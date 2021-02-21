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
    private AlaLiveView hGD;
    private AlaLiveRoomCoverLayout hRc;
    private SimpleDraweeView hRd;
    private FrameLayout hRe;
    private View hRf;
    private View hRg;
    private FrameLayout hRh;
    private TextView hRi;
    Runnable hRj;
    private Handler mHandler;
    private TbPageContext mPageContext;
    private ViewGroup mRootView;

    public AlaLiveRoomBlurPageLayout(Context context) {
        super(context);
        this.hRd = null;
        this.hRf = null;
        this.hGD = null;
        this.hRg = null;
        this.hRh = null;
        this.hRi = null;
        this.hRj = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveRoomBlurPageLayout.1
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
                        AlaLiveRoomBlurPageLayout.this.hRd.setAlpha(0.0f);
                        AlaLiveRoomBlurPageLayout.this.hRc.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                AlaLiveRoomBlurPageLayout.this.hRd.clearAnimation();
                AlaLiveRoomBlurPageLayout.this.hRd.startAnimation(alphaAnimation);
            }
        };
        init();
    }

    public AlaLiveRoomBlurPageLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hRd = null;
        this.hRf = null;
        this.hGD = null;
        this.hRg = null;
        this.hRh = null;
        this.hRi = null;
        this.hRj = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveRoomBlurPageLayout.1
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
                        AlaLiveRoomBlurPageLayout.this.hRd.setAlpha(0.0f);
                        AlaLiveRoomBlurPageLayout.this.hRc.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                AlaLiveRoomBlurPageLayout.this.hRd.clearAnimation();
                AlaLiveRoomBlurPageLayout.this.hRd.startAnimation(alphaAnimation);
            }
        };
        init();
    }

    public AlaLiveRoomBlurPageLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hRd = null;
        this.hRf = null;
        this.hGD = null;
        this.hRg = null;
        this.hRh = null;
        this.hRi = null;
        this.hRj = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveRoomBlurPageLayout.1
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
                        AlaLiveRoomBlurPageLayout.this.hRd.setAlpha(0.0f);
                        AlaLiveRoomBlurPageLayout.this.hRc.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                AlaLiveRoomBlurPageLayout.this.hRd.clearAnimation();
                AlaLiveRoomBlurPageLayout.this.hRd.startAnimation(alphaAnimation);
            }
        };
        init();
    }

    private void init() {
        Log.i("LiveRoomBlurPageLayout", "@@ context = " + getContext());
        this.mRootView = (ViewGroup) View.inflate(getContext(), a.g.ala_liveroom_audience_blur_layout, this);
        setClipChildren(false);
        this.hRc = (AlaLiveRoomCoverLayout) findViewById(a.f.layout_liveroom_cover);
        this.hRd = this.hRc.hRm;
        this.hRe = new FrameLayout(getContext());
        this.hRe.setId(a.f.ala_liveroom_player_container_view);
        this.mHandler = new Handler();
    }

    public void c(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        int[] screenFullSize = ViewCommonUtil.getScreenFullSize(tbPageContext.getPageActivity());
        bW(screenFullSize[0], screenFullSize[1]);
    }

    private void bW(int i, int i2) {
        if (this.hRc != null && this.hRc.getLayoutParams() != null && i > 0 && i2 > 0) {
            ViewGroup.LayoutParams layoutParams = this.hRc.getLayoutParams();
            layoutParams.width = i;
            layoutParams.height = i2;
            this.hRc.setLayoutParams(layoutParams);
        }
    }

    public void C(int i, int i2) {
        bW(i, i2);
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (configuration != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null) {
            int[] screenFullSize = ViewCommonUtil.getScreenFullSize(this.mPageContext.getPageActivity());
            if (this.hRh != null && this.hRh.getParent() != null) {
                ViewGroup.LayoutParams layoutParams = this.hRh.getLayoutParams();
                layoutParams.width = screenFullSize[0];
                layoutParams.height = screenFullSize[1] - 0;
                this.hRh.setLayoutParams(layoutParams);
            }
        }
    }

    public void a(AlaLiveView alaLiveView, ViewGroup.LayoutParams layoutParams) {
        if (alaLiveView != null) {
            if (this.mRootView.indexOfChild(alaLiveView) < 0 && this.mRootView.getChildCount() > 1) {
                this.hGD = alaLiveView;
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
            clm();
        }
    }

    public void clj() {
        if (this.hGD != null) {
            this.mRootView.removeView(this.hGD);
        }
        this.hGD = null;
    }

    @Override // com.baidu.live.u.e
    public ViewGroup getLiveContainerView() {
        return this;
    }

    @Override // com.baidu.live.u.e
    public FrameLayout getMastView() {
        return this.hRe;
    }

    public void a(View view, ViewGroup.LayoutParams layoutParams, boolean z) {
        if (this.hRe.getParent() != null) {
            this.mRootView.removeView(this.hRe);
        }
        this.mRootView.addView(this.hRe, 1);
        if (this.hRf != null && this.hRf.getParent() != null) {
            ((ViewGroup) this.hRf.getParent()).removeView(this.hRf);
        }
        this.hRf = view;
        if (this.hRf != null && this.hRf.getParent() != null) {
            ((ViewGroup) this.hRf.getParent()).removeView(this.hRf);
        }
        if (this.hRf != null) {
            if (layoutParams != null) {
                this.hRe.addView(this.hRf, layoutParams);
            } else {
                this.hRe.addView(this.hRf, this.hRf.getLayoutParams());
            }
        }
    }

    public void Xi() {
        if (this.hRe.getParent() != null) {
            ((ViewGroup) this.hRe.getParent()).removeView(this.hRe);
        }
        if (this.hRf != null && this.hRf.getParent() != null) {
            ((ViewGroup) this.hRf.getParent()).removeView(this.hRf);
        }
        this.hRf = null;
    }

    public boolean cz(View view) {
        return (this.hRe == null || this.hRe.getParent() == null || this.hRe.indexOfChild(view) < 0) ? false : true;
    }

    public void e(View view, ViewGroup.LayoutParams layoutParams) {
        if (this.hRg != null && this.mRootView.indexOfChild(this.hRg) >= 0) {
            this.mRootView.removeView(this.hRg);
        }
        this.hRg = view;
        int childCount = this.mRootView.getChildCount() - 1;
        int childCount2 = this.mRootView.getChildCount();
        for (int i = 0; i < childCount2; i++) {
            if (this.mRootView.getChildAt(i).getId() == a.f.ala_live_room_close_btn_layout) {
                childCount = Math.max(childCount, i);
            }
        }
        if (this.hRg != null) {
            this.mRootView.addView(this.hRg, childCount, layoutParams);
        }
        clm();
    }

    public void clk() {
        if (this.hRg != null) {
            this.mRootView.removeView(this.hRg);
        }
        this.hRg = null;
    }

    public void cll() {
        this.mHandler.removeCallbacks(this.hRj);
        this.hRd.clearAnimation();
        this.hRd.setAlpha(1.0f);
        this.hRc.setVisibility(0);
    }

    public void setBackImageBlack(AlaLiveInfoData alaLiveInfoData) {
        if ((alaLiveInfoData == null || alaLiveInfoData.screen_direction != 2) && this.hRd != null) {
            this.hRd.setImageDrawable(null);
            this.hRd.setBackgroundColor(this.mPageContext.getResources().getColor(a.c.sdk_transparent));
        }
    }

    public void setBgImageUrl(String str, int i, AlaLiveInfoData alaLiveInfoData) {
        if (this.mPageContext != null && !TextUtils.isEmpty(str)) {
            int[] screenFullSize = ViewCommonUtil.getScreenFullSize(this.mPageContext.getPageActivity());
            bW(screenFullSize[0], screenFullSize[1]);
            if (!TextUtils.isEmpty(str)) {
                a(this.hRd, str, 2, 20);
            } else {
                this.hRd.setBackgroundResource(a.e.pic_avatar_moren);
            }
        }
    }

    public void a(SimpleDraweeView simpleDraweeView, String str, int i, int i2) {
        try {
            simpleDraweeView.setController(com.facebook.drawee.a.a.c.etw().c(simpleDraweeView.getController()).bo(ImageRequestBuilder.ag(Uri.parse(str)).a(new com.facebook.imagepipeline.i.a(i, i2)).eAq()).eun());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setBgImageUrl(String str, AlaLiveInfoData alaLiveInfoData) {
        setBgImageUrl(str, 10, alaLiveInfoData);
    }

    public void release() {
        if (this.hRd != null) {
            this.hRd.setImageDrawable(null);
            this.hRd.setController(null);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (this.hGD != null && !this.hGD.hRx) {
            z = this.hGD.X(motionEvent);
        }
        if (z || motionEvent.getAction() == 0) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void oO(boolean z) {
        Context context = getContext();
        if (this.hRi == null) {
            this.hRh = new FrameLayout(context);
            this.hRh.setBackgroundColor(getContext().getResources().getColor(a.c.sdk_cp_cont_b));
            this.hRi = new TextView(context);
            this.hRi.setText(context.getResources().getString(a.h.ala_live_private_tip));
            this.hRi.setTextSize(0, context.getResources().getDimensionPixelSize(a.d.sdk_ds28));
            this.hRi.setTextColor(context.getResources().getColor(a.c.sdk_cp_cont_i_alpha40));
            this.hRi.setGravity(49);
            Drawable drawable = context.getResources().getDrawable(a.e.private_tip);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            this.hRi.setCompoundDrawables(null, drawable, null, null);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.topMargin = oP(z);
            layoutParams.gravity = 1;
            this.hRh.addView(this.hRi, layoutParams);
            int indexOfChild = this.hGD != null ? this.mRootView.indexOfChild(this.hGD) : -1;
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
            int[] screenFullSize = ViewCommonUtil.getScreenFullSize(this.mPageContext.getPageActivity());
            int statusBarHeight = !UtilHelper.canUseStyleImmersiveSticky() ? UtilHelper.getStatusBarHeight() : 0;
            layoutParams2.width = screenFullSize[0];
            layoutParams2.height = screenFullSize[1] - statusBarHeight;
            if (indexOfChild < 0) {
                this.mRootView.addView(this.hRh, layoutParams2);
            } else {
                this.mRootView.addView(this.hRh, indexOfChild, layoutParams2);
            }
        } else {
            if (this.hRh.getParent() != null) {
                this.mRootView.removeView(this.hRh);
            }
            int indexOfChild2 = this.hGD != null ? this.mRootView.indexOfChild(this.hGD) : -1;
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -1);
            int[] screenFullSize2 = ViewCommonUtil.getScreenFullSize(this.mPageContext.getPageActivity());
            int statusBarHeight2 = !UtilHelper.canUseStyleImmersiveSticky() ? UtilHelper.getStatusBarHeight() : 0;
            layoutParams3.width = screenFullSize2[0];
            layoutParams3.height = screenFullSize2[1] - statusBarHeight2;
            if (indexOfChild2 < 0) {
                this.mRootView.addView(this.hRh, layoutParams3);
            } else {
                this.mRootView.addView(this.hRh, indexOfChild2, layoutParams3);
            }
            FrameLayout.LayoutParams layoutParams4 = (FrameLayout.LayoutParams) this.hRi.getLayoutParams();
            layoutParams4.topMargin = oP(z);
            this.hRi.setLayoutParams(layoutParams4);
        }
        this.hRh.setVisibility(0);
        this.hRi.setVisibility(0);
        if (this.hRf != null) {
            this.hRf.setVisibility(8);
        }
        if (this.hRc != null) {
            this.hRc.setVisibility(8);
        }
    }

    public void M(int i, boolean z) {
        FrameLayout.LayoutParams layoutParams;
        if (this.hRi != null) {
            if (this.hRi.getLayoutParams() != null && (this.hRi.getLayoutParams() instanceof FrameLayout.LayoutParams)) {
                layoutParams = (FrameLayout.LayoutParams) this.hRi.getLayoutParams();
            } else {
                layoutParams = new FrameLayout.LayoutParams(-2, -2);
            }
            if (i == 2) {
                layoutParams.topMargin = getResources().getDimensionPixelSize(a.d.sdk_ds45);
                layoutParams.gravity = 1;
                this.hRi.setLayoutParams(layoutParams);
                return;
            }
            layoutParams.topMargin = oP(z);
            layoutParams.gravity = 1;
            this.hRi.setLayoutParams(layoutParams);
        }
    }

    public void clm() {
        if (this.hRh != null && this.hRh.getParent() != null) {
            ((ViewGroup) this.hRh.getParent()).removeView(this.hRh);
        }
        if (this.hRf != null) {
            this.hRf.setVisibility(0);
        }
        if (this.hRc != null) {
            this.hRc.setVisibility(0);
        }
    }

    public boolean cln() {
        return (this.hRh == null || this.hRh.getParent() == null) ? false : true;
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

    public void clo() {
        View findViewWithTag = findViewWithTag("AlaLivePraiseGuideController");
        if (findViewWithTag != null) {
            removeView(findViewWithTag);
        }
    }
}
