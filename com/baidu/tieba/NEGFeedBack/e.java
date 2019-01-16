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
    private int bxL;
    private int bxM;
    private PopupWindow bxP;
    private com.baidu.tieba.NEGFeedBack.b bxS;
    private boolean bxT;
    private LinearLayout bya;
    private a byb;
    private b byc;
    private TextView byd;
    private TextView bye;
    private TextView byf;
    private TextView byg;
    private View byh;
    private View mAnchor;
    private ViewGroup mContentView;
    private Context mContext;
    private String mFrom;
    private TbPageContext mPageContext;
    private View mTopLine;
    private int mWindowHeight;
    private int mXOffset;
    private PopupWindow mPopupWindow = null;
    private ah bxJ = null;
    private SparseArray<String> bxx = null;
    private List<b.a> bxK = new ArrayList();
    private NEGFeedBackView.a bxO = null;
    private int mSkinType = 3;
    private com.baidu.tbadk.core.view.d biP = null;
    private CompoundButton.OnCheckedChangeListener bxA = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.NEGFeedBack.e.1
        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (e.this.bxO != null) {
                e.this.bxO.a(e.this.bxJ, compoundButton, z);
            }
            if (compoundButton.getTag() instanceof b.a) {
                b.a aVar = (b.a) compoundButton.getTag();
                if (z) {
                    if (!e.this.bxK.contains(aVar)) {
                        e.this.bxK.add(aVar);
                        return;
                    }
                    return;
                }
                e.this.bxK.remove(aVar);
            }
        }
    };
    private PopupWindow.OnDismissListener bxV = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.NEGFeedBack.e.2
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (e.this.bxP != null) {
                e.this.bxP.dismiss();
                e.this.bxP = null;
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
        this.bxL = l.aO(this.mContext) - (this.mXOffset * 2);
        this.bxS = new com.baidu.tieba.NEGFeedBack.b(this.mPageContext);
        this.bxS.a(this.bxA);
        this.bxS.dn(true);
    }

    private int getWindowMeasuredHeight() {
        if (this.mContentView == null) {
            return 0;
        }
        this.mContentView.measure(0, 0);
        this.bxM = this.mContentView.getMeasuredHeight() + l.h(this.mContext, e.C0210e.ds12);
        return this.bxM;
    }

    public void setData(ah ahVar) {
        if (ahVar != null) {
            this.bxJ = ahVar;
            this.bxx = ahVar.yS();
            if (this.bxx != null && this.bxx.size() > 8) {
                for (int size = this.bxx.size() - 1; size >= 8; size--) {
                    this.bxx.removeAt(size);
                }
            }
            this.bxS.setData(ahVar);
        }
    }

    public void setDefaultReasonArray(String[] strArr) {
        this.bxS.setDefaultReasonArray(strArr);
    }

    public void UX() {
        if (this.mPopupWindow != null) {
            this.mPopupWindow.dismiss();
            this.mPopupWindow = null;
        }
        if (this.bxP != null) {
            this.bxP.dismiss();
            this.bxP = null;
        }
    }

    private void UZ() {
        if (this.bxT && this.bxK.size() != 0) {
            this.bxK.clear();
        }
    }

    private void Fw() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            al.c(this.bye, e.d.cp_cont_f, 1);
            al.c(this.byd, e.d.cp_cont_f, 1);
            al.j(this.mTopLine, e.d.cp_bg_line_b);
            al.j(this.byh, e.d.cp_bg_line_b);
            al.c(this.byf, e.d.cp_cont_f, 1);
            al.c(this.byg, e.d.cp_cont_d, 1);
            this.mSkinType = skinType;
        }
    }

    private View getView() {
        if (this.mContext == null) {
            return null;
        }
        if (this.mContentView == null) {
            this.mContentView = (ViewGroup) LayoutInflater.from(this.mContext).inflate(e.h.neg_dt_head_popupwindow, (ViewGroup) null);
            this.byf = (TextView) this.mContentView.findViewById(e.g.head_text);
            this.byg = (TextView) this.mContentView.findViewById(e.g.sub_head_text);
        }
        View rootView = this.bxS.getRootView();
        if (rootView != null && rootView.getParent() == null) {
            int h = l.h(this.mContext, e.C0210e.ds40);
            rootView.setPadding(h, 0, h, 0);
            this.mContentView.addView(rootView);
        }
        if (this.bya == null) {
            this.bya = (LinearLayout) LayoutInflater.from(this.mContext).inflate(e.h.neg_dt_bottom_popupwindow, (ViewGroup) null);
            this.bye = (TextView) this.bya.findViewById(e.g.dialog_bottom_cancel_button);
            this.byd = (TextView) this.bya.findViewById(e.g.dialog_bottom_certain_button);
            this.mTopLine = this.bya.findViewById(e.g.top_line);
            this.byh = this.bya.findViewById(e.g.middle_line);
            this.mContentView.addView(this.bya);
            this.bye.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.NEGFeedBack.e.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (e.this.bxP != null) {
                        e.this.bxP.dismiss();
                        e.this.bxP = null;
                    }
                    if (e.this.mPopupWindow != null) {
                        e.this.mPopupWindow.dismiss();
                        e.this.mPopupWindow = null;
                    }
                    if (e.this.byb != null) {
                        e.this.byb.onClick();
                    }
                }
            });
            if (this.byd != null) {
                this.byd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.NEGFeedBack.e.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        JSONObject Vb = e.this.Vb();
                        if (e.this.mFrom == "3" || e.this.mFrom == "4" || e.this.mFrom == "1") {
                            e.this.UX();
                        } else if (Vb != null) {
                            e.this.showLoadingView();
                            CustomMessage customMessage = new CustomMessage(2016489, e.this.mPageContext.getUniqueId());
                            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2016489, Vb);
                            customResponsedMessage.setOrginalMessage(customMessage);
                            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                        }
                    }
                });
            }
            Fw();
        }
        return this.mContentView;
    }

    public void a(b bVar) {
        this.byc = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLoadingView() {
        if (this.biP == null) {
            this.biP = new com.baidu.tbadk.core.view.d(this.mPageContext);
        }
        this.biP.ec(e.j.loading);
        this.biP.bB(true);
    }

    public void Va() {
        if (this.biP != null) {
            this.biP.bB(false);
        }
    }

    public void jy(String str) {
        if (this.mContext != null) {
            this.mFrom = str;
            View view = getView();
            if (view != null && view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            Fw();
            this.mWindowHeight = getWindowMeasuredHeight() - l.h(this.mContext, e.C0210e.ds12);
            this.mPopupWindow = new PopupWindow(view, this.bxL, this.mWindowHeight);
            this.mPopupWindow.setFocusable(true);
            this.mPopupWindow.setTouchable(true);
            this.mPopupWindow.setOnDismissListener(this.bxV);
            UZ();
            this.bxP = new PopupWindow(LayoutInflater.from(this.mContext).inflate(e.h.view_negative_feedback_bottom, (ViewGroup) null), -1, -1);
            if (Build.VERSION.SDK_INT >= 22) {
                this.bxP.setAttachedInDecor(false);
            }
            this.bxP.showAtLocation(this.mAnchor, 0, 0, 0);
            al.a(this.mPopupWindow, e.f.bg_dailog);
            this.mPopupWindow.showAtLocation(this.mAnchor, 17, 0, 0);
            if (this.bxO != null) {
                this.bxO.a(this.bxJ);
            }
            this.bxT = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject Vb() {
        int i;
        JSONObject jSONObject = new JSONObject();
        if (this.bxJ == null) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        if (v.I(this.bxK)) {
            i = 0;
        } else {
            i = 0;
            for (int i2 = 0; i2 < this.bxK.size(); i2++) {
                b.a aVar = this.bxK.get(i2);
                if (aVar != null) {
                    jSONArray.put(String.valueOf(aVar.id));
                    i = aVar.index + 1;
                }
            }
        }
        TiebaStatic.log(new am("c13123").aB(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.mFrom).y("obj_type", i));
        if (this.byc != null) {
            this.byc.m(jSONArray);
        }
        try {
            jSONObject.put(WebSocketAction.PARAM_KEY_REASON, jSONArray);
            jSONObject.put("thread_ids", this.bxJ.yU());
            jSONObject.put("type", this.bxJ.yT());
            jSONObject.put("forum_id", this.bxJ.getFid());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
