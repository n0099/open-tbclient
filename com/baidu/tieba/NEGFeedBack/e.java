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
import com.baidu.tbadk.core.data.as;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.NEGFeedBack.b;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes20.dex */
public class e {
    private TextView bJY;
    private int fOI;
    private PopupWindow fON;
    private com.baidu.tieba.NEGFeedBack.b fOR;
    private boolean fOS;
    private LinearLayout fPd;
    private a fPe;
    private b fPf;
    private TextView fPg;
    private TextView fPh;
    private TextView fPi;
    private View fPj;
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
    private as fOG = null;
    private SparseArray<String> fOt = null;
    private List<b.a> fOH = new ArrayList();
    private NEGFeedBackView.a fOM = null;
    private int mSkinType = 3;
    private com.baidu.tbadk.core.view.a fxh = null;
    private CompoundButton.OnCheckedChangeListener fOx = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.NEGFeedBack.e.1
        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (e.this.fOM != null) {
                e.this.fOM.onCheckedChanged(e.this.fOG, compoundButton, z);
            }
            if (compoundButton.getTag() instanceof b.a) {
                b.a aVar = (b.a) compoundButton.getTag();
                if (z) {
                    if (!e.this.fOH.contains(aVar)) {
                        e.this.fOH.add(aVar);
                        return;
                    }
                    return;
                }
                e.this.fOH.remove(aVar);
            }
        }
    };
    private PopupWindow.OnDismissListener fOX = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.NEGFeedBack.e.2
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (e.this.fON != null) {
                e.this.fON.dismiss();
                e.this.fON = null;
            }
        }
    };

    /* loaded from: classes20.dex */
    public interface a {
        void onClick();
    }

    /* loaded from: classes20.dex */
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
        this.fOR = new com.baidu.tieba.NEGFeedBack.b(this.mPageContext);
        this.fOR.a(this.fOx);
        this.fOR.lf(true);
    }

    private int getWindowMeasuredHeight() {
        if (this.mContentView == null) {
            return 0;
        }
        this.mContentView.measure(0, 0);
        this.fOI = this.mContentView.getMeasuredHeight() + l.getDimens(this.mContext, R.dimen.ds12);
        return this.fOI;
    }

    public void setData(as asVar) {
        if (asVar != null) {
            this.fOG = asVar;
            this.fOt = asVar.getFeedBackReasonMap();
            if (this.fOt != null && this.fOt.size() > 8) {
                for (int size = this.fOt.size() - 1; size >= 8; size--) {
                    this.fOt.removeAt(size);
                }
            }
            this.fOR.setData(asVar);
        }
    }

    public void setDefaultReasonArray(String[] strArr) {
        this.fOR.setDefaultReasonArray(strArr);
    }

    public void bHP() {
        if (this.mPopupWindow != null) {
            this.mPopupWindow.dismiss();
            this.mPopupWindow = null;
        }
        if (this.fON != null) {
            this.fON.dismiss();
            this.fON = null;
        }
    }

    private void resetState() {
        if (this.fOS && this.fOH.size() != 0) {
            this.fOH.clear();
        }
    }

    private void brT() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            ap.setBackgroundColor(this.mContentView, R.color.CAM_X0212);
            ap.setViewTextColor(this.bJY, R.color.CAM_X0106, 1);
            ap.setViewTextColor(this.fPg, R.color.CAM_X0106, 1);
            ap.setBackgroundColor(this.mTopLine, R.color.CAM_X0204);
            ap.setBackgroundColor(this.fPj, R.color.CAM_X0204);
            ap.setViewTextColor(this.fPh, R.color.CAM_X0106, 1);
            ap.setViewTextColor(this.fPi, R.color.CAM_X0109, 1);
            this.mSkinType = skinType;
        }
    }

    private View getView() {
        if (this.mContext == null) {
            return null;
        }
        if (this.mContentView == null) {
            this.mContentView = (ViewGroup) LayoutInflater.from(this.mContext).inflate(R.layout.neg_dt_head_popupwindow, (ViewGroup) null);
            this.fPh = (TextView) this.mContentView.findViewById(R.id.head_text);
            this.fPi = (TextView) this.mContentView.findViewById(R.id.sub_head_text);
        }
        View rootView = this.fOR.getRootView();
        if (rootView != null && rootView.getParent() == null) {
            int dimens = l.getDimens(this.mContext, R.dimen.ds40);
            rootView.setPadding(dimens, 0, dimens, 0);
            this.mContentView.addView(rootView);
        }
        if (this.fPd == null) {
            this.fPd = (LinearLayout) LayoutInflater.from(this.mContext).inflate(R.layout.neg_dt_bottom_popupwindow, (ViewGroup) null);
            this.bJY = (TextView) this.fPd.findViewById(R.id.dialog_bottom_cancel_button);
            this.fPg = (TextView) this.fPd.findViewById(R.id.dialog_bottom_certain_button);
            this.mTopLine = this.fPd.findViewById(R.id.top_line);
            this.fPj = this.fPd.findViewById(R.id.middle_line);
            this.mContentView.addView(this.fPd);
            this.bJY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.NEGFeedBack.e.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (e.this.fON != null) {
                        e.this.fON.dismiss();
                        e.this.fON = null;
                    }
                    if (e.this.mPopupWindow != null) {
                        e.this.mPopupWindow.dismiss();
                        e.this.mPopupWindow = null;
                    }
                    if (e.this.fPe != null) {
                        e.this.fPe.onClick();
                    }
                }
            });
            if (this.fPg != null) {
                this.fPg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.NEGFeedBack.e.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        JSONObject bHU = e.this.bHU();
                        if (e.this.mFrom == "3" || e.this.mFrom == "4" || e.this.mFrom == "1") {
                            e.this.bHP();
                        } else if (bHU != null) {
                            e.this.showLoadingView();
                            CustomMessage customMessage = new CustomMessage(2016489, e.this.mPageContext.getUniqueId());
                            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2016489, bHU);
                            customResponsedMessage.setOrginalMessage(customMessage);
                            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                        }
                    }
                });
            }
            brT();
        }
        return this.mContentView;
    }

    public void a(b bVar) {
        this.fPf = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLoadingView() {
        if (this.fxh == null) {
            this.fxh = new com.baidu.tbadk.core.view.a(this.mPageContext);
        }
        this.fxh.setTipString(R.string.loading);
        this.fxh.setDialogVisiable(true);
    }

    public void bHT() {
        if (this.fxh != null) {
            this.fxh.setDialogVisiable(false);
        }
    }

    public void Ev(String str) {
        if (this.mContext != null) {
            this.mFrom = str;
            View view = getView();
            if (view != null && view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            brT();
            this.mWindowHeight = getWindowMeasuredHeight() - l.getDimens(this.mContext, R.dimen.ds12);
            this.mPopupWindow = new PopupWindow(view, this.mWindowWidth, this.mWindowHeight);
            this.mPopupWindow.setFocusable(true);
            this.mPopupWindow.setTouchable(true);
            this.mPopupWindow.setOnDismissListener(this.fOX);
            resetState();
            this.fON = new PopupWindow(LayoutInflater.from(this.mContext).inflate(R.layout.view_negative_feedback_bottom, (ViewGroup) null), -1, -1);
            if (Build.VERSION.SDK_INT >= 22) {
                this.fON.setAttachedInDecor(false);
            }
            this.fON.showAtLocation(this.mAnchor, 0, 0, 0);
            ap.setBackgroundDrawable(this.mPopupWindow, R.drawable.bg_dailog);
            this.mPopupWindow.showAtLocation(this.mAnchor, 17, 0, 0);
            if (this.fOM != null) {
                this.fOM.onNEGFeedbackWindowShow(this.fOG);
            }
            this.fOS = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject bHU() {
        int i;
        JSONObject jSONObject = new JSONObject();
        if (this.fOG == null) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        if (y.isEmpty(this.fOH)) {
            i = 0;
        } else {
            i = 0;
            for (int i2 = 0; i2 < this.fOH.size(); i2++) {
                b.a aVar = this.fOH.get(i2);
                if (aVar != null) {
                    jSONArray.put(String.valueOf(aVar.id));
                    i = aVar.index + 1;
                }
            }
        }
        TiebaStatic.log(new ar("c13123").dR("obj_source", this.mFrom).ak("obj_type", i));
        if (this.fPf != null) {
            this.fPf.W(jSONArray);
        }
        try {
            jSONObject.put(TiebaInitialize.LogFields.REASON, jSONArray);
            jSONObject.put("thread_ids", this.fOG.bka());
            jSONObject.put("type", this.fOG.bjZ());
            jSONObject.put("forum_id", this.fOG.getFid());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
