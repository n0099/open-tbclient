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
import com.baidu.live.utils.j;
/* loaded from: classes4.dex */
public class d extends com.baidu.live.tieba.pb.interactionpopupwindow.b<AlaChallengeRewardData> implements View.OnClickListener {
    private AlaChallengeRewardData gXa;
    private com.baidu.live.tieba.pb.interactionpopupwindow.c gXb;
    private TextView gXc;
    private TextView gXd;
    private TextView gXe;
    private TextView gXf;
    private TextView gXg;
    private TextView gXh;
    private TextView gXi;
    private ImageView gXj;
    private LinearLayout gXk;
    private LinearLayout gXl;
    private LinearLayout gXm;
    private TbImageView gXn;
    private TextView gXo;
    private TextView gXp;
    private TextView gXq;
    private ProgressBar gXr;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
    }

    public void a(com.baidu.live.tieba.pb.interactionpopupwindow.c cVar) {
        this.gXb = cVar;
    }

    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.d
    public int getLayout() {
        return a.h.ala_challenge_reward_dialog;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.d
    public void a(AlaChallengeRewardData alaChallengeRewardData) {
        if (alaChallengeRewardData != null) {
            this.gXa = alaChallengeRewardData;
            if (this.gXa.isUseAllIn()) {
                this.gXj.setVisibility(0);
            } else {
                this.gXj.setVisibility(8);
            }
            if (!StringHelper.isEmpty(alaChallengeRewardData.mResultDescription)) {
                this.gXd.setText(alaChallengeRewardData.mResultDescription);
                this.gXd.setVisibility(0);
            } else {
                this.gXd.setVisibility(8);
            }
            if (this.gXa.getChallengeResult() == 2) {
                this.gXc.setText(getTbPageContext().getResources().getString(a.i.ala_pk_success_reward_tip));
            } else if (this.gXa.getChallengeResult() == 0) {
                this.gXc.setText(getTbPageContext().getResources().getString(a.i.ala_pk_fail_reward_tip));
            } else if (this.gXa.getChallengeResult() == 1) {
                this.gXc.setText(getTbPageContext().getResources().getString(a.i.ala_pk_tie_reward_tip));
            }
            this.gXl.setVisibility(8);
            if (JavaTypesHelper.toInt(this.gXa.streakSuccessNum, 0) > 1) {
                this.gXl.setVisibility(0);
                this.gXh.setText(this.gXa.streakSuccessNum);
            }
            this.gXi.setText(String.format("%s%s", this.gXa.successRateNum, "%"));
            this.gXe.setText(j.numFormatOverWanNaForAudienceNum(this.gXa.watcherNum));
            if (this.gXa.isUseAllIn() && this.gXa.getChallengeResult() == 2) {
                this.gXf.setText(getTbPageContext().getResources().getString(a.i.ala_pk_reward_charm_num_label, j.numFormatOverWanNaForAudienceNum(this.gXa.charmNum), this.gXa.charmExt));
            } else {
                this.gXf.setText(j.numFormatOverWanNaForAudienceNum(this.gXa.charmNum));
            }
            this.gXg.setText(j.numFormatOverWanNaForAudienceNum(this.gXa.giftNum));
            if (this.gXa.challengeLevelScore < 0 || this.gXa.challengeLevelNextScore <= 0 || this.gXa.challengeLevelScore > this.gXa.challengeLevelNextScore) {
                this.gXr.setVisibility(8);
                this.gXp.setVisibility(8);
                this.gXq.setVisibility(8);
                this.gXn.setVisibility(8);
                this.gXo.setVisibility(8);
                return;
            }
            this.gXr.setVisibility(0);
            this.gXp.setVisibility(0);
            this.gXq.setVisibility(0);
            this.gXn.setVisibility(0);
            this.gXo.setVisibility(0);
            this.gXn.startLoad(this.gXa.challengeLevelIcon, 10, false);
            this.gXo.setText(this.gXa.challengeLevelName);
            this.gXr.setProgress((int) ((this.gXa.challengeLevelScore * 100) / this.gXa.challengeLevelNextScore));
            this.gXp.setText(String.valueOf(this.gXa.challengeLevelScore));
            this.gXq.setText(String.format("%s%s", "/", Long.valueOf(this.gXa.challengeLevelNextScore)));
        }
    }

    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.d
    public void initView() {
        this.gXl = (LinearLayout) getViewGroup().findViewById(a.g.reward_streak_win_layout);
        this.gXc = (TextView) getViewGroup().findViewById(a.g.reward_title);
        this.gXd = (TextView) getViewGroup().findViewById(a.g.reward_desc);
        this.gXe = (TextView) getViewGroup().findViewById(a.g.watch_cnt_value);
        this.gXf = (TextView) getViewGroup().findViewById(a.g.charm_value);
        this.gXg = (TextView) getViewGroup().findViewById(a.g.gift_num_value);
        this.gXh = (TextView) getViewGroup().findViewById(a.g.reward_streak_success);
        this.gXi = (TextView) getViewGroup().findViewById(a.g.reward_success_rate);
        this.gXj = (ImageView) getViewGroup().findViewById(a.g.reward_all_in_icon);
        this.gXm = (LinearLayout) getViewGroup().findViewById(a.g.level_layout);
        this.gXn = (TbImageView) getViewGroup().findViewById(a.g.level_icon);
        this.gXn.setAutoChangeStyle(false);
        this.gXn.setIsNight(false);
        this.gXo = (TextView) getViewGroup().findViewById(a.g.level_name);
        this.gXp = (TextView) getViewGroup().findViewById(a.g.level_cur_exp);
        this.gXq = (TextView) getViewGroup().findViewById(a.g.level_max_exp);
        this.gXr = (ProgressBar) getViewGroup().findViewById(a.g.ala_challenge_level_progress);
        this.gXk = (LinearLayout) getViewGroup().findViewById(a.g.ok);
        this.gXk.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == a.g.ok && this.gXb != null) {
            this.gXb.dismiss();
        }
    }
}
