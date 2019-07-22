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
    private long cSr;
    c cSs;
    private RotateAnimation cSt;
    private RotateAnimation cSu;
    private View.OnClickListener cSv;
    private int cuO;
    private int cuP;
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
        this.cSr = 0L;
        this.cSv = new View.OnClickListener() { // from class: com.baidu.tieba.NEGFeedBack.NEGFeedBackView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                NEGFeedBackView.this.aBn();
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - NEGFeedBackView.this.cSr > 500) {
                    NEGFeedBackView.this.bo(view);
                }
                NEGFeedBackView.this.cSr = currentTimeMillis;
            }
        };
        this.mContext = tbPageContext.getPageActivity();
        g(tbPageContext);
    }

    private void g(TbPageContext tbPageContext) {
        this.cSs = new c(tbPageContext, this);
        setOnClickListener(this.cSv);
        am.c(this, (int) R.drawable.icon_home_card_delete);
        setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        aBo();
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.cSs.setUniqueId(bdUniqueId);
    }

    public void setDefaultLayout() {
        onChangeSkinType();
    }

    public void setLeftPadding(int i) {
        this.cuO = i;
        setPadding(i, this.mPaddingTop, this.cuP, 0);
    }

    public void setTopPadding(int i) {
        this.mPaddingTop = i;
        setPadding(this.cuO, i, this.cuP, 0);
    }

    public void setRightPadding(int i) {
        this.cuP = i;
        setPadding(this.cuO, this.mPaddingTop, i, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bo(View view) {
        this.cSs.bo(view);
    }

    public void aBn() {
        this.cSs.aBn();
    }

    private void aBo() {
        this.cSt = new RotateAnimation(0.0f, 135.0f, 1, 0.5f, 1, 0.5f);
        OvershootInterpolator overshootInterpolator = new OvershootInterpolator();
        this.cSt.setInterpolator(overshootInterpolator);
        this.cSt.setDuration(250L);
        this.cSt.setFillAfter(true);
        this.cSu = new RotateAnimation(135.0f, 0.0f, 1, 0.5f, 1, 0.5f);
        this.cSu.setInterpolator(overshootInterpolator);
        this.cSu.setDuration(250L);
        this.cSu.setFillAfter(true);
    }

    public void setCWRotateAnimation() {
        clearAnimation();
        startAnimation(this.cSt);
    }

    public void setACRotateAnimation() {
        clearAnimation();
        startAnimation(this.cSu);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.cSs.onDetachedFromWindow();
    }

    public void setData(aj ajVar) {
        this.cSs.setData(ajVar);
    }

    public void setFirstRowSingleColumn(boolean z) {
        this.cSs.setFirstRowSingleColumn(z);
    }

    public void onChangeSkinType() {
        am.c(this, (int) R.drawable.icon_home_card_delete);
    }

    public void setEventCallback(a aVar) {
        this.cSs.setEventCallback(aVar);
    }

    public void setDefaultReasonArray(String[] strArr) {
        this.cSs.setDefaultReasonArray(strArr);
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
