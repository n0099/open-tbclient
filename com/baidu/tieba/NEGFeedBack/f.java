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
    private PopupWindow fWB;
    private com.baidu.tieba.NEGFeedBack.b fWF;
    private boolean fWG;
    private LinearLayout fWT;
    private a fWU;
    private b fWV;
    private TextView fWW;
    private TextView fWX;
    private TextView fWY;
    private View fWZ;
    private int fWw;
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
    private at fWu = null;
    private SparseArray<String> fWf = null;
    private List<b.a> fWv = new ArrayList();
    private NEGFeedBackView.a fWA = null;
    private int mSkinType = 3;
    private com.baidu.tbadk.core.view.a fEW = null;
    private CompoundButton.OnCheckedChangeListener fWj = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.NEGFeedBack.f.1
        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (f.this.fWA != null) {
                f.this.fWA.onCheckedChanged(f.this.fWu, compoundButton, z);
            }
            if (compoundButton.getTag() instanceof b.a) {
                b.a aVar = (b.a) compoundButton.getTag();
                if (z) {
                    if (!f.this.fWv.contains(aVar)) {
                        f.this.fWv.add(aVar);
                        return;
                    }
                    return;
                }
                f.this.fWv.remove(aVar);
            }
        }
    };
    private PopupWindow.OnDismissListener fWM = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.NEGFeedBack.f.2
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (f.this.fWB != null) {
                f.this.fWB.dismiss();
                f.this.fWB = null;
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
        this.fWF = new com.baidu.tieba.NEGFeedBack.b(this.mPageContext);
        this.fWF.a(this.fWj);
        this.fWF.lz(true);
    }

    private int getWindowMeasuredHeight() {
        if (this.mContentView == null) {
            return 0;
        }
        this.mContentView.measure(0, 0);
        this.fWw = this.mContentView.getMeasuredHeight() + l.getDimens(this.mContext, R.dimen.ds12);
        return this.fWw;
    }

    public void setData(at atVar) {
        if (atVar != null) {
            this.fWu = atVar;
            this.fWf = atVar.getFeedBackReasonMap();
            if (this.fWf != null && this.fWf.size() > 8) {
                for (int size = this.fWf.size() - 1; size >= 8; size--) {
                    this.fWf.removeAt(size);
                }
            }
            this.fWF.setData(atVar);
        }
    }

    public void setDefaultReasonArray(String[] strArr) {
        this.fWF.setDefaultReasonArray(strArr);
    }

    public void bLp() {
        if (this.mPopupWindow != null) {
            this.mPopupWindow.dismiss();
            this.mPopupWindow = null;
        }
        if (this.fWB != null) {
            this.fWB.dismiss();
            this.fWB = null;
        }
    }

    private void UW() {
        if (this.fWG && this.fWv.size() != 0) {
            this.fWv.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bvt() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            ap.setBackgroundColor(this.mContentView, R.color.CAM_X0205);
            ap.setViewTextColor(this.bPf, R.color.CAM_X0106, 1);
            ap.setViewTextColor(this.fWW, R.color.CAM_X0106, 1);
            ap.setBackgroundColor(this.mTopLine, R.color.CAM_X0204);
            ap.setBackgroundColor(this.fWZ, R.color.CAM_X0204);
            ap.setViewTextColor(this.fWX, R.color.CAM_X0106, 1);
            ap.setViewTextColor(this.fWY, R.color.CAM_X0109, 1);
            this.mSkinType = skinType;
        }
    }

    private View getView() {
        if (this.mContext == null) {
            return null;
        }
        if (this.mContentView == null) {
            this.mContentView = (ViewGroup) LayoutInflater.from(this.mContext).inflate(R.layout.neg_dt_head_popupwindow, (ViewGroup) null);
            this.fWX = (TextView) this.mContentView.findViewById(R.id.head_text);
            this.fWY = (TextView) this.mContentView.findViewById(R.id.sub_head_text);
        }
        View rootView = this.fWF.getRootView();
        if (rootView != null && rootView.getParent() == null) {
            int dimens = l.getDimens(this.mContext, R.dimen.ds40);
            rootView.setPadding(dimens, 0, dimens, 0);
            this.mContentView.addView(rootView);
        }
        if (this.fWT == null) {
            this.fWT = (LinearLayout) LayoutInflater.from(this.mContext).inflate(R.layout.neg_dt_bottom_popupwindow, (ViewGroup) null);
            this.bPf = (TextView) this.fWT.findViewById(R.id.dialog_bottom_cancel_button);
            this.fWW = (TextView) this.fWT.findViewById(R.id.dialog_bottom_certain_button);
            this.mTopLine = this.fWT.findViewById(R.id.top_line);
            this.fWZ = this.fWT.findViewById(R.id.middle_line);
            this.mContentView.addView(this.fWT);
            this.bPf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.NEGFeedBack.f.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (f.this.fWB != null) {
                        f.this.fWB.dismiss();
                        f.this.fWB = null;
                    }
                    if (f.this.mPopupWindow != null) {
                        f.this.mPopupWindow.dismiss();
                        f.this.mPopupWindow = null;
                    }
                    if (f.this.fWU != null) {
                        f.this.fWU.onClick();
                    }
                }
            });
            if (this.fWW != null) {
                this.fWW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.NEGFeedBack.f.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        JSONObject bLu = f.this.bLu();
                        if (f.this.mFrom == "3" || f.this.mFrom == "4" || f.this.mFrom == "1") {
                            f.this.bLp();
                        } else if (bLu != null) {
                            f.this.showLoadingView();
                            CustomMessage customMessage = new CustomMessage(2016489, f.this.mPageContext.getUniqueId());
                            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2016489, bLu);
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
        this.fWV = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLoadingView() {
        if (this.fEW == null) {
            this.fEW = new com.baidu.tbadk.core.view.a(this.mPageContext);
        }
        this.fEW.setTipString(R.string.loading);
        this.fEW.setDialogVisiable(true);
    }

    public void bLt() {
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
            this.mPopupWindow.setOnDismissListener(this.fWM);
            UW();
            this.fWB = new PopupWindow(LayoutInflater.from(this.mContext).inflate(R.layout.view_negative_feedback_bottom, (ViewGroup) null), -1, -1);
            if (Build.VERSION.SDK_INT >= 22) {
                this.fWB.setAttachedInDecor(false);
            }
            this.fWB.showAtLocation(this.mAnchor, 0, 0, 0);
            ap.setBackgroundDrawable(this.mPopupWindow, R.drawable.bg_dailog);
            this.mPopupWindow.showAtLocation(this.mAnchor, 17, 0, 0);
            if (this.fWA != null) {
                this.fWA.onNEGFeedbackWindowShow(this.fWu);
            }
            this.fWG = true;
            this.mPageContext.registerListener(this.eOd);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject bLu() {
        int i;
        JSONObject jSONObject = new JSONObject();
        if (this.fWu == null) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        if (y.isEmpty(this.fWv)) {
            i = 0;
        } else {
            i = 0;
            for (int i2 = 0; i2 < this.fWv.size(); i2++) {
                b.a aVar = this.fWv.get(i2);
                if (aVar != null) {
                    jSONArray.put(String.valueOf(aVar.id));
                    i = aVar.index + 1;
                }
            }
        }
        TiebaStatic.log(new ar("c13123").dY("obj_source", this.mFrom).al("obj_type", i));
        if (this.fWV != null) {
            this.fWV.X(jSONArray);
        }
        try {
            jSONObject.put(TiebaInitialize.LogFields.REASON, jSONArray);
            jSONObject.put("thread_ids", this.fWu.bnn());
            jSONObject.put("type", this.fWu.bnm());
            jSONObject.put("forum_id", this.fWu.getFid());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
