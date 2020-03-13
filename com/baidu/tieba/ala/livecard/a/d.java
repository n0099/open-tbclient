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
    private final View.OnClickListener Nw = new View.OnClickListener() { // from class: com.baidu.tieba.ala.livecard.a.d.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (d.this.eNC != null) {
                d.this.eNC.c(view, d.this.KJ);
            }
        }
    };
    public View eNA;
    public AlaVideoContainer eNB;
    private com.baidu.tieba.ala.livecard.vc.c eNC;
    public RelativeLayout eNx;
    public ThreadUserInfoLayout eNy;
    public ThreadCommentAndPraiseInfoLayout eNz;
    public View mDivider;
    private String mForumName;
    public TextView mTextTitle;
    private View rootView;

    public d(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.rootView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.frs_ala_stage_live_item, (ViewGroup) null);
        this.eNx = (RelativeLayout) this.rootView.findViewById(R.id.layout_root);
        this.eNy = (ThreadUserInfoLayout) this.rootView.findViewById(R.id.card_frs_ala_video_user_info_layout);
        this.eNy.setFrom(3);
        this.mTextTitle = (TextView) this.rootView.findViewById(R.id.text_title);
        this.eNB = (AlaVideoContainer) this.rootView.findViewById(R.id.ala_video_container);
        this.eNA = this.rootView.findViewById(R.id.divider_below_reply_number_layout);
        this.eNz = (ThreadCommentAndPraiseInfoLayout) this.rootView.findViewById(R.id.text_bottom);
        this.mDivider = this.rootView.findViewById(R.id.divider_line);
        this.eNx.setOnClickListener(this);
        this.eNz.setOnClickListener(this);
        this.eNz.getCommentContainer().setOnClickListener(this);
        this.eNB.setOnVideoClickListener(this);
    }

    public View getRootView() {
        return this.rootView;
    }

    public void refreshView() {
        if (this.KJ != null && this.KJ.aCo() != null) {
            d(this.KJ, this.mForumName);
        }
    }

    public void d(bj bjVar, String str) {
        if (bjVar != null && bjVar.aCo() != null) {
            this.KJ = bjVar;
            this.mForumName = str;
            this.eNx.setVisibility(0);
            this.eNy.setData(bjVar);
            if (this.eNy.getHeaderImg() != null) {
                this.eNy.getHeaderImg().setData(bjVar);
            }
            this.eNy.setUserAfterClickListener(this.Nw);
            bjVar.t(false, true);
            this.mTextTitle.setText(bjVar.aCV());
            this.eNB.getController().a(bjVar, str, "", false);
            this.eNB.getController().startPlayAnimation();
            this.eNz.setReplyTimeVisible(false);
            this.eNz.setNeedAddReplyIcon(true);
            this.eNz.setIsBarViewVisible(false);
            this.eNz.setCommentNumEnable(false);
            this.eNz.setOnClickListener(this);
            this.eNz.setLiveShareEnable(false);
            this.eNz.setShareVisible(true);
            this.eNz.setShowPraiseNum(true);
            this.eNz.setNeedAddPraiseIcon(true);
            this.eNz.setFrom(2);
            if (this.eNz.setData(bjVar)) {
                this.eNA.setVisibility(8);
            } else {
                this.eNA.setVisibility(0);
            }
            T(bjVar);
        }
    }

    public void m(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.eNz != null && this.eNy != null) {
            this.eNy.setPageUniqueId(bdUniqueId);
        }
    }

    private void T(bj bjVar) {
        this.eNz.onChangeSkinType();
        this.eNy.onChangeSkinType();
        this.eNB.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.eNx.setBackgroundDrawable(am.kv(R.color.cp_bg_line_e));
        am.setBackgroundColor(this.mDivider, R.color.cp_bg_line_c);
        if (bjVar != null && l.zU(bjVar.getId())) {
            am.setViewTextColor(this.mTextTitle, (int) R.color.cp_cont_d);
        } else {
            am.setViewTextColor(this.mTextTitle, (int) R.color.cp_cont_b);
        }
    }

    public void a(com.baidu.tieba.ala.livecard.vc.c cVar) {
        this.eNC = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.eNx || view == this.eNz.getCommentContainer()) {
            if (this.KJ != null) {
                l.zT(this.KJ.getId());
            }
            if (this.eNC != null) {
                this.eNC.b(view, this.KJ);
            }
        } else if (view.getId() == R.id.video_container && this.eNC != null) {
            this.eNC.b(view, this.KJ);
        }
    }
}
