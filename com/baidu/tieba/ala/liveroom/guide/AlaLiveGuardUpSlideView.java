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
    private ImageView eNu;
    private AnimatorSet fVr;
    private ObjectAnimator fVs;
    private ObjectAnimator fVt;
    a fVu;

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
        this.eNu = (ImageView) findViewById(a.g.ala_liveroom_guard_image_hand);
    }

    public void bBS() {
        setVisibility(0);
        bBT();
    }

    private void bBT() {
        try {
            if (this.fVr == null) {
                this.fVr = new AnimatorSet();
                this.fVr.setDuration(2200L);
                this.fVs = ObjectAnimator.ofFloat(this.eNu, "translationY", 0.0f, -126.0f, -200.0f, -200.0f, 0.0f, 0.0f, 65.0f, 110.0f, 110.0f, 0.0f, 0.0f);
                this.fVt = ObjectAnimator.ofFloat(this.eNu, "alpha", 1.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f);
                this.fVs.setRepeatMode(1);
                this.fVs.setRepeatCount(-1);
                this.fVt.setRepeatMode(1);
                this.fVt.setRepeatCount(-1);
                this.fVr.play(this.fVs).with(this.fVt);
                this.fVr.setInterpolator(new LinearInterpolator());
                this.fVr.start();
            }
        } catch (OutOfMemoryError e) {
            System.gc();
            if (this.fVu != null) {
                this.fVu.kP(true);
            }
        }
    }

    public void setOnEndListener(a aVar) {
        this.fVu = aVar;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (getVisibility() == 8) {
            return super.onTouchEvent(motionEvent);
        }
        if (motionEvent.getAction() == 0 && this.fVu != null) {
            this.fVu.kP(false);
        }
        return true;
    }

    public void onDestroy() {
        if (this.fVr != null) {
            this.fVr.cancel();
            this.fVr = null;
        }
    }
}
