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
/* loaded from: classes11.dex */
public class AlaLiveGuardUpSlideView extends FrameLayout {
    private ImageView giH;
    private ObjectAnimator hEA;
    a hEB;
    private AnimatorSet hEy;
    private ObjectAnimator hEz;

    /* loaded from: classes11.dex */
    public interface a {
        void oj(boolean z);
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
        this.giH = (ImageView) findViewById(a.f.ala_liveroom_guard_image_hand);
    }

    public void ciE() {
        setVisibility(0);
        ciF();
    }

    private void ciF() {
        try {
            if (this.hEy == null) {
                this.hEy = new AnimatorSet();
                this.hEy.setDuration(2200L);
                this.hEz = ObjectAnimator.ofFloat(this.giH, "translationY", 0.0f, -126.0f, -200.0f, -200.0f, 0.0f, 0.0f, 65.0f, 110.0f, 110.0f, 0.0f, 0.0f);
                this.hEA = ObjectAnimator.ofFloat(this.giH, "alpha", 1.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f);
                this.hEz.setRepeatMode(1);
                this.hEz.setRepeatCount(-1);
                this.hEA.setRepeatMode(1);
                this.hEA.setRepeatCount(-1);
                this.hEy.play(this.hEz).with(this.hEA);
                this.hEy.setInterpolator(new LinearInterpolator());
                this.hEy.start();
            }
        } catch (OutOfMemoryError e) {
            System.gc();
            if (this.hEB != null) {
                this.hEB.oj(true);
            }
        }
    }

    public void setOnEndListener(a aVar) {
        this.hEB = aVar;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (getVisibility() == 8) {
            return super.onTouchEvent(motionEvent);
        }
        if (motionEvent.getAction() == 0 && this.hEB != null) {
            this.hEB.oj(false);
        }
        return true;
    }

    public void onDestroy() {
        if (this.hEy != null) {
            this.hEy.cancel();
            this.hEy = null;
        }
    }
}
