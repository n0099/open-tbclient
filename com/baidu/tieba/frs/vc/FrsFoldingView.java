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
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes21.dex */
public class FrsFoldingView extends LinearLayout {
    private int jiW;
    private boolean jiX;
    private LinearLayout.LayoutParams jiY;
    private LinearLayout jiZ;
    private FrameLayout jja;
    private FrameLayout jjb;
    private ImageView jjc;
    private View mRootView;

    public FrsFoldingView(Context context) {
        this(context, null);
    }

    public FrsFoldingView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FrsFoldingView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jiW = 0;
        this.jiX = true;
        init();
    }

    private void init() {
        initView();
        cFa();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(getContext()).inflate(R.layout.folding_view_layout, (ViewGroup) this, true);
        this.jiZ = (LinearLayout) this.mRootView.findViewById(R.id.folding_root_layout);
        this.jja = (FrameLayout) this.mRootView.findViewById(R.id.permanent_layout);
        this.jjb = (FrameLayout) this.mRootView.findViewById(R.id.collapsible_layout);
        this.jjc = (ImageView) this.mRootView.findViewById(R.id.folding_arrow);
        SvgManager.bqB().a(this.jjc, R.drawable.icon_pure_unfold12_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    private void cFa() {
        this.mRootView.findViewById(R.id.folding_arrow).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.FrsFoldingView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (FrsFoldingView.this.jiX) {
                    FrsFoldingView.this.cFb();
                    FrsFoldingView.this.jiX = false;
                    return;
                }
                FrsFoldingView.this.cFc();
                FrsFoldingView.this.jiX = true;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cFb() {
        this.jiY = (LinearLayout.LayoutParams) this.jjb.getLayoutParams();
        final ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.vc.FrsFoldingView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) ofFloat.getAnimatedValue()).floatValue();
                FrsFoldingView.this.jiY.height = (int) (FrsFoldingView.this.jiW * floatValue);
                FrsFoldingView.this.jjb.setLayoutParams(FrsFoldingView.this.jiY);
                FrsFoldingView.this.jjb.setAlpha(floatValue);
                FrsFoldingView.this.jjc.setRotation((-floatValue) * 180.0f);
            }
        });
        ofFloat.setDuration(300L);
        ofFloat.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cFc() {
        this.jiY = (LinearLayout.LayoutParams) this.jjb.getLayoutParams();
        final ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.vc.FrsFoldingView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) ofFloat.getAnimatedValue()).floatValue();
                FrsFoldingView.this.jiY.height = (int) (FrsFoldingView.this.jiW * floatValue);
                FrsFoldingView.this.jjb.setLayoutParams(FrsFoldingView.this.jiY);
                FrsFoldingView.this.jjb.setAlpha(floatValue);
                FrsFoldingView.this.jjc.setRotation((-floatValue) * 180.0f);
            }
        });
        ofFloat.setDuration(300L);
        ofFloat.start();
    }

    public void setViews(List<View> list, List<com.baidu.tieba.frs.view.g> list2) {
        this.jja.removeAllViews();
        this.jja.addView(list.get(0));
        if (list.size() > 1) {
            this.jjc.setVisibility(0);
            this.jjb.removeAllViews();
            this.jjb.addView(list.get(1));
            this.jiW = list2.get(1).getCount() * com.baidu.adp.lib.util.l.getDimens(getContext().getApplicationContext(), R.dimen.tbds93);
            return;
        }
        this.jjc.setVisibility(8);
    }

    public void onChangeSkinType() {
        SvgManager.bqB().a(this.jjc, R.drawable.icon_pure_unfold12_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }
}
