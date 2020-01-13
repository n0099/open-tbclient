package com.baidu.tieba.ala.liveroom.challenge.rewarddialog;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.live.adp.lib.safe.JavaTypesHelper;
import com.baidu.live.r.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.live.utils.i;
/* loaded from: classes2.dex */
public class d extends com.baidu.live.tieba.pb.interactionpopupwindow.b<AlaChallengeRewardData> implements View.OnClickListener {
    private AlaChallengeRewardData eSL;
    private com.baidu.live.tieba.pb.interactionpopupwindow.c eSM;
    private TextView eSN;
    private TextView eSO;
    private TextView eSP;
    private TextView eSQ;
    private TextView eSR;
    private TextView eSS;
    private TextView eST;
    private ImageView eSU;
    private LinearLayout eSV;
    private LinearLayout eSW;
    private LinearLayout eSX;
    private TbImageView eSY;
    private TextView eSZ;
    private TextView eTa;
    private TextView eTb;
    private ProgressBar eTc;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
    }

    public void a(com.baidu.live.tieba.pb.interactionpopupwindow.c cVar) {
        this.eSM = cVar;
    }

    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.d
    public int getLayout() {
        return a.h.ala_challenge_reward_dialog;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.d
    public void a(AlaChallengeRewardData alaChallengeRewardData) {
        if (alaChallengeRewardData != null) {
            this.eSL = alaChallengeRewardData;
            if (this.eSL.isUseAllIn()) {
                this.eSU.setVisibility(0);
            } else {
                this.eSU.setVisibility(8);
            }
            if (!StringHelper.isEmpty(alaChallengeRewardData.mResultDescription)) {
                this.eSO.setText(alaChallengeRewardData.mResultDescription);
                this.eSO.setVisibility(0);
            } else {
                this.eSO.setVisibility(8);
            }
            if (this.eSL.getChallengeResult() == 2) {
                this.eSN.setText(getTbPageContext().getResources().getString(a.i.ala_pk_success_reward_tip));
            } else if (this.eSL.getChallengeResult() == 0) {
                this.eSN.setText(getTbPageContext().getResources().getString(a.i.ala_pk_fail_reward_tip));
            } else if (this.eSL.getChallengeResult() == 1) {
                this.eSN.setText(getTbPageContext().getResources().getString(a.i.ala_pk_tie_reward_tip));
            }
            this.eSW.setVisibility(8);
            if (JavaTypesHelper.toInt(this.eSL.streakSuccessNum, 0) > 1) {
                this.eSW.setVisibility(0);
                this.eSS.setText(this.eSL.streakSuccessNum);
            }
            this.eST.setText(String.format("%s%s", this.eSL.successRateNum, "%"));
            this.eSP.setText(i.numFormatOverWanNaForAudienceNum(this.eSL.watcherNum));
            if (this.eSL.isUseAllIn() && this.eSL.getChallengeResult() == 2) {
                this.eSQ.setText(getTbPageContext().getResources().getString(a.i.ala_pk_reward_charm_num_label, i.numFormatOverWanNaForAudienceNum(this.eSL.charmNum), this.eSL.charmExt));
            } else {
                this.eSQ.setText(i.numFormatOverWanNaForAudienceNum(this.eSL.charmNum));
            }
            this.eSR.setText(i.numFormatOverWanNaForAudienceNum(this.eSL.giftNum));
            if (this.eSL.challengeLevelScore < 0 || this.eSL.challengeLevelNextScore <= 0 || this.eSL.challengeLevelScore > this.eSL.challengeLevelNextScore) {
                this.eTc.setVisibility(8);
                this.eTa.setVisibility(8);
                this.eTb.setVisibility(8);
                this.eSY.setVisibility(8);
                this.eSZ.setVisibility(8);
                return;
            }
            this.eTc.setVisibility(0);
            this.eTa.setVisibility(0);
            this.eTb.setVisibility(0);
            this.eSY.setVisibility(0);
            this.eSZ.setVisibility(0);
            this.eSY.startLoad(this.eSL.challengeLevelIcon, 10, false);
            this.eSZ.setText(this.eSL.challengeLevelName);
            this.eTc.setProgress((int) ((this.eSL.challengeLevelScore * 100) / this.eSL.challengeLevelNextScore));
            this.eTa.setText(String.valueOf(this.eSL.challengeLevelScore));
            this.eTb.setText(String.format("%s%s", "/", Long.valueOf(this.eSL.challengeLevelNextScore)));
        }
    }

    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.d
    public void initView() {
        this.eSW = (LinearLayout) getViewGroup().findViewById(a.g.reward_streak_win_layout);
        this.eSN = (TextView) getViewGroup().findViewById(a.g.reward_title);
        this.eSO = (TextView) getViewGroup().findViewById(a.g.reward_desc);
        this.eSP = (TextView) getViewGroup().findViewById(a.g.watch_cnt_value);
        this.eSQ = (TextView) getViewGroup().findViewById(a.g.charm_value);
        this.eSR = (TextView) getViewGroup().findViewById(a.g.gift_num_value);
        this.eSS = (TextView) getViewGroup().findViewById(a.g.reward_streak_success);
        this.eST = (TextView) getViewGroup().findViewById(a.g.reward_success_rate);
        this.eSU = (ImageView) getViewGroup().findViewById(a.g.reward_all_in_icon);
        this.eSX = (LinearLayout) getViewGroup().findViewById(a.g.level_layout);
        this.eSY = (TbImageView) getViewGroup().findViewById(a.g.level_icon);
        this.eSY.setAutoChangeStyle(false);
        this.eSY.setIsNight(false);
        this.eSZ = (TextView) getViewGroup().findViewById(a.g.level_name);
        this.eTa = (TextView) getViewGroup().findViewById(a.g.level_cur_exp);
        this.eTb = (TextView) getViewGroup().findViewById(a.g.level_max_exp);
        this.eTc = (ProgressBar) getViewGroup().findViewById(a.g.ala_challenge_level_progress);
        this.eSV = (LinearLayout) getViewGroup().findViewById(a.g.ok);
        this.eSV.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == a.g.ok && this.eSM != null) {
            this.eSM.dismiss();
        }
    }
}
