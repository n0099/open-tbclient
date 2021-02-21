package com.baidu.tieba.ala.livecard.holder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadUserInfoLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.livecard.vc.c;
import com.baidu.tieba.card.ala.AlaVideoContainer;
import com.baidu.tieba.card.m;
/* loaded from: classes10.dex */
public class a implements View.OnClickListener {
    private cb ahi;
    private final View.OnClickListener aki = new View.OnClickListener() { // from class: com.baidu.tieba.ala.livecard.holder.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.hnx != null) {
                a.this.hnx.d(view, a.this.ahi);
            }
        }
    };
    public View dBb;
    public RelativeLayout hns;
    public ThreadUserInfoLayout hnt;
    public ThreadCommentAndPraiseInfoLayout hnu;
    public View hnv;
    public AlaVideoContainer hnw;
    private c hnx;
    private String mForumName;
    public TextView mTextTitle;
    private View rootView;

    public a(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.rootView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.frs_ala_stage_live_item, (ViewGroup) null);
        this.hns = (RelativeLayout) this.rootView.findViewById(R.id.layout_root);
        this.hnt = (ThreadUserInfoLayout) this.rootView.findViewById(R.id.card_frs_ala_video_user_info_layout);
        this.hnt.setFrom(3);
        this.mTextTitle = (TextView) this.rootView.findViewById(R.id.text_title);
        this.hnw = (AlaVideoContainer) this.rootView.findViewById(R.id.ala_video_container);
        this.hnv = this.rootView.findViewById(R.id.divider_below_reply_number_layout);
        this.hnu = (ThreadCommentAndPraiseInfoLayout) this.rootView.findViewById(R.id.text_bottom);
        this.dBb = this.rootView.findViewById(R.id.divider_line);
        this.hns.setOnClickListener(this);
        this.hnu.setOnClickListener(this);
        this.hnu.getCommentContainer().setOnClickListener(this);
        this.hnw.setOnVideoClickListener(this);
    }

    public View getRootView() {
        return this.rootView;
    }

    public void refreshView() {
        if (this.ahi != null && this.ahi.bnQ() != null) {
            k(this.ahi, this.mForumName);
        }
    }

    public void k(cb cbVar, String str) {
        if (cbVar != null && cbVar.bnQ() != null) {
            this.ahi = cbVar;
            this.mForumName = str;
            this.hns.setVisibility(0);
            this.hnt.setData(cbVar);
            if (this.hnt.getHeaderImg() != null) {
                this.hnt.getHeaderImg().setData(cbVar);
            }
            this.hnt.setUserAfterClickListener(this.aki);
            cbVar.y(false, true);
            this.mTextTitle.setText(cbVar.boz());
            this.hnw.getController().a(cbVar, str, "", false);
            this.hnw.getController().startPlayAnimation();
            this.hnu.setReplyTimeVisible(false);
            this.hnu.setNeedAddReplyIcon(true);
            this.hnu.setIsBarViewVisible(false);
            this.hnu.setCommentNumEnable(false);
            this.hnu.setOnClickListener(this);
            this.hnu.setLiveShareEnable(false);
            this.hnu.setShareVisible(true);
            this.hnu.setShowPraiseNum(true);
            this.hnu.setNeedAddPraiseIcon(true);
            this.hnu.setFrom(2);
            if (this.hnu.setData(cbVar)) {
                this.hnv.setVisibility(8);
            } else {
                this.hnv.setVisibility(0);
            }
            X(cbVar);
        }
    }

    public void o(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.hnu != null && this.hnt != null) {
            this.hnt.setPageUniqueId(bdUniqueId);
        }
    }

    private void X(cb cbVar) {
        this.hnu.onChangeSkinType();
        this.hnt.onChangeSkinType();
        this.hnw.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.hns.setBackgroundDrawable(ap.oC(R.color.CAM_X0205));
        ap.setBackgroundColor(this.dBb, R.color.CAM_X0204);
        if (cbVar != null && m.IO(cbVar.getId())) {
            ap.setViewTextColor(this.mTextTitle, R.color.CAM_X0109);
        } else {
            ap.setViewTextColor(this.mTextTitle, R.color.CAM_X0105);
        }
    }

    public void a(c cVar) {
        this.hnx = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.hns || view == this.hnu.getCommentContainer()) {
            if (this.ahi != null) {
                m.IN(this.ahi.getId());
            }
            if (this.hnx != null) {
                this.hnx.c(view, this.ahi);
            }
        } else if (view.getId() == R.id.video_container && this.hnx != null) {
            this.hnx.c(view, this.ahi);
        }
    }
}
