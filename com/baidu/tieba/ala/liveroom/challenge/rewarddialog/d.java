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
/* loaded from: classes10.dex */
public class d extends com.baidu.live.tieba.pb.interactionpopupwindow.b<AlaChallengeRewardData> implements View.OnClickListener {
    private ImageView hAa;
    private LinearLayout hAb;
    private LinearLayout hAc;
    private LinearLayout hAd;
    private TbImageView hAe;
    private TextView hAf;
    private TextView hAg;
    private TextView hAh;
    private ProgressBar hAi;
    private AlaChallengeRewardData hzR;
    private com.baidu.live.tieba.pb.interactionpopupwindow.c hzS;
    private TextView hzT;
    private TextView hzU;
    private TextView hzV;
    private TextView hzW;
    private TextView hzX;
    private TextView hzY;
    private TextView hzZ;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
    }

    public void a(com.baidu.live.tieba.pb.interactionpopupwindow.c cVar) {
        this.hzS = cVar;
    }

    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.d
    public int getLayout() {
        return a.g.ala_challenge_reward_dialog;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.d
    public void a(AlaChallengeRewardData alaChallengeRewardData) {
        if (alaChallengeRewardData != null) {
            this.hzR = alaChallengeRewardData;
            if (this.hzR.isUseAllIn()) {
                this.hAa.setVisibility(0);
            } else {
                this.hAa.setVisibility(8);
            }
            if (!StringHelper.isEmpty(alaChallengeRewardData.mResultDescription)) {
                this.hzU.setText(alaChallengeRewardData.mResultDescription);
                this.hzU.setVisibility(0);
            } else {
                this.hzU.setVisibility(8);
            }
            if (this.hzR.getChallengeResult() == 2) {
                this.hzT.setText(getTbPageContext().getResources().getString(a.h.ala_pk_success_reward_tip));
            } else if (this.hzR.getChallengeResult() == 0) {
                this.hzT.setText(getTbPageContext().getResources().getString(a.h.ala_pk_fail_reward_tip));
            } else if (this.hzR.getChallengeResult() == 1) {
                this.hzT.setText(getTbPageContext().getResources().getString(a.h.ala_pk_tie_reward_tip));
            }
            this.hAc.setVisibility(8);
            if (JavaTypesHelper.toInt(this.hzR.streakSuccessNum, 0) > 1) {
                this.hAc.setVisibility(0);
                this.hzY.setText(this.hzR.streakSuccessNum);
            }
            this.hzZ.setText(String.format("%s%s", this.hzR.successRateNum, "%"));
            this.hzV.setText(j.numFormatOverWanNaForAudienceNum(this.hzR.watcherNum));
            if (this.hzR.isUseAllIn() && this.hzR.getChallengeResult() == 2) {
                this.hzW.setText(getTbPageContext().getResources().getString(a.h.ala_pk_reward_charm_num_label, j.numFormatOverWanNaForAudienceNum(this.hzR.charmNum), this.hzR.charmExt));
            } else {
                this.hzW.setText(j.numFormatOverWanNaForAudienceNum(this.hzR.charmNum));
            }
            this.hzX.setText(j.numFormatOverWanNaForAudienceNum(this.hzR.giftNum));
            if (this.hzR.challengeLevelScore < 0 || this.hzR.challengeLevelNextScore <= 0 || this.hzR.challengeLevelScore > this.hzR.challengeLevelNextScore) {
                this.hAi.setVisibility(8);
                this.hAg.setVisibility(8);
                this.hAh.setVisibility(8);
                this.hAe.setVisibility(8);
                this.hAf.setVisibility(8);
                return;
            }
            this.hAi.setVisibility(0);
            this.hAg.setVisibility(0);
            this.hAh.setVisibility(0);
            this.hAe.setVisibility(0);
            this.hAf.setVisibility(0);
            this.hAe.startLoad(this.hzR.challengeLevelIcon, 10, false);
            this.hAf.setText(this.hzR.challengeLevelName);
            this.hAi.setProgress((int) ((this.hzR.challengeLevelScore * 100) / this.hzR.challengeLevelNextScore));
            this.hAg.setText(String.valueOf(this.hzR.challengeLevelScore));
            this.hAh.setText(String.format("%s%s", "/", Long.valueOf(this.hzR.challengeLevelNextScore)));
        }
    }

    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.d
    public void initView() {
        this.hAc = (LinearLayout) getViewGroup().findViewById(a.f.reward_streak_win_layout);
        this.hzT = (TextView) getViewGroup().findViewById(a.f.reward_title);
        this.hzU = (TextView) getViewGroup().findViewById(a.f.reward_desc);
        this.hzV = (TextView) getViewGroup().findViewById(a.f.watch_cnt_value);
        this.hzW = (TextView) getViewGroup().findViewById(a.f.charm_value);
        this.hzX = (TextView) getViewGroup().findViewById(a.f.gift_num_value);
        this.hzY = (TextView) getViewGroup().findViewById(a.f.reward_streak_success);
        this.hzZ = (TextView) getViewGroup().findViewById(a.f.reward_success_rate);
        this.hAa = (ImageView) getViewGroup().findViewById(a.f.reward_all_in_icon);
        this.hAd = (LinearLayout) getViewGroup().findViewById(a.f.level_layout);
        this.hAe = (TbImageView) getViewGroup().findViewById(a.f.level_icon);
        this.hAe.setAutoChangeStyle(false);
        this.hAe.setIsNight(false);
        this.hAf = (TextView) getViewGroup().findViewById(a.f.level_name);
        this.hAg = (TextView) getViewGroup().findViewById(a.f.level_cur_exp);
        this.hAh = (TextView) getViewGroup().findViewById(a.f.level_max_exp);
        this.hAi = (ProgressBar) getViewGroup().findViewById(a.f.ala_challenge_level_progress);
        this.hAb = (LinearLayout) getViewGroup().findViewById(a.f.ok);
        this.hAb.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == a.f.ok && this.hzS != null) {
            this.hzS.dismiss();
        }
    }
}
