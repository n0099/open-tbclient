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
/* loaded from: classes4.dex */
public class PkRankResultView extends RelativeLayout {
    Context context;
    private PkRankView gzq;
    private TextView hOA;
    private TextView hOB;
    private TextView hOC;
    private TextView hOD;
    private TextView hOE;
    private TextView hOF;
    private TextView hOG;
    private TextView hOH;
    private TextView hOI;
    private TextView hOJ;
    private TextView hOK;
    private TextView hOL;
    private TbImageView hOM;
    private LinearLayout hON;
    private SeekBar hOO;
    private TextView hOP;
    private TextView hOQ;
    PkRankMvpView hOR;
    private RelativeLayout hOx;
    private RelativeLayout hOy;
    private ViewFlipper hOz;
    private Handler handler;
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
        this.hOx = (RelativeLayout) this.mView.findViewById(a.f.result_layout);
        this.hOy = (RelativeLayout) this.mView.findViewById(a.f.title_layout);
        this.hOA = (TextView) this.mView.findViewById(a.f.wins_title);
        this.hOB = (TextView) this.mView.findViewById(a.f.score_title);
        this.hOz = (ViewFlipper) this.mView.findViewById(a.f.view_flipper);
        this.hOz.setInAnimation(AnimationUtils.loadAnimation(this.context, a.C0197a.pk_rank_slide_in_left));
        this.hOz.setOutAnimation(AnimationUtils.loadAnimation(this.context, a.C0197a.pk_rank_slide_out_right));
        this.hOR = (PkRankMvpView) this.mView.findViewById(a.f.mvp_view);
        clZ();
    }

    private void cmq() {
        View inflate = LayoutInflater.from(getContext()).inflate(a.g.sdk_rank_result_score_layout, (ViewGroup) null);
        this.hOC = (TextView) inflate.findViewById(a.f.result);
        this.hOD = (TextView) inflate.findViewById(a.f.result_score);
        this.hOE = (TextView) inflate.findViewById(a.f.glory);
        this.hOF = (TextView) inflate.findViewById(a.f.glory_score);
        this.hOG = (TextView) inflate.findViewById(a.f.wins);
        this.hOH = (TextView) inflate.findViewById(a.f.wins_score);
        this.hOI = (TextView) inflate.findViewById(a.f.shut_down);
        this.hOJ = (TextView) inflate.findViewById(a.f.shut_down_score);
        this.hOK = (TextView) inflate.findViewById(a.f.total_times);
        this.hOL = (TextView) inflate.findViewById(a.f.total_times_score);
        this.hOz.addView(inflate);
    }

    private void cmr() {
        View inflate = LayoutInflater.from(getContext()).inflate(a.g.sdk_rank_result_rank_layout, (ViewGroup) null);
        this.hOM = (TbImageView) inflate.findViewById(a.f.rank_view);
        this.hON = (LinearLayout) inflate.findViewById(a.f.star_layout);
        this.hOO = (SeekBar) inflate.findViewById(a.f.rank_progress);
        this.hOP = (TextView) inflate.findViewById(a.f.rank_get_score);
        this.hOQ = (TextView) inflate.findViewById(a.f.rank_total_score);
        this.hOz.addView(inflate);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clZ() {
        this.hOx.setVisibility(8);
        this.hOy.setVisibility(8);
        this.hOz.setVisibility(8);
        this.hOR.setVisibility(8);
    }

    public void b(PkInfoData pkInfoData, int i) {
        this.gzq.cmE();
        if (this.gzq.wN(i) && !this.isShowing) {
            g(pkInfoData);
        }
    }

    private void g(final PkInfoData pkInfoData) {
        clZ();
        this.hOx.setVisibility(0);
        h(pkInfoData);
        this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.view.PkRankResultView.1
            @Override // java.lang.Runnable
            public void run() {
                PkRankResultView.this.cms();
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
                    PkRankResultView.this.gzq.hPk.wL(0);
                    PkRankResultView.this.clZ();
                }
            }, pkInfoData.showScoreTime + pkInfoData.showRankTime + pkInfoData.showMvpTime);
        } else {
            this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.view.PkRankResultView.4
                @Override // java.lang.Runnable
                public void run() {
                    PkRankResultView.this.gzq.hPk.wL(0);
                    PkRankResultView.this.clZ();
                }
            }, pkInfoData.showScoreTime + pkInfoData.showRankTime);
        }
        this.isShowing = true;
    }

    private void h(PkInfoData pkInfoData) {
        this.hOy.setVisibility(0);
        this.hOz.setVisibility(0);
        this.hOz.removeAllViews();
        cmq();
        cmr();
        k(pkInfoData);
        j(pkInfoData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cms() {
        this.hOz.showNext();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(PkInfoData pkInfoData) {
        this.hOy.setVisibility(8);
        this.hOz.setVisibility(8);
        this.hOR.setVisibility(0);
        this.hOR.e(pkInfoData);
    }

    private void j(PkInfoData pkInfoData) {
        boolean z = pkInfoData.pkResultData.rankType.equals("king");
        this.hOM.startLoad(pkInfoData.pkResultData.rankImageUrl, 10, false);
        this.hON.removeAllViews();
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(BdUtilHelper.getDimens(this.context, a.d.sdk_ds16), BdUtilHelper.getDimens(this.context, a.d.sdk_ds16));
        layoutParams.rightMargin = BdUtilHelper.getDimens(this.context, a.d.sdk_ds4);
        layoutParams.gravity = 16;
        for (int i = 0; i < pkInfoData.pkResultData.currentStar; i++) {
            this.hON.addView(getSolidStarView(), layoutParams);
        }
        for (int i2 = 0; i2 < pkInfoData.pkResultData.maxStar - pkInfoData.pkResultData.currentStar; i2++) {
            this.hON.addView(getBlankStarView(), layoutParams);
        }
        if (z) {
            this.hOO.setVisibility(8);
            this.hOP.setVisibility(8);
            this.hOQ.setVisibility(8);
            return;
        }
        this.hOO.setProgress((int) (((pkInfoData.pkResultData.rankScore - pkInfoData.pkResultData.rankMinScore) / pkInfoData.pkResultData.rankMaxScore) * 100.0d));
        this.hOP.setText(String.valueOf(pkInfoData.pkResultData.rankScore));
        this.hOQ.setText(String.valueOf(pkInfoData.pkResultData.rankMaxScore));
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
            this.hOB.setText(this.context.getString(a.h.sdk_pk_rank_this_total, String.valueOf(pkInfoData.pkResultData.totalScore)));
        } else {
            this.hOB.setText(this.context.getString(a.h.sdk_pk_rank_this_total_fu, String.valueOf(pkInfoData.pkResultData.totalScore)));
        }
        if (pkInfoData.pkResultData.resultScore != 0) {
            this.hOC.setVisibility(0);
            this.hOD.setVisibility(0);
            switch (pkInfoData.pkResultData.resultType) {
                case 1:
                    if (pkInfoData.pkResultData.winStreakNum < 2) {
                        this.hOA.setText(a.h.sdk_pk_rank_win_title);
                    } else {
                        this.hOA.setText(this.context.getString(a.h.sdk_pk_rank_wins_title, String.valueOf(pkInfoData.pkResultData.winStreakNum)));
                    }
                    this.hOC.setText(a.h.sdk_pk_rank_win);
                    this.hOA.setTextColor(-5376);
                    break;
                case 2:
                    this.hOA.setText(a.h.sdk_pk_rank_loss);
                    this.hOA.setTextColor(-1513240);
                    this.hOC.setText(a.h.sdk_pk_rank_loss);
                    break;
                case 3:
                    this.hOC.setText(a.h.sdk_pk_rank_tied);
                    this.hOA.setTextColor(-10955153);
                    this.hOA.setText(a.h.sdk_pk_rank_tied);
                    break;
            }
            if (pkInfoData.pkResultData.resultScore > 0) {
                this.hOD.setText(this.context.getString(a.h.sdk_pk_rank_add_score, String.valueOf(pkInfoData.pkResultData.resultScore)));
            } else {
                this.hOD.setText(String.valueOf(pkInfoData.pkResultData.resultScore));
            }
        }
        if (pkInfoData.pkResultData.honorAddScore != 0) {
            this.hOE.setVisibility(0);
            this.hOF.setVisibility(0);
            this.hOE.setText(this.context.getString(a.h.sdk_pk_rank_win_score, String.valueOf(pkInfoData.pkResultData.honorNum)));
            if (pkInfoData.pkResultData.honorAddScore > 0) {
                this.hOF.setText(this.context.getString(a.h.sdk_pk_rank_add_score, String.valueOf(pkInfoData.pkResultData.honorAddScore)));
            } else {
                this.hOF.setText(String.valueOf(pkInfoData.pkResultData.honorAddScore));
            }
        }
        if (pkInfoData.pkResultData.winStreakAddScore != 0) {
            this.hOG.setVisibility(0);
            this.hOH.setVisibility(0);
            this.hOG.setText(this.context.getString(a.h.sdk_pk_rank_wins, String.valueOf(pkInfoData.pkResultData.winStreakNum2)));
            if (pkInfoData.pkResultData.winStreakAddScore > 0) {
                this.hOH.setText(this.context.getString(a.h.sdk_pk_rank_add_score, String.valueOf(pkInfoData.pkResultData.winStreakAddScore)));
            } else {
                this.hOH.setText(String.valueOf(pkInfoData.pkResultData.winStreakAddScore));
            }
        }
        if (pkInfoData.pkResultData.finalWinScore != 0) {
            this.hOJ.setVisibility(0);
            this.hOI.setVisibility(0);
            if (pkInfoData.pkResultData.finalWinScore > 0) {
                this.hOJ.setText(this.context.getString(a.h.sdk_pk_rank_add_score, String.valueOf(pkInfoData.pkResultData.finalWinScore)));
            } else {
                this.hOJ.setText(String.valueOf(pkInfoData.pkResultData.finalWinScore));
            }
        }
        if (pkInfoData.pkResultData.roundAddScore != 0) {
            this.hOK.setVisibility(0);
            this.hOL.setVisibility(0);
            this.hOK.setText(this.context.getString(a.h.sdk_pk_rank_total_times, String.valueOf(pkInfoData.pkResultData.roundNum)));
            if (pkInfoData.pkResultData.roundAddScore > 0) {
                this.hOL.setText(this.context.getString(a.h.sdk_pk_rank_add_score, String.valueOf(pkInfoData.pkResultData.roundAddScore)));
            } else {
                this.hOL.setText(String.valueOf(pkInfoData.pkResultData.roundAddScore));
            }
        }
    }

    public void setPkRankView(PkRankView pkRankView) {
        this.gzq = pkRankView;
        this.hOR.setPkRankView(pkRankView);
    }

    public void onDestroy() {
        if (this.gzq.getGetPkInfoModel() != null) {
            this.gzq.getGetPkInfoModel().ciT();
            this.handler.removeMessages(0);
        }
    }
}
