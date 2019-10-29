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
import com.baidu.live.k.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.core.util.ViewCommonUtil;
import com.baidu.live.tbadk.widget.TbImageView;
/* loaded from: classes6.dex */
public class AlaLiveRoomBlurPageLayout extends FrameLayout {
    Runnable aau;
    private AlaLiveView eiU;
    private TbImageView erb;
    private FrameLayout erc;
    private View erd;
    private View ere;
    private FrameLayout erf;
    private TextView erg;
    private Bitmap erh;
    private Handler mHandler;
    private TbPageContext mPageContext;
    private ViewGroup mRootView;

    public AlaLiveRoomBlurPageLayout(Context context) {
        super(context);
        this.erb = null;
        this.erd = null;
        this.eiU = null;
        this.ere = null;
        this.erf = null;
        this.erg = null;
        this.aau = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveRoomBlurPageLayout.1
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
                        AlaLiveRoomBlurPageLayout.this.erb.setAlpha(0.0f);
                        AlaLiveRoomBlurPageLayout.this.erb.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                AlaLiveRoomBlurPageLayout.this.erb.clearAnimation();
                AlaLiveRoomBlurPageLayout.this.erb.startAnimation(alphaAnimation);
            }
        };
        init();
    }

    public AlaLiveRoomBlurPageLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.erb = null;
        this.erd = null;
        this.eiU = null;
        this.ere = null;
        this.erf = null;
        this.erg = null;
        this.aau = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveRoomBlurPageLayout.1
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
                        AlaLiveRoomBlurPageLayout.this.erb.setAlpha(0.0f);
                        AlaLiveRoomBlurPageLayout.this.erb.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                AlaLiveRoomBlurPageLayout.this.erb.clearAnimation();
                AlaLiveRoomBlurPageLayout.this.erb.startAnimation(alphaAnimation);
            }
        };
        init();
    }

    public AlaLiveRoomBlurPageLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.erb = null;
        this.erd = null;
        this.eiU = null;
        this.ere = null;
        this.erf = null;
        this.erg = null;
        this.aau = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveRoomBlurPageLayout.1
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
                        AlaLiveRoomBlurPageLayout.this.erb.setAlpha(0.0f);
                        AlaLiveRoomBlurPageLayout.this.erb.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                AlaLiveRoomBlurPageLayout.this.erb.clearAnimation();
                AlaLiveRoomBlurPageLayout.this.erb.startAnimation(alphaAnimation);
            }
        };
        init();
    }

    private void init() {
        Log.i("LiveRoomBlurPageLayout", "@@ context = " + getContext());
        this.mRootView = (ViewGroup) View.inflate(getContext(), a.h.ala_liveroom_audience_blur_layout, this);
        setClipChildren(false);
        this.erb = (TbImageView) findViewById(a.g.ala_liveroom_background_img);
        this.erh = drawableToBitmap(new ColorDrawable(getResources().getColor(a.d.sdk_color_333333)));
        this.erc = new FrameLayout(getContext());
        this.erc.setId(a.g.ala_liveroom_player_container_view);
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
        be(screenFullSize[0], screenFullSize[1]);
    }

    private void be(int i, int i2) {
        if (this.erb != null) {
            ViewGroup.LayoutParams layoutParams = this.erb.getLayoutParams();
            layoutParams.width = i;
            layoutParams.height = i2;
            this.erb.setLayoutParams(layoutParams);
        }
    }

    public void aO(int i, int i2) {
        be(i, i2);
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (configuration != null) {
            int[] screenFullSize = ViewCommonUtil.getScreenFullSize(this.mPageContext.getPageActivity());
            if (this.erf != null && this.erf.getParent() != null) {
                ViewGroup.LayoutParams layoutParams = this.erf.getLayoutParams();
                layoutParams.width = screenFullSize[0];
                layoutParams.height = screenFullSize[1] - 0;
                this.erf.setLayoutParams(layoutParams);
            }
        }
    }

    public void a(AlaLiveView alaLiveView, ViewGroup.LayoutParams layoutParams) {
        if (alaLiveView != null) {
            if (this.mRootView.indexOfChild(alaLiveView) < 0 && this.mRootView.getChildCount() > 1) {
                this.eiU = alaLiveView;
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
            aWD();
        }
    }

    public void aWy() {
        if (this.eiU != null) {
            this.mRootView.removeView(this.eiU);
        }
        this.eiU = null;
    }

    public void a(View view, ViewGroup.LayoutParams layoutParams, boolean z) {
        if (this.erc.getParent() != null) {
            this.mRootView.removeView(this.erc);
        }
        this.mRootView.addView(this.erc, 1);
        if (this.erd != null && this.erd.getParent() != null) {
            ((ViewGroup) this.erd.getParent()).removeView(this.erd);
        }
        this.erd = view;
        if (this.erd != null && this.erd.getParent() != null) {
            ((ViewGroup) this.erd.getParent()).removeView(this.erd);
        }
        if (this.erd != null) {
            if (layoutParams != null) {
                this.erc.addView(this.erd, layoutParams);
            } else {
                this.erc.addView(this.erd, this.erd.getLayoutParams());
            }
        }
    }

    public void aRM() {
        if (this.erc.getParent() != null) {
            ((ViewGroup) this.erc.getParent()).removeView(this.erc);
        }
        if (this.erd != null && this.erd.getParent() != null) {
            ((ViewGroup) this.erd.getParent()).removeView(this.erd);
        }
        this.erd = null;
    }

    public boolean bA(View view) {
        return (this.erc == null || this.erc.getParent() == null || this.erc.indexOfChild(view) < 0) ? false : true;
    }

    public void b(View view, ViewGroup.LayoutParams layoutParams) {
        if (this.ere != null && this.mRootView.indexOfChild(this.ere) >= 0) {
            this.mRootView.removeView(this.ere);
        }
        this.ere = view;
        int childCount = this.mRootView.getChildCount() - 1;
        int childCount2 = this.mRootView.getChildCount();
        int i = childCount;
        for (int i2 = 0; i2 < childCount2; i2++) {
            if (this.mRootView.getChildAt(i2).getId() == a.g.ala_live_room_close_btn_layout) {
                i = Math.max(i, i2);
            }
        }
        if (this.ere != null) {
            this.mRootView.addView(this.ere, i, layoutParams);
        }
        aWD();
    }

    public void aWz() {
        if (this.ere != null) {
            this.mRootView.removeView(this.ere);
        }
        this.ere = null;
    }

    public void aWA() {
        if (this.erb.getAlpha() == 1.0f) {
            this.erb.clearAnimation();
            this.mHandler.postDelayed(this.aau, 300L);
            return;
        }
        this.erb.clearAnimation();
        this.erb.setAlpha(0.0f);
        this.erb.setVisibility(8);
    }

    public void aWB() {
        this.mHandler.removeCallbacks(this.aau);
        this.erb.clearAnimation();
        this.erb.setAlpha(0.0f);
        this.erb.setVisibility(8);
    }

    public void aWC() {
        this.mHandler.removeCallbacks(this.aau);
        this.erb.clearAnimation();
        this.erb.setAlpha(1.0f);
        this.erb.setVisibility(0);
    }

    public void setBackImageBlack(AlaLiveInfoData alaLiveInfoData) {
        if ((alaLiveInfoData == null || alaLiveInfoData.screen_direction != 2) && this.erb != null) {
            this.erb.setImageDrawable(null);
            this.erb.setBackgroundColor(this.mPageContext.getResources().getColor(a.d.sdk_transparent));
        }
    }

    public void setBgImageUrl(String str, int i, AlaLiveInfoData alaLiveInfoData) {
        if (this.mPageContext != null && !TextUtils.isEmpty(str)) {
            int[] screenFullSize = ViewCommonUtil.getScreenFullSize(this.mPageContext.getPageActivity());
            be(screenFullSize[0], screenFullSize[1]);
            if (alaLiveInfoData != null && alaLiveInfoData.screen_direction == 2) {
                this.erb.setImageBitmap(this.erh);
            } else if (!TextUtils.isEmpty(str)) {
                this.erb.startLoad(str, 39, false, false);
            } else {
                this.erb.setBackgroundResource(a.f.pic_avatar_moren);
            }
        }
    }

    public void setBgImageUrl(String str, AlaLiveInfoData alaLiveInfoData) {
        setBgImageUrl(str, 10, alaLiveInfoData);
    }

    public void release() {
        if (this.erb != null) {
            this.erb.setImageDrawable(null);
            this.erb.stopLoad();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (this.eiU != null && !this.eiU.eru) {
            z = this.eiU.z(motionEvent);
        }
        if (z || motionEvent.getAction() == 0) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void ik(boolean z) {
        Context context = getContext();
        if (this.erg == null) {
            this.erf = new FrameLayout(context);
            this.erf.setBackgroundColor(getContext().getResources().getColor(a.d.sdk_cp_cont_b));
            this.erg = new TextView(context);
            this.erg.setText(context.getResources().getString(a.i.ala_live_private_tip));
            this.erg.setTextSize(0, context.getResources().getDimensionPixelSize(a.e.sdk_ds28));
            this.erg.setTextColor(context.getResources().getColor(a.d.sdk_cp_cont_i_alpha40));
            this.erg.setGravity(49);
            Drawable drawable = context.getResources().getDrawable(a.f.private_tip);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            this.erg.setCompoundDrawables(null, drawable, null, null);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.topMargin = il(z);
            layoutParams.gravity = 1;
            this.erf.addView(this.erg, layoutParams);
            int indexOfChild = this.eiU != null ? this.mRootView.indexOfChild(this.eiU) : -1;
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
            int[] screenFullSize = ViewCommonUtil.getScreenFullSize(this.mPageContext.getPageActivity());
            int statusBarHeight = !UtilHelper.canUseStyleImmersiveSticky() ? UtilHelper.getStatusBarHeight() : 0;
            layoutParams2.width = screenFullSize[0];
            layoutParams2.height = screenFullSize[1] - statusBarHeight;
            if (indexOfChild < 0) {
                this.mRootView.addView(this.erf, layoutParams2);
            } else {
                this.mRootView.addView(this.erf, indexOfChild, layoutParams2);
            }
        } else {
            if (this.erf.getParent() != null) {
                this.mRootView.removeView(this.erf);
            }
            int indexOfChild2 = this.eiU != null ? this.mRootView.indexOfChild(this.eiU) : -1;
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -1);
            int[] screenFullSize2 = ViewCommonUtil.getScreenFullSize(this.mPageContext.getPageActivity());
            int statusBarHeight2 = !UtilHelper.canUseStyleImmersiveSticky() ? UtilHelper.getStatusBarHeight() : 0;
            layoutParams3.width = screenFullSize2[0];
            layoutParams3.height = screenFullSize2[1] - statusBarHeight2;
            if (indexOfChild2 < 0) {
                this.mRootView.addView(this.erf, layoutParams3);
            } else {
                this.mRootView.addView(this.erf, indexOfChild2, layoutParams3);
            }
            FrameLayout.LayoutParams layoutParams4 = (FrameLayout.LayoutParams) this.erg.getLayoutParams();
            layoutParams4.topMargin = il(z);
            this.erg.setLayoutParams(layoutParams4);
        }
        this.erf.setVisibility(0);
        this.erg.setVisibility(0);
        if (this.erd != null) {
            this.erd.setVisibility(8);
        }
        if (this.erb != null) {
            this.erb.setVisibility(8);
        }
    }

    public void z(int i, boolean z) {
        FrameLayout.LayoutParams layoutParams;
        if (this.erg != null) {
            if (this.erg.getLayoutParams() != null && (this.erg.getLayoutParams() instanceof FrameLayout.LayoutParams)) {
                layoutParams = (FrameLayout.LayoutParams) this.erg.getLayoutParams();
            } else {
                layoutParams = new FrameLayout.LayoutParams(-2, -2);
            }
            if (i == 2) {
                layoutParams.topMargin = getResources().getDimensionPixelSize(a.e.sdk_ds45);
                layoutParams.gravity = 1;
                this.erg.setLayoutParams(layoutParams);
                return;
            }
            layoutParams.topMargin = il(z);
            layoutParams.gravity = 1;
            this.erg.setLayoutParams(layoutParams);
        }
    }

    public void aWD() {
        if (this.erf != null && this.erf.getParent() != null) {
            ((ViewGroup) this.erf.getParent()).removeView(this.erf);
        }
        if (this.erd != null) {
            this.erd.setVisibility(0);
        }
        if (this.erb != null) {
            this.erb.setVisibility(0);
        }
    }

    public boolean aWE() {
        return (this.erf == null || this.erf.getParent() == null) ? false : true;
    }

    private int il(boolean z) {
        if (z) {
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                return UtilHelper.getStatusBarHeight();
            }
            return 0;
        }
        return this.mPageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds160);
    }

    public void aWF() {
        View findViewWithTag = findViewWithTag("AlaLivePraiseGuideController");
        if (findViewWithTag != null) {
            removeView(findViewWithTag);
        }
    }
}
