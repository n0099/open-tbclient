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
    private ae eUt;
    private ae eUu;
    private LinearLayout eXA;
    private ChallengeJinzhuView eXB;
    private ChallengeJinzhuView eXC;
    private ChallengeJinzhuView eXD;
    private LinearLayout eXE;
    private ImageView eXF;
    private TextView eXG;
    private LinearLayout eXH;
    private TextView eXI;
    private RelativeLayout eXJ;
    private TextView eXK;
    private TextView eXL;
    private TextView eXM;
    private TextView eXN;
    private View eXO;
    private View eXP;
    private TextView eXQ;
    private a eXR;
    private long eXS;
    private long eXT;
    private int eXU;
    private int eXV;
    private ad eXW;
    private ValueAnimator eXX;
    private List<ab> eXY;
    private List<ab> eXZ;
    private RelativeLayout eXf;
    private RelativeLayout eXg;
    private RelativeLayout eXh;
    private TbImageView eXi;
    private View eXj;
    private RelativeLayout eXk;
    private TbImageView eXl;
    private View eXm;
    private RelativeLayout eXn;
    private RelativeLayout eXo;
    private LinearLayout eXp;
    private ImageView eXq;
    private TextView eXr;
    private LinearLayout eXs;
    private ChallengeJinzhuView eXt;
    private ChallengeJinzhuView eXu;
    private ChallengeJinzhuView eXv;
    private RelativeLayout eXw;
    private RelativeLayout eXx;
    private HeadImageView eXy;
    private TextView eXz;
    private CountDownTimer ewj;
    private boolean isHost;
    private Context mContext;
    private Handler mHandler;
    private RelativeLayout rootView;
    private int screenWidth;

    /* loaded from: classes3.dex */
    public interface a {
        void b(ae aeVar);

        void blg();

        void c(ae aeVar);
    }

    public AlaChallengeLiveView(Context context) {
        super(context);
        this.isHost = false;
        this.eXS = -1L;
        this.eXT = -1L;
        this.screenWidth = -1;
        this.eXU = 0;
        this.eXV = 0;
        init(context);
    }

    public AlaChallengeLiveView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isHost = false;
        this.eXS = -1L;
        this.eXT = -1L;
        this.screenWidth = -1;
        this.eXU = 0;
        this.eXV = 0;
        init(context);
    }

    public AlaChallengeLiveView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isHost = false;
        this.eXS = -1L;
        this.eXT = -1L;
        this.screenWidth = -1;
        this.eXU = 0;
        this.eXV = 0;
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
        this.eXf = (RelativeLayout) this.rootView.findViewById(a.g.root_container);
        this.eXh = (RelativeLayout) this.rootView.findViewById(a.g.anchor_live_anim_layout);
        this.eXi = (TbImageView) this.rootView.findViewById(a.g.anchor_live_anim_bg);
        this.eXk = (RelativeLayout) this.rootView.findViewById(a.g.rival_live_anim_layout);
        this.eXl = (TbImageView) this.rootView.findViewById(a.g.rival_live_anim_bg);
        this.eXg = (RelativeLayout) this.rootView.findViewById(a.g.pk_live_container);
        this.eXo = (RelativeLayout) this.rootView.findViewById(a.g.pk_anchor_live_layout);
        this.eXp = (LinearLayout) this.rootView.findViewById(a.g.anchor_streak_win_layout);
        this.eXq = (ImageView) this.rootView.findViewById(a.g.anchor_user_pk_streak_img);
        this.eXr = (TextView) this.rootView.findViewById(a.g.anchor_user_pk_streak_time);
        this.eXn = (RelativeLayout) this.rootView.findViewById(a.g.jinzhu_container);
        this.eXs = (LinearLayout) this.rootView.findViewById(a.g.anchor_jinzhu_layout);
        this.eXt = (ChallengeJinzhuView) this.rootView.findViewById(a.g.anchor_jinzhu_1);
        this.eXu = (ChallengeJinzhuView) this.rootView.findViewById(a.g.anchor_jinzhu_2);
        this.eXv = (ChallengeJinzhuView) this.rootView.findViewById(a.g.anchor_jinzhu_3);
        this.eXw = (RelativeLayout) this.rootView.findViewById(a.g.pk_rival_live_layout);
        this.eXx = (RelativeLayout) this.rootView.findViewById(a.g.pk_rival_user_layout);
        this.eXy = (HeadImageView) this.rootView.findViewById(a.g.ala_live_rival_user_image);
        this.eXz = (TextView) this.rootView.findViewById(a.g.ala_live_rival_user_name);
        this.eXE = (LinearLayout) this.rootView.findViewById(a.g.rival_streak_win_layout);
        this.eXA = (LinearLayout) this.rootView.findViewById(a.g.rival_jinzhu_layout);
        this.eXB = (ChallengeJinzhuView) this.rootView.findViewById(a.g.rival_jinzhu_1);
        this.eXC = (ChallengeJinzhuView) this.rootView.findViewById(a.g.rival_jinzhu_2);
        this.eXD = (ChallengeJinzhuView) this.rootView.findViewById(a.g.rival_jinzhu_3);
        this.eXF = (ImageView) this.rootView.findViewById(a.g.rival_user_pk_streak_img);
        this.eXG = (TextView) this.rootView.findViewById(a.g.rival_user_pk_streak_time);
        this.eXH = (LinearLayout) this.rootView.findViewById(a.g.pk_time_layout);
        this.eXI = (TextView) this.rootView.findViewById(a.g.pk_time_label);
        this.eXJ = (RelativeLayout) this.rootView.findViewById(a.g.pk_score_progress_layout);
        this.eXK = (TextView) this.rootView.findViewById(a.g.pk_anchor_label);
        this.eXM = (TextView) this.rootView.findViewById(a.g.pk_anchor_progress);
        this.eXN = (TextView) this.rootView.findViewById(a.g.pk_rival_progress);
        this.eXL = (TextView) this.rootView.findViewById(a.g.pk_rival_label);
        this.eXQ = (TextView) this.rootView.findViewById(a.g.btn_close_challenge_view);
        this.eXO = this.rootView.findViewById(a.g.anchor_progress_bg);
        this.eXP = this.rootView.findViewById(a.g.rival_progress_bg);
        this.eXj = this.rootView.findViewById(a.g.anchor_live_anim_fore_bg);
        this.eXm = this.rootView.findViewById(a.g.rival_live_anim_fore_bg);
        this.eXx.setVisibility(0);
        this.eXx.setBackgroundResource(a.f.sdk_round_host_header_bg);
        this.eXy.setIsRound(true);
        this.eXy.setAutoChangeStyle(false);
        this.eXy.setDefaultBgResource(a.f.sdk_icon_default_avatar100_bg);
        this.eXy.setIsNight(false);
        this.eXw.setOnClickListener(this);
        this.eXx.setOnClickListener(this);
        this.eXQ.setOnClickListener(this);
        this.eXs.setVisibility(8);
        this.eXA.setVisibility(8);
    }

    private void updateView() {
        this.eXV = g.aK(this.mContext);
        this.eXU = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds50);
        this.screenWidth = BdUtilHelper.getScreenDimensions(this.mContext)[0];
        int aN = g.aN(this.mContext);
        int aM = g.aM(this.mContext);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = this.eXV;
        layoutParams.height = aM;
        this.eXg.setLayoutParams(layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(aN, aM);
        layoutParams2.addRule(9);
        this.eXo.setLayoutParams(layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(aN, aM);
        layoutParams3.addRule(11);
        this.eXw.setLayoutParams(layoutParams3);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(aN, aM);
        layoutParams4.addRule(11);
        layoutParams4.topMargin = this.eXV;
        this.eXk.setLayoutParams(layoutParams4);
        RelativeLayout.LayoutParams layoutParams5 = (RelativeLayout.LayoutParams) this.eXH.getLayoutParams();
        layoutParams5.topMargin = this.eXV;
        layoutParams5.addRule(14);
        this.eXH.setLayoutParams(layoutParams5);
        this.eXJ.setAlpha(0.0f);
    }

    public View getAnchorAnimLiveLayout() {
        return this.eXh;
    }

    public View getAnchorAnimLiveForeBg() {
        return this.eXj;
    }

    public View getRivalAnimLiveLayout() {
        return this.eXk;
    }

    public View getRivalAnimLiveForeBg() {
        return this.eXm;
    }

    public TbImageView getAnchorAnimLiveBgView() {
        return this.eXi;
    }

    public void setAnchorUserViewBg(ae aeVar) {
        this.eXi.setScaleType(ImageView.ScaleType.FIT_XY);
        String str = "";
        if (aeVar.abx != null) {
            str = aeVar.abx.portrait;
        }
        this.eXi.startLoad(str, 12, false);
        this.eXi.setVisibility(0);
    }

    public void setRivalUserViewBg(ae aeVar) {
        this.eXl.setScaleType(ImageView.ScaleType.FIT_XY);
        String str = "";
        if (aeVar.abx != null) {
            str = aeVar.abx.portrait;
        }
        this.eXl.startLoad(str, 12, false);
    }

    public View getLeftTimeView() {
        return this.eXH;
    }

    public ViewGroup getLiveContainerView() {
        return this.eXg;
    }

    public View getScoreProgressLayout() {
        return this.eXJ;
    }

    public View getJinzhuLayout() {
        return this.eXn;
    }

    public View getCloseBtnView() {
        return this.eXQ;
    }

    public RelativeLayout getContainerView() {
        return this.eXf;
    }

    public void a(ad adVar, ae aeVar, ae aeVar2, boolean z) {
        this.eUt = aeVar;
        this.eUu = aeVar2;
        int i = adVar.abz;
        a(adVar.challengeId, i, adVar.abD, adVar.abC);
        v(adVar.abE, adVar.abF);
        if (z) {
            a(aeVar2);
        }
        if (i == 2) {
            setCloseBtnVisible(true);
            ble();
        } else if (i == 3) {
            setCloseBtnVisible(false);
            bo(adVar.challengeResult, adVar.abG);
        } else {
            bdU();
            setCloseBtnVisible(false);
            bo(adVar.challengeResult, adVar.abG);
        }
        a(aeVar.abK);
        b(aeVar2.abK);
        this.eXW = adVar;
    }

    private void a(ac acVar) {
        ArrayList arrayList;
        if (acVar == null) {
            this.eXt.setVisibility(8);
            this.eXu.setVisibility(8);
            this.eXv.setVisibility(8);
            return;
        }
        this.eXs.setVisibility(0);
        if (ListUtils.isEmpty(acVar.aby)) {
            acVar.aby = this.eXY;
        }
        if (ListUtils.isEmpty(acVar.aby)) {
            this.eXt.setVisibility(0);
            this.eXu.setVisibility(8);
            this.eXv.setVisibility(8);
            this.eXt.a(true, null, acVar.liveId);
            return;
        }
        this.eXY = acVar.aby;
        this.eXt.setVisibility(8);
        this.eXu.setVisibility(8);
        this.eXv.setVisibility(8);
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
                    this.eXt.setVisibility(0);
                    this.eXt.a(true, abVar, acVar.liveId);
                } else if (abVar.rank == 2) {
                    this.eXu.setVisibility(0);
                    this.eXu.a(true, abVar, acVar.liveId);
                } else if (abVar.rank == 3) {
                    this.eXv.setVisibility(0);
                    this.eXv.a(true, abVar, acVar.liveId);
                }
            }
        }
    }

    private void b(ac acVar) {
        List<ab> list;
        if (acVar == null) {
            this.eXB.setVisibility(8);
            this.eXC.setVisibility(8);
            this.eXD.setVisibility(8);
            return;
        }
        this.eXA.setVisibility(0);
        if (ListUtils.isEmpty(acVar.aby)) {
            acVar.aby = this.eXZ;
        }
        if (ListUtils.isEmpty(acVar.aby)) {
            this.eXB.setVisibility(0);
            this.eXC.setVisibility(8);
            this.eXD.setVisibility(8);
            this.eXB.a(false, null, acVar.liveId);
            return;
        }
        this.eXZ = acVar.aby;
        this.eXB.setVisibility(8);
        this.eXC.setVisibility(8);
        this.eXD.setVisibility(8);
        if (acVar.aby.size() > 3) {
            list = acVar.aby.subList(0, 3);
        } else {
            list = acVar.aby;
        }
        for (int i = 0; i < list.size(); i++) {
            ab abVar = list.get(i);
            if (abVar != null) {
                if (abVar.qF() || abVar.isFirst()) {
                    this.eXB.setVisibility(0);
                    this.eXB.a(false, abVar, acVar.liveId);
                } else if (abVar.rank == 2) {
                    this.eXC.setVisibility(0);
                    this.eXC.a(false, abVar, acVar.liveId);
                } else if (abVar.rank == 3) {
                    this.eXD.setVisibility(0);
                    this.eXD.a(false, abVar, acVar.liveId);
                }
            }
        }
    }

    private void a(long j, int i, long j2, long j3) {
        if (j3 >= j2 && a(j, i, j3)) {
            bdU();
            if (this.eXW != null) {
                u(this.eXW.abz, (j3 - j2) * 1000);
            }
            this.ewj = new CountDownTimer((j3 - j2) * 1000, 1000L) { // from class: com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeLiveView.1
                @Override // android.os.CountDownTimer
                public void onTick(long j4) {
                    if (AlaChallengeLiveView.this.eXW != null) {
                        AlaChallengeLiveView.this.u(AlaChallengeLiveView.this.eXW.abz, j4);
                    }
                }

                @Override // android.os.CountDownTimer
                public void onFinish() {
                    if (AlaChallengeLiveView.this.eXW != null) {
                        AlaChallengeLiveView.this.u(AlaChallengeLiveView.this.eXW.abz, 0L);
                    }
                }
            };
            this.ewj.start();
        }
    }

    private boolean a(long j, int i, long j2) {
        return (this.eXW != null && this.eXW.challengeId == j && this.eXW.abz == i && this.eXW.abC == j2) ? false : true;
    }

    private void bdU() {
        if (this.ewj != null) {
            this.ewj.cancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(int i, long j) {
        if (this.eXI != null) {
            String formatSecondsTime = StringHelper.formatSecondsTime(Math.round(j / 1000.0d));
            String string = this.mContext.getString(a.i.ala_challenge_operate_challenge_time, formatSecondsTime);
            if (i == 2) {
                string = this.mContext.getString(a.i.ala_challenge_operate_challenge_time, formatSecondsTime);
            } else if (i == 3) {
                string = this.mContext.getString(a.i.ala_challenge_operate_publish_time, formatSecondsTime);
            } else if (i == 4) {
                string = this.mContext.getString(a.i.ala_challenge_operate_over_time);
            }
            this.eXI.setText(string);
        }
    }

    public void setLiveContainerVisible(boolean z) {
        this.eXg.setVisibility(z ? 0 : 4);
    }

    public void setCloseBtnVisible(boolean z) {
        if (this.isHost) {
            this.eXQ.setVisibility(z ? 0 : 4);
        } else {
            this.eXQ.setVisibility(4);
        }
    }

    public void bld() {
        setCloseBtnVisible(false);
        setLiveContainerVisible(false);
        if (this.eXY != null) {
            this.eXY.clear();
            this.eXY = null;
        }
        if (this.eXZ != null) {
            this.eXZ.clear();
            this.eXZ = null;
        }
        this.eXW = null;
    }

    public void bo(int i, int i2) {
        this.eXp.setVisibility(0);
        this.eXE.setVisibility(0);
        this.eXr.setVisibility(4);
        this.eXG.setVisibility(4);
        if (1 == i) {
            this.eXq.setImageResource(a.f.icon_live_vs_win);
            if (i2 >= 2) {
                this.eXr.setVisibility(0);
                this.eXr.setText(this.mContext.getResources().getString(a.i.ala_challenge_streak_win_label, Integer.valueOf(i2)));
            } else {
                this.eXr.setText("");
            }
            this.eXF.setImageResource(a.f.icon_live_vs_lose);
        } else if (3 == i) {
            this.eXq.setImageResource(a.f.icon_live_vs_draw);
            this.eXF.setImageResource(a.f.icon_live_vs_draw);
        } else if (2 == i) {
            this.eXq.setImageResource(a.f.icon_live_vs_lose);
            if (i2 >= 2) {
                this.eXG.setVisibility(0);
                this.eXG.setText(this.mContext.getResources().getString(a.i.ala_challenge_streak_win_label, Integer.valueOf(i2)));
            } else {
                this.eXG.setText("");
            }
            this.eXF.setImageResource(a.f.icon_live_vs_win);
        } else {
            ble();
        }
    }

    public void ble() {
        this.eXp.setVisibility(4);
        this.eXE.setVisibility(4);
    }

    public void blf() {
        if (this.eXY != null) {
            this.eXY.clear();
            this.eXY = null;
        }
        if (this.eXZ != null) {
            this.eXZ.clear();
            this.eXZ = null;
        }
    }

    private void v(long j, long j2) {
        int i;
        if (this.eXS != j || this.eXT != j2) {
            this.eXS = j;
            this.eXT = j2;
            this.eXM.setText(String.valueOf(this.eXS));
            this.eXN.setText(String.valueOf(this.eXT));
            float f = (float) (this.eXS + this.eXT);
            final int dimensionPixelSize = (this.screenWidth - (this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds20) * 2)) - (this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds6) * 2);
            int i2 = dimensionPixelSize / 2;
            if (f != 0.0f) {
                int i3 = (int) ((((float) this.eXS) / f) * dimensionPixelSize);
                int i4 = ((LinearLayout.LayoutParams) this.eXO.getLayoutParams()).width;
                if (i3 < this.eXU) {
                    i = this.eXU;
                } else {
                    i = i3 > dimensionPixelSize - this.eXU ? dimensionPixelSize - this.eXU : i3;
                }
                if (this.eXX != null) {
                    this.eXX.cancel();
                }
                this.eXX = ValueAnimator.ofInt(i4, i);
                this.eXX.setDuration(100L);
                this.eXX.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeLiveView.2
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) AlaChallengeLiveView.this.eXO.getLayoutParams();
                        layoutParams.width = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                        AlaChallengeLiveView.this.eXO.setLayoutParams(layoutParams);
                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) AlaChallengeLiveView.this.eXP.getLayoutParams();
                        layoutParams2.width = dimensionPixelSize - layoutParams.width;
                        AlaChallengeLiveView.this.eXP.setLayoutParams(layoutParams2);
                    }
                });
                this.eXX.start();
                return;
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eXO.getLayoutParams();
            layoutParams.width = i2;
            this.eXO.setLayoutParams(layoutParams);
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.eXP.getLayoutParams();
            layoutParams2.width = dimensionPixelSize - layoutParams.width;
            this.eXP.setLayoutParams(layoutParams2);
        }
    }

    public void a(ae aeVar) {
        if (aeVar == null || aeVar.abx == null) {
            this.eXx.setVisibility(4);
            return;
        }
        this.eXx.setTag(aeVar);
        this.eXy.startLoad(aeVar.abx.portrait, 12, false, false);
        String str = aeVar.abx.userName;
        if (TextHelper.getTextLengthWithEmoji(str) > 12) {
            str = TextHelper.subStringWithEmoji(str, 12) + StringHelper.STRING_MORE;
        }
        this.eXz.setText(str);
    }

    public View getRivalUserInfoView() {
        return this.eXx;
    }

    public void releaseResource() {
        bdU();
        this.eXW = null;
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.eXQ) {
            if (this.eXR != null) {
                this.eXR.blg();
            }
        } else if (view == this.eXx) {
            if (this.eXR != null) {
                this.eXR.b((ae) this.eXx.getTag());
            }
        } else if (view == this.eXw && this.eXR != null) {
            this.eXR.c(this.eUu);
        }
    }

    public void setViewClickCallBack(a aVar) {
        this.eXR = aVar;
    }
}
