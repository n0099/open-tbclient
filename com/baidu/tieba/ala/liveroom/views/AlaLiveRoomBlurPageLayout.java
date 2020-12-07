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
public class AlaLiveRoomBlurPageLayout extends FrameLayout implements com.baidu.live.u.e {
    private AlaLiveRoomCoverLayout hEY;
    private SimpleDraweeView hEZ;
    private FrameLayout hFa;
    private View hFb;
    private View hFc;
    private FrameLayout hFd;
    private TextView hFe;
    Runnable hFf;
    private AlaLiveView huO;
    private Handler mHandler;
    private TbPageContext mPageContext;
    private ViewGroup mRootView;

    public AlaLiveRoomBlurPageLayout(Context context) {
        super(context);
        this.hEZ = null;
        this.hFb = null;
        this.huO = null;
        this.hFc = null;
        this.hFd = null;
        this.hFe = null;
        this.hFf = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveRoomBlurPageLayout.1
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
                        AlaLiveRoomBlurPageLayout.this.hEZ.setAlpha(0.0f);
                        AlaLiveRoomBlurPageLayout.this.hEY.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                AlaLiveRoomBlurPageLayout.this.hEZ.clearAnimation();
                AlaLiveRoomBlurPageLayout.this.hEZ.startAnimation(alphaAnimation);
            }
        };
        init();
    }

    public AlaLiveRoomBlurPageLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hEZ = null;
        this.hFb = null;
        this.huO = null;
        this.hFc = null;
        this.hFd = null;
        this.hFe = null;
        this.hFf = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveRoomBlurPageLayout.1
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
                        AlaLiveRoomBlurPageLayout.this.hEZ.setAlpha(0.0f);
                        AlaLiveRoomBlurPageLayout.this.hEY.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                AlaLiveRoomBlurPageLayout.this.hEZ.clearAnimation();
                AlaLiveRoomBlurPageLayout.this.hEZ.startAnimation(alphaAnimation);
            }
        };
        init();
    }

    public AlaLiveRoomBlurPageLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hEZ = null;
        this.hFb = null;
        this.huO = null;
        this.hFc = null;
        this.hFd = null;
        this.hFe = null;
        this.hFf = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveRoomBlurPageLayout.1
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
                        AlaLiveRoomBlurPageLayout.this.hEZ.setAlpha(0.0f);
                        AlaLiveRoomBlurPageLayout.this.hEY.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                AlaLiveRoomBlurPageLayout.this.hEZ.clearAnimation();
                AlaLiveRoomBlurPageLayout.this.hEZ.startAnimation(alphaAnimation);
            }
        };
        init();
    }

    private void init() {
        Log.i("LiveRoomBlurPageLayout", "@@ context = " + getContext());
        this.mRootView = (ViewGroup) View.inflate(getContext(), a.g.ala_liveroom_audience_blur_layout, this);
        setClipChildren(false);
        this.hEY = (AlaLiveRoomCoverLayout) findViewById(a.f.layout_liveroom_cover);
        this.hEZ = this.hEY.hFi;
        this.hFa = new FrameLayout(getContext());
        this.hFa.setId(a.f.ala_liveroom_player_container_view);
        this.mHandler = new Handler();
    }

    public void c(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        int[] screenFullSize = ViewCommonUtil.getScreenFullSize(tbPageContext.getPageActivity());
        bZ(screenFullSize[0], screenFullSize[1]);
    }

    private void bZ(int i, int i2) {
        if (this.hEY != null && this.hEY.getLayoutParams() != null && i > 0 && i2 > 0) {
            ViewGroup.LayoutParams layoutParams = this.hEY.getLayoutParams();
            layoutParams.width = i;
            layoutParams.height = i2;
            this.hEY.setLayoutParams(layoutParams);
        }
    }

    public void C(int i, int i2) {
        bZ(i, i2);
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (configuration != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null) {
            int[] screenFullSize = ViewCommonUtil.getScreenFullSize(this.mPageContext.getPageActivity());
            if (this.hFd != null && this.hFd.getParent() != null) {
                ViewGroup.LayoutParams layoutParams = this.hFd.getLayoutParams();
                layoutParams.width = screenFullSize[0];
                layoutParams.height = screenFullSize[1] - 0;
                this.hFd.setLayoutParams(layoutParams);
            }
        }
    }

    public void a(AlaLiveView alaLiveView, ViewGroup.LayoutParams layoutParams) {
        if (alaLiveView != null) {
            if (this.mRootView.indexOfChild(alaLiveView) < 0 && this.mRootView.getChildCount() > 1) {
                this.huO = alaLiveView;
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
            clg();
        }
    }

    public void cld() {
        if (this.huO != null) {
            this.mRootView.removeView(this.huO);
        }
        this.huO = null;
    }

    @Override // com.baidu.live.u.e
    public ViewGroup getLiveContainerView() {
        return this;
    }

    @Override // com.baidu.live.u.e
    public FrameLayout getMastView() {
        return this.hFa;
    }

    public void a(View view, ViewGroup.LayoutParams layoutParams, boolean z) {
        if (this.hFa.getParent() != null) {
            this.mRootView.removeView(this.hFa);
        }
        this.mRootView.addView(this.hFa, 1);
        if (this.hFb != null && this.hFb.getParent() != null) {
            ((ViewGroup) this.hFb.getParent()).removeView(this.hFb);
        }
        this.hFb = view;
        if (this.hFb != null && this.hFb.getParent() != null) {
            ((ViewGroup) this.hFb.getParent()).removeView(this.hFb);
        }
        if (this.hFb != null) {
            if (layoutParams != null) {
                this.hFa.addView(this.hFb, layoutParams);
            } else {
                this.hFa.addView(this.hFb, this.hFb.getLayoutParams());
            }
        }
    }

    public void Yj() {
        if (this.hFa.getParent() != null) {
            ((ViewGroup) this.hFa.getParent()).removeView(this.hFa);
        }
        if (this.hFb != null && this.hFb.getParent() != null) {
            ((ViewGroup) this.hFb.getParent()).removeView(this.hFb);
        }
        this.hFb = null;
    }

    public boolean cu(View view) {
        return (this.hFa == null || this.hFa.getParent() == null || this.hFa.indexOfChild(view) < 0) ? false : true;
    }

    public void c(View view, ViewGroup.LayoutParams layoutParams) {
        if (this.hFc != null && this.mRootView.indexOfChild(this.hFc) >= 0) {
            this.mRootView.removeView(this.hFc);
        }
        this.hFc = view;
        int childCount = this.mRootView.getChildCount() - 1;
        int childCount2 = this.mRootView.getChildCount();
        int i = childCount;
        for (int i2 = 0; i2 < childCount2; i2++) {
            if (this.mRootView.getChildAt(i2).getId() == a.f.ala_live_room_close_btn_layout) {
                i = Math.max(i, i2);
            }
        }
        if (this.hFc != null) {
            this.mRootView.addView(this.hFc, i, layoutParams);
        }
        clg();
    }

    public void cle() {
        if (this.hFc != null) {
            this.mRootView.removeView(this.hFc);
        }
        this.hFc = null;
    }

    public void clf() {
        this.mHandler.removeCallbacks(this.hFf);
        this.hEZ.clearAnimation();
        this.hEZ.setAlpha(1.0f);
        this.hEY.setVisibility(0);
    }

    public void setBackImageBlack(AlaLiveInfoData alaLiveInfoData) {
        if ((alaLiveInfoData == null || alaLiveInfoData.screen_direction != 2) && this.hEZ != null) {
            this.hEZ.setImageDrawable(null);
            this.hEZ.setBackgroundColor(this.mPageContext.getResources().getColor(a.c.sdk_transparent));
        }
    }

    public void setBgImageUrl(String str, int i, AlaLiveInfoData alaLiveInfoData) {
        if (this.mPageContext != null && !TextUtils.isEmpty(str)) {
            int[] screenFullSize = ViewCommonUtil.getScreenFullSize(this.mPageContext.getPageActivity());
            bZ(screenFullSize[0], screenFullSize[1]);
            if (!TextUtils.isEmpty(str)) {
                a(this.hEZ, str, 2, 20);
            } else {
                this.hEZ.setBackgroundResource(a.e.pic_avatar_moren);
            }
        }
    }

    public void a(SimpleDraweeView simpleDraweeView, String str, int i, int i2) {
        try {
            simpleDraweeView.setController(com.facebook.drawee.a.a.c.eqF().c(simpleDraweeView.getController()).bo(ImageRequestBuilder.af(Uri.parse(str)).a(new com.facebook.imagepipeline.i.a(i, i2)).exw()).erw());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setBgImageUrl(String str, AlaLiveInfoData alaLiveInfoData) {
        setBgImageUrl(str, 10, alaLiveInfoData);
    }

    public void release() {
        if (this.hEZ != null) {
            this.hEZ.setImageDrawable(null);
            this.hEZ.setController(null);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (this.huO != null && !this.huO.hFt) {
            z = this.huO.W(motionEvent);
        }
        if (z || motionEvent.getAction() == 0) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void oj(boolean z) {
        Context context = getContext();
        if (this.hFe == null) {
            this.hFd = new FrameLayout(context);
            this.hFd.setBackgroundColor(getContext().getResources().getColor(a.c.sdk_cp_cont_b));
            this.hFe = new TextView(context);
            this.hFe.setText(context.getResources().getString(a.h.ala_live_private_tip));
            this.hFe.setTextSize(0, context.getResources().getDimensionPixelSize(a.d.sdk_ds28));
            this.hFe.setTextColor(context.getResources().getColor(a.c.sdk_cp_cont_i_alpha40));
            this.hFe.setGravity(49);
            Drawable drawable = context.getResources().getDrawable(a.e.private_tip);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            this.hFe.setCompoundDrawables(null, drawable, null, null);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.topMargin = ok(z);
            layoutParams.gravity = 1;
            this.hFd.addView(this.hFe, layoutParams);
            int indexOfChild = this.huO != null ? this.mRootView.indexOfChild(this.huO) : -1;
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
            int[] screenFullSize = ViewCommonUtil.getScreenFullSize(this.mPageContext.getPageActivity());
            int statusBarHeight = !UtilHelper.canUseStyleImmersiveSticky() ? UtilHelper.getStatusBarHeight() : 0;
            layoutParams2.width = screenFullSize[0];
            layoutParams2.height = screenFullSize[1] - statusBarHeight;
            if (indexOfChild < 0) {
                this.mRootView.addView(this.hFd, layoutParams2);
            } else {
                this.mRootView.addView(this.hFd, indexOfChild, layoutParams2);
            }
        } else {
            if (this.hFd.getParent() != null) {
                this.mRootView.removeView(this.hFd);
            }
            int indexOfChild2 = this.huO != null ? this.mRootView.indexOfChild(this.huO) : -1;
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -1);
            int[] screenFullSize2 = ViewCommonUtil.getScreenFullSize(this.mPageContext.getPageActivity());
            int statusBarHeight2 = !UtilHelper.canUseStyleImmersiveSticky() ? UtilHelper.getStatusBarHeight() : 0;
            layoutParams3.width = screenFullSize2[0];
            layoutParams3.height = screenFullSize2[1] - statusBarHeight2;
            if (indexOfChild2 < 0) {
                this.mRootView.addView(this.hFd, layoutParams3);
            } else {
                this.mRootView.addView(this.hFd, indexOfChild2, layoutParams3);
            }
            FrameLayout.LayoutParams layoutParams4 = (FrameLayout.LayoutParams) this.hFe.getLayoutParams();
            layoutParams4.topMargin = ok(z);
            this.hFe.setLayoutParams(layoutParams4);
        }
        this.hFd.setVisibility(0);
        this.hFe.setVisibility(0);
        if (this.hFb != null) {
            this.hFb.setVisibility(8);
        }
        if (this.hEY != null) {
            this.hEY.setVisibility(8);
        }
    }

    public void M(int i, boolean z) {
        FrameLayout.LayoutParams layoutParams;
        if (this.hFe != null) {
            if (this.hFe.getLayoutParams() != null && (this.hFe.getLayoutParams() instanceof FrameLayout.LayoutParams)) {
                layoutParams = (FrameLayout.LayoutParams) this.hFe.getLayoutParams();
            } else {
                layoutParams = new FrameLayout.LayoutParams(-2, -2);
            }
            if (i == 2) {
                layoutParams.topMargin = getResources().getDimensionPixelSize(a.d.sdk_ds45);
                layoutParams.gravity = 1;
                this.hFe.setLayoutParams(layoutParams);
                return;
            }
            layoutParams.topMargin = ok(z);
            layoutParams.gravity = 1;
            this.hFe.setLayoutParams(layoutParams);
        }
    }

    public void clg() {
        if (this.hFd != null && this.hFd.getParent() != null) {
            ((ViewGroup) this.hFd.getParent()).removeView(this.hFd);
        }
        if (this.hFb != null) {
            this.hFb.setVisibility(0);
        }
        if (this.hEY != null) {
            this.hEY.setVisibility(0);
        }
    }

    public boolean clh() {
        return (this.hFd == null || this.hFd.getParent() == null) ? false : true;
    }

    private int ok(boolean z) {
        if (z) {
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                return UtilHelper.getStatusBarHeight();
            }
            return 0;
        }
        return this.mPageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds160);
    }

    public void cli() {
        View findViewWithTag = findViewWithTag("AlaLivePraiseGuideController");
        if (findViewWithTag != null) {
            removeView(findViewWithTag);
        }
    }
}
