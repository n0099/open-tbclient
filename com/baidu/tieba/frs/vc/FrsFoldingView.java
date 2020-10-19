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
/* loaded from: classes22.dex */
public class FrsFoldingView extends LinearLayout {
    private int iPR;
    private boolean iPS;
    private LinearLayout.LayoutParams iPT;
    private LinearLayout iPU;
    private FrameLayout iPV;
    private FrameLayout iPW;
    private ImageView iPX;
    private View mRootView;

    public FrsFoldingView(Context context) {
        this(context, null);
    }

    public FrsFoldingView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FrsFoldingView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iPR = 0;
        this.iPS = true;
        init();
    }

    private void init() {
        initView();
        czN();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(getContext()).inflate(R.layout.folding_view_layout, (ViewGroup) this, true);
        this.iPU = (LinearLayout) this.mRootView.findViewById(R.id.folding_root_layout);
        this.iPV = (FrameLayout) this.mRootView.findViewById(R.id.permanent_layout);
        this.iPW = (FrameLayout) this.mRootView.findViewById(R.id.collapsible_layout);
        this.iPX = (ImageView) this.mRootView.findViewById(R.id.folding_arrow);
        SvgManager.bmU().a(this.iPX, R.drawable.ic_icon_pure_open12_right_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        ap.setBackgroundColor(this.mRootView, R.color.cp_bg_line_e);
    }

    private void czN() {
        this.mRootView.findViewById(R.id.folding_arrow).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.FrsFoldingView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (FrsFoldingView.this.iPS) {
                    FrsFoldingView.this.czO();
                    FrsFoldingView.this.iPS = false;
                    return;
                }
                FrsFoldingView.this.czP();
                FrsFoldingView.this.iPS = true;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void czO() {
        this.iPT = (LinearLayout.LayoutParams) this.iPW.getLayoutParams();
        final ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.vc.FrsFoldingView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) ofFloat.getAnimatedValue()).floatValue();
                FrsFoldingView.this.iPT.height = (int) (FrsFoldingView.this.iPR * floatValue);
                FrsFoldingView.this.iPW.setLayoutParams(FrsFoldingView.this.iPT);
                FrsFoldingView.this.iPW.setAlpha(floatValue);
                FrsFoldingView.this.iPX.setRotation((-floatValue) * 180.0f);
            }
        });
        ofFloat.setDuration(300L);
        ofFloat.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void czP() {
        this.iPT = (LinearLayout.LayoutParams) this.iPW.getLayoutParams();
        final ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.vc.FrsFoldingView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) ofFloat.getAnimatedValue()).floatValue();
                FrsFoldingView.this.iPT.height = (int) (FrsFoldingView.this.iPR * floatValue);
                FrsFoldingView.this.iPW.setLayoutParams(FrsFoldingView.this.iPT);
                FrsFoldingView.this.iPW.setAlpha(floatValue);
                FrsFoldingView.this.iPX.setRotation((-floatValue) * 180.0f);
            }
        });
        ofFloat.setDuration(300L);
        ofFloat.start();
    }

    public void setViews(List<View> list, List<com.baidu.tieba.frs.view.g> list2) {
        this.iPV.removeAllViews();
        this.iPV.addView(list.get(0));
        if (list.size() > 1) {
            this.iPX.setVisibility(0);
            this.iPW.removeAllViews();
            this.iPW.addView(list.get(1));
            this.iPR = list2.get(1).getCount() * com.baidu.adp.lib.util.l.getDimens(getContext().getApplicationContext(), R.dimen.tbds83);
            return;
        }
        this.iPX.setVisibility(8);
    }

    public void onChangeSkinType() {
        ap.setBackgroundColor(this.mRootView, R.color.cp_bg_line_e);
        SvgManager.bmU().a(this.iPX, R.drawable.ic_icon_pure_open12_right_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }
}
