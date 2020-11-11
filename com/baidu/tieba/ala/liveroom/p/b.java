package com.baidu.tieba.ala.liveroom.p;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Handler;
import android.support.v4.view.animation.FastOutLinearInInterpolator;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.IMConnection;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.data.w;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.GuardClubInfoActivityConfig;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.frameworkdata.IntentAction;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.log.LogManager;
import com.baidu.live.tbadk.util.TextHelper;
import com.baidu.live.view.RoundRectRelativeLayout;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes4.dex */
public class b {
    private TextView ewx;
    private c gWj;
    private com.baidu.tieba.ala.liveroom.operation.b gWq;
    private TextView giP;
    private Handler handler;
    private RelativeLayout hkA;
    private RelativeLayout hkB;
    private TextView hkC;
    private w hkD;
    private AnimatorSet hkI;
    private AnimatorSet hkJ;
    private AnimatorSet hkK;
    private AnimatorSet hkL;
    private AnimatorSet hkM;
    private AnimatorSet hkN;
    private AnimatorSet hkO;
    private AnimatorSet hkP;
    private AnimatorSet hkQ;
    private float hkR;
    private HeadImageView hkt;
    private TextView hku;
    private ImageView hkv;
    private TextView hkw;
    private ViewGroup hkx;
    private ImageView hky;
    private ImageView hkz;
    private boolean isHost;
    private Context mContext;
    private String otherParams;
    private View mView = null;
    private int hkE = 30000;
    public boolean hkF = false;
    private boolean bgC = false;
    private Set<Long> hkG = new HashSet();
    private long hkH = 0;
    CustomMessageListener gEZ = new CustomMessageListener(2913106) { // from class: com.baidu.tieba.ala.liveroom.p.b.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof String) {
                b.this.Hn((String) customResponsedMessage.getData());
            } else {
                b.this.cdv();
            }
        }
    };

    public b(Context context) {
        this.mContext = context;
        initView();
        MessageManager.getInstance().registerListener(this.gEZ);
        this.handler = new Handler();
    }

    public void setId(int i) {
        this.mView.setId(i);
    }

    private void initView() {
        this.mView = View.inflate(this.mContext, a.g.hk_liveroom_hostheader_layout, null);
        this.mView.setBackgroundResource(a.e.sdk_round_host_bg);
        this.hku = (TextView) this.mView.findViewById(a.f.ala_liveroom_hostheader_attention);
        this.hkw = (TextView) this.mView.findViewById(a.f.tv_guardClub_level);
        this.hkt = (HeadImageView) this.mView.findViewById(a.f.ala_liveroom_hostheader_image);
        this.ewx = (TextView) this.mView.findViewById(a.f.ala_liveroom_hostheader_guest);
        this.giP = (TextView) this.mView.findViewById(a.f.ala_liveroom_hostheader_address);
        this.hkx = (ViewGroup) this.mView.findViewById(a.f.fl_guardClubEnter);
        this.hkv = (ImageView) this.mView.findViewById(a.f.guardClubEnter_imageView);
        this.hkt.setIsRound(true);
        this.hkt.setBorderColor(this.mContext.getResources().getColor(a.c.sdk_cp_bg_line_k_alpha10_1));
        this.hkt.setAutoChangeStyle(false);
        this.hkz = (ImageView) this.mView.findViewById(a.f.ala_follow_success_img);
        this.hkA = (RelativeLayout) this.mView.findViewById(a.f.guardClub);
        this.hkC = (TextView) this.mView.findViewById(a.f.guardClubToast);
        this.hkB = (RelativeLayout) this.mView.findViewById(a.f.follow_btn);
        RoundRectRelativeLayout roundRectRelativeLayout = (RoundRectRelativeLayout) this.mView.findViewById(a.f.roundRect);
        this.hky = (ImageView) this.mView.findViewById(a.f.ala_icon_back);
        if (TbadkCoreApplication.getInst().isHaokan()) {
            roundRectRelativeLayout.setCornerRadius(this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds30));
            this.hkB.setBackgroundResource(a.e.ala_live_follow_btn_radius_16_selector_hk);
            this.hkA.setBackgroundResource(a.e.ala_bg_guard_club);
        } else if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            roundRectRelativeLayout.setCornerRadius(this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds30));
            this.hkB.setBackgroundResource(a.e.ala_live_room_follow_btn_radius_16_selector_bd);
            this.hkA.setBackgroundResource(a.e.ala_bg_guard_club_bd);
        } else {
            roundRectRelativeLayout.setCornerRadius(this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds30));
            this.hkB.setBackgroundResource(a.e.ala_live_follow_btn_radius_16_selector_qm);
            this.hkA.setBackgroundResource(a.e.ala_bg_guard_club_qm);
        }
        this.hky = (ImageView) this.mView.findViewById(a.f.ala_icon_back);
        if (UtilHelper.getRealScreenOrientation(this.mContext) == 2) {
            this.hky.setVisibility(0);
        } else {
            this.hky.setVisibility(8);
        }
        this.hky.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.p.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.gWq.p(b.this.hky, 19);
            }
        });
    }

    public void n(View.OnClickListener onClickListener) {
        this.hkB.setOnClickListener(onClickListener);
    }

    public void a(c cVar) {
        this.gWj = cVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ns(boolean z) {
        if (z) {
            this.hkA.setVisibility(0);
            this.hkx.setVisibility(0);
            this.hkB.setVisibility(0);
            return;
        }
        this.hkA.setVisibility(8);
        this.hkB.setVisibility(4);
    }

    public void nt(boolean z) {
        if (TbadkCoreApplication.sAlaLiveSwitchData == null || (!TbadkCoreApplication.sAlaLiveSwitchData.isFollowBtnUnabled() && !TbadkCoreApplication.sAlaLiveSwitchData.isGuardFansUnabled())) {
            if (!z || this.bgC) {
                cdk();
            } else {
                if (this.gWj != null) {
                    this.gWj.onClick();
                }
                cdl();
            }
        } else if (TbadkCoreApplication.sAlaLiveSwitchData != null && !TbadkCoreApplication.sAlaLiveSwitchData.isFollowBtnUnabled() && TbadkCoreApplication.sAlaLiveSwitchData.isGuardFansUnabled()) {
            cde();
        }
        if (!this.isHost && this.hkD != null && this.hkD.mLiveInfo != null && this.hkD.aIV != null) {
            long j = this.hkD.aIV.userId;
            if (!this.hkG.contains(Long.valueOf(j))) {
                this.hkG.add(Long.valueOf(j));
                LogManager.getGuardClubLogger().doDisplayLiveGuardButtonLog(this.hkD.mLiveInfo.live_id + "", this.hkD.mLiveInfo.room_id + "", this.hkD.mLiveInfo.feed_id, this.otherParams);
            }
        }
    }

    private void cdk() {
        this.hku.setVisibility(8);
        this.hkx.setAlpha(1.0f);
        this.hkx.setScaleX(1.0f);
        this.hkx.setScaleY(1.0f);
        this.hkx.setVisibility(0);
        this.hkC.setVisibility(4);
        this.hkA.setTranslationX(this.hkR);
        this.hkA.getLayoutParams().width = this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds88);
        this.hkA.setVisibility(0);
    }

    public void cde() {
        this.hkB.setVisibility(4);
    }

    private void cdl() {
        if (!this.hkF && this.hkx.getVisibility() != 0) {
            this.hkF = true;
            this.hkQ = cdu();
            this.hkP = cdt();
            this.hkO = new AnimatorSet();
            this.hkO.play(this.hkP).after(this.hkQ);
            this.hkN = c(this.hkO);
            ValueAnimator cdr = cdr();
            ObjectAnimator cds = cds();
            this.hkM = new AnimatorSet();
            this.hkM.setStartDelay(IMConnection.RETRY_DELAY_TIMES);
            this.hkM.play(cds).with(cdr);
            ObjectAnimator cdq = cdq();
            ObjectAnimator cdp = cdp();
            this.hkL = new AnimatorSet();
            this.hkL.setStartDelay(958L);
            this.hkL.play(cdp).with(cdq);
            this.hkK = cdo();
            AnimatorSet cdn = cdn();
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.play(cdn).after(this.hkK);
            this.hkJ = cdm();
            AnimatorSet a2 = a(animatorSet);
            this.hkI = new AnimatorSet();
            this.hkI.play(a2).after(this.hkJ);
            this.hkI.start();
        }
    }

    private AnimatorSet a(final AnimatorSet animatorSet) {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.hku, "scaleX", 1.15f, 0.0f).setDuration(210L);
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.hku, "scaleY", 1.15f, 0.0f).setDuration(210L);
        AnimatorSet animatorSet2 = new AnimatorSet();
        animatorSet2.play(duration).with(duration2);
        animatorSet2.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.liveroom.p.b.7
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                b.this.hku.setVisibility(8);
                b.this.hku.setScaleX(1.0f);
                b.this.hku.setScaleY(1.0f);
                b.this.b(animatorSet);
            }
        });
        return animatorSet2;
    }

    private AnimatorSet cdm() {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.hku, "scaleX", 1.0f, 1.15f).setDuration(42L);
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.hku, "scaleY", 1.0f, 1.15f).setDuration(42L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(duration).with(duration2);
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.liveroom.p.b.8
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                b.this.hku.setScaleX(1.15f);
                b.this.hku.setScaleY(1.15f);
            }
        });
        return animatorSet;
    }

    private AnimatorSet cdn() {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.hkz, "scaleX", 1.15f, 1.0f).setDuration(42L);
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.hkz, "scaleY", 1.15f, 1.0f).setDuration(42L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(duration).with(duration2);
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.liveroom.p.b.9
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                b.this.b(b.this.hkL);
            }
        });
        return animatorSet;
    }

    private AnimatorSet cdo() {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.hkz, "scaleX", 0.0f, 1.15f).setDuration(210L);
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.hkz, "scaleY", 0.0f, 1.15f).setDuration(210L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(duration).with(duration2);
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.liveroom.p.b.10
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                b.this.hkz.setVisibility(0);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                b.this.hkz.setScaleX(1.15f);
                b.this.hkz.setScaleY(1.15f);
            }
        });
        return animatorSet;
    }

    private ObjectAnimator cdp() {
        this.hkR = this.hkA.getTranslationX();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.hkA, "translationX", this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds180) + this.hkR, this.hkR);
        ofFloat.setDuration(375L);
        ofFloat.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.liveroom.p.b.11
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                b.this.hkA.getLayoutParams().width = b.this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds180);
                b.this.hkx.setVisibility(4);
                b.this.hkA.setVisibility(0);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                b.this.b(b.this.hkM);
            }
        });
        return ofFloat;
    }

    private ObjectAnimator cdq() {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.hkC, "alpha", 0.0f, 1.0f).setDuration(210L);
        duration.setStartDelay(165L);
        duration.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.liveroom.p.b.12
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                b.this.hkC.setVisibility(0);
            }
        });
        return duration;
    }

    private ValueAnimator cdr() {
        ValueAnimator ofInt = ValueAnimator.ofInt(this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds180), this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds88));
        ofInt.setInterpolator(new FastOutLinearInInterpolator());
        ofInt.setDuration(542L);
        ofInt.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.liveroom.p.b.13
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                b.this.b(b.this.hkN);
            }
        });
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.ala.liveroom.p.b.14
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                b.this.hkA.getLayoutParams().width = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                b.this.hkA.requestLayout();
            }
        });
        return ofInt;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(AnimatorSet animatorSet) {
        if (this.hkF && animatorSet != null) {
            animatorSet.start();
        }
    }

    private ObjectAnimator cds() {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.hkC, "alpha", 1.0f, 0.0f).setDuration(210L);
        duration.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.liveroom.p.b.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                b.this.hkC.setVisibility(4);
                b.this.hkC.setAlpha(1.0f);
            }
        });
        return duration;
    }

    private AnimatorSet c(AnimatorSet animatorSet) {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.hkx, "alpha", 0.0f, 1.0f).setDuration(292L);
        AnimatorSet animatorSet2 = new AnimatorSet();
        animatorSet2.setStartDelay(250L);
        animatorSet2.play(animatorSet).with(duration);
        return animatorSet2;
    }

    private AnimatorSet cdt() {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.hkx, "scaleX", 1.15f, 1.0f).setDuration(84L);
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.hkx, "scaleY", 1.15f, 1.0f).setDuration(84L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(duration).with(duration2);
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.liveroom.p.b.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                b.this.hkF = false;
                if (b.this.gWj != null) {
                    b.this.gWj.endAnimation();
                }
            }
        });
        return animatorSet;
    }

    private AnimatorSet cdu() {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.hkx, "scaleX", 0.0f, 1.15f).setDuration(292L);
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.hkx, "scaleY", 0.0f, 1.15f).setDuration(292L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(duration).with(duration2);
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.liveroom.p.b.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                b.this.hkx.setScaleX(1.15f);
                b.this.hkx.setScaleY(1.15f);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                b.this.hkx.setVisibility(0);
            }
        });
        return animatorSet;
    }

    public void cdd() {
        if (this.hkF) {
            this.hkF = false;
            cancelAnimation();
        }
        this.hku.setScaleY(1.0f);
        this.hku.setScaleX(1.0f);
        this.hku.setVisibility(0);
        this.hkB.setVisibility(0);
        this.hkz.setVisibility(4);
        this.hkx.setVisibility(4);
        this.hkC.setVisibility(4);
        this.hkA.setVisibility(8);
    }

    public View getView() {
        return this.mView;
    }

    public void eY(long j) {
        if (j > this.hkH) {
            this.hkH = j;
            this.giP.setText(String.format(this.mContext.getString(a.h.sdk_live_charm), StringHelper.formatForCharmValue(j)));
        }
    }

    public void a(w wVar, final boolean z, final String str) {
        boolean z2 = this.hkD == null || this.hkD.mLiveInfo == null || wVar == null || wVar.mLiveInfo == null || this.hkD.mLiveInfo.live_id != wVar.mLiveInfo.live_id;
        this.hkD = wVar;
        this.otherParams = str;
        this.isHost = z;
        if (this.hkD != null && this.hkD.aIV != null) {
            this.hkt.stopLoad();
            this.hkt.startLoad(this.hkD.aIV.portrait, 12, false, false);
            String str2 = this.hkD.aIV.userName;
            if (TextHelper.getTextLengthWithEmoji(str2) > 14) {
                str2 = TextHelper.subStringWithEmoji(str2, 14) + StringHelper.STRING_MORE;
            }
            this.ewx.setText(str2);
            if (z2 || wVar.aIV.charmCount > this.hkH) {
                this.hkH = wVar.aIV.charmCount;
                this.giP.setText(String.format(this.mContext.getString(a.h.sdk_live_charm), StringHelper.formatForCharmValue(this.hkH)));
            }
            this.hkA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.p.b.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    b.this.cdv();
                    if (!z && b.this.hkD != null && b.this.hkD.mLiveInfo != null) {
                        LogManager.getGuardClubLogger().doClickLiveGuardButtonLog(b.this.hkD.mLiveInfo.live_id + "", b.this.hkD.mLiveInfo.room_id + "", b.this.hkD.mLiveInfo.feed_id, str);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cdv() {
        Hn(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Hn(String str) {
        if (this.mContext != null && this.hkD != null && this.hkD.aIV != null && this.hkD.mLiveInfo != null) {
            long j = this.hkD.aIV.userId;
            long j2 = this.hkD.mLiveInfo.live_id;
            long j3 = this.hkD.mLiveInfo.room_id;
            String str2 = this.hkD.mLiveInfo.feed_id;
            GuardClubInfoActivityConfig guardClubInfoActivityConfig = new GuardClubInfoActivityConfig(this.mContext, j, j2, this.isHost, this.otherParams, false, str);
            guardClubInfoActivityConfig.setRoomId(j3);
            guardClubInfoActivityConfig.setFeedId(str2);
            guardClubInfoActivityConfig.setIsClubMember(this.bgC);
            guardClubInfoActivityConfig.setAnchorInfo(this.hkD.aIV.nickName, this.hkD.aIV.portrait);
            guardClubInfoActivityConfig.setRequestCode(RequestResponseCode.REQUEST_GUARD_CLUB_INFO);
            guardClubInfoActivityConfig.setIntentAction(IntentAction.ActivityForResult);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, guardClubInfoActivityConfig));
        }
    }

    public void cdh() {
        cancelAnimation();
        if (this.hkF) {
            cdk();
            this.hkF = false;
        }
        setLevel(0);
    }

    public void onDestroy() {
        if (this.gEZ != null) {
            MessageManager.getInstance().unRegisterListener(this.gEZ);
        }
        cancelAnimation();
        if (this.handler != null) {
            this.handler.removeCallbacksAndMessages(null);
        }
        this.hkG.clear();
    }

    private void cancelAnimation() {
        if (this.hkI != null) {
            this.hkI.removeAllListeners();
            this.hkI.cancel();
        }
        if (this.hkJ != null) {
            this.hkJ.removeAllListeners();
            this.hkJ.cancel();
        }
        if (this.hkK != null) {
            this.hkK.removeAllListeners();
            this.hkK.cancel();
        }
        if (this.hkL != null) {
            this.hkL.removeAllListeners();
            this.hkL.cancel();
        }
        if (this.hkM != null) {
            this.hkM.removeAllListeners();
            this.hkM.cancel();
        }
        if (this.hkN != null) {
            this.hkN.removeAllListeners();
            this.hkN.cancel();
        }
        if (this.hkO != null) {
            this.hkO.removeAllListeners();
            this.hkO.cancel();
        }
        if (this.hkP != null) {
            this.hkP.removeAllListeners();
            this.hkP.cancel();
        }
        if (this.hkQ != null) {
            this.hkQ.removeAllListeners();
            this.hkQ.cancel();
        }
    }

    public void a(com.baidu.tieba.ala.liveroom.operation.b bVar) {
        this.gWq = bVar;
    }

    public void nu(boolean z) {
        this.bgC = z;
    }

    public void setLevel(int i) {
        if (this.hkw != null) {
            if (i <= 0) {
                this.hkw.setText("");
            } else {
                this.hkw.setText(String.valueOf(i));
            }
        }
    }

    public HeadImageView cdw() {
        return this.hkt;
    }
}
