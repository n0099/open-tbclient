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
import com.baidu.live.r.a;
/* loaded from: classes2.dex */
public class AlaLiveGuardUpSlideView extends FrameLayout {
    private ImageView dTY;
    private AnimatorSet eYY;
    private ObjectAnimator eYZ;
    private ObjectAnimator eZa;
    a eZb;

    /* loaded from: classes2.dex */
    public interface a {
        void jp(boolean z);
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
        this.dTY = (ImageView) findViewById(a.g.ala_liveroom_guard_image_hand);
    }

    public void bkK() {
        setVisibility(0);
        bkL();
    }

    private void bkL() {
        try {
            if (this.eYY == null) {
                this.eYY = new AnimatorSet();
                this.eYY.setDuration(2200L);
                this.eYZ = ObjectAnimator.ofFloat(this.dTY, "translationY", 0.0f, -126.0f, -200.0f, -200.0f, 0.0f, 0.0f, 65.0f, 110.0f, 110.0f, 0.0f, 0.0f);
                this.eZa = ObjectAnimator.ofFloat(this.dTY, "alpha", 1.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f);
                this.eYZ.setRepeatMode(1);
                this.eYZ.setRepeatCount(-1);
                this.eZa.setRepeatMode(1);
                this.eZa.setRepeatCount(-1);
                this.eYY.play(this.eYZ).with(this.eZa);
                this.eYY.setInterpolator(new LinearInterpolator());
                this.eYY.start();
            }
        } catch (OutOfMemoryError e) {
            System.gc();
            if (this.eZb != null) {
                this.eZb.jp(true);
            }
        }
    }

    public void setOnEndListener(a aVar) {
        this.eZb = aVar;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (getVisibility() == 8) {
            return super.onTouchEvent(motionEvent);
        }
        if (motionEvent.getAction() == 0 && this.eZb != null) {
            this.eZb.jp(false);
        }
        return true;
    }

    public void onDestroy() {
        if (this.eYY != null) {
            this.eYY.cancel();
            this.eYY = null;
        }
    }
}
