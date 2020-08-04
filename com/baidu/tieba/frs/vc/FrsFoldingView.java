package com.baidu.tieba.frs.vc;

import android.animation.ValueAnimator;
import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes16.dex */
public class FrsFoldingView extends LinearLayout {
    private int ift;
    private boolean ifu;
    private LinearLayout.LayoutParams ifv;
    private LinearLayout ifw;
    private FrameLayout ifx;
    private FrameLayout ify;
    private ImageView ifz;
    private View mRootView;

    public FrsFoldingView(Context context) {
        this(context, null);
    }

    public FrsFoldingView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FrsFoldingView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ift = 0;
        this.ifu = true;
        init();
    }

    private void init() {
        initView();
        ciu();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(getContext()).inflate(R.layout.folding_view_layout, (ViewGroup) this, true);
        this.ifw = (LinearLayout) this.mRootView.findViewById(R.id.folding_root_layout);
        this.ifx = (FrameLayout) this.mRootView.findViewById(R.id.permanent_layout);
        this.ify = (FrameLayout) this.mRootView.findViewById(R.id.collapsible_layout);
        this.ifz = (ImageView) this.mRootView.findViewById(R.id.folding_arrow);
        SvgManager.baR().a(this.ifz, R.drawable.ic_icon_pure_open12_right_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        ao.setBackgroundColor(this.mRootView, R.color.cp_bg_line_e);
    }

    private void ciu() {
        this.mRootView.findViewById(R.id.folding_arrow).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.FrsFoldingView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (FrsFoldingView.this.ifu) {
                    FrsFoldingView.this.civ();
                    FrsFoldingView.this.ifu = false;
                    return;
                }
                FrsFoldingView.this.ciw();
                FrsFoldingView.this.ifu = true;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void civ() {
        this.ifv = (LinearLayout.LayoutParams) this.ify.getLayoutParams();
        final ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.vc.FrsFoldingView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) ofFloat.getAnimatedValue()).floatValue();
                FrsFoldingView.this.ifv.height = (int) (FrsFoldingView.this.ift * floatValue);
                FrsFoldingView.this.ify.setLayoutParams(FrsFoldingView.this.ifv);
                FrsFoldingView.this.ify.setAlpha(floatValue);
                FrsFoldingView.this.ifz.setRotation((-floatValue) * 180.0f);
            }
        });
        ofFloat.setDuration(300L);
        ofFloat.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ciw() {
        this.ifv = (LinearLayout.LayoutParams) this.ify.getLayoutParams();
        final ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.vc.FrsFoldingView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) ofFloat.getAnimatedValue()).floatValue();
                FrsFoldingView.this.ifv.height = (int) (FrsFoldingView.this.ift * floatValue);
                FrsFoldingView.this.ify.setLayoutParams(FrsFoldingView.this.ifv);
                FrsFoldingView.this.ify.setAlpha(floatValue);
                FrsFoldingView.this.ifz.setRotation((-floatValue) * 180.0f);
            }
        });
        ofFloat.setDuration(300L);
        ofFloat.start();
    }

    public void setViews(List<View> list, List<com.baidu.tieba.frs.view.g> list2) {
        if (list == null || list.size() == 0) {
            throw new IllegalArgumentException("com.baidu.tieba.frs.vc.FrsFoldingView setViews(List<View> views) IllegalArgumentException");
        }
        this.ifx.removeAllViews();
        this.ifx.addView(list.get(0));
        if (list.size() > 1) {
            this.ifz.setVisibility(0);
            this.ify.removeAllViews();
            this.ify.addView(list.get(1));
            this.ift = list2.get(1).getCount() * com.baidu.adp.lib.util.l.getDimens(getContext().getApplicationContext(), R.dimen.tbds83);
            return;
        }
        this.ifz.setVisibility(8);
    }

    public void onChangeSkinType() {
        ao.setBackgroundColor(this.mRootView, R.color.cp_bg_line_e);
        SvgManager.baR().a(this.ifz, R.drawable.ic_icon_pure_open12_right_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }
}
