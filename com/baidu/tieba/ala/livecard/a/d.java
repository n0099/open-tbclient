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
            if (d.this.hbQ != null) {
                d.this.hbQ.d(view, d.this.ahA);
            }
        }
    };
    public RelativeLayout hbL;
    public ThreadUserInfoLayout hbM;
    public ThreadCommentAndPraiseInfoLayout hbN;
    public View hbO;
    public AlaVideoContainer hbP;
    private com.baidu.tieba.ala.livecard.vc.c hbQ;
    public View mDivider;
    private String mForumName;
    public TextView mTextTitle;
    private View rootView;

    public d(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.rootView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.frs_ala_stage_live_item, (ViewGroup) null);
        this.hbL = (RelativeLayout) this.rootView.findViewById(R.id.layout_root);
        this.hbM = (ThreadUserInfoLayout) this.rootView.findViewById(R.id.card_frs_ala_video_user_info_layout);
        this.hbM.setFrom(3);
        this.mTextTitle = (TextView) this.rootView.findViewById(R.id.text_title);
        this.hbP = (AlaVideoContainer) this.rootView.findViewById(R.id.ala_video_container);
        this.hbO = this.rootView.findViewById(R.id.divider_below_reply_number_layout);
        this.hbN = (ThreadCommentAndPraiseInfoLayout) this.rootView.findViewById(R.id.text_bottom);
        this.mDivider = this.rootView.findViewById(R.id.divider_line);
        this.hbL.setOnClickListener(this);
        this.hbN.setOnClickListener(this);
        this.hbN.getCommentContainer().setOnClickListener(this);
        this.hbP.setOnVideoClickListener(this);
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
            this.hbL.setVisibility(0);
            this.hbM.setData(byVar);
            if (this.hbM.getHeaderImg() != null) {
                this.hbM.getHeaderImg().setData(byVar);
            }
            this.hbM.setUserAfterClickListener(this.akI);
            byVar.z(false, true);
            this.mTextTitle.setText(byVar.bpz());
            this.hbP.getController().a(byVar, str, "", false);
            this.hbP.getController().startPlayAnimation();
            this.hbN.setReplyTimeVisible(false);
            this.hbN.setNeedAddReplyIcon(true);
            this.hbN.setIsBarViewVisible(false);
            this.hbN.setCommentNumEnable(false);
            this.hbN.setOnClickListener(this);
            this.hbN.setLiveShareEnable(false);
            this.hbN.setShareVisible(true);
            this.hbN.setShowPraiseNum(true);
            this.hbN.setNeedAddPraiseIcon(true);
            this.hbN.setFrom(2);
            if (this.hbN.setData(byVar)) {
                this.hbO.setVisibility(8);
            } else {
                this.hbO.setVisibility(0);
            }
            W(byVar);
        }
    }

    public void o(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.hbN != null && this.hbM != null) {
            this.hbM.setPageUniqueId(bdUniqueId);
        }
    }

    private void W(by byVar) {
        this.hbN.onChangeSkinType();
        this.hbM.onChangeSkinType();
        this.hbP.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.hbL.setBackgroundDrawable(ap.pT(R.color.CAM_X0205));
        ap.setBackgroundColor(this.mDivider, R.color.CAM_X0204);
        if (byVar != null && n.Jr(byVar.getId())) {
            ap.setViewTextColor(this.mTextTitle, (int) R.color.CAM_X0109);
        } else {
            ap.setViewTextColor(this.mTextTitle, (int) R.color.CAM_X0105);
        }
    }

    public void a(com.baidu.tieba.ala.livecard.vc.c cVar) {
        this.hbQ = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.hbL || view == this.hbN.getCommentContainer()) {
            if (this.ahA != null) {
                n.Jq(this.ahA.getId());
            }
            if (this.hbQ != null) {
                this.hbQ.c(view, this.ahA);
            }
        } else if (view.getId() == R.id.video_container && this.hbQ != null) {
            this.hbQ.c(view, this.ahA);
        }
    }
}
