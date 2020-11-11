package com.baidu.tieba.ala.livecard.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadUserInfoLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ala.AlaVideoContainer;
import com.baidu.tieba.card.n;
/* loaded from: classes4.dex */
public class d implements View.OnClickListener {
    private bw agx;
    private final View.OnClickListener ajG = new View.OnClickListener() { // from class: com.baidu.tieba.ala.livecard.a.d.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (d.this.gSU != null) {
                d.this.gSU.d(view, d.this.agx);
            }
        }
    };
    public RelativeLayout gSP;
    public ThreadUserInfoLayout gSQ;
    public ThreadCommentAndPraiseInfoLayout gSR;
    public View gSS;
    public AlaVideoContainer gST;
    private com.baidu.tieba.ala.livecard.vc.c gSU;
    public View mDivider;
    private String mForumName;
    public TextView mTextTitle;
    private View rootView;

    public d(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.rootView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.frs_ala_stage_live_item, (ViewGroup) null);
        this.gSP = (RelativeLayout) this.rootView.findViewById(R.id.layout_root);
        this.gSQ = (ThreadUserInfoLayout) this.rootView.findViewById(R.id.card_frs_ala_video_user_info_layout);
        this.gSQ.setFrom(3);
        this.mTextTitle = (TextView) this.rootView.findViewById(R.id.text_title);
        this.gST = (AlaVideoContainer) this.rootView.findViewById(R.id.ala_video_container);
        this.gSS = this.rootView.findViewById(R.id.divider_below_reply_number_layout);
        this.gSR = (ThreadCommentAndPraiseInfoLayout) this.rootView.findViewById(R.id.text_bottom);
        this.mDivider = this.rootView.findViewById(R.id.divider_line);
        this.gSP.setOnClickListener(this);
        this.gSR.setOnClickListener(this);
        this.gSR.getCommentContainer().setOnClickListener(this);
        this.gST.setOnVideoClickListener(this);
    }

    public View getRootView() {
        return this.rootView;
    }

    public void refreshView() {
        if (this.agx != null && this.agx.bmA() != null) {
            k(this.agx, this.mForumName);
        }
    }

    public void k(bw bwVar, String str) {
        if (bwVar != null && bwVar.bmA() != null) {
            this.agx = bwVar;
            this.mForumName = str;
            this.gSP.setVisibility(0);
            this.gSQ.setData(bwVar);
            if (this.gSQ.getHeaderImg() != null) {
                this.gSQ.getHeaderImg().setData(bwVar);
            }
            this.gSQ.setUserAfterClickListener(this.ajG);
            bwVar.z(false, true);
            this.mTextTitle.setText(bwVar.bnk());
            this.gST.getController().a(bwVar, str, "", false);
            this.gST.getController().startPlayAnimation();
            this.gSR.setReplyTimeVisible(false);
            this.gSR.setNeedAddReplyIcon(true);
            this.gSR.setIsBarViewVisible(false);
            this.gSR.setCommentNumEnable(false);
            this.gSR.setOnClickListener(this);
            this.gSR.setLiveShareEnable(false);
            this.gSR.setShareVisible(true);
            this.gSR.setShowPraiseNum(true);
            this.gSR.setNeedAddPraiseIcon(true);
            this.gSR.setFrom(2);
            if (this.gSR.setData(bwVar)) {
                this.gSS.setVisibility(8);
            } else {
                this.gSS.setVisibility(0);
            }
            U(bwVar);
        }
    }

    public void o(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.gSR != null && this.gSQ != null) {
            this.gSQ.setPageUniqueId(bdUniqueId);
        }
    }

    private void U(bw bwVar) {
        this.gSR.onChangeSkinType();
        this.gSQ.onChangeSkinType();
        this.gST.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.gSP.setBackgroundDrawable(ap.oX(R.color.cp_bg_line_e));
        ap.setBackgroundColor(this.mDivider, R.color.cp_bg_line_c);
        if (bwVar != null && n.Ja(bwVar.getId())) {
            ap.setViewTextColor(this.mTextTitle, (int) R.color.cp_cont_d);
        } else {
            ap.setViewTextColor(this.mTextTitle, (int) R.color.cp_cont_b);
        }
    }

    public void a(com.baidu.tieba.ala.livecard.vc.c cVar) {
        this.gSU = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.gSP || view == this.gSR.getCommentContainer()) {
            if (this.agx != null) {
                n.IZ(this.agx.getId());
            }
            if (this.gSU != null) {
                this.gSU.c(view, this.agx);
            }
        } else if (view.getId() == R.id.video_container && this.gSU != null) {
            this.gSU.c(view, this.agx);
        }
    }
}
