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
    private bw afL;
    private final View.OnClickListener aiT = new View.OnClickListener() { // from class: com.baidu.tieba.ala.livecard.a.d.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (d.this.gjh != null) {
                d.this.gjh.d(view, d.this.afL);
            }
        }
    };
    public RelativeLayout gjc;
    public ThreadUserInfoLayout gjd;
    public ThreadCommentAndPraiseInfoLayout gje;
    public View gjf;
    public AlaVideoContainer gjg;
    private com.baidu.tieba.ala.livecard.vc.c gjh;
    public View mDivider;
    private String mForumName;
    public TextView mTextTitle;
    private View rootView;

    public d(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.rootView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.frs_ala_stage_live_item, (ViewGroup) null);
        this.gjc = (RelativeLayout) this.rootView.findViewById(R.id.layout_root);
        this.gjd = (ThreadUserInfoLayout) this.rootView.findViewById(R.id.card_frs_ala_video_user_info_layout);
        this.gjd.setFrom(3);
        this.mTextTitle = (TextView) this.rootView.findViewById(R.id.text_title);
        this.gjg = (AlaVideoContainer) this.rootView.findViewById(R.id.ala_video_container);
        this.gjf = this.rootView.findViewById(R.id.divider_below_reply_number_layout);
        this.gje = (ThreadCommentAndPraiseInfoLayout) this.rootView.findViewById(R.id.text_bottom);
        this.mDivider = this.rootView.findViewById(R.id.divider_line);
        this.gjc.setOnClickListener(this);
        this.gje.setOnClickListener(this);
        this.gje.getCommentContainer().setOnClickListener(this);
        this.gjg.setOnVideoClickListener(this);
    }

    public View getRootView() {
        return this.rootView;
    }

    public void refreshView() {
        if (this.afL != null && this.afL.beE() != null) {
            k(this.afL, this.mForumName);
        }
    }

    public void k(bw bwVar, String str) {
        if (bwVar != null && bwVar.beE() != null) {
            this.afL = bwVar;
            this.mForumName = str;
            this.gjc.setVisibility(0);
            this.gjd.setData(bwVar);
            if (this.gjd.getHeaderImg() != null) {
                this.gjd.getHeaderImg().setData(bwVar);
            }
            this.gjd.setUserAfterClickListener(this.aiT);
            bwVar.z(false, true);
            this.mTextTitle.setText(bwVar.bfo());
            this.gjg.getController().a(bwVar, str, "", false);
            this.gjg.getController().startPlayAnimation();
            this.gje.setReplyTimeVisible(false);
            this.gje.setNeedAddReplyIcon(true);
            this.gje.setIsBarViewVisible(false);
            this.gje.setCommentNumEnable(false);
            this.gje.setOnClickListener(this);
            this.gje.setLiveShareEnable(false);
            this.gje.setShareVisible(true);
            this.gje.setShowPraiseNum(true);
            this.gje.setNeedAddPraiseIcon(true);
            this.gje.setFrom(2);
            if (this.gje.setData(bwVar)) {
                this.gjf.setVisibility(8);
            } else {
                this.gjf.setVisibility(0);
            }
            T(bwVar);
        }
    }

    public void p(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.gje != null && this.gjd != null) {
            this.gjd.setPageUniqueId(bdUniqueId);
        }
    }

    private void T(bw bwVar) {
        this.gje.onChangeSkinType();
        this.gjd.onChangeSkinType();
        this.gjg.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.gjc.setBackgroundDrawable(ap.nT(R.color.cp_bg_line_e));
        ap.setBackgroundColor(this.mDivider, R.color.cp_bg_line_c);
        if (bwVar != null && m.Ha(bwVar.getId())) {
            ap.setViewTextColor(this.mTextTitle, (int) R.color.cp_cont_d);
        } else {
            ap.setViewTextColor(this.mTextTitle, (int) R.color.cp_cont_b);
        }
    }

    public void a(com.baidu.tieba.ala.livecard.vc.c cVar) {
        this.gjh = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.gjc || view == this.gje.getCommentContainer()) {
            if (this.afL != null) {
                m.GZ(this.afL.getId());
            }
            if (this.gjh != null) {
                this.gjh.c(view, this.afL);
            }
        } else if (view.getId() == R.id.video_container && this.gjh != null) {
            this.gjh.c(view, this.afL);
        }
    }
}
