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
/* loaded from: classes20.dex */
public class VoteCandidateCard extends CardBasicLayout {
    public static int hVg = -1;
    private View fPU;
    private d hRj;
    private VotedAreaLayout hUY;
    private TextView hVh;
    private View hVi;
    private TextView hVj;
    private TextView hVk;
    private CandidateInfoLayout hVl;
    private NewAnounceLayout hVm;
    private VoteAreaLayout hVn;
    private View hVo;
    private TextView hVp;
    private TextView hVq;
    private View hVr;
    private View hVs;
    private View hVt;
    private View hVu;
    private View hVv;
    private TextView hVw;
    private View hVx;
    private LinearLayout hVy;
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
        this.hVi = findViewById(R.id.mine_vote_content);
        this.hVj = (TextView) findViewById(R.id.mine_vote_title);
        this.hVk = (TextView) findViewById(R.id.mine_vote_num);
        this.hVh = (TextView) findViewById(R.id.tv_voted_rank);
        this.hVl = (CandidateInfoLayout) findViewById(R.id.candidate_info_layout);
        this.hVm = (NewAnounceLayout) findViewById(R.id.announce_layout);
        this.hVn = (VoteAreaLayout) findViewById(R.id.vote_area_layout);
        this.hUY = (VotedAreaLayout) findViewById(R.id.voted_area_layout);
        this.fPU = findViewById(R.id.divider_line);
        this.hVr = findViewById(R.id.divider_empty_view);
        this.hVs = findViewById(R.id.divider_line_container);
        this.hVt = findViewById(R.id.empty_view);
        this.hVu = findViewById(R.id.main_container);
        this.hVv = findViewById(R.id.info_container);
        this.hVo = findViewById(R.id.vote_ueg_warn_container);
        this.hVp = (TextView) findViewById(R.id.vote_ueg_warn_img);
        this.hVq = (TextView) findViewById(R.id.vote_ueg_warn_tv);
        this.hVx = findViewById(R.id.divider_top_line);
        this.hVw = (TextView) findViewById(R.id.title_notpass_tv);
        this.hVy = (LinearLayout) findViewById(R.id.not_allow_view);
    }

    @Override // com.baidu.tieba.barselect.segment.CardBasicLayout
    public void setData(int i, f fVar) {
        super.setData(i, fVar);
        this.position = i;
        if (this.hQM == null || this.hUB == null || this.status < 0) {
            setVisibility(8);
            return;
        }
        if (this.status == com.baidu.tieba.barselect.a.a.hUR) {
            this.hVu.setBackgroundResource(R.drawable.bar_select_bg_shadow_and_radius);
            this.hVi.setVisibility(0);
            this.hVk.setText("当前排名" + this.hUB.getRank());
            setRankVisible(8);
            this.hVs.setVisibility(8);
            this.hVn.setVisibility(0);
            this.hUY.setVisibility(8);
            this.hVn.setData(i, fVar);
            this.hVy.setVisibility(8);
        } else if (this.status == com.baidu.tieba.barselect.a.a.hUO) {
            if (i == 0) {
                this.hVs.setVisibility(8);
            } else {
                this.hVs.setVisibility(8);
                this.hVr.setVisibility(8);
            }
            this.hVu.setBackgroundColor(getResources().getColor(R.color.CAM_X0201));
            this.hVi.setVisibility(8);
            setRankVisible(8);
            if (this.hUB.cmF() == 2 && this.hRj.cmy() == -1) {
                this.hRj.xm(i);
            }
            if (this.hUB.cmF() == 2) {
                if (this.hRj != null && this.hRj.cmy() == i) {
                    this.hVy.setVisibility(0);
                } else {
                    this.hVy.setVisibility(8);
                }
                this.hVn.setVisibility(8);
            } else {
                this.hVy.setVisibility(8);
                this.hVn.setVisibility(0);
                this.hVn.setData(i, fVar);
            }
            this.hUY.setVisibility(8);
        } else if (this.status == com.baidu.tieba.barselect.a.a.hUQ) {
            int dimens = l.getDimens(getContext(), R.dimen.tbds22);
            int dimens2 = l.getDimens(getContext(), R.dimen.tbds10);
            int dimens3 = l.getDimens(getContext(), R.dimen.tbds20);
            int dimens4 = l.getDimens(getContext(), R.dimen.tbds30);
            this.hVu.setBackgroundResource(R.drawable.bg_bazhu_shadow_and_radius);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.setMargins(dimens4, 0, dimens4, dimens3);
            this.hVu.setLayoutParams(layoutParams);
            this.hVu.setPadding(dimens2, 0, dimens2, dimens4);
            this.hVi.setVisibility(8);
            this.hVs.setVisibility(8);
            setRankVisible(8);
            this.hVn.setVisibility(8);
            this.hUY.setVisibility(0);
            this.hUY.setData(i, fVar);
            this.hVv.setPadding(0, dimens, 0, 0);
            this.hVy.setVisibility(8);
        } else if (this.status == com.baidu.tieba.barselect.a.a.hUP) {
            if (i == 1) {
                this.hVu.setBackgroundResource(R.drawable.bar_select_bg_top_round);
                this.hVs.setVisibility(8);
            } else {
                this.hVu.setBackgroundColor(getResources().getColor(R.color.CAM_X0201));
                this.hVs.setVisibility(0);
                this.hVr.setVisibility(0);
            }
            setRankVisible(0);
            this.hVi.setVisibility(8);
            int rank = this.hUB.getRank();
            if (rank < 10) {
                this.hVh.setText("0" + rank);
            } else {
                this.hVh.setText("" + rank);
            }
            if (rank == 2) {
                this.hVh.setTextColor(getResources().getColor(R.color.common_color_10263));
            } else if (rank == 3) {
                this.hVh.setTextColor(getResources().getColor(R.color.common_color_10266));
            } else {
                this.hVh.setTextColor(getResources().getColor(R.color.CAM_X0105));
            }
            this.hVn.setVisibility(8);
            this.hUY.setVisibility(0);
            this.hUY.setData(i, fVar);
            this.hVy.setVisibility(8);
        } else {
            setVisibility(8);
            return;
        }
        this.hVl.setData(i, fVar);
        this.hVm.setData(i, fVar);
        if (this.hUB.cmE()) {
            this.hVo.setVisibility(0);
        } else {
            this.hVo.setVisibility(8);
        }
        vc(TbadkCoreApplication.getInst().getSkinType());
    }

    public void vc(int i) {
        this.hVm.vc(i);
        this.hVl.vc(i);
        if (this.hUY.getVisibility() == 0) {
            this.hUY.vc(i);
        }
        this.hVn.vc(i);
        ap.setBackgroundColor(this.fPU, R.color.CAM_X0204, i);
        if (this.status == com.baidu.tieba.barselect.a.a.hUR) {
            ap.setBackgroundResource(this.hVu, R.drawable.bar_select_bg_shadow_and_radius, i);
            ap.setViewTextColor(this.hVk, R.color.CAM_X0105, 1, i);
            ap.setViewTextColor(this.hVj, R.color.CAM_X0105, 1, i);
        } else if (this.status == com.baidu.tieba.barselect.a.a.hUQ) {
            ap.setBackgroundResource(this.hVu, R.drawable.bg_bazhu_shadow_and_radius, i);
        } else if (this.status == com.baidu.tieba.barselect.a.a.hUP) {
            if (this.position == 1) {
                ap.setBackgroundResource(this.hVu, R.drawable.bar_select_bg_top_round, i);
            } else {
                ap.setBackgroundColor(this.hVu, R.color.CAM_X0201, i);
            }
        } else if (this.status == com.baidu.tieba.barselect.a.a.hUO) {
            ap.setBackgroundColor(this.hVu, R.color.CAM_X0201, i);
            ap.setViewTextColor(this.hVw, R.color.CAM_X0105, 1, i);
            ap.setBackgroundColor(this.hVy, R.color.CAM_X0201, i);
            ap.setBackgroundColor(this.hVx, R.color.CAM_X0203, i);
        }
        if (this.hUB != null) {
            if (this.hUB.cmE()) {
                ap.setViewTextColor(this.hVq, R.color.CAM_X0301, 1, i);
                ap.setBackgroundResource(this.hVp, R.drawable.icon_use_tip_red, i);
            }
            int rank = this.hUB.getRank();
            if (rank == 2) {
                ap.setViewTextColor(this.hVh, R.color.CAM_X0305, 1, i);
            } else if (rank == 3) {
                ap.setViewTextColor(this.hVh, R.color.CAM_X0312, 1, i);
            } else {
                ap.setViewTextColor(this.hVh, R.color.CAM_X0105, 1, i);
            }
        }
    }

    private void setRankVisible(int i) {
        this.hVh.setVisibility(i);
        this.hVt.setVisibility(i);
    }

    public void setVoteAdaPter(d dVar) {
        this.hRj = dVar;
    }
}
