package com.baidu.tieba.ala.liveroom.challenge.view;

import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.be;
import com.baidu.live.data.bf;
import com.baidu.live.data.bg;
import com.baidu.live.data.bk;
import com.baidu.live.data.cg;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.util.TextHelper;
import com.baidu.live.utils.h;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes11.dex */
public class AlaChallengeLiveView extends RelativeLayout implements View.OnClickListener {
    private bk aOG;
    private bk aOH;
    private CountDownTimer gNY;
    private RelativeLayout hdI;
    private RelativeLayout hyA;
    private RelativeLayout hyB;
    private RelativeLayout hyC;
    private RelativeLayout hyD;
    private RelativeLayout hyE;
    private RelativeLayout hyF;
    private ImageView hyG;
    private TextView hyH;
    private LinearLayout hyI;
    private ChallengeJinzhuView hyJ;
    private ChallengeJinzhuView hyK;
    private ChallengeJinzhuView hyL;
    private RelativeLayout hyM;
    private RelativeLayout hyN;
    private HeadImageView hyO;
    private TextView hyP;
    private ImageView hyQ;
    private LinearLayout hyR;
    private ChallengeJinzhuView hyS;
    private ChallengeJinzhuView hyT;
    private ChallengeJinzhuView hyU;
    private RelativeLayout hyV;
    private ImageView hyW;
    private TextView hyX;
    private AlaChallengeMvpTipView hyY;
    private AlaChallengeMvpDynamicAnimView hyZ;
    private LinearLayout hza;
    private TextView hzb;
    private RelativeLayout hzc;
    private TextView hzd;
    private TextView hze;
    private View hzf;
    private View hzg;
    private TextView hzh;
    private a hzi;
    private long hzj;
    private long hzk;
    private int hzl;
    private int hzm;
    private bg hzn;
    private ValueAnimator hzo;
    private AnimatorSet hzp;
    private List<be> hzq;
    private List<be> hzr;
    public boolean hzs;
    private boolean isHost;
    private Context mContext;
    private Handler mHandler;
    private RelativeLayout rootView;
    private int screenWidth;

    /* loaded from: classes11.dex */
    public interface a {
        void a(cg cgVar);

        void cdV();

        void cdW();

        void d(bk bkVar);

        void e(bk bkVar);

        void f(bk bkVar);

        void oe(boolean z);
    }

    public AlaChallengeLiveView(Context context) {
        super(context);
        this.isHost = false;
        this.hzj = -1L;
        this.hzk = -1L;
        this.screenWidth = -1;
        this.hzl = 0;
        this.hzm = 0;
        this.hzs = false;
        init(context);
    }

