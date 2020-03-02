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
public class AlaLiveRoomBlurPageLayout extends FrameLayout implements com.baidu.live.o.d {
    Runnable akS;
    private AlaLiveView fec;
    private TbImageView fmL;
    private FrameLayout fmM;
    private View fmN;
    private View fmO;
    private FrameLayout fmP;
    private TextView fmQ;
    private Bitmap fmR;
    private Handler mHandler;
    private TbPageContext mPageContext;
    private ViewGroup mRootView;

    public AlaLiveRoomBlurPageLayout(Context context) {
        super(context);
        this.fmL = null;
        this.fmN = null;
        this.fec = null;
        this.fmO = null;
        this.fmP = null;
        this.fmQ = null;
        this.akS = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveRoomBlurPageLayout.1
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
                        AlaLiveRoomBlurPageLayout.this.fmL.setAlpha(0.0f);
                        AlaLiveRoomBlurPageLayout.this.fmL.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                AlaLiveRoomBlurPageLayout.this.fmL.clearAnimation();
                AlaLiveRoomBlurPageLayout.this.fmL.startAnimation(alphaAnimation);
            }
        };
        init();
    }

    public AlaLiveRoomBlurPageLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fmL = null;
        this.fmN = null;
        this.fec = null;
        this.fmO = null;
        this.fmP = null;
        this.fmQ = null;
        this.akS = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveRoomBlurPageLayout.1
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
                        AlaLiveRoomBlurPageLayout.this.fmL.setAlpha(0.0f);
                        AlaLiveRoomBlurPageLayout.this.fmL.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                AlaLiveRoomBlurPageLayout.this.fmL.clearAnimation();
                AlaLiveRoomBlurPageLayout.this.fmL.startAnimation(alphaAnimation);
            }
        };
        init();
    }

    public AlaLiveRoomBlurPageLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fmL = null;
        this.fmN = null;
        this.fec = null;
        this.fmO = null;
        this.fmP = null;
        this.fmQ = null;
        this.akS = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveRoomBlurPageLayout.1
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
                        AlaLiveRoomBlurPageLayout.this.fmL.setAlpha(0.0f);
                        AlaLiveRoomBlurPageLayout.this.fmL.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                AlaLiveRoomBlurPageLayout.this.fmL.clearAnimation();
                AlaLiveRoomBlurPageLayout.this.fmL.startAnimation(alphaAnimation);
            }
        };
        init();
    }

    private void init() {
        Log.i("LiveRoomBlurPageLayout", "@@ context = " + getContext());
        this.mRootView = (ViewGroup) View.inflate(getContext(), a.h.ala_liveroom_audience_blur_layout, this);
        setClipChildren(false);
        this.fmL = (TbImageView) findViewById(a.g.ala_liveroom_background_img);
        this.fmR = drawableToBitmap(new ColorDrawable(getResources().getColor(a.d.sdk_color_333333)));
        this.fmM = new FrameLayout(getContext());
        this.fmM.setId(a.g.ala_liveroom_player_container_view);
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
        bs(screenFullSize[0], screenFullSize[1]);
    }

    private void bs(int i, int i2) {
        if (this.fmL != null) {
            ViewGroup.LayoutParams layoutParams = this.fmL.getLayoutParams();
            layoutParams.width = i;
            layoutParams.height = i2;
            this.fmL.setLayoutParams(layoutParams);
        }
    }

    public void bg(int i, int i2) {
        bs(i, i2);
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (configuration != null) {
            int[] screenFullSize = ViewCommonUtil.getScreenFullSize(this.mPageContext.getPageActivity());
            if (this.fmP != null && this.fmP.getParent() != null) {
                ViewGroup.LayoutParams layoutParams = this.fmP.getLayoutParams();
                layoutParams.width = screenFullSize[0];
                layoutParams.height = screenFullSize[1] - 0;
                this.fmP.setLayoutParams(layoutParams);
            }
        }
    }

    public void a(AlaLiveView alaLiveView, ViewGroup.LayoutParams layoutParams) {
        if (alaLiveView != null) {
            if (this.mRootView.indexOfChild(alaLiveView) < 0 && this.mRootView.getChildCount() > 1) {
                this.fec = alaLiveView;
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
            bqX();
        }
    }

    public void bqS() {
        if (this.fec != null) {
            this.mRootView.removeView(this.fec);
        }
        this.fec = null;
    }

    @Override // com.baidu.live.o.d
    public ViewGroup getLiveContainerView() {
        return this;
    }

    public void a(View view, ViewGroup.LayoutParams layoutParams, boolean z) {
        if (this.fmM.getParent() != null) {
            this.mRootView.removeView(this.fmM);
        }
        this.mRootView.addView(this.fmM, 1);
        if (this.fmN != null && this.fmN.getParent() != null) {
            ((ViewGroup) this.fmN.getParent()).removeView(this.fmN);
        }
        this.fmN = view;
        if (this.fmN != null && this.fmN.getParent() != null) {
            ((ViewGroup) this.fmN.getParent()).removeView(this.fmN);
        }
        if (this.fmN != null) {
            if (layoutParams != null) {
                this.fmM.addView(this.fmN, layoutParams);
            } else {
                this.fmM.addView(this.fmN, this.fmN.getLayoutParams());
            }
        }
    }

    public void blN() {
        if (this.fmM.getParent() != null) {
            ((ViewGroup) this.fmM.getParent()).removeView(this.fmM);
        }
        if (this.fmN != null && this.fmN.getParent() != null) {
            ((ViewGroup) this.fmN.getParent()).removeView(this.fmN);
        }
        this.fmN = null;
    }

    public boolean bC(View view) {
        return (this.fmM == null || this.fmM.getParent() == null || this.fmM.indexOfChild(view) < 0) ? false : true;
    }

    public void b(View view, ViewGroup.LayoutParams layoutParams) {
        if (this.fmO != null && this.mRootView.indexOfChild(this.fmO) >= 0) {
            this.mRootView.removeView(this.fmO);
        }
        this.fmO = view;
        int childCount = this.mRootView.getChildCount() - 1;
        int childCount2 = this.mRootView.getChildCount();
        int i = childCount;
        for (int i2 = 0; i2 < childCount2; i2++) {
            if (this.mRootView.getChildAt(i2).getId() == a.g.ala_live_room_close_btn_layout) {
                i = Math.max(i, i2);
            }
        }
        if (this.fmO != null) {
            this.mRootView.addView(this.fmO, i, layoutParams);
        }
        bqX();
    }

    public void bqT() {
        if (this.fmO != null) {
            this.mRootView.removeView(this.fmO);
        }
        this.fmO = null;
    }

    public void bqU() {
        if (this.fmL.getAlpha() == 1.0f) {
            this.fmL.clearAnimation();
            this.mHandler.postDelayed(this.akS, 300L);
            return;
        }
        this.fmL.clearAnimation();
        this.fmL.setAlpha(0.0f);
        this.fmL.setVisibility(8);
    }

    public void bqV() {
        this.mHandler.removeCallbacks(this.akS);
        this.fmL.clearAnimation();
        this.fmL.setAlpha(0.0f);
        this.fmL.setVisibility(8);
    }

    public void bqW() {
        this.mHandler.removeCallbacks(this.akS);
        this.fmL.clearAnimation();
        this.fmL.setAlpha(1.0f);
        this.fmL.setVisibility(0);
    }

    public void setBackImageBlack(AlaLiveInfoData alaLiveInfoData) {
        if ((alaLiveInfoData == null || alaLiveInfoData.screen_direction != 2) && this.fmL != null) {
            this.fmL.setImageDrawable(null);
            this.fmL.setBackgroundColor(this.mPageContext.getResources().getColor(a.d.sdk_transparent));
        }
    }

    public void setBgImageUrl(String str, int i, AlaLiveInfoData alaLiveInfoData) {
        if (this.mPageContext != null && !TextUtils.isEmpty(str)) {
            int[] screenFullSize = ViewCommonUtil.getScreenFullSize(this.mPageContext.getPageActivity());
            bs(screenFullSize[0], screenFullSize[1]);
            if (alaLiveInfoData != null && alaLiveInfoData.screen_direction == 2) {
                this.fmL.setImageBitmap(this.fmR);
            } else if (!TextUtils.isEmpty(str)) {
                this.fmL.startLoad(str, 39, false, false);
            } else {
                this.fmL.setBackgroundResource(a.f.pic_avatar_moren);
            }
        }
    }

    public void setBgImageUrl(String str, AlaLiveInfoData alaLiveInfoData) {
        setBgImageUrl(str, 10, alaLiveInfoData);
    }

    public void release() {
        if (this.fmL != null) {
            this.fmL.setImageDrawable(null);
            this.fmL.stopLoad();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (this.fec != null && !this.fec.isDestroy) {
            z = this.fec.z(motionEvent);
        }
        if (z || motionEvent.getAction() == 0) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void jO(boolean z) {
        Context context = getContext();
        if (this.fmQ == null) {
            this.fmP = new FrameLayout(context);
            this.fmP.setBackgroundColor(getContext().getResources().getColor(a.d.sdk_cp_cont_b));
            this.fmQ = new TextView(context);
            this.fmQ.setText(context.getResources().getString(a.i.ala_live_private_tip));
            this.fmQ.setTextSize(0, context.getResources().getDimensionPixelSize(a.e.sdk_ds28));
            this.fmQ.setTextColor(context.getResources().getColor(a.d.sdk_cp_cont_i_alpha40));
            this.fmQ.setGravity(49);
            Drawable drawable = context.getResources().getDrawable(a.f.private_tip);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            this.fmQ.setCompoundDrawables(null, drawable, null, null);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.topMargin = jP(z);
            layoutParams.gravity = 1;
            this.fmP.addView(this.fmQ, layoutParams);
            int indexOfChild = this.fec != null ? this.mRootView.indexOfChild(this.fec) : -1;
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
            int[] screenFullSize = ViewCommonUtil.getScreenFullSize(this.mPageContext.getPageActivity());
            int statusBarHeight = !UtilHelper.canUseStyleImmersiveSticky() ? UtilHelper.getStatusBarHeight() : 0;
            layoutParams2.width = screenFullSize[0];
            layoutParams2.height = screenFullSize[1] - statusBarHeight;
            if (indexOfChild < 0) {
                this.mRootView.addView(this.fmP, layoutParams2);
            } else {
                this.mRootView.addView(this.fmP, indexOfChild, layoutParams2);
            }
        } else {
            if (this.fmP.getParent() != null) {
                this.mRootView.removeView(this.fmP);
            }
            int indexOfChild2 = this.fec != null ? this.mRootView.indexOfChild(this.fec) : -1;
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -1);
            int[] screenFullSize2 = ViewCommonUtil.getScreenFullSize(this.mPageContext.getPageActivity());
            int statusBarHeight2 = !UtilHelper.canUseStyleImmersiveSticky() ? UtilHelper.getStatusBarHeight() : 0;
            layoutParams3.width = screenFullSize2[0];
            layoutParams3.height = screenFullSize2[1] - statusBarHeight2;
            if (indexOfChild2 < 0) {
                this.mRootView.addView(this.fmP, layoutParams3);
            } else {
                this.mRootView.addView(this.fmP, indexOfChild2, layoutParams3);
            }
            FrameLayout.LayoutParams layoutParams4 = (FrameLayout.LayoutParams) this.fmQ.getLayoutParams();
            layoutParams4.topMargin = jP(z);
            this.fmQ.setLayoutParams(layoutParams4);
        }
        this.fmP.setVisibility(0);
        this.fmQ.setVisibility(0);
        if (this.fmN != null) {
            this.fmN.setVisibility(8);
        }
        if (this.fmL != null) {
            this.fmL.setVisibility(8);
        }
    }

    public void A(int i, boolean z) {
        FrameLayout.LayoutParams layoutParams;
        if (this.fmQ != null) {
            if (this.fmQ.getLayoutParams() != null && (this.fmQ.getLayoutParams() instanceof FrameLayout.LayoutParams)) {
                layoutParams = (FrameLayout.LayoutParams) this.fmQ.getLayoutParams();
            } else {
                layoutParams = new FrameLayout.LayoutParams(-2, -2);
            }
            if (i == 2) {
                layoutParams.topMargin = getResources().getDimensionPixelSize(a.e.sdk_ds45);
                layoutParams.gravity = 1;
                this.fmQ.setLayoutParams(layoutParams);
                return;
            }
            layoutParams.topMargin = jP(z);
            layoutParams.gravity = 1;
            this.fmQ.setLayoutParams(layoutParams);
        }
    }

    public void bqX() {
        if (this.fmP != null && this.fmP.getParent() != null) {
            ((ViewGroup) this.fmP.getParent()).removeView(this.fmP);
        }
        if (this.fmN != null) {
            this.fmN.setVisibility(0);
        }
        if (this.fmL != null) {
            this.fmL.setVisibility(0);
        }
    }

    public boolean bqY() {
        return (this.fmP == null || this.fmP.getParent() == null) ? false : true;
    }

    private int jP(boolean z) {
        if (z) {
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                return UtilHelper.getStatusBarHeight();
            }
            return 0;
        }
        return this.mPageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds160);
    }

    public void bqZ() {
        View findViewWithTag = findViewWithTag("AlaLivePraiseGuideController");
        if (findViewWithTag != null) {
            removeView(findViewWithTag);
        }
    }
}
