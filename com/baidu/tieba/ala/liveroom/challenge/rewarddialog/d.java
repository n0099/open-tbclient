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
    private AlaChallengeRewardData hxU;
    private com.baidu.live.tieba.pb.interactionpopupwindow.c hxV;
    private TextView hxW;
    private TextView hxX;
    private TextView hxY;
    private TextView hxZ;
    private TextView hya;
    private TextView hyb;
    private TextView hyc;
    private ImageView hyd;
    private LinearLayout hye;
    private LinearLayout hyf;
    private LinearLayout hyg;
    private TbImageView hyh;
    private TextView hyi;
    private TextView hyj;
    private TextView hyk;
    private ProgressBar hyl;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
    }

    public void a(com.baidu.live.tieba.pb.interactionpopupwindow.c cVar) {
        this.hxV = cVar;
    }

    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.d
    public int getLayout() {
        return a.g.ala_challenge_reward_dialog;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.d
    public void a(AlaChallengeRewardData alaChallengeRewardData) {
        if (alaChallengeRewardData != null) {
            this.hxU = alaChallengeRewardData;
            if (this.hxU.isUseAllIn()) {
                this.hyd.setVisibility(0);
            } else {
                this.hyd.setVisibility(8);
            }
            if (!StringHelper.isEmpty(alaChallengeRewardData.mResultDescription)) {
                this.hxX.setText(alaChallengeRewardData.mResultDescription);
                this.hxX.setVisibility(0);
            } else {
                this.hxX.setVisibility(8);
            }
            if (this.hxU.getChallengeResult() == 2) {
                this.hxW.setText(getTbPageContext().getResources().getString(a.h.ala_pk_success_reward_tip));
            } else if (this.hxU.getChallengeResult() == 0) {
                this.hxW.setText(getTbPageContext().getResources().getString(a.h.ala_pk_fail_reward_tip));
            } else if (this.hxU.getChallengeResult() == 1) {
                this.hxW.setText(getTbPageContext().getResources().getString(a.h.ala_pk_tie_reward_tip));
            }
            this.hyf.setVisibility(8);
            if (JavaTypesHelper.toInt(this.hxU.streakSuccessNum, 0) > 1) {
                this.hyf.setVisibility(0);
                this.hyb.setText(this.hxU.streakSuccessNum);
            }
            this.hyc.setText(String.format("%s%s", this.hxU.successRateNum, "%"));
            this.hxY.setText(j.numFormatOverWanNaForAudienceNum(this.hxU.watcherNum));
            if (this.hxU.isUseAllIn() && this.hxU.getChallengeResult() == 2) {
                this.hxZ.setText(getTbPageContext().getResources().getString(a.h.ala_pk_reward_charm_num_label, j.numFormatOverWanNaForAudienceNum(this.hxU.charmNum), this.hxU.charmExt));
            } else {
                this.hxZ.setText(j.numFormatOverWanNaForAudienceNum(this.hxU.charmNum));
            }
            this.hya.setText(j.numFormatOverWanNaForAudienceNum(this.hxU.giftNum));
            if (this.hxU.challengeLevelScore < 0 || this.hxU.challengeLevelNextScore <= 0 || this.hxU.challengeLevelScore > this.hxU.challengeLevelNextScore) {
                this.hyl.setVisibility(8);
                this.hyj.setVisibility(8);
                this.hyk.setVisibility(8);
                this.hyh.setVisibility(8);
                this.hyi.setVisibility(8);
                return;
            }
            this.hyl.setVisibility(0);
            this.hyj.setVisibility(0);
            this.hyk.setVisibility(0);
            this.hyh.setVisibility(0);
            this.hyi.setVisibility(0);
            this.hyh.startLoad(this.hxU.challengeLevelIcon, 10, false);
            this.hyi.setText(this.hxU.challengeLevelName);
            this.hyl.setProgress((int) ((this.hxU.challengeLevelScore * 100) / this.hxU.challengeLevelNextScore));
            this.hyj.setText(String.valueOf(this.hxU.challengeLevelScore));
            this.hyk.setText(String.format("%s%s", "/", Long.valueOf(this.hxU.challengeLevelNextScore)));
        }
    }

    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.d
    public void initView() {
        this.hyf = (LinearLayout) getViewGroup().findViewById(a.f.reward_streak_win_layout);
        this.hxW = (TextView) getViewGroup().findViewById(a.f.reward_title);
        this.hxX = (TextView) getViewGroup().findViewById(a.f.reward_desc);
        this.hxY = (TextView) getViewGroup().findViewById(a.f.watch_cnt_value);
        this.hxZ = (TextView) getViewGroup().findViewById(a.f.charm_value);
        this.hya = (TextView) getViewGroup().findViewById(a.f.gift_num_value);
        this.hyb = (TextView) getViewGroup().findViewById(a.f.reward_streak_success);
        this.hyc = (TextView) getViewGroup().findViewById(a.f.reward_success_rate);
        this.hyd = (ImageView) getViewGroup().findViewById(a.f.reward_all_in_icon);
        this.hyg = (LinearLayout) getViewGroup().findViewById(a.f.level_layout);
        this.hyh = (TbImageView) getViewGroup().findViewById(a.f.level_icon);
        this.hyh.setAutoChangeStyle(false);
        this.hyh.setIsNight(false);
        this.hyi = (TextView) getViewGroup().findViewById(a.f.level_name);
        this.hyj = (TextView) getViewGroup().findViewById(a.f.level_cur_exp);
        this.hyk = (TextView) getViewGroup().findViewById(a.f.level_max_exp);
        this.hyl = (ProgressBar) getViewGroup().findViewById(a.f.ala_challenge_level_progress);
        this.hye = (LinearLayout) getViewGroup().findViewById(a.f.ok);
        this.hye.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == a.f.ok && this.hxV != null) {
            this.hxV.dismiss();
        }
    }
}
