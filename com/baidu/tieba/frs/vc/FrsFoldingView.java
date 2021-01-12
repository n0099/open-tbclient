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
    private int jEp;
    private boolean jEq;
    private LinearLayout.LayoutParams jEr;
    private LinearLayout jEs;
    private FrameLayout jEt;
    private FrameLayout jEu;
    private ImageView jEv;
    private View mRootView;

    public FrsFoldingView(Context context) {
        this(context, null);
    }

    public FrsFoldingView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FrsFoldingView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jEp = 0;
        this.jEq = true;
        init();
    }

    private void init() {
        initView();
        setupListener();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(getContext()).inflate(R.layout.folding_view_layout, (ViewGroup) this, true);
        this.jEs = (LinearLayout) this.mRootView.findViewById(R.id.folding_root_layout);
        this.jEt = (FrameLayout) this.mRootView.findViewById(R.id.permanent_layout);
        this.jEu = (FrameLayout) this.mRootView.findViewById(R.id.collapsible_layout);
        this.jEv = (ImageView) this.mRootView.findViewById(R.id.folding_arrow);
        SvgManager.bsx().a(this.jEv, R.drawable.icon_pure_unfold12_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    private void setupListener() {
        this.mRootView.findViewById(R.id.folding_arrow).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.FrsFoldingView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (FrsFoldingView.this.jEq) {
                    FrsFoldingView.this.cJA();
                    FrsFoldingView.this.jEq = false;
                    return;
                }
                FrsFoldingView.this.cJB();
                FrsFoldingView.this.jEq = true;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cJA() {
        this.jEr = (LinearLayout.LayoutParams) this.jEu.getLayoutParams();
        final ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.vc.FrsFoldingView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) ofFloat.getAnimatedValue()).floatValue();
                FrsFoldingView.this.jEr.height = (int) (FrsFoldingView.this.jEp * floatValue);
                FrsFoldingView.this.jEu.setLayoutParams(FrsFoldingView.this.jEr);
                FrsFoldingView.this.jEu.setAlpha(floatValue);
                FrsFoldingView.this.jEv.setRotation((-floatValue) * 180.0f);
            }
        });
        ofFloat.setDuration(300L);
        ofFloat.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cJB() {
        this.jEr = (LinearLayout.LayoutParams) this.jEu.getLayoutParams();
        final ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.vc.FrsFoldingView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) ofFloat.getAnimatedValue()).floatValue();
                FrsFoldingView.this.jEr.height = (int) (FrsFoldingView.this.jEp * floatValue);
                FrsFoldingView.this.jEu.setLayoutParams(FrsFoldingView.this.jEr);
                FrsFoldingView.this.jEu.setAlpha(floatValue);
                FrsFoldingView.this.jEv.setRotation((-floatValue) * 180.0f);
            }
        });
        ofFloat.setDuration(300L);
        ofFloat.start();
    }

    public void setViews(List<View> list, List<com.baidu.tieba.frs.view.e> list2) {
        this.jEt.removeAllViews();
        this.jEt.addView(list.get(0));
        if (list.size() > 1) {
            this.jEv.setVisibility(0);
            this.jEu.removeAllViews();
            this.jEu.addView(list.get(1));
            this.jEp = list2.get(1).getCount() * com.baidu.adp.lib.util.l.getDimens(getContext().getApplicationContext(), R.dimen.tbds93);
            return;
        }
        this.jEv.setVisibility(8);
    }

    public void onChangeSkinType() {
        SvgManager.bsx().a(this.jEv, R.drawable.icon_pure_unfold12_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }
}
