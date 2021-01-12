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
import com.baidu.live.data.bd;
import com.baidu.live.lottie.LottieAnimationView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.util.TextHelper;
import com.baidu.live.utils.m;
/* loaded from: classes10.dex */
public class AlaChallengeMvpDynamicAnimView extends RelativeLayout {
    private RelativeLayout gmv;
    private HeadImageView hvv;
    private TextView hvw;
    private LottieAnimationView hvx;
    private Animation hvy;
    private final CustomMessageListener hvz;
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
        this.hvz = new CustomMessageListener(2913205) { // from class: com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeMvpDynamicAnimView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bd)) {
                    AlaChallengeMvpDynamicAnimView.this.a((bd) customResponsedMessage.getData());
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
        this.hvz = new CustomMessageListener(2913205) { // from class: com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeMvpDynamicAnimView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bd)) {
                    AlaChallengeMvpDynamicAnimView.this.a((bd) customResponsedMessage.getData());
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
        this.hvz = new CustomMessageListener(2913205) { // from class: com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeMvpDynamicAnimView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bd)) {
                    AlaChallengeMvpDynamicAnimView.this.a((bd) customResponsedMessage.getData());
                }
            }
        };
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(a.g.ala_challenge_mvp_dynamic_view, (ViewGroup) this, true);
        this.gmv = (RelativeLayout) findViewById(a.f.id_challenge_mvp_dynamic_content_layout);
        this.hvv = (HeadImageView) findViewById(a.f.id_challenge_head_img);
        this.hvv.setIsRound(true);
        this.hvv.setAutoChangeStyle(false);
        this.hvv.setDefaultResource(a.e.sdk_pic_mycenter_avatar_def);
        this.hvv.setDefaultErrorResource(a.e.sdk_pic_mycenter_avatar_def);
        this.hvv.setDrawBorder(true);
        this.hvv.setBorderWidth(getResources().getDimensionPixelOffset(a.d.sdk_ds3));
        this.hvv.setBorderColor(getResources().getColor(a.c.sdk_white_alpha100));
        this.hvw = (TextView) findViewById(a.f.id_challenge_user_name);
        this.hvx = (LottieAnimationView) findViewById(a.f.id_challenge_mvp_anim_lottie_view);
        GS();
    }

    private void GS() {
        this.hvx.setAnimation("mvpdynamic.json");
        this.hvx.setImageAssetsFolder("images/");
        this.hvx.addAnimatorListener(this.mAnimatorListener);
        this.hvx.loop(false);
        this.hvy = AnimationUtils.loadAnimation(getContext(), a.C0194a.challenge_mvp_content_anim);
        BounceInterpolator bounceInterpolator = new BounceInterpolator();
        this.hvy.setDuration(800L);
        this.hvy.setInterpolator(bounceInterpolator);
    }

    public void a(bd bdVar) {
        if (bdVar == null) {
            cdg();
        } else if (bdVar.aLV < com.baidu.live.af.a.OJ().bru.aJw) {
            cdg();
        } else {
            setVisibility(0);
            String str = bdVar.mNickName;
            if (!StringUtils.isNull(str)) {
                if (TextHelper.getTextLengthWithEmoji(str) > 22) {
                    str = TextHelper.subStringWithEmoji(str, 22) + StringHelper.STRING_MORE;
                }
                this.hvw.setText(str);
            }
            m.a(this.hvv, bdVar.mPortrait, true, false);
            startAnim();
        }
    }

    private void startAnim() {
        if (this.hvx.isAnimating()) {
            this.hvx.cancelAnimation();
        }
        this.hvx.setProgress(0.0f);
        this.hvx.playAnimation();
        this.gmv.clearAnimation();
        this.gmv.startAnimation(this.hvy);
    }

    public void cdg() {
        if (this.hvx.isAnimating()) {
            this.hvx.cancelAnimation();
        }
        this.gmv.clearAnimation();
        setVisibility(8);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.hvz);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        cdg();
        MessageManager.getInstance().unRegisterListener(this.hvz);
    }
}
