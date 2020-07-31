package com.baidu.tieba.ala.livecard.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadUserInfoLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ala.AlaVideoContainer;
import com.baidu.tieba.card.m;
/* loaded from: classes4.dex */
public class d implements View.OnClickListener {
    private bv aeA;
    private final View.OnClickListener ahD = new View.OnClickListener() { // from class: com.baidu.tieba.ala.livecard.a.d.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (d.this.fXe != null) {
                d.this.fXe.d(view, d.this.aeA);
            }
        }
    };
    public RelativeLayout fWZ;
    public ThreadUserInfoLayout fXa;
    public ThreadCommentAndPraiseInfoLayout fXb;
    public View fXc;
    public AlaVideoContainer fXd;
    private com.baidu.tieba.ala.livecard.vc.c fXe;
    public View mDivider;
    private String mForumName;
    public TextView mTextTitle;
    private View rootView;

    public d(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.rootView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.frs_ala_stage_live_item, (ViewGroup) null);
        this.fWZ = (RelativeLayout) this.rootView.findViewById(R.id.layout_root);
        this.fXa = (ThreadUserInfoLayout) this.rootView.findViewById(R.id.card_frs_ala_video_user_info_layout);
        this.fXa.setFrom(3);
        this.mTextTitle = (TextView) this.rootView.findViewById(R.id.text_title);
        this.fXd = (AlaVideoContainer) this.rootView.findViewById(R.id.ala_video_container);
        this.fXc = this.rootView.findViewById(R.id.divider_below_reply_number_layout);
        this.fXb = (ThreadCommentAndPraiseInfoLayout) this.rootView.findViewById(R.id.text_bottom);
        this.mDivider = this.rootView.findViewById(R.id.divider_line);
        this.fWZ.setOnClickListener(this);
        this.fXb.setOnClickListener(this);
        this.fXb.getCommentContainer().setOnClickListener(this);
        this.fXd.setOnVideoClickListener(this);
    }

    public View getRootView() {
        return this.rootView;
    }

    public void refreshView() {
        if (this.aeA != null && this.aeA.aWl() != null) {
            k(this.aeA, this.mForumName);
        }
    }

    public void k(bv bvVar, String str) {
        if (bvVar != null && bvVar.aWl() != null) {
            this.aeA = bvVar;
            this.mForumName = str;
            this.fWZ.setVisibility(0);
            this.fXa.setData(bvVar);
            if (this.fXa.getHeaderImg() != null) {
                this.fXa.getHeaderImg().setData(bvVar);
            }
            this.fXa.setUserAfterClickListener(this.ahD);
            bvVar.w(false, true);
            this.mTextTitle.setText(bvVar.aWV());
            this.fXd.getController().a(bvVar, str, "", false);
            this.fXd.getController().startPlayAnimation();
            this.fXb.setReplyTimeVisible(false);
            this.fXb.setNeedAddReplyIcon(true);
            this.fXb.setIsBarViewVisible(false);
            this.fXb.setCommentNumEnable(false);
            this.fXb.setOnClickListener(this);
            this.fXb.setLiveShareEnable(false);
            this.fXb.setShareVisible(true);
            this.fXb.setShowPraiseNum(true);
            this.fXb.setNeedAddPraiseIcon(true);
            this.fXb.setFrom(2);
            if (this.fXb.setData(bvVar)) {
                this.fXc.setVisibility(8);
            } else {
                this.fXc.setVisibility(0);
            }
            T(bvVar);
        }
    }

    public void p(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.fXb != null && this.fXa != null) {
            this.fXa.setPageUniqueId(bdUniqueId);
        }
    }

    private void T(bv bvVar) {
        this.fXb.onChangeSkinType();
        this.fXa.onChangeSkinType();
        this.fXd.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.fWZ.setBackgroundDrawable(ao.lM(R.color.cp_bg_line_e));
        ao.setBackgroundColor(this.mDivider, R.color.cp_bg_line_c);
        if (bvVar != null && m.EA(bvVar.getId())) {
            ao.setViewTextColor(this.mTextTitle, R.color.cp_cont_d);
        } else {
            ao.setViewTextColor(this.mTextTitle, R.color.cp_cont_b);
        }
    }

    public void a(com.baidu.tieba.ala.livecard.vc.c cVar) {
        this.fXe = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.fWZ || view == this.fXb.getCommentContainer()) {
            if (this.aeA != null) {
                m.Ez(this.aeA.getId());
            }
            if (this.fXe != null) {
                this.fXe.c(view, this.aeA);
            }
        } else if (view.getId() == R.id.video_container && this.fXe != null) {
            this.fXe.c(view, this.aeA);
        }
    }
}
