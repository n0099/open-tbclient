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
    private AlaChallengeRewardData eWC;
    private com.baidu.live.tieba.pb.interactionpopupwindow.c eWD;
    private TextView eWE;
    private TextView eWF;
    private TextView eWG;
    private TextView eWH;
    private TextView eWI;
    private TextView eWJ;
    private TextView eWK;
    private ImageView eWL;
    private LinearLayout eWM;
    private LinearLayout eWN;
    private LinearLayout eWO;
    private TbImageView eWP;
    private TextView eWQ;
    private TextView eWR;
    private TextView eWS;
    private ProgressBar eWT;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
    }

    public void a(com.baidu.live.tieba.pb.interactionpopupwindow.c cVar) {
        this.eWD = cVar;
    }

    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.d
    public int getLayout() {
        return a.h.ala_challenge_reward_dialog;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.d
    public void a(AlaChallengeRewardData alaChallengeRewardData) {
        if (alaChallengeRewardData != null) {
            this.eWC = alaChallengeRewardData;
            if (this.eWC.isUseAllIn()) {
                this.eWL.setVisibility(0);
            } else {
                this.eWL.setVisibility(8);
            }
            if (!StringHelper.isEmpty(alaChallengeRewardData.mResultDescription)) {
                this.eWF.setText(alaChallengeRewardData.mResultDescription);
                this.eWF.setVisibility(0);
            } else {
                this.eWF.setVisibility(8);
            }
            if (this.eWC.getChallengeResult() == 2) {
                this.eWE.setText(getTbPageContext().getResources().getString(a.i.ala_pk_success_reward_tip));
            } else if (this.eWC.getChallengeResult() == 0) {
                this.eWE.setText(getTbPageContext().getResources().getString(a.i.ala_pk_fail_reward_tip));
            } else if (this.eWC.getChallengeResult() == 1) {
                this.eWE.setText(getTbPageContext().getResources().getString(a.i.ala_pk_tie_reward_tip));
            }
            this.eWN.setVisibility(8);
            if (JavaTypesHelper.toInt(this.eWC.streakSuccessNum, 0) > 1) {
                this.eWN.setVisibility(0);
                this.eWJ.setText(this.eWC.streakSuccessNum);
            }
            this.eWK.setText(String.format("%s%s", this.eWC.successRateNum, "%"));
            this.eWG.setText(i.numFormatOverWanNaForAudienceNum(this.eWC.watcherNum));
            if (this.eWC.isUseAllIn() && this.eWC.getChallengeResult() == 2) {
                this.eWH.setText(getTbPageContext().getResources().getString(a.i.ala_pk_reward_charm_num_label, i.numFormatOverWanNaForAudienceNum(this.eWC.charmNum), this.eWC.charmExt));
            } else {
                this.eWH.setText(i.numFormatOverWanNaForAudienceNum(this.eWC.charmNum));
            }
            this.eWI.setText(i.numFormatOverWanNaForAudienceNum(this.eWC.giftNum));
            if (this.eWC.challengeLevelScore < 0 || this.eWC.challengeLevelNextScore <= 0 || this.eWC.challengeLevelScore > this.eWC.challengeLevelNextScore) {
                this.eWT.setVisibility(8);
                this.eWR.setVisibility(8);
                this.eWS.setVisibility(8);
                this.eWP.setVisibility(8);
                this.eWQ.setVisibility(8);
                return;
            }
            this.eWT.setVisibility(0);
            this.eWR.setVisibility(0);
            this.eWS.setVisibility(0);
            this.eWP.setVisibility(0);
            this.eWQ.setVisibility(0);
            this.eWP.startLoad(this.eWC.challengeLevelIcon, 10, false);
            this.eWQ.setText(this.eWC.challengeLevelName);
            this.eWT.setProgress((int) ((this.eWC.challengeLevelScore * 100) / this.eWC.challengeLevelNextScore));
            this.eWR.setText(String.valueOf(this.eWC.challengeLevelScore));
            this.eWS.setText(String.format("%s%s", "/", Long.valueOf(this.eWC.challengeLevelNextScore)));
        }
    }

    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.d
    public void initView() {
        this.eWN = (LinearLayout) getViewGroup().findViewById(a.g.reward_streak_win_layout);
        this.eWE = (TextView) getViewGroup().findViewById(a.g.reward_title);
        this.eWF = (TextView) getViewGroup().findViewById(a.g.reward_desc);
        this.eWG = (TextView) getViewGroup().findViewById(a.g.watch_cnt_value);
        this.eWH = (TextView) getViewGroup().findViewById(a.g.charm_value);
        this.eWI = (TextView) getViewGroup().findViewById(a.g.gift_num_value);
        this.eWJ = (TextView) getViewGroup().findViewById(a.g.reward_streak_success);
        this.eWK = (TextView) getViewGroup().findViewById(a.g.reward_success_rate);
        this.eWL = (ImageView) getViewGroup().findViewById(a.g.reward_all_in_icon);
        this.eWO = (LinearLayout) getViewGroup().findViewById(a.g.level_layout);
        this.eWP = (TbImageView) getViewGroup().findViewById(a.g.level_icon);
        this.eWP.setAutoChangeStyle(false);
        this.eWP.setIsNight(false);
        this.eWQ = (TextView) getViewGroup().findViewById(a.g.level_name);
        this.eWR = (TextView) getViewGroup().findViewById(a.g.level_cur_exp);
        this.eWS = (TextView) getViewGroup().findViewById(a.g.level_max_exp);
        this.eWT = (ProgressBar) getViewGroup().findViewById(a.g.ala_challenge_level_progress);
        this.eWM = (LinearLayout) getViewGroup().findViewById(a.g.ok);
        this.eWM.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == a.g.ok && this.eWD != null) {
            this.eWD.dismiss();
        }
    }
}
