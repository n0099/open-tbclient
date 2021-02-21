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
    public static int itL = -1;
    private View gfy;
    private VoteAdapter ipS;
    private VotedAreaLayout itD;
    private TextView itM;
    private View itN;
    private TextView itO;
    private TextView itP;
    private CandidateInfoLayout itQ;
    private NewAnounceLayout itR;
    private VoteAreaLayout itS;
    private View itT;
    private TextView itU;
    private TextView itV;
    private View itW;
    private View itX;
    private View itY;
    private View itZ;
    private View iua;
    private TextView iub;
    private View iuc;
    private LinearLayout iud;
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
        this.itN = findViewById(R.id.mine_vote_content);
        this.itO = (TextView) findViewById(R.id.mine_vote_title);
        this.itP = (TextView) findViewById(R.id.mine_vote_num);
        this.itM = (TextView) findViewById(R.id.tv_voted_rank);
        this.itQ = (CandidateInfoLayout) findViewById(R.id.candidate_info_layout);
        this.itR = (NewAnounceLayout) findViewById(R.id.announce_layout);
        this.itS = (VoteAreaLayout) findViewById(R.id.vote_area_layout);
        this.itD = (VotedAreaLayout) findViewById(R.id.voted_area_layout);
        this.gfy = findViewById(R.id.divider_line);
        this.itW = findViewById(R.id.divider_empty_view);
        this.itX = findViewById(R.id.divider_line_container);
        this.itY = findViewById(R.id.empty_view);
        this.itZ = findViewById(R.id.main_container);
        this.iua = findViewById(R.id.info_container);
        this.itT = findViewById(R.id.vote_ueg_warn_container);
        this.itU = (TextView) findViewById(R.id.vote_ueg_warn_img);
        this.itV = (TextView) findViewById(R.id.vote_ueg_warn_tv);
        this.iuc = findViewById(R.id.divider_top_line);
        this.iub = (TextView) findViewById(R.id.title_notpass_tv);
        this.iud = (LinearLayout) findViewById(R.id.not_allow_view);
    }

    @Override // com.baidu.tieba.barselect.segment.CardBasicLayout
    public void setData(int i, f fVar) {
        super.setData(i, fVar);
        this.position = i;
        if (this.ipv == null || this.itg == null || this.status < 0) {
            setVisibility(8);
            return;
        }
        if (this.status == com.baidu.tieba.barselect.a.a.itw) {
            this.itZ.setBackgroundResource(R.drawable.bar_select_bg_shadow_and_radius);
            this.itN.setVisibility(0);
            this.itP.setText("当前排名" + this.itg.getRank());
            setRankVisible(8);
            this.itX.setVisibility(8);
            this.itS.setVisibility(0);
            this.itD.setVisibility(8);
            this.itS.setData(i, fVar);
            this.iud.setVisibility(8);
        } else if (this.status == com.baidu.tieba.barselect.a.a.itt) {
            if (i == 0) {
                this.itX.setVisibility(8);
            } else {
                this.itX.setVisibility(8);
                this.itW.setVisibility(8);
            }
            this.itZ.setBackgroundColor(getResources().getColor(R.color.CAM_X0201));
            this.itN.setVisibility(8);
            setRankVisible(8);
            if (this.itg.crm() == 2 && this.ipS.crf() == -1) {
                this.ipS.wK(i);
            }
            if (this.itg.crm() == 2) {
                if (this.ipS != null && this.ipS.crf() == i) {
                    this.iud.setVisibility(0);
                } else {
                    this.iud.setVisibility(8);
                }
                this.itS.setVisibility(8);
            } else {
                this.iud.setVisibility(8);
                this.itS.setVisibility(0);
                this.itS.setData(i, fVar);
            }
            this.itD.setVisibility(8);
        } else if (this.status == com.baidu.tieba.barselect.a.a.itv) {
            int dimens = l.getDimens(getContext(), R.dimen.tbds22);
            int dimens2 = l.getDimens(getContext(), R.dimen.tbds10);
            int dimens3 = l.getDimens(getContext(), R.dimen.tbds20);
            int dimens4 = l.getDimens(getContext(), R.dimen.tbds30);
            this.itZ.setBackgroundResource(R.drawable.bg_bazhu_shadow_and_radius);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.setMargins(dimens4, 0, dimens4, dimens3);
            this.itZ.setLayoutParams(layoutParams);
            this.itZ.setPadding(dimens2, 0, dimens2, dimens4);
            this.itN.setVisibility(8);
            this.itX.setVisibility(8);
            setRankVisible(8);
            this.itS.setVisibility(8);
            this.itD.setVisibility(0);
            this.itD.setData(i, fVar);
            this.iua.setPadding(0, dimens, 0, 0);
            this.iud.setVisibility(8);
        } else if (this.status == com.baidu.tieba.barselect.a.a.itu) {
            if (i == 1) {
                this.itZ.setBackgroundResource(R.drawable.bar_select_bg_top_round);
                this.itX.setVisibility(8);
            } else {
                this.itZ.setBackgroundColor(getResources().getColor(R.color.CAM_X0201));
                this.itX.setVisibility(0);
                this.itW.setVisibility(0);
            }
            setRankVisible(0);
            this.itN.setVisibility(8);
            int rank = this.itg.getRank();
            if (rank < 10) {
                this.itM.setText("0" + rank);
            } else {
                this.itM.setText("" + rank);
            }
            if (rank == 2) {
                this.itM.setTextColor(getResources().getColor(R.color.common_color_10263));
            } else if (rank == 3) {
                this.itM.setTextColor(getResources().getColor(R.color.common_color_10266));
            } else {
                this.itM.setTextColor(getResources().getColor(R.color.CAM_X0105));
            }
            this.itS.setVisibility(8);
            this.itD.setVisibility(0);
            this.itD.setData(i, fVar);
            this.iud.setVisibility(8);
        } else {
            setVisibility(8);
            return;
        }
        this.itQ.setData(i, fVar);
        this.itR.setData(i, fVar);
        if (this.itg.crl()) {
            this.itT.setVisibility(0);
        } else {
            this.itT.setVisibility(8);
        }
        uu(TbadkCoreApplication.getInst().getSkinType());
    }

    public void uu(int i) {
        this.itR.uu(i);
        this.itQ.uu(i);
        if (this.itD.getVisibility() == 0) {
            this.itD.uu(i);
        }
        this.itS.uu(i);
        ap.setBackgroundColor(this.gfy, R.color.CAM_X0204, i);
        if (this.status == com.baidu.tieba.barselect.a.a.itw) {
            ap.setBackgroundResource(this.itZ, R.drawable.bar_select_bg_shadow_and_radius, i);
            ap.setViewTextColor(this.itP, R.color.CAM_X0105, 1, i);
            ap.setViewTextColor(this.itO, R.color.CAM_X0105, 1, i);
        } else if (this.status == com.baidu.tieba.barselect.a.a.itv) {
            ap.setBackgroundResource(this.itZ, R.drawable.bg_bazhu_shadow_and_radius, i);
        } else if (this.status == com.baidu.tieba.barselect.a.a.itu) {
            if (this.position == 1) {
                ap.setBackgroundResource(this.itZ, R.drawable.bar_select_bg_top_round, i);
            } else {
                ap.setBackgroundColor(this.itZ, R.color.CAM_X0201, i);
            }
        } else if (this.status == com.baidu.tieba.barselect.a.a.itt) {
            ap.setBackgroundColor(this.itZ, R.color.CAM_X0201, i);
            ap.setViewTextColor(this.iub, R.color.CAM_X0105, 1, i);
            ap.setBackgroundColor(this.iud, R.color.CAM_X0201, i);
            ap.setBackgroundColor(this.iuc, R.color.CAM_X0203, i);
        }
        if (this.itg != null) {
            if (this.itg.crl()) {
                ap.setViewTextColor(this.itV, R.color.CAM_X0301, 1, i);
                ap.setBackgroundResource(this.itU, R.drawable.icon_use_tip_red, i);
            }
            int rank = this.itg.getRank();
            if (rank == 2) {
                ap.setViewTextColor(this.itM, R.color.CAM_X0305, 1, i);
            } else if (rank == 3) {
                ap.setViewTextColor(this.itM, R.color.CAM_X0312, 1, i);
            } else {
                ap.setViewTextColor(this.itM, R.color.CAM_X0105, 1, i);
            }
        }
    }

    private void setRankVisible(int i) {
        this.itM.setVisibility(i);
        this.itY.setVisibility(i);
    }

    public void setVoteAdaPter(VoteAdapter voteAdapter) {
        this.ipS = voteAdapter;
    }
}
