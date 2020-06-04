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
    public static int gBe = -1;
    private View eLr;
    private VotedAreaLayout gAW;
    private TextView gBf;
    private View gBg;
    private TextView gBh;
    private TextView gBi;
    private CandidateInfoLayout gBj;
    private NewAnounceLayout gBk;
    private VoteAreaLayout gBl;
    private View gBm;
    private TextView gBn;
    private TextView gBo;
    private View gBp;
    private View gBq;
    private View gBr;
    private View gBs;
    private View gBt;
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
        rV();
    }

    private void rV() {
        this.gBg = findViewById(R.id.mine_vote_content);
        this.gBh = (TextView) findViewById(R.id.mine_vote_title);
        this.gBi = (TextView) findViewById(R.id.mine_vote_num);
        this.gBf = (TextView) findViewById(R.id.tv_voted_rank);
        this.gBj = (CandidateInfoLayout) findViewById(R.id.candidate_info_layout);
        this.gBk = (NewAnounceLayout) findViewById(R.id.announce_layout);
        this.gBl = (VoteAreaLayout) findViewById(R.id.vote_area_layout);
        this.gAW = (VotedAreaLayout) findViewById(R.id.voted_area_layout);
        this.eLr = findViewById(R.id.divider_line);
        this.gBp = findViewById(R.id.divider_empty_view);
        this.gBq = findViewById(R.id.divider_line_container);
        this.gBr = findViewById(R.id.empty_view);
        this.gBs = findViewById(R.id.main_container);
        this.gBt = findViewById(R.id.info_container);
        this.gBm = findViewById(R.id.vote_ueg_warn_container);
        this.gBn = (TextView) findViewById(R.id.vote_ueg_warn_img);
        this.gBo = (TextView) findViewById(R.id.vote_ueg_warn_tv);
    }

    @Override // com.baidu.tieba.barselect.segment.CardBasicLayout
    public void setData(int i, f fVar) {
        super.setData(i, fVar);
        this.position = i;
        if (this.gwL == null || this.gAy == null || this.status < 0) {
            setVisibility(8);
            return;
        }
        if (this.status == com.baidu.tieba.barselect.a.a.gAP) {
            this.gBs.setBackgroundResource(R.drawable.bar_select_bg_shadow_and_radius);
            this.gBg.setVisibility(0);
            this.gBi.setText("当前排名" + this.gAy.getRank());
            setRankVisible(8);
            this.gBq.setVisibility(8);
            this.gBl.setVisibility(0);
            this.gAW.setVisibility(8);
            this.gBl.setData(i, fVar);
        } else if (this.status == com.baidu.tieba.barselect.a.a.gAM) {
            if (i == 0) {
                this.gBq.setVisibility(8);
            } else {
                this.gBq.setVisibility(8);
                this.gBp.setVisibility(8);
            }
            this.gBs.setBackgroundColor(getResources().getColor(R.color.cp_bg_line_d));
            this.gBg.setVisibility(8);
            setRankVisible(8);
            this.gBl.setVisibility(0);
            this.gAW.setVisibility(8);
            this.gBl.setData(i, fVar);
        } else if (this.status == com.baidu.tieba.barselect.a.a.gAO) {
            int dimens = l.getDimens(getContext(), R.dimen.tbds22);
            int dimens2 = l.getDimens(getContext(), R.dimen.tbds10);
            int dimens3 = l.getDimens(getContext(), R.dimen.tbds20);
            int dimens4 = l.getDimens(getContext(), R.dimen.tbds30);
            this.gBs.setBackgroundResource(R.drawable.bg_bazhu_shadow_and_radius);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.setMargins(dimens4, 0, dimens4, dimens3);
            this.gBs.setLayoutParams(layoutParams);
            this.gBs.setPadding(dimens2, 0, dimens2, dimens4);
            this.gBg.setVisibility(8);
            this.gBq.setVisibility(8);
            setRankVisible(8);
            this.gBl.setVisibility(8);
            this.gAW.setVisibility(0);
            this.gAW.setData(i, fVar);
            this.gBt.setPadding(0, dimens, 0, 0);
        } else if (this.status == com.baidu.tieba.barselect.a.a.gAN) {
            if (i == 1) {
                this.gBs.setBackgroundResource(R.drawable.bar_select_bg_top_round);
                this.gBq.setVisibility(8);
            } else {
                this.gBs.setBackgroundColor(getResources().getColor(R.color.cp_bg_line_d));
                this.gBq.setVisibility(0);
                this.gBp.setVisibility(0);
            }
            setRankVisible(0);
            this.gBg.setVisibility(8);
            int rank = this.gAy.getRank();
            if (rank < 10) {
                this.gBf.setText("0" + rank);
            } else {
                this.gBf.setText("" + rank);
            }
            if (rank == 2) {
                this.gBf.setTextColor(getResources().getColor(R.color.common_color_10263));
            } else if (rank == 3) {
                this.gBf.setTextColor(getResources().getColor(R.color.common_color_10266));
            } else {
                this.gBf.setTextColor(getResources().getColor(R.color.cp_cont_b));
            }
            this.gBl.setVisibility(8);
            this.gAW.setVisibility(0);
            this.gAW.setData(i, fVar);
        } else {
            setVisibility(8);
            return;
        }
        this.gBj.setData(i, fVar);
        this.gBk.setData(i, fVar);
        if (this.gAy.bKh()) {
            this.gBm.setVisibility(0);
        } else {
            this.gBm.setVisibility(8);
        }
        qk(TbadkCoreApplication.getInst().getSkinType());
    }

    public void qk(int i) {
        this.gBk.qk(i);
        this.gBj.qk(i);
        if (this.gAW.getVisibility() == 0) {
            this.gAW.qk(i);
        }
        this.gBl.qk(i);
        am.setBackgroundColor(this.eLr, R.color.cp_bg_line_c, i);
        if (this.status == com.baidu.tieba.barselect.a.a.gAP) {
            am.setBackgroundResource(this.gBs, R.drawable.bar_select_bg_shadow_and_radius, i);
            am.setViewTextColor(this.gBi, R.color.cp_cont_b, 1, i);
            am.setViewTextColor(this.gBh, R.color.cp_cont_b, 1, i);
        } else if (this.status == com.baidu.tieba.barselect.a.a.gAO) {
            am.setBackgroundResource(this.gBs, R.drawable.bg_bazhu_shadow_and_radius, i);
        } else if (this.status == com.baidu.tieba.barselect.a.a.gAN) {
            if (this.position == 1) {
                am.setBackgroundResource(this.gBs, R.drawable.bar_select_bg_top_round, i);
            } else {
                am.setBackgroundColor(this.gBs, R.color.cp_bg_line_d, i);
            }
        } else if (this.status == com.baidu.tieba.barselect.a.a.gAM) {
            am.setBackgroundColor(this.gBs, R.color.cp_bg_line_d, i);
        }
        if (this.gAy != null) {
            if (this.gAy.bKh()) {
                am.setViewTextColor(this.gBo, R.color.cp_cont_h, 1, i);
                am.setBackgroundResource(this.gBn, R.drawable.icon_use_tip_red, i);
            }
            int rank = this.gAy.getRank();
            if (rank == 2) {
                am.setViewTextColor(this.gBf, R.color.cp_link_tip_d, 1, i);
            } else if (rank == 3) {
                am.setViewTextColor(this.gBf, R.color.cp_other_f, 1, i);
            } else {
                am.setViewTextColor(this.gBf, R.color.cp_cont_b, 1, i);
            }
        }
    }

    private void setRankVisible(int i) {
        this.gBf.setVisibility(i);
        this.gBr.setVisibility(i);
    }
}
