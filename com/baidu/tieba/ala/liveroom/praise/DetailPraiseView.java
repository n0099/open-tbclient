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
/* loaded from: classes10.dex */
public class DetailPraiseView extends FrameLayout {
    private ArrayList<LottieAnimationView> hGg;
    private int hPp;
    private boolean hPq;
    private a hPr;
    private boolean hPs;
    private boolean hPt;
    private GestureDetector.SimpleOnGestureListener hPu;
    private GestureDetector mDetector;

    /* loaded from: classes10.dex */
    public interface a {
        void ckw();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.hPt) {
            if (!this.hPs) {
                this.hPs = true;
                return false;
            }
            return super.dispatchTouchEvent(motionEvent);
        }
        return false;
    }

    public DetailPraiseView(@NonNull Context context) {
        super(context);
        this.hGg = new ArrayList<>();
        this.hPq = true;
        this.hPs = true;
        this.hPt = true;
        this.hPu = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.ala.liveroom.praise.DetailPraiseView.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                return DetailPraiseView.this.hPq;
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
        this.hGg = new ArrayList<>();
        this.hPq = true;
        this.hPs = true;
        this.hPt = true;
        this.hPu = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.ala.liveroom.praise.DetailPraiseView.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                return DetailPraiseView.this.hPq;
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
        this.hGg = new ArrayList<>();
        this.hPq = true;
        this.hPs = true;
        this.hPt = true;
        this.hPu = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.ala.liveroom.praise.DetailPraiseView.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                return DetailPraiseView.this.hPq;
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
        this.hPp = (int) TypedValue.applyDimension(1, 150.0f, getResources().getDisplayMetrics());
        this.mDetector = new GestureDetector(context, this.hPu);
    }

    public void setShowPraise(boolean z) {
        this.hPs = z;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        this.hGg.clear();
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.mDetector.onTouchEvent(motionEvent);
    }

    public void setOnDoubleClickListener(a aVar) {
        this.hPr = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C(float f, float f2) {
        final LottieAnimationView lottieAnimationView;
        int i = 0;
        while (true) {
            if (i >= this.hGg.size()) {
                lottieAnimationView = null;
                break;
            }
            lottieAnimationView = this.hGg.get(i);
            if (!lottieAnimationView.isAnimating()) {
                break;
            }
            i++;
        }
        if (lottieAnimationView == null) {
            lottieAnimationView = new LottieAnimationView(getContext());
            lottieAnimationView.setLayoutParams(new FrameLayout.LayoutParams(this.hPp, this.hPp, 119));
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
            this.hGg.add(lottieAnimationView);
        }
        lottieAnimationView.setX(f - (this.hPp / 2));
        lottieAnimationView.setY(f2 - (this.hPp / 2));
        lottieAnimationView.setVisibility(0);
        lottieAnimationView.bringToFront();
        lottieAnimationView.playAnimation();
        if (this.hPr != null) {
            this.hPr.ckw();
        }
    }

    public void bWv() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.hGg.size()) {
                LottieAnimationView lottieAnimationView = this.hGg.get(i2);
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
        this.hPt = z;
    }
}
