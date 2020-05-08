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
    private AlaChallengeRewardData fBG;
    private com.baidu.live.tieba.pb.interactionpopupwindow.c fBH;
    private TextView fBI;
    private TextView fBJ;
    private TextView fBK;
    private TextView fBL;
    private TextView fBM;
    private TextView fBN;
    private TextView fBO;
    private ImageView fBP;
    private LinearLayout fBQ;
    private LinearLayout fBR;
    private LinearLayout fBS;
    private TbImageView fBT;
    private TextView fBU;
    private TextView fBV;
    private TextView fBW;
    private ProgressBar fBX;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
    }

    public void a(com.baidu.live.tieba.pb.interactionpopupwindow.c cVar) {
        this.fBH = cVar;
    }

    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.d
    public int getLayout() {
        return a.h.ala_challenge_reward_dialog;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.d
    public void a(AlaChallengeRewardData alaChallengeRewardData) {
        if (alaChallengeRewardData != null) {
            this.fBG = alaChallengeRewardData;
            if (this.fBG.isUseAllIn()) {
                this.fBP.setVisibility(0);
            } else {
                this.fBP.setVisibility(8);
            }
            if (!StringHelper.isEmpty(alaChallengeRewardData.mResultDescription)) {
                this.fBJ.setText(alaChallengeRewardData.mResultDescription);
                this.fBJ.setVisibility(0);
            } else {
                this.fBJ.setVisibility(8);
            }
            if (this.fBG.getChallengeResult() == 2) {
                this.fBI.setText(getTbPageContext().getResources().getString(a.i.ala_pk_success_reward_tip));
            } else if (this.fBG.getChallengeResult() == 0) {
                this.fBI.setText(getTbPageContext().getResources().getString(a.i.ala_pk_fail_reward_tip));
            } else if (this.fBG.getChallengeResult() == 1) {
                this.fBI.setText(getTbPageContext().getResources().getString(a.i.ala_pk_tie_reward_tip));
            }
            this.fBR.setVisibility(8);
            if (JavaTypesHelper.toInt(this.fBG.streakSuccessNum, 0) > 1) {
                this.fBR.setVisibility(0);
                this.fBN.setText(this.fBG.streakSuccessNum);
            }
            this.fBO.setText(String.format("%s%s", this.fBG.successRateNum, "%"));
            this.fBK.setText(i.numFormatOverWanNaForAudienceNum(this.fBG.watcherNum));
            if (this.fBG.isUseAllIn() && this.fBG.getChallengeResult() == 2) {
                this.fBL.setText(getTbPageContext().getResources().getString(a.i.ala_pk_reward_charm_num_label, i.numFormatOverWanNaForAudienceNum(this.fBG.charmNum), this.fBG.charmExt));
            } else {
                this.fBL.setText(i.numFormatOverWanNaForAudienceNum(this.fBG.charmNum));
            }
            this.fBM.setText(i.numFormatOverWanNaForAudienceNum(this.fBG.giftNum));
            if (this.fBG.challengeLevelScore < 0 || this.fBG.challengeLevelNextScore <= 0 || this.fBG.challengeLevelScore > this.fBG.challengeLevelNextScore) {
                this.fBX.setVisibility(8);
                this.fBV.setVisibility(8);
                this.fBW.setVisibility(8);
                this.fBT.setVisibility(8);
                this.fBU.setVisibility(8);
                return;
            }
            this.fBX.setVisibility(0);
            this.fBV.setVisibility(0);
            this.fBW.setVisibility(0);
            this.fBT.setVisibility(0);
            this.fBU.setVisibility(0);
            this.fBT.startLoad(this.fBG.challengeLevelIcon, 10, false);
            this.fBU.setText(this.fBG.challengeLevelName);
            this.fBX.setProgress((int) ((this.fBG.challengeLevelScore * 100) / this.fBG.challengeLevelNextScore));
            this.fBV.setText(String.valueOf(this.fBG.challengeLevelScore));
            this.fBW.setText(String.format("%s%s", "/", Long.valueOf(this.fBG.challengeLevelNextScore)));
        }
    }

    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.d
    public void initView() {
        this.fBR = (LinearLayout) getViewGroup().findViewById(a.g.reward_streak_win_layout);
        this.fBI = (TextView) getViewGroup().findViewById(a.g.reward_title);
        this.fBJ = (TextView) getViewGroup().findViewById(a.g.reward_desc);
        this.fBK = (TextView) getViewGroup().findViewById(a.g.watch_cnt_value);
        this.fBL = (TextView) getViewGroup().findViewById(a.g.charm_value);
        this.fBM = (TextView) getViewGroup().findViewById(a.g.gift_num_value);
        this.fBN = (TextView) getViewGroup().findViewById(a.g.reward_streak_success);
        this.fBO = (TextView) getViewGroup().findViewById(a.g.reward_success_rate);
        this.fBP = (ImageView) getViewGroup().findViewById(a.g.reward_all_in_icon);
        this.fBS = (LinearLayout) getViewGroup().findViewById(a.g.level_layout);
        this.fBT = (TbImageView) getViewGroup().findViewById(a.g.level_icon);
        this.fBT.setAutoChangeStyle(false);
        this.fBT.setIsNight(false);
        this.fBU = (TextView) getViewGroup().findViewById(a.g.level_name);
        this.fBV = (TextView) getViewGroup().findViewById(a.g.level_cur_exp);
        this.fBW = (TextView) getViewGroup().findViewById(a.g.level_max_exp);
        this.fBX = (ProgressBar) getViewGroup().findViewById(a.g.ala_challenge_level_progress);
        this.fBQ = (LinearLayout) getViewGroup().findViewById(a.g.ok);
        this.fBQ.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == a.g.ok && this.fBH != null) {
            this.fBH.dismiss();
        }
    }
}
