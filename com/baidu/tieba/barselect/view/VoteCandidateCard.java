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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
import com.baidu.tieba.barselect.data.f;
import com.baidu.tieba.barselect.segment.CandidateInfoLayout;
import com.baidu.tieba.barselect.segment.CardBasicLayout;
import com.baidu.tieba.barselect.segment.NewAnounceLayout;
import com.baidu.tieba.barselect.segment.VoteAreaLayout;
import com.baidu.tieba.barselect.segment.VotedAreaLayout;
/* loaded from: classes15.dex */
public class VoteCandidateCard extends CardBasicLayout {
    public static int hgs = -1;
    private View fmI;
    private View hgA;
    private TextView hgB;
    private TextView hgC;
    private View hgD;
    private View hgE;
    private View hgF;
    private View hgG;
    private View hgH;
    private VotedAreaLayout hgk;
    private TextView hgt;
    private View hgu;
    private TextView hgv;
    private TextView hgw;
    private CandidateInfoLayout hgx;
    private NewAnounceLayout hgy;
    private VoteAreaLayout hgz;
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
        uf();
    }

    private void uf() {
        this.hgu = findViewById(R.id.mine_vote_content);
        this.hgv = (TextView) findViewById(R.id.mine_vote_title);
        this.hgw = (TextView) findViewById(R.id.mine_vote_num);
        this.hgt = (TextView) findViewById(R.id.tv_voted_rank);
        this.hgx = (CandidateInfoLayout) findViewById(R.id.candidate_info_layout);
        this.hgy = (NewAnounceLayout) findViewById(R.id.announce_layout);
        this.hgz = (VoteAreaLayout) findViewById(R.id.vote_area_layout);
        this.hgk = (VotedAreaLayout) findViewById(R.id.voted_area_layout);
        this.fmI = findViewById(R.id.divider_line);
        this.hgD = findViewById(R.id.divider_empty_view);
        this.hgE = findViewById(R.id.divider_line_container);
        this.hgF = findViewById(R.id.empty_view);
        this.hgG = findViewById(R.id.main_container);
        this.hgH = findViewById(R.id.info_container);
        this.hgA = findViewById(R.id.vote_ueg_warn_container);
        this.hgB = (TextView) findViewById(R.id.vote_ueg_warn_img);
        this.hgC = (TextView) findViewById(R.id.vote_ueg_warn_tv);
    }

    @Override // com.baidu.tieba.barselect.segment.CardBasicLayout
    public void setData(int i, f fVar) {
        super.setData(i, fVar);
        this.position = i;
        if (this.hbZ == null || this.hfN == null || this.status < 0) {
            setVisibility(8);
            return;
        }
        if (this.status == com.baidu.tieba.barselect.a.a.hgd) {
            this.hgG.setBackgroundResource(R.drawable.bar_select_bg_shadow_and_radius);
            this.hgu.setVisibility(0);
            this.hgw.setText("当前排名" + this.hfN.getRank());
            setRankVisible(8);
            this.hgE.setVisibility(8);
            this.hgz.setVisibility(0);
            this.hgk.setVisibility(8);
            this.hgz.setData(i, fVar);
        } else if (this.status == com.baidu.tieba.barselect.a.a.hga) {
            if (i == 0) {
                this.hgE.setVisibility(8);
            } else {
                this.hgE.setVisibility(8);
                this.hgD.setVisibility(8);
            }
            this.hgG.setBackgroundColor(getResources().getColor(R.color.cp_bg_line_d));
            this.hgu.setVisibility(8);
            setRankVisible(8);
            this.hgz.setVisibility(0);
            this.hgk.setVisibility(8);
            this.hgz.setData(i, fVar);
        } else if (this.status == com.baidu.tieba.barselect.a.a.hgc) {
            int dimens = l.getDimens(getContext(), R.dimen.tbds22);
            int dimens2 = l.getDimens(getContext(), R.dimen.tbds10);
            int dimens3 = l.getDimens(getContext(), R.dimen.tbds20);
            int dimens4 = l.getDimens(getContext(), R.dimen.tbds30);
            this.hgG.setBackgroundResource(R.drawable.bg_bazhu_shadow_and_radius);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.setMargins(dimens4, 0, dimens4, dimens3);
            this.hgG.setLayoutParams(layoutParams);
            this.hgG.setPadding(dimens2, 0, dimens2, dimens4);
            this.hgu.setVisibility(8);
            this.hgE.setVisibility(8);
            setRankVisible(8);
            this.hgz.setVisibility(8);
            this.hgk.setVisibility(0);
            this.hgk.setData(i, fVar);
            this.hgH.setPadding(0, dimens, 0, 0);
        } else if (this.status == com.baidu.tieba.barselect.a.a.hgb) {
            if (i == 1) {
                this.hgG.setBackgroundResource(R.drawable.bar_select_bg_top_round);
                this.hgE.setVisibility(8);
            } else {
                this.hgG.setBackgroundColor(getResources().getColor(R.color.cp_bg_line_d));
                this.hgE.setVisibility(0);
                this.hgD.setVisibility(0);
            }
            setRankVisible(0);
            this.hgu.setVisibility(8);
            int rank = this.hfN.getRank();
            if (rank < 10) {
                this.hgt.setText("0" + rank);
            } else {
                this.hgt.setText("" + rank);
            }
            if (rank == 2) {
                this.hgt.setTextColor(getResources().getColor(R.color.common_color_10263));
            } else if (rank == 3) {
                this.hgt.setTextColor(getResources().getColor(R.color.common_color_10266));
            } else {
                this.hgt.setTextColor(getResources().getColor(R.color.cp_cont_b));
            }
            this.hgz.setVisibility(8);
            this.hgk.setVisibility(0);
            this.hgk.setData(i, fVar);
        } else {
            setVisibility(8);
            return;
        }
        this.hgx.setData(i, fVar);
        this.hgy.setData(i, fVar);
        if (this.hfN.caK()) {
            this.hgA.setVisibility(0);
        } else {
            this.hgA.setVisibility(8);
        }
        tl(TbadkCoreApplication.getInst().getSkinType());
    }

    public void tl(int i) {
        this.hgy.tl(i);
        this.hgx.tl(i);
        if (this.hgk.getVisibility() == 0) {
            this.hgk.tl(i);
        }
        this.hgz.tl(i);
        ap.setBackgroundColor(this.fmI, R.color.cp_bg_line_c, i);
        if (this.status == com.baidu.tieba.barselect.a.a.hgd) {
            ap.setBackgroundResource(this.hgG, R.drawable.bar_select_bg_shadow_and_radius, i);
            ap.setViewTextColor(this.hgw, R.color.cp_cont_b, 1, i);
            ap.setViewTextColor(this.hgv, R.color.cp_cont_b, 1, i);
        } else if (this.status == com.baidu.tieba.barselect.a.a.hgc) {
            ap.setBackgroundResource(this.hgG, R.drawable.bg_bazhu_shadow_and_radius, i);
        } else if (this.status == com.baidu.tieba.barselect.a.a.hgb) {
            if (this.position == 1) {
                ap.setBackgroundResource(this.hgG, R.drawable.bar_select_bg_top_round, i);
            } else {
                ap.setBackgroundColor(this.hgG, R.color.cp_bg_line_d, i);
            }
        } else if (this.status == com.baidu.tieba.barselect.a.a.hga) {
            ap.setBackgroundColor(this.hgG, R.color.cp_bg_line_d, i);
        }
        if (this.hfN != null) {
            if (this.hfN.caK()) {
                ap.setViewTextColor(this.hgC, R.color.cp_cont_h, 1, i);
                ap.setBackgroundResource(this.hgB, R.drawable.icon_use_tip_red, i);
            }
            int rank = this.hfN.getRank();
            if (rank == 2) {
                ap.setViewTextColor(this.hgt, R.color.cp_link_tip_d, 1, i);
            } else if (rank == 3) {
                ap.setViewTextColor(this.hgt, R.color.cp_other_f, 1, i);
            } else {
                ap.setViewTextColor(this.hgt, R.color.cp_cont_b, 1, i);
            }
        }
    }

    private void setRankVisible(int i) {
        this.hgt.setVisibility(i);
        this.hgF.setVisibility(i);
    }
}
