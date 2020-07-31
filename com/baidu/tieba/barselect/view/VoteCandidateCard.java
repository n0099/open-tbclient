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
import com.baidu.tieba.barselect.data.f;
import com.baidu.tieba.barselect.segment.CandidateInfoLayout;
import com.baidu.tieba.barselect.segment.CardBasicLayout;
import com.baidu.tieba.barselect.segment.NewAnounceLayout;
import com.baidu.tieba.barselect.segment.VoteAreaLayout;
import com.baidu.tieba.barselect.segment.VotedAreaLayout;
/* loaded from: classes15.dex */
public class VoteCandidateCard extends CardBasicLayout {
    public static int gTv = -1;
    private View fbk;
    private CandidateInfoLayout gTA;
    private NewAnounceLayout gTB;
    private VoteAreaLayout gTC;
    private View gTD;
    private TextView gTE;
    private TextView gTF;
    private View gTG;
    private View gTH;
    private View gTI;
    private View gTJ;
    private View gTK;
    private VotedAreaLayout gTn;
    private TextView gTw;
    private View gTx;
    private TextView gTy;
    private TextView gTz;
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
        ss();
    }

    private void ss() {
        this.gTx = findViewById(R.id.mine_vote_content);
        this.gTy = (TextView) findViewById(R.id.mine_vote_title);
        this.gTz = (TextView) findViewById(R.id.mine_vote_num);
        this.gTw = (TextView) findViewById(R.id.tv_voted_rank);
        this.gTA = (CandidateInfoLayout) findViewById(R.id.candidate_info_layout);
        this.gTB = (NewAnounceLayout) findViewById(R.id.announce_layout);
        this.gTC = (VoteAreaLayout) findViewById(R.id.vote_area_layout);
        this.gTn = (VotedAreaLayout) findViewById(R.id.voted_area_layout);
        this.fbk = findViewById(R.id.divider_line);
        this.gTG = findViewById(R.id.divider_empty_view);
        this.gTH = findViewById(R.id.divider_line_container);
        this.gTI = findViewById(R.id.empty_view);
        this.gTJ = findViewById(R.id.main_container);
        this.gTK = findViewById(R.id.info_container);
        this.gTD = findViewById(R.id.vote_ueg_warn_container);
        this.gTE = (TextView) findViewById(R.id.vote_ueg_warn_img);
        this.gTF = (TextView) findViewById(R.id.vote_ueg_warn_tv);
    }

    @Override // com.baidu.tieba.barselect.segment.CardBasicLayout
    public void setData(int i, f fVar) {
        super.setData(i, fVar);
        this.position = i;
        if (this.gPf == null || this.gSQ == null || this.status < 0) {
            setVisibility(8);
            return;
        }
        if (this.status == com.baidu.tieba.barselect.a.a.gTg) {
            this.gTJ.setBackgroundResource(R.drawable.bar_select_bg_shadow_and_radius);
            this.gTx.setVisibility(0);
            this.gTz.setText("当前排名" + this.gSQ.getRank());
            setRankVisible(8);
            this.gTH.setVisibility(8);
            this.gTC.setVisibility(0);
            this.gTn.setVisibility(8);
            this.gTC.setData(i, fVar);
        } else if (this.status == com.baidu.tieba.barselect.a.a.gTd) {
            if (i == 0) {
                this.gTH.setVisibility(8);
            } else {
                this.gTH.setVisibility(8);
                this.gTG.setVisibility(8);
            }
            this.gTJ.setBackgroundColor(getResources().getColor(R.color.cp_bg_line_d));
            this.gTx.setVisibility(8);
            setRankVisible(8);
            this.gTC.setVisibility(0);
            this.gTn.setVisibility(8);
            this.gTC.setData(i, fVar);
        } else if (this.status == com.baidu.tieba.barselect.a.a.gTf) {
            int dimens = l.getDimens(getContext(), R.dimen.tbds22);
            int dimens2 = l.getDimens(getContext(), R.dimen.tbds10);
            int dimens3 = l.getDimens(getContext(), R.dimen.tbds20);
            int dimens4 = l.getDimens(getContext(), R.dimen.tbds30);
            this.gTJ.setBackgroundResource(R.drawable.bg_bazhu_shadow_and_radius);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.setMargins(dimens4, 0, dimens4, dimens3);
            this.gTJ.setLayoutParams(layoutParams);
            this.gTJ.setPadding(dimens2, 0, dimens2, dimens4);
            this.gTx.setVisibility(8);
            this.gTH.setVisibility(8);
            setRankVisible(8);
            this.gTC.setVisibility(8);
            this.gTn.setVisibility(0);
            this.gTn.setData(i, fVar);
            this.gTK.setPadding(0, dimens, 0, 0);
        } else if (this.status == com.baidu.tieba.barselect.a.a.gTe) {
            if (i == 1) {
                this.gTJ.setBackgroundResource(R.drawable.bar_select_bg_top_round);
                this.gTH.setVisibility(8);
            } else {
                this.gTJ.setBackgroundColor(getResources().getColor(R.color.cp_bg_line_d));
                this.gTH.setVisibility(0);
                this.gTG.setVisibility(0);
            }
            setRankVisible(0);
            this.gTx.setVisibility(8);
            int rank = this.gSQ.getRank();
            if (rank < 10) {
                this.gTw.setText("0" + rank);
            } else {
                this.gTw.setText("" + rank);
            }
            if (rank == 2) {
                this.gTw.setTextColor(getResources().getColor(R.color.common_color_10263));
            } else if (rank == 3) {
                this.gTw.setTextColor(getResources().getColor(R.color.common_color_10266));
            } else {
                this.gTw.setTextColor(getResources().getColor(R.color.cp_cont_b));
            }
            this.gTC.setVisibility(8);
            this.gTn.setVisibility(0);
            this.gTn.setData(i, fVar);
        } else {
            setVisibility(8);
            return;
        }
        this.gTA.setData(i, fVar);
        this.gTB.setData(i, fVar);
        if (this.gSQ.bQy()) {
            this.gTD.setVisibility(0);
        } else {
            this.gTD.setVisibility(8);
        }
        qZ(TbadkCoreApplication.getInst().getSkinType());
    }

    public void qZ(int i) {
        this.gTB.qZ(i);
        this.gTA.qZ(i);
        if (this.gTn.getVisibility() == 0) {
            this.gTn.qZ(i);
        }
        this.gTC.qZ(i);
        ao.setBackgroundColor(this.fbk, R.color.cp_bg_line_c, i);
        if (this.status == com.baidu.tieba.barselect.a.a.gTg) {
            ao.setBackgroundResource(this.gTJ, R.drawable.bar_select_bg_shadow_and_radius, i);
            ao.setViewTextColor(this.gTz, R.color.cp_cont_b, 1, i);
            ao.setViewTextColor(this.gTy, R.color.cp_cont_b, 1, i);
        } else if (this.status == com.baidu.tieba.barselect.a.a.gTf) {
            ao.setBackgroundResource(this.gTJ, R.drawable.bg_bazhu_shadow_and_radius, i);
        } else if (this.status == com.baidu.tieba.barselect.a.a.gTe) {
            if (this.position == 1) {
                ao.setBackgroundResource(this.gTJ, R.drawable.bar_select_bg_top_round, i);
            } else {
                ao.setBackgroundColor(this.gTJ, R.color.cp_bg_line_d, i);
            }
        } else if (this.status == com.baidu.tieba.barselect.a.a.gTd) {
            ao.setBackgroundColor(this.gTJ, R.color.cp_bg_line_d, i);
        }
        if (this.gSQ != null) {
            if (this.gSQ.bQy()) {
                ao.setViewTextColor(this.gTF, R.color.cp_cont_h, 1, i);
                ao.setBackgroundResource(this.gTE, R.drawable.icon_use_tip_red, i);
            }
            int rank = this.gSQ.getRank();
            if (rank == 2) {
                ao.setViewTextColor(this.gTw, R.color.cp_link_tip_d, 1, i);
            } else if (rank == 3) {
                ao.setViewTextColor(this.gTw, R.color.cp_other_f, 1, i);
            } else {
                ao.setViewTextColor(this.gTw, R.color.cp_cont_b, 1, i);
            }
        }
    }

    private void setRankVisible(int i) {
        this.gTw.setVisibility(i);
        this.gTI.setVisibility(i);
    }
}
