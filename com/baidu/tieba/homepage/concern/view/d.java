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
    protected bd bZU;
    private final View.OnClickListener bdT;
    private com.baidu.tbadk.core.view.userLike.c cWa;
    public ThreadUserInfoLayout clZ;
    public ThreadSourceShareAndPraiseLayout cmO;
    public ThreadCommentAndPraiseInfoLayout cma;
    protected LinearLayout cna;
    private View dZr;
    private TextView ehb;
    public ConcernUserLikeButton ehc;
    private View ehd;
    public LinearLayout ehe;
    protected com.baidu.tieba.homepage.concern.b.b ehf;
    protected boolean ehg;
    private View.OnClickListener ehh;
    protected View.OnClickListener ehi;
    private final View.OnClickListener ehj;
    protected TbPageContext<?> mPageContext;
    private int mSkinType;
    protected TextView mTitle;

    protected abstract void X(bd bdVar);

    protected abstract void by(View view);

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.ehg = true;
        this.ehh = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.akP() != null) {
                    d.this.akP().a(view, d.this.ehf);
                }
                if (d.this.ehf != null && !StringUtils.isNull(d.this.ehf.egN.getName()) && !StringUtils.isNull(d.this.ehf.egN.getUserId())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(d.this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.g.b.c(d.this.ehf.egN.getUserId(), 0L), false, d.this.ehf.egN.isGod())));
                }
            }
        };
        this.ehi = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.d.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.akP() != null) {
                    d.this.akP().a(view, d.this.ehf);
                }
                d.this.alj();
            }
        };
        this.bdT = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.d.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.akP() != null) {
                    d.this.akP().a(view, d.this.ehf);
                }
            }
        };
        this.ehj = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.d.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == d.g.thread_info_commont_container && d.this.bZU != null) {
                    j.kr(d.this.bZU.getId());
                    d.this.akU();
                }
            }
        };
        View view = getView();
        this.currentPageType = 1;
        this.mPageContext = tbPageContext;
        this.ehb = (TextView) view.findViewById(d.g.card_recommend_god_reason);
        this.ehc = (ConcernUserLikeButton) view.findViewById(d.g.card_recommend_god_user_like_btn);
        this.clZ = (ThreadUserInfoLayout) view.findViewById(d.g.card_rec_god_user_info);
        this.cWa = new com.baidu.tbadk.core.view.userLike.c(tbPageContext, this.ehc);
        this.clZ.setTShowVisible(false);
        this.clZ.getHeaderImg().setAfterClickListener(this.bdT);
        this.ehc.setAfterOnClickListener(this.bdT);
        this.dZr = view.findViewById(d.g.card_recommend_god_divide_line);
        this.ehd = view.findViewById(d.g.divider_line);
        this.ehe = (LinearLayout) view.findViewById(d.g.card_recommend_god_content);
        this.ehe.setOnClickListener(this.ehh);
        this.mTitle = (TextView) view.findViewById(d.g.card_recommend_god_therad_title);
        this.cma = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.card_recommend_god_therad_info_layout);
        this.cma.setOnClickListener(this.ehi);
        this.cma.setReplyTimeVisible(false);
        this.cma.setIsBarViewVisible(false);
        this.cma.setShowPraiseNum(true);
        this.cma.setNeedAddPraiseIcon(true);
        this.cma.setNeedAddReplyIcon(true);
        this.cma.setShareVisible(true);
        this.cma.aQv = this.currentPageType;
        this.cma.setForumAfterClickListener(this.ehj);
        this.cma.setShareReportFrom(4);
        this.cma.setFrom(9);
        this.cmO = (ThreadSourceShareAndPraiseLayout) view.findViewById(d.g.card_concern_god_source_read_share_layout);
        this.cmO.bep.setOnClickListener(this.ehi);
        this.cmO.bep.aQv = this.currentPageType;
        this.cmO.bep.setForumAfterClickListener(this.ehj);
        this.cmO.setShareReportFrom(4);
        this.cmO.setFrom(9);
        this.cna = (LinearLayout) view.findViewById(d.g.card_recommend_god_therad_content_layout);
        by(view);
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
            this.cWa.h(bdUniqueId);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.s(getView(), d.f.addresslist_item_bg);
            aj.r(this.ehb, d.C0141d.cp_cont_d);
            aj.t(this.dZr, d.C0141d.cp_bg_line_e);
            aj.t(this.ehd, d.C0141d.cp_bg_line_e);
            this.ehc.onChangeSkinType(i);
            this.cma.onChangeSkinType();
            this.cmO.onChangeSkinType();
        }
        this.mSkinType = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.homepage.concern.b.b bVar) {
        if (bVar != null && bVar.egN != null && !StringUtils.isNull(bVar.egN.getName()) && !StringUtils.isNull(bVar.egN.getUserId()) && !StringUtils.isNull(bVar.dxK.getTid())) {
            this.ehf = bVar;
            if (this.clZ != null) {
                this.clZ.setData(bVar.dxK);
                if (this.clZ.getHeaderImg() != null) {
                    this.clZ.getHeaderImg().setData(bVar.metaData);
                }
                this.clZ.onChangeSkinType();
            }
            this.cWa.a(this.ehf.metaData);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ehe.getLayoutParams();
            String aCs = this.ehf.egN.aCs();
            if (StringUtils.isNull(aCs)) {
                this.ehb.setVisibility(8);
            } else {
                this.ehb.setVisibility(0);
                this.ehb.setText(aCs);
            }
            this.bZU = bVar.dxK;
            if (j.ks(this.bZU.getId())) {
                akU();
            }
            this.cma.setData(this.bZU);
            j.b(this.bZU, this.mTitle);
            this.ehg = true;
            if ((StringUtils.isNull(this.bZU.getTitle()) && (this.bZU.zl() == null || this.bZU.zl().size() == 0)) || this.bZU.zD() == 1) {
                this.bZU.h(false, true);
                if (this.bZU.zN() == null || StringUtils.isNull(this.bZU.zN().toString())) {
                    this.ehg = false;
                }
            }
            X(this.bZU);
            jX(this.bZU.aQp);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.ehc != null) {
            this.ehc.setTag(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void akU() {
        j.a(this.mTitle, this.bZU.getId(), d.C0141d.cp_cont_b, d.C0141d.cp_cont_d);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void alj() {
        if (this.ehf != null && this.bZU != null) {
            j.kr(this.bZU.getId());
            akU();
            PbActivityConfig createCfgForPersonCenter = new PbActivityConfig(this.mPageContext.getPageActivity()).createCfgForPersonCenter(this.bZU.getId(), this.bZU.zE(), j.zd(), 18005);
            createCfgForPersonCenter.setStartFrom(this.currentPageType);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createCfgForPersonCenter));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void jX(int i) {
        if (this.bZU != null) {
            if (i == 1) {
                this.cma.setVisibility(8);
                this.cmO.setData(this.bZU);
                this.clZ.showForumNameView(false);
                return;
            }
            this.cma.setData(this.bZU);
            this.cmO.setVisibility(8);
            this.clZ.showForumNameView(true);
        }
    }
}
