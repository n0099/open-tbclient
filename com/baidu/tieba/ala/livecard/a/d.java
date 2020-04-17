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
    private bj adG;
    private final View.OnClickListener agi = new View.OnClickListener() { // from class: com.baidu.tieba.ala.livecard.a.d.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (d.this.fsu != null) {
                d.this.fsu.c(view, d.this.adG);
            }
        }
    };
    public RelativeLayout fsp;
    public ThreadUserInfoLayout fsq;
    public ThreadCommentAndPraiseInfoLayout fsr;
    public View fss;
    public AlaVideoContainer fst;
    private com.baidu.tieba.ala.livecard.vc.c fsu;
    public View mDivider;
    private String mForumName;
    public TextView mTextTitle;
    private View rootView;

    public d(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.rootView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.frs_ala_stage_live_item, (ViewGroup) null);
        this.fsp = (RelativeLayout) this.rootView.findViewById(R.id.layout_root);
        this.fsq = (ThreadUserInfoLayout) this.rootView.findViewById(R.id.card_frs_ala_video_user_info_layout);
        this.fsq.setFrom(3);
        this.mTextTitle = (TextView) this.rootView.findViewById(R.id.text_title);
        this.fst = (AlaVideoContainer) this.rootView.findViewById(R.id.ala_video_container);
        this.fss = this.rootView.findViewById(R.id.divider_below_reply_number_layout);
        this.fsr = (ThreadCommentAndPraiseInfoLayout) this.rootView.findViewById(R.id.text_bottom);
        this.mDivider = this.rootView.findViewById(R.id.divider_line);
        this.fsp.setOnClickListener(this);
        this.fsr.setOnClickListener(this);
        this.fsr.getCommentContainer().setOnClickListener(this);
        this.fst.setOnVideoClickListener(this);
    }

    public View getRootView() {
        return this.rootView;
    }

    public void refreshView() {
        if (this.adG != null && this.adG.aKE() != null) {
            d(this.adG, this.mForumName);
        }
    }

    public void d(bj bjVar, String str) {
        if (bjVar != null && bjVar.aKE() != null) {
            this.adG = bjVar;
            this.mForumName = str;
            this.fsp.setVisibility(0);
            this.fsq.setData(bjVar);
            if (this.fsq.getHeaderImg() != null) {
                this.fsq.getHeaderImg().setData(bjVar);
            }
            this.fsq.setUserAfterClickListener(this.agi);
            bjVar.s(false, true);
            this.mTextTitle.setText(bjVar.aLl());
            this.fst.getController().a(bjVar, str, "", false);
            this.fst.getController().startPlayAnimation();
            this.fsr.setReplyTimeVisible(false);
            this.fsr.setNeedAddReplyIcon(true);
            this.fsr.setIsBarViewVisible(false);
            this.fsr.setCommentNumEnable(false);
            this.fsr.setOnClickListener(this);
            this.fsr.setLiveShareEnable(false);
            this.fsr.setShareVisible(true);
            this.fsr.setShowPraiseNum(true);
            this.fsr.setNeedAddPraiseIcon(true);
            this.fsr.setFrom(2);
            if (this.fsr.setData(bjVar)) {
                this.fss.setVisibility(8);
            } else {
                this.fss.setVisibility(0);
            }
            U(bjVar);
        }
    }

    public void m(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.fsr != null && this.fsq != null) {
            this.fsq.setPageUniqueId(bdUniqueId);
        }
    }

    private void U(bj bjVar) {
        this.fsr.onChangeSkinType();
        this.fsq.onChangeSkinType();
        this.fst.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.fsp.setBackgroundDrawable(am.kC(R.color.cp_bg_line_e));
        am.setBackgroundColor(this.mDivider, R.color.cp_bg_line_c);
        if (bjVar != null && l.BC(bjVar.getId())) {
            am.setViewTextColor(this.mTextTitle, (int) R.color.cp_cont_d);
        } else {
            am.setViewTextColor(this.mTextTitle, (int) R.color.cp_cont_b);
        }
    }

    public void a(com.baidu.tieba.ala.livecard.vc.c cVar) {
        this.fsu = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.fsp || view == this.fsr.getCommentContainer()) {
            if (this.adG != null) {
                l.BB(this.adG.getId());
            }
            if (this.fsu != null) {
                this.fsu.b(view, this.adG);
            }
        } else if (view.getId() == R.id.video_container && this.fsu != null) {
            this.fsu.b(view, this.adG);
        }
    }
}
