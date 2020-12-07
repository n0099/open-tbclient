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
    private PkRankView gHT;
    private RelativeLayout hYY;
    private RelativeLayout hYZ;
    private ViewFlipper hZa;
    private TextView hZb;
    private TextView hZc;
    private TextView hZd;
    private TextView hZe;
    private TextView hZf;
    private TextView hZg;
    private TextView hZh;
    private TextView hZi;
    private TextView hZj;
    private TextView hZk;
    private TextView hZl;
    private TextView hZm;
    private TbImageView hZn;
    private LinearLayout hZo;
    private SeekBar hZp;
    private TextView hZq;
    private TextView hZr;
    PkRankMvpView hZs;
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
        this.hYY = (RelativeLayout) this.mView.findViewById(a.f.result_layout);
        this.hYZ = (RelativeLayout) this.mView.findViewById(a.f.title_layout);
        this.hZb = (TextView) this.mView.findViewById(a.f.wins_title);
        this.hZc = (TextView) this.mView.findViewById(a.f.score_title);
        this.hZa = (ViewFlipper) this.mView.findViewById(a.f.view_flipper);
        this.hZa.setInAnimation(AnimationUtils.loadAnimation(this.context, a.C0205a.pk_rank_slide_in_left));
        this.hZa.setOutAnimation(AnimationUtils.loadAnimation(this.context, a.C0205a.pk_rank_slide_out_right));
        this.hZs = (PkRankMvpView) this.mView.findViewById(a.f.mvp_view);
        cpH();
    }

    private void cpY() {
        View inflate = LayoutInflater.from(getContext()).inflate(a.g.sdk_rank_result_score_layout, (ViewGroup) null);
        this.hZd = (TextView) inflate.findViewById(a.f.result);
        this.hZe = (TextView) inflate.findViewById(a.f.result_score);
        this.hZf = (TextView) inflate.findViewById(a.f.glory);
        this.hZg = (TextView) inflate.findViewById(a.f.glory_score);
        this.hZh = (TextView) inflate.findViewById(a.f.wins);
        this.hZi = (TextView) inflate.findViewById(a.f.wins_score);
        this.hZj = (TextView) inflate.findViewById(a.f.shut_down);
        this.hZk = (TextView) inflate.findViewById(a.f.shut_down_score);
        this.hZl = (TextView) inflate.findViewById(a.f.total_times);
        this.hZm = (TextView) inflate.findViewById(a.f.total_times_score);
        this.hZa.addView(inflate);
    }

    private void cpZ() {
        View inflate = LayoutInflater.from(getContext()).inflate(a.g.sdk_rank_result_rank_layout, (ViewGroup) null);
        this.hZn = (TbImageView) inflate.findViewById(a.f.rank_view);
        this.hZo = (LinearLayout) inflate.findViewById(a.f.star_layout);
        this.hZp = (SeekBar) inflate.findViewById(a.f.rank_progress);
        this.hZq = (TextView) inflate.findViewById(a.f.rank_get_score);
        this.hZr = (TextView) inflate.findViewById(a.f.rank_total_score);
        this.hZa.addView(inflate);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cpH() {
        this.hYY.setVisibility(8);
        this.hYZ.setVisibility(8);
        this.hZa.setVisibility(8);
        this.hZs.setVisibility(8);
    }

    public void b(PkInfoData pkInfoData, int i) {
        this.gHT.cqk();
        if (this.gHT.xR(i) && !this.isShowing) {
            g(pkInfoData);
        }
    }

    private void g(final PkInfoData pkInfoData) {
        cpH();
        this.hYY.setVisibility(0);
        h(pkInfoData);
        this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.view.PkRankResultView.1
            @Override // java.lang.Runnable
            public void run() {
                PkRankResultView.this.cqa();
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
                    PkRankResultView.this.gHT.hZI.xP(0);
                    PkRankResultView.this.cpH();
                }
            }, pkInfoData.showScoreTime + pkInfoData.showRankTime + pkInfoData.showMvpTime);
        } else {
            this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.view.PkRankResultView.4
                @Override // java.lang.Runnable
                public void run() {
                    PkRankResultView.this.gHT.hZI.xP(0);
                    PkRankResultView.this.cpH();
                }
            }, pkInfoData.showScoreTime + pkInfoData.showRankTime);
        }
        this.isShowing = true;
    }

    private void h(PkInfoData pkInfoData) {
        this.hYZ.setVisibility(0);
        this.hZa.setVisibility(0);
        this.hZa.removeAllViews();
        cpY();
        cpZ();
        k(pkInfoData);
        j(pkInfoData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cqa() {
        this.hZa.showNext();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(PkInfoData pkInfoData) {
        this.hYZ.setVisibility(8);
        this.hZa.setVisibility(8);
        this.hZs.setVisibility(0);
        this.hZs.e(pkInfoData);
    }

    private void j(PkInfoData pkInfoData) {
        boolean z = pkInfoData.pkResultData.rankType.equals("king");
        this.hZn.startLoad(pkInfoData.pkResultData.rankImageUrl, 10, false);
        this.hZo.removeAllViews();
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(BdUtilHelper.getDimens(this.context, a.d.sdk_ds16), BdUtilHelper.getDimens(this.context, a.d.sdk_ds16));
        layoutParams.rightMargin = BdUtilHelper.getDimens(this.context, a.d.sdk_ds4);
        layoutParams.gravity = 16;
        for (int i = 0; i < pkInfoData.pkResultData.currentStar; i++) {
            this.hZo.addView(getSolidStarView(), layoutParams);
        }
        for (int i2 = 0; i2 < pkInfoData.pkResultData.maxStar - pkInfoData.pkResultData.currentStar; i2++) {
            this.hZo.addView(getBlankStarView(), layoutParams);
        }
        if (z) {
            this.hZp.setVisibility(8);
            this.hZq.setVisibility(8);
            this.hZr.setVisibility(8);
            return;
        }
        this.hZp.setProgress((int) (((pkInfoData.pkResultData.rankScore - pkInfoData.pkResultData.rankMinScore) / pkInfoData.pkResultData.rankMaxScore) * 100.0d));
        this.hZq.setText(String.valueOf(pkInfoData.pkResultData.rankScore));
        this.hZr.setText(String.valueOf(pkInfoData.pkResultData.rankMaxScore));
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
            this.hZc.setText(this.context.getString(a.h.sdk_pk_rank_this_total, String.valueOf(pkInfoData.pkResultData.totalScore)));
        } else {
            this.hZc.setText(this.context.getString(a.h.sdk_pk_rank_this_total_fu, String.valueOf(pkInfoData.pkResultData.totalScore)));
        }
        if (pkInfoData.pkResultData.resultScore != 0) {
            this.hZd.setVisibility(0);
            this.hZe.setVisibility(0);
            switch (pkInfoData.pkResultData.resultType) {
                case 1:
                    if (pkInfoData.pkResultData.winStreakNum < 2) {
                        this.hZb.setText(a.h.sdk_pk_rank_win_title);
                    } else {
                        this.hZb.setText(this.context.getString(a.h.sdk_pk_rank_wins_title, String.valueOf(pkInfoData.pkResultData.winStreakNum)));
                    }
                    this.hZd.setText(a.h.sdk_pk_rank_win);
                    this.hZb.setTextColor(-5376);
                    break;
                case 2:
                    this.hZb.setText(a.h.sdk_pk_rank_loss);
                    this.hZb.setTextColor(-1513240);
                    this.hZd.setText(a.h.sdk_pk_rank_loss);
                    break;
                case 3:
                    this.hZd.setText(a.h.sdk_pk_rank_tied);
                    this.hZb.setTextColor(-10955153);
                    this.hZb.setText(a.h.sdk_pk_rank_tied);
                    break;
            }
            if (pkInfoData.pkResultData.resultScore > 0) {
                this.hZe.setText(this.context.getString(a.h.sdk_pk_rank_add_score, String.valueOf(pkInfoData.pkResultData.resultScore)));
            } else {
                this.hZe.setText(String.valueOf(pkInfoData.pkResultData.resultScore));
            }
        }
        if (pkInfoData.pkResultData.honorAddScore != 0) {
            this.hZf.setVisibility(0);
            this.hZg.setVisibility(0);
            this.hZf.setText(this.context.getString(a.h.sdk_pk_rank_win_score, String.valueOf(pkInfoData.pkResultData.honorNum)));
            if (pkInfoData.pkResultData.honorAddScore > 0) {
                this.hZg.setText(this.context.getString(a.h.sdk_pk_rank_add_score, String.valueOf(pkInfoData.pkResultData.honorAddScore)));
            } else {
                this.hZg.setText(String.valueOf(pkInfoData.pkResultData.honorAddScore));
            }
        }
        if (pkInfoData.pkResultData.winStreakAddScore != 0) {
            this.hZh.setVisibility(0);
            this.hZi.setVisibility(0);
            this.hZh.setText(this.context.getString(a.h.sdk_pk_rank_wins, String.valueOf(pkInfoData.pkResultData.winStreakNum2)));
            if (pkInfoData.pkResultData.winStreakAddScore > 0) {
                this.hZi.setText(this.context.getString(a.h.sdk_pk_rank_add_score, String.valueOf(pkInfoData.pkResultData.winStreakAddScore)));
            } else {
                this.hZi.setText(String.valueOf(pkInfoData.pkResultData.winStreakAddScore));
            }
        }
        if (pkInfoData.pkResultData.finalWinScore != 0) {
            this.hZk.setVisibility(0);
            this.hZj.setVisibility(0);
            if (pkInfoData.pkResultData.finalWinScore > 0) {
                this.hZk.setText(this.context.getString(a.h.sdk_pk_rank_add_score, String.valueOf(pkInfoData.pkResultData.finalWinScore)));
            } else {
                this.hZk.setText(String.valueOf(pkInfoData.pkResultData.finalWinScore));
            }
        }
        if (pkInfoData.pkResultData.roundAddScore != 0) {
            this.hZl.setVisibility(0);
            this.hZm.setVisibility(0);
            this.hZl.setText(this.context.getString(a.h.sdk_pk_rank_total_times, String.valueOf(pkInfoData.pkResultData.roundNum)));
            if (pkInfoData.pkResultData.roundAddScore > 0) {
                this.hZm.setText(this.context.getString(a.h.sdk_pk_rank_add_score, String.valueOf(pkInfoData.pkResultData.roundAddScore)));
            } else {
                this.hZm.setText(String.valueOf(pkInfoData.pkResultData.roundAddScore));
            }
        }
    }

    public void setPkRankView(PkRankView pkRankView) {
        this.gHT = pkRankView;
        this.hZs.setPkRankView(pkRankView);
    }

    public void onDestroy() {
        if (this.gHT.getGetPkInfoModel() != null) {
            this.gHT.getGetPkInfoModel().cmg();
            this.handler.removeMessages(0);
        }
    }
}
