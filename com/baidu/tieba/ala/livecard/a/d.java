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
    private bw afJ;
    private final View.OnClickListener aiR = new View.OnClickListener() { // from class: com.baidu.tieba.ala.livecard.a.d.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (d.this.gjd != null) {
                d.this.gjd.d(view, d.this.afJ);
            }
        }
    };
    public RelativeLayout giY;
    public ThreadUserInfoLayout giZ;
    public ThreadCommentAndPraiseInfoLayout gja;
    public View gjb;
    public AlaVideoContainer gjc;
    private com.baidu.tieba.ala.livecard.vc.c gjd;
    public View mDivider;
    private String mForumName;
    public TextView mTextTitle;
    private View rootView;

    public d(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.rootView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.frs_ala_stage_live_item, (ViewGroup) null);
        this.giY = (RelativeLayout) this.rootView.findViewById(R.id.layout_root);
        this.giZ = (ThreadUserInfoLayout) this.rootView.findViewById(R.id.card_frs_ala_video_user_info_layout);
        this.giZ.setFrom(3);
        this.mTextTitle = (TextView) this.rootView.findViewById(R.id.text_title);
        this.gjc = (AlaVideoContainer) this.rootView.findViewById(R.id.ala_video_container);
        this.gjb = this.rootView.findViewById(R.id.divider_below_reply_number_layout);
        this.gja = (ThreadCommentAndPraiseInfoLayout) this.rootView.findViewById(R.id.text_bottom);
        this.mDivider = this.rootView.findViewById(R.id.divider_line);
        this.giY.setOnClickListener(this);
        this.gja.setOnClickListener(this);
        this.gja.getCommentContainer().setOnClickListener(this);
        this.gjc.setOnVideoClickListener(this);
    }

    public View getRootView() {
        return this.rootView;
    }

    public void refreshView() {
        if (this.afJ != null && this.afJ.beE() != null) {
            k(this.afJ, this.mForumName);
        }
    }

    public void k(bw bwVar, String str) {
        if (bwVar != null && bwVar.beE() != null) {
            this.afJ = bwVar;
            this.mForumName = str;
            this.giY.setVisibility(0);
            this.giZ.setData(bwVar);
            if (this.giZ.getHeaderImg() != null) {
                this.giZ.getHeaderImg().setData(bwVar);
            }
            this.giZ.setUserAfterClickListener(this.aiR);
            bwVar.z(false, true);
            this.mTextTitle.setText(bwVar.bfo());
            this.gjc.getController().a(bwVar, str, "", false);
            this.gjc.getController().startPlayAnimation();
            this.gja.setReplyTimeVisible(false);
            this.gja.setNeedAddReplyIcon(true);
            this.gja.setIsBarViewVisible(false);
            this.gja.setCommentNumEnable(false);
            this.gja.setOnClickListener(this);
            this.gja.setLiveShareEnable(false);
            this.gja.setShareVisible(true);
            this.gja.setShowPraiseNum(true);
            this.gja.setNeedAddPraiseIcon(true);
            this.gja.setFrom(2);
            if (this.gja.setData(bwVar)) {
                this.gjb.setVisibility(8);
            } else {
                this.gjb.setVisibility(0);
            }
            T(bwVar);
        }
    }

    public void p(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.gja != null && this.giZ != null) {
            this.giZ.setPageUniqueId(bdUniqueId);
        }
    }

    private void T(bw bwVar) {
        this.gja.onChangeSkinType();
        this.giZ.onChangeSkinType();
        this.gjc.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.giY.setBackgroundDrawable(ap.nT(R.color.cp_bg_line_e));
        ap.setBackgroundColor(this.mDivider, R.color.cp_bg_line_c);
        if (bwVar != null && m.GZ(bwVar.getId())) {
            ap.setViewTextColor(this.mTextTitle, (int) R.color.cp_cont_d);
        } else {
            ap.setViewTextColor(this.mTextTitle, (int) R.color.cp_cont_b);
        }
    }

    public void a(com.baidu.tieba.ala.livecard.vc.c cVar) {
        this.gjd = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.giY || view == this.gja.getCommentContainer()) {
            if (this.afJ != null) {
                m.GY(this.afJ.getId());
            }
            if (this.gjd != null) {
                this.gjd.c(view, this.afJ);
            }
        } else if (view.getId() == R.id.video_container && this.gjd != null) {
            this.gjd.c(view, this.afJ);
        }
    }
}
