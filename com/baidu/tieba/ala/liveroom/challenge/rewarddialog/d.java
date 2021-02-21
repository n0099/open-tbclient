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
/* loaded from: classes11.dex */
public class d extends com.baidu.live.tieba.pb.interactionpopupwindow.b<AlaChallengeRewardData> implements View.OnClickListener {
    private AlaChallengeRewardData hyi;
    private com.baidu.live.tieba.pb.interactionpopupwindow.c hyj;
    private TextView hyk;
    private TextView hyl;
    private TextView hym;
    private TextView hyn;
    private TextView hyo;
    private TextView hyp;
    private TextView hyq;
    private ImageView hyr;
    private LinearLayout hys;
    private LinearLayout hyt;
    private LinearLayout hyu;
    private TbImageView hyv;
    private TextView hyw;
    private TextView hyx;
    private TextView hyy;
    private ProgressBar hyz;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
    }

    public void a(com.baidu.live.tieba.pb.interactionpopupwindow.c cVar) {
        this.hyj = cVar;
    }

    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.d
    public int getLayout() {
        return a.g.ala_challenge_reward_dialog;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.d
    public void a(AlaChallengeRewardData alaChallengeRewardData) {
        if (alaChallengeRewardData != null) {
            this.hyi = alaChallengeRewardData;
            if (this.hyi.isUseAllIn()) {
                this.hyr.setVisibility(0);
            } else {
                this.hyr.setVisibility(8);
            }
            if (!StringHelper.isEmpty(alaChallengeRewardData.mResultDescription)) {
                this.hyl.setText(alaChallengeRewardData.mResultDescription);
                this.hyl.setVisibility(0);
            } else {
                this.hyl.setVisibility(8);
            }
            if (this.hyi.getChallengeResult() == 2) {
                this.hyk.setText(getTbPageContext().getResources().getString(a.h.ala_pk_success_reward_tip));
            } else if (this.hyi.getChallengeResult() == 0) {
                this.hyk.setText(getTbPageContext().getResources().getString(a.h.ala_pk_fail_reward_tip));
            } else if (this.hyi.getChallengeResult() == 1) {
                this.hyk.setText(getTbPageContext().getResources().getString(a.h.ala_pk_tie_reward_tip));
            }
            this.hyt.setVisibility(8);
            if (JavaTypesHelper.toInt(this.hyi.streakSuccessNum, 0) > 1) {
                this.hyt.setVisibility(0);
                this.hyp.setText(this.hyi.streakSuccessNum);
            }
            this.hyq.setText(String.format("%s%s", this.hyi.successRateNum, "%"));
            this.hym.setText(j.numFormatOverWanNaForAudienceNum(this.hyi.watcherNum));
            if (this.hyi.isUseAllIn() && this.hyi.getChallengeResult() == 2) {
                this.hyn.setText(getTbPageContext().getResources().getString(a.h.ala_pk_reward_charm_num_label, j.numFormatOverWanNaForAudienceNum(this.hyi.charmNum), this.hyi.charmExt));
            } else {
                this.hyn.setText(j.numFormatOverWanNaForAudienceNum(this.hyi.charmNum));
            }
            this.hyo.setText(j.numFormatOverWanNaForAudienceNum(this.hyi.giftNum));
            if (this.hyi.challengeLevelScore < 0 || this.hyi.challengeLevelNextScore <= 0 || this.hyi.challengeLevelScore > this.hyi.challengeLevelNextScore) {
                this.hyz.setVisibility(8);
                this.hyx.setVisibility(8);
                this.hyy.setVisibility(8);
                this.hyv.setVisibility(8);
                this.hyw.setVisibility(8);
                return;
            }
            this.hyz.setVisibility(0);
            this.hyx.setVisibility(0);
            this.hyy.setVisibility(0);
            this.hyv.setVisibility(0);
            this.hyw.setVisibility(0);
            this.hyv.startLoad(this.hyi.challengeLevelIcon, 10, false);
            this.hyw.setText(this.hyi.challengeLevelName);
            this.hyz.setProgress((int) ((this.hyi.challengeLevelScore * 100) / this.hyi.challengeLevelNextScore));
            this.hyx.setText(String.valueOf(this.hyi.challengeLevelScore));
            this.hyy.setText(String.format("%s%s", "/", Long.valueOf(this.hyi.challengeLevelNextScore)));
        }
    }

    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.d
    public void initView() {
        this.hyt = (LinearLayout) getViewGroup().findViewById(a.f.reward_streak_win_layout);
        this.hyk = (TextView) getViewGroup().findViewById(a.f.reward_title);
        this.hyl = (TextView) getViewGroup().findViewById(a.f.reward_desc);
        this.hym = (TextView) getViewGroup().findViewById(a.f.watch_cnt_value);
        this.hyn = (TextView) getViewGroup().findViewById(a.f.charm_value);
        this.hyo = (TextView) getViewGroup().findViewById(a.f.gift_num_value);
        this.hyp = (TextView) getViewGroup().findViewById(a.f.reward_streak_success);
        this.hyq = (TextView) getViewGroup().findViewById(a.f.reward_success_rate);
        this.hyr = (ImageView) getViewGroup().findViewById(a.f.reward_all_in_icon);
        this.hyu = (LinearLayout) getViewGroup().findViewById(a.f.level_layout);
        this.hyv = (TbImageView) getViewGroup().findViewById(a.f.level_icon);
        this.hyv.setAutoChangeStyle(false);
        this.hyv.setIsNight(false);
        this.hyw = (TextView) getViewGroup().findViewById(a.f.level_name);
        this.hyx = (TextView) getViewGroup().findViewById(a.f.level_cur_exp);
        this.hyy = (TextView) getViewGroup().findViewById(a.f.level_max_exp);
        this.hyz = (ProgressBar) getViewGroup().findViewById(a.f.ala_challenge_level_progress);
        this.hys = (LinearLayout) getViewGroup().findViewById(a.f.ok);
        this.hys.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == a.f.ok && this.hyj != null) {
            this.hyj.dismiss();
        }
    }
}
