package com.baidu.tieba.d;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.bh;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
/* loaded from: classes21.dex */
public class g {
    private by alu;
    private com.baidu.tbadk.coreExtra.model.a eTC;
    private int fWA;
    private PopupWindow fWD;
    private TextView fWE;
    private TBSpecificationBtn fWF;
    private com.baidu.tbadk.core.view.commonBtn.b fWG;
    private int fWy;
    private int fWz;
    private View mAnchor;
    private ViewGroup mContentView;
    private TbPageContext mPageContext;
    private PopupWindow mPopupWindow;
    private int mWindowHeight;
    private int mWindowWidth;
    private int mXOffset;
    private int mYOffset;
    private int mSkinType = 3;
    private PopupWindow.OnDismissListener mOnDismissListener = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.d.g.1
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (g.this.fWD != null) {
                g.this.fWD.dismiss();
                g.this.fWD = null;
            }
        }
    };
    private View.OnClickListener iqc = new View.OnClickListener() { // from class: com.baidu.tieba.d.g.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.isNetworkAvailableForImmediately()) {
                g.this.mPageContext.showToast(R.string.network_ungeilivable);
            }
            if (bh.checkUpIsLogin(g.this.mPageContext.getPageActivity())) {
                if (g.this.alu != null) {
                    g.this.eTC.a(false, g.this.alu.boP().getPortrait(), g.this.alu.boP().getUserId(), g.this.alu.boP().isGod(), "0", g.this.mPageContext.getUniqueId(), null, "0");
                    TiebaStatic.log(new ar("c13571"));
                } else {
                    return;
                }
            }
            if (g.this.fWD != null && g.this.mPopupWindow != null) {
                g.this.fWD.dismiss();
                g.this.mPopupWindow.dismiss();
                g.this.mPopupWindow = null;
                g.this.fWD = null;
            }
        }
    };

    public g(TbPageContext tbPageContext, View view) {
        this.mPageContext = tbPageContext;
        this.eTC = new com.baidu.tbadk.coreExtra.model.a(tbPageContext);
        this.mAnchor = view;
        cts();
    }

    public void r(by byVar) {
        this.alu = byVar;
    }

    private void cts() {
        this.fWA = l.getDimens(this.mPageContext.getContext(), R.dimen.M_W_X005);
        this.mXOffset = com.baidu.tbadk.a.d.bkA() ? l.getDimens(this.mPageContext.getContext(), R.dimen.M_W_X007) : l.getDimens(this.mPageContext.getContext(), R.dimen.M_W_X004);
        this.mYOffset = l.getDimens(this.mPageContext.getContext(), R.dimen.tbds14);
        this.fWz = l.getDimens(this.mPageContext.getContext(), R.dimen.tbds160);
    }

    private View getContentView() {
        if (this.mPageContext.getContext() == null) {
            return null;
        }
        if (this.mContentView == null) {
            this.mContentView = (ViewGroup) LayoutInflater.from(this.mPageContext.getContext()).inflate(R.layout.neg_feedback_popupwindow, (ViewGroup) null);
            this.fWE = (TextView) this.mContentView.findViewById(R.id.head_text);
            this.fWE.setText(this.mPageContext.getString(R.string.confirm_unlike));
            ap.setViewTextColor(this.fWE, R.color.CAM_X0105, 1);
            this.fWF = (TBSpecificationBtn) this.mContentView.findViewById(R.id.uninterested_btn);
            this.fWF.setText(this.mPageContext.getString(R.string.confirm_unlike_confirm));
            this.fWF.setTextSize(R.dimen.T_X08);
            this.fWF.setOnClickListener(this.iqc);
            this.fWG = new com.baidu.tbadk.core.view.commonBtn.b();
            this.fWG.rh(R.color.CAM_X0304);
            this.fWF.setConfig(this.fWG);
            this.mContentView.setPadding(this.fWA, 0, this.fWA, 0);
        }
        bvt();
        return this.mContentView;
    }

    public void ctt() {
        if (this.mPageContext.getContext() != null) {
            View contentView = getContentView();
            this.mWindowWidth = l.getEquipmentWidth(this.mPageContext.getContext()) - (this.mXOffset * 2);
            this.mWindowHeight = getWindowMeasuredHeight();
            int[] iArr = new int[2];
            boolean a2 = a(this.mPageContext.getContext(), this.mAnchor, this.mWindowHeight, this.mWindowWidth, this.fWz, this.mYOffset, iArr);
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(0);
            gradientDrawable.setColor(ap.getColor(R.color.CAM_X0204));
            gradientDrawable.setCornerRadius(l.getDimens(this.mPageContext.getContext(), R.dimen.tbds31));
            contentView.setBackgroundDrawable(gradientDrawable);
            this.mPopupWindow = new PopupWindow(contentView, this.mWindowWidth, getWindowMeasuredHeight());
            this.mPopupWindow.setFocusable(true);
            this.mPopupWindow.setTouchable(true);
            this.mPopupWindow.setOnDismissListener(this.mOnDismissListener);
            this.fWD = new PopupWindow(LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.view_negative_feedback_bottom, (ViewGroup) null), -1, -1);
            if (Build.VERSION.SDK_INT >= 22) {
                this.fWD.setAttachedInDecor(false);
            }
            this.fWD.showAtLocation(this.mAnchor, 0, 0, 0);
            if (iArr[0] != 0 || iArr[1] != 0) {
                this.mPopupWindow.setBackgroundDrawable(new ColorDrawable(0));
                if (a2) {
                    this.mPopupWindow.setAnimationStyle(R.style.scale_rb2lt_anim);
                } else {
                    this.mPopupWindow.setAnimationStyle(R.style.scale_rt2lb_anim);
                }
                this.mPopupWindow.showAtLocation(this.mAnchor, 0, iArr[0] - this.mXOffset, iArr[1]);
            }
        }
    }

    private int getWindowMeasuredHeight() {
        if (this.mContentView == null) {
            return 0;
        }
        this.mContentView.measure(0, 0);
        this.fWy = this.mContentView.getMeasuredHeight();
        return this.fWy;
    }

    private boolean a(Context context, View view, int i, int i2, int i3, int i4, int[] iArr) {
        if (context == null || view == null || iArr == null || iArr.length != 2) {
            return false;
        }
        int[] iArr2 = new int[2];
        view.getLocationOnScreen(iArr2);
        int height = view.getHeight();
        int equipmentHeight = l.getEquipmentHeight(context);
        int equipmentWidth = l.getEquipmentWidth(context);
        boolean z = ((equipmentHeight - iArr2[1]) - height) - i3 < i;
        iArr[0] = equipmentWidth - i2;
        if (z) {
            iArr[1] = (iArr2[1] - i) - i4;
            iArr[1] = Math.max(UtilHelper.getStatusBarHeight(), iArr[1]);
            return z;
        }
        iArr[1] = iArr2[1] + height + i4;
        return z;
    }

    private void bvt() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            ap.setViewTextColor(this.fWE, R.color.CAM_X0105, 1);
            this.mSkinType = skinType;
        }
    }
}
