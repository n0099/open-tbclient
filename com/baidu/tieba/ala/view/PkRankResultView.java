package com.baidu.tieba.ala.view;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.ViewFlipper;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.tieba.ala.data.PkInfoData;
/* loaded from: classes11.dex */
public class PkRankResultView extends RelativeLayout {
    Context context;
    private PkRankView gTH;
    private Handler handler;
    private RelativeLayout ilA;
    private ViewFlipper ilB;
    private TextView ilC;
    private TextView ilD;
    private TextView ilE;
    private TextView ilF;
    private TextView ilG;
    private TextView ilH;
    private TextView ilI;
    private TextView ilJ;
    private TextView ilK;
    private TextView ilL;
    private TextView ilM;
    private TextView ilN;
    private TbImageView ilO;
    private LinearLayout ilP;
    private SeekBar ilQ;
    private TextView ilR;
    private TextView ilS;
    PkRankMvpView ilT;
    private RelativeLayout ilz;
    boolean isShowing;
    private View mView;

    public PkRankResultView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PkRankResultView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.handler = new Handler();
        this.isShowing = false;
        this.context = context;
        initView();
    }

    private void initView() {
        this.mView = LayoutInflater.from(getContext()).inflate(a.g.sdk_rank_result_layout, (ViewGroup) this, true);
        this.ilz = (RelativeLayout) this.mView.findViewById(a.f.result_layout);
        this.ilA = (RelativeLayout) this.mView.findViewById(a.f.title_layout);
        this.ilC = (TextView) this.mView.findViewById(a.f.wins_title);
        this.ilD = (TextView) this.mView.findViewById(a.f.score_title);
        this.ilB = (ViewFlipper) this.mView.findViewById(a.f.view_flipper);
        this.ilB.setInAnimation(AnimationUtils.loadAnimation(this.context, a.C0203a.pk_rank_slide_in_left));
        this.ilB.setOutAnimation(AnimationUtils.loadAnimation(this.context, a.C0203a.pk_rank_slide_out_right));
        this.ilT = (PkRankMvpView) this.mView.findViewById(a.f.mvp_view);
        csB();
    }

    private void csS() {
        View inflate = LayoutInflater.from(getContext()).inflate(a.g.sdk_rank_result_score_layout, (ViewGroup) null);
        this.ilE = (TextView) inflate.findViewById(a.f.result);
        this.ilF = (TextView) inflate.findViewById(a.f.result_score);
        this.ilG = (TextView) inflate.findViewById(a.f.glory);
        this.ilH = (TextView) inflate.findViewById(a.f.glory_score);
        this.ilI = (TextView) inflate.findViewById(a.f.wins);
        this.ilJ = (TextView) inflate.findViewById(a.f.wins_score);
        this.ilK = (TextView) inflate.findViewById(a.f.shut_down);
        this.ilL = (TextView) inflate.findViewById(a.f.shut_down_score);
        this.ilM = (TextView) inflate.findViewById(a.f.total_times);
        this.ilN = (TextView) inflate.findViewById(a.f.total_times_score);
        this.ilB.addView(inflate);
    }

    private void csT() {
        View inflate = LayoutInflater.from(getContext()).inflate(a.g.sdk_rank_result_rank_layout, (ViewGroup) null);
        this.ilO = (TbImageView) inflate.findViewById(a.f.rank_view);
        this.ilP = (LinearLayout) inflate.findViewById(a.f.star_layout);
        this.ilQ = (SeekBar) inflate.findViewById(a.f.rank_progress);
        this.ilR = (TextView) inflate.findViewById(a.f.rank_get_score);
        this.ilS = (TextView) inflate.findViewById(a.f.rank_total_score);
        this.ilB.addView(inflate);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void csB() {
        this.ilz.setVisibility(8);
        this.ilA.setVisibility(8);
        this.ilB.setVisibility(8);
        this.ilT.setVisibility(8);
    }

    public void b(PkInfoData pkInfoData, int i) {
        this.gTH.cte();
        if (this.gTH.ye(i) && !this.isShowing) {
            g(pkInfoData);
        }
    }

    private void g(final PkInfoData pkInfoData) {
        csB();
        this.ilz.setVisibility(0);
        h(pkInfoData);
        this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.view.PkRankResultView.1
            @Override // java.lang.Runnable
            public void run() {
                PkRankResultView.this.csU();
            }
        }, pkInfoData.showScoreTime);
        if (pkInfoData.mvpInfoData.userID != 0) {
            this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.view.PkRankResultView.2
                @Override // java.lang.Runnable
                public void run() {
                    PkRankResultView.this.i(pkInfoData);
                }
            }, pkInfoData.showScoreTime + pkInfoData.showRankTime);
            this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.view.PkRankResultView.3
                @Override // java.lang.Runnable
                public void run() {
                    PkRankResultView.this.gTH.imk.yc(0);
                    PkRankResultView.this.csB();
                }
            }, pkInfoData.showScoreTime + pkInfoData.showRankTime + pkInfoData.showMvpTime);
        } else {
            this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.view.PkRankResultView.4
                @Override // java.lang.Runnable
                public void run() {
                    PkRankResultView.this.gTH.imk.yc(0);
                    PkRankResultView.this.csB();
                }
            }, pkInfoData.showScoreTime + pkInfoData.showRankTime);
        }
        this.isShowing = true;
    }

    private void h(PkInfoData pkInfoData) {
        this.ilA.setVisibility(0);
        this.ilB.setVisibility(0);
        this.ilB.removeAllViews();
        csS();
        csT();
        k(pkInfoData);
        j(pkInfoData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void csU() {
        this.ilB.showNext();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(PkInfoData pkInfoData) {
        this.ilA.setVisibility(8);
        this.ilB.setVisibility(8);
        this.ilT.setVisibility(0);
        this.ilT.e(pkInfoData);
    }

    private void j(PkInfoData pkInfoData) {
        boolean z = pkInfoData.pkResultData.rankType.equals("king");
        this.ilO.startLoad(pkInfoData.pkResultData.rankImageUrl, 10, false);
        this.ilP.removeAllViews();
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(BdUtilHelper.getDimens(this.context, a.d.sdk_ds16), BdUtilHelper.getDimens(this.context, a.d.sdk_ds16));
        layoutParams.rightMargin = BdUtilHelper.getDimens(this.context, a.d.sdk_ds4);
        layoutParams.gravity = 16;
        for (int i = 0; i < pkInfoData.pkResultData.currentStar; i++) {
            this.ilP.addView(getSolidStarView(), layoutParams);
        }
        for (int i2 = 0; i2 < pkInfoData.pkResultData.maxStar - pkInfoData.pkResultData.currentStar; i2++) {
            this.ilP.addView(getBlankStarView(), layoutParams);
        }
        if (z) {
            this.ilQ.setVisibility(8);
            this.ilR.setVisibility(8);
            this.ilS.setVisibility(8);
            return;
        }
        this.ilQ.setProgress((int) (((pkInfoData.pkResultData.rankScore - pkInfoData.pkResultData.rankMinScore) / pkInfoData.pkResultData.rankMaxScore) * 100.0d));
        this.ilR.setText(String.valueOf(pkInfoData.pkResultData.rankScore));
        this.ilS.setText(String.valueOf(pkInfoData.pkResultData.rankMaxScore));
    }

    private View getSolidStarView() {
        ImageView imageView = new ImageView(this.context);
        imageView.setImageResource(a.e.ala_icon_five_pointed_star);
        return imageView;
    }

    private View getBlankStarView() {
        ImageView imageView = new ImageView(this.context);
        imageView.setImageResource(a.e.ala_icon_blank_five_pointed_star);
        return imageView;
    }

    private void k(PkInfoData pkInfoData) {
        if (pkInfoData.pkResultData.totalScore > 0) {
            this.ilD.setText(this.context.getString(a.h.sdk_pk_rank_this_total, String.valueOf(pkInfoData.pkResultData.totalScore)));
        } else {
            this.ilD.setText(this.context.getString(a.h.sdk_pk_rank_this_total_fu, String.valueOf(pkInfoData.pkResultData.totalScore)));
        }
        if (pkInfoData.pkResultData.resultScore != 0) {
            this.ilE.setVisibility(0);
            this.ilF.setVisibility(0);
            switch (pkInfoData.pkResultData.resultType) {
                case 1:
                    if (pkInfoData.pkResultData.winStreakNum < 2) {
                        this.ilC.setText(a.h.sdk_pk_rank_win_title);
                    } else {
                        this.ilC.setText(this.context.getString(a.h.sdk_pk_rank_wins_title, String.valueOf(pkInfoData.pkResultData.winStreakNum)));
                    }
                    this.ilE.setText(a.h.sdk_pk_rank_win);
                    this.ilC.setTextColor(-5376);
                    break;
                case 2:
                    this.ilC.setText(a.h.sdk_pk_rank_loss);
                    this.ilC.setTextColor(-1513240);
                    this.ilE.setText(a.h.sdk_pk_rank_loss);
                    break;
                case 3:
                    this.ilE.setText(a.h.sdk_pk_rank_tied);
                    this.ilC.setTextColor(-10955153);
                    this.ilC.setText(a.h.sdk_pk_rank_tied);
                    break;
            }
            if (pkInfoData.pkResultData.resultScore > 0) {
                this.ilF.setText(this.context.getString(a.h.sdk_pk_rank_add_score, String.valueOf(pkInfoData.pkResultData.resultScore)));
            } else {
                this.ilF.setText(String.valueOf(pkInfoData.pkResultData.resultScore));
            }
        }
        if (pkInfoData.pkResultData.honorAddScore != 0) {
            this.ilG.setVisibility(0);
            this.ilH.setVisibility(0);
            this.ilG.setText(this.context.getString(a.h.sdk_pk_rank_win_score, String.valueOf(pkInfoData.pkResultData.honorNum)));
            if (pkInfoData.pkResultData.honorAddScore > 0) {
                this.ilH.setText(this.context.getString(a.h.sdk_pk_rank_add_score, String.valueOf(pkInfoData.pkResultData.honorAddScore)));
            } else {
                this.ilH.setText(String.valueOf(pkInfoData.pkResultData.honorAddScore));
            }
        }
        if (pkInfoData.pkResultData.winStreakAddScore != 0) {
            this.ilI.setVisibility(0);
            this.ilJ.setVisibility(0);
            this.ilI.setText(this.context.getString(a.h.sdk_pk_rank_wins, String.valueOf(pkInfoData.pkResultData.winStreakNum2)));
            if (pkInfoData.pkResultData.winStreakAddScore > 0) {
                this.ilJ.setText(this.context.getString(a.h.sdk_pk_rank_add_score, String.valueOf(pkInfoData.pkResultData.winStreakAddScore)));
            } else {
                this.ilJ.setText(String.valueOf(pkInfoData.pkResultData.winStreakAddScore));
            }
        }
        if (pkInfoData.pkResultData.finalWinScore != 0) {
            this.ilL.setVisibility(0);
            this.ilK.setVisibility(0);
            if (pkInfoData.pkResultData.finalWinScore > 0) {
                this.ilL.setText(this.context.getString(a.h.sdk_pk_rank_add_score, String.valueOf(pkInfoData.pkResultData.finalWinScore)));
            } else {
                this.ilL.setText(String.valueOf(pkInfoData.pkResultData.finalWinScore));
            }
        }
        if (pkInfoData.pkResultData.roundAddScore != 0) {
            this.ilM.setVisibility(0);
            this.ilN.setVisibility(0);
            this.ilM.setText(this.context.getString(a.h.sdk_pk_rank_total_times, String.valueOf(pkInfoData.pkResultData.roundNum)));
            if (pkInfoData.pkResultData.roundAddScore > 0) {
                this.ilN.setText(this.context.getString(a.h.sdk_pk_rank_add_score, String.valueOf(pkInfoData.pkResultData.roundAddScore)));
            } else {
                this.ilN.setText(String.valueOf(pkInfoData.pkResultData.roundAddScore));
            }
        }
    }

    public void setPkRankView(PkRankView pkRankView) {
        this.gTH = pkRankView;
        this.ilT.setPkRankView(pkRankView);
    }

    public void onDestroy() {
        if (this.gTH.getGetPkInfoModel() != null) {
            this.gTH.getGetPkInfoModel().coY();
            this.handler.removeMessages(0);
        }
    }
}
