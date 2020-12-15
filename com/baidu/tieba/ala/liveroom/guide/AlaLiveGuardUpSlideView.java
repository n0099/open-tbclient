package com.baidu.tieba.ala.liveroom.guide;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.baidu.live.sdk.a;
/* loaded from: classes4.dex */
public class AlaLiveGuardUpSlideView extends FrameLayout {
    private ImageView fZa;
    private AnimatorSet hsD;
    private ObjectAnimator hsE;
    private ObjectAnimator hsF;
    a hsG;

    /* loaded from: classes4.dex */
    public interface a {
        void nJ(boolean z);
    }

    public AlaLiveGuardUpSlideView(Context context) {
        super(context);
        b(context, false, false);
    }

    public AlaLiveGuardUpSlideView(Context context, boolean z, boolean z2) {
        super(context);
        b(context, z, z2);
    }

    public AlaLiveGuardUpSlideView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b(context, false, false);
    }

    public AlaLiveGuardUpSlideView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        b(context, false, false);
    }

    private void b(Context context, boolean z, boolean z2) {
        setBackgroundColor(getResources().getColor(a.c.sdk_black_alpha50));
        LayoutInflater.from(context).inflate(a.g.ala_liveroom_guard_upglide_layout, this);
        this.fZa = (ImageView) findViewById(a.f.ala_liveroom_guard_image_hand);
    }

    public void cfN() {
        setVisibility(0);
        cfO();
    }

    private void cfO() {
        try {
            if (this.hsD == null) {
                this.hsD = new AnimatorSet();
                this.hsD.setDuration(2200L);
                this.hsE = ObjectAnimator.ofFloat(this.fZa, "translationY", 0.0f, -126.0f, -200.0f, -200.0f, 0.0f, 0.0f, 65.0f, 110.0f, 110.0f, 0.0f, 0.0f);
                this.hsF = ObjectAnimator.ofFloat(this.fZa, "alpha", 1.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f);
                this.hsE.setRepeatMode(1);
                this.hsE.setRepeatCount(-1);
                this.hsF.setRepeatMode(1);
                this.hsF.setRepeatCount(-1);
                this.hsD.play(this.hsE).with(this.hsF);
                this.hsD.setInterpolator(new LinearInterpolator());
                this.hsD.start();
            }
        } catch (OutOfMemoryError e) {
            System.gc();
            if (this.hsG != null) {
                this.hsG.nJ(true);
            }
        }
    }

    public void setOnEndListener(a aVar) {
        this.hsG = aVar;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (getVisibility() == 8) {
            return super.onTouchEvent(motionEvent);
        }
        if (motionEvent.getAction() == 0 && this.hsG != null) {
            this.hsG.nJ(false);
        }
        return true;
    }

    public void onDestroy() {
        if (this.hsD != null) {
            this.hsD.cancel();
            this.hsD = null;
        }
    }
}
