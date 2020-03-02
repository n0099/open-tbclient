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
            if (d.this.eNp != null) {
                d.this.eNp.c(view, d.this.KJ);
            }
        }
    };
    public RelativeLayout eNk;
    public ThreadUserInfoLayout eNl;
    public ThreadCommentAndPraiseInfoLayout eNm;
    public View eNn;
    public AlaVideoContainer eNo;
    private com.baidu.tieba.ala.livecard.vc.c eNp;
    public View mDivider;
    private String mForumName;
    public TextView mTextTitle;
    private View rootView;

    public d(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.rootView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.frs_ala_stage_live_item, (ViewGroup) null);
        this.eNk = (RelativeLayout) this.rootView.findViewById(R.id.layout_root);
        this.eNl = (ThreadUserInfoLayout) this.rootView.findViewById(R.id.card_frs_ala_video_user_info_layout);
        this.eNl.setFrom(3);
        this.mTextTitle = (TextView) this.rootView.findViewById(R.id.text_title);
        this.eNo = (AlaVideoContainer) this.rootView.findViewById(R.id.ala_video_container);
        this.eNn = this.rootView.findViewById(R.id.divider_below_reply_number_layout);
        this.eNm = (ThreadCommentAndPraiseInfoLayout) this.rootView.findViewById(R.id.text_bottom);
        this.mDivider = this.rootView.findViewById(R.id.divider_line);
        this.eNk.setOnClickListener(this);
        this.eNm.setOnClickListener(this);
        this.eNm.getCommentContainer().setOnClickListener(this);
        this.eNo.setOnVideoClickListener(this);
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
            this.eNk.setVisibility(0);
            this.eNl.setData(bjVar);
            if (this.eNl.getHeaderImg() != null) {
                this.eNl.getHeaderImg().setData(bjVar);
            }
            this.eNl.setUserAfterClickListener(this.Nw);
            bjVar.s(false, true);
            this.mTextTitle.setText(bjVar.aCV());
            this.eNo.getController().a(bjVar, str, "", false);
            this.eNo.getController().startPlayAnimation();
            this.eNm.setReplyTimeVisible(false);
            this.eNm.setNeedAddReplyIcon(true);
            this.eNm.setIsBarViewVisible(false);
            this.eNm.setCommentNumEnable(false);
            this.eNm.setOnClickListener(this);
            this.eNm.setLiveShareEnable(false);
            this.eNm.setShareVisible(true);
            this.eNm.setShowPraiseNum(true);
            this.eNm.setNeedAddPraiseIcon(true);
            this.eNm.setFrom(2);
            if (this.eNm.setData(bjVar)) {
                this.eNn.setVisibility(8);
            } else {
                this.eNn.setVisibility(0);
            }
            T(bjVar);
        }
    }

    public void m(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.eNm != null && this.eNl != null) {
            this.eNl.setPageUniqueId(bdUniqueId);
        }
    }

    private void T(bj bjVar) {
        this.eNm.onChangeSkinType();
        this.eNl.onChangeSkinType();
        this.eNo.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.eNk.setBackgroundDrawable(am.kv(R.color.cp_bg_line_e));
        am.setBackgroundColor(this.mDivider, R.color.cp_bg_line_c);
        if (bjVar != null && l.zT(bjVar.getId())) {
            am.setViewTextColor(this.mTextTitle, (int) R.color.cp_cont_d);
        } else {
            am.setViewTextColor(this.mTextTitle, (int) R.color.cp_cont_b);
        }
    }

    public void a(com.baidu.tieba.ala.livecard.vc.c cVar) {
        this.eNp = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.eNk || view == this.eNm.getCommentContainer()) {
            if (this.KJ != null) {
                l.zS(this.KJ.getId());
            }
            if (this.eNp != null) {
                this.eNp.b(view, this.KJ);
            }
        } else if (view.getId() == R.id.video_container && this.eNp != null) {
            this.eNp.b(view, this.KJ);
        }
    }
}
