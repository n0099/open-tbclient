package com.baidu.tieba.ala.liveroom.views;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.net.Uri;
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
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
/* loaded from: classes4.dex */
public class AlaLiveRoomBlurPageLayout extends FrameLayout implements com.baidu.live.q.e {
    private AlaLiveView gUa;
    private AlaLiveRoomCoverLayout hdU;
    private SimpleDraweeView hdV;
    private FrameLayout hdW;
    private View hdX;
    private View hdY;
    private FrameLayout hdZ;
    private TextView hea;
    Runnable heb;
    private Handler mHandler;
    private TbPageContext mPageContext;
    private ViewGroup mRootView;

    public AlaLiveRoomBlurPageLayout(Context context) {
        super(context);
        this.hdV = null;
        this.hdX = null;
        this.gUa = null;
        this.hdY = null;
        this.hdZ = null;
        this.hea = null;
        this.heb = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveRoomBlurPageLayout.1
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
                        AlaLiveRoomBlurPageLayout.this.hdV.setAlpha(0.0f);
                        AlaLiveRoomBlurPageLayout.this.hdU.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                AlaLiveRoomBlurPageLayout.this.hdV.clearAnimation();
                AlaLiveRoomBlurPageLayout.this.hdV.startAnimation(alphaAnimation);
            }
        };
        init();
    }

    public AlaLiveRoomBlurPageLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hdV = null;
        this.hdX = null;
        this.gUa = null;
        this.hdY = null;
        this.hdZ = null;
        this.hea = null;
        this.heb = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveRoomBlurPageLayout.1
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
                        AlaLiveRoomBlurPageLayout.this.hdV.setAlpha(0.0f);
                        AlaLiveRoomBlurPageLayout.this.hdU.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                AlaLiveRoomBlurPageLayout.this.hdV.clearAnimation();
                AlaLiveRoomBlurPageLayout.this.hdV.startAnimation(alphaAnimation);
            }
        };
        init();
    }

    public AlaLiveRoomBlurPageLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hdV = null;
        this.hdX = null;
        this.gUa = null;
        this.hdY = null;
        this.hdZ = null;
        this.hea = null;
        this.heb = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveRoomBlurPageLayout.1
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
                        AlaLiveRoomBlurPageLayout.this.hdV.setAlpha(0.0f);
                        AlaLiveRoomBlurPageLayout.this.hdU.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                AlaLiveRoomBlurPageLayout.this.hdV.clearAnimation();
                AlaLiveRoomBlurPageLayout.this.hdV.startAnimation(alphaAnimation);
            }
        };
        init();
    }

    private void init() {
        Log.i("LiveRoomBlurPageLayout", "@@ context = " + getContext());
        this.mRootView = (ViewGroup) View.inflate(getContext(), a.h.ala_liveroom_audience_blur_layout, this);
        setClipChildren(false);
        this.hdU = (AlaLiveRoomCoverLayout) findViewById(a.g.layout_liveroom_cover);
        this.hdV = this.hdU.hee;
        this.hdW = new FrameLayout(getContext());
        this.hdW.setId(a.g.ala_liveroom_player_container_view);
        this.mHandler = new Handler();
    }

    public void c(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        int[] screenFullSize = ViewCommonUtil.getScreenFullSize(tbPageContext.getPageActivity());
        bR(screenFullSize[0], screenFullSize[1]);
    }

    private void bR(int i, int i2) {
        if (this.hdU != null && this.hdU.getLayoutParams() != null && i > 0 && i2 > 0) {
            ViewGroup.LayoutParams layoutParams = this.hdU.getLayoutParams();
            layoutParams.width = i;
            layoutParams.height = i2;
            this.hdU.setLayoutParams(layoutParams);
        }
    }

    public void D(int i, int i2) {
        bR(i, i2);
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (configuration != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null) {
            int[] screenFullSize = ViewCommonUtil.getScreenFullSize(this.mPageContext.getPageActivity());
            if (this.hdZ != null && this.hdZ.getParent() != null) {
                ViewGroup.LayoutParams layoutParams = this.hdZ.getLayoutParams();
                layoutParams.width = screenFullSize[0];
                layoutParams.height = screenFullSize[1] - 0;
                this.hdZ.setLayoutParams(layoutParams);
            }
        }
    }

    public void a(AlaLiveView alaLiveView, ViewGroup.LayoutParams layoutParams) {
        if (alaLiveView != null) {
            if (this.mRootView.indexOfChild(alaLiveView) < 0 && this.mRootView.getChildCount() > 1) {
                this.gUa = alaLiveView;
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
            ccm();
        }
    }

    public void ccj() {
        if (this.gUa != null) {
            this.mRootView.removeView(this.gUa);
        }
        this.gUa = null;
    }

    @Override // com.baidu.live.q.e
    public ViewGroup getLiveContainerView() {
        return this;
    }

    public void a(View view, ViewGroup.LayoutParams layoutParams, boolean z) {
        if (this.hdW.getParent() != null) {
            this.mRootView.removeView(this.hdW);
        }
        this.mRootView.addView(this.hdW, 1);
        if (this.hdX != null && this.hdX.getParent() != null) {
            ((ViewGroup) this.hdX.getParent()).removeView(this.hdX);
        }
        this.hdX = view;
        if (this.hdX != null && this.hdX.getParent() != null) {
            ((ViewGroup) this.hdX.getParent()).removeView(this.hdX);
        }
        if (this.hdX != null) {
            if (layoutParams != null) {
                this.hdW.addView(this.hdX, layoutParams);
            } else {
                this.hdW.addView(this.hdX, this.hdX.getLayoutParams());
            }
        }
    }

    public void ST() {
        if (this.hdW.getParent() != null) {
            ((ViewGroup) this.hdW.getParent()).removeView(this.hdW);
        }
        if (this.hdX != null && this.hdX.getParent() != null) {
            ((ViewGroup) this.hdX.getParent()).removeView(this.hdX);
        }
        this.hdX = null;
    }

    public boolean cb(View view) {
        return (this.hdW == null || this.hdW.getParent() == null || this.hdW.indexOfChild(view) < 0) ? false : true;
    }

    public void c(View view, ViewGroup.LayoutParams layoutParams) {
        if (this.hdY != null && this.mRootView.indexOfChild(this.hdY) >= 0) {
            this.mRootView.removeView(this.hdY);
        }
        this.hdY = view;
        int childCount = this.mRootView.getChildCount() - 1;
        int childCount2 = this.mRootView.getChildCount();
        int i = childCount;
        for (int i2 = 0; i2 < childCount2; i2++) {
            if (this.mRootView.getChildAt(i2).getId() == a.g.ala_live_room_close_btn_layout) {
                i = Math.max(i, i2);
            }
        }
        if (this.hdY != null) {
            this.mRootView.addView(this.hdY, i, layoutParams);
        }
        ccm();
    }

    public void cck() {
        if (this.hdY != null) {
            this.mRootView.removeView(this.hdY);
        }
        this.hdY = null;
    }

    public void ccl() {
        this.mHandler.removeCallbacks(this.heb);
        this.hdV.clearAnimation();
        this.hdV.setAlpha(1.0f);
        this.hdU.setVisibility(0);
    }

    public void setBackImageBlack(AlaLiveInfoData alaLiveInfoData) {
        if ((alaLiveInfoData == null || alaLiveInfoData.screen_direction != 2) && this.hdV != null) {
            this.hdV.setImageDrawable(null);
            this.hdV.setBackgroundColor(this.mPageContext.getResources().getColor(a.d.sdk_transparent));
        }
    }

    public void setBgImageUrl(String str, int i, AlaLiveInfoData alaLiveInfoData) {
        if (this.mPageContext != null && !TextUtils.isEmpty(str)) {
            int[] screenFullSize = ViewCommonUtil.getScreenFullSize(this.mPageContext.getPageActivity());
            bR(screenFullSize[0], screenFullSize[1]);
            if (!TextUtils.isEmpty(str)) {
                a(this.hdV, str, 2, 20);
            } else {
                this.hdV.setBackgroundResource(a.f.pic_avatar_moren);
            }
        }
    }

    public void a(SimpleDraweeView simpleDraweeView, String str, int i, int i2) {
        try {
            simpleDraweeView.setController(com.facebook.drawee.a.a.c.dXf().c(simpleDraweeView.getController()).bj(ImageRequestBuilder.ad(Uri.parse(str)).a(new com.facebook.imagepipeline.j.a(i, i2)).eej()).dXW());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setBgImageUrl(String str, AlaLiveInfoData alaLiveInfoData) {
        setBgImageUrl(str, 10, alaLiveInfoData);
    }

    public void release() {
        if (this.hdV != null) {
            this.hdV.setImageDrawable(null);
            this.hdV.setController(null);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (this.gUa != null && !this.gUa.heo) {
            z = this.gUa.V(motionEvent);
        }
        if (z || motionEvent.getAction() == 0) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void no(boolean z) {
        Context context = getContext();
        if (this.hea == null) {
            this.hdZ = new FrameLayout(context);
            this.hdZ.setBackgroundColor(getContext().getResources().getColor(a.d.sdk_cp_cont_b));
            this.hea = new TextView(context);
            this.hea.setText(context.getResources().getString(a.i.ala_live_private_tip));
            this.hea.setTextSize(0, context.getResources().getDimensionPixelSize(a.e.sdk_ds28));
            this.hea.setTextColor(context.getResources().getColor(a.d.sdk_cp_cont_i_alpha40));
            this.hea.setGravity(49);
            Drawable drawable = context.getResources().getDrawable(a.f.private_tip);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            this.hea.setCompoundDrawables(null, drawable, null, null);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.topMargin = np(z);
            layoutParams.gravity = 1;
            this.hdZ.addView(this.hea, layoutParams);
            int indexOfChild = this.gUa != null ? this.mRootView.indexOfChild(this.gUa) : -1;
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
            int[] screenFullSize = ViewCommonUtil.getScreenFullSize(this.mPageContext.getPageActivity());
            int statusBarHeight = !UtilHelper.canUseStyleImmersiveSticky() ? UtilHelper.getStatusBarHeight() : 0;
            layoutParams2.width = screenFullSize[0];
            layoutParams2.height = screenFullSize[1] - statusBarHeight;
            if (indexOfChild < 0) {
                this.mRootView.addView(this.hdZ, layoutParams2);
            } else {
                this.mRootView.addView(this.hdZ, indexOfChild, layoutParams2);
            }
        } else {
            if (this.hdZ.getParent() != null) {
                this.mRootView.removeView(this.hdZ);
            }
            int indexOfChild2 = this.gUa != null ? this.mRootView.indexOfChild(this.gUa) : -1;
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -1);
            int[] screenFullSize2 = ViewCommonUtil.getScreenFullSize(this.mPageContext.getPageActivity());
            int statusBarHeight2 = !UtilHelper.canUseStyleImmersiveSticky() ? UtilHelper.getStatusBarHeight() : 0;
            layoutParams3.width = screenFullSize2[0];
            layoutParams3.height = screenFullSize2[1] - statusBarHeight2;
            if (indexOfChild2 < 0) {
                this.mRootView.addView(this.hdZ, layoutParams3);
            } else {
                this.mRootView.addView(this.hdZ, indexOfChild2, layoutParams3);
            }
            FrameLayout.LayoutParams layoutParams4 = (FrameLayout.LayoutParams) this.hea.getLayoutParams();
            layoutParams4.topMargin = np(z);
            this.hea.setLayoutParams(layoutParams4);
        }
        this.hdZ.setVisibility(0);
        this.hea.setVisibility(0);
        if (this.hdX != null) {
            this.hdX.setVisibility(8);
        }
        if (this.hdU != null) {
            this.hdU.setVisibility(8);
        }
    }

    public void M(int i, boolean z) {
        FrameLayout.LayoutParams layoutParams;
        if (this.hea != null) {
            if (this.hea.getLayoutParams() != null && (this.hea.getLayoutParams() instanceof FrameLayout.LayoutParams)) {
                layoutParams = (FrameLayout.LayoutParams) this.hea.getLayoutParams();
            } else {
                layoutParams = new FrameLayout.LayoutParams(-2, -2);
            }
            if (i == 2) {
                layoutParams.topMargin = getResources().getDimensionPixelSize(a.e.sdk_ds45);
                layoutParams.gravity = 1;
                this.hea.setLayoutParams(layoutParams);
                return;
            }
            layoutParams.topMargin = np(z);
            layoutParams.gravity = 1;
            this.hea.setLayoutParams(layoutParams);
        }
    }

    public void ccm() {
        if (this.hdZ != null && this.hdZ.getParent() != null) {
            ((ViewGroup) this.hdZ.getParent()).removeView(this.hdZ);
        }
        if (this.hdX != null) {
            this.hdX.setVisibility(0);
        }
        if (this.hdU != null) {
            this.hdU.setVisibility(0);
        }
    }

    public boolean ccn() {
        return (this.hdZ == null || this.hdZ.getParent() == null) ? false : true;
    }

    private int np(boolean z) {
        if (z) {
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                return UtilHelper.getStatusBarHeight();
            }
            return 0;
        }
        return this.mPageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds160);
    }

    public void cco() {
        View findViewWithTag = findViewWithTag("AlaLivePraiseGuideController");
        if (findViewWithTag != null) {
            removeView(findViewWithTag);
        }
    }
}
