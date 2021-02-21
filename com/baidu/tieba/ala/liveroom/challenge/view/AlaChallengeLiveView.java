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
    private CountDownTimer gOm;
    private RelativeLayout hdW;
    private RelativeLayout hyO;
    private RelativeLayout hyP;
    private RelativeLayout hyQ;
    private RelativeLayout hyR;
    private RelativeLayout hyS;
    private RelativeLayout hyT;
    private ImageView hyU;
    private TextView hyV;
    private LinearLayout hyW;
    private ChallengeJinzhuView hyX;
    private ChallengeJinzhuView hyY;
    private ChallengeJinzhuView hyZ;
    private int hzA;
    private bg hzB;
    private ValueAnimator hzC;
    private AnimatorSet hzD;
    private List<be> hzE;
    private List<be> hzF;
    public boolean hzG;
    private RelativeLayout hza;
    private RelativeLayout hzb;
    private HeadImageView hzc;
    private TextView hzd;
    private ImageView hze;
    private LinearLayout hzf;
    private ChallengeJinzhuView hzg;
    private ChallengeJinzhuView hzh;
    private ChallengeJinzhuView hzi;
    private RelativeLayout hzj;
    private ImageView hzk;
    private TextView hzl;
    private AlaChallengeMvpTipView hzm;
    private AlaChallengeMvpDynamicAnimView hzn;
    private LinearLayout hzo;
    private TextView hzp;
    private RelativeLayout hzq;
    private TextView hzr;
    private TextView hzs;
    private View hzt;
    private View hzu;
    private TextView hzv;
    private a hzw;
    private long hzx;
    private long hzy;
    private int hzz;
    private boolean isHost;
    private Context mContext;
    private Handler mHandler;
    private RelativeLayout rootView;
    private int screenWidth;

    /* loaded from: classes11.dex */
    public interface a {
        void a(cg cgVar);

        void cec();

        void ced();

        void d(bk bkVar);

        void e(bk bkVar);

        void f(bk bkVar);

        void oe(boolean z);
    }

    public AlaChallengeLiveView(Context context) {
        super(context);
        this.isHost = false;
        this.hzx = -1L;
        this.hzy = -1L;
        this.screenWidth = -1;
        this.hzz = 0;
        this.hzA = 0;
        this.hzG = false;
        init(context);
    }

    public AlaChallengeLiveView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isHost = false;
        this.hzx = -1L;
        this.hzy = -1L;
        this.screenWidth = -1;
        this.hzz = 0;
        this.hzA = 0;
        this.hzG = false;
        init(context);
    }

    public AlaChallengeLiveView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isHost = false;
        this.hzx = -1L;
        this.hzy = -1L;
        this.screenWidth = -1;
        this.hzz = 0;
        this.hzA = 0;
        this.hzG = false;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.mHandler = new Handler(Looper.getMainLooper());
        initView(context);
        updateView();
    }

    public void setNeedCloseRecommendFloat(boolean z) {
        this.hzG = z;
        this.hyX.setNeedCloseRecommendFloat(this.hzG);
        this.hyY.setNeedCloseRecommendFloat(this.hzG);
        this.hyZ.setNeedCloseRecommendFloat(this.hzG);
        this.hzg.setNeedCloseRecommendFloat(this.hzG);
        this.hzh.setNeedCloseRecommendFloat(this.hzG);
        this.hzi.setNeedCloseRecommendFloat(this.hzG);
    }

    public void setIsHost(boolean z) {
        this.isHost = z;
    }

    private void initView(Context context) {
        this.rootView = (RelativeLayout) View.inflate(context, a.g.ala_challenge_panel_optation_view, this);
        this.hdW = (RelativeLayout) this.rootView.findViewById(a.f.root_container);
        this.hyP = (RelativeLayout) this.rootView.findViewById(a.f.anchor_live_anim_layout);
        this.hyQ = (RelativeLayout) this.rootView.findViewById(a.f.rival_live_anim_layout);
        this.hyO = (RelativeLayout) this.rootView.findViewById(a.f.pk_live_container);
        this.hyS = (RelativeLayout) this.rootView.findViewById(a.f.pk_anchor_live_layout);
        this.hyT = (RelativeLayout) this.rootView.findViewById(a.f.anchor_streak_win_layout);
        this.hyU = (ImageView) this.rootView.findViewById(a.f.anchor_user_pk_streak_img);
        this.hyV = (TextView) this.rootView.findViewById(a.f.anchor_user_pk_streak_time);
        this.hyR = (RelativeLayout) this.rootView.findViewById(a.f.jinzhu_container);
        this.hyW = (LinearLayout) this.rootView.findViewById(a.f.anchor_jinzhu_layout);
        this.hyX = (ChallengeJinzhuView) this.rootView.findViewById(a.f.anchor_jinzhu_1);
        this.hyY = (ChallengeJinzhuView) this.rootView.findViewById(a.f.anchor_jinzhu_2);
        this.hyZ = (ChallengeJinzhuView) this.rootView.findViewById(a.f.anchor_jinzhu_3);
        this.hza = (RelativeLayout) this.rootView.findViewById(a.f.pk_rival_live_layout);
        this.hzb = (RelativeLayout) this.rootView.findViewById(a.f.pk_rival_user_layout);
        this.hzc = (HeadImageView) this.rootView.findViewById(a.f.ala_live_rival_user_image);
        this.hzd = (TextView) this.rootView.findViewById(a.f.ala_live_rival_user_name);
        this.hze = (ImageView) this.rootView.findViewById(a.f.iv_rival_user_follow);
        this.hzj = (RelativeLayout) this.rootView.findViewById(a.f.rival_streak_win_layout);
        this.hzf = (LinearLayout) this.rootView.findViewById(a.f.rival_jinzhu_layout);
        this.hzg = (ChallengeJinzhuView) this.rootView.findViewById(a.f.rival_jinzhu_1);
        this.hzh = (ChallengeJinzhuView) this.rootView.findViewById(a.f.rival_jinzhu_2);
        this.hzi = (ChallengeJinzhuView) this.rootView.findViewById(a.f.rival_jinzhu_3);
        this.hzk = (ImageView) this.rootView.findViewById(a.f.rival_user_pk_streak_img);
        this.hzl = (TextView) this.rootView.findViewById(a.f.rival_user_pk_streak_time);
        this.hzo = (LinearLayout) this.rootView.findViewById(a.f.pk_time_layout);
        this.hzp = (TextView) this.rootView.findViewById(a.f.pk_time_label);
        this.hzq = (RelativeLayout) this.rootView.findViewById(a.f.pk_score_progress_layout);
        this.hzr = (TextView) this.rootView.findViewById(a.f.pk_anchor_progress);
        this.hzs = (TextView) this.rootView.findViewById(a.f.pk_rival_progress);
        this.hzv = (TextView) this.rootView.findViewById(a.f.btn_close_challenge_view);
        this.hzt = this.rootView.findViewById(a.f.anchor_progress_bg);
        this.hzu = this.rootView.findViewById(a.f.rival_progress_bg);
        this.hzm = (AlaChallengeMvpTipView) this.rootView.findViewById(a.f.id_chellenge_mvp_tip);
        this.hzn = (AlaChallengeMvpDynamicAnimView) this.rootView.findViewById(a.f.id_challenge_mvp_anim_view);
        this.hzb.setVisibility(0);
        this.hzb.setBackgroundResource(a.e.sdk_round_host_header_bg);
        this.hzc.setIsRound(true);
        this.hzc.setAutoChangeStyle(false);
        this.hzc.setDefaultBgResource(a.e.sdk_icon_default_avatar100);
        this.hzc.setIsNight(false);
        this.hzb.setOnClickListener(this);
        this.hze.setOnClickListener(this);
        this.hzv.setOnClickListener(this);
        this.hyW.setVisibility(8);
        this.hzf.setVisibility(8);
        this.hyW.setOnClickListener(this);
        this.hzf.setOnClickListener(this);
    }

    private void updateView() {
        this.hzA = h.bm(this.mContext);
        this.hzz = this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds50);
        this.screenWidth = BdUtilHelper.getScreenDimensions(this.mContext)[0];
        int bp = h.bp(this.mContext);
        int bo = h.bo(this.mContext);
        ViewGroup.LayoutParams layoutParams = this.hzq.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            layoutParams.height = h.bNP;
            ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = h.bl(this.mContext);
            this.hzq.setLayoutParams(layoutParams);
        }
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams2.topMargin = this.hzA;
        layoutParams2.height = bo;
        this.hyO.setLayoutParams(layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.hzn.getLayoutParams();
        layoutParams3.topMargin = this.hzA;
        this.hzn.setLayoutParams(layoutParams3);
        ViewGroup.LayoutParams layoutParams4 = this.hyS.getLayoutParams();
        if (layoutParams4 != null) {
            layoutParams4.width = bp;
            layoutParams4.height = bo;
            this.hyS.setLayoutParams(layoutParams4);
        }
        ViewGroup.LayoutParams layoutParams5 = this.hza.getLayoutParams();
        if (layoutParams5 != null) {
            layoutParams5.width = bp;
            layoutParams5.height = bo;
            this.hza.setLayoutParams(layoutParams5);
        }
        RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(bp, bo);
        layoutParams6.topMargin = this.hzA;
        this.hyQ.setLayoutParams(layoutParams6);
        RelativeLayout.LayoutParams layoutParams7 = (RelativeLayout.LayoutParams) this.hzo.getLayoutParams();
        layoutParams7.topMargin = this.hzA;
        layoutParams7.addRule(14);
        this.hzo.setLayoutParams(layoutParams7);
        this.hzq.setAlpha(0.0f);
        int paddingLeft = (((((bp * 2) - this.hyR.getPaddingLeft()) - this.hyR.getPaddingRight()) - ((getResources().getDimensionPixelOffset(a.d.sdk_ds56) * 3) * 2)) - (getResources().getDimensionPixelOffset(a.d.sdk_ds12) * 4)) - (getResources().getDimensionPixelOffset(a.d.sdk_ds12) * 2);
        ViewGroup.LayoutParams layoutParams8 = this.hzm.getLayoutParams();
        if (layoutParams8 instanceof ViewGroup.MarginLayoutParams) {
            layoutParams8.width = paddingLeft;
            ((ViewGroup.MarginLayoutParams) layoutParams8).bottomMargin = this.hyR.getPaddingBottom();
            this.hzm.setLayoutParams(layoutParams8);
        }
    }

    public View getAnchorAnimLiveLayout() {
        return this.hyP;
    }

    public View getRivalAnimLiveLayout() {
        return this.hyQ;
    }

    public void setAnchorUserViewBg(bk bkVar) {
    }

    public void setRivalUserViewBg(bk bkVar) {
    }

    public View getLeftTimeView() {
        return this.hzo;
    }

    public ViewGroup getLiveContainerView() {
        return this.hyO;
    }

    public View getScoreProgressLayout() {
        return this.hzq;
    }

    public View getJinzhuLayout() {
        return this.hyR;
    }

    public View getCloseBtnView() {
        return this.hzv;
    }

    public RelativeLayout getContainerView() {
        return this.hdW;
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
            cdY();
        } else if (i == 3) {
            boolean z2 = false;
            if (com.baidu.live.ae.a.Qj().buX != null && com.baidu.live.ae.a.Qj().buX.aMb == 1) {
                z2 = true;
            }
            if (z2) {
                this.hzv.setText(this.mContext.getResources().getString(a.h.ala_challenge_btn_close_label_2));
            }
            setCloseBtnVisible(z2);
            bS(bgVar.challengeResult, bgVar.aOM);
        } else {
            bTJ();
            setCloseBtnVisible(false);
            bS(bgVar.challengeResult, bgVar.aOM);
        }
        a(bkVar.aOX);
        b(bkVar2.aOX);
        this.hzB = bgVar;
    }

    private void a(bf bfVar) {
        ArrayList arrayList;
        if (bfVar == null) {
            this.hyX.setVisibility(8);
            this.hyY.setVisibility(8);
            this.hyZ.setVisibility(8);
            return;
        }
        this.hyW.setVisibility(0);
        if (ListUtils.isEmpty(bfVar.aOJ)) {
            bfVar.aOJ = this.hzE;
        }
        if (ListUtils.isEmpty(bfVar.aOJ)) {
            this.hyX.setVisibility(0);
            this.hyY.setVisibility(8);
            this.hyZ.setVisibility(8);
            this.hyX.a(true, null, bfVar.liveId);
            return;
        }
        this.hzE = bfVar.aOJ;
        this.hyX.setVisibility(8);
        this.hyY.setVisibility(8);
        this.hyZ.setVisibility(8);
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
                    this.hyX.setVisibility(0);
                    this.hyX.a(true, beVar, bfVar.liveId);
                } else if (beVar.rank == 2) {
                    this.hyY.setVisibility(0);
                    this.hyY.a(true, beVar, bfVar.liveId);
                } else if (beVar.rank == 3) {
                    this.hyZ.setVisibility(0);
                    this.hyZ.a(true, beVar, bfVar.liveId);
                }
            }
        }
    }

    private void b(bf bfVar) {
        List<be> list;
        if (bfVar == null) {
            this.hzg.setVisibility(8);
            this.hzh.setVisibility(8);
            this.hzi.setVisibility(8);
            return;
        }
        this.hzf.setVisibility(0);
        if (ListUtils.isEmpty(bfVar.aOJ)) {
            bfVar.aOJ = this.hzF;
        }
        if (ListUtils.isEmpty(bfVar.aOJ)) {
            this.hzg.setVisibility(0);
            this.hzh.setVisibility(8);
            this.hzi.setVisibility(8);
            this.hzg.a(false, null, bfVar.liveId);
            return;
        }
        this.hzF = bfVar.aOJ;
        this.hzg.setVisibility(8);
        this.hzh.setVisibility(8);
        this.hzi.setVisibility(8);
        if (bfVar.aOJ.size() > 3) {
            list = bfVar.aOJ.subList(0, 3);
        } else {
            list = bfVar.aOJ;
        }
        for (int i = 0; i < list.size(); i++) {
            be beVar = list.get(i);
            if (beVar != null) {
                if (beVar.Cw() || beVar.isFirst()) {
                    this.hzg.setVisibility(0);
                    this.hzg.a(false, beVar, bfVar.liveId);
                } else if (beVar.rank == 2) {
                    this.hzh.setVisibility(0);
                    this.hzh.a(false, beVar, bfVar.liveId);
                } else if (beVar.rank == 3) {
                    this.hzi.setVisibility(0);
                    this.hzi.a(false, beVar, bfVar.liveId);
                }
            }
        }
    }

    private void a(long j, int i, long j2, long j3) {
        if (j3 >= j2 && a(j, i, j3)) {
            bTJ();
            if (this.hzB != null) {
                w(this.hzB.aOK, (j3 - j2) * 1000);
            }
            this.gOm = new CountDownTimer((j3 - j2) * 1000, 1000L) { // from class: com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeLiveView.1
                @Override // android.os.CountDownTimer
                public void onTick(long j4) {
                    if (AlaChallengeLiveView.this.hzB != null) {
                        AlaChallengeLiveView.this.w(AlaChallengeLiveView.this.hzB.aOK, j4);
                    }
                }

                @Override // android.os.CountDownTimer
                public void onFinish() {
                    if (AlaChallengeLiveView.this.hzB != null) {
                        AlaChallengeLiveView.this.w(AlaChallengeLiveView.this.hzB.aOK, 0L);
                    }
                }
            };
            this.gOm.start();
        }
    }

    private boolean a(long j, int i, long j2) {
        return (this.hzB != null && this.hzB.challengeId == j && this.hzB.aOK == i && this.hzB.stageEndTime == j2) ? false : true;
    }

    private void bTJ() {
        if (this.gOm != null) {
            this.gOm.cancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(int i, long j) {
        if (this.hzp != null) {
            this.hzp.setCompoundDrawables(null, null, null, null);
            String formatSecondsTime = StringHelper.formatSecondsTime(Math.round(j / 1000.0d));
            String string = this.mContext.getString(a.h.ala_challenge_operate_challenge_time, formatSecondsTime);
            if (i == 2) {
                Drawable drawable = getResources().getDrawable(a.e.icon_challenge_timer_countdown);
                drawable.setBounds(0, 0, getResources().getDimensionPixelOffset(a.d.sdk_ds40), getResources().getDimensionPixelOffset(a.d.sdk_ds40));
                this.hzp.setCompoundDrawablePadding(getResources().getDimensionPixelOffset(a.d.sdk_ds8));
                this.hzp.setCompoundDrawables(drawable, null, null, null);
            } else if (i == 3) {
                formatSecondsTime = this.mContext.getString(a.h.ala_challenge_operate_publish_time, formatSecondsTime);
            } else {
                formatSecondsTime = i == 4 ? this.mContext.getString(a.h.ala_challenge_operate_over_time) : string;
            }
            this.hzp.setText(formatSecondsTime);
        }
    }

    public void setLiveContainerVisible(boolean z) {
        this.hyO.setVisibility(z ? 0 : 4);
    }

    public void setCloseBtnVisible(boolean z) {
        if (this.isHost) {
            this.hzv.setVisibility(z ? 0 : 4);
        } else {
            this.hzv.setVisibility(4);
        }
    }

    public void cdX() {
        setCloseBtnVisible(false);
        this.hzv.setText(this.mContext.getResources().getString(a.h.ala_challenge_btn_close_label));
        this.hzm.FP();
        this.hzn.cei();
        setLiveContainerVisible(false);
        if (this.hzE != null) {
            this.hzE.clear();
            this.hzE = null;
        }
        if (this.hzF != null) {
            this.hzF.clear();
            this.hzF = null;
        }
        this.hzB = null;
    }

    public void bS(int i, int i2) {
        this.hyT.setVisibility(0);
        this.hzj.setVisibility(0);
        this.hyV.setVisibility(4);
        this.hzl.setVisibility(4);
        if (1 == i) {
            this.hyU.setImageResource(a.e.icon_live_vs_win);
            if (i2 >= 2) {
                this.hyV.setVisibility(0);
                this.hyV.setText(this.mContext.getResources().getString(a.h.ala_challenge_streak_win_label, Integer.valueOf(i2)));
            } else {
                this.hyV.setText("");
            }
            this.hzk.setImageResource(a.e.icon_live_vs_lose);
        } else if (3 == i) {
            this.hyU.setImageResource(a.e.icon_live_vs_draw);
            this.hzk.setImageResource(a.e.icon_live_vs_draw);
        } else if (2 == i) {
            this.hyU.setImageResource(a.e.icon_live_vs_lose);
            if (i2 >= 2) {
                this.hzl.setVisibility(0);
                this.hzl.setText(this.mContext.getResources().getString(a.h.ala_challenge_streak_win_label, Integer.valueOf(i2)));
            } else {
                this.hzl.setText("");
            }
            this.hzk.setImageResource(a.e.icon_live_vs_win);
        } else {
            cdY();
        }
    }

    public void cdY() {
        this.hyT.setVisibility(4);
        this.hzj.setVisibility(4);
    }

    public void cdZ() {
        if (this.hzE != null) {
            this.hzE.clear();
            this.hzE = null;
        }
        if (this.hzF != null) {
            this.hzF.clear();
            this.hzF = null;
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

    public void cea() {
        this.hzr.setText(String.valueOf(this.hzx));
        this.hzs.setText(String.valueOf(this.hzy));
        if (this.hzD != null) {
            this.hzD.cancel();
        }
        this.hzD = new AnimatorSet();
        ValueAnimator cq = cq(this.hzr);
        ValueAnimator cq2 = cq(this.hzs);
        if (this.hzx != this.hzy) {
            this.hzD.setStartDelay(500L);
        } else {
            this.hzD.setStartDelay(200L);
        }
        this.hzD.playTogether(cq, cq2);
        this.hzD.start();
    }

    public void ceb() {
        this.hzr.setAlpha(0.0f);
        this.hzs.setAlpha(0.0f);
        this.hzr.setText("");
        this.hzs.setText("");
    }

    private void d(long j, long j2, boolean z) {
        int i;
        if (z || this.hzx != j || this.hzy != j2) {
            this.hzx = j;
            this.hzy = j2;
            if (z) {
                ceb();
            } else {
                this.hzr.setText(String.valueOf(this.hzx));
                this.hzs.setText(String.valueOf(this.hzy));
            }
            float f = (float) (this.hzx + this.hzy);
            int i2 = this.screenWidth;
            int i3 = i2 / 2;
            if (z && f != 0.0f) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hzt.getLayoutParams();
                layoutParams.width = i3;
                this.hzt.setLayoutParams(layoutParams);
            }
            if (this.hzx != this.hzy && f > 0.0f) {
                int i4 = (int) ((((float) this.hzx) / f) * i2);
                int i5 = !z ? ((LinearLayout.LayoutParams) this.hzt.getLayoutParams()).width : i3;
                if (i4 < this.hzz) {
                    i = this.hzz;
                } else {
                    i = i4 > i2 - this.hzz ? i2 - this.hzz : i4;
                }
                if (this.hzC != null) {
                    this.hzC.cancel();
                }
                this.hzC = ValueAnimator.ofInt(i5, i);
                if (z) {
                    this.hzC.setDuration(300L);
                    this.hzC.setStartDelay(200L);
                } else {
                    this.hzC.setDuration(100L);
                }
                this.hzC.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeLiveView.3
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) AlaChallengeLiveView.this.hzt.getLayoutParams();
                        layoutParams2.width = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                        AlaChallengeLiveView.this.hzt.setLayoutParams(layoutParams2);
                    }
                });
                this.hzC.start();
                return;
            }
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.hzt.getLayoutParams();
            layoutParams2.width = i3;
            this.hzt.setLayoutParams(layoutParams2);
        }
    }

    public void c(bk bkVar) {
        if (bkVar == null || bkVar.aOI == null) {
            this.hzb.setVisibility(4);
            return;
        }
        this.hzb.setTag(bkVar);
        this.hzc.startLoad(bkVar.aOI.portrait, 12, false, false);
        String str = bkVar.aOI.userName;
        if (TextHelper.getTextLengthWithEmoji(str) > 8) {
            str = TextHelper.subStringWithEmoji(str, 8) + StringHelper.STRING_MORE;
        }
        this.hzd.setText(str);
        this.hze.setVisibility(8);
    }

    public void od(boolean z) {
        if (this.hze != null) {
            this.hze.setVisibility(z ? 8 : 0);
        }
    }

    public View getRivalUserInfoView() {
        return this.hzb;
    }

    public void releaseResource() {
        bTJ();
        if (this.hzC != null) {
            this.hzC.cancel();
        }
        if (this.hzD != null) {
            this.hzD.cancel();
        }
        ceb();
        this.hzo.setAlpha(0.0f);
        this.hzv.setText(this.mContext.getResources().getString(a.h.ala_challenge_btn_close_label));
        this.hzm.FP();
        this.hzn.cei();
        this.hzB = null;
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z = true;
        if (view == this.hzv) {
            if (this.hzw != null) {
                if (com.baidu.live.ae.a.Qj().buX == null || this.hzB == null || this.hzB.aOK != 3 || com.baidu.live.ae.a.Qj().buX.aMb != 1) {
                    z = false;
                }
                if (z) {
                    if (this.hzB != null) {
                        this.hzw.a(this.hzB.aOP);
                        return;
                    }
                    return;
                }
                this.hzw.cec();
            }
        } else if (view == this.hzb) {
            if (this.hzw != null) {
                if (this.hzG) {
                    this.hzw.ced();
                } else {
                    this.hzw.d((bk) this.hzb.getTag());
                }
            }
        } else if (view == this.hze) {
            if (this.hzw != null) {
                if (this.hzG) {
                    this.hzw.ced();
                } else {
                    this.hzw.e((bk) this.hzb.getTag());
                }
            }
        } else if (view == this.hza) {
            if (this.hzw != null) {
                if (this.hzG) {
                    this.hzw.ced();
                } else {
                    this.hzw.f(this.aOH);
                }
            }
        } else if (view == this.hyW) {
            this.hzw.oe(false);
        } else if (view == this.hzf) {
            this.hzw.oe(true);
        }
    }

    public void setViewClickCallBack(a aVar) {
        this.hzw = aVar;
    }
}
