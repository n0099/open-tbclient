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
    private TextView eqE;
    private c gQf;
    private com.baidu.tieba.ala.liveroom.operation.b gQm;
    private TextView gcZ;
    private Handler handler;
    private TextView heA;
    private ViewGroup heB;
    private ImageView heC;
    private ImageView heD;
    private RelativeLayout heE;
    private RelativeLayout heF;
    private TextView heG;
    private w heH;
    private AnimatorSet heM;
    private AnimatorSet heN;
    private AnimatorSet heO;
    private AnimatorSet heP;
    private AnimatorSet heQ;
    private AnimatorSet heR;
    private AnimatorSet heS;
    private AnimatorSet heT;
    private AnimatorSet heU;
    private float heV;
    private HeadImageView hex;
    private TextView hey;
    private ImageView hez;
    private boolean isHost;
    private Context mContext;
    private String otherParams;
    private View mView = null;
    private int heI = 30000;
    public boolean heJ = false;
    private boolean bfh = false;
    private Set<Long> heK = new HashSet();
    private long heL = 0;
    CustomMessageListener gzl = new CustomMessageListener(2913106) { // from class: com.baidu.tieba.ala.liveroom.p.b.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof String) {
                b.this.Ha((String) customResponsedMessage.getData());
            } else {
                b.this.caU();
            }
        }
    };

    public b(Context context) {
        this.mContext = context;
        initView();
        MessageManager.getInstance().registerListener(this.gzl);
        this.handler = new Handler();
    }

    public void setId(int i) {
        this.mView.setId(i);
    }

    private void initView() {
        this.mView = View.inflate(this.mContext, a.h.hk_liveroom_hostheader_layout, null);
        this.mView.setBackgroundResource(a.f.sdk_round_host_bg);
        this.hey = (TextView) this.mView.findViewById(a.g.ala_liveroom_hostheader_attention);
        this.heA = (TextView) this.mView.findViewById(a.g.tv_guardClub_level);
        this.hex = (HeadImageView) this.mView.findViewById(a.g.ala_liveroom_hostheader_image);
        this.eqE = (TextView) this.mView.findViewById(a.g.ala_liveroom_hostheader_guest);
        this.gcZ = (TextView) this.mView.findViewById(a.g.ala_liveroom_hostheader_address);
        this.heB = (ViewGroup) this.mView.findViewById(a.g.fl_guardClubEnter);
        this.hez = (ImageView) this.mView.findViewById(a.g.guardClubEnter_imageView);
        this.hex.setIsRound(true);
        this.hex.setBorderColor(this.mContext.getResources().getColor(a.d.sdk_cp_bg_line_k_alpha10_1));
        this.hex.setAutoChangeStyle(false);
        this.heD = (ImageView) this.mView.findViewById(a.g.ala_follow_success_img);
        this.heE = (RelativeLayout) this.mView.findViewById(a.g.guardClub);
        this.heG = (TextView) this.mView.findViewById(a.g.guardClubToast);
        this.heF = (RelativeLayout) this.mView.findViewById(a.g.follow_btn);
        RoundRectRelativeLayout roundRectRelativeLayout = (RoundRectRelativeLayout) this.mView.findViewById(a.g.roundRect);
        this.heC = (ImageView) this.mView.findViewById(a.g.ala_icon_back);
        if (TbadkCoreApplication.getInst().isHaokan()) {
            roundRectRelativeLayout.setCornerRadius(this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds30));
            this.heF.setBackgroundResource(a.f.ala_live_follow_btn_radius_16_selector_hk);
            this.heE.setBackgroundResource(a.f.ala_bg_guard_club);
        } else if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            roundRectRelativeLayout.setCornerRadius(this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds30));
            this.heF.setBackgroundResource(a.f.ala_live_room_follow_btn_radius_16_selector_bd);
            this.heE.setBackgroundResource(a.f.ala_bg_guard_club_bd);
        } else {
            roundRectRelativeLayout.setCornerRadius(this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds30));
            this.heF.setBackgroundResource(a.f.ala_live_follow_btn_radius_16_selector_qm);
            this.heE.setBackgroundResource(a.f.ala_bg_guard_club_qm);
        }
        this.heC = (ImageView) this.mView.findViewById(a.g.ala_icon_back);
        if (UtilHelper.getRealScreenOrientation(this.mContext) == 2) {
            this.heC.setVisibility(0);
        } else {
            this.heC.setVisibility(8);
        }
        this.heC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.p.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.gQm.p(b.this.heC, 19);
            }
        });
    }

    public void m(View.OnClickListener onClickListener) {
        this.heF.setOnClickListener(onClickListener);
    }

    public void a(c cVar) {
        this.gQf = cVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void nj(boolean z) {
        if (z) {
            this.heE.setVisibility(0);
            this.heB.setVisibility(0);
            this.heF.setVisibility(0);
            return;
        }
        this.heE.setVisibility(8);
        this.heF.setVisibility(4);
    }

    public void nk(boolean z) {
        if (TbadkCoreApplication.sAlaLiveSwitchData == null || (!TbadkCoreApplication.sAlaLiveSwitchData.isFollowBtnUnabled() && !TbadkCoreApplication.sAlaLiveSwitchData.isGuardFansUnabled())) {
            if (!z || this.bfh) {
                caJ();
            } else {
                if (this.gQf != null) {
                    this.gQf.onClick();
                }
                caK();
            }
        } else if (TbadkCoreApplication.sAlaLiveSwitchData != null && !TbadkCoreApplication.sAlaLiveSwitchData.isFollowBtnUnabled() && TbadkCoreApplication.sAlaLiveSwitchData.isGuardFansUnabled()) {
            caD();
        }
        if (!this.isHost && this.heH != null && this.heH.mLiveInfo != null && this.heH.aIe != null) {
            long j = this.heH.aIe.userId;
            if (!this.heK.contains(Long.valueOf(j))) {
                this.heK.add(Long.valueOf(j));
                LogManager.getGuardClubLogger().doDisplayLiveGuardButtonLog(this.heH.mLiveInfo.live_id + "", this.heH.mLiveInfo.room_id + "", this.heH.mLiveInfo.feed_id, this.otherParams);
            }
        }
    }

    private void caJ() {
        this.hey.setVisibility(8);
        this.heB.setAlpha(1.0f);
        this.heB.setScaleX(1.0f);
        this.heB.setScaleY(1.0f);
        this.heB.setVisibility(0);
        this.heG.setVisibility(4);
        this.heE.setTranslationX(this.heV);
        this.heE.getLayoutParams().width = this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds88);
        this.heE.setVisibility(0);
    }

    public void caD() {
        this.heF.setVisibility(4);
    }

    private void caK() {
        if (!this.heJ && this.heB.getVisibility() != 0) {
            this.heJ = true;
            this.heU = caT();
            this.heT = caS();
            this.heS = new AnimatorSet();
            this.heS.play(this.heT).after(this.heU);
            this.heR = c(this.heS);
            ValueAnimator caQ = caQ();
            ObjectAnimator caR = caR();
            this.heQ = new AnimatorSet();
            this.heQ.setStartDelay(IMConnection.RETRY_DELAY_TIMES);
            this.heQ.play(caR).with(caQ);
            ObjectAnimator caP = caP();
            ObjectAnimator caO = caO();
            this.heP = new AnimatorSet();
            this.heP.setStartDelay(958L);
            this.heP.play(caO).with(caP);
            this.heO = caN();
            AnimatorSet caM = caM();
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.play(caM).after(this.heO);
            this.heN = caL();
            AnimatorSet a2 = a(animatorSet);
            this.heM = new AnimatorSet();
            this.heM.play(a2).after(this.heN);
            this.heM.start();
        }
    }

    private AnimatorSet a(final AnimatorSet animatorSet) {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.hey, "scaleX", 1.15f, 0.0f).setDuration(210L);
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.hey, "scaleY", 1.15f, 0.0f).setDuration(210L);
        AnimatorSet animatorSet2 = new AnimatorSet();
        animatorSet2.play(duration).with(duration2);
        animatorSet2.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.liveroom.p.b.7
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                b.this.hey.setVisibility(8);
                b.this.hey.setScaleX(1.0f);
                b.this.hey.setScaleY(1.0f);
                b.this.b(animatorSet);
            }
        });
        return animatorSet2;
    }

    private AnimatorSet caL() {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.hey, "scaleX", 1.0f, 1.15f).setDuration(42L);
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.hey, "scaleY", 1.0f, 1.15f).setDuration(42L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(duration).with(duration2);
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.liveroom.p.b.8
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                b.this.hey.setScaleX(1.15f);
                b.this.hey.setScaleY(1.15f);
            }
        });
        return animatorSet;
    }

    private AnimatorSet caM() {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.heD, "scaleX", 1.15f, 1.0f).setDuration(42L);
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.heD, "scaleY", 1.15f, 1.0f).setDuration(42L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(duration).with(duration2);
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.liveroom.p.b.9
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                b.this.b(b.this.heP);
            }
        });
        return animatorSet;
    }

    private AnimatorSet caN() {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.heD, "scaleX", 0.0f, 1.15f).setDuration(210L);
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.heD, "scaleY", 0.0f, 1.15f).setDuration(210L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(duration).with(duration2);
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.liveroom.p.b.10
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                b.this.heD.setVisibility(0);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                b.this.heD.setScaleX(1.15f);
                b.this.heD.setScaleY(1.15f);
            }
        });
        return animatorSet;
    }

    private ObjectAnimator caO() {
        this.heV = this.heE.getTranslationX();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.heE, "translationX", this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds180) + this.heV, this.heV);
        ofFloat.setDuration(375L);
        ofFloat.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.liveroom.p.b.11
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                b.this.heE.getLayoutParams().width = b.this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds180);
                b.this.heB.setVisibility(4);
                b.this.heE.setVisibility(0);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                b.this.b(b.this.heQ);
            }
        });
        return ofFloat;
    }

    private ObjectAnimator caP() {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.heG, "alpha", 0.0f, 1.0f).setDuration(210L);
        duration.setStartDelay(165L);
        duration.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.liveroom.p.b.12
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                b.this.heG.setVisibility(0);
            }
        });
        return duration;
    }

    private ValueAnimator caQ() {
        ValueAnimator ofInt = ValueAnimator.ofInt(this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds180), this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds88));
        ofInt.setInterpolator(new FastOutLinearInInterpolator());
        ofInt.setDuration(542L);
        ofInt.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.liveroom.p.b.13
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                b.this.b(b.this.heR);
            }
        });
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.ala.liveroom.p.b.14
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                b.this.heE.getLayoutParams().width = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                b.this.heE.requestLayout();
            }
        });
        return ofInt;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(AnimatorSet animatorSet) {
        if (this.heJ && animatorSet != null) {
            animatorSet.start();
        }
    }

    private ObjectAnimator caR() {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.heG, "alpha", 1.0f, 0.0f).setDuration(210L);
        duration.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.liveroom.p.b.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                b.this.heG.setVisibility(4);
                b.this.heG.setAlpha(1.0f);
            }
        });
        return duration;
    }

    private AnimatorSet c(AnimatorSet animatorSet) {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.heB, "alpha", 0.0f, 1.0f).setDuration(292L);
        AnimatorSet animatorSet2 = new AnimatorSet();
        animatorSet2.setStartDelay(250L);
        animatorSet2.play(animatorSet).with(duration);
        return animatorSet2;
    }

    private AnimatorSet caS() {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.heB, "scaleX", 1.15f, 1.0f).setDuration(84L);
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.heB, "scaleY", 1.15f, 1.0f).setDuration(84L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(duration).with(duration2);
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.liveroom.p.b.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                b.this.heJ = false;
                if (b.this.gQf != null) {
                    b.this.gQf.endAnimation();
                }
            }
        });
        return animatorSet;
    }

    private AnimatorSet caT() {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.heB, "scaleX", 0.0f, 1.15f).setDuration(292L);
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.heB, "scaleY", 0.0f, 1.15f).setDuration(292L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(duration).with(duration2);
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.liveroom.p.b.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                b.this.heB.setScaleX(1.15f);
                b.this.heB.setScaleY(1.15f);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                b.this.heB.setVisibility(0);
            }
        });
        return animatorSet;
    }

    public void caC() {
        if (this.heJ) {
            this.heJ = false;
            cancelAnimation();
        }
        this.hey.setScaleY(1.0f);
        this.hey.setScaleX(1.0f);
        this.hey.setVisibility(0);
        this.heF.setVisibility(0);
        this.heD.setVisibility(4);
        this.heB.setVisibility(4);
        this.heG.setVisibility(4);
        this.heE.setVisibility(8);
    }

    public View getView() {
        return this.mView;
    }

    public void eC(long j) {
        if (j > this.heL) {
            this.heL = j;
            this.gcZ.setText(String.format(this.mContext.getString(a.i.sdk_live_charm), StringHelper.formatForCharmValue(j)));
        }
    }

    public void a(w wVar, final boolean z, final String str) {
        boolean z2 = this.heH == null || this.heH.mLiveInfo == null || wVar == null || wVar.mLiveInfo == null || this.heH.mLiveInfo.live_id != wVar.mLiveInfo.live_id;
        this.heH = wVar;
        this.otherParams = str;
        this.isHost = z;
        if (this.heH != null && this.heH.aIe != null) {
            this.hex.stopLoad();
            this.hex.startLoad(this.heH.aIe.portrait, 12, false, false);
            String str2 = this.heH.aIe.userName;
            if (TextHelper.getTextLengthWithEmoji(str2) > 14) {
                str2 = TextHelper.subStringWithEmoji(str2, 14) + StringHelper.STRING_MORE;
            }
            this.eqE.setText(str2);
            if (z2 || wVar.aIe.charmCount > this.heL) {
                this.heL = wVar.aIe.charmCount;
                this.gcZ.setText(String.format(this.mContext.getString(a.i.sdk_live_charm), StringHelper.formatForCharmValue(this.heL)));
            }
            this.heE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.p.b.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    b.this.caU();
                    if (!z && b.this.heH != null && b.this.heH.mLiveInfo != null) {
                        LogManager.getGuardClubLogger().doClickLiveGuardButtonLog(b.this.heH.mLiveInfo.live_id + "", b.this.heH.mLiveInfo.room_id + "", b.this.heH.mLiveInfo.feed_id, str);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void caU() {
        Ha(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ha(String str) {
        if (this.mContext != null && this.heH != null && this.heH.aIe != null && this.heH.mLiveInfo != null) {
            long j = this.heH.aIe.userId;
            long j2 = this.heH.mLiveInfo.live_id;
            long j3 = this.heH.mLiveInfo.room_id;
            String str2 = this.heH.mLiveInfo.feed_id;
            GuardClubInfoActivityConfig guardClubInfoActivityConfig = new GuardClubInfoActivityConfig(this.mContext, j, j2, this.isHost, this.otherParams, false, str);
            guardClubInfoActivityConfig.setRoomId(j3);
            guardClubInfoActivityConfig.setFeedId(str2);
            guardClubInfoActivityConfig.setIsClubMember(this.bfh);
            guardClubInfoActivityConfig.setRequestCode(RequestResponseCode.REQUEST_GUARD_CLUB_INFO);
            guardClubInfoActivityConfig.setIntentAction(IntentAction.ActivityForResult);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, guardClubInfoActivityConfig));
        }
    }

    public void caG() {
        cancelAnimation();
        if (this.heJ) {
            caJ();
            this.heJ = false;
        }
        setLevel(0);
    }

    public void onDestroy() {
        if (this.gzl != null) {
            MessageManager.getInstance().unRegisterListener(this.gzl);
        }
        cancelAnimation();
        if (this.handler != null) {
            this.handler.removeCallbacksAndMessages(null);
        }
        this.heK.clear();
    }

    private void cancelAnimation() {
        if (this.heM != null) {
            this.heM.removeAllListeners();
            this.heM.cancel();
        }
        if (this.heN != null) {
            this.heN.removeAllListeners();
            this.heN.cancel();
        }
        if (this.heO != null) {
            this.heO.removeAllListeners();
            this.heO.cancel();
        }
        if (this.heP != null) {
            this.heP.removeAllListeners();
            this.heP.cancel();
        }
        if (this.heQ != null) {
            this.heQ.removeAllListeners();
            this.heQ.cancel();
        }
        if (this.heR != null) {
            this.heR.removeAllListeners();
            this.heR.cancel();
        }
        if (this.heS != null) {
            this.heS.removeAllListeners();
            this.heS.cancel();
        }
        if (this.heT != null) {
            this.heT.removeAllListeners();
            this.heT.cancel();
        }
        if (this.heU != null) {
            this.heU.removeAllListeners();
            this.heU.cancel();
        }
    }

    public void a(com.baidu.tieba.ala.liveroom.operation.b bVar) {
        this.gQm = bVar;
    }

    public void nl(boolean z) {
        this.bfh = z;
    }

    public void setLevel(int i) {
        if (this.heA != null) {
            if (i <= 0) {
                this.heA.setText("");
            } else {
                this.heA.setText(String.valueOf(i));
            }
        }
    }

    public HeadImageView caV() {
        return this.hex;
    }
}
