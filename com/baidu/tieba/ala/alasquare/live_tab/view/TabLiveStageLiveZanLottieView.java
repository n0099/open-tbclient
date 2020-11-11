package com.baidu.tieba.ala.alasquare.live_tab.view;

import android.content.Context;
import android.util.AttributeSet;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
/* loaded from: classes4.dex */
public class TabLiveStageLiveZanLottieView extends TBLottieAnimationView {
    private boolean gol;

    public TabLiveStageLiveZanLottieView(Context context) {
        super(context);
        this.gol = false;
    }

    public TabLiveStageLiveZanLottieView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gol = false;
    }

    public TabLiveStageLiveZanLottieView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gol = false;
    }

    public void setForbidAutoUpdateState(boolean z) {
        this.gol = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.airbnb.lottie.LottieAnimationView, android.widget.ImageView, android.view.View
    public void onAttachedToWindow() {
        if (!this.gol) {
            super.onAttachedToWindow();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.airbnb.lottie.LottieAnimationView, android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        if (!this.gol) {
            super.onDetachedFromWindow();
        }
    }
}
