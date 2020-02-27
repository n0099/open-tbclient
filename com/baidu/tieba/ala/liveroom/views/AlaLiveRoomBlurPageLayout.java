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
public class AlaLiveRoomBlurPageLayout extends FrameLayout implements com.baidu.live.o.b {
    Runnable akS;
    private AlaLiveView feb;
    private TbImageView fmK;
    private FrameLayout fmL;
    private View fmM;
    private View fmN;
    private FrameLayout fmO;
    private TextView fmP;
    private Bitmap fmQ;
    private Handler mHandler;
    private TbPageContext mPageContext;
    private ViewGroup mRootView;

    public AlaLiveRoomBlurPageLayout(Context context) {
        super(context);
        this.fmK = null;
        this.fmM = null;
        this.feb = null;
        this.fmN = null;
        this.fmO = null;
        this.fmP = null;
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
                        AlaLiveRoomBlurPageLayout.this.fmK.setAlpha(0.0f);
                        AlaLiveRoomBlurPageLayout.this.fmK.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                AlaLiveRoomBlurPageLayout.this.fmK.clearAnimation();
                AlaLiveRoomBlurPageLayout.this.fmK.startAnimation(alphaAnimation);
            }
        };
        init();
    }

    public AlaLiveRoomBlurPageLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fmK = null;
        this.fmM = null;
        this.feb = null;
        this.fmN = null;
        this.fmO = null;
        this.fmP = null;
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
                        AlaLiveRoomBlurPageLayout.this.fmK.setAlpha(0.0f);
                        AlaLiveRoomBlurPageLayout.this.fmK.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                AlaLiveRoomBlurPageLayout.this.fmK.clearAnimation();
                AlaLiveRoomBlurPageLayout.this.fmK.startAnimation(alphaAnimation);
            }
        };
        init();
    }

    public AlaLiveRoomBlurPageLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fmK = null;
        this.fmM = null;
        this.feb = null;
        this.fmN = null;
        this.fmO = null;
        this.fmP = null;
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
                        AlaLiveRoomBlurPageLayout.this.fmK.setAlpha(0.0f);
                        AlaLiveRoomBlurPageLayout.this.fmK.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                AlaLiveRoomBlurPageLayout.this.fmK.clearAnimation();
                AlaLiveRoomBlurPageLayout.this.fmK.startAnimation(alphaAnimation);
            }
        };
        init();
    }

    private void init() {
        Log.i("LiveRoomBlurPageLayout", "@@ context = " + getContext());
        this.mRootView = (ViewGroup) View.inflate(getContext(), a.h.ala_liveroom_audience_blur_layout, this);
        setClipChildren(false);
        this.fmK = (TbImageView) findViewById(a.g.ala_liveroom_background_img);
        this.fmQ = drawableToBitmap(new ColorDrawable(getResources().getColor(a.d.sdk_color_333333)));
        this.fmL = new FrameLayout(getContext());
        this.fmL.setId(a.g.ala_liveroom_player_container_view);
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
        if (this.fmK != null) {
            ViewGroup.LayoutParams layoutParams = this.fmK.getLayoutParams();
            layoutParams.width = i;
            layoutParams.height = i2;
            this.fmK.setLayoutParams(layoutParams);
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
            if (this.fmO != null && this.fmO.getParent() != null) {
                ViewGroup.LayoutParams layoutParams = this.fmO.getLayoutParams();
                layoutParams.width = screenFullSize[0];
                layoutParams.height = screenFullSize[1] - 0;
                this.fmO.setLayoutParams(layoutParams);
            }
        }
    }

    public void a(AlaLiveView alaLiveView, ViewGroup.LayoutParams layoutParams) {
        if (alaLiveView != null) {
            if (this.mRootView.indexOfChild(alaLiveView) < 0 && this.mRootView.getChildCount() > 1) {
                this.feb = alaLiveView;
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
            bqV();
        }
    }

    public void bqQ() {
        if (this.feb != null) {
            this.mRootView.removeView(this.feb);
        }
        this.feb = null;
    }

    @Override // com.baidu.live.o.b
    public ViewGroup getLiveContainerView() {
        return this;
    }

    public void a(View view, ViewGroup.LayoutParams layoutParams, boolean z) {
        if (this.fmL.getParent() != null) {
            this.mRootView.removeView(this.fmL);
        }
        this.mRootView.addView(this.fmL, 1);
        if (this.fmM != null && this.fmM.getParent() != null) {
            ((ViewGroup) this.fmM.getParent()).removeView(this.fmM);
        }
        this.fmM = view;
        if (this.fmM != null && this.fmM.getParent() != null) {
            ((ViewGroup) this.fmM.getParent()).removeView(this.fmM);
        }
        if (this.fmM != null) {
            if (layoutParams != null) {
                this.fmL.addView(this.fmM, layoutParams);
            } else {
                this.fmL.addView(this.fmM, this.fmM.getLayoutParams());
            }
        }
    }

    public void blL() {
        if (this.fmL.getParent() != null) {
            ((ViewGroup) this.fmL.getParent()).removeView(this.fmL);
        }
        if (this.fmM != null && this.fmM.getParent() != null) {
            ((ViewGroup) this.fmM.getParent()).removeView(this.fmM);
        }
        this.fmM = null;
    }

    public boolean bC(View view) {
        return (this.fmL == null || this.fmL.getParent() == null || this.fmL.indexOfChild(view) < 0) ? false : true;
    }

    public void b(View view, ViewGroup.LayoutParams layoutParams) {
        if (this.fmN != null && this.mRootView.indexOfChild(this.fmN) >= 0) {
            this.mRootView.removeView(this.fmN);
        }
        this.fmN = view;
        int childCount = this.mRootView.getChildCount() - 1;
        int childCount2 = this.mRootView.getChildCount();
        int i = childCount;
        for (int i2 = 0; i2 < childCount2; i2++) {
            if (this.mRootView.getChildAt(i2).getId() == a.g.ala_live_room_close_btn_layout) {
                i = Math.max(i, i2);
            }
        }
        if (this.fmN != null) {
            this.mRootView.addView(this.fmN, i, layoutParams);
        }
        bqV();
    }

    public void bqR() {
        if (this.fmN != null) {
            this.mRootView.removeView(this.fmN);
        }
        this.fmN = null;
    }

    public void bqS() {
        if (this.fmK.getAlpha() == 1.0f) {
            this.fmK.clearAnimation();
            this.mHandler.postDelayed(this.akS, 300L);
            return;
        }
        this.fmK.clearAnimation();
        this.fmK.setAlpha(0.0f);
        this.fmK.setVisibility(8);
    }

    public void bqT() {
        this.mHandler.removeCallbacks(this.akS);
        this.fmK.clearAnimation();
        this.fmK.setAlpha(0.0f);
        this.fmK.setVisibility(8);
    }

    public void bqU() {
        this.mHandler.removeCallbacks(this.akS);
        this.fmK.clearAnimation();
        this.fmK.setAlpha(1.0f);
        this.fmK.setVisibility(0);
    }

    public void setBackImageBlack(AlaLiveInfoData alaLiveInfoData) {
        if ((alaLiveInfoData == null || alaLiveInfoData.screen_direction != 2) && this.fmK != null) {
            this.fmK.setImageDrawable(null);
            this.fmK.setBackgroundColor(this.mPageContext.getResources().getColor(a.d.sdk_transparent));
        }
    }

    public void setBgImageUrl(String str, int i, AlaLiveInfoData alaLiveInfoData) {
        if (this.mPageContext != null && !TextUtils.isEmpty(str)) {
            int[] screenFullSize = ViewCommonUtil.getScreenFullSize(this.mPageContext.getPageActivity());
            bs(screenFullSize[0], screenFullSize[1]);
            if (alaLiveInfoData != null && alaLiveInfoData.screen_direction == 2) {
                this.fmK.setImageBitmap(this.fmQ);
            } else if (!TextUtils.isEmpty(str)) {
                this.fmK.startLoad(str, 39, false, false);
            } else {
                this.fmK.setBackgroundResource(a.f.pic_avatar_moren);
            }
        }
    }

    public void setBgImageUrl(String str, AlaLiveInfoData alaLiveInfoData) {
        setBgImageUrl(str, 10, alaLiveInfoData);
    }

    public void release() {
        if (this.fmK != null) {
            this.fmK.setImageDrawable(null);
            this.fmK.stopLoad();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (this.feb != null && !this.feb.isDestroy) {
            z = this.feb.z(motionEvent);
        }
        if (z || motionEvent.getAction() == 0) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void jO(boolean z) {
        Context context = getContext();
        if (this.fmP == null) {
            this.fmO = new FrameLayout(context);
            this.fmO.setBackgroundColor(getContext().getResources().getColor(a.d.sdk_cp_cont_b));
            this.fmP = new TextView(context);
            this.fmP.setText(context.getResources().getString(a.i.ala_live_private_tip));
            this.fmP.setTextSize(0, context.getResources().getDimensionPixelSize(a.e.sdk_ds28));
            this.fmP.setTextColor(context.getResources().getColor(a.d.sdk_cp_cont_i_alpha40));
            this.fmP.setGravity(49);
            Drawable drawable = context.getResources().getDrawable(a.f.private_tip);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            this.fmP.setCompoundDrawables(null, drawable, null, null);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.topMargin = jP(z);
            layoutParams.gravity = 1;
            this.fmO.addView(this.fmP, layoutParams);
            int indexOfChild = this.feb != null ? this.mRootView.indexOfChild(this.feb) : -1;
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
            int[] screenFullSize = ViewCommonUtil.getScreenFullSize(this.mPageContext.getPageActivity());
            int statusBarHeight = !UtilHelper.canUseStyleImmersiveSticky() ? UtilHelper.getStatusBarHeight() : 0;
            layoutParams2.width = screenFullSize[0];
            layoutParams2.height = screenFullSize[1] - statusBarHeight;
            if (indexOfChild < 0) {
                this.mRootView.addView(this.fmO, layoutParams2);
            } else {
                this.mRootView.addView(this.fmO, indexOfChild, layoutParams2);
            }
        } else {
            if (this.fmO.getParent() != null) {
                this.mRootView.removeView(this.fmO);
            }
            int indexOfChild2 = this.feb != null ? this.mRootView.indexOfChild(this.feb) : -1;
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -1);
            int[] screenFullSize2 = ViewCommonUtil.getScreenFullSize(this.mPageContext.getPageActivity());
            int statusBarHeight2 = !UtilHelper.canUseStyleImmersiveSticky() ? UtilHelper.getStatusBarHeight() : 0;
            layoutParams3.width = screenFullSize2[0];
            layoutParams3.height = screenFullSize2[1] - statusBarHeight2;
            if (indexOfChild2 < 0) {
                this.mRootView.addView(this.fmO, layoutParams3);
            } else {
                this.mRootView.addView(this.fmO, indexOfChild2, layoutParams3);
            }
            FrameLayout.LayoutParams layoutParams4 = (FrameLayout.LayoutParams) this.fmP.getLayoutParams();
            layoutParams4.topMargin = jP(z);
            this.fmP.setLayoutParams(layoutParams4);
        }
        this.fmO.setVisibility(0);
        this.fmP.setVisibility(0);
        if (this.fmM != null) {
            this.fmM.setVisibility(8);
        }
        if (this.fmK != null) {
            this.fmK.setVisibility(8);
        }
    }

    public void A(int i, boolean z) {
        FrameLayout.LayoutParams layoutParams;
        if (this.fmP != null) {
            if (this.fmP.getLayoutParams() != null && (this.fmP.getLayoutParams() instanceof FrameLayout.LayoutParams)) {
                layoutParams = (FrameLayout.LayoutParams) this.fmP.getLayoutParams();
            } else {
                layoutParams = new FrameLayout.LayoutParams(-2, -2);
            }
            if (i == 2) {
                layoutParams.topMargin = getResources().getDimensionPixelSize(a.e.sdk_ds45);
                layoutParams.gravity = 1;
                this.fmP.setLayoutParams(layoutParams);
                return;
            }
            layoutParams.topMargin = jP(z);
            layoutParams.gravity = 1;
            this.fmP.setLayoutParams(layoutParams);
        }
    }

    public void bqV() {
        if (this.fmO != null && this.fmO.getParent() != null) {
            ((ViewGroup) this.fmO.getParent()).removeView(this.fmO);
        }
        if (this.fmM != null) {
            this.fmM.setVisibility(0);
        }
        if (this.fmK != null) {
            this.fmK.setVisibility(0);
        }
    }

    public boolean bqW() {
        return (this.fmO == null || this.fmO.getParent() == null) ? false : true;
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

    public void bqX() {
        View findViewWithTag = findViewWithTag("AlaLivePraiseGuideController");
        if (findViewWithTag != null) {
            removeView(findViewWithTag);
        }
    }
}
