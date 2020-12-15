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
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes22.dex */
public class FrsFoldingView extends LinearLayout {
    private int jwA;
    private boolean jwB;
    private LinearLayout.LayoutParams jwC;
    private LinearLayout jwD;
    private FrameLayout jwE;
    private FrameLayout jwF;
    private ImageView jwG;
    private View mRootView;

    public FrsFoldingView(Context context) {
        this(context, null);
    }

    public FrsFoldingView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FrsFoldingView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jwA = 0;
        this.jwB = true;
        init();
    }

    private void init() {
        initView();
        cKq();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(getContext()).inflate(R.layout.folding_view_layout, (ViewGroup) this, true);
        this.jwD = (LinearLayout) this.mRootView.findViewById(R.id.folding_root_layout);
        this.jwE = (FrameLayout) this.mRootView.findViewById(R.id.permanent_layout);
        this.jwF = (FrameLayout) this.mRootView.findViewById(R.id.collapsible_layout);
        this.jwG = (ImageView) this.mRootView.findViewById(R.id.folding_arrow);
        SvgManager.btW().a(this.jwG, R.drawable.icon_pure_unfold12_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    private void cKq() {
        this.mRootView.findViewById(R.id.folding_arrow).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.FrsFoldingView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (FrsFoldingView.this.jwB) {
                    FrsFoldingView.this.cKr();
                    FrsFoldingView.this.jwB = false;
                    return;
                }
                FrsFoldingView.this.cKs();
                FrsFoldingView.this.jwB = true;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cKr() {
        this.jwC = (LinearLayout.LayoutParams) this.jwF.getLayoutParams();
        final ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.vc.FrsFoldingView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) ofFloat.getAnimatedValue()).floatValue();
                FrsFoldingView.this.jwC.height = (int) (FrsFoldingView.this.jwA * floatValue);
                FrsFoldingView.this.jwF.setLayoutParams(FrsFoldingView.this.jwC);
                FrsFoldingView.this.jwF.setAlpha(floatValue);
                FrsFoldingView.this.jwG.setRotation((-floatValue) * 180.0f);
            }
        });
        ofFloat.setDuration(300L);
        ofFloat.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cKs() {
        this.jwC = (LinearLayout.LayoutParams) this.jwF.getLayoutParams();
        final ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.vc.FrsFoldingView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) ofFloat.getAnimatedValue()).floatValue();
                FrsFoldingView.this.jwC.height = (int) (FrsFoldingView.this.jwA * floatValue);
                FrsFoldingView.this.jwF.setLayoutParams(FrsFoldingView.this.jwC);
                FrsFoldingView.this.jwF.setAlpha(floatValue);
                FrsFoldingView.this.jwG.setRotation((-floatValue) * 180.0f);
            }
        });
        ofFloat.setDuration(300L);
        ofFloat.start();
    }

    public void setViews(List<View> list, List<com.baidu.tieba.frs.view.g> list2) {
        this.jwE.removeAllViews();
        this.jwE.addView(list.get(0));
        if (list.size() > 1) {
            this.jwG.setVisibility(0);
            this.jwF.removeAllViews();
            this.jwF.addView(list.get(1));
            this.jwA = list2.get(1).getCount() * com.baidu.adp.lib.util.l.getDimens(getContext().getApplicationContext(), R.dimen.tbds93);
            return;
        }
        this.jwG.setVisibility(8);
    }

    public void onChangeSkinType() {
        SvgManager.btW().a(this.jwG, R.drawable.icon_pure_unfold12_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }
}
