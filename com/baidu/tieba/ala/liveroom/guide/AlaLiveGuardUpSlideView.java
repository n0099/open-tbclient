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
    private ImageView fRh;
    a hjA;
    private AnimatorSet hjx;
    private ObjectAnimator hjy;
    private ObjectAnimator hjz;

    /* loaded from: classes4.dex */
    public interface a {
        void nn(boolean z);
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
        this.fRh = (ImageView) findViewById(a.f.ala_liveroom_guard_image_hand);
    }

    public void ccB() {
        setVisibility(0);
        ccC();
    }

    private void ccC() {
        try {
            if (this.hjx == null) {
                this.hjx = new AnimatorSet();
                this.hjx.setDuration(2200L);
                this.hjy = ObjectAnimator.ofFloat(this.fRh, "translationY", 0.0f, -126.0f, -200.0f, -200.0f, 0.0f, 0.0f, 65.0f, 110.0f, 110.0f, 0.0f, 0.0f);
                this.hjz = ObjectAnimator.ofFloat(this.fRh, "alpha", 1.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f);
                this.hjy.setRepeatMode(1);
                this.hjy.setRepeatCount(-1);
                this.hjz.setRepeatMode(1);
                this.hjz.setRepeatCount(-1);
                this.hjx.play(this.hjy).with(this.hjz);
                this.hjx.setInterpolator(new LinearInterpolator());
                this.hjx.start();
            }
        } catch (OutOfMemoryError e) {
            System.gc();
            if (this.hjA != null) {
                this.hjA.nn(true);
            }
        }
    }

    public void setOnEndListener(a aVar) {
        this.hjA = aVar;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (getVisibility() == 8) {
            return super.onTouchEvent(motionEvent);
        }
        if (motionEvent.getAction() == 0 && this.hjA != null) {
            this.hjA.nn(false);
        }
        return true;
    }

    public void onDestroy() {
        if (this.hjx != null) {
            this.hjx.cancel();
            this.hjx = null;
        }
    }
}
