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
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadSourceShareAndPraiseLayout;
import com.baidu.tbadk.core.view.ThreadUserInfoLayout;
import com.baidu.tieba.card.n;
import com.baidu.tieba.d;
/* loaded from: classes4.dex */
public abstract class d extends com.baidu.tieba.card.a<com.baidu.tieba.homepage.concern.b.b> implements com.baidu.tieba.a.e {
    private String YA;
    private final View.OnClickListener ZG;
    private View bFq;
    protected bg bTl;
    private View cSB;
    public ThreadUserInfoLayout dqu;
    public ThreadCommentAndPraiseInfoLayout dqv;
    public ThreadSourceShareAndPraiseLayout drk;
    protected LinearLayout drv;
    private com.baidu.tbadk.core.view.userLike.c ehx;
    private TextView fHp;
    public ConcernUserLikeButton fHq;
    public LinearLayout fHr;
    protected com.baidu.tieba.homepage.concern.b.b fHs;
    protected boolean fHt;
    private View.OnClickListener fHu;
    protected View.OnClickListener fHv;
    private final View.OnClickListener fHw;
    protected TbPageContext<?> mPageContext;
    private int mSkinType;
    protected TextView mTitle;

    protected abstract void ao(bg bgVar);

    protected abstract void bQ(View view);

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.fHt = true;
        this.fHu = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.aQh() != null) {
                    d.this.aQh().a(view, d.this.fHs);
                }
                if (d.this.fHs != null && !StringUtils.isNull(d.this.fHs.fHa.getName()) && !StringUtils.isNull(d.this.fHs.fHa.getUserId())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(d.this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.g.b.d(d.this.fHs.fHa.getUserId(), 0L), false, d.this.fHs.fHa.isGod())));
                }
            }
        };
        this.fHv = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.d.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.aQh() != null) {
                    d.this.aQh().a(view, d.this.fHs);
                }
                d.this.ajX();
            }
        };
        this.ZG = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.d.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.aQh() != null) {
                    d.this.aQh().a(view, d.this.fHs);
                }
            }
        };
        this.fHw = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.d.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == d.g.thread_info_commont_container && d.this.bTl != null) {
                    n.tA(d.this.bTl.getId());
                    d.this.blA();
                }
            }
        };
        View view = getView();
        this.currentPageType = 1;
        this.mPageContext = tbPageContext;
        this.fHp = (TextView) view.findViewById(d.g.card_recommend_god_reason);
        this.fHq = (ConcernUserLikeButton) view.findViewById(d.g.card_recommend_god_user_like_btn);
        this.dqu = (ThreadUserInfoLayout) view.findViewById(d.g.card_rec_god_user_info);
        this.ehx = new com.baidu.tbadk.core.view.userLike.c(tbPageContext, this.fHq);
        this.dqu.setTShowVisible(false);
        this.dqu.getHeaderImg().setAfterClickListener(this.ZG);
        this.fHq.setAfterOnClickListener(this.ZG);
        this.cSB = view.findViewById(d.g.card_recommend_god_divide_line);
        this.bFq = view.findViewById(d.g.divider_line);
        this.fHr = (LinearLayout) view.findViewById(d.g.card_recommend_god_content);
        this.fHr.setOnClickListener(this.fHu);
        this.mTitle = (TextView) view.findViewById(d.g.card_recommend_god_therad_title);
        this.dqv = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.card_recommend_god_therad_info_layout);
        this.dqv.setOnClickListener(this.fHv);
        this.dqv.setReplyTimeVisible(false);
        this.dqv.setIsBarViewVisible(false);
        this.dqv.setShowPraiseNum(true);
        this.dqv.setNeedAddPraiseIcon(true);
        this.dqv.setNeedAddReplyIcon(true);
        this.dqv.setShareVisible(true);
        this.dqv.bSH = this.currentPageType;
        this.dqv.setForumAfterClickListener(this.fHw);
        this.dqv.setShareReportFrom(4);
        this.dqv.setFrom(9);
        this.dqv.setDisPraiseFrom(4);
        this.drk = (ThreadSourceShareAndPraiseLayout) view.findViewById(d.g.card_concern_god_source_read_share_layout);
        this.drk.bTz.setOnClickListener(this.fHv);
        this.drk.bTz.bSH = this.currentPageType;
        this.drk.bTz.setForumAfterClickListener(this.fHw);
        this.drk.setShareReportFrom(4);
        this.drk.setFrom(9);
        this.drv = (LinearLayout) view.findViewById(d.g.card_recommend_god_therad_content_layout);
        bQ(view);
    }

    public void k(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
            this.ehx.i(bdUniqueId);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.k(getView(), d.f.addresslist_item_bg);
            al.j(this.fHp, d.C0277d.cp_cont_d);
            al.l(this.cSB, d.C0277d.cp_bg_line_e);
            al.l(this.bFq, d.C0277d.cp_bg_line_e);
            this.fHq.onChangeSkinType(i);
            this.dqv.onChangeSkinType();
            this.drk.onChangeSkinType();
        }
        this.mSkinType = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.homepage.concern.b.b bVar) {
        if (bVar != null && bVar.fHa != null && !StringUtils.isNull(bVar.fHa.getName()) && !StringUtils.isNull(bVar.fHa.getUserId()) && !StringUtils.isNull(bVar.eNM.getTid())) {
            this.fHs = bVar;
            if (this.dqu != null) {
                this.dqu.setData(bVar.eNM);
                if (this.dqu.getHeaderImg() != null) {
                    this.dqu.getHeaderImg().setData(bVar.metaData);
                }
                this.dqu.onChangeSkinType();
            }
            this.ehx.a(this.fHs.metaData);
            String blz = this.fHs.fHa.blz();
            if (StringUtils.isNull(blz)) {
                this.fHp.setVisibility(8);
            } else {
                this.fHp.setVisibility(0);
                this.fHp.setText(blz);
            }
            this.bTl = bVar.eNM;
            if (n.tB(this.bTl.getId())) {
                blA();
            }
            this.dqv.setData(this.bTl);
            n.b(this.bTl, this.mTitle);
            this.fHt = true;
            if ((StringUtils.isNull(this.bTl.getTitle()) && (this.bTl.YP() == null || this.bTl.YP().size() == 0)) || this.bTl.Zg() == 1) {
                this.bTl.k(false, true);
                if (this.bTl.Zx() == null || StringUtils.isNull(this.bTl.Zx().toString())) {
                    this.fHt = false;
                }
            }
            ao(this.bTl);
            mF(lt(1));
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.fHq != null) {
            this.fHq.setTag(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void blA() {
        n.a(this.mTitle, this.bTl.getId(), d.C0277d.cp_cont_b, d.C0277d.cp_cont_d);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ajX() {
        if (this.fHs != null && this.bTl != null) {
            n.tA(this.bTl.getId());
            blA();
            PbActivityConfig createCfgForPersonCenter = new PbActivityConfig(this.mPageContext.getPageActivity()).createCfgForPersonCenter(this.bTl.getId(), this.bTl.Zh(), n.YE(), 18005);
            createCfgForPersonCenter.setStartFrom(this.currentPageType);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createCfgForPersonCenter));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void mF(int i) {
        if (this.bTl != null) {
            if (i == 1) {
                this.dqv.setVisibility(8);
                this.drk.setData(this.bTl);
                this.dqu.dN(false);
                return;
            }
            this.dqv.setData(this.bTl);
            this.drk.setVisibility(8);
            this.dqu.dN(true);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.YA = str;
    }

    public int lt(int i) {
        return com.baidu.tieba.a.d.awk().ak(this.YA, i);
    }
}
