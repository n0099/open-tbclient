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
    private TextView gqF;
    private Handler handler;
    private c hfm;
    private com.baidu.tieba.ala.liveroom.operation.b hfu;
    private ImageView htA;
    private TextView htB;
    private ViewGroup htC;
    private ImageView htD;
    private ImageView htE;
    private RelativeLayout htF;
    private RelativeLayout htG;
    private TextView htH;
    private w htI;
    private AnimatorSet htN;
    private AnimatorSet htO;
    private AnimatorSet htP;
    private AnimatorSet htQ;
    private AnimatorSet htR;
    private AnimatorSet htS;
    private AnimatorSet htT;
    private AnimatorSet htU;
    private AnimatorSet htV;
    private float htW;
    private HeadImageView hty;
    private TextView htz;
    private boolean isHost;
    private Context mContext;
    private String otherParams;
    private View mView = null;
    private int htJ = 30000;
    public boolean htK = false;
    private boolean bjf = false;
    private Set<Long> htL = new HashSet();
    private long htM = 0;
    CustomMessageListener gNE = new CustomMessageListener(2913106) { // from class: com.baidu.tieba.ala.liveroom.o.b.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof String) {
                b.this.HC((String) customResponsedMessage.getData());
            } else {
                b.this.cgG();
            }
        }
    };

    public b(Context context) {
        this.mContext = context;
        initView();
        MessageManager.getInstance().registerListener(this.gNE);
        this.handler = new Handler();
    }

    public void setId(int i) {
        this.mView.setId(i);
    }

    private void initView() {
        this.mView = View.inflate(this.mContext, a.g.hk_liveroom_hostheader_layout, null);
        this.mView.setBackgroundResource(a.e.sdk_round_host_bg);
        this.htz = (TextView) this.mView.findViewById(a.f.ala_liveroom_hostheader_attention);
        this.htB = (TextView) this.mView.findViewById(a.f.tv_guardClub_level);
        this.hty = (HeadImageView) this.mView.findViewById(a.f.ala_liveroom_hostheader_image);
        this.eBQ = (TextView) this.mView.findViewById(a.f.ala_liveroom_hostheader_guest);
        this.gqF = (TextView) this.mView.findViewById(a.f.ala_liveroom_hostheader_address);
        this.htC = (ViewGroup) this.mView.findViewById(a.f.fl_guardClubEnter);
        this.htA = (ImageView) this.mView.findViewById(a.f.guardClubEnter_imageView);
        this.hty.setIsRound(true);
        this.hty.setBorderColor(this.mContext.getResources().getColor(a.c.sdk_cp_bg_line_k_alpha10_1));
        this.hty.setAutoChangeStyle(false);
        this.htE = (ImageView) this.mView.findViewById(a.f.ala_follow_success_img);
        this.htF = (RelativeLayout) this.mView.findViewById(a.f.guardClub);
        this.htH = (TextView) this.mView.findViewById(a.f.guardClubToast);
        this.htG = (RelativeLayout) this.mView.findViewById(a.f.follow_btn);
        RoundRectRelativeLayout roundRectRelativeLayout = (RoundRectRelativeLayout) this.mView.findViewById(a.f.roundRect);
        this.htD = (ImageView) this.mView.findViewById(a.f.ala_icon_back);
        if (TbadkCoreApplication.getInst().isHaokan()) {
            roundRectRelativeLayout.setCornerRadius(this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds30));
            this.htG.setBackgroundResource(a.e.ala_live_follow_btn_radius_16_selector_hk);
            this.htF.setBackgroundResource(a.e.ala_bg_guard_club);
        } else if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            roundRectRelativeLayout.setCornerRadius(this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds30));
            this.htG.setBackgroundResource(a.e.ala_live_room_follow_btn_radius_16_selector_bd);
            this.htF.setBackgroundResource(a.e.ala_bg_guard_club_bd);
        } else {
            roundRectRelativeLayout.setCornerRadius(this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds30));
            this.htG.setBackgroundResource(a.e.ala_live_follow_btn_radius_16_selector_qm);
            this.htF.setBackgroundResource(a.e.ala_bg_guard_club_qm);
        }
        this.htD = (ImageView) this.mView.findViewById(a.f.ala_icon_back);
        if (UtilHelper.getRealScreenOrientation(this.mContext) == 2) {
            this.htD.setVisibility(0);
        } else {
            this.htD.setVisibility(8);
        }
        this.htD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.o.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.hfu.s(b.this.htD, 19);
            }
        });
    }

    public void n(View.OnClickListener onClickListener) {
        this.htG.setOnClickListener(onClickListener);
    }

    public void a(c cVar) {
        this.hfm = cVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void nO(boolean z) {
        if (z) {
            this.htF.setVisibility(0);
            this.htC.setVisibility(0);
            this.htG.setVisibility(0);
            return;
        }
        this.htF.setVisibility(8);
        this.htG.setVisibility(4);
    }

    public void nP(boolean z) {
        if (TbadkCoreApplication.sAlaLiveSwitchData == null || (!TbadkCoreApplication.sAlaLiveSwitchData.isFollowBtnUnabled() && !TbadkCoreApplication.sAlaLiveSwitchData.isGuardFansUnabled())) {
            if (!z || this.bjf) {
                cgv();
            } else {
                if (this.hfm != null) {
                    this.hfm.onClick();
                }
                cgw();
            }
        } else if (TbadkCoreApplication.sAlaLiveSwitchData != null && !TbadkCoreApplication.sAlaLiveSwitchData.isFollowBtnUnabled() && TbadkCoreApplication.sAlaLiveSwitchData.isGuardFansUnabled()) {
            cgp();
        }
        if (!this.isHost && this.htI != null && this.htI.mLiveInfo != null && this.htI.aJV != null) {
            long j = this.htI.aJV.userId;
            if (!this.htL.contains(Long.valueOf(j))) {
                this.htL.add(Long.valueOf(j));
                LogManager.getGuardClubLogger().doDisplayLiveGuardButtonLog(this.htI.mLiveInfo.live_id + "", this.htI.mLiveInfo.room_id + "", this.htI.mLiveInfo.feed_id, this.otherParams);
            }
        }
    }

    private void cgv() {
        this.htz.setVisibility(8);
        this.htC.setAlpha(1.0f);
        this.htC.setScaleX(1.0f);
        this.htC.setScaleY(1.0f);
        this.htC.setVisibility(0);
        this.htH.setVisibility(4);
        this.htF.setTranslationX(this.htW);
        this.htF.getLayoutParams().width = this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds88);
        this.htF.setVisibility(0);
    }

    public void cgp() {
        this.htG.setVisibility(4);
    }

    private void cgw() {
        if (!this.htK && this.htC.getVisibility() != 0) {
            this.htK = true;
            this.htV = cgF();
            this.htU = cgE();
            this.htT = new AnimatorSet();
            this.htT.play(this.htU).after(this.htV);
            this.htS = c(this.htT);
            ValueAnimator cgC = cgC();
            ObjectAnimator cgD = cgD();
            this.htR = new AnimatorSet();
            this.htR.setStartDelay(IMConnection.RETRY_DELAY_TIMES);
            this.htR.play(cgD).with(cgC);
            ObjectAnimator cgB = cgB();
            ObjectAnimator cgA = cgA();
            this.htQ = new AnimatorSet();
            this.htQ.setStartDelay(958L);
            this.htQ.play(cgA).with(cgB);
            this.htP = cgz();
            AnimatorSet cgy = cgy();
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.play(cgy).after(this.htP);
            this.htO = cgx();
            AnimatorSet a2 = a(animatorSet);
            this.htN = new AnimatorSet();
            this.htN.play(a2).after(this.htO);
            this.htN.start();
        }
    }

    private AnimatorSet a(final AnimatorSet animatorSet) {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.htz, "scaleX", 1.15f, 0.0f).setDuration(210L);
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.htz, "scaleY", 1.15f, 0.0f).setDuration(210L);
        AnimatorSet animatorSet2 = new AnimatorSet();
        animatorSet2.play(duration).with(duration2);
        animatorSet2.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.liveroom.o.b.7
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                b.this.htz.setVisibility(8);
                b.this.htz.setScaleX(1.0f);
                b.this.htz.setScaleY(1.0f);
                b.this.b(animatorSet);
            }
        });
        return animatorSet2;
    }

    private AnimatorSet cgx() {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.htz, "scaleX", 1.0f, 1.15f).setDuration(42L);
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.htz, "scaleY", 1.0f, 1.15f).setDuration(42L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(duration).with(duration2);
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.liveroom.o.b.8
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                b.this.htz.setScaleX(1.15f);
                b.this.htz.setScaleY(1.15f);
            }
        });
        return animatorSet;
    }

    private AnimatorSet cgy() {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.htE, "scaleX", 1.15f, 1.0f).setDuration(42L);
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.htE, "scaleY", 1.15f, 1.0f).setDuration(42L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(duration).with(duration2);
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.liveroom.o.b.9
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                b.this.b(b.this.htQ);
            }
        });
        return animatorSet;
    }

    private AnimatorSet cgz() {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.htE, "scaleX", 0.0f, 1.15f).setDuration(210L);
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.htE, "scaleY", 0.0f, 1.15f).setDuration(210L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(duration).with(duration2);
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.liveroom.o.b.10
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                b.this.htE.setVisibility(0);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                b.this.htE.setScaleX(1.15f);
                b.this.htE.setScaleY(1.15f);
            }
        });
        return animatorSet;
    }

    private ObjectAnimator cgA() {
        this.htW = this.htF.getTranslationX();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.htF, "translationX", this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds180) + this.htW, this.htW);
        ofFloat.setDuration(375L);
        ofFloat.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.liveroom.o.b.11
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                b.this.htF.getLayoutParams().width = b.this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds180);
                b.this.htC.setVisibility(4);
                b.this.htF.setVisibility(0);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                b.this.b(b.this.htR);
            }
        });
        return ofFloat;
    }

    private ObjectAnimator cgB() {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.htH, "alpha", 0.0f, 1.0f).setDuration(210L);
        duration.setStartDelay(165L);
        duration.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.liveroom.o.b.12
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                b.this.htH.setVisibility(0);
            }
        });
        return duration;
    }

    private ValueAnimator cgC() {
        ValueAnimator ofInt = ValueAnimator.ofInt(this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds180), this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds88));
        ofInt.setInterpolator(new FastOutLinearInInterpolator());
        ofInt.setDuration(542L);
        ofInt.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.liveroom.o.b.13
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                b.this.b(b.this.htS);
            }
        });
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.ala.liveroom.o.b.14
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                b.this.htF.getLayoutParams().width = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                b.this.htF.requestLayout();
            }
        });
        return ofInt;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(AnimatorSet animatorSet) {
        if (this.htK && animatorSet != null) {
            animatorSet.start();
        }
    }

    private ObjectAnimator cgD() {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.htH, "alpha", 1.0f, 0.0f).setDuration(210L);
        duration.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.liveroom.o.b.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                b.this.htH.setVisibility(4);
                b.this.htH.setAlpha(1.0f);
            }
        });
        return duration;
    }

    private AnimatorSet c(AnimatorSet animatorSet) {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.htC, "alpha", 0.0f, 1.0f).setDuration(292L);
        AnimatorSet animatorSet2 = new AnimatorSet();
        animatorSet2.setStartDelay(250L);
        animatorSet2.play(animatorSet).with(duration);
        return animatorSet2;
    }

    private AnimatorSet cgE() {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.htC, "scaleX", 1.15f, 1.0f).setDuration(84L);
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.htC, "scaleY", 1.15f, 1.0f).setDuration(84L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(duration).with(duration2);
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.liveroom.o.b.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                b.this.htK = false;
                if (b.this.hfm != null) {
                    b.this.hfm.endAnimation();
                }
            }
        });
        return animatorSet;
    }

    private AnimatorSet cgF() {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.htC, "scaleX", 0.0f, 1.15f).setDuration(292L);
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.htC, "scaleY", 0.0f, 1.15f).setDuration(292L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(duration).with(duration2);
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.liveroom.o.b.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                b.this.htC.setScaleX(1.15f);
                b.this.htC.setScaleY(1.15f);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                b.this.htC.setVisibility(0);
            }
        });
        return animatorSet;
    }

    public void cgo() {
        if (this.htK) {
            this.htK = false;
            cancelAnimation();
        }
        this.htz.setScaleY(1.0f);
        this.htz.setScaleX(1.0f);
        this.htz.setVisibility(0);
        this.htG.setVisibility(0);
        this.htE.setVisibility(4);
        this.htC.setVisibility(4);
        this.htH.setVisibility(4);
        this.htF.setVisibility(8);
    }

    public View getView() {
        return this.mView;
    }

    public void fC(long j) {
        if (j > this.htM) {
            this.htM = j;
            this.gqF.setText(String.format(this.mContext.getString(a.h.sdk_live_charm), StringHelper.formatForCharmValue(j)));
        }
    }

    public void a(w wVar, final boolean z, final String str) {
        boolean z2 = this.htI == null || this.htI.mLiveInfo == null || wVar == null || wVar.mLiveInfo == null || this.htI.mLiveInfo.live_id != wVar.mLiveInfo.live_id;
        this.htI = wVar;
        this.otherParams = str;
        this.isHost = z;
        if (this.htI != null && this.htI.aJV != null) {
            this.hty.stopLoad();
            this.hty.startLoad(this.htI.aJV.portrait, 12, false, false);
            String str2 = this.htI.aJV.userName;
            if (TextHelper.getTextLengthWithEmoji(str2) > 14) {
                str2 = TextHelper.subStringWithEmoji(str2, 14) + StringHelper.STRING_MORE;
            }
            this.eBQ.setText(str2);
            if (z2 || wVar.aJV.charmCount > this.htM) {
                this.htM = wVar.aJV.charmCount;
                this.gqF.setText(String.format(this.mContext.getString(a.h.sdk_live_charm), StringHelper.formatForCharmValue(this.htM)));
            }
            this.htF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.o.b.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    b.this.cgG();
                    if (!z && b.this.htI != null && b.this.htI.mLiveInfo != null) {
                        LogManager.getGuardClubLogger().doClickLiveGuardButtonLog(b.this.htI.mLiveInfo.live_id + "", b.this.htI.mLiveInfo.room_id + "", b.this.htI.mLiveInfo.feed_id, str);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cgG() {
        HC(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void HC(String str) {
        if (this.mContext != null && this.htI != null && this.htI.aJV != null && this.htI.mLiveInfo != null) {
            long j = this.htI.aJV.userId;
            long j2 = this.htI.mLiveInfo.live_id;
            long j3 = this.htI.mLiveInfo.room_id;
            String str2 = this.htI.mLiveInfo.feed_id;
            GuardClubInfoActivityConfig guardClubInfoActivityConfig = new GuardClubInfoActivityConfig(this.mContext, j, j2, this.isHost, this.otherParams, false, str);
            guardClubInfoActivityConfig.setRoomId(j3);
            guardClubInfoActivityConfig.setFeedId(str2);
            guardClubInfoActivityConfig.setIsClubMember(this.bjf);
            guardClubInfoActivityConfig.setAnchorInfo(this.htI.aJV.nickName, this.htI.aJV.portrait);
            guardClubInfoActivityConfig.setRequestCode(RequestResponseCode.REQUEST_GUARD_CLUB_INFO);
            guardClubInfoActivityConfig.setIntentAction(IntentAction.ActivityForResult);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, guardClubInfoActivityConfig));
        }
    }

    public void cgs() {
        cancelAnimation();
        if (this.htK) {
            cgv();
            this.htK = false;
        }
        setLevel(0);
    }

    public void onDestroy() {
        if (this.gNE != null) {
            MessageManager.getInstance().unRegisterListener(this.gNE);
        }
        cancelAnimation();
        if (this.handler != null) {
            this.handler.removeCallbacksAndMessages(null);
        }
        this.htL.clear();
    }

    private void cancelAnimation() {
        if (this.htN != null) {
            this.htN.removeAllListeners();
            this.htN.cancel();
        }
        if (this.htO != null) {
            this.htO.removeAllListeners();
            this.htO.cancel();
        }
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
    }

    public void a(com.baidu.tieba.ala.liveroom.operation.b bVar) {
        this.hfu = bVar;
    }

    public void nQ(boolean z) {
        this.bjf = z;
    }

    public void setLevel(int i) {
        if (this.htB != null) {
            if (i <= 0) {
                this.htB.setText("");
            } else {
                this.htB.setText(String.valueOf(i));
            }
        }
    }

    public HeadImageView cgH() {
        return this.hty;
    }
}
