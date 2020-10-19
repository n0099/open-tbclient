package com.baidu.tieba.ala.liveroom.challenge.view;

import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.as;
import com.baidu.live.data.at;
import com.baidu.live.data.au;
import com.baidu.live.data.ay;
import com.baidu.live.data.bq;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.util.TextHelper;
import com.baidu.live.utils.h;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class AlaChallengeLiveView extends RelativeLayout implements View.OnClickListener {
    private ay aML;
    private ay aMM;
    private RelativeLayout gLR;
    private RelativeLayout gLS;
    private RelativeLayout gLT;
    private RelativeLayout gLU;
    private RelativeLayout gLV;
    private RelativeLayout gLW;
    private RelativeLayout gLX;
    private ImageView gLY;
    private TextView gLZ;
    private a gMA;
    private long gMB;
    private long gMC;
    private int gMD;
    private int gME;
    private au gMF;
    private ValueAnimator gMG;
    private AnimatorSet gMH;
    private List<as> gMI;
    private List<as> gMJ;
    public boolean gMK;
    private LinearLayout gMa;
    private ChallengeJinzhuView gMb;
    private ChallengeJinzhuView gMc;
    private ChallengeJinzhuView gMd;
    private RelativeLayout gMe;
    private RelativeLayout gMf;
    private HeadImageView gMg;
    private TextView gMh;
    private ImageView gMi;
    private LinearLayout gMj;
    private ChallengeJinzhuView gMk;
    private ChallengeJinzhuView gMl;
    private ChallengeJinzhuView gMm;
    private RelativeLayout gMn;
    private ImageView gMo;
    private TextView gMp;
    private AlaChallengeMvpTipView gMq;
    private AlaChallengeMvpDynamicAnimView gMr;
    private LinearLayout gMs;
    private TextView gMt;
    private RelativeLayout gMu;
    private TextView gMv;
    private TextView gMw;
    private View gMx;
    private View gMy;
    private TextView gMz;
    private CountDownTimer gge;
    private boolean isHost;
    private Context mContext;
    private Handler mHandler;
    private RelativeLayout rootView;
    private int screenWidth;

    /* loaded from: classes4.dex */
    public interface a {
        void a(bq bqVar);

        void bVl();

        void bVm();

        void d(ay ayVar);

        void e(ay ayVar);

        void f(ay ayVar);

        void mC(boolean z);
    }

    public AlaChallengeLiveView(Context context) {
        super(context);
        this.isHost = false;
        this.gMB = -1L;
        this.gMC = -1L;
        this.screenWidth = -1;
        this.gMD = 0;
        this.gME = 0;
        this.gMK = false;
        init(context);
    }

    public AlaChallengeLiveView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isHost = false;
        this.gMB = -1L;
        this.gMC = -1L;
        this.screenWidth = -1;
        this.gMD = 0;
        this.gME = 0;
        this.gMK = false;
        init(context);
    }

    public AlaChallengeLiveView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isHost = false;
        this.gMB = -1L;
        this.gMC = -1L;
        this.screenWidth = -1;
        this.gMD = 0;
        this.gME = 0;
        this.gMK = false;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.mHandler = new Handler(Looper.getMainLooper());
        dQ(context);
        updateView();
    }

    public void setNeedCloseRecommendFloat(boolean z) {
        this.gMK = z;
        this.gMb.setNeedCloseRecommendFloat(this.gMK);
        this.gMc.setNeedCloseRecommendFloat(this.gMK);
        this.gMd.setNeedCloseRecommendFloat(this.gMK);
        this.gMk.setNeedCloseRecommendFloat(this.gMK);
        this.gMl.setNeedCloseRecommendFloat(this.gMK);
        this.gMm.setNeedCloseRecommendFloat(this.gMK);
    }

    public void setIsHost(boolean z) {
        this.isHost = z;
    }

    private void dQ(Context context) {
        this.rootView = (RelativeLayout) View.inflate(context, a.h.ala_challenge_panel_optation_view, this);
        this.gLR = (RelativeLayout) this.rootView.findViewById(a.g.root_container);
        this.gLT = (RelativeLayout) this.rootView.findViewById(a.g.anchor_live_anim_layout);
        this.gLU = (RelativeLayout) this.rootView.findViewById(a.g.rival_live_anim_layout);
        this.gLS = (RelativeLayout) this.rootView.findViewById(a.g.pk_live_container);
        this.gLW = (RelativeLayout) this.rootView.findViewById(a.g.pk_anchor_live_layout);
        this.gLX = (RelativeLayout) this.rootView.findViewById(a.g.anchor_streak_win_layout);
        this.gLY = (ImageView) this.rootView.findViewById(a.g.anchor_user_pk_streak_img);
        this.gLZ = (TextView) this.rootView.findViewById(a.g.anchor_user_pk_streak_time);
        this.gLV = (RelativeLayout) this.rootView.findViewById(a.g.jinzhu_container);
        this.gMa = (LinearLayout) this.rootView.findViewById(a.g.anchor_jinzhu_layout);
        this.gMb = (ChallengeJinzhuView) this.rootView.findViewById(a.g.anchor_jinzhu_1);
        this.gMc = (ChallengeJinzhuView) this.rootView.findViewById(a.g.anchor_jinzhu_2);
        this.gMd = (ChallengeJinzhuView) this.rootView.findViewById(a.g.anchor_jinzhu_3);
        this.gMe = (RelativeLayout) this.rootView.findViewById(a.g.pk_rival_live_layout);
        this.gMf = (RelativeLayout) this.rootView.findViewById(a.g.pk_rival_user_layout);
        this.gMg = (HeadImageView) this.rootView.findViewById(a.g.ala_live_rival_user_image);
        this.gMh = (TextView) this.rootView.findViewById(a.g.ala_live_rival_user_name);
        this.gMi = (ImageView) this.rootView.findViewById(a.g.iv_rival_user_follow);
        this.gMn = (RelativeLayout) this.rootView.findViewById(a.g.rival_streak_win_layout);
        this.gMj = (LinearLayout) this.rootView.findViewById(a.g.rival_jinzhu_layout);
        this.gMk = (ChallengeJinzhuView) this.rootView.findViewById(a.g.rival_jinzhu_1);
        this.gMl = (ChallengeJinzhuView) this.rootView.findViewById(a.g.rival_jinzhu_2);
        this.gMm = (ChallengeJinzhuView) this.rootView.findViewById(a.g.rival_jinzhu_3);
        this.gMo = (ImageView) this.rootView.findViewById(a.g.rival_user_pk_streak_img);
        this.gMp = (TextView) this.rootView.findViewById(a.g.rival_user_pk_streak_time);
        this.gMs = (LinearLayout) this.rootView.findViewById(a.g.pk_time_layout);
        this.gMt = (TextView) this.rootView.findViewById(a.g.pk_time_label);
        this.gMu = (RelativeLayout) this.rootView.findViewById(a.g.pk_score_progress_layout);
        this.gMv = (TextView) this.rootView.findViewById(a.g.pk_anchor_progress);
        this.gMw = (TextView) this.rootView.findViewById(a.g.pk_rival_progress);
        this.gMz = (TextView) this.rootView.findViewById(a.g.btn_close_challenge_view);
        this.gMx = this.rootView.findViewById(a.g.anchor_progress_bg);
        this.gMy = this.rootView.findViewById(a.g.rival_progress_bg);
        this.gMq = (AlaChallengeMvpTipView) this.rootView.findViewById(a.g.id_chellenge_mvp_tip);
        this.gMr = (AlaChallengeMvpDynamicAnimView) this.rootView.findViewById(a.g.id_challenge_mvp_anim_view);
        this.gMf.setVisibility(0);
        this.gMf.setBackgroundResource(a.f.sdk_round_host_header_bg);
        this.gMg.setIsRound(true);
        this.gMg.setAutoChangeStyle(false);
        this.gMg.setDefaultBgResource(a.f.sdk_icon_default_avatar100_bg);
        this.gMg.setIsNight(false);
        this.gMf.setOnClickListener(this);
        this.gMi.setOnClickListener(this);
        this.gMz.setOnClickListener(this);
        this.gMa.setVisibility(8);
        this.gMj.setVisibility(8);
        this.gMa.setOnClickListener(this);
        this.gMj.setOnClickListener(this);
    }

    private void updateView() {
        this.gME = h.aC(this.mContext);
        this.gMD = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds50);
        this.screenWidth = BdUtilHelper.getScreenDimensions(this.mContext)[0];
        int aF = h.aF(this.mContext);
        int aE = h.aE(this.mContext);
        ViewGroup.LayoutParams layoutParams = this.gMu.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            layoutParams.height = h.bxt;
            ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = h.aB(this.mContext);
            this.gMu.setLayoutParams(layoutParams);
        }
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams2.topMargin = this.gME;
        layoutParams2.height = aE;
        this.gLS.setLayoutParams(layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.gMr.getLayoutParams();
        layoutParams3.topMargin = this.gME;
        this.gMr.setLayoutParams(layoutParams3);
        ViewGroup.LayoutParams layoutParams4 = this.gLW.getLayoutParams();
        if (layoutParams4 != null) {
            layoutParams4.width = aF;
            layoutParams4.height = aE;
            this.gLW.setLayoutParams(layoutParams4);
        }
        ViewGroup.LayoutParams layoutParams5 = this.gMe.getLayoutParams();
        if (layoutParams5 != null) {
            layoutParams5.width = aF;
            layoutParams5.height = aE;
            this.gMe.setLayoutParams(layoutParams5);
        }
        RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(aF, aE);
        layoutParams6.topMargin = this.gME;
        this.gLU.setLayoutParams(layoutParams6);
        RelativeLayout.LayoutParams layoutParams7 = (RelativeLayout.LayoutParams) this.gMs.getLayoutParams();
        layoutParams7.topMargin = this.gME;
        layoutParams7.addRule(14);
        this.gMs.setLayoutParams(layoutParams7);
        this.gMu.setAlpha(0.0f);
        int paddingLeft = (((((aF * 2) - this.gLV.getPaddingLeft()) - this.gLV.getPaddingRight()) - ((getResources().getDimensionPixelOffset(a.e.sdk_ds56) * 3) * 2)) - (getResources().getDimensionPixelOffset(a.e.sdk_ds12) * 4)) - (getResources().getDimensionPixelOffset(a.e.sdk_ds12) * 2);
        ViewGroup.LayoutParams layoutParams8 = this.gMq.getLayoutParams();
        if (layoutParams8 instanceof ViewGroup.MarginLayoutParams) {
            layoutParams8.width = paddingLeft;
            ((ViewGroup.MarginLayoutParams) layoutParams8).bottomMargin = this.gLV.getPaddingBottom();
            this.gMq.setLayoutParams(layoutParams8);
        }
    }

    public View getAnchorAnimLiveLayout() {
        return this.gLT;
    }

    public View getRivalAnimLiveLayout() {
        return this.gLU;
    }

    public void setAnchorUserViewBg(ay ayVar) {
    }

    public void setRivalUserViewBg(ay ayVar) {
    }

    public View getLeftTimeView() {
        return this.gMs;
    }

    public ViewGroup getLiveContainerView() {
        return this.gLS;
    }

    public View getScoreProgressLayout() {
        return this.gMu;
    }

    public View getJinzhuLayout() {
        return this.gLV;
    }

    public View getCloseBtnView() {
        return this.gMz;
    }

    public RelativeLayout getContainerView() {
        return this.gLR;
    }

    public void a(au auVar, ay ayVar, ay ayVar2, boolean z) {
        this.aML = ayVar;
        this.aMM = ayVar2;
        int i = auVar.aMP;
        a(auVar.challengeId, i, auVar.nowTime, auVar.stageEndTime);
        c(auVar.anchorScore, auVar.rivalScore, z);
        if (z) {
            c(ayVar2);
        }
        if (i == 2) {
            setCloseBtnVisible(true);
            bVh();
        } else if (i == 3) {
            boolean z2 = false;
            if (com.baidu.live.x.a.OS().blo != null && com.baidu.live.x.a.OS().blo.aKO == 1) {
                z2 = true;
            }
            if (z2) {
                this.gMz.setText(this.mContext.getResources().getString(a.i.ala_challenge_btn_close_label_2));
            }
            setCloseBtnVisible(z2);
            bN(auVar.challengeResult, auVar.aMR);
        } else {
            bMg();
            setCloseBtnVisible(false);
            bN(auVar.challengeResult, auVar.aMR);
        }
        a(ayVar.aNc);
        b(ayVar2.aNc);
        this.gMF = auVar;
    }

    private void a(at atVar) {
        ArrayList arrayList;
        if (atVar == null) {
            this.gMb.setVisibility(8);
            this.gMc.setVisibility(8);
            this.gMd.setVisibility(8);
            return;
        }
        this.gMa.setVisibility(0);
        if (ListUtils.isEmpty(atVar.aMO)) {
            atVar.aMO = this.gMI;
        }
        if (ListUtils.isEmpty(atVar.aMO)) {
            this.gMb.setVisibility(0);
            this.gMc.setVisibility(8);
            this.gMd.setVisibility(8);
            this.gMb.a(true, null, atVar.liveId);
            return;
        }
        this.gMI = atVar.aMO;
        this.gMb.setVisibility(8);
        this.gMc.setVisibility(8);
        this.gMd.setVisibility(8);
        if (atVar.aMO.size() > 3) {
            ArrayList arrayList2 = new ArrayList();
            for (int i = 0; i < 3; i++) {
                arrayList2.add(atVar.aMO.get(i));
            }
            arrayList = arrayList2;
        } else {
            arrayList = atVar.aMO;
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            as asVar = arrayList.get(i2);
            if (asVar != null) {
                if (asVar.Eg() || asVar.isFirst()) {
                    this.gMb.setVisibility(0);
                    this.gMb.a(true, asVar, atVar.liveId);
                } else if (asVar.rank == 2) {
                    this.gMc.setVisibility(0);
                    this.gMc.a(true, asVar, atVar.liveId);
                } else if (asVar.rank == 3) {
                    this.gMd.setVisibility(0);
                    this.gMd.a(true, asVar, atVar.liveId);
                }
            }
        }
    }

    private void b(at atVar) {
        List<as> list;
        if (atVar == null) {
            this.gMk.setVisibility(8);
            this.gMl.setVisibility(8);
            this.gMm.setVisibility(8);
            return;
        }
        this.gMj.setVisibility(0);
        if (ListUtils.isEmpty(atVar.aMO)) {
            atVar.aMO = this.gMJ;
        }
        if (ListUtils.isEmpty(atVar.aMO)) {
            this.gMk.setVisibility(0);
            this.gMl.setVisibility(8);
            this.gMm.setVisibility(8);
            this.gMk.a(false, null, atVar.liveId);
            return;
        }
        this.gMJ = atVar.aMO;
        this.gMk.setVisibility(8);
        this.gMl.setVisibility(8);
        this.gMm.setVisibility(8);
        if (atVar.aMO.size() > 3) {
            list = atVar.aMO.subList(0, 3);
        } else {
            list = atVar.aMO;
        }
        for (int i = 0; i < list.size(); i++) {
            as asVar = list.get(i);
            if (asVar != null) {
                if (asVar.Eg() || asVar.isFirst()) {
                    this.gMk.setVisibility(0);
                    this.gMk.a(false, asVar, atVar.liveId);
                } else if (asVar.rank == 2) {
                    this.gMl.setVisibility(0);
                    this.gMl.a(false, asVar, atVar.liveId);
                } else if (asVar.rank == 3) {
                    this.gMm.setVisibility(0);
                    this.gMm.a(false, asVar, atVar.liveId);
                }
            }
        }
    }

    private void a(long j, int i, long j2, long j3) {
        if (j3 >= j2 && a(j, i, j3)) {
            bMg();
            if (this.gMF != null) {
                w(this.gMF.aMP, (j3 - j2) * 1000);
            }
            this.gge = new CountDownTimer((j3 - j2) * 1000, 1000L) { // from class: com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeLiveView.1
                @Override // android.os.CountDownTimer
                public void onTick(long j4) {
                    if (AlaChallengeLiveView.this.gMF != null) {
                        AlaChallengeLiveView.this.w(AlaChallengeLiveView.this.gMF.aMP, j4);
                    }
                }

                @Override // android.os.CountDownTimer
                public void onFinish() {
                    if (AlaChallengeLiveView.this.gMF != null) {
                        AlaChallengeLiveView.this.w(AlaChallengeLiveView.this.gMF.aMP, 0L);
                    }
                }
            };
            this.gge.start();
        }
    }

    private boolean a(long j, int i, long j2) {
        return (this.gMF != null && this.gMF.challengeId == j && this.gMF.aMP == i && this.gMF.stageEndTime == j2) ? false : true;
    }

    private void bMg() {
        if (this.gge != null) {
            this.gge.cancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(int i, long j) {
        if (this.gMt != null) {
            this.gMt.setCompoundDrawables(null, null, null, null);
            String formatSecondsTime = StringHelper.formatSecondsTime(Math.round(j / 1000.0d));
            String string = this.mContext.getString(a.i.ala_challenge_operate_challenge_time, formatSecondsTime);
            if (i == 2) {
                Drawable drawable = getResources().getDrawable(a.f.icon_challenge_timer_countdown);
                drawable.setBounds(0, 0, getResources().getDimensionPixelOffset(a.e.sdk_ds40), getResources().getDimensionPixelOffset(a.e.sdk_ds40));
                this.gMt.setCompoundDrawablePadding(getResources().getDimensionPixelOffset(a.e.sdk_ds8));
                this.gMt.setCompoundDrawables(drawable, null, null, null);
            } else if (i == 3) {
                formatSecondsTime = this.mContext.getString(a.i.ala_challenge_operate_publish_time, formatSecondsTime);
            } else {
                formatSecondsTime = i == 4 ? this.mContext.getString(a.i.ala_challenge_operate_over_time) : string;
            }
            this.gMt.setText(formatSecondsTime);
        }
    }

    public void setLiveContainerVisible(boolean z) {
        this.gLS.setVisibility(z ? 0 : 4);
    }

    public void setCloseBtnVisible(boolean z) {
        if (this.isHost) {
            this.gMz.setVisibility(z ? 0 : 4);
        } else {
            this.gMz.setVisibility(4);
        }
    }

    public void bVg() {
        setCloseBtnVisible(false);
        this.gMz.setText(this.mContext.getResources().getString(a.i.ala_challenge_btn_close_label));
        this.gMq.GP();
        this.gMr.bVr();
        setLiveContainerVisible(false);
        if (this.gMI != null) {
            this.gMI.clear();
            this.gMI = null;
        }
        if (this.gMJ != null) {
            this.gMJ.clear();
            this.gMJ = null;
        }
        this.gMF = null;
    }

    public void bN(int i, int i2) {
        this.gLX.setVisibility(0);
        this.gMn.setVisibility(0);
        this.gLZ.setVisibility(4);
        this.gMp.setVisibility(4);
        if (1 == i) {
            this.gLY.setImageResource(a.f.icon_live_vs_win);
            if (i2 >= 2) {
                this.gLZ.setVisibility(0);
                this.gLZ.setText(this.mContext.getResources().getString(a.i.ala_challenge_streak_win_label, Integer.valueOf(i2)));
            } else {
                this.gLZ.setText("");
            }
            this.gMo.setImageResource(a.f.icon_live_vs_lose);
        } else if (3 == i) {
            this.gLY.setImageResource(a.f.icon_live_vs_draw);
            this.gMo.setImageResource(a.f.icon_live_vs_draw);
        } else if (2 == i) {
            this.gLY.setImageResource(a.f.icon_live_vs_lose);
            if (i2 >= 2) {
                this.gMp.setVisibility(0);
                this.gMp.setText(this.mContext.getResources().getString(a.i.ala_challenge_streak_win_label, Integer.valueOf(i2)));
            } else {
                this.gMp.setText("");
            }
            this.gMo.setImageResource(a.f.icon_live_vs_win);
        } else {
            bVh();
        }
    }

    public void bVh() {
        this.gLX.setVisibility(4);
        this.gMn.setVisibility(4);
    }

    public void bVi() {
        if (this.gMI != null) {
            this.gMI.clear();
            this.gMI = null;
        }
        if (this.gMJ != null) {
            this.gMJ.clear();
            this.gMJ = null;
        }
    }

    private ValueAnimator bT(final View view) {
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

    public void bVj() {
        this.gMv.setText(String.valueOf(this.gMB));
        this.gMw.setText(String.valueOf(this.gMC));
        if (this.gMH != null) {
            this.gMH.cancel();
        }
        this.gMH = new AnimatorSet();
        ValueAnimator bT = bT(this.gMv);
        ValueAnimator bT2 = bT(this.gMw);
        if (this.gMB != this.gMC) {
            this.gMH.setStartDelay(500L);
        } else {
            this.gMH.setStartDelay(200L);
        }
        this.gMH.playTogether(bT, bT2);
        this.gMH.start();
    }

    public void bVk() {
        this.gMv.setAlpha(0.0f);
        this.gMw.setAlpha(0.0f);
        this.gMv.setText("");
        this.gMw.setText("");
    }

    private void c(long j, long j2, boolean z) {
        int i;
        if (z || this.gMB != j || this.gMC != j2) {
            this.gMB = j;
            this.gMC = j2;
            if (z) {
                bVk();
            } else {
                this.gMv.setText(String.valueOf(this.gMB));
                this.gMw.setText(String.valueOf(this.gMC));
            }
            float f = (float) (this.gMB + this.gMC);
            int i2 = this.screenWidth;
            int i3 = i2 / 2;
            if (z && f != 0.0f) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gMx.getLayoutParams();
                layoutParams.width = i3;
                this.gMx.setLayoutParams(layoutParams);
            }
            if (this.gMB != this.gMC && f > 0.0f) {
                int i4 = (int) ((((float) this.gMB) / f) * i2);
                int i5 = !z ? ((LinearLayout.LayoutParams) this.gMx.getLayoutParams()).width : i3;
                if (i4 < this.gMD) {
                    i = this.gMD;
                } else {
                    i = i4 > i2 - this.gMD ? i2 - this.gMD : i4;
                }
                if (this.gMG != null) {
                    this.gMG.cancel();
                }
                this.gMG = ValueAnimator.ofInt(i5, i);
                if (z) {
                    this.gMG.setDuration(300L);
                    this.gMG.setStartDelay(200L);
                } else {
                    this.gMG.setDuration(100L);
                }
                this.gMG.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeLiveView.3
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) AlaChallengeLiveView.this.gMx.getLayoutParams();
                        layoutParams2.width = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                        AlaChallengeLiveView.this.gMx.setLayoutParams(layoutParams2);
                    }
                });
                this.gMG.start();
                return;
            }
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.gMx.getLayoutParams();
            layoutParams2.width = i3;
            this.gMx.setLayoutParams(layoutParams2);
        }
    }

    public void c(ay ayVar) {
        if (ayVar == null || ayVar.aMN == null) {
            this.gMf.setVisibility(4);
            return;
        }
        this.gMf.setTag(ayVar);
        this.gMg.startLoad(ayVar.aMN.portrait, 12, false, false);
        String str = ayVar.aMN.userName;
        if (TextHelper.getTextLengthWithEmoji(str) > 8) {
            str = TextHelper.subStringWithEmoji(str, 8) + StringHelper.STRING_MORE;
        }
        this.gMh.setText(str);
        this.gMi.setVisibility(8);
    }

    public void mB(boolean z) {
        if (this.gMi != null) {
            this.gMi.setVisibility(z ? 8 : 0);
        }
    }

    public View getRivalUserInfoView() {
        return this.gMf;
    }

    public void releaseResource() {
        bMg();
        if (this.gMG != null) {
            this.gMG.cancel();
        }
        if (this.gMH != null) {
            this.gMH.cancel();
        }
        bVk();
        this.gMs.setAlpha(0.0f);
        this.gMz.setText(this.mContext.getResources().getString(a.i.ala_challenge_btn_close_label));
        this.gMq.GP();
        this.gMr.bVr();
        this.gMF = null;
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z = true;
        if (view == this.gMz) {
            if (this.gMA != null) {
                if (com.baidu.live.x.a.OS().blo == null || this.gMF == null || this.gMF.aMP != 3 || com.baidu.live.x.a.OS().blo.aKO != 1) {
                    z = false;
                }
                if (z) {
                    if (this.gMF != null) {
                        this.gMA.a(this.gMF.aMU);
                        return;
                    }
                    return;
                }
                this.gMA.bVl();
            }
        } else if (view == this.gMf) {
            if (this.gMA != null) {
                if (this.gMK) {
                    this.gMA.bVm();
                } else {
                    this.gMA.d((ay) this.gMf.getTag());
                }
            }
        } else if (view == this.gMi) {
            if (this.gMA != null) {
                if (this.gMK) {
                    this.gMA.bVm();
                } else {
                    this.gMA.e((ay) this.gMf.getTag());
                }
            }
        } else if (view == this.gMe) {
            if (this.gMA != null) {
                if (this.gMK) {
                    this.gMA.bVm();
                } else {
                    this.gMA.f(this.aMM);
                }
            }
        } else if (view == this.gMa) {
            this.gMA.mC(false);
        } else if (view == this.gMj) {
            this.gMA.mC(true);
        }
    }

    public void setViewClickCallBack(a aVar) {
        this.gMA = aVar;
    }
}
