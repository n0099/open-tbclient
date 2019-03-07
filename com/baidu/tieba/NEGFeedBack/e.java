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
import com.baidu.tbadk.core.data.aj;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.NEGFeedBack.b;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class e {
    private int cIS;
    private int cIT;
    private PopupWindow cIX;
    private com.baidu.tieba.NEGFeedBack.b cJa;
    private boolean cJb;
    private LinearLayout cJj;
    private a cJk;
    private b cJl;
    private TextView cJm;
    private TextView cJn;
    private TextView cJo;
    private TextView cJp;
    private View cJq;
    private View mAnchor;
    private ViewGroup mContentView;
    private Context mContext;
    private String mFrom;
    private TbPageContext mPageContext;
    private View mTopLine;
    private int mWindowHeight;
    private int mXOffset;
    private PopupWindow aMI = null;
    private aj cIQ = null;
    private SparseArray<String> cIC = null;
    private List<b.a> cIR = new ArrayList();
    private NEGFeedBackView.a cIW = null;
    private int mSkinType = 3;
    private com.baidu.tbadk.core.view.b csN = null;
    private CompoundButton.OnCheckedChangeListener cIF = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.NEGFeedBack.e.1
        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (e.this.cIW != null) {
                e.this.cIW.a(e.this.cIQ, compoundButton, z);
            }
            if (compoundButton.getTag() instanceof b.a) {
                b.a aVar = (b.a) compoundButton.getTag();
                if (z) {
                    if (!e.this.cIR.contains(aVar)) {
                        e.this.cIR.add(aVar);
                        return;
                    }
                    return;
                }
                e.this.cIR.remove(aVar);
            }
        }
    };
    private PopupWindow.OnDismissListener cJe = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.NEGFeedBack.e.2
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (e.this.cIX != null) {
                e.this.cIX.dismiss();
                e.this.cIX = null;
            }
        }
    };

    /* loaded from: classes3.dex */
    public interface a {
        void onClick();
    }

    /* loaded from: classes3.dex */
    public interface b {
        void B(JSONArray jSONArray);
    }

    public e(TbPageContext tbPageContext, View view) {
        this.mContext = null;
        this.mContext = tbPageContext.getPageActivity();
        this.mPageContext = tbPageContext;
        this.mAnchor = view;
        init();
    }

    private void init() {
        this.mXOffset = l.h(this.mContext, d.e.tbds32);
        this.cIS = l.aO(this.mContext) - (this.mXOffset * 2);
        this.cJa = new com.baidu.tieba.NEGFeedBack.b(this.mPageContext);
        this.cJa.a(this.cIF);
        this.cJa.fD(true);
    }

    private int getWindowMeasuredHeight() {
        if (this.mContentView == null) {
            return 0;
        }
        this.mContentView.measure(0, 0);
        this.cIT = this.mContentView.getMeasuredHeight() + l.h(this.mContext, d.e.ds12);
        return this.cIT;
    }

    public void setData(aj ajVar) {
        if (ajVar != null) {
            this.cIQ = ajVar;
            this.cIC = ajVar.XA();
            if (this.cIC != null && this.cIC.size() > 8) {
                for (int size = this.cIC.size() - 1; size >= 8; size--) {
                    this.cIC.removeAt(size);
                }
            }
            this.cJa.setData(ajVar);
        }
    }

    public void setDefaultReasonArray(String[] strArr) {
        this.cJa.setDefaultReasonArray(strArr);
    }

    public void auU() {
        if (this.aMI != null) {
            this.aMI.dismiss();
            this.aMI = null;
        }
        if (this.cIX != null) {
            this.cIX.dismiss();
            this.cIX = null;
        }
    }

    private void auY() {
        if (this.cJb && this.cIR.size() != 0) {
            this.cIR.clear();
        }
    }

    private void aeK() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            al.d(this.cJn, d.C0236d.cp_cont_f, 1);
            al.d(this.cJm, d.C0236d.cp_cont_f, 1);
            al.l(this.mTopLine, d.C0236d.cp_bg_line_b);
            al.l(this.cJq, d.C0236d.cp_bg_line_b);
            al.d(this.cJo, d.C0236d.cp_cont_f, 1);
            al.d(this.cJp, d.C0236d.cp_cont_d, 1);
            this.mSkinType = skinType;
        }
    }

    private View getView() {
        if (this.mContext == null) {
            return null;
        }
        if (this.mContentView == null) {
            this.mContentView = (ViewGroup) LayoutInflater.from(this.mContext).inflate(d.h.neg_dt_head_popupwindow, (ViewGroup) null);
            this.cJo = (TextView) this.mContentView.findViewById(d.g.head_text);
            this.cJp = (TextView) this.mContentView.findViewById(d.g.sub_head_text);
        }
        View rootView = this.cJa.getRootView();
        if (rootView != null && rootView.getParent() == null) {
            int h = l.h(this.mContext, d.e.ds40);
            rootView.setPadding(h, 0, h, 0);
            this.mContentView.addView(rootView);
        }
        if (this.cJj == null) {
            this.cJj = (LinearLayout) LayoutInflater.from(this.mContext).inflate(d.h.neg_dt_bottom_popupwindow, (ViewGroup) null);
            this.cJn = (TextView) this.cJj.findViewById(d.g.dialog_bottom_cancel_button);
            this.cJm = (TextView) this.cJj.findViewById(d.g.dialog_bottom_certain_button);
            this.mTopLine = this.cJj.findViewById(d.g.top_line);
            this.cJq = this.cJj.findViewById(d.g.middle_line);
            this.mContentView.addView(this.cJj);
            this.cJn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.NEGFeedBack.e.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (e.this.cIX != null) {
                        e.this.cIX.dismiss();
                        e.this.cIX = null;
                    }
                    if (e.this.aMI != null) {
                        e.this.aMI.dismiss();
                        e.this.aMI = null;
                    }
                    if (e.this.cJk != null) {
                        e.this.cJk.onClick();
                    }
                }
            });
            if (this.cJm != null) {
                this.cJm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.NEGFeedBack.e.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        JSONObject ava = e.this.ava();
                        if (e.this.mFrom == "3" || e.this.mFrom == "4" || e.this.mFrom == "1") {
                            e.this.auU();
                        } else if (ava != null) {
                            e.this.showLoadingView();
                            CustomMessage customMessage = new CustomMessage(2016489, e.this.mPageContext.getUniqueId());
                            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2016489, ava);
                            customResponsedMessage.setOrginalMessage(customMessage);
                            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                        }
                    }
                });
            }
            aeK();
        }
        return this.mContentView;
    }

    public void a(b bVar) {
        this.cJl = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLoadingView() {
        if (this.csN == null) {
            this.csN = new com.baidu.tbadk.core.view.b(this.mPageContext);
        }
        this.csN.hG(d.j.loading);
        this.csN.dJ(true);
    }

    public void auZ() {
        if (this.csN != null) {
            this.csN.dJ(false);
        }
    }

    public void qj(String str) {
        if (this.mContext != null) {
            this.mFrom = str;
            View view = getView();
            if (view != null && view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            aeK();
            this.mWindowHeight = getWindowMeasuredHeight() - l.h(this.mContext, d.e.ds12);
            this.aMI = new PopupWindow(view, this.cIS, this.mWindowHeight);
            this.aMI.setFocusable(true);
            this.aMI.setTouchable(true);
            this.aMI.setOnDismissListener(this.cJe);
            auY();
            this.cIX = new PopupWindow(LayoutInflater.from(this.mContext).inflate(d.h.view_negative_feedback_bottom, (ViewGroup) null), -1, -1);
            if (Build.VERSION.SDK_INT >= 22) {
                this.cIX.setAttachedInDecor(false);
            }
            this.cIX.showAtLocation(this.mAnchor, 0, 0, 0);
            al.a(this.aMI, d.f.bg_dailog);
            this.aMI.showAtLocation(this.mAnchor, 17, 0, 0);
            if (this.cIW != null) {
                this.cIW.b(this.cIQ);
            }
            this.cJb = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject ava() {
        int i;
        JSONObject jSONObject = new JSONObject();
        if (this.cIQ == null) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        if (v.T(this.cIR)) {
            i = 0;
        } else {
            i = 0;
            for (int i2 = 0; i2 < this.cIR.size(); i2++) {
                b.a aVar = this.cIR.get(i2);
                if (aVar != null) {
                    jSONArray.put(String.valueOf(aVar.id));
                    i = aVar.index + 1;
                }
            }
        }
        TiebaStatic.log(new am("c13123").bJ(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.mFrom).T("obj_type", i));
        if (this.cJl != null) {
            this.cJl.B(jSONArray);
        }
        try {
            jSONObject.put("reason", jSONArray);
            jSONObject.put("thread_ids", this.cIQ.XC());
            jSONObject.put("type", this.cIQ.XB());
            jSONObject.put("forum_id", this.cIQ.getFid());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
