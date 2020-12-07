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
    private ImageView hmC;
    private LinearLayout hmD;
    private LinearLayout hmE;
    private LinearLayout hmF;
    private TbImageView hmG;
    private TextView hmH;
    private TextView hmI;
    private TextView hmJ;
    private ProgressBar hmK;
    private AlaChallengeRewardData hmt;
    private com.baidu.live.tieba.pb.interactionpopupwindow.c hmu;
    private TextView hmv;
    private TextView hmw;
    private TextView hmx;
    private TextView hmy;
    private TextView hmz;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
    }

    public void a(com.baidu.live.tieba.pb.interactionpopupwindow.c cVar) {
        this.hmu = cVar;
    }

    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.d
    public int getLayout() {
        return a.g.ala_challenge_reward_dialog;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.d
    public void a(AlaChallengeRewardData alaChallengeRewardData) {
        if (alaChallengeRewardData != null) {
            this.hmt = alaChallengeRewardData;
            if (this.hmt.isUseAllIn()) {
                this.hmC.setVisibility(0);
            } else {
                this.hmC.setVisibility(8);
            }
            if (!StringHelper.isEmpty(alaChallengeRewardData.mResultDescription)) {
                this.hmw.setText(alaChallengeRewardData.mResultDescription);
                this.hmw.setVisibility(0);
            } else {
                this.hmw.setVisibility(8);
            }
            if (this.hmt.getChallengeResult() == 2) {
                this.hmv.setText(getTbPageContext().getResources().getString(a.h.ala_pk_success_reward_tip));
            } else if (this.hmt.getChallengeResult() == 0) {
                this.hmv.setText(getTbPageContext().getResources().getString(a.h.ala_pk_fail_reward_tip));
            } else if (this.hmt.getChallengeResult() == 1) {
                this.hmv.setText(getTbPageContext().getResources().getString(a.h.ala_pk_tie_reward_tip));
            }
            this.hmE.setVisibility(8);
            if (JavaTypesHelper.toInt(this.hmt.streakSuccessNum, 0) > 1) {
                this.hmE.setVisibility(0);
                this.hmA.setText(this.hmt.streakSuccessNum);
            }
            this.hmB.setText(String.format("%s%s", this.hmt.successRateNum, "%"));
            this.hmx.setText(j.numFormatOverWanNaForAudienceNum(this.hmt.watcherNum));
            if (this.hmt.isUseAllIn() && this.hmt.getChallengeResult() == 2) {
                this.hmy.setText(getTbPageContext().getResources().getString(a.h.ala_pk_reward_charm_num_label, j.numFormatOverWanNaForAudienceNum(this.hmt.charmNum), this.hmt.charmExt));
            } else {
                this.hmy.setText(j.numFormatOverWanNaForAudienceNum(this.hmt.charmNum));
            }
            this.hmz.setText(j.numFormatOverWanNaForAudienceNum(this.hmt.giftNum));
            if (this.hmt.challengeLevelScore < 0 || this.hmt.challengeLevelNextScore <= 0 || this.hmt.challengeLevelScore > this.hmt.challengeLevelNextScore) {
                this.hmK.setVisibility(8);
                this.hmI.setVisibility(8);
                this.hmJ.setVisibility(8);
                this.hmG.setVisibility(8);
                this.hmH.setVisibility(8);
                return;
            }
            this.hmK.setVisibility(0);
            this.hmI.setVisibility(0);
            this.hmJ.setVisibility(0);
            this.hmG.setVisibility(0);
            this.hmH.setVisibility(0);
            this.hmG.startLoad(this.hmt.challengeLevelIcon, 10, false);
            this.hmH.setText(this.hmt.challengeLevelName);
            this.hmK.setProgress((int) ((this.hmt.challengeLevelScore * 100) / this.hmt.challengeLevelNextScore));
            this.hmI.setText(String.valueOf(this.hmt.challengeLevelScore));
            this.hmJ.setText(String.format("%s%s", "/", Long.valueOf(this.hmt.challengeLevelNextScore)));
        }
    }

    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.d
    public void initView() {
        this.hmE = (LinearLayout) getViewGroup().findViewById(a.f.reward_streak_win_layout);
        this.hmv = (TextView) getViewGroup().findViewById(a.f.reward_title);
        this.hmw = (TextView) getViewGroup().findViewById(a.f.reward_desc);
        this.hmx = (TextView) getViewGroup().findViewById(a.f.watch_cnt_value);
        this.hmy = (TextView) getViewGroup().findViewById(a.f.charm_value);
        this.hmz = (TextView) getViewGroup().findViewById(a.f.gift_num_value);
        this.hmA = (TextView) getViewGroup().findViewById(a.f.reward_streak_success);
        this.hmB = (TextView) getViewGroup().findViewById(a.f.reward_success_rate);
        this.hmC = (ImageView) getViewGroup().findViewById(a.f.reward_all_in_icon);
        this.hmF = (LinearLayout) getViewGroup().findViewById(a.f.level_layout);
        this.hmG = (TbImageView) getViewGroup().findViewById(a.f.level_icon);
        this.hmG.setAutoChangeStyle(false);
        this.hmG.setIsNight(false);
        this.hmH = (TextView) getViewGroup().findViewById(a.f.level_name);
        this.hmI = (TextView) getViewGroup().findViewById(a.f.level_cur_exp);
        this.hmJ = (TextView) getViewGroup().findViewById(a.f.level_max_exp);
        this.hmK = (ProgressBar) getViewGroup().findViewById(a.f.ala_challenge_level_progress);
        this.hmD = (LinearLayout) getViewGroup().findViewById(a.f.ok);
        this.hmD.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == a.f.ok && this.hmu != null) {
            this.hmu.dismiss();
        }
    }
}
