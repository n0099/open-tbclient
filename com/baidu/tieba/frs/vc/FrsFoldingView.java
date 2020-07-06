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
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes9.dex */
public class FrsFoldingView extends LinearLayout {
    private int hZp;
    private boolean hZq;
    private LinearLayout.LayoutParams hZr;
    private LinearLayout hZs;
    private FrameLayout hZt;
    private FrameLayout hZu;
    private ImageView hZv;
    private View mRootView;

    public FrsFoldingView(Context context) {
        this(context, null);
    }

    public FrsFoldingView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FrsFoldingView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hZp = 0;
        this.hZq = true;
        init();
    }

    private void init() {
        initView();
        ceV();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(getContext()).inflate(R.layout.folding_view_layout, (ViewGroup) this, true);
        this.hZs = (LinearLayout) this.mRootView.findViewById(R.id.folding_root_layout);
        this.hZt = (FrameLayout) this.mRootView.findViewById(R.id.permanent_layout);
        this.hZu = (FrameLayout) this.mRootView.findViewById(R.id.collapsible_layout);
        this.hZv = (ImageView) this.mRootView.findViewById(R.id.folding_arrow);
        SvgManager.aWQ().a(this.hZv, R.drawable.ic_icon_pure_open12_right_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        an.setBackgroundColor(this.mRootView, R.color.cp_bg_line_e);
    }

    private void ceV() {
        this.mRootView.findViewById(R.id.folding_arrow).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.FrsFoldingView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (FrsFoldingView.this.hZq) {
                    FrsFoldingView.this.ceW();
                    FrsFoldingView.this.hZq = false;
                    return;
                }
                FrsFoldingView.this.ceX();
                FrsFoldingView.this.hZq = true;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ceW() {
        this.hZr = (LinearLayout.LayoutParams) this.hZu.getLayoutParams();
        final ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.vc.FrsFoldingView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) ofFloat.getAnimatedValue()).floatValue();
                FrsFoldingView.this.hZr.height = (int) (FrsFoldingView.this.hZp * floatValue);
                FrsFoldingView.this.hZu.setLayoutParams(FrsFoldingView.this.hZr);
                FrsFoldingView.this.hZu.setAlpha(floatValue);
                FrsFoldingView.this.hZv.setRotation((-floatValue) * 180.0f);
            }
        });
        ofFloat.setDuration(300L);
        ofFloat.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ceX() {
        this.hZr = (LinearLayout.LayoutParams) this.hZu.getLayoutParams();
        final ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.vc.FrsFoldingView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) ofFloat.getAnimatedValue()).floatValue();
                FrsFoldingView.this.hZr.height = (int) (FrsFoldingView.this.hZp * floatValue);
                FrsFoldingView.this.hZu.setLayoutParams(FrsFoldingView.this.hZr);
                FrsFoldingView.this.hZu.setAlpha(floatValue);
                FrsFoldingView.this.hZv.setRotation((-floatValue) * 180.0f);
            }
        });
        ofFloat.setDuration(300L);
        ofFloat.start();
    }

    public void setViews(List<View> list, List<com.baidu.tieba.frs.view.g> list2) {
        if (list == null || list.size() == 0) {
            throw new IllegalArgumentException("com.baidu.tieba.frs.vc.FrsFoldingView setViews(List<View> views) IllegalArgumentException");
        }
        this.hZt.removeAllViews();
        this.hZt.addView(list.get(0));
        if (list.size() > 1) {
            this.hZv.setVisibility(0);
            this.hZu.removeAllViews();
            this.hZu.addView(list.get(1));
            this.hZp = list2.get(1).getCount() * com.baidu.adp.lib.util.l.getDimens(getContext().getApplicationContext(), R.dimen.tbds83);
            return;
        }
        this.hZv.setVisibility(8);
    }

    public void onChangeSkinType() {
        an.setBackgroundColor(this.mRootView, R.color.cp_bg_line_e);
        SvgManager.aWQ().a(this.hZv, R.drawable.ic_icon_pure_open12_right_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }
}
