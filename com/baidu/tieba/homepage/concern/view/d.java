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
    private final View.OnClickListener aHa;
    private View bCY;
    protected bb bJG;
    private String bWE;
    public ThreadUserInfoLayout bWQ;
    public ThreadCommentAndPraiseInfoLayout bWR;
    public ThreadSourceShareAndPraiseLayout bXE;
    protected LinearLayout bXP;
    private com.baidu.tbadk.core.view.userLike.c cNG;
    public ConcernUserLikeButton ekA;
    private View ekB;
    public LinearLayout ekC;
    protected com.baidu.tieba.homepage.concern.b.b ekD;
    protected boolean ekE;
    private View.OnClickListener ekF;
    protected View.OnClickListener ekG;
    private final View.OnClickListener ekH;
    private TextView ekz;
    protected TbPageContext<?> mPageContext;
    private int mSkinType;
    protected TextView mTitle;

    protected abstract void ag(bb bbVar);

    protected abstract void ax(View view);

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.ekE = true;
        this.ekF = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.anq() != null) {
                    d.this.anq().a(view, d.this.ekD);
                }
                if (d.this.ekD != null && !StringUtils.isNull(d.this.ekD.ekk.getName()) && !StringUtils.isNull(d.this.ekD.ekk.getUserId())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(d.this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.g.b.d(d.this.ekD.ekk.getUserId(), 0L), false, d.this.ekD.ekk.isGod())));
                }
            }
        };
        this.ekG = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.d.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.anq() != null) {
                    d.this.anq().a(view, d.this.ekD);
                }
                d.this.anK();
            }
        };
        this.aHa = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.d.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.anq() != null) {
                    d.this.anq().a(view, d.this.ekD);
                }
            }
        };
        this.ekH = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.d.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == e.g.thread_info_commont_container && d.this.bJG != null) {
                    o.me(d.this.bJG.getId());
                    d.this.anv();
                }
            }
        };
        View view = getView();
        this.currentPageType = 1;
        this.mPageContext = tbPageContext;
        this.ekz = (TextView) view.findViewById(e.g.card_recommend_god_reason);
        this.ekA = (ConcernUserLikeButton) view.findViewById(e.g.card_recommend_god_user_like_btn);
        this.bWQ = (ThreadUserInfoLayout) view.findViewById(e.g.card_rec_god_user_info);
        this.cNG = new com.baidu.tbadk.core.view.userLike.c(tbPageContext, this.ekA);
        this.bWQ.setTShowVisible(false);
        this.bWQ.getHeaderImg().setAfterClickListener(this.aHa);
        this.ekA.setAfterOnClickListener(this.aHa);
        this.bCY = view.findViewById(e.g.card_recommend_god_divide_line);
        this.ekB = view.findViewById(e.g.divider_line);
        this.ekC = (LinearLayout) view.findViewById(e.g.card_recommend_god_content);
        this.ekC.setOnClickListener(this.ekF);
        this.mTitle = (TextView) view.findViewById(e.g.card_recommend_god_therad_title);
        this.bWR = (ThreadCommentAndPraiseInfoLayout) view.findViewById(e.g.card_recommend_god_therad_info_layout);
        this.bWR.setOnClickListener(this.ekG);
        this.bWR.setReplyTimeVisible(false);
        this.bWR.setIsBarViewVisible(false);
        this.bWR.setShowPraiseNum(true);
        this.bWR.setNeedAddPraiseIcon(true);
        this.bWR.setNeedAddReplyIcon(true);
        this.bWR.setShareVisible(true);
        this.bWR.asl = this.currentPageType;
        this.bWR.setForumAfterClickListener(this.ekH);
        this.bWR.setShareReportFrom(4);
        this.bWR.setFrom(9);
        this.bWR.setDisPraiseFrom(4);
        this.bXE = (ThreadSourceShareAndPraiseLayout) view.findViewById(e.g.card_concern_god_source_read_share_layout);
        this.bXE.aGI.setOnClickListener(this.ekG);
        this.bXE.aGI.asl = this.currentPageType;
        this.bXE.aGI.setForumAfterClickListener(this.ekH);
        this.bXE.setShareReportFrom(4);
        this.bXE.setFrom(9);
        this.bXP = (LinearLayout) view.findViewById(e.g.card_recommend_god_therad_content_layout);
        ax(view);
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
            this.cNG.h(bdUniqueId);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.i(getView(), e.f.addresslist_item_bg);
            al.h(this.ekz, e.d.cp_cont_d);
            al.j(this.bCY, e.d.cp_bg_line_e);
            al.j(this.ekB, e.d.cp_bg_line_e);
            this.ekA.onChangeSkinType(i);
            this.bWR.onChangeSkinType();
            this.bXE.onChangeSkinType();
        }
        this.mSkinType = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.homepage.concern.b.b bVar) {
        if (bVar != null && bVar.ekk != null && !StringUtils.isNull(bVar.ekk.getName()) && !StringUtils.isNull(bVar.ekk.getUserId()) && !StringUtils.isNull(bVar.dqz.getTid())) {
            this.ekD = bVar;
            if (this.bWQ != null) {
                this.bWQ.setData(bVar.dqz);
                if (this.bWQ.getHeaderImg() != null) {
                    this.bWQ.getHeaderImg().setData(bVar.metaData);
                }
                this.bWQ.onChangeSkinType();
            }
            this.cNG.a(this.ekD.metaData);
            String aIt = this.ekD.ekk.aIt();
            if (StringUtils.isNull(aIt)) {
                this.ekz.setVisibility(8);
            } else {
                this.ekz.setVisibility(0);
                this.ekz.setText(aIt);
            }
            this.bJG = bVar.dqz;
            if (o.mf(this.bJG.getId())) {
                anv();
            }
            this.bWR.setData(this.bJG);
            o.b(this.bJG, this.mTitle);
            this.ekE = true;
            if ((StringUtils.isNull(this.bJG.getTitle()) && (this.bJG.yA() == null || this.bJG.yA().size() == 0)) || this.bJG.yS() == 1) {
                this.bJG.g(false, true);
                if (this.bJG.zc() == null || StringUtils.isNull(this.bJG.zc().toString())) {
                    this.ekE = false;
                }
            }
            ag(this.bJG);
            ix(ho(1));
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.ekA != null) {
            this.ekA.setTag(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void anv() {
        o.a(this.mTitle, this.bJG.getId(), e.d.cp_cont_b, e.d.cp_cont_d);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void anK() {
        if (this.ekD != null && this.bJG != null) {
            o.me(this.bJG.getId());
            anv();
            PbActivityConfig createCfgForPersonCenter = new PbActivityConfig(this.mPageContext.getPageActivity()).createCfgForPersonCenter(this.bJG.getId(), this.bJG.yT(), o.yq(), 18005);
            createCfgForPersonCenter.setStartFrom(this.currentPageType);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createCfgForPersonCenter));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void ix(int i) {
        if (this.bJG != null) {
            if (i == 1) {
                this.bWR.setVisibility(8);
                this.bXE.setData(this.bJG);
                this.bWQ.showForumNameView(false);
                return;
            }
            this.bWR.setData(this.bJG);
            this.bXE.setVisibility(8);
            this.bWQ.showForumNameView(true);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.bWE = str;
    }

    public int ho(int i) {
        return com.baidu.tieba.a.d.UG().M(this.bWE, i);
    }
}
