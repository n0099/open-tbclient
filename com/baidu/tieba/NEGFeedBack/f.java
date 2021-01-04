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
    private TextView bUj;
    private LinearLayout ggB;
    private a ggC;
    private b ggD;
    private TextView ggE;
    private TextView ggF;
    private TextView ggG;
    private View ggH;
    private int gge;
    private PopupWindow ggj;
    private com.baidu.tieba.NEGFeedBack.b ggn;
    private boolean ggo;
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
    private at ggc = null;
    private SparseArray<String> gfN = null;
    private List<b.a> ggd = new ArrayList();
    private NEGFeedBackView.a ggi = null;
    private int mSkinType = 3;
    private com.baidu.tbadk.core.view.a fOA = null;
    private CompoundButton.OnCheckedChangeListener gfR = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.NEGFeedBack.f.1
        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (f.this.ggi != null) {
                f.this.ggi.onCheckedChanged(f.this.ggc, compoundButton, z);
            }
            if (compoundButton.getTag() instanceof b.a) {
                b.a aVar = (b.a) compoundButton.getTag();
                if (z) {
                    if (!f.this.ggd.contains(aVar)) {
                        f.this.ggd.add(aVar);
                        return;
                    }
                    return;
                }
                f.this.ggd.remove(aVar);
            }
        }
    };
    private PopupWindow.OnDismissListener ggu = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.NEGFeedBack.f.2
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (f.this.ggj != null) {
                f.this.ggj.dismiss();
                f.this.ggj = null;
                MessageManager.getInstance().unRegisterListener(f.this.eYa);
            }
        }
    };
    private CustomMessageListener eYa = new CustomMessageListener(CmdConfigCustom.CMD_SKIN_TYPE_CHANGE) { // from class: com.baidu.tieba.NEGFeedBack.f.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001304 && (customResponsedMessage.getData() instanceof Integer)) {
                f.this.bxO();
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
        this.ggn = new com.baidu.tieba.NEGFeedBack.b(this.mPageContext);
        this.ggn.a(this.gfR);
        this.ggn.lW(true);
    }

    private int getWindowMeasuredHeight() {
        if (this.mContentView == null) {
            return 0;
        }
        this.mContentView.measure(0, 0);
        this.gge = this.mContentView.getMeasuredHeight() + l.getDimens(this.mContext, R.dimen.ds12);
        return this.gge;
    }

    public void setData(at atVar) {
        if (atVar != null) {
            this.ggc = atVar;
            this.gfN = atVar.getFeedBackReasonMap();
            if (this.gfN != null && this.gfN.size() > 8) {
                for (int size = this.gfN.size() - 1; size >= 8; size--) {
                    this.gfN.removeAt(size);
                }
            }
            this.ggn.setData(atVar);
        }
    }

    public void setDefaultReasonArray(String[] strArr) {
        this.ggn.setDefaultReasonArray(strArr);
    }

    public void bNI() {
        if (this.mPopupWindow != null) {
            this.mPopupWindow.dismiss();
            this.mPopupWindow = null;
        }
        if (this.ggj != null) {
            this.ggj.dismiss();
            this.ggj = null;
        }
    }

    private void Wb() {
        if (this.ggo && this.ggd.size() != 0) {
            this.ggd.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bxO() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            ao.setBackgroundColor(this.mContentView, R.color.CAM_X0205);
            ao.setViewTextColor(this.bUj, R.color.CAM_X0106, 1);
            ao.setViewTextColor(this.ggE, R.color.CAM_X0106, 1);
            ao.setBackgroundColor(this.mTopLine, R.color.CAM_X0204);
            ao.setBackgroundColor(this.ggH, R.color.CAM_X0204);
            ao.setViewTextColor(this.ggF, R.color.CAM_X0106, 1);
            ao.setViewTextColor(this.ggG, R.color.CAM_X0109, 1);
            this.mSkinType = skinType;
        }
    }

    private View getView() {
        if (this.mContext == null) {
            return null;
        }
        if (this.mContentView == null) {
            this.mContentView = (ViewGroup) LayoutInflater.from(this.mContext).inflate(R.layout.neg_dt_head_popupwindow, (ViewGroup) null);
            this.ggF = (TextView) this.mContentView.findViewById(R.id.head_text);
            this.ggG = (TextView) this.mContentView.findViewById(R.id.sub_head_text);
        }
        View rootView = this.ggn.getRootView();
        if (rootView != null && rootView.getParent() == null) {
            int dimens = l.getDimens(this.mContext, R.dimen.ds40);
            rootView.setPadding(dimens, 0, dimens, 0);
            this.mContentView.addView(rootView);
        }
        if (this.ggB == null) {
            this.ggB = (LinearLayout) LayoutInflater.from(this.mContext).inflate(R.layout.neg_dt_bottom_popupwindow, (ViewGroup) null);
            this.bUj = (TextView) this.ggB.findViewById(R.id.dialog_bottom_cancel_button);
            this.ggE = (TextView) this.ggB.findViewById(R.id.dialog_bottom_certain_button);
            this.mTopLine = this.ggB.findViewById(R.id.top_line);
            this.ggH = this.ggB.findViewById(R.id.middle_line);
            this.mContentView.addView(this.ggB);
            this.bUj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.NEGFeedBack.f.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (f.this.ggj != null) {
                        f.this.ggj.dismiss();
                        f.this.ggj = null;
                    }
                    if (f.this.mPopupWindow != null) {
                        f.this.mPopupWindow.dismiss();
                        f.this.mPopupWindow = null;
                    }
                    if (f.this.ggC != null) {
                        f.this.ggC.onClick();
                    }
                }
            });
            if (this.ggE != null) {
                this.ggE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.NEGFeedBack.f.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        JSONObject bNN = f.this.bNN();
                        if (f.this.mFrom == "3" || f.this.mFrom == "4" || f.this.mFrom == "1") {
                            f.this.bNI();
                        } else if (bNN != null) {
                            f.this.showLoadingView();
                            CustomMessage customMessage = new CustomMessage(2016489, f.this.mPageContext.getUniqueId());
                            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2016489, bNN);
                            customResponsedMessage.setOrginalMessage(customMessage);
                            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                        }
                    }
                });
            }
            bxO();
        }
        return this.mContentView;
    }

    public void a(b bVar) {
        this.ggD = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLoadingView() {
        if (this.fOA == null) {
            this.fOA = new com.baidu.tbadk.core.view.a(this.mPageContext);
        }
        this.fOA.setTipString(R.string.loading);
        this.fOA.setDialogVisiable(true);
    }

    public void bNM() {
        if (this.fOA != null) {
            this.fOA.setDialogVisiable(false);
        }
    }

    public void Fh(String str) {
        if (this.mContext != null) {
            this.mFrom = str;
            View view = getView();
            if (view != null && view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            bxO();
            this.mWindowHeight = getWindowMeasuredHeight() - l.getDimens(this.mContext, R.dimen.ds12);
            this.mPopupWindow = new PopupWindow(view, this.mWindowWidth, this.mWindowHeight);
            this.mPopupWindow.setFocusable(true);
            this.mPopupWindow.setTouchable(true);
            this.mPopupWindow.setOnDismissListener(this.ggu);
            Wb();
            this.ggj = new PopupWindow(LayoutInflater.from(this.mContext).inflate(R.layout.view_negative_feedback_bottom, (ViewGroup) null), -1, -1);
            if (Build.VERSION.SDK_INT >= 22) {
                this.ggj.setAttachedInDecor(false);
            }
            this.ggj.showAtLocation(this.mAnchor, 0, 0, 0);
            ao.setBackgroundDrawable(this.mPopupWindow, R.drawable.bg_dailog);
            this.mPopupWindow.showAtLocation(this.mAnchor, 17, 0, 0);
            if (this.ggi != null) {
                this.ggi.onNEGFeedbackWindowShow(this.ggc);
            }
            this.ggo = true;
            this.mPageContext.registerListener(this.eYa);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject bNN() {
        int i;
        JSONObject jSONObject = new JSONObject();
        if (this.ggc == null) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        if (x.isEmpty(this.ggd)) {
            i = 0;
        } else {
            i = 0;
            for (int i2 = 0; i2 < this.ggd.size(); i2++) {
                b.a aVar = this.ggd.get(i2);
                if (aVar != null) {
                    jSONArray.put(String.valueOf(aVar.id));
                    i = aVar.index + 1;
                }
            }
        }
        TiebaStatic.log(new aq("c13123").dX("obj_source", this.mFrom).an("obj_type", i));
        if (this.ggD != null) {
            this.ggD.X(jSONArray);
        }
        try {
            jSONObject.put(TiebaInitialize.LogFields.REASON, jSONArray);
            jSONObject.put("thread_ids", this.ggc.bpM());
            jSONObject.put("type", this.ggc.bpL());
            jSONObject.put("forum_id", this.ggc.getFid());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
