package com.baidu.tieba.ala.liveroom.challenge.view;

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
import com.baidu.live.data.an;
import com.baidu.live.data.ao;
import com.baidu.live.data.ap;
import com.baidu.live.data.at;
import com.baidu.live.data.bj;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.util.TextHelper;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.live.utils.g;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class AlaChallengeLiveView extends RelativeLayout implements View.OnClickListener {
    private at aIj;
    private at aIk;
    private CountDownTimer fQx;
    private RelativeLayout gtN;
    private RelativeLayout gtO;
    private RelativeLayout gtP;
    private TbImageView gtQ;
    private View gtR;
    private RelativeLayout gtS;
    private TbImageView gtT;
    private View gtU;
    private RelativeLayout gtV;
    private RelativeLayout gtW;
    private RelativeLayout gtX;
    private ImageView gtY;
    private TextView gtZ;
    private a guA;
    private long guB;
    private long guC;
    private int guD;
    private int guE;
    private ap guF;
    private ValueAnimator guG;
    private List<an> guH;
    private List<an> guI;
    public boolean guJ;
    private LinearLayout gua;
    private ChallengeJinzhuView gub;
    private ChallengeJinzhuView guc;
    private ChallengeJinzhuView gud;
    private RelativeLayout gue;
    private RelativeLayout guf;
    private HeadImageView gug;
    private TextView guh;
    private ImageView gui;
    private LinearLayout guj;
    private ChallengeJinzhuView guk;
    private ChallengeJinzhuView gul;
    private ChallengeJinzhuView gum;
    private RelativeLayout gun;
    private ImageView guo;
    private TextView gup;
    private AlaChallengeMvpTipView guq;
    private AlaChallengeMvpDynamicAnimView gur;
    private LinearLayout gus;
    private TextView gut;
    private RelativeLayout guu;
    private TextView guv;
    private TextView guw;
    private View gux;
    private View guy;
    private TextView guz;
    private boolean isHost;
    private Context mContext;
    private Handler mHandler;
    private RelativeLayout rootView;
    private int screenWidth;

    /* loaded from: classes7.dex */
    public interface a {
        void a(bj bjVar);

        void bQu();

        void bQv();

        void d(at atVar);

        void e(at atVar);

        void f(at atVar);

        void lV(boolean z);
    }

    public AlaChallengeLiveView(Context context) {
        super(context);
        this.isHost = false;
        this.guB = -1L;
        this.guC = -1L;
        this.screenWidth = -1;
        this.guD = 0;
        this.guE = 0;
        this.guJ = false;
        init(context);
    }

    public AlaChallengeLiveView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isHost = false;
        this.guB = -1L;
        this.guC = -1L;
        this.screenWidth = -1;
        this.guD = 0;
        this.guE = 0;
        this.guJ = false;
        init(context);
    }

    public AlaChallengeLiveView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isHost = false;
        this.guB = -1L;
        this.guC = -1L;
        this.screenWidth = -1;
        this.guD = 0;
        this.guE = 0;
        this.guJ = false;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.mHandler = new Handler(Looper.getMainLooper());
        dL(context);
        updateView();
    }

    public void setNeedCloseRecommendFloat(boolean z) {
        this.guJ = z;
        this.gub.setNeedCloseRecommendFloat(this.guJ);
        this.guc.setNeedCloseRecommendFloat(this.guJ);
        this.gud.setNeedCloseRecommendFloat(this.guJ);
        this.guk.setNeedCloseRecommendFloat(this.guJ);
        this.gul.setNeedCloseRecommendFloat(this.guJ);
        this.gum.setNeedCloseRecommendFloat(this.guJ);
    }

    public void setIsHost(boolean z) {
        this.isHost = z;
    }

    private void dL(Context context) {
        this.rootView = (RelativeLayout) View.inflate(context, a.h.ala_challenge_panel_optation_view, this);
        this.gtN = (RelativeLayout) this.rootView.findViewById(a.g.root_container);
        this.gtP = (RelativeLayout) this.rootView.findViewById(a.g.anchor_live_anim_layout);
        this.gtQ = (TbImageView) this.rootView.findViewById(a.g.anchor_live_anim_bg);
        this.gtS = (RelativeLayout) this.rootView.findViewById(a.g.rival_live_anim_layout);
        this.gtT = (TbImageView) this.rootView.findViewById(a.g.rival_live_anim_bg);
        this.gtO = (RelativeLayout) this.rootView.findViewById(a.g.pk_live_container);
        this.gtW = (RelativeLayout) this.rootView.findViewById(a.g.pk_anchor_live_layout);
        this.gtX = (RelativeLayout) this.rootView.findViewById(a.g.anchor_streak_win_layout);
        this.gtY = (ImageView) this.rootView.findViewById(a.g.anchor_user_pk_streak_img);
        this.gtZ = (TextView) this.rootView.findViewById(a.g.anchor_user_pk_streak_time);
        this.gtV = (RelativeLayout) this.rootView.findViewById(a.g.jinzhu_container);
        this.gua = (LinearLayout) this.rootView.findViewById(a.g.anchor_jinzhu_layout);
        this.gub = (ChallengeJinzhuView) this.rootView.findViewById(a.g.anchor_jinzhu_1);
        this.guc = (ChallengeJinzhuView) this.rootView.findViewById(a.g.anchor_jinzhu_2);
        this.gud = (ChallengeJinzhuView) this.rootView.findViewById(a.g.anchor_jinzhu_3);
        this.gue = (RelativeLayout) this.rootView.findViewById(a.g.pk_rival_live_layout);
        this.guf = (RelativeLayout) this.rootView.findViewById(a.g.pk_rival_user_layout);
        this.gug = (HeadImageView) this.rootView.findViewById(a.g.ala_live_rival_user_image);
        this.guh = (TextView) this.rootView.findViewById(a.g.ala_live_rival_user_name);
        this.gui = (ImageView) this.rootView.findViewById(a.g.iv_rival_user_follow);
        this.gun = (RelativeLayout) this.rootView.findViewById(a.g.rival_streak_win_layout);
        this.guj = (LinearLayout) this.rootView.findViewById(a.g.rival_jinzhu_layout);
        this.guk = (ChallengeJinzhuView) this.rootView.findViewById(a.g.rival_jinzhu_1);
        this.gul = (ChallengeJinzhuView) this.rootView.findViewById(a.g.rival_jinzhu_2);
        this.gum = (ChallengeJinzhuView) this.rootView.findViewById(a.g.rival_jinzhu_3);
        this.guo = (ImageView) this.rootView.findViewById(a.g.rival_user_pk_streak_img);
        this.gup = (TextView) this.rootView.findViewById(a.g.rival_user_pk_streak_time);
        this.gus = (LinearLayout) this.rootView.findViewById(a.g.pk_time_layout);
        this.gut = (TextView) this.rootView.findViewById(a.g.pk_time_label);
        this.guu = (RelativeLayout) this.rootView.findViewById(a.g.pk_score_progress_layout);
        this.guv = (TextView) this.rootView.findViewById(a.g.pk_anchor_progress);
        this.guw = (TextView) this.rootView.findViewById(a.g.pk_rival_progress);
        this.guz = (TextView) this.rootView.findViewById(a.g.btn_close_challenge_view);
        this.gux = this.rootView.findViewById(a.g.anchor_progress_bg);
        this.guy = this.rootView.findViewById(a.g.rival_progress_bg);
        this.gtR = this.rootView.findViewById(a.g.anchor_live_anim_fore_bg);
        this.gtU = this.rootView.findViewById(a.g.rival_live_anim_fore_bg);
        this.guq = (AlaChallengeMvpTipView) this.rootView.findViewById(a.g.id_chellenge_mvp_tip);
        this.gur = (AlaChallengeMvpDynamicAnimView) this.rootView.findViewById(a.g.id_challenge_mvp_anim_view);
        this.guf.setVisibility(0);
        this.guf.setBackgroundResource(a.f.sdk_round_host_header_bg);
        this.gug.setIsRound(true);
        this.gug.setAutoChangeStyle(false);
        this.gug.setDefaultBgResource(a.f.sdk_icon_default_avatar100_bg);
        this.gug.setIsNight(false);
        this.guf.setOnClickListener(this);
        this.gui.setOnClickListener(this);
        this.guz.setOnClickListener(this);
        this.gua.setVisibility(8);
        this.guj.setVisibility(8);
        this.gua.setOnClickListener(this);
        this.guj.setOnClickListener(this);
    }

    private void updateView() {
        this.guE = g.az(this.mContext);
        this.guD = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds50);
        this.screenWidth = BdUtilHelper.getScreenDimensions(this.mContext)[0];
        int aC = g.aC(this.mContext);
        int aB = g.aB(this.mContext);
        ViewGroup.LayoutParams layoutParams = this.guu.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            layoutParams.height = g.bqt;
            ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = g.ay(this.mContext);
            this.guu.setLayoutParams(layoutParams);
        }
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams2.topMargin = this.guE;
        layoutParams2.height = aB;
        this.gtO.setLayoutParams(layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.gur.getLayoutParams();
        layoutParams3.topMargin = this.guE;
        this.gur.setLayoutParams(layoutParams3);
        ViewGroup.LayoutParams layoutParams4 = this.gtW.getLayoutParams();
        if (layoutParams4 != null) {
            layoutParams4.width = aC;
            layoutParams4.height = aB;
            this.gtW.setLayoutParams(layoutParams4);
        }
        ViewGroup.LayoutParams layoutParams5 = this.gue.getLayoutParams();
        if (layoutParams5 != null) {
            layoutParams5.width = aC;
            layoutParams5.height = aB;
            this.gue.setLayoutParams(layoutParams5);
        }
        RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(aC, aB);
        layoutParams6.addRule(11);
        layoutParams6.topMargin = this.guE;
        this.gtS.setLayoutParams(layoutParams6);
        RelativeLayout.LayoutParams layoutParams7 = (RelativeLayout.LayoutParams) this.gus.getLayoutParams();
        layoutParams7.topMargin = this.guE;
        layoutParams7.addRule(14);
        this.gus.setLayoutParams(layoutParams7);
        this.guu.setAlpha(0.0f);
        int paddingLeft = (((((aC * 2) - this.gtV.getPaddingLeft()) - this.gtV.getPaddingRight()) - ((getResources().getDimensionPixelOffset(a.e.sdk_ds56) * 3) * 2)) - (getResources().getDimensionPixelOffset(a.e.sdk_ds12) * 4)) - (getResources().getDimensionPixelOffset(a.e.sdk_ds12) * 2);
        ViewGroup.LayoutParams layoutParams8 = this.guq.getLayoutParams();
        if (layoutParams8 instanceof ViewGroup.MarginLayoutParams) {
            layoutParams8.width = paddingLeft;
            ((ViewGroup.MarginLayoutParams) layoutParams8).bottomMargin = this.gtV.getPaddingBottom();
            this.guq.setLayoutParams(layoutParams8);
        }
    }

    public View getAnchorAnimLiveLayout() {
        return this.gtP;
    }

    public View getAnchorAnimLiveForeBg() {
        return this.gtR;
    }

    public View getRivalAnimLiveLayout() {
        return this.gtS;
    }

    public View getRivalAnimLiveForeBg() {
        return this.gtU;
    }

    public TbImageView getAnchorAnimLiveBgView() {
        return this.gtQ;
    }

    public void setAnchorUserViewBg(at atVar) {
        this.gtQ.setScaleType(ImageView.ScaleType.FIT_XY);
        String str = "";
        if (atVar.aIl != null) {
            str = atVar.aIl.portrait;
        }
        this.gtQ.startLoad(str, 12, false);
        this.gtQ.setVisibility(0);
    }

    public void setRivalUserViewBg(at atVar) {
        this.gtT.setScaleType(ImageView.ScaleType.FIT_XY);
        String str = "";
        if (atVar.aIl != null) {
            str = atVar.aIl.portrait;
        }
        this.gtT.startLoad(str, 12, false);
    }

    public View getLeftTimeView() {
        return this.gus;
    }

    public ViewGroup getLiveContainerView() {
        return this.gtO;
    }

    public View getScoreProgressLayout() {
        return this.guu;
    }

    public View getJinzhuLayout() {
        return this.gtV;
    }

    public View getCloseBtnView() {
        return this.guz;
    }

    public RelativeLayout getContainerView() {
        return this.gtN;
    }

    public void a(ap apVar, at atVar, at atVar2, boolean z) {
        this.aIj = atVar;
        this.aIk = atVar2;
        int i = apVar.aIn;
        a(apVar.challengeId, i, apVar.aIr, apVar.aIq);
        w(apVar.aIs, apVar.aIt);
        if (z) {
            c(atVar2);
        }
        if (i == 2) {
            setCloseBtnVisible(true);
            bQs();
        } else if (i == 3) {
            boolean z2 = com.baidu.live.w.a.Nk().beH != null && com.baidu.live.w.a.Nk().beH.aGt == 1;
            if (z2) {
                this.guz.setText(this.mContext.getResources().getString(a.i.ala_challenge_btn_close_label_2));
            }
            setCloseBtnVisible(z2);
            bN(apVar.challengeResult, apVar.aIu);
        } else {
            bIn();
            setCloseBtnVisible(false);
            bN(apVar.challengeResult, apVar.aIu);
        }
        a(atVar.aIF);
        b(atVar2.aIF);
        this.guF = apVar;
    }

    private void a(ao aoVar) {
        ArrayList arrayList;
        if (aoVar == null) {
            this.gub.setVisibility(8);
            this.guc.setVisibility(8);
            this.gud.setVisibility(8);
            return;
        }
        this.gua.setVisibility(0);
        if (ListUtils.isEmpty(aoVar.aIm)) {
            aoVar.aIm = this.guH;
        }
        if (ListUtils.isEmpty(aoVar.aIm)) {
            this.gub.setVisibility(0);
            this.guc.setVisibility(8);
            this.gud.setVisibility(8);
            this.gub.a(true, null, aoVar.liveId);
            return;
        }
        this.guH = aoVar.aIm;
        this.gub.setVisibility(8);
        this.guc.setVisibility(8);
        this.gud.setVisibility(8);
        if (aoVar.aIm.size() > 3) {
            ArrayList arrayList2 = new ArrayList();
            for (int i = 0; i < 3; i++) {
                arrayList2.add(aoVar.aIm.get(i));
            }
            arrayList = arrayList2;
        } else {
            arrayList = aoVar.aIm;
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            an anVar = arrayList.get(i2);
            if (anVar != null) {
                if (anVar.CT() || anVar.isFirst()) {
                    this.gub.setVisibility(0);
                    this.gub.a(true, anVar, aoVar.liveId);
                } else if (anVar.rank == 2) {
                    this.guc.setVisibility(0);
                    this.guc.a(true, anVar, aoVar.liveId);
                } else if (anVar.rank == 3) {
                    this.gud.setVisibility(0);
                    this.gud.a(true, anVar, aoVar.liveId);
                }
            }
        }
    }

    private void b(ao aoVar) {
        List<an> list;
        if (aoVar == null) {
            this.guk.setVisibility(8);
            this.gul.setVisibility(8);
            this.gum.setVisibility(8);
            return;
        }
        this.guj.setVisibility(0);
        if (ListUtils.isEmpty(aoVar.aIm)) {
            aoVar.aIm = this.guI;
        }
        if (ListUtils.isEmpty(aoVar.aIm)) {
            this.guk.setVisibility(0);
            this.gul.setVisibility(8);
            this.gum.setVisibility(8);
            this.guk.a(false, null, aoVar.liveId);
            return;
        }
        this.guI = aoVar.aIm;
        this.guk.setVisibility(8);
        this.gul.setVisibility(8);
        this.gum.setVisibility(8);
        if (aoVar.aIm.size() > 3) {
            list = aoVar.aIm.subList(0, 3);
        } else {
            list = aoVar.aIm;
        }
        for (int i = 0; i < list.size(); i++) {
            an anVar = list.get(i);
            if (anVar != null) {
                if (anVar.CT() || anVar.isFirst()) {
                    this.guk.setVisibility(0);
                    this.guk.a(false, anVar, aoVar.liveId);
                } else if (anVar.rank == 2) {
                    this.gul.setVisibility(0);
                    this.gul.a(false, anVar, aoVar.liveId);
                } else if (anVar.rank == 3) {
                    this.gum.setVisibility(0);
                    this.gum.a(false, anVar, aoVar.liveId);
                }
            }
        }
    }

    private void a(long j, int i, long j2, long j3) {
        if (j3 >= j2 && a(j, i, j3)) {
            bIn();
            if (this.guF != null) {
                v(this.guF.aIn, (j3 - j2) * 1000);
            }
            this.fQx = new CountDownTimer((j3 - j2) * 1000, 1000L) { // from class: com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeLiveView.1
                @Override // android.os.CountDownTimer
                public void onTick(long j4) {
                    if (AlaChallengeLiveView.this.guF != null) {
                        AlaChallengeLiveView.this.v(AlaChallengeLiveView.this.guF.aIn, j4);
                    }
                }

                @Override // android.os.CountDownTimer
                public void onFinish() {
                    if (AlaChallengeLiveView.this.guF != null) {
                        AlaChallengeLiveView.this.v(AlaChallengeLiveView.this.guF.aIn, 0L);
                    }
                }
            };
            this.fQx.start();
        }
    }

    private boolean a(long j, int i, long j2) {
        return (this.guF != null && this.guF.challengeId == j && this.guF.aIn == i && this.guF.aIq == j2) ? false : true;
    }

    private void bIn() {
        if (this.fQx != null) {
            this.fQx.cancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(int i, long j) {
        if (this.gut != null) {
            this.gut.setCompoundDrawables(null, null, null, null);
            String formatSecondsTime = StringHelper.formatSecondsTime(Math.round(j / 1000.0d));
            String string = this.mContext.getString(a.i.ala_challenge_operate_challenge_time, formatSecondsTime);
            if (i == 2) {
                Drawable drawable = getResources().getDrawable(a.f.icon_challenge_timer_countdown);
                drawable.setBounds(0, 0, getResources().getDimensionPixelOffset(a.e.sdk_ds40), getResources().getDimensionPixelOffset(a.e.sdk_ds40));
                this.gut.setCompoundDrawablePadding(getResources().getDimensionPixelOffset(a.e.sdk_ds8));
                this.gut.setCompoundDrawables(drawable, null, null, null);
            } else if (i == 3) {
                formatSecondsTime = this.mContext.getString(a.i.ala_challenge_operate_publish_time, formatSecondsTime);
            } else {
                formatSecondsTime = i == 4 ? this.mContext.getString(a.i.ala_challenge_operate_over_time) : string;
            }
            this.gut.setText(formatSecondsTime);
        }
    }

    public void setLiveContainerVisible(boolean z) {
        this.gtO.setVisibility(z ? 0 : 4);
    }

    public void setCloseBtnVisible(boolean z) {
        if (this.isHost) {
            this.guz.setVisibility(z ? 0 : 4);
        } else {
            this.guz.setVisibility(4);
        }
    }

    public void bQr() {
        setCloseBtnVisible(false);
        this.guz.setText(this.mContext.getResources().getString(a.i.ala_challenge_btn_close_label));
        this.guq.Ft();
        this.gur.bQA();
        setLiveContainerVisible(false);
        if (this.guH != null) {
            this.guH.clear();
            this.guH = null;
        }
        if (this.guI != null) {
            this.guI.clear();
            this.guI = null;
        }
        this.guF = null;
    }

    public void bN(int i, int i2) {
        this.gtX.setVisibility(0);
        this.gun.setVisibility(0);
        this.gtZ.setVisibility(4);
        this.gup.setVisibility(4);
        if (1 == i) {
            this.gtY.setImageResource(a.f.icon_live_vs_win);
            if (i2 >= 2) {
                this.gtZ.setVisibility(0);
                this.gtZ.setText(this.mContext.getResources().getString(a.i.ala_challenge_streak_win_label, Integer.valueOf(i2)));
            } else {
                this.gtZ.setText("");
            }
            this.guo.setImageResource(a.f.icon_live_vs_lose);
        } else if (3 == i) {
            this.gtY.setImageResource(a.f.icon_live_vs_draw);
            this.guo.setImageResource(a.f.icon_live_vs_draw);
        } else if (2 == i) {
            this.gtY.setImageResource(a.f.icon_live_vs_lose);
            if (i2 >= 2) {
                this.gup.setVisibility(0);
                this.gup.setText(this.mContext.getResources().getString(a.i.ala_challenge_streak_win_label, Integer.valueOf(i2)));
            } else {
                this.gup.setText("");
            }
            this.guo.setImageResource(a.f.icon_live_vs_win);
        } else {
            bQs();
        }
    }

    public void bQs() {
        this.gtX.setVisibility(4);
        this.gun.setVisibility(4);
    }

    public void bQt() {
        if (this.guH != null) {
            this.guH.clear();
            this.guH = null;
        }
        if (this.guI != null) {
            this.guI.clear();
            this.guI = null;
        }
    }

    private void w(long j, long j2) {
        int i;
        if (this.guB != j || this.guC != j2) {
            this.guB = j;
            this.guC = j2;
            this.guv.setText(String.valueOf(this.guB));
            this.guw.setText(String.valueOf(this.guC));
            float f = (float) (this.guB + this.guC);
            final int i2 = this.screenWidth;
            int i3 = i2 / 2;
            if (f != 0.0f) {
                int i4 = (int) ((((float) this.guB) / f) * i2);
                int i5 = ((LinearLayout.LayoutParams) this.gux.getLayoutParams()).width;
                if (i4 < this.guD) {
                    i = this.guD;
                } else {
                    i = i4 > i2 - this.guD ? i2 - this.guD : i4;
                }
                if (this.guG != null) {
                    this.guG.cancel();
                }
                this.guG = ValueAnimator.ofInt(i5, i);
                this.guG.setDuration(100L);
                this.guG.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeLiveView.2
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) AlaChallengeLiveView.this.gux.getLayoutParams();
                        layoutParams.width = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                        AlaChallengeLiveView.this.gux.setLayoutParams(layoutParams);
                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) AlaChallengeLiveView.this.guy.getLayoutParams();
                        layoutParams2.width = i2 - layoutParams.width;
                        AlaChallengeLiveView.this.guy.setLayoutParams(layoutParams2);
                    }
                });
                this.guG.start();
                return;
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gux.getLayoutParams();
            layoutParams.width = i3;
            this.gux.setLayoutParams(layoutParams);
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.guy.getLayoutParams();
            layoutParams2.width = i2 - layoutParams.width;
            this.guy.setLayoutParams(layoutParams2);
        }
    }

    public void c(at atVar) {
        if (atVar == null || atVar.aIl == null) {
            this.guf.setVisibility(4);
            return;
        }
        this.guf.setTag(atVar);
        this.gug.startLoad(atVar.aIl.portrait, 12, false, false);
        String str = atVar.aIl.userName;
        if (TextHelper.getTextLengthWithEmoji(str) > 8) {
            str = TextHelper.subStringWithEmoji(str, 8) + StringHelper.STRING_MORE;
        }
        this.guh.setText(str);
        this.gui.setVisibility(8);
    }

    public void lU(boolean z) {
        if (this.gui != null) {
            this.gui.setVisibility(z ? 8 : 0);
        }
    }

    public View getRivalUserInfoView() {
        return this.guf;
    }

    public void releaseResource() {
        bIn();
        this.guz.setText(this.mContext.getResources().getString(a.i.ala_challenge_btn_close_label));
        this.guq.Ft();
        this.gur.bQA();
        this.guF = null;
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z = true;
        if (view == this.guz) {
            if (this.guA != null) {
                if (com.baidu.live.w.a.Nk().beH == null || this.guF == null || this.guF.aIn != 3 || com.baidu.live.w.a.Nk().beH.aGt != 1) {
                    z = false;
                }
                if (z) {
                    if (this.guF != null) {
                        this.guA.a(this.guF.aIx);
                        return;
                    }
                    return;
                }
                this.guA.bQu();
            }
        } else if (view == this.guf) {
            if (this.guA != null) {
                if (this.guJ) {
                    this.guA.bQv();
                } else {
                    this.guA.d((at) this.guf.getTag());
                }
            }
        } else if (view == this.gui) {
            if (this.guA != null) {
                if (this.guJ) {
                    this.guA.bQv();
                } else {
                    this.guA.e((at) this.guf.getTag());
                }
            }
        } else if (view == this.gue) {
            if (this.guA != null) {
                if (this.guJ) {
                    this.guA.bQv();
                } else {
                    this.guA.f(this.aIk);
                }
            }
        } else if (view == this.gua) {
            this.guA.lV(false);
        } else if (view == this.guj) {
            this.guA.lV(true);
        }
    }

    public void setViewClickCallBack(a aVar) {
        this.guA = aVar;
    }
}
