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
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.R;
import com.baidu.tieba.barselect.data.f;
import com.baidu.tieba.barselect.segment.CandidateInfoLayout;
import com.baidu.tieba.barselect.segment.CardBasicLayout;
import com.baidu.tieba.barselect.segment.NewAnounceLayout;
import com.baidu.tieba.barselect.segment.VoteAreaLayout;
import com.baidu.tieba.barselect.segment.VotedAreaLayout;
/* loaded from: classes8.dex */
public class VoteCandidateCard extends CardBasicLayout {
    public static int gNP = -1;
    private View eVD;
    private VotedAreaLayout gNH;
    private TextView gNQ;
    private View gNR;
    private TextView gNS;
    private TextView gNT;
    private CandidateInfoLayout gNU;
    private NewAnounceLayout gNV;
    private VoteAreaLayout gNW;
    private View gNX;
    private TextView gNY;
    private TextView gNZ;
    private View gOa;
    private View gOb;
    private View gOc;
    private View gOd;
    private View gOe;
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
        sq();
    }

    private void sq() {
        this.gNR = findViewById(R.id.mine_vote_content);
        this.gNS = (TextView) findViewById(R.id.mine_vote_title);
        this.gNT = (TextView) findViewById(R.id.mine_vote_num);
        this.gNQ = (TextView) findViewById(R.id.tv_voted_rank);
        this.gNU = (CandidateInfoLayout) findViewById(R.id.candidate_info_layout);
        this.gNV = (NewAnounceLayout) findViewById(R.id.announce_layout);
        this.gNW = (VoteAreaLayout) findViewById(R.id.vote_area_layout);
        this.gNH = (VotedAreaLayout) findViewById(R.id.voted_area_layout);
        this.eVD = findViewById(R.id.divider_line);
        this.gOa = findViewById(R.id.divider_empty_view);
        this.gOb = findViewById(R.id.divider_line_container);
        this.gOc = findViewById(R.id.empty_view);
        this.gOd = findViewById(R.id.main_container);
        this.gOe = findViewById(R.id.info_container);
        this.gNX = findViewById(R.id.vote_ueg_warn_container);
        this.gNY = (TextView) findViewById(R.id.vote_ueg_warn_img);
        this.gNZ = (TextView) findViewById(R.id.vote_ueg_warn_tv);
    }

    @Override // com.baidu.tieba.barselect.segment.CardBasicLayout
    public void setData(int i, f fVar) {
        super.setData(i, fVar);
        this.position = i;
        if (this.gJz == null || this.gNk == null || this.status < 0) {
            setVisibility(8);
            return;
        }
        if (this.status == com.baidu.tieba.barselect.a.a.gNA) {
            this.gOd.setBackgroundResource(R.drawable.bar_select_bg_shadow_and_radius);
            this.gNR.setVisibility(0);
            this.gNT.setText("当前排名" + this.gNk.getRank());
            setRankVisible(8);
            this.gOb.setVisibility(8);
            this.gNW.setVisibility(0);
            this.gNH.setVisibility(8);
            this.gNW.setData(i, fVar);
        } else if (this.status == com.baidu.tieba.barselect.a.a.gNx) {
            if (i == 0) {
                this.gOb.setVisibility(8);
            } else {
                this.gOb.setVisibility(8);
                this.gOa.setVisibility(8);
            }
            this.gOd.setBackgroundColor(getResources().getColor(R.color.cp_bg_line_d));
            this.gNR.setVisibility(8);
            setRankVisible(8);
            this.gNW.setVisibility(0);
            this.gNH.setVisibility(8);
            this.gNW.setData(i, fVar);
        } else if (this.status == com.baidu.tieba.barselect.a.a.gNz) {
            int dimens = l.getDimens(getContext(), R.dimen.tbds22);
            int dimens2 = l.getDimens(getContext(), R.dimen.tbds10);
            int dimens3 = l.getDimens(getContext(), R.dimen.tbds20);
            int dimens4 = l.getDimens(getContext(), R.dimen.tbds30);
            this.gOd.setBackgroundResource(R.drawable.bg_bazhu_shadow_and_radius);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.setMargins(dimens4, 0, dimens4, dimens3);
            this.gOd.setLayoutParams(layoutParams);
            this.gOd.setPadding(dimens2, 0, dimens2, dimens4);
            this.gNR.setVisibility(8);
            this.gOb.setVisibility(8);
            setRankVisible(8);
            this.gNW.setVisibility(8);
            this.gNH.setVisibility(0);
            this.gNH.setData(i, fVar);
            this.gOe.setPadding(0, dimens, 0, 0);
        } else if (this.status == com.baidu.tieba.barselect.a.a.gNy) {
            if (i == 1) {
                this.gOd.setBackgroundResource(R.drawable.bar_select_bg_top_round);
                this.gOb.setVisibility(8);
            } else {
                this.gOd.setBackgroundColor(getResources().getColor(R.color.cp_bg_line_d));
                this.gOb.setVisibility(0);
                this.gOa.setVisibility(0);
            }
            setRankVisible(0);
            this.gNR.setVisibility(8);
            int rank = this.gNk.getRank();
            if (rank < 10) {
                this.gNQ.setText("0" + rank);
            } else {
                this.gNQ.setText("" + rank);
            }
            if (rank == 2) {
                this.gNQ.setTextColor(getResources().getColor(R.color.common_color_10263));
            } else if (rank == 3) {
                this.gNQ.setTextColor(getResources().getColor(R.color.common_color_10266));
            } else {
                this.gNQ.setTextColor(getResources().getColor(R.color.cp_cont_b));
            }
            this.gNW.setVisibility(8);
            this.gNH.setVisibility(0);
            this.gNH.setData(i, fVar);
        } else {
            setVisibility(8);
            return;
        }
        this.gNU.setData(i, fVar);
        this.gNV.setData(i, fVar);
        if (this.gNk.bNn()) {
            this.gNX.setVisibility(0);
        } else {
            this.gNX.setVisibility(8);
        }
        qJ(TbadkCoreApplication.getInst().getSkinType());
    }

    public void qJ(int i) {
        this.gNV.qJ(i);
        this.gNU.qJ(i);
        if (this.gNH.getVisibility() == 0) {
            this.gNH.qJ(i);
        }
        this.gNW.qJ(i);
        an.setBackgroundColor(this.eVD, R.color.cp_bg_line_c, i);
        if (this.status == com.baidu.tieba.barselect.a.a.gNA) {
            an.setBackgroundResource(this.gOd, R.drawable.bar_select_bg_shadow_and_radius, i);
            an.setViewTextColor(this.gNT, R.color.cp_cont_b, 1, i);
            an.setViewTextColor(this.gNS, R.color.cp_cont_b, 1, i);
        } else if (this.status == com.baidu.tieba.barselect.a.a.gNz) {
            an.setBackgroundResource(this.gOd, R.drawable.bg_bazhu_shadow_and_radius, i);
        } else if (this.status == com.baidu.tieba.barselect.a.a.gNy) {
            if (this.position == 1) {
                an.setBackgroundResource(this.gOd, R.drawable.bar_select_bg_top_round, i);
            } else {
                an.setBackgroundColor(this.gOd, R.color.cp_bg_line_d, i);
            }
        } else if (this.status == com.baidu.tieba.barselect.a.a.gNx) {
            an.setBackgroundColor(this.gOd, R.color.cp_bg_line_d, i);
        }
        if (this.gNk != null) {
            if (this.gNk.bNn()) {
                an.setViewTextColor(this.gNZ, R.color.cp_cont_h, 1, i);
                an.setBackgroundResource(this.gNY, R.drawable.icon_use_tip_red, i);
            }
            int rank = this.gNk.getRank();
            if (rank == 2) {
                an.setViewTextColor(this.gNQ, R.color.cp_link_tip_d, 1, i);
            } else if (rank == 3) {
                an.setViewTextColor(this.gNQ, R.color.cp_other_f, 1, i);
            } else {
                an.setViewTextColor(this.gNQ, R.color.cp_cont_b, 1, i);
            }
        }
    }

    private void setRankVisible(int i) {
        this.gNQ.setVisibility(i);
        this.gOc.setVisibility(i);
    }
}
