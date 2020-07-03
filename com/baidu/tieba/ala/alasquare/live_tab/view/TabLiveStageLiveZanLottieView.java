package com.baidu.tieba.ala.alasquare.live_tab.view;

import android.content.Context;
import android.util.AttributeSet;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
/* loaded from: classes3.dex */
public class TabLiveStageLiveZanLottieView extends TBLottieAnimationView {
    private boolean fsj;

    public TabLiveStageLiveZanLottieView(Context context) {
        super(context);
        this.fsj = false;
    }

    public TabLiveStageLiveZanLottieView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fsj = false;
    }

    public TabLiveStageLiveZanLottieView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fsj = false;
    }

    public void setForbidAutoUpdateState(boolean z) {
        this.fsj = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.airbnb.lottie.LottieAnimationView, android.widget.ImageView, android.view.View
    public void onAttachedToWindow() {
        if (!this.fsj) {
            super.onAttachedToWindow();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.airbnb.lottie.LottieAnimationView, android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        if (!this.fsj) {
            super.onDetachedFromWindow();
        }
    }
}
