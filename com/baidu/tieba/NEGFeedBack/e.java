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
/* loaded from: classes2.dex */
public class e {
    private int boJ;
    private int boK;
    private PopupWindow boN;
    private com.baidu.tieba.NEGFeedBack.b boQ;
    private boolean boR;
    private LinearLayout boY;
    private a boZ;
    private b bpa;
    private TextView bpb;
    private TextView bpc;
    private TextView bpd;
    private TextView bpe;
    private View bpf;
    private View mAnchor;
    private ViewGroup mContentView;
    private Context mContext;
    private String mFrom;
    private TbPageContext mPageContext;
    private View mTopLine;
    private int mWindowHeight;
    private int mXOffset;
    private PopupWindow boG = null;
    private ah boH = null;
    private SparseArray<String> bot = null;
    private List<b.a> boI = new ArrayList();
    private NEGFeedBackView.a boM = null;
    private int mSkinType = 3;
    private com.baidu.tbadk.core.view.d aZn = null;
    private CompoundButton.OnCheckedChangeListener bow = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.NEGFeedBack.e.1
        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (e.this.boM != null) {
                e.this.boM.a(e.this.boH, compoundButton, z);
            }
            if (compoundButton.getTag() instanceof b.a) {
                b.a aVar = (b.a) compoundButton.getTag();
                if (z) {
                    if (!e.this.boI.contains(aVar)) {
                        e.this.boI.add(aVar);
                        return;
                    }
                    return;
                }
                e.this.boI.remove(aVar);
            }
        }
    };
    private PopupWindow.OnDismissListener boT = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.NEGFeedBack.e.2
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (e.this.boN != null) {
                e.this.boN.dismiss();
                e.this.boN = null;
            }
        }
    };

    /* loaded from: classes2.dex */
    public interface a {
        void onClick();
    }

    /* loaded from: classes2.dex */
    public interface b {
        void j(JSONArray jSONArray);
    }

    public e(TbPageContext tbPageContext, View view) {
        this.mContext = null;
        this.mContext = tbPageContext.getPageActivity();
        this.mPageContext = tbPageContext;
        this.mAnchor = view;
        init();
    }

    private void init() {
        this.mXOffset = l.h(this.mContext, e.C0141e.tbds32);
        this.boJ = l.aO(this.mContext) - (this.mXOffset * 2);
        this.boQ = new com.baidu.tieba.NEGFeedBack.b(this.mPageContext);
        this.boQ.a(this.bow);
        this.boQ.cJ(true);
    }

    private int getWindowMeasuredHeight() {
        if (this.mContentView == null) {
            return 0;
        }
        this.mContentView.measure(0, 0);
        this.boK = this.mContentView.getMeasuredHeight() + l.h(this.mContext, e.C0141e.ds12);
        return this.boK;
    }

    public void setData(ah ahVar) {
        if (ahVar != null) {
            this.boH = ahVar;
            this.bot = ahVar.vk();
            if (this.bot != null && this.bot.size() > 8) {
                for (int size = this.bot.size() - 1; size >= 8; size--) {
                    this.bot.removeAt(size);
                }
            }
            this.boQ.setData(ahVar);
        }
    }

    public void setDefaultReasonArray(String[] strArr) {
        this.boQ.setDefaultReasonArray(strArr);
    }

    public void Ro() {
        if (this.boG != null) {
            this.boG.dismiss();
            this.boG = null;
        }
        if (this.boN != null) {
            this.boN.dismiss();
            this.boN = null;
        }
    }

    private void Rq() {
        if (this.boR && this.boI.size() != 0) {
            this.boI.clear();
        }
    }

    private void BQ() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            al.c(this.bpc, e.d.cp_cont_f, 1);
            al.c(this.bpb, e.d.cp_cont_f, 1);
            al.j(this.mTopLine, e.d.cp_bg_line_b);
            al.j(this.bpf, e.d.cp_bg_line_b);
            al.c(this.bpd, e.d.cp_cont_f, 1);
            al.c(this.bpe, e.d.cp_cont_d, 1);
            this.mSkinType = skinType;
        }
    }

    private View getView() {
        if (this.mContext == null) {
            return null;
        }
        if (this.mContentView == null) {
            this.mContentView = (ViewGroup) LayoutInflater.from(this.mContext).inflate(e.h.neg_dt_head_popupwindow, (ViewGroup) null);
            this.bpd = (TextView) this.mContentView.findViewById(e.g.head_text);
            this.bpe = (TextView) this.mContentView.findViewById(e.g.sub_head_text);
        }
        View rootView = this.boQ.getRootView();
        if (rootView != null && rootView.getParent() == null) {
            int h = l.h(this.mContext, e.C0141e.ds40);
            rootView.setPadding(h, 0, h, 0);
            this.mContentView.addView(rootView);
        }
        if (this.boY == null) {
            this.boY = (LinearLayout) LayoutInflater.from(this.mContext).inflate(e.h.neg_dt_bottom_popupwindow, (ViewGroup) null);
            this.bpc = (TextView) this.boY.findViewById(e.g.dialog_bottom_cancel_button);
            this.bpb = (TextView) this.boY.findViewById(e.g.dialog_bottom_certain_button);
            this.mTopLine = this.boY.findViewById(e.g.top_line);
            this.bpf = this.boY.findViewById(e.g.middle_line);
            this.mContentView.addView(this.boY);
            this.bpc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.NEGFeedBack.e.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (e.this.boN != null) {
                        e.this.boN.dismiss();
                        e.this.boN = null;
                    }
                    if (e.this.boG != null) {
                        e.this.boG.dismiss();
                        e.this.boG = null;
                    }
                    if (e.this.boZ != null) {
                        e.this.boZ.onClick();
                    }
                }
            });
            if (this.bpb != null) {
                this.bpb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.NEGFeedBack.e.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        JSONObject Rs = e.this.Rs();
                        if (e.this.mFrom == "3" || e.this.mFrom == "4" || e.this.mFrom == "1") {
                            e.this.Ro();
                        } else if (Rs != null) {
                            e.this.showLoadingView();
                            CustomMessage customMessage = new CustomMessage(2016489, e.this.mPageContext.getUniqueId());
                            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2016489, Rs);
                            customResponsedMessage.setOrginalMessage(customMessage);
                            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                        }
                    }
                });
            }
            BQ();
        }
        return this.mContentView;
    }

    public void a(b bVar) {
        this.bpa = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLoadingView() {
        if (this.aZn == null) {
            this.aZn = new com.baidu.tbadk.core.view.d(this.mPageContext);
        }
        this.aZn.dq(e.j.loading);
        this.aZn.aZ(true);
    }

    public void Rr() {
        if (this.aZn != null) {
            this.aZn.aZ(false);
        }
    }

    public void iA(String str) {
        if (this.mContext != null) {
            this.mFrom = str;
            View view = getView();
            if (view != null && view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            BQ();
            this.mWindowHeight = getWindowMeasuredHeight() - l.h(this.mContext, e.C0141e.ds12);
            this.boG = new PopupWindow(view, this.boJ, this.mWindowHeight);
            this.boG.setFocusable(true);
            this.boG.setTouchable(true);
            this.boG.setOnDismissListener(this.boT);
            Rq();
            this.boN = new PopupWindow(LayoutInflater.from(this.mContext).inflate(e.h.view_negative_feedback_bottom, (ViewGroup) null), -1, -1);
            if (Build.VERSION.SDK_INT >= 22) {
                this.boN.setAttachedInDecor(false);
            }
            this.boN.showAtLocation(this.mAnchor, 0, 0, 0);
            al.a(this.boG, e.f.bg_dailog);
            this.boG.showAtLocation(this.mAnchor, 17, 0, 0);
            if (this.boM != null) {
                this.boM.a(this.boH);
            }
            this.boR = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject Rs() {
        int i;
        JSONObject jSONObject = new JSONObject();
        if (this.boH == null) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        if (v.z(this.boI)) {
            i = 0;
        } else {
            i = 0;
            for (int i2 = 0; i2 < this.boI.size(); i2++) {
                b.a aVar = this.boI.get(i2);
                if (aVar != null) {
                    jSONArray.put(String.valueOf(aVar.id));
                    i = aVar.index + 1;
                }
            }
        }
        TiebaStatic.log(new am("c13123").al(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.mFrom).w("obj_type", i));
        if (this.bpa != null) {
            this.bpa.j(jSONArray);
        }
        try {
            jSONObject.put("reason", jSONArray);
            jSONObject.put("thread_ids", this.boH.vm());
            jSONObject.put("type", this.boH.vl());
            jSONObject.put("forum_id", this.boH.getFid());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
