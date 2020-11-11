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
import com.baidu.live.data.ba;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.util.TextHelper;
import com.baidu.live.utils.l;
import com.tb.airbnb.lottie.LottieAnimationView;
/* loaded from: classes4.dex */
public class AlaChallengeMvpDynamicAnimView extends RelativeLayout {
    private RelativeLayout fYK;
    private HeadImageView heP;
    private TextView heQ;
    private LottieAnimationView heR;
    private Animation heS;
    private final CustomMessageListener heT;
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
        this.heT = new CustomMessageListener(2913205) { // from class: com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeMvpDynamicAnimView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof ba)) {
                    AlaChallengeMvpDynamicAnimView.this.a((ba) customResponsedMessage.getData());
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
        this.heT = new CustomMessageListener(2913205) { // from class: com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeMvpDynamicAnimView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof ba)) {
                    AlaChallengeMvpDynamicAnimView.this.a((ba) customResponsedMessage.getData());
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
        this.heT = new CustomMessageListener(2913205) { // from class: com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeMvpDynamicAnimView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof ba)) {
                    AlaChallengeMvpDynamicAnimView.this.a((ba) customResponsedMessage.getData());
                }
            }
        };
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(a.g.ala_challenge_mvp_dynamic_view, (ViewGroup) this, true);
        this.fYK = (RelativeLayout) findViewById(a.f.id_challenge_mvp_dynamic_content_layout);
        this.heP = (HeadImageView) findViewById(a.f.id_challenge_head_img);
        this.heP.setIsRound(true);
        this.heP.setAutoChangeStyle(false);
        this.heP.setDefaultResource(a.e.sdk_pic_mycenter_avatar_def);
        this.heP.setDefaultErrorResource(a.e.sdk_pic_mycenter_avatar_def);
        this.heP.setDrawBorder(true);
        this.heP.setBorderWidth(getResources().getDimensionPixelOffset(a.d.sdk_ds3));
        this.heP.setBorderColor(getResources().getColor(a.c.sdk_white_alpha100));
        this.heQ = (TextView) findViewById(a.f.id_challenge_user_name);
        this.heR = (LottieAnimationView) findViewById(a.f.id_challenge_mvp_anim_lottie_view);
        JW();
    }

    private void JW() {
        this.heR.setAnimation("mvpdynamic.json");
        this.heR.setImageAssetsFolder("images/");
        this.heR.addAnimatorListener(this.mAnimatorListener);
        this.heR.loop(false);
        this.heS = AnimationUtils.loadAnimation(getContext(), a.C0197a.challenge_mvp_content_anim);
        BounceInterpolator bounceInterpolator = new BounceInterpolator();
        this.heS.setDuration(800L);
        this.heS.setInterpolator(bounceInterpolator);
    }

    public void a(ba baVar) {
        if (baVar == null) {
            caS();
        } else if (baVar.aOF < com.baidu.live.aa.a.PQ().bod.aMv) {
            caS();
        } else {
            setVisibility(0);
            String str = baVar.mNickName;
            if (!StringUtils.isNull(str)) {
                if (TextHelper.getTextLengthWithEmoji(str) > 22) {
                    str = TextHelper.subStringWithEmoji(str, 22) + StringHelper.STRING_MORE;
                }
                this.heQ.setText(str);
            }
            l.a(this.heP, baVar.mPortrait, true, false);
            startAnim();
        }
    }

    private void startAnim() {
        if (this.heR.isAnimating()) {
            this.heR.cancelAnimation();
        }
        this.heR.setProgress(0.0f);
        this.heR.playAnimation();
        this.fYK.clearAnimation();
        this.fYK.startAnimation(this.heS);
    }

    public void caS() {
        if (this.heR.isAnimating()) {
            this.heR.cancelAnimation();
        }
        this.fYK.clearAnimation();
        setVisibility(8);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.heT);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        caS();
        MessageManager.getInstance().unRegisterListener(this.heT);
    }
}
