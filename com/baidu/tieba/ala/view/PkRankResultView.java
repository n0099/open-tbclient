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
    private PkRankView gjB;
    private Handler handler;
    private RelativeLayout hwd;
    private RelativeLayout hwe;
    private ViewFlipper hwf;
    private TextView hwg;
    private TextView hwh;
    private TextView hwi;
    private TextView hwj;
    private TextView hwk;
    private TextView hwl;
    private TextView hwm;
    private TextView hwn;
    private TextView hwo;
    private TextView hwp;
    private TextView hwq;
    private TextView hwr;
    private TbImageView hws;
    private LinearLayout hwt;
    private SeekBar hwu;
    private TextView hwv;
    private TextView hww;
    PkRankMvpView hwx;
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
        this.hwd = (RelativeLayout) this.mView.findViewById(a.g.result_layout);
        this.hwe = (RelativeLayout) this.mView.findViewById(a.g.title_layout);
        this.hwg = (TextView) this.mView.findViewById(a.g.wins_title);
        this.hwh = (TextView) this.mView.findViewById(a.g.score_title);
        this.hwf = (ViewFlipper) this.mView.findViewById(a.g.view_flipper);
        this.hwf.setInAnimation(AnimationUtils.loadAnimation(this.context, a.C0194a.pk_rank_slide_in_left));
        this.hwf.setOutAnimation(AnimationUtils.loadAnimation(this.context, a.C0194a.pk_rank_slide_out_right));
        this.hwx = (PkRankMvpView) this.mView.findViewById(a.g.mvp_view);
        cgq();
    }

    private void cgH() {
        View inflate = LayoutInflater.from(getContext()).inflate(a.h.sdk_rank_result_score_layout, (ViewGroup) null);
        this.hwi = (TextView) inflate.findViewById(a.g.result);
        this.hwj = (TextView) inflate.findViewById(a.g.result_score);
        this.hwk = (TextView) inflate.findViewById(a.g.glory);
        this.hwl = (TextView) inflate.findViewById(a.g.glory_score);
        this.hwm = (TextView) inflate.findViewById(a.g.wins);
        this.hwn = (TextView) inflate.findViewById(a.g.wins_score);
        this.hwo = (TextView) inflate.findViewById(a.g.shut_down);
        this.hwp = (TextView) inflate.findViewById(a.g.shut_down_score);
        this.hwq = (TextView) inflate.findViewById(a.g.total_times);
        this.hwr = (TextView) inflate.findViewById(a.g.total_times_score);
        this.hwf.addView(inflate);
    }

    private void cgI() {
        View inflate = LayoutInflater.from(getContext()).inflate(a.h.sdk_rank_result_rank_layout, (ViewGroup) null);
        this.hws = (TbImageView) inflate.findViewById(a.g.rank_view);
        this.hwt = (LinearLayout) inflate.findViewById(a.g.star_layout);
        this.hwu = (SeekBar) inflate.findViewById(a.g.rank_progress);
        this.hwv = (TextView) inflate.findViewById(a.g.rank_get_score);
        this.hww = (TextView) inflate.findViewById(a.g.rank_total_score);
        this.hwf.addView(inflate);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cgq() {
        this.hwd.setVisibility(8);
        this.hwe.setVisibility(8);
        this.hwf.setVisibility(8);
        this.hwx.setVisibility(8);
    }

    public void b(PkInfoData pkInfoData, int i) {
        this.gjB.cgV();
        if (this.gjB.wh(i) && !this.isShowing) {
            g(pkInfoData);
        }
    }

    private void g(final PkInfoData pkInfoData) {
        cgq();
        this.hwd.setVisibility(0);
        h(pkInfoData);
        this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.view.PkRankResultView.1
            @Override // java.lang.Runnable
            public void run() {
                PkRankResultView.this.cgJ();
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
                    PkRankResultView.this.gjB.hwQ.wf(0);
                    PkRankResultView.this.cgq();
                }
            }, pkInfoData.showScoreTime + pkInfoData.showRankTime + pkInfoData.showMvpTime);
        } else {
            this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.view.PkRankResultView.4
                @Override // java.lang.Runnable
                public void run() {
                    PkRankResultView.this.gjB.hwQ.wf(0);
                    PkRankResultView.this.cgq();
                }
            }, pkInfoData.showScoreTime + pkInfoData.showRankTime);
        }
        this.isShowing = true;
    }

    private void h(PkInfoData pkInfoData) {
        this.hwe.setVisibility(0);
        this.hwf.setVisibility(0);
        this.hwf.removeAllViews();
        cgH();
        cgI();
        k(pkInfoData);
        j(pkInfoData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cgJ() {
        this.hwf.showNext();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(PkInfoData pkInfoData) {
        this.hwe.setVisibility(8);
        this.hwf.setVisibility(8);
        this.hwx.setVisibility(0);
        this.hwx.e(pkInfoData);
    }

    private void j(PkInfoData pkInfoData) {
        boolean z = pkInfoData.pkResultData.rankType.equals("king");
        this.hws.startLoad(pkInfoData.pkResultData.rankImageUrl, 10, false);
        this.hwt.removeAllViews();
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(BdUtilHelper.getDimens(this.context, a.e.sdk_ds16), BdUtilHelper.getDimens(this.context, a.e.sdk_ds16));
        layoutParams.rightMargin = BdUtilHelper.getDimens(this.context, a.e.sdk_ds4);
        layoutParams.gravity = 16;
        for (int i = 0; i < pkInfoData.pkResultData.currentStar; i++) {
            this.hwt.addView(getSolidStarView(), layoutParams);
        }
        for (int i2 = 0; i2 < pkInfoData.pkResultData.maxStar - pkInfoData.pkResultData.currentStar; i2++) {
            this.hwt.addView(getBlankStarView(), layoutParams);
        }
        if (z) {
            this.hwu.setVisibility(8);
            this.hwv.setVisibility(8);
            this.hww.setVisibility(8);
            return;
        }
        this.hwu.setProgress((int) (((pkInfoData.pkResultData.rankScore - pkInfoData.pkResultData.rankMinScore) / pkInfoData.pkResultData.rankMaxScore) * 100.0d));
        this.hwv.setText(String.valueOf(pkInfoData.pkResultData.rankScore));
        this.hww.setText(String.valueOf(pkInfoData.pkResultData.rankMaxScore));
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
            this.hwh.setText(this.context.getString(a.i.sdk_pk_rank_this_total, String.valueOf(pkInfoData.pkResultData.totalScore)));
        } else {
            this.hwh.setText(this.context.getString(a.i.sdk_pk_rank_this_total_fu, String.valueOf(pkInfoData.pkResultData.totalScore)));
        }
        if (pkInfoData.pkResultData.resultScore != 0) {
            this.hwi.setVisibility(0);
            this.hwj.setVisibility(0);
            switch (pkInfoData.pkResultData.resultType) {
                case 1:
                    if (pkInfoData.pkResultData.winStreakNum < 2) {
                        this.hwg.setText(a.i.sdk_pk_rank_win_title);
                    } else {
                        this.hwg.setText(this.context.getString(a.i.sdk_pk_rank_wins_title, String.valueOf(pkInfoData.pkResultData.winStreakNum)));
                    }
                    this.hwi.setText(a.i.sdk_pk_rank_win);
                    this.hwg.setTextColor(-5376);
                    break;
                case 2:
                    this.hwg.setText(a.i.sdk_pk_rank_loss);
                    this.hwg.setTextColor(-1513240);
                    this.hwi.setText(a.i.sdk_pk_rank_loss);
                    break;
                case 3:
                    this.hwi.setText(a.i.sdk_pk_rank_tied);
                    this.hwg.setTextColor(-10955153);
                    this.hwg.setText(a.i.sdk_pk_rank_tied);
                    break;
            }
            if (pkInfoData.pkResultData.resultScore > 0) {
                this.hwj.setText(this.context.getString(a.i.sdk_pk_rank_add_score, String.valueOf(pkInfoData.pkResultData.resultScore)));
            } else {
                this.hwj.setText(String.valueOf(pkInfoData.pkResultData.resultScore));
            }
        }
        if (pkInfoData.pkResultData.honorAddScore != 0) {
            this.hwk.setVisibility(0);
            this.hwl.setVisibility(0);
            this.hwk.setText(this.context.getString(a.i.sdk_pk_rank_win_score, String.valueOf(pkInfoData.pkResultData.honorNum)));
            if (pkInfoData.pkResultData.honorAddScore > 0) {
                this.hwl.setText(this.context.getString(a.i.sdk_pk_rank_add_score, String.valueOf(pkInfoData.pkResultData.honorAddScore)));
            } else {
                this.hwl.setText(String.valueOf(pkInfoData.pkResultData.honorAddScore));
            }
        }
        if (pkInfoData.pkResultData.winStreakAddScore != 0) {
            this.hwm.setVisibility(0);
            this.hwn.setVisibility(0);
            this.hwm.setText(this.context.getString(a.i.sdk_pk_rank_wins, String.valueOf(pkInfoData.pkResultData.winStreakNum2)));
            if (pkInfoData.pkResultData.winStreakAddScore > 0) {
                this.hwn.setText(this.context.getString(a.i.sdk_pk_rank_add_score, String.valueOf(pkInfoData.pkResultData.winStreakAddScore)));
            } else {
                this.hwn.setText(String.valueOf(pkInfoData.pkResultData.winStreakAddScore));
            }
        }
        if (pkInfoData.pkResultData.finalWinScore != 0) {
            this.hwp.setVisibility(0);
            this.hwo.setVisibility(0);
            if (pkInfoData.pkResultData.finalWinScore > 0) {
                this.hwp.setText(this.context.getString(a.i.sdk_pk_rank_add_score, String.valueOf(pkInfoData.pkResultData.finalWinScore)));
            } else {
                this.hwp.setText(String.valueOf(pkInfoData.pkResultData.finalWinScore));
            }
        }
        if (pkInfoData.pkResultData.roundAddScore != 0) {
            this.hwq.setVisibility(0);
            this.hwr.setVisibility(0);
            this.hwq.setText(this.context.getString(a.i.sdk_pk_rank_total_times, String.valueOf(pkInfoData.pkResultData.roundNum)));
            if (pkInfoData.pkResultData.roundAddScore > 0) {
                this.hwr.setText(this.context.getString(a.i.sdk_pk_rank_add_score, String.valueOf(pkInfoData.pkResultData.roundAddScore)));
            } else {
                this.hwr.setText(String.valueOf(pkInfoData.pkResultData.roundAddScore));
            }
        }
    }

    public void setPkRankView(PkRankView pkRankView) {
        this.gjB = pkRankView;
        this.hwx.setPkRankView(pkRankView);
    }

    public void onDestroy() {
        if (this.gjB.getGetPkInfoModel() != null) {
            this.gjB.getGetPkInfoModel().cdp();
            this.handler.removeMessages(0);
        }
    }
}
