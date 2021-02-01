package com.baidu.tieba.ala.liveroom.praise;

import android.animation.Animator;
import android.content.Context;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.live.lottie.LottieAnimationView;
import java.util.ArrayList;
/* loaded from: classes11.dex */
public class DetailPraiseView extends FrameLayout {
    private ArrayList<LottieAnimationView> hEj;
    private int hNs;
    private boolean hNt;
    private a hNu;
    private boolean hNv;
    private boolean hNw;
    private GestureDetector.SimpleOnGestureListener hNx;
    private GestureDetector mDetector;

    /* loaded from: classes11.dex */
    public interface a {
        void ckj();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.hNw) {
            if (!this.hNv) {
                this.hNv = true;
                return false;
            }
            return super.dispatchTouchEvent(motionEvent);
        }
        return false;
    }

    public DetailPraiseView(@NonNull Context context) {
        super(context);
        this.hEj = new ArrayList<>();
        this.hNt = true;
        this.hNv = true;
        this.hNw = true;
        this.hNx = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.ala.liveroom.praise.DetailPraiseView.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                return DetailPraiseView.this.hNt;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                DetailPraiseView.this.C(motionEvent.getX(), motionEvent.getY());
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onDoubleTapEvent(MotionEvent motionEvent) {
                DetailPraiseView.this.C(motionEvent.getX(), motionEvent.getY());
                return true;
            }
        };
        init(context);
    }

    public DetailPraiseView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hEj = new ArrayList<>();
        this.hNt = true;
        this.hNv = true;
        this.hNw = true;
        this.hNx = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.ala.liveroom.praise.DetailPraiseView.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                return DetailPraiseView.this.hNt;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                DetailPraiseView.this.C(motionEvent.getX(), motionEvent.getY());
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onDoubleTapEvent(MotionEvent motionEvent) {
                DetailPraiseView.this.C(motionEvent.getX(), motionEvent.getY());
                return true;
            }
        };
        init(context);
    }

    public DetailPraiseView(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i) {
        super(context, attributeSet, i);
        this.hEj = new ArrayList<>();
        this.hNt = true;
        this.hNv = true;
        this.hNw = true;
        this.hNx = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.ala.liveroom.praise.DetailPraiseView.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                return DetailPraiseView.this.hNt;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                DetailPraiseView.this.C(motionEvent.getX(), motionEvent.getY());
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onDoubleTapEvent(MotionEvent motionEvent) {
                DetailPraiseView.this.C(motionEvent.getX(), motionEvent.getY());
                return true;
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.hNs = (int) TypedValue.applyDimension(1, 150.0f, getResources().getDisplayMetrics());
        this.mDetector = new GestureDetector(context, this.hNx);
    }

    public void setShowPraise(boolean z) {
        this.hNv = z;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        this.hEj.clear();
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.mDetector.onTouchEvent(motionEvent);
    }

    public void setOnDoubleClickListener(a aVar) {
        this.hNu = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C(float f, float f2) {
        final LottieAnimationView lottieAnimationView;
        int i = 0;
        while (true) {
            if (i >= this.hEj.size()) {
                lottieAnimationView = null;
                break;
            }
            lottieAnimationView = this.hEj.get(i);
            if (!lottieAnimationView.isAnimating()) {
                break;
            }
            i++;
        }
        if (lottieAnimationView == null) {
            lottieAnimationView = new LottieAnimationView(getContext());
            lottieAnimationView.setLayoutParams(new FrameLayout.LayoutParams(this.hNs, this.hNs, 119));
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
            lottieAnimationView.setImageAssetsFolder("praise/images");
            lottieAnimationView.setAnimation("praise/double_click_praise.json");
            addView(lottieAnimationView);
            this.hEj.add(lottieAnimationView);
        }
        lottieAnimationView.setX(f - (this.hNs / 2));
        lottieAnimationView.setY(f2 - (this.hNs / 2));
        lottieAnimationView.setVisibility(0);
        lottieAnimationView.bringToFront();
        lottieAnimationView.playAnimation();
        if (this.hNu != null) {
            this.hNu.ckj();
        }
    }

    public void bWi() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.hEj.size()) {
                LottieAnimationView lottieAnimationView = this.hEj.get(i2);
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
        this.hNw = z;
    }
}
