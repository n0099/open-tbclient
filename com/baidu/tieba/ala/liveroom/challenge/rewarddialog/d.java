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
    private AlaChallengeRewardData hde;
    private com.baidu.live.tieba.pb.interactionpopupwindow.c hdf;
    private TextView hdg;
    private TextView hdh;
    private TextView hdi;
    private TextView hdj;
    private TextView hdk;
    private TextView hdl;
    private TextView hdm;
    private ImageView hdn;
    private LinearLayout hdo;
    private LinearLayout hdp;
    private LinearLayout hdq;
    private TbImageView hdr;
    private TextView hds;
    private TextView hdt;
    private TextView hdu;
    private ProgressBar hdv;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
    }

    public void a(com.baidu.live.tieba.pb.interactionpopupwindow.c cVar) {
        this.hdf = cVar;
    }

    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.d
    public int getLayout() {
        return a.g.ala_challenge_reward_dialog;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.d
    public void a(AlaChallengeRewardData alaChallengeRewardData) {
        if (alaChallengeRewardData != null) {
            this.hde = alaChallengeRewardData;
            if (this.hde.isUseAllIn()) {
                this.hdn.setVisibility(0);
            } else {
                this.hdn.setVisibility(8);
            }
            if (!StringHelper.isEmpty(alaChallengeRewardData.mResultDescription)) {
                this.hdh.setText(alaChallengeRewardData.mResultDescription);
                this.hdh.setVisibility(0);
            } else {
                this.hdh.setVisibility(8);
            }
            if (this.hde.getChallengeResult() == 2) {
                this.hdg.setText(getTbPageContext().getResources().getString(a.h.ala_pk_success_reward_tip));
            } else if (this.hde.getChallengeResult() == 0) {
                this.hdg.setText(getTbPageContext().getResources().getString(a.h.ala_pk_fail_reward_tip));
            } else if (this.hde.getChallengeResult() == 1) {
                this.hdg.setText(getTbPageContext().getResources().getString(a.h.ala_pk_tie_reward_tip));
            }
            this.hdp.setVisibility(8);
            if (JavaTypesHelper.toInt(this.hde.streakSuccessNum, 0) > 1) {
                this.hdp.setVisibility(0);
                this.hdl.setText(this.hde.streakSuccessNum);
            }
            this.hdm.setText(String.format("%s%s", this.hde.successRateNum, "%"));
            this.hdi.setText(j.numFormatOverWanNaForAudienceNum(this.hde.watcherNum));
            if (this.hde.isUseAllIn() && this.hde.getChallengeResult() == 2) {
                this.hdj.setText(getTbPageContext().getResources().getString(a.h.ala_pk_reward_charm_num_label, j.numFormatOverWanNaForAudienceNum(this.hde.charmNum), this.hde.charmExt));
            } else {
                this.hdj.setText(j.numFormatOverWanNaForAudienceNum(this.hde.charmNum));
            }
            this.hdk.setText(j.numFormatOverWanNaForAudienceNum(this.hde.giftNum));
            if (this.hde.challengeLevelScore < 0 || this.hde.challengeLevelNextScore <= 0 || this.hde.challengeLevelScore > this.hde.challengeLevelNextScore) {
                this.hdv.setVisibility(8);
                this.hdt.setVisibility(8);
                this.hdu.setVisibility(8);
                this.hdr.setVisibility(8);
                this.hds.setVisibility(8);
                return;
            }
            this.hdv.setVisibility(0);
            this.hdt.setVisibility(0);
            this.hdu.setVisibility(0);
            this.hdr.setVisibility(0);
            this.hds.setVisibility(0);
            this.hdr.startLoad(this.hde.challengeLevelIcon, 10, false);
            this.hds.setText(this.hde.challengeLevelName);
            this.hdv.setProgress((int) ((this.hde.challengeLevelScore * 100) / this.hde.challengeLevelNextScore));
            this.hdt.setText(String.valueOf(this.hde.challengeLevelScore));
            this.hdu.setText(String.format("%s%s", "/", Long.valueOf(this.hde.challengeLevelNextScore)));
        }
    }

    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.d
    public void initView() {
        this.hdp = (LinearLayout) getViewGroup().findViewById(a.f.reward_streak_win_layout);
        this.hdg = (TextView) getViewGroup().findViewById(a.f.reward_title);
        this.hdh = (TextView) getViewGroup().findViewById(a.f.reward_desc);
        this.hdi = (TextView) getViewGroup().findViewById(a.f.watch_cnt_value);
        this.hdj = (TextView) getViewGroup().findViewById(a.f.charm_value);
        this.hdk = (TextView) getViewGroup().findViewById(a.f.gift_num_value);
        this.hdl = (TextView) getViewGroup().findViewById(a.f.reward_streak_success);
        this.hdm = (TextView) getViewGroup().findViewById(a.f.reward_success_rate);
        this.hdn = (ImageView) getViewGroup().findViewById(a.f.reward_all_in_icon);
        this.hdq = (LinearLayout) getViewGroup().findViewById(a.f.level_layout);
        this.hdr = (TbImageView) getViewGroup().findViewById(a.f.level_icon);
        this.hdr.setAutoChangeStyle(false);
        this.hdr.setIsNight(false);
        this.hds = (TextView) getViewGroup().findViewById(a.f.level_name);
        this.hdt = (TextView) getViewGroup().findViewById(a.f.level_cur_exp);
        this.hdu = (TextView) getViewGroup().findViewById(a.f.level_max_exp);
        this.hdv = (ProgressBar) getViewGroup().findViewById(a.f.ala_challenge_level_progress);
        this.hdo = (LinearLayout) getViewGroup().findViewById(a.f.ok);
        this.hdo.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == a.f.ok && this.hdf != null) {
            this.hdf.dismiss();
        }
    }
}
