package com.baidu.tieba.ala.livecard.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadUserInfoLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ala.AlaVideoContainer;
import com.baidu.tieba.card.m;
/* loaded from: classes4.dex */
public class d implements View.OnClickListener {
    private bw agw;
    private final View.OnClickListener ajF = new View.OnClickListener() { // from class: com.baidu.tieba.ala.livecard.a.d.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (d.this.gAH != null) {
                d.this.gAH.d(view, d.this.agw);
            }
        }
    };
    public RelativeLayout gAC;
    public ThreadUserInfoLayout gAD;
    public ThreadCommentAndPraiseInfoLayout gAE;
    public View gAF;
    public AlaVideoContainer gAG;
    private com.baidu.tieba.ala.livecard.vc.c gAH;
    public View mDivider;
    private String mForumName;
    public TextView mTextTitle;
    private View rootView;

    public d(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.rootView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.frs_ala_stage_live_item, (ViewGroup) null);
        this.gAC = (RelativeLayout) this.rootView.findViewById(R.id.layout_root);
        this.gAD = (ThreadUserInfoLayout) this.rootView.findViewById(R.id.card_frs_ala_video_user_info_layout);
        this.gAD.setFrom(3);
        this.mTextTitle = (TextView) this.rootView.findViewById(R.id.text_title);
        this.gAG = (AlaVideoContainer) this.rootView.findViewById(R.id.ala_video_container);
        this.gAF = this.rootView.findViewById(R.id.divider_below_reply_number_layout);
        this.gAE = (ThreadCommentAndPraiseInfoLayout) this.rootView.findViewById(R.id.text_bottom);
        this.mDivider = this.rootView.findViewById(R.id.divider_line);
        this.gAC.setOnClickListener(this);
        this.gAE.setOnClickListener(this);
        this.gAE.getCommentContainer().setOnClickListener(this);
        this.gAG.setOnVideoClickListener(this);
    }

    public View getRootView() {
        return this.rootView;
    }

    public void refreshView() {
        if (this.agw != null && this.agw.bih() != null) {
            k(this.agw, this.mForumName);
        }
    }

    public void k(bw bwVar, String str) {
        if (bwVar != null && bwVar.bih() != null) {
            this.agw = bwVar;
            this.mForumName = str;
            this.gAC.setVisibility(0);
            this.gAD.setData(bwVar);
            if (this.gAD.getHeaderImg() != null) {
                this.gAD.getHeaderImg().setData(bwVar);
            }
            this.gAD.setUserAfterClickListener(this.ajF);
            bwVar.z(false, true);
            this.mTextTitle.setText(bwVar.biR());
            this.gAG.getController().a(bwVar, str, "", false);
            this.gAG.getController().startPlayAnimation();
            this.gAE.setReplyTimeVisible(false);
            this.gAE.setNeedAddReplyIcon(true);
            this.gAE.setIsBarViewVisible(false);
            this.gAE.setCommentNumEnable(false);
            this.gAE.setOnClickListener(this);
            this.gAE.setLiveShareEnable(false);
            this.gAE.setShareVisible(true);
            this.gAE.setShowPraiseNum(true);
            this.gAE.setNeedAddPraiseIcon(true);
            this.gAE.setFrom(2);
            if (this.gAE.setData(bwVar)) {
                this.gAF.setVisibility(8);
            } else {
                this.gAF.setVisibility(0);
            }
            U(bwVar);
        }
    }

    public void o(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.gAE != null && this.gAD != null) {
            this.gAD.setPageUniqueId(bdUniqueId);
        }
    }

    private void U(bw bwVar) {
        this.gAE.onChangeSkinType();
        this.gAD.onChangeSkinType();
        this.gAG.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.gAC.setBackgroundDrawable(ap.oC(R.color.cp_bg_line_e));
        ap.setBackgroundColor(this.mDivider, R.color.cp_bg_line_c);
        if (bwVar != null && m.Ik(bwVar.getId())) {
            ap.setViewTextColor(this.mTextTitle, R.color.cp_cont_d);
        } else {
            ap.setViewTextColor(this.mTextTitle, R.color.cp_cont_b);
        }
    }

    public void a(com.baidu.tieba.ala.livecard.vc.c cVar) {
        this.gAH = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.gAC || view == this.gAE.getCommentContainer()) {
            if (this.agw != null) {
                m.Ij(this.agw.getId());
            }
            if (this.gAH != null) {
                this.gAH.c(view, this.agw);
            }
        } else if (view.getId() == R.id.video_container && this.gAH != null) {
            this.gAH.c(view, this.agw);
        }
    }
}
