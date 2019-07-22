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
    private int cSA;
    private PopupWindow cSE;
    private com.baidu.tieba.NEGFeedBack.b cSH;
    private boolean cSI;
    private LinearLayout cSQ;
    private a cSR;
    private b cSS;
    private TextView cST;
    private TextView cSU;
    private TextView cSV;
    private TextView cSW;
    private View cSX;
    private int cSz;
    private View mAnchor;
    private ViewGroup mContentView;
    private Context mContext;
    private String mFrom;
    private TbPageContext mPageContext;
    private View mTopLine;
    private int mWindowHeight;
    private int mXOffset;
    private PopupWindow aPu = null;
    private aj cSx = null;
    private SparseArray<String> cSj = null;
    private List<b.a> cSy = new ArrayList();
    private NEGFeedBackView.a cSD = null;
    private int mSkinType = 3;
    private com.baidu.tbadk.core.view.b cCo = null;
    private CompoundButton.OnCheckedChangeListener cSm = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.NEGFeedBack.e.1
        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (e.this.cSD != null) {
                e.this.cSD.a(e.this.cSx, compoundButton, z);
            }
            if (compoundButton.getTag() instanceof b.a) {
                b.a aVar = (b.a) compoundButton.getTag();
                if (z) {
                    if (!e.this.cSy.contains(aVar)) {
                        e.this.cSy.add(aVar);
                        return;
                    }
                    return;
                }
                e.this.cSy.remove(aVar);
            }
        }
    };
    private PopupWindow.OnDismissListener cSL = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.NEGFeedBack.e.2
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (e.this.cSE != null) {
                e.this.cSE.dismiss();
                e.this.cSE = null;
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
        this.cSz = l.af(this.mContext) - (this.mXOffset * 2);
        this.cSH = new com.baidu.tieba.NEGFeedBack.b(this.mPageContext);
        this.cSH.a(this.cSm);
        this.cSH.ge(true);
    }

    private int getWindowMeasuredHeight() {
        if (this.mContentView == null) {
            return 0;
        }
        this.mContentView.measure(0, 0);
        this.cSA = this.mContentView.getMeasuredHeight() + l.g(this.mContext, R.dimen.ds12);
        return this.cSA;
    }

    public void setData(aj ajVar) {
        if (ajVar != null) {
            this.cSx = ajVar;
            this.cSj = ajVar.adg();
            if (this.cSj != null && this.cSj.size() > 8) {
                for (int size = this.cSj.size() - 1; size >= 8; size--) {
                    this.cSj.removeAt(size);
                }
            }
            this.cSH.setData(ajVar);
        }
    }

    public void setDefaultReasonArray(String[] strArr) {
        this.cSH.setDefaultReasonArray(strArr);
    }

    public void aBn() {
        if (this.aPu != null) {
            this.aPu.dismiss();
            this.aPu = null;
        }
        if (this.cSE != null) {
            this.cSE.dismiss();
            this.cSE = null;
        }
    }

    private void aBr() {
        if (this.cSI && this.cSy.size() != 0) {
            this.cSy.clear();
        }
    }

    private void akL() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            am.f(this.cSU, R.color.cp_cont_f, 1);
            am.f(this.cST, R.color.cp_cont_f, 1);
            am.l(this.mTopLine, R.color.cp_bg_line_b);
            am.l(this.cSX, R.color.cp_bg_line_b);
            am.f(this.cSV, R.color.cp_cont_f, 1);
            am.f(this.cSW, R.color.cp_cont_d, 1);
            this.mSkinType = skinType;
        }
    }

    private View getView() {
        if (this.mContext == null) {
            return null;
        }
        if (this.mContentView == null) {
            this.mContentView = (ViewGroup) LayoutInflater.from(this.mContext).inflate(R.layout.neg_dt_head_popupwindow, (ViewGroup) null);
            this.cSV = (TextView) this.mContentView.findViewById(R.id.head_text);
            this.cSW = (TextView) this.mContentView.findViewById(R.id.sub_head_text);
        }
        View rootView = this.cSH.getRootView();
        if (rootView != null && rootView.getParent() == null) {
            int g = l.g(this.mContext, R.dimen.ds40);
            rootView.setPadding(g, 0, g, 0);
            this.mContentView.addView(rootView);
        }
        if (this.cSQ == null) {
            this.cSQ = (LinearLayout) LayoutInflater.from(this.mContext).inflate(R.layout.neg_dt_bottom_popupwindow, (ViewGroup) null);
            this.cSU = (TextView) this.cSQ.findViewById(R.id.dialog_bottom_cancel_button);
            this.cST = (TextView) this.cSQ.findViewById(R.id.dialog_bottom_certain_button);
            this.mTopLine = this.cSQ.findViewById(R.id.top_line);
            this.cSX = this.cSQ.findViewById(R.id.middle_line);
            this.mContentView.addView(this.cSQ);
            this.cSU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.NEGFeedBack.e.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (e.this.cSE != null) {
                        e.this.cSE.dismiss();
                        e.this.cSE = null;
                    }
                    if (e.this.aPu != null) {
                        e.this.aPu.dismiss();
                        e.this.aPu = null;
                    }
                    if (e.this.cSR != null) {
                        e.this.cSR.onClick();
                    }
                }
            });
            if (this.cST != null) {
                this.cST.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.NEGFeedBack.e.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        JSONObject aBt = e.this.aBt();
                        if (e.this.mFrom == "3" || e.this.mFrom == "4" || e.this.mFrom == "1") {
                            e.this.aBn();
                        } else if (aBt != null) {
                            e.this.showLoadingView();
                            CustomMessage customMessage = new CustomMessage(2016489, e.this.mPageContext.getUniqueId());
                            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2016489, aBt);
                            customResponsedMessage.setOrginalMessage(customMessage);
                            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                        }
                    }
                });
            }
            akL();
        }
        return this.mContentView;
    }

    public void a(b bVar) {
        this.cSS = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLoadingView() {
        if (this.cCo == null) {
            this.cCo = new com.baidu.tbadk.core.view.b(this.mPageContext);
        }
        this.cCo.iz(R.string.loading);
        this.cCo.ej(true);
    }

    public void aBs() {
        if (this.cCo != null) {
            this.cCo.ej(false);
        }
    }

    public void rJ(String str) {
        if (this.mContext != null) {
            this.mFrom = str;
            View view = getView();
            if (view != null && view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            akL();
            this.mWindowHeight = getWindowMeasuredHeight() - l.g(this.mContext, R.dimen.ds12);
            this.aPu = new PopupWindow(view, this.cSz, this.mWindowHeight);
            this.aPu.setFocusable(true);
            this.aPu.setTouchable(true);
            this.aPu.setOnDismissListener(this.cSL);
            aBr();
            this.cSE = new PopupWindow(LayoutInflater.from(this.mContext).inflate(R.layout.view_negative_feedback_bottom, (ViewGroup) null), -1, -1);
            if (Build.VERSION.SDK_INT >= 22) {
                this.cSE.setAttachedInDecor(false);
            }
            this.cSE.showAtLocation(this.mAnchor, 0, 0, 0);
            am.a(this.aPu, (int) R.drawable.bg_dailog);
            this.aPu.showAtLocation(this.mAnchor, 17, 0, 0);
            if (this.cSD != null) {
                this.cSD.b(this.cSx);
            }
            this.cSI = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject aBt() {
        int i;
        JSONObject jSONObject = new JSONObject();
        if (this.cSx == null) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        if (v.aa(this.cSy)) {
            i = 0;
        } else {
            i = 0;
            for (int i2 = 0; i2 < this.cSy.size(); i2++) {
                b.a aVar = this.cSy.get(i2);
                if (aVar != null) {
                    jSONArray.put(String.valueOf(aVar.id));
                    i = aVar.index + 1;
                }
            }
        }
        TiebaStatic.log(new an("c13123").bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.mFrom).P("obj_type", i));
        if (this.cSS != null) {
            this.cSS.C(jSONArray);
        }
        try {
            jSONObject.put("reason", jSONArray);
            jSONObject.put("thread_ids", this.cSx.adi());
            jSONObject.put("type", this.cSx.adh());
            jSONObject.put("forum_id", this.cSx.getFid());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
