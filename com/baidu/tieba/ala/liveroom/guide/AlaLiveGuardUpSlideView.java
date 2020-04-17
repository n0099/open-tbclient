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
    private ImageView eyE;
    private AnimatorSet fHg;
    private ObjectAnimator fHh;
    private ObjectAnimator fHi;
    a fHj;

    /* loaded from: classes3.dex */
    public interface a {
        void ku(boolean z);
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
        this.eyE = (ImageView) findViewById(a.g.ala_liveroom_guard_image_hand);
    }

    public void bvT() {
        setVisibility(0);
        bvU();
    }

    private void bvU() {
        try {
            if (this.fHg == null) {
                this.fHg = new AnimatorSet();
                this.fHg.setDuration(2200L);
                this.fHh = ObjectAnimator.ofFloat(this.eyE, "translationY", 0.0f, -126.0f, -200.0f, -200.0f, 0.0f, 0.0f, 65.0f, 110.0f, 110.0f, 0.0f, 0.0f);
                this.fHi = ObjectAnimator.ofFloat(this.eyE, "alpha", 1.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f);
                this.fHh.setRepeatMode(1);
                this.fHh.setRepeatCount(-1);
                this.fHi.setRepeatMode(1);
                this.fHi.setRepeatCount(-1);
                this.fHg.play(this.fHh).with(this.fHi);
                this.fHg.setInterpolator(new LinearInterpolator());
                this.fHg.start();
            }
        } catch (OutOfMemoryError e) {
            System.gc();
            if (this.fHj != null) {
                this.fHj.ku(true);
            }
        }
    }

    public void setOnEndListener(a aVar) {
        this.fHj = aVar;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (getVisibility() == 8) {
            return super.onTouchEvent(motionEvent);
        }
        if (motionEvent.getAction() == 0 && this.fHj != null) {
            this.fHj.ku(false);
        }
        return true;
    }

    public void onDestroy() {
        if (this.fHg != null) {
            this.fHg.cancel();
            this.fHg = null;
        }
    }
}
