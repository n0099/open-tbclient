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
import com.baidu.live.data.ay;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.util.TextHelper;
import com.baidu.live.utils.l;
import com.tb.airbnb.lottie.LottieAnimationView;
/* loaded from: classes4.dex */
public class AlaChallengeMvpDynamicAnimView extends RelativeLayout {
    private RelativeLayout fSU;
    private HeadImageView gYL;
    private TextView gYM;
    private LottieAnimationView gYN;
    private Animation gYO;
    private final CustomMessageListener gYP;
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
        this.gYP = new CustomMessageListener(2913205) { // from class: com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeMvpDynamicAnimView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof ay)) {
                    AlaChallengeMvpDynamicAnimView.this.a((ay) customResponsedMessage.getData());
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
        this.gYP = new CustomMessageListener(2913205) { // from class: com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeMvpDynamicAnimView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof ay)) {
                    AlaChallengeMvpDynamicAnimView.this.a((ay) customResponsedMessage.getData());
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
        this.gYP = new CustomMessageListener(2913205) { // from class: com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeMvpDynamicAnimView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof ay)) {
                    AlaChallengeMvpDynamicAnimView.this.a((ay) customResponsedMessage.getData());
                }
            }
        };
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(a.h.ala_challenge_mvp_dynamic_view, (ViewGroup) this, true);
        this.fSU = (RelativeLayout) findViewById(a.g.id_challenge_mvp_dynamic_content_layout);
        this.gYL = (HeadImageView) findViewById(a.g.id_challenge_head_img);
        this.gYL.setIsRound(true);
        this.gYL.setAutoChangeStyle(false);
        this.gYL.setDefaultResource(a.f.sdk_pic_mycenter_avatar_def);
        this.gYL.setDefaultErrorResource(a.f.sdk_pic_mycenter_avatar_def);
        this.gYL.setDrawBorder(true);
        this.gYL.setBorderWidth(getResources().getDimensionPixelOffset(a.e.sdk_ds3));
        this.gYL.setBorderColor(getResources().getColor(a.d.sdk_white_alpha100));
        this.gYM = (TextView) findViewById(a.g.id_challenge_user_name);
        this.gYN = (LottieAnimationView) findViewById(a.g.id_challenge_mvp_anim_lottie_view);
        Jw();
    }

    private void Jw() {
        this.gYN.setAnimation("mvpdynamic.json");
        this.gYN.setImageAssetsFolder("images/");
        this.gYN.addAnimatorListener(this.mAnimatorListener);
        this.gYN.loop(false);
        this.gYO = AnimationUtils.loadAnimation(getContext(), a.C0195a.challenge_mvp_content_anim);
        BounceInterpolator bounceInterpolator = new BounceInterpolator();
        this.gYO.setDuration(800L);
        this.gYO.setInterpolator(bounceInterpolator);
    }

    public void a(ay ayVar) {
        if (ayVar == null) {
            bYq();
        } else if (ayVar.aNC < com.baidu.live.z.a.Pq().bmJ.aLv) {
            bYq();
        } else {
            setVisibility(0);
            String str = ayVar.mNickName;
            if (!StringUtils.isNull(str)) {
                if (TextHelper.getTextLengthWithEmoji(str) > 22) {
                    str = TextHelper.subStringWithEmoji(str, 22) + StringHelper.STRING_MORE;
                }
                this.gYM.setText(str);
            }
            l.a(this.gYL, ayVar.mPortrait, true, false);
            startAnim();
        }
    }

    private void startAnim() {
        if (this.gYN.isAnimating()) {
            this.gYN.cancelAnimation();
        }
        this.gYN.setProgress(0.0f);
        this.gYN.playAnimation();
        this.fSU.clearAnimation();
        this.fSU.startAnimation(this.gYO);
    }

    public void bYq() {
        if (this.gYN.isAnimating()) {
            this.gYN.cancelAnimation();
        }
        this.fSU.clearAnimation();
        setVisibility(8);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.gYP);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        bYq();
        MessageManager.getInstance().unRegisterListener(this.gYP);
    }
}
