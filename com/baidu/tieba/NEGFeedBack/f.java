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
import com.baidu.tbadk.core.data.av;
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
/* loaded from: classes.dex */
public class f {
    private TextView bTn;
    private int gdP;
    private PopupWindow gdU;
    private com.baidu.tieba.NEGFeedBack.b gdY;
    private boolean gdZ;
    private LinearLayout gem;
    private a gen;
    private b gep;
    private TextView geq;
    private TextView ger;
    private TextView ges;
    private View get;
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
    private av gdN = null;
    private SparseArray<String> gdy = null;
    private List<b.a> gdO = new ArrayList();
    private NEGFeedBackView.a gdT = null;
    private int mSkinType = 3;
    private com.baidu.tbadk.core.view.a fMe = null;
    private CompoundButton.OnCheckedChangeListener gdC = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.NEGFeedBack.f.1
        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (f.this.gdT != null) {
                f.this.gdT.onCheckedChanged(f.this.gdN, compoundButton, z);
            }
            if (compoundButton.getTag() instanceof b.a) {
                b.a aVar = (b.a) compoundButton.getTag();
                if (z) {
                    if (!f.this.gdO.contains(aVar)) {
                        f.this.gdO.add(aVar);
                        return;
                    }
                    return;
                }
                f.this.gdO.remove(aVar);
            }
        }
    };
    private PopupWindow.OnDismissListener gef = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.NEGFeedBack.f.2
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (f.this.gdU != null) {
                f.this.gdU.dismiss();
                f.this.gdU = null;
                MessageManager.getInstance().unRegisterListener(f.this.eVF);
            }
        }
    };
    private CustomMessageListener eVF = new CustomMessageListener(CmdConfigCustom.CMD_SKIN_TYPE_CHANGE) { // from class: com.baidu.tieba.NEGFeedBack.f.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001304 && (customResponsedMessage.getData() instanceof Integer)) {
                f.this.bup();
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void onClick();
    }

    /* loaded from: classes.dex */
    public interface b {
        void W(JSONArray jSONArray);
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
        this.gdY = new com.baidu.tieba.NEGFeedBack.b(this.mPageContext);
        this.gdY.a(this.gdC);
        this.gdY.lW(true);
    }

    private int getWindowMeasuredHeight() {
        if (this.mContentView == null) {
            return 0;
        }
        this.mContentView.measure(0, 0);
        this.gdP = this.mContentView.getMeasuredHeight() + l.getDimens(this.mContext, R.dimen.ds12);
        return this.gdP;
    }

    public void setData(av avVar) {
        if (avVar != null) {
            this.gdN = avVar;
            this.gdy = avVar.getFeedBackReasonMap();
            if (this.gdy != null && this.gdy.size() > 8) {
                for (int size = this.gdy.size() - 1; size >= 8; size--) {
                    this.gdy.removeAt(size);
                }
            }
            this.gdY.setData(avVar);
        }
    }

    public void setDefaultReasonArray(String[] strArr) {
        this.gdY.setDefaultReasonArray(strArr);
    }

    public void bKq() {
        if (this.mPopupWindow != null) {
            this.mPopupWindow.dismiss();
            this.mPopupWindow = null;
        }
        if (this.gdU != null) {
            this.gdU.dismiss();
            this.gdU = null;
        }
    }

    private void TP() {
        if (this.gdZ && this.gdO.size() != 0) {
            this.gdO.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bup() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            ap.setBackgroundColor(this.mContentView, R.color.CAM_X0205);
            ap.setViewTextColor(this.bTn, R.color.CAM_X0106, 1);
            ap.setViewTextColor(this.geq, R.color.CAM_X0106, 1);
            ap.setBackgroundColor(this.mTopLine, R.color.CAM_X0204);
            ap.setBackgroundColor(this.get, R.color.CAM_X0204);
            ap.setViewTextColor(this.ger, R.color.CAM_X0106, 1);
            ap.setViewTextColor(this.ges, R.color.CAM_X0109, 1);
            this.mSkinType = skinType;
        }
    }

    private View getView() {
        if (this.mContext == null) {
            return null;
        }
        if (this.mContentView == null) {
            this.mContentView = (ViewGroup) LayoutInflater.from(this.mContext).inflate(R.layout.neg_dt_head_popupwindow, (ViewGroup) null);
            this.ger = (TextView) this.mContentView.findViewById(R.id.head_text);
            this.ges = (TextView) this.mContentView.findViewById(R.id.sub_head_text);
        }
        View rootView = this.gdY.getRootView();
        if (rootView != null && rootView.getParent() == null) {
            int dimens = l.getDimens(this.mContext, R.dimen.ds40);
            rootView.setPadding(dimens, 0, dimens, 0);
            this.mContentView.addView(rootView);
        }
        if (this.gem == null) {
            this.gem = (LinearLayout) LayoutInflater.from(this.mContext).inflate(R.layout.neg_dt_bottom_popupwindow, (ViewGroup) null);
            this.bTn = (TextView) this.gem.findViewById(R.id.dialog_bottom_cancel_button);
            this.geq = (TextView) this.gem.findViewById(R.id.dialog_bottom_certain_button);
            this.mTopLine = this.gem.findViewById(R.id.top_line);
            this.get = this.gem.findViewById(R.id.middle_line);
            this.mContentView.addView(this.gem);
            this.bTn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.NEGFeedBack.f.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (f.this.gdU != null) {
                        f.this.gdU.dismiss();
                        f.this.gdU = null;
                    }
                    if (f.this.mPopupWindow != null) {
                        f.this.mPopupWindow.dismiss();
                        f.this.mPopupWindow = null;
                    }
                    if (f.this.gen != null) {
                        f.this.gen.onClick();
                    }
                }
            });
            if (this.geq != null) {
                this.geq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.NEGFeedBack.f.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        JSONObject bKv = f.this.bKv();
                        if (f.this.mFrom == "3" || f.this.mFrom == "4" || f.this.mFrom == "1") {
                            f.this.bKq();
                        } else if (bKv != null) {
                            f.this.showLoadingView();
                            CustomMessage customMessage = new CustomMessage(2016489, f.this.mPageContext.getUniqueId());
                            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2016489, bKv);
                            customResponsedMessage.setOrginalMessage(customMessage);
                            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                        }
                    }
                });
            }
            bup();
        }
        return this.mContentView;
    }

    public void a(b bVar) {
        this.gep = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLoadingView() {
        if (this.fMe == null) {
            this.fMe = new com.baidu.tbadk.core.view.a(this.mPageContext);
        }
        this.fMe.setTipString(R.string.loading);
        this.fMe.setDialogVisiable(true);
    }

    public void bKu() {
        if (this.fMe != null) {
            this.fMe.setDialogVisiable(false);
        }
    }

    public void Er(String str) {
        if (this.mContext != null) {
            this.mFrom = str;
            View view = getView();
            if (view != null && view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            bup();
            this.mWindowHeight = getWindowMeasuredHeight() - l.getDimens(this.mContext, R.dimen.ds12);
            this.mPopupWindow = new PopupWindow(view, this.mWindowWidth, this.mWindowHeight);
            this.mPopupWindow.setFocusable(true);
            this.mPopupWindow.setTouchable(true);
            this.mPopupWindow.setOnDismissListener(this.gef);
            TP();
            this.gdU = new PopupWindow(LayoutInflater.from(this.mContext).inflate(R.layout.view_negative_feedback_bottom, (ViewGroup) null), -1, -1);
            if (Build.VERSION.SDK_INT >= 22) {
                this.gdU.setAttachedInDecor(false);
            }
            this.gdU.showAtLocation(this.mAnchor, 0, 0, 0);
            ap.setBackgroundDrawable(this.mPopupWindow, R.drawable.bg_dailog);
            this.mPopupWindow.showAtLocation(this.mAnchor, 17, 0, 0);
            if (this.gdT != null) {
                this.gdT.onNEGFeedbackWindowShow(this.gdN);
            }
            this.gdZ = true;
            this.mPageContext.registerListener(this.eVF);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject bKv() {
        int i;
        JSONObject jSONObject = new JSONObject();
        if (this.gdN == null) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        if (y.isEmpty(this.gdO)) {
            i = 0;
        } else {
            i = 0;
            for (int i2 = 0; i2 < this.gdO.size(); i2++) {
                b.a aVar = this.gdO.get(i2);
                if (aVar != null) {
                    jSONArray.put(String.valueOf(aVar.id));
                    i = aVar.index + 1;
                }
            }
        }
        TiebaStatic.log(new ar("c13123").dR("obj_source", this.mFrom).ap("obj_type", i));
        if (this.gep != null) {
            this.gep.W(jSONArray);
        }
        try {
            jSONObject.put(TiebaInitialize.LogFields.REASON, jSONArray);
            jSONObject.put("thread_ids", this.gdN.bmm());
            jSONObject.put("type", this.gdN.bml());
            jSONObject.put("forum_id", this.gdN.getFid());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
