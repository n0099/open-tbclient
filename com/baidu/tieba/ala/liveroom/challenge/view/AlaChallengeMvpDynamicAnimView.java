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
import com.baidu.live.data.av;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.util.TextHelper;
import com.baidu.live.utils.l;
import com.tb.airbnb.lottie.LottieAnimationView;
/* loaded from: classes4.dex */
public class AlaChallengeMvpDynamicAnimView extends RelativeLayout {
    private RelativeLayout fyu;
    private HeadImageView gyE;
    private TextView gyF;
    private LottieAnimationView gyG;
    private Animation gyH;
    private final CustomMessageListener gyI;
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
        this.gyI = new CustomMessageListener(2913205) { // from class: com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeMvpDynamicAnimView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof av)) {
                    AlaChallengeMvpDynamicAnimView.this.a((av) customResponsedMessage.getData());
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
        this.gyI = new CustomMessageListener(2913205) { // from class: com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeMvpDynamicAnimView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof av)) {
                    AlaChallengeMvpDynamicAnimView.this.a((av) customResponsedMessage.getData());
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
        this.gyI = new CustomMessageListener(2913205) { // from class: com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeMvpDynamicAnimView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof av)) {
                    AlaChallengeMvpDynamicAnimView.this.a((av) customResponsedMessage.getData());
                }
            }
        };
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(a.h.ala_challenge_mvp_dynamic_view, (ViewGroup) this, true);
        this.fyu = (RelativeLayout) findViewById(a.g.id_challenge_mvp_dynamic_content_layout);
        this.gyE = (HeadImageView) findViewById(a.g.id_challenge_head_img);
        this.gyE.setIsRound(true);
        this.gyE.setAutoChangeStyle(false);
        this.gyE.setDefaultResource(a.f.sdk_pic_mycenter_avatar_def);
        this.gyE.setDefaultErrorResource(a.f.sdk_pic_mycenter_avatar_def);
        this.gyE.setDrawBorder(true);
        this.gyE.setBorderWidth(getResources().getDimensionPixelOffset(a.e.sdk_ds3));
        this.gyE.setBorderColor(getResources().getColor(a.d.sdk_white_alpha100));
        this.gyF = (TextView) findViewById(a.g.id_challenge_user_name);
        this.gyG = (LottieAnimationView) findViewById(a.g.id_challenge_mvp_anim_lottie_view);
        Ig();
    }

    private void Ig() {
        this.gyG.setAnimation("mvpdynamic.json");
        this.gyG.setImageAssetsFolder("images/");
        this.gyG.addAnimatorListener(this.mAnimatorListener);
        this.gyG.loop(false);
        this.gyH = AnimationUtils.loadAnimation(getContext(), a.C0186a.challenge_mvp_content_anim);
        BounceInterpolator bounceInterpolator = new BounceInterpolator();
        this.gyH.setDuration(800L);
        this.gyH.setInterpolator(bounceInterpolator);
    }

    public void a(av avVar) {
        if (avVar == null) {
            bRX();
        } else if (avVar.aJS < com.baidu.live.x.a.NN().bhy.aHP) {
            bRX();
        } else {
            setVisibility(0);
            String str = avVar.mNickName;
            if (!StringUtils.isNull(str)) {
                if (TextHelper.getTextLengthWithEmoji(str) > 22) {
                    str = TextHelper.subStringWithEmoji(str, 22) + StringHelper.STRING_MORE;
                }
                this.gyF.setText(str);
            }
            l.a(this.gyE, avVar.mPortrait, true, false);
            startAnim();
        }
    }

    private void startAnim() {
        if (this.gyG.isAnimating()) {
            this.gyG.cancelAnimation();
        }
        this.gyG.setProgress(0.0f);
        this.gyG.playAnimation();
        this.fyu.clearAnimation();
        this.fyu.startAnimation(this.gyH);
    }

    public void bRX() {
        if (this.gyG.isAnimating()) {
            this.gyG.cancelAnimation();
        }
        this.fyu.clearAnimation();
        setVisibility(8);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.gyI);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        bRX();
        MessageManager.getInstance().unRegisterListener(this.gyI);
    }
}
