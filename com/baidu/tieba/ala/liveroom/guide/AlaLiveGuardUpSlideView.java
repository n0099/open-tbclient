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
    private ImageView dYe;
    private AnimatorSet fcm;
    private ObjectAnimator fcn;
    private ObjectAnimator fco;
    a fcp;

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
        this.dYe = (ImageView) findViewById(a.g.ala_liveroom_guard_image_hand);
    }

    public void bmw() {
        setVisibility(0);
        bmx();
    }

    private void bmx() {
        try {
            if (this.fcm == null) {
                this.fcm = new AnimatorSet();
                this.fcm.setDuration(2200L);
                this.fcn = ObjectAnimator.ofFloat(this.dYe, "translationY", 0.0f, -126.0f, -200.0f, -200.0f, 0.0f, 0.0f, 65.0f, 110.0f, 110.0f, 0.0f, 0.0f);
                this.fco = ObjectAnimator.ofFloat(this.dYe, "alpha", 1.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f);
                this.fcn.setRepeatMode(1);
                this.fcn.setRepeatCount(-1);
                this.fco.setRepeatMode(1);
                this.fco.setRepeatCount(-1);
                this.fcm.play(this.fcn).with(this.fco);
                this.fcm.setInterpolator(new LinearInterpolator());
                this.fcm.start();
            }
        } catch (OutOfMemoryError e) {
            System.gc();
            if (this.fcp != null) {
                this.fcp.jr(true);
            }
        }
    }

    public void setOnEndListener(a aVar) {
        this.fcp = aVar;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (getVisibility() == 8) {
            return super.onTouchEvent(motionEvent);
        }
        if (motionEvent.getAction() == 0 && this.fcp != null) {
            this.fcp.jr(false);
        }
        return true;
    }

    public void onDestroy() {
        if (this.fcm != null) {
            this.fcm.cancel();
            this.fcm = null;
        }
    }
}
