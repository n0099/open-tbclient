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
    private int cRb;
    private int cRc;
    private PopupWindow cRg;
    private com.baidu.tieba.NEGFeedBack.b cRj;
    private boolean cRk;
    private LinearLayout cRs;
    private a cRt;
    private b cRu;
    private TextView cRv;
    private TextView cRw;
    private TextView cRx;
    private TextView cRy;
    private View cRz;
    private View mAnchor;
    private ViewGroup mContentView;
    private Context mContext;
    private String mFrom;
    private TbPageContext mPageContext;
    private View mTopLine;
    private int mWindowHeight;
    private int mXOffset;
    private PopupWindow aOK = null;
    private aj cQZ = null;
    private SparseArray<String> cQL = null;
    private List<b.a> cRa = new ArrayList();
    private NEGFeedBackView.a cRf = null;
    private int mSkinType = 3;
    private com.baidu.tbadk.core.view.b cAW = null;
    private CompoundButton.OnCheckedChangeListener cQO = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.NEGFeedBack.e.1
        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (e.this.cRf != null) {
                e.this.cRf.a(e.this.cQZ, compoundButton, z);
            }
            if (compoundButton.getTag() instanceof b.a) {
                b.a aVar = (b.a) compoundButton.getTag();
                if (z) {
                    if (!e.this.cRa.contains(aVar)) {
                        e.this.cRa.add(aVar);
                        return;
                    }
                    return;
                }
                e.this.cRa.remove(aVar);
            }
        }
    };
    private PopupWindow.OnDismissListener cRn = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.NEGFeedBack.e.2
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (e.this.cRg != null) {
                e.this.cRg.dismiss();
                e.this.cRg = null;
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
        this.cRb = l.af(this.mContext) - (this.mXOffset * 2);
        this.cRj = new com.baidu.tieba.NEGFeedBack.b(this.mPageContext);
        this.cRj.a(this.cQO);
        this.cRj.ga(true);
    }

    private int getWindowMeasuredHeight() {
        if (this.mContentView == null) {
            return 0;
        }
        this.mContentView.measure(0, 0);
        this.cRc = this.mContentView.getMeasuredHeight() + l.g(this.mContext, R.dimen.ds12);
        return this.cRc;
    }

    public void setData(aj ajVar) {
        if (ajVar != null) {
            this.cQZ = ajVar;
            this.cQL = ajVar.ace();
            if (this.cQL != null && this.cQL.size() > 8) {
                for (int size = this.cQL.size() - 1; size >= 8; size--) {
                    this.cQL.removeAt(size);
                }
            }
            this.cRj.setData(ajVar);
        }
    }

    public void setDefaultReasonArray(String[] strArr) {
        this.cRj.setDefaultReasonArray(strArr);
    }

    public void azW() {
        if (this.aOK != null) {
            this.aOK.dismiss();
            this.aOK = null;
        }
        if (this.cRg != null) {
            this.cRg.dismiss();
            this.cRg = null;
        }
    }

    private void aAa() {
        if (this.cRk && this.cRa.size() != 0) {
            this.cRa.clear();
        }
    }

    private void ajG() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            al.f(this.cRw, R.color.cp_cont_f, 1);
            al.f(this.cRv, R.color.cp_cont_f, 1);
            al.l(this.mTopLine, R.color.cp_bg_line_b);
            al.l(this.cRz, R.color.cp_bg_line_b);
            al.f(this.cRx, R.color.cp_cont_f, 1);
            al.f(this.cRy, R.color.cp_cont_d, 1);
            this.mSkinType = skinType;
        }
    }

    private View getView() {
        if (this.mContext == null) {
            return null;
        }
        if (this.mContentView == null) {
            this.mContentView = (ViewGroup) LayoutInflater.from(this.mContext).inflate(R.layout.neg_dt_head_popupwindow, (ViewGroup) null);
            this.cRx = (TextView) this.mContentView.findViewById(R.id.head_text);
            this.cRy = (TextView) this.mContentView.findViewById(R.id.sub_head_text);
        }
        View rootView = this.cRj.getRootView();
        if (rootView != null && rootView.getParent() == null) {
            int g = l.g(this.mContext, R.dimen.ds40);
            rootView.setPadding(g, 0, g, 0);
            this.mContentView.addView(rootView);
        }
        if (this.cRs == null) {
            this.cRs = (LinearLayout) LayoutInflater.from(this.mContext).inflate(R.layout.neg_dt_bottom_popupwindow, (ViewGroup) null);
            this.cRw = (TextView) this.cRs.findViewById(R.id.dialog_bottom_cancel_button);
            this.cRv = (TextView) this.cRs.findViewById(R.id.dialog_bottom_certain_button);
            this.mTopLine = this.cRs.findViewById(R.id.top_line);
            this.cRz = this.cRs.findViewById(R.id.middle_line);
            this.mContentView.addView(this.cRs);
            this.cRw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.NEGFeedBack.e.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (e.this.cRg != null) {
                        e.this.cRg.dismiss();
                        e.this.cRg = null;
                    }
                    if (e.this.aOK != null) {
                        e.this.aOK.dismiss();
                        e.this.aOK = null;
                    }
                    if (e.this.cRt != null) {
                        e.this.cRt.onClick();
                    }
                }
            });
            if (this.cRv != null) {
                this.cRv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.NEGFeedBack.e.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        JSONObject aAc = e.this.aAc();
                        if (e.this.mFrom == "3" || e.this.mFrom == "4" || e.this.mFrom == "1") {
                            e.this.azW();
                        } else if (aAc != null) {
                            e.this.showLoadingView();
                            CustomMessage customMessage = new CustomMessage(2016489, e.this.mPageContext.getUniqueId());
                            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2016489, aAc);
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
        this.cRu = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLoadingView() {
        if (this.cAW == null) {
            this.cAW = new com.baidu.tbadk.core.view.b(this.mPageContext);
        }
        this.cAW.it(R.string.loading);
        this.cAW.ef(true);
    }

    public void aAb() {
        if (this.cAW != null) {
            this.cAW.ef(false);
        }
    }

    public void rs(String str) {
        if (this.mContext != null) {
            this.mFrom = str;
            View view = getView();
            if (view != null && view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            ajG();
            this.mWindowHeight = getWindowMeasuredHeight() - l.g(this.mContext, R.dimen.ds12);
            this.aOK = new PopupWindow(view, this.cRb, this.mWindowHeight);
            this.aOK.setFocusable(true);
            this.aOK.setTouchable(true);
            this.aOK.setOnDismissListener(this.cRn);
            aAa();
            this.cRg = new PopupWindow(LayoutInflater.from(this.mContext).inflate(R.layout.view_negative_feedback_bottom, (ViewGroup) null), -1, -1);
            if (Build.VERSION.SDK_INT >= 22) {
                this.cRg.setAttachedInDecor(false);
            }
            this.cRg.showAtLocation(this.mAnchor, 0, 0, 0);
            al.a(this.aOK, (int) R.drawable.bg_dailog);
            this.aOK.showAtLocation(this.mAnchor, 17, 0, 0);
            if (this.cRf != null) {
                this.cRf.b(this.cQZ);
            }
            this.cRk = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject aAc() {
        int i;
        JSONObject jSONObject = new JSONObject();
        if (this.cQZ == null) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        if (v.aa(this.cRa)) {
            i = 0;
        } else {
            i = 0;
            for (int i2 = 0; i2 < this.cRa.size(); i2++) {
                b.a aVar = this.cRa.get(i2);
                if (aVar != null) {
                    jSONArray.put(String.valueOf(aVar.id));
                    i = aVar.index + 1;
                }
            }
        }
        TiebaStatic.log(new am("c13123").bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.mFrom).P("obj_type", i));
        if (this.cRu != null) {
            this.cRu.C(jSONArray);
        }
        try {
            jSONObject.put("reason", jSONArray);
            jSONObject.put("thread_ids", this.cQZ.acg());
            jSONObject.put("type", this.cQZ.acf());
            jSONObject.put("forum_id", this.cQZ.getFid());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
