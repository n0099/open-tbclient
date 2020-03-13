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
    public static int fGH = -1;
    private View cen;
    private VotedAreaLayout fGC;
    private TextView fGI;
    private View fGJ;
    private TextView fGK;
    private TextView fGL;
    private CandidateInfoLayout fGM;
    private NewAnounceLayout fGN;
    private VoteAreaLayout fGO;
    private View fGP;
    private TextView fGQ;
    private TextView fGR;
    private View fGS;
    private View fGT;
    private View fGU;
    private View fGV;
    private View fGW;
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
        ns();
    }

    private void ns() {
        this.fGJ = findViewById(R.id.mine_vote_content);
        this.fGK = (TextView) findViewById(R.id.mine_vote_title);
        this.fGL = (TextView) findViewById(R.id.mine_vote_num);
        this.fGI = (TextView) findViewById(R.id.tv_voted_rank);
        this.fGM = (CandidateInfoLayout) findViewById(R.id.candidate_info_layout);
        this.fGN = (NewAnounceLayout) findViewById(R.id.announce_layout);
        this.fGO = (VoteAreaLayout) findViewById(R.id.vote_area_layout);
        this.fGC = (VotedAreaLayout) findViewById(R.id.voted_area_layout);
        this.cen = findViewById(R.id.divider_line);
        this.fGS = findViewById(R.id.divider_empty_view);
        this.fGT = findViewById(R.id.divider_line_container);
        this.fGU = findViewById(R.id.empty_view);
        this.fGV = findViewById(R.id.main_container);
        this.fGW = findViewById(R.id.info_container);
        this.fGP = findViewById(R.id.vote_ueg_warn_container);
        this.fGQ = (TextView) findViewById(R.id.vote_ueg_warn_img);
        this.fGR = (TextView) findViewById(R.id.vote_ueg_warn_tv);
    }

    @Override // com.baidu.tieba.barselect.segment.CardBasicLayout
    public void setData(int i, f fVar) {
        super.setData(i, fVar);
        this.position = i;
        if (this.fCu == null || this.fGe == null || this.status < 0) {
            setVisibility(8);
            return;
        }
        if (this.status == com.baidu.tieba.barselect.a.a.fGv) {
            this.fGV.setBackgroundResource(R.drawable.bar_select_bg_shadow_and_radius);
            this.fGJ.setVisibility(0);
            this.fGL.setText("当前排名" + this.fGe.getRank());
            setRankVisible(8);
            this.fGT.setVisibility(8);
            this.fGO.setVisibility(0);
            this.fGC.setVisibility(8);
            this.fGO.setData(i, fVar);
        } else if (this.status == com.baidu.tieba.barselect.a.a.fGs) {
            if (i == 0) {
                this.fGT.setVisibility(8);
            } else {
                this.fGT.setVisibility(8);
                this.fGS.setVisibility(8);
            }
            this.fGV.setBackgroundColor(getResources().getColor(R.color.cp_bg_line_d));
            this.fGJ.setVisibility(8);
            setRankVisible(8);
            this.fGO.setVisibility(0);
            this.fGC.setVisibility(8);
            this.fGO.setData(i, fVar);
        } else if (this.status == com.baidu.tieba.barselect.a.a.fGu) {
            int dimens = l.getDimens(getContext(), R.dimen.tbds22);
            int dimens2 = l.getDimens(getContext(), R.dimen.tbds10);
            int dimens3 = l.getDimens(getContext(), R.dimen.tbds20);
            int dimens4 = l.getDimens(getContext(), R.dimen.tbds30);
            this.fGV.setBackgroundResource(R.drawable.bg_bazhu_shadow_and_radius);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.setMargins(dimens4, 0, dimens4, dimens3);
            this.fGV.setLayoutParams(layoutParams);
            this.fGV.setPadding(dimens2, 0, dimens2, dimens4);
            this.fGJ.setVisibility(8);
            this.fGT.setVisibility(8);
            setRankVisible(8);
            this.fGO.setVisibility(8);
            this.fGC.setVisibility(0);
            this.fGC.setData(i, fVar);
            this.fGW.setPadding(0, dimens, 0, 0);
        } else if (this.status == com.baidu.tieba.barselect.a.a.fGt) {
            if (i == 1) {
                this.fGV.setBackgroundResource(R.drawable.bar_select_bg_top_round);
                this.fGT.setVisibility(8);
            } else {
                this.fGV.setBackgroundColor(getResources().getColor(R.color.cp_bg_line_d));
                this.fGT.setVisibility(0);
                this.fGS.setVisibility(0);
            }
            setRankVisible(0);
            this.fGJ.setVisibility(8);
            int rank = this.fGe.getRank();
            if (rank < 10) {
                this.fGI.setText("0" + rank);
            } else {
                this.fGI.setText("" + rank);
            }
            if (rank == 2) {
                this.fGI.setTextColor(getResources().getColor(R.color.common_color_10263));
            } else if (rank == 3) {
                this.fGI.setTextColor(getResources().getColor(R.color.common_color_10266));
            } else {
                this.fGI.setTextColor(getResources().getColor(R.color.cp_cont_b));
            }
            this.fGO.setVisibility(8);
            this.fGC.setVisibility(0);
            this.fGC.setData(i, fVar);
        } else {
            setVisibility(8);
            return;
        }
        this.fGM.setData(i, fVar);
        this.fGN.setData(i, fVar);
        if (this.fGe.btZ()) {
            this.fGP.setVisibility(0);
        } else {
            this.fGP.setVisibility(8);
        }
        pk(TbadkCoreApplication.getInst().getSkinType());
    }

    public void pk(int i) {
        this.fGN.pk(i);
        this.fGM.pk(i);
        if (this.fGC.getVisibility() == 0) {
            this.fGC.pk(i);
        }
        this.fGO.pk(i);
        am.setBackgroundColor(this.cen, R.color.cp_bg_line_c, i);
        if (this.status == com.baidu.tieba.barselect.a.a.fGv) {
            am.setBackgroundResource(this.fGV, R.drawable.bar_select_bg_shadow_and_radius, i);
            am.setViewTextColor(this.fGL, R.color.cp_cont_b, 1, i);
            am.setViewTextColor(this.fGK, R.color.cp_cont_b, 1, i);
        } else if (this.status == com.baidu.tieba.barselect.a.a.fGu) {
            am.setBackgroundResource(this.fGV, R.drawable.bg_bazhu_shadow_and_radius, i);
        } else if (this.status == com.baidu.tieba.barselect.a.a.fGt) {
            if (this.position == 1) {
                am.setBackgroundResource(this.fGV, R.drawable.bar_select_bg_top_round, i);
            } else {
                am.setBackgroundColor(this.fGV, R.color.cp_bg_line_d, i);
            }
        } else if (this.status == com.baidu.tieba.barselect.a.a.fGs) {
            am.setBackgroundColor(this.fGV, R.color.cp_bg_line_d, i);
        }
        if (this.fGe != null) {
            if (this.fGe.btZ()) {
                am.setViewTextColor(this.fGR, R.color.cp_cont_h, 1, i);
                am.setBackgroundResource(this.fGQ, R.drawable.icon_use_tip_red, i);
            }
            int rank = this.fGe.getRank();
            if (rank == 2) {
                am.setViewTextColor(this.fGI, R.color.cp_link_tip_d, 1, i);
            } else if (rank == 3) {
                am.setViewTextColor(this.fGI, R.color.cp_other_f, 1, i);
            } else {
                am.setViewTextColor(this.fGI, R.color.cp_cont_b, 1, i);
            }
        }
    }

    private void setRankVisible(int i) {
        this.fGI.setVisibility(i);
        this.fGU.setVisibility(i);
    }
}
