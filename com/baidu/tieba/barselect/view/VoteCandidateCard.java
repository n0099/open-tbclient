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
    public static int fGs = -1;
    private View cel;
    private View fGA;
    private TextView fGB;
    private TextView fGC;
    private View fGD;
    private View fGE;
    private View fGF;
    private View fGG;
    private View fGH;
    private VotedAreaLayout fGn;
    private TextView fGt;
    private View fGu;
    private TextView fGv;
    private TextView fGw;
    private CandidateInfoLayout fGx;
    private NewAnounceLayout fGy;
    private VoteAreaLayout fGz;
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
        this.fGu = findViewById(R.id.mine_vote_content);
        this.fGv = (TextView) findViewById(R.id.mine_vote_title);
        this.fGw = (TextView) findViewById(R.id.mine_vote_num);
        this.fGt = (TextView) findViewById(R.id.tv_voted_rank);
        this.fGx = (CandidateInfoLayout) findViewById(R.id.candidate_info_layout);
        this.fGy = (NewAnounceLayout) findViewById(R.id.announce_layout);
        this.fGz = (VoteAreaLayout) findViewById(R.id.vote_area_layout);
        this.fGn = (VotedAreaLayout) findViewById(R.id.voted_area_layout);
        this.cel = findViewById(R.id.divider_line);
        this.fGD = findViewById(R.id.divider_empty_view);
        this.fGE = findViewById(R.id.divider_line_container);
        this.fGF = findViewById(R.id.empty_view);
        this.fGG = findViewById(R.id.main_container);
        this.fGH = findViewById(R.id.info_container);
        this.fGA = findViewById(R.id.vote_ueg_warn_container);
        this.fGB = (TextView) findViewById(R.id.vote_ueg_warn_img);
        this.fGC = (TextView) findViewById(R.id.vote_ueg_warn_tv);
    }

    @Override // com.baidu.tieba.barselect.segment.CardBasicLayout
    public void setData(int i, f fVar) {
        super.setData(i, fVar);
        this.position = i;
        if (this.fCf == null || this.fFP == null || this.status < 0) {
            setVisibility(8);
            return;
        }
        if (this.status == com.baidu.tieba.barselect.a.a.fGg) {
            this.fGG.setBackgroundResource(R.drawable.bar_select_bg_shadow_and_radius);
            this.fGu.setVisibility(0);
            this.fGw.setText("当前排名" + this.fFP.getRank());
            setRankVisible(8);
            this.fGE.setVisibility(8);
            this.fGz.setVisibility(0);
            this.fGn.setVisibility(8);
            this.fGz.setData(i, fVar);
        } else if (this.status == com.baidu.tieba.barselect.a.a.fGd) {
            if (i == 0) {
                this.fGE.setVisibility(8);
            } else {
                this.fGE.setVisibility(8);
                this.fGD.setVisibility(8);
            }
            this.fGG.setBackgroundColor(getResources().getColor(R.color.cp_bg_line_d));
            this.fGu.setVisibility(8);
            setRankVisible(8);
            this.fGz.setVisibility(0);
            this.fGn.setVisibility(8);
            this.fGz.setData(i, fVar);
        } else if (this.status == com.baidu.tieba.barselect.a.a.fGf) {
            int dimens = l.getDimens(getContext(), R.dimen.tbds22);
            int dimens2 = l.getDimens(getContext(), R.dimen.tbds10);
            int dimens3 = l.getDimens(getContext(), R.dimen.tbds20);
            int dimens4 = l.getDimens(getContext(), R.dimen.tbds30);
            this.fGG.setBackgroundResource(R.drawable.bg_bazhu_shadow_and_radius);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.setMargins(dimens4, 0, dimens4, dimens3);
            this.fGG.setLayoutParams(layoutParams);
            this.fGG.setPadding(dimens2, 0, dimens2, dimens4);
            this.fGu.setVisibility(8);
            this.fGE.setVisibility(8);
            setRankVisible(8);
            this.fGz.setVisibility(8);
            this.fGn.setVisibility(0);
            this.fGn.setData(i, fVar);
            this.fGH.setPadding(0, dimens, 0, 0);
        } else if (this.status == com.baidu.tieba.barselect.a.a.fGe) {
            if (i == 1) {
                this.fGG.setBackgroundResource(R.drawable.bar_select_bg_top_round);
                this.fGE.setVisibility(8);
            } else {
                this.fGG.setBackgroundColor(getResources().getColor(R.color.cp_bg_line_d));
                this.fGE.setVisibility(0);
                this.fGD.setVisibility(0);
            }
            setRankVisible(0);
            this.fGu.setVisibility(8);
            int rank = this.fFP.getRank();
            if (rank < 10) {
                this.fGt.setText("0" + rank);
            } else {
                this.fGt.setText("" + rank);
            }
            if (rank == 2) {
                this.fGt.setTextColor(getResources().getColor(R.color.common_color_10263));
            } else if (rank == 3) {
                this.fGt.setTextColor(getResources().getColor(R.color.common_color_10266));
            } else {
                this.fGt.setTextColor(getResources().getColor(R.color.cp_cont_b));
            }
            this.fGz.setVisibility(8);
            this.fGn.setVisibility(0);
            this.fGn.setData(i, fVar);
        } else {
            setVisibility(8);
            return;
        }
        this.fGx.setData(i, fVar);
        this.fGy.setData(i, fVar);
        if (this.fFP.btW()) {
            this.fGA.setVisibility(0);
        } else {
            this.fGA.setVisibility(8);
        }
        pk(TbadkCoreApplication.getInst().getSkinType());
    }

    public void pk(int i) {
        this.fGy.pk(i);
        this.fGx.pk(i);
        if (this.fGn.getVisibility() == 0) {
            this.fGn.pk(i);
        }
        this.fGz.pk(i);
        am.setBackgroundColor(this.cel, R.color.cp_bg_line_c, i);
        if (this.status == com.baidu.tieba.barselect.a.a.fGg) {
            am.setBackgroundResource(this.fGG, R.drawable.bar_select_bg_shadow_and_radius, i);
            am.setViewTextColor(this.fGw, R.color.cp_cont_b, 1, i);
            am.setViewTextColor(this.fGv, R.color.cp_cont_b, 1, i);
        } else if (this.status == com.baidu.tieba.barselect.a.a.fGf) {
            am.setBackgroundResource(this.fGG, R.drawable.bg_bazhu_shadow_and_radius, i);
        } else if (this.status == com.baidu.tieba.barselect.a.a.fGe) {
            if (this.position == 1) {
                am.setBackgroundResource(this.fGG, R.drawable.bar_select_bg_top_round, i);
            } else {
                am.setBackgroundColor(this.fGG, R.color.cp_bg_line_d, i);
            }
        } else if (this.status == com.baidu.tieba.barselect.a.a.fGd) {
            am.setBackgroundColor(this.fGG, R.color.cp_bg_line_d, i);
        }
        if (this.fFP != null) {
            if (this.fFP.btW()) {
                am.setViewTextColor(this.fGC, R.color.cp_cont_h, 1, i);
                am.setBackgroundResource(this.fGB, R.drawable.icon_use_tip_red, i);
            }
            int rank = this.fFP.getRank();
            if (rank == 2) {
                am.setViewTextColor(this.fGt, R.color.cp_link_tip_d, 1, i);
            } else if (rank == 3) {
                am.setViewTextColor(this.fGt, R.color.cp_other_f, 1, i);
            } else {
                am.setViewTextColor(this.fGt, R.color.cp_cont_b, 1, i);
            }
        }
    }

    private void setRankVisible(int i) {
        this.fGt.setVisibility(i);
        this.fGF.setVisibility(i);
    }
}
