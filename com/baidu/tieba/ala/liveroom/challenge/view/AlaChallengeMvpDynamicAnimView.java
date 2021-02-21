package com.baidu.tieba.ala.liveroom.challenge.view;

import android.animation.Animator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.BounceInterpolator;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.data.bh;
import com.baidu.live.lottie.LottieAnimationView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.util.TextHelper;
import com.baidu.live.utils.m;
/* loaded from: classes11.dex */
public class AlaChallengeMvpDynamicAnimView extends RelativeLayout {
    private RelativeLayout gps;
    private HeadImageView hzT;
    private TextView hzU;
    private LottieAnimationView hzV;
    private Animation hzW;
    private final CustomMessageListener hzX;
    private final Animator.AnimatorListener mAnimatorListener;

    public AlaChallengeMvpDynamicAnimView(Context context) {
        super(context);
        this.mAnimatorListener = new Animator.AnimatorListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeMvpDynamicAnimView.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                AlaChallengeMvpDynamicAnimView.this.setVisibility(8);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        };
        this.hzX = new CustomMessageListener(2913205) { // from class: com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeMvpDynamicAnimView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bh)) {
                    AlaChallengeMvpDynamicAnimView.this.a((bh) customResponsedMessage.getData());
                }
            }
        };
        init();
    }

    public AlaChallengeMvpDynamicAnimView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mAnimatorListener = new Animator.AnimatorListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeMvpDynamicAnimView.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                AlaChallengeMvpDynamicAnimView.this.setVisibility(8);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        };
        this.hzX = new CustomMessageListener(2913205) { // from class: com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeMvpDynamicAnimView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bh)) {
                    AlaChallengeMvpDynamicAnimView.this.a((bh) customResponsedMessage.getData());
                }
            }
        };
        init();
    }

    public AlaChallengeMvpDynamicAnimView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mAnimatorListener = new Animator.AnimatorListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeMvpDynamicAnimView.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                AlaChallengeMvpDynamicAnimView.this.setVisibility(8);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        };
        this.hzX = new CustomMessageListener(2913205) { // from class: com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeMvpDynamicAnimView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bh)) {
                    AlaChallengeMvpDynamicAnimView.this.a((bh) customResponsedMessage.getData());
                }
            }
        };
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(a.g.ala_challenge_mvp_dynamic_view, (ViewGroup) this, true);
        this.gps = (RelativeLayout) findViewById(a.f.id_challenge_mvp_dynamic_content_layout);
        this.hzT = (HeadImageView) findViewById(a.f.id_challenge_head_img);
        this.hzT.setIsRound(true);
        this.hzT.setAutoChangeStyle(false);
        this.hzT.setDefaultResource(a.e.sdk_icon_default_avatar100);
        this.hzT.setDefaultErrorResource(a.e.sdk_icon_default_avatar100);
        this.hzT.setDrawBorder(true);
        this.hzT.setBorderWidth(getResources().getDimensionPixelOffset(a.d.sdk_ds3));
        this.hzT.setBorderColor(getResources().getColor(a.c.sdk_white_alpha100));
        this.hzU = (TextView) findViewById(a.f.id_challenge_user_name);
        this.hzV = (LottieAnimationView) findViewById(a.f.id_challenge_mvp_anim_lottie_view);
        Ii();
    }

    private void Ii() {
        this.hzV.setAnimation("mvpdynamic.json");
        this.hzV.setImageAssetsFolder("images/");
        this.hzV.addAnimatorListener(this.mAnimatorListener);
        this.hzV.loop(false);
        this.hzW = AnimationUtils.loadAnimation(getContext(), a.C0195a.challenge_mvp_content_anim);
        BounceInterpolator bounceInterpolator = new BounceInterpolator();
        this.hzW.setDuration(800L);
        this.hzW.setInterpolator(bounceInterpolator);
    }

    public void a(bh bhVar) {
        if (bhVar == null) {
            cei();
        } else if (bhVar.aOS < com.baidu.live.ae.a.Qj().buX.aMg) {
            cei();
        } else {
            setVisibility(0);
            String str = bhVar.mNickName;
            if (!StringUtils.isNull(str)) {
                if (TextHelper.getTextLengthWithEmoji(str) > 22) {
                    str = TextHelper.subStringWithEmoji(str, 22) + StringHelper.STRING_MORE;
                }
                this.hzU.setText(str);
            }
            m.a(this.hzT, bhVar.mPortrait, true, false);
            startAnim();
        }
    }

    private void startAnim() {
        if (this.hzV.isAnimating()) {
            this.hzV.cancelAnimation();
        }
        this.hzV.setProgress(0.0f);
        this.hzV.playAnimation();
        this.gps.clearAnimation();
        this.gps.startAnimation(this.hzW);
    }

    public void cei() {
        if (this.hzV.isAnimating()) {
            this.hzV.cancelAnimation();
        }
        this.gps.clearAnimation();
        setVisibility(8);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.hzX);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        cei();
        MessageManager.getInstance().unRegisterListener(this.hzX);
    }
}
