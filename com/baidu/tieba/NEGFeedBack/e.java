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
    private PopupWindow btA;
    private com.baidu.tieba.NEGFeedBack.b btD;
    private boolean btE;
    private LinearLayout btL;
    private a btM;
    private b btN;
    private TextView btO;
    private TextView btP;
    private TextView btQ;
    private TextView btR;
    private View btS;
    private int btw;
    private int btx;
    private View mAnchor;
    private ViewGroup mContentView;
    private Context mContext;
    private String mFrom;
    private TbPageContext mPageContext;
    private View mTopLine;
    private int mWindowHeight;
    private int mXOffset;
    private PopupWindow mPopupWindow = null;
    private ah btu = null;
    private SparseArray<String> bth = null;
    private List<b.a> btv = new ArrayList();
    private NEGFeedBackView.a btz = null;
    private int mSkinType = 3;
    private com.baidu.tbadk.core.view.d beC = null;
    private CompoundButton.OnCheckedChangeListener btk = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.NEGFeedBack.e.1
        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (e.this.btz != null) {
                e.this.btz.a(e.this.btu, compoundButton, z);
            }
            if (compoundButton.getTag() instanceof b.a) {
                b.a aVar = (b.a) compoundButton.getTag();
                if (z) {
                    if (!e.this.btv.contains(aVar)) {
                        e.this.btv.add(aVar);
                        return;
                    }
                    return;
                }
                e.this.btv.remove(aVar);
            }
        }
    };
    private PopupWindow.OnDismissListener btG = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.NEGFeedBack.e.2
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (e.this.btA != null) {
                e.this.btA.dismiss();
                e.this.btA = null;
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
        this.mXOffset = l.h(this.mContext, e.C0200e.tbds32);
        this.btw = l.aO(this.mContext) - (this.mXOffset * 2);
        this.btD = new com.baidu.tieba.NEGFeedBack.b(this.mPageContext);
        this.btD.a(this.btk);
        this.btD.dj(true);
    }

    private int getWindowMeasuredHeight() {
        if (this.mContentView == null) {
            return 0;
        }
        this.mContentView.measure(0, 0);
        this.btx = this.mContentView.getMeasuredHeight() + l.h(this.mContext, e.C0200e.ds12);
        return this.btx;
    }

    public void setData(ah ahVar) {
        if (ahVar != null) {
            this.btu = ahVar;
            this.bth = ahVar.xB();
            if (this.bth != null && this.bth.size() > 8) {
                for (int size = this.bth.size() - 1; size >= 8; size--) {
                    this.bth.removeAt(size);
                }
            }
            this.btD.setData(ahVar);
        }
    }

    public void setDefaultReasonArray(String[] strArr) {
        this.btD.setDefaultReasonArray(strArr);
    }

    public void Tt() {
        if (this.mPopupWindow != null) {
            this.mPopupWindow.dismiss();
            this.mPopupWindow = null;
        }
        if (this.btA != null) {
            this.btA.dismiss();
            this.btA = null;
        }
    }

    private void Tv() {
        if (this.btE && this.btv.size() != 0) {
            this.btv.clear();
        }
    }

    private void Ef() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            al.c(this.btP, e.d.cp_cont_f, 1);
            al.c(this.btO, e.d.cp_cont_f, 1);
            al.j(this.mTopLine, e.d.cp_bg_line_b);
            al.j(this.btS, e.d.cp_bg_line_b);
            al.c(this.btQ, e.d.cp_cont_f, 1);
            al.c(this.btR, e.d.cp_cont_d, 1);
            this.mSkinType = skinType;
        }
    }

    private View getView() {
        if (this.mContext == null) {
            return null;
        }
        if (this.mContentView == null) {
            this.mContentView = (ViewGroup) LayoutInflater.from(this.mContext).inflate(e.h.neg_dt_head_popupwindow, (ViewGroup) null);
            this.btQ = (TextView) this.mContentView.findViewById(e.g.head_text);
            this.btR = (TextView) this.mContentView.findViewById(e.g.sub_head_text);
        }
        View rootView = this.btD.getRootView();
        if (rootView != null && rootView.getParent() == null) {
            int h = l.h(this.mContext, e.C0200e.ds40);
            rootView.setPadding(h, 0, h, 0);
            this.mContentView.addView(rootView);
        }
        if (this.btL == null) {
            this.btL = (LinearLayout) LayoutInflater.from(this.mContext).inflate(e.h.neg_dt_bottom_popupwindow, (ViewGroup) null);
            this.btP = (TextView) this.btL.findViewById(e.g.dialog_bottom_cancel_button);
            this.btO = (TextView) this.btL.findViewById(e.g.dialog_bottom_certain_button);
            this.mTopLine = this.btL.findViewById(e.g.top_line);
            this.btS = this.btL.findViewById(e.g.middle_line);
            this.mContentView.addView(this.btL);
            this.btP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.NEGFeedBack.e.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (e.this.btA != null) {
                        e.this.btA.dismiss();
                        e.this.btA = null;
                    }
                    if (e.this.mPopupWindow != null) {
                        e.this.mPopupWindow.dismiss();
                        e.this.mPopupWindow = null;
                    }
                    if (e.this.btM != null) {
                        e.this.btM.onClick();
                    }
                }
            });
            if (this.btO != null) {
                this.btO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.NEGFeedBack.e.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        JSONObject Tx = e.this.Tx();
                        if (e.this.mFrom == "3" || e.this.mFrom == "4" || e.this.mFrom == "1") {
                            e.this.Tt();
                        } else if (Tx != null) {
                            e.this.showLoadingView();
                            CustomMessage customMessage = new CustomMessage(2016489, e.this.mPageContext.getUniqueId());
                            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2016489, Tx);
                            customResponsedMessage.setOrginalMessage(customMessage);
                            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                        }
                    }
                });
            }
            Ef();
        }
        return this.mContentView;
    }

    public void a(b bVar) {
        this.btN = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLoadingView() {
        if (this.beC == null) {
            this.beC = new com.baidu.tbadk.core.view.d(this.mPageContext);
        }
        this.beC.dO(e.j.loading);
        this.beC.bz(true);
    }

    public void Tw() {
        if (this.beC != null) {
            this.beC.bz(false);
        }
    }

    public void iP(String str) {
        if (this.mContext != null) {
            this.mFrom = str;
            View view = getView();
            if (view != null && view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            Ef();
            this.mWindowHeight = getWindowMeasuredHeight() - l.h(this.mContext, e.C0200e.ds12);
            this.mPopupWindow = new PopupWindow(view, this.btw, this.mWindowHeight);
            this.mPopupWindow.setFocusable(true);
            this.mPopupWindow.setTouchable(true);
            this.mPopupWindow.setOnDismissListener(this.btG);
            Tv();
            this.btA = new PopupWindow(LayoutInflater.from(this.mContext).inflate(e.h.view_negative_feedback_bottom, (ViewGroup) null), -1, -1);
            if (Build.VERSION.SDK_INT >= 22) {
                this.btA.setAttachedInDecor(false);
            }
            this.btA.showAtLocation(this.mAnchor, 0, 0, 0);
            al.a(this.mPopupWindow, e.f.bg_dailog);
            this.mPopupWindow.showAtLocation(this.mAnchor, 17, 0, 0);
            if (this.btz != null) {
                this.btz.a(this.btu);
            }
            this.btE = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject Tx() {
        int i;
        JSONObject jSONObject = new JSONObject();
        if (this.btu == null) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        if (v.I(this.btv)) {
            i = 0;
        } else {
            i = 0;
            for (int i2 = 0; i2 < this.btv.size(); i2++) {
                b.a aVar = this.btv.get(i2);
                if (aVar != null) {
                    jSONArray.put(String.valueOf(aVar.id));
                    i = aVar.index + 1;
                }
            }
        }
        TiebaStatic.log(new am("c13123").ax(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.mFrom).x("obj_type", i));
        if (this.btN != null) {
            this.btN.m(jSONArray);
        }
        try {
            jSONObject.put(WebSocketAction.PARAM_KEY_REASON, jSONArray);
            jSONObject.put("thread_ids", this.btu.xD());
            jSONObject.put("type", this.btu.xC());
            jSONObject.put("forum_id", this.btu.getFid());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
