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
/* loaded from: classes5.dex */
public class e {
    private TextView azH;
    private int dPW;
    private int dPX;
    private PopupWindow dQb;
    private com.baidu.tieba.NEGFeedBack.b dQe;
    private boolean dQf;
    private LinearLayout dQp;
    private a dQq;
    private b dQr;
    private TextView dQs;
    private TextView dQt;
    private TextView dQu;
    private View dQv;
    private View mAnchor;
    private ViewGroup mContentView;
    private Context mContext;
    private String mFrom;
    private TbPageContext mPageContext;
    private View mTopLine;
    private int mWindowHeight;
    private int mXOffset;
    private PopupWindow mPopupWindow = null;
    private al dPU = null;
    private SparseArray<String> dPI = null;
    private List<b.a> dPV = new ArrayList();
    private NEGFeedBackView.a dQa = null;
    private int mSkinType = 3;
    private com.baidu.tbadk.core.view.a dBH = null;
    private CompoundButton.OnCheckedChangeListener dPL = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.NEGFeedBack.e.1
        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (e.this.dQa != null) {
                e.this.dQa.a(e.this.dPU, compoundButton, z);
            }
            if (compoundButton.getTag() instanceof b.a) {
                b.a aVar = (b.a) compoundButton.getTag();
                if (z) {
                    if (!e.this.dPV.contains(aVar)) {
                        e.this.dPV.add(aVar);
                        return;
                    }
                    return;
                }
                e.this.dPV.remove(aVar);
            }
        }
    };
    private PopupWindow.OnDismissListener dQk = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.NEGFeedBack.e.2
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (e.this.dQb != null) {
                e.this.dQb.dismiss();
                e.this.dQb = null;
            }
        }
    };

    /* loaded from: classes5.dex */
    public interface a {
        void onClick();
    }

    /* loaded from: classes5.dex */
    public interface b {
        void R(JSONArray jSONArray);
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
        this.dPW = l.getEquipmentWidth(this.mContext) - (this.mXOffset * 2);
        this.dQe = new com.baidu.tieba.NEGFeedBack.b(this.mPageContext);
        this.dQe.a(this.dPL);
        this.dQe.hk(true);
    }

    private int getWindowMeasuredHeight() {
        if (this.mContentView == null) {
            return 0;
        }
        this.mContentView.measure(0, 0);
        this.dPX = this.mContentView.getMeasuredHeight() + l.getDimens(this.mContext, R.dimen.ds12);
        return this.dPX;
    }

    public void setData(al alVar) {
        if (alVar != null) {
            this.dPU = alVar;
            this.dPI = alVar.getFeedBackReasonMap();
            if (this.dPI != null && this.dPI.size() > 8) {
                for (int size = this.dPI.size() - 1; size >= 8; size--) {
                    this.dPI.removeAt(size);
                }
            }
            this.dQe.setData(alVar);
        }
    }

    public void setDefaultReasonArray(String[] strArr) {
        this.dQe.setDefaultReasonArray(strArr);
    }

    public void aTB() {
        if (this.mPopupWindow != null) {
            this.mPopupWindow.dismiss();
            this.mPopupWindow = null;
        }
        if (this.dQb != null) {
            this.dQb.dismiss();
            this.dQb = null;
        }
    }

    private void resetState() {
        if (this.dQf && this.dPV.size() != 0) {
            this.dPV.clear();
        }
    }

    private void aFd() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            am.setViewTextColor(this.azH, R.color.cp_cont_f, 1);
            am.setViewTextColor(this.dQs, R.color.cp_cont_f, 1);
            am.setBackgroundColor(this.mTopLine, R.color.cp_bg_line_c);
            am.setBackgroundColor(this.dQv, R.color.cp_bg_line_c);
            am.setViewTextColor(this.dQt, R.color.cp_cont_f, 1);
            am.setViewTextColor(this.dQu, R.color.cp_cont_d, 1);
            this.mSkinType = skinType;
        }
    }

    private View getView() {
        if (this.mContext == null) {
            return null;
        }
        if (this.mContentView == null) {
            this.mContentView = (ViewGroup) LayoutInflater.from(this.mContext).inflate(R.layout.neg_dt_head_popupwindow, (ViewGroup) null);
            this.dQt = (TextView) this.mContentView.findViewById(R.id.head_text);
            this.dQu = (TextView) this.mContentView.findViewById(R.id.sub_head_text);
        }
        View rootView = this.dQe.getRootView();
        if (rootView != null && rootView.getParent() == null) {
            int dimens = l.getDimens(this.mContext, R.dimen.ds40);
            rootView.setPadding(dimens, 0, dimens, 0);
            this.mContentView.addView(rootView);
        }
        if (this.dQp == null) {
            this.dQp = (LinearLayout) LayoutInflater.from(this.mContext).inflate(R.layout.neg_dt_bottom_popupwindow, (ViewGroup) null);
            this.azH = (TextView) this.dQp.findViewById(R.id.dialog_bottom_cancel_button);
            this.dQs = (TextView) this.dQp.findViewById(R.id.dialog_bottom_certain_button);
            this.mTopLine = this.dQp.findViewById(R.id.top_line);
            this.dQv = this.dQp.findViewById(R.id.middle_line);
            this.mContentView.addView(this.dQp);
            this.azH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.NEGFeedBack.e.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (e.this.dQb != null) {
                        e.this.dQb.dismiss();
                        e.this.dQb = null;
                    }
                    if (e.this.mPopupWindow != null) {
                        e.this.mPopupWindow.dismiss();
                        e.this.mPopupWindow = null;
                    }
                    if (e.this.dQq != null) {
                        e.this.dQq.onClick();
                    }
                }
            });
            if (this.dQs != null) {
                this.dQs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.NEGFeedBack.e.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        JSONObject aTF = e.this.aTF();
                        if (e.this.mFrom == "3" || e.this.mFrom == "4" || e.this.mFrom == "1") {
                            e.this.aTB();
                        } else if (aTF != null) {
                            e.this.showLoadingView();
                            CustomMessage customMessage = new CustomMessage(2016489, e.this.mPageContext.getUniqueId());
                            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2016489, aTF);
                            customResponsedMessage.setOrginalMessage(customMessage);
                            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                        }
                    }
                });
            }
            aFd();
        }
        return this.mContentView;
    }

    public void a(b bVar) {
        this.dQr = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLoadingView() {
        if (this.dBH == null) {
            this.dBH = new com.baidu.tbadk.core.view.a(this.mPageContext);
        }
        this.dBH.setTipString(R.string.loading);
        this.dBH.setDialogVisiable(true);
    }

    public void aTE() {
        if (this.dBH != null) {
            this.dBH.setDialogVisiable(false);
        }
    }

    public void vO(String str) {
        if (this.mContext != null) {
            this.mFrom = str;
            View view = getView();
            if (view != null && view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            aFd();
            this.mWindowHeight = getWindowMeasuredHeight() - l.getDimens(this.mContext, R.dimen.ds12);
            this.mPopupWindow = new PopupWindow(view, this.dPW, this.mWindowHeight);
            this.mPopupWindow.setFocusable(true);
            this.mPopupWindow.setTouchable(true);
            this.mPopupWindow.setOnDismissListener(this.dQk);
            resetState();
            this.dQb = new PopupWindow(LayoutInflater.from(this.mContext).inflate(R.layout.view_negative_feedback_bottom, (ViewGroup) null), -1, -1);
            if (Build.VERSION.SDK_INT >= 22) {
                this.dQb.setAttachedInDecor(false);
            }
            this.dQb.showAtLocation(this.mAnchor, 0, 0, 0);
            am.setBackgroundDrawable(this.mPopupWindow, R.drawable.bg_dailog);
            this.mPopupWindow.showAtLocation(this.mAnchor, 17, 0, 0);
            if (this.dQa != null) {
                this.dQa.b(this.dPU);
            }
            this.dQf = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject aTF() {
        int i;
        JSONObject jSONObject = new JSONObject();
        if (this.dPU == null) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        if (v.isEmpty(this.dPV)) {
            i = 0;
        } else {
            i = 0;
            for (int i2 = 0; i2 < this.dPV.size(); i2++) {
                b.a aVar = this.dPV.get(i2);
                if (aVar != null) {
                    jSONArray.put(String.valueOf(aVar.id));
                    i = aVar.index + 1;
                }
            }
        }
        TiebaStatic.log(new an("c13123").cp("obj_source", this.mFrom).Z("obj_type", i));
        if (this.dQr != null) {
            this.dQr.R(jSONArray);
        }
        try {
            jSONObject.put(TiebaInitialize.LogFields.REASON, jSONArray);
            jSONObject.put("thread_ids", this.dPU.ayk());
            jSONObject.put("type", this.dPU.ayj());
            jSONObject.put("forum_id", this.dPU.getFid());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
