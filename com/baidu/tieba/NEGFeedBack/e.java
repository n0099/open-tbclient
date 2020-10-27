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
import com.baidu.tbadk.core.data.ar;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.NEGFeedBack.b;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes21.dex */
public class e {
    private TextView bGe;
    private LinearLayout fJE;
    private a fJF;
    private b fJG;
    private TextView fJH;
    private TextView fJI;
    private TextView fJJ;
    private View fJK;
    private int fJm;
    private PopupWindow fJq;
    private com.baidu.tieba.NEGFeedBack.b fJt;
    private boolean fJu;
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
    private ar fJk = null;
    private SparseArray<String> fIX = null;
    private List<b.a> fJl = new ArrayList();
    private NEGFeedBackView.a fJp = null;
    private int mSkinType = 3;
    private com.baidu.tbadk.core.view.a fsa = null;
    private CompoundButton.OnCheckedChangeListener fJb = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.NEGFeedBack.e.1
        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (e.this.fJp != null) {
                e.this.fJp.onCheckedChanged(e.this.fJk, compoundButton, z);
            }
            if (compoundButton.getTag() instanceof b.a) {
                b.a aVar = (b.a) compoundButton.getTag();
                if (z) {
                    if (!e.this.fJl.contains(aVar)) {
                        e.this.fJl.add(aVar);
                        return;
                    }
                    return;
                }
                e.this.fJl.remove(aVar);
            }
        }
    };
    private PopupWindow.OnDismissListener fJz = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.NEGFeedBack.e.2
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (e.this.fJq != null) {
                e.this.fJq.dismiss();
                e.this.fJq = null;
            }
        }
    };

    /* loaded from: classes21.dex */
    public interface a {
        void onClick();
    }

    /* loaded from: classes21.dex */
    public interface b {
        void W(JSONArray jSONArray);
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
        this.fJt = new com.baidu.tieba.NEGFeedBack.b(this.mPageContext);
        this.fJt.a(this.fJb);
        this.fJt.kV(true);
    }

    private int getWindowMeasuredHeight() {
        if (this.mContentView == null) {
            return 0;
        }
        this.mContentView.measure(0, 0);
        this.fJm = this.mContentView.getMeasuredHeight() + l.getDimens(this.mContext, R.dimen.ds12);
        return this.fJm;
    }

    public void setData(ar arVar) {
        if (arVar != null) {
            this.fJk = arVar;
            this.fIX = arVar.getFeedBackReasonMap();
            if (this.fIX != null && this.fIX.size() > 8) {
                for (int size = this.fIX.size() - 1; size >= 8; size--) {
                    this.fIX.removeAt(size);
                }
            }
            this.fJt.setData(arVar);
        }
    }

    public void setDefaultReasonArray(String[] strArr) {
        this.fJt.setDefaultReasonArray(strArr);
    }

    public void bFX() {
        if (this.mPopupWindow != null) {
            this.mPopupWindow.dismiss();
            this.mPopupWindow = null;
        }
        if (this.fJq != null) {
            this.fJq.dismiss();
            this.fJq = null;
        }
    }

    private void resetState() {
        if (this.fJu && this.fJl.size() != 0) {
            this.fJl.clear();
        }
    }

    private void bqd() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            ap.setBackgroundColor(this.mContentView, R.color.cp_bg_line_f);
            ap.setViewTextColor(this.bGe, R.color.cp_cont_f, 1);
            ap.setViewTextColor(this.fJH, R.color.cp_cont_f, 1);
            ap.setBackgroundColor(this.mTopLine, R.color.cp_bg_line_c);
            ap.setBackgroundColor(this.fJK, R.color.cp_bg_line_c);
            ap.setViewTextColor(this.fJI, R.color.cp_cont_f, 1);
            ap.setViewTextColor(this.fJJ, R.color.cp_cont_d, 1);
            this.mSkinType = skinType;
        }
    }

    private View getView() {
        if (this.mContext == null) {
            return null;
        }
        if (this.mContentView == null) {
            this.mContentView = (ViewGroup) LayoutInflater.from(this.mContext).inflate(R.layout.neg_dt_head_popupwindow, (ViewGroup) null);
            this.fJI = (TextView) this.mContentView.findViewById(R.id.head_text);
            this.fJJ = (TextView) this.mContentView.findViewById(R.id.sub_head_text);
        }
        View rootView = this.fJt.getRootView();
        if (rootView != null && rootView.getParent() == null) {
            int dimens = l.getDimens(this.mContext, R.dimen.ds40);
            rootView.setPadding(dimens, 0, dimens, 0);
            this.mContentView.addView(rootView);
        }
        if (this.fJE == null) {
            this.fJE = (LinearLayout) LayoutInflater.from(this.mContext).inflate(R.layout.neg_dt_bottom_popupwindow, (ViewGroup) null);
            this.bGe = (TextView) this.fJE.findViewById(R.id.dialog_bottom_cancel_button);
            this.fJH = (TextView) this.fJE.findViewById(R.id.dialog_bottom_certain_button);
            this.mTopLine = this.fJE.findViewById(R.id.top_line);
            this.fJK = this.fJE.findViewById(R.id.middle_line);
            this.mContentView.addView(this.fJE);
            this.bGe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.NEGFeedBack.e.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (e.this.fJq != null) {
                        e.this.fJq.dismiss();
                        e.this.fJq = null;
                    }
                    if (e.this.mPopupWindow != null) {
                        e.this.mPopupWindow.dismiss();
                        e.this.mPopupWindow = null;
                    }
                    if (e.this.fJF != null) {
                        e.this.fJF.onClick();
                    }
                }
            });
            if (this.fJH != null) {
                this.fJH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.NEGFeedBack.e.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        JSONObject bGb = e.this.bGb();
                        if (e.this.mFrom == "3" || e.this.mFrom == "4" || e.this.mFrom == "1") {
                            e.this.bFX();
                        } else if (bGb != null) {
                            e.this.showLoadingView();
                            CustomMessage customMessage = new CustomMessage(2016489, e.this.mPageContext.getUniqueId());
                            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2016489, bGb);
                            customResponsedMessage.setOrginalMessage(customMessage);
                            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                        }
                    }
                });
            }
            bqd();
        }
        return this.mContentView;
    }

    public void a(b bVar) {
        this.fJG = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLoadingView() {
        if (this.fsa == null) {
            this.fsa = new com.baidu.tbadk.core.view.a(this.mPageContext);
        }
        this.fsa.setTipString(R.string.loading);
        this.fsa.setDialogVisiable(true);
    }

    public void bGa() {
        if (this.fsa != null) {
            this.fsa.setDialogVisiable(false);
        }
    }

    public void EG(String str) {
        if (this.mContext != null) {
            this.mFrom = str;
            View view = getView();
            if (view != null && view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            bqd();
            this.mWindowHeight = getWindowMeasuredHeight() - l.getDimens(this.mContext, R.dimen.ds12);
            this.mPopupWindow = new PopupWindow(view, this.mWindowWidth, this.mWindowHeight);
            this.mPopupWindow.setFocusable(true);
            this.mPopupWindow.setTouchable(true);
            this.mPopupWindow.setOnDismissListener(this.fJz);
            resetState();
            this.fJq = new PopupWindow(LayoutInflater.from(this.mContext).inflate(R.layout.view_negative_feedback_bottom, (ViewGroup) null), -1, -1);
            if (Build.VERSION.SDK_INT >= 22) {
                this.fJq.setAttachedInDecor(false);
            }
            this.fJq.showAtLocation(this.mAnchor, 0, 0, 0);
            ap.setBackgroundDrawable(this.mPopupWindow, R.drawable.bg_dailog);
            this.mPopupWindow.showAtLocation(this.mAnchor, 17, 0, 0);
            if (this.fJp != null) {
                this.fJp.onNEGFeedbackWindowShow(this.fJk);
            }
            this.fJu = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject bGb() {
        int i;
        JSONObject jSONObject = new JSONObject();
        if (this.fJk == null) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        if (y.isEmpty(this.fJl)) {
            i = 0;
        } else {
            i = 0;
            for (int i2 = 0; i2 < this.fJl.size(); i2++) {
                b.a aVar = this.fJl.get(i2);
                if (aVar != null) {
                    jSONArray.put(String.valueOf(aVar.id));
                    i = aVar.index + 1;
                }
            }
        }
        TiebaStatic.log(new aq("c13123").dR("obj_source", this.mFrom).aj("obj_type", i));
        if (this.fJG != null) {
            this.fJG.W(jSONArray);
        }
        try {
            jSONObject.put(TiebaInitialize.LogFields.REASON, jSONArray);
            jSONObject.put("thread_ids", this.fJk.biy());
            jSONObject.put("type", this.fJk.bix());
            jSONObject.put("forum_id", this.fJk.getFid());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
