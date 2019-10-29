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
    private AlaChallengeRewardData ece;
    private com.baidu.live.tieba.pb.interactionpopupwindow.c ecf;
    private TextView ecg;
    private TextView ech;
    private TextView eci;
    private TextView ecj;
    private TextView eck;
    private TextView ecl;
    private TextView ecm;
    private ImageView ecn;
    private LinearLayout eco;
    private LinearLayout ecp;
    private LinearLayout ecq;
    private TbImageView ecr;
    private TextView ecs;
    private TextView ect;
    private TextView ecu;
    private ProgressBar ecv;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
    }

    public void a(com.baidu.live.tieba.pb.interactionpopupwindow.c cVar) {
        this.ecf = cVar;
    }

    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.d
    public int getLayout() {
        return a.h.ala_challenge_reward_dialog;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.d
    public void a(AlaChallengeRewardData alaChallengeRewardData) {
        if (alaChallengeRewardData != null) {
            this.ece = alaChallengeRewardData;
            if (this.ece.isUseAllIn()) {
                this.ecn.setVisibility(0);
            } else {
                this.ecn.setVisibility(8);
            }
            if (!StringHelper.isEmpty(alaChallengeRewardData.mResultDescription)) {
                this.ech.setText(alaChallengeRewardData.mResultDescription);
                this.ech.setVisibility(0);
            } else {
                this.ech.setVisibility(8);
            }
            if (this.ece.getChallengeResult() == 2) {
                this.ecg.setText(getTbPageContext().getResources().getString(a.i.ala_pk_success_reward_tip));
            } else if (this.ece.getChallengeResult() == 0) {
                this.ecg.setText(getTbPageContext().getResources().getString(a.i.ala_pk_fail_reward_tip));
            } else if (this.ece.getChallengeResult() == 1) {
                this.ecg.setText(getTbPageContext().getResources().getString(a.i.ala_pk_tie_reward_tip));
            }
            this.ecp.setVisibility(8);
            if (JavaTypesHelper.toInt(this.ece.streakSuccessNum, 0) > 1) {
                this.ecp.setVisibility(0);
                this.ecl.setText(this.ece.streakSuccessNum);
            }
            this.ecm.setText(String.format("%s%s", this.ece.successRateNum, "%"));
            this.eci.setText(h.numFormatOverWanNaForAudienceNum(this.ece.watcherNum));
            if (this.ece.isUseAllIn() && this.ece.getChallengeResult() == 2) {
                this.ecj.setText(getTbPageContext().getResources().getString(a.i.ala_pk_reward_charm_num_label, h.numFormatOverWanNaForAudienceNum(this.ece.charmNum), this.ece.charmExt));
            } else {
                this.ecj.setText(h.numFormatOverWanNaForAudienceNum(this.ece.charmNum));
            }
            this.eck.setText(h.numFormatOverWanNaForAudienceNum(this.ece.giftNum));
            if (this.ece.challengeLevelScore < 0 || this.ece.challengeLevelNextScore <= 0 || this.ece.challengeLevelScore > this.ece.challengeLevelNextScore) {
                this.ecv.setVisibility(8);
                this.ect.setVisibility(8);
                this.ecu.setVisibility(8);
                this.ecr.setVisibility(8);
                this.ecs.setVisibility(8);
                return;
            }
            this.ecv.setVisibility(0);
            this.ect.setVisibility(0);
            this.ecu.setVisibility(0);
            this.ecr.setVisibility(0);
            this.ecs.setVisibility(0);
            this.ecr.startLoad(this.ece.challengeLevelIcon, 10, false);
            this.ecs.setText(this.ece.challengeLevelName);
            this.ecv.setProgress((int) ((this.ece.challengeLevelScore * 100) / this.ece.challengeLevelNextScore));
            this.ect.setText(String.valueOf(this.ece.challengeLevelScore));
            this.ecu.setText(String.format("%s%s", "/", Long.valueOf(this.ece.challengeLevelNextScore)));
        }
    }

    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.d
    public void initView() {
        this.ecp = (LinearLayout) getViewGroup().findViewById(a.g.reward_streak_win_layout);
        this.ecg = (TextView) getViewGroup().findViewById(a.g.reward_title);
        this.ech = (TextView) getViewGroup().findViewById(a.g.reward_desc);
        this.eci = (TextView) getViewGroup().findViewById(a.g.watch_cnt_value);
        this.ecj = (TextView) getViewGroup().findViewById(a.g.charm_value);
        this.eck = (TextView) getViewGroup().findViewById(a.g.gift_num_value);
        this.ecl = (TextView) getViewGroup().findViewById(a.g.reward_streak_success);
        this.ecm = (TextView) getViewGroup().findViewById(a.g.reward_success_rate);
        this.ecn = (ImageView) getViewGroup().findViewById(a.g.reward_all_in_icon);
        this.ecq = (LinearLayout) getViewGroup().findViewById(a.g.level_layout);
        this.ecr = (TbImageView) getViewGroup().findViewById(a.g.level_icon);
        this.ecr.setAutoChangeStyle(false);
        this.ecr.setIsNight(false);
        this.ecs = (TextView) getViewGroup().findViewById(a.g.level_name);
        this.ect = (TextView) getViewGroup().findViewById(a.g.level_cur_exp);
        this.ecu = (TextView) getViewGroup().findViewById(a.g.level_max_exp);
        this.ecv = (ProgressBar) getViewGroup().findViewById(a.g.ala_challenge_level_progress);
        this.eco = (LinearLayout) getViewGroup().findViewById(a.g.ok);
        this.eco.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == a.g.ok && this.ecf != null) {
            this.ecf.dismiss();
        }
    }
}
