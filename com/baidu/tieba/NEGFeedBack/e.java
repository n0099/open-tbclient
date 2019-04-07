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
    private int cIR;
    private int cIS;
    private PopupWindow cIW;
    private com.baidu.tieba.NEGFeedBack.b cIZ;
    private boolean cJa;
    private LinearLayout cJi;
    private a cJj;
    private b cJk;
    private TextView cJl;
    private TextView cJm;
    private TextView cJn;
    private TextView cJo;
    private View cJp;
    private View mAnchor;
    private ViewGroup mContentView;
    private Context mContext;
    private String mFrom;
    private TbPageContext mPageContext;
    private View mTopLine;
    private int mWindowHeight;
    private int mXOffset;
    private PopupWindow aMM = null;
    private aj cIP = null;
    private SparseArray<String> cIB = null;
    private List<b.a> cIQ = new ArrayList();
    private NEGFeedBackView.a cIV = null;
    private int mSkinType = 3;
    private com.baidu.tbadk.core.view.b csM = null;
    private CompoundButton.OnCheckedChangeListener cIE = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.NEGFeedBack.e.1
        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (e.this.cIV != null) {
                e.this.cIV.a(e.this.cIP, compoundButton, z);
            }
            if (compoundButton.getTag() instanceof b.a) {
                b.a aVar = (b.a) compoundButton.getTag();
                if (z) {
                    if (!e.this.cIQ.contains(aVar)) {
                        e.this.cIQ.add(aVar);
                        return;
                    }
                    return;
                }
                e.this.cIQ.remove(aVar);
            }
        }
    };
    private PopupWindow.OnDismissListener cJd = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.NEGFeedBack.e.2
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (e.this.cIW != null) {
                e.this.cIW.dismiss();
                e.this.cIW = null;
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
        this.cIR = l.aO(this.mContext) - (this.mXOffset * 2);
        this.cIZ = new com.baidu.tieba.NEGFeedBack.b(this.mPageContext);
        this.cIZ.a(this.cIE);
        this.cIZ.fD(true);
    }

    private int getWindowMeasuredHeight() {
        if (this.mContentView == null) {
            return 0;
        }
        this.mContentView.measure(0, 0);
        this.cIS = this.mContentView.getMeasuredHeight() + l.h(this.mContext, d.e.ds12);
        return this.cIS;
    }

    public void setData(aj ajVar) {
        if (ajVar != null) {
            this.cIP = ajVar;
            this.cIB = ajVar.Xx();
            if (this.cIB != null && this.cIB.size() > 8) {
                for (int size = this.cIB.size() - 1; size >= 8; size--) {
                    this.cIB.removeAt(size);
                }
            }
            this.cIZ.setData(ajVar);
        }
    }

    public void setDefaultReasonArray(String[] strArr) {
        this.cIZ.setDefaultReasonArray(strArr);
    }

    public void auR() {
        if (this.aMM != null) {
            this.aMM.dismiss();
            this.aMM = null;
        }
        if (this.cIW != null) {
            this.cIW.dismiss();
            this.cIW = null;
        }
    }

    private void auV() {
        if (this.cJa && this.cIQ.size() != 0) {
            this.cIQ.clear();
        }
    }

    private void aeH() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            al.d(this.cJm, d.C0277d.cp_cont_f, 1);
            al.d(this.cJl, d.C0277d.cp_cont_f, 1);
            al.l(this.mTopLine, d.C0277d.cp_bg_line_b);
            al.l(this.cJp, d.C0277d.cp_bg_line_b);
            al.d(this.cJn, d.C0277d.cp_cont_f, 1);
            al.d(this.cJo, d.C0277d.cp_cont_d, 1);
            this.mSkinType = skinType;
        }
    }

    private View getView() {
        if (this.mContext == null) {
            return null;
        }
        if (this.mContentView == null) {
            this.mContentView = (ViewGroup) LayoutInflater.from(this.mContext).inflate(d.h.neg_dt_head_popupwindow, (ViewGroup) null);
            this.cJn = (TextView) this.mContentView.findViewById(d.g.head_text);
            this.cJo = (TextView) this.mContentView.findViewById(d.g.sub_head_text);
        }
        View rootView = this.cIZ.getRootView();
        if (rootView != null && rootView.getParent() == null) {
            int h = l.h(this.mContext, d.e.ds40);
            rootView.setPadding(h, 0, h, 0);
            this.mContentView.addView(rootView);
        }
        if (this.cJi == null) {
            this.cJi = (LinearLayout) LayoutInflater.from(this.mContext).inflate(d.h.neg_dt_bottom_popupwindow, (ViewGroup) null);
            this.cJm = (TextView) this.cJi.findViewById(d.g.dialog_bottom_cancel_button);
            this.cJl = (TextView) this.cJi.findViewById(d.g.dialog_bottom_certain_button);
            this.mTopLine = this.cJi.findViewById(d.g.top_line);
            this.cJp = this.cJi.findViewById(d.g.middle_line);
            this.mContentView.addView(this.cJi);
            this.cJm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.NEGFeedBack.e.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (e.this.cIW != null) {
                        e.this.cIW.dismiss();
                        e.this.cIW = null;
                    }
                    if (e.this.aMM != null) {
                        e.this.aMM.dismiss();
                        e.this.aMM = null;
                    }
                    if (e.this.cJj != null) {
                        e.this.cJj.onClick();
                    }
                }
            });
            if (this.cJl != null) {
                this.cJl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.NEGFeedBack.e.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        JSONObject auX = e.this.auX();
                        if (e.this.mFrom == "3" || e.this.mFrom == "4" || e.this.mFrom == "1") {
                            e.this.auR();
                        } else if (auX != null) {
                            e.this.showLoadingView();
                            CustomMessage customMessage = new CustomMessage(2016489, e.this.mPageContext.getUniqueId());
                            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2016489, auX);
                            customResponsedMessage.setOrginalMessage(customMessage);
                            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                        }
                    }
                });
            }
            aeH();
        }
        return this.mContentView;
    }

    public void a(b bVar) {
        this.cJk = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLoadingView() {
        if (this.csM == null) {
            this.csM = new com.baidu.tbadk.core.view.b(this.mPageContext);
        }
        this.csM.hF(d.j.loading);
        this.csM.dJ(true);
    }

    public void auW() {
        if (this.csM != null) {
            this.csM.dJ(false);
        }
    }

    public void qj(String str) {
        if (this.mContext != null) {
            this.mFrom = str;
            View view = getView();
            if (view != null && view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            aeH();
            this.mWindowHeight = getWindowMeasuredHeight() - l.h(this.mContext, d.e.ds12);
            this.aMM = new PopupWindow(view, this.cIR, this.mWindowHeight);
            this.aMM.setFocusable(true);
            this.aMM.setTouchable(true);
            this.aMM.setOnDismissListener(this.cJd);
            auV();
            this.cIW = new PopupWindow(LayoutInflater.from(this.mContext).inflate(d.h.view_negative_feedback_bottom, (ViewGroup) null), -1, -1);
            if (Build.VERSION.SDK_INT >= 22) {
                this.cIW.setAttachedInDecor(false);
            }
            this.cIW.showAtLocation(this.mAnchor, 0, 0, 0);
            al.a(this.aMM, d.f.bg_dailog);
            this.aMM.showAtLocation(this.mAnchor, 17, 0, 0);
            if (this.cIV != null) {
                this.cIV.b(this.cIP);
            }
            this.cJa = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject auX() {
        int i;
        JSONObject jSONObject = new JSONObject();
        if (this.cIP == null) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        if (v.T(this.cIQ)) {
            i = 0;
        } else {
            i = 0;
            for (int i2 = 0; i2 < this.cIQ.size(); i2++) {
                b.a aVar = this.cIQ.get(i2);
                if (aVar != null) {
                    jSONArray.put(String.valueOf(aVar.id));
                    i = aVar.index + 1;
                }
            }
        }
        TiebaStatic.log(new am("c13123").bJ(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.mFrom).T("obj_type", i));
        if (this.cJk != null) {
            this.cJk.B(jSONArray);
        }
        try {
            jSONObject.put("reason", jSONArray);
            jSONObject.put("thread_ids", this.cIP.Xz());
            jSONObject.put("type", this.cIP.Xy());
            jSONObject.put("forum_id", this.cIP.getFid());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
