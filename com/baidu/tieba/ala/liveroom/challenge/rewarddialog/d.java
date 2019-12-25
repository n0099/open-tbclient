package com.baidu.tieba.ala.liveroom.challenge.rewarddialog;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.live.adp.lib.safe.JavaTypesHelper;
import com.baidu.live.q.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.live.utils.i;
/* loaded from: classes2.dex */
public class d extends com.baidu.live.tieba.pb.interactionpopupwindow.b<AlaChallengeRewardData> implements View.OnClickListener {
    private AlaChallengeRewardData eRi;
    private com.baidu.live.tieba.pb.interactionpopupwindow.c eRj;
    private TextView eRk;
    private TextView eRl;
    private TextView eRm;
    private TextView eRn;
    private TextView eRo;
    private TextView eRp;
    private TextView eRq;
    private ImageView eRr;
    private LinearLayout eRs;
    private LinearLayout eRt;
    private LinearLayout eRu;
    private TbImageView eRv;
    private TextView eRw;
    private TextView eRx;
    private TextView eRy;
    private ProgressBar eRz;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
    }

    public void a(com.baidu.live.tieba.pb.interactionpopupwindow.c cVar) {
        this.eRj = cVar;
    }

    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.d
    public int getLayout() {
        return a.h.ala_challenge_reward_dialog;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.d
    public void a(AlaChallengeRewardData alaChallengeRewardData) {
        if (alaChallengeRewardData != null) {
            this.eRi = alaChallengeRewardData;
            if (this.eRi.isUseAllIn()) {
                this.eRr.setVisibility(0);
            } else {
                this.eRr.setVisibility(8);
            }
            if (!StringHelper.isEmpty(alaChallengeRewardData.mResultDescription)) {
                this.eRl.setText(alaChallengeRewardData.mResultDescription);
                this.eRl.setVisibility(0);
            } else {
                this.eRl.setVisibility(8);
            }
            if (this.eRi.getChallengeResult() == 2) {
                this.eRk.setText(getTbPageContext().getResources().getString(a.i.ala_pk_success_reward_tip));
            } else if (this.eRi.getChallengeResult() == 0) {
                this.eRk.setText(getTbPageContext().getResources().getString(a.i.ala_pk_fail_reward_tip));
            } else if (this.eRi.getChallengeResult() == 1) {
                this.eRk.setText(getTbPageContext().getResources().getString(a.i.ala_pk_tie_reward_tip));
            }
            this.eRt.setVisibility(8);
            if (JavaTypesHelper.toInt(this.eRi.streakSuccessNum, 0) > 1) {
                this.eRt.setVisibility(0);
                this.eRp.setText(this.eRi.streakSuccessNum);
            }
            this.eRq.setText(String.format("%s%s", this.eRi.successRateNum, "%"));
            this.eRm.setText(i.numFormatOverWanNaForAudienceNum(this.eRi.watcherNum));
            if (this.eRi.isUseAllIn() && this.eRi.getChallengeResult() == 2) {
                this.eRn.setText(getTbPageContext().getResources().getString(a.i.ala_pk_reward_charm_num_label, i.numFormatOverWanNaForAudienceNum(this.eRi.charmNum), this.eRi.charmExt));
            } else {
                this.eRn.setText(i.numFormatOverWanNaForAudienceNum(this.eRi.charmNum));
            }
            this.eRo.setText(i.numFormatOverWanNaForAudienceNum(this.eRi.giftNum));
            if (this.eRi.challengeLevelScore < 0 || this.eRi.challengeLevelNextScore <= 0 || this.eRi.challengeLevelScore > this.eRi.challengeLevelNextScore) {
                this.eRz.setVisibility(8);
                this.eRx.setVisibility(8);
                this.eRy.setVisibility(8);
                this.eRv.setVisibility(8);
                this.eRw.setVisibility(8);
                return;
            }
            this.eRz.setVisibility(0);
            this.eRx.setVisibility(0);
            this.eRy.setVisibility(0);
            this.eRv.setVisibility(0);
            this.eRw.setVisibility(0);
            this.eRv.startLoad(this.eRi.challengeLevelIcon, 10, false);
            this.eRw.setText(this.eRi.challengeLevelName);
            this.eRz.setProgress((int) ((this.eRi.challengeLevelScore * 100) / this.eRi.challengeLevelNextScore));
            this.eRx.setText(String.valueOf(this.eRi.challengeLevelScore));
            this.eRy.setText(String.format("%s%s", "/", Long.valueOf(this.eRi.challengeLevelNextScore)));
        }
    }

    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.d
    public void initView() {
        this.eRt = (LinearLayout) getViewGroup().findViewById(a.g.reward_streak_win_layout);
        this.eRk = (TextView) getViewGroup().findViewById(a.g.reward_title);
        this.eRl = (TextView) getViewGroup().findViewById(a.g.reward_desc);
        this.eRm = (TextView) getViewGroup().findViewById(a.g.watch_cnt_value);
        this.eRn = (TextView) getViewGroup().findViewById(a.g.charm_value);
        this.eRo = (TextView) getViewGroup().findViewById(a.g.gift_num_value);
        this.eRp = (TextView) getViewGroup().findViewById(a.g.reward_streak_success);
        this.eRq = (TextView) getViewGroup().findViewById(a.g.reward_success_rate);
        this.eRr = (ImageView) getViewGroup().findViewById(a.g.reward_all_in_icon);
        this.eRu = (LinearLayout) getViewGroup().findViewById(a.g.level_layout);
        this.eRv = (TbImageView) getViewGroup().findViewById(a.g.level_icon);
        this.eRv.setAutoChangeStyle(false);
        this.eRv.setIsNight(false);
        this.eRw = (TextView) getViewGroup().findViewById(a.g.level_name);
        this.eRx = (TextView) getViewGroup().findViewById(a.g.level_cur_exp);
        this.eRy = (TextView) getViewGroup().findViewById(a.g.level_max_exp);
        this.eRz = (ProgressBar) getViewGroup().findViewById(a.g.ala_challenge_level_progress);
        this.eRs = (LinearLayout) getViewGroup().findViewById(a.g.ok);
        this.eRs.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == a.g.ok && this.eRj != null) {
            this.eRj.dismiss();
        }
    }
}
