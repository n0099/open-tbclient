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
    private ah aui;
    private ah auj;
    private RelativeLayout fCA;
    private HeadImageView fCB;
    private TextView fCC;
    private LinearLayout fCD;
    private ChallengeJinzhuView fCE;
    private ChallengeJinzhuView fCF;
    private ChallengeJinzhuView fCG;
    private LinearLayout fCH;
    private ImageView fCI;
    private TextView fCJ;
    private LinearLayout fCK;
    private TextView fCL;
    private RelativeLayout fCM;
    private TextView fCN;
    private TextView fCO;
    private TextView fCP;
    private TextView fCQ;
    private View fCR;
    private View fCS;
    private TextView fCT;
    private a fCU;
    private long fCV;
    private long fCW;
    private int fCX;
    private int fCY;
    private ag fCZ;
    private RelativeLayout fCi;
    private RelativeLayout fCj;
    private RelativeLayout fCk;
    private TbImageView fCl;
    private View fCm;
    private RelativeLayout fCn;
    private TbImageView fCo;
    private View fCp;
    private RelativeLayout fCq;
    private RelativeLayout fCr;
    private LinearLayout fCs;
    private ImageView fCt;
    private TextView fCu;
    private LinearLayout fCv;
    private ChallengeJinzhuView fCw;
    private ChallengeJinzhuView fCx;
    private ChallengeJinzhuView fCy;
    private RelativeLayout fCz;
    private ValueAnimator fDa;
    private List<ae> fDb;
    private List<ae> fDc;
    private CountDownTimer fba;
    private boolean isHost;
    private Context mContext;
    private Handler mHandler;
    private RelativeLayout rootView;
    private int screenWidth;

    /* loaded from: classes3.dex */
    public interface a {
        void buD();

        void d(ah ahVar);

        void e(ah ahVar);
    }

    public AlaChallengeLiveView(Context context) {
        super(context);
        this.isHost = false;
        this.fCV = -1L;
        this.fCW = -1L;
        this.screenWidth = -1;
        this.fCX = 0;
        this.fCY = 0;
        init(context);
    }

    public AlaChallengeLiveView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isHost = false;
        this.fCV = -1L;
        this.fCW = -1L;
        this.screenWidth = -1;
        this.fCX = 0;
        this.fCY = 0;
        init(context);
    }

    public AlaChallengeLiveView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isHost = false;
        this.fCV = -1L;
        this.fCW = -1L;
        this.screenWidth = -1;
        this.fCX = 0;
        this.fCY = 0;
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
        this.fCi = (RelativeLayout) this.rootView.findViewById(a.g.root_container);
        this.fCk = (RelativeLayout) this.rootView.findViewById(a.g.anchor_live_anim_layout);
        this.fCl = (TbImageView) this.rootView.findViewById(a.g.anchor_live_anim_bg);
        this.fCn = (RelativeLayout) this.rootView.findViewById(a.g.rival_live_anim_layout);
        this.fCo = (TbImageView) this.rootView.findViewById(a.g.rival_live_anim_bg);
        this.fCj = (RelativeLayout) this.rootView.findViewById(a.g.pk_live_container);
        this.fCr = (RelativeLayout) this.rootView.findViewById(a.g.pk_anchor_live_layout);
        this.fCs = (LinearLayout) this.rootView.findViewById(a.g.anchor_streak_win_layout);
        this.fCt = (ImageView) this.rootView.findViewById(a.g.anchor_user_pk_streak_img);
        this.fCu = (TextView) this.rootView.findViewById(a.g.anchor_user_pk_streak_time);
        this.fCq = (RelativeLayout) this.rootView.findViewById(a.g.jinzhu_container);
        this.fCv = (LinearLayout) this.rootView.findViewById(a.g.anchor_jinzhu_layout);
        this.fCw = (ChallengeJinzhuView) this.rootView.findViewById(a.g.anchor_jinzhu_1);
        this.fCx = (ChallengeJinzhuView) this.rootView.findViewById(a.g.anchor_jinzhu_2);
        this.fCy = (ChallengeJinzhuView) this.rootView.findViewById(a.g.anchor_jinzhu_3);
        this.fCz = (RelativeLayout) this.rootView.findViewById(a.g.pk_rival_live_layout);
        this.fCA = (RelativeLayout) this.rootView.findViewById(a.g.pk_rival_user_layout);
        this.fCB = (HeadImageView) this.rootView.findViewById(a.g.ala_live_rival_user_image);
        this.fCC = (TextView) this.rootView.findViewById(a.g.ala_live_rival_user_name);
        this.fCH = (LinearLayout) this.rootView.findViewById(a.g.rival_streak_win_layout);
        this.fCD = (LinearLayout) this.rootView.findViewById(a.g.rival_jinzhu_layout);
        this.fCE = (ChallengeJinzhuView) this.rootView.findViewById(a.g.rival_jinzhu_1);
        this.fCF = (ChallengeJinzhuView) this.rootView.findViewById(a.g.rival_jinzhu_2);
        this.fCG = (ChallengeJinzhuView) this.rootView.findViewById(a.g.rival_jinzhu_3);
        this.fCI = (ImageView) this.rootView.findViewById(a.g.rival_user_pk_streak_img);
        this.fCJ = (TextView) this.rootView.findViewById(a.g.rival_user_pk_streak_time);
        this.fCK = (LinearLayout) this.rootView.findViewById(a.g.pk_time_layout);
        this.fCL = (TextView) this.rootView.findViewById(a.g.pk_time_label);
        this.fCM = (RelativeLayout) this.rootView.findViewById(a.g.pk_score_progress_layout);
        this.fCN = (TextView) this.rootView.findViewById(a.g.pk_anchor_label);
        this.fCP = (TextView) this.rootView.findViewById(a.g.pk_anchor_progress);
        this.fCQ = (TextView) this.rootView.findViewById(a.g.pk_rival_progress);
        this.fCO = (TextView) this.rootView.findViewById(a.g.pk_rival_label);
        this.fCT = (TextView) this.rootView.findViewById(a.g.btn_close_challenge_view);
        this.fCR = this.rootView.findViewById(a.g.anchor_progress_bg);
        this.fCS = this.rootView.findViewById(a.g.rival_progress_bg);
        this.fCm = this.rootView.findViewById(a.g.anchor_live_anim_fore_bg);
        this.fCp = this.rootView.findViewById(a.g.rival_live_anim_fore_bg);
        this.fCA.setVisibility(0);
        this.fCA.setBackgroundResource(a.f.sdk_round_host_header_bg);
        this.fCB.setIsRound(true);
        this.fCB.setAutoChangeStyle(false);
        this.fCB.setDefaultBgResource(a.f.sdk_icon_default_avatar100_bg);
        this.fCB.setIsNight(false);
        this.fCz.setOnClickListener(this);
        this.fCA.setOnClickListener(this);
        this.fCT.setOnClickListener(this);
        this.fCv.setVisibility(8);
        this.fCD.setVisibility(8);
    }

    private void updateView() {
        this.fCY = g.ak(this.mContext);
        this.fCX = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds50);
        this.screenWidth = BdUtilHelper.getScreenDimensions(this.mContext)[0];
        int an = g.an(this.mContext);
        int am = g.am(this.mContext);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = this.fCY;
        layoutParams.height = am;
        this.fCj.setLayoutParams(layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(an, am);
        layoutParams2.addRule(9);
        this.fCr.setLayoutParams(layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(an, am);
        layoutParams3.addRule(11);
        this.fCz.setLayoutParams(layoutParams3);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(an, am);
        layoutParams4.addRule(11);
        layoutParams4.topMargin = this.fCY;
        this.fCn.setLayoutParams(layoutParams4);
        RelativeLayout.LayoutParams layoutParams5 = (RelativeLayout.LayoutParams) this.fCK.getLayoutParams();
        layoutParams5.topMargin = this.fCY;
        layoutParams5.addRule(14);
        this.fCK.setLayoutParams(layoutParams5);
        this.fCM.setAlpha(0.0f);
    }

    public View getAnchorAnimLiveLayout() {
        return this.fCk;
    }

    public View getAnchorAnimLiveForeBg() {
        return this.fCm;
    }

    public View getRivalAnimLiveLayout() {
        return this.fCn;
    }

    public View getRivalAnimLiveForeBg() {
        return this.fCp;
    }

    public TbImageView getAnchorAnimLiveBgView() {
        return this.fCl;
    }

    public void setAnchorUserViewBg(ah ahVar) {
        this.fCl.setScaleType(ImageView.ScaleType.FIT_XY);
        String str = "";
        if (ahVar.auk != null) {
            str = ahVar.auk.portrait;
        }
        this.fCl.startLoad(str, 12, false);
        this.fCl.setVisibility(0);
    }

    public void setRivalUserViewBg(ah ahVar) {
        this.fCo.setScaleType(ImageView.ScaleType.FIT_XY);
        String str = "";
        if (ahVar.auk != null) {
            str = ahVar.auk.portrait;
        }
        this.fCo.startLoad(str, 12, false);
    }

    public View getLeftTimeView() {
        return this.fCK;
    }

    public ViewGroup getLiveContainerView() {
        return this.fCj;
    }

    public View getScoreProgressLayout() {
        return this.fCM;
    }

    public View getJinzhuLayout() {
        return this.fCq;
    }

    public View getCloseBtnView() {
        return this.fCT;
    }

    public RelativeLayout getContainerView() {
        return this.fCi;
    }

    public void a(ag agVar, ah ahVar, ah ahVar2, boolean z) {
        this.aui = ahVar;
        this.auj = ahVar2;
        int i = agVar.aum;
        a(agVar.challengeId, i, agVar.auq, agVar.aup);
        w(agVar.aur, agVar.aus);
        if (z) {
            c(ahVar2);
        }
        if (i == 2) {
            setCloseBtnVisible(true);
            buB();
        } else if (i == 3) {
            setCloseBtnVisible(false);
            bu(agVar.challengeResult, agVar.aut);
        } else {
            bnk();
            setCloseBtnVisible(false);
            bu(agVar.challengeResult, agVar.aut);
        }
        a(ahVar.aux);
        b(ahVar2.aux);
        this.fCZ = agVar;
    }

    private void a(af afVar) {
        ArrayList arrayList;
        if (afVar == null) {
            this.fCw.setVisibility(8);
            this.fCx.setVisibility(8);
            this.fCy.setVisibility(8);
            return;
        }
        this.fCv.setVisibility(0);
        if (ListUtils.isEmpty(afVar.aul)) {
            afVar.aul = this.fDb;
        }
        if (ListUtils.isEmpty(afVar.aul)) {
            this.fCw.setVisibility(0);
            this.fCx.setVisibility(8);
            this.fCy.setVisibility(8);
            this.fCw.a(true, null, afVar.liveId);
            return;
        }
        this.fDb = afVar.aul;
        this.fCw.setVisibility(8);
        this.fCx.setVisibility(8);
        this.fCy.setVisibility(8);
        if (afVar.aul.size() > 3) {
            ArrayList arrayList2 = new ArrayList();
            for (int i = 0; i < 3; i++) {
                arrayList2.add(afVar.aul.get(i));
            }
            arrayList = arrayList2;
        } else {
            arrayList = afVar.aul;
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            ae aeVar = arrayList.get(i2);
            if (aeVar != null) {
                if (aeVar.va() || aeVar.isFirst()) {
                    this.fCw.setVisibility(0);
                    this.fCw.a(true, aeVar, afVar.liveId);
                } else if (aeVar.rank == 2) {
                    this.fCx.setVisibility(0);
                    this.fCx.a(true, aeVar, afVar.liveId);
                } else if (aeVar.rank == 3) {
                    this.fCy.setVisibility(0);
                    this.fCy.a(true, aeVar, afVar.liveId);
                }
            }
        }
    }

    private void b(af afVar) {
        List<ae> list;
        if (afVar == null) {
            this.fCE.setVisibility(8);
            this.fCF.setVisibility(8);
            this.fCG.setVisibility(8);
            return;
        }
        this.fCD.setVisibility(0);
        if (ListUtils.isEmpty(afVar.aul)) {
            afVar.aul = this.fDc;
        }
        if (ListUtils.isEmpty(afVar.aul)) {
            this.fCE.setVisibility(0);
            this.fCF.setVisibility(8);
            this.fCG.setVisibility(8);
            this.fCE.a(false, null, afVar.liveId);
            return;
        }
        this.fDc = afVar.aul;
        this.fCE.setVisibility(8);
        this.fCF.setVisibility(8);
        this.fCG.setVisibility(8);
        if (afVar.aul.size() > 3) {
            list = afVar.aul.subList(0, 3);
        } else {
            list = afVar.aul;
        }
        for (int i = 0; i < list.size(); i++) {
            ae aeVar = list.get(i);
            if (aeVar != null) {
                if (aeVar.va() || aeVar.isFirst()) {
                    this.fCE.setVisibility(0);
                    this.fCE.a(false, aeVar, afVar.liveId);
                } else if (aeVar.rank == 2) {
                    this.fCF.setVisibility(0);
                    this.fCF.a(false, aeVar, afVar.liveId);
                } else if (aeVar.rank == 3) {
                    this.fCG.setVisibility(0);
                    this.fCG.a(false, aeVar, afVar.liveId);
                }
            }
        }
    }

    private void a(long j, int i, long j2, long j3) {
        if (j3 >= j2 && a(j, i, j3)) {
            bnk();
            if (this.fCZ != null) {
                u(this.fCZ.aum, (j3 - j2) * 1000);
            }
            this.fba = new CountDownTimer((j3 - j2) * 1000, 1000L) { // from class: com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeLiveView.1
                @Override // android.os.CountDownTimer
                public void onTick(long j4) {
                    if (AlaChallengeLiveView.this.fCZ != null) {
                        AlaChallengeLiveView.this.u(AlaChallengeLiveView.this.fCZ.aum, j4);
                    }
                }

                @Override // android.os.CountDownTimer
                public void onFinish() {
                    if (AlaChallengeLiveView.this.fCZ != null) {
                        AlaChallengeLiveView.this.u(AlaChallengeLiveView.this.fCZ.aum, 0L);
                    }
                }
            };
            this.fba.start();
        }
    }

    private boolean a(long j, int i, long j2) {
        return (this.fCZ != null && this.fCZ.challengeId == j && this.fCZ.aum == i && this.fCZ.aup == j2) ? false : true;
    }

    private void bnk() {
        if (this.fba != null) {
            this.fba.cancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(int i, long j) {
        if (this.fCL != null) {
            String formatSecondsTime = StringHelper.formatSecondsTime(Math.round(j / 1000.0d));
            String string = this.mContext.getString(a.i.ala_challenge_operate_challenge_time, formatSecondsTime);
            if (i == 2) {
                string = this.mContext.getString(a.i.ala_challenge_operate_challenge_time, formatSecondsTime);
            } else if (i == 3) {
                string = this.mContext.getString(a.i.ala_challenge_operate_publish_time, formatSecondsTime);
            } else if (i == 4) {
                string = this.mContext.getString(a.i.ala_challenge_operate_over_time);
            }
            this.fCL.setText(string);
        }
    }

    public void setLiveContainerVisible(boolean z) {
        this.fCj.setVisibility(z ? 0 : 4);
    }

    public void setCloseBtnVisible(boolean z) {
        if (this.isHost) {
            this.fCT.setVisibility(z ? 0 : 4);
        } else {
            this.fCT.setVisibility(4);
        }
    }

    public void buA() {
        setCloseBtnVisible(false);
        setLiveContainerVisible(false);
        if (this.fDb != null) {
            this.fDb.clear();
            this.fDb = null;
        }
        if (this.fDc != null) {
            this.fDc.clear();
            this.fDc = null;
        }
        this.fCZ = null;
    }

    public void bu(int i, int i2) {
        this.fCs.setVisibility(0);
        this.fCH.setVisibility(0);
        this.fCu.setVisibility(4);
        this.fCJ.setVisibility(4);
        if (1 == i) {
            this.fCt.setImageResource(a.f.icon_live_vs_win);
            if (i2 >= 2) {
                this.fCu.setVisibility(0);
                this.fCu.setText(this.mContext.getResources().getString(a.i.ala_challenge_streak_win_label, Integer.valueOf(i2)));
            } else {
                this.fCu.setText("");
            }
            this.fCI.setImageResource(a.f.icon_live_vs_lose);
        } else if (3 == i) {
            this.fCt.setImageResource(a.f.icon_live_vs_draw);
            this.fCI.setImageResource(a.f.icon_live_vs_draw);
        } else if (2 == i) {
            this.fCt.setImageResource(a.f.icon_live_vs_lose);
            if (i2 >= 2) {
                this.fCJ.setVisibility(0);
                this.fCJ.setText(this.mContext.getResources().getString(a.i.ala_challenge_streak_win_label, Integer.valueOf(i2)));
            } else {
                this.fCJ.setText("");
            }
            this.fCI.setImageResource(a.f.icon_live_vs_win);
        } else {
            buB();
        }
    }

    public void buB() {
        this.fCs.setVisibility(4);
        this.fCH.setVisibility(4);
    }

    public void buC() {
        if (this.fDb != null) {
            this.fDb.clear();
            this.fDb = null;
        }
        if (this.fDc != null) {
            this.fDc.clear();
            this.fDc = null;
        }
    }

    private void w(long j, long j2) {
        int i;
        if (this.fCV != j || this.fCW != j2) {
            this.fCV = j;
            this.fCW = j2;
            this.fCP.setText(String.valueOf(this.fCV));
            this.fCQ.setText(String.valueOf(this.fCW));
            float f = (float) (this.fCV + this.fCW);
            final int dimensionPixelSize = (this.screenWidth - (this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds20) * 2)) - (this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds6) * 2);
            int i2 = dimensionPixelSize / 2;
            if (f != 0.0f) {
                int i3 = (int) ((((float) this.fCV) / f) * dimensionPixelSize);
                int i4 = ((LinearLayout.LayoutParams) this.fCR.getLayoutParams()).width;
                if (i3 < this.fCX) {
                    i = this.fCX;
                } else {
                    i = i3 > dimensionPixelSize - this.fCX ? dimensionPixelSize - this.fCX : i3;
                }
                if (this.fDa != null) {
                    this.fDa.cancel();
                }
                this.fDa = ValueAnimator.ofInt(i4, i);
                this.fDa.setDuration(100L);
                this.fDa.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeLiveView.2
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) AlaChallengeLiveView.this.fCR.getLayoutParams();
                        layoutParams.width = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                        AlaChallengeLiveView.this.fCR.setLayoutParams(layoutParams);
                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) AlaChallengeLiveView.this.fCS.getLayoutParams();
                        layoutParams2.width = dimensionPixelSize - layoutParams.width;
                        AlaChallengeLiveView.this.fCS.setLayoutParams(layoutParams2);
                    }
                });
                this.fDa.start();
                return;
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fCR.getLayoutParams();
            layoutParams.width = i2;
            this.fCR.setLayoutParams(layoutParams);
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.fCS.getLayoutParams();
            layoutParams2.width = dimensionPixelSize - layoutParams.width;
            this.fCS.setLayoutParams(layoutParams2);
        }
    }

    public void c(ah ahVar) {
        if (ahVar == null || ahVar.auk == null) {
            this.fCA.setVisibility(4);
            return;
        }
        this.fCA.setTag(ahVar);
        this.fCB.startLoad(ahVar.auk.portrait, 12, false, false);
        String str = ahVar.auk.userName;
        if (TextHelper.getTextLengthWithEmoji(str) > 12) {
            str = TextHelper.subStringWithEmoji(str, 12) + StringHelper.STRING_MORE;
        }
        this.fCC.setText(str);
    }

    public View getRivalUserInfoView() {
        return this.fCA;
    }

    public void releaseResource() {
        bnk();
        this.fCZ = null;
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.fCT) {
            if (this.fCU != null) {
                this.fCU.buD();
            }
        } else if (view == this.fCA) {
            if (this.fCU != null) {
                this.fCU.d((ah) this.fCA.getTag());
            }
        } else if (view == this.fCz && this.fCU != null) {
            this.fCU.e(this.auj);
        }
    }

    public void setViewClickCallBack(a aVar) {
        this.fCU = aVar;
    }
}
