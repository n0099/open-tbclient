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
    private AlaLiveView fWZ;
    private TbImageView ggC;
    private FrameLayout ggD;
    private View ggE;
    private View ggF;
    private FrameLayout ggG;
    private TextView ggH;
    private Bitmap ggI;
    Runnable ggJ;
    private Handler mHandler;
    private TbPageContext mPageContext;
    private ViewGroup mRootView;

    public AlaLiveRoomBlurPageLayout(Context context) {
        super(context);
        this.ggC = null;
        this.ggE = null;
        this.fWZ = null;
        this.ggF = null;
        this.ggG = null;
        this.ggH = null;
        this.ggJ = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveRoomBlurPageLayout.1
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
                        AlaLiveRoomBlurPageLayout.this.ggC.setAlpha(0.0f);
                        AlaLiveRoomBlurPageLayout.this.ggC.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                AlaLiveRoomBlurPageLayout.this.ggC.clearAnimation();
                AlaLiveRoomBlurPageLayout.this.ggC.startAnimation(alphaAnimation);
            }
        };
        init();
    }

    public AlaLiveRoomBlurPageLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ggC = null;
        this.ggE = null;
        this.fWZ = null;
        this.ggF = null;
        this.ggG = null;
        this.ggH = null;
        this.ggJ = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveRoomBlurPageLayout.1
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
                        AlaLiveRoomBlurPageLayout.this.ggC.setAlpha(0.0f);
                        AlaLiveRoomBlurPageLayout.this.ggC.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                AlaLiveRoomBlurPageLayout.this.ggC.clearAnimation();
                AlaLiveRoomBlurPageLayout.this.ggC.startAnimation(alphaAnimation);
            }
        };
        init();
    }

    public AlaLiveRoomBlurPageLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ggC = null;
        this.ggE = null;
        this.fWZ = null;
        this.ggF = null;
        this.ggG = null;
        this.ggH = null;
        this.ggJ = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveRoomBlurPageLayout.1
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
                        AlaLiveRoomBlurPageLayout.this.ggC.setAlpha(0.0f);
                        AlaLiveRoomBlurPageLayout.this.ggC.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                AlaLiveRoomBlurPageLayout.this.ggC.clearAnimation();
                AlaLiveRoomBlurPageLayout.this.ggC.startAnimation(alphaAnimation);
            }
        };
        init();
    }

    private void init() {
        Log.i("LiveRoomBlurPageLayout", "@@ context = " + getContext());
        this.mRootView = (ViewGroup) View.inflate(getContext(), a.h.ala_liveroom_audience_blur_layout, this);
        setClipChildren(false);
        this.ggC = (TbImageView) findViewById(a.g.ala_liveroom_background_img);
        this.ggI = drawableToBitmap(new ColorDrawable(getResources().getColor(a.d.sdk_color_333333)));
        this.ggD = new FrameLayout(getContext());
        this.ggD.setId(a.g.ala_liveroom_player_container_view);
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
        bC(screenFullSize[0], screenFullSize[1]);
    }

    private void bC(int i, int i2) {
        if (this.ggC != null) {
            ViewGroup.LayoutParams layoutParams = this.ggC.getLayoutParams();
            layoutParams.width = i;
            layoutParams.height = i2;
            this.ggC.setLayoutParams(layoutParams);
        }
    }

    public void bp(int i, int i2) {
        bC(i, i2);
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (configuration != null) {
            int[] screenFullSize = ViewCommonUtil.getScreenFullSize(this.mPageContext.getPageActivity());
            if (this.ggG != null && this.ggG.getParent() != null) {
                ViewGroup.LayoutParams layoutParams = this.ggG.getLayoutParams();
                layoutParams.width = screenFullSize[0];
                layoutParams.height = screenFullSize[1] - 0;
                this.ggG.setLayoutParams(layoutParams);
            }
        }
    }

    public void a(AlaLiveView alaLiveView, ViewGroup.LayoutParams layoutParams) {
        if (alaLiveView != null) {
            if (this.mRootView.indexOfChild(alaLiveView) < 0 && this.mRootView.getChildCount() > 1) {
                this.fWZ = alaLiveView;
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
            bGQ();
        }
    }

    public void bGL() {
        if (this.fWZ != null) {
            this.mRootView.removeView(this.fWZ);
        }
        this.fWZ = null;
    }

    @Override // com.baidu.live.o.e
    public ViewGroup getLiveContainerView() {
        return this;
    }

    public void a(View view, ViewGroup.LayoutParams layoutParams, boolean z) {
        if (this.ggD.getParent() != null) {
            this.mRootView.removeView(this.ggD);
        }
        this.mRootView.addView(this.ggD, 1);
        if (this.ggE != null && this.ggE.getParent() != null) {
            ((ViewGroup) this.ggE.getParent()).removeView(this.ggE);
        }
        this.ggE = view;
        if (this.ggE != null && this.ggE.getParent() != null) {
            ((ViewGroup) this.ggE.getParent()).removeView(this.ggE);
        }
        if (this.ggE != null) {
            if (layoutParams != null) {
                this.ggD.addView(this.ggE, layoutParams);
            } else {
                this.ggD.addView(this.ggE, this.ggE.getLayoutParams());
            }
        }
    }

    public void Jh() {
        if (this.ggD.getParent() != null) {
            ((ViewGroup) this.ggD.getParent()).removeView(this.ggD);
        }
        if (this.ggE != null && this.ggE.getParent() != null) {
            ((ViewGroup) this.ggE.getParent()).removeView(this.ggE);
        }
        this.ggE = null;
    }

    public boolean bG(View view) {
        return (this.ggD == null || this.ggD.getParent() == null || this.ggD.indexOfChild(view) < 0) ? false : true;
    }

    public void b(View view, ViewGroup.LayoutParams layoutParams) {
        if (this.ggF != null && this.mRootView.indexOfChild(this.ggF) >= 0) {
            this.mRootView.removeView(this.ggF);
        }
        this.ggF = view;
        int childCount = this.mRootView.getChildCount() - 1;
        int childCount2 = this.mRootView.getChildCount();
        int i = childCount;
        for (int i2 = 0; i2 < childCount2; i2++) {
            if (this.mRootView.getChildAt(i2).getId() == a.g.ala_live_room_close_btn_layout) {
                i = Math.max(i, i2);
            }
        }
        if (this.ggF != null) {
            this.mRootView.addView(this.ggF, i, layoutParams);
        }
        bGQ();
    }

    public void bGM() {
        if (this.ggF != null) {
            this.mRootView.removeView(this.ggF);
        }
        this.ggF = null;
    }

    public void bGN() {
        if (this.ggC.getAlpha() == 1.0f) {
            this.ggC.clearAnimation();
            this.mHandler.postDelayed(this.ggJ, 300L);
            return;
        }
        this.ggC.clearAnimation();
        this.ggC.setAlpha(0.0f);
        this.ggC.setVisibility(8);
    }

    public void bGO() {
        this.mHandler.removeCallbacks(this.ggJ);
        this.ggC.clearAnimation();
        this.ggC.setAlpha(0.0f);
        this.ggC.setVisibility(8);
    }

    public void bGP() {
        this.mHandler.removeCallbacks(this.ggJ);
        this.ggC.clearAnimation();
        this.ggC.setAlpha(1.0f);
        this.ggC.setVisibility(0);
    }

    public void setBackImageBlack(AlaLiveInfoData alaLiveInfoData) {
        if ((alaLiveInfoData == null || alaLiveInfoData.screen_direction != 2) && this.ggC != null) {
            this.ggC.setImageDrawable(null);
            this.ggC.setBackgroundColor(this.mPageContext.getResources().getColor(a.d.sdk_transparent));
        }
    }

    public void setBgImageUrl(String str, int i, AlaLiveInfoData alaLiveInfoData) {
        if (this.mPageContext != null && !TextUtils.isEmpty(str)) {
            int[] screenFullSize = ViewCommonUtil.getScreenFullSize(this.mPageContext.getPageActivity());
            bC(screenFullSize[0], screenFullSize[1]);
            if (alaLiveInfoData != null && alaLiveInfoData.screen_direction == 2) {
                this.ggC.setImageBitmap(this.ggI);
            } else if (!TextUtils.isEmpty(str)) {
                this.ggC.startLoad(str, 39, false, false);
            } else {
                this.ggC.setBackgroundResource(a.f.pic_avatar_moren);
            }
        }
    }

    public void setBgImageUrl(String str, AlaLiveInfoData alaLiveInfoData) {
        setBgImageUrl(str, 10, alaLiveInfoData);
    }

    public void release() {
        if (this.ggC != null) {
            this.ggC.setImageDrawable(null);
            this.ggC.stopLoad();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (this.fWZ != null && !this.fWZ.ggV) {
            z = this.fWZ.E(motionEvent);
        }
        if (z || motionEvent.getAction() == 0) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void lr(boolean z) {
        Context context = getContext();
        if (this.ggH == null) {
            this.ggG = new FrameLayout(context);
            this.ggG.setBackgroundColor(getContext().getResources().getColor(a.d.sdk_cp_cont_b));
            this.ggH = new TextView(context);
            this.ggH.setText(context.getResources().getString(a.i.ala_live_private_tip));
            this.ggH.setTextSize(0, context.getResources().getDimensionPixelSize(a.e.sdk_ds28));
            this.ggH.setTextColor(context.getResources().getColor(a.d.sdk_cp_cont_i_alpha40));
            this.ggH.setGravity(49);
            Drawable drawable = context.getResources().getDrawable(a.f.private_tip);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            this.ggH.setCompoundDrawables(null, drawable, null, null);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.topMargin = ls(z);
            layoutParams.gravity = 1;
            this.ggG.addView(this.ggH, layoutParams);
            int indexOfChild = this.fWZ != null ? this.mRootView.indexOfChild(this.fWZ) : -1;
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
            int[] screenFullSize = ViewCommonUtil.getScreenFullSize(this.mPageContext.getPageActivity());
            int statusBarHeight = !UtilHelper.canUseStyleImmersiveSticky() ? UtilHelper.getStatusBarHeight() : 0;
            layoutParams2.width = screenFullSize[0];
            layoutParams2.height = screenFullSize[1] - statusBarHeight;
            if (indexOfChild < 0) {
                this.mRootView.addView(this.ggG, layoutParams2);
            } else {
                this.mRootView.addView(this.ggG, indexOfChild, layoutParams2);
            }
        } else {
            if (this.ggG.getParent() != null) {
                this.mRootView.removeView(this.ggG);
            }
            int indexOfChild2 = this.fWZ != null ? this.mRootView.indexOfChild(this.fWZ) : -1;
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -1);
            int[] screenFullSize2 = ViewCommonUtil.getScreenFullSize(this.mPageContext.getPageActivity());
            int statusBarHeight2 = !UtilHelper.canUseStyleImmersiveSticky() ? UtilHelper.getStatusBarHeight() : 0;
            layoutParams3.width = screenFullSize2[0];
            layoutParams3.height = screenFullSize2[1] - statusBarHeight2;
            if (indexOfChild2 < 0) {
                this.mRootView.addView(this.ggG, layoutParams3);
            } else {
                this.mRootView.addView(this.ggG, indexOfChild2, layoutParams3);
            }
            FrameLayout.LayoutParams layoutParams4 = (FrameLayout.LayoutParams) this.ggH.getLayoutParams();
            layoutParams4.topMargin = ls(z);
            this.ggH.setLayoutParams(layoutParams4);
        }
        this.ggG.setVisibility(0);
        this.ggH.setVisibility(0);
        if (this.ggE != null) {
            this.ggE.setVisibility(8);
        }
        if (this.ggC != null) {
            this.ggC.setVisibility(8);
        }
    }

    public void G(int i, boolean z) {
        FrameLayout.LayoutParams layoutParams;
        if (this.ggH != null) {
            if (this.ggH.getLayoutParams() != null && (this.ggH.getLayoutParams() instanceof FrameLayout.LayoutParams)) {
                layoutParams = (FrameLayout.LayoutParams) this.ggH.getLayoutParams();
            } else {
                layoutParams = new FrameLayout.LayoutParams(-2, -2);
            }
            if (i == 2) {
                layoutParams.topMargin = getResources().getDimensionPixelSize(a.e.sdk_ds45);
                layoutParams.gravity = 1;
                this.ggH.setLayoutParams(layoutParams);
                return;
            }
            layoutParams.topMargin = ls(z);
            layoutParams.gravity = 1;
            this.ggH.setLayoutParams(layoutParams);
        }
    }

    public void bGQ() {
        if (this.ggG != null && this.ggG.getParent() != null) {
            ((ViewGroup) this.ggG.getParent()).removeView(this.ggG);
        }
        if (this.ggE != null) {
            this.ggE.setVisibility(0);
        }
        if (this.ggC != null) {
            this.ggC.setVisibility(0);
        }
    }

    public boolean bGR() {
        return (this.ggG == null || this.ggG.getParent() == null) ? false : true;
    }

    private int ls(boolean z) {
        if (z) {
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                return UtilHelper.getStatusBarHeight();
            }
            return 0;
        }
        return this.mPageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds160);
    }

    public void bGS() {
        View findViewWithTag = findViewWithTag("AlaLivePraiseGuideController");
        if (findViewWithTag != null) {
            removeView(findViewWithTag);
        }
    }
}
