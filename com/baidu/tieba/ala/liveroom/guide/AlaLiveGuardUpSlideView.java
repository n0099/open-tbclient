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
    private ImageView ghV;
    private AnimatorSet hFZ;
    private ObjectAnimator hGa;
    private ObjectAnimator hGb;
    a hGc;

    /* loaded from: classes10.dex */
    public interface a {
        void op(boolean z);
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
        this.ghV = (ImageView) findViewById(a.f.ala_liveroom_guard_image_hand);
    }

    public void cfS() {
        setVisibility(0);
        cfT();
    }

    private void cfT() {
        try {
            if (this.hFZ == null) {
                this.hFZ = new AnimatorSet();
                this.hFZ.setDuration(2200L);
                this.hGa = ObjectAnimator.ofFloat(this.ghV, "translationY", 0.0f, -126.0f, -200.0f, -200.0f, 0.0f, 0.0f, 65.0f, 110.0f, 110.0f, 0.0f, 0.0f);
                this.hGb = ObjectAnimator.ofFloat(this.ghV, "alpha", 1.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f);
                this.hGa.setRepeatMode(1);
                this.hGa.setRepeatCount(-1);
                this.hGb.setRepeatMode(1);
                this.hGb.setRepeatCount(-1);
                this.hFZ.play(this.hGa).with(this.hGb);
                this.hFZ.setInterpolator(new LinearInterpolator());
                this.hFZ.start();
            }
        } catch (OutOfMemoryError e) {
            System.gc();
            if (this.hGc != null) {
                this.hGc.op(true);
            }
        }
    }

    public void setOnEndListener(a aVar) {
        this.hGc = aVar;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (getVisibility() == 8) {
            return super.onTouchEvent(motionEvent);
        }
        if (motionEvent.getAction() == 0 && this.hGc != null) {
            this.hGc.op(false);
        }
        return true;
    }

    public void onDestroy() {
        if (this.hFZ != null) {
            this.hFZ.cancel();
            this.hFZ = null;
        }
    }
}
