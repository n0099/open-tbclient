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
    private int ifr;
    private boolean ifs;
    private LinearLayout.LayoutParams ift;
    private LinearLayout ifu;
    private FrameLayout ifv;
    private FrameLayout ifw;
    private ImageView ifx;
    private View mRootView;

    public FrsFoldingView(Context context) {
        this(context, null);
    }

    public FrsFoldingView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FrsFoldingView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ifr = 0;
        this.ifs = true;
        init();
    }

    private void init() {
        initView();
        ciu();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(getContext()).inflate(R.layout.folding_view_layout, (ViewGroup) this, true);
        this.ifu = (LinearLayout) this.mRootView.findViewById(R.id.folding_root_layout);
        this.ifv = (FrameLayout) this.mRootView.findViewById(R.id.permanent_layout);
        this.ifw = (FrameLayout) this.mRootView.findViewById(R.id.collapsible_layout);
        this.ifx = (ImageView) this.mRootView.findViewById(R.id.folding_arrow);
        SvgManager.baR().a(this.ifx, R.drawable.ic_icon_pure_open12_right_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        ao.setBackgroundColor(this.mRootView, R.color.cp_bg_line_e);
    }

    private void ciu() {
        this.mRootView.findViewById(R.id.folding_arrow).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.FrsFoldingView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (FrsFoldingView.this.ifs) {
                    FrsFoldingView.this.civ();
                    FrsFoldingView.this.ifs = false;
                    return;
                }
                FrsFoldingView.this.ciw();
                FrsFoldingView.this.ifs = true;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void civ() {
        this.ift = (LinearLayout.LayoutParams) this.ifw.getLayoutParams();
        final ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.vc.FrsFoldingView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) ofFloat.getAnimatedValue()).floatValue();
                FrsFoldingView.this.ift.height = (int) (FrsFoldingView.this.ifr * floatValue);
                FrsFoldingView.this.ifw.setLayoutParams(FrsFoldingView.this.ift);
                FrsFoldingView.this.ifw.setAlpha(floatValue);
                FrsFoldingView.this.ifx.setRotation((-floatValue) * 180.0f);
            }
        });
        ofFloat.setDuration(300L);
        ofFloat.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ciw() {
        this.ift = (LinearLayout.LayoutParams) this.ifw.getLayoutParams();
        final ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.vc.FrsFoldingView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) ofFloat.getAnimatedValue()).floatValue();
                FrsFoldingView.this.ift.height = (int) (FrsFoldingView.this.ifr * floatValue);
                FrsFoldingView.this.ifw.setLayoutParams(FrsFoldingView.this.ift);
                FrsFoldingView.this.ifw.setAlpha(floatValue);
                FrsFoldingView.this.ifx.setRotation((-floatValue) * 180.0f);
            }
        });
        ofFloat.setDuration(300L);
        ofFloat.start();
    }

    public void setViews(List<View> list, List<com.baidu.tieba.frs.view.g> list2) {
        if (list == null || list.size() == 0) {
            throw new IllegalArgumentException("com.baidu.tieba.frs.vc.FrsFoldingView setViews(List<View> views) IllegalArgumentException");
        }
        this.ifv.removeAllViews();
        this.ifv.addView(list.get(0));
        if (list.size() > 1) {
            this.ifx.setVisibility(0);
            this.ifw.removeAllViews();
            this.ifw.addView(list.get(1));
            this.ifr = list2.get(1).getCount() * com.baidu.adp.lib.util.l.getDimens(getContext().getApplicationContext(), R.dimen.tbds83);
            return;
        }
        this.ifx.setVisibility(8);
    }

    public void onChangeSkinType() {
        ao.setBackgroundColor(this.mRootView, R.color.cp_bg_line_e);
        SvgManager.baR().a(this.ifx, R.drawable.ic_icon_pure_open12_right_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }
}
