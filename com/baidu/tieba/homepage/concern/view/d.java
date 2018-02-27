package com.baidu.tieba.homepage.concern.view;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadSourceShareAndPraiseLayout;
import com.baidu.tbadk.core.view.ThreadUserInfoLayout;
import com.baidu.tieba.card.j;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public abstract class d extends com.baidu.tieba.card.a<com.baidu.tieba.homepage.concern.b.b> {
    protected bd bZR;
    private final View.OnClickListener bdQ;
    private com.baidu.tbadk.core.view.userLike.c cVX;
    public ThreadUserInfoLayout clW;
    public ThreadCommentAndPraiseInfoLayout clX;
    public ThreadSourceShareAndPraiseLayout cmL;
    protected LinearLayout cmX;
    private View dZa;
    private TextView egL;
    public ConcernUserLikeButton egM;
    private View egN;
    public LinearLayout egO;
    protected com.baidu.tieba.homepage.concern.b.b egP;
    protected boolean egQ;
    private View.OnClickListener egR;
    protected View.OnClickListener egS;
    private final View.OnClickListener egT;
    protected TbPageContext<?> mPageContext;
    private int mSkinType;
    protected TextView mTitle;

    protected abstract void X(bd bdVar);

    protected abstract void by(View view);

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.egQ = true;
        this.egR = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.akO() != null) {
                    d.this.akO().a(view, d.this.egP);
                }
                if (d.this.egP != null && !StringUtils.isNull(d.this.egP.egx.getName()) && !StringUtils.isNull(d.this.egP.egx.getUserId())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(d.this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.g.b.c(d.this.egP.egx.getUserId(), 0L), false, d.this.egP.egx.isGod())));
                }
            }
        };
        this.egS = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.d.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.akO() != null) {
                    d.this.akO().a(view, d.this.egP);
                }
                d.this.ali();
            }
        };
        this.bdQ = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.d.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.akO() != null) {
                    d.this.akO().a(view, d.this.egP);
                }
            }
        };
        this.egT = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.d.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == d.g.thread_info_commont_container && d.this.bZR != null) {
                    j.kr(d.this.bZR.getId());
                    d.this.akT();
                }
            }
        };
        View view = getView();
        this.currentPageType = 1;
        this.mPageContext = tbPageContext;
        this.egL = (TextView) view.findViewById(d.g.card_recommend_god_reason);
        this.egM = (ConcernUserLikeButton) view.findViewById(d.g.card_recommend_god_user_like_btn);
        this.clW = (ThreadUserInfoLayout) view.findViewById(d.g.card_rec_god_user_info);
        this.cVX = new com.baidu.tbadk.core.view.userLike.c(tbPageContext, this.egM);
        this.clW.setTShowVisible(false);
        this.clW.getHeaderImg().setAfterClickListener(this.bdQ);
        this.egM.setAfterOnClickListener(this.bdQ);
        this.dZa = view.findViewById(d.g.card_recommend_god_divide_line);
        this.egN = view.findViewById(d.g.divider_line);
        this.egO = (LinearLayout) view.findViewById(d.g.card_recommend_god_content);
        this.egO.setOnClickListener(this.egR);
        this.mTitle = (TextView) view.findViewById(d.g.card_recommend_god_therad_title);
        this.clX = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.card_recommend_god_therad_info_layout);
        this.clX.setOnClickListener(this.egS);
        this.clX.setReplyTimeVisible(false);
        this.clX.setIsBarViewVisible(false);
        this.clX.setShowPraiseNum(true);
        this.clX.setNeedAddPraiseIcon(true);
        this.clX.setNeedAddReplyIcon(true);
        this.clX.setShareVisible(true);
        this.clX.aQt = this.currentPageType;
        this.clX.setForumAfterClickListener(this.egT);
        this.clX.setShareReportFrom(4);
        this.clX.setFrom(9);
        this.cmL = (ThreadSourceShareAndPraiseLayout) view.findViewById(d.g.card_concern_god_source_read_share_layout);
        this.cmL.bem.setOnClickListener(this.egS);
        this.cmL.bem.aQt = this.currentPageType;
        this.cmL.bem.setForumAfterClickListener(this.egT);
        this.cmL.setShareReportFrom(4);
        this.cmL.setFrom(9);
        this.cmX = (LinearLayout) view.findViewById(d.g.card_recommend_god_therad_content_layout);
        by(view);
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
            this.cVX.h(bdUniqueId);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.s(getView(), d.f.addresslist_item_bg);
            aj.r(this.egL, d.C0141d.cp_cont_d);
            aj.t(this.dZa, d.C0141d.cp_bg_line_e);
            aj.t(this.egN, d.C0141d.cp_bg_line_e);
            this.egM.onChangeSkinType(i);
            this.clX.onChangeSkinType();
            this.cmL.onChangeSkinType();
        }
        this.mSkinType = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.homepage.concern.b.b bVar) {
        if (bVar != null && bVar.egx != null && !StringUtils.isNull(bVar.egx.getName()) && !StringUtils.isNull(bVar.egx.getUserId()) && !StringUtils.isNull(bVar.dxH.getTid())) {
            this.egP = bVar;
            if (this.clW != null) {
                this.clW.setData(bVar.dxH);
                if (this.clW.getHeaderImg() != null) {
                    this.clW.getHeaderImg().setData(bVar.metaData);
                }
                this.clW.onChangeSkinType();
            }
            this.cVX.a(this.egP.metaData);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.egO.getLayoutParams();
            String aCr = this.egP.egx.aCr();
            if (StringUtils.isNull(aCr)) {
                this.egL.setVisibility(8);
            } else {
                this.egL.setVisibility(0);
                this.egL.setText(aCr);
            }
            this.bZR = bVar.dxH;
            if (j.ks(this.bZR.getId())) {
                akT();
            }
            this.clX.setData(this.bZR);
            j.b(this.bZR, this.mTitle);
            this.egQ = true;
            if ((StringUtils.isNull(this.bZR.getTitle()) && (this.bZR.zl() == null || this.bZR.zl().size() == 0)) || this.bZR.zD() == 1) {
                this.bZR.h(false, true);
                if (this.bZR.zN() == null || StringUtils.isNull(this.bZR.zN().toString())) {
                    this.egQ = false;
                }
            }
            X(this.bZR);
            jX(this.bZR.aQo);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.egM != null) {
            this.egM.setTag(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void akT() {
        j.a(this.mTitle, this.bZR.getId(), d.C0141d.cp_cont_b, d.C0141d.cp_cont_d);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ali() {
        if (this.egP != null && this.bZR != null) {
            j.kr(this.bZR.getId());
            akT();
            PbActivityConfig createCfgForPersonCenter = new PbActivityConfig(this.mPageContext.getPageActivity()).createCfgForPersonCenter(this.bZR.getId(), this.bZR.zE(), j.zd(), 18005);
            createCfgForPersonCenter.setStartFrom(this.currentPageType);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createCfgForPersonCenter));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void jX(int i) {
        if (this.bZR != null) {
            if (i == 1) {
                this.clX.setVisibility(8);
                this.cmL.setData(this.bZR);
                this.clW.showForumNameView(false);
                return;
            }
            this.clX.setData(this.bZR);
            this.cmL.setVisibility(8);
            this.clW.showForumNameView(true);
        }
    }
}
