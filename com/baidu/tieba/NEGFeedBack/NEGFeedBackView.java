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
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.aj;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class NEGFeedBackView extends ImageView {
    private long cQU;
    c cQV;
    private RotateAnimation cQW;
    private RotateAnimation cQX;
    private View.OnClickListener cQY;
    private int cty;
    private int ctz;
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
        this.cQU = 0L;
        this.cQY = new View.OnClickListener() { // from class: com.baidu.tieba.NEGFeedBack.NEGFeedBackView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                NEGFeedBackView.this.azZ();
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - NEGFeedBackView.this.cQU > 500) {
                    NEGFeedBackView.this.bm(view);
                }
                NEGFeedBackView.this.cQU = currentTimeMillis;
            }
        };
        this.mContext = tbPageContext.getPageActivity();
        g(tbPageContext);
    }

    private void g(TbPageContext tbPageContext) {
        this.cQV = new c(tbPageContext, this);
        setOnClickListener(this.cQY);
        al.c(this, (int) R.drawable.icon_home_card_delete);
        setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        aAa();
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.cQV.setUniqueId(bdUniqueId);
    }

    public void setDefaultLayout() {
        onChangeSkinType();
    }

    public void setLeftPadding(int i) {
        this.cty = i;
        setPadding(i, this.mPaddingTop, this.ctz, 0);
    }

    public void setTopPadding(int i) {
        this.mPaddingTop = i;
        setPadding(this.cty, i, this.ctz, 0);
    }

    public void setRightPadding(int i) {
        this.ctz = i;
        setPadding(this.cty, this.mPaddingTop, i, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bm(View view) {
        this.cQV.bm(view);
    }

    public void azZ() {
        this.cQV.azZ();
    }

    private void aAa() {
        this.cQW = new RotateAnimation(0.0f, 135.0f, 1, 0.5f, 1, 0.5f);
        OvershootInterpolator overshootInterpolator = new OvershootInterpolator();
        this.cQW.setInterpolator(overshootInterpolator);
        this.cQW.setDuration(250L);
        this.cQW.setFillAfter(true);
        this.cQX = new RotateAnimation(135.0f, 0.0f, 1, 0.5f, 1, 0.5f);
        this.cQX.setInterpolator(overshootInterpolator);
        this.cQX.setDuration(250L);
        this.cQX.setFillAfter(true);
    }

    public void setCWRotateAnimation() {
        clearAnimation();
        startAnimation(this.cQW);
    }

    public void setACRotateAnimation() {
        clearAnimation();
        startAnimation(this.cQX);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.cQV.onDetachedFromWindow();
    }

    public void setData(aj ajVar) {
        this.cQV.setData(ajVar);
    }

    public void setFirstRowSingleColumn(boolean z) {
        this.cQV.setFirstRowSingleColumn(z);
    }

    public void onChangeSkinType() {
        al.c(this, (int) R.drawable.icon_home_card_delete);
    }

    public void setEventCallback(a aVar) {
        this.cQV.setEventCallback(aVar);
    }

    public void setDefaultReasonArray(String[] strArr) {
        this.cQV.setDefaultReasonArray(strArr);
    }

    public void a(ViewGroup viewGroup, int i, int i2) {
        setPadding(0, i2, i2, 0);
        if (viewGroup instanceof RelativeLayout) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(11);
            layoutParams.addRule(15);
            viewGroup.addView(this, layoutParams);
        } else if (viewGroup instanceof FrameLayout) {
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(i, i);
            layoutParams2.gravity = 53;
            viewGroup.addView(this, layoutParams2);
        }
    }

    public void b(ViewGroup viewGroup, int i, int i2) {
        int g = l.g(this.mContext, R.dimen.tbds24);
        setPadding(i2, 0, i2, 0);
        if (viewGroup instanceof RelativeLayout) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, i);
            layoutParams.addRule(11);
            layoutParams.addRule(15);
            layoutParams.rightMargin = g;
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
