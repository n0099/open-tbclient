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
    private int cTA;
    private PopupWindow cTE;
    private com.baidu.tieba.NEGFeedBack.b cTH;
    private boolean cTI;
    private LinearLayout cTQ;
    private a cTR;
    private b cTS;
    private TextView cTT;
    private TextView cTU;
    private TextView cTV;
    private TextView cTW;
    private View cTX;
    private int cTz;
    private View mAnchor;
    private ViewGroup mContentView;
    private Context mContext;
    private String mFrom;
    private TbPageContext mPageContext;
    private View mTopLine;
    private int mWindowHeight;
    private int mXOffset;
    private PopupWindow aPS = null;
    private aj cTx = null;
    private SparseArray<String> cTj = null;
    private List<b.a> cTy = new ArrayList();
    private NEGFeedBackView.a cTD = null;
    private int mSkinType = 3;
    private com.baidu.tbadk.core.view.b cDr = null;
    private CompoundButton.OnCheckedChangeListener cTm = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.NEGFeedBack.e.1
        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (e.this.cTD != null) {
                e.this.cTD.a(e.this.cTx, compoundButton, z);
            }
            if (compoundButton.getTag() instanceof b.a) {
                b.a aVar = (b.a) compoundButton.getTag();
                if (z) {
                    if (!e.this.cTy.contains(aVar)) {
                        e.this.cTy.add(aVar);
                        return;
                    }
                    return;
                }
                e.this.cTy.remove(aVar);
            }
        }
    };
    private PopupWindow.OnDismissListener cTL = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.NEGFeedBack.e.2
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (e.this.cTE != null) {
                e.this.cTE.dismiss();
                e.this.cTE = null;
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
        this.cTz = l.af(this.mContext) - (this.mXOffset * 2);
        this.cTH = new com.baidu.tieba.NEGFeedBack.b(this.mPageContext);
        this.cTH.a(this.cTm);
        this.cTH.gh(true);
    }

    private int getWindowMeasuredHeight() {
        if (this.mContentView == null) {
            return 0;
        }
        this.mContentView.measure(0, 0);
        this.cTA = this.mContentView.getMeasuredHeight() + l.g(this.mContext, R.dimen.ds12);
        return this.cTA;
    }

    public void setData(aj ajVar) {
        if (ajVar != null) {
            this.cTx = ajVar;
            this.cTj = ajVar.adl();
            if (this.cTj != null && this.cTj.size() > 8) {
                for (int size = this.cTj.size() - 1; size >= 8; size--) {
                    this.cTj.removeAt(size);
                }
            }
            this.cTH.setData(ajVar);
        }
    }

    public void setDefaultReasonArray(String[] strArr) {
        this.cTH.setDefaultReasonArray(strArr);
    }

    public void aBD() {
        if (this.aPS != null) {
            this.aPS.dismiss();
            this.aPS = null;
        }
        if (this.cTE != null) {
            this.cTE.dismiss();
            this.cTE = null;
        }
    }

    private void aBH() {
        if (this.cTI && this.cTy.size() != 0) {
            this.cTy.clear();
        }
    }

    private void akZ() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            am.f(this.cTU, R.color.cp_cont_f, 1);
            am.f(this.cTT, R.color.cp_cont_f, 1);
            am.l(this.mTopLine, R.color.cp_bg_line_c);
            am.l(this.cTX, R.color.cp_bg_line_c);
            am.f(this.cTV, R.color.cp_cont_f, 1);
            am.f(this.cTW, R.color.cp_cont_d, 1);
            this.mSkinType = skinType;
        }
    }

    private View getView() {
        if (this.mContext == null) {
            return null;
        }
        if (this.mContentView == null) {
            this.mContentView = (ViewGroup) LayoutInflater.from(this.mContext).inflate(R.layout.neg_dt_head_popupwindow, (ViewGroup) null);
            this.cTV = (TextView) this.mContentView.findViewById(R.id.head_text);
            this.cTW = (TextView) this.mContentView.findViewById(R.id.sub_head_text);
        }
        View rootView = this.cTH.getRootView();
        if (rootView != null && rootView.getParent() == null) {
            int g = l.g(this.mContext, R.dimen.ds40);
            rootView.setPadding(g, 0, g, 0);
            this.mContentView.addView(rootView);
        }
        if (this.cTQ == null) {
            this.cTQ = (LinearLayout) LayoutInflater.from(this.mContext).inflate(R.layout.neg_dt_bottom_popupwindow, (ViewGroup) null);
            this.cTU = (TextView) this.cTQ.findViewById(R.id.dialog_bottom_cancel_button);
            this.cTT = (TextView) this.cTQ.findViewById(R.id.dialog_bottom_certain_button);
            this.mTopLine = this.cTQ.findViewById(R.id.top_line);
            this.cTX = this.cTQ.findViewById(R.id.middle_line);
            this.mContentView.addView(this.cTQ);
            this.cTU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.NEGFeedBack.e.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (e.this.cTE != null) {
                        e.this.cTE.dismiss();
                        e.this.cTE = null;
                    }
                    if (e.this.aPS != null) {
                        e.this.aPS.dismiss();
                        e.this.aPS = null;
                    }
                    if (e.this.cTR != null) {
                        e.this.cTR.onClick();
                    }
                }
            });
            if (this.cTT != null) {
                this.cTT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.NEGFeedBack.e.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        JSONObject aBJ = e.this.aBJ();
                        if (e.this.mFrom == "3" || e.this.mFrom == "4" || e.this.mFrom == "1") {
                            e.this.aBD();
                        } else if (aBJ != null) {
                            e.this.showLoadingView();
                            CustomMessage customMessage = new CustomMessage(2016489, e.this.mPageContext.getUniqueId());
                            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2016489, aBJ);
                            customResponsedMessage.setOrginalMessage(customMessage);
                            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                        }
                    }
                });
            }
            akZ();
        }
        return this.mContentView;
    }

    public void a(b bVar) {
        this.cTS = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLoadingView() {
        if (this.cDr == null) {
            this.cDr = new com.baidu.tbadk.core.view.b(this.mPageContext);
        }
        this.cDr.iC(R.string.loading);
        this.cDr.em(true);
    }

    public void aBI() {
        if (this.cDr != null) {
            this.cDr.em(false);
        }
    }

    public void rU(String str) {
        if (this.mContext != null) {
            this.mFrom = str;
            View view = getView();
            if (view != null && view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            akZ();
            this.mWindowHeight = getWindowMeasuredHeight() - l.g(this.mContext, R.dimen.ds12);
            this.aPS = new PopupWindow(view, this.cTz, this.mWindowHeight);
            this.aPS.setFocusable(true);
            this.aPS.setTouchable(true);
            this.aPS.setOnDismissListener(this.cTL);
            aBH();
            this.cTE = new PopupWindow(LayoutInflater.from(this.mContext).inflate(R.layout.view_negative_feedback_bottom, (ViewGroup) null), -1, -1);
            if (Build.VERSION.SDK_INT >= 22) {
                this.cTE.setAttachedInDecor(false);
            }
            this.cTE.showAtLocation(this.mAnchor, 0, 0, 0);
            am.a(this.aPS, (int) R.drawable.bg_dailog);
            this.aPS.showAtLocation(this.mAnchor, 17, 0, 0);
            if (this.cTD != null) {
                this.cTD.b(this.cTx);
            }
            this.cTI = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject aBJ() {
        int i;
        JSONObject jSONObject = new JSONObject();
        if (this.cTx == null) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        if (v.aa(this.cTy)) {
            i = 0;
        } else {
            i = 0;
            for (int i2 = 0; i2 < this.cTy.size(); i2++) {
                b.a aVar = this.cTy.get(i2);
                if (aVar != null) {
                    jSONArray.put(String.valueOf(aVar.id));
                    i = aVar.index + 1;
                }
            }
        }
        TiebaStatic.log(new an("c13123").bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.mFrom).P("obj_type", i));
        if (this.cTS != null) {
            this.cTS.C(jSONArray);
        }
        try {
            jSONObject.put("reason", jSONArray);
            jSONObject.put("thread_ids", this.cTx.adn());
            jSONObject.put("type", this.cTx.adm());
            jSONObject.put("forum_id", this.cTx.getFid());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
