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
    private TextView bLJ;
    private View fPA;
    private int fPc;
    private PopupWindow fPg;
    private com.baidu.tieba.NEGFeedBack.b fPj;
    private boolean fPk;
    private LinearLayout fPu;
    private a fPv;
    private b fPw;
    private TextView fPx;
    private TextView fPy;
    private TextView fPz;
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
    private ar fPa = null;
    private SparseArray<String> fON = null;
    private List<b.a> fPb = new ArrayList();
    private NEGFeedBackView.a fPf = null;
    private int mSkinType = 3;
    private com.baidu.tbadk.core.view.a fxS = null;
    private CompoundButton.OnCheckedChangeListener fOR = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.NEGFeedBack.e.1
        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (e.this.fPf != null) {
                e.this.fPf.onCheckedChanged(e.this.fPa, compoundButton, z);
            }
            if (compoundButton.getTag() instanceof b.a) {
                b.a aVar = (b.a) compoundButton.getTag();
                if (z) {
                    if (!e.this.fPb.contains(aVar)) {
                        e.this.fPb.add(aVar);
                        return;
                    }
                    return;
                }
                e.this.fPb.remove(aVar);
            }
        }
    };
    private PopupWindow.OnDismissListener fPp = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.NEGFeedBack.e.2
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (e.this.fPg != null) {
                e.this.fPg.dismiss();
                e.this.fPg = null;
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
        this.fPj = new com.baidu.tieba.NEGFeedBack.b(this.mPageContext);
        this.fPj.a(this.fOR);
        this.fPj.le(true);
    }

    private int getWindowMeasuredHeight() {
        if (this.mContentView == null) {
            return 0;
        }
        this.mContentView.measure(0, 0);
        this.fPc = this.mContentView.getMeasuredHeight() + l.getDimens(this.mContext, R.dimen.ds12);
        return this.fPc;
    }

    public void setData(ar arVar) {
        if (arVar != null) {
            this.fPa = arVar;
            this.fON = arVar.getFeedBackReasonMap();
            if (this.fON != null && this.fON.size() > 8) {
                for (int size = this.fON.size() - 1; size >= 8; size--) {
                    this.fON.removeAt(size);
                }
            }
            this.fPj.setData(arVar);
        }
    }

    public void setDefaultReasonArray(String[] strArr) {
        this.fPj.setDefaultReasonArray(strArr);
    }

    public void bIw() {
        if (this.mPopupWindow != null) {
            this.mPopupWindow.dismiss();
            this.mPopupWindow = null;
        }
        if (this.fPg != null) {
            this.fPg.dismiss();
            this.fPg = null;
        }
    }

    private void resetState() {
        if (this.fPk && this.fPb.size() != 0) {
            this.fPb.clear();
        }
    }

    private void bsD() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            ap.setBackgroundColor(this.mContentView, R.color.cp_bg_line_f);
            ap.setViewTextColor(this.bLJ, R.color.cp_cont_f, 1);
            ap.setViewTextColor(this.fPx, R.color.cp_cont_f, 1);
            ap.setBackgroundColor(this.mTopLine, R.color.cp_bg_line_c);
            ap.setBackgroundColor(this.fPA, R.color.cp_bg_line_c);
            ap.setViewTextColor(this.fPy, R.color.cp_cont_f, 1);
            ap.setViewTextColor(this.fPz, R.color.cp_cont_d, 1);
            this.mSkinType = skinType;
        }
    }

    private View getView() {
        if (this.mContext == null) {
            return null;
        }
        if (this.mContentView == null) {
            this.mContentView = (ViewGroup) LayoutInflater.from(this.mContext).inflate(R.layout.neg_dt_head_popupwindow, (ViewGroup) null);
            this.fPy = (TextView) this.mContentView.findViewById(R.id.head_text);
            this.fPz = (TextView) this.mContentView.findViewById(R.id.sub_head_text);
        }
        View rootView = this.fPj.getRootView();
        if (rootView != null && rootView.getParent() == null) {
            int dimens = l.getDimens(this.mContext, R.dimen.ds40);
            rootView.setPadding(dimens, 0, dimens, 0);
            this.mContentView.addView(rootView);
        }
        if (this.fPu == null) {
            this.fPu = (LinearLayout) LayoutInflater.from(this.mContext).inflate(R.layout.neg_dt_bottom_popupwindow, (ViewGroup) null);
            this.bLJ = (TextView) this.fPu.findViewById(R.id.dialog_bottom_cancel_button);
            this.fPx = (TextView) this.fPu.findViewById(R.id.dialog_bottom_certain_button);
            this.mTopLine = this.fPu.findViewById(R.id.top_line);
            this.fPA = this.fPu.findViewById(R.id.middle_line);
            this.mContentView.addView(this.fPu);
            this.bLJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.NEGFeedBack.e.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (e.this.fPg != null) {
                        e.this.fPg.dismiss();
                        e.this.fPg = null;
                    }
                    if (e.this.mPopupWindow != null) {
                        e.this.mPopupWindow.dismiss();
                        e.this.mPopupWindow = null;
                    }
                    if (e.this.fPv != null) {
                        e.this.fPv.onClick();
                    }
                }
            });
            if (this.fPx != null) {
                this.fPx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.NEGFeedBack.e.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        JSONObject bIA = e.this.bIA();
                        if (e.this.mFrom == "3" || e.this.mFrom == "4" || e.this.mFrom == "1") {
                            e.this.bIw();
                        } else if (bIA != null) {
                            e.this.showLoadingView();
                            CustomMessage customMessage = new CustomMessage(2016489, e.this.mPageContext.getUniqueId());
                            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2016489, bIA);
                            customResponsedMessage.setOrginalMessage(customMessage);
                            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                        }
                    }
                });
            }
            bsD();
        }
        return this.mContentView;
    }

    public void a(b bVar) {
        this.fPw = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLoadingView() {
        if (this.fxS == null) {
            this.fxS = new com.baidu.tbadk.core.view.a(this.mPageContext);
        }
        this.fxS.setTipString(R.string.loading);
        this.fxS.setDialogVisiable(true);
    }

    public void bIz() {
        if (this.fxS != null) {
            this.fxS.setDialogVisiable(false);
        }
    }

    public void EU(String str) {
        if (this.mContext != null) {
            this.mFrom = str;
            View view = getView();
            if (view != null && view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            bsD();
            this.mWindowHeight = getWindowMeasuredHeight() - l.getDimens(this.mContext, R.dimen.ds12);
            this.mPopupWindow = new PopupWindow(view, this.mWindowWidth, this.mWindowHeight);
            this.mPopupWindow.setFocusable(true);
            this.mPopupWindow.setTouchable(true);
            this.mPopupWindow.setOnDismissListener(this.fPp);
            resetState();
            this.fPg = new PopupWindow(LayoutInflater.from(this.mContext).inflate(R.layout.view_negative_feedback_bottom, (ViewGroup) null), -1, -1);
            if (Build.VERSION.SDK_INT >= 22) {
                this.fPg.setAttachedInDecor(false);
            }
            this.fPg.showAtLocation(this.mAnchor, 0, 0, 0);
            ap.setBackgroundDrawable(this.mPopupWindow, R.drawable.bg_dailog);
            this.mPopupWindow.showAtLocation(this.mAnchor, 17, 0, 0);
            if (this.fPf != null) {
                this.fPf.onNEGFeedbackWindowShow(this.fPa);
            }
            this.fPk = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject bIA() {
        int i;
        JSONObject jSONObject = new JSONObject();
        if (this.fPa == null) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        if (y.isEmpty(this.fPb)) {
            i = 0;
        } else {
            i = 0;
            for (int i2 = 0; i2 < this.fPb.size(); i2++) {
                b.a aVar = this.fPb.get(i2);
                if (aVar != null) {
                    jSONArray.put(String.valueOf(aVar.id));
                    i = aVar.index + 1;
                }
            }
        }
        TiebaStatic.log(new aq("c13123").dR("obj_source", this.mFrom).al("obj_type", i));
        if (this.fPw != null) {
            this.fPw.W(jSONArray);
        }
        try {
            jSONObject.put(TiebaInitialize.LogFields.REASON, jSONArray);
            jSONObject.put("thread_ids", this.fPa.bkY());
            jSONObject.put("type", this.fPa.bkX());
            jSONObject.put("forum_id", this.fPa.getFid());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
