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
import com.baidu.tbadk.core.util.ao;
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
    public static int isA = -1;
    private View ghM;
    private VoteAdapter ioF;
    private TextView isB;
    private View isC;
    private TextView isD;
    private TextView isE;
    private CandidateInfoLayout isF;
    private NewAnounceLayout isG;
    private VoteAreaLayout isH;
    private View isI;
    private TextView isJ;
    private TextView isK;
    private View isL;
    private View isM;
    private View isN;
    private View isO;
    private View isP;
    private TextView isQ;
    private View isR;
    private LinearLayout isS;
    private VotedAreaLayout iss;
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
        tN();
    }

    private void tN() {
        this.isC = findViewById(R.id.mine_vote_content);
        this.isD = (TextView) findViewById(R.id.mine_vote_title);
        this.isE = (TextView) findViewById(R.id.mine_vote_num);
        this.isB = (TextView) findViewById(R.id.tv_voted_rank);
        this.isF = (CandidateInfoLayout) findViewById(R.id.candidate_info_layout);
        this.isG = (NewAnounceLayout) findViewById(R.id.announce_layout);
        this.isH = (VoteAreaLayout) findViewById(R.id.vote_area_layout);
        this.iss = (VotedAreaLayout) findViewById(R.id.voted_area_layout);
        this.ghM = findViewById(R.id.divider_line);
        this.isL = findViewById(R.id.divider_empty_view);
        this.isM = findViewById(R.id.divider_line_container);
        this.isN = findViewById(R.id.empty_view);
        this.isO = findViewById(R.id.main_container);
        this.isP = findViewById(R.id.info_container);
        this.isI = findViewById(R.id.vote_ueg_warn_container);
        this.isJ = (TextView) findViewById(R.id.vote_ueg_warn_img);
        this.isK = (TextView) findViewById(R.id.vote_ueg_warn_tv);
        this.isR = findViewById(R.id.divider_top_line);
        this.isQ = (TextView) findViewById(R.id.title_notpass_tv);
        this.isS = (LinearLayout) findViewById(R.id.not_allow_view);
    }

    @Override // com.baidu.tieba.barselect.segment.CardBasicLayout
    public void setData(int i, f fVar) {
        super.setData(i, fVar);
        this.position = i;
        if (this.ioi == null || this.irV == null || this.status < 0) {
            setVisibility(8);
            return;
        }
        if (this.status == com.baidu.tieba.barselect.a.a.isl) {
            this.isO.setBackgroundResource(R.drawable.bar_select_bg_shadow_and_radius);
            this.isC.setVisibility(0);
            this.isE.setText("当前排名" + this.irV.getRank());
            setRankVisible(8);
            this.isM.setVisibility(8);
            this.isH.setVisibility(0);
            this.iss.setVisibility(8);
            this.isH.setData(i, fVar);
            this.isS.setVisibility(8);
        } else if (this.status == com.baidu.tieba.barselect.a.a.isi) {
            if (i == 0) {
                this.isM.setVisibility(8);
            } else {
                this.isM.setVisibility(8);
                this.isL.setVisibility(8);
            }
            this.isO.setBackgroundColor(getResources().getColor(R.color.CAM_X0201));
            this.isC.setVisibility(8);
            setRankVisible(8);
            if (this.irV.ctN() == 2 && this.ioF.ctG() == -1) {
                this.ioF.yf(i);
            }
            if (this.irV.ctN() == 2) {
                if (this.ioF != null && this.ioF.ctG() == i) {
                    this.isS.setVisibility(0);
                } else {
                    this.isS.setVisibility(8);
                }
                this.isH.setVisibility(8);
            } else {
                this.isS.setVisibility(8);
                this.isH.setVisibility(0);
                this.isH.setData(i, fVar);
            }
            this.iss.setVisibility(8);
        } else if (this.status == com.baidu.tieba.barselect.a.a.isk) {
            int dimens = l.getDimens(getContext(), R.dimen.tbds22);
            int dimens2 = l.getDimens(getContext(), R.dimen.tbds10);
            int dimens3 = l.getDimens(getContext(), R.dimen.tbds20);
            int dimens4 = l.getDimens(getContext(), R.dimen.tbds30);
            this.isO.setBackgroundResource(R.drawable.bg_bazhu_shadow_and_radius);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.setMargins(dimens4, 0, dimens4, dimens3);
            this.isO.setLayoutParams(layoutParams);
            this.isO.setPadding(dimens2, 0, dimens2, dimens4);
            this.isC.setVisibility(8);
            this.isM.setVisibility(8);
            setRankVisible(8);
            this.isH.setVisibility(8);
            this.iss.setVisibility(0);
            this.iss.setData(i, fVar);
            this.isP.setPadding(0, dimens, 0, 0);
            this.isS.setVisibility(8);
        } else if (this.status == com.baidu.tieba.barselect.a.a.isj) {
            if (i == 1) {
                this.isO.setBackgroundResource(R.drawable.bar_select_bg_top_round);
                this.isM.setVisibility(8);
            } else {
                this.isO.setBackgroundColor(getResources().getColor(R.color.CAM_X0201));
                this.isM.setVisibility(0);
                this.isL.setVisibility(0);
            }
            setRankVisible(0);
            this.isC.setVisibility(8);
            int rank = this.irV.getRank();
            if (rank < 10) {
                this.isB.setText("0" + rank);
            } else {
                this.isB.setText("" + rank);
            }
            if (rank == 2) {
                this.isB.setTextColor(getResources().getColor(R.color.common_color_10263));
            } else if (rank == 3) {
                this.isB.setTextColor(getResources().getColor(R.color.common_color_10266));
            } else {
                this.isB.setTextColor(getResources().getColor(R.color.CAM_X0105));
            }
            this.isH.setVisibility(8);
            this.iss.setVisibility(0);
            this.iss.setData(i, fVar);
            this.isS.setVisibility(8);
        } else {
            setVisibility(8);
            return;
        }
        this.isF.setData(i, fVar);
        this.isG.setData(i, fVar);
        if (this.irV.ctM()) {
            this.isI.setVisibility(0);
        } else {
            this.isI.setVisibility(8);
        }
        vU(TbadkCoreApplication.getInst().getSkinType());
    }

    public void vU(int i) {
        this.isG.vU(i);
        this.isF.vU(i);
        if (this.iss.getVisibility() == 0) {
            this.iss.vU(i);
        }
        this.isH.vU(i);
        ao.setBackgroundColor(this.ghM, R.color.CAM_X0204, i);
        if (this.status == com.baidu.tieba.barselect.a.a.isl) {
            ao.setBackgroundResource(this.isO, R.drawable.bar_select_bg_shadow_and_radius, i);
            ao.setViewTextColor(this.isE, R.color.CAM_X0105, 1, i);
            ao.setViewTextColor(this.isD, R.color.CAM_X0105, 1, i);
        } else if (this.status == com.baidu.tieba.barselect.a.a.isk) {
            ao.setBackgroundResource(this.isO, R.drawable.bg_bazhu_shadow_and_radius, i);
        } else if (this.status == com.baidu.tieba.barselect.a.a.isj) {
            if (this.position == 1) {
                ao.setBackgroundResource(this.isO, R.drawable.bar_select_bg_top_round, i);
            } else {
                ao.setBackgroundColor(this.isO, R.color.CAM_X0201, i);
            }
        } else if (this.status == com.baidu.tieba.barselect.a.a.isi) {
            ao.setBackgroundColor(this.isO, R.color.CAM_X0201, i);
            ao.setViewTextColor(this.isQ, R.color.CAM_X0105, 1, i);
            ao.setBackgroundColor(this.isS, R.color.CAM_X0201, i);
            ao.setBackgroundColor(this.isR, R.color.CAM_X0203, i);
        }
        if (this.irV != null) {
            if (this.irV.ctM()) {
                ao.setViewTextColor(this.isK, R.color.CAM_X0301, 1, i);
                ao.setBackgroundResource(this.isJ, R.drawable.icon_use_tip_red, i);
            }
            int rank = this.irV.getRank();
            if (rank == 2) {
                ao.setViewTextColor(this.isB, R.color.CAM_X0305, 1, i);
            } else if (rank == 3) {
                ao.setViewTextColor(this.isB, R.color.CAM_X0312, 1, i);
            } else {
                ao.setViewTextColor(this.isB, R.color.CAM_X0105, 1, i);
            }
        }
    }

    private void setRankVisible(int i) {
        this.isB.setVisibility(i);
        this.isN.setVisibility(i);
    }

    public void setVoteAdaPter(VoteAdapter voteAdapter) {
        this.ioF = voteAdapter;
    }
}
