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
import com.baidu.live.q.a;
/* loaded from: classes2.dex */
public class AlaLiveGuardUpSlideView extends FrameLayout {
    private ImageView dTP;
    private ObjectAnimator eWA;
    a eWB;
    private AnimatorSet eWy;
    private ObjectAnimator eWz;

    /* loaded from: classes2.dex */
    public interface a {
        void je(boolean z);
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
        this.dTP = (ImageView) findViewById(a.g.ala_liveroom_guard_image_hand);
    }

    public void bjO() {
        setVisibility(0);
        bjP();
    }

    private void bjP() {
        try {
            if (this.eWy == null) {
                this.eWy = new AnimatorSet();
                this.eWy.setDuration(2200L);
                this.eWz = ObjectAnimator.ofFloat(this.dTP, "translationY", 0.0f, -126.0f, -200.0f, -200.0f, 0.0f, 0.0f, 65.0f, 110.0f, 110.0f, 0.0f, 0.0f);
                this.eWA = ObjectAnimator.ofFloat(this.dTP, "alpha", 1.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f);
                this.eWz.setRepeatMode(1);
                this.eWz.setRepeatCount(-1);
                this.eWA.setRepeatMode(1);
                this.eWA.setRepeatCount(-1);
                this.eWy.play(this.eWz).with(this.eWA);
                this.eWy.setInterpolator(new LinearInterpolator());
                this.eWy.start();
            }
        } catch (OutOfMemoryError e) {
            System.gc();
            if (this.eWB != null) {
                this.eWB.je(true);
            }
        }
    }

    public void setOnEndListener(a aVar) {
        this.eWB = aVar;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (getVisibility() == 8) {
            return super.onTouchEvent(motionEvent);
        }
        if (motionEvent.getAction() == 0 && this.eWB != null) {
            this.eWB.je(false);
        }
        return true;
    }

    public void onDestroy() {
        if (this.eWy != null) {
            this.eWy.cancel();
            this.eWy = null;
        }
    }
}
