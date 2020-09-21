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
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.log.LogManager;
import com.baidu.live.tbadk.util.TextHelper;
import com.baidu.live.view.RoundRectRelativeLayout;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes4.dex */
public class b {
    private TextView dWe;
    private TextView fGN;
    private AnimatorSet gEC;
    private AnimatorSet gED;
    private AnimatorSet gEE;
    private AnimatorSet gEF;
    private AnimatorSet gEG;
    private AnimatorSet gEH;
    private AnimatorSet gEI;
    private AnimatorSet gEJ;
    private AnimatorSet gEK;
    private float gEL;
    private HeadImageView gEo;
    private TextView gEp;
    private ImageView gEq;
    private TextView gEr;
    private ViewGroup gEs;
    private ImageView gEt;
    private RelativeLayout gEu;
    private RelativeLayout gEv;
    private TextView gEw;
    private u gEx;
    private c gpX;
    private com.baidu.tieba.ala.liveroom.operation.b gqe;
    private Handler handler;
    private boolean isHost;
    private Context mContext;
    private String otherParams;
    private View mView = null;
    private int gEy = 30000;
    public boolean gEz = false;
    private boolean baw = false;
    private Set<Long> gEA = new HashSet();
    private long gEB = 0;
    CustomMessageListener gcQ = new CustomMessageListener(2913106) { // from class: com.baidu.tieba.ala.liveroom.p.b.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof String) {
                b.this.FR((String) customResponsedMessage.getData());
            } else {
                b.this.bUB();
            }
        }
    };

    public b(Context context) {
        this.mContext = context;
        initView();
        MessageManager.getInstance().registerListener(this.gcQ);
        this.handler = new Handler();
    }

    public void setId(int i) {
        this.mView.setId(i);
    }

    private void initView() {
        this.mView = View.inflate(this.mContext, a.h.hk_liveroom_hostheader_layout, null);
        if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.mView.setBackgroundResource(a.f.sdk_round_host_header_bg_bd);
        } else {
            this.mView.setBackgroundResource(a.f.sdk_round_host_bg);
        }
        this.gEp = (TextView) this.mView.findViewById(a.g.ala_liveroom_hostheader_attention);
        this.gEr = (TextView) this.mView.findViewById(a.g.tv_guardClub_level);
        this.gEo = (HeadImageView) this.mView.findViewById(a.g.ala_liveroom_hostheader_image);
        this.dWe = (TextView) this.mView.findViewById(a.g.ala_liveroom_hostheader_guest);
        this.fGN = (TextView) this.mView.findViewById(a.g.ala_liveroom_hostheader_address);
        this.gEs = (ViewGroup) this.mView.findViewById(a.g.fl_guardClubEnter);
        this.gEq = (ImageView) this.mView.findViewById(a.g.guardClubEnter_imageView);
        this.gEo.setIsRound(true);
        this.gEo.setBorderColor(this.mContext.getResources().getColor(a.d.sdk_cp_bg_line_k_alpha10_1));
        this.gEo.setAutoChangeStyle(false);
        this.gEt = (ImageView) this.mView.findViewById(a.g.ala_follow_success_img);
        this.gEu = (RelativeLayout) this.mView.findViewById(a.g.guardClub);
        this.gEw = (TextView) this.mView.findViewById(a.g.guardClubToast);
        this.gEv = (RelativeLayout) this.mView.findViewById(a.g.follow_btn);
        RoundRectRelativeLayout roundRectRelativeLayout = (RoundRectRelativeLayout) this.mView.findViewById(a.g.roundRect);
        if (TbadkCoreApplication.getInst().isHaokan()) {
            roundRectRelativeLayout.setCornerRadius(this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds30));
            this.gEv.setBackgroundResource(a.f.ala_live_follow_btn_radius_20_selector_hk);
            this.gEv.setBackgroundResource(a.f.sdk_round_btn_hk_bg_radius_12_n);
            this.gEu.setBackgroundResource(a.f.ala_bg_guard_club);
        } else if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            roundRectRelativeLayout.setCornerRadius(this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds16));
            this.gEv.setBackgroundResource(a.f.ala_live_room_follow_btn_radius_20_selector_bd);
            this.gEu.setBackgroundResource(a.f.ala_bg_guard_club_bd);
        } else {
            roundRectRelativeLayout.setCornerRadius(this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds28));
            this.gEv.setBackgroundResource(a.f.ala_live_follow_btn_radius_20_selector_qm);
            this.gEv.setBackgroundResource(a.f.sdk_round_btn_qm_bg_radius_12_n);
            this.gEu.setBackgroundResource(a.f.ala_bg_guard_club_qm);
        }
    }

    public void m(View.OnClickListener onClickListener) {
        this.gEv.setOnClickListener(onClickListener);
    }

    public void a(c cVar) {
        this.gpX = cVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void mr(boolean z) {
        if (z) {
            this.gEu.setVisibility(0);
            this.gEv.setVisibility(0);
            return;
        }
        this.gEu.setVisibility(8);
        this.gEv.setVisibility(8);
    }

    public void ms(boolean z) {
        if (TbadkCoreApplication.sAlaLiveSwitchData == null || (!TbadkCoreApplication.sAlaLiveSwitchData.isFollowBtnUnabled() && !TbadkCoreApplication.sAlaLiveSwitchData.isGuardFansUnabled())) {
            if (!z || this.baw) {
                bUq();
            } else {
                if (this.gpX != null) {
                    this.gpX.onClick();
                }
                bUr();
            }
        } else if (TbadkCoreApplication.sAlaLiveSwitchData != null && !TbadkCoreApplication.sAlaLiveSwitchData.isFollowBtnUnabled() && TbadkCoreApplication.sAlaLiveSwitchData.isGuardFansUnabled()) {
            bUl();
        }
        if (!this.isHost && this.gEx != null && this.gEx.mLiveInfo != null && this.gEx.aEz != null) {
            long j = this.gEx.aEz.userId;
            if (!this.gEA.contains(Long.valueOf(j))) {
                this.gEA.add(Long.valueOf(j));
                LogManager.getGuardClubLogger().doDisplayLiveGuardButtonLog(this.gEx.mLiveInfo.live_id + "", this.gEx.mLiveInfo.room_id + "", this.gEx.mLiveInfo.feed_id, this.otherParams);
            }
        }
    }

    private void bUq() {
        this.gEp.setVisibility(8);
        this.gEs.setAlpha(1.0f);
        this.gEs.setScaleX(1.0f);
        this.gEs.setScaleY(1.0f);
        this.gEs.setVisibility(0);
        this.gEw.setVisibility(4);
        this.gEu.setTranslationX(this.gEL);
        this.gEu.getLayoutParams().width = this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds80);
        this.gEu.setVisibility(0);
    }

    public void bUl() {
        this.gEv.setVisibility(8);
    }

    private void bUr() {
        if (!this.gEz && this.gEs.getVisibility() != 0) {
            this.gEz = true;
            this.gEK = bUA();
            this.gEJ = bUz();
            this.gEI = new AnimatorSet();
            this.gEI.play(this.gEJ).after(this.gEK);
            this.gEH = c(this.gEI);
            ValueAnimator bUx = bUx();
            ObjectAnimator bUy = bUy();
            this.gEG = new AnimatorSet();
            this.gEG.setStartDelay(IMConnection.RETRY_DELAY_TIMES);
            this.gEG.play(bUy).with(bUx);
            ObjectAnimator bUw = bUw();
            ObjectAnimator bUv = bUv();
            this.gEF = new AnimatorSet();
            this.gEF.setStartDelay(958L);
            this.gEF.play(bUv).with(bUw);
            this.gEE = bUu();
            AnimatorSet bUt = bUt();
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.play(bUt).after(this.gEE);
            this.gED = bUs();
            AnimatorSet a = a(animatorSet);
            this.gEC = new AnimatorSet();
            this.gEC.play(a).after(this.gED);
            this.gEC.start();
        }
    }

    private AnimatorSet a(final AnimatorSet animatorSet) {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.gEp, "scaleX", 1.15f, 0.0f).setDuration(210L);
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.gEp, "scaleY", 1.15f, 0.0f).setDuration(210L);
        AnimatorSet animatorSet2 = new AnimatorSet();
        animatorSet2.play(duration).with(duration2);
        animatorSet2.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.liveroom.p.b.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                b.this.gEp.setVisibility(8);
                b.this.gEp.setScaleX(1.0f);
                b.this.gEp.setScaleY(1.0f);
                b.this.b(animatorSet);
            }
        });
        return animatorSet2;
    }

    private AnimatorSet bUs() {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.gEp, "scaleX", 1.0f, 1.15f).setDuration(42L);
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.gEp, "scaleY", 1.0f, 1.15f).setDuration(42L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(duration).with(duration2);
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.liveroom.p.b.6
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                b.this.gEp.setScaleX(1.15f);
                b.this.gEp.setScaleY(1.15f);
            }
        });
        return animatorSet;
    }

    private AnimatorSet bUt() {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.gEt, "scaleX", 1.15f, 1.0f).setDuration(42L);
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.gEt, "scaleY", 1.15f, 1.0f).setDuration(42L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(duration).with(duration2);
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.liveroom.p.b.7
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                b.this.b(b.this.gEF);
            }
        });
        return animatorSet;
    }

    private AnimatorSet bUu() {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.gEt, "scaleX", 0.0f, 1.15f).setDuration(210L);
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.gEt, "scaleY", 0.0f, 1.15f).setDuration(210L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(duration).with(duration2);
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.liveroom.p.b.8
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                b.this.gEt.setVisibility(0);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                b.this.gEt.setScaleX(1.15f);
                b.this.gEt.setScaleY(1.15f);
            }
        });
        return animatorSet;
    }

    private ObjectAnimator bUv() {
        this.gEL = this.gEu.getTranslationX();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.gEu, "translationX", this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds180) + this.gEL, this.gEL);
        ofFloat.setDuration(375L);
        ofFloat.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.liveroom.p.b.9
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                b.this.gEu.getLayoutParams().width = b.this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds180);
                b.this.gEs.setVisibility(4);
                b.this.gEu.setVisibility(0);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                b.this.b(b.this.gEG);
            }
        });
        return ofFloat;
    }

    private ObjectAnimator bUw() {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.gEw, "alpha", 0.0f, 1.0f).setDuration(210L);
        duration.setStartDelay(165L);
        duration.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.liveroom.p.b.10
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                b.this.gEw.setVisibility(0);
            }
        });
        return duration;
    }

    private ValueAnimator bUx() {
        ValueAnimator ofInt = ValueAnimator.ofInt(this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds180), this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds80));
        ofInt.setInterpolator(new FastOutLinearInInterpolator());
        ofInt.setDuration(542L);
        ofInt.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.liveroom.p.b.11
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                b.this.b(b.this.gEH);
            }
        });
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.ala.liveroom.p.b.12
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                b.this.gEu.getLayoutParams().width = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                b.this.gEu.requestLayout();
            }
        });
        return ofInt;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(AnimatorSet animatorSet) {
        if (this.gEz && animatorSet != null) {
            animatorSet.start();
        }
    }

    private ObjectAnimator bUy() {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.gEw, "alpha", 1.0f, 0.0f).setDuration(210L);
        duration.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.liveroom.p.b.13
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                b.this.gEw.setVisibility(4);
                b.this.gEw.setAlpha(1.0f);
            }
        });
        return duration;
    }

    private AnimatorSet c(AnimatorSet animatorSet) {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.gEs, "alpha", 0.0f, 1.0f).setDuration(292L);
        AnimatorSet animatorSet2 = new AnimatorSet();
        animatorSet2.setStartDelay(250L);
        animatorSet2.play(animatorSet).with(duration);
        return animatorSet2;
    }

    private AnimatorSet bUz() {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.gEs, "scaleX", 1.15f, 1.0f).setDuration(84L);
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.gEs, "scaleY", 1.15f, 1.0f).setDuration(84L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(duration).with(duration2);
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.liveroom.p.b.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                b.this.gEz = false;
                if (b.this.gpX != null) {
                    b.this.gpX.endAnimation();
                }
            }
        });
        return animatorSet;
    }

    private AnimatorSet bUA() {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.gEs, "scaleX", 0.0f, 1.15f).setDuration(292L);
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.gEs, "scaleY", 0.0f, 1.15f).setDuration(292L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(duration).with(duration2);
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.liveroom.p.b.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                b.this.gEs.setScaleX(1.15f);
                b.this.gEs.setScaleY(1.15f);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                b.this.gEs.setVisibility(0);
            }
        });
        return animatorSet;
    }

    public void bUk() {
        if (this.gEz) {
            this.gEz = false;
            cancelAnimation();
        }
        this.gEp.setScaleY(1.0f);
        this.gEp.setScaleX(1.0f);
        this.gEp.setVisibility(0);
        this.gEv.setVisibility(0);
        this.gEt.setVisibility(4);
        this.gEs.setVisibility(4);
        this.gEw.setVisibility(4);
        this.gEu.setVisibility(8);
    }

    public View getView() {
        return this.mView;
    }

    public void ek(long j) {
        if (j > this.gEB) {
            this.gEB = j;
            this.fGN.setText(String.format(this.mContext.getString(a.i.sdk_live_charm), StringHelper.formatForCharmValue(j)));
        }
    }

    public void a(u uVar, final boolean z, final String str) {
        boolean z2 = this.gEx == null || this.gEx.mLiveInfo == null || uVar == null || uVar.mLiveInfo == null || this.gEx.mLiveInfo.live_id == uVar.mLiveInfo.live_id;
        this.gEx = uVar;
        this.otherParams = str;
        this.isHost = z;
        if (this.gEx != null && this.gEx.aEz != null) {
            this.gEo.stopLoad();
            this.gEo.startLoad(this.gEx.aEz.portrait, 12, false, false);
            String str2 = this.gEx.aEz.userName;
            if (TextHelper.getTextLengthWithEmoji(str2) > 14) {
                str2 = TextHelper.subStringWithEmoji(str2, 14) + StringHelper.STRING_MORE;
            }
            this.dWe.setText(str2);
            if (z2 || uVar.aEz.charmCount > this.gEB) {
                this.gEB = uVar.aEz.charmCount;
                this.fGN.setText(String.format(this.mContext.getString(a.i.sdk_live_charm), StringHelper.formatForCharmValue(this.gEB)));
            }
            this.gEu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.p.b.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    b.this.bUB();
                    if (!z && b.this.gEx != null && b.this.gEx.mLiveInfo != null) {
                        LogManager.getGuardClubLogger().doClickLiveGuardButtonLog(b.this.gEx.mLiveInfo.live_id + "", b.this.gEx.mLiveInfo.room_id + "", b.this.gEx.mLiveInfo.feed_id, str);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bUB() {
        FR(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FR(String str) {
        if (this.mContext != null && this.gEx != null && this.gEx.aEz != null && this.gEx.mLiveInfo != null) {
            long j = this.gEx.aEz.userId;
            long j2 = this.gEx.mLiveInfo.live_id;
            long j3 = this.gEx.mLiveInfo.room_id;
            String str2 = this.gEx.mLiveInfo.feed_id;
            GuardClubInfoActivityConfig guardClubInfoActivityConfig = new GuardClubInfoActivityConfig(this.mContext, j, j2, this.isHost, this.otherParams, false, str);
            guardClubInfoActivityConfig.setRoomId(j3);
            guardClubInfoActivityConfig.setFeedId(str2);
            guardClubInfoActivityConfig.setIsClubMember(this.baw);
            guardClubInfoActivityConfig.setRequestCode(RequestResponseCode.REQUEST_GUARD_CLUB_INFO);
            guardClubInfoActivityConfig.setIntentAction(IntentAction.ActivityForResult);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, guardClubInfoActivityConfig));
        }
    }

    public void bUo() {
        cancelAnimation();
        if (this.gEz) {
            bUq();
            this.gEz = false;
        }
        setLevel(0);
    }

    public void onDestroy() {
        if (this.gcQ != null) {
            MessageManager.getInstance().unRegisterListener(this.gcQ);
        }
        cancelAnimation();
        if (this.handler != null) {
            this.handler.removeCallbacksAndMessages(null);
        }
        this.gEA.clear();
    }

    private void cancelAnimation() {
        if (this.gEC != null) {
            this.gEC.removeAllListeners();
            this.gEC.cancel();
        }
        if (this.gED != null) {
            this.gED.removeAllListeners();
            this.gED.cancel();
        }
        if (this.gEE != null) {
            this.gEE.removeAllListeners();
            this.gEE.cancel();
        }
        if (this.gEF != null) {
            this.gEF.removeAllListeners();
            this.gEF.cancel();
        }
        if (this.gEG != null) {
            this.gEG.removeAllListeners();
            this.gEG.cancel();
        }
        if (this.gEH != null) {
            this.gEH.removeAllListeners();
            this.gEH.cancel();
        }
        if (this.gEI != null) {
            this.gEI.removeAllListeners();
            this.gEI.cancel();
        }
        if (this.gEJ != null) {
            this.gEJ.removeAllListeners();
            this.gEJ.cancel();
        }
        if (this.gEK != null) {
            this.gEK.removeAllListeners();
            this.gEK.cancel();
        }
    }

    public void a(com.baidu.tieba.ala.liveroom.operation.b bVar) {
        this.gqe = bVar;
    }

    public void mt(boolean z) {
        this.baw = z;
    }

    public void setLevel(int i) {
        if (this.gEr != null) {
            if (i <= 0) {
                this.gEr.setText("");
            } else {
                this.gEr.setText(String.valueOf(i));
            }
        }
    }
}
