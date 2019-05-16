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
    public static int eug = -1;
    private View cSY;
    private VotedAreaLayout eub;
    private TextView euh;
    private View eui;
    private TextView euj;
    private TextView euk;
    private CandidateInfoLayout eul;
    private NewAnounceLayout eum;
    private VoteAreaLayout eun;
    private View euo;
    private TextView eup;
    private TextView euq;
    private View eur;
    private View eus;
    private View eut;
    private View euu;
    private View euv;
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
        this.eui = findViewById(R.id.mine_vote_content);
        this.euj = (TextView) findViewById(R.id.mine_vote_title);
        this.euk = (TextView) findViewById(R.id.mine_vote_num);
        this.euh = (TextView) findViewById(R.id.tv_voted_rank);
        this.eul = (CandidateInfoLayout) findViewById(R.id.candidate_info_layout);
        this.eum = (NewAnounceLayout) findViewById(R.id.announce_layout);
        this.eun = (VoteAreaLayout) findViewById(R.id.vote_area_layout);
        this.eub = (VotedAreaLayout) findViewById(R.id.voted_area_layout);
        this.cSY = findViewById(R.id.divider_line);
        this.eur = findViewById(R.id.divider_empty_view);
        this.eus = findViewById(R.id.divider_line_container);
        this.eut = findViewById(R.id.empty_view);
        this.euu = findViewById(R.id.main_container);
        this.euv = findViewById(R.id.info_container);
        this.euo = findViewById(R.id.vote_ueg_warn_container);
        this.eup = (TextView) findViewById(R.id.vote_ueg_warn_img);
        this.euq = (TextView) findViewById(R.id.vote_ueg_warn_tv);
    }

    @Override // com.baidu.tieba.barselect.segment.CardBasicLayout
    public void setData(int i, f fVar) {
        super.setData(i, fVar);
        this.position = i;
        if (this.epN == null || this.etD == null || this.status < 0) {
            setVisibility(8);
            return;
        }
        if (this.status == com.baidu.tieba.barselect.a.a.etU) {
            this.euu.setBackgroundResource(R.drawable.bar_select_bg_shadow_and_radius);
            this.eui.setVisibility(0);
            this.euk.setText("当前排名" + this.etD.getRank());
            setRankVisible(8);
            this.eus.setVisibility(8);
            this.eun.setVisibility(0);
            this.eub.setVisibility(8);
            this.eun.setData(i, fVar);
        } else if (this.status == com.baidu.tieba.barselect.a.a.etR) {
            if (i == 0) {
                this.eus.setVisibility(8);
            } else {
                this.eus.setVisibility(8);
                this.eur.setVisibility(8);
            }
            this.euu.setBackgroundColor(getResources().getColor(R.color.cp_bg_line_d));
            this.eui.setVisibility(8);
            setRankVisible(8);
            this.eun.setVisibility(0);
            this.eub.setVisibility(8);
            this.eun.setData(i, fVar);
        } else if (this.status == com.baidu.tieba.barselect.a.a.etT) {
            int g = l.g(getContext(), R.dimen.tbds22);
            int g2 = l.g(getContext(), R.dimen.tbds10);
            int g3 = l.g(getContext(), R.dimen.tbds20);
            int g4 = l.g(getContext(), R.dimen.tbds30);
            this.euu.setBackgroundResource(R.drawable.bg_bazhu_shadow_and_radius);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.setMargins(g4, 0, g4, g3);
            this.euu.setLayoutParams(layoutParams);
            this.euu.setPadding(g2, 0, g2, g4);
            this.eui.setVisibility(8);
            this.eus.setVisibility(8);
            setRankVisible(8);
            this.eun.setVisibility(8);
            this.eub.setVisibility(0);
            this.eub.setData(i, fVar);
            this.euv.setPadding(0, g, 0, 0);
        } else if (this.status == com.baidu.tieba.barselect.a.a.etS) {
            if (i == 1) {
                this.euu.setBackgroundResource(R.drawable.bar_select_bg_top_round);
                this.eus.setVisibility(8);
            } else {
                this.euu.setBackgroundColor(getResources().getColor(R.color.cp_bg_line_d));
                this.eus.setVisibility(0);
                this.eur.setVisibility(0);
            }
            setRankVisible(0);
            this.eui.setVisibility(8);
            int rank = this.etD.getRank();
            if (rank < 10) {
                this.euh.setText("0" + rank);
            } else {
                this.euh.setText("" + rank);
            }
            if (rank == 2) {
                this.euh.setTextColor(getResources().getColor(R.color.common_color_10263));
            } else if (rank == 3) {
                this.euh.setTextColor(getResources().getColor(R.color.common_color_10266));
            } else {
                this.euh.setTextColor(getResources().getColor(R.color.cp_cont_b));
            }
            this.eun.setVisibility(8);
            this.eub.setVisibility(0);
            this.eub.setData(i, fVar);
        } else {
            setVisibility(8);
            return;
        }
        this.eul.setData(i, fVar);
        this.eum.setData(i, fVar);
        if (this.etD.aWG()) {
            this.euo.setVisibility(0);
        } else {
            this.euo.setVisibility(8);
        }
        nq(TbadkCoreApplication.getInst().getSkinType());
    }

    public void nq(int i) {
        this.eum.nq(i);
        this.eul.nq(i);
        if (this.eub.getVisibility() == 0) {
            this.eub.nq(i);
        }
        this.eun.nq(i);
        al.h(this.cSY, R.color.cp_bg_line_c, i);
        if (this.status == com.baidu.tieba.barselect.a.a.etU) {
            al.g(this.euu, R.drawable.bar_select_bg_shadow_and_radius, i);
            al.c(this.euk, R.color.cp_cont_b, 1, i);
            al.c(this.euj, R.color.cp_cont_b, 1, i);
        } else if (this.status == com.baidu.tieba.barselect.a.a.etT) {
            al.g(this.euu, R.drawable.bg_bazhu_shadow_and_radius, i);
        } else if (this.status == com.baidu.tieba.barselect.a.a.etS) {
            if (this.position == 1) {
                al.g(this.euu, R.drawable.bar_select_bg_top_round, i);
            } else {
                al.h(this.euu, R.color.cp_bg_line_d, i);
            }
        } else if (this.status == com.baidu.tieba.barselect.a.a.etR) {
            al.h(this.euu, R.color.cp_bg_line_d, i);
        }
        if (this.etD != null) {
            if (this.etD.aWG()) {
                al.c(this.euq, R.color.cp_cont_h, 1, i);
                al.g(this.eup, R.drawable.icon_use_tip_red, i);
            }
            int rank = this.etD.getRank();
            if (rank == 2) {
                al.c(this.euh, R.color.cp_link_tip_d, 1, i);
            } else if (rank == 3) {
                al.c(this.euh, R.color.cp_other_f, 1, i);
            } else {
                al.c(this.euh, R.color.cp_cont_b, 1, i);
            }
        }
    }

    private void setRankVisible(int i) {
        this.euh.setVisibility(i);
        this.eut.setVisibility(i);
    }
}
