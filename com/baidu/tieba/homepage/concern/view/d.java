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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadSourceShareAndPraiseLayout;
import com.baidu.tbadk.core.view.ThreadUserInfoLayout;
import com.baidu.tieba.card.o;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public abstract class d extends com.baidu.tieba.card.a<com.baidu.tieba.homepage.concern.b.b> implements com.baidu.tieba.a.e {
    private final View.OnClickListener axO;
    private String bHB;
    public ThreadUserInfoLayout bHN;
    public ThreadCommentAndPraiseInfoLayout bHO;
    public ThreadSourceShareAndPraiseLayout bIC;
    protected LinearLayout bIN;
    protected bb buw;
    private com.baidu.tbadk.core.view.userLike.c cyt;
    private View dKC;
    private TextView dTX;
    public ConcernUserLikeButton dTY;
    private View dTZ;
    public LinearLayout dUa;
    protected com.baidu.tieba.homepage.concern.b.b dUb;
    protected boolean dUc;
    private View.OnClickListener dUd;
    protected View.OnClickListener dUe;
    private final View.OnClickListener dUf;
    protected TbPageContext<?> mPageContext;
    private int mSkinType;
    protected TextView mTitle;

    protected abstract void af(bb bbVar);

    protected abstract void ah(View view);

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.dUc = true;
        this.dUd = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.aiz() != null) {
                    d.this.aiz().a(view, d.this.dUb);
                }
                if (d.this.dUb != null && !StringUtils.isNull(d.this.dUb.dTI.getName()) && !StringUtils.isNull(d.this.dUb.dTI.getUserId())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(d.this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.g.b.c(d.this.dUb.dTI.getUserId(), 0L), false, d.this.dUb.dTI.isGod())));
                }
            }
        };
        this.dUe = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.d.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.aiz() != null) {
                    d.this.aiz().a(view, d.this.dUb);
                }
                d.this.aiS();
            }
        };
        this.axO = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.d.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.aiz() != null) {
                    d.this.aiz().a(view, d.this.dUb);
                }
            }
        };
        this.dUf = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.d.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == d.g.thread_info_commont_container && d.this.buw != null) {
                    o.kW(d.this.buw.getId());
                    d.this.aiE();
                }
            }
        };
        View view = getView();
        this.currentPageType = 1;
        this.mPageContext = tbPageContext;
        this.dTX = (TextView) view.findViewById(d.g.card_recommend_god_reason);
        this.dTY = (ConcernUserLikeButton) view.findViewById(d.g.card_recommend_god_user_like_btn);
        this.bHN = (ThreadUserInfoLayout) view.findViewById(d.g.card_rec_god_user_info);
        this.cyt = new com.baidu.tbadk.core.view.userLike.c(tbPageContext, this.dTY);
        this.bHN.setTShowVisible(false);
        this.bHN.getHeaderImg().setAfterClickListener(this.axO);
        this.dTY.setAfterOnClickListener(this.axO);
        this.dKC = view.findViewById(d.g.card_recommend_god_divide_line);
        this.dTZ = view.findViewById(d.g.divider_line);
        this.dUa = (LinearLayout) view.findViewById(d.g.card_recommend_god_content);
        this.dUa.setOnClickListener(this.dUd);
        this.mTitle = (TextView) view.findViewById(d.g.card_recommend_god_therad_title);
        this.bHO = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.card_recommend_god_therad_info_layout);
        this.bHO.setOnClickListener(this.dUe);
        this.bHO.setReplyTimeVisible(false);
        this.bHO.setIsBarViewVisible(false);
        this.bHO.setShowPraiseNum(true);
        this.bHO.setNeedAddPraiseIcon(true);
        this.bHO.setNeedAddReplyIcon(true);
        this.bHO.setShareVisible(true);
        this.bHO.ajY = this.currentPageType;
        this.bHO.setForumAfterClickListener(this.dUf);
        this.bHO.setShareReportFrom(4);
        this.bHO.setFrom(9);
        this.bIC = (ThreadSourceShareAndPraiseLayout) view.findViewById(d.g.card_concern_god_source_read_share_layout);
        this.bIC.ayr.setOnClickListener(this.dUe);
        this.bIC.ayr.ajY = this.currentPageType;
        this.bIC.ayr.setForumAfterClickListener(this.dUf);
        this.bIC.setShareReportFrom(4);
        this.bIC.setFrom(9);
        this.bIN = (LinearLayout) view.findViewById(d.g.card_recommend_god_therad_content_layout);
        ah(view);
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
            this.cyt.h(bdUniqueId);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.i(getView(), d.f.addresslist_item_bg);
            am.h(this.dTX, d.C0140d.cp_cont_d);
            am.j(this.dKC, d.C0140d.cp_bg_line_e);
            am.j(this.dTZ, d.C0140d.cp_bg_line_e);
            this.dTY.onChangeSkinType(i);
            this.bHO.onChangeSkinType();
            this.bIC.onChangeSkinType();
        }
        this.mSkinType = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.homepage.concern.b.b bVar) {
        if (bVar != null && bVar.dTI != null && !StringUtils.isNull(bVar.dTI.getName()) && !StringUtils.isNull(bVar.dTI.getUserId()) && !StringUtils.isNull(bVar.dbA.getTid())) {
            this.dUb = bVar;
            if (this.bHN != null) {
                this.bHN.setData(bVar.dbA);
                if (this.bHN.getHeaderImg() != null) {
                    this.bHN.getHeaderImg().setData(bVar.metaData);
                }
                this.bHN.onChangeSkinType();
            }
            this.cyt.a(this.dUb.metaData);
            String aDt = this.dUb.dTI.aDt();
            if (StringUtils.isNull(aDt)) {
                this.dTX.setVisibility(8);
            } else {
                this.dTX.setVisibility(0);
                this.dTX.setText(aDt);
            }
            this.buw = bVar.dbA;
            if (o.kX(this.buw.getId())) {
                aiE();
            }
            this.bHO.setData(this.buw);
            o.b(this.buw, this.mTitle);
            this.dUc = true;
            if ((StringUtils.isNull(this.buw.getTitle()) && (this.buw.vi() == null || this.buw.vi().size() == 0)) || this.buw.vA() == 1) {
                this.buw.e(false, true);
                if (this.buw.vJ() == null || StringUtils.isNull(this.buw.vJ().toString())) {
                    this.dUc = false;
                }
            }
            af(this.buw);
            hn(gu(1));
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.dTY != null) {
            this.dTY.setTag(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aiE() {
        o.a(this.mTitle, this.buw.getId(), d.C0140d.cp_cont_b, d.C0140d.cp_cont_d);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aiS() {
        if (this.dUb != null && this.buw != null) {
            o.kW(this.buw.getId());
            aiE();
            PbActivityConfig createCfgForPersonCenter = new PbActivityConfig(this.mPageContext.getPageActivity()).createCfgForPersonCenter(this.buw.getId(), this.buw.vB(), o.uY(), 18005);
            createCfgForPersonCenter.setStartFrom(this.currentPageType);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createCfgForPersonCenter));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void hn(int i) {
        if (this.buw != null) {
            if (i == 1) {
                this.bHO.setVisibility(8);
                this.bIC.setData(this.buw);
                this.bHN.showForumNameView(false);
                return;
            }
            this.bHO.setData(this.buw);
            this.bIC.setVisibility(8);
            this.bHN.showForumNameView(true);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.bHB = str;
    }

    public int gu(int i) {
        return com.baidu.tieba.a.d.QI().G(this.bHB, i);
    }
}
