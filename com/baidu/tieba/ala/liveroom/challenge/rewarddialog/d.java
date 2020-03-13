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
    private AlaChallengeRewardData eWQ;
    private com.baidu.live.tieba.pb.interactionpopupwindow.c eWR;
    private TextView eWS;
    private TextView eWT;
    private TextView eWU;
    private TextView eWV;
    private TextView eWW;
    private TextView eWX;
    private TextView eWY;
    private ImageView eWZ;
    private LinearLayout eXa;
    private LinearLayout eXb;
    private LinearLayout eXc;
    private TbImageView eXd;
    private TextView eXe;
    private TextView eXf;
    private TextView eXg;
    private ProgressBar eXh;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
    }

    public void a(com.baidu.live.tieba.pb.interactionpopupwindow.c cVar) {
        this.eWR = cVar;
    }

    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.d
    public int getLayout() {
        return a.h.ala_challenge_reward_dialog;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.d
    public void a(AlaChallengeRewardData alaChallengeRewardData) {
        if (alaChallengeRewardData != null) {
            this.eWQ = alaChallengeRewardData;
            if (this.eWQ.isUseAllIn()) {
                this.eWZ.setVisibility(0);
            } else {
                this.eWZ.setVisibility(8);
            }
            if (!StringHelper.isEmpty(alaChallengeRewardData.mResultDescription)) {
                this.eWT.setText(alaChallengeRewardData.mResultDescription);
                this.eWT.setVisibility(0);
            } else {
                this.eWT.setVisibility(8);
            }
            if (this.eWQ.getChallengeResult() == 2) {
                this.eWS.setText(getTbPageContext().getResources().getString(a.i.ala_pk_success_reward_tip));
            } else if (this.eWQ.getChallengeResult() == 0) {
                this.eWS.setText(getTbPageContext().getResources().getString(a.i.ala_pk_fail_reward_tip));
            } else if (this.eWQ.getChallengeResult() == 1) {
                this.eWS.setText(getTbPageContext().getResources().getString(a.i.ala_pk_tie_reward_tip));
            }
            this.eXb.setVisibility(8);
            if (JavaTypesHelper.toInt(this.eWQ.streakSuccessNum, 0) > 1) {
                this.eXb.setVisibility(0);
                this.eWX.setText(this.eWQ.streakSuccessNum);
            }
            this.eWY.setText(String.format("%s%s", this.eWQ.successRateNum, "%"));
            this.eWU.setText(i.numFormatOverWanNaForAudienceNum(this.eWQ.watcherNum));
            if (this.eWQ.isUseAllIn() && this.eWQ.getChallengeResult() == 2) {
                this.eWV.setText(getTbPageContext().getResources().getString(a.i.ala_pk_reward_charm_num_label, i.numFormatOverWanNaForAudienceNum(this.eWQ.charmNum), this.eWQ.charmExt));
            } else {
                this.eWV.setText(i.numFormatOverWanNaForAudienceNum(this.eWQ.charmNum));
            }
            this.eWW.setText(i.numFormatOverWanNaForAudienceNum(this.eWQ.giftNum));
            if (this.eWQ.challengeLevelScore < 0 || this.eWQ.challengeLevelNextScore <= 0 || this.eWQ.challengeLevelScore > this.eWQ.challengeLevelNextScore) {
                this.eXh.setVisibility(8);
                this.eXf.setVisibility(8);
                this.eXg.setVisibility(8);
                this.eXd.setVisibility(8);
                this.eXe.setVisibility(8);
                return;
            }
            this.eXh.setVisibility(0);
            this.eXf.setVisibility(0);
            this.eXg.setVisibility(0);
            this.eXd.setVisibility(0);
            this.eXe.setVisibility(0);
            this.eXd.startLoad(this.eWQ.challengeLevelIcon, 10, false);
            this.eXe.setText(this.eWQ.challengeLevelName);
            this.eXh.setProgress((int) ((this.eWQ.challengeLevelScore * 100) / this.eWQ.challengeLevelNextScore));
            this.eXf.setText(String.valueOf(this.eWQ.challengeLevelScore));
            this.eXg.setText(String.format("%s%s", "/", Long.valueOf(this.eWQ.challengeLevelNextScore)));
        }
    }

    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.d
    public void initView() {
        this.eXb = (LinearLayout) getViewGroup().findViewById(a.g.reward_streak_win_layout);
        this.eWS = (TextView) getViewGroup().findViewById(a.g.reward_title);
        this.eWT = (TextView) getViewGroup().findViewById(a.g.reward_desc);
        this.eWU = (TextView) getViewGroup().findViewById(a.g.watch_cnt_value);
        this.eWV = (TextView) getViewGroup().findViewById(a.g.charm_value);
        this.eWW = (TextView) getViewGroup().findViewById(a.g.gift_num_value);
        this.eWX = (TextView) getViewGroup().findViewById(a.g.reward_streak_success);
        this.eWY = (TextView) getViewGroup().findViewById(a.g.reward_success_rate);
        this.eWZ = (ImageView) getViewGroup().findViewById(a.g.reward_all_in_icon);
        this.eXc = (LinearLayout) getViewGroup().findViewById(a.g.level_layout);
        this.eXd = (TbImageView) getViewGroup().findViewById(a.g.level_icon);
        this.eXd.setAutoChangeStyle(false);
        this.eXd.setIsNight(false);
        this.eXe = (TextView) getViewGroup().findViewById(a.g.level_name);
        this.eXf = (TextView) getViewGroup().findViewById(a.g.level_cur_exp);
        this.eXg = (TextView) getViewGroup().findViewById(a.g.level_max_exp);
        this.eXh = (ProgressBar) getViewGroup().findViewById(a.g.ala_challenge_level_progress);
        this.eXa = (LinearLayout) getViewGroup().findViewById(a.g.ok);
        this.eXa.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == a.g.ok && this.eWR != null) {
            this.eWR.dismiss();
        }
    }
}
