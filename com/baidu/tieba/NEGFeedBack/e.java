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
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.al;
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
/* loaded from: classes8.dex */
public class e {
    private TextView baJ;
    private int euU;
    private PopupWindow euY;
    private com.baidu.tieba.NEGFeedBack.b evb;
    private boolean evc;
    private LinearLayout evm;
    private a evn;
    private b evo;
    private TextView evp;
    private TextView evq;
    private TextView evr;
    private View evs;
    private View mAnchor;
    private ViewGroup mContentView;
    private Context mContext;
    private String mFrom;
    private TbPageContext mPageContext;
    private View mTopLine;
    private int mWindowHeight;
    private int mWindowWidth;
    private int mXOffset;
    private PopupWindow mPopupWindow = null;
    private al euS = null;
    private SparseArray<String> euG = null;
    private List<b.a> euT = new ArrayList();
    private NEGFeedBackView.a euX = null;
    private int mSkinType = 3;
    private com.baidu.tbadk.core.view.a egi = null;
    private CompoundButton.OnCheckedChangeListener euJ = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.NEGFeedBack.e.1
        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (e.this.euX != null) {
                e.this.euX.a(e.this.euS, compoundButton, z);
            }
            if (compoundButton.getTag() instanceof b.a) {
                b.a aVar = (b.a) compoundButton.getTag();
                if (z) {
                    if (!e.this.euT.contains(aVar)) {
                        e.this.euT.add(aVar);
                        return;
                    }
                    return;
                }
                e.this.euT.remove(aVar);
            }
        }
    };
    private PopupWindow.OnDismissListener evh = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.NEGFeedBack.e.2
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (e.this.euY != null) {
                e.this.euY.dismiss();
                e.this.euY = null;
            }
        }
    };

    /* loaded from: classes8.dex */
    public interface a {
        void onClick();
    }

    /* loaded from: classes8.dex */
    public interface b {
        void T(JSONArray jSONArray);
    }

    public e(TbPageContext tbPageContext, View view) {
        this.mContext = null;
        this.mContext = tbPageContext.getPageActivity();
        this.mPageContext = tbPageContext;
        this.mAnchor = view;
        init();
    }

    private void init() {
        this.mXOffset = l.getDimens(this.mContext, R.dimen.tbds32);
        this.mWindowWidth = l.getEquipmentWidth(this.mContext) - (this.mXOffset * 2);
        this.evb = new com.baidu.tieba.NEGFeedBack.b(this.mPageContext);
        this.evb.a(this.euJ);
        this.evb.iv(true);
    }

    private int getWindowMeasuredHeight() {
        if (this.mContentView == null) {
            return 0;
        }
        this.mContentView.measure(0, 0);
        this.euU = this.mContentView.getMeasuredHeight() + l.getDimens(this.mContext, R.dimen.ds12);
        return this.euU;
    }

    public void setData(al alVar) {
        if (alVar != null) {
            this.euS = alVar;
            this.euG = alVar.getFeedBackReasonMap();
            if (this.euG != null && this.euG.size() > 8) {
                for (int size = this.euG.size() - 1; size >= 8; size--) {
                    this.euG.removeAt(size);
                }
            }
            this.evb.setData(alVar);
        }
    }

    public void setDefaultReasonArray(String[] strArr) {
        this.evb.setDefaultReasonArray(strArr);
    }

    public void beB() {
        if (this.mPopupWindow != null) {
            this.mPopupWindow.dismiss();
            this.mPopupWindow = null;
        }
        if (this.euY != null) {
            this.euY.dismiss();
            this.euY = null;
        }
    }

    private void resetState() {
        if (this.evc && this.euT.size() != 0) {
            this.euT.clear();
        }
    }

    private void aQm() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            am.setViewTextColor(this.baJ, R.color.cp_cont_f, 1);
            am.setViewTextColor(this.evp, R.color.cp_cont_f, 1);
            am.setBackgroundColor(this.mTopLine, R.color.cp_bg_line_c);
            am.setBackgroundColor(this.evs, R.color.cp_bg_line_c);
            am.setViewTextColor(this.evq, R.color.cp_cont_f, 1);
            am.setViewTextColor(this.evr, R.color.cp_cont_d, 1);
            this.mSkinType = skinType;
        }
    }

    private View getView() {
        if (this.mContext == null) {
            return null;
        }
        if (this.mContentView == null) {
            this.mContentView = (ViewGroup) LayoutInflater.from(this.mContext).inflate(R.layout.neg_dt_head_popupwindow, (ViewGroup) null);
            this.evq = (TextView) this.mContentView.findViewById(R.id.head_text);
            this.evr = (TextView) this.mContentView.findViewById(R.id.sub_head_text);
        }
        View rootView = this.evb.getRootView();
        if (rootView != null && rootView.getParent() == null) {
            int dimens = l.getDimens(this.mContext, R.dimen.ds40);
            rootView.setPadding(dimens, 0, dimens, 0);
            this.mContentView.addView(rootView);
        }
        if (this.evm == null) {
            this.evm = (LinearLayout) LayoutInflater.from(this.mContext).inflate(R.layout.neg_dt_bottom_popupwindow, (ViewGroup) null);
            this.baJ = (TextView) this.evm.findViewById(R.id.dialog_bottom_cancel_button);
            this.evp = (TextView) this.evm.findViewById(R.id.dialog_bottom_certain_button);
            this.mTopLine = this.evm.findViewById(R.id.top_line);
            this.evs = this.evm.findViewById(R.id.middle_line);
            this.mContentView.addView(this.evm);
            this.baJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.NEGFeedBack.e.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (e.this.euY != null) {
                        e.this.euY.dismiss();
                        e.this.euY = null;
                    }
                    if (e.this.mPopupWindow != null) {
                        e.this.mPopupWindow.dismiss();
                        e.this.mPopupWindow = null;
                    }
                    if (e.this.evn != null) {
                        e.this.evn.onClick();
                    }
                }
            });
            if (this.evp != null) {
                this.evp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.NEGFeedBack.e.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        JSONObject beF = e.this.beF();
                        if (e.this.mFrom == "3" || e.this.mFrom == "4" || e.this.mFrom == "1") {
                            e.this.beB();
                        } else if (beF != null) {
                            e.this.showLoadingView();
                            CustomMessage customMessage = new CustomMessage(2016489, e.this.mPageContext.getUniqueId());
                            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2016489, beF);
                            customResponsedMessage.setOrginalMessage(customMessage);
                            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                        }
                    }
                });
            }
            aQm();
        }
        return this.mContentView;
    }

    public void a(b bVar) {
        this.evo = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLoadingView() {
        if (this.egi == null) {
            this.egi = new com.baidu.tbadk.core.view.a(this.mPageContext);
        }
        this.egi.setTipString(R.string.loading);
        this.egi.setDialogVisiable(true);
    }

    public void beE() {
        if (this.egi != null) {
            this.egi.setDialogVisiable(false);
        }
    }

    public void xD(String str) {
        if (this.mContext != null) {
            this.mFrom = str;
            View view = getView();
            if (view != null && view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            aQm();
            this.mWindowHeight = getWindowMeasuredHeight() - l.getDimens(this.mContext, R.dimen.ds12);
            this.mPopupWindow = new PopupWindow(view, this.mWindowWidth, this.mWindowHeight);
            this.mPopupWindow.setFocusable(true);
            this.mPopupWindow.setTouchable(true);
            this.mPopupWindow.setOnDismissListener(this.evh);
            resetState();
            this.euY = new PopupWindow(LayoutInflater.from(this.mContext).inflate(R.layout.view_negative_feedback_bottom, (ViewGroup) null), -1, -1);
            if (Build.VERSION.SDK_INT >= 22) {
                this.euY.setAttachedInDecor(false);
            }
            this.euY.showAtLocation(this.mAnchor, 0, 0, 0);
            am.setBackgroundDrawable(this.mPopupWindow, R.drawable.bg_dailog);
            this.mPopupWindow.showAtLocation(this.mAnchor, 17, 0, 0);
            if (this.euX != null) {
                this.euX.b(this.euS);
            }
            this.evc = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject beF() {
        int i;
        JSONObject jSONObject = new JSONObject();
        if (this.euS == null) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        if (v.isEmpty(this.euT)) {
            i = 0;
        } else {
            i = 0;
            for (int i2 = 0; i2 < this.euT.size(); i2++) {
                b.a aVar = this.euT.get(i2);
                if (aVar != null) {
                    jSONArray.put(String.valueOf(aVar.id));
                    i = aVar.index + 1;
                }
            }
        }
        TiebaStatic.log(new an("c13123").cI("obj_source", this.mFrom).af("obj_type", i));
        if (this.evo != null) {
            this.evo.T(jSONArray);
        }
        try {
            jSONObject.put(TiebaInitialize.LogFields.REASON, jSONArray);
            jSONObject.put("thread_ids", this.euS.aJh());
            jSONObject.put("type", this.euS.aJg());
            jSONObject.put("forum_id", this.euS.getFid());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
