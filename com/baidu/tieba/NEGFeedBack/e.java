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
import com.baidu.tbadk.core.data.aj;
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
/* loaded from: classes3.dex */
public class e {
    private TextView arT;
    private View dcA;
    private int dcc;
    private int dcd;
    private PopupWindow dch;
    private com.baidu.tieba.NEGFeedBack.b dck;
    private boolean dcl;
    private LinearLayout dct;
    private a dcv;
    private b dcw;
    private TextView dcx;
    private TextView dcy;
    private TextView dcz;
    private View mAnchor;
    private ViewGroup mContentView;
    private Context mContext;
    private String mFrom;
    private TbPageContext mPageContext;
    private View mTopLine;
    private int mWindowHeight;
    private int mXOffset;
    private PopupWindow mPopupWindow = null;
    private aj dca = null;
    private SparseArray<String> dbM = null;
    private List<b.a> dcb = new ArrayList();
    private NEGFeedBackView.a dcg = null;
    private int mSkinType = 3;
    private com.baidu.tbadk.core.view.b cNJ = null;
    private CompoundButton.OnCheckedChangeListener dbP = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.NEGFeedBack.e.1
        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (e.this.dcg != null) {
                e.this.dcg.a(e.this.dca, compoundButton, z);
            }
            if (compoundButton.getTag() instanceof b.a) {
                b.a aVar = (b.a) compoundButton.getTag();
                if (z) {
                    if (!e.this.dcb.contains(aVar)) {
                        e.this.dcb.add(aVar);
                        return;
                    }
                    return;
                }
                e.this.dcb.remove(aVar);
            }
        }
    };
    private PopupWindow.OnDismissListener dco = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.NEGFeedBack.e.2
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (e.this.dch != null) {
                e.this.dch.dismiss();
                e.this.dch = null;
            }
        }
    };

    /* loaded from: classes3.dex */
    public interface a {
        void onClick();
    }

    /* loaded from: classes3.dex */
    public interface b {
        void K(JSONArray jSONArray);
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
        this.dcc = l.getEquipmentWidth(this.mContext) - (this.mXOffset * 2);
        this.dck = new com.baidu.tieba.NEGFeedBack.b(this.mPageContext);
        this.dck.a(this.dbP);
        this.dck.fW(true);
    }

    private int getWindowMeasuredHeight() {
        if (this.mContentView == null) {
            return 0;
        }
        this.mContentView.measure(0, 0);
        this.dcd = this.mContentView.getMeasuredHeight() + l.getDimens(this.mContext, R.dimen.ds12);
        return this.dcd;
    }

    public void setData(aj ajVar) {
        if (ajVar != null) {
            this.dca = ajVar;
            this.dbM = ajVar.getFeedBackReasonMap();
            if (this.dbM != null && this.dbM.size() > 8) {
                for (int size = this.dbM.size() - 1; size >= 8; size--) {
                    this.dbM.removeAt(size);
                }
            }
            this.dck.setData(ajVar);
        }
    }

    public void setDefaultReasonArray(String[] strArr) {
        this.dck.setDefaultReasonArray(strArr);
    }

    public void aBM() {
        if (this.mPopupWindow != null) {
            this.mPopupWindow.dismiss();
            this.mPopupWindow = null;
        }
        if (this.dch != null) {
            this.dch.dismiss();
            this.dch = null;
        }
    }

    private void vg() {
        if (this.dcl && this.dcb.size() != 0) {
            this.dcb.clear();
        }
    }

    private void anM() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            am.setViewTextColor(this.arT, R.color.cp_cont_f, 1);
            am.setViewTextColor(this.dcx, R.color.cp_cont_f, 1);
            am.setBackgroundColor(this.mTopLine, R.color.cp_bg_line_c);
            am.setBackgroundColor(this.dcA, R.color.cp_bg_line_c);
            am.setViewTextColor(this.dcy, R.color.cp_cont_f, 1);
            am.setViewTextColor(this.dcz, R.color.cp_cont_d, 1);
            this.mSkinType = skinType;
        }
    }

    private View getView() {
        if (this.mContext == null) {
            return null;
        }
        if (this.mContentView == null) {
            this.mContentView = (ViewGroup) LayoutInflater.from(this.mContext).inflate(R.layout.neg_dt_head_popupwindow, (ViewGroup) null);
            this.dcy = (TextView) this.mContentView.findViewById(R.id.head_text);
            this.dcz = (TextView) this.mContentView.findViewById(R.id.sub_head_text);
        }
        View rootView = this.dck.getRootView();
        if (rootView != null && rootView.getParent() == null) {
            int dimens = l.getDimens(this.mContext, R.dimen.ds40);
            rootView.setPadding(dimens, 0, dimens, 0);
            this.mContentView.addView(rootView);
        }
        if (this.dct == null) {
            this.dct = (LinearLayout) LayoutInflater.from(this.mContext).inflate(R.layout.neg_dt_bottom_popupwindow, (ViewGroup) null);
            this.arT = (TextView) this.dct.findViewById(R.id.dialog_bottom_cancel_button);
            this.dcx = (TextView) this.dct.findViewById(R.id.dialog_bottom_certain_button);
            this.mTopLine = this.dct.findViewById(R.id.top_line);
            this.dcA = this.dct.findViewById(R.id.middle_line);
            this.mContentView.addView(this.dct);
            this.arT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.NEGFeedBack.e.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (e.this.dch != null) {
                        e.this.dch.dismiss();
                        e.this.dch = null;
                    }
                    if (e.this.mPopupWindow != null) {
                        e.this.mPopupWindow.dismiss();
                        e.this.mPopupWindow = null;
                    }
                    if (e.this.dcv != null) {
                        e.this.dcv.onClick();
                    }
                }
            });
            if (this.dcx != null) {
                this.dcx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.NEGFeedBack.e.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        JSONObject aBR = e.this.aBR();
                        if (e.this.mFrom == "3" || e.this.mFrom == "4" || e.this.mFrom == "1") {
                            e.this.aBM();
                        } else if (aBR != null) {
                            e.this.showLoadingView();
                            CustomMessage customMessage = new CustomMessage(2016489, e.this.mPageContext.getUniqueId());
                            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2016489, aBR);
                            customResponsedMessage.setOrginalMessage(customMessage);
                            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                        }
                    }
                });
            }
            anM();
        }
        return this.mContentView;
    }

    public void a(b bVar) {
        this.dcw = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLoadingView() {
        if (this.cNJ == null) {
            this.cNJ = new com.baidu.tbadk.core.view.b(this.mPageContext);
        }
        this.cNJ.setTipString(R.string.loading);
        this.cNJ.setDialogVisiable(true);
    }

    public void aBQ() {
        if (this.cNJ != null) {
            this.cNJ.setDialogVisiable(false);
        }
    }

    public void qE(String str) {
        if (this.mContext != null) {
            this.mFrom = str;
            View view = getView();
            if (view != null && view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            anM();
            this.mWindowHeight = getWindowMeasuredHeight() - l.getDimens(this.mContext, R.dimen.ds12);
            this.mPopupWindow = new PopupWindow(view, this.dcc, this.mWindowHeight);
            this.mPopupWindow.setFocusable(true);
            this.mPopupWindow.setTouchable(true);
            this.mPopupWindow.setOnDismissListener(this.dco);
            vg();
            this.dch = new PopupWindow(LayoutInflater.from(this.mContext).inflate(R.layout.view_negative_feedback_bottom, (ViewGroup) null), -1, -1);
            if (Build.VERSION.SDK_INT >= 22) {
                this.dch.setAttachedInDecor(false);
            }
            this.dch.showAtLocation(this.mAnchor, 0, 0, 0);
            am.setBackgroundDrawable(this.mPopupWindow, R.drawable.bg_dailog);
            this.mPopupWindow.showAtLocation(this.mAnchor, 17, 0, 0);
            if (this.dcg != null) {
                this.dcg.b(this.dca);
            }
            this.dcl = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject aBR() {
        int i;
        JSONObject jSONObject = new JSONObject();
        if (this.dca == null) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        if (v.isEmpty(this.dcb)) {
            i = 0;
        } else {
            i = 0;
            for (int i2 = 0; i2 < this.dcb.size(); i2++) {
                b.a aVar = this.dcb.get(i2);
                if (aVar != null) {
                    jSONArray.put(String.valueOf(aVar.id));
                    i = aVar.index + 1;
                }
            }
        }
        TiebaStatic.log(new an("c13123").bS("obj_source", this.mFrom).O("obj_type", i));
        if (this.dcw != null) {
            this.dcw.K(jSONArray);
        }
        try {
            jSONObject.put(TiebaInitialize.LogFields.REASON, jSONArray);
            jSONObject.put("thread_ids", this.dca.ahq());
            jSONObject.put("type", this.dca.ahp());
            jSONObject.put("forum_id", this.dca.getFid());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
