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
    public static int hgo = -1;
    private View fmE;
    private View hgA;
    private View hgB;
    private View hgC;
    private View hgD;
    private VotedAreaLayout hgg;
    private TextView hgp;
    private View hgq;
    private TextView hgr;
    private TextView hgs;
    private CandidateInfoLayout hgt;
    private NewAnounceLayout hgu;
    private VoteAreaLayout hgv;
    private View hgw;
    private TextView hgx;
    private TextView hgy;
    private View hgz;
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
        this.hgq = findViewById(R.id.mine_vote_content);
        this.hgr = (TextView) findViewById(R.id.mine_vote_title);
        this.hgs = (TextView) findViewById(R.id.mine_vote_num);
        this.hgp = (TextView) findViewById(R.id.tv_voted_rank);
        this.hgt = (CandidateInfoLayout) findViewById(R.id.candidate_info_layout);
        this.hgu = (NewAnounceLayout) findViewById(R.id.announce_layout);
        this.hgv = (VoteAreaLayout) findViewById(R.id.vote_area_layout);
        this.hgg = (VotedAreaLayout) findViewById(R.id.voted_area_layout);
        this.fmE = findViewById(R.id.divider_line);
        this.hgz = findViewById(R.id.divider_empty_view);
        this.hgA = findViewById(R.id.divider_line_container);
        this.hgB = findViewById(R.id.empty_view);
        this.hgC = findViewById(R.id.main_container);
        this.hgD = findViewById(R.id.info_container);
        this.hgw = findViewById(R.id.vote_ueg_warn_container);
        this.hgx = (TextView) findViewById(R.id.vote_ueg_warn_img);
        this.hgy = (TextView) findViewById(R.id.vote_ueg_warn_tv);
    }

    @Override // com.baidu.tieba.barselect.segment.CardBasicLayout
    public void setData(int i, f fVar) {
        super.setData(i, fVar);
        this.position = i;
        if (this.hbV == null || this.hfJ == null || this.status < 0) {
            setVisibility(8);
            return;
        }
        if (this.status == com.baidu.tieba.barselect.a.a.hfZ) {
            this.hgC.setBackgroundResource(R.drawable.bar_select_bg_shadow_and_radius);
            this.hgq.setVisibility(0);
            this.hgs.setText("当前排名" + this.hfJ.getRank());
            setRankVisible(8);
            this.hgA.setVisibility(8);
            this.hgv.setVisibility(0);
            this.hgg.setVisibility(8);
            this.hgv.setData(i, fVar);
        } else if (this.status == com.baidu.tieba.barselect.a.a.hfW) {
            if (i == 0) {
                this.hgA.setVisibility(8);
            } else {
                this.hgA.setVisibility(8);
                this.hgz.setVisibility(8);
            }
            this.hgC.setBackgroundColor(getResources().getColor(R.color.cp_bg_line_d));
            this.hgq.setVisibility(8);
            setRankVisible(8);
            this.hgv.setVisibility(0);
            this.hgg.setVisibility(8);
            this.hgv.setData(i, fVar);
        } else if (this.status == com.baidu.tieba.barselect.a.a.hfY) {
            int dimens = l.getDimens(getContext(), R.dimen.tbds22);
            int dimens2 = l.getDimens(getContext(), R.dimen.tbds10);
            int dimens3 = l.getDimens(getContext(), R.dimen.tbds20);
            int dimens4 = l.getDimens(getContext(), R.dimen.tbds30);
            this.hgC.setBackgroundResource(R.drawable.bg_bazhu_shadow_and_radius);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.setMargins(dimens4, 0, dimens4, dimens3);
            this.hgC.setLayoutParams(layoutParams);
            this.hgC.setPadding(dimens2, 0, dimens2, dimens4);
            this.hgq.setVisibility(8);
            this.hgA.setVisibility(8);
            setRankVisible(8);
            this.hgv.setVisibility(8);
            this.hgg.setVisibility(0);
            this.hgg.setData(i, fVar);
            this.hgD.setPadding(0, dimens, 0, 0);
        } else if (this.status == com.baidu.tieba.barselect.a.a.hfX) {
            if (i == 1) {
                this.hgC.setBackgroundResource(R.drawable.bar_select_bg_top_round);
                this.hgA.setVisibility(8);
            } else {
                this.hgC.setBackgroundColor(getResources().getColor(R.color.cp_bg_line_d));
                this.hgA.setVisibility(0);
                this.hgz.setVisibility(0);
            }
            setRankVisible(0);
            this.hgq.setVisibility(8);
            int rank = this.hfJ.getRank();
            if (rank < 10) {
                this.hgp.setText("0" + rank);
            } else {
                this.hgp.setText("" + rank);
            }
            if (rank == 2) {
                this.hgp.setTextColor(getResources().getColor(R.color.common_color_10263));
            } else if (rank == 3) {
                this.hgp.setTextColor(getResources().getColor(R.color.common_color_10266));
            } else {
                this.hgp.setTextColor(getResources().getColor(R.color.cp_cont_b));
            }
            this.hgv.setVisibility(8);
            this.hgg.setVisibility(0);
            this.hgg.setData(i, fVar);
        } else {
            setVisibility(8);
            return;
        }
        this.hgt.setData(i, fVar);
        this.hgu.setData(i, fVar);
        if (this.hfJ.caJ()) {
            this.hgw.setVisibility(0);
        } else {
            this.hgw.setVisibility(8);
        }
        tl(TbadkCoreApplication.getInst().getSkinType());
    }

    public void tl(int i) {
        this.hgu.tl(i);
        this.hgt.tl(i);
        if (this.hgg.getVisibility() == 0) {
            this.hgg.tl(i);
        }
        this.hgv.tl(i);
        ap.setBackgroundColor(this.fmE, R.color.cp_bg_line_c, i);
        if (this.status == com.baidu.tieba.barselect.a.a.hfZ) {
            ap.setBackgroundResource(this.hgC, R.drawable.bar_select_bg_shadow_and_radius, i);
            ap.setViewTextColor(this.hgs, R.color.cp_cont_b, 1, i);
            ap.setViewTextColor(this.hgr, R.color.cp_cont_b, 1, i);
        } else if (this.status == com.baidu.tieba.barselect.a.a.hfY) {
            ap.setBackgroundResource(this.hgC, R.drawable.bg_bazhu_shadow_and_radius, i);
        } else if (this.status == com.baidu.tieba.barselect.a.a.hfX) {
            if (this.position == 1) {
                ap.setBackgroundResource(this.hgC, R.drawable.bar_select_bg_top_round, i);
            } else {
                ap.setBackgroundColor(this.hgC, R.color.cp_bg_line_d, i);
            }
        } else if (this.status == com.baidu.tieba.barselect.a.a.hfW) {
            ap.setBackgroundColor(this.hgC, R.color.cp_bg_line_d, i);
        }
        if (this.hfJ != null) {
            if (this.hfJ.caJ()) {
                ap.setViewTextColor(this.hgy, R.color.cp_cont_h, 1, i);
                ap.setBackgroundResource(this.hgx, R.drawable.icon_use_tip_red, i);
            }
            int rank = this.hfJ.getRank();
            if (rank == 2) {
                ap.setViewTextColor(this.hgp, R.color.cp_link_tip_d, 1, i);
            } else if (rank == 3) {
                ap.setViewTextColor(this.hgp, R.color.cp_other_f, 1, i);
            } else {
                ap.setViewTextColor(this.hgp, R.color.cp_cont_b, 1, i);
            }
        }
    }

    private void setRankVisible(int i) {
        this.hgp.setVisibility(i);
        this.hgB.setVisibility(i);
    }
}
