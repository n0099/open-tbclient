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
    private PkRankView gRJ;
    private Handler handler;
    private TextView imA;
    private TextView imB;
    private TextView imC;
    private TextView imD;
    private TextView imE;
    private TextView imF;
    private TextView imG;
    private TbImageView imH;
    private LinearLayout imI;
    private SeekBar imJ;
    private TextView imK;
    private TextView imL;
    PkRankMvpView imM;
    private RelativeLayout imo;
    private RelativeLayout imp;
    private ViewFlipper imq;
    private TextView imr;
    private TextView ims;
    private TextView imt;
    private TextView imu;
    private TextView imv;
    private TextView imw;
    private TextView imx;
    private TextView imy;
    private TextView imz;
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
        this.imo = (RelativeLayout) this.mView.findViewById(a.f.result_layout);
        this.imp = (RelativeLayout) this.mView.findViewById(a.f.title_layout);
        this.imr = (TextView) this.mView.findViewById(a.f.wins_title);
        this.ims = (TextView) this.mView.findViewById(a.f.score_title);
        this.imq = (ViewFlipper) this.mView.findViewById(a.f.view_flipper);
        this.imq.setInAnimation(AnimationUtils.loadAnimation(this.context, a.C0195a.pk_rank_slide_in_left));
        this.imq.setOutAnimation(AnimationUtils.loadAnimation(this.context, a.C0195a.pk_rank_slide_out_right));
        this.imM = (PkRankMvpView) this.mView.findViewById(a.f.mvp_view);
        cpP();
    }

    private void cqi() {
        View inflate = LayoutInflater.from(getContext()).inflate(a.g.sdk_rank_result_score_layout, (ViewGroup) null);
        this.imt = (TextView) inflate.findViewById(a.f.result);
        this.imu = (TextView) inflate.findViewById(a.f.result_score);
        this.imv = (TextView) inflate.findViewById(a.f.division_name);
        this.imw = (TextView) inflate.findViewById(a.f.division_score);
        this.imx = (TextView) inflate.findViewById(a.f.kill_name);
        this.imy = (TextView) inflate.findViewById(a.f.kill_score);
        this.imz = (TextView) inflate.findViewById(a.f.glory);
        this.imA = (TextView) inflate.findViewById(a.f.glory_score);
        this.imB = (TextView) inflate.findViewById(a.f.wins);
        this.imC = (TextView) inflate.findViewById(a.f.wins_score);
        this.imD = (TextView) inflate.findViewById(a.f.shut_down);
        this.imE = (TextView) inflate.findViewById(a.f.shut_down_score);
        this.imF = (TextView) inflate.findViewById(a.f.total_times);
        this.imG = (TextView) inflate.findViewById(a.f.total_times_score);
        this.imq.addView(inflate);
    }

    private void cqj() {
        View inflate = LayoutInflater.from(getContext()).inflate(a.g.sdk_rank_result_rank_layout, (ViewGroup) null);
        this.imH = (TbImageView) inflate.findViewById(a.f.rank_view);
        this.imI = (LinearLayout) inflate.findViewById(a.f.star_layout);
        this.imJ = (SeekBar) inflate.findViewById(a.f.rank_progress);
        this.imK = (TextView) inflate.findViewById(a.f.rank_get_score);
        this.imL = (TextView) inflate.findViewById(a.f.rank_total_score);
        this.imq.addView(inflate);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cpP() {
        this.imo.setVisibility(8);
        this.imp.setVisibility(8);
        this.imq.setVisibility(8);
        this.imM.setVisibility(8);
    }

    public void b(PkInfoData pkInfoData, int i) {
        this.gRJ.cqu();
        if (this.gRJ.wJ(i) && !this.isShowing) {
            h(pkInfoData);
        }
    }

    private void h(final PkInfoData pkInfoData) {
        cpP();
        this.imo.setVisibility(0);
        i(pkInfoData);
        this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.view.PkRankResultView.1
            @Override // java.lang.Runnable
            public void run() {
                PkRankResultView.this.cqk();
            }
        }, pkInfoData.showScoreTime);
        if (pkInfoData.mvpInfoData.userID != 0) {
            this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.view.PkRankResultView.2
                @Override // java.lang.Runnable
                public void run() {
                    PkRankResultView.this.j(pkInfoData);
                }
            }, pkInfoData.showScoreTime + pkInfoData.showRankTime);
            this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.view.PkRankResultView.3
                @Override // java.lang.Runnable
                public void run() {
                    PkRankResultView.this.gRJ.inf.wH(0);
                    PkRankResultView.this.cpP();
                }
            }, pkInfoData.showScoreTime + pkInfoData.showRankTime + pkInfoData.showMvpTime);
        } else {
            this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.view.PkRankResultView.4
                @Override // java.lang.Runnable
                public void run() {
                    PkRankResultView.this.gRJ.inf.wH(0);
                    PkRankResultView.this.cpP();
                }
            }, pkInfoData.showScoreTime + pkInfoData.showRankTime);
        }
        this.isShowing = true;
    }

    private void i(PkInfoData pkInfoData) {
        this.imp.setVisibility(0);
        this.imq.setVisibility(0);
        this.imq.removeAllViews();
        cqi();
        cqj();
        l(pkInfoData);
        k(pkInfoData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cqk() {
        this.imq.showNext();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(PkInfoData pkInfoData) {
        this.imp.setVisibility(8);
        this.imq.setVisibility(8);
        this.imM.setVisibility(0);
        this.imM.f(pkInfoData);
    }

    private void k(PkInfoData pkInfoData) {
        boolean z = pkInfoData.pkResultData.rankType.equals("king");
        this.imH.startLoad(pkInfoData.pkResultData.rankImageUrl, 10, false);
        this.imI.removeAllViews();
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(BdUtilHelper.getDimens(this.context, a.d.sdk_ds16), BdUtilHelper.getDimens(this.context, a.d.sdk_ds16));
        layoutParams.rightMargin = BdUtilHelper.getDimens(this.context, a.d.sdk_ds4);
        layoutParams.gravity = 16;
        for (int i = 0; i < pkInfoData.pkResultData.currentStar; i++) {
            this.imI.addView(getSolidStarView(), layoutParams);
        }
        for (int i2 = 0; i2 < pkInfoData.pkResultData.maxStar - pkInfoData.pkResultData.currentStar; i2++) {
            this.imI.addView(getBlankStarView(), layoutParams);
        }
        if (z) {
            this.imJ.setVisibility(8);
            this.imK.setVisibility(8);
            this.imL.setVisibility(8);
            return;
        }
        this.imJ.setProgress((int) (((pkInfoData.pkResultData.rankScore - pkInfoData.pkResultData.rankMinScore) / pkInfoData.pkResultData.rankMaxScore) * 100.0d));
        this.imK.setText(String.valueOf(pkInfoData.pkResultData.rankScore));
        this.imL.setText(String.valueOf(pkInfoData.pkResultData.rankMaxScore));
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

    private void l(PkInfoData pkInfoData) {
        long j;
        if (pkInfoData.pkResultData.totalScore > 0) {
            this.ims.setText(this.context.getString(a.h.sdk_pk_rank_this_total, String.valueOf(pkInfoData.pkResultData.totalScore)));
        } else {
            this.ims.setText(this.context.getString(a.h.sdk_pk_rank_this_total_fu, String.valueOf(pkInfoData.pkResultData.totalScore)));
        }
        if (pkInfoData.pkResultData.resultScore != 0) {
            this.imt.setVisibility(0);
            this.imu.setVisibility(0);
            switch (pkInfoData.pkResultData.resultType) {
                case 1:
                    if (pkInfoData.pkResultData.winStreakNum < 2) {
                        this.imr.setText(a.h.sdk_pk_rank_win_title);
                    } else {
                        this.imr.setText(this.context.getString(a.h.sdk_pk_rank_wins_title, String.valueOf(pkInfoData.pkResultData.winStreakNum)));
                    }
                    this.imt.setText(a.h.sdk_pk_rank_win);
                    this.imr.setTextColor(-5376);
                    break;
                case 2:
                    this.imr.setText(a.h.sdk_pk_rank_loss);
                    this.imr.setTextColor(-1513240);
                    this.imt.setText(a.h.sdk_pk_rank_loss);
                    break;
                case 3:
                    this.imt.setText(a.h.sdk_pk_rank_tied);
                    this.imr.setTextColor(-10955153);
                    this.imr.setText(a.h.sdk_pk_rank_tied);
                    break;
            }
            if (pkInfoData.pkResultData.resultScore > 0) {
                this.imu.setText(this.context.getString(a.h.sdk_pk_rank_add_score, String.valueOf(pkInfoData.pkResultData.resultScore)));
            } else {
                this.imu.setText(String.valueOf(pkInfoData.pkResultData.resultScore));
            }
        }
        if (pkInfoData.pkResultData.divisionAddScore != 0) {
            this.imv.setVisibility(0);
            this.imw.setVisibility(0);
            if (pkInfoData.pkResultData.divisionType > 2) {
                this.imv.setText("以弱胜强");
            } else {
                this.imv.setText("针锋相对");
            }
            if (pkInfoData.pkResultData.divisionAddScore > 0) {
                this.imw.setText(this.context.getString(a.h.sdk_pk_rank_add_score, String.valueOf(pkInfoData.pkResultData.divisionAddScore)));
            } else {
                this.imw.setText(String.valueOf(pkInfoData.pkResultData.divisionAddScore));
            }
        }
        if (pkInfoData.pkResultData.killScore != 0 || pkInfoData.pkResultData.antiKillScore != 0) {
            this.imx.setVisibility(0);
            this.imy.setVisibility(0);
            if (pkInfoData.pkResultData.killScore > 0) {
                this.imx.setText("KO加分");
                j = pkInfoData.pkResultData.killScore;
            } else {
                j = 0;
            }
            if (pkInfoData.pkResultData.antiKillScore > 0) {
                this.imx.setText("反杀加分");
                j = pkInfoData.pkResultData.antiKillScore;
            }
            if (j > 0) {
                this.imy.setText(this.context.getString(a.h.sdk_pk_rank_add_score, String.valueOf(j)));
            } else {
                this.imy.setText(String.valueOf(j));
            }
        }
        if (pkInfoData.pkResultData.honorAddScore != 0) {
            this.imz.setVisibility(0);
            this.imA.setVisibility(0);
            this.imz.setText(this.context.getString(a.h.sdk_pk_rank_win_score, String.valueOf(pkInfoData.pkResultData.honorNum)));
            if (pkInfoData.pkResultData.honorAddScore > 0) {
                this.imA.setText(this.context.getString(a.h.sdk_pk_rank_add_score, String.valueOf(pkInfoData.pkResultData.honorAddScore)));
            } else {
                this.imA.setText(String.valueOf(pkInfoData.pkResultData.honorAddScore));
            }
        }
        if (pkInfoData.pkResultData.winStreakAddScore != 0) {
            this.imB.setVisibility(0);
            this.imC.setVisibility(0);
            this.imB.setText(this.context.getString(a.h.sdk_pk_rank_wins, String.valueOf(pkInfoData.pkResultData.winStreakNum2)));
            if (pkInfoData.pkResultData.winStreakAddScore > 0) {
                this.imC.setText(this.context.getString(a.h.sdk_pk_rank_add_score, String.valueOf(pkInfoData.pkResultData.winStreakAddScore)));
            } else {
                this.imC.setText(String.valueOf(pkInfoData.pkResultData.winStreakAddScore));
            }
        }
        if (pkInfoData.pkResultData.finalWinScore != 0) {
            this.imE.setVisibility(0);
            this.imD.setVisibility(0);
            if (pkInfoData.pkResultData.finalWinScore > 0) {
                this.imE.setText(this.context.getString(a.h.sdk_pk_rank_add_score, String.valueOf(pkInfoData.pkResultData.finalWinScore)));
            } else {
                this.imE.setText(String.valueOf(pkInfoData.pkResultData.finalWinScore));
            }
        }
        if (pkInfoData.pkResultData.roundAddScore != 0) {
            this.imF.setVisibility(0);
            this.imG.setVisibility(0);
            this.imF.setText(this.context.getString(a.h.sdk_pk_rank_total_times, String.valueOf(pkInfoData.pkResultData.roundNum)));
            if (pkInfoData.pkResultData.roundAddScore > 0) {
                this.imG.setText(this.context.getString(a.h.sdk_pk_rank_add_score, String.valueOf(pkInfoData.pkResultData.roundAddScore)));
            } else {
                this.imG.setText(String.valueOf(pkInfoData.pkResultData.roundAddScore));
            }
        }
    }

    public void setPkRankView(PkRankView pkRankView) {
        this.gRJ = pkRankView;
        this.imM.setPkRankView(pkRankView);
    }

    public void onDestroy() {
        if (this.gRJ.getGetPkInfoModel() != null) {
            this.gRJ.getGetPkInfoModel().cmf();
            this.handler.removeMessages(0);
        }
    }
}
