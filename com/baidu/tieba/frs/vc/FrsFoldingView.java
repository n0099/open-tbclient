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
/* loaded from: classes21.dex */
public class FrsFoldingView extends LinearLayout {
    private int iAZ;
    private boolean iBa;
    private LinearLayout.LayoutParams iBb;
    private LinearLayout iBc;
    private FrameLayout iBd;
    private FrameLayout iBe;
    private ImageView iBf;
    private View mRootView;

    public FrsFoldingView(Context context) {
        this(context, null);
    }

    public FrsFoldingView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FrsFoldingView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iAZ = 0;
        this.iBa = true;
        init();
    }

    private void init() {
        initView();
        cwq();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(getContext()).inflate(R.layout.folding_view_layout, (ViewGroup) this, true);
        this.iBc = (LinearLayout) this.mRootView.findViewById(R.id.folding_root_layout);
        this.iBd = (FrameLayout) this.mRootView.findViewById(R.id.permanent_layout);
        this.iBe = (FrameLayout) this.mRootView.findViewById(R.id.collapsible_layout);
        this.iBf = (ImageView) this.mRootView.findViewById(R.id.folding_arrow);
        SvgManager.bkl().a(this.iBf, R.drawable.ic_icon_pure_open12_right_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        ap.setBackgroundColor(this.mRootView, R.color.cp_bg_line_e);
    }

    private void cwq() {
        this.mRootView.findViewById(R.id.folding_arrow).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.FrsFoldingView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (FrsFoldingView.this.iBa) {
                    FrsFoldingView.this.cwr();
                    FrsFoldingView.this.iBa = false;
                    return;
                }
                FrsFoldingView.this.cws();
                FrsFoldingView.this.iBa = true;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cwr() {
        this.iBb = (LinearLayout.LayoutParams) this.iBe.getLayoutParams();
        final ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.vc.FrsFoldingView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) ofFloat.getAnimatedValue()).floatValue();
                FrsFoldingView.this.iBb.height = (int) (FrsFoldingView.this.iAZ * floatValue);
                FrsFoldingView.this.iBe.setLayoutParams(FrsFoldingView.this.iBb);
                FrsFoldingView.this.iBe.setAlpha(floatValue);
                FrsFoldingView.this.iBf.setRotation((-floatValue) * 180.0f);
            }
        });
        ofFloat.setDuration(300L);
        ofFloat.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cws() {
        this.iBb = (LinearLayout.LayoutParams) this.iBe.getLayoutParams();
        final ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.vc.FrsFoldingView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) ofFloat.getAnimatedValue()).floatValue();
                FrsFoldingView.this.iBb.height = (int) (FrsFoldingView.this.iAZ * floatValue);
                FrsFoldingView.this.iBe.setLayoutParams(FrsFoldingView.this.iBb);
                FrsFoldingView.this.iBe.setAlpha(floatValue);
                FrsFoldingView.this.iBf.setRotation((-floatValue) * 180.0f);
            }
        });
        ofFloat.setDuration(300L);
        ofFloat.start();
    }

    public void setViews(List<View> list, List<com.baidu.tieba.frs.view.g> list2) {
        this.iBd.removeAllViews();
        this.iBd.addView(list.get(0));
        if (list.size() > 1) {
            this.iBf.setVisibility(0);
            this.iBe.removeAllViews();
            this.iBe.addView(list.get(1));
            this.iAZ = list2.get(1).getCount() * com.baidu.adp.lib.util.l.getDimens(getContext().getApplicationContext(), R.dimen.tbds83);
            return;
        }
        this.iBf.setVisibility(8);
    }

    public void onChangeSkinType() {
        ap.setBackgroundColor(this.mRootView, R.color.cp_bg_line_e);
        SvgManager.bkl().a(this.iBf, R.drawable.ic_icon_pure_open12_right_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }
}
