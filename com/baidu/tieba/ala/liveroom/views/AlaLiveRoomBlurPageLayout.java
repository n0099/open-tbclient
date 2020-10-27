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
public class AlaLiveRoomBlurPageLayout extends FrameLayout implements com.baidu.live.r.e {
    private AlaLiveView hfN;
    private AlaLiveRoomCoverLayout hpQ;
    private SimpleDraweeView hpR;
    private FrameLayout hpS;
    private View hpT;
    private View hpU;
    private FrameLayout hpV;
    private TextView hpW;
    Runnable hpX;
    private Handler mHandler;
    private TbPageContext mPageContext;
    private ViewGroup mRootView;

    public AlaLiveRoomBlurPageLayout(Context context) {
        super(context);
        this.hpR = null;
        this.hpT = null;
        this.hfN = null;
        this.hpU = null;
        this.hpV = null;
        this.hpW = null;
        this.hpX = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveRoomBlurPageLayout.1
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
                        AlaLiveRoomBlurPageLayout.this.hpR.setAlpha(0.0f);
                        AlaLiveRoomBlurPageLayout.this.hpQ.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                AlaLiveRoomBlurPageLayout.this.hpR.clearAnimation();
                AlaLiveRoomBlurPageLayout.this.hpR.startAnimation(alphaAnimation);
            }
        };
        init();
    }

    public AlaLiveRoomBlurPageLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hpR = null;
        this.hpT = null;
        this.hfN = null;
        this.hpU = null;
        this.hpV = null;
        this.hpW = null;
        this.hpX = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveRoomBlurPageLayout.1
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
                        AlaLiveRoomBlurPageLayout.this.hpR.setAlpha(0.0f);
                        AlaLiveRoomBlurPageLayout.this.hpQ.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                AlaLiveRoomBlurPageLayout.this.hpR.clearAnimation();
                AlaLiveRoomBlurPageLayout.this.hpR.startAnimation(alphaAnimation);
            }
        };
        init();
    }

    public AlaLiveRoomBlurPageLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hpR = null;
        this.hpT = null;
        this.hfN = null;
        this.hpU = null;
        this.hpV = null;
        this.hpW = null;
        this.hpX = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveRoomBlurPageLayout.1
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
                        AlaLiveRoomBlurPageLayout.this.hpR.setAlpha(0.0f);
                        AlaLiveRoomBlurPageLayout.this.hpQ.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                AlaLiveRoomBlurPageLayout.this.hpR.clearAnimation();
                AlaLiveRoomBlurPageLayout.this.hpR.startAnimation(alphaAnimation);
            }
        };
        init();
    }

    private void init() {
        Log.i("LiveRoomBlurPageLayout", "@@ context = " + getContext());
        this.mRootView = (ViewGroup) View.inflate(getContext(), a.h.ala_liveroom_audience_blur_layout, this);
        setClipChildren(false);
        this.hpQ = (AlaLiveRoomCoverLayout) findViewById(a.g.layout_liveroom_cover);
        this.hpR = this.hpQ.hqa;
        this.hpS = new FrameLayout(getContext());
        this.hpS.setId(a.g.ala_liveroom_player_container_view);
        this.mHandler = new Handler();
    }

    public void c(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        int[] screenFullSize = ViewCommonUtil.getScreenFullSize(tbPageContext.getPageActivity());
        bT(screenFullSize[0], screenFullSize[1]);
    }

    private void bT(int i, int i2) {
        if (this.hpQ != null && this.hpQ.getLayoutParams() != null && i > 0 && i2 > 0) {
            ViewGroup.LayoutParams layoutParams = this.hpQ.getLayoutParams();
            layoutParams.width = i;
            layoutParams.height = i2;
            this.hpQ.setLayoutParams(layoutParams);
        }
    }

    public void D(int i, int i2) {
        bT(i, i2);
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (configuration != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null) {
            int[] screenFullSize = ViewCommonUtil.getScreenFullSize(this.mPageContext.getPageActivity());
            if (this.hpV != null && this.hpV.getParent() != null) {
                ViewGroup.LayoutParams layoutParams = this.hpV.getLayoutParams();
                layoutParams.width = screenFullSize[0];
                layoutParams.height = screenFullSize[1] - 0;
                this.hpV.setLayoutParams(layoutParams);
            }
        }
    }

    public void a(AlaLiveView alaLiveView, ViewGroup.LayoutParams layoutParams) {
        if (alaLiveView != null) {
            if (this.mRootView.indexOfChild(alaLiveView) < 0 && this.mRootView.getChildCount() > 1) {
                this.hfN = alaLiveView;
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
            cfq();
        }
    }

    public void cfn() {
        if (this.hfN != null) {
            this.mRootView.removeView(this.hfN);
        }
        this.hfN = null;
    }

    @Override // com.baidu.live.r.e
    public ViewGroup getLiveContainerView() {
        return this;
    }

    public void a(View view, ViewGroup.LayoutParams layoutParams, boolean z) {
        if (this.hpS.getParent() != null) {
            this.mRootView.removeView(this.hpS);
        }
        this.mRootView.addView(this.hpS, 1);
        if (this.hpT != null && this.hpT.getParent() != null) {
            ((ViewGroup) this.hpT.getParent()).removeView(this.hpT);
        }
        this.hpT = view;
        if (this.hpT != null && this.hpT.getParent() != null) {
            ((ViewGroup) this.hpT.getParent()).removeView(this.hpT);
        }
        if (this.hpT != null) {
            if (layoutParams != null) {
                this.hpS.addView(this.hpT, layoutParams);
            } else {
                this.hpS.addView(this.hpT, this.hpT.getLayoutParams());
            }
        }
    }

    public void TS() {
        if (this.hpS.getParent() != null) {
            ((ViewGroup) this.hpS.getParent()).removeView(this.hpS);
        }
        if (this.hpT != null && this.hpT.getParent() != null) {
            ((ViewGroup) this.hpT.getParent()).removeView(this.hpT);
        }
        this.hpT = null;
    }

    public boolean cf(View view) {
        return (this.hpS == null || this.hpS.getParent() == null || this.hpS.indexOfChild(view) < 0) ? false : true;
    }

    public void c(View view, ViewGroup.LayoutParams layoutParams) {
        if (this.hpU != null && this.mRootView.indexOfChild(this.hpU) >= 0) {
            this.mRootView.removeView(this.hpU);
        }
        this.hpU = view;
        int childCount = this.mRootView.getChildCount() - 1;
        int childCount2 = this.mRootView.getChildCount();
        int i = childCount;
        for (int i2 = 0; i2 < childCount2; i2++) {
            if (this.mRootView.getChildAt(i2).getId() == a.g.ala_live_room_close_btn_layout) {
                i = Math.max(i, i2);
            }
        }
        if (this.hpU != null) {
            this.mRootView.addView(this.hpU, i, layoutParams);
        }
        cfq();
    }

    public void cfo() {
        if (this.hpU != null) {
            this.mRootView.removeView(this.hpU);
        }
        this.hpU = null;
    }

    public void cfp() {
        this.mHandler.removeCallbacks(this.hpX);
        this.hpR.clearAnimation();
        this.hpR.setAlpha(1.0f);
        this.hpQ.setVisibility(0);
    }

    public void setBackImageBlack(AlaLiveInfoData alaLiveInfoData) {
        if ((alaLiveInfoData == null || alaLiveInfoData.screen_direction != 2) && this.hpR != null) {
            this.hpR.setImageDrawable(null);
            this.hpR.setBackgroundColor(this.mPageContext.getResources().getColor(a.d.sdk_transparent));
        }
    }

    public void setBgImageUrl(String str, int i, AlaLiveInfoData alaLiveInfoData) {
        if (this.mPageContext != null && !TextUtils.isEmpty(str)) {
            int[] screenFullSize = ViewCommonUtil.getScreenFullSize(this.mPageContext.getPageActivity());
            bT(screenFullSize[0], screenFullSize[1]);
            if (!TextUtils.isEmpty(str)) {
                a(this.hpR, str, 2, 20);
            } else {
                this.hpR.setBackgroundResource(a.f.pic_avatar_moren);
            }
        }
    }

    public void a(SimpleDraweeView simpleDraweeView, String str, int i, int i2) {
        try {
            simpleDraweeView.setController(com.facebook.drawee.a.a.c.ehd().c(simpleDraweeView.getController()).bn(ImageRequestBuilder.ad(Uri.parse(str)).a(new com.facebook.imagepipeline.j.a(i, i2)).eoj()).ehU());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setBgImageUrl(String str, AlaLiveInfoData alaLiveInfoData) {
        setBgImageUrl(str, 10, alaLiveInfoData);
    }

    public void release() {
        if (this.hpR != null) {
            this.hpR.setImageDrawable(null);
            this.hpR.setController(null);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (this.hfN != null && !this.hfN.hqk) {
            z = this.hfN.V(motionEvent);
        }
        if (z || motionEvent.getAction() == 0) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void nE(boolean z) {
        Context context = getContext();
        if (this.hpW == null) {
            this.hpV = new FrameLayout(context);
            this.hpV.setBackgroundColor(getContext().getResources().getColor(a.d.sdk_cp_cont_b));
            this.hpW = new TextView(context);
            this.hpW.setText(context.getResources().getString(a.i.ala_live_private_tip));
            this.hpW.setTextSize(0, context.getResources().getDimensionPixelSize(a.e.sdk_ds28));
            this.hpW.setTextColor(context.getResources().getColor(a.d.sdk_cp_cont_i_alpha40));
            this.hpW.setGravity(49);
            Drawable drawable = context.getResources().getDrawable(a.f.private_tip);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            this.hpW.setCompoundDrawables(null, drawable, null, null);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.topMargin = nF(z);
            layoutParams.gravity = 1;
            this.hpV.addView(this.hpW, layoutParams);
            int indexOfChild = this.hfN != null ? this.mRootView.indexOfChild(this.hfN) : -1;
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
            int[] screenFullSize = ViewCommonUtil.getScreenFullSize(this.mPageContext.getPageActivity());
            int statusBarHeight = !UtilHelper.canUseStyleImmersiveSticky() ? UtilHelper.getStatusBarHeight() : 0;
            layoutParams2.width = screenFullSize[0];
            layoutParams2.height = screenFullSize[1] - statusBarHeight;
            if (indexOfChild < 0) {
                this.mRootView.addView(this.hpV, layoutParams2);
            } else {
                this.mRootView.addView(this.hpV, indexOfChild, layoutParams2);
            }
        } else {
            if (this.hpV.getParent() != null) {
                this.mRootView.removeView(this.hpV);
            }
            int indexOfChild2 = this.hfN != null ? this.mRootView.indexOfChild(this.hfN) : -1;
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -1);
            int[] screenFullSize2 = ViewCommonUtil.getScreenFullSize(this.mPageContext.getPageActivity());
            int statusBarHeight2 = !UtilHelper.canUseStyleImmersiveSticky() ? UtilHelper.getStatusBarHeight() : 0;
            layoutParams3.width = screenFullSize2[0];
            layoutParams3.height = screenFullSize2[1] - statusBarHeight2;
            if (indexOfChild2 < 0) {
                this.mRootView.addView(this.hpV, layoutParams3);
            } else {
                this.mRootView.addView(this.hpV, indexOfChild2, layoutParams3);
            }
            FrameLayout.LayoutParams layoutParams4 = (FrameLayout.LayoutParams) this.hpW.getLayoutParams();
            layoutParams4.topMargin = nF(z);
            this.hpW.setLayoutParams(layoutParams4);
        }
        this.hpV.setVisibility(0);
        this.hpW.setVisibility(0);
        if (this.hpT != null) {
            this.hpT.setVisibility(8);
        }
        if (this.hpQ != null) {
            this.hpQ.setVisibility(8);
        }
    }

    public void M(int i, boolean z) {
        FrameLayout.LayoutParams layoutParams;
        if (this.hpW != null) {
            if (this.hpW.getLayoutParams() != null && (this.hpW.getLayoutParams() instanceof FrameLayout.LayoutParams)) {
                layoutParams = (FrameLayout.LayoutParams) this.hpW.getLayoutParams();
            } else {
                layoutParams = new FrameLayout.LayoutParams(-2, -2);
            }
            if (i == 2) {
                layoutParams.topMargin = getResources().getDimensionPixelSize(a.e.sdk_ds45);
                layoutParams.gravity = 1;
                this.hpW.setLayoutParams(layoutParams);
                return;
            }
            layoutParams.topMargin = nF(z);
            layoutParams.gravity = 1;
            this.hpW.setLayoutParams(layoutParams);
        }
    }

    public void cfq() {
        if (this.hpV != null && this.hpV.getParent() != null) {
            ((ViewGroup) this.hpV.getParent()).removeView(this.hpV);
        }
        if (this.hpT != null) {
            this.hpT.setVisibility(0);
        }
        if (this.hpQ != null) {
            this.hpQ.setVisibility(0);
        }
    }

    public boolean cfr() {
        return (this.hpV == null || this.hpV.getParent() == null) ? false : true;
    }

    private int nF(boolean z) {
        if (z) {
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                return UtilHelper.getStatusBarHeight();
            }
            return 0;
        }
        return this.mPageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds160);
    }

    public void cfs() {
        View findViewWithTag = findViewWithTag("AlaLivePraiseGuideController");
        if (findViewWithTag != null) {
            removeView(findViewWithTag);
        }
    }
}
