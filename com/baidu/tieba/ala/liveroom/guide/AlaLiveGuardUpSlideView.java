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
    private ImageView dYH;
    private AnimatorSet fcX;
    private ObjectAnimator fcY;
    private ObjectAnimator fcZ;
    a fda;

    /* loaded from: classes3.dex */
    public interface a {
        void jt(boolean z);
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
        this.dYH = (ImageView) findViewById(a.g.ala_liveroom_guard_image_hand);
    }

    public void bmC() {
        setVisibility(0);
        bmD();
    }

    private void bmD() {
        try {
            if (this.fcX == null) {
                this.fcX = new AnimatorSet();
                this.fcX.setDuration(2200L);
                this.fcY = ObjectAnimator.ofFloat(this.dYH, "translationY", 0.0f, -126.0f, -200.0f, -200.0f, 0.0f, 0.0f, 65.0f, 110.0f, 110.0f, 0.0f, 0.0f);
                this.fcZ = ObjectAnimator.ofFloat(this.dYH, "alpha", 1.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f);
                this.fcY.setRepeatMode(1);
                this.fcY.setRepeatCount(-1);
                this.fcZ.setRepeatMode(1);
                this.fcZ.setRepeatCount(-1);
                this.fcX.play(this.fcY).with(this.fcZ);
                this.fcX.setInterpolator(new LinearInterpolator());
                this.fcX.start();
            }
        } catch (OutOfMemoryError e) {
            System.gc();
            if (this.fda != null) {
                this.fda.jt(true);
            }
        }
    }

    public void setOnEndListener(a aVar) {
        this.fda = aVar;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (getVisibility() == 8) {
            return super.onTouchEvent(motionEvent);
        }
        if (motionEvent.getAction() == 0 && this.fda != null) {
            this.fda.jt(false);
        }
        return true;
    }

    public void onDestroy() {
        if (this.fcX != null) {
            this.fcX.cancel();
            this.fcX = null;
        }
    }
}
