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
import com.baidu.live.utils.i;
/* loaded from: classes3.dex */
public class d extends com.baidu.live.tieba.pb.interactionpopupwindow.b<AlaChallengeRewardData> implements View.OnClickListener {
    private AlaChallengeRewardData gbQ;
    private com.baidu.live.tieba.pb.interactionpopupwindow.c gbR;
    private TextView gbS;
    private TextView gbT;
    private TextView gbU;
    private TextView gbV;
    private TextView gbW;
    private TextView gbX;
    private TextView gbY;
    private ImageView gbZ;
    private LinearLayout gca;
    private LinearLayout gcb;
    private LinearLayout gcc;
    private TbImageView gcd;
    private TextView gce;
    private TextView gcf;
    private TextView gcg;
    private ProgressBar gch;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
    }

    public void a(com.baidu.live.tieba.pb.interactionpopupwindow.c cVar) {
        this.gbR = cVar;
    }

    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.d
    public int getLayout() {
        return a.h.ala_challenge_reward_dialog;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.d
    public void a(AlaChallengeRewardData alaChallengeRewardData) {
        if (alaChallengeRewardData != null) {
            this.gbQ = alaChallengeRewardData;
            if (this.gbQ.isUseAllIn()) {
                this.gbZ.setVisibility(0);
            } else {
                this.gbZ.setVisibility(8);
            }
            if (!StringHelper.isEmpty(alaChallengeRewardData.mResultDescription)) {
                this.gbT.setText(alaChallengeRewardData.mResultDescription);
                this.gbT.setVisibility(0);
            } else {
                this.gbT.setVisibility(8);
            }
            if (this.gbQ.getChallengeResult() == 2) {
                this.gbS.setText(getTbPageContext().getResources().getString(a.i.ala_pk_success_reward_tip));
            } else if (this.gbQ.getChallengeResult() == 0) {
                this.gbS.setText(getTbPageContext().getResources().getString(a.i.ala_pk_fail_reward_tip));
            } else if (this.gbQ.getChallengeResult() == 1) {
                this.gbS.setText(getTbPageContext().getResources().getString(a.i.ala_pk_tie_reward_tip));
            }
            this.gcb.setVisibility(8);
            if (JavaTypesHelper.toInt(this.gbQ.streakSuccessNum, 0) > 1) {
                this.gcb.setVisibility(0);
                this.gbX.setText(this.gbQ.streakSuccessNum);
            }
            this.gbY.setText(String.format("%s%s", this.gbQ.successRateNum, "%"));
            this.gbU.setText(i.numFormatOverWanNaForAudienceNum(this.gbQ.watcherNum));
            if (this.gbQ.isUseAllIn() && this.gbQ.getChallengeResult() == 2) {
                this.gbV.setText(getTbPageContext().getResources().getString(a.i.ala_pk_reward_charm_num_label, i.numFormatOverWanNaForAudienceNum(this.gbQ.charmNum), this.gbQ.charmExt));
            } else {
                this.gbV.setText(i.numFormatOverWanNaForAudienceNum(this.gbQ.charmNum));
            }
            this.gbW.setText(i.numFormatOverWanNaForAudienceNum(this.gbQ.giftNum));
            if (this.gbQ.challengeLevelScore < 0 || this.gbQ.challengeLevelNextScore <= 0 || this.gbQ.challengeLevelScore > this.gbQ.challengeLevelNextScore) {
                this.gch.setVisibility(8);
                this.gcf.setVisibility(8);
                this.gcg.setVisibility(8);
                this.gcd.setVisibility(8);
                this.gce.setVisibility(8);
                return;
            }
            this.gch.setVisibility(0);
            this.gcf.setVisibility(0);
            this.gcg.setVisibility(0);
            this.gcd.setVisibility(0);
            this.gce.setVisibility(0);
            this.gcd.startLoad(this.gbQ.challengeLevelIcon, 10, false);
            this.gce.setText(this.gbQ.challengeLevelName);
            this.gch.setProgress((int) ((this.gbQ.challengeLevelScore * 100) / this.gbQ.challengeLevelNextScore));
            this.gcf.setText(String.valueOf(this.gbQ.challengeLevelScore));
            this.gcg.setText(String.format("%s%s", "/", Long.valueOf(this.gbQ.challengeLevelNextScore)));
        }
    }

    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.d
    public void initView() {
        this.gcb = (LinearLayout) getViewGroup().findViewById(a.g.reward_streak_win_layout);
        this.gbS = (TextView) getViewGroup().findViewById(a.g.reward_title);
        this.gbT = (TextView) getViewGroup().findViewById(a.g.reward_desc);
        this.gbU = (TextView) getViewGroup().findViewById(a.g.watch_cnt_value);
        this.gbV = (TextView) getViewGroup().findViewById(a.g.charm_value);
        this.gbW = (TextView) getViewGroup().findViewById(a.g.gift_num_value);
        this.gbX = (TextView) getViewGroup().findViewById(a.g.reward_streak_success);
        this.gbY = (TextView) getViewGroup().findViewById(a.g.reward_success_rate);
        this.gbZ = (ImageView) getViewGroup().findViewById(a.g.reward_all_in_icon);
        this.gcc = (LinearLayout) getViewGroup().findViewById(a.g.level_layout);
        this.gcd = (TbImageView) getViewGroup().findViewById(a.g.level_icon);
        this.gcd.setAutoChangeStyle(false);
        this.gcd.setIsNight(false);
        this.gce = (TextView) getViewGroup().findViewById(a.g.level_name);
        this.gcf = (TextView) getViewGroup().findViewById(a.g.level_cur_exp);
        this.gcg = (TextView) getViewGroup().findViewById(a.g.level_max_exp);
        this.gch = (ProgressBar) getViewGroup().findViewById(a.g.ala_challenge_level_progress);
        this.gca = (LinearLayout) getViewGroup().findViewById(a.g.ok);
        this.gca.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == a.g.ok && this.gbR != null) {
            this.gbR.dismiss();
        }
    }
}
