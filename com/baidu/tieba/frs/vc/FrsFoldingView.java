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
    private int hLq;
    private boolean hLr;
    private LinearLayout.LayoutParams hLs;
    private LinearLayout hLt;
    private FrameLayout hLu;
    private FrameLayout hLv;
    private ImageView hLw;
    private View mRootView;

    public FrsFoldingView(Context context) {
        this(context, null);
    }

    public FrsFoldingView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FrsFoldingView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hLq = 0;
        this.hLr = true;
        init();
    }

    private void init() {
        initView();
        cbu();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(getContext()).inflate(R.layout.folding_view_layout, (ViewGroup) this, true);
        this.hLt = (LinearLayout) this.mRootView.findViewById(R.id.folding_root_layout);
        this.hLu = (FrameLayout) this.mRootView.findViewById(R.id.permanent_layout);
        this.hLv = (FrameLayout) this.mRootView.findViewById(R.id.collapsible_layout);
        this.hLw = (ImageView) this.mRootView.findViewById(R.id.folding_arrow);
        SvgManager.aUV().a(this.hLw, R.drawable.ic_icon_pure_open12_right_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_e);
    }

    private void cbu() {
        this.mRootView.findViewById(R.id.folding_arrow).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.FrsFoldingView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (FrsFoldingView.this.hLr) {
                    FrsFoldingView.this.cbv();
                    FrsFoldingView.this.hLr = false;
                    return;
                }
                FrsFoldingView.this.cbw();
                FrsFoldingView.this.hLr = true;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cbv() {
        this.hLs = (LinearLayout.LayoutParams) this.hLv.getLayoutParams();
        final ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.vc.FrsFoldingView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) ofFloat.getAnimatedValue()).floatValue();
                FrsFoldingView.this.hLs.height = (int) (FrsFoldingView.this.hLq * floatValue);
                FrsFoldingView.this.hLv.setLayoutParams(FrsFoldingView.this.hLs);
                FrsFoldingView.this.hLv.setAlpha(floatValue);
                FrsFoldingView.this.hLw.setRotation((-floatValue) * 180.0f);
            }
        });
        ofFloat.setDuration(300L);
        ofFloat.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cbw() {
        this.hLs = (LinearLayout.LayoutParams) this.hLv.getLayoutParams();
        final ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.vc.FrsFoldingView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) ofFloat.getAnimatedValue()).floatValue();
                FrsFoldingView.this.hLs.height = (int) (FrsFoldingView.this.hLq * floatValue);
                FrsFoldingView.this.hLv.setLayoutParams(FrsFoldingView.this.hLs);
                FrsFoldingView.this.hLv.setAlpha(floatValue);
                FrsFoldingView.this.hLw.setRotation((-floatValue) * 180.0f);
            }
        });
        ofFloat.setDuration(300L);
        ofFloat.start();
    }

    public void setViews(List<View> list, List<com.baidu.tieba.frs.view.d> list2) {
        if (list == null || list.size() == 0) {
            throw new IllegalArgumentException("com.baidu.tieba.frs.vc.FrsFoldingView setViews(List<View> views) IllegalArgumentException");
        }
        this.hLu.removeAllViews();
        this.hLu.addView(list.get(0));
        if (list.size() > 1) {
            this.hLw.setVisibility(0);
            this.hLv.removeAllViews();
            this.hLv.addView(list.get(1));
            this.hLq = list2.get(1).getCount() * com.baidu.adp.lib.util.l.getDimens(getContext().getApplicationContext(), R.dimen.tbds83);
            return;
        }
        this.hLw.setVisibility(8);
    }

    public void onChangeSkinType() {
        am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_e);
        SvgManager.aUV().a(this.hLw, R.drawable.ic_icon_pure_open12_right_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }
}
