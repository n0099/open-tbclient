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
    private ImageView fqJ;
    private AnimatorSet gDv;
    private ObjectAnimator gDw;
    private ObjectAnimator gDx;
    a gDy;

    /* loaded from: classes4.dex */
    public interface a {
        void mm(boolean z);
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
        this.fqJ = (ImageView) findViewById(a.g.ala_liveroom_guard_image_hand);
    }

    public void bTH() {
        setVisibility(0);
        bTI();
    }

    private void bTI() {
        try {
            if (this.gDv == null) {
                this.gDv = new AnimatorSet();
                this.gDv.setDuration(2200L);
                this.gDw = ObjectAnimator.ofFloat(this.fqJ, "translationY", 0.0f, -126.0f, -200.0f, -200.0f, 0.0f, 0.0f, 65.0f, 110.0f, 110.0f, 0.0f, 0.0f);
                this.gDx = ObjectAnimator.ofFloat(this.fqJ, "alpha", 1.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f);
                this.gDw.setRepeatMode(1);
                this.gDw.setRepeatCount(-1);
                this.gDx.setRepeatMode(1);
                this.gDx.setRepeatCount(-1);
                this.gDv.play(this.gDw).with(this.gDx);
                this.gDv.setInterpolator(new LinearInterpolator());
                this.gDv.start();
            }
        } catch (OutOfMemoryError e) {
            System.gc();
            if (this.gDy != null) {
                this.gDy.mm(true);
            }
        }
    }

    public void setOnEndListener(a aVar) {
        this.gDy = aVar;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (getVisibility() == 8) {
            return super.onTouchEvent(motionEvent);
        }
        if (motionEvent.getAction() == 0 && this.gDy != null) {
            this.gDy.mm(false);
        }
        return true;
    }

    public void onDestroy() {
        if (this.gDv != null) {
            this.gDv.cancel();
            this.gDv = null;
        }
    }
}
