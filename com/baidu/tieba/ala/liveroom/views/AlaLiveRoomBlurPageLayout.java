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
import com.baidu.live.r.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.core.util.ViewCommonUtil;
import com.baidu.live.tbadk.widget.TbImageView;
/* loaded from: classes2.dex */
public class AlaLiveRoomBlurPageLayout extends FrameLayout {
    Runnable aiM;
    private AlaLiveView faQ;
    private TbImageView fjQ;
    private FrameLayout fjR;
    private View fjS;
    private View fjT;
    private FrameLayout fjU;
    private TextView fjV;
    private Bitmap fjW;
    private Handler mHandler;
    private TbPageContext mPageContext;
    private ViewGroup mRootView;

    public AlaLiveRoomBlurPageLayout(Context context) {
        super(context);
        this.fjQ = null;
        this.fjS = null;
        this.faQ = null;
        this.fjT = null;
        this.fjU = null;
        this.fjV = null;
        this.aiM = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveRoomBlurPageLayout.1
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
                        AlaLiveRoomBlurPageLayout.this.fjQ.setAlpha(0.0f);
                        AlaLiveRoomBlurPageLayout.this.fjQ.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                AlaLiveRoomBlurPageLayout.this.fjQ.clearAnimation();
                AlaLiveRoomBlurPageLayout.this.fjQ.startAnimation(alphaAnimation);
            }
        };
        init();
    }

    public AlaLiveRoomBlurPageLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fjQ = null;
        this.fjS = null;
        this.faQ = null;
        this.fjT = null;
        this.fjU = null;
        this.fjV = null;
        this.aiM = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveRoomBlurPageLayout.1
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
                        AlaLiveRoomBlurPageLayout.this.fjQ.setAlpha(0.0f);
                        AlaLiveRoomBlurPageLayout.this.fjQ.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                AlaLiveRoomBlurPageLayout.this.fjQ.clearAnimation();
                AlaLiveRoomBlurPageLayout.this.fjQ.startAnimation(alphaAnimation);
            }
        };
        init();
    }

    public AlaLiveRoomBlurPageLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fjQ = null;
        this.fjS = null;
        this.faQ = null;
        this.fjT = null;
        this.fjU = null;
        this.fjV = null;
        this.aiM = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveRoomBlurPageLayout.1
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
                        AlaLiveRoomBlurPageLayout.this.fjQ.setAlpha(0.0f);
                        AlaLiveRoomBlurPageLayout.this.fjQ.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                AlaLiveRoomBlurPageLayout.this.fjQ.clearAnimation();
                AlaLiveRoomBlurPageLayout.this.fjQ.startAnimation(alphaAnimation);
            }
        };
        init();
    }

    private void init() {
        Log.i("LiveRoomBlurPageLayout", "@@ context = " + getContext());
        this.mRootView = (ViewGroup) View.inflate(getContext(), a.h.ala_liveroom_audience_blur_layout, this);
        setClipChildren(false);
        this.fjQ = (TbImageView) findViewById(a.g.ala_liveroom_background_img);
        this.fjW = drawableToBitmap(new ColorDrawable(getResources().getColor(a.d.sdk_color_333333)));
        this.fjR = new FrameLayout(getContext());
        this.fjR.setId(a.g.ala_liveroom_player_container_view);
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
        br(screenFullSize[0], screenFullSize[1]);
    }

    private void br(int i, int i2) {
        if (this.fjQ != null) {
            ViewGroup.LayoutParams layoutParams = this.fjQ.getLayoutParams();
            layoutParams.width = i;
            layoutParams.height = i2;
            this.fjQ.setLayoutParams(layoutParams);
        }
    }

    public void bg(int i, int i2) {
        br(i, i2);
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (configuration != null) {
            int[] screenFullSize = ViewCommonUtil.getScreenFullSize(this.mPageContext.getPageActivity());
            if (this.fjU != null && this.fjU.getParent() != null) {
                ViewGroup.LayoutParams layoutParams = this.fjU.getLayoutParams();
                layoutParams.width = screenFullSize[0];
                layoutParams.height = screenFullSize[1] - 0;
                this.fjU.setLayoutParams(layoutParams);
            }
        }
    }

    public void a(AlaLiveView alaLiveView, ViewGroup.LayoutParams layoutParams) {
        if (alaLiveView != null) {
            if (this.mRootView.indexOfChild(alaLiveView) < 0 && this.mRootView.getChildCount() > 1) {
                this.faQ = alaLiveView;
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
            bpp();
        }
    }

    public void bpk() {
        if (this.faQ != null) {
            this.mRootView.removeView(this.faQ);
        }
        this.faQ = null;
    }

    public void a(View view, ViewGroup.LayoutParams layoutParams, boolean z) {
        if (this.fjR.getParent() != null) {
            this.mRootView.removeView(this.fjR);
        }
        this.mRootView.addView(this.fjR, 1);
        if (this.fjS != null && this.fjS.getParent() != null) {
            ((ViewGroup) this.fjS.getParent()).removeView(this.fjS);
        }
        this.fjS = view;
        if (this.fjS != null && this.fjS.getParent() != null) {
            ((ViewGroup) this.fjS.getParent()).removeView(this.fjS);
        }
        if (this.fjS != null) {
            if (layoutParams != null) {
                this.fjR.addView(this.fjS, layoutParams);
            } else {
                this.fjR.addView(this.fjS, this.fjS.getLayoutParams());
            }
        }
    }

    public void bjX() {
        if (this.fjR.getParent() != null) {
            ((ViewGroup) this.fjR.getParent()).removeView(this.fjR);
        }
        if (this.fjS != null && this.fjS.getParent() != null) {
            ((ViewGroup) this.fjS.getParent()).removeView(this.fjS);
        }
        this.fjS = null;
    }

    public boolean bC(View view) {
        return (this.fjR == null || this.fjR.getParent() == null || this.fjR.indexOfChild(view) < 0) ? false : true;
    }

    public void b(View view, ViewGroup.LayoutParams layoutParams) {
        if (this.fjT != null && this.mRootView.indexOfChild(this.fjT) >= 0) {
            this.mRootView.removeView(this.fjT);
        }
        this.fjT = view;
        int childCount = this.mRootView.getChildCount() - 1;
        int childCount2 = this.mRootView.getChildCount();
        int i = childCount;
        for (int i2 = 0; i2 < childCount2; i2++) {
            if (this.mRootView.getChildAt(i2).getId() == a.g.ala_live_room_close_btn_layout) {
                i = Math.max(i, i2);
            }
        }
        if (this.fjT != null) {
            this.mRootView.addView(this.fjT, i, layoutParams);
        }
        bpp();
    }

    public void bpl() {
        if (this.fjT != null) {
            this.mRootView.removeView(this.fjT);
        }
        this.fjT = null;
    }

    public void bpm() {
        if (this.fjQ.getAlpha() == 1.0f) {
            this.fjQ.clearAnimation();
            this.mHandler.postDelayed(this.aiM, 300L);
            return;
        }
        this.fjQ.clearAnimation();
        this.fjQ.setAlpha(0.0f);
        this.fjQ.setVisibility(8);
    }

    public void bpn() {
        this.mHandler.removeCallbacks(this.aiM);
        this.fjQ.clearAnimation();
        this.fjQ.setAlpha(0.0f);
        this.fjQ.setVisibility(8);
    }

    public void bpo() {
        this.mHandler.removeCallbacks(this.aiM);
        this.fjQ.clearAnimation();
        this.fjQ.setAlpha(1.0f);
        this.fjQ.setVisibility(0);
    }

    public void setBackImageBlack(AlaLiveInfoData alaLiveInfoData) {
        if ((alaLiveInfoData == null || alaLiveInfoData.screen_direction != 2) && this.fjQ != null) {
            this.fjQ.setImageDrawable(null);
            this.fjQ.setBackgroundColor(this.mPageContext.getResources().getColor(a.d.sdk_transparent));
        }
    }

    public void setBgImageUrl(String str, int i, AlaLiveInfoData alaLiveInfoData) {
        if (this.mPageContext != null && !TextUtils.isEmpty(str)) {
            int[] screenFullSize = ViewCommonUtil.getScreenFullSize(this.mPageContext.getPageActivity());
            br(screenFullSize[0], screenFullSize[1]);
            if (alaLiveInfoData != null && alaLiveInfoData.screen_direction == 2) {
                this.fjQ.setImageBitmap(this.fjW);
            } else if (!TextUtils.isEmpty(str)) {
                this.fjQ.startLoad(str, 39, false, false);
            } else {
                this.fjQ.setBackgroundResource(a.f.pic_avatar_moren);
            }
        }
    }

    public void setBgImageUrl(String str, AlaLiveInfoData alaLiveInfoData) {
        setBgImageUrl(str, 10, alaLiveInfoData);
    }

    public void release() {
        if (this.fjQ != null) {
            this.fjQ.setImageDrawable(null);
            this.fjQ.stopLoad();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (this.faQ != null && !this.faQ.isDestroy) {
            z = this.faQ.z(motionEvent);
        }
        if (z || motionEvent.getAction() == 0) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void jM(boolean z) {
        Context context = getContext();
        if (this.fjV == null) {
            this.fjU = new FrameLayout(context);
            this.fjU.setBackgroundColor(getContext().getResources().getColor(a.d.sdk_cp_cont_b));
            this.fjV = new TextView(context);
            this.fjV.setText(context.getResources().getString(a.i.ala_live_private_tip));
            this.fjV.setTextSize(0, context.getResources().getDimensionPixelSize(a.e.sdk_ds28));
            this.fjV.setTextColor(context.getResources().getColor(a.d.sdk_cp_cont_i_alpha40));
            this.fjV.setGravity(49);
            Drawable drawable = context.getResources().getDrawable(a.f.private_tip);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            this.fjV.setCompoundDrawables(null, drawable, null, null);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.topMargin = jN(z);
            layoutParams.gravity = 1;
            this.fjU.addView(this.fjV, layoutParams);
            int indexOfChild = this.faQ != null ? this.mRootView.indexOfChild(this.faQ) : -1;
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
            int[] screenFullSize = ViewCommonUtil.getScreenFullSize(this.mPageContext.getPageActivity());
            int statusBarHeight = !UtilHelper.canUseStyleImmersiveSticky() ? UtilHelper.getStatusBarHeight() : 0;
            layoutParams2.width = screenFullSize[0];
            layoutParams2.height = screenFullSize[1] - statusBarHeight;
            if (indexOfChild < 0) {
                this.mRootView.addView(this.fjU, layoutParams2);
            } else {
                this.mRootView.addView(this.fjU, indexOfChild, layoutParams2);
            }
        } else {
            if (this.fjU.getParent() != null) {
                this.mRootView.removeView(this.fjU);
            }
            int indexOfChild2 = this.faQ != null ? this.mRootView.indexOfChild(this.faQ) : -1;
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -1);
            int[] screenFullSize2 = ViewCommonUtil.getScreenFullSize(this.mPageContext.getPageActivity());
            int statusBarHeight2 = !UtilHelper.canUseStyleImmersiveSticky() ? UtilHelper.getStatusBarHeight() : 0;
            layoutParams3.width = screenFullSize2[0];
            layoutParams3.height = screenFullSize2[1] - statusBarHeight2;
            if (indexOfChild2 < 0) {
                this.mRootView.addView(this.fjU, layoutParams3);
            } else {
                this.mRootView.addView(this.fjU, indexOfChild2, layoutParams3);
            }
            FrameLayout.LayoutParams layoutParams4 = (FrameLayout.LayoutParams) this.fjV.getLayoutParams();
            layoutParams4.topMargin = jN(z);
            this.fjV.setLayoutParams(layoutParams4);
        }
        this.fjU.setVisibility(0);
        this.fjV.setVisibility(0);
        if (this.fjS != null) {
            this.fjS.setVisibility(8);
        }
        if (this.fjQ != null) {
            this.fjQ.setVisibility(8);
        }
    }

    public void B(int i, boolean z) {
        FrameLayout.LayoutParams layoutParams;
        if (this.fjV != null) {
            if (this.fjV.getLayoutParams() != null && (this.fjV.getLayoutParams() instanceof FrameLayout.LayoutParams)) {
                layoutParams = (FrameLayout.LayoutParams) this.fjV.getLayoutParams();
            } else {
                layoutParams = new FrameLayout.LayoutParams(-2, -2);
            }
            if (i == 2) {
                layoutParams.topMargin = getResources().getDimensionPixelSize(a.e.sdk_ds45);
                layoutParams.gravity = 1;
                this.fjV.setLayoutParams(layoutParams);
                return;
            }
            layoutParams.topMargin = jN(z);
            layoutParams.gravity = 1;
            this.fjV.setLayoutParams(layoutParams);
        }
    }

    public void bpp() {
        if (this.fjU != null && this.fjU.getParent() != null) {
            ((ViewGroup) this.fjU.getParent()).removeView(this.fjU);
        }
        if (this.fjS != null) {
            this.fjS.setVisibility(0);
        }
        if (this.fjQ != null) {
            this.fjQ.setVisibility(0);
        }
    }

    public boolean bpq() {
        return (this.fjU == null || this.fjU.getParent() == null) ? false : true;
    }

    private int jN(boolean z) {
        if (z) {
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                return UtilHelper.getStatusBarHeight();
            }
            return 0;
        }
        return this.mPageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds160);
    }

    public void bpr() {
        View findViewWithTag = findViewWithTag("AlaLivePraiseGuideController");
        if (findViewWithTag != null) {
            removeView(findViewWithTag);
        }
    }
}
