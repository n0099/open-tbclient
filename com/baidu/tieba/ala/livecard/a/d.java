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
/* loaded from: classes2.dex */
public class d implements View.OnClickListener {
    private bj Ki;
    private final View.OnClickListener MT = new View.OnClickListener() { // from class: com.baidu.tieba.ala.livecard.a.d.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (d.this.eIk != null) {
                d.this.eIk.c(view, d.this.Ki);
            }
        }
    };
    public RelativeLayout eIf;
    public ThreadUserInfoLayout eIg;
    public ThreadCommentAndPraiseInfoLayout eIh;
    public View eIi;
    public AlaVideoContainer eIj;
    private com.baidu.tieba.ala.livecard.vc.c eIk;
    public View mDivider;
    private String mForumName;
    public TextView mTextTitle;
    private View rootView;

    public d(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.rootView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.frs_ala_stage_live_item, (ViewGroup) null);
        this.eIf = (RelativeLayout) this.rootView.findViewById(R.id.layout_root);
        this.eIg = (ThreadUserInfoLayout) this.rootView.findViewById(R.id.card_frs_ala_video_user_info_layout);
        this.eIg.setFrom(3);
        this.mTextTitle = (TextView) this.rootView.findViewById(R.id.text_title);
        this.eIj = (AlaVideoContainer) this.rootView.findViewById(R.id.ala_video_container);
        this.eIi = this.rootView.findViewById(R.id.divider_below_reply_number_layout);
        this.eIh = (ThreadCommentAndPraiseInfoLayout) this.rootView.findViewById(R.id.text_bottom);
        this.mDivider = this.rootView.findViewById(R.id.divider_line);
        this.eIf.setOnClickListener(this);
        this.eIh.setOnClickListener(this);
        this.eIh.getCommentContainer().setOnClickListener(this);
        this.eIj.setOnVideoClickListener(this);
    }

    public View getRootView() {
        return this.rootView;
    }

    public void refreshView() {
        if (this.Ki != null && this.Ki.azE() != null) {
            d(this.Ki, this.mForumName);
        }
    }

    public void d(bj bjVar, String str) {
        if (bjVar != null && bjVar.azE() != null) {
            this.Ki = bjVar;
            this.mForumName = str;
            this.eIf.setVisibility(0);
            this.eIg.setData(bjVar);
            if (this.eIg.getHeaderImg() != null) {
                this.eIg.getHeaderImg().setData(bjVar);
            }
            this.eIg.setUserAfterClickListener(this.MT);
            bjVar.q(false, true);
            this.mTextTitle.setText(bjVar.aAl());
            this.eIj.getController().a(bjVar, str, "", false);
            this.eIj.getController().startPlayAnimation();
            this.eIh.setReplyTimeVisible(false);
            this.eIh.setNeedAddReplyIcon(true);
            this.eIh.setIsBarViewVisible(false);
            this.eIh.setCommentNumEnable(false);
            this.eIh.setOnClickListener(this);
            this.eIh.setLiveShareEnable(false);
            this.eIh.setShareVisible(true);
            this.eIh.setShowPraiseNum(true);
            this.eIh.setNeedAddPraiseIcon(true);
            this.eIh.setFrom(2);
            if (this.eIh.setData(bjVar)) {
                this.eIi.setVisibility(8);
            } else {
                this.eIi.setVisibility(0);
            }
            R(bjVar);
        }
    }

    public void m(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.eIh != null && this.eIg != null) {
            this.eIg.setPageUniqueId(bdUniqueId);
        }
    }

    private void R(bj bjVar) {
        this.eIh.onChangeSkinType();
        this.eIg.onChangeSkinType();
        this.eIj.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.eIf.setBackgroundDrawable(am.ke(R.color.cp_bg_line_e));
        am.setBackgroundColor(this.mDivider, R.color.cp_bg_line_c);
        if (bjVar != null && l.zt(bjVar.getId())) {
            am.setViewTextColor(this.mTextTitle, (int) R.color.cp_cont_d);
        } else {
            am.setViewTextColor(this.mTextTitle, (int) R.color.cp_cont_b);
        }
    }

    public void a(com.baidu.tieba.ala.livecard.vc.c cVar) {
        this.eIk = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.eIf || view == this.eIh.getCommentContainer()) {
            if (this.Ki != null) {
                l.zs(this.Ki.getId());
            }
            if (this.eIk != null) {
                this.eIk.b(view, this.Ki);
            }
        } else if (view.getId() == R.id.video_container && this.eIk != null) {
            this.eIk.b(view, this.Ki);
        }
    }
}
