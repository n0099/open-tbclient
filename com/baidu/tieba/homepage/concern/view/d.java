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
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadSourceShareAndPraiseLayout;
import com.baidu.tbadk.core.view.ThreadUserInfoLayout;
import com.baidu.tieba.card.o;
import com.baidu.tieba.e;
/* loaded from: classes2.dex */
public abstract class d extends com.baidu.tieba.card.a<com.baidu.tieba.homepage.concern.b.b> implements com.baidu.tieba.a.e {
    private final View.OnClickListener aBE;
    protected bb bAn;
    public ThreadUserInfoLayout bNC;
    public ThreadCommentAndPraiseInfoLayout bND;
    private String bNq;
    protected LinearLayout bOC;
    public ThreadSourceShareAndPraiseLayout bOr;
    private com.baidu.tbadk.core.view.userLike.c cEg;
    private View dRI;
    private TextView ebl;
    public ConcernUserLikeButton ebm;
    private View ebn;
    public LinearLayout ebo;
    protected com.baidu.tieba.homepage.concern.b.b ebp;
    protected boolean ebq;
    private View.OnClickListener ebr;
    protected View.OnClickListener ebs;
    private final View.OnClickListener ebt;
    protected TbPageContext<?> mPageContext;
    private int mSkinType;
    protected TextView mTitle;

    protected abstract void ag(bb bbVar);

