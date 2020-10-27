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
    public static int hOJ = -1;
    private View fKv;
    private d hKM;
    private VotedAreaLayout hOB;
    private TextView hOK;
    private View hOL;
    private TextView hOM;
    private TextView hON;
    private CandidateInfoLayout hOO;
    private NewAnounceLayout hOP;
    private VoteAreaLayout hOQ;
    private View hOR;
    private TextView hOS;
    private TextView hOT;
    private View hOU;
    private View hOV;
    private View hOW;
    private View hOX;
    private View hOY;
    private TextView hOZ;
    private View hPa;
    private LinearLayout hPb;
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
        this.hOL = findViewById(R.id.mine_vote_content);
        this.hOM = (TextView) findViewById(R.id.mine_vote_title);
        this.hON = (TextView) findViewById(R.id.mine_vote_num);
        this.hOK = (TextView) findViewById(R.id.tv_voted_rank);
        this.hOO = (CandidateInfoLayout) findViewById(R.id.candidate_info_layout);
        this.hOP = (NewAnounceLayout) findViewById(R.id.announce_layout);
        this.hOQ = (VoteAreaLayout) findViewById(R.id.vote_area_layout);
        this.hOB = (VotedAreaLayout) findViewById(R.id.voted_area_layout);
        this.fKv = findViewById(R.id.divider_line);
        this.hOU = findViewById(R.id.divider_empty_view);
        this.hOV = findViewById(R.id.divider_line_container);
        this.hOW = findViewById(R.id.empty_view);
        this.hOX = findViewById(R.id.main_container);
        this.hOY = findViewById(R.id.info_container);
        this.hOR = findViewById(R.id.vote_ueg_warn_container);
        this.hOS = (TextView) findViewById(R.id.vote_ueg_warn_img);
        this.hOT = (TextView) findViewById(R.id.vote_ueg_warn_tv);
        this.hPa = findViewById(R.id.divider_top_line);
        this.hOZ = (TextView) findViewById(R.id.title_notpass_tv);
        this.hPb = (LinearLayout) findViewById(R.id.not_allow_view);
    }

    @Override // com.baidu.tieba.barselect.segment.CardBasicLayout
    public void setData(int i, f fVar) {
        super.setData(i, fVar);
        this.position = i;
        if (this.hKp == null || this.hOe == null || this.status < 0) {
            setVisibility(8);
            return;
        }
        if (this.status == com.baidu.tieba.barselect.a.a.hOu) {
            this.hOX.setBackgroundResource(R.drawable.bar_select_bg_shadow_and_radius);
            this.hOL.setVisibility(0);
            this.hON.setText("当前排名" + this.hOe.getRank());
            setRankVisible(8);
            this.hOV.setVisibility(8);
            this.hOQ.setVisibility(0);
            this.hOB.setVisibility(8);
            this.hOQ.setData(i, fVar);
            this.hPb.setVisibility(8);
        } else if (this.status == com.baidu.tieba.barselect.a.a.hOr) {
            if (i == 0) {
                this.hOV.setVisibility(8);
            } else {
                this.hOV.setVisibility(8);
                this.hOU.setVisibility(8);
            }
            this.hOX.setBackgroundColor(getResources().getColor(R.color.cp_bg_line_d));
            this.hOL.setVisibility(8);
            setRankVisible(8);
            if (this.hOe.ckB() == 2 && this.hKM.cku() == -1) {
                this.hKM.wB(i);
            }
            if (this.hOe.ckB() == 2) {
                if (this.hKM != null && this.hKM.cku() == i) {
                    this.hPb.setVisibility(0);
                } else {
                    this.hPb.setVisibility(8);
                }
                this.hOQ.setVisibility(8);
            } else {
                this.hPb.setVisibility(8);
                this.hOQ.setVisibility(0);
                this.hOQ.setData(i, fVar);
            }
            this.hOB.setVisibility(8);
        } else if (this.status == com.baidu.tieba.barselect.a.a.hOt) {
            int dimens = l.getDimens(getContext(), R.dimen.tbds22);
            int dimens2 = l.getDimens(getContext(), R.dimen.tbds10);
            int dimens3 = l.getDimens(getContext(), R.dimen.tbds20);
            int dimens4 = l.getDimens(getContext(), R.dimen.tbds30);
            this.hOX.setBackgroundResource(R.drawable.bg_bazhu_shadow_and_radius);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.setMargins(dimens4, 0, dimens4, dimens3);
            this.hOX.setLayoutParams(layoutParams);
            this.hOX.setPadding(dimens2, 0, dimens2, dimens4);
            this.hOL.setVisibility(8);
            this.hOV.setVisibility(8);
            setRankVisible(8);
            this.hOQ.setVisibility(8);
            this.hOB.setVisibility(0);
            this.hOB.setData(i, fVar);
            this.hOY.setPadding(0, dimens, 0, 0);
            this.hPb.setVisibility(8);
        } else if (this.status == com.baidu.tieba.barselect.a.a.hOs) {
            if (i == 1) {
                this.hOX.setBackgroundResource(R.drawable.bar_select_bg_top_round);
                this.hOV.setVisibility(8);
            } else {
                this.hOX.setBackgroundColor(getResources().getColor(R.color.cp_bg_line_d));
                this.hOV.setVisibility(0);
                this.hOU.setVisibility(0);
            }
            setRankVisible(0);
            this.hOL.setVisibility(8);
            int rank = this.hOe.getRank();
            if (rank < 10) {
                this.hOK.setText("0" + rank);
            } else {
                this.hOK.setText("" + rank);
            }
            if (rank == 2) {
                this.hOK.setTextColor(getResources().getColor(R.color.common_color_10263));
            } else if (rank == 3) {
                this.hOK.setTextColor(getResources().getColor(R.color.common_color_10266));
            } else {
                this.hOK.setTextColor(getResources().getColor(R.color.cp_cont_b));
            }
            this.hOQ.setVisibility(8);
            this.hOB.setVisibility(0);
            this.hOB.setData(i, fVar);
            this.hPb.setVisibility(8);
        } else {
            setVisibility(8);
            return;
        }
        this.hOO.setData(i, fVar);
        this.hOP.setData(i, fVar);
        if (this.hOe.ckA()) {
            this.hOR.setVisibility(0);
        } else {
            this.hOR.setVisibility(8);
        }
        uu(TbadkCoreApplication.getInst().getSkinType());
    }

    public void uu(int i) {
        this.hOP.uu(i);
        this.hOO.uu(i);
        if (this.hOB.getVisibility() == 0) {
            this.hOB.uu(i);
        }
        this.hOQ.uu(i);
        ap.setBackgroundColor(this.fKv, R.color.cp_bg_line_c, i);
        if (this.status == com.baidu.tieba.barselect.a.a.hOu) {
            ap.setBackgroundResource(this.hOX, R.drawable.bar_select_bg_shadow_and_radius, i);
            ap.setViewTextColor(this.hON, R.color.cp_cont_b, 1, i);
            ap.setViewTextColor(this.hOM, R.color.cp_cont_b, 1, i);
        } else if (this.status == com.baidu.tieba.barselect.a.a.hOt) {
            ap.setBackgroundResource(this.hOX, R.drawable.bg_bazhu_shadow_and_radius, i);
        } else if (this.status == com.baidu.tieba.barselect.a.a.hOs) {
            if (this.position == 1) {
                ap.setBackgroundResource(this.hOX, R.drawable.bar_select_bg_top_round, i);
            } else {
                ap.setBackgroundColor(this.hOX, R.color.cp_bg_line_d, i);
            }
        } else if (this.status == com.baidu.tieba.barselect.a.a.hOr) {
            ap.setBackgroundColor(this.hOX, R.color.cp_bg_line_d, i);
            ap.setViewTextColor(this.hOZ, R.color.cp_cont_b, 1, i);
            ap.setBackgroundColor(this.hPb, R.color.cp_bg_line_d, i);
            ap.setBackgroundColor(this.hPa, R.color.cp_bg_line_b, i);
        }
        if (this.hOe != null) {
            if (this.hOe.ckA()) {
                ap.setViewTextColor(this.hOT, R.color.cp_cont_h, 1, i);
                ap.setBackgroundResource(this.hOS, R.drawable.icon_use_tip_red, i);
            }
            int rank = this.hOe.getRank();
            if (rank == 2) {
                ap.setViewTextColor(this.hOK, R.color.cp_link_tip_d, 1, i);
            } else if (rank == 3) {
                ap.setViewTextColor(this.hOK, R.color.cp_other_f, 1, i);
            } else {
                ap.setViewTextColor(this.hOK, R.color.cp_cont_b, 1, i);
            }
        }
    }

    private void setRankVisible(int i) {
        this.hOK.setVisibility(i);
        this.hOW.setVisibility(i);
    }

    public void setVoteAdaPter(d dVar) {
        this.hKM = dVar;
    }
}
