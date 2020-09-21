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
    private bw agf;
    private final View.OnClickListener ajn = new View.OnClickListener() { // from class: com.baidu.tieba.ala.livecard.a.d.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (d.this.gmo != null) {
                d.this.gmo.d(view, d.this.agf);
            }
        }
    };
    public RelativeLayout gmj;
    public ThreadUserInfoLayout gmk;
    public ThreadCommentAndPraiseInfoLayout gml;
    public View gmm;
    public AlaVideoContainer gmn;
    private com.baidu.tieba.ala.livecard.vc.c gmo;
    public View mDivider;
    private String mForumName;
    public TextView mTextTitle;
    private View rootView;

    public d(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.rootView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.frs_ala_stage_live_item, (ViewGroup) null);
        this.gmj = (RelativeLayout) this.rootView.findViewById(R.id.layout_root);
        this.gmk = (ThreadUserInfoLayout) this.rootView.findViewById(R.id.card_frs_ala_video_user_info_layout);
        this.gmk.setFrom(3);
        this.mTextTitle = (TextView) this.rootView.findViewById(R.id.text_title);
        this.gmn = (AlaVideoContainer) this.rootView.findViewById(R.id.ala_video_container);
        this.gmm = this.rootView.findViewById(R.id.divider_below_reply_number_layout);
        this.gml = (ThreadCommentAndPraiseInfoLayout) this.rootView.findViewById(R.id.text_bottom);
        this.mDivider = this.rootView.findViewById(R.id.divider_line);
        this.gmj.setOnClickListener(this);
        this.gml.setOnClickListener(this);
        this.gml.getCommentContainer().setOnClickListener(this);
        this.gmn.setOnVideoClickListener(this);
    }

    public View getRootView() {
        return this.rootView;
    }

    public void refreshView() {
        if (this.agf != null && this.agf.bfy() != null) {
            k(this.agf, this.mForumName);
        }
    }

    public void k(bw bwVar, String str) {
        if (bwVar != null && bwVar.bfy() != null) {
            this.agf = bwVar;
            this.mForumName = str;
            this.gmj.setVisibility(0);
            this.gmk.setData(bwVar);
            if (this.gmk.getHeaderImg() != null) {
                this.gmk.getHeaderImg().setData(bwVar);
            }
            this.gmk.setUserAfterClickListener(this.ajn);
            bwVar.z(false, true);
            this.mTextTitle.setText(bwVar.bgi());
            this.gmn.getController().a(bwVar, str, "", false);
            this.gmn.getController().startPlayAnimation();
            this.gml.setReplyTimeVisible(false);
            this.gml.setNeedAddReplyIcon(true);
            this.gml.setIsBarViewVisible(false);
            this.gml.setCommentNumEnable(false);
            this.gml.setOnClickListener(this);
            this.gml.setLiveShareEnable(false);
            this.gml.setShareVisible(true);
            this.gml.setShowPraiseNum(true);
            this.gml.setNeedAddPraiseIcon(true);
            this.gml.setFrom(2);
            if (this.gml.setData(bwVar)) {
                this.gmm.setVisibility(8);
            } else {
                this.gmm.setVisibility(0);
            }
            U(bwVar);
        }
    }

    public void o(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.gml != null && this.gmk != null) {
            this.gmk.setPageUniqueId(bdUniqueId);
        }
    }

    private void U(bw bwVar) {
        this.gml.onChangeSkinType();
        this.gmk.onChangeSkinType();
        this.gmn.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.gmj.setBackgroundDrawable(ap.of(R.color.cp_bg_line_e));
        ap.setBackgroundColor(this.mDivider, R.color.cp_bg_line_c);
        if (bwVar != null && m.Hx(bwVar.getId())) {
            ap.setViewTextColor(this.mTextTitle, R.color.cp_cont_d);
        } else {
            ap.setViewTextColor(this.mTextTitle, R.color.cp_cont_b);
        }
    }

    public void a(com.baidu.tieba.ala.livecard.vc.c cVar) {
        this.gmo = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.gmj || view == this.gml.getCommentContainer()) {
            if (this.agf != null) {
                m.Hw(this.agf.getId());
            }
            if (this.gmo != null) {
                this.gmo.c(view, this.agf);
            }
        } else if (view.getId() == R.id.video_container && this.gmo != null) {
            this.gmo.c(view, this.agf);
        }
    }
}
