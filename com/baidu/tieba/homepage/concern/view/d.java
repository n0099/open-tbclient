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
    private final View.OnClickListener ZH;
    private View bFs;
    protected bg bTn;
    private View cSD;
    public ThreadUserInfoLayout dqx;
    public ThreadCommentAndPraiseInfoLayout dqy;
    public ThreadSourceShareAndPraiseLayout drn;
    protected LinearLayout dry;
    private com.baidu.tbadk.core.view.userLike.c ehj;
    private TextView fHd;
    public ConcernUserLikeButton fHe;
    public LinearLayout fHf;
    protected com.baidu.tieba.homepage.concern.b.b fHg;
    protected boolean fHh;
    private View.OnClickListener fHi;
    protected View.OnClickListener fHj;
    private final View.OnClickListener fHk;
    protected TbPageContext<?> mPageContext;
    private int mSkinType;
    protected TextView mTitle;

    protected abstract void an(bg bgVar);

    protected abstract void bQ(View view);

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.fHh = true;
        this.fHi = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.aQf() != null) {
                    d.this.aQf().a(view, d.this.fHg);
                }
                if (d.this.fHg != null && !StringUtils.isNull(d.this.fHg.fGO.getName()) && !StringUtils.isNull(d.this.fHg.fGO.getUserId())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(d.this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.g.b.d(d.this.fHg.fGO.getUserId(), 0L), false, d.this.fHg.fGO.isGod())));
                }
            }
        };
        this.fHj = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.d.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.aQf() != null) {
                    d.this.aQf().a(view, d.this.fHg);
                }
                d.this.ajU();
            }
        };
        this.ZH = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.d.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.aQf() != null) {
                    d.this.aQf().a(view, d.this.fHg);
                }
            }
        };
        this.fHk = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.d.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == d.g.thread_info_commont_container && d.this.bTn != null) {
                    n.tz(d.this.bTn.getId());
                    d.this.blx();
                }
            }
        };
        View view = getView();
        this.currentPageType = 1;
        this.mPageContext = tbPageContext;
        this.fHd = (TextView) view.findViewById(d.g.card_recommend_god_reason);
        this.fHe = (ConcernUserLikeButton) view.findViewById(d.g.card_recommend_god_user_like_btn);
        this.dqx = (ThreadUserInfoLayout) view.findViewById(d.g.card_rec_god_user_info);
        this.ehj = new com.baidu.tbadk.core.view.userLike.c(tbPageContext, this.fHe);
        this.dqx.setTShowVisible(false);
        this.dqx.getHeaderImg().setAfterClickListener(this.ZH);
        this.fHe.setAfterOnClickListener(this.ZH);
        this.cSD = view.findViewById(d.g.card_recommend_god_divide_line);
        this.bFs = view.findViewById(d.g.divider_line);
        this.fHf = (LinearLayout) view.findViewById(d.g.card_recommend_god_content);
        this.fHf.setOnClickListener(this.fHi);
        this.mTitle = (TextView) view.findViewById(d.g.card_recommend_god_therad_title);
        this.dqy = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.card_recommend_god_therad_info_layout);
        this.dqy.setOnClickListener(this.fHj);
        this.dqy.setReplyTimeVisible(false);
        this.dqy.setIsBarViewVisible(false);
        this.dqy.setShowPraiseNum(true);
        this.dqy.setNeedAddPraiseIcon(true);
        this.dqy.setNeedAddReplyIcon(true);
        this.dqy.setShareVisible(true);
        this.dqy.bSJ = this.currentPageType;
        this.dqy.setForumAfterClickListener(this.fHk);
        this.dqy.setShareReportFrom(4);
        this.dqy.setFrom(9);
        this.dqy.setDisPraiseFrom(4);
        this.drn = (ThreadSourceShareAndPraiseLayout) view.findViewById(d.g.card_concern_god_source_read_share_layout);
        this.drn.bTB.setOnClickListener(this.fHj);
        this.drn.bTB.bSJ = this.currentPageType;
        this.drn.bTB.setForumAfterClickListener(this.fHk);
        this.drn.setShareReportFrom(4);
        this.drn.setFrom(9);
        this.dry = (LinearLayout) view.findViewById(d.g.card_recommend_god_therad_content_layout);
        bQ(view);
    }

    public void k(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
            this.ehj.i(bdUniqueId);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.k(getView(), d.f.addresslist_item_bg);
            al.j(this.fHd, d.C0277d.cp_cont_d);
            al.l(this.cSD, d.C0277d.cp_bg_line_e);
            al.l(this.bFs, d.C0277d.cp_bg_line_e);
            this.fHe.onChangeSkinType(i);
            this.dqy.onChangeSkinType();
            this.drn.onChangeSkinType();
        }
        this.mSkinType = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.homepage.concern.b.b bVar) {
        if (bVar != null && bVar.fGO != null && !StringUtils.isNull(bVar.fGO.getName()) && !StringUtils.isNull(bVar.fGO.getUserId()) && !StringUtils.isNull(bVar.eNy.getTid())) {
            this.fHg = bVar;
            if (this.dqx != null) {
                this.dqx.setData(bVar.eNy);
                if (this.dqx.getHeaderImg() != null) {
                    this.dqx.getHeaderImg().setData(bVar.metaData);
                }
                this.dqx.onChangeSkinType();
            }
            this.ehj.a(this.fHg.metaData);
            String blw = this.fHg.fGO.blw();
            if (StringUtils.isNull(blw)) {
                this.fHd.setVisibility(8);
            } else {
                this.fHd.setVisibility(0);
                this.fHd.setText(blw);
            }
            this.bTn = bVar.eNy;
            if (n.tA(this.bTn.getId())) {
                blx();
            }
            this.dqy.setData(this.bTn);
            n.b(this.bTn, this.mTitle);
            this.fHh = true;
            if ((StringUtils.isNull(this.bTn.getTitle()) && (this.bTn.YM() == null || this.bTn.YM().size() == 0)) || this.bTn.Zd() == 1) {
                this.bTn.k(false, true);
                if (this.bTn.Zu() == null || StringUtils.isNull(this.bTn.Zu().toString())) {
                    this.fHh = false;
                }
            }
            an(this.bTn);
            mE(ls(1));
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.fHe != null) {
            this.fHe.setTag(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void blx() {
        n.a(this.mTitle, this.bTn.getId(), d.C0277d.cp_cont_b, d.C0277d.cp_cont_d);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ajU() {
        if (this.fHg != null && this.bTn != null) {
            n.tz(this.bTn.getId());
            blx();
            PbActivityConfig createCfgForPersonCenter = new PbActivityConfig(this.mPageContext.getPageActivity()).createCfgForPersonCenter(this.bTn.getId(), this.bTn.Ze(), n.YB(), 18005);
            createCfgForPersonCenter.setStartFrom(this.currentPageType);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createCfgForPersonCenter));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void mE(int i) {
        if (this.bTn != null) {
            if (i == 1) {
                this.dqy.setVisibility(8);
                this.drn.setData(this.bTn);
                this.dqx.dN(false);
                return;
            }
            this.dqy.setData(this.bTn);
            this.drn.setVisibility(8);
            this.dqx.dN(true);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.YA = str;
    }

    public int ls(int i) {
        return com.baidu.tieba.a.d.awh().ak(this.YA, i);
    }
}
