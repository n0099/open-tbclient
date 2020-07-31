package com.baidu.tieba.ala.liveroom.challenge.view;

import android.animation.ValueAnimator;
import android.content.Context;
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
import com.baidu.live.data.al;
import com.baidu.live.data.am;
import com.baidu.live.data.an;
import com.baidu.live.data.ar;
import com.baidu.live.data.bh;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.util.TextHelper;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.live.utils.g;
import com.baidu.tieba.ala.liveroom.challenge.view.ChallengeJinzhuView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class AlaChallengeLiveView extends RelativeLayout implements View.OnClickListener, ChallengeJinzhuView.a {
    private ar aCZ;
    private ar aDa;
    private CountDownTimer fFg;
    private RelativeLayout ghE;
    private RelativeLayout ghF;
    private RelativeLayout ghG;
    private TbImageView ghH;
    private View ghI;
    private RelativeLayout ghJ;
    private TbImageView ghK;
    private View ghL;
    private RelativeLayout ghM;
    private RelativeLayout ghN;
    private RelativeLayout ghO;
    private ImageView ghP;
    private TextView ghQ;
    private LinearLayout ghR;
    private ChallengeJinzhuView ghS;
    private ChallengeJinzhuView ghT;
    private ChallengeJinzhuView ghU;
    private LinearLayout ghV;
    private RelativeLayout ghW;
    private RelativeLayout ghX;
    private HeadImageView ghY;
    private TextView ghZ;
    private int giA;
    private an giB;
    private ValueAnimator giC;
    private List<al> giD;
    private List<al> giE;
    public boolean giF;
    private ImageView gia;
    private LinearLayout gib;
    private ChallengeJinzhuView gic;
    private ChallengeJinzhuView gie;
    private ChallengeJinzhuView gif;
    private RelativeLayout gig;
    private ImageView gih;
    private TextView gii;
    private LinearLayout gij;
    private AlaChallengeMvpTipView gik;
    private AlaChallengeMvpDynamicAnimView gil;
    private LinearLayout gim;
    private TextView gin;
    private RelativeLayout gio;
    private TextView gip;
    private TextView giq;
    private TextView gir;
    private TextView gis;
    private View git;
    private View giu;
    private TextView giv;
    private a giw;
    private long gix;
    private long giy;
    private int giz;
    private boolean isHost;
    private Context mContext;
    private Handler mHandler;
    private RelativeLayout rootView;
    private int screenWidth;

    /* loaded from: classes4.dex */
    public interface a {
        void a(bh bhVar);

        void bGQ();

        void bGR();

        void d(ar arVar);

        void e(ar arVar);

        void f(ar arVar);

        void lu(boolean z);
    }

    public AlaChallengeLiveView(Context context) {
        super(context);
        this.isHost = false;
        this.gix = -1L;
        this.giy = -1L;
        this.screenWidth = -1;
        this.giz = 0;
        this.giA = 0;
        this.giF = false;
        init(context);
    }

    public AlaChallengeLiveView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isHost = false;
        this.gix = -1L;
        this.giy = -1L;
        this.screenWidth = -1;
        this.giz = 0;
        this.giA = 0;
        this.giF = false;
        init(context);
    }

    public AlaChallengeLiveView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isHost = false;
        this.gix = -1L;
        this.giy = -1L;
        this.screenWidth = -1;
        this.giz = 0;
        this.giA = 0;
        this.giF = false;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.mHandler = new Handler(Looper.getMainLooper());
        initView(context);
        updateView();
    }

    public void setNeedCloseRecommendFloat(boolean z) {
        this.giF = z;
        this.ghS.setNeedCloseRecommendFloat(this.giF);
        this.ghT.setNeedCloseRecommendFloat(this.giF);
        this.ghU.setNeedCloseRecommendFloat(this.giF);
        this.gic.setNeedCloseRecommendFloat(this.giF);
        this.gie.setNeedCloseRecommendFloat(this.giF);
        this.gif.setNeedCloseRecommendFloat(this.giF);
    }

    public void setIsHost(boolean z) {
        this.isHost = z;
    }

    private void initView(Context context) {
        this.rootView = (RelativeLayout) View.inflate(context, a.h.ala_challenge_panel_optation_view, this);
        this.ghE = (RelativeLayout) this.rootView.findViewById(a.g.root_container);
        this.ghG = (RelativeLayout) this.rootView.findViewById(a.g.anchor_live_anim_layout);
        this.ghH = (TbImageView) this.rootView.findViewById(a.g.anchor_live_anim_bg);
        this.ghJ = (RelativeLayout) this.rootView.findViewById(a.g.rival_live_anim_layout);
        this.ghK = (TbImageView) this.rootView.findViewById(a.g.rival_live_anim_bg);
        this.ghF = (RelativeLayout) this.rootView.findViewById(a.g.pk_live_container);
        this.ghN = (RelativeLayout) this.rootView.findViewById(a.g.pk_anchor_live_layout);
        this.ghO = (RelativeLayout) this.rootView.findViewById(a.g.anchor_streak_win_layout);
        this.ghP = (ImageView) this.rootView.findViewById(a.g.anchor_user_pk_streak_img);
        this.ghQ = (TextView) this.rootView.findViewById(a.g.anchor_user_pk_streak_time);
        this.ghM = (RelativeLayout) this.rootView.findViewById(a.g.jinzhu_container);
        this.ghR = (LinearLayout) this.rootView.findViewById(a.g.anchor_jinzhu_layout);
        this.ghS = (ChallengeJinzhuView) this.rootView.findViewById(a.g.anchor_jinzhu_1);
        this.ghT = (ChallengeJinzhuView) this.rootView.findViewById(a.g.anchor_jinzhu_2);
        this.ghU = (ChallengeJinzhuView) this.rootView.findViewById(a.g.anchor_jinzhu_3);
        this.ghV = (LinearLayout) this.rootView.findViewById(a.g.anchor_jinzhu_click_area_layout);
        this.ghW = (RelativeLayout) this.rootView.findViewById(a.g.pk_rival_live_layout);
        this.ghX = (RelativeLayout) this.rootView.findViewById(a.g.pk_rival_user_layout);
        this.ghY = (HeadImageView) this.rootView.findViewById(a.g.ala_live_rival_user_image);
        this.ghZ = (TextView) this.rootView.findViewById(a.g.ala_live_rival_user_name);
        this.gia = (ImageView) this.rootView.findViewById(a.g.iv_rival_user_follow);
        this.gig = (RelativeLayout) this.rootView.findViewById(a.g.rival_streak_win_layout);
        this.gib = (LinearLayout) this.rootView.findViewById(a.g.rival_jinzhu_layout);
        this.gic = (ChallengeJinzhuView) this.rootView.findViewById(a.g.rival_jinzhu_1);
        this.gie = (ChallengeJinzhuView) this.rootView.findViewById(a.g.rival_jinzhu_2);
        this.gif = (ChallengeJinzhuView) this.rootView.findViewById(a.g.rival_jinzhu_3);
        this.gij = (LinearLayout) this.rootView.findViewById(a.g.rival_jinzhu_click_area_layout);
        this.gih = (ImageView) this.rootView.findViewById(a.g.rival_user_pk_streak_img);
        this.gii = (TextView) this.rootView.findViewById(a.g.rival_user_pk_streak_time);
        this.gim = (LinearLayout) this.rootView.findViewById(a.g.pk_time_layout);
        this.gin = (TextView) this.rootView.findViewById(a.g.pk_time_label);
        this.gio = (RelativeLayout) this.rootView.findViewById(a.g.pk_score_progress_layout);
        this.gip = (TextView) this.rootView.findViewById(a.g.pk_anchor_label);
        this.gir = (TextView) this.rootView.findViewById(a.g.pk_anchor_progress);
        this.gis = (TextView) this.rootView.findViewById(a.g.pk_rival_progress);
        this.giq = (TextView) this.rootView.findViewById(a.g.pk_rival_label);
        this.giv = (TextView) this.rootView.findViewById(a.g.btn_close_challenge_view);
        this.git = this.rootView.findViewById(a.g.anchor_progress_bg);
        this.giu = this.rootView.findViewById(a.g.rival_progress_bg);
        this.ghI = this.rootView.findViewById(a.g.anchor_live_anim_fore_bg);
        this.ghL = this.rootView.findViewById(a.g.rival_live_anim_fore_bg);
        this.gik = (AlaChallengeMvpTipView) this.rootView.findViewById(a.g.id_chellenge_mvp_tip);
        this.gil = (AlaChallengeMvpDynamicAnimView) this.rootView.findViewById(a.g.id_challenge_mvp_anim_view);
        this.ghX.setVisibility(0);
        this.ghX.setBackgroundResource(a.f.sdk_round_host_header_bg);
        this.ghY.setIsRound(true);
        this.ghY.setAutoChangeStyle(false);
        this.ghY.setDefaultBgResource(a.f.sdk_icon_default_avatar100_bg);
        this.ghY.setIsNight(false);
        this.ghX.setOnClickListener(this);
        this.gia.setOnClickListener(this);
        this.giv.setOnClickListener(this);
        this.ghR.setVisibility(8);
        this.gib.setVisibility(8);
        this.ghV.setOnClickListener(this);
        this.gij.setOnClickListener(this);
        this.ghS.setClickListener(this);
        this.ghT.setClickListener(this);
        this.ghU.setClickListener(this);
        this.gic.setClickListener(this);
        this.gie.setClickListener(this);
        this.gif.setClickListener(this);
    }

    private void updateView() {
        this.giA = g.av(this.mContext);
        this.giz = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds50);
        this.screenWidth = BdUtilHelper.getScreenDimensions(this.mContext)[0];
        int ay = g.ay(this.mContext);
        int ax = g.ax(this.mContext);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = this.giA;
        layoutParams.height = ax;
        this.ghF.setLayoutParams(layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.gil.getLayoutParams();
        layoutParams2.topMargin = this.giA;
        this.gil.setLayoutParams(layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(ay, ax);
        layoutParams3.addRule(9);
        this.ghN.setLayoutParams(layoutParams3);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(ay, ax);
        layoutParams4.addRule(11);
        this.ghW.setLayoutParams(layoutParams4);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(ay, ax);
        layoutParams5.addRule(11);
        layoutParams5.topMargin = this.giA;
        this.ghJ.setLayoutParams(layoutParams5);
        RelativeLayout.LayoutParams layoutParams6 = (RelativeLayout.LayoutParams) this.gim.getLayoutParams();
        layoutParams6.topMargin = this.giA;
        layoutParams6.addRule(14);
        this.gim.setLayoutParams(layoutParams6);
        this.gio.setAlpha(0.0f);
    }

    public View getAnchorAnimLiveLayout() {
        return this.ghG;
    }

    public View getAnchorAnimLiveForeBg() {
        return this.ghI;
    }

    public View getRivalAnimLiveLayout() {
        return this.ghJ;
    }

    public View getRivalAnimLiveForeBg() {
        return this.ghL;
    }

    public TbImageView getAnchorAnimLiveBgView() {
        return this.ghH;
    }

    public void setAnchorUserViewBg(ar arVar) {
        this.ghH.setScaleType(ImageView.ScaleType.FIT_XY);
        String str = "";
        if (arVar.aDb != null) {
            str = arVar.aDb.portrait;
        }
        this.ghH.startLoad(str, 12, false);
        this.ghH.setVisibility(0);
    }

    public void setRivalUserViewBg(ar arVar) {
        this.ghK.setScaleType(ImageView.ScaleType.FIT_XY);
        String str = "";
        if (arVar.aDb != null) {
            str = arVar.aDb.portrait;
        }
        this.ghK.startLoad(str, 12, false);
    }

    public View getLeftTimeView() {
        return this.gim;
    }

    public ViewGroup getLiveContainerView() {
        return this.ghF;
    }

    public View getScoreProgressLayout() {
        return this.gio;
    }

    public View getJinzhuLayout() {
        return this.ghM;
    }

    public View getCloseBtnView() {
        return this.giv;
    }

    public RelativeLayout getContainerView() {
        return this.ghE;
    }

    public void a(an anVar, ar arVar, ar arVar2, boolean z) {
        this.aCZ = arVar;
        this.aDa = arVar2;
        int i = anVar.aDd;
        a(anVar.challengeId, i, anVar.aDh, anVar.aDg);
        w(anVar.aDi, anVar.aDj);
        if (z) {
            c(arVar2);
        }
        if (i == 2) {
            setCloseBtnVisible(true);
            bGN();
        } else if (i == 3) {
            boolean z2 = com.baidu.live.v.a.Hs().aZn != null && com.baidu.live.v.a.Hs().aZn.aBj == 1;
            if (z2) {
                this.giv.setText(this.mContext.getResources().getString(a.i.ala_challenge_btn_close_label_2));
            }
            setCloseBtnVisible(z2);
            bF(anVar.challengeResult, anVar.aDk);
        } else {
            bzk();
            setCloseBtnVisible(false);
            bF(anVar.challengeResult, anVar.aDk);
        }
        a(arVar.aDv);
        b(arVar2.aDv);
        this.giB = anVar;
    }

    private void a(am amVar) {
        ArrayList arrayList;
        if (amVar == null) {
            this.ghS.setVisibility(8);
            this.ghT.setVisibility(8);
            this.ghU.setVisibility(8);
            return;
        }
        this.ghR.setVisibility(0);
        if (ListUtils.isEmpty(amVar.aDc)) {
            amVar.aDc = this.giD;
        }
        if (ListUtils.isEmpty(amVar.aDc)) {
            this.ghS.setVisibility(0);
            this.ghT.setVisibility(8);
            this.ghU.setVisibility(8);
            this.ghS.a(true, null, amVar.liveId);
            return;
        }
        this.giD = amVar.aDc;
        this.ghS.setVisibility(8);
        this.ghT.setVisibility(8);
        this.ghU.setVisibility(8);
        if (amVar.aDc.size() > 3) {
            ArrayList arrayList2 = new ArrayList();
            for (int i = 0; i < 3; i++) {
                arrayList2.add(amVar.aDc.get(i));
            }
            arrayList = arrayList2;
        } else {
            arrayList = amVar.aDc;
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            al alVar = arrayList.get(i2);
            if (alVar != null) {
                if (alVar.xq() || alVar.isFirst()) {
                    this.ghS.setVisibility(0);
                    this.ghS.a(true, alVar, amVar.liveId);
                } else if (alVar.rank == 2) {
                    this.ghT.setVisibility(0);
                    this.ghT.a(true, alVar, amVar.liveId);
                } else if (alVar.rank == 3) {
                    this.ghU.setVisibility(0);
                    this.ghU.a(true, alVar, amVar.liveId);
                }
            }
        }
    }

    private void b(am amVar) {
        List<al> list;
        if (amVar == null) {
            this.gic.setVisibility(8);
            this.gie.setVisibility(8);
            this.gif.setVisibility(8);
            return;
        }
        this.gib.setVisibility(0);
        if (ListUtils.isEmpty(amVar.aDc)) {
            amVar.aDc = this.giE;
        }
        if (ListUtils.isEmpty(amVar.aDc)) {
            this.gic.setVisibility(0);
            this.gie.setVisibility(8);
            this.gif.setVisibility(8);
            this.gic.a(false, null, amVar.liveId);
            return;
        }
        this.giE = amVar.aDc;
        this.gic.setVisibility(8);
        this.gie.setVisibility(8);
        this.gif.setVisibility(8);
        if (amVar.aDc.size() > 3) {
            list = amVar.aDc.subList(0, 3);
        } else {
            list = amVar.aDc;
        }
        for (int i = 0; i < list.size(); i++) {
            al alVar = list.get(i);
            if (alVar != null) {
                if (alVar.xq() || alVar.isFirst()) {
                    this.gic.setVisibility(0);
                    this.gic.a(false, alVar, amVar.liveId);
                } else if (alVar.rank == 2) {
                    this.gie.setVisibility(0);
                    this.gie.a(false, alVar, amVar.liveId);
                } else if (alVar.rank == 3) {
                    this.gif.setVisibility(0);
                    this.gif.a(false, alVar, amVar.liveId);
                }
            }
        }
    }

    private void a(long j, int i, long j2, long j3) {
        if (j3 >= j2 && a(j, i, j3)) {
            bzk();
            if (this.giB != null) {
                v(this.giB.aDd, (j3 - j2) * 1000);
            }
            this.fFg = new CountDownTimer((j3 - j2) * 1000, 1000L) { // from class: com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeLiveView.1
                @Override // android.os.CountDownTimer
                public void onTick(long j4) {
                    if (AlaChallengeLiveView.this.giB != null) {
                        AlaChallengeLiveView.this.v(AlaChallengeLiveView.this.giB.aDd, j4);
                    }
                }

                @Override // android.os.CountDownTimer
                public void onFinish() {
                    if (AlaChallengeLiveView.this.giB != null) {
                        AlaChallengeLiveView.this.v(AlaChallengeLiveView.this.giB.aDd, 0L);
                    }
                }
            };
            this.fFg.start();
        }
    }

    private boolean a(long j, int i, long j2) {
        return (this.giB != null && this.giB.challengeId == j && this.giB.aDd == i && this.giB.aDg == j2) ? false : true;
    }

    private void bzk() {
        if (this.fFg != null) {
            this.fFg.cancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(int i, long j) {
        if (this.gin != null) {
            String formatSecondsTime = StringHelper.formatSecondsTime(Math.round(j / 1000.0d));
            String string = this.mContext.getString(a.i.ala_challenge_operate_challenge_time, formatSecondsTime);
            if (i == 2) {
                string = this.mContext.getString(a.i.ala_challenge_operate_challenge_time, formatSecondsTime);
            } else if (i == 3) {
                string = this.mContext.getString(a.i.ala_challenge_operate_publish_time, formatSecondsTime);
            } else if (i == 4) {
                string = this.mContext.getString(a.i.ala_challenge_operate_over_time);
            }
            this.gin.setText(string);
        }
    }

    public void setLiveContainerVisible(boolean z) {
        this.ghF.setVisibility(z ? 0 : 4);
    }

    public void setCloseBtnVisible(boolean z) {
        if (this.isHost) {
            this.giv.setVisibility(z ? 0 : 4);
        } else {
            this.giv.setVisibility(4);
        }
    }

    public void bGM() {
        setCloseBtnVisible(false);
        this.giv.setText(this.mContext.getResources().getString(a.i.ala_challenge_btn_close_label));
        this.gik.zQ();
        this.gil.bGW();
        setLiveContainerVisible(false);
        if (this.giD != null) {
            this.giD.clear();
            this.giD = null;
        }
        if (this.giE != null) {
            this.giE.clear();
            this.giE = null;
        }
        this.giB = null;
    }

    public void bF(int i, int i2) {
        this.ghO.setVisibility(0);
        this.gig.setVisibility(0);
        this.ghQ.setVisibility(4);
        this.gii.setVisibility(4);
        if (1 == i) {
            this.ghP.setImageResource(a.f.icon_live_vs_win);
            if (i2 >= 2) {
                this.ghQ.setVisibility(0);
                this.ghQ.setText(this.mContext.getResources().getString(a.i.ala_challenge_streak_win_label, Integer.valueOf(i2)));
            } else {
                this.ghQ.setText("");
            }
            this.gih.setImageResource(a.f.icon_live_vs_lose);
        } else if (3 == i) {
            this.ghP.setImageResource(a.f.icon_live_vs_draw);
            this.gih.setImageResource(a.f.icon_live_vs_draw);
        } else if (2 == i) {
            this.ghP.setImageResource(a.f.icon_live_vs_lose);
            if (i2 >= 2) {
                this.gii.setVisibility(0);
                this.gii.setText(this.mContext.getResources().getString(a.i.ala_challenge_streak_win_label, Integer.valueOf(i2)));
            } else {
                this.gii.setText("");
            }
            this.gih.setImageResource(a.f.icon_live_vs_win);
        } else {
            bGN();
        }
    }

    public void bGN() {
        this.ghO.setVisibility(4);
        this.gig.setVisibility(4);
    }

    public void bGO() {
        if (this.giD != null) {
            this.giD.clear();
            this.giD = null;
        }
        if (this.giE != null) {
            this.giE.clear();
            this.giE = null;
        }
    }

    private void w(long j, long j2) {
        int i;
        if (this.gix != j || this.giy != j2) {
            this.gix = j;
            this.giy = j2;
            this.gir.setText(String.valueOf(this.gix));
            this.gis.setText(String.valueOf(this.giy));
            float f = (float) (this.gix + this.giy);
            final int dimensionPixelSize = (this.screenWidth - (this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds20) * 2)) - (this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds6) * 2);
            int i2 = dimensionPixelSize / 2;
            if (f != 0.0f) {
                int i3 = (int) ((((float) this.gix) / f) * dimensionPixelSize);
                int i4 = ((LinearLayout.LayoutParams) this.git.getLayoutParams()).width;
                if (i3 < this.giz) {
                    i = this.giz;
                } else {
                    i = i3 > dimensionPixelSize - this.giz ? dimensionPixelSize - this.giz : i3;
                }
                if (this.giC != null) {
                    this.giC.cancel();
                }
                this.giC = ValueAnimator.ofInt(i4, i);
                this.giC.setDuration(100L);
                this.giC.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeLiveView.2
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) AlaChallengeLiveView.this.git.getLayoutParams();
                        layoutParams.width = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                        AlaChallengeLiveView.this.git.setLayoutParams(layoutParams);
                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) AlaChallengeLiveView.this.giu.getLayoutParams();
                        layoutParams2.width = dimensionPixelSize - layoutParams.width;
                        AlaChallengeLiveView.this.giu.setLayoutParams(layoutParams2);
                    }
                });
                this.giC.start();
                return;
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.git.getLayoutParams();
            layoutParams.width = i2;
            this.git.setLayoutParams(layoutParams);
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.giu.getLayoutParams();
            layoutParams2.width = dimensionPixelSize - layoutParams.width;
            this.giu.setLayoutParams(layoutParams2);
        }
    }

    public void c(ar arVar) {
        if (arVar == null || arVar.aDb == null) {
            this.ghX.setVisibility(4);
            return;
        }
        this.ghX.setTag(arVar);
        this.ghY.startLoad(arVar.aDb.portrait, 12, false, false);
        String str = arVar.aDb.userName;
        if (TextHelper.getTextLengthWithEmoji(str) > 8) {
            str = TextHelper.subStringWithEmoji(str, 8) + StringHelper.STRING_MORE;
        }
        this.ghZ.setText(str);
        this.gia.setVisibility(8);
    }

    public void lt(boolean z) {
        if (this.gia != null) {
            this.gia.setVisibility(z ? 8 : 0);
        }
    }

    public View getRivalUserInfoView() {
        return this.ghX;
    }

    public void releaseResource() {
        bzk();
        this.giv.setText(this.mContext.getResources().getString(a.i.ala_challenge_btn_close_label));
        this.gik.zQ();
        this.gil.bGW();
        this.giB = null;
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z = true;
        if (view == this.giv) {
            if (this.giw != null) {
                if (com.baidu.live.v.a.Hs().aZn == null || this.giB == null || this.giB.aDd != 3 || com.baidu.live.v.a.Hs().aZn.aBj != 1) {
                    z = false;
                }
                if (z) {
                    if (this.giB != null) {
                        this.giw.a(this.giB.aDn);
                        return;
                    }
                    return;
                }
                this.giw.bGQ();
            }
        } else if (view == this.ghX) {
            if (this.giw != null) {
                if (this.giF) {
                    this.giw.bGR();
                } else {
                    this.giw.d((ar) this.ghX.getTag());
                }
            }
        } else if (view == this.gia) {
            if (this.giw != null) {
                if (this.giF) {
                    this.giw.bGR();
                } else {
                    this.giw.e((ar) this.ghX.getTag());
                }
            }
        } else if (view == this.ghW) {
            if (this.giw != null) {
                if (this.giF) {
                    this.giw.bGR();
                } else {
                    this.giw.f(this.aDa);
                }
            }
        } else if (view == this.ghV) {
            this.giw.lu(false);
        } else if (view == this.gij) {
            this.giw.lu(true);
        }
    }

    public void setViewClickCallBack(a aVar) {
        this.giw = aVar;
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.view.ChallengeJinzhuView.a
    public void bGP() {
        if (this.giw != null) {
            this.giw.bGR();
        }
    }
}
