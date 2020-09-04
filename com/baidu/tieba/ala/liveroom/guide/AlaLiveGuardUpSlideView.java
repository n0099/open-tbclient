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
/* loaded from: classes7.dex */
public class AlaLiveGuardUpSlideView extends FrameLayout {
    private ImageView fnE;
    private AnimatorSet gAg;
    private ObjectAnimator gAh;
    private ObjectAnimator gAi;
    a gAj;

    /* loaded from: classes7.dex */
    public interface a {
        void mj(boolean z);
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
        this.fnE = (ImageView) findViewById(a.g.ala_liveroom_guard_image_hand);
    }

    public void bSk() {
        setVisibility(0);
        bSl();
    }

    private void bSl() {
        try {
            if (this.gAg == null) {
                this.gAg = new AnimatorSet();
                this.gAg.setDuration(2200L);
                this.gAh = ObjectAnimator.ofFloat(this.fnE, "translationY", 0.0f, -126.0f, -200.0f, -200.0f, 0.0f, 0.0f, 65.0f, 110.0f, 110.0f, 0.0f, 0.0f);
                this.gAi = ObjectAnimator.ofFloat(this.fnE, "alpha", 1.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f);
                this.gAh.setRepeatMode(1);
                this.gAh.setRepeatCount(-1);
                this.gAi.setRepeatMode(1);
                this.gAi.setRepeatCount(-1);
                this.gAg.play(this.gAh).with(this.gAi);
                this.gAg.setInterpolator(new LinearInterpolator());
                this.gAg.start();
            }
        } catch (OutOfMemoryError e) {
            System.gc();
            if (this.gAj != null) {
                this.gAj.mj(true);
            }
        }
    }

    public void setOnEndListener(a aVar) {
        this.gAj = aVar;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (getVisibility() == 8) {
            return super.onTouchEvent(motionEvent);
        }
        if (motionEvent.getAction() == 0 && this.gAj != null) {
            this.gAj.mj(false);
        }
        return true;
    }

    public void onDestroy() {
        if (this.gAg != null) {
            this.gAg.cancel();
            this.gAg = null;
        }
    }
}
