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
    public static int gAT = -1;
    private View eLg;
    private VotedAreaLayout gAL;
    private TextView gAU;
    private View gAV;
    private TextView gAW;
    private TextView gAX;
    private CandidateInfoLayout gAY;
    private NewAnounceLayout gAZ;
    private VoteAreaLayout gBa;
    private View gBb;
    private TextView gBc;
    private TextView gBd;
    private View gBe;
    private View gBf;
    private View gBg;
    private View gBh;
    private View gBi;
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
        rV();
    }

    private void rV() {
        this.gAV = findViewById(R.id.mine_vote_content);
        this.gAW = (TextView) findViewById(R.id.mine_vote_title);
        this.gAX = (TextView) findViewById(R.id.mine_vote_num);
        this.gAU = (TextView) findViewById(R.id.tv_voted_rank);
        this.gAY = (CandidateInfoLayout) findViewById(R.id.candidate_info_layout);
        this.gAZ = (NewAnounceLayout) findViewById(R.id.announce_layout);
        this.gBa = (VoteAreaLayout) findViewById(R.id.vote_area_layout);
        this.gAL = (VotedAreaLayout) findViewById(R.id.voted_area_layout);
        this.eLg = findViewById(R.id.divider_line);
        this.gBe = findViewById(R.id.divider_empty_view);
        this.gBf = findViewById(R.id.divider_line_container);
        this.gBg = findViewById(R.id.empty_view);
        this.gBh = findViewById(R.id.main_container);
        this.gBi = findViewById(R.id.info_container);
        this.gBb = findViewById(R.id.vote_ueg_warn_container);
        this.gBc = (TextView) findViewById(R.id.vote_ueg_warn_img);
        this.gBd = (TextView) findViewById(R.id.vote_ueg_warn_tv);
    }

    @Override // com.baidu.tieba.barselect.segment.CardBasicLayout
    public void setData(int i, f fVar) {
        super.setData(i, fVar);
        this.position = i;
        if (this.gwA == null || this.gAn == null || this.status < 0) {
            setVisibility(8);
            return;
        }
        if (this.status == com.baidu.tieba.barselect.a.a.gAE) {
            this.gBh.setBackgroundResource(R.drawable.bar_select_bg_shadow_and_radius);
            this.gAV.setVisibility(0);
            this.gAX.setText("当前排名" + this.gAn.getRank());
            setRankVisible(8);
            this.gBf.setVisibility(8);
            this.gBa.setVisibility(0);
            this.gAL.setVisibility(8);
            this.gBa.setData(i, fVar);
        } else if (this.status == com.baidu.tieba.barselect.a.a.gAB) {
            if (i == 0) {
                this.gBf.setVisibility(8);
            } else {
                this.gBf.setVisibility(8);
                this.gBe.setVisibility(8);
            }
            this.gBh.setBackgroundColor(getResources().getColor(R.color.cp_bg_line_d));
            this.gAV.setVisibility(8);
            setRankVisible(8);
            this.gBa.setVisibility(0);
            this.gAL.setVisibility(8);
            this.gBa.setData(i, fVar);
        } else if (this.status == com.baidu.tieba.barselect.a.a.gAD) {
            int dimens = l.getDimens(getContext(), R.dimen.tbds22);
            int dimens2 = l.getDimens(getContext(), R.dimen.tbds10);
            int dimens3 = l.getDimens(getContext(), R.dimen.tbds20);
            int dimens4 = l.getDimens(getContext(), R.dimen.tbds30);
            this.gBh.setBackgroundResource(R.drawable.bg_bazhu_shadow_and_radius);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.setMargins(dimens4, 0, dimens4, dimens3);
            this.gBh.setLayoutParams(layoutParams);
            this.gBh.setPadding(dimens2, 0, dimens2, dimens4);
            this.gAV.setVisibility(8);
            this.gBf.setVisibility(8);
            setRankVisible(8);
            this.gBa.setVisibility(8);
            this.gAL.setVisibility(0);
            this.gAL.setData(i, fVar);
            this.gBi.setPadding(0, dimens, 0, 0);
        } else if (this.status == com.baidu.tieba.barselect.a.a.gAC) {
            if (i == 1) {
                this.gBh.setBackgroundResource(R.drawable.bar_select_bg_top_round);
                this.gBf.setVisibility(8);
            } else {
                this.gBh.setBackgroundColor(getResources().getColor(R.color.cp_bg_line_d));
                this.gBf.setVisibility(0);
                this.gBe.setVisibility(0);
            }
            setRankVisible(0);
            this.gAV.setVisibility(8);
            int rank = this.gAn.getRank();
            if (rank < 10) {
                this.gAU.setText("0" + rank);
            } else {
                this.gAU.setText("" + rank);
            }
            if (rank == 2) {
                this.gAU.setTextColor(getResources().getColor(R.color.common_color_10263));
            } else if (rank == 3) {
                this.gAU.setTextColor(getResources().getColor(R.color.common_color_10266));
            } else {
                this.gAU.setTextColor(getResources().getColor(R.color.cp_cont_b));
            }
            this.gBa.setVisibility(8);
            this.gAL.setVisibility(0);
            this.gAL.setData(i, fVar);
        } else {
            setVisibility(8);
            return;
        }
        this.gAY.setData(i, fVar);
        this.gAZ.setData(i, fVar);
        if (this.gAn.bKf()) {
            this.gBb.setVisibility(0);
        } else {
            this.gBb.setVisibility(8);
        }
        qi(TbadkCoreApplication.getInst().getSkinType());
    }

    public void qi(int i) {
        this.gAZ.qi(i);
        this.gAY.qi(i);
        if (this.gAL.getVisibility() == 0) {
            this.gAL.qi(i);
        }
        this.gBa.qi(i);
        am.setBackgroundColor(this.eLg, R.color.cp_bg_line_c, i);
        if (this.status == com.baidu.tieba.barselect.a.a.gAE) {
            am.setBackgroundResource(this.gBh, R.drawable.bar_select_bg_shadow_and_radius, i);
            am.setViewTextColor(this.gAX, R.color.cp_cont_b, 1, i);
            am.setViewTextColor(this.gAW, R.color.cp_cont_b, 1, i);
        } else if (this.status == com.baidu.tieba.barselect.a.a.gAD) {
            am.setBackgroundResource(this.gBh, R.drawable.bg_bazhu_shadow_and_radius, i);
        } else if (this.status == com.baidu.tieba.barselect.a.a.gAC) {
            if (this.position == 1) {
                am.setBackgroundResource(this.gBh, R.drawable.bar_select_bg_top_round, i);
            } else {
                am.setBackgroundColor(this.gBh, R.color.cp_bg_line_d, i);
            }
        } else if (this.status == com.baidu.tieba.barselect.a.a.gAB) {
            am.setBackgroundColor(this.gBh, R.color.cp_bg_line_d, i);
        }
        if (this.gAn != null) {
            if (this.gAn.bKf()) {
                am.setViewTextColor(this.gBd, R.color.cp_cont_h, 1, i);
                am.setBackgroundResource(this.gBc, R.drawable.icon_use_tip_red, i);
            }
            int rank = this.gAn.getRank();
            if (rank == 2) {
                am.setViewTextColor(this.gAU, R.color.cp_link_tip_d, 1, i);
            } else if (rank == 3) {
                am.setViewTextColor(this.gAU, R.color.cp_other_f, 1, i);
            } else {
                am.setViewTextColor(this.gAU, R.color.cp_cont_b, 1, i);
            }
        }
    }

    private void setRankVisible(int i) {
        this.gAU.setVisibility(i);
        this.gBg.setVisibility(i);
    }
}
