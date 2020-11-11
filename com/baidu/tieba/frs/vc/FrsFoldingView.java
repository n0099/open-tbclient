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
    private int jil;
    private boolean jim;
    private LinearLayout.LayoutParams jin;
    private LinearLayout jio;
    private FrameLayout jip;
    private FrameLayout jiq;
    private ImageView jir;
    private View mRootView;

    public FrsFoldingView(Context context) {
        this(context, null);
    }

    public FrsFoldingView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FrsFoldingView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jil = 0;
        this.jim = true;
        init();
    }

    private void init() {
        initView();
        cFv();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(getContext()).inflate(R.layout.folding_view_layout, (ViewGroup) this, true);
        this.jio = (LinearLayout) this.mRootView.findViewById(R.id.folding_root_layout);
        this.jip = (FrameLayout) this.mRootView.findViewById(R.id.permanent_layout);
        this.jiq = (FrameLayout) this.mRootView.findViewById(R.id.collapsible_layout);
        this.jir = (ImageView) this.mRootView.findViewById(R.id.folding_arrow);
        SvgManager.brn().a(this.jir, R.drawable.ic_icon_pure_open12_right_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        ap.setBackgroundColor(this.mRootView, R.color.cp_bg_line_e);
    }

    private void cFv() {
        this.mRootView.findViewById(R.id.folding_arrow).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.FrsFoldingView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (FrsFoldingView.this.jim) {
                    FrsFoldingView.this.cFw();
                    FrsFoldingView.this.jim = false;
                    return;
                }
                FrsFoldingView.this.cFx();
                FrsFoldingView.this.jim = true;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cFw() {
        this.jin = (LinearLayout.LayoutParams) this.jiq.getLayoutParams();
        final ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.vc.FrsFoldingView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) ofFloat.getAnimatedValue()).floatValue();
                FrsFoldingView.this.jin.height = (int) (FrsFoldingView.this.jil * floatValue);
                FrsFoldingView.this.jiq.setLayoutParams(FrsFoldingView.this.jin);
                FrsFoldingView.this.jiq.setAlpha(floatValue);
                FrsFoldingView.this.jir.setRotation((-floatValue) * 180.0f);
            }
        });
        ofFloat.setDuration(300L);
        ofFloat.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cFx() {
        this.jin = (LinearLayout.LayoutParams) this.jiq.getLayoutParams();
        final ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.vc.FrsFoldingView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) ofFloat.getAnimatedValue()).floatValue();
                FrsFoldingView.this.jin.height = (int) (FrsFoldingView.this.jil * floatValue);
                FrsFoldingView.this.jiq.setLayoutParams(FrsFoldingView.this.jin);
                FrsFoldingView.this.jiq.setAlpha(floatValue);
                FrsFoldingView.this.jir.setRotation((-floatValue) * 180.0f);
            }
        });
        ofFloat.setDuration(300L);
        ofFloat.start();
    }

    public void setViews(List<View> list, List<com.baidu.tieba.frs.view.g> list2) {
        this.jip.removeAllViews();
        this.jip.addView(list.get(0));
        if (list.size() > 1) {
            this.jir.setVisibility(0);
            this.jiq.removeAllViews();
            this.jiq.addView(list.get(1));
            this.jil = list2.get(1).getCount() * com.baidu.adp.lib.util.l.getDimens(getContext().getApplicationContext(), R.dimen.tbds83);
            return;
        }
        this.jir.setVisibility(8);
    }

    public void onChangeSkinType() {
        ap.setBackgroundColor(this.mRootView, R.color.cp_bg_line_e);
        SvgManager.brn().a(this.jir, R.drawable.ic_icon_pure_open12_right_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }
}
