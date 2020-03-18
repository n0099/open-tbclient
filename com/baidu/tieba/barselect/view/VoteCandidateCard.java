package com.baidu.tieba.barselect.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
import com.baidu.tieba.barselect.data.f;
import com.baidu.tieba.barselect.segment.CandidateInfoLayout;
import com.baidu.tieba.barselect.segment.CardBasicLayout;
import com.baidu.tieba.barselect.segment.NewAnounceLayout;
import com.baidu.tieba.barselect.segment.VoteAreaLayout;
import com.baidu.tieba.barselect.segment.VotedAreaLayout;
/* loaded from: classes8.dex */
public class VoteCandidateCard extends CardBasicLayout {
    public static int fHp = -1;
    private View cey;
    private View fHA;
    private View fHB;
    private View fHC;
    private View fHD;
    private View fHE;
    private VotedAreaLayout fHk;
    private TextView fHq;
    private View fHr;
    private TextView fHs;
    private TextView fHt;
    private CandidateInfoLayout fHu;
    private NewAnounceLayout fHv;
    private VoteAreaLayout fHw;
    private View fHx;
    private TextView fHy;
    private TextView fHz;
    private Context mContext;
    private int position;

    public VoteCandidateCard(Context context) {
        this(context, null);
    }

    public VoteCandidateCard(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.position = -2;
        initUI();
    }

    private void initUI() {
        this.mContext = getContext();
        setClipChildren(false);
        setClipToPadding(false);
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        LayoutInflater.from(getContext()).inflate(R.layout.vote_candidate_card, (ViewGroup) this, true);
        ns();
    }

    private void ns() {
        this.fHr = findViewById(R.id.mine_vote_content);
        this.fHs = (TextView) findViewById(R.id.mine_vote_title);
        this.fHt = (TextView) findViewById(R.id.mine_vote_num);
        this.fHq = (TextView) findViewById(R.id.tv_voted_rank);
        this.fHu = (CandidateInfoLayout) findViewById(R.id.candidate_info_layout);
        this.fHv = (NewAnounceLayout) findViewById(R.id.announce_layout);
        this.fHw = (VoteAreaLayout) findViewById(R.id.vote_area_layout);
        this.fHk = (VotedAreaLayout) findViewById(R.id.voted_area_layout);
        this.cey = findViewById(R.id.divider_line);
        this.fHA = findViewById(R.id.divider_empty_view);
        this.fHB = findViewById(R.id.divider_line_container);
        this.fHC = findViewById(R.id.empty_view);
        this.fHD = findViewById(R.id.main_container);
        this.fHE = findViewById(R.id.info_container);
        this.fHx = findViewById(R.id.vote_ueg_warn_container);
        this.fHy = (TextView) findViewById(R.id.vote_ueg_warn_img);
        this.fHz = (TextView) findViewById(R.id.vote_ueg_warn_tv);
    }

