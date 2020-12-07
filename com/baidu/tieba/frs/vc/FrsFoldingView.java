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
    private LinearLayout.LayoutParams jwA;
    private LinearLayout jwB;
    private FrameLayout jwC;
    private FrameLayout jwD;
    private ImageView jwE;
    private int jwy;
    private boolean jwz;
    private View mRootView;

    public FrsFoldingView(Context context) {
        this(context, null);
    }

    public FrsFoldingView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FrsFoldingView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jwy = 0;
        this.jwz = true;
        init();
    }

    private void init() {
        initView();
        cKp();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(getContext()).inflate(R.layout.folding_view_layout, (ViewGroup) this, true);
        this.jwB = (LinearLayout) this.mRootView.findViewById(R.id.folding_root_layout);
        this.jwC = (FrameLayout) this.mRootView.findViewById(R.id.permanent_layout);
        this.jwD = (FrameLayout) this.mRootView.findViewById(R.id.collapsible_layout);
        this.jwE = (ImageView) this.mRootView.findViewById(R.id.folding_arrow);
        SvgManager.btW().a(this.jwE, R.drawable.icon_pure_unfold12_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    private void cKp() {
        this.mRootView.findViewById(R.id.folding_arrow).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.FrsFoldingView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (FrsFoldingView.this.jwz) {
                    FrsFoldingView.this.cKq();
                    FrsFoldingView.this.jwz = false;
                    return;
                }
                FrsFoldingView.this.cKr();
                FrsFoldingView.this.jwz = true;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cKq() {
        this.jwA = (LinearLayout.LayoutParams) this.jwD.getLayoutParams();
        final ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.vc.FrsFoldingView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) ofFloat.getAnimatedValue()).floatValue();
                FrsFoldingView.this.jwA.height = (int) (FrsFoldingView.this.jwy * floatValue);
                FrsFoldingView.this.jwD.setLayoutParams(FrsFoldingView.this.jwA);
                FrsFoldingView.this.jwD.setAlpha(floatValue);
                FrsFoldingView.this.jwE.setRotation((-floatValue) * 180.0f);
            }
        });
        ofFloat.setDuration(300L);
        ofFloat.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cKr() {
        this.jwA = (LinearLayout.LayoutParams) this.jwD.getLayoutParams();
        final ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.vc.FrsFoldingView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) ofFloat.getAnimatedValue()).floatValue();
                FrsFoldingView.this.jwA.height = (int) (FrsFoldingView.this.jwy * floatValue);
                FrsFoldingView.this.jwD.setLayoutParams(FrsFoldingView.this.jwA);
                FrsFoldingView.this.jwD.setAlpha(floatValue);
                FrsFoldingView.this.jwE.setRotation((-floatValue) * 180.0f);
            }
        });
        ofFloat.setDuration(300L);
        ofFloat.start();
    }

    public void setViews(List<View> list, List<com.baidu.tieba.frs.view.g> list2) {
        this.jwC.removeAllViews();
        this.jwC.addView(list.get(0));
        if (list.size() > 1) {
            this.jwE.setVisibility(0);
            this.jwD.removeAllViews();
            this.jwD.addView(list.get(1));
            this.jwy = list2.get(1).getCount() * com.baidu.adp.lib.util.l.getDimens(getContext().getApplicationContext(), R.dimen.tbds93);
            return;
        }
        this.jwE.setVisibility(8);
    }

    public void onChangeSkinType() {
        SvgManager.btW().a(this.jwE, R.drawable.icon_pure_unfold12_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }
}
