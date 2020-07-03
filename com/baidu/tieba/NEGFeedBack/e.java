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
import com.baidu.tbadk.core.data.ap;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.NEGFeedBack.b;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class e {
    private TextView bnn;
    private int eTT;
    private PopupWindow eTX;
    private com.baidu.tieba.NEGFeedBack.b eUa;
    private boolean eUb;
    private LinearLayout eUl;
    private a eUm;
    private b eUn;
    private TextView eUo;
    private TextView eUp;
    private TextView eUq;
    private View eUr;
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
    private ap eTR = null;
    private SparseArray<String> eTF = null;
    private List<b.a> eTS = new ArrayList();
    private NEGFeedBackView.a eTW = null;
    private int mSkinType = 3;
    private com.baidu.tbadk.core.view.a eDA = null;
    private CompoundButton.OnCheckedChangeListener eTI = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.NEGFeedBack.e.1
        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (e.this.eTW != null) {
                e.this.eTW.a(e.this.eTR, compoundButton, z);
            }
            if (compoundButton.getTag() instanceof b.a) {
                b.a aVar = (b.a) compoundButton.getTag();
                if (z) {
                    if (!e.this.eTS.contains(aVar)) {
                        e.this.eTS.add(aVar);
                        return;
                    }
                    return;
                }
                e.this.eTS.remove(aVar);
            }
        }
    };
    private PopupWindow.OnDismissListener eUg = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.NEGFeedBack.e.2
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (e.this.eTX != null) {
                e.this.eTX.dismiss();
                e.this.eTX = null;
            }
        }
    };

    /* loaded from: classes8.dex */
    public interface a {
        void onClick();
    }

    /* loaded from: classes8.dex */
    public interface b {
        void T(JSONArray jSONArray);
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
        this.eUa = new com.baidu.tieba.NEGFeedBack.b(this.mPageContext);
        this.eUa.a(this.eTI);
        this.eUa.je(true);
    }

    private int getWindowMeasuredHeight() {
        if (this.mContentView == null) {
            return 0;
        }
        this.mContentView.measure(0, 0);
        this.eTT = this.mContentView.getMeasuredHeight() + l.getDimens(this.mContext, R.dimen.ds12);
        return this.eTT;
    }

    public void setData(ap apVar) {
        if (apVar != null) {
            this.eTR = apVar;
            this.eTF = apVar.getFeedBackReasonMap();
            if (this.eTF != null && this.eTF.size() > 8) {
                for (int size = this.eTF.size() - 1; size >= 8; size--) {
                    this.eTF.removeAt(size);
                }
            }
            this.eUa.setData(apVar);
        }
    }

    public void setDefaultReasonArray(String[] strArr) {
        this.eUa.setDefaultReasonArray(strArr);
    }

    public void bnp() {
        if (this.mPopupWindow != null) {
            this.mPopupWindow.dismiss();
            this.mPopupWindow = null;
        }
        if (this.eTX != null) {
            this.eTX.dismiss();
            this.eTX = null;
        }
    }

    private void resetState() {
        if (this.eUb && this.eTS.size() != 0) {
            this.eTS.clear();
        }
    }

    private void aYj() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            an.setViewTextColor(this.bnn, R.color.cp_cont_f, 1);
            an.setViewTextColor(this.eUo, R.color.cp_cont_f, 1);
            an.setBackgroundColor(this.mTopLine, R.color.cp_bg_line_c);
            an.setBackgroundColor(this.eUr, R.color.cp_bg_line_c);
            an.setViewTextColor(this.eUp, R.color.cp_cont_f, 1);
            an.setViewTextColor(this.eUq, R.color.cp_cont_d, 1);
            this.mSkinType = skinType;
        }
    }

    private View getView() {
        if (this.mContext == null) {
            return null;
        }
        if (this.mContentView == null) {
            this.mContentView = (ViewGroup) LayoutInflater.from(this.mContext).inflate(R.layout.neg_dt_head_popupwindow, (ViewGroup) null);
            this.eUp = (TextView) this.mContentView.findViewById(R.id.head_text);
            this.eUq = (TextView) this.mContentView.findViewById(R.id.sub_head_text);
        }
        View rootView = this.eUa.getRootView();
        if (rootView != null && rootView.getParent() == null) {
            int dimens = l.getDimens(this.mContext, R.dimen.ds40);
            rootView.setPadding(dimens, 0, dimens, 0);
            this.mContentView.addView(rootView);
        }
        if (this.eUl == null) {
            this.eUl = (LinearLayout) LayoutInflater.from(this.mContext).inflate(R.layout.neg_dt_bottom_popupwindow, (ViewGroup) null);
            this.bnn = (TextView) this.eUl.findViewById(R.id.dialog_bottom_cancel_button);
            this.eUo = (TextView) this.eUl.findViewById(R.id.dialog_bottom_certain_button);
            this.mTopLine = this.eUl.findViewById(R.id.top_line);
            this.eUr = this.eUl.findViewById(R.id.middle_line);
            this.mContentView.addView(this.eUl);
            this.bnn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.NEGFeedBack.e.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (e.this.eTX != null) {
                        e.this.eTX.dismiss();
                        e.this.eTX = null;
                    }
                    if (e.this.mPopupWindow != null) {
                        e.this.mPopupWindow.dismiss();
                        e.this.mPopupWindow = null;
                    }
                    if (e.this.eUm != null) {
                        e.this.eUm.onClick();
                    }
                }
            });
            if (this.eUo != null) {
                this.eUo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.NEGFeedBack.e.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        JSONObject bnt = e.this.bnt();
                        if (e.this.mFrom == "3" || e.this.mFrom == "4" || e.this.mFrom == "1") {
                            e.this.bnp();
                        } else if (bnt != null) {
                            e.this.showLoadingView();
                            CustomMessage customMessage = new CustomMessage(2016489, e.this.mPageContext.getUniqueId());
                            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2016489, bnt);
                            customResponsedMessage.setOrginalMessage(customMessage);
                            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                        }
                    }
                });
            }
            aYj();
        }
        return this.mContentView;
    }

    public void a(b bVar) {
        this.eUn = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLoadingView() {
        if (this.eDA == null) {
            this.eDA = new com.baidu.tbadk.core.view.a(this.mPageContext);
        }
        this.eDA.setTipString(R.string.loading);
        this.eDA.setDialogVisiable(true);
    }

    public void bns() {
        if (this.eDA != null) {
            this.eDA.setDialogVisiable(false);
        }
    }

    public void zC(String str) {
        if (this.mContext != null) {
            this.mFrom = str;
            View view = getView();
            if (view != null && view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            aYj();
            this.mWindowHeight = getWindowMeasuredHeight() - l.getDimens(this.mContext, R.dimen.ds12);
            this.mPopupWindow = new PopupWindow(view, this.mWindowWidth, this.mWindowHeight);
            this.mPopupWindow.setFocusable(true);
            this.mPopupWindow.setTouchable(true);
            this.mPopupWindow.setOnDismissListener(this.eUg);
            resetState();
            this.eTX = new PopupWindow(LayoutInflater.from(this.mContext).inflate(R.layout.view_negative_feedback_bottom, (ViewGroup) null), -1, -1);
            if (Build.VERSION.SDK_INT >= 22) {
                this.eTX.setAttachedInDecor(false);
            }
            this.eTX.showAtLocation(this.mAnchor, 0, 0, 0);
            an.setBackgroundDrawable(this.mPopupWindow, R.drawable.bg_dailog);
            this.mPopupWindow.showAtLocation(this.mAnchor, 17, 0, 0);
            if (this.eTW != null) {
                this.eTW.b(this.eTR);
            }
            this.eUb = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject bnt() {
        int i;
        JSONObject jSONObject = new JSONObject();
        if (this.eTR == null) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        if (w.isEmpty(this.eTS)) {
            i = 0;
        } else {
            i = 0;
            for (int i2 = 0; i2 < this.eTS.size(); i2++) {
                b.a aVar = this.eTS.get(i2);
                if (aVar != null) {
                    jSONArray.put(String.valueOf(aVar.id));
                    i = aVar.index + 1;
                }
            }
        }
        TiebaStatic.log(new ao("c13123").dk("obj_source", this.mFrom).ag("obj_type", i));
        if (this.eUn != null) {
            this.eUn.T(jSONArray);
        }
        try {
            jSONObject.put(TiebaInitialize.LogFields.REASON, jSONArray);
            jSONObject.put("thread_ids", this.eTR.aQN());
            jSONObject.put("type", this.eTR.aQM());
            jSONObject.put("forum_id", this.eTR.getFid());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
