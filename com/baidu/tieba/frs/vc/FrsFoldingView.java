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
    private int hwD;
    private boolean hwE;
    private LinearLayout.LayoutParams hwF;
    private LinearLayout hwG;
    private FrameLayout hwH;
    private FrameLayout hwI;
    private ImageView hwJ;
    private View mRootView;

    public FrsFoldingView(Context context) {
        this(context, null);
    }

    public FrsFoldingView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FrsFoldingView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hwD = 0;
        this.hwE = true;
        init();
    }

    private void init() {
        initView();
        bUX();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(getContext()).inflate(R.layout.folding_view_layout, (ViewGroup) this, true);
        this.hwG = (LinearLayout) this.mRootView.findViewById(R.id.folding_root_layout);
        this.hwH = (FrameLayout) this.mRootView.findViewById(R.id.permanent_layout);
        this.hwI = (FrameLayout) this.mRootView.findViewById(R.id.collapsible_layout);
        this.hwJ = (ImageView) this.mRootView.findViewById(R.id.folding_arrow);
        SvgManager.aOR().a(this.hwJ, R.drawable.ic_icon_pure_open12_right_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_e);
    }

    private void bUX() {
        this.mRootView.findViewById(R.id.folding_arrow).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.FrsFoldingView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (FrsFoldingView.this.hwE) {
                    FrsFoldingView.this.bUY();
                    FrsFoldingView.this.hwE = false;
                    return;
                }
                FrsFoldingView.this.bUZ();
                FrsFoldingView.this.hwE = true;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bUY() {
        this.hwF = (LinearLayout.LayoutParams) this.hwI.getLayoutParams();
        final ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.vc.FrsFoldingView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) ofFloat.getAnimatedValue()).floatValue();
                FrsFoldingView.this.hwF.height = (int) (FrsFoldingView.this.hwD * floatValue);
                FrsFoldingView.this.hwI.setLayoutParams(FrsFoldingView.this.hwF);
                FrsFoldingView.this.hwI.setAlpha(floatValue);
                FrsFoldingView.this.hwJ.setRotation((-floatValue) * 180.0f);
            }
        });
        ofFloat.setDuration(300L);
        ofFloat.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bUZ() {
        this.hwF = (LinearLayout.LayoutParams) this.hwI.getLayoutParams();
        final ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.vc.FrsFoldingView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) ofFloat.getAnimatedValue()).floatValue();
                FrsFoldingView.this.hwF.height = (int) (FrsFoldingView.this.hwD * floatValue);
                FrsFoldingView.this.hwI.setLayoutParams(FrsFoldingView.this.hwF);
                FrsFoldingView.this.hwI.setAlpha(floatValue);
                FrsFoldingView.this.hwJ.setRotation((-floatValue) * 180.0f);
            }
        });
        ofFloat.setDuration(300L);
        ofFloat.start();
    }

    public void setViews(List<View> list, List<com.baidu.tieba.frs.view.d> list2) {
        if (list == null || list.size() == 0) {
            throw new IllegalArgumentException("com.baidu.tieba.frs.vc.FrsFoldingView setViews(List<View> views) IllegalArgumentException");
        }
        this.hwH.removeAllViews();
        this.hwH.addView(list.get(0));
        if (list.size() > 1) {
            this.hwJ.setVisibility(0);
            this.hwI.removeAllViews();
            this.hwI.addView(list.get(1));
            this.hwD = list2.get(1).getCount() * com.baidu.adp.lib.util.l.getDimens(getContext().getApplicationContext(), R.dimen.tbds83);
            return;
        }
        this.hwJ.setVisibility(8);
    }

    public void onChangeSkinType() {
        am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_e);
        SvgManager.aOR().a(this.hwJ, R.drawable.ic_icon_pure_open12_right_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }
}
