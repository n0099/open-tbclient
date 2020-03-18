package com.baidu.tieba.ala.liveroom.challenge.rewarddialog;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.live.adp.lib.safe.JavaTypesHelper;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.live.u.a;
import com.baidu.live.utils.i;
/* loaded from: classes3.dex */
public class d extends com.baidu.live.tieba.pb.interactionpopupwindow.b<AlaChallengeRewardData> implements View.OnClickListener {
    private LinearLayout eXA;
    private TbImageView eXB;
    private TextView eXC;
    private TextView eXD;
    private TextView eXE;
    private ProgressBar eXF;
    private AlaChallengeRewardData eXo;
    private com.baidu.live.tieba.pb.interactionpopupwindow.c eXp;
    private TextView eXq;
    private TextView eXr;
    private TextView eXs;
    private TextView eXt;
    private TextView eXu;
    private TextView eXv;
    private TextView eXw;
    private ImageView eXx;
    private LinearLayout eXy;
    private LinearLayout eXz;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
    }

    public void a(com.baidu.live.tieba.pb.interactionpopupwindow.c cVar) {
        this.eXp = cVar;
    }

    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.d
    public int getLayout() {
        return a.h.ala_challenge_reward_dialog;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.d
    public void a(AlaChallengeRewardData alaChallengeRewardData) {
        if (alaChallengeRewardData != null) {
            this.eXo = alaChallengeRewardData;
            if (this.eXo.isUseAllIn()) {
                this.eXx.setVisibility(0);
            } else {
                this.eXx.setVisibility(8);
            }
            if (!StringHelper.isEmpty(alaChallengeRewardData.mResultDescription)) {
                this.eXr.setText(alaChallengeRewardData.mResultDescription);
                this.eXr.setVisibility(0);
            } else {
                this.eXr.setVisibility(8);
            }
            if (this.eXo.getChallengeResult() == 2) {
                this.eXq.setText(getTbPageContext().getResources().getString(a.i.ala_pk_success_reward_tip));
            } else if (this.eXo.getChallengeResult() == 0) {
                this.eXq.setText(getTbPageContext().getResources().getString(a.i.ala_pk_fail_reward_tip));
            } else if (this.eXo.getChallengeResult() == 1) {
                this.eXq.setText(getTbPageContext().getResources().getString(a.i.ala_pk_tie_reward_tip));
            }
            this.eXz.setVisibility(8);
            if (JavaTypesHelper.toInt(this.eXo.streakSuccessNum, 0) > 1) {
                this.eXz.setVisibility(0);
                this.eXv.setText(this.eXo.streakSuccessNum);
            }
            this.eXw.setText(String.format("%s%s", this.eXo.successRateNum, "%"));
            this.eXs.setText(i.numFormatOverWanNaForAudienceNum(this.eXo.watcherNum));
            if (this.eXo.isUseAllIn() && this.eXo.getChallengeResult() == 2) {
                this.eXt.setText(getTbPageContext().getResources().getString(a.i.ala_pk_reward_charm_num_label, i.numFormatOverWanNaForAudienceNum(this.eXo.charmNum), this.eXo.charmExt));
            } else {
                this.eXt.setText(i.numFormatOverWanNaForAudienceNum(this.eXo.charmNum));
            }
            this.eXu.setText(i.numFormatOverWanNaForAudienceNum(this.eXo.giftNum));
            if (this.eXo.challengeLevelScore < 0 || this.eXo.challengeLevelNextScore <= 0 || this.eXo.challengeLevelScore > this.eXo.challengeLevelNextScore) {
                this.eXF.setVisibility(8);
                this.eXD.setVisibility(8);
                this.eXE.setVisibility(8);
                this.eXB.setVisibility(8);
                this.eXC.setVisibility(8);
                return;
            }
            this.eXF.setVisibility(0);
            this.eXD.setVisibility(0);
            this.eXE.setVisibility(0);
            this.eXB.setVisibility(0);
            this.eXC.setVisibility(0);
            this.eXB.startLoad(this.eXo.challengeLevelIcon, 10, false);
            this.eXC.setText(this.eXo.challengeLevelName);
            this.eXF.setProgress((int) ((this.eXo.challengeLevelScore * 100) / this.eXo.challengeLevelNextScore));
            this.eXD.setText(String.valueOf(this.eXo.challengeLevelScore));
            this.eXE.setText(String.format("%s%s", "/", Long.valueOf(this.eXo.challengeLevelNextScore)));
        }
    }

    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.d
    public void initView() {
        this.eXz = (LinearLayout) getViewGroup().findViewById(a.g.reward_streak_win_layout);
        this.eXq = (TextView) getViewGroup().findViewById(a.g.reward_title);
        this.eXr = (TextView) getViewGroup().findViewById(a.g.reward_desc);
        this.eXs = (TextView) getViewGroup().findViewById(a.g.watch_cnt_value);
        this.eXt = (TextView) getViewGroup().findViewById(a.g.charm_value);
        this.eXu = (TextView) getViewGroup().findViewById(a.g.gift_num_value);
        this.eXv = (TextView) getViewGroup().findViewById(a.g.reward_streak_success);
        this.eXw = (TextView) getViewGroup().findViewById(a.g.reward_success_rate);
        this.eXx = (ImageView) getViewGroup().findViewById(a.g.reward_all_in_icon);
        this.eXA = (LinearLayout) getViewGroup().findViewById(a.g.level_layout);
        this.eXB = (TbImageView) getViewGroup().findViewById(a.g.level_icon);
        this.eXB.setAutoChangeStyle(false);
        this.eXB.setIsNight(false);
        this.eXC = (TextView) getViewGroup().findViewById(a.g.level_name);
        this.eXD = (TextView) getViewGroup().findViewById(a.g.level_cur_exp);
        this.eXE = (TextView) getViewGroup().findViewById(a.g.level_max_exp);
        this.eXF = (ProgressBar) getViewGroup().findViewById(a.g.ala_challenge_level_progress);
        this.eXy = (LinearLayout) getViewGroup().findViewById(a.g.ok);
        this.eXy.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == a.g.ok && this.eXp != null) {
            this.eXp.dismiss();
        }
    }
}
