package com.baidu.tieba.ala.livecard.holder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadUserInfoLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.livecard.vc.c;
import com.baidu.tieba.card.ala.AlaVideoContainer;
import com.baidu.tieba.card.m;
/* loaded from: classes9.dex */
public class a implements View.OnClickListener {
    private bz ahu;
    private final View.OnClickListener akt = new View.OnClickListener() { // from class: com.baidu.tieba.ala.livecard.holder.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.hiW != null) {
                a.this.hiW.d(view, a.this.ahu);
            }
        }
    };
    public View dyW;
    public RelativeLayout hiR;
    public ThreadUserInfoLayout hiS;
    public ThreadCommentAndPraiseInfoLayout hiT;
    public View hiU;
    public AlaVideoContainer hiV;
    private c hiW;
    private String mForumName;
    public TextView mTextTitle;
    private View rootView;

    public a(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.rootView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.frs_ala_stage_live_item, (ViewGroup) null);
        this.hiR = (RelativeLayout) this.rootView.findViewById(R.id.layout_root);
        this.hiS = (ThreadUserInfoLayout) this.rootView.findViewById(R.id.card_frs_ala_video_user_info_layout);
        this.hiS.setFrom(3);
        this.mTextTitle = (TextView) this.rootView.findViewById(R.id.text_title);
        this.hiV = (AlaVideoContainer) this.rootView.findViewById(R.id.ala_video_container);
        this.hiU = this.rootView.findViewById(R.id.divider_below_reply_number_layout);
        this.hiT = (ThreadCommentAndPraiseInfoLayout) this.rootView.findViewById(R.id.text_bottom);
        this.dyW = this.rootView.findViewById(R.id.divider_line);
        this.hiR.setOnClickListener(this);
        this.hiT.setOnClickListener(this);
        this.hiT.getCommentContainer().setOnClickListener(this);
        this.hiV.setOnVideoClickListener(this);
    }

    public View getRootView() {
        return this.rootView;
    }

    public void refreshView() {
        if (this.ahu != null && this.ahu.bnx() != null) {
            k(this.ahu, this.mForumName);
        }
    }

    public void k(bz bzVar, String str) {
        if (bzVar != null && bzVar.bnx() != null) {
            this.ahu = bzVar;
            this.mForumName = str;
            this.hiR.setVisibility(0);
            this.hiS.setData(bzVar);
            if (this.hiS.getHeaderImg() != null) {
                this.hiS.getHeaderImg().setData(bzVar);
            }
            this.hiS.setUserAfterClickListener(this.akt);
            bzVar.z(false, true);
            this.mTextTitle.setText(bzVar.bog());
            this.hiV.getController().a(bzVar, str, "", false);
            this.hiV.getController().startPlayAnimation();
            this.hiT.setReplyTimeVisible(false);
            this.hiT.setNeedAddReplyIcon(true);
            this.hiT.setIsBarViewVisible(false);
            this.hiT.setCommentNumEnable(false);
            this.hiT.setOnClickListener(this);
            this.hiT.setLiveShareEnable(false);
            this.hiT.setShareVisible(true);
            this.hiT.setShowPraiseNum(true);
            this.hiT.setNeedAddPraiseIcon(true);
            this.hiT.setFrom(2);
            if (this.hiT.setData(bzVar)) {
                this.hiU.setVisibility(8);
            } else {
                this.hiU.setVisibility(0);
            }
            W(bzVar);
        }
    }

    public void o(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.hiT != null && this.hiS != null) {
            this.hiS.setPageUniqueId(bdUniqueId);
        }
    }

    private void W(bz bzVar) {
        this.hiT.onChangeSkinType();
        this.hiS.onChangeSkinType();
        this.hiV.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.hiR.setBackgroundDrawable(ao.ox(R.color.CAM_X0205));
        ao.setBackgroundColor(this.dyW, R.color.CAM_X0204);
        if (bzVar != null && m.Id(bzVar.getId())) {
            ao.setViewTextColor(this.mTextTitle, R.color.CAM_X0109);
        } else {
            ao.setViewTextColor(this.mTextTitle, R.color.CAM_X0105);
        }
    }

    public void a(c cVar) {
        this.hiW = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.hiR || view == this.hiT.getCommentContainer()) {
            if (this.ahu != null) {
                m.Ic(this.ahu.getId());
            }
            if (this.hiW != null) {
                this.hiW.c(view, this.ahu);
            }
        } else if (view.getId() == R.id.video_container && this.hiW != null) {
            this.hiW.c(view, this.ahu);
        }
    }
}
