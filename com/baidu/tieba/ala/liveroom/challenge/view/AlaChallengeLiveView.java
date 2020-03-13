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
    private ae eUG;
    private ae eUH;
    private RelativeLayout eXA;
    private RelativeLayout eXB;
    private LinearLayout eXC;
    private ImageView eXD;
    private TextView eXE;
    private LinearLayout eXF;
    private ChallengeJinzhuView eXG;
    private ChallengeJinzhuView eXH;
    private ChallengeJinzhuView eXI;
    private RelativeLayout eXJ;
    private RelativeLayout eXK;
    private HeadImageView eXL;
    private TextView eXM;
    private LinearLayout eXN;
    private ChallengeJinzhuView eXO;
    private ChallengeJinzhuView eXP;
    private ChallengeJinzhuView eXQ;
    private LinearLayout eXR;
    private ImageView eXS;
    private TextView eXT;
    private LinearLayout eXU;
    private TextView eXV;
    private RelativeLayout eXW;
    private TextView eXX;
    private TextView eXY;
    private TextView eXZ;
    private RelativeLayout eXs;
    private RelativeLayout eXt;
    private RelativeLayout eXu;
    private TbImageView eXv;
    private View eXw;
    private RelativeLayout eXx;
    private TbImageView eXy;
    private View eXz;
    private TextView eYa;
    private View eYb;
    private View eYc;
    private TextView eYd;
    private a eYe;
    private long eYf;
    private long eYg;
    private int eYh;
    private int eYi;
    private ad eYj;
    private ValueAnimator eYk;
    private List<ab> eYl;
    private List<ab> eYm;
    private CountDownTimer eww;
    private boolean isHost;
    private Context mContext;
    private Handler mHandler;
    private RelativeLayout rootView;
    private int screenWidth;

    /* loaded from: classes3.dex */
    public interface a {
        void b(ae aeVar);

        void blh();

        void c(ae aeVar);
    }

    public AlaChallengeLiveView(Context context) {
        super(context);
        this.isHost = false;
        this.eYf = -1L;
        this.eYg = -1L;
        this.screenWidth = -1;
        this.eYh = 0;
        this.eYi = 0;
        init(context);
    }

    public AlaChallengeLiveView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isHost = false;
        this.eYf = -1L;
        this.eYg = -1L;
        this.screenWidth = -1;
        this.eYh = 0;
        this.eYi = 0;
        init(context);
    }

    public AlaChallengeLiveView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isHost = false;
        this.eYf = -1L;
        this.eYg = -1L;
        this.screenWidth = -1;
        this.eYh = 0;
        this.eYi = 0;
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
        this.eXs = (RelativeLayout) this.rootView.findViewById(a.g.root_container);
        this.eXu = (RelativeLayout) this.rootView.findViewById(a.g.anchor_live_anim_layout);
        this.eXv = (TbImageView) this.rootView.findViewById(a.g.anchor_live_anim_bg);
        this.eXx = (RelativeLayout) this.rootView.findViewById(a.g.rival_live_anim_layout);
        this.eXy = (TbImageView) this.rootView.findViewById(a.g.rival_live_anim_bg);
        this.eXt = (RelativeLayout) this.rootView.findViewById(a.g.pk_live_container);
        this.eXB = (RelativeLayout) this.rootView.findViewById(a.g.pk_anchor_live_layout);
        this.eXC = (LinearLayout) this.rootView.findViewById(a.g.anchor_streak_win_layout);
        this.eXD = (ImageView) this.rootView.findViewById(a.g.anchor_user_pk_streak_img);
        this.eXE = (TextView) this.rootView.findViewById(a.g.anchor_user_pk_streak_time);
        this.eXA = (RelativeLayout) this.rootView.findViewById(a.g.jinzhu_container);
        this.eXF = (LinearLayout) this.rootView.findViewById(a.g.anchor_jinzhu_layout);
        this.eXG = (ChallengeJinzhuView) this.rootView.findViewById(a.g.anchor_jinzhu_1);
        this.eXH = (ChallengeJinzhuView) this.rootView.findViewById(a.g.anchor_jinzhu_2);
        this.eXI = (ChallengeJinzhuView) this.rootView.findViewById(a.g.anchor_jinzhu_3);
        this.eXJ = (RelativeLayout) this.rootView.findViewById(a.g.pk_rival_live_layout);
        this.eXK = (RelativeLayout) this.rootView.findViewById(a.g.pk_rival_user_layout);
        this.eXL = (HeadImageView) this.rootView.findViewById(a.g.ala_live_rival_user_image);
        this.eXM = (TextView) this.rootView.findViewById(a.g.ala_live_rival_user_name);
        this.eXR = (LinearLayout) this.rootView.findViewById(a.g.rival_streak_win_layout);
        this.eXN = (LinearLayout) this.rootView.findViewById(a.g.rival_jinzhu_layout);
        this.eXO = (ChallengeJinzhuView) this.rootView.findViewById(a.g.rival_jinzhu_1);
        this.eXP = (ChallengeJinzhuView) this.rootView.findViewById(a.g.rival_jinzhu_2);
        this.eXQ = (ChallengeJinzhuView) this.rootView.findViewById(a.g.rival_jinzhu_3);
        this.eXS = (ImageView) this.rootView.findViewById(a.g.rival_user_pk_streak_img);
        this.eXT = (TextView) this.rootView.findViewById(a.g.rival_user_pk_streak_time);
        this.eXU = (LinearLayout) this.rootView.findViewById(a.g.pk_time_layout);
        this.eXV = (TextView) this.rootView.findViewById(a.g.pk_time_label);
        this.eXW = (RelativeLayout) this.rootView.findViewById(a.g.pk_score_progress_layout);
        this.eXX = (TextView) this.rootView.findViewById(a.g.pk_anchor_label);
        this.eXZ = (TextView) this.rootView.findViewById(a.g.pk_anchor_progress);
        this.eYa = (TextView) this.rootView.findViewById(a.g.pk_rival_progress);
        this.eXY = (TextView) this.rootView.findViewById(a.g.pk_rival_label);
        this.eYd = (TextView) this.rootView.findViewById(a.g.btn_close_challenge_view);
        this.eYb = this.rootView.findViewById(a.g.anchor_progress_bg);
        this.eYc = this.rootView.findViewById(a.g.rival_progress_bg);
        this.eXw = this.rootView.findViewById(a.g.anchor_live_anim_fore_bg);
        this.eXz = this.rootView.findViewById(a.g.rival_live_anim_fore_bg);
        this.eXK.setVisibility(0);
        this.eXK.setBackgroundResource(a.f.sdk_round_host_header_bg);
        this.eXL.setIsRound(true);
        this.eXL.setAutoChangeStyle(false);
        this.eXL.setDefaultBgResource(a.f.sdk_icon_default_avatar100_bg);
        this.eXL.setIsNight(false);
        this.eXJ.setOnClickListener(this);
        this.eXK.setOnClickListener(this);
        this.eYd.setOnClickListener(this);
        this.eXF.setVisibility(8);
        this.eXN.setVisibility(8);
    }

    private void updateView() {
        this.eYi = g.aK(this.mContext);
        this.eYh = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds50);
        this.screenWidth = BdUtilHelper.getScreenDimensions(this.mContext)[0];
        int aN = g.aN(this.mContext);
        int aM = g.aM(this.mContext);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = this.eYi;
        layoutParams.height = aM;
        this.eXt.setLayoutParams(layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(aN, aM);
        layoutParams2.addRule(9);
        this.eXB.setLayoutParams(layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(aN, aM);
        layoutParams3.addRule(11);
        this.eXJ.setLayoutParams(layoutParams3);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(aN, aM);
        layoutParams4.addRule(11);
        layoutParams4.topMargin = this.eYi;
        this.eXx.setLayoutParams(layoutParams4);
        RelativeLayout.LayoutParams layoutParams5 = (RelativeLayout.LayoutParams) this.eXU.getLayoutParams();
        layoutParams5.topMargin = this.eYi;
        layoutParams5.addRule(14);
        this.eXU.setLayoutParams(layoutParams5);
        this.eXW.setAlpha(0.0f);
    }

    public View getAnchorAnimLiveLayout() {
        return this.eXu;
    }

    public View getAnchorAnimLiveForeBg() {
        return this.eXw;
    }

    public View getRivalAnimLiveLayout() {
        return this.eXx;
    }

    public View getRivalAnimLiveForeBg() {
        return this.eXz;
    }

    public TbImageView getAnchorAnimLiveBgView() {
        return this.eXv;
    }

    public void setAnchorUserViewBg(ae aeVar) {
        this.eXv.setScaleType(ImageView.ScaleType.FIT_XY);
        String str = "";
        if (aeVar.abx != null) {
            str = aeVar.abx.portrait;
        }
        this.eXv.startLoad(str, 12, false);
        this.eXv.setVisibility(0);
    }

    public void setRivalUserViewBg(ae aeVar) {
        this.eXy.setScaleType(ImageView.ScaleType.FIT_XY);
        String str = "";
        if (aeVar.abx != null) {
            str = aeVar.abx.portrait;
        }
        this.eXy.startLoad(str, 12, false);
    }

    public View getLeftTimeView() {
        return this.eXU;
    }

    public ViewGroup getLiveContainerView() {
        return this.eXt;
    }

    public View getScoreProgressLayout() {
        return this.eXW;
    }

    public View getJinzhuLayout() {
        return this.eXA;
    }

    public View getCloseBtnView() {
        return this.eYd;
    }

    public RelativeLayout getContainerView() {
        return this.eXs;
    }

    public void a(ad adVar, ae aeVar, ae aeVar2, boolean z) {
        this.eUG = aeVar;
        this.eUH = aeVar2;
        int i = adVar.abz;
        a(adVar.challengeId, i, adVar.abD, adVar.abC);
        v(adVar.abE, adVar.abF);
        if (z) {
            a(aeVar2);
        }
        if (i == 2) {
            setCloseBtnVisible(true);
            blf();
        } else if (i == 3) {
            setCloseBtnVisible(false);
            bo(adVar.challengeResult, adVar.abG);
        } else {
            bdV();
            setCloseBtnVisible(false);
            bo(adVar.challengeResult, adVar.abG);
        }
        a(aeVar.abK);
        b(aeVar2.abK);
        this.eYj = adVar;
    }

    private void a(ac acVar) {
        ArrayList arrayList;
        if (acVar == null) {
            this.eXG.setVisibility(8);
            this.eXH.setVisibility(8);
            this.eXI.setVisibility(8);
            return;
        }
        this.eXF.setVisibility(0);
        if (ListUtils.isEmpty(acVar.aby)) {
            acVar.aby = this.eYl;
        }
        if (ListUtils.isEmpty(acVar.aby)) {
            this.eXG.setVisibility(0);
            this.eXH.setVisibility(8);
            this.eXI.setVisibility(8);
            this.eXG.a(true, null, acVar.liveId);
            return;
        }
        this.eYl = acVar.aby;
        this.eXG.setVisibility(8);
        this.eXH.setVisibility(8);
        this.eXI.setVisibility(8);
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
                    this.eXG.setVisibility(0);
                    this.eXG.a(true, abVar, acVar.liveId);
                } else if (abVar.rank == 2) {
                    this.eXH.setVisibility(0);
                    this.eXH.a(true, abVar, acVar.liveId);
                } else if (abVar.rank == 3) {
                    this.eXI.setVisibility(0);
                    this.eXI.a(true, abVar, acVar.liveId);
                }
            }
        }
    }

    private void b(ac acVar) {
        List<ab> list;
        if (acVar == null) {
            this.eXO.setVisibility(8);
            this.eXP.setVisibility(8);
            this.eXQ.setVisibility(8);
            return;
        }
        this.eXN.setVisibility(0);
        if (ListUtils.isEmpty(acVar.aby)) {
            acVar.aby = this.eYm;
        }
        if (ListUtils.isEmpty(acVar.aby)) {
            this.eXO.setVisibility(0);
            this.eXP.setVisibility(8);
            this.eXQ.setVisibility(8);
            this.eXO.a(false, null, acVar.liveId);
            return;
        }
        this.eYm = acVar.aby;
        this.eXO.setVisibility(8);
        this.eXP.setVisibility(8);
        this.eXQ.setVisibility(8);
        if (acVar.aby.size() > 3) {
            list = acVar.aby.subList(0, 3);
        } else {
            list = acVar.aby;
        }
        for (int i = 0; i < list.size(); i++) {
            ab abVar = list.get(i);
            if (abVar != null) {
                if (abVar.qF() || abVar.isFirst()) {
                    this.eXO.setVisibility(0);
                    this.eXO.a(false, abVar, acVar.liveId);
                } else if (abVar.rank == 2) {
                    this.eXP.setVisibility(0);
                    this.eXP.a(false, abVar, acVar.liveId);
                } else if (abVar.rank == 3) {
                    this.eXQ.setVisibility(0);
                    this.eXQ.a(false, abVar, acVar.liveId);
                }
            }
        }
    }

    private void a(long j, int i, long j2, long j3) {
        if (j3 >= j2 && a(j, i, j3)) {
            bdV();
            if (this.eYj != null) {
                u(this.eYj.abz, (j3 - j2) * 1000);
            }
            this.eww = new CountDownTimer((j3 - j2) * 1000, 1000L) { // from class: com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeLiveView.1
                @Override // android.os.CountDownTimer
                public void onTick(long j4) {
                    if (AlaChallengeLiveView.this.eYj != null) {
                        AlaChallengeLiveView.this.u(AlaChallengeLiveView.this.eYj.abz, j4);
                    }
                }

                @Override // android.os.CountDownTimer
                public void onFinish() {
                    if (AlaChallengeLiveView.this.eYj != null) {
                        AlaChallengeLiveView.this.u(AlaChallengeLiveView.this.eYj.abz, 0L);
                    }
                }
            };
            this.eww.start();
        }
    }

    private boolean a(long j, int i, long j2) {
        return (this.eYj != null && this.eYj.challengeId == j && this.eYj.abz == i && this.eYj.abC == j2) ? false : true;
    }

    private void bdV() {
        if (this.eww != null) {
            this.eww.cancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(int i, long j) {
        if (this.eXV != null) {
            String formatSecondsTime = StringHelper.formatSecondsTime(Math.round(j / 1000.0d));
            String string = this.mContext.getString(a.i.ala_challenge_operate_challenge_time, formatSecondsTime);
            if (i == 2) {
                string = this.mContext.getString(a.i.ala_challenge_operate_challenge_time, formatSecondsTime);
            } else if (i == 3) {
                string = this.mContext.getString(a.i.ala_challenge_operate_publish_time, formatSecondsTime);
            } else if (i == 4) {
                string = this.mContext.getString(a.i.ala_challenge_operate_over_time);
            }
            this.eXV.setText(string);
        }
    }

    public void setLiveContainerVisible(boolean z) {
        this.eXt.setVisibility(z ? 0 : 4);
    }

    public void setCloseBtnVisible(boolean z) {
        if (this.isHost) {
            this.eYd.setVisibility(z ? 0 : 4);
        } else {
            this.eYd.setVisibility(4);
        }
    }

    public void ble() {
        setCloseBtnVisible(false);
        setLiveContainerVisible(false);
        if (this.eYl != null) {
            this.eYl.clear();
            this.eYl = null;
        }
        if (this.eYm != null) {
            this.eYm.clear();
            this.eYm = null;
        }
        this.eYj = null;
    }

    public void bo(int i, int i2) {
        this.eXC.setVisibility(0);
        this.eXR.setVisibility(0);
        this.eXE.setVisibility(4);
        this.eXT.setVisibility(4);
        if (1 == i) {
            this.eXD.setImageResource(a.f.icon_live_vs_win);
            if (i2 >= 2) {
                this.eXE.setVisibility(0);
                this.eXE.setText(this.mContext.getResources().getString(a.i.ala_challenge_streak_win_label, Integer.valueOf(i2)));
            } else {
                this.eXE.setText("");
            }
            this.eXS.setImageResource(a.f.icon_live_vs_lose);
        } else if (3 == i) {
            this.eXD.setImageResource(a.f.icon_live_vs_draw);
            this.eXS.setImageResource(a.f.icon_live_vs_draw);
        } else if (2 == i) {
            this.eXD.setImageResource(a.f.icon_live_vs_lose);
            if (i2 >= 2) {
                this.eXT.setVisibility(0);
                this.eXT.setText(this.mContext.getResources().getString(a.i.ala_challenge_streak_win_label, Integer.valueOf(i2)));
            } else {
                this.eXT.setText("");
            }
            this.eXS.setImageResource(a.f.icon_live_vs_win);
        } else {
            blf();
        }
    }

    public void blf() {
        this.eXC.setVisibility(4);
        this.eXR.setVisibility(4);
    }

    public void blg() {
        if (this.eYl != null) {
            this.eYl.clear();
            this.eYl = null;
        }
        if (this.eYm != null) {
            this.eYm.clear();
            this.eYm = null;
        }
    }

    private void v(long j, long j2) {
        int i;
        if (this.eYf != j || this.eYg != j2) {
            this.eYf = j;
            this.eYg = j2;
            this.eXZ.setText(String.valueOf(this.eYf));
            this.eYa.setText(String.valueOf(this.eYg));
            float f = (float) (this.eYf + this.eYg);
            final int dimensionPixelSize = (this.screenWidth - (this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds20) * 2)) - (this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds6) * 2);
            int i2 = dimensionPixelSize / 2;
            if (f != 0.0f) {
                int i3 = (int) ((((float) this.eYf) / f) * dimensionPixelSize);
                int i4 = ((LinearLayout.LayoutParams) this.eYb.getLayoutParams()).width;
                if (i3 < this.eYh) {
                    i = this.eYh;
                } else {
                    i = i3 > dimensionPixelSize - this.eYh ? dimensionPixelSize - this.eYh : i3;
                }
                if (this.eYk != null) {
                    this.eYk.cancel();
                }
                this.eYk = ValueAnimator.ofInt(i4, i);
                this.eYk.setDuration(100L);
                this.eYk.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeLiveView.2
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) AlaChallengeLiveView.this.eYb.getLayoutParams();
                        layoutParams.width = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                        AlaChallengeLiveView.this.eYb.setLayoutParams(layoutParams);
                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) AlaChallengeLiveView.this.eYc.getLayoutParams();
                        layoutParams2.width = dimensionPixelSize - layoutParams.width;
                        AlaChallengeLiveView.this.eYc.setLayoutParams(layoutParams2);
                    }
                });
                this.eYk.start();
                return;
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eYb.getLayoutParams();
            layoutParams.width = i2;
            this.eYb.setLayoutParams(layoutParams);
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.eYc.getLayoutParams();
            layoutParams2.width = dimensionPixelSize - layoutParams.width;
            this.eYc.setLayoutParams(layoutParams2);
        }
    }

    public void a(ae aeVar) {
        if (aeVar == null || aeVar.abx == null) {
            this.eXK.setVisibility(4);
            return;
        }
        this.eXK.setTag(aeVar);
        this.eXL.startLoad(aeVar.abx.portrait, 12, false, false);
        String str = aeVar.abx.userName;
        if (TextHelper.getTextLengthWithEmoji(str) > 12) {
            str = TextHelper.subStringWithEmoji(str, 12) + StringHelper.STRING_MORE;
        }
        this.eXM.setText(str);
    }

    public View getRivalUserInfoView() {
        return this.eXK;
    }

    public void releaseResource() {
        bdV();
        this.eYj = null;
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.eYd) {
            if (this.eYe != null) {
                this.eYe.blh();
            }
        } else if (view == this.eXK) {
            if (this.eYe != null) {
                this.eYe.b((ae) this.eXK.getTag());
            }
        } else if (view == this.eXJ && this.eYe != null) {
            this.eYe.c(this.eUH);
        }
    }

    public void setViewClickCallBack(a aVar) {
        this.eYe = aVar;
    }
}
