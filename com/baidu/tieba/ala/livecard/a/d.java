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
            if (d.this.eNo != null) {
                d.this.eNo.c(view, d.this.KJ);
            }
        }
    };
    public RelativeLayout eNj;
    public ThreadUserInfoLayout eNk;
    public ThreadCommentAndPraiseInfoLayout eNl;
    public View eNm;
    public AlaVideoContainer eNn;
    private com.baidu.tieba.ala.livecard.vc.c eNo;
    public View mDivider;
    private String mForumName;
    public TextView mTextTitle;
    private View rootView;

    public d(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.rootView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.frs_ala_stage_live_item, (ViewGroup) null);
        this.eNj = (RelativeLayout) this.rootView.findViewById(R.id.layout_root);
        this.eNk = (ThreadUserInfoLayout) this.rootView.findViewById(R.id.card_frs_ala_video_user_info_layout);
        this.eNk.setFrom(3);
        this.mTextTitle = (TextView) this.rootView.findViewById(R.id.text_title);
        this.eNn = (AlaVideoContainer) this.rootView.findViewById(R.id.ala_video_container);
        this.eNm = this.rootView.findViewById(R.id.divider_below_reply_number_layout);
        this.eNl = (ThreadCommentAndPraiseInfoLayout) this.rootView.findViewById(R.id.text_bottom);
        this.mDivider = this.rootView.findViewById(R.id.divider_line);
        this.eNj.setOnClickListener(this);
        this.eNl.setOnClickListener(this);
        this.eNl.getCommentContainer().setOnClickListener(this);
        this.eNn.setOnVideoClickListener(this);
    }

    public View getRootView() {
        return this.rootView;
    }

    public void refreshView() {
        if (this.KJ != null && this.KJ.aCm() != null) {
            d(this.KJ, this.mForumName);
        }
    }

    public void d(bj bjVar, String str) {
        if (bjVar != null && bjVar.aCm() != null) {
            this.KJ = bjVar;
            this.mForumName = str;
            this.eNj.setVisibility(0);
            this.eNk.setData(bjVar);
            if (this.eNk.getHeaderImg() != null) {
                this.eNk.getHeaderImg().setData(bjVar);
            }
            this.eNk.setUserAfterClickListener(this.Nw);
            bjVar.s(false, true);
            this.mTextTitle.setText(bjVar.aCT());
            this.eNn.getController().a(bjVar, str, "", false);
            this.eNn.getController().startPlayAnimation();
            this.eNl.setReplyTimeVisible(false);
            this.eNl.setNeedAddReplyIcon(true);
            this.eNl.setIsBarViewVisible(false);
            this.eNl.setCommentNumEnable(false);
            this.eNl.setOnClickListener(this);
            this.eNl.setLiveShareEnable(false);
            this.eNl.setShareVisible(true);
            this.eNl.setShowPraiseNum(true);
            this.eNl.setNeedAddPraiseIcon(true);
            this.eNl.setFrom(2);
            if (this.eNl.setData(bjVar)) {
                this.eNm.setVisibility(8);
            } else {
                this.eNm.setVisibility(0);
            }
            T(bjVar);
        }
    }

    public void m(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.eNl != null && this.eNk != null) {
            this.eNk.setPageUniqueId(bdUniqueId);
        }
    }

    private void T(bj bjVar) {
        this.eNl.onChangeSkinType();
        this.eNk.onChangeSkinType();
        this.eNn.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.eNj.setBackgroundDrawable(am.kv(R.color.cp_bg_line_e));
        am.setBackgroundColor(this.mDivider, R.color.cp_bg_line_c);
        if (bjVar != null && l.zT(bjVar.getId())) {
            am.setViewTextColor(this.mTextTitle, (int) R.color.cp_cont_d);
        } else {
            am.setViewTextColor(this.mTextTitle, (int) R.color.cp_cont_b);
        }
    }

    public void a(com.baidu.tieba.ala.livecard.vc.c cVar) {
        this.eNo = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.eNj || view == this.eNl.getCommentContainer()) {
            if (this.KJ != null) {
                l.zS(this.KJ.getId());
            }
            if (this.eNo != null) {
                this.eNo.b(view, this.KJ);
            }
        } else if (view.getId() == R.id.video_container && this.eNo != null) {
            this.eNo.b(view, this.KJ);
        }
    }
}
