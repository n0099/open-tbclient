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
    private CountDownTimer gEm;
    private RelativeLayout gTP;
    private RelativeLayout hmZ;
    private TextView hnA;
    private RelativeLayout hnB;
    private TextView hnC;
    private TextView hnD;
    private View hnE;
    private View hnF;
    private TextView hnG;
    private a hnH;
    private long hnI;
    private long hnJ;
    private int hnK;
    private int hnL;
    private ba hnM;
    private ValueAnimator hnN;
    private AnimatorSet hnO;
    private List<ay> hnP;
    private List<ay> hnQ;
    public boolean hnR;
    private RelativeLayout hna;
    private RelativeLayout hnb;
    private RelativeLayout hnc;
    private RelativeLayout hnd;
    private RelativeLayout hne;
    private ImageView hnf;
    private TextView hng;
    private LinearLayout hnh;
    private ChallengeJinzhuView hni;
    private ChallengeJinzhuView hnj;
    private ChallengeJinzhuView hnk;
    private RelativeLayout hnl;
    private RelativeLayout hnm;
    private HeadImageView hnn;
    private TextView hno;
    private ImageView hnp;
    private LinearLayout hnq;
    private ChallengeJinzhuView hnr;
    private ChallengeJinzhuView hns;
    private ChallengeJinzhuView hnt;
    private RelativeLayout hnu;
    private ImageView hnv;
    private TextView hnw;
    private AlaChallengeMvpTipView hnx;
    private AlaChallengeMvpDynamicAnimView hny;
    private LinearLayout hnz;
    private boolean isHost;
    private Context mContext;
    private Handler mHandler;
    private RelativeLayout rootView;
    private int screenWidth;

    /* loaded from: classes4.dex */
    public interface a {
        void a(bx bxVar);

        void cea();

        void ceb();

        void d(be beVar);

        void e(be beVar);

        void f(be beVar);

        void nx(boolean z);
    }

    public AlaChallengeLiveView(Context context) {
        super(context);
        this.isHost = false;
        this.hnI = -1L;
        this.hnJ = -1L;
        this.screenWidth = -1;
        this.hnK = 0;
        this.hnL = 0;
        this.hnR = false;
        init(context);
    }

    public AlaChallengeLiveView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isHost = false;
        this.hnI = -1L;
        this.hnJ = -1L;
        this.screenWidth = -1;
        this.hnK = 0;
        this.hnL = 0;
        this.hnR = false;
        init(context);
    }

    public AlaChallengeLiveView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isHost = false;
        this.hnI = -1L;
        this.hnJ = -1L;
        this.screenWidth = -1;
        this.hnK = 0;
        this.hnL = 0;
        this.hnR = false;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.mHandler = new Handler(Looper.getMainLooper());
        ev(context);
        updateView();
    }

    public void setNeedCloseRecommendFloat(boolean z) {
        this.hnR = z;
        this.hni.setNeedCloseRecommendFloat(this.hnR);
        this.hnj.setNeedCloseRecommendFloat(this.hnR);
        this.hnk.setNeedCloseRecommendFloat(this.hnR);
        this.hnr.setNeedCloseRecommendFloat(this.hnR);
        this.hns.setNeedCloseRecommendFloat(this.hnR);
        this.hnt.setNeedCloseRecommendFloat(this.hnR);
    }

    public void setIsHost(boolean z) {
        this.isHost = z;
    }

    private void ev(Context context) {
        this.rootView = (RelativeLayout) View.inflate(context, a.g.ala_challenge_panel_optation_view, this);
        this.gTP = (RelativeLayout) this.rootView.findViewById(a.f.root_container);
        this.hna = (RelativeLayout) this.rootView.findViewById(a.f.anchor_live_anim_layout);
        this.hnb = (RelativeLayout) this.rootView.findViewById(a.f.rival_live_anim_layout);
        this.hmZ = (RelativeLayout) this.rootView.findViewById(a.f.pk_live_container);
        this.hnd = (RelativeLayout) this.rootView.findViewById(a.f.pk_anchor_live_layout);
        this.hne = (RelativeLayout) this.rootView.findViewById(a.f.anchor_streak_win_layout);
        this.hnf = (ImageView) this.rootView.findViewById(a.f.anchor_user_pk_streak_img);
        this.hng = (TextView) this.rootView.findViewById(a.f.anchor_user_pk_streak_time);
        this.hnc = (RelativeLayout) this.rootView.findViewById(a.f.jinzhu_container);
        this.hnh = (LinearLayout) this.rootView.findViewById(a.f.anchor_jinzhu_layout);
        this.hni = (ChallengeJinzhuView) this.rootView.findViewById(a.f.anchor_jinzhu_1);
        this.hnj = (ChallengeJinzhuView) this.rootView.findViewById(a.f.anchor_jinzhu_2);
        this.hnk = (ChallengeJinzhuView) this.rootView.findViewById(a.f.anchor_jinzhu_3);
        this.hnl = (RelativeLayout) this.rootView.findViewById(a.f.pk_rival_live_layout);
        this.hnm = (RelativeLayout) this.rootView.findViewById(a.f.pk_rival_user_layout);
        this.hnn = (HeadImageView) this.rootView.findViewById(a.f.ala_live_rival_user_image);
        this.hno = (TextView) this.rootView.findViewById(a.f.ala_live_rival_user_name);
        this.hnp = (ImageView) this.rootView.findViewById(a.f.iv_rival_user_follow);
        this.hnu = (RelativeLayout) this.rootView.findViewById(a.f.rival_streak_win_layout);
        this.hnq = (LinearLayout) this.rootView.findViewById(a.f.rival_jinzhu_layout);
        this.hnr = (ChallengeJinzhuView) this.rootView.findViewById(a.f.rival_jinzhu_1);
        this.hns = (ChallengeJinzhuView) this.rootView.findViewById(a.f.rival_jinzhu_2);
        this.hnt = (ChallengeJinzhuView) this.rootView.findViewById(a.f.rival_jinzhu_3);
        this.hnv = (ImageView) this.rootView.findViewById(a.f.rival_user_pk_streak_img);
        this.hnw = (TextView) this.rootView.findViewById(a.f.rival_user_pk_streak_time);
        this.hnz = (LinearLayout) this.rootView.findViewById(a.f.pk_time_layout);
        this.hnA = (TextView) this.rootView.findViewById(a.f.pk_time_label);
        this.hnB = (RelativeLayout) this.rootView.findViewById(a.f.pk_score_progress_layout);
        this.hnC = (TextView) this.rootView.findViewById(a.f.pk_anchor_progress);
        this.hnD = (TextView) this.rootView.findViewById(a.f.pk_rival_progress);
        this.hnG = (TextView) this.rootView.findViewById(a.f.btn_close_challenge_view);
        this.hnE = this.rootView.findViewById(a.f.anchor_progress_bg);
        this.hnF = this.rootView.findViewById(a.f.rival_progress_bg);
        this.hnx = (AlaChallengeMvpTipView) this.rootView.findViewById(a.f.id_chellenge_mvp_tip);
        this.hny = (AlaChallengeMvpDynamicAnimView) this.rootView.findViewById(a.f.id_challenge_mvp_anim_view);
        this.hnm.setVisibility(0);
        this.hnm.setBackgroundResource(a.e.sdk_round_host_header_bg);
        this.hnn.setIsRound(true);
        this.hnn.setAutoChangeStyle(false);
        this.hnn.setDefaultBgResource(a.e.sdk_icon_default_avatar100_bg);
        this.hnn.setIsNight(false);
        this.hnm.setOnClickListener(this);
        this.hnp.setOnClickListener(this);
        this.hnG.setOnClickListener(this);
        this.hnh.setVisibility(8);
        this.hnq.setVisibility(8);
        this.hnh.setOnClickListener(this);
        this.hnq.setOnClickListener(this);
    }

    private void updateView() {
        this.hnL = h.bh(this.mContext);
        this.hnK = this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds50);
        this.screenWidth = BdUtilHelper.getScreenDimensions(this.mContext)[0];
        int bk = h.bk(this.mContext);
        int bj = h.bj(this.mContext);
        ViewGroup.LayoutParams layoutParams = this.hnB.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            layoutParams.height = h.bKe;
            ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = h.bg(this.mContext);
            this.hnB.setLayoutParams(layoutParams);
        }
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams2.topMargin = this.hnL;
        layoutParams2.height = bj;
        this.hmZ.setLayoutParams(layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.hny.getLayoutParams();
        layoutParams3.topMargin = this.hnL;
        this.hny.setLayoutParams(layoutParams3);
        ViewGroup.LayoutParams layoutParams4 = this.hnd.getLayoutParams();
        if (layoutParams4 != null) {
            layoutParams4.width = bk;
            layoutParams4.height = bj;
            this.hnd.setLayoutParams(layoutParams4);
        }
        ViewGroup.LayoutParams layoutParams5 = this.hnl.getLayoutParams();
        if (layoutParams5 != null) {
            layoutParams5.width = bk;
            layoutParams5.height = bj;
            this.hnl.setLayoutParams(layoutParams5);
        }
        RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(bk, bj);
        layoutParams6.topMargin = this.hnL;
        this.hnb.setLayoutParams(layoutParams6);
        RelativeLayout.LayoutParams layoutParams7 = (RelativeLayout.LayoutParams) this.hnz.getLayoutParams();
        layoutParams7.topMargin = this.hnL;
        layoutParams7.addRule(14);
        this.hnz.setLayoutParams(layoutParams7);
        this.hnB.setAlpha(0.0f);
        int paddingLeft = (((((bk * 2) - this.hnc.getPaddingLeft()) - this.hnc.getPaddingRight()) - ((getResources().getDimensionPixelOffset(a.d.sdk_ds56) * 3) * 2)) - (getResources().getDimensionPixelOffset(a.d.sdk_ds12) * 4)) - (getResources().getDimensionPixelOffset(a.d.sdk_ds12) * 2);
        ViewGroup.LayoutParams layoutParams8 = this.hnx.getLayoutParams();
        if (layoutParams8 instanceof ViewGroup.MarginLayoutParams) {
            layoutParams8.width = paddingLeft;
            ((ViewGroup.MarginLayoutParams) layoutParams8).bottomMargin = this.hnc.getPaddingBottom();
            this.hnx.setLayoutParams(layoutParams8);
        }
    }

    public View getAnchorAnimLiveLayout() {
        return this.hna;
    }

    public View getRivalAnimLiveLayout() {
        return this.hnb;
    }

    public void setAnchorUserViewBg(be beVar) {
    }

    public void setRivalUserViewBg(be beVar) {
    }

    public View getLeftTimeView() {
        return this.hnz;
    }

    public ViewGroup getLiveContainerView() {
        return this.hmZ;
    }

    public View getScoreProgressLayout() {
        return this.hnB;
    }

    public View getJinzhuLayout() {
        return this.hnc;
    }

    public View getCloseBtnView() {
        return this.hnG;
    }

    public RelativeLayout getContainerView() {
        return this.gTP;
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
            cdW();
        } else if (i == 3) {
            boolean z2 = false;
            if (com.baidu.live.ae.a.RB().brA != null && com.baidu.live.ae.a.RB().brA.aNA == 1) {
                z2 = true;
            }
            if (z2) {
                this.hnG.setText(this.mContext.getResources().getString(a.h.ala_challenge_btn_close_label_2));
            }
            setCloseBtnVisible(z2);
            bV(baVar.challengeResult, baVar.aPN);
        } else {
            bUl();
            setCloseBtnVisible(false);
            bV(baVar.challengeResult, baVar.aPN);
        }
        a(beVar.aPY);
        b(beVar2.aPY);
        this.hnM = baVar;
    }

    private void a(az azVar) {
        ArrayList arrayList;
        if (azVar == null) {
            this.hni.setVisibility(8);
            this.hnj.setVisibility(8);
            this.hnk.setVisibility(8);
            return;
        }
        this.hnh.setVisibility(0);
        if (ListUtils.isEmpty(azVar.aPK)) {
            azVar.aPK = this.hnP;
        }
        if (ListUtils.isEmpty(azVar.aPK)) {
            this.hni.setVisibility(0);
            this.hnj.setVisibility(8);
            this.hnk.setVisibility(8);
            this.hni.a(true, null, azVar.liveId);
            return;
        }
        this.hnP = azVar.aPK;
        this.hni.setVisibility(8);
        this.hnj.setVisibility(8);
        this.hnk.setVisibility(8);
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
                    this.hni.setVisibility(0);
                    this.hni.a(true, ayVar, azVar.liveId);
                } else if (ayVar.rank == 2) {
                    this.hnj.setVisibility(0);
                    this.hnj.a(true, ayVar, azVar.liveId);
                } else if (ayVar.rank == 3) {
                    this.hnk.setVisibility(0);
                    this.hnk.a(true, ayVar, azVar.liveId);
                }
            }
        }
    }

    private void b(az azVar) {
        List<ay> list;
        if (azVar == null) {
            this.hnr.setVisibility(8);
            this.hns.setVisibility(8);
            this.hnt.setVisibility(8);
            return;
        }
        this.hnq.setVisibility(0);
        if (ListUtils.isEmpty(azVar.aPK)) {
            azVar.aPK = this.hnQ;
        }
        if (ListUtils.isEmpty(azVar.aPK)) {
            this.hnr.setVisibility(0);
            this.hns.setVisibility(8);
            this.hnt.setVisibility(8);
            this.hnr.a(false, null, azVar.liveId);
            return;
        }
        this.hnQ = azVar.aPK;
        this.hnr.setVisibility(8);
        this.hns.setVisibility(8);
        this.hnt.setVisibility(8);
        if (azVar.aPK.size() > 3) {
            list = azVar.aPK.subList(0, 3);
        } else {
            list = azVar.aPK;
        }
        for (int i = 0; i < list.size(); i++) {
            ay ayVar = list.get(i);
            if (ayVar != null) {
                if (ayVar.FO() || ayVar.isFirst()) {
                    this.hnr.setVisibility(0);
                    this.hnr.a(false, ayVar, azVar.liveId);
                } else if (ayVar.rank == 2) {
                    this.hns.setVisibility(0);
                    this.hns.a(false, ayVar, azVar.liveId);
                } else if (ayVar.rank == 3) {
                    this.hnt.setVisibility(0);
                    this.hnt.a(false, ayVar, azVar.liveId);
                }
            }
        }
    }

    private void a(long j, int i, long j2, long j3) {
        if (j3 >= j2 && a(j, i, j3)) {
            bUl();
            if (this.hnM != null) {
                v(this.hnM.aPL, (j3 - j2) * 1000);
            }
            this.gEm = new CountDownTimer((j3 - j2) * 1000, 1000L) { // from class: com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeLiveView.1
                @Override // android.os.CountDownTimer
                public void onTick(long j4) {
                    if (AlaChallengeLiveView.this.hnM != null) {
                        AlaChallengeLiveView.this.v(AlaChallengeLiveView.this.hnM.aPL, j4);
                    }
                }

                @Override // android.os.CountDownTimer
                public void onFinish() {
                    if (AlaChallengeLiveView.this.hnM != null) {
                        AlaChallengeLiveView.this.v(AlaChallengeLiveView.this.hnM.aPL, 0L);
                    }
                }
            };
            this.gEm.start();
        }
    }

    private boolean a(long j, int i, long j2) {
        return (this.hnM != null && this.hnM.challengeId == j && this.hnM.aPL == i && this.hnM.stageEndTime == j2) ? false : true;
    }

    private void bUl() {
        if (this.gEm != null) {
            this.gEm.cancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(int i, long j) {
        if (this.hnA != null) {
            this.hnA.setCompoundDrawables(null, null, null, null);
            String formatSecondsTime = StringHelper.formatSecondsTime(Math.round(j / 1000.0d));
            String string = this.mContext.getString(a.h.ala_challenge_operate_challenge_time, formatSecondsTime);
            if (i == 2) {
                Drawable drawable = getResources().getDrawable(a.e.icon_challenge_timer_countdown);
                drawable.setBounds(0, 0, getResources().getDimensionPixelOffset(a.d.sdk_ds40), getResources().getDimensionPixelOffset(a.d.sdk_ds40));
                this.hnA.setCompoundDrawablePadding(getResources().getDimensionPixelOffset(a.d.sdk_ds8));
                this.hnA.setCompoundDrawables(drawable, null, null, null);
            } else if (i == 3) {
                formatSecondsTime = this.mContext.getString(a.h.ala_challenge_operate_publish_time, formatSecondsTime);
            } else {
                formatSecondsTime = i == 4 ? this.mContext.getString(a.h.ala_challenge_operate_over_time) : string;
            }
            this.hnA.setText(formatSecondsTime);
        }
    }

    public void setLiveContainerVisible(boolean z) {
        this.hmZ.setVisibility(z ? 0 : 4);
    }

    public void setCloseBtnVisible(boolean z) {
        if (this.isHost) {
            this.hnG.setVisibility(z ? 0 : 4);
        } else {
            this.hnG.setVisibility(4);
        }
    }

    public void cdV() {
        setCloseBtnVisible(false);
        this.hnG.setText(this.mContext.getResources().getString(a.h.ala_challenge_btn_close_label));
        this.hnx.IT();
        this.hny.ceg();
        setLiveContainerVisible(false);
        if (this.hnP != null) {
            this.hnP.clear();
            this.hnP = null;
        }
        if (this.hnQ != null) {
            this.hnQ.clear();
            this.hnQ = null;
        }
        this.hnM = null;
    }

    public void bV(int i, int i2) {
        this.hne.setVisibility(0);
        this.hnu.setVisibility(0);
        this.hng.setVisibility(4);
        this.hnw.setVisibility(4);
        if (1 == i) {
            this.hnf.setImageResource(a.e.icon_live_vs_win);
            if (i2 >= 2) {
                this.hng.setVisibility(0);
                this.hng.setText(this.mContext.getResources().getString(a.h.ala_challenge_streak_win_label, Integer.valueOf(i2)));
            } else {
                this.hng.setText("");
            }
            this.hnv.setImageResource(a.e.icon_live_vs_lose);
        } else if (3 == i) {
            this.hnf.setImageResource(a.e.icon_live_vs_draw);
            this.hnv.setImageResource(a.e.icon_live_vs_draw);
        } else if (2 == i) {
            this.hnf.setImageResource(a.e.icon_live_vs_lose);
            if (i2 >= 2) {
                this.hnw.setVisibility(0);
                this.hnw.setText(this.mContext.getResources().getString(a.h.ala_challenge_streak_win_label, Integer.valueOf(i2)));
            } else {
                this.hnw.setText("");
            }
            this.hnv.setImageResource(a.e.icon_live_vs_win);
        } else {
            cdW();
        }
    }

    public void cdW() {
        this.hne.setVisibility(4);
        this.hnu.setVisibility(4);
    }

    public void cdX() {
        if (this.hnP != null) {
            this.hnP.clear();
            this.hnP = null;
        }
        if (this.hnQ != null) {
            this.hnQ.clear();
            this.hnQ = null;
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

    public void cdY() {
        this.hnC.setText(String.valueOf(this.hnI));
        this.hnD.setText(String.valueOf(this.hnJ));
        if (this.hnO != null) {
            this.hnO.cancel();
        }
        this.hnO = new AnimatorSet();
        ValueAnimator cl = cl(this.hnC);
        ValueAnimator cl2 = cl(this.hnD);
        if (this.hnI != this.hnJ) {
            this.hnO.setStartDelay(500L);
        } else {
            this.hnO.setStartDelay(200L);
        }
        this.hnO.playTogether(cl, cl2);
        this.hnO.start();
    }

    public void cdZ() {
        this.hnC.setAlpha(0.0f);
        this.hnD.setAlpha(0.0f);
        this.hnC.setText("");
        this.hnD.setText("");
    }

    private void c(long j, long j2, boolean z) {
        int i;
        if (z || this.hnI != j || this.hnJ != j2) {
            this.hnI = j;
            this.hnJ = j2;
            if (z) {
                cdZ();
            } else {
                this.hnC.setText(String.valueOf(this.hnI));
                this.hnD.setText(String.valueOf(this.hnJ));
            }
            float f = (float) (this.hnI + this.hnJ);
            int i2 = this.screenWidth;
            int i3 = i2 / 2;
            if (z && f != 0.0f) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hnE.getLayoutParams();
                layoutParams.width = i3;
                this.hnE.setLayoutParams(layoutParams);
            }
            if (this.hnI != this.hnJ && f > 0.0f) {
                int i4 = (int) ((((float) this.hnI) / f) * i2);
                int i5 = !z ? ((LinearLayout.LayoutParams) this.hnE.getLayoutParams()).width : i3;
                if (i4 < this.hnK) {
                    i = this.hnK;
                } else {
                    i = i4 > i2 - this.hnK ? i2 - this.hnK : i4;
                }
                if (this.hnN != null) {
                    this.hnN.cancel();
                }
                this.hnN = ValueAnimator.ofInt(i5, i);
                if (z) {
                    this.hnN.setDuration(300L);
                    this.hnN.setStartDelay(200L);
                } else {
                    this.hnN.setDuration(100L);
                }
                this.hnN.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeLiveView.3
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) AlaChallengeLiveView.this.hnE.getLayoutParams();
                        layoutParams2.width = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                        AlaChallengeLiveView.this.hnE.setLayoutParams(layoutParams2);
                    }
                });
                this.hnN.start();
                return;
            }
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.hnE.getLayoutParams();
            layoutParams2.width = i3;
            this.hnE.setLayoutParams(layoutParams2);
        }
    }

    public void c(be beVar) {
        if (beVar == null || beVar.aPJ == null) {
            this.hnm.setVisibility(4);
            return;
        }
        this.hnm.setTag(beVar);
        this.hnn.startLoad(beVar.aPJ.portrait, 12, false, false);
        String str = beVar.aPJ.userName;
        if (TextHelper.getTextLengthWithEmoji(str) > 8) {
            str = TextHelper.subStringWithEmoji(str, 8) + StringHelper.STRING_MORE;
        }
        this.hno.setText(str);
        this.hnp.setVisibility(8);
    }

    public void nw(boolean z) {
        if (this.hnp != null) {
            this.hnp.setVisibility(z ? 8 : 0);
        }
    }

    public View getRivalUserInfoView() {
        return this.hnm;
    }

    public void releaseResource() {
        bUl();
        if (this.hnN != null) {
            this.hnN.cancel();
        }
        if (this.hnO != null) {
            this.hnO.cancel();
        }
        cdZ();
        this.hnz.setAlpha(0.0f);
        this.hnG.setText(this.mContext.getResources().getString(a.h.ala_challenge_btn_close_label));
        this.hnx.IT();
        this.hny.ceg();
        this.hnM = null;
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z = true;
        if (view == this.hnG) {
            if (this.hnH != null) {
                if (com.baidu.live.ae.a.RB().brA == null || this.hnM == null || this.hnM.aPL != 3 || com.baidu.live.ae.a.RB().brA.aNA != 1) {
                    z = false;
                }
                if (z) {
                    if (this.hnM != null) {
                        this.hnH.a(this.hnM.aPQ);
                        return;
                    }
                    return;
                }
                this.hnH.cea();
            }
        } else if (view == this.hnm) {
            if (this.hnH != null) {
                if (this.hnR) {
                    this.hnH.ceb();
                } else {
                    this.hnH.d((be) this.hnm.getTag());
                }
            }
        } else if (view == this.hnp) {
            if (this.hnH != null) {
                if (this.hnR) {
                    this.hnH.ceb();
                } else {
                    this.hnH.e((be) this.hnm.getTag());
                }
            }
        } else if (view == this.hnl) {
            if (this.hnH != null) {
                if (this.hnR) {
                    this.hnH.ceb();
                } else {
                    this.hnH.f(this.aPI);
                }
            }
        } else if (view == this.hnh) {
            this.hnH.nx(false);
        } else if (view == this.hnq) {
            this.hnH.nx(true);
        }
    }

    public void setViewClickCallBack(a aVar) {
        this.hnH = aVar;
    }
}
