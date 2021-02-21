package com.baidu.tieba.c;

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
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.bh;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class g {
    private cb akU;
    private com.baidu.tbadk.coreExtra.model.a faF;
    private int gdP;
    private int gdQ;
    private int gdR;
    private PopupWindow gdU;
    private TextView gdV;
    private TBSpecificationBtn gdW;
    private com.baidu.tbadk.core.view.commonBtn.b gdX;
    private View mAnchor;
    private ViewGroup mContentView;
    private TbPageContext mPageContext;
    private PopupWindow mPopupWindow;
    private int mWindowHeight;
    private int mWindowWidth;
    private int mXOffset;
    private int mYOffset;
    private int mSkinType = 3;
    private PopupWindow.OnDismissListener mOnDismissListener = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.c.g.1
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (g.this.gdU != null) {
                g.this.gdU.dismiss();
                g.this.gdU = null;
            }
        }
    };
    private View.OnClickListener iDN = new View.OnClickListener() { // from class: com.baidu.tieba.c.g.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.isNetworkAvailableForImmediately()) {
                g.this.mPageContext.showToast(R.string.network_ungeilivable);
            }
            if (bh.checkUpIsLogin(g.this.mPageContext.getPageActivity())) {
                if (g.this.akU != null) {
                    g.this.faF.a(false, g.this.akU.bnQ().getPortrait(), g.this.akU.bnQ().getUserId(), g.this.akU.bnQ().isGod(), "0", g.this.mPageContext.getUniqueId(), null, "0");
                    TiebaStatic.log(new ar("c13571"));
                } else {
                    return;
                }
            }
            if (g.this.gdU != null && g.this.mPopupWindow != null) {
                g.this.gdU.dismiss();
                g.this.mPopupWindow.dismiss();
                g.this.mPopupWindow = null;
                g.this.gdU = null;
            }
        }
    };

    public g(TbPageContext tbPageContext, View view) {
        this.mPageContext = tbPageContext;
        this.faF = new com.baidu.tbadk.coreExtra.model.a(tbPageContext);
        this.mAnchor = view;
        ctN();
    }

    public void r(cb cbVar) {
        this.akU = cbVar;
    }

    private void ctN() {
        this.gdR = l.getDimens(this.mPageContext.getContext(), R.dimen.M_W_X005);
        this.mXOffset = l.getDimens(this.mPageContext.getContext(), R.dimen.M_W_X004);
        this.mYOffset = l.getDimens(this.mPageContext.getContext(), R.dimen.tbds14);
        this.gdQ = l.getDimens(this.mPageContext.getContext(), R.dimen.tbds160);
    }

    private View getContentView() {
        if (this.mPageContext.getContext() == null) {
            return null;
        }
        if (this.mContentView == null) {
            this.mContentView = (ViewGroup) LayoutInflater.from(this.mPageContext.getContext()).inflate(R.layout.neg_feedback_popupwindow, (ViewGroup) null);
            this.gdV = (TextView) this.mContentView.findViewById(R.id.head_text);
            this.gdV.setText(this.mPageContext.getString(R.string.confirm_unlike));
            ap.setViewTextColor(this.gdV, R.color.CAM_X0105, 1);
            this.gdW = (TBSpecificationBtn) this.mContentView.findViewById(R.id.uninterested_btn);
            this.gdW.setText(this.mPageContext.getString(R.string.confirm_unlike_confirm));
            this.gdW.setTextSize(R.dimen.T_X08);
            this.gdW.setOnClickListener(this.iDN);
            this.gdX = new com.baidu.tbadk.core.view.commonBtn.b();
            this.gdX.pR(R.color.CAM_X0304);
            this.gdW.setConfig(this.gdX);
            this.mContentView.setPadding(this.gdR, 0, this.gdR, 0);
        }
        bup();
        return this.mContentView;
    }

    public void ctO() {
        if (this.mPageContext.getContext() != null) {
            View contentView = getContentView();
            this.mWindowWidth = l.getEquipmentWidth(this.mPageContext.getContext()) - (this.mXOffset * 2);
            this.mWindowHeight = getWindowMeasuredHeight();
            int[] iArr = new int[2];
            boolean a2 = a(this.mPageContext.getContext(), this.mAnchor, this.mWindowHeight, this.mWindowWidth, this.gdQ, this.mYOffset, iArr);
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(0);
            gradientDrawable.setColor(ap.getColor(R.color.CAM_X0204));
            gradientDrawable.setCornerRadius(l.getDimens(this.mPageContext.getContext(), R.dimen.tbds31));
            contentView.setBackgroundDrawable(gradientDrawable);
            this.mPopupWindow = new PopupWindow(contentView, this.mWindowWidth, getWindowMeasuredHeight());
            this.mPopupWindow.setFocusable(true);
            this.mPopupWindow.setTouchable(true);
            this.mPopupWindow.setOnDismissListener(this.mOnDismissListener);
            this.gdU = new PopupWindow(LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.view_negative_feedback_bottom, (ViewGroup) null), -1, -1);
            if (Build.VERSION.SDK_INT >= 22) {
                this.gdU.setAttachedInDecor(false);
            }
            this.gdU.showAtLocation(this.mAnchor, 0, 0, 0);
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
        this.gdP = this.mContentView.getMeasuredHeight();
        return this.gdP;
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

    private void bup() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            ap.setViewTextColor(this.gdV, R.color.CAM_X0105, 1);
            this.mSkinType = skinType;
        }
    }
}
