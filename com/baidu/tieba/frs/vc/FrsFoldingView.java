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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes16.dex */
public class FrsFoldingView extends LinearLayout {
    private LinearLayout itA;
    private FrameLayout itB;
    private FrameLayout itC;
    private ImageView itD;
    private int itx;
    private boolean ity;
    private LinearLayout.LayoutParams itz;
    private View mRootView;

    public FrsFoldingView(Context context) {
        this(context, null);
    }

    public FrsFoldingView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FrsFoldingView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.itx = 0;
        this.ity = true;
        init();
    }

    private void init() {
        initView();
        csY();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(getContext()).inflate(R.layout.folding_view_layout, (ViewGroup) this, true);
        this.itA = (LinearLayout) this.mRootView.findViewById(R.id.folding_root_layout);
        this.itB = (FrameLayout) this.mRootView.findViewById(R.id.permanent_layout);
        this.itC = (FrameLayout) this.mRootView.findViewById(R.id.collapsible_layout);
        this.itD = (ImageView) this.mRootView.findViewById(R.id.folding_arrow);
        SvgManager.bjq().a(this.itD, R.drawable.ic_icon_pure_open12_right_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        ap.setBackgroundColor(this.mRootView, R.color.cp_bg_line_e);
    }

    private void csY() {
        this.mRootView.findViewById(R.id.folding_arrow).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.FrsFoldingView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (FrsFoldingView.this.ity) {
                    FrsFoldingView.this.csZ();
                    FrsFoldingView.this.ity = false;
                    return;
                }
                FrsFoldingView.this.cta();
                FrsFoldingView.this.ity = true;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void csZ() {
        this.itz = (LinearLayout.LayoutParams) this.itC.getLayoutParams();
        final ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.vc.FrsFoldingView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) ofFloat.getAnimatedValue()).floatValue();
                FrsFoldingView.this.itz.height = (int) (FrsFoldingView.this.itx * floatValue);
                FrsFoldingView.this.itC.setLayoutParams(FrsFoldingView.this.itz);
                FrsFoldingView.this.itC.setAlpha(floatValue);
                FrsFoldingView.this.itD.setRotation((-floatValue) * 180.0f);
            }
        });
        ofFloat.setDuration(300L);
        ofFloat.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cta() {
        this.itz = (LinearLayout.LayoutParams) this.itC.getLayoutParams();
        final ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.vc.FrsFoldingView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) ofFloat.getAnimatedValue()).floatValue();
                FrsFoldingView.this.itz.height = (int) (FrsFoldingView.this.itx * floatValue);
                FrsFoldingView.this.itC.setLayoutParams(FrsFoldingView.this.itz);
                FrsFoldingView.this.itC.setAlpha(floatValue);
                FrsFoldingView.this.itD.setRotation((-floatValue) * 180.0f);
            }
        });
        ofFloat.setDuration(300L);
        ofFloat.start();
    }

    public void setViews(List<View> list, List<com.baidu.tieba.frs.view.g> list2) {
        this.itB.removeAllViews();
        this.itB.addView(list.get(0));
        if (list.size() > 1) {
            this.itD.setVisibility(0);
            this.itC.removeAllViews();
            this.itC.addView(list.get(1));
            this.itx = list2.get(1).getCount() * com.baidu.adp.lib.util.l.getDimens(getContext().getApplicationContext(), R.dimen.tbds83);
            return;
        }
        this.itD.setVisibility(8);
    }

    public void onChangeSkinType() {
        ap.setBackgroundColor(this.mRootView, R.color.cp_bg_line_e);
        SvgManager.bjq().a(this.itD, R.drawable.ic_icon_pure_open12_right_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }
}
