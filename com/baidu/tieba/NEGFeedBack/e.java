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
    private TextView aEH;
    private LinearLayout dUE;
    private a dUF;
    private b dUG;
    private TextView dUH;
    private TextView dUI;
    private TextView dUJ;
    private View dUK;
    private int dUl;
    private int dUm;
    private PopupWindow dUq;
    private com.baidu.tieba.NEGFeedBack.b dUt;
    private boolean dUu;
    private View mAnchor;
    private ViewGroup mContentView;
    private Context mContext;
    private String mFrom;
    private TbPageContext mPageContext;
    private View mTopLine;
    private int mWindowHeight;
    private int mXOffset;
    private PopupWindow mPopupWindow = null;
    private al dUj = null;
    private SparseArray<String> dTX = null;
    private List<b.a> dUk = new ArrayList();
    private NEGFeedBackView.a dUp = null;
    private int mSkinType = 3;
    private com.baidu.tbadk.core.view.a dFS = null;
    private CompoundButton.OnCheckedChangeListener dUa = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.NEGFeedBack.e.1
        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (e.this.dUp != null) {
                e.this.dUp.a(e.this.dUj, compoundButton, z);
            }
            if (compoundButton.getTag() instanceof b.a) {
                b.a aVar = (b.a) compoundButton.getTag();
                if (z) {
                    if (!e.this.dUk.contains(aVar)) {
                        e.this.dUk.add(aVar);
                        return;
                    }
                    return;
                }
                e.this.dUk.remove(aVar);
            }
        }
    };
    private PopupWindow.OnDismissListener dUz = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.NEGFeedBack.e.2
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (e.this.dUq != null) {
                e.this.dUq.dismiss();
                e.this.dUq = null;
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
        this.dUl = l.getEquipmentWidth(this.mContext) - (this.mXOffset * 2);
        this.dUt = new com.baidu.tieba.NEGFeedBack.b(this.mPageContext);
        this.dUt.a(this.dUa);
        this.dUt.hw(true);
    }

    private int getWindowMeasuredHeight() {
        if (this.mContentView == null) {
            return 0;
        }
        this.mContentView.measure(0, 0);
        this.dUm = this.mContentView.getMeasuredHeight() + l.getDimens(this.mContext, R.dimen.ds12);
        return this.dUm;
    }

    public void setData(al alVar) {
        if (alVar != null) {
            this.dUj = alVar;
            this.dTX = alVar.getFeedBackReasonMap();
            if (this.dTX != null && this.dTX.size() > 8) {
                for (int size = this.dTX.size() - 1; size >= 8; size--) {
                    this.dTX.removeAt(size);
                }
            }
            this.dUt.setData(alVar);
        }
    }

    public void setDefaultReasonArray(String[] strArr) {
        this.dUt.setDefaultReasonArray(strArr);
    }

    public void aWl() {
        if (this.mPopupWindow != null) {
            this.mPopupWindow.dismiss();
            this.mPopupWindow = null;
        }
        if (this.dUq != null) {
            this.dUq.dismiss();
            this.dUq = null;
        }
    }

    private void resetState() {
        if (this.dUu && this.dUk.size() != 0) {
            this.dUk.clear();
        }
    }

    private void aHL() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            am.setViewTextColor(this.aEH, R.color.cp_cont_f, 1);
            am.setViewTextColor(this.dUH, R.color.cp_cont_f, 1);
            am.setBackgroundColor(this.mTopLine, R.color.cp_bg_line_c);
            am.setBackgroundColor(this.dUK, R.color.cp_bg_line_c);
            am.setViewTextColor(this.dUI, R.color.cp_cont_f, 1);
            am.setViewTextColor(this.dUJ, R.color.cp_cont_d, 1);
            this.mSkinType = skinType;
        }
    }

    private View getView() {
        if (this.mContext == null) {
            return null;
        }
        if (this.mContentView == null) {
            this.mContentView = (ViewGroup) LayoutInflater.from(this.mContext).inflate(R.layout.neg_dt_head_popupwindow, (ViewGroup) null);
            this.dUI = (TextView) this.mContentView.findViewById(R.id.head_text);
            this.dUJ = (TextView) this.mContentView.findViewById(R.id.sub_head_text);
        }
        View rootView = this.dUt.getRootView();
        if (rootView != null && rootView.getParent() == null) {
            int dimens = l.getDimens(this.mContext, R.dimen.ds40);
            rootView.setPadding(dimens, 0, dimens, 0);
            this.mContentView.addView(rootView);
        }
        if (this.dUE == null) {
            this.dUE = (LinearLayout) LayoutInflater.from(this.mContext).inflate(R.layout.neg_dt_bottom_popupwindow, (ViewGroup) null);
            this.aEH = (TextView) this.dUE.findViewById(R.id.dialog_bottom_cancel_button);
            this.dUH = (TextView) this.dUE.findViewById(R.id.dialog_bottom_certain_button);
            this.mTopLine = this.dUE.findViewById(R.id.top_line);
            this.dUK = this.dUE.findViewById(R.id.middle_line);
            this.mContentView.addView(this.dUE);
            this.aEH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.NEGFeedBack.e.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (e.this.dUq != null) {
                        e.this.dUq.dismiss();
                        e.this.dUq = null;
                    }
                    if (e.this.mPopupWindow != null) {
                        e.this.mPopupWindow.dismiss();
                        e.this.mPopupWindow = null;
                    }
                    if (e.this.dUF != null) {
                        e.this.dUF.onClick();
                    }
                }
            });
            if (this.dUH != null) {
                this.dUH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.NEGFeedBack.e.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        JSONObject aWp = e.this.aWp();
                        if (e.this.mFrom == "3" || e.this.mFrom == "4" || e.this.mFrom == "1") {
                            e.this.aWl();
                        } else if (aWp != null) {
                            e.this.showLoadingView();
                            CustomMessage customMessage = new CustomMessage(2016489, e.this.mPageContext.getUniqueId());
                            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2016489, aWp);
                            customResponsedMessage.setOrginalMessage(customMessage);
                            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                        }
                    }
                });
            }
            aHL();
        }
        return this.mContentView;
    }

    public void a(b bVar) {
        this.dUG = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLoadingView() {
        if (this.dFS == null) {
            this.dFS = new com.baidu.tbadk.core.view.a(this.mPageContext);
        }
        this.dFS.setTipString(R.string.loading);
        this.dFS.setDialogVisiable(true);
    }

    public void aWo() {
        if (this.dFS != null) {
            this.dFS.setDialogVisiable(false);
        }
    }

    public void wm(String str) {
        if (this.mContext != null) {
            this.mFrom = str;
            View view = getView();
            if (view != null && view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            aHL();
            this.mWindowHeight = getWindowMeasuredHeight() - l.getDimens(this.mContext, R.dimen.ds12);
            this.mPopupWindow = new PopupWindow(view, this.dUl, this.mWindowHeight);
            this.mPopupWindow.setFocusable(true);
            this.mPopupWindow.setTouchable(true);
            this.mPopupWindow.setOnDismissListener(this.dUz);
            resetState();
            this.dUq = new PopupWindow(LayoutInflater.from(this.mContext).inflate(R.layout.view_negative_feedback_bottom, (ViewGroup) null), -1, -1);
            if (Build.VERSION.SDK_INT >= 22) {
                this.dUq.setAttachedInDecor(false);
            }
            this.dUq.showAtLocation(this.mAnchor, 0, 0, 0);
            am.setBackgroundDrawable(this.mPopupWindow, R.drawable.bg_dailog);
            this.mPopupWindow.showAtLocation(this.mAnchor, 17, 0, 0);
            if (this.dUp != null) {
                this.dUp.b(this.dUj);
            }
            this.dUu = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject aWp() {
        int i;
        JSONObject jSONObject = new JSONObject();
        if (this.dUj == null) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        if (v.isEmpty(this.dUk)) {
            i = 0;
        } else {
            i = 0;
            for (int i2 = 0; i2 < this.dUk.size(); i2++) {
                b.a aVar = this.dUk.get(i2);
                if (aVar != null) {
                    jSONArray.put(String.valueOf(aVar.id));
                    i = aVar.index + 1;
                }
            }
        }
        TiebaStatic.log(new an("c13123").cy("obj_source", this.mFrom).X("obj_type", i));
        if (this.dUG != null) {
            this.dUG.S(jSONArray);
        }
        try {
            jSONObject.put(TiebaInitialize.LogFields.REASON, jSONArray);
            jSONObject.put("thread_ids", this.dUj.aAR());
            jSONObject.put("type", this.dUj.aAQ());
            jSONObject.put("forum_id", this.dUj.getFid());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
