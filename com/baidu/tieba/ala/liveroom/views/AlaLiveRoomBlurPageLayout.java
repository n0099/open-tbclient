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
    Runnable ald;
    private AlaLiveView feO;
    private View fnA;
    private FrameLayout fnB;
    private TextView fnC;
    private Bitmap fnD;
    private TbImageView fnx;
    private FrameLayout fny;
    private View fnz;
    private Handler mHandler;
    private TbPageContext mPageContext;
    private ViewGroup mRootView;

    public AlaLiveRoomBlurPageLayout(Context context) {
        super(context);
        this.fnx = null;
        this.fnz = null;
        this.feO = null;
        this.fnA = null;
        this.fnB = null;
        this.fnC = null;
        this.ald = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveRoomBlurPageLayout.1
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
                        AlaLiveRoomBlurPageLayout.this.fnx.setAlpha(0.0f);
                        AlaLiveRoomBlurPageLayout.this.fnx.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                AlaLiveRoomBlurPageLayout.this.fnx.clearAnimation();
                AlaLiveRoomBlurPageLayout.this.fnx.startAnimation(alphaAnimation);
            }
        };
        init();
    }

    public AlaLiveRoomBlurPageLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fnx = null;
        this.fnz = null;
        this.feO = null;
        this.fnA = null;
        this.fnB = null;
        this.fnC = null;
        this.ald = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveRoomBlurPageLayout.1
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
                        AlaLiveRoomBlurPageLayout.this.fnx.setAlpha(0.0f);
                        AlaLiveRoomBlurPageLayout.this.fnx.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                AlaLiveRoomBlurPageLayout.this.fnx.clearAnimation();
                AlaLiveRoomBlurPageLayout.this.fnx.startAnimation(alphaAnimation);
            }
        };
        init();
    }

    public AlaLiveRoomBlurPageLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fnx = null;
        this.fnz = null;
        this.feO = null;
        this.fnA = null;
        this.fnB = null;
        this.fnC = null;
        this.ald = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveRoomBlurPageLayout.1
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
                        AlaLiveRoomBlurPageLayout.this.fnx.setAlpha(0.0f);
                        AlaLiveRoomBlurPageLayout.this.fnx.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                AlaLiveRoomBlurPageLayout.this.fnx.clearAnimation();
                AlaLiveRoomBlurPageLayout.this.fnx.startAnimation(alphaAnimation);
            }
        };
        init();
    }

    private void init() {
        Log.i("LiveRoomBlurPageLayout", "@@ context = " + getContext());
        this.mRootView = (ViewGroup) View.inflate(getContext(), a.h.ala_liveroom_audience_blur_layout, this);
        setClipChildren(false);
        this.fnx = (TbImageView) findViewById(a.g.ala_liveroom_background_img);
        this.fnD = drawableToBitmap(new ColorDrawable(getResources().getColor(a.d.sdk_color_333333)));
        this.fny = new FrameLayout(getContext());
        this.fny.setId(a.g.ala_liveroom_player_container_view);
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
        bt(screenFullSize[0], screenFullSize[1]);
    }

    private void bt(int i, int i2) {
        if (this.fnx != null) {
            ViewGroup.LayoutParams layoutParams = this.fnx.getLayoutParams();
            layoutParams.width = i;
            layoutParams.height = i2;
            this.fnx.setLayoutParams(layoutParams);
        }
    }

    public void bh(int i, int i2) {
        bt(i, i2);
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (configuration != null) {
            int[] screenFullSize = ViewCommonUtil.getScreenFullSize(this.mPageContext.getPageActivity());
            if (this.fnB != null && this.fnB.getParent() != null) {
                ViewGroup.LayoutParams layoutParams = this.fnB.getLayoutParams();
                layoutParams.width = screenFullSize[0];
                layoutParams.height = screenFullSize[1] - 0;
                this.fnB.setLayoutParams(layoutParams);
            }
        }
    }

    public void a(AlaLiveView alaLiveView, ViewGroup.LayoutParams layoutParams) {
        if (alaLiveView != null) {
            if (this.mRootView.indexOfChild(alaLiveView) < 0 && this.mRootView.getChildCount() > 1) {
                this.feO = alaLiveView;
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
            brd();
        }
    }

    public void bqY() {
        if (this.feO != null) {
            this.mRootView.removeView(this.feO);
        }
        this.feO = null;
    }

    @Override // com.baidu.live.o.e
    public ViewGroup getLiveContainerView() {
        return this;
    }

    public void a(View view, ViewGroup.LayoutParams layoutParams, boolean z) {
        if (this.fny.getParent() != null) {
            this.mRootView.removeView(this.fny);
        }
        this.mRootView.addView(this.fny, 1);
        if (this.fnz != null && this.fnz.getParent() != null) {
            ((ViewGroup) this.fnz.getParent()).removeView(this.fnz);
        }
        this.fnz = view;
        if (this.fnz != null && this.fnz.getParent() != null) {
            ((ViewGroup) this.fnz.getParent()).removeView(this.fnz);
        }
        if (this.fnz != null) {
            if (layoutParams != null) {
                this.fny.addView(this.fnz, layoutParams);
            } else {
                this.fny.addView(this.fnz, this.fnz.getLayoutParams());
            }
        }
    }

    public void blT() {
        if (this.fny.getParent() != null) {
            ((ViewGroup) this.fny.getParent()).removeView(this.fny);
        }
        if (this.fnz != null && this.fnz.getParent() != null) {
            ((ViewGroup) this.fnz.getParent()).removeView(this.fnz);
        }
        this.fnz = null;
    }

    public boolean bC(View view) {
        return (this.fny == null || this.fny.getParent() == null || this.fny.indexOfChild(view) < 0) ? false : true;
    }

    public void b(View view, ViewGroup.LayoutParams layoutParams) {
        if (this.fnA != null && this.mRootView.indexOfChild(this.fnA) >= 0) {
            this.mRootView.removeView(this.fnA);
        }
        this.fnA = view;
        int childCount = this.mRootView.getChildCount() - 1;
        int childCount2 = this.mRootView.getChildCount();
        int i = childCount;
        for (int i2 = 0; i2 < childCount2; i2++) {
            if (this.mRootView.getChildAt(i2).getId() == a.g.ala_live_room_close_btn_layout) {
                i = Math.max(i, i2);
            }
        }
        if (this.fnA != null) {
            this.mRootView.addView(this.fnA, i, layoutParams);
        }
        brd();
    }

    public void bqZ() {
        if (this.fnA != null) {
            this.mRootView.removeView(this.fnA);
        }
        this.fnA = null;
    }

    public void bra() {
        if (this.fnx.getAlpha() == 1.0f) {
            this.fnx.clearAnimation();
            this.mHandler.postDelayed(this.ald, 300L);
            return;
        }
        this.fnx.clearAnimation();
        this.fnx.setAlpha(0.0f);
        this.fnx.setVisibility(8);
    }

    public void brb() {
        this.mHandler.removeCallbacks(this.ald);
        this.fnx.clearAnimation();
        this.fnx.setAlpha(0.0f);
        this.fnx.setVisibility(8);
    }

    public void brc() {
        this.mHandler.removeCallbacks(this.ald);
        this.fnx.clearAnimation();
        this.fnx.setAlpha(1.0f);
        this.fnx.setVisibility(0);
    }

    public void setBackImageBlack(AlaLiveInfoData alaLiveInfoData) {
        if ((alaLiveInfoData == null || alaLiveInfoData.screen_direction != 2) && this.fnx != null) {
            this.fnx.setImageDrawable(null);
            this.fnx.setBackgroundColor(this.mPageContext.getResources().getColor(a.d.sdk_transparent));
        }
    }

    public void setBgImageUrl(String str, int i, AlaLiveInfoData alaLiveInfoData) {
        if (this.mPageContext != null && !TextUtils.isEmpty(str)) {
            int[] screenFullSize = ViewCommonUtil.getScreenFullSize(this.mPageContext.getPageActivity());
            bt(screenFullSize[0], screenFullSize[1]);
            if (alaLiveInfoData != null && alaLiveInfoData.screen_direction == 2) {
                this.fnx.setImageBitmap(this.fnD);
            } else if (!TextUtils.isEmpty(str)) {
                this.fnx.startLoad(str, 39, false, false);
            } else {
                this.fnx.setBackgroundResource(a.f.pic_avatar_moren);
            }
        }
    }

    public void setBgImageUrl(String str, AlaLiveInfoData alaLiveInfoData) {
        setBgImageUrl(str, 10, alaLiveInfoData);
    }

    public void release() {
        if (this.fnx != null) {
            this.fnx.setImageDrawable(null);
            this.fnx.stopLoad();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (this.feO != null && !this.feO.isDestroy) {
            z = this.feO.z(motionEvent);
        }
        if (z || motionEvent.getAction() == 0) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void jQ(boolean z) {
        Context context = getContext();
        if (this.fnC == null) {
            this.fnB = new FrameLayout(context);
            this.fnB.setBackgroundColor(getContext().getResources().getColor(a.d.sdk_cp_cont_b));
            this.fnC = new TextView(context);
            this.fnC.setText(context.getResources().getString(a.i.ala_live_private_tip));
            this.fnC.setTextSize(0, context.getResources().getDimensionPixelSize(a.e.sdk_ds28));
            this.fnC.setTextColor(context.getResources().getColor(a.d.sdk_cp_cont_i_alpha40));
            this.fnC.setGravity(49);
            Drawable drawable = context.getResources().getDrawable(a.f.private_tip);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            this.fnC.setCompoundDrawables(null, drawable, null, null);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.topMargin = jR(z);
            layoutParams.gravity = 1;
            this.fnB.addView(this.fnC, layoutParams);
            int indexOfChild = this.feO != null ? this.mRootView.indexOfChild(this.feO) : -1;
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
            int[] screenFullSize = ViewCommonUtil.getScreenFullSize(this.mPageContext.getPageActivity());
            int statusBarHeight = !UtilHelper.canUseStyleImmersiveSticky() ? UtilHelper.getStatusBarHeight() : 0;
            layoutParams2.width = screenFullSize[0];
            layoutParams2.height = screenFullSize[1] - statusBarHeight;
            if (indexOfChild < 0) {
                this.mRootView.addView(this.fnB, layoutParams2);
            } else {
                this.mRootView.addView(this.fnB, indexOfChild, layoutParams2);
            }
        } else {
            if (this.fnB.getParent() != null) {
                this.mRootView.removeView(this.fnB);
            }
            int indexOfChild2 = this.feO != null ? this.mRootView.indexOfChild(this.feO) : -1;
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -1);
            int[] screenFullSize2 = ViewCommonUtil.getScreenFullSize(this.mPageContext.getPageActivity());
            int statusBarHeight2 = !UtilHelper.canUseStyleImmersiveSticky() ? UtilHelper.getStatusBarHeight() : 0;
            layoutParams3.width = screenFullSize2[0];
            layoutParams3.height = screenFullSize2[1] - statusBarHeight2;
            if (indexOfChild2 < 0) {
                this.mRootView.addView(this.fnB, layoutParams3);
            } else {
                this.mRootView.addView(this.fnB, indexOfChild2, layoutParams3);
            }
            FrameLayout.LayoutParams layoutParams4 = (FrameLayout.LayoutParams) this.fnC.getLayoutParams();
            layoutParams4.topMargin = jR(z);
            this.fnC.setLayoutParams(layoutParams4);
        }
        this.fnB.setVisibility(0);
        this.fnC.setVisibility(0);
        if (this.fnz != null) {
            this.fnz.setVisibility(8);
        }
        if (this.fnx != null) {
            this.fnx.setVisibility(8);
        }
    }

    public void A(int i, boolean z) {
        FrameLayout.LayoutParams layoutParams;
        if (this.fnC != null) {
            if (this.fnC.getLayoutParams() != null && (this.fnC.getLayoutParams() instanceof FrameLayout.LayoutParams)) {
                layoutParams = (FrameLayout.LayoutParams) this.fnC.getLayoutParams();
            } else {
                layoutParams = new FrameLayout.LayoutParams(-2, -2);
            }
            if (i == 2) {
                layoutParams.topMargin = getResources().getDimensionPixelSize(a.e.sdk_ds45);
                layoutParams.gravity = 1;
                this.fnC.setLayoutParams(layoutParams);
                return;
            }
            layoutParams.topMargin = jR(z);
            layoutParams.gravity = 1;
            this.fnC.setLayoutParams(layoutParams);
        }
    }

    public void brd() {
        if (this.fnB != null && this.fnB.getParent() != null) {
            ((ViewGroup) this.fnB.getParent()).removeView(this.fnB);
        }
        if (this.fnz != null) {
            this.fnz.setVisibility(0);
        }
        if (this.fnx != null) {
            this.fnx.setVisibility(0);
        }
    }

    public boolean bre() {
        return (this.fnB == null || this.fnB.getParent() == null) ? false : true;
    }

    private int jR(boolean z) {
        if (z) {
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                return UtilHelper.getStatusBarHeight();
            }
            return 0;
        }
        return this.mPageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds160);
    }

    public void brf() {
        View findViewWithTag = findViewWithTag("AlaLivePraiseGuideController");
        if (findViewWithTag != null) {
            removeView(findViewWithTag);
        }
    }
}
