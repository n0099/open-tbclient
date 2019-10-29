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
/* loaded from: classes3.dex */
public class VoteCandidateCard extends CardBasicLayout {
    public static int eJE = -1;
    private View deR;
    private TextView eJF;
    private View eJG;
    private TextView eJH;
    private TextView eJI;
    private CandidateInfoLayout eJJ;
    private NewAnounceLayout eJK;
    private VoteAreaLayout eJL;
    private View eJM;
    private TextView eJN;
    private TextView eJO;
    private View eJP;
    private View eJQ;
    private View eJR;
    private View eJS;
    private View eJT;
    private VotedAreaLayout eJz;
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
        md();
    }

    private void md() {
        this.eJG = findViewById(R.id.mine_vote_content);
        this.eJH = (TextView) findViewById(R.id.mine_vote_title);
        this.eJI = (TextView) findViewById(R.id.mine_vote_num);
        this.eJF = (TextView) findViewById(R.id.tv_voted_rank);
        this.eJJ = (CandidateInfoLayout) findViewById(R.id.candidate_info_layout);
        this.eJK = (NewAnounceLayout) findViewById(R.id.announce_layout);
        this.eJL = (VoteAreaLayout) findViewById(R.id.vote_area_layout);
        this.eJz = (VotedAreaLayout) findViewById(R.id.voted_area_layout);
        this.deR = findViewById(R.id.divider_line);
        this.eJP = findViewById(R.id.divider_empty_view);
        this.eJQ = findViewById(R.id.divider_line_container);
        this.eJR = findViewById(R.id.empty_view);
        this.eJS = findViewById(R.id.main_container);
        this.eJT = findViewById(R.id.info_container);
        this.eJM = findViewById(R.id.vote_ueg_warn_container);
        this.eJN = (TextView) findViewById(R.id.vote_ueg_warn_img);
        this.eJO = (TextView) findViewById(R.id.vote_ueg_warn_tv);
    }

    @Override // com.baidu.tieba.barselect.segment.CardBasicLayout
    public void setData(int i, f fVar) {
        super.setData(i, fVar);
        this.position = i;
        if (this.eFp == null || this.eJb == null || this.status < 0) {
            setVisibility(8);
            return;
        }
        if (this.status == com.baidu.tieba.barselect.a.a.eJs) {
            this.eJS.setBackgroundResource(R.drawable.bar_select_bg_shadow_and_radius);
            this.eJG.setVisibility(0);
            this.eJI.setText("当前排名" + this.eJb.getRank());
            setRankVisible(8);
            this.eJQ.setVisibility(8);
            this.eJL.setVisibility(0);
            this.eJz.setVisibility(8);
            this.eJL.setData(i, fVar);
        } else if (this.status == com.baidu.tieba.barselect.a.a.eJp) {
            if (i == 0) {
                this.eJQ.setVisibility(8);
            } else {
                this.eJQ.setVisibility(8);
                this.eJP.setVisibility(8);
            }
            this.eJS.setBackgroundColor(getResources().getColor(R.color.cp_bg_line_d));
            this.eJG.setVisibility(8);
            setRankVisible(8);
            this.eJL.setVisibility(0);
            this.eJz.setVisibility(8);
            this.eJL.setData(i, fVar);
        } else if (this.status == com.baidu.tieba.barselect.a.a.eJr) {
            int dimens = l.getDimens(getContext(), R.dimen.tbds22);
            int dimens2 = l.getDimens(getContext(), R.dimen.tbds10);
            int dimens3 = l.getDimens(getContext(), R.dimen.tbds20);
            int dimens4 = l.getDimens(getContext(), R.dimen.tbds30);
            this.eJS.setBackgroundResource(R.drawable.bg_bazhu_shadow_and_radius);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.setMargins(dimens4, 0, dimens4, dimens3);
            this.eJS.setLayoutParams(layoutParams);
            this.eJS.setPadding(dimens2, 0, dimens2, dimens4);
            this.eJG.setVisibility(8);
            this.eJQ.setVisibility(8);
            setRankVisible(8);
            this.eJL.setVisibility(8);
            this.eJz.setVisibility(0);
            this.eJz.setData(i, fVar);
            this.eJT.setPadding(0, dimens, 0, 0);
        } else if (this.status == com.baidu.tieba.barselect.a.a.eJq) {
            if (i == 1) {
                this.eJS.setBackgroundResource(R.drawable.bar_select_bg_top_round);
                this.eJQ.setVisibility(8);
            } else {
                this.eJS.setBackgroundColor(getResources().getColor(R.color.cp_bg_line_d));
                this.eJQ.setVisibility(0);
                this.eJP.setVisibility(0);
            }
            setRankVisible(0);
            this.eJG.setVisibility(8);
            int rank = this.eJb.getRank();
            if (rank < 10) {
                this.eJF.setText("0" + rank);
            } else {
                this.eJF.setText("" + rank);
            }
            if (rank == 2) {
                this.eJF.setTextColor(getResources().getColor(R.color.common_color_10263));
            } else if (rank == 3) {
                this.eJF.setTextColor(getResources().getColor(R.color.common_color_10266));
            } else {
                this.eJF.setTextColor(getResources().getColor(R.color.cp_cont_b));
            }
            this.eJL.setVisibility(8);
            this.eJz.setVisibility(0);
            this.eJz.setData(i, fVar);
        } else {
            setVisibility(8);
            return;
        }
        this.eJJ.setData(i, fVar);
        this.eJK.setData(i, fVar);
        if (this.eJb.aZo()) {
            this.eJM.setVisibility(0);
        } else {
            this.eJM.setVisibility(8);
        }
        mE(TbadkCoreApplication.getInst().getSkinType());
    }

    public void mE(int i) {
        this.eJK.mE(i);
        this.eJJ.mE(i);
        if (this.eJz.getVisibility() == 0) {
            this.eJz.mE(i);
        }
        this.eJL.mE(i);
        am.setBackgroundColor(this.deR, R.color.cp_bg_line_c, i);
        if (this.status == com.baidu.tieba.barselect.a.a.eJs) {
            am.setBackgroundResource(this.eJS, R.drawable.bar_select_bg_shadow_and_radius, i);
            am.setViewTextColor(this.eJI, R.color.cp_cont_b, 1, i);
            am.setViewTextColor(this.eJH, R.color.cp_cont_b, 1, i);
        } else if (this.status == com.baidu.tieba.barselect.a.a.eJr) {
            am.setBackgroundResource(this.eJS, R.drawable.bg_bazhu_shadow_and_radius, i);
        } else if (this.status == com.baidu.tieba.barselect.a.a.eJq) {
            if (this.position == 1) {
                am.setBackgroundResource(this.eJS, R.drawable.bar_select_bg_top_round, i);
            } else {
                am.setBackgroundColor(this.eJS, R.color.cp_bg_line_d, i);
            }
        } else if (this.status == com.baidu.tieba.barselect.a.a.eJp) {
            am.setBackgroundColor(this.eJS, R.color.cp_bg_line_d, i);
        }
        if (this.eJb != null) {
            if (this.eJb.aZo()) {
                am.setViewTextColor(this.eJO, R.color.cp_cont_h, 1, i);
                am.setBackgroundResource(this.eJN, R.drawable.icon_use_tip_red, i);
            }
            int rank = this.eJb.getRank();
            if (rank == 2) {
                am.setViewTextColor(this.eJF, R.color.cp_link_tip_d, 1, i);
            } else if (rank == 3) {
                am.setViewTextColor(this.eJF, R.color.cp_other_f, 1, i);
            } else {
                am.setViewTextColor(this.eJF, R.color.cp_cont_b, 1, i);
            }
        }
    }

    private void setRankVisible(int i) {
        this.eJF.setVisibility(i);
        this.eJR.setVisibility(i);
    }
}
