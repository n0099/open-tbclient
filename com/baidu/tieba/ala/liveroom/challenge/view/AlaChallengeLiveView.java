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
    private View fQA;
    private RelativeLayout fQB;
    private TbImageView fQC;
    private View fQD;
    private RelativeLayout fQE;
    private RelativeLayout fQF;
    private LinearLayout fQG;
    private ImageView fQH;
    private TextView fQI;
    private LinearLayout fQJ;
    private ChallengeJinzhuView fQK;
    private ChallengeJinzhuView fQL;
    private ChallengeJinzhuView fQM;
    private RelativeLayout fQN;
    private RelativeLayout fQO;
    private HeadImageView fQP;
    private TextView fQQ;
    private LinearLayout fQR;
    private ChallengeJinzhuView fQS;
    private ChallengeJinzhuView fQT;
    private ChallengeJinzhuView fQU;
    private LinearLayout fQV;
    private ImageView fQW;
    private TextView fQX;
    private LinearLayout fQY;
    private TextView fQZ;
    private RelativeLayout fQw;
    private RelativeLayout fQx;
    private RelativeLayout fQy;
    private TbImageView fQz;
    private RelativeLayout fRa;
    private TextView fRb;
    private TextView fRc;
    private TextView fRd;
    private TextView fRe;
    private View fRf;
    private View fRg;
    private TextView fRh;
    private a fRi;
    private long fRj;
    private long fRk;
    private int fRl;
    private int fRm;
    private ak fRn;
    private ValueAnimator fRo;
    private List<ai> fRp;
    private List<ai> fRq;
    public boolean fRr;
    private CountDownTimer foN;
    private boolean isHost;
    private Context mContext;
    private Handler mHandler;
    private RelativeLayout rootView;
    private int screenWidth;

    /* loaded from: classes3.dex */
    public interface a {
        void bAF();

        void bAG();

        void d(al alVar);

        void e(al alVar);
    }

    public AlaChallengeLiveView(Context context) {
        super(context);
        this.isHost = false;
        this.fRj = -1L;
        this.fRk = -1L;
        this.screenWidth = -1;
        this.fRl = 0;
        this.fRm = 0;
        this.fRr = false;
        init(context);
    }

    public AlaChallengeLiveView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isHost = false;
        this.fRj = -1L;
        this.fRk = -1L;
        this.screenWidth = -1;
        this.fRl = 0;
        this.fRm = 0;
        this.fRr = false;
        init(context);
    }

    public AlaChallengeLiveView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isHost = false;
        this.fRj = -1L;
        this.fRk = -1L;
        this.screenWidth = -1;
        this.fRl = 0;
        this.fRm = 0;
        this.fRr = false;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.mHandler = new Handler(Looper.getMainLooper());
        initView(context);
        updateView();
    }

    public void setNeedCloseRecommendFloat(boolean z) {
        this.fRr = z;
        this.fQK.setNeedCloseRecommendFloat(this.fRr);
        this.fQL.setNeedCloseRecommendFloat(this.fRr);
        this.fQM.setNeedCloseRecommendFloat(this.fRr);
        this.fQS.setNeedCloseRecommendFloat(this.fRr);
        this.fQT.setNeedCloseRecommendFloat(this.fRr);
        this.fQU.setNeedCloseRecommendFloat(this.fRr);
    }

    public void setIsHost(boolean z) {
        this.isHost = z;
    }

    private void initView(Context context) {
        this.rootView = (RelativeLayout) View.inflate(context, a.h.ala_challenge_panel_optation_view, this);
        this.fQw = (RelativeLayout) this.rootView.findViewById(a.g.root_container);
        this.fQy = (RelativeLayout) this.rootView.findViewById(a.g.anchor_live_anim_layout);
        this.fQz = (TbImageView) this.rootView.findViewById(a.g.anchor_live_anim_bg);
        this.fQB = (RelativeLayout) this.rootView.findViewById(a.g.rival_live_anim_layout);
        this.fQC = (TbImageView) this.rootView.findViewById(a.g.rival_live_anim_bg);
        this.fQx = (RelativeLayout) this.rootView.findViewById(a.g.pk_live_container);
        this.fQF = (RelativeLayout) this.rootView.findViewById(a.g.pk_anchor_live_layout);
        this.fQG = (LinearLayout) this.rootView.findViewById(a.g.anchor_streak_win_layout);
        this.fQH = (ImageView) this.rootView.findViewById(a.g.anchor_user_pk_streak_img);
        this.fQI = (TextView) this.rootView.findViewById(a.g.anchor_user_pk_streak_time);
        this.fQE = (RelativeLayout) this.rootView.findViewById(a.g.jinzhu_container);
        this.fQJ = (LinearLayout) this.rootView.findViewById(a.g.anchor_jinzhu_layout);
        this.fQK = (ChallengeJinzhuView) this.rootView.findViewById(a.g.anchor_jinzhu_1);
        this.fQL = (ChallengeJinzhuView) this.rootView.findViewById(a.g.anchor_jinzhu_2);
        this.fQM = (ChallengeJinzhuView) this.rootView.findViewById(a.g.anchor_jinzhu_3);
        this.fQN = (RelativeLayout) this.rootView.findViewById(a.g.pk_rival_live_layout);
        this.fQO = (RelativeLayout) this.rootView.findViewById(a.g.pk_rival_user_layout);
        this.fQP = (HeadImageView) this.rootView.findViewById(a.g.ala_live_rival_user_image);
        this.fQQ = (TextView) this.rootView.findViewById(a.g.ala_live_rival_user_name);
        this.fQV = (LinearLayout) this.rootView.findViewById(a.g.rival_streak_win_layout);
        this.fQR = (LinearLayout) this.rootView.findViewById(a.g.rival_jinzhu_layout);
        this.fQS = (ChallengeJinzhuView) this.rootView.findViewById(a.g.rival_jinzhu_1);
        this.fQT = (ChallengeJinzhuView) this.rootView.findViewById(a.g.rival_jinzhu_2);
        this.fQU = (ChallengeJinzhuView) this.rootView.findViewById(a.g.rival_jinzhu_3);
        this.fQW = (ImageView) this.rootView.findViewById(a.g.rival_user_pk_streak_img);
        this.fQX = (TextView) this.rootView.findViewById(a.g.rival_user_pk_streak_time);
        this.fQY = (LinearLayout) this.rootView.findViewById(a.g.pk_time_layout);
        this.fQZ = (TextView) this.rootView.findViewById(a.g.pk_time_label);
        this.fRa = (RelativeLayout) this.rootView.findViewById(a.g.pk_score_progress_layout);
        this.fRb = (TextView) this.rootView.findViewById(a.g.pk_anchor_label);
        this.fRd = (TextView) this.rootView.findViewById(a.g.pk_anchor_progress);
        this.fRe = (TextView) this.rootView.findViewById(a.g.pk_rival_progress);
        this.fRc = (TextView) this.rootView.findViewById(a.g.pk_rival_label);
        this.fRh = (TextView) this.rootView.findViewById(a.g.btn_close_challenge_view);
        this.fRf = this.rootView.findViewById(a.g.anchor_progress_bg);
        this.fRg = this.rootView.findViewById(a.g.rival_progress_bg);
        this.fQA = this.rootView.findViewById(a.g.anchor_live_anim_fore_bg);
        this.fQD = this.rootView.findViewById(a.g.rival_live_anim_fore_bg);
        this.fQO.setVisibility(0);
        this.fQO.setBackgroundResource(a.f.sdk_round_host_header_bg);
        this.fQP.setIsRound(true);
        this.fQP.setAutoChangeStyle(false);
        this.fQP.setDefaultBgResource(a.f.sdk_icon_default_avatar100_bg);
        this.fQP.setIsNight(false);
        this.fQN.setOnClickListener(this);
        this.fQO.setOnClickListener(this);
        this.fRh.setOnClickListener(this);
        this.fQJ.setVisibility(8);
        this.fQR.setVisibility(8);
        this.fQK.setClickListener(this);
        this.fQL.setClickListener(this);
        this.fQM.setClickListener(this);
        this.fQS.setClickListener(this);
        this.fQT.setClickListener(this);
        this.fQU.setClickListener(this);
    }

    private void updateView() {
        this.fRm = g.au(this.mContext);
        this.fRl = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds50);
        this.screenWidth = BdUtilHelper.getScreenDimensions(this.mContext)[0];
        int ax = g.ax(this.mContext);
        int aw = g.aw(this.mContext);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = this.fRm;
        layoutParams.height = aw;
        this.fQx.setLayoutParams(layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(ax, aw);
        layoutParams2.addRule(9);
        this.fQF.setLayoutParams(layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(ax, aw);
        layoutParams3.addRule(11);
        this.fQN.setLayoutParams(layoutParams3);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(ax, aw);
        layoutParams4.addRule(11);
        layoutParams4.topMargin = this.fRm;
        this.fQB.setLayoutParams(layoutParams4);
        RelativeLayout.LayoutParams layoutParams5 = (RelativeLayout.LayoutParams) this.fQY.getLayoutParams();
        layoutParams5.topMargin = this.fRm;
        layoutParams5.addRule(14);
        this.fQY.setLayoutParams(layoutParams5);
        this.fRa.setAlpha(0.0f);
    }

    public View getAnchorAnimLiveLayout() {
        return this.fQy;
    }

    public View getAnchorAnimLiveForeBg() {
        return this.fQA;
    }

    public View getRivalAnimLiveLayout() {
        return this.fQB;
    }

    public View getRivalAnimLiveForeBg() {
        return this.fQD;
    }

    public TbImageView getAnchorAnimLiveBgView() {
        return this.fQz;
    }

    public void setAnchorUserViewBg(al alVar) {
        this.fQz.setScaleType(ImageView.ScaleType.FIT_XY);
        String str = "";
        if (alVar.azo != null) {
            str = alVar.azo.portrait;
        }
        this.fQz.startLoad(str, 12, false);
        this.fQz.setVisibility(0);
    }

    public void setRivalUserViewBg(al alVar) {
        this.fQC.setScaleType(ImageView.ScaleType.FIT_XY);
        String str = "";
        if (alVar.azo != null) {
            str = alVar.azo.portrait;
        }
        this.fQC.startLoad(str, 12, false);
    }

    public View getLeftTimeView() {
        return this.fQY;
    }

    public ViewGroup getLiveContainerView() {
        return this.fQx;
    }

    public View getScoreProgressLayout() {
        return this.fRa;
    }

    public View getJinzhuLayout() {
        return this.fQE;
    }

    public View getCloseBtnView() {
        return this.fRh;
    }

    public RelativeLayout getContainerView() {
        return this.fQw;
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
            bAC();
        } else if (i == 3) {
            setCloseBtnVisible(false);
            by(akVar.challengeResult, akVar.azx);
        } else {
            bte();
            setCloseBtnVisible(false);
            by(akVar.challengeResult, akVar.azx);
        }
        a(alVar.azB);
        b(alVar2.azB);
        this.fRn = akVar;
    }

    private void a(aj ajVar) {
        ArrayList arrayList;
        if (ajVar == null) {
            this.fQK.setVisibility(8);
            this.fQL.setVisibility(8);
            this.fQM.setVisibility(8);
            return;
        }
        this.fQJ.setVisibility(0);
        if (ListUtils.isEmpty(ajVar.azp)) {
            ajVar.azp = this.fRp;
        }
        if (ListUtils.isEmpty(ajVar.azp)) {
            this.fQK.setVisibility(0);
            this.fQL.setVisibility(8);
            this.fQM.setVisibility(8);
            this.fQK.a(true, null, ajVar.liveId);
            return;
        }
        this.fRp = ajVar.azp;
        this.fQK.setVisibility(8);
        this.fQL.setVisibility(8);
        this.fQM.setVisibility(8);
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
                    this.fQK.setVisibility(0);
                    this.fQK.a(true, aiVar, ajVar.liveId);
                } else if (aiVar.rank == 2) {
                    this.fQL.setVisibility(0);
                    this.fQL.a(true, aiVar, ajVar.liveId);
                } else if (aiVar.rank == 3) {
                    this.fQM.setVisibility(0);
                    this.fQM.a(true, aiVar, ajVar.liveId);
                }
            }
        }
    }

    private void b(aj ajVar) {
        List<ai> list;
        if (ajVar == null) {
            this.fQS.setVisibility(8);
            this.fQT.setVisibility(8);
            this.fQU.setVisibility(8);
            return;
        }
        this.fQR.setVisibility(0);
        if (ListUtils.isEmpty(ajVar.azp)) {
            ajVar.azp = this.fRq;
        }
        if (ListUtils.isEmpty(ajVar.azp)) {
            this.fQS.setVisibility(0);
            this.fQT.setVisibility(8);
            this.fQU.setVisibility(8);
            this.fQS.a(false, null, ajVar.liveId);
            return;
        }
        this.fRq = ajVar.azp;
        this.fQS.setVisibility(8);
        this.fQT.setVisibility(8);
        this.fQU.setVisibility(8);
        if (ajVar.azp.size() > 3) {
            list = ajVar.azp.subList(0, 3);
        } else {
            list = ajVar.azp;
        }
        for (int i = 0; i < list.size(); i++) {
            ai aiVar = list.get(i);
            if (aiVar != null) {
                if (aiVar.wp() || aiVar.isFirst()) {
                    this.fQS.setVisibility(0);
                    this.fQS.a(false, aiVar, ajVar.liveId);
                } else if (aiVar.rank == 2) {
                    this.fQT.setVisibility(0);
                    this.fQT.a(false, aiVar, ajVar.liveId);
                } else if (aiVar.rank == 3) {
                    this.fQU.setVisibility(0);
                    this.fQU.a(false, aiVar, ajVar.liveId);
                }
            }
        }
    }

    private void a(long j, int i, long j2, long j3) {
        if (j3 >= j2 && a(j, i, j3)) {
            bte();
            if (this.fRn != null) {
                u(this.fRn.azq, (j3 - j2) * 1000);
            }
            this.foN = new CountDownTimer((j3 - j2) * 1000, 1000L) { // from class: com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeLiveView.1
                @Override // android.os.CountDownTimer
                public void onTick(long j4) {
                    if (AlaChallengeLiveView.this.fRn != null) {
                        AlaChallengeLiveView.this.u(AlaChallengeLiveView.this.fRn.azq, j4);
                    }
                }

                @Override // android.os.CountDownTimer
                public void onFinish() {
                    if (AlaChallengeLiveView.this.fRn != null) {
                        AlaChallengeLiveView.this.u(AlaChallengeLiveView.this.fRn.azq, 0L);
                    }
                }
            };
            this.foN.start();
        }
    }

    private boolean a(long j, int i, long j2) {
        return (this.fRn != null && this.fRn.challengeId == j && this.fRn.azq == i && this.fRn.azt == j2) ? false : true;
    }

    private void bte() {
        if (this.foN != null) {
            this.foN.cancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(int i, long j) {
        if (this.fQZ != null) {
            String formatSecondsTime = StringHelper.formatSecondsTime(Math.round(j / 1000.0d));
            String string = this.mContext.getString(a.i.ala_challenge_operate_challenge_time, formatSecondsTime);
            if (i == 2) {
                string = this.mContext.getString(a.i.ala_challenge_operate_challenge_time, formatSecondsTime);
            } else if (i == 3) {
                string = this.mContext.getString(a.i.ala_challenge_operate_publish_time, formatSecondsTime);
            } else if (i == 4) {
                string = this.mContext.getString(a.i.ala_challenge_operate_over_time);
            }
            this.fQZ.setText(string);
        }
    }

    public void setLiveContainerVisible(boolean z) {
        this.fQx.setVisibility(z ? 0 : 4);
    }

    public void setCloseBtnVisible(boolean z) {
        if (this.isHost) {
            this.fRh.setVisibility(z ? 0 : 4);
        } else {
            this.fRh.setVisibility(4);
        }
    }

    public void bAB() {
        setCloseBtnVisible(false);
        setLiveContainerVisible(false);
        if (this.fRp != null) {
            this.fRp.clear();
            this.fRp = null;
        }
        if (this.fRq != null) {
            this.fRq.clear();
            this.fRq = null;
        }
        this.fRn = null;
    }

    public void by(int i, int i2) {
        this.fQG.setVisibility(0);
        this.fQV.setVisibility(0);
        this.fQI.setVisibility(4);
        this.fQX.setVisibility(4);
        if (1 == i) {
            this.fQH.setImageResource(a.f.icon_live_vs_win);
            if (i2 >= 2) {
                this.fQI.setVisibility(0);
                this.fQI.setText(this.mContext.getResources().getString(a.i.ala_challenge_streak_win_label, Integer.valueOf(i2)));
            } else {
                this.fQI.setText("");
            }
            this.fQW.setImageResource(a.f.icon_live_vs_lose);
        } else if (3 == i) {
            this.fQH.setImageResource(a.f.icon_live_vs_draw);
            this.fQW.setImageResource(a.f.icon_live_vs_draw);
        } else if (2 == i) {
            this.fQH.setImageResource(a.f.icon_live_vs_lose);
            if (i2 >= 2) {
                this.fQX.setVisibility(0);
                this.fQX.setText(this.mContext.getResources().getString(a.i.ala_challenge_streak_win_label, Integer.valueOf(i2)));
            } else {
                this.fQX.setText("");
            }
            this.fQW.setImageResource(a.f.icon_live_vs_win);
        } else {
            bAC();
        }
    }

    public void bAC() {
        this.fQG.setVisibility(4);
        this.fQV.setVisibility(4);
    }

    public void bAD() {
        if (this.fRp != null) {
            this.fRp.clear();
            this.fRp = null;
        }
        if (this.fRq != null) {
            this.fRq.clear();
            this.fRq = null;
        }
    }

    private void x(long j, long j2) {
        int i;
        if (this.fRj != j || this.fRk != j2) {
            this.fRj = j;
            this.fRk = j2;
            this.fRd.setText(String.valueOf(this.fRj));
            this.fRe.setText(String.valueOf(this.fRk));
            float f = (float) (this.fRj + this.fRk);
            final int dimensionPixelSize = (this.screenWidth - (this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds20) * 2)) - (this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds6) * 2);
            int i2 = dimensionPixelSize / 2;
            if (f != 0.0f) {
                int i3 = (int) ((((float) this.fRj) / f) * dimensionPixelSize);
                int i4 = ((LinearLayout.LayoutParams) this.fRf.getLayoutParams()).width;
                if (i3 < this.fRl) {
                    i = this.fRl;
                } else {
                    i = i3 > dimensionPixelSize - this.fRl ? dimensionPixelSize - this.fRl : i3;
                }
                if (this.fRo != null) {
                    this.fRo.cancel();
                }
                this.fRo = ValueAnimator.ofInt(i4, i);
                this.fRo.setDuration(100L);
                this.fRo.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeLiveView.2
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) AlaChallengeLiveView.this.fRf.getLayoutParams();
                        layoutParams.width = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                        AlaChallengeLiveView.this.fRf.setLayoutParams(layoutParams);
                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) AlaChallengeLiveView.this.fRg.getLayoutParams();
                        layoutParams2.width = dimensionPixelSize - layoutParams.width;
                        AlaChallengeLiveView.this.fRg.setLayoutParams(layoutParams2);
                    }
                });
                this.fRo.start();
                return;
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fRf.getLayoutParams();
            layoutParams.width = i2;
            this.fRf.setLayoutParams(layoutParams);
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.fRg.getLayoutParams();
            layoutParams2.width = dimensionPixelSize - layoutParams.width;
            this.fRg.setLayoutParams(layoutParams2);
        }
    }

    public void c(al alVar) {
        if (alVar == null || alVar.azo == null) {
            this.fQO.setVisibility(4);
            return;
        }
        this.fQO.setTag(alVar);
        this.fQP.startLoad(alVar.azo.portrait, 12, false, false);
        String str = alVar.azo.userName;
        if (TextHelper.getTextLengthWithEmoji(str) > 12) {
            str = TextHelper.subStringWithEmoji(str, 12) + StringHelper.STRING_MORE;
        }
        this.fQQ.setText(str);
    }

    public View getRivalUserInfoView() {
        return this.fQO;
    }

    public void releaseResource() {
        bte();
        this.fRn = null;
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.fRh) {
            if (this.fRi != null) {
                this.fRi.bAF();
            }
        } else if (view == this.fQO) {
            if (this.fRi != null) {
                if (this.fRr) {
                    this.fRi.bAG();
                } else {
                    this.fRi.d((al) this.fQO.getTag());
                }
            }
        } else if (view == this.fQN && this.fRi != null) {
            if (this.fRr) {
                this.fRi.bAG();
            } else {
                this.fRi.e(this.azn);
            }
        }
    }

    public void setViewClickCallBack(a aVar) {
        this.fRi = aVar;
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.view.ChallengeJinzhuView.a
    public void bAE() {
        if (this.fRi != null) {
            this.fRi.bAG();
        }
    }
}
