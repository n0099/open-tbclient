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
    private PkRankView fXi;
    private Handler handler;
    private TextView hhA;
    PkRankMvpView hhB;
    private RelativeLayout hhh;
    private RelativeLayout hhi;
    private ViewFlipper hhj;
    private TextView hhk;
    private TextView hhl;
    private TextView hhm;
    private TextView hhn;
    private TextView hho;
    private TextView hhp;
    private TextView hhq;
    private TextView hhr;
    private TextView hhs;
    private TextView hht;
    private TextView hhu;
    private TextView hhv;
    private TbImageView hhw;
    private LinearLayout hhx;
    private SeekBar hhy;
    private TextView hhz;
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
        this.mView = LayoutInflater.from(getContext()).inflate(a.h.sdk_rank_result_layout, (ViewGroup) this, true);
        this.hhh = (RelativeLayout) this.mView.findViewById(a.g.result_layout);
        this.hhi = (RelativeLayout) this.mView.findViewById(a.g.title_layout);
        this.hhk = (TextView) this.mView.findViewById(a.g.wins_title);
        this.hhl = (TextView) this.mView.findViewById(a.g.score_title);
        this.hhj = (ViewFlipper) this.mView.findViewById(a.g.view_flipper);
        this.hhj.setInAnimation(AnimationUtils.loadAnimation(this.context, a.C0186a.pk_rank_slide_in_left));
        this.hhj.setOutAnimation(AnimationUtils.loadAnimation(this.context, a.C0186a.pk_rank_slide_out_right));
        this.hhB = (PkRankMvpView) this.mView.findViewById(a.g.mvp_view);
        ccU();
    }

    private void cdl() {
        View inflate = LayoutInflater.from(getContext()).inflate(a.h.sdk_rank_result_score_layout, (ViewGroup) null);
        this.hhm = (TextView) inflate.findViewById(a.g.result);
        this.hhn = (TextView) inflate.findViewById(a.g.result_score);
        this.hho = (TextView) inflate.findViewById(a.g.glory);
        this.hhp = (TextView) inflate.findViewById(a.g.glory_score);
        this.hhq = (TextView) inflate.findViewById(a.g.wins);
        this.hhr = (TextView) inflate.findViewById(a.g.wins_score);
        this.hhs = (TextView) inflate.findViewById(a.g.shut_down);
        this.hht = (TextView) inflate.findViewById(a.g.shut_down_score);
        this.hhu = (TextView) inflate.findViewById(a.g.total_times);
        this.hhv = (TextView) inflate.findViewById(a.g.total_times_score);
        this.hhj.addView(inflate);
    }

    private void cdm() {
        View inflate = LayoutInflater.from(getContext()).inflate(a.h.sdk_rank_result_rank_layout, (ViewGroup) null);
        this.hhw = (TbImageView) inflate.findViewById(a.g.rank_view);
        this.hhx = (LinearLayout) inflate.findViewById(a.g.star_layout);
        this.hhy = (SeekBar) inflate.findViewById(a.g.rank_progress);
        this.hhz = (TextView) inflate.findViewById(a.g.rank_get_score);
        this.hhA = (TextView) inflate.findViewById(a.g.rank_total_score);
        this.hhj.addView(inflate);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ccU() {
        this.hhh.setVisibility(8);
        this.hhi.setVisibility(8);
        this.hhj.setVisibility(8);
        this.hhB.setVisibility(8);
    }

    public void b(PkInfoData pkInfoData, int i) {
        this.fXi.cdz();
        if (this.fXi.vB(i) && !this.isShowing) {
            g(pkInfoData);
        }
    }

    private void g(final PkInfoData pkInfoData) {
        ccU();
        this.hhh.setVisibility(0);
        h(pkInfoData);
        this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.view.PkRankResultView.1
            @Override // java.lang.Runnable
            public void run() {
                PkRankResultView.this.cdn();
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
                    PkRankResultView.this.fXi.hhU.vz(0);
                    PkRankResultView.this.ccU();
                }
            }, pkInfoData.showScoreTime + pkInfoData.showRankTime + pkInfoData.showMvpTime);
        } else {
            this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.view.PkRankResultView.4
                @Override // java.lang.Runnable
                public void run() {
                    PkRankResultView.this.fXi.hhU.vz(0);
                    PkRankResultView.this.ccU();
                }
            }, pkInfoData.showScoreTime + pkInfoData.showRankTime);
        }
        this.isShowing = true;
    }

    private void h(PkInfoData pkInfoData) {
        this.hhi.setVisibility(0);
        this.hhj.setVisibility(0);
        this.hhj.removeAllViews();
        cdl();
        cdm();
        k(pkInfoData);
        j(pkInfoData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cdn() {
        this.hhj.showNext();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(PkInfoData pkInfoData) {
        this.hhi.setVisibility(8);
        this.hhj.setVisibility(8);
        this.hhB.setVisibility(0);
        this.hhB.e(pkInfoData);
    }

    private void j(PkInfoData pkInfoData) {
        boolean z = pkInfoData.pkResultData.rankType.equals("king");
        this.hhw.startLoad(pkInfoData.pkResultData.rankImageUrl, 10, false);
        this.hhx.removeAllViews();
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(BdUtilHelper.getDimens(this.context, a.e.sdk_ds16), BdUtilHelper.getDimens(this.context, a.e.sdk_ds16));
        layoutParams.rightMargin = BdUtilHelper.getDimens(this.context, a.e.sdk_ds4);
        layoutParams.gravity = 16;
        for (int i = 0; i < pkInfoData.pkResultData.currentStar; i++) {
            this.hhx.addView(getSolidStarView(), layoutParams);
        }
        for (int i2 = 0; i2 < pkInfoData.pkResultData.maxStar - pkInfoData.pkResultData.currentStar; i2++) {
            this.hhx.addView(getBlankStarView(), layoutParams);
        }
        if (z) {
            this.hhy.setVisibility(8);
            this.hhz.setVisibility(8);
            this.hhA.setVisibility(8);
            return;
        }
        this.hhy.setProgress((int) (((pkInfoData.pkResultData.rankScore - pkInfoData.pkResultData.rankMinScore) / pkInfoData.pkResultData.rankMaxScore) * 100.0d));
        this.hhz.setText(String.valueOf(pkInfoData.pkResultData.rankScore));
        this.hhA.setText(String.valueOf(pkInfoData.pkResultData.rankMaxScore));
    }

    private View getSolidStarView() {
        ImageView imageView = new ImageView(this.context);
        imageView.setImageResource(a.f.ala_icon_five_pointed_star);
        return imageView;
    }

    private View getBlankStarView() {
        ImageView imageView = new ImageView(this.context);
        imageView.setImageResource(a.f.ala_icon_blank_five_pointed_star);
        return imageView;
    }

    private void k(PkInfoData pkInfoData) {
        if (pkInfoData.pkResultData.totalScore > 0) {
            this.hhl.setText(this.context.getString(a.i.sdk_pk_rank_this_total, String.valueOf(pkInfoData.pkResultData.totalScore)));
        } else {
            this.hhl.setText(this.context.getString(a.i.sdk_pk_rank_this_total_fu, String.valueOf(pkInfoData.pkResultData.totalScore)));
        }
        if (pkInfoData.pkResultData.resultScore != 0) {
            this.hhm.setVisibility(0);
            this.hhn.setVisibility(0);
            switch (pkInfoData.pkResultData.resultType) {
                case 1:
                    if (pkInfoData.pkResultData.winStreakNum < 2) {
                        this.hhk.setText(a.i.sdk_pk_rank_win_title);
                    } else {
                        this.hhk.setText(this.context.getString(a.i.sdk_pk_rank_wins_title, String.valueOf(pkInfoData.pkResultData.winStreakNum)));
                    }
                    this.hhm.setText(a.i.sdk_pk_rank_win);
                    this.hhk.setTextColor(-5376);
                    break;
                case 2:
                    this.hhk.setText(a.i.sdk_pk_rank_loss);
                    this.hhk.setTextColor(-1513240);
                    this.hhm.setText(a.i.sdk_pk_rank_loss);
                    break;
                case 3:
                    this.hhm.setText(a.i.sdk_pk_rank_tied);
                    this.hhk.setTextColor(-10955153);
                    this.hhk.setText(a.i.sdk_pk_rank_tied);
                    break;
            }
            if (pkInfoData.pkResultData.resultScore > 0) {
                this.hhn.setText(this.context.getString(a.i.sdk_pk_rank_add_score, String.valueOf(pkInfoData.pkResultData.resultScore)));
            } else {
                this.hhn.setText(String.valueOf(pkInfoData.pkResultData.resultScore));
            }
        }
        if (pkInfoData.pkResultData.honorAddScore != 0) {
            this.hho.setVisibility(0);
            this.hhp.setVisibility(0);
            this.hho.setText(this.context.getString(a.i.sdk_pk_rank_win_score, String.valueOf(pkInfoData.pkResultData.honorNum)));
            if (pkInfoData.pkResultData.honorAddScore > 0) {
                this.hhp.setText(this.context.getString(a.i.sdk_pk_rank_add_score, String.valueOf(pkInfoData.pkResultData.honorAddScore)));
            } else {
                this.hhp.setText(String.valueOf(pkInfoData.pkResultData.honorAddScore));
            }
        }
        if (pkInfoData.pkResultData.winStreakAddScore != 0) {
            this.hhq.setVisibility(0);
            this.hhr.setVisibility(0);
            this.hhq.setText(this.context.getString(a.i.sdk_pk_rank_wins, String.valueOf(pkInfoData.pkResultData.winStreakNum2)));
            if (pkInfoData.pkResultData.winStreakAddScore > 0) {
                this.hhr.setText(this.context.getString(a.i.sdk_pk_rank_add_score, String.valueOf(pkInfoData.pkResultData.winStreakAddScore)));
            } else {
                this.hhr.setText(String.valueOf(pkInfoData.pkResultData.winStreakAddScore));
            }
        }
        if (pkInfoData.pkResultData.finalWinScore != 0) {
            this.hht.setVisibility(0);
            this.hhs.setVisibility(0);
            if (pkInfoData.pkResultData.finalWinScore > 0) {
                this.hht.setText(this.context.getString(a.i.sdk_pk_rank_add_score, String.valueOf(pkInfoData.pkResultData.finalWinScore)));
            } else {
                this.hht.setText(String.valueOf(pkInfoData.pkResultData.finalWinScore));
            }
        }
        if (pkInfoData.pkResultData.roundAddScore != 0) {
            this.hhu.setVisibility(0);
            this.hhv.setVisibility(0);
            this.hhu.setText(this.context.getString(a.i.sdk_pk_rank_total_times, String.valueOf(pkInfoData.pkResultData.roundNum)));
            if (pkInfoData.pkResultData.roundAddScore > 0) {
                this.hhv.setText(this.context.getString(a.i.sdk_pk_rank_add_score, String.valueOf(pkInfoData.pkResultData.roundAddScore)));
            } else {
                this.hhv.setText(String.valueOf(pkInfoData.pkResultData.roundAddScore));
            }
        }
    }

    public void setPkRankView(PkRankView pkRankView) {
        this.fXi = pkRankView;
        this.hhB.setPkRankView(pkRankView);
    }

    public void onDestroy() {
        if (this.fXi.getGetPkInfoModel() != null) {
            this.fXi.getGetPkInfoModel().bZR();
            this.handler.removeMessages(0);
        }
    }
}
