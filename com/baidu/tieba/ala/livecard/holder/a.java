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
            if (a.this.hnj != null) {
                a.this.hnj.d(view, a.this.ahi);
            }
        }
    };
    public View dBb;
    public RelativeLayout hne;
    public ThreadUserInfoLayout hnf;
    public ThreadCommentAndPraiseInfoLayout hng;
    public View hnh;
    public AlaVideoContainer hni;
    private c hnj;
    private String mForumName;
    public TextView mTextTitle;
    private View rootView;

    public a(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.rootView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.frs_ala_stage_live_item, (ViewGroup) null);
        this.hne = (RelativeLayout) this.rootView.findViewById(R.id.layout_root);
        this.hnf = (ThreadUserInfoLayout) this.rootView.findViewById(R.id.card_frs_ala_video_user_info_layout);
        this.hnf.setFrom(3);
        this.mTextTitle = (TextView) this.rootView.findViewById(R.id.text_title);
        this.hni = (AlaVideoContainer) this.rootView.findViewById(R.id.ala_video_container);
        this.hnh = this.rootView.findViewById(R.id.divider_below_reply_number_layout);
        this.hng = (ThreadCommentAndPraiseInfoLayout) this.rootView.findViewById(R.id.text_bottom);
        this.dBb = this.rootView.findViewById(R.id.divider_line);
        this.hne.setOnClickListener(this);
        this.hng.setOnClickListener(this);
        this.hng.getCommentContainer().setOnClickListener(this);
        this.hni.setOnVideoClickListener(this);
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
            this.hne.setVisibility(0);
            this.hnf.setData(cbVar);
            if (this.hnf.getHeaderImg() != null) {
                this.hnf.getHeaderImg().setData(cbVar);
            }
            this.hnf.setUserAfterClickListener(this.aki);
            cbVar.y(false, true);
            this.mTextTitle.setText(cbVar.boz());
            this.hni.getController().a(cbVar, str, "", false);
            this.hni.getController().startPlayAnimation();
            this.hng.setReplyTimeVisible(false);
            this.hng.setNeedAddReplyIcon(true);
            this.hng.setIsBarViewVisible(false);
            this.hng.setCommentNumEnable(false);
            this.hng.setOnClickListener(this);
            this.hng.setLiveShareEnable(false);
            this.hng.setShareVisible(true);
            this.hng.setShowPraiseNum(true);
            this.hng.setNeedAddPraiseIcon(true);
            this.hng.setFrom(2);
            if (this.hng.setData(cbVar)) {
                this.hnh.setVisibility(8);
            } else {
                this.hnh.setVisibility(0);
            }
            X(cbVar);
        }
    }

    public void o(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.hng != null && this.hnf != null) {
            this.hnf.setPageUniqueId(bdUniqueId);
        }
    }

    private void X(cb cbVar) {
        this.hng.onChangeSkinType();
        this.hnf.onChangeSkinType();
        this.hni.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.hne.setBackgroundDrawable(ap.oC(R.color.CAM_X0205));
        ap.setBackgroundColor(this.dBb, R.color.CAM_X0204);
        if (cbVar != null && m.IN(cbVar.getId())) {
            ap.setViewTextColor(this.mTextTitle, R.color.CAM_X0109);
        } else {
            ap.setViewTextColor(this.mTextTitle, R.color.CAM_X0105);
        }
    }

    public void a(c cVar) {
        this.hnj = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.hne || view == this.hng.getCommentContainer()) {
            if (this.ahi != null) {
                m.IM(this.ahi.getId());
            }
            if (this.hnj != null) {
                this.hnj.c(view, this.ahi);
            }
        } else if (view.getId() == R.id.video_container && this.hnj != null) {
            this.hnj.c(view, this.ahi);
        }
    }
}
