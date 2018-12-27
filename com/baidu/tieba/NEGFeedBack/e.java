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
import com.baidu.searchbox.ng.ai.apps.network.WebSocketAction;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.data.ah;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.NEGFeedBack.b;
import com.baidu.tieba.e;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class e {
    private int bwX;
    private int bwY;
    private PopupWindow bxb;
    private com.baidu.tieba.NEGFeedBack.b bxe;
    private boolean bxf;
    private LinearLayout bxm;
    private a bxn;
    private b bxo;
    private TextView bxp;
    private TextView bxq;
    private TextView bxr;
    private TextView bxs;
    private View bxt;
    private View mAnchor;
    private ViewGroup mContentView;
    private Context mContext;
    private String mFrom;
    private TbPageContext mPageContext;
    private View mTopLine;
    private int mWindowHeight;
    private int mXOffset;
    private PopupWindow mPopupWindow = null;
    private ah bwV = null;
    private SparseArray<String> bwJ = null;
    private List<b.a> bwW = new ArrayList();
    private NEGFeedBackView.a bxa = null;
    private int mSkinType = 3;
    private com.baidu.tbadk.core.view.d bif = null;
    private CompoundButton.OnCheckedChangeListener bwM = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.NEGFeedBack.e.1
        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (e.this.bxa != null) {
                e.this.bxa.a(e.this.bwV, compoundButton, z);
            }
            if (compoundButton.getTag() instanceof b.a) {
                b.a aVar = (b.a) compoundButton.getTag();
                if (z) {
                    if (!e.this.bwW.contains(aVar)) {
                        e.this.bwW.add(aVar);
                        return;
                    }
                    return;
                }
                e.this.bwW.remove(aVar);
            }
        }
    };
    private PopupWindow.OnDismissListener bxh = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.NEGFeedBack.e.2
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (e.this.bxb != null) {
                e.this.bxb.dismiss();
                e.this.bxb = null;
            }
        }
    };

    /* loaded from: classes6.dex */
    public interface a {
        void onClick();
    }

    /* loaded from: classes6.dex */
    public interface b {
        void m(JSONArray jSONArray);
    }

    public e(TbPageContext tbPageContext, View view) {
        this.mContext = null;
        this.mContext = tbPageContext.getPageActivity();
        this.mPageContext = tbPageContext;
        this.mAnchor = view;
        init();
    }

    private void init() {
        this.mXOffset = l.h(this.mContext, e.C0210e.tbds32);
        this.bwX = l.aO(this.mContext) - (this.mXOffset * 2);
        this.bxe = new com.baidu.tieba.NEGFeedBack.b(this.mPageContext);
        this.bxe.a(this.bwM);
        this.bxe.dk(true);
    }

    private int getWindowMeasuredHeight() {
        if (this.mContentView == null) {
            return 0;
        }
        this.mContentView.measure(0, 0);
        this.bwY = this.mContentView.getMeasuredHeight() + l.h(this.mContext, e.C0210e.ds12);
        return this.bwY;
    }

    public void setData(ah ahVar) {
        if (ahVar != null) {
            this.bwV = ahVar;
            this.bwJ = ahVar.yF();
            if (this.bwJ != null && this.bwJ.size() > 8) {
                for (int size = this.bwJ.size() - 1; size >= 8; size--) {
                    this.bwJ.removeAt(size);
                }
            }
            this.bxe.setData(ahVar);
        }
    }

    public void setDefaultReasonArray(String[] strArr) {
        this.bxe.setDefaultReasonArray(strArr);
    }

    public void UB() {
        if (this.mPopupWindow != null) {
            this.mPopupWindow.dismiss();
            this.mPopupWindow = null;
        }
        if (this.bxb != null) {
            this.bxb.dismiss();
            this.bxb = null;
        }
    }

    private void UD() {
        if (this.bxf && this.bwW.size() != 0) {
            this.bwW.clear();
        }
    }

    private void Fj() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            al.c(this.bxq, e.d.cp_cont_f, 1);
            al.c(this.bxp, e.d.cp_cont_f, 1);
            al.j(this.mTopLine, e.d.cp_bg_line_b);
            al.j(this.bxt, e.d.cp_bg_line_b);
            al.c(this.bxr, e.d.cp_cont_f, 1);
            al.c(this.bxs, e.d.cp_cont_d, 1);
            this.mSkinType = skinType;
        }
    }

    private View getView() {
        if (this.mContext == null) {
            return null;
        }
        if (this.mContentView == null) {
            this.mContentView = (ViewGroup) LayoutInflater.from(this.mContext).inflate(e.h.neg_dt_head_popupwindow, (ViewGroup) null);
            this.bxr = (TextView) this.mContentView.findViewById(e.g.head_text);
            this.bxs = (TextView) this.mContentView.findViewById(e.g.sub_head_text);
        }
        View rootView = this.bxe.getRootView();
        if (rootView != null && rootView.getParent() == null) {
            int h = l.h(this.mContext, e.C0210e.ds40);
            rootView.setPadding(h, 0, h, 0);
            this.mContentView.addView(rootView);
        }
        if (this.bxm == null) {
            this.bxm = (LinearLayout) LayoutInflater.from(this.mContext).inflate(e.h.neg_dt_bottom_popupwindow, (ViewGroup) null);
            this.bxq = (TextView) this.bxm.findViewById(e.g.dialog_bottom_cancel_button);
            this.bxp = (TextView) this.bxm.findViewById(e.g.dialog_bottom_certain_button);
            this.mTopLine = this.bxm.findViewById(e.g.top_line);
            this.bxt = this.bxm.findViewById(e.g.middle_line);
            this.mContentView.addView(this.bxm);
            this.bxq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.NEGFeedBack.e.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (e.this.bxb != null) {
                        e.this.bxb.dismiss();
                        e.this.bxb = null;
                    }
                    if (e.this.mPopupWindow != null) {
                        e.this.mPopupWindow.dismiss();
                        e.this.mPopupWindow = null;
                    }
                    if (e.this.bxn != null) {
                        e.this.bxn.onClick();
                    }
                }
            });
            if (this.bxp != null) {
                this.bxp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.NEGFeedBack.e.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        JSONObject UF = e.this.UF();
                        if (e.this.mFrom == "3" || e.this.mFrom == "4" || e.this.mFrom == "1") {
                            e.this.UB();
                        } else if (UF != null) {
                            e.this.showLoadingView();
                            CustomMessage customMessage = new CustomMessage(2016489, e.this.mPageContext.getUniqueId());
                            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2016489, UF);
                            customResponsedMessage.setOrginalMessage(customMessage);
                            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                        }
                    }
                });
            }
            Fj();
        }
        return this.mContentView;
    }

    public void a(b bVar) {
        this.bxo = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLoadingView() {
        if (this.bif == null) {
            this.bif = new com.baidu.tbadk.core.view.d(this.mPageContext);
        }
        this.bif.ec(e.j.loading);
        this.bif.bA(true);
    }

    public void UE() {
        if (this.bif != null) {
            this.bif.bA(false);
        }
    }

    public void ji(String str) {
        if (this.mContext != null) {
            this.mFrom = str;
            View view = getView();
            if (view != null && view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            Fj();
            this.mWindowHeight = getWindowMeasuredHeight() - l.h(this.mContext, e.C0210e.ds12);
            this.mPopupWindow = new PopupWindow(view, this.bwX, this.mWindowHeight);
            this.mPopupWindow.setFocusable(true);
            this.mPopupWindow.setTouchable(true);
            this.mPopupWindow.setOnDismissListener(this.bxh);
            UD();
            this.bxb = new PopupWindow(LayoutInflater.from(this.mContext).inflate(e.h.view_negative_feedback_bottom, (ViewGroup) null), -1, -1);
            if (Build.VERSION.SDK_INT >= 22) {
                this.bxb.setAttachedInDecor(false);
            }
            this.bxb.showAtLocation(this.mAnchor, 0, 0, 0);
            al.a(this.mPopupWindow, e.f.bg_dailog);
            this.mPopupWindow.showAtLocation(this.mAnchor, 17, 0, 0);
            if (this.bxa != null) {
                this.bxa.a(this.bwV);
            }
            this.bxf = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject UF() {
        int i;
        JSONObject jSONObject = new JSONObject();
        if (this.bwV == null) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        if (v.I(this.bwW)) {
            i = 0;
        } else {
            i = 0;
            for (int i2 = 0; i2 < this.bwW.size(); i2++) {
                b.a aVar = this.bwW.get(i2);
                if (aVar != null) {
                    jSONArray.put(String.valueOf(aVar.id));
                    i = aVar.index + 1;
                }
            }
        }
        TiebaStatic.log(new am("c13123").aA(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.mFrom).x("obj_type", i));
        if (this.bxo != null) {
            this.bxo.m(jSONArray);
        }
        try {
            jSONObject.put(WebSocketAction.PARAM_KEY_REASON, jSONArray);
            jSONObject.put("thread_ids", this.bwV.yH());
            jSONObject.put("type", this.bwV.yG());
            jSONObject.put("forum_id", this.bwV.getFid());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
