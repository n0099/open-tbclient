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
    private LinearLayout hyA;
    private LinearLayout hyB;
    private LinearLayout hyC;
    private TbImageView hyD;
    private TextView hyE;
    private TextView hyF;
    private TextView hyG;
    private ProgressBar hyH;
    private AlaChallengeRewardData hyq;
    private com.baidu.live.tieba.pb.interactionpopupwindow.c hyr;
    private TextView hys;
    private TextView hyt;
    private TextView hyu;
    private TextView hyv;
    private TextView hyw;
    private TextView hyx;
    private TextView hyy;
    private ImageView hyz;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
    }

    public void a(com.baidu.live.tieba.pb.interactionpopupwindow.c cVar) {
        this.hyr = cVar;
    }

    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.d
    public int getLayout() {
        return a.g.ala_challenge_reward_dialog;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.d
    public void a(AlaChallengeRewardData alaChallengeRewardData) {
        if (alaChallengeRewardData != null) {
            this.hyq = alaChallengeRewardData;
            if (this.hyq.isUseAllIn()) {
                this.hyz.setVisibility(0);
            } else {
                this.hyz.setVisibility(8);
            }
            if (!StringHelper.isEmpty(alaChallengeRewardData.mResultDescription)) {
                this.hyt.setText(alaChallengeRewardData.mResultDescription);
                this.hyt.setVisibility(0);
            } else {
                this.hyt.setVisibility(8);
            }
            if (this.hyq.getChallengeResult() == 2) {
                this.hys.setText(getTbPageContext().getResources().getString(a.h.ala_pk_success_reward_tip));
            } else if (this.hyq.getChallengeResult() == 0) {
                this.hys.setText(getTbPageContext().getResources().getString(a.h.ala_pk_fail_reward_tip));
            } else if (this.hyq.getChallengeResult() == 1) {
                this.hys.setText(getTbPageContext().getResources().getString(a.h.ala_pk_tie_reward_tip));
            }
            this.hyB.setVisibility(8);
            if (JavaTypesHelper.toInt(this.hyq.streakSuccessNum, 0) > 1) {
                this.hyB.setVisibility(0);
                this.hyx.setText(this.hyq.streakSuccessNum);
            }
            this.hyy.setText(String.format("%s%s", this.hyq.successRateNum, "%"));
            this.hyu.setText(j.numFormatOverWanNaForAudienceNum(this.hyq.watcherNum));
            if (this.hyq.isUseAllIn() && this.hyq.getChallengeResult() == 2) {
                this.hyv.setText(getTbPageContext().getResources().getString(a.h.ala_pk_reward_charm_num_label, j.numFormatOverWanNaForAudienceNum(this.hyq.charmNum), this.hyq.charmExt));
            } else {
                this.hyv.setText(j.numFormatOverWanNaForAudienceNum(this.hyq.charmNum));
            }
            this.hyw.setText(j.numFormatOverWanNaForAudienceNum(this.hyq.giftNum));
            if (this.hyq.challengeLevelScore < 0 || this.hyq.challengeLevelNextScore <= 0 || this.hyq.challengeLevelScore > this.hyq.challengeLevelNextScore) {
                this.hyH.setVisibility(8);
                this.hyF.setVisibility(8);
                this.hyG.setVisibility(8);
                this.hyD.setVisibility(8);
                this.hyE.setVisibility(8);
                return;
            }
            this.hyH.setVisibility(0);
            this.hyF.setVisibility(0);
            this.hyG.setVisibility(0);
            this.hyD.setVisibility(0);
            this.hyE.setVisibility(0);
            this.hyD.startLoad(this.hyq.challengeLevelIcon, 10, false);
            this.hyE.setText(this.hyq.challengeLevelName);
            this.hyH.setProgress((int) ((this.hyq.challengeLevelScore * 100) / this.hyq.challengeLevelNextScore));
            this.hyF.setText(String.valueOf(this.hyq.challengeLevelScore));
            this.hyG.setText(String.format("%s%s", "/", Long.valueOf(this.hyq.challengeLevelNextScore)));
        }
    }

    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.d
    public void initView() {
        this.hyB = (LinearLayout) getViewGroup().findViewById(a.f.reward_streak_win_layout);
        this.hys = (TextView) getViewGroup().findViewById(a.f.reward_title);
        this.hyt = (TextView) getViewGroup().findViewById(a.f.reward_desc);
        this.hyu = (TextView) getViewGroup().findViewById(a.f.watch_cnt_value);
        this.hyv = (TextView) getViewGroup().findViewById(a.f.charm_value);
        this.hyw = (TextView) getViewGroup().findViewById(a.f.gift_num_value);
        this.hyx = (TextView) getViewGroup().findViewById(a.f.reward_streak_success);
        this.hyy = (TextView) getViewGroup().findViewById(a.f.reward_success_rate);
        this.hyz = (ImageView) getViewGroup().findViewById(a.f.reward_all_in_icon);
        this.hyC = (LinearLayout) getViewGroup().findViewById(a.f.level_layout);
        this.hyD = (TbImageView) getViewGroup().findViewById(a.f.level_icon);
        this.hyD.setAutoChangeStyle(false);
        this.hyD.setIsNight(false);
        this.hyE = (TextView) getViewGroup().findViewById(a.f.level_name);
        this.hyF = (TextView) getViewGroup().findViewById(a.f.level_cur_exp);
        this.hyG = (TextView) getViewGroup().findViewById(a.f.level_max_exp);
        this.hyH = (ProgressBar) getViewGroup().findViewById(a.f.ala_challenge_level_progress);
        this.hyA = (LinearLayout) getViewGroup().findViewById(a.f.ok);
        this.hyA.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == a.f.ok && this.hyr != null) {
            this.hyr.dismiss();
        }
    }
}
