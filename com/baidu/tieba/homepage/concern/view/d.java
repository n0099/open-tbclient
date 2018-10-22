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
/* loaded from: classes6.dex */
public abstract class d extends com.baidu.tieba.card.a<com.baidu.tieba.homepage.concern.b.b> implements com.baidu.tieba.a.e {
    private final View.OnClickListener aGk;
    private View bCm;
    protected bb bIV;
    private String bVS;
    public ThreadSourceShareAndPraiseLayout bWS;
    public ThreadUserInfoLayout bWe;
    public ThreadCommentAndPraiseInfoLayout bWf;
    protected LinearLayout bXd;
    private com.baidu.tbadk.core.view.userLike.c cMA;
    private TextView ejf;
    public ConcernUserLikeButton ejg;
    private View ejh;
    public LinearLayout eji;
    protected com.baidu.tieba.homepage.concern.b.b ejj;
    protected boolean ejk;
    private View.OnClickListener ejl;
    protected View.OnClickListener ejm;
    private final View.OnClickListener ejn;
    protected TbPageContext<?> mPageContext;
    private int mSkinType;
    protected TextView mTitle;

    protected abstract void ag(bb bbVar);

    protected abstract void av(View view);

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.ejk = true;
        this.ejl = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.anP() != null) {
                    d.this.anP().a(view, d.this.ejj);
                }
                if (d.this.ejj != null && !StringUtils.isNull(d.this.ejj.eiQ.getName()) && !StringUtils.isNull(d.this.ejj.eiQ.getUserId())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(d.this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.g.b.d(d.this.ejj.eiQ.getUserId(), 0L), false, d.this.ejj.eiQ.isGod())));
                }
            }
        };
        this.ejm = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.d.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.anP() != null) {
                    d.this.anP().a(view, d.this.ejj);
                }
                d.this.aoj();
            }
        };
        this.aGk = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.d.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.anP() != null) {
                    d.this.anP().a(view, d.this.ejj);
                }
            }
        };
        this.ejn = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.d.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == e.g.thread_info_commont_container && d.this.bIV != null) {
                    o.md(d.this.bIV.getId());
                    d.this.anU();
                }
            }
        };
        View view = getView();
        this.currentPageType = 1;
        this.mPageContext = tbPageContext;
        this.ejf = (TextView) view.findViewById(e.g.card_recommend_god_reason);
        this.ejg = (ConcernUserLikeButton) view.findViewById(e.g.card_recommend_god_user_like_btn);
        this.bWe = (ThreadUserInfoLayout) view.findViewById(e.g.card_rec_god_user_info);
        this.cMA = new com.baidu.tbadk.core.view.userLike.c(tbPageContext, this.ejg);
        this.bWe.setTShowVisible(false);
        this.bWe.getHeaderImg().setAfterClickListener(this.aGk);
        this.ejg.setAfterOnClickListener(this.aGk);
        this.bCm = view.findViewById(e.g.card_recommend_god_divide_line);
        this.ejh = view.findViewById(e.g.divider_line);
        this.eji = (LinearLayout) view.findViewById(e.g.card_recommend_god_content);
        this.eji.setOnClickListener(this.ejl);
        this.mTitle = (TextView) view.findViewById(e.g.card_recommend_god_therad_title);
        this.bWf = (ThreadCommentAndPraiseInfoLayout) view.findViewById(e.g.card_recommend_god_therad_info_layout);
        this.bWf.setOnClickListener(this.ejm);
        this.bWf.setReplyTimeVisible(false);
        this.bWf.setIsBarViewVisible(false);
        this.bWf.setShowPraiseNum(true);
        this.bWf.setNeedAddPraiseIcon(true);
        this.bWf.setNeedAddReplyIcon(true);
        this.bWf.setShareVisible(true);
        this.bWf.ary = this.currentPageType;
        this.bWf.setForumAfterClickListener(this.ejn);
        this.bWf.setShareReportFrom(4);
        this.bWf.setFrom(9);
        this.bWf.setDisPraiseFrom(4);
        this.bWS = (ThreadSourceShareAndPraiseLayout) view.findViewById(e.g.card_concern_god_source_read_share_layout);
        this.bWS.aFS.setOnClickListener(this.ejm);
        this.bWS.aFS.ary = this.currentPageType;
        this.bWS.aFS.setForumAfterClickListener(this.ejn);
        this.bWS.setShareReportFrom(4);
        this.bWS.setFrom(9);
        this.bXd = (LinearLayout) view.findViewById(e.g.card_recommend_god_therad_content_layout);
        av(view);
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
            this.cMA.h(bdUniqueId);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.i(getView(), e.f.addresslist_item_bg);
            al.h(this.ejf, e.d.cp_cont_d);
            al.j(this.bCm, e.d.cp_bg_line_e);
            al.j(this.ejh, e.d.cp_bg_line_e);
            this.ejg.onChangeSkinType(i);
            this.bWf.onChangeSkinType();
            this.bWS.onChangeSkinType();
        }
        this.mSkinType = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.homepage.concern.b.b bVar) {
        if (bVar != null && bVar.eiQ != null && !StringUtils.isNull(bVar.eiQ.getName()) && !StringUtils.isNull(bVar.eiQ.getUserId()) && !StringUtils.isNull(bVar.dpv.getTid())) {
            this.ejj = bVar;
            if (this.bWe != null) {
                this.bWe.setData(bVar.dpv);
                if (this.bWe.getHeaderImg() != null) {
                    this.bWe.getHeaderImg().setData(bVar.metaData);
                }
                this.bWe.onChangeSkinType();
            }
            this.cMA.a(this.ejj.metaData);
            String aIV = this.ejj.eiQ.aIV();
            if (StringUtils.isNull(aIV)) {
                this.ejf.setVisibility(8);
            } else {
                this.ejf.setVisibility(0);
                this.ejf.setText(aIV);
            }
            this.bIV = bVar.dpv;
            if (o.me(this.bIV.getId())) {
                anU();
            }
            this.bWf.setData(this.bIV);
            o.b(this.bIV, this.mTitle);
            this.ejk = true;
            if ((StringUtils.isNull(this.bIV.getTitle()) && (this.bIV.yt() == null || this.bIV.yt().size() == 0)) || this.bIV.yL() == 1) {
                this.bIV.g(false, true);
                if (this.bIV.yV() == null || StringUtils.isNull(this.bIV.yV().toString())) {
                    this.ejk = false;
                }
            }
            ag(this.bIV);
            ik(hb(1));
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.ejg != null) {
            this.ejg.setTag(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void anU() {
        o.a(this.mTitle, this.bIV.getId(), e.d.cp_cont_b, e.d.cp_cont_d);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aoj() {
        if (this.ejj != null && this.bIV != null) {
            o.md(this.bIV.getId());
            anU();
            PbActivityConfig createCfgForPersonCenter = new PbActivityConfig(this.mPageContext.getPageActivity()).createCfgForPersonCenter(this.bIV.getId(), this.bIV.yM(), o.yj(), 18005);
            createCfgForPersonCenter.setStartFrom(this.currentPageType);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createCfgForPersonCenter));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void ik(int i) {
        if (this.bIV != null) {
            if (i == 1) {
                this.bWf.setVisibility(8);
                this.bWS.setData(this.bIV);
                this.bWe.showForumNameView(false);
                return;
            }
            this.bWf.setData(this.bIV);
            this.bWS.setVisibility(8);
            this.bWe.showForumNameView(true);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.bVS = str;
    }

    public int hb(int i) {
        return com.baidu.tieba.a.d.Ux().M(this.bVS, i);
    }
}
