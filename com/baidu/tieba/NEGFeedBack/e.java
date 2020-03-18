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
    private TextView aEX;
    private int dUP;
    private int dUQ;
    private PopupWindow dUU;
    private com.baidu.tieba.NEGFeedBack.b dUX;
    private boolean dUY;
    private LinearLayout dVi;
    private a dVj;
    private b dVk;
    private TextView dVl;
    private TextView dVm;
    private TextView dVn;
    private View dVo;
    private View mAnchor;
    private ViewGroup mContentView;
    private Context mContext;
    private String mFrom;
    private TbPageContext mPageContext;
    private View mTopLine;
    private int mWindowHeight;
    private int mXOffset;
    private PopupWindow mPopupWindow = null;
    private al dUN = null;
    private SparseArray<String> dUB = null;
    private List<b.a> dUO = new ArrayList();
    private NEGFeedBackView.a dUT = null;
    private int mSkinType = 3;
    private com.baidu.tbadk.core.view.a dGw = null;
    private CompoundButton.OnCheckedChangeListener dUE = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.NEGFeedBack.e.1
        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (e.this.dUT != null) {
                e.this.dUT.a(e.this.dUN, compoundButton, z);
            }
            if (compoundButton.getTag() instanceof b.a) {
                b.a aVar = (b.a) compoundButton.getTag();
                if (z) {
                    if (!e.this.dUO.contains(aVar)) {
                        e.this.dUO.add(aVar);
                        return;
                    }
                    return;
                }
                e.this.dUO.remove(aVar);
            }
        }
    };
    private PopupWindow.OnDismissListener dVd = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.NEGFeedBack.e.2
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (e.this.dUU != null) {
                e.this.dUU.dismiss();
                e.this.dUU = null;
            }
        }
    };

    /* loaded from: classes8.dex */
    public interface a {
        void onClick();
    }

    /* loaded from: classes8.dex */
    public interface b {
        void S(JSONArray jSONArray);
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
        this.dUP = l.getEquipmentWidth(this.mContext) - (this.mXOffset * 2);
        this.dUX = new com.baidu.tieba.NEGFeedBack.b(this.mPageContext);
        this.dUX.a(this.dUE);
        this.dUX.hx(true);
    }

    private int getWindowMeasuredHeight() {
        if (this.mContentView == null) {
            return 0;
        }
        this.mContentView.measure(0, 0);
        this.dUQ = this.mContentView.getMeasuredHeight() + l.getDimens(this.mContext, R.dimen.ds12);
        return this.dUQ;
    }

    public void setData(al alVar) {
        if (alVar != null) {
            this.dUN = alVar;
            this.dUB = alVar.getFeedBackReasonMap();
            if (this.dUB != null && this.dUB.size() > 8) {
                for (int size = this.dUB.size() - 1; size >= 8; size--) {
                    this.dUB.removeAt(size);
                }
            }
            this.dUX.setData(alVar);
        }
    }

    public void setDefaultReasonArray(String[] strArr) {
        this.dUX.setDefaultReasonArray(strArr);
    }

    public void aWs() {
        if (this.mPopupWindow != null) {
            this.mPopupWindow.dismiss();
            this.mPopupWindow = null;
        }
        if (this.dUU != null) {
            this.dUU.dismiss();
            this.dUU = null;
        }
    }

    private void resetState() {
        if (this.dUY && this.dUO.size() != 0) {
            this.dUO.clear();
        }
    }

    private void aHS() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            am.setViewTextColor(this.aEX, R.color.cp_cont_f, 1);
            am.setViewTextColor(this.dVl, R.color.cp_cont_f, 1);
            am.setBackgroundColor(this.mTopLine, R.color.cp_bg_line_c);
            am.setBackgroundColor(this.dVo, R.color.cp_bg_line_c);
            am.setViewTextColor(this.dVm, R.color.cp_cont_f, 1);
            am.setViewTextColor(this.dVn, R.color.cp_cont_d, 1);
            this.mSkinType = skinType;
        }
    }

    private View getView() {
        if (this.mContext == null) {
            return null;
        }
        if (this.mContentView == null) {
            this.mContentView = (ViewGroup) LayoutInflater.from(this.mContext).inflate(R.layout.neg_dt_head_popupwindow, (ViewGroup) null);
            this.dVm = (TextView) this.mContentView.findViewById(R.id.head_text);
            this.dVn = (TextView) this.mContentView.findViewById(R.id.sub_head_text);
        }
        View rootView = this.dUX.getRootView();
        if (rootView != null && rootView.getParent() == null) {
            int dimens = l.getDimens(this.mContext, R.dimen.ds40);
            rootView.setPadding(dimens, 0, dimens, 0);
            this.mContentView.addView(rootView);
        }
        if (this.dVi == null) {
            this.dVi = (LinearLayout) LayoutInflater.from(this.mContext).inflate(R.layout.neg_dt_bottom_popupwindow, (ViewGroup) null);
            this.aEX = (TextView) this.dVi.findViewById(R.id.dialog_bottom_cancel_button);
            this.dVl = (TextView) this.dVi.findViewById(R.id.dialog_bottom_certain_button);
            this.mTopLine = this.dVi.findViewById(R.id.top_line);
            this.dVo = this.dVi.findViewById(R.id.middle_line);
            this.mContentView.addView(this.dVi);
            this.aEX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.NEGFeedBack.e.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (e.this.dUU != null) {
                        e.this.dUU.dismiss();
                        e.this.dUU = null;
                    }
                    if (e.this.mPopupWindow != null) {
                        e.this.mPopupWindow.dismiss();
                        e.this.mPopupWindow = null;
                    }
                    if (e.this.dVj != null) {
                        e.this.dVj.onClick();
                    }
                }
            });
            if (this.dVl != null) {
                this.dVl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.NEGFeedBack.e.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        JSONObject aWw = e.this.aWw();
                        if (e.this.mFrom == "3" || e.this.mFrom == "4" || e.this.mFrom == "1") {
                            e.this.aWs();
                        } else if (aWw != null) {
                            e.this.showLoadingView();
                            CustomMessage customMessage = new CustomMessage(2016489, e.this.mPageContext.getUniqueId());
                            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2016489, aWw);
                            customResponsedMessage.setOrginalMessage(customMessage);
                            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                        }
                    }
                });
            }
            aHS();
        }
        return this.mContentView;
    }

    public void a(b bVar) {
        this.dVk = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLoadingView() {
        if (this.dGw == null) {
            this.dGw = new com.baidu.tbadk.core.view.a(this.mPageContext);
        }
        this.dGw.setTipString(R.string.loading);
        this.dGw.setDialogVisiable(true);
    }

    public void aWv() {
        if (this.dGw != null) {
            this.dGw.setDialogVisiable(false);
        }
    }

    public void wn(String str) {
        if (this.mContext != null) {
            this.mFrom = str;
            View view = getView();
            if (view != null && view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            aHS();
            this.mWindowHeight = getWindowMeasuredHeight() - l.getDimens(this.mContext, R.dimen.ds12);
            this.mPopupWindow = new PopupWindow(view, this.dUP, this.mWindowHeight);
            this.mPopupWindow.setFocusable(true);
            this.mPopupWindow.setTouchable(true);
            this.mPopupWindow.setOnDismissListener(this.dVd);
            resetState();
            this.dUU = new PopupWindow(LayoutInflater.from(this.mContext).inflate(R.layout.view_negative_feedback_bottom, (ViewGroup) null), -1, -1);
            if (Build.VERSION.SDK_INT >= 22) {
                this.dUU.setAttachedInDecor(false);
            }
            this.dUU.showAtLocation(this.mAnchor, 0, 0, 0);
            am.setBackgroundDrawable(this.mPopupWindow, R.drawable.bg_dailog);
            this.mPopupWindow.showAtLocation(this.mAnchor, 17, 0, 0);
            if (this.dUT != null) {
                this.dUT.b(this.dUN);
            }
            this.dUY = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject aWw() {
        int i;
        JSONObject jSONObject = new JSONObject();
        if (this.dUN == null) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        if (v.isEmpty(this.dUO)) {
            i = 0;
        } else {
            i = 0;
            for (int i2 = 0; i2 < this.dUO.size(); i2++) {
                b.a aVar = this.dUO.get(i2);
                if (aVar != null) {
                    jSONArray.put(String.valueOf(aVar.id));
                    i = aVar.index + 1;
                }
            }
        }
        TiebaStatic.log(new an("c13123").cx("obj_source", this.mFrom).X("obj_type", i));
        if (this.dVk != null) {
            this.dVk.S(jSONArray);
        }
        try {
            jSONObject.put(TiebaInitialize.LogFields.REASON, jSONArray);
            jSONObject.put("thread_ids", this.dUN.aAW());
            jSONObject.put("type", this.dUN.aAV());
            jSONObject.put("forum_id", this.dUN.getFid());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
