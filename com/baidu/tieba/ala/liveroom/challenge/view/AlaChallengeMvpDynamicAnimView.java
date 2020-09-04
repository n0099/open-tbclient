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
    private RelativeLayout fvj;
    private HeadImageView gvt;
    private TextView gvu;
    private LottieAnimationView gvv;
    private Animation gvw;
    private final CustomMessageListener gvx;
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
        this.gvx = new CustomMessageListener(2913205) { // from class: com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeMvpDynamicAnimView.2
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
        this.gvx = new CustomMessageListener(2913205) { // from class: com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeMvpDynamicAnimView.2
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
        this.gvx = new CustomMessageListener(2913205) { // from class: com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeMvpDynamicAnimView.2
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
        this.fvj = (RelativeLayout) findViewById(a.g.id_challenge_mvp_dynamic_content_layout);
        this.gvt = (HeadImageView) findViewById(a.g.id_challenge_head_img);
        this.gvt.setIsRound(true);
        this.gvt.setAutoChangeStyle(false);
        this.gvt.setDefaultResource(a.f.sdk_pic_mycenter_avatar_def);
        this.gvt.setDefaultErrorResource(a.f.sdk_pic_mycenter_avatar_def);
        this.gvt.setDrawBorder(true);
        this.gvt.setBorderWidth(getResources().getDimensionPixelOffset(a.e.sdk_ds3));
        this.gvt.setBorderColor(getResources().getColor(a.d.sdk_white_alpha100));
        this.gvu = (TextView) findViewById(a.g.id_challenge_user_name);
        this.gvv = (LottieAnimationView) findViewById(a.g.id_challenge_mvp_anim_lottie_view);
        HE();
    }

    private void HE() {
        this.gvv.setAnimation("mvpdynamic.json");
        this.gvv.setImageAssetsFolder("images/");
        this.gvv.addAnimatorListener(this.mAnimatorListener);
        this.gvv.loop(false);
        this.gvw = AnimationUtils.loadAnimation(getContext(), a.C0185a.challenge_mvp_content_anim);
        BounceInterpolator bounceInterpolator = new BounceInterpolator();
        this.gvw.setDuration(800L);
        this.gvw.setInterpolator(bounceInterpolator);
    }

    public void a(aq aqVar) {
        if (aqVar == null) {
            bQB();
        } else if (aqVar.aIC < com.baidu.live.w.a.Nk().beJ.aGA) {
            bQB();
        } else {
            setVisibility(0);
            String str = aqVar.mNickName;
            if (!StringUtils.isNull(str)) {
                if (TextHelper.getTextLengthWithEmoji(str) > 22) {
                    str = TextHelper.subStringWithEmoji(str, 22) + StringHelper.STRING_MORE;
                }
                this.gvu.setText(str);
            }
            k.a(this.gvt, aqVar.mPortrait, true, false);
            startAnim();
        }
    }

    private void startAnim() {
        if (this.gvv.isAnimating()) {
            this.gvv.cancelAnimation();
        }
        this.gvv.setProgress(0.0f);
        this.gvv.playAnimation();
        this.fvj.clearAnimation();
        this.fvj.startAnimation(this.gvw);
    }

    public void bQB() {
        if (this.gvv.isAnimating()) {
            this.gvv.cancelAnimation();
        }
        this.fvj.clearAnimation();
        setVisibility(8);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.gvx);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        bQB();
        MessageManager.getInstance().unRegisterListener(this.gvx);
    }
}
