package com.baidu.tieba.ala.livecard.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadUserInfoLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ala.AlaVideoContainer;
import com.baidu.tieba.card.m;
/* loaded from: classes3.dex */
public class d implements View.OnClickListener {
    private bk aee;
    private final View.OnClickListener agI = new View.OnClickListener() { // from class: com.baidu.tieba.ala.livecard.a.d.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (d.this.fGr != null) {
                d.this.fGr.d(view, d.this.aee);
            }
        }
    };
    public RelativeLayout fGm;
    public ThreadUserInfoLayout fGn;
    public ThreadCommentAndPraiseInfoLayout fGo;
    public View fGp;
    public AlaVideoContainer fGq;
    private com.baidu.tieba.ala.livecard.vc.c fGr;
    public View mDivider;
    private String mForumName;
    public TextView mTextTitle;
    private View rootView;

    public d(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.rootView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.frs_ala_stage_live_item, (ViewGroup) null);
        this.fGm = (RelativeLayout) this.rootView.findViewById(R.id.layout_root);
        this.fGn = (ThreadUserInfoLayout) this.rootView.findViewById(R.id.card_frs_ala_video_user_info_layout);
        this.fGn.setFrom(3);
        this.mTextTitle = (TextView) this.rootView.findViewById(R.id.text_title);
        this.fGq = (AlaVideoContainer) this.rootView.findViewById(R.id.ala_video_container);
        this.fGp = this.rootView.findViewById(R.id.divider_below_reply_number_layout);
        this.fGo = (ThreadCommentAndPraiseInfoLayout) this.rootView.findViewById(R.id.text_bottom);
        this.mDivider = this.rootView.findViewById(R.id.divider_line);
        this.fGm.setOnClickListener(this);
        this.fGo.setOnClickListener(this);
        this.fGo.getCommentContainer().setOnClickListener(this);
        this.fGq.setOnVideoClickListener(this);
    }

    public View getRootView() {
        return this.rootView;
    }

    public void refreshView() {
        if (this.aee != null && this.aee.aQx() != null) {
            d(this.aee, this.mForumName);
        }
    }

    public void d(bk bkVar, String str) {
        if (bkVar != null && bkVar.aQx() != null) {
            this.aee = bkVar;
            this.mForumName = str;
            this.fGm.setVisibility(0);
            this.fGn.setData(bkVar);
            if (this.fGn.getHeaderImg() != null) {
                this.fGn.getHeaderImg().setData(bkVar);
            }
            this.fGn.setUserAfterClickListener(this.agI);
            bkVar.v(false, true);
            this.mTextTitle.setText(bkVar.aRi());
            this.fGq.getController().a(bkVar, str, "", false);
            this.fGq.getController().startPlayAnimation();
            this.fGo.setReplyTimeVisible(false);
            this.fGo.setNeedAddReplyIcon(true);
            this.fGo.setIsBarViewVisible(false);
            this.fGo.setCommentNumEnable(false);
            this.fGo.setOnClickListener(this);
            this.fGo.setLiveShareEnable(false);
            this.fGo.setShareVisible(true);
            this.fGo.setShowPraiseNum(true);
            this.fGo.setNeedAddPraiseIcon(true);
            this.fGo.setFrom(2);
            if (this.fGo.setData(bkVar)) {
                this.fGp.setVisibility(8);
            } else {
                this.fGp.setVisibility(0);
            }
            V(bkVar);
        }
    }

    public void o(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.fGo != null && this.fGn != null) {
            this.fGn.setPageUniqueId(bdUniqueId);
        }
    }

    private void V(bk bkVar) {
        this.fGo.onChangeSkinType();
        this.fGn.onChangeSkinType();
        this.fGq.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.fGm.setBackgroundDrawable(am.lc(R.color.cp_bg_line_e));
        am.setBackgroundColor(this.mDivider, R.color.cp_bg_line_c);
        if (bkVar != null && m.Do(bkVar.getId())) {
            am.setViewTextColor(this.mTextTitle, (int) R.color.cp_cont_d);
        } else {
            am.setViewTextColor(this.mTextTitle, (int) R.color.cp_cont_b);
        }
    }

    public void a(com.baidu.tieba.ala.livecard.vc.c cVar) {
        this.fGr = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.fGm || view == this.fGo.getCommentContainer()) {
            if (this.aee != null) {
                m.Dn(this.aee.getId());
            }
            if (this.fGr != null) {
                this.fGr.c(view, this.aee);
            }
        } else if (view.getId() == R.id.video_container && this.fGr != null) {
            this.fGr.c(view, this.aee);
        }
    }
}
