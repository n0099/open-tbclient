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
    private PkRankView gRX;
    private Handler handler;
    private RelativeLayout imC;
    private RelativeLayout imD;
    private ViewFlipper imE;
    private TextView imF;
    private TextView imG;
    private TextView imH;
    private TextView imI;
    private TextView imJ;
    private TextView imK;
    private TextView imL;
    private TextView imM;
    private TextView imN;
    private TextView imO;
    private TextView imP;
    private TextView imQ;
    private TextView imR;
    private TextView imS;
    private TextView imT;
    private TextView imU;
    private TbImageView imV;
    private LinearLayout imW;
    private SeekBar imX;
    private TextView imY;
    private TextView imZ;
    PkRankMvpView ina;
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
        this.imC = (RelativeLayout) this.mView.findViewById(a.f.result_layout);
        this.imD = (RelativeLayout) this.mView.findViewById(a.f.title_layout);
        this.imF = (TextView) this.mView.findViewById(a.f.wins_title);
        this.imG = (TextView) this.mView.findViewById(a.f.score_title);
        this.imE = (ViewFlipper) this.mView.findViewById(a.f.view_flipper);
        this.imE.setInAnimation(AnimationUtils.loadAnimation(this.context, a.C0195a.pk_rank_slide_in_left));
        this.imE.setOutAnimation(AnimationUtils.loadAnimation(this.context, a.C0195a.pk_rank_slide_out_right));
        this.ina = (PkRankMvpView) this.mView.findViewById(a.f.mvp_view);
        cpW();
    }

    private void cqp() {
        View inflate = LayoutInflater.from(getContext()).inflate(a.g.sdk_rank_result_score_layout, (ViewGroup) null);
        this.imH = (TextView) inflate.findViewById(a.f.result);
        this.imI = (TextView) inflate.findViewById(a.f.result_score);
        this.imJ = (TextView) inflate.findViewById(a.f.division_name);
        this.imK = (TextView) inflate.findViewById(a.f.division_score);
        this.imL = (TextView) inflate.findViewById(a.f.kill_name);
        this.imM = (TextView) inflate.findViewById(a.f.kill_score);
        this.imN = (TextView) inflate.findViewById(a.f.glory);
        this.imO = (TextView) inflate.findViewById(a.f.glory_score);
        this.imP = (TextView) inflate.findViewById(a.f.wins);
        this.imQ = (TextView) inflate.findViewById(a.f.wins_score);
        this.imR = (TextView) inflate.findViewById(a.f.shut_down);
        this.imS = (TextView) inflate.findViewById(a.f.shut_down_score);
        this.imT = (TextView) inflate.findViewById(a.f.total_times);
        this.imU = (TextView) inflate.findViewById(a.f.total_times_score);
        this.imE.addView(inflate);
    }

    private void cqq() {
        View inflate = LayoutInflater.from(getContext()).inflate(a.g.sdk_rank_result_rank_layout, (ViewGroup) null);
        this.imV = (TbImageView) inflate.findViewById(a.f.rank_view);
        this.imW = (LinearLayout) inflate.findViewById(a.f.star_layout);
        this.imX = (SeekBar) inflate.findViewById(a.f.rank_progress);
        this.imY = (TextView) inflate.findViewById(a.f.rank_get_score);
        this.imZ = (TextView) inflate.findViewById(a.f.rank_total_score);
        this.imE.addView(inflate);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cpW() {
        this.imC.setVisibility(8);
        this.imD.setVisibility(8);
        this.imE.setVisibility(8);
        this.ina.setVisibility(8);
    }

    public void b(PkInfoData pkInfoData, int i) {
        this.gRX.cqB();
        if (this.gRX.wJ(i) && !this.isShowing) {
            h(pkInfoData);
        }
    }

    private void h(final PkInfoData pkInfoData) {
        cpW();
        this.imC.setVisibility(0);
        i(pkInfoData);
        this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.view.PkRankResultView.1
            @Override // java.lang.Runnable
            public void run() {
                PkRankResultView.this.cqr();
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
                    PkRankResultView.this.gRX.inu.wH(0);
                    PkRankResultView.this.cpW();
                }
            }, pkInfoData.showScoreTime + pkInfoData.showRankTime + pkInfoData.showMvpTime);
        } else {
            this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.view.PkRankResultView.4
                @Override // java.lang.Runnable
                public void run() {
                    PkRankResultView.this.gRX.inu.wH(0);
                    PkRankResultView.this.cpW();
                }
            }, pkInfoData.showScoreTime + pkInfoData.showRankTime);
        }
        this.isShowing = true;
    }

    private void i(PkInfoData pkInfoData) {
        this.imD.setVisibility(0);
        this.imE.setVisibility(0);
        this.imE.removeAllViews();
        cqp();
        cqq();
        l(pkInfoData);
        k(pkInfoData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cqr() {
        this.imE.showNext();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(PkInfoData pkInfoData) {
        this.imD.setVisibility(8);
        this.imE.setVisibility(8);
        this.ina.setVisibility(0);
        this.ina.f(pkInfoData);
    }

    private void k(PkInfoData pkInfoData) {
        boolean z = pkInfoData.pkResultData.rankType.equals("king");
        this.imV.startLoad(pkInfoData.pkResultData.rankImageUrl, 10, false);
        this.imW.removeAllViews();
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(BdUtilHelper.getDimens(this.context, a.d.sdk_ds16), BdUtilHelper.getDimens(this.context, a.d.sdk_ds16));
        layoutParams.rightMargin = BdUtilHelper.getDimens(this.context, a.d.sdk_ds4);
        layoutParams.gravity = 16;
        for (int i = 0; i < pkInfoData.pkResultData.currentStar; i++) {
            this.imW.addView(getSolidStarView(), layoutParams);
        }
        for (int i2 = 0; i2 < pkInfoData.pkResultData.maxStar - pkInfoData.pkResultData.currentStar; i2++) {
            this.imW.addView(getBlankStarView(), layoutParams);
        }
        if (z) {
            this.imX.setVisibility(8);
            this.imY.setVisibility(8);
            this.imZ.setVisibility(8);
            return;
        }
        this.imX.setProgress((int) (((pkInfoData.pkResultData.rankScore - pkInfoData.pkResultData.rankMinScore) / pkInfoData.pkResultData.rankMaxScore) * 100.0d));
        this.imY.setText(String.valueOf(pkInfoData.pkResultData.rankScore));
        this.imZ.setText(String.valueOf(pkInfoData.pkResultData.rankMaxScore));
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
            this.imG.setText(this.context.getString(a.h.sdk_pk_rank_this_total, String.valueOf(pkInfoData.pkResultData.totalScore)));
        } else {
            this.imG.setText(this.context.getString(a.h.sdk_pk_rank_this_total_fu, String.valueOf(pkInfoData.pkResultData.totalScore)));
        }
        if (pkInfoData.pkResultData.resultScore != 0) {
            this.imH.setVisibility(0);
            this.imI.setVisibility(0);
            switch (pkInfoData.pkResultData.resultType) {
                case 1:
                    if (pkInfoData.pkResultData.winStreakNum < 2) {
                        this.imF.setText(a.h.sdk_pk_rank_win_title);
                    } else {
                        this.imF.setText(this.context.getString(a.h.sdk_pk_rank_wins_title, String.valueOf(pkInfoData.pkResultData.winStreakNum)));
                    }
                    this.imH.setText(a.h.sdk_pk_rank_win);
                    this.imF.setTextColor(-5376);
                    break;
                case 2:
                    this.imF.setText(a.h.sdk_pk_rank_loss);
                    this.imF.setTextColor(-1513240);
                    this.imH.setText(a.h.sdk_pk_rank_loss);
                    break;
                case 3:
                    this.imH.setText(a.h.sdk_pk_rank_tied);
                    this.imF.setTextColor(-10955153);
                    this.imF.setText(a.h.sdk_pk_rank_tied);
                    break;
            }
            if (pkInfoData.pkResultData.resultScore > 0) {
                this.imI.setText(this.context.getString(a.h.sdk_pk_rank_add_score, String.valueOf(pkInfoData.pkResultData.resultScore)));
            } else {
                this.imI.setText(String.valueOf(pkInfoData.pkResultData.resultScore));
            }
        }
        if (pkInfoData.pkResultData.divisionAddScore != 0) {
            this.imJ.setVisibility(0);
            this.imK.setVisibility(0);
            if (pkInfoData.pkResultData.divisionType > 2) {
                this.imJ.setText("以弱胜强");
            } else {
                this.imJ.setText("针锋相对");
            }
            if (pkInfoData.pkResultData.divisionAddScore > 0) {
                this.imK.setText(this.context.getString(a.h.sdk_pk_rank_add_score, String.valueOf(pkInfoData.pkResultData.divisionAddScore)));
            } else {
                this.imK.setText(String.valueOf(pkInfoData.pkResultData.divisionAddScore));
            }
        }
        if (pkInfoData.pkResultData.killScore != 0 || pkInfoData.pkResultData.antiKillScore != 0) {
            this.imL.setVisibility(0);
            this.imM.setVisibility(0);
            if (pkInfoData.pkResultData.killScore > 0) {
                this.imL.setText("KO加分");
                j = pkInfoData.pkResultData.killScore;
            } else {
                j = 0;
            }
            if (pkInfoData.pkResultData.antiKillScore > 0) {
                this.imL.setText("反杀加分");
                j = pkInfoData.pkResultData.antiKillScore;
            }
            if (j > 0) {
                this.imM.setText(this.context.getString(a.h.sdk_pk_rank_add_score, String.valueOf(j)));
            } else {
                this.imM.setText(String.valueOf(j));
            }
        }
        if (pkInfoData.pkResultData.honorAddScore != 0) {
            this.imN.setVisibility(0);
            this.imO.setVisibility(0);
            this.imN.setText(this.context.getString(a.h.sdk_pk_rank_win_score, String.valueOf(pkInfoData.pkResultData.honorNum)));
            if (pkInfoData.pkResultData.honorAddScore > 0) {
                this.imO.setText(this.context.getString(a.h.sdk_pk_rank_add_score, String.valueOf(pkInfoData.pkResultData.honorAddScore)));
            } else {
                this.imO.setText(String.valueOf(pkInfoData.pkResultData.honorAddScore));
            }
        }
        if (pkInfoData.pkResultData.winStreakAddScore != 0) {
            this.imP.setVisibility(0);
            this.imQ.setVisibility(0);
            this.imP.setText(this.context.getString(a.h.sdk_pk_rank_wins, String.valueOf(pkInfoData.pkResultData.winStreakNum2)));
            if (pkInfoData.pkResultData.winStreakAddScore > 0) {
                this.imQ.setText(this.context.getString(a.h.sdk_pk_rank_add_score, String.valueOf(pkInfoData.pkResultData.winStreakAddScore)));
            } else {
                this.imQ.setText(String.valueOf(pkInfoData.pkResultData.winStreakAddScore));
            }
        }
        if (pkInfoData.pkResultData.finalWinScore != 0) {
            this.imS.setVisibility(0);
            this.imR.setVisibility(0);
            if (pkInfoData.pkResultData.finalWinScore > 0) {
                this.imS.setText(this.context.getString(a.h.sdk_pk_rank_add_score, String.valueOf(pkInfoData.pkResultData.finalWinScore)));
            } else {
                this.imS.setText(String.valueOf(pkInfoData.pkResultData.finalWinScore));
            }
        }
        if (pkInfoData.pkResultData.roundAddScore != 0) {
            this.imT.setVisibility(0);
            this.imU.setVisibility(0);
            this.imT.setText(this.context.getString(a.h.sdk_pk_rank_total_times, String.valueOf(pkInfoData.pkResultData.roundNum)));
            if (pkInfoData.pkResultData.roundAddScore > 0) {
                this.imU.setText(this.context.getString(a.h.sdk_pk_rank_add_score, String.valueOf(pkInfoData.pkResultData.roundAddScore)));
            } else {
                this.imU.setText(String.valueOf(pkInfoData.pkResultData.roundAddScore));
            }
        }
    }

    public void setPkRankView(PkRankView pkRankView) {
        this.gRX = pkRankView;
        this.ina.setPkRankView(pkRankView);
    }

    public void onDestroy() {
        if (this.gRX.getGetPkInfoModel() != null) {
            this.gRX.getGetPkInfoModel().cmm();
            this.handler.removeMessages(0);
        }
    }
}
