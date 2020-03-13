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
    private TextView aEJ;
    private int dUA;
    private PopupWindow dUE;
    private com.baidu.tieba.NEGFeedBack.b dUH;
    private boolean dUI;
    private LinearLayout dUS;
    private a dUT;
    private b dUU;
    private TextView dUV;
    private TextView dUW;
    private TextView dUX;
    private View dUY;
    private int dUz;
    private View mAnchor;
    private ViewGroup mContentView;
    private Context mContext;
    private String mFrom;
    private TbPageContext mPageContext;
    private View mTopLine;
    private int mWindowHeight;
    private int mXOffset;
    private PopupWindow mPopupWindow = null;
    private al dUx = null;
    private SparseArray<String> dUl = null;
    private List<b.a> dUy = new ArrayList();
    private NEGFeedBackView.a dUD = null;
    private int mSkinType = 3;
    private com.baidu.tbadk.core.view.a dGg = null;
    private CompoundButton.OnCheckedChangeListener dUo = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.NEGFeedBack.e.1
        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (e.this.dUD != null) {
                e.this.dUD.a(e.this.dUx, compoundButton, z);
            }
            if (compoundButton.getTag() instanceof b.a) {
                b.a aVar = (b.a) compoundButton.getTag();
                if (z) {
                    if (!e.this.dUy.contains(aVar)) {
                        e.this.dUy.add(aVar);
                        return;
                    }
                    return;
                }
                e.this.dUy.remove(aVar);
            }
        }
    };
    private PopupWindow.OnDismissListener dUN = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.NEGFeedBack.e.2
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (e.this.dUE != null) {
                e.this.dUE.dismiss();
                e.this.dUE = null;
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
        this.dUz = l.getEquipmentWidth(this.mContext) - (this.mXOffset * 2);
        this.dUH = new com.baidu.tieba.NEGFeedBack.b(this.mPageContext);
        this.dUH.a(this.dUo);
        this.dUH.hw(true);
    }

    private int getWindowMeasuredHeight() {
        if (this.mContentView == null) {
            return 0;
        }
        this.mContentView.measure(0, 0);
        this.dUA = this.mContentView.getMeasuredHeight() + l.getDimens(this.mContext, R.dimen.ds12);
        return this.dUA;
    }

    public void setData(al alVar) {
        if (alVar != null) {
            this.dUx = alVar;
            this.dUl = alVar.getFeedBackReasonMap();
            if (this.dUl != null && this.dUl.size() > 8) {
                for (int size = this.dUl.size() - 1; size >= 8; size--) {
                    this.dUl.removeAt(size);
                }
            }
            this.dUH.setData(alVar);
        }
    }

    public void setDefaultReasonArray(String[] strArr) {
        this.dUH.setDefaultReasonArray(strArr);
    }

    public void aWo() {
        if (this.mPopupWindow != null) {
            this.mPopupWindow.dismiss();
            this.mPopupWindow = null;
        }
        if (this.dUE != null) {
            this.dUE.dismiss();
            this.dUE = null;
        }
    }

    private void resetState() {
        if (this.dUI && this.dUy.size() != 0) {
            this.dUy.clear();
        }
    }

    private void aHO() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            am.setViewTextColor(this.aEJ, R.color.cp_cont_f, 1);
            am.setViewTextColor(this.dUV, R.color.cp_cont_f, 1);
            am.setBackgroundColor(this.mTopLine, R.color.cp_bg_line_c);
            am.setBackgroundColor(this.dUY, R.color.cp_bg_line_c);
            am.setViewTextColor(this.dUW, R.color.cp_cont_f, 1);
            am.setViewTextColor(this.dUX, R.color.cp_cont_d, 1);
            this.mSkinType = skinType;
        }
    }

    private View getView() {
        if (this.mContext == null) {
            return null;
        }
        if (this.mContentView == null) {
            this.mContentView = (ViewGroup) LayoutInflater.from(this.mContext).inflate(R.layout.neg_dt_head_popupwindow, (ViewGroup) null);
            this.dUW = (TextView) this.mContentView.findViewById(R.id.head_text);
            this.dUX = (TextView) this.mContentView.findViewById(R.id.sub_head_text);
        }
        View rootView = this.dUH.getRootView();
        if (rootView != null && rootView.getParent() == null) {
            int dimens = l.getDimens(this.mContext, R.dimen.ds40);
            rootView.setPadding(dimens, 0, dimens, 0);
            this.mContentView.addView(rootView);
        }
        if (this.dUS == null) {
            this.dUS = (LinearLayout) LayoutInflater.from(this.mContext).inflate(R.layout.neg_dt_bottom_popupwindow, (ViewGroup) null);
            this.aEJ = (TextView) this.dUS.findViewById(R.id.dialog_bottom_cancel_button);
            this.dUV = (TextView) this.dUS.findViewById(R.id.dialog_bottom_certain_button);
            this.mTopLine = this.dUS.findViewById(R.id.top_line);
            this.dUY = this.dUS.findViewById(R.id.middle_line);
            this.mContentView.addView(this.dUS);
            this.aEJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.NEGFeedBack.e.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (e.this.dUE != null) {
                        e.this.dUE.dismiss();
                        e.this.dUE = null;
                    }
                    if (e.this.mPopupWindow != null) {
                        e.this.mPopupWindow.dismiss();
                        e.this.mPopupWindow = null;
                    }
                    if (e.this.dUT != null) {
                        e.this.dUT.onClick();
                    }
                }
            });
            if (this.dUV != null) {
                this.dUV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.NEGFeedBack.e.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        JSONObject aWs = e.this.aWs();
                        if (e.this.mFrom == "3" || e.this.mFrom == "4" || e.this.mFrom == "1") {
                            e.this.aWo();
                        } else if (aWs != null) {
                            e.this.showLoadingView();
                            CustomMessage customMessage = new CustomMessage(2016489, e.this.mPageContext.getUniqueId());
                            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2016489, aWs);
                            customResponsedMessage.setOrginalMessage(customMessage);
                            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                        }
                    }
                });
            }
            aHO();
        }
        return this.mContentView;
    }

    public void a(b bVar) {
        this.dUU = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLoadingView() {
        if (this.dGg == null) {
            this.dGg = new com.baidu.tbadk.core.view.a(this.mPageContext);
        }
        this.dGg.setTipString(R.string.loading);
        this.dGg.setDialogVisiable(true);
    }

    public void aWr() {
        if (this.dGg != null) {
            this.dGg.setDialogVisiable(false);
        }
    }

    public void wn(String str) {
        if (this.mContext != null) {
            this.mFrom = str;
            View view = getView();
            if (view != null && view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            aHO();
            this.mWindowHeight = getWindowMeasuredHeight() - l.getDimens(this.mContext, R.dimen.ds12);
            this.mPopupWindow = new PopupWindow(view, this.dUz, this.mWindowHeight);
            this.mPopupWindow.setFocusable(true);
            this.mPopupWindow.setTouchable(true);
            this.mPopupWindow.setOnDismissListener(this.dUN);
            resetState();
            this.dUE = new PopupWindow(LayoutInflater.from(this.mContext).inflate(R.layout.view_negative_feedback_bottom, (ViewGroup) null), -1, -1);
            if (Build.VERSION.SDK_INT >= 22) {
                this.dUE.setAttachedInDecor(false);
            }
            this.dUE.showAtLocation(this.mAnchor, 0, 0, 0);
            am.setBackgroundDrawable(this.mPopupWindow, R.drawable.bg_dailog);
            this.mPopupWindow.showAtLocation(this.mAnchor, 17, 0, 0);
            if (this.dUD != null) {
                this.dUD.b(this.dUx);
            }
            this.dUI = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject aWs() {
        int i;
        JSONObject jSONObject = new JSONObject();
        if (this.dUx == null) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        if (v.isEmpty(this.dUy)) {
            i = 0;
        } else {
            i = 0;
            for (int i2 = 0; i2 < this.dUy.size(); i2++) {
                b.a aVar = this.dUy.get(i2);
                if (aVar != null) {
                    jSONArray.put(String.valueOf(aVar.id));
                    i = aVar.index + 1;
                }
            }
        }
        TiebaStatic.log(new an("c13123").cy("obj_source", this.mFrom).X("obj_type", i));
        if (this.dUU != null) {
            this.dUU.S(jSONArray);
        }
        try {
            jSONObject.put(TiebaInitialize.LogFields.REASON, jSONArray);
            jSONObject.put("thread_ids", this.dUx.aAT());
            jSONObject.put("type", this.dUx.aAS());
            jSONObject.put("forum_id", this.dUx.getFid());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
