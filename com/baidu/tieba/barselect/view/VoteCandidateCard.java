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
import com.baidu.tieba.barselect.VoteAdapter;
import com.baidu.tieba.barselect.data.f;
import com.baidu.tieba.barselect.segment.CandidateInfoLayout;
import com.baidu.tieba.barselect.segment.CardBasicLayout;
import com.baidu.tieba.barselect.segment.NewAnounceLayout;
import com.baidu.tieba.barselect.segment.VoteAreaLayout;
import com.baidu.tieba.barselect.segment.VotedAreaLayout;
/* loaded from: classes7.dex */
public class VoteCandidateCard extends CardBasicLayout {
    public static int ivu = -1;
    private View ghb;
    private VoteAdapter irB;
    private NewAnounceLayout ivA;
    private VoteAreaLayout ivB;
    private View ivC;
    private TextView ivD;
    private TextView ivE;
    private View ivF;
    private View ivG;
    private View ivH;
    private View ivI;
    private View ivJ;
    private TextView ivK;
    private View ivL;
    private LinearLayout ivM;
    private VotedAreaLayout ivm;
    private TextView ivv;
    private View ivw;
    private TextView ivx;
    private TextView ivy;
    private CandidateInfoLayout ivz;
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
        tz();
    }

    private void tz() {
        this.ivw = findViewById(R.id.mine_vote_content);
        this.ivx = (TextView) findViewById(R.id.mine_vote_title);
        this.ivy = (TextView) findViewById(R.id.mine_vote_num);
        this.ivv = (TextView) findViewById(R.id.tv_voted_rank);
        this.ivz = (CandidateInfoLayout) findViewById(R.id.candidate_info_layout);
        this.ivA = (NewAnounceLayout) findViewById(R.id.announce_layout);
        this.ivB = (VoteAreaLayout) findViewById(R.id.vote_area_layout);
        this.ivm = (VotedAreaLayout) findViewById(R.id.voted_area_layout);
        this.ghb = findViewById(R.id.divider_line);
        this.ivF = findViewById(R.id.divider_empty_view);
        this.ivG = findViewById(R.id.divider_line_container);
        this.ivH = findViewById(R.id.empty_view);
        this.ivI = findViewById(R.id.main_container);
        this.ivJ = findViewById(R.id.info_container);
        this.ivC = findViewById(R.id.vote_ueg_warn_container);
        this.ivD = (TextView) findViewById(R.id.vote_ueg_warn_img);
        this.ivE = (TextView) findViewById(R.id.vote_ueg_warn_tv);
        this.ivL = findViewById(R.id.divider_top_line);
        this.ivK = (TextView) findViewById(R.id.title_notpass_tv);
        this.ivM = (LinearLayout) findViewById(R.id.not_allow_view);
    }

    @Override // com.baidu.tieba.barselect.segment.CardBasicLayout
    public void setData(int i, f fVar) {
        super.setData(i, fVar);
        this.position = i;
        if (this.ire == null || this.iuP == null || this.status < 0) {
            setVisibility(8);
            return;
        }
        if (this.status == com.baidu.tieba.barselect.a.a.ivf) {
            this.ivI.setBackgroundResource(R.drawable.bar_select_bg_shadow_and_radius);
            this.ivw.setVisibility(0);
            this.ivy.setText("当前排名" + this.iuP.getRank());
            setRankVisible(8);
            this.ivG.setVisibility(8);
            this.ivB.setVisibility(0);
            this.ivm.setVisibility(8);
            this.ivB.setData(i, fVar);
            this.ivM.setVisibility(8);
        } else if (this.status == com.baidu.tieba.barselect.a.a.ivc) {
            if (i == 0) {
                this.ivG.setVisibility(8);
            } else {
                this.ivG.setVisibility(8);
                this.ivF.setVisibility(8);
            }
            this.ivI.setBackgroundColor(getResources().getColor(R.color.CAM_X0201));
            this.ivw.setVisibility(8);
            setRankVisible(8);
            if (this.iuP.crs() == 2 && this.irB.crl() == -1) {
                this.irB.wL(i);
            }
            if (this.iuP.crs() == 2) {
                if (this.irB != null && this.irB.crl() == i) {
                    this.ivM.setVisibility(0);
                } else {
                    this.ivM.setVisibility(8);
                }
                this.ivB.setVisibility(8);
            } else {
                this.ivM.setVisibility(8);
                this.ivB.setVisibility(0);
                this.ivB.setData(i, fVar);
            }
            this.ivm.setVisibility(8);
        } else if (this.status == com.baidu.tieba.barselect.a.a.ive) {
            int dimens = l.getDimens(getContext(), R.dimen.tbds22);
            int dimens2 = l.getDimens(getContext(), R.dimen.tbds10);
            int dimens3 = l.getDimens(getContext(), R.dimen.tbds20);
            int dimens4 = l.getDimens(getContext(), R.dimen.tbds30);
            this.ivI.setBackgroundResource(R.drawable.bg_bazhu_shadow_and_radius);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.setMargins(dimens4, 0, dimens4, dimens3);
            this.ivI.setLayoutParams(layoutParams);
            this.ivI.setPadding(dimens2, 0, dimens2, dimens4);
            this.ivw.setVisibility(8);
            this.ivG.setVisibility(8);
            setRankVisible(8);
            this.ivB.setVisibility(8);
            this.ivm.setVisibility(0);
            this.ivm.setData(i, fVar);
            this.ivJ.setPadding(0, dimens, 0, 0);
            this.ivM.setVisibility(8);
        } else if (this.status == com.baidu.tieba.barselect.a.a.ivd) {
            if (i == 1) {
                this.ivI.setBackgroundResource(R.drawable.bar_select_bg_top_round);
                this.ivG.setVisibility(8);
            } else {
                this.ivI.setBackgroundColor(getResources().getColor(R.color.CAM_X0201));
                this.ivG.setVisibility(0);
                this.ivF.setVisibility(0);
            }
            setRankVisible(0);
            this.ivw.setVisibility(8);
            int rank = this.iuP.getRank();
            if (rank < 10) {
                this.ivv.setText("0" + rank);
            } else {
                this.ivv.setText("" + rank);
            }
            if (rank == 2) {
                this.ivv.setTextColor(getResources().getColor(R.color.common_color_10263));
            } else if (rank == 3) {
                this.ivv.setTextColor(getResources().getColor(R.color.common_color_10266));
            } else {
                this.ivv.setTextColor(getResources().getColor(R.color.CAM_X0105));
            }
            this.ivB.setVisibility(8);
            this.ivm.setVisibility(0);
            this.ivm.setData(i, fVar);
            this.ivM.setVisibility(8);
        } else {
            setVisibility(8);
            return;
        }
        this.ivz.setData(i, fVar);
        this.ivA.setData(i, fVar);
        if (this.iuP.crr()) {
            this.ivC.setVisibility(0);
        } else {
            this.ivC.setVisibility(8);
        }
        uw(TbadkCoreApplication.getInst().getSkinType());
    }

    public void uw(int i) {
        this.ivA.uw(i);
        this.ivz.uw(i);
        if (this.ivm.getVisibility() == 0) {
            this.ivm.uw(i);
        }
        this.ivB.uw(i);
        ap.setBackgroundColor(this.ghb, R.color.CAM_X0204, i);
        if (this.status == com.baidu.tieba.barselect.a.a.ivf) {
            ap.setBackgroundResource(this.ivI, R.drawable.bar_select_bg_shadow_and_radius, i);
            ap.setViewTextColor(this.ivy, R.color.CAM_X0105, 1, i);
            ap.setViewTextColor(this.ivx, R.color.CAM_X0105, 1, i);
        } else if (this.status == com.baidu.tieba.barselect.a.a.ive) {
            ap.setBackgroundResource(this.ivI, R.drawable.bg_bazhu_shadow_and_radius, i);
        } else if (this.status == com.baidu.tieba.barselect.a.a.ivd) {
            if (this.position == 1) {
                ap.setBackgroundResource(this.ivI, R.drawable.bar_select_bg_top_round, i);
            } else {
                ap.setBackgroundColor(this.ivI, R.color.CAM_X0201, i);
            }
        } else if (this.status == com.baidu.tieba.barselect.a.a.ivc) {
            ap.setBackgroundColor(this.ivI, R.color.CAM_X0201, i);
            ap.setViewTextColor(this.ivK, R.color.CAM_X0105, 1, i);
            ap.setBackgroundColor(this.ivM, R.color.CAM_X0201, i);
            ap.setBackgroundColor(this.ivL, R.color.CAM_X0203, i);
        }
        if (this.iuP != null) {
            if (this.iuP.crr()) {
                ap.setViewTextColor(this.ivE, R.color.CAM_X0301, 1, i);
                ap.setBackgroundResource(this.ivD, R.drawable.icon_use_tip_red, i);
            }
            int rank = this.iuP.getRank();
            if (rank == 2) {
                ap.setViewTextColor(this.ivv, R.color.CAM_X0305, 1, i);
            } else if (rank == 3) {
                ap.setViewTextColor(this.ivv, R.color.CAM_X0312, 1, i);
            } else {
                ap.setViewTextColor(this.ivv, R.color.CAM_X0105, 1, i);
            }
        }
    }

    private void setRankVisible(int i) {
        this.ivv.setVisibility(i);
        this.ivH.setVisibility(i);
    }

    public void setVoteAdaPter(VoteAdapter voteAdapter) {
        this.irB = voteAdapter;
    }
}
