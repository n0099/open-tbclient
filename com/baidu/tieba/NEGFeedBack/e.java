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
import com.baidu.tieba.f;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class e {
    private int biZ;
    private int bja;
    private PopupWindow bjd;
    private com.baidu.tieba.NEGFeedBack.b bjg;
    private boolean bjh;
    private LinearLayout bjo;
    private a bjp;
    private b bjq;
    private TextView bjr;
    private TextView bjs;
    private TextView bjt;
    private TextView bju;
    private View bjv;
    private View mAnchor;
    private ViewGroup mContentView;
    private Context mContext;
    private String mFrom;
    private TbPageContext mPageContext;
    private View mTopLine;
    private int mWindowHeight;
    private int mXOffset;
    private PopupWindow biW = null;
    private ah biX = null;
    private SparseArray<String> biJ = null;
    private List<b.a> biY = new ArrayList();
    private NEGFeedBackView.a bjc = null;
    private int mSkinType = 3;
    private com.baidu.tbadk.core.view.a aVY = null;
    private CompoundButton.OnCheckedChangeListener biM = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.NEGFeedBack.e.1
        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (e.this.bjc != null) {
                e.this.bjc.a(e.this.biX, compoundButton, z);
            }
            if (compoundButton.getTag() instanceof b.a) {
                b.a aVar = (b.a) compoundButton.getTag();
                if (z) {
                    if (!e.this.biY.contains(aVar)) {
                        e.this.biY.add(aVar);
                        return;
                    }
                    return;
                }
                e.this.biY.remove(aVar);
            }
        }
    };
    private PopupWindow.OnDismissListener bjj = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.NEGFeedBack.e.2
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (e.this.bjd != null) {
                e.this.bjd.dismiss();
                e.this.bjd = null;
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
        this.mXOffset = l.f(this.mContext, f.e.tbds32);
        this.biZ = l.ah(this.mContext) - (this.mXOffset * 2);
        this.bjg = new com.baidu.tieba.NEGFeedBack.b(this.mPageContext);
        this.bjg.a(this.biM);
        this.bjg.cs(true);
    }

    private int getWindowMeasuredHeight() {
        if (this.mContentView == null) {
            return 0;
        }
        this.mContentView.measure(0, 0);
        this.bja = this.mContentView.getMeasuredHeight() + l.f(this.mContext, f.e.ds12);
        return this.bja;
    }

    public void setData(ah ahVar) {
        if (ahVar != null) {
            this.biX = ahVar;
            this.biJ = ahVar.uh();
            if (this.biJ != null && this.biJ.size() > 8) {
                for (int size = this.biJ.size() - 1; size >= 8; size--) {
                    this.biJ.removeAt(size);
                }
            }
            this.bjg.setData(ahVar);
        }
    }

    public void setDefaultReasonArray(String[] strArr) {
        this.bjg.setDefaultReasonArray(strArr);
    }

    public void PB() {
        if (this.biW != null) {
            this.biW.dismiss();
            this.biW = null;
        }
        if (this.bjd != null) {
            this.bjd.dismiss();
            this.bjd = null;
        }
    }

    private void PD() {
        if (this.bjh && this.biY.size() != 0) {
            this.biY.clear();
        }
    }

    private void AD() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            am.c(this.bjs, f.d.cp_cont_f, 1);
            am.c(this.bjr, f.d.cp_cont_f, 1);
            am.j(this.mTopLine, f.d.cp_bg_line_b);
            am.j(this.bjv, f.d.cp_bg_line_b);
            am.c(this.bjt, f.d.cp_cont_f, 1);
            am.c(this.bju, f.d.cp_cont_d, 1);
            this.mSkinType = skinType;
        }
    }

    private View getView() {
        if (this.mContext == null) {
            return null;
        }
        if (this.mContentView == null) {
            this.mContentView = (ViewGroup) LayoutInflater.from(this.mContext).inflate(f.h.neg_dt_head_popupwindow, (ViewGroup) null);
            this.bjt = (TextView) this.mContentView.findViewById(f.g.head_text);
            this.bju = (TextView) this.mContentView.findViewById(f.g.sub_head_text);
        }
        View rootView = this.bjg.getRootView();
        if (rootView != null && rootView.getParent() == null) {
            int f = l.f(this.mContext, f.e.ds40);
            rootView.setPadding(f, 0, f, 0);
            this.mContentView.addView(rootView);
        }
        if (this.bjo == null) {
            this.bjo = (LinearLayout) LayoutInflater.from(this.mContext).inflate(f.h.neg_dt_bottom_popupwindow, (ViewGroup) null);
            this.bjs = (TextView) this.bjo.findViewById(f.g.dialog_bottom_cancel_button);
            this.bjr = (TextView) this.bjo.findViewById(f.g.dialog_bottom_certain_button);
            this.mTopLine = this.bjo.findViewById(f.g.top_line);
            this.bjv = this.bjo.findViewById(f.g.middle_line);
            this.mContentView.addView(this.bjo);
            this.bjs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.NEGFeedBack.e.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (e.this.bjd != null) {
                        e.this.bjd.dismiss();
                        e.this.bjd = null;
                    }
                    if (e.this.biW != null) {
                        e.this.biW.dismiss();
                        e.this.biW = null;
                    }
                    if (e.this.bjp != null) {
                        e.this.bjp.onClick();
                    }
                }
            });
            if (this.bjr != null) {
                this.bjr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.NEGFeedBack.e.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        JSONObject PF = e.this.PF();
                        if (e.this.mFrom == "3" || e.this.mFrom == "4" || e.this.mFrom == "1") {
                            e.this.PB();
                        } else if (PF != null) {
                            e.this.showLoadingView();
                            CustomMessage customMessage = new CustomMessage(2016489, e.this.mPageContext.getUniqueId());
                            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2016489, PF);
                            customResponsedMessage.setOrginalMessage(customMessage);
                            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                        }
                    }
                });
            }
            AD();
        }
        return this.mContentView;
    }

    public void a(b bVar) {
        this.bjq = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLoadingView() {
        if (this.aVY == null) {
            this.aVY = new com.baidu.tbadk.core.view.a(this.mPageContext);
        }
        this.aVY.df(f.j.loading);
        this.aVY.aN(true);
    }

    public void PE() {
        if (this.aVY != null) {
            this.aVY.aN(false);
        }
    }

    public void hZ(String str) {
        if (this.mContext != null) {
            this.mFrom = str;
            View view = getView();
            if (view != null && view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            AD();
            this.mWindowHeight = getWindowMeasuredHeight() - l.f(this.mContext, f.e.ds12);
            this.biW = new PopupWindow(view, this.biZ, this.mWindowHeight);
            this.biW.setFocusable(true);
            this.biW.setTouchable(true);
            this.biW.setOnDismissListener(this.bjj);
            PD();
            this.bjd = new PopupWindow(LayoutInflater.from(this.mContext).inflate(f.h.view_negative_feedback_bottom, (ViewGroup) null), -1, -1);
            if (Build.VERSION.SDK_INT >= 22) {
                this.bjd.setAttachedInDecor(false);
            }
            this.bjd.showAtLocation(this.mAnchor, 0, 0, 0);
            am.a(this.biW, f.C0146f.bg_dailog);
            this.biW.showAtLocation(this.mAnchor, 17, 0, 0);
            if (this.bjc != null) {
                this.bjc.a(this.biX);
            }
            this.bjh = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject PF() {
        int i;
        JSONObject jSONObject = new JSONObject();
        if (this.biX == null) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        if (w.z(this.biY)) {
            i = 0;
        } else {
            i = 0;
            for (int i2 = 0; i2 < this.biY.size(); i2++) {
                b.a aVar = this.biY.get(i2);
                if (aVar != null) {
                    jSONArray.put(String.valueOf(aVar.id));
                    i = aVar.index + 1;
                }
            }
        }
        TiebaStatic.log(new an("c13123").ae(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.mFrom).r("obj_type", i));
        if (this.bjq != null) {
            this.bjq.f(jSONArray);
        }
        try {
            jSONObject.put("reason", jSONArray);
            jSONObject.put("thread_ids", this.biX.uj());
            jSONObject.put("type", this.biX.ui());
            jSONObject.put("forum_id", this.biX.getFid());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
