package com.baidu.tieba.ala.liveroom.tippop;

import android.content.Context;
import android.content.res.Configuration;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.SkinManager;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tieba.d.a;
import com.baidu.live.tieba.d.b;
/* loaded from: classes4.dex */
public class AlaTopTipView extends TextView {
    private a.InterfaceC0192a bnK;
    private Animation bxL;
    private Runnable bxN;
    private Animation gMK;
    private a gML;
    private b gMM;
    private int mDuration;
    private boolean mIsShowing;
    private int mType;

    /* loaded from: classes4.dex */
    public interface a {
        void bW(View view);
    }

    public AlaTopTipView(Context context) {
        super(context);
        this.mDuration = 2000;
        this.bxN = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.tippop.AlaTopTipView.1
            @Override // java.lang.Runnable
            public void run() {
                AlaTopTipView.this.hideTip();
            }
        };
        this.bnK = new a.InterfaceC0192a() { // from class: com.baidu.tieba.ala.liveroom.tippop.AlaTopTipView.2
            @Override // com.baidu.live.tieba.d.a.InterfaceC0192a
            public void H(int i, int i2) {
            }

            @Override // com.baidu.live.tieba.d.a.InterfaceC0192a
            public void I(int i, int i2) {
                if (al(i2) && AlaTopTipView.this.mIsShowing) {
                    AlaTopTipView.this.hideTip();
                }
            }

            @Override // com.baidu.live.tieba.d.a.InterfaceC0192a
            public void J(int i, int i2) {
            }

            private boolean al(float f) {
                return Math.abs(f) >= 2.0f;
            }
        };
        init();
    }

    public AlaTopTipView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mDuration = 2000;
        this.bxN = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.tippop.AlaTopTipView.1
            @Override // java.lang.Runnable
            public void run() {
                AlaTopTipView.this.hideTip();
            }
        };
        this.bnK = new a.InterfaceC0192a() { // from class: com.baidu.tieba.ala.liveroom.tippop.AlaTopTipView.2
            @Override // com.baidu.live.tieba.d.a.InterfaceC0192a
            public void H(int i, int i2) {
            }

            @Override // com.baidu.live.tieba.d.a.InterfaceC0192a
            public void I(int i, int i2) {
                if (al(i2) && AlaTopTipView.this.mIsShowing) {
                    AlaTopTipView.this.hideTip();
                }
            }

            @Override // com.baidu.live.tieba.d.a.InterfaceC0192a
            public void J(int i, int i2) {
            }

            private boolean al(float f) {
                return Math.abs(f) >= 2.0f;
            }
        };
        init();
    }

    public AlaTopTipView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mDuration = 2000;
        this.bxN = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.tippop.AlaTopTipView.1
            @Override // java.lang.Runnable
            public void run() {
                AlaTopTipView.this.hideTip();
            }
        };
        this.bnK = new a.InterfaceC0192a() { // from class: com.baidu.tieba.ala.liveroom.tippop.AlaTopTipView.2
            @Override // com.baidu.live.tieba.d.a.InterfaceC0192a
            public void H(int i2, int i22) {
            }

            @Override // com.baidu.live.tieba.d.a.InterfaceC0192a
            public void I(int i2, int i22) {
                if (al(i22) && AlaTopTipView.this.mIsShowing) {
                    AlaTopTipView.this.hideTip();
                }
            }

            @Override // com.baidu.live.tieba.d.a.InterfaceC0192a
            public void J(int i2, int i22) {
            }

            private boolean al(float f) {
                return Math.abs(f) >= 2.0f;
            }
        };
        init();
    }

    private void init() {
        this.gMM = new b(getContext());
        this.gMM.a(this.bnK);
        setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.ala.liveroom.tippop.AlaTopTipView.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    view.getParent().requestDisallowInterceptTouchEvent(true);
                }
                return AlaTopTipView.this.gMM.onTouchEvent(motionEvent);
            }
        });
        setupPaddings();
        this.gMK = AnimationUtils.loadAnimation(getContext(), a.C0186a.sdk_push_top_in);
        this.bxL = AnimationUtils.loadAnimation(getContext(), a.C0186a.sdk_push_top_out);
        setTextSize(0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds28));
        this.bxL.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.liveroom.tippop.AlaTopTipView.4
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                AlaTopTipView.this.onDestroy();
                ViewGroup viewGroup = (ViewGroup) AlaTopTipView.this.getParent();
                if (viewGroup != null) {
                    viewGroup.removeView(AlaTopTipView.this);
                }
                if (AlaTopTipView.this.gML != null) {
                    AlaTopTipView.this.gML.bW(AlaTopTipView.this);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.gMK.setDuration(400L);
        this.gMK.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.liveroom.tippop.AlaTopTipView.5
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (AlaTopTipView.this.mDuration > 0) {
                    AlaTopTipView.this.postDelayed(AlaTopTipView.this.bxN, AlaTopTipView.this.mDuration);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

    private void setupPaddings() {
        int dimensionPixelOffset = getContext().getResources().getDimensionPixelOffset(a.e.sdk_ds30);
        int statusBarHeight = (UtilHelper.canUseStyleImmersiveSticky() && UtilHelper.getRealScreenOrientation(getContext()) == 1) ? UtilHelper.getStatusBarHeight() + dimensionPixelOffset : dimensionPixelOffset;
        int dimensionPixelOffset2 = getContext().getResources().getDimensionPixelOffset(a.e.sdk_ds34);
        setPadding(dimensionPixelOffset2, statusBarHeight, dimensionPixelOffset2, dimensionPixelOffset);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        setupPaddings();
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.width = getRealWidth();
        setLayoutParams(layoutParams);
    }

    public void setDuration(int i) {
        this.mDuration = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideTip() {
        this.mIsShowing = false;
        removeCallbacks(this.bxN);
        if (this != null && getParent() != null) {
            clearAnimation();
            startAnimation(this.bxL);
        }
    }

    private int getRealWidth() {
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(getContext());
        if (screenDimensions.length != 2 || screenDimensions[0] <= 0) {
            return -1;
        }
        return screenDimensions[0];
    }

    public void p(ViewGroup viewGroup, int i) {
        if (viewGroup instanceof RelativeLayout) {
            a((RelativeLayout) viewGroup, i);
        } else if (viewGroup instanceof FrameLayout) {
            b((FrameLayout) viewGroup, i);
        } else if (viewGroup instanceof LinearLayout) {
            c((LinearLayout) viewGroup, i);
        }
    }

    public void c(LinearLayout linearLayout, int i) {
        if (linearLayout != null) {
            if (getParent() != null) {
                clearAnimation();
                ((ViewGroup) getParent()).removeView(this);
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(getRealWidth(), -2);
            layoutParams.gravity = 48;
            linearLayout.addView(this, layoutParams);
            onChangeSkinType(i);
            startAnimation(this.gMK);
            this.mIsShowing = true;
        }
    }

    public void a(RelativeLayout relativeLayout, int i) {
        if (relativeLayout != null) {
            if (getParent() != null) {
                clearAnimation();
                ((ViewGroup) getParent()).removeView(this);
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(getRealWidth(), -2);
            layoutParams.addRule(10);
            relativeLayout.addView(this, layoutParams);
            onChangeSkinType(i);
            startAnimation(this.gMK);
            this.mIsShowing = true;
        }
    }

    public void b(FrameLayout frameLayout, int i) {
        if (frameLayout != null) {
            if (getParent() != null) {
                clearAnimation();
                ((ViewGroup) getParent()).removeView(this);
            }
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(getRealWidth(), -2);
            layoutParams.setMargins(0, 0, 0, 0);
            frameLayout.addView(this, layoutParams);
            onChangeSkinType(i);
            startAnimation(this.gMK);
            this.mIsShowing = true;
        }
    }

    public void fp(boolean z) {
        this.mIsShowing = false;
        onDestroy();
        ViewGroup viewGroup = (ViewGroup) getParent();
        if (viewGroup != null) {
            viewGroup.removeView(this);
        }
        if (z && this.gML != null) {
            this.gML.bW(this);
        }
    }

    public void setTipDuration(int i) {
        if (i > 0) {
            this.mDuration = i;
        }
    }

    public void bYl() {
        setupPaddings();
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.width = getRealWidth();
        setLayoutParams(layoutParams);
    }

    public void onChangeSkinType(int i) {
        SkinManager.setBackgroundResource(this, a.d.sdk_white_alpha95, i);
        SkinManager.setViewTextColor(this, a.d.sdk_cp_cont_f, 1, i);
    }

    public void onDestroy() {
        removeCallbacks(this.bxN);
        clearAnimation();
    }

    public void setOnTipCompletedCallback(a aVar) {
        this.gML = aVar;
    }

    public int getType() {
        return this.mType;
    }

    public void setType(int i) {
        this.mType = i;
    }
}
