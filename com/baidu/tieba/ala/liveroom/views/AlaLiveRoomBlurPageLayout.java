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
    private AlaLiveRoomCoverLayout hFa;
    private SimpleDraweeView hFb;
    private FrameLayout hFc;
    private View hFd;
    private View hFe;
    private FrameLayout hFf;
    private TextView hFg;
    Runnable hFh;
    private AlaLiveView huQ;
    private Handler mHandler;
    private TbPageContext mPageContext;
    private ViewGroup mRootView;

    public AlaLiveRoomBlurPageLayout(Context context) {
        super(context);
        this.hFb = null;
        this.hFd = null;
        this.huQ = null;
        this.hFe = null;
        this.hFf = null;
        this.hFg = null;
        this.hFh = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveRoomBlurPageLayout.1
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
                        AlaLiveRoomBlurPageLayout.this.hFb.setAlpha(0.0f);
                        AlaLiveRoomBlurPageLayout.this.hFa.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                AlaLiveRoomBlurPageLayout.this.hFb.clearAnimation();
                AlaLiveRoomBlurPageLayout.this.hFb.startAnimation(alphaAnimation);
            }
        };
        init();
    }

    public AlaLiveRoomBlurPageLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hFb = null;
        this.hFd = null;
        this.huQ = null;
        this.hFe = null;
        this.hFf = null;
        this.hFg = null;
        this.hFh = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveRoomBlurPageLayout.1
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
                        AlaLiveRoomBlurPageLayout.this.hFb.setAlpha(0.0f);
                        AlaLiveRoomBlurPageLayout.this.hFa.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                AlaLiveRoomBlurPageLayout.this.hFb.clearAnimation();
                AlaLiveRoomBlurPageLayout.this.hFb.startAnimation(alphaAnimation);
            }
        };
        init();
    }

    public AlaLiveRoomBlurPageLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hFb = null;
        this.hFd = null;
        this.huQ = null;
        this.hFe = null;
        this.hFf = null;
        this.hFg = null;
        this.hFh = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveRoomBlurPageLayout.1
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
                        AlaLiveRoomBlurPageLayout.this.hFb.setAlpha(0.0f);
                        AlaLiveRoomBlurPageLayout.this.hFa.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                AlaLiveRoomBlurPageLayout.this.hFb.clearAnimation();
                AlaLiveRoomBlurPageLayout.this.hFb.startAnimation(alphaAnimation);
            }
        };
        init();
    }

    private void init() {
        Log.i("LiveRoomBlurPageLayout", "@@ context = " + getContext());
        this.mRootView = (ViewGroup) View.inflate(getContext(), a.g.ala_liveroom_audience_blur_layout, this);
        setClipChildren(false);
        this.hFa = (AlaLiveRoomCoverLayout) findViewById(a.f.layout_liveroom_cover);
        this.hFb = this.hFa.hFk;
        this.hFc = new FrameLayout(getContext());
        this.hFc.setId(a.f.ala_liveroom_player_container_view);
        this.mHandler = new Handler();
    }

    public void c(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        int[] screenFullSize = ViewCommonUtil.getScreenFullSize(tbPageContext.getPageActivity());
        bZ(screenFullSize[0], screenFullSize[1]);
    }

    private void bZ(int i, int i2) {
        if (this.hFa != null && this.hFa.getLayoutParams() != null && i > 0 && i2 > 0) {
            ViewGroup.LayoutParams layoutParams = this.hFa.getLayoutParams();
            layoutParams.width = i;
            layoutParams.height = i2;
            this.hFa.setLayoutParams(layoutParams);
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
            if (this.hFf != null && this.hFf.getParent() != null) {
                ViewGroup.LayoutParams layoutParams = this.hFf.getLayoutParams();
                layoutParams.width = screenFullSize[0];
                layoutParams.height = screenFullSize[1] - 0;
                this.hFf.setLayoutParams(layoutParams);
            }
        }
    }

    public void a(AlaLiveView alaLiveView, ViewGroup.LayoutParams layoutParams) {
        if (alaLiveView != null) {
            if (this.mRootView.indexOfChild(alaLiveView) < 0 && this.mRootView.getChildCount() > 1) {
                this.huQ = alaLiveView;
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
            clh();
        }
    }

    public void cle() {
        if (this.huQ != null) {
            this.mRootView.removeView(this.huQ);
        }
        this.huQ = null;
    }

    @Override // com.baidu.live.u.e
    public ViewGroup getLiveContainerView() {
        return this;
    }

    @Override // com.baidu.live.u.e
    public FrameLayout getMastView() {
        return this.hFc;
    }

    public void a(View view, ViewGroup.LayoutParams layoutParams, boolean z) {
        if (this.hFc.getParent() != null) {
            this.mRootView.removeView(this.hFc);
        }
        this.mRootView.addView(this.hFc, 1);
        if (this.hFd != null && this.hFd.getParent() != null) {
            ((ViewGroup) this.hFd.getParent()).removeView(this.hFd);
        }
        this.hFd = view;
        if (this.hFd != null && this.hFd.getParent() != null) {
            ((ViewGroup) this.hFd.getParent()).removeView(this.hFd);
        }
        if (this.hFd != null) {
            if (layoutParams != null) {
                this.hFc.addView(this.hFd, layoutParams);
            } else {
                this.hFc.addView(this.hFd, this.hFd.getLayoutParams());
            }
        }
    }

    public void Yj() {
        if (this.hFc.getParent() != null) {
            ((ViewGroup) this.hFc.getParent()).removeView(this.hFc);
        }
        if (this.hFd != null && this.hFd.getParent() != null) {
            ((ViewGroup) this.hFd.getParent()).removeView(this.hFd);
        }
        this.hFd = null;
    }

    public boolean cu(View view) {
        return (this.hFc == null || this.hFc.getParent() == null || this.hFc.indexOfChild(view) < 0) ? false : true;
    }

    public void c(View view, ViewGroup.LayoutParams layoutParams) {
        if (this.hFe != null && this.mRootView.indexOfChild(this.hFe) >= 0) {
            this.mRootView.removeView(this.hFe);
        }
        this.hFe = view;
        int childCount = this.mRootView.getChildCount() - 1;
        int childCount2 = this.mRootView.getChildCount();
        int i = childCount;
        for (int i2 = 0; i2 < childCount2; i2++) {
            if (this.mRootView.getChildAt(i2).getId() == a.f.ala_live_room_close_btn_layout) {
                i = Math.max(i, i2);
            }
        }
        if (this.hFe != null) {
            this.mRootView.addView(this.hFe, i, layoutParams);
        }
        clh();
    }

    public void clf() {
        if (this.hFe != null) {
            this.mRootView.removeView(this.hFe);
        }
        this.hFe = null;
    }

    public void clg() {
        this.mHandler.removeCallbacks(this.hFh);
        this.hFb.clearAnimation();
        this.hFb.setAlpha(1.0f);
        this.hFa.setVisibility(0);
    }

    public void setBackImageBlack(AlaLiveInfoData alaLiveInfoData) {
        if ((alaLiveInfoData == null || alaLiveInfoData.screen_direction != 2) && this.hFb != null) {
            this.hFb.setImageDrawable(null);
            this.hFb.setBackgroundColor(this.mPageContext.getResources().getColor(a.c.sdk_transparent));
        }
    }

    public void setBgImageUrl(String str, int i, AlaLiveInfoData alaLiveInfoData) {
        if (this.mPageContext != null && !TextUtils.isEmpty(str)) {
            int[] screenFullSize = ViewCommonUtil.getScreenFullSize(this.mPageContext.getPageActivity());
            bZ(screenFullSize[0], screenFullSize[1]);
            if (!TextUtils.isEmpty(str)) {
                a(this.hFb, str, 2, 20);
            } else {
                this.hFb.setBackgroundResource(a.e.pic_avatar_moren);
            }
        }
    }

    public void a(SimpleDraweeView simpleDraweeView, String str, int i, int i2) {
        try {
            simpleDraweeView.setController(com.facebook.drawee.a.a.c.eqG().c(simpleDraweeView.getController()).bo(ImageRequestBuilder.af(Uri.parse(str)).a(new com.facebook.imagepipeline.i.a(i, i2)).exx()).erx());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setBgImageUrl(String str, AlaLiveInfoData alaLiveInfoData) {
        setBgImageUrl(str, 10, alaLiveInfoData);
    }

    public void release() {
        if (this.hFb != null) {
            this.hFb.setImageDrawable(null);
            this.hFb.setController(null);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (this.huQ != null && !this.huQ.hFv) {
            z = this.huQ.W(motionEvent);
        }
        if (z || motionEvent.getAction() == 0) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void oj(boolean z) {
        Context context = getContext();
        if (this.hFg == null) {
            this.hFf = new FrameLayout(context);
            this.hFf.setBackgroundColor(getContext().getResources().getColor(a.c.sdk_cp_cont_b));
            this.hFg = new TextView(context);
            this.hFg.setText(context.getResources().getString(a.h.ala_live_private_tip));
            this.hFg.setTextSize(0, context.getResources().getDimensionPixelSize(a.d.sdk_ds28));
            this.hFg.setTextColor(context.getResources().getColor(a.c.sdk_cp_cont_i_alpha40));
            this.hFg.setGravity(49);
            Drawable drawable = context.getResources().getDrawable(a.e.private_tip);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            this.hFg.setCompoundDrawables(null, drawable, null, null);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.topMargin = ok(z);
            layoutParams.gravity = 1;
            this.hFf.addView(this.hFg, layoutParams);
            int indexOfChild = this.huQ != null ? this.mRootView.indexOfChild(this.huQ) : -1;
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
            int[] screenFullSize = ViewCommonUtil.getScreenFullSize(this.mPageContext.getPageActivity());
            int statusBarHeight = !UtilHelper.canUseStyleImmersiveSticky() ? UtilHelper.getStatusBarHeight() : 0;
            layoutParams2.width = screenFullSize[0];
            layoutParams2.height = screenFullSize[1] - statusBarHeight;
            if (indexOfChild < 0) {
                this.mRootView.addView(this.hFf, layoutParams2);
            } else {
                this.mRootView.addView(this.hFf, indexOfChild, layoutParams2);
            }
        } else {
            if (this.hFf.getParent() != null) {
                this.mRootView.removeView(this.hFf);
            }
            int indexOfChild2 = this.huQ != null ? this.mRootView.indexOfChild(this.huQ) : -1;
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -1);
            int[] screenFullSize2 = ViewCommonUtil.getScreenFullSize(this.mPageContext.getPageActivity());
            int statusBarHeight2 = !UtilHelper.canUseStyleImmersiveSticky() ? UtilHelper.getStatusBarHeight() : 0;
            layoutParams3.width = screenFullSize2[0];
            layoutParams3.height = screenFullSize2[1] - statusBarHeight2;
            if (indexOfChild2 < 0) {
                this.mRootView.addView(this.hFf, layoutParams3);
            } else {
                this.mRootView.addView(this.hFf, indexOfChild2, layoutParams3);
            }
            FrameLayout.LayoutParams layoutParams4 = (FrameLayout.LayoutParams) this.hFg.getLayoutParams();
            layoutParams4.topMargin = ok(z);
            this.hFg.setLayoutParams(layoutParams4);
        }
        this.hFf.setVisibility(0);
        this.hFg.setVisibility(0);
        if (this.hFd != null) {
            this.hFd.setVisibility(8);
        }
        if (this.hFa != null) {
            this.hFa.setVisibility(8);
        }
    }

    public void M(int i, boolean z) {
        FrameLayout.LayoutParams layoutParams;
        if (this.hFg != null) {
            if (this.hFg.getLayoutParams() != null && (this.hFg.getLayoutParams() instanceof FrameLayout.LayoutParams)) {
                layoutParams = (FrameLayout.LayoutParams) this.hFg.getLayoutParams();
            } else {
                layoutParams = new FrameLayout.LayoutParams(-2, -2);
            }
            if (i == 2) {
                layoutParams.topMargin = getResources().getDimensionPixelSize(a.d.sdk_ds45);
                layoutParams.gravity = 1;
                this.hFg.setLayoutParams(layoutParams);
                return;
            }
            layoutParams.topMargin = ok(z);
            layoutParams.gravity = 1;
            this.hFg.setLayoutParams(layoutParams);
        }
    }

    public void clh() {
        if (this.hFf != null && this.hFf.getParent() != null) {
            ((ViewGroup) this.hFf.getParent()).removeView(this.hFf);
        }
        if (this.hFd != null) {
            this.hFd.setVisibility(0);
        }
        if (this.hFa != null) {
            this.hFa.setVisibility(0);
        }
    }

    public boolean cli() {
        return (this.hFf == null || this.hFf.getParent() == null) ? false : true;
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

    public void clj() {
        View findViewWithTag = findViewWithTag("AlaLivePraiseGuideController");
        if (findViewWithTag != null) {
            removeView(findViewWithTag);
        }
    }
}
