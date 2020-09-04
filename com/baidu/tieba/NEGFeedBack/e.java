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
    private TextView btp;
    private int flK;
    private PopupWindow flO;
    private com.baidu.tieba.NEGFeedBack.b flR;
    private boolean flS;
    private LinearLayout fmc;
    private a fmd;
    private b fme;
    private TextView fmf;
    private TextView fmg;
    private TextView fmh;
    private View fmi;
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
    private ar flI = null;
    private SparseArray<String> flv = null;
    private List<b.a> flJ = new ArrayList();
    private NEGFeedBackView.a flN = null;
    private int mSkinType = 3;
    private com.baidu.tbadk.core.view.a eUz = null;
    private CompoundButton.OnCheckedChangeListener flz = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.NEGFeedBack.e.1
        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (e.this.flN != null) {
                e.this.flN.onCheckedChanged(e.this.flI, compoundButton, z);
            }
            if (compoundButton.getTag() instanceof b.a) {
                b.a aVar = (b.a) compoundButton.getTag();
                if (z) {
                    if (!e.this.flJ.contains(aVar)) {
                        e.this.flJ.add(aVar);
                        return;
                    }
                    return;
                }
                e.this.flJ.remove(aVar);
            }
        }
    };
    private PopupWindow.OnDismissListener flX = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.NEGFeedBack.e.2
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (e.this.flO != null) {
                e.this.flO.dismiss();
                e.this.flO = null;
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
        this.flR = new com.baidu.tieba.NEGFeedBack.b(this.mPageContext);
        this.flR.a(this.flz);
        this.flR.kj(true);
    }

    private int getWindowMeasuredHeight() {
        if (this.mContentView == null) {
            return 0;
        }
        this.mContentView.measure(0, 0);
        this.flK = this.mContentView.getMeasuredHeight() + l.getDimens(this.mContext, R.dimen.ds12);
        return this.flK;
    }

    public void setData(ar arVar) {
        if (arVar != null) {
            this.flI = arVar;
            this.flv = arVar.getFeedBackReasonMap();
            if (this.flv != null && this.flv.size() > 8) {
                for (int size = this.flv.size() - 1; size >= 8; size--) {
                    this.flv.removeAt(size);
                }
            }
            this.flR.setData(arVar);
        }
    }

    public void setDefaultReasonArray(String[] strArr) {
        this.flR.setDefaultReasonArray(strArr);
    }

    public void bAj() {
        if (this.mPopupWindow != null) {
            this.mPopupWindow.dismiss();
            this.mPopupWindow = null;
        }
        if (this.flO != null) {
            this.flO.dismiss();
            this.flO = null;
        }
    }

    private void resetState() {
        if (this.flS && this.flJ.size() != 0) {
            this.flJ.clear();
        }
    }

    private void bkF() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            ap.setBackgroundColor(this.mContentView, R.color.cp_bg_line_f);
            ap.setViewTextColor(this.btp, R.color.cp_cont_f, 1);
            ap.setViewTextColor(this.fmf, R.color.cp_cont_f, 1);
            ap.setBackgroundColor(this.mTopLine, R.color.cp_bg_line_c);
            ap.setBackgroundColor(this.fmi, R.color.cp_bg_line_c);
            ap.setViewTextColor(this.fmg, R.color.cp_cont_f, 1);
            ap.setViewTextColor(this.fmh, R.color.cp_cont_d, 1);
            this.mSkinType = skinType;
        }
    }

    private View getView() {
        if (this.mContext == null) {
            return null;
        }
        if (this.mContentView == null) {
            this.mContentView = (ViewGroup) LayoutInflater.from(this.mContext).inflate(R.layout.neg_dt_head_popupwindow, (ViewGroup) null);
            this.fmg = (TextView) this.mContentView.findViewById(R.id.head_text);
            this.fmh = (TextView) this.mContentView.findViewById(R.id.sub_head_text);
        }
        View rootView = this.flR.getRootView();
        if (rootView != null && rootView.getParent() == null) {
            int dimens = l.getDimens(this.mContext, R.dimen.ds40);
            rootView.setPadding(dimens, 0, dimens, 0);
            this.mContentView.addView(rootView);
        }
        if (this.fmc == null) {
            this.fmc = (LinearLayout) LayoutInflater.from(this.mContext).inflate(R.layout.neg_dt_bottom_popupwindow, (ViewGroup) null);
            this.btp = (TextView) this.fmc.findViewById(R.id.dialog_bottom_cancel_button);
            this.fmf = (TextView) this.fmc.findViewById(R.id.dialog_bottom_certain_button);
            this.mTopLine = this.fmc.findViewById(R.id.top_line);
            this.fmi = this.fmc.findViewById(R.id.middle_line);
            this.mContentView.addView(this.fmc);
            this.btp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.NEGFeedBack.e.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (e.this.flO != null) {
                        e.this.flO.dismiss();
                        e.this.flO = null;
                    }
                    if (e.this.mPopupWindow != null) {
                        e.this.mPopupWindow.dismiss();
                        e.this.mPopupWindow = null;
                    }
                    if (e.this.fmd != null) {
                        e.this.fmd.onClick();
                    }
                }
            });
            if (this.fmf != null) {
                this.fmf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.NEGFeedBack.e.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        JSONObject bAn = e.this.bAn();
                        if (e.this.mFrom == "3" || e.this.mFrom == "4" || e.this.mFrom == "1") {
                            e.this.bAj();
                        } else if (bAn != null) {
                            e.this.showLoadingView();
                            CustomMessage customMessage = new CustomMessage(2016489, e.this.mPageContext.getUniqueId());
                            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2016489, bAn);
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
        this.fme = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLoadingView() {
        if (this.eUz == null) {
            this.eUz = new com.baidu.tbadk.core.view.a(this.mPageContext);
        }
        this.eUz.setTipString(R.string.loading);
        this.eUz.setDialogVisiable(true);
    }

    public void bAm() {
        if (this.eUz != null) {
            this.eUz.setDialogVisiable(false);
        }
    }

    public void Df(String str) {
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
            this.mPopupWindow.setOnDismissListener(this.flX);
            resetState();
            this.flO = new PopupWindow(LayoutInflater.from(this.mContext).inflate(R.layout.view_negative_feedback_bottom, (ViewGroup) null), -1, -1);
            if (Build.VERSION.SDK_INT >= 22) {
                this.flO.setAttachedInDecor(false);
            }
            this.flO.showAtLocation(this.mAnchor, 0, 0, 0);
            ap.setBackgroundDrawable(this.mPopupWindow, R.drawable.bg_dailog);
            this.mPopupWindow.showAtLocation(this.mAnchor, 17, 0, 0);
            if (this.flN != null) {
                this.flN.onNEGFeedbackWindowShow(this.flI);
            }
            this.flS = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject bAn() {
        int i;
        JSONObject jSONObject = new JSONObject();
        if (this.flI == null) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        if (y.isEmpty(this.flJ)) {
            i = 0;
        } else {
            i = 0;
            for (int i2 = 0; i2 < this.flJ.size(); i2++) {
                b.a aVar = this.flJ.get(i2);
                if (aVar != null) {
                    jSONArray.put(String.valueOf(aVar.id));
                    i = aVar.index + 1;
                }
            }
        }
        TiebaStatic.log(new aq("c13123").dD("obj_source", this.mFrom).ai("obj_type", i));
        if (this.fme != null) {
            this.fme.W(jSONArray);
        }
        try {
            jSONObject.put(TiebaInitialize.LogFields.REASON, jSONArray);
            jSONObject.put("thread_ids", this.flI.bdc());
            jSONObject.put("type", this.flI.bdb());
            jSONObject.put("forum_id", this.flI.getFid());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
