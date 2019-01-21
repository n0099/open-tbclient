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
    private final View.OnClickListener aLf;
    private View bHi;
    protected bb bOl;
    private com.baidu.tbadk.core.view.userLike.c cXP;
    private String cbl;
    public ThreadUserInfoLayout cbx;
    public ThreadCommentAndPraiseInfoLayout cby;
    public ThreadSourceShareAndPraiseLayout ccl;
    protected LinearLayout ccx;
    private TextView euS;
    public ConcernUserLikeButton euT;
    private View euU;
    public LinearLayout euV;
    protected com.baidu.tieba.homepage.concern.b.b euW;
    protected boolean euX;
    private View.OnClickListener euY;
    protected View.OnClickListener euZ;
    private final View.OnClickListener eva;
    protected TbPageContext<?> mPageContext;
    private int mSkinType;
    protected TextView mTitle;

    protected abstract void aA(View view);

    protected abstract void ag(bb bbVar);

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.euX = true;
        this.euY = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.aqp() != null) {
                    d.this.aqp().a(view, d.this.euW);
                }
                if (d.this.euW != null && !StringUtils.isNull(d.this.euW.euD.getName()) && !StringUtils.isNull(d.this.euW.euD.getUserId())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(d.this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.g.b.d(d.this.euW.euD.getUserId(), 0L), false, d.this.euW.euD.isGod())));
                }
            }
        };
        this.euZ = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.d.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.aqp() != null) {
                    d.this.aqp().a(view, d.this.euW);
                }
                d.this.aqJ();
            }
        };
        this.aLf = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.d.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.aqp() != null) {
                    d.this.aqp().a(view, d.this.euW);
                }
            }
        };
        this.eva = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.d.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == e.g.thread_info_commont_container && d.this.bOl != null) {
                    o.mW(d.this.bOl.getId());
                    d.this.aqu();
                }
            }
        };
        View view = getView();
        this.currentPageType = 1;
        this.mPageContext = tbPageContext;
        this.euS = (TextView) view.findViewById(e.g.card_recommend_god_reason);
        this.euT = (ConcernUserLikeButton) view.findViewById(e.g.card_recommend_god_user_like_btn);
        this.cbx = (ThreadUserInfoLayout) view.findViewById(e.g.card_rec_god_user_info);
        this.cXP = new com.baidu.tbadk.core.view.userLike.c(tbPageContext, this.euT);
        this.cbx.setTShowVisible(false);
        this.cbx.getHeaderImg().setAfterClickListener(this.aLf);
        this.euT.setAfterOnClickListener(this.aLf);
        this.bHi = view.findViewById(e.g.card_recommend_god_divide_line);
        this.euU = view.findViewById(e.g.divider_line);
        this.euV = (LinearLayout) view.findViewById(e.g.card_recommend_god_content);
        this.euV.setOnClickListener(this.euY);
        this.mTitle = (TextView) view.findViewById(e.g.card_recommend_god_therad_title);
        this.cby = (ThreadCommentAndPraiseInfoLayout) view.findViewById(e.g.card_recommend_god_therad_info_layout);
        this.cby.setOnClickListener(this.euZ);
        this.cby.setReplyTimeVisible(false);
        this.cby.setIsBarViewVisible(false);
        this.cby.setShowPraiseNum(true);
        this.cby.setNeedAddPraiseIcon(true);
        this.cby.setNeedAddReplyIcon(true);
        this.cby.setShareVisible(true);
        this.cby.awp = this.currentPageType;
        this.cby.setForumAfterClickListener(this.eva);
        this.cby.setShareReportFrom(4);
        this.cby.setFrom(9);
        this.cby.setDisPraiseFrom(4);
        this.ccl = (ThreadSourceShareAndPraiseLayout) view.findViewById(e.g.card_concern_god_source_read_share_layout);
        this.ccl.aKN.setOnClickListener(this.euZ);
        this.ccl.aKN.awp = this.currentPageType;
        this.ccl.aKN.setForumAfterClickListener(this.eva);
        this.ccl.setShareReportFrom(4);
        this.ccl.setFrom(9);
        this.ccx = (LinearLayout) view.findViewById(e.g.card_recommend_god_therad_content_layout);
        aA(view);
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
            this.cXP.h(bdUniqueId);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.i(getView(), e.f.addresslist_item_bg);
            al.h(this.euS, e.d.cp_cont_d);
            al.j(this.bHi, e.d.cp_bg_line_e);
            al.j(this.euU, e.d.cp_bg_line_e);
            this.euT.onChangeSkinType(i);
            this.cby.onChangeSkinType();
            this.ccl.onChangeSkinType();
        }
        this.mSkinType = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.homepage.concern.b.b bVar) {
        if (bVar != null && bVar.euD != null && !StringUtils.isNull(bVar.euD.getName()) && !StringUtils.isNull(bVar.euD.getUserId()) && !StringUtils.isNull(bVar.dAw.getTid())) {
            this.euW = bVar;
            if (this.cbx != null) {
                this.cbx.setData(bVar.dAw);
                if (this.cbx.getHeaderImg() != null) {
                    this.cbx.getHeaderImg().setData(bVar.metaData);
                }
                this.cbx.onChangeSkinType();
            }
            this.cXP.a(this.euW.metaData);
            String aLx = this.euW.euD.aLx();
            if (StringUtils.isNull(aLx)) {
                this.euS.setVisibility(8);
            } else {
                this.euS.setVisibility(0);
                this.euS.setText(aLx);
            }
            this.bOl = bVar.dAw;
            if (o.mX(this.bOl.getId())) {
                aqu();
            }
            this.cby.setData(this.bOl);
            o.b(this.bOl, this.mTitle);
            this.euX = true;
            if ((StringUtils.isNull(this.bOl.getTitle()) && (this.bOl.zR() == null || this.bOl.zR().size() == 0)) || this.bOl.Aj() == 1) {
                this.bOl.g(false, true);
                if (this.bOl.At() == null || StringUtils.isNull(this.bOl.At().toString())) {
                    this.euX = false;
                }
            }
            ag(this.bOl);
            iM(hD(1));
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.euT != null) {
            this.euT.setTag(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aqu() {
        o.a(this.mTitle, this.bOl.getId(), e.d.cp_cont_b, e.d.cp_cont_d);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aqJ() {
        if (this.euW != null && this.bOl != null) {
            o.mW(this.bOl.getId());
            aqu();
            PbActivityConfig createCfgForPersonCenter = new PbActivityConfig(this.mPageContext.getPageActivity()).createCfgForPersonCenter(this.bOl.getId(), this.bOl.Ak(), o.zH(), 18005);
            createCfgForPersonCenter.setStartFrom(this.currentPageType);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createCfgForPersonCenter));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void iM(int i) {
        if (this.bOl != null) {
            if (i == 1) {
                this.cby.setVisibility(8);
                this.ccl.setData(this.bOl);
                this.cbx.showForumNameView(false);
                return;
            }
            this.cby.setData(this.bOl);
            this.ccl.setVisibility(8);
            this.cbx.showForumNameView(true);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.cbl = str;
    }

    public int hD(int i) {
        return com.baidu.tieba.a.d.Wk().N(this.cbl, i);
    }
}
