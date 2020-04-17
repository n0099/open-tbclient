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
    private TextView baE;
    private int euP;
    private PopupWindow euT;
    private com.baidu.tieba.NEGFeedBack.b euW;
    private boolean euX;
    private LinearLayout evh;
    private a evi;
    private b evj;
    private TextView evk;
    private TextView evl;
    private TextView evm;
    private View evn;
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
    private al euN = null;
    private SparseArray<String> euB = null;
    private List<b.a> euO = new ArrayList();
    private NEGFeedBackView.a euS = null;
    private int mSkinType = 3;
    private com.baidu.tbadk.core.view.a egd = null;
    private CompoundButton.OnCheckedChangeListener euE = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.NEGFeedBack.e.1
        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (e.this.euS != null) {
                e.this.euS.a(e.this.euN, compoundButton, z);
            }
            if (compoundButton.getTag() instanceof b.a) {
                b.a aVar = (b.a) compoundButton.getTag();
                if (z) {
                    if (!e.this.euO.contains(aVar)) {
                        e.this.euO.add(aVar);
                        return;
                    }
                    return;
                }
                e.this.euO.remove(aVar);
            }
        }
    };
    private PopupWindow.OnDismissListener evc = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.NEGFeedBack.e.2
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (e.this.euT != null) {
                e.this.euT.dismiss();
                e.this.euT = null;
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
        this.euW = new com.baidu.tieba.NEGFeedBack.b(this.mPageContext);
        this.euW.a(this.euE);
        this.euW.iv(true);
    }

    private int getWindowMeasuredHeight() {
        if (this.mContentView == null) {
            return 0;
        }
        this.mContentView.measure(0, 0);
        this.euP = this.mContentView.getMeasuredHeight() + l.getDimens(this.mContext, R.dimen.ds12);
        return this.euP;
    }

    public void setData(al alVar) {
        if (alVar != null) {
            this.euN = alVar;
            this.euB = alVar.getFeedBackReasonMap();
            if (this.euB != null && this.euB.size() > 8) {
                for (int size = this.euB.size() - 1; size >= 8; size--) {
                    this.euB.removeAt(size);
                }
            }
            this.euW.setData(alVar);
        }
    }

    public void setDefaultReasonArray(String[] strArr) {
        this.euW.setDefaultReasonArray(strArr);
    }

    public void beD() {
        if (this.mPopupWindow != null) {
            this.mPopupWindow.dismiss();
            this.mPopupWindow = null;
        }
        if (this.euT != null) {
            this.euT.dismiss();
            this.euT = null;
        }
    }

    private void resetState() {
        if (this.euX && this.euO.size() != 0) {
            this.euO.clear();
        }
    }

    private void aQp() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            am.setViewTextColor(this.baE, R.color.cp_cont_f, 1);
            am.setViewTextColor(this.evk, R.color.cp_cont_f, 1);
            am.setBackgroundColor(this.mTopLine, R.color.cp_bg_line_c);
            am.setBackgroundColor(this.evn, R.color.cp_bg_line_c);
            am.setViewTextColor(this.evl, R.color.cp_cont_f, 1);
            am.setViewTextColor(this.evm, R.color.cp_cont_d, 1);
            this.mSkinType = skinType;
        }
    }

    private View getView() {
        if (this.mContext == null) {
            return null;
        }
        if (this.mContentView == null) {
            this.mContentView = (ViewGroup) LayoutInflater.from(this.mContext).inflate(R.layout.neg_dt_head_popupwindow, (ViewGroup) null);
            this.evl = (TextView) this.mContentView.findViewById(R.id.head_text);
            this.evm = (TextView) this.mContentView.findViewById(R.id.sub_head_text);
        }
        View rootView = this.euW.getRootView();
        if (rootView != null && rootView.getParent() == null) {
            int dimens = l.getDimens(this.mContext, R.dimen.ds40);
            rootView.setPadding(dimens, 0, dimens, 0);
            this.mContentView.addView(rootView);
        }
        if (this.evh == null) {
            this.evh = (LinearLayout) LayoutInflater.from(this.mContext).inflate(R.layout.neg_dt_bottom_popupwindow, (ViewGroup) null);
            this.baE = (TextView) this.evh.findViewById(R.id.dialog_bottom_cancel_button);
            this.evk = (TextView) this.evh.findViewById(R.id.dialog_bottom_certain_button);
            this.mTopLine = this.evh.findViewById(R.id.top_line);
            this.evn = this.evh.findViewById(R.id.middle_line);
            this.mContentView.addView(this.evh);
            this.baE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.NEGFeedBack.e.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (e.this.euT != null) {
                        e.this.euT.dismiss();
                        e.this.euT = null;
                    }
                    if (e.this.mPopupWindow != null) {
                        e.this.mPopupWindow.dismiss();
                        e.this.mPopupWindow = null;
                    }
                    if (e.this.evi != null) {
                        e.this.evi.onClick();
                    }
                }
            });
            if (this.evk != null) {
                this.evk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.NEGFeedBack.e.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        JSONObject beH = e.this.beH();
                        if (e.this.mFrom == "3" || e.this.mFrom == "4" || e.this.mFrom == "1") {
                            e.this.beD();
                        } else if (beH != null) {
                            e.this.showLoadingView();
                            CustomMessage customMessage = new CustomMessage(2016489, e.this.mPageContext.getUniqueId());
                            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2016489, beH);
                            customResponsedMessage.setOrginalMessage(customMessage);
                            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                        }
                    }
                });
            }
            aQp();
        }
        return this.mContentView;
    }

    public void a(b bVar) {
        this.evj = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLoadingView() {
        if (this.egd == null) {
            this.egd = new com.baidu.tbadk.core.view.a(this.mPageContext);
        }
        this.egd.setTipString(R.string.loading);
        this.egd.setDialogVisiable(true);
    }

    public void beG() {
        if (this.egd != null) {
            this.egd.setDialogVisiable(false);
        }
    }

    public void xA(String str) {
        if (this.mContext != null) {
            this.mFrom = str;
            View view = getView();
            if (view != null && view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            aQp();
            this.mWindowHeight = getWindowMeasuredHeight() - l.getDimens(this.mContext, R.dimen.ds12);
            this.mPopupWindow = new PopupWindow(view, this.mWindowWidth, this.mWindowHeight);
            this.mPopupWindow.setFocusable(true);
            this.mPopupWindow.setTouchable(true);
            this.mPopupWindow.setOnDismissListener(this.evc);
            resetState();
            this.euT = new PopupWindow(LayoutInflater.from(this.mContext).inflate(R.layout.view_negative_feedback_bottom, (ViewGroup) null), -1, -1);
            if (Build.VERSION.SDK_INT >= 22) {
                this.euT.setAttachedInDecor(false);
            }
            this.euT.showAtLocation(this.mAnchor, 0, 0, 0);
            am.setBackgroundDrawable(this.mPopupWindow, R.drawable.bg_dailog);
            this.mPopupWindow.showAtLocation(this.mAnchor, 17, 0, 0);
            if (this.euS != null) {
                this.euS.b(this.euN);
            }
            this.euX = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject beH() {
        int i;
        JSONObject jSONObject = new JSONObject();
        if (this.euN == null) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        if (v.isEmpty(this.euO)) {
            i = 0;
        } else {
            i = 0;
            for (int i2 = 0; i2 < this.euO.size(); i2++) {
                b.a aVar = this.euO.get(i2);
                if (aVar != null) {
                    jSONArray.put(String.valueOf(aVar.id));
                    i = aVar.index + 1;
                }
            }
        }
        TiebaStatic.log(new an("c13123").cI("obj_source", this.mFrom).af("obj_type", i));
        if (this.evj != null) {
            this.evj.T(jSONArray);
        }
        try {
            jSONObject.put(TiebaInitialize.LogFields.REASON, jSONArray);
            jSONObject.put("thread_ids", this.euN.aJj());
            jSONObject.put("type", this.euN.aJi());
            jSONObject.put("forum_id", this.euN.getFid());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
