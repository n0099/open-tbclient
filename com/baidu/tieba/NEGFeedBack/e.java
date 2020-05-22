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
    private PopupWindow eJA;
    private com.baidu.tieba.NEGFeedBack.b eJD;
    private boolean eJE;
    private LinearLayout eJO;
    private a eJP;
    private b eJQ;
    private TextView eJR;
    private TextView eJS;
    private TextView eJT;
    private View eJU;
    private int eJw;
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
    private ak eJu = null;
    private SparseArray<String> eJi = null;
    private List<b.a> eJv = new ArrayList();
    private NEGFeedBackView.a eJz = null;
    private int mSkinType = 3;
    private com.baidu.tbadk.core.view.a euw = null;
    private CompoundButton.OnCheckedChangeListener eJl = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.NEGFeedBack.e.1
        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (e.this.eJz != null) {
                e.this.eJz.a(e.this.eJu, compoundButton, z);
            }
            if (compoundButton.getTag() instanceof b.a) {
                b.a aVar = (b.a) compoundButton.getTag();
                if (z) {
                    if (!e.this.eJv.contains(aVar)) {
                        e.this.eJv.add(aVar);
                        return;
                    }
                    return;
                }
                e.this.eJv.remove(aVar);
            }
        }
    };
    private PopupWindow.OnDismissListener eJJ = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.NEGFeedBack.e.2
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (e.this.eJA != null) {
                e.this.eJA.dismiss();
                e.this.eJA = null;
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
        this.eJD = new com.baidu.tieba.NEGFeedBack.b(this.mPageContext);
        this.eJD.a(this.eJl);
        this.eJD.iS(true);
    }

    private int getWindowMeasuredHeight() {
        if (this.mContentView == null) {
            return 0;
        }
        this.mContentView.measure(0, 0);
        this.eJw = this.mContentView.getMeasuredHeight() + l.getDimens(this.mContext, R.dimen.ds12);
        return this.eJw;
    }

    public void setData(ak akVar) {
        if (akVar != null) {
            this.eJu = akVar;
            this.eJi = akVar.getFeedBackReasonMap();
            if (this.eJi != null && this.eJi.size() > 8) {
                for (int size = this.eJi.size() - 1; size >= 8; size--) {
                    this.eJi.removeAt(size);
                }
            }
            this.eJD.setData(akVar);
        }
    }

    public void setDefaultReasonArray(String[] strArr) {
        this.eJD.setDefaultReasonArray(strArr);
    }

    public void bkO() {
        if (this.mPopupWindow != null) {
            this.mPopupWindow.dismiss();
            this.mPopupWindow = null;
        }
        if (this.eJA != null) {
            this.eJA.dismiss();
            this.eJA = null;
        }
    }

    private void resetState() {
        if (this.eJE && this.eJv.size() != 0) {
            this.eJv.clear();
        }
    }

    private void aWq() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            am.setViewTextColor(this.bii, R.color.cp_cont_f, 1);
            am.setViewTextColor(this.eJR, R.color.cp_cont_f, 1);
            am.setBackgroundColor(this.mTopLine, R.color.cp_bg_line_c);
            am.setBackgroundColor(this.eJU, R.color.cp_bg_line_c);
            am.setViewTextColor(this.eJS, R.color.cp_cont_f, 1);
            am.setViewTextColor(this.eJT, R.color.cp_cont_d, 1);
            this.mSkinType = skinType;
        }
    }

    private View getView() {
        if (this.mContext == null) {
            return null;
        }
        if (this.mContentView == null) {
            this.mContentView = (ViewGroup) LayoutInflater.from(this.mContext).inflate(R.layout.neg_dt_head_popupwindow, (ViewGroup) null);
            this.eJS = (TextView) this.mContentView.findViewById(R.id.head_text);
            this.eJT = (TextView) this.mContentView.findViewById(R.id.sub_head_text);
        }
        View rootView = this.eJD.getRootView();
        if (rootView != null && rootView.getParent() == null) {
            int dimens = l.getDimens(this.mContext, R.dimen.ds40);
            rootView.setPadding(dimens, 0, dimens, 0);
            this.mContentView.addView(rootView);
        }
        if (this.eJO == null) {
            this.eJO = (LinearLayout) LayoutInflater.from(this.mContext).inflate(R.layout.neg_dt_bottom_popupwindow, (ViewGroup) null);
            this.bii = (TextView) this.eJO.findViewById(R.id.dialog_bottom_cancel_button);
            this.eJR = (TextView) this.eJO.findViewById(R.id.dialog_bottom_certain_button);
            this.mTopLine = this.eJO.findViewById(R.id.top_line);
            this.eJU = this.eJO.findViewById(R.id.middle_line);
            this.mContentView.addView(this.eJO);
            this.bii.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.NEGFeedBack.e.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (e.this.eJA != null) {
                        e.this.eJA.dismiss();
                        e.this.eJA = null;
                    }
                    if (e.this.mPopupWindow != null) {
                        e.this.mPopupWindow.dismiss();
                        e.this.mPopupWindow = null;
                    }
                    if (e.this.eJP != null) {
                        e.this.eJP.onClick();
                    }
                }
            });
            if (this.eJR != null) {
                this.eJR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.NEGFeedBack.e.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        JSONObject bkS = e.this.bkS();
                        if (e.this.mFrom == "3" || e.this.mFrom == "4" || e.this.mFrom == "1") {
                            e.this.bkO();
                        } else if (bkS != null) {
                            e.this.showLoadingView();
                            CustomMessage customMessage = new CustomMessage(2016489, e.this.mPageContext.getUniqueId());
                            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2016489, bkS);
                            customResponsedMessage.setOrginalMessage(customMessage);
                            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                        }
                    }
                });
            }
            aWq();
        }
        return this.mContentView;
    }

    public void a(b bVar) {
        this.eJQ = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLoadingView() {
        if (this.euw == null) {
            this.euw = new com.baidu.tbadk.core.view.a(this.mPageContext);
        }
        this.euw.setTipString(R.string.loading);
        this.euw.setDialogVisiable(true);
    }

    public void bkR() {
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
            aWq();
            this.mWindowHeight = getWindowMeasuredHeight() - l.getDimens(this.mContext, R.dimen.ds12);
            this.mPopupWindow = new PopupWindow(view, this.mWindowWidth, this.mWindowHeight);
            this.mPopupWindow.setFocusable(true);
            this.mPopupWindow.setTouchable(true);
            this.mPopupWindow.setOnDismissListener(this.eJJ);
            resetState();
            this.eJA = new PopupWindow(LayoutInflater.from(this.mContext).inflate(R.layout.view_negative_feedback_bottom, (ViewGroup) null), -1, -1);
            if (Build.VERSION.SDK_INT >= 22) {
                this.eJA.setAttachedInDecor(false);
            }
            this.eJA.showAtLocation(this.mAnchor, 0, 0, 0);
            am.setBackgroundDrawable(this.mPopupWindow, R.drawable.bg_dailog);
            this.mPopupWindow.showAtLocation(this.mAnchor, 17, 0, 0);
            if (this.eJz != null) {
                this.eJz.b(this.eJu);
            }
            this.eJE = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject bkS() {
        int i;
        JSONObject jSONObject = new JSONObject();
        if (this.eJu == null) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        if (v.isEmpty(this.eJv)) {
            i = 0;
        } else {
            i = 0;
            for (int i2 = 0; i2 < this.eJv.size(); i2++) {
                b.a aVar = this.eJv.get(i2);
                if (aVar != null) {
                    jSONArray.put(String.valueOf(aVar.id));
                    i = aVar.index + 1;
                }
            }
        }
        TiebaStatic.log(new an("c13123").dh("obj_source", this.mFrom).ag("obj_type", i));
        if (this.eJQ != null) {
            this.eJQ.S(jSONArray);
        }
        try {
            jSONObject.put(TiebaInitialize.LogFields.REASON, jSONArray);
            jSONObject.put("thread_ids", this.eJu.aPc());
            jSONObject.put("type", this.eJu.aPb());
            jSONObject.put("forum_id", this.eJu.getFid());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
