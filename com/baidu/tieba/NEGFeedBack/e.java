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
/* loaded from: classes20.dex */
public class e {
    private TextView bwF;
    private int foD;
    private PopupWindow foH;
    private com.baidu.tieba.NEGFeedBack.b foK;
    private boolean foL;
    private LinearLayout foV;
    private a foW;
    private b foX;
    private TextView foY;
    private TextView foZ;
    private TextView fpa;
    private View fpb;
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
    private ar foB = null;
    private SparseArray<String> foo = null;
    private List<b.a> foC = new ArrayList();
    private NEGFeedBackView.a foG = null;
    private int mSkinType = 3;
    private com.baidu.tbadk.core.view.a eXp = null;
    private CompoundButton.OnCheckedChangeListener fos = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.NEGFeedBack.e.1
        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (e.this.foG != null) {
                e.this.foG.onCheckedChanged(e.this.foB, compoundButton, z);
            }
            if (compoundButton.getTag() instanceof b.a) {
                b.a aVar = (b.a) compoundButton.getTag();
                if (z) {
                    if (!e.this.foC.contains(aVar)) {
                        e.this.foC.add(aVar);
                        return;
                    }
                    return;
                }
                e.this.foC.remove(aVar);
            }
        }
    };
    private PopupWindow.OnDismissListener foQ = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.NEGFeedBack.e.2
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (e.this.foH != null) {
                e.this.foH.dismiss();
                e.this.foH = null;
            }
        }
    };

    /* loaded from: classes20.dex */
    public interface a {
        void onClick();
    }

    /* loaded from: classes20.dex */
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
        this.foK = new com.baidu.tieba.NEGFeedBack.b(this.mPageContext);
        this.foK.a(this.fos);
        this.foK.kk(true);
    }

    private int getWindowMeasuredHeight() {
        if (this.mContentView == null) {
            return 0;
        }
        this.mContentView.measure(0, 0);
        this.foD = this.mContentView.getMeasuredHeight() + l.getDimens(this.mContext, R.dimen.ds12);
        return this.foD;
    }

    public void setData(ar arVar) {
        if (arVar != null) {
            this.foB = arVar;
            this.foo = arVar.getFeedBackReasonMap();
            if (this.foo != null && this.foo.size() > 8) {
                for (int size = this.foo.size() - 1; size >= 8; size--) {
                    this.foo.removeAt(size);
                }
            }
            this.foK.setData(arVar);
        }
    }

    public void setDefaultReasonArray(String[] strArr) {
        this.foK.setDefaultReasonArray(strArr);
    }

    public void bBs() {
        if (this.mPopupWindow != null) {
            this.mPopupWindow.dismiss();
            this.mPopupWindow = null;
        }
        if (this.foH != null) {
            this.foH.dismiss();
            this.foH = null;
        }
    }

    private void resetState() {
        if (this.foL && this.foC.size() != 0) {
            this.foC.clear();
        }
    }

    private void blA() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            ap.setBackgroundColor(this.mContentView, R.color.cp_bg_line_f);
            ap.setViewTextColor(this.bwF, R.color.cp_cont_f, 1);
            ap.setViewTextColor(this.foY, R.color.cp_cont_f, 1);
            ap.setBackgroundColor(this.mTopLine, R.color.cp_bg_line_c);
            ap.setBackgroundColor(this.fpb, R.color.cp_bg_line_c);
            ap.setViewTextColor(this.foZ, R.color.cp_cont_f, 1);
            ap.setViewTextColor(this.fpa, R.color.cp_cont_d, 1);
            this.mSkinType = skinType;
        }
    }

    private View getView() {
        if (this.mContext == null) {
            return null;
        }
        if (this.mContentView == null) {
            this.mContentView = (ViewGroup) LayoutInflater.from(this.mContext).inflate(R.layout.neg_dt_head_popupwindow, (ViewGroup) null);
            this.foZ = (TextView) this.mContentView.findViewById(R.id.head_text);
            this.fpa = (TextView) this.mContentView.findViewById(R.id.sub_head_text);
        }
        View rootView = this.foK.getRootView();
        if (rootView != null && rootView.getParent() == null) {
            int dimens = l.getDimens(this.mContext, R.dimen.ds40);
            rootView.setPadding(dimens, 0, dimens, 0);
            this.mContentView.addView(rootView);
        }
        if (this.foV == null) {
            this.foV = (LinearLayout) LayoutInflater.from(this.mContext).inflate(R.layout.neg_dt_bottom_popupwindow, (ViewGroup) null);
            this.bwF = (TextView) this.foV.findViewById(R.id.dialog_bottom_cancel_button);
            this.foY = (TextView) this.foV.findViewById(R.id.dialog_bottom_certain_button);
            this.mTopLine = this.foV.findViewById(R.id.top_line);
            this.fpb = this.foV.findViewById(R.id.middle_line);
            this.mContentView.addView(this.foV);
            this.bwF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.NEGFeedBack.e.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (e.this.foH != null) {
                        e.this.foH.dismiss();
                        e.this.foH = null;
                    }
                    if (e.this.mPopupWindow != null) {
                        e.this.mPopupWindow.dismiss();
                        e.this.mPopupWindow = null;
                    }
                    if (e.this.foW != null) {
                        e.this.foW.onClick();
                    }
                }
            });
            if (this.foY != null) {
                this.foY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.NEGFeedBack.e.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        JSONObject bBw = e.this.bBw();
                        if (e.this.mFrom == "3" || e.this.mFrom == "4" || e.this.mFrom == "1") {
                            e.this.bBs();
                        } else if (bBw != null) {
                            e.this.showLoadingView();
                            CustomMessage customMessage = new CustomMessage(2016489, e.this.mPageContext.getUniqueId());
                            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2016489, bBw);
                            customResponsedMessage.setOrginalMessage(customMessage);
                            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                        }
                    }
                });
            }
            blA();
        }
        return this.mContentView;
    }

    public void a(b bVar) {
        this.foX = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLoadingView() {
        if (this.eXp == null) {
            this.eXp = new com.baidu.tbadk.core.view.a(this.mPageContext);
        }
        this.eXp.setTipString(R.string.loading);
        this.eXp.setDialogVisiable(true);
    }

    public void bBv() {
        if (this.eXp != null) {
            this.eXp.setDialogVisiable(false);
        }
    }

    public void DC(String str) {
        if (this.mContext != null) {
            this.mFrom = str;
            View view = getView();
            if (view != null && view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            blA();
            this.mWindowHeight = getWindowMeasuredHeight() - l.getDimens(this.mContext, R.dimen.ds12);
            this.mPopupWindow = new PopupWindow(view, this.mWindowWidth, this.mWindowHeight);
            this.mPopupWindow.setFocusable(true);
            this.mPopupWindow.setTouchable(true);
            this.mPopupWindow.setOnDismissListener(this.foQ);
            resetState();
            this.foH = new PopupWindow(LayoutInflater.from(this.mContext).inflate(R.layout.view_negative_feedback_bottom, (ViewGroup) null), -1, -1);
            if (Build.VERSION.SDK_INT >= 22) {
                this.foH.setAttachedInDecor(false);
            }
            this.foH.showAtLocation(this.mAnchor, 0, 0, 0);
            ap.setBackgroundDrawable(this.mPopupWindow, R.drawable.bg_dailog);
            this.mPopupWindow.showAtLocation(this.mAnchor, 17, 0, 0);
            if (this.foG != null) {
                this.foG.onNEGFeedbackWindowShow(this.foB);
            }
            this.foL = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject bBw() {
        int i;
        JSONObject jSONObject = new JSONObject();
        if (this.foB == null) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        if (y.isEmpty(this.foC)) {
            i = 0;
        } else {
            i = 0;
            for (int i2 = 0; i2 < this.foC.size(); i2++) {
                b.a aVar = this.foC.get(i2);
                if (aVar != null) {
                    jSONArray.put(String.valueOf(aVar.id));
                    i = aVar.index + 1;
                }
            }
        }
        TiebaStatic.log(new aq("c13123").dF("obj_source", this.mFrom).ai("obj_type", i));
        if (this.foX != null) {
            this.foX.W(jSONArray);
        }
        try {
            jSONObject.put(TiebaInitialize.LogFields.REASON, jSONArray);
            jSONObject.put("thread_ids", this.foB.bdW());
            jSONObject.put("type", this.foB.bdV());
            jSONObject.put("forum_id", this.foB.getFid());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
