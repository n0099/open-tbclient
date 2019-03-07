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
    private String Yz;
    private final View.OnClickListener ZF;
    private View bFo;
    protected bg bTk;
    private View cSF;
    public ThreadUserInfoLayout dqy;
    public ThreadCommentAndPraiseInfoLayout dqz;
    public ThreadSourceShareAndPraiseLayout dro;
    protected LinearLayout drz;
    private com.baidu.tbadk.core.view.userLike.c ehB;
    private TextView fHq;
    public ConcernUserLikeButton fHr;
    public LinearLayout fHs;
    protected com.baidu.tieba.homepage.concern.b.b fHt;
    protected boolean fHu;
    private View.OnClickListener fHv;
    protected View.OnClickListener fHw;
    private final View.OnClickListener fHx;
    protected TbPageContext<?> mPageContext;
    private int mSkinType;
    protected TextView mTitle;

    protected abstract void ao(bg bgVar);

    protected abstract void bQ(View view);

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.fHu = true;
        this.fHv = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.aQh() != null) {
                    d.this.aQh().a(view, d.this.fHt);
                }
                if (d.this.fHt != null && !StringUtils.isNull(d.this.fHt.fHb.getName()) && !StringUtils.isNull(d.this.fHt.fHb.getUserId())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(d.this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.g.b.d(d.this.fHt.fHb.getUserId(), 0L), false, d.this.fHt.fHb.isGod())));
                }
            }
        };
        this.fHw = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.d.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.aQh() != null) {
                    d.this.aQh().a(view, d.this.fHt);
                }
                d.this.ajY();
            }
        };
        this.ZF = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.d.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.aQh() != null) {
                    d.this.aQh().a(view, d.this.fHt);
                }
            }
        };
        this.fHx = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.d.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == d.g.thread_info_commont_container && d.this.bTk != null) {
                    n.tB(d.this.bTk.getId());
                    d.this.blA();
                }
            }
        };
        View view = getView();
        this.currentPageType = 1;
        this.mPageContext = tbPageContext;
        this.fHq = (TextView) view.findViewById(d.g.card_recommend_god_reason);
        this.fHr = (ConcernUserLikeButton) view.findViewById(d.g.card_recommend_god_user_like_btn);
        this.dqy = (ThreadUserInfoLayout) view.findViewById(d.g.card_rec_god_user_info);
        this.ehB = new com.baidu.tbadk.core.view.userLike.c(tbPageContext, this.fHr);
        this.dqy.setTShowVisible(false);
        this.dqy.getHeaderImg().setAfterClickListener(this.ZF);
        this.fHr.setAfterOnClickListener(this.ZF);
        this.cSF = view.findViewById(d.g.card_recommend_god_divide_line);
        this.bFo = view.findViewById(d.g.divider_line);
        this.fHs = (LinearLayout) view.findViewById(d.g.card_recommend_god_content);
        this.fHs.setOnClickListener(this.fHv);
        this.mTitle = (TextView) view.findViewById(d.g.card_recommend_god_therad_title);
        this.dqz = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.card_recommend_god_therad_info_layout);
        this.dqz.setOnClickListener(this.fHw);
        this.dqz.setReplyTimeVisible(false);
        this.dqz.setIsBarViewVisible(false);
        this.dqz.setShowPraiseNum(true);
        this.dqz.setNeedAddPraiseIcon(true);
        this.dqz.setNeedAddReplyIcon(true);
        this.dqz.setShareVisible(true);
        this.dqz.bSG = this.currentPageType;
        this.dqz.setForumAfterClickListener(this.fHx);
        this.dqz.setShareReportFrom(4);
        this.dqz.setFrom(9);
        this.dqz.setDisPraiseFrom(4);
        this.dro = (ThreadSourceShareAndPraiseLayout) view.findViewById(d.g.card_concern_god_source_read_share_layout);
        this.dro.bTy.setOnClickListener(this.fHw);
        this.dro.bTy.bSG = this.currentPageType;
        this.dro.bTy.setForumAfterClickListener(this.fHx);
        this.dro.setShareReportFrom(4);
        this.dro.setFrom(9);
        this.drz = (LinearLayout) view.findViewById(d.g.card_recommend_god_therad_content_layout);
        bQ(view);
    }

    public void k(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
            this.ehB.i(bdUniqueId);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.k(getView(), d.f.addresslist_item_bg);
            al.j(this.fHq, d.C0236d.cp_cont_d);
            al.l(this.cSF, d.C0236d.cp_bg_line_e);
            al.l(this.bFo, d.C0236d.cp_bg_line_e);
            this.fHr.onChangeSkinType(i);
            this.dqz.onChangeSkinType();
            this.dro.onChangeSkinType();
        }
        this.mSkinType = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.homepage.concern.b.b bVar) {
        if (bVar != null && bVar.fHb != null && !StringUtils.isNull(bVar.fHb.getName()) && !StringUtils.isNull(bVar.fHb.getUserId()) && !StringUtils.isNull(bVar.eNQ.getTid())) {
            this.fHt = bVar;
            if (this.dqy != null) {
                this.dqy.setData(bVar.eNQ);
                if (this.dqy.getHeaderImg() != null) {
                    this.dqy.getHeaderImg().setData(bVar.metaData);
                }
                this.dqy.onChangeSkinType();
            }
            this.ehB.a(this.fHt.metaData);
            String blz = this.fHt.fHb.blz();
            if (StringUtils.isNull(blz)) {
                this.fHq.setVisibility(8);
            } else {
                this.fHq.setVisibility(0);
                this.fHq.setText(blz);
            }
            this.bTk = bVar.eNQ;
            if (n.tC(this.bTk.getId())) {
                blA();
            }
            this.dqz.setData(this.bTk);
            n.b(this.bTk, this.mTitle);
            this.fHu = true;
            if ((StringUtils.isNull(this.bTk.getTitle()) && (this.bTk.YP() == null || this.bTk.YP().size() == 0)) || this.bTk.Zg() == 1) {
                this.bTk.k(false, true);
                if (this.bTk.Zx() == null || StringUtils.isNull(this.bTk.Zx().toString())) {
                    this.fHu = false;
                }
            }
            ao(this.bTk);
            mF(lt(1));
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.fHr != null) {
            this.fHr.setTag(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void blA() {
        n.a(this.mTitle, this.bTk.getId(), d.C0236d.cp_cont_b, d.C0236d.cp_cont_d);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ajY() {
        if (this.fHt != null && this.bTk != null) {
            n.tB(this.bTk.getId());
            blA();
            PbActivityConfig createCfgForPersonCenter = new PbActivityConfig(this.mPageContext.getPageActivity()).createCfgForPersonCenter(this.bTk.getId(), this.bTk.Zh(), n.YE(), 18005);
            createCfgForPersonCenter.setStartFrom(this.currentPageType);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createCfgForPersonCenter));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void mF(int i) {
        if (this.bTk != null) {
            if (i == 1) {
                this.dqz.setVisibility(8);
                this.dro.setData(this.bTk);
                this.dqy.dN(false);
                return;
            }
            this.dqz.setData(this.bTk);
            this.dro.setVisibility(8);
            this.dqy.dN(true);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.Yz = str;
    }

    public int lt(int i) {
        return com.baidu.tieba.a.d.awk().ak(this.Yz, i);
    }
}
