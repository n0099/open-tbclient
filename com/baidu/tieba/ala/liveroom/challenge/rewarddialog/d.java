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
    private AlaChallengeRewardData gth;
    private com.baidu.live.tieba.pb.interactionpopupwindow.c gti;
    private TextView gtj;
    private TextView gtk;
    private TextView gtl;
    private TextView gtm;
    private TextView gtn;
    private TextView gto;
    private TextView gtp;
    private ImageView gtq;
    private LinearLayout gtr;
    private LinearLayout gts;
    private LinearLayout gtt;
    private TbImageView gtu;
    private TextView gtv;
    private TextView gtw;
    private TextView gtx;
    private ProgressBar gty;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
    }

    public void a(com.baidu.live.tieba.pb.interactionpopupwindow.c cVar) {
        this.gti = cVar;
    }

    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.d
    public int getLayout() {
        return a.h.ala_challenge_reward_dialog;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.d
    public void a(AlaChallengeRewardData alaChallengeRewardData) {
        if (alaChallengeRewardData != null) {
            this.gth = alaChallengeRewardData;
            if (this.gth.isUseAllIn()) {
                this.gtq.setVisibility(0);
            } else {
                this.gtq.setVisibility(8);
            }
            if (!StringHelper.isEmpty(alaChallengeRewardData.mResultDescription)) {
                this.gtk.setText(alaChallengeRewardData.mResultDescription);
                this.gtk.setVisibility(0);
            } else {
                this.gtk.setVisibility(8);
            }
            if (this.gth.getChallengeResult() == 2) {
                this.gtj.setText(getTbPageContext().getResources().getString(a.i.ala_pk_success_reward_tip));
            } else if (this.gth.getChallengeResult() == 0) {
                this.gtj.setText(getTbPageContext().getResources().getString(a.i.ala_pk_fail_reward_tip));
            } else if (this.gth.getChallengeResult() == 1) {
                this.gtj.setText(getTbPageContext().getResources().getString(a.i.ala_pk_tie_reward_tip));
            }
            this.gts.setVisibility(8);
            if (JavaTypesHelper.toInt(this.gth.streakSuccessNum, 0) > 1) {
                this.gts.setVisibility(0);
                this.gto.setText(this.gth.streakSuccessNum);
            }
            this.gtp.setText(String.format("%s%s", this.gth.successRateNum, "%"));
            this.gtl.setText(i.numFormatOverWanNaForAudienceNum(this.gth.watcherNum));
            if (this.gth.isUseAllIn() && this.gth.getChallengeResult() == 2) {
                this.gtm.setText(getTbPageContext().getResources().getString(a.i.ala_pk_reward_charm_num_label, i.numFormatOverWanNaForAudienceNum(this.gth.charmNum), this.gth.charmExt));
            } else {
                this.gtm.setText(i.numFormatOverWanNaForAudienceNum(this.gth.charmNum));
            }
            this.gtn.setText(i.numFormatOverWanNaForAudienceNum(this.gth.giftNum));
            if (this.gth.challengeLevelScore < 0 || this.gth.challengeLevelNextScore <= 0 || this.gth.challengeLevelScore > this.gth.challengeLevelNextScore) {
                this.gty.setVisibility(8);
                this.gtw.setVisibility(8);
                this.gtx.setVisibility(8);
                this.gtu.setVisibility(8);
                this.gtv.setVisibility(8);
                return;
            }
            this.gty.setVisibility(0);
            this.gtw.setVisibility(0);
            this.gtx.setVisibility(0);
            this.gtu.setVisibility(0);
            this.gtv.setVisibility(0);
            this.gtu.startLoad(this.gth.challengeLevelIcon, 10, false);
            this.gtv.setText(this.gth.challengeLevelName);
            this.gty.setProgress((int) ((this.gth.challengeLevelScore * 100) / this.gth.challengeLevelNextScore));
            this.gtw.setText(String.valueOf(this.gth.challengeLevelScore));
            this.gtx.setText(String.format("%s%s", "/", Long.valueOf(this.gth.challengeLevelNextScore)));
        }
    }

    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.d
    public void initView() {
        this.gts = (LinearLayout) getViewGroup().findViewById(a.g.reward_streak_win_layout);
        this.gtj = (TextView) getViewGroup().findViewById(a.g.reward_title);
        this.gtk = (TextView) getViewGroup().findViewById(a.g.reward_desc);
        this.gtl = (TextView) getViewGroup().findViewById(a.g.watch_cnt_value);
        this.gtm = (TextView) getViewGroup().findViewById(a.g.charm_value);
        this.gtn = (TextView) getViewGroup().findViewById(a.g.gift_num_value);
        this.gto = (TextView) getViewGroup().findViewById(a.g.reward_streak_success);
        this.gtp = (TextView) getViewGroup().findViewById(a.g.reward_success_rate);
        this.gtq = (ImageView) getViewGroup().findViewById(a.g.reward_all_in_icon);
        this.gtt = (LinearLayout) getViewGroup().findViewById(a.g.level_layout);
        this.gtu = (TbImageView) getViewGroup().findViewById(a.g.level_icon);
        this.gtu.setAutoChangeStyle(false);
        this.gtu.setIsNight(false);
        this.gtv = (TextView) getViewGroup().findViewById(a.g.level_name);
        this.gtw = (TextView) getViewGroup().findViewById(a.g.level_cur_exp);
        this.gtx = (TextView) getViewGroup().findViewById(a.g.level_max_exp);
        this.gty = (ProgressBar) getViewGroup().findViewById(a.g.ala_challenge_level_progress);
        this.gtr = (LinearLayout) getViewGroup().findViewById(a.g.ok);
        this.gtr.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == a.g.ok && this.gti != null) {
            this.gti.dismiss();
        }
    }
}
