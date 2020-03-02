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
import com.baidu.tbadk.core.data.al;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.NEGFeedBack.b;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class e {
    private TextView aEI;
    private LinearLayout dUF;
    private a dUG;
    private b dUH;
    private TextView dUI;
    private TextView dUJ;
    private TextView dUK;
    private View dUL;
    private int dUm;
    private int dUn;
    private PopupWindow dUr;
    private com.baidu.tieba.NEGFeedBack.b dUu;
    private boolean dUv;
    private View mAnchor;
    private ViewGroup mContentView;
    private Context mContext;
    private String mFrom;
    private TbPageContext mPageContext;
    private View mTopLine;
    private int mWindowHeight;
    private int mXOffset;
    private PopupWindow mPopupWindow = null;
    private al dUk = null;
    private SparseArray<String> dTY = null;
    private List<b.a> dUl = new ArrayList();
    private NEGFeedBackView.a dUq = null;
    private int mSkinType = 3;
    private com.baidu.tbadk.core.view.a dFT = null;
    private CompoundButton.OnCheckedChangeListener dUb = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.NEGFeedBack.e.1
        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (e.this.dUq != null) {
                e.this.dUq.a(e.this.dUk, compoundButton, z);
            }
            if (compoundButton.getTag() instanceof b.a) {
                b.a aVar = (b.a) compoundButton.getTag();
                if (z) {
                    if (!e.this.dUl.contains(aVar)) {
                        e.this.dUl.add(aVar);
                        return;
                    }
                    return;
                }
                e.this.dUl.remove(aVar);
            }
        }
    };
    private PopupWindow.OnDismissListener dUA = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.NEGFeedBack.e.2
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (e.this.dUr != null) {
                e.this.dUr.dismiss();
                e.this.dUr = null;
            }
        }
    };

    /* loaded from: classes8.dex */
    public interface a {
        void onClick();
    }

    /* loaded from: classes8.dex */
    public interface b {
        void S(JSONArray jSONArray);
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
        this.dUm = l.getEquipmentWidth(this.mContext) - (this.mXOffset * 2);
        this.dUu = new com.baidu.tieba.NEGFeedBack.b(this.mPageContext);
        this.dUu.a(this.dUb);
        this.dUu.hw(true);
    }

    private int getWindowMeasuredHeight() {
        if (this.mContentView == null) {
            return 0;
        }
        this.mContentView.measure(0, 0);
        this.dUn = this.mContentView.getMeasuredHeight() + l.getDimens(this.mContext, R.dimen.ds12);
        return this.dUn;
    }

    public void setData(al alVar) {
        if (alVar != null) {
            this.dUk = alVar;
            this.dTY = alVar.getFeedBackReasonMap();
            if (this.dTY != null && this.dTY.size() > 8) {
                for (int size = this.dTY.size() - 1; size >= 8; size--) {
                    this.dTY.removeAt(size);
                }
            }
            this.dUu.setData(alVar);
        }
    }

    public void setDefaultReasonArray(String[] strArr) {
        this.dUu.setDefaultReasonArray(strArr);
    }

    public void aWn() {
        if (this.mPopupWindow != null) {
            this.mPopupWindow.dismiss();
            this.mPopupWindow = null;
        }
        if (this.dUr != null) {
            this.dUr.dismiss();
            this.dUr = null;
        }
    }

    private void resetState() {
        if (this.dUv && this.dUl.size() != 0) {
            this.dUl.clear();
        }
    }

    private void aHN() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            am.setViewTextColor(this.aEI, R.color.cp_cont_f, 1);
            am.setViewTextColor(this.dUI, R.color.cp_cont_f, 1);
            am.setBackgroundColor(this.mTopLine, R.color.cp_bg_line_c);
            am.setBackgroundColor(this.dUL, R.color.cp_bg_line_c);
            am.setViewTextColor(this.dUJ, R.color.cp_cont_f, 1);
            am.setViewTextColor(this.dUK, R.color.cp_cont_d, 1);
            this.mSkinType = skinType;
        }
    }

    private View getView() {
        if (this.mContext == null) {
            return null;
        }
        if (this.mContentView == null) {
            this.mContentView = (ViewGroup) LayoutInflater.from(this.mContext).inflate(R.layout.neg_dt_head_popupwindow, (ViewGroup) null);
            this.dUJ = (TextView) this.mContentView.findViewById(R.id.head_text);
            this.dUK = (TextView) this.mContentView.findViewById(R.id.sub_head_text);
        }
        View rootView = this.dUu.getRootView();
        if (rootView != null && rootView.getParent() == null) {
            int dimens = l.getDimens(this.mContext, R.dimen.ds40);
            rootView.setPadding(dimens, 0, dimens, 0);
            this.mContentView.addView(rootView);
        }
        if (this.dUF == null) {
            this.dUF = (LinearLayout) LayoutInflater.from(this.mContext).inflate(R.layout.neg_dt_bottom_popupwindow, (ViewGroup) null);
            this.aEI = (TextView) this.dUF.findViewById(R.id.dialog_bottom_cancel_button);
            this.dUI = (TextView) this.dUF.findViewById(R.id.dialog_bottom_certain_button);
            this.mTopLine = this.dUF.findViewById(R.id.top_line);
            this.dUL = this.dUF.findViewById(R.id.middle_line);
            this.mContentView.addView(this.dUF);
            this.aEI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.NEGFeedBack.e.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (e.this.dUr != null) {
                        e.this.dUr.dismiss();
                        e.this.dUr = null;
                    }
                    if (e.this.mPopupWindow != null) {
                        e.this.mPopupWindow.dismiss();
                        e.this.mPopupWindow = null;
                    }
                    if (e.this.dUG != null) {
                        e.this.dUG.onClick();
                    }
                }
            });
            if (this.dUI != null) {
                this.dUI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.NEGFeedBack.e.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        JSONObject aWr = e.this.aWr();
                        if (e.this.mFrom == "3" || e.this.mFrom == "4" || e.this.mFrom == "1") {
                            e.this.aWn();
                        } else if (aWr != null) {
                            e.this.showLoadingView();
                            CustomMessage customMessage = new CustomMessage(2016489, e.this.mPageContext.getUniqueId());
                            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2016489, aWr);
                            customResponsedMessage.setOrginalMessage(customMessage);
                            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                        }
                    }
                });
            }
            aHN();
        }
        return this.mContentView;
    }

    public void a(b bVar) {
        this.dUH = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLoadingView() {
        if (this.dFT == null) {
            this.dFT = new com.baidu.tbadk.core.view.a(this.mPageContext);
        }
        this.dFT.setTipString(R.string.loading);
        this.dFT.setDialogVisiable(true);
    }

    public void aWq() {
        if (this.dFT != null) {
            this.dFT.setDialogVisiable(false);
        }
    }

    public void wm(String str) {
        if (this.mContext != null) {
            this.mFrom = str;
            View view = getView();
            if (view != null && view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            aHN();
            this.mWindowHeight = getWindowMeasuredHeight() - l.getDimens(this.mContext, R.dimen.ds12);
            this.mPopupWindow = new PopupWindow(view, this.dUm, this.mWindowHeight);
            this.mPopupWindow.setFocusable(true);
            this.mPopupWindow.setTouchable(true);
            this.mPopupWindow.setOnDismissListener(this.dUA);
            resetState();
            this.dUr = new PopupWindow(LayoutInflater.from(this.mContext).inflate(R.layout.view_negative_feedback_bottom, (ViewGroup) null), -1, -1);
            if (Build.VERSION.SDK_INT >= 22) {
                this.dUr.setAttachedInDecor(false);
            }
            this.dUr.showAtLocation(this.mAnchor, 0, 0, 0);
            am.setBackgroundDrawable(this.mPopupWindow, R.drawable.bg_dailog);
            this.mPopupWindow.showAtLocation(this.mAnchor, 17, 0, 0);
            if (this.dUq != null) {
                this.dUq.b(this.dUk);
            }
            this.dUv = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject aWr() {
        int i;
        JSONObject jSONObject = new JSONObject();
        if (this.dUk == null) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        if (v.isEmpty(this.dUl)) {
            i = 0;
        } else {
            i = 0;
            for (int i2 = 0; i2 < this.dUl.size(); i2++) {
                b.a aVar = this.dUl.get(i2);
                if (aVar != null) {
                    jSONArray.put(String.valueOf(aVar.id));
                    i = aVar.index + 1;
                }
            }
        }
        TiebaStatic.log(new an("c13123").cy("obj_source", this.mFrom).X("obj_type", i));
        if (this.dUH != null) {
            this.dUH.S(jSONArray);
        }
        try {
            jSONObject.put(TiebaInitialize.LogFields.REASON, jSONArray);
            jSONObject.put("thread_ids", this.dUk.aAT());
            jSONObject.put("type", this.dUk.aAS());
            jSONObject.put("forum_id", this.dUk.getFid());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
