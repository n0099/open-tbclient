package com.baidu.tieba.ala.liveroom.challenge.rewarddialog;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.live.adp.lib.safe.JavaTypesHelper;
import com.baidu.live.k.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.live.utils.h;
/* loaded from: classes6.dex */
public class d extends com.baidu.live.tieba.pb.interactionpopupwindow.b<AlaChallengeRewardData> implements View.OnClickListener {
    private TbImageView ebA;
    private TextView ebB;
    private TextView ebC;
    private TextView ebD;
    private ProgressBar ebE;
    private AlaChallengeRewardData ebn;
    private com.baidu.live.tieba.pb.interactionpopupwindow.c ebo;
    private TextView ebp;
    private TextView ebq;
    private TextView ebr;
    private TextView ebs;
    private TextView ebt;
    private TextView ebu;
    private TextView ebv;
    private ImageView ebw;
    private LinearLayout ebx;
    private LinearLayout eby;
    private LinearLayout ebz;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
    }

    public void a(com.baidu.live.tieba.pb.interactionpopupwindow.c cVar) {
        this.ebo = cVar;
    }

    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.d
    public int getLayout() {
        return a.h.ala_challenge_reward_dialog;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.d
    public void a(AlaChallengeRewardData alaChallengeRewardData) {
        if (alaChallengeRewardData != null) {
            this.ebn = alaChallengeRewardData;
            if (this.ebn.isUseAllIn()) {
                this.ebw.setVisibility(0);
            } else {
                this.ebw.setVisibility(8);
            }
            if (!StringHelper.isEmpty(alaChallengeRewardData.mResultDescription)) {
                this.ebq.setText(alaChallengeRewardData.mResultDescription);
                this.ebq.setVisibility(0);
            } else {
                this.ebq.setVisibility(8);
            }
            if (this.ebn.getChallengeResult() == 2) {
                this.ebp.setText(getTbPageContext().getResources().getString(a.i.ala_pk_success_reward_tip));
            } else if (this.ebn.getChallengeResult() == 0) {
                this.ebp.setText(getTbPageContext().getResources().getString(a.i.ala_pk_fail_reward_tip));
            } else if (this.ebn.getChallengeResult() == 1) {
                this.ebp.setText(getTbPageContext().getResources().getString(a.i.ala_pk_tie_reward_tip));
            }
            this.eby.setVisibility(8);
            if (JavaTypesHelper.toInt(this.ebn.streakSuccessNum, 0) > 1) {
                this.eby.setVisibility(0);
                this.ebu.setText(this.ebn.streakSuccessNum);
            }
            this.ebv.setText(String.format("%s%s", this.ebn.successRateNum, "%"));
            this.ebr.setText(h.numFormatOverWanNaForAudienceNum(this.ebn.watcherNum));
            if (this.ebn.isUseAllIn() && this.ebn.getChallengeResult() == 2) {
                this.ebs.setText(getTbPageContext().getResources().getString(a.i.ala_pk_reward_charm_num_label, h.numFormatOverWanNaForAudienceNum(this.ebn.charmNum), this.ebn.charmExt));
            } else {
                this.ebs.setText(h.numFormatOverWanNaForAudienceNum(this.ebn.charmNum));
            }
            this.ebt.setText(h.numFormatOverWanNaForAudienceNum(this.ebn.giftNum));
            if (this.ebn.challengeLevelScore < 0 || this.ebn.challengeLevelNextScore <= 0 || this.ebn.challengeLevelScore > this.ebn.challengeLevelNextScore) {
                this.ebE.setVisibility(8);
                this.ebC.setVisibility(8);
                this.ebD.setVisibility(8);
                this.ebA.setVisibility(8);
                this.ebB.setVisibility(8);
                return;
            }
            this.ebE.setVisibility(0);
            this.ebC.setVisibility(0);
            this.ebD.setVisibility(0);
            this.ebA.setVisibility(0);
            this.ebB.setVisibility(0);
            this.ebA.startLoad(this.ebn.challengeLevelIcon, 10, false);
            this.ebB.setText(this.ebn.challengeLevelName);
            this.ebE.setProgress((int) ((this.ebn.challengeLevelScore * 100) / this.ebn.challengeLevelNextScore));
            this.ebC.setText(String.valueOf(this.ebn.challengeLevelScore));
            this.ebD.setText(String.format("%s%s", "/", Long.valueOf(this.ebn.challengeLevelNextScore)));
        }
    }

    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.d
    public void initView() {
        this.eby = (LinearLayout) getViewGroup().findViewById(a.g.reward_streak_win_layout);
        this.ebp = (TextView) getViewGroup().findViewById(a.g.reward_title);
        this.ebq = (TextView) getViewGroup().findViewById(a.g.reward_desc);
        this.ebr = (TextView) getViewGroup().findViewById(a.g.watch_cnt_value);
        this.ebs = (TextView) getViewGroup().findViewById(a.g.charm_value);
        this.ebt = (TextView) getViewGroup().findViewById(a.g.gift_num_value);
        this.ebu = (TextView) getViewGroup().findViewById(a.g.reward_streak_success);
        this.ebv = (TextView) getViewGroup().findViewById(a.g.reward_success_rate);
        this.ebw = (ImageView) getViewGroup().findViewById(a.g.reward_all_in_icon);
        this.ebz = (LinearLayout) getViewGroup().findViewById(a.g.level_layout);
        this.ebA = (TbImageView) getViewGroup().findViewById(a.g.level_icon);
        this.ebA.setAutoChangeStyle(false);
        this.ebA.setIsNight(false);
        this.ebB = (TextView) getViewGroup().findViewById(a.g.level_name);
        this.ebC = (TextView) getViewGroup().findViewById(a.g.level_cur_exp);
        this.ebD = (TextView) getViewGroup().findViewById(a.g.level_max_exp);
        this.ebE = (ProgressBar) getViewGroup().findViewById(a.g.ala_challenge_level_progress);
        this.ebx = (LinearLayout) getViewGroup().findViewById(a.g.ok);
        this.ebx.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == a.g.ok && this.ebo != null) {
            this.ebo.dismiss();
        }
    }
}