    @Override // com.baidu.tieba.barselect.segment.CardBasicLayout
    public void setData(int i, f fVar) {
        super.setData(i, fVar);
        this.position = i;
        if (this.fDc == null || this.fGM == null || this.status < 0) {
            setVisibility(8);
            return;
        }
        if (this.status == com.baidu.tieba.barselect.a.a.fHd) {
            this.fHD.setBackgroundResource(R.drawable.bar_select_bg_shadow_and_radius);
            this.fHr.setVisibility(0);
            this.fHt.setText("当前排名" + this.fGM.getRank());
            setRankVisible(8);
            this.fHB.setVisibility(8);
            this.fHw.setVisibility(0);
            this.fHk.setVisibility(8);
            this.fHw.setData(i, fVar);
        } else if (this.status == com.baidu.tieba.barselect.a.a.fHa) {
            if (i == 0) {
                this.fHB.setVisibility(8);
            } else {
                this.fHB.setVisibility(8);
                this.fHA.setVisibility(8);
            }
            this.fHD.setBackgroundColor(getResources().getColor(R.color.cp_bg_line_d));
            this.fHr.setVisibility(8);
            setRankVisible(8);
            this.fHw.setVisibility(0);
            this.fHk.setVisibility(8);
            this.fHw.setData(i, fVar);
        } else if (this.status == com.baidu.tieba.barselect.a.a.fHc) {
            int dimens = l.getDimens(getContext(), R.dimen.tbds22);
            int dimens2 = l.getDimens(getContext(), R.dimen.tbds10);
            int dimens3 = l.getDimens(getContext(), R.dimen.tbds20);
            int dimens4 = l.getDimens(getContext(), R.dimen.tbds30);
            this.fHD.setBackgroundResource(R.drawable.bg_bazhu_shadow_and_radius);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.setMargins(dimens4, 0, dimens4, dimens3);
            this.fHD.setLayoutParams(layoutParams);
            this.fHD.setPadding(dimens2, 0, dimens2, dimens4);
            this.fHr.setVisibility(8);
            this.fHB.setVisibility(8);
            setRankVisible(8);
            this.fHw.setVisibility(8);
            this.fHk.setVisibility(0);
            this.fHk.setData(i, fVar);
            this.fHE.setPadding(0, dimens, 0, 0);
        } else if (this.status == com.baidu.tieba.barselect.a.a.fHb) {
            if (i == 1) {
                this.fHD.setBackgroundResource(R.drawable.bar_select_bg_top_round);
                this.fHB.setVisibility(8);
            } else {
                this.fHD.setBackgroundColor(getResources().getColor(R.color.cp_bg_line_d));
                this.fHB.setVisibility(0);
                this.fHA.setVisibility(0);
            }
            setRankVisible(0);
            this.fHr.setVisibility(8);
            int rank = this.fGM.getRank();
            if (rank < 10) {
                this.fHq.setText("0" + rank);
            } else {
                this.fHq.setText("" + rank);
            }
            if (rank == 2) {
                this.fHq.setTextColor(getResources().getColor(R.color.common_color_10263));
            } else if (rank == 3) {
                this.fHq.setTextColor(getResources().getColor(R.color.common_color_10266));
            } else {
                this.fHq.setTextColor(getResources().getColor(R.color.cp_cont_b));
            }
            this.fHw.setVisibility(8);
            this.fHk.setVisibility(0);
            this.fHk.setData(i, fVar);
        } else {
            setVisibility(8);
            return;
        }
        this.fHu.setData(i, fVar);
        this.fHv.setData(i, fVar);
        if (this.fGM.bue()) {
            this.fHx.setVisibility(0);
        } else {
            this.fHx.setVisibility(8);
        }
        pm(TbadkCoreApplication.getInst().getSkinType());
    }

    public void pm(int i) {
        this.fHv.pm(i);
        this.fHu.pm(i);
        if (this.fHk.getVisibility() == 0) {
            this.fHk.pm(i);
        }
        this.fHw.pm(i);
        am.setBackgroundColor(this.cey, R.color.cp_bg_line_c, i);
        if (this.status == com.baidu.tieba.barselect.a.a.fHd) {
            am.setBackgroundResource(this.fHD, R.drawable.bar_select_bg_shadow_and_radius, i);
            am.setViewTextColor(this.fHt, R.color.cp_cont_b, 1, i);
            am.setViewTextColor(this.fHs, R.color.cp_cont_b, 1, i);
        } else if (this.status == com.baidu.tieba.barselect.a.a.fHc) {
            am.setBackgroundResource(this.fHD, R.drawable.bg_bazhu_shadow_and_radius, i);
        } else if (this.status == com.baidu.tieba.barselect.a.a.fHb) {
            if (this.position == 1) {
                am.setBackgroundResource(this.fHD, R.drawable.bar_select_bg_top_round, i);
            } else {
                am.setBackgroundColor(this.fHD, R.color.cp_bg_line_d, i);
            }
        } else if (this.status == com.baidu.tieba.barselect.a.a.fHa) {
            am.setBackgroundColor(this.fHD, R.color.cp_bg_line_d, i);
        }
        if (this.fGM != null) {
            if (this.fGM.bue()) {
                am.setViewTextColor(this.fHz, R.color.cp_cont_h, 1, i);
                am.setBackgroundResource(this.fHy, R.drawable.icon_use_tip_red, i);
            }
            int rank = this.fGM.getRank();
            if (rank == 2) {
                am.setViewTextColor(this.fHq, R.color.cp_link_tip_d, 1, i);
            } else if (rank == 3) {
                am.setViewTextColor(this.fHq, R.color.cp_other_f, 1, i);
            } else {
                am.setViewTextColor(this.fHq, R.color.cp_cont_b, 1, i);
            }
        }
    }

    private void setRankVisible(int i) {
        this.fHq.setVisibility(i);
        this.fHC.setVisibility(i);
    }
}
