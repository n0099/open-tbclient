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
    private PkRankView gHV;
    private RelativeLayout hZa;
    private RelativeLayout hZb;
    private ViewFlipper hZc;
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
    private TextView hZn;
    private TextView hZo;
    private TbImageView hZp;
    private LinearLayout hZq;
    private SeekBar hZr;
    private TextView hZs;
    private TextView hZt;
    PkRankMvpView hZu;
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
        this.hZa = (RelativeLayout) this.mView.findViewById(a.f.result_layout);
        this.hZb = (RelativeLayout) this.mView.findViewById(a.f.title_layout);
        this.hZd = (TextView) this.mView.findViewById(a.f.wins_title);
        this.hZe = (TextView) this.mView.findViewById(a.f.score_title);
        this.hZc = (ViewFlipper) this.mView.findViewById(a.f.view_flipper);
        this.hZc.setInAnimation(AnimationUtils.loadAnimation(this.context, a.C0205a.pk_rank_slide_in_left));
        this.hZc.setOutAnimation(AnimationUtils.loadAnimation(this.context, a.C0205a.pk_rank_slide_out_right));
        this.hZu = (PkRankMvpView) this.mView.findViewById(a.f.mvp_view);
        cpI();
    }

    private void cpZ() {
        View inflate = LayoutInflater.from(getContext()).inflate(a.g.sdk_rank_result_score_layout, (ViewGroup) null);
        this.hZf = (TextView) inflate.findViewById(a.f.result);
        this.hZg = (TextView) inflate.findViewById(a.f.result_score);
        this.hZh = (TextView) inflate.findViewById(a.f.glory);
        this.hZi = (TextView) inflate.findViewById(a.f.glory_score);
        this.hZj = (TextView) inflate.findViewById(a.f.wins);
        this.hZk = (TextView) inflate.findViewById(a.f.wins_score);
        this.hZl = (TextView) inflate.findViewById(a.f.shut_down);
        this.hZm = (TextView) inflate.findViewById(a.f.shut_down_score);
        this.hZn = (TextView) inflate.findViewById(a.f.total_times);
        this.hZo = (TextView) inflate.findViewById(a.f.total_times_score);
        this.hZc.addView(inflate);
    }

    private void cqa() {
        View inflate = LayoutInflater.from(getContext()).inflate(a.g.sdk_rank_result_rank_layout, (ViewGroup) null);
        this.hZp = (TbImageView) inflate.findViewById(a.f.rank_view);
        this.hZq = (LinearLayout) inflate.findViewById(a.f.star_layout);
        this.hZr = (SeekBar) inflate.findViewById(a.f.rank_progress);
        this.hZs = (TextView) inflate.findViewById(a.f.rank_get_score);
        this.hZt = (TextView) inflate.findViewById(a.f.rank_total_score);
        this.hZc.addView(inflate);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cpI() {
        this.hZa.setVisibility(8);
        this.hZb.setVisibility(8);
        this.hZc.setVisibility(8);
        this.hZu.setVisibility(8);
    }

    public void b(PkInfoData pkInfoData, int i) {
        this.gHV.cql();
        if (this.gHV.xR(i) && !this.isShowing) {
            g(pkInfoData);
        }
    }

    private void g(final PkInfoData pkInfoData) {
        cpI();
        this.hZa.setVisibility(0);
        h(pkInfoData);
        this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.view.PkRankResultView.1
            @Override // java.lang.Runnable
            public void run() {
                PkRankResultView.this.cqb();
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
                    PkRankResultView.this.gHV.hZK.xP(0);
                    PkRankResultView.this.cpI();
                }
            }, pkInfoData.showScoreTime + pkInfoData.showRankTime + pkInfoData.showMvpTime);
        } else {
            this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.view.PkRankResultView.4
                @Override // java.lang.Runnable
                public void run() {
                    PkRankResultView.this.gHV.hZK.xP(0);
                    PkRankResultView.this.cpI();
                }
            }, pkInfoData.showScoreTime + pkInfoData.showRankTime);
        }
        this.isShowing = true;
    }

    private void h(PkInfoData pkInfoData) {
        this.hZb.setVisibility(0);
        this.hZc.setVisibility(0);
        this.hZc.removeAllViews();
        cpZ();
        cqa();
        k(pkInfoData);
        j(pkInfoData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cqb() {
        this.hZc.showNext();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(PkInfoData pkInfoData) {
        this.hZb.setVisibility(8);
        this.hZc.setVisibility(8);
        this.hZu.setVisibility(0);
        this.hZu.e(pkInfoData);
    }

    private void j(PkInfoData pkInfoData) {
        boolean z = pkInfoData.pkResultData.rankType.equals("king");
        this.hZp.startLoad(pkInfoData.pkResultData.rankImageUrl, 10, false);
        this.hZq.removeAllViews();
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(BdUtilHelper.getDimens(this.context, a.d.sdk_ds16), BdUtilHelper.getDimens(this.context, a.d.sdk_ds16));
        layoutParams.rightMargin = BdUtilHelper.getDimens(this.context, a.d.sdk_ds4);
        layoutParams.gravity = 16;
        for (int i = 0; i < pkInfoData.pkResultData.currentStar; i++) {
            this.hZq.addView(getSolidStarView(), layoutParams);
        }
        for (int i2 = 0; i2 < pkInfoData.pkResultData.maxStar - pkInfoData.pkResultData.currentStar; i2++) {
            this.hZq.addView(getBlankStarView(), layoutParams);
        }
        if (z) {
            this.hZr.setVisibility(8);
            this.hZs.setVisibility(8);
            this.hZt.setVisibility(8);
            return;
        }
        this.hZr.setProgress((int) (((pkInfoData.pkResultData.rankScore - pkInfoData.pkResultData.rankMinScore) / pkInfoData.pkResultData.rankMaxScore) * 100.0d));
        this.hZs.setText(String.valueOf(pkInfoData.pkResultData.rankScore));
        this.hZt.setText(String.valueOf(pkInfoData.pkResultData.rankMaxScore));
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
            this.hZe.setText(this.context.getString(a.h.sdk_pk_rank_this_total, String.valueOf(pkInfoData.pkResultData.totalScore)));
        } else {
            this.hZe.setText(this.context.getString(a.h.sdk_pk_rank_this_total_fu, String.valueOf(pkInfoData.pkResultData.totalScore)));
        }
        if (pkInfoData.pkResultData.resultScore != 0) {
            this.hZf.setVisibility(0);
            this.hZg.setVisibility(0);
            switch (pkInfoData.pkResultData.resultType) {
                case 1:
                    if (pkInfoData.pkResultData.winStreakNum < 2) {
                        this.hZd.setText(a.h.sdk_pk_rank_win_title);
                    } else {
                        this.hZd.setText(this.context.getString(a.h.sdk_pk_rank_wins_title, String.valueOf(pkInfoData.pkResultData.winStreakNum)));
                    }
                    this.hZf.setText(a.h.sdk_pk_rank_win);
                    this.hZd.setTextColor(-5376);
                    break;
                case 2:
                    this.hZd.setText(a.h.sdk_pk_rank_loss);
                    this.hZd.setTextColor(-1513240);
                    this.hZf.setText(a.h.sdk_pk_rank_loss);
                    break;
                case 3:
                    this.hZf.setText(a.h.sdk_pk_rank_tied);
                    this.hZd.setTextColor(-10955153);
                    this.hZd.setText(a.h.sdk_pk_rank_tied);
                    break;
            }
            if (pkInfoData.pkResultData.resultScore > 0) {
                this.hZg.setText(this.context.getString(a.h.sdk_pk_rank_add_score, String.valueOf(pkInfoData.pkResultData.resultScore)));
            } else {
                this.hZg.setText(String.valueOf(pkInfoData.pkResultData.resultScore));
            }
        }
        if (pkInfoData.pkResultData.honorAddScore != 0) {
            this.hZh.setVisibility(0);
            this.hZi.setVisibility(0);
            this.hZh.setText(this.context.getString(a.h.sdk_pk_rank_win_score, String.valueOf(pkInfoData.pkResultData.honorNum)));
            if (pkInfoData.pkResultData.honorAddScore > 0) {
                this.hZi.setText(this.context.getString(a.h.sdk_pk_rank_add_score, String.valueOf(pkInfoData.pkResultData.honorAddScore)));
            } else {
                this.hZi.setText(String.valueOf(pkInfoData.pkResultData.honorAddScore));
            }
        }
        if (pkInfoData.pkResultData.winStreakAddScore != 0) {
            this.hZj.setVisibility(0);
            this.hZk.setVisibility(0);
            this.hZj.setText(this.context.getString(a.h.sdk_pk_rank_wins, String.valueOf(pkInfoData.pkResultData.winStreakNum2)));
            if (pkInfoData.pkResultData.winStreakAddScore > 0) {
                this.hZk.setText(this.context.getString(a.h.sdk_pk_rank_add_score, String.valueOf(pkInfoData.pkResultData.winStreakAddScore)));
            } else {
                this.hZk.setText(String.valueOf(pkInfoData.pkResultData.winStreakAddScore));
            }
        }
        if (pkInfoData.pkResultData.finalWinScore != 0) {
            this.hZm.setVisibility(0);
            this.hZl.setVisibility(0);
            if (pkInfoData.pkResultData.finalWinScore > 0) {
                this.hZm.setText(this.context.getString(a.h.sdk_pk_rank_add_score, String.valueOf(pkInfoData.pkResultData.finalWinScore)));
            } else {
                this.hZm.setText(String.valueOf(pkInfoData.pkResultData.finalWinScore));
            }
        }
        if (pkInfoData.pkResultData.roundAddScore != 0) {
            this.hZn.setVisibility(0);
            this.hZo.setVisibility(0);
            this.hZn.setText(this.context.getString(a.h.sdk_pk_rank_total_times, String.valueOf(pkInfoData.pkResultData.roundNum)));
            if (pkInfoData.pkResultData.roundAddScore > 0) {
                this.hZo.setText(this.context.getString(a.h.sdk_pk_rank_add_score, String.valueOf(pkInfoData.pkResultData.roundAddScore)));
            } else {
                this.hZo.setText(String.valueOf(pkInfoData.pkResultData.roundAddScore));
            }
        }
    }

    public void setPkRankView(PkRankView pkRankView) {
        this.gHV = pkRankView;
        this.hZu.setPkRankView(pkRankView);
    }

    public void onDestroy() {
        if (this.gHV.getGetPkInfoModel() != null) {
            this.gHV.getGetPkInfoModel().cmh();
            this.handler.removeMessages(0);
        }
    }
}
