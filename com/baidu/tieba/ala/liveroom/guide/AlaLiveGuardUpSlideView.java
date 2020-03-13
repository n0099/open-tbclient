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
    private ImageView dYr;
    private ObjectAnimator fcA;
    private ObjectAnimator fcB;
    a fcC;
    private AnimatorSet fcz;

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
        this.dYr = (ImageView) findViewById(a.g.ala_liveroom_guard_image_hand);
    }

    public void bmx() {
        setVisibility(0);
        bmy();
    }

    private void bmy() {
        try {
            if (this.fcz == null) {
                this.fcz = new AnimatorSet();
                this.fcz.setDuration(2200L);
                this.fcA = ObjectAnimator.ofFloat(this.dYr, "translationY", 0.0f, -126.0f, -200.0f, -200.0f, 0.0f, 0.0f, 65.0f, 110.0f, 110.0f, 0.0f, 0.0f);
                this.fcB = ObjectAnimator.ofFloat(this.dYr, "alpha", 1.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f);
                this.fcA.setRepeatMode(1);
                this.fcA.setRepeatCount(-1);
                this.fcB.setRepeatMode(1);
                this.fcB.setRepeatCount(-1);
                this.fcz.play(this.fcA).with(this.fcB);
                this.fcz.setInterpolator(new LinearInterpolator());
                this.fcz.start();
            }
        } catch (OutOfMemoryError e) {
            System.gc();
            if (this.fcC != null) {
                this.fcC.jr(true);
            }
        }
    }

    public void setOnEndListener(a aVar) {
        this.fcC = aVar;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (getVisibility() == 8) {
            return super.onTouchEvent(motionEvent);
        }
        if (motionEvent.getAction() == 0 && this.fcC != null) {
            this.fcC.jr(false);
        }
        return true;
    }

    public void onDestroy() {
        if (this.fcz != null) {
            this.fcz.cancel();
            this.fcz = null;
        }
    }
}
