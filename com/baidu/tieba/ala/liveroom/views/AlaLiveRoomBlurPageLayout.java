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
/* loaded from: classes10.dex */
public class AlaLiveRoomBlurPageLayout extends FrameLayout implements com.baidu.live.v.e {
    private AlaLiveView hCg;
    private TextView hMA;
    Runnable hMB;
    private AlaLiveRoomCoverLayout hMu;
    private SimpleDraweeView hMv;
    private FrameLayout hMw;
    private View hMx;
    private View hMy;
    private FrameLayout hMz;
    private Handler mHandler;
    private TbPageContext mPageContext;
    private ViewGroup mRootView;

    public AlaLiveRoomBlurPageLayout(Context context) {
        super(context);
        this.hMv = null;
        this.hMx = null;
        this.hCg = null;
        this.hMy = null;
        this.hMz = null;
        this.hMA = null;
        this.hMB = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveRoomBlurPageLayout.1
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
                        AlaLiveRoomBlurPageLayout.this.hMv.setAlpha(0.0f);
                        AlaLiveRoomBlurPageLayout.this.hMu.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                AlaLiveRoomBlurPageLayout.this.hMv.clearAnimation();
                AlaLiveRoomBlurPageLayout.this.hMv.startAnimation(alphaAnimation);
            }
        };
        init();
    }

    public AlaLiveRoomBlurPageLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hMv = null;
        this.hMx = null;
        this.hCg = null;
        this.hMy = null;
        this.hMz = null;
        this.hMA = null;
        this.hMB = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveRoomBlurPageLayout.1
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
                        AlaLiveRoomBlurPageLayout.this.hMv.setAlpha(0.0f);
                        AlaLiveRoomBlurPageLayout.this.hMu.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                AlaLiveRoomBlurPageLayout.this.hMv.clearAnimation();
                AlaLiveRoomBlurPageLayout.this.hMv.startAnimation(alphaAnimation);
            }
        };
        init();
    }

    public AlaLiveRoomBlurPageLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hMv = null;
        this.hMx = null;
        this.hCg = null;
        this.hMy = null;
        this.hMz = null;
        this.hMA = null;
        this.hMB = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveRoomBlurPageLayout.1
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
                        AlaLiveRoomBlurPageLayout.this.hMv.setAlpha(0.0f);
                        AlaLiveRoomBlurPageLayout.this.hMu.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                AlaLiveRoomBlurPageLayout.this.hMv.clearAnimation();
                AlaLiveRoomBlurPageLayout.this.hMv.startAnimation(alphaAnimation);
            }
        };
        init();
    }

    private void init() {
        Log.i("LiveRoomBlurPageLayout", "@@ context = " + getContext());
        this.mRootView = (ViewGroup) View.inflate(getContext(), a.g.ala_liveroom_audience_blur_layout, this);
        setClipChildren(false);
        this.hMu = (AlaLiveRoomCoverLayout) findViewById(a.f.layout_liveroom_cover);
        this.hMv = this.hMu.hME;
        this.hMw = new FrameLayout(getContext());
        this.hMw.setId(a.f.ala_liveroom_player_container_view);
        this.mHandler = new Handler();
    }

    public void c(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        int[] screenFullSize = ViewCommonUtil.getScreenFullSize(tbPageContext.getPageActivity());
        bY(screenFullSize[0], screenFullSize[1]);
    }

    private void bY(int i, int i2) {
        if (this.hMu != null && this.hMu.getLayoutParams() != null && i > 0 && i2 > 0) {
            ViewGroup.LayoutParams layoutParams = this.hMu.getLayoutParams();
            layoutParams.width = i;
            layoutParams.height = i2;
            this.hMu.setLayoutParams(layoutParams);
        }
    }

    public void C(int i, int i2) {
        bY(i, i2);
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (configuration != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null) {
            int[] screenFullSize = ViewCommonUtil.getScreenFullSize(this.mPageContext.getPageActivity());
            if (this.hMz != null && this.hMz.getParent() != null) {
                ViewGroup.LayoutParams layoutParams = this.hMz.getLayoutParams();
                layoutParams.width = screenFullSize[0];
                layoutParams.height = screenFullSize[1] - 0;
                this.hMz.setLayoutParams(layoutParams);
            }
        }
    }

    public void a(AlaLiveView alaLiveView, ViewGroup.LayoutParams layoutParams) {
        if (alaLiveView != null) {
            if (this.mRootView.indexOfChild(alaLiveView) < 0 && this.mRootView.getChildCount() > 1) {
                this.hCg = alaLiveView;
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
            ckh();
        }
    }

    public void cke() {
        if (this.hCg != null) {
            this.mRootView.removeView(this.hCg);
        }
        this.hCg = null;
    }

    @Override // com.baidu.live.v.e
    public ViewGroup getLiveContainerView() {
        return this;
    }

    @Override // com.baidu.live.v.e
    public FrameLayout getMastView() {
        return this.hMw;
    }

    public void a(View view, ViewGroup.LayoutParams layoutParams, boolean z) {
        if (this.hMw.getParent() != null) {
            this.mRootView.removeView(this.hMw);
        }
        this.mRootView.addView(this.hMw, 1);
        if (this.hMx != null && this.hMx.getParent() != null) {
            ((ViewGroup) this.hMx.getParent()).removeView(this.hMx);
        }
        this.hMx = view;
        if (this.hMx != null && this.hMx.getParent() != null) {
            ((ViewGroup) this.hMx.getParent()).removeView(this.hMx);
        }
        if (this.hMx != null) {
            if (layoutParams != null) {
                this.hMw.addView(this.hMx, layoutParams);
            } else {
                this.hMw.addView(this.hMx, this.hMx.getLayoutParams());
            }
        }
    }

    public void Vz() {
        if (this.hMw.getParent() != null) {
            ((ViewGroup) this.hMw.getParent()).removeView(this.hMw);
        }
        if (this.hMx != null && this.hMx.getParent() != null) {
            ((ViewGroup) this.hMx.getParent()).removeView(this.hMx);
        }
        this.hMx = null;
    }

    public boolean cD(View view) {
        return (this.hMw == null || this.hMw.getParent() == null || this.hMw.indexOfChild(view) < 0) ? false : true;
    }

    public void e(View view, ViewGroup.LayoutParams layoutParams) {
        if (this.hMy != null && this.mRootView.indexOfChild(this.hMy) >= 0) {
            this.mRootView.removeView(this.hMy);
        }
        this.hMy = view;
        int childCount = this.mRootView.getChildCount() - 1;
        int childCount2 = this.mRootView.getChildCount();
        for (int i = 0; i < childCount2; i++) {
            if (this.mRootView.getChildAt(i).getId() == a.f.ala_live_room_close_btn_layout) {
                childCount = Math.max(childCount, i);
            }
        }
        if (this.hMy != null) {
            this.mRootView.addView(this.hMy, childCount, layoutParams);
        }
        ckh();
    }

    public void ckf() {
        if (this.hMy != null) {
            this.mRootView.removeView(this.hMy);
        }
        this.hMy = null;
    }

    public void ckg() {
        this.mHandler.removeCallbacks(this.hMB);
        this.hMv.clearAnimation();
        this.hMv.setAlpha(1.0f);
        this.hMu.setVisibility(0);
    }

    public void setBackImageBlack(AlaLiveInfoData alaLiveInfoData) {
        if ((alaLiveInfoData == null || alaLiveInfoData.screen_direction != 2) && this.hMv != null) {
            this.hMv.setImageDrawable(null);
            this.hMv.setBackgroundColor(this.mPageContext.getResources().getColor(a.c.sdk_transparent));
        }
    }

    public void setBgImageUrl(String str, int i, AlaLiveInfoData alaLiveInfoData) {
        if (this.mPageContext != null && !TextUtils.isEmpty(str)) {
            int[] screenFullSize = ViewCommonUtil.getScreenFullSize(this.mPageContext.getPageActivity());
            bY(screenFullSize[0], screenFullSize[1]);
            if (!TextUtils.isEmpty(str)) {
                a(this.hMv, str, 2, 20);
            } else {
                this.hMv.setBackgroundResource(a.e.pic_avatar_moren);
            }
        }
    }

    public void a(SimpleDraweeView simpleDraweeView, String str, int i, int i2) {
        try {
            simpleDraweeView.setController(com.facebook.drawee.a.a.c.eqV().c(simpleDraweeView.getController()).bo(ImageRequestBuilder.ag(Uri.parse(str)).a(new com.facebook.imagepipeline.i.a(i, i2)).exQ()).erN());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setBgImageUrl(String str, AlaLiveInfoData alaLiveInfoData) {
        setBgImageUrl(str, 10, alaLiveInfoData);
    }

    public void release() {
        if (this.hMv != null) {
            this.hMv.setImageDrawable(null);
            this.hMv.setController(null);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (this.hCg != null && !this.hCg.hMP) {
            z = this.hCg.X(motionEvent);
        }
        if (z || motionEvent.getAction() == 0) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void oE(boolean z) {
        Context context = getContext();
        if (this.hMA == null) {
            this.hMz = new FrameLayout(context);
            this.hMz.setBackgroundColor(getContext().getResources().getColor(a.c.sdk_cp_cont_b));
            this.hMA = new TextView(context);
            this.hMA.setText(context.getResources().getString(a.h.ala_live_private_tip));
            this.hMA.setTextSize(0, context.getResources().getDimensionPixelSize(a.d.sdk_ds28));
            this.hMA.setTextColor(context.getResources().getColor(a.c.sdk_cp_cont_i_alpha40));
            this.hMA.setGravity(49);
            Drawable drawable = context.getResources().getDrawable(a.e.private_tip);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            this.hMA.setCompoundDrawables(null, drawable, null, null);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.topMargin = oF(z);
            layoutParams.gravity = 1;
            this.hMz.addView(this.hMA, layoutParams);
            int indexOfChild = this.hCg != null ? this.mRootView.indexOfChild(this.hCg) : -1;
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
            int[] screenFullSize = ViewCommonUtil.getScreenFullSize(this.mPageContext.getPageActivity());
            int statusBarHeight = !UtilHelper.canUseStyleImmersiveSticky() ? UtilHelper.getStatusBarHeight() : 0;
            layoutParams2.width = screenFullSize[0];
            layoutParams2.height = screenFullSize[1] - statusBarHeight;
            if (indexOfChild < 0) {
                this.mRootView.addView(this.hMz, layoutParams2);
            } else {
                this.mRootView.addView(this.hMz, indexOfChild, layoutParams2);
            }
        } else {
            if (this.hMz.getParent() != null) {
                this.mRootView.removeView(this.hMz);
            }
            int indexOfChild2 = this.hCg != null ? this.mRootView.indexOfChild(this.hCg) : -1;
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -1);
            int[] screenFullSize2 = ViewCommonUtil.getScreenFullSize(this.mPageContext.getPageActivity());
            int statusBarHeight2 = !UtilHelper.canUseStyleImmersiveSticky() ? UtilHelper.getStatusBarHeight() : 0;
            layoutParams3.width = screenFullSize2[0];
            layoutParams3.height = screenFullSize2[1] - statusBarHeight2;
            if (indexOfChild2 < 0) {
                this.mRootView.addView(this.hMz, layoutParams3);
            } else {
                this.mRootView.addView(this.hMz, indexOfChild2, layoutParams3);
            }
            FrameLayout.LayoutParams layoutParams4 = (FrameLayout.LayoutParams) this.hMA.getLayoutParams();
            layoutParams4.topMargin = oF(z);
            this.hMA.setLayoutParams(layoutParams4);
        }
        this.hMz.setVisibility(0);
        this.hMA.setVisibility(0);
        if (this.hMx != null) {
            this.hMx.setVisibility(8);
        }
        if (this.hMu != null) {
            this.hMu.setVisibility(8);
        }
    }

    public void M(int i, boolean z) {
        FrameLayout.LayoutParams layoutParams;
        if (this.hMA != null) {
            if (this.hMA.getLayoutParams() != null && (this.hMA.getLayoutParams() instanceof FrameLayout.LayoutParams)) {
                layoutParams = (FrameLayout.LayoutParams) this.hMA.getLayoutParams();
            } else {
                layoutParams = new FrameLayout.LayoutParams(-2, -2);
            }
            if (i == 2) {
                layoutParams.topMargin = getResources().getDimensionPixelSize(a.d.sdk_ds45);
                layoutParams.gravity = 1;
                this.hMA.setLayoutParams(layoutParams);
                return;
            }
            layoutParams.topMargin = oF(z);
            layoutParams.gravity = 1;
            this.hMA.setLayoutParams(layoutParams);
        }
    }

    public void ckh() {
        if (this.hMz != null && this.hMz.getParent() != null) {
            ((ViewGroup) this.hMz.getParent()).removeView(this.hMz);
        }
        if (this.hMx != null) {
            this.hMx.setVisibility(0);
        }
        if (this.hMu != null) {
            this.hMu.setVisibility(0);
        }
    }

    public boolean cki() {
        return (this.hMz == null || this.hMz.getParent() == null) ? false : true;
    }

    private int oF(boolean z) {
        if (z) {
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                return UtilHelper.getStatusBarHeight();
            }
            return 0;
        }
        return this.mPageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds160);
    }

    public void ckj() {
        View findViewWithTag = findViewWithTag("AlaLivePraiseGuideController");
        if (findViewWithTag != null) {
            removeView(findViewWithTag);
        }
    }
}
