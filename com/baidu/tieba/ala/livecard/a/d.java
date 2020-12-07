package com.baidu.tieba.ala.livecard.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadUserInfoLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ala.AlaVideoContainer;
import com.baidu.tieba.card.n;
/* loaded from: classes6.dex */
public class d implements View.OnClickListener {
    private by ahA;
    private final View.OnClickListener akI = new View.OnClickListener() { // from class: com.baidu.tieba.ala.livecard.a.d.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (d.this.hbO != null) {
                d.this.hbO.d(view, d.this.ahA);
            }
        }
    };
    public RelativeLayout hbJ;
    public ThreadUserInfoLayout hbK;
    public ThreadCommentAndPraiseInfoLayout hbL;
    public View hbM;
    public AlaVideoContainer hbN;
    private com.baidu.tieba.ala.livecard.vc.c hbO;
    public View mDivider;
    private String mForumName;
    public TextView mTextTitle;
    private View rootView;

    public d(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.rootView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.frs_ala_stage_live_item, (ViewGroup) null);
        this.hbJ = (RelativeLayout) this.rootView.findViewById(R.id.layout_root);
        this.hbK = (ThreadUserInfoLayout) this.rootView.findViewById(R.id.card_frs_ala_video_user_info_layout);
        this.hbK.setFrom(3);
        this.mTextTitle = (TextView) this.rootView.findViewById(R.id.text_title);
        this.hbN = (AlaVideoContainer) this.rootView.findViewById(R.id.ala_video_container);
        this.hbM = this.rootView.findViewById(R.id.divider_below_reply_number_layout);
        this.hbL = (ThreadCommentAndPraiseInfoLayout) this.rootView.findViewById(R.id.text_bottom);
        this.mDivider = this.rootView.findViewById(R.id.divider_line);
        this.hbJ.setOnClickListener(this);
        this.hbL.setOnClickListener(this);
        this.hbL.getCommentContainer().setOnClickListener(this);
        this.hbN.setOnVideoClickListener(this);
    }

    public View getRootView() {
        return this.rootView;
    }

    public void refreshView() {
        if (this.ahA != null && this.ahA.boP() != null) {
            k(this.ahA, this.mForumName);
        }
    }

    public void k(by byVar, String str) {
        if (byVar != null && byVar.boP() != null) {
            this.ahA = byVar;
            this.mForumName = str;
            this.hbJ.setVisibility(0);
            this.hbK.setData(byVar);
            if (this.hbK.getHeaderImg() != null) {
                this.hbK.getHeaderImg().setData(byVar);
            }
            this.hbK.setUserAfterClickListener(this.akI);
            byVar.z(false, true);
            this.mTextTitle.setText(byVar.bpz());
            this.hbN.getController().a(byVar, str, "", false);
            this.hbN.getController().startPlayAnimation();
            this.hbL.setReplyTimeVisible(false);
            this.hbL.setNeedAddReplyIcon(true);
            this.hbL.setIsBarViewVisible(false);
            this.hbL.setCommentNumEnable(false);
            this.hbL.setOnClickListener(this);
            this.hbL.setLiveShareEnable(false);
            this.hbL.setShareVisible(true);
            this.hbL.setShowPraiseNum(true);
            this.hbL.setNeedAddPraiseIcon(true);
            this.hbL.setFrom(2);
            if (this.hbL.setData(byVar)) {
                this.hbM.setVisibility(8);
            } else {
                this.hbM.setVisibility(0);
            }
            W(byVar);
        }
    }

    public void o(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.hbL != null && this.hbK != null) {
            this.hbK.setPageUniqueId(bdUniqueId);
        }
    }

    private void W(by byVar) {
        this.hbL.onChangeSkinType();
        this.hbK.onChangeSkinType();
        this.hbN.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.hbJ.setBackgroundDrawable(ap.pT(R.color.CAM_X0205));
        ap.setBackgroundColor(this.mDivider, R.color.CAM_X0204);
        if (byVar != null && n.Jr(byVar.getId())) {
            ap.setViewTextColor(this.mTextTitle, R.color.CAM_X0109);
        } else {
            ap.setViewTextColor(this.mTextTitle, R.color.CAM_X0105);
        }
    }

    public void a(com.baidu.tieba.ala.livecard.vc.c cVar) {
        this.hbO = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.hbJ || view == this.hbL.getCommentContainer()) {
            if (this.ahA != null) {
                n.Jq(this.ahA.getId());
            }
            if (this.hbO != null) {
                this.hbO.c(view, this.ahA);
            }
        } else if (view.getId() == R.id.video_container && this.hbO != null) {
            this.hbO.c(view, this.ahA);
        }
    }
}
