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
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.core.util.ViewCommonUtil;
import com.baidu.live.tbadk.widget.TbImageView;
/* loaded from: classes7.dex */
public class AlaLiveRoomBlurPageLayout extends FrameLayout implements com.baidu.live.p.e {
    private AlaLiveView gBZ;
    private TbImageView gLD;
    private FrameLayout gLE;
    private View gLF;
    private View gLG;
    private FrameLayout gLH;
    private TextView gLI;
    private Bitmap gLJ;
    Runnable gLK;
    private Handler mHandler;
    private TbPageContext mPageContext;
    private ViewGroup mRootView;

    public AlaLiveRoomBlurPageLayout(Context context) {
        super(context);
        this.gLD = null;
        this.gLF = null;
        this.gBZ = null;
        this.gLG = null;
        this.gLH = null;
        this.gLI = null;
        this.gLK = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveRoomBlurPageLayout.1
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
                        AlaLiveRoomBlurPageLayout.this.gLD.setAlpha(0.0f);
                        AlaLiveRoomBlurPageLayout.this.gLD.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                AlaLiveRoomBlurPageLayout.this.gLD.clearAnimation();
                AlaLiveRoomBlurPageLayout.this.gLD.startAnimation(alphaAnimation);
            }
        };
        init();
    }

    public AlaLiveRoomBlurPageLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gLD = null;
        this.gLF = null;
        this.gBZ = null;
        this.gLG = null;
        this.gLH = null;
        this.gLI = null;
        this.gLK = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveRoomBlurPageLayout.1
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
                        AlaLiveRoomBlurPageLayout.this.gLD.setAlpha(0.0f);
                        AlaLiveRoomBlurPageLayout.this.gLD.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                AlaLiveRoomBlurPageLayout.this.gLD.clearAnimation();
                AlaLiveRoomBlurPageLayout.this.gLD.startAnimation(alphaAnimation);
            }
        };
        init();
    }

    public AlaLiveRoomBlurPageLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gLD = null;
        this.gLF = null;
        this.gBZ = null;
        this.gLG = null;
        this.gLH = null;
        this.gLI = null;
        this.gLK = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveRoomBlurPageLayout.1
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
                        AlaLiveRoomBlurPageLayout.this.gLD.setAlpha(0.0f);
                        AlaLiveRoomBlurPageLayout.this.gLD.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                AlaLiveRoomBlurPageLayout.this.gLD.clearAnimation();
                AlaLiveRoomBlurPageLayout.this.gLD.startAnimation(alphaAnimation);
            }
        };
        init();
    }

    private void init() {
        Log.i("LiveRoomBlurPageLayout", "@@ context = " + getContext());
        this.mRootView = (ViewGroup) View.inflate(getContext(), a.h.ala_liveroom_audience_blur_layout, this);
        setClipChildren(false);
        this.gLD = (TbImageView) findViewById(a.g.ala_liveroom_background_img);
        this.gLJ = drawableToBitmap(new ColorDrawable(getResources().getColor(a.d.sdk_color_333333)));
        this.gLE = new FrameLayout(getContext());
        this.gLE.setId(a.g.ala_liveroom_player_container_view);
        this.mHandler = new Handler();
    }

    private Bitmap drawableToBitmap(Drawable drawable) {
        Bitmap createBitmap = Bitmap.createBitmap(10, 10, drawable.getOpacity() != -1 ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, 10, 10);
        drawable.draw(canvas);
        return createBitmap;
    }

    public void c(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        int[] screenFullSize = ViewCommonUtil.getScreenFullSize(tbPageContext.getPageActivity());
        bR(screenFullSize[0], screenFullSize[1]);
    }

    private void bR(int i, int i2) {
        if (this.gLD != null) {
            ViewGroup.LayoutParams layoutParams = this.gLD.getLayoutParams();
            layoutParams.width = i;
            layoutParams.height = i2;
            this.gLD.setLayoutParams(layoutParams);
        }
    }

    public void D(int i, int i2) {
        bR(i, i2);
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (configuration != null) {
            int[] screenFullSize = ViewCommonUtil.getScreenFullSize(this.mPageContext.getPageActivity());
            if (this.gLH != null && this.gLH.getParent() != null) {
                ViewGroup.LayoutParams layoutParams = this.gLH.getLayoutParams();
                layoutParams.width = screenFullSize[0];
                layoutParams.height = screenFullSize[1] - 0;
                this.gLH.setLayoutParams(layoutParams);
            }
        }
    }

    public void a(AlaLiveView alaLiveView, ViewGroup.LayoutParams layoutParams) {
        if (alaLiveView != null) {
            if (this.mRootView.indexOfChild(alaLiveView) < 0 && this.mRootView.getChildCount() > 1) {
                this.gBZ = alaLiveView;
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
            bXg();
        }
    }

    public void bXb() {
        if (this.gBZ != null) {
            this.mRootView.removeView(this.gBZ);
        }
        this.gBZ = null;
    }

    @Override // com.baidu.live.p.e
    public ViewGroup getLiveContainerView() {
        return this;
    }

    public void a(View view, ViewGroup.LayoutParams layoutParams, boolean z) {
        if (this.gLE.getParent() != null) {
            this.mRootView.removeView(this.gLE);
        }
        this.mRootView.addView(this.gLE, 1);
        if (this.gLF != null && this.gLF.getParent() != null) {
            ((ViewGroup) this.gLF.getParent()).removeView(this.gLF);
        }
        this.gLF = view;
        if (this.gLF != null && this.gLF.getParent() != null) {
            ((ViewGroup) this.gLF.getParent()).removeView(this.gLF);
        }
        if (this.gLF != null) {
            if (layoutParams != null) {
                this.gLE.addView(this.gLF, layoutParams);
            } else {
                this.gLE.addView(this.gLF, this.gLF.getLayoutParams());
            }
        }
    }

    public void Qt() {
        if (this.gLE.getParent() != null) {
            ((ViewGroup) this.gLE.getParent()).removeView(this.gLE);
        }
        if (this.gLF != null && this.gLF.getParent() != null) {
            ((ViewGroup) this.gLF.getParent()).removeView(this.gLF);
        }
        this.gLF = null;
    }

    public boolean bS(View view) {
        return (this.gLE == null || this.gLE.getParent() == null || this.gLE.indexOfChild(view) < 0) ? false : true;
    }

    public void c(View view, ViewGroup.LayoutParams layoutParams) {
        if (this.gLG != null && this.mRootView.indexOfChild(this.gLG) >= 0) {
            this.mRootView.removeView(this.gLG);
        }
        this.gLG = view;
        int childCount = this.mRootView.getChildCount() - 1;
        int childCount2 = this.mRootView.getChildCount();
        int i = childCount;
        for (int i2 = 0; i2 < childCount2; i2++) {
            if (this.mRootView.getChildAt(i2).getId() == a.g.ala_live_room_close_btn_layout) {
                i = Math.max(i, i2);
            }
        }
        if (this.gLG != null) {
            this.mRootView.addView(this.gLG, i, layoutParams);
        }
        bXg();
    }

    public void bXc() {
        if (this.gLG != null) {
            this.mRootView.removeView(this.gLG);
        }
        this.gLG = null;
    }

    public void bXd() {
        if (this.gLD.getAlpha() == 1.0f) {
            this.gLD.clearAnimation();
            this.mHandler.postDelayed(this.gLK, 300L);
            return;
        }
        this.gLD.clearAnimation();
        this.gLD.setAlpha(0.0f);
        this.gLD.setVisibility(8);
    }

    public void bXe() {
        this.mHandler.removeCallbacks(this.gLK);
        this.gLD.clearAnimation();
        this.gLD.setAlpha(0.0f);
        this.gLD.setVisibility(8);
    }

    public void bXf() {
        this.mHandler.removeCallbacks(this.gLK);
        this.gLD.clearAnimation();
        this.gLD.setAlpha(1.0f);
        this.gLD.setVisibility(0);
    }

    public void setBackImageBlack(AlaLiveInfoData alaLiveInfoData) {
        if ((alaLiveInfoData == null || alaLiveInfoData.screen_direction != 2) && this.gLD != null) {
            this.gLD.setImageDrawable(null);
            this.gLD.setBackgroundColor(this.mPageContext.getResources().getColor(a.d.sdk_transparent));
        }
    }

    public void setBgImageUrl(String str, int i, AlaLiveInfoData alaLiveInfoData) {
        if (this.mPageContext != null && !TextUtils.isEmpty(str)) {
            int[] screenFullSize = ViewCommonUtil.getScreenFullSize(this.mPageContext.getPageActivity());
            bR(screenFullSize[0], screenFullSize[1]);
            if (alaLiveInfoData != null && alaLiveInfoData.screen_direction == 2) {
                this.gLD.setImageBitmap(this.gLJ);
            } else if (!TextUtils.isEmpty(str)) {
                this.gLD.startLoad(str, 39, false, false);
            } else {
                this.gLD.setBackgroundResource(a.f.pic_avatar_moren);
            }
        }
    }

    public void setBgImageUrl(String str, AlaLiveInfoData alaLiveInfoData) {
        setBgImageUrl(str, 10, alaLiveInfoData);
    }

    public void release() {
        if (this.gLD != null) {
            this.gLD.setImageDrawable(null);
            this.gLD.stopLoad();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (this.gBZ != null && !this.gBZ.gLX) {
            z = this.gBZ.V(motionEvent);
        }
        if (z || motionEvent.getAction() == 0) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void mF(boolean z) {
        Context context = getContext();
        if (this.gLI == null) {
            this.gLH = new FrameLayout(context);
            this.gLH.setBackgroundColor(getContext().getResources().getColor(a.d.sdk_cp_cont_b));
            this.gLI = new TextView(context);
            this.gLI.setText(context.getResources().getString(a.i.ala_live_private_tip));
            this.gLI.setTextSize(0, context.getResources().getDimensionPixelSize(a.e.sdk_ds28));
            this.gLI.setTextColor(context.getResources().getColor(a.d.sdk_cp_cont_i_alpha40));
            this.gLI.setGravity(49);
            Drawable drawable = context.getResources().getDrawable(a.f.private_tip);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            this.gLI.setCompoundDrawables(null, drawable, null, null);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.topMargin = mG(z);
            layoutParams.gravity = 1;
            this.gLH.addView(this.gLI, layoutParams);
            int indexOfChild = this.gBZ != null ? this.mRootView.indexOfChild(this.gBZ) : -1;
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
            int[] screenFullSize = ViewCommonUtil.getScreenFullSize(this.mPageContext.getPageActivity());
            int statusBarHeight = !UtilHelper.canUseStyleImmersiveSticky() ? UtilHelper.getStatusBarHeight() : 0;
            layoutParams2.width = screenFullSize[0];
            layoutParams2.height = screenFullSize[1] - statusBarHeight;
            if (indexOfChild < 0) {
                this.mRootView.addView(this.gLH, layoutParams2);
            } else {
                this.mRootView.addView(this.gLH, indexOfChild, layoutParams2);
            }
        } else {
            if (this.gLH.getParent() != null) {
                this.mRootView.removeView(this.gLH);
            }
            int indexOfChild2 = this.gBZ != null ? this.mRootView.indexOfChild(this.gBZ) : -1;
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -1);
            int[] screenFullSize2 = ViewCommonUtil.getScreenFullSize(this.mPageContext.getPageActivity());
            int statusBarHeight2 = !UtilHelper.canUseStyleImmersiveSticky() ? UtilHelper.getStatusBarHeight() : 0;
            layoutParams3.width = screenFullSize2[0];
            layoutParams3.height = screenFullSize2[1] - statusBarHeight2;
            if (indexOfChild2 < 0) {
                this.mRootView.addView(this.gLH, layoutParams3);
            } else {
                this.mRootView.addView(this.gLH, indexOfChild2, layoutParams3);
            }
            FrameLayout.LayoutParams layoutParams4 = (FrameLayout.LayoutParams) this.gLI.getLayoutParams();
            layoutParams4.topMargin = mG(z);
            this.gLI.setLayoutParams(layoutParams4);
        }
        this.gLH.setVisibility(0);
        this.gLI.setVisibility(0);
        if (this.gLF != null) {
            this.gLF.setVisibility(8);
        }
        if (this.gLD != null) {
            this.gLD.setVisibility(8);
        }
    }

    public void K(int i, boolean z) {
        FrameLayout.LayoutParams layoutParams;
        if (this.gLI != null) {
            if (this.gLI.getLayoutParams() != null && (this.gLI.getLayoutParams() instanceof FrameLayout.LayoutParams)) {
                layoutParams = (FrameLayout.LayoutParams) this.gLI.getLayoutParams();
            } else {
                layoutParams = new FrameLayout.LayoutParams(-2, -2);
            }
            if (i == 2) {
                layoutParams.topMargin = getResources().getDimensionPixelSize(a.e.sdk_ds45);
                layoutParams.gravity = 1;
                this.gLI.setLayoutParams(layoutParams);
                return;
            }
            layoutParams.topMargin = mG(z);
            layoutParams.gravity = 1;
            this.gLI.setLayoutParams(layoutParams);
        }
    }

    public void bXg() {
        if (this.gLH != null && this.gLH.getParent() != null) {
            ((ViewGroup) this.gLH.getParent()).removeView(this.gLH);
        }
        if (this.gLF != null) {
            this.gLF.setVisibility(0);
        }
        if (this.gLD != null) {
            this.gLD.setVisibility(0);
        }
    }

    public boolean bXh() {
        return (this.gLH == null || this.gLH.getParent() == null) ? false : true;
    }

    private int mG(boolean z) {
        if (z) {
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                return UtilHelper.getStatusBarHeight();
            }
            return 0;
        }
        return this.mPageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds160);
    }

    public void bXi() {
        View findViewWithTag = findViewWithTag("AlaLivePraiseGuideController");
        if (findViewWithTag != null) {
            removeView(findViewWithTag);
        }
    }
}
