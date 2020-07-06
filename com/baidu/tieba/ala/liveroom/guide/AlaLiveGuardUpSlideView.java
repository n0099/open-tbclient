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
/* loaded from: classes3.dex */
public class AlaLiveGuardUpSlideView extends FrameLayout {
    private ImageView eXF;
    private AnimatorSet gio;
    private ObjectAnimator gip;
    private ObjectAnimator giq;
    a gir;

    /* loaded from: classes3.dex */
    public interface a {
        void la(boolean z);
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
        this.eXF = (ImageView) findViewById(a.g.ala_liveroom_guard_image_hand);
    }

    public void bFa() {
        setVisibility(0);
        bFb();
    }

    private void bFb() {
        try {
            if (this.gio == null) {
                this.gio = new AnimatorSet();
                this.gio.setDuration(2200L);
                this.gip = ObjectAnimator.ofFloat(this.eXF, "translationY", 0.0f, -126.0f, -200.0f, -200.0f, 0.0f, 0.0f, 65.0f, 110.0f, 110.0f, 0.0f, 0.0f);
                this.giq = ObjectAnimator.ofFloat(this.eXF, "alpha", 1.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f);
                this.gip.setRepeatMode(1);
                this.gip.setRepeatCount(-1);
                this.giq.setRepeatMode(1);
                this.giq.setRepeatCount(-1);
                this.gio.play(this.gip).with(this.giq);
                this.gio.setInterpolator(new LinearInterpolator());
                this.gio.start();
            }
        } catch (OutOfMemoryError e) {
            System.gc();
            if (this.gir != null) {
                this.gir.la(true);
            }
        }
    }

    public void setOnEndListener(a aVar) {
        this.gir = aVar;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (getVisibility() == 8) {
            return super.onTouchEvent(motionEvent);
        }
        if (motionEvent.getAction() == 0 && this.gir != null) {
            this.gir.la(false);
        }
        return true;
    }

    public void onDestroy() {
        if (this.gio != null) {
            this.gio.cancel();
            this.gio = null;
        }
    }
}
