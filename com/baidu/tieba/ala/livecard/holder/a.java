package com.baidu.tieba.ala.livecard.holder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadUserInfoLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.livecard.vc.c;
import com.baidu.tieba.card.ala.AlaVideoContainer;
import com.baidu.tieba.card.m;
/* loaded from: classes10.dex */
public class a implements View.OnClickListener {
    private bz aim;
    private final View.OnClickListener alk = new View.OnClickListener() { // from class: com.baidu.tieba.ala.livecard.holder.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.hnC != null) {
                a.this.hnC.d(view, a.this.aim);
            }
        }
    };
    public View dDI;
    public View hnA;
    public AlaVideoContainer hnB;
    private c hnC;
    public RelativeLayout hnx;
    public ThreadUserInfoLayout hny;
    public ThreadCommentAndPraiseInfoLayout hnz;
    private String mForumName;
    public TextView mTextTitle;
    private View rootView;

    public a(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.rootView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.frs_ala_stage_live_item, (ViewGroup) null);
        this.hnx = (RelativeLayout) this.rootView.findViewById(R.id.layout_root);
        this.hny = (ThreadUserInfoLayout) this.rootView.findViewById(R.id.card_frs_ala_video_user_info_layout);
        this.hny.setFrom(3);
        this.mTextTitle = (TextView) this.rootView.findViewById(R.id.text_title);
        this.hnB = (AlaVideoContainer) this.rootView.findViewById(R.id.ala_video_container);
        this.hnA = this.rootView.findViewById(R.id.divider_below_reply_number_layout);
        this.hnz = (ThreadCommentAndPraiseInfoLayout) this.rootView.findViewById(R.id.text_bottom);
        this.dDI = this.rootView.findViewById(R.id.divider_line);
        this.hnx.setOnClickListener(this);
        this.hnz.setOnClickListener(this);
        this.hnz.getCommentContainer().setOnClickListener(this);
        this.hnB.setOnVideoClickListener(this);
    }

    public View getRootView() {
        return this.rootView;
    }

    public void refreshView() {
        if (this.aim != null && this.aim.brq() != null) {
            k(this.aim, this.mForumName);
        }
    }

    public void k(bz bzVar, String str) {
        if (bzVar != null && bzVar.brq() != null) {
            this.aim = bzVar;
            this.mForumName = str;
            this.hnx.setVisibility(0);
            this.hny.setData(bzVar);
            if (this.hny.getHeaderImg() != null) {
                this.hny.getHeaderImg().setData(bzVar);
            }
            this.hny.setUserAfterClickListener(this.alk);
            bzVar.z(false, true);
            this.mTextTitle.setText(bzVar.brZ());
            this.hnB.getController().a(bzVar, str, "", false);
            this.hnB.getController().startPlayAnimation();
            this.hnz.setReplyTimeVisible(false);
            this.hnz.setNeedAddReplyIcon(true);
            this.hnz.setIsBarViewVisible(false);
            this.hnz.setCommentNumEnable(false);
            this.hnz.setOnClickListener(this);
            this.hnz.setLiveShareEnable(false);
            this.hnz.setShareVisible(true);
            this.hnz.setShowPraiseNum(true);
            this.hnz.setNeedAddPraiseIcon(true);
            this.hnz.setFrom(2);
            if (this.hnz.setData(bzVar)) {
                this.hnA.setVisibility(8);
            } else {
                this.hnA.setVisibility(0);
            }
            W(bzVar);
        }
    }

    public void o(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.hnz != null && this.hny != null) {
            this.hny.setPageUniqueId(bdUniqueId);
        }
    }

    private void W(bz bzVar) {
        this.hnz.onChangeSkinType();
        this.hny.onChangeSkinType();
        this.hnB.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.hnx.setBackgroundDrawable(ao.qe(R.color.CAM_X0205));
        ao.setBackgroundColor(this.dDI, R.color.CAM_X0204);
        if (bzVar != null && m.Jp(bzVar.getId())) {
            ao.setViewTextColor(this.mTextTitle, R.color.CAM_X0109);
        } else {
            ao.setViewTextColor(this.mTextTitle, R.color.CAM_X0105);
        }
    }

    public void a(c cVar) {
        this.hnC = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.hnx || view == this.hnz.getCommentContainer()) {
            if (this.aim != null) {
                m.Jo(this.aim.getId());
            }
            if (this.hnC != null) {
                this.hnC.c(view, this.aim);
            }
        } else if (view.getId() == R.id.video_container && this.hnC != null) {
            this.hnC.c(view, this.aim);
        }
    }
}
