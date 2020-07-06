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
/* loaded from: classes3.dex */
public class AlaLiveRoomBlurPageLayout extends FrameLayout implements com.baidu.live.p.e {
    private AlaLiveView gkj;
    private TbImageView gtJ;
    private FrameLayout gtK;
    private View gtL;
    private View gtM;
    private FrameLayout gtN;
    private TextView gtO;
    private Bitmap gtP;
    Runnable gtQ;
    private Handler mHandler;
    private TbPageContext mPageContext;
    private ViewGroup mRootView;

    public AlaLiveRoomBlurPageLayout(Context context) {
        super(context);
        this.gtJ = null;
        this.gtL = null;
        this.gkj = null;
        this.gtM = null;
        this.gtN = null;
        this.gtO = null;
        this.gtQ = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveRoomBlurPageLayout.1
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
                        AlaLiveRoomBlurPageLayout.this.gtJ.setAlpha(0.0f);
                        AlaLiveRoomBlurPageLayout.this.gtJ.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                AlaLiveRoomBlurPageLayout.this.gtJ.clearAnimation();
                AlaLiveRoomBlurPageLayout.this.gtJ.startAnimation(alphaAnimation);
            }
        };
        init();
    }

    public AlaLiveRoomBlurPageLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gtJ = null;
        this.gtL = null;
        this.gkj = null;
        this.gtM = null;
        this.gtN = null;
        this.gtO = null;
        this.gtQ = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveRoomBlurPageLayout.1
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
                        AlaLiveRoomBlurPageLayout.this.gtJ.setAlpha(0.0f);
                        AlaLiveRoomBlurPageLayout.this.gtJ.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                AlaLiveRoomBlurPageLayout.this.gtJ.clearAnimation();
                AlaLiveRoomBlurPageLayout.this.gtJ.startAnimation(alphaAnimation);
            }
        };
        init();
    }

    public AlaLiveRoomBlurPageLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gtJ = null;
        this.gtL = null;
        this.gkj = null;
        this.gtM = null;
        this.gtN = null;
        this.gtO = null;
        this.gtQ = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveRoomBlurPageLayout.1
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
                        AlaLiveRoomBlurPageLayout.this.gtJ.setAlpha(0.0f);
                        AlaLiveRoomBlurPageLayout.this.gtJ.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                AlaLiveRoomBlurPageLayout.this.gtJ.clearAnimation();
                AlaLiveRoomBlurPageLayout.this.gtJ.startAnimation(alphaAnimation);
            }
        };
        init();
    }

    private void init() {
        Log.i("LiveRoomBlurPageLayout", "@@ context = " + getContext());
        this.mRootView = (ViewGroup) View.inflate(getContext(), a.h.ala_liveroom_audience_blur_layout, this);
        setClipChildren(false);
        this.gtJ = (TbImageView) findViewById(a.g.ala_liveroom_background_img);
        this.gtP = drawableToBitmap(new ColorDrawable(getResources().getColor(a.d.sdk_color_333333)));
        this.gtK = new FrameLayout(getContext());
        this.gtK.setId(a.g.ala_liveroom_player_container_view);
        this.mHandler = new Handler();
    }

    private Bitmap drawableToBitmap(Drawable drawable) {
        Bitmap createBitmap = Bitmap.createBitmap(10, 10, drawable.getOpacity() != -1 ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, 10, 10);
        drawable.draw(canvas);
        return createBitmap;
    }

    public void d(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        int[] screenFullSize = ViewCommonUtil.getScreenFullSize(tbPageContext.getPageActivity());
        bG(screenFullSize[0], screenFullSize[1]);
    }

    private void bG(int i, int i2) {
        if (this.gtJ != null) {
            ViewGroup.LayoutParams layoutParams = this.gtJ.getLayoutParams();
            layoutParams.width = i;
            layoutParams.height = i2;
            this.gtJ.setLayoutParams(layoutParams);
        }
    }

    public void bt(int i, int i2) {
        bG(i, i2);
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (configuration != null) {
            int[] screenFullSize = ViewCommonUtil.getScreenFullSize(this.mPageContext.getPageActivity());
            if (this.gtN != null && this.gtN.getParent() != null) {
                ViewGroup.LayoutParams layoutParams = this.gtN.getLayoutParams();
                layoutParams.width = screenFullSize[0];
                layoutParams.height = screenFullSize[1] - 0;
                this.gtN.setLayoutParams(layoutParams);
            }
        }
    }

    public void a(AlaLiveView alaLiveView, ViewGroup.LayoutParams layoutParams) {
        if (alaLiveView != null) {
            if (this.mRootView.indexOfChild(alaLiveView) < 0 && this.mRootView.getChildCount() > 1) {
                this.gkj = alaLiveView;
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
            bKa();
        }
    }

    public void bJV() {
        if (this.gkj != null) {
            this.mRootView.removeView(this.gkj);
        }
        this.gkj = null;
    }

    @Override // com.baidu.live.p.e
    public ViewGroup getLiveContainerView() {
        return this;
    }

    public void a(View view, ViewGroup.LayoutParams layoutParams, boolean z) {
        if (this.gtK.getParent() != null) {
            this.mRootView.removeView(this.gtK);
        }
        this.mRootView.addView(this.gtK, 1);
        if (this.gtL != null && this.gtL.getParent() != null) {
            ((ViewGroup) this.gtL.getParent()).removeView(this.gtL);
        }
        this.gtL = view;
        if (this.gtL != null && this.gtL.getParent() != null) {
            ((ViewGroup) this.gtL.getParent()).removeView(this.gtL);
        }
        if (this.gtL != null) {
            if (layoutParams != null) {
                this.gtK.addView(this.gtL, layoutParams);
            } else {
                this.gtK.addView(this.gtL, this.gtL.getLayoutParams());
            }
        }
    }

    public void Ku() {
        if (this.gtK.getParent() != null) {
            ((ViewGroup) this.gtK.getParent()).removeView(this.gtK);
        }
        if (this.gtL != null && this.gtL.getParent() != null) {
            ((ViewGroup) this.gtL.getParent()).removeView(this.gtL);
        }
        this.gtL = null;
    }

    public boolean bK(View view) {
        return (this.gtK == null || this.gtK.getParent() == null || this.gtK.indexOfChild(view) < 0) ? false : true;
    }

    public void b(View view, ViewGroup.LayoutParams layoutParams) {
        if (this.gtM != null && this.mRootView.indexOfChild(this.gtM) >= 0) {
            this.mRootView.removeView(this.gtM);
        }
        this.gtM = view;
        int childCount = this.mRootView.getChildCount() - 1;
        int childCount2 = this.mRootView.getChildCount();
        int i = childCount;
        for (int i2 = 0; i2 < childCount2; i2++) {
            if (this.mRootView.getChildAt(i2).getId() == a.g.ala_live_room_close_btn_layout) {
                i = Math.max(i, i2);
            }
        }
        if (this.gtM != null) {
            this.mRootView.addView(this.gtM, i, layoutParams);
        }
        bKa();
    }

    public void bJW() {
        if (this.gtM != null) {
            this.mRootView.removeView(this.gtM);
        }
        this.gtM = null;
    }

    public void bJX() {
        if (this.gtJ.getAlpha() == 1.0f) {
            this.gtJ.clearAnimation();
            this.mHandler.postDelayed(this.gtQ, 300L);
            return;
        }
        this.gtJ.clearAnimation();
        this.gtJ.setAlpha(0.0f);
        this.gtJ.setVisibility(8);
    }

    public void bJY() {
        this.mHandler.removeCallbacks(this.gtQ);
        this.gtJ.clearAnimation();
        this.gtJ.setAlpha(0.0f);
        this.gtJ.setVisibility(8);
    }

    public void bJZ() {
        this.mHandler.removeCallbacks(this.gtQ);
        this.gtJ.clearAnimation();
        this.gtJ.setAlpha(1.0f);
        this.gtJ.setVisibility(0);
    }

    public void setBackImageBlack(AlaLiveInfoData alaLiveInfoData) {
        if ((alaLiveInfoData == null || alaLiveInfoData.screen_direction != 2) && this.gtJ != null) {
            this.gtJ.setImageDrawable(null);
            this.gtJ.setBackgroundColor(this.mPageContext.getResources().getColor(a.d.sdk_transparent));
        }
    }

    public void setBgImageUrl(String str, int i, AlaLiveInfoData alaLiveInfoData) {
        if (this.mPageContext != null && !TextUtils.isEmpty(str)) {
            int[] screenFullSize = ViewCommonUtil.getScreenFullSize(this.mPageContext.getPageActivity());
            bG(screenFullSize[0], screenFullSize[1]);
            if (alaLiveInfoData != null && alaLiveInfoData.screen_direction == 2) {
                this.gtJ.setImageBitmap(this.gtP);
            } else if (!TextUtils.isEmpty(str)) {
                this.gtJ.startLoad(str, 39, false, false);
            } else {
                this.gtJ.setBackgroundResource(a.f.pic_avatar_moren);
            }
        }
    }

    public void setBgImageUrl(String str, AlaLiveInfoData alaLiveInfoData) {
        setBgImageUrl(str, 10, alaLiveInfoData);
    }

    public void release() {
        if (this.gtJ != null) {
            this.gtJ.setImageDrawable(null);
            this.gtJ.stopLoad();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (this.gkj != null && !this.gkj.gud) {
            z = this.gkj.E(motionEvent);
        }
        if (z || motionEvent.getAction() == 0) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void lz(boolean z) {
        Context context = getContext();
        if (this.gtO == null) {
            this.gtN = new FrameLayout(context);
            this.gtN.setBackgroundColor(getContext().getResources().getColor(a.d.sdk_cp_cont_b));
            this.gtO = new TextView(context);
            this.gtO.setText(context.getResources().getString(a.i.ala_live_private_tip));
            this.gtO.setTextSize(0, context.getResources().getDimensionPixelSize(a.e.sdk_ds28));
            this.gtO.setTextColor(context.getResources().getColor(a.d.sdk_cp_cont_i_alpha40));
            this.gtO.setGravity(49);
            Drawable drawable = context.getResources().getDrawable(a.f.private_tip);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            this.gtO.setCompoundDrawables(null, drawable, null, null);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.topMargin = lA(z);
            layoutParams.gravity = 1;
            this.gtN.addView(this.gtO, layoutParams);
            int indexOfChild = this.gkj != null ? this.mRootView.indexOfChild(this.gkj) : -1;
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
            int[] screenFullSize = ViewCommonUtil.getScreenFullSize(this.mPageContext.getPageActivity());
            int statusBarHeight = !UtilHelper.canUseStyleImmersiveSticky() ? UtilHelper.getStatusBarHeight() : 0;
            layoutParams2.width = screenFullSize[0];
            layoutParams2.height = screenFullSize[1] - statusBarHeight;
            if (indexOfChild < 0) {
                this.mRootView.addView(this.gtN, layoutParams2);
            } else {
                this.mRootView.addView(this.gtN, indexOfChild, layoutParams2);
            }
        } else {
            if (this.gtN.getParent() != null) {
                this.mRootView.removeView(this.gtN);
            }
            int indexOfChild2 = this.gkj != null ? this.mRootView.indexOfChild(this.gkj) : -1;
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -1);
            int[] screenFullSize2 = ViewCommonUtil.getScreenFullSize(this.mPageContext.getPageActivity());
            int statusBarHeight2 = !UtilHelper.canUseStyleImmersiveSticky() ? UtilHelper.getStatusBarHeight() : 0;
            layoutParams3.width = screenFullSize2[0];
            layoutParams3.height = screenFullSize2[1] - statusBarHeight2;
            if (indexOfChild2 < 0) {
                this.mRootView.addView(this.gtN, layoutParams3);
            } else {
                this.mRootView.addView(this.gtN, indexOfChild2, layoutParams3);
            }
            FrameLayout.LayoutParams layoutParams4 = (FrameLayout.LayoutParams) this.gtO.getLayoutParams();
            layoutParams4.topMargin = lA(z);
            this.gtO.setLayoutParams(layoutParams4);
        }
        this.gtN.setVisibility(0);
        this.gtO.setVisibility(0);
        if (this.gtL != null) {
            this.gtL.setVisibility(8);
        }
        if (this.gtJ != null) {
            this.gtJ.setVisibility(8);
        }
    }

    public void I(int i, boolean z) {
        FrameLayout.LayoutParams layoutParams;
        if (this.gtO != null) {
            if (this.gtO.getLayoutParams() != null && (this.gtO.getLayoutParams() instanceof FrameLayout.LayoutParams)) {
                layoutParams = (FrameLayout.LayoutParams) this.gtO.getLayoutParams();
            } else {
                layoutParams = new FrameLayout.LayoutParams(-2, -2);
            }
            if (i == 2) {
                layoutParams.topMargin = getResources().getDimensionPixelSize(a.e.sdk_ds45);
                layoutParams.gravity = 1;
                this.gtO.setLayoutParams(layoutParams);
                return;
            }
            layoutParams.topMargin = lA(z);
            layoutParams.gravity = 1;
            this.gtO.setLayoutParams(layoutParams);
        }
    }

    public void bKa() {
        if (this.gtN != null && this.gtN.getParent() != null) {
            ((ViewGroup) this.gtN.getParent()).removeView(this.gtN);
        }
        if (this.gtL != null) {
            this.gtL.setVisibility(0);
        }
        if (this.gtJ != null) {
            this.gtJ.setVisibility(0);
        }
    }

    public boolean bKb() {
        return (this.gtN == null || this.gtN.getParent() == null) ? false : true;
    }

    private int lA(boolean z) {
        if (z) {
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                return UtilHelper.getStatusBarHeight();
            }
            return 0;
        }
        return this.mPageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds160);
    }

    public void bKc() {
        View findViewWithTag = findViewWithTag("AlaLivePraiseGuideController");
        if (findViewWithTag != null) {
            removeView(findViewWithTag);
        }
    }
}
