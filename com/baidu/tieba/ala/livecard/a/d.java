package com.baidu.tieba.ala.livecard.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadUserInfoLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ala.AlaVideoContainer;
import com.baidu.tieba.card.n;
/* loaded from: classes4.dex */
public class d implements View.OnClickListener {
    private bx agB;
    private final View.OnClickListener ajJ = new View.OnClickListener() { // from class: com.baidu.tieba.ala.livecard.a.d.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (d.this.gSB != null) {
                d.this.gSB.d(view, d.this.agB);
            }
        }
    };
    public AlaVideoContainer gSA;
    private com.baidu.tieba.ala.livecard.vc.c gSB;
    public RelativeLayout gSw;
    public ThreadUserInfoLayout gSx;
    public ThreadCommentAndPraiseInfoLayout gSy;
    public View gSz;
    public View mDivider;
    private String mForumName;
    public TextView mTextTitle;
    private View rootView;

    public d(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.rootView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.frs_ala_stage_live_item, (ViewGroup) null);
        this.gSw = (RelativeLayout) this.rootView.findViewById(R.id.layout_root);
        this.gSx = (ThreadUserInfoLayout) this.rootView.findViewById(R.id.card_frs_ala_video_user_info_layout);
        this.gSx.setFrom(3);
        this.mTextTitle = (TextView) this.rootView.findViewById(R.id.text_title);
        this.gSA = (AlaVideoContainer) this.rootView.findViewById(R.id.ala_video_container);
        this.gSz = this.rootView.findViewById(R.id.divider_below_reply_number_layout);
        this.gSy = (ThreadCommentAndPraiseInfoLayout) this.rootView.findViewById(R.id.text_bottom);
        this.mDivider = this.rootView.findViewById(R.id.divider_line);
        this.gSw.setOnClickListener(this);
        this.gSy.setOnClickListener(this);
        this.gSy.getCommentContainer().setOnClickListener(this);
        this.gSA.setOnVideoClickListener(this);
    }

    public View getRootView() {
        return this.rootView;
    }

    public void refreshView() {
        if (this.agB != null && this.agB.blC() != null) {
            k(this.agB, this.mForumName);
        }
    }

    public void k(bx bxVar, String str) {
        if (bxVar != null && bxVar.blC() != null) {
            this.agB = bxVar;
            this.mForumName = str;
            this.gSw.setVisibility(0);
            this.gSx.setData(bxVar);
            if (this.gSx.getHeaderImg() != null) {
                this.gSx.getHeaderImg().setData(bxVar);
            }
            this.gSx.setUserAfterClickListener(this.ajJ);
            bxVar.z(false, true);
            this.mTextTitle.setText(bxVar.bmm());
            this.gSA.getController().a(bxVar, str, "", false);
            this.gSA.getController().startPlayAnimation();
            this.gSy.setReplyTimeVisible(false);
            this.gSy.setNeedAddReplyIcon(true);
            this.gSy.setIsBarViewVisible(false);
            this.gSy.setCommentNumEnable(false);
            this.gSy.setOnClickListener(this);
            this.gSy.setLiveShareEnable(false);
            this.gSy.setShareVisible(true);
            this.gSy.setShowPraiseNum(true);
            this.gSy.setNeedAddPraiseIcon(true);
            this.gSy.setFrom(2);
            if (this.gSy.setData(bxVar)) {
                this.gSz.setVisibility(8);
            } else {
                this.gSz.setVisibility(0);
            }
            W(bxVar);
        }
    }

    public void o(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.gSy != null && this.gSx != null) {
            this.gSx.setPageUniqueId(bdUniqueId);
        }
    }

    private void W(bx bxVar) {
        this.gSy.onChangeSkinType();
        this.gSx.onChangeSkinType();
        this.gSA.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.gSw.setBackgroundDrawable(ap.pt(R.color.CAM_X0205));
        ap.setBackgroundColor(this.mDivider, R.color.CAM_X0204);
        if (bxVar != null && n.IB(bxVar.getId())) {
            ap.setViewTextColor(this.mTextTitle, R.color.CAM_X0109);
        } else {
            ap.setViewTextColor(this.mTextTitle, R.color.CAM_X0105);
        }
    }

    public void a(com.baidu.tieba.ala.livecard.vc.c cVar) {
        this.gSB = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.gSw || view == this.gSy.getCommentContainer()) {
            if (this.agB != null) {
                n.IA(this.agB.getId());
            }
            if (this.gSB != null) {
                this.gSB.c(view, this.agB);
            }
        } else if (view.getId() == R.id.video_container && this.gSB != null) {
            this.gSB.c(view, this.agB);
        }
    }
}
