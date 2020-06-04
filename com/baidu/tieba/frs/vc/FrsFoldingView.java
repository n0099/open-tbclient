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
    private int hMd;
    private boolean hMe;
    private LinearLayout.LayoutParams hMf;
    private LinearLayout hMg;
    private FrameLayout hMh;
    private FrameLayout hMi;
    private ImageView hMj;
    private View mRootView;

    public FrsFoldingView(Context context) {
        this(context, null);
    }

    public FrsFoldingView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FrsFoldingView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hMd = 0;
        this.hMe = true;
        init();
    }

    private void init() {
        initView();
        cbC();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(getContext()).inflate(R.layout.folding_view_layout, (ViewGroup) this, true);
        this.hMg = (LinearLayout) this.mRootView.findViewById(R.id.folding_root_layout);
        this.hMh = (FrameLayout) this.mRootView.findViewById(R.id.permanent_layout);
        this.hMi = (FrameLayout) this.mRootView.findViewById(R.id.collapsible_layout);
        this.hMj = (ImageView) this.mRootView.findViewById(R.id.folding_arrow);
        SvgManager.aUW().a(this.hMj, R.drawable.ic_icon_pure_open12_right_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_e);
    }

    private void cbC() {
        this.mRootView.findViewById(R.id.folding_arrow).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.FrsFoldingView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (FrsFoldingView.this.hMe) {
                    FrsFoldingView.this.cbD();
                    FrsFoldingView.this.hMe = false;
                    return;
                }
                FrsFoldingView.this.cbE();
                FrsFoldingView.this.hMe = true;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cbD() {
        this.hMf = (LinearLayout.LayoutParams) this.hMi.getLayoutParams();
        final ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.vc.FrsFoldingView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) ofFloat.getAnimatedValue()).floatValue();
                FrsFoldingView.this.hMf.height = (int) (FrsFoldingView.this.hMd * floatValue);
                FrsFoldingView.this.hMi.setLayoutParams(FrsFoldingView.this.hMf);
                FrsFoldingView.this.hMi.setAlpha(floatValue);
                FrsFoldingView.this.hMj.setRotation((-floatValue) * 180.0f);
            }
        });
        ofFloat.setDuration(300L);
        ofFloat.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cbE() {
        this.hMf = (LinearLayout.LayoutParams) this.hMi.getLayoutParams();
        final ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.vc.FrsFoldingView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) ofFloat.getAnimatedValue()).floatValue();
                FrsFoldingView.this.hMf.height = (int) (FrsFoldingView.this.hMd * floatValue);
                FrsFoldingView.this.hMi.setLayoutParams(FrsFoldingView.this.hMf);
                FrsFoldingView.this.hMi.setAlpha(floatValue);
                FrsFoldingView.this.hMj.setRotation((-floatValue) * 180.0f);
            }
        });
        ofFloat.setDuration(300L);
        ofFloat.start();
    }

    public void setViews(List<View> list, List<com.baidu.tieba.frs.view.d> list2) {
        if (list == null || list.size() == 0) {
            throw new IllegalArgumentException("com.baidu.tieba.frs.vc.FrsFoldingView setViews(List<View> views) IllegalArgumentException");
        }
        this.hMh.removeAllViews();
        this.hMh.addView(list.get(0));
        if (list.size() > 1) {
            this.hMj.setVisibility(0);
            this.hMi.removeAllViews();
            this.hMi.addView(list.get(1));
            this.hMd = list2.get(1).getCount() * com.baidu.adp.lib.util.l.getDimens(getContext().getApplicationContext(), R.dimen.tbds83);
            return;
        }
        this.hMj.setVisibility(8);
    }

    public void onChangeSkinType() {
        am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_e);
        SvgManager.aUW().a(this.hMj, R.drawable.ic_icon_pure_open12_right_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }
}
