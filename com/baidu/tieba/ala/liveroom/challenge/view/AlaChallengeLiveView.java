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
    private at aIl;
    private at aIm;
    private CountDownTimer fQB;
    private RelativeLayout gtR;
    private RelativeLayout gtS;
    private RelativeLayout gtT;
    private TbImageView gtU;
    private View gtV;
    private RelativeLayout gtW;
    private TbImageView gtX;
    private View gtY;
    private RelativeLayout gtZ;
    private TextView guA;
    private View guB;
    private View guC;
    private TextView guD;
    private a guE;
    private long guF;
    private long guG;
    private int guH;
    private int guI;
    private ap guJ;
    private ValueAnimator guK;
    private List<an> guL;
    private List<an> guM;
    public boolean guN;
    private RelativeLayout gua;
    private RelativeLayout gub;
    private ImageView guc;
    private TextView gud;
    private LinearLayout gue;
    private ChallengeJinzhuView guf;
    private ChallengeJinzhuView gug;
    private ChallengeJinzhuView guh;
    private RelativeLayout gui;
    private RelativeLayout guj;
    private HeadImageView guk;
    private TextView gul;
    private ImageView gum;
    private LinearLayout gun;
    private ChallengeJinzhuView guo;
    private ChallengeJinzhuView gup;
    private ChallengeJinzhuView guq;
    private RelativeLayout gur;
    private ImageView gus;
    private TextView gut;
    private AlaChallengeMvpTipView guu;
    private AlaChallengeMvpDynamicAnimView guv;
    private LinearLayout guw;
    private TextView gux;
    private RelativeLayout guy;
    private TextView guz;
    private boolean isHost;
    private Context mContext;
    private Handler mHandler;
    private RelativeLayout rootView;
    private int screenWidth;

    /* loaded from: classes7.dex */
    public interface a {
        void a(bj bjVar);

        void bQv();

        void bQw();

        void d(at atVar);

        void e(at atVar);

        void f(at atVar);

        void lX(boolean z);
    }

    public AlaChallengeLiveView(Context context) {
        super(context);
        this.isHost = false;
        this.guF = -1L;
        this.guG = -1L;
        this.screenWidth = -1;
        this.guH = 0;
        this.guI = 0;
        this.guN = false;
        init(context);
    }

    public AlaChallengeLiveView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isHost = false;
        this.guF = -1L;
        this.guG = -1L;
        this.screenWidth = -1;
        this.guH = 0;
        this.guI = 0;
        this.guN = false;
        init(context);
    }

    public AlaChallengeLiveView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isHost = false;
        this.guF = -1L;
        this.guG = -1L;
        this.screenWidth = -1;
        this.guH = 0;
        this.guI = 0;
        this.guN = false;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.mHandler = new Handler(Looper.getMainLooper());
        dL(context);
        updateView();
    }

    public void setNeedCloseRecommendFloat(boolean z) {
        this.guN = z;
        this.guf.setNeedCloseRecommendFloat(this.guN);
        this.gug.setNeedCloseRecommendFloat(this.guN);
        this.guh.setNeedCloseRecommendFloat(this.guN);
        this.guo.setNeedCloseRecommendFloat(this.guN);
        this.gup.setNeedCloseRecommendFloat(this.guN);
        this.guq.setNeedCloseRecommendFloat(this.guN);
    }

    public void setIsHost(boolean z) {
        this.isHost = z;
    }

    private void dL(Context context) {
        this.rootView = (RelativeLayout) View.inflate(context, a.h.ala_challenge_panel_optation_view, this);
        this.gtR = (RelativeLayout) this.rootView.findViewById(a.g.root_container);
        this.gtT = (RelativeLayout) this.rootView.findViewById(a.g.anchor_live_anim_layout);
        this.gtU = (TbImageView) this.rootView.findViewById(a.g.anchor_live_anim_bg);
        this.gtW = (RelativeLayout) this.rootView.findViewById(a.g.rival_live_anim_layout);
        this.gtX = (TbImageView) this.rootView.findViewById(a.g.rival_live_anim_bg);
        this.gtS = (RelativeLayout) this.rootView.findViewById(a.g.pk_live_container);
        this.gua = (RelativeLayout) this.rootView.findViewById(a.g.pk_anchor_live_layout);
        this.gub = (RelativeLayout) this.rootView.findViewById(a.g.anchor_streak_win_layout);
        this.guc = (ImageView) this.rootView.findViewById(a.g.anchor_user_pk_streak_img);
        this.gud = (TextView) this.rootView.findViewById(a.g.anchor_user_pk_streak_time);
        this.gtZ = (RelativeLayout) this.rootView.findViewById(a.g.jinzhu_container);
        this.gue = (LinearLayout) this.rootView.findViewById(a.g.anchor_jinzhu_layout);
        this.guf = (ChallengeJinzhuView) this.rootView.findViewById(a.g.anchor_jinzhu_1);
        this.gug = (ChallengeJinzhuView) this.rootView.findViewById(a.g.anchor_jinzhu_2);
        this.guh = (ChallengeJinzhuView) this.rootView.findViewById(a.g.anchor_jinzhu_3);
        this.gui = (RelativeLayout) this.rootView.findViewById(a.g.pk_rival_live_layout);
        this.guj = (RelativeLayout) this.rootView.findViewById(a.g.pk_rival_user_layout);
        this.guk = (HeadImageView) this.rootView.findViewById(a.g.ala_live_rival_user_image);
        this.gul = (TextView) this.rootView.findViewById(a.g.ala_live_rival_user_name);
        this.gum = (ImageView) this.rootView.findViewById(a.g.iv_rival_user_follow);
        this.gur = (RelativeLayout) this.rootView.findViewById(a.g.rival_streak_win_layout);
        this.gun = (LinearLayout) this.rootView.findViewById(a.g.rival_jinzhu_layout);
        this.guo = (ChallengeJinzhuView) this.rootView.findViewById(a.g.rival_jinzhu_1);
        this.gup = (ChallengeJinzhuView) this.rootView.findViewById(a.g.rival_jinzhu_2);
        this.guq = (ChallengeJinzhuView) this.rootView.findViewById(a.g.rival_jinzhu_3);
        this.gus = (ImageView) this.rootView.findViewById(a.g.rival_user_pk_streak_img);
        this.gut = (TextView) this.rootView.findViewById(a.g.rival_user_pk_streak_time);
        this.guw = (LinearLayout) this.rootView.findViewById(a.g.pk_time_layout);
        this.gux = (TextView) this.rootView.findViewById(a.g.pk_time_label);
        this.guy = (RelativeLayout) this.rootView.findViewById(a.g.pk_score_progress_layout);
        this.guz = (TextView) this.rootView.findViewById(a.g.pk_anchor_progress);
        this.guA = (TextView) this.rootView.findViewById(a.g.pk_rival_progress);
        this.guD = (TextView) this.rootView.findViewById(a.g.btn_close_challenge_view);
        this.guB = this.rootView.findViewById(a.g.anchor_progress_bg);
        this.guC = this.rootView.findViewById(a.g.rival_progress_bg);
        this.gtV = this.rootView.findViewById(a.g.anchor_live_anim_fore_bg);
        this.gtY = this.rootView.findViewById(a.g.rival_live_anim_fore_bg);
        this.guu = (AlaChallengeMvpTipView) this.rootView.findViewById(a.g.id_chellenge_mvp_tip);
        this.guv = (AlaChallengeMvpDynamicAnimView) this.rootView.findViewById(a.g.id_challenge_mvp_anim_view);
        this.guj.setVisibility(0);
        this.guj.setBackgroundResource(a.f.sdk_round_host_header_bg);
        this.guk.setIsRound(true);
        this.guk.setAutoChangeStyle(false);
        this.guk.setDefaultBgResource(a.f.sdk_icon_default_avatar100_bg);
        this.guk.setIsNight(false);
        this.guj.setOnClickListener(this);
        this.gum.setOnClickListener(this);
        this.guD.setOnClickListener(this);
        this.gue.setVisibility(8);
        this.gun.setVisibility(8);
        this.gue.setOnClickListener(this);
        this.gun.setOnClickListener(this);
    }

    private void updateView() {
        this.guI = g.az(this.mContext);
        this.guH = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds50);
        this.screenWidth = BdUtilHelper.getScreenDimensions(this.mContext)[0];
        int aC = g.aC(this.mContext);
        int aB = g.aB(this.mContext);
        ViewGroup.LayoutParams layoutParams = this.guy.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            layoutParams.height = g.bqw;
            ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = g.ay(this.mContext);
            this.guy.setLayoutParams(layoutParams);
        }
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams2.topMargin = this.guI;
        layoutParams2.height = aB;
        this.gtS.setLayoutParams(layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.guv.getLayoutParams();
        layoutParams3.topMargin = this.guI;
        this.guv.setLayoutParams(layoutParams3);
        ViewGroup.LayoutParams layoutParams4 = this.gua.getLayoutParams();
        if (layoutParams4 != null) {
            layoutParams4.width = aC;
            layoutParams4.height = aB;
            this.gua.setLayoutParams(layoutParams4);
        }
        ViewGroup.LayoutParams layoutParams5 = this.gui.getLayoutParams();
        if (layoutParams5 != null) {
            layoutParams5.width = aC;
            layoutParams5.height = aB;
            this.gui.setLayoutParams(layoutParams5);
        }
        RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(aC, aB);
        layoutParams6.addRule(11);
        layoutParams6.topMargin = this.guI;
        this.gtW.setLayoutParams(layoutParams6);
        RelativeLayout.LayoutParams layoutParams7 = (RelativeLayout.LayoutParams) this.guw.getLayoutParams();
        layoutParams7.topMargin = this.guI;
        layoutParams7.addRule(14);
        this.guw.setLayoutParams(layoutParams7);
        this.guy.setAlpha(0.0f);
        int paddingLeft = (((((aC * 2) - this.gtZ.getPaddingLeft()) - this.gtZ.getPaddingRight()) - ((getResources().getDimensionPixelOffset(a.e.sdk_ds56) * 3) * 2)) - (getResources().getDimensionPixelOffset(a.e.sdk_ds12) * 4)) - (getResources().getDimensionPixelOffset(a.e.sdk_ds12) * 2);
        ViewGroup.LayoutParams layoutParams8 = this.guu.getLayoutParams();
        if (layoutParams8 instanceof ViewGroup.MarginLayoutParams) {
            layoutParams8.width = paddingLeft;
            ((ViewGroup.MarginLayoutParams) layoutParams8).bottomMargin = this.gtZ.getPaddingBottom();
            this.guu.setLayoutParams(layoutParams8);
        }
    }

    public View getAnchorAnimLiveLayout() {
        return this.gtT;
    }

    public View getAnchorAnimLiveForeBg() {
        return this.gtV;
    }

    public View getRivalAnimLiveLayout() {
        return this.gtW;
    }

    public View getRivalAnimLiveForeBg() {
        return this.gtY;
    }

    public TbImageView getAnchorAnimLiveBgView() {
        return this.gtU;
    }

    public void setAnchorUserViewBg(at atVar) {
        this.gtU.setScaleType(ImageView.ScaleType.FIT_XY);
        String str = "";
        if (atVar.aIn != null) {
            str = atVar.aIn.portrait;
        }
        this.gtU.startLoad(str, 12, false);
        this.gtU.setVisibility(0);
    }

    public void setRivalUserViewBg(at atVar) {
        this.gtX.setScaleType(ImageView.ScaleType.FIT_XY);
        String str = "";
        if (atVar.aIn != null) {
            str = atVar.aIn.portrait;
        }
        this.gtX.startLoad(str, 12, false);
    }

    public View getLeftTimeView() {
        return this.guw;
    }

    public ViewGroup getLiveContainerView() {
        return this.gtS;
    }

    public View getScoreProgressLayout() {
        return this.guy;
    }

    public View getJinzhuLayout() {
        return this.gtZ;
    }

    public View getCloseBtnView() {
        return this.guD;
    }

    public RelativeLayout getContainerView() {
        return this.gtR;
    }

    public void a(ap apVar, at atVar, at atVar2, boolean z) {
        this.aIl = atVar;
        this.aIm = atVar2;
        int i = apVar.aIp;
        a(apVar.challengeId, i, apVar.aIt, apVar.aIs);
        w(apVar.aIu, apVar.aIv);
        if (z) {
            c(atVar2);
        }
        if (i == 2) {
            setCloseBtnVisible(true);
            bQt();
        } else if (i == 3) {
            boolean z2 = com.baidu.live.w.a.Nk().beJ != null && com.baidu.live.w.a.Nk().beJ.aGv == 1;
            if (z2) {
                this.guD.setText(this.mContext.getResources().getString(a.i.ala_challenge_btn_close_label_2));
            }
            setCloseBtnVisible(z2);
            bN(apVar.challengeResult, apVar.aIw);
        } else {
            bIo();
            setCloseBtnVisible(false);
            bN(apVar.challengeResult, apVar.aIw);
        }
        a(atVar.aIH);
        b(atVar2.aIH);
        this.guJ = apVar;
    }

    private void a(ao aoVar) {
        ArrayList arrayList;
        if (aoVar == null) {
            this.guf.setVisibility(8);
            this.gug.setVisibility(8);
            this.guh.setVisibility(8);
            return;
        }
        this.gue.setVisibility(0);
        if (ListUtils.isEmpty(aoVar.aIo)) {
            aoVar.aIo = this.guL;
        }
        if (ListUtils.isEmpty(aoVar.aIo)) {
            this.guf.setVisibility(0);
            this.gug.setVisibility(8);
            this.guh.setVisibility(8);
            this.guf.a(true, null, aoVar.liveId);
            return;
        }
        this.guL = aoVar.aIo;
        this.guf.setVisibility(8);
        this.gug.setVisibility(8);
        this.guh.setVisibility(8);
        if (aoVar.aIo.size() > 3) {
            ArrayList arrayList2 = new ArrayList();
            for (int i = 0; i < 3; i++) {
                arrayList2.add(aoVar.aIo.get(i));
            }
            arrayList = arrayList2;
        } else {
            arrayList = aoVar.aIo;
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            an anVar = arrayList.get(i2);
            if (anVar != null) {
                if (anVar.CT() || anVar.isFirst()) {
                    this.guf.setVisibility(0);
                    this.guf.a(true, anVar, aoVar.liveId);
                } else if (anVar.rank == 2) {
                    this.gug.setVisibility(0);
                    this.gug.a(true, anVar, aoVar.liveId);
                } else if (anVar.rank == 3) {
                    this.guh.setVisibility(0);
                    this.guh.a(true, anVar, aoVar.liveId);
                }
            }
        }
    }

    private void b(ao aoVar) {
        List<an> list;
        if (aoVar == null) {
            this.guo.setVisibility(8);
            this.gup.setVisibility(8);
            this.guq.setVisibility(8);
            return;
        }
        this.gun.setVisibility(0);
        if (ListUtils.isEmpty(aoVar.aIo)) {
            aoVar.aIo = this.guM;
        }
        if (ListUtils.isEmpty(aoVar.aIo)) {
            this.guo.setVisibility(0);
            this.gup.setVisibility(8);
            this.guq.setVisibility(8);
            this.guo.a(false, null, aoVar.liveId);
            return;
        }
        this.guM = aoVar.aIo;
        this.guo.setVisibility(8);
        this.gup.setVisibility(8);
        this.guq.setVisibility(8);
        if (aoVar.aIo.size() > 3) {
            list = aoVar.aIo.subList(0, 3);
        } else {
            list = aoVar.aIo;
        }
        for (int i = 0; i < list.size(); i++) {
            an anVar = list.get(i);
            if (anVar != null) {
                if (anVar.CT() || anVar.isFirst()) {
                    this.guo.setVisibility(0);
                    this.guo.a(false, anVar, aoVar.liveId);
                } else if (anVar.rank == 2) {
                    this.gup.setVisibility(0);
                    this.gup.a(false, anVar, aoVar.liveId);
                } else if (anVar.rank == 3) {
                    this.guq.setVisibility(0);
                    this.guq.a(false, anVar, aoVar.liveId);
                }
            }
        }
    }

    private void a(long j, int i, long j2, long j3) {
        if (j3 >= j2 && a(j, i, j3)) {
            bIo();
            if (this.guJ != null) {
                v(this.guJ.aIp, (j3 - j2) * 1000);
            }
            this.fQB = new CountDownTimer((j3 - j2) * 1000, 1000L) { // from class: com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeLiveView.1
                @Override // android.os.CountDownTimer
                public void onTick(long j4) {
                    if (AlaChallengeLiveView.this.guJ != null) {
                        AlaChallengeLiveView.this.v(AlaChallengeLiveView.this.guJ.aIp, j4);
                    }
                }

                @Override // android.os.CountDownTimer
                public void onFinish() {
                    if (AlaChallengeLiveView.this.guJ != null) {
                        AlaChallengeLiveView.this.v(AlaChallengeLiveView.this.guJ.aIp, 0L);
                    }
                }
            };
            this.fQB.start();
        }
    }

    private boolean a(long j, int i, long j2) {
        return (this.guJ != null && this.guJ.challengeId == j && this.guJ.aIp == i && this.guJ.aIs == j2) ? false : true;
    }

    private void bIo() {
        if (this.fQB != null) {
            this.fQB.cancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(int i, long j) {
        if (this.gux != null) {
            this.gux.setCompoundDrawables(null, null, null, null);
            String formatSecondsTime = StringHelper.formatSecondsTime(Math.round(j / 1000.0d));
            String string = this.mContext.getString(a.i.ala_challenge_operate_challenge_time, formatSecondsTime);
            if (i == 2) {
                Drawable drawable = getResources().getDrawable(a.f.icon_challenge_timer_countdown);
                drawable.setBounds(0, 0, getResources().getDimensionPixelOffset(a.e.sdk_ds40), getResources().getDimensionPixelOffset(a.e.sdk_ds40));
                this.gux.setCompoundDrawablePadding(getResources().getDimensionPixelOffset(a.e.sdk_ds8));
                this.gux.setCompoundDrawables(drawable, null, null, null);
            } else if (i == 3) {
                formatSecondsTime = this.mContext.getString(a.i.ala_challenge_operate_publish_time, formatSecondsTime);
            } else {
                formatSecondsTime = i == 4 ? this.mContext.getString(a.i.ala_challenge_operate_over_time) : string;
            }
            this.gux.setText(formatSecondsTime);
        }
    }

    public void setLiveContainerVisible(boolean z) {
        this.gtS.setVisibility(z ? 0 : 4);
    }

    public void setCloseBtnVisible(boolean z) {
        if (this.isHost) {
            this.guD.setVisibility(z ? 0 : 4);
        } else {
            this.guD.setVisibility(4);
        }
    }

    public void bQs() {
        setCloseBtnVisible(false);
        this.guD.setText(this.mContext.getResources().getString(a.i.ala_challenge_btn_close_label));
        this.guu.Ft();
        this.guv.bQB();
        setLiveContainerVisible(false);
        if (this.guL != null) {
            this.guL.clear();
            this.guL = null;
        }
        if (this.guM != null) {
            this.guM.clear();
            this.guM = null;
        }
        this.guJ = null;
    }

    public void bN(int i, int i2) {
        this.gub.setVisibility(0);
        this.gur.setVisibility(0);
        this.gud.setVisibility(4);
        this.gut.setVisibility(4);
        if (1 == i) {
            this.guc.setImageResource(a.f.icon_live_vs_win);
            if (i2 >= 2) {
                this.gud.setVisibility(0);
                this.gud.setText(this.mContext.getResources().getString(a.i.ala_challenge_streak_win_label, Integer.valueOf(i2)));
            } else {
                this.gud.setText("");
            }
            this.gus.setImageResource(a.f.icon_live_vs_lose);
        } else if (3 == i) {
            this.guc.setImageResource(a.f.icon_live_vs_draw);
            this.gus.setImageResource(a.f.icon_live_vs_draw);
        } else if (2 == i) {
            this.guc.setImageResource(a.f.icon_live_vs_lose);
            if (i2 >= 2) {
                this.gut.setVisibility(0);
                this.gut.setText(this.mContext.getResources().getString(a.i.ala_challenge_streak_win_label, Integer.valueOf(i2)));
            } else {
                this.gut.setText("");
            }
            this.gus.setImageResource(a.f.icon_live_vs_win);
        } else {
            bQt();
        }
    }

    public void bQt() {
        this.gub.setVisibility(4);
        this.gur.setVisibility(4);
    }

    public void bQu() {
        if (this.guL != null) {
            this.guL.clear();
            this.guL = null;
        }
        if (this.guM != null) {
            this.guM.clear();
            this.guM = null;
        }
    }

    private void w(long j, long j2) {
        int i;
        if (this.guF != j || this.guG != j2) {
            this.guF = j;
            this.guG = j2;
            this.guz.setText(String.valueOf(this.guF));
            this.guA.setText(String.valueOf(this.guG));
            float f = (float) (this.guF + this.guG);
            final int i2 = this.screenWidth;
            int i3 = i2 / 2;
            if (f != 0.0f) {
                int i4 = (int) ((((float) this.guF) / f) * i2);
                int i5 = ((LinearLayout.LayoutParams) this.guB.getLayoutParams()).width;
                if (i4 < this.guH) {
                    i = this.guH;
                } else {
                    i = i4 > i2 - this.guH ? i2 - this.guH : i4;
                }
                if (this.guK != null) {
                    this.guK.cancel();
                }
                this.guK = ValueAnimator.ofInt(i5, i);
                this.guK.setDuration(100L);
                this.guK.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeLiveView.2
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) AlaChallengeLiveView.this.guB.getLayoutParams();
                        layoutParams.width = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                        AlaChallengeLiveView.this.guB.setLayoutParams(layoutParams);
                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) AlaChallengeLiveView.this.guC.getLayoutParams();
                        layoutParams2.width = i2 - layoutParams.width;
                        AlaChallengeLiveView.this.guC.setLayoutParams(layoutParams2);
                    }
                });
                this.guK.start();
                return;
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.guB.getLayoutParams();
            layoutParams.width = i3;
            this.guB.setLayoutParams(layoutParams);
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.guC.getLayoutParams();
            layoutParams2.width = i2 - layoutParams.width;
            this.guC.setLayoutParams(layoutParams2);
        }
    }

    public void c(at atVar) {
        if (atVar == null || atVar.aIn == null) {
            this.guj.setVisibility(4);
            return;
        }
        this.guj.setTag(atVar);
        this.guk.startLoad(atVar.aIn.portrait, 12, false, false);
        String str = atVar.aIn.userName;
        if (TextHelper.getTextLengthWithEmoji(str) > 8) {
            str = TextHelper.subStringWithEmoji(str, 8) + StringHelper.STRING_MORE;
        }
        this.gul.setText(str);
        this.gum.setVisibility(8);
    }

    public void lW(boolean z) {
        if (this.gum != null) {
            this.gum.setVisibility(z ? 8 : 0);
        }
    }

    public View getRivalUserInfoView() {
        return this.guj;
    }

    public void releaseResource() {
        bIo();
        this.guD.setText(this.mContext.getResources().getString(a.i.ala_challenge_btn_close_label));
        this.guu.Ft();
        this.guv.bQB();
        this.guJ = null;
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z = true;
        if (view == this.guD) {
            if (this.guE != null) {
                if (com.baidu.live.w.a.Nk().beJ == null || this.guJ == null || this.guJ.aIp != 3 || com.baidu.live.w.a.Nk().beJ.aGv != 1) {
                    z = false;
                }
                if (z) {
                    if (this.guJ != null) {
                        this.guE.a(this.guJ.aIz);
                        return;
                    }
                    return;
                }
                this.guE.bQv();
            }
        } else if (view == this.guj) {
            if (this.guE != null) {
                if (this.guN) {
                    this.guE.bQw();
                } else {
                    this.guE.d((at) this.guj.getTag());
                }
            }
        } else if (view == this.gum) {
            if (this.guE != null) {
                if (this.guN) {
                    this.guE.bQw();
                } else {
                    this.guE.e((at) this.guj.getTag());
                }
            }
        } else if (view == this.gui) {
            if (this.guE != null) {
                if (this.guN) {
                    this.guE.bQw();
                } else {
                    this.guE.f(this.aIm);
                }
            }
        } else if (view == this.gue) {
            this.guE.lX(false);
        } else if (view == this.gun) {
            this.guE.lX(true);
        }
    }

    public void setViewClickCallBack(a aVar) {
        this.guE = aVar;
    }
}
