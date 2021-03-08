package com.baidu.tieba.ala.liveroom.challenge.view;

import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.be;
import com.baidu.live.data.bf;
import com.baidu.live.data.bg;
import com.baidu.live.data.bk;
import com.baidu.live.data.cg;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.util.TextHelper;
import com.baidu.live.utils.h;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public class AlaChallengeLiveView extends RelativeLayout implements View.OnClickListener {
    private bk aQg;
    private bk aQh;
    private CountDownTimer gPV;
    private RelativeLayout hAA;
    private RelativeLayout hAB;
    private RelativeLayout hAC;
    private ImageView hAD;
    private TextView hAE;
    private LinearLayout hAF;
    private ChallengeJinzhuView hAG;
    private ChallengeJinzhuView hAH;
    private ChallengeJinzhuView hAI;
    private RelativeLayout hAJ;
    private RelativeLayout hAK;
    private HeadImageView hAL;
    private TextView hAM;
    private ImageView hAN;
    private LinearLayout hAO;
    private ChallengeJinzhuView hAP;
    private ChallengeJinzhuView hAQ;
    private ChallengeJinzhuView hAR;
    private RelativeLayout hAS;
    private ImageView hAT;
    private TextView hAU;
    private AlaChallengeMvpTipView hAV;
    private AlaChallengeMvpDynamicAnimView hAW;
    private LinearLayout hAX;
    private TextView hAY;
    private RelativeLayout hAZ;
    private RelativeLayout hAx;
    private RelativeLayout hAy;
    private RelativeLayout hAz;
    private TextView hBa;
    private TextView hBb;
    private View hBc;
    private View hBd;
    private TextView hBe;
    private a hBf;
    private long hBg;
    private long hBh;
    private int hBi;
    private int hBj;
    private bg hBk;
    private ValueAnimator hBl;
    private AnimatorSet hBm;
    private List<be> hBn;
    private List<be> hBo;
    public boolean hBp;
    private RelativeLayout hfF;
    private boolean isHost;
    private Context mContext;
    private Handler mHandler;
    private RelativeLayout rootView;
    private int screenWidth;

    /* loaded from: classes10.dex */
    public interface a {
        void a(cg cgVar);

        void cei();

        void cej();

        void d(bk bkVar);

        void e(bk bkVar);

        void f(bk bkVar);

        void oe(boolean z);
    }

    public AlaChallengeLiveView(Context context) {
        super(context);
        this.isHost = false;
        this.hBg = -1L;
        this.hBh = -1L;
        this.screenWidth = -1;
        this.hBi = 0;
        this.hBj = 0;
        this.hBp = false;
        init(context);
    }

    public AlaChallengeLiveView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isHost = false;
        this.hBg = -1L;
        this.hBh = -1L;
        this.screenWidth = -1;
        this.hBi = 0;
        this.hBj = 0;
        this.hBp = false;
        init(context);
    }

    public AlaChallengeLiveView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isHost = false;
        this.hBg = -1L;
        this.hBh = -1L;
        this.screenWidth = -1;
        this.hBi = 0;
        this.hBj = 0;
        this.hBp = false;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.mHandler = new Handler(Looper.getMainLooper());
        initView(context);
        updateView();
    }

    public void setNeedCloseRecommendFloat(boolean z) {
        this.hBp = z;
        this.hAG.setNeedCloseRecommendFloat(this.hBp);
        this.hAH.setNeedCloseRecommendFloat(this.hBp);
        this.hAI.setNeedCloseRecommendFloat(this.hBp);
        this.hAP.setNeedCloseRecommendFloat(this.hBp);
        this.hAQ.setNeedCloseRecommendFloat(this.hBp);
        this.hAR.setNeedCloseRecommendFloat(this.hBp);
    }

    public void setIsHost(boolean z) {
        this.isHost = z;
    }

    private void initView(Context context) {
        this.rootView = (RelativeLayout) View.inflate(context, a.g.ala_challenge_panel_optation_view, this);
        this.hfF = (RelativeLayout) this.rootView.findViewById(a.f.root_container);
        this.hAy = (RelativeLayout) this.rootView.findViewById(a.f.anchor_live_anim_layout);
        this.hAz = (RelativeLayout) this.rootView.findViewById(a.f.rival_live_anim_layout);
        this.hAx = (RelativeLayout) this.rootView.findViewById(a.f.pk_live_container);
        this.hAB = (RelativeLayout) this.rootView.findViewById(a.f.pk_anchor_live_layout);
        this.hAC = (RelativeLayout) this.rootView.findViewById(a.f.anchor_streak_win_layout);
        this.hAD = (ImageView) this.rootView.findViewById(a.f.anchor_user_pk_streak_img);
        this.hAE = (TextView) this.rootView.findViewById(a.f.anchor_user_pk_streak_time);
        this.hAA = (RelativeLayout) this.rootView.findViewById(a.f.jinzhu_container);
        this.hAF = (LinearLayout) this.rootView.findViewById(a.f.anchor_jinzhu_layout);
        this.hAG = (ChallengeJinzhuView) this.rootView.findViewById(a.f.anchor_jinzhu_1);
        this.hAH = (ChallengeJinzhuView) this.rootView.findViewById(a.f.anchor_jinzhu_2);
        this.hAI = (ChallengeJinzhuView) this.rootView.findViewById(a.f.anchor_jinzhu_3);
        this.hAJ = (RelativeLayout) this.rootView.findViewById(a.f.pk_rival_live_layout);
        this.hAK = (RelativeLayout) this.rootView.findViewById(a.f.pk_rival_user_layout);
        this.hAL = (HeadImageView) this.rootView.findViewById(a.f.ala_live_rival_user_image);
        this.hAM = (TextView) this.rootView.findViewById(a.f.ala_live_rival_user_name);
        this.hAN = (ImageView) this.rootView.findViewById(a.f.iv_rival_user_follow);
        this.hAS = (RelativeLayout) this.rootView.findViewById(a.f.rival_streak_win_layout);
        this.hAO = (LinearLayout) this.rootView.findViewById(a.f.rival_jinzhu_layout);
        this.hAP = (ChallengeJinzhuView) this.rootView.findViewById(a.f.rival_jinzhu_1);
        this.hAQ = (ChallengeJinzhuView) this.rootView.findViewById(a.f.rival_jinzhu_2);
        this.hAR = (ChallengeJinzhuView) this.rootView.findViewById(a.f.rival_jinzhu_3);
        this.hAT = (ImageView) this.rootView.findViewById(a.f.rival_user_pk_streak_img);
        this.hAU = (TextView) this.rootView.findViewById(a.f.rival_user_pk_streak_time);
        this.hAX = (LinearLayout) this.rootView.findViewById(a.f.pk_time_layout);
        this.hAY = (TextView) this.rootView.findViewById(a.f.pk_time_label);
        this.hAZ = (RelativeLayout) this.rootView.findViewById(a.f.pk_score_progress_layout);
        this.hBa = (TextView) this.rootView.findViewById(a.f.pk_anchor_progress);
        this.hBb = (TextView) this.rootView.findViewById(a.f.pk_rival_progress);
        this.hBe = (TextView) this.rootView.findViewById(a.f.btn_close_challenge_view);
        this.hBc = this.rootView.findViewById(a.f.anchor_progress_bg);
        this.hBd = this.rootView.findViewById(a.f.rival_progress_bg);
        this.hAV = (AlaChallengeMvpTipView) this.rootView.findViewById(a.f.id_chellenge_mvp_tip);
        this.hAW = (AlaChallengeMvpDynamicAnimView) this.rootView.findViewById(a.f.id_challenge_mvp_anim_view);
        this.hAK.setVisibility(0);
        this.hAK.setBackgroundResource(a.e.sdk_round_host_header_bg);
        this.hAL.setIsRound(true);
        this.hAL.setAutoChangeStyle(false);
        this.hAL.setDefaultBgResource(a.e.sdk_icon_default_avatar100);
        this.hAL.setIsNight(false);
        this.hAK.setOnClickListener(this);
        this.hAN.setOnClickListener(this);
        this.hBe.setOnClickListener(this);
        this.hAF.setVisibility(8);
        this.hAO.setVisibility(8);
        this.hAF.setOnClickListener(this);
        this.hAO.setOnClickListener(this);
    }

    private void updateView() {
        this.hBj = h.bl(this.mContext);
        this.hBi = this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds50);
        this.screenWidth = BdUtilHelper.getScreenDimensions(this.mContext)[0];
        int bo = h.bo(this.mContext);
        int bn = h.bn(this.mContext);
        ViewGroup.LayoutParams layoutParams = this.hAZ.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            layoutParams.height = h.bPp;
            ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = h.bk(this.mContext);
            this.hAZ.setLayoutParams(layoutParams);
        }
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams2.topMargin = this.hBj;
        layoutParams2.height = bn;
        this.hAx.setLayoutParams(layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.hAW.getLayoutParams();
        layoutParams3.topMargin = this.hBj;
        this.hAW.setLayoutParams(layoutParams3);
        ViewGroup.LayoutParams layoutParams4 = this.hAB.getLayoutParams();
        if (layoutParams4 != null) {
            layoutParams4.width = bo;
            layoutParams4.height = bn;
            this.hAB.setLayoutParams(layoutParams4);
        }
        ViewGroup.LayoutParams layoutParams5 = this.hAJ.getLayoutParams();
        if (layoutParams5 != null) {
            layoutParams5.width = bo;
            layoutParams5.height = bn;
            this.hAJ.setLayoutParams(layoutParams5);
        }
        RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(bo, bn);
        layoutParams6.topMargin = this.hBj;
        this.hAz.setLayoutParams(layoutParams6);
        RelativeLayout.LayoutParams layoutParams7 = (RelativeLayout.LayoutParams) this.hAX.getLayoutParams();
        layoutParams7.topMargin = this.hBj;
        layoutParams7.addRule(14);
        this.hAX.setLayoutParams(layoutParams7);
        this.hAZ.setAlpha(0.0f);
        int paddingLeft = (((((bo * 2) - this.hAA.getPaddingLeft()) - this.hAA.getPaddingRight()) - ((getResources().getDimensionPixelOffset(a.d.sdk_ds56) * 3) * 2)) - (getResources().getDimensionPixelOffset(a.d.sdk_ds12) * 4)) - (getResources().getDimensionPixelOffset(a.d.sdk_ds12) * 2);
        ViewGroup.LayoutParams layoutParams8 = this.hAV.getLayoutParams();
        if (layoutParams8 instanceof ViewGroup.MarginLayoutParams) {
            layoutParams8.width = paddingLeft;
            ((ViewGroup.MarginLayoutParams) layoutParams8).bottomMargin = this.hAA.getPaddingBottom();
            this.hAV.setLayoutParams(layoutParams8);
        }
    }

    public View getAnchorAnimLiveLayout() {
        return this.hAy;
    }

    public View getRivalAnimLiveLayout() {
        return this.hAz;
    }

    public void setAnchorUserViewBg(bk bkVar) {
    }

    public void setRivalUserViewBg(bk bkVar) {
    }

    public View getLeftTimeView() {
        return this.hAX;
    }

    public ViewGroup getLiveContainerView() {
        return this.hAx;
    }

    public View getScoreProgressLayout() {
        return this.hAZ;
    }

    public View getJinzhuLayout() {
        return this.hAA;
    }

    public View getCloseBtnView() {
        return this.hBe;
    }

    public RelativeLayout getContainerView() {
        return this.hfF;
    }

    public void a(bg bgVar, bk bkVar, bk bkVar2, boolean z) {
        this.aQg = bkVar;
        this.aQh = bkVar2;
        int i = bgVar.aQk;
        a(bgVar.challengeId, i, bgVar.nowTime, bgVar.stageEndTime);
        d(bgVar.anchorScore, bgVar.rivalScore, z);
        if (z) {
            c(bkVar2);
        }
        if (i == 2) {
            setCloseBtnVisible(true);
            cee();
        } else if (i == 3) {
            boolean z2 = false;
            if (com.baidu.live.ae.a.Qm().bwx != null && com.baidu.live.ae.a.Qm().bwx.aNB == 1) {
                z2 = true;
            }
            if (z2) {
                this.hBe.setText(this.mContext.getResources().getString(a.h.ala_challenge_btn_close_label_2));
            }
            setCloseBtnVisible(z2);
            bS(bgVar.challengeResult, bgVar.aQm);
        } else {
            bTP();
            setCloseBtnVisible(false);
            bS(bgVar.challengeResult, bgVar.aQm);
        }
        a(bkVar.aQx);
        b(bkVar2.aQx);
        this.hBk = bgVar;
    }

    private void a(bf bfVar) {
        ArrayList arrayList;
        if (bfVar == null) {
            this.hAG.setVisibility(8);
            this.hAH.setVisibility(8);
            this.hAI.setVisibility(8);
            return;
        }
        this.hAF.setVisibility(0);
        if (ListUtils.isEmpty(bfVar.aQj)) {
            bfVar.aQj = this.hBn;
        }
        if (ListUtils.isEmpty(bfVar.aQj)) {
            this.hAG.setVisibility(0);
            this.hAH.setVisibility(8);
            this.hAI.setVisibility(8);
            this.hAG.a(true, null, bfVar.liveId);
            return;
        }
        this.hBn = bfVar.aQj;
        this.hAG.setVisibility(8);
        this.hAH.setVisibility(8);
        this.hAI.setVisibility(8);
        if (bfVar.aQj.size() > 3) {
            ArrayList arrayList2 = new ArrayList();
            for (int i = 0; i < 3; i++) {
                arrayList2.add(bfVar.aQj.get(i));
            }
            arrayList = arrayList2;
        } else {
            arrayList = bfVar.aQj;
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            be beVar = arrayList.get(i2);
            if (beVar != null) {
                if (beVar.Cz() || beVar.isFirst()) {
                    this.hAG.setVisibility(0);
                    this.hAG.a(true, beVar, bfVar.liveId);
                } else if (beVar.rank == 2) {
                    this.hAH.setVisibility(0);
                    this.hAH.a(true, beVar, bfVar.liveId);
                } else if (beVar.rank == 3) {
                    this.hAI.setVisibility(0);
                    this.hAI.a(true, beVar, bfVar.liveId);
                }
            }
        }
    }

    private void b(bf bfVar) {
        List<be> list;
        if (bfVar == null) {
            this.hAP.setVisibility(8);
            this.hAQ.setVisibility(8);
            this.hAR.setVisibility(8);
            return;
        }
        this.hAO.setVisibility(0);
        if (ListUtils.isEmpty(bfVar.aQj)) {
            bfVar.aQj = this.hBo;
        }
        if (ListUtils.isEmpty(bfVar.aQj)) {
            this.hAP.setVisibility(0);
            this.hAQ.setVisibility(8);
            this.hAR.setVisibility(8);
            this.hAP.a(false, null, bfVar.liveId);
            return;
        }
        this.hBo = bfVar.aQj;
        this.hAP.setVisibility(8);
        this.hAQ.setVisibility(8);
        this.hAR.setVisibility(8);
        if (bfVar.aQj.size() > 3) {
            list = bfVar.aQj.subList(0, 3);
        } else {
            list = bfVar.aQj;
        }
        for (int i = 0; i < list.size(); i++) {
            be beVar = list.get(i);
            if (beVar != null) {
                if (beVar.Cz() || beVar.isFirst()) {
                    this.hAP.setVisibility(0);
                    this.hAP.a(false, beVar, bfVar.liveId);
                } else if (beVar.rank == 2) {
                    this.hAQ.setVisibility(0);
                    this.hAQ.a(false, beVar, bfVar.liveId);
                } else if (beVar.rank == 3) {
                    this.hAR.setVisibility(0);
                    this.hAR.a(false, beVar, bfVar.liveId);
                }
            }
        }
    }

    private void a(long j, int i, long j2, long j3) {
        if (j3 >= j2 && a(j, i, j3)) {
            bTP();
            if (this.hBk != null) {
                w(this.hBk.aQk, (j3 - j2) * 1000);
            }
            this.gPV = new CountDownTimer((j3 - j2) * 1000, 1000L) { // from class: com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeLiveView.1
                @Override // android.os.CountDownTimer
                public void onTick(long j4) {
                    if (AlaChallengeLiveView.this.hBk != null) {
                        AlaChallengeLiveView.this.w(AlaChallengeLiveView.this.hBk.aQk, j4);
                    }
                }

                @Override // android.os.CountDownTimer
                public void onFinish() {
                    if (AlaChallengeLiveView.this.hBk != null) {
                        AlaChallengeLiveView.this.w(AlaChallengeLiveView.this.hBk.aQk, 0L);
                    }
                }
            };
            this.gPV.start();
        }
    }

    private boolean a(long j, int i, long j2) {
        return (this.hBk != null && this.hBk.challengeId == j && this.hBk.aQk == i && this.hBk.stageEndTime == j2) ? false : true;
    }

    private void bTP() {
        if (this.gPV != null) {
            this.gPV.cancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(int i, long j) {
        if (this.hAY != null) {
            this.hAY.setCompoundDrawables(null, null, null, null);
            String formatSecondsTime = StringHelper.formatSecondsTime(Math.round(j / 1000.0d));
            String string = this.mContext.getString(a.h.ala_challenge_operate_challenge_time, formatSecondsTime);
            if (i == 2) {
                Drawable drawable = getResources().getDrawable(a.e.icon_challenge_timer_countdown);
                drawable.setBounds(0, 0, getResources().getDimensionPixelOffset(a.d.sdk_ds40), getResources().getDimensionPixelOffset(a.d.sdk_ds40));
                this.hAY.setCompoundDrawablePadding(getResources().getDimensionPixelOffset(a.d.sdk_ds8));
                this.hAY.setCompoundDrawables(drawable, null, null, null);
            } else if (i == 3) {
                formatSecondsTime = this.mContext.getString(a.h.ala_challenge_operate_publish_time, formatSecondsTime);
            } else {
                formatSecondsTime = i == 4 ? this.mContext.getString(a.h.ala_challenge_operate_over_time) : string;
            }
            this.hAY.setText(formatSecondsTime);
        }
    }

    public void setLiveContainerVisible(boolean z) {
        this.hAx.setVisibility(z ? 0 : 4);
    }

    public void setCloseBtnVisible(boolean z) {
        if (this.isHost) {
            this.hBe.setVisibility(z ? 0 : 4);
        } else {
            this.hBe.setVisibility(4);
        }
    }

    public void ced() {
        setCloseBtnVisible(false);
        this.hBe.setText(this.mContext.getResources().getString(a.h.ala_challenge_btn_close_label));
        this.hAV.FS();
        this.hAW.ceo();
        setLiveContainerVisible(false);
        if (this.hBn != null) {
            this.hBn.clear();
            this.hBn = null;
        }
        if (this.hBo != null) {
            this.hBo.clear();
            this.hBo = null;
        }
        this.hBk = null;
    }

    public void bS(int i, int i2) {
        this.hAC.setVisibility(0);
        this.hAS.setVisibility(0);
        this.hAE.setVisibility(4);
        this.hAU.setVisibility(4);
        if (1 == i) {
            this.hAD.setImageResource(a.e.icon_live_vs_win);
            if (i2 >= 2) {
                this.hAE.setVisibility(0);
                this.hAE.setText(this.mContext.getResources().getString(a.h.ala_challenge_streak_win_label, Integer.valueOf(i2)));
            } else {
                this.hAE.setText("");
            }
            this.hAT.setImageResource(a.e.icon_live_vs_lose);
        } else if (3 == i) {
            this.hAD.setImageResource(a.e.icon_live_vs_draw);
            this.hAT.setImageResource(a.e.icon_live_vs_draw);
        } else if (2 == i) {
            this.hAD.setImageResource(a.e.icon_live_vs_lose);
            if (i2 >= 2) {
                this.hAU.setVisibility(0);
                this.hAU.setText(this.mContext.getResources().getString(a.h.ala_challenge_streak_win_label, Integer.valueOf(i2)));
            } else {
                this.hAU.setText("");
            }
            this.hAT.setImageResource(a.e.icon_live_vs_win);
        } else {
            cee();
        }
    }

    public void cee() {
        this.hAC.setVisibility(4);
        this.hAS.setVisibility(4);
    }

    public void cef() {
        if (this.hBn != null) {
            this.hBn.clear();
            this.hBn = null;
        }
        if (this.hBo != null) {
            this.hBo.clear();
            this.hBo = null;
        }
    }

    private ValueAnimator cq(final View view) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 0.33f, 0.66f, 1.0f, 1.3f, 1.0f);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeLiveView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                view.setScaleX(floatValue);
                view.setScaleY(floatValue);
                view.setAlpha(valueAnimator.getAnimatedFraction());
            }
        });
        ofFloat.setDuration(600L);
        return ofFloat;
    }

    public void ceg() {
        this.hBa.setText(String.valueOf(this.hBg));
        this.hBb.setText(String.valueOf(this.hBh));
        if (this.hBm != null) {
            this.hBm.cancel();
        }
        this.hBm = new AnimatorSet();
        ValueAnimator cq = cq(this.hBa);
        ValueAnimator cq2 = cq(this.hBb);
        if (this.hBg != this.hBh) {
            this.hBm.setStartDelay(500L);
        } else {
            this.hBm.setStartDelay(200L);
        }
        this.hBm.playTogether(cq, cq2);
        this.hBm.start();
    }

    public void ceh() {
        this.hBa.setAlpha(0.0f);
        this.hBb.setAlpha(0.0f);
        this.hBa.setText("");
        this.hBb.setText("");
    }

    private void d(long j, long j2, boolean z) {
        int i;
        if (z || this.hBg != j || this.hBh != j2) {
            this.hBg = j;
            this.hBh = j2;
            if (z) {
                ceh();
            } else {
                this.hBa.setText(String.valueOf(this.hBg));
                this.hBb.setText(String.valueOf(this.hBh));
            }
            float f = (float) (this.hBg + this.hBh);
            int i2 = this.screenWidth;
            int i3 = i2 / 2;
            if (z && f != 0.0f) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hBc.getLayoutParams();
                layoutParams.width = i3;
                this.hBc.setLayoutParams(layoutParams);
            }
            if (this.hBg != this.hBh && f > 0.0f) {
                int i4 = (int) ((((float) this.hBg) / f) * i2);
                int i5 = !z ? ((LinearLayout.LayoutParams) this.hBc.getLayoutParams()).width : i3;
                if (i4 < this.hBi) {
                    i = this.hBi;
                } else {
                    i = i4 > i2 - this.hBi ? i2 - this.hBi : i4;
                }
                if (this.hBl != null) {
                    this.hBl.cancel();
                }
                this.hBl = ValueAnimator.ofInt(i5, i);
                if (z) {
                    this.hBl.setDuration(300L);
                    this.hBl.setStartDelay(200L);
                } else {
                    this.hBl.setDuration(100L);
                }
                this.hBl.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeLiveView.3
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) AlaChallengeLiveView.this.hBc.getLayoutParams();
                        layoutParams2.width = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                        AlaChallengeLiveView.this.hBc.setLayoutParams(layoutParams2);
                    }
                });
                this.hBl.start();
                return;
            }
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.hBc.getLayoutParams();
            layoutParams2.width = i3;
            this.hBc.setLayoutParams(layoutParams2);
        }
    }

    public void c(bk bkVar) {
        if (bkVar == null || bkVar.aQi == null) {
            this.hAK.setVisibility(4);
            return;
        }
        this.hAK.setTag(bkVar);
        this.hAL.startLoad(bkVar.aQi.portrait, 12, false, false);
        String str = bkVar.aQi.userName;
        if (TextHelper.getTextLengthWithEmoji(str) > 8) {
            str = TextHelper.subStringWithEmoji(str, 8) + StringHelper.STRING_MORE;
        }
        this.hAM.setText(str);
        this.hAN.setVisibility(8);
    }

    public void od(boolean z) {
        if (this.hAN != null) {
            this.hAN.setVisibility(z ? 8 : 0);
        }
    }

    public View getRivalUserInfoView() {
        return this.hAK;
    }

    public void releaseResource() {
        bTP();
        if (this.hBl != null) {
            this.hBl.cancel();
        }
        if (this.hBm != null) {
            this.hBm.cancel();
        }
        ceh();
        this.hAX.setAlpha(0.0f);
        this.hBe.setText(this.mContext.getResources().getString(a.h.ala_challenge_btn_close_label));
        this.hAV.FS();
        this.hAW.ceo();
        this.hBk = null;
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z = true;
        if (view == this.hBe) {
            if (this.hBf != null) {
                if (com.baidu.live.ae.a.Qm().bwx == null || this.hBk == null || this.hBk.aQk != 3 || com.baidu.live.ae.a.Qm().bwx.aNB != 1) {
                    z = false;
                }
                if (z) {
                    if (this.hBk != null) {
                        this.hBf.a(this.hBk.aQp);
                        return;
                    }
                    return;
                }
                this.hBf.cei();
            }
        } else if (view == this.hAK) {
            if (this.hBf != null) {
                if (this.hBp) {
                    this.hBf.cej();
                } else {
                    this.hBf.d((bk) this.hAK.getTag());
                }
            }
        } else if (view == this.hAN) {
            if (this.hBf != null) {
                if (this.hBp) {
                    this.hBf.cej();
                } else {
                    this.hBf.e((bk) this.hAK.getTag());
                }
            }
        } else if (view == this.hAJ) {
            if (this.hBf != null) {
                if (this.hBp) {
                    this.hBf.cej();
                } else {
                    this.hBf.f(this.aQh);
                }
            }
        } else if (view == this.hAF) {
            this.hBf.oe(false);
        } else if (view == this.hAO) {
            this.hBf.oe(true);
        }
    }

    public void setViewClickCallBack(a aVar) {
        this.hBf = aVar;
    }
}
