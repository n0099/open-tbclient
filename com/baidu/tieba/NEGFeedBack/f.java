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
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.at;
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
/* loaded from: classes21.dex */
public class f {
    private TextView bPf;
    private PopupWindow fWD;
    private com.baidu.tieba.NEGFeedBack.b fWH;
    private boolean fWI;
    private LinearLayout fWV;
    private a fWW;
    private b fWX;
    private TextView fWY;
    private TextView fWZ;
    private int fWy;
    private TextView fXa;
    private View fXb;
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
    private at fWw = null;
    private SparseArray<String> fWh = null;
    private List<b.a> fWx = new ArrayList();
    private NEGFeedBackView.a fWC = null;
    private int mSkinType = 3;
    private com.baidu.tbadk.core.view.a fEW = null;
    private CompoundButton.OnCheckedChangeListener fWl = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.NEGFeedBack.f.1
        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (f.this.fWC != null) {
                f.this.fWC.onCheckedChanged(f.this.fWw, compoundButton, z);
            }
            if (compoundButton.getTag() instanceof b.a) {
                b.a aVar = (b.a) compoundButton.getTag();
                if (z) {
                    if (!f.this.fWx.contains(aVar)) {
                        f.this.fWx.add(aVar);
                        return;
                    }
                    return;
                }
                f.this.fWx.remove(aVar);
            }
        }
    };
    private PopupWindow.OnDismissListener fWO = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.NEGFeedBack.f.2
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (f.this.fWD != null) {
                f.this.fWD.dismiss();
                f.this.fWD = null;
                MessageManager.getInstance().unRegisterListener(f.this.eOd);
            }
        }
    };
    private CustomMessageListener eOd = new CustomMessageListener(CmdConfigCustom.CMD_SKIN_TYPE_CHANGE) { // from class: com.baidu.tieba.NEGFeedBack.f.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001304 && (customResponsedMessage.getData() instanceof Integer)) {
                f.this.bvt();
            }
        }
    };

    /* loaded from: classes21.dex */
    public interface a {
        void onClick();
    }

    /* loaded from: classes21.dex */
    public interface b {
        void X(JSONArray jSONArray);
    }

    public f(TbPageContext tbPageContext, View view) {
        this.mContext = null;
        this.mContext = tbPageContext.getPageActivity();
        this.mPageContext = tbPageContext;
        this.mAnchor = view;
        init();
    }

    private void init() {
        this.mXOffset = l.getDimens(this.mContext, R.dimen.tbds32);
        this.mWindowWidth = l.getEquipmentWidth(this.mContext) - (this.mXOffset * 2);
        this.fWH = new com.baidu.tieba.NEGFeedBack.b(this.mPageContext);
        this.fWH.a(this.fWl);
        this.fWH.lz(true);
    }

    private int getWindowMeasuredHeight() {
        if (this.mContentView == null) {
            return 0;
        }
        this.mContentView.measure(0, 0);
        this.fWy = this.mContentView.getMeasuredHeight() + l.getDimens(this.mContext, R.dimen.ds12);
        return this.fWy;
    }

    public void setData(at atVar) {
        if (atVar != null) {
            this.fWw = atVar;
            this.fWh = atVar.getFeedBackReasonMap();
            if (this.fWh != null && this.fWh.size() > 8) {
                for (int size = this.fWh.size() - 1; size >= 8; size--) {
                    this.fWh.removeAt(size);
                }
            }
            this.fWH.setData(atVar);
        }
    }

    public void setDefaultReasonArray(String[] strArr) {
        this.fWH.setDefaultReasonArray(strArr);
    }

    public void bLq() {
        if (this.mPopupWindow != null) {
            this.mPopupWindow.dismiss();
            this.mPopupWindow = null;
        }
        if (this.fWD != null) {
            this.fWD.dismiss();
            this.fWD = null;
        }
    }

    private void UW() {
        if (this.fWI && this.fWx.size() != 0) {
            this.fWx.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bvt() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            ap.setBackgroundColor(this.mContentView, R.color.CAM_X0205);
            ap.setViewTextColor(this.bPf, R.color.CAM_X0106, 1);
            ap.setViewTextColor(this.fWY, R.color.CAM_X0106, 1);
            ap.setBackgroundColor(this.mTopLine, R.color.CAM_X0204);
            ap.setBackgroundColor(this.fXb, R.color.CAM_X0204);
            ap.setViewTextColor(this.fWZ, R.color.CAM_X0106, 1);
            ap.setViewTextColor(this.fXa, R.color.CAM_X0109, 1);
            this.mSkinType = skinType;
        }
    }

    private View getView() {
        if (this.mContext == null) {
            return null;
        }
        if (this.mContentView == null) {
            this.mContentView = (ViewGroup) LayoutInflater.from(this.mContext).inflate(R.layout.neg_dt_head_popupwindow, (ViewGroup) null);
            this.fWZ = (TextView) this.mContentView.findViewById(R.id.head_text);
            this.fXa = (TextView) this.mContentView.findViewById(R.id.sub_head_text);
        }
        View rootView = this.fWH.getRootView();
        if (rootView != null && rootView.getParent() == null) {
            int dimens = l.getDimens(this.mContext, R.dimen.ds40);
            rootView.setPadding(dimens, 0, dimens, 0);
            this.mContentView.addView(rootView);
        }
        if (this.fWV == null) {
            this.fWV = (LinearLayout) LayoutInflater.from(this.mContext).inflate(R.layout.neg_dt_bottom_popupwindow, (ViewGroup) null);
            this.bPf = (TextView) this.fWV.findViewById(R.id.dialog_bottom_cancel_button);
            this.fWY = (TextView) this.fWV.findViewById(R.id.dialog_bottom_certain_button);
            this.mTopLine = this.fWV.findViewById(R.id.top_line);
            this.fXb = this.fWV.findViewById(R.id.middle_line);
            this.mContentView.addView(this.fWV);
            this.bPf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.NEGFeedBack.f.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (f.this.fWD != null) {
                        f.this.fWD.dismiss();
                        f.this.fWD = null;
                    }
                    if (f.this.mPopupWindow != null) {
                        f.this.mPopupWindow.dismiss();
                        f.this.mPopupWindow = null;
                    }
                    if (f.this.fWW != null) {
                        f.this.fWW.onClick();
                    }
                }
            });
            if (this.fWY != null) {
                this.fWY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.NEGFeedBack.f.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        JSONObject bLv = f.this.bLv();
                        if (f.this.mFrom == "3" || f.this.mFrom == "4" || f.this.mFrom == "1") {
                            f.this.bLq();
                        } else if (bLv != null) {
                            f.this.showLoadingView();
                            CustomMessage customMessage = new CustomMessage(2016489, f.this.mPageContext.getUniqueId());
                            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2016489, bLv);
                            customResponsedMessage.setOrginalMessage(customMessage);
                            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                        }
                    }
                });
            }
            bvt();
        }
        return this.mContentView;
    }

    public void a(b bVar) {
        this.fWX = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLoadingView() {
        if (this.fEW == null) {
            this.fEW = new com.baidu.tbadk.core.view.a(this.mPageContext);
        }
        this.fEW.setTipString(R.string.loading);
        this.fEW.setDialogVisiable(true);
    }

    public void bLu() {
        if (this.fEW != null) {
            this.fEW.setDialogVisiable(false);
        }
    }

    public void Fj(String str) {
        if (this.mContext != null) {
            this.mFrom = str;
            View view = getView();
            if (view != null && view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            bvt();
            this.mWindowHeight = getWindowMeasuredHeight() - l.getDimens(this.mContext, R.dimen.ds12);
            this.mPopupWindow = new PopupWindow(view, this.mWindowWidth, this.mWindowHeight);
            this.mPopupWindow.setFocusable(true);
            this.mPopupWindow.setTouchable(true);
            this.mPopupWindow.setOnDismissListener(this.fWO);
            UW();
            this.fWD = new PopupWindow(LayoutInflater.from(this.mContext).inflate(R.layout.view_negative_feedback_bottom, (ViewGroup) null), -1, -1);
            if (Build.VERSION.SDK_INT >= 22) {
                this.fWD.setAttachedInDecor(false);
            }
            this.fWD.showAtLocation(this.mAnchor, 0, 0, 0);
            ap.setBackgroundDrawable(this.mPopupWindow, R.drawable.bg_dailog);
            this.mPopupWindow.showAtLocation(this.mAnchor, 17, 0, 0);
            if (this.fWC != null) {
                this.fWC.onNEGFeedbackWindowShow(this.fWw);
            }
            this.fWI = true;
            this.mPageContext.registerListener(this.eOd);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject bLv() {
        int i;
        JSONObject jSONObject = new JSONObject();
        if (this.fWw == null) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        if (y.isEmpty(this.fWx)) {
            i = 0;
        } else {
            i = 0;
            for (int i2 = 0; i2 < this.fWx.size(); i2++) {
                b.a aVar = this.fWx.get(i2);
                if (aVar != null) {
                    jSONArray.put(String.valueOf(aVar.id));
                    i = aVar.index + 1;
                }
            }
        }
        TiebaStatic.log(new ar("c13123").dY("obj_source", this.mFrom).al("obj_type", i));
        if (this.fWX != null) {
            this.fWX.X(jSONArray);
        }
        try {
            jSONObject.put(TiebaInitialize.LogFields.REASON, jSONArray);
            jSONObject.put("thread_ids", this.fWw.bnn());
            jSONObject.put("type", this.fWw.bnm());
            jSONObject.put("forum_id", this.fWw.getFid());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
