package com.baidu.tieba.ala.livecard.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadUserInfoLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ala.AlaVideoContainer;
import com.baidu.tieba.card.n;
/* loaded from: classes6.dex */
public class d implements View.OnClickListener {
    private bh Fs;
    private final View.OnClickListener Ho = new View.OnClickListener() { // from class: com.baidu.tieba.ala.livecard.a.d.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (d.this.dSD != null) {
                d.this.dSD.c(view, d.this.Fs);
            }
        }
    };
    public View bgU;
    public ThreadCommentAndPraiseInfoLayout dSA;
    public View dSB;
    public AlaVideoContainer dSC;
    private com.baidu.tieba.ala.livecard.vc.c dSD;
    public RelativeLayout dSy;
    public ThreadUserInfoLayout dSz;
    private String mForumName;
    public TextView mTextTitle;
    private View rootView;

    public d(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.rootView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.frs_ala_stage_live_item, (ViewGroup) null);
        this.dSy = (RelativeLayout) this.rootView.findViewById(R.id.layout_root);
        this.dSz = (ThreadUserInfoLayout) this.rootView.findViewById(R.id.card_frs_ala_video_user_info_layout);
        this.dSz.setFrom(3);
        this.mTextTitle = (TextView) this.rootView.findViewById(R.id.text_title);
        this.dSC = (AlaVideoContainer) this.rootView.findViewById(R.id.ala_video_container);
        this.dSB = this.rootView.findViewById(R.id.divider_below_reply_number_layout);
        this.dSA = (ThreadCommentAndPraiseInfoLayout) this.rootView.findViewById(R.id.text_bottom);
        this.bgU = this.rootView.findViewById(R.id.divider_line);
        this.dSy.setOnClickListener(this);
        this.dSA.setOnClickListener(this);
        this.dSA.getCommentContainer().setOnClickListener(this);
        this.dSC.setOnVideoClickListener(this);
    }

    public View getRootView() {
        return this.rootView;
    }

    public void refreshView() {
        if (this.Fs != null && this.Fs.aiE() != null) {
            b(this.Fs, this.mForumName);
        }
    }

    public void b(bh bhVar, String str) {
        if (bhVar != null && bhVar.aiE() != null) {
            this.Fs = bhVar;
            this.mForumName = str;
            this.dSy.setVisibility(0);
            this.dSz.setData(bhVar);
            if (this.dSz.getHeaderImg() != null) {
                this.dSz.getHeaderImg().setData(bhVar);
            }
            this.dSz.setUserAfterClickListener(this.Ho);
            bhVar.q(false, true);
            this.mTextTitle.setText(bhVar.ajk());
            this.dSC.getController().a(bhVar, str, "", false);
            this.dSC.getController().startPlayAnimation();
            this.dSA.setReplyTimeVisible(false);
            this.dSA.setNeedAddReplyIcon(true);
            this.dSA.setIsBarViewVisible(false);
            this.dSA.setCommentNumEnable(false);
            this.dSA.setOnClickListener(this);
            this.dSA.setLiveShareEnable(false);
            this.dSA.setShareVisible(true);
            this.dSA.setShowPraiseNum(true);
            this.dSA.setNeedAddPraiseIcon(true);
            this.dSA.setFrom(2);
            if (this.dSA.setData(bhVar)) {
                this.dSB.setVisibility(8);
            } else {
                this.dSB.setVisibility(0);
            }
            N(bhVar);
        }
    }

    public void l(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.dSA != null && this.dSz != null) {
            this.dSz.setPageUniqueId(bdUniqueId);
        }
    }

    private void N(bh bhVar) {
        this.dSA.onChangeSkinType();
        this.dSz.onChangeSkinType();
        this.dSC.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.dSy.setBackgroundDrawable(am.is(R.color.cp_bg_line_e));
        am.setBackgroundColor(this.bgU, R.color.cp_bg_line_c);
        if (bhVar != null && n.uA(bhVar.getId())) {
            am.setViewTextColor(this.mTextTitle, (int) R.color.cp_cont_d);
        } else {
            am.setViewTextColor(this.mTextTitle, (int) R.color.cp_cont_b);
        }
    }

    public void a(com.baidu.tieba.ala.livecard.vc.c cVar) {
        this.dSD = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.dSy || view == this.dSA.getCommentContainer()) {
            if (this.Fs != null) {
                n.uz(this.Fs.getId());
            }
            if (this.dSD != null) {
                this.dSD.b(view, this.Fs);
            }
        } else if (view.getId() == R.id.video_container && this.dSD != null) {
            this.dSD.b(view, this.Fs);
        }
    }
}
