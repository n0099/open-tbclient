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
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadSourceShareAndPraiseLayout;
import com.baidu.tbadk.core.view.ThreadUserInfoLayout;
import com.baidu.tieba.card.o;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public abstract class d extends com.baidu.tieba.card.a<com.baidu.tieba.homepage.concern.b.b> implements com.baidu.tieba.a.e {
    private final View.OnClickListener apj;
    protected bd bkk;
    private String bwO;
    public ThreadSourceShareAndPraiseLayout bxQ;
    public ThreadUserInfoLayout bxa;
    public ThreadCommentAndPraiseInfoLayout bxb;
    protected LinearLayout byb;
    private com.baidu.tbadk.core.view.userLike.c cpg;
    private TextView dCL;
    public ConcernUserLikeButton dCM;
    private View dCN;
    public LinearLayout dCO;
    protected com.baidu.tieba.homepage.concern.b.b dCP;
    protected boolean dCQ;
    private View.OnClickListener dCR;
    protected View.OnClickListener dCS;
    private final View.OnClickListener dCT;
    private View dvf;
    protected TbPageContext<?> mPageContext;
    private int mSkinType;
    protected TextView mTitle;

    protected abstract void Y(bd bdVar);

    protected abstract void ac(View view2);

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.dCQ = true;
        this.dCR = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (d.this.aeZ() != null) {
                    d.this.aeZ().a(view2, d.this.dCP);
                }
                if (d.this.dCP != null && !StringUtils.isNull(d.this.dCP.dCx.getName()) && !StringUtils.isNull(d.this.dCP.dCx.getUserId())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(d.this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.g.b.c(d.this.dCP.dCx.getUserId(), 0L), false, d.this.dCP.dCx.isGod())));
                }
            }
        };
        this.dCS = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.d.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (d.this.aeZ() != null) {
                    d.this.aeZ().a(view2, d.this.dCP);
                }
                d.this.afs();
            }
        };
        this.apj = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.d.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (d.this.aeZ() != null) {
                    d.this.aeZ().a(view2, d.this.dCP);
                }
            }
        };
        this.dCT = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.d.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (view2.getId() == d.g.thread_info_commont_container && d.this.bkk != null) {
                    o.ky(d.this.bkk.getId());
                    d.this.afe();
                }
            }
        };
        View view2 = getView();
        this.currentPageType = 1;
        this.mPageContext = tbPageContext;
        this.dCL = (TextView) view2.findViewById(d.g.card_recommend_god_reason);
        this.dCM = (ConcernUserLikeButton) view2.findViewById(d.g.card_recommend_god_user_like_btn);
        this.bxa = (ThreadUserInfoLayout) view2.findViewById(d.g.card_rec_god_user_info);
        this.cpg = new com.baidu.tbadk.core.view.userLike.c(tbPageContext, this.dCM);
        this.bxa.setTShowVisible(false);
        this.bxa.getHeaderImg().setAfterClickListener(this.apj);
        this.dCM.setAfterOnClickListener(this.apj);
        this.dvf = view2.findViewById(d.g.card_recommend_god_divide_line);
        this.dCN = view2.findViewById(d.g.divider_line);
        this.dCO = (LinearLayout) view2.findViewById(d.g.card_recommend_god_content);
        this.dCO.setOnClickListener(this.dCR);
        this.mTitle = (TextView) view2.findViewById(d.g.card_recommend_god_therad_title);
        this.bxb = (ThreadCommentAndPraiseInfoLayout) view2.findViewById(d.g.card_recommend_god_therad_info_layout);
        this.bxb.setOnClickListener(this.dCS);
        this.bxb.setReplyTimeVisible(false);
        this.bxb.setIsBarViewVisible(false);
        this.bxb.setShowPraiseNum(true);
        this.bxb.setNeedAddPraiseIcon(true);
        this.bxb.setNeedAddReplyIcon(true);
        this.bxb.setShareVisible(true);
        this.bxb.abW = this.currentPageType;
        this.bxb.setForumAfterClickListener(this.dCT);
        this.bxb.setShareReportFrom(4);
        this.bxb.setFrom(9);
        this.bxQ = (ThreadSourceShareAndPraiseLayout) view2.findViewById(d.g.card_concern_god_source_read_share_layout);
        this.bxQ.apG.setOnClickListener(this.dCS);
        this.bxQ.apG.abW = this.currentPageType;
        this.bxQ.apG.setForumAfterClickListener(this.dCT);
        this.bxQ.setShareReportFrom(4);
        this.bxQ.setFrom(9);
        this.byb = (LinearLayout) view2.findViewById(d.g.card_recommend_god_therad_content_layout);
        ac(view2);
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
            this.cpg.h(bdUniqueId);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ak.i(getView(), d.f.addresslist_item_bg);
            ak.h(this.dCL, d.C0126d.cp_cont_d);
            ak.j(this.dvf, d.C0126d.cp_bg_line_e);
            ak.j(this.dCN, d.C0126d.cp_bg_line_e);
            this.dCM.onChangeSkinType(i);
            this.bxb.onChangeSkinType();
            this.bxQ.onChangeSkinType();
        }
        this.mSkinType = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.homepage.concern.b.b bVar) {
        if (bVar != null && bVar.dCx != null && !StringUtils.isNull(bVar.dCx.getName()) && !StringUtils.isNull(bVar.dCx.getUserId()) && !StringUtils.isNull(bVar.cRB.getTid())) {
            this.dCP = bVar;
            if (this.bxa != null) {
                this.bxa.setData(bVar.cRB);
                if (this.bxa.getHeaderImg() != null) {
                    this.bxa.getHeaderImg().setData(bVar.metaData);
                }
                this.bxa.onChangeSkinType();
            }
            this.cpg.a(this.dCP.metaData);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dCO.getLayoutParams();
            String axo = this.dCP.dCx.axo();
            if (StringUtils.isNull(axo)) {
                this.dCL.setVisibility(8);
            } else {
                this.dCL.setVisibility(0);
                this.dCL.setText(axo);
            }
            this.bkk = bVar.cRB;
            if (o.kz(this.bkk.getId())) {
                afe();
            }
            this.bxb.setData(this.bkk);
            o.b(this.bkk, this.mTitle);
            this.dCQ = true;
            if ((StringUtils.isNull(this.bkk.getTitle()) && (this.bkk.rN() == null || this.bkk.rN().size() == 0)) || this.bkk.se() == 1) {
                this.bkk.e(false, true);
                if (this.bkk.sn() == null || StringUtils.isNull(this.bkk.sn().toString())) {
                    this.dCQ = false;
                }
            }
            Y(this.bkk);
            hc(gn(1));
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.dCM != null) {
            this.dCM.setTag(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void afe() {
        o.a(this.mTitle, this.bkk.getId(), d.C0126d.cp_cont_b, d.C0126d.cp_cont_d);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void afs() {
        if (this.dCP != null && this.bkk != null) {
            o.ky(this.bkk.getId());
            afe();
            PbActivityConfig createCfgForPersonCenter = new PbActivityConfig(this.mPageContext.getPageActivity()).createCfgForPersonCenter(this.bkk.getId(), this.bkk.sf(), o.rF(), 18005);
            createCfgForPersonCenter.setStartFrom(this.currentPageType);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createCfgForPersonCenter));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
    }

    public void hc(int i) {
        if (this.bkk != null) {
            if (i == 1) {
                this.bxb.setVisibility(8);
                this.bxQ.setData(this.bkk);
                this.bxa.showForumNameView(false);
                return;
            }
            this.bxb.setData(this.bkk);
            this.bxQ.setVisibility(8);
            this.bxa.showForumNameView(true);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.bwO = str;
    }

    public int gn(int i) {
        return com.baidu.tieba.a.d.MF().L(this.bwO, i);
    }
}
