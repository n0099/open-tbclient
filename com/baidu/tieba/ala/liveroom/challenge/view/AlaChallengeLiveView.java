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
import com.baidu.live.data.ae;
import com.baidu.live.data.af;
import com.baidu.live.data.ag;
import com.baidu.live.data.ah;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.util.TextHelper;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.live.u.a;
import com.baidu.live.utils.g;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class AlaChallengeLiveView extends RelativeLayout implements View.OnClickListener {
    private ah auc;
    private ah aud;
    private ChallengeJinzhuView fCA;
    private ChallengeJinzhuView fCB;
    private LinearLayout fCC;
    private ImageView fCD;
    private TextView fCE;
    private LinearLayout fCF;
    private TextView fCG;
    private RelativeLayout fCH;
    private TextView fCI;
    private TextView fCJ;
    private TextView fCK;
    private TextView fCL;
    private View fCM;
    private View fCN;
    private TextView fCO;
    private a fCP;
    private long fCQ;
    private long fCR;
    private int fCS;
    private int fCT;
    private ag fCU;
    private ValueAnimator fCV;
    private List<ae> fCW;
    private List<ae> fCX;
    private RelativeLayout fCd;
    private RelativeLayout fCe;
    private RelativeLayout fCf;
    private TbImageView fCg;
    private View fCh;
    private RelativeLayout fCi;
    private TbImageView fCj;
    private View fCk;
    private RelativeLayout fCl;
    private RelativeLayout fCm;
    private LinearLayout fCn;
    private ImageView fCo;
    private TextView fCp;
    private LinearLayout fCq;
    private ChallengeJinzhuView fCr;
    private ChallengeJinzhuView fCs;
    private ChallengeJinzhuView fCt;
    private RelativeLayout fCu;
    private RelativeLayout fCv;
    private HeadImageView fCw;
    private TextView fCx;
    private LinearLayout fCy;
    private ChallengeJinzhuView fCz;
    private CountDownTimer faV;
    private boolean isHost;
    private Context mContext;
    private Handler mHandler;
    private RelativeLayout rootView;
    private int screenWidth;

    /* loaded from: classes3.dex */
    public interface a {
        void buF();

        void d(ah ahVar);

        void e(ah ahVar);
    }

    public AlaChallengeLiveView(Context context) {
        super(context);
        this.isHost = false;
        this.fCQ = -1L;
        this.fCR = -1L;
        this.screenWidth = -1;
        this.fCS = 0;
        this.fCT = 0;
        init(context);
    }

    public AlaChallengeLiveView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isHost = false;
        this.fCQ = -1L;
        this.fCR = -1L;
        this.screenWidth = -1;
        this.fCS = 0;
        this.fCT = 0;
        init(context);
    }

    public AlaChallengeLiveView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isHost = false;
        this.fCQ = -1L;
        this.fCR = -1L;
        this.screenWidth = -1;
        this.fCS = 0;
        this.fCT = 0;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.mHandler = new Handler(Looper.getMainLooper());
        initView(context);
        updateView();
    }

    public void setIsHost(boolean z) {
        this.isHost = z;
    }

    private void initView(Context context) {
        this.rootView = (RelativeLayout) View.inflate(context, a.h.ala_challenge_panel_optation_view, this);
        this.fCd = (RelativeLayout) this.rootView.findViewById(a.g.root_container);
        this.fCf = (RelativeLayout) this.rootView.findViewById(a.g.anchor_live_anim_layout);
        this.fCg = (TbImageView) this.rootView.findViewById(a.g.anchor_live_anim_bg);
        this.fCi = (RelativeLayout) this.rootView.findViewById(a.g.rival_live_anim_layout);
        this.fCj = (TbImageView) this.rootView.findViewById(a.g.rival_live_anim_bg);
        this.fCe = (RelativeLayout) this.rootView.findViewById(a.g.pk_live_container);
        this.fCm = (RelativeLayout) this.rootView.findViewById(a.g.pk_anchor_live_layout);
        this.fCn = (LinearLayout) this.rootView.findViewById(a.g.anchor_streak_win_layout);
        this.fCo = (ImageView) this.rootView.findViewById(a.g.anchor_user_pk_streak_img);
        this.fCp = (TextView) this.rootView.findViewById(a.g.anchor_user_pk_streak_time);
        this.fCl = (RelativeLayout) this.rootView.findViewById(a.g.jinzhu_container);
        this.fCq = (LinearLayout) this.rootView.findViewById(a.g.anchor_jinzhu_layout);
        this.fCr = (ChallengeJinzhuView) this.rootView.findViewById(a.g.anchor_jinzhu_1);
        this.fCs = (ChallengeJinzhuView) this.rootView.findViewById(a.g.anchor_jinzhu_2);
        this.fCt = (ChallengeJinzhuView) this.rootView.findViewById(a.g.anchor_jinzhu_3);
        this.fCu = (RelativeLayout) this.rootView.findViewById(a.g.pk_rival_live_layout);
        this.fCv = (RelativeLayout) this.rootView.findViewById(a.g.pk_rival_user_layout);
        this.fCw = (HeadImageView) this.rootView.findViewById(a.g.ala_live_rival_user_image);
        this.fCx = (TextView) this.rootView.findViewById(a.g.ala_live_rival_user_name);
        this.fCC = (LinearLayout) this.rootView.findViewById(a.g.rival_streak_win_layout);
        this.fCy = (LinearLayout) this.rootView.findViewById(a.g.rival_jinzhu_layout);
        this.fCz = (ChallengeJinzhuView) this.rootView.findViewById(a.g.rival_jinzhu_1);
        this.fCA = (ChallengeJinzhuView) this.rootView.findViewById(a.g.rival_jinzhu_2);
        this.fCB = (ChallengeJinzhuView) this.rootView.findViewById(a.g.rival_jinzhu_3);
        this.fCD = (ImageView) this.rootView.findViewById(a.g.rival_user_pk_streak_img);
        this.fCE = (TextView) this.rootView.findViewById(a.g.rival_user_pk_streak_time);
        this.fCF = (LinearLayout) this.rootView.findViewById(a.g.pk_time_layout);
        this.fCG = (TextView) this.rootView.findViewById(a.g.pk_time_label);
        this.fCH = (RelativeLayout) this.rootView.findViewById(a.g.pk_score_progress_layout);
        this.fCI = (TextView) this.rootView.findViewById(a.g.pk_anchor_label);
        this.fCK = (TextView) this.rootView.findViewById(a.g.pk_anchor_progress);
        this.fCL = (TextView) this.rootView.findViewById(a.g.pk_rival_progress);
        this.fCJ = (TextView) this.rootView.findViewById(a.g.pk_rival_label);
        this.fCO = (TextView) this.rootView.findViewById(a.g.btn_close_challenge_view);
        this.fCM = this.rootView.findViewById(a.g.anchor_progress_bg);
        this.fCN = this.rootView.findViewById(a.g.rival_progress_bg);
        this.fCh = this.rootView.findViewById(a.g.anchor_live_anim_fore_bg);
        this.fCk = this.rootView.findViewById(a.g.rival_live_anim_fore_bg);
        this.fCv.setVisibility(0);
        this.fCv.setBackgroundResource(a.f.sdk_round_host_header_bg);
        this.fCw.setIsRound(true);
        this.fCw.setAutoChangeStyle(false);
        this.fCw.setDefaultBgResource(a.f.sdk_icon_default_avatar100_bg);
        this.fCw.setIsNight(false);
        this.fCu.setOnClickListener(this);
        this.fCv.setOnClickListener(this);
        this.fCO.setOnClickListener(this);
        this.fCq.setVisibility(8);
        this.fCy.setVisibility(8);
    }

    private void updateView() {
        this.fCT = g.aw(this.mContext);
        this.fCS = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds50);
        this.screenWidth = BdUtilHelper.getScreenDimensions(this.mContext)[0];
        int az = g.az(this.mContext);
        int ay = g.ay(this.mContext);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = this.fCT;
        layoutParams.height = ay;
        this.fCe.setLayoutParams(layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(az, ay);
        layoutParams2.addRule(9);
        this.fCm.setLayoutParams(layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(az, ay);
        layoutParams3.addRule(11);
        this.fCu.setLayoutParams(layoutParams3);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(az, ay);
        layoutParams4.addRule(11);
        layoutParams4.topMargin = this.fCT;
        this.fCi.setLayoutParams(layoutParams4);
        RelativeLayout.LayoutParams layoutParams5 = (RelativeLayout.LayoutParams) this.fCF.getLayoutParams();
        layoutParams5.topMargin = this.fCT;
        layoutParams5.addRule(14);
        this.fCF.setLayoutParams(layoutParams5);
        this.fCH.setAlpha(0.0f);
    }

    public View getAnchorAnimLiveLayout() {
        return this.fCf;
    }

    public View getAnchorAnimLiveForeBg() {
        return this.fCh;
    }

    public View getRivalAnimLiveLayout() {
        return this.fCi;
    }

    public View getRivalAnimLiveForeBg() {
        return this.fCk;
    }

    public TbImageView getAnchorAnimLiveBgView() {
        return this.fCg;
    }

    public void setAnchorUserViewBg(ah ahVar) {
        this.fCg.setScaleType(ImageView.ScaleType.FIT_XY);
        String str = "";
        if (ahVar.aue != null) {
            str = ahVar.aue.portrait;
        }
        this.fCg.startLoad(str, 12, false);
        this.fCg.setVisibility(0);
    }

    public void setRivalUserViewBg(ah ahVar) {
        this.fCj.setScaleType(ImageView.ScaleType.FIT_XY);
        String str = "";
        if (ahVar.aue != null) {
            str = ahVar.aue.portrait;
        }
        this.fCj.startLoad(str, 12, false);
    }

    public View getLeftTimeView() {
        return this.fCF;
    }

    public ViewGroup getLiveContainerView() {
        return this.fCe;
    }

    public View getScoreProgressLayout() {
        return this.fCH;
    }

    public View getJinzhuLayout() {
        return this.fCl;
    }

    public View getCloseBtnView() {
        return this.fCO;
    }

    public RelativeLayout getContainerView() {
        return this.fCd;
    }

    public void a(ag agVar, ah ahVar, ah ahVar2, boolean z) {
        this.auc = ahVar;
        this.aud = ahVar2;
        int i = agVar.aug;
        a(agVar.challengeId, i, agVar.auk, agVar.auj);
        w(agVar.aul, agVar.aum);
        if (z) {
            c(ahVar2);
        }
        if (i == 2) {
            setCloseBtnVisible(true);
            buD();
        } else if (i == 3) {
            setCloseBtnVisible(false);
            bu(agVar.challengeResult, agVar.aun);
        } else {
            bnm();
            setCloseBtnVisible(false);
            bu(agVar.challengeResult, agVar.aun);
        }
        a(ahVar.aur);
        b(ahVar2.aur);
        this.fCU = agVar;
    }

    private void a(af afVar) {
        ArrayList arrayList;
        if (afVar == null) {
            this.fCr.setVisibility(8);
            this.fCs.setVisibility(8);
            this.fCt.setVisibility(8);
            return;
        }
        this.fCq.setVisibility(0);
        if (ListUtils.isEmpty(afVar.auf)) {
            afVar.auf = this.fCW;
        }
        if (ListUtils.isEmpty(afVar.auf)) {
            this.fCr.setVisibility(0);
            this.fCs.setVisibility(8);
            this.fCt.setVisibility(8);
            this.fCr.a(true, null, afVar.liveId);
            return;
        }
        this.fCW = afVar.auf;
        this.fCr.setVisibility(8);
        this.fCs.setVisibility(8);
        this.fCt.setVisibility(8);
        if (afVar.auf.size() > 3) {
            ArrayList arrayList2 = new ArrayList();
            for (int i = 0; i < 3; i++) {
                arrayList2.add(afVar.auf.get(i));
            }
            arrayList = arrayList2;
        } else {
            arrayList = afVar.auf;
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            ae aeVar = arrayList.get(i2);
            if (aeVar != null) {
                if (aeVar.vb() || aeVar.isFirst()) {
                    this.fCr.setVisibility(0);
                    this.fCr.a(true, aeVar, afVar.liveId);
                } else if (aeVar.rank == 2) {
                    this.fCs.setVisibility(0);
                    this.fCs.a(true, aeVar, afVar.liveId);
                } else if (aeVar.rank == 3) {
                    this.fCt.setVisibility(0);
                    this.fCt.a(true, aeVar, afVar.liveId);
                }
            }
        }
    }

    private void b(af afVar) {
        List<ae> list;
        if (afVar == null) {
            this.fCz.setVisibility(8);
            this.fCA.setVisibility(8);
            this.fCB.setVisibility(8);
            return;
        }
        this.fCy.setVisibility(0);
        if (ListUtils.isEmpty(afVar.auf)) {
            afVar.auf = this.fCX;
        }
        if (ListUtils.isEmpty(afVar.auf)) {
            this.fCz.setVisibility(0);
            this.fCA.setVisibility(8);
            this.fCB.setVisibility(8);
            this.fCz.a(false, null, afVar.liveId);
            return;
        }
        this.fCX = afVar.auf;
        this.fCz.setVisibility(8);
        this.fCA.setVisibility(8);
        this.fCB.setVisibility(8);
        if (afVar.auf.size() > 3) {
            list = afVar.auf.subList(0, 3);
        } else {
            list = afVar.auf;
        }
        for (int i = 0; i < list.size(); i++) {
            ae aeVar = list.get(i);
            if (aeVar != null) {
                if (aeVar.vb() || aeVar.isFirst()) {
                    this.fCz.setVisibility(0);
                    this.fCz.a(false, aeVar, afVar.liveId);
                } else if (aeVar.rank == 2) {
                    this.fCA.setVisibility(0);
                    this.fCA.a(false, aeVar, afVar.liveId);
                } else if (aeVar.rank == 3) {
                    this.fCB.setVisibility(0);
                    this.fCB.a(false, aeVar, afVar.liveId);
                }
            }
        }
    }

    private void a(long j, int i, long j2, long j3) {
        if (j3 >= j2 && a(j, i, j3)) {
            bnm();
            if (this.fCU != null) {
                u(this.fCU.aug, (j3 - j2) * 1000);
            }
            this.faV = new CountDownTimer((j3 - j2) * 1000, 1000L) { // from class: com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeLiveView.1
                @Override // android.os.CountDownTimer
                public void onTick(long j4) {
                    if (AlaChallengeLiveView.this.fCU != null) {
                        AlaChallengeLiveView.this.u(AlaChallengeLiveView.this.fCU.aug, j4);
                    }
                }

                @Override // android.os.CountDownTimer
                public void onFinish() {
                    if (AlaChallengeLiveView.this.fCU != null) {
                        AlaChallengeLiveView.this.u(AlaChallengeLiveView.this.fCU.aug, 0L);
                    }
                }
            };
            this.faV.start();
        }
    }

    private boolean a(long j, int i, long j2) {
        return (this.fCU != null && this.fCU.challengeId == j && this.fCU.aug == i && this.fCU.auj == j2) ? false : true;
    }

    private void bnm() {
        if (this.faV != null) {
            this.faV.cancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(int i, long j) {
        if (this.fCG != null) {
            String formatSecondsTime = StringHelper.formatSecondsTime(Math.round(j / 1000.0d));
            String string = this.mContext.getString(a.i.ala_challenge_operate_challenge_time, formatSecondsTime);
            if (i == 2) {
                string = this.mContext.getString(a.i.ala_challenge_operate_challenge_time, formatSecondsTime);
            } else if (i == 3) {
                string = this.mContext.getString(a.i.ala_challenge_operate_publish_time, formatSecondsTime);
            } else if (i == 4) {
                string = this.mContext.getString(a.i.ala_challenge_operate_over_time);
            }
            this.fCG.setText(string);
        }
    }

    public void setLiveContainerVisible(boolean z) {
        this.fCe.setVisibility(z ? 0 : 4);
    }

    public void setCloseBtnVisible(boolean z) {
        if (this.isHost) {
            this.fCO.setVisibility(z ? 0 : 4);
        } else {
            this.fCO.setVisibility(4);
        }
    }

    public void buC() {
        setCloseBtnVisible(false);
        setLiveContainerVisible(false);
        if (this.fCW != null) {
            this.fCW.clear();
            this.fCW = null;
        }
        if (this.fCX != null) {
            this.fCX.clear();
            this.fCX = null;
        }
        this.fCU = null;
    }

    public void bu(int i, int i2) {
        this.fCn.setVisibility(0);
        this.fCC.setVisibility(0);
        this.fCp.setVisibility(4);
        this.fCE.setVisibility(4);
        if (1 == i) {
            this.fCo.setImageResource(a.f.icon_live_vs_win);
            if (i2 >= 2) {
                this.fCp.setVisibility(0);
                this.fCp.setText(this.mContext.getResources().getString(a.i.ala_challenge_streak_win_label, Integer.valueOf(i2)));
            } else {
                this.fCp.setText("");
            }
            this.fCD.setImageResource(a.f.icon_live_vs_lose);
        } else if (3 == i) {
            this.fCo.setImageResource(a.f.icon_live_vs_draw);
            this.fCD.setImageResource(a.f.icon_live_vs_draw);
        } else if (2 == i) {
            this.fCo.setImageResource(a.f.icon_live_vs_lose);
            if (i2 >= 2) {
                this.fCE.setVisibility(0);
                this.fCE.setText(this.mContext.getResources().getString(a.i.ala_challenge_streak_win_label, Integer.valueOf(i2)));
            } else {
                this.fCE.setText("");
            }
            this.fCD.setImageResource(a.f.icon_live_vs_win);
        } else {
            buD();
        }
    }

    public void buD() {
        this.fCn.setVisibility(4);
        this.fCC.setVisibility(4);
    }

    public void buE() {
        if (this.fCW != null) {
            this.fCW.clear();
            this.fCW = null;
        }
        if (this.fCX != null) {
            this.fCX.clear();
            this.fCX = null;
        }
    }

    private void w(long j, long j2) {
        int i;
        if (this.fCQ != j || this.fCR != j2) {
            this.fCQ = j;
            this.fCR = j2;
            this.fCK.setText(String.valueOf(this.fCQ));
            this.fCL.setText(String.valueOf(this.fCR));
            float f = (float) (this.fCQ + this.fCR);
            final int dimensionPixelSize = (this.screenWidth - (this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds20) * 2)) - (this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds6) * 2);
            int i2 = dimensionPixelSize / 2;
            if (f != 0.0f) {
                int i3 = (int) ((((float) this.fCQ) / f) * dimensionPixelSize);
                int i4 = ((LinearLayout.LayoutParams) this.fCM.getLayoutParams()).width;
                if (i3 < this.fCS) {
                    i = this.fCS;
                } else {
                    i = i3 > dimensionPixelSize - this.fCS ? dimensionPixelSize - this.fCS : i3;
                }
                if (this.fCV != null) {
                    this.fCV.cancel();
                }
                this.fCV = ValueAnimator.ofInt(i4, i);
                this.fCV.setDuration(100L);
                this.fCV.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeLiveView.2
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) AlaChallengeLiveView.this.fCM.getLayoutParams();
                        layoutParams.width = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                        AlaChallengeLiveView.this.fCM.setLayoutParams(layoutParams);
                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) AlaChallengeLiveView.this.fCN.getLayoutParams();
                        layoutParams2.width = dimensionPixelSize - layoutParams.width;
                        AlaChallengeLiveView.this.fCN.setLayoutParams(layoutParams2);
                    }
                });
                this.fCV.start();
                return;
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fCM.getLayoutParams();
            layoutParams.width = i2;
            this.fCM.setLayoutParams(layoutParams);
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.fCN.getLayoutParams();
            layoutParams2.width = dimensionPixelSize - layoutParams.width;
            this.fCN.setLayoutParams(layoutParams2);
        }
    }

    public void c(ah ahVar) {
        if (ahVar == null || ahVar.aue == null) {
            this.fCv.setVisibility(4);
            return;
        }
        this.fCv.setTag(ahVar);
        this.fCw.startLoad(ahVar.aue.portrait, 12, false, false);
        String str = ahVar.aue.userName;
        if (TextHelper.getTextLengthWithEmoji(str) > 12) {
            str = TextHelper.subStringWithEmoji(str, 12) + StringHelper.STRING_MORE;
        }
        this.fCx.setText(str);
    }

    public View getRivalUserInfoView() {
        return this.fCv;
    }

    public void releaseResource() {
        bnm();
        this.fCU = null;
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.fCO) {
            if (this.fCP != null) {
                this.fCP.buF();
            }
        } else if (view == this.fCv) {
            if (this.fCP != null) {
                this.fCP.d((ah) this.fCv.getTag());
            }
        } else if (view == this.fCu && this.fCP != null) {
            this.fCP.e(this.aud);
        }
    }

    public void setViewClickCallBack(a aVar) {
        this.fCP = aVar;
    }
}
