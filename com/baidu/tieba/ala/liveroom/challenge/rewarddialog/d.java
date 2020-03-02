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
    private AlaChallengeRewardData eWD;
    private com.baidu.live.tieba.pb.interactionpopupwindow.c eWE;
    private TextView eWF;
    private TextView eWG;
    private TextView eWH;
    private TextView eWI;
    private TextView eWJ;
    private TextView eWK;
    private TextView eWL;
    private ImageView eWM;
    private LinearLayout eWN;
    private LinearLayout eWO;
    private LinearLayout eWP;
    private TbImageView eWQ;
    private TextView eWR;
    private TextView eWS;
    private TextView eWT;
    private ProgressBar eWU;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
    }

    public void a(com.baidu.live.tieba.pb.interactionpopupwindow.c cVar) {
        this.eWE = cVar;
    }

    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.d
    public int getLayout() {
        return a.h.ala_challenge_reward_dialog;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.d
    public void a(AlaChallengeRewardData alaChallengeRewardData) {
        if (alaChallengeRewardData != null) {
            this.eWD = alaChallengeRewardData;
            if (this.eWD.isUseAllIn()) {
                this.eWM.setVisibility(0);
            } else {
                this.eWM.setVisibility(8);
            }
            if (!StringHelper.isEmpty(alaChallengeRewardData.mResultDescription)) {
                this.eWG.setText(alaChallengeRewardData.mResultDescription);
                this.eWG.setVisibility(0);
            } else {
                this.eWG.setVisibility(8);
            }
            if (this.eWD.getChallengeResult() == 2) {
                this.eWF.setText(getTbPageContext().getResources().getString(a.i.ala_pk_success_reward_tip));
            } else if (this.eWD.getChallengeResult() == 0) {
                this.eWF.setText(getTbPageContext().getResources().getString(a.i.ala_pk_fail_reward_tip));
            } else if (this.eWD.getChallengeResult() == 1) {
                this.eWF.setText(getTbPageContext().getResources().getString(a.i.ala_pk_tie_reward_tip));
            }
            this.eWO.setVisibility(8);
            if (JavaTypesHelper.toInt(this.eWD.streakSuccessNum, 0) > 1) {
                this.eWO.setVisibility(0);
                this.eWK.setText(this.eWD.streakSuccessNum);
            }
            this.eWL.setText(String.format("%s%s", this.eWD.successRateNum, "%"));
            this.eWH.setText(i.numFormatOverWanNaForAudienceNum(this.eWD.watcherNum));
            if (this.eWD.isUseAllIn() && this.eWD.getChallengeResult() == 2) {
                this.eWI.setText(getTbPageContext().getResources().getString(a.i.ala_pk_reward_charm_num_label, i.numFormatOverWanNaForAudienceNum(this.eWD.charmNum), this.eWD.charmExt));
            } else {
                this.eWI.setText(i.numFormatOverWanNaForAudienceNum(this.eWD.charmNum));
            }
            this.eWJ.setText(i.numFormatOverWanNaForAudienceNum(this.eWD.giftNum));
            if (this.eWD.challengeLevelScore < 0 || this.eWD.challengeLevelNextScore <= 0 || this.eWD.challengeLevelScore > this.eWD.challengeLevelNextScore) {
                this.eWU.setVisibility(8);
                this.eWS.setVisibility(8);
                this.eWT.setVisibility(8);
                this.eWQ.setVisibility(8);
                this.eWR.setVisibility(8);
                return;
            }
            this.eWU.setVisibility(0);
            this.eWS.setVisibility(0);
            this.eWT.setVisibility(0);
            this.eWQ.setVisibility(0);
            this.eWR.setVisibility(0);
            this.eWQ.startLoad(this.eWD.challengeLevelIcon, 10, false);
            this.eWR.setText(this.eWD.challengeLevelName);
            this.eWU.setProgress((int) ((this.eWD.challengeLevelScore * 100) / this.eWD.challengeLevelNextScore));
            this.eWS.setText(String.valueOf(this.eWD.challengeLevelScore));
            this.eWT.setText(String.format("%s%s", "/", Long.valueOf(this.eWD.challengeLevelNextScore)));
        }
    }

    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.d
    public void initView() {
        this.eWO = (LinearLayout) getViewGroup().findViewById(a.g.reward_streak_win_layout);
        this.eWF = (TextView) getViewGroup().findViewById(a.g.reward_title);
        this.eWG = (TextView) getViewGroup().findViewById(a.g.reward_desc);
        this.eWH = (TextView) getViewGroup().findViewById(a.g.watch_cnt_value);
        this.eWI = (TextView) getViewGroup().findViewById(a.g.charm_value);
        this.eWJ = (TextView) getViewGroup().findViewById(a.g.gift_num_value);
        this.eWK = (TextView) getViewGroup().findViewById(a.g.reward_streak_success);
        this.eWL = (TextView) getViewGroup().findViewById(a.g.reward_success_rate);
        this.eWM = (ImageView) getViewGroup().findViewById(a.g.reward_all_in_icon);
        this.eWP = (LinearLayout) getViewGroup().findViewById(a.g.level_layout);
        this.eWQ = (TbImageView) getViewGroup().findViewById(a.g.level_icon);
        this.eWQ.setAutoChangeStyle(false);
        this.eWQ.setIsNight(false);
        this.eWR = (TextView) getViewGroup().findViewById(a.g.level_name);
        this.eWS = (TextView) getViewGroup().findViewById(a.g.level_cur_exp);
        this.eWT = (TextView) getViewGroup().findViewById(a.g.level_max_exp);
        this.eWU = (ProgressBar) getViewGroup().findViewById(a.g.ala_challenge_level_progress);
        this.eWN = (LinearLayout) getViewGroup().findViewById(a.g.ok);
        this.eWN.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == a.g.ok && this.eWE != null) {
            this.eWE.dismiss();
        }
    }
}
