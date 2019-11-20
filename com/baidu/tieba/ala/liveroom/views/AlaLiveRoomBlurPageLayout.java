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
    Runnable aac;
    private AlaLiveView eid;
    private TbImageView eqk;
    private FrameLayout eql;
    private View eqm;
    private View eqn;
    private FrameLayout eqo;
    private TextView eqp;
    private Bitmap eqq;
    private Handler mHandler;
    private TbPageContext mPageContext;
    private ViewGroup mRootView;

    public AlaLiveRoomBlurPageLayout(Context context) {
        super(context);
        this.eqk = null;
        this.eqm = null;
        this.eid = null;
        this.eqn = null;
        this.eqo = null;
        this.eqp = null;
        this.aac = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveRoomBlurPageLayout.1
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
                        AlaLiveRoomBlurPageLayout.this.eqk.setAlpha(0.0f);
                        AlaLiveRoomBlurPageLayout.this.eqk.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                AlaLiveRoomBlurPageLayout.this.eqk.clearAnimation();
                AlaLiveRoomBlurPageLayout.this.eqk.startAnimation(alphaAnimation);
            }
        };
        init();
    }

    public AlaLiveRoomBlurPageLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eqk = null;
        this.eqm = null;
        this.eid = null;
        this.eqn = null;
        this.eqo = null;
        this.eqp = null;
        this.aac = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveRoomBlurPageLayout.1
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
                        AlaLiveRoomBlurPageLayout.this.eqk.setAlpha(0.0f);
                        AlaLiveRoomBlurPageLayout.this.eqk.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                AlaLiveRoomBlurPageLayout.this.eqk.clearAnimation();
                AlaLiveRoomBlurPageLayout.this.eqk.startAnimation(alphaAnimation);
            }
        };
        init();
    }

    public AlaLiveRoomBlurPageLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eqk = null;
        this.eqm = null;
        this.eid = null;
        this.eqn = null;
        this.eqo = null;
        this.eqp = null;
        this.aac = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveRoomBlurPageLayout.1
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
                        AlaLiveRoomBlurPageLayout.this.eqk.setAlpha(0.0f);
                        AlaLiveRoomBlurPageLayout.this.eqk.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                AlaLiveRoomBlurPageLayout.this.eqk.clearAnimation();
                AlaLiveRoomBlurPageLayout.this.eqk.startAnimation(alphaAnimation);
            }
        };
        init();
    }

    private void init() {
        Log.i("LiveRoomBlurPageLayout", "@@ context = " + getContext());
        this.mRootView = (ViewGroup) View.inflate(getContext(), a.h.ala_liveroom_audience_blur_layout, this);
        setClipChildren(false);
        this.eqk = (TbImageView) findViewById(a.g.ala_liveroom_background_img);
        this.eqq = drawableToBitmap(new ColorDrawable(getResources().getColor(a.d.sdk_color_333333)));
        this.eql = new FrameLayout(getContext());
        this.eql.setId(a.g.ala_liveroom_player_container_view);
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
        bc(screenFullSize[0], screenFullSize[1]);
    }

    private void bc(int i, int i2) {
        if (this.eqk != null) {
            ViewGroup.LayoutParams layoutParams = this.eqk.getLayoutParams();
            layoutParams.width = i;
            layoutParams.height = i2;
            this.eqk.setLayoutParams(layoutParams);
        }
    }

    public void aM(int i, int i2) {
        bc(i, i2);
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (configuration != null) {
            int[] screenFullSize = ViewCommonUtil.getScreenFullSize(this.mPageContext.getPageActivity());
            if (this.eqo != null && this.eqo.getParent() != null) {
                ViewGroup.LayoutParams layoutParams = this.eqo.getLayoutParams();
                layoutParams.width = screenFullSize[0];
                layoutParams.height = screenFullSize[1] - 0;
                this.eqo.setLayoutParams(layoutParams);
            }
        }
    }

    public void a(AlaLiveView alaLiveView, ViewGroup.LayoutParams layoutParams) {
        if (alaLiveView != null) {
            if (this.mRootView.indexOfChild(alaLiveView) < 0 && this.mRootView.getChildCount() > 1) {
                this.eid = alaLiveView;
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
            aWB();
        }
    }

    public void aWw() {
        if (this.eid != null) {
            this.mRootView.removeView(this.eid);
        }
        this.eid = null;
    }

    public void a(View view, ViewGroup.LayoutParams layoutParams, boolean z) {
        if (this.eql.getParent() != null) {
            this.mRootView.removeView(this.eql);
        }
        this.mRootView.addView(this.eql, 1);
        if (this.eqm != null && this.eqm.getParent() != null) {
            ((ViewGroup) this.eqm.getParent()).removeView(this.eqm);
        }
        this.eqm = view;
        if (this.eqm != null && this.eqm.getParent() != null) {
            ((ViewGroup) this.eqm.getParent()).removeView(this.eqm);
        }
        if (this.eqm != null) {
            if (layoutParams != null) {
                this.eql.addView(this.eqm, layoutParams);
            } else {
                this.eql.addView(this.eqm, this.eqm.getLayoutParams());
            }
        }
    }

    public void aRK() {
        if (this.eql.getParent() != null) {
            ((ViewGroup) this.eql.getParent()).removeView(this.eql);
        }
        if (this.eqm != null && this.eqm.getParent() != null) {
            ((ViewGroup) this.eqm.getParent()).removeView(this.eqm);
        }
        this.eqm = null;
    }

    public boolean bA(View view) {
        return (this.eql == null || this.eql.getParent() == null || this.eql.indexOfChild(view) < 0) ? false : true;
    }

    public void b(View view, ViewGroup.LayoutParams layoutParams) {
        if (this.eqn != null && this.mRootView.indexOfChild(this.eqn) >= 0) {
            this.mRootView.removeView(this.eqn);
        }
        this.eqn = view;
        int childCount = this.mRootView.getChildCount() - 1;
        int childCount2 = this.mRootView.getChildCount();
        int i = childCount;
        for (int i2 = 0; i2 < childCount2; i2++) {
            if (this.mRootView.getChildAt(i2).getId() == a.g.ala_live_room_close_btn_layout) {
                i = Math.max(i, i2);
            }
        }
        if (this.eqn != null) {
            this.mRootView.addView(this.eqn, i, layoutParams);
        }
        aWB();
    }

    public void aWx() {
        if (this.eqn != null) {
            this.mRootView.removeView(this.eqn);
        }
        this.eqn = null;
    }

    public void aWy() {
        if (this.eqk.getAlpha() == 1.0f) {
            this.eqk.clearAnimation();
            this.mHandler.postDelayed(this.aac, 300L);
            return;
        }
        this.eqk.clearAnimation();
        this.eqk.setAlpha(0.0f);
        this.eqk.setVisibility(8);
    }

    public void aWz() {
        this.mHandler.removeCallbacks(this.aac);
        this.eqk.clearAnimation();
        this.eqk.setAlpha(0.0f);
        this.eqk.setVisibility(8);
    }

    public void aWA() {
        this.mHandler.removeCallbacks(this.aac);
        this.eqk.clearAnimation();
        this.eqk.setAlpha(1.0f);
        this.eqk.setVisibility(0);
    }

    public void setBackImageBlack(AlaLiveInfoData alaLiveInfoData) {
        if ((alaLiveInfoData == null || alaLiveInfoData.screen_direction != 2) && this.eqk != null) {
            this.eqk.setImageDrawable(null);
            this.eqk.setBackgroundColor(this.mPageContext.getResources().getColor(a.d.sdk_transparent));
        }
    }

    public void setBgImageUrl(String str, int i, AlaLiveInfoData alaLiveInfoData) {
        if (this.mPageContext != null && !TextUtils.isEmpty(str)) {
            int[] screenFullSize = ViewCommonUtil.getScreenFullSize(this.mPageContext.getPageActivity());
            bc(screenFullSize[0], screenFullSize[1]);
            if (alaLiveInfoData != null && alaLiveInfoData.screen_direction == 2) {
                this.eqk.setImageBitmap(this.eqq);
            } else if (!TextUtils.isEmpty(str)) {
                this.eqk.startLoad(str, 39, false, false);
            } else {
                this.eqk.setBackgroundResource(a.f.pic_avatar_moren);
            }
        }
    }

    public void setBgImageUrl(String str, AlaLiveInfoData alaLiveInfoData) {
        setBgImageUrl(str, 10, alaLiveInfoData);
    }

    public void release() {
        if (this.eqk != null) {
            this.eqk.setImageDrawable(null);
            this.eqk.stopLoad();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (this.eid != null && !this.eid.eqC) {
            z = this.eid.z(motionEvent);
        }
        if (z || motionEvent.getAction() == 0) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void ik(boolean z) {
        Context context = getContext();
        if (this.eqp == null) {
            this.eqo = new FrameLayout(context);
            this.eqo.setBackgroundColor(getContext().getResources().getColor(a.d.sdk_cp_cont_b));
            this.eqp = new TextView(context);
            this.eqp.setText(context.getResources().getString(a.i.ala_live_private_tip));
            this.eqp.setTextSize(0, context.getResources().getDimensionPixelSize(a.e.sdk_ds28));
            this.eqp.setTextColor(context.getResources().getColor(a.d.sdk_cp_cont_i_alpha40));
            this.eqp.setGravity(49);
            Drawable drawable = context.getResources().getDrawable(a.f.private_tip);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            this.eqp.setCompoundDrawables(null, drawable, null, null);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.topMargin = il(z);
            layoutParams.gravity = 1;
            this.eqo.addView(this.eqp, layoutParams);
            int indexOfChild = this.eid != null ? this.mRootView.indexOfChild(this.eid) : -1;
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
            int[] screenFullSize = ViewCommonUtil.getScreenFullSize(this.mPageContext.getPageActivity());
            int statusBarHeight = !UtilHelper.canUseStyleImmersiveSticky() ? UtilHelper.getStatusBarHeight() : 0;
            layoutParams2.width = screenFullSize[0];
            layoutParams2.height = screenFullSize[1] - statusBarHeight;
            if (indexOfChild < 0) {
                this.mRootView.addView(this.eqo, layoutParams2);
            } else {
                this.mRootView.addView(this.eqo, indexOfChild, layoutParams2);
            }
        } else {
            if (this.eqo.getParent() != null) {
                this.mRootView.removeView(this.eqo);
            }
            int indexOfChild2 = this.eid != null ? this.mRootView.indexOfChild(this.eid) : -1;
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -1);
            int[] screenFullSize2 = ViewCommonUtil.getScreenFullSize(this.mPageContext.getPageActivity());
            int statusBarHeight2 = !UtilHelper.canUseStyleImmersiveSticky() ? UtilHelper.getStatusBarHeight() : 0;
            layoutParams3.width = screenFullSize2[0];
            layoutParams3.height = screenFullSize2[1] - statusBarHeight2;
            if (indexOfChild2 < 0) {
                this.mRootView.addView(this.eqo, layoutParams3);
            } else {
                this.mRootView.addView(this.eqo, indexOfChild2, layoutParams3);
            }
            FrameLayout.LayoutParams layoutParams4 = (FrameLayout.LayoutParams) this.eqp.getLayoutParams();
            layoutParams4.topMargin = il(z);
            this.eqp.setLayoutParams(layoutParams4);
        }
        this.eqo.setVisibility(0);
        this.eqp.setVisibility(0);
        if (this.eqm != null) {
            this.eqm.setVisibility(8);
        }
        if (this.eqk != null) {
            this.eqk.setVisibility(8);
        }
    }

    public void z(int i, boolean z) {
        FrameLayout.LayoutParams layoutParams;
        if (this.eqp != null) {
            if (this.eqp.getLayoutParams() != null && (this.eqp.getLayoutParams() instanceof FrameLayout.LayoutParams)) {
                layoutParams = (FrameLayout.LayoutParams) this.eqp.getLayoutParams();
            } else {
                layoutParams = new FrameLayout.LayoutParams(-2, -2);
            }
            if (i == 2) {
                layoutParams.topMargin = getResources().getDimensionPixelSize(a.e.sdk_ds45);
                layoutParams.gravity = 1;
                this.eqp.setLayoutParams(layoutParams);
                return;
            }
            layoutParams.topMargin = il(z);
            layoutParams.gravity = 1;
            this.eqp.setLayoutParams(layoutParams);
        }
    }

    public void aWB() {
        if (this.eqo != null && this.eqo.getParent() != null) {
            ((ViewGroup) this.eqo.getParent()).removeView(this.eqo);
        }
        if (this.eqm != null) {
            this.eqm.setVisibility(0);
        }
        if (this.eqk != null) {
            this.eqk.setVisibility(0);
        }
    }

    public boolean aWC() {
        return (this.eqo == null || this.eqo.getParent() == null) ? false : true;
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

    public void aWD() {
        View findViewWithTag = findViewWithTag("AlaLivePraiseGuideController");
        if (findViewWithTag != null) {
            removeView(findViewWithTag);
        }
    }
}
