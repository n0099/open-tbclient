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
/* loaded from: classes6.dex */
public class VoteCandidateCard extends CardBasicLayout {
    public static int fDV = -1;
    private View caf;
    private VotedAreaLayout fDQ;
    private TextView fDW;
    private View fDX;
    private TextView fDY;
    private TextView fDZ;
    private CandidateInfoLayout fEa;
    private NewAnounceLayout fEb;
    private VoteAreaLayout fEc;
    private View fEd;
    private TextView fEe;
    private TextView fEf;
    private View fEg;
    private View fEh;
    private View fEi;
    private View fEj;
    private View fEk;
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
        nb();
    }

    private void nb() {
        this.fDX = findViewById(R.id.mine_vote_content);
        this.fDY = (TextView) findViewById(R.id.mine_vote_title);
        this.fDZ = (TextView) findViewById(R.id.mine_vote_num);
        this.fDW = (TextView) findViewById(R.id.tv_voted_rank);
        this.fEa = (CandidateInfoLayout) findViewById(R.id.candidate_info_layout);
        this.fEb = (NewAnounceLayout) findViewById(R.id.announce_layout);
        this.fEc = (VoteAreaLayout) findViewById(R.id.vote_area_layout);
        this.fDQ = (VotedAreaLayout) findViewById(R.id.voted_area_layout);
        this.caf = findViewById(R.id.divider_line);
        this.fEg = findViewById(R.id.divider_empty_view);
        this.fEh = findViewById(R.id.divider_line_container);
        this.fEi = findViewById(R.id.empty_view);
        this.fEj = findViewById(R.id.main_container);
        this.fEk = findViewById(R.id.info_container);
        this.fEd = findViewById(R.id.vote_ueg_warn_container);
        this.fEe = (TextView) findViewById(R.id.vote_ueg_warn_img);
        this.fEf = (TextView) findViewById(R.id.vote_ueg_warn_tv);
    }

    @Override // com.baidu.tieba.barselect.segment.CardBasicLayout
    public void setData(int i, f fVar) {
        super.setData(i, fVar);
        this.position = i;
        if (this.fzH == null || this.fDs == null || this.status < 0) {
            setVisibility(8);
            return;
        }
        if (this.status == com.baidu.tieba.barselect.a.a.fDJ) {
            this.fEj.setBackgroundResource(R.drawable.bar_select_bg_shadow_and_radius);
            this.fDX.setVisibility(0);
            this.fDZ.setText("当前排名" + this.fDs.getRank());
            setRankVisible(8);
            this.fEh.setVisibility(8);
            this.fEc.setVisibility(0);
            this.fDQ.setVisibility(8);
            this.fEc.setData(i, fVar);
        } else if (this.status == com.baidu.tieba.barselect.a.a.fDG) {
            if (i == 0) {
                this.fEh.setVisibility(8);
            } else {
                this.fEh.setVisibility(8);
                this.fEg.setVisibility(8);
            }
            this.fEj.setBackgroundColor(getResources().getColor(R.color.cp_bg_line_d));
            this.fDX.setVisibility(8);
            setRankVisible(8);
            this.fEc.setVisibility(0);
            this.fDQ.setVisibility(8);
            this.fEc.setData(i, fVar);
        } else if (this.status == com.baidu.tieba.barselect.a.a.fDI) {
            int dimens = l.getDimens(getContext(), R.dimen.tbds22);
            int dimens2 = l.getDimens(getContext(), R.dimen.tbds10);
            int dimens3 = l.getDimens(getContext(), R.dimen.tbds20);
            int dimens4 = l.getDimens(getContext(), R.dimen.tbds30);
            this.fEj.setBackgroundResource(R.drawable.bg_bazhu_shadow_and_radius);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.setMargins(dimens4, 0, dimens4, dimens3);
            this.fEj.setLayoutParams(layoutParams);
            this.fEj.setPadding(dimens2, 0, dimens2, dimens4);
            this.fDX.setVisibility(8);
            this.fEh.setVisibility(8);
            setRankVisible(8);
            this.fEc.setVisibility(8);
            this.fDQ.setVisibility(0);
            this.fDQ.setData(i, fVar);
            this.fEk.setPadding(0, dimens, 0, 0);
        } else if (this.status == com.baidu.tieba.barselect.a.a.fDH) {
            if (i == 1) {
                this.fEj.setBackgroundResource(R.drawable.bar_select_bg_top_round);
                this.fEh.setVisibility(8);
            } else {
                this.fEj.setBackgroundColor(getResources().getColor(R.color.cp_bg_line_d));
                this.fEh.setVisibility(0);
                this.fEg.setVisibility(0);
            }
            setRankVisible(0);
            this.fDX.setVisibility(8);
            int rank = this.fDs.getRank();
            if (rank < 10) {
                this.fDW.setText("0" + rank);
            } else {
                this.fDW.setText("" + rank);
            }
            if (rank == 2) {
                this.fDW.setTextColor(getResources().getColor(R.color.common_color_10263));
            } else if (rank == 3) {
                this.fDW.setTextColor(getResources().getColor(R.color.common_color_10266));
            } else {
                this.fDW.setTextColor(getResources().getColor(R.color.cp_cont_b));
            }
            this.fEc.setVisibility(8);
            this.fDQ.setVisibility(0);
            this.fDQ.setData(i, fVar);
        } else {
            setVisibility(8);
            return;
        }
        this.fEa.setData(i, fVar);
        this.fEb.setData(i, fVar);
        if (this.fDs.bss()) {
            this.fEd.setVisibility(0);
        } else {
            this.fEd.setVisibility(8);
        }
        oU(TbadkCoreApplication.getInst().getSkinType());
    }

    public void oU(int i) {
        this.fEb.oU(i);
        this.fEa.oU(i);
        if (this.fDQ.getVisibility() == 0) {
            this.fDQ.oU(i);
        }
        this.fEc.oU(i);
        am.setBackgroundColor(this.caf, R.color.cp_bg_line_c, i);
        if (this.status == com.baidu.tieba.barselect.a.a.fDJ) {
            am.setBackgroundResource(this.fEj, R.drawable.bar_select_bg_shadow_and_radius, i);
            am.setViewTextColor(this.fDZ, R.color.cp_cont_b, 1, i);
            am.setViewTextColor(this.fDY, R.color.cp_cont_b, 1, i);
        } else if (this.status == com.baidu.tieba.barselect.a.a.fDI) {
            am.setBackgroundResource(this.fEj, R.drawable.bg_bazhu_shadow_and_radius, i);
        } else if (this.status == com.baidu.tieba.barselect.a.a.fDH) {
            if (this.position == 1) {
                am.setBackgroundResource(this.fEj, R.drawable.bar_select_bg_top_round, i);
            } else {
                am.setBackgroundColor(this.fEj, R.color.cp_bg_line_d, i);
            }
        } else if (this.status == com.baidu.tieba.barselect.a.a.fDG) {
            am.setBackgroundColor(this.fEj, R.color.cp_bg_line_d, i);
        }
        if (this.fDs != null) {
            if (this.fDs.bss()) {
                am.setViewTextColor(this.fEf, R.color.cp_cont_h, 1, i);
                am.setBackgroundResource(this.fEe, R.drawable.icon_use_tip_red, i);
            }
            int rank = this.fDs.getRank();
            if (rank == 2) {
                am.setViewTextColor(this.fDW, R.color.cp_link_tip_d, 1, i);
            } else if (rank == 3) {
                am.setViewTextColor(this.fDW, R.color.cp_other_f, 1, i);
            } else {
                am.setViewTextColor(this.fDW, R.color.cp_cont_b, 1, i);
            }
        }
    }

    private void setRankVisible(int i) {
        this.fDW.setVisibility(i);
        this.fEi.setVisibility(i);
    }
}
