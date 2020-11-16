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
/* loaded from: classes4.dex */
public class AlaLiveGuardUpSlideView extends FrameLayout {
    private ImageView fQP;
    private AnimatorSet hje;
    private ObjectAnimator hjf;
    private ObjectAnimator hjg;
    a hjh;

    /* loaded from: classes4.dex */
    public interface a {
        void no(boolean z);
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
        this.fQP = (ImageView) findViewById(a.f.ala_liveroom_guard_image_hand);
    }

    public void cbU() {
        setVisibility(0);
        cbV();
    }

    private void cbV() {
        try {
            if (this.hje == null) {
                this.hje = new AnimatorSet();
                this.hje.setDuration(2200L);
                this.hjf = ObjectAnimator.ofFloat(this.fQP, "translationY", 0.0f, -126.0f, -200.0f, -200.0f, 0.0f, 0.0f, 65.0f, 110.0f, 110.0f, 0.0f, 0.0f);
                this.hjg = ObjectAnimator.ofFloat(this.fQP, "alpha", 1.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f);
                this.hjf.setRepeatMode(1);
                this.hjf.setRepeatCount(-1);
                this.hjg.setRepeatMode(1);
                this.hjg.setRepeatCount(-1);
                this.hje.play(this.hjf).with(this.hjg);
                this.hje.setInterpolator(new LinearInterpolator());
                this.hje.start();
            }
        } catch (OutOfMemoryError e) {
            System.gc();
            if (this.hjh != null) {
                this.hjh.no(true);
            }
        }
    }

    public void setOnEndListener(a aVar) {
        this.hjh = aVar;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (getVisibility() == 8) {
            return super.onTouchEvent(motionEvent);
        }
        if (motionEvent.getAction() == 0 && this.hjh != null) {
            this.hjh.no(false);
        }
        return true;
    }

    public void onDestroy() {
        if (this.hje != null) {
            this.hje.cancel();
            this.hje = null;
        }
    }
}
