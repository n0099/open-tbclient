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
    private AlaLiveView gCd;
    private TbImageView gLH;
    private FrameLayout gLI;
    private View gLJ;
    private View gLK;
    private FrameLayout gLL;
    private TextView gLM;
    private Bitmap gLN;
    Runnable gLO;
    private Handler mHandler;
    private TbPageContext mPageContext;
    private ViewGroup mRootView;

    public AlaLiveRoomBlurPageLayout(Context context) {
        super(context);
        this.gLH = null;
        this.gLJ = null;
        this.gCd = null;
        this.gLK = null;
        this.gLL = null;
        this.gLM = null;
        this.gLO = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveRoomBlurPageLayout.1
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
                        AlaLiveRoomBlurPageLayout.this.gLH.setAlpha(0.0f);
                        AlaLiveRoomBlurPageLayout.this.gLH.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                AlaLiveRoomBlurPageLayout.this.gLH.clearAnimation();
                AlaLiveRoomBlurPageLayout.this.gLH.startAnimation(alphaAnimation);
            }
        };
        init();
    }

    public AlaLiveRoomBlurPageLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gLH = null;
        this.gLJ = null;
        this.gCd = null;
        this.gLK = null;
        this.gLL = null;
        this.gLM = null;
        this.gLO = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveRoomBlurPageLayout.1
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
                        AlaLiveRoomBlurPageLayout.this.gLH.setAlpha(0.0f);
                        AlaLiveRoomBlurPageLayout.this.gLH.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                AlaLiveRoomBlurPageLayout.this.gLH.clearAnimation();
                AlaLiveRoomBlurPageLayout.this.gLH.startAnimation(alphaAnimation);
            }
        };
        init();
    }

    public AlaLiveRoomBlurPageLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gLH = null;
        this.gLJ = null;
        this.gCd = null;
        this.gLK = null;
        this.gLL = null;
        this.gLM = null;
        this.gLO = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveRoomBlurPageLayout.1
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
                        AlaLiveRoomBlurPageLayout.this.gLH.setAlpha(0.0f);
                        AlaLiveRoomBlurPageLayout.this.gLH.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                AlaLiveRoomBlurPageLayout.this.gLH.clearAnimation();
                AlaLiveRoomBlurPageLayout.this.gLH.startAnimation(alphaAnimation);
            }
        };
        init();
    }

    private void init() {
        Log.i("LiveRoomBlurPageLayout", "@@ context = " + getContext());
        this.mRootView = (ViewGroup) View.inflate(getContext(), a.h.ala_liveroom_audience_blur_layout, this);
        setClipChildren(false);
        this.gLH = (TbImageView) findViewById(a.g.ala_liveroom_background_img);
        this.gLN = drawableToBitmap(new ColorDrawable(getResources().getColor(a.d.sdk_color_333333)));
        this.gLI = new FrameLayout(getContext());
        this.gLI.setId(a.g.ala_liveroom_player_container_view);
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
        if (this.gLH != null) {
            ViewGroup.LayoutParams layoutParams = this.gLH.getLayoutParams();
            layoutParams.width = i;
            layoutParams.height = i2;
            this.gLH.setLayoutParams(layoutParams);
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
            if (this.gLL != null && this.gLL.getParent() != null) {
                ViewGroup.LayoutParams layoutParams = this.gLL.getLayoutParams();
                layoutParams.width = screenFullSize[0];
                layoutParams.height = screenFullSize[1] - 0;
                this.gLL.setLayoutParams(layoutParams);
            }
        }
    }

    public void a(AlaLiveView alaLiveView, ViewGroup.LayoutParams layoutParams) {
        if (alaLiveView != null) {
            if (this.mRootView.indexOfChild(alaLiveView) < 0 && this.mRootView.getChildCount() > 1) {
                this.gCd = alaLiveView;
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
            bXh();
        }
    }

    public void bXc() {
        if (this.gCd != null) {
            this.mRootView.removeView(this.gCd);
        }
        this.gCd = null;
    }

    @Override // com.baidu.live.p.e
    public ViewGroup getLiveContainerView() {
        return this;
    }

    public void a(View view, ViewGroup.LayoutParams layoutParams, boolean z) {
        if (this.gLI.getParent() != null) {
            this.mRootView.removeView(this.gLI);
        }
        this.mRootView.addView(this.gLI, 1);
        if (this.gLJ != null && this.gLJ.getParent() != null) {
            ((ViewGroup) this.gLJ.getParent()).removeView(this.gLJ);
        }
        this.gLJ = view;
        if (this.gLJ != null && this.gLJ.getParent() != null) {
            ((ViewGroup) this.gLJ.getParent()).removeView(this.gLJ);
        }
        if (this.gLJ != null) {
            if (layoutParams != null) {
                this.gLI.addView(this.gLJ, layoutParams);
            } else {
                this.gLI.addView(this.gLJ, this.gLJ.getLayoutParams());
            }
        }
    }

    public void Qt() {
        if (this.gLI.getParent() != null) {
            ((ViewGroup) this.gLI.getParent()).removeView(this.gLI);
        }
        if (this.gLJ != null && this.gLJ.getParent() != null) {
            ((ViewGroup) this.gLJ.getParent()).removeView(this.gLJ);
        }
        this.gLJ = null;
    }

    public boolean bS(View view) {
        return (this.gLI == null || this.gLI.getParent() == null || this.gLI.indexOfChild(view) < 0) ? false : true;
    }

    public void c(View view, ViewGroup.LayoutParams layoutParams) {
        if (this.gLK != null && this.mRootView.indexOfChild(this.gLK) >= 0) {
            this.mRootView.removeView(this.gLK);
        }
        this.gLK = view;
        int childCount = this.mRootView.getChildCount() - 1;
        int childCount2 = this.mRootView.getChildCount();
        int i = childCount;
        for (int i2 = 0; i2 < childCount2; i2++) {
            if (this.mRootView.getChildAt(i2).getId() == a.g.ala_live_room_close_btn_layout) {
                i = Math.max(i, i2);
            }
        }
        if (this.gLK != null) {
            this.mRootView.addView(this.gLK, i, layoutParams);
        }
        bXh();
    }

    public void bXd() {
        if (this.gLK != null) {
            this.mRootView.removeView(this.gLK);
        }
        this.gLK = null;
    }

    public void bXe() {
        if (this.gLH.getAlpha() == 1.0f) {
            this.gLH.clearAnimation();
            this.mHandler.postDelayed(this.gLO, 300L);
            return;
        }
        this.gLH.clearAnimation();
        this.gLH.setAlpha(0.0f);
        this.gLH.setVisibility(8);
    }

    public void bXf() {
        this.mHandler.removeCallbacks(this.gLO);
        this.gLH.clearAnimation();
        this.gLH.setAlpha(0.0f);
        this.gLH.setVisibility(8);
    }

    public void bXg() {
        this.mHandler.removeCallbacks(this.gLO);
        this.gLH.clearAnimation();
        this.gLH.setAlpha(1.0f);
        this.gLH.setVisibility(0);
    }

    public void setBackImageBlack(AlaLiveInfoData alaLiveInfoData) {
        if ((alaLiveInfoData == null || alaLiveInfoData.screen_direction != 2) && this.gLH != null) {
            this.gLH.setImageDrawable(null);
            this.gLH.setBackgroundColor(this.mPageContext.getResources().getColor(a.d.sdk_transparent));
        }
    }

    public void setBgImageUrl(String str, int i, AlaLiveInfoData alaLiveInfoData) {
        if (this.mPageContext != null && !TextUtils.isEmpty(str)) {
            int[] screenFullSize = ViewCommonUtil.getScreenFullSize(this.mPageContext.getPageActivity());
            bR(screenFullSize[0], screenFullSize[1]);
            if (alaLiveInfoData != null && alaLiveInfoData.screen_direction == 2) {
                this.gLH.setImageBitmap(this.gLN);
            } else if (!TextUtils.isEmpty(str)) {
                this.gLH.startLoad(str, 39, false, false);
            } else {
                this.gLH.setBackgroundResource(a.f.pic_avatar_moren);
            }
        }
    }

    public void setBgImageUrl(String str, AlaLiveInfoData alaLiveInfoData) {
        setBgImageUrl(str, 10, alaLiveInfoData);
    }

    public void release() {
        if (this.gLH != null) {
            this.gLH.setImageDrawable(null);
            this.gLH.stopLoad();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (this.gCd != null && !this.gCd.gMb) {
            z = this.gCd.V(motionEvent);
        }
        if (z || motionEvent.getAction() == 0) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void mH(boolean z) {
        Context context = getContext();
        if (this.gLM == null) {
            this.gLL = new FrameLayout(context);
            this.gLL.setBackgroundColor(getContext().getResources().getColor(a.d.sdk_cp_cont_b));
            this.gLM = new TextView(context);
            this.gLM.setText(context.getResources().getString(a.i.ala_live_private_tip));
            this.gLM.setTextSize(0, context.getResources().getDimensionPixelSize(a.e.sdk_ds28));
            this.gLM.setTextColor(context.getResources().getColor(a.d.sdk_cp_cont_i_alpha40));
            this.gLM.setGravity(49);
            Drawable drawable = context.getResources().getDrawable(a.f.private_tip);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            this.gLM.setCompoundDrawables(null, drawable, null, null);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.topMargin = mI(z);
            layoutParams.gravity = 1;
            this.gLL.addView(this.gLM, layoutParams);
            int indexOfChild = this.gCd != null ? this.mRootView.indexOfChild(this.gCd) : -1;
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
            int[] screenFullSize = ViewCommonUtil.getScreenFullSize(this.mPageContext.getPageActivity());
            int statusBarHeight = !UtilHelper.canUseStyleImmersiveSticky() ? UtilHelper.getStatusBarHeight() : 0;
            layoutParams2.width = screenFullSize[0];
            layoutParams2.height = screenFullSize[1] - statusBarHeight;
            if (indexOfChild < 0) {
                this.mRootView.addView(this.gLL, layoutParams2);
            } else {
                this.mRootView.addView(this.gLL, indexOfChild, layoutParams2);
            }
        } else {
            if (this.gLL.getParent() != null) {
                this.mRootView.removeView(this.gLL);
            }
            int indexOfChild2 = this.gCd != null ? this.mRootView.indexOfChild(this.gCd) : -1;
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -1);
            int[] screenFullSize2 = ViewCommonUtil.getScreenFullSize(this.mPageContext.getPageActivity());
            int statusBarHeight2 = !UtilHelper.canUseStyleImmersiveSticky() ? UtilHelper.getStatusBarHeight() : 0;
            layoutParams3.width = screenFullSize2[0];
            layoutParams3.height = screenFullSize2[1] - statusBarHeight2;
            if (indexOfChild2 < 0) {
                this.mRootView.addView(this.gLL, layoutParams3);
            } else {
                this.mRootView.addView(this.gLL, indexOfChild2, layoutParams3);
            }
            FrameLayout.LayoutParams layoutParams4 = (FrameLayout.LayoutParams) this.gLM.getLayoutParams();
            layoutParams4.topMargin = mI(z);
            this.gLM.setLayoutParams(layoutParams4);
        }
        this.gLL.setVisibility(0);
        this.gLM.setVisibility(0);
        if (this.gLJ != null) {
            this.gLJ.setVisibility(8);
        }
        if (this.gLH != null) {
            this.gLH.setVisibility(8);
        }
    }

    public void K(int i, boolean z) {
        FrameLayout.LayoutParams layoutParams;
        if (this.gLM != null) {
            if (this.gLM.getLayoutParams() != null && (this.gLM.getLayoutParams() instanceof FrameLayout.LayoutParams)) {
                layoutParams = (FrameLayout.LayoutParams) this.gLM.getLayoutParams();
            } else {
                layoutParams = new FrameLayout.LayoutParams(-2, -2);
            }
            if (i == 2) {
                layoutParams.topMargin = getResources().getDimensionPixelSize(a.e.sdk_ds45);
                layoutParams.gravity = 1;
                this.gLM.setLayoutParams(layoutParams);
                return;
            }
            layoutParams.topMargin = mI(z);
            layoutParams.gravity = 1;
            this.gLM.setLayoutParams(layoutParams);
        }
    }

    public void bXh() {
        if (this.gLL != null && this.gLL.getParent() != null) {
            ((ViewGroup) this.gLL.getParent()).removeView(this.gLL);
        }
        if (this.gLJ != null) {
            this.gLJ.setVisibility(0);
        }
        if (this.gLH != null) {
            this.gLH.setVisibility(0);
        }
    }

    public boolean bXi() {
        return (this.gLL == null || this.gLL.getParent() == null) ? false : true;
    }

    private int mI(boolean z) {
        if (z) {
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                return UtilHelper.getStatusBarHeight();
            }
            return 0;
        }
        return this.mPageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds160);
    }

    public void bXj() {
        View findViewWithTag = findViewWithTag("AlaLivePraiseGuideController");
        if (findViewWithTag != null) {
            removeView(findViewWithTag);
        }
    }
}
