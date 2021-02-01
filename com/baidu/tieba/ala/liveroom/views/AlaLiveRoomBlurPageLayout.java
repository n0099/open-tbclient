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
import com.baidu.live.tieba.view.fresco.SimpleDraweeView;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
/* loaded from: classes11.dex */
public class AlaLiveRoomBlurPageLayout extends FrameLayout implements com.baidu.live.u.e {
    private AlaLiveView hGp;
    private AlaLiveRoomCoverLayout hQO;
    private SimpleDraweeView hQP;
    private FrameLayout hQQ;
    private View hQR;
    private View hQS;
    private FrameLayout hQT;
    private TextView hQU;
    Runnable hQV;
    private Handler mHandler;
    private TbPageContext mPageContext;
    private ViewGroup mRootView;

    public AlaLiveRoomBlurPageLayout(Context context) {
        super(context);
        this.hQP = null;
        this.hQR = null;
        this.hGp = null;
        this.hQS = null;
        this.hQT = null;
        this.hQU = null;
        this.hQV = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveRoomBlurPageLayout.1
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
                        AlaLiveRoomBlurPageLayout.this.hQP.setAlpha(0.0f);
                        AlaLiveRoomBlurPageLayout.this.hQO.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                AlaLiveRoomBlurPageLayout.this.hQP.clearAnimation();
                AlaLiveRoomBlurPageLayout.this.hQP.startAnimation(alphaAnimation);
            }
        };
        init();
    }

    public AlaLiveRoomBlurPageLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hQP = null;
        this.hQR = null;
        this.hGp = null;
        this.hQS = null;
        this.hQT = null;
        this.hQU = null;
        this.hQV = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveRoomBlurPageLayout.1
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
                        AlaLiveRoomBlurPageLayout.this.hQP.setAlpha(0.0f);
                        AlaLiveRoomBlurPageLayout.this.hQO.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                AlaLiveRoomBlurPageLayout.this.hQP.clearAnimation();
                AlaLiveRoomBlurPageLayout.this.hQP.startAnimation(alphaAnimation);
            }
        };
        init();
    }

    public AlaLiveRoomBlurPageLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hQP = null;
        this.hQR = null;
        this.hGp = null;
        this.hQS = null;
        this.hQT = null;
        this.hQU = null;
        this.hQV = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveRoomBlurPageLayout.1
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
                        AlaLiveRoomBlurPageLayout.this.hQP.setAlpha(0.0f);
                        AlaLiveRoomBlurPageLayout.this.hQO.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                AlaLiveRoomBlurPageLayout.this.hQP.clearAnimation();
                AlaLiveRoomBlurPageLayout.this.hQP.startAnimation(alphaAnimation);
            }
        };
        init();
    }

    private void init() {
        Log.i("LiveRoomBlurPageLayout", "@@ context = " + getContext());
        this.mRootView = (ViewGroup) View.inflate(getContext(), a.g.ala_liveroom_audience_blur_layout, this);
        setClipChildren(false);
        this.hQO = (AlaLiveRoomCoverLayout) findViewById(a.f.layout_liveroom_cover);
        this.hQP = this.hQO.hQY;
        this.hQQ = new FrameLayout(getContext());
        this.hQQ.setId(a.f.ala_liveroom_player_container_view);
        this.mHandler = new Handler();
    }

    public void c(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        int[] screenFullSize = ViewCommonUtil.getScreenFullSize(tbPageContext.getPageActivity());
        bV(screenFullSize[0], screenFullSize[1]);
    }

    private void bV(int i, int i2) {
        if (this.hQO != null && this.hQO.getLayoutParams() != null && i > 0 && i2 > 0) {
            ViewGroup.LayoutParams layoutParams = this.hQO.getLayoutParams();
            layoutParams.width = i;
            layoutParams.height = i2;
            this.hQO.setLayoutParams(layoutParams);
        }
    }

    public void C(int i, int i2) {
        bV(i, i2);
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (configuration != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null) {
            int[] screenFullSize = ViewCommonUtil.getScreenFullSize(this.mPageContext.getPageActivity());
            if (this.hQT != null && this.hQT.getParent() != null) {
                ViewGroup.LayoutParams layoutParams = this.hQT.getLayoutParams();
                layoutParams.width = screenFullSize[0];
                layoutParams.height = screenFullSize[1] - 0;
                this.hQT.setLayoutParams(layoutParams);
            }
        }
    }

    public void a(AlaLiveView alaLiveView, ViewGroup.LayoutParams layoutParams) {
        if (alaLiveView != null) {
            if (this.mRootView.indexOfChild(alaLiveView) < 0 && this.mRootView.getChildCount() > 1) {
                this.hGp = alaLiveView;
                int childCount = this.mRootView.getChildCount() - 1;
                int childCount2 = this.mRootView.getChildCount();
                for (int i = 0; i < childCount2; i++) {
                    View childAt = this.mRootView.getChildAt(i);
                    if (childAt.getId() == a.f.ala_liveroom_player_container_view) {
                        childCount = Math.max(childCount, i);
                    } else if (childAt.getId() == a.f.ala_liveroom_audience_end_view) {
                        childCount = Math.min(childCount, i);
                    } else if (childAt.getId() == a.f.ala_live_room_close_btn_layout) {
                        childCount = Math.min(childCount, i);
                    }
                }
                if (layoutParams != null) {
                    this.mRootView.addView(alaLiveView, childCount, layoutParams);
                } else {
                    this.mRootView.addView(alaLiveView, childCount, alaLiveView.getLayoutParams());
                }
            }
            clf();
        }
    }

    public void clc() {
        if (this.hGp != null) {
            this.mRootView.removeView(this.hGp);
        }
        this.hGp = null;
    }

    @Override // com.baidu.live.u.e
    public ViewGroup getLiveContainerView() {
        return this;
    }

    @Override // com.baidu.live.u.e
    public FrameLayout getMastView() {
        return this.hQQ;
    }

    public void a(View view, ViewGroup.LayoutParams layoutParams, boolean z) {
        if (this.hQQ.getParent() != null) {
            this.mRootView.removeView(this.hQQ);
        }
        this.mRootView.addView(this.hQQ, 1);
        if (this.hQR != null && this.hQR.getParent() != null) {
            ((ViewGroup) this.hQR.getParent()).removeView(this.hQR);
        }
        this.hQR = view;
        if (this.hQR != null && this.hQR.getParent() != null) {
            ((ViewGroup) this.hQR.getParent()).removeView(this.hQR);
        }
        if (this.hQR != null) {
            if (layoutParams != null) {
                this.hQQ.addView(this.hQR, layoutParams);
            } else {
                this.hQQ.addView(this.hQR, this.hQR.getLayoutParams());
            }
        }
    }

    public void Xi() {
        if (this.hQQ.getParent() != null) {
            ((ViewGroup) this.hQQ.getParent()).removeView(this.hQQ);
        }
        if (this.hQR != null && this.hQR.getParent() != null) {
            ((ViewGroup) this.hQR.getParent()).removeView(this.hQR);
        }
        this.hQR = null;
    }

    public boolean cz(View view) {
        return (this.hQQ == null || this.hQQ.getParent() == null || this.hQQ.indexOfChild(view) < 0) ? false : true;
    }

    public void e(View view, ViewGroup.LayoutParams layoutParams) {
        if (this.hQS != null && this.mRootView.indexOfChild(this.hQS) >= 0) {
            this.mRootView.removeView(this.hQS);
        }
        this.hQS = view;
        int childCount = this.mRootView.getChildCount() - 1;
        int childCount2 = this.mRootView.getChildCount();
        for (int i = 0; i < childCount2; i++) {
            if (this.mRootView.getChildAt(i).getId() == a.f.ala_live_room_close_btn_layout) {
                childCount = Math.max(childCount, i);
            }
        }
        if (this.hQS != null) {
            this.mRootView.addView(this.hQS, childCount, layoutParams);
        }
        clf();
    }

    public void cld() {
        if (this.hQS != null) {
            this.mRootView.removeView(this.hQS);
        }
        this.hQS = null;
    }

    public void cle() {
        this.mHandler.removeCallbacks(this.hQV);
        this.hQP.clearAnimation();
        this.hQP.setAlpha(1.0f);
        this.hQO.setVisibility(0);
    }

    public void setBackImageBlack(AlaLiveInfoData alaLiveInfoData) {
        if ((alaLiveInfoData == null || alaLiveInfoData.screen_direction != 2) && this.hQP != null) {
            this.hQP.setImageDrawable(null);
            this.hQP.setBackgroundColor(this.mPageContext.getResources().getColor(a.c.sdk_transparent));
        }
    }

    public void setBgImageUrl(String str, int i, AlaLiveInfoData alaLiveInfoData) {
        if (this.mPageContext != null && !TextUtils.isEmpty(str)) {
            int[] screenFullSize = ViewCommonUtil.getScreenFullSize(this.mPageContext.getPageActivity());
            bV(screenFullSize[0], screenFullSize[1]);
            if (!TextUtils.isEmpty(str)) {
                a(this.hQP, str, 2, 20);
            } else {
                this.hQP.setBackgroundResource(a.e.pic_avatar_moren);
            }
        }
    }

    public void a(SimpleDraweeView simpleDraweeView, String str, int i, int i2) {
        try {
            simpleDraweeView.setController(com.facebook.drawee.a.a.c.eto().c(simpleDraweeView.getController()).bo(ImageRequestBuilder.ag(Uri.parse(str)).a(new com.facebook.imagepipeline.i.a(i, i2)).eAi()).euf());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setBgImageUrl(String str, AlaLiveInfoData alaLiveInfoData) {
        setBgImageUrl(str, 10, alaLiveInfoData);
    }

    public void release() {
        if (this.hQP != null) {
            this.hQP.setImageDrawable(null);
            this.hQP.setController(null);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (this.hGp != null && !this.hGp.hRj) {
            z = this.hGp.X(motionEvent);
        }
        if (z || motionEvent.getAction() == 0) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void oO(boolean z) {
        Context context = getContext();
        if (this.hQU == null) {
            this.hQT = new FrameLayout(context);
            this.hQT.setBackgroundColor(getContext().getResources().getColor(a.c.sdk_cp_cont_b));
            this.hQU = new TextView(context);
            this.hQU.setText(context.getResources().getString(a.h.ala_live_private_tip));
            this.hQU.setTextSize(0, context.getResources().getDimensionPixelSize(a.d.sdk_ds28));
            this.hQU.setTextColor(context.getResources().getColor(a.c.sdk_cp_cont_i_alpha40));
            this.hQU.setGravity(49);
            Drawable drawable = context.getResources().getDrawable(a.e.private_tip);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            this.hQU.setCompoundDrawables(null, drawable, null, null);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.topMargin = oP(z);
            layoutParams.gravity = 1;
            this.hQT.addView(this.hQU, layoutParams);
            int indexOfChild = this.hGp != null ? this.mRootView.indexOfChild(this.hGp) : -1;
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
            int[] screenFullSize = ViewCommonUtil.getScreenFullSize(this.mPageContext.getPageActivity());
            int statusBarHeight = !UtilHelper.canUseStyleImmersiveSticky() ? UtilHelper.getStatusBarHeight() : 0;
            layoutParams2.width = screenFullSize[0];
            layoutParams2.height = screenFullSize[1] - statusBarHeight;
            if (indexOfChild < 0) {
                this.mRootView.addView(this.hQT, layoutParams2);
            } else {
                this.mRootView.addView(this.hQT, indexOfChild, layoutParams2);
            }
        } else {
            if (this.hQT.getParent() != null) {
                this.mRootView.removeView(this.hQT);
            }
            int indexOfChild2 = this.hGp != null ? this.mRootView.indexOfChild(this.hGp) : -1;
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -1);
            int[] screenFullSize2 = ViewCommonUtil.getScreenFullSize(this.mPageContext.getPageActivity());
            int statusBarHeight2 = !UtilHelper.canUseStyleImmersiveSticky() ? UtilHelper.getStatusBarHeight() : 0;
            layoutParams3.width = screenFullSize2[0];
            layoutParams3.height = screenFullSize2[1] - statusBarHeight2;
            if (indexOfChild2 < 0) {
                this.mRootView.addView(this.hQT, layoutParams3);
            } else {
                this.mRootView.addView(this.hQT, indexOfChild2, layoutParams3);
            }
            FrameLayout.LayoutParams layoutParams4 = (FrameLayout.LayoutParams) this.hQU.getLayoutParams();
            layoutParams4.topMargin = oP(z);
            this.hQU.setLayoutParams(layoutParams4);
        }
        this.hQT.setVisibility(0);
        this.hQU.setVisibility(0);
        if (this.hQR != null) {
            this.hQR.setVisibility(8);
        }
        if (this.hQO != null) {
            this.hQO.setVisibility(8);
        }
    }

    public void M(int i, boolean z) {
        FrameLayout.LayoutParams layoutParams;
        if (this.hQU != null) {
            if (this.hQU.getLayoutParams() != null && (this.hQU.getLayoutParams() instanceof FrameLayout.LayoutParams)) {
                layoutParams = (FrameLayout.LayoutParams) this.hQU.getLayoutParams();
            } else {
                layoutParams = new FrameLayout.LayoutParams(-2, -2);
            }
            if (i == 2) {
                layoutParams.topMargin = getResources().getDimensionPixelSize(a.d.sdk_ds45);
                layoutParams.gravity = 1;
                this.hQU.setLayoutParams(layoutParams);
                return;
            }
            layoutParams.topMargin = oP(z);
            layoutParams.gravity = 1;
            this.hQU.setLayoutParams(layoutParams);
        }
    }

    public void clf() {
        if (this.hQT != null && this.hQT.getParent() != null) {
            ((ViewGroup) this.hQT.getParent()).removeView(this.hQT);
        }
        if (this.hQR != null) {
            this.hQR.setVisibility(0);
        }
        if (this.hQO != null) {
            this.hQO.setVisibility(0);
        }
    }

    public boolean clg() {
        return (this.hQT == null || this.hQT.getParent() == null) ? false : true;
    }

    private int oP(boolean z) {
        if (z) {
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                return UtilHelper.getStatusBarHeight();
            }
            return 0;
        }
        return this.mPageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds160);
    }

    public void clh() {
        View findViewWithTag = findViewWithTag("AlaLivePraiseGuideController");
        if (findViewWithTag != null) {
            removeView(findViewWithTag);
        }
    }
}
