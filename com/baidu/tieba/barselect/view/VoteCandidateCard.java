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
    public static int ezg = -1;
    private View cUw;
    private VotedAreaLayout ezb;
    private TextView ezh;
    private View ezi;
    private TextView ezj;
    private TextView ezk;
    private CandidateInfoLayout ezl;
    private NewAnounceLayout ezm;
    private VoteAreaLayout ezn;
    private View ezo;
    private TextView ezp;
    private TextView ezq;
    private View ezr;
    private View ezs;
    private View ezt;
    private View ezu;
    private View ezv;
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
        qX();
    }

    private void qX() {
        this.ezi = findViewById(R.id.mine_vote_content);
        this.ezj = (TextView) findViewById(R.id.mine_vote_title);
        this.ezk = (TextView) findViewById(R.id.mine_vote_num);
        this.ezh = (TextView) findViewById(R.id.tv_voted_rank);
        this.ezl = (CandidateInfoLayout) findViewById(R.id.candidate_info_layout);
        this.ezm = (NewAnounceLayout) findViewById(R.id.announce_layout);
        this.ezn = (VoteAreaLayout) findViewById(R.id.vote_area_layout);
        this.ezb = (VotedAreaLayout) findViewById(R.id.voted_area_layout);
        this.cUw = findViewById(R.id.divider_line);
        this.ezr = findViewById(R.id.divider_empty_view);
        this.ezs = findViewById(R.id.divider_line_container);
        this.ezt = findViewById(R.id.empty_view);
        this.ezu = findViewById(R.id.main_container);
        this.ezv = findViewById(R.id.info_container);
        this.ezo = findViewById(R.id.vote_ueg_warn_container);
        this.ezp = (TextView) findViewById(R.id.vote_ueg_warn_img);
        this.ezq = (TextView) findViewById(R.id.vote_ueg_warn_tv);
    }

    @Override // com.baidu.tieba.barselect.segment.CardBasicLayout
    public void setData(int i, f fVar) {
        super.setData(i, fVar);
        this.position = i;
        if (this.euM == null || this.eyD == null || this.status < 0) {
            setVisibility(8);
            return;
        }
        if (this.status == com.baidu.tieba.barselect.a.a.eyU) {
            this.ezu.setBackgroundResource(R.drawable.bar_select_bg_shadow_and_radius);
            this.ezi.setVisibility(0);
            this.ezk.setText("当前排名" + this.eyD.getRank());
            setRankVisible(8);
            this.ezs.setVisibility(8);
            this.ezn.setVisibility(0);
            this.ezb.setVisibility(8);
            this.ezn.setData(i, fVar);
        } else if (this.status == com.baidu.tieba.barselect.a.a.eyR) {
            if (i == 0) {
                this.ezs.setVisibility(8);
            } else {
                this.ezs.setVisibility(8);
                this.ezr.setVisibility(8);
            }
            this.ezu.setBackgroundColor(getResources().getColor(R.color.cp_bg_line_d));
            this.ezi.setVisibility(8);
            setRankVisible(8);
            this.ezn.setVisibility(0);
            this.ezb.setVisibility(8);
            this.ezn.setData(i, fVar);
        } else if (this.status == com.baidu.tieba.barselect.a.a.eyT) {
            int g = l.g(getContext(), R.dimen.tbds22);
            int g2 = l.g(getContext(), R.dimen.tbds10);
            int g3 = l.g(getContext(), R.dimen.tbds20);
            int g4 = l.g(getContext(), R.dimen.tbds30);
            this.ezu.setBackgroundResource(R.drawable.bg_bazhu_shadow_and_radius);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.setMargins(g4, 0, g4, g3);
            this.ezu.setLayoutParams(layoutParams);
            this.ezu.setPadding(g2, 0, g2, g4);
            this.ezi.setVisibility(8);
            this.ezs.setVisibility(8);
            setRankVisible(8);
            this.ezn.setVisibility(8);
            this.ezb.setVisibility(0);
            this.ezb.setData(i, fVar);
            this.ezv.setPadding(0, g, 0, 0);
        } else if (this.status == com.baidu.tieba.barselect.a.a.eyS) {
            if (i == 1) {
                this.ezu.setBackgroundResource(R.drawable.bar_select_bg_top_round);
                this.ezs.setVisibility(8);
            } else {
                this.ezu.setBackgroundColor(getResources().getColor(R.color.cp_bg_line_d));
                this.ezs.setVisibility(0);
                this.ezr.setVisibility(0);
            }
            setRankVisible(0);
            this.ezi.setVisibility(8);
            int rank = this.eyD.getRank();
            if (rank < 10) {
                this.ezh.setText("0" + rank);
            } else {
                this.ezh.setText("" + rank);
            }
            if (rank == 2) {
                this.ezh.setTextColor(getResources().getColor(R.color.common_color_10263));
            } else if (rank == 3) {
                this.ezh.setTextColor(getResources().getColor(R.color.common_color_10266));
            } else {
                this.ezh.setTextColor(getResources().getColor(R.color.cp_cont_b));
            }
            this.ezn.setVisibility(8);
            this.ezb.setVisibility(0);
            this.ezb.setData(i, fVar);
        } else {
            setVisibility(8);
            return;
        }
        this.ezl.setData(i, fVar);
        this.ezm.setData(i, fVar);
        if (this.eyD.aYF()) {
            this.ezo.setVisibility(0);
        } else {
            this.ezo.setVisibility(8);
        }
        nz(TbadkCoreApplication.getInst().getSkinType());
    }

    public void nz(int i) {
        this.ezm.nz(i);
        this.ezl.nz(i);
        if (this.ezb.getVisibility() == 0) {
            this.ezb.nz(i);
        }
        this.ezn.nz(i);
        am.h(this.cUw, R.color.cp_bg_line_c, i);
        if (this.status == com.baidu.tieba.barselect.a.a.eyU) {
            am.g(this.ezu, R.drawable.bar_select_bg_shadow_and_radius, i);
            am.d(this.ezk, R.color.cp_cont_b, 1, i);
            am.d(this.ezj, R.color.cp_cont_b, 1, i);
        } else if (this.status == com.baidu.tieba.barselect.a.a.eyT) {
            am.g(this.ezu, R.drawable.bg_bazhu_shadow_and_radius, i);
        } else if (this.status == com.baidu.tieba.barselect.a.a.eyS) {
            if (this.position == 1) {
                am.g(this.ezu, R.drawable.bar_select_bg_top_round, i);
            } else {
                am.h(this.ezu, R.color.cp_bg_line_d, i);
            }
        } else if (this.status == com.baidu.tieba.barselect.a.a.eyR) {
            am.h(this.ezu, R.color.cp_bg_line_d, i);
        }
        if (this.eyD != null) {
            if (this.eyD.aYF()) {
                am.d(this.ezq, R.color.cp_cont_h, 1, i);
                am.g(this.ezp, R.drawable.icon_use_tip_red, i);
            }
            int rank = this.eyD.getRank();
            if (rank == 2) {
                am.d(this.ezh, R.color.cp_link_tip_d, 1, i);
            } else if (rank == 3) {
                am.d(this.ezh, R.color.cp_other_f, 1, i);
            } else {
                am.d(this.ezh, R.color.cp_cont_b, 1, i);
            }
        }
    }

    private void setRankVisible(int i) {
        this.ezh.setVisibility(i);
        this.ezt.setVisibility(i);
    }
}
