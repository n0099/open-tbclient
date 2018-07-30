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
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.data.ah;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.NEGFeedBack.b;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class e {
    private View aIx;
    private int biT;
    private int biU;
    private PopupWindow biX;
    private com.baidu.tieba.NEGFeedBack.b bja;
    private boolean bjb;
    private LinearLayout bji;
    private a bjj;
    private b bjk;
    private TextView bjl;
    private TextView bjm;
    private TextView bjn;
    private TextView bjo;
    private View bjp;
    private View mAnchor;
    private ViewGroup mContentView;
    private Context mContext;
    private String mFrom;
    private TbPageContext mPageContext;
    private int mWindowHeight;
    private int mXOffset;
    private PopupWindow biQ = null;
    private ah biR = null;
    private SparseArray<String> biD = null;
    private List<b.a> biS = new ArrayList();
    private NEGFeedBackView.a biW = null;
    private int mSkinType = 3;
    private com.baidu.tbadk.core.view.a aVY = null;
    private CompoundButton.OnCheckedChangeListener biG = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.NEGFeedBack.e.1
        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (e.this.biW != null) {
                e.this.biW.a(e.this.biR, compoundButton, z);
            }
            if (compoundButton.getTag() instanceof b.a) {
                b.a aVar = (b.a) compoundButton.getTag();
                if (z) {
                    if (!e.this.biS.contains(aVar)) {
                        e.this.biS.add(aVar);
                        return;
                    }
                    return;
                }
                e.this.biS.remove(aVar);
            }
        }
    };
    private PopupWindow.OnDismissListener bjd = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.NEGFeedBack.e.2
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (e.this.biX != null) {
                e.this.biX.dismiss();
                e.this.biX = null;
            }
        }
    };

    /* loaded from: classes2.dex */
    public interface a {
        void onClick();
    }

    /* loaded from: classes2.dex */
    public interface b {
        void f(JSONArray jSONArray);
    }

    public e(TbPageContext tbPageContext, View view) {
        this.mContext = null;
        this.mContext = tbPageContext.getPageActivity();
        this.mPageContext = tbPageContext;
        this.mAnchor = view;
        init();
    }

    private void init() {
        this.mXOffset = l.f(this.mContext, d.e.tbds32);
        this.biT = l.ah(this.mContext) - (this.mXOffset * 2);
        this.bja = new com.baidu.tieba.NEGFeedBack.b(this.mPageContext);
        this.bja.a(this.biG);
        this.bja.cr(true);
    }

    private int getWindowMeasuredHeight() {
        if (this.mContentView == null) {
            return 0;
        }
        this.mContentView.measure(0, 0);
        this.biU = this.mContentView.getMeasuredHeight() + l.f(this.mContext, d.e.ds12);
        return this.biU;
    }

    public void setData(ah ahVar) {
        if (ahVar != null) {
            this.biR = ahVar;
            this.biD = ahVar.ui();
            if (this.biD != null && this.biD.size() > 8) {
                for (int size = this.biD.size() - 1; size >= 8; size--) {
                    this.biD.removeAt(size);
                }
            }
            this.bja.setData(ahVar);
        }
    }

    public void setDefaultReasonArray(String[] strArr) {
        this.bja.setDefaultReasonArray(strArr);
    }

    public void Pv() {
        if (this.biQ != null) {
            this.biQ.dismiss();
            this.biQ = null;
        }
        if (this.biX != null) {
            this.biX.dismiss();
            this.biX = null;
        }
    }

    private void Px() {
        if (this.bjb && this.biS.size() != 0) {
            this.biS.clear();
        }
    }

    private void AG() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            am.c(this.bjm, d.C0140d.cp_cont_f, 1);
            am.c(this.bjl, d.C0140d.cp_cont_f, 1);
            am.j(this.aIx, d.C0140d.cp_bg_line_b);
            am.j(this.bjp, d.C0140d.cp_bg_line_b);
            am.c(this.bjn, d.C0140d.cp_cont_f, 1);
            am.c(this.bjo, d.C0140d.cp_cont_d, 1);
            this.mSkinType = skinType;
        }
    }

    private View getView() {
        if (this.mContext == null) {
            return null;
        }
        if (this.mContentView == null) {
            this.mContentView = (ViewGroup) LayoutInflater.from(this.mContext).inflate(d.h.neg_dt_head_popupwindow, (ViewGroup) null);
            this.bjn = (TextView) this.mContentView.findViewById(d.g.head_text);
            this.bjo = (TextView) this.mContentView.findViewById(d.g.sub_head_text);
        }
        View rootView = this.bja.getRootView();
        if (rootView != null && rootView.getParent() == null) {
            int f = l.f(this.mContext, d.e.ds40);
            rootView.setPadding(f, 0, f, 0);
            this.mContentView.addView(rootView);
        }
        if (this.bji == null) {
            this.bji = (LinearLayout) LayoutInflater.from(this.mContext).inflate(d.h.neg_dt_bottom_popupwindow, (ViewGroup) null);
            this.bjm = (TextView) this.bji.findViewById(d.g.dialog_bottom_cancel_button);
            this.bjl = (TextView) this.bji.findViewById(d.g.dialog_bottom_certain_button);
            this.aIx = this.bji.findViewById(d.g.top_line);
            this.bjp = this.bji.findViewById(d.g.middle_line);
            this.mContentView.addView(this.bji);
            this.bjm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.NEGFeedBack.e.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (e.this.biX != null) {
                        e.this.biX.dismiss();
                        e.this.biX = null;
                    }
                    if (e.this.biQ != null) {
                        e.this.biQ.dismiss();
                        e.this.biQ = null;
                    }
                    if (e.this.bjj != null) {
                        e.this.bjj.onClick();
                    }
                }
            });
            if (this.bjl != null) {
                this.bjl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.NEGFeedBack.e.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        JSONObject Pz = e.this.Pz();
                        if (e.this.mFrom == "3" || e.this.mFrom == "4" || e.this.mFrom == "1") {
                            e.this.Pv();
                        } else if (Pz != null) {
                            e.this.showLoadingView();
                            CustomMessage customMessage = new CustomMessage(2016489, e.this.mPageContext.getUniqueId());
                            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2016489, Pz);
                            customResponsedMessage.setOrginalMessage(customMessage);
                            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                        }
                    }
                });
            }
            AG();
        }
        return this.mContentView;
    }

    public void a(b bVar) {
        this.bjk = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLoadingView() {
        if (this.aVY == null) {
            this.aVY = new com.baidu.tbadk.core.view.a(this.mPageContext);
        }
        this.aVY.df(d.j.loading);
        this.aVY.aM(true);
    }

    public void Py() {
        if (this.aVY != null) {
            this.aVY.aM(false);
        }
    }

    public void hY(String str) {
        if (this.mContext != null) {
            this.mFrom = str;
            View view = getView();
            if (view != null && view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            AG();
            this.mWindowHeight = getWindowMeasuredHeight() - l.f(this.mContext, d.e.ds12);
            this.biQ = new PopupWindow(view, this.biT, this.mWindowHeight);
            this.biQ.setFocusable(true);
            this.biQ.setTouchable(true);
            this.biQ.setOnDismissListener(this.bjd);
            Px();
            this.biX = new PopupWindow(LayoutInflater.from(this.mContext).inflate(d.h.view_negative_feedback_bottom, (ViewGroup) null), -1, -1);
            if (Build.VERSION.SDK_INT >= 22) {
                this.biX.setAttachedInDecor(false);
            }
            this.biX.showAtLocation(this.mAnchor, 0, 0, 0);
            am.a(this.biQ, d.f.bg_dailog);
            this.biQ.showAtLocation(this.mAnchor, 17, 0, 0);
            if (this.biW != null) {
                this.biW.a(this.biR);
            }
            this.bjb = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject Pz() {
        int i;
        JSONObject jSONObject = new JSONObject();
        if (this.biR == null) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        if (w.z(this.biS)) {
            i = 0;
        } else {
            i = 0;
            for (int i2 = 0; i2 < this.biS.size(); i2++) {
                b.a aVar = this.biS.get(i2);
                if (aVar != null) {
                    jSONArray.put(String.valueOf(aVar.id));
                    i = aVar.index + 1;
                }
            }
        }
        TiebaStatic.log(new an("c13123").af(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.mFrom).r("obj_type", i));
        if (this.bjk != null) {
            this.bjk.f(jSONArray);
        }
        try {
            jSONObject.put("reason", jSONArray);
            jSONObject.put("thread_ids", this.biR.uk());
            jSONObject.put("type", this.biR.uj());
            jSONObject.put("forum_id", this.biR.getFid());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
