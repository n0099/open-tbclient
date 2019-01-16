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
    private final View.OnClickListener aLe;
    private View bHh;
    protected bb bOk;
    private com.baidu.tbadk.core.view.userLike.c cXO;
    private String cbk;
    public ThreadUserInfoLayout cbw;
    public ThreadCommentAndPraiseInfoLayout cbx;
    public ThreadSourceShareAndPraiseLayout cck;
    protected LinearLayout ccw;
    private TextView euR;
    public ConcernUserLikeButton euS;
    private View euT;
    public LinearLayout euU;
    protected com.baidu.tieba.homepage.concern.b.b euV;
    protected boolean euW;
    private View.OnClickListener euX;
    protected View.OnClickListener euY;
    private final View.OnClickListener euZ;
    protected TbPageContext<?> mPageContext;
    private int mSkinType;
    protected TextView mTitle;

    protected abstract void aA(View view);

    protected abstract void ag(bb bbVar);

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.euW = true;
        this.euX = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.aqp() != null) {
                    d.this.aqp().a(view, d.this.euV);
                }
                if (d.this.euV != null && !StringUtils.isNull(d.this.euV.euC.getName()) && !StringUtils.isNull(d.this.euV.euC.getUserId())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(d.this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.g.b.d(d.this.euV.euC.getUserId(), 0L), false, d.this.euV.euC.isGod())));
                }
            }
        };
        this.euY = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.d.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.aqp() != null) {
                    d.this.aqp().a(view, d.this.euV);
                }
                d.this.aqJ();
            }
        };
        this.aLe = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.d.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.aqp() != null) {
                    d.this.aqp().a(view, d.this.euV);
                }
            }
        };
        this.euZ = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.d.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == e.g.thread_info_commont_container && d.this.bOk != null) {
                    o.mW(d.this.bOk.getId());
                    d.this.aqu();
                }
            }
        };
        View view = getView();
        this.currentPageType = 1;
        this.mPageContext = tbPageContext;
        this.euR = (TextView) view.findViewById(e.g.card_recommend_god_reason);
        this.euS = (ConcernUserLikeButton) view.findViewById(e.g.card_recommend_god_user_like_btn);
        this.cbw = (ThreadUserInfoLayout) view.findViewById(e.g.card_rec_god_user_info);
        this.cXO = new com.baidu.tbadk.core.view.userLike.c(tbPageContext, this.euS);
        this.cbw.setTShowVisible(false);
        this.cbw.getHeaderImg().setAfterClickListener(this.aLe);
        this.euS.setAfterOnClickListener(this.aLe);
        this.bHh = view.findViewById(e.g.card_recommend_god_divide_line);
        this.euT = view.findViewById(e.g.divider_line);
        this.euU = (LinearLayout) view.findViewById(e.g.card_recommend_god_content);
        this.euU.setOnClickListener(this.euX);
        this.mTitle = (TextView) view.findViewById(e.g.card_recommend_god_therad_title);
        this.cbx = (ThreadCommentAndPraiseInfoLayout) view.findViewById(e.g.card_recommend_god_therad_info_layout);
        this.cbx.setOnClickListener(this.euY);
        this.cbx.setReplyTimeVisible(false);
        this.cbx.setIsBarViewVisible(false);
        this.cbx.setShowPraiseNum(true);
        this.cbx.setNeedAddPraiseIcon(true);
        this.cbx.setNeedAddReplyIcon(true);
        this.cbx.setShareVisible(true);
        this.cbx.awo = this.currentPageType;
        this.cbx.setForumAfterClickListener(this.euZ);
        this.cbx.setShareReportFrom(4);
        this.cbx.setFrom(9);
        this.cbx.setDisPraiseFrom(4);
        this.cck = (ThreadSourceShareAndPraiseLayout) view.findViewById(e.g.card_concern_god_source_read_share_layout);
        this.cck.aKM.setOnClickListener(this.euY);
        this.cck.aKM.awo = this.currentPageType;
        this.cck.aKM.setForumAfterClickListener(this.euZ);
        this.cck.setShareReportFrom(4);
        this.cck.setFrom(9);
        this.ccw = (LinearLayout) view.findViewById(e.g.card_recommend_god_therad_content_layout);
        aA(view);
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
            this.cXO.h(bdUniqueId);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.i(getView(), e.f.addresslist_item_bg);
            al.h(this.euR, e.d.cp_cont_d);
            al.j(this.bHh, e.d.cp_bg_line_e);
            al.j(this.euT, e.d.cp_bg_line_e);
            this.euS.onChangeSkinType(i);
            this.cbx.onChangeSkinType();
            this.cck.onChangeSkinType();
        }
        this.mSkinType = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.homepage.concern.b.b bVar) {
        if (bVar != null && bVar.euC != null && !StringUtils.isNull(bVar.euC.getName()) && !StringUtils.isNull(bVar.euC.getUserId()) && !StringUtils.isNull(bVar.dAv.getTid())) {
            this.euV = bVar;
            if (this.cbw != null) {
                this.cbw.setData(bVar.dAv);
                if (this.cbw.getHeaderImg() != null) {
                    this.cbw.getHeaderImg().setData(bVar.metaData);
                }
                this.cbw.onChangeSkinType();
            }
            this.cXO.a(this.euV.metaData);
            String aLx = this.euV.euC.aLx();
            if (StringUtils.isNull(aLx)) {
                this.euR.setVisibility(8);
            } else {
                this.euR.setVisibility(0);
                this.euR.setText(aLx);
            }
            this.bOk = bVar.dAv;
            if (o.mX(this.bOk.getId())) {
                aqu();
            }
            this.cbx.setData(this.bOk);
            o.b(this.bOk, this.mTitle);
            this.euW = true;
            if ((StringUtils.isNull(this.bOk.getTitle()) && (this.bOk.zR() == null || this.bOk.zR().size() == 0)) || this.bOk.Aj() == 1) {
                this.bOk.g(false, true);
                if (this.bOk.At() == null || StringUtils.isNull(this.bOk.At().toString())) {
                    this.euW = false;
                }
            }
            ag(this.bOk);
            iM(hD(1));
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.euS != null) {
            this.euS.setTag(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aqu() {
        o.a(this.mTitle, this.bOk.getId(), e.d.cp_cont_b, e.d.cp_cont_d);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aqJ() {
        if (this.euV != null && this.bOk != null) {
            o.mW(this.bOk.getId());
            aqu();
            PbActivityConfig createCfgForPersonCenter = new PbActivityConfig(this.mPageContext.getPageActivity()).createCfgForPersonCenter(this.bOk.getId(), this.bOk.Ak(), o.zH(), 18005);
            createCfgForPersonCenter.setStartFrom(this.currentPageType);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createCfgForPersonCenter));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void iM(int i) {
        if (this.bOk != null) {
            if (i == 1) {
                this.cbx.setVisibility(8);
                this.cck.setData(this.bOk);
                this.cbw.showForumNameView(false);
                return;
            }
            this.cbx.setData(this.bOk);
            this.cck.setVisibility(8);
            this.cbw.showForumNameView(true);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.cbk = str;
    }

    public int hD(int i) {
        return com.baidu.tieba.a.d.Wk().N(this.cbk, i);
    }
}
