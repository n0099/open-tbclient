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
    private TextView euO;
    private c gVQ;
    private com.baidu.tieba.ala.liveroom.operation.b gVX;
    private TextView giw;
    private Handler handler;
    private HeadImageView hka;
    private TextView hkb;
    private ImageView hkc;
    private TextView hkd;
    private ViewGroup hke;
    private ImageView hkf;
    private ImageView hkg;
    private RelativeLayout hkh;
    private RelativeLayout hki;
    private TextView hkj;
    private w hkk;
    private AnimatorSet hkp;
    private AnimatorSet hkq;
    private AnimatorSet hkr;
    private AnimatorSet hks;
    private AnimatorSet hkt;
    private AnimatorSet hku;
    private AnimatorSet hkv;
    private AnimatorSet hkw;
    private AnimatorSet hkx;
    private float hky;
    private boolean isHost;
    private Context mContext;
    private String otherParams;
    private View mView = null;
    private int hkl = 30000;
    public boolean hkm = false;
    private boolean beO = false;
    private Set<Long> hkn = new HashSet();
    private long hko = 0;
    CustomMessageListener gEG = new CustomMessageListener(2913106) { // from class: com.baidu.tieba.ala.liveroom.p.b.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof String) {
                b.this.GO((String) customResponsedMessage.getData());
            } else {
                b.this.ccO();
            }
        }
    };

    public b(Context context) {
        this.mContext = context;
        initView();
        MessageManager.getInstance().registerListener(this.gEG);
        this.handler = new Handler();
    }

    public void setId(int i) {
        this.mView.setId(i);
    }

    private void initView() {
        this.mView = View.inflate(this.mContext, a.g.hk_liveroom_hostheader_layout, null);
        this.mView.setBackgroundResource(a.e.sdk_round_host_bg);
        this.hkb = (TextView) this.mView.findViewById(a.f.ala_liveroom_hostheader_attention);
        this.hkd = (TextView) this.mView.findViewById(a.f.tv_guardClub_level);
        this.hka = (HeadImageView) this.mView.findViewById(a.f.ala_liveroom_hostheader_image);
        this.euO = (TextView) this.mView.findViewById(a.f.ala_liveroom_hostheader_guest);
        this.giw = (TextView) this.mView.findViewById(a.f.ala_liveroom_hostheader_address);
        this.hke = (ViewGroup) this.mView.findViewById(a.f.fl_guardClubEnter);
        this.hkc = (ImageView) this.mView.findViewById(a.f.guardClubEnter_imageView);
        this.hka.setIsRound(true);
        this.hka.setBorderColor(this.mContext.getResources().getColor(a.c.sdk_cp_bg_line_k_alpha10_1));
        this.hka.setAutoChangeStyle(false);
        this.hkg = (ImageView) this.mView.findViewById(a.f.ala_follow_success_img);
        this.hkh = (RelativeLayout) this.mView.findViewById(a.f.guardClub);
        this.hkj = (TextView) this.mView.findViewById(a.f.guardClubToast);
        this.hki = (RelativeLayout) this.mView.findViewById(a.f.follow_btn);
        RoundRectRelativeLayout roundRectRelativeLayout = (RoundRectRelativeLayout) this.mView.findViewById(a.f.roundRect);
        this.hkf = (ImageView) this.mView.findViewById(a.f.ala_icon_back);
        if (TbadkCoreApplication.getInst().isHaokan()) {
            roundRectRelativeLayout.setCornerRadius(this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds30));
            this.hki.setBackgroundResource(a.e.ala_live_follow_btn_radius_16_selector_hk);
            this.hkh.setBackgroundResource(a.e.ala_bg_guard_club);
        } else if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            roundRectRelativeLayout.setCornerRadius(this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds30));
            this.hki.setBackgroundResource(a.e.ala_live_room_follow_btn_radius_16_selector_bd);
            this.hkh.setBackgroundResource(a.e.ala_bg_guard_club_bd);
        } else {
            roundRectRelativeLayout.setCornerRadius(this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds30));
            this.hki.setBackgroundResource(a.e.ala_live_follow_btn_radius_16_selector_qm);
            this.hkh.setBackgroundResource(a.e.ala_bg_guard_club_qm);
        }
        this.hkf = (ImageView) this.mView.findViewById(a.f.ala_icon_back);
        if (UtilHelper.getRealScreenOrientation(this.mContext) == 2) {
            this.hkf.setVisibility(0);
        } else {
            this.hkf.setVisibility(8);
        }
        this.hkf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.p.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.gVX.s(b.this.hkf, 19);
            }
        });
    }

    public void n(View.OnClickListener onClickListener) {
        this.hki.setOnClickListener(onClickListener);
    }

    public void a(c cVar) {
        this.gVQ = cVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void nt(boolean z) {
        if (z) {
            this.hkh.setVisibility(0);
            this.hke.setVisibility(0);
            this.hki.setVisibility(0);
            return;
        }
        this.hkh.setVisibility(8);
        this.hki.setVisibility(4);
    }

    public void nu(boolean z) {
        if (TbadkCoreApplication.sAlaLiveSwitchData == null || (!TbadkCoreApplication.sAlaLiveSwitchData.isFollowBtnUnabled() && !TbadkCoreApplication.sAlaLiveSwitchData.isGuardFansUnabled())) {
            if (!z || this.beO) {
                ccD();
            } else {
                if (this.gVQ != null) {
                    this.gVQ.onClick();
                }
                ccE();
            }
        } else if (TbadkCoreApplication.sAlaLiveSwitchData != null && !TbadkCoreApplication.sAlaLiveSwitchData.isFollowBtnUnabled() && TbadkCoreApplication.sAlaLiveSwitchData.isGuardFansUnabled()) {
            ccx();
        }
        if (!this.isHost && this.hkk != null && this.hkk.mLiveInfo != null && this.hkk.aHk != null) {
            long j = this.hkk.aHk.userId;
            if (!this.hkn.contains(Long.valueOf(j))) {
                this.hkn.add(Long.valueOf(j));
                LogManager.getGuardClubLogger().doDisplayLiveGuardButtonLog(this.hkk.mLiveInfo.live_id + "", this.hkk.mLiveInfo.room_id + "", this.hkk.mLiveInfo.feed_id, this.otherParams);
            }
        }
    }

    private void ccD() {
        this.hkb.setVisibility(8);
        this.hke.setAlpha(1.0f);
        this.hke.setScaleX(1.0f);
        this.hke.setScaleY(1.0f);
        this.hke.setVisibility(0);
        this.hkj.setVisibility(4);
        this.hkh.setTranslationX(this.hky);
        this.hkh.getLayoutParams().width = this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds88);
        this.hkh.setVisibility(0);
    }

    public void ccx() {
        this.hki.setVisibility(4);
    }

    private void ccE() {
        if (!this.hkm && this.hke.getVisibility() != 0) {
            this.hkm = true;
            this.hkx = ccN();
            this.hkw = ccM();
            this.hkv = new AnimatorSet();
            this.hkv.play(this.hkw).after(this.hkx);
            this.hku = c(this.hkv);
            ValueAnimator ccK = ccK();
            ObjectAnimator ccL = ccL();
            this.hkt = new AnimatorSet();
            this.hkt.setStartDelay(IMConnection.RETRY_DELAY_TIMES);
            this.hkt.play(ccL).with(ccK);
            ObjectAnimator ccJ = ccJ();
            ObjectAnimator ccI = ccI();
            this.hks = new AnimatorSet();
            this.hks.setStartDelay(958L);
            this.hks.play(ccI).with(ccJ);
            this.hkr = ccH();
            AnimatorSet ccG = ccG();
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.play(ccG).after(this.hkr);
            this.hkq = ccF();
            AnimatorSet a2 = a(animatorSet);
            this.hkp = new AnimatorSet();
            this.hkp.play(a2).after(this.hkq);
            this.hkp.start();
        }
    }

    private AnimatorSet a(final AnimatorSet animatorSet) {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.hkb, "scaleX", 1.15f, 0.0f).setDuration(210L);
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.hkb, "scaleY", 1.15f, 0.0f).setDuration(210L);
        AnimatorSet animatorSet2 = new AnimatorSet();
        animatorSet2.play(duration).with(duration2);
        animatorSet2.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.liveroom.p.b.7
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                b.this.hkb.setVisibility(8);
                b.this.hkb.setScaleX(1.0f);
                b.this.hkb.setScaleY(1.0f);
                b.this.b(animatorSet);
            }
        });
        return animatorSet2;
    }

    private AnimatorSet ccF() {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.hkb, "scaleX", 1.0f, 1.15f).setDuration(42L);
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.hkb, "scaleY", 1.0f, 1.15f).setDuration(42L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(duration).with(duration2);
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.liveroom.p.b.8
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                b.this.hkb.setScaleX(1.15f);
                b.this.hkb.setScaleY(1.15f);
            }
        });
        return animatorSet;
    }

    private AnimatorSet ccG() {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.hkg, "scaleX", 1.15f, 1.0f).setDuration(42L);
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.hkg, "scaleY", 1.15f, 1.0f).setDuration(42L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(duration).with(duration2);
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.liveroom.p.b.9
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                b.this.b(b.this.hks);
            }
        });
        return animatorSet;
    }

    private AnimatorSet ccH() {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.hkg, "scaleX", 0.0f, 1.15f).setDuration(210L);
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.hkg, "scaleY", 0.0f, 1.15f).setDuration(210L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(duration).with(duration2);
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.liveroom.p.b.10
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                b.this.hkg.setVisibility(0);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                b.this.hkg.setScaleX(1.15f);
                b.this.hkg.setScaleY(1.15f);
            }
        });
        return animatorSet;
    }

    private ObjectAnimator ccI() {
        this.hky = this.hkh.getTranslationX();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.hkh, "translationX", this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds180) + this.hky, this.hky);
        ofFloat.setDuration(375L);
        ofFloat.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.liveroom.p.b.11
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                b.this.hkh.getLayoutParams().width = b.this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds180);
                b.this.hke.setVisibility(4);
                b.this.hkh.setVisibility(0);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                b.this.b(b.this.hkt);
            }
        });
        return ofFloat;
    }

    private ObjectAnimator ccJ() {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.hkj, "alpha", 0.0f, 1.0f).setDuration(210L);
        duration.setStartDelay(165L);
        duration.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.liveroom.p.b.12
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                b.this.hkj.setVisibility(0);
            }
        });
        return duration;
    }

    private ValueAnimator ccK() {
        ValueAnimator ofInt = ValueAnimator.ofInt(this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds180), this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds88));
        ofInt.setInterpolator(new FastOutLinearInInterpolator());
        ofInt.setDuration(542L);
        ofInt.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.liveroom.p.b.13
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                b.this.b(b.this.hku);
            }
        });
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.ala.liveroom.p.b.14
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                b.this.hkh.getLayoutParams().width = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                b.this.hkh.requestLayout();
            }
        });
        return ofInt;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(AnimatorSet animatorSet) {
        if (this.hkm && animatorSet != null) {
            animatorSet.start();
        }
    }

    private ObjectAnimator ccL() {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.hkj, "alpha", 1.0f, 0.0f).setDuration(210L);
        duration.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.liveroom.p.b.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                b.this.hkj.setVisibility(4);
                b.this.hkj.setAlpha(1.0f);
            }
        });
        return duration;
    }

    private AnimatorSet c(AnimatorSet animatorSet) {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.hke, "alpha", 0.0f, 1.0f).setDuration(292L);
        AnimatorSet animatorSet2 = new AnimatorSet();
        animatorSet2.setStartDelay(250L);
        animatorSet2.play(animatorSet).with(duration);
        return animatorSet2;
    }

    private AnimatorSet ccM() {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.hke, "scaleX", 1.15f, 1.0f).setDuration(84L);
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.hke, "scaleY", 1.15f, 1.0f).setDuration(84L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(duration).with(duration2);
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.liveroom.p.b.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                b.this.hkm = false;
                if (b.this.gVQ != null) {
                    b.this.gVQ.endAnimation();
                }
            }
        });
        return animatorSet;
    }

    private AnimatorSet ccN() {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.hke, "scaleX", 0.0f, 1.15f).setDuration(292L);
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.hke, "scaleY", 0.0f, 1.15f).setDuration(292L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(duration).with(duration2);
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.liveroom.p.b.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                b.this.hke.setScaleX(1.15f);
                b.this.hke.setScaleY(1.15f);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                b.this.hke.setVisibility(0);
            }
        });
        return animatorSet;
    }

    public void ccw() {
        if (this.hkm) {
            this.hkm = false;
            cancelAnimation();
        }
        this.hkb.setScaleY(1.0f);
        this.hkb.setScaleX(1.0f);
        this.hkb.setVisibility(0);
        this.hki.setVisibility(0);
        this.hkg.setVisibility(4);
        this.hke.setVisibility(4);
        this.hkj.setVisibility(4);
        this.hkh.setVisibility(8);
    }

    public View getView() {
        return this.mView;
    }

    public void eY(long j) {
        if (j > this.hko) {
            this.hko = j;
            this.giw.setText(String.format(this.mContext.getString(a.h.sdk_live_charm), StringHelper.formatForCharmValue(j)));
        }
    }

    public void a(w wVar, final boolean z, final String str) {
        boolean z2 = this.hkk == null || this.hkk.mLiveInfo == null || wVar == null || wVar.mLiveInfo == null || this.hkk.mLiveInfo.live_id != wVar.mLiveInfo.live_id;
        this.hkk = wVar;
        this.otherParams = str;
        this.isHost = z;
        if (this.hkk != null && this.hkk.aHk != null) {
            this.hka.stopLoad();
            this.hka.startLoad(this.hkk.aHk.portrait, 12, false, false);
            String str2 = this.hkk.aHk.userName;
            if (TextHelper.getTextLengthWithEmoji(str2) > 14) {
                str2 = TextHelper.subStringWithEmoji(str2, 14) + StringHelper.STRING_MORE;
            }
            this.euO.setText(str2);
            if (z2 || wVar.aHk.charmCount > this.hko) {
                this.hko = wVar.aHk.charmCount;
                this.giw.setText(String.format(this.mContext.getString(a.h.sdk_live_charm), StringHelper.formatForCharmValue(this.hko)));
            }
            this.hkh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.p.b.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    b.this.ccO();
                    if (!z && b.this.hkk != null && b.this.hkk.mLiveInfo != null) {
                        LogManager.getGuardClubLogger().doClickLiveGuardButtonLog(b.this.hkk.mLiveInfo.live_id + "", b.this.hkk.mLiveInfo.room_id + "", b.this.hkk.mLiveInfo.feed_id, str);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ccO() {
        GO(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GO(String str) {
        if (this.mContext != null && this.hkk != null && this.hkk.aHk != null && this.hkk.mLiveInfo != null) {
            long j = this.hkk.aHk.userId;
            long j2 = this.hkk.mLiveInfo.live_id;
            long j3 = this.hkk.mLiveInfo.room_id;
            String str2 = this.hkk.mLiveInfo.feed_id;
            GuardClubInfoActivityConfig guardClubInfoActivityConfig = new GuardClubInfoActivityConfig(this.mContext, j, j2, this.isHost, this.otherParams, false, str);
            guardClubInfoActivityConfig.setRoomId(j3);
            guardClubInfoActivityConfig.setFeedId(str2);
            guardClubInfoActivityConfig.setIsClubMember(this.beO);
            guardClubInfoActivityConfig.setAnchorInfo(this.hkk.aHk.nickName, this.hkk.aHk.portrait);
            guardClubInfoActivityConfig.setRequestCode(RequestResponseCode.REQUEST_GUARD_CLUB_INFO);
            guardClubInfoActivityConfig.setIntentAction(IntentAction.ActivityForResult);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, guardClubInfoActivityConfig));
        }
    }

    public void ccA() {
        cancelAnimation();
        if (this.hkm) {
            ccD();
            this.hkm = false;
        }
        setLevel(0);
    }

    public void onDestroy() {
        if (this.gEG != null) {
            MessageManager.getInstance().unRegisterListener(this.gEG);
        }
        cancelAnimation();
        if (this.handler != null) {
            this.handler.removeCallbacksAndMessages(null);
        }
        this.hkn.clear();
    }

    private void cancelAnimation() {
        if (this.hkp != null) {
            this.hkp.removeAllListeners();
            this.hkp.cancel();
        }
        if (this.hkq != null) {
            this.hkq.removeAllListeners();
            this.hkq.cancel();
        }
        if (this.hkr != null) {
            this.hkr.removeAllListeners();
            this.hkr.cancel();
        }
        if (this.hks != null) {
            this.hks.removeAllListeners();
            this.hks.cancel();
        }
        if (this.hkt != null) {
            this.hkt.removeAllListeners();
            this.hkt.cancel();
        }
        if (this.hku != null) {
            this.hku.removeAllListeners();
            this.hku.cancel();
        }
        if (this.hkv != null) {
            this.hkv.removeAllListeners();
            this.hkv.cancel();
        }
        if (this.hkw != null) {
            this.hkw.removeAllListeners();
            this.hkw.cancel();
        }
        if (this.hkx != null) {
            this.hkx.removeAllListeners();
            this.hkx.cancel();
        }
    }

    public void a(com.baidu.tieba.ala.liveroom.operation.b bVar) {
        this.gVX = bVar;
    }

    public void nv(boolean z) {
        this.beO = z;
    }

    public void setLevel(int i) {
        if (this.hkd != null) {
            if (i <= 0) {
                this.hkd.setText("");
            } else {
                this.hkd.setText(String.valueOf(i));
            }
        }
    }

    public HeadImageView ccP() {
        return this.hka;
    }
}
