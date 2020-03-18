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
/* loaded from: classes3.dex */
public class d implements View.OnClickListener {
    private bj KJ;
    private final View.OnClickListener Nx = new View.OnClickListener() { // from class: com.baidu.tieba.ala.livecard.a.d.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (d.this.eOa != null) {
                d.this.eOa.c(view, d.this.KJ);
            }
        }
    };
    public RelativeLayout eNV;
    public ThreadUserInfoLayout eNW;
    public ThreadCommentAndPraiseInfoLayout eNX;
    public View eNY;
    public AlaVideoContainer eNZ;
    private com.baidu.tieba.ala.livecard.vc.c eOa;
    public View mDivider;
    private String mForumName;
    public TextView mTextTitle;
    private View rootView;

    public d(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.rootView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.frs_ala_stage_live_item, (ViewGroup) null);
        this.eNV = (RelativeLayout) this.rootView.findViewById(R.id.layout_root);
        this.eNW = (ThreadUserInfoLayout) this.rootView.findViewById(R.id.card_frs_ala_video_user_info_layout);
        this.eNW.setFrom(3);
        this.mTextTitle = (TextView) this.rootView.findViewById(R.id.text_title);
        this.eNZ = (AlaVideoContainer) this.rootView.findViewById(R.id.ala_video_container);
        this.eNY = this.rootView.findViewById(R.id.divider_below_reply_number_layout);
        this.eNX = (ThreadCommentAndPraiseInfoLayout) this.rootView.findViewById(R.id.text_bottom);
        this.mDivider = this.rootView.findViewById(R.id.divider_line);
        this.eNV.setOnClickListener(this);
        this.eNX.setOnClickListener(this);
        this.eNX.getCommentContainer().setOnClickListener(this);
        this.eNZ.setOnVideoClickListener(this);
    }

    public View getRootView() {
        return this.rootView;
    }

    public void refreshView() {
        if (this.KJ != null && this.KJ.aCr() != null) {
            d(this.KJ, this.mForumName);
        }
    }

    public void d(bj bjVar, String str) {
        if (bjVar != null && bjVar.aCr() != null) {
            this.KJ = bjVar;
            this.mForumName = str;
            this.eNV.setVisibility(0);
            this.eNW.setData(bjVar);
            if (this.eNW.getHeaderImg() != null) {
                this.eNW.getHeaderImg().setData(bjVar);
            }
            this.eNW.setUserAfterClickListener(this.Nx);
            bjVar.t(false, true);
            this.mTextTitle.setText(bjVar.aCY());
            this.eNZ.getController().a(bjVar, str, "", false);
            this.eNZ.getController().startPlayAnimation();
            this.eNX.setReplyTimeVisible(false);
            this.eNX.setNeedAddReplyIcon(true);
            this.eNX.setIsBarViewVisible(false);
            this.eNX.setCommentNumEnable(false);
            this.eNX.setOnClickListener(this);
            this.eNX.setLiveShareEnable(false);
            this.eNX.setShareVisible(true);
            this.eNX.setShowPraiseNum(true);
            this.eNX.setNeedAddPraiseIcon(true);
            this.eNX.setFrom(2);
            if (this.eNX.setData(bjVar)) {
                this.eNY.setVisibility(8);
            } else {
                this.eNY.setVisibility(0);
            }
            U(bjVar);
        }
    }

    public void m(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.eNX != null && this.eNW != null) {
            this.eNW.setPageUniqueId(bdUniqueId);
        }
    }

    private void U(bj bjVar) {
        this.eNX.onChangeSkinType();
        this.eNW.onChangeSkinType();
        this.eNZ.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.eNV.setBackgroundDrawable(am.kv(R.color.cp_bg_line_e));
        am.setBackgroundColor(this.mDivider, R.color.cp_bg_line_c);
        if (bjVar != null && l.zV(bjVar.getId())) {
            am.setViewTextColor(this.mTextTitle, (int) R.color.cp_cont_d);
        } else {
            am.setViewTextColor(this.mTextTitle, (int) R.color.cp_cont_b);
        }
    }

    public void a(com.baidu.tieba.ala.livecard.vc.c cVar) {
        this.eOa = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.eNV || view == this.eNX.getCommentContainer()) {
            if (this.KJ != null) {
                l.zU(this.KJ.getId());
            }
            if (this.eOa != null) {
                this.eOa.b(view, this.KJ);
            }
        } else if (view.getId() == R.id.video_container && this.eOa != null) {
            this.eOa.b(view, this.KJ);
        }
    }
}
