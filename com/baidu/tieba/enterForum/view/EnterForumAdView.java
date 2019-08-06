package com.baidu.tieba.enterForum.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.home.EnterForumDelegateStatic;
/* loaded from: classes4.dex */
public class EnterForumAdView extends FrameLayout {
    private ImageView ahs;
    private int eWi;
    private Drawable fbA;
    private Drawable fbB;
    private Drawable fbC;
    private Drawable fbD;
    private boolean fbE;
    private TbImageView fbF;
    private ViewEventCenter fbG;
    private boolean fbH;
    private View fbI;
    private float fbJ;
    private com.baidu.tieba.enterForum.data.a fbK;
    private boolean fbL;
    private boolean isShow;
    private BdUniqueId mTag;

    public EnterForumAdView(@NonNull Context context) {
        super(context);
        this.fbE = false;
        this.fbH = false;
        this.isShow = false;
        this.fbL = false;
        init(context);
    }

    public EnterForumAdView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fbE = false;
        this.fbH = false;
        this.isShow = false;
        this.fbL = false;
        init(context);
    }

    public EnterForumAdView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fbE = false;
        this.fbH = false;
        this.isShow = false;
        this.fbL = false;
        init(context);
    }

    private void init(Context context) {
        setClipChildren(true);
        this.fbD = new ColorDrawable(1241513984);
        this.fbA = context.getResources().getDrawable(R.drawable.enter_forum_ad_top_shader);
        this.fbB = context.getResources().getDrawable(R.drawable.enter_forum_ad_bottom_shader2);
        this.fbC = context.getResources().getDrawable(R.drawable.enter_forum_ad_bottom_shader2_1);
        this.fbI = new View(context);
        this.fbI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.EnterForumAdView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EnterForumAdView.a(EnterForumAdView.this.mTag, EnterForumAdView.this.getContext());
            }
        });
        this.fbI.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.enterForum.view.EnterForumAdView.2
            private float fbN = 0.0f;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        EnterForumAdView.this.fbJ = motionEvent.getRawY();
                        return true;
                    case 1:
                        if (EnterForumAdView.this.fbJ <= (EnterForumAdView.this.getResources().getDisplayMetrics().heightPixels * 2) / 3 || motionEvent.getRawY() >= EnterForumAdView.this.fbJ) {
                            EnterForumAdView.this.bgO();
                            if (this.fbN < 50.0f) {
                                EnterForumAdView.this.fbI.performClick();
                            }
                        } else {
                            EnterForumAdView.this.bgP();
                        }
                        EnterForumAdView.this.fbJ = 0.0f;
                        this.fbN = 0.0f;
                        return true;
                    case 2:
                        if (motionEvent.getRawY() < EnterForumAdView.this.fbJ) {
                            EnterForumAdView.this.setFullscreenAdImageViewPosition(motionEvent.getRawY() - EnterForumAdView.this.fbJ);
                            if (EnterForumAdView.this.ahs != null) {
                                EnterForumAdView.this.ahs.setVisibility(8);
                            }
                        }
                        if (Math.abs(motionEvent.getRawY() - EnterForumAdView.this.fbJ) > this.fbN) {
                            this.fbN = Math.abs(motionEvent.getRawY() - EnterForumAdView.this.fbJ);
                            return true;
                        }
                        return true;
                    default:
                        if (EnterForumAdView.this.fbJ <= (EnterForumAdView.this.getResources().getDisplayMetrics().heightPixels * 2) / 3 || motionEvent.getRawY() >= EnterForumAdView.this.fbJ) {
                            EnterForumAdView.this.bgO();
                        } else {
                            EnterForumAdView.this.bgP();
                        }
                        EnterForumAdView.this.fbJ = 0.0f;
                        this.fbN = 0.0f;
                        return true;
                }
            }
        });
        this.ahs = new ImageView(context);
        this.ahs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.EnterForumAdView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EnterForumAdView.this.bgP();
            }
        });
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.EnterForumAdView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EnterForumAdView.a(EnterForumAdView.this.mTag, EnterForumAdView.this.getContext());
            }
        });
    }

    public void setEventCenter(ViewEventCenter viewEventCenter) {
        this.fbG = viewEventCenter;
    }

    public void setTag(BdUniqueId bdUniqueId) {
        this.mTag = bdUniqueId;
    }

    public void setAdData() {
        bgN();
    }

    private void bgN() {
        an a;
        if (this.fbF == null) {
            this.fbF = (TbImageView) findViewById(R.id.enter_forum_ad_image);
            this.fbF.setDefaultBgResource(com.baidu.tbadk.util.e.Qr());
            this.fbF.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.enterForum.view.EnterForumAdView.5
                @Override // com.baidu.tbadk.widget.TbImageView.a
                public void P(String str, boolean z) {
                    if (z) {
                        EnterForumAdView.this.fbE = false;
                        EnterForumAdView.this.invalidate();
                    }
                }

                @Override // com.baidu.tbadk.widget.TbImageView.a
                public void onCancel() {
                }
            });
        }
        com.baidu.tieba.enterForum.data.a bgl = EnterForumDelegateStatic.eWZ.bgl();
        if (bgl != null) {
            this.fbE = true;
            this.fbF.startLoad(bgl.eWd, 38, false);
            invalidate();
            if (this.fbG != null) {
                com.baidu.tieba.enterForum.data.b bVar = new com.baidu.tieba.enterForum.data.b();
                bVar.eWf = true;
                bVar.eWg = false;
                bVar.eWh = getBottom();
                bVar.eWi = this.eWi;
                com.baidu.tbadk.mvc.c.b bVar2 = new com.baidu.tbadk.mvc.c.b(16, null, null, null);
                bVar2.a(bVar);
                this.fbG.dispatchMvcEvent(bVar2);
            }
            setVisibility(0);
            if (this.fbK != bgl && (a = com.baidu.tieba.q.a.a(false, "a025", "common_exp", 0, 0, true, String.valueOf(bgl.eWc), String.valueOf(bgl.eWc), 5)) != null) {
                com.baidu.tieba.q.c.coG().a(this.mTag, "enterfourm_att_" + bgl.eWc, a);
                com.baidu.tieba.q.c.coG().b(this.mTag, false);
            }
        } else {
            if (this.fbG != null) {
                com.baidu.tieba.enterForum.data.b bVar3 = new com.baidu.tieba.enterForum.data.b();
                bVar3.eWf = false;
                bVar3.eWg = false;
                bVar3.eWh = getBottom();
                bVar3.eWi = this.eWi;
                com.baidu.tbadk.mvc.c.b bVar4 = new com.baidu.tbadk.mvc.c.b(16, null, null, null);
                bVar4.a(bVar3);
                this.fbG.dispatchMvcEvent(bVar4);
            }
            setVisibility(8);
        }
        this.fbK = bgl;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.fbD.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
        this.fbA.setBounds(0, 0, getMeasuredWidth(), getResources().getDimensionPixelOffset(R.dimen.tbds260));
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.tbds240);
        this.fbB.setBounds(0, getMeasuredHeight() - dimensionPixelOffset, getMeasuredWidth(), getMeasuredHeight());
        this.fbC.setBounds(0, getMeasuredHeight() - dimensionPixelOffset, getMeasuredWidth(), getMeasuredHeight());
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.fbA.setBounds(0, -i2, getMeasuredWidth(), (-i2) + getResources().getDimensionPixelOffset(R.dimen.tbds260));
        if (z && EnterForumDelegateStatic.eWZ.bgl() != null && this.fbG != null) {
            com.baidu.tieba.enterForum.data.b bVar = new com.baidu.tieba.enterForum.data.b();
            bVar.eWf = true;
            bVar.eWg = false;
            bVar.eWh = i4;
            bVar.eWi = this.eWi;
            com.baidu.tbadk.mvc.c.b bVar2 = new com.baidu.tbadk.mvc.c.b(16, null, null, null);
            bVar2.a(bVar);
            this.fbG.dispatchMvcEvent(bVar2);
        }
    }

    @Override // android.view.View
    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        super.setLayoutParams(layoutParams);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.fbE) {
            this.fbD.draw(canvas);
        }
        this.fbA.draw(canvas);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFullscreenAdImageViewPosition(float f) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.fbF.getLayoutParams();
        marginLayoutParams.topMargin = (int) f;
        this.fbF.setLayoutParams(marginLayoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bgO() {
        if (this.ahs != null) {
            this.ahs.setVisibility(0);
        }
        TranslateAnimation translateAnimation = new TranslateAnimation(0, 0.0f, 0, 0.0f, 0, 0.0f, 0, -((ViewGroup.MarginLayoutParams) this.fbF.getLayoutParams()).topMargin);
        translateAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.enterForum.view.EnterForumAdView.6
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                com.baidu.adp.lib.g.e.iK().post(new Runnable() { // from class: com.baidu.tieba.enterForum.view.EnterForumAdView.6.1
                    @Override // java.lang.Runnable
                    public void run() {
                        EnterForumAdView.this.setFullscreenAdImageViewPosition(0.0f);
                    }
                });
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        translateAnimation.setDuration(300L);
        this.fbF.startAnimation(translateAnimation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bgP() {
        this.fbL = false;
        int[] iArr = new int[2];
        getLocationInWindow(iArr);
        this.ahs.setVisibility(8);
        TranslateAnimation translateAnimation = new TranslateAnimation(0, 0.0f, 0, 0.0f, 0, 0.0f, 0, iArr[1] - ((ViewGroup.MarginLayoutParams) this.fbF.getLayoutParams()).topMargin);
        translateAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.enterForum.view.EnterForumAdView.7
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                com.baidu.adp.lib.g.e.iK().post(new Runnable() { // from class: com.baidu.tieba.enterForum.view.EnterForumAdView.7.1
                    @Override // java.lang.Runnable
                    public void run() {
                        ViewGroup viewGroup = (ViewGroup) EnterForumAdView.this.fbF.getParent();
                        viewGroup.removeView(EnterForumAdView.this.fbF);
                        viewGroup.removeView(EnterForumAdView.this.fbI);
                        viewGroup.removeView(EnterForumAdView.this.ahs);
                        EnterForumAdView.this.ahs.setVisibility(0);
                        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                        layoutParams.addRule(10);
                        EnterForumAdView.this.addView(EnterForumAdView.this.fbF, layoutParams);
                        EnterForumAdView.this.fbF.requestLayout();
                        EnterForumAdView.this.fbF.invalidate();
                    }
                });
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        translateAnimation.setDuration(300L);
        this.fbF.startAnimation(translateAnimation);
    }

    public void setAdViewHeight(int i) {
        this.eWi = i;
    }

    public static final void a(BdUniqueId bdUniqueId, Context context) {
        an a;
        com.baidu.tieba.enterForum.data.a bgl = EnterForumDelegateStatic.eWZ.bgl();
        if (bgl != null) {
            String str = EnterForumDelegateStatic.eWZ.bgl().bDN;
            if (!TextUtils.isEmpty(str)) {
                if (context != null) {
                    com.baidu.tbadk.browser.a.ae(context, str);
                }
                if (bdUniqueId != null && (a = com.baidu.tieba.q.a.a(true, "a025", "common_click", 0, 0, true, String.valueOf(bgl.eWc), String.valueOf(bgl.eWc), 5)) != null) {
                    com.baidu.tieba.q.c.coG().b(bdUniqueId, a);
                }
            }
        }
    }

    public void setRecentlyIsExtend(boolean z) {
        this.fbH = z;
        invalidate();
    }

    public void setRecentlyIsShow(boolean z) {
        this.isShow = z;
        invalidate();
    }

    public boolean bgQ() {
        return this.fbH;
    }

    public boolean bgR() {
        return this.isShow;
    }

    public void bM(View view) {
        if ((view instanceof FrameLayout) && !this.fbL) {
            this.fbL = true;
            int[] iArr = new int[2];
            this.fbF.getLocationInWindow(iArr);
            removeView(this.fbF);
            am.c(this.ahs, (int) R.drawable.icon_jinba_retract_n);
            FrameLayout frameLayout = (FrameLayout) view;
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            layoutParams.height = view.getHeight();
            if (this.fbF.getParent() == null) {
                frameLayout.addView(this.fbF, layoutParams);
            }
            if (this.fbI.getParent() == null) {
                frameLayout.addView(this.fbI, new FrameLayout.LayoutParams(-1, -1));
            }
            if (this.ahs.getParent() == null) {
                FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
                layoutParams2.bottomMargin = getResources().getDimensionPixelOffset(R.dimen.tbds107);
                layoutParams2.gravity = 81;
                frameLayout.addView(this.ahs, layoutParams2);
            }
            TranslateAnimation translateAnimation = new TranslateAnimation(0, 0.0f, 0, 0.0f, 0, iArr[1], 0, 0.0f);
            translateAnimation.setDuration(500L);
            this.fbF.startAnimation(translateAnimation);
        }
    }
}
