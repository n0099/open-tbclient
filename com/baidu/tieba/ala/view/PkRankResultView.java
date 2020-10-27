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
    private PkRankView gtC;
    private RelativeLayout hIA;
    private RelativeLayout hIB;
    private ViewFlipper hIC;
    private TextView hID;
    private TextView hIE;
    private TextView hIF;
    private TextView hIG;
    private TextView hIH;
    private TextView hII;
    private TextView hIJ;
    private TextView hIK;
    private TextView hIL;
    private TextView hIM;
    private TextView hIN;
    private TextView hIO;
    private TbImageView hIP;
    private LinearLayout hIQ;
    private SeekBar hIR;
    private TextView hIS;
    private TextView hIT;
    PkRankMvpView hIU;
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
        this.mView = LayoutInflater.from(getContext()).inflate(a.h.sdk_rank_result_layout, (ViewGroup) this, true);
        this.hIA = (RelativeLayout) this.mView.findViewById(a.g.result_layout);
        this.hIB = (RelativeLayout) this.mView.findViewById(a.g.title_layout);
        this.hID = (TextView) this.mView.findViewById(a.g.wins_title);
        this.hIE = (TextView) this.mView.findViewById(a.g.score_title);
        this.hIC = (ViewFlipper) this.mView.findViewById(a.g.view_flipper);
        this.hIC.setInAnimation(AnimationUtils.loadAnimation(this.context, a.C0195a.pk_rank_slide_in_left));
        this.hIC.setOutAnimation(AnimationUtils.loadAnimation(this.context, a.C0195a.pk_rank_slide_out_right));
        this.hIU = (PkRankMvpView) this.mView.findViewById(a.g.mvp_view);
        cjx();
    }

    private void cjO() {
        View inflate = LayoutInflater.from(getContext()).inflate(a.h.sdk_rank_result_score_layout, (ViewGroup) null);
        this.hIF = (TextView) inflate.findViewById(a.g.result);
        this.hIG = (TextView) inflate.findViewById(a.g.result_score);
        this.hIH = (TextView) inflate.findViewById(a.g.glory);
        this.hII = (TextView) inflate.findViewById(a.g.glory_score);
        this.hIJ = (TextView) inflate.findViewById(a.g.wins);
        this.hIK = (TextView) inflate.findViewById(a.g.wins_score);
        this.hIL = (TextView) inflate.findViewById(a.g.shut_down);
        this.hIM = (TextView) inflate.findViewById(a.g.shut_down_score);
        this.hIN = (TextView) inflate.findViewById(a.g.total_times);
        this.hIO = (TextView) inflate.findViewById(a.g.total_times_score);
        this.hIC.addView(inflate);
    }

    private void cjP() {
        View inflate = LayoutInflater.from(getContext()).inflate(a.h.sdk_rank_result_rank_layout, (ViewGroup) null);
        this.hIP = (TbImageView) inflate.findViewById(a.g.rank_view);
        this.hIQ = (LinearLayout) inflate.findViewById(a.g.star_layout);
        this.hIR = (SeekBar) inflate.findViewById(a.g.rank_progress);
        this.hIS = (TextView) inflate.findViewById(a.g.rank_get_score);
        this.hIT = (TextView) inflate.findViewById(a.g.rank_total_score);
        this.hIC.addView(inflate);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cjx() {
        this.hIA.setVisibility(8);
        this.hIB.setVisibility(8);
        this.hIC.setVisibility(8);
        this.hIU.setVisibility(8);
    }

    public void b(PkInfoData pkInfoData, int i) {
        this.gtC.ckc();
        if (this.gtC.wA(i) && !this.isShowing) {
            g(pkInfoData);
        }
    }

    private void g(final PkInfoData pkInfoData) {
        cjx();
        this.hIA.setVisibility(0);
        h(pkInfoData);
        this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.view.PkRankResultView.1
            @Override // java.lang.Runnable
            public void run() {
                PkRankResultView.this.cjQ();
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
                    PkRankResultView.this.gtC.hJn.wy(0);
                    PkRankResultView.this.cjx();
                }
            }, pkInfoData.showScoreTime + pkInfoData.showRankTime + pkInfoData.showMvpTime);
        } else {
            this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.view.PkRankResultView.4
                @Override // java.lang.Runnable
                public void run() {
                    PkRankResultView.this.gtC.hJn.wy(0);
                    PkRankResultView.this.cjx();
                }
            }, pkInfoData.showScoreTime + pkInfoData.showRankTime);
        }
        this.isShowing = true;
    }

    private void h(PkInfoData pkInfoData) {
        this.hIB.setVisibility(0);
        this.hIC.setVisibility(0);
        this.hIC.removeAllViews();
        cjO();
        cjP();
        k(pkInfoData);
        j(pkInfoData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cjQ() {
        this.hIC.showNext();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(PkInfoData pkInfoData) {
        this.hIB.setVisibility(8);
        this.hIC.setVisibility(8);
        this.hIU.setVisibility(0);
        this.hIU.e(pkInfoData);
    }

    private void j(PkInfoData pkInfoData) {
        boolean z = pkInfoData.pkResultData.rankType.equals("king");
        this.hIP.startLoad(pkInfoData.pkResultData.rankImageUrl, 10, false);
        this.hIQ.removeAllViews();
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(BdUtilHelper.getDimens(this.context, a.e.sdk_ds16), BdUtilHelper.getDimens(this.context, a.e.sdk_ds16));
        layoutParams.rightMargin = BdUtilHelper.getDimens(this.context, a.e.sdk_ds4);
        layoutParams.gravity = 16;
        for (int i = 0; i < pkInfoData.pkResultData.currentStar; i++) {
            this.hIQ.addView(getSolidStarView(), layoutParams);
        }
        for (int i2 = 0; i2 < pkInfoData.pkResultData.maxStar - pkInfoData.pkResultData.currentStar; i2++) {
            this.hIQ.addView(getBlankStarView(), layoutParams);
        }
        if (z) {
            this.hIR.setVisibility(8);
            this.hIS.setVisibility(8);
            this.hIT.setVisibility(8);
            return;
        }
        this.hIR.setProgress((int) (((pkInfoData.pkResultData.rankScore - pkInfoData.pkResultData.rankMinScore) / pkInfoData.pkResultData.rankMaxScore) * 100.0d));
        this.hIS.setText(String.valueOf(pkInfoData.pkResultData.rankScore));
        this.hIT.setText(String.valueOf(pkInfoData.pkResultData.rankMaxScore));
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
            this.hIE.setText(this.context.getString(a.i.sdk_pk_rank_this_total, String.valueOf(pkInfoData.pkResultData.totalScore)));
        } else {
            this.hIE.setText(this.context.getString(a.i.sdk_pk_rank_this_total_fu, String.valueOf(pkInfoData.pkResultData.totalScore)));
        }
        if (pkInfoData.pkResultData.resultScore != 0) {
            this.hIF.setVisibility(0);
            this.hIG.setVisibility(0);
            switch (pkInfoData.pkResultData.resultType) {
                case 1:
                    if (pkInfoData.pkResultData.winStreakNum < 2) {
                        this.hID.setText(a.i.sdk_pk_rank_win_title);
                    } else {
                        this.hID.setText(this.context.getString(a.i.sdk_pk_rank_wins_title, String.valueOf(pkInfoData.pkResultData.winStreakNum)));
                    }
                    this.hIF.setText(a.i.sdk_pk_rank_win);
                    this.hID.setTextColor(-5376);
                    break;
                case 2:
                    this.hID.setText(a.i.sdk_pk_rank_loss);
                    this.hID.setTextColor(-1513240);
                    this.hIF.setText(a.i.sdk_pk_rank_loss);
                    break;
                case 3:
                    this.hIF.setText(a.i.sdk_pk_rank_tied);
                    this.hID.setTextColor(-10955153);
                    this.hID.setText(a.i.sdk_pk_rank_tied);
                    break;
            }
            if (pkInfoData.pkResultData.resultScore > 0) {
                this.hIG.setText(this.context.getString(a.i.sdk_pk_rank_add_score, String.valueOf(pkInfoData.pkResultData.resultScore)));
            } else {
                this.hIG.setText(String.valueOf(pkInfoData.pkResultData.resultScore));
            }
        }
        if (pkInfoData.pkResultData.honorAddScore != 0) {
            this.hIH.setVisibility(0);
            this.hII.setVisibility(0);
            this.hIH.setText(this.context.getString(a.i.sdk_pk_rank_win_score, String.valueOf(pkInfoData.pkResultData.honorNum)));
            if (pkInfoData.pkResultData.honorAddScore > 0) {
                this.hII.setText(this.context.getString(a.i.sdk_pk_rank_add_score, String.valueOf(pkInfoData.pkResultData.honorAddScore)));
            } else {
                this.hII.setText(String.valueOf(pkInfoData.pkResultData.honorAddScore));
            }
        }
        if (pkInfoData.pkResultData.winStreakAddScore != 0) {
            this.hIJ.setVisibility(0);
            this.hIK.setVisibility(0);
            this.hIJ.setText(this.context.getString(a.i.sdk_pk_rank_wins, String.valueOf(pkInfoData.pkResultData.winStreakNum2)));
            if (pkInfoData.pkResultData.winStreakAddScore > 0) {
                this.hIK.setText(this.context.getString(a.i.sdk_pk_rank_add_score, String.valueOf(pkInfoData.pkResultData.winStreakAddScore)));
            } else {
                this.hIK.setText(String.valueOf(pkInfoData.pkResultData.winStreakAddScore));
            }
        }
        if (pkInfoData.pkResultData.finalWinScore != 0) {
            this.hIM.setVisibility(0);
            this.hIL.setVisibility(0);
            if (pkInfoData.pkResultData.finalWinScore > 0) {
                this.hIM.setText(this.context.getString(a.i.sdk_pk_rank_add_score, String.valueOf(pkInfoData.pkResultData.finalWinScore)));
            } else {
                this.hIM.setText(String.valueOf(pkInfoData.pkResultData.finalWinScore));
            }
        }
        if (pkInfoData.pkResultData.roundAddScore != 0) {
            this.hIN.setVisibility(0);
            this.hIO.setVisibility(0);
            this.hIN.setText(this.context.getString(a.i.sdk_pk_rank_total_times, String.valueOf(pkInfoData.pkResultData.roundNum)));
            if (pkInfoData.pkResultData.roundAddScore > 0) {
                this.hIO.setText(this.context.getString(a.i.sdk_pk_rank_add_score, String.valueOf(pkInfoData.pkResultData.roundAddScore)));
            } else {
                this.hIO.setText(String.valueOf(pkInfoData.pkResultData.roundAddScore));
            }
        }
    }

    public void setPkRankView(PkRankView pkRankView) {
        this.gtC = pkRankView;
        this.hIU.setPkRankView(pkRankView);
    }

    public void onDestroy() {
        if (this.gtC.getGetPkInfoModel() != null) {
            this.gtC.getGetPkInfoModel().cgr();
            this.handler.removeMessages(0);
        }
    }
}
