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
    public static int igf = -1;
    private View fYf;
    private d icf;
    private VotedAreaLayout ifX;
    private TextView igg;
    private View igh;
    private TextView igi;
    private TextView igj;
    private CandidateInfoLayout igk;
    private NewAnounceLayout igl;
    private VoteAreaLayout igm;
    private View ign;
    private TextView igo;
    private TextView igp;
    private View igq;
    private View igr;
    private View igs;
    private View igt;
    private View igu;
    private TextView igv;
    private View igw;
    private LinearLayout igx;
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
        uo();
    }

    private void uo() {
        this.igh = findViewById(R.id.mine_vote_content);
        this.igi = (TextView) findViewById(R.id.mine_vote_title);
        this.igj = (TextView) findViewById(R.id.mine_vote_num);
        this.igg = (TextView) findViewById(R.id.tv_voted_rank);
        this.igk = (CandidateInfoLayout) findViewById(R.id.candidate_info_layout);
        this.igl = (NewAnounceLayout) findViewById(R.id.announce_layout);
        this.igm = (VoteAreaLayout) findViewById(R.id.vote_area_layout);
        this.ifX = (VotedAreaLayout) findViewById(R.id.voted_area_layout);
        this.fYf = findViewById(R.id.divider_line);
        this.igq = findViewById(R.id.divider_empty_view);
        this.igr = findViewById(R.id.divider_line_container);
        this.igs = findViewById(R.id.empty_view);
        this.igt = findViewById(R.id.main_container);
        this.igu = findViewById(R.id.info_container);
        this.ign = findViewById(R.id.vote_ueg_warn_container);
        this.igo = (TextView) findViewById(R.id.vote_ueg_warn_img);
        this.igp = (TextView) findViewById(R.id.vote_ueg_warn_tv);
        this.igw = findViewById(R.id.divider_top_line);
        this.igv = (TextView) findViewById(R.id.title_notpass_tv);
        this.igx = (LinearLayout) findViewById(R.id.not_allow_view);
    }

    @Override // com.baidu.tieba.barselect.segment.CardBasicLayout
    public void setData(int i, f fVar) {
        super.setData(i, fVar);
        this.position = i;
        if (this.ibI == null || this.ifA == null || this.status < 0) {
            setVisibility(8);
            return;
        }
        if (this.status == com.baidu.tieba.barselect.a.a.ifQ) {
            this.igt.setBackgroundResource(R.drawable.bar_select_bg_shadow_and_radius);
            this.igh.setVisibility(0);
            this.igj.setText("当前排名" + this.ifA.getRank());
            setRankVisible(8);
            this.igr.setVisibility(8);
            this.igm.setVisibility(0);
            this.ifX.setVisibility(8);
            this.igm.setData(i, fVar);
            this.igx.setVisibility(8);
        } else if (this.status == com.baidu.tieba.barselect.a.a.ifN) {
            if (i == 0) {
                this.igr.setVisibility(8);
            } else {
                this.igr.setVisibility(8);
                this.igq.setVisibility(8);
            }
            this.igt.setBackgroundColor(getResources().getColor(R.color.CAM_X0201));
            this.igh.setVisibility(8);
            setRankVisible(8);
            if (this.ifA.cqT() == 2 && this.icf.cqM() == -1) {
                this.icf.xS(i);
            }
            if (this.ifA.cqT() == 2) {
                if (this.icf != null && this.icf.cqM() == i) {
                    this.igx.setVisibility(0);
                } else {
                    this.igx.setVisibility(8);
                }
                this.igm.setVisibility(8);
            } else {
                this.igx.setVisibility(8);
                this.igm.setVisibility(0);
                this.igm.setData(i, fVar);
            }
            this.ifX.setVisibility(8);
        } else if (this.status == com.baidu.tieba.barselect.a.a.ifP) {
            int dimens = l.getDimens(getContext(), R.dimen.tbds22);
            int dimens2 = l.getDimens(getContext(), R.dimen.tbds10);
            int dimens3 = l.getDimens(getContext(), R.dimen.tbds20);
            int dimens4 = l.getDimens(getContext(), R.dimen.tbds30);
            this.igt.setBackgroundResource(R.drawable.bg_bazhu_shadow_and_radius);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.setMargins(dimens4, 0, dimens4, dimens3);
            this.igt.setLayoutParams(layoutParams);
            this.igt.setPadding(dimens2, 0, dimens2, dimens4);
            this.igh.setVisibility(8);
            this.igr.setVisibility(8);
            setRankVisible(8);
            this.igm.setVisibility(8);
            this.ifX.setVisibility(0);
            this.ifX.setData(i, fVar);
            this.igu.setPadding(0, dimens, 0, 0);
            this.igx.setVisibility(8);
        } else if (this.status == com.baidu.tieba.barselect.a.a.ifO) {
            if (i == 1) {
                this.igt.setBackgroundResource(R.drawable.bar_select_bg_top_round);
                this.igr.setVisibility(8);
            } else {
                this.igt.setBackgroundColor(getResources().getColor(R.color.CAM_X0201));
                this.igr.setVisibility(0);
                this.igq.setVisibility(0);
            }
            setRankVisible(0);
            this.igh.setVisibility(8);
            int rank = this.ifA.getRank();
            if (rank < 10) {
                this.igg.setText("0" + rank);
            } else {
                this.igg.setText("" + rank);
            }
            if (rank == 2) {
                this.igg.setTextColor(getResources().getColor(R.color.common_color_10263));
            } else if (rank == 3) {
                this.igg.setTextColor(getResources().getColor(R.color.common_color_10266));
            } else {
                this.igg.setTextColor(getResources().getColor(R.color.CAM_X0105));
            }
            this.igm.setVisibility(8);
            this.ifX.setVisibility(0);
            this.ifX.setData(i, fVar);
            this.igx.setVisibility(8);
        } else {
            setVisibility(8);
            return;
        }
        this.igk.setData(i, fVar);
        this.igl.setData(i, fVar);
        if (this.ifA.cqS()) {
            this.ign.setVisibility(0);
        } else {
            this.ign.setVisibility(8);
        }
        vJ(TbadkCoreApplication.getInst().getSkinType());
    }

    public void vJ(int i) {
        this.igl.vJ(i);
        this.igk.vJ(i);
        if (this.ifX.getVisibility() == 0) {
            this.ifX.vJ(i);
        }
        this.igm.vJ(i);
        ap.setBackgroundColor(this.fYf, R.color.CAM_X0204, i);
        if (this.status == com.baidu.tieba.barselect.a.a.ifQ) {
            ap.setBackgroundResource(this.igt, R.drawable.bar_select_bg_shadow_and_radius, i);
            ap.setViewTextColor(this.igj, R.color.CAM_X0105, 1, i);
            ap.setViewTextColor(this.igi, R.color.CAM_X0105, 1, i);
        } else if (this.status == com.baidu.tieba.barselect.a.a.ifP) {
            ap.setBackgroundResource(this.igt, R.drawable.bg_bazhu_shadow_and_radius, i);
        } else if (this.status == com.baidu.tieba.barselect.a.a.ifO) {
            if (this.position == 1) {
                ap.setBackgroundResource(this.igt, R.drawable.bar_select_bg_top_round, i);
            } else {
                ap.setBackgroundColor(this.igt, R.color.CAM_X0201, i);
            }
        } else if (this.status == com.baidu.tieba.barselect.a.a.ifN) {
            ap.setBackgroundColor(this.igt, R.color.CAM_X0201, i);
            ap.setViewTextColor(this.igv, R.color.CAM_X0105, 1, i);
            ap.setBackgroundColor(this.igx, R.color.CAM_X0201, i);
            ap.setBackgroundColor(this.igw, R.color.CAM_X0203, i);
        }
        if (this.ifA != null) {
            if (this.ifA.cqS()) {
                ap.setViewTextColor(this.igp, R.color.CAM_X0301, 1, i);
                ap.setBackgroundResource(this.igo, R.drawable.icon_use_tip_red, i);
            }
            int rank = this.ifA.getRank();
            if (rank == 2) {
                ap.setViewTextColor(this.igg, R.color.CAM_X0305, 1, i);
            } else if (rank == 3) {
                ap.setViewTextColor(this.igg, R.color.CAM_X0312, 1, i);
            } else {
                ap.setViewTextColor(this.igg, R.color.CAM_X0105, 1, i);
            }
        }
    }

    private void setRankVisible(int i) {
        this.igg.setVisibility(i);
        this.igs.setVisibility(i);
    }

    public void setVoteAdaPter(d dVar) {
        this.icf = dVar;
    }
}
