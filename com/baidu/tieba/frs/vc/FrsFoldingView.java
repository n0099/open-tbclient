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
    private int jcn;
    private boolean jco;
    private LinearLayout.LayoutParams jcp;
    private LinearLayout jcq;
    private FrameLayout jcr;
    private FrameLayout jcs;
    private ImageView jct;
    private View mRootView;

    public FrsFoldingView(Context context) {
        this(context, null);
    }

    public FrsFoldingView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FrsFoldingView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jcn = 0;
        this.jco = true;
        init();
    }

    private void init() {
        initView();
        cCU();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(getContext()).inflate(R.layout.folding_view_layout, (ViewGroup) this, true);
        this.jcq = (LinearLayout) this.mRootView.findViewById(R.id.folding_root_layout);
        this.jcr = (FrameLayout) this.mRootView.findViewById(R.id.permanent_layout);
        this.jcs = (FrameLayout) this.mRootView.findViewById(R.id.collapsible_layout);
        this.jct = (ImageView) this.mRootView.findViewById(R.id.folding_arrow);
        SvgManager.boN().a(this.jct, R.drawable.ic_icon_pure_open12_right_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        ap.setBackgroundColor(this.mRootView, R.color.cp_bg_line_e);
    }

    private void cCU() {
        this.mRootView.findViewById(R.id.folding_arrow).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.FrsFoldingView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (FrsFoldingView.this.jco) {
                    FrsFoldingView.this.cCV();
                    FrsFoldingView.this.jco = false;
                    return;
                }
                FrsFoldingView.this.cCW();
                FrsFoldingView.this.jco = true;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cCV() {
        this.jcp = (LinearLayout.LayoutParams) this.jcs.getLayoutParams();
        final ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.vc.FrsFoldingView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) ofFloat.getAnimatedValue()).floatValue();
                FrsFoldingView.this.jcp.height = (int) (FrsFoldingView.this.jcn * floatValue);
                FrsFoldingView.this.jcs.setLayoutParams(FrsFoldingView.this.jcp);
                FrsFoldingView.this.jcs.setAlpha(floatValue);
                FrsFoldingView.this.jct.setRotation((-floatValue) * 180.0f);
            }
        });
        ofFloat.setDuration(300L);
        ofFloat.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cCW() {
        this.jcp = (LinearLayout.LayoutParams) this.jcs.getLayoutParams();
        final ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.vc.FrsFoldingView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) ofFloat.getAnimatedValue()).floatValue();
                FrsFoldingView.this.jcp.height = (int) (FrsFoldingView.this.jcn * floatValue);
                FrsFoldingView.this.jcs.setLayoutParams(FrsFoldingView.this.jcp);
                FrsFoldingView.this.jcs.setAlpha(floatValue);
                FrsFoldingView.this.jct.setRotation((-floatValue) * 180.0f);
            }
        });
        ofFloat.setDuration(300L);
        ofFloat.start();
    }

    public void setViews(List<View> list, List<com.baidu.tieba.frs.view.g> list2) {
        this.jcr.removeAllViews();
        this.jcr.addView(list.get(0));
        if (list.size() > 1) {
            this.jct.setVisibility(0);
            this.jcs.removeAllViews();
            this.jcs.addView(list.get(1));
            this.jcn = list2.get(1).getCount() * com.baidu.adp.lib.util.l.getDimens(getContext().getApplicationContext(), R.dimen.tbds83);
            return;
        }
        this.jct.setVisibility(8);
    }

    public void onChangeSkinType() {
        ap.setBackgroundColor(this.mRootView, R.color.cp_bg_line_e);
        SvgManager.boN().a(this.jct, R.drawable.ic_icon_pure_open12_right_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }
}
