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
    private ImageView eNj;
    private AnimatorSet fVg;
    private ObjectAnimator fVh;
    private ObjectAnimator fVi;
    a fVj;

    /* loaded from: classes3.dex */
    public interface a {
        void kP(boolean z);
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
        this.eNj = (ImageView) findViewById(a.g.ala_liveroom_guard_image_hand);
    }

    public void bBQ() {
        setVisibility(0);
        bBR();
    }

    private void bBR() {
        try {
            if (this.fVg == null) {
                this.fVg = new AnimatorSet();
                this.fVg.setDuration(2200L);
                this.fVh = ObjectAnimator.ofFloat(this.eNj, "translationY", 0.0f, -126.0f, -200.0f, -200.0f, 0.0f, 0.0f, 65.0f, 110.0f, 110.0f, 0.0f, 0.0f);
                this.fVi = ObjectAnimator.ofFloat(this.eNj, "alpha", 1.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f);
                this.fVh.setRepeatMode(1);
                this.fVh.setRepeatCount(-1);
                this.fVi.setRepeatMode(1);
                this.fVi.setRepeatCount(-1);
                this.fVg.play(this.fVh).with(this.fVi);
                this.fVg.setInterpolator(new LinearInterpolator());
                this.fVg.start();
            }
        } catch (OutOfMemoryError e) {
            System.gc();
            if (this.fVj != null) {
                this.fVj.kP(true);
            }
        }
    }

    public void setOnEndListener(a aVar) {
        this.fVj = aVar;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (getVisibility() == 8) {
            return super.onTouchEvent(motionEvent);
        }
        if (motionEvent.getAction() == 0 && this.fVj != null) {
            this.fVj.kP(false);
        }
        return true;
    }

    public void onDestroy() {
        if (this.fVg != null) {
            this.fVg.cancel();
            this.fVg = null;
        }
    }
}
