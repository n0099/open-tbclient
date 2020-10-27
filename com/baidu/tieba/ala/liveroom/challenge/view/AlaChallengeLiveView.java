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
import com.baidu.live.data.av;
import com.baidu.live.data.aw;
import com.baidu.live.data.ax;
import com.baidu.live.data.bb;
import com.baidu.live.data.bu;
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
    private bb aNq;
    private bb aNr;
    private RelativeLayout gFk;
    private RelativeLayout gXG;
    private RelativeLayout gXH;
    private RelativeLayout gXI;
    private RelativeLayout gXJ;
    private RelativeLayout gXK;
    private RelativeLayout gXL;
    private ImageView gXM;
    private TextView gXN;
    private LinearLayout gXO;
    private ChallengeJinzhuView gXP;
    private ChallengeJinzhuView gXQ;
    private ChallengeJinzhuView gXR;
    private RelativeLayout gXS;
    private RelativeLayout gXT;
    private HeadImageView gXU;
    private TextView gXV;
    private ImageView gXW;
    private LinearLayout gXX;
    private ChallengeJinzhuView gXY;
    private ChallengeJinzhuView gXZ;
    private ChallengeJinzhuView gYa;
    private RelativeLayout gYb;
    private ImageView gYc;
    private TextView gYd;
    private AlaChallengeMvpTipView gYe;
    private AlaChallengeMvpDynamicAnimView gYf;
    private LinearLayout gYg;
    private TextView gYh;
    private RelativeLayout gYi;
    private TextView gYj;
    private TextView gYk;
    private View gYl;
    private View gYm;
    private TextView gYn;
    private a gYo;
    private long gYp;
    private long gYq;
    private int gYr;
    private int gYs;
    private ax gYt;
    private ValueAnimator gYu;
    private AnimatorSet gYv;
    private List<av> gYw;
    private List<av> gYx;
    public boolean gYy;
    private CountDownTimer gqh;
    private boolean isHost;
    private Context mContext;
    private Handler mHandler;
    private RelativeLayout rootView;
    private int screenWidth;

    /* loaded from: classes4.dex */
    public interface a {
        void a(bu buVar);

        void bYk();

        void bYl();

        void d(bb bbVar);

        void e(bb bbVar);

        void f(bb bbVar);

        void mS(boolean z);
    }

    public AlaChallengeLiveView(Context context) {
        super(context);
        this.isHost = false;
        this.gYp = -1L;
        this.gYq = -1L;
        this.screenWidth = -1;
        this.gYr = 0;
        this.gYs = 0;
        this.gYy = false;
        init(context);
    }

    public AlaChallengeLiveView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isHost = false;
        this.gYp = -1L;
        this.gYq = -1L;
        this.screenWidth = -1;
        this.gYr = 0;
        this.gYs = 0;
        this.gYy = false;
        init(context);
    }

    public AlaChallengeLiveView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isHost = false;
        this.gYp = -1L;
        this.gYq = -1L;
        this.screenWidth = -1;
        this.gYr = 0;
        this.gYs = 0;
        this.gYy = false;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.mHandler = new Handler(Looper.getMainLooper());
        dQ(context);
        updateView();
    }

    public void setNeedCloseRecommendFloat(boolean z) {
        this.gYy = z;
        this.gXP.setNeedCloseRecommendFloat(this.gYy);
        this.gXQ.setNeedCloseRecommendFloat(this.gYy);
        this.gXR.setNeedCloseRecommendFloat(this.gYy);
        this.gXY.setNeedCloseRecommendFloat(this.gYy);
        this.gXZ.setNeedCloseRecommendFloat(this.gYy);
        this.gYa.setNeedCloseRecommendFloat(this.gYy);
    }

    public void setIsHost(boolean z) {
        this.isHost = z;
    }

    private void dQ(Context context) {
        this.rootView = (RelativeLayout) View.inflate(context, a.h.ala_challenge_panel_optation_view, this);
        this.gFk = (RelativeLayout) this.rootView.findViewById(a.g.root_container);
        this.gXH = (RelativeLayout) this.rootView.findViewById(a.g.anchor_live_anim_layout);
        this.gXI = (RelativeLayout) this.rootView.findViewById(a.g.rival_live_anim_layout);
        this.gXG = (RelativeLayout) this.rootView.findViewById(a.g.pk_live_container);
        this.gXK = (RelativeLayout) this.rootView.findViewById(a.g.pk_anchor_live_layout);
        this.gXL = (RelativeLayout) this.rootView.findViewById(a.g.anchor_streak_win_layout);
        this.gXM = (ImageView) this.rootView.findViewById(a.g.anchor_user_pk_streak_img);
        this.gXN = (TextView) this.rootView.findViewById(a.g.anchor_user_pk_streak_time);
        this.gXJ = (RelativeLayout) this.rootView.findViewById(a.g.jinzhu_container);
        this.gXO = (LinearLayout) this.rootView.findViewById(a.g.anchor_jinzhu_layout);
        this.gXP = (ChallengeJinzhuView) this.rootView.findViewById(a.g.anchor_jinzhu_1);
        this.gXQ = (ChallengeJinzhuView) this.rootView.findViewById(a.g.anchor_jinzhu_2);
        this.gXR = (ChallengeJinzhuView) this.rootView.findViewById(a.g.anchor_jinzhu_3);
        this.gXS = (RelativeLayout) this.rootView.findViewById(a.g.pk_rival_live_layout);
        this.gXT = (RelativeLayout) this.rootView.findViewById(a.g.pk_rival_user_layout);
        this.gXU = (HeadImageView) this.rootView.findViewById(a.g.ala_live_rival_user_image);
        this.gXV = (TextView) this.rootView.findViewById(a.g.ala_live_rival_user_name);
        this.gXW = (ImageView) this.rootView.findViewById(a.g.iv_rival_user_follow);
        this.gYb = (RelativeLayout) this.rootView.findViewById(a.g.rival_streak_win_layout);
        this.gXX = (LinearLayout) this.rootView.findViewById(a.g.rival_jinzhu_layout);
        this.gXY = (ChallengeJinzhuView) this.rootView.findViewById(a.g.rival_jinzhu_1);
        this.gXZ = (ChallengeJinzhuView) this.rootView.findViewById(a.g.rival_jinzhu_2);
        this.gYa = (ChallengeJinzhuView) this.rootView.findViewById(a.g.rival_jinzhu_3);
        this.gYc = (ImageView) this.rootView.findViewById(a.g.rival_user_pk_streak_img);
        this.gYd = (TextView) this.rootView.findViewById(a.g.rival_user_pk_streak_time);
        this.gYg = (LinearLayout) this.rootView.findViewById(a.g.pk_time_layout);
        this.gYh = (TextView) this.rootView.findViewById(a.g.pk_time_label);
        this.gYi = (RelativeLayout) this.rootView.findViewById(a.g.pk_score_progress_layout);
        this.gYj = (TextView) this.rootView.findViewById(a.g.pk_anchor_progress);
        this.gYk = (TextView) this.rootView.findViewById(a.g.pk_rival_progress);
        this.gYn = (TextView) this.rootView.findViewById(a.g.btn_close_challenge_view);
        this.gYl = this.rootView.findViewById(a.g.anchor_progress_bg);
        this.gYm = this.rootView.findViewById(a.g.rival_progress_bg);
        this.gYe = (AlaChallengeMvpTipView) this.rootView.findViewById(a.g.id_chellenge_mvp_tip);
        this.gYf = (AlaChallengeMvpDynamicAnimView) this.rootView.findViewById(a.g.id_challenge_mvp_anim_view);
        this.gXT.setVisibility(0);
        this.gXT.setBackgroundResource(a.f.sdk_round_host_header_bg);
        this.gXU.setIsRound(true);
        this.gXU.setAutoChangeStyle(false);
        this.gXU.setDefaultBgResource(a.f.sdk_icon_default_avatar100_bg);
        this.gXU.setIsNight(false);
        this.gXT.setOnClickListener(this);
        this.gXW.setOnClickListener(this);
        this.gYn.setOnClickListener(this);
        this.gXO.setVisibility(8);
        this.gXX.setVisibility(8);
        this.gXO.setOnClickListener(this);
        this.gXX.setOnClickListener(this);
    }

    private void updateView() {
        this.gYs = h.aC(this.mContext);
        this.gYr = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds50);
        this.screenWidth = BdUtilHelper.getScreenDimensions(this.mContext)[0];
        int aF = h.aF(this.mContext);
        int aE = h.aE(this.mContext);
        ViewGroup.LayoutParams layoutParams = this.gYi.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            layoutParams.height = h.bAv;
            ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = h.aB(this.mContext);
            this.gYi.setLayoutParams(layoutParams);
        }
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams2.topMargin = this.gYs;
        layoutParams2.height = aE;
        this.gXG.setLayoutParams(layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.gYf.getLayoutParams();
        layoutParams3.topMargin = this.gYs;
        this.gYf.setLayoutParams(layoutParams3);
        ViewGroup.LayoutParams layoutParams4 = this.gXK.getLayoutParams();
        if (layoutParams4 != null) {
            layoutParams4.width = aF;
            layoutParams4.height = aE;
            this.gXK.setLayoutParams(layoutParams4);
        }
        ViewGroup.LayoutParams layoutParams5 = this.gXS.getLayoutParams();
        if (layoutParams5 != null) {
            layoutParams5.width = aF;
            layoutParams5.height = aE;
            this.gXS.setLayoutParams(layoutParams5);
        }
        RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(aF, aE);
        layoutParams6.topMargin = this.gYs;
        this.gXI.setLayoutParams(layoutParams6);
        RelativeLayout.LayoutParams layoutParams7 = (RelativeLayout.LayoutParams) this.gYg.getLayoutParams();
        layoutParams7.topMargin = this.gYs;
        layoutParams7.addRule(14);
        this.gYg.setLayoutParams(layoutParams7);
        this.gYi.setAlpha(0.0f);
        int paddingLeft = (((((aF * 2) - this.gXJ.getPaddingLeft()) - this.gXJ.getPaddingRight()) - ((getResources().getDimensionPixelOffset(a.e.sdk_ds56) * 3) * 2)) - (getResources().getDimensionPixelOffset(a.e.sdk_ds12) * 4)) - (getResources().getDimensionPixelOffset(a.e.sdk_ds12) * 2);
        ViewGroup.LayoutParams layoutParams8 = this.gYe.getLayoutParams();
        if (layoutParams8 instanceof ViewGroup.MarginLayoutParams) {
            layoutParams8.width = paddingLeft;
            ((ViewGroup.MarginLayoutParams) layoutParams8).bottomMargin = this.gXJ.getPaddingBottom();
            this.gYe.setLayoutParams(layoutParams8);
        }
    }

    public View getAnchorAnimLiveLayout() {
        return this.gXH;
    }

    public View getRivalAnimLiveLayout() {
        return this.gXI;
    }

    public void setAnchorUserViewBg(bb bbVar) {
    }

    public void setRivalUserViewBg(bb bbVar) {
    }

    public View getLeftTimeView() {
        return this.gYg;
    }

    public ViewGroup getLiveContainerView() {
        return this.gXG;
    }

    public View getScoreProgressLayout() {
        return this.gYi;
    }

    public View getJinzhuLayout() {
        return this.gXJ;
    }

    public View getCloseBtnView() {
        return this.gYn;
    }

    public RelativeLayout getContainerView() {
        return this.gFk;
    }

    public void a(ax axVar, bb bbVar, bb bbVar2, boolean z) {
        this.aNq = bbVar;
        this.aNr = bbVar2;
        int i = axVar.aNu;
        a(axVar.challengeId, i, axVar.nowTime, axVar.stageEndTime);
        c(axVar.anchorScore, axVar.rivalScore, z);
        if (z) {
            c(bbVar2);
        }
        if (i == 2) {
            setCloseBtnVisible(true);
            bYg();
        } else if (i == 3) {
            boolean z2 = false;
            if (com.baidu.live.z.a.Pq().bmJ != null && com.baidu.live.z.a.Pq().bmJ.aLq == 1) {
                z2 = true;
            }
            if (z2) {
                this.gYn.setText(this.mContext.getResources().getString(a.i.ala_challenge_btn_close_label_2));
            }
            setCloseBtnVisible(z2);
            bP(axVar.challengeResult, axVar.aNw);
        } else {
            bOI();
            setCloseBtnVisible(false);
            bP(axVar.challengeResult, axVar.aNw);
        }
        a(bbVar.aNH);
        b(bbVar2.aNH);
        this.gYt = axVar;
    }

    private void a(aw awVar) {
        ArrayList arrayList;
        if (awVar == null) {
            this.gXP.setVisibility(8);
            this.gXQ.setVisibility(8);
            this.gXR.setVisibility(8);
            return;
        }
        this.gXO.setVisibility(0);
        if (ListUtils.isEmpty(awVar.aNt)) {
            awVar.aNt = this.gYw;
        }
        if (ListUtils.isEmpty(awVar.aNt)) {
            this.gXP.setVisibility(0);
            this.gXQ.setVisibility(8);
            this.gXR.setVisibility(8);
            this.gXP.a(true, null, awVar.liveId);
            return;
        }
        this.gYw = awVar.aNt;
        this.gXP.setVisibility(8);
        this.gXQ.setVisibility(8);
        this.gXR.setVisibility(8);
        if (awVar.aNt.size() > 3) {
            ArrayList arrayList2 = new ArrayList();
            for (int i = 0; i < 3; i++) {
                arrayList2.add(awVar.aNt.get(i));
            }
            arrayList = arrayList2;
        } else {
            arrayList = awVar.aNt;
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            av avVar = arrayList.get(i2);
            if (avVar != null) {
                if (avVar.Ep() || avVar.isFirst()) {
                    this.gXP.setVisibility(0);
                    this.gXP.a(true, avVar, awVar.liveId);
                } else if (avVar.rank == 2) {
                    this.gXQ.setVisibility(0);
                    this.gXQ.a(true, avVar, awVar.liveId);
                } else if (avVar.rank == 3) {
                    this.gXR.setVisibility(0);
                    this.gXR.a(true, avVar, awVar.liveId);
                }
            }
        }
    }

    private void b(aw awVar) {
        List<av> list;
        if (awVar == null) {
            this.gXY.setVisibility(8);
            this.gXZ.setVisibility(8);
            this.gYa.setVisibility(8);
            return;
        }
        this.gXX.setVisibility(0);
        if (ListUtils.isEmpty(awVar.aNt)) {
            awVar.aNt = this.gYx;
        }
        if (ListUtils.isEmpty(awVar.aNt)) {
            this.gXY.setVisibility(0);
            this.gXZ.setVisibility(8);
            this.gYa.setVisibility(8);
            this.gXY.a(false, null, awVar.liveId);
            return;
        }
        this.gYx = awVar.aNt;
        this.gXY.setVisibility(8);
        this.gXZ.setVisibility(8);
        this.gYa.setVisibility(8);
        if (awVar.aNt.size() > 3) {
            list = awVar.aNt.subList(0, 3);
        } else {
            list = awVar.aNt;
        }
        for (int i = 0; i < list.size(); i++) {
            av avVar = list.get(i);
            if (avVar != null) {
                if (avVar.Ep() || avVar.isFirst()) {
                    this.gXY.setVisibility(0);
                    this.gXY.a(false, avVar, awVar.liveId);
                } else if (avVar.rank == 2) {
                    this.gXZ.setVisibility(0);
                    this.gXZ.a(false, avVar, awVar.liveId);
                } else if (avVar.rank == 3) {
                    this.gYa.setVisibility(0);
                    this.gYa.a(false, avVar, awVar.liveId);
                }
            }
        }
    }

    private void a(long j, int i, long j2, long j3) {
        if (j3 >= j2 && a(j, i, j3)) {
            bOI();
            if (this.gYt != null) {
                w(this.gYt.aNu, (j3 - j2) * 1000);
            }
            this.gqh = new CountDownTimer((j3 - j2) * 1000, 1000L) { // from class: com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeLiveView.1
                @Override // android.os.CountDownTimer
                public void onTick(long j4) {
                    if (AlaChallengeLiveView.this.gYt != null) {
                        AlaChallengeLiveView.this.w(AlaChallengeLiveView.this.gYt.aNu, j4);
                    }
                }

                @Override // android.os.CountDownTimer
                public void onFinish() {
                    if (AlaChallengeLiveView.this.gYt != null) {
                        AlaChallengeLiveView.this.w(AlaChallengeLiveView.this.gYt.aNu, 0L);
                    }
                }
            };
            this.gqh.start();
        }
    }

    private boolean a(long j, int i, long j2) {
        return (this.gYt != null && this.gYt.challengeId == j && this.gYt.aNu == i && this.gYt.stageEndTime == j2) ? false : true;
    }

    private void bOI() {
        if (this.gqh != null) {
            this.gqh.cancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(int i, long j) {
        if (this.gYh != null) {
            this.gYh.setCompoundDrawables(null, null, null, null);
            String formatSecondsTime = StringHelper.formatSecondsTime(Math.round(j / 1000.0d));
            String string = this.mContext.getString(a.i.ala_challenge_operate_challenge_time, formatSecondsTime);
            if (i == 2) {
                Drawable drawable = getResources().getDrawable(a.f.icon_challenge_timer_countdown);
                drawable.setBounds(0, 0, getResources().getDimensionPixelOffset(a.e.sdk_ds40), getResources().getDimensionPixelOffset(a.e.sdk_ds40));
                this.gYh.setCompoundDrawablePadding(getResources().getDimensionPixelOffset(a.e.sdk_ds8));
                this.gYh.setCompoundDrawables(drawable, null, null, null);
            } else if (i == 3) {
                formatSecondsTime = this.mContext.getString(a.i.ala_challenge_operate_publish_time, formatSecondsTime);
            } else {
                formatSecondsTime = i == 4 ? this.mContext.getString(a.i.ala_challenge_operate_over_time) : string;
            }
            this.gYh.setText(formatSecondsTime);
        }
    }

    public void setLiveContainerVisible(boolean z) {
        this.gXG.setVisibility(z ? 0 : 4);
    }

    public void setCloseBtnVisible(boolean z) {
        if (this.isHost) {
            this.gYn.setVisibility(z ? 0 : 4);
        } else {
            this.gYn.setVisibility(4);
        }
    }

    public void bYf() {
        setCloseBtnVisible(false);
        this.gYn.setText(this.mContext.getResources().getString(a.i.ala_challenge_btn_close_label));
        this.gYe.Hl();
        this.gYf.bYq();
        setLiveContainerVisible(false);
        if (this.gYw != null) {
            this.gYw.clear();
            this.gYw = null;
        }
        if (this.gYx != null) {
            this.gYx.clear();
            this.gYx = null;
        }
        this.gYt = null;
    }

    public void bP(int i, int i2) {
        this.gXL.setVisibility(0);
        this.gYb.setVisibility(0);
        this.gXN.setVisibility(4);
        this.gYd.setVisibility(4);
        if (1 == i) {
            this.gXM.setImageResource(a.f.icon_live_vs_win);
            if (i2 >= 2) {
                this.gXN.setVisibility(0);
                this.gXN.setText(this.mContext.getResources().getString(a.i.ala_challenge_streak_win_label, Integer.valueOf(i2)));
            } else {
                this.gXN.setText("");
            }
            this.gYc.setImageResource(a.f.icon_live_vs_lose);
        } else if (3 == i) {
            this.gXM.setImageResource(a.f.icon_live_vs_draw);
            this.gYc.setImageResource(a.f.icon_live_vs_draw);
        } else if (2 == i) {
            this.gXM.setImageResource(a.f.icon_live_vs_lose);
            if (i2 >= 2) {
                this.gYd.setVisibility(0);
                this.gYd.setText(this.mContext.getResources().getString(a.i.ala_challenge_streak_win_label, Integer.valueOf(i2)));
            } else {
                this.gYd.setText("");
            }
            this.gYc.setImageResource(a.f.icon_live_vs_win);
        } else {
            bYg();
        }
    }

    public void bYg() {
        this.gXL.setVisibility(4);
        this.gYb.setVisibility(4);
    }

    public void bYh() {
        if (this.gYw != null) {
            this.gYw.clear();
            this.gYw = null;
        }
        if (this.gYx != null) {
            this.gYx.clear();
            this.gYx = null;
        }
    }

    private ValueAnimator bX(final View view) {
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

    public void bYi() {
        this.gYj.setText(String.valueOf(this.gYp));
        this.gYk.setText(String.valueOf(this.gYq));
        if (this.gYv != null) {
            this.gYv.cancel();
        }
        this.gYv = new AnimatorSet();
        ValueAnimator bX = bX(this.gYj);
        ValueAnimator bX2 = bX(this.gYk);
        if (this.gYp != this.gYq) {
            this.gYv.setStartDelay(500L);
        } else {
            this.gYv.setStartDelay(200L);
        }
        this.gYv.playTogether(bX, bX2);
        this.gYv.start();
    }

    public void bYj() {
        this.gYj.setAlpha(0.0f);
        this.gYk.setAlpha(0.0f);
        this.gYj.setText("");
        this.gYk.setText("");
    }

    private void c(long j, long j2, boolean z) {
        int i;
        if (z || this.gYp != j || this.gYq != j2) {
            this.gYp = j;
            this.gYq = j2;
            if (z) {
                bYj();
            } else {
                this.gYj.setText(String.valueOf(this.gYp));
                this.gYk.setText(String.valueOf(this.gYq));
            }
            float f = (float) (this.gYp + this.gYq);
            int i2 = this.screenWidth;
            int i3 = i2 / 2;
            if (z && f != 0.0f) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gYl.getLayoutParams();
                layoutParams.width = i3;
                this.gYl.setLayoutParams(layoutParams);
            }
            if (this.gYp != this.gYq && f > 0.0f) {
                int i4 = (int) ((((float) this.gYp) / f) * i2);
                int i5 = !z ? ((LinearLayout.LayoutParams) this.gYl.getLayoutParams()).width : i3;
                if (i4 < this.gYr) {
                    i = this.gYr;
                } else {
                    i = i4 > i2 - this.gYr ? i2 - this.gYr : i4;
                }
                if (this.gYu != null) {
                    this.gYu.cancel();
                }
                this.gYu = ValueAnimator.ofInt(i5, i);
                if (z) {
                    this.gYu.setDuration(300L);
                    this.gYu.setStartDelay(200L);
                } else {
                    this.gYu.setDuration(100L);
                }
                this.gYu.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeLiveView.3
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) AlaChallengeLiveView.this.gYl.getLayoutParams();
                        layoutParams2.width = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                        AlaChallengeLiveView.this.gYl.setLayoutParams(layoutParams2);
                    }
                });
                this.gYu.start();
                return;
            }
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.gYl.getLayoutParams();
            layoutParams2.width = i3;
            this.gYl.setLayoutParams(layoutParams2);
        }
    }

    public void c(bb bbVar) {
        if (bbVar == null || bbVar.aNs == null) {
            this.gXT.setVisibility(4);
            return;
        }
        this.gXT.setTag(bbVar);
        this.gXU.startLoad(bbVar.aNs.portrait, 12, false, false);
        String str = bbVar.aNs.userName;
        if (TextHelper.getTextLengthWithEmoji(str) > 8) {
            str = TextHelper.subStringWithEmoji(str, 8) + StringHelper.STRING_MORE;
        }
        this.gXV.setText(str);
        this.gXW.setVisibility(8);
    }

    public void mR(boolean z) {
        if (this.gXW != null) {
            this.gXW.setVisibility(z ? 8 : 0);
        }
    }

    public View getRivalUserInfoView() {
        return this.gXT;
    }

    public void releaseResource() {
        bOI();
        if (this.gYu != null) {
            this.gYu.cancel();
        }
        if (this.gYv != null) {
            this.gYv.cancel();
        }
        bYj();
        this.gYg.setAlpha(0.0f);
        this.gYn.setText(this.mContext.getResources().getString(a.i.ala_challenge_btn_close_label));
        this.gYe.Hl();
        this.gYf.bYq();
        this.gYt = null;
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z = true;
        if (view == this.gYn) {
            if (this.gYo != null) {
                if (com.baidu.live.z.a.Pq().bmJ == null || this.gYt == null || this.gYt.aNu != 3 || com.baidu.live.z.a.Pq().bmJ.aLq != 1) {
                    z = false;
                }
                if (z) {
                    if (this.gYt != null) {
                        this.gYo.a(this.gYt.aNz);
                        return;
                    }
                    return;
                }
                this.gYo.bYk();
            }
        } else if (view == this.gXT) {
            if (this.gYo != null) {
                if (this.gYy) {
                    this.gYo.bYl();
                } else {
                    this.gYo.d((bb) this.gXT.getTag());
                }
            }
        } else if (view == this.gXW) {
            if (this.gYo != null) {
                if (this.gYy) {
                    this.gYo.bYl();
                } else {
                    this.gYo.e((bb) this.gXT.getTag());
                }
            }
        } else if (view == this.gXS) {
            if (this.gYo != null) {
                if (this.gYy) {
                    this.gYo.bYl();
                } else {
                    this.gYo.f(this.aNr);
                }
            }
        } else if (view == this.gXO) {
            this.gYo.mS(false);
        } else if (view == this.gXX) {
            this.gYo.mS(true);
        }
    }

    public void setViewClickCallBack(a aVar) {
        this.gYo = aVar;
    }
}
