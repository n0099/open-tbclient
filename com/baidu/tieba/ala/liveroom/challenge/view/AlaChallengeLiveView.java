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
    private ay aJG;
    private ay aJH;
    private CountDownTimer fTL;
    private RelativeLayout gxA;
    private RelativeLayout gxB;
    private RelativeLayout gxC;
    private RelativeLayout gxD;
    private RelativeLayout gxE;
    private ImageView gxF;
    private TextView gxG;
    private LinearLayout gxH;
    private ChallengeJinzhuView gxI;
    private ChallengeJinzhuView gxJ;
    private ChallengeJinzhuView gxK;
    private RelativeLayout gxL;
    private RelativeLayout gxM;
    private HeadImageView gxN;
    private TextView gxO;
    private ImageView gxP;
    private LinearLayout gxQ;
    private ChallengeJinzhuView gxR;
    private ChallengeJinzhuView gxS;
    private ChallengeJinzhuView gxT;
    private RelativeLayout gxU;
    private ImageView gxV;
    private TextView gxW;
    private AlaChallengeMvpTipView gxX;
    private AlaChallengeMvpDynamicAnimView gxY;
    private LinearLayout gxZ;
    private RelativeLayout gxy;
    private RelativeLayout gxz;
    private TextView gya;
    private RelativeLayout gyb;
    private TextView gyc;
    private TextView gyd;
    private View gye;
    private View gyf;
    private TextView gyg;
    private a gyh;
    private long gyi;
    private long gyj;
    private int gyk;
    private int gyl;
    private au gym;
    private ValueAnimator gyn;
    private AnimatorSet gyo;
    private List<as> gyp;
    private List<as> gyq;
    public boolean gyr;
    private boolean isHost;
    private Context mContext;
    private Handler mHandler;
    private RelativeLayout rootView;
    private int screenWidth;

    /* loaded from: classes4.dex */
    public interface a {
        void a(bq bqVar);

        void bRR();

        void bRS();

        void d(ay ayVar);

        void e(ay ayVar);

        void f(ay ayVar);

        void ma(boolean z);
    }

    public AlaChallengeLiveView(Context context) {
        super(context);
        this.isHost = false;
        this.gyi = -1L;
        this.gyj = -1L;
        this.screenWidth = -1;
        this.gyk = 0;
        this.gyl = 0;
        this.gyr = false;
        init(context);
    }

    public AlaChallengeLiveView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isHost = false;
        this.gyi = -1L;
        this.gyj = -1L;
        this.screenWidth = -1;
        this.gyk = 0;
        this.gyl = 0;
        this.gyr = false;
        init(context);
    }

    public AlaChallengeLiveView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isHost = false;
        this.gyi = -1L;
        this.gyj = -1L;
        this.screenWidth = -1;
        this.gyk = 0;
        this.gyl = 0;
        this.gyr = false;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.mHandler = new Handler(Looper.getMainLooper());
        dK(context);
        updateView();
    }

    public void setNeedCloseRecommendFloat(boolean z) {
        this.gyr = z;
        this.gxI.setNeedCloseRecommendFloat(this.gyr);
        this.gxJ.setNeedCloseRecommendFloat(this.gyr);
        this.gxK.setNeedCloseRecommendFloat(this.gyr);
        this.gxR.setNeedCloseRecommendFloat(this.gyr);
        this.gxS.setNeedCloseRecommendFloat(this.gyr);
        this.gxT.setNeedCloseRecommendFloat(this.gyr);
    }

    public void setIsHost(boolean z) {
        this.isHost = z;
    }

    private void dK(Context context) {
        this.rootView = (RelativeLayout) View.inflate(context, a.h.ala_challenge_panel_optation_view, this);
        this.gxy = (RelativeLayout) this.rootView.findViewById(a.g.root_container);
        this.gxA = (RelativeLayout) this.rootView.findViewById(a.g.anchor_live_anim_layout);
        this.gxB = (RelativeLayout) this.rootView.findViewById(a.g.rival_live_anim_layout);
        this.gxz = (RelativeLayout) this.rootView.findViewById(a.g.pk_live_container);
        this.gxD = (RelativeLayout) this.rootView.findViewById(a.g.pk_anchor_live_layout);
        this.gxE = (RelativeLayout) this.rootView.findViewById(a.g.anchor_streak_win_layout);
        this.gxF = (ImageView) this.rootView.findViewById(a.g.anchor_user_pk_streak_img);
        this.gxG = (TextView) this.rootView.findViewById(a.g.anchor_user_pk_streak_time);
        this.gxC = (RelativeLayout) this.rootView.findViewById(a.g.jinzhu_container);
        this.gxH = (LinearLayout) this.rootView.findViewById(a.g.anchor_jinzhu_layout);
        this.gxI = (ChallengeJinzhuView) this.rootView.findViewById(a.g.anchor_jinzhu_1);
        this.gxJ = (ChallengeJinzhuView) this.rootView.findViewById(a.g.anchor_jinzhu_2);
        this.gxK = (ChallengeJinzhuView) this.rootView.findViewById(a.g.anchor_jinzhu_3);
        this.gxL = (RelativeLayout) this.rootView.findViewById(a.g.pk_rival_live_layout);
        this.gxM = (RelativeLayout) this.rootView.findViewById(a.g.pk_rival_user_layout);
        this.gxN = (HeadImageView) this.rootView.findViewById(a.g.ala_live_rival_user_image);
        this.gxO = (TextView) this.rootView.findViewById(a.g.ala_live_rival_user_name);
        this.gxP = (ImageView) this.rootView.findViewById(a.g.iv_rival_user_follow);
        this.gxU = (RelativeLayout) this.rootView.findViewById(a.g.rival_streak_win_layout);
        this.gxQ = (LinearLayout) this.rootView.findViewById(a.g.rival_jinzhu_layout);
        this.gxR = (ChallengeJinzhuView) this.rootView.findViewById(a.g.rival_jinzhu_1);
        this.gxS = (ChallengeJinzhuView) this.rootView.findViewById(a.g.rival_jinzhu_2);
        this.gxT = (ChallengeJinzhuView) this.rootView.findViewById(a.g.rival_jinzhu_3);
        this.gxV = (ImageView) this.rootView.findViewById(a.g.rival_user_pk_streak_img);
        this.gxW = (TextView) this.rootView.findViewById(a.g.rival_user_pk_streak_time);
        this.gxZ = (LinearLayout) this.rootView.findViewById(a.g.pk_time_layout);
        this.gya = (TextView) this.rootView.findViewById(a.g.pk_time_label);
        this.gyb = (RelativeLayout) this.rootView.findViewById(a.g.pk_score_progress_layout);
        this.gyc = (TextView) this.rootView.findViewById(a.g.pk_anchor_progress);
        this.gyd = (TextView) this.rootView.findViewById(a.g.pk_rival_progress);
        this.gyg = (TextView) this.rootView.findViewById(a.g.btn_close_challenge_view);
        this.gye = this.rootView.findViewById(a.g.anchor_progress_bg);
        this.gyf = this.rootView.findViewById(a.g.rival_progress_bg);
        this.gxX = (AlaChallengeMvpTipView) this.rootView.findViewById(a.g.id_chellenge_mvp_tip);
        this.gxY = (AlaChallengeMvpDynamicAnimView) this.rootView.findViewById(a.g.id_challenge_mvp_anim_view);
        this.gxM.setVisibility(0);
        this.gxM.setBackgroundResource(a.f.sdk_round_host_header_bg);
        this.gxN.setIsRound(true);
        this.gxN.setAutoChangeStyle(false);
        this.gxN.setDefaultBgResource(a.f.sdk_icon_default_avatar100_bg);
        this.gxN.setIsNight(false);
        this.gxM.setOnClickListener(this);
        this.gxP.setOnClickListener(this);
        this.gyg.setOnClickListener(this);
        this.gxH.setVisibility(8);
        this.gxQ.setVisibility(8);
        this.gxH.setOnClickListener(this);
        this.gxQ.setOnClickListener(this);
    }

    private void updateView() {
        this.gyl = h.az(this.mContext);
        this.gyk = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds50);
        this.screenWidth = BdUtilHelper.getScreenDimensions(this.mContext)[0];
        int aC = h.aC(this.mContext);
        int aB = h.aB(this.mContext);
        ViewGroup.LayoutParams layoutParams = this.gyb.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            layoutParams.height = h.btG;
            ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = h.ay(this.mContext);
            this.gyb.setLayoutParams(layoutParams);
        }
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams2.topMargin = this.gyl;
        layoutParams2.height = aB;
        this.gxz.setLayoutParams(layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.gxY.getLayoutParams();
        layoutParams3.topMargin = this.gyl;
        this.gxY.setLayoutParams(layoutParams3);
        ViewGroup.LayoutParams layoutParams4 = this.gxD.getLayoutParams();
        if (layoutParams4 != null) {
            layoutParams4.width = aC;
            layoutParams4.height = aB;
            this.gxD.setLayoutParams(layoutParams4);
        }
        ViewGroup.LayoutParams layoutParams5 = this.gxL.getLayoutParams();
        if (layoutParams5 != null) {
            layoutParams5.width = aC;
            layoutParams5.height = aB;
            this.gxL.setLayoutParams(layoutParams5);
        }
        RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(aC, aB);
        layoutParams6.topMargin = this.gyl;
        this.gxB.setLayoutParams(layoutParams6);
        RelativeLayout.LayoutParams layoutParams7 = (RelativeLayout.LayoutParams) this.gxZ.getLayoutParams();
        layoutParams7.topMargin = this.gyl;
        layoutParams7.addRule(14);
        this.gxZ.setLayoutParams(layoutParams7);
        this.gyb.setAlpha(0.0f);
        int paddingLeft = (((((aC * 2) - this.gxC.getPaddingLeft()) - this.gxC.getPaddingRight()) - ((getResources().getDimensionPixelOffset(a.e.sdk_ds56) * 3) * 2)) - (getResources().getDimensionPixelOffset(a.e.sdk_ds12) * 4)) - (getResources().getDimensionPixelOffset(a.e.sdk_ds12) * 2);
        ViewGroup.LayoutParams layoutParams8 = this.gxX.getLayoutParams();
        if (layoutParams8 instanceof ViewGroup.MarginLayoutParams) {
            layoutParams8.width = paddingLeft;
            ((ViewGroup.MarginLayoutParams) layoutParams8).bottomMargin = this.gxC.getPaddingBottom();
            this.gxX.setLayoutParams(layoutParams8);
        }
    }

    public View getAnchorAnimLiveLayout() {
        return this.gxA;
    }

    public View getRivalAnimLiveLayout() {
        return this.gxB;
    }

    public void setAnchorUserViewBg(ay ayVar) {
    }

    public void setRivalUserViewBg(ay ayVar) {
    }

    public View getLeftTimeView() {
        return this.gxZ;
    }

    public ViewGroup getLiveContainerView() {
        return this.gxz;
    }

    public View getScoreProgressLayout() {
        return this.gyb;
    }

    public View getJinzhuLayout() {
        return this.gxC;
    }

    public View getCloseBtnView() {
        return this.gyg;
    }

    public RelativeLayout getContainerView() {
        return this.gxy;
    }

    public void a(au auVar, ay ayVar, ay ayVar2, boolean z) {
        this.aJG = ayVar;
        this.aJH = ayVar2;
        int i = auVar.aJK;
        a(auVar.challengeId, i, auVar.nowTime, auVar.stageEndTime);
        c(auVar.anchorScore, auVar.rivalScore, z);
        if (z) {
            c(ayVar2);
        }
        if (i == 2) {
            setCloseBtnVisible(true);
            bRN();
        } else if (i == 3) {
            boolean z2 = false;
            if (com.baidu.live.x.a.NN().bhy != null && com.baidu.live.x.a.NN().bhy.aHK == 1) {
                z2 = true;
            }
            if (z2) {
                this.gyg.setText(this.mContext.getResources().getString(a.i.ala_challenge_btn_close_label_2));
            }
            setCloseBtnVisible(z2);
            bN(auVar.challengeResult, auVar.aJM);
        } else {
            bJw();
            setCloseBtnVisible(false);
            bN(auVar.challengeResult, auVar.aJM);
        }
        a(ayVar.aJX);
        b(ayVar2.aJX);
        this.gym = auVar;
    }

    private void a(at atVar) {
        ArrayList arrayList;
        if (atVar == null) {
            this.gxI.setVisibility(8);
            this.gxJ.setVisibility(8);
            this.gxK.setVisibility(8);
            return;
        }
        this.gxH.setVisibility(0);
        if (ListUtils.isEmpty(atVar.aJJ)) {
            atVar.aJJ = this.gyp;
        }
        if (ListUtils.isEmpty(atVar.aJJ)) {
            this.gxI.setVisibility(0);
            this.gxJ.setVisibility(8);
            this.gxK.setVisibility(8);
            this.gxI.a(true, null, atVar.liveId);
            return;
        }
        this.gyp = atVar.aJJ;
        this.gxI.setVisibility(8);
        this.gxJ.setVisibility(8);
        this.gxK.setVisibility(8);
        if (atVar.aJJ.size() > 3) {
            ArrayList arrayList2 = new ArrayList();
            for (int i = 0; i < 3; i++) {
                arrayList2.add(atVar.aJJ.get(i));
            }
            arrayList = arrayList2;
        } else {
            arrayList = atVar.aJJ;
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            as asVar = arrayList.get(i2);
            if (asVar != null) {
                if (asVar.Dj() || asVar.isFirst()) {
                    this.gxI.setVisibility(0);
                    this.gxI.a(true, asVar, atVar.liveId);
                } else if (asVar.rank == 2) {
                    this.gxJ.setVisibility(0);
                    this.gxJ.a(true, asVar, atVar.liveId);
                } else if (asVar.rank == 3) {
                    this.gxK.setVisibility(0);
                    this.gxK.a(true, asVar, atVar.liveId);
                }
            }
        }
    }

    private void b(at atVar) {
        List<as> list;
        if (atVar == null) {
            this.gxR.setVisibility(8);
            this.gxS.setVisibility(8);
            this.gxT.setVisibility(8);
            return;
        }
        this.gxQ.setVisibility(0);
        if (ListUtils.isEmpty(atVar.aJJ)) {
            atVar.aJJ = this.gyq;
        }
        if (ListUtils.isEmpty(atVar.aJJ)) {
            this.gxR.setVisibility(0);
            this.gxS.setVisibility(8);
            this.gxT.setVisibility(8);
            this.gxR.a(false, null, atVar.liveId);
            return;
        }
        this.gyq = atVar.aJJ;
        this.gxR.setVisibility(8);
        this.gxS.setVisibility(8);
        this.gxT.setVisibility(8);
        if (atVar.aJJ.size() > 3) {
            list = atVar.aJJ.subList(0, 3);
        } else {
            list = atVar.aJJ;
        }
        for (int i = 0; i < list.size(); i++) {
            as asVar = list.get(i);
            if (asVar != null) {
                if (asVar.Dj() || asVar.isFirst()) {
                    this.gxR.setVisibility(0);
                    this.gxR.a(false, asVar, atVar.liveId);
                } else if (asVar.rank == 2) {
                    this.gxS.setVisibility(0);
                    this.gxS.a(false, asVar, atVar.liveId);
                } else if (asVar.rank == 3) {
                    this.gxT.setVisibility(0);
                    this.gxT.a(false, asVar, atVar.liveId);
                }
            }
        }
    }

    private void a(long j, int i, long j2, long j3) {
        if (j3 >= j2 && a(j, i, j3)) {
            bJw();
            if (this.gym != null) {
                v(this.gym.aJK, (j3 - j2) * 1000);
            }
            this.fTL = new CountDownTimer((j3 - j2) * 1000, 1000L) { // from class: com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeLiveView.1
                @Override // android.os.CountDownTimer
                public void onTick(long j4) {
                    if (AlaChallengeLiveView.this.gym != null) {
                        AlaChallengeLiveView.this.v(AlaChallengeLiveView.this.gym.aJK, j4);
                    }
                }

                @Override // android.os.CountDownTimer
                public void onFinish() {
                    if (AlaChallengeLiveView.this.gym != null) {
                        AlaChallengeLiveView.this.v(AlaChallengeLiveView.this.gym.aJK, 0L);
                    }
                }
            };
            this.fTL.start();
        }
    }

    private boolean a(long j, int i, long j2) {
        return (this.gym != null && this.gym.challengeId == j && this.gym.aJK == i && this.gym.stageEndTime == j2) ? false : true;
    }

    private void bJw() {
        if (this.fTL != null) {
            this.fTL.cancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(int i, long j) {
        if (this.gya != null) {
            this.gya.setCompoundDrawables(null, null, null, null);
            String formatSecondsTime = StringHelper.formatSecondsTime(Math.round(j / 1000.0d));
            String string = this.mContext.getString(a.i.ala_challenge_operate_challenge_time, formatSecondsTime);
            if (i == 2) {
                Drawable drawable = getResources().getDrawable(a.f.icon_challenge_timer_countdown);
                drawable.setBounds(0, 0, getResources().getDimensionPixelOffset(a.e.sdk_ds40), getResources().getDimensionPixelOffset(a.e.sdk_ds40));
                this.gya.setCompoundDrawablePadding(getResources().getDimensionPixelOffset(a.e.sdk_ds8));
                this.gya.setCompoundDrawables(drawable, null, null, null);
            } else if (i == 3) {
                formatSecondsTime = this.mContext.getString(a.i.ala_challenge_operate_publish_time, formatSecondsTime);
            } else {
                formatSecondsTime = i == 4 ? this.mContext.getString(a.i.ala_challenge_operate_over_time) : string;
            }
            this.gya.setText(formatSecondsTime);
        }
    }

    public void setLiveContainerVisible(boolean z) {
        this.gxz.setVisibility(z ? 0 : 4);
    }

    public void setCloseBtnVisible(boolean z) {
        if (this.isHost) {
            this.gyg.setVisibility(z ? 0 : 4);
        } else {
            this.gyg.setVisibility(4);
        }
    }

    public void bRM() {
        setCloseBtnVisible(false);
        this.gyg.setText(this.mContext.getResources().getString(a.i.ala_challenge_btn_close_label));
        this.gxX.FT();
        this.gxY.bRX();
        setLiveContainerVisible(false);
        if (this.gyp != null) {
            this.gyp.clear();
            this.gyp = null;
        }
        if (this.gyq != null) {
            this.gyq.clear();
            this.gyq = null;
        }
        this.gym = null;
    }

    public void bN(int i, int i2) {
        this.gxE.setVisibility(0);
        this.gxU.setVisibility(0);
        this.gxG.setVisibility(4);
        this.gxW.setVisibility(4);
        if (1 == i) {
            this.gxF.setImageResource(a.f.icon_live_vs_win);
            if (i2 >= 2) {
                this.gxG.setVisibility(0);
                this.gxG.setText(this.mContext.getResources().getString(a.i.ala_challenge_streak_win_label, Integer.valueOf(i2)));
            } else {
                this.gxG.setText("");
            }
            this.gxV.setImageResource(a.f.icon_live_vs_lose);
        } else if (3 == i) {
            this.gxF.setImageResource(a.f.icon_live_vs_draw);
            this.gxV.setImageResource(a.f.icon_live_vs_draw);
        } else if (2 == i) {
            this.gxF.setImageResource(a.f.icon_live_vs_lose);
            if (i2 >= 2) {
                this.gxW.setVisibility(0);
                this.gxW.setText(this.mContext.getResources().getString(a.i.ala_challenge_streak_win_label, Integer.valueOf(i2)));
            } else {
                this.gxW.setText("");
            }
            this.gxV.setImageResource(a.f.icon_live_vs_win);
        } else {
            bRN();
        }
    }

    public void bRN() {
        this.gxE.setVisibility(4);
        this.gxU.setVisibility(4);
    }

    public void bRO() {
        if (this.gyp != null) {
            this.gyp.clear();
            this.gyp = null;
        }
        if (this.gyq != null) {
            this.gyq.clear();
            this.gyq = null;
        }
    }

    private ValueAnimator bP(final View view) {
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

    public void bRP() {
        this.gyc.setText(String.valueOf(this.gyi));
        this.gyd.setText(String.valueOf(this.gyj));
        if (this.gyo != null) {
            this.gyo.cancel();
        }
        this.gyo = new AnimatorSet();
        ValueAnimator bP = bP(this.gyc);
        ValueAnimator bP2 = bP(this.gyd);
        if (this.gyi != this.gyj) {
            this.gyo.setStartDelay(500L);
        } else {
            this.gyo.setStartDelay(200L);
        }
        this.gyo.playTogether(bP, bP2);
        this.gyo.start();
    }

    public void bRQ() {
        this.gyc.setAlpha(0.0f);
        this.gyd.setAlpha(0.0f);
        this.gyc.setText("");
        this.gyd.setText("");
    }

    private void c(long j, long j2, boolean z) {
        int i;
        if (z || this.gyi != j || this.gyj != j2) {
            this.gyi = j;
            this.gyj = j2;
            if (z) {
                bRQ();
            } else {
                this.gyc.setText(String.valueOf(this.gyi));
                this.gyd.setText(String.valueOf(this.gyj));
            }
            float f = (float) (this.gyi + this.gyj);
            int i2 = this.screenWidth;
            int i3 = i2 / 2;
            if (z && f != 0.0f) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gye.getLayoutParams();
                layoutParams.width = i3;
                this.gye.setLayoutParams(layoutParams);
            }
            if (this.gyi != this.gyj && f > 0.0f) {
                int i4 = (int) ((((float) this.gyi) / f) * i2);
                int i5 = !z ? ((LinearLayout.LayoutParams) this.gye.getLayoutParams()).width : i3;
                if (i4 < this.gyk) {
                    i = this.gyk;
                } else {
                    i = i4 > i2 - this.gyk ? i2 - this.gyk : i4;
                }
                if (this.gyn != null) {
                    this.gyn.cancel();
                }
                this.gyn = ValueAnimator.ofInt(i5, i);
                if (z) {
                    this.gyn.setDuration(300L);
                    this.gyn.setStartDelay(200L);
                } else {
                    this.gyn.setDuration(100L);
                }
                this.gyn.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeLiveView.3
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) AlaChallengeLiveView.this.gye.getLayoutParams();
                        layoutParams2.width = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                        AlaChallengeLiveView.this.gye.setLayoutParams(layoutParams2);
                    }
                });
                this.gyn.start();
                return;
            }
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.gye.getLayoutParams();
            layoutParams2.width = i3;
            this.gye.setLayoutParams(layoutParams2);
        }
    }

    public void c(ay ayVar) {
        if (ayVar == null || ayVar.aJI == null) {
            this.gxM.setVisibility(4);
            return;
        }
        this.gxM.setTag(ayVar);
        this.gxN.startLoad(ayVar.aJI.portrait, 12, false, false);
        String str = ayVar.aJI.userName;
        if (TextHelper.getTextLengthWithEmoji(str) > 8) {
            str = TextHelper.subStringWithEmoji(str, 8) + StringHelper.STRING_MORE;
        }
        this.gxO.setText(str);
        this.gxP.setVisibility(8);
    }

    public void lZ(boolean z) {
        if (this.gxP != null) {
            this.gxP.setVisibility(z ? 8 : 0);
        }
    }

    public View getRivalUserInfoView() {
        return this.gxM;
    }

    public void releaseResource() {
        bJw();
        if (this.gyn != null) {
            this.gyn.cancel();
        }
        if (this.gyo != null) {
            this.gyo.cancel();
        }
        bRQ();
        this.gxZ.setAlpha(0.0f);
        this.gyg.setText(this.mContext.getResources().getString(a.i.ala_challenge_btn_close_label));
        this.gxX.FT();
        this.gxY.bRX();
        this.gym = null;
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z = true;
        if (view == this.gyg) {
            if (this.gyh != null) {
                if (com.baidu.live.x.a.NN().bhy == null || this.gym == null || this.gym.aJK != 3 || com.baidu.live.x.a.NN().bhy.aHK != 1) {
                    z = false;
                }
                if (z) {
                    if (this.gym != null) {
                        this.gyh.a(this.gym.aJP);
                        return;
                    }
                    return;
                }
                this.gyh.bRR();
            }
        } else if (view == this.gxM) {
            if (this.gyh != null) {
                if (this.gyr) {
                    this.gyh.bRS();
                } else {
                    this.gyh.d((ay) this.gxM.getTag());
                }
            }
        } else if (view == this.gxP) {
            if (this.gyh != null) {
                if (this.gyr) {
                    this.gyh.bRS();
                } else {
                    this.gyh.e((ay) this.gxM.getTag());
                }
            }
        } else if (view == this.gxL) {
            if (this.gyh != null) {
                if (this.gyr) {
                    this.gyh.bRS();
                } else {
                    this.gyh.f(this.aJH);
                }
            }
        } else if (view == this.gxH) {
            this.gyh.ma(false);
        } else if (view == this.gxQ) {
            this.gyh.ma(true);
        }
    }

    public void setViewClickCallBack(a aVar) {
        this.gyh = aVar;
    }
}
