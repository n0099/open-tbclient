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
    private ImageView fLr;
    private AnimatorSet hdB;
    private ObjectAnimator hdC;
    private ObjectAnimator hdD;
    a hdE;

    /* loaded from: classes4.dex */
    public interface a {
        void ne(boolean z);
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
        this.fLr = (ImageView) findViewById(a.g.ala_liveroom_guard_image_hand);
    }

    public void bZZ() {
        setVisibility(0);
        caa();
    }

    private void caa() {
        try {
            if (this.hdB == null) {
                this.hdB = new AnimatorSet();
                this.hdB.setDuration(2200L);
                this.hdC = ObjectAnimator.ofFloat(this.fLr, "translationY", 0.0f, -126.0f, -200.0f, -200.0f, 0.0f, 0.0f, 65.0f, 110.0f, 110.0f, 0.0f, 0.0f);
                this.hdD = ObjectAnimator.ofFloat(this.fLr, "alpha", 1.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f);
                this.hdC.setRepeatMode(1);
                this.hdC.setRepeatCount(-1);
                this.hdD.setRepeatMode(1);
                this.hdD.setRepeatCount(-1);
                this.hdB.play(this.hdC).with(this.hdD);
                this.hdB.setInterpolator(new LinearInterpolator());
                this.hdB.start();
            }
        } catch (OutOfMemoryError e) {
            System.gc();
            if (this.hdE != null) {
                this.hdE.ne(true);
            }
        }
    }

    public void setOnEndListener(a aVar) {
        this.hdE = aVar;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (getVisibility() == 8) {
            return super.onTouchEvent(motionEvent);
        }
        if (motionEvent.getAction() == 0 && this.hdE != null) {
            this.hdE.ne(false);
        }
        return true;
    }

    public void onDestroy() {
        if (this.hdB != null) {
            this.hdB.cancel();
            this.hdB = null;
        }
    }
}
