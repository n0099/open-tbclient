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
import com.baidu.live.data.ai;
import com.baidu.live.data.aj;
import com.baidu.live.data.ak;
import com.baidu.live.data.al;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.util.TextHelper;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.live.u.a;
import com.baidu.live.utils.g;
import com.baidu.tieba.ala.liveroom.challenge.view.ChallengeJinzhuView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class AlaChallengeLiveView extends RelativeLayout implements View.OnClickListener, ChallengeJinzhuView.a {
    private al azm;
    private al azn;
    private ChallengeJinzhuView fQA;
    private ChallengeJinzhuView fQB;
    private RelativeLayout fQC;
    private RelativeLayout fQD;
    private HeadImageView fQE;
    private TextView fQF;
    private LinearLayout fQG;
    private ChallengeJinzhuView fQH;
    private ChallengeJinzhuView fQI;
    private ChallengeJinzhuView fQJ;
    private LinearLayout fQK;
    private ImageView fQL;
    private TextView fQM;
    private LinearLayout fQN;
    private TextView fQO;
    private RelativeLayout fQP;
    private TextView fQQ;
    private TextView fQR;
    private TextView fQS;
    private TextView fQT;
    private View fQU;
    private View fQV;
    private TextView fQW;
    private a fQX;
    private long fQY;
    private long fQZ;
    private RelativeLayout fQl;
    private RelativeLayout fQm;
    private RelativeLayout fQn;
    private TbImageView fQo;
    private View fQp;
    private RelativeLayout fQq;
    private TbImageView fQr;
    private View fQs;
    private RelativeLayout fQt;
    private RelativeLayout fQu;
    private LinearLayout fQv;
    private ImageView fQw;
    private TextView fQx;
    private LinearLayout fQy;
    private ChallengeJinzhuView fQz;
    private int fRa;
    private int fRb;
    private ak fRc;
    private ValueAnimator fRd;
    private List<ai> fRe;
    private List<ai> fRf;
    public boolean fRg;
    private CountDownTimer foC;
    private boolean isHost;
    private Context mContext;
    private Handler mHandler;
    private RelativeLayout rootView;
    private int screenWidth;

    /* loaded from: classes3.dex */
    public interface a {
        void bAD();

        void bAE();

        void d(al alVar);

        void e(al alVar);
    }

    public AlaChallengeLiveView(Context context) {
        super(context);
        this.isHost = false;
        this.fQY = -1L;
        this.fQZ = -1L;
        this.screenWidth = -1;
        this.fRa = 0;
        this.fRb = 0;
        this.fRg = false;
        init(context);
    }

    public AlaChallengeLiveView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isHost = false;
        this.fQY = -1L;
        this.fQZ = -1L;
        this.screenWidth = -1;
        this.fRa = 0;
        this.fRb = 0;
        this.fRg = false;
        init(context);
    }

    public AlaChallengeLiveView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isHost = false;
        this.fQY = -1L;
        this.fQZ = -1L;
        this.screenWidth = -1;
        this.fRa = 0;
        this.fRb = 0;
        this.fRg = false;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.mHandler = new Handler(Looper.getMainLooper());
        initView(context);
        updateView();
    }

    public void setNeedCloseRecommendFloat(boolean z) {
        this.fRg = z;
        this.fQz.setNeedCloseRecommendFloat(this.fRg);
        this.fQA.setNeedCloseRecommendFloat(this.fRg);
        this.fQB.setNeedCloseRecommendFloat(this.fRg);
        this.fQH.setNeedCloseRecommendFloat(this.fRg);
        this.fQI.setNeedCloseRecommendFloat(this.fRg);
        this.fQJ.setNeedCloseRecommendFloat(this.fRg);
    }

    public void setIsHost(boolean z) {
        this.isHost = z;
    }

    private void initView(Context context) {
        this.rootView = (RelativeLayout) View.inflate(context, a.h.ala_challenge_panel_optation_view, this);
        this.fQl = (RelativeLayout) this.rootView.findViewById(a.g.root_container);
        this.fQn = (RelativeLayout) this.rootView.findViewById(a.g.anchor_live_anim_layout);
        this.fQo = (TbImageView) this.rootView.findViewById(a.g.anchor_live_anim_bg);
        this.fQq = (RelativeLayout) this.rootView.findViewById(a.g.rival_live_anim_layout);
        this.fQr = (TbImageView) this.rootView.findViewById(a.g.rival_live_anim_bg);
        this.fQm = (RelativeLayout) this.rootView.findViewById(a.g.pk_live_container);
        this.fQu = (RelativeLayout) this.rootView.findViewById(a.g.pk_anchor_live_layout);
        this.fQv = (LinearLayout) this.rootView.findViewById(a.g.anchor_streak_win_layout);
        this.fQw = (ImageView) this.rootView.findViewById(a.g.anchor_user_pk_streak_img);
        this.fQx = (TextView) this.rootView.findViewById(a.g.anchor_user_pk_streak_time);
        this.fQt = (RelativeLayout) this.rootView.findViewById(a.g.jinzhu_container);
        this.fQy = (LinearLayout) this.rootView.findViewById(a.g.anchor_jinzhu_layout);
        this.fQz = (ChallengeJinzhuView) this.rootView.findViewById(a.g.anchor_jinzhu_1);
        this.fQA = (ChallengeJinzhuView) this.rootView.findViewById(a.g.anchor_jinzhu_2);
        this.fQB = (ChallengeJinzhuView) this.rootView.findViewById(a.g.anchor_jinzhu_3);
        this.fQC = (RelativeLayout) this.rootView.findViewById(a.g.pk_rival_live_layout);
        this.fQD = (RelativeLayout) this.rootView.findViewById(a.g.pk_rival_user_layout);
        this.fQE = (HeadImageView) this.rootView.findViewById(a.g.ala_live_rival_user_image);
        this.fQF = (TextView) this.rootView.findViewById(a.g.ala_live_rival_user_name);
        this.fQK = (LinearLayout) this.rootView.findViewById(a.g.rival_streak_win_layout);
        this.fQG = (LinearLayout) this.rootView.findViewById(a.g.rival_jinzhu_layout);
        this.fQH = (ChallengeJinzhuView) this.rootView.findViewById(a.g.rival_jinzhu_1);
        this.fQI = (ChallengeJinzhuView) this.rootView.findViewById(a.g.rival_jinzhu_2);
        this.fQJ = (ChallengeJinzhuView) this.rootView.findViewById(a.g.rival_jinzhu_3);
        this.fQL = (ImageView) this.rootView.findViewById(a.g.rival_user_pk_streak_img);
        this.fQM = (TextView) this.rootView.findViewById(a.g.rival_user_pk_streak_time);
        this.fQN = (LinearLayout) this.rootView.findViewById(a.g.pk_time_layout);
        this.fQO = (TextView) this.rootView.findViewById(a.g.pk_time_label);
        this.fQP = (RelativeLayout) this.rootView.findViewById(a.g.pk_score_progress_layout);
        this.fQQ = (TextView) this.rootView.findViewById(a.g.pk_anchor_label);
        this.fQS = (TextView) this.rootView.findViewById(a.g.pk_anchor_progress);
        this.fQT = (TextView) this.rootView.findViewById(a.g.pk_rival_progress);
        this.fQR = (TextView) this.rootView.findViewById(a.g.pk_rival_label);
        this.fQW = (TextView) this.rootView.findViewById(a.g.btn_close_challenge_view);
        this.fQU = this.rootView.findViewById(a.g.anchor_progress_bg);
        this.fQV = this.rootView.findViewById(a.g.rival_progress_bg);
        this.fQp = this.rootView.findViewById(a.g.anchor_live_anim_fore_bg);
        this.fQs = this.rootView.findViewById(a.g.rival_live_anim_fore_bg);
        this.fQD.setVisibility(0);
        this.fQD.setBackgroundResource(a.f.sdk_round_host_header_bg);
        this.fQE.setIsRound(true);
        this.fQE.setAutoChangeStyle(false);
        this.fQE.setDefaultBgResource(a.f.sdk_icon_default_avatar100_bg);
        this.fQE.setIsNight(false);
        this.fQC.setOnClickListener(this);
        this.fQD.setOnClickListener(this);
        this.fQW.setOnClickListener(this);
        this.fQy.setVisibility(8);
        this.fQG.setVisibility(8);
        this.fQz.setClickListener(this);
        this.fQA.setClickListener(this);
        this.fQB.setClickListener(this);
        this.fQH.setClickListener(this);
        this.fQI.setClickListener(this);
        this.fQJ.setClickListener(this);
    }

    private void updateView() {
        this.fRb = g.au(this.mContext);
        this.fRa = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds50);
        this.screenWidth = BdUtilHelper.getScreenDimensions(this.mContext)[0];
        int ax = g.ax(this.mContext);
        int aw = g.aw(this.mContext);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = this.fRb;
        layoutParams.height = aw;
        this.fQm.setLayoutParams(layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(ax, aw);
        layoutParams2.addRule(9);
        this.fQu.setLayoutParams(layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(ax, aw);
        layoutParams3.addRule(11);
        this.fQC.setLayoutParams(layoutParams3);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(ax, aw);
        layoutParams4.addRule(11);
        layoutParams4.topMargin = this.fRb;
        this.fQq.setLayoutParams(layoutParams4);
        RelativeLayout.LayoutParams layoutParams5 = (RelativeLayout.LayoutParams) this.fQN.getLayoutParams();
        layoutParams5.topMargin = this.fRb;
        layoutParams5.addRule(14);
        this.fQN.setLayoutParams(layoutParams5);
        this.fQP.setAlpha(0.0f);
    }

    public View getAnchorAnimLiveLayout() {
        return this.fQn;
    }

    public View getAnchorAnimLiveForeBg() {
        return this.fQp;
    }

    public View getRivalAnimLiveLayout() {
        return this.fQq;
    }

    public View getRivalAnimLiveForeBg() {
        return this.fQs;
    }

    public TbImageView getAnchorAnimLiveBgView() {
        return this.fQo;
    }

    public void setAnchorUserViewBg(al alVar) {
        this.fQo.setScaleType(ImageView.ScaleType.FIT_XY);
        String str = "";
        if (alVar.azo != null) {
            str = alVar.azo.portrait;
        }
        this.fQo.startLoad(str, 12, false);
        this.fQo.setVisibility(0);
    }

    public void setRivalUserViewBg(al alVar) {
        this.fQr.setScaleType(ImageView.ScaleType.FIT_XY);
        String str = "";
        if (alVar.azo != null) {
            str = alVar.azo.portrait;
        }
        this.fQr.startLoad(str, 12, false);
    }

    public View getLeftTimeView() {
        return this.fQN;
    }

    public ViewGroup getLiveContainerView() {
        return this.fQm;
    }

    public View getScoreProgressLayout() {
        return this.fQP;
    }

    public View getJinzhuLayout() {
        return this.fQt;
    }

    public View getCloseBtnView() {
        return this.fQW;
    }

    public RelativeLayout getContainerView() {
        return this.fQl;
    }

    public void a(ak akVar, al alVar, al alVar2, boolean z) {
        this.azm = alVar;
        this.azn = alVar2;
        int i = akVar.azq;
        a(akVar.challengeId, i, akVar.azu, akVar.azt);
        x(akVar.azv, akVar.azw);
        if (z) {
            c(alVar2);
        }
        if (i == 2) {
            setCloseBtnVisible(true);
            bAA();
        } else if (i == 3) {
            setCloseBtnVisible(false);
            by(akVar.challengeResult, akVar.azx);
        } else {
            btc();
            setCloseBtnVisible(false);
            by(akVar.challengeResult, akVar.azx);
        }
        a(alVar.azB);
        b(alVar2.azB);
        this.fRc = akVar;
    }

    private void a(aj ajVar) {
        ArrayList arrayList;
        if (ajVar == null) {
            this.fQz.setVisibility(8);
            this.fQA.setVisibility(8);
            this.fQB.setVisibility(8);
            return;
        }
        this.fQy.setVisibility(0);
        if (ListUtils.isEmpty(ajVar.azp)) {
            ajVar.azp = this.fRe;
        }
        if (ListUtils.isEmpty(ajVar.azp)) {
            this.fQz.setVisibility(0);
            this.fQA.setVisibility(8);
            this.fQB.setVisibility(8);
            this.fQz.a(true, null, ajVar.liveId);
            return;
        }
        this.fRe = ajVar.azp;
        this.fQz.setVisibility(8);
        this.fQA.setVisibility(8);
        this.fQB.setVisibility(8);
        if (ajVar.azp.size() > 3) {
            ArrayList arrayList2 = new ArrayList();
            for (int i = 0; i < 3; i++) {
                arrayList2.add(ajVar.azp.get(i));
            }
            arrayList = arrayList2;
        } else {
            arrayList = ajVar.azp;
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            ai aiVar = arrayList.get(i2);
            if (aiVar != null) {
                if (aiVar.wp() || aiVar.isFirst()) {
                    this.fQz.setVisibility(0);
                    this.fQz.a(true, aiVar, ajVar.liveId);
                } else if (aiVar.rank == 2) {
                    this.fQA.setVisibility(0);
                    this.fQA.a(true, aiVar, ajVar.liveId);
                } else if (aiVar.rank == 3) {
                    this.fQB.setVisibility(0);
                    this.fQB.a(true, aiVar, ajVar.liveId);
                }
            }
        }
    }

    private void b(aj ajVar) {
        List<ai> list;
        if (ajVar == null) {
            this.fQH.setVisibility(8);
            this.fQI.setVisibility(8);
            this.fQJ.setVisibility(8);
            return;
        }
        this.fQG.setVisibility(0);
        if (ListUtils.isEmpty(ajVar.azp)) {
            ajVar.azp = this.fRf;
        }
        if (ListUtils.isEmpty(ajVar.azp)) {
            this.fQH.setVisibility(0);
            this.fQI.setVisibility(8);
            this.fQJ.setVisibility(8);
            this.fQH.a(false, null, ajVar.liveId);
            return;
        }
        this.fRf = ajVar.azp;
        this.fQH.setVisibility(8);
        this.fQI.setVisibility(8);
        this.fQJ.setVisibility(8);
        if (ajVar.azp.size() > 3) {
            list = ajVar.azp.subList(0, 3);
        } else {
            list = ajVar.azp;
        }
        for (int i = 0; i < list.size(); i++) {
            ai aiVar = list.get(i);
            if (aiVar != null) {
                if (aiVar.wp() || aiVar.isFirst()) {
                    this.fQH.setVisibility(0);
                    this.fQH.a(false, aiVar, ajVar.liveId);
                } else if (aiVar.rank == 2) {
                    this.fQI.setVisibility(0);
                    this.fQI.a(false, aiVar, ajVar.liveId);
                } else if (aiVar.rank == 3) {
                    this.fQJ.setVisibility(0);
                    this.fQJ.a(false, aiVar, ajVar.liveId);
                }
            }
        }
    }

    private void a(long j, int i, long j2, long j3) {
        if (j3 >= j2 && a(j, i, j3)) {
            btc();
            if (this.fRc != null) {
                u(this.fRc.azq, (j3 - j2) * 1000);
            }
            this.foC = new CountDownTimer((j3 - j2) * 1000, 1000L) { // from class: com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeLiveView.1
                @Override // android.os.CountDownTimer
                public void onTick(long j4) {
                    if (AlaChallengeLiveView.this.fRc != null) {
                        AlaChallengeLiveView.this.u(AlaChallengeLiveView.this.fRc.azq, j4);
                    }
                }

                @Override // android.os.CountDownTimer
                public void onFinish() {
                    if (AlaChallengeLiveView.this.fRc != null) {
                        AlaChallengeLiveView.this.u(AlaChallengeLiveView.this.fRc.azq, 0L);
                    }
                }
            };
            this.foC.start();
        }
    }

    private boolean a(long j, int i, long j2) {
        return (this.fRc != null && this.fRc.challengeId == j && this.fRc.azq == i && this.fRc.azt == j2) ? false : true;
    }

    private void btc() {
        if (this.foC != null) {
            this.foC.cancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(int i, long j) {
        if (this.fQO != null) {
            String formatSecondsTime = StringHelper.formatSecondsTime(Math.round(j / 1000.0d));
            String string = this.mContext.getString(a.i.ala_challenge_operate_challenge_time, formatSecondsTime);
            if (i == 2) {
                string = this.mContext.getString(a.i.ala_challenge_operate_challenge_time, formatSecondsTime);
            } else if (i == 3) {
                string = this.mContext.getString(a.i.ala_challenge_operate_publish_time, formatSecondsTime);
            } else if (i == 4) {
                string = this.mContext.getString(a.i.ala_challenge_operate_over_time);
            }
            this.fQO.setText(string);
        }
    }

    public void setLiveContainerVisible(boolean z) {
        this.fQm.setVisibility(z ? 0 : 4);
    }

    public void setCloseBtnVisible(boolean z) {
        if (this.isHost) {
            this.fQW.setVisibility(z ? 0 : 4);
        } else {
            this.fQW.setVisibility(4);
        }
    }

    public void bAz() {
        setCloseBtnVisible(false);
        setLiveContainerVisible(false);
        if (this.fRe != null) {
            this.fRe.clear();
            this.fRe = null;
        }
        if (this.fRf != null) {
            this.fRf.clear();
            this.fRf = null;
        }
        this.fRc = null;
    }

    public void by(int i, int i2) {
        this.fQv.setVisibility(0);
        this.fQK.setVisibility(0);
        this.fQx.setVisibility(4);
        this.fQM.setVisibility(4);
        if (1 == i) {
            this.fQw.setImageResource(a.f.icon_live_vs_win);
            if (i2 >= 2) {
                this.fQx.setVisibility(0);
                this.fQx.setText(this.mContext.getResources().getString(a.i.ala_challenge_streak_win_label, Integer.valueOf(i2)));
            } else {
                this.fQx.setText("");
            }
            this.fQL.setImageResource(a.f.icon_live_vs_lose);
        } else if (3 == i) {
            this.fQw.setImageResource(a.f.icon_live_vs_draw);
            this.fQL.setImageResource(a.f.icon_live_vs_draw);
        } else if (2 == i) {
            this.fQw.setImageResource(a.f.icon_live_vs_lose);
            if (i2 >= 2) {
                this.fQM.setVisibility(0);
                this.fQM.setText(this.mContext.getResources().getString(a.i.ala_challenge_streak_win_label, Integer.valueOf(i2)));
            } else {
                this.fQM.setText("");
            }
            this.fQL.setImageResource(a.f.icon_live_vs_win);
        } else {
            bAA();
        }
    }

    public void bAA() {
        this.fQv.setVisibility(4);
        this.fQK.setVisibility(4);
    }

    public void bAB() {
        if (this.fRe != null) {
            this.fRe.clear();
            this.fRe = null;
        }
        if (this.fRf != null) {
            this.fRf.clear();
            this.fRf = null;
        }
    }

    private void x(long j, long j2) {
        int i;
        if (this.fQY != j || this.fQZ != j2) {
            this.fQY = j;
            this.fQZ = j2;
            this.fQS.setText(String.valueOf(this.fQY));
            this.fQT.setText(String.valueOf(this.fQZ));
            float f = (float) (this.fQY + this.fQZ);
            final int dimensionPixelSize = (this.screenWidth - (this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds20) * 2)) - (this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds6) * 2);
            int i2 = dimensionPixelSize / 2;
            if (f != 0.0f) {
                int i3 = (int) ((((float) this.fQY) / f) * dimensionPixelSize);
                int i4 = ((LinearLayout.LayoutParams) this.fQU.getLayoutParams()).width;
                if (i3 < this.fRa) {
                    i = this.fRa;
                } else {
                    i = i3 > dimensionPixelSize - this.fRa ? dimensionPixelSize - this.fRa : i3;
                }
                if (this.fRd != null) {
                    this.fRd.cancel();
                }
                this.fRd = ValueAnimator.ofInt(i4, i);
                this.fRd.setDuration(100L);
                this.fRd.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeLiveView.2
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) AlaChallengeLiveView.this.fQU.getLayoutParams();
                        layoutParams.width = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                        AlaChallengeLiveView.this.fQU.setLayoutParams(layoutParams);
                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) AlaChallengeLiveView.this.fQV.getLayoutParams();
                        layoutParams2.width = dimensionPixelSize - layoutParams.width;
                        AlaChallengeLiveView.this.fQV.setLayoutParams(layoutParams2);
                    }
                });
                this.fRd.start();
                return;
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fQU.getLayoutParams();
            layoutParams.width = i2;
            this.fQU.setLayoutParams(layoutParams);
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.fQV.getLayoutParams();
            layoutParams2.width = dimensionPixelSize - layoutParams.width;
            this.fQV.setLayoutParams(layoutParams2);
        }
    }

    public void c(al alVar) {
        if (alVar == null || alVar.azo == null) {
            this.fQD.setVisibility(4);
            return;
        }
        this.fQD.setTag(alVar);
        this.fQE.startLoad(alVar.azo.portrait, 12, false, false);
        String str = alVar.azo.userName;
        if (TextHelper.getTextLengthWithEmoji(str) > 12) {
            str = TextHelper.subStringWithEmoji(str, 12) + StringHelper.STRING_MORE;
        }
        this.fQF.setText(str);
    }

    public View getRivalUserInfoView() {
        return this.fQD;
    }

    public void releaseResource() {
        btc();
        this.fRc = null;
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.fQW) {
            if (this.fQX != null) {
                this.fQX.bAD();
            }
        } else if (view == this.fQD) {
            if (this.fQX != null) {
                if (this.fRg) {
                    this.fQX.bAE();
                } else {
                    this.fQX.d((al) this.fQD.getTag());
                }
            }
        } else if (view == this.fQC && this.fQX != null) {
            if (this.fRg) {
                this.fQX.bAE();
            } else {
                this.fQX.e(this.azn);
            }
        }
    }

    public void setViewClickCallBack(a aVar) {
        this.fQX = aVar;
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.view.ChallengeJinzhuView.a
    public void bAC() {
        if (this.fQX != null) {
            this.fQX.bAE();
        }
    }
}
