package com.baidu.tieba.ala.liveroom.challenge.view;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;
import com.baidu.live.tbadk.core.util.ViewCommonUtil;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.live.utils.h;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a {
    private int hzA;
    private InterfaceC0662a hzI;
    private AnimatorSet hzJ;
    private ValueAnimator hzK;
    private ValueAnimator hzL;
    private int hzM;
    private int hzN;

    /* renamed from: com.baidu.tieba.ala.liveroom.challenge.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0662a {
        void cee();

        void cef();

        void ceg();

        void ceh();
    }

    public a(Context context) {
        this.hzA = 0;
        this.hzA = h.bm(context);
    }

    public void bT(int i, int i2) {
        this.hzM = i;
        this.hzN = i2;
    }

    private void a(AlaChallengeLiveView alaChallengeLiveView, int i, int i2, int i3) {
        View anchorAnimLiveLayout = alaChallengeLiveView.getAnchorAnimLiveLayout();
        anchorAnimLiveLayout.setAlpha(1.0f);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) anchorAnimLiveLayout.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i2;
        anchorAnimLiveLayout.setLayoutParams(layoutParams);
        anchorAnimLiveLayout.setY(i3);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("endWidth", i);
            jSONObject.put("endHeight", i2);
            jSONObject.put("toY", i3);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem("2678", UbcStatConstant.ContentType.UBC_TYPE_CHALLENGE_SCREEN_CHANGE, "liveroom", "left_big_to_small_start").setContentExt(null, null, jSONObject));
    }

    private void b(AlaChallengeLiveView alaChallengeLiveView, int i, int i2, int i3) {
        View anchorAnimLiveLayout = alaChallengeLiveView.getAnchorAnimLiveLayout();
        anchorAnimLiveLayout.setAlpha(1.0f);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) anchorAnimLiveLayout.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i2;
        anchorAnimLiveLayout.setLayoutParams(layoutParams);
        anchorAnimLiveLayout.setY(i3);
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem("2678", UbcStatConstant.ContentType.UBC_TYPE_CHALLENGE_SCREEN_CHANGE, "liveroom", "left_small_to_big_end").setContentExt(null, null, null));
    }

    private void a(AlaChallengeLiveView alaChallengeLiveView, int i) {
        View rivalAnimLiveLayout = alaChallengeLiveView.getRivalAnimLiveLayout();
        rivalAnimLiveLayout.setX(i);
        rivalAnimLiveLayout.setAlpha(1.0f);
        rivalAnimLiveLayout.setVisibility(0);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("endX", i);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem("2678", UbcStatConstant.ContentType.UBC_TYPE_CHALLENGE_SCREEN_CHANGE, "liveroom", "right_show").setContentExt(null, null, jSONObject));
    }

    private void c(AlaChallengeLiveView alaChallengeLiveView) {
        alaChallengeLiveView.getRivalAnimLiveLayout().setAlpha(0.0f);
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem("2678", UbcStatConstant.ContentType.UBC_TYPE_CHALLENGE_SCREEN_CHANGE, "liveroom", "right_hide").setContentExt(null, null, null));
    }

    private ValueAnimator d(AlaChallengeLiveView alaChallengeLiveView) {
        final View leftTimeView = alaChallengeLiveView.getLeftTimeView();
        int i = this.hzA;
        leftTimeView.setVisibility(0);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) leftTimeView.getLayoutParams();
        layoutParams.topMargin = i;
        leftTimeView.setLayoutParams(layoutParams);
        leftTimeView.setAlpha(0.0f);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.a.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                leftTimeView.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        ofFloat.setDuration(280L);
        return ofFloat;
    }

    private void e(AlaChallengeLiveView alaChallengeLiveView) {
        View leftTimeView = alaChallengeLiveView.getLeftTimeView();
        int i = this.hzA;
        int height = leftTimeView.getHeight();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) leftTimeView.getLayoutParams();
        layoutParams.topMargin = i - height;
        leftTimeView.setLayoutParams(layoutParams);
        leftTimeView.setVisibility(4);
        leftTimeView.setAlpha(0.0f);
    }

    private ValueAnimator f(AlaChallengeLiveView alaChallengeLiveView) {
        final View rivalUserInfoView = alaChallengeLiveView.getRivalUserInfoView();
        rivalUserInfoView.setAlpha(0.0f);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.a.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                rivalUserInfoView.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        ofFloat.setDuration(280L);
        return ofFloat;
    }

    private void g(AlaChallengeLiveView alaChallengeLiveView) {
        alaChallengeLiveView.getRivalUserInfoView().setAlpha(0.0f);
    }

    private ValueAnimator h(AlaChallengeLiveView alaChallengeLiveView) {
        View scoreProgressLayout = alaChallengeLiveView.getScoreProgressLayout();
        final View jinzhuLayout = alaChallengeLiveView.getJinzhuLayout();
        scoreProgressLayout.setAlpha(1.0f);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        jinzhuLayout.setAlpha(0.0f);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.a.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                jinzhuLayout.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        ofFloat.setDuration(500L);
        return ofFloat;
    }

    private void i(AlaChallengeLiveView alaChallengeLiveView) {
        View scoreProgressLayout = alaChallengeLiveView.getScoreProgressLayout();
        View jinzhuLayout = alaChallengeLiveView.getJinzhuLayout();
        scoreProgressLayout.setAlpha(0.0f);
        jinzhuLayout.setAlpha(0.0f);
    }

    public void j(AlaChallengeLiveView alaChallengeLiveView) {
        final View rivalAnimLiveLayout;
        if (alaChallengeLiveView != null && (rivalAnimLiveLayout = alaChallengeLiveView.getRivalAnimLiveLayout()) != null && rivalAnimLiveLayout.getAlpha() != 0.0f) {
            if (this.hzL != null) {
                this.hzL.cancel();
            }
            this.hzL = ValueAnimator.ofFloat(1.0f, 0.0f);
            this.hzL.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.a.4
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    rivalAnimLiveLayout.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            });
            this.hzL.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.a.5
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (a.this.hzI != null) {
                        a.this.hzI.ceh();
                    }
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            this.hzL.setDuration(300L);
            this.hzL.start();
        }
    }

    public void k(AlaChallengeLiveView alaChallengeLiveView) {
        View anchorAnimLiveLayout;
        if (alaChallengeLiveView != null && (anchorAnimLiveLayout = alaChallengeLiveView.getAnchorAnimLiveLayout()) != null && anchorAnimLiveLayout.getAlpha() != 0.0f) {
            anchorAnimLiveLayout.setAlpha(0.0f);
            if (this.hzI != null) {
                this.hzI.ceg();
            }
        }
    }

    public void FS() {
        if (this.hzJ != null) {
            this.hzJ.cancel();
        }
        if (this.hzK != null) {
            this.hzK.cancel();
        }
        if (this.hzL != null) {
            this.hzL.cancel();
        }
    }

    public void a(Activity activity, AlaChallengeLiveView alaChallengeLiveView) {
        int[] screenFullSize = ViewCommonUtil.getScreenFullSize(activity);
        int i = screenFullSize[0] / 2;
        a(alaChallengeLiveView, i, h.fa(i), this.hzA);
        a(alaChallengeLiveView, screenFullSize[0] / 2);
        ValueAnimator h = h(alaChallengeLiveView);
        ValueAnimator d = d(alaChallengeLiveView);
        ValueAnimator f = f(alaChallengeLiveView);
        if (this.hzJ != null) {
            this.hzJ.cancel();
        }
        this.hzJ = new AnimatorSet();
        this.hzJ.setDuration(500L);
        this.hzJ.playTogether(h, d, f);
        this.hzJ.setStartDelay(200L);
        this.hzJ.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.a.6
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (a.this.hzI != null) {
                    a.this.hzI.cee();
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.hzJ.start();
        alaChallengeLiveView.cea();
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem("2678", UbcStatConstant.ContentType.UBC_TYPE_CHALLENGE_SCREEN_CHANGE, "liveroom", "left_big_to_small_end").setContentExt(null, null, null));
    }

    public void b(Activity activity, AlaChallengeLiveView alaChallengeLiveView) {
        int[] screenFullSize = ViewCommonUtil.getScreenFullSize(activity);
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem("2678", UbcStatConstant.ContentType.UBC_TYPE_CHALLENGE_SCREEN_CHANGE, "liveroom", "left_small_to_big_start").setContentExt(null, null, null));
        e(alaChallengeLiveView);
        g(alaChallengeLiveView);
        i(alaChallengeLiveView);
        alaChallengeLiveView.ceb();
        c(alaChallengeLiveView);
        b(alaChallengeLiveView, screenFullSize[0], screenFullSize[1], 0);
        if (this.hzI != null) {
            this.hzI.cef();
        }
    }

    public void a(InterfaceC0662a interfaceC0662a) {
        this.hzI = interfaceC0662a;
    }
}
