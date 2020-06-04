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
    private AlaLiveView fXk;
    private TbImageView ggN;
    private FrameLayout ggO;
    private View ggP;
    private View ggQ;
    private FrameLayout ggR;
    private TextView ggS;
    private Bitmap ggT;
    Runnable ggU;
    private Handler mHandler;
    private TbPageContext mPageContext;
    private ViewGroup mRootView;

    public AlaLiveRoomBlurPageLayout(Context context) {
        super(context);
        this.ggN = null;
        this.ggP = null;
        this.fXk = null;
        this.ggQ = null;
        this.ggR = null;
        this.ggS = null;
        this.ggU = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveRoomBlurPageLayout.1
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
                        AlaLiveRoomBlurPageLayout.this.ggN.setAlpha(0.0f);
                        AlaLiveRoomBlurPageLayout.this.ggN.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                AlaLiveRoomBlurPageLayout.this.ggN.clearAnimation();
                AlaLiveRoomBlurPageLayout.this.ggN.startAnimation(alphaAnimation);
            }
        };
        init();
    }

    public AlaLiveRoomBlurPageLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ggN = null;
        this.ggP = null;
        this.fXk = null;
        this.ggQ = null;
        this.ggR = null;
        this.ggS = null;
        this.ggU = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveRoomBlurPageLayout.1
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
                        AlaLiveRoomBlurPageLayout.this.ggN.setAlpha(0.0f);
                        AlaLiveRoomBlurPageLayout.this.ggN.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                AlaLiveRoomBlurPageLayout.this.ggN.clearAnimation();
                AlaLiveRoomBlurPageLayout.this.ggN.startAnimation(alphaAnimation);
            }
        };
        init();
    }

    public AlaLiveRoomBlurPageLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ggN = null;
        this.ggP = null;
        this.fXk = null;
        this.ggQ = null;
        this.ggR = null;
        this.ggS = null;
        this.ggU = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveRoomBlurPageLayout.1
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
                        AlaLiveRoomBlurPageLayout.this.ggN.setAlpha(0.0f);
                        AlaLiveRoomBlurPageLayout.this.ggN.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                AlaLiveRoomBlurPageLayout.this.ggN.clearAnimation();
                AlaLiveRoomBlurPageLayout.this.ggN.startAnimation(alphaAnimation);
            }
        };
        init();
    }

    private void init() {
        Log.i("LiveRoomBlurPageLayout", "@@ context = " + getContext());
        this.mRootView = (ViewGroup) View.inflate(getContext(), a.h.ala_liveroom_audience_blur_layout, this);
        setClipChildren(false);
        this.ggN = (TbImageView) findViewById(a.g.ala_liveroom_background_img);
        this.ggT = drawableToBitmap(new ColorDrawable(getResources().getColor(a.d.sdk_color_333333)));
        this.ggO = new FrameLayout(getContext());
        this.ggO.setId(a.g.ala_liveroom_player_container_view);
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
        if (this.ggN != null) {
            ViewGroup.LayoutParams layoutParams = this.ggN.getLayoutParams();
            layoutParams.width = i;
            layoutParams.height = i2;
            this.ggN.setLayoutParams(layoutParams);
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
            if (this.ggR != null && this.ggR.getParent() != null) {
                ViewGroup.LayoutParams layoutParams = this.ggR.getLayoutParams();
                layoutParams.width = screenFullSize[0];
                layoutParams.height = screenFullSize[1] - 0;
                this.ggR.setLayoutParams(layoutParams);
            }
        }
    }

    public void a(AlaLiveView alaLiveView, ViewGroup.LayoutParams layoutParams) {
        if (alaLiveView != null) {
            if (this.mRootView.indexOfChild(alaLiveView) < 0 && this.mRootView.getChildCount() > 1) {
                this.fXk = alaLiveView;
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
            bGS();
        }
    }

    public void bGN() {
        if (this.fXk != null) {
            this.mRootView.removeView(this.fXk);
        }
        this.fXk = null;
    }

    @Override // com.baidu.live.o.e
    public ViewGroup getLiveContainerView() {
        return this;
    }

    public void a(View view, ViewGroup.LayoutParams layoutParams, boolean z) {
        if (this.ggO.getParent() != null) {
            this.mRootView.removeView(this.ggO);
        }
        this.mRootView.addView(this.ggO, 1);
        if (this.ggP != null && this.ggP.getParent() != null) {
            ((ViewGroup) this.ggP.getParent()).removeView(this.ggP);
        }
        this.ggP = view;
        if (this.ggP != null && this.ggP.getParent() != null) {
            ((ViewGroup) this.ggP.getParent()).removeView(this.ggP);
        }
        if (this.ggP != null) {
            if (layoutParams != null) {
                this.ggO.addView(this.ggP, layoutParams);
            } else {
                this.ggO.addView(this.ggP, this.ggP.getLayoutParams());
            }
        }
    }

    public void Jh() {
        if (this.ggO.getParent() != null) {
            ((ViewGroup) this.ggO.getParent()).removeView(this.ggO);
        }
        if (this.ggP != null && this.ggP.getParent() != null) {
            ((ViewGroup) this.ggP.getParent()).removeView(this.ggP);
        }
        this.ggP = null;
    }

    public boolean bG(View view) {
        return (this.ggO == null || this.ggO.getParent() == null || this.ggO.indexOfChild(view) < 0) ? false : true;
    }

    public void b(View view, ViewGroup.LayoutParams layoutParams) {
        if (this.ggQ != null && this.mRootView.indexOfChild(this.ggQ) >= 0) {
            this.mRootView.removeView(this.ggQ);
        }
        this.ggQ = view;
        int childCount = this.mRootView.getChildCount() - 1;
        int childCount2 = this.mRootView.getChildCount();
        int i = childCount;
        for (int i2 = 0; i2 < childCount2; i2++) {
            if (this.mRootView.getChildAt(i2).getId() == a.g.ala_live_room_close_btn_layout) {
                i = Math.max(i, i2);
            }
        }
        if (this.ggQ != null) {
            this.mRootView.addView(this.ggQ, i, layoutParams);
        }
        bGS();
    }

    public void bGO() {
        if (this.ggQ != null) {
            this.mRootView.removeView(this.ggQ);
        }
        this.ggQ = null;
    }

    public void bGP() {
        if (this.ggN.getAlpha() == 1.0f) {
            this.ggN.clearAnimation();
            this.mHandler.postDelayed(this.ggU, 300L);
            return;
        }
        this.ggN.clearAnimation();
        this.ggN.setAlpha(0.0f);
        this.ggN.setVisibility(8);
    }

    public void bGQ() {
        this.mHandler.removeCallbacks(this.ggU);
        this.ggN.clearAnimation();
        this.ggN.setAlpha(0.0f);
        this.ggN.setVisibility(8);
    }

    public void bGR() {
        this.mHandler.removeCallbacks(this.ggU);
        this.ggN.clearAnimation();
        this.ggN.setAlpha(1.0f);
        this.ggN.setVisibility(0);
    }

    public void setBackImageBlack(AlaLiveInfoData alaLiveInfoData) {
        if ((alaLiveInfoData == null || alaLiveInfoData.screen_direction != 2) && this.ggN != null) {
            this.ggN.setImageDrawable(null);
            this.ggN.setBackgroundColor(this.mPageContext.getResources().getColor(a.d.sdk_transparent));
        }
    }

    public void setBgImageUrl(String str, int i, AlaLiveInfoData alaLiveInfoData) {
        if (this.mPageContext != null && !TextUtils.isEmpty(str)) {
            int[] screenFullSize = ViewCommonUtil.getScreenFullSize(this.mPageContext.getPageActivity());
            bC(screenFullSize[0], screenFullSize[1]);
            if (alaLiveInfoData != null && alaLiveInfoData.screen_direction == 2) {
                this.ggN.setImageBitmap(this.ggT);
            } else if (!TextUtils.isEmpty(str)) {
                this.ggN.startLoad(str, 39, false, false);
            } else {
                this.ggN.setBackgroundResource(a.f.pic_avatar_moren);
            }
        }
    }

    public void setBgImageUrl(String str, AlaLiveInfoData alaLiveInfoData) {
        setBgImageUrl(str, 10, alaLiveInfoData);
    }

    public void release() {
        if (this.ggN != null) {
            this.ggN.setImageDrawable(null);
            this.ggN.stopLoad();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (this.fXk != null && !this.fXk.ghg) {
            z = this.fXk.E(motionEvent);
        }
        if (z || motionEvent.getAction() == 0) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void lr(boolean z) {
        Context context = getContext();
        if (this.ggS == null) {
            this.ggR = new FrameLayout(context);
            this.ggR.setBackgroundColor(getContext().getResources().getColor(a.d.sdk_cp_cont_b));
            this.ggS = new TextView(context);
            this.ggS.setText(context.getResources().getString(a.i.ala_live_private_tip));
            this.ggS.setTextSize(0, context.getResources().getDimensionPixelSize(a.e.sdk_ds28));
            this.ggS.setTextColor(context.getResources().getColor(a.d.sdk_cp_cont_i_alpha40));
            this.ggS.setGravity(49);
            Drawable drawable = context.getResources().getDrawable(a.f.private_tip);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            this.ggS.setCompoundDrawables(null, drawable, null, null);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.topMargin = ls(z);
            layoutParams.gravity = 1;
            this.ggR.addView(this.ggS, layoutParams);
            int indexOfChild = this.fXk != null ? this.mRootView.indexOfChild(this.fXk) : -1;
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
            int[] screenFullSize = ViewCommonUtil.getScreenFullSize(this.mPageContext.getPageActivity());
            int statusBarHeight = !UtilHelper.canUseStyleImmersiveSticky() ? UtilHelper.getStatusBarHeight() : 0;
            layoutParams2.width = screenFullSize[0];
            layoutParams2.height = screenFullSize[1] - statusBarHeight;
            if (indexOfChild < 0) {
                this.mRootView.addView(this.ggR, layoutParams2);
            } else {
                this.mRootView.addView(this.ggR, indexOfChild, layoutParams2);
            }
        } else {
            if (this.ggR.getParent() != null) {
                this.mRootView.removeView(this.ggR);
            }
            int indexOfChild2 = this.fXk != null ? this.mRootView.indexOfChild(this.fXk) : -1;
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -1);
            int[] screenFullSize2 = ViewCommonUtil.getScreenFullSize(this.mPageContext.getPageActivity());
            int statusBarHeight2 = !UtilHelper.canUseStyleImmersiveSticky() ? UtilHelper.getStatusBarHeight() : 0;
            layoutParams3.width = screenFullSize2[0];
            layoutParams3.height = screenFullSize2[1] - statusBarHeight2;
            if (indexOfChild2 < 0) {
                this.mRootView.addView(this.ggR, layoutParams3);
            } else {
                this.mRootView.addView(this.ggR, indexOfChild2, layoutParams3);
            }
            FrameLayout.LayoutParams layoutParams4 = (FrameLayout.LayoutParams) this.ggS.getLayoutParams();
            layoutParams4.topMargin = ls(z);
            this.ggS.setLayoutParams(layoutParams4);
        }
        this.ggR.setVisibility(0);
        this.ggS.setVisibility(0);
        if (this.ggP != null) {
            this.ggP.setVisibility(8);
        }
        if (this.ggN != null) {
            this.ggN.setVisibility(8);
        }
    }

    public void G(int i, boolean z) {
        FrameLayout.LayoutParams layoutParams;
        if (this.ggS != null) {
            if (this.ggS.getLayoutParams() != null && (this.ggS.getLayoutParams() instanceof FrameLayout.LayoutParams)) {
                layoutParams = (FrameLayout.LayoutParams) this.ggS.getLayoutParams();
            } else {
                layoutParams = new FrameLayout.LayoutParams(-2, -2);
            }
            if (i == 2) {
                layoutParams.topMargin = getResources().getDimensionPixelSize(a.e.sdk_ds45);
                layoutParams.gravity = 1;
                this.ggS.setLayoutParams(layoutParams);
                return;
            }
            layoutParams.topMargin = ls(z);
            layoutParams.gravity = 1;
            this.ggS.setLayoutParams(layoutParams);
        }
    }

    public void bGS() {
        if (this.ggR != null && this.ggR.getParent() != null) {
            ((ViewGroup) this.ggR.getParent()).removeView(this.ggR);
        }
        if (this.ggP != null) {
            this.ggP.setVisibility(0);
        }
        if (this.ggN != null) {
            this.ggN.setVisibility(0);
        }
    }

    public boolean bGT() {
        return (this.ggR == null || this.ggR.getParent() == null) ? false : true;
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

    public void bGU() {
        View findViewWithTag = findViewWithTag("AlaLivePraiseGuideController");
        if (findViewWithTag != null) {
            removeView(findViewWithTag);
        }
    }
}
