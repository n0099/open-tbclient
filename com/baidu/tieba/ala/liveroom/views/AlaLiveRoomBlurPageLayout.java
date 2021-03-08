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
public class AlaLiveRoomBlurPageLayout extends FrameLayout implements com.baidu.live.u.e {
    private AlaLiveView hIm;
    private AlaLiveRoomCoverLayout hSL;
    private SimpleDraweeView hSM;
    private FrameLayout hSN;
    private View hSO;
    private View hSP;
    private FrameLayout hSQ;
    private TextView hSR;
    Runnable hSS;
    private Handler mHandler;
    private TbPageContext mPageContext;
    private ViewGroup mRootView;

    public AlaLiveRoomBlurPageLayout(Context context) {
        super(context);
        this.hSM = null;
        this.hSO = null;
        this.hIm = null;
        this.hSP = null;
        this.hSQ = null;
        this.hSR = null;
        this.hSS = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveRoomBlurPageLayout.1
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
                        AlaLiveRoomBlurPageLayout.this.hSM.setAlpha(0.0f);
                        AlaLiveRoomBlurPageLayout.this.hSL.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                AlaLiveRoomBlurPageLayout.this.hSM.clearAnimation();
                AlaLiveRoomBlurPageLayout.this.hSM.startAnimation(alphaAnimation);
            }
        };
        init();
    }

    public AlaLiveRoomBlurPageLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hSM = null;
        this.hSO = null;
        this.hIm = null;
        this.hSP = null;
        this.hSQ = null;
        this.hSR = null;
        this.hSS = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveRoomBlurPageLayout.1
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
                        AlaLiveRoomBlurPageLayout.this.hSM.setAlpha(0.0f);
                        AlaLiveRoomBlurPageLayout.this.hSL.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                AlaLiveRoomBlurPageLayout.this.hSM.clearAnimation();
                AlaLiveRoomBlurPageLayout.this.hSM.startAnimation(alphaAnimation);
            }
        };
        init();
    }

    public AlaLiveRoomBlurPageLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hSM = null;
        this.hSO = null;
        this.hIm = null;
        this.hSP = null;
        this.hSQ = null;
        this.hSR = null;
        this.hSS = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveRoomBlurPageLayout.1
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
                        AlaLiveRoomBlurPageLayout.this.hSM.setAlpha(0.0f);
                        AlaLiveRoomBlurPageLayout.this.hSL.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                AlaLiveRoomBlurPageLayout.this.hSM.clearAnimation();
                AlaLiveRoomBlurPageLayout.this.hSM.startAnimation(alphaAnimation);
            }
        };
        init();
    }

    private void init() {
        Log.i("LiveRoomBlurPageLayout", "@@ context = " + getContext());
        this.mRootView = (ViewGroup) View.inflate(getContext(), a.g.ala_liveroom_audience_blur_layout, this);
        setClipChildren(false);
        this.hSL = (AlaLiveRoomCoverLayout) findViewById(a.f.layout_liveroom_cover);
        this.hSM = this.hSL.hSV;
        this.hSN = new FrameLayout(getContext());
        this.hSN.setId(a.f.ala_liveroom_player_container_view);
        this.mHandler = new Handler();
    }

    public void c(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        int[] screenFullSize = ViewCommonUtil.getScreenFullSize(tbPageContext.getPageActivity());
        bW(screenFullSize[0], screenFullSize[1]);
    }

    private void bW(int i, int i2) {
        if (this.hSL != null && this.hSL.getLayoutParams() != null && i > 0 && i2 > 0) {
            ViewGroup.LayoutParams layoutParams = this.hSL.getLayoutParams();
            layoutParams.width = i;
            layoutParams.height = i2;
            this.hSL.setLayoutParams(layoutParams);
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
            if (this.hSQ != null && this.hSQ.getParent() != null) {
                ViewGroup.LayoutParams layoutParams = this.hSQ.getLayoutParams();
                layoutParams.width = screenFullSize[0];
                layoutParams.height = screenFullSize[1] - 0;
                this.hSQ.setLayoutParams(layoutParams);
            }
        }
    }

    public void a(AlaLiveView alaLiveView, ViewGroup.LayoutParams layoutParams) {
        if (alaLiveView != null) {
            if (this.mRootView.indexOfChild(alaLiveView) < 0 && this.mRootView.getChildCount() > 1) {
                this.hIm = alaLiveView;
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
            cls();
        }
    }

    public void clp() {
        if (this.hIm != null) {
            this.mRootView.removeView(this.hIm);
        }
        this.hIm = null;
    }

    @Override // com.baidu.live.u.e
    public ViewGroup getLiveContainerView() {
        return this;
    }

    @Override // com.baidu.live.u.e
    public FrameLayout getMastView() {
        return this.hSN;
    }

    public void a(View view, ViewGroup.LayoutParams layoutParams, boolean z) {
        if (this.hSN.getParent() != null) {
            this.mRootView.removeView(this.hSN);
        }
        this.mRootView.addView(this.hSN, 1);
        if (this.hSO != null && this.hSO.getParent() != null) {
            ((ViewGroup) this.hSO.getParent()).removeView(this.hSO);
        }
        this.hSO = view;
        if (this.hSO != null && this.hSO.getParent() != null) {
            ((ViewGroup) this.hSO.getParent()).removeView(this.hSO);
        }
        if (this.hSO != null) {
            if (layoutParams != null) {
                this.hSN.addView(this.hSO, layoutParams);
            } else {
                this.hSN.addView(this.hSO, this.hSO.getLayoutParams());
            }
        }
    }

    public void Xl() {
        if (this.hSN.getParent() != null) {
            ((ViewGroup) this.hSN.getParent()).removeView(this.hSN);
        }
        if (this.hSO != null && this.hSO.getParent() != null) {
            ((ViewGroup) this.hSO.getParent()).removeView(this.hSO);
        }
        this.hSO = null;
    }

    public boolean cz(View view) {
        return (this.hSN == null || this.hSN.getParent() == null || this.hSN.indexOfChild(view) < 0) ? false : true;
    }

    public void e(View view, ViewGroup.LayoutParams layoutParams) {
        if (this.hSP != null && this.mRootView.indexOfChild(this.hSP) >= 0) {
            this.mRootView.removeView(this.hSP);
        }
        this.hSP = view;
        int childCount = this.mRootView.getChildCount() - 1;
        int childCount2 = this.mRootView.getChildCount();
        for (int i = 0; i < childCount2; i++) {
            if (this.mRootView.getChildAt(i).getId() == a.f.ala_live_room_close_btn_layout) {
                childCount = Math.max(childCount, i);
            }
        }
        if (this.hSP != null) {
            this.mRootView.addView(this.hSP, childCount, layoutParams);
        }
        cls();
    }

    public void clq() {
        if (this.hSP != null) {
            this.mRootView.removeView(this.hSP);
        }
        this.hSP = null;
    }

    public void clr() {
        this.mHandler.removeCallbacks(this.hSS);
        this.hSM.clearAnimation();
        this.hSM.setAlpha(1.0f);
        this.hSL.setVisibility(0);
    }

    public void setBackImageBlack(AlaLiveInfoData alaLiveInfoData) {
        if ((alaLiveInfoData == null || alaLiveInfoData.screen_direction != 2) && this.hSM != null) {
            this.hSM.setImageDrawable(null);
            this.hSM.setBackgroundColor(this.mPageContext.getResources().getColor(a.c.sdk_transparent));
        }
    }

    public void setBgImageUrl(String str, int i, AlaLiveInfoData alaLiveInfoData) {
        if (this.mPageContext != null && !TextUtils.isEmpty(str)) {
            int[] screenFullSize = ViewCommonUtil.getScreenFullSize(this.mPageContext.getPageActivity());
            bW(screenFullSize[0], screenFullSize[1]);
            if (!TextUtils.isEmpty(str)) {
                a(this.hSM, str, 2, 20);
            } else {
                this.hSM.setBackgroundResource(a.e.pic_avatar_moren);
            }
        }
    }

    public void a(SimpleDraweeView simpleDraweeView, String str, int i, int i2) {
        try {
            simpleDraweeView.setController(com.facebook.drawee.a.a.c.etF().c(simpleDraweeView.getController()).bq(ImageRequestBuilder.ag(Uri.parse(str)).a(new com.facebook.imagepipeline.i.a(i, i2)).eAz()).euw());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setBgImageUrl(String str, AlaLiveInfoData alaLiveInfoData) {
        setBgImageUrl(str, 10, alaLiveInfoData);
    }

    public void release() {
        if (this.hSM != null) {
            this.hSM.setImageDrawable(null);
            this.hSM.setController(null);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (this.hIm != null && !this.hIm.hTg) {
            z = this.hIm.X(motionEvent);
        }
        if (z || motionEvent.getAction() == 0) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void oO(boolean z) {
        Context context = getContext();
        if (this.hSR == null) {
            this.hSQ = new FrameLayout(context);
            this.hSQ.setBackgroundColor(getContext().getResources().getColor(a.c.sdk_cp_cont_b));
            this.hSR = new TextView(context);
            this.hSR.setText(context.getResources().getString(a.h.ala_live_private_tip));
            this.hSR.setTextSize(0, context.getResources().getDimensionPixelSize(a.d.sdk_ds28));
            this.hSR.setTextColor(context.getResources().getColor(a.c.sdk_cp_cont_i_alpha40));
            this.hSR.setGravity(49);
            Drawable drawable = context.getResources().getDrawable(a.e.private_tip);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            this.hSR.setCompoundDrawables(null, drawable, null, null);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.topMargin = oP(z);
            layoutParams.gravity = 1;
            this.hSQ.addView(this.hSR, layoutParams);
            int indexOfChild = this.hIm != null ? this.mRootView.indexOfChild(this.hIm) : -1;
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
            int[] screenFullSize = ViewCommonUtil.getScreenFullSize(this.mPageContext.getPageActivity());
            int statusBarHeight = !UtilHelper.canUseStyleImmersiveSticky() ? UtilHelper.getStatusBarHeight() : 0;
            layoutParams2.width = screenFullSize[0];
            layoutParams2.height = screenFullSize[1] - statusBarHeight;
            if (indexOfChild < 0) {
                this.mRootView.addView(this.hSQ, layoutParams2);
            } else {
                this.mRootView.addView(this.hSQ, indexOfChild, layoutParams2);
            }
        } else {
            if (this.hSQ.getParent() != null) {
                this.mRootView.removeView(this.hSQ);
            }
            int indexOfChild2 = this.hIm != null ? this.mRootView.indexOfChild(this.hIm) : -1;
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -1);
            int[] screenFullSize2 = ViewCommonUtil.getScreenFullSize(this.mPageContext.getPageActivity());
            int statusBarHeight2 = !UtilHelper.canUseStyleImmersiveSticky() ? UtilHelper.getStatusBarHeight() : 0;
            layoutParams3.width = screenFullSize2[0];
            layoutParams3.height = screenFullSize2[1] - statusBarHeight2;
            if (indexOfChild2 < 0) {
                this.mRootView.addView(this.hSQ, layoutParams3);
            } else {
                this.mRootView.addView(this.hSQ, indexOfChild2, layoutParams3);
            }
            FrameLayout.LayoutParams layoutParams4 = (FrameLayout.LayoutParams) this.hSR.getLayoutParams();
            layoutParams4.topMargin = oP(z);
            this.hSR.setLayoutParams(layoutParams4);
        }
        this.hSQ.setVisibility(0);
        this.hSR.setVisibility(0);
        if (this.hSO != null) {
            this.hSO.setVisibility(8);
        }
        if (this.hSL != null) {
            this.hSL.setVisibility(8);
        }
    }

    public void M(int i, boolean z) {
        FrameLayout.LayoutParams layoutParams;
        if (this.hSR != null) {
            if (this.hSR.getLayoutParams() != null && (this.hSR.getLayoutParams() instanceof FrameLayout.LayoutParams)) {
                layoutParams = (FrameLayout.LayoutParams) this.hSR.getLayoutParams();
            } else {
                layoutParams = new FrameLayout.LayoutParams(-2, -2);
            }
            if (i == 2) {
                layoutParams.topMargin = getResources().getDimensionPixelSize(a.d.sdk_ds45);
                layoutParams.gravity = 1;
                this.hSR.setLayoutParams(layoutParams);
                return;
            }
            layoutParams.topMargin = oP(z);
            layoutParams.gravity = 1;
            this.hSR.setLayoutParams(layoutParams);
        }
    }

    public void cls() {
        if (this.hSQ != null && this.hSQ.getParent() != null) {
            ((ViewGroup) this.hSQ.getParent()).removeView(this.hSQ);
        }
        if (this.hSO != null) {
            this.hSO.setVisibility(0);
        }
        if (this.hSL != null) {
            this.hSL.setVisibility(0);
        }
    }

    public boolean clt() {
        return (this.hSQ == null || this.hSQ.getParent() == null) ? false : true;
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

    public void clu() {
        View findViewWithTag = findViewWithTag("AlaLivePraiseGuideController");
        if (findViewWithTag != null) {
            removeView(findViewWithTag);
        }
    }
}
