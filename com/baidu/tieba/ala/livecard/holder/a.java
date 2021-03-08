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
/* loaded from: classes9.dex */
public class a implements View.OnClickListener {
    private cb aiB;
    private final View.OnClickListener alB = new View.OnClickListener() { // from class: com.baidu.tieba.ala.livecard.holder.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.hph != null) {
                a.this.hph.d(view, a.this.aiB);
            }
        }
    };
    public View dCC;
    public RelativeLayout hpc;
    public ThreadUserInfoLayout hpd;
    public ThreadCommentAndPraiseInfoLayout hpe;
    public View hpf;
    public AlaVideoContainer hpg;
    private c hph;
    private String mForumName;
    public TextView mTextTitle;
    private View rootView;

    public a(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.rootView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.frs_ala_stage_live_item, (ViewGroup) null);
        this.hpc = (RelativeLayout) this.rootView.findViewById(R.id.layout_root);
        this.hpd = (ThreadUserInfoLayout) this.rootView.findViewById(R.id.card_frs_ala_video_user_info_layout);
        this.hpd.setFrom(3);
        this.mTextTitle = (TextView) this.rootView.findViewById(R.id.text_title);
        this.hpg = (AlaVideoContainer) this.rootView.findViewById(R.id.ala_video_container);
        this.hpf = this.rootView.findViewById(R.id.divider_below_reply_number_layout);
        this.hpe = (ThreadCommentAndPraiseInfoLayout) this.rootView.findViewById(R.id.text_bottom);
        this.dCC = this.rootView.findViewById(R.id.divider_line);
        this.hpc.setOnClickListener(this);
        this.hpe.setOnClickListener(this);
        this.hpe.getCommentContainer().setOnClickListener(this);
        this.hpg.setOnVideoClickListener(this);
    }

    public View getRootView() {
        return this.rootView;
    }

    public void refreshView() {
        if (this.aiB != null && this.aiB.bnS() != null) {
            k(this.aiB, this.mForumName);
        }
    }

    public void k(cb cbVar, String str) {
        if (cbVar != null && cbVar.bnS() != null) {
            this.aiB = cbVar;
            this.mForumName = str;
            this.hpc.setVisibility(0);
            this.hpd.setData(cbVar);
            if (this.hpd.getHeaderImg() != null) {
                this.hpd.getHeaderImg().setData(cbVar);
            }
            this.hpd.setUserAfterClickListener(this.alB);
            cbVar.y(false, true);
            this.mTextTitle.setText(cbVar.boB());
            this.hpg.getController().a(cbVar, str, "", false);
            this.hpg.getController().startPlayAnimation();
            this.hpe.setReplyTimeVisible(false);
            this.hpe.setNeedAddReplyIcon(true);
            this.hpe.setIsBarViewVisible(false);
            this.hpe.setCommentNumEnable(false);
            this.hpe.setOnClickListener(this);
            this.hpe.setLiveShareEnable(false);
            this.hpe.setShareVisible(true);
            this.hpe.setShowPraiseNum(true);
            this.hpe.setNeedAddPraiseIcon(true);
            this.hpe.setFrom(2);
            if (this.hpe.setData(cbVar)) {
                this.hpf.setVisibility(8);
            } else {
                this.hpf.setVisibility(0);
            }
            X(cbVar);
        }
    }

    public void o(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.hpe != null && this.hpd != null) {
            this.hpd.setPageUniqueId(bdUniqueId);
        }
    }

    private void X(cb cbVar) {
        this.hpe.onChangeSkinType();
        this.hpd.onChangeSkinType();
        this.hpg.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.hpc.setBackgroundDrawable(ap.oD(R.color.CAM_X0205));
        ap.setBackgroundColor(this.dCC, R.color.CAM_X0204);
        if (cbVar != null && m.IX(cbVar.getId())) {
            ap.setViewTextColor(this.mTextTitle, R.color.CAM_X0109);
        } else {
            ap.setViewTextColor(this.mTextTitle, R.color.CAM_X0105);
        }
    }

    public void a(c cVar) {
        this.hph = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.hpc || view == this.hpe.getCommentContainer()) {
            if (this.aiB != null) {
                m.IW(this.aiB.getId());
            }
            if (this.hph != null) {
                this.hph.c(view, this.aiB);
            }
        } else if (view.getId() == R.id.video_container && this.hph != null) {
            this.hph.c(view, this.aiB);
        }
    }
}
