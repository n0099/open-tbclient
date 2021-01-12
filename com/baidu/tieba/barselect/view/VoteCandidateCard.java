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
/* loaded from: classes7.dex */
public class VoteCandidateCard extends CardBasicLayout {
    public static int inT = -1;
    private View gde;
    private VoteAdapter ijW;
    private VotedAreaLayout inL;
    private TextView inU;
    private View inV;
    private TextView inW;
    private TextView inX;
    private CandidateInfoLayout inY;
    private NewAnounceLayout inZ;
    private VoteAreaLayout ioa;
    private View iob;
    private TextView ioc;
    private TextView iod;
    private View ioe;
    private View iof;
    private View iog;
    private View ioh;
    private View ioi;
    private TextView ioj;
    private View iok;
    private LinearLayout iol;
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
        tC();
    }

    private void tC() {
        this.inV = findViewById(R.id.mine_vote_content);
        this.inW = (TextView) findViewById(R.id.mine_vote_title);
        this.inX = (TextView) findViewById(R.id.mine_vote_num);
        this.inU = (TextView) findViewById(R.id.tv_voted_rank);
        this.inY = (CandidateInfoLayout) findViewById(R.id.candidate_info_layout);
        this.inZ = (NewAnounceLayout) findViewById(R.id.announce_layout);
        this.ioa = (VoteAreaLayout) findViewById(R.id.vote_area_layout);
        this.inL = (VotedAreaLayout) findViewById(R.id.voted_area_layout);
        this.gde = findViewById(R.id.divider_line);
        this.ioe = findViewById(R.id.divider_empty_view);
        this.iof = findViewById(R.id.divider_line_container);
        this.iog = findViewById(R.id.empty_view);
        this.ioh = findViewById(R.id.main_container);
        this.ioi = findViewById(R.id.info_container);
        this.iob = findViewById(R.id.vote_ueg_warn_container);
        this.ioc = (TextView) findViewById(R.id.vote_ueg_warn_img);
        this.iod = (TextView) findViewById(R.id.vote_ueg_warn_tv);
        this.iok = findViewById(R.id.divider_top_line);
        this.ioj = (TextView) findViewById(R.id.title_notpass_tv);
        this.iol = (LinearLayout) findViewById(R.id.not_allow_view);
    }

    @Override // com.baidu.tieba.barselect.segment.CardBasicLayout
    public void setData(int i, f fVar) {
        super.setData(i, fVar);
        this.position = i;
        if (this.ijz == null || this.inn == null || this.status < 0) {
            setVisibility(8);
            return;
        }
        if (this.status == com.baidu.tieba.barselect.a.a.inE) {
            this.ioh.setBackgroundResource(R.drawable.bar_select_bg_shadow_and_radius);
            this.inV.setVisibility(0);
            this.inX.setText("当前排名" + this.inn.getRank());
            setRankVisible(8);
            this.iof.setVisibility(8);
            this.ioa.setVisibility(0);
            this.inL.setVisibility(8);
            this.ioa.setData(i, fVar);
            this.iol.setVisibility(8);
        } else if (this.status == com.baidu.tieba.barselect.a.a.inB) {
            if (i == 0) {
                this.iof.setVisibility(8);
            } else {
                this.iof.setVisibility(8);
                this.ioe.setVisibility(8);
            }
            this.ioh.setBackgroundColor(getResources().getColor(R.color.CAM_X0201));
            this.inV.setVisibility(8);
            setRankVisible(8);
            if (this.inn.cpV() == 2 && this.ijW.cpO() == -1) {
                this.ijW.wz(i);
            }
            if (this.inn.cpV() == 2) {
                if (this.ijW != null && this.ijW.cpO() == i) {
                    this.iol.setVisibility(0);
                } else {
                    this.iol.setVisibility(8);
                }
                this.ioa.setVisibility(8);
            } else {
                this.iol.setVisibility(8);
                this.ioa.setVisibility(0);
                this.ioa.setData(i, fVar);
            }
            this.inL.setVisibility(8);
        } else if (this.status == com.baidu.tieba.barselect.a.a.inD) {
            int dimens = l.getDimens(getContext(), R.dimen.tbds22);
            int dimens2 = l.getDimens(getContext(), R.dimen.tbds10);
            int dimens3 = l.getDimens(getContext(), R.dimen.tbds20);
            int dimens4 = l.getDimens(getContext(), R.dimen.tbds30);
            this.ioh.setBackgroundResource(R.drawable.bg_bazhu_shadow_and_radius);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.setMargins(dimens4, 0, dimens4, dimens3);
            this.ioh.setLayoutParams(layoutParams);
            this.ioh.setPadding(dimens2, 0, dimens2, dimens4);
            this.inV.setVisibility(8);
            this.iof.setVisibility(8);
            setRankVisible(8);
            this.ioa.setVisibility(8);
            this.inL.setVisibility(0);
            this.inL.setData(i, fVar);
            this.ioi.setPadding(0, dimens, 0, 0);
            this.iol.setVisibility(8);
        } else if (this.status == com.baidu.tieba.barselect.a.a.inC) {
            if (i == 1) {
                this.ioh.setBackgroundResource(R.drawable.bar_select_bg_top_round);
                this.iof.setVisibility(8);
            } else {
                this.ioh.setBackgroundColor(getResources().getColor(R.color.CAM_X0201));
                this.iof.setVisibility(0);
                this.ioe.setVisibility(0);
            }
            setRankVisible(0);
            this.inV.setVisibility(8);
            int rank = this.inn.getRank();
            if (rank < 10) {
                this.inU.setText("0" + rank);
            } else {
                this.inU.setText("" + rank);
            }
            if (rank == 2) {
                this.inU.setTextColor(getResources().getColor(R.color.common_color_10263));
            } else if (rank == 3) {
                this.inU.setTextColor(getResources().getColor(R.color.common_color_10266));
            } else {
                this.inU.setTextColor(getResources().getColor(R.color.CAM_X0105));
            }
            this.ioa.setVisibility(8);
            this.inL.setVisibility(0);
            this.inL.setData(i, fVar);
            this.iol.setVisibility(8);
        } else {
            setVisibility(8);
            return;
        }
        this.inY.setData(i, fVar);
        this.inZ.setData(i, fVar);
        if (this.inn.cpU()) {
            this.iob.setVisibility(0);
        } else {
            this.iob.setVisibility(8);
        }
        uo(TbadkCoreApplication.getInst().getSkinType());
    }

    public void uo(int i) {
        this.inZ.uo(i);
        this.inY.uo(i);
        if (this.inL.getVisibility() == 0) {
            this.inL.uo(i);
        }
        this.ioa.uo(i);
        ao.setBackgroundColor(this.gde, R.color.CAM_X0204, i);
        if (this.status == com.baidu.tieba.barselect.a.a.inE) {
            ao.setBackgroundResource(this.ioh, R.drawable.bar_select_bg_shadow_and_radius, i);
            ao.setViewTextColor(this.inX, R.color.CAM_X0105, 1, i);
            ao.setViewTextColor(this.inW, R.color.CAM_X0105, 1, i);
        } else if (this.status == com.baidu.tieba.barselect.a.a.inD) {
            ao.setBackgroundResource(this.ioh, R.drawable.bg_bazhu_shadow_and_radius, i);
        } else if (this.status == com.baidu.tieba.barselect.a.a.inC) {
            if (this.position == 1) {
                ao.setBackgroundResource(this.ioh, R.drawable.bar_select_bg_top_round, i);
            } else {
                ao.setBackgroundColor(this.ioh, R.color.CAM_X0201, i);
            }
        } else if (this.status == com.baidu.tieba.barselect.a.a.inB) {
            ao.setBackgroundColor(this.ioh, R.color.CAM_X0201, i);
            ao.setViewTextColor(this.ioj, R.color.CAM_X0105, 1, i);
            ao.setBackgroundColor(this.iol, R.color.CAM_X0201, i);
            ao.setBackgroundColor(this.iok, R.color.CAM_X0203, i);
        }
        if (this.inn != null) {
            if (this.inn.cpU()) {
                ao.setViewTextColor(this.iod, R.color.CAM_X0301, 1, i);
                ao.setBackgroundResource(this.ioc, R.drawable.icon_use_tip_red, i);
            }
            int rank = this.inn.getRank();
            if (rank == 2) {
                ao.setViewTextColor(this.inU, R.color.CAM_X0305, 1, i);
            } else if (rank == 3) {
                ao.setViewTextColor(this.inU, R.color.CAM_X0312, 1, i);
            } else {
                ao.setViewTextColor(this.inU, R.color.CAM_X0105, 1, i);
            }
        }
    }

    private void setRankVisible(int i) {
        this.inU.setVisibility(i);
        this.iog.setVisibility(i);
    }

    public void setVoteAdaPter(VoteAdapter voteAdapter) {
        this.ijW = voteAdapter;
    }
}
