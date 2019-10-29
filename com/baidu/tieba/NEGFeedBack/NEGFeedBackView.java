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
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class NEGFeedBackView extends ImageView {
    private int cIa;
    private int cIb;
    private long dcM;
    c dcN;
    private RotateAnimation dcO;
    private RotateAnimation dcP;
    private View.OnClickListener dcQ;
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
        this.dcM = 0L;
        this.dcQ = new View.OnClickListener() { // from class: com.baidu.tieba.NEGFeedBack.NEGFeedBackView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                NEGFeedBackView.this.aBO();
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - NEGFeedBackView.this.dcM > 500) {
                    NEGFeedBackView.this.O(view);
                }
                NEGFeedBackView.this.dcM = currentTimeMillis;
            }
        };
        this.mContext = tbPageContext.getPageActivity();
        g(tbPageContext);
    }

    private void g(TbPageContext tbPageContext) {
        this.dcN = new c(tbPageContext, this);
        setOnClickListener(this.dcQ);
        am.setImageResource(this, R.drawable.icon_home_card_delete);
        setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        aBP();
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.dcN.setUniqueId(bdUniqueId);
    }

    public void setDefaultLayout() {
        onChangeSkinType();
    }

    public void setLeftPadding(int i) {
        this.cIa = i;
        setPadding(i, this.mPaddingTop, this.cIb, 0);
    }

    public void setTopPadding(int i) {
        this.mPaddingTop = i;
        setPadding(this.cIa, i, this.cIb, 0);
    }

    public void setRightPadding(int i) {
        this.cIb = i;
        setPadding(this.cIa, this.mPaddingTop, i, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O(View view) {
        this.dcN.O(view);
    }

    public void aBO() {
        this.dcN.aBO();
    }

    private void aBP() {
        this.dcO = new RotateAnimation(0.0f, 135.0f, 1, 0.5f, 1, 0.5f);
        OvershootInterpolator overshootInterpolator = new OvershootInterpolator();
        this.dcO.setInterpolator(overshootInterpolator);
        this.dcO.setDuration(250L);
        this.dcO.setFillAfter(true);
        this.dcP = new RotateAnimation(135.0f, 0.0f, 1, 0.5f, 1, 0.5f);
        this.dcP.setInterpolator(overshootInterpolator);
        this.dcP.setDuration(250L);
        this.dcP.setFillAfter(true);
    }

    public void setCWRotateAnimation() {
        clearAnimation();
        startAnimation(this.dcO);
    }

    public void setACRotateAnimation() {
        clearAnimation();
        startAnimation(this.dcP);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.dcN.onDetachedFromWindow();
    }

    public void setData(aj ajVar) {
        this.dcN.setData(ajVar);
    }

    public void setFirstRowSingleColumn(boolean z) {
        this.dcN.setFirstRowSingleColumn(z);
    }

    public void onChangeSkinType() {
        SvgManager.amN().a(this, R.drawable.icon_pure_close16_n_svg, R.color.cp_cont_d, null);
    }

    public void setEventCallback(a aVar) {
        this.dcN.setEventCallback(aVar);
    }

    public void setDefaultReasonArray(String[] strArr) {
        this.dcN.setDefaultReasonArray(strArr);
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
        int dimens = l.getDimens(this.mContext, R.dimen.tbds24);
        setPadding(i2, 0, i2, 0);
        if (viewGroup instanceof RelativeLayout) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, i);
            layoutParams.addRule(11);
            layoutParams.addRule(15);
            layoutParams.rightMargin = dimens;
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
