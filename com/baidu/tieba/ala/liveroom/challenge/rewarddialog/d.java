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
    private AlaChallengeRewardData fBB;
    private com.baidu.live.tieba.pb.interactionpopupwindow.c fBC;
    private TextView fBD;
    private TextView fBE;
    private TextView fBF;
    private TextView fBG;
    private TextView fBH;
    private TextView fBI;
    private TextView fBJ;
    private ImageView fBK;
    private LinearLayout fBL;
    private LinearLayout fBM;
    private LinearLayout fBN;
    private TbImageView fBO;
    private TextView fBP;
    private TextView fBQ;
    private TextView fBR;
    private ProgressBar fBS;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
    }

    public void a(com.baidu.live.tieba.pb.interactionpopupwindow.c cVar) {
        this.fBC = cVar;
    }

    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.d
    public int getLayout() {
        return a.h.ala_challenge_reward_dialog;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.d
    public void a(AlaChallengeRewardData alaChallengeRewardData) {
        if (alaChallengeRewardData != null) {
            this.fBB = alaChallengeRewardData;
            if (this.fBB.isUseAllIn()) {
                this.fBK.setVisibility(0);
            } else {
                this.fBK.setVisibility(8);
            }
            if (!StringHelper.isEmpty(alaChallengeRewardData.mResultDescription)) {
                this.fBE.setText(alaChallengeRewardData.mResultDescription);
                this.fBE.setVisibility(0);
            } else {
                this.fBE.setVisibility(8);
            }
            if (this.fBB.getChallengeResult() == 2) {
                this.fBD.setText(getTbPageContext().getResources().getString(a.i.ala_pk_success_reward_tip));
            } else if (this.fBB.getChallengeResult() == 0) {
                this.fBD.setText(getTbPageContext().getResources().getString(a.i.ala_pk_fail_reward_tip));
            } else if (this.fBB.getChallengeResult() == 1) {
                this.fBD.setText(getTbPageContext().getResources().getString(a.i.ala_pk_tie_reward_tip));
            }
            this.fBM.setVisibility(8);
            if (JavaTypesHelper.toInt(this.fBB.streakSuccessNum, 0) > 1) {
                this.fBM.setVisibility(0);
                this.fBI.setText(this.fBB.streakSuccessNum);
            }
            this.fBJ.setText(String.format("%s%s", this.fBB.successRateNum, "%"));
            this.fBF.setText(i.numFormatOverWanNaForAudienceNum(this.fBB.watcherNum));
            if (this.fBB.isUseAllIn() && this.fBB.getChallengeResult() == 2) {
                this.fBG.setText(getTbPageContext().getResources().getString(a.i.ala_pk_reward_charm_num_label, i.numFormatOverWanNaForAudienceNum(this.fBB.charmNum), this.fBB.charmExt));
            } else {
                this.fBG.setText(i.numFormatOverWanNaForAudienceNum(this.fBB.charmNum));
            }
            this.fBH.setText(i.numFormatOverWanNaForAudienceNum(this.fBB.giftNum));
            if (this.fBB.challengeLevelScore < 0 || this.fBB.challengeLevelNextScore <= 0 || this.fBB.challengeLevelScore > this.fBB.challengeLevelNextScore) {
                this.fBS.setVisibility(8);
                this.fBQ.setVisibility(8);
                this.fBR.setVisibility(8);
                this.fBO.setVisibility(8);
                this.fBP.setVisibility(8);
                return;
            }
            this.fBS.setVisibility(0);
            this.fBQ.setVisibility(0);
            this.fBR.setVisibility(0);
            this.fBO.setVisibility(0);
            this.fBP.setVisibility(0);
            this.fBO.startLoad(this.fBB.challengeLevelIcon, 10, false);
            this.fBP.setText(this.fBB.challengeLevelName);
            this.fBS.setProgress((int) ((this.fBB.challengeLevelScore * 100) / this.fBB.challengeLevelNextScore));
            this.fBQ.setText(String.valueOf(this.fBB.challengeLevelScore));
            this.fBR.setText(String.format("%s%s", "/", Long.valueOf(this.fBB.challengeLevelNextScore)));
        }
    }

    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.d
    public void initView() {
        this.fBM = (LinearLayout) getViewGroup().findViewById(a.g.reward_streak_win_layout);
        this.fBD = (TextView) getViewGroup().findViewById(a.g.reward_title);
        this.fBE = (TextView) getViewGroup().findViewById(a.g.reward_desc);
        this.fBF = (TextView) getViewGroup().findViewById(a.g.watch_cnt_value);
        this.fBG = (TextView) getViewGroup().findViewById(a.g.charm_value);
        this.fBH = (TextView) getViewGroup().findViewById(a.g.gift_num_value);
        this.fBI = (TextView) getViewGroup().findViewById(a.g.reward_streak_success);
        this.fBJ = (TextView) getViewGroup().findViewById(a.g.reward_success_rate);
        this.fBK = (ImageView) getViewGroup().findViewById(a.g.reward_all_in_icon);
        this.fBN = (LinearLayout) getViewGroup().findViewById(a.g.level_layout);
        this.fBO = (TbImageView) getViewGroup().findViewById(a.g.level_icon);
        this.fBO.setAutoChangeStyle(false);
        this.fBO.setIsNight(false);
        this.fBP = (TextView) getViewGroup().findViewById(a.g.level_name);
        this.fBQ = (TextView) getViewGroup().findViewById(a.g.level_cur_exp);
        this.fBR = (TextView) getViewGroup().findViewById(a.g.level_max_exp);
        this.fBS = (ProgressBar) getViewGroup().findViewById(a.g.ala_challenge_level_progress);
        this.fBL = (LinearLayout) getViewGroup().findViewById(a.g.ok);
        this.fBL.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == a.g.ok && this.fBC != null) {
            this.fBC.dismiss();
        }
    }
}