    public AlaChallengeLiveView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isHost = false;
        this.hzj = -1L;
        this.hzk = -1L;
        this.screenWidth = -1;
        this.hzl = 0;
        this.hzm = 0;
        this.hzs = false;
        init(context);
    }

    public AlaChallengeLiveView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isHost = false;
        this.hzj = -1L;
        this.hzk = -1L;
        this.screenWidth = -1;
        this.hzl = 0;
        this.hzm = 0;
        this.hzs = false;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.mHandler = new Handler(Looper.getMainLooper());
        initView(context);
        updateView();
    }

    public void setNeedCloseRecommendFloat(boolean z) {
        this.hzs = z;
        this.hyJ.setNeedCloseRecommendFloat(this.hzs);
        this.hyK.setNeedCloseRecommendFloat(this.hzs);
        this.hyL.setNeedCloseRecommendFloat(this.hzs);
        this.hyS.setNeedCloseRecommendFloat(this.hzs);
        this.hyT.setNeedCloseRecommendFloat(this.hzs);
        this.hyU.setNeedCloseRecommendFloat(this.hzs);
    }

    public void setIsHost(boolean z) {
        this.isHost = z;
    }

    private void initView(Context context) {
        this.rootView = (RelativeLayout) View.inflate(context, a.g.ala_challenge_panel_optation_view, this);
        this.hdI = (RelativeLayout) this.rootView.findViewById(a.f.root_container);
        this.hyB = (RelativeLayout) this.rootView.findViewById(a.f.anchor_live_anim_layout);
        this.hyC = (RelativeLayout) this.rootView.findViewById(a.f.rival_live_anim_layout);
        this.hyA = (RelativeLayout) this.rootView.findViewById(a.f.pk_live_container);
        this.hyE = (RelativeLayout) this.rootView.findViewById(a.f.pk_anchor_live_layout);
        this.hyF = (RelativeLayout) this.rootView.findViewById(a.f.anchor_streak_win_layout);
        this.hyG = (ImageView) this.rootView.findViewById(a.f.anchor_user_pk_streak_img);
        this.hyH = (TextView) this.rootView.findViewById(a.f.anchor_user_pk_streak_time);
        this.hyD = (RelativeLayout) this.rootView.findViewById(a.f.jinzhu_container);
        this.hyI = (LinearLayout) this.rootView.findViewById(a.f.anchor_jinzhu_layout);
        this.hyJ = (ChallengeJinzhuView) this.rootView.findViewById(a.f.anchor_jinzhu_1);
        this.hyK = (ChallengeJinzhuView) this.rootView.findViewById(a.f.anchor_jinzhu_2);
        this.hyL = (ChallengeJinzhuView) this.rootView.findViewById(a.f.anchor_jinzhu_3);
        this.hyM = (RelativeLayout) this.rootView.findViewById(a.f.pk_rival_live_layout);
        this.hyN = (RelativeLayout) this.rootView.findViewById(a.f.pk_rival_user_layout);
        this.hyO = (HeadImageView) this.rootView.findViewById(a.f.ala_live_rival_user_image);
        this.hyP = (TextView) this.rootView.findViewById(a.f.ala_live_rival_user_name);
        this.hyQ = (ImageView) this.rootView.findViewById(a.f.iv_rival_user_follow);
        this.hyV = (RelativeLayout) this.rootView.findViewById(a.f.rival_streak_win_layout);
        this.hyR = (LinearLayout) this.rootView.findViewById(a.f.rival_jinzhu_layout);
        this.hyS = (ChallengeJinzhuView) this.rootView.findViewById(a.f.rival_jinzhu_1);
        this.hyT = (ChallengeJinzhuView) this.rootView.findViewById(a.f.rival_jinzhu_2);
        this.hyU = (ChallengeJinzhuView) this.rootView.findViewById(a.f.rival_jinzhu_3);
        this.hyW = (ImageView) this.rootView.findViewById(a.f.rival_user_pk_streak_img);
        this.hyX = (TextView) this.rootView.findViewById(a.f.rival_user_pk_streak_time);
        this.hza = (LinearLayout) this.rootView.findViewById(a.f.pk_time_layout);
        this.hzb = (TextView) this.rootView.findViewById(a.f.pk_time_label);
        this.hzc = (RelativeLayout) this.rootView.findViewById(a.f.pk_score_progress_layout);
        this.hzd = (TextView) this.rootView.findViewById(a.f.pk_anchor_progress);
        this.hze = (TextView) this.rootView.findViewById(a.f.pk_rival_progress);
        this.hzh = (TextView) this.rootView.findViewById(a.f.btn_close_challenge_view);
        this.hzf = this.rootView.findViewById(a.f.anchor_progress_bg);
        this.hzg = this.rootView.findViewById(a.f.rival_progress_bg);
        this.hyY = (AlaChallengeMvpTipView) this.rootView.findViewById(a.f.id_chellenge_mvp_tip);
        this.hyZ = (AlaChallengeMvpDynamicAnimView) this.rootView.findViewById(a.f.id_challenge_mvp_anim_view);
        this.hyN.setVisibility(0);
        this.hyN.setBackgroundResource(a.e.sdk_round_host_header_bg);
        this.hyO.setIsRound(true);
        this.hyO.setAutoChangeStyle(false);
        this.hyO.setDefaultBgResource(a.e.sdk_icon_default_avatar100);
        this.hyO.setIsNight(false);
        this.hyN.setOnClickListener(this);
        this.hyQ.setOnClickListener(this);
        this.hzh.setOnClickListener(this);
        this.hyI.setVisibility(8);
        this.hyR.setVisibility(8);
        this.hyI.setOnClickListener(this);
        this.hyR.setOnClickListener(this);
    }

    private void updateView() {
        this.hzm = h.bm(this.mContext);
        this.hzl = this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds50);
        this.screenWidth = BdUtilHelper.getScreenDimensions(this.mContext)[0];
        int bp = h.bp(this.mContext);
        int bo = h.bo(this.mContext);
        ViewGroup.LayoutParams layoutParams = this.hzc.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            layoutParams.height = h.bNP;
            ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = h.bl(this.mContext);
            this.hzc.setLayoutParams(layoutParams);
        }
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams2.topMargin = this.hzm;
        layoutParams2.height = bo;
        this.hyA.setLayoutParams(layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.hyZ.getLayoutParams();
        layoutParams3.topMargin = this.hzm;
        this.hyZ.setLayoutParams(layoutParams3);
        ViewGroup.LayoutParams layoutParams4 = this.hyE.getLayoutParams();
        if (layoutParams4 != null) {
            layoutParams4.width = bp;
            layoutParams4.height = bo;
            this.hyE.setLayoutParams(layoutParams4);
        }
        ViewGroup.LayoutParams layoutParams5 = this.hyM.getLayoutParams();
        if (layoutParams5 != null) {
            layoutParams5.width = bp;
            layoutParams5.height = bo;
            this.hyM.setLayoutParams(layoutParams5);
        }
        RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(bp, bo);
        layoutParams6.topMargin = this.hzm;
        this.hyC.setLayoutParams(layoutParams6);
        RelativeLayout.LayoutParams layoutParams7 = (RelativeLayout.LayoutParams) this.hza.getLayoutParams();
        layoutParams7.topMargin = this.hzm;
        layoutParams7.addRule(14);
        this.hza.setLayoutParams(layoutParams7);
        this.hzc.setAlpha(0.0f);
        int paddingLeft = (((((bp * 2) - this.hyD.getPaddingLeft()) - this.hyD.getPaddingRight()) - ((getResources().getDimensionPixelOffset(a.d.sdk_ds56) * 3) * 2)) - (getResources().getDimensionPixelOffset(a.d.sdk_ds12) * 4)) - (getResources().getDimensionPixelOffset(a.d.sdk_ds12) * 2);
        ViewGroup.LayoutParams layoutParams8 = this.hyY.getLayoutParams();
        if (layoutParams8 instanceof ViewGroup.MarginLayoutParams) {
            layoutParams8.width = paddingLeft;
            ((ViewGroup.MarginLayoutParams) layoutParams8).bottomMargin = this.hyD.getPaddingBottom();
            this.hyY.setLayoutParams(layoutParams8);
        }
    }

    public View getAnchorAnimLiveLayout() {
        return this.hyB;
    }

    public View getRivalAnimLiveLayout() {
        return this.hyC;
    }

    public void setAnchorUserViewBg(bk bkVar) {
    }

    public void setRivalUserViewBg(bk bkVar) {
    }

    public View getLeftTimeView() {
        return this.hza;
    }

    public ViewGroup getLiveContainerView() {
        return this.hyA;
    }

    public View getScoreProgressLayout() {
        return this.hzc;
    }

    public View getJinzhuLayout() {
        return this.hyD;
    }

    public View getCloseBtnView() {
        return this.hzh;
    }

    public RelativeLayout getContainerView() {
        return this.hdI;
    }

    public void a(bg bgVar, bk bkVar, bk bkVar2, boolean z) {
        this.aOG = bkVar;
        this.aOH = bkVar2;
        int i = bgVar.aOK;
        a(bgVar.challengeId, i, bgVar.nowTime, bgVar.stageEndTime);
        d(bgVar.anchorScore, bgVar.rivalScore, z);
        if (z) {
            c(bkVar2);
        }
        if (i == 2) {
            setCloseBtnVisible(true);
            cdR();
        } else if (i == 3) {
            boolean z2 = false;
            if (com.baidu.live.ae.a.Qj().buX != null && com.baidu.live.ae.a.Qj().buX.aMb == 1) {
                z2 = true;
            }
            if (z2) {
                this.hzh.setText(this.mContext.getResources().getString(a.h.ala_challenge_btn_close_label_2));
            }
            setCloseBtnVisible(z2);
            bR(bgVar.challengeResult, bgVar.aOM);
        } else {
            bTC();
            setCloseBtnVisible(false);
            bR(bgVar.challengeResult, bgVar.aOM);
        }
        a(bkVar.aOX);
        b(bkVar2.aOX);
        this.hzn = bgVar;
    }

    private void a(bf bfVar) {
        ArrayList arrayList;
        if (bfVar == null) {
            this.hyJ.setVisibility(8);
            this.hyK.setVisibility(8);
            this.hyL.setVisibility(8);
            return;
        }
        this.hyI.setVisibility(0);
        if (ListUtils.isEmpty(bfVar.aOJ)) {
            bfVar.aOJ = this.hzq;
        }
        if (ListUtils.isEmpty(bfVar.aOJ)) {
            this.hyJ.setVisibility(0);
            this.hyK.setVisibility(8);
            this.hyL.setVisibility(8);
            this.hyJ.a(true, null, bfVar.liveId);
            return;
        }
        this.hzq = bfVar.aOJ;
        this.hyJ.setVisibility(8);
        this.hyK.setVisibility(8);
        this.hyL.setVisibility(8);
        if (bfVar.aOJ.size() > 3) {
            ArrayList arrayList2 = new ArrayList();
            for (int i = 0; i < 3; i++) {
                arrayList2.add(bfVar.aOJ.get(i));
            }
            arrayList = arrayList2;
        } else {
            arrayList = bfVar.aOJ;
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            be beVar = arrayList.get(i2);
            if (beVar != null) {
                if (beVar.Cw() || beVar.isFirst()) {
                    this.hyJ.setVisibility(0);
                    this.hyJ.a(true, beVar, bfVar.liveId);
                } else if (beVar.rank == 2) {
                    this.hyK.setVisibility(0);
                    this.hyK.a(true, beVar, bfVar.liveId);
                } else if (beVar.rank == 3) {
                    this.hyL.setVisibility(0);
                    this.hyL.a(true, beVar, bfVar.liveId);
                }
            }
        }
    }

    private void b(bf bfVar) {
        List<be> list;
        if (bfVar == null) {
            this.hyS.setVisibility(8);
            this.hyT.setVisibility(8);
            this.hyU.setVisibility(8);
            return;
        }
        this.hyR.setVisibility(0);
        if (ListUtils.isEmpty(bfVar.aOJ)) {
            bfVar.aOJ = this.hzr;
        }
        if (ListUtils.isEmpty(bfVar.aOJ)) {
            this.hyS.setVisibility(0);
            this.hyT.setVisibility(8);
            this.hyU.setVisibility(8);
            this.hyS.a(false, null, bfVar.liveId);
            return;
        }
        this.hzr = bfVar.aOJ;
        this.hyS.setVisibility(8);
        this.hyT.setVisibility(8);
        this.hyU.setVisibility(8);
        if (bfVar.aOJ.size() > 3) {
            list = bfVar.aOJ.subList(0, 3);
        } else {
            list = bfVar.aOJ;
        }
        for (int i = 0; i < list.size(); i++) {
            be beVar = list.get(i);
            if (beVar != null) {
                if (beVar.Cw() || beVar.isFirst()) {
                    this.hyS.setVisibility(0);
                    this.hyS.a(false, beVar, bfVar.liveId);
                } else if (beVar.rank == 2) {
                    this.hyT.setVisibility(0);
                    this.hyT.a(false, beVar, bfVar.liveId);
                } else if (beVar.rank == 3) {
                    this.hyU.setVisibility(0);
                    this.hyU.a(false, beVar, bfVar.liveId);
                }
            }
        }
    }

    private void a(long j, int i, long j2, long j3) {
        if (j3 >= j2 && a(j, i, j3)) {
            bTC();
            if (this.hzn != null) {
                w(this.hzn.aOK, (j3 - j2) * 1000);
            }
            this.gNY = new CountDownTimer((j3 - j2) * 1000, 1000L) { // from class: com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeLiveView.1
                @Override // android.os.CountDownTimer
                public void onTick(long j4) {
                    if (AlaChallengeLiveView.this.hzn != null) {
                        AlaChallengeLiveView.this.w(AlaChallengeLiveView.this.hzn.aOK, j4);
                    }
                }

                @Override // android.os.CountDownTimer
                public void onFinish() {
                    if (AlaChallengeLiveView.this.hzn != null) {
                        AlaChallengeLiveView.this.w(AlaChallengeLiveView.this.hzn.aOK, 0L);
                    }
                }
            };
            this.gNY.start();
        }
    }

    private boolean a(long j, int i, long j2) {
        return (this.hzn != null && this.hzn.challengeId == j && this.hzn.aOK == i && this.hzn.stageEndTime == j2) ? false : true;
    }

    private void bTC() {
        if (this.gNY != null) {
            this.gNY.cancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(int i, long j) {
        if (this.hzb != null) {
            this.hzb.setCompoundDrawables(null, null, null, null);
            String formatSecondsTime = StringHelper.formatSecondsTime(Math.round(j / 1000.0d));
            String string = this.mContext.getString(a.h.ala_challenge_operate_challenge_time, formatSecondsTime);
            if (i == 2) {
                Drawable drawable = getResources().getDrawable(a.e.icon_challenge_timer_countdown);
                drawable.setBounds(0, 0, getResources().getDimensionPixelOffset(a.d.sdk_ds40), getResources().getDimensionPixelOffset(a.d.sdk_ds40));
                this.hzb.setCompoundDrawablePadding(getResources().getDimensionPixelOffset(a.d.sdk_ds8));
                this.hzb.setCompoundDrawables(drawable, null, null, null);
            } else if (i == 3) {
                formatSecondsTime = this.mContext.getString(a.h.ala_challenge_operate_publish_time, formatSecondsTime);
            } else {
                formatSecondsTime = i == 4 ? this.mContext.getString(a.h.ala_challenge_operate_over_time) : string;
            }
            this.hzb.setText(formatSecondsTime);
        }
    }

    public void setLiveContainerVisible(boolean z) {
        this.hyA.setVisibility(z ? 0 : 4);
    }

    public void setCloseBtnVisible(boolean z) {
        if (this.isHost) {
            this.hzh.setVisibility(z ? 0 : 4);
        } else {
            this.hzh.setVisibility(4);
        }
    }

    public void cdQ() {
        setCloseBtnVisible(false);
        this.hzh.setText(this.mContext.getResources().getString(a.h.ala_challenge_btn_close_label));
        this.hyY.FP();
        this.hyZ.ceb();
        setLiveContainerVisible(false);
        if (this.hzq != null) {
            this.hzq.clear();
            this.hzq = null;
        }
        if (this.hzr != null) {
            this.hzr.clear();
            this.hzr = null;
        }
        this.hzn = null;
    }

    public void bR(int i, int i2) {
        this.hyF.setVisibility(0);
        this.hyV.setVisibility(0);
        this.hyH.setVisibility(4);
        this.hyX.setVisibility(4);
        if (1 == i) {
            this.hyG.setImageResource(a.e.icon_live_vs_win);
            if (i2 >= 2) {
                this.hyH.setVisibility(0);
                this.hyH.setText(this.mContext.getResources().getString(a.h.ala_challenge_streak_win_label, Integer.valueOf(i2)));
            } else {
                this.hyH.setText("");
            }
            this.hyW.setImageResource(a.e.icon_live_vs_lose);
        } else if (3 == i) {
            this.hyG.setImageResource(a.e.icon_live_vs_draw);
            this.hyW.setImageResource(a.e.icon_live_vs_draw);
        } else if (2 == i) {
            this.hyG.setImageResource(a.e.icon_live_vs_lose);
            if (i2 >= 2) {
                this.hyX.setVisibility(0);
                this.hyX.setText(this.mContext.getResources().getString(a.h.ala_challenge_streak_win_label, Integer.valueOf(i2)));
            } else {
                this.hyX.setText("");
            }
            this.hyW.setImageResource(a.e.icon_live_vs_win);
        } else {
            cdR();
        }
    }

    public void cdR() {
        this.hyF.setVisibility(4);
        this.hyV.setVisibility(4);
    }

    public void cdS() {
        if (this.hzq != null) {
            this.hzq.clear();
            this.hzq = null;
        }
        if (this.hzr != null) {
            this.hzr.clear();
            this.hzr = null;
        }
    }

    private ValueAnimator cq(final View view) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 0.33f, 0.66f, 1.0f, 1.3f, 1.0f);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeLiveView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                view.setScaleX(floatValue);
                view.setScaleY(floatValue);
                view.setAlpha(valueAnimator.getAnimatedFraction());
            }
        });
        ofFloat.setDuration(600L);
        return ofFloat;
    }

    public void cdT() {
        this.hzd.setText(String.valueOf(this.hzj));
        this.hze.setText(String.valueOf(this.hzk));
        if (this.hzp != null) {
            this.hzp.cancel();
        }
        this.hzp = new AnimatorSet();
        ValueAnimator cq = cq(this.hzd);
        ValueAnimator cq2 = cq(this.hze);
        if (this.hzj != this.hzk) {
            this.hzp.setStartDelay(500L);
        } else {
            this.hzp.setStartDelay(200L);
        }
        this.hzp.playTogether(cq, cq2);
        this.hzp.start();
    }

    public void cdU() {
        this.hzd.setAlpha(0.0f);
        this.hze.setAlpha(0.0f);
        this.hzd.setText("");
        this.hze.setText("");
    }

    private void d(long j, long j2, boolean z) {
        int i;
        if (z || this.hzj != j || this.hzk != j2) {
            this.hzj = j;
            this.hzk = j2;
            if (z) {
                cdU();
            } else {
                this.hzd.setText(String.valueOf(this.hzj));
                this.hze.setText(String.valueOf(this.hzk));
            }
            float f = (float) (this.hzj + this.hzk);
            int i2 = this.screenWidth;
            int i3 = i2 / 2;
            if (z && f != 0.0f) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hzf.getLayoutParams();
                layoutParams.width = i3;
                this.hzf.setLayoutParams(layoutParams);
            }
            if (this.hzj != this.hzk && f > 0.0f) {
                int i4 = (int) ((((float) this.hzj) / f) * i2);
                int i5 = !z ? ((LinearLayout.LayoutParams) this.hzf.getLayoutParams()).width : i3;
                if (i4 < this.hzl) {
                    i = this.hzl;
                } else {
                    i = i4 > i2 - this.hzl ? i2 - this.hzl : i4;
                }
                if (this.hzo != null) {
                    this.hzo.cancel();
                }
                this.hzo = ValueAnimator.ofInt(i5, i);
                if (z) {
                    this.hzo.setDuration(300L);
                    this.hzo.setStartDelay(200L);
                } else {
                    this.hzo.setDuration(100L);
                }
                this.hzo.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeLiveView.3
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) AlaChallengeLiveView.this.hzf.getLayoutParams();
                        layoutParams2.width = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                        AlaChallengeLiveView.this.hzf.setLayoutParams(layoutParams2);
                    }
                });
                this.hzo.start();
                return;
            }
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.hzf.getLayoutParams();
            layoutParams2.width = i3;
            this.hzf.setLayoutParams(layoutParams2);
        }
    }

    public void c(bk bkVar) {
        if (bkVar == null || bkVar.aOI == null) {
            this.hyN.setVisibility(4);
            return;
        }
        this.hyN.setTag(bkVar);
        this.hyO.startLoad(bkVar.aOI.portrait, 12, false, false);
        String str = bkVar.aOI.userName;
        if (TextHelper.getTextLengthWithEmoji(str) > 8) {
            str = TextHelper.subStringWithEmoji(str, 8) + StringHelper.STRING_MORE;
        }
        this.hyP.setText(str);
        this.hyQ.setVisibility(8);
    }

    public void od(boolean z) {
        if (this.hyQ != null) {
            this.hyQ.setVisibility(z ? 8 : 0);
        }
    }

    public View getRivalUserInfoView() {
        return this.hyN;
    }

    public void releaseResource() {
        bTC();
        if (this.hzo != null) {
            this.hzo.cancel();
        }
        if (this.hzp != null) {
            this.hzp.cancel();
        }
        cdU();
        this.hza.setAlpha(0.0f);
        this.hzh.setText(this.mContext.getResources().getString(a.h.ala_challenge_btn_close_label));
        this.hyY.FP();
        this.hyZ.ceb();
        this.hzn = null;
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z = true;
        if (view == this.hzh) {
            if (this.hzi != null) {
                if (com.baidu.live.ae.a.Qj().buX == null || this.hzn == null || this.hzn.aOK != 3 || com.baidu.live.ae.a.Qj().buX.aMb != 1) {
                    z = false;
                }
                if (z) {
                    if (this.hzn != null) {
                        this.hzi.a(this.hzn.aOP);
                        return;
                    }
                    return;
                }
                this.hzi.cdV();
            }
        } else if (view == this.hyN) {
            if (this.hzi != null) {
                if (this.hzs) {
                    this.hzi.cdW();
                } else {
                    this.hzi.d((bk) this.hyN.getTag());
                }
            }
        } else if (view == this.hyQ) {
            if (this.hzi != null) {
                if (this.hzs) {
                    this.hzi.cdW();
                } else {
                    this.hzi.e((bk) this.hyN.getTag());
                }
            }
        } else if (view == this.hyM) {
            if (this.hzi != null) {
                if (this.hzs) {
                    this.hzi.cdW();
                } else {
                    this.hzi.f(this.aOH);
                }
            }
        } else if (view == this.hyI) {
            this.hzi.oe(false);
        } else if (view == this.hyR) {
            this.hzi.oe(true);
        }
    }

    public void setViewClickCallBack(a aVar) {
        this.hzi = aVar;
    }
}
