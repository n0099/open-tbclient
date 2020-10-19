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
    private ImageView fCW;
    private AnimatorSet gRO;
    private ObjectAnimator gRP;
    private ObjectAnimator gRQ;
    a gRR;

    /* loaded from: classes4.dex */
    public interface a {
        void mO(boolean z);
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
        this.fCW = (ImageView) findViewById(a.g.ala_liveroom_guard_image_hand);
    }

    public void bXa() {
        setVisibility(0);
        bXb();
    }

    private void bXb() {
        try {
            if (this.gRO == null) {
                this.gRO = new AnimatorSet();
                this.gRO.setDuration(2200L);
                this.gRP = ObjectAnimator.ofFloat(this.fCW, "translationY", 0.0f, -126.0f, -200.0f, -200.0f, 0.0f, 0.0f, 65.0f, 110.0f, 110.0f, 0.0f, 0.0f);
                this.gRQ = ObjectAnimator.ofFloat(this.fCW, "alpha", 1.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f);
                this.gRP.setRepeatMode(1);
                this.gRP.setRepeatCount(-1);
                this.gRQ.setRepeatMode(1);
                this.gRQ.setRepeatCount(-1);
                this.gRO.play(this.gRP).with(this.gRQ);
                this.gRO.setInterpolator(new LinearInterpolator());
                this.gRO.start();
            }
        } catch (OutOfMemoryError e) {
            System.gc();
            if (this.gRR != null) {
                this.gRR.mO(true);
            }
        }
    }

    public void setOnEndListener(a aVar) {
        this.gRR = aVar;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (getVisibility() == 8) {
            return super.onTouchEvent(motionEvent);
        }
        if (motionEvent.getAction() == 0 && this.gRR != null) {
            this.gRR.mO(false);
        }
        return true;
    }

    public void onDestroy() {
        if (this.gRO != null) {
            this.gRO.cancel();
            this.gRO = null;
        }
    }
}
