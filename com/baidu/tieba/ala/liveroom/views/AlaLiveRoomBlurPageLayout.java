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
public class AlaLiveRoomBlurPageLayout extends FrameLayout implements com.baidu.live.v.e {
    private AlaLiveView hGM;
    private AlaLiveRoomCoverLayout hRa;
    private SimpleDraweeView hRb;
    private FrameLayout hRc;
    private View hRd;
    private View hRe;
    private FrameLayout hRf;
    private TextView hRg;
    Runnable hRh;
    private Handler mHandler;
    private TbPageContext mPageContext;
    private ViewGroup mRootView;

    public AlaLiveRoomBlurPageLayout(Context context) {
        super(context);
        this.hRb = null;
        this.hRd = null;
        this.hGM = null;
        this.hRe = null;
        this.hRf = null;
        this.hRg = null;
        this.hRh = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveRoomBlurPageLayout.1
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
                        AlaLiveRoomBlurPageLayout.this.hRb.setAlpha(0.0f);
                        AlaLiveRoomBlurPageLayout.this.hRa.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                AlaLiveRoomBlurPageLayout.this.hRb.clearAnimation();
                AlaLiveRoomBlurPageLayout.this.hRb.startAnimation(alphaAnimation);
            }
        };
        init();
    }

    public AlaLiveRoomBlurPageLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hRb = null;
        this.hRd = null;
        this.hGM = null;
        this.hRe = null;
        this.hRf = null;
        this.hRg = null;
        this.hRh = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveRoomBlurPageLayout.1
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
                        AlaLiveRoomBlurPageLayout.this.hRb.setAlpha(0.0f);
                        AlaLiveRoomBlurPageLayout.this.hRa.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                AlaLiveRoomBlurPageLayout.this.hRb.clearAnimation();
                AlaLiveRoomBlurPageLayout.this.hRb.startAnimation(alphaAnimation);
            }
        };
        init();
    }

    public AlaLiveRoomBlurPageLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hRb = null;
        this.hRd = null;
        this.hGM = null;
        this.hRe = null;
        this.hRf = null;
        this.hRg = null;
        this.hRh = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveRoomBlurPageLayout.1
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
                        AlaLiveRoomBlurPageLayout.this.hRb.setAlpha(0.0f);
                        AlaLiveRoomBlurPageLayout.this.hRa.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                AlaLiveRoomBlurPageLayout.this.hRb.clearAnimation();
                AlaLiveRoomBlurPageLayout.this.hRb.startAnimation(alphaAnimation);
            }
        };
        init();
    }

    private void init() {
        Log.i("LiveRoomBlurPageLayout", "@@ context = " + getContext());
        this.mRootView = (ViewGroup) View.inflate(getContext(), a.g.ala_liveroom_audience_blur_layout, this);
        setClipChildren(false);
        this.hRa = (AlaLiveRoomCoverLayout) findViewById(a.f.layout_liveroom_cover);
        this.hRb = this.hRa.hRk;
        this.hRc = new FrameLayout(getContext());
        this.hRc.setId(a.f.ala_liveroom_player_container_view);
        this.mHandler = new Handler();
    }

    public void c(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        int[] screenFullSize = ViewCommonUtil.getScreenFullSize(tbPageContext.getPageActivity());
        bY(screenFullSize[0], screenFullSize[1]);
    }

    private void bY(int i, int i2) {
        if (this.hRa != null && this.hRa.getLayoutParams() != null && i > 0 && i2 > 0) {
            ViewGroup.LayoutParams layoutParams = this.hRa.getLayoutParams();
            layoutParams.width = i;
            layoutParams.height = i2;
            this.hRa.setLayoutParams(layoutParams);
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
            if (this.hRf != null && this.hRf.getParent() != null) {
                ViewGroup.LayoutParams layoutParams = this.hRf.getLayoutParams();
                layoutParams.width = screenFullSize[0];
                layoutParams.height = screenFullSize[1] - 0;
                this.hRf.setLayoutParams(layoutParams);
            }
        }
    }

    public void a(AlaLiveView alaLiveView, ViewGroup.LayoutParams layoutParams) {
        if (alaLiveView != null) {
            if (this.mRootView.indexOfChild(alaLiveView) < 0 && this.mRootView.getChildCount() > 1) {
                this.hGM = alaLiveView;
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
            cnY();
        }
    }

    public void cnV() {
        if (this.hGM != null) {
            this.mRootView.removeView(this.hGM);
        }
        this.hGM = null;
    }

    @Override // com.baidu.live.v.e
    public ViewGroup getLiveContainerView() {
        return this;
    }

    @Override // com.baidu.live.v.e
    public FrameLayout getMastView() {
        return this.hRc;
    }

    public void a(View view, ViewGroup.LayoutParams layoutParams, boolean z) {
        if (this.hRc.getParent() != null) {
            this.mRootView.removeView(this.hRc);
        }
        this.mRootView.addView(this.hRc, 1);
        if (this.hRd != null && this.hRd.getParent() != null) {
            ((ViewGroup) this.hRd.getParent()).removeView(this.hRd);
        }
        this.hRd = view;
        if (this.hRd != null && this.hRd.getParent() != null) {
            ((ViewGroup) this.hRd.getParent()).removeView(this.hRd);
        }
        if (this.hRd != null) {
            if (layoutParams != null) {
                this.hRc.addView(this.hRd, layoutParams);
            } else {
                this.hRc.addView(this.hRd, this.hRd.getLayoutParams());
            }
        }
    }

    public void Zr() {
        if (this.hRc.getParent() != null) {
            ((ViewGroup) this.hRc.getParent()).removeView(this.hRc);
        }
        if (this.hRd != null && this.hRd.getParent() != null) {
            ((ViewGroup) this.hRd.getParent()).removeView(this.hRd);
        }
        this.hRd = null;
    }

    public boolean cD(View view) {
        return (this.hRc == null || this.hRc.getParent() == null || this.hRc.indexOfChild(view) < 0) ? false : true;
    }

    public void e(View view, ViewGroup.LayoutParams layoutParams) {
        if (this.hRe != null && this.mRootView.indexOfChild(this.hRe) >= 0) {
            this.mRootView.removeView(this.hRe);
        }
        this.hRe = view;
        int childCount = this.mRootView.getChildCount() - 1;
        int childCount2 = this.mRootView.getChildCount();
        for (int i = 0; i < childCount2; i++) {
            if (this.mRootView.getChildAt(i).getId() == a.f.ala_live_room_close_btn_layout) {
                childCount = Math.max(childCount, i);
            }
        }
        if (this.hRe != null) {
            this.mRootView.addView(this.hRe, childCount, layoutParams);
        }
        cnY();
    }

    public void cnW() {
        if (this.hRe != null) {
            this.mRootView.removeView(this.hRe);
        }
        this.hRe = null;
    }

    public void cnX() {
        this.mHandler.removeCallbacks(this.hRh);
        this.hRb.clearAnimation();
        this.hRb.setAlpha(1.0f);
        this.hRa.setVisibility(0);
    }

    public void setBackImageBlack(AlaLiveInfoData alaLiveInfoData) {
        if ((alaLiveInfoData == null || alaLiveInfoData.screen_direction != 2) && this.hRb != null) {
            this.hRb.setImageDrawable(null);
            this.hRb.setBackgroundColor(this.mPageContext.getResources().getColor(a.c.sdk_transparent));
        }
    }

    public void setBgImageUrl(String str, int i, AlaLiveInfoData alaLiveInfoData) {
        if (this.mPageContext != null && !TextUtils.isEmpty(str)) {
            int[] screenFullSize = ViewCommonUtil.getScreenFullSize(this.mPageContext.getPageActivity());
            bY(screenFullSize[0], screenFullSize[1]);
            if (!TextUtils.isEmpty(str)) {
                a(this.hRb, str, 2, 20);
            } else {
                this.hRb.setBackgroundResource(a.e.pic_avatar_moren);
            }
        }
    }

    public void a(SimpleDraweeView simpleDraweeView, String str, int i, int i2) {
        try {
            simpleDraweeView.setController(com.facebook.drawee.a.a.c.euI().c(simpleDraweeView.getController()).bo(ImageRequestBuilder.aj(Uri.parse(str)).a(new com.facebook.imagepipeline.i.a(i, i2)).eBe()).evz());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setBgImageUrl(String str, AlaLiveInfoData alaLiveInfoData) {
        setBgImageUrl(str, 10, alaLiveInfoData);
    }

    public void release() {
        if (this.hRb != null) {
            this.hRb.setImageDrawable(null);
            this.hRb.setController(null);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (this.hGM != null && !this.hGM.hRv) {
            z = this.hGM.W(motionEvent);
        }
        if (z || motionEvent.getAction() == 0) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void oI(boolean z) {
        Context context = getContext();
        if (this.hRg == null) {
            this.hRf = new FrameLayout(context);
            this.hRf.setBackgroundColor(getContext().getResources().getColor(a.c.sdk_cp_cont_b));
            this.hRg = new TextView(context);
            this.hRg.setText(context.getResources().getString(a.h.ala_live_private_tip));
            this.hRg.setTextSize(0, context.getResources().getDimensionPixelSize(a.d.sdk_ds28));
            this.hRg.setTextColor(context.getResources().getColor(a.c.sdk_cp_cont_i_alpha40));
            this.hRg.setGravity(49);
            Drawable drawable = context.getResources().getDrawable(a.e.private_tip);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            this.hRg.setCompoundDrawables(null, drawable, null, null);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.topMargin = oJ(z);
            layoutParams.gravity = 1;
            this.hRf.addView(this.hRg, layoutParams);
            int indexOfChild = this.hGM != null ? this.mRootView.indexOfChild(this.hGM) : -1;
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
            int[] screenFullSize = ViewCommonUtil.getScreenFullSize(this.mPageContext.getPageActivity());
            int statusBarHeight = !UtilHelper.canUseStyleImmersiveSticky() ? UtilHelper.getStatusBarHeight() : 0;
            layoutParams2.width = screenFullSize[0];
            layoutParams2.height = screenFullSize[1] - statusBarHeight;
            if (indexOfChild < 0) {
                this.mRootView.addView(this.hRf, layoutParams2);
            } else {
                this.mRootView.addView(this.hRf, indexOfChild, layoutParams2);
            }
        } else {
            if (this.hRf.getParent() != null) {
                this.mRootView.removeView(this.hRf);
            }
            int indexOfChild2 = this.hGM != null ? this.mRootView.indexOfChild(this.hGM) : -1;
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -1);
            int[] screenFullSize2 = ViewCommonUtil.getScreenFullSize(this.mPageContext.getPageActivity());
            int statusBarHeight2 = !UtilHelper.canUseStyleImmersiveSticky() ? UtilHelper.getStatusBarHeight() : 0;
            layoutParams3.width = screenFullSize2[0];
            layoutParams3.height = screenFullSize2[1] - statusBarHeight2;
            if (indexOfChild2 < 0) {
                this.mRootView.addView(this.hRf, layoutParams3);
            } else {
                this.mRootView.addView(this.hRf, indexOfChild2, layoutParams3);
            }
            FrameLayout.LayoutParams layoutParams4 = (FrameLayout.LayoutParams) this.hRg.getLayoutParams();
            layoutParams4.topMargin = oJ(z);
            this.hRg.setLayoutParams(layoutParams4);
        }
        this.hRf.setVisibility(0);
        this.hRg.setVisibility(0);
        if (this.hRd != null) {
            this.hRd.setVisibility(8);
        }
        if (this.hRa != null) {
            this.hRa.setVisibility(8);
        }
    }

    public void M(int i, boolean z) {
        FrameLayout.LayoutParams layoutParams;
        if (this.hRg != null) {
            if (this.hRg.getLayoutParams() != null && (this.hRg.getLayoutParams() instanceof FrameLayout.LayoutParams)) {
                layoutParams = (FrameLayout.LayoutParams) this.hRg.getLayoutParams();
            } else {
                layoutParams = new FrameLayout.LayoutParams(-2, -2);
            }
            if (i == 2) {
                layoutParams.topMargin = getResources().getDimensionPixelSize(a.d.sdk_ds45);
                layoutParams.gravity = 1;
                this.hRg.setLayoutParams(layoutParams);
                return;
            }
            layoutParams.topMargin = oJ(z);
            layoutParams.gravity = 1;
            this.hRg.setLayoutParams(layoutParams);
        }
    }

    public void cnY() {
        if (this.hRf != null && this.hRf.getParent() != null) {
            ((ViewGroup) this.hRf.getParent()).removeView(this.hRf);
        }
        if (this.hRd != null) {
            this.hRd.setVisibility(0);
        }
        if (this.hRa != null) {
            this.hRa.setVisibility(0);
        }
    }

    public boolean cnZ() {
        return (this.hRf == null || this.hRf.getParent() == null) ? false : true;
    }

    private int oJ(boolean z) {
        if (z) {
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                return UtilHelper.getStatusBarHeight();
            }
            return 0;
        }
        return this.mPageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds160);
    }

    public void coa() {
        View findViewWithTag = findViewWithTag("AlaLivePraiseGuideController");
        if (findViewWithTag != null) {
            removeView(findViewWithTag);
        }
    }
}
