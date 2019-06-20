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
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.R;
import com.baidu.tieba.barselect.data.f;
import com.baidu.tieba.barselect.segment.CandidateInfoLayout;
import com.baidu.tieba.barselect.segment.CardBasicLayout;
import com.baidu.tieba.barselect.segment.NewAnounceLayout;
import com.baidu.tieba.barselect.segment.VoteAreaLayout;
import com.baidu.tieba.barselect.segment.VotedAreaLayout;
/* loaded from: classes3.dex */
public class VoteCandidateCard extends CardBasicLayout {
    public static int euh = -1;
    private View cTa;
    private VotedAreaLayout euc;
    private TextView eui;
    private View euj;
    private TextView euk;
    private TextView eul;
    private CandidateInfoLayout eum;
    private NewAnounceLayout eun;
    private VoteAreaLayout euo;
    private View eup;
    private TextView euq;
    private TextView eur;
    private View eus;
    private View eut;
    private View euu;
    private View euv;
    private View euw;
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
        qA();
    }

    private void qA() {
        this.euj = findViewById(R.id.mine_vote_content);
        this.euk = (TextView) findViewById(R.id.mine_vote_title);
        this.eul = (TextView) findViewById(R.id.mine_vote_num);
        this.eui = (TextView) findViewById(R.id.tv_voted_rank);
        this.eum = (CandidateInfoLayout) findViewById(R.id.candidate_info_layout);
        this.eun = (NewAnounceLayout) findViewById(R.id.announce_layout);
        this.euo = (VoteAreaLayout) findViewById(R.id.vote_area_layout);
        this.euc = (VotedAreaLayout) findViewById(R.id.voted_area_layout);
        this.cTa = findViewById(R.id.divider_line);
        this.eus = findViewById(R.id.divider_empty_view);
        this.eut = findViewById(R.id.divider_line_container);
        this.euu = findViewById(R.id.empty_view);
        this.euv = findViewById(R.id.main_container);
        this.euw = findViewById(R.id.info_container);
        this.eup = findViewById(R.id.vote_ueg_warn_container);
        this.euq = (TextView) findViewById(R.id.vote_ueg_warn_img);
        this.eur = (TextView) findViewById(R.id.vote_ueg_warn_tv);
    }

    @Override // com.baidu.tieba.barselect.segment.CardBasicLayout
    public void setData(int i, f fVar) {
        super.setData(i, fVar);
        this.position = i;
        if (this.epO == null || this.etE == null || this.status < 0) {
            setVisibility(8);
            return;
        }
        if (this.status == com.baidu.tieba.barselect.a.a.etV) {
            this.euv.setBackgroundResource(R.drawable.bar_select_bg_shadow_and_radius);
            this.euj.setVisibility(0);
            this.eul.setText("当前排名" + this.etE.getRank());
            setRankVisible(8);
            this.eut.setVisibility(8);
            this.euo.setVisibility(0);
            this.euc.setVisibility(8);
            this.euo.setData(i, fVar);
        } else if (this.status == com.baidu.tieba.barselect.a.a.etS) {
            if (i == 0) {
                this.eut.setVisibility(8);
            } else {
                this.eut.setVisibility(8);
                this.eus.setVisibility(8);
            }
            this.euv.setBackgroundColor(getResources().getColor(R.color.cp_bg_line_d));
            this.euj.setVisibility(8);
            setRankVisible(8);
            this.euo.setVisibility(0);
            this.euc.setVisibility(8);
            this.euo.setData(i, fVar);
        } else if (this.status == com.baidu.tieba.barselect.a.a.etU) {
            int g = l.g(getContext(), R.dimen.tbds22);
            int g2 = l.g(getContext(), R.dimen.tbds10);
            int g3 = l.g(getContext(), R.dimen.tbds20);
            int g4 = l.g(getContext(), R.dimen.tbds30);
            this.euv.setBackgroundResource(R.drawable.bg_bazhu_shadow_and_radius);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.setMargins(g4, 0, g4, g3);
            this.euv.setLayoutParams(layoutParams);
            this.euv.setPadding(g2, 0, g2, g4);
            this.euj.setVisibility(8);
            this.eut.setVisibility(8);
            setRankVisible(8);
            this.euo.setVisibility(8);
            this.euc.setVisibility(0);
            this.euc.setData(i, fVar);
            this.euw.setPadding(0, g, 0, 0);
        } else if (this.status == com.baidu.tieba.barselect.a.a.etT) {
            if (i == 1) {
                this.euv.setBackgroundResource(R.drawable.bar_select_bg_top_round);
                this.eut.setVisibility(8);
            } else {
                this.euv.setBackgroundColor(getResources().getColor(R.color.cp_bg_line_d));
                this.eut.setVisibility(0);
                this.eus.setVisibility(0);
            }
            setRankVisible(0);
            this.euj.setVisibility(8);
            int rank = this.etE.getRank();
            if (rank < 10) {
                this.eui.setText("0" + rank);
            } else {
                this.eui.setText("" + rank);
            }
            if (rank == 2) {
                this.eui.setTextColor(getResources().getColor(R.color.common_color_10263));
            } else if (rank == 3) {
                this.eui.setTextColor(getResources().getColor(R.color.common_color_10266));
            } else {
                this.eui.setTextColor(getResources().getColor(R.color.cp_cont_b));
            }
            this.euo.setVisibility(8);
            this.euc.setVisibility(0);
            this.euc.setData(i, fVar);
        } else {
            setVisibility(8);
            return;
        }
        this.eum.setData(i, fVar);
        this.eun.setData(i, fVar);
        if (this.etE.aWJ()) {
            this.eup.setVisibility(0);
        } else {
            this.eup.setVisibility(8);
        }
        nq(TbadkCoreApplication.getInst().getSkinType());
    }

    public void nq(int i) {
        this.eun.nq(i);
        this.eum.nq(i);
        if (this.euc.getVisibility() == 0) {
            this.euc.nq(i);
        }
        this.euo.nq(i);
        al.h(this.cTa, R.color.cp_bg_line_c, i);
        if (this.status == com.baidu.tieba.barselect.a.a.etV) {
            al.g(this.euv, R.drawable.bar_select_bg_shadow_and_radius, i);
            al.c(this.eul, R.color.cp_cont_b, 1, i);
            al.c(this.euk, R.color.cp_cont_b, 1, i);
        } else if (this.status == com.baidu.tieba.barselect.a.a.etU) {
            al.g(this.euv, R.drawable.bg_bazhu_shadow_and_radius, i);
        } else if (this.status == com.baidu.tieba.barselect.a.a.etT) {
            if (this.position == 1) {
                al.g(this.euv, R.drawable.bar_select_bg_top_round, i);
            } else {
                al.h(this.euv, R.color.cp_bg_line_d, i);
            }
        } else if (this.status == com.baidu.tieba.barselect.a.a.etS) {
            al.h(this.euv, R.color.cp_bg_line_d, i);
        }
        if (this.etE != null) {
            if (this.etE.aWJ()) {
                al.c(this.eur, R.color.cp_cont_h, 1, i);
                al.g(this.euq, R.drawable.icon_use_tip_red, i);
            }
            int rank = this.etE.getRank();
            if (rank == 2) {
                al.c(this.eui, R.color.cp_link_tip_d, 1, i);
            } else if (rank == 3) {
                al.c(this.eui, R.color.cp_other_f, 1, i);
            } else {
                al.c(this.eui, R.color.cp_cont_b, 1, i);
            }
        }
    }

    private void setRankVisible(int i) {
        this.eui.setVisibility(i);
        this.euu.setVisibility(i);
    }
}
