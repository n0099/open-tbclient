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
    private String YB;
    private final View.OnClickListener ZI;
    private View bFt;
    protected bg bTo;
    private View cSE;
    public ThreadUserInfoLayout dqy;
    public ThreadCommentAndPraiseInfoLayout dqz;
    public ThreadSourceShareAndPraiseLayout dro;
    protected LinearLayout drz;
    private com.baidu.tbadk.core.view.userLike.c ehk;
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
        this.ZI = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.d.3
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
                if (view.getId() == d.g.thread_info_commont_container && d.this.bTo != null) {
                    n.tz(d.this.bTo.getId());
                    d.this.blx();
                }
            }
        };
        View view = getView();
        this.currentPageType = 1;
        this.mPageContext = tbPageContext;
        this.fHd = (TextView) view.findViewById(d.g.card_recommend_god_reason);
        this.fHe = (ConcernUserLikeButton) view.findViewById(d.g.card_recommend_god_user_like_btn);
        this.dqy = (ThreadUserInfoLayout) view.findViewById(d.g.card_rec_god_user_info);
        this.ehk = new com.baidu.tbadk.core.view.userLike.c(tbPageContext, this.fHe);
        this.dqy.setTShowVisible(false);
        this.dqy.getHeaderImg().setAfterClickListener(this.ZI);
        this.fHe.setAfterOnClickListener(this.ZI);
        this.cSE = view.findViewById(d.g.card_recommend_god_divide_line);
        this.bFt = view.findViewById(d.g.divider_line);
        this.fHf = (LinearLayout) view.findViewById(d.g.card_recommend_god_content);
        this.fHf.setOnClickListener(this.fHi);
        this.mTitle = (TextView) view.findViewById(d.g.card_recommend_god_therad_title);
        this.dqz = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.card_recommend_god_therad_info_layout);
        this.dqz.setOnClickListener(this.fHj);
        this.dqz.setReplyTimeVisible(false);
        this.dqz.setIsBarViewVisible(false);
        this.dqz.setShowPraiseNum(true);
        this.dqz.setNeedAddPraiseIcon(true);
        this.dqz.setNeedAddReplyIcon(true);
        this.dqz.setShareVisible(true);
        this.dqz.bSK = this.currentPageType;
        this.dqz.setForumAfterClickListener(this.fHk);
        this.dqz.setShareReportFrom(4);
        this.dqz.setFrom(9);
        this.dqz.setDisPraiseFrom(4);
        this.dro = (ThreadSourceShareAndPraiseLayout) view.findViewById(d.g.card_concern_god_source_read_share_layout);
        this.dro.bTC.setOnClickListener(this.fHj);
        this.dro.bTC.bSK = this.currentPageType;
        this.dro.bTC.setForumAfterClickListener(this.fHk);
        this.dro.setShareReportFrom(4);
        this.dro.setFrom(9);
        this.drz = (LinearLayout) view.findViewById(d.g.card_recommend_god_therad_content_layout);
        bQ(view);
    }

    public void k(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
            this.ehk.i(bdUniqueId);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.k(getView(), d.f.addresslist_item_bg);
            al.j(this.fHd, d.C0277d.cp_cont_d);
            al.l(this.cSE, d.C0277d.cp_bg_line_e);
            al.l(this.bFt, d.C0277d.cp_bg_line_e);
            this.fHe.onChangeSkinType(i);
            this.dqz.onChangeSkinType();
            this.dro.onChangeSkinType();
        }
        this.mSkinType = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.homepage.concern.b.b bVar) {
        if (bVar != null && bVar.fGO != null && !StringUtils.isNull(bVar.fGO.getName()) && !StringUtils.isNull(bVar.fGO.getUserId()) && !StringUtils.isNull(bVar.eNz.getTid())) {
            this.fHg = bVar;
            if (this.dqy != null) {
                this.dqy.setData(bVar.eNz);
                if (this.dqy.getHeaderImg() != null) {
                    this.dqy.getHeaderImg().setData(bVar.metaData);
                }
                this.dqy.onChangeSkinType();
            }
            this.ehk.a(this.fHg.metaData);
            String blw = this.fHg.fGO.blw();
            if (StringUtils.isNull(blw)) {
                this.fHd.setVisibility(8);
            } else {
                this.fHd.setVisibility(0);
                this.fHd.setText(blw);
            }
            this.bTo = bVar.eNz;
            if (n.tA(this.bTo.getId())) {
                blx();
            }
            this.dqz.setData(this.bTo);
            n.b(this.bTo, this.mTitle);
            this.fHh = true;
            if ((StringUtils.isNull(this.bTo.getTitle()) && (this.bTo.YM() == null || this.bTo.YM().size() == 0)) || this.bTo.Zd() == 1) {
                this.bTo.k(false, true);
                if (this.bTo.Zu() == null || StringUtils.isNull(this.bTo.Zu().toString())) {
                    this.fHh = false;
                }
            }
            an(this.bTo);
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
        n.a(this.mTitle, this.bTo.getId(), d.C0277d.cp_cont_b, d.C0277d.cp_cont_d);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ajU() {
        if (this.fHg != null && this.bTo != null) {
            n.tz(this.bTo.getId());
            blx();
            PbActivityConfig createCfgForPersonCenter = new PbActivityConfig(this.mPageContext.getPageActivity()).createCfgForPersonCenter(this.bTo.getId(), this.bTo.Ze(), n.YB(), 18005);
            createCfgForPersonCenter.setStartFrom(this.currentPageType);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createCfgForPersonCenter));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void mE(int i) {
        if (this.bTo != null) {
            if (i == 1) {
                this.dqz.setVisibility(8);
                this.dro.setData(this.bTo);
                this.dqy.dN(false);
                return;
            }
            this.dqz.setData(this.bTo);
            this.dro.setVisibility(8);
            this.dqy.dN(true);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.YB = str;
    }

    public int ls(int i) {
        return com.baidu.tieba.a.d.awh().ak(this.YB, i);
    }
}
