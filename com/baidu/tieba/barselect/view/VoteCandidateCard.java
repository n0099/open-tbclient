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
    public static int igd = -1;
    private View fYd;
    private d icd;
    private VotedAreaLayout ifV;
    private TextView ige;
    private View igf;
    private TextView igg;
    private TextView igh;
    private CandidateInfoLayout igi;
    private NewAnounceLayout igj;
    private VoteAreaLayout igk;
    private View igl;
    private TextView igm;
    private TextView ign;
    private View igo;
    private View igp;
    private View igq;
    private View igr;
    private View igs;
    private TextView igt;
    private View igu;
    private LinearLayout igv;
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
        this.igf = findViewById(R.id.mine_vote_content);
        this.igg = (TextView) findViewById(R.id.mine_vote_title);
        this.igh = (TextView) findViewById(R.id.mine_vote_num);
        this.ige = (TextView) findViewById(R.id.tv_voted_rank);
        this.igi = (CandidateInfoLayout) findViewById(R.id.candidate_info_layout);
        this.igj = (NewAnounceLayout) findViewById(R.id.announce_layout);
        this.igk = (VoteAreaLayout) findViewById(R.id.vote_area_layout);
        this.ifV = (VotedAreaLayout) findViewById(R.id.voted_area_layout);
        this.fYd = findViewById(R.id.divider_line);
        this.igo = findViewById(R.id.divider_empty_view);
        this.igp = findViewById(R.id.divider_line_container);
        this.igq = findViewById(R.id.empty_view);
        this.igr = findViewById(R.id.main_container);
        this.igs = findViewById(R.id.info_container);
        this.igl = findViewById(R.id.vote_ueg_warn_container);
        this.igm = (TextView) findViewById(R.id.vote_ueg_warn_img);
        this.ign = (TextView) findViewById(R.id.vote_ueg_warn_tv);
        this.igu = findViewById(R.id.divider_top_line);
        this.igt = (TextView) findViewById(R.id.title_notpass_tv);
        this.igv = (LinearLayout) findViewById(R.id.not_allow_view);
    }

    @Override // com.baidu.tieba.barselect.segment.CardBasicLayout
    public void setData(int i, f fVar) {
        super.setData(i, fVar);
        this.position = i;
        if (this.ibG == null || this.ify == null || this.status < 0) {
            setVisibility(8);
            return;
        }
        if (this.status == com.baidu.tieba.barselect.a.a.ifO) {
            this.igr.setBackgroundResource(R.drawable.bar_select_bg_shadow_and_radius);
            this.igf.setVisibility(0);
            this.igh.setText("当前排名" + this.ify.getRank());
            setRankVisible(8);
            this.igp.setVisibility(8);
            this.igk.setVisibility(0);
            this.ifV.setVisibility(8);
            this.igk.setData(i, fVar);
            this.igv.setVisibility(8);
        } else if (this.status == com.baidu.tieba.barselect.a.a.ifL) {
            if (i == 0) {
                this.igp.setVisibility(8);
            } else {
                this.igp.setVisibility(8);
                this.igo.setVisibility(8);
            }
            this.igr.setBackgroundColor(getResources().getColor(R.color.CAM_X0201));
            this.igf.setVisibility(8);
            setRankVisible(8);
            if (this.ify.cqS() == 2 && this.icd.cqL() == -1) {
                this.icd.xS(i);
            }
            if (this.ify.cqS() == 2) {
                if (this.icd != null && this.icd.cqL() == i) {
                    this.igv.setVisibility(0);
                } else {
                    this.igv.setVisibility(8);
                }
                this.igk.setVisibility(8);
            } else {
                this.igv.setVisibility(8);
                this.igk.setVisibility(0);
                this.igk.setData(i, fVar);
            }
            this.ifV.setVisibility(8);
        } else if (this.status == com.baidu.tieba.barselect.a.a.ifN) {
            int dimens = l.getDimens(getContext(), R.dimen.tbds22);
            int dimens2 = l.getDimens(getContext(), R.dimen.tbds10);
            int dimens3 = l.getDimens(getContext(), R.dimen.tbds20);
            int dimens4 = l.getDimens(getContext(), R.dimen.tbds30);
            this.igr.setBackgroundResource(R.drawable.bg_bazhu_shadow_and_radius);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.setMargins(dimens4, 0, dimens4, dimens3);
            this.igr.setLayoutParams(layoutParams);
            this.igr.setPadding(dimens2, 0, dimens2, dimens4);
            this.igf.setVisibility(8);
            this.igp.setVisibility(8);
            setRankVisible(8);
            this.igk.setVisibility(8);
            this.ifV.setVisibility(0);
            this.ifV.setData(i, fVar);
            this.igs.setPadding(0, dimens, 0, 0);
            this.igv.setVisibility(8);
        } else if (this.status == com.baidu.tieba.barselect.a.a.ifM) {
            if (i == 1) {
                this.igr.setBackgroundResource(R.drawable.bar_select_bg_top_round);
                this.igp.setVisibility(8);
            } else {
                this.igr.setBackgroundColor(getResources().getColor(R.color.CAM_X0201));
                this.igp.setVisibility(0);
                this.igo.setVisibility(0);
            }
            setRankVisible(0);
            this.igf.setVisibility(8);
            int rank = this.ify.getRank();
            if (rank < 10) {
                this.ige.setText("0" + rank);
            } else {
                this.ige.setText("" + rank);
            }
            if (rank == 2) {
                this.ige.setTextColor(getResources().getColor(R.color.common_color_10263));
            } else if (rank == 3) {
                this.ige.setTextColor(getResources().getColor(R.color.common_color_10266));
            } else {
                this.ige.setTextColor(getResources().getColor(R.color.CAM_X0105));
            }
            this.igk.setVisibility(8);
            this.ifV.setVisibility(0);
            this.ifV.setData(i, fVar);
            this.igv.setVisibility(8);
        } else {
            setVisibility(8);
            return;
        }
        this.igi.setData(i, fVar);
        this.igj.setData(i, fVar);
        if (this.ify.cqR()) {
            this.igl.setVisibility(0);
        } else {
            this.igl.setVisibility(8);
        }
        vJ(TbadkCoreApplication.getInst().getSkinType());
    }

    public void vJ(int i) {
        this.igj.vJ(i);
        this.igi.vJ(i);
        if (this.ifV.getVisibility() == 0) {
            this.ifV.vJ(i);
        }
        this.igk.vJ(i);
        ap.setBackgroundColor(this.fYd, R.color.CAM_X0204, i);
        if (this.status == com.baidu.tieba.barselect.a.a.ifO) {
            ap.setBackgroundResource(this.igr, R.drawable.bar_select_bg_shadow_and_radius, i);
            ap.setViewTextColor(this.igh, R.color.CAM_X0105, 1, i);
            ap.setViewTextColor(this.igg, R.color.CAM_X0105, 1, i);
        } else if (this.status == com.baidu.tieba.barselect.a.a.ifN) {
            ap.setBackgroundResource(this.igr, R.drawable.bg_bazhu_shadow_and_radius, i);
        } else if (this.status == com.baidu.tieba.barselect.a.a.ifM) {
            if (this.position == 1) {
                ap.setBackgroundResource(this.igr, R.drawable.bar_select_bg_top_round, i);
            } else {
                ap.setBackgroundColor(this.igr, R.color.CAM_X0201, i);
            }
        } else if (this.status == com.baidu.tieba.barselect.a.a.ifL) {
            ap.setBackgroundColor(this.igr, R.color.CAM_X0201, i);
            ap.setViewTextColor(this.igt, R.color.CAM_X0105, 1, i);
            ap.setBackgroundColor(this.igv, R.color.CAM_X0201, i);
            ap.setBackgroundColor(this.igu, R.color.CAM_X0203, i);
        }
        if (this.ify != null) {
            if (this.ify.cqR()) {
                ap.setViewTextColor(this.ign, R.color.CAM_X0301, 1, i);
                ap.setBackgroundResource(this.igm, R.drawable.icon_use_tip_red, i);
            }
            int rank = this.ify.getRank();
            if (rank == 2) {
                ap.setViewTextColor(this.ige, R.color.CAM_X0305, 1, i);
            } else if (rank == 3) {
                ap.setViewTextColor(this.ige, R.color.CAM_X0312, 1, i);
            } else {
                ap.setViewTextColor(this.ige, R.color.CAM_X0105, 1, i);
            }
        }
    }

    private void setRankVisible(int i) {
        this.ige.setVisibility(i);
        this.igq.setVisibility(i);
    }

    public void setVoteAdaPter(d dVar) {
        this.icd = dVar;
    }
}
