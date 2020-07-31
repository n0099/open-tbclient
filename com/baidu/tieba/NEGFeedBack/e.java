package com.baidu.tieba.NEGFeedBack;

import android.content.Context;
import android.os.Build;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.aq;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.NEGFeedBack.b;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes15.dex */
public class e {
    private TextView bnI;
    private LinearLayout faG;
    private a faH;
    private b faI;
    private TextView faJ;
    private TextView faK;
    private TextView faL;
    private View faM;
    private int fao;
    private PopupWindow fas;
    private com.baidu.tieba.NEGFeedBack.b fav;
    private boolean faw;
    private View mAnchor;
    private ViewGroup mContentView;
    private Context mContext;
    private String mFrom;
    private TbPageContext mPageContext;
    private View mTopLine;
    private int mWindowHeight;
    private int mWindowWidth;
    private int mXOffset;
    private PopupWindow mPopupWindow = null;
    private aq fam = null;
    private SparseArray<String> eZZ = null;
    private List<b.a> fan = new ArrayList();
    private NEGFeedBackView.a far = null;
    private int mSkinType = 3;
    private com.baidu.tbadk.core.view.a eJP = null;
    private CompoundButton.OnCheckedChangeListener fad = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.NEGFeedBack.e.1
        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (e.this.far != null) {
                e.this.far.a(e.this.fam, compoundButton, z);
            }
            if (compoundButton.getTag() instanceof b.a) {
                b.a aVar = (b.a) compoundButton.getTag();
                if (z) {
                    if (!e.this.fan.contains(aVar)) {
                        e.this.fan.add(aVar);
                        return;
                    }
                    return;
                }
                e.this.fan.remove(aVar);
            }
        }
    };
    private PopupWindow.OnDismissListener faB = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.NEGFeedBack.e.2
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (e.this.fas != null) {
                e.this.fas.dismiss();
                e.this.fas = null;
            }
        }
    };

    /* loaded from: classes15.dex */
    public interface a {
        void onClick();
    }

    /* loaded from: classes15.dex */
    public interface b {
        void U(JSONArray jSONArray);
    }

    public e(TbPageContext tbPageContext, View view) {
        this.mContext = null;
        this.mContext = tbPageContext.getPageActivity();
        this.mPageContext = tbPageContext;
        this.mAnchor = view;
        init();
    }

    private void init() {
        this.mXOffset = l.getDimens(this.mContext, R.dimen.tbds32);
        this.mWindowWidth = l.getEquipmentWidth(this.mContext) - (this.mXOffset * 2);
        this.fav = new com.baidu.tieba.NEGFeedBack.b(this.mPageContext);
        this.fav.a(this.fad);
        this.fav.jJ(true);
    }

    private int getWindowMeasuredHeight() {
        if (this.mContentView == null) {
            return 0;
        }
        this.mContentView.measure(0, 0);
        this.fao = this.mContentView.getMeasuredHeight() + l.getDimens(this.mContext, R.dimen.ds12);
        return this.fao;
    }

    public void setData(aq aqVar) {
        if (aqVar != null) {
            this.fam = aqVar;
            this.eZZ = aqVar.getFeedBackReasonMap();
            if (this.eZZ != null && this.eZZ.size() > 8) {
                for (int size = this.eZZ.size() - 1; size >= 8; size--) {
                    this.eZZ.removeAt(size);
                }
            }
            this.fav.setData(aqVar);
        }
    }

    public void setDefaultReasonArray(String[] strArr) {
        this.fav.setDefaultReasonArray(strArr);
    }

    public void brl() {
        if (this.mPopupWindow != null) {
            this.mPopupWindow.dismiss();
            this.mPopupWindow = null;
        }
        if (this.fas != null) {
            this.fas.dismiss();
            this.fas = null;
        }
    }

    private void resetState() {
        if (this.faw && this.fan.size() != 0) {
            this.fan.clear();
        }
    }

    private void bci() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            ao.setBackgroundColor(this.mContentView, R.color.cp_bg_line_f);
            ao.setViewTextColor(this.bnI, R.color.cp_cont_f, 1);
            ao.setViewTextColor(this.faJ, R.color.cp_cont_f, 1);
            ao.setBackgroundColor(this.mTopLine, R.color.cp_bg_line_c);
            ao.setBackgroundColor(this.faM, R.color.cp_bg_line_c);
            ao.setViewTextColor(this.faK, R.color.cp_cont_f, 1);
            ao.setViewTextColor(this.faL, R.color.cp_cont_d, 1);
            this.mSkinType = skinType;
        }
    }

    private View getView() {
        if (this.mContext == null) {
            return null;
        }
        if (this.mContentView == null) {
            this.mContentView = (ViewGroup) LayoutInflater.from(this.mContext).inflate(R.layout.neg_dt_head_popupwindow, (ViewGroup) null);
            this.faK = (TextView) this.mContentView.findViewById(R.id.head_text);
            this.faL = (TextView) this.mContentView.findViewById(R.id.sub_head_text);
        }
        View rootView = this.fav.getRootView();
        if (rootView != null && rootView.getParent() == null) {
            int dimens = l.getDimens(this.mContext, R.dimen.ds40);
            rootView.setPadding(dimens, 0, dimens, 0);
            this.mContentView.addView(rootView);
        }
        if (this.faG == null) {
            this.faG = (LinearLayout) LayoutInflater.from(this.mContext).inflate(R.layout.neg_dt_bottom_popupwindow, (ViewGroup) null);
            this.bnI = (TextView) this.faG.findViewById(R.id.dialog_bottom_cancel_button);
            this.faJ = (TextView) this.faG.findViewById(R.id.dialog_bottom_certain_button);
            this.mTopLine = this.faG.findViewById(R.id.top_line);
            this.faM = this.faG.findViewById(R.id.middle_line);
            this.mContentView.addView(this.faG);
            this.bnI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.NEGFeedBack.e.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (e.this.fas != null) {
                        e.this.fas.dismiss();
                        e.this.fas = null;
                    }
                    if (e.this.mPopupWindow != null) {
                        e.this.mPopupWindow.dismiss();
                        e.this.mPopupWindow = null;
                    }
                    if (e.this.faH != null) {
                        e.this.faH.onClick();
                    }
                }
            });
            if (this.faJ != null) {
                this.faJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.NEGFeedBack.e.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        JSONObject brp = e.this.brp();
                        if (e.this.mFrom == "3" || e.this.mFrom == "4" || e.this.mFrom == "1") {
                            e.this.brl();
                        } else if (brp != null) {
                            e.this.showLoadingView();
                            CustomMessage customMessage = new CustomMessage(2016489, e.this.mPageContext.getUniqueId());
                            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2016489, brp);
                            customResponsedMessage.setOrginalMessage(customMessage);
                            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                        }
                    }
                });
            }
            bci();
        }
        return this.mContentView;
    }

    public void a(b bVar) {
        this.faI = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLoadingView() {
        if (this.eJP == null) {
            this.eJP = new com.baidu.tbadk.core.view.a(this.mPageContext);
        }
        this.eJP.setTipString(R.string.loading);
        this.eJP.setDialogVisiable(true);
    }

    public void bro() {
        if (this.eJP != null) {
            this.eJP.setDialogVisiable(false);
        }
    }

    public void AK(String str) {
        if (this.mContext != null) {
            this.mFrom = str;
            View view = getView();
            if (view != null && view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            bci();
            this.mWindowHeight = getWindowMeasuredHeight() - l.getDimens(this.mContext, R.dimen.ds12);
            this.mPopupWindow = new PopupWindow(view, this.mWindowWidth, this.mWindowHeight);
            this.mPopupWindow.setFocusable(true);
            this.mPopupWindow.setTouchable(true);
            this.mPopupWindow.setOnDismissListener(this.faB);
            resetState();
            this.fas = new PopupWindow(LayoutInflater.from(this.mContext).inflate(R.layout.view_negative_feedback_bottom, (ViewGroup) null), -1, -1);
            if (Build.VERSION.SDK_INT >= 22) {
                this.fas.setAttachedInDecor(false);
            }
            this.fas.showAtLocation(this.mAnchor, 0, 0, 0);
            ao.setBackgroundDrawable(this.mPopupWindow, R.drawable.bg_dailog);
            this.mPopupWindow.showAtLocation(this.mAnchor, 17, 0, 0);
            if (this.far != null) {
                this.far.b(this.fam);
            }
            this.faw = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject brp() {
        int i;
        JSONObject jSONObject = new JSONObject();
        if (this.fam == null) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        if (x.isEmpty(this.fan)) {
            i = 0;
        } else {
            i = 0;
            for (int i2 = 0; i2 < this.fan.size(); i2++) {
                b.a aVar = this.fan.get(i2);
                if (aVar != null) {
                    jSONArray.put(String.valueOf(aVar.id));
                    i = aVar.index + 1;
                }
            }
        }
        TiebaStatic.log(new ap("c13123").dn("obj_source", this.mFrom).ah("obj_type", i));
        if (this.faI != null) {
            this.faI.U(jSONArray);
        }
        try {
            jSONObject.put(TiebaInitialize.LogFields.REASON, jSONArray);
            jSONObject.put("thread_ids", this.fam.aUJ());
            jSONObject.put("type", this.fam.aUI());
            jSONObject.put("forum_id", this.fam.getFid());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
