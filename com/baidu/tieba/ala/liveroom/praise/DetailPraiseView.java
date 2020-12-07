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
/* loaded from: classes4.dex */
public class DetailPraiseView extends FrameLayout {
    private boolean hBA;
    private boolean hBB;
    private GestureDetector.SimpleOnGestureListener hBC;
    private int hBx;
    private boolean hBy;
    private a hBz;
    private ArrayList<LottieAnimationView> hsI;
    private GestureDetector mDetector;

    /* loaded from: classes4.dex */
    public interface a {
        void ckm();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.hBB) {
            if (!this.hBA) {
                this.hBA = true;
                return false;
            }
            return super.dispatchTouchEvent(motionEvent);
        }
        return false;
    }

    public DetailPraiseView(@NonNull Context context) {
        super(context);
        this.hsI = new ArrayList<>();
        this.hBy = true;
        this.hBA = true;
        this.hBB = true;
        this.hBC = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.ala.liveroom.praise.DetailPraiseView.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                return DetailPraiseView.this.hBy;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                DetailPraiseView.this.B(motionEvent.getX(), motionEvent.getY());
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onDoubleTapEvent(MotionEvent motionEvent) {
                DetailPraiseView.this.B(motionEvent.getX(), motionEvent.getY());
                return true;
            }
        };
        init(context);
    }

    public DetailPraiseView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hsI = new ArrayList<>();
        this.hBy = true;
        this.hBA = true;
        this.hBB = true;
        this.hBC = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.ala.liveroom.praise.DetailPraiseView.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                return DetailPraiseView.this.hBy;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                DetailPraiseView.this.B(motionEvent.getX(), motionEvent.getY());
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onDoubleTapEvent(MotionEvent motionEvent) {
                DetailPraiseView.this.B(motionEvent.getX(), motionEvent.getY());
                return true;
            }
        };
        init(context);
    }

    public DetailPraiseView(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i) {
        super(context, attributeSet, i);
        this.hsI = new ArrayList<>();
        this.hBy = true;
        this.hBA = true;
        this.hBB = true;
        this.hBC = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.ala.liveroom.praise.DetailPraiseView.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                return DetailPraiseView.this.hBy;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                DetailPraiseView.this.B(motionEvent.getX(), motionEvent.getY());
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onDoubleTapEvent(MotionEvent motionEvent) {
                DetailPraiseView.this.B(motionEvent.getX(), motionEvent.getY());
                return true;
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.hBx = (int) TypedValue.applyDimension(1, 150.0f, getResources().getDisplayMetrics());
        this.mDetector = new GestureDetector(context, this.hBC);
    }

    public void setShowPraise(boolean z) {
        this.hBA = z;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        this.hsI.clear();
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.mDetector.onTouchEvent(motionEvent);
    }

    public void setOnDoubleClickListener(a aVar) {
        this.hBz = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B(float f, float f2) {
        final LottieAnimationView lottieAnimationView;
        int i = 0;
        while (true) {
            if (i >= this.hsI.size()) {
                lottieAnimationView = null;
                break;
            }
            lottieAnimationView = this.hsI.get(i);
            if (!lottieAnimationView.isAnimating()) {
                break;
            }
            i++;
        }
        if (lottieAnimationView == null) {
            lottieAnimationView = new LottieAnimationView(getContext());
            lottieAnimationView.setLayoutParams(new FrameLayout.LayoutParams(this.hBx, this.hBx, 119));
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
            lottieAnimationView.setAnimation("double_click_praise.json");
            addView(lottieAnimationView);
            this.hsI.add(lottieAnimationView);
        }
        lottieAnimationView.setX(f - (this.hBx / 2));
        lottieAnimationView.setY(f2 - (this.hBx / 2));
        lottieAnimationView.setVisibility(0);
        lottieAnimationView.bringToFront();
        lottieAnimationView.playAnimation();
        if (this.hBz != null) {
            this.hBz.ckm();
        }
    }

    public void bWP() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.hsI.size()) {
                LottieAnimationView lottieAnimationView = this.hsI.get(i2);
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
        this.hBB = z;
    }
}
