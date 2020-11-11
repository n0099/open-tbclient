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
import com.baidu.live.data.ax;
import com.baidu.live.data.ay;
import com.baidu.live.data.az;
import com.baidu.live.data.bd;
import com.baidu.live.data.bv;
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
    private bd aOt;
    private bd aOu;
    private RelativeLayout gKW;
    private CountDownTimer gvV;
    private RelativeLayout hdK;
    private RelativeLayout hdL;
    private RelativeLayout hdM;
    private RelativeLayout hdN;
    private RelativeLayout hdO;
    private RelativeLayout hdP;
    private ImageView hdQ;
    private TextView hdR;
    private LinearLayout hdS;
    private ChallengeJinzhuView hdT;
    private ChallengeJinzhuView hdU;
    private ChallengeJinzhuView hdV;
    private RelativeLayout hdW;
    private RelativeLayout hdX;
    private HeadImageView hdY;
    private TextView hdZ;
    private List<ax> heA;
    private List<ax> heB;
    public boolean heC;
    private ImageView hea;
    private LinearLayout heb;
    private ChallengeJinzhuView hec;
    private ChallengeJinzhuView hed;
    private ChallengeJinzhuView hee;
    private RelativeLayout hef;
    private ImageView heg;
    private TextView heh;
    private AlaChallengeMvpTipView hei;
    private AlaChallengeMvpDynamicAnimView hej;
    private LinearLayout hek;
    private TextView hel;
    private RelativeLayout hem;
    private TextView hen;
    private TextView heo;
    private View hep;
    private View heq;
    private TextView her;
    private a hes;
    private long het;
    private long heu;
    private int hev;
    private int hew;
    private az hex;
    private ValueAnimator hey;
    private AnimatorSet hez;
    private boolean isHost;
    private Context mContext;
    private Handler mHandler;
    private RelativeLayout rootView;
    private int screenWidth;

    /* loaded from: classes4.dex */
    public interface a {
        void a(bv bvVar);

        void caM();

        void caN();

        void d(bd bdVar);

        void e(bd bdVar);

        void f(bd bdVar);

        void nb(boolean z);
    }

    public AlaChallengeLiveView(Context context) {
        super(context);
        this.isHost = false;
        this.het = -1L;
        this.heu = -1L;
        this.screenWidth = -1;
        this.hev = 0;
        this.hew = 0;
        this.heC = false;
        init(context);
    }

    public AlaChallengeLiveView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isHost = false;
        this.het = -1L;
        this.heu = -1L;
        this.screenWidth = -1;
        this.hev = 0;
        this.hew = 0;
        this.heC = false;
        init(context);
    }

    public AlaChallengeLiveView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isHost = false;
        this.het = -1L;
        this.heu = -1L;
        this.screenWidth = -1;
        this.hev = 0;
        this.hew = 0;
        this.heC = false;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.mHandler = new Handler(Looper.getMainLooper());
        dQ(context);
        updateView();
    }

    public void setNeedCloseRecommendFloat(boolean z) {
        this.heC = z;
        this.hdT.setNeedCloseRecommendFloat(this.heC);
        this.hdU.setNeedCloseRecommendFloat(this.heC);
        this.hdV.setNeedCloseRecommendFloat(this.heC);
        this.hec.setNeedCloseRecommendFloat(this.heC);
        this.hed.setNeedCloseRecommendFloat(this.heC);
        this.hee.setNeedCloseRecommendFloat(this.heC);
    }

    public void setIsHost(boolean z) {
        this.isHost = z;
    }

    private void dQ(Context context) {
        this.rootView = (RelativeLayout) View.inflate(context, a.g.ala_challenge_panel_optation_view, this);
        this.gKW = (RelativeLayout) this.rootView.findViewById(a.f.root_container);
        this.hdL = (RelativeLayout) this.rootView.findViewById(a.f.anchor_live_anim_layout);
        this.hdM = (RelativeLayout) this.rootView.findViewById(a.f.rival_live_anim_layout);
        this.hdK = (RelativeLayout) this.rootView.findViewById(a.f.pk_live_container);
        this.hdO = (RelativeLayout) this.rootView.findViewById(a.f.pk_anchor_live_layout);
        this.hdP = (RelativeLayout) this.rootView.findViewById(a.f.anchor_streak_win_layout);
        this.hdQ = (ImageView) this.rootView.findViewById(a.f.anchor_user_pk_streak_img);
        this.hdR = (TextView) this.rootView.findViewById(a.f.anchor_user_pk_streak_time);
        this.hdN = (RelativeLayout) this.rootView.findViewById(a.f.jinzhu_container);
        this.hdS = (LinearLayout) this.rootView.findViewById(a.f.anchor_jinzhu_layout);
        this.hdT = (ChallengeJinzhuView) this.rootView.findViewById(a.f.anchor_jinzhu_1);
        this.hdU = (ChallengeJinzhuView) this.rootView.findViewById(a.f.anchor_jinzhu_2);
        this.hdV = (ChallengeJinzhuView) this.rootView.findViewById(a.f.anchor_jinzhu_3);
        this.hdW = (RelativeLayout) this.rootView.findViewById(a.f.pk_rival_live_layout);
        this.hdX = (RelativeLayout) this.rootView.findViewById(a.f.pk_rival_user_layout);
        this.hdY = (HeadImageView) this.rootView.findViewById(a.f.ala_live_rival_user_image);
        this.hdZ = (TextView) this.rootView.findViewById(a.f.ala_live_rival_user_name);
        this.hea = (ImageView) this.rootView.findViewById(a.f.iv_rival_user_follow);
        this.hef = (RelativeLayout) this.rootView.findViewById(a.f.rival_streak_win_layout);
        this.heb = (LinearLayout) this.rootView.findViewById(a.f.rival_jinzhu_layout);
        this.hec = (ChallengeJinzhuView) this.rootView.findViewById(a.f.rival_jinzhu_1);
        this.hed = (ChallengeJinzhuView) this.rootView.findViewById(a.f.rival_jinzhu_2);
        this.hee = (ChallengeJinzhuView) this.rootView.findViewById(a.f.rival_jinzhu_3);
        this.heg = (ImageView) this.rootView.findViewById(a.f.rival_user_pk_streak_img);
        this.heh = (TextView) this.rootView.findViewById(a.f.rival_user_pk_streak_time);
        this.hek = (LinearLayout) this.rootView.findViewById(a.f.pk_time_layout);
        this.hel = (TextView) this.rootView.findViewById(a.f.pk_time_label);
        this.hem = (RelativeLayout) this.rootView.findViewById(a.f.pk_score_progress_layout);
        this.hen = (TextView) this.rootView.findViewById(a.f.pk_anchor_progress);
        this.heo = (TextView) this.rootView.findViewById(a.f.pk_rival_progress);
        this.her = (TextView) this.rootView.findViewById(a.f.btn_close_challenge_view);
        this.hep = this.rootView.findViewById(a.f.anchor_progress_bg);
        this.heq = this.rootView.findViewById(a.f.rival_progress_bg);
        this.hei = (AlaChallengeMvpTipView) this.rootView.findViewById(a.f.id_chellenge_mvp_tip);
        this.hej = (AlaChallengeMvpDynamicAnimView) this.rootView.findViewById(a.f.id_challenge_mvp_anim_view);
        this.hdX.setVisibility(0);
        this.hdX.setBackgroundResource(a.e.sdk_round_host_header_bg);
        this.hdY.setIsRound(true);
        this.hdY.setAutoChangeStyle(false);
        this.hdY.setDefaultBgResource(a.e.sdk_icon_default_avatar100_bg);
        this.hdY.setIsNight(false);
        this.hdX.setOnClickListener(this);
        this.hea.setOnClickListener(this);
        this.her.setOnClickListener(this);
        this.hdS.setVisibility(8);
        this.heb.setVisibility(8);
        this.hdS.setOnClickListener(this);
        this.heb.setOnClickListener(this);
    }

    private void updateView() {
        this.hew = h.aD(this.mContext);
        this.hev = this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds50);
        this.screenWidth = BdUtilHelper.getScreenDimensions(this.mContext)[0];
        int aG = h.aG(this.mContext);
        int aF = h.aF(this.mContext);
        ViewGroup.LayoutParams layoutParams = this.hem.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            layoutParams.height = h.bGG;
            ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = h.aC(this.mContext);
            this.hem.setLayoutParams(layoutParams);
        }
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams2.topMargin = this.hew;
        layoutParams2.height = aF;
        this.hdK.setLayoutParams(layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.hej.getLayoutParams();
        layoutParams3.topMargin = this.hew;
        this.hej.setLayoutParams(layoutParams3);
        ViewGroup.LayoutParams layoutParams4 = this.hdO.getLayoutParams();
        if (layoutParams4 != null) {
            layoutParams4.width = aG;
            layoutParams4.height = aF;
            this.hdO.setLayoutParams(layoutParams4);
        }
        ViewGroup.LayoutParams layoutParams5 = this.hdW.getLayoutParams();
        if (layoutParams5 != null) {
            layoutParams5.width = aG;
            layoutParams5.height = aF;
            this.hdW.setLayoutParams(layoutParams5);
        }
        RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(aG, aF);
        layoutParams6.topMargin = this.hew;
        this.hdM.setLayoutParams(layoutParams6);
        RelativeLayout.LayoutParams layoutParams7 = (RelativeLayout.LayoutParams) this.hek.getLayoutParams();
        layoutParams7.topMargin = this.hew;
        layoutParams7.addRule(14);
        this.hek.setLayoutParams(layoutParams7);
        this.hem.setAlpha(0.0f);
        int paddingLeft = (((((aG * 2) - this.hdN.getPaddingLeft()) - this.hdN.getPaddingRight()) - ((getResources().getDimensionPixelOffset(a.d.sdk_ds56) * 3) * 2)) - (getResources().getDimensionPixelOffset(a.d.sdk_ds12) * 4)) - (getResources().getDimensionPixelOffset(a.d.sdk_ds12) * 2);
        ViewGroup.LayoutParams layoutParams8 = this.hei.getLayoutParams();
        if (layoutParams8 instanceof ViewGroup.MarginLayoutParams) {
            layoutParams8.width = paddingLeft;
            ((ViewGroup.MarginLayoutParams) layoutParams8).bottomMargin = this.hdN.getPaddingBottom();
            this.hei.setLayoutParams(layoutParams8);
        }
    }

    public View getAnchorAnimLiveLayout() {
        return this.hdL;
    }

    public View getRivalAnimLiveLayout() {
        return this.hdM;
    }

    public void setAnchorUserViewBg(bd bdVar) {
    }

    public void setRivalUserViewBg(bd bdVar) {
    }

    public View getLeftTimeView() {
        return this.hek;
    }

    public ViewGroup getLiveContainerView() {
        return this.hdK;
    }

    public View getScoreProgressLayout() {
        return this.hem;
    }

    public View getJinzhuLayout() {
        return this.hdN;
    }

    public View getCloseBtnView() {
        return this.her;
    }

    public RelativeLayout getContainerView() {
        return this.gKW;
    }

    public void a(az azVar, bd bdVar, bd bdVar2, boolean z) {
        this.aOt = bdVar;
        this.aOu = bdVar2;
        int i = azVar.aOx;
        a(azVar.challengeId, i, azVar.nowTime, azVar.stageEndTime);
        c(azVar.anchorScore, azVar.rivalScore, z);
        if (z) {
            c(bdVar2);
        }
        if (i == 2) {
            setCloseBtnVisible(true);
            caI();
        } else if (i == 3) {
            boolean z2 = false;
            if (com.baidu.live.aa.a.PQ().bod != null && com.baidu.live.aa.a.PQ().bod.aMq == 1) {
                z2 = true;
            }
            if (z2) {
                this.her.setText(this.mContext.getResources().getString(a.h.ala_challenge_btn_close_label_2));
            }
            setCloseBtnVisible(z2);
            bR(azVar.challengeResult, azVar.aOz);
        } else {
            bRi();
            setCloseBtnVisible(false);
            bR(azVar.challengeResult, azVar.aOz);
        }
        a(bdVar.aOK);
        b(bdVar2.aOK);
        this.hex = azVar;
    }

    private void a(ay ayVar) {
        ArrayList arrayList;
        if (ayVar == null) {
            this.hdT.setVisibility(8);
            this.hdU.setVisibility(8);
            this.hdV.setVisibility(8);
            return;
        }
        this.hdS.setVisibility(0);
        if (ListUtils.isEmpty(ayVar.aOw)) {
            ayVar.aOw = this.heA;
        }
        if (ListUtils.isEmpty(ayVar.aOw)) {
            this.hdT.setVisibility(0);
            this.hdU.setVisibility(8);
            this.hdV.setVisibility(8);
            this.hdT.a(true, null, ayVar.liveId);
            return;
        }
        this.heA = ayVar.aOw;
        this.hdT.setVisibility(8);
        this.hdU.setVisibility(8);
        this.hdV.setVisibility(8);
        if (ayVar.aOw.size() > 3) {
            ArrayList arrayList2 = new ArrayList();
            for (int i = 0; i < 3; i++) {
                arrayList2.add(ayVar.aOw.get(i));
            }
            arrayList = arrayList2;
        } else {
            arrayList = ayVar.aOw;
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            ax axVar = arrayList.get(i2);
            if (axVar != null) {
                if (axVar.EM() || axVar.isFirst()) {
                    this.hdT.setVisibility(0);
                    this.hdT.a(true, axVar, ayVar.liveId);
                } else if (axVar.rank == 2) {
                    this.hdU.setVisibility(0);
                    this.hdU.a(true, axVar, ayVar.liveId);
                } else if (axVar.rank == 3) {
                    this.hdV.setVisibility(0);
                    this.hdV.a(true, axVar, ayVar.liveId);
                }
            }
        }
    }

    private void b(ay ayVar) {
        List<ax> list;
        if (ayVar == null) {
            this.hec.setVisibility(8);
            this.hed.setVisibility(8);
            this.hee.setVisibility(8);
            return;
        }
        this.heb.setVisibility(0);
        if (ListUtils.isEmpty(ayVar.aOw)) {
            ayVar.aOw = this.heB;
        }
        if (ListUtils.isEmpty(ayVar.aOw)) {
            this.hec.setVisibility(0);
            this.hed.setVisibility(8);
            this.hee.setVisibility(8);
            this.hec.a(false, null, ayVar.liveId);
            return;
        }
        this.heB = ayVar.aOw;
        this.hec.setVisibility(8);
        this.hed.setVisibility(8);
        this.hee.setVisibility(8);
        if (ayVar.aOw.size() > 3) {
            list = ayVar.aOw.subList(0, 3);
        } else {
            list = ayVar.aOw;
        }
        for (int i = 0; i < list.size(); i++) {
            ax axVar = list.get(i);
            if (axVar != null) {
                if (axVar.EM() || axVar.isFirst()) {
                    this.hec.setVisibility(0);
                    this.hec.a(false, axVar, ayVar.liveId);
                } else if (axVar.rank == 2) {
                    this.hed.setVisibility(0);
                    this.hed.a(false, axVar, ayVar.liveId);
                } else if (axVar.rank == 3) {
                    this.hee.setVisibility(0);
                    this.hee.a(false, axVar, ayVar.liveId);
                }
            }
        }
    }

    private void a(long j, int i, long j2, long j3) {
        if (j3 >= j2 && a(j, i, j3)) {
            bRi();
            if (this.hex != null) {
                v(this.hex.aOx, (j3 - j2) * 1000);
            }
            this.gvV = new CountDownTimer((j3 - j2) * 1000, 1000L) { // from class: com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeLiveView.1
                @Override // android.os.CountDownTimer
                public void onTick(long j4) {
                    if (AlaChallengeLiveView.this.hex != null) {
                        AlaChallengeLiveView.this.v(AlaChallengeLiveView.this.hex.aOx, j4);
                    }
                }

                @Override // android.os.CountDownTimer
                public void onFinish() {
                    if (AlaChallengeLiveView.this.hex != null) {
                        AlaChallengeLiveView.this.v(AlaChallengeLiveView.this.hex.aOx, 0L);
                    }
                }
            };
            this.gvV.start();
        }
    }

    private boolean a(long j, int i, long j2) {
        return (this.hex != null && this.hex.challengeId == j && this.hex.aOx == i && this.hex.stageEndTime == j2) ? false : true;
    }

    private void bRi() {
        if (this.gvV != null) {
            this.gvV.cancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(int i, long j) {
        if (this.hel != null) {
            this.hel.setCompoundDrawables(null, null, null, null);
            String formatSecondsTime = StringHelper.formatSecondsTime(Math.round(j / 1000.0d));
            String string = this.mContext.getString(a.h.ala_challenge_operate_challenge_time, formatSecondsTime);
            if (i == 2) {
                Drawable drawable = getResources().getDrawable(a.e.icon_challenge_timer_countdown);
                drawable.setBounds(0, 0, getResources().getDimensionPixelOffset(a.d.sdk_ds40), getResources().getDimensionPixelOffset(a.d.sdk_ds40));
                this.hel.setCompoundDrawablePadding(getResources().getDimensionPixelOffset(a.d.sdk_ds8));
                this.hel.setCompoundDrawables(drawable, null, null, null);
            } else if (i == 3) {
                formatSecondsTime = this.mContext.getString(a.h.ala_challenge_operate_publish_time, formatSecondsTime);
            } else {
                formatSecondsTime = i == 4 ? this.mContext.getString(a.h.ala_challenge_operate_over_time) : string;
            }
            this.hel.setText(formatSecondsTime);
        }
    }

    public void setLiveContainerVisible(boolean z) {
        this.hdK.setVisibility(z ? 0 : 4);
    }

    public void setCloseBtnVisible(boolean z) {
        if (this.isHost) {
            this.her.setVisibility(z ? 0 : 4);
        } else {
            this.her.setVisibility(4);
        }
    }

    public void caH() {
        setCloseBtnVisible(false);
        this.her.setText(this.mContext.getResources().getString(a.h.ala_challenge_btn_close_label));
        this.hei.HM();
        this.hej.caS();
        setLiveContainerVisible(false);
        if (this.heA != null) {
            this.heA.clear();
            this.heA = null;
        }
        if (this.heB != null) {
            this.heB.clear();
            this.heB = null;
        }
        this.hex = null;
    }

    public void bR(int i, int i2) {
        this.hdP.setVisibility(0);
        this.hef.setVisibility(0);
        this.hdR.setVisibility(4);
        this.heh.setVisibility(4);
        if (1 == i) {
            this.hdQ.setImageResource(a.e.icon_live_vs_win);
            if (i2 >= 2) {
                this.hdR.setVisibility(0);
                this.hdR.setText(this.mContext.getResources().getString(a.h.ala_challenge_streak_win_label, Integer.valueOf(i2)));
            } else {
                this.hdR.setText("");
            }
            this.heg.setImageResource(a.e.icon_live_vs_lose);
        } else if (3 == i) {
            this.hdQ.setImageResource(a.e.icon_live_vs_draw);
            this.heg.setImageResource(a.e.icon_live_vs_draw);
        } else if (2 == i) {
            this.hdQ.setImageResource(a.e.icon_live_vs_lose);
            if (i2 >= 2) {
                this.heh.setVisibility(0);
                this.heh.setText(this.mContext.getResources().getString(a.h.ala_challenge_streak_win_label, Integer.valueOf(i2)));
            } else {
                this.heh.setText("");
            }
            this.heg.setImageResource(a.e.icon_live_vs_win);
        } else {
            caI();
        }
    }

    public void caI() {
        this.hdP.setVisibility(4);
        this.hef.setVisibility(4);
    }

    public void caJ() {
        if (this.heA != null) {
            this.heA.clear();
            this.heA = null;
        }
        if (this.heB != null) {
            this.heB.clear();
            this.heB = null;
        }
    }

    private ValueAnimator cb(final View view) {
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

    public void caK() {
        this.hen.setText(String.valueOf(this.het));
        this.heo.setText(String.valueOf(this.heu));
        if (this.hez != null) {
            this.hez.cancel();
        }
        this.hez = new AnimatorSet();
        ValueAnimator cb = cb(this.hen);
        ValueAnimator cb2 = cb(this.heo);
        if (this.het != this.heu) {
            this.hez.setStartDelay(500L);
        } else {
            this.hez.setStartDelay(200L);
        }
        this.hez.playTogether(cb, cb2);
        this.hez.start();
    }

    public void caL() {
        this.hen.setAlpha(0.0f);
        this.heo.setAlpha(0.0f);
        this.hen.setText("");
        this.heo.setText("");
    }

    private void c(long j, long j2, boolean z) {
        int i;
        if (z || this.het != j || this.heu != j2) {
            this.het = j;
            this.heu = j2;
            if (z) {
                caL();
            } else {
                this.hen.setText(String.valueOf(this.het));
                this.heo.setText(String.valueOf(this.heu));
            }
            float f = (float) (this.het + this.heu);
            int i2 = this.screenWidth;
            int i3 = i2 / 2;
            if (z && f != 0.0f) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hep.getLayoutParams();
                layoutParams.width = i3;
                this.hep.setLayoutParams(layoutParams);
            }
            if (this.het != this.heu && f > 0.0f) {
                int i4 = (int) ((((float) this.het) / f) * i2);
                int i5 = !z ? ((LinearLayout.LayoutParams) this.hep.getLayoutParams()).width : i3;
                if (i4 < this.hev) {
                    i = this.hev;
                } else {
                    i = i4 > i2 - this.hev ? i2 - this.hev : i4;
                }
                if (this.hey != null) {
                    this.hey.cancel();
                }
                this.hey = ValueAnimator.ofInt(i5, i);
                if (z) {
                    this.hey.setDuration(300L);
                    this.hey.setStartDelay(200L);
                } else {
                    this.hey.setDuration(100L);
                }
                this.hey.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeLiveView.3
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) AlaChallengeLiveView.this.hep.getLayoutParams();
                        layoutParams2.width = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                        AlaChallengeLiveView.this.hep.setLayoutParams(layoutParams2);
                    }
                });
                this.hey.start();
                return;
            }
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.hep.getLayoutParams();
            layoutParams2.width = i3;
            this.hep.setLayoutParams(layoutParams2);
        }
    }

    public void c(bd bdVar) {
        if (bdVar == null || bdVar.aOv == null) {
            this.hdX.setVisibility(4);
            return;
        }
        this.hdX.setTag(bdVar);
        this.hdY.startLoad(bdVar.aOv.portrait, 12, false, false);
        String str = bdVar.aOv.userName;
        if (TextHelper.getTextLengthWithEmoji(str) > 8) {
            str = TextHelper.subStringWithEmoji(str, 8) + StringHelper.STRING_MORE;
        }
        this.hdZ.setText(str);
        this.hea.setVisibility(8);
    }

    public void na(boolean z) {
        if (this.hea != null) {
            this.hea.setVisibility(z ? 8 : 0);
        }
    }

    public View getRivalUserInfoView() {
        return this.hdX;
    }

    public void releaseResource() {
        bRi();
        if (this.hey != null) {
            this.hey.cancel();
        }
        if (this.hez != null) {
            this.hez.cancel();
        }
        caL();
        this.hek.setAlpha(0.0f);
        this.her.setText(this.mContext.getResources().getString(a.h.ala_challenge_btn_close_label));
        this.hei.HM();
        this.hej.caS();
        this.hex = null;
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z = true;
        if (view == this.her) {
            if (this.hes != null) {
                if (com.baidu.live.aa.a.PQ().bod == null || this.hex == null || this.hex.aOx != 3 || com.baidu.live.aa.a.PQ().bod.aMq != 1) {
                    z = false;
                }
                if (z) {
                    if (this.hex != null) {
                        this.hes.a(this.hex.aOC);
                        return;
                    }
                    return;
                }
                this.hes.caM();
            }
        } else if (view == this.hdX) {
            if (this.hes != null) {
                if (this.heC) {
                    this.hes.caN();
                } else {
                    this.hes.d((bd) this.hdX.getTag());
                }
            }
        } else if (view == this.hea) {
            if (this.hes != null) {
                if (this.heC) {
                    this.hes.caN();
                } else {
                    this.hes.e((bd) this.hdX.getTag());
                }
            }
        } else if (view == this.hdW) {
            if (this.hes != null) {
                if (this.heC) {
                    this.hes.caN();
                } else {
                    this.hes.f(this.aOu);
                }
            }
        } else if (view == this.hdS) {
            this.hes.nb(false);
        } else if (view == this.heb) {
            this.hes.nb(true);
        }
    }

    public void setViewClickCallBack(a aVar) {
        this.hes = aVar;
    }
}
