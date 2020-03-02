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
/* loaded from: classes8.dex */
public class VoteCandidateCard extends CardBasicLayout {
    public static int fGu = -1;
    private View cem;
    private NewAnounceLayout fGA;
    private VoteAreaLayout fGB;
    private View fGC;
    private TextView fGD;
    private TextView fGE;
    private View fGF;
    private View fGG;
    private View fGH;
    private View fGI;
    private View fGJ;
    private VotedAreaLayout fGp;
    private TextView fGv;
    private View fGw;
    private TextView fGx;
    private TextView fGy;
    private CandidateInfoLayout fGz;
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
        ns();
    }

    private void ns() {
        this.fGw = findViewById(R.id.mine_vote_content);
        this.fGx = (TextView) findViewById(R.id.mine_vote_title);
        this.fGy = (TextView) findViewById(R.id.mine_vote_num);
        this.fGv = (TextView) findViewById(R.id.tv_voted_rank);
        this.fGz = (CandidateInfoLayout) findViewById(R.id.candidate_info_layout);
        this.fGA = (NewAnounceLayout) findViewById(R.id.announce_layout);
        this.fGB = (VoteAreaLayout) findViewById(R.id.vote_area_layout);
        this.fGp = (VotedAreaLayout) findViewById(R.id.voted_area_layout);
        this.cem = findViewById(R.id.divider_line);
        this.fGF = findViewById(R.id.divider_empty_view);
        this.fGG = findViewById(R.id.divider_line_container);
        this.fGH = findViewById(R.id.empty_view);
        this.fGI = findViewById(R.id.main_container);
        this.fGJ = findViewById(R.id.info_container);
        this.fGC = findViewById(R.id.vote_ueg_warn_container);
        this.fGD = (TextView) findViewById(R.id.vote_ueg_warn_img);
        this.fGE = (TextView) findViewById(R.id.vote_ueg_warn_tv);
    }

    @Override // com.baidu.tieba.barselect.segment.CardBasicLayout
    public void setData(int i, f fVar) {
        super.setData(i, fVar);
        this.position = i;
        if (this.fCh == null || this.fFR == null || this.status < 0) {
            setVisibility(8);
            return;
        }
        if (this.status == com.baidu.tieba.barselect.a.a.fGi) {
            this.fGI.setBackgroundResource(R.drawable.bar_select_bg_shadow_and_radius);
            this.fGw.setVisibility(0);
            this.fGy.setText("当前排名" + this.fFR.getRank());
            setRankVisible(8);
            this.fGG.setVisibility(8);
            this.fGB.setVisibility(0);
            this.fGp.setVisibility(8);
            this.fGB.setData(i, fVar);
        } else if (this.status == com.baidu.tieba.barselect.a.a.fGf) {
            if (i == 0) {
                this.fGG.setVisibility(8);
            } else {
                this.fGG.setVisibility(8);
                this.fGF.setVisibility(8);
            }
            this.fGI.setBackgroundColor(getResources().getColor(R.color.cp_bg_line_d));
            this.fGw.setVisibility(8);
            setRankVisible(8);
            this.fGB.setVisibility(0);
            this.fGp.setVisibility(8);
            this.fGB.setData(i, fVar);
        } else if (this.status == com.baidu.tieba.barselect.a.a.fGh) {
            int dimens = l.getDimens(getContext(), R.dimen.tbds22);
            int dimens2 = l.getDimens(getContext(), R.dimen.tbds10);
            int dimens3 = l.getDimens(getContext(), R.dimen.tbds20);
            int dimens4 = l.getDimens(getContext(), R.dimen.tbds30);
            this.fGI.setBackgroundResource(R.drawable.bg_bazhu_shadow_and_radius);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.setMargins(dimens4, 0, dimens4, dimens3);
            this.fGI.setLayoutParams(layoutParams);
            this.fGI.setPadding(dimens2, 0, dimens2, dimens4);
            this.fGw.setVisibility(8);
            this.fGG.setVisibility(8);
            setRankVisible(8);
            this.fGB.setVisibility(8);
            this.fGp.setVisibility(0);
            this.fGp.setData(i, fVar);
            this.fGJ.setPadding(0, dimens, 0, 0);
        } else if (this.status == com.baidu.tieba.barselect.a.a.fGg) {
            if (i == 1) {
                this.fGI.setBackgroundResource(R.drawable.bar_select_bg_top_round);
                this.fGG.setVisibility(8);
            } else {
                this.fGI.setBackgroundColor(getResources().getColor(R.color.cp_bg_line_d));
                this.fGG.setVisibility(0);
                this.fGF.setVisibility(0);
            }
            setRankVisible(0);
            this.fGw.setVisibility(8);
            int rank = this.fFR.getRank();
            if (rank < 10) {
                this.fGv.setText("0" + rank);
            } else {
                this.fGv.setText("" + rank);
            }
            if (rank == 2) {
                this.fGv.setTextColor(getResources().getColor(R.color.common_color_10263));
            } else if (rank == 3) {
                this.fGv.setTextColor(getResources().getColor(R.color.common_color_10266));
            } else {
                this.fGv.setTextColor(getResources().getColor(R.color.cp_cont_b));
            }
            this.fGB.setVisibility(8);
            this.fGp.setVisibility(0);
            this.fGp.setData(i, fVar);
        } else {
            setVisibility(8);
            return;
        }
        this.fGz.setData(i, fVar);
        this.fGA.setData(i, fVar);
        if (this.fFR.btY()) {
            this.fGC.setVisibility(0);
        } else {
            this.fGC.setVisibility(8);
        }
        pk(TbadkCoreApplication.getInst().getSkinType());
    }

    public void pk(int i) {
        this.fGA.pk(i);
        this.fGz.pk(i);
        if (this.fGp.getVisibility() == 0) {
            this.fGp.pk(i);
        }
        this.fGB.pk(i);
        am.setBackgroundColor(this.cem, R.color.cp_bg_line_c, i);
        if (this.status == com.baidu.tieba.barselect.a.a.fGi) {
            am.setBackgroundResource(this.fGI, R.drawable.bar_select_bg_shadow_and_radius, i);
            am.setViewTextColor(this.fGy, R.color.cp_cont_b, 1, i);
            am.setViewTextColor(this.fGx, R.color.cp_cont_b, 1, i);
        } else if (this.status == com.baidu.tieba.barselect.a.a.fGh) {
            am.setBackgroundResource(this.fGI, R.drawable.bg_bazhu_shadow_and_radius, i);
        } else if (this.status == com.baidu.tieba.barselect.a.a.fGg) {
            if (this.position == 1) {
                am.setBackgroundResource(this.fGI, R.drawable.bar_select_bg_top_round, i);
            } else {
                am.setBackgroundColor(this.fGI, R.color.cp_bg_line_d, i);
            }
        } else if (this.status == com.baidu.tieba.barselect.a.a.fGf) {
            am.setBackgroundColor(this.fGI, R.color.cp_bg_line_d, i);
        }
        if (this.fFR != null) {
            if (this.fFR.btY()) {
                am.setViewTextColor(this.fGE, R.color.cp_cont_h, 1, i);
                am.setBackgroundResource(this.fGD, R.drawable.icon_use_tip_red, i);
            }
            int rank = this.fFR.getRank();
            if (rank == 2) {
                am.setViewTextColor(this.fGv, R.color.cp_link_tip_d, 1, i);
            } else if (rank == 3) {
                am.setViewTextColor(this.fGv, R.color.cp_other_f, 1, i);
            } else {
                am.setViewTextColor(this.fGv, R.color.cp_cont_b, 1, i);
            }
        }
    }

    private void setRankVisible(int i) {
        this.fGv.setVisibility(i);
        this.fGH.setVisibility(i);
    }
}
