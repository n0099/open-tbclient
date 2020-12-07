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
    private ImageView fYY;
    private AnimatorSet hsB;
    private ObjectAnimator hsC;
    private ObjectAnimator hsD;
    a hsE;

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
        this.fYY = (ImageView) findViewById(a.f.ala_liveroom_guard_image_hand);
    }

    public void cfM() {
        setVisibility(0);
        cfN();
    }

    private void cfN() {
        try {
            if (this.hsB == null) {
                this.hsB = new AnimatorSet();
                this.hsB.setDuration(2200L);
                this.hsC = ObjectAnimator.ofFloat(this.fYY, "translationY", 0.0f, -126.0f, -200.0f, -200.0f, 0.0f, 0.0f, 65.0f, 110.0f, 110.0f, 0.0f, 0.0f);
                this.hsD = ObjectAnimator.ofFloat(this.fYY, "alpha", 1.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f);
                this.hsC.setRepeatMode(1);
                this.hsC.setRepeatCount(-1);
                this.hsD.setRepeatMode(1);
                this.hsD.setRepeatCount(-1);
                this.hsB.play(this.hsC).with(this.hsD);
                this.hsB.setInterpolator(new LinearInterpolator());
                this.hsB.start();
            }
        } catch (OutOfMemoryError e) {
            System.gc();
            if (this.hsE != null) {
                this.hsE.nJ(true);
            }
        }
    }

    public void setOnEndListener(a aVar) {
        this.hsE = aVar;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (getVisibility() == 8) {
            return super.onTouchEvent(motionEvent);
        }
        if (motionEvent.getAction() == 0 && this.hsE != null) {
            this.hsE.nJ(false);
        }
        return true;
    }

    public void onDestroy() {
        if (this.hsB != null) {
            this.hsB.cancel();
            this.hsB = null;
        }
    }
}
