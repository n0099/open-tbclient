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
/* loaded from: classes11.dex */
public class b {
    private TextView eLt;
    private TextView gBG;
    private ImageView hFA;
    private ImageView hFB;
    private RelativeLayout hFC;
    private RelativeLayout hFD;
    private TextView hFE;
    private x hFF;
    private AnimatorSet hFK;
    private AnimatorSet hFL;
    private AnimatorSet hFM;
    private AnimatorSet hFN;
    private AnimatorSet hFO;
    private AnimatorSet hFP;
    private AnimatorSet hFQ;
    private AnimatorSet hFR;
    private AnimatorSet hFS;
    private float hFT;
    private HeadImageView hFv;
    private TextView hFw;
    private ImageView hFx;
    private TextView hFy;
    private ViewGroup hFz;
    private Handler handler;
    private c hrb;
    private com.baidu.tieba.ala.liveroom.operation.b hrl;
    private boolean isHost;
    private Context mContext;
    private String otherParams;
    private View mView = null;
    private int hFG = 30000;
    public boolean hFH = false;
    private boolean bkK = false;
    private Set<Long> hFI = new HashSet();
    private long hFJ = 0;
    CustomMessageListener gZt = new CustomMessageListener(2913106) { // from class: com.baidu.tieba.ala.liveroom.o.b.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof String) {
                b.this.HB((String) customResponsedMessage.getData());
            } else {
                b.this.cjw();
            }
        }
    };

    public b(Context context) {
        this.mContext = context;
        initView();
        MessageManager.getInstance().registerListener(this.gZt);
        this.handler = new Handler();
    }

    public void setId(int i) {
        this.mView.setId(i);
    }

    private void initView() {
        this.mView = View.inflate(this.mContext, a.g.hk_liveroom_hostheader_layout, null);
        this.mView.setBackgroundResource(a.e.sdk_round_host_bg);
        this.hFw = (TextView) this.mView.findViewById(a.f.ala_liveroom_hostheader_attention);
        this.hFy = (TextView) this.mView.findViewById(a.f.tv_guardClub_level);
        this.hFv = (HeadImageView) this.mView.findViewById(a.f.ala_liveroom_hostheader_image);
        this.eLt = (TextView) this.mView.findViewById(a.f.ala_liveroom_hostheader_guest);
        this.gBG = (TextView) this.mView.findViewById(a.f.ala_liveroom_hostheader_address);
        this.hFz = (ViewGroup) this.mView.findViewById(a.f.fl_guardClubEnter);
        this.hFx = (ImageView) this.mView.findViewById(a.f.guardClubEnter_imageView);
        this.hFv.setIsRound(true);
        this.hFv.setBorderColor(this.mContext.getResources().getColor(a.c.sdk_cp_bg_line_k_alpha10_1));
        this.hFv.setAutoChangeStyle(false);
        this.hFB = (ImageView) this.mView.findViewById(a.f.ala_follow_success_img);
        this.hFC = (RelativeLayout) this.mView.findViewById(a.f.guardClub);
        this.hFE = (TextView) this.mView.findViewById(a.f.guardClubToast);
        this.hFD = (RelativeLayout) this.mView.findViewById(a.f.follow_btn);
        RoundRectRelativeLayout roundRectRelativeLayout = (RoundRectRelativeLayout) this.mView.findViewById(a.f.roundRect);
        this.hFA = (ImageView) this.mView.findViewById(a.f.ala_icon_back);
        if (TbadkCoreApplication.getInst().isHaokan()) {
            roundRectRelativeLayout.setCornerRadius(this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds30));
            this.hFD.setBackgroundResource(a.e.ala_live_follow_btn_radius_16_selector_hk);
            this.hFC.setBackgroundResource(a.e.ala_bg_guard_club);
        } else if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            roundRectRelativeLayout.setCornerRadius(this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds30));
            this.hFD.setBackgroundResource(a.e.ala_live_room_follow_btn_radius_16_selector_bd);
            this.hFC.setBackgroundResource(a.e.ala_bg_guard_club_bd);
        } else {
            roundRectRelativeLayout.setCornerRadius(this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds30));
            this.hFD.setBackgroundResource(a.e.ala_live_follow_btn_radius_16_selector_qm);
            this.hFC.setBackgroundResource(a.e.ala_bg_guard_club_qm);
        }
        this.hFA = (ImageView) this.mView.findViewById(a.f.ala_icon_back);
        if (UtilHelper.getRealScreenOrientation(this.mContext) == 2) {
            this.hFA.setVisibility(0);
        } else {
            this.hFA.setVisibility(8);
        }
        this.hFA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.o.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.hrl.v(b.this.hFA, 19);
            }
        });
    }

    public void o(View.OnClickListener onClickListener) {
        this.hFD.setOnClickListener(onClickListener);
    }

    public void a(c cVar) {
        this.hrb = cVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void oo(boolean z) {
        if (z) {
            this.hFC.setVisibility(0);
            this.hFz.setVisibility(0);
            this.hFD.setVisibility(0);
            return;
        }
        this.hFC.setVisibility(8);
        this.hFD.setVisibility(4);
    }

    public void op(boolean z) {
        if (TbadkCoreApplication.sAlaLiveSwitchData == null || (!TbadkCoreApplication.sAlaLiveSwitchData.isFollowBtnUnabled() && !TbadkCoreApplication.sAlaLiveSwitchData.isGuardFansUnabled())) {
            if (!z || this.bkK) {
                cjl();
            } else {
                if (this.hrb != null) {
                    this.hrb.onClick();
                }
                cjm();
            }
        } else if (TbadkCoreApplication.sAlaLiveSwitchData != null && !TbadkCoreApplication.sAlaLiveSwitchData.isFollowBtnUnabled() && TbadkCoreApplication.sAlaLiveSwitchData.isGuardFansUnabled()) {
            cjf();
        }
        if (!this.isHost && this.hFF != null && this.hFF.mLiveInfo != null && this.hFF.aKu != null) {
            long j = this.hFF.aKu.userId;
            if (!this.hFI.contains(Long.valueOf(j))) {
                this.hFI.add(Long.valueOf(j));
                LogManager.getGuardClubLogger().doDisplayLiveGuardButtonLog(this.hFF.mLiveInfo.live_id + "", this.hFF.mLiveInfo.room_id + "", this.hFF.mLiveInfo.feed_id, this.otherParams);
            }
        }
    }

    private void cjl() {
        this.hFw.setVisibility(8);
        this.hFz.setAlpha(1.0f);
        this.hFz.setScaleX(1.0f);
        this.hFz.setScaleY(1.0f);
        this.hFz.setVisibility(0);
        this.hFE.setVisibility(4);
        this.hFC.setTranslationX(this.hFT);
        this.hFC.getLayoutParams().width = this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds88);
        this.hFC.setVisibility(0);
    }

    public void cjf() {
        this.hFD.setVisibility(4);
    }

    private void cjm() {
        if (!this.hFH && this.hFz.getVisibility() != 0) {
            this.hFH = true;
            this.hFS = cjv();
            this.hFR = cju();
            this.hFQ = new AnimatorSet();
            this.hFQ.play(this.hFR).after(this.hFS);
            this.hFP = c(this.hFQ);
            ValueAnimator cjs = cjs();
            ObjectAnimator cjt = cjt();
            this.hFO = new AnimatorSet();
            this.hFO.setStartDelay(IMConnection.RETRY_DELAY_TIMES);
            this.hFO.play(cjt).with(cjs);
            ObjectAnimator cjr = cjr();
            ObjectAnimator cjq = cjq();
            this.hFN = new AnimatorSet();
            this.hFN.setStartDelay(958L);
            this.hFN.play(cjq).with(cjr);
            this.hFM = cjp();
            AnimatorSet cjo = cjo();
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.play(cjo).after(this.hFM);
            this.hFL = cjn();
            AnimatorSet a2 = a(animatorSet);
            this.hFK = new AnimatorSet();
            this.hFK.play(a2).after(this.hFL);
            this.hFK.start();
        }
    }

    private AnimatorSet a(final AnimatorSet animatorSet) {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.hFw, "scaleX", 1.15f, 0.0f).setDuration(210L);
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.hFw, "scaleY", 1.15f, 0.0f).setDuration(210L);
        AnimatorSet animatorSet2 = new AnimatorSet();
        animatorSet2.play(duration).with(duration2);
        animatorSet2.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.liveroom.o.b.7
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                b.this.hFw.setVisibility(8);
                b.this.hFw.setScaleX(1.0f);
                b.this.hFw.setScaleY(1.0f);
                b.this.b(animatorSet);
            }
        });
        return animatorSet2;
    }

    private AnimatorSet cjn() {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.hFw, "scaleX", 1.0f, 1.15f).setDuration(42L);
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.hFw, "scaleY", 1.0f, 1.15f).setDuration(42L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(duration).with(duration2);
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.liveroom.o.b.8
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                b.this.hFw.setScaleX(1.15f);
                b.this.hFw.setScaleY(1.15f);
            }
        });
        return animatorSet;
    }

    private AnimatorSet cjo() {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.hFB, "scaleX", 1.15f, 1.0f).setDuration(42L);
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.hFB, "scaleY", 1.15f, 1.0f).setDuration(42L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(duration).with(duration2);
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.liveroom.o.b.9
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                b.this.b(b.this.hFN);
            }
        });
        return animatorSet;
    }

    private AnimatorSet cjp() {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.hFB, "scaleX", 0.0f, 1.15f).setDuration(210L);
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.hFB, "scaleY", 0.0f, 1.15f).setDuration(210L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(duration).with(duration2);
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.liveroom.o.b.10
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                b.this.hFB.setVisibility(0);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                b.this.hFB.setScaleX(1.15f);
                b.this.hFB.setScaleY(1.15f);
            }
        });
        return animatorSet;
    }

    private ObjectAnimator cjq() {
        this.hFT = this.hFC.getTranslationX();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.hFC, "translationX", this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds180) + this.hFT, this.hFT);
        ofFloat.setDuration(375L);
        ofFloat.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.liveroom.o.b.11
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                b.this.hFC.getLayoutParams().width = b.this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds180);
                b.this.hFz.setVisibility(4);
                b.this.hFC.setVisibility(0);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                b.this.b(b.this.hFO);
            }
        });
        return ofFloat;
    }

    private ObjectAnimator cjr() {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.hFE, "alpha", 0.0f, 1.0f).setDuration(210L);
        duration.setStartDelay(165L);
        duration.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.liveroom.o.b.12
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                b.this.hFE.setVisibility(0);
            }
        });
        return duration;
    }

    private ValueAnimator cjs() {
        ValueAnimator ofInt = ValueAnimator.ofInt(this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds180), this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds88));
        ofInt.setInterpolator(new FastOutLinearInInterpolator());
        ofInt.setDuration(542L);
        ofInt.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.liveroom.o.b.13
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                b.this.b(b.this.hFP);
            }
        });
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.ala.liveroom.o.b.14
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                b.this.hFC.getLayoutParams().width = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                b.this.hFC.requestLayout();
            }
        });
        return ofInt;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(AnimatorSet animatorSet) {
        if (this.hFH && animatorSet != null) {
            animatorSet.start();
        }
    }

    private ObjectAnimator cjt() {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.hFE, "alpha", 1.0f, 0.0f).setDuration(210L);
        duration.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.liveroom.o.b.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                b.this.hFE.setVisibility(4);
                b.this.hFE.setAlpha(1.0f);
            }
        });
        return duration;
    }

    private AnimatorSet c(AnimatorSet animatorSet) {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.hFz, "alpha", 0.0f, 1.0f).setDuration(292L);
        AnimatorSet animatorSet2 = new AnimatorSet();
        animatorSet2.setStartDelay(250L);
        animatorSet2.play(animatorSet).with(duration);
        return animatorSet2;
    }

    private AnimatorSet cju() {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.hFz, "scaleX", 1.15f, 1.0f).setDuration(84L);
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.hFz, "scaleY", 1.15f, 1.0f).setDuration(84L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(duration).with(duration2);
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.liveroom.o.b.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                b.this.hFH = false;
                if (b.this.hrb != null) {
                    b.this.hrb.endAnimation();
                }
            }
        });
        return animatorSet;
    }

    private AnimatorSet cjv() {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.hFz, "scaleX", 0.0f, 1.15f).setDuration(292L);
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.hFz, "scaleY", 0.0f, 1.15f).setDuration(292L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(duration).with(duration2);
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.liveroom.o.b.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                b.this.hFz.setScaleX(1.15f);
                b.this.hFz.setScaleY(1.15f);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                b.this.hFz.setVisibility(0);
            }
        });
        return animatorSet;
    }

    public void cje() {
        if (this.hFH) {
            this.hFH = false;
            cancelAnimation();
        }
        this.hFw.setScaleY(1.0f);
        this.hFw.setScaleX(1.0f);
        this.hFw.setVisibility(0);
        this.hFD.setVisibility(0);
        this.hFB.setVisibility(4);
        this.hFz.setVisibility(4);
        this.hFE.setVisibility(4);
        this.hFC.setVisibility(8);
    }

    public View getView() {
        return this.mView;
    }

    public void fC(long j) {
        if (j > this.hFJ) {
            this.hFJ = j;
            this.gBG.setText(String.format(this.mContext.getString(a.h.sdk_live_charm), StringHelper.formatForCharmValue(j)));
        }
    }

    public void a(x xVar, final boolean z, final String str) {
        boolean z2 = this.hFF == null || this.hFF.mLiveInfo == null || xVar == null || xVar.mLiveInfo == null || this.hFF.mLiveInfo.live_id != xVar.mLiveInfo.live_id;
        this.hFF = xVar;
        this.otherParams = str;
        this.isHost = z;
        if (this.hFF != null && this.hFF.aKu != null) {
            this.hFv.stopLoad();
            this.hFv.startLoad(this.hFF.aKu.portrait, 12, false, false);
            String str2 = this.hFF.aKu.userName;
            if (TextHelper.getTextLengthWithEmoji(str2) > 14) {
                str2 = TextHelper.subStringWithEmoji(str2, 14) + StringHelper.STRING_MORE;
            }
            this.eLt.setText(str2);
            if (z2 || xVar.aKu.charmCount > this.hFJ) {
                this.hFJ = xVar.aKu.charmCount;
                this.gBG.setText(String.format(this.mContext.getString(a.h.sdk_live_charm), StringHelper.formatForCharmValue(this.hFJ)));
            }
            this.hFC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.o.b.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    b.this.cjw();
                    if (!z && b.this.hFF != null && b.this.hFF.mLiveInfo != null) {
                        LogManager.getGuardClubLogger().doClickLiveGuardButtonLog(b.this.hFF.mLiveInfo.live_id + "", b.this.hFF.mLiveInfo.room_id + "", b.this.hFF.mLiveInfo.feed_id, str);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cjw() {
        HB(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void HB(String str) {
        if (this.mContext != null && this.hFF != null && this.hFF.aKu != null && this.hFF.mLiveInfo != null) {
            long j = this.hFF.aKu.userId;
            long j2 = this.hFF.mLiveInfo.live_id;
            long j3 = this.hFF.mLiveInfo.room_id;
            String str2 = this.hFF.mLiveInfo.feed_id;
            GuardClubInfoActivityConfig guardClubInfoActivityConfig = new GuardClubInfoActivityConfig(this.mContext, j, j2, this.isHost, this.otherParams, false, str);
            guardClubInfoActivityConfig.setRoomId(j3);
            guardClubInfoActivityConfig.setFeedId(str2);
            guardClubInfoActivityConfig.setIsClubMember(this.bkK);
            guardClubInfoActivityConfig.setAnchorInfo(this.hFF.aKu.nickName, this.hFF.aKu.portrait);
            guardClubInfoActivityConfig.setRequestCode(RequestResponseCode.REQUEST_GUARD_CLUB_INFO);
            guardClubInfoActivityConfig.setIntentAction(IntentAction.ActivityForResult);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, guardClubInfoActivityConfig));
        }
    }

    public void cji() {
        cancelAnimation();
        if (this.hFH) {
            cjl();
            this.hFH = false;
        }
        setLevel(0);
    }

    public void onDestroy() {
        if (this.gZt != null) {
            MessageManager.getInstance().unRegisterListener(this.gZt);
        }
        cancelAnimation();
        if (this.handler != null) {
            this.handler.removeCallbacksAndMessages(null);
        }
        this.hFI.clear();
    }

    private void cancelAnimation() {
        if (this.hFK != null) {
            this.hFK.removeAllListeners();
            this.hFK.cancel();
        }
        if (this.hFL != null) {
            this.hFL.removeAllListeners();
            this.hFL.cancel();
        }
        if (this.hFM != null) {
            this.hFM.removeAllListeners();
            this.hFM.cancel();
        }
        if (this.hFN != null) {
            this.hFN.removeAllListeners();
            this.hFN.cancel();
        }
        if (this.hFO != null) {
            this.hFO.removeAllListeners();
            this.hFO.cancel();
        }
        if (this.hFP != null) {
            this.hFP.removeAllListeners();
            this.hFP.cancel();
        }
        if (this.hFQ != null) {
            this.hFQ.removeAllListeners();
            this.hFQ.cancel();
        }
        if (this.hFR != null) {
            this.hFR.removeAllListeners();
            this.hFR.cancel();
        }
        if (this.hFS != null) {
            this.hFS.removeAllListeners();
            this.hFS.cancel();
        }
    }

    public void a(com.baidu.tieba.ala.liveroom.operation.b bVar) {
        this.hrl = bVar;
    }

    public void oq(boolean z) {
        this.bkK = z;
    }

    public void setLevel(int i) {
        if (this.hFy != null) {
            if (i <= 0) {
                this.hFy.setText("");
            } else {
                this.hFy.setText(String.valueOf(i));
            }
        }
    }

    public HeadImageView cjx() {
        return this.hFv;
    }
}
