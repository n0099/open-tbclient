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
import com.baidu.live.data.u;
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
    private TextView eig;
    private TextView fSW;
    private c gEq;
    private com.baidu.tieba.ala.liveroom.operation.b gEx;
    private HeadImageView gSK;
    private TextView gSL;
    private ImageView gSM;
    private TextView gSN;
    private ViewGroup gSO;
    private ImageView gSP;
    private ImageView gSQ;
    private RelativeLayout gSR;
    private RelativeLayout gSS;
    private TextView gST;
    private u gSU;
    private AnimatorSet gSZ;
    private AnimatorSet gTa;
    private AnimatorSet gTb;
    private AnimatorSet gTc;
    private AnimatorSet gTd;
    private AnimatorSet gTe;
    private AnimatorSet gTf;
    private AnimatorSet gTg;
    private AnimatorSet gTh;
    private float gTi;
    private Handler handler;
    private boolean isHost;
    private Context mContext;
    private String otherParams;
    private View mView = null;
    private int gSV = 30000;
    public boolean gSW = false;
    private boolean bdQ = false;
    private Set<Long> gSX = new HashSet();
    private long gSY = 0;
    CustomMessageListener gpg = new CustomMessageListener(2913106) { // from class: com.baidu.tieba.ala.liveroom.p.b.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof String) {
                b.this.GC((String) customResponsedMessage.getData());
            } else {
                b.this.bXU();
            }
        }
    };

    public b(Context context) {
        this.mContext = context;
        initView();
        MessageManager.getInstance().registerListener(this.gpg);
        this.handler = new Handler();
    }

    public void setId(int i) {
        this.mView.setId(i);
    }

    private void initView() {
        this.mView = View.inflate(this.mContext, a.h.hk_liveroom_hostheader_layout, null);
        this.mView.setBackgroundResource(a.f.sdk_round_host_bg);
        this.gSL = (TextView) this.mView.findViewById(a.g.ala_liveroom_hostheader_attention);
        this.gSN = (TextView) this.mView.findViewById(a.g.tv_guardClub_level);
        this.gSK = (HeadImageView) this.mView.findViewById(a.g.ala_liveroom_hostheader_image);
        this.eig = (TextView) this.mView.findViewById(a.g.ala_liveroom_hostheader_guest);
        this.fSW = (TextView) this.mView.findViewById(a.g.ala_liveroom_hostheader_address);
        this.gSO = (ViewGroup) this.mView.findViewById(a.g.fl_guardClubEnter);
        this.gSM = (ImageView) this.mView.findViewById(a.g.guardClubEnter_imageView);
        this.gSK.setIsRound(true);
        this.gSK.setBorderColor(this.mContext.getResources().getColor(a.d.sdk_cp_bg_line_k_alpha10_1));
        this.gSK.setAutoChangeStyle(false);
        this.gSQ = (ImageView) this.mView.findViewById(a.g.ala_follow_success_img);
        this.gSR = (RelativeLayout) this.mView.findViewById(a.g.guardClub);
        this.gST = (TextView) this.mView.findViewById(a.g.guardClubToast);
        this.gSS = (RelativeLayout) this.mView.findViewById(a.g.follow_btn);
        RoundRectRelativeLayout roundRectRelativeLayout = (RoundRectRelativeLayout) this.mView.findViewById(a.g.roundRect);
        this.gSP = (ImageView) this.mView.findViewById(a.g.ala_icon_back);
        if (TbadkCoreApplication.getInst().isHaokan()) {
            roundRectRelativeLayout.setCornerRadius(this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds30));
            this.gSS.setBackgroundResource(a.f.ala_live_follow_btn_radius_16_selector_hk);
            this.gSR.setBackgroundResource(a.f.ala_bg_guard_club);
        } else if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            roundRectRelativeLayout.setCornerRadius(this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds30));
            this.gSS.setBackgroundResource(a.f.ala_live_room_follow_btn_radius_16_selector_bd);
            this.gSR.setBackgroundResource(a.f.ala_bg_guard_club_bd);
        } else {
            roundRectRelativeLayout.setCornerRadius(this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds30));
            this.gSS.setBackgroundResource(a.f.ala_live_follow_btn_radius_16_selector_qm);
            this.gSR.setBackgroundResource(a.f.ala_bg_guard_club_qm);
        }
        this.gSP = (ImageView) this.mView.findViewById(a.g.ala_icon_back);
        if (UtilHelper.getRealScreenOrientation(this.mContext) == 2) {
            this.gSP.setVisibility(0);
        } else {
            this.gSP.setVisibility(8);
        }
        this.gSP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.p.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.gEx.o(b.this.gSP, 19);
            }
        });
    }

    public void m(View.OnClickListener onClickListener) {
        this.gSS.setOnClickListener(onClickListener);
    }

    public void a(c cVar) {
        this.gEq = cVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void mT(boolean z) {
        if (z) {
            this.gSR.setVisibility(0);
            this.gSO.setVisibility(0);
            this.gSS.setVisibility(0);
            return;
        }
        this.gSR.setVisibility(8);
        this.gSS.setVisibility(4);
    }

    public void mU(boolean z) {
        if (TbadkCoreApplication.sAlaLiveSwitchData == null || (!TbadkCoreApplication.sAlaLiveSwitchData.isFollowBtnUnabled() && !TbadkCoreApplication.sAlaLiveSwitchData.isGuardFansUnabled())) {
            if (!z || this.bdQ) {
                bXJ();
            } else {
                if (this.gEq != null) {
                    this.gEq.onClick();
                }
                bXK();
            }
        } else if (TbadkCoreApplication.sAlaLiveSwitchData != null && !TbadkCoreApplication.sAlaLiveSwitchData.isFollowBtnUnabled() && TbadkCoreApplication.sAlaLiveSwitchData.isGuardFansUnabled()) {
            bXE();
        }
        if (!this.isHost && this.gSU != null && this.gSU.mLiveInfo != null && this.gSU.aHD != null) {
            long j = this.gSU.aHD.userId;
            if (!this.gSX.contains(Long.valueOf(j))) {
                this.gSX.add(Long.valueOf(j));
                LogManager.getGuardClubLogger().doDisplayLiveGuardButtonLog(this.gSU.mLiveInfo.live_id + "", this.gSU.mLiveInfo.room_id + "", this.gSU.mLiveInfo.feed_id, this.otherParams);
            }
        }
    }

    private void bXJ() {
        this.gSL.setVisibility(8);
        this.gSO.setAlpha(1.0f);
        this.gSO.setScaleX(1.0f);
        this.gSO.setScaleY(1.0f);
        this.gSO.setVisibility(0);
        this.gST.setVisibility(4);
        this.gSR.setTranslationX(this.gTi);
        this.gSR.getLayoutParams().width = this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds88);
        this.gSR.setVisibility(0);
    }

    public void bXE() {
        this.gSS.setVisibility(4);
    }

    private void bXK() {
        if (!this.gSW && this.gSO.getVisibility() != 0) {
            this.gSW = true;
            this.gTh = bXT();
            this.gTg = bXS();
            this.gTf = new AnimatorSet();
            this.gTf.play(this.gTg).after(this.gTh);
            this.gTe = c(this.gTf);
            ValueAnimator bXQ = bXQ();
            ObjectAnimator bXR = bXR();
            this.gTd = new AnimatorSet();
            this.gTd.setStartDelay(IMConnection.RETRY_DELAY_TIMES);
            this.gTd.play(bXR).with(bXQ);
            ObjectAnimator bXP = bXP();
            ObjectAnimator bXO = bXO();
            this.gTc = new AnimatorSet();
            this.gTc.setStartDelay(958L);
            this.gTc.play(bXO).with(bXP);
            this.gTb = bXN();
            AnimatorSet bXM = bXM();
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.play(bXM).after(this.gTb);
            this.gTa = bXL();
            AnimatorSet a2 = a(animatorSet);
            this.gSZ = new AnimatorSet();
            this.gSZ.play(a2).after(this.gTa);
            this.gSZ.start();
        }
    }

    private AnimatorSet a(final AnimatorSet animatorSet) {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.gSL, "scaleX", 1.15f, 0.0f).setDuration(210L);
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.gSL, "scaleY", 1.15f, 0.0f).setDuration(210L);
        AnimatorSet animatorSet2 = new AnimatorSet();
        animatorSet2.play(duration).with(duration2);
        animatorSet2.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.liveroom.p.b.7
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                b.this.gSL.setVisibility(8);
                b.this.gSL.setScaleX(1.0f);
                b.this.gSL.setScaleY(1.0f);
                b.this.b(animatorSet);
            }
        });
        return animatorSet2;
    }

    private AnimatorSet bXL() {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.gSL, "scaleX", 1.0f, 1.15f).setDuration(42L);
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.gSL, "scaleY", 1.0f, 1.15f).setDuration(42L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(duration).with(duration2);
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.liveroom.p.b.8
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                b.this.gSL.setScaleX(1.15f);
                b.this.gSL.setScaleY(1.15f);
            }
        });
        return animatorSet;
    }

    private AnimatorSet bXM() {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.gSQ, "scaleX", 1.15f, 1.0f).setDuration(42L);
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.gSQ, "scaleY", 1.15f, 1.0f).setDuration(42L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(duration).with(duration2);
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.liveroom.p.b.9
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                b.this.b(b.this.gTc);
            }
        });
        return animatorSet;
    }

    private AnimatorSet bXN() {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.gSQ, "scaleX", 0.0f, 1.15f).setDuration(210L);
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.gSQ, "scaleY", 0.0f, 1.15f).setDuration(210L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(duration).with(duration2);
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.liveroom.p.b.10
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                b.this.gSQ.setVisibility(0);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                b.this.gSQ.setScaleX(1.15f);
                b.this.gSQ.setScaleY(1.15f);
            }
        });
        return animatorSet;
    }

    private ObjectAnimator bXO() {
        this.gTi = this.gSR.getTranslationX();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.gSR, "translationX", this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds180) + this.gTi, this.gTi);
        ofFloat.setDuration(375L);
        ofFloat.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.liveroom.p.b.11
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                b.this.gSR.getLayoutParams().width = b.this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds180);
                b.this.gSO.setVisibility(4);
                b.this.gSR.setVisibility(0);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                b.this.b(b.this.gTd);
            }
        });
        return ofFloat;
    }

    private ObjectAnimator bXP() {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.gST, "alpha", 0.0f, 1.0f).setDuration(210L);
        duration.setStartDelay(165L);
        duration.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.liveroom.p.b.12
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                b.this.gST.setVisibility(0);
            }
        });
        return duration;
    }

    private ValueAnimator bXQ() {
        ValueAnimator ofInt = ValueAnimator.ofInt(this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds180), this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds88));
        ofInt.setInterpolator(new FastOutLinearInInterpolator());
        ofInt.setDuration(542L);
        ofInt.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.liveroom.p.b.13
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                b.this.b(b.this.gTe);
            }
        });
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.ala.liveroom.p.b.14
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                b.this.gSR.getLayoutParams().width = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                b.this.gSR.requestLayout();
            }
        });
        return ofInt;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(AnimatorSet animatorSet) {
        if (this.gSW && animatorSet != null) {
            animatorSet.start();
        }
    }

    private ObjectAnimator bXR() {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.gST, "alpha", 1.0f, 0.0f).setDuration(210L);
        duration.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.liveroom.p.b.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                b.this.gST.setVisibility(4);
                b.this.gST.setAlpha(1.0f);
            }
        });
        return duration;
    }

    private AnimatorSet c(AnimatorSet animatorSet) {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.gSO, "alpha", 0.0f, 1.0f).setDuration(292L);
        AnimatorSet animatorSet2 = new AnimatorSet();
        animatorSet2.setStartDelay(250L);
        animatorSet2.play(animatorSet).with(duration);
        return animatorSet2;
    }

    private AnimatorSet bXS() {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.gSO, "scaleX", 1.15f, 1.0f).setDuration(84L);
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.gSO, "scaleY", 1.15f, 1.0f).setDuration(84L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(duration).with(duration2);
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.liveroom.p.b.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                b.this.gSW = false;
                if (b.this.gEq != null) {
                    b.this.gEq.endAnimation();
                }
            }
        });
        return animatorSet;
    }

    private AnimatorSet bXT() {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.gSO, "scaleX", 0.0f, 1.15f).setDuration(292L);
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.gSO, "scaleY", 0.0f, 1.15f).setDuration(292L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(duration).with(duration2);
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.liveroom.p.b.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                b.this.gSO.setScaleX(1.15f);
                b.this.gSO.setScaleY(1.15f);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                b.this.gSO.setVisibility(0);
            }
        });
        return animatorSet;
    }

    public void bXD() {
        if (this.gSW) {
            this.gSW = false;
            cancelAnimation();
        }
        this.gSL.setScaleY(1.0f);
        this.gSL.setScaleX(1.0f);
        this.gSL.setVisibility(0);
        this.gSS.setVisibility(0);
        this.gSQ.setVisibility(4);
        this.gSO.setVisibility(4);
        this.gST.setVisibility(4);
        this.gSR.setVisibility(8);
    }

    public View getView() {
        return this.mView;
    }

    public void eA(long j) {
        if (j > this.gSY) {
            this.gSY = j;
            this.fSW.setText(String.format(this.mContext.getString(a.i.sdk_live_charm), StringHelper.formatForCharmValue(j)));
        }
    }

    public void a(u uVar, final boolean z, final String str) {
        boolean z2 = this.gSU == null || this.gSU.mLiveInfo == null || uVar == null || uVar.mLiveInfo == null || this.gSU.mLiveInfo.live_id != uVar.mLiveInfo.live_id;
        this.gSU = uVar;
        this.otherParams = str;
        this.isHost = z;
        if (this.gSU != null && this.gSU.aHD != null) {
            this.gSK.stopLoad();
            this.gSK.startLoad(this.gSU.aHD.portrait, 12, false, false);
            String str2 = this.gSU.aHD.userName;
            if (TextHelper.getTextLengthWithEmoji(str2) > 14) {
                str2 = TextHelper.subStringWithEmoji(str2, 14) + StringHelper.STRING_MORE;
            }
            this.eig.setText(str2);
            if (z2 || uVar.aHD.charmCount > this.gSY) {
                this.gSY = uVar.aHD.charmCount;
                this.fSW.setText(String.format(this.mContext.getString(a.i.sdk_live_charm), StringHelper.formatForCharmValue(this.gSY)));
            }
            this.gSR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.p.b.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    b.this.bXU();
                    if (!z && b.this.gSU != null && b.this.gSU.mLiveInfo != null) {
                        LogManager.getGuardClubLogger().doClickLiveGuardButtonLog(b.this.gSU.mLiveInfo.live_id + "", b.this.gSU.mLiveInfo.room_id + "", b.this.gSU.mLiveInfo.feed_id, str);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bXU() {
        GC(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GC(String str) {
        if (this.mContext != null && this.gSU != null && this.gSU.aHD != null && this.gSU.mLiveInfo != null) {
            long j = this.gSU.aHD.userId;
            long j2 = this.gSU.mLiveInfo.live_id;
            long j3 = this.gSU.mLiveInfo.room_id;
            String str2 = this.gSU.mLiveInfo.feed_id;
            GuardClubInfoActivityConfig guardClubInfoActivityConfig = new GuardClubInfoActivityConfig(this.mContext, j, j2, this.isHost, this.otherParams, false, str);
            guardClubInfoActivityConfig.setRoomId(j3);
            guardClubInfoActivityConfig.setFeedId(str2);
            guardClubInfoActivityConfig.setIsClubMember(this.bdQ);
            guardClubInfoActivityConfig.setRequestCode(RequestResponseCode.REQUEST_GUARD_CLUB_INFO);
            guardClubInfoActivityConfig.setIntentAction(IntentAction.ActivityForResult);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, guardClubInfoActivityConfig));
        }
    }

    public void bXH() {
        cancelAnimation();
        if (this.gSW) {
            bXJ();
            this.gSW = false;
        }
        setLevel(0);
    }

    public void onDestroy() {
        if (this.gpg != null) {
            MessageManager.getInstance().unRegisterListener(this.gpg);
        }
        cancelAnimation();
        if (this.handler != null) {
            this.handler.removeCallbacksAndMessages(null);
        }
        this.gSX.clear();
    }

    private void cancelAnimation() {
        if (this.gSZ != null) {
            this.gSZ.removeAllListeners();
            this.gSZ.cancel();
        }
        if (this.gTa != null) {
            this.gTa.removeAllListeners();
            this.gTa.cancel();
        }
        if (this.gTb != null) {
            this.gTb.removeAllListeners();
            this.gTb.cancel();
        }
        if (this.gTc != null) {
            this.gTc.removeAllListeners();
            this.gTc.cancel();
        }
        if (this.gTd != null) {
            this.gTd.removeAllListeners();
            this.gTd.cancel();
        }
        if (this.gTe != null) {
            this.gTe.removeAllListeners();
            this.gTe.cancel();
        }
        if (this.gTf != null) {
            this.gTf.removeAllListeners();
            this.gTf.cancel();
        }
        if (this.gTg != null) {
            this.gTg.removeAllListeners();
            this.gTg.cancel();
        }
        if (this.gTh != null) {
            this.gTh.removeAllListeners();
            this.gTh.cancel();
        }
    }

    public void a(com.baidu.tieba.ala.liveroom.operation.b bVar) {
        this.gEx = bVar;
    }

    public void mV(boolean z) {
        this.bdQ = z;
    }

    public void setLevel(int i) {
        if (this.gSN != null) {
            if (i <= 0) {
                this.gSN.setText("");
            } else {
                this.gSN.setText(String.valueOf(i));
            }
        }
    }
}
