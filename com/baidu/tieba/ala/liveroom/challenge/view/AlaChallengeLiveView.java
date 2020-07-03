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
import com.baidu.live.data.ak;
import com.baidu.live.data.al;
import com.baidu.live.data.am;
import com.baidu.live.data.aq;
import com.baidu.live.data.bg;
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
/* loaded from: classes3.dex */
public class AlaChallengeLiveView extends RelativeLayout implements View.OnClickListener, ChallengeJinzhuView.a {
    private aq aBE;
    private aq aBF;
    private CountDownTimer fzZ;
    private View gcA;
    private RelativeLayout gcB;
    private TbImageView gcC;
    private View gcD;
    private RelativeLayout gcE;
    private RelativeLayout gcF;
    private RelativeLayout gcG;
    private ImageView gcH;
    private TextView gcI;
    private LinearLayout gcJ;
    private ChallengeJinzhuView gcK;
    private ChallengeJinzhuView gcL;
    private ChallengeJinzhuView gcM;
    private LinearLayout gcN;
    private RelativeLayout gcO;
    private RelativeLayout gcP;
    private HeadImageView gcQ;
    private TextView gcR;
    private ImageView gcS;
    private LinearLayout gcT;
    private ChallengeJinzhuView gcU;
    private ChallengeJinzhuView gcV;
    private ChallengeJinzhuView gcW;
    private RelativeLayout gcX;
    private ImageView gcY;
    private TextView gcZ;
    private RelativeLayout gcw;
    private RelativeLayout gcx;
    private RelativeLayout gcy;
    private TbImageView gcz;
    private LinearLayout gda;
    private AlaChallengeMvpTipView gdb;
    private AlaChallengeMvpDynamicAnimView gdc;
    private LinearLayout gdd;
    private TextView gde;
    private RelativeLayout gdf;
    private TextView gdg;
    private TextView gdh;
    private TextView gdi;
    private TextView gdj;
    private View gdk;
    private View gdl;
    private TextView gdm;
    private a gdn;
    private long gdo;
    private long gdp;
    private int gdq;
    private int gdr;
    private am gds;
    private ValueAnimator gdt;
    private List<ak> gdu;
    private List<ak> gdv;
    public boolean gdw;
    private boolean isHost;
    private Context mContext;
    private Handler mHandler;
    private RelativeLayout rootView;
    private int screenWidth;

    /* loaded from: classes3.dex */
    public interface a {
        void a(bg bgVar);

        void bDE();

        void bDF();

        void d(aq aqVar);

        void e(aq aqVar);

        void f(aq aqVar);

        void kR(boolean z);
    }

    public AlaChallengeLiveView(Context context) {
        super(context);
        this.isHost = false;
        this.gdo = -1L;
        this.gdp = -1L;
        this.screenWidth = -1;
        this.gdq = 0;
        this.gdr = 0;
        this.gdw = false;
        init(context);
    }

