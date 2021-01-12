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
/* loaded from: classes10.dex */
public class AlaLiveGuardUpSlideView extends FrameLayout {
    private ImageView gdY;
    private AnimatorSet hzS;
    private ObjectAnimator hzT;
    private ObjectAnimator hzU;
    a hzV;

    /* loaded from: classes10.dex */
    public interface a {
        void of(boolean z);
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
        this.gdY = (ImageView) findViewById(a.f.ala_liveroom_guard_image_hand);
    }

    public void ceM() {
        setVisibility(0);
        ceN();
    }

    private void ceN() {
        try {
            if (this.hzS == null) {
                this.hzS = new AnimatorSet();
                this.hzS.setDuration(2200L);
                this.hzT = ObjectAnimator.ofFloat(this.gdY, "translationY", 0.0f, -126.0f, -200.0f, -200.0f, 0.0f, 0.0f, 65.0f, 110.0f, 110.0f, 0.0f, 0.0f);
                this.hzU = ObjectAnimator.ofFloat(this.gdY, "alpha", 1.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f);
                this.hzT.setRepeatMode(1);
                this.hzT.setRepeatCount(-1);
                this.hzU.setRepeatMode(1);
                this.hzU.setRepeatCount(-1);
                this.hzS.play(this.hzT).with(this.hzU);
                this.hzS.setInterpolator(new LinearInterpolator());
                this.hzS.start();
            }
        } catch (OutOfMemoryError e) {
            System.gc();
            if (this.hzV != null) {
                this.hzV.of(true);
            }
        }
    }

    public void setOnEndListener(a aVar) {
        this.hzV = aVar;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (getVisibility() == 8) {
            return super.onTouchEvent(motionEvent);
        }
        if (motionEvent.getAction() == 0 && this.hzV != null) {
            this.hzV.of(false);
        }
        return true;
    }

    public void onDestroy() {
        if (this.hzS != null) {
            this.hzS.cancel();
            this.hzS = null;
        }
    }
}
