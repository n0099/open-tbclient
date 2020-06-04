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
import com.baidu.tbadk.core.data.ak;
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
    private TextView bii;
    private int eJH;
    private PopupWindow eJL;
    private com.baidu.tieba.NEGFeedBack.b eJO;
    private boolean eJP;
    private LinearLayout eJZ;
    private a eKa;
    private b eKb;
    private TextView eKc;
    private TextView eKd;
    private TextView eKe;
    private View eKf;
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
    private ak eJF = null;
    private SparseArray<String> eJt = null;
    private List<b.a> eJG = new ArrayList();
    private NEGFeedBackView.a eJK = null;
    private int mSkinType = 3;
    private com.baidu.tbadk.core.view.a euw = null;
    private CompoundButton.OnCheckedChangeListener eJw = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.NEGFeedBack.e.1
        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (e.this.eJK != null) {
                e.this.eJK.a(e.this.eJF, compoundButton, z);
            }
            if (compoundButton.getTag() instanceof b.a) {
                b.a aVar = (b.a) compoundButton.getTag();
                if (z) {
                    if (!e.this.eJG.contains(aVar)) {
                        e.this.eJG.add(aVar);
                        return;
                    }
                    return;
                }
                e.this.eJG.remove(aVar);
            }
        }
    };
    private PopupWindow.OnDismissListener eJU = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.NEGFeedBack.e.2
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (e.this.eJL != null) {
                e.this.eJL.dismiss();
                e.this.eJL = null;
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
        this.mWindowWidth = l.getEquipmentWidth(this.mContext) - (this.mXOffset * 2);
        this.eJO = new com.baidu.tieba.NEGFeedBack.b(this.mPageContext);
        this.eJO.a(this.eJw);
        this.eJO.iS(true);
    }

    private int getWindowMeasuredHeight() {
        if (this.mContentView == null) {
            return 0;
        }
        this.mContentView.measure(0, 0);
        this.eJH = this.mContentView.getMeasuredHeight() + l.getDimens(this.mContext, R.dimen.ds12);
        return this.eJH;
    }

    public void setData(ak akVar) {
        if (akVar != null) {
            this.eJF = akVar;
            this.eJt = akVar.getFeedBackReasonMap();
            if (this.eJt != null && this.eJt.size() > 8) {
                for (int size = this.eJt.size() - 1; size >= 8; size--) {
                    this.eJt.removeAt(size);
                }
            }
            this.eJO.setData(akVar);
        }
    }

    public void setDefaultReasonArray(String[] strArr) {
        this.eJO.setDefaultReasonArray(strArr);
    }

    public void bkQ() {
        if (this.mPopupWindow != null) {
            this.mPopupWindow.dismiss();
            this.mPopupWindow = null;
        }
        if (this.eJL != null) {
            this.eJL.dismiss();
            this.eJL = null;
        }
    }

    private void resetState() {
        if (this.eJP && this.eJG.size() != 0) {
            this.eJG.clear();
        }
    }

    private void aWr() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            am.setViewTextColor(this.bii, R.color.cp_cont_f, 1);
            am.setViewTextColor(this.eKc, R.color.cp_cont_f, 1);
            am.setBackgroundColor(this.mTopLine, R.color.cp_bg_line_c);
            am.setBackgroundColor(this.eKf, R.color.cp_bg_line_c);
            am.setViewTextColor(this.eKd, R.color.cp_cont_f, 1);
            am.setViewTextColor(this.eKe, R.color.cp_cont_d, 1);
            this.mSkinType = skinType;
        }
    }

    private View getView() {
        if (this.mContext == null) {
            return null;
        }
        if (this.mContentView == null) {
            this.mContentView = (ViewGroup) LayoutInflater.from(this.mContext).inflate(R.layout.neg_dt_head_popupwindow, (ViewGroup) null);
            this.eKd = (TextView) this.mContentView.findViewById(R.id.head_text);
            this.eKe = (TextView) this.mContentView.findViewById(R.id.sub_head_text);
        }
        View rootView = this.eJO.getRootView();
        if (rootView != null && rootView.getParent() == null) {
            int dimens = l.getDimens(this.mContext, R.dimen.ds40);
            rootView.setPadding(dimens, 0, dimens, 0);
            this.mContentView.addView(rootView);
        }
        if (this.eJZ == null) {
            this.eJZ = (LinearLayout) LayoutInflater.from(this.mContext).inflate(R.layout.neg_dt_bottom_popupwindow, (ViewGroup) null);
            this.bii = (TextView) this.eJZ.findViewById(R.id.dialog_bottom_cancel_button);
            this.eKc = (TextView) this.eJZ.findViewById(R.id.dialog_bottom_certain_button);
            this.mTopLine = this.eJZ.findViewById(R.id.top_line);
            this.eKf = this.eJZ.findViewById(R.id.middle_line);
            this.mContentView.addView(this.eJZ);
            this.bii.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.NEGFeedBack.e.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (e.this.eJL != null) {
                        e.this.eJL.dismiss();
                        e.this.eJL = null;
                    }
                    if (e.this.mPopupWindow != null) {
                        e.this.mPopupWindow.dismiss();
                        e.this.mPopupWindow = null;
                    }
                    if (e.this.eKa != null) {
                        e.this.eKa.onClick();
                    }
                }
            });
            if (this.eKc != null) {
                this.eKc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.NEGFeedBack.e.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        JSONObject bkU = e.this.bkU();
                        if (e.this.mFrom == "3" || e.this.mFrom == "4" || e.this.mFrom == "1") {
                            e.this.bkQ();
                        } else if (bkU != null) {
                            e.this.showLoadingView();
                            CustomMessage customMessage = new CustomMessage(2016489, e.this.mPageContext.getUniqueId());
                            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2016489, bkU);
                            customResponsedMessage.setOrginalMessage(customMessage);
                            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                        }
                    }
                });
            }
            aWr();
        }
        return this.mContentView;
    }

    public void a(b bVar) {
        this.eKb = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLoadingView() {
        if (this.euw == null) {
            this.euw = new com.baidu.tbadk.core.view.a(this.mPageContext);
        }
        this.euw.setTipString(R.string.loading);
        this.euw.setDialogVisiable(true);
    }

    public void bkT() {
        if (this.euw != null) {
            this.euw.setDialogVisiable(false);
        }
    }

    public void zj(String str) {
        if (this.mContext != null) {
            this.mFrom = str;
            View view = getView();
            if (view != null && view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            aWr();
            this.mWindowHeight = getWindowMeasuredHeight() - l.getDimens(this.mContext, R.dimen.ds12);
            this.mPopupWindow = new PopupWindow(view, this.mWindowWidth, this.mWindowHeight);
            this.mPopupWindow.setFocusable(true);
            this.mPopupWindow.setTouchable(true);
            this.mPopupWindow.setOnDismissListener(this.eJU);
            resetState();
            this.eJL = new PopupWindow(LayoutInflater.from(this.mContext).inflate(R.layout.view_negative_feedback_bottom, (ViewGroup) null), -1, -1);
            if (Build.VERSION.SDK_INT >= 22) {
                this.eJL.setAttachedInDecor(false);
            }
            this.eJL.showAtLocation(this.mAnchor, 0, 0, 0);
            am.setBackgroundDrawable(this.mPopupWindow, R.drawable.bg_dailog);
            this.mPopupWindow.showAtLocation(this.mAnchor, 17, 0, 0);
            if (this.eJK != null) {
                this.eJK.b(this.eJF);
            }
            this.eJP = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject bkU() {
        int i;
        JSONObject jSONObject = new JSONObject();
        if (this.eJF == null) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        if (v.isEmpty(this.eJG)) {
            i = 0;
        } else {
            i = 0;
            for (int i2 = 0; i2 < this.eJG.size(); i2++) {
                b.a aVar = this.eJG.get(i2);
                if (aVar != null) {
                    jSONArray.put(String.valueOf(aVar.id));
                    i = aVar.index + 1;
                }
            }
        }
        TiebaStatic.log(new an("c13123").dh("obj_source", this.mFrom).ag("obj_type", i));
        if (this.eKb != null) {
            this.eKb.S(jSONArray);
        }
        try {
            jSONObject.put(TiebaInitialize.LogFields.REASON, jSONArray);
            jSONObject.put("thread_ids", this.eJF.aPc());
            jSONObject.put("type", this.eJF.aPb());
            jSONObject.put("forum_id", this.eJF.getFid());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
