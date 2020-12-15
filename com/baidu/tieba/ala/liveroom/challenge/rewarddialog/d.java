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
/* loaded from: classes4.dex */
public class d extends com.baidu.live.tieba.pb.interactionpopupwindow.b<AlaChallengeRewardData> implements View.OnClickListener {
    private TextView hmA;
    private TextView hmB;
    private TextView hmC;
    private TextView hmD;
    private ImageView hmE;
    private LinearLayout hmF;
    private LinearLayout hmG;
    private LinearLayout hmH;
    private TbImageView hmI;
    private TextView hmJ;
    private TextView hmK;
    private TextView hmL;
    private ProgressBar hmM;
    private AlaChallengeRewardData hmv;
    private com.baidu.live.tieba.pb.interactionpopupwindow.c hmw;
    private TextView hmx;
    private TextView hmy;
    private TextView hmz;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
    }

    public void a(com.baidu.live.tieba.pb.interactionpopupwindow.c cVar) {
        this.hmw = cVar;
    }

    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.d
    public int getLayout() {
        return a.g.ala_challenge_reward_dialog;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.d
    public void a(AlaChallengeRewardData alaChallengeRewardData) {
        if (alaChallengeRewardData != null) {
            this.hmv = alaChallengeRewardData;
            if (this.hmv.isUseAllIn()) {
                this.hmE.setVisibility(0);
            } else {
                this.hmE.setVisibility(8);
            }
            if (!StringHelper.isEmpty(alaChallengeRewardData.mResultDescription)) {
                this.hmy.setText(alaChallengeRewardData.mResultDescription);
                this.hmy.setVisibility(0);
            } else {
                this.hmy.setVisibility(8);
            }
            if (this.hmv.getChallengeResult() == 2) {
                this.hmx.setText(getTbPageContext().getResources().getString(a.h.ala_pk_success_reward_tip));
            } else if (this.hmv.getChallengeResult() == 0) {
                this.hmx.setText(getTbPageContext().getResources().getString(a.h.ala_pk_fail_reward_tip));
            } else if (this.hmv.getChallengeResult() == 1) {
                this.hmx.setText(getTbPageContext().getResources().getString(a.h.ala_pk_tie_reward_tip));
            }
            this.hmG.setVisibility(8);
            if (JavaTypesHelper.toInt(this.hmv.streakSuccessNum, 0) > 1) {
                this.hmG.setVisibility(0);
                this.hmC.setText(this.hmv.streakSuccessNum);
            }
            this.hmD.setText(String.format("%s%s", this.hmv.successRateNum, "%"));
            this.hmz.setText(j.numFormatOverWanNaForAudienceNum(this.hmv.watcherNum));
            if (this.hmv.isUseAllIn() && this.hmv.getChallengeResult() == 2) {
                this.hmA.setText(getTbPageContext().getResources().getString(a.h.ala_pk_reward_charm_num_label, j.numFormatOverWanNaForAudienceNum(this.hmv.charmNum), this.hmv.charmExt));
            } else {
                this.hmA.setText(j.numFormatOverWanNaForAudienceNum(this.hmv.charmNum));
            }
            this.hmB.setText(j.numFormatOverWanNaForAudienceNum(this.hmv.giftNum));
            if (this.hmv.challengeLevelScore < 0 || this.hmv.challengeLevelNextScore <= 0 || this.hmv.challengeLevelScore > this.hmv.challengeLevelNextScore) {
                this.hmM.setVisibility(8);
                this.hmK.setVisibility(8);
                this.hmL.setVisibility(8);
                this.hmI.setVisibility(8);
                this.hmJ.setVisibility(8);
                return;
            }
            this.hmM.setVisibility(0);
            this.hmK.setVisibility(0);
            this.hmL.setVisibility(0);
            this.hmI.setVisibility(0);
            this.hmJ.setVisibility(0);
            this.hmI.startLoad(this.hmv.challengeLevelIcon, 10, false);
            this.hmJ.setText(this.hmv.challengeLevelName);
            this.hmM.setProgress((int) ((this.hmv.challengeLevelScore * 100) / this.hmv.challengeLevelNextScore));
            this.hmK.setText(String.valueOf(this.hmv.challengeLevelScore));
            this.hmL.setText(String.format("%s%s", "/", Long.valueOf(this.hmv.challengeLevelNextScore)));
        }
    }

    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.d
    public void initView() {
        this.hmG = (LinearLayout) getViewGroup().findViewById(a.f.reward_streak_win_layout);
        this.hmx = (TextView) getViewGroup().findViewById(a.f.reward_title);
        this.hmy = (TextView) getViewGroup().findViewById(a.f.reward_desc);
        this.hmz = (TextView) getViewGroup().findViewById(a.f.watch_cnt_value);
        this.hmA = (TextView) getViewGroup().findViewById(a.f.charm_value);
        this.hmB = (TextView) getViewGroup().findViewById(a.f.gift_num_value);
        this.hmC = (TextView) getViewGroup().findViewById(a.f.reward_streak_success);
        this.hmD = (TextView) getViewGroup().findViewById(a.f.reward_success_rate);
        this.hmE = (ImageView) getViewGroup().findViewById(a.f.reward_all_in_icon);
        this.hmH = (LinearLayout) getViewGroup().findViewById(a.f.level_layout);
        this.hmI = (TbImageView) getViewGroup().findViewById(a.f.level_icon);
        this.hmI.setAutoChangeStyle(false);
        this.hmI.setIsNight(false);
        this.hmJ = (TextView) getViewGroup().findViewById(a.f.level_name);
        this.hmK = (TextView) getViewGroup().findViewById(a.f.level_cur_exp);
        this.hmL = (TextView) getViewGroup().findViewById(a.f.level_max_exp);
        this.hmM = (ProgressBar) getViewGroup().findViewById(a.f.ala_challenge_level_progress);
        this.hmF = (LinearLayout) getViewGroup().findViewById(a.f.ok);
        this.hmF.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == a.f.ok && this.hmw != null) {
            this.hmw.dismiss();
        }
    }
}
