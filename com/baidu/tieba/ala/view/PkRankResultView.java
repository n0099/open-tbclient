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
    private PkRankView gTG;
    private Handler handler;
    private TextView ioA;
    private TextView ioB;
    private TextView ioC;
    private TextView ioD;
    private TextView ioE;
    private TbImageView ioF;
    private LinearLayout ioG;
    private SeekBar ioH;
    private TextView ioI;
    private TextView ioJ;
    PkRankMvpView ioK;
    private RelativeLayout iom;
    private RelativeLayout ion;
    private ViewFlipper ioo;
    private TextView iop;
    private TextView ioq;
    private TextView ior;
    private TextView ios;
    private TextView iot;
    private TextView iou;
    private TextView iov;
    private TextView iow;
    private TextView iox;
    private TextView ioy;
    private TextView ioz;
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
        this.iom = (RelativeLayout) this.mView.findViewById(a.f.result_layout);
        this.ion = (RelativeLayout) this.mView.findViewById(a.f.title_layout);
        this.iop = (TextView) this.mView.findViewById(a.f.wins_title);
        this.ioq = (TextView) this.mView.findViewById(a.f.score_title);
        this.ioo = (ViewFlipper) this.mView.findViewById(a.f.view_flipper);
        this.ioo.setInAnimation(AnimationUtils.loadAnimation(this.context, a.C0201a.pk_rank_slide_in_left));
        this.ioo.setOutAnimation(AnimationUtils.loadAnimation(this.context, a.C0201a.pk_rank_slide_out_right));
        this.ioK = (PkRankMvpView) this.mView.findViewById(a.f.mvp_view);
        cqc();
    }

    private void cqv() {
        View inflate = LayoutInflater.from(getContext()).inflate(a.g.sdk_rank_result_score_layout, (ViewGroup) null);
        this.ior = (TextView) inflate.findViewById(a.f.result);
        this.ios = (TextView) inflate.findViewById(a.f.result_score);
        this.iot = (TextView) inflate.findViewById(a.f.division_name);
        this.iou = (TextView) inflate.findViewById(a.f.division_score);
        this.iov = (TextView) inflate.findViewById(a.f.kill_name);
        this.iow = (TextView) inflate.findViewById(a.f.kill_score);
        this.iox = (TextView) inflate.findViewById(a.f.glory);
        this.ioy = (TextView) inflate.findViewById(a.f.glory_score);
        this.ioz = (TextView) inflate.findViewById(a.f.wins);
        this.ioA = (TextView) inflate.findViewById(a.f.wins_score);
        this.ioB = (TextView) inflate.findViewById(a.f.shut_down);
        this.ioC = (TextView) inflate.findViewById(a.f.shut_down_score);
        this.ioD = (TextView) inflate.findViewById(a.f.total_times);
        this.ioE = (TextView) inflate.findViewById(a.f.total_times_score);
        this.ioo.addView(inflate);
    }

    private void cqw() {
        View inflate = LayoutInflater.from(getContext()).inflate(a.g.sdk_rank_result_rank_layout, (ViewGroup) null);
        this.ioF = (TbImageView) inflate.findViewById(a.f.rank_view);
        this.ioG = (LinearLayout) inflate.findViewById(a.f.star_layout);
        this.ioH = (SeekBar) inflate.findViewById(a.f.rank_progress);
        this.ioI = (TextView) inflate.findViewById(a.f.rank_get_score);
        this.ioJ = (TextView) inflate.findViewById(a.f.rank_total_score);
        this.ioo.addView(inflate);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cqc() {
        this.iom.setVisibility(8);
        this.ion.setVisibility(8);
        this.ioo.setVisibility(8);
        this.ioK.setVisibility(8);
    }

    public void b(PkInfoData pkInfoData, int i) {
        this.gTG.cqH();
        if (this.gTG.wK(i) && !this.isShowing) {
            h(pkInfoData);
        }
    }

    private void h(final PkInfoData pkInfoData) {
        cqc();
        this.iom.setVisibility(0);
        i(pkInfoData);
        this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.view.PkRankResultView.1
            @Override // java.lang.Runnable
            public void run() {
                PkRankResultView.this.cqx();
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
                    PkRankResultView.this.gTG.ipd.wI(0);
                    PkRankResultView.this.cqc();
                }
            }, pkInfoData.showScoreTime + pkInfoData.showRankTime + pkInfoData.showMvpTime);
        } else {
            this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.view.PkRankResultView.4
                @Override // java.lang.Runnable
                public void run() {
                    PkRankResultView.this.gTG.ipd.wI(0);
                    PkRankResultView.this.cqc();
                }
            }, pkInfoData.showScoreTime + pkInfoData.showRankTime);
        }
        this.isShowing = true;
    }

    private void i(PkInfoData pkInfoData) {
        this.ion.setVisibility(0);
        this.ioo.setVisibility(0);
        this.ioo.removeAllViews();
        cqv();
        cqw();
        l(pkInfoData);
        k(pkInfoData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cqx() {
        this.ioo.showNext();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(PkInfoData pkInfoData) {
        this.ion.setVisibility(8);
        this.ioo.setVisibility(8);
        this.ioK.setVisibility(0);
        this.ioK.f(pkInfoData);
    }

    private void k(PkInfoData pkInfoData) {
        boolean z = pkInfoData.pkResultData.rankType.equals("king");
        this.ioF.startLoad(pkInfoData.pkResultData.rankImageUrl, 10, false);
        this.ioG.removeAllViews();
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(BdUtilHelper.getDimens(this.context, a.d.sdk_ds16), BdUtilHelper.getDimens(this.context, a.d.sdk_ds16));
        layoutParams.rightMargin = BdUtilHelper.getDimens(this.context, a.d.sdk_ds4);
        layoutParams.gravity = 16;
        for (int i = 0; i < pkInfoData.pkResultData.currentStar; i++) {
            this.ioG.addView(getSolidStarView(), layoutParams);
        }
        for (int i2 = 0; i2 < pkInfoData.pkResultData.maxStar - pkInfoData.pkResultData.currentStar; i2++) {
            this.ioG.addView(getBlankStarView(), layoutParams);
        }
        if (z) {
            this.ioH.setVisibility(8);
            this.ioI.setVisibility(8);
            this.ioJ.setVisibility(8);
            return;
        }
        this.ioH.setProgress((int) (((pkInfoData.pkResultData.rankScore - pkInfoData.pkResultData.rankMinScore) / pkInfoData.pkResultData.rankMaxScore) * 100.0d));
        this.ioI.setText(String.valueOf(pkInfoData.pkResultData.rankScore));
        this.ioJ.setText(String.valueOf(pkInfoData.pkResultData.rankMaxScore));
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
            this.ioq.setText(this.context.getString(a.h.sdk_pk_rank_this_total, String.valueOf(pkInfoData.pkResultData.totalScore)));
        } else {
            this.ioq.setText(this.context.getString(a.h.sdk_pk_rank_this_total_fu, String.valueOf(pkInfoData.pkResultData.totalScore)));
        }
        if (pkInfoData.pkResultData.resultScore != 0) {
            this.ior.setVisibility(0);
            this.ios.setVisibility(0);
            switch (pkInfoData.pkResultData.resultType) {
                case 1:
                    if (pkInfoData.pkResultData.winStreakNum < 2) {
                        this.iop.setText(a.h.sdk_pk_rank_win_title);
                    } else {
                        this.iop.setText(this.context.getString(a.h.sdk_pk_rank_wins_title, String.valueOf(pkInfoData.pkResultData.winStreakNum)));
                    }
                    this.ior.setText(a.h.sdk_pk_rank_win);
                    this.iop.setTextColor(-5376);
                    break;
                case 2:
                    this.iop.setText(a.h.sdk_pk_rank_loss);
                    this.iop.setTextColor(-1513240);
                    this.ior.setText(a.h.sdk_pk_rank_loss);
                    break;
                case 3:
                    this.ior.setText(a.h.sdk_pk_rank_tied);
                    this.iop.setTextColor(-10955153);
                    this.iop.setText(a.h.sdk_pk_rank_tied);
                    break;
            }
            if (pkInfoData.pkResultData.resultScore > 0) {
                this.ios.setText(this.context.getString(a.h.sdk_pk_rank_add_score, String.valueOf(pkInfoData.pkResultData.resultScore)));
            } else {
                this.ios.setText(String.valueOf(pkInfoData.pkResultData.resultScore));
            }
        }
        if (pkInfoData.pkResultData.divisionAddScore != 0) {
            this.iot.setVisibility(0);
            this.iou.setVisibility(0);
            if (pkInfoData.pkResultData.divisionType > 2) {
                this.iot.setText("以弱胜强");
            } else {
                this.iot.setText("针锋相对");
            }
            if (pkInfoData.pkResultData.divisionAddScore > 0) {
                this.iou.setText(this.context.getString(a.h.sdk_pk_rank_add_score, String.valueOf(pkInfoData.pkResultData.divisionAddScore)));
            } else {
                this.iou.setText(String.valueOf(pkInfoData.pkResultData.divisionAddScore));
            }
        }
        if (pkInfoData.pkResultData.killScore != 0 || pkInfoData.pkResultData.antiKillScore != 0) {
            this.iov.setVisibility(0);
            this.iow.setVisibility(0);
            if (pkInfoData.pkResultData.killScore > 0) {
                this.iov.setText("KO加分");
                j = pkInfoData.pkResultData.killScore;
            } else {
                j = 0;
            }
            if (pkInfoData.pkResultData.antiKillScore > 0) {
                this.iov.setText("反杀加分");
                j = pkInfoData.pkResultData.antiKillScore;
            }
            if (j > 0) {
                this.iow.setText(this.context.getString(a.h.sdk_pk_rank_add_score, String.valueOf(j)));
            } else {
                this.iow.setText(String.valueOf(j));
            }
        }
        if (pkInfoData.pkResultData.honorAddScore != 0) {
            this.iox.setVisibility(0);
            this.ioy.setVisibility(0);
            this.iox.setText(this.context.getString(a.h.sdk_pk_rank_win_score, String.valueOf(pkInfoData.pkResultData.honorNum)));
            if (pkInfoData.pkResultData.honorAddScore > 0) {
                this.ioy.setText(this.context.getString(a.h.sdk_pk_rank_add_score, String.valueOf(pkInfoData.pkResultData.honorAddScore)));
            } else {
                this.ioy.setText(String.valueOf(pkInfoData.pkResultData.honorAddScore));
            }
        }
        if (pkInfoData.pkResultData.winStreakAddScore != 0) {
            this.ioz.setVisibility(0);
            this.ioA.setVisibility(0);
            this.ioz.setText(this.context.getString(a.h.sdk_pk_rank_wins, String.valueOf(pkInfoData.pkResultData.winStreakNum2)));
            if (pkInfoData.pkResultData.winStreakAddScore > 0) {
                this.ioA.setText(this.context.getString(a.h.sdk_pk_rank_add_score, String.valueOf(pkInfoData.pkResultData.winStreakAddScore)));
            } else {
                this.ioA.setText(String.valueOf(pkInfoData.pkResultData.winStreakAddScore));
            }
        }
        if (pkInfoData.pkResultData.finalWinScore != 0) {
            this.ioC.setVisibility(0);
            this.ioB.setVisibility(0);
            if (pkInfoData.pkResultData.finalWinScore > 0) {
                this.ioC.setText(this.context.getString(a.h.sdk_pk_rank_add_score, String.valueOf(pkInfoData.pkResultData.finalWinScore)));
            } else {
                this.ioC.setText(String.valueOf(pkInfoData.pkResultData.finalWinScore));
            }
        }
        if (pkInfoData.pkResultData.roundAddScore != 0) {
            this.ioD.setVisibility(0);
            this.ioE.setVisibility(0);
            this.ioD.setText(this.context.getString(a.h.sdk_pk_rank_total_times, String.valueOf(pkInfoData.pkResultData.roundNum)));
            if (pkInfoData.pkResultData.roundAddScore > 0) {
                this.ioE.setText(this.context.getString(a.h.sdk_pk_rank_add_score, String.valueOf(pkInfoData.pkResultData.roundAddScore)));
            } else {
                this.ioE.setText(String.valueOf(pkInfoData.pkResultData.roundAddScore));
            }
        }
    }

    public void setPkRankView(PkRankView pkRankView) {
        this.gTG = pkRankView;
        this.ioK.setPkRankView(pkRankView);
    }

    public void onDestroy() {
        if (this.gTG.getGetPkInfoModel() != null) {
            this.gTG.getGetPkInfoModel().cms();
            this.handler.removeMessages(0);
        }
    }
}
