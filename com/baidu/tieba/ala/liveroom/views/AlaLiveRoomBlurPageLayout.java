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
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.core.util.ViewCommonUtil;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.live.u.a;
/* loaded from: classes3.dex */
public class AlaLiveRoomBlurPageLayout extends FrameLayout implements com.baidu.live.o.e {
    private AlaLiveView fJb;
    private TbImageView fRR;
    private FrameLayout fRS;
    private View fRT;
    private View fRU;
    private FrameLayout fRV;
    private TextView fRW;
    private Bitmap fRX;
    Runnable fRY;
    private Handler mHandler;
    private TbPageContext mPageContext;
    private ViewGroup mRootView;

    public AlaLiveRoomBlurPageLayout(Context context) {
        super(context);
        this.fRR = null;
        this.fRT = null;
        this.fJb = null;
        this.fRU = null;
        this.fRV = null;
        this.fRW = null;
        this.fRY = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveRoomBlurPageLayout.1
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
                        AlaLiveRoomBlurPageLayout.this.fRR.setAlpha(0.0f);
                        AlaLiveRoomBlurPageLayout.this.fRR.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                AlaLiveRoomBlurPageLayout.this.fRR.clearAnimation();
                AlaLiveRoomBlurPageLayout.this.fRR.startAnimation(alphaAnimation);
            }
        };
        init();
    }

    public AlaLiveRoomBlurPageLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fRR = null;
        this.fRT = null;
        this.fJb = null;
        this.fRU = null;
        this.fRV = null;
        this.fRW = null;
        this.fRY = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveRoomBlurPageLayout.1
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
                        AlaLiveRoomBlurPageLayout.this.fRR.setAlpha(0.0f);
                        AlaLiveRoomBlurPageLayout.this.fRR.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                AlaLiveRoomBlurPageLayout.this.fRR.clearAnimation();
                AlaLiveRoomBlurPageLayout.this.fRR.startAnimation(alphaAnimation);
            }
        };
        init();
    }

    public AlaLiveRoomBlurPageLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fRR = null;
        this.fRT = null;
        this.fJb = null;
        this.fRU = null;
        this.fRV = null;
        this.fRW = null;
        this.fRY = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveRoomBlurPageLayout.1
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
                        AlaLiveRoomBlurPageLayout.this.fRR.setAlpha(0.0f);
                        AlaLiveRoomBlurPageLayout.this.fRR.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                AlaLiveRoomBlurPageLayout.this.fRR.clearAnimation();
                AlaLiveRoomBlurPageLayout.this.fRR.startAnimation(alphaAnimation);
            }
        };
        init();
    }

    private void init() {
        Log.i("LiveRoomBlurPageLayout", "@@ context = " + getContext());
        this.mRootView = (ViewGroup) View.inflate(getContext(), a.h.ala_liveroom_audience_blur_layout, this);
        setClipChildren(false);
        this.fRR = (TbImageView) findViewById(a.g.ala_liveroom_background_img);
        this.fRX = drawableToBitmap(new ColorDrawable(getResources().getColor(a.d.sdk_color_333333)));
        this.fRS = new FrameLayout(getContext());
        this.fRS.setId(a.g.ala_liveroom_player_container_view);
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
        by(screenFullSize[0], screenFullSize[1]);
    }

    private void by(int i, int i2) {
        if (this.fRR != null) {
            ViewGroup.LayoutParams layoutParams = this.fRR.getLayoutParams();
            layoutParams.width = i;
            layoutParams.height = i2;
            this.fRR.setLayoutParams(layoutParams);
        }
    }

    public void bm(int i, int i2) {
        by(i, i2);
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (configuration != null) {
            int[] screenFullSize = ViewCommonUtil.getScreenFullSize(this.mPageContext.getPageActivity());
            if (this.fRV != null && this.fRV.getParent() != null) {
                ViewGroup.LayoutParams layoutParams = this.fRV.getLayoutParams();
                layoutParams.width = screenFullSize[0];
                layoutParams.height = screenFullSize[1] - 0;
                this.fRV.setLayoutParams(layoutParams);
            }
        }
    }

    public void a(AlaLiveView alaLiveView, ViewGroup.LayoutParams layoutParams) {
        if (alaLiveView != null) {
            if (this.mRootView.indexOfChild(alaLiveView) < 0 && this.mRootView.getChildCount() > 1) {
                this.fJb = alaLiveView;
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
            bAB();
        }
    }

    public void bAw() {
        if (this.fJb != null) {
            this.mRootView.removeView(this.fJb);
        }
        this.fJb = null;
    }

    @Override // com.baidu.live.o.e
    public ViewGroup getLiveContainerView() {
        return this;
    }

    public void a(View view, ViewGroup.LayoutParams layoutParams, boolean z) {
        if (this.fRS.getParent() != null) {
            this.mRootView.removeView(this.fRS);
        }
        this.mRootView.addView(this.fRS, 1);
        if (this.fRT != null && this.fRT.getParent() != null) {
            ((ViewGroup) this.fRT.getParent()).removeView(this.fRT);
        }
        this.fRT = view;
        if (this.fRT != null && this.fRT.getParent() != null) {
            ((ViewGroup) this.fRT.getParent()).removeView(this.fRT);
        }
        if (this.fRT != null) {
            if (layoutParams != null) {
                this.fRS.addView(this.fRT, layoutParams);
            } else {
                this.fRS.addView(this.fRT, this.fRT.getLayoutParams());
            }
        }
    }

    public void Ho() {
        if (this.fRS.getParent() != null) {
            ((ViewGroup) this.fRS.getParent()).removeView(this.fRS);
        }
        if (this.fRT != null && this.fRT.getParent() != null) {
            ((ViewGroup) this.fRT.getParent()).removeView(this.fRT);
        }
        this.fRT = null;
    }

    public boolean bH(View view) {
        return (this.fRS == null || this.fRS.getParent() == null || this.fRS.indexOfChild(view) < 0) ? false : true;
    }

    public void b(View view, ViewGroup.LayoutParams layoutParams) {
        if (this.fRU != null && this.mRootView.indexOfChild(this.fRU) >= 0) {
            this.mRootView.removeView(this.fRU);
        }
        this.fRU = view;
        int childCount = this.mRootView.getChildCount() - 1;
        int childCount2 = this.mRootView.getChildCount();
        int i = childCount;
        for (int i2 = 0; i2 < childCount2; i2++) {
            if (this.mRootView.getChildAt(i2).getId() == a.g.ala_live_room_close_btn_layout) {
                i = Math.max(i, i2);
            }
        }
        if (this.fRU != null) {
            this.mRootView.addView(this.fRU, i, layoutParams);
        }
        bAB();
    }

    public void bAx() {
        if (this.fRU != null) {
            this.mRootView.removeView(this.fRU);
        }
        this.fRU = null;
    }

    public void bAy() {
        if (this.fRR.getAlpha() == 1.0f) {
            this.fRR.clearAnimation();
            this.mHandler.postDelayed(this.fRY, 300L);
            return;
        }
        this.fRR.clearAnimation();
        this.fRR.setAlpha(0.0f);
        this.fRR.setVisibility(8);
    }

    public void bAz() {
        this.mHandler.removeCallbacks(this.fRY);
        this.fRR.clearAnimation();
        this.fRR.setAlpha(0.0f);
        this.fRR.setVisibility(8);
    }

    public void bAA() {
        this.mHandler.removeCallbacks(this.fRY);
        this.fRR.clearAnimation();
        this.fRR.setAlpha(1.0f);
        this.fRR.setVisibility(0);
    }

    public void setBackImageBlack(AlaLiveInfoData alaLiveInfoData) {
        if ((alaLiveInfoData == null || alaLiveInfoData.screen_direction != 2) && this.fRR != null) {
            this.fRR.setImageDrawable(null);
            this.fRR.setBackgroundColor(this.mPageContext.getResources().getColor(a.d.sdk_transparent));
        }
    }

    public void setBgImageUrl(String str, int i, AlaLiveInfoData alaLiveInfoData) {
        if (this.mPageContext != null && !TextUtils.isEmpty(str)) {
            int[] screenFullSize = ViewCommonUtil.getScreenFullSize(this.mPageContext.getPageActivity());
            by(screenFullSize[0], screenFullSize[1]);
            if (alaLiveInfoData != null && alaLiveInfoData.screen_direction == 2) {
                this.fRR.setImageBitmap(this.fRX);
            } else if (!TextUtils.isEmpty(str)) {
                this.fRR.startLoad(str, 39, false, false);
            } else {
                this.fRR.setBackgroundResource(a.f.pic_avatar_moren);
            }
        }
    }

    public void setBgImageUrl(String str, AlaLiveInfoData alaLiveInfoData) {
        setBgImageUrl(str, 10, alaLiveInfoData);
    }

    public void release() {
        if (this.fRR != null) {
            this.fRR.setImageDrawable(null);
            this.fRR.stopLoad();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (this.fJb != null && !this.fJb.fSk) {
            z = this.fJb.z(motionEvent);
        }
        if (z || motionEvent.getAction() == 0) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void kU(boolean z) {
        Context context = getContext();
        if (this.fRW == null) {
            this.fRV = new FrameLayout(context);
            this.fRV.setBackgroundColor(getContext().getResources().getColor(a.d.sdk_cp_cont_b));
            this.fRW = new TextView(context);
            this.fRW.setText(context.getResources().getString(a.i.ala_live_private_tip));
            this.fRW.setTextSize(0, context.getResources().getDimensionPixelSize(a.e.sdk_ds28));
            this.fRW.setTextColor(context.getResources().getColor(a.d.sdk_cp_cont_i_alpha40));
            this.fRW.setGravity(49);
            Drawable drawable = context.getResources().getDrawable(a.f.private_tip);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            this.fRW.setCompoundDrawables(null, drawable, null, null);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.topMargin = kV(z);
            layoutParams.gravity = 1;
            this.fRV.addView(this.fRW, layoutParams);
            int indexOfChild = this.fJb != null ? this.mRootView.indexOfChild(this.fJb) : -1;
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
            int[] screenFullSize = ViewCommonUtil.getScreenFullSize(this.mPageContext.getPageActivity());
            int statusBarHeight = !UtilHelper.canUseStyleImmersiveSticky() ? UtilHelper.getStatusBarHeight() : 0;
            layoutParams2.width = screenFullSize[0];
            layoutParams2.height = screenFullSize[1] - statusBarHeight;
            if (indexOfChild < 0) {
                this.mRootView.addView(this.fRV, layoutParams2);
            } else {
                this.mRootView.addView(this.fRV, indexOfChild, layoutParams2);
            }
        } else {
            if (this.fRV.getParent() != null) {
                this.mRootView.removeView(this.fRV);
            }
            int indexOfChild2 = this.fJb != null ? this.mRootView.indexOfChild(this.fJb) : -1;
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -1);
            int[] screenFullSize2 = ViewCommonUtil.getScreenFullSize(this.mPageContext.getPageActivity());
            int statusBarHeight2 = !UtilHelper.canUseStyleImmersiveSticky() ? UtilHelper.getStatusBarHeight() : 0;
            layoutParams3.width = screenFullSize2[0];
            layoutParams3.height = screenFullSize2[1] - statusBarHeight2;
            if (indexOfChild2 < 0) {
                this.mRootView.addView(this.fRV, layoutParams3);
            } else {
                this.mRootView.addView(this.fRV, indexOfChild2, layoutParams3);
            }
            FrameLayout.LayoutParams layoutParams4 = (FrameLayout.LayoutParams) this.fRW.getLayoutParams();
            layoutParams4.topMargin = kV(z);
            this.fRW.setLayoutParams(layoutParams4);
        }
        this.fRV.setVisibility(0);
        this.fRW.setVisibility(0);
        if (this.fRT != null) {
            this.fRT.setVisibility(8);
        }
        if (this.fRR != null) {
            this.fRR.setVisibility(8);
        }
    }

    public void D(int i, boolean z) {
        FrameLayout.LayoutParams layoutParams;
        if (this.fRW != null) {
            if (this.fRW.getLayoutParams() != null && (this.fRW.getLayoutParams() instanceof FrameLayout.LayoutParams)) {
                layoutParams = (FrameLayout.LayoutParams) this.fRW.getLayoutParams();
            } else {
                layoutParams = new FrameLayout.LayoutParams(-2, -2);
            }
            if (i == 2) {
                layoutParams.topMargin = getResources().getDimensionPixelSize(a.e.sdk_ds45);
                layoutParams.gravity = 1;
                this.fRW.setLayoutParams(layoutParams);
                return;
            }
            layoutParams.topMargin = kV(z);
            layoutParams.gravity = 1;
            this.fRW.setLayoutParams(layoutParams);
        }
    }

    public void bAB() {
        if (this.fRV != null && this.fRV.getParent() != null) {
            ((ViewGroup) this.fRV.getParent()).removeView(this.fRV);
        }
        if (this.fRT != null) {
            this.fRT.setVisibility(0);
        }
        if (this.fRR != null) {
            this.fRR.setVisibility(0);
        }
    }

    public boolean bAC() {
        return (this.fRV == null || this.fRV.getParent() == null) ? false : true;
    }

    private int kV(boolean z) {
        if (z) {
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                return UtilHelper.getStatusBarHeight();
            }
            return 0;
        }
        return this.mPageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds160);
    }

    public void bAD() {
        View findViewWithTag = findViewWithTag("AlaLivePraiseGuideController");
        if (findViewWithTag != null) {
            removeView(findViewWithTag);
        }
    }
}
