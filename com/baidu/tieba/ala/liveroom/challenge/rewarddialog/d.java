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
    private AlaChallengeRewardData htK;
    private com.baidu.live.tieba.pb.interactionpopupwindow.c htL;
    private TextView htM;
    private TextView htN;
    private TextView htO;
    private TextView htP;
    private TextView htQ;
    private TextView htR;
    private TextView htS;
    private ImageView htT;
    private LinearLayout htU;
    private LinearLayout htV;
    private LinearLayout htW;
    private TbImageView htX;
    private TextView htY;
    private TextView htZ;
    private TextView hua;
    private ProgressBar hub;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
    }

    public void a(com.baidu.live.tieba.pb.interactionpopupwindow.c cVar) {
        this.htL = cVar;
    }

    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.d
    public int getLayout() {
        return a.g.ala_challenge_reward_dialog;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.d
    public void a(AlaChallengeRewardData alaChallengeRewardData) {
        if (alaChallengeRewardData != null) {
            this.htK = alaChallengeRewardData;
            if (this.htK.isUseAllIn()) {
                this.htT.setVisibility(0);
            } else {
                this.htT.setVisibility(8);
            }
            if (!StringHelper.isEmpty(alaChallengeRewardData.mResultDescription)) {
                this.htN.setText(alaChallengeRewardData.mResultDescription);
                this.htN.setVisibility(0);
            } else {
                this.htN.setVisibility(8);
            }
            if (this.htK.getChallengeResult() == 2) {
                this.htM.setText(getTbPageContext().getResources().getString(a.h.ala_pk_success_reward_tip));
            } else if (this.htK.getChallengeResult() == 0) {
                this.htM.setText(getTbPageContext().getResources().getString(a.h.ala_pk_fail_reward_tip));
            } else if (this.htK.getChallengeResult() == 1) {
                this.htM.setText(getTbPageContext().getResources().getString(a.h.ala_pk_tie_reward_tip));
            }
            this.htV.setVisibility(8);
            if (JavaTypesHelper.toInt(this.htK.streakSuccessNum, 0) > 1) {
                this.htV.setVisibility(0);
                this.htR.setText(this.htK.streakSuccessNum);
            }
            this.htS.setText(String.format("%s%s", this.htK.successRateNum, "%"));
            this.htO.setText(j.numFormatOverWanNaForAudienceNum(this.htK.watcherNum));
            if (this.htK.isUseAllIn() && this.htK.getChallengeResult() == 2) {
                this.htP.setText(getTbPageContext().getResources().getString(a.h.ala_pk_reward_charm_num_label, j.numFormatOverWanNaForAudienceNum(this.htK.charmNum), this.htK.charmExt));
            } else {
                this.htP.setText(j.numFormatOverWanNaForAudienceNum(this.htK.charmNum));
            }
            this.htQ.setText(j.numFormatOverWanNaForAudienceNum(this.htK.giftNum));
            if (this.htK.challengeLevelScore < 0 || this.htK.challengeLevelNextScore <= 0 || this.htK.challengeLevelScore > this.htK.challengeLevelNextScore) {
                this.hub.setVisibility(8);
                this.htZ.setVisibility(8);
                this.hua.setVisibility(8);
                this.htX.setVisibility(8);
                this.htY.setVisibility(8);
                return;
            }
            this.hub.setVisibility(0);
            this.htZ.setVisibility(0);
            this.hua.setVisibility(0);
            this.htX.setVisibility(0);
            this.htY.setVisibility(0);
            this.htX.startLoad(this.htK.challengeLevelIcon, 10, false);
            this.htY.setText(this.htK.challengeLevelName);
            this.hub.setProgress((int) ((this.htK.challengeLevelScore * 100) / this.htK.challengeLevelNextScore));
            this.htZ.setText(String.valueOf(this.htK.challengeLevelScore));
            this.hua.setText(String.format("%s%s", "/", Long.valueOf(this.htK.challengeLevelNextScore)));
        }
    }

    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.d
    public void initView() {
        this.htV = (LinearLayout) getViewGroup().findViewById(a.f.reward_streak_win_layout);
        this.htM = (TextView) getViewGroup().findViewById(a.f.reward_title);
        this.htN = (TextView) getViewGroup().findViewById(a.f.reward_desc);
        this.htO = (TextView) getViewGroup().findViewById(a.f.watch_cnt_value);
        this.htP = (TextView) getViewGroup().findViewById(a.f.charm_value);
        this.htQ = (TextView) getViewGroup().findViewById(a.f.gift_num_value);
        this.htR = (TextView) getViewGroup().findViewById(a.f.reward_streak_success);
        this.htS = (TextView) getViewGroup().findViewById(a.f.reward_success_rate);
        this.htT = (ImageView) getViewGroup().findViewById(a.f.reward_all_in_icon);
        this.htW = (LinearLayout) getViewGroup().findViewById(a.f.level_layout);
        this.htX = (TbImageView) getViewGroup().findViewById(a.f.level_icon);
        this.htX.setAutoChangeStyle(false);
        this.htX.setIsNight(false);
        this.htY = (TextView) getViewGroup().findViewById(a.f.level_name);
        this.htZ = (TextView) getViewGroup().findViewById(a.f.level_cur_exp);
        this.hua = (TextView) getViewGroup().findViewById(a.f.level_max_exp);
        this.hub = (ProgressBar) getViewGroup().findViewById(a.f.ala_challenge_level_progress);
        this.htU = (LinearLayout) getViewGroup().findViewById(a.f.ok);
        this.htU.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == a.f.ok && this.htL != null) {
            this.htL.dismiss();
        }
    }
}
