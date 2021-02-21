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
    private TextView gzX;
    private AnimatorSet hFC;
    private AnimatorSet hFD;
    private AnimatorSet hFE;
    private AnimatorSet hFF;
    private AnimatorSet hFG;
    private AnimatorSet hFH;
    private AnimatorSet hFI;
    private AnimatorSet hFJ;
    private AnimatorSet hFK;
    private float hFL;
    private HeadImageView hFn;
    private TextView hFo;
    private ImageView hFp;
    private TextView hFq;
    private ViewGroup hFr;
    private ImageView hFs;
    private ImageView hFt;
    private RelativeLayout hFu;
    private RelativeLayout hFv;
    private TextView hFw;
    private ab hFx;
    private Handler handler;
    private c hqW;
    private com.baidu.tieba.ala.liveroom.operation.b hrf;
    private boolean isHost;
    private Context mContext;
    private String otherParams;
    private View mView = null;
    private int hFy = 30000;
    public boolean hFz = false;
    private boolean bjd = false;
    private Set<Long> hFA = new HashSet();
    private long hFB = 0;
    CustomMessageListener gXL = new CustomMessageListener(2913106) { // from class: com.baidu.tieba.ala.liveroom.m.b.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof String) {
                b.this.GQ((String) customResponsedMessage.getData());
            } else {
                b.this.cgE();
            }
        }
    };

    public b(Context context) {
        this.mContext = context;
        initView();
        MessageManager.getInstance().registerListener(this.gXL);
        this.handler = new Handler();
    }

    public void setId(int i) {
        this.mView.setId(i);
    }

    private void initView() {
        this.mView = View.inflate(this.mContext, a.g.hk_liveroom_hostheader_layout, null);
        this.mView.setBackgroundResource(a.e.sdk_round_host_bg);
        this.hFo = (TextView) this.mView.findViewById(a.f.ala_liveroom_hostheader_attention);
        this.hFq = (TextView) this.mView.findViewById(a.f.tv_guardClub_level);
        this.hFn = (HeadImageView) this.mView.findViewById(a.f.ala_liveroom_hostheader_image);
        this.eIO = (TextView) this.mView.findViewById(a.f.ala_liveroom_hostheader_guest);
        this.gzX = (TextView) this.mView.findViewById(a.f.ala_liveroom_hostheader_address);
        this.hFr = (ViewGroup) this.mView.findViewById(a.f.fl_guardClubEnter);
        this.hFp = (ImageView) this.mView.findViewById(a.f.guardClubEnter_imageView);
        this.hFn.setIsRound(true);
        this.hFn.setBorderColor(this.mContext.getResources().getColor(a.c.sdk_cp_bg_line_k_alpha10_1));
        this.hFn.setAutoChangeStyle(false);
        this.hFt = (ImageView) this.mView.findViewById(a.f.ala_follow_success_img);
        this.hFu = (RelativeLayout) this.mView.findViewById(a.f.guardClub);
        this.hFw = (TextView) this.mView.findViewById(a.f.guardClubToast);
        this.hFv = (RelativeLayout) this.mView.findViewById(a.f.follow_btn);
        RoundRectRelativeLayout roundRectRelativeLayout = (RoundRectRelativeLayout) this.mView.findViewById(a.f.roundRect);
        this.hFs = (ImageView) this.mView.findViewById(a.f.ala_icon_back);
        if (TbadkCoreApplication.getInst().isHaokan()) {
            roundRectRelativeLayout.setCornerRadius(this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds30));
            this.hFu.setBackgroundResource(a.e.ala_bg_guard_club);
        } else if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            roundRectRelativeLayout.setCornerRadius(this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds30));
            this.hFu.setBackgroundResource(a.e.ala_bg_guard_club_bd);
        } else {
            roundRectRelativeLayout.setCornerRadius(this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds30));
            this.hFu.setBackgroundResource(a.e.ala_bg_guard_club_qm);
        }
        this.hFs = (ImageView) this.mView.findViewById(a.f.ala_icon_back);
        if (UtilHelper.getRealScreenOrientation(this.mContext) == 2) {
            this.hFs.setVisibility(0);
        } else {
            this.hFs.setVisibility(8);
        }
        this.hFs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.m.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.hrf.v(b.this.hFs, 19);
            }
        });
    }

    public void o(View.OnClickListener onClickListener) {
        this.hFv.setOnClickListener(onClickListener);
    }

    public void a(c cVar) {
        this.hqW = cVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ou(boolean z) {
        if (z) {
            this.hFu.setVisibility(0);
            this.hFr.setVisibility(0);
            this.hFv.setVisibility(0);
            return;
        }
        this.hFu.setVisibility(8);
        this.hFv.setVisibility(4);
    }

    public void ov(boolean z) {
        if (TbadkCoreApplication.sAlaLiveSwitchData == null || (!TbadkCoreApplication.sAlaLiveSwitchData.isFollowBtnUnabled() && !TbadkCoreApplication.sAlaLiveSwitchData.isGuardFansUnabled())) {
            if (!z || this.bjd) {
                cgt();
            } else {
                if (this.hqW != null) {
                    this.hqW.onClick();
                }
                cgu();
            }
        } else if (TbadkCoreApplication.sAlaLiveSwitchData != null && !TbadkCoreApplication.sAlaLiveSwitchData.isFollowBtnUnabled() && TbadkCoreApplication.sAlaLiveSwitchData.isGuardFansUnabled()) {
            cgn();
        }
        if (!this.isHost && this.hFx != null && this.hFx.mLiveInfo != null && this.hFx.aId != null) {
            long j = this.hFx.aId.userId;
            if (!this.hFA.contains(Long.valueOf(j))) {
                this.hFA.add(Long.valueOf(j));
                LogManager.getGuardClubLogger().doDisplayLiveGuardButtonLog(this.hFx.mLiveInfo.live_id + "", this.hFx.mLiveInfo.room_id + "", this.hFx.mLiveInfo.feed_id, this.otherParams);
            }
        }
    }

    private void cgt() {
        this.hFo.setVisibility(8);
        this.hFr.setAlpha(1.0f);
        this.hFr.setScaleX(1.0f);
        this.hFr.setScaleY(1.0f);
        this.hFr.setVisibility(0);
        this.hFw.setVisibility(4);
        this.hFu.setTranslationX(this.hFL);
        this.hFu.getLayoutParams().width = this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds88);
        this.hFu.setVisibility(0);
    }

    public void cgn() {
        this.hFv.setVisibility(8);
    }

    private void cgu() {
        if (!this.hFz && this.hFr.getVisibility() != 0) {
            this.hFz = true;
            this.hFK = cgD();
            this.hFJ = cgC();
            this.hFI = new AnimatorSet();
            this.hFI.play(this.hFJ).after(this.hFK);
            this.hFH = c(this.hFI);
            ValueAnimator cgA = cgA();
            ObjectAnimator cgB = cgB();
            this.hFG = new AnimatorSet();
            this.hFG.setStartDelay(IMConnection.RETRY_DELAY_TIMES);
            this.hFG.play(cgB).with(cgA);
            ObjectAnimator cgz = cgz();
            ObjectAnimator cgy = cgy();
            this.hFF = new AnimatorSet();
            this.hFF.setStartDelay(958L);
            this.hFF.play(cgy).with(cgz);
            this.hFE = cgx();
            AnimatorSet cgw = cgw();
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.play(cgw).after(this.hFE);
            this.hFD = cgv();
            AnimatorSet a2 = a(animatorSet);
            this.hFC = new AnimatorSet();
            this.hFC.play(a2).after(this.hFD);
            this.hFC.start();
        }
    }

    private AnimatorSet a(final AnimatorSet animatorSet) {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.hFo, "scaleX", 1.15f, 0.0f).setDuration(210L);
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.hFo, "scaleY", 1.15f, 0.0f).setDuration(210L);
        AnimatorSet animatorSet2 = new AnimatorSet();
        animatorSet2.play(duration).with(duration2);
        animatorSet2.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.liveroom.m.b.7
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                b.this.hFo.setVisibility(8);
                b.this.hFo.setScaleX(1.0f);
                b.this.hFo.setScaleY(1.0f);
                b.this.b(animatorSet);
            }
        });
        return animatorSet2;
    }

    private AnimatorSet cgv() {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.hFo, "scaleX", 1.0f, 1.15f).setDuration(42L);
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.hFo, "scaleY", 1.0f, 1.15f).setDuration(42L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(duration).with(duration2);
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.liveroom.m.b.8
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                b.this.hFo.setScaleX(1.15f);
                b.this.hFo.setScaleY(1.15f);
            }
        });
        return animatorSet;
    }

    private AnimatorSet cgw() {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.hFt, "scaleX", 1.15f, 1.0f).setDuration(42L);
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.hFt, "scaleY", 1.15f, 1.0f).setDuration(42L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(duration).with(duration2);
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.liveroom.m.b.9
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                b.this.b(b.this.hFF);
            }
        });
        return animatorSet;
    }

    private AnimatorSet cgx() {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.hFt, "scaleX", 0.0f, 1.15f).setDuration(210L);
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.hFt, "scaleY", 0.0f, 1.15f).setDuration(210L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(duration).with(duration2);
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.liveroom.m.b.10
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                b.this.hFt.setVisibility(0);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                b.this.hFt.setScaleX(1.15f);
                b.this.hFt.setScaleY(1.15f);
            }
        });
        return animatorSet;
    }

    private ObjectAnimator cgy() {
        this.hFL = this.hFu.getTranslationX();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.hFu, "translationX", this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds180) + this.hFL, this.hFL);
        ofFloat.setDuration(375L);
        ofFloat.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.liveroom.m.b.11
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                b.this.hFu.getLayoutParams().width = b.this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds180);
                b.this.hFr.setVisibility(4);
                b.this.hFu.setVisibility(0);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                b.this.b(b.this.hFG);
            }
        });
        return ofFloat;
    }

    private ObjectAnimator cgz() {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.hFw, "alpha", 0.0f, 1.0f).setDuration(210L);
        duration.setStartDelay(165L);
        duration.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.liveroom.m.b.12
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                b.this.hFw.setVisibility(0);
            }
        });
        return duration;
    }

    private ValueAnimator cgA() {
        ValueAnimator ofInt = ValueAnimator.ofInt(this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds180), this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds88));
        ofInt.setInterpolator(new FastOutLinearInInterpolator());
        ofInt.setDuration(542L);
        ofInt.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.liveroom.m.b.13
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                b.this.b(b.this.hFH);
            }
        });
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.ala.liveroom.m.b.14
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                b.this.hFu.getLayoutParams().width = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                b.this.hFu.requestLayout();
            }
        });
        return ofInt;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(AnimatorSet animatorSet) {
        if (this.hFz && animatorSet != null) {
            animatorSet.start();
        }
    }

    private ObjectAnimator cgB() {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.hFw, "alpha", 1.0f, 0.0f).setDuration(210L);
        duration.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.liveroom.m.b.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                b.this.hFw.setVisibility(4);
                b.this.hFw.setAlpha(1.0f);
            }
        });
        return duration;
    }

    private AnimatorSet c(AnimatorSet animatorSet) {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.hFr, "alpha", 0.0f, 1.0f).setDuration(292L);
        AnimatorSet animatorSet2 = new AnimatorSet();
        animatorSet2.setStartDelay(250L);
        animatorSet2.play(animatorSet).with(duration);
        return animatorSet2;
    }

    private AnimatorSet cgC() {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.hFr, "scaleX", 1.15f, 1.0f).setDuration(84L);
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.hFr, "scaleY", 1.15f, 1.0f).setDuration(84L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(duration).with(duration2);
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.liveroom.m.b.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                b.this.hFz = false;
                if (b.this.hqW != null) {
                    b.this.hqW.endAnimation();
                }
            }
        });
        return animatorSet;
    }

    private AnimatorSet cgD() {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.hFr, "scaleX", 0.0f, 1.15f).setDuration(292L);
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.hFr, "scaleY", 0.0f, 1.15f).setDuration(292L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(duration).with(duration2);
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.liveroom.m.b.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                b.this.hFr.setScaleX(1.15f);
                b.this.hFr.setScaleY(1.15f);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                b.this.hFr.setVisibility(0);
            }
        });
        return animatorSet;
    }

    public void cgm() {
        if (this.hFz) {
            this.hFz = false;
            cancelAnimation();
        }
        this.hFo.setScaleY(1.0f);
        this.hFo.setScaleX(1.0f);
        this.hFo.setVisibility(0);
        this.hFv.setVisibility(0);
        this.hFt.setVisibility(4);
        this.hFr.setVisibility(4);
        this.hFw.setVisibility(4);
        this.hFu.setVisibility(8);
    }

    public View getView() {
        return this.mView;
    }

    public void fH(long j) {
        if (j > this.hFB) {
            this.hFB = j;
            this.gzX.setText(String.format(this.mContext.getString(a.h.sdk_live_charm), StringHelper.formatForCharmValue(j)));
        }
    }

    public void a(ab abVar, final boolean z, final String str) {
        boolean z2 = this.hFx == null || this.hFx.mLiveInfo == null || abVar == null || abVar.mLiveInfo == null || this.hFx.mLiveInfo.live_id != abVar.mLiveInfo.live_id;
        this.hFx = abVar;
        this.otherParams = str;
        this.isHost = z;
        if (this.hFx != null && this.hFx.aId != null) {
            this.hFn.stopLoad();
            this.hFn.startLoad(this.hFx.aId.portrait, 12, false, false);
            String str2 = this.hFx.aId.userName;
            if (TextHelper.getTextLengthWithEmoji(str2) > 14) {
                str2 = TextHelper.subStringWithEmoji(str2, 14) + StringHelper.STRING_MORE;
            }
            this.eIO.setText(str2);
            if (z2 || abVar.aId.charmCount > this.hFB) {
                this.hFB = abVar.aId.charmCount;
                this.gzX.setText(String.format(this.mContext.getString(a.h.sdk_live_charm), StringHelper.formatForCharmValue(this.hFB)));
            }
            this.hFu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.m.b.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    b.this.cgE();
                    if (!z && b.this.hFx != null && b.this.hFx.mLiveInfo != null) {
                        LogManager.getGuardClubLogger().doClickLiveGuardButtonLog(b.this.hFx.mLiveInfo.live_id + "", b.this.hFx.mLiveInfo.room_id + "", b.this.hFx.mLiveInfo.feed_id, str);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cgE() {
        GQ(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GQ(String str) {
        if (this.mContext != null && this.hFx != null && this.hFx.aId != null && this.hFx.mLiveInfo != null) {
            long j = this.hFx.aId.userId;
            long j2 = this.hFx.mLiveInfo.live_id;
            long j3 = this.hFx.mLiveInfo.room_id;
            String str2 = this.hFx.mLiveInfo.feed_id;
            GuardClubInfoActivityConfig guardClubInfoActivityConfig = new GuardClubInfoActivityConfig(this.mContext, j, j2, this.isHost, this.otherParams, false, str);
            guardClubInfoActivityConfig.setRoomId(j3);
            guardClubInfoActivityConfig.setFeedId(str2);
            guardClubInfoActivityConfig.setIsClubMember(this.bjd);
            guardClubInfoActivityConfig.setAnchorInfo(this.hFx.aId.nickName, this.hFx.aId.portrait);
            guardClubInfoActivityConfig.setRequestCode(RequestResponseCode.REQUEST_GUARD_CLUB_INFO);
            guardClubInfoActivityConfig.setIntentAction(IntentAction.ActivityForResult);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, guardClubInfoActivityConfig));
        }
    }

    public void cgq() {
        cancelAnimation();
        if (this.hFz) {
            cgt();
            this.hFz = false;
        }
        setLevel(0);
    }

    public void onDestroy() {
        if (this.gXL != null) {
            MessageManager.getInstance().unRegisterListener(this.gXL);
        }
        cancelAnimation();
        if (this.handler != null) {
            this.handler.removeCallbacksAndMessages(null);
        }
        this.hFA.clear();
    }

    private void cancelAnimation() {
        if (this.hFC != null) {
            this.hFC.removeAllListeners();
            this.hFC.cancel();
        }
        if (this.hFD != null) {
            this.hFD.removeAllListeners();
            this.hFD.cancel();
        }
        if (this.hFE != null) {
            this.hFE.removeAllListeners();
            this.hFE.cancel();
        }
        if (this.hFF != null) {
            this.hFF.removeAllListeners();
            this.hFF.cancel();
        }
        if (this.hFG != null) {
            this.hFG.removeAllListeners();
            this.hFG.cancel();
        }
        if (this.hFH != null) {
            this.hFH.removeAllListeners();
            this.hFH.cancel();
        }
        if (this.hFI != null) {
            this.hFI.removeAllListeners();
            this.hFI.cancel();
        }
        if (this.hFJ != null) {
            this.hFJ.removeAllListeners();
            this.hFJ.cancel();
        }
        if (this.hFK != null) {
            this.hFK.removeAllListeners();
            this.hFK.cancel();
        }
    }

    public void a(com.baidu.tieba.ala.liveroom.operation.b bVar) {
        this.hrf = bVar;
    }

    public void ow(boolean z) {
        this.bjd = z;
    }

    public void setLevel(int i) {
        if (this.hFq != null) {
            if (i <= 0) {
                this.hFq.setText("");
            } else {
                this.hFq.setText(String.valueOf(i));
            }
        }
    }

    public HeadImageView cgF() {
        return this.hFn;
    }
}
