package com.baidu.tieba.NEGFeedBack;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.OvershootInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.aj;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class NEGFeedBackView extends ImageView {
    private long cIH;
    c cII;
    private RotateAnimation cIJ;
    private RotateAnimation cIK;
    private View.OnClickListener cIL;
    private int cln;
    private int clo;
    private Context mContext;
    private int mPaddingTop;

    /* loaded from: classes3.dex */
    public interface a {
        void a(aj ajVar, CompoundButton compoundButton, boolean z);

        void a(ArrayList<Integer> arrayList, String str, aj ajVar);

        void b(aj ajVar);
    }

    public NEGFeedBackView(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.mContext = null;
        this.cIH = 0L;
        this.cIL = new View.OnClickListener() { // from class: com.baidu.tieba.NEGFeedBack.NEGFeedBackView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                NEGFeedBackView.this.auU();
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - NEGFeedBackView.this.cIH > 500) {
                    NEGFeedBackView.this.bg(view);
                }
                NEGFeedBackView.this.cIH = currentTimeMillis;
            }
        };
        this.mContext = tbPageContext.getPageActivity();
        g(tbPageContext);
    }

    private void g(TbPageContext tbPageContext) {
        this.cII = new c(tbPageContext, this);
        setOnClickListener(this.cIL);
        al.c(this, d.f.icon_home_card_delete);
        setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        auV();
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.cII.setUniqueId(bdUniqueId);
    }

    public void setDefaultLayout() {
        onChangeSkinType();
    }

    public void setLeftPadding(int i) {
        this.cln = i;
        setPadding(i, this.mPaddingTop, this.clo, 0);
    }

    public void setTopPadding(int i) {
        this.mPaddingTop = i;
        setPadding(this.cln, i, this.clo, 0);
    }

    public void setRightPadding(int i) {
        this.clo = i;
        setPadding(this.cln, this.mPaddingTop, i, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bg(View view) {
        this.cII.bg(view);
    }

    public void auU() {
        this.cII.auU();
    }

    private void auV() {
        this.cIJ = new RotateAnimation(0.0f, 135.0f, 1, 0.5f, 1, 0.5f);
        OvershootInterpolator overshootInterpolator = new OvershootInterpolator();
        this.cIJ.setInterpolator(overshootInterpolator);
        this.cIJ.setDuration(250L);
        this.cIJ.setFillAfter(true);
        this.cIK = new RotateAnimation(135.0f, 0.0f, 1, 0.5f, 1, 0.5f);
        this.cIK.setInterpolator(overshootInterpolator);
        this.cIK.setDuration(250L);
        this.cIK.setFillAfter(true);
    }

    public void setCWRotateAnimation() {
        clearAnimation();
        startAnimation(this.cIJ);
    }

    public void setACRotateAnimation() {
        clearAnimation();
        startAnimation(this.cIK);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.cII.onDetachedFromWindow();
    }

    public void setData(aj ajVar) {
        this.cII.setData(ajVar);
    }

    public void setFirstRowSingleColumn(boolean z) {
        this.cII.setFirstRowSingleColumn(z);
    }

    public void onChangeSkinType() {
        al.c(this, d.f.icon_home_card_delete);
    }

    public void setEventCallback(a aVar) {
        this.cII.setEventCallback(aVar);
    }

    public void setDefaultReasonArray(String[] strArr) {
        this.cII.setDefaultReasonArray(strArr);
    }

    public void a(ViewGroup viewGroup, int i, int i2) {
        setPadding(0, i2, i2, 0);
        if (viewGroup instanceof RelativeLayout) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i, i);
            layoutParams.addRule(11);
            viewGroup.addView(this, layoutParams);
        } else if (viewGroup instanceof FrameLayout) {
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(i, i);
            layoutParams2.gravity = 53;
            viewGroup.addView(this, layoutParams2);
        }
    }

    public void a(ViewGroup viewGroup, int i, int i2, int i3, int i4) {
        setPadding(0, i2, i2, 0);
        if (viewGroup instanceof RelativeLayout) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i, i);
            layoutParams.addRule(11);
            viewGroup.addView(this, layoutParams);
        } else if (viewGroup instanceof FrameLayout) {
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(i, i);
            layoutParams2.topMargin = i3;
            layoutParams2.rightMargin = i4;
            layoutParams2.gravity = 53;
            viewGroup.addView(this, layoutParams2);
        }
    }
}
