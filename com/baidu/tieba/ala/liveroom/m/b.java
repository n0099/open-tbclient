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
/* loaded from: classes11.dex */
public class b {
    private TextView eIO;
    private TextView gzJ;
    private HeadImageView hEZ;
    private TextView hFa;
    private ImageView hFb;
    private TextView hFc;
    private ViewGroup hFd;
    private ImageView hFe;
    private ImageView hFf;
    private RelativeLayout hFg;
    private RelativeLayout hFh;
    private TextView hFi;
    private ab hFj;
    private AnimatorSet hFo;
    private AnimatorSet hFp;
    private AnimatorSet hFq;
    private AnimatorSet hFr;
    private AnimatorSet hFs;
    private AnimatorSet hFt;
    private AnimatorSet hFu;
    private AnimatorSet hFv;
    private AnimatorSet hFw;
    private float hFx;
    private Handler handler;
    private c hqI;
    private com.baidu.tieba.ala.liveroom.operation.b hqR;
    private boolean isHost;
    private Context mContext;
    private String otherParams;
    private View mView = null;
    private int hFk = 30000;
    public boolean hFl = false;
    private boolean bjd = false;
    private Set<Long> hFm = new HashSet();
    private long hFn = 0;
    CustomMessageListener gXx = new CustomMessageListener(2913106) { // from class: com.baidu.tieba.ala.liveroom.m.b.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof String) {
                b.this.GP((String) customResponsedMessage.getData());
            } else {
                b.this.cgx();
            }
        }
    };

    public b(Context context) {
        this.mContext = context;
        initView();
        MessageManager.getInstance().registerListener(this.gXx);
        this.handler = new Handler();
    }

    public void setId(int i) {
        this.mView.setId(i);
    }

    private void initView() {
        this.mView = View.inflate(this.mContext, a.g.hk_liveroom_hostheader_layout, null);
        this.mView.setBackgroundResource(a.e.sdk_round_host_bg);
        this.hFa = (TextView) this.mView.findViewById(a.f.ala_liveroom_hostheader_attention);
        this.hFc = (TextView) this.mView.findViewById(a.f.tv_guardClub_level);
        this.hEZ = (HeadImageView) this.mView.findViewById(a.f.ala_liveroom_hostheader_image);
        this.eIO = (TextView) this.mView.findViewById(a.f.ala_liveroom_hostheader_guest);
        this.gzJ = (TextView) this.mView.findViewById(a.f.ala_liveroom_hostheader_address);
        this.hFd = (ViewGroup) this.mView.findViewById(a.f.fl_guardClubEnter);
        this.hFb = (ImageView) this.mView.findViewById(a.f.guardClubEnter_imageView);
        this.hEZ.setIsRound(true);
        this.hEZ.setBorderColor(this.mContext.getResources().getColor(a.c.sdk_cp_bg_line_k_alpha10_1));
        this.hEZ.setAutoChangeStyle(false);
        this.hFf = (ImageView) this.mView.findViewById(a.f.ala_follow_success_img);
        this.hFg = (RelativeLayout) this.mView.findViewById(a.f.guardClub);
        this.hFi = (TextView) this.mView.findViewById(a.f.guardClubToast);
        this.hFh = (RelativeLayout) this.mView.findViewById(a.f.follow_btn);
        RoundRectRelativeLayout roundRectRelativeLayout = (RoundRectRelativeLayout) this.mView.findViewById(a.f.roundRect);
        this.hFe = (ImageView) this.mView.findViewById(a.f.ala_icon_back);
        if (TbadkCoreApplication.getInst().isHaokan()) {
            roundRectRelativeLayout.setCornerRadius(this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds30));
            this.hFg.setBackgroundResource(a.e.ala_bg_guard_club);
        } else if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            roundRectRelativeLayout.setCornerRadius(this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds30));
            this.hFg.setBackgroundResource(a.e.ala_bg_guard_club_bd);
        } else {
            roundRectRelativeLayout.setCornerRadius(this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds30));
            this.hFg.setBackgroundResource(a.e.ala_bg_guard_club_qm);
        }
        this.hFe = (ImageView) this.mView.findViewById(a.f.ala_icon_back);
        if (UtilHelper.getRealScreenOrientation(this.mContext) == 2) {
            this.hFe.setVisibility(0);
        } else {
            this.hFe.setVisibility(8);
        }
        this.hFe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.m.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.hqR.v(b.this.hFe, 19);
            }
        });
    }

    public void o(View.OnClickListener onClickListener) {
        this.hFh.setOnClickListener(onClickListener);
    }

    public void a(c cVar) {
        this.hqI = cVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ou(boolean z) {
        if (z) {
            this.hFg.setVisibility(0);
            this.hFd.setVisibility(0);
            this.hFh.setVisibility(0);
            return;
        }
        this.hFg.setVisibility(8);
        this.hFh.setVisibility(4);
    }

    public void ov(boolean z) {
        if (TbadkCoreApplication.sAlaLiveSwitchData == null || (!TbadkCoreApplication.sAlaLiveSwitchData.isFollowBtnUnabled() && !TbadkCoreApplication.sAlaLiveSwitchData.isGuardFansUnabled())) {
            if (!z || this.bjd) {
                cgm();
            } else {
                if (this.hqI != null) {
                    this.hqI.onClick();
                }
                cgn();
            }
        } else if (TbadkCoreApplication.sAlaLiveSwitchData != null && !TbadkCoreApplication.sAlaLiveSwitchData.isFollowBtnUnabled() && TbadkCoreApplication.sAlaLiveSwitchData.isGuardFansUnabled()) {
            cgg();
        }
        if (!this.isHost && this.hFj != null && this.hFj.mLiveInfo != null && this.hFj.aId != null) {
            long j = this.hFj.aId.userId;
            if (!this.hFm.contains(Long.valueOf(j))) {
                this.hFm.add(Long.valueOf(j));
                LogManager.getGuardClubLogger().doDisplayLiveGuardButtonLog(this.hFj.mLiveInfo.live_id + "", this.hFj.mLiveInfo.room_id + "", this.hFj.mLiveInfo.feed_id, this.otherParams);
            }
        }
    }

    private void cgm() {
        this.hFa.setVisibility(8);
        this.hFd.setAlpha(1.0f);
        this.hFd.setScaleX(1.0f);
        this.hFd.setScaleY(1.0f);
        this.hFd.setVisibility(0);
        this.hFi.setVisibility(4);
        this.hFg.setTranslationX(this.hFx);
        this.hFg.getLayoutParams().width = this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds88);
        this.hFg.setVisibility(0);
    }

    public void cgg() {
        this.hFh.setVisibility(8);
    }

    private void cgn() {
        if (!this.hFl && this.hFd.getVisibility() != 0) {
            this.hFl = true;
            this.hFw = cgw();
            this.hFv = cgv();
            this.hFu = new AnimatorSet();
            this.hFu.play(this.hFv).after(this.hFw);
            this.hFt = c(this.hFu);
            ValueAnimator cgt = cgt();
            ObjectAnimator cgu = cgu();
            this.hFs = new AnimatorSet();
            this.hFs.setStartDelay(IMConnection.RETRY_DELAY_TIMES);
            this.hFs.play(cgu).with(cgt);
            ObjectAnimator cgs = cgs();
            ObjectAnimator cgr = cgr();
            this.hFr = new AnimatorSet();
            this.hFr.setStartDelay(958L);
            this.hFr.play(cgr).with(cgs);
            this.hFq = cgq();
            AnimatorSet cgp = cgp();
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.play(cgp).after(this.hFq);
            this.hFp = cgo();
            AnimatorSet a2 = a(animatorSet);
            this.hFo = new AnimatorSet();
            this.hFo.play(a2).after(this.hFp);
            this.hFo.start();
        }
    }

    private AnimatorSet a(final AnimatorSet animatorSet) {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.hFa, "scaleX", 1.15f, 0.0f).setDuration(210L);
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.hFa, "scaleY", 1.15f, 0.0f).setDuration(210L);
        AnimatorSet animatorSet2 = new AnimatorSet();
        animatorSet2.play(duration).with(duration2);
        animatorSet2.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.liveroom.m.b.7
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                b.this.hFa.setVisibility(8);
                b.this.hFa.setScaleX(1.0f);
                b.this.hFa.setScaleY(1.0f);
                b.this.b(animatorSet);
            }
        });
        return animatorSet2;
    }

    private AnimatorSet cgo() {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.hFa, "scaleX", 1.0f, 1.15f).setDuration(42L);
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.hFa, "scaleY", 1.0f, 1.15f).setDuration(42L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(duration).with(duration2);
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.liveroom.m.b.8
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                b.this.hFa.setScaleX(1.15f);
                b.this.hFa.setScaleY(1.15f);
            }
        });
        return animatorSet;
    }

    private AnimatorSet cgp() {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.hFf, "scaleX", 1.15f, 1.0f).setDuration(42L);
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.hFf, "scaleY", 1.15f, 1.0f).setDuration(42L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(duration).with(duration2);
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.liveroom.m.b.9
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                b.this.b(b.this.hFr);
            }
        });
        return animatorSet;
    }

    private AnimatorSet cgq() {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.hFf, "scaleX", 0.0f, 1.15f).setDuration(210L);
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.hFf, "scaleY", 0.0f, 1.15f).setDuration(210L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(duration).with(duration2);
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.liveroom.m.b.10
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                b.this.hFf.setVisibility(0);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                b.this.hFf.setScaleX(1.15f);
                b.this.hFf.setScaleY(1.15f);
            }
        });
        return animatorSet;
    }

    private ObjectAnimator cgr() {
        this.hFx = this.hFg.getTranslationX();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.hFg, "translationX", this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds180) + this.hFx, this.hFx);
        ofFloat.setDuration(375L);
        ofFloat.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.liveroom.m.b.11
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                b.this.hFg.getLayoutParams().width = b.this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds180);
                b.this.hFd.setVisibility(4);
                b.this.hFg.setVisibility(0);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                b.this.b(b.this.hFs);
            }
        });
        return ofFloat;
    }

    private ObjectAnimator cgs() {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.hFi, "alpha", 0.0f, 1.0f).setDuration(210L);
        duration.setStartDelay(165L);
        duration.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.liveroom.m.b.12
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                b.this.hFi.setVisibility(0);
            }
        });
        return duration;
    }

    private ValueAnimator cgt() {
        ValueAnimator ofInt = ValueAnimator.ofInt(this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds180), this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds88));
        ofInt.setInterpolator(new FastOutLinearInInterpolator());
        ofInt.setDuration(542L);
        ofInt.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.liveroom.m.b.13
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                b.this.b(b.this.hFt);
            }
        });
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.ala.liveroom.m.b.14
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                b.this.hFg.getLayoutParams().width = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                b.this.hFg.requestLayout();
            }
        });
        return ofInt;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(AnimatorSet animatorSet) {
        if (this.hFl && animatorSet != null) {
            animatorSet.start();
        }
    }

    private ObjectAnimator cgu() {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.hFi, "alpha", 1.0f, 0.0f).setDuration(210L);
        duration.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.liveroom.m.b.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                b.this.hFi.setVisibility(4);
                b.this.hFi.setAlpha(1.0f);
            }
        });
        return duration;
    }

    private AnimatorSet c(AnimatorSet animatorSet) {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.hFd, "alpha", 0.0f, 1.0f).setDuration(292L);
        AnimatorSet animatorSet2 = new AnimatorSet();
        animatorSet2.setStartDelay(250L);
        animatorSet2.play(animatorSet).with(duration);
        return animatorSet2;
    }

    private AnimatorSet cgv() {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.hFd, "scaleX", 1.15f, 1.0f).setDuration(84L);
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.hFd, "scaleY", 1.15f, 1.0f).setDuration(84L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(duration).with(duration2);
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.liveroom.m.b.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                b.this.hFl = false;
                if (b.this.hqI != null) {
                    b.this.hqI.endAnimation();
                }
            }
        });
        return animatorSet;
    }

    private AnimatorSet cgw() {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.hFd, "scaleX", 0.0f, 1.15f).setDuration(292L);
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.hFd, "scaleY", 0.0f, 1.15f).setDuration(292L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(duration).with(duration2);
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.liveroom.m.b.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                b.this.hFd.setScaleX(1.15f);
                b.this.hFd.setScaleY(1.15f);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                b.this.hFd.setVisibility(0);
            }
        });
        return animatorSet;
    }

    public void cgf() {
        if (this.hFl) {
            this.hFl = false;
            cancelAnimation();
        }
        this.hFa.setScaleY(1.0f);
        this.hFa.setScaleX(1.0f);
        this.hFa.setVisibility(0);
        this.hFh.setVisibility(0);
        this.hFf.setVisibility(4);
        this.hFd.setVisibility(4);
        this.hFi.setVisibility(4);
        this.hFg.setVisibility(8);
    }

    public View getView() {
        return this.mView;
    }

    public void fH(long j) {
        if (j > this.hFn) {
            this.hFn = j;
            this.gzJ.setText(String.format(this.mContext.getString(a.h.sdk_live_charm), StringHelper.formatForCharmValue(j)));
        }
    }

    public void a(ab abVar, final boolean z, final String str) {
        boolean z2 = this.hFj == null || this.hFj.mLiveInfo == null || abVar == null || abVar.mLiveInfo == null || this.hFj.mLiveInfo.live_id != abVar.mLiveInfo.live_id;
        this.hFj = abVar;
        this.otherParams = str;
        this.isHost = z;
        if (this.hFj != null && this.hFj.aId != null) {
            this.hEZ.stopLoad();
            this.hEZ.startLoad(this.hFj.aId.portrait, 12, false, false);
            String str2 = this.hFj.aId.userName;
            if (TextHelper.getTextLengthWithEmoji(str2) > 14) {
                str2 = TextHelper.subStringWithEmoji(str2, 14) + StringHelper.STRING_MORE;
            }
            this.eIO.setText(str2);
            if (z2 || abVar.aId.charmCount > this.hFn) {
                this.hFn = abVar.aId.charmCount;
                this.gzJ.setText(String.format(this.mContext.getString(a.h.sdk_live_charm), StringHelper.formatForCharmValue(this.hFn)));
            }
            this.hFg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.m.b.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    b.this.cgx();
                    if (!z && b.this.hFj != null && b.this.hFj.mLiveInfo != null) {
                        LogManager.getGuardClubLogger().doClickLiveGuardButtonLog(b.this.hFj.mLiveInfo.live_id + "", b.this.hFj.mLiveInfo.room_id + "", b.this.hFj.mLiveInfo.feed_id, str);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cgx() {
        GP(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GP(String str) {
        if (this.mContext != null && this.hFj != null && this.hFj.aId != null && this.hFj.mLiveInfo != null) {
            long j = this.hFj.aId.userId;
            long j2 = this.hFj.mLiveInfo.live_id;
            long j3 = this.hFj.mLiveInfo.room_id;
            String str2 = this.hFj.mLiveInfo.feed_id;
            GuardClubInfoActivityConfig guardClubInfoActivityConfig = new GuardClubInfoActivityConfig(this.mContext, j, j2, this.isHost, this.otherParams, false, str);
            guardClubInfoActivityConfig.setRoomId(j3);
            guardClubInfoActivityConfig.setFeedId(str2);
            guardClubInfoActivityConfig.setIsClubMember(this.bjd);
            guardClubInfoActivityConfig.setAnchorInfo(this.hFj.aId.nickName, this.hFj.aId.portrait);
            guardClubInfoActivityConfig.setRequestCode(RequestResponseCode.REQUEST_GUARD_CLUB_INFO);
            guardClubInfoActivityConfig.setIntentAction(IntentAction.ActivityForResult);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, guardClubInfoActivityConfig));
        }
    }

    public void cgj() {
        cancelAnimation();
        if (this.hFl) {
            cgm();
            this.hFl = false;
        }
        setLevel(0);
    }

    public void onDestroy() {
        if (this.gXx != null) {
            MessageManager.getInstance().unRegisterListener(this.gXx);
        }
        cancelAnimation();
        if (this.handler != null) {
            this.handler.removeCallbacksAndMessages(null);
        }
        this.hFm.clear();
    }

    private void cancelAnimation() {
        if (this.hFo != null) {
            this.hFo.removeAllListeners();
            this.hFo.cancel();
        }
        if (this.hFp != null) {
            this.hFp.removeAllListeners();
            this.hFp.cancel();
        }
        if (this.hFq != null) {
            this.hFq.removeAllListeners();
            this.hFq.cancel();
        }
        if (this.hFr != null) {
            this.hFr.removeAllListeners();
            this.hFr.cancel();
        }
        if (this.hFs != null) {
            this.hFs.removeAllListeners();
            this.hFs.cancel();
        }
        if (this.hFt != null) {
            this.hFt.removeAllListeners();
            this.hFt.cancel();
        }
        if (this.hFu != null) {
            this.hFu.removeAllListeners();
            this.hFu.cancel();
        }
        if (this.hFv != null) {
            this.hFv.removeAllListeners();
            this.hFv.cancel();
        }
        if (this.hFw != null) {
            this.hFw.removeAllListeners();
            this.hFw.cancel();
        }
    }

    public void a(com.baidu.tieba.ala.liveroom.operation.b bVar) {
        this.hqR = bVar;
    }

    public void ow(boolean z) {
        this.bjd = z;
    }

    public void setLevel(int i) {
        if (this.hFc != null) {
            if (i <= 0) {
                this.hFc.setText("");
            } else {
                this.hFc.setText(String.valueOf(i));
            }
        }
    }

    public HeadImageView cgy() {
        return this.hEZ;
    }
}
