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
    private bj adJ;
    private final View.OnClickListener agl = new View.OnClickListener() { // from class: com.baidu.tieba.ala.livecard.a.d.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (d.this.fsz != null) {
                d.this.fsz.c(view, d.this.adJ);
            }
        }
    };
    public RelativeLayout fsu;
    public ThreadUserInfoLayout fsv;
    public ThreadCommentAndPraiseInfoLayout fsw;
    public View fsx;
    public AlaVideoContainer fsy;
    private com.baidu.tieba.ala.livecard.vc.c fsz;
    public View mDivider;
    private String mForumName;
    public TextView mTextTitle;
    private View rootView;

    public d(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.rootView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.frs_ala_stage_live_item, (ViewGroup) null);
        this.fsu = (RelativeLayout) this.rootView.findViewById(R.id.layout_root);
        this.fsv = (ThreadUserInfoLayout) this.rootView.findViewById(R.id.card_frs_ala_video_user_info_layout);
        this.fsv.setFrom(3);
        this.mTextTitle = (TextView) this.rootView.findViewById(R.id.text_title);
        this.fsy = (AlaVideoContainer) this.rootView.findViewById(R.id.ala_video_container);
        this.fsx = this.rootView.findViewById(R.id.divider_below_reply_number_layout);
        this.fsw = (ThreadCommentAndPraiseInfoLayout) this.rootView.findViewById(R.id.text_bottom);
        this.mDivider = this.rootView.findViewById(R.id.divider_line);
        this.fsu.setOnClickListener(this);
        this.fsw.setOnClickListener(this);
        this.fsw.getCommentContainer().setOnClickListener(this);
        this.fsy.setOnVideoClickListener(this);
    }

    public View getRootView() {
        return this.rootView;
    }

    public void refreshView() {
        if (this.adJ != null && this.adJ.aKC() != null) {
            d(this.adJ, this.mForumName);
        }
    }

    public void d(bj bjVar, String str) {
        if (bjVar != null && bjVar.aKC() != null) {
            this.adJ = bjVar;
            this.mForumName = str;
            this.fsu.setVisibility(0);
            this.fsv.setData(bjVar);
            if (this.fsv.getHeaderImg() != null) {
                this.fsv.getHeaderImg().setData(bjVar);
            }
            this.fsv.setUserAfterClickListener(this.agl);
            bjVar.s(false, true);
            this.mTextTitle.setText(bjVar.aLj());
            this.fsy.getController().a(bjVar, str, "", false);
            this.fsy.getController().startPlayAnimation();
            this.fsw.setReplyTimeVisible(false);
            this.fsw.setNeedAddReplyIcon(true);
            this.fsw.setIsBarViewVisible(false);
            this.fsw.setCommentNumEnable(false);
            this.fsw.setOnClickListener(this);
            this.fsw.setLiveShareEnable(false);
            this.fsw.setShareVisible(true);
            this.fsw.setShowPraiseNum(true);
            this.fsw.setNeedAddPraiseIcon(true);
            this.fsw.setFrom(2);
            if (this.fsw.setData(bjVar)) {
                this.fsx.setVisibility(8);
            } else {
                this.fsx.setVisibility(0);
            }
            U(bjVar);
        }
    }

    public void m(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.fsw != null && this.fsv != null) {
            this.fsv.setPageUniqueId(bdUniqueId);
        }
    }

    private void U(bj bjVar) {
        this.fsw.onChangeSkinType();
        this.fsv.onChangeSkinType();
        this.fsy.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.fsu.setBackgroundDrawable(am.kC(R.color.cp_bg_line_e));
        am.setBackgroundColor(this.mDivider, R.color.cp_bg_line_c);
        if (bjVar != null && l.BF(bjVar.getId())) {
            am.setViewTextColor(this.mTextTitle, (int) R.color.cp_cont_d);
        } else {
            am.setViewTextColor(this.mTextTitle, (int) R.color.cp_cont_b);
        }
    }

    public void a(com.baidu.tieba.ala.livecard.vc.c cVar) {
        this.fsz = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.fsu || view == this.fsw.getCommentContainer()) {
            if (this.adJ != null) {
                l.BE(this.adJ.getId());
            }
            if (this.fsz != null) {
                this.fsz.b(view, this.adJ);
            }
        } else if (view.getId() == R.id.video_container && this.fsz != null) {
            this.fsz.b(view, this.adJ);
        }
    }
}
