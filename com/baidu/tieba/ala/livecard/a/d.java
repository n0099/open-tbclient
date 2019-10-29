package com.baidu.tieba.ala.livecard.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadUserInfoLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ala.AlaVideoContainer;
import com.baidu.tieba.card.n;
/* loaded from: classes6.dex */
public class d implements View.OnClickListener {
    private bh FT;
    private final View.OnClickListener HO = new View.OnClickListener() { // from class: com.baidu.tieba.ala.livecard.a.d.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (d.this.dTu != null) {
                d.this.dTu.c(view, d.this.FT);
            }
        }
    };
    public View bhm;
    public RelativeLayout dTp;
    public ThreadUserInfoLayout dTq;
    public ThreadCommentAndPraiseInfoLayout dTr;
    public View dTs;
    public AlaVideoContainer dTt;
    private com.baidu.tieba.ala.livecard.vc.c dTu;
    private String mForumName;
    public TextView mTextTitle;
    private View rootView;

    public d(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.rootView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.frs_ala_stage_live_item, (ViewGroup) null);
        this.dTp = (RelativeLayout) this.rootView.findViewById(R.id.layout_root);
        this.dTq = (ThreadUserInfoLayout) this.rootView.findViewById(R.id.card_frs_ala_video_user_info_layout);
        this.dTq.setFrom(3);
        this.mTextTitle = (TextView) this.rootView.findViewById(R.id.text_title);
        this.dTt = (AlaVideoContainer) this.rootView.findViewById(R.id.ala_video_container);
        this.dTs = this.rootView.findViewById(R.id.divider_below_reply_number_layout);
        this.dTr = (ThreadCommentAndPraiseInfoLayout) this.rootView.findViewById(R.id.text_bottom);
        this.bhm = this.rootView.findViewById(R.id.divider_line);
        this.dTp.setOnClickListener(this);
        this.dTr.setOnClickListener(this);
        this.dTr.getCommentContainer().setOnClickListener(this);
        this.dTt.setOnVideoClickListener(this);
    }

    public View getRootView() {
        return this.rootView;
    }

    public void refreshView() {
        if (this.FT != null && this.FT.aiG() != null) {
            b(this.FT, this.mForumName);
        }
    }

    public void b(bh bhVar, String str) {
        if (bhVar != null && bhVar.aiG() != null) {
            this.FT = bhVar;
            this.mForumName = str;
            this.dTp.setVisibility(0);
            this.dTq.setData(bhVar);
            if (this.dTq.getHeaderImg() != null) {
                this.dTq.getHeaderImg().setData(bhVar);
            }
            this.dTq.setUserAfterClickListener(this.HO);
            bhVar.q(false, true);
            this.mTextTitle.setText(bhVar.ajm());
            this.dTt.getController().a(bhVar, str, "", false);
            this.dTt.getController().startPlayAnimation();
            this.dTr.setReplyTimeVisible(false);
            this.dTr.setNeedAddReplyIcon(true);
            this.dTr.setIsBarViewVisible(false);
            this.dTr.setCommentNumEnable(false);
            this.dTr.setOnClickListener(this);
            this.dTr.setLiveShareEnable(false);
            this.dTr.setShareVisible(true);
            this.dTr.setShowPraiseNum(true);
            this.dTr.setNeedAddPraiseIcon(true);
            this.dTr.setFrom(2);
            if (this.dTr.setData(bhVar)) {
                this.dTs.setVisibility(8);
            } else {
                this.dTs.setVisibility(0);
            }
            N(bhVar);
        }
    }

    public void l(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.dTr != null && this.dTq != null) {
            this.dTq.setPageUniqueId(bdUniqueId);
        }
    }

    private void N(bh bhVar) {
        this.dTr.onChangeSkinType();
        this.dTq.onChangeSkinType();
        this.dTt.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.dTp.setBackgroundDrawable(am.it(R.color.cp_bg_line_e));
        am.setBackgroundColor(this.bhm, R.color.cp_bg_line_c);
        if (bhVar != null && n.uA(bhVar.getId())) {
            am.setViewTextColor(this.mTextTitle, (int) R.color.cp_cont_d);
        } else {
            am.setViewTextColor(this.mTextTitle, (int) R.color.cp_cont_b);
        }
    }

    public void a(com.baidu.tieba.ala.livecard.vc.c cVar) {
        this.dTu = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.dTp || view == this.dTr.getCommentContainer()) {
            if (this.FT != null) {
                n.uz(this.FT.getId());
            }
            if (this.dTu != null) {
                this.dTu.b(view, this.FT);
            }
        } else if (view.getId() == R.id.video_container && this.dTu != null) {
            this.dTu.b(view, this.FT);
        }
    }
}
