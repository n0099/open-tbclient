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
/* loaded from: classes10.dex */
public class PkRankResultView extends RelativeLayout {
    Context context;
    private PkRankView gPb;
    private Handler handler;
    private RelativeLayout igS;
    private RelativeLayout igT;
    private ViewFlipper igU;
    private TextView igV;
    private TextView igW;
    private TextView igX;
    private TextView igY;
    private TextView igZ;
    private TextView iha;
    private TextView ihb;
    private TextView ihc;
    private TextView ihd;
    private TextView ihe;
    private TextView ihf;
    private TextView ihg;
    private TbImageView ihh;
    private LinearLayout ihi;
    private SeekBar ihj;
    private TextView ihk;
    private TextView ihl;
    PkRankMvpView ihm;
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
        this.igS = (RelativeLayout) this.mView.findViewById(a.f.result_layout);
        this.igT = (RelativeLayout) this.mView.findViewById(a.f.title_layout);
        this.igV = (TextView) this.mView.findViewById(a.f.wins_title);
        this.igW = (TextView) this.mView.findViewById(a.f.score_title);
        this.igU = (ViewFlipper) this.mView.findViewById(a.f.view_flipper);
        this.igU.setInAnimation(AnimationUtils.loadAnimation(this.context, a.C0194a.pk_rank_slide_in_left));
        this.igU.setOutAnimation(AnimationUtils.loadAnimation(this.context, a.C0194a.pk_rank_slide_out_right));
        this.ihm = (PkRankMvpView) this.mView.findViewById(a.f.mvp_view);
        coK();
    }

    private void cpb() {
        View inflate = LayoutInflater.from(getContext()).inflate(a.g.sdk_rank_result_score_layout, (ViewGroup) null);
        this.igX = (TextView) inflate.findViewById(a.f.result);
        this.igY = (TextView) inflate.findViewById(a.f.result_score);
        this.igZ = (TextView) inflate.findViewById(a.f.glory);
        this.iha = (TextView) inflate.findViewById(a.f.glory_score);
        this.ihb = (TextView) inflate.findViewById(a.f.wins);
        this.ihc = (TextView) inflate.findViewById(a.f.wins_score);
        this.ihd = (TextView) inflate.findViewById(a.f.shut_down);
        this.ihe = (TextView) inflate.findViewById(a.f.shut_down_score);
        this.ihf = (TextView) inflate.findViewById(a.f.total_times);
        this.ihg = (TextView) inflate.findViewById(a.f.total_times_score);
        this.igU.addView(inflate);
    }

    private void cpc() {
        View inflate = LayoutInflater.from(getContext()).inflate(a.g.sdk_rank_result_rank_layout, (ViewGroup) null);
        this.ihh = (TbImageView) inflate.findViewById(a.f.rank_view);
        this.ihi = (LinearLayout) inflate.findViewById(a.f.star_layout);
        this.ihj = (SeekBar) inflate.findViewById(a.f.rank_progress);
        this.ihk = (TextView) inflate.findViewById(a.f.rank_get_score);
        this.ihl = (TextView) inflate.findViewById(a.f.rank_total_score);
        this.igU.addView(inflate);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void coK() {
        this.igS.setVisibility(8);
        this.igT.setVisibility(8);
        this.igU.setVisibility(8);
        this.ihm.setVisibility(8);
    }

    public void b(PkInfoData pkInfoData, int i) {
        this.gPb.cpn();
        if (this.gPb.wy(i) && !this.isShowing) {
            g(pkInfoData);
        }
    }

    private void g(final PkInfoData pkInfoData) {
        coK();
        this.igS.setVisibility(0);
        h(pkInfoData);
        this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.view.PkRankResultView.1
            @Override // java.lang.Runnable
            public void run() {
                PkRankResultView.this.cpd();
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
                    PkRankResultView.this.gPb.ihC.ww(0);
                    PkRankResultView.this.coK();
                }
            }, pkInfoData.showScoreTime + pkInfoData.showRankTime + pkInfoData.showMvpTime);
        } else {
            this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.view.PkRankResultView.4
                @Override // java.lang.Runnable
                public void run() {
                    PkRankResultView.this.gPb.ihC.ww(0);
                    PkRankResultView.this.coK();
                }
            }, pkInfoData.showScoreTime + pkInfoData.showRankTime);
        }
        this.isShowing = true;
    }

    private void h(PkInfoData pkInfoData) {
        this.igT.setVisibility(0);
        this.igU.setVisibility(0);
        this.igU.removeAllViews();
        cpb();
        cpc();
        k(pkInfoData);
        j(pkInfoData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cpd() {
        this.igU.showNext();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(PkInfoData pkInfoData) {
        this.igT.setVisibility(8);
        this.igU.setVisibility(8);
        this.ihm.setVisibility(0);
        this.ihm.e(pkInfoData);
    }

    private void j(PkInfoData pkInfoData) {
        boolean z = pkInfoData.pkResultData.rankType.equals("king");
        this.ihh.startLoad(pkInfoData.pkResultData.rankImageUrl, 10, false);
        this.ihi.removeAllViews();
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(BdUtilHelper.getDimens(this.context, a.d.sdk_ds16), BdUtilHelper.getDimens(this.context, a.d.sdk_ds16));
        layoutParams.rightMargin = BdUtilHelper.getDimens(this.context, a.d.sdk_ds4);
        layoutParams.gravity = 16;
        for (int i = 0; i < pkInfoData.pkResultData.currentStar; i++) {
            this.ihi.addView(getSolidStarView(), layoutParams);
        }
        for (int i2 = 0; i2 < pkInfoData.pkResultData.maxStar - pkInfoData.pkResultData.currentStar; i2++) {
            this.ihi.addView(getBlankStarView(), layoutParams);
        }
        if (z) {
            this.ihj.setVisibility(8);
            this.ihk.setVisibility(8);
            this.ihl.setVisibility(8);
            return;
        }
        this.ihj.setProgress((int) (((pkInfoData.pkResultData.rankScore - pkInfoData.pkResultData.rankMinScore) / pkInfoData.pkResultData.rankMaxScore) * 100.0d));
        this.ihk.setText(String.valueOf(pkInfoData.pkResultData.rankScore));
        this.ihl.setText(String.valueOf(pkInfoData.pkResultData.rankMaxScore));
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
            this.igW.setText(this.context.getString(a.h.sdk_pk_rank_this_total, String.valueOf(pkInfoData.pkResultData.totalScore)));
        } else {
            this.igW.setText(this.context.getString(a.h.sdk_pk_rank_this_total_fu, String.valueOf(pkInfoData.pkResultData.totalScore)));
        }
        if (pkInfoData.pkResultData.resultScore != 0) {
            this.igX.setVisibility(0);
            this.igY.setVisibility(0);
            switch (pkInfoData.pkResultData.resultType) {
                case 1:
                    if (pkInfoData.pkResultData.winStreakNum < 2) {
                        this.igV.setText(a.h.sdk_pk_rank_win_title);
                    } else {
                        this.igV.setText(this.context.getString(a.h.sdk_pk_rank_wins_title, String.valueOf(pkInfoData.pkResultData.winStreakNum)));
                    }
                    this.igX.setText(a.h.sdk_pk_rank_win);
                    this.igV.setTextColor(-5376);
                    break;
                case 2:
                    this.igV.setText(a.h.sdk_pk_rank_loss);
                    this.igV.setTextColor(-1513240);
                    this.igX.setText(a.h.sdk_pk_rank_loss);
                    break;
                case 3:
                    this.igX.setText(a.h.sdk_pk_rank_tied);
                    this.igV.setTextColor(-10955153);
                    this.igV.setText(a.h.sdk_pk_rank_tied);
                    break;
            }
            if (pkInfoData.pkResultData.resultScore > 0) {
                this.igY.setText(this.context.getString(a.h.sdk_pk_rank_add_score, String.valueOf(pkInfoData.pkResultData.resultScore)));
            } else {
                this.igY.setText(String.valueOf(pkInfoData.pkResultData.resultScore));
            }
        }
        if (pkInfoData.pkResultData.honorAddScore != 0) {
            this.igZ.setVisibility(0);
            this.iha.setVisibility(0);
            this.igZ.setText(this.context.getString(a.h.sdk_pk_rank_win_score, String.valueOf(pkInfoData.pkResultData.honorNum)));
            if (pkInfoData.pkResultData.honorAddScore > 0) {
                this.iha.setText(this.context.getString(a.h.sdk_pk_rank_add_score, String.valueOf(pkInfoData.pkResultData.honorAddScore)));
            } else {
                this.iha.setText(String.valueOf(pkInfoData.pkResultData.honorAddScore));
            }
        }
        if (pkInfoData.pkResultData.winStreakAddScore != 0) {
            this.ihb.setVisibility(0);
            this.ihc.setVisibility(0);
            this.ihb.setText(this.context.getString(a.h.sdk_pk_rank_wins, String.valueOf(pkInfoData.pkResultData.winStreakNum2)));
            if (pkInfoData.pkResultData.winStreakAddScore > 0) {
                this.ihc.setText(this.context.getString(a.h.sdk_pk_rank_add_score, String.valueOf(pkInfoData.pkResultData.winStreakAddScore)));
            } else {
                this.ihc.setText(String.valueOf(pkInfoData.pkResultData.winStreakAddScore));
            }
        }
        if (pkInfoData.pkResultData.finalWinScore != 0) {
            this.ihe.setVisibility(0);
            this.ihd.setVisibility(0);
            if (pkInfoData.pkResultData.finalWinScore > 0) {
                this.ihe.setText(this.context.getString(a.h.sdk_pk_rank_add_score, String.valueOf(pkInfoData.pkResultData.finalWinScore)));
            } else {
                this.ihe.setText(String.valueOf(pkInfoData.pkResultData.finalWinScore));
            }
        }
        if (pkInfoData.pkResultData.roundAddScore != 0) {
            this.ihf.setVisibility(0);
            this.ihg.setVisibility(0);
            this.ihf.setText(this.context.getString(a.h.sdk_pk_rank_total_times, String.valueOf(pkInfoData.pkResultData.roundNum)));
            if (pkInfoData.pkResultData.roundAddScore > 0) {
                this.ihg.setText(this.context.getString(a.h.sdk_pk_rank_add_score, String.valueOf(pkInfoData.pkResultData.roundAddScore)));
            } else {
                this.ihg.setText(String.valueOf(pkInfoData.pkResultData.roundAddScore));
            }
        }
    }

    public void setPkRankView(PkRankView pkRankView) {
        this.gPb = pkRankView;
        this.ihm.setPkRankView(pkRankView);
    }

    public void onDestroy() {
        if (this.gPb.getGetPkInfoModel() != null) {
            this.gPb.getGetPkInfoModel().clh();
            this.handler.removeMessages(0);
        }
    }
}
