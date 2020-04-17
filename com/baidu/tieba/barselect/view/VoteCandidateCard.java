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
    public static int glX = -1;
    private View cDw;
    private VotedAreaLayout glP;
    private TextView glY;
    private View glZ;
    private TextView gma;
    private TextView gmb;
    private CandidateInfoLayout gmc;
    private NewAnounceLayout gmd;
    private VoteAreaLayout gme;
    private View gmf;
    private TextView gmg;
    private TextView gmh;
    private View gmi;
    private View gmj;
    private View gmk;
    private View gml;
    private View gmm;
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
        rL();
    }

    private void rL() {
        this.glZ = findViewById(R.id.mine_vote_content);
        this.gma = (TextView) findViewById(R.id.mine_vote_title);
        this.gmb = (TextView) findViewById(R.id.mine_vote_num);
        this.glY = (TextView) findViewById(R.id.tv_voted_rank);
        this.gmc = (CandidateInfoLayout) findViewById(R.id.candidate_info_layout);
        this.gmd = (NewAnounceLayout) findViewById(R.id.announce_layout);
        this.gme = (VoteAreaLayout) findViewById(R.id.vote_area_layout);
        this.glP = (VotedAreaLayout) findViewById(R.id.voted_area_layout);
        this.cDw = findViewById(R.id.divider_line);
        this.gmi = findViewById(R.id.divider_empty_view);
        this.gmj = findViewById(R.id.divider_line_container);
        this.gmk = findViewById(R.id.empty_view);
        this.gml = findViewById(R.id.main_container);
        this.gmm = findViewById(R.id.info_container);
        this.gmf = findViewById(R.id.vote_ueg_warn_container);
        this.gmg = (TextView) findViewById(R.id.vote_ueg_warn_img);
        this.gmh = (TextView) findViewById(R.id.vote_ueg_warn_tv);
    }

    @Override // com.baidu.tieba.barselect.segment.CardBasicLayout
    public void setData(int i, f fVar) {
        super.setData(i, fVar);
        this.position = i;
        if (this.ghD == null || this.glr == null || this.status < 0) {
            setVisibility(8);
            return;
        }
        if (this.status == com.baidu.tieba.barselect.a.a.glI) {
            this.gml.setBackgroundResource(R.drawable.bar_select_bg_shadow_and_radius);
            this.glZ.setVisibility(0);
            this.gmb.setText("当前排名" + this.glr.getRank());
            setRankVisible(8);
            this.gmj.setVisibility(8);
            this.gme.setVisibility(0);
            this.glP.setVisibility(8);
            this.gme.setData(i, fVar);
        } else if (this.status == com.baidu.tieba.barselect.a.a.glF) {
            if (i == 0) {
                this.gmj.setVisibility(8);
            } else {
                this.gmj.setVisibility(8);
                this.gmi.setVisibility(8);
            }
            this.gml.setBackgroundColor(getResources().getColor(R.color.cp_bg_line_d));
            this.glZ.setVisibility(8);
            setRankVisible(8);
            this.gme.setVisibility(0);
            this.glP.setVisibility(8);
            this.gme.setData(i, fVar);
        } else if (this.status == com.baidu.tieba.barselect.a.a.glH) {
            int dimens = l.getDimens(getContext(), R.dimen.tbds22);
            int dimens2 = l.getDimens(getContext(), R.dimen.tbds10);
            int dimens3 = l.getDimens(getContext(), R.dimen.tbds20);
            int dimens4 = l.getDimens(getContext(), R.dimen.tbds30);
            this.gml.setBackgroundResource(R.drawable.bg_bazhu_shadow_and_radius);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.setMargins(dimens4, 0, dimens4, dimens3);
            this.gml.setLayoutParams(layoutParams);
            this.gml.setPadding(dimens2, 0, dimens2, dimens4);
            this.glZ.setVisibility(8);
            this.gmj.setVisibility(8);
            setRankVisible(8);
            this.gme.setVisibility(8);
            this.glP.setVisibility(0);
            this.glP.setData(i, fVar);
            this.gmm.setPadding(0, dimens, 0, 0);
        } else if (this.status == com.baidu.tieba.barselect.a.a.glG) {
            if (i == 1) {
                this.gml.setBackgroundResource(R.drawable.bar_select_bg_top_round);
                this.gmj.setVisibility(8);
            } else {
                this.gml.setBackgroundColor(getResources().getColor(R.color.cp_bg_line_d));
                this.gmj.setVisibility(0);
                this.gmi.setVisibility(0);
            }
            setRankVisible(0);
            this.glZ.setVisibility(8);
            int rank = this.glr.getRank();
            if (rank < 10) {
                this.glY.setText("0" + rank);
            } else {
                this.glY.setText("" + rank);
            }
            if (rank == 2) {
                this.glY.setTextColor(getResources().getColor(R.color.common_color_10263));
            } else if (rank == 3) {
                this.glY.setTextColor(getResources().getColor(R.color.common_color_10266));
            } else {
                this.glY.setTextColor(getResources().getColor(R.color.cp_cont_b));
            }
            this.gme.setVisibility(8);
            this.glP.setVisibility(0);
            this.glP.setData(i, fVar);
        } else {
            setVisibility(8);
            return;
        }
        this.gmc.setData(i, fVar);
        this.gmd.setData(i, fVar);
        if (this.glr.bDP()) {
            this.gmf.setVisibility(0);
        } else {
            this.gmf.setVisibility(8);
        }
        pH(TbadkCoreApplication.getInst().getSkinType());
    }

    public void pH(int i) {
        this.gmd.pH(i);
        this.gmc.pH(i);
        if (this.glP.getVisibility() == 0) {
            this.glP.pH(i);
        }
        this.gme.pH(i);
        am.setBackgroundColor(this.cDw, R.color.cp_bg_line_c, i);
        if (this.status == com.baidu.tieba.barselect.a.a.glI) {
            am.setBackgroundResource(this.gml, R.drawable.bar_select_bg_shadow_and_radius, i);
            am.setViewTextColor(this.gmb, R.color.cp_cont_b, 1, i);
            am.setViewTextColor(this.gma, R.color.cp_cont_b, 1, i);
        } else if (this.status == com.baidu.tieba.barselect.a.a.glH) {
            am.setBackgroundResource(this.gml, R.drawable.bg_bazhu_shadow_and_radius, i);
        } else if (this.status == com.baidu.tieba.barselect.a.a.glG) {
            if (this.position == 1) {
                am.setBackgroundResource(this.gml, R.drawable.bar_select_bg_top_round, i);
            } else {
                am.setBackgroundColor(this.gml, R.color.cp_bg_line_d, i);
            }
        } else if (this.status == com.baidu.tieba.barselect.a.a.glF) {
            am.setBackgroundColor(this.gml, R.color.cp_bg_line_d, i);
        }
        if (this.glr != null) {
            if (this.glr.bDP()) {
                am.setViewTextColor(this.gmh, R.color.cp_cont_h, 1, i);
                am.setBackgroundResource(this.gmg, R.drawable.icon_use_tip_red, i);
            }
            int rank = this.glr.getRank();
            if (rank == 2) {
                am.setViewTextColor(this.glY, R.color.cp_link_tip_d, 1, i);
            } else if (rank == 3) {
                am.setViewTextColor(this.glY, R.color.cp_other_f, 1, i);
            } else {
                am.setViewTextColor(this.glY, R.color.cp_cont_b, 1, i);
            }
        }
    }

    private void setRankVisible(int i) {
        this.glY.setVisibility(i);
        this.gmk.setVisibility(i);
    }
}
