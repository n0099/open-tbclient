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
    private a.InterfaceC0218a bHY;
    private Animation bVo;
    private Runnable bVq;
    private boolean epJ;
    private TextView hOH;
    private Animation hOI;
    private a hOJ;
    private b hOK;
    private int mDuration;
    private int mType;

    /* loaded from: classes11.dex */
    public interface a {
        void cC(View view);
    }

    public AlaTopTipView(Context context) {
        super(context);
        this.mDuration = 2000;
        this.bVq = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.tippop.AlaTopTipView.1
            @Override // java.lang.Runnable
            public void run() {
                AlaTopTipView.this.hideTip();
            }
        };
        this.bHY = new a.InterfaceC0218a() { // from class: com.baidu.tieba.ala.liveroom.tippop.AlaTopTipView.2
            @Override // com.baidu.live.tieba.d.a.InterfaceC0218a
            public void G(int i, int i2) {
            }

            @Override // com.baidu.live.tieba.d.a.InterfaceC0218a
            public void H(int i, int i2) {
                if (aA(i2) && AlaTopTipView.this.epJ) {
                    AlaTopTipView.this.hideTip();
                }
            }

            @Override // com.baidu.live.tieba.d.a.InterfaceC0218a
            public void I(int i, int i2) {
            }

            private boolean aA(float f) {
                return Math.abs(f) >= 2.0f;
            }
        };
        init();
    }

    public AlaTopTipView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mDuration = 2000;
        this.bVq = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.tippop.AlaTopTipView.1
            @Override // java.lang.Runnable
            public void run() {
                AlaTopTipView.this.hideTip();
            }
        };
        this.bHY = new a.InterfaceC0218a() { // from class: com.baidu.tieba.ala.liveroom.tippop.AlaTopTipView.2
            @Override // com.baidu.live.tieba.d.a.InterfaceC0218a
            public void G(int i, int i2) {
            }

            @Override // com.baidu.live.tieba.d.a.InterfaceC0218a
            public void H(int i, int i2) {
                if (aA(i2) && AlaTopTipView.this.epJ) {
                    AlaTopTipView.this.hideTip();
                }
            }

            @Override // com.baidu.live.tieba.d.a.InterfaceC0218a
            public void I(int i, int i2) {
            }

            private boolean aA(float f) {
                return Math.abs(f) >= 2.0f;
            }
        };
        init();
    }

    public AlaTopTipView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mDuration = 2000;
        this.bVq = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.tippop.AlaTopTipView.1
            @Override // java.lang.Runnable
            public void run() {
                AlaTopTipView.this.hideTip();
            }
        };
        this.bHY = new a.InterfaceC0218a() { // from class: com.baidu.tieba.ala.liveroom.tippop.AlaTopTipView.2
            @Override // com.baidu.live.tieba.d.a.InterfaceC0218a
            public void G(int i2, int i22) {
            }

            @Override // com.baidu.live.tieba.d.a.InterfaceC0218a
            public void H(int i2, int i22) {
                if (aA(i22) && AlaTopTipView.this.epJ) {
                    AlaTopTipView.this.hideTip();
                }
            }

            @Override // com.baidu.live.tieba.d.a.InterfaceC0218a
            public void I(int i2, int i22) {
            }

            private boolean aA(float f) {
                return Math.abs(f) >= 2.0f;
            }
        };
        init();
    }

    private void init() {
        cnw();
        cnv();
        initAnimation();
    }

    private void cnv() {
        this.hOK = new b(getContext());
        this.hOK.a(this.bHY);
        setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.ala.liveroom.tippop.AlaTopTipView.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    view.getParent().requestDisallowInterceptTouchEvent(true);
                }
                return AlaTopTipView.this.hOK.onTouchEvent(motionEvent);
            }
        });
    }

    private void initAnimation() {
        this.hOI = AnimationUtils.loadAnimation(getContext(), a.C0203a.sdk_push_top_in);
        this.bVo = AnimationUtils.loadAnimation(getContext(), a.C0203a.sdk_push_top_out);
        this.bVo.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.liveroom.tippop.AlaTopTipView.4
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
                if (AlaTopTipView.this.hOJ != null) {
                    AlaTopTipView.this.hOJ.cC(AlaTopTipView.this);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.hOI.setDuration(400L);
        this.hOI.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.liveroom.tippop.AlaTopTipView.5
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (AlaTopTipView.this.mDuration > 0) {
                    AlaTopTipView.this.postDelayed(AlaTopTipView.this.bVq, AlaTopTipView.this.mDuration);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

    private void cnw() {
        if (getContext() != null) {
            this.hOH = new TextView(getContext());
            this.hOH.setTextSize(0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds28));
            int dimensionPixelOffset = getContext().getResources().getDimensionPixelOffset(a.d.sdk_ds30);
            int statusBarHeight = (UtilHelper.canUseStyleImmersiveSticky() && UtilHelper.getRealScreenOrientation(getContext()) == 1) ? UtilHelper.getStatusBarHeight() + dimensionPixelOffset : dimensionPixelOffset;
            int dimensionPixelOffset2 = getContext().getResources().getDimensionPixelOffset(a.d.sdk_ds34);
            this.hOH.setPadding(dimensionPixelOffset2, statusBarHeight, dimensionPixelOffset2, dimensionPixelOffset);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            if (this.hOH != null && this.hOH.getParent() != null) {
                ((ViewGroup) this.hOH.getParent()).removeView(this.hOH);
            }
            addView(this.hOH, layoutParams);
        }
    }

    public void cnx() {
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
        this.epJ = false;
        removeCallbacks(this.bVq);
        if (this != null && getParent() != null) {
            clearAnimation();
            startAnimation(this.bVo);
        }
    }

    private int getRealWidth() {
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(getContext());
        if (screenDimensions.length != 2 || screenDimensions[0] <= 0) {
            return -1;
        }
        return screenDimensions[0];
    }

    public void v(ViewGroup viewGroup, int i) {
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
            startAnimation(this.hOI);
            this.epJ = true;
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
            startAnimation(this.hOI);
            this.epJ = true;
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
            startAnimation(this.hOI);
            this.epJ = true;
        }
    }

    public void gI(boolean z) {
        this.epJ = false;
        onDestroy();
        ViewGroup viewGroup = (ViewGroup) getParent();
        if (viewGroup != null) {
            viewGroup.removeView(this);
        }
        if (z && this.hOJ != null) {
            this.hOJ.cC(this);
        }
    }

    public void setTipDuration(int i) {
        if (i > 0) {
            this.mDuration = i;
        }
    }

    public void cny() {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.width = getRealWidth();
        setLayoutParams(layoutParams);
    }

    public void onChangeSkinType(int i) {
        SkinManager.setBackgroundResource(this, a.c.sdk_white_alpha95, i);
        if (this.hOH != null) {
            SkinManager.setViewTextColor(this.hOH, a.c.sdk_cp_cont_f, 1, i);
        } else {
            SkinManager.setViewTextColor(this, a.c.sdk_cp_cont_f, 1, i);
        }
    }

    public void onDestroy() {
        removeCallbacks(this.bVq);
        clearAnimation();
    }

    public void setOnTipCompletedCallback(a aVar) {
        this.hOJ = aVar;
    }

    public int getType() {
        return this.mType;
    }

    public void setType(int i) {
        this.mType = i;
    }

    public void setText(String str) {
        if (this.hOH != null) {
            this.hOH.setText(str);
        }
    }
}
