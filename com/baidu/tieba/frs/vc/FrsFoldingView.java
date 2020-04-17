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
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes9.dex */
public class FrsFoldingView extends LinearLayout {
    private LinearLayout hwA;
    private FrameLayout hwB;
    private FrameLayout hwC;
    private ImageView hwD;
    private int hwx;
    private boolean hwy;
    private LinearLayout.LayoutParams hwz;
    private View mRootView;

    public FrsFoldingView(Context context) {
        this(context, null);
    }

    public FrsFoldingView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FrsFoldingView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hwx = 0;
        this.hwy = true;
        init();
    }

    private void init() {
        initView();
        bUY();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(getContext()).inflate(R.layout.folding_view_layout, (ViewGroup) this, true);
        this.hwA = (LinearLayout) this.mRootView.findViewById(R.id.folding_root_layout);
        this.hwB = (FrameLayout) this.mRootView.findViewById(R.id.permanent_layout);
        this.hwC = (FrameLayout) this.mRootView.findViewById(R.id.collapsible_layout);
        this.hwD = (ImageView) this.mRootView.findViewById(R.id.folding_arrow);
        SvgManager.aOU().a(this.hwD, R.drawable.ic_icon_pure_open12_right_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_e);
    }

    private void bUY() {
        this.mRootView.findViewById(R.id.folding_arrow).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.FrsFoldingView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (FrsFoldingView.this.hwy) {
                    FrsFoldingView.this.bUZ();
                    FrsFoldingView.this.hwy = false;
                    return;
                }
                FrsFoldingView.this.bVa();
                FrsFoldingView.this.hwy = true;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bUZ() {
        this.hwz = (LinearLayout.LayoutParams) this.hwC.getLayoutParams();
        final ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.vc.FrsFoldingView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) ofFloat.getAnimatedValue()).floatValue();
                FrsFoldingView.this.hwz.height = (int) (FrsFoldingView.this.hwx * floatValue);
                FrsFoldingView.this.hwC.setLayoutParams(FrsFoldingView.this.hwz);
                FrsFoldingView.this.hwC.setAlpha(floatValue);
                FrsFoldingView.this.hwD.setRotation((-floatValue) * 180.0f);
            }
        });
        ofFloat.setDuration(300L);
        ofFloat.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bVa() {
        this.hwz = (LinearLayout.LayoutParams) this.hwC.getLayoutParams();
        final ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.vc.FrsFoldingView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) ofFloat.getAnimatedValue()).floatValue();
                FrsFoldingView.this.hwz.height = (int) (FrsFoldingView.this.hwx * floatValue);
                FrsFoldingView.this.hwC.setLayoutParams(FrsFoldingView.this.hwz);
                FrsFoldingView.this.hwC.setAlpha(floatValue);
                FrsFoldingView.this.hwD.setRotation((-floatValue) * 180.0f);
            }
        });
        ofFloat.setDuration(300L);
        ofFloat.start();
    }

    public void setViews(List<View> list, List<com.baidu.tieba.frs.view.d> list2) {
        if (list == null || list.size() == 0) {
            throw new IllegalArgumentException("com.baidu.tieba.frs.vc.FrsFoldingView setViews(List<View> views) IllegalArgumentException");
        }
        this.hwB.removeAllViews();
        this.hwB.addView(list.get(0));
        if (list.size() > 1) {
            this.hwD.setVisibility(0);
            this.hwC.removeAllViews();
            this.hwC.addView(list.get(1));
            this.hwx = list2.get(1).getCount() * com.baidu.adp.lib.util.l.getDimens(getContext().getApplicationContext(), R.dimen.tbds83);
            return;
        }
        this.hwD.setVisibility(8);
    }

    public void onChangeSkinType() {
        am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_e);
        SvgManager.aOU().a(this.hwD, R.drawable.ic_icon_pure_open12_right_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }
}
