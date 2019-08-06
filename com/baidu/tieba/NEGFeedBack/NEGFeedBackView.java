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
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class NEGFeedBackView extends ImageView {
    private RotateAnimation cSA;
    private RotateAnimation cSB;
    private View.OnClickListener cSC;
    private long cSy;
    c cSz;
    private int cuV;
    private int cuW;
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
        this.cSy = 0L;
        this.cSC = new View.OnClickListener() { // from class: com.baidu.tieba.NEGFeedBack.NEGFeedBackView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                NEGFeedBackView.this.aBp();
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - NEGFeedBackView.this.cSy > 500) {
                    NEGFeedBackView.this.bo(view);
                }
                NEGFeedBackView.this.cSy = currentTimeMillis;
            }
        };
        this.mContext = tbPageContext.getPageActivity();
        g(tbPageContext);
    }

    private void g(TbPageContext tbPageContext) {
        this.cSz = new c(tbPageContext, this);
        setOnClickListener(this.cSC);
        am.c(this, (int) R.drawable.icon_home_card_delete);
        setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        aBq();
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.cSz.setUniqueId(bdUniqueId);
    }

    public void setDefaultLayout() {
        onChangeSkinType();
    }

    public void setLeftPadding(int i) {
        this.cuV = i;
        setPadding(i, this.mPaddingTop, this.cuW, 0);
    }

    public void setTopPadding(int i) {
        this.mPaddingTop = i;
        setPadding(this.cuV, i, this.cuW, 0);
    }

    public void setRightPadding(int i) {
        this.cuW = i;
        setPadding(this.cuV, this.mPaddingTop, i, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bo(View view) {
        this.cSz.bo(view);
    }

    public void aBp() {
        this.cSz.aBp();
    }

    private void aBq() {
        this.cSA = new RotateAnimation(0.0f, 135.0f, 1, 0.5f, 1, 0.5f);
        OvershootInterpolator overshootInterpolator = new OvershootInterpolator();
        this.cSA.setInterpolator(overshootInterpolator);
        this.cSA.setDuration(250L);
        this.cSA.setFillAfter(true);
        this.cSB = new RotateAnimation(135.0f, 0.0f, 1, 0.5f, 1, 0.5f);
        this.cSB.setInterpolator(overshootInterpolator);
        this.cSB.setDuration(250L);
        this.cSB.setFillAfter(true);
    }

    public void setCWRotateAnimation() {
        clearAnimation();
        startAnimation(this.cSA);
    }

    public void setACRotateAnimation() {
        clearAnimation();
        startAnimation(this.cSB);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.cSz.onDetachedFromWindow();
    }

    public void setData(aj ajVar) {
        this.cSz.setData(ajVar);
    }

    public void setFirstRowSingleColumn(boolean z) {
        this.cSz.setFirstRowSingleColumn(z);
    }

    public void onChangeSkinType() {
        am.c(this, (int) R.drawable.icon_home_card_delete);
    }

    public void setEventCallback(a aVar) {
        this.cSz.setEventCallback(aVar);
    }

    public void setDefaultReasonArray(String[] strArr) {
        this.cSz.setDefaultReasonArray(strArr);
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
