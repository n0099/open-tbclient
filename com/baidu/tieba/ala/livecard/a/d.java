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
            if (d.this.fGC != null) {
                d.this.fGC.d(view, d.this.aee);
            }
        }
    };
    public View fGA;
    public AlaVideoContainer fGB;
    private com.baidu.tieba.ala.livecard.vc.c fGC;
    public RelativeLayout fGx;
    public ThreadUserInfoLayout fGy;
    public ThreadCommentAndPraiseInfoLayout fGz;
    public View mDivider;
    private String mForumName;
    public TextView mTextTitle;
    private View rootView;

    public d(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.rootView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.frs_ala_stage_live_item, (ViewGroup) null);
        this.fGx = (RelativeLayout) this.rootView.findViewById(R.id.layout_root);
        this.fGy = (ThreadUserInfoLayout) this.rootView.findViewById(R.id.card_frs_ala_video_user_info_layout);
        this.fGy.setFrom(3);
        this.mTextTitle = (TextView) this.rootView.findViewById(R.id.text_title);
        this.fGB = (AlaVideoContainer) this.rootView.findViewById(R.id.ala_video_container);
        this.fGA = this.rootView.findViewById(R.id.divider_below_reply_number_layout);
        this.fGz = (ThreadCommentAndPraiseInfoLayout) this.rootView.findViewById(R.id.text_bottom);
        this.mDivider = this.rootView.findViewById(R.id.divider_line);
        this.fGx.setOnClickListener(this);
        this.fGz.setOnClickListener(this);
        this.fGz.getCommentContainer().setOnClickListener(this);
        this.fGB.setOnVideoClickListener(this);
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
            this.fGx.setVisibility(0);
            this.fGy.setData(bkVar);
            if (this.fGy.getHeaderImg() != null) {
                this.fGy.getHeaderImg().setData(bkVar);
            }
            this.fGy.setUserAfterClickListener(this.agI);
            bkVar.v(false, true);
            this.mTextTitle.setText(bkVar.aRi());
            this.fGB.getController().a(bkVar, str, "", false);
            this.fGB.getController().startPlayAnimation();
            this.fGz.setReplyTimeVisible(false);
            this.fGz.setNeedAddReplyIcon(true);
            this.fGz.setIsBarViewVisible(false);
            this.fGz.setCommentNumEnable(false);
            this.fGz.setOnClickListener(this);
            this.fGz.setLiveShareEnable(false);
            this.fGz.setShareVisible(true);
            this.fGz.setShowPraiseNum(true);
            this.fGz.setNeedAddPraiseIcon(true);
            this.fGz.setFrom(2);
            if (this.fGz.setData(bkVar)) {
                this.fGA.setVisibility(8);
            } else {
                this.fGA.setVisibility(0);
            }
            V(bkVar);
        }
    }

    public void o(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.fGz != null && this.fGy != null) {
            this.fGy.setPageUniqueId(bdUniqueId);
        }
    }

    private void V(bk bkVar) {
        this.fGz.onChangeSkinType();
        this.fGy.onChangeSkinType();
        this.fGB.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.fGx.setBackgroundDrawable(am.le(R.color.cp_bg_line_e));
        am.setBackgroundColor(this.mDivider, R.color.cp_bg_line_c);
        if (bkVar != null && m.Do(bkVar.getId())) {
            am.setViewTextColor(this.mTextTitle, (int) R.color.cp_cont_d);
        } else {
            am.setViewTextColor(this.mTextTitle, (int) R.color.cp_cont_b);
        }
    }

    public void a(com.baidu.tieba.ala.livecard.vc.c cVar) {
        this.fGC = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.fGx || view == this.fGz.getCommentContainer()) {
            if (this.aee != null) {
                m.Dn(this.aee.getId());
            }
            if (this.fGC != null) {
                this.fGC.c(view, this.aee);
            }
        } else if (view.getId() == R.id.video_container && this.fGC != null) {
            this.fGC.c(view, this.aee);
        }
    }
}
