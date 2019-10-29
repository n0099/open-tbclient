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
import com.baidu.tbadk.core.data.aj;
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
/* loaded from: classes3.dex */
public class e {
    private TextView asl;
    private int dcU;
    private int dcV;
    private PopupWindow dcZ;
    private com.baidu.tieba.NEGFeedBack.b ddc;
    private boolean ddd;
    private LinearLayout ddl;
    private a ddm;
    private b ddn;
    private TextView ddo;
    private TextView ddp;
    private TextView ddq;
    private View ddr;
    private View mAnchor;
    private ViewGroup mContentView;
    private Context mContext;
    private String mFrom;
    private TbPageContext mPageContext;
    private View mTopLine;
    private int mWindowHeight;
    private int mXOffset;
    private PopupWindow mPopupWindow = null;
    private aj dcS = null;
    private SparseArray<String> dcE = null;
    private List<b.a> dcT = new ArrayList();
    private NEGFeedBackView.a dcY = null;
    private int mSkinType = 3;
    private com.baidu.tbadk.core.view.b cOA = null;
    private CompoundButton.OnCheckedChangeListener dcH = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.NEGFeedBack.e.1
        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (e.this.dcY != null) {
                e.this.dcY.a(e.this.dcS, compoundButton, z);
            }
            if (compoundButton.getTag() instanceof b.a) {
                b.a aVar = (b.a) compoundButton.getTag();
                if (z) {
                    if (!e.this.dcT.contains(aVar)) {
                        e.this.dcT.add(aVar);
                        return;
                    }
                    return;
                }
                e.this.dcT.remove(aVar);
            }
        }
    };
    private PopupWindow.OnDismissListener ddg = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.NEGFeedBack.e.2
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (e.this.dcZ != null) {
                e.this.dcZ.dismiss();
                e.this.dcZ = null;
            }
        }
    };

    /* loaded from: classes3.dex */
    public interface a {
        void onClick();
    }

    /* loaded from: classes3.dex */
    public interface b {
        void K(JSONArray jSONArray);
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
        this.dcU = l.getEquipmentWidth(this.mContext) - (this.mXOffset * 2);
        this.ddc = new com.baidu.tieba.NEGFeedBack.b(this.mPageContext);
        this.ddc.a(this.dcH);
        this.ddc.fW(true);
    }

    private int getWindowMeasuredHeight() {
        if (this.mContentView == null) {
            return 0;
        }
        this.mContentView.measure(0, 0);
        this.dcV = this.mContentView.getMeasuredHeight() + l.getDimens(this.mContext, R.dimen.ds12);
        return this.dcV;
    }

    public void setData(aj ajVar) {
        if (ajVar != null) {
            this.dcS = ajVar;
            this.dcE = ajVar.getFeedBackReasonMap();
            if (this.dcE != null && this.dcE.size() > 8) {
                for (int size = this.dcE.size() - 1; size >= 8; size--) {
                    this.dcE.removeAt(size);
                }
            }
            this.ddc.setData(ajVar);
        }
    }

    public void setDefaultReasonArray(String[] strArr) {
        this.ddc.setDefaultReasonArray(strArr);
    }

    public void aBO() {
        if (this.mPopupWindow != null) {
            this.mPopupWindow.dismiss();
            this.mPopupWindow = null;
        }
        if (this.dcZ != null) {
            this.dcZ.dismiss();
            this.dcZ = null;
        }
    }

    private void vf() {
        if (this.ddd && this.dcT.size() != 0) {
            this.dcT.clear();
        }
    }

    private void anO() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            am.setViewTextColor(this.asl, R.color.cp_cont_f, 1);
            am.setViewTextColor(this.ddo, R.color.cp_cont_f, 1);
            am.setBackgroundColor(this.mTopLine, R.color.cp_bg_line_c);
            am.setBackgroundColor(this.ddr, R.color.cp_bg_line_c);
            am.setViewTextColor(this.ddp, R.color.cp_cont_f, 1);
            am.setViewTextColor(this.ddq, R.color.cp_cont_d, 1);
            this.mSkinType = skinType;
        }
    }

    private View getView() {
        if (this.mContext == null) {
            return null;
        }
        if (this.mContentView == null) {
            this.mContentView = (ViewGroup) LayoutInflater.from(this.mContext).inflate(R.layout.neg_dt_head_popupwindow, (ViewGroup) null);
            this.ddp = (TextView) this.mContentView.findViewById(R.id.head_text);
            this.ddq = (TextView) this.mContentView.findViewById(R.id.sub_head_text);
        }
        View rootView = this.ddc.getRootView();
        if (rootView != null && rootView.getParent() == null) {
            int dimens = l.getDimens(this.mContext, R.dimen.ds40);
            rootView.setPadding(dimens, 0, dimens, 0);
            this.mContentView.addView(rootView);
        }
        if (this.ddl == null) {
            this.ddl = (LinearLayout) LayoutInflater.from(this.mContext).inflate(R.layout.neg_dt_bottom_popupwindow, (ViewGroup) null);
            this.asl = (TextView) this.ddl.findViewById(R.id.dialog_bottom_cancel_button);
            this.ddo = (TextView) this.ddl.findViewById(R.id.dialog_bottom_certain_button);
            this.mTopLine = this.ddl.findViewById(R.id.top_line);
            this.ddr = this.ddl.findViewById(R.id.middle_line);
            this.mContentView.addView(this.ddl);
            this.asl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.NEGFeedBack.e.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (e.this.dcZ != null) {
                        e.this.dcZ.dismiss();
                        e.this.dcZ = null;
                    }
                    if (e.this.mPopupWindow != null) {
                        e.this.mPopupWindow.dismiss();
                        e.this.mPopupWindow = null;
                    }
                    if (e.this.ddm != null) {
                        e.this.ddm.onClick();
                    }
                }
            });
            if (this.ddo != null) {
                this.ddo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.NEGFeedBack.e.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        JSONObject aBT = e.this.aBT();
                        if (e.this.mFrom == "3" || e.this.mFrom == "4" || e.this.mFrom == "1") {
                            e.this.aBO();
                        } else if (aBT != null) {
                            e.this.showLoadingView();
                            CustomMessage customMessage = new CustomMessage(2016489, e.this.mPageContext.getUniqueId());
                            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2016489, aBT);
                            customResponsedMessage.setOrginalMessage(customMessage);
                            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                        }
                    }
                });
            }
            anO();
        }
        return this.mContentView;
    }

    public void a(b bVar) {
        this.ddn = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLoadingView() {
        if (this.cOA == null) {
            this.cOA = new com.baidu.tbadk.core.view.b(this.mPageContext);
        }
        this.cOA.setTipString(R.string.loading);
        this.cOA.setDialogVisiable(true);
    }

    public void aBS() {
        if (this.cOA != null) {
            this.cOA.setDialogVisiable(false);
        }
    }

    public void qE(String str) {
        if (this.mContext != null) {
            this.mFrom = str;
            View view = getView();
            if (view != null && view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            anO();
            this.mWindowHeight = getWindowMeasuredHeight() - l.getDimens(this.mContext, R.dimen.ds12);
            this.mPopupWindow = new PopupWindow(view, this.dcU, this.mWindowHeight);
            this.mPopupWindow.setFocusable(true);
            this.mPopupWindow.setTouchable(true);
            this.mPopupWindow.setOnDismissListener(this.ddg);
            vf();
            this.dcZ = new PopupWindow(LayoutInflater.from(this.mContext).inflate(R.layout.view_negative_feedback_bottom, (ViewGroup) null), -1, -1);
            if (Build.VERSION.SDK_INT >= 22) {
                this.dcZ.setAttachedInDecor(false);
            }
            this.dcZ.showAtLocation(this.mAnchor, 0, 0, 0);
            am.setBackgroundDrawable(this.mPopupWindow, R.drawable.bg_dailog);
            this.mPopupWindow.showAtLocation(this.mAnchor, 17, 0, 0);
            if (this.dcY != null) {
                this.dcY.b(this.dcS);
            }
            this.ddd = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject aBT() {
        int i;
        JSONObject jSONObject = new JSONObject();
        if (this.dcS == null) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        if (v.isEmpty(this.dcT)) {
            i = 0;
        } else {
            i = 0;
            for (int i2 = 0; i2 < this.dcT.size(); i2++) {
                b.a aVar = this.dcT.get(i2);
                if (aVar != null) {
                    jSONArray.put(String.valueOf(aVar.id));
                    i = aVar.index + 1;
                }
            }
        }
        TiebaStatic.log(new an("c13123").bS("obj_source", this.mFrom).O("obj_type", i));
        if (this.ddn != null) {
            this.ddn.K(jSONArray);
        }
        try {
            jSONObject.put(TiebaInitialize.LogFields.REASON, jSONArray);
            jSONObject.put("thread_ids", this.dcS.ahs());
            jSONObject.put("type", this.dcS.ahr());
            jSONObject.put("forum_id", this.dcS.getFid());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
