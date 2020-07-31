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
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.core.util.ViewCommonUtil;
import com.baidu.live.tbadk.widget.TbImageView;
/* loaded from: classes4.dex */
public class AlaLiveRoomBlurPageLayout extends FrameLayout implements com.baidu.live.p.e {
    private AlaLiveView gpi;
    private TbImageView gzg;
    private FrameLayout gzh;
    private View gzi;
    private View gzj;
    private FrameLayout gzk;
    private TextView gzl;
    private Bitmap gzm;
    Runnable gzn;
    private Handler mHandler;
    private TbPageContext mPageContext;
    private ViewGroup mRootView;

    public AlaLiveRoomBlurPageLayout(Context context) {
        super(context);
        this.gzg = null;
        this.gzi = null;
        this.gpi = null;
        this.gzj = null;
        this.gzk = null;
        this.gzl = null;
        this.gzn = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveRoomBlurPageLayout.1
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
                        AlaLiveRoomBlurPageLayout.this.gzg.setAlpha(0.0f);
                        AlaLiveRoomBlurPageLayout.this.gzg.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                AlaLiveRoomBlurPageLayout.this.gzg.clearAnimation();
                AlaLiveRoomBlurPageLayout.this.gzg.startAnimation(alphaAnimation);
            }
        };
        init();
    }

    public AlaLiveRoomBlurPageLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gzg = null;
        this.gzi = null;
        this.gpi = null;
        this.gzj = null;
        this.gzk = null;
        this.gzl = null;
        this.gzn = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveRoomBlurPageLayout.1
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
                        AlaLiveRoomBlurPageLayout.this.gzg.setAlpha(0.0f);
                        AlaLiveRoomBlurPageLayout.this.gzg.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                AlaLiveRoomBlurPageLayout.this.gzg.clearAnimation();
                AlaLiveRoomBlurPageLayout.this.gzg.startAnimation(alphaAnimation);
            }
        };
        init();
    }

    public AlaLiveRoomBlurPageLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gzg = null;
        this.gzi = null;
        this.gpi = null;
        this.gzj = null;
        this.gzk = null;
        this.gzl = null;
        this.gzn = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveRoomBlurPageLayout.1
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
                        AlaLiveRoomBlurPageLayout.this.gzg.setAlpha(0.0f);
                        AlaLiveRoomBlurPageLayout.this.gzg.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                AlaLiveRoomBlurPageLayout.this.gzg.clearAnimation();
                AlaLiveRoomBlurPageLayout.this.gzg.startAnimation(alphaAnimation);
            }
        };
        init();
    }

    private void init() {
        Log.i("LiveRoomBlurPageLayout", "@@ context = " + getContext());
        this.mRootView = (ViewGroup) View.inflate(getContext(), a.h.ala_liveroom_audience_blur_layout, this);
        setClipChildren(false);
        this.gzg = (TbImageView) findViewById(a.g.ala_liveroom_background_img);
        this.gzm = drawableToBitmap(new ColorDrawable(getResources().getColor(a.d.sdk_color_333333)));
        this.gzh = new FrameLayout(getContext());
        this.gzh.setId(a.g.ala_liveroom_player_container_view);
        this.mHandler = new Handler();
    }

    private Bitmap drawableToBitmap(Drawable drawable) {
        Bitmap createBitmap = Bitmap.createBitmap(10, 10, drawable.getOpacity() != -1 ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, 10, 10);
        drawable.draw(canvas);
        return createBitmap;
    }

    public void c(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        int[] screenFullSize = ViewCommonUtil.getScreenFullSize(tbPageContext.getPageActivity());
        bJ(screenFullSize[0], screenFullSize[1]);
    }

    private void bJ(int i, int i2) {
        if (this.gzg != null) {
            ViewGroup.LayoutParams layoutParams = this.gzg.getLayoutParams();
            layoutParams.width = i;
            layoutParams.height = i2;
            this.gzg.setLayoutParams(layoutParams);
        }
    }

    public void bw(int i, int i2) {
        bJ(i, i2);
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (configuration != null) {
            int[] screenFullSize = ViewCommonUtil.getScreenFullSize(this.mPageContext.getPageActivity());
            if (this.gzk != null && this.gzk.getParent() != null) {
                ViewGroup.LayoutParams layoutParams = this.gzk.getLayoutParams();
                layoutParams.width = screenFullSize[0];
                layoutParams.height = screenFullSize[1] - 0;
                this.gzk.setLayoutParams(layoutParams);
            }
        }
    }

    public void a(AlaLiveView alaLiveView, ViewGroup.LayoutParams layoutParams) {
        if (alaLiveView != null) {
            if (this.mRootView.indexOfChild(alaLiveView) < 0 && this.mRootView.getChildCount() > 1) {
                this.gpi = alaLiveView;
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
            bNg();
        }
    }

    public void bNb() {
        if (this.gpi != null) {
            this.mRootView.removeView(this.gpi);
        }
        this.gpi = null;
    }

    @Override // com.baidu.live.p.e
    public ViewGroup getLiveContainerView() {
        return this;
    }

    public void a(View view, ViewGroup.LayoutParams layoutParams, boolean z) {
        if (this.gzh.getParent() != null) {
            this.mRootView.removeView(this.gzh);
        }
        this.mRootView.addView(this.gzh, 1);
        if (this.gzi != null && this.gzi.getParent() != null) {
            ((ViewGroup) this.gzi.getParent()).removeView(this.gzi);
        }
        this.gzi = view;
        if (this.gzi != null && this.gzi.getParent() != null) {
            ((ViewGroup) this.gzi.getParent()).removeView(this.gzi);
        }
        if (this.gzi != null) {
            if (layoutParams != null) {
                this.gzh.addView(this.gzi, layoutParams);
            } else {
                this.gzh.addView(this.gzi, this.gzi.getLayoutParams());
            }
        }
    }

    public void KB() {
        if (this.gzh.getParent() != null) {
            ((ViewGroup) this.gzh.getParent()).removeView(this.gzh);
        }
        if (this.gzi != null && this.gzi.getParent() != null) {
            ((ViewGroup) this.gzi.getParent()).removeView(this.gzi);
        }
        this.gzi = null;
    }

    public boolean bQ(View view) {
        return (this.gzh == null || this.gzh.getParent() == null || this.gzh.indexOfChild(view) < 0) ? false : true;
    }

    public void b(View view, ViewGroup.LayoutParams layoutParams) {
        if (this.gzj != null && this.mRootView.indexOfChild(this.gzj) >= 0) {
            this.mRootView.removeView(this.gzj);
        }
        this.gzj = view;
        int childCount = this.mRootView.getChildCount() - 1;
        int childCount2 = this.mRootView.getChildCount();
        int i = childCount;
        for (int i2 = 0; i2 < childCount2; i2++) {
            if (this.mRootView.getChildAt(i2).getId() == a.g.ala_live_room_close_btn_layout) {
                i = Math.max(i, i2);
            }
        }
        if (this.gzj != null) {
            this.mRootView.addView(this.gzj, i, layoutParams);
        }
        bNg();
    }

    public void bNc() {
        if (this.gzj != null) {
            this.mRootView.removeView(this.gzj);
        }
        this.gzj = null;
    }

    public void bNd() {
        if (this.gzg.getAlpha() == 1.0f) {
            this.gzg.clearAnimation();
            this.mHandler.postDelayed(this.gzn, 300L);
            return;
        }
        this.gzg.clearAnimation();
        this.gzg.setAlpha(0.0f);
        this.gzg.setVisibility(8);
    }

    public void bNe() {
        this.mHandler.removeCallbacks(this.gzn);
        this.gzg.clearAnimation();
        this.gzg.setAlpha(0.0f);
        this.gzg.setVisibility(8);
    }

    public void bNf() {
        this.mHandler.removeCallbacks(this.gzn);
        this.gzg.clearAnimation();
        this.gzg.setAlpha(1.0f);
        this.gzg.setVisibility(0);
    }

    public void setBackImageBlack(AlaLiveInfoData alaLiveInfoData) {
        if ((alaLiveInfoData == null || alaLiveInfoData.screen_direction != 2) && this.gzg != null) {
            this.gzg.setImageDrawable(null);
            this.gzg.setBackgroundColor(this.mPageContext.getResources().getColor(a.d.sdk_transparent));
        }
    }

    public void setBgImageUrl(String str, int i, AlaLiveInfoData alaLiveInfoData) {
        if (this.mPageContext != null && !TextUtils.isEmpty(str)) {
            int[] screenFullSize = ViewCommonUtil.getScreenFullSize(this.mPageContext.getPageActivity());
            bJ(screenFullSize[0], screenFullSize[1]);
            if (alaLiveInfoData != null && alaLiveInfoData.screen_direction == 2) {
                this.gzg.setImageBitmap(this.gzm);
            } else if (!TextUtils.isEmpty(str)) {
                this.gzg.startLoad(str, 39, false, false);
            } else {
                this.gzg.setBackgroundResource(a.f.pic_avatar_moren);
            }
        }
    }

    public void setBgImageUrl(String str, AlaLiveInfoData alaLiveInfoData) {
        setBgImageUrl(str, 10, alaLiveInfoData);
    }

    public void release() {
        if (this.gzg != null) {
            this.gzg.setImageDrawable(null);
            this.gzg.stopLoad();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (this.gpi != null && !this.gpi.gzA) {
            z = this.gpi.E(motionEvent);
        }
        if (z || motionEvent.getAction() == 0) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void md(boolean z) {
        Context context = getContext();
        if (this.gzl == null) {
            this.gzk = new FrameLayout(context);
            this.gzk.setBackgroundColor(getContext().getResources().getColor(a.d.sdk_cp_cont_b));
            this.gzl = new TextView(context);
            this.gzl.setText(context.getResources().getString(a.i.ala_live_private_tip));
            this.gzl.setTextSize(0, context.getResources().getDimensionPixelSize(a.e.sdk_ds28));
            this.gzl.setTextColor(context.getResources().getColor(a.d.sdk_cp_cont_i_alpha40));
            this.gzl.setGravity(49);
            Drawable drawable = context.getResources().getDrawable(a.f.private_tip);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            this.gzl.setCompoundDrawables(null, drawable, null, null);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.topMargin = me(z);
            layoutParams.gravity = 1;
            this.gzk.addView(this.gzl, layoutParams);
            int indexOfChild = this.gpi != null ? this.mRootView.indexOfChild(this.gpi) : -1;
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
            int[] screenFullSize = ViewCommonUtil.getScreenFullSize(this.mPageContext.getPageActivity());
            int statusBarHeight = !UtilHelper.canUseStyleImmersiveSticky() ? UtilHelper.getStatusBarHeight() : 0;
            layoutParams2.width = screenFullSize[0];
            layoutParams2.height = screenFullSize[1] - statusBarHeight;
            if (indexOfChild < 0) {
                this.mRootView.addView(this.gzk, layoutParams2);
            } else {
                this.mRootView.addView(this.gzk, indexOfChild, layoutParams2);
            }
        } else {
            if (this.gzk.getParent() != null) {
                this.mRootView.removeView(this.gzk);
            }
            int indexOfChild2 = this.gpi != null ? this.mRootView.indexOfChild(this.gpi) : -1;
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -1);
            int[] screenFullSize2 = ViewCommonUtil.getScreenFullSize(this.mPageContext.getPageActivity());
            int statusBarHeight2 = !UtilHelper.canUseStyleImmersiveSticky() ? UtilHelper.getStatusBarHeight() : 0;
            layoutParams3.width = screenFullSize2[0];
            layoutParams3.height = screenFullSize2[1] - statusBarHeight2;
            if (indexOfChild2 < 0) {
                this.mRootView.addView(this.gzk, layoutParams3);
            } else {
                this.mRootView.addView(this.gzk, indexOfChild2, layoutParams3);
            }
            FrameLayout.LayoutParams layoutParams4 = (FrameLayout.LayoutParams) this.gzl.getLayoutParams();
            layoutParams4.topMargin = me(z);
            this.gzl.setLayoutParams(layoutParams4);
        }
        this.gzk.setVisibility(0);
        this.gzl.setVisibility(0);
        if (this.gzi != null) {
            this.gzi.setVisibility(8);
        }
        if (this.gzg != null) {
            this.gzg.setVisibility(8);
        }
    }

    public void I(int i, boolean z) {
        FrameLayout.LayoutParams layoutParams;
        if (this.gzl != null) {
            if (this.gzl.getLayoutParams() != null && (this.gzl.getLayoutParams() instanceof FrameLayout.LayoutParams)) {
                layoutParams = (FrameLayout.LayoutParams) this.gzl.getLayoutParams();
            } else {
                layoutParams = new FrameLayout.LayoutParams(-2, -2);
            }
            if (i == 2) {
                layoutParams.topMargin = getResources().getDimensionPixelSize(a.e.sdk_ds45);
                layoutParams.gravity = 1;
                this.gzl.setLayoutParams(layoutParams);
                return;
            }
            layoutParams.topMargin = me(z);
            layoutParams.gravity = 1;
            this.gzl.setLayoutParams(layoutParams);
        }
    }

    public void bNg() {
        if (this.gzk != null && this.gzk.getParent() != null) {
            ((ViewGroup) this.gzk.getParent()).removeView(this.gzk);
        }
        if (this.gzi != null) {
            this.gzi.setVisibility(0);
        }
        if (this.gzg != null) {
            this.gzg.setVisibility(0);
        }
    }

    public boolean bNh() {
        return (this.gzk == null || this.gzk.getParent() == null) ? false : true;
    }

    private int me(boolean z) {
        if (z) {
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                return UtilHelper.getStatusBarHeight();
            }
            return 0;
        }
        return this.mPageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds160);
    }

    public void bNi() {
        View findViewWithTag = findViewWithTag("AlaLivePraiseGuideController");
        if (findViewWithTag != null) {
            removeView(findViewWithTag);
        }
    }
}
