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
/* loaded from: classes7.dex */
public class AlaLiveGuardUpSlideView extends FrameLayout {
    private ImageView fnA;
    private AnimatorSet gAc;
    private ObjectAnimator gAd;
    private ObjectAnimator gAe;
    a gAf;

    /* loaded from: classes7.dex */
    public interface a {
        void mh(boolean z);
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
        setBackgroundColor(getResources().getColor(a.d.sdk_black_alpha50));
        LayoutInflater.from(context).inflate(a.h.ala_liveroom_guard_upglide_layout, this);
        this.fnA = (ImageView) findViewById(a.g.ala_liveroom_guard_image_hand);
    }

    public void bSj() {
        setVisibility(0);
        bSk();
    }

    private void bSk() {
        try {
            if (this.gAc == null) {
                this.gAc = new AnimatorSet();
                this.gAc.setDuration(2200L);
                this.gAd = ObjectAnimator.ofFloat(this.fnA, "translationY", 0.0f, -126.0f, -200.0f, -200.0f, 0.0f, 0.0f, 65.0f, 110.0f, 110.0f, 0.0f, 0.0f);
                this.gAe = ObjectAnimator.ofFloat(this.fnA, "alpha", 1.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f);
                this.gAd.setRepeatMode(1);
                this.gAd.setRepeatCount(-1);
                this.gAe.setRepeatMode(1);
                this.gAe.setRepeatCount(-1);
                this.gAc.play(this.gAd).with(this.gAe);
                this.gAc.setInterpolator(new LinearInterpolator());
                this.gAc.start();
            }
        } catch (OutOfMemoryError e) {
            System.gc();
            if (this.gAf != null) {
                this.gAf.mh(true);
            }
        }
    }

    public void setOnEndListener(a aVar) {
        this.gAf = aVar;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (getVisibility() == 8) {
            return super.onTouchEvent(motionEvent);
        }
        if (motionEvent.getAction() == 0 && this.gAf != null) {
            this.gAf.mh(false);
        }
        return true;
    }

    public void onDestroy() {
        if (this.gAc != null) {
            this.gAc.cancel();
            this.gAc = null;
        }
    }
}
