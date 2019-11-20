package com.baidu.tieba.ala.liveroom.praise;

import android.animation.Animator;
import android.content.Context;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.tb.airbnb.lottie.LottieAnimationView;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class DetailPraiseView extends FrameLayout {
    private ArrayList<LottieAnimationView> egv;
    private final int emK;
    private int emL;
    private boolean emM;
    private a emN;
    private boolean emO;
    private boolean emP;
    private GestureDetector.SimpleOnGestureListener emQ;
    private GestureDetector mDetector;

    /* loaded from: classes6.dex */
    public interface a {
        void aVD();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.emP) {
            if (!this.emO) {
                this.emO = true;
                return false;
            }
            return super.dispatchTouchEvent(motionEvent);
        }
        return false;
    }

    public DetailPraiseView(@NonNull Context context) {
        super(context);
        this.emK = 150;
        this.egv = new ArrayList<>();
        this.emM = true;
        this.emO = true;
        this.emP = true;
        this.emQ = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.ala.liveroom.praise.DetailPraiseView.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                return DetailPraiseView.this.emM;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                DetailPraiseView.this.t(motionEvent.getX(), motionEvent.getY());
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onDoubleTapEvent(MotionEvent motionEvent) {
                DetailPraiseView.this.t(motionEvent.getX(), motionEvent.getY());
                return true;
            }
        };
        init(context);
    }

    public DetailPraiseView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.emK = 150;
        this.egv = new ArrayList<>();
        this.emM = true;
        this.emO = true;
        this.emP = true;
        this.emQ = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.ala.liveroom.praise.DetailPraiseView.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                return DetailPraiseView.this.emM;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                DetailPraiseView.this.t(motionEvent.getX(), motionEvent.getY());
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onDoubleTapEvent(MotionEvent motionEvent) {
                DetailPraiseView.this.t(motionEvent.getX(), motionEvent.getY());
                return true;
            }
        };
        init(context);
    }

    public DetailPraiseView(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i) {
        super(context, attributeSet, i);
        this.emK = 150;
        this.egv = new ArrayList<>();
        this.emM = true;
        this.emO = true;
        this.emP = true;
        this.emQ = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.ala.liveroom.praise.DetailPraiseView.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                return DetailPraiseView.this.emM;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                DetailPraiseView.this.t(motionEvent.getX(), motionEvent.getY());
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onDoubleTapEvent(MotionEvent motionEvent) {
                DetailPraiseView.this.t(motionEvent.getX(), motionEvent.getY());
                return true;
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.emL = (int) TypedValue.applyDimension(1, 150.0f, getResources().getDisplayMetrics());
        this.mDetector = new GestureDetector(context, this.emQ);
    }

    public void setShowPraise(boolean z) {
        this.emO = z;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        this.egv.clear();
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.mDetector.onTouchEvent(motionEvent);
    }

    public void setOnDoubleClickListener(a aVar) {
        this.emN = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(float f, float f2) {
        final LottieAnimationView lottieAnimationView;
        int i = 0;
        while (true) {
            if (i >= this.egv.size()) {
                lottieAnimationView = null;
                break;
            }
            lottieAnimationView = this.egv.get(i);
            if (!lottieAnimationView.isAnimating()) {
                break;
            }
            i++;
        }
        if (lottieAnimationView == null) {
            lottieAnimationView = new LottieAnimationView(getContext());
            lottieAnimationView.setLayoutParams(new FrameLayout.LayoutParams(this.emL, this.emL, 119));
            lottieAnimationView.addAnimatorListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.ala.liveroom.praise.DetailPraiseView.2
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    lottieAnimationView.setVisibility(8);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    lottieAnimationView.setVisibility(8);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            lottieAnimationView.setImageAssetsFolder("/");
            lottieAnimationView.setAnimation("double_click_praise.json", LottieAnimationView.CacheStrategy.Strong);
            addView(lottieAnimationView);
            this.egv.add(lottieAnimationView);
        }
        lottieAnimationView.setX(f - (this.emL / 2));
        lottieAnimationView.setY(f2 - (this.emL / 2));
        lottieAnimationView.setVisibility(0);
        lottieAnimationView.bringToFront();
        lottieAnimationView.playAnimation();
        if (this.emN != null) {
            this.emN.aVD();
        }
    }

    public void aMe() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.egv.size()) {
                LottieAnimationView lottieAnimationView = this.egv.get(i2);
                if (lottieAnimationView != null && lottieAnimationView.isAnimating()) {
                    lottieAnimationView.cancelAnimation();
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void setPraiseEnable(boolean z) {
        this.emP = z;
    }
}
