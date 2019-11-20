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
    private ImageView dgd;
    private AnimatorSet ego;
    private ObjectAnimator egp;
    private ObjectAnimator egq;
    a egr;

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
        this.dgd = (ImageView) findViewById(a.g.ala_liveroom_guard_image_hand);
    }

    public void aSd() {
        setVisibility(0);
        aSe();
    }

    private void aSe() {
        try {
            if (this.ego == null) {
                this.ego = new AnimatorSet();
                this.ego.setDuration(2200L);
                this.egp = ObjectAnimator.ofFloat(this.dgd, "translationY", 0.0f, -126.0f, -200.0f, -200.0f, 0.0f, 0.0f, 65.0f, 110.0f, 110.0f, 0.0f, 0.0f);
                this.egq = ObjectAnimator.ofFloat(this.dgd, "alpha", 1.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f);
                this.egp.setRepeatMode(1);
                this.egp.setRepeatCount(-1);
                this.egq.setRepeatMode(1);
                this.egq.setRepeatCount(-1);
                this.ego.play(this.egp).with(this.egq);
                this.ego.setInterpolator(new LinearInterpolator());
                this.ego.start();
            }
        } catch (OutOfMemoryError e) {
            System.gc();
            if (this.egr != null) {
                this.egr.hO(true);
            }
        }
    }

    public void setOnEndListener(a aVar) {
        this.egr = aVar;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (getVisibility() == 8) {
            return super.onTouchEvent(motionEvent);
        }
        if (motionEvent.getAction() == 0 && this.egr != null) {
            this.egr.hO(false);
        }
        return true;
    }

    public void onDestroy() {
        if (this.ego != null) {
            this.ego.cancel();
            this.ego = null;
        }
    }
}
