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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.NEGFeedBack.b;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class e {
    private int cSG;
    private int cSH;
    private PopupWindow cSL;
    private com.baidu.tieba.NEGFeedBack.b cSO;
    private boolean cSP;
    private LinearLayout cSX;
    private a cSY;
    private b cSZ;
    private TextView cTa;
    private TextView cTb;
    private TextView cTc;
    private TextView cTd;
    private View cTe;
    private View mAnchor;
    private ViewGroup mContentView;
    private Context mContext;
    private String mFrom;
    private TbPageContext mPageContext;
    private View mTopLine;
    private int mWindowHeight;
    private int mXOffset;
    private PopupWindow aPu = null;
    private aj cSE = null;
    private SparseArray<String> cSq = null;
    private List<b.a> cSF = new ArrayList();
    private NEGFeedBackView.a cSK = null;
    private int mSkinType = 3;
    private com.baidu.tbadk.core.view.b cCv = null;
    private CompoundButton.OnCheckedChangeListener cSt = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.NEGFeedBack.e.1
        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (e.this.cSK != null) {
                e.this.cSK.a(e.this.cSE, compoundButton, z);
            }
            if (compoundButton.getTag() instanceof b.a) {
                b.a aVar = (b.a) compoundButton.getTag();
                if (z) {
                    if (!e.this.cSF.contains(aVar)) {
                        e.this.cSF.add(aVar);
                        return;
                    }
                    return;
                }
                e.this.cSF.remove(aVar);
            }
        }
    };
    private PopupWindow.OnDismissListener cSS = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.NEGFeedBack.e.2
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (e.this.cSL != null) {
                e.this.cSL.dismiss();
                e.this.cSL = null;
            }
        }
    };

    /* loaded from: classes3.dex */
    public interface a {
        void onClick();
    }

    /* loaded from: classes3.dex */
    public interface b {
        void C(JSONArray jSONArray);
    }

    public e(TbPageContext tbPageContext, View view) {
        this.mContext = null;
        this.mContext = tbPageContext.getPageActivity();
        this.mPageContext = tbPageContext;
        this.mAnchor = view;
        init();
    }

    private void init() {
        this.mXOffset = l.g(this.mContext, R.dimen.tbds32);
        this.cSG = l.af(this.mContext) - (this.mXOffset * 2);
        this.cSO = new com.baidu.tieba.NEGFeedBack.b(this.mPageContext);
        this.cSO.a(this.cSt);
        this.cSO.ge(true);
    }

    private int getWindowMeasuredHeight() {
        if (this.mContentView == null) {
            return 0;
        }
        this.mContentView.measure(0, 0);
        this.cSH = this.mContentView.getMeasuredHeight() + l.g(this.mContext, R.dimen.ds12);
        return this.cSH;
    }

    public void setData(aj ajVar) {
        if (ajVar != null) {
            this.cSE = ajVar;
            this.cSq = ajVar.adh();
            if (this.cSq != null && this.cSq.size() > 8) {
                for (int size = this.cSq.size() - 1; size >= 8; size--) {
                    this.cSq.removeAt(size);
                }
            }
            this.cSO.setData(ajVar);
        }
    }

    public void setDefaultReasonArray(String[] strArr) {
        this.cSO.setDefaultReasonArray(strArr);
    }

    public void aBp() {
        if (this.aPu != null) {
            this.aPu.dismiss();
            this.aPu = null;
        }
        if (this.cSL != null) {
            this.cSL.dismiss();
            this.cSL = null;
        }
    }

    private void aBt() {
        if (this.cSP && this.cSF.size() != 0) {
            this.cSF.clear();
        }
    }

    private void akN() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            am.f(this.cTb, R.color.cp_cont_f, 1);
            am.f(this.cTa, R.color.cp_cont_f, 1);
            am.l(this.mTopLine, R.color.cp_bg_line_b);
            am.l(this.cTe, R.color.cp_bg_line_b);
            am.f(this.cTc, R.color.cp_cont_f, 1);
            am.f(this.cTd, R.color.cp_cont_d, 1);
            this.mSkinType = skinType;
        }
    }

    private View getView() {
        if (this.mContext == null) {
            return null;
        }
        if (this.mContentView == null) {
            this.mContentView = (ViewGroup) LayoutInflater.from(this.mContext).inflate(R.layout.neg_dt_head_popupwindow, (ViewGroup) null);
            this.cTc = (TextView) this.mContentView.findViewById(R.id.head_text);
            this.cTd = (TextView) this.mContentView.findViewById(R.id.sub_head_text);
        }
        View rootView = this.cSO.getRootView();
        if (rootView != null && rootView.getParent() == null) {
            int g = l.g(this.mContext, R.dimen.ds40);
            rootView.setPadding(g, 0, g, 0);
            this.mContentView.addView(rootView);
        }
        if (this.cSX == null) {
            this.cSX = (LinearLayout) LayoutInflater.from(this.mContext).inflate(R.layout.neg_dt_bottom_popupwindow, (ViewGroup) null);
            this.cTb = (TextView) this.cSX.findViewById(R.id.dialog_bottom_cancel_button);
            this.cTa = (TextView) this.cSX.findViewById(R.id.dialog_bottom_certain_button);
            this.mTopLine = this.cSX.findViewById(R.id.top_line);
            this.cTe = this.cSX.findViewById(R.id.middle_line);
            this.mContentView.addView(this.cSX);
            this.cTb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.NEGFeedBack.e.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (e.this.cSL != null) {
                        e.this.cSL.dismiss();
                        e.this.cSL = null;
                    }
                    if (e.this.aPu != null) {
                        e.this.aPu.dismiss();
                        e.this.aPu = null;
                    }
                    if (e.this.cSY != null) {
                        e.this.cSY.onClick();
                    }
                }
            });
            if (this.cTa != null) {
                this.cTa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.NEGFeedBack.e.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        JSONObject aBv = e.this.aBv();
                        if (e.this.mFrom == "3" || e.this.mFrom == "4" || e.this.mFrom == "1") {
                            e.this.aBp();
                        } else if (aBv != null) {
                            e.this.showLoadingView();
                            CustomMessage customMessage = new CustomMessage(2016489, e.this.mPageContext.getUniqueId());
                            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2016489, aBv);
                            customResponsedMessage.setOrginalMessage(customMessage);
                            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                        }
                    }
                });
            }
            akN();
        }
        return this.mContentView;
    }

    public void a(b bVar) {
        this.cSZ = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLoadingView() {
        if (this.cCv == null) {
            this.cCv = new com.baidu.tbadk.core.view.b(this.mPageContext);
        }
        this.cCv.iz(R.string.loading);
        this.cCv.ej(true);
    }

    public void aBu() {
        if (this.cCv != null) {
            this.cCv.ej(false);
        }
    }

    public void rJ(String str) {
        if (this.mContext != null) {
            this.mFrom = str;
            View view = getView();
            if (view != null && view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            akN();
            this.mWindowHeight = getWindowMeasuredHeight() - l.g(this.mContext, R.dimen.ds12);
            this.aPu = new PopupWindow(view, this.cSG, this.mWindowHeight);
            this.aPu.setFocusable(true);
            this.aPu.setTouchable(true);
            this.aPu.setOnDismissListener(this.cSS);
            aBt();
            this.cSL = new PopupWindow(LayoutInflater.from(this.mContext).inflate(R.layout.view_negative_feedback_bottom, (ViewGroup) null), -1, -1);
            if (Build.VERSION.SDK_INT >= 22) {
                this.cSL.setAttachedInDecor(false);
            }
            this.cSL.showAtLocation(this.mAnchor, 0, 0, 0);
            am.a(this.aPu, (int) R.drawable.bg_dailog);
            this.aPu.showAtLocation(this.mAnchor, 17, 0, 0);
            if (this.cSK != null) {
                this.cSK.b(this.cSE);
            }
            this.cSP = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject aBv() {
        int i;
        JSONObject jSONObject = new JSONObject();
        if (this.cSE == null) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        if (v.aa(this.cSF)) {
            i = 0;
        } else {
            i = 0;
            for (int i2 = 0; i2 < this.cSF.size(); i2++) {
                b.a aVar = this.cSF.get(i2);
                if (aVar != null) {
                    jSONArray.put(String.valueOf(aVar.id));
                    i = aVar.index + 1;
                }
            }
        }
        TiebaStatic.log(new an("c13123").bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.mFrom).P("obj_type", i));
        if (this.cSZ != null) {
            this.cSZ.C(jSONArray);
        }
        try {
            jSONObject.put("reason", jSONArray);
            jSONObject.put("thread_ids", this.cSE.adj());
            jSONObject.put("type", this.cSE.adi());
            jSONObject.put("forum_id", this.cSE.getFid());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
