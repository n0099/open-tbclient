package com.baidu.tieba.ala.liveroom.challenge.rewarddialog;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.live.adp.lib.safe.JavaTypesHelper;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.live.utils.i;
/* loaded from: classes4.dex */
public class d extends com.baidu.live.tieba.pb.interactionpopupwindow.b<AlaChallengeRewardData> implements View.OnClickListener {
    private AlaChallengeRewardData ggY;
    private com.baidu.live.tieba.pb.interactionpopupwindow.c ggZ;
    private TextView gha;
    private TextView ghb;
    private TextView ghc;
    private TextView ghd;
    private TextView ghe;
    private TextView ghf;
    private TextView ghg;
    private ImageView ghh;
    private LinearLayout ghi;
    private LinearLayout ghj;
    private LinearLayout ghk;
    private TbImageView ghl;
    private TextView ghm;
    private TextView ghn;
    private TextView gho;
    private ProgressBar ghp;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
    }

    public void a(com.baidu.live.tieba.pb.interactionpopupwindow.c cVar) {
        this.ggZ = cVar;
    }

    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.d
    public int getLayout() {
        return a.h.ala_challenge_reward_dialog;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.d
    public void a(AlaChallengeRewardData alaChallengeRewardData) {
        if (alaChallengeRewardData != null) {
            this.ggY = alaChallengeRewardData;
            if (this.ggY.isUseAllIn()) {
                this.ghh.setVisibility(0);
            } else {
                this.ghh.setVisibility(8);
            }
            if (!StringHelper.isEmpty(alaChallengeRewardData.mResultDescription)) {
                this.ghb.setText(alaChallengeRewardData.mResultDescription);
                this.ghb.setVisibility(0);
            } else {
                this.ghb.setVisibility(8);
            }
            if (this.ggY.getChallengeResult() == 2) {
                this.gha.setText(getTbPageContext().getResources().getString(a.i.ala_pk_success_reward_tip));
            } else if (this.ggY.getChallengeResult() == 0) {
                this.gha.setText(getTbPageContext().getResources().getString(a.i.ala_pk_fail_reward_tip));
            } else if (this.ggY.getChallengeResult() == 1) {
                this.gha.setText(getTbPageContext().getResources().getString(a.i.ala_pk_tie_reward_tip));
            }
            this.ghj.setVisibility(8);
            if (JavaTypesHelper.toInt(this.ggY.streakSuccessNum, 0) > 1) {
                this.ghj.setVisibility(0);
                this.ghf.setText(this.ggY.streakSuccessNum);
            }
            this.ghg.setText(String.format("%s%s", this.ggY.successRateNum, "%"));
            this.ghc.setText(i.numFormatOverWanNaForAudienceNum(this.ggY.watcherNum));
            if (this.ggY.isUseAllIn() && this.ggY.getChallengeResult() == 2) {
                this.ghd.setText(getTbPageContext().getResources().getString(a.i.ala_pk_reward_charm_num_label, i.numFormatOverWanNaForAudienceNum(this.ggY.charmNum), this.ggY.charmExt));
            } else {
                this.ghd.setText(i.numFormatOverWanNaForAudienceNum(this.ggY.charmNum));
            }
            this.ghe.setText(i.numFormatOverWanNaForAudienceNum(this.ggY.giftNum));
            if (this.ggY.challengeLevelScore < 0 || this.ggY.challengeLevelNextScore <= 0 || this.ggY.challengeLevelScore > this.ggY.challengeLevelNextScore) {
                this.ghp.setVisibility(8);
                this.ghn.setVisibility(8);
                this.gho.setVisibility(8);
                this.ghl.setVisibility(8);
                this.ghm.setVisibility(8);
                return;
            }
            this.ghp.setVisibility(0);
            this.ghn.setVisibility(0);
            this.gho.setVisibility(0);
            this.ghl.setVisibility(0);
            this.ghm.setVisibility(0);
            this.ghl.startLoad(this.ggY.challengeLevelIcon, 10, false);
            this.ghm.setText(this.ggY.challengeLevelName);
            this.ghp.setProgress((int) ((this.ggY.challengeLevelScore * 100) / this.ggY.challengeLevelNextScore));
            this.ghn.setText(String.valueOf(this.ggY.challengeLevelScore));
            this.gho.setText(String.format("%s%s", "/", Long.valueOf(this.ggY.challengeLevelNextScore)));
        }
    }

    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.d
    public void initView() {
        this.ghj = (LinearLayout) getViewGroup().findViewById(a.g.reward_streak_win_layout);
        this.gha = (TextView) getViewGroup().findViewById(a.g.reward_title);
        this.ghb = (TextView) getViewGroup().findViewById(a.g.reward_desc);
        this.ghc = (TextView) getViewGroup().findViewById(a.g.watch_cnt_value);
        this.ghd = (TextView) getViewGroup().findViewById(a.g.charm_value);
        this.ghe = (TextView) getViewGroup().findViewById(a.g.gift_num_value);
        this.ghf = (TextView) getViewGroup().findViewById(a.g.reward_streak_success);
        this.ghg = (TextView) getViewGroup().findViewById(a.g.reward_success_rate);
        this.ghh = (ImageView) getViewGroup().findViewById(a.g.reward_all_in_icon);
        this.ghk = (LinearLayout) getViewGroup().findViewById(a.g.level_layout);
        this.ghl = (TbImageView) getViewGroup().findViewById(a.g.level_icon);
        this.ghl.setAutoChangeStyle(false);
        this.ghl.setIsNight(false);
        this.ghm = (TextView) getViewGroup().findViewById(a.g.level_name);
        this.ghn = (TextView) getViewGroup().findViewById(a.g.level_cur_exp);
        this.gho = (TextView) getViewGroup().findViewById(a.g.level_max_exp);
        this.ghp = (ProgressBar) getViewGroup().findViewById(a.g.ala_challenge_level_progress);
        this.ghi = (LinearLayout) getViewGroup().findViewById(a.g.ok);
        this.ghi.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == a.g.ok && this.ggZ != null) {
            this.ggZ.dismiss();
        }
    }
}
