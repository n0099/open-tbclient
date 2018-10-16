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
    private int bsJ;
    private int bsK;
    private PopupWindow bsN;
    private com.baidu.tieba.NEGFeedBack.b bsQ;
    private boolean bsR;
    private LinearLayout bsY;
    private a bsZ;
    private b bta;
    private TextView btb;
    private TextView btc;
    private TextView btd;
    private TextView bte;
    private View btf;
    private View mAnchor;
    private ViewGroup mContentView;
    private Context mContext;
    private String mFrom;
    private TbPageContext mPageContext;
    private View mTopLine;
    private int mWindowHeight;
    private int mXOffset;
    private PopupWindow mPopupWindow = null;
    private ah bsH = null;
    private SparseArray<String> bsv = null;
    private List<b.a> bsI = new ArrayList();
    private NEGFeedBackView.a bsM = null;
    private int mSkinType = 3;
    private com.baidu.tbadk.core.view.d bdN = null;
    private CompoundButton.OnCheckedChangeListener bsy = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.NEGFeedBack.e.1
        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (e.this.bsM != null) {
                e.this.bsM.a(e.this.bsH, compoundButton, z);
            }
            if (compoundButton.getTag() instanceof b.a) {
                b.a aVar = (b.a) compoundButton.getTag();
                if (z) {
                    if (!e.this.bsI.contains(aVar)) {
                        e.this.bsI.add(aVar);
                        return;
                    }
                    return;
                }
                e.this.bsI.remove(aVar);
            }
        }
    };
    private PopupWindow.OnDismissListener bsT = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.NEGFeedBack.e.2
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (e.this.bsN != null) {
                e.this.bsN.dismiss();
                e.this.bsN = null;
            }
        }
    };

    /* loaded from: classes6.dex */
    public interface a {
        void onClick();
    }

    /* loaded from: classes6.dex */
    public interface b {
        void k(JSONArray jSONArray);
    }

    public e(TbPageContext tbPageContext, View view) {
        this.mContext = null;
        this.mContext = tbPageContext.getPageActivity();
        this.mPageContext = tbPageContext;
        this.mAnchor = view;
        init();
    }

    private void init() {
        this.mXOffset = l.h(this.mContext, e.C0175e.tbds32);
        this.bsJ = l.aO(this.mContext) - (this.mXOffset * 2);
        this.bsQ = new com.baidu.tieba.NEGFeedBack.b(this.mPageContext);
        this.bsQ.a(this.bsy);
        this.bsQ.cS(true);
    }

    private int getWindowMeasuredHeight() {
        if (this.mContentView == null) {
            return 0;
        }
        this.mContentView.measure(0, 0);
        this.bsK = this.mContentView.getMeasuredHeight() + l.h(this.mContext, e.C0175e.ds12);
        return this.bsK;
    }

    public void setData(ah ahVar) {
        if (ahVar != null) {
            this.bsH = ahVar;
            this.bsv = ahVar.xt();
            if (this.bsv != null && this.bsv.size() > 8) {
                for (int size = this.bsv.size() - 1; size >= 8; size--) {
                    this.bsv.removeAt(size);
                }
            }
            this.bsQ.setData(ahVar);
        }
    }

    public void setDefaultReasonArray(String[] strArr) {
        this.bsQ.setDefaultReasonArray(strArr);
    }

    public void Tk() {
        if (this.mPopupWindow != null) {
            this.mPopupWindow.dismiss();
            this.mPopupWindow = null;
        }
        if (this.bsN != null) {
            this.bsN.dismiss();
            this.bsN = null;
        }
    }

    private void Tm() {
        if (this.bsR && this.bsI.size() != 0) {
            this.bsI.clear();
        }
    }

    private void DV() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            al.c(this.btc, e.d.cp_cont_f, 1);
            al.c(this.btb, e.d.cp_cont_f, 1);
            al.j(this.mTopLine, e.d.cp_bg_line_b);
            al.j(this.btf, e.d.cp_bg_line_b);
            al.c(this.btd, e.d.cp_cont_f, 1);
            al.c(this.bte, e.d.cp_cont_d, 1);
            this.mSkinType = skinType;
        }
    }

    private View getView() {
        if (this.mContext == null) {
            return null;
        }
        if (this.mContentView == null) {
            this.mContentView = (ViewGroup) LayoutInflater.from(this.mContext).inflate(e.h.neg_dt_head_popupwindow, (ViewGroup) null);
            this.btd = (TextView) this.mContentView.findViewById(e.g.head_text);
            this.bte = (TextView) this.mContentView.findViewById(e.g.sub_head_text);
        }
        View rootView = this.bsQ.getRootView();
        if (rootView != null && rootView.getParent() == null) {
            int h = l.h(this.mContext, e.C0175e.ds40);
            rootView.setPadding(h, 0, h, 0);
            this.mContentView.addView(rootView);
        }
        if (this.bsY == null) {
            this.bsY = (LinearLayout) LayoutInflater.from(this.mContext).inflate(e.h.neg_dt_bottom_popupwindow, (ViewGroup) null);
            this.btc = (TextView) this.bsY.findViewById(e.g.dialog_bottom_cancel_button);
            this.btb = (TextView) this.bsY.findViewById(e.g.dialog_bottom_certain_button);
            this.mTopLine = this.bsY.findViewById(e.g.top_line);
            this.btf = this.bsY.findViewById(e.g.middle_line);
            this.mContentView.addView(this.bsY);
            this.btc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.NEGFeedBack.e.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (e.this.bsN != null) {
                        e.this.bsN.dismiss();
                        e.this.bsN = null;
                    }
                    if (e.this.mPopupWindow != null) {
                        e.this.mPopupWindow.dismiss();
                        e.this.mPopupWindow = null;
                    }
                    if (e.this.bsZ != null) {
                        e.this.bsZ.onClick();
                    }
                }
            });
            if (this.btb != null) {
                this.btb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.NEGFeedBack.e.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        JSONObject To = e.this.To();
                        if (e.this.mFrom == "3" || e.this.mFrom == "4" || e.this.mFrom == "1") {
                            e.this.Tk();
                        } else if (To != null) {
                            e.this.showLoadingView();
                            CustomMessage customMessage = new CustomMessage(2016489, e.this.mPageContext.getUniqueId());
                            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2016489, To);
                            customResponsedMessage.setOrginalMessage(customMessage);
                            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                        }
                    }
                });
            }
            DV();
        }
        return this.mContentView;
    }

    public void a(b bVar) {
        this.bta = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLoadingView() {
        if (this.bdN == null) {
            this.bdN = new com.baidu.tbadk.core.view.d(this.mPageContext);
        }
        this.bdN.dA(e.j.loading);
        this.bdN.bj(true);
    }

    public void Tn() {
        if (this.bdN != null) {
            this.bdN.bj(false);
        }
    }

    public void iN(String str) {
        if (this.mContext != null) {
            this.mFrom = str;
            View view = getView();
            if (view != null && view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            DV();
            this.mWindowHeight = getWindowMeasuredHeight() - l.h(this.mContext, e.C0175e.ds12);
            this.mPopupWindow = new PopupWindow(view, this.bsJ, this.mWindowHeight);
            this.mPopupWindow.setFocusable(true);
            this.mPopupWindow.setTouchable(true);
            this.mPopupWindow.setOnDismissListener(this.bsT);
            Tm();
            this.bsN = new PopupWindow(LayoutInflater.from(this.mContext).inflate(e.h.view_negative_feedback_bottom, (ViewGroup) null), -1, -1);
            if (Build.VERSION.SDK_INT >= 22) {
                this.bsN.setAttachedInDecor(false);
            }
            this.bsN.showAtLocation(this.mAnchor, 0, 0, 0);
            al.a(this.mPopupWindow, e.f.bg_dailog);
            this.mPopupWindow.showAtLocation(this.mAnchor, 17, 0, 0);
            if (this.bsM != null) {
                this.bsM.a(this.bsH);
            }
            this.bsR = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject To() {
        int i;
        JSONObject jSONObject = new JSONObject();
        if (this.bsH == null) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        if (v.J(this.bsI)) {
            i = 0;
        } else {
            i = 0;
            for (int i2 = 0; i2 < this.bsI.size(); i2++) {
                b.a aVar = this.bsI.get(i2);
                if (aVar != null) {
                    jSONArray.put(String.valueOf(aVar.id));
                    i = aVar.index + 1;
                }
            }
        }
        TiebaStatic.log(new am("c13123").ax(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.mFrom).x("obj_type", i));
        if (this.bta != null) {
            this.bta.k(jSONArray);
        }
        try {
            jSONObject.put(WebSocketAction.PARAM_KEY_REASON, jSONArray);
            jSONObject.put("thread_ids", this.bsH.xv());
            jSONObject.put("type", this.bsH.xu());
            jSONObject.put("forum_id", this.bsH.getFid());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
