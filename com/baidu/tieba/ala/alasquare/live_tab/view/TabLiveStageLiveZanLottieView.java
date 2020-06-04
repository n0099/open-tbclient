package com.baidu.tieba.ala.alasquare.live_tab.view;

import android.content.Context;
import android.util.AttributeSet;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
/* loaded from: classes3.dex */
public class TabLiveStageLiveZanLottieView extends TBLottieAnimationView {
    private boolean fgV;

    public TabLiveStageLiveZanLottieView(Context context) {
        super(context);
        this.fgV = false;
    }

    public TabLiveStageLiveZanLottieView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fgV = false;
    }

    public TabLiveStageLiveZanLottieView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fgV = false;
    }

    public void setForbidAutoUpdateState(boolean z) {
        this.fgV = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.airbnb.lottie.LottieAnimationView, android.widget.ImageView, android.view.View
    public void onAttachedToWindow() {
        if (!this.fgV) {
            super.onAttachedToWindow();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.airbnb.lottie.LottieAnimationView, android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        if (!this.fgV) {
            super.onDetachedFromWindow();
        }
    }
}
