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
    private ImageView ggs;
    private AnimatorSet hEq;
    private ObjectAnimator hEr;
    private ObjectAnimator hEs;
    a hEt;

    /* loaded from: classes11.dex */
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
        this.ggs = (ImageView) findViewById(a.f.ala_liveroom_guard_image_hand);
    }

    public void cfM() {
        setVisibility(0);
        cfN();
    }

    private void cfN() {
        try {
            if (this.hEq == null) {
                this.hEq = new AnimatorSet();
                this.hEq.setDuration(2200L);
                this.hEr = ObjectAnimator.ofFloat(this.ggs, "translationY", 0.0f, -126.0f, -200.0f, -200.0f, 0.0f, 0.0f, 65.0f, 110.0f, 110.0f, 0.0f, 0.0f);
                this.hEs = ObjectAnimator.ofFloat(this.ggs, "alpha", 1.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f);
                this.hEr.setRepeatMode(1);
                this.hEr.setRepeatCount(-1);
                this.hEs.setRepeatMode(1);
                this.hEs.setRepeatCount(-1);
                this.hEq.play(this.hEr).with(this.hEs);
                this.hEq.setInterpolator(new LinearInterpolator());
                this.hEq.start();
            }
        } catch (OutOfMemoryError e) {
            System.gc();
            if (this.hEt != null) {
                this.hEt.op(true);
            }
        }
    }

    public void setOnEndListener(a aVar) {
        this.hEt = aVar;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (getVisibility() == 8) {
            return super.onTouchEvent(motionEvent);
        }
        if (motionEvent.getAction() == 0 && this.hEt != null) {
            this.hEt.op(false);
        }
        return true;
    }

    public void onDestroy() {
        if (this.hEq != null) {
            this.hEq.cancel();
            this.hEq = null;
        }
    }
}
