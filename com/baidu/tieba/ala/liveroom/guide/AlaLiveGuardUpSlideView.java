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
    private ImageView fcg;
    private AnimatorSet gnm;
    private ObjectAnimator gnn;
    private ObjectAnimator gno;
    a gnp;

    /* loaded from: classes4.dex */
    public interface a {
        void lD(boolean z);
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
        this.fcg = (ImageView) findViewById(a.g.ala_liveroom_guard_image_hand);
    }

    public void bIi() {
        setVisibility(0);
        bIj();
    }

    private void bIj() {
        try {
            if (this.gnm == null) {
                this.gnm = new AnimatorSet();
                this.gnm.setDuration(2200L);
                this.gnn = ObjectAnimator.ofFloat(this.fcg, "translationY", 0.0f, -126.0f, -200.0f, -200.0f, 0.0f, 0.0f, 65.0f, 110.0f, 110.0f, 0.0f, 0.0f);
                this.gno = ObjectAnimator.ofFloat(this.fcg, "alpha", 1.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f);
                this.gnn.setRepeatMode(1);
                this.gnn.setRepeatCount(-1);
                this.gno.setRepeatMode(1);
                this.gno.setRepeatCount(-1);
                this.gnm.play(this.gnn).with(this.gno);
                this.gnm.setInterpolator(new LinearInterpolator());
                this.gnm.start();
            }
        } catch (OutOfMemoryError e) {
            System.gc();
            if (this.gnp != null) {
                this.gnp.lD(true);
            }
        }
    }

    public void setOnEndListener(a aVar) {
        this.gnp = aVar;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (getVisibility() == 8) {
            return super.onTouchEvent(motionEvent);
        }
        if (motionEvent.getAction() == 0 && this.gnp != null) {
            this.gnp.lD(false);
        }
        return true;
    }

    public void onDestroy() {
        if (this.gnm != null) {
            this.gnm.cancel();
            this.gnm = null;
        }
    }
}
