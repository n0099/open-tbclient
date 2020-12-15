package com.baidu.tieba.ala.liveroom.o;

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
    private TextView eBQ;
    private TextView gqH;
    private Handler handler;
    private c hfo;
    private com.baidu.tieba.ala.liveroom.operation.b hfw;
    private HeadImageView htA;
    private TextView htB;
    private ImageView htC;
    private TextView htD;
    private ViewGroup htE;
    private ImageView htF;
    private ImageView htG;
    private RelativeLayout htH;
    private RelativeLayout htI;
    private TextView htJ;
    private w htK;
    private AnimatorSet htP;
    private AnimatorSet htQ;
    private AnimatorSet htR;
    private AnimatorSet htS;
    private AnimatorSet htT;
    private AnimatorSet htU;
    private AnimatorSet htV;
    private AnimatorSet htW;
    private AnimatorSet htX;
    private float htY;
    private boolean isHost;
    private Context mContext;
    private String otherParams;
    private View mView = null;
    private int htL = 30000;
    public boolean htM = false;
    private boolean bjf = false;
    private Set<Long> htN = new HashSet();
    private long htO = 0;
    CustomMessageListener gNG = new CustomMessageListener(2913106) { // from class: com.baidu.tieba.ala.liveroom.o.b.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof String) {
                b.this.HC((String) customResponsedMessage.getData());
            } else {
                b.this.cgH();
            }
        }
    };

    public b(Context context) {
        this.mContext = context;
        initView();
        MessageManager.getInstance().registerListener(this.gNG);
        this.handler = new Handler();
    }

    public void setId(int i) {
        this.mView.setId(i);
    }

    private void initView() {
        this.mView = View.inflate(this.mContext, a.g.hk_liveroom_hostheader_layout, null);
        this.mView.setBackgroundResource(a.e.sdk_round_host_bg);
        this.htB = (TextView) this.mView.findViewById(a.f.ala_liveroom_hostheader_attention);
        this.htD = (TextView) this.mView.findViewById(a.f.tv_guardClub_level);
        this.htA = (HeadImageView) this.mView.findViewById(a.f.ala_liveroom_hostheader_image);
        this.eBQ = (TextView) this.mView.findViewById(a.f.ala_liveroom_hostheader_guest);
        this.gqH = (TextView) this.mView.findViewById(a.f.ala_liveroom_hostheader_address);
        this.htE = (ViewGroup) this.mView.findViewById(a.f.fl_guardClubEnter);
        this.htC = (ImageView) this.mView.findViewById(a.f.guardClubEnter_imageView);
        this.htA.setIsRound(true);
        this.htA.setBorderColor(this.mContext.getResources().getColor(a.c.sdk_cp_bg_line_k_alpha10_1));
        this.htA.setAutoChangeStyle(false);
        this.htG = (ImageView) this.mView.findViewById(a.f.ala_follow_success_img);
        this.htH = (RelativeLayout) this.mView.findViewById(a.f.guardClub);
        this.htJ = (TextView) this.mView.findViewById(a.f.guardClubToast);
        this.htI = (RelativeLayout) this.mView.findViewById(a.f.follow_btn);
        RoundRectRelativeLayout roundRectRelativeLayout = (RoundRectRelativeLayout) this.mView.findViewById(a.f.roundRect);
        this.htF = (ImageView) this.mView.findViewById(a.f.ala_icon_back);
        if (TbadkCoreApplication.getInst().isHaokan()) {
            roundRectRelativeLayout.setCornerRadius(this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds30));
            this.htI.setBackgroundResource(a.e.ala_live_follow_btn_radius_16_selector_hk);
            this.htH.setBackgroundResource(a.e.ala_bg_guard_club);
        } else if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            roundRectRelativeLayout.setCornerRadius(this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds30));
            this.htI.setBackgroundResource(a.e.ala_live_room_follow_btn_radius_16_selector_bd);
            this.htH.setBackgroundResource(a.e.ala_bg_guard_club_bd);
        } else {
            roundRectRelativeLayout.setCornerRadius(this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds30));
            this.htI.setBackgroundResource(a.e.ala_live_follow_btn_radius_16_selector_qm);
            this.htH.setBackgroundResource(a.e.ala_bg_guard_club_qm);
        }
        this.htF = (ImageView) this.mView.findViewById(a.f.ala_icon_back);
        if (UtilHelper.getRealScreenOrientation(this.mContext) == 2) {
            this.htF.setVisibility(0);
        } else {
            this.htF.setVisibility(8);
        }
        this.htF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.o.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.hfw.s(b.this.htF, 19);
            }
        });
    }

    public void n(View.OnClickListener onClickListener) {
        this.htI.setOnClickListener(onClickListener);
    }

    public void a(c cVar) {
        this.hfo = cVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void nO(boolean z) {
        if (z) {
            this.htH.setVisibility(0);
            this.htE.setVisibility(0);
            this.htI.setVisibility(0);
            return;
        }
        this.htH.setVisibility(8);
        this.htI.setVisibility(4);
    }

    public void nP(boolean z) {
        if (TbadkCoreApplication.sAlaLiveSwitchData == null || (!TbadkCoreApplication.sAlaLiveSwitchData.isFollowBtnUnabled() && !TbadkCoreApplication.sAlaLiveSwitchData.isGuardFansUnabled())) {
            if (!z || this.bjf) {
                cgw();
            } else {
                if (this.hfo != null) {
                    this.hfo.onClick();
                }
                cgx();
            }
        } else if (TbadkCoreApplication.sAlaLiveSwitchData != null && !TbadkCoreApplication.sAlaLiveSwitchData.isFollowBtnUnabled() && TbadkCoreApplication.sAlaLiveSwitchData.isGuardFansUnabled()) {
            cgq();
        }
        if (!this.isHost && this.htK != null && this.htK.mLiveInfo != null && this.htK.aJV != null) {
            long j = this.htK.aJV.userId;
            if (!this.htN.contains(Long.valueOf(j))) {
                this.htN.add(Long.valueOf(j));
                LogManager.getGuardClubLogger().doDisplayLiveGuardButtonLog(this.htK.mLiveInfo.live_id + "", this.htK.mLiveInfo.room_id + "", this.htK.mLiveInfo.feed_id, this.otherParams);
            }
        }
    }

    private void cgw() {
        this.htB.setVisibility(8);
        this.htE.setAlpha(1.0f);
        this.htE.setScaleX(1.0f);
        this.htE.setScaleY(1.0f);
        this.htE.setVisibility(0);
        this.htJ.setVisibility(4);
        this.htH.setTranslationX(this.htY);
        this.htH.getLayoutParams().width = this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds88);
        this.htH.setVisibility(0);
    }

    public void cgq() {
        this.htI.setVisibility(4);
    }

    private void cgx() {
        if (!this.htM && this.htE.getVisibility() != 0) {
            this.htM = true;
            this.htX = cgG();
            this.htW = cgF();
            this.htV = new AnimatorSet();
            this.htV.play(this.htW).after(this.htX);
            this.htU = c(this.htV);
            ValueAnimator cgD = cgD();
            ObjectAnimator cgE = cgE();
            this.htT = new AnimatorSet();
            this.htT.setStartDelay(IMConnection.RETRY_DELAY_TIMES);
            this.htT.play(cgE).with(cgD);
            ObjectAnimator cgC = cgC();
            ObjectAnimator cgB = cgB();
            this.htS = new AnimatorSet();
            this.htS.setStartDelay(958L);
            this.htS.play(cgB).with(cgC);
            this.htR = cgA();
            AnimatorSet cgz = cgz();
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.play(cgz).after(this.htR);
            this.htQ = cgy();
            AnimatorSet a2 = a(animatorSet);
            this.htP = new AnimatorSet();
            this.htP.play(a2).after(this.htQ);
            this.htP.start();
        }
    }

    private AnimatorSet a(final AnimatorSet animatorSet) {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.htB, "scaleX", 1.15f, 0.0f).setDuration(210L);
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.htB, "scaleY", 1.15f, 0.0f).setDuration(210L);
        AnimatorSet animatorSet2 = new AnimatorSet();
        animatorSet2.play(duration).with(duration2);
        animatorSet2.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.liveroom.o.b.7
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                b.this.htB.setVisibility(8);
                b.this.htB.setScaleX(1.0f);
                b.this.htB.setScaleY(1.0f);
                b.this.b(animatorSet);
            }
        });
        return animatorSet2;
    }

    private AnimatorSet cgy() {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.htB, "scaleX", 1.0f, 1.15f).setDuration(42L);
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.htB, "scaleY", 1.0f, 1.15f).setDuration(42L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(duration).with(duration2);
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.liveroom.o.b.8
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                b.this.htB.setScaleX(1.15f);
                b.this.htB.setScaleY(1.15f);
            }
        });
        return animatorSet;
    }

    private AnimatorSet cgz() {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.htG, "scaleX", 1.15f, 1.0f).setDuration(42L);
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.htG, "scaleY", 1.15f, 1.0f).setDuration(42L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(duration).with(duration2);
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.liveroom.o.b.9
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                b.this.b(b.this.htS);
            }
        });
        return animatorSet;
    }

    private AnimatorSet cgA() {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.htG, "scaleX", 0.0f, 1.15f).setDuration(210L);
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.htG, "scaleY", 0.0f, 1.15f).setDuration(210L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(duration).with(duration2);
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.liveroom.o.b.10
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                b.this.htG.setVisibility(0);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                b.this.htG.setScaleX(1.15f);
                b.this.htG.setScaleY(1.15f);
            }
        });
        return animatorSet;
    }

    private ObjectAnimator cgB() {
        this.htY = this.htH.getTranslationX();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.htH, "translationX", this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds180) + this.htY, this.htY);
        ofFloat.setDuration(375L);
        ofFloat.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.liveroom.o.b.11
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                b.this.htH.getLayoutParams().width = b.this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds180);
                b.this.htE.setVisibility(4);
                b.this.htH.setVisibility(0);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                b.this.b(b.this.htT);
            }
        });
        return ofFloat;
    }

    private ObjectAnimator cgC() {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.htJ, "alpha", 0.0f, 1.0f).setDuration(210L);
        duration.setStartDelay(165L);
        duration.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.liveroom.o.b.12
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                b.this.htJ.setVisibility(0);
            }
        });
        return duration;
    }

    private ValueAnimator cgD() {
        ValueAnimator ofInt = ValueAnimator.ofInt(this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds180), this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds88));
        ofInt.setInterpolator(new FastOutLinearInInterpolator());
        ofInt.setDuration(542L);
        ofInt.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.liveroom.o.b.13
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                b.this.b(b.this.htU);
            }
        });
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.ala.liveroom.o.b.14
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                b.this.htH.getLayoutParams().width = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                b.this.htH.requestLayout();
            }
        });
        return ofInt;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(AnimatorSet animatorSet) {
        if (this.htM && animatorSet != null) {
            animatorSet.start();
        }
    }

    private ObjectAnimator cgE() {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.htJ, "alpha", 1.0f, 0.0f).setDuration(210L);
        duration.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.liveroom.o.b.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                b.this.htJ.setVisibility(4);
                b.this.htJ.setAlpha(1.0f);
            }
        });
        return duration;
    }

    private AnimatorSet c(AnimatorSet animatorSet) {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.htE, "alpha", 0.0f, 1.0f).setDuration(292L);
        AnimatorSet animatorSet2 = new AnimatorSet();
        animatorSet2.setStartDelay(250L);
        animatorSet2.play(animatorSet).with(duration);
        return animatorSet2;
    }

    private AnimatorSet cgF() {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.htE, "scaleX", 1.15f, 1.0f).setDuration(84L);
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.htE, "scaleY", 1.15f, 1.0f).setDuration(84L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(duration).with(duration2);
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.liveroom.o.b.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                b.this.htM = false;
                if (b.this.hfo != null) {
                    b.this.hfo.endAnimation();
                }
            }
        });
        return animatorSet;
    }

    private AnimatorSet cgG() {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.htE, "scaleX", 0.0f, 1.15f).setDuration(292L);
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.htE, "scaleY", 0.0f, 1.15f).setDuration(292L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(duration).with(duration2);
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.liveroom.o.b.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                b.this.htE.setScaleX(1.15f);
                b.this.htE.setScaleY(1.15f);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                b.this.htE.setVisibility(0);
            }
        });
        return animatorSet;
    }

    public void cgp() {
        if (this.htM) {
            this.htM = false;
            cancelAnimation();
        }
        this.htB.setScaleY(1.0f);
        this.htB.setScaleX(1.0f);
        this.htB.setVisibility(0);
        this.htI.setVisibility(0);
        this.htG.setVisibility(4);
        this.htE.setVisibility(4);
        this.htJ.setVisibility(4);
        this.htH.setVisibility(8);
    }

    public View getView() {
        return this.mView;
    }

    public void fC(long j) {
        if (j > this.htO) {
            this.htO = j;
            this.gqH.setText(String.format(this.mContext.getString(a.h.sdk_live_charm), StringHelper.formatForCharmValue(j)));
        }
    }

    public void a(w wVar, final boolean z, final String str) {
        boolean z2 = this.htK == null || this.htK.mLiveInfo == null || wVar == null || wVar.mLiveInfo == null || this.htK.mLiveInfo.live_id != wVar.mLiveInfo.live_id;
        this.htK = wVar;
        this.otherParams = str;
        this.isHost = z;
        if (this.htK != null && this.htK.aJV != null) {
            this.htA.stopLoad();
            this.htA.startLoad(this.htK.aJV.portrait, 12, false, false);
            String str2 = this.htK.aJV.userName;
            if (TextHelper.getTextLengthWithEmoji(str2) > 14) {
                str2 = TextHelper.subStringWithEmoji(str2, 14) + StringHelper.STRING_MORE;
            }
            this.eBQ.setText(str2);
            if (z2 || wVar.aJV.charmCount > this.htO) {
                this.htO = wVar.aJV.charmCount;
                this.gqH.setText(String.format(this.mContext.getString(a.h.sdk_live_charm), StringHelper.formatForCharmValue(this.htO)));
            }
            this.htH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.o.b.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    b.this.cgH();
                    if (!z && b.this.htK != null && b.this.htK.mLiveInfo != null) {
                        LogManager.getGuardClubLogger().doClickLiveGuardButtonLog(b.this.htK.mLiveInfo.live_id + "", b.this.htK.mLiveInfo.room_id + "", b.this.htK.mLiveInfo.feed_id, str);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cgH() {
        HC(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void HC(String str) {
        if (this.mContext != null && this.htK != null && this.htK.aJV != null && this.htK.mLiveInfo != null) {
            long j = this.htK.aJV.userId;
            long j2 = this.htK.mLiveInfo.live_id;
            long j3 = this.htK.mLiveInfo.room_id;
            String str2 = this.htK.mLiveInfo.feed_id;
            GuardClubInfoActivityConfig guardClubInfoActivityConfig = new GuardClubInfoActivityConfig(this.mContext, j, j2, this.isHost, this.otherParams, false, str);
            guardClubInfoActivityConfig.setRoomId(j3);
            guardClubInfoActivityConfig.setFeedId(str2);
            guardClubInfoActivityConfig.setIsClubMember(this.bjf);
            guardClubInfoActivityConfig.setAnchorInfo(this.htK.aJV.nickName, this.htK.aJV.portrait);
            guardClubInfoActivityConfig.setRequestCode(RequestResponseCode.REQUEST_GUARD_CLUB_INFO);
            guardClubInfoActivityConfig.setIntentAction(IntentAction.ActivityForResult);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, guardClubInfoActivityConfig));
        }
    }

    public void cgt() {
        cancelAnimation();
        if (this.htM) {
            cgw();
            this.htM = false;
        }
        setLevel(0);
    }

    public void onDestroy() {
        if (this.gNG != null) {
            MessageManager.getInstance().unRegisterListener(this.gNG);
        }
        cancelAnimation();
        if (this.handler != null) {
            this.handler.removeCallbacksAndMessages(null);
        }
        this.htN.clear();
    }

    private void cancelAnimation() {
        if (this.htP != null) {
            this.htP.removeAllListeners();
            this.htP.cancel();
        }
        if (this.htQ != null) {
            this.htQ.removeAllListeners();
            this.htQ.cancel();
        }
        if (this.htR != null) {
            this.htR.removeAllListeners();
            this.htR.cancel();
        }
        if (this.htS != null) {
            this.htS.removeAllListeners();
            this.htS.cancel();
        }
        if (this.htT != null) {
            this.htT.removeAllListeners();
            this.htT.cancel();
        }
        if (this.htU != null) {
            this.htU.removeAllListeners();
            this.htU.cancel();
        }
        if (this.htV != null) {
            this.htV.removeAllListeners();
            this.htV.cancel();
        }
        if (this.htW != null) {
            this.htW.removeAllListeners();
            this.htW.cancel();
        }
        if (this.htX != null) {
            this.htX.removeAllListeners();
            this.htX.cancel();
        }
    }

    public void a(com.baidu.tieba.ala.liveroom.operation.b bVar) {
        this.hfw = bVar;
    }

    public void nQ(boolean z) {
        this.bjf = z;
    }

    public void setLevel(int i) {
        if (this.htD != null) {
            if (i <= 0) {
                this.htD.setText("");
            } else {
                this.htD.setText(String.valueOf(i));
            }
        }
    }

    public HeadImageView cgI() {
        return this.htA;
    }
}
