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
    public static int gmd = -1;
    private View cDC;
    private VotedAreaLayout glV;
    private TextView gme;
    private View gmf;
    private TextView gmg;
    private TextView gmh;
    private CandidateInfoLayout gmi;
    private NewAnounceLayout gmj;
    private VoteAreaLayout gmk;
    private View gml;
    private TextView gmm;
    private TextView gmn;
    private View gmo;
    private View gmp;
    private View gmq;
    private View gmr;
    private View gms;
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
        this.gmf = findViewById(R.id.mine_vote_content);
        this.gmg = (TextView) findViewById(R.id.mine_vote_title);
        this.gmh = (TextView) findViewById(R.id.mine_vote_num);
        this.gme = (TextView) findViewById(R.id.tv_voted_rank);
        this.gmi = (CandidateInfoLayout) findViewById(R.id.candidate_info_layout);
        this.gmj = (NewAnounceLayout) findViewById(R.id.announce_layout);
        this.gmk = (VoteAreaLayout) findViewById(R.id.vote_area_layout);
        this.glV = (VotedAreaLayout) findViewById(R.id.voted_area_layout);
        this.cDC = findViewById(R.id.divider_line);
        this.gmo = findViewById(R.id.divider_empty_view);
        this.gmp = findViewById(R.id.divider_line_container);
        this.gmq = findViewById(R.id.empty_view);
        this.gmr = findViewById(R.id.main_container);
        this.gms = findViewById(R.id.info_container);
        this.gml = findViewById(R.id.vote_ueg_warn_container);
        this.gmm = (TextView) findViewById(R.id.vote_ueg_warn_img);
        this.gmn = (TextView) findViewById(R.id.vote_ueg_warn_tv);
    }

    @Override // com.baidu.tieba.barselect.segment.CardBasicLayout
    public void setData(int i, f fVar) {
        super.setData(i, fVar);
        this.position = i;
        if (this.ghJ == null || this.glx == null || this.status < 0) {
            setVisibility(8);
            return;
        }
        if (this.status == com.baidu.tieba.barselect.a.a.glO) {
            this.gmr.setBackgroundResource(R.drawable.bar_select_bg_shadow_and_radius);
            this.gmf.setVisibility(0);
            this.gmh.setText("当前排名" + this.glx.getRank());
            setRankVisible(8);
            this.gmp.setVisibility(8);
            this.gmk.setVisibility(0);
            this.glV.setVisibility(8);
            this.gmk.setData(i, fVar);
        } else if (this.status == com.baidu.tieba.barselect.a.a.glL) {
            if (i == 0) {
                this.gmp.setVisibility(8);
            } else {
                this.gmp.setVisibility(8);
                this.gmo.setVisibility(8);
            }
            this.gmr.setBackgroundColor(getResources().getColor(R.color.cp_bg_line_d));
            this.gmf.setVisibility(8);
            setRankVisible(8);
            this.gmk.setVisibility(0);
            this.glV.setVisibility(8);
            this.gmk.setData(i, fVar);
        } else if (this.status == com.baidu.tieba.barselect.a.a.glN) {
            int dimens = l.getDimens(getContext(), R.dimen.tbds22);
            int dimens2 = l.getDimens(getContext(), R.dimen.tbds10);
            int dimens3 = l.getDimens(getContext(), R.dimen.tbds20);
            int dimens4 = l.getDimens(getContext(), R.dimen.tbds30);
            this.gmr.setBackgroundResource(R.drawable.bg_bazhu_shadow_and_radius);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.setMargins(dimens4, 0, dimens4, dimens3);
            this.gmr.setLayoutParams(layoutParams);
            this.gmr.setPadding(dimens2, 0, dimens2, dimens4);
            this.gmf.setVisibility(8);
            this.gmp.setVisibility(8);
            setRankVisible(8);
            this.gmk.setVisibility(8);
            this.glV.setVisibility(0);
            this.glV.setData(i, fVar);
            this.gms.setPadding(0, dimens, 0, 0);
        } else if (this.status == com.baidu.tieba.barselect.a.a.glM) {
            if (i == 1) {
                this.gmr.setBackgroundResource(R.drawable.bar_select_bg_top_round);
                this.gmp.setVisibility(8);
            } else {
                this.gmr.setBackgroundColor(getResources().getColor(R.color.cp_bg_line_d));
                this.gmp.setVisibility(0);
                this.gmo.setVisibility(0);
            }
            setRankVisible(0);
            this.gmf.setVisibility(8);
            int rank = this.glx.getRank();
            if (rank < 10) {
                this.gme.setText("0" + rank);
            } else {
                this.gme.setText("" + rank);
            }
            if (rank == 2) {
                this.gme.setTextColor(getResources().getColor(R.color.common_color_10263));
            } else if (rank == 3) {
                this.gme.setTextColor(getResources().getColor(R.color.common_color_10266));
            } else {
                this.gme.setTextColor(getResources().getColor(R.color.cp_cont_b));
            }
            this.gmk.setVisibility(8);
            this.glV.setVisibility(0);
            this.glV.setData(i, fVar);
        } else {
            setVisibility(8);
            return;
        }
        this.gmi.setData(i, fVar);
        this.gmj.setData(i, fVar);
        if (this.glx.bDN()) {
            this.gml.setVisibility(0);
        } else {
            this.gml.setVisibility(8);
        }
        pH(TbadkCoreApplication.getInst().getSkinType());
    }

    public void pH(int i) {
        this.gmj.pH(i);
        this.gmi.pH(i);
        if (this.glV.getVisibility() == 0) {
            this.glV.pH(i);
        }
        this.gmk.pH(i);
        am.setBackgroundColor(this.cDC, R.color.cp_bg_line_c, i);
        if (this.status == com.baidu.tieba.barselect.a.a.glO) {
            am.setBackgroundResource(this.gmr, R.drawable.bar_select_bg_shadow_and_radius, i);
            am.setViewTextColor(this.gmh, R.color.cp_cont_b, 1, i);
            am.setViewTextColor(this.gmg, R.color.cp_cont_b, 1, i);
        } else if (this.status == com.baidu.tieba.barselect.a.a.glN) {
            am.setBackgroundResource(this.gmr, R.drawable.bg_bazhu_shadow_and_radius, i);
        } else if (this.status == com.baidu.tieba.barselect.a.a.glM) {
            if (this.position == 1) {
                am.setBackgroundResource(this.gmr, R.drawable.bar_select_bg_top_round, i);
            } else {
                am.setBackgroundColor(this.gmr, R.color.cp_bg_line_d, i);
            }
        } else if (this.status == com.baidu.tieba.barselect.a.a.glL) {
            am.setBackgroundColor(this.gmr, R.color.cp_bg_line_d, i);
        }
        if (this.glx != null) {
            if (this.glx.bDN()) {
                am.setViewTextColor(this.gmn, R.color.cp_cont_h, 1, i);
                am.setBackgroundResource(this.gmm, R.drawable.icon_use_tip_red, i);
            }
            int rank = this.glx.getRank();
            if (rank == 2) {
                am.setViewTextColor(this.gme, R.color.cp_link_tip_d, 1, i);
            } else if (rank == 3) {
                am.setViewTextColor(this.gme, R.color.cp_other_f, 1, i);
            } else {
                am.setViewTextColor(this.gme, R.color.cp_cont_b, 1, i);
            }
        }
    }

    private void setRankVisible(int i) {
        this.gme.setVisibility(i);
        this.gmq.setVisibility(i);
    }
}
