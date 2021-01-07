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
/* loaded from: classes11.dex */
public class AlaChallengeLiveView extends RelativeLayout implements View.OnClickListener {
    private bg aQw;
    private bg aQx;
    private CountDownTimer gPY;
    private RelativeLayout hfE;
    private RelativeLayout hyW;
    private RelativeLayout hyX;
    private RelativeLayout hyY;
    private RelativeLayout hyZ;
    private TextView hzA;
    private View hzB;
    private View hzC;
    private TextView hzD;
    private a hzE;
    private long hzF;
    private long hzG;
    private int hzH;
    private int hzI;
    private bc hzJ;
    private ValueAnimator hzK;
    private AnimatorSet hzL;
    private List<ba> hzM;
    private List<ba> hzN;
    public boolean hzO;
    private RelativeLayout hza;
    private RelativeLayout hzb;
    private ImageView hzc;
    private TextView hzd;
    private LinearLayout hze;
    private ChallengeJinzhuView hzf;
    private ChallengeJinzhuView hzg;
    private ChallengeJinzhuView hzh;
    private RelativeLayout hzi;
    private RelativeLayout hzj;
    private HeadImageView hzk;
    private TextView hzl;
    private ImageView hzm;
    private LinearLayout hzn;
    private ChallengeJinzhuView hzo;
    private ChallengeJinzhuView hzp;
    private ChallengeJinzhuView hzq;
    private RelativeLayout hzr;
    private ImageView hzs;
    private TextView hzt;
    private AlaChallengeMvpTipView hzu;
    private AlaChallengeMvpDynamicAnimView hzv;
    private LinearLayout hzw;
    private TextView hzx;
    private RelativeLayout hzy;
    private TextView hzz;
    private boolean isHost;
    private Context mContext;
    private Handler mHandler;
    private RelativeLayout rootView;
    private int screenWidth;

    /* loaded from: classes11.dex */
    public interface a {
        void a(bz bzVar);

        void cgS();

        void cgT();

        void d(bg bgVar);

        void e(bg bgVar);

        void f(bg bgVar);

        void nX(boolean z);
    }

    public AlaChallengeLiveView(Context context) {
        super(context);
        this.isHost = false;
        this.hzF = -1L;
        this.hzG = -1L;
        this.screenWidth = -1;
        this.hzH = 0;
        this.hzI = 0;
        this.hzO = false;
        init(context);
    }

