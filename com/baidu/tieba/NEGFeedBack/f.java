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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.NEGFeedBack.b;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class f {
    private TextView bPx;
    private PopupWindow gbA;
    private com.baidu.tieba.NEGFeedBack.b gbE;
    private boolean gbF;
    private LinearLayout gbS;
    private a gbT;
    private b gbU;
    private TextView gbV;
    private TextView gbW;
    private TextView gbX;
    private View gbY;
    private int gbv;
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
    private at gbt = null;
    private SparseArray<String> gbe = null;
    private List<b.a> gbu = new ArrayList();
    private NEGFeedBackView.a gbz = null;
    private int mSkinType = 3;
    private com.baidu.tbadk.core.view.a fJT = null;
    private CompoundButton.OnCheckedChangeListener gbi = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.NEGFeedBack.f.1
        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (f.this.gbz != null) {
                f.this.gbz.onCheckedChanged(f.this.gbt, compoundButton, z);
            }
            if (compoundButton.getTag() instanceof b.a) {
                b.a aVar = (b.a) compoundButton.getTag();
                if (z) {
                    if (!f.this.gbu.contains(aVar)) {
                        f.this.gbu.add(aVar);
                        return;
                    }
                    return;
                }
                f.this.gbu.remove(aVar);
            }
        }
    };
    private PopupWindow.OnDismissListener gbL = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.NEGFeedBack.f.2
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (f.this.gbA != null) {
                f.this.gbA.dismiss();
                f.this.gbA = null;
                MessageManager.getInstance().unRegisterListener(f.this.eTp);
            }
        }
    };
    private CustomMessageListener eTp = new CustomMessageListener(CmdConfigCustom.CMD_SKIN_TYPE_CHANGE) { // from class: com.baidu.tieba.NEGFeedBack.f.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001304 && (customResponsedMessage.getData() instanceof Integer)) {
                f.this.btV();
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void onClick();
    }

    /* loaded from: classes.dex */
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
        this.gbE = new com.baidu.tieba.NEGFeedBack.b(this.mPageContext);
        this.gbE.a(this.gbi);
        this.gbE.lS(true);
    }

    private int getWindowMeasuredHeight() {
        if (this.mContentView == null) {
            return 0;
        }
        this.mContentView.measure(0, 0);
        this.gbv = this.mContentView.getMeasuredHeight() + l.getDimens(this.mContext, R.dimen.ds12);
        return this.gbv;
    }

    public void setData(at atVar) {
        if (atVar != null) {
            this.gbt = atVar;
            this.gbe = atVar.getFeedBackReasonMap();
            if (this.gbe != null && this.gbe.size() > 8) {
                for (int size = this.gbe.size() - 1; size >= 8; size--) {
                    this.gbe.removeAt(size);
                }
            }
            this.gbE.setData(atVar);
        }
    }

    public void setDefaultReasonArray(String[] strArr) {
        this.gbE.setDefaultReasonArray(strArr);
    }

    public void bJR() {
        if (this.mPopupWindow != null) {
            this.mPopupWindow.dismiss();
            this.mPopupWindow = null;
        }
        if (this.gbA != null) {
            this.gbA.dismiss();
            this.gbA = null;
        }
    }

    private void Si() {
        if (this.gbF && this.gbu.size() != 0) {
            this.gbu.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btV() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            ao.setBackgroundColor(this.mContentView, R.color.CAM_X0205);
            ao.setViewTextColor(this.bPx, R.color.CAM_X0106, 1);
            ao.setViewTextColor(this.gbV, R.color.CAM_X0106, 1);
            ao.setBackgroundColor(this.mTopLine, R.color.CAM_X0204);
            ao.setBackgroundColor(this.gbY, R.color.CAM_X0204);
            ao.setViewTextColor(this.gbW, R.color.CAM_X0106, 1);
            ao.setViewTextColor(this.gbX, R.color.CAM_X0109, 1);
            this.mSkinType = skinType;
        }
    }

    private View getView() {
        if (this.mContext == null) {
            return null;
        }
        if (this.mContentView == null) {
            this.mContentView = (ViewGroup) LayoutInflater.from(this.mContext).inflate(R.layout.neg_dt_head_popupwindow, (ViewGroup) null);
            this.gbW = (TextView) this.mContentView.findViewById(R.id.head_text);
            this.gbX = (TextView) this.mContentView.findViewById(R.id.sub_head_text);
        }
        View rootView = this.gbE.getRootView();
        if (rootView != null && rootView.getParent() == null) {
            int dimens = l.getDimens(this.mContext, R.dimen.ds40);
            rootView.setPadding(dimens, 0, dimens, 0);
            this.mContentView.addView(rootView);
        }
        if (this.gbS == null) {
            this.gbS = (LinearLayout) LayoutInflater.from(this.mContext).inflate(R.layout.neg_dt_bottom_popupwindow, (ViewGroup) null);
            this.bPx = (TextView) this.gbS.findViewById(R.id.dialog_bottom_cancel_button);
            this.gbV = (TextView) this.gbS.findViewById(R.id.dialog_bottom_certain_button);
            this.mTopLine = this.gbS.findViewById(R.id.top_line);
            this.gbY = this.gbS.findViewById(R.id.middle_line);
            this.mContentView.addView(this.gbS);
            this.bPx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.NEGFeedBack.f.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (f.this.gbA != null) {
                        f.this.gbA.dismiss();
                        f.this.gbA = null;
                    }
                    if (f.this.mPopupWindow != null) {
                        f.this.mPopupWindow.dismiss();
                        f.this.mPopupWindow = null;
                    }
                    if (f.this.gbT != null) {
                        f.this.gbT.onClick();
                    }
                }
            });
            if (this.gbV != null) {
                this.gbV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.NEGFeedBack.f.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        JSONObject bJW = f.this.bJW();
                        if (f.this.mFrom == "3" || f.this.mFrom == "4" || f.this.mFrom == "1") {
                            f.this.bJR();
                        } else if (bJW != null) {
                            f.this.showLoadingView();
                            CustomMessage customMessage = new CustomMessage(2016489, f.this.mPageContext.getUniqueId());
                            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2016489, bJW);
                            customResponsedMessage.setOrginalMessage(customMessage);
                            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                        }
                    }
                });
            }
            btV();
        }
        return this.mContentView;
    }

    public void a(b bVar) {
        this.gbU = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLoadingView() {
        if (this.fJT == null) {
            this.fJT = new com.baidu.tbadk.core.view.a(this.mPageContext);
        }
        this.fJT.setTipString(R.string.loading);
        this.fJT.setDialogVisiable(true);
    }

    public void bJV() {
        if (this.fJT != null) {
            this.fJT.setDialogVisiable(false);
        }
    }

    public void DV(String str) {
        if (this.mContext != null) {
            this.mFrom = str;
            View view = getView();
            if (view != null && view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            btV();
            this.mWindowHeight = getWindowMeasuredHeight() - l.getDimens(this.mContext, R.dimen.ds12);
            this.mPopupWindow = new PopupWindow(view, this.mWindowWidth, this.mWindowHeight);
            this.mPopupWindow.setFocusable(true);
            this.mPopupWindow.setTouchable(true);
            this.mPopupWindow.setOnDismissListener(this.gbL);
            Si();
            this.gbA = new PopupWindow(LayoutInflater.from(this.mContext).inflate(R.layout.view_negative_feedback_bottom, (ViewGroup) null), -1, -1);
            if (Build.VERSION.SDK_INT >= 22) {
                this.gbA.setAttachedInDecor(false);
            }
            this.gbA.showAtLocation(this.mAnchor, 0, 0, 0);
            ao.setBackgroundDrawable(this.mPopupWindow, R.drawable.bg_dailog);
            this.mPopupWindow.showAtLocation(this.mAnchor, 17, 0, 0);
            if (this.gbz != null) {
                this.gbz.onNEGFeedbackWindowShow(this.gbt);
            }
            this.gbF = true;
            this.mPageContext.registerListener(this.eTp);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject bJW() {
        int i;
        JSONObject jSONObject = new JSONObject();
        if (this.gbt == null) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        if (x.isEmpty(this.gbu)) {
            i = 0;
        } else {
            i = 0;
            for (int i2 = 0; i2 < this.gbu.size(); i2++) {
                b.a aVar = this.gbu.get(i2);
                if (aVar != null) {
                    jSONArray.put(String.valueOf(aVar.id));
                    i = aVar.index + 1;
                }
            }
        }
        TiebaStatic.log(new aq("c13123").dW("obj_source", this.mFrom).an("obj_type", i));
        if (this.gbU != null) {
            this.gbU.X(jSONArray);
        }
        try {
            jSONObject.put(TiebaInitialize.LogFields.REASON, jSONArray);
            jSONObject.put("thread_ids", this.gbt.blT());
            jSONObject.put("type", this.gbt.blS());
            jSONObject.put("forum_id", this.gbt.getFid());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
