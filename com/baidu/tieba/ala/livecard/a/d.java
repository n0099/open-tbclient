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
import com.baidu.tieba.card.n;
/* loaded from: classes4.dex */
public class d implements View.OnClickListener {
    private bw agx;
    private final View.OnClickListener ajG = new View.OnClickListener() { // from class: com.baidu.tieba.ala.livecard.a.d.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (d.this.gMv != null) {
                d.this.gMv.d(view, d.this.agx);
            }
        }
    };
    public RelativeLayout gMq;
    public ThreadUserInfoLayout gMr;
    public ThreadCommentAndPraiseInfoLayout gMs;
    public View gMt;
    public AlaVideoContainer gMu;
    private com.baidu.tieba.ala.livecard.vc.c gMv;
    public View mDivider;
    private String mForumName;
    public TextView mTextTitle;
    private View rootView;

    public d(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.rootView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.frs_ala_stage_live_item, (ViewGroup) null);
        this.gMq = (RelativeLayout) this.rootView.findViewById(R.id.layout_root);
        this.gMr = (ThreadUserInfoLayout) this.rootView.findViewById(R.id.card_frs_ala_video_user_info_layout);
        this.gMr.setFrom(3);
        this.mTextTitle = (TextView) this.rootView.findViewById(R.id.text_title);
        this.gMu = (AlaVideoContainer) this.rootView.findViewById(R.id.ala_video_container);
        this.gMt = this.rootView.findViewById(R.id.divider_below_reply_number_layout);
        this.gMs = (ThreadCommentAndPraiseInfoLayout) this.rootView.findViewById(R.id.text_bottom);
        this.mDivider = this.rootView.findViewById(R.id.divider_line);
        this.gMq.setOnClickListener(this);
        this.gMs.setOnClickListener(this);
        this.gMs.getCommentContainer().setOnClickListener(this);
        this.gMu.setOnVideoClickListener(this);
    }

    public View getRootView() {
        return this.rootView;
    }

    public void refreshView() {
        if (this.agx != null && this.agx.bka() != null) {
            k(this.agx, this.mForumName);
        }
    }

    public void k(bw bwVar, String str) {
        if (bwVar != null && bwVar.bka() != null) {
            this.agx = bwVar;
            this.mForumName = str;
            this.gMq.setVisibility(0);
            this.gMr.setData(bwVar);
            if (this.gMr.getHeaderImg() != null) {
                this.gMr.getHeaderImg().setData(bwVar);
            }
            this.gMr.setUserAfterClickListener(this.ajG);
            bwVar.z(false, true);
            this.mTextTitle.setText(bwVar.bkK());
            this.gMu.getController().a(bwVar, str, "", false);
            this.gMu.getController().startPlayAnimation();
            this.gMs.setReplyTimeVisible(false);
            this.gMs.setNeedAddReplyIcon(true);
            this.gMs.setIsBarViewVisible(false);
            this.gMs.setCommentNumEnable(false);
            this.gMs.setOnClickListener(this);
            this.gMs.setLiveShareEnable(false);
            this.gMs.setShareVisible(true);
            this.gMs.setShowPraiseNum(true);
            this.gMs.setNeedAddPraiseIcon(true);
            this.gMs.setFrom(2);
            if (this.gMs.setData(bwVar)) {
                this.gMt.setVisibility(8);
            } else {
                this.gMt.setVisibility(0);
            }
            U(bwVar);
        }
    }

    public void o(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.gMs != null && this.gMr != null) {
            this.gMr.setPageUniqueId(bdUniqueId);
        }
    }

    private void U(bw bwVar) {
        this.gMs.onChangeSkinType();
        this.gMr.onChangeSkinType();
        this.gMu.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.gMq.setBackgroundDrawable(ap.oN(R.color.cp_bg_line_e));
        ap.setBackgroundColor(this.mDivider, R.color.cp_bg_line_c);
        if (bwVar != null && n.IJ(bwVar.getId())) {
            ap.setViewTextColor(this.mTextTitle, R.color.cp_cont_d);
        } else {
            ap.setViewTextColor(this.mTextTitle, R.color.cp_cont_b);
        }
    }

    public void a(com.baidu.tieba.ala.livecard.vc.c cVar) {
        this.gMv = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.gMq || view == this.gMs.getCommentContainer()) {
            if (this.agx != null) {
                n.II(this.agx.getId());
            }
            if (this.gMv != null) {
                this.gMv.c(view, this.agx);
            }
        } else if (view.getId() == R.id.video_container && this.gMv != null) {
            this.gMv.c(view, this.agx);
        }
    }
}
