package com.baidu.tieba.ala.liveroom.o;

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
import com.baidu.live.data.x;
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
    private TextView eGI;
    private TextView gwZ;
    private HeadImageView hAP;
    private TextView hAQ;
    private ImageView hAR;
    private TextView hAS;
    private ViewGroup hAT;
    private ImageView hAU;
    private ImageView hAV;
    private RelativeLayout hAW;
    private RelativeLayout hAX;
    private TextView hAY;
    private x hAZ;
    private AnimatorSet hBe;
    private AnimatorSet hBf;
    private AnimatorSet hBg;
    private AnimatorSet hBh;
    private AnimatorSet hBi;
    private AnimatorSet hBj;
    private AnimatorSet hBk;
    private AnimatorSet hBl;
    private AnimatorSet hBm;
    private float hBn;
    private Handler handler;
    private com.baidu.tieba.ala.liveroom.operation.b hmE;
    private c hmu;
    private boolean isHost;
    private Context mContext;
    private String otherParams;
    private View mView = null;
    private int hBa = 30000;
    public boolean hBb = false;
    private boolean bfU = false;
    private Set<Long> hBc = new HashSet();
    private long hBd = 0;
    CustomMessageListener gUN = new CustomMessageListener(2913106) { // from class: com.baidu.tieba.ala.liveroom.o.b.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof String) {
                b.this.Gq((String) customResponsedMessage.getData());
            } else {
                b.this.cfE();
            }
        }
    };

    public b(Context context) {
        this.mContext = context;
        initView();
        MessageManager.getInstance().registerListener(this.gUN);
        this.handler = new Handler();
    }

    public void setId(int i) {
        this.mView.setId(i);
    }

    private void initView() {
        this.mView = View.inflate(this.mContext, a.g.hk_liveroom_hostheader_layout, null);
        this.mView.setBackgroundResource(a.e.sdk_round_host_bg);
        this.hAQ = (TextView) this.mView.findViewById(a.f.ala_liveroom_hostheader_attention);
        this.hAS = (TextView) this.mView.findViewById(a.f.tv_guardClub_level);
        this.hAP = (HeadImageView) this.mView.findViewById(a.f.ala_liveroom_hostheader_image);
        this.eGI = (TextView) this.mView.findViewById(a.f.ala_liveroom_hostheader_guest);
        this.gwZ = (TextView) this.mView.findViewById(a.f.ala_liveroom_hostheader_address);
        this.hAT = (ViewGroup) this.mView.findViewById(a.f.fl_guardClubEnter);
        this.hAR = (ImageView) this.mView.findViewById(a.f.guardClubEnter_imageView);
        this.hAP.setIsRound(true);
        this.hAP.setBorderColor(this.mContext.getResources().getColor(a.c.sdk_cp_bg_line_k_alpha10_1));
        this.hAP.setAutoChangeStyle(false);
        this.hAV = (ImageView) this.mView.findViewById(a.f.ala_follow_success_img);
        this.hAW = (RelativeLayout) this.mView.findViewById(a.f.guardClub);
        this.hAY = (TextView) this.mView.findViewById(a.f.guardClubToast);
        this.hAX = (RelativeLayout) this.mView.findViewById(a.f.follow_btn);
        RoundRectRelativeLayout roundRectRelativeLayout = (RoundRectRelativeLayout) this.mView.findViewById(a.f.roundRect);
        this.hAU = (ImageView) this.mView.findViewById(a.f.ala_icon_back);
        if (TbadkCoreApplication.getInst().isHaokan()) {
            roundRectRelativeLayout.setCornerRadius(this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds30));
            this.hAX.setBackgroundResource(a.e.ala_live_follow_btn_radius_16_selector_hk);
            this.hAW.setBackgroundResource(a.e.ala_bg_guard_club);
        } else if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            roundRectRelativeLayout.setCornerRadius(this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds30));
            this.hAX.setBackgroundResource(a.e.ala_live_room_follow_btn_radius_16_selector_bd);
            this.hAW.setBackgroundResource(a.e.ala_bg_guard_club_bd);
        } else {
            roundRectRelativeLayout.setCornerRadius(this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds30));
            this.hAX.setBackgroundResource(a.e.ala_live_follow_btn_radius_16_selector_qm);
            this.hAW.setBackgroundResource(a.e.ala_bg_guard_club_qm);
        }
        this.hAU = (ImageView) this.mView.findViewById(a.f.ala_icon_back);
        if (UtilHelper.getRealScreenOrientation(this.mContext) == 2) {
            this.hAU.setVisibility(0);
        } else {
            this.hAU.setVisibility(8);
        }
        this.hAU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.o.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.hmE.v(b.this.hAU, 19);
            }
        });
    }

    public void o(View.OnClickListener onClickListener) {
        this.hAX.setOnClickListener(onClickListener);
    }

    public void a(c cVar) {
        this.hmu = cVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ok(boolean z) {
        if (z) {
            this.hAW.setVisibility(0);
            this.hAT.setVisibility(0);
            this.hAX.setVisibility(0);
            return;
        }
        this.hAW.setVisibility(8);
        this.hAX.setVisibility(4);
    }

    public void ol(boolean z) {
        if (TbadkCoreApplication.sAlaLiveSwitchData == null || (!TbadkCoreApplication.sAlaLiveSwitchData.isFollowBtnUnabled() && !TbadkCoreApplication.sAlaLiveSwitchData.isGuardFansUnabled())) {
            if (!z || this.bfU) {
                cft();
            } else {
                if (this.hmu != null) {
                    this.hmu.onClick();
                }
                cfu();
            }
        } else if (TbadkCoreApplication.sAlaLiveSwitchData != null && !TbadkCoreApplication.sAlaLiveSwitchData.isFollowBtnUnabled() && TbadkCoreApplication.sAlaLiveSwitchData.isGuardFansUnabled()) {
            cfn();
        }
        if (!this.isHost && this.hAZ != null && this.hAZ.mLiveInfo != null && this.hAZ.aFH != null) {
            long j = this.hAZ.aFH.userId;
            if (!this.hBc.contains(Long.valueOf(j))) {
                this.hBc.add(Long.valueOf(j));
                LogManager.getGuardClubLogger().doDisplayLiveGuardButtonLog(this.hAZ.mLiveInfo.live_id + "", this.hAZ.mLiveInfo.room_id + "", this.hAZ.mLiveInfo.feed_id, this.otherParams);
            }
        }
    }

    private void cft() {
        this.hAQ.setVisibility(8);
        this.hAT.setAlpha(1.0f);
        this.hAT.setScaleX(1.0f);
        this.hAT.setScaleY(1.0f);
        this.hAT.setVisibility(0);
        this.hAY.setVisibility(4);
        this.hAW.setTranslationX(this.hBn);
        this.hAW.getLayoutParams().width = this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds88);
        this.hAW.setVisibility(0);
    }

    public void cfn() {
        this.hAX.setVisibility(4);
    }

    private void cfu() {
        if (!this.hBb && this.hAT.getVisibility() != 0) {
            this.hBb = true;
            this.hBm = cfD();
            this.hBl = cfC();
            this.hBk = new AnimatorSet();
            this.hBk.play(this.hBl).after(this.hBm);
            this.hBj = c(this.hBk);
            ValueAnimator cfA = cfA();
            ObjectAnimator cfB = cfB();
            this.hBi = new AnimatorSet();
            this.hBi.setStartDelay(IMConnection.RETRY_DELAY_TIMES);
            this.hBi.play(cfB).with(cfA);
            ObjectAnimator cfz = cfz();
            ObjectAnimator cfy = cfy();
            this.hBh = new AnimatorSet();
            this.hBh.setStartDelay(958L);
            this.hBh.play(cfy).with(cfz);
            this.hBg = cfx();
            AnimatorSet cfw = cfw();
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.play(cfw).after(this.hBg);
            this.hBf = cfv();
            AnimatorSet a2 = a(animatorSet);
            this.hBe = new AnimatorSet();
            this.hBe.play(a2).after(this.hBf);
            this.hBe.start();
        }
    }

    private AnimatorSet a(final AnimatorSet animatorSet) {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.hAQ, "scaleX", 1.15f, 0.0f).setDuration(210L);
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.hAQ, "scaleY", 1.15f, 0.0f).setDuration(210L);
        AnimatorSet animatorSet2 = new AnimatorSet();
        animatorSet2.play(duration).with(duration2);
        animatorSet2.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.liveroom.o.b.7
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                b.this.hAQ.setVisibility(8);
                b.this.hAQ.setScaleX(1.0f);
                b.this.hAQ.setScaleY(1.0f);
                b.this.b(animatorSet);
            }
        });
        return animatorSet2;
    }

    private AnimatorSet cfv() {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.hAQ, "scaleX", 1.0f, 1.15f).setDuration(42L);
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.hAQ, "scaleY", 1.0f, 1.15f).setDuration(42L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(duration).with(duration2);
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.liveroom.o.b.8
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                b.this.hAQ.setScaleX(1.15f);
                b.this.hAQ.setScaleY(1.15f);
            }
        });
        return animatorSet;
    }

    private AnimatorSet cfw() {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.hAV, "scaleX", 1.15f, 1.0f).setDuration(42L);
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.hAV, "scaleY", 1.15f, 1.0f).setDuration(42L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(duration).with(duration2);
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.liveroom.o.b.9
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                b.this.b(b.this.hBh);
            }
        });
        return animatorSet;
    }

    private AnimatorSet cfx() {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.hAV, "scaleX", 0.0f, 1.15f).setDuration(210L);
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.hAV, "scaleY", 0.0f, 1.15f).setDuration(210L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(duration).with(duration2);
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.liveroom.o.b.10
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                b.this.hAV.setVisibility(0);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                b.this.hAV.setScaleX(1.15f);
                b.this.hAV.setScaleY(1.15f);
            }
        });
        return animatorSet;
    }

    private ObjectAnimator cfy() {
        this.hBn = this.hAW.getTranslationX();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.hAW, "translationX", this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds180) + this.hBn, this.hBn);
        ofFloat.setDuration(375L);
        ofFloat.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.liveroom.o.b.11
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                b.this.hAW.getLayoutParams().width = b.this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds180);
                b.this.hAT.setVisibility(4);
                b.this.hAW.setVisibility(0);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                b.this.b(b.this.hBi);
            }
        });
        return ofFloat;
    }

    private ObjectAnimator cfz() {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.hAY, "alpha", 0.0f, 1.0f).setDuration(210L);
        duration.setStartDelay(165L);
        duration.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.liveroom.o.b.12
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                b.this.hAY.setVisibility(0);
            }
        });
        return duration;
    }

    private ValueAnimator cfA() {
        ValueAnimator ofInt = ValueAnimator.ofInt(this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds180), this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds88));
        ofInt.setInterpolator(new FastOutLinearInInterpolator());
        ofInt.setDuration(542L);
        ofInt.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.liveroom.o.b.13
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                b.this.b(b.this.hBj);
            }
        });
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.ala.liveroom.o.b.14
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                b.this.hAW.getLayoutParams().width = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                b.this.hAW.requestLayout();
            }
        });
        return ofInt;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(AnimatorSet animatorSet) {
        if (this.hBb && animatorSet != null) {
            animatorSet.start();
        }
    }

    private ObjectAnimator cfB() {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.hAY, "alpha", 1.0f, 0.0f).setDuration(210L);
        duration.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.liveroom.o.b.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                b.this.hAY.setVisibility(4);
                b.this.hAY.setAlpha(1.0f);
            }
        });
        return duration;
    }

    private AnimatorSet c(AnimatorSet animatorSet) {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.hAT, "alpha", 0.0f, 1.0f).setDuration(292L);
        AnimatorSet animatorSet2 = new AnimatorSet();
        animatorSet2.setStartDelay(250L);
        animatorSet2.play(animatorSet).with(duration);
        return animatorSet2;
    }

    private AnimatorSet cfC() {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.hAT, "scaleX", 1.15f, 1.0f).setDuration(84L);
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.hAT, "scaleY", 1.15f, 1.0f).setDuration(84L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(duration).with(duration2);
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.liveroom.o.b.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                b.this.hBb = false;
                if (b.this.hmu != null) {
                    b.this.hmu.endAnimation();
                }
            }
        });
        return animatorSet;
    }

    private AnimatorSet cfD() {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.hAT, "scaleX", 0.0f, 1.15f).setDuration(292L);
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.hAT, "scaleY", 0.0f, 1.15f).setDuration(292L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(duration).with(duration2);
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.liveroom.o.b.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                b.this.hAT.setScaleX(1.15f);
                b.this.hAT.setScaleY(1.15f);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                b.this.hAT.setVisibility(0);
            }
        });
        return animatorSet;
    }

    public void cfm() {
        if (this.hBb) {
            this.hBb = false;
            cancelAnimation();
        }
        this.hAQ.setScaleY(1.0f);
        this.hAQ.setScaleX(1.0f);
        this.hAQ.setVisibility(0);
        this.hAX.setVisibility(0);
        this.hAV.setVisibility(4);
        this.hAT.setVisibility(4);
        this.hAY.setVisibility(4);
        this.hAW.setVisibility(8);
    }

    public View getView() {
        return this.mView;
    }

    public void fC(long j) {
        if (j > this.hBd) {
            this.hBd = j;
            this.gwZ.setText(String.format(this.mContext.getString(a.h.sdk_live_charm), StringHelper.formatForCharmValue(j)));
        }
    }

    public void a(x xVar, final boolean z, final String str) {
        boolean z2 = this.hAZ == null || this.hAZ.mLiveInfo == null || xVar == null || xVar.mLiveInfo == null || this.hAZ.mLiveInfo.live_id != xVar.mLiveInfo.live_id;
        this.hAZ = xVar;
        this.otherParams = str;
        this.isHost = z;
        if (this.hAZ != null && this.hAZ.aFH != null) {
            this.hAP.stopLoad();
            this.hAP.startLoad(this.hAZ.aFH.portrait, 12, false, false);
            String str2 = this.hAZ.aFH.userName;
            if (TextHelper.getTextLengthWithEmoji(str2) > 14) {
                str2 = TextHelper.subStringWithEmoji(str2, 14) + StringHelper.STRING_MORE;
            }
            this.eGI.setText(str2);
            if (z2 || xVar.aFH.charmCount > this.hBd) {
                this.hBd = xVar.aFH.charmCount;
                this.gwZ.setText(String.format(this.mContext.getString(a.h.sdk_live_charm), StringHelper.formatForCharmValue(this.hBd)));
            }
            this.hAW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.o.b.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    b.this.cfE();
                    if (!z && b.this.hAZ != null && b.this.hAZ.mLiveInfo != null) {
                        LogManager.getGuardClubLogger().doClickLiveGuardButtonLog(b.this.hAZ.mLiveInfo.live_id + "", b.this.hAZ.mLiveInfo.room_id + "", b.this.hAZ.mLiveInfo.feed_id, str);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cfE() {
        Gq(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Gq(String str) {
        if (this.mContext != null && this.hAZ != null && this.hAZ.aFH != null && this.hAZ.mLiveInfo != null) {
            long j = this.hAZ.aFH.userId;
            long j2 = this.hAZ.mLiveInfo.live_id;
            long j3 = this.hAZ.mLiveInfo.room_id;
            String str2 = this.hAZ.mLiveInfo.feed_id;
            GuardClubInfoActivityConfig guardClubInfoActivityConfig = new GuardClubInfoActivityConfig(this.mContext, j, j2, this.isHost, this.otherParams, false, str);
            guardClubInfoActivityConfig.setRoomId(j3);
            guardClubInfoActivityConfig.setFeedId(str2);
            guardClubInfoActivityConfig.setIsClubMember(this.bfU);
            guardClubInfoActivityConfig.setAnchorInfo(this.hAZ.aFH.nickName, this.hAZ.aFH.portrait);
            guardClubInfoActivityConfig.setRequestCode(RequestResponseCode.REQUEST_GUARD_CLUB_INFO);
            guardClubInfoActivityConfig.setIntentAction(IntentAction.ActivityForResult);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, guardClubInfoActivityConfig));
        }
    }

    public void cfq() {
        cancelAnimation();
        if (this.hBb) {
            cft();
            this.hBb = false;
        }
        setLevel(0);
    }

    public void onDestroy() {
        if (this.gUN != null) {
            MessageManager.getInstance().unRegisterListener(this.gUN);
        }
        cancelAnimation();
        if (this.handler != null) {
            this.handler.removeCallbacksAndMessages(null);
        }
        this.hBc.clear();
    }

    private void cancelAnimation() {
        if (this.hBe != null) {
            this.hBe.removeAllListeners();
            this.hBe.cancel();
        }
        if (this.hBf != null) {
            this.hBf.removeAllListeners();
            this.hBf.cancel();
        }
        if (this.hBg != null) {
            this.hBg.removeAllListeners();
            this.hBg.cancel();
        }
        if (this.hBh != null) {
            this.hBh.removeAllListeners();
            this.hBh.cancel();
        }
        if (this.hBi != null) {
            this.hBi.removeAllListeners();
            this.hBi.cancel();
        }
        if (this.hBj != null) {
            this.hBj.removeAllListeners();
            this.hBj.cancel();
        }
        if (this.hBk != null) {
            this.hBk.removeAllListeners();
            this.hBk.cancel();
        }
        if (this.hBl != null) {
            this.hBl.removeAllListeners();
            this.hBl.cancel();
        }
        if (this.hBm != null) {
            this.hBm.removeAllListeners();
            this.hBm.cancel();
        }
    }

    public void a(com.baidu.tieba.ala.liveroom.operation.b bVar) {
        this.hmE = bVar;
    }

    public void om(boolean z) {
        this.bfU = z;
    }

    public void setLevel(int i) {
        if (this.hAS != null) {
            if (i <= 0) {
                this.hAS.setText("");
            } else {
                this.hAS.setText(String.valueOf(i));
            }
        }
    }

    public HeadImageView cfF() {
        return this.hAP;
    }
}
