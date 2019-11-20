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
    public static int eIN = -1;
    private View ddZ;
    private VotedAreaLayout eII;
    private TextView eIO;
    private View eIP;
    private TextView eIQ;
    private TextView eIR;
    private CandidateInfoLayout eIS;
    private NewAnounceLayout eIT;
    private VoteAreaLayout eIU;
    private View eIV;
    private TextView eIW;
    private TextView eIX;
    private View eIY;
    private View eIZ;
    private View eJa;
    private View eJb;
    private View eJc;
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
        this.eIP = findViewById(R.id.mine_vote_content);
        this.eIQ = (TextView) findViewById(R.id.mine_vote_title);
        this.eIR = (TextView) findViewById(R.id.mine_vote_num);
        this.eIO = (TextView) findViewById(R.id.tv_voted_rank);
        this.eIS = (CandidateInfoLayout) findViewById(R.id.candidate_info_layout);
        this.eIT = (NewAnounceLayout) findViewById(R.id.announce_layout);
        this.eIU = (VoteAreaLayout) findViewById(R.id.vote_area_layout);
        this.eII = (VotedAreaLayout) findViewById(R.id.voted_area_layout);
        this.ddZ = findViewById(R.id.divider_line);
        this.eIY = findViewById(R.id.divider_empty_view);
        this.eIZ = findViewById(R.id.divider_line_container);
        this.eJa = findViewById(R.id.empty_view);
        this.eJb = findViewById(R.id.main_container);
        this.eJc = findViewById(R.id.info_container);
        this.eIV = findViewById(R.id.vote_ueg_warn_container);
        this.eIW = (TextView) findViewById(R.id.vote_ueg_warn_img);
        this.eIX = (TextView) findViewById(R.id.vote_ueg_warn_tv);
    }

    @Override // com.baidu.tieba.barselect.segment.CardBasicLayout
    public void setData(int i, f fVar) {
        super.setData(i, fVar);
        this.position = i;
        if (this.eEy == null || this.eIk == null || this.status < 0) {
            setVisibility(8);
            return;
        }
        if (this.status == com.baidu.tieba.barselect.a.a.eIB) {
            this.eJb.setBackgroundResource(R.drawable.bar_select_bg_shadow_and_radius);
            this.eIP.setVisibility(0);
            this.eIR.setText("当前排名" + this.eIk.getRank());
            setRankVisible(8);
            this.eIZ.setVisibility(8);
            this.eIU.setVisibility(0);
            this.eII.setVisibility(8);
            this.eIU.setData(i, fVar);
        } else if (this.status == com.baidu.tieba.barselect.a.a.eIy) {
            if (i == 0) {
                this.eIZ.setVisibility(8);
            } else {
                this.eIZ.setVisibility(8);
                this.eIY.setVisibility(8);
            }
            this.eJb.setBackgroundColor(getResources().getColor(R.color.cp_bg_line_d));
            this.eIP.setVisibility(8);
            setRankVisible(8);
            this.eIU.setVisibility(0);
            this.eII.setVisibility(8);
            this.eIU.setData(i, fVar);
        } else if (this.status == com.baidu.tieba.barselect.a.a.eIA) {
            int dimens = l.getDimens(getContext(), R.dimen.tbds22);
            int dimens2 = l.getDimens(getContext(), R.dimen.tbds10);
            int dimens3 = l.getDimens(getContext(), R.dimen.tbds20);
            int dimens4 = l.getDimens(getContext(), R.dimen.tbds30);
            this.eJb.setBackgroundResource(R.drawable.bg_bazhu_shadow_and_radius);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.setMargins(dimens4, 0, dimens4, dimens3);
            this.eJb.setLayoutParams(layoutParams);
            this.eJb.setPadding(dimens2, 0, dimens2, dimens4);
            this.eIP.setVisibility(8);
            this.eIZ.setVisibility(8);
            setRankVisible(8);
            this.eIU.setVisibility(8);
            this.eII.setVisibility(0);
            this.eII.setData(i, fVar);
            this.eJc.setPadding(0, dimens, 0, 0);
        } else if (this.status == com.baidu.tieba.barselect.a.a.eIz) {
            if (i == 1) {
                this.eJb.setBackgroundResource(R.drawable.bar_select_bg_top_round);
                this.eIZ.setVisibility(8);
            } else {
                this.eJb.setBackgroundColor(getResources().getColor(R.color.cp_bg_line_d));
                this.eIZ.setVisibility(0);
                this.eIY.setVisibility(0);
            }
            setRankVisible(0);
            this.eIP.setVisibility(8);
            int rank = this.eIk.getRank();
            if (rank < 10) {
                this.eIO.setText("0" + rank);
            } else {
                this.eIO.setText("" + rank);
            }
            if (rank == 2) {
                this.eIO.setTextColor(getResources().getColor(R.color.common_color_10263));
            } else if (rank == 3) {
                this.eIO.setTextColor(getResources().getColor(R.color.common_color_10266));
            } else {
                this.eIO.setTextColor(getResources().getColor(R.color.cp_cont_b));
            }
            this.eIU.setVisibility(8);
            this.eII.setVisibility(0);
            this.eII.setData(i, fVar);
        } else {
            setVisibility(8);
            return;
        }
        this.eIS.setData(i, fVar);
        this.eIT.setData(i, fVar);
        if (this.eIk.aZm()) {
            this.eIV.setVisibility(0);
        } else {
            this.eIV.setVisibility(8);
        }
        mD(TbadkCoreApplication.getInst().getSkinType());
    }

    public void mD(int i) {
        this.eIT.mD(i);
        this.eIS.mD(i);
        if (this.eII.getVisibility() == 0) {
            this.eII.mD(i);
        }
        this.eIU.mD(i);
        am.setBackgroundColor(this.ddZ, R.color.cp_bg_line_c, i);
        if (this.status == com.baidu.tieba.barselect.a.a.eIB) {
            am.setBackgroundResource(this.eJb, R.drawable.bar_select_bg_shadow_and_radius, i);
            am.setViewTextColor(this.eIR, R.color.cp_cont_b, 1, i);
            am.setViewTextColor(this.eIQ, R.color.cp_cont_b, 1, i);
        } else if (this.status == com.baidu.tieba.barselect.a.a.eIA) {
            am.setBackgroundResource(this.eJb, R.drawable.bg_bazhu_shadow_and_radius, i);
        } else if (this.status == com.baidu.tieba.barselect.a.a.eIz) {
            if (this.position == 1) {
                am.setBackgroundResource(this.eJb, R.drawable.bar_select_bg_top_round, i);
            } else {
                am.setBackgroundColor(this.eJb, R.color.cp_bg_line_d, i);
            }
        } else if (this.status == com.baidu.tieba.barselect.a.a.eIy) {
            am.setBackgroundColor(this.eJb, R.color.cp_bg_line_d, i);
        }
        if (this.eIk != null) {
            if (this.eIk.aZm()) {
                am.setViewTextColor(this.eIX, R.color.cp_cont_h, 1, i);
                am.setBackgroundResource(this.eIW, R.drawable.icon_use_tip_red, i);
            }
            int rank = this.eIk.getRank();
            if (rank == 2) {
                am.setViewTextColor(this.eIO, R.color.cp_link_tip_d, 1, i);
            } else if (rank == 3) {
                am.setViewTextColor(this.eIO, R.color.cp_other_f, 1, i);
            } else {
                am.setViewTextColor(this.eIO, R.color.cp_cont_b, 1, i);
            }
        }
    }

    private void setRankVisible(int i) {
        this.eIO.setVisibility(i);
        this.eJa.setVisibility(i);
    }
}
