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
import com.baidu.live.data.ab;
import com.baidu.live.data.ac;
import com.baidu.live.data.ad;
import com.baidu.live.data.ae;
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
    private ae eUs;
    private ae eUt;
    private ChallengeJinzhuView eXA;
    private ChallengeJinzhuView eXB;
    private ChallengeJinzhuView eXC;
    private LinearLayout eXD;
    private ImageView eXE;
    private TextView eXF;
    private LinearLayout eXG;
    private TextView eXH;
    private RelativeLayout eXI;
    private TextView eXJ;
    private TextView eXK;
    private TextView eXL;
    private TextView eXM;
    private View eXN;
    private View eXO;
    private TextView eXP;
    private a eXQ;
    private long eXR;
    private long eXS;
    private int eXT;
    private int eXU;
    private ad eXV;
    private ValueAnimator eXW;
    private List<ab> eXX;
    private List<ab> eXY;
    private RelativeLayout eXe;
    private RelativeLayout eXf;
    private RelativeLayout eXg;
    private TbImageView eXh;
    private View eXi;
    private RelativeLayout eXj;
    private TbImageView eXk;
    private View eXl;
    private RelativeLayout eXm;
    private RelativeLayout eXn;
    private LinearLayout eXo;
    private ImageView eXp;
    private TextView eXq;
    private LinearLayout eXr;
    private ChallengeJinzhuView eXs;
    private ChallengeJinzhuView eXt;
    private ChallengeJinzhuView eXu;
    private RelativeLayout eXv;
    private RelativeLayout eXw;
    private HeadImageView eXx;
    private TextView eXy;
    private LinearLayout eXz;
    private CountDownTimer ewi;
    private boolean isHost;
    private Context mContext;
    private Handler mHandler;
    private RelativeLayout rootView;
    private int screenWidth;

    /* loaded from: classes3.dex */
    public interface a {
        void b(ae aeVar);

        void ble();

        void c(ae aeVar);
    }

    public AlaChallengeLiveView(Context context) {
        super(context);
        this.isHost = false;
        this.eXR = -1L;
        this.eXS = -1L;
        this.screenWidth = -1;
        this.eXT = 0;
        this.eXU = 0;
        init(context);
    }

    public AlaChallengeLiveView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isHost = false;
        this.eXR = -1L;
        this.eXS = -1L;
        this.screenWidth = -1;
        this.eXT = 0;
        this.eXU = 0;
        init(context);
    }

    public AlaChallengeLiveView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isHost = false;
        this.eXR = -1L;
        this.eXS = -1L;
        this.screenWidth = -1;
        this.eXT = 0;
        this.eXU = 0;
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
        this.eXe = (RelativeLayout) this.rootView.findViewById(a.g.root_container);
        this.eXg = (RelativeLayout) this.rootView.findViewById(a.g.anchor_live_anim_layout);
        this.eXh = (TbImageView) this.rootView.findViewById(a.g.anchor_live_anim_bg);
        this.eXj = (RelativeLayout) this.rootView.findViewById(a.g.rival_live_anim_layout);
        this.eXk = (TbImageView) this.rootView.findViewById(a.g.rival_live_anim_bg);
        this.eXf = (RelativeLayout) this.rootView.findViewById(a.g.pk_live_container);
        this.eXn = (RelativeLayout) this.rootView.findViewById(a.g.pk_anchor_live_layout);
        this.eXo = (LinearLayout) this.rootView.findViewById(a.g.anchor_streak_win_layout);
        this.eXp = (ImageView) this.rootView.findViewById(a.g.anchor_user_pk_streak_img);
        this.eXq = (TextView) this.rootView.findViewById(a.g.anchor_user_pk_streak_time);
        this.eXm = (RelativeLayout) this.rootView.findViewById(a.g.jinzhu_container);
        this.eXr = (LinearLayout) this.rootView.findViewById(a.g.anchor_jinzhu_layout);
        this.eXs = (ChallengeJinzhuView) this.rootView.findViewById(a.g.anchor_jinzhu_1);
        this.eXt = (ChallengeJinzhuView) this.rootView.findViewById(a.g.anchor_jinzhu_2);
        this.eXu = (ChallengeJinzhuView) this.rootView.findViewById(a.g.anchor_jinzhu_3);
        this.eXv = (RelativeLayout) this.rootView.findViewById(a.g.pk_rival_live_layout);
        this.eXw = (RelativeLayout) this.rootView.findViewById(a.g.pk_rival_user_layout);
        this.eXx = (HeadImageView) this.rootView.findViewById(a.g.ala_live_rival_user_image);
        this.eXy = (TextView) this.rootView.findViewById(a.g.ala_live_rival_user_name);
        this.eXD = (LinearLayout) this.rootView.findViewById(a.g.rival_streak_win_layout);
        this.eXz = (LinearLayout) this.rootView.findViewById(a.g.rival_jinzhu_layout);
        this.eXA = (ChallengeJinzhuView) this.rootView.findViewById(a.g.rival_jinzhu_1);
        this.eXB = (ChallengeJinzhuView) this.rootView.findViewById(a.g.rival_jinzhu_2);
        this.eXC = (ChallengeJinzhuView) this.rootView.findViewById(a.g.rival_jinzhu_3);
        this.eXE = (ImageView) this.rootView.findViewById(a.g.rival_user_pk_streak_img);
        this.eXF = (TextView) this.rootView.findViewById(a.g.rival_user_pk_streak_time);
        this.eXG = (LinearLayout) this.rootView.findViewById(a.g.pk_time_layout);
        this.eXH = (TextView) this.rootView.findViewById(a.g.pk_time_label);
        this.eXI = (RelativeLayout) this.rootView.findViewById(a.g.pk_score_progress_layout);
        this.eXJ = (TextView) this.rootView.findViewById(a.g.pk_anchor_label);
        this.eXL = (TextView) this.rootView.findViewById(a.g.pk_anchor_progress);
        this.eXM = (TextView) this.rootView.findViewById(a.g.pk_rival_progress);
        this.eXK = (TextView) this.rootView.findViewById(a.g.pk_rival_label);
        this.eXP = (TextView) this.rootView.findViewById(a.g.btn_close_challenge_view);
        this.eXN = this.rootView.findViewById(a.g.anchor_progress_bg);
        this.eXO = this.rootView.findViewById(a.g.rival_progress_bg);
        this.eXi = this.rootView.findViewById(a.g.anchor_live_anim_fore_bg);
        this.eXl = this.rootView.findViewById(a.g.rival_live_anim_fore_bg);
        this.eXw.setVisibility(0);
        this.eXw.setBackgroundResource(a.f.sdk_round_host_header_bg);
        this.eXx.setIsRound(true);
        this.eXx.setAutoChangeStyle(false);
        this.eXx.setDefaultBgResource(a.f.sdk_icon_default_avatar100_bg);
        this.eXx.setIsNight(false);
        this.eXv.setOnClickListener(this);
        this.eXw.setOnClickListener(this);
        this.eXP.setOnClickListener(this);
        this.eXr.setVisibility(8);
        this.eXz.setVisibility(8);
    }

    private void updateView() {
        this.eXU = g.aK(this.mContext);
        this.eXT = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds50);
        this.screenWidth = BdUtilHelper.getScreenDimensions(this.mContext)[0];
        int aN = g.aN(this.mContext);
        int aM = g.aM(this.mContext);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = this.eXU;
        layoutParams.height = aM;
        this.eXf.setLayoutParams(layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(aN, aM);
        layoutParams2.addRule(9);
        this.eXn.setLayoutParams(layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(aN, aM);
        layoutParams3.addRule(11);
        this.eXv.setLayoutParams(layoutParams3);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(aN, aM);
        layoutParams4.addRule(11);
        layoutParams4.topMargin = this.eXU;
        this.eXj.setLayoutParams(layoutParams4);
        RelativeLayout.LayoutParams layoutParams5 = (RelativeLayout.LayoutParams) this.eXG.getLayoutParams();
        layoutParams5.topMargin = this.eXU;
        layoutParams5.addRule(14);
        this.eXG.setLayoutParams(layoutParams5);
        this.eXI.setAlpha(0.0f);
    }

    public View getAnchorAnimLiveLayout() {
        return this.eXg;
    }

    public View getAnchorAnimLiveForeBg() {
        return this.eXi;
    }

    public View getRivalAnimLiveLayout() {
        return this.eXj;
    }

    public View getRivalAnimLiveForeBg() {
        return this.eXl;
    }

    public TbImageView getAnchorAnimLiveBgView() {
        return this.eXh;
    }

    public void setAnchorUserViewBg(ae aeVar) {
        this.eXh.setScaleType(ImageView.ScaleType.FIT_XY);
        String str = "";
        if (aeVar.abx != null) {
            str = aeVar.abx.portrait;
        }
        this.eXh.startLoad(str, 12, false);
        this.eXh.setVisibility(0);
    }

    public void setRivalUserViewBg(ae aeVar) {
        this.eXk.setScaleType(ImageView.ScaleType.FIT_XY);
        String str = "";
        if (aeVar.abx != null) {
            str = aeVar.abx.portrait;
        }
        this.eXk.startLoad(str, 12, false);
    }

    public View getLeftTimeView() {
        return this.eXG;
    }

    public ViewGroup getLiveContainerView() {
        return this.eXf;
    }

    public View getScoreProgressLayout() {
        return this.eXI;
    }

    public View getJinzhuLayout() {
        return this.eXm;
    }

    public View getCloseBtnView() {
        return this.eXP;
    }

    public RelativeLayout getContainerView() {
        return this.eXe;
    }

    public void a(ad adVar, ae aeVar, ae aeVar2, boolean z) {
        this.eUs = aeVar;
        this.eUt = aeVar2;
        int i = adVar.abz;
        a(adVar.challengeId, i, adVar.abD, adVar.abC);
        v(adVar.abE, adVar.abF);
        if (z) {
            a(aeVar2);
        }
        if (i == 2) {
            setCloseBtnVisible(true);
            blc();
        } else if (i == 3) {
            setCloseBtnVisible(false);
            bo(adVar.challengeResult, adVar.abG);
        } else {
            bdS();
            setCloseBtnVisible(false);
            bo(adVar.challengeResult, adVar.abG);
        }
        a(aeVar.abK);
        b(aeVar2.abK);
        this.eXV = adVar;
    }

    private void a(ac acVar) {
        ArrayList arrayList;
        if (acVar == null) {
            this.eXs.setVisibility(8);
            this.eXt.setVisibility(8);
            this.eXu.setVisibility(8);
            return;
        }
        this.eXr.setVisibility(0);
        if (ListUtils.isEmpty(acVar.aby)) {
            acVar.aby = this.eXX;
        }
        if (ListUtils.isEmpty(acVar.aby)) {
            this.eXs.setVisibility(0);
            this.eXt.setVisibility(8);
            this.eXu.setVisibility(8);
            this.eXs.a(true, null, acVar.liveId);
            return;
        }
        this.eXX = acVar.aby;
        this.eXs.setVisibility(8);
        this.eXt.setVisibility(8);
        this.eXu.setVisibility(8);
        if (acVar.aby.size() > 3) {
            ArrayList arrayList2 = new ArrayList();
            for (int i = 0; i < 3; i++) {
                arrayList2.add(acVar.aby.get(i));
            }
            arrayList = arrayList2;
        } else {
            arrayList = acVar.aby;
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            ab abVar = arrayList.get(i2);
            if (abVar != null) {
                if (abVar.qF() || abVar.isFirst()) {
                    this.eXs.setVisibility(0);
                    this.eXs.a(true, abVar, acVar.liveId);
                } else if (abVar.rank == 2) {
                    this.eXt.setVisibility(0);
                    this.eXt.a(true, abVar, acVar.liveId);
                } else if (abVar.rank == 3) {
                    this.eXu.setVisibility(0);
                    this.eXu.a(true, abVar, acVar.liveId);
                }
            }
        }
    }

    private void b(ac acVar) {
        List<ab> list;
        if (acVar == null) {
            this.eXA.setVisibility(8);
            this.eXB.setVisibility(8);
            this.eXC.setVisibility(8);
            return;
        }
        this.eXz.setVisibility(0);
        if (ListUtils.isEmpty(acVar.aby)) {
            acVar.aby = this.eXY;
        }
        if (ListUtils.isEmpty(acVar.aby)) {
            this.eXA.setVisibility(0);
            this.eXB.setVisibility(8);
            this.eXC.setVisibility(8);
            this.eXA.a(false, null, acVar.liveId);
            return;
        }
        this.eXY = acVar.aby;
        this.eXA.setVisibility(8);
        this.eXB.setVisibility(8);
        this.eXC.setVisibility(8);
        if (acVar.aby.size() > 3) {
            list = acVar.aby.subList(0, 3);
        } else {
            list = acVar.aby;
        }
        for (int i = 0; i < list.size(); i++) {
            ab abVar = list.get(i);
            if (abVar != null) {
                if (abVar.qF() || abVar.isFirst()) {
                    this.eXA.setVisibility(0);
                    this.eXA.a(false, abVar, acVar.liveId);
                } else if (abVar.rank == 2) {
                    this.eXB.setVisibility(0);
                    this.eXB.a(false, abVar, acVar.liveId);
                } else if (abVar.rank == 3) {
                    this.eXC.setVisibility(0);
                    this.eXC.a(false, abVar, acVar.liveId);
                }
            }
        }
    }

    private void a(long j, int i, long j2, long j3) {
        if (j3 >= j2 && a(j, i, j3)) {
            bdS();
            if (this.eXV != null) {
                u(this.eXV.abz, (j3 - j2) * 1000);
            }
            this.ewi = new CountDownTimer((j3 - j2) * 1000, 1000L) { // from class: com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeLiveView.1
                @Override // android.os.CountDownTimer
                public void onTick(long j4) {
                    if (AlaChallengeLiveView.this.eXV != null) {
                        AlaChallengeLiveView.this.u(AlaChallengeLiveView.this.eXV.abz, j4);
                    }
                }

                @Override // android.os.CountDownTimer
                public void onFinish() {
                    if (AlaChallengeLiveView.this.eXV != null) {
                        AlaChallengeLiveView.this.u(AlaChallengeLiveView.this.eXV.abz, 0L);
                    }
                }
            };
            this.ewi.start();
        }
    }

    private boolean a(long j, int i, long j2) {
        return (this.eXV != null && this.eXV.challengeId == j && this.eXV.abz == i && this.eXV.abC == j2) ? false : true;
    }

    private void bdS() {
        if (this.ewi != null) {
            this.ewi.cancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(int i, long j) {
        if (this.eXH != null) {
            String formatSecondsTime = StringHelper.formatSecondsTime(Math.round(j / 1000.0d));
            String string = this.mContext.getString(a.i.ala_challenge_operate_challenge_time, formatSecondsTime);
            if (i == 2) {
                string = this.mContext.getString(a.i.ala_challenge_operate_challenge_time, formatSecondsTime);
            } else if (i == 3) {
                string = this.mContext.getString(a.i.ala_challenge_operate_publish_time, formatSecondsTime);
            } else if (i == 4) {
                string = this.mContext.getString(a.i.ala_challenge_operate_over_time);
            }
            this.eXH.setText(string);
        }
    }

    public void setLiveContainerVisible(boolean z) {
        this.eXf.setVisibility(z ? 0 : 4);
    }

    public void setCloseBtnVisible(boolean z) {
        if (this.isHost) {
            this.eXP.setVisibility(z ? 0 : 4);
        } else {
            this.eXP.setVisibility(4);
        }
    }

    public void blb() {
        setCloseBtnVisible(false);
        setLiveContainerVisible(false);
        if (this.eXX != null) {
            this.eXX.clear();
            this.eXX = null;
        }
        if (this.eXY != null) {
            this.eXY.clear();
            this.eXY = null;
        }
        this.eXV = null;
    }

    public void bo(int i, int i2) {
        this.eXo.setVisibility(0);
        this.eXD.setVisibility(0);
        this.eXq.setVisibility(4);
        this.eXF.setVisibility(4);
        if (1 == i) {
            this.eXp.setImageResource(a.f.icon_live_vs_win);
            if (i2 >= 2) {
                this.eXq.setVisibility(0);
                this.eXq.setText(this.mContext.getResources().getString(a.i.ala_challenge_streak_win_label, Integer.valueOf(i2)));
            } else {
                this.eXq.setText("");
            }
            this.eXE.setImageResource(a.f.icon_live_vs_lose);
        } else if (3 == i) {
            this.eXp.setImageResource(a.f.icon_live_vs_draw);
            this.eXE.setImageResource(a.f.icon_live_vs_draw);
        } else if (2 == i) {
            this.eXp.setImageResource(a.f.icon_live_vs_lose);
            if (i2 >= 2) {
                this.eXF.setVisibility(0);
                this.eXF.setText(this.mContext.getResources().getString(a.i.ala_challenge_streak_win_label, Integer.valueOf(i2)));
            } else {
                this.eXF.setText("");
            }
            this.eXE.setImageResource(a.f.icon_live_vs_win);
        } else {
            blc();
        }
    }

    public void blc() {
        this.eXo.setVisibility(4);
        this.eXD.setVisibility(4);
    }

    public void bld() {
        if (this.eXX != null) {
            this.eXX.clear();
            this.eXX = null;
        }
        if (this.eXY != null) {
            this.eXY.clear();
            this.eXY = null;
        }
    }

    private void v(long j, long j2) {
        int i;
        if (this.eXR != j || this.eXS != j2) {
            this.eXR = j;
            this.eXS = j2;
            this.eXL.setText(String.valueOf(this.eXR));
            this.eXM.setText(String.valueOf(this.eXS));
            float f = (float) (this.eXR + this.eXS);
            final int dimensionPixelSize = (this.screenWidth - (this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds20) * 2)) - (this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds6) * 2);
            int i2 = dimensionPixelSize / 2;
            if (f != 0.0f) {
                int i3 = (int) ((((float) this.eXR) / f) * dimensionPixelSize);
                int i4 = ((LinearLayout.LayoutParams) this.eXN.getLayoutParams()).width;
                if (i3 < this.eXT) {
                    i = this.eXT;
                } else {
                    i = i3 > dimensionPixelSize - this.eXT ? dimensionPixelSize - this.eXT : i3;
                }
                if (this.eXW != null) {
                    this.eXW.cancel();
                }
                this.eXW = ValueAnimator.ofInt(i4, i);
                this.eXW.setDuration(100L);
                this.eXW.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeLiveView.2
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) AlaChallengeLiveView.this.eXN.getLayoutParams();
                        layoutParams.width = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                        AlaChallengeLiveView.this.eXN.setLayoutParams(layoutParams);
                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) AlaChallengeLiveView.this.eXO.getLayoutParams();
                        layoutParams2.width = dimensionPixelSize - layoutParams.width;
                        AlaChallengeLiveView.this.eXO.setLayoutParams(layoutParams2);
                    }
                });
                this.eXW.start();
                return;
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eXN.getLayoutParams();
            layoutParams.width = i2;
            this.eXN.setLayoutParams(layoutParams);
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.eXO.getLayoutParams();
            layoutParams2.width = dimensionPixelSize - layoutParams.width;
            this.eXO.setLayoutParams(layoutParams2);
        }
    }

    public void a(ae aeVar) {
        if (aeVar == null || aeVar.abx == null) {
            this.eXw.setVisibility(4);
            return;
        }
        this.eXw.setTag(aeVar);
        this.eXx.startLoad(aeVar.abx.portrait, 12, false, false);
        String str = aeVar.abx.userName;
        if (TextHelper.getTextLengthWithEmoji(str) > 12) {
            str = TextHelper.subStringWithEmoji(str, 12) + StringHelper.STRING_MORE;
        }
        this.eXy.setText(str);
    }

    public View getRivalUserInfoView() {
        return this.eXw;
    }

    public void releaseResource() {
        bdS();
        this.eXV = null;
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.eXP) {
            if (this.eXQ != null) {
                this.eXQ.ble();
            }
        } else if (view == this.eXw) {
            if (this.eXQ != null) {
                this.eXQ.b((ae) this.eXw.getTag());
            }
        } else if (view == this.eXv && this.eXQ != null) {
            this.eXQ.c(this.eUt);
        }
    }

    public void setViewClickCallBack(a aVar) {
        this.eXQ = aVar;
    }
}
