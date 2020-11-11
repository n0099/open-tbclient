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
    private AlaLiveView hlI;
    private AlaLiveRoomCoverLayout hvO;
    private SimpleDraweeView hvP;
    private FrameLayout hvQ;
    private View hvR;
    private View hvS;
    private FrameLayout hvT;
    private TextView hvU;
    Runnable hvV;
    private Handler mHandler;
    private TbPageContext mPageContext;
    private ViewGroup mRootView;

    public AlaLiveRoomBlurPageLayout(Context context) {
        super(context);
        this.hvP = null;
        this.hvR = null;
        this.hlI = null;
        this.hvS = null;
        this.hvT = null;
        this.hvU = null;
        this.hvV = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveRoomBlurPageLayout.1
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
                        AlaLiveRoomBlurPageLayout.this.hvP.setAlpha(0.0f);
                        AlaLiveRoomBlurPageLayout.this.hvO.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                AlaLiveRoomBlurPageLayout.this.hvP.clearAnimation();
                AlaLiveRoomBlurPageLayout.this.hvP.startAnimation(alphaAnimation);
            }
        };
        init();
    }

    public AlaLiveRoomBlurPageLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hvP = null;
        this.hvR = null;
        this.hlI = null;
        this.hvS = null;
        this.hvT = null;
        this.hvU = null;
        this.hvV = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveRoomBlurPageLayout.1
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
                        AlaLiveRoomBlurPageLayout.this.hvP.setAlpha(0.0f);
                        AlaLiveRoomBlurPageLayout.this.hvO.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                AlaLiveRoomBlurPageLayout.this.hvP.clearAnimation();
                AlaLiveRoomBlurPageLayout.this.hvP.startAnimation(alphaAnimation);
            }
        };
        init();
    }

    public AlaLiveRoomBlurPageLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hvP = null;
        this.hvR = null;
        this.hlI = null;
        this.hvS = null;
        this.hvT = null;
        this.hvU = null;
        this.hvV = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveRoomBlurPageLayout.1
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
                        AlaLiveRoomBlurPageLayout.this.hvP.setAlpha(0.0f);
                        AlaLiveRoomBlurPageLayout.this.hvO.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                AlaLiveRoomBlurPageLayout.this.hvP.clearAnimation();
                AlaLiveRoomBlurPageLayout.this.hvP.startAnimation(alphaAnimation);
            }
        };
        init();
    }

    private void init() {
        Log.i("LiveRoomBlurPageLayout", "@@ context = " + getContext());
        this.mRootView = (ViewGroup) View.inflate(getContext(), a.g.ala_liveroom_audience_blur_layout, this);
        setClipChildren(false);
        this.hvO = (AlaLiveRoomCoverLayout) findViewById(a.f.layout_liveroom_cover);
        this.hvP = this.hvO.hvY;
        this.hvQ = new FrameLayout(getContext());
        this.hvQ.setId(a.f.ala_liveroom_player_container_view);
        this.mHandler = new Handler();
    }

    public void c(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        int[] screenFullSize = ViewCommonUtil.getScreenFullSize(tbPageContext.getPageActivity());
        bV(screenFullSize[0], screenFullSize[1]);
    }

    private void bV(int i, int i2) {
        if (this.hvO != null && this.hvO.getLayoutParams() != null && i > 0 && i2 > 0) {
            ViewGroup.LayoutParams layoutParams = this.hvO.getLayoutParams();
            layoutParams.width = i;
            layoutParams.height = i2;
            this.hvO.setLayoutParams(layoutParams);
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
            if (this.hvT != null && this.hvT.getParent() != null) {
                ViewGroup.LayoutParams layoutParams = this.hvT.getLayoutParams();
                layoutParams.width = screenFullSize[0];
                layoutParams.height = screenFullSize[1] - 0;
                this.hvT.setLayoutParams(layoutParams);
            }
        }
    }

    public void a(AlaLiveView alaLiveView, ViewGroup.LayoutParams layoutParams) {
        if (alaLiveView != null) {
            if (this.mRootView.indexOfChild(alaLiveView) < 0 && this.mRootView.getChildCount() > 1) {
                this.hlI = alaLiveView;
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
            chT();
        }
    }

    public void chQ() {
        if (this.hlI != null) {
            this.mRootView.removeView(this.hlI);
        }
        this.hlI = null;
    }

    @Override // com.baidu.live.s.e
    public ViewGroup getLiveContainerView() {
        return this;
    }

    @Override // com.baidu.live.s.e
    public FrameLayout getMastView() {
        return this.hvQ;
    }

    public void a(View view, ViewGroup.LayoutParams layoutParams, boolean z) {
        if (this.hvQ.getParent() != null) {
            this.mRootView.removeView(this.hvQ);
        }
        this.mRootView.addView(this.hvQ, 1);
        if (this.hvR != null && this.hvR.getParent() != null) {
            ((ViewGroup) this.hvR.getParent()).removeView(this.hvR);
        }
        this.hvR = view;
        if (this.hvR != null && this.hvR.getParent() != null) {
            ((ViewGroup) this.hvR.getParent()).removeView(this.hvR);
        }
        if (this.hvR != null) {
            if (layoutParams != null) {
                this.hvQ.addView(this.hvR, layoutParams);
            } else {
                this.hvQ.addView(this.hvR, this.hvR.getLayoutParams());
            }
        }
    }

    public void Ws() {
        if (this.hvQ.getParent() != null) {
            ((ViewGroup) this.hvQ.getParent()).removeView(this.hvQ);
        }
        if (this.hvR != null && this.hvR.getParent() != null) {
            ((ViewGroup) this.hvR.getParent()).removeView(this.hvR);
        }
        this.hvR = null;
    }

    public boolean ck(View view) {
        return (this.hvQ == null || this.hvQ.getParent() == null || this.hvQ.indexOfChild(view) < 0) ? false : true;
    }

    public void c(View view, ViewGroup.LayoutParams layoutParams) {
        if (this.hvS != null && this.mRootView.indexOfChild(this.hvS) >= 0) {
            this.mRootView.removeView(this.hvS);
        }
        this.hvS = view;
        int childCount = this.mRootView.getChildCount() - 1;
        int childCount2 = this.mRootView.getChildCount();
        int i = childCount;
        for (int i2 = 0; i2 < childCount2; i2++) {
            if (this.mRootView.getChildAt(i2).getId() == a.f.ala_live_room_close_btn_layout) {
                i = Math.max(i, i2);
            }
        }
        if (this.hvS != null) {
            this.mRootView.addView(this.hvS, i, layoutParams);
        }
        chT();
    }

    public void chR() {
        if (this.hvS != null) {
            this.mRootView.removeView(this.hvS);
        }
        this.hvS = null;
    }

    public void chS() {
        this.mHandler.removeCallbacks(this.hvV);
        this.hvP.clearAnimation();
        this.hvP.setAlpha(1.0f);
        this.hvO.setVisibility(0);
    }

    public void setBackImageBlack(AlaLiveInfoData alaLiveInfoData) {
        if ((alaLiveInfoData == null || alaLiveInfoData.screen_direction != 2) && this.hvP != null) {
            this.hvP.setImageDrawable(null);
            this.hvP.setBackgroundColor(this.mPageContext.getResources().getColor(a.c.sdk_transparent));
        }
    }

    public void setBgImageUrl(String str, int i, AlaLiveInfoData alaLiveInfoData) {
        if (this.mPageContext != null && !TextUtils.isEmpty(str)) {
            int[] screenFullSize = ViewCommonUtil.getScreenFullSize(this.mPageContext.getPageActivity());
            bV(screenFullSize[0], screenFullSize[1]);
            if (!TextUtils.isEmpty(str)) {
                a(this.hvP, str, 2, 20);
            } else {
                this.hvP.setBackgroundResource(a.e.pic_avatar_moren);
            }
        }
    }

    public void a(SimpleDraweeView simpleDraweeView, String str, int i, int i2) {
        try {
            simpleDraweeView.setController(com.facebook.drawee.a.a.c.ekS().c(simpleDraweeView.getController()).bn(ImageRequestBuilder.ad(Uri.parse(str)).a(new com.facebook.imagepipeline.j.a(i, i2)).erY()).elJ());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setBgImageUrl(String str, AlaLiveInfoData alaLiveInfoData) {
        setBgImageUrl(str, 10, alaLiveInfoData);
    }

    public void release() {
        if (this.hvP != null) {
            this.hvP.setImageDrawable(null);
            this.hvP.setController(null);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (this.hlI != null && !this.hlI.hwi) {
            z = this.hlI.W(motionEvent);
        }
        if (z || motionEvent.getAction() == 0) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void nN(boolean z) {
        Context context = getContext();
        if (this.hvU == null) {
            this.hvT = new FrameLayout(context);
            this.hvT.setBackgroundColor(getContext().getResources().getColor(a.c.sdk_cp_cont_b));
            this.hvU = new TextView(context);
            this.hvU.setText(context.getResources().getString(a.h.ala_live_private_tip));
            this.hvU.setTextSize(0, context.getResources().getDimensionPixelSize(a.d.sdk_ds28));
            this.hvU.setTextColor(context.getResources().getColor(a.c.sdk_cp_cont_i_alpha40));
            this.hvU.setGravity(49);
            Drawable drawable = context.getResources().getDrawable(a.e.private_tip);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            this.hvU.setCompoundDrawables(null, drawable, null, null);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.topMargin = nO(z);
            layoutParams.gravity = 1;
            this.hvT.addView(this.hvU, layoutParams);
            int indexOfChild = this.hlI != null ? this.mRootView.indexOfChild(this.hlI) : -1;
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
            int[] screenFullSize = ViewCommonUtil.getScreenFullSize(this.mPageContext.getPageActivity());
            int statusBarHeight = !UtilHelper.canUseStyleImmersiveSticky() ? UtilHelper.getStatusBarHeight() : 0;
            layoutParams2.width = screenFullSize[0];
            layoutParams2.height = screenFullSize[1] - statusBarHeight;
            if (indexOfChild < 0) {
                this.mRootView.addView(this.hvT, layoutParams2);
            } else {
                this.mRootView.addView(this.hvT, indexOfChild, layoutParams2);
            }
        } else {
            if (this.hvT.getParent() != null) {
                this.mRootView.removeView(this.hvT);
            }
            int indexOfChild2 = this.hlI != null ? this.mRootView.indexOfChild(this.hlI) : -1;
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -1);
            int[] screenFullSize2 = ViewCommonUtil.getScreenFullSize(this.mPageContext.getPageActivity());
            int statusBarHeight2 = !UtilHelper.canUseStyleImmersiveSticky() ? UtilHelper.getStatusBarHeight() : 0;
            layoutParams3.width = screenFullSize2[0];
            layoutParams3.height = screenFullSize2[1] - statusBarHeight2;
            if (indexOfChild2 < 0) {
                this.mRootView.addView(this.hvT, layoutParams3);
            } else {
                this.mRootView.addView(this.hvT, indexOfChild2, layoutParams3);
            }
            FrameLayout.LayoutParams layoutParams4 = (FrameLayout.LayoutParams) this.hvU.getLayoutParams();
            layoutParams4.topMargin = nO(z);
            this.hvU.setLayoutParams(layoutParams4);
        }
        this.hvT.setVisibility(0);
        this.hvU.setVisibility(0);
        if (this.hvR != null) {
            this.hvR.setVisibility(8);
        }
        if (this.hvO != null) {
            this.hvO.setVisibility(8);
        }
    }

    public void M(int i, boolean z) {
        FrameLayout.LayoutParams layoutParams;
        if (this.hvU != null) {
            if (this.hvU.getLayoutParams() != null && (this.hvU.getLayoutParams() instanceof FrameLayout.LayoutParams)) {
                layoutParams = (FrameLayout.LayoutParams) this.hvU.getLayoutParams();
            } else {
                layoutParams = new FrameLayout.LayoutParams(-2, -2);
            }
            if (i == 2) {
                layoutParams.topMargin = getResources().getDimensionPixelSize(a.d.sdk_ds45);
                layoutParams.gravity = 1;
                this.hvU.setLayoutParams(layoutParams);
                return;
            }
            layoutParams.topMargin = nO(z);
            layoutParams.gravity = 1;
            this.hvU.setLayoutParams(layoutParams);
        }
    }

    public void chT() {
        if (this.hvT != null && this.hvT.getParent() != null) {
            ((ViewGroup) this.hvT.getParent()).removeView(this.hvT);
        }
        if (this.hvR != null) {
            this.hvR.setVisibility(0);
        }
        if (this.hvO != null) {
            this.hvO.setVisibility(0);
        }
    }

    public boolean chU() {
        return (this.hvT == null || this.hvT.getParent() == null) ? false : true;
    }

    private int nO(boolean z) {
        if (z) {
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                return UtilHelper.getStatusBarHeight();
            }
            return 0;
        }
        return this.mPageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds160);
    }

    public void chV() {
        View findViewWithTag = findViewWithTag("AlaLivePraiseGuideController");
        if (findViewWithTag != null) {
            removeView(findViewWithTag);
        }
    }
}
