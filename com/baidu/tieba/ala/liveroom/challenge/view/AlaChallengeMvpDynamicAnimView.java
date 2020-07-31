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
import com.baidu.live.data.ao;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.util.TextHelper;
import com.baidu.live.utils.k;
import com.tb.airbnb.lottie.LottieAnimationView;
/* loaded from: classes4.dex */
public class AlaChallengeMvpDynamicAnimView extends RelativeLayout {
    private RelativeLayout fjJ;
    private HeadImageView gjm;
    private TextView gjn;
    private LottieAnimationView gjo;
    private Animation gjp;
    private final CustomMessageListener gjq;
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
        this.gjq = new CustomMessageListener(2913205) { // from class: com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeMvpDynamicAnimView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof ao)) {
                    AlaChallengeMvpDynamicAnimView.this.a((ao) customResponsedMessage.getData());
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
        this.gjq = new CustomMessageListener(2913205) { // from class: com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeMvpDynamicAnimView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof ao)) {
                    AlaChallengeMvpDynamicAnimView.this.a((ao) customResponsedMessage.getData());
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
        this.gjq = new CustomMessageListener(2913205) { // from class: com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeMvpDynamicAnimView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof ao)) {
                    AlaChallengeMvpDynamicAnimView.this.a((ao) customResponsedMessage.getData());
                }
            }
        };
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(a.h.ala_challenge_mvp_dynamic_view, (ViewGroup) this, true);
        this.fjJ = (RelativeLayout) findViewById(a.g.id_challenge_mvp_dynamic_content_layout);
        this.gjm = (HeadImageView) findViewById(a.g.id_challenge_head_img);
        this.gjm.setIsRound(true);
        this.gjm.setAutoChangeStyle(false);
        this.gjm.setDefaultResource(a.f.sdk_pic_mycenter_avatar_def);
        this.gjm.setDefaultErrorResource(a.f.sdk_pic_mycenter_avatar_def);
        this.gjm.setDrawBorder(true);
        this.gjm.setBorderWidth(getResources().getDimensionPixelOffset(a.e.sdk_ds3));
        this.gjm.setBorderColor(getResources().getColor(a.d.sdk_white_alpha100));
        this.gjn = (TextView) findViewById(a.g.id_challenge_user_name);
        this.gjo = (LottieAnimationView) findViewById(a.g.id_challenge_mvp_anim_lottie_view);
        Cb();
    }

    private void Cb() {
        this.gjo.setAnimation("mvpdynamic.json");
        this.gjo.setImageAssetsFolder("images/");
        this.gjo.addAnimatorListener(this.mAnimatorListener);
        this.gjo.loop(false);
        this.gjp = AnimationUtils.loadAnimation(getContext(), a.C0178a.challenge_mvp_content_anim);
        BounceInterpolator bounceInterpolator = new BounceInterpolator();
        this.gjp.setDuration(800L);
        this.gjp.setInterpolator(bounceInterpolator);
    }

    public void a(ao aoVar) {
        if (aoVar == null) {
            bGW();
        } else if (aoVar.aDq < com.baidu.live.v.a.Hs().aZn.aBo) {
            bGW();
        } else {
            setVisibility(0);
            String str = aoVar.mNickName;
            if (!StringUtils.isNull(str)) {
                if (TextHelper.getTextLengthWithEmoji(str) > 22) {
                    str = TextHelper.subStringWithEmoji(str, 22) + StringHelper.STRING_MORE;
                }
                this.gjn.setText(str);
            }
            k.a(this.gjm, aoVar.mPortrait, true, false);
            startAnim();
        }
    }

    private void startAnim() {
        if (this.gjo.isAnimating()) {
            this.gjo.cancelAnimation();
        }
        this.gjo.setProgress(0.0f);
        this.gjo.playAnimation();
        this.fjJ.clearAnimation();
        this.fjJ.startAnimation(this.gjp);
    }

    public void bGW() {
        if (this.gjo.isAnimating()) {
            this.gjo.cancelAnimation();
        }
        this.fjJ.clearAnimation();
        setVisibility(8);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.gjq);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        bGW();
        MessageManager.getInstance().unRegisterListener(this.gjq);
    }
}
