package com.baidu.tieba.frs.vc;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes2.dex */
public class FrsFoldingView extends LinearLayout {
    private int jJT;
    private boolean jJU;
    private LinearLayout.LayoutParams jJV;
    private LinearLayout jJW;
    private FrameLayout jJX;
    private FrameLayout jJY;
    private ImageView jJZ;
    private View mRootView;

    public FrsFoldingView(Context context) {
        this(context, null);
    }

    public FrsFoldingView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FrsFoldingView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jJT = 0;
        this.jJU = true;
        init();
    }

    private void init() {
        initView();
        setupListener();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(getContext()).inflate(R.layout.folding_view_layout, (ViewGroup) this, true);
        this.jJW = (LinearLayout) this.mRootView.findViewById(R.id.folding_root_layout);
        this.jJX = (FrameLayout) this.mRootView.findViewById(R.id.permanent_layout);
        this.jJY = (FrameLayout) this.mRootView.findViewById(R.id.collapsible_layout);
        this.jJZ = (ImageView) this.mRootView.findViewById(R.id.folding_arrow);
        SvgManager.bsR().a(this.jJZ, R.drawable.icon_pure_unfold12_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    private void setupListener() {
        this.mRootView.findViewById(R.id.folding_arrow).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.FrsFoldingView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (FrsFoldingView.this.jJU) {
                    FrsFoldingView.this.cKN();
                    FrsFoldingView.this.jJU = false;
                    return;
                }
                FrsFoldingView.this.cKO();
                FrsFoldingView.this.jJU = true;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cKN() {
        this.jJV = (LinearLayout.LayoutParams) this.jJY.getLayoutParams();
        final ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.vc.FrsFoldingView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) ofFloat.getAnimatedValue()).floatValue();
                FrsFoldingView.this.jJV.height = (int) (FrsFoldingView.this.jJT * floatValue);
                FrsFoldingView.this.jJY.setLayoutParams(FrsFoldingView.this.jJV);
                FrsFoldingView.this.jJY.setAlpha(floatValue);
                FrsFoldingView.this.jJZ.setRotation((-floatValue) * 180.0f);
            }
        });
        ofFloat.setDuration(300L);
        ofFloat.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cKO() {
        this.jJV = (LinearLayout.LayoutParams) this.jJY.getLayoutParams();
        final ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.vc.FrsFoldingView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) ofFloat.getAnimatedValue()).floatValue();
                FrsFoldingView.this.jJV.height = (int) (FrsFoldingView.this.jJT * floatValue);
                FrsFoldingView.this.jJY.setLayoutParams(FrsFoldingView.this.jJV);
                FrsFoldingView.this.jJY.setAlpha(floatValue);
                FrsFoldingView.this.jJZ.setRotation((-floatValue) * 180.0f);
            }
        });
        ofFloat.setDuration(300L);
        ofFloat.start();
    }

    public void setViews(List<View> list, List<com.baidu.tieba.frs.view.e> list2) {
        this.jJX.removeAllViews();
        this.jJX.addView(list.get(0));
        if (list.size() > 1) {
            this.jJZ.setVisibility(0);
            this.jJY.removeAllViews();
            this.jJY.addView(list.get(1));
            this.jJT = list2.get(1).getCount() * com.baidu.adp.lib.util.l.getDimens(getContext().getApplicationContext(), R.dimen.tbds93);
            return;
        }
        this.jJZ.setVisibility(8);
    }

    public void onChangeSkinType() {
        SvgManager.bsR().a(this.jJZ, R.drawable.icon_pure_unfold12_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }
}