    protected abstract void av(View view);

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.ebq = true;
        this.ebr = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.akm() != null) {
                    d.this.akm().a(view, d.this.ebp);
                }
                if (d.this.ebp != null && !StringUtils.isNull(d.this.ebp.eaW.getName()) && !StringUtils.isNull(d.this.ebp.eaW.getUserId())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(d.this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.g.b.d(d.this.ebp.eaW.getUserId(), 0L), false, d.this.ebp.eaW.isGod())));
                }
            }
        };
        this.ebs = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.d.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.akm() != null) {
                    d.this.akm().a(view, d.this.ebp);
                }
                d.this.akG();
            }
        };
        this.aBE = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.d.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.akm() != null) {
                    d.this.akm().a(view, d.this.ebp);
                }
            }
        };
        this.ebt = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.d.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == e.g.thread_info_commont_container && d.this.bAn != null) {
                    o.lA(d.this.bAn.getId());
                    d.this.akr();
                }
            }
        };
        View view = getView();
        this.currentPageType = 1;
        this.mPageContext = tbPageContext;
        this.ebl = (TextView) view.findViewById(e.g.card_recommend_god_reason);
        this.ebm = (ConcernUserLikeButton) view.findViewById(e.g.card_recommend_god_user_like_btn);
        this.bNC = (ThreadUserInfoLayout) view.findViewById(e.g.card_rec_god_user_info);
        this.cEg = new com.baidu.tbadk.core.view.userLike.c(tbPageContext, this.ebm);
        this.bNC.setTShowVisible(false);
        this.bNC.getHeaderImg().setAfterClickListener(this.aBE);
        this.ebm.setAfterOnClickListener(this.aBE);
        this.dRI = view.findViewById(e.g.card_recommend_god_divide_line);
        this.ebn = view.findViewById(e.g.divider_line);
        this.ebo = (LinearLayout) view.findViewById(e.g.card_recommend_god_content);
        this.ebo.setOnClickListener(this.ebr);
        this.mTitle = (TextView) view.findViewById(e.g.card_recommend_god_therad_title);
        this.bND = (ThreadCommentAndPraiseInfoLayout) view.findViewById(e.g.card_recommend_god_therad_info_layout);
        this.bND.setOnClickListener(this.ebs);
        this.bND.setReplyTimeVisible(false);
        this.bND.setIsBarViewVisible(false);
        this.bND.setShowPraiseNum(true);
        this.bND.setNeedAddPraiseIcon(true);
        this.bND.setNeedAddReplyIcon(true);
        this.bND.setShareVisible(true);
        this.bND.amD = this.currentPageType;
        this.bND.setForumAfterClickListener(this.ebt);
        this.bND.setShareReportFrom(4);
        this.bND.setFrom(9);
        this.bND.setDisPraiseFrom(4);
        this.bOr = (ThreadSourceShareAndPraiseLayout) view.findViewById(e.g.card_concern_god_source_read_share_layout);
        this.bOr.aBl.setOnClickListener(this.ebs);
        this.bOr.aBl.amD = this.currentPageType;
        this.bOr.aBl.setForumAfterClickListener(this.ebt);
        this.bOr.setShareReportFrom(4);
        this.bOr.setFrom(9);
        this.bOC = (LinearLayout) view.findViewById(e.g.card_recommend_god_therad_content_layout);
        av(view);
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
            this.cEg.h(bdUniqueId);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.i(getView(), e.f.addresslist_item_bg);
            al.h(this.ebl, e.d.cp_cont_d);
            al.j(this.dRI, e.d.cp_bg_line_e);
            al.j(this.ebn, e.d.cp_bg_line_e);
            this.ebm.onChangeSkinType(i);
            this.bND.onChangeSkinType();
            this.bOr.onChangeSkinType();
        }
        this.mSkinType = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.homepage.concern.b.b bVar) {
        if (bVar != null && bVar.eaW != null && !StringUtils.isNull(bVar.eaW.getName()) && !StringUtils.isNull(bVar.eaW.getUserId()) && !StringUtils.isNull(bVar.dhr.getTid())) {
            this.ebp = bVar;
            if (this.bNC != null) {
                this.bNC.setData(bVar.dhr);
                if (this.bNC.getHeaderImg() != null) {
                    this.bNC.getHeaderImg().setData(bVar.metaData);
                }
                this.bNC.onChangeSkinType();
            }
            this.cEg.a(this.ebp.metaData);
            String aFD = this.ebp.eaW.aFD();
            if (StringUtils.isNull(aFD)) {
                this.ebl.setVisibility(8);
            } else {
                this.ebl.setVisibility(0);
                this.ebl.setText(aFD);
            }
            this.bAn = bVar.dhr;
            if (o.lB(this.bAn.getId())) {
                akr();
            }
            this.bND.setData(this.bAn);
            o.b(this.bAn, this.mTitle);
            this.ebq = true;
            if ((StringUtils.isNull(this.bAn.getTitle()) && (this.bAn.wk() == null || this.bAn.wk().size() == 0)) || this.bAn.wC() == 1) {
                this.bAn.g(false, true);
                if (this.bAn.wM() == null || StringUtils.isNull(this.bAn.wM().toString())) {
                    this.ebq = false;
                }
            }
            ag(this.bAn);
            hM(gT(1));
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.ebm != null) {
            this.ebm.setTag(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void akr() {
        o.a(this.mTitle, this.bAn.getId(), e.d.cp_cont_b, e.d.cp_cont_d);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void akG() {
        if (this.ebp != null && this.bAn != null) {
            o.lA(this.bAn.getId());
            akr();
            PbActivityConfig createCfgForPersonCenter = new PbActivityConfig(this.mPageContext.getPageActivity()).createCfgForPersonCenter(this.bAn.getId(), this.bAn.wD(), o.wa(), 18005);
            createCfgForPersonCenter.setStartFrom(this.currentPageType);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createCfgForPersonCenter));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void hM(int i) {
        if (this.bAn != null) {
            if (i == 1) {
                this.bND.setVisibility(8);
                this.bOr.setData(this.bAn);
                this.bNC.showForumNameView(false);
                return;
            }
            this.bND.setData(this.bAn);
            this.bOr.setVisibility(8);
            this.bNC.showForumNameView(true);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.bNq = str;
    }

    public int gT(int i) {
        return com.baidu.tieba.a.d.SB().L(this.bNq, i);
    }
}
