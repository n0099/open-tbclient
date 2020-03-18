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
    private ae eVe;
    private ae eVf;
    private RelativeLayout eXQ;
    private RelativeLayout eXR;
    private RelativeLayout eXS;
    private TbImageView eXT;
    private View eXU;
    private RelativeLayout eXV;
    private TbImageView eXW;
    private View eXX;
    private RelativeLayout eXY;
    private RelativeLayout eXZ;
    private View eYA;
    private TextView eYB;
    private a eYC;
    private long eYD;
    private long eYE;
    private int eYF;
    private int eYG;
    private ad eYH;
    private ValueAnimator eYI;
    private List<ab> eYJ;
    private List<ab> eYK;
    private LinearLayout eYa;
    private ImageView eYb;
    private TextView eYc;
    private LinearLayout eYd;
    private ChallengeJinzhuView eYe;
    private ChallengeJinzhuView eYf;
    private ChallengeJinzhuView eYg;
    private RelativeLayout eYh;
    private RelativeLayout eYi;
    private HeadImageView eYj;
    private TextView eYk;
    private LinearLayout eYl;
    private ChallengeJinzhuView eYm;
    private ChallengeJinzhuView eYn;
    private ChallengeJinzhuView eYo;
    private LinearLayout eYp;
    private ImageView eYq;
    private TextView eYr;
    private LinearLayout eYs;
    private TextView eYt;
    private RelativeLayout eYu;
    private TextView eYv;
    private TextView eYw;
    private TextView eYx;
    private TextView eYy;
    private View eYz;
    private CountDownTimer ewS;
    private boolean isHost;
    private Context mContext;
    private Handler mHandler;
    private RelativeLayout rootView;
    private int screenWidth;

    /* loaded from: classes3.dex */
    public interface a {
        void b(ae aeVar);

        void blm();

        void c(ae aeVar);
    }

    public AlaChallengeLiveView(Context context) {
        super(context);
        this.isHost = false;
        this.eYD = -1L;
        this.eYE = -1L;
        this.screenWidth = -1;
        this.eYF = 0;
        this.eYG = 0;
        init(context);
    }

    public AlaChallengeLiveView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isHost = false;
        this.eYD = -1L;
        this.eYE = -1L;
        this.screenWidth = -1;
        this.eYF = 0;
        this.eYG = 0;
        init(context);
    }

    public AlaChallengeLiveView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isHost = false;
        this.eYD = -1L;
        this.eYE = -1L;
        this.screenWidth = -1;
        this.eYF = 0;
        this.eYG = 0;
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
        this.eXQ = (RelativeLayout) this.rootView.findViewById(a.g.root_container);
        this.eXS = (RelativeLayout) this.rootView.findViewById(a.g.anchor_live_anim_layout);
        this.eXT = (TbImageView) this.rootView.findViewById(a.g.anchor_live_anim_bg);
        this.eXV = (RelativeLayout) this.rootView.findViewById(a.g.rival_live_anim_layout);
        this.eXW = (TbImageView) this.rootView.findViewById(a.g.rival_live_anim_bg);
        this.eXR = (RelativeLayout) this.rootView.findViewById(a.g.pk_live_container);
        this.eXZ = (RelativeLayout) this.rootView.findViewById(a.g.pk_anchor_live_layout);
        this.eYa = (LinearLayout) this.rootView.findViewById(a.g.anchor_streak_win_layout);
        this.eYb = (ImageView) this.rootView.findViewById(a.g.anchor_user_pk_streak_img);
        this.eYc = (TextView) this.rootView.findViewById(a.g.anchor_user_pk_streak_time);
        this.eXY = (RelativeLayout) this.rootView.findViewById(a.g.jinzhu_container);
        this.eYd = (LinearLayout) this.rootView.findViewById(a.g.anchor_jinzhu_layout);
        this.eYe = (ChallengeJinzhuView) this.rootView.findViewById(a.g.anchor_jinzhu_1);
        this.eYf = (ChallengeJinzhuView) this.rootView.findViewById(a.g.anchor_jinzhu_2);
        this.eYg = (ChallengeJinzhuView) this.rootView.findViewById(a.g.anchor_jinzhu_3);
        this.eYh = (RelativeLayout) this.rootView.findViewById(a.g.pk_rival_live_layout);
        this.eYi = (RelativeLayout) this.rootView.findViewById(a.g.pk_rival_user_layout);
        this.eYj = (HeadImageView) this.rootView.findViewById(a.g.ala_live_rival_user_image);
        this.eYk = (TextView) this.rootView.findViewById(a.g.ala_live_rival_user_name);
        this.eYp = (LinearLayout) this.rootView.findViewById(a.g.rival_streak_win_layout);
        this.eYl = (LinearLayout) this.rootView.findViewById(a.g.rival_jinzhu_layout);
        this.eYm = (ChallengeJinzhuView) this.rootView.findViewById(a.g.rival_jinzhu_1);
        this.eYn = (ChallengeJinzhuView) this.rootView.findViewById(a.g.rival_jinzhu_2);
        this.eYo = (ChallengeJinzhuView) this.rootView.findViewById(a.g.rival_jinzhu_3);
        this.eYq = (ImageView) this.rootView.findViewById(a.g.rival_user_pk_streak_img);
        this.eYr = (TextView) this.rootView.findViewById(a.g.rival_user_pk_streak_time);
        this.eYs = (LinearLayout) this.rootView.findViewById(a.g.pk_time_layout);
        this.eYt = (TextView) this.rootView.findViewById(a.g.pk_time_label);
        this.eYu = (RelativeLayout) this.rootView.findViewById(a.g.pk_score_progress_layout);
        this.eYv = (TextView) this.rootView.findViewById(a.g.pk_anchor_label);
        this.eYx = (TextView) this.rootView.findViewById(a.g.pk_anchor_progress);
        this.eYy = (TextView) this.rootView.findViewById(a.g.pk_rival_progress);
        this.eYw = (TextView) this.rootView.findViewById(a.g.pk_rival_label);
        this.eYB = (TextView) this.rootView.findViewById(a.g.btn_close_challenge_view);
        this.eYz = this.rootView.findViewById(a.g.anchor_progress_bg);
        this.eYA = this.rootView.findViewById(a.g.rival_progress_bg);
        this.eXU = this.rootView.findViewById(a.g.anchor_live_anim_fore_bg);
        this.eXX = this.rootView.findViewById(a.g.rival_live_anim_fore_bg);
        this.eYi.setVisibility(0);
        this.eYi.setBackgroundResource(a.f.sdk_round_host_header_bg);
        this.eYj.setIsRound(true);
        this.eYj.setAutoChangeStyle(false);
        this.eYj.setDefaultBgResource(a.f.sdk_icon_default_avatar100_bg);
        this.eYj.setIsNight(false);
        this.eYh.setOnClickListener(this);
        this.eYi.setOnClickListener(this);
        this.eYB.setOnClickListener(this);
        this.eYd.setVisibility(8);
        this.eYl.setVisibility(8);
    }

    private void updateView() {
        this.eYG = g.aJ(this.mContext);
        this.eYF = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds50);
        this.screenWidth = BdUtilHelper.getScreenDimensions(this.mContext)[0];
        int aM = g.aM(this.mContext);
        int aL = g.aL(this.mContext);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = this.eYG;
        layoutParams.height = aL;
        this.eXR.setLayoutParams(layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(aM, aL);
        layoutParams2.addRule(9);
        this.eXZ.setLayoutParams(layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(aM, aL);
        layoutParams3.addRule(11);
        this.eYh.setLayoutParams(layoutParams3);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(aM, aL);
        layoutParams4.addRule(11);
        layoutParams4.topMargin = this.eYG;
        this.eXV.setLayoutParams(layoutParams4);
        RelativeLayout.LayoutParams layoutParams5 = (RelativeLayout.LayoutParams) this.eYs.getLayoutParams();
        layoutParams5.topMargin = this.eYG;
        layoutParams5.addRule(14);
        this.eYs.setLayoutParams(layoutParams5);
        this.eYu.setAlpha(0.0f);
    }

    public View getAnchorAnimLiveLayout() {
        return this.eXS;
    }

    public View getAnchorAnimLiveForeBg() {
        return this.eXU;
    }

    public View getRivalAnimLiveLayout() {
        return this.eXV;
    }

    public View getRivalAnimLiveForeBg() {
        return this.eXX;
    }

    public TbImageView getAnchorAnimLiveBgView() {
        return this.eXT;
    }

    public void setAnchorUserViewBg(ae aeVar) {
        this.eXT.setScaleType(ImageView.ScaleType.FIT_XY);
        String str = "";
        if (aeVar.abH != null) {
            str = aeVar.abH.portrait;
        }
        this.eXT.startLoad(str, 12, false);
        this.eXT.setVisibility(0);
    }

    public void setRivalUserViewBg(ae aeVar) {
        this.eXW.setScaleType(ImageView.ScaleType.FIT_XY);
        String str = "";
        if (aeVar.abH != null) {
            str = aeVar.abH.portrait;
        }
        this.eXW.startLoad(str, 12, false);
    }

    public View getLeftTimeView() {
        return this.eYs;
    }

    public ViewGroup getLiveContainerView() {
        return this.eXR;
    }

    public View getScoreProgressLayout() {
        return this.eYu;
    }

    public View getJinzhuLayout() {
        return this.eXY;
    }

    public View getCloseBtnView() {
        return this.eYB;
    }

    public RelativeLayout getContainerView() {
        return this.eXQ;
    }

    public void a(ad adVar, ae aeVar, ae aeVar2, boolean z) {
        this.eVe = aeVar;
        this.eVf = aeVar2;
        int i = adVar.abJ;
        a(adVar.challengeId, i, adVar.abN, adVar.abM);
        v(adVar.abO, adVar.abP);
        if (z) {
            a(aeVar2);
        }
        if (i == 2) {
            setCloseBtnVisible(true);
            blk();
        } else if (i == 3) {
            setCloseBtnVisible(false);
            bp(adVar.challengeResult, adVar.abQ);
        } else {
            bea();
            setCloseBtnVisible(false);
            bp(adVar.challengeResult, adVar.abQ);
        }
        a(aeVar.abU);
        b(aeVar2.abU);
        this.eYH = adVar;
    }

    private void a(ac acVar) {
        ArrayList arrayList;
        if (acVar == null) {
            this.eYe.setVisibility(8);
            this.eYf.setVisibility(8);
            this.eYg.setVisibility(8);
            return;
        }
        this.eYd.setVisibility(0);
        if (ListUtils.isEmpty(acVar.abI)) {
            acVar.abI = this.eYJ;
        }
        if (ListUtils.isEmpty(acVar.abI)) {
            this.eYe.setVisibility(0);
            this.eYf.setVisibility(8);
            this.eYg.setVisibility(8);
            this.eYe.a(true, null, acVar.liveId);
            return;
        }
        this.eYJ = acVar.abI;
        this.eYe.setVisibility(8);
        this.eYf.setVisibility(8);
        this.eYg.setVisibility(8);
        if (acVar.abI.size() > 3) {
            ArrayList arrayList2 = new ArrayList();
            for (int i = 0; i < 3; i++) {
                arrayList2.add(acVar.abI.get(i));
            }
            arrayList = arrayList2;
        } else {
            arrayList = acVar.abI;
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            ab abVar = arrayList.get(i2);
            if (abVar != null) {
                if (abVar.qK() || abVar.isFirst()) {
                    this.eYe.setVisibility(0);
                    this.eYe.a(true, abVar, acVar.liveId);
                } else if (abVar.rank == 2) {
                    this.eYf.setVisibility(0);
                    this.eYf.a(true, abVar, acVar.liveId);
                } else if (abVar.rank == 3) {
                    this.eYg.setVisibility(0);
                    this.eYg.a(true, abVar, acVar.liveId);
                }
            }
        }
    }

    private void b(ac acVar) {
        List<ab> list;
        if (acVar == null) {
            this.eYm.setVisibility(8);
            this.eYn.setVisibility(8);
            this.eYo.setVisibility(8);
            return;
        }
        this.eYl.setVisibility(0);
        if (ListUtils.isEmpty(acVar.abI)) {
            acVar.abI = this.eYK;
        }
        if (ListUtils.isEmpty(acVar.abI)) {
            this.eYm.setVisibility(0);
            this.eYn.setVisibility(8);
            this.eYo.setVisibility(8);
            this.eYm.a(false, null, acVar.liveId);
            return;
        }
        this.eYK = acVar.abI;
        this.eYm.setVisibility(8);
        this.eYn.setVisibility(8);
        this.eYo.setVisibility(8);
        if (acVar.abI.size() > 3) {
            list = acVar.abI.subList(0, 3);
        } else {
            list = acVar.abI;
        }
        for (int i = 0; i < list.size(); i++) {
            ab abVar = list.get(i);
            if (abVar != null) {
                if (abVar.qK() || abVar.isFirst()) {
                    this.eYm.setVisibility(0);
                    this.eYm.a(false, abVar, acVar.liveId);
                } else if (abVar.rank == 2) {
                    this.eYn.setVisibility(0);
                    this.eYn.a(false, abVar, acVar.liveId);
                } else if (abVar.rank == 3) {
                    this.eYo.setVisibility(0);
                    this.eYo.a(false, abVar, acVar.liveId);
                }
            }
        }
    }

    private void a(long j, int i, long j2, long j3) {
        if (j3 >= j2 && a(j, i, j3)) {
            bea();
            if (this.eYH != null) {
                u(this.eYH.abJ, (j3 - j2) * 1000);
            }
            this.ewS = new CountDownTimer((j3 - j2) * 1000, 1000L) { // from class: com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeLiveView.1
                @Override // android.os.CountDownTimer
                public void onTick(long j4) {
                    if (AlaChallengeLiveView.this.eYH != null) {
                        AlaChallengeLiveView.this.u(AlaChallengeLiveView.this.eYH.abJ, j4);
                    }
                }

                @Override // android.os.CountDownTimer
                public void onFinish() {
                    if (AlaChallengeLiveView.this.eYH != null) {
                        AlaChallengeLiveView.this.u(AlaChallengeLiveView.this.eYH.abJ, 0L);
                    }
                }
            };
            this.ewS.start();
        }
    }

    private boolean a(long j, int i, long j2) {
        return (this.eYH != null && this.eYH.challengeId == j && this.eYH.abJ == i && this.eYH.abM == j2) ? false : true;
    }

    private void bea() {
        if (this.ewS != null) {
            this.ewS.cancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(int i, long j) {
        if (this.eYt != null) {
            String formatSecondsTime = StringHelper.formatSecondsTime(Math.round(j / 1000.0d));
            String string = this.mContext.getString(a.i.ala_challenge_operate_challenge_time, formatSecondsTime);
            if (i == 2) {
                string = this.mContext.getString(a.i.ala_challenge_operate_challenge_time, formatSecondsTime);
            } else if (i == 3) {
                string = this.mContext.getString(a.i.ala_challenge_operate_publish_time, formatSecondsTime);
            } else if (i == 4) {
                string = this.mContext.getString(a.i.ala_challenge_operate_over_time);
            }
            this.eYt.setText(string);
        }
    }

    public void setLiveContainerVisible(boolean z) {
        this.eXR.setVisibility(z ? 0 : 4);
    }

    public void setCloseBtnVisible(boolean z) {
        if (this.isHost) {
            this.eYB.setVisibility(z ? 0 : 4);
        } else {
            this.eYB.setVisibility(4);
        }
    }

    public void blj() {
        setCloseBtnVisible(false);
        setLiveContainerVisible(false);
        if (this.eYJ != null) {
            this.eYJ.clear();
            this.eYJ = null;
        }
        if (this.eYK != null) {
            this.eYK.clear();
            this.eYK = null;
        }
        this.eYH = null;
    }

    public void bp(int i, int i2) {
        this.eYa.setVisibility(0);
        this.eYp.setVisibility(0);
        this.eYc.setVisibility(4);
        this.eYr.setVisibility(4);
        if (1 == i) {
            this.eYb.setImageResource(a.f.icon_live_vs_win);
            if (i2 >= 2) {
                this.eYc.setVisibility(0);
                this.eYc.setText(this.mContext.getResources().getString(a.i.ala_challenge_streak_win_label, Integer.valueOf(i2)));
            } else {
                this.eYc.setText("");
            }
            this.eYq.setImageResource(a.f.icon_live_vs_lose);
        } else if (3 == i) {
            this.eYb.setImageResource(a.f.icon_live_vs_draw);
            this.eYq.setImageResource(a.f.icon_live_vs_draw);
        } else if (2 == i) {
            this.eYb.setImageResource(a.f.icon_live_vs_lose);
            if (i2 >= 2) {
                this.eYr.setVisibility(0);
                this.eYr.setText(this.mContext.getResources().getString(a.i.ala_challenge_streak_win_label, Integer.valueOf(i2)));
            } else {
                this.eYr.setText("");
            }
            this.eYq.setImageResource(a.f.icon_live_vs_win);
        } else {
            blk();
        }
    }

    public void blk() {
        this.eYa.setVisibility(4);
        this.eYp.setVisibility(4);
    }

    public void bll() {
        if (this.eYJ != null) {
            this.eYJ.clear();
            this.eYJ = null;
        }
        if (this.eYK != null) {
            this.eYK.clear();
            this.eYK = null;
        }
    }

    private void v(long j, long j2) {
        int i;
        if (this.eYD != j || this.eYE != j2) {
            this.eYD = j;
            this.eYE = j2;
            this.eYx.setText(String.valueOf(this.eYD));
            this.eYy.setText(String.valueOf(this.eYE));
            float f = (float) (this.eYD + this.eYE);
            final int dimensionPixelSize = (this.screenWidth - (this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds20) * 2)) - (this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds6) * 2);
            int i2 = dimensionPixelSize / 2;
            if (f != 0.0f) {
                int i3 = (int) ((((float) this.eYD) / f) * dimensionPixelSize);
                int i4 = ((LinearLayout.LayoutParams) this.eYz.getLayoutParams()).width;
                if (i3 < this.eYF) {
                    i = this.eYF;
                } else {
                    i = i3 > dimensionPixelSize - this.eYF ? dimensionPixelSize - this.eYF : i3;
                }
                if (this.eYI != null) {
                    this.eYI.cancel();
                }
                this.eYI = ValueAnimator.ofInt(i4, i);
                this.eYI.setDuration(100L);
                this.eYI.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeLiveView.2
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) AlaChallengeLiveView.this.eYz.getLayoutParams();
                        layoutParams.width = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                        AlaChallengeLiveView.this.eYz.setLayoutParams(layoutParams);
                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) AlaChallengeLiveView.this.eYA.getLayoutParams();
                        layoutParams2.width = dimensionPixelSize - layoutParams.width;
                        AlaChallengeLiveView.this.eYA.setLayoutParams(layoutParams2);
                    }
                });
                this.eYI.start();
                return;
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eYz.getLayoutParams();
            layoutParams.width = i2;
            this.eYz.setLayoutParams(layoutParams);
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.eYA.getLayoutParams();
            layoutParams2.width = dimensionPixelSize - layoutParams.width;
            this.eYA.setLayoutParams(layoutParams2);
        }
    }

    public void a(ae aeVar) {
        if (aeVar == null || aeVar.abH == null) {
            this.eYi.setVisibility(4);
            return;
        }
        this.eYi.setTag(aeVar);
        this.eYj.startLoad(aeVar.abH.portrait, 12, false, false);
        String str = aeVar.abH.userName;
        if (TextHelper.getTextLengthWithEmoji(str) > 12) {
            str = TextHelper.subStringWithEmoji(str, 12) + StringHelper.STRING_MORE;
        }
        this.eYk.setText(str);
    }

    public View getRivalUserInfoView() {
        return this.eYi;
    }

    public void releaseResource() {
        bea();
        this.eYH = null;
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.eYB) {
            if (this.eYC != null) {
                this.eYC.blm();
            }
        } else if (view == this.eYi) {
            if (this.eYC != null) {
                this.eYC.b((ae) this.eYi.getTag());
            }
        } else if (view == this.eYh && this.eYC != null) {
            this.eYC.c(this.eVf);
        }
    }

    public void setViewClickCallBack(a aVar) {
        this.eYC = aVar;
    }
}
