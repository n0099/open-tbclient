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
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class g {
    private bz ale;
    private com.baidu.tbadk.coreExtra.model.a eYq;
    private PopupWindow gbA;
    private TextView gbB;
    private TBSpecificationBtn gbC;
    private com.baidu.tbadk.core.view.commonBtn.b gbD;
    private int gbv;
    private int gbw;
    private int gbx;
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
            if (g.this.gbA != null) {
                g.this.gbA.dismiss();
                g.this.gbA = null;
            }
        }
    };
    private View.OnClickListener ixP = new View.OnClickListener() { // from class: com.baidu.tieba.c.g.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.isNetworkAvailableForImmediately()) {
                g.this.mPageContext.showToast(R.string.network_ungeilivable);
            }
            if (bg.checkUpIsLogin(g.this.mPageContext.getPageActivity())) {
                if (g.this.ale != null) {
                    g.this.eYq.a(false, g.this.ale.bnx().getPortrait(), g.this.ale.bnx().getUserId(), g.this.ale.bnx().isGod(), "0", g.this.mPageContext.getUniqueId(), null, "0");
                    TiebaStatic.log(new aq("c13571"));
                } else {
                    return;
                }
            }
            if (g.this.gbA != null && g.this.mPopupWindow != null) {
                g.this.gbA.dismiss();
                g.this.mPopupWindow.dismiss();
                g.this.mPopupWindow = null;
                g.this.gbA = null;
            }
        }
    };

    public g(TbPageContext tbPageContext, View view) {
        this.mPageContext = tbPageContext;
        this.eYq = new com.baidu.tbadk.coreExtra.model.a(tbPageContext);
        this.mAnchor = view;
        csu();
    }

    public void r(bz bzVar) {
        this.ale = bzVar;
    }

    private void csu() {
        this.gbx = l.getDimens(this.mPageContext.getContext(), R.dimen.M_W_X005);
        this.mXOffset = l.getDimens(this.mPageContext.getContext(), R.dimen.M_W_X004);
        this.mYOffset = l.getDimens(this.mPageContext.getContext(), R.dimen.tbds14);
        this.gbw = l.getDimens(this.mPageContext.getContext(), R.dimen.tbds160);
    }

    private View getContentView() {
        if (this.mPageContext.getContext() == null) {
            return null;
        }
        if (this.mContentView == null) {
            this.mContentView = (ViewGroup) LayoutInflater.from(this.mPageContext.getContext()).inflate(R.layout.neg_feedback_popupwindow, (ViewGroup) null);
            this.gbB = (TextView) this.mContentView.findViewById(R.id.head_text);
            this.gbB.setText(this.mPageContext.getString(R.string.confirm_unlike));
            ao.setViewTextColor(this.gbB, R.color.CAM_X0105, 1);
            this.gbC = (TBSpecificationBtn) this.mContentView.findViewById(R.id.uninterested_btn);
            this.gbC.setText(this.mPageContext.getString(R.string.confirm_unlike_confirm));
            this.gbC.setTextSize(R.dimen.T_X08);
            this.gbC.setOnClickListener(this.ixP);
            this.gbD = new com.baidu.tbadk.core.view.commonBtn.b();
            this.gbD.pM(R.color.CAM_X0304);
            this.gbC.setConfig(this.gbD);
            this.mContentView.setPadding(this.gbx, 0, this.gbx, 0);
        }
        btV();
        return this.mContentView;
    }

    public void csv() {
        if (this.mPageContext.getContext() != null) {
            View contentView = getContentView();
            this.mWindowWidth = l.getEquipmentWidth(this.mPageContext.getContext()) - (this.mXOffset * 2);
            this.mWindowHeight = getWindowMeasuredHeight();
            int[] iArr = new int[2];
            boolean a2 = a(this.mPageContext.getContext(), this.mAnchor, this.mWindowHeight, this.mWindowWidth, this.gbw, this.mYOffset, iArr);
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(0);
            gradientDrawable.setColor(ao.getColor(R.color.CAM_X0204));
            gradientDrawable.setCornerRadius(l.getDimens(this.mPageContext.getContext(), R.dimen.tbds31));
            contentView.setBackgroundDrawable(gradientDrawable);
            this.mPopupWindow = new PopupWindow(contentView, this.mWindowWidth, getWindowMeasuredHeight());
            this.mPopupWindow.setFocusable(true);
            this.mPopupWindow.setTouchable(true);
            this.mPopupWindow.setOnDismissListener(this.mOnDismissListener);
            this.gbA = new PopupWindow(LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.view_negative_feedback_bottom, (ViewGroup) null), -1, -1);
            if (Build.VERSION.SDK_INT >= 22) {
                this.gbA.setAttachedInDecor(false);
            }
            this.gbA.showAtLocation(this.mAnchor, 0, 0, 0);
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
        this.gbv = this.mContentView.getMeasuredHeight();
        return this.gbv;
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

    private void btV() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            ao.setViewTextColor(this.gbB, R.color.CAM_X0105, 1);
            this.mSkinType = skinType;
        }
    }
}
