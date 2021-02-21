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
import android.widget.ImageView;
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
/* loaded from: classes11.dex */
public class AlaTopTipView extends FrameLayout {
    private a.InterfaceC0211a bGW;
    private Animation bUs;
    private Runnable bUu;
    private boolean enb;
    private TextView hON;
    private Animation hOO;
    private a hOP;
    private b hOQ;
    private int mDuration;
    private int mType;

    /* loaded from: classes11.dex */
    public interface a {
        void cy(View view);
    }

    public AlaTopTipView(Context context) {
        super(context);
        this.mDuration = 2000;
        this.bUu = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.tippop.AlaTopTipView.1
            @Override // java.lang.Runnable
            public void run() {
                AlaTopTipView.this.hideTip();
            }
        };
        this.bGW = new a.InterfaceC0211a() { // from class: com.baidu.tieba.ala.liveroom.tippop.AlaTopTipView.2
            @Override // com.baidu.live.tieba.d.a.InterfaceC0211a
            public void G(int i, int i2) {
            }

            @Override // com.baidu.live.tieba.d.a.InterfaceC0211a
            public void H(int i, int i2) {
                if (aD(i2) && AlaTopTipView.this.enb) {
                    AlaTopTipView.this.hideTip();
                }
            }

            @Override // com.baidu.live.tieba.d.a.InterfaceC0211a
            public void I(int i, int i2) {
            }

            private boolean aD(float f) {
                return Math.abs(f) >= 2.0f;
            }
        };
        init();
    }

    public AlaTopTipView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mDuration = 2000;
        this.bUu = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.tippop.AlaTopTipView.1
            @Override // java.lang.Runnable
            public void run() {
                AlaTopTipView.this.hideTip();
            }
        };
        this.bGW = new a.InterfaceC0211a() { // from class: com.baidu.tieba.ala.liveroom.tippop.AlaTopTipView.2
            @Override // com.baidu.live.tieba.d.a.InterfaceC0211a
            public void G(int i, int i2) {
            }

            @Override // com.baidu.live.tieba.d.a.InterfaceC0211a
            public void H(int i, int i2) {
                if (aD(i2) && AlaTopTipView.this.enb) {
                    AlaTopTipView.this.hideTip();
                }
            }

            @Override // com.baidu.live.tieba.d.a.InterfaceC0211a
            public void I(int i, int i2) {
            }

            private boolean aD(float f) {
                return Math.abs(f) >= 2.0f;
            }
        };
        init();
    }

    public AlaTopTipView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mDuration = 2000;
        this.bUu = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.tippop.AlaTopTipView.1
            @Override // java.lang.Runnable
            public void run() {
                AlaTopTipView.this.hideTip();
            }
        };
        this.bGW = new a.InterfaceC0211a() { // from class: com.baidu.tieba.ala.liveroom.tippop.AlaTopTipView.2
            @Override // com.baidu.live.tieba.d.a.InterfaceC0211a
            public void G(int i2, int i22) {
            }

            @Override // com.baidu.live.tieba.d.a.InterfaceC0211a
            public void H(int i2, int i22) {
                if (aD(i22) && AlaTopTipView.this.enb) {
                    AlaTopTipView.this.hideTip();
                }
            }

            @Override // com.baidu.live.tieba.d.a.InterfaceC0211a
            public void I(int i2, int i22) {
            }

            private boolean aD(float f) {
                return Math.abs(f) >= 2.0f;
            }
        };
        init();
    }

    private void init() {
        ckK();
        ckJ();
        initAnimation();
    }

    private void ckJ() {
        this.hOQ = new b(getContext());
        this.hOQ.a(this.bGW);
        setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.ala.liveroom.tippop.AlaTopTipView.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    view.getParent().requestDisallowInterceptTouchEvent(true);
                }
                return AlaTopTipView.this.hOQ.onTouchEvent(motionEvent);
            }
        });
    }

    private void initAnimation() {
        this.hOO = AnimationUtils.loadAnimation(getContext(), a.C0195a.sdk_push_top_in);
        this.bUs = AnimationUtils.loadAnimation(getContext(), a.C0195a.sdk_push_top_out);
        this.bUs.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.liveroom.tippop.AlaTopTipView.4
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
                if (AlaTopTipView.this.hOP != null) {
                    AlaTopTipView.this.hOP.cy(AlaTopTipView.this);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.hOO.setDuration(400L);
        this.hOO.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.liveroom.tippop.AlaTopTipView.5
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (AlaTopTipView.this.mDuration > 0) {
                    AlaTopTipView.this.postDelayed(AlaTopTipView.this.bUu, AlaTopTipView.this.mDuration);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

    private void ckK() {
        if (getContext() != null) {
            this.hON = new TextView(getContext());
            this.hON.setTextSize(0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds28));
            int dimensionPixelOffset = getContext().getResources().getDimensionPixelOffset(a.d.sdk_ds30);
            int statusBarHeight = (UtilHelper.canUseStyleImmersiveSticky() && UtilHelper.getRealScreenOrientation(getContext()) == 1) ? UtilHelper.getStatusBarHeight() + dimensionPixelOffset : dimensionPixelOffset;
            int dimensionPixelOffset2 = getContext().getResources().getDimensionPixelOffset(a.d.sdk_ds34);
            this.hON.setPadding(dimensionPixelOffset2, statusBarHeight, dimensionPixelOffset2, dimensionPixelOffset);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            if (this.hON != null && this.hON.getParent() != null) {
                ((ViewGroup) this.hON.getParent()).removeView(this.hON);
            }
            addView(this.hON, layoutParams);
        }
    }

    public void ckL() {
        if (getContext() != null) {
            int dimensionPixelOffset = getContext().getResources().getDimensionPixelOffset(a.d.sdk_ds20);
            int dimensionPixelOffset2 = getContext().getResources().getDimensionPixelOffset(a.d.sdk_ds30);
            if (UtilHelper.canUseStyleImmersiveSticky() && UtilHelper.getRealScreenOrientation(getContext()) == 1) {
                dimensionPixelOffset2 += UtilHelper.getStatusBarHeight() - dimensionPixelOffset;
            }
            int dimensionPixelOffset3 = getContext().getResources().getDimensionPixelOffset(a.d.sdk_ds35) + (dimensionPixelOffset * 2);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dimensionPixelOffset3, dimensionPixelOffset3);
            layoutParams.gravity = 5;
            ImageView imageView = new ImageView(getContext());
            layoutParams.setMargins(0, dimensionPixelOffset2, getContext().getResources().getDimensionPixelOffset(a.d.sdk_ds34) - dimensionPixelOffset, 0);
            imageView.setImageResource(a.e.ala_live_icon_audio_switch_close);
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.tippop.AlaTopTipView.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    AlaTopTipView.this.hideTip();
                }
            });
            imageView.setPadding(dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset);
            addView(imageView, layoutParams);
        }
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.width = getRealWidth();
        setLayoutParams(layoutParams);
    }

    public void setDuration(int i) {
        this.mDuration = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideTip() {
        this.enb = false;
        removeCallbacks(this.bUu);
        if (this != null && getParent() != null) {
            clearAnimation();
            startAnimation(this.bUs);
        }
    }

    private int getRealWidth() {
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(getContext());
        if (screenDimensions.length != 2 || screenDimensions[0] <= 0) {
            return -1;
        }
        return screenDimensions[0];
    }

    public void w(ViewGroup viewGroup, int i) {
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
            startAnimation(this.hOO);
            this.enb = true;
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
            startAnimation(this.hOO);
            this.enb = true;
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
            startAnimation(this.hOO);
            this.enb = true;
        }
    }

    public void gG(boolean z) {
        this.enb = false;
        onDestroy();
        ViewGroup viewGroup = (ViewGroup) getParent();
        if (viewGroup != null) {
            viewGroup.removeView(this);
        }
        if (z && this.hOP != null) {
            this.hOP.cy(this);
        }
    }

    public void setTipDuration(int i) {
        if (i > 0) {
            this.mDuration = i;
        }
    }

    public void ckM() {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.width = getRealWidth();
        setLayoutParams(layoutParams);
    }

    public void onChangeSkinType(int i) {
        SkinManager.setBackgroundResource(this, a.c.sdk_white_alpha95, i);
        if (this.hON != null) {
            SkinManager.setViewTextColor(this.hON, a.c.sdk_cp_cont_f, 1, i);
        } else {
            SkinManager.setViewTextColor(this, a.c.sdk_cp_cont_f, 1, i);
        }
    }

    public void onDestroy() {
        removeCallbacks(this.bUu);
        clearAnimation();
    }

    public void setOnTipCompletedCallback(a aVar) {
        this.hOP = aVar;
    }

    public int getType() {
        return this.mType;
    }

    public void setType(int i) {
        this.mType = i;
    }

    public void setText(String str) {
        if (this.hON != null) {
            this.hON.setText(str);
        }
    }
}
