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
    Runnable akT;
    private AlaLiveView fep;
    private TbImageView fmY;
    private FrameLayout fmZ;
    private View fna;
    private View fnb;
    private FrameLayout fnc;
    private TextView fnd;
    private Bitmap fne;
    private Handler mHandler;
    private TbPageContext mPageContext;
    private ViewGroup mRootView;

    public AlaLiveRoomBlurPageLayout(Context context) {
        super(context);
        this.fmY = null;
        this.fna = null;
        this.fep = null;
        this.fnb = null;
        this.fnc = null;
        this.fnd = null;
        this.akT = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveRoomBlurPageLayout.1
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
                        AlaLiveRoomBlurPageLayout.this.fmY.setAlpha(0.0f);
                        AlaLiveRoomBlurPageLayout.this.fmY.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                AlaLiveRoomBlurPageLayout.this.fmY.clearAnimation();
                AlaLiveRoomBlurPageLayout.this.fmY.startAnimation(alphaAnimation);
            }
        };
        init();
    }

    public AlaLiveRoomBlurPageLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fmY = null;
        this.fna = null;
        this.fep = null;
        this.fnb = null;
        this.fnc = null;
        this.fnd = null;
        this.akT = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveRoomBlurPageLayout.1
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
                        AlaLiveRoomBlurPageLayout.this.fmY.setAlpha(0.0f);
                        AlaLiveRoomBlurPageLayout.this.fmY.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                AlaLiveRoomBlurPageLayout.this.fmY.clearAnimation();
                AlaLiveRoomBlurPageLayout.this.fmY.startAnimation(alphaAnimation);
            }
        };
        init();
    }

    public AlaLiveRoomBlurPageLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fmY = null;
        this.fna = null;
        this.fep = null;
        this.fnb = null;
        this.fnc = null;
        this.fnd = null;
        this.akT = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveRoomBlurPageLayout.1
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
                        AlaLiveRoomBlurPageLayout.this.fmY.setAlpha(0.0f);
                        AlaLiveRoomBlurPageLayout.this.fmY.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                AlaLiveRoomBlurPageLayout.this.fmY.clearAnimation();
                AlaLiveRoomBlurPageLayout.this.fmY.startAnimation(alphaAnimation);
            }
        };
        init();
    }

    private void init() {
        Log.i("LiveRoomBlurPageLayout", "@@ context = " + getContext());
        this.mRootView = (ViewGroup) View.inflate(getContext(), a.h.ala_liveroom_audience_blur_layout, this);
        setClipChildren(false);
        this.fmY = (TbImageView) findViewById(a.g.ala_liveroom_background_img);
        this.fne = drawableToBitmap(new ColorDrawable(getResources().getColor(a.d.sdk_color_333333)));
        this.fmZ = new FrameLayout(getContext());
        this.fmZ.setId(a.g.ala_liveroom_player_container_view);
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
        if (this.fmY != null) {
            ViewGroup.LayoutParams layoutParams = this.fmY.getLayoutParams();
            layoutParams.width = i;
            layoutParams.height = i2;
            this.fmY.setLayoutParams(layoutParams);
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
            if (this.fnc != null && this.fnc.getParent() != null) {
                ViewGroup.LayoutParams layoutParams = this.fnc.getLayoutParams();
                layoutParams.width = screenFullSize[0];
                layoutParams.height = screenFullSize[1] - 0;
                this.fnc.setLayoutParams(layoutParams);
            }
        }
    }

    public void a(AlaLiveView alaLiveView, ViewGroup.LayoutParams layoutParams) {
        if (alaLiveView != null) {
            if (this.mRootView.indexOfChild(alaLiveView) < 0 && this.mRootView.getChildCount() > 1) {
                this.fep = alaLiveView;
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
            bqY();
        }
    }

    public void bqT() {
        if (this.fep != null) {
            this.mRootView.removeView(this.fep);
        }
        this.fep = null;
    }

    @Override // com.baidu.live.o.d
    public ViewGroup getLiveContainerView() {
        return this;
    }

    public void a(View view, ViewGroup.LayoutParams layoutParams, boolean z) {
        if (this.fmZ.getParent() != null) {
            this.mRootView.removeView(this.fmZ);
        }
        this.mRootView.addView(this.fmZ, 1);
        if (this.fna != null && this.fna.getParent() != null) {
            ((ViewGroup) this.fna.getParent()).removeView(this.fna);
        }
        this.fna = view;
        if (this.fna != null && this.fna.getParent() != null) {
            ((ViewGroup) this.fna.getParent()).removeView(this.fna);
        }
        if (this.fna != null) {
            if (layoutParams != null) {
                this.fmZ.addView(this.fna, layoutParams);
            } else {
                this.fmZ.addView(this.fna, this.fna.getLayoutParams());
            }
        }
    }

    public void blO() {
        if (this.fmZ.getParent() != null) {
            ((ViewGroup) this.fmZ.getParent()).removeView(this.fmZ);
        }
        if (this.fna != null && this.fna.getParent() != null) {
            ((ViewGroup) this.fna.getParent()).removeView(this.fna);
        }
        this.fna = null;
    }

    public boolean bC(View view) {
        return (this.fmZ == null || this.fmZ.getParent() == null || this.fmZ.indexOfChild(view) < 0) ? false : true;
    }

    public void b(View view, ViewGroup.LayoutParams layoutParams) {
        if (this.fnb != null && this.mRootView.indexOfChild(this.fnb) >= 0) {
            this.mRootView.removeView(this.fnb);
        }
        this.fnb = view;
        int childCount = this.mRootView.getChildCount() - 1;
        int childCount2 = this.mRootView.getChildCount();
        int i = childCount;
        for (int i2 = 0; i2 < childCount2; i2++) {
            if (this.mRootView.getChildAt(i2).getId() == a.g.ala_live_room_close_btn_layout) {
                i = Math.max(i, i2);
            }
        }
        if (this.fnb != null) {
            this.mRootView.addView(this.fnb, i, layoutParams);
        }
        bqY();
    }

    public void bqU() {
        if (this.fnb != null) {
            this.mRootView.removeView(this.fnb);
        }
        this.fnb = null;
    }

    public void bqV() {
        if (this.fmY.getAlpha() == 1.0f) {
            this.fmY.clearAnimation();
            this.mHandler.postDelayed(this.akT, 300L);
            return;
        }
        this.fmY.clearAnimation();
        this.fmY.setAlpha(0.0f);
        this.fmY.setVisibility(8);
    }

    public void bqW() {
        this.mHandler.removeCallbacks(this.akT);
        this.fmY.clearAnimation();
        this.fmY.setAlpha(0.0f);
        this.fmY.setVisibility(8);
    }

    public void bqX() {
        this.mHandler.removeCallbacks(this.akT);
        this.fmY.clearAnimation();
        this.fmY.setAlpha(1.0f);
        this.fmY.setVisibility(0);
    }

    public void setBackImageBlack(AlaLiveInfoData alaLiveInfoData) {
        if ((alaLiveInfoData == null || alaLiveInfoData.screen_direction != 2) && this.fmY != null) {
            this.fmY.setImageDrawable(null);
            this.fmY.setBackgroundColor(this.mPageContext.getResources().getColor(a.d.sdk_transparent));
        }
    }

    public void setBgImageUrl(String str, int i, AlaLiveInfoData alaLiveInfoData) {
        if (this.mPageContext != null && !TextUtils.isEmpty(str)) {
            int[] screenFullSize = ViewCommonUtil.getScreenFullSize(this.mPageContext.getPageActivity());
            bs(screenFullSize[0], screenFullSize[1]);
            if (alaLiveInfoData != null && alaLiveInfoData.screen_direction == 2) {
                this.fmY.setImageBitmap(this.fne);
            } else if (!TextUtils.isEmpty(str)) {
                this.fmY.startLoad(str, 39, false, false);
            } else {
                this.fmY.setBackgroundResource(a.f.pic_avatar_moren);
            }
        }
    }

    public void setBgImageUrl(String str, AlaLiveInfoData alaLiveInfoData) {
        setBgImageUrl(str, 10, alaLiveInfoData);
    }

    public void release() {
        if (this.fmY != null) {
            this.fmY.setImageDrawable(null);
            this.fmY.stopLoad();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (this.fep != null && !this.fep.isDestroy) {
            z = this.fep.z(motionEvent);
        }
        if (z || motionEvent.getAction() == 0) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void jO(boolean z) {
        Context context = getContext();
        if (this.fnd == null) {
            this.fnc = new FrameLayout(context);
            this.fnc.setBackgroundColor(getContext().getResources().getColor(a.d.sdk_cp_cont_b));
            this.fnd = new TextView(context);
            this.fnd.setText(context.getResources().getString(a.i.ala_live_private_tip));
            this.fnd.setTextSize(0, context.getResources().getDimensionPixelSize(a.e.sdk_ds28));
            this.fnd.setTextColor(context.getResources().getColor(a.d.sdk_cp_cont_i_alpha40));
            this.fnd.setGravity(49);
            Drawable drawable = context.getResources().getDrawable(a.f.private_tip);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            this.fnd.setCompoundDrawables(null, drawable, null, null);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.topMargin = jP(z);
            layoutParams.gravity = 1;
            this.fnc.addView(this.fnd, layoutParams);
            int indexOfChild = this.fep != null ? this.mRootView.indexOfChild(this.fep) : -1;
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
            int[] screenFullSize = ViewCommonUtil.getScreenFullSize(this.mPageContext.getPageActivity());
            int statusBarHeight = !UtilHelper.canUseStyleImmersiveSticky() ? UtilHelper.getStatusBarHeight() : 0;
            layoutParams2.width = screenFullSize[0];
            layoutParams2.height = screenFullSize[1] - statusBarHeight;
            if (indexOfChild < 0) {
                this.mRootView.addView(this.fnc, layoutParams2);
            } else {
                this.mRootView.addView(this.fnc, indexOfChild, layoutParams2);
            }
        } else {
            if (this.fnc.getParent() != null) {
                this.mRootView.removeView(this.fnc);
            }
            int indexOfChild2 = this.fep != null ? this.mRootView.indexOfChild(this.fep) : -1;
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -1);
            int[] screenFullSize2 = ViewCommonUtil.getScreenFullSize(this.mPageContext.getPageActivity());
            int statusBarHeight2 = !UtilHelper.canUseStyleImmersiveSticky() ? UtilHelper.getStatusBarHeight() : 0;
            layoutParams3.width = screenFullSize2[0];
            layoutParams3.height = screenFullSize2[1] - statusBarHeight2;
            if (indexOfChild2 < 0) {
                this.mRootView.addView(this.fnc, layoutParams3);
            } else {
                this.mRootView.addView(this.fnc, indexOfChild2, layoutParams3);
            }
            FrameLayout.LayoutParams layoutParams4 = (FrameLayout.LayoutParams) this.fnd.getLayoutParams();
            layoutParams4.topMargin = jP(z);
            this.fnd.setLayoutParams(layoutParams4);
        }
        this.fnc.setVisibility(0);
        this.fnd.setVisibility(0);
        if (this.fna != null) {
            this.fna.setVisibility(8);
        }
        if (this.fmY != null) {
            this.fmY.setVisibility(8);
        }
    }

    public void A(int i, boolean z) {
        FrameLayout.LayoutParams layoutParams;
        if (this.fnd != null) {
            if (this.fnd.getLayoutParams() != null && (this.fnd.getLayoutParams() instanceof FrameLayout.LayoutParams)) {
                layoutParams = (FrameLayout.LayoutParams) this.fnd.getLayoutParams();
            } else {
                layoutParams = new FrameLayout.LayoutParams(-2, -2);
            }
            if (i == 2) {
                layoutParams.topMargin = getResources().getDimensionPixelSize(a.e.sdk_ds45);
                layoutParams.gravity = 1;
                this.fnd.setLayoutParams(layoutParams);
                return;
            }
            layoutParams.topMargin = jP(z);
            layoutParams.gravity = 1;
            this.fnd.setLayoutParams(layoutParams);
        }
    }

    public void bqY() {
        if (this.fnc != null && this.fnc.getParent() != null) {
            ((ViewGroup) this.fnc.getParent()).removeView(this.fnc);
        }
        if (this.fna != null) {
            this.fna.setVisibility(0);
        }
        if (this.fmY != null) {
            this.fmY.setVisibility(0);
        }
    }

    public boolean bqZ() {
        return (this.fnc == null || this.fnc.getParent() == null) ? false : true;
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

    public void bra() {
        View findViewWithTag = findViewWithTag("AlaLivePraiseGuideController");
        if (findViewWithTag != null) {
            removeView(findViewWithTag);
        }
    }
}
