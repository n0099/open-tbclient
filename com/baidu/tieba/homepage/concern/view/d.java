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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadSourceShareAndPraiseLayout;
import com.baidu.tbadk.core.view.ThreadUserInfoLayout;
import com.baidu.tieba.card.o;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public abstract class d extends com.baidu.tieba.card.a<com.baidu.tieba.homepage.concern.b.b> implements com.baidu.tieba.a.e {
    private final View.OnClickListener axr;
    private String bER;
    public ThreadSourceShareAndPraiseLayout bFT;
    public ThreadUserInfoLayout bFd;
    public ThreadCommentAndPraiseInfoLayout bFe;
    protected LinearLayout bGe;
    protected bd bso;
    private com.baidu.tbadk.core.view.userLike.c cxK;
    private View dEs;
    private TextView dNT;
    public ConcernUserLikeButton dNU;
    private View dNV;
    public LinearLayout dNW;
    protected com.baidu.tieba.homepage.concern.b.b dNX;
    protected boolean dNY;
    private View.OnClickListener dNZ;
    protected View.OnClickListener dOa;
    private final View.OnClickListener dOb;
    protected TbPageContext<?> mPageContext;
    private int mSkinType;
    protected TextView mTitle;

    protected abstract void Y(bd bdVar);

    protected abstract void ac(View view);

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.dNY = true;
        this.dNZ = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.aiI() != null) {
                    d.this.aiI().a(view, d.this.dNX);
                }
                if (d.this.dNX != null && !StringUtils.isNull(d.this.dNX.dND.getName()) && !StringUtils.isNull(d.this.dNX.dND.getUserId())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(d.this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.g.b.c(d.this.dNX.dND.getUserId(), 0L), false, d.this.dNX.dND.isGod())));
                }
            }
        };
        this.dOa = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.d.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.aiI() != null) {
                    d.this.aiI().a(view, d.this.dNX);
                }
                d.this.ajb();
            }
        };
        this.axr = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.d.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.aiI() != null) {
                    d.this.aiI().a(view, d.this.dNX);
                }
            }
        };
        this.dOb = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.d.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == d.g.thread_info_commont_container && d.this.bso != null) {
                    o.lb(d.this.bso.getId());
                    d.this.aiN();
                }
            }
        };
        View view = getView();
        this.currentPageType = 1;
        this.mPageContext = tbPageContext;
        this.dNT = (TextView) view.findViewById(d.g.card_recommend_god_reason);
        this.dNU = (ConcernUserLikeButton) view.findViewById(d.g.card_recommend_god_user_like_btn);
        this.bFd = (ThreadUserInfoLayout) view.findViewById(d.g.card_rec_god_user_info);
        this.cxK = new com.baidu.tbadk.core.view.userLike.c(tbPageContext, this.dNU);
        this.bFd.setTShowVisible(false);
        this.bFd.getHeaderImg().setAfterClickListener(this.axr);
        this.dNU.setAfterOnClickListener(this.axr);
        this.dEs = view.findViewById(d.g.card_recommend_god_divide_line);
        this.dNV = view.findViewById(d.g.divider_line);
        this.dNW = (LinearLayout) view.findViewById(d.g.card_recommend_god_content);
        this.dNW.setOnClickListener(this.dNZ);
        this.mTitle = (TextView) view.findViewById(d.g.card_recommend_god_therad_title);
        this.bFe = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.card_recommend_god_therad_info_layout);
        this.bFe.setOnClickListener(this.dOa);
        this.bFe.setReplyTimeVisible(false);
        this.bFe.setIsBarViewVisible(false);
        this.bFe.setShowPraiseNum(true);
        this.bFe.setNeedAddPraiseIcon(true);
        this.bFe.setNeedAddReplyIcon(true);
        this.bFe.setShareVisible(true);
        this.bFe.aka = this.currentPageType;
        this.bFe.setForumAfterClickListener(this.dOb);
        this.bFe.setShareReportFrom(4);
        this.bFe.setFrom(9);
        this.bFT = (ThreadSourceShareAndPraiseLayout) view.findViewById(d.g.card_concern_god_source_read_share_layout);
        this.bFT.axN.setOnClickListener(this.dOa);
        this.bFT.axN.aka = this.currentPageType;
        this.bFT.axN.setForumAfterClickListener(this.dOb);
        this.bFT.setShareReportFrom(4);
        this.bFT.setFrom(9);
        this.bGe = (LinearLayout) view.findViewById(d.g.card_recommend_god_therad_content_layout);
        ac(view);
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
            this.cxK.h(bdUniqueId);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.i(getView(), d.f.addresslist_item_bg);
            al.h(this.dNT, d.C0141d.cp_cont_d);
            al.j(this.dEs, d.C0141d.cp_bg_line_e);
            al.j(this.dNV, d.C0141d.cp_bg_line_e);
            this.dNU.onChangeSkinType(i);
            this.bFe.onChangeSkinType();
            this.bFT.onChangeSkinType();
        }
        this.mSkinType = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.homepage.concern.b.b bVar) {
        if (bVar != null && bVar.dND != null && !StringUtils.isNull(bVar.dND.getName()) && !StringUtils.isNull(bVar.dND.getUserId()) && !StringUtils.isNull(bVar.daI.getTid())) {
            this.dNX = bVar;
            if (this.bFd != null) {
                this.bFd.setData(bVar.daI);
                if (this.bFd.getHeaderImg() != null) {
                    this.bFd.getHeaderImg().setData(bVar.metaData);
                }
                this.bFd.onChangeSkinType();
            }
            this.cxK.a(this.dNX.metaData);
            String aCh = this.dNX.dND.aCh();
            if (StringUtils.isNull(aCh)) {
                this.dNT.setVisibility(8);
            } else {
                this.dNT.setVisibility(0);
                this.dNT.setText(aCh);
            }
            this.bso = bVar.daI;
            if (o.lc(this.bso.getId())) {
                aiN();
            }
            this.bFe.setData(this.bso);
            o.b(this.bso, this.mTitle);
            this.dNY = true;
            if ((StringUtils.isNull(this.bso.getTitle()) && (this.bso.vk() == null || this.bso.vk().size() == 0)) || this.bso.vB() == 1) {
                this.bso.e(false, true);
                if (this.bso.vK() == null || StringUtils.isNull(this.bso.vK().toString())) {
                    this.dNY = false;
                }
            }
            Y(this.bso);
            hd(go(1));
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.dNU != null) {
            this.dNU.setTag(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aiN() {
        o.a(this.mTitle, this.bso.getId(), d.C0141d.cp_cont_b, d.C0141d.cp_cont_d);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ajb() {
        if (this.dNX != null && this.bso != null) {
            o.lb(this.bso.getId());
            aiN();
            PbActivityConfig createCfgForPersonCenter = new PbActivityConfig(this.mPageContext.getPageActivity()).createCfgForPersonCenter(this.bso.getId(), this.bso.vC(), o.vb(), 18005);
            createCfgForPersonCenter.setStartFrom(this.currentPageType);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createCfgForPersonCenter));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void hd(int i) {
        if (this.bso != null) {
            if (i == 1) {
                this.bFe.setVisibility(8);
                this.bFT.setData(this.bso);
                this.bFd.showForumNameView(false);
                return;
            }
            this.bFe.setData(this.bso);
            this.bFT.setVisibility(8);
            this.bFd.showForumNameView(true);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.bER = str;
    }

    public int go(int i) {
        return com.baidu.tieba.a.d.Qe().L(this.bER, i);
    }
}
