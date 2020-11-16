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
/* loaded from: classes4.dex */
public class AlaLiveRoomBlurPageLayout extends FrameLayout implements com.baidu.live.s.e {
    private AlaLiveView hlp;
    private FrameLayout hvA;
    private TextView hvB;
    Runnable hvC;
    private AlaLiveRoomCoverLayout hvv;
    private SimpleDraweeView hvw;
    private FrameLayout hvx;
    private View hvy;
    private View hvz;
    private Handler mHandler;
    private TbPageContext mPageContext;
    private ViewGroup mRootView;

    public AlaLiveRoomBlurPageLayout(Context context) {
        super(context);
        this.hvw = null;
        this.hvy = null;
        this.hlp = null;
        this.hvz = null;
        this.hvA = null;
        this.hvB = null;
        this.hvC = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveRoomBlurPageLayout.1
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
                        AlaLiveRoomBlurPageLayout.this.hvw.setAlpha(0.0f);
                        AlaLiveRoomBlurPageLayout.this.hvv.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                AlaLiveRoomBlurPageLayout.this.hvw.clearAnimation();
                AlaLiveRoomBlurPageLayout.this.hvw.startAnimation(alphaAnimation);
            }
        };
        init();
    }

    public AlaLiveRoomBlurPageLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hvw = null;
        this.hvy = null;
        this.hlp = null;
        this.hvz = null;
        this.hvA = null;
        this.hvB = null;
        this.hvC = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveRoomBlurPageLayout.1
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
                        AlaLiveRoomBlurPageLayout.this.hvw.setAlpha(0.0f);
                        AlaLiveRoomBlurPageLayout.this.hvv.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                AlaLiveRoomBlurPageLayout.this.hvw.clearAnimation();
                AlaLiveRoomBlurPageLayout.this.hvw.startAnimation(alphaAnimation);
            }
        };
        init();
    }

    public AlaLiveRoomBlurPageLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hvw = null;
        this.hvy = null;
        this.hlp = null;
        this.hvz = null;
        this.hvA = null;
        this.hvB = null;
        this.hvC = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveRoomBlurPageLayout.1
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
                        AlaLiveRoomBlurPageLayout.this.hvw.setAlpha(0.0f);
                        AlaLiveRoomBlurPageLayout.this.hvv.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                AlaLiveRoomBlurPageLayout.this.hvw.clearAnimation();
                AlaLiveRoomBlurPageLayout.this.hvw.startAnimation(alphaAnimation);
            }
        };
        init();
    }

    private void init() {
        Log.i("LiveRoomBlurPageLayout", "@@ context = " + getContext());
        this.mRootView = (ViewGroup) View.inflate(getContext(), a.g.ala_liveroom_audience_blur_layout, this);
        setClipChildren(false);
        this.hvv = (AlaLiveRoomCoverLayout) findViewById(a.f.layout_liveroom_cover);
        this.hvw = this.hvv.hvF;
        this.hvx = new FrameLayout(getContext());
        this.hvx.setId(a.f.ala_liveroom_player_container_view);
        this.mHandler = new Handler();
    }

    public void c(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        int[] screenFullSize = ViewCommonUtil.getScreenFullSize(tbPageContext.getPageActivity());
        bV(screenFullSize[0], screenFullSize[1]);
    }

    private void bV(int i, int i2) {
        if (this.hvv != null && this.hvv.getLayoutParams() != null && i > 0 && i2 > 0) {
            ViewGroup.LayoutParams layoutParams = this.hvv.getLayoutParams();
            layoutParams.width = i;
            layoutParams.height = i2;
            this.hvv.setLayoutParams(layoutParams);
        }
    }

    public void D(int i, int i2) {
        bV(i, i2);
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (configuration != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null) {
            int[] screenFullSize = ViewCommonUtil.getScreenFullSize(this.mPageContext.getPageActivity());
            if (this.hvA != null && this.hvA.getParent() != null) {
                ViewGroup.LayoutParams layoutParams = this.hvA.getLayoutParams();
                layoutParams.width = screenFullSize[0];
                layoutParams.height = screenFullSize[1] - 0;
                this.hvA.setLayoutParams(layoutParams);
            }
        }
    }

    public void a(AlaLiveView alaLiveView, ViewGroup.LayoutParams layoutParams) {
        if (alaLiveView != null) {
            if (this.mRootView.indexOfChild(alaLiveView) < 0 && this.mRootView.getChildCount() > 1) {
                this.hlp = alaLiveView;
                int childCount = this.mRootView.getChildCount() - 1;
                int childCount2 = this.mRootView.getChildCount();
                int i = childCount;
                for (int i2 = 0; i2 < childCount2; i2++) {
                    View childAt = this.mRootView.getChildAt(i2);
                    if (childAt.getId() == a.f.ala_liveroom_player_container_view) {
                        i = Math.max(i, i2);
                    } else if (childAt.getId() == a.f.ala_liveroom_audience_end_view) {
                        i = Math.min(i, i2);
                    } else if (childAt.getId() == a.f.ala_live_room_close_btn_layout) {
                        i = Math.min(i, i2);
                    }
                }
                if (layoutParams != null) {
                    this.mRootView.addView(alaLiveView, i, layoutParams);
                } else {
                    this.mRootView.addView(alaLiveView, i, alaLiveView.getLayoutParams());
                }
            }
            chm();
        }
    }

    public void chj() {
        if (this.hlp != null) {
            this.mRootView.removeView(this.hlp);
        }
        this.hlp = null;
    }

    @Override // com.baidu.live.s.e
    public ViewGroup getLiveContainerView() {
        return this;
    }

    @Override // com.baidu.live.s.e
    public FrameLayout getMastView() {
        return this.hvx;
    }

    public void a(View view, ViewGroup.LayoutParams layoutParams, boolean z) {
        if (this.hvx.getParent() != null) {
            this.mRootView.removeView(this.hvx);
        }
        this.mRootView.addView(this.hvx, 1);
        if (this.hvy != null && this.hvy.getParent() != null) {
            ((ViewGroup) this.hvy.getParent()).removeView(this.hvy);
        }
        this.hvy = view;
        if (this.hvy != null && this.hvy.getParent() != null) {
            ((ViewGroup) this.hvy.getParent()).removeView(this.hvy);
        }
        if (this.hvy != null) {
            if (layoutParams != null) {
                this.hvx.addView(this.hvy, layoutParams);
            } else {
                this.hvx.addView(this.hvy, this.hvy.getLayoutParams());
            }
        }
    }

    public void VJ() {
        if (this.hvx.getParent() != null) {
            ((ViewGroup) this.hvx.getParent()).removeView(this.hvx);
        }
        if (this.hvy != null && this.hvy.getParent() != null) {
            ((ViewGroup) this.hvy.getParent()).removeView(this.hvy);
        }
        this.hvy = null;
    }

    public boolean cn(View view) {
        return (this.hvx == null || this.hvx.getParent() == null || this.hvx.indexOfChild(view) < 0) ? false : true;
    }

    public void c(View view, ViewGroup.LayoutParams layoutParams) {
        if (this.hvz != null && this.mRootView.indexOfChild(this.hvz) >= 0) {
            this.mRootView.removeView(this.hvz);
        }
        this.hvz = view;
        int childCount = this.mRootView.getChildCount() - 1;
        int childCount2 = this.mRootView.getChildCount();
        int i = childCount;
        for (int i2 = 0; i2 < childCount2; i2++) {
            if (this.mRootView.getChildAt(i2).getId() == a.f.ala_live_room_close_btn_layout) {
                i = Math.max(i, i2);
            }
        }
        if (this.hvz != null) {
            this.mRootView.addView(this.hvz, i, layoutParams);
        }
        chm();
    }

    public void chk() {
        if (this.hvz != null) {
            this.mRootView.removeView(this.hvz);
        }
        this.hvz = null;
    }

    public void chl() {
        this.mHandler.removeCallbacks(this.hvC);
        this.hvw.clearAnimation();
        this.hvw.setAlpha(1.0f);
        this.hvv.setVisibility(0);
    }

    public void setBackImageBlack(AlaLiveInfoData alaLiveInfoData) {
        if ((alaLiveInfoData == null || alaLiveInfoData.screen_direction != 2) && this.hvw != null) {
            this.hvw.setImageDrawable(null);
            this.hvw.setBackgroundColor(this.mPageContext.getResources().getColor(a.c.sdk_transparent));
        }
    }

    public void setBgImageUrl(String str, int i, AlaLiveInfoData alaLiveInfoData) {
        if (this.mPageContext != null && !TextUtils.isEmpty(str)) {
            int[] screenFullSize = ViewCommonUtil.getScreenFullSize(this.mPageContext.getPageActivity());
            bV(screenFullSize[0], screenFullSize[1]);
            if (!TextUtils.isEmpty(str)) {
                a(this.hvw, str, 2, 20);
            } else {
                this.hvw.setBackgroundResource(a.e.pic_avatar_moren);
            }
        }
    }

    public void a(SimpleDraweeView simpleDraweeView, String str, int i, int i2) {
        try {
            simpleDraweeView.setController(com.facebook.drawee.a.a.c.ekQ().c(simpleDraweeView.getController()).bo(ImageRequestBuilder.ae(Uri.parse(str)).a(new com.facebook.imagepipeline.j.a(i, i2)).erW()).elH());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setBgImageUrl(String str, AlaLiveInfoData alaLiveInfoData) {
        setBgImageUrl(str, 10, alaLiveInfoData);
    }

    public void release() {
        if (this.hvw != null) {
            this.hvw.setImageDrawable(null);
            this.hvw.setController(null);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (this.hlp != null && !this.hlp.hvP) {
            z = this.hlp.W(motionEvent);
        }
        if (z || motionEvent.getAction() == 0) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void nO(boolean z) {
        Context context = getContext();
        if (this.hvB == null) {
            this.hvA = new FrameLayout(context);
            this.hvA.setBackgroundColor(getContext().getResources().getColor(a.c.sdk_cp_cont_b));
            this.hvB = new TextView(context);
            this.hvB.setText(context.getResources().getString(a.h.ala_live_private_tip));
            this.hvB.setTextSize(0, context.getResources().getDimensionPixelSize(a.d.sdk_ds28));
            this.hvB.setTextColor(context.getResources().getColor(a.c.sdk_cp_cont_i_alpha40));
            this.hvB.setGravity(49);
            Drawable drawable = context.getResources().getDrawable(a.e.private_tip);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            this.hvB.setCompoundDrawables(null, drawable, null, null);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.topMargin = nP(z);
            layoutParams.gravity = 1;
            this.hvA.addView(this.hvB, layoutParams);
            int indexOfChild = this.hlp != null ? this.mRootView.indexOfChild(this.hlp) : -1;
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
            int[] screenFullSize = ViewCommonUtil.getScreenFullSize(this.mPageContext.getPageActivity());
            int statusBarHeight = !UtilHelper.canUseStyleImmersiveSticky() ? UtilHelper.getStatusBarHeight() : 0;
            layoutParams2.width = screenFullSize[0];
            layoutParams2.height = screenFullSize[1] - statusBarHeight;
            if (indexOfChild < 0) {
                this.mRootView.addView(this.hvA, layoutParams2);
            } else {
                this.mRootView.addView(this.hvA, indexOfChild, layoutParams2);
            }
        } else {
            if (this.hvA.getParent() != null) {
                this.mRootView.removeView(this.hvA);
            }
            int indexOfChild2 = this.hlp != null ? this.mRootView.indexOfChild(this.hlp) : -1;
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -1);
            int[] screenFullSize2 = ViewCommonUtil.getScreenFullSize(this.mPageContext.getPageActivity());
            int statusBarHeight2 = !UtilHelper.canUseStyleImmersiveSticky() ? UtilHelper.getStatusBarHeight() : 0;
            layoutParams3.width = screenFullSize2[0];
            layoutParams3.height = screenFullSize2[1] - statusBarHeight2;
            if (indexOfChild2 < 0) {
                this.mRootView.addView(this.hvA, layoutParams3);
            } else {
                this.mRootView.addView(this.hvA, indexOfChild2, layoutParams3);
            }
            FrameLayout.LayoutParams layoutParams4 = (FrameLayout.LayoutParams) this.hvB.getLayoutParams();
            layoutParams4.topMargin = nP(z);
            this.hvB.setLayoutParams(layoutParams4);
        }
        this.hvA.setVisibility(0);
        this.hvB.setVisibility(0);
        if (this.hvy != null) {
            this.hvy.setVisibility(8);
        }
        if (this.hvv != null) {
            this.hvv.setVisibility(8);
        }
    }

    public void M(int i, boolean z) {
        FrameLayout.LayoutParams layoutParams;
        if (this.hvB != null) {
            if (this.hvB.getLayoutParams() != null && (this.hvB.getLayoutParams() instanceof FrameLayout.LayoutParams)) {
                layoutParams = (FrameLayout.LayoutParams) this.hvB.getLayoutParams();
            } else {
                layoutParams = new FrameLayout.LayoutParams(-2, -2);
            }
            if (i == 2) {
                layoutParams.topMargin = getResources().getDimensionPixelSize(a.d.sdk_ds45);
                layoutParams.gravity = 1;
                this.hvB.setLayoutParams(layoutParams);
                return;
            }
            layoutParams.topMargin = nP(z);
            layoutParams.gravity = 1;
            this.hvB.setLayoutParams(layoutParams);
        }
    }

    public void chm() {
        if (this.hvA != null && this.hvA.getParent() != null) {
            ((ViewGroup) this.hvA.getParent()).removeView(this.hvA);
        }
        if (this.hvy != null) {
            this.hvy.setVisibility(0);
        }
        if (this.hvv != null) {
            this.hvv.setVisibility(0);
        }
    }

    public boolean chn() {
        return (this.hvA == null || this.hvA.getParent() == null) ? false : true;
    }

    private int nP(boolean z) {
        if (z) {
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                return UtilHelper.getStatusBarHeight();
            }
            return 0;
        }
        return this.mPageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds160);
    }

    public void cho() {
        View findViewWithTag = findViewWithTag("AlaLivePraiseGuideController");
        if (findViewWithTag != null) {
            removeView(findViewWithTag);
        }
    }
}
