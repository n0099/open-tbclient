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
/* loaded from: classes7.dex */
public class d extends com.baidu.live.tieba.pb.interactionpopupwindow.b<AlaChallengeRewardData> implements View.OnClickListener {
    private TextView gtA;
    private TextView gtB;
    private ProgressBar gtC;
    private AlaChallengeRewardData gtl;
    private com.baidu.live.tieba.pb.interactionpopupwindow.c gtm;
    private TextView gtn;
    private TextView gto;
    private TextView gtp;
    private TextView gtq;
    private TextView gtr;
    private TextView gts;
    private TextView gtt;
    private ImageView gtu;
    private LinearLayout gtv;
    private LinearLayout gtw;
    private LinearLayout gtx;
    private TbImageView gty;
    private TextView gtz;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
    }

    public void a(com.baidu.live.tieba.pb.interactionpopupwindow.c cVar) {
        this.gtm = cVar;
    }

    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.d
    public int getLayout() {
        return a.h.ala_challenge_reward_dialog;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.d
    public void a(AlaChallengeRewardData alaChallengeRewardData) {
        if (alaChallengeRewardData != null) {
            this.gtl = alaChallengeRewardData;
            if (this.gtl.isUseAllIn()) {
                this.gtu.setVisibility(0);
            } else {
                this.gtu.setVisibility(8);
            }
            if (!StringHelper.isEmpty(alaChallengeRewardData.mResultDescription)) {
                this.gto.setText(alaChallengeRewardData.mResultDescription);
                this.gto.setVisibility(0);
            } else {
                this.gto.setVisibility(8);
            }
            if (this.gtl.getChallengeResult() == 2) {
                this.gtn.setText(getTbPageContext().getResources().getString(a.i.ala_pk_success_reward_tip));
            } else if (this.gtl.getChallengeResult() == 0) {
                this.gtn.setText(getTbPageContext().getResources().getString(a.i.ala_pk_fail_reward_tip));
            } else if (this.gtl.getChallengeResult() == 1) {
                this.gtn.setText(getTbPageContext().getResources().getString(a.i.ala_pk_tie_reward_tip));
            }
            this.gtw.setVisibility(8);
            if (JavaTypesHelper.toInt(this.gtl.streakSuccessNum, 0) > 1) {
                this.gtw.setVisibility(0);
                this.gts.setText(this.gtl.streakSuccessNum);
            }
            this.gtt.setText(String.format("%s%s", this.gtl.successRateNum, "%"));
            this.gtp.setText(i.numFormatOverWanNaForAudienceNum(this.gtl.watcherNum));
            if (this.gtl.isUseAllIn() && this.gtl.getChallengeResult() == 2) {
                this.gtq.setText(getTbPageContext().getResources().getString(a.i.ala_pk_reward_charm_num_label, i.numFormatOverWanNaForAudienceNum(this.gtl.charmNum), this.gtl.charmExt));
            } else {
                this.gtq.setText(i.numFormatOverWanNaForAudienceNum(this.gtl.charmNum));
            }
            this.gtr.setText(i.numFormatOverWanNaForAudienceNum(this.gtl.giftNum));
            if (this.gtl.challengeLevelScore < 0 || this.gtl.challengeLevelNextScore <= 0 || this.gtl.challengeLevelScore > this.gtl.challengeLevelNextScore) {
                this.gtC.setVisibility(8);
                this.gtA.setVisibility(8);
                this.gtB.setVisibility(8);
                this.gty.setVisibility(8);
                this.gtz.setVisibility(8);
                return;
            }
            this.gtC.setVisibility(0);
            this.gtA.setVisibility(0);
            this.gtB.setVisibility(0);
            this.gty.setVisibility(0);
            this.gtz.setVisibility(0);
            this.gty.startLoad(this.gtl.challengeLevelIcon, 10, false);
            this.gtz.setText(this.gtl.challengeLevelName);
            this.gtC.setProgress((int) ((this.gtl.challengeLevelScore * 100) / this.gtl.challengeLevelNextScore));
            this.gtA.setText(String.valueOf(this.gtl.challengeLevelScore));
            this.gtB.setText(String.format("%s%s", "/", Long.valueOf(this.gtl.challengeLevelNextScore)));
        }
    }

    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.d
    public void initView() {
        this.gtw = (LinearLayout) getViewGroup().findViewById(a.g.reward_streak_win_layout);
        this.gtn = (TextView) getViewGroup().findViewById(a.g.reward_title);
        this.gto = (TextView) getViewGroup().findViewById(a.g.reward_desc);
        this.gtp = (TextView) getViewGroup().findViewById(a.g.watch_cnt_value);
        this.gtq = (TextView) getViewGroup().findViewById(a.g.charm_value);
        this.gtr = (TextView) getViewGroup().findViewById(a.g.gift_num_value);
        this.gts = (TextView) getViewGroup().findViewById(a.g.reward_streak_success);
        this.gtt = (TextView) getViewGroup().findViewById(a.g.reward_success_rate);
        this.gtu = (ImageView) getViewGroup().findViewById(a.g.reward_all_in_icon);
        this.gtx = (LinearLayout) getViewGroup().findViewById(a.g.level_layout);
        this.gty = (TbImageView) getViewGroup().findViewById(a.g.level_icon);
        this.gty.setAutoChangeStyle(false);
        this.gty.setIsNight(false);
        this.gtz = (TextView) getViewGroup().findViewById(a.g.level_name);
        this.gtA = (TextView) getViewGroup().findViewById(a.g.level_cur_exp);
        this.gtB = (TextView) getViewGroup().findViewById(a.g.level_max_exp);
        this.gtC = (ProgressBar) getViewGroup().findViewById(a.g.ala_challenge_level_progress);
        this.gtv = (LinearLayout) getViewGroup().findViewById(a.g.ok);
        this.gtv.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == a.g.ok && this.gtm != null) {
            this.gtm.dismiss();
        }
    }
}
