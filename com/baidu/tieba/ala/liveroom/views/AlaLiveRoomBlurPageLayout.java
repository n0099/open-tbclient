package com.baidu.tieba.ala.liveroom.views;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.ColorDrawable;
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
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.core.util.ViewCommonUtil;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.live.u.a;
/* loaded from: classes3.dex */
public class AlaLiveRoomBlurPageLayout extends FrameLayout implements com.baidu.live.o.e {
    private AlaLiveView fIW;
    private TbImageView fRM;
    private FrameLayout fRN;
    private View fRO;
    private View fRP;
    private FrameLayout fRQ;
    private TextView fRR;
    private Bitmap fRS;
    Runnable fRT;
    private Handler mHandler;
    private TbPageContext mPageContext;
    private ViewGroup mRootView;

    public AlaLiveRoomBlurPageLayout(Context context) {
        super(context);
        this.fRM = null;
        this.fRO = null;
        this.fIW = null;
        this.fRP = null;
        this.fRQ = null;
        this.fRR = null;
        this.fRT = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveRoomBlurPageLayout.1
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
                        AlaLiveRoomBlurPageLayout.this.fRM.setAlpha(0.0f);
                        AlaLiveRoomBlurPageLayout.this.fRM.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                AlaLiveRoomBlurPageLayout.this.fRM.clearAnimation();
                AlaLiveRoomBlurPageLayout.this.fRM.startAnimation(alphaAnimation);
            }
        };
        init();
    }

    public AlaLiveRoomBlurPageLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fRM = null;
        this.fRO = null;
        this.fIW = null;
        this.fRP = null;
        this.fRQ = null;
        this.fRR = null;
        this.fRT = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveRoomBlurPageLayout.1
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
                        AlaLiveRoomBlurPageLayout.this.fRM.setAlpha(0.0f);
                        AlaLiveRoomBlurPageLayout.this.fRM.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                AlaLiveRoomBlurPageLayout.this.fRM.clearAnimation();
                AlaLiveRoomBlurPageLayout.this.fRM.startAnimation(alphaAnimation);
            }
        };
        init();
    }

    public AlaLiveRoomBlurPageLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fRM = null;
        this.fRO = null;
        this.fIW = null;
        this.fRP = null;
        this.fRQ = null;
        this.fRR = null;
        this.fRT = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveRoomBlurPageLayout.1
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
                        AlaLiveRoomBlurPageLayout.this.fRM.setAlpha(0.0f);
                        AlaLiveRoomBlurPageLayout.this.fRM.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                AlaLiveRoomBlurPageLayout.this.fRM.clearAnimation();
                AlaLiveRoomBlurPageLayout.this.fRM.startAnimation(alphaAnimation);
            }
        };
        init();
    }

    private void init() {
        Log.i("LiveRoomBlurPageLayout", "@@ context = " + getContext());
        this.mRootView = (ViewGroup) View.inflate(getContext(), a.h.ala_liveroom_audience_blur_layout, this);
        setClipChildren(false);
        this.fRM = (TbImageView) findViewById(a.g.ala_liveroom_background_img);
        this.fRS = drawableToBitmap(new ColorDrawable(getResources().getColor(a.d.sdk_color_333333)));
        this.fRN = new FrameLayout(getContext());
        this.fRN.setId(a.g.ala_liveroom_player_container_view);
        this.mHandler = new Handler();
    }

    private Bitmap drawableToBitmap(Drawable drawable) {
        Bitmap createBitmap = Bitmap.createBitmap(10, 10, drawable.getOpacity() != -1 ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, 10, 10);
        drawable.draw(canvas);
        return createBitmap;
    }

    public void e(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        int[] screenFullSize = ViewCommonUtil.getScreenFullSize(tbPageContext.getPageActivity());
        by(screenFullSize[0], screenFullSize[1]);
    }

    private void by(int i, int i2) {
        if (this.fRM != null) {
            ViewGroup.LayoutParams layoutParams = this.fRM.getLayoutParams();
            layoutParams.width = i;
            layoutParams.height = i2;
            this.fRM.setLayoutParams(layoutParams);
        }
    }

    public void bm(int i, int i2) {
        by(i, i2);
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (configuration != null) {
            int[] screenFullSize = ViewCommonUtil.getScreenFullSize(this.mPageContext.getPageActivity());
            if (this.fRQ != null && this.fRQ.getParent() != null) {
                ViewGroup.LayoutParams layoutParams = this.fRQ.getLayoutParams();
                layoutParams.width = screenFullSize[0];
                layoutParams.height = screenFullSize[1] - 0;
                this.fRQ.setLayoutParams(layoutParams);
            }
        }
    }

    public void a(AlaLiveView alaLiveView, ViewGroup.LayoutParams layoutParams) {
        if (alaLiveView != null) {
            if (this.mRootView.indexOfChild(alaLiveView) < 0 && this.mRootView.getChildCount() > 1) {
                this.fIW = alaLiveView;
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
            bAD();
        }
    }

    public void bAy() {
        if (this.fIW != null) {
            this.mRootView.removeView(this.fIW);
        }
        this.fIW = null;
    }

    @Override // com.baidu.live.o.e
    public ViewGroup getLiveContainerView() {
        return this;
    }

    public void a(View view, ViewGroup.LayoutParams layoutParams, boolean z) {
        if (this.fRN.getParent() != null) {
            this.mRootView.removeView(this.fRN);
        }
        this.mRootView.addView(this.fRN, 1);
        if (this.fRO != null && this.fRO.getParent() != null) {
            ((ViewGroup) this.fRO.getParent()).removeView(this.fRO);
        }
        this.fRO = view;
        if (this.fRO != null && this.fRO.getParent() != null) {
            ((ViewGroup) this.fRO.getParent()).removeView(this.fRO);
        }
        if (this.fRO != null) {
            if (layoutParams != null) {
                this.fRN.addView(this.fRO, layoutParams);
            } else {
                this.fRN.addView(this.fRO, this.fRO.getLayoutParams());
            }
        }
    }

    public void Hp() {
        if (this.fRN.getParent() != null) {
            ((ViewGroup) this.fRN.getParent()).removeView(this.fRN);
        }
        if (this.fRO != null && this.fRO.getParent() != null) {
            ((ViewGroup) this.fRO.getParent()).removeView(this.fRO);
        }
        this.fRO = null;
    }

    public boolean bH(View view) {
        return (this.fRN == null || this.fRN.getParent() == null || this.fRN.indexOfChild(view) < 0) ? false : true;
    }

    public void b(View view, ViewGroup.LayoutParams layoutParams) {
        if (this.fRP != null && this.mRootView.indexOfChild(this.fRP) >= 0) {
            this.mRootView.removeView(this.fRP);
        }
        this.fRP = view;
        int childCount = this.mRootView.getChildCount() - 1;
        int childCount2 = this.mRootView.getChildCount();
        int i = childCount;
        for (int i2 = 0; i2 < childCount2; i2++) {
            if (this.mRootView.getChildAt(i2).getId() == a.g.ala_live_room_close_btn_layout) {
                i = Math.max(i, i2);
            }
        }
        if (this.fRP != null) {
            this.mRootView.addView(this.fRP, i, layoutParams);
        }
        bAD();
    }

    public void bAz() {
        if (this.fRP != null) {
            this.mRootView.removeView(this.fRP);
        }
        this.fRP = null;
    }

    public void bAA() {
        if (this.fRM.getAlpha() == 1.0f) {
            this.fRM.clearAnimation();
            this.mHandler.postDelayed(this.fRT, 300L);
            return;
        }
        this.fRM.clearAnimation();
        this.fRM.setAlpha(0.0f);
        this.fRM.setVisibility(8);
    }

    public void bAB() {
        this.mHandler.removeCallbacks(this.fRT);
        this.fRM.clearAnimation();
        this.fRM.setAlpha(0.0f);
        this.fRM.setVisibility(8);
    }

    public void bAC() {
        this.mHandler.removeCallbacks(this.fRT);
        this.fRM.clearAnimation();
        this.fRM.setAlpha(1.0f);
        this.fRM.setVisibility(0);
    }

    public void setBackImageBlack(AlaLiveInfoData alaLiveInfoData) {
        if ((alaLiveInfoData == null || alaLiveInfoData.screen_direction != 2) && this.fRM != null) {
            this.fRM.setImageDrawable(null);
            this.fRM.setBackgroundColor(this.mPageContext.getResources().getColor(a.d.sdk_transparent));
        }
    }

    public void setBgImageUrl(String str, int i, AlaLiveInfoData alaLiveInfoData) {
        if (this.mPageContext != null && !TextUtils.isEmpty(str)) {
            int[] screenFullSize = ViewCommonUtil.getScreenFullSize(this.mPageContext.getPageActivity());
            by(screenFullSize[0], screenFullSize[1]);
            if (alaLiveInfoData != null && alaLiveInfoData.screen_direction == 2) {
                this.fRM.setImageBitmap(this.fRS);
            } else if (!TextUtils.isEmpty(str)) {
                this.fRM.startLoad(str, 39, false, false);
            } else {
                this.fRM.setBackgroundResource(a.f.pic_avatar_moren);
            }
        }
    }

    public void setBgImageUrl(String str, AlaLiveInfoData alaLiveInfoData) {
        setBgImageUrl(str, 10, alaLiveInfoData);
    }

    public void release() {
        if (this.fRM != null) {
            this.fRM.setImageDrawable(null);
            this.fRM.stopLoad();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (this.fIW != null && !this.fIW.fSf) {
            z = this.fIW.z(motionEvent);
        }
        if (z || motionEvent.getAction() == 0) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void kU(boolean z) {
        Context context = getContext();
        if (this.fRR == null) {
            this.fRQ = new FrameLayout(context);
            this.fRQ.setBackgroundColor(getContext().getResources().getColor(a.d.sdk_cp_cont_b));
            this.fRR = new TextView(context);
            this.fRR.setText(context.getResources().getString(a.i.ala_live_private_tip));
            this.fRR.setTextSize(0, context.getResources().getDimensionPixelSize(a.e.sdk_ds28));
            this.fRR.setTextColor(context.getResources().getColor(a.d.sdk_cp_cont_i_alpha40));
            this.fRR.setGravity(49);
            Drawable drawable = context.getResources().getDrawable(a.f.private_tip);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            this.fRR.setCompoundDrawables(null, drawable, null, null);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.topMargin = kV(z);
            layoutParams.gravity = 1;
            this.fRQ.addView(this.fRR, layoutParams);
            int indexOfChild = this.fIW != null ? this.mRootView.indexOfChild(this.fIW) : -1;
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
            int[] screenFullSize = ViewCommonUtil.getScreenFullSize(this.mPageContext.getPageActivity());
            int statusBarHeight = !UtilHelper.canUseStyleImmersiveSticky() ? UtilHelper.getStatusBarHeight() : 0;
            layoutParams2.width = screenFullSize[0];
            layoutParams2.height = screenFullSize[1] - statusBarHeight;
            if (indexOfChild < 0) {
                this.mRootView.addView(this.fRQ, layoutParams2);
            } else {
                this.mRootView.addView(this.fRQ, indexOfChild, layoutParams2);
            }
        } else {
            if (this.fRQ.getParent() != null) {
                this.mRootView.removeView(this.fRQ);
            }
            int indexOfChild2 = this.fIW != null ? this.mRootView.indexOfChild(this.fIW) : -1;
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -1);
            int[] screenFullSize2 = ViewCommonUtil.getScreenFullSize(this.mPageContext.getPageActivity());
            int statusBarHeight2 = !UtilHelper.canUseStyleImmersiveSticky() ? UtilHelper.getStatusBarHeight() : 0;
            layoutParams3.width = screenFullSize2[0];
            layoutParams3.height = screenFullSize2[1] - statusBarHeight2;
            if (indexOfChild2 < 0) {
                this.mRootView.addView(this.fRQ, layoutParams3);
            } else {
                this.mRootView.addView(this.fRQ, indexOfChild2, layoutParams3);
            }
            FrameLayout.LayoutParams layoutParams4 = (FrameLayout.LayoutParams) this.fRR.getLayoutParams();
            layoutParams4.topMargin = kV(z);
            this.fRR.setLayoutParams(layoutParams4);
        }
        this.fRQ.setVisibility(0);
        this.fRR.setVisibility(0);
        if (this.fRO != null) {
            this.fRO.setVisibility(8);
        }
        if (this.fRM != null) {
            this.fRM.setVisibility(8);
        }
    }

    public void D(int i, boolean z) {
        FrameLayout.LayoutParams layoutParams;
        if (this.fRR != null) {
            if (this.fRR.getLayoutParams() != null && (this.fRR.getLayoutParams() instanceof FrameLayout.LayoutParams)) {
                layoutParams = (FrameLayout.LayoutParams) this.fRR.getLayoutParams();
            } else {
                layoutParams = new FrameLayout.LayoutParams(-2, -2);
            }
            if (i == 2) {
                layoutParams.topMargin = getResources().getDimensionPixelSize(a.e.sdk_ds45);
                layoutParams.gravity = 1;
                this.fRR.setLayoutParams(layoutParams);
                return;
            }
            layoutParams.topMargin = kV(z);
            layoutParams.gravity = 1;
            this.fRR.setLayoutParams(layoutParams);
        }
    }

    public void bAD() {
        if (this.fRQ != null && this.fRQ.getParent() != null) {
            ((ViewGroup) this.fRQ.getParent()).removeView(this.fRQ);
        }
        if (this.fRO != null) {
            this.fRO.setVisibility(0);
        }
        if (this.fRM != null) {
            this.fRM.setVisibility(0);
        }
    }

    public boolean bAE() {
        return (this.fRQ == null || this.fRQ.getParent() == null) ? false : true;
    }

    private int kV(boolean z) {
        if (z) {
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                return UtilHelper.getStatusBarHeight();
            }
            return 0;
        }
        return this.mPageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds160);
    }

    public void bAF() {
        View findViewWithTag = findViewWithTag("AlaLivePraiseGuideController");
        if (findViewWithTag != null) {
            removeView(findViewWithTag);
        }
    }
}
