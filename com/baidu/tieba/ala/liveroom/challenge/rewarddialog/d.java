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
    private AlaChallengeRewardData fPJ;
    private com.baidu.live.tieba.pb.interactionpopupwindow.c fPK;
    private TextView fPL;
    private TextView fPM;
    private TextView fPN;
    private TextView fPO;
    private TextView fPP;
    private TextView fPQ;
    private TextView fPR;
    private ImageView fPS;
    private LinearLayout fPT;
    private LinearLayout fPU;
    private LinearLayout fPV;
    private TbImageView fPW;
    private TextView fPX;
    private TextView fPY;
    private TextView fPZ;
    private ProgressBar fQa;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
    }

    public void a(com.baidu.live.tieba.pb.interactionpopupwindow.c cVar) {
        this.fPK = cVar;
    }

    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.d
    public int getLayout() {
        return a.h.ala_challenge_reward_dialog;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.d
    public void a(AlaChallengeRewardData alaChallengeRewardData) {
        if (alaChallengeRewardData != null) {
            this.fPJ = alaChallengeRewardData;
            if (this.fPJ.isUseAllIn()) {
                this.fPS.setVisibility(0);
            } else {
                this.fPS.setVisibility(8);
            }
            if (!StringHelper.isEmpty(alaChallengeRewardData.mResultDescription)) {
                this.fPM.setText(alaChallengeRewardData.mResultDescription);
                this.fPM.setVisibility(0);
            } else {
                this.fPM.setVisibility(8);
            }
            if (this.fPJ.getChallengeResult() == 2) {
                this.fPL.setText(getTbPageContext().getResources().getString(a.i.ala_pk_success_reward_tip));
            } else if (this.fPJ.getChallengeResult() == 0) {
                this.fPL.setText(getTbPageContext().getResources().getString(a.i.ala_pk_fail_reward_tip));
            } else if (this.fPJ.getChallengeResult() == 1) {
                this.fPL.setText(getTbPageContext().getResources().getString(a.i.ala_pk_tie_reward_tip));
            }
            this.fPU.setVisibility(8);
            if (JavaTypesHelper.toInt(this.fPJ.streakSuccessNum, 0) > 1) {
                this.fPU.setVisibility(0);
                this.fPQ.setText(this.fPJ.streakSuccessNum);
            }
            this.fPR.setText(String.format("%s%s", this.fPJ.successRateNum, "%"));
            this.fPN.setText(i.numFormatOverWanNaForAudienceNum(this.fPJ.watcherNum));
            if (this.fPJ.isUseAllIn() && this.fPJ.getChallengeResult() == 2) {
                this.fPO.setText(getTbPageContext().getResources().getString(a.i.ala_pk_reward_charm_num_label, i.numFormatOverWanNaForAudienceNum(this.fPJ.charmNum), this.fPJ.charmExt));
            } else {
                this.fPO.setText(i.numFormatOverWanNaForAudienceNum(this.fPJ.charmNum));
            }
            this.fPP.setText(i.numFormatOverWanNaForAudienceNum(this.fPJ.giftNum));
            if (this.fPJ.challengeLevelScore < 0 || this.fPJ.challengeLevelNextScore <= 0 || this.fPJ.challengeLevelScore > this.fPJ.challengeLevelNextScore) {
                this.fQa.setVisibility(8);
                this.fPY.setVisibility(8);
                this.fPZ.setVisibility(8);
                this.fPW.setVisibility(8);
                this.fPX.setVisibility(8);
                return;
            }
            this.fQa.setVisibility(0);
            this.fPY.setVisibility(0);
            this.fPZ.setVisibility(0);
            this.fPW.setVisibility(0);
            this.fPX.setVisibility(0);
            this.fPW.startLoad(this.fPJ.challengeLevelIcon, 10, false);
            this.fPX.setText(this.fPJ.challengeLevelName);
            this.fQa.setProgress((int) ((this.fPJ.challengeLevelScore * 100) / this.fPJ.challengeLevelNextScore));
            this.fPY.setText(String.valueOf(this.fPJ.challengeLevelScore));
            this.fPZ.setText(String.format("%s%s", "/", Long.valueOf(this.fPJ.challengeLevelNextScore)));
        }
    }

    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.d
    public void initView() {
        this.fPU = (LinearLayout) getViewGroup().findViewById(a.g.reward_streak_win_layout);
        this.fPL = (TextView) getViewGroup().findViewById(a.g.reward_title);
        this.fPM = (TextView) getViewGroup().findViewById(a.g.reward_desc);
        this.fPN = (TextView) getViewGroup().findViewById(a.g.watch_cnt_value);
        this.fPO = (TextView) getViewGroup().findViewById(a.g.charm_value);
        this.fPP = (TextView) getViewGroup().findViewById(a.g.gift_num_value);
        this.fPQ = (TextView) getViewGroup().findViewById(a.g.reward_streak_success);
        this.fPR = (TextView) getViewGroup().findViewById(a.g.reward_success_rate);
        this.fPS = (ImageView) getViewGroup().findViewById(a.g.reward_all_in_icon);
        this.fPV = (LinearLayout) getViewGroup().findViewById(a.g.level_layout);
        this.fPW = (TbImageView) getViewGroup().findViewById(a.g.level_icon);
        this.fPW.setAutoChangeStyle(false);
        this.fPW.setIsNight(false);
        this.fPX = (TextView) getViewGroup().findViewById(a.g.level_name);
        this.fPY = (TextView) getViewGroup().findViewById(a.g.level_cur_exp);
        this.fPZ = (TextView) getViewGroup().findViewById(a.g.level_max_exp);
        this.fQa = (ProgressBar) getViewGroup().findViewById(a.g.ala_challenge_level_progress);
        this.fPT = (LinearLayout) getViewGroup().findViewById(a.g.ok);
        this.fPT.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == a.g.ok && this.fPK != null) {
            this.fPK.dismiss();
        }
    }
}
