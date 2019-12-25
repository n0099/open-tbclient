package com.baidu.tieba.ala.liveroom.views;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.q.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.core.util.ViewCommonUtil;
import com.baidu.live.tbadk.widget.TbImageView;
/* loaded from: classes2.dex */
public class AlaLiveRoomBlurPageLayout extends FrameLayout {
    Runnable aie;
    private AlaLiveView eYo;
    private TbImageView fgE;
    private FrameLayout fgF;
    private View fgG;
    private View fgH;
    private FrameLayout fgI;
    private TextView fgJ;
    private Bitmap fgK;
    private Handler mHandler;
    private TbPageContext mPageContext;
    private ViewGroup mRootView;

    public AlaLiveRoomBlurPageLayout(Context context) {
        super(context);
        this.fgE = null;
        this.fgG = null;
        this.eYo = null;
        this.fgH = null;
        this.fgI = null;
        this.fgJ = null;
        this.aie = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveRoomBlurPageLayout.1
            @Override // java.lang.Runnable
            public void run() {
                AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
                alphaAnimation.setDuration(400L);
                alphaAnimation.setStartOffset(120L);
                alphaAnimation.setInterpolator(new LinearInterpolator());
                alphaAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveRoomBlurPageLayout.1.1
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        AlaLiveRoomBlurPageLayout.this.fgE.setAlpha(0.0f);
                        AlaLiveRoomBlurPageLayout.this.fgE.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                AlaLiveRoomBlurPageLayout.this.fgE.clearAnimation();
                AlaLiveRoomBlurPageLayout.this.fgE.startAnimation(alphaAnimation);
            }
        };
        init();
    }

    public AlaLiveRoomBlurPageLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fgE = null;
        this.fgG = null;
        this.eYo = null;
        this.fgH = null;
        this.fgI = null;
        this.fgJ = null;
        this.aie = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveRoomBlurPageLayout.1
            @Override // java.lang.Runnable
            public void run() {
                AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
                alphaAnimation.setDuration(400L);
                alphaAnimation.setStartOffset(120L);
                alphaAnimation.setInterpolator(new LinearInterpolator());
                alphaAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveRoomBlurPageLayout.1.1
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        AlaLiveRoomBlurPageLayout.this.fgE.setAlpha(0.0f);
                        AlaLiveRoomBlurPageLayout.this.fgE.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                AlaLiveRoomBlurPageLayout.this.fgE.clearAnimation();
                AlaLiveRoomBlurPageLayout.this.fgE.startAnimation(alphaAnimation);
            }
        };
        init();
    }

    public AlaLiveRoomBlurPageLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fgE = null;
        this.fgG = null;
        this.eYo = null;
        this.fgH = null;
        this.fgI = null;
        this.fgJ = null;
        this.aie = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveRoomBlurPageLayout.1
            @Override // java.lang.Runnable
            public void run() {
                AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
                alphaAnimation.setDuration(400L);
                alphaAnimation.setStartOffset(120L);
                alphaAnimation.setInterpolator(new LinearInterpolator());
                alphaAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveRoomBlurPageLayout.1.1
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        AlaLiveRoomBlurPageLayout.this.fgE.setAlpha(0.0f);
                        AlaLiveRoomBlurPageLayout.this.fgE.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                AlaLiveRoomBlurPageLayout.this.fgE.clearAnimation();
                AlaLiveRoomBlurPageLayout.this.fgE.startAnimation(alphaAnimation);
            }
        };
        init();
    }

    private void init() {
        Log.i("LiveRoomBlurPageLayout", "@@ context = " + getContext());
        this.mRootView = (ViewGroup) View.inflate(getContext(), a.h.ala_liveroom_audience_blur_layout, this);
        setClipChildren(false);
        this.fgE = (TbImageView) findViewById(a.g.ala_liveroom_background_img);
        this.fgK = drawableToBitmap(new ColorDrawable(getResources().getColor(a.d.sdk_color_333333)));
        this.fgF = new FrameLayout(getContext());
        this.fgF.setId(a.g.ala_liveroom_player_container_view);
        this.mHandler = new Handler();
    }

    private Bitmap drawableToBitmap(Drawable drawable) {
        Bitmap createBitmap = Bitmap.createBitmap(10, 10, drawable.getOpacity() != -1 ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, 10, 10);
        drawable.draw(canvas);
        return createBitmap;
    }

    public void e(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        int[] screenFullSize = ViewCommonUtil.getScreenFullSize(tbPageContext.getPageActivity());
        bs(screenFullSize[0], screenFullSize[1]);
    }

    private void bs(int i, int i2) {
        if (this.fgE != null) {
            ViewGroup.LayoutParams layoutParams = this.fgE.getLayoutParams();
            layoutParams.width = i;
            layoutParams.height = i2;
            this.fgE.setLayoutParams(layoutParams);
        }
    }

    public void bc(int i, int i2) {
        bs(i, i2);
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (configuration != null) {
            int[] screenFullSize = ViewCommonUtil.getScreenFullSize(this.mPageContext.getPageActivity());
            if (this.fgI != null && this.fgI.getParent() != null) {
                ViewGroup.LayoutParams layoutParams = this.fgI.getLayoutParams();
                layoutParams.width = screenFullSize[0];
                layoutParams.height = screenFullSize[1] - 0;
                this.fgI.setLayoutParams(layoutParams);
            }
        }
    }

    public void a(AlaLiveView alaLiveView, ViewGroup.LayoutParams layoutParams) {
        if (alaLiveView != null) {
            if (this.mRootView.indexOfChild(alaLiveView) < 0 && this.mRootView.getChildCount() > 1) {
                this.eYo = alaLiveView;
                int childCount = this.mRootView.getChildCount() - 1;
                int childCount2 = this.mRootView.getChildCount();
                int i = childCount;
                for (int i2 = 0; i2 < childCount2; i2++) {
                    View childAt = this.mRootView.getChildAt(i2);
                    if (childAt.getId() == a.g.ala_liveroom_player_container_view) {
                        i = Math.max(i, i2);
                    } else if (childAt.getId() == a.g.ala_liveroom_audience_end_view) {
                        i = Math.min(i, i2);
                    } else if (childAt.getId() == a.g.ala_live_room_close_btn_layout) {
                        i = Math.min(i, i2);
                    }
                }
                if (layoutParams != null) {
                    this.mRootView.addView(alaLiveView, i, layoutParams);
                } else {
                    this.mRootView.addView(alaLiveView, i, alaLiveView.getLayoutParams());
                }
            }
            bop();
        }
    }

    public void bok() {
        if (this.eYo != null) {
            this.mRootView.removeView(this.eYo);
        }
        this.eYo = null;
    }

    public void a(View view, ViewGroup.LayoutParams layoutParams, boolean z) {
        if (this.fgF.getParent() != null) {
            this.mRootView.removeView(this.fgF);
        }
        this.mRootView.addView(this.fgF, 1);
        if (this.fgG != null && this.fgG.getParent() != null) {
            ((ViewGroup) this.fgG.getParent()).removeView(this.fgG);
        }
        this.fgG = view;
        if (this.fgG != null && this.fgG.getParent() != null) {
            ((ViewGroup) this.fgG.getParent()).removeView(this.fgG);
        }
        if (this.fgG != null) {
            if (layoutParams != null) {
                this.fgF.addView(this.fgG, layoutParams);
            } else {
                this.fgF.addView(this.fgG, this.fgG.getLayoutParams());
            }
        }
    }

    public void bjl() {
        if (this.fgF.getParent() != null) {
            ((ViewGroup) this.fgF.getParent()).removeView(this.fgF);
        }
        if (this.fgG != null && this.fgG.getParent() != null) {
            ((ViewGroup) this.fgG.getParent()).removeView(this.fgG);
        }
        this.fgG = null;
    }

    public boolean bx(View view) {
        return (this.fgF == null || this.fgF.getParent() == null || this.fgF.indexOfChild(view) < 0) ? false : true;
    }

    public void b(View view, ViewGroup.LayoutParams layoutParams) {
        if (this.fgH != null && this.mRootView.indexOfChild(this.fgH) >= 0) {
            this.mRootView.removeView(this.fgH);
        }
        this.fgH = view;
        int childCount = this.mRootView.getChildCount() - 1;
        int childCount2 = this.mRootView.getChildCount();
        int i = childCount;
        for (int i2 = 0; i2 < childCount2; i2++) {
            if (this.mRootView.getChildAt(i2).getId() == a.g.ala_live_room_close_btn_layout) {
                i = Math.max(i, i2);
            }
        }
        if (this.fgH != null) {
            this.mRootView.addView(this.fgH, i, layoutParams);
        }
        bop();
    }

    public void bol() {
        if (this.fgH != null) {
            this.mRootView.removeView(this.fgH);
        }
        this.fgH = null;
    }

    public void bom() {
        if (this.fgE.getAlpha() == 1.0f) {
            this.fgE.clearAnimation();
            this.mHandler.postDelayed(this.aie, 300L);
            return;
        }
        this.fgE.clearAnimation();
        this.fgE.setAlpha(0.0f);
        this.fgE.setVisibility(8);
    }

    public void bon() {
        this.mHandler.removeCallbacks(this.aie);
        this.fgE.clearAnimation();
        this.fgE.setAlpha(0.0f);
        this.fgE.setVisibility(8);
    }

    public void boo() {
        this.mHandler.removeCallbacks(this.aie);
        this.fgE.clearAnimation();
        this.fgE.setAlpha(1.0f);
        this.fgE.setVisibility(0);
    }

    public void setBackImageBlack(AlaLiveInfoData alaLiveInfoData) {
        if ((alaLiveInfoData == null || alaLiveInfoData.screen_direction != 2) && this.fgE != null) {
            this.fgE.setImageDrawable(null);
            this.fgE.setBackgroundColor(this.mPageContext.getResources().getColor(a.d.sdk_transparent));
        }
    }

    public void setBgImageUrl(String str, int i, AlaLiveInfoData alaLiveInfoData) {
        if (this.mPageContext != null && !TextUtils.isEmpty(str)) {
            int[] screenFullSize = ViewCommonUtil.getScreenFullSize(this.mPageContext.getPageActivity());
            bs(screenFullSize[0], screenFullSize[1]);
            if (alaLiveInfoData != null && alaLiveInfoData.screen_direction == 2) {
                this.fgE.setImageBitmap(this.fgK);
            } else if (!TextUtils.isEmpty(str)) {
                this.fgE.startLoad(str, 39, false, false);
            } else {
                this.fgE.setBackgroundResource(a.f.pic_avatar_moren);
            }
        }
    }

    public void setBgImageUrl(String str, AlaLiveInfoData alaLiveInfoData) {
        setBgImageUrl(str, 10, alaLiveInfoData);
    }

    public void release() {
        if (this.fgE != null) {
            this.fgE.setImageDrawable(null);
            this.fgE.stopLoad();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (this.eYo != null && !this.eYo.isDestroy) {
            z = this.eYo.z(motionEvent);
        }
        if (z || motionEvent.getAction() == 0) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void jB(boolean z) {
        Context context = getContext();
        if (this.fgJ == null) {
            this.fgI = new FrameLayout(context);
            this.fgI.setBackgroundColor(getContext().getResources().getColor(a.d.sdk_cp_cont_b));
            this.fgJ = new TextView(context);
            this.fgJ.setText(context.getResources().getString(a.i.ala_live_private_tip));
            this.fgJ.setTextSize(0, context.getResources().getDimensionPixelSize(a.e.sdk_ds28));
            this.fgJ.setTextColor(context.getResources().getColor(a.d.sdk_cp_cont_i_alpha40));
            this.fgJ.setGravity(49);
            Drawable drawable = context.getResources().getDrawable(a.f.private_tip);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            this.fgJ.setCompoundDrawables(null, drawable, null, null);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.topMargin = jC(z);
            layoutParams.gravity = 1;
            this.fgI.addView(this.fgJ, layoutParams);
            int indexOfChild = this.eYo != null ? this.mRootView.indexOfChild(this.eYo) : -1;
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
            int[] screenFullSize = ViewCommonUtil.getScreenFullSize(this.mPageContext.getPageActivity());
            int statusBarHeight = !UtilHelper.canUseStyleImmersiveSticky() ? UtilHelper.getStatusBarHeight() : 0;
            layoutParams2.width = screenFullSize[0];
            layoutParams2.height = screenFullSize[1] - statusBarHeight;
            if (indexOfChild < 0) {
                this.mRootView.addView(this.fgI, layoutParams2);
            } else {
                this.mRootView.addView(this.fgI, indexOfChild, layoutParams2);
            }
        } else {
            if (this.fgI.getParent() != null) {
                this.mRootView.removeView(this.fgI);
            }
            int indexOfChild2 = this.eYo != null ? this.mRootView.indexOfChild(this.eYo) : -1;
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -1);
            int[] screenFullSize2 = ViewCommonUtil.getScreenFullSize(this.mPageContext.getPageActivity());
            int statusBarHeight2 = !UtilHelper.canUseStyleImmersiveSticky() ? UtilHelper.getStatusBarHeight() : 0;
            layoutParams3.width = screenFullSize2[0];
            layoutParams3.height = screenFullSize2[1] - statusBarHeight2;
            if (indexOfChild2 < 0) {
                this.mRootView.addView(this.fgI, layoutParams3);
            } else {
                this.mRootView.addView(this.fgI, indexOfChild2, layoutParams3);
            }
            FrameLayout.LayoutParams layoutParams4 = (FrameLayout.LayoutParams) this.fgJ.getLayoutParams();
            layoutParams4.topMargin = jC(z);
            this.fgJ.setLayoutParams(layoutParams4);
        }
        this.fgI.setVisibility(0);
        this.fgJ.setVisibility(0);
        if (this.fgG != null) {
            this.fgG.setVisibility(8);
        }
        if (this.fgE != null) {
            this.fgE.setVisibility(8);
        }
    }

    public void B(int i, boolean z) {
        FrameLayout.LayoutParams layoutParams;
        if (this.fgJ != null) {
            if (this.fgJ.getLayoutParams() != null && (this.fgJ.getLayoutParams() instanceof FrameLayout.LayoutParams)) {
                layoutParams = (FrameLayout.LayoutParams) this.fgJ.getLayoutParams();
            } else {
                layoutParams = new FrameLayout.LayoutParams(-2, -2);
            }
            if (i == 2) {
                layoutParams.topMargin = getResources().getDimensionPixelSize(a.e.sdk_ds45);
                layoutParams.gravity = 1;
                this.fgJ.setLayoutParams(layoutParams);
                return;
            }
            layoutParams.topMargin = jC(z);
            layoutParams.gravity = 1;
            this.fgJ.setLayoutParams(layoutParams);
        }
    }

    public void bop() {
        if (this.fgI != null && this.fgI.getParent() != null) {
            ((ViewGroup) this.fgI.getParent()).removeView(this.fgI);
        }
        if (this.fgG != null) {
            this.fgG.setVisibility(0);
        }
        if (this.fgE != null) {
            this.fgE.setVisibility(0);
        }
    }

    public boolean boq() {
        return (this.fgI == null || this.fgI.getParent() == null) ? false : true;
    }

    private int jC(boolean z) {
        if (z) {
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                return UtilHelper.getStatusBarHeight();
            }
            return 0;
        }
        return this.mPageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds160);
    }

    public void bor() {
        View findViewWithTag = findViewWithTag("AlaLivePraiseGuideController");
        if (findViewWithTag != null) {
            removeView(findViewWithTag);
        }
    }
}
