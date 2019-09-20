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
    private long cTr;
    c cTs;
    private RotateAnimation cTt;
    private RotateAnimation cTu;
    private View.OnClickListener cTv;
    private int cvR;
    private int cvS;
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
        this.cTr = 0L;
        this.cTv = new View.OnClickListener() { // from class: com.baidu.tieba.NEGFeedBack.NEGFeedBackView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                NEGFeedBackView.this.aBD();
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - NEGFeedBackView.this.cTr > 500) {
                    NEGFeedBackView.this.bo(view);
                }
                NEGFeedBackView.this.cTr = currentTimeMillis;
            }
        };
        this.mContext = tbPageContext.getPageActivity();
        g(tbPageContext);
    }

    private void g(TbPageContext tbPageContext) {
        this.cTs = new c(tbPageContext, this);
        setOnClickListener(this.cTv);
        am.c(this, (int) R.drawable.icon_home_card_delete);
        setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        aBE();
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.cTs.setUniqueId(bdUniqueId);
    }

    public void setDefaultLayout() {
        onChangeSkinType();
    }

    public void setLeftPadding(int i) {
        this.cvR = i;
        setPadding(i, this.mPaddingTop, this.cvS, 0);
    }

    public void setTopPadding(int i) {
        this.mPaddingTop = i;
        setPadding(this.cvR, i, this.cvS, 0);
    }

    public void setRightPadding(int i) {
        this.cvS = i;
        setPadding(this.cvR, this.mPaddingTop, i, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bo(View view) {
        this.cTs.bo(view);
    }

    public void aBD() {
        this.cTs.aBD();
    }

    private void aBE() {
        this.cTt = new RotateAnimation(0.0f, 135.0f, 1, 0.5f, 1, 0.5f);
        OvershootInterpolator overshootInterpolator = new OvershootInterpolator();
        this.cTt.setInterpolator(overshootInterpolator);
        this.cTt.setDuration(250L);
        this.cTt.setFillAfter(true);
        this.cTu = new RotateAnimation(135.0f, 0.0f, 1, 0.5f, 1, 0.5f);
        this.cTu.setInterpolator(overshootInterpolator);
        this.cTu.setDuration(250L);
        this.cTu.setFillAfter(true);
    }

    public void setCWRotateAnimation() {
        clearAnimation();
        startAnimation(this.cTt);
    }

    public void setACRotateAnimation() {
        clearAnimation();
        startAnimation(this.cTu);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.cTs.onDetachedFromWindow();
    }

    public void setData(aj ajVar) {
        this.cTs.setData(ajVar);
    }

    public void setFirstRowSingleColumn(boolean z) {
        this.cTs.setFirstRowSingleColumn(z);
    }

    public void onChangeSkinType() {
        SvgManager.ajv().a(this, R.drawable.icon_pure_close16_n_svg, R.color.cp_cont_d, null);
    }

    public void setEventCallback(a aVar) {
        this.cTs.setEventCallback(aVar);
    }

    public void setDefaultReasonArray(String[] strArr) {
        this.cTs.setDefaultReasonArray(strArr);
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
