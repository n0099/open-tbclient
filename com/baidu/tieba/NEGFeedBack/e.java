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
/* loaded from: classes6.dex */
public class e {
    private TextView aAr;
    private b dQA;
    private TextView dQB;
    private TextView dQC;
    private TextView dQD;
    private View dQE;
    private int dQf;
    private int dQg;
    private PopupWindow dQk;
    private com.baidu.tieba.NEGFeedBack.b dQn;
    private boolean dQo;
    private LinearLayout dQy;
    private a dQz;
    private View mAnchor;
    private ViewGroup mContentView;
    private Context mContext;
    private String mFrom;
    private TbPageContext mPageContext;
    private View mTopLine;
    private int mWindowHeight;
    private int mXOffset;
    private PopupWindow mPopupWindow = null;
    private al dQd = null;
    private SparseArray<String> dPR = null;
    private List<b.a> dQe = new ArrayList();
    private NEGFeedBackView.a dQj = null;
    private int mSkinType = 3;
    private com.baidu.tbadk.core.view.a dBR = null;
    private CompoundButton.OnCheckedChangeListener dPU = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.NEGFeedBack.e.1
        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (e.this.dQj != null) {
                e.this.dQj.a(e.this.dQd, compoundButton, z);
            }
            if (compoundButton.getTag() instanceof b.a) {
                b.a aVar = (b.a) compoundButton.getTag();
                if (z) {
                    if (!e.this.dQe.contains(aVar)) {
                        e.this.dQe.add(aVar);
                        return;
                    }
                    return;
                }
                e.this.dQe.remove(aVar);
            }
        }
    };
    private PopupWindow.OnDismissListener dQt = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.NEGFeedBack.e.2
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (e.this.dQk != null) {
                e.this.dQk.dismiss();
                e.this.dQk = null;
            }
        }
    };

    /* loaded from: classes6.dex */
    public interface a {
        void onClick();
    }

    /* loaded from: classes6.dex */
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
        this.dQf = l.getEquipmentWidth(this.mContext) - (this.mXOffset * 2);
        this.dQn = new com.baidu.tieba.NEGFeedBack.b(this.mPageContext);
        this.dQn.a(this.dPU);
        this.dQn.hp(true);
    }

    private int getWindowMeasuredHeight() {
        if (this.mContentView == null) {
            return 0;
        }
        this.mContentView.measure(0, 0);
        this.dQg = this.mContentView.getMeasuredHeight() + l.getDimens(this.mContext, R.dimen.ds12);
        return this.dQg;
    }

    public void setData(al alVar) {
        if (alVar != null) {
            this.dQd = alVar;
            this.dPR = alVar.getFeedBackReasonMap();
            if (this.dPR != null && this.dPR.size() > 8) {
                for (int size = this.dPR.size() - 1; size >= 8; size--) {
                    this.dPR.removeAt(size);
                }
            }
            this.dQn.setData(alVar);
        }
    }

    public void setDefaultReasonArray(String[] strArr) {
        this.dQn.setDefaultReasonArray(strArr);
    }

    public void aTV() {
        if (this.mPopupWindow != null) {
            this.mPopupWindow.dismiss();
            this.mPopupWindow = null;
        }
        if (this.dQk != null) {
            this.dQk.dismiss();
            this.dQk = null;
        }
    }

    private void resetState() {
        if (this.dQo && this.dQe.size() != 0) {
            this.dQe.clear();
        }
    }

    private void aFw() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            am.setViewTextColor(this.aAr, R.color.cp_cont_f, 1);
            am.setViewTextColor(this.dQB, R.color.cp_cont_f, 1);
            am.setBackgroundColor(this.mTopLine, R.color.cp_bg_line_c);
            am.setBackgroundColor(this.dQE, R.color.cp_bg_line_c);
            am.setViewTextColor(this.dQC, R.color.cp_cont_f, 1);
            am.setViewTextColor(this.dQD, R.color.cp_cont_d, 1);
            this.mSkinType = skinType;
        }
    }

    private View getView() {
        if (this.mContext == null) {
            return null;
        }
        if (this.mContentView == null) {
            this.mContentView = (ViewGroup) LayoutInflater.from(this.mContext).inflate(R.layout.neg_dt_head_popupwindow, (ViewGroup) null);
            this.dQC = (TextView) this.mContentView.findViewById(R.id.head_text);
            this.dQD = (TextView) this.mContentView.findViewById(R.id.sub_head_text);
        }
        View rootView = this.dQn.getRootView();
        if (rootView != null && rootView.getParent() == null) {
            int dimens = l.getDimens(this.mContext, R.dimen.ds40);
            rootView.setPadding(dimens, 0, dimens, 0);
            this.mContentView.addView(rootView);
        }
        if (this.dQy == null) {
            this.dQy = (LinearLayout) LayoutInflater.from(this.mContext).inflate(R.layout.neg_dt_bottom_popupwindow, (ViewGroup) null);
            this.aAr = (TextView) this.dQy.findViewById(R.id.dialog_bottom_cancel_button);
            this.dQB = (TextView) this.dQy.findViewById(R.id.dialog_bottom_certain_button);
            this.mTopLine = this.dQy.findViewById(R.id.top_line);
            this.dQE = this.dQy.findViewById(R.id.middle_line);
            this.mContentView.addView(this.dQy);
            this.aAr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.NEGFeedBack.e.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (e.this.dQk != null) {
                        e.this.dQk.dismiss();
                        e.this.dQk = null;
                    }
                    if (e.this.mPopupWindow != null) {
                        e.this.mPopupWindow.dismiss();
                        e.this.mPopupWindow = null;
                    }
                    if (e.this.dQz != null) {
                        e.this.dQz.onClick();
                    }
                }
            });
            if (this.dQB != null) {
                this.dQB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.NEGFeedBack.e.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        JSONObject aTZ = e.this.aTZ();
                        if (e.this.mFrom == "3" || e.this.mFrom == "4" || e.this.mFrom == "1") {
                            e.this.aTV();
                        } else if (aTZ != null) {
                            e.this.showLoadingView();
                            CustomMessage customMessage = new CustomMessage(2016489, e.this.mPageContext.getUniqueId());
                            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2016489, aTZ);
                            customResponsedMessage.setOrginalMessage(customMessage);
                            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                        }
                    }
                });
            }
            aFw();
        }
        return this.mContentView;
    }

    public void a(b bVar) {
        this.dQA = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLoadingView() {
        if (this.dBR == null) {
            this.dBR = new com.baidu.tbadk.core.view.a(this.mPageContext);
        }
        this.dBR.setTipString(R.string.loading);
        this.dBR.setDialogVisiable(true);
    }

    public void aTY() {
        if (this.dBR != null) {
            this.dBR.setDialogVisiable(false);
        }
    }

    public void vS(String str) {
        if (this.mContext != null) {
            this.mFrom = str;
            View view = getView();
            if (view != null && view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            aFw();
            this.mWindowHeight = getWindowMeasuredHeight() - l.getDimens(this.mContext, R.dimen.ds12);
            this.mPopupWindow = new PopupWindow(view, this.dQf, this.mWindowHeight);
            this.mPopupWindow.setFocusable(true);
            this.mPopupWindow.setTouchable(true);
            this.mPopupWindow.setOnDismissListener(this.dQt);
            resetState();
            this.dQk = new PopupWindow(LayoutInflater.from(this.mContext).inflate(R.layout.view_negative_feedback_bottom, (ViewGroup) null), -1, -1);
            if (Build.VERSION.SDK_INT >= 22) {
                this.dQk.setAttachedInDecor(false);
            }
            this.dQk.showAtLocation(this.mAnchor, 0, 0, 0);
            am.setBackgroundDrawable(this.mPopupWindow, R.drawable.bg_dailog);
            this.mPopupWindow.showAtLocation(this.mAnchor, 17, 0, 0);
            if (this.dQj != null) {
                this.dQj.b(this.dQd);
            }
            this.dQo = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject aTZ() {
        int i;
        JSONObject jSONObject = new JSONObject();
        if (this.dQd == null) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        if (v.isEmpty(this.dQe)) {
            i = 0;
        } else {
            i = 0;
            for (int i2 = 0; i2 < this.dQe.size(); i2++) {
                b.a aVar = this.dQe.get(i2);
                if (aVar != null) {
                    jSONArray.put(String.valueOf(aVar.id));
                    i = aVar.index + 1;
                }
            }
        }
        TiebaStatic.log(new an("c13123").cp("obj_source", this.mFrom).Z("obj_type", i));
        if (this.dQA != null) {
            this.dQA.S(jSONArray);
        }
        try {
            jSONObject.put(TiebaInitialize.LogFields.REASON, jSONArray);
            jSONObject.put("thread_ids", this.dQd.ayD());
            jSONObject.put("type", this.dQd.ayC());
            jSONObject.put("forum_id", this.dQd.getFid());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
