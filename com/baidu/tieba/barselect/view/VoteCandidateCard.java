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
/* loaded from: classes21.dex */
public class VoteCandidateCard extends CardBasicLayout {
    public static int hCn = -1;
    private View fCa;
    private View hCA;
    private View hCB;
    private View hCC;
    private TextView hCD;
    private View hCE;
    private LinearLayout hCF;
    private VotedAreaLayout hCf;
    private TextView hCo;
    private View hCp;
    private TextView hCq;
    private TextView hCr;
    private CandidateInfoLayout hCs;
    private NewAnounceLayout hCt;
    private VoteAreaLayout hCu;
    private View hCv;
    private TextView hCw;
    private TextView hCx;
    private View hCy;
    private View hCz;
    private d hyq;
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
        this.hCp = findViewById(R.id.mine_vote_content);
        this.hCq = (TextView) findViewById(R.id.mine_vote_title);
        this.hCr = (TextView) findViewById(R.id.mine_vote_num);
        this.hCo = (TextView) findViewById(R.id.tv_voted_rank);
        this.hCs = (CandidateInfoLayout) findViewById(R.id.candidate_info_layout);
        this.hCt = (NewAnounceLayout) findViewById(R.id.announce_layout);
        this.hCu = (VoteAreaLayout) findViewById(R.id.vote_area_layout);
        this.hCf = (VotedAreaLayout) findViewById(R.id.voted_area_layout);
        this.fCa = findViewById(R.id.divider_line);
        this.hCy = findViewById(R.id.divider_empty_view);
        this.hCz = findViewById(R.id.divider_line_container);
        this.hCA = findViewById(R.id.empty_view);
        this.hCB = findViewById(R.id.main_container);
        this.hCC = findViewById(R.id.info_container);
        this.hCv = findViewById(R.id.vote_ueg_warn_container);
        this.hCw = (TextView) findViewById(R.id.vote_ueg_warn_img);
        this.hCx = (TextView) findViewById(R.id.vote_ueg_warn_tv);
        this.hCE = findViewById(R.id.divider_top_line);
        this.hCD = (TextView) findViewById(R.id.title_notpass_tv);
        this.hCF = (LinearLayout) findViewById(R.id.not_allow_view);
    }

    @Override // com.baidu.tieba.barselect.segment.CardBasicLayout
    public void setData(int i, f fVar) {
        super.setData(i, fVar);
        this.position = i;
        if (this.hxT == null || this.hBI == null || this.status < 0) {
            setVisibility(8);
            return;
        }
        if (this.status == com.baidu.tieba.barselect.a.a.hBY) {
            this.hCB.setBackgroundResource(R.drawable.bar_select_bg_shadow_and_radius);
            this.hCp.setVisibility(0);
            this.hCr.setText("当前排名" + this.hBI.getRank());
            setRankVisible(8);
            this.hCz.setVisibility(8);
            this.hCu.setVisibility(0);
            this.hCf.setVisibility(8);
            this.hCu.setData(i, fVar);
            this.hCF.setVisibility(8);
        } else if (this.status == com.baidu.tieba.barselect.a.a.hBV) {
            if (i == 0) {
                this.hCz.setVisibility(8);
            } else {
                this.hCz.setVisibility(8);
                this.hCy.setVisibility(8);
            }
            this.hCB.setBackgroundColor(getResources().getColor(R.color.cp_bg_line_d));
            this.hCp.setVisibility(8);
            setRankVisible(8);
            if (this.hBI.chu() == 2 && this.hyq.chn() == -1) {
                this.hyq.wi(i);
            }
            if (this.hBI.chu() == 2) {
                if (this.hyq != null && this.hyq.chn() == i) {
                    this.hCF.setVisibility(0);
                } else {
                    this.hCF.setVisibility(8);
                }
                this.hCu.setVisibility(8);
            } else {
                this.hCF.setVisibility(8);
                this.hCu.setVisibility(0);
                this.hCu.setData(i, fVar);
            }
            this.hCf.setVisibility(8);
        } else if (this.status == com.baidu.tieba.barselect.a.a.hBX) {
            int dimens = l.getDimens(getContext(), R.dimen.tbds22);
            int dimens2 = l.getDimens(getContext(), R.dimen.tbds10);
            int dimens3 = l.getDimens(getContext(), R.dimen.tbds20);
            int dimens4 = l.getDimens(getContext(), R.dimen.tbds30);
            this.hCB.setBackgroundResource(R.drawable.bg_bazhu_shadow_and_radius);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.setMargins(dimens4, 0, dimens4, dimens3);
            this.hCB.setLayoutParams(layoutParams);
            this.hCB.setPadding(dimens2, 0, dimens2, dimens4);
            this.hCp.setVisibility(8);
            this.hCz.setVisibility(8);
            setRankVisible(8);
            this.hCu.setVisibility(8);
            this.hCf.setVisibility(0);
            this.hCf.setData(i, fVar);
            this.hCC.setPadding(0, dimens, 0, 0);
            this.hCF.setVisibility(8);
        } else if (this.status == com.baidu.tieba.barselect.a.a.hBW) {
            if (i == 1) {
                this.hCB.setBackgroundResource(R.drawable.bar_select_bg_top_round);
                this.hCz.setVisibility(8);
            } else {
                this.hCB.setBackgroundColor(getResources().getColor(R.color.cp_bg_line_d));
                this.hCz.setVisibility(0);
                this.hCy.setVisibility(0);
            }
            setRankVisible(0);
            this.hCp.setVisibility(8);
            int rank = this.hBI.getRank();
            if (rank < 10) {
                this.hCo.setText("0" + rank);
            } else {
                this.hCo.setText("" + rank);
            }
            if (rank == 2) {
                this.hCo.setTextColor(getResources().getColor(R.color.common_color_10263));
            } else if (rank == 3) {
                this.hCo.setTextColor(getResources().getColor(R.color.common_color_10266));
            } else {
                this.hCo.setTextColor(getResources().getColor(R.color.cp_cont_b));
            }
            this.hCu.setVisibility(8);
            this.hCf.setVisibility(0);
            this.hCf.setData(i, fVar);
            this.hCF.setVisibility(8);
        } else {
            setVisibility(8);
            return;
        }
        this.hCs.setData(i, fVar);
        this.hCt.setData(i, fVar);
        if (this.hBI.cht()) {
            this.hCv.setVisibility(0);
        } else {
            this.hCv.setVisibility(8);
        }
        uc(TbadkCoreApplication.getInst().getSkinType());
    }

    public void uc(int i) {
        this.hCt.uc(i);
        this.hCs.uc(i);
        if (this.hCf.getVisibility() == 0) {
            this.hCf.uc(i);
        }
        this.hCu.uc(i);
        ap.setBackgroundColor(this.fCa, R.color.cp_bg_line_c, i);
        if (this.status == com.baidu.tieba.barselect.a.a.hBY) {
            ap.setBackgroundResource(this.hCB, R.drawable.bar_select_bg_shadow_and_radius, i);
            ap.setViewTextColor(this.hCr, R.color.cp_cont_b, 1, i);
            ap.setViewTextColor(this.hCq, R.color.cp_cont_b, 1, i);
        } else if (this.status == com.baidu.tieba.barselect.a.a.hBX) {
            ap.setBackgroundResource(this.hCB, R.drawable.bg_bazhu_shadow_and_radius, i);
        } else if (this.status == com.baidu.tieba.barselect.a.a.hBW) {
            if (this.position == 1) {
                ap.setBackgroundResource(this.hCB, R.drawable.bar_select_bg_top_round, i);
            } else {
                ap.setBackgroundColor(this.hCB, R.color.cp_bg_line_d, i);
            }
        } else if (this.status == com.baidu.tieba.barselect.a.a.hBV) {
            ap.setBackgroundColor(this.hCB, R.color.cp_bg_line_d, i);
            ap.setViewTextColor(this.hCD, R.color.cp_cont_b, 1, i);
            ap.setBackgroundColor(this.hCF, R.color.cp_bg_line_d, i);
            ap.setBackgroundColor(this.hCE, R.color.cp_bg_line_b, i);
        }
        if (this.hBI != null) {
            if (this.hBI.cht()) {
                ap.setViewTextColor(this.hCx, R.color.cp_cont_h, 1, i);
                ap.setBackgroundResource(this.hCw, R.drawable.icon_use_tip_red, i);
            }
            int rank = this.hBI.getRank();
            if (rank == 2) {
                ap.setViewTextColor(this.hCo, R.color.cp_link_tip_d, 1, i);
            } else if (rank == 3) {
                ap.setViewTextColor(this.hCo, R.color.cp_other_f, 1, i);
            } else {
                ap.setViewTextColor(this.hCo, R.color.cp_cont_b, 1, i);
            }
        }
    }

    private void setRankVisible(int i) {
        this.hCo.setVisibility(i);
        this.hCA.setVisibility(i);
    }

    public void setVoteAdaPter(d dVar) {
        this.hyq = dVar;
    }
}
