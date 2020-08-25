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
import com.baidu.tbadk.core.data.ar;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.NEGFeedBack.b;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes15.dex */
public class e {
    private TextView btl;
    private int flG;
    private PopupWindow flK;
    private com.baidu.tieba.NEGFeedBack.b flN;
    private boolean flO;
    private LinearLayout flY;
    private a flZ;
    private b fma;
    private TextView fmb;
    private TextView fmc;
    private TextView fmd;
    private View fme;
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
    private ar flE = null;
    private SparseArray<String> flr = null;
    private List<b.a> flF = new ArrayList();
    private NEGFeedBackView.a flJ = null;
    private int mSkinType = 3;
    private com.baidu.tbadk.core.view.a eUv = null;
    private CompoundButton.OnCheckedChangeListener flv = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.NEGFeedBack.e.1
        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (e.this.flJ != null) {
                e.this.flJ.onCheckedChanged(e.this.flE, compoundButton, z);
            }
            if (compoundButton.getTag() instanceof b.a) {
                b.a aVar = (b.a) compoundButton.getTag();
                if (z) {
                    if (!e.this.flF.contains(aVar)) {
                        e.this.flF.add(aVar);
                        return;
                    }
                    return;
                }
                e.this.flF.remove(aVar);
            }
        }
    };
    private PopupWindow.OnDismissListener flT = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.NEGFeedBack.e.2
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (e.this.flK != null) {
                e.this.flK.dismiss();
                e.this.flK = null;
            }
        }
    };

    /* loaded from: classes15.dex */
    public interface a {
        void onClick();
    }

    /* loaded from: classes15.dex */
    public interface b {
        void W(JSONArray jSONArray);
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
        this.flN = new com.baidu.tieba.NEGFeedBack.b(this.mPageContext);
        this.flN.a(this.flv);
        this.flN.kh(true);
    }

    private int getWindowMeasuredHeight() {
        if (this.mContentView == null) {
            return 0;
        }
        this.mContentView.measure(0, 0);
        this.flG = this.mContentView.getMeasuredHeight() + l.getDimens(this.mContext, R.dimen.ds12);
        return this.flG;
    }

    public void setData(ar arVar) {
        if (arVar != null) {
            this.flE = arVar;
            this.flr = arVar.getFeedBackReasonMap();
            if (this.flr != null && this.flr.size() > 8) {
                for (int size = this.flr.size() - 1; size >= 8; size--) {
                    this.flr.removeAt(size);
                }
            }
            this.flN.setData(arVar);
        }
    }

    public void setDefaultReasonArray(String[] strArr) {
        this.flN.setDefaultReasonArray(strArr);
    }

    public void bAi() {
        if (this.mPopupWindow != null) {
            this.mPopupWindow.dismiss();
            this.mPopupWindow = null;
        }
        if (this.flK != null) {
            this.flK.dismiss();
            this.flK = null;
        }
    }

    private void resetState() {
        if (this.flO && this.flF.size() != 0) {
            this.flF.clear();
        }
    }

    private void bkF() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            ap.setBackgroundColor(this.mContentView, R.color.cp_bg_line_f);
            ap.setViewTextColor(this.btl, R.color.cp_cont_f, 1);
            ap.setViewTextColor(this.fmb, R.color.cp_cont_f, 1);
            ap.setBackgroundColor(this.mTopLine, R.color.cp_bg_line_c);
            ap.setBackgroundColor(this.fme, R.color.cp_bg_line_c);
            ap.setViewTextColor(this.fmc, R.color.cp_cont_f, 1);
            ap.setViewTextColor(this.fmd, R.color.cp_cont_d, 1);
            this.mSkinType = skinType;
        }
    }

    private View getView() {
        if (this.mContext == null) {
            return null;
        }
        if (this.mContentView == null) {
            this.mContentView = (ViewGroup) LayoutInflater.from(this.mContext).inflate(R.layout.neg_dt_head_popupwindow, (ViewGroup) null);
            this.fmc = (TextView) this.mContentView.findViewById(R.id.head_text);
            this.fmd = (TextView) this.mContentView.findViewById(R.id.sub_head_text);
        }
        View rootView = this.flN.getRootView();
        if (rootView != null && rootView.getParent() == null) {
            int dimens = l.getDimens(this.mContext, R.dimen.ds40);
            rootView.setPadding(dimens, 0, dimens, 0);
            this.mContentView.addView(rootView);
        }
        if (this.flY == null) {
            this.flY = (LinearLayout) LayoutInflater.from(this.mContext).inflate(R.layout.neg_dt_bottom_popupwindow, (ViewGroup) null);
            this.btl = (TextView) this.flY.findViewById(R.id.dialog_bottom_cancel_button);
            this.fmb = (TextView) this.flY.findViewById(R.id.dialog_bottom_certain_button);
            this.mTopLine = this.flY.findViewById(R.id.top_line);
            this.fme = this.flY.findViewById(R.id.middle_line);
            this.mContentView.addView(this.flY);
            this.btl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.NEGFeedBack.e.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (e.this.flK != null) {
                        e.this.flK.dismiss();
                        e.this.flK = null;
                    }
                    if (e.this.mPopupWindow != null) {
                        e.this.mPopupWindow.dismiss();
                        e.this.mPopupWindow = null;
                    }
                    if (e.this.flZ != null) {
                        e.this.flZ.onClick();
                    }
                }
            });
            if (this.fmb != null) {
                this.fmb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.NEGFeedBack.e.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        JSONObject bAm = e.this.bAm();
                        if (e.this.mFrom == "3" || e.this.mFrom == "4" || e.this.mFrom == "1") {
                            e.this.bAi();
                        } else if (bAm != null) {
                            e.this.showLoadingView();
                            CustomMessage customMessage = new CustomMessage(2016489, e.this.mPageContext.getUniqueId());
                            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2016489, bAm);
                            customResponsedMessage.setOrginalMessage(customMessage);
                            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                        }
                    }
                });
            }
            bkF();
        }
        return this.mContentView;
    }

    public void a(b bVar) {
        this.fma = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLoadingView() {
        if (this.eUv == null) {
            this.eUv = new com.baidu.tbadk.core.view.a(this.mPageContext);
        }
        this.eUv.setTipString(R.string.loading);
        this.eUv.setDialogVisiable(true);
    }

    public void bAl() {
        if (this.eUv != null) {
            this.eUv.setDialogVisiable(false);
        }
    }

    public void De(String str) {
        if (this.mContext != null) {
            this.mFrom = str;
            View view = getView();
            if (view != null && view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            bkF();
            this.mWindowHeight = getWindowMeasuredHeight() - l.getDimens(this.mContext, R.dimen.ds12);
            this.mPopupWindow = new PopupWindow(view, this.mWindowWidth, this.mWindowHeight);
            this.mPopupWindow.setFocusable(true);
            this.mPopupWindow.setTouchable(true);
            this.mPopupWindow.setOnDismissListener(this.flT);
            resetState();
            this.flK = new PopupWindow(LayoutInflater.from(this.mContext).inflate(R.layout.view_negative_feedback_bottom, (ViewGroup) null), -1, -1);
            if (Build.VERSION.SDK_INT >= 22) {
                this.flK.setAttachedInDecor(false);
            }
            this.flK.showAtLocation(this.mAnchor, 0, 0, 0);
            ap.setBackgroundDrawable(this.mPopupWindow, R.drawable.bg_dailog);
            this.mPopupWindow.showAtLocation(this.mAnchor, 17, 0, 0);
            if (this.flJ != null) {
                this.flJ.onNEGFeedbackWindowShow(this.flE);
            }
            this.flO = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject bAm() {
        int i;
        JSONObject jSONObject = new JSONObject();
        if (this.flE == null) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        if (y.isEmpty(this.flF)) {
            i = 0;
        } else {
            i = 0;
            for (int i2 = 0; i2 < this.flF.size(); i2++) {
                b.a aVar = this.flF.get(i2);
                if (aVar != null) {
                    jSONArray.put(String.valueOf(aVar.id));
                    i = aVar.index + 1;
                }
            }
        }
        TiebaStatic.log(new aq("c13123").dD("obj_source", this.mFrom).ai("obj_type", i));
        if (this.fma != null) {
            this.fma.W(jSONArray);
        }
        try {
            jSONObject.put(TiebaInitialize.LogFields.REASON, jSONArray);
            jSONObject.put("thread_ids", this.flE.bdc());
            jSONObject.put("type", this.flE.bdb());
            jSONObject.put("forum_id", this.flE.getFid());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
