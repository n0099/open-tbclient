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
    private int bwU;
    private int bwV;
    private PopupWindow bwY;
    private com.baidu.tieba.NEGFeedBack.b bxb;
    private boolean bxc;
    private LinearLayout bxj;
    private a bxk;
    private b bxl;
    private TextView bxm;
    private TextView bxn;
    private TextView bxo;
    private TextView bxp;
    private View bxq;
    private View mAnchor;
    private ViewGroup mContentView;
    private Context mContext;
    private String mFrom;
    private TbPageContext mPageContext;
    private View mTopLine;
    private int mWindowHeight;
    private int mXOffset;
    private PopupWindow mPopupWindow = null;
    private ah bwS = null;
    private SparseArray<String> bwG = null;
    private List<b.a> bwT = new ArrayList();
    private NEGFeedBackView.a bwX = null;
    private int mSkinType = 3;
    private com.baidu.tbadk.core.view.d bib = null;
    private CompoundButton.OnCheckedChangeListener bwJ = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.NEGFeedBack.e.1
        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (e.this.bwX != null) {
                e.this.bwX.a(e.this.bwS, compoundButton, z);
            }
            if (compoundButton.getTag() instanceof b.a) {
                b.a aVar = (b.a) compoundButton.getTag();
                if (z) {
                    if (!e.this.bwT.contains(aVar)) {
                        e.this.bwT.add(aVar);
                        return;
                    }
                    return;
                }
                e.this.bwT.remove(aVar);
            }
        }
    };
    private PopupWindow.OnDismissListener bxe = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.NEGFeedBack.e.2
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (e.this.bwY != null) {
                e.this.bwY.dismiss();
                e.this.bwY = null;
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
        this.bwU = l.aO(this.mContext) - (this.mXOffset * 2);
        this.bxb = new com.baidu.tieba.NEGFeedBack.b(this.mPageContext);
        this.bxb.a(this.bwJ);
        this.bxb.dk(true);
    }

    private int getWindowMeasuredHeight() {
        if (this.mContentView == null) {
            return 0;
        }
        this.mContentView.measure(0, 0);
        this.bwV = this.mContentView.getMeasuredHeight() + l.h(this.mContext, e.C0210e.ds12);
        return this.bwV;
    }

    public void setData(ah ahVar) {
        if (ahVar != null) {
            this.bwS = ahVar;
            this.bwG = ahVar.yF();
            if (this.bwG != null && this.bwG.size() > 8) {
                for (int size = this.bwG.size() - 1; size >= 8; size--) {
                    this.bwG.removeAt(size);
                }
            }
            this.bxb.setData(ahVar);
        }
    }

    public void setDefaultReasonArray(String[] strArr) {
        this.bxb.setDefaultReasonArray(strArr);
    }

    public void Uz() {
        if (this.mPopupWindow != null) {
            this.mPopupWindow.dismiss();
            this.mPopupWindow = null;
        }
        if (this.bwY != null) {
            this.bwY.dismiss();
            this.bwY = null;
        }
    }

    private void UB() {
        if (this.bxc && this.bwT.size() != 0) {
            this.bwT.clear();
        }
    }

    private void Fj() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            al.c(this.bxn, e.d.cp_cont_f, 1);
            al.c(this.bxm, e.d.cp_cont_f, 1);
            al.j(this.mTopLine, e.d.cp_bg_line_b);
            al.j(this.bxq, e.d.cp_bg_line_b);
            al.c(this.bxo, e.d.cp_cont_f, 1);
            al.c(this.bxp, e.d.cp_cont_d, 1);
            this.mSkinType = skinType;
        }
    }

    private View getView() {
        if (this.mContext == null) {
            return null;
        }
        if (this.mContentView == null) {
            this.mContentView = (ViewGroup) LayoutInflater.from(this.mContext).inflate(e.h.neg_dt_head_popupwindow, (ViewGroup) null);
            this.bxo = (TextView) this.mContentView.findViewById(e.g.head_text);
            this.bxp = (TextView) this.mContentView.findViewById(e.g.sub_head_text);
        }
        View rootView = this.bxb.getRootView();
        if (rootView != null && rootView.getParent() == null) {
            int h = l.h(this.mContext, e.C0210e.ds40);
            rootView.setPadding(h, 0, h, 0);
            this.mContentView.addView(rootView);
        }
        if (this.bxj == null) {
            this.bxj = (LinearLayout) LayoutInflater.from(this.mContext).inflate(e.h.neg_dt_bottom_popupwindow, (ViewGroup) null);
            this.bxn = (TextView) this.bxj.findViewById(e.g.dialog_bottom_cancel_button);
            this.bxm = (TextView) this.bxj.findViewById(e.g.dialog_bottom_certain_button);
            this.mTopLine = this.bxj.findViewById(e.g.top_line);
            this.bxq = this.bxj.findViewById(e.g.middle_line);
            this.mContentView.addView(this.bxj);
            this.bxn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.NEGFeedBack.e.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (e.this.bwY != null) {
                        e.this.bwY.dismiss();
                        e.this.bwY = null;
                    }
                    if (e.this.mPopupWindow != null) {
                        e.this.mPopupWindow.dismiss();
                        e.this.mPopupWindow = null;
                    }
                    if (e.this.bxk != null) {
                        e.this.bxk.onClick();
                    }
                }
            });
            if (this.bxm != null) {
                this.bxm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.NEGFeedBack.e.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        JSONObject UD = e.this.UD();
                        if (e.this.mFrom == "3" || e.this.mFrom == "4" || e.this.mFrom == "1") {
                            e.this.Uz();
                        } else if (UD != null) {
                            e.this.showLoadingView();
                            CustomMessage customMessage = new CustomMessage(2016489, e.this.mPageContext.getUniqueId());
                            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2016489, UD);
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
        this.bxl = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLoadingView() {
        if (this.bib == null) {
            this.bib = new com.baidu.tbadk.core.view.d(this.mPageContext);
        }
        this.bib.ec(e.j.loading);
        this.bib.bA(true);
    }

    public void UC() {
        if (this.bib != null) {
            this.bib.bA(false);
        }
    }

    public void jh(String str) {
        if (this.mContext != null) {
            this.mFrom = str;
            View view = getView();
            if (view != null && view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            Fj();
            this.mWindowHeight = getWindowMeasuredHeight() - l.h(this.mContext, e.C0210e.ds12);
            this.mPopupWindow = new PopupWindow(view, this.bwU, this.mWindowHeight);
            this.mPopupWindow.setFocusable(true);
            this.mPopupWindow.setTouchable(true);
            this.mPopupWindow.setOnDismissListener(this.bxe);
            UB();
            this.bwY = new PopupWindow(LayoutInflater.from(this.mContext).inflate(e.h.view_negative_feedback_bottom, (ViewGroup) null), -1, -1);
            if (Build.VERSION.SDK_INT >= 22) {
                this.bwY.setAttachedInDecor(false);
            }
            this.bwY.showAtLocation(this.mAnchor, 0, 0, 0);
            al.a(this.mPopupWindow, e.f.bg_dailog);
            this.mPopupWindow.showAtLocation(this.mAnchor, 17, 0, 0);
            if (this.bwX != null) {
                this.bwX.a(this.bwS);
            }
            this.bxc = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject UD() {
        int i;
        JSONObject jSONObject = new JSONObject();
        if (this.bwS == null) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        if (v.I(this.bwT)) {
            i = 0;
        } else {
            i = 0;
            for (int i2 = 0; i2 < this.bwT.size(); i2++) {
                b.a aVar = this.bwT.get(i2);
                if (aVar != null) {
                    jSONArray.put(String.valueOf(aVar.id));
                    i = aVar.index + 1;
                }
            }
        }
        TiebaStatic.log(new am("c13123").aA(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.mFrom).x("obj_type", i));
        if (this.bxl != null) {
            this.bxl.m(jSONArray);
        }
        try {
            jSONObject.put(WebSocketAction.PARAM_KEY_REASON, jSONArray);
            jSONObject.put("thread_ids", this.bwS.yH());
            jSONObject.put("type", this.bwS.yG());
            jSONObject.put("forum_id", this.bwS.getFid());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
