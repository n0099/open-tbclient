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
    private View cRA;
    private int cRc;
    private int cRd;
    private PopupWindow cRh;
    private com.baidu.tieba.NEGFeedBack.b cRk;
    private boolean cRl;
    private LinearLayout cRt;
    private a cRu;
    private b cRv;
    private TextView cRw;
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
    private aj cRa = null;
    private SparseArray<String> cQM = null;
    private List<b.a> cRb = new ArrayList();
    private NEGFeedBackView.a cRg = null;
    private int mSkinType = 3;
    private com.baidu.tbadk.core.view.b cAW = null;
    private CompoundButton.OnCheckedChangeListener cQP = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.NEGFeedBack.e.1
        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (e.this.cRg != null) {
                e.this.cRg.a(e.this.cRa, compoundButton, z);
            }
            if (compoundButton.getTag() instanceof b.a) {
                b.a aVar = (b.a) compoundButton.getTag();
                if (z) {
                    if (!e.this.cRb.contains(aVar)) {
                        e.this.cRb.add(aVar);
                        return;
                    }
                    return;
                }
                e.this.cRb.remove(aVar);
            }
        }
    };
    private PopupWindow.OnDismissListener cRo = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.NEGFeedBack.e.2
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (e.this.cRh != null) {
                e.this.cRh.dismiss();
                e.this.cRh = null;
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
        this.cRc = l.af(this.mContext) - (this.mXOffset * 2);
        this.cRk = new com.baidu.tieba.NEGFeedBack.b(this.mPageContext);
        this.cRk.a(this.cQP);
        this.cRk.ga(true);
    }

    private int getWindowMeasuredHeight() {
        if (this.mContentView == null) {
            return 0;
        }
        this.mContentView.measure(0, 0);
        this.cRd = this.mContentView.getMeasuredHeight() + l.g(this.mContext, R.dimen.ds12);
        return this.cRd;
    }

    public void setData(aj ajVar) {
        if (ajVar != null) {
            this.cRa = ajVar;
            this.cQM = ajVar.ace();
            if (this.cQM != null && this.cQM.size() > 8) {
                for (int size = this.cQM.size() - 1; size >= 8; size--) {
                    this.cQM.removeAt(size);
                }
            }
            this.cRk.setData(ajVar);
        }
    }

    public void setDefaultReasonArray(String[] strArr) {
        this.cRk.setDefaultReasonArray(strArr);
    }

    public void azZ() {
        if (this.aOK != null) {
            this.aOK.dismiss();
            this.aOK = null;
        }
        if (this.cRh != null) {
            this.cRh.dismiss();
            this.cRh = null;
        }
    }

    private void aAd() {
        if (this.cRl && this.cRb.size() != 0) {
            this.cRb.clear();
        }
    }

    private void ajG() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            al.f(this.cRx, R.color.cp_cont_f, 1);
            al.f(this.cRw, R.color.cp_cont_f, 1);
            al.l(this.mTopLine, R.color.cp_bg_line_b);
            al.l(this.cRA, R.color.cp_bg_line_b);
            al.f(this.cRy, R.color.cp_cont_f, 1);
            al.f(this.cRz, R.color.cp_cont_d, 1);
            this.mSkinType = skinType;
        }
    }

    private View getView() {
        if (this.mContext == null) {
            return null;
        }
        if (this.mContentView == null) {
            this.mContentView = (ViewGroup) LayoutInflater.from(this.mContext).inflate(R.layout.neg_dt_head_popupwindow, (ViewGroup) null);
            this.cRy = (TextView) this.mContentView.findViewById(R.id.head_text);
            this.cRz = (TextView) this.mContentView.findViewById(R.id.sub_head_text);
        }
        View rootView = this.cRk.getRootView();
        if (rootView != null && rootView.getParent() == null) {
            int g = l.g(this.mContext, R.dimen.ds40);
            rootView.setPadding(g, 0, g, 0);
            this.mContentView.addView(rootView);
        }
        if (this.cRt == null) {
            this.cRt = (LinearLayout) LayoutInflater.from(this.mContext).inflate(R.layout.neg_dt_bottom_popupwindow, (ViewGroup) null);
            this.cRx = (TextView) this.cRt.findViewById(R.id.dialog_bottom_cancel_button);
            this.cRw = (TextView) this.cRt.findViewById(R.id.dialog_bottom_certain_button);
            this.mTopLine = this.cRt.findViewById(R.id.top_line);
            this.cRA = this.cRt.findViewById(R.id.middle_line);
            this.mContentView.addView(this.cRt);
            this.cRx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.NEGFeedBack.e.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (e.this.cRh != null) {
                        e.this.cRh.dismiss();
                        e.this.cRh = null;
                    }
                    if (e.this.aOK != null) {
                        e.this.aOK.dismiss();
                        e.this.aOK = null;
                    }
                    if (e.this.cRu != null) {
                        e.this.cRu.onClick();
                    }
                }
            });
            if (this.cRw != null) {
                this.cRw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.NEGFeedBack.e.4
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
        this.cRv = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLoadingView() {
        if (this.cAW == null) {
            this.cAW = new com.baidu.tbadk.core.view.b(this.mPageContext);
        }
        this.cAW.it(R.string.loading);
        this.cAW.ef(true);
    }

    public void aAe() {
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
            this.aOK = new PopupWindow(view, this.cRc, this.mWindowHeight);
            this.aOK.setFocusable(true);
            this.aOK.setTouchable(true);
            this.aOK.setOnDismissListener(this.cRo);
            aAd();
            this.cRh = new PopupWindow(LayoutInflater.from(this.mContext).inflate(R.layout.view_negative_feedback_bottom, (ViewGroup) null), -1, -1);
            if (Build.VERSION.SDK_INT >= 22) {
                this.cRh.setAttachedInDecor(false);
            }
            this.cRh.showAtLocation(this.mAnchor, 0, 0, 0);
            al.a(this.aOK, (int) R.drawable.bg_dailog);
            this.aOK.showAtLocation(this.mAnchor, 17, 0, 0);
            if (this.cRg != null) {
                this.cRg.b(this.cRa);
            }
            this.cRl = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject aAf() {
        int i;
        JSONObject jSONObject = new JSONObject();
        if (this.cRa == null) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        if (v.aa(this.cRb)) {
            i = 0;
        } else {
            i = 0;
            for (int i2 = 0; i2 < this.cRb.size(); i2++) {
                b.a aVar = this.cRb.get(i2);
                if (aVar != null) {
                    jSONArray.put(String.valueOf(aVar.id));
                    i = aVar.index + 1;
                }
            }
        }
        TiebaStatic.log(new am("c13123").bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.mFrom).P("obj_type", i));
        if (this.cRv != null) {
            this.cRv.C(jSONArray);
        }
        try {
            jSONObject.put("reason", jSONArray);
            jSONObject.put("thread_ids", this.cRa.acg());
            jSONObject.put("type", this.cRa.acf());
            jSONObject.put("forum_id", this.cRa.getFid());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
