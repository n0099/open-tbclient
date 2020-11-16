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
    private bd aMI;
    private bd aMJ;
    private RelativeLayout gKD;
    private CountDownTimer gvC;
    private ChallengeJinzhuView hdA;
    private ChallengeJinzhuView hdB;
    private ChallengeJinzhuView hdC;
    private RelativeLayout hdD;
    private RelativeLayout hdE;
    private HeadImageView hdF;
    private TextView hdG;
    private ImageView hdH;
    private LinearLayout hdI;
    private ChallengeJinzhuView hdJ;
    private ChallengeJinzhuView hdK;
    private ChallengeJinzhuView hdL;
    private RelativeLayout hdM;
    private ImageView hdN;
    private TextView hdO;
    private AlaChallengeMvpTipView hdP;
    private AlaChallengeMvpDynamicAnimView hdQ;
    private LinearLayout hdR;
    private TextView hdS;
    private RelativeLayout hdT;
    private TextView hdU;
    private TextView hdV;
    private View hdW;
    private View hdX;
    private TextView hdY;
    private a hdZ;
    private RelativeLayout hdr;
    private RelativeLayout hds;
    private RelativeLayout hdt;
    private RelativeLayout hdu;
    private RelativeLayout hdv;
    private RelativeLayout hdw;
    private ImageView hdx;
    private TextView hdy;
    private LinearLayout hdz;
    private long hea;
    private long heb;
    private int hec;
    private int hed;
    private az hee;
    private ValueAnimator hef;
    private AnimatorSet heg;
    private List<ax> heh;
    private List<ax> hei;
    public boolean hej;
    private boolean isHost;
    private Context mContext;
    private Handler mHandler;
    private RelativeLayout rootView;
    private int screenWidth;

    /* loaded from: classes4.dex */
    public interface a {
        void a(bv bvVar);

        void caf();

        void cag();

        void d(bd bdVar);

        void e(bd bdVar);

        void f(bd bdVar);

        void nc(boolean z);
    }

    public AlaChallengeLiveView(Context context) {
        super(context);
        this.isHost = false;
        this.hea = -1L;
        this.heb = -1L;
        this.screenWidth = -1;
        this.hec = 0;
        this.hed = 0;
        this.hej = false;
        init(context);
    }

    public AlaChallengeLiveView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isHost = false;
        this.hea = -1L;
        this.heb = -1L;
        this.screenWidth = -1;
        this.hec = 0;
        this.hed = 0;
        this.hej = false;
        init(context);
    }

    public AlaChallengeLiveView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isHost = false;
        this.hea = -1L;
        this.heb = -1L;
        this.screenWidth = -1;
        this.hec = 0;
        this.hed = 0;
        this.hej = false;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.mHandler = new Handler(Looper.getMainLooper());
        dQ(context);
        updateView();
    }

    public void setNeedCloseRecommendFloat(boolean z) {
        this.hej = z;
        this.hdA.setNeedCloseRecommendFloat(this.hej);
        this.hdB.setNeedCloseRecommendFloat(this.hej);
        this.hdC.setNeedCloseRecommendFloat(this.hej);
        this.hdJ.setNeedCloseRecommendFloat(this.hej);
        this.hdK.setNeedCloseRecommendFloat(this.hej);
        this.hdL.setNeedCloseRecommendFloat(this.hej);
    }

    public void setIsHost(boolean z) {
        this.isHost = z;
    }

    private void dQ(Context context) {
        this.rootView = (RelativeLayout) View.inflate(context, a.g.ala_challenge_panel_optation_view, this);
        this.gKD = (RelativeLayout) this.rootView.findViewById(a.f.root_container);
        this.hds = (RelativeLayout) this.rootView.findViewById(a.f.anchor_live_anim_layout);
        this.hdt = (RelativeLayout) this.rootView.findViewById(a.f.rival_live_anim_layout);
        this.hdr = (RelativeLayout) this.rootView.findViewById(a.f.pk_live_container);
        this.hdv = (RelativeLayout) this.rootView.findViewById(a.f.pk_anchor_live_layout);
        this.hdw = (RelativeLayout) this.rootView.findViewById(a.f.anchor_streak_win_layout);
        this.hdx = (ImageView) this.rootView.findViewById(a.f.anchor_user_pk_streak_img);
        this.hdy = (TextView) this.rootView.findViewById(a.f.anchor_user_pk_streak_time);
        this.hdu = (RelativeLayout) this.rootView.findViewById(a.f.jinzhu_container);
        this.hdz = (LinearLayout) this.rootView.findViewById(a.f.anchor_jinzhu_layout);
        this.hdA = (ChallengeJinzhuView) this.rootView.findViewById(a.f.anchor_jinzhu_1);
        this.hdB = (ChallengeJinzhuView) this.rootView.findViewById(a.f.anchor_jinzhu_2);
        this.hdC = (ChallengeJinzhuView) this.rootView.findViewById(a.f.anchor_jinzhu_3);
        this.hdD = (RelativeLayout) this.rootView.findViewById(a.f.pk_rival_live_layout);
        this.hdE = (RelativeLayout) this.rootView.findViewById(a.f.pk_rival_user_layout);
        this.hdF = (HeadImageView) this.rootView.findViewById(a.f.ala_live_rival_user_image);
        this.hdG = (TextView) this.rootView.findViewById(a.f.ala_live_rival_user_name);
        this.hdH = (ImageView) this.rootView.findViewById(a.f.iv_rival_user_follow);
        this.hdM = (RelativeLayout) this.rootView.findViewById(a.f.rival_streak_win_layout);
        this.hdI = (LinearLayout) this.rootView.findViewById(a.f.rival_jinzhu_layout);
        this.hdJ = (ChallengeJinzhuView) this.rootView.findViewById(a.f.rival_jinzhu_1);
        this.hdK = (ChallengeJinzhuView) this.rootView.findViewById(a.f.rival_jinzhu_2);
        this.hdL = (ChallengeJinzhuView) this.rootView.findViewById(a.f.rival_jinzhu_3);
        this.hdN = (ImageView) this.rootView.findViewById(a.f.rival_user_pk_streak_img);
        this.hdO = (TextView) this.rootView.findViewById(a.f.rival_user_pk_streak_time);
        this.hdR = (LinearLayout) this.rootView.findViewById(a.f.pk_time_layout);
        this.hdS = (TextView) this.rootView.findViewById(a.f.pk_time_label);
        this.hdT = (RelativeLayout) this.rootView.findViewById(a.f.pk_score_progress_layout);
        this.hdU = (TextView) this.rootView.findViewById(a.f.pk_anchor_progress);
        this.hdV = (TextView) this.rootView.findViewById(a.f.pk_rival_progress);
        this.hdY = (TextView) this.rootView.findViewById(a.f.btn_close_challenge_view);
        this.hdW = this.rootView.findViewById(a.f.anchor_progress_bg);
        this.hdX = this.rootView.findViewById(a.f.rival_progress_bg);
        this.hdP = (AlaChallengeMvpTipView) this.rootView.findViewById(a.f.id_chellenge_mvp_tip);
        this.hdQ = (AlaChallengeMvpDynamicAnimView) this.rootView.findViewById(a.f.id_challenge_mvp_anim_view);
        this.hdE.setVisibility(0);
        this.hdE.setBackgroundResource(a.e.sdk_round_host_header_bg);
        this.hdF.setIsRound(true);
        this.hdF.setAutoChangeStyle(false);
        this.hdF.setDefaultBgResource(a.e.sdk_icon_default_avatar100_bg);
        this.hdF.setIsNight(false);
        this.hdE.setOnClickListener(this);
        this.hdH.setOnClickListener(this);
        this.hdY.setOnClickListener(this);
        this.hdz.setVisibility(8);
        this.hdI.setVisibility(8);
        this.hdz.setOnClickListener(this);
        this.hdI.setOnClickListener(this);
    }

    private void updateView() {
        this.hed = h.aD(this.mContext);
        this.hec = this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds50);
        this.screenWidth = BdUtilHelper.getScreenDimensions(this.mContext)[0];
        int aG = h.aG(this.mContext);
        int aF = h.aF(this.mContext);
        ViewGroup.LayoutParams layoutParams = this.hdT.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            layoutParams.height = h.bEV;
            ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = h.aC(this.mContext);
            this.hdT.setLayoutParams(layoutParams);
        }
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams2.topMargin = this.hed;
        layoutParams2.height = aF;
        this.hdr.setLayoutParams(layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.hdQ.getLayoutParams();
        layoutParams3.topMargin = this.hed;
        this.hdQ.setLayoutParams(layoutParams3);
        ViewGroup.LayoutParams layoutParams4 = this.hdv.getLayoutParams();
        if (layoutParams4 != null) {
            layoutParams4.width = aG;
            layoutParams4.height = aF;
            this.hdv.setLayoutParams(layoutParams4);
        }
        ViewGroup.LayoutParams layoutParams5 = this.hdD.getLayoutParams();
        if (layoutParams5 != null) {
            layoutParams5.width = aG;
            layoutParams5.height = aF;
            this.hdD.setLayoutParams(layoutParams5);
        }
        RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(aG, aF);
        layoutParams6.topMargin = this.hed;
        this.hdt.setLayoutParams(layoutParams6);
        RelativeLayout.LayoutParams layoutParams7 = (RelativeLayout.LayoutParams) this.hdR.getLayoutParams();
        layoutParams7.topMargin = this.hed;
        layoutParams7.addRule(14);
        this.hdR.setLayoutParams(layoutParams7);
        this.hdT.setAlpha(0.0f);
        int paddingLeft = (((((aG * 2) - this.hdu.getPaddingLeft()) - this.hdu.getPaddingRight()) - ((getResources().getDimensionPixelOffset(a.d.sdk_ds56) * 3) * 2)) - (getResources().getDimensionPixelOffset(a.d.sdk_ds12) * 4)) - (getResources().getDimensionPixelOffset(a.d.sdk_ds12) * 2);
        ViewGroup.LayoutParams layoutParams8 = this.hdP.getLayoutParams();
        if (layoutParams8 instanceof ViewGroup.MarginLayoutParams) {
            layoutParams8.width = paddingLeft;
            ((ViewGroup.MarginLayoutParams) layoutParams8).bottomMargin = this.hdu.getPaddingBottom();
            this.hdP.setLayoutParams(layoutParams8);
        }
    }

    public View getAnchorAnimLiveLayout() {
        return this.hds;
    }

    public View getRivalAnimLiveLayout() {
        return this.hdt;
    }

    public void setAnchorUserViewBg(bd bdVar) {
    }

    public void setRivalUserViewBg(bd bdVar) {
    }

    public View getLeftTimeView() {
        return this.hdR;
    }

    public ViewGroup getLiveContainerView() {
        return this.hdr;
    }

    public View getScoreProgressLayout() {
        return this.hdT;
    }

    public View getJinzhuLayout() {
        return this.hdu;
    }

    public View getCloseBtnView() {
        return this.hdY;
    }

    public RelativeLayout getContainerView() {
        return this.gKD;
    }

    public void a(az azVar, bd bdVar, bd bdVar2, boolean z) {
        this.aMI = bdVar;
        this.aMJ = bdVar2;
        int i = azVar.aMM;
        a(azVar.challengeId, i, azVar.nowTime, azVar.stageEndTime);
        c(azVar.anchorScore, azVar.rivalScore, z);
        if (z) {
            c(bdVar2);
        }
        if (i == 2) {
            setCloseBtnVisible(true);
            cab();
        } else if (i == 3) {
            boolean z2 = false;
            if (com.baidu.live.aa.a.Ph().bms != null && com.baidu.live.aa.a.Ph().bms.aKF == 1) {
                z2 = true;
            }
            if (z2) {
                this.hdY.setText(this.mContext.getResources().getString(a.h.ala_challenge_btn_close_label_2));
            }
            setCloseBtnVisible(z2);
            bR(azVar.challengeResult, azVar.aMO);
        } else {
            bQB();
            setCloseBtnVisible(false);
            bR(azVar.challengeResult, azVar.aMO);
        }
        a(bdVar.aMZ);
        b(bdVar2.aMZ);
        this.hee = azVar;
    }

    private void a(ay ayVar) {
        ArrayList arrayList;
        if (ayVar == null) {
            this.hdA.setVisibility(8);
            this.hdB.setVisibility(8);
            this.hdC.setVisibility(8);
            return;
        }
        this.hdz.setVisibility(0);
        if (ListUtils.isEmpty(ayVar.aML)) {
            ayVar.aML = this.heh;
        }
        if (ListUtils.isEmpty(ayVar.aML)) {
            this.hdA.setVisibility(0);
            this.hdB.setVisibility(8);
            this.hdC.setVisibility(8);
            this.hdA.a(true, null, ayVar.liveId);
            return;
        }
        this.heh = ayVar.aML;
        this.hdA.setVisibility(8);
        this.hdB.setVisibility(8);
        this.hdC.setVisibility(8);
        if (ayVar.aML.size() > 3) {
            ArrayList arrayList2 = new ArrayList();
            for (int i = 0; i < 3; i++) {
                arrayList2.add(ayVar.aML.get(i));
            }
            arrayList = arrayList2;
        } else {
            arrayList = ayVar.aML;
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            ax axVar = arrayList.get(i2);
            if (axVar != null) {
                if (axVar.Ed() || axVar.isFirst()) {
                    this.hdA.setVisibility(0);
                    this.hdA.a(true, axVar, ayVar.liveId);
                } else if (axVar.rank == 2) {
                    this.hdB.setVisibility(0);
                    this.hdB.a(true, axVar, ayVar.liveId);
                } else if (axVar.rank == 3) {
                    this.hdC.setVisibility(0);
                    this.hdC.a(true, axVar, ayVar.liveId);
                }
            }
        }
    }

    private void b(ay ayVar) {
        List<ax> list;
        if (ayVar == null) {
            this.hdJ.setVisibility(8);
            this.hdK.setVisibility(8);
            this.hdL.setVisibility(8);
            return;
        }
        this.hdI.setVisibility(0);
        if (ListUtils.isEmpty(ayVar.aML)) {
            ayVar.aML = this.hei;
        }
        if (ListUtils.isEmpty(ayVar.aML)) {
            this.hdJ.setVisibility(0);
            this.hdK.setVisibility(8);
            this.hdL.setVisibility(8);
            this.hdJ.a(false, null, ayVar.liveId);
            return;
        }
        this.hei = ayVar.aML;
        this.hdJ.setVisibility(8);
        this.hdK.setVisibility(8);
        this.hdL.setVisibility(8);
        if (ayVar.aML.size() > 3) {
            list = ayVar.aML.subList(0, 3);
        } else {
            list = ayVar.aML;
        }
        for (int i = 0; i < list.size(); i++) {
            ax axVar = list.get(i);
            if (axVar != null) {
                if (axVar.Ed() || axVar.isFirst()) {
                    this.hdJ.setVisibility(0);
                    this.hdJ.a(false, axVar, ayVar.liveId);
                } else if (axVar.rank == 2) {
                    this.hdK.setVisibility(0);
                    this.hdK.a(false, axVar, ayVar.liveId);
                } else if (axVar.rank == 3) {
                    this.hdL.setVisibility(0);
                    this.hdL.a(false, axVar, ayVar.liveId);
                }
            }
        }
    }

    private void a(long j, int i, long j2, long j3) {
        if (j3 >= j2 && a(j, i, j3)) {
            bQB();
            if (this.hee != null) {
                v(this.hee.aMM, (j3 - j2) * 1000);
            }
            this.gvC = new CountDownTimer((j3 - j2) * 1000, 1000L) { // from class: com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeLiveView.1
                @Override // android.os.CountDownTimer
                public void onTick(long j4) {
                    if (AlaChallengeLiveView.this.hee != null) {
                        AlaChallengeLiveView.this.v(AlaChallengeLiveView.this.hee.aMM, j4);
                    }
                }

                @Override // android.os.CountDownTimer
                public void onFinish() {
                    if (AlaChallengeLiveView.this.hee != null) {
                        AlaChallengeLiveView.this.v(AlaChallengeLiveView.this.hee.aMM, 0L);
                    }
                }
            };
            this.gvC.start();
        }
    }

    private boolean a(long j, int i, long j2) {
        return (this.hee != null && this.hee.challengeId == j && this.hee.aMM == i && this.hee.stageEndTime == j2) ? false : true;
    }

    private void bQB() {
        if (this.gvC != null) {
            this.gvC.cancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(int i, long j) {
        if (this.hdS != null) {
            this.hdS.setCompoundDrawables(null, null, null, null);
            String formatSecondsTime = StringHelper.formatSecondsTime(Math.round(j / 1000.0d));
            String string = this.mContext.getString(a.h.ala_challenge_operate_challenge_time, formatSecondsTime);
            if (i == 2) {
                Drawable drawable = getResources().getDrawable(a.e.icon_challenge_timer_countdown);
                drawable.setBounds(0, 0, getResources().getDimensionPixelOffset(a.d.sdk_ds40), getResources().getDimensionPixelOffset(a.d.sdk_ds40));
                this.hdS.setCompoundDrawablePadding(getResources().getDimensionPixelOffset(a.d.sdk_ds8));
                this.hdS.setCompoundDrawables(drawable, null, null, null);
            } else if (i == 3) {
                formatSecondsTime = this.mContext.getString(a.h.ala_challenge_operate_publish_time, formatSecondsTime);
            } else {
                formatSecondsTime = i == 4 ? this.mContext.getString(a.h.ala_challenge_operate_over_time) : string;
            }
            this.hdS.setText(formatSecondsTime);
        }
    }

    public void setLiveContainerVisible(boolean z) {
        this.hdr.setVisibility(z ? 0 : 4);
    }

    public void setCloseBtnVisible(boolean z) {
        if (this.isHost) {
            this.hdY.setVisibility(z ? 0 : 4);
        } else {
            this.hdY.setVisibility(4);
        }
    }

    public void caa() {
        setCloseBtnVisible(false);
        this.hdY.setText(this.mContext.getResources().getString(a.h.ala_challenge_btn_close_label));
        this.hdP.Hd();
        this.hdQ.cal();
        setLiveContainerVisible(false);
        if (this.heh != null) {
            this.heh.clear();
            this.heh = null;
        }
        if (this.hei != null) {
            this.hei.clear();
            this.hei = null;
        }
        this.hee = null;
    }

    public void bR(int i, int i2) {
        this.hdw.setVisibility(0);
        this.hdM.setVisibility(0);
        this.hdy.setVisibility(4);
        this.hdO.setVisibility(4);
        if (1 == i) {
            this.hdx.setImageResource(a.e.icon_live_vs_win);
            if (i2 >= 2) {
                this.hdy.setVisibility(0);
                this.hdy.setText(this.mContext.getResources().getString(a.h.ala_challenge_streak_win_label, Integer.valueOf(i2)));
            } else {
                this.hdy.setText("");
            }
            this.hdN.setImageResource(a.e.icon_live_vs_lose);
        } else if (3 == i) {
            this.hdx.setImageResource(a.e.icon_live_vs_draw);
            this.hdN.setImageResource(a.e.icon_live_vs_draw);
        } else if (2 == i) {
            this.hdx.setImageResource(a.e.icon_live_vs_lose);
            if (i2 >= 2) {
                this.hdO.setVisibility(0);
                this.hdO.setText(this.mContext.getResources().getString(a.h.ala_challenge_streak_win_label, Integer.valueOf(i2)));
            } else {
                this.hdO.setText("");
            }
            this.hdN.setImageResource(a.e.icon_live_vs_win);
        } else {
            cab();
        }
    }

    public void cab() {
        this.hdw.setVisibility(4);
        this.hdM.setVisibility(4);
    }

    public void cac() {
        if (this.heh != null) {
            this.heh.clear();
            this.heh = null;
        }
        if (this.hei != null) {
            this.hei.clear();
            this.hei = null;
        }
    }

    private ValueAnimator ce(final View view) {
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

    public void cad() {
        this.hdU.setText(String.valueOf(this.hea));
        this.hdV.setText(String.valueOf(this.heb));
        if (this.heg != null) {
            this.heg.cancel();
        }
        this.heg = new AnimatorSet();
        ValueAnimator ce = ce(this.hdU);
        ValueAnimator ce2 = ce(this.hdV);
        if (this.hea != this.heb) {
            this.heg.setStartDelay(500L);
        } else {
            this.heg.setStartDelay(200L);
        }
        this.heg.playTogether(ce, ce2);
        this.heg.start();
    }

    public void cae() {
        this.hdU.setAlpha(0.0f);
        this.hdV.setAlpha(0.0f);
        this.hdU.setText("");
        this.hdV.setText("");
    }

    private void c(long j, long j2, boolean z) {
        int i;
        if (z || this.hea != j || this.heb != j2) {
            this.hea = j;
            this.heb = j2;
            if (z) {
                cae();
            } else {
                this.hdU.setText(String.valueOf(this.hea));
                this.hdV.setText(String.valueOf(this.heb));
            }
            float f = (float) (this.hea + this.heb);
            int i2 = this.screenWidth;
            int i3 = i2 / 2;
            if (z && f != 0.0f) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hdW.getLayoutParams();
                layoutParams.width = i3;
                this.hdW.setLayoutParams(layoutParams);
            }
            if (this.hea != this.heb && f > 0.0f) {
                int i4 = (int) ((((float) this.hea) / f) * i2);
                int i5 = !z ? ((LinearLayout.LayoutParams) this.hdW.getLayoutParams()).width : i3;
                if (i4 < this.hec) {
                    i = this.hec;
                } else {
                    i = i4 > i2 - this.hec ? i2 - this.hec : i4;
                }
                if (this.hef != null) {
                    this.hef.cancel();
                }
                this.hef = ValueAnimator.ofInt(i5, i);
                if (z) {
                    this.hef.setDuration(300L);
                    this.hef.setStartDelay(200L);
                } else {
                    this.hef.setDuration(100L);
                }
                this.hef.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeLiveView.3
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) AlaChallengeLiveView.this.hdW.getLayoutParams();
                        layoutParams2.width = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                        AlaChallengeLiveView.this.hdW.setLayoutParams(layoutParams2);
                    }
                });
                this.hef.start();
                return;
            }
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.hdW.getLayoutParams();
            layoutParams2.width = i3;
            this.hdW.setLayoutParams(layoutParams2);
        }
    }

    public void c(bd bdVar) {
        if (bdVar == null || bdVar.aMK == null) {
            this.hdE.setVisibility(4);
            return;
        }
        this.hdE.setTag(bdVar);
        this.hdF.startLoad(bdVar.aMK.portrait, 12, false, false);
        String str = bdVar.aMK.userName;
        if (TextHelper.getTextLengthWithEmoji(str) > 8) {
            str = TextHelper.subStringWithEmoji(str, 8) + StringHelper.STRING_MORE;
        }
        this.hdG.setText(str);
        this.hdH.setVisibility(8);
    }

    public void nb(boolean z) {
        if (this.hdH != null) {
            this.hdH.setVisibility(z ? 8 : 0);
        }
    }

    public View getRivalUserInfoView() {
        return this.hdE;
    }

    public void releaseResource() {
        bQB();
        if (this.hef != null) {
            this.hef.cancel();
        }
        if (this.heg != null) {
            this.heg.cancel();
        }
        cae();
        this.hdR.setAlpha(0.0f);
        this.hdY.setText(this.mContext.getResources().getString(a.h.ala_challenge_btn_close_label));
        this.hdP.Hd();
        this.hdQ.cal();
        this.hee = null;
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z = true;
        if (view == this.hdY) {
            if (this.hdZ != null) {
                if (com.baidu.live.aa.a.Ph().bms == null || this.hee == null || this.hee.aMM != 3 || com.baidu.live.aa.a.Ph().bms.aKF != 1) {
                    z = false;
                }
                if (z) {
                    if (this.hee != null) {
                        this.hdZ.a(this.hee.aMR);
                        return;
                    }
                    return;
                }
                this.hdZ.caf();
            }
        } else if (view == this.hdE) {
            if (this.hdZ != null) {
                if (this.hej) {
                    this.hdZ.cag();
                } else {
                    this.hdZ.d((bd) this.hdE.getTag());
                }
            }
        } else if (view == this.hdH) {
            if (this.hdZ != null) {
                if (this.hej) {
                    this.hdZ.cag();
                } else {
                    this.hdZ.e((bd) this.hdE.getTag());
                }
            }
        } else if (view == this.hdD) {
            if (this.hdZ != null) {
                if (this.hej) {
                    this.hdZ.cag();
                } else {
                    this.hdZ.f(this.aMJ);
                }
            }
        } else if (view == this.hdz) {
            this.hdZ.nc(false);
        } else if (view == this.hdI) {
            this.hdZ.nc(true);
        }
    }

    public void setViewClickCallBack(a aVar) {
        this.hdZ = aVar;
    }
}
