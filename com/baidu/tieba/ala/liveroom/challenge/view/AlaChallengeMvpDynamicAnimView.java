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
import com.baidu.live.data.an;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.util.TextHelper;
import com.baidu.live.utils.k;
import com.tb.airbnb.lottie.LottieAnimationView;
/* loaded from: classes3.dex */
public class AlaChallengeMvpDynamicAnimView extends RelativeLayout {
    private RelativeLayout feG;
    private HeadImageView ged;
    private TextView gee;
    private LottieAnimationView gef;
    private Animation geg;
    private final CustomMessageListener geh;
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
        this.geh = new CustomMessageListener(2913205) { // from class: com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeMvpDynamicAnimView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof an)) {
                    AlaChallengeMvpDynamicAnimView.this.a((an) customResponsedMessage.getData());
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
        this.geh = new CustomMessageListener(2913205) { // from class: com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeMvpDynamicAnimView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof an)) {
                    AlaChallengeMvpDynamicAnimView.this.a((an) customResponsedMessage.getData());
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
        this.geh = new CustomMessageListener(2913205) { // from class: com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeMvpDynamicAnimView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof an)) {
                    AlaChallengeMvpDynamicAnimView.this.a((an) customResponsedMessage.getData());
                }
            }
        };
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(a.h.ala_challenge_mvp_dynamic_view, (ViewGroup) this, true);
        this.feG = (RelativeLayout) findViewById(a.g.id_challenge_mvp_dynamic_content_layout);
        this.ged = (HeadImageView) findViewById(a.g.id_challenge_head_img);
        this.ged.setIsRound(true);
        this.ged.setAutoChangeStyle(false);
        this.ged.setDefaultResource(a.f.sdk_pic_mycenter_avatar_def);
        this.ged.setDefaultErrorResource(a.f.sdk_pic_mycenter_avatar_def);
        this.ged.setDrawBorder(true);
        this.ged.setBorderWidth(getResources().getDimensionPixelOffset(a.e.sdk_ds3));
        this.ged.setBorderColor(getResources().getColor(a.d.sdk_white_alpha100));
        this.gee = (TextView) findViewById(a.g.id_challenge_user_name);
        this.gef = (LottieAnimationView) findViewById(a.g.id_challenge_mvp_anim_lottie_view);
        Bz();
    }

    private void Bz() {
        this.gef.setAnimation("mvpdynamic.json");
        this.gef.setImageAssetsFolder("images/");
        this.gef.addAnimatorListener(this.mAnimatorListener);
        this.gef.loop(false);
        this.geg = AnimationUtils.loadAnimation(getContext(), a.C0176a.challenge_mvp_content_anim);
        BounceInterpolator bounceInterpolator = new BounceInterpolator();
        this.geg.setDuration(800L);
        this.geg.setInterpolator(bounceInterpolator);
    }

    public void a(an anVar) {
        if (anVar == null) {
            bDK();
        } else if (anVar.aBV < com.baidu.live.v.a.Hm().aZp.aAb) {
            bDK();
        } else {
            setVisibility(0);
            String str = anVar.mNickName;
            if (!StringUtils.isNull(str)) {
                if (TextHelper.getTextLengthWithEmoji(str) > 22) {
                    str = TextHelper.subStringWithEmoji(str, 22) + StringHelper.STRING_MORE;
                }
                this.gee.setText(str);
            }
            k.a(this.ged, anVar.mPortrait, true, false);
            startAnim();
        }
    }

    private void startAnim() {
        if (this.gef.isAnimating()) {
            this.gef.cancelAnimation();
        }
        this.gef.setProgress(0.0f);
        this.gef.playAnimation();
        this.feG.clearAnimation();
        this.feG.startAnimation(this.geg);
    }

    public void bDK() {
        if (this.gef.isAnimating()) {
            this.gef.cancelAnimation();
        }
        this.feG.clearAnimation();
        setVisibility(8);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.geh);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        bDK();
        MessageManager.getInstance().unRegisterListener(this.geh);
    }
}
