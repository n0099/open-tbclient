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
import com.baidu.tieba.barselect.d;
import com.baidu.tieba.barselect.data.f;
import com.baidu.tieba.barselect.segment.CandidateInfoLayout;
import com.baidu.tieba.barselect.segment.CardBasicLayout;
import com.baidu.tieba.barselect.segment.NewAnounceLayout;
import com.baidu.tieba.barselect.segment.VoteAreaLayout;
import com.baidu.tieba.barselect.segment.VotedAreaLayout;
/* loaded from: classes21.dex */
public class VoteCandidateCard extends CardBasicLayout {
    public static int hUG = -1;
    private View fQl;
    private d hQJ;
    private TextView hUH;
    private View hUI;
    private TextView hUJ;
    private TextView hUK;
    private CandidateInfoLayout hUL;
    private NewAnounceLayout hUM;
    private VoteAreaLayout hUN;
    private View hUO;
    private TextView hUP;
    private TextView hUQ;
    private View hUR;
    private View hUS;
    private View hUT;
    private View hUU;
    private View hUV;
    private TextView hUW;
    private View hUX;
    private LinearLayout hUY;
    private VotedAreaLayout hUy;
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
        ul();
    }

    private void ul() {
        this.hUI = findViewById(R.id.mine_vote_content);
        this.hUJ = (TextView) findViewById(R.id.mine_vote_title);
        this.hUK = (TextView) findViewById(R.id.mine_vote_num);
        this.hUH = (TextView) findViewById(R.id.tv_voted_rank);
        this.hUL = (CandidateInfoLayout) findViewById(R.id.candidate_info_layout);
        this.hUM = (NewAnounceLayout) findViewById(R.id.announce_layout);
        this.hUN = (VoteAreaLayout) findViewById(R.id.vote_area_layout);
        this.hUy = (VotedAreaLayout) findViewById(R.id.voted_area_layout);
        this.fQl = findViewById(R.id.divider_line);
        this.hUR = findViewById(R.id.divider_empty_view);
        this.hUS = findViewById(R.id.divider_line_container);
        this.hUT = findViewById(R.id.empty_view);
        this.hUU = findViewById(R.id.main_container);
        this.hUV = findViewById(R.id.info_container);
        this.hUO = findViewById(R.id.vote_ueg_warn_container);
        this.hUP = (TextView) findViewById(R.id.vote_ueg_warn_img);
        this.hUQ = (TextView) findViewById(R.id.vote_ueg_warn_tv);
        this.hUX = findViewById(R.id.divider_top_line);
        this.hUW = (TextView) findViewById(R.id.title_notpass_tv);
        this.hUY = (LinearLayout) findViewById(R.id.not_allow_view);
    }

    @Override // com.baidu.tieba.barselect.segment.CardBasicLayout
    public void setData(int i, f fVar) {
        super.setData(i, fVar);
        this.position = i;
        if (this.hQm == null || this.hUb == null || this.status < 0) {
            setVisibility(8);
            return;
        }
        if (this.status == com.baidu.tieba.barselect.a.a.hUr) {
            this.hUU.setBackgroundResource(R.drawable.bar_select_bg_shadow_and_radius);
            this.hUI.setVisibility(0);
            this.hUK.setText("当前排名" + this.hUb.getRank());
            setRankVisible(8);
            this.hUS.setVisibility(8);
            this.hUN.setVisibility(0);
            this.hUy.setVisibility(8);
            this.hUN.setData(i, fVar);
            this.hUY.setVisibility(8);
        } else if (this.status == com.baidu.tieba.barselect.a.a.hUo) {
            if (i == 0) {
                this.hUS.setVisibility(8);
            } else {
                this.hUS.setVisibility(8);
                this.hUR.setVisibility(8);
            }
            this.hUU.setBackgroundColor(getResources().getColor(R.color.cp_bg_line_d));
            this.hUI.setVisibility(8);
            setRankVisible(8);
            if (this.hUb.cnd() == 2 && this.hQJ.cmW() == -1) {
                this.hQJ.wO(i);
            }
            if (this.hUb.cnd() == 2) {
                if (this.hQJ != null && this.hQJ.cmW() == i) {
                    this.hUY.setVisibility(0);
                } else {
                    this.hUY.setVisibility(8);
                }
                this.hUN.setVisibility(8);
            } else {
                this.hUY.setVisibility(8);
                this.hUN.setVisibility(0);
                this.hUN.setData(i, fVar);
            }
            this.hUy.setVisibility(8);
        } else if (this.status == com.baidu.tieba.barselect.a.a.hUq) {
            int dimens = l.getDimens(getContext(), R.dimen.tbds22);
            int dimens2 = l.getDimens(getContext(), R.dimen.tbds10);
            int dimens3 = l.getDimens(getContext(), R.dimen.tbds20);
            int dimens4 = l.getDimens(getContext(), R.dimen.tbds30);
            this.hUU.setBackgroundResource(R.drawable.bg_bazhu_shadow_and_radius);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.setMargins(dimens4, 0, dimens4, dimens3);
            this.hUU.setLayoutParams(layoutParams);
            this.hUU.setPadding(dimens2, 0, dimens2, dimens4);
            this.hUI.setVisibility(8);
            this.hUS.setVisibility(8);
            setRankVisible(8);
            this.hUN.setVisibility(8);
            this.hUy.setVisibility(0);
            this.hUy.setData(i, fVar);
            this.hUV.setPadding(0, dimens, 0, 0);
            this.hUY.setVisibility(8);
        } else if (this.status == com.baidu.tieba.barselect.a.a.hUp) {
            if (i == 1) {
                this.hUU.setBackgroundResource(R.drawable.bar_select_bg_top_round);
                this.hUS.setVisibility(8);
            } else {
                this.hUU.setBackgroundColor(getResources().getColor(R.color.cp_bg_line_d));
                this.hUS.setVisibility(0);
                this.hUR.setVisibility(0);
            }
            setRankVisible(0);
            this.hUI.setVisibility(8);
            int rank = this.hUb.getRank();
            if (rank < 10) {
                this.hUH.setText("0" + rank);
            } else {
                this.hUH.setText("" + rank);
            }
            if (rank == 2) {
                this.hUH.setTextColor(getResources().getColor(R.color.common_color_10263));
            } else if (rank == 3) {
                this.hUH.setTextColor(getResources().getColor(R.color.common_color_10266));
            } else {
                this.hUH.setTextColor(getResources().getColor(R.color.cp_cont_b));
            }
            this.hUN.setVisibility(8);
            this.hUy.setVisibility(0);
            this.hUy.setData(i, fVar);
            this.hUY.setVisibility(8);
        } else {
            setVisibility(8);
            return;
        }
        this.hUL.setData(i, fVar);
        this.hUM.setData(i, fVar);
        if (this.hUb.cnc()) {
            this.hUO.setVisibility(0);
        } else {
            this.hUO.setVisibility(8);
        }
        uE(TbadkCoreApplication.getInst().getSkinType());
    }

    public void uE(int i) {
        this.hUM.uE(i);
        this.hUL.uE(i);
        if (this.hUy.getVisibility() == 0) {
            this.hUy.uE(i);
        }
        this.hUN.uE(i);
        ap.setBackgroundColor(this.fQl, R.color.cp_bg_line_c, i);
        if (this.status == com.baidu.tieba.barselect.a.a.hUr) {
            ap.setBackgroundResource(this.hUU, R.drawable.bar_select_bg_shadow_and_radius, i);
            ap.setViewTextColor(this.hUK, R.color.cp_cont_b, 1, i);
            ap.setViewTextColor(this.hUJ, R.color.cp_cont_b, 1, i);
        } else if (this.status == com.baidu.tieba.barselect.a.a.hUq) {
            ap.setBackgroundResource(this.hUU, R.drawable.bg_bazhu_shadow_and_radius, i);
        } else if (this.status == com.baidu.tieba.barselect.a.a.hUp) {
            if (this.position == 1) {
                ap.setBackgroundResource(this.hUU, R.drawable.bar_select_bg_top_round, i);
            } else {
                ap.setBackgroundColor(this.hUU, R.color.cp_bg_line_d, i);
            }
        } else if (this.status == com.baidu.tieba.barselect.a.a.hUo) {
            ap.setBackgroundColor(this.hUU, R.color.cp_bg_line_d, i);
            ap.setViewTextColor(this.hUW, R.color.cp_cont_b, 1, i);
            ap.setBackgroundColor(this.hUY, R.color.cp_bg_line_d, i);
            ap.setBackgroundColor(this.hUX, R.color.cp_bg_line_b, i);
        }
        if (this.hUb != null) {
            if (this.hUb.cnc()) {
                ap.setViewTextColor(this.hUQ, R.color.cp_cont_h, 1, i);
                ap.setBackgroundResource(this.hUP, R.drawable.icon_use_tip_red, i);
            }
            int rank = this.hUb.getRank();
            if (rank == 2) {
                ap.setViewTextColor(this.hUH, R.color.cp_link_tip_d, 1, i);
            } else if (rank == 3) {
                ap.setViewTextColor(this.hUH, R.color.cp_other_f, 1, i);
            } else {
                ap.setViewTextColor(this.hUH, R.color.cp_cont_b, 1, i);
            }
        }
    }

    private void setRankVisible(int i) {
        this.hUH.setVisibility(i);
        this.hUT.setVisibility(i);
    }

    public void setVoteAdaPter(d dVar) {
        this.hQJ = dVar;
    }
}
