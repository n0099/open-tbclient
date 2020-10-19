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
    private TextView gLA;
    private TextView gLB;
    private ProgressBar gLC;
    private AlaChallengeRewardData gLl;
    private com.baidu.live.tieba.pb.interactionpopupwindow.c gLm;
    private TextView gLn;
    private TextView gLo;
    private TextView gLp;
    private TextView gLq;
    private TextView gLr;
    private TextView gLs;
    private TextView gLt;
    private ImageView gLu;
    private LinearLayout gLv;
    private LinearLayout gLw;
    private LinearLayout gLx;
    private TbImageView gLy;
    private TextView gLz;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
    }

    public void a(com.baidu.live.tieba.pb.interactionpopupwindow.c cVar) {
        this.gLm = cVar;
    }

    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.d
    public int getLayout() {
        return a.h.ala_challenge_reward_dialog;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.d
    public void a(AlaChallengeRewardData alaChallengeRewardData) {
        if (alaChallengeRewardData != null) {
            this.gLl = alaChallengeRewardData;
            if (this.gLl.isUseAllIn()) {
                this.gLu.setVisibility(0);
            } else {
                this.gLu.setVisibility(8);
            }
            if (!StringHelper.isEmpty(alaChallengeRewardData.mResultDescription)) {
                this.gLo.setText(alaChallengeRewardData.mResultDescription);
                this.gLo.setVisibility(0);
            } else {
                this.gLo.setVisibility(8);
            }
            if (this.gLl.getChallengeResult() == 2) {
                this.gLn.setText(getTbPageContext().getResources().getString(a.i.ala_pk_success_reward_tip));
            } else if (this.gLl.getChallengeResult() == 0) {
                this.gLn.setText(getTbPageContext().getResources().getString(a.i.ala_pk_fail_reward_tip));
            } else if (this.gLl.getChallengeResult() == 1) {
                this.gLn.setText(getTbPageContext().getResources().getString(a.i.ala_pk_tie_reward_tip));
            }
            this.gLw.setVisibility(8);
            if (JavaTypesHelper.toInt(this.gLl.streakSuccessNum, 0) > 1) {
                this.gLw.setVisibility(0);
                this.gLs.setText(this.gLl.streakSuccessNum);
            }
            this.gLt.setText(String.format("%s%s", this.gLl.successRateNum, "%"));
            this.gLp.setText(j.numFormatOverWanNaForAudienceNum(this.gLl.watcherNum));
            if (this.gLl.isUseAllIn() && this.gLl.getChallengeResult() == 2) {
                this.gLq.setText(getTbPageContext().getResources().getString(a.i.ala_pk_reward_charm_num_label, j.numFormatOverWanNaForAudienceNum(this.gLl.charmNum), this.gLl.charmExt));
            } else {
                this.gLq.setText(j.numFormatOverWanNaForAudienceNum(this.gLl.charmNum));
            }
            this.gLr.setText(j.numFormatOverWanNaForAudienceNum(this.gLl.giftNum));
            if (this.gLl.challengeLevelScore < 0 || this.gLl.challengeLevelNextScore <= 0 || this.gLl.challengeLevelScore > this.gLl.challengeLevelNextScore) {
                this.gLC.setVisibility(8);
                this.gLA.setVisibility(8);
                this.gLB.setVisibility(8);
                this.gLy.setVisibility(8);
                this.gLz.setVisibility(8);
                return;
            }
            this.gLC.setVisibility(0);
            this.gLA.setVisibility(0);
            this.gLB.setVisibility(0);
            this.gLy.setVisibility(0);
            this.gLz.setVisibility(0);
            this.gLy.startLoad(this.gLl.challengeLevelIcon, 10, false);
            this.gLz.setText(this.gLl.challengeLevelName);
            this.gLC.setProgress((int) ((this.gLl.challengeLevelScore * 100) / this.gLl.challengeLevelNextScore));
            this.gLA.setText(String.valueOf(this.gLl.challengeLevelScore));
            this.gLB.setText(String.format("%s%s", "/", Long.valueOf(this.gLl.challengeLevelNextScore)));
        }
    }

    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.d
    public void initView() {
        this.gLw = (LinearLayout) getViewGroup().findViewById(a.g.reward_streak_win_layout);
        this.gLn = (TextView) getViewGroup().findViewById(a.g.reward_title);
        this.gLo = (TextView) getViewGroup().findViewById(a.g.reward_desc);
        this.gLp = (TextView) getViewGroup().findViewById(a.g.watch_cnt_value);
        this.gLq = (TextView) getViewGroup().findViewById(a.g.charm_value);
        this.gLr = (TextView) getViewGroup().findViewById(a.g.gift_num_value);
        this.gLs = (TextView) getViewGroup().findViewById(a.g.reward_streak_success);
        this.gLt = (TextView) getViewGroup().findViewById(a.g.reward_success_rate);
        this.gLu = (ImageView) getViewGroup().findViewById(a.g.reward_all_in_icon);
        this.gLx = (LinearLayout) getViewGroup().findViewById(a.g.level_layout);
        this.gLy = (TbImageView) getViewGroup().findViewById(a.g.level_icon);
        this.gLy.setAutoChangeStyle(false);
        this.gLy.setIsNight(false);
        this.gLz = (TextView) getViewGroup().findViewById(a.g.level_name);
        this.gLA = (TextView) getViewGroup().findViewById(a.g.level_cur_exp);
        this.gLB = (TextView) getViewGroup().findViewById(a.g.level_max_exp);
        this.gLC = (ProgressBar) getViewGroup().findViewById(a.g.ala_challenge_level_progress);
        this.gLv = (LinearLayout) getViewGroup().findViewById(a.g.ok);
        this.gLv.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == a.g.ok && this.gLm != null) {
            this.gLm.dismiss();
        }
    }
}
