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
    private AlaChallengeRewardData hcL;
    private com.baidu.live.tieba.pb.interactionpopupwindow.c hcM;
    private TextView hcN;
    private TextView hcO;
    private TextView hcP;
    private TextView hcQ;
    private TextView hcR;
    private TextView hcS;
    private TextView hcT;
    private ImageView hcU;
    private LinearLayout hcV;
    private LinearLayout hcW;
    private LinearLayout hcX;
    private TbImageView hcY;
    private TextView hcZ;
    private TextView hda;
    private TextView hdb;
    private ProgressBar hdc;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
    }

    public void a(com.baidu.live.tieba.pb.interactionpopupwindow.c cVar) {
        this.hcM = cVar;
    }

    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.d
    public int getLayout() {
        return a.g.ala_challenge_reward_dialog;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.d
    public void a(AlaChallengeRewardData alaChallengeRewardData) {
        if (alaChallengeRewardData != null) {
            this.hcL = alaChallengeRewardData;
            if (this.hcL.isUseAllIn()) {
                this.hcU.setVisibility(0);
            } else {
                this.hcU.setVisibility(8);
            }
            if (!StringHelper.isEmpty(alaChallengeRewardData.mResultDescription)) {
                this.hcO.setText(alaChallengeRewardData.mResultDescription);
                this.hcO.setVisibility(0);
            } else {
                this.hcO.setVisibility(8);
            }
            if (this.hcL.getChallengeResult() == 2) {
                this.hcN.setText(getTbPageContext().getResources().getString(a.h.ala_pk_success_reward_tip));
            } else if (this.hcL.getChallengeResult() == 0) {
                this.hcN.setText(getTbPageContext().getResources().getString(a.h.ala_pk_fail_reward_tip));
            } else if (this.hcL.getChallengeResult() == 1) {
                this.hcN.setText(getTbPageContext().getResources().getString(a.h.ala_pk_tie_reward_tip));
            }
            this.hcW.setVisibility(8);
            if (JavaTypesHelper.toInt(this.hcL.streakSuccessNum, 0) > 1) {
                this.hcW.setVisibility(0);
                this.hcS.setText(this.hcL.streakSuccessNum);
            }
            this.hcT.setText(String.format("%s%s", this.hcL.successRateNum, "%"));
            this.hcP.setText(j.numFormatOverWanNaForAudienceNum(this.hcL.watcherNum));
            if (this.hcL.isUseAllIn() && this.hcL.getChallengeResult() == 2) {
                this.hcQ.setText(getTbPageContext().getResources().getString(a.h.ala_pk_reward_charm_num_label, j.numFormatOverWanNaForAudienceNum(this.hcL.charmNum), this.hcL.charmExt));
            } else {
                this.hcQ.setText(j.numFormatOverWanNaForAudienceNum(this.hcL.charmNum));
            }
            this.hcR.setText(j.numFormatOverWanNaForAudienceNum(this.hcL.giftNum));
            if (this.hcL.challengeLevelScore < 0 || this.hcL.challengeLevelNextScore <= 0 || this.hcL.challengeLevelScore > this.hcL.challengeLevelNextScore) {
                this.hdc.setVisibility(8);
                this.hda.setVisibility(8);
                this.hdb.setVisibility(8);
                this.hcY.setVisibility(8);
                this.hcZ.setVisibility(8);
                return;
            }
            this.hdc.setVisibility(0);
            this.hda.setVisibility(0);
            this.hdb.setVisibility(0);
            this.hcY.setVisibility(0);
            this.hcZ.setVisibility(0);
            this.hcY.startLoad(this.hcL.challengeLevelIcon, 10, false);
            this.hcZ.setText(this.hcL.challengeLevelName);
            this.hdc.setProgress((int) ((this.hcL.challengeLevelScore * 100) / this.hcL.challengeLevelNextScore));
            this.hda.setText(String.valueOf(this.hcL.challengeLevelScore));
            this.hdb.setText(String.format("%s%s", "/", Long.valueOf(this.hcL.challengeLevelNextScore)));
        }
    }

    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.d
    public void initView() {
        this.hcW = (LinearLayout) getViewGroup().findViewById(a.f.reward_streak_win_layout);
        this.hcN = (TextView) getViewGroup().findViewById(a.f.reward_title);
        this.hcO = (TextView) getViewGroup().findViewById(a.f.reward_desc);
        this.hcP = (TextView) getViewGroup().findViewById(a.f.watch_cnt_value);
        this.hcQ = (TextView) getViewGroup().findViewById(a.f.charm_value);
        this.hcR = (TextView) getViewGroup().findViewById(a.f.gift_num_value);
        this.hcS = (TextView) getViewGroup().findViewById(a.f.reward_streak_success);
        this.hcT = (TextView) getViewGroup().findViewById(a.f.reward_success_rate);
        this.hcU = (ImageView) getViewGroup().findViewById(a.f.reward_all_in_icon);
        this.hcX = (LinearLayout) getViewGroup().findViewById(a.f.level_layout);
        this.hcY = (TbImageView) getViewGroup().findViewById(a.f.level_icon);
        this.hcY.setAutoChangeStyle(false);
        this.hcY.setIsNight(false);
        this.hcZ = (TextView) getViewGroup().findViewById(a.f.level_name);
        this.hda = (TextView) getViewGroup().findViewById(a.f.level_cur_exp);
        this.hdb = (TextView) getViewGroup().findViewById(a.f.level_max_exp);
        this.hdc = (ProgressBar) getViewGroup().findViewById(a.f.ala_challenge_level_progress);
        this.hcV = (LinearLayout) getViewGroup().findViewById(a.f.ok);
        this.hcV.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == a.f.ok && this.hcM != null) {
            this.hcM.dismiss();
        }
    }
}
