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
import com.baidu.live.k.a;
/* loaded from: classes6.dex */
public class AlaLiveGuardUpSlideView extends FrameLayout {
    private ImageView dgU;
    private AnimatorSet ehf;
    private ObjectAnimator ehg;
    private ObjectAnimator ehh;
    a ehi;

    /* loaded from: classes6.dex */
    public interface a {
        void hO(boolean z);
    }

    public AlaLiveGuardUpSlideView(Context context) {
        super(context);
        c(context, false, false);
    }

    public AlaLiveGuardUpSlideView(Context context, boolean z, boolean z2) {
        super(context);
        c(context, z, z2);
    }

    public AlaLiveGuardUpSlideView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        c(context, false, false);
    }

    public AlaLiveGuardUpSlideView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        c(context, false, false);
    }

    private void c(Context context, boolean z, boolean z2) {
        setBackgroundColor(getResources().getColor(a.d.sdk_black_alpha50));
        LayoutInflater.from(context).inflate(a.h.ala_liveroom_guard_upglide_layout, this);
        this.dgU = (ImageView) findViewById(a.g.ala_liveroom_guard_image_hand);
    }

    public void aSf() {
        setVisibility(0);
        aSg();
    }

    private void aSg() {
        try {
            if (this.ehf == null) {
                this.ehf = new AnimatorSet();
                this.ehf.setDuration(2200L);
                this.ehg = ObjectAnimator.ofFloat(this.dgU, "translationY", 0.0f, -126.0f, -200.0f, -200.0f, 0.0f, 0.0f, 65.0f, 110.0f, 110.0f, 0.0f, 0.0f);
                this.ehh = ObjectAnimator.ofFloat(this.dgU, "alpha", 1.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f);
                this.ehg.setRepeatMode(1);
                this.ehg.setRepeatCount(-1);
                this.ehh.setRepeatMode(1);
                this.ehh.setRepeatCount(-1);
                this.ehf.play(this.ehg).with(this.ehh);
                this.ehf.setInterpolator(new LinearInterpolator());
                this.ehf.start();
            }
        } catch (OutOfMemoryError e) {
            System.gc();
            if (this.ehi != null) {
                this.ehi.hO(true);
            }
        }
    }

    public void setOnEndListener(a aVar) {
        this.ehi = aVar;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (getVisibility() == 8) {
            return super.onTouchEvent(motionEvent);
        }
        if (motionEvent.getAction() == 0 && this.ehi != null) {
            this.ehi.hO(false);
        }
        return true;
    }

    public void onDestroy() {
        if (this.ehf != null) {
            this.ehf.cancel();
            this.ehf = null;
        }
    }
}
