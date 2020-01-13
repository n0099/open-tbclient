package com.baidu.tieba.ala.livecard.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadUserInfoLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ala.AlaVideoContainer;
import com.baidu.tieba.card.l;
/* loaded from: classes2.dex */
public class d implements View.OnClickListener {
    private bj Kn;
    private final View.OnClickListener MX = new View.OnClickListener() { // from class: com.baidu.tieba.ala.livecard.a.d.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (d.this.eJu != null) {
                d.this.eJu.c(view, d.this.Kn);
            }
        }
    };
    public RelativeLayout eJp;
    public ThreadUserInfoLayout eJq;
    public ThreadCommentAndPraiseInfoLayout eJr;
    public View eJs;
    public AlaVideoContainer eJt;
    private com.baidu.tieba.ala.livecard.vc.c eJu;
    public View mDivider;
    private String mForumName;
    public TextView mTextTitle;
    private View rootView;

    public d(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.rootView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.frs_ala_stage_live_item, (ViewGroup) null);
        this.eJp = (RelativeLayout) this.rootView.findViewById(R.id.layout_root);
        this.eJq = (ThreadUserInfoLayout) this.rootView.findViewById(R.id.card_frs_ala_video_user_info_layout);
        this.eJq.setFrom(3);
        this.mTextTitle = (TextView) this.rootView.findViewById(R.id.text_title);
        this.eJt = (AlaVideoContainer) this.rootView.findViewById(R.id.ala_video_container);
        this.eJs = this.rootView.findViewById(R.id.divider_below_reply_number_layout);
        this.eJr = (ThreadCommentAndPraiseInfoLayout) this.rootView.findViewById(R.id.text_bottom);
        this.mDivider = this.rootView.findViewById(R.id.divider_line);
        this.eJp.setOnClickListener(this);
        this.eJr.setOnClickListener(this);
        this.eJr.getCommentContainer().setOnClickListener(this);
        this.eJt.setOnVideoClickListener(this);
    }

    public View getRootView() {
        return this.rootView;
    }

    public void refreshView() {
        if (this.Kn != null && this.Kn.azX() != null) {
            d(this.Kn, this.mForumName);
        }
    }

    public void d(bj bjVar, String str) {
        if (bjVar != null && bjVar.azX() != null) {
            this.Kn = bjVar;
            this.mForumName = str;
            this.eJp.setVisibility(0);
            this.eJq.setData(bjVar);
            if (this.eJq.getHeaderImg() != null) {
                this.eJq.getHeaderImg().setData(bjVar);
            }
            this.eJq.setUserAfterClickListener(this.MX);
            bjVar.p(false, true);
            this.mTextTitle.setText(bjVar.aAE());
            this.eJt.getController().a(bjVar, str, "", false);
            this.eJt.getController().startPlayAnimation();
            this.eJr.setReplyTimeVisible(false);
            this.eJr.setNeedAddReplyIcon(true);
            this.eJr.setIsBarViewVisible(false);
            this.eJr.setCommentNumEnable(false);
            this.eJr.setOnClickListener(this);
            this.eJr.setLiveShareEnable(false);
            this.eJr.setShareVisible(true);
            this.eJr.setShowPraiseNum(true);
            this.eJr.setNeedAddPraiseIcon(true);
            this.eJr.setFrom(2);
            if (this.eJr.setData(bjVar)) {
                this.eJs.setVisibility(8);
            } else {
                this.eJs.setVisibility(0);
            }
            S(bjVar);
        }
    }

    public void m(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.eJr != null && this.eJq != null) {
            this.eJq.setPageUniqueId(bdUniqueId);
        }
    }

    private void S(bj bjVar) {
        this.eJr.onChangeSkinType();
        this.eJq.onChangeSkinType();
        this.eJt.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.eJp.setBackgroundDrawable(am.ke(R.color.cp_bg_line_e));
        am.setBackgroundColor(this.mDivider, R.color.cp_bg_line_c);
        if (bjVar != null && l.zD(bjVar.getId())) {
            am.setViewTextColor(this.mTextTitle, (int) R.color.cp_cont_d);
        } else {
            am.setViewTextColor(this.mTextTitle, (int) R.color.cp_cont_b);
        }
    }

    public void a(com.baidu.tieba.ala.livecard.vc.c cVar) {
        this.eJu = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.eJp || view == this.eJr.getCommentContainer()) {
            if (this.Kn != null) {
                l.zC(this.Kn.getId());
            }
            if (this.eJu != null) {
                this.eJu.b(view, this.Kn);
            }
        } else if (view.getId() == R.id.video_container && this.eJu != null) {
            this.eJu.b(view, this.Kn);
        }
    }
}
