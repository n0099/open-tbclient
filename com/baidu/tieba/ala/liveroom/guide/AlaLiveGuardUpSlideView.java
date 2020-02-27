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
import com.baidu.live.u.a;
/* loaded from: classes3.dex */
public class AlaLiveGuardUpSlideView extends FrameLayout {
    private ImageView dYd;
    private AnimatorSet fcl;
    private ObjectAnimator fcm;
    private ObjectAnimator fcn;
    a fco;

    /* loaded from: classes3.dex */
    public interface a {
        void jr(boolean z);
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
        this.dYd = (ImageView) findViewById(a.g.ala_liveroom_guard_image_hand);
    }

    public void bmu() {
        setVisibility(0);
        bmv();
    }

    private void bmv() {
        try {
            if (this.fcl == null) {
                this.fcl = new AnimatorSet();
                this.fcl.setDuration(2200L);
                this.fcm = ObjectAnimator.ofFloat(this.dYd, "translationY", 0.0f, -126.0f, -200.0f, -200.0f, 0.0f, 0.0f, 65.0f, 110.0f, 110.0f, 0.0f, 0.0f);
                this.fcn = ObjectAnimator.ofFloat(this.dYd, "alpha", 1.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f);
                this.fcm.setRepeatMode(1);
                this.fcm.setRepeatCount(-1);
                this.fcn.setRepeatMode(1);
                this.fcn.setRepeatCount(-1);
                this.fcl.play(this.fcm).with(this.fcn);
                this.fcl.setInterpolator(new LinearInterpolator());
                this.fcl.start();
            }
        } catch (OutOfMemoryError e) {
            System.gc();
            if (this.fco != null) {
                this.fco.jr(true);
            }
        }
    }

    public void setOnEndListener(a aVar) {
        this.fco = aVar;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (getVisibility() == 8) {
            return super.onTouchEvent(motionEvent);
        }
        if (motionEvent.getAction() == 0 && this.fco != null) {
            this.fco.jr(false);
        }
        return true;
    }

    public void onDestroy() {
        if (this.fcl != null) {
            this.fcl.cancel();
            this.fcl = null;
        }
    }
}
