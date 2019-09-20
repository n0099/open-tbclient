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
    public static int eAW = -1;
    private View cVw;
    private VotedAreaLayout eAR;
    private TextView eAX;
    private View eAY;
    private TextView eAZ;
    private TextView eBa;
    private CandidateInfoLayout eBb;
    private NewAnounceLayout eBc;
    private VoteAreaLayout eBd;
    private View eBe;
    private TextView eBf;
    private TextView eBg;
    private View eBh;
    private View eBi;
    private View eBj;
    private View eBk;
    private View eBl;
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
        qY();
    }

    private void qY() {
        this.eAY = findViewById(R.id.mine_vote_content);
        this.eAZ = (TextView) findViewById(R.id.mine_vote_title);
        this.eBa = (TextView) findViewById(R.id.mine_vote_num);
        this.eAX = (TextView) findViewById(R.id.tv_voted_rank);
        this.eBb = (CandidateInfoLayout) findViewById(R.id.candidate_info_layout);
        this.eBc = (NewAnounceLayout) findViewById(R.id.announce_layout);
        this.eBd = (VoteAreaLayout) findViewById(R.id.vote_area_layout);
        this.eAR = (VotedAreaLayout) findViewById(R.id.voted_area_layout);
        this.cVw = findViewById(R.id.divider_line);
        this.eBh = findViewById(R.id.divider_empty_view);
        this.eBi = findViewById(R.id.divider_line_container);
        this.eBj = findViewById(R.id.empty_view);
        this.eBk = findViewById(R.id.main_container);
        this.eBl = findViewById(R.id.info_container);
        this.eBe = findViewById(R.id.vote_ueg_warn_container);
        this.eBf = (TextView) findViewById(R.id.vote_ueg_warn_img);
        this.eBg = (TextView) findViewById(R.id.vote_ueg_warn_tv);
    }

    @Override // com.baidu.tieba.barselect.segment.CardBasicLayout
    public void setData(int i, f fVar) {
        super.setData(i, fVar);
        this.position = i;
        if (this.ewD == null || this.eAt == null || this.status < 0) {
            setVisibility(8);
            return;
        }
        if (this.status == com.baidu.tieba.barselect.a.a.eAK) {
            this.eBk.setBackgroundResource(R.drawable.bar_select_bg_shadow_and_radius);
            this.eAY.setVisibility(0);
            this.eBa.setText("当前排名" + this.eAt.getRank());
            setRankVisible(8);
            this.eBi.setVisibility(8);
            this.eBd.setVisibility(0);
            this.eAR.setVisibility(8);
            this.eBd.setData(i, fVar);
        } else if (this.status == com.baidu.tieba.barselect.a.a.eAH) {
            if (i == 0) {
                this.eBi.setVisibility(8);
            } else {
                this.eBi.setVisibility(8);
                this.eBh.setVisibility(8);
            }
            this.eBk.setBackgroundColor(getResources().getColor(R.color.cp_bg_line_d));
            this.eAY.setVisibility(8);
            setRankVisible(8);
            this.eBd.setVisibility(0);
            this.eAR.setVisibility(8);
            this.eBd.setData(i, fVar);
        } else if (this.status == com.baidu.tieba.barselect.a.a.eAJ) {
            int g = l.g(getContext(), R.dimen.tbds22);
            int g2 = l.g(getContext(), R.dimen.tbds10);
            int g3 = l.g(getContext(), R.dimen.tbds20);
            int g4 = l.g(getContext(), R.dimen.tbds30);
            this.eBk.setBackgroundResource(R.drawable.bg_bazhu_shadow_and_radius);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.setMargins(g4, 0, g4, g3);
            this.eBk.setLayoutParams(layoutParams);
            this.eBk.setPadding(g2, 0, g2, g4);
            this.eAY.setVisibility(8);
            this.eBi.setVisibility(8);
            setRankVisible(8);
            this.eBd.setVisibility(8);
            this.eAR.setVisibility(0);
            this.eAR.setData(i, fVar);
            this.eBl.setPadding(0, g, 0, 0);
        } else if (this.status == com.baidu.tieba.barselect.a.a.eAI) {
            if (i == 1) {
                this.eBk.setBackgroundResource(R.drawable.bar_select_bg_top_round);
                this.eBi.setVisibility(8);
            } else {
                this.eBk.setBackgroundColor(getResources().getColor(R.color.cp_bg_line_d));
                this.eBi.setVisibility(0);
                this.eBh.setVisibility(0);
            }
            setRankVisible(0);
            this.eAY.setVisibility(8);
            int rank = this.eAt.getRank();
            if (rank < 10) {
                this.eAX.setText("0" + rank);
            } else {
                this.eAX.setText("" + rank);
            }
            if (rank == 2) {
                this.eAX.setTextColor(getResources().getColor(R.color.common_color_10263));
            } else if (rank == 3) {
                this.eAX.setTextColor(getResources().getColor(R.color.common_color_10266));
            } else {
                this.eAX.setTextColor(getResources().getColor(R.color.cp_cont_b));
            }
            this.eBd.setVisibility(8);
            this.eAR.setVisibility(0);
            this.eAR.setData(i, fVar);
        } else {
            setVisibility(8);
            return;
        }
        this.eBb.setData(i, fVar);
        this.eBc.setData(i, fVar);
        if (this.eAt.aZl()) {
            this.eBe.setVisibility(0);
        } else {
            this.eBe.setVisibility(8);
        }
        nE(TbadkCoreApplication.getInst().getSkinType());
    }

    public void nE(int i) {
        this.eBc.nE(i);
        this.eBb.nE(i);
        if (this.eAR.getVisibility() == 0) {
            this.eAR.nE(i);
        }
        this.eBd.nE(i);
        am.h(this.cVw, R.color.cp_bg_line_c, i);
        if (this.status == com.baidu.tieba.barselect.a.a.eAK) {
            am.g(this.eBk, R.drawable.bar_select_bg_shadow_and_radius, i);
            am.d(this.eBa, R.color.cp_cont_b, 1, i);
            am.d(this.eAZ, R.color.cp_cont_b, 1, i);
        } else if (this.status == com.baidu.tieba.barselect.a.a.eAJ) {
            am.g(this.eBk, R.drawable.bg_bazhu_shadow_and_radius, i);
        } else if (this.status == com.baidu.tieba.barselect.a.a.eAI) {
            if (this.position == 1) {
                am.g(this.eBk, R.drawable.bar_select_bg_top_round, i);
            } else {
                am.h(this.eBk, R.color.cp_bg_line_d, i);
            }
        } else if (this.status == com.baidu.tieba.barselect.a.a.eAH) {
            am.h(this.eBk, R.color.cp_bg_line_d, i);
        }
        if (this.eAt != null) {
            if (this.eAt.aZl()) {
                am.d(this.eBg, R.color.cp_cont_h, 1, i);
                am.g(this.eBf, R.drawable.icon_use_tip_red, i);
            }
            int rank = this.eAt.getRank();
            if (rank == 2) {
                am.d(this.eAX, R.color.cp_link_tip_d, 1, i);
            } else if (rank == 3) {
                am.d(this.eAX, R.color.cp_other_f, 1, i);
            } else {
                am.d(this.eAX, R.color.cp_cont_b, 1, i);
            }
        }
    }

    private void setRankVisible(int i) {
        this.eAX.setVisibility(i);
        this.eBj.setVisibility(i);
    }
}
