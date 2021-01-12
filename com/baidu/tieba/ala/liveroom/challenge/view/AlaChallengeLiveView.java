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
import com.baidu.live.data.ba;
import com.baidu.live.data.bb;
import com.baidu.live.data.bc;
import com.baidu.live.data.bg;
import com.baidu.live.data.bz;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.util.TextHelper;
import com.baidu.live.utils.h;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public class AlaChallengeLiveView extends RelativeLayout implements View.OnClickListener {
    private bg aLJ;
    private bg aLK;
    private CountDownTimer gLs;
    private RelativeLayout haY;
    private ChallengeJinzhuView huA;
    private ChallengeJinzhuView huB;
    private RelativeLayout huC;
    private RelativeLayout huD;
    private HeadImageView huE;
    private TextView huF;
    private ImageView huG;
    private LinearLayout huH;
    private ChallengeJinzhuView huI;
    private ChallengeJinzhuView huJ;
    private ChallengeJinzhuView huK;
    private RelativeLayout huL;
    private ImageView huM;
    private TextView huN;
    private AlaChallengeMvpTipView huO;
    private AlaChallengeMvpDynamicAnimView huP;
    private LinearLayout huQ;
    private TextView huR;
    private RelativeLayout huS;
    private TextView huT;
    private TextView huU;
    private View huV;
    private View huW;
    private TextView huX;
    private a huY;
    private long huZ;
    private RelativeLayout huq;
    private RelativeLayout hur;
    private RelativeLayout hus;
    private RelativeLayout hut;
    private RelativeLayout huu;
    private RelativeLayout huv;
    private ImageView huw;
    private TextView hux;
    private LinearLayout huy;
    private ChallengeJinzhuView huz;
    private long hva;
    private int hvb;
    private int hvc;
    private bc hvd;
    private ValueAnimator hve;
    private AnimatorSet hvf;
    private List<ba> hvg;
    private List<ba> hvh;
    public boolean hvi;
    private boolean isHost;
    private Context mContext;
    private Handler mHandler;
    private RelativeLayout rootView;
    private int screenWidth;

    /* loaded from: classes10.dex */
    public interface a {
        void a(bz bzVar);

        void cda();

        void cdb();

        void d(bg bgVar);

        void e(bg bgVar);

        void f(bg bgVar);

        void nT(boolean z);
    }

    public AlaChallengeLiveView(Context context) {
        super(context);
        this.isHost = false;
        this.huZ = -1L;
        this.hva = -1L;
        this.screenWidth = -1;
        this.hvb = 0;
        this.hvc = 0;
        this.hvi = false;
        init(context);
    }

    public AlaChallengeLiveView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isHost = false;
        this.huZ = -1L;
        this.hva = -1L;
        this.screenWidth = -1;
        this.hvb = 0;
        this.hvc = 0;
        this.hvi = false;
        init(context);
    }

    public AlaChallengeLiveView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isHost = false;
        this.huZ = -1L;
        this.hva = -1L;
        this.screenWidth = -1;
        this.hvb = 0;
        this.hvc = 0;
        this.hvi = false;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.mHandler = new Handler(Looper.getMainLooper());
        initView(context);
        updateView();
    }

    public void setNeedCloseRecommendFloat(boolean z) {
        this.hvi = z;
        this.huz.setNeedCloseRecommendFloat(this.hvi);
        this.huA.setNeedCloseRecommendFloat(this.hvi);
        this.huB.setNeedCloseRecommendFloat(this.hvi);
        this.huI.setNeedCloseRecommendFloat(this.hvi);
        this.huJ.setNeedCloseRecommendFloat(this.hvi);
        this.huK.setNeedCloseRecommendFloat(this.hvi);
    }

    public void setIsHost(boolean z) {
        this.isHost = z;
    }

    private void initView(Context context) {
        this.rootView = (RelativeLayout) View.inflate(context, a.g.ala_challenge_panel_optation_view, this);
        this.haY = (RelativeLayout) this.rootView.findViewById(a.f.root_container);
        this.hur = (RelativeLayout) this.rootView.findViewById(a.f.anchor_live_anim_layout);
        this.hus = (RelativeLayout) this.rootView.findViewById(a.f.rival_live_anim_layout);
        this.huq = (RelativeLayout) this.rootView.findViewById(a.f.pk_live_container);
        this.huu = (RelativeLayout) this.rootView.findViewById(a.f.pk_anchor_live_layout);
        this.huv = (RelativeLayout) this.rootView.findViewById(a.f.anchor_streak_win_layout);
        this.huw = (ImageView) this.rootView.findViewById(a.f.anchor_user_pk_streak_img);
        this.hux = (TextView) this.rootView.findViewById(a.f.anchor_user_pk_streak_time);
        this.hut = (RelativeLayout) this.rootView.findViewById(a.f.jinzhu_container);
        this.huy = (LinearLayout) this.rootView.findViewById(a.f.anchor_jinzhu_layout);
        this.huz = (ChallengeJinzhuView) this.rootView.findViewById(a.f.anchor_jinzhu_1);
        this.huA = (ChallengeJinzhuView) this.rootView.findViewById(a.f.anchor_jinzhu_2);
        this.huB = (ChallengeJinzhuView) this.rootView.findViewById(a.f.anchor_jinzhu_3);
        this.huC = (RelativeLayout) this.rootView.findViewById(a.f.pk_rival_live_layout);
        this.huD = (RelativeLayout) this.rootView.findViewById(a.f.pk_rival_user_layout);
        this.huE = (HeadImageView) this.rootView.findViewById(a.f.ala_live_rival_user_image);
        this.huF = (TextView) this.rootView.findViewById(a.f.ala_live_rival_user_name);
        this.huG = (ImageView) this.rootView.findViewById(a.f.iv_rival_user_follow);
        this.huL = (RelativeLayout) this.rootView.findViewById(a.f.rival_streak_win_layout);
        this.huH = (LinearLayout) this.rootView.findViewById(a.f.rival_jinzhu_layout);
        this.huI = (ChallengeJinzhuView) this.rootView.findViewById(a.f.rival_jinzhu_1);
        this.huJ = (ChallengeJinzhuView) this.rootView.findViewById(a.f.rival_jinzhu_2);
        this.huK = (ChallengeJinzhuView) this.rootView.findViewById(a.f.rival_jinzhu_3);
        this.huM = (ImageView) this.rootView.findViewById(a.f.rival_user_pk_streak_img);
        this.huN = (TextView) this.rootView.findViewById(a.f.rival_user_pk_streak_time);
        this.huQ = (LinearLayout) this.rootView.findViewById(a.f.pk_time_layout);
        this.huR = (TextView) this.rootView.findViewById(a.f.pk_time_label);
        this.huS = (RelativeLayout) this.rootView.findViewById(a.f.pk_score_progress_layout);
        this.huT = (TextView) this.rootView.findViewById(a.f.pk_anchor_progress);
        this.huU = (TextView) this.rootView.findViewById(a.f.pk_rival_progress);
        this.huX = (TextView) this.rootView.findViewById(a.f.btn_close_challenge_view);
        this.huV = this.rootView.findViewById(a.f.anchor_progress_bg);
        this.huW = this.rootView.findViewById(a.f.rival_progress_bg);
        this.huO = (AlaChallengeMvpTipView) this.rootView.findViewById(a.f.id_chellenge_mvp_tip);
        this.huP = (AlaChallengeMvpDynamicAnimView) this.rootView.findViewById(a.f.id_challenge_mvp_anim_view);
        this.huD.setVisibility(0);
        this.huD.setBackgroundResource(a.e.sdk_round_host_header_bg);
        this.huE.setIsRound(true);
        this.huE.setAutoChangeStyle(false);
        this.huE.setDefaultBgResource(a.e.sdk_icon_default_avatar100_bg);
        this.huE.setIsNight(false);
        this.huD.setOnClickListener(this);
        this.huG.setOnClickListener(this);
        this.huX.setOnClickListener(this);
        this.huy.setVisibility(8);
        this.huH.setVisibility(8);
        this.huy.setOnClickListener(this);
        this.huH.setOnClickListener(this);
    }

    private void updateView() {
        this.hvc = h.bm(this.mContext);
        this.hvb = this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds50);
        this.screenWidth = BdUtilHelper.getScreenDimensions(this.mContext)[0];
        int bp = h.bp(this.mContext);
        int bo = h.bo(this.mContext);
        ViewGroup.LayoutParams layoutParams = this.huS.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            layoutParams.height = h.bKf;
            ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = h.bl(this.mContext);
            this.huS.setLayoutParams(layoutParams);
        }
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams2.topMargin = this.hvc;
        layoutParams2.height = bo;
        this.huq.setLayoutParams(layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.huP.getLayoutParams();
        layoutParams3.topMargin = this.hvc;
        this.huP.setLayoutParams(layoutParams3);
        ViewGroup.LayoutParams layoutParams4 = this.huu.getLayoutParams();
        if (layoutParams4 != null) {
            layoutParams4.width = bp;
            layoutParams4.height = bo;
            this.huu.setLayoutParams(layoutParams4);
        }
        ViewGroup.LayoutParams layoutParams5 = this.huC.getLayoutParams();
        if (layoutParams5 != null) {
            layoutParams5.width = bp;
            layoutParams5.height = bo;
            this.huC.setLayoutParams(layoutParams5);
        }
        RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(bp, bo);
        layoutParams6.topMargin = this.hvc;
        this.hus.setLayoutParams(layoutParams6);
        RelativeLayout.LayoutParams layoutParams7 = (RelativeLayout.LayoutParams) this.huQ.getLayoutParams();
        layoutParams7.topMargin = this.hvc;
        layoutParams7.addRule(14);
        this.huQ.setLayoutParams(layoutParams7);
        this.huS.setAlpha(0.0f);
        int paddingLeft = (((((bp * 2) - this.hut.getPaddingLeft()) - this.hut.getPaddingRight()) - ((getResources().getDimensionPixelOffset(a.d.sdk_ds56) * 3) * 2)) - (getResources().getDimensionPixelOffset(a.d.sdk_ds12) * 4)) - (getResources().getDimensionPixelOffset(a.d.sdk_ds12) * 2);
        ViewGroup.LayoutParams layoutParams8 = this.huO.getLayoutParams();
        if (layoutParams8 instanceof ViewGroup.MarginLayoutParams) {
            layoutParams8.width = paddingLeft;
            ((ViewGroup.MarginLayoutParams) layoutParams8).bottomMargin = this.hut.getPaddingBottom();
            this.huO.setLayoutParams(layoutParams8);
        }
    }

    public View getAnchorAnimLiveLayout() {
        return this.hur;
    }

    public View getRivalAnimLiveLayout() {
        return this.hus;
    }

    public void setAnchorUserViewBg(bg bgVar) {
    }

    public void setRivalUserViewBg(bg bgVar) {
    }

    public View getLeftTimeView() {
        return this.huQ;
    }

    public ViewGroup getLiveContainerView() {
        return this.huq;
    }

    public View getScoreProgressLayout() {
        return this.huS;
    }

    public View getJinzhuLayout() {
        return this.hut;
    }

    public View getCloseBtnView() {
        return this.huX;
    }

    public RelativeLayout getContainerView() {
        return this.haY;
    }

    public void a(bc bcVar, bg bgVar, bg bgVar2, boolean z) {
        this.aLJ = bgVar;
        this.aLK = bgVar2;
        int i = bcVar.aLN;
        a(bcVar.challengeId, i, bcVar.nowTime, bcVar.stageEndTime);
        c(bcVar.anchorScore, bcVar.rivalScore, z);
        if (z) {
            c(bgVar2);
        }
        if (i == 2) {
            setCloseBtnVisible(true);
            ccW();
        } else if (i == 3) {
            boolean z2 = false;
            if (com.baidu.live.af.a.OJ().bru != null && com.baidu.live.af.a.OJ().bru.aJr == 1) {
                z2 = true;
            }
            if (z2) {
                this.huX.setText(this.mContext.getResources().getString(a.h.ala_challenge_btn_close_label_2));
            }
            setCloseBtnVisible(z2);
            bU(bcVar.challengeResult, bcVar.aLP);
        } else {
            bSZ();
            setCloseBtnVisible(false);
            bU(bcVar.challengeResult, bcVar.aLP);
        }
        a(bgVar.aMa);
        b(bgVar2.aMa);
        this.hvd = bcVar;
    }

    private void a(bb bbVar) {
        ArrayList arrayList;
        if (bbVar == null) {
            this.huz.setVisibility(8);
            this.huA.setVisibility(8);
            this.huB.setVisibility(8);
            return;
        }
        this.huy.setVisibility(0);
        if (ListUtils.isEmpty(bbVar.aLM)) {
            bbVar.aLM = this.hvg;
        }
        if (ListUtils.isEmpty(bbVar.aLM)) {
            this.huz.setVisibility(0);
            this.huA.setVisibility(8);
            this.huB.setVisibility(8);
            this.huz.a(true, null, bbVar.liveId);
            return;
        }
        this.hvg = bbVar.aLM;
        this.huz.setVisibility(8);
        this.huA.setVisibility(8);
        this.huB.setVisibility(8);
        if (bbVar.aLM.size() > 3) {
            ArrayList arrayList2 = new ArrayList();
            for (int i = 0; i < 3; i++) {
                arrayList2.add(bbVar.aLM.get(i));
            }
            arrayList = arrayList2;
        } else {
            arrayList = bbVar.aLM;
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            ba baVar = arrayList.get(i2);
            if (baVar != null) {
                if (baVar.Bj() || baVar.isFirst()) {
                    this.huz.setVisibility(0);
                    this.huz.a(true, baVar, bbVar.liveId);
                } else if (baVar.rank == 2) {
                    this.huA.setVisibility(0);
                    this.huA.a(true, baVar, bbVar.liveId);
                } else if (baVar.rank == 3) {
                    this.huB.setVisibility(0);
                    this.huB.a(true, baVar, bbVar.liveId);
                }
            }
        }
    }

    private void b(bb bbVar) {
        List<ba> list;
        if (bbVar == null) {
            this.huI.setVisibility(8);
            this.huJ.setVisibility(8);
            this.huK.setVisibility(8);
            return;
        }
        this.huH.setVisibility(0);
        if (ListUtils.isEmpty(bbVar.aLM)) {
            bbVar.aLM = this.hvh;
        }
        if (ListUtils.isEmpty(bbVar.aLM)) {
            this.huI.setVisibility(0);
            this.huJ.setVisibility(8);
            this.huK.setVisibility(8);
            this.huI.a(false, null, bbVar.liveId);
            return;
        }
        this.hvh = bbVar.aLM;
        this.huI.setVisibility(8);
        this.huJ.setVisibility(8);
        this.huK.setVisibility(8);
        if (bbVar.aLM.size() > 3) {
            list = bbVar.aLM.subList(0, 3);
        } else {
            list = bbVar.aLM;
        }
        for (int i = 0; i < list.size(); i++) {
            ba baVar = list.get(i);
            if (baVar != null) {
                if (baVar.Bj() || baVar.isFirst()) {
                    this.huI.setVisibility(0);
                    this.huI.a(false, baVar, bbVar.liveId);
                } else if (baVar.rank == 2) {
                    this.huJ.setVisibility(0);
                    this.huJ.a(false, baVar, bbVar.liveId);
                } else if (baVar.rank == 3) {
                    this.huK.setVisibility(0);
                    this.huK.a(false, baVar, bbVar.liveId);
                }
            }
        }
    }

    private void a(long j, int i, long j2, long j3) {
        if (j3 >= j2 && a(j, i, j3)) {
            bSZ();
            if (this.hvd != null) {
                v(this.hvd.aLN, (j3 - j2) * 1000);
            }
            this.gLs = new CountDownTimer((j3 - j2) * 1000, 1000L) { // from class: com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeLiveView.1
                @Override // android.os.CountDownTimer
                public void onTick(long j4) {
                    if (AlaChallengeLiveView.this.hvd != null) {
                        AlaChallengeLiveView.this.v(AlaChallengeLiveView.this.hvd.aLN, j4);
                    }
                }

                @Override // android.os.CountDownTimer
                public void onFinish() {
                    if (AlaChallengeLiveView.this.hvd != null) {
                        AlaChallengeLiveView.this.v(AlaChallengeLiveView.this.hvd.aLN, 0L);
                    }
                }
            };
            this.gLs.start();
        }
    }

    private boolean a(long j, int i, long j2) {
        return (this.hvd != null && this.hvd.challengeId == j && this.hvd.aLN == i && this.hvd.stageEndTime == j2) ? false : true;
    }

    private void bSZ() {
        if (this.gLs != null) {
            this.gLs.cancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(int i, long j) {
        if (this.huR != null) {
            this.huR.setCompoundDrawables(null, null, null, null);
            String formatSecondsTime = StringHelper.formatSecondsTime(Math.round(j / 1000.0d));
            String string = this.mContext.getString(a.h.ala_challenge_operate_challenge_time, formatSecondsTime);
            if (i == 2) {
                Drawable drawable = getResources().getDrawable(a.e.icon_challenge_timer_countdown);
                drawable.setBounds(0, 0, getResources().getDimensionPixelOffset(a.d.sdk_ds40), getResources().getDimensionPixelOffset(a.d.sdk_ds40));
                this.huR.setCompoundDrawablePadding(getResources().getDimensionPixelOffset(a.d.sdk_ds8));
                this.huR.setCompoundDrawables(drawable, null, null, null);
            } else if (i == 3) {
                formatSecondsTime = this.mContext.getString(a.h.ala_challenge_operate_publish_time, formatSecondsTime);
            } else {
                formatSecondsTime = i == 4 ? this.mContext.getString(a.h.ala_challenge_operate_over_time) : string;
            }
            this.huR.setText(formatSecondsTime);
        }
    }

    public void setLiveContainerVisible(boolean z) {
        this.huq.setVisibility(z ? 0 : 4);
    }

    public void setCloseBtnVisible(boolean z) {
        if (this.isHost) {
            this.huX.setVisibility(z ? 0 : 4);
        } else {
            this.huX.setVisibility(4);
        }
    }

    public void ccV() {
        setCloseBtnVisible(false);
        this.huX.setText(this.mContext.getResources().getString(a.h.ala_challenge_btn_close_label));
        this.huO.Ez();
        this.huP.cdg();
        setLiveContainerVisible(false);
        if (this.hvg != null) {
            this.hvg.clear();
            this.hvg = null;
        }
        if (this.hvh != null) {
            this.hvh.clear();
            this.hvh = null;
        }
        this.hvd = null;
    }

    public void bU(int i, int i2) {
        this.huv.setVisibility(0);
        this.huL.setVisibility(0);
        this.hux.setVisibility(4);
        this.huN.setVisibility(4);
        if (1 == i) {
            this.huw.setImageResource(a.e.icon_live_vs_win);
            if (i2 >= 2) {
                this.hux.setVisibility(0);
                this.hux.setText(this.mContext.getResources().getString(a.h.ala_challenge_streak_win_label, Integer.valueOf(i2)));
            } else {
                this.hux.setText("");
            }
            this.huM.setImageResource(a.e.icon_live_vs_lose);
        } else if (3 == i) {
            this.huw.setImageResource(a.e.icon_live_vs_draw);
            this.huM.setImageResource(a.e.icon_live_vs_draw);
        } else if (2 == i) {
            this.huw.setImageResource(a.e.icon_live_vs_lose);
            if (i2 >= 2) {
                this.huN.setVisibility(0);
                this.huN.setText(this.mContext.getResources().getString(a.h.ala_challenge_streak_win_label, Integer.valueOf(i2)));
            } else {
                this.huN.setText("");
            }
            this.huM.setImageResource(a.e.icon_live_vs_win);
        } else {
            ccW();
        }
    }

    public void ccW() {
        this.huv.setVisibility(4);
        this.huL.setVisibility(4);
    }

    public void ccX() {
        if (this.hvg != null) {
            this.hvg.clear();
            this.hvg = null;
        }
        if (this.hvh != null) {
            this.hvh.clear();
            this.hvh = null;
        }
    }

    private ValueAnimator cu(final View view) {
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

    public void ccY() {
        this.huT.setText(String.valueOf(this.huZ));
        this.huU.setText(String.valueOf(this.hva));
        if (this.hvf != null) {
            this.hvf.cancel();
        }
        this.hvf = new AnimatorSet();
        ValueAnimator cu = cu(this.huT);
        ValueAnimator cu2 = cu(this.huU);
        if (this.huZ != this.hva) {
            this.hvf.setStartDelay(500L);
        } else {
            this.hvf.setStartDelay(200L);
        }
        this.hvf.playTogether(cu, cu2);
        this.hvf.start();
    }

    public void ccZ() {
        this.huT.setAlpha(0.0f);
        this.huU.setAlpha(0.0f);
        this.huT.setText("");
        this.huU.setText("");
    }

    private void c(long j, long j2, boolean z) {
        int i;
        if (z || this.huZ != j || this.hva != j2) {
            this.huZ = j;
            this.hva = j2;
            if (z) {
                ccZ();
            } else {
                this.huT.setText(String.valueOf(this.huZ));
                this.huU.setText(String.valueOf(this.hva));
            }
            float f = (float) (this.huZ + this.hva);
            int i2 = this.screenWidth;
            int i3 = i2 / 2;
            if (z && f != 0.0f) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.huV.getLayoutParams();
                layoutParams.width = i3;
                this.huV.setLayoutParams(layoutParams);
            }
            if (this.huZ != this.hva && f > 0.0f) {
                int i4 = (int) ((((float) this.huZ) / f) * i2);
                int i5 = !z ? ((LinearLayout.LayoutParams) this.huV.getLayoutParams()).width : i3;
                if (i4 < this.hvb) {
                    i = this.hvb;
                } else {
                    i = i4 > i2 - this.hvb ? i2 - this.hvb : i4;
                }
                if (this.hve != null) {
                    this.hve.cancel();
                }
                this.hve = ValueAnimator.ofInt(i5, i);
                if (z) {
                    this.hve.setDuration(300L);
                    this.hve.setStartDelay(200L);
                } else {
                    this.hve.setDuration(100L);
                }
                this.hve.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeLiveView.3
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) AlaChallengeLiveView.this.huV.getLayoutParams();
                        layoutParams2.width = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                        AlaChallengeLiveView.this.huV.setLayoutParams(layoutParams2);
                    }
                });
                this.hve.start();
                return;
            }
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.huV.getLayoutParams();
            layoutParams2.width = i3;
            this.huV.setLayoutParams(layoutParams2);
        }
    }

    public void c(bg bgVar) {
        if (bgVar == null || bgVar.aLL == null) {
            this.huD.setVisibility(4);
            return;
        }
        this.huD.setTag(bgVar);
        this.huE.startLoad(bgVar.aLL.portrait, 12, false, false);
        String str = bgVar.aLL.userName;
        if (TextHelper.getTextLengthWithEmoji(str) > 8) {
            str = TextHelper.subStringWithEmoji(str, 8) + StringHelper.STRING_MORE;
        }
        this.huF.setText(str);
        this.huG.setVisibility(8);
    }

    public void nS(boolean z) {
        if (this.huG != null) {
            this.huG.setVisibility(z ? 8 : 0);
        }
    }

    public View getRivalUserInfoView() {
        return this.huD;
    }

    public void releaseResource() {
        bSZ();
        if (this.hve != null) {
            this.hve.cancel();
        }
        if (this.hvf != null) {
            this.hvf.cancel();
        }
        ccZ();
        this.huQ.setAlpha(0.0f);
        this.huX.setText(this.mContext.getResources().getString(a.h.ala_challenge_btn_close_label));
        this.huO.Ez();
        this.huP.cdg();
        this.hvd = null;
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z = true;
        if (view == this.huX) {
            if (this.huY != null) {
                if (com.baidu.live.af.a.OJ().bru == null || this.hvd == null || this.hvd.aLN != 3 || com.baidu.live.af.a.OJ().bru.aJr != 1) {
                    z = false;
                }
                if (z) {
                    if (this.hvd != null) {
                        this.huY.a(this.hvd.aLS);
                        return;
                    }
                    return;
                }
                this.huY.cda();
            }
        } else if (view == this.huD) {
            if (this.huY != null) {
                if (this.hvi) {
                    this.huY.cdb();
                } else {
                    this.huY.d((bg) this.huD.getTag());
                }
            }
        } else if (view == this.huG) {
            if (this.huY != null) {
                if (this.hvi) {
                    this.huY.cdb();
                } else {
                    this.huY.e((bg) this.huD.getTag());
                }
            }
        } else if (view == this.huC) {
            if (this.huY != null) {
                if (this.hvi) {
                    this.huY.cdb();
                } else {
                    this.huY.f(this.aLK);
                }
            }
        } else if (view == this.huy) {
            this.huY.nT(false);
        } else if (view == this.huH) {
            this.huY.nT(true);
        }
    }

    public void setViewClickCallBack(a aVar) {
        this.huY = aVar;
    }
}
