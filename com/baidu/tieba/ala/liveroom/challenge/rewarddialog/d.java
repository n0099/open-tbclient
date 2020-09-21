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
    private AlaChallengeRewardData gwS;
    private com.baidu.live.tieba.pb.interactionpopupwindow.c gwT;
    private TextView gwU;
    private TextView gwV;
    private TextView gwW;
    private TextView gwX;
    private TextView gwY;
    private TextView gwZ;
    private TextView gxa;
    private ImageView gxb;
    private LinearLayout gxc;
    private LinearLayout gxd;
    private LinearLayout gxe;
    private TbImageView gxf;
    private TextView gxg;
    private TextView gxh;
    private TextView gxi;
    private ProgressBar gxj;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
    }

    public void a(com.baidu.live.tieba.pb.interactionpopupwindow.c cVar) {
        this.gwT = cVar;
    }

    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.d
    public int getLayout() {
        return a.h.ala_challenge_reward_dialog;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.d
    public void a(AlaChallengeRewardData alaChallengeRewardData) {
        if (alaChallengeRewardData != null) {
            this.gwS = alaChallengeRewardData;
            if (this.gwS.isUseAllIn()) {
                this.gxb.setVisibility(0);
            } else {
                this.gxb.setVisibility(8);
            }
            if (!StringHelper.isEmpty(alaChallengeRewardData.mResultDescription)) {
                this.gwV.setText(alaChallengeRewardData.mResultDescription);
                this.gwV.setVisibility(0);
            } else {
                this.gwV.setVisibility(8);
            }
            if (this.gwS.getChallengeResult() == 2) {
                this.gwU.setText(getTbPageContext().getResources().getString(a.i.ala_pk_success_reward_tip));
            } else if (this.gwS.getChallengeResult() == 0) {
                this.gwU.setText(getTbPageContext().getResources().getString(a.i.ala_pk_fail_reward_tip));
            } else if (this.gwS.getChallengeResult() == 1) {
                this.gwU.setText(getTbPageContext().getResources().getString(a.i.ala_pk_tie_reward_tip));
            }
            this.gxd.setVisibility(8);
            if (JavaTypesHelper.toInt(this.gwS.streakSuccessNum, 0) > 1) {
                this.gxd.setVisibility(0);
                this.gwZ.setText(this.gwS.streakSuccessNum);
            }
            this.gxa.setText(String.format("%s%s", this.gwS.successRateNum, "%"));
            this.gwW.setText(j.numFormatOverWanNaForAudienceNum(this.gwS.watcherNum));
            if (this.gwS.isUseAllIn() && this.gwS.getChallengeResult() == 2) {
                this.gwX.setText(getTbPageContext().getResources().getString(a.i.ala_pk_reward_charm_num_label, j.numFormatOverWanNaForAudienceNum(this.gwS.charmNum), this.gwS.charmExt));
            } else {
                this.gwX.setText(j.numFormatOverWanNaForAudienceNum(this.gwS.charmNum));
            }
            this.gwY.setText(j.numFormatOverWanNaForAudienceNum(this.gwS.giftNum));
            if (this.gwS.challengeLevelScore < 0 || this.gwS.challengeLevelNextScore <= 0 || this.gwS.challengeLevelScore > this.gwS.challengeLevelNextScore) {
                this.gxj.setVisibility(8);
                this.gxh.setVisibility(8);
                this.gxi.setVisibility(8);
                this.gxf.setVisibility(8);
                this.gxg.setVisibility(8);
                return;
            }
            this.gxj.setVisibility(0);
            this.gxh.setVisibility(0);
            this.gxi.setVisibility(0);
            this.gxf.setVisibility(0);
            this.gxg.setVisibility(0);
            this.gxf.startLoad(this.gwS.challengeLevelIcon, 10, false);
            this.gxg.setText(this.gwS.challengeLevelName);
            this.gxj.setProgress((int) ((this.gwS.challengeLevelScore * 100) / this.gwS.challengeLevelNextScore));
            this.gxh.setText(String.valueOf(this.gwS.challengeLevelScore));
            this.gxi.setText(String.format("%s%s", "/", Long.valueOf(this.gwS.challengeLevelNextScore)));
        }
    }

    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.d
    public void initView() {
        this.gxd = (LinearLayout) getViewGroup().findViewById(a.g.reward_streak_win_layout);
        this.gwU = (TextView) getViewGroup().findViewById(a.g.reward_title);
        this.gwV = (TextView) getViewGroup().findViewById(a.g.reward_desc);
        this.gwW = (TextView) getViewGroup().findViewById(a.g.watch_cnt_value);
        this.gwX = (TextView) getViewGroup().findViewById(a.g.charm_value);
        this.gwY = (TextView) getViewGroup().findViewById(a.g.gift_num_value);
        this.gwZ = (TextView) getViewGroup().findViewById(a.g.reward_streak_success);
        this.gxa = (TextView) getViewGroup().findViewById(a.g.reward_success_rate);
        this.gxb = (ImageView) getViewGroup().findViewById(a.g.reward_all_in_icon);
        this.gxe = (LinearLayout) getViewGroup().findViewById(a.g.level_layout);
        this.gxf = (TbImageView) getViewGroup().findViewById(a.g.level_icon);
        this.gxf.setAutoChangeStyle(false);
        this.gxf.setIsNight(false);
        this.gxg = (TextView) getViewGroup().findViewById(a.g.level_name);
        this.gxh = (TextView) getViewGroup().findViewById(a.g.level_cur_exp);
        this.gxi = (TextView) getViewGroup().findViewById(a.g.level_max_exp);
        this.gxj = (ProgressBar) getViewGroup().findViewById(a.g.ala_challenge_level_progress);
        this.gxc = (LinearLayout) getViewGroup().findViewById(a.g.ok);
        this.gxc.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == a.g.ok && this.gwT != null) {
            this.gwT.dismiss();
        }
    }
}
