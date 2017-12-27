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
import com.baidu.tbadk.core.data.be;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadUserInfoLayout;
import com.baidu.tieba.card.k;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public abstract class d extends com.baidu.tieba.card.a<com.baidu.tieba.homepage.concern.b.b> {
    protected be bXF;
    private final View.OnClickListener bce;
    private com.baidu.tbadk.core.view.userLike.c cOt;
    public ThreadUserInfoLayout ciD;
    public ThreadCommentAndPraiseInfoLayout ciE;
    protected LinearLayout cjA;
    private TextView ebf;
    public ConcernUserLikeButton ebg;
    private View ebh;
    private View ebi;
    public LinearLayout ebj;
    protected com.baidu.tieba.homepage.concern.b.b ebk;
    protected boolean ebl;
    private View.OnClickListener ebm;
    protected View.OnClickListener ebn;
    private final View.OnClickListener ebo;
    protected TbPageContext<?> mPageContext;
    private int mSkinType;
    protected TextView mTitle;

    protected abstract void U(be beVar);

    protected abstract void bx(View view);

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.ebl = true;
        this.ebm = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.aiY() != null) {
                    d.this.aiY().a(view, d.this.ebk);
                }
                if (d.this.ebk != null && !StringUtils.isNull(d.this.ebk.eaS.getName()) && !StringUtils.isNull(d.this.ebk.eaS.getUserId())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(d.this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.g.b.c(d.this.ebk.eaS.getUserId(), 0L), false, d.this.ebk.eaS.isGod())));
                }
            }
        };
        this.ebn = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.d.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.aiY() != null) {
                    d.this.aiY().a(view, d.this.ebk);
                }
                d.this.ajs();
            }
        };
        this.bce = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.d.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.aiY() != null) {
                    d.this.aiY().a(view, d.this.ebk);
                }
            }
        };
        this.ebo = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.d.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == d.g.thread_info_commont_container && d.this.bXF != null) {
                    k.jT(d.this.bXF.getId());
                    d.this.ajd();
                }
            }
        };
        View view = getView();
        this.currentPageType = 1;
        this.mPageContext = tbPageContext;
        this.ebf = (TextView) view.findViewById(d.g.card_recommend_god_reason);
        this.ebg = (ConcernUserLikeButton) view.findViewById(d.g.card_recommend_god_user_like_btn);
        this.ciD = (ThreadUserInfoLayout) view.findViewById(d.g.card_rec_god_user_info);
        this.cOt = new com.baidu.tbadk.core.view.userLike.c(tbPageContext, this.ebg);
        this.ciD.setTShowVisible(false);
        this.ciD.getHeaderImg().setAfterClickListener(this.bce);
        this.ebg.setAfterOnClickListener(this.bce);
        this.ebh = view.findViewById(d.g.card_recommend_god_divide_line);
        this.ebi = view.findViewById(d.g.divider_line);
        this.ebj = (LinearLayout) view.findViewById(d.g.card_recommend_god_content);
        this.ebj.setOnClickListener(this.ebm);
        this.mTitle = (TextView) view.findViewById(d.g.card_recommend_god_therad_title);
        this.ciE = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.card_recommend_god_therad_info_layout);
        this.ciE.setOnClickListener(this.ebn);
        this.ciE.setReplyTimeVisible(false);
        this.ciE.setIsBarViewVisible(false);
        this.ciE.setShowPraiseNum(true);
        this.ciE.setNeedAddPraiseIcon(true);
        this.ciE.setNeedAddReplyIcon(true);
        this.ciE.setShareVisible(true);
        this.ciE.bbP = this.currentPageType;
        this.ciE.setForumAfterClickListener(this.ebo);
        this.cjA = (LinearLayout) view.findViewById(d.g.card_recommend_god_therad_content_layout);
        bx(view);
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
            this.cOt.h(bdUniqueId);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.s(getView(), d.f.addresslist_item_bg);
            aj.r(this.ebf, d.C0108d.cp_cont_d);
            aj.t(this.ebh, d.C0108d.cp_bg_line_e);
            aj.t(this.ebi, d.C0108d.cp_bg_line_e);
            this.ebg.onChangeSkinType(i);
            this.ciE.onChangeSkinType();
        }
        this.mSkinType = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.homepage.concern.b.b bVar) {
        if (bVar != null && bVar.eaS != null && !StringUtils.isNull(bVar.eaS.getName()) && !StringUtils.isNull(bVar.eaS.getUserId()) && !StringUtils.isNull(bVar.dqg.getTid())) {
            this.ebk = bVar;
            if (this.ciD != null) {
                this.ciD.setData(bVar.dqg);
                if (this.ciD.getHeaderImg() != null) {
                    this.ciD.getHeaderImg().setData(bVar.metaData);
                }
                this.ciD.onChangeSkinType();
            }
            this.cOt.a(this.ebk.metaData);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ebj.getLayoutParams();
            String aAR = this.ebk.eaS.aAR();
            if (StringUtils.isNull(aAR)) {
                this.ebf.setVisibility(8);
            } else {
                this.ebf.setVisibility(0);
                this.ebf.setText(aAR);
            }
            this.bXF = bVar.dqg;
            if (k.jU(this.bXF.getId())) {
                ajd();
            }
            this.ciE.setData(this.bXF);
            k.b(this.bXF, this.mTitle);
            this.ebl = true;
            if ((StringUtils.isNull(this.bXF.getTitle()) && (this.bXF.yV() == null || this.bXF.yV().size() == 0)) || this.bXF.zn() == 1) {
                this.bXF.h(false, true);
                if (this.bXF.zx() == null || StringUtils.isNull(this.bXF.zx().toString())) {
                    this.ebl = false;
                }
            }
            U(this.bXF);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.ebg != null) {
            this.ebg.setTag(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ajd() {
        k.a(this.mTitle, this.bXF.getId(), d.C0108d.cp_cont_b, d.C0108d.cp_cont_d);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ajs() {
        if (this.ebk != null && this.bXF != null) {
            k.jT(this.bXF.getId());
            ajd();
            PbActivityConfig createCfgForPersonCenter = new PbActivityConfig(this.mPageContext.getPageActivity()).createCfgForPersonCenter(this.bXF.getId(), this.bXF.zo(), k.yN(), 18005);
            createCfgForPersonCenter.setStartFrom(this.currentPageType);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createCfgForPersonCenter));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
