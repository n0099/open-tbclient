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
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class e {
    private TextView cRA;
    private View cRB;
    private int cRd;
    private int cRe;
    private PopupWindow cRi;
    private com.baidu.tieba.NEGFeedBack.b cRl;
    private boolean cRm;
    private LinearLayout cRu;
    private a cRv;
    private b cRw;
    private TextView cRx;
    private TextView cRy;
    private TextView cRz;
    private View mAnchor;
    private ViewGroup mContentView;
    private Context mContext;
    private String mFrom;
    private TbPageContext mPageContext;
    private View mTopLine;
    private int mWindowHeight;
    private int mXOffset;
    private PopupWindow aOK = null;
    private aj cRb = null;
    private SparseArray<String> cQN = null;
    private List<b.a> cRc = new ArrayList();
    private NEGFeedBackView.a cRh = null;
    private int mSkinType = 3;
    private com.baidu.tbadk.core.view.b cAX = null;
    private CompoundButton.OnCheckedChangeListener cQQ = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.NEGFeedBack.e.1
        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (e.this.cRh != null) {
                e.this.cRh.a(e.this.cRb, compoundButton, z);
            }
            if (compoundButton.getTag() instanceof b.a) {
                b.a aVar = (b.a) compoundButton.getTag();
                if (z) {
                    if (!e.this.cRc.contains(aVar)) {
                        e.this.cRc.add(aVar);
                        return;
                    }
                    return;
                }
                e.this.cRc.remove(aVar);
            }
        }
    };
    private PopupWindow.OnDismissListener cRp = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.NEGFeedBack.e.2
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (e.this.cRi != null) {
                e.this.cRi.dismiss();
                e.this.cRi = null;
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
        this.cRd = l.af(this.mContext) - (this.mXOffset * 2);
        this.cRl = new com.baidu.tieba.NEGFeedBack.b(this.mPageContext);
        this.cRl.a(this.cQQ);
        this.cRl.ga(true);
    }

    private int getWindowMeasuredHeight() {
        if (this.mContentView == null) {
            return 0;
        }
        this.mContentView.measure(0, 0);
        this.cRe = this.mContentView.getMeasuredHeight() + l.g(this.mContext, R.dimen.ds12);
        return this.cRe;
    }

    public void setData(aj ajVar) {
        if (ajVar != null) {
            this.cRb = ajVar;
            this.cQN = ajVar.ace();
            if (this.cQN != null && this.cQN.size() > 8) {
                for (int size = this.cQN.size() - 1; size >= 8; size--) {
                    this.cQN.removeAt(size);
                }
            }
            this.cRl.setData(ajVar);
        }
    }

    public void setDefaultReasonArray(String[] strArr) {
        this.cRl.setDefaultReasonArray(strArr);
    }

    public void azZ() {
        if (this.aOK != null) {
            this.aOK.dismiss();
            this.aOK = null;
        }
        if (this.cRi != null) {
            this.cRi.dismiss();
            this.cRi = null;
        }
    }

    private void aAd() {
        if (this.cRm && this.cRc.size() != 0) {
            this.cRc.clear();
        }
    }

    private void ajG() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            al.f(this.cRy, R.color.cp_cont_f, 1);
            al.f(this.cRx, R.color.cp_cont_f, 1);
            al.l(this.mTopLine, R.color.cp_bg_line_b);
            al.l(this.cRB, R.color.cp_bg_line_b);
            al.f(this.cRz, R.color.cp_cont_f, 1);
            al.f(this.cRA, R.color.cp_cont_d, 1);
            this.mSkinType = skinType;
        }
    }

    private View getView() {
        if (this.mContext == null) {
            return null;
        }
        if (this.mContentView == null) {
            this.mContentView = (ViewGroup) LayoutInflater.from(this.mContext).inflate(R.layout.neg_dt_head_popupwindow, (ViewGroup) null);
            this.cRz = (TextView) this.mContentView.findViewById(R.id.head_text);
            this.cRA = (TextView) this.mContentView.findViewById(R.id.sub_head_text);
        }
        View rootView = this.cRl.getRootView();
        if (rootView != null && rootView.getParent() == null) {
            int g = l.g(this.mContext, R.dimen.ds40);
            rootView.setPadding(g, 0, g, 0);
            this.mContentView.addView(rootView);
        }
        if (this.cRu == null) {
            this.cRu = (LinearLayout) LayoutInflater.from(this.mContext).inflate(R.layout.neg_dt_bottom_popupwindow, (ViewGroup) null);
            this.cRy = (TextView) this.cRu.findViewById(R.id.dialog_bottom_cancel_button);
            this.cRx = (TextView) this.cRu.findViewById(R.id.dialog_bottom_certain_button);
            this.mTopLine = this.cRu.findViewById(R.id.top_line);
            this.cRB = this.cRu.findViewById(R.id.middle_line);
            this.mContentView.addView(this.cRu);
            this.cRy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.NEGFeedBack.e.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (e.this.cRi != null) {
                        e.this.cRi.dismiss();
                        e.this.cRi = null;
                    }
                    if (e.this.aOK != null) {
                        e.this.aOK.dismiss();
                        e.this.aOK = null;
                    }
                    if (e.this.cRv != null) {
                        e.this.cRv.onClick();
                    }
                }
            });
            if (this.cRx != null) {
                this.cRx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.NEGFeedBack.e.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        JSONObject aAf = e.this.aAf();
                        if (e.this.mFrom == "3" || e.this.mFrom == "4" || e.this.mFrom == "1") {
                            e.this.azZ();
                        } else if (aAf != null) {
                            e.this.showLoadingView();
                            CustomMessage customMessage = new CustomMessage(2016489, e.this.mPageContext.getUniqueId());
                            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2016489, aAf);
                            customResponsedMessage.setOrginalMessage(customMessage);
                            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                        }
                    }
                });
            }
            ajG();
        }
        return this.mContentView;
    }

    public void a(b bVar) {
        this.cRw = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLoadingView() {
        if (this.cAX == null) {
            this.cAX = new com.baidu.tbadk.core.view.b(this.mPageContext);
        }
        this.cAX.it(R.string.loading);
        this.cAX.ef(true);
    }

    public void aAe() {
        if (this.cAX != null) {
            this.cAX.ef(false);
        }
    }

    public void rr(String str) {
        if (this.mContext != null) {
            this.mFrom = str;
            View view = getView();
            if (view != null && view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            ajG();
            this.mWindowHeight = getWindowMeasuredHeight() - l.g(this.mContext, R.dimen.ds12);
            this.aOK = new PopupWindow(view, this.cRd, this.mWindowHeight);
            this.aOK.setFocusable(true);
            this.aOK.setTouchable(true);
            this.aOK.setOnDismissListener(this.cRp);
            aAd();
            this.cRi = new PopupWindow(LayoutInflater.from(this.mContext).inflate(R.layout.view_negative_feedback_bottom, (ViewGroup) null), -1, -1);
            if (Build.VERSION.SDK_INT >= 22) {
                this.cRi.setAttachedInDecor(false);
            }
            this.cRi.showAtLocation(this.mAnchor, 0, 0, 0);
            al.a(this.aOK, (int) R.drawable.bg_dailog);
            this.aOK.showAtLocation(this.mAnchor, 17, 0, 0);
            if (this.cRh != null) {
                this.cRh.b(this.cRb);
            }
            this.cRm = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject aAf() {
        int i;
        JSONObject jSONObject = new JSONObject();
        if (this.cRb == null) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        if (v.aa(this.cRc)) {
            i = 0;
        } else {
            i = 0;
            for (int i2 = 0; i2 < this.cRc.size(); i2++) {
                b.a aVar = this.cRc.get(i2);
                if (aVar != null) {
                    jSONArray.put(String.valueOf(aVar.id));
                    i = aVar.index + 1;
                }
            }
        }
        TiebaStatic.log(new am("c13123").bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.mFrom).P("obj_type", i));
        if (this.cRw != null) {
            this.cRw.C(jSONArray);
        }
        try {
            jSONObject.put("reason", jSONArray);
            jSONObject.put("thread_ids", this.cRb.acg());
            jSONObject.put("type", this.cRb.acf());
            jSONObject.put("forum_id", this.cRb.getFid());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
