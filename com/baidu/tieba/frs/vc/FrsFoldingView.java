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
/* loaded from: classes16.dex */
public class FrsFoldingView extends LinearLayout {
    private int itD;
    private boolean itE;
    private LinearLayout.LayoutParams itF;
    private LinearLayout itG;
    private FrameLayout itH;
    private FrameLayout itI;
    private ImageView itJ;
    private View mRootView;

    public FrsFoldingView(Context context) {
        this(context, null);
    }

    public FrsFoldingView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FrsFoldingView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.itD = 0;
        this.itE = true;
        init();
    }

    private void init() {
        initView();
        csZ();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(getContext()).inflate(R.layout.folding_view_layout, (ViewGroup) this, true);
        this.itG = (LinearLayout) this.mRootView.findViewById(R.id.folding_root_layout);
        this.itH = (FrameLayout) this.mRootView.findViewById(R.id.permanent_layout);
        this.itI = (FrameLayout) this.mRootView.findViewById(R.id.collapsible_layout);
        this.itJ = (ImageView) this.mRootView.findViewById(R.id.folding_arrow);
        SvgManager.bjq().a(this.itJ, R.drawable.ic_icon_pure_open12_right_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        ap.setBackgroundColor(this.mRootView, R.color.cp_bg_line_e);
    }

    private void csZ() {
        this.mRootView.findViewById(R.id.folding_arrow).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.FrsFoldingView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (FrsFoldingView.this.itE) {
                    FrsFoldingView.this.cta();
                    FrsFoldingView.this.itE = false;
                    return;
                }
                FrsFoldingView.this.ctb();
                FrsFoldingView.this.itE = true;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cta() {
        this.itF = (LinearLayout.LayoutParams) this.itI.getLayoutParams();
        final ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.vc.FrsFoldingView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) ofFloat.getAnimatedValue()).floatValue();
                FrsFoldingView.this.itF.height = (int) (FrsFoldingView.this.itD * floatValue);
                FrsFoldingView.this.itI.setLayoutParams(FrsFoldingView.this.itF);
                FrsFoldingView.this.itI.setAlpha(floatValue);
                FrsFoldingView.this.itJ.setRotation((-floatValue) * 180.0f);
            }
        });
        ofFloat.setDuration(300L);
        ofFloat.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ctb() {
        this.itF = (LinearLayout.LayoutParams) this.itI.getLayoutParams();
        final ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.vc.FrsFoldingView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) ofFloat.getAnimatedValue()).floatValue();
                FrsFoldingView.this.itF.height = (int) (FrsFoldingView.this.itD * floatValue);
                FrsFoldingView.this.itI.setLayoutParams(FrsFoldingView.this.itF);
                FrsFoldingView.this.itI.setAlpha(floatValue);
                FrsFoldingView.this.itJ.setRotation((-floatValue) * 180.0f);
            }
        });
        ofFloat.setDuration(300L);
        ofFloat.start();
    }

    public void setViews(List<View> list, List<com.baidu.tieba.frs.view.g> list2) {
        this.itH.removeAllViews();
        this.itH.addView(list.get(0));
        if (list.size() > 1) {
            this.itJ.setVisibility(0);
            this.itI.removeAllViews();
            this.itI.addView(list.get(1));
            this.itD = list2.get(1).getCount() * com.baidu.adp.lib.util.l.getDimens(getContext().getApplicationContext(), R.dimen.tbds83);
            return;
        }
        this.itJ.setVisibility(8);
    }

    public void onChangeSkinType() {
        ap.setBackgroundColor(this.mRootView, R.color.cp_bg_line_e);
        SvgManager.bjq().a(this.itJ, R.drawable.ic_icon_pure_open12_right_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }
}
