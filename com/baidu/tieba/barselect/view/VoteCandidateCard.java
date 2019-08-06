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
    public static int ezn = -1;
    private View cUD;
    private View ezA;
    private View ezB;
    private View ezC;
    private VotedAreaLayout ezi;
    private TextView ezo;
    private View ezp;
    private TextView ezq;
    private TextView ezr;
    private CandidateInfoLayout ezs;
    private NewAnounceLayout ezt;
    private VoteAreaLayout ezu;
    private View ezv;
    private TextView ezw;
    private TextView ezx;
    private View ezy;
    private View ezz;
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
        this.ezp = findViewById(R.id.mine_vote_content);
        this.ezq = (TextView) findViewById(R.id.mine_vote_title);
        this.ezr = (TextView) findViewById(R.id.mine_vote_num);
        this.ezo = (TextView) findViewById(R.id.tv_voted_rank);
        this.ezs = (CandidateInfoLayout) findViewById(R.id.candidate_info_layout);
        this.ezt = (NewAnounceLayout) findViewById(R.id.announce_layout);
        this.ezu = (VoteAreaLayout) findViewById(R.id.vote_area_layout);
        this.ezi = (VotedAreaLayout) findViewById(R.id.voted_area_layout);
        this.cUD = findViewById(R.id.divider_line);
        this.ezy = findViewById(R.id.divider_empty_view);
        this.ezz = findViewById(R.id.divider_line_container);
        this.ezA = findViewById(R.id.empty_view);
        this.ezB = findViewById(R.id.main_container);
        this.ezC = findViewById(R.id.info_container);
        this.ezv = findViewById(R.id.vote_ueg_warn_container);
        this.ezw = (TextView) findViewById(R.id.vote_ueg_warn_img);
        this.ezx = (TextView) findViewById(R.id.vote_ueg_warn_tv);
    }

    @Override // com.baidu.tieba.barselect.segment.CardBasicLayout
    public void setData(int i, f fVar) {
        super.setData(i, fVar);
        this.position = i;
        if (this.euT == null || this.eyK == null || this.status < 0) {
            setVisibility(8);
            return;
        }
        if (this.status == com.baidu.tieba.barselect.a.a.ezb) {
            this.ezB.setBackgroundResource(R.drawable.bar_select_bg_shadow_and_radius);
            this.ezp.setVisibility(0);
            this.ezr.setText("当前排名" + this.eyK.getRank());
            setRankVisible(8);
            this.ezz.setVisibility(8);
            this.ezu.setVisibility(0);
            this.ezi.setVisibility(8);
            this.ezu.setData(i, fVar);
        } else if (this.status == com.baidu.tieba.barselect.a.a.eyY) {
            if (i == 0) {
                this.ezz.setVisibility(8);
            } else {
                this.ezz.setVisibility(8);
                this.ezy.setVisibility(8);
            }
            this.ezB.setBackgroundColor(getResources().getColor(R.color.cp_bg_line_d));
            this.ezp.setVisibility(8);
            setRankVisible(8);
            this.ezu.setVisibility(0);
            this.ezi.setVisibility(8);
            this.ezu.setData(i, fVar);
        } else if (this.status == com.baidu.tieba.barselect.a.a.eza) {
            int g = l.g(getContext(), R.dimen.tbds22);
            int g2 = l.g(getContext(), R.dimen.tbds10);
            int g3 = l.g(getContext(), R.dimen.tbds20);
            int g4 = l.g(getContext(), R.dimen.tbds30);
            this.ezB.setBackgroundResource(R.drawable.bg_bazhu_shadow_and_radius);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.setMargins(g4, 0, g4, g3);
            this.ezB.setLayoutParams(layoutParams);
            this.ezB.setPadding(g2, 0, g2, g4);
            this.ezp.setVisibility(8);
            this.ezz.setVisibility(8);
            setRankVisible(8);
            this.ezu.setVisibility(8);
            this.ezi.setVisibility(0);
            this.ezi.setData(i, fVar);
            this.ezC.setPadding(0, g, 0, 0);
        } else if (this.status == com.baidu.tieba.barselect.a.a.eyZ) {
            if (i == 1) {
                this.ezB.setBackgroundResource(R.drawable.bar_select_bg_top_round);
                this.ezz.setVisibility(8);
            } else {
                this.ezB.setBackgroundColor(getResources().getColor(R.color.cp_bg_line_d));
                this.ezz.setVisibility(0);
                this.ezy.setVisibility(0);
            }
            setRankVisible(0);
            this.ezp.setVisibility(8);
            int rank = this.eyK.getRank();
            if (rank < 10) {
                this.ezo.setText("0" + rank);
            } else {
                this.ezo.setText("" + rank);
            }
            if (rank == 2) {
                this.ezo.setTextColor(getResources().getColor(R.color.common_color_10263));
            } else if (rank == 3) {
                this.ezo.setTextColor(getResources().getColor(R.color.common_color_10266));
            } else {
                this.ezo.setTextColor(getResources().getColor(R.color.cp_cont_b));
            }
            this.ezu.setVisibility(8);
            this.ezi.setVisibility(0);
            this.ezi.setData(i, fVar);
        } else {
            setVisibility(8);
            return;
        }
        this.ezs.setData(i, fVar);
        this.ezt.setData(i, fVar);
        if (this.eyK.aYH()) {
            this.ezv.setVisibility(0);
        } else {
            this.ezv.setVisibility(8);
        }
        nA(TbadkCoreApplication.getInst().getSkinType());
    }

    public void nA(int i) {
        this.ezt.nA(i);
        this.ezs.nA(i);
        if (this.ezi.getVisibility() == 0) {
            this.ezi.nA(i);
        }
        this.ezu.nA(i);
        am.h(this.cUD, R.color.cp_bg_line_c, i);
        if (this.status == com.baidu.tieba.barselect.a.a.ezb) {
            am.g(this.ezB, R.drawable.bar_select_bg_shadow_and_radius, i);
            am.d(this.ezr, R.color.cp_cont_b, 1, i);
            am.d(this.ezq, R.color.cp_cont_b, 1, i);
        } else if (this.status == com.baidu.tieba.barselect.a.a.eza) {
            am.g(this.ezB, R.drawable.bg_bazhu_shadow_and_radius, i);
        } else if (this.status == com.baidu.tieba.barselect.a.a.eyZ) {
            if (this.position == 1) {
                am.g(this.ezB, R.drawable.bar_select_bg_top_round, i);
            } else {
                am.h(this.ezB, R.color.cp_bg_line_d, i);
            }
        } else if (this.status == com.baidu.tieba.barselect.a.a.eyY) {
            am.h(this.ezB, R.color.cp_bg_line_d, i);
        }
        if (this.eyK != null) {
            if (this.eyK.aYH()) {
                am.d(this.ezx, R.color.cp_cont_h, 1, i);
                am.g(this.ezw, R.drawable.icon_use_tip_red, i);
            }
            int rank = this.eyK.getRank();
            if (rank == 2) {
                am.d(this.ezo, R.color.cp_link_tip_d, 1, i);
            } else if (rank == 3) {
                am.d(this.ezo, R.color.cp_other_f, 1, i);
            } else {
                am.d(this.ezo, R.color.cp_cont_b, 1, i);
            }
        }
    }

    private void setRankVisible(int i) {
        this.ezo.setVisibility(i);
        this.ezA.setVisibility(i);
    }
}
