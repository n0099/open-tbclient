package com.baidu.tieba.ala.alasquare.live_tab.view;

import android.content.Context;
import android.util.AttributeSet;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
/* loaded from: classes4.dex */
public class TabLiveStageLiveZanLottieView extends TBLottieAnimationView {
    public boolean l;

    public TabLiveStageLiveZanLottieView(Context context) {
        super(context);
        this.l = false;
    }

    @Override // com.airbnb.lottie.LottieAnimationView, android.widget.ImageView, android.view.View
    public void onAttachedToWindow() {
        if (this.l) {
            return;
        }
        super.onAttachedToWindow();
    }

    @Override // com.airbnb.lottie.LottieAnimationView, android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        if (this.l) {
            return;
        }
        super.onDetachedFromWindow();
    }

    public void setForbidAutoUpdateState(boolean z) {
        this.l = z;
    }

    public TabLiveStageLiveZanLottieView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.l = false;
    }

    public TabLiveStageLiveZanLottieView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.l = false;
    }
}
