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
import com.baidu.live.data.bb;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.util.TextHelper;
import com.baidu.live.utils.l;
import com.tb.airbnb.lottie.LottieAnimationView;
/* loaded from: classes4.dex */
public class AlaChallengeMvpDynamicAnimView extends RelativeLayout {
    private RelativeLayout ggE;
    private HeadImageView hog;
    private TextView hoh;
    private LottieAnimationView hoi;
    private Animation hoj;
    private final CustomMessageListener hok;
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
        this.hok = new CustomMessageListener(2913205) { // from class: com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeMvpDynamicAnimView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bb)) {
                    AlaChallengeMvpDynamicAnimView.this.a((bb) customResponsedMessage.getData());
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
        this.hok = new CustomMessageListener(2913205) { // from class: com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeMvpDynamicAnimView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bb)) {
                    AlaChallengeMvpDynamicAnimView.this.a((bb) customResponsedMessage.getData());
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
        this.hok = new CustomMessageListener(2913205) { // from class: com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeMvpDynamicAnimView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bb)) {
                    AlaChallengeMvpDynamicAnimView.this.a((bb) customResponsedMessage.getData());
                }
            }
        };
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(a.g.ala_challenge_mvp_dynamic_view, (ViewGroup) this, true);
        this.ggE = (RelativeLayout) findViewById(a.f.id_challenge_mvp_dynamic_content_layout);
        this.hog = (HeadImageView) findViewById(a.f.id_challenge_head_img);
        this.hog.setIsRound(true);
        this.hog.setAutoChangeStyle(false);
        this.hog.setDefaultResource(a.e.sdk_pic_mycenter_avatar_def);
        this.hog.setDefaultErrorResource(a.e.sdk_pic_mycenter_avatar_def);
        this.hog.setDrawBorder(true);
        this.hog.setBorderWidth(getResources().getDimensionPixelOffset(a.d.sdk_ds3));
        this.hog.setBorderColor(getResources().getColor(a.c.sdk_white_alpha100));
        this.hoh = (TextView) findViewById(a.f.id_challenge_user_name);
        this.hoi = (LottieAnimationView) findViewById(a.f.id_challenge_mvp_anim_lottie_view);
        Lo();
    }

    private void Lo() {
        this.hoi.setAnimation("mvpdynamic.json");
        this.hoi.setImageAssetsFolder("images/");
        this.hoi.addAnimatorListener(this.mAnimatorListener);
        this.hoi.loop(false);
        this.hoj = AnimationUtils.loadAnimation(getContext(), a.C0205a.challenge_mvp_content_anim);
        BounceInterpolator bounceInterpolator = new BounceInterpolator();
        this.hoj.setDuration(800L);
        this.hoj.setInterpolator(bounceInterpolator);
    }

    public void a(bb bbVar) {
        if (bbVar == null) {
            ceh();
        } else if (bbVar.aPT < com.baidu.live.ae.a.RB().brA.aNF) {
            ceh();
        } else {
            setVisibility(0);
            String str = bbVar.mNickName;
            if (!StringUtils.isNull(str)) {
                if (TextHelper.getTextLengthWithEmoji(str) > 22) {
                    str = TextHelper.subStringWithEmoji(str, 22) + StringHelper.STRING_MORE;
                }
                this.hoh.setText(str);
            }
            l.a(this.hog, bbVar.mPortrait, true, false);
            startAnim();
        }
    }

    private void startAnim() {
        if (this.hoi.isAnimating()) {
            this.hoi.cancelAnimation();
        }
        this.hoi.setProgress(0.0f);
        this.hoi.playAnimation();
        this.ggE.clearAnimation();
        this.ggE.startAnimation(this.hoj);
    }

    public void ceh() {
        if (this.hoi.isAnimating()) {
            this.hoi.cancelAnimation();
        }
        this.ggE.clearAnimation();
        setVisibility(8);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.hok);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ceh();
        MessageManager.getInstance().unRegisterListener(this.hok);
    }
}