    public AlaChallengeLiveView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isHost = false;
        this.gdo = -1L;
        this.gdp = -1L;
        this.screenWidth = -1;
        this.gdq = 0;
        this.gdr = 0;
        this.gdw = false;
        init(context);
    }

    public AlaChallengeLiveView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isHost = false;
        this.gdo = -1L;
        this.gdp = -1L;
        this.screenWidth = -1;
        this.gdq = 0;
        this.gdr = 0;
        this.gdw = false;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.mHandler = new Handler(Looper.getMainLooper());
        initView(context);
        updateView();
    }

    public void setNeedCloseRecommendFloat(boolean z) {
        this.gdw = z;
        this.gcK.setNeedCloseRecommendFloat(this.gdw);
        this.gcL.setNeedCloseRecommendFloat(this.gdw);
        this.gcM.setNeedCloseRecommendFloat(this.gdw);
        this.gcU.setNeedCloseRecommendFloat(this.gdw);
        this.gcV.setNeedCloseRecommendFloat(this.gdw);
        this.gcW.setNeedCloseRecommendFloat(this.gdw);
    }

    public void setIsHost(boolean z) {
        this.isHost = z;
    }

    private void initView(Context context) {
        this.rootView = (RelativeLayout) View.inflate(context, a.h.ala_challenge_panel_optation_view, this);
        this.gcw = (RelativeLayout) this.rootView.findViewById(a.g.root_container);
        this.gcy = (RelativeLayout) this.rootView.findViewById(a.g.anchor_live_anim_layout);
        this.gcz = (TbImageView) this.rootView.findViewById(a.g.anchor_live_anim_bg);
        this.gcB = (RelativeLayout) this.rootView.findViewById(a.g.rival_live_anim_layout);
        this.gcC = (TbImageView) this.rootView.findViewById(a.g.rival_live_anim_bg);
        this.gcx = (RelativeLayout) this.rootView.findViewById(a.g.pk_live_container);
        this.gcF = (RelativeLayout) this.rootView.findViewById(a.g.pk_anchor_live_layout);
        this.gcG = (RelativeLayout) this.rootView.findViewById(a.g.anchor_streak_win_layout);
        this.gcH = (ImageView) this.rootView.findViewById(a.g.anchor_user_pk_streak_img);
        this.gcI = (TextView) this.rootView.findViewById(a.g.anchor_user_pk_streak_time);
        this.gcE = (RelativeLayout) this.rootView.findViewById(a.g.jinzhu_container);
        this.gcJ = (LinearLayout) this.rootView.findViewById(a.g.anchor_jinzhu_layout);
        this.gcK = (ChallengeJinzhuView) this.rootView.findViewById(a.g.anchor_jinzhu_1);
        this.gcL = (ChallengeJinzhuView) this.rootView.findViewById(a.g.anchor_jinzhu_2);
        this.gcM = (ChallengeJinzhuView) this.rootView.findViewById(a.g.anchor_jinzhu_3);
        this.gcN = (LinearLayout) this.rootView.findViewById(a.g.anchor_jinzhu_click_area_layout);
        this.gcO = (RelativeLayout) this.rootView.findViewById(a.g.pk_rival_live_layout);
        this.gcP = (RelativeLayout) this.rootView.findViewById(a.g.pk_rival_user_layout);
        this.gcQ = (HeadImageView) this.rootView.findViewById(a.g.ala_live_rival_user_image);
        this.gcR = (TextView) this.rootView.findViewById(a.g.ala_live_rival_user_name);
        this.gcS = (ImageView) this.rootView.findViewById(a.g.iv_rival_user_follow);
        this.gcX = (RelativeLayout) this.rootView.findViewById(a.g.rival_streak_win_layout);
        this.gcT = (LinearLayout) this.rootView.findViewById(a.g.rival_jinzhu_layout);
        this.gcU = (ChallengeJinzhuView) this.rootView.findViewById(a.g.rival_jinzhu_1);
        this.gcV = (ChallengeJinzhuView) this.rootView.findViewById(a.g.rival_jinzhu_2);
        this.gcW = (ChallengeJinzhuView) this.rootView.findViewById(a.g.rival_jinzhu_3);
        this.gda = (LinearLayout) this.rootView.findViewById(a.g.rival_jinzhu_click_area_layout);
        this.gcY = (ImageView) this.rootView.findViewById(a.g.rival_user_pk_streak_img);
        this.gcZ = (TextView) this.rootView.findViewById(a.g.rival_user_pk_streak_time);
        this.gdd = (LinearLayout) this.rootView.findViewById(a.g.pk_time_layout);
        this.gde = (TextView) this.rootView.findViewById(a.g.pk_time_label);
        this.gdf = (RelativeLayout) this.rootView.findViewById(a.g.pk_score_progress_layout);
        this.gdg = (TextView) this.rootView.findViewById(a.g.pk_anchor_label);
        this.gdi = (TextView) this.rootView.findViewById(a.g.pk_anchor_progress);
        this.gdj = (TextView) this.rootView.findViewById(a.g.pk_rival_progress);
        this.gdh = (TextView) this.rootView.findViewById(a.g.pk_rival_label);
        this.gdm = (TextView) this.rootView.findViewById(a.g.btn_close_challenge_view);
        this.gdk = this.rootView.findViewById(a.g.anchor_progress_bg);
        this.gdl = this.rootView.findViewById(a.g.rival_progress_bg);
        this.gcA = this.rootView.findViewById(a.g.anchor_live_anim_fore_bg);
        this.gcD = this.rootView.findViewById(a.g.rival_live_anim_fore_bg);
        this.gdb = (AlaChallengeMvpTipView) this.rootView.findViewById(a.g.id_chellenge_mvp_tip);
        this.gdc = (AlaChallengeMvpDynamicAnimView) this.rootView.findViewById(a.g.id_challenge_mvp_anim_view);
        this.gcP.setVisibility(0);
        this.gcP.setBackgroundResource(a.f.sdk_round_host_header_bg);
        this.gcQ.setIsRound(true);
        this.gcQ.setAutoChangeStyle(false);
        this.gcQ.setDefaultBgResource(a.f.sdk_icon_default_avatar100_bg);
        this.gcQ.setIsNight(false);
        this.gcP.setOnClickListener(this);
        this.gcS.setOnClickListener(this);
        this.gdm.setOnClickListener(this);
        this.gcJ.setVisibility(8);
        this.gcT.setVisibility(8);
        this.gcN.setOnClickListener(this);
        this.gda.setOnClickListener(this);
        this.gcK.setClickListener(this);
        this.gcL.setClickListener(this);
        this.gcM.setClickListener(this);
        this.gcU.setClickListener(this);
        this.gcV.setClickListener(this);
        this.gcW.setClickListener(this);
    }

    private void updateView() {
        this.gdr = g.av(this.mContext);
        this.gdq = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds50);
        this.screenWidth = BdUtilHelper.getScreenDimensions(this.mContext)[0];
        int ay = g.ay(this.mContext);
        int ax = g.ax(this.mContext);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = this.gdr;
        layoutParams.height = ax;
        this.gcx.setLayoutParams(layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.gdc.getLayoutParams();
        layoutParams2.topMargin = this.gdr;
        this.gdc.setLayoutParams(layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(ay, ax);
        layoutParams3.addRule(9);
        this.gcF.setLayoutParams(layoutParams3);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(ay, ax);
        layoutParams4.addRule(11);
        this.gcO.setLayoutParams(layoutParams4);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(ay, ax);
        layoutParams5.addRule(11);
        layoutParams5.topMargin = this.gdr;
        this.gcB.setLayoutParams(layoutParams5);
        RelativeLayout.LayoutParams layoutParams6 = (RelativeLayout.LayoutParams) this.gdd.getLayoutParams();
        layoutParams6.topMargin = this.gdr;
        layoutParams6.addRule(14);
        this.gdd.setLayoutParams(layoutParams6);
        this.gdf.setAlpha(0.0f);
    }

    public View getAnchorAnimLiveLayout() {
        return this.gcy;
    }

    public View getAnchorAnimLiveForeBg() {
        return this.gcA;
    }

    public View getRivalAnimLiveLayout() {
        return this.gcB;
    }

    public View getRivalAnimLiveForeBg() {
        return this.gcD;
    }

    public TbImageView getAnchorAnimLiveBgView() {
        return this.gcz;
    }

    public void setAnchorUserViewBg(aq aqVar) {
        this.gcz.setScaleType(ImageView.ScaleType.FIT_XY);
        String str = "";
        if (aqVar.aBG != null) {
            str = aqVar.aBG.portrait;
        }
        this.gcz.startLoad(str, 12, false);
        this.gcz.setVisibility(0);
    }

    public void setRivalUserViewBg(aq aqVar) {
        this.gcC.setScaleType(ImageView.ScaleType.FIT_XY);
        String str = "";
        if (aqVar.aBG != null) {
            str = aqVar.aBG.portrait;
        }
        this.gcC.startLoad(str, 12, false);
    }

    public View getLeftTimeView() {
        return this.gdd;
    }

    public ViewGroup getLiveContainerView() {
        return this.gcx;
    }

    public View getScoreProgressLayout() {
        return this.gdf;
    }

    public View getJinzhuLayout() {
        return this.gcE;
    }

    public View getCloseBtnView() {
        return this.gdm;
    }

    public RelativeLayout getContainerView() {
        return this.gcw;
    }

    public void a(am amVar, aq aqVar, aq aqVar2, boolean z) {
        this.aBE = aqVar;
        this.aBF = aqVar2;
        int i = amVar.aBI;
        a(amVar.challengeId, i, amVar.aBM, amVar.aBL);
        w(amVar.aBN, amVar.aBO);
        if (z) {
            c(aqVar2);
        }
        if (i == 2) {
            setCloseBtnVisible(true);
            bDB();
        } else if (i == 3) {
            boolean z2 = com.baidu.live.v.a.Hm().aZp != null && com.baidu.live.v.a.Hm().aZp.azW == 1;
            if (z2) {
                this.gdm.setText(this.mContext.getResources().getString(a.i.ala_challenge_btn_close_label_2));
            }
            setCloseBtnVisible(z2);
            bC(amVar.challengeResult, amVar.aBP);
        } else {
            bvY();
            setCloseBtnVisible(false);
            bC(amVar.challengeResult, amVar.aBP);
        }
        a(aqVar.aCa);
        b(aqVar2.aCa);
        this.gds = amVar;
    }

    private void a(al alVar) {
        ArrayList arrayList;
        if (alVar == null) {
            this.gcK.setVisibility(8);
            this.gcL.setVisibility(8);
            this.gcM.setVisibility(8);
            return;
        }
        this.gcJ.setVisibility(0);
        if (ListUtils.isEmpty(alVar.aBH)) {
            alVar.aBH = this.gdu;
        }
        if (ListUtils.isEmpty(alVar.aBH)) {
            this.gcK.setVisibility(0);
            this.gcL.setVisibility(8);
            this.gcM.setVisibility(8);
            this.gcK.a(true, null, alVar.liveId);
            return;
        }
        this.gdu = alVar.aBH;
        this.gcK.setVisibility(8);
        this.gcL.setVisibility(8);
        this.gcM.setVisibility(8);
        if (alVar.aBH.size() > 3) {
            ArrayList arrayList2 = new ArrayList();
            for (int i = 0; i < 3; i++) {
                arrayList2.add(alVar.aBH.get(i));
            }
            arrayList = arrayList2;
        } else {
            arrayList = alVar.aBH;
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            ak akVar = arrayList.get(i2);
            if (akVar != null) {
                if (akVar.wN() || akVar.isFirst()) {
                    this.gcK.setVisibility(0);
                    this.gcK.a(true, akVar, alVar.liveId);
                } else if (akVar.rank == 2) {
                    this.gcL.setVisibility(0);
                    this.gcL.a(true, akVar, alVar.liveId);
                } else if (akVar.rank == 3) {
                    this.gcM.setVisibility(0);
                    this.gcM.a(true, akVar, alVar.liveId);
                }
            }
        }
    }

    private void b(al alVar) {
        List<ak> list;
        if (alVar == null) {
            this.gcU.setVisibility(8);
            this.gcV.setVisibility(8);
            this.gcW.setVisibility(8);
            return;
        }
        this.gcT.setVisibility(0);
        if (ListUtils.isEmpty(alVar.aBH)) {
            alVar.aBH = this.gdv;
        }
        if (ListUtils.isEmpty(alVar.aBH)) {
            this.gcU.setVisibility(0);
            this.gcV.setVisibility(8);
            this.gcW.setVisibility(8);
            this.gcU.a(false, null, alVar.liveId);
            return;
        }
        this.gdv = alVar.aBH;
        this.gcU.setVisibility(8);
        this.gcV.setVisibility(8);
        this.gcW.setVisibility(8);
        if (alVar.aBH.size() > 3) {
            list = alVar.aBH.subList(0, 3);
        } else {
            list = alVar.aBH;
        }
        for (int i = 0; i < list.size(); i++) {
            ak akVar = list.get(i);
            if (akVar != null) {
                if (akVar.wN() || akVar.isFirst()) {
                    this.gcU.setVisibility(0);
                    this.gcU.a(false, akVar, alVar.liveId);
                } else if (akVar.rank == 2) {
                    this.gcV.setVisibility(0);
                    this.gcV.a(false, akVar, alVar.liveId);
                } else if (akVar.rank == 3) {
                    this.gcW.setVisibility(0);
                    this.gcW.a(false, akVar, alVar.liveId);
                }
            }
        }
    }

    private void a(long j, int i, long j2, long j3) {
        if (j3 >= j2 && a(j, i, j3)) {
            bvY();
            if (this.gds != null) {
                v(this.gds.aBI, (j3 - j2) * 1000);
            }
            this.fzZ = new CountDownTimer((j3 - j2) * 1000, 1000L) { // from class: com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeLiveView.1
                @Override // android.os.CountDownTimer
                public void onTick(long j4) {
                    if (AlaChallengeLiveView.this.gds != null) {
                        AlaChallengeLiveView.this.v(AlaChallengeLiveView.this.gds.aBI, j4);
                    }
                }

                @Override // android.os.CountDownTimer
                public void onFinish() {
                    if (AlaChallengeLiveView.this.gds != null) {
                        AlaChallengeLiveView.this.v(AlaChallengeLiveView.this.gds.aBI, 0L);
                    }
                }
            };
            this.fzZ.start();
        }
    }

    private boolean a(long j, int i, long j2) {
        return (this.gds != null && this.gds.challengeId == j && this.gds.aBI == i && this.gds.aBL == j2) ? false : true;
    }

    private void bvY() {
        if (this.fzZ != null) {
            this.fzZ.cancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(int i, long j) {
        if (this.gde != null) {
            String formatSecondsTime = StringHelper.formatSecondsTime(Math.round(j / 1000.0d));
            String string = this.mContext.getString(a.i.ala_challenge_operate_challenge_time, formatSecondsTime);
            if (i == 2) {
                string = this.mContext.getString(a.i.ala_challenge_operate_challenge_time, formatSecondsTime);
            } else if (i == 3) {
                string = this.mContext.getString(a.i.ala_challenge_operate_publish_time, formatSecondsTime);
            } else if (i == 4) {
                string = this.mContext.getString(a.i.ala_challenge_operate_over_time);
            }
            this.gde.setText(string);
        }
    }

    public void setLiveContainerVisible(boolean z) {
        this.gcx.setVisibility(z ? 0 : 4);
    }

    public void setCloseBtnVisible(boolean z) {
        if (this.isHost) {
            this.gdm.setVisibility(z ? 0 : 4);
        } else {
            this.gdm.setVisibility(4);
        }
    }

    public void bDA() {
        setCloseBtnVisible(false);
        this.gdm.setText(this.mContext.getResources().getString(a.i.ala_challenge_btn_close_label));
        this.gdb.zo();
        this.gdc.bDK();
        setLiveContainerVisible(false);
        if (this.gdu != null) {
            this.gdu.clear();
            this.gdu = null;
        }
        if (this.gdv != null) {
            this.gdv.clear();
            this.gdv = null;
        }
        this.gds = null;
    }

    public void bC(int i, int i2) {
        this.gcG.setVisibility(0);
        this.gcX.setVisibility(0);
        this.gcI.setVisibility(4);
        this.gcZ.setVisibility(4);
        if (1 == i) {
            this.gcH.setImageResource(a.f.icon_live_vs_win);
            if (i2 >= 2) {
                this.gcI.setVisibility(0);
                this.gcI.setText(this.mContext.getResources().getString(a.i.ala_challenge_streak_win_label, Integer.valueOf(i2)));
            } else {
                this.gcI.setText("");
            }
            this.gcY.setImageResource(a.f.icon_live_vs_lose);
        } else if (3 == i) {
            this.gcH.setImageResource(a.f.icon_live_vs_draw);
            this.gcY.setImageResource(a.f.icon_live_vs_draw);
        } else if (2 == i) {
            this.gcH.setImageResource(a.f.icon_live_vs_lose);
            if (i2 >= 2) {
                this.gcZ.setVisibility(0);
                this.gcZ.setText(this.mContext.getResources().getString(a.i.ala_challenge_streak_win_label, Integer.valueOf(i2)));
            } else {
                this.gcZ.setText("");
            }
            this.gcY.setImageResource(a.f.icon_live_vs_win);
        } else {
            bDB();
        }
    }

    public void bDB() {
        this.gcG.setVisibility(4);
        this.gcX.setVisibility(4);
    }

    public void bDC() {
        if (this.gdu != null) {
            this.gdu.clear();
            this.gdu = null;
        }
        if (this.gdv != null) {
            this.gdv.clear();
            this.gdv = null;
        }
    }

    private void w(long j, long j2) {
        int i;
        if (this.gdo != j || this.gdp != j2) {
            this.gdo = j;
            this.gdp = j2;
            this.gdi.setText(String.valueOf(this.gdo));
            this.gdj.setText(String.valueOf(this.gdp));
            float f = (float) (this.gdo + this.gdp);
            final int dimensionPixelSize = (this.screenWidth - (this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds20) * 2)) - (this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds6) * 2);
            int i2 = dimensionPixelSize / 2;
            if (f != 0.0f) {
                int i3 = (int) ((((float) this.gdo) / f) * dimensionPixelSize);
                int i4 = ((LinearLayout.LayoutParams) this.gdk.getLayoutParams()).width;
                if (i3 < this.gdq) {
                    i = this.gdq;
                } else {
                    i = i3 > dimensionPixelSize - this.gdq ? dimensionPixelSize - this.gdq : i3;
                }
                if (this.gdt != null) {
                    this.gdt.cancel();
                }
                this.gdt = ValueAnimator.ofInt(i4, i);
                this.gdt.setDuration(100L);
                this.gdt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeLiveView.2
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) AlaChallengeLiveView.this.gdk.getLayoutParams();
                        layoutParams.width = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                        AlaChallengeLiveView.this.gdk.setLayoutParams(layoutParams);
                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) AlaChallengeLiveView.this.gdl.getLayoutParams();
                        layoutParams2.width = dimensionPixelSize - layoutParams.width;
                        AlaChallengeLiveView.this.gdl.setLayoutParams(layoutParams2);
                    }
                });
                this.gdt.start();
                return;
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gdk.getLayoutParams();
            layoutParams.width = i2;
            this.gdk.setLayoutParams(layoutParams);
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.gdl.getLayoutParams();
            layoutParams2.width = dimensionPixelSize - layoutParams.width;
            this.gdl.setLayoutParams(layoutParams2);
        }
    }

    public void c(aq aqVar) {
        if (aqVar == null || aqVar.aBG == null) {
            this.gcP.setVisibility(4);
            return;
        }
        this.gcP.setTag(aqVar);
        this.gcQ.startLoad(aqVar.aBG.portrait, 12, false, false);
        String str = aqVar.aBG.userName;
        if (TextHelper.getTextLengthWithEmoji(str) > 8) {
            str = TextHelper.subStringWithEmoji(str, 8) + StringHelper.STRING_MORE;
        }
        this.gcR.setText(str);
        this.gcS.setVisibility(8);
    }

    public void kQ(boolean z) {
        if (this.gcS != null) {
            this.gcS.setVisibility(z ? 8 : 0);
        }
    }

    public View getRivalUserInfoView() {
        return this.gcP;
    }

    public void releaseResource() {
        bvY();
        this.gdm.setText(this.mContext.getResources().getString(a.i.ala_challenge_btn_close_label));
        this.gdb.zo();
        this.gdc.bDK();
        this.gds = null;
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z = true;
        if (view == this.gdm) {
            if (this.gdn != null) {
                if (com.baidu.live.v.a.Hm().aZp == null || this.gds == null || this.gds.aBI != 3 || com.baidu.live.v.a.Hm().aZp.azW != 1) {
                    z = false;
                }
                if (z) {
                    if (this.gds != null) {
                        this.gdn.a(this.gds.aBS);
                        return;
                    }
                    return;
                }
                this.gdn.bDE();
            }
        } else if (view == this.gcP) {
            if (this.gdn != null) {
                if (this.gdw) {
                    this.gdn.bDF();
                } else {
                    this.gdn.d((aq) this.gcP.getTag());
                }
            }
        } else if (view == this.gcS) {
            if (this.gdn != null) {
                if (this.gdw) {
                    this.gdn.bDF();
                } else {
                    this.gdn.e((aq) this.gcP.getTag());
                }
            }
        } else if (view == this.gcO) {
            if (this.gdn != null) {
                if (this.gdw) {
                    this.gdn.bDF();
                } else {
                    this.gdn.f(this.aBF);
                }
            }
        } else if (view == this.gcN) {
            this.gdn.kR(false);
        } else if (view == this.gda) {
            this.gdn.kR(true);
        }
    }

    public void setViewClickCallBack(a aVar) {
        this.gdn = aVar;
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.view.ChallengeJinzhuView.a
    public void bDD() {
        if (this.gdn != null) {
            this.gdn.bDF();
        }
    }
}
