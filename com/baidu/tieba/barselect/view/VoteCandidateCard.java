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
import com.baidu.tieba.barselect.d;
import com.baidu.tieba.barselect.data.f;
import com.baidu.tieba.barselect.segment.CandidateInfoLayout;
import com.baidu.tieba.barselect.segment.CardBasicLayout;
import com.baidu.tieba.barselect.segment.NewAnounceLayout;
import com.baidu.tieba.barselect.segment.VoteAreaLayout;
import com.baidu.tieba.barselect.segment.VotedAreaLayout;
/* loaded from: classes20.dex */
public class VoteCandidateCard extends CardBasicLayout {
    public static int hnt = -1;
    private View fpN;
    private d hjv;
    private VoteAreaLayout hnA;
    private View hnB;
    private TextView hnC;
    private TextView hnD;
    private View hnE;
    private View hnF;
    private View hnG;
    private View hnH;
    private View hnI;
    private TextView hnJ;
    private View hnK;
    private LinearLayout hnL;
    private VotedAreaLayout hnl;
    private TextView hnu;
    private View hnv;
    private TextView hnw;
    private TextView hnx;
    private CandidateInfoLayout hny;
    private NewAnounceLayout hnz;
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
        ul();
    }

    private void ul() {
        this.hnv = findViewById(R.id.mine_vote_content);
        this.hnw = (TextView) findViewById(R.id.mine_vote_title);
        this.hnx = (TextView) findViewById(R.id.mine_vote_num);
        this.hnu = (TextView) findViewById(R.id.tv_voted_rank);
        this.hny = (CandidateInfoLayout) findViewById(R.id.candidate_info_layout);
        this.hnz = (NewAnounceLayout) findViewById(R.id.announce_layout);
        this.hnA = (VoteAreaLayout) findViewById(R.id.vote_area_layout);
        this.hnl = (VotedAreaLayout) findViewById(R.id.voted_area_layout);
        this.fpN = findViewById(R.id.divider_line);
        this.hnE = findViewById(R.id.divider_empty_view);
        this.hnF = findViewById(R.id.divider_line_container);
        this.hnG = findViewById(R.id.empty_view);
        this.hnH = findViewById(R.id.main_container);
        this.hnI = findViewById(R.id.info_container);
        this.hnB = findViewById(R.id.vote_ueg_warn_container);
        this.hnC = (TextView) findViewById(R.id.vote_ueg_warn_img);
        this.hnD = (TextView) findViewById(R.id.vote_ueg_warn_tv);
        this.hnK = findViewById(R.id.divider_top_line);
        this.hnJ = (TextView) findViewById(R.id.title_notpass_tv);
        this.hnL = (LinearLayout) findViewById(R.id.not_allow_view);
    }

    @Override // com.baidu.tieba.barselect.segment.CardBasicLayout
    public void setData(int i, f fVar) {
        super.setData(i, fVar);
        this.position = i;
        if (this.hiY == null || this.hmO == null || this.status < 0) {
            setVisibility(8);
            return;
        }
        if (this.status == com.baidu.tieba.barselect.a.a.hne) {
            this.hnH.setBackgroundResource(R.drawable.bar_select_bg_shadow_and_radius);
            this.hnv.setVisibility(0);
            this.hnx.setText("当前排名" + this.hmO.getRank());
            setRankVisible(8);
            this.hnF.setVisibility(8);
            this.hnA.setVisibility(0);
            this.hnl.setVisibility(8);
            this.hnA.setData(i, fVar);
            this.hnL.setVisibility(8);
        } else if (this.status == com.baidu.tieba.barselect.a.a.hnb) {
            if (i == 0) {
                this.hnF.setVisibility(8);
            } else {
                this.hnF.setVisibility(8);
                this.hnE.setVisibility(8);
            }
            this.hnH.setBackgroundColor(getResources().getColor(R.color.cp_bg_line_d));
            this.hnv.setVisibility(8);
            setRankVisible(8);
            if (this.hmO.cdY() == 2 && this.hjv.cdR() == -1) {
                this.hjv.vC(i);
            }
            if (this.hmO.cdY() == 2) {
                if (this.hjv != null && this.hjv.cdR() == i) {
                    this.hnL.setVisibility(0);
                } else {
                    this.hnL.setVisibility(8);
                }
                this.hnA.setVisibility(8);
            } else {
                this.hnL.setVisibility(8);
                this.hnA.setVisibility(0);
                this.hnA.setData(i, fVar);
            }
            this.hnl.setVisibility(8);
        } else if (this.status == com.baidu.tieba.barselect.a.a.hnd) {
            int dimens = l.getDimens(getContext(), R.dimen.tbds22);
            int dimens2 = l.getDimens(getContext(), R.dimen.tbds10);
            int dimens3 = l.getDimens(getContext(), R.dimen.tbds20);
            int dimens4 = l.getDimens(getContext(), R.dimen.tbds30);
            this.hnH.setBackgroundResource(R.drawable.bg_bazhu_shadow_and_radius);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.setMargins(dimens4, 0, dimens4, dimens3);
            this.hnH.setLayoutParams(layoutParams);
            this.hnH.setPadding(dimens2, 0, dimens2, dimens4);
            this.hnv.setVisibility(8);
            this.hnF.setVisibility(8);
            setRankVisible(8);
            this.hnA.setVisibility(8);
            this.hnl.setVisibility(0);
            this.hnl.setData(i, fVar);
            this.hnI.setPadding(0, dimens, 0, 0);
            this.hnL.setVisibility(8);
        } else if (this.status == com.baidu.tieba.barselect.a.a.hnc) {
            if (i == 1) {
                this.hnH.setBackgroundResource(R.drawable.bar_select_bg_top_round);
                this.hnF.setVisibility(8);
            } else {
                this.hnH.setBackgroundColor(getResources().getColor(R.color.cp_bg_line_d));
                this.hnF.setVisibility(0);
                this.hnE.setVisibility(0);
            }
            setRankVisible(0);
            this.hnv.setVisibility(8);
            int rank = this.hmO.getRank();
            if (rank < 10) {
                this.hnu.setText("0" + rank);
            } else {
                this.hnu.setText("" + rank);
            }
            if (rank == 2) {
                this.hnu.setTextColor(getResources().getColor(R.color.common_color_10263));
            } else if (rank == 3) {
                this.hnu.setTextColor(getResources().getColor(R.color.common_color_10266));
            } else {
                this.hnu.setTextColor(getResources().getColor(R.color.cp_cont_b));
            }
            this.hnA.setVisibility(8);
            this.hnl.setVisibility(0);
            this.hnl.setData(i, fVar);
            this.hnL.setVisibility(8);
        } else {
            setVisibility(8);
            return;
        }
        this.hny.setData(i, fVar);
        this.hnz.setData(i, fVar);
        if (this.hmO.cdX()) {
            this.hnB.setVisibility(0);
        } else {
            this.hnB.setVisibility(8);
        }
        tE(TbadkCoreApplication.getInst().getSkinType());
    }

    public void tE(int i) {
        this.hnz.tE(i);
        this.hny.tE(i);
        if (this.hnl.getVisibility() == 0) {
            this.hnl.tE(i);
        }
        this.hnA.tE(i);
        ap.setBackgroundColor(this.fpN, R.color.cp_bg_line_c, i);
        if (this.status == com.baidu.tieba.barselect.a.a.hne) {
            ap.setBackgroundResource(this.hnH, R.drawable.bar_select_bg_shadow_and_radius, i);
            ap.setViewTextColor(this.hnx, R.color.cp_cont_b, 1, i);
            ap.setViewTextColor(this.hnw, R.color.cp_cont_b, 1, i);
        } else if (this.status == com.baidu.tieba.barselect.a.a.hnd) {
            ap.setBackgroundResource(this.hnH, R.drawable.bg_bazhu_shadow_and_radius, i);
        } else if (this.status == com.baidu.tieba.barselect.a.a.hnc) {
            if (this.position == 1) {
                ap.setBackgroundResource(this.hnH, R.drawable.bar_select_bg_top_round, i);
            } else {
                ap.setBackgroundColor(this.hnH, R.color.cp_bg_line_d, i);
            }
        } else if (this.status == com.baidu.tieba.barselect.a.a.hnb) {
            ap.setBackgroundColor(this.hnH, R.color.cp_bg_line_d, i);
            ap.setViewTextColor(this.hnJ, R.color.cp_cont_b, 1, i);
            ap.setBackgroundColor(this.hnL, R.color.cp_bg_line_d, i);
            ap.setBackgroundColor(this.hnK, R.color.cp_bg_line_b, i);
        }
        if (this.hmO != null) {
            if (this.hmO.cdX()) {
                ap.setViewTextColor(this.hnD, R.color.cp_cont_h, 1, i);
                ap.setBackgroundResource(this.hnC, R.drawable.icon_use_tip_red, i);
            }
            int rank = this.hmO.getRank();
            if (rank == 2) {
                ap.setViewTextColor(this.hnu, R.color.cp_link_tip_d, 1, i);
            } else if (rank == 3) {
                ap.setViewTextColor(this.hnu, R.color.cp_other_f, 1, i);
            } else {
                ap.setViewTextColor(this.hnu, R.color.cp_cont_b, 1, i);
            }
        }
    }

    private void setRankVisible(int i) {
        this.hnu.setVisibility(i);
        this.hnG.setVisibility(i);
    }

    public void setVoteAdaPter(d dVar) {
        this.hjv = dVar;
    }
}
