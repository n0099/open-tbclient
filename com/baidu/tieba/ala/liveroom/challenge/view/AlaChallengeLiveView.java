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
import com.baidu.live.data.ay;
import com.baidu.live.data.az;
import com.baidu.live.data.ba;
import com.baidu.live.data.be;
import com.baidu.live.data.bx;
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
    private be aPH;
    private be aPI;
    private CountDownTimer gEo;
    private RelativeLayout gTR;
    private AlaChallengeMvpDynamicAnimView hnA;
    private LinearLayout hnB;
    private TextView hnC;
    private RelativeLayout hnD;
    private TextView hnE;
    private TextView hnF;
    private View hnG;
    private View hnH;
    private TextView hnI;
    private a hnJ;
    private long hnK;
    private long hnL;
    private int hnM;
    private int hnN;
    private ba hnO;
    private ValueAnimator hnP;
    private AnimatorSet hnQ;
    private List<ay> hnR;
    private List<ay> hnS;
    public boolean hnT;
    private RelativeLayout hnb;
    private RelativeLayout hnc;
    private RelativeLayout hnd;
    private RelativeLayout hne;
    private RelativeLayout hnf;
    private RelativeLayout hng;
    private ImageView hnh;
    private TextView hni;
    private LinearLayout hnj;
    private ChallengeJinzhuView hnk;
    private ChallengeJinzhuView hnl;
    private ChallengeJinzhuView hnm;
    private RelativeLayout hnn;
    private RelativeLayout hno;
    private HeadImageView hnp;
    private TextView hnq;
    private ImageView hnr;
    private LinearLayout hns;
    private ChallengeJinzhuView hnt;
    private ChallengeJinzhuView hnu;
    private ChallengeJinzhuView hnv;
    private RelativeLayout hnw;
    private ImageView hnx;
    private TextView hny;
    private AlaChallengeMvpTipView hnz;
    private boolean isHost;
    private Context mContext;
    private Handler mHandler;
    private RelativeLayout rootView;
    private int screenWidth;

    /* loaded from: classes4.dex */
    public interface a {
        void a(bx bxVar);

        void ceb();

        void cec();

        void d(be beVar);

        void e(be beVar);

        void f(be beVar);

        void nx(boolean z);
    }

    public AlaChallengeLiveView(Context context) {
        super(context);
        this.isHost = false;
        this.hnK = -1L;
        this.hnL = -1L;
        this.screenWidth = -1;
        this.hnM = 0;
        this.hnN = 0;
        this.hnT = false;
        init(context);
    }

    public AlaChallengeLiveView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isHost = false;
        this.hnK = -1L;
        this.hnL = -1L;
        this.screenWidth = -1;
        this.hnM = 0;
        this.hnN = 0;
        this.hnT = false;
        init(context);
    }

    public AlaChallengeLiveView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isHost = false;
        this.hnK = -1L;
        this.hnL = -1L;
        this.screenWidth = -1;
        this.hnM = 0;
        this.hnN = 0;
        this.hnT = false;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.mHandler = new Handler(Looper.getMainLooper());
        ev(context);
        updateView();
    }

    public void setNeedCloseRecommendFloat(boolean z) {
        this.hnT = z;
        this.hnk.setNeedCloseRecommendFloat(this.hnT);
        this.hnl.setNeedCloseRecommendFloat(this.hnT);
        this.hnm.setNeedCloseRecommendFloat(this.hnT);
        this.hnt.setNeedCloseRecommendFloat(this.hnT);
        this.hnu.setNeedCloseRecommendFloat(this.hnT);
        this.hnv.setNeedCloseRecommendFloat(this.hnT);
    }

    public void setIsHost(boolean z) {
        this.isHost = z;
    }

    private void ev(Context context) {
        this.rootView = (RelativeLayout) View.inflate(context, a.g.ala_challenge_panel_optation_view, this);
        this.gTR = (RelativeLayout) this.rootView.findViewById(a.f.root_container);
        this.hnc = (RelativeLayout) this.rootView.findViewById(a.f.anchor_live_anim_layout);
        this.hnd = (RelativeLayout) this.rootView.findViewById(a.f.rival_live_anim_layout);
        this.hnb = (RelativeLayout) this.rootView.findViewById(a.f.pk_live_container);
        this.hnf = (RelativeLayout) this.rootView.findViewById(a.f.pk_anchor_live_layout);
        this.hng = (RelativeLayout) this.rootView.findViewById(a.f.anchor_streak_win_layout);
        this.hnh = (ImageView) this.rootView.findViewById(a.f.anchor_user_pk_streak_img);
        this.hni = (TextView) this.rootView.findViewById(a.f.anchor_user_pk_streak_time);
        this.hne = (RelativeLayout) this.rootView.findViewById(a.f.jinzhu_container);
        this.hnj = (LinearLayout) this.rootView.findViewById(a.f.anchor_jinzhu_layout);
        this.hnk = (ChallengeJinzhuView) this.rootView.findViewById(a.f.anchor_jinzhu_1);
        this.hnl = (ChallengeJinzhuView) this.rootView.findViewById(a.f.anchor_jinzhu_2);
        this.hnm = (ChallengeJinzhuView) this.rootView.findViewById(a.f.anchor_jinzhu_3);
        this.hnn = (RelativeLayout) this.rootView.findViewById(a.f.pk_rival_live_layout);
        this.hno = (RelativeLayout) this.rootView.findViewById(a.f.pk_rival_user_layout);
        this.hnp = (HeadImageView) this.rootView.findViewById(a.f.ala_live_rival_user_image);
        this.hnq = (TextView) this.rootView.findViewById(a.f.ala_live_rival_user_name);
        this.hnr = (ImageView) this.rootView.findViewById(a.f.iv_rival_user_follow);
        this.hnw = (RelativeLayout) this.rootView.findViewById(a.f.rival_streak_win_layout);
        this.hns = (LinearLayout) this.rootView.findViewById(a.f.rival_jinzhu_layout);
        this.hnt = (ChallengeJinzhuView) this.rootView.findViewById(a.f.rival_jinzhu_1);
        this.hnu = (ChallengeJinzhuView) this.rootView.findViewById(a.f.rival_jinzhu_2);
        this.hnv = (ChallengeJinzhuView) this.rootView.findViewById(a.f.rival_jinzhu_3);
        this.hnx = (ImageView) this.rootView.findViewById(a.f.rival_user_pk_streak_img);
        this.hny = (TextView) this.rootView.findViewById(a.f.rival_user_pk_streak_time);
        this.hnB = (LinearLayout) this.rootView.findViewById(a.f.pk_time_layout);
        this.hnC = (TextView) this.rootView.findViewById(a.f.pk_time_label);
        this.hnD = (RelativeLayout) this.rootView.findViewById(a.f.pk_score_progress_layout);
        this.hnE = (TextView) this.rootView.findViewById(a.f.pk_anchor_progress);
        this.hnF = (TextView) this.rootView.findViewById(a.f.pk_rival_progress);
        this.hnI = (TextView) this.rootView.findViewById(a.f.btn_close_challenge_view);
        this.hnG = this.rootView.findViewById(a.f.anchor_progress_bg);
        this.hnH = this.rootView.findViewById(a.f.rival_progress_bg);
        this.hnz = (AlaChallengeMvpTipView) this.rootView.findViewById(a.f.id_chellenge_mvp_tip);
        this.hnA = (AlaChallengeMvpDynamicAnimView) this.rootView.findViewById(a.f.id_challenge_mvp_anim_view);
        this.hno.setVisibility(0);
        this.hno.setBackgroundResource(a.e.sdk_round_host_header_bg);
        this.hnp.setIsRound(true);
        this.hnp.setAutoChangeStyle(false);
        this.hnp.setDefaultBgResource(a.e.sdk_icon_default_avatar100_bg);
        this.hnp.setIsNight(false);
        this.hno.setOnClickListener(this);
        this.hnr.setOnClickListener(this);
        this.hnI.setOnClickListener(this);
        this.hnj.setVisibility(8);
        this.hns.setVisibility(8);
        this.hnj.setOnClickListener(this);
        this.hns.setOnClickListener(this);
    }

    private void updateView() {
        this.hnN = h.bh(this.mContext);
        this.hnM = this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds50);
        this.screenWidth = BdUtilHelper.getScreenDimensions(this.mContext)[0];
        int bk = h.bk(this.mContext);
        int bj = h.bj(this.mContext);
        ViewGroup.LayoutParams layoutParams = this.hnD.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            layoutParams.height = h.bKe;
            ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = h.bg(this.mContext);
            this.hnD.setLayoutParams(layoutParams);
        }
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams2.topMargin = this.hnN;
        layoutParams2.height = bj;
        this.hnb.setLayoutParams(layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.hnA.getLayoutParams();
        layoutParams3.topMargin = this.hnN;
        this.hnA.setLayoutParams(layoutParams3);
        ViewGroup.LayoutParams layoutParams4 = this.hnf.getLayoutParams();
        if (layoutParams4 != null) {
            layoutParams4.width = bk;
            layoutParams4.height = bj;
            this.hnf.setLayoutParams(layoutParams4);
        }
        ViewGroup.LayoutParams layoutParams5 = this.hnn.getLayoutParams();
        if (layoutParams5 != null) {
            layoutParams5.width = bk;
            layoutParams5.height = bj;
            this.hnn.setLayoutParams(layoutParams5);
        }
        RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(bk, bj);
        layoutParams6.topMargin = this.hnN;
        this.hnd.setLayoutParams(layoutParams6);
        RelativeLayout.LayoutParams layoutParams7 = (RelativeLayout.LayoutParams) this.hnB.getLayoutParams();
        layoutParams7.topMargin = this.hnN;
        layoutParams7.addRule(14);
        this.hnB.setLayoutParams(layoutParams7);
        this.hnD.setAlpha(0.0f);
        int paddingLeft = (((((bk * 2) - this.hne.getPaddingLeft()) - this.hne.getPaddingRight()) - ((getResources().getDimensionPixelOffset(a.d.sdk_ds56) * 3) * 2)) - (getResources().getDimensionPixelOffset(a.d.sdk_ds12) * 4)) - (getResources().getDimensionPixelOffset(a.d.sdk_ds12) * 2);
        ViewGroup.LayoutParams layoutParams8 = this.hnz.getLayoutParams();
        if (layoutParams8 instanceof ViewGroup.MarginLayoutParams) {
            layoutParams8.width = paddingLeft;
            ((ViewGroup.MarginLayoutParams) layoutParams8).bottomMargin = this.hne.getPaddingBottom();
            this.hnz.setLayoutParams(layoutParams8);
        }
    }

    public View getAnchorAnimLiveLayout() {
        return this.hnc;
    }

    public View getRivalAnimLiveLayout() {
        return this.hnd;
    }

    public void setAnchorUserViewBg(be beVar) {
    }

    public void setRivalUserViewBg(be beVar) {
    }

    public View getLeftTimeView() {
        return this.hnB;
    }

    public ViewGroup getLiveContainerView() {
        return this.hnb;
    }

    public View getScoreProgressLayout() {
        return this.hnD;
    }

    public View getJinzhuLayout() {
        return this.hne;
    }

    public View getCloseBtnView() {
        return this.hnI;
    }

    public RelativeLayout getContainerView() {
        return this.gTR;
    }

    public void a(ba baVar, be beVar, be beVar2, boolean z) {
        this.aPH = beVar;
        this.aPI = beVar2;
        int i = baVar.aPL;
        a(baVar.challengeId, i, baVar.nowTime, baVar.stageEndTime);
        c(baVar.anchorScore, baVar.rivalScore, z);
        if (z) {
            c(beVar2);
        }
        if (i == 2) {
            setCloseBtnVisible(true);
            cdX();
        } else if (i == 3) {
            boolean z2 = false;
            if (com.baidu.live.ae.a.RB().brA != null && com.baidu.live.ae.a.RB().brA.aNA == 1) {
                z2 = true;
            }
            if (z2) {
                this.hnI.setText(this.mContext.getResources().getString(a.h.ala_challenge_btn_close_label_2));
            }
            setCloseBtnVisible(z2);
            bV(baVar.challengeResult, baVar.aPN);
        } else {
            bUm();
            setCloseBtnVisible(false);
            bV(baVar.challengeResult, baVar.aPN);
        }
        a(beVar.aPY);
        b(beVar2.aPY);
        this.hnO = baVar;
    }

    private void a(az azVar) {
        ArrayList arrayList;
        if (azVar == null) {
            this.hnk.setVisibility(8);
            this.hnl.setVisibility(8);
            this.hnm.setVisibility(8);
            return;
        }
        this.hnj.setVisibility(0);
        if (ListUtils.isEmpty(azVar.aPK)) {
            azVar.aPK = this.hnR;
        }
        if (ListUtils.isEmpty(azVar.aPK)) {
            this.hnk.setVisibility(0);
            this.hnl.setVisibility(8);
            this.hnm.setVisibility(8);
            this.hnk.a(true, null, azVar.liveId);
            return;
        }
        this.hnR = azVar.aPK;
        this.hnk.setVisibility(8);
        this.hnl.setVisibility(8);
        this.hnm.setVisibility(8);
        if (azVar.aPK.size() > 3) {
            ArrayList arrayList2 = new ArrayList();
            for (int i = 0; i < 3; i++) {
                arrayList2.add(azVar.aPK.get(i));
            }
            arrayList = arrayList2;
        } else {
            arrayList = azVar.aPK;
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            ay ayVar = arrayList.get(i2);
            if (ayVar != null) {
                if (ayVar.FO() || ayVar.isFirst()) {
                    this.hnk.setVisibility(0);
                    this.hnk.a(true, ayVar, azVar.liveId);
                } else if (ayVar.rank == 2) {
                    this.hnl.setVisibility(0);
                    this.hnl.a(true, ayVar, azVar.liveId);
                } else if (ayVar.rank == 3) {
                    this.hnm.setVisibility(0);
                    this.hnm.a(true, ayVar, azVar.liveId);
                }
            }
        }
    }

    private void b(az azVar) {
        List<ay> list;
        if (azVar == null) {
            this.hnt.setVisibility(8);
            this.hnu.setVisibility(8);
            this.hnv.setVisibility(8);
            return;
        }
        this.hns.setVisibility(0);
        if (ListUtils.isEmpty(azVar.aPK)) {
            azVar.aPK = this.hnS;
        }
        if (ListUtils.isEmpty(azVar.aPK)) {
            this.hnt.setVisibility(0);
            this.hnu.setVisibility(8);
            this.hnv.setVisibility(8);
            this.hnt.a(false, null, azVar.liveId);
            return;
        }
        this.hnS = azVar.aPK;
        this.hnt.setVisibility(8);
        this.hnu.setVisibility(8);
        this.hnv.setVisibility(8);
        if (azVar.aPK.size() > 3) {
            list = azVar.aPK.subList(0, 3);
        } else {
            list = azVar.aPK;
        }
        for (int i = 0; i < list.size(); i++) {
            ay ayVar = list.get(i);
            if (ayVar != null) {
                if (ayVar.FO() || ayVar.isFirst()) {
                    this.hnt.setVisibility(0);
                    this.hnt.a(false, ayVar, azVar.liveId);
                } else if (ayVar.rank == 2) {
                    this.hnu.setVisibility(0);
                    this.hnu.a(false, ayVar, azVar.liveId);
                } else if (ayVar.rank == 3) {
                    this.hnv.setVisibility(0);
                    this.hnv.a(false, ayVar, azVar.liveId);
                }
            }
        }
    }

    private void a(long j, int i, long j2, long j3) {
        if (j3 >= j2 && a(j, i, j3)) {
            bUm();
            if (this.hnO != null) {
                v(this.hnO.aPL, (j3 - j2) * 1000);
            }
            this.gEo = new CountDownTimer((j3 - j2) * 1000, 1000L) { // from class: com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeLiveView.1
                @Override // android.os.CountDownTimer
                public void onTick(long j4) {
                    if (AlaChallengeLiveView.this.hnO != null) {
                        AlaChallengeLiveView.this.v(AlaChallengeLiveView.this.hnO.aPL, j4);
                    }
                }

                @Override // android.os.CountDownTimer
                public void onFinish() {
                    if (AlaChallengeLiveView.this.hnO != null) {
                        AlaChallengeLiveView.this.v(AlaChallengeLiveView.this.hnO.aPL, 0L);
                    }
                }
            };
            this.gEo.start();
        }
    }

    private boolean a(long j, int i, long j2) {
        return (this.hnO != null && this.hnO.challengeId == j && this.hnO.aPL == i && this.hnO.stageEndTime == j2) ? false : true;
    }

    private void bUm() {
        if (this.gEo != null) {
            this.gEo.cancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(int i, long j) {
        if (this.hnC != null) {
            this.hnC.setCompoundDrawables(null, null, null, null);
            String formatSecondsTime = StringHelper.formatSecondsTime(Math.round(j / 1000.0d));
            String string = this.mContext.getString(a.h.ala_challenge_operate_challenge_time, formatSecondsTime);
            if (i == 2) {
                Drawable drawable = getResources().getDrawable(a.e.icon_challenge_timer_countdown);
                drawable.setBounds(0, 0, getResources().getDimensionPixelOffset(a.d.sdk_ds40), getResources().getDimensionPixelOffset(a.d.sdk_ds40));
                this.hnC.setCompoundDrawablePadding(getResources().getDimensionPixelOffset(a.d.sdk_ds8));
                this.hnC.setCompoundDrawables(drawable, null, null, null);
            } else if (i == 3) {
                formatSecondsTime = this.mContext.getString(a.h.ala_challenge_operate_publish_time, formatSecondsTime);
            } else {
                formatSecondsTime = i == 4 ? this.mContext.getString(a.h.ala_challenge_operate_over_time) : string;
            }
            this.hnC.setText(formatSecondsTime);
        }
    }

    public void setLiveContainerVisible(boolean z) {
        this.hnb.setVisibility(z ? 0 : 4);
    }

    public void setCloseBtnVisible(boolean z) {
        if (this.isHost) {
            this.hnI.setVisibility(z ? 0 : 4);
        } else {
            this.hnI.setVisibility(4);
        }
    }

    public void cdW() {
        setCloseBtnVisible(false);
        this.hnI.setText(this.mContext.getResources().getString(a.h.ala_challenge_btn_close_label));
        this.hnz.IT();
        this.hnA.ceh();
        setLiveContainerVisible(false);
        if (this.hnR != null) {
            this.hnR.clear();
            this.hnR = null;
        }
        if (this.hnS != null) {
            this.hnS.clear();
            this.hnS = null;
        }
        this.hnO = null;
    }

    public void bV(int i, int i2) {
        this.hng.setVisibility(0);
        this.hnw.setVisibility(0);
        this.hni.setVisibility(4);
        this.hny.setVisibility(4);
        if (1 == i) {
            this.hnh.setImageResource(a.e.icon_live_vs_win);
            if (i2 >= 2) {
                this.hni.setVisibility(0);
                this.hni.setText(this.mContext.getResources().getString(a.h.ala_challenge_streak_win_label, Integer.valueOf(i2)));
            } else {
                this.hni.setText("");
            }
            this.hnx.setImageResource(a.e.icon_live_vs_lose);
        } else if (3 == i) {
            this.hnh.setImageResource(a.e.icon_live_vs_draw);
            this.hnx.setImageResource(a.e.icon_live_vs_draw);
        } else if (2 == i) {
            this.hnh.setImageResource(a.e.icon_live_vs_lose);
            if (i2 >= 2) {
                this.hny.setVisibility(0);
                this.hny.setText(this.mContext.getResources().getString(a.h.ala_challenge_streak_win_label, Integer.valueOf(i2)));
            } else {
                this.hny.setText("");
            }
            this.hnx.setImageResource(a.e.icon_live_vs_win);
        } else {
            cdX();
        }
    }

    public void cdX() {
        this.hng.setVisibility(4);
        this.hnw.setVisibility(4);
    }

    public void cdY() {
        if (this.hnR != null) {
            this.hnR.clear();
            this.hnR = null;
        }
        if (this.hnS != null) {
            this.hnS.clear();
            this.hnS = null;
        }
    }

    private ValueAnimator cl(final View view) {
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

    public void cdZ() {
        this.hnE.setText(String.valueOf(this.hnK));
        this.hnF.setText(String.valueOf(this.hnL));
        if (this.hnQ != null) {
            this.hnQ.cancel();
        }
        this.hnQ = new AnimatorSet();
        ValueAnimator cl = cl(this.hnE);
        ValueAnimator cl2 = cl(this.hnF);
        if (this.hnK != this.hnL) {
            this.hnQ.setStartDelay(500L);
        } else {
            this.hnQ.setStartDelay(200L);
        }
        this.hnQ.playTogether(cl, cl2);
        this.hnQ.start();
    }

    public void cea() {
        this.hnE.setAlpha(0.0f);
        this.hnF.setAlpha(0.0f);
        this.hnE.setText("");
        this.hnF.setText("");
    }

    private void c(long j, long j2, boolean z) {
        int i;
        if (z || this.hnK != j || this.hnL != j2) {
            this.hnK = j;
            this.hnL = j2;
            if (z) {
                cea();
            } else {
                this.hnE.setText(String.valueOf(this.hnK));
                this.hnF.setText(String.valueOf(this.hnL));
            }
            float f = (float) (this.hnK + this.hnL);
            int i2 = this.screenWidth;
            int i3 = i2 / 2;
            if (z && f != 0.0f) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hnG.getLayoutParams();
                layoutParams.width = i3;
                this.hnG.setLayoutParams(layoutParams);
            }
            if (this.hnK != this.hnL && f > 0.0f) {
                int i4 = (int) ((((float) this.hnK) / f) * i2);
                int i5 = !z ? ((LinearLayout.LayoutParams) this.hnG.getLayoutParams()).width : i3;
                if (i4 < this.hnM) {
                    i = this.hnM;
                } else {
                    i = i4 > i2 - this.hnM ? i2 - this.hnM : i4;
                }
                if (this.hnP != null) {
                    this.hnP.cancel();
                }
                this.hnP = ValueAnimator.ofInt(i5, i);
                if (z) {
                    this.hnP.setDuration(300L);
                    this.hnP.setStartDelay(200L);
                } else {
                    this.hnP.setDuration(100L);
                }
                this.hnP.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeLiveView.3
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) AlaChallengeLiveView.this.hnG.getLayoutParams();
                        layoutParams2.width = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                        AlaChallengeLiveView.this.hnG.setLayoutParams(layoutParams2);
                    }
                });
                this.hnP.start();
                return;
            }
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.hnG.getLayoutParams();
            layoutParams2.width = i3;
            this.hnG.setLayoutParams(layoutParams2);
        }
    }

    public void c(be beVar) {
        if (beVar == null || beVar.aPJ == null) {
            this.hno.setVisibility(4);
            return;
        }
        this.hno.setTag(beVar);
        this.hnp.startLoad(beVar.aPJ.portrait, 12, false, false);
        String str = beVar.aPJ.userName;
        if (TextHelper.getTextLengthWithEmoji(str) > 8) {
            str = TextHelper.subStringWithEmoji(str, 8) + StringHelper.STRING_MORE;
        }
        this.hnq.setText(str);
        this.hnr.setVisibility(8);
    }

    public void nw(boolean z) {
        if (this.hnr != null) {
            this.hnr.setVisibility(z ? 8 : 0);
        }
    }

    public View getRivalUserInfoView() {
        return this.hno;
    }

    public void releaseResource() {
        bUm();
        if (this.hnP != null) {
            this.hnP.cancel();
        }
        if (this.hnQ != null) {
            this.hnQ.cancel();
        }
        cea();
        this.hnB.setAlpha(0.0f);
        this.hnI.setText(this.mContext.getResources().getString(a.h.ala_challenge_btn_close_label));
        this.hnz.IT();
        this.hnA.ceh();
        this.hnO = null;
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z = true;
        if (view == this.hnI) {
            if (this.hnJ != null) {
                if (com.baidu.live.ae.a.RB().brA == null || this.hnO == null || this.hnO.aPL != 3 || com.baidu.live.ae.a.RB().brA.aNA != 1) {
                    z = false;
                }
                if (z) {
                    if (this.hnO != null) {
                        this.hnJ.a(this.hnO.aPQ);
                        return;
                    }
                    return;
                }
                this.hnJ.ceb();
            }
        } else if (view == this.hno) {
            if (this.hnJ != null) {
                if (this.hnT) {
                    this.hnJ.cec();
                } else {
                    this.hnJ.d((be) this.hno.getTag());
                }
            }
        } else if (view == this.hnr) {
            if (this.hnJ != null) {
                if (this.hnT) {
                    this.hnJ.cec();
                } else {
                    this.hnJ.e((be) this.hno.getTag());
                }
            }
        } else if (view == this.hnn) {
            if (this.hnJ != null) {
                if (this.hnT) {
                    this.hnJ.cec();
                } else {
                    this.hnJ.f(this.aPI);
                }
            }
        } else if (view == this.hnj) {
            this.hnJ.nx(false);
        } else if (view == this.hns) {
            this.hnJ.nx(true);
        }
    }

    public void setViewClickCallBack(a aVar) {
        this.hnJ = aVar;
    }
}
