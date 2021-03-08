package com.baidu.tieba.ala.liveroom.m;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.interpolator.view.animation.FastOutLinearInInterpolator;
import com.baidu.android.imsdk.internal.IMConnection;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.data.ab;
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
/* loaded from: classes10.dex */
public class b {
    private TextView eKp;
    private TextView gBG;
    private HeadImageView hGW;
    private TextView hGX;
    private ImageView hGY;
    private TextView hGZ;
    private ViewGroup hHa;
    private ImageView hHb;
    private ImageView hHc;
    private RelativeLayout hHd;
    private RelativeLayout hHe;
    private TextView hHf;
    private ab hHg;
    private AnimatorSet hHl;
    private AnimatorSet hHm;
    private AnimatorSet hHn;
    private AnimatorSet hHo;
    private AnimatorSet hHp;
    private AnimatorSet hHq;
    private AnimatorSet hHr;
    private AnimatorSet hHs;
    private AnimatorSet hHt;
    private float hHu;
    private Handler handler;
    private c hsF;
    private com.baidu.tieba.ala.liveroom.operation.b hsO;
    private boolean isHost;
    private Context mContext;
    private String otherParams;
    private View mView = null;
    private int hHh = 30000;
    public boolean hHi = false;
    private boolean bkD = false;
    private Set<Long> hHj = new HashSet();
    private long hHk = 0;
    CustomMessageListener gZu = new CustomMessageListener(2913106) { // from class: com.baidu.tieba.ala.liveroom.m.b.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof String) {
                b.this.GZ((String) customResponsedMessage.getData());
            } else {
                b.this.cgK();
            }
        }
    };

    public b(Context context) {
        this.mContext = context;
        initView();
        MessageManager.getInstance().registerListener(this.gZu);
        this.handler = new Handler();
    }

    public void setId(int i) {
        this.mView.setId(i);
    }

    private void initView() {
        this.mView = View.inflate(this.mContext, a.g.hk_liveroom_hostheader_layout, null);
        this.mView.setBackgroundResource(a.e.sdk_round_host_bg);
        this.hGX = (TextView) this.mView.findViewById(a.f.ala_liveroom_hostheader_attention);
        this.hGZ = (TextView) this.mView.findViewById(a.f.tv_guardClub_level);
        this.hGW = (HeadImageView) this.mView.findViewById(a.f.ala_liveroom_hostheader_image);
        this.eKp = (TextView) this.mView.findViewById(a.f.ala_liveroom_hostheader_guest);
        this.gBG = (TextView) this.mView.findViewById(a.f.ala_liveroom_hostheader_address);
        this.hHa = (ViewGroup) this.mView.findViewById(a.f.fl_guardClubEnter);
        this.hGY = (ImageView) this.mView.findViewById(a.f.guardClubEnter_imageView);
        this.hGW.setIsRound(true);
        this.hGW.setBorderColor(this.mContext.getResources().getColor(a.c.sdk_cp_bg_line_k_alpha10_1));
        this.hGW.setAutoChangeStyle(false);
        this.hHc = (ImageView) this.mView.findViewById(a.f.ala_follow_success_img);
        this.hHd = (RelativeLayout) this.mView.findViewById(a.f.guardClub);
        this.hHf = (TextView) this.mView.findViewById(a.f.guardClubToast);
        this.hHe = (RelativeLayout) this.mView.findViewById(a.f.follow_btn);
        RoundRectRelativeLayout roundRectRelativeLayout = (RoundRectRelativeLayout) this.mView.findViewById(a.f.roundRect);
        this.hHb = (ImageView) this.mView.findViewById(a.f.ala_icon_back);
        if (TbadkCoreApplication.getInst().isHaokan()) {
            roundRectRelativeLayout.setCornerRadius(this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds30));
            this.hHd.setBackgroundResource(a.e.ala_bg_guard_club);
        } else if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            roundRectRelativeLayout.setCornerRadius(this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds30));
            this.hHd.setBackgroundResource(a.e.ala_bg_guard_club_bd);
        } else {
            roundRectRelativeLayout.setCornerRadius(this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds30));
            this.hHd.setBackgroundResource(a.e.ala_bg_guard_club_qm);
        }
        this.hHb = (ImageView) this.mView.findViewById(a.f.ala_icon_back);
        if (UtilHelper.getRealScreenOrientation(this.mContext) == 2) {
            this.hHb.setVisibility(0);
        } else {
            this.hHb.setVisibility(8);
        }
        this.hHb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.m.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.hsO.v(b.this.hHb, 19);
            }
        });
    }

    public void o(View.OnClickListener onClickListener) {
        this.hHe.setOnClickListener(onClickListener);
    }

    public void a(c cVar) {
        this.hsF = cVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ou(boolean z) {
        if (z) {
            this.hHd.setVisibility(0);
            this.hHa.setVisibility(0);
            this.hHe.setVisibility(0);
            return;
        }
        this.hHd.setVisibility(8);
        this.hHe.setVisibility(4);
    }

    public void ov(boolean z) {
        if (TbadkCoreApplication.sAlaLiveSwitchData == null || (!TbadkCoreApplication.sAlaLiveSwitchData.isFollowBtnUnabled() && !TbadkCoreApplication.sAlaLiveSwitchData.isGuardFansUnabled())) {
            if (!z || this.bkD) {
                cgz();
            } else {
                if (this.hsF != null) {
                    this.hsF.onClick();
                }
                cgA();
            }
        } else if (TbadkCoreApplication.sAlaLiveSwitchData != null && !TbadkCoreApplication.sAlaLiveSwitchData.isFollowBtnUnabled() && TbadkCoreApplication.sAlaLiveSwitchData.isGuardFansUnabled()) {
            cgt();
        }
        if (!this.isHost && this.hHg != null && this.hHg.mLiveInfo != null && this.hHg.aJD != null) {
            long j = this.hHg.aJD.userId;
            if (!this.hHj.contains(Long.valueOf(j))) {
                this.hHj.add(Long.valueOf(j));
                LogManager.getGuardClubLogger().doDisplayLiveGuardButtonLog(this.hHg.mLiveInfo.live_id + "", this.hHg.mLiveInfo.room_id + "", this.hHg.mLiveInfo.feed_id, this.otherParams);
            }
        }
    }

    private void cgz() {
        this.hGX.setVisibility(8);
        this.hHa.setAlpha(1.0f);
        this.hHa.setScaleX(1.0f);
        this.hHa.setScaleY(1.0f);
        this.hHa.setVisibility(0);
        this.hHf.setVisibility(4);
        this.hHd.setTranslationX(this.hHu);
        this.hHd.getLayoutParams().width = this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds88);
        this.hHd.setVisibility(0);
    }

    public void cgt() {
        this.hHe.setVisibility(8);
    }

    private void cgA() {
        if (!this.hHi && this.hHa.getVisibility() != 0) {
            this.hHi = true;
            this.hHt = cgJ();
            this.hHs = cgI();
            this.hHr = new AnimatorSet();
            this.hHr.play(this.hHs).after(this.hHt);
            this.hHq = c(this.hHr);
            ValueAnimator cgG = cgG();
            ObjectAnimator cgH = cgH();
            this.hHp = new AnimatorSet();
            this.hHp.setStartDelay(IMConnection.RETRY_DELAY_TIMES);
            this.hHp.play(cgH).with(cgG);
            ObjectAnimator cgF = cgF();
            ObjectAnimator cgE = cgE();
            this.hHo = new AnimatorSet();
            this.hHo.setStartDelay(958L);
            this.hHo.play(cgE).with(cgF);
            this.hHn = cgD();
            AnimatorSet cgC = cgC();
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.play(cgC).after(this.hHn);
            this.hHm = cgB();
            AnimatorSet a2 = a(animatorSet);
            this.hHl = new AnimatorSet();
            this.hHl.play(a2).after(this.hHm);
            this.hHl.start();
        }
    }

    private AnimatorSet a(final AnimatorSet animatorSet) {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.hGX, "scaleX", 1.15f, 0.0f).setDuration(210L);
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.hGX, "scaleY", 1.15f, 0.0f).setDuration(210L);
        AnimatorSet animatorSet2 = new AnimatorSet();
        animatorSet2.play(duration).with(duration2);
        animatorSet2.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.liveroom.m.b.7
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                b.this.hGX.setVisibility(8);
                b.this.hGX.setScaleX(1.0f);
                b.this.hGX.setScaleY(1.0f);
                b.this.b(animatorSet);
            }
        });
        return animatorSet2;
    }

    private AnimatorSet cgB() {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.hGX, "scaleX", 1.0f, 1.15f).setDuration(42L);
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.hGX, "scaleY", 1.0f, 1.15f).setDuration(42L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(duration).with(duration2);
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.liveroom.m.b.8
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                b.this.hGX.setScaleX(1.15f);
                b.this.hGX.setScaleY(1.15f);
            }
        });
        return animatorSet;
    }

    private AnimatorSet cgC() {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.hHc, "scaleX", 1.15f, 1.0f).setDuration(42L);
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.hHc, "scaleY", 1.15f, 1.0f).setDuration(42L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(duration).with(duration2);
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.liveroom.m.b.9
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                b.this.b(b.this.hHo);
            }
        });
        return animatorSet;
    }

    private AnimatorSet cgD() {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.hHc, "scaleX", 0.0f, 1.15f).setDuration(210L);
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.hHc, "scaleY", 0.0f, 1.15f).setDuration(210L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(duration).with(duration2);
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.liveroom.m.b.10
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                b.this.hHc.setVisibility(0);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                b.this.hHc.setScaleX(1.15f);
                b.this.hHc.setScaleY(1.15f);
            }
        });
        return animatorSet;
    }

    private ObjectAnimator cgE() {
        this.hHu = this.hHd.getTranslationX();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.hHd, "translationX", this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds180) + this.hHu, this.hHu);
        ofFloat.setDuration(375L);
        ofFloat.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.liveroom.m.b.11
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                b.this.hHd.getLayoutParams().width = b.this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds180);
                b.this.hHa.setVisibility(4);
                b.this.hHd.setVisibility(0);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                b.this.b(b.this.hHp);
            }
        });
        return ofFloat;
    }

    private ObjectAnimator cgF() {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.hHf, "alpha", 0.0f, 1.0f).setDuration(210L);
        duration.setStartDelay(165L);
        duration.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.liveroom.m.b.12
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                b.this.hHf.setVisibility(0);
            }
        });
        return duration;
    }

    private ValueAnimator cgG() {
        ValueAnimator ofInt = ValueAnimator.ofInt(this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds180), this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds88));
        ofInt.setInterpolator(new FastOutLinearInInterpolator());
        ofInt.setDuration(542L);
        ofInt.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.liveroom.m.b.13
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                b.this.b(b.this.hHq);
            }
        });
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.ala.liveroom.m.b.14
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                b.this.hHd.getLayoutParams().width = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                b.this.hHd.requestLayout();
            }
        });
        return ofInt;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(AnimatorSet animatorSet) {
        if (this.hHi && animatorSet != null) {
            animatorSet.start();
        }
    }

    private ObjectAnimator cgH() {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.hHf, "alpha", 1.0f, 0.0f).setDuration(210L);
        duration.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.liveroom.m.b.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                b.this.hHf.setVisibility(4);
                b.this.hHf.setAlpha(1.0f);
            }
        });
        return duration;
    }

    private AnimatorSet c(AnimatorSet animatorSet) {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.hHa, "alpha", 0.0f, 1.0f).setDuration(292L);
        AnimatorSet animatorSet2 = new AnimatorSet();
        animatorSet2.setStartDelay(250L);
        animatorSet2.play(animatorSet).with(duration);
        return animatorSet2;
    }

    private AnimatorSet cgI() {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.hHa, "scaleX", 1.15f, 1.0f).setDuration(84L);
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.hHa, "scaleY", 1.15f, 1.0f).setDuration(84L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(duration).with(duration2);
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.liveroom.m.b.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                b.this.hHi = false;
                if (b.this.hsF != null) {
                    b.this.hsF.endAnimation();
                }
            }
        });
        return animatorSet;
    }

    private AnimatorSet cgJ() {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.hHa, "scaleX", 0.0f, 1.15f).setDuration(292L);
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.hHa, "scaleY", 0.0f, 1.15f).setDuration(292L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(duration).with(duration2);
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.liveroom.m.b.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                b.this.hHa.setScaleX(1.15f);
                b.this.hHa.setScaleY(1.15f);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                b.this.hHa.setVisibility(0);
            }
        });
        return animatorSet;
    }

    public void cgs() {
        if (this.hHi) {
            this.hHi = false;
            cancelAnimation();
        }
        this.hGX.setScaleY(1.0f);
        this.hGX.setScaleX(1.0f);
        this.hGX.setVisibility(0);
        this.hHe.setVisibility(0);
        this.hHc.setVisibility(4);
        this.hHa.setVisibility(4);
        this.hHf.setVisibility(4);
        this.hHd.setVisibility(8);
    }

    public View getView() {
        return this.mView;
    }

    public void fH(long j) {
        if (j > this.hHk) {
            this.hHk = j;
            this.gBG.setText(String.format(this.mContext.getString(a.h.sdk_live_charm), StringHelper.formatForCharmValue(j)));
        }
    }

    public void a(ab abVar, final boolean z, final String str) {
        boolean z2 = this.hHg == null || this.hHg.mLiveInfo == null || abVar == null || abVar.mLiveInfo == null || this.hHg.mLiveInfo.live_id != abVar.mLiveInfo.live_id;
        this.hHg = abVar;
        this.otherParams = str;
        this.isHost = z;
        if (this.hHg != null && this.hHg.aJD != null) {
            this.hGW.stopLoad();
            this.hGW.startLoad(this.hHg.aJD.portrait, 12, false, false);
            String str2 = this.hHg.aJD.userName;
            if (TextHelper.getTextLengthWithEmoji(str2) > 14) {
                str2 = TextHelper.subStringWithEmoji(str2, 14) + StringHelper.STRING_MORE;
            }
            this.eKp.setText(str2);
            if (z2 || abVar.aJD.charmCount > this.hHk) {
                this.hHk = abVar.aJD.charmCount;
                this.gBG.setText(String.format(this.mContext.getString(a.h.sdk_live_charm), StringHelper.formatForCharmValue(this.hHk)));
            }
            this.hHd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.m.b.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    b.this.cgK();
                    if (!z && b.this.hHg != null && b.this.hHg.mLiveInfo != null) {
                        LogManager.getGuardClubLogger().doClickLiveGuardButtonLog(b.this.hHg.mLiveInfo.live_id + "", b.this.hHg.mLiveInfo.room_id + "", b.this.hHg.mLiveInfo.feed_id, str);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cgK() {
        GZ(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GZ(String str) {
        if (this.mContext != null && this.hHg != null && this.hHg.aJD != null && this.hHg.mLiveInfo != null) {
            long j = this.hHg.aJD.userId;
            long j2 = this.hHg.mLiveInfo.live_id;
            long j3 = this.hHg.mLiveInfo.room_id;
            String str2 = this.hHg.mLiveInfo.feed_id;
            GuardClubInfoActivityConfig guardClubInfoActivityConfig = new GuardClubInfoActivityConfig(this.mContext, j, j2, this.isHost, this.otherParams, false, str);
            guardClubInfoActivityConfig.setRoomId(j3);
            guardClubInfoActivityConfig.setFeedId(str2);
            guardClubInfoActivityConfig.setIsClubMember(this.bkD);
            guardClubInfoActivityConfig.setAnchorInfo(this.hHg.aJD.nickName, this.hHg.aJD.portrait);
            guardClubInfoActivityConfig.setRequestCode(RequestResponseCode.REQUEST_GUARD_CLUB_INFO);
            guardClubInfoActivityConfig.setIntentAction(IntentAction.ActivityForResult);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, guardClubInfoActivityConfig));
        }
    }

    public void cgw() {
        cancelAnimation();
        if (this.hHi) {
            cgz();
            this.hHi = false;
        }
        setLevel(0);
    }

    public void onDestroy() {
        if (this.gZu != null) {
            MessageManager.getInstance().unRegisterListener(this.gZu);
        }
        cancelAnimation();
        if (this.handler != null) {
            this.handler.removeCallbacksAndMessages(null);
        }
        this.hHj.clear();
    }

    private void cancelAnimation() {
        if (this.hHl != null) {
            this.hHl.removeAllListeners();
            this.hHl.cancel();
        }
        if (this.hHm != null) {
            this.hHm.removeAllListeners();
            this.hHm.cancel();
        }
        if (this.hHn != null) {
            this.hHn.removeAllListeners();
            this.hHn.cancel();
        }
        if (this.hHo != null) {
            this.hHo.removeAllListeners();
            this.hHo.cancel();
        }
        if (this.hHp != null) {
            this.hHp.removeAllListeners();
            this.hHp.cancel();
        }
        if (this.hHq != null) {
            this.hHq.removeAllListeners();
            this.hHq.cancel();
        }
        if (this.hHr != null) {
            this.hHr.removeAllListeners();
            this.hHr.cancel();
        }
        if (this.hHs != null) {
            this.hHs.removeAllListeners();
            this.hHs.cancel();
        }
        if (this.hHt != null) {
            this.hHt.removeAllListeners();
            this.hHt.cancel();
        }
    }

    public void a(com.baidu.tieba.ala.liveroom.operation.b bVar) {
        this.hsO = bVar;
    }

    public void ow(boolean z) {
        this.bkD = z;
    }

    public void setLevel(int i) {
        if (this.hGZ != null) {
            if (i <= 0) {
                this.hGZ.setText("");
            } else {
                this.hGZ.setText(String.valueOf(i));
            }
        }
    }

    public HeadImageView cgL() {
        return this.hGW;
    }
}
