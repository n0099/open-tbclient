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
    private AlaChallengeRewardData fPU;
    private com.baidu.live.tieba.pb.interactionpopupwindow.c fPV;
    private TextView fPW;
    private TextView fPX;
    private TextView fPY;
    private TextView fPZ;
    private TextView fQa;
    private TextView fQb;
    private TextView fQc;
    private ImageView fQd;
    private LinearLayout fQe;
    private LinearLayout fQf;
    private LinearLayout fQg;
    private TbImageView fQh;
    private TextView fQi;
    private TextView fQj;
    private TextView fQk;
    private ProgressBar fQl;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
    }

    public void a(com.baidu.live.tieba.pb.interactionpopupwindow.c cVar) {
        this.fPV = cVar;
    }

    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.d
    public int getLayout() {
        return a.h.ala_challenge_reward_dialog;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.d
    public void a(AlaChallengeRewardData alaChallengeRewardData) {
        if (alaChallengeRewardData != null) {
            this.fPU = alaChallengeRewardData;
            if (this.fPU.isUseAllIn()) {
                this.fQd.setVisibility(0);
            } else {
                this.fQd.setVisibility(8);
            }
            if (!StringHelper.isEmpty(alaChallengeRewardData.mResultDescription)) {
                this.fPX.setText(alaChallengeRewardData.mResultDescription);
                this.fPX.setVisibility(0);
            } else {
                this.fPX.setVisibility(8);
            }
            if (this.fPU.getChallengeResult() == 2) {
                this.fPW.setText(getTbPageContext().getResources().getString(a.i.ala_pk_success_reward_tip));
            } else if (this.fPU.getChallengeResult() == 0) {
                this.fPW.setText(getTbPageContext().getResources().getString(a.i.ala_pk_fail_reward_tip));
            } else if (this.fPU.getChallengeResult() == 1) {
                this.fPW.setText(getTbPageContext().getResources().getString(a.i.ala_pk_tie_reward_tip));
            }
            this.fQf.setVisibility(8);
            if (JavaTypesHelper.toInt(this.fPU.streakSuccessNum, 0) > 1) {
                this.fQf.setVisibility(0);
                this.fQb.setText(this.fPU.streakSuccessNum);
            }
            this.fQc.setText(String.format("%s%s", this.fPU.successRateNum, "%"));
            this.fPY.setText(i.numFormatOverWanNaForAudienceNum(this.fPU.watcherNum));
            if (this.fPU.isUseAllIn() && this.fPU.getChallengeResult() == 2) {
                this.fPZ.setText(getTbPageContext().getResources().getString(a.i.ala_pk_reward_charm_num_label, i.numFormatOverWanNaForAudienceNum(this.fPU.charmNum), this.fPU.charmExt));
            } else {
                this.fPZ.setText(i.numFormatOverWanNaForAudienceNum(this.fPU.charmNum));
            }
            this.fQa.setText(i.numFormatOverWanNaForAudienceNum(this.fPU.giftNum));
            if (this.fPU.challengeLevelScore < 0 || this.fPU.challengeLevelNextScore <= 0 || this.fPU.challengeLevelScore > this.fPU.challengeLevelNextScore) {
                this.fQl.setVisibility(8);
                this.fQj.setVisibility(8);
                this.fQk.setVisibility(8);
                this.fQh.setVisibility(8);
                this.fQi.setVisibility(8);
                return;
            }
            this.fQl.setVisibility(0);
            this.fQj.setVisibility(0);
            this.fQk.setVisibility(0);
            this.fQh.setVisibility(0);
            this.fQi.setVisibility(0);
            this.fQh.startLoad(this.fPU.challengeLevelIcon, 10, false);
            this.fQi.setText(this.fPU.challengeLevelName);
            this.fQl.setProgress((int) ((this.fPU.challengeLevelScore * 100) / this.fPU.challengeLevelNextScore));
            this.fQj.setText(String.valueOf(this.fPU.challengeLevelScore));
            this.fQk.setText(String.format("%s%s", "/", Long.valueOf(this.fPU.challengeLevelNextScore)));
        }
    }

    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.d
    public void initView() {
        this.fQf = (LinearLayout) getViewGroup().findViewById(a.g.reward_streak_win_layout);
        this.fPW = (TextView) getViewGroup().findViewById(a.g.reward_title);
        this.fPX = (TextView) getViewGroup().findViewById(a.g.reward_desc);
        this.fPY = (TextView) getViewGroup().findViewById(a.g.watch_cnt_value);
        this.fPZ = (TextView) getViewGroup().findViewById(a.g.charm_value);
        this.fQa = (TextView) getViewGroup().findViewById(a.g.gift_num_value);
        this.fQb = (TextView) getViewGroup().findViewById(a.g.reward_streak_success);
        this.fQc = (TextView) getViewGroup().findViewById(a.g.reward_success_rate);
        this.fQd = (ImageView) getViewGroup().findViewById(a.g.reward_all_in_icon);
        this.fQg = (LinearLayout) getViewGroup().findViewById(a.g.level_layout);
        this.fQh = (TbImageView) getViewGroup().findViewById(a.g.level_icon);
        this.fQh.setAutoChangeStyle(false);
        this.fQh.setIsNight(false);
        this.fQi = (TextView) getViewGroup().findViewById(a.g.level_name);
        this.fQj = (TextView) getViewGroup().findViewById(a.g.level_cur_exp);
        this.fQk = (TextView) getViewGroup().findViewById(a.g.level_max_exp);
        this.fQl = (ProgressBar) getViewGroup().findViewById(a.g.ala_challenge_level_progress);
        this.fQe = (LinearLayout) getViewGroup().findViewById(a.g.ok);
        this.fQe.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == a.g.ok && this.fPV != null) {
            this.fPV.dismiss();
        }
    }
}
