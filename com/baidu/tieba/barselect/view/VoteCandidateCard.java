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
/* loaded from: classes5.dex */
public class VoteCandidateCard extends CardBasicLayout {
    public static int fAK = -1;
    private View bZT;
    private VotedAreaLayout fAF;
    private TextView fAL;
    private View fAM;
    private TextView fAN;
    private TextView fAO;
    private CandidateInfoLayout fAP;
    private NewAnounceLayout fAQ;
    private VoteAreaLayout fAR;
    private View fAS;
    private TextView fAT;
    private TextView fAU;
    private View fAV;
    private View fAW;
    private View fAX;
    private View fAY;
    private View fAZ;
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
        na();
    }

    private void na() {
        this.fAM = findViewById(R.id.mine_vote_content);
        this.fAN = (TextView) findViewById(R.id.mine_vote_title);
        this.fAO = (TextView) findViewById(R.id.mine_vote_num);
        this.fAL = (TextView) findViewById(R.id.tv_voted_rank);
        this.fAP = (CandidateInfoLayout) findViewById(R.id.candidate_info_layout);
        this.fAQ = (NewAnounceLayout) findViewById(R.id.announce_layout);
        this.fAR = (VoteAreaLayout) findViewById(R.id.vote_area_layout);
        this.fAF = (VotedAreaLayout) findViewById(R.id.voted_area_layout);
        this.bZT = findViewById(R.id.divider_line);
        this.fAV = findViewById(R.id.divider_empty_view);
        this.fAW = findViewById(R.id.divider_line_container);
        this.fAX = findViewById(R.id.empty_view);
        this.fAY = findViewById(R.id.main_container);
        this.fAZ = findViewById(R.id.info_container);
        this.fAS = findViewById(R.id.vote_ueg_warn_container);
        this.fAT = (TextView) findViewById(R.id.vote_ueg_warn_img);
        this.fAU = (TextView) findViewById(R.id.vote_ueg_warn_tv);
    }

    @Override // com.baidu.tieba.barselect.segment.CardBasicLayout
    public void setData(int i, f fVar) {
        super.setData(i, fVar);
        this.position = i;
        if (this.fww == null || this.fAh == null || this.status < 0) {
            setVisibility(8);
            return;
        }
        if (this.status == com.baidu.tieba.barselect.a.a.fAy) {
            this.fAY.setBackgroundResource(R.drawable.bar_select_bg_shadow_and_radius);
            this.fAM.setVisibility(0);
            this.fAO.setText("当前排名" + this.fAh.getRank());
            setRankVisible(8);
            this.fAW.setVisibility(8);
            this.fAR.setVisibility(0);
            this.fAF.setVisibility(8);
            this.fAR.setData(i, fVar);
        } else if (this.status == com.baidu.tieba.barselect.a.a.fAv) {
            if (i == 0) {
                this.fAW.setVisibility(8);
            } else {
                this.fAW.setVisibility(8);
                this.fAV.setVisibility(8);
            }
            this.fAY.setBackgroundColor(getResources().getColor(R.color.cp_bg_line_d));
            this.fAM.setVisibility(8);
            setRankVisible(8);
            this.fAR.setVisibility(0);
            this.fAF.setVisibility(8);
            this.fAR.setData(i, fVar);
        } else if (this.status == com.baidu.tieba.barselect.a.a.fAx) {
            int dimens = l.getDimens(getContext(), R.dimen.tbds22);
            int dimens2 = l.getDimens(getContext(), R.dimen.tbds10);
            int dimens3 = l.getDimens(getContext(), R.dimen.tbds20);
            int dimens4 = l.getDimens(getContext(), R.dimen.tbds30);
            this.fAY.setBackgroundResource(R.drawable.bg_bazhu_shadow_and_radius);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.setMargins(dimens4, 0, dimens4, dimens3);
            this.fAY.setLayoutParams(layoutParams);
            this.fAY.setPadding(dimens2, 0, dimens2, dimens4);
            this.fAM.setVisibility(8);
            this.fAW.setVisibility(8);
            setRankVisible(8);
            this.fAR.setVisibility(8);
            this.fAF.setVisibility(0);
            this.fAF.setData(i, fVar);
            this.fAZ.setPadding(0, dimens, 0, 0);
        } else if (this.status == com.baidu.tieba.barselect.a.a.fAw) {
            if (i == 1) {
                this.fAY.setBackgroundResource(R.drawable.bar_select_bg_top_round);
                this.fAW.setVisibility(8);
            } else {
                this.fAY.setBackgroundColor(getResources().getColor(R.color.cp_bg_line_d));
                this.fAW.setVisibility(0);
                this.fAV.setVisibility(0);
            }
            setRankVisible(0);
            this.fAM.setVisibility(8);
            int rank = this.fAh.getRank();
            if (rank < 10) {
                this.fAL.setText("0" + rank);
            } else {
                this.fAL.setText("" + rank);
            }
            if (rank == 2) {
                this.fAL.setTextColor(getResources().getColor(R.color.common_color_10263));
            } else if (rank == 3) {
                this.fAL.setTextColor(getResources().getColor(R.color.common_color_10266));
            } else {
                this.fAL.setTextColor(getResources().getColor(R.color.cp_cont_b));
            }
            this.fAR.setVisibility(8);
            this.fAF.setVisibility(0);
            this.fAF.setData(i, fVar);
        } else {
            setVisibility(8);
            return;
        }
        this.fAP.setData(i, fVar);
        this.fAQ.setData(i, fVar);
        if (this.fAh.brq()) {
            this.fAS.setVisibility(0);
        } else {
            this.fAS.setVisibility(8);
        }
        oT(TbadkCoreApplication.getInst().getSkinType());
    }

    public void oT(int i) {
        this.fAQ.oT(i);
        this.fAP.oT(i);
        if (this.fAF.getVisibility() == 0) {
            this.fAF.oT(i);
        }
        this.fAR.oT(i);
        am.setBackgroundColor(this.bZT, R.color.cp_bg_line_c, i);
        if (this.status == com.baidu.tieba.barselect.a.a.fAy) {
            am.setBackgroundResource(this.fAY, R.drawable.bar_select_bg_shadow_and_radius, i);
            am.setViewTextColor(this.fAO, R.color.cp_cont_b, 1, i);
            am.setViewTextColor(this.fAN, R.color.cp_cont_b, 1, i);
        } else if (this.status == com.baidu.tieba.barselect.a.a.fAx) {
            am.setBackgroundResource(this.fAY, R.drawable.bg_bazhu_shadow_and_radius, i);
        } else if (this.status == com.baidu.tieba.barselect.a.a.fAw) {
            if (this.position == 1) {
                am.setBackgroundResource(this.fAY, R.drawable.bar_select_bg_top_round, i);
            } else {
                am.setBackgroundColor(this.fAY, R.color.cp_bg_line_d, i);
            }
        } else if (this.status == com.baidu.tieba.barselect.a.a.fAv) {
            am.setBackgroundColor(this.fAY, R.color.cp_bg_line_d, i);
        }
        if (this.fAh != null) {
            if (this.fAh.brq()) {
                am.setViewTextColor(this.fAU, R.color.cp_cont_h, 1, i);
                am.setBackgroundResource(this.fAT, R.drawable.icon_use_tip_red, i);
            }
            int rank = this.fAh.getRank();
            if (rank == 2) {
                am.setViewTextColor(this.fAL, R.color.cp_link_tip_d, 1, i);
            } else if (rank == 3) {
                am.setViewTextColor(this.fAL, R.color.cp_other_f, 1, i);
            } else {
                am.setViewTextColor(this.fAL, R.color.cp_cont_b, 1, i);
            }
        }
    }

    private void setRankVisible(int i) {
        this.fAL.setVisibility(i);
        this.fAX.setVisibility(i);
    }
}
