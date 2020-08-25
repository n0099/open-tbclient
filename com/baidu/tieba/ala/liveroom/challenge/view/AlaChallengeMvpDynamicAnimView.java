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
import com.baidu.live.data.aq;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.util.TextHelper;
import com.baidu.live.utils.k;
import com.tb.airbnb.lottie.LottieAnimationView;
/* loaded from: classes7.dex */
public class AlaChallengeMvpDynamicAnimView extends RelativeLayout {
    private RelativeLayout fvf;
    private HeadImageView gvp;
    private TextView gvq;
    private LottieAnimationView gvr;
    private Animation gvs;
    private final CustomMessageListener gvt;
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
        this.gvt = new CustomMessageListener(2913205) { // from class: com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeMvpDynamicAnimView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof aq)) {
                    AlaChallengeMvpDynamicAnimView.this.a((aq) customResponsedMessage.getData());
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
        this.gvt = new CustomMessageListener(2913205) { // from class: com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeMvpDynamicAnimView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof aq)) {
                    AlaChallengeMvpDynamicAnimView.this.a((aq) customResponsedMessage.getData());
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
        this.gvt = new CustomMessageListener(2913205) { // from class: com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeMvpDynamicAnimView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof aq)) {
                    AlaChallengeMvpDynamicAnimView.this.a((aq) customResponsedMessage.getData());
                }
            }
        };
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(a.h.ala_challenge_mvp_dynamic_view, (ViewGroup) this, true);
        this.fvf = (RelativeLayout) findViewById(a.g.id_challenge_mvp_dynamic_content_layout);
        this.gvp = (HeadImageView) findViewById(a.g.id_challenge_head_img);
        this.gvp.setIsRound(true);
        this.gvp.setAutoChangeStyle(false);
        this.gvp.setDefaultResource(a.f.sdk_pic_mycenter_avatar_def);
        this.gvp.setDefaultErrorResource(a.f.sdk_pic_mycenter_avatar_def);
        this.gvp.setDrawBorder(true);
        this.gvp.setBorderWidth(getResources().getDimensionPixelOffset(a.e.sdk_ds3));
        this.gvp.setBorderColor(getResources().getColor(a.d.sdk_white_alpha100));
        this.gvq = (TextView) findViewById(a.g.id_challenge_user_name);
        this.gvr = (LottieAnimationView) findViewById(a.g.id_challenge_mvp_anim_lottie_view);
        HE();
    }

    private void HE() {
        this.gvr.setAnimation("mvpdynamic.json");
        this.gvr.setImageAssetsFolder("images/");
        this.gvr.addAnimatorListener(this.mAnimatorListener);
        this.gvr.loop(false);
        this.gvs = AnimationUtils.loadAnimation(getContext(), a.C0185a.challenge_mvp_content_anim);
        BounceInterpolator bounceInterpolator = new BounceInterpolator();
        this.gvs.setDuration(800L);
        this.gvs.setInterpolator(bounceInterpolator);
    }

    public void a(aq aqVar) {
        if (aqVar == null) {
            bQA();
        } else if (aqVar.aIA < com.baidu.live.w.a.Nk().beH.aGy) {
            bQA();
        } else {
            setVisibility(0);
            String str = aqVar.mNickName;
            if (!StringUtils.isNull(str)) {
                if (TextHelper.getTextLengthWithEmoji(str) > 22) {
                    str = TextHelper.subStringWithEmoji(str, 22) + StringHelper.STRING_MORE;
                }
                this.gvq.setText(str);
            }
            k.a(this.gvp, aqVar.mPortrait, true, false);
            startAnim();
        }
    }

    private void startAnim() {
        if (this.gvr.isAnimating()) {
            this.gvr.cancelAnimation();
        }
        this.gvr.setProgress(0.0f);
        this.gvr.playAnimation();
        this.fvf.clearAnimation();
        this.fvf.startAnimation(this.gvs);
    }

    public void bQA() {
        if (this.gvr.isAnimating()) {
            this.gvr.cancelAnimation();
        }
        this.fvf.clearAnimation();
        setVisibility(8);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.gvt);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        bQA();
        MessageManager.getInstance().unRegisterListener(this.gvt);
    }
}
