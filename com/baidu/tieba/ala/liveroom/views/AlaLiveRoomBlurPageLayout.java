package com.baidu.tieba.ala.liveroom.views;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
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
import com.baidu.live.tbadk.widget.TbImageView;
/* loaded from: classes4.dex */
public class AlaLiveRoomBlurPageLayout extends FrameLayout implements com.baidu.live.q.e {
    private AlaLiveView gFC;
    private AlaLiveRoomCoverLayout gOX;
    private TbImageView gOY;
    private FrameLayout gOZ;
    private View gPa;
    private View gPb;
    private FrameLayout gPc;
    private TextView gPd;
    Runnable gPe;
    private Handler mHandler;
    private TbPageContext mPageContext;
    private ViewGroup mRootView;

    public AlaLiveRoomBlurPageLayout(Context context) {
        super(context);
        this.gOY = null;
        this.gPa = null;
        this.gFC = null;
        this.gPb = null;
        this.gPc = null;
        this.gPd = null;
        this.gPe = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveRoomBlurPageLayout.1
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
                        AlaLiveRoomBlurPageLayout.this.gOY.setAlpha(0.0f);
                        AlaLiveRoomBlurPageLayout.this.gOX.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                AlaLiveRoomBlurPageLayout.this.gOY.clearAnimation();
                AlaLiveRoomBlurPageLayout.this.gOY.startAnimation(alphaAnimation);
            }
        };
        init();
    }

    public AlaLiveRoomBlurPageLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gOY = null;
        this.gPa = null;
        this.gFC = null;
        this.gPb = null;
        this.gPc = null;
        this.gPd = null;
        this.gPe = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveRoomBlurPageLayout.1
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
                        AlaLiveRoomBlurPageLayout.this.gOY.setAlpha(0.0f);
                        AlaLiveRoomBlurPageLayout.this.gOX.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                AlaLiveRoomBlurPageLayout.this.gOY.clearAnimation();
                AlaLiveRoomBlurPageLayout.this.gOY.startAnimation(alphaAnimation);
            }
        };
        init();
    }

    public AlaLiveRoomBlurPageLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gOY = null;
        this.gPa = null;
        this.gFC = null;
        this.gPb = null;
        this.gPc = null;
        this.gPd = null;
        this.gPe = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveRoomBlurPageLayout.1
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
                        AlaLiveRoomBlurPageLayout.this.gOY.setAlpha(0.0f);
                        AlaLiveRoomBlurPageLayout.this.gOX.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                AlaLiveRoomBlurPageLayout.this.gOY.clearAnimation();
                AlaLiveRoomBlurPageLayout.this.gOY.startAnimation(alphaAnimation);
            }
        };
        init();
    }

    private void init() {
        Log.i("LiveRoomBlurPageLayout", "@@ context = " + getContext());
        this.mRootView = (ViewGroup) View.inflate(getContext(), a.h.ala_liveroom_audience_blur_layout, this);
        setClipChildren(false);
        this.gOX = (AlaLiveRoomCoverLayout) findViewById(a.g.layout_liveroom_cover);
        this.gOY = this.gOX.gPh;
        this.gOZ = new FrameLayout(getContext());
        this.gOZ.setId(a.g.ala_liveroom_player_container_view);
        this.mHandler = new Handler();
    }

    public void c(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        int[] screenFullSize = ViewCommonUtil.getScreenFullSize(tbPageContext.getPageActivity());
        bR(screenFullSize[0], screenFullSize[1]);
    }

    private void bR(int i, int i2) {
        if (this.gOX != null && this.gOX.getLayoutParams() != null && i > 0 && i2 > 0) {
            ViewGroup.LayoutParams layoutParams = this.gOX.getLayoutParams();
            layoutParams.width = i;
            layoutParams.height = i2;
            this.gOX.setLayoutParams(layoutParams);
        }
    }

    public void D(int i, int i2) {
        bR(i, i2);
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (configuration != null) {
            int[] screenFullSize = ViewCommonUtil.getScreenFullSize(this.mPageContext.getPageActivity());
            if (this.gPc != null && this.gPc.getParent() != null) {
                ViewGroup.LayoutParams layoutParams = this.gPc.getLayoutParams();
                layoutParams.width = screenFullSize[0];
                layoutParams.height = screenFullSize[1] - 0;
                this.gPc.setLayoutParams(layoutParams);
            }
        }
    }

    public void a(AlaLiveView alaLiveView, ViewGroup.LayoutParams layoutParams) {
        if (alaLiveView != null) {
            if (this.mRootView.indexOfChild(alaLiveView) < 0 && this.mRootView.getChildCount() > 1) {
                this.gFC = alaLiveView;
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
            bYO();
        }
    }

    public void bYJ() {
        if (this.gFC != null) {
            this.mRootView.removeView(this.gFC);
        }
        this.gFC = null;
    }

    @Override // com.baidu.live.q.e
    public ViewGroup getLiveContainerView() {
        return this;
    }

    public void a(View view, ViewGroup.LayoutParams layoutParams, boolean z) {
        if (this.gOZ.getParent() != null) {
            this.mRootView.removeView(this.gOZ);
        }
        this.mRootView.addView(this.gOZ, 1);
        if (this.gPa != null && this.gPa.getParent() != null) {
            ((ViewGroup) this.gPa.getParent()).removeView(this.gPa);
        }
        this.gPa = view;
        if (this.gPa != null && this.gPa.getParent() != null) {
            ((ViewGroup) this.gPa.getParent()).removeView(this.gPa);
        }
        if (this.gPa != null) {
            if (layoutParams != null) {
                this.gOZ.addView(this.gPa, layoutParams);
            } else {
                this.gOZ.addView(this.gPa, this.gPa.getLayoutParams());
            }
        }
    }

    public void Rb() {
        if (this.gOZ.getParent() != null) {
            ((ViewGroup) this.gOZ.getParent()).removeView(this.gOZ);
        }
        if (this.gPa != null && this.gPa.getParent() != null) {
            ((ViewGroup) this.gPa.getParent()).removeView(this.gPa);
        }
        this.gPa = null;
    }

    public boolean bX(View view) {
        return (this.gOZ == null || this.gOZ.getParent() == null || this.gOZ.indexOfChild(view) < 0) ? false : true;
    }

    public void c(View view, ViewGroup.LayoutParams layoutParams) {
        if (this.gPb != null && this.mRootView.indexOfChild(this.gPb) >= 0) {
            this.mRootView.removeView(this.gPb);
        }
        this.gPb = view;
        int childCount = this.mRootView.getChildCount() - 1;
        int childCount2 = this.mRootView.getChildCount();
        int i = childCount;
        for (int i2 = 0; i2 < childCount2; i2++) {
            if (this.mRootView.getChildAt(i2).getId() == a.g.ala_live_room_close_btn_layout) {
                i = Math.max(i, i2);
            }
        }
        if (this.gPb != null) {
            this.mRootView.addView(this.gPb, i, layoutParams);
        }
        bYO();
    }

    public void bYK() {
        if (this.gPb != null) {
            this.mRootView.removeView(this.gPb);
        }
        this.gPb = null;
    }

    public void bYL() {
        if (this.gOY.getAlpha() == 1.0f) {
            this.gOY.clearAnimation();
            this.mHandler.postDelayed(this.gPe, 300L);
            return;
        }
        this.gOY.clearAnimation();
        this.gOY.setAlpha(0.0f);
        this.gOX.setVisibility(8);
    }

    public void bYM() {
        this.mHandler.removeCallbacks(this.gPe);
        this.gOY.clearAnimation();
        this.gOY.setAlpha(0.0f);
        this.gOX.setVisibility(8);
    }

    public void bYN() {
        this.mHandler.removeCallbacks(this.gPe);
        this.gOY.clearAnimation();
        this.gOY.setAlpha(1.0f);
        this.gOX.setVisibility(0);
    }

    public void setBackImageBlack(AlaLiveInfoData alaLiveInfoData) {
        if ((alaLiveInfoData == null || alaLiveInfoData.screen_direction != 2) && this.gOY != null) {
            this.gOY.setImageDrawable(null);
            this.gOY.setBackgroundColor(this.mPageContext.getResources().getColor(a.d.sdk_transparent));
        }
    }

    public void setBgImageUrl(String str, int i, AlaLiveInfoData alaLiveInfoData) {
        if (this.mPageContext != null && !TextUtils.isEmpty(str)) {
            int[] screenFullSize = ViewCommonUtil.getScreenFullSize(this.mPageContext.getPageActivity());
            bR(screenFullSize[0], screenFullSize[1]);
            if (!TextUtils.isEmpty(str)) {
                this.gOY.startLoad(str, 39, false, false);
            } else {
                this.gOY.setBackgroundResource(a.f.pic_avatar_moren);
            }
        }
    }

    public void setBgImageUrl(String str, AlaLiveInfoData alaLiveInfoData) {
        setBgImageUrl(str, 10, alaLiveInfoData);
    }

    public void release() {
        if (this.gOY != null) {
            this.gOY.setImageDrawable(null);
            this.gOY.stopLoad();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (this.gFC != null && !this.gFC.gPr) {
            z = this.gFC.V(motionEvent);
        }
        if (z || motionEvent.getAction() == 0) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void mL(boolean z) {
        Context context = getContext();
        if (this.gPd == null) {
            this.gPc = new FrameLayout(context);
            this.gPc.setBackgroundColor(getContext().getResources().getColor(a.d.sdk_cp_cont_b));
            this.gPd = new TextView(context);
            this.gPd.setText(context.getResources().getString(a.i.ala_live_private_tip));
            this.gPd.setTextSize(0, context.getResources().getDimensionPixelSize(a.e.sdk_ds28));
            this.gPd.setTextColor(context.getResources().getColor(a.d.sdk_cp_cont_i_alpha40));
            this.gPd.setGravity(49);
            Drawable drawable = context.getResources().getDrawable(a.f.private_tip);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            this.gPd.setCompoundDrawables(null, drawable, null, null);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.topMargin = mM(z);
            layoutParams.gravity = 1;
            this.gPc.addView(this.gPd, layoutParams);
            int indexOfChild = this.gFC != null ? this.mRootView.indexOfChild(this.gFC) : -1;
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
            int[] screenFullSize = ViewCommonUtil.getScreenFullSize(this.mPageContext.getPageActivity());
            int statusBarHeight = !UtilHelper.canUseStyleImmersiveSticky() ? UtilHelper.getStatusBarHeight() : 0;
            layoutParams2.width = screenFullSize[0];
            layoutParams2.height = screenFullSize[1] - statusBarHeight;
            if (indexOfChild < 0) {
                this.mRootView.addView(this.gPc, layoutParams2);
            } else {
                this.mRootView.addView(this.gPc, indexOfChild, layoutParams2);
            }
        } else {
            if (this.gPc.getParent() != null) {
                this.mRootView.removeView(this.gPc);
            }
            int indexOfChild2 = this.gFC != null ? this.mRootView.indexOfChild(this.gFC) : -1;
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -1);
            int[] screenFullSize2 = ViewCommonUtil.getScreenFullSize(this.mPageContext.getPageActivity());
            int statusBarHeight2 = !UtilHelper.canUseStyleImmersiveSticky() ? UtilHelper.getStatusBarHeight() : 0;
            layoutParams3.width = screenFullSize2[0];
            layoutParams3.height = screenFullSize2[1] - statusBarHeight2;
            if (indexOfChild2 < 0) {
                this.mRootView.addView(this.gPc, layoutParams3);
            } else {
                this.mRootView.addView(this.gPc, indexOfChild2, layoutParams3);
            }
            FrameLayout.LayoutParams layoutParams4 = (FrameLayout.LayoutParams) this.gPd.getLayoutParams();
            layoutParams4.topMargin = mM(z);
            this.gPd.setLayoutParams(layoutParams4);
        }
        this.gPc.setVisibility(0);
        this.gPd.setVisibility(0);
        if (this.gPa != null) {
            this.gPa.setVisibility(8);
        }
        if (this.gOX != null) {
            this.gOX.setVisibility(8);
        }
    }

    public void K(int i, boolean z) {
        FrameLayout.LayoutParams layoutParams;
        if (this.gPd != null) {
            if (this.gPd.getLayoutParams() != null && (this.gPd.getLayoutParams() instanceof FrameLayout.LayoutParams)) {
                layoutParams = (FrameLayout.LayoutParams) this.gPd.getLayoutParams();
            } else {
                layoutParams = new FrameLayout.LayoutParams(-2, -2);
            }
            if (i == 2) {
                layoutParams.topMargin = getResources().getDimensionPixelSize(a.e.sdk_ds45);
                layoutParams.gravity = 1;
                this.gPd.setLayoutParams(layoutParams);
                return;
            }
            layoutParams.topMargin = mM(z);
            layoutParams.gravity = 1;
            this.gPd.setLayoutParams(layoutParams);
        }
    }

    public void bYO() {
        if (this.gPc != null && this.gPc.getParent() != null) {
            ((ViewGroup) this.gPc.getParent()).removeView(this.gPc);
        }
        if (this.gPa != null) {
            this.gPa.setVisibility(0);
        }
        if (this.gOX != null) {
            this.gOX.setVisibility(0);
        }
    }

    public boolean bYP() {
        return (this.gPc == null || this.gPc.getParent() == null) ? false : true;
    }

    private int mM(boolean z) {
        if (z) {
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                return UtilHelper.getStatusBarHeight();
            }
            return 0;
        }
        return this.mPageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds160);
    }

    public void bYQ() {
        View findViewWithTag = findViewWithTag("AlaLivePraiseGuideController");
        if (findViewWithTag != null) {
            removeView(findViewWithTag);
        }
    }
}
