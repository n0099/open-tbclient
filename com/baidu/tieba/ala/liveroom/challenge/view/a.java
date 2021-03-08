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
/* loaded from: classes10.dex */
public class a {
    private int hBj;
    private InterfaceC0668a hBr;
    private AnimatorSet hBs;
    private ValueAnimator hBt;
    private ValueAnimator hBu;
    private int hBv;
    private int hBw;

    /* renamed from: com.baidu.tieba.ala.liveroom.challenge.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0668a {
        void cek();

        void cel();

        void cem();

        void cen();
    }

    public a(Context context) {
        this.hBj = 0;
        this.hBj = h.bl(context);
    }

    public void bT(int i, int i2) {
        this.hBv = i;
        this.hBw = i2;
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
        int i = this.hBj;
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
        int i = this.hBj;
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
            if (this.hBu != null) {
                this.hBu.cancel();
            }
            this.hBu = ValueAnimator.ofFloat(1.0f, 0.0f);
            this.hBu.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.a.4
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    rivalAnimLiveLayout.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            });
            this.hBu.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.a.5
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (a.this.hBr != null) {
                        a.this.hBr.cen();
                    }
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            this.hBu.setDuration(300L);
            this.hBu.start();
        }
    }

    public void k(AlaChallengeLiveView alaChallengeLiveView) {
        View anchorAnimLiveLayout;
        if (alaChallengeLiveView != null && (anchorAnimLiveLayout = alaChallengeLiveView.getAnchorAnimLiveLayout()) != null && anchorAnimLiveLayout.getAlpha() != 0.0f) {
            anchorAnimLiveLayout.setAlpha(0.0f);
            if (this.hBr != null) {
                this.hBr.cem();
            }
        }
    }

    public void FV() {
        if (this.hBs != null) {
            this.hBs.cancel();
        }
        if (this.hBt != null) {
            this.hBt.cancel();
        }
        if (this.hBu != null) {
            this.hBu.cancel();
        }
    }

    public void a(Activity activity, AlaChallengeLiveView alaChallengeLiveView) {
        int[] screenFullSize = ViewCommonUtil.getScreenFullSize(activity);
        int i = screenFullSize[0] / 2;
        a(alaChallengeLiveView, i, h.fb(i), this.hBj);
        a(alaChallengeLiveView, screenFullSize[0] / 2);
        ValueAnimator h = h(alaChallengeLiveView);
        ValueAnimator d = d(alaChallengeLiveView);
        ValueAnimator f = f(alaChallengeLiveView);
        if (this.hBs != null) {
            this.hBs.cancel();
        }
        this.hBs = new AnimatorSet();
        this.hBs.setDuration(500L);
        this.hBs.playTogether(h, d, f);
        this.hBs.setStartDelay(200L);
        this.hBs.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.a.6
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (a.this.hBr != null) {
                    a.this.hBr.cek();
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.hBs.start();
        alaChallengeLiveView.ceg();
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem("2678", UbcStatConstant.ContentType.UBC_TYPE_CHALLENGE_SCREEN_CHANGE, "liveroom", "left_big_to_small_end").setContentExt(null, null, null));
    }

    public void b(Activity activity, AlaChallengeLiveView alaChallengeLiveView) {
        int[] screenFullSize = ViewCommonUtil.getScreenFullSize(activity);
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem("2678", UbcStatConstant.ContentType.UBC_TYPE_CHALLENGE_SCREEN_CHANGE, "liveroom", "left_small_to_big_start").setContentExt(null, null, null));
        e(alaChallengeLiveView);
        g(alaChallengeLiveView);
        i(alaChallengeLiveView);
        alaChallengeLiveView.ceh();
        c(alaChallengeLiveView);
        b(alaChallengeLiveView, screenFullSize[0], screenFullSize[1], 0);
        if (this.hBr != null) {
            this.hBr.cel();
        }
    }

    public void a(InterfaceC0668a interfaceC0668a) {
        this.hBr = interfaceC0668a;
    }
}
