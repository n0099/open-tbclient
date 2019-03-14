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
    private int cIP;
    private int cIQ;
    private PopupWindow cIU;
    private com.baidu.tieba.NEGFeedBack.b cIX;
    private boolean cIY;
    private LinearLayout cJg;
    private a cJh;
    private b cJi;
    private TextView cJj;
    private TextView cJk;
    private TextView cJl;
    private TextView cJm;
    private View cJn;
    private View mAnchor;
    private ViewGroup mContentView;
    private Context mContext;
    private String mFrom;
    private TbPageContext mPageContext;
    private View mTopLine;
    private int mWindowHeight;
    private int mXOffset;
    private PopupWindow aMJ = null;
    private aj cIN = null;
    private SparseArray<String> cIz = null;
    private List<b.a> cIO = new ArrayList();
    private NEGFeedBackView.a cIT = null;
    private int mSkinType = 3;
    private com.baidu.tbadk.core.view.b csK = null;
    private CompoundButton.OnCheckedChangeListener cIC = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.NEGFeedBack.e.1
        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (e.this.cIT != null) {
                e.this.cIT.a(e.this.cIN, compoundButton, z);
            }
            if (compoundButton.getTag() instanceof b.a) {
                b.a aVar = (b.a) compoundButton.getTag();
                if (z) {
                    if (!e.this.cIO.contains(aVar)) {
                        e.this.cIO.add(aVar);
                        return;
                    }
                    return;
                }
                e.this.cIO.remove(aVar);
            }
        }
    };
    private PopupWindow.OnDismissListener cJb = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.NEGFeedBack.e.2
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (e.this.cIU != null) {
                e.this.cIU.dismiss();
                e.this.cIU = null;
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
        this.cIP = l.aO(this.mContext) - (this.mXOffset * 2);
        this.cIX = new com.baidu.tieba.NEGFeedBack.b(this.mPageContext);
        this.cIX.a(this.cIC);
        this.cIX.fD(true);
    }

    private int getWindowMeasuredHeight() {
        if (this.mContentView == null) {
            return 0;
        }
        this.mContentView.measure(0, 0);
        this.cIQ = this.mContentView.getMeasuredHeight() + l.h(this.mContext, d.e.ds12);
        return this.cIQ;
    }

    public void setData(aj ajVar) {
        if (ajVar != null) {
            this.cIN = ajVar;
            this.cIz = ajVar.XA();
            if (this.cIz != null && this.cIz.size() > 8) {
                for (int size = this.cIz.size() - 1; size >= 8; size--) {
                    this.cIz.removeAt(size);
                }
            }
            this.cIX.setData(ajVar);
        }
    }

    public void setDefaultReasonArray(String[] strArr) {
        this.cIX.setDefaultReasonArray(strArr);
    }

    public void auU() {
        if (this.aMJ != null) {
            this.aMJ.dismiss();
            this.aMJ = null;
        }
        if (this.cIU != null) {
            this.cIU.dismiss();
            this.cIU = null;
        }
    }

    private void auY() {
        if (this.cIY && this.cIO.size() != 0) {
            this.cIO.clear();
        }
    }

    private void aeK() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            al.d(this.cJk, d.C0277d.cp_cont_f, 1);
            al.d(this.cJj, d.C0277d.cp_cont_f, 1);
            al.l(this.mTopLine, d.C0277d.cp_bg_line_b);
            al.l(this.cJn, d.C0277d.cp_bg_line_b);
            al.d(this.cJl, d.C0277d.cp_cont_f, 1);
            al.d(this.cJm, d.C0277d.cp_cont_d, 1);
            this.mSkinType = skinType;
        }
    }

    private View getView() {
        if (this.mContext == null) {
            return null;
        }
        if (this.mContentView == null) {
            this.mContentView = (ViewGroup) LayoutInflater.from(this.mContext).inflate(d.h.neg_dt_head_popupwindow, (ViewGroup) null);
            this.cJl = (TextView) this.mContentView.findViewById(d.g.head_text);
            this.cJm = (TextView) this.mContentView.findViewById(d.g.sub_head_text);
        }
        View rootView = this.cIX.getRootView();
        if (rootView != null && rootView.getParent() == null) {
            int h = l.h(this.mContext, d.e.ds40);
            rootView.setPadding(h, 0, h, 0);
            this.mContentView.addView(rootView);
        }
        if (this.cJg == null) {
            this.cJg = (LinearLayout) LayoutInflater.from(this.mContext).inflate(d.h.neg_dt_bottom_popupwindow, (ViewGroup) null);
            this.cJk = (TextView) this.cJg.findViewById(d.g.dialog_bottom_cancel_button);
            this.cJj = (TextView) this.cJg.findViewById(d.g.dialog_bottom_certain_button);
            this.mTopLine = this.cJg.findViewById(d.g.top_line);
            this.cJn = this.cJg.findViewById(d.g.middle_line);
            this.mContentView.addView(this.cJg);
            this.cJk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.NEGFeedBack.e.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (e.this.cIU != null) {
                        e.this.cIU.dismiss();
                        e.this.cIU = null;
                    }
                    if (e.this.aMJ != null) {
                        e.this.aMJ.dismiss();
                        e.this.aMJ = null;
                    }
                    if (e.this.cJh != null) {
                        e.this.cJh.onClick();
                    }
                }
            });
            if (this.cJj != null) {
                this.cJj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.NEGFeedBack.e.4
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
        this.cJi = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLoadingView() {
        if (this.csK == null) {
            this.csK = new com.baidu.tbadk.core.view.b(this.mPageContext);
        }
        this.csK.hG(d.j.loading);
        this.csK.dJ(true);
    }

    public void auZ() {
        if (this.csK != null) {
            this.csK.dJ(false);
        }
    }

    public void qi(String str) {
        if (this.mContext != null) {
            this.mFrom = str;
            View view = getView();
            if (view != null && view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            aeK();
            this.mWindowHeight = getWindowMeasuredHeight() - l.h(this.mContext, d.e.ds12);
            this.aMJ = new PopupWindow(view, this.cIP, this.mWindowHeight);
            this.aMJ.setFocusable(true);
            this.aMJ.setTouchable(true);
            this.aMJ.setOnDismissListener(this.cJb);
            auY();
            this.cIU = new PopupWindow(LayoutInflater.from(this.mContext).inflate(d.h.view_negative_feedback_bottom, (ViewGroup) null), -1, -1);
            if (Build.VERSION.SDK_INT >= 22) {
                this.cIU.setAttachedInDecor(false);
            }
            this.cIU.showAtLocation(this.mAnchor, 0, 0, 0);
            al.a(this.aMJ, d.f.bg_dailog);
            this.aMJ.showAtLocation(this.mAnchor, 17, 0, 0);
            if (this.cIT != null) {
                this.cIT.b(this.cIN);
            }
            this.cIY = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject ava() {
        int i;
        JSONObject jSONObject = new JSONObject();
        if (this.cIN == null) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        if (v.T(this.cIO)) {
            i = 0;
        } else {
            i = 0;
            for (int i2 = 0; i2 < this.cIO.size(); i2++) {
                b.a aVar = this.cIO.get(i2);
                if (aVar != null) {
                    jSONArray.put(String.valueOf(aVar.id));
                    i = aVar.index + 1;
                }
            }
        }
        TiebaStatic.log(new am("c13123").bJ(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.mFrom).T("obj_type", i));
        if (this.cJi != null) {
            this.cJi.B(jSONArray);
        }
        try {
            jSONObject.put("reason", jSONArray);
            jSONObject.put("thread_ids", this.cIN.XC());
            jSONObject.put("type", this.cIN.XB());
            jSONObject.put("forum_id", this.cIN.getFid());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
