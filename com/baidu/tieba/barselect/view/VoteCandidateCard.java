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
import com.baidu.tieba.barselect.VoteAdapter;
import com.baidu.tieba.barselect.data.f;
import com.baidu.tieba.barselect.segment.CandidateInfoLayout;
import com.baidu.tieba.barselect.segment.CardBasicLayout;
import com.baidu.tieba.barselect.segment.NewAnounceLayout;
import com.baidu.tieba.barselect.segment.VoteAreaLayout;
import com.baidu.tieba.barselect.segment.VotedAreaLayout;
/* loaded from: classes8.dex */
public class VoteCandidateCard extends CardBasicLayout {
    public static int itx = -1;
    private View gft;
    private VoteAdapter ipE;
    private TextView itA;
    private TextView itB;
    private CandidateInfoLayout itC;
    private NewAnounceLayout itD;
    private VoteAreaLayout itE;
    private View itF;
    private TextView itG;
    private TextView itH;
    private View itI;
    private View itJ;
    private View itK;
    private View itL;
    private View itM;
    private TextView itN;
    private View itO;
    private LinearLayout itP;
    private VotedAreaLayout itp;
    private TextView ity;
    private View itz;
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
        tz();
    }

    private void tz() {
        this.itz = findViewById(R.id.mine_vote_content);
        this.itA = (TextView) findViewById(R.id.mine_vote_title);
        this.itB = (TextView) findViewById(R.id.mine_vote_num);
        this.ity = (TextView) findViewById(R.id.tv_voted_rank);
        this.itC = (CandidateInfoLayout) findViewById(R.id.candidate_info_layout);
        this.itD = (NewAnounceLayout) findViewById(R.id.announce_layout);
        this.itE = (VoteAreaLayout) findViewById(R.id.vote_area_layout);
        this.itp = (VotedAreaLayout) findViewById(R.id.voted_area_layout);
        this.gft = findViewById(R.id.divider_line);
        this.itI = findViewById(R.id.divider_empty_view);
        this.itJ = findViewById(R.id.divider_line_container);
        this.itK = findViewById(R.id.empty_view);
        this.itL = findViewById(R.id.main_container);
        this.itM = findViewById(R.id.info_container);
        this.itF = findViewById(R.id.vote_ueg_warn_container);
        this.itG = (TextView) findViewById(R.id.vote_ueg_warn_img);
        this.itH = (TextView) findViewById(R.id.vote_ueg_warn_tv);
        this.itO = findViewById(R.id.divider_top_line);
        this.itN = (TextView) findViewById(R.id.title_notpass_tv);
        this.itP = (LinearLayout) findViewById(R.id.not_allow_view);
    }

    @Override // com.baidu.tieba.barselect.segment.CardBasicLayout
    public void setData(int i, f fVar) {
        super.setData(i, fVar);
        this.position = i;
        if (this.iph == null || this.isS == null || this.status < 0) {
            setVisibility(8);
            return;
        }
        if (this.status == com.baidu.tieba.barselect.a.a.iti) {
            this.itL.setBackgroundResource(R.drawable.bar_select_bg_shadow_and_radius);
            this.itz.setVisibility(0);
            this.itB.setText("当前排名" + this.isS.getRank());
            setRankVisible(8);
            this.itJ.setVisibility(8);
            this.itE.setVisibility(0);
            this.itp.setVisibility(8);
            this.itE.setData(i, fVar);
            this.itP.setVisibility(8);
        } else if (this.status == com.baidu.tieba.barselect.a.a.itf) {
            if (i == 0) {
                this.itJ.setVisibility(8);
            } else {
                this.itJ.setVisibility(8);
                this.itI.setVisibility(8);
            }
            this.itL.setBackgroundColor(getResources().getColor(R.color.CAM_X0201));
            this.itz.setVisibility(8);
            setRankVisible(8);
            if (this.isS.crf() == 2 && this.ipE.cqY() == -1) {
                this.ipE.wK(i);
            }
            if (this.isS.crf() == 2) {
                if (this.ipE != null && this.ipE.cqY() == i) {
                    this.itP.setVisibility(0);
                } else {
                    this.itP.setVisibility(8);
                }
                this.itE.setVisibility(8);
            } else {
                this.itP.setVisibility(8);
                this.itE.setVisibility(0);
                this.itE.setData(i, fVar);
            }
            this.itp.setVisibility(8);
        } else if (this.status == com.baidu.tieba.barselect.a.a.ith) {
            int dimens = l.getDimens(getContext(), R.dimen.tbds22);
            int dimens2 = l.getDimens(getContext(), R.dimen.tbds10);
            int dimens3 = l.getDimens(getContext(), R.dimen.tbds20);
            int dimens4 = l.getDimens(getContext(), R.dimen.tbds30);
            this.itL.setBackgroundResource(R.drawable.bg_bazhu_shadow_and_radius);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.setMargins(dimens4, 0, dimens4, dimens3);
            this.itL.setLayoutParams(layoutParams);
            this.itL.setPadding(dimens2, 0, dimens2, dimens4);
            this.itz.setVisibility(8);
            this.itJ.setVisibility(8);
            setRankVisible(8);
            this.itE.setVisibility(8);
            this.itp.setVisibility(0);
            this.itp.setData(i, fVar);
            this.itM.setPadding(0, dimens, 0, 0);
            this.itP.setVisibility(8);
        } else if (this.status == com.baidu.tieba.barselect.a.a.itg) {
            if (i == 1) {
                this.itL.setBackgroundResource(R.drawable.bar_select_bg_top_round);
                this.itJ.setVisibility(8);
            } else {
                this.itL.setBackgroundColor(getResources().getColor(R.color.CAM_X0201));
                this.itJ.setVisibility(0);
                this.itI.setVisibility(0);
            }
            setRankVisible(0);
            this.itz.setVisibility(8);
            int rank = this.isS.getRank();
            if (rank < 10) {
                this.ity.setText("0" + rank);
            } else {
                this.ity.setText("" + rank);
            }
            if (rank == 2) {
                this.ity.setTextColor(getResources().getColor(R.color.common_color_10263));
            } else if (rank == 3) {
                this.ity.setTextColor(getResources().getColor(R.color.common_color_10266));
            } else {
                this.ity.setTextColor(getResources().getColor(R.color.CAM_X0105));
            }
            this.itE.setVisibility(8);
            this.itp.setVisibility(0);
            this.itp.setData(i, fVar);
            this.itP.setVisibility(8);
        } else {
            setVisibility(8);
            return;
        }
        this.itC.setData(i, fVar);
        this.itD.setData(i, fVar);
        if (this.isS.cre()) {
            this.itF.setVisibility(0);
        } else {
            this.itF.setVisibility(8);
        }
        uu(TbadkCoreApplication.getInst().getSkinType());
    }

    public void uu(int i) {
        this.itD.uu(i);
        this.itC.uu(i);
        if (this.itp.getVisibility() == 0) {
            this.itp.uu(i);
        }
        this.itE.uu(i);
        ap.setBackgroundColor(this.gft, R.color.CAM_X0204, i);
        if (this.status == com.baidu.tieba.barselect.a.a.iti) {
            ap.setBackgroundResource(this.itL, R.drawable.bar_select_bg_shadow_and_radius, i);
            ap.setViewTextColor(this.itB, R.color.CAM_X0105, 1, i);
            ap.setViewTextColor(this.itA, R.color.CAM_X0105, 1, i);
        } else if (this.status == com.baidu.tieba.barselect.a.a.ith) {
            ap.setBackgroundResource(this.itL, R.drawable.bg_bazhu_shadow_and_radius, i);
        } else if (this.status == com.baidu.tieba.barselect.a.a.itg) {
            if (this.position == 1) {
                ap.setBackgroundResource(this.itL, R.drawable.bar_select_bg_top_round, i);
            } else {
                ap.setBackgroundColor(this.itL, R.color.CAM_X0201, i);
            }
        } else if (this.status == com.baidu.tieba.barselect.a.a.itf) {
            ap.setBackgroundColor(this.itL, R.color.CAM_X0201, i);
            ap.setViewTextColor(this.itN, R.color.CAM_X0105, 1, i);
            ap.setBackgroundColor(this.itP, R.color.CAM_X0201, i);
            ap.setBackgroundColor(this.itO, R.color.CAM_X0203, i);
        }
        if (this.isS != null) {
            if (this.isS.cre()) {
                ap.setViewTextColor(this.itH, R.color.CAM_X0301, 1, i);
                ap.setBackgroundResource(this.itG, R.drawable.icon_use_tip_red, i);
            }
            int rank = this.isS.getRank();
            if (rank == 2) {
                ap.setViewTextColor(this.ity, R.color.CAM_X0305, 1, i);
            } else if (rank == 3) {
                ap.setViewTextColor(this.ity, R.color.CAM_X0312, 1, i);
            } else {
                ap.setViewTextColor(this.ity, R.color.CAM_X0105, 1, i);
            }
        }
    }

    private void setRankVisible(int i) {
        this.ity.setVisibility(i);
        this.itK.setVisibility(i);
    }

    public void setVoteAdaPter(VoteAdapter voteAdapter) {
        this.ipE = voteAdapter;
    }
}