    public AlaChallengeLiveView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isHost = false;
        this.hzF = -1L;
        this.hzG = -1L;
        this.screenWidth = -1;
        this.hzH = 0;
        this.hzI = 0;
        this.hzO = false;
        init(context);
    }

    public AlaChallengeLiveView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isHost = false;
        this.hzF = -1L;
        this.hzG = -1L;
        this.screenWidth = -1;
        this.hzH = 0;
        this.hzI = 0;
        this.hzO = false;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.mHandler = new Handler(Looper.getMainLooper());
        eO(context);
        updateView();
    }

    public void setNeedCloseRecommendFloat(boolean z) {
        this.hzO = z;
        this.hzf.setNeedCloseRecommendFloat(this.hzO);
        this.hzg.setNeedCloseRecommendFloat(this.hzO);
        this.hzh.setNeedCloseRecommendFloat(this.hzO);
        this.hzo.setNeedCloseRecommendFloat(this.hzO);
        this.hzp.setNeedCloseRecommendFloat(this.hzO);
        this.hzq.setNeedCloseRecommendFloat(this.hzO);
    }

    public void setIsHost(boolean z) {
        this.isHost = z;
    }

    private void eO(Context context) {
        this.rootView = (RelativeLayout) View.inflate(context, a.g.ala_challenge_panel_optation_view, this);
        this.hfE = (RelativeLayout) this.rootView.findViewById(a.f.root_container);
        this.hyX = (RelativeLayout) this.rootView.findViewById(a.f.anchor_live_anim_layout);
        this.hyY = (RelativeLayout) this.rootView.findViewById(a.f.rival_live_anim_layout);
        this.hyW = (RelativeLayout) this.rootView.findViewById(a.f.pk_live_container);
        this.hza = (RelativeLayout) this.rootView.findViewById(a.f.pk_anchor_live_layout);
        this.hzb = (RelativeLayout) this.rootView.findViewById(a.f.anchor_streak_win_layout);
        this.hzc = (ImageView) this.rootView.findViewById(a.f.anchor_user_pk_streak_img);
        this.hzd = (TextView) this.rootView.findViewById(a.f.anchor_user_pk_streak_time);
        this.hyZ = (RelativeLayout) this.rootView.findViewById(a.f.jinzhu_container);
        this.hze = (LinearLayout) this.rootView.findViewById(a.f.anchor_jinzhu_layout);
        this.hzf = (ChallengeJinzhuView) this.rootView.findViewById(a.f.anchor_jinzhu_1);
        this.hzg = (ChallengeJinzhuView) this.rootView.findViewById(a.f.anchor_jinzhu_2);
        this.hzh = (ChallengeJinzhuView) this.rootView.findViewById(a.f.anchor_jinzhu_3);
        this.hzi = (RelativeLayout) this.rootView.findViewById(a.f.pk_rival_live_layout);
        this.hzj = (RelativeLayout) this.rootView.findViewById(a.f.pk_rival_user_layout);
        this.hzk = (HeadImageView) this.rootView.findViewById(a.f.ala_live_rival_user_image);
        this.hzl = (TextView) this.rootView.findViewById(a.f.ala_live_rival_user_name);
        this.hzm = (ImageView) this.rootView.findViewById(a.f.iv_rival_user_follow);
        this.hzr = (RelativeLayout) this.rootView.findViewById(a.f.rival_streak_win_layout);
        this.hzn = (LinearLayout) this.rootView.findViewById(a.f.rival_jinzhu_layout);
        this.hzo = (ChallengeJinzhuView) this.rootView.findViewById(a.f.rival_jinzhu_1);
        this.hzp = (ChallengeJinzhuView) this.rootView.findViewById(a.f.rival_jinzhu_2);
        this.hzq = (ChallengeJinzhuView) this.rootView.findViewById(a.f.rival_jinzhu_3);
        this.hzs = (ImageView) this.rootView.findViewById(a.f.rival_user_pk_streak_img);
        this.hzt = (TextView) this.rootView.findViewById(a.f.rival_user_pk_streak_time);
        this.hzw = (LinearLayout) this.rootView.findViewById(a.f.pk_time_layout);
        this.hzx = (TextView) this.rootView.findViewById(a.f.pk_time_label);
        this.hzy = (RelativeLayout) this.rootView.findViewById(a.f.pk_score_progress_layout);
        this.hzz = (TextView) this.rootView.findViewById(a.f.pk_anchor_progress);
        this.hzA = (TextView) this.rootView.findViewById(a.f.pk_rival_progress);
        this.hzD = (TextView) this.rootView.findViewById(a.f.btn_close_challenge_view);
        this.hzB = this.rootView.findViewById(a.f.anchor_progress_bg);
        this.hzC = this.rootView.findViewById(a.f.rival_progress_bg);
        this.hzu = (AlaChallengeMvpTipView) this.rootView.findViewById(a.f.id_chellenge_mvp_tip);
        this.hzv = (AlaChallengeMvpDynamicAnimView) this.rootView.findViewById(a.f.id_challenge_mvp_anim_view);
        this.hzj.setVisibility(0);
        this.hzj.setBackgroundResource(a.e.sdk_round_host_header_bg);
        this.hzk.setIsRound(true);
        this.hzk.setAutoChangeStyle(false);
        this.hzk.setDefaultBgResource(a.e.sdk_icon_default_avatar100_bg);
        this.hzk.setIsNight(false);
        this.hzj.setOnClickListener(this);
        this.hzm.setOnClickListener(this);
        this.hzD.setOnClickListener(this);
        this.hze.setVisibility(8);
        this.hzn.setVisibility(8);
        this.hze.setOnClickListener(this);
        this.hzn.setOnClickListener(this);
    }

    private void updateView() {
        this.hzI = h.bn(this.mContext);
        this.hzH = this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds50);
        this.screenWidth = BdUtilHelper.getScreenDimensions(this.mContext)[0];
        int bq = h.bq(this.mContext);
        int bp = h.bp(this.mContext);
        ViewGroup.LayoutParams layoutParams = this.hzy.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            layoutParams.height = h.bOR;
            ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = h.bm(this.mContext);
            this.hzy.setLayoutParams(layoutParams);
        }
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams2.topMargin = this.hzI;
        layoutParams2.height = bp;
        this.hyW.setLayoutParams(layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.hzv.getLayoutParams();
        layoutParams3.topMargin = this.hzI;
        this.hzv.setLayoutParams(layoutParams3);
        ViewGroup.LayoutParams layoutParams4 = this.hza.getLayoutParams();
        if (layoutParams4 != null) {
            layoutParams4.width = bq;
            layoutParams4.height = bp;
            this.hza.setLayoutParams(layoutParams4);
        }
        ViewGroup.LayoutParams layoutParams5 = this.hzi.getLayoutParams();
        if (layoutParams5 != null) {
            layoutParams5.width = bq;
            layoutParams5.height = bp;
            this.hzi.setLayoutParams(layoutParams5);
        }
        RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(bq, bp);
        layoutParams6.topMargin = this.hzI;
        this.hyY.setLayoutParams(layoutParams6);
        RelativeLayout.LayoutParams layoutParams7 = (RelativeLayout.LayoutParams) this.hzw.getLayoutParams();
        layoutParams7.topMargin = this.hzI;
        layoutParams7.addRule(14);
        this.hzw.setLayoutParams(layoutParams7);
        this.hzy.setAlpha(0.0f);
        int paddingLeft = (((((bq * 2) - this.hyZ.getPaddingLeft()) - this.hyZ.getPaddingRight()) - ((getResources().getDimensionPixelOffset(a.d.sdk_ds56) * 3) * 2)) - (getResources().getDimensionPixelOffset(a.d.sdk_ds12) * 4)) - (getResources().getDimensionPixelOffset(a.d.sdk_ds12) * 2);
        ViewGroup.LayoutParams layoutParams8 = this.hzu.getLayoutParams();
        if (layoutParams8 instanceof ViewGroup.MarginLayoutParams) {
            layoutParams8.width = paddingLeft;
            ((ViewGroup.MarginLayoutParams) layoutParams8).bottomMargin = this.hyZ.getPaddingBottom();
            this.hzu.setLayoutParams(layoutParams8);
        }
    }

    public View getAnchorAnimLiveLayout() {
        return this.hyX;
    }

    public View getRivalAnimLiveLayout() {
        return this.hyY;
    }

    public void setAnchorUserViewBg(bg bgVar) {
    }

    public void setRivalUserViewBg(bg bgVar) {
    }

    public View getLeftTimeView() {
        return this.hzw;
    }

    public ViewGroup getLiveContainerView() {
        return this.hyW;
    }

    public View getScoreProgressLayout() {
        return this.hzy;
    }

    public View getJinzhuLayout() {
        return this.hyZ;
    }

    public View getCloseBtnView() {
        return this.hzD;
    }

    public RelativeLayout getContainerView() {
        return this.hfE;
    }

    public void a(bc bcVar, bg bgVar, bg bgVar2, boolean z) {
        this.aQw = bgVar;
        this.aQx = bgVar2;
        int i = bcVar.aQA;
        a(bcVar.challengeId, i, bcVar.nowTime, bcVar.stageEndTime);
        c(bcVar.anchorScore, bcVar.rivalScore, z);
        if (z) {
            c(bgVar2);
        }
        if (i == 2) {
            setCloseBtnVisible(true);
            cgO();
        } else if (i == 3) {
            boolean z2 = false;
            if (com.baidu.live.af.a.SE().bwi != null && com.baidu.live.af.a.SE().bwi.aOe == 1) {
                z2 = true;
            }
            if (z2) {
                this.hzD.setText(this.mContext.getResources().getString(a.h.ala_challenge_btn_close_label_2));
            }
            setCloseBtnVisible(z2);
            bU(bcVar.challengeResult, bcVar.aQC);
        } else {
            bWR();
            setCloseBtnVisible(false);
            bU(bcVar.challengeResult, bcVar.aQC);
        }
        a(bgVar.aQN);
        b(bgVar2.aQN);
        this.hzJ = bcVar;
    }

    private void a(bb bbVar) {
        ArrayList arrayList;
        if (bbVar == null) {
            this.hzf.setVisibility(8);
            this.hzg.setVisibility(8);
            this.hzh.setVisibility(8);
            return;
        }
        this.hze.setVisibility(0);
        if (ListUtils.isEmpty(bbVar.aQz)) {
            bbVar.aQz = this.hzM;
        }
        if (ListUtils.isEmpty(bbVar.aQz)) {
            this.hzf.setVisibility(0);
            this.hzg.setVisibility(8);
            this.hzh.setVisibility(8);
            this.hzf.a(true, null, bbVar.liveId);
            return;
        }
        this.hzM = bbVar.aQz;
        this.hzf.setVisibility(8);
        this.hzg.setVisibility(8);
        this.hzh.setVisibility(8);
        if (bbVar.aQz.size() > 3) {
            ArrayList arrayList2 = new ArrayList();
            for (int i = 0; i < 3; i++) {
                arrayList2.add(bbVar.aQz.get(i));
            }
            arrayList = arrayList2;
        } else {
            arrayList = bbVar.aQz;
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            ba baVar = arrayList.get(i2);
            if (baVar != null) {
                if (baVar.Fe() || baVar.isFirst()) {
                    this.hzf.setVisibility(0);
                    this.hzf.a(true, baVar, bbVar.liveId);
                } else if (baVar.rank == 2) {
                    this.hzg.setVisibility(0);
                    this.hzg.a(true, baVar, bbVar.liveId);
                } else if (baVar.rank == 3) {
                    this.hzh.setVisibility(0);
                    this.hzh.a(true, baVar, bbVar.liveId);
                }
            }
        }
    }

    private void b(bb bbVar) {
        List<ba> list;
        if (bbVar == null) {
            this.hzo.setVisibility(8);
            this.hzp.setVisibility(8);
            this.hzq.setVisibility(8);
            return;
        }
        this.hzn.setVisibility(0);
        if (ListUtils.isEmpty(bbVar.aQz)) {
            bbVar.aQz = this.hzN;
        }
        if (ListUtils.isEmpty(bbVar.aQz)) {
            this.hzo.setVisibility(0);
            this.hzp.setVisibility(8);
            this.hzq.setVisibility(8);
            this.hzo.a(false, null, bbVar.liveId);
            return;
        }
        this.hzN = bbVar.aQz;
        this.hzo.setVisibility(8);
        this.hzp.setVisibility(8);
        this.hzq.setVisibility(8);
        if (bbVar.aQz.size() > 3) {
            list = bbVar.aQz.subList(0, 3);
        } else {
            list = bbVar.aQz;
        }
        for (int i = 0; i < list.size(); i++) {
            ba baVar = list.get(i);
            if (baVar != null) {
                if (baVar.Fe() || baVar.isFirst()) {
                    this.hzo.setVisibility(0);
                    this.hzo.a(false, baVar, bbVar.liveId);
                } else if (baVar.rank == 2) {
                    this.hzp.setVisibility(0);
                    this.hzp.a(false, baVar, bbVar.liveId);
                } else if (baVar.rank == 3) {
                    this.hzq.setVisibility(0);
                    this.hzq.a(false, baVar, bbVar.liveId);
                }
            }
        }
    }

    private void a(long j, int i, long j2, long j3) {
        if (j3 >= j2 && a(j, i, j3)) {
            bWR();
            if (this.hzJ != null) {
                v(this.hzJ.aQA, (j3 - j2) * 1000);
            }
            this.gPY = new CountDownTimer((j3 - j2) * 1000, 1000L) { // from class: com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeLiveView.1
                @Override // android.os.CountDownTimer
                public void onTick(long j4) {
                    if (AlaChallengeLiveView.this.hzJ != null) {
                        AlaChallengeLiveView.this.v(AlaChallengeLiveView.this.hzJ.aQA, j4);
                    }
                }

                @Override // android.os.CountDownTimer
                public void onFinish() {
                    if (AlaChallengeLiveView.this.hzJ != null) {
                        AlaChallengeLiveView.this.v(AlaChallengeLiveView.this.hzJ.aQA, 0L);
                    }
                }
            };
            this.gPY.start();
        }
    }

    private boolean a(long j, int i, long j2) {
        return (this.hzJ != null && this.hzJ.challengeId == j && this.hzJ.aQA == i && this.hzJ.stageEndTime == j2) ? false : true;
    }

    private void bWR() {
        if (this.gPY != null) {
            this.gPY.cancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(int i, long j) {
        if (this.hzx != null) {
            this.hzx.setCompoundDrawables(null, null, null, null);
            String formatSecondsTime = StringHelper.formatSecondsTime(Math.round(j / 1000.0d));
            String string = this.mContext.getString(a.h.ala_challenge_operate_challenge_time, formatSecondsTime);
            if (i == 2) {
                Drawable drawable = getResources().getDrawable(a.e.icon_challenge_timer_countdown);
                drawable.setBounds(0, 0, getResources().getDimensionPixelOffset(a.d.sdk_ds40), getResources().getDimensionPixelOffset(a.d.sdk_ds40));
                this.hzx.setCompoundDrawablePadding(getResources().getDimensionPixelOffset(a.d.sdk_ds8));
                this.hzx.setCompoundDrawables(drawable, null, null, null);
            } else if (i == 3) {
                formatSecondsTime = this.mContext.getString(a.h.ala_challenge_operate_publish_time, formatSecondsTime);
            } else {
                formatSecondsTime = i == 4 ? this.mContext.getString(a.h.ala_challenge_operate_over_time) : string;
            }
            this.hzx.setText(formatSecondsTime);
        }
    }

    public void setLiveContainerVisible(boolean z) {
        this.hyW.setVisibility(z ? 0 : 4);
    }

    public void setCloseBtnVisible(boolean z) {
        if (this.isHost) {
            this.hzD.setVisibility(z ? 0 : 4);
        } else {
            this.hzD.setVisibility(4);
        }
    }

    public void cgN() {
        setCloseBtnVisible(false);
        this.hzD.setText(this.mContext.getResources().getString(a.h.ala_challenge_btn_close_label));
        this.hzu.Iu();
        this.hzv.cgY();
        setLiveContainerVisible(false);
        if (this.hzM != null) {
            this.hzM.clear();
            this.hzM = null;
        }
        if (this.hzN != null) {
            this.hzN.clear();
            this.hzN = null;
        }
        this.hzJ = null;
    }

    public void bU(int i, int i2) {
        this.hzb.setVisibility(0);
        this.hzr.setVisibility(0);
        this.hzd.setVisibility(4);
        this.hzt.setVisibility(4);
        if (1 == i) {
            this.hzc.setImageResource(a.e.icon_live_vs_win);
            if (i2 >= 2) {
                this.hzd.setVisibility(0);
                this.hzd.setText(this.mContext.getResources().getString(a.h.ala_challenge_streak_win_label, Integer.valueOf(i2)));
            } else {
                this.hzd.setText("");
            }
            this.hzs.setImageResource(a.e.icon_live_vs_lose);
        } else if (3 == i) {
            this.hzc.setImageResource(a.e.icon_live_vs_draw);
            this.hzs.setImageResource(a.e.icon_live_vs_draw);
        } else if (2 == i) {
            this.hzc.setImageResource(a.e.icon_live_vs_lose);
            if (i2 >= 2) {
                this.hzt.setVisibility(0);
                this.hzt.setText(this.mContext.getResources().getString(a.h.ala_challenge_streak_win_label, Integer.valueOf(i2)));
            } else {
                this.hzt.setText("");
            }
            this.hzs.setImageResource(a.e.icon_live_vs_win);
        } else {
            cgO();
        }
    }

    public void cgO() {
        this.hzb.setVisibility(4);
        this.hzr.setVisibility(4);
    }

    public void cgP() {
        if (this.hzM != null) {
            this.hzM.clear();
            this.hzM = null;
        }
        if (this.hzN != null) {
            this.hzN.clear();
            this.hzN = null;
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

    public void cgQ() {
        this.hzz.setText(String.valueOf(this.hzF));
        this.hzA.setText(String.valueOf(this.hzG));
        if (this.hzL != null) {
            this.hzL.cancel();
        }
        this.hzL = new AnimatorSet();
        ValueAnimator cu = cu(this.hzz);
        ValueAnimator cu2 = cu(this.hzA);
        if (this.hzF != this.hzG) {
            this.hzL.setStartDelay(500L);
        } else {
            this.hzL.setStartDelay(200L);
        }
        this.hzL.playTogether(cu, cu2);
        this.hzL.start();
    }

    public void cgR() {
        this.hzz.setAlpha(0.0f);
        this.hzA.setAlpha(0.0f);
        this.hzz.setText("");
        this.hzA.setText("");
    }

    private void c(long j, long j2, boolean z) {
        int i;
        if (z || this.hzF != j || this.hzG != j2) {
            this.hzF = j;
            this.hzG = j2;
            if (z) {
                cgR();
            } else {
                this.hzz.setText(String.valueOf(this.hzF));
                this.hzA.setText(String.valueOf(this.hzG));
            }
            float f = (float) (this.hzF + this.hzG);
            int i2 = this.screenWidth;
            int i3 = i2 / 2;
            if (z && f != 0.0f) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hzB.getLayoutParams();
                layoutParams.width = i3;
                this.hzB.setLayoutParams(layoutParams);
            }
            if (this.hzF != this.hzG && f > 0.0f) {
                int i4 = (int) ((((float) this.hzF) / f) * i2);
                int i5 = !z ? ((LinearLayout.LayoutParams) this.hzB.getLayoutParams()).width : i3;
                if (i4 < this.hzH) {
                    i = this.hzH;
                } else {
                    i = i4 > i2 - this.hzH ? i2 - this.hzH : i4;
                }
                if (this.hzK != null) {
                    this.hzK.cancel();
                }
                this.hzK = ValueAnimator.ofInt(i5, i);
                if (z) {
                    this.hzK.setDuration(300L);
                    this.hzK.setStartDelay(200L);
                } else {
                    this.hzK.setDuration(100L);
                }
                this.hzK.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeLiveView.3
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) AlaChallengeLiveView.this.hzB.getLayoutParams();
                        layoutParams2.width = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                        AlaChallengeLiveView.this.hzB.setLayoutParams(layoutParams2);
                    }
                });
                this.hzK.start();
                return;
            }
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.hzB.getLayoutParams();
            layoutParams2.width = i3;
            this.hzB.setLayoutParams(layoutParams2);
        }
    }

    public void c(bg bgVar) {
        if (bgVar == null || bgVar.aQy == null) {
            this.hzj.setVisibility(4);
            return;
        }
        this.hzj.setTag(bgVar);
        this.hzk.startLoad(bgVar.aQy.portrait, 12, false, false);
        String str = bgVar.aQy.userName;
        if (TextHelper.getTextLengthWithEmoji(str) > 8) {
            str = TextHelper.subStringWithEmoji(str, 8) + StringHelper.STRING_MORE;
        }
        this.hzl.setText(str);
        this.hzm.setVisibility(8);
    }

    public void nW(boolean z) {
        if (this.hzm != null) {
            this.hzm.setVisibility(z ? 8 : 0);
        }
    }

    public View getRivalUserInfoView() {
        return this.hzj;
    }

    public void releaseResource() {
        bWR();
        if (this.hzK != null) {
            this.hzK.cancel();
        }
        if (this.hzL != null) {
            this.hzL.cancel();
        }
        cgR();
        this.hzw.setAlpha(0.0f);
        this.hzD.setText(this.mContext.getResources().getString(a.h.ala_challenge_btn_close_label));
        this.hzu.Iu();
        this.hzv.cgY();
        this.hzJ = null;
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z = true;
        if (view == this.hzD) {
            if (this.hzE != null) {
                if (com.baidu.live.af.a.SE().bwi == null || this.hzJ == null || this.hzJ.aQA != 3 || com.baidu.live.af.a.SE().bwi.aOe != 1) {
                    z = false;
                }
                if (z) {
                    if (this.hzJ != null) {
                        this.hzE.a(this.hzJ.aQF);
                        return;
                    }
                    return;
                }
                this.hzE.cgS();
            }
        } else if (view == this.hzj) {
            if (this.hzE != null) {
                if (this.hzO) {
                    this.hzE.cgT();
                } else {
                    this.hzE.d((bg) this.hzj.getTag());
                }
            }
        } else if (view == this.hzm) {
            if (this.hzE != null) {
                if (this.hzO) {
                    this.hzE.cgT();
                } else {
                    this.hzE.e((bg) this.hzj.getTag());
                }
            }
        } else if (view == this.hzi) {
            if (this.hzE != null) {
                if (this.hzO) {
                    this.hzE.cgT();
                } else {
                    this.hzE.f(this.aQx);
                }
            }
        } else if (view == this.hze) {
            this.hzE.nX(false);
        } else if (view == this.hzn) {
            this.hzE.nX(true);
        }
    }

    public void setViewClickCallBack(a aVar) {
        this.hzE = aVar;
    }
}
