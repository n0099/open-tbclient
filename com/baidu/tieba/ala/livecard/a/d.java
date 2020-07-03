package com.baidu.tieba.ala.livecard.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadUserInfoLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ala.AlaVideoContainer;
import com.baidu.tieba.card.m;
/* loaded from: classes3.dex */
public class d implements View.OnClickListener {
    private bu aeK;
    private final View.OnClickListener ahM = new View.OnClickListener() { // from class: com.baidu.tieba.ala.livecard.a.d.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (d.this.fRL != null) {
                d.this.fRL.d(view, d.this.aeK);
            }
        }
    };
    public RelativeLayout fRG;
    public ThreadUserInfoLayout fRH;
    public ThreadCommentAndPraiseInfoLayout fRI;
    public View fRJ;
    public AlaVideoContainer fRK;
    private com.baidu.tieba.ala.livecard.vc.c fRL;
    public View mDivider;
    private String mForumName;
    public TextView mTextTitle;
    private View rootView;

    public d(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.rootView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.frs_ala_stage_live_item, (ViewGroup) null);
        this.fRG = (RelativeLayout) this.rootView.findViewById(R.id.layout_root);
        this.fRH = (ThreadUserInfoLayout) this.rootView.findViewById(R.id.card_frs_ala_video_user_info_layout);
        this.fRH.setFrom(3);
        this.mTextTitle = (TextView) this.rootView.findViewById(R.id.text_title);
        this.fRK = (AlaVideoContainer) this.rootView.findViewById(R.id.ala_video_container);
        this.fRJ = this.rootView.findViewById(R.id.divider_below_reply_number_layout);
        this.fRI = (ThreadCommentAndPraiseInfoLayout) this.rootView.findViewById(R.id.text_bottom);
        this.mDivider = this.rootView.findViewById(R.id.divider_line);
        this.fRG.setOnClickListener(this);
        this.fRI.setOnClickListener(this);
        this.fRI.getCommentContainer().setOnClickListener(this);
        this.fRK.setOnVideoClickListener(this);
    }

    public View getRootView() {
        return this.rootView;
    }

    public void refreshView() {
        if (this.aeK != null && this.aeK.aSp() != null) {
            k(this.aeK, this.mForumName);
        }
    }

    public void k(bu buVar, String str) {
        if (buVar != null && buVar.aSp() != null) {
            this.aeK = buVar;
            this.mForumName = str;
            this.fRG.setVisibility(0);
            this.fRH.setData(buVar);
            if (this.fRH.getHeaderImg() != null) {
                this.fRH.getHeaderImg().setData(buVar);
            }
            this.fRH.setUserAfterClickListener(this.ahM);
            buVar.v(false, true);
            this.mTextTitle.setText(buVar.aSZ());
            this.fRK.getController().a(buVar, str, "", false);
            this.fRK.getController().startPlayAnimation();
            this.fRI.setReplyTimeVisible(false);
            this.fRI.setNeedAddReplyIcon(true);
            this.fRI.setIsBarViewVisible(false);
            this.fRI.setCommentNumEnable(false);
            this.fRI.setOnClickListener(this);
            this.fRI.setLiveShareEnable(false);
            this.fRI.setShareVisible(true);
            this.fRI.setShowPraiseNum(true);
            this.fRI.setNeedAddPraiseIcon(true);
            this.fRI.setFrom(2);
            if (this.fRI.setData(buVar)) {
                this.fRJ.setVisibility(8);
            } else {
                this.fRJ.setVisibility(0);
            }
            W(buVar);
        }
    }

    public void o(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.fRI != null && this.fRH != null) {
            this.fRH.setPageUniqueId(bdUniqueId);
        }
    }

    private void W(bu buVar) {
        this.fRI.onChangeSkinType();
        this.fRH.onChangeSkinType();
        this.fRK.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.fRG.setBackgroundDrawable(an.ls(R.color.cp_bg_line_e));
        an.setBackgroundColor(this.mDivider, R.color.cp_bg_line_c);
        if (buVar != null && m.DP(buVar.getId())) {
            an.setViewTextColor(this.mTextTitle, (int) R.color.cp_cont_d);
        } else {
            an.setViewTextColor(this.mTextTitle, (int) R.color.cp_cont_b);
        }
    }

    public void a(com.baidu.tieba.ala.livecard.vc.c cVar) {
        this.fRL = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.fRG || view == this.fRI.getCommentContainer()) {
            if (this.aeK != null) {
                m.DO(this.aeK.getId());
            }
            if (this.fRL != null) {
                this.fRL.c(view, this.aeK);
            }
        } else if (view.getId() == R.id.video_container && this.fRL != null) {
            this.fRL.c(view, this.aeK);
        }
    }
}
