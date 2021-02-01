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
    private ImageView ggn;
    private AnimatorSet hEc;
    private ObjectAnimator hEd;
    private ObjectAnimator hEe;
    a hEf;

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
        this.ggn = (ImageView) findViewById(a.f.ala_liveroom_guard_image_hand);
    }

    public void cfF() {
        setVisibility(0);
        cfG();
    }

    private void cfG() {
        try {
            if (this.hEc == null) {
                this.hEc = new AnimatorSet();
                this.hEc.setDuration(2200L);
                this.hEd = ObjectAnimator.ofFloat(this.ggn, "translationY", 0.0f, -126.0f, -200.0f, -200.0f, 0.0f, 0.0f, 65.0f, 110.0f, 110.0f, 0.0f, 0.0f);
                this.hEe = ObjectAnimator.ofFloat(this.ggn, "alpha", 1.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f);
                this.hEd.setRepeatMode(1);
                this.hEd.setRepeatCount(-1);
                this.hEe.setRepeatMode(1);
                this.hEe.setRepeatCount(-1);
                this.hEc.play(this.hEd).with(this.hEe);
                this.hEc.setInterpolator(new LinearInterpolator());
                this.hEc.start();
            }
        } catch (OutOfMemoryError e) {
            System.gc();
            if (this.hEf != null) {
                this.hEf.op(true);
            }
        }
    }

    public void setOnEndListener(a aVar) {
        this.hEf = aVar;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (getVisibility() == 8) {
            return super.onTouchEvent(motionEvent);
        }
        if (motionEvent.getAction() == 0 && this.hEf != null) {
            this.hEf.op(false);
        }
        return true;
    }

    public void onDestroy() {
        if (this.hEc != null) {
            this.hEc.cancel();
            this.hEc = null;
        }
    }
}
