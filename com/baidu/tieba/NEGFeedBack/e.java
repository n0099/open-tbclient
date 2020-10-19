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
/* loaded from: classes21.dex */
public class e {
    private TextView bDi;
    private int fAR;
    private PopupWindow fAV;
    private com.baidu.tieba.NEGFeedBack.b fAY;
    private boolean fAZ;
    private LinearLayout fBj;
    private a fBk;
    private b fBl;
    private TextView fBm;
    private TextView fBn;
    private TextView fBo;
    private View fBp;
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
    private ar fAP = null;
    private SparseArray<String> fAC = null;
    private List<b.a> fAQ = new ArrayList();
    private NEGFeedBackView.a fAU = null;
    private int mSkinType = 3;
    private com.baidu.tbadk.core.view.a fjB = null;
    private CompoundButton.OnCheckedChangeListener fAG = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.NEGFeedBack.e.1
        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (e.this.fAU != null) {
                e.this.fAU.onCheckedChanged(e.this.fAP, compoundButton, z);
            }
            if (compoundButton.getTag() instanceof b.a) {
                b.a aVar = (b.a) compoundButton.getTag();
                if (z) {
                    if (!e.this.fAQ.contains(aVar)) {
                        e.this.fAQ.add(aVar);
                        return;
                    }
                    return;
                }
                e.this.fAQ.remove(aVar);
            }
        }
    };
    private PopupWindow.OnDismissListener fBe = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.NEGFeedBack.e.2
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (e.this.fAV != null) {
                e.this.fAV.dismiss();
                e.this.fAV = null;
            }
        }
    };

    /* loaded from: classes21.dex */
    public interface a {
        void onClick();
    }

    /* loaded from: classes21.dex */
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
        this.fAY = new com.baidu.tieba.NEGFeedBack.b(this.mPageContext);
        this.fAY.a(this.fAG);
        this.fAY.kI(true);
    }

    private int getWindowMeasuredHeight() {
        if (this.mContentView == null) {
            return 0;
        }
        this.mContentView.measure(0, 0);
        this.fAR = this.mContentView.getMeasuredHeight() + l.getDimens(this.mContext, R.dimen.ds12);
        return this.fAR;
    }

    public void setData(ar arVar) {
        if (arVar != null) {
            this.fAP = arVar;
            this.fAC = arVar.getFeedBackReasonMap();
            if (this.fAC != null && this.fAC.size() > 8) {
                for (int size = this.fAC.size() - 1; size >= 8; size--) {
                    this.fAC.removeAt(size);
                }
            }
            this.fAY.setData(arVar);
        }
    }

    public void setDefaultReasonArray(String[] strArr) {
        this.fAY.setDefaultReasonArray(strArr);
    }

    public void bEe() {
        if (this.mPopupWindow != null) {
            this.mPopupWindow.dismiss();
            this.mPopupWindow = null;
        }
        if (this.fAV != null) {
            this.fAV.dismiss();
            this.fAV = null;
        }
    }

    private void resetState() {
        if (this.fAZ && this.fAQ.size() != 0) {
            this.fAQ.clear();
        }
    }

    private void bok() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            ap.setBackgroundColor(this.mContentView, R.color.cp_bg_line_f);
            ap.setViewTextColor(this.bDi, R.color.cp_cont_f, 1);
            ap.setViewTextColor(this.fBm, R.color.cp_cont_f, 1);
            ap.setBackgroundColor(this.mTopLine, R.color.cp_bg_line_c);
            ap.setBackgroundColor(this.fBp, R.color.cp_bg_line_c);
            ap.setViewTextColor(this.fBn, R.color.cp_cont_f, 1);
            ap.setViewTextColor(this.fBo, R.color.cp_cont_d, 1);
            this.mSkinType = skinType;
        }
    }

    private View getView() {
        if (this.mContext == null) {
            return null;
        }
        if (this.mContentView == null) {
            this.mContentView = (ViewGroup) LayoutInflater.from(this.mContext).inflate(R.layout.neg_dt_head_popupwindow, (ViewGroup) null);
            this.fBn = (TextView) this.mContentView.findViewById(R.id.head_text);
            this.fBo = (TextView) this.mContentView.findViewById(R.id.sub_head_text);
        }
        View rootView = this.fAY.getRootView();
        if (rootView != null && rootView.getParent() == null) {
            int dimens = l.getDimens(this.mContext, R.dimen.ds40);
            rootView.setPadding(dimens, 0, dimens, 0);
            this.mContentView.addView(rootView);
        }
        if (this.fBj == null) {
            this.fBj = (LinearLayout) LayoutInflater.from(this.mContext).inflate(R.layout.neg_dt_bottom_popupwindow, (ViewGroup) null);
            this.bDi = (TextView) this.fBj.findViewById(R.id.dialog_bottom_cancel_button);
            this.fBm = (TextView) this.fBj.findViewById(R.id.dialog_bottom_certain_button);
            this.mTopLine = this.fBj.findViewById(R.id.top_line);
            this.fBp = this.fBj.findViewById(R.id.middle_line);
            this.mContentView.addView(this.fBj);
            this.bDi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.NEGFeedBack.e.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (e.this.fAV != null) {
                        e.this.fAV.dismiss();
                        e.this.fAV = null;
                    }
                    if (e.this.mPopupWindow != null) {
                        e.this.mPopupWindow.dismiss();
                        e.this.mPopupWindow = null;
                    }
                    if (e.this.fBk != null) {
                        e.this.fBk.onClick();
                    }
                }
            });
            if (this.fBm != null) {
                this.fBm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.NEGFeedBack.e.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        JSONObject bEi = e.this.bEi();
                        if (e.this.mFrom == "3" || e.this.mFrom == "4" || e.this.mFrom == "1") {
                            e.this.bEe();
                        } else if (bEi != null) {
                            e.this.showLoadingView();
                            CustomMessage customMessage = new CustomMessage(2016489, e.this.mPageContext.getUniqueId());
                            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2016489, bEi);
                            customResponsedMessage.setOrginalMessage(customMessage);
                            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                        }
                    }
                });
            }
            bok();
        }
        return this.mContentView;
    }

    public void a(b bVar) {
        this.fBl = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLoadingView() {
        if (this.fjB == null) {
            this.fjB = new com.baidu.tbadk.core.view.a(this.mPageContext);
        }
        this.fjB.setTipString(R.string.loading);
        this.fjB.setDialogVisiable(true);
    }

    public void bEh() {
        if (this.fjB != null) {
            this.fjB.setDialogVisiable(false);
        }
    }

    public void En(String str) {
        if (this.mContext != null) {
            this.mFrom = str;
            View view = getView();
            if (view != null && view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            bok();
            this.mWindowHeight = getWindowMeasuredHeight() - l.getDimens(this.mContext, R.dimen.ds12);
            this.mPopupWindow = new PopupWindow(view, this.mWindowWidth, this.mWindowHeight);
            this.mPopupWindow.setFocusable(true);
            this.mPopupWindow.setTouchable(true);
            this.mPopupWindow.setOnDismissListener(this.fBe);
            resetState();
            this.fAV = new PopupWindow(LayoutInflater.from(this.mContext).inflate(R.layout.view_negative_feedback_bottom, (ViewGroup) null), -1, -1);
            if (Build.VERSION.SDK_INT >= 22) {
                this.fAV.setAttachedInDecor(false);
            }
            this.fAV.showAtLocation(this.mAnchor, 0, 0, 0);
            ap.setBackgroundDrawable(this.mPopupWindow, R.drawable.bg_dailog);
            this.mPopupWindow.showAtLocation(this.mAnchor, 17, 0, 0);
            if (this.fAU != null) {
                this.fAU.onNEGFeedbackWindowShow(this.fAP);
            }
            this.fAZ = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject bEi() {
        int i;
        JSONObject jSONObject = new JSONObject();
        if (this.fAP == null) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        if (y.isEmpty(this.fAQ)) {
            i = 0;
        } else {
            i = 0;
            for (int i2 = 0; i2 < this.fAQ.size(); i2++) {
                b.a aVar = this.fAQ.get(i2);
                if (aVar != null) {
                    jSONArray.put(String.valueOf(aVar.id));
                    i = aVar.index + 1;
                }
            }
        }
        TiebaStatic.log(new aq("c13123").dK("obj_source", this.mFrom).aj("obj_type", i));
        if (this.fBl != null) {
            this.fBl.W(jSONArray);
        }
        try {
            jSONObject.put(TiebaInitialize.LogFields.REASON, jSONArray);
            jSONObject.put("thread_ids", this.fAP.bgF());
            jSONObject.put("type", this.fAP.bgE());
            jSONObject.put("forum_id", this.fAP.getFid());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
