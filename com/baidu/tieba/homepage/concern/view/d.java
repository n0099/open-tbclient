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
import com.baidu.tbadk.core.data.bc;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadSourceShareAndPraiseLayout;
import com.baidu.tbadk.core.view.ThreadUserInfoLayout;
import com.baidu.tieba.card.o;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public abstract class d extends com.baidu.tieba.card.a<com.baidu.tieba.homepage.concern.b.b> implements com.baidu.tieba.a.e {
    private final View.OnClickListener ayi;
    private String bGM;
    public ThreadUserInfoLayout bGY;
    public ThreadCommentAndPraiseInfoLayout bGZ;
    public ThreadSourceShareAndPraiseLayout bHN;
    protected LinearLayout bHY;
    protected bc btP;
    private com.baidu.tbadk.core.view.userLike.c cvR;
    private View dHN;
    private TextView dRk;
    public ConcernUserLikeButton dRl;
    private View dRm;
    public LinearLayout dRn;
    protected com.baidu.tieba.homepage.concern.b.b dRo;
    protected boolean dRp;
    private View.OnClickListener dRq;
    protected View.OnClickListener dRr;
    private final View.OnClickListener dRs;
    protected TbPageContext<?> mPageContext;
    private int mSkinType;
    protected TextView mTitle;

    protected abstract void ad(bc bcVar);

    protected abstract void ae(View view);

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.dRp = true;
        this.dRq = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.aia() != null) {
                    d.this.aia().a(view, d.this.dRo);
                }
                if (d.this.dRo != null && !StringUtils.isNull(d.this.dRo.dQV.getName()) && !StringUtils.isNull(d.this.dRo.dQV.getUserId())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(d.this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.g.b.c(d.this.dRo.dQV.getUserId(), 0L), false, d.this.dRo.dQV.isGod())));
                }
            }
        };
        this.dRr = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.d.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.aia() != null) {
                    d.this.aia().a(view, d.this.dRo);
                }
                d.this.ait();
            }
        };
        this.ayi = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.d.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.aia() != null) {
                    d.this.aia().a(view, d.this.dRo);
                }
            }
        };
        this.dRs = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.d.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == d.g.thread_info_commont_container && d.this.btP != null) {
                    o.kY(d.this.btP.getId());
                    d.this.aif();
                }
            }
        };
        View view = getView();
        this.currentPageType = 1;
        this.mPageContext = tbPageContext;
        this.dRk = (TextView) view.findViewById(d.g.card_recommend_god_reason);
        this.dRl = (ConcernUserLikeButton) view.findViewById(d.g.card_recommend_god_user_like_btn);
        this.bGY = (ThreadUserInfoLayout) view.findViewById(d.g.card_rec_god_user_info);
        this.cvR = new com.baidu.tbadk.core.view.userLike.c(tbPageContext, this.dRl);
        this.bGY.setTShowVisible(false);
        this.bGY.getHeaderImg().setAfterClickListener(this.ayi);
        this.dRl.setAfterOnClickListener(this.ayi);
        this.dHN = view.findViewById(d.g.card_recommend_god_divide_line);
        this.dRm = view.findViewById(d.g.divider_line);
        this.dRn = (LinearLayout) view.findViewById(d.g.card_recommend_god_content);
        this.dRn.setOnClickListener(this.dRq);
        this.mTitle = (TextView) view.findViewById(d.g.card_recommend_god_therad_title);
        this.bGZ = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.card_recommend_god_therad_info_layout);
        this.bGZ.setOnClickListener(this.dRr);
        this.bGZ.setReplyTimeVisible(false);
        this.bGZ.setIsBarViewVisible(false);
        this.bGZ.setShowPraiseNum(true);
        this.bGZ.setNeedAddPraiseIcon(true);
        this.bGZ.setNeedAddReplyIcon(true);
        this.bGZ.setShareVisible(true);
        this.bGZ.akz = this.currentPageType;
        this.bGZ.setForumAfterClickListener(this.dRs);
        this.bGZ.setShareReportFrom(4);
        this.bGZ.setFrom(9);
        this.bHN = (ThreadSourceShareAndPraiseLayout) view.findViewById(d.g.card_concern_god_source_read_share_layout);
        this.bHN.ayE.setOnClickListener(this.dRr);
        this.bHN.ayE.akz = this.currentPageType;
        this.bHN.ayE.setForumAfterClickListener(this.dRs);
        this.bHN.setShareReportFrom(4);
        this.bHN.setFrom(9);
        this.bHY = (LinearLayout) view.findViewById(d.g.card_recommend_god_therad_content_layout);
        ae(view);
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
            this.cvR.h(bdUniqueId);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.i(getView(), d.f.addresslist_item_bg);
            am.h(this.dRk, d.C0142d.cp_cont_d);
            am.j(this.dHN, d.C0142d.cp_bg_line_e);
            am.j(this.dRm, d.C0142d.cp_bg_line_e);
            this.dRl.onChangeSkinType(i);
            this.bGZ.onChangeSkinType();
            this.bHN.onChangeSkinType();
        }
        this.mSkinType = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.homepage.concern.b.b bVar) {
        if (bVar != null && bVar.dQV != null && !StringUtils.isNull(bVar.dQV.getName()) && !StringUtils.isNull(bVar.dQV.getUserId()) && !StringUtils.isNull(bVar.cYJ.getTid())) {
            this.dRo = bVar;
            if (this.bGY != null) {
                this.bGY.setData(bVar.cYJ);
                if (this.bGY.getHeaderImg() != null) {
                    this.bGY.getHeaderImg().setData(bVar.metaData);
                }
                this.bGY.onChangeSkinType();
            }
            this.cvR.a(this.dRo.metaData);
            String aCL = this.dRo.dQV.aCL();
            if (StringUtils.isNull(aCL)) {
                this.dRk.setVisibility(8);
            } else {
                this.dRk.setVisibility(0);
                this.dRk.setText(aCL);
            }
            this.btP = bVar.cYJ;
            if (o.kZ(this.btP.getId())) {
                aif();
            }
            this.bGZ.setData(this.btP);
            o.b(this.btP, this.mTitle);
            this.dRp = true;
            if ((StringUtils.isNull(this.btP.getTitle()) && (this.btP.vu() == null || this.btP.vu().size() == 0)) || this.btP.vL() == 1) {
                this.btP.e(false, true);
                if (this.btP.vU() == null || StringUtils.isNull(this.btP.vU().toString())) {
                    this.dRp = false;
                }
            }
            ad(this.btP);
            hh(gp(1));
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.dRl != null) {
            this.dRl.setTag(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aif() {
        o.a(this.mTitle, this.btP.getId(), d.C0142d.cp_cont_b, d.C0142d.cp_cont_d);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ait() {
        if (this.dRo != null && this.btP != null) {
            o.kY(this.btP.getId());
            aif();
            PbActivityConfig createCfgForPersonCenter = new PbActivityConfig(this.mPageContext.getPageActivity()).createCfgForPersonCenter(this.btP.getId(), this.btP.vM(), o.vk(), 18005);
            createCfgForPersonCenter.setStartFrom(this.currentPageType);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createCfgForPersonCenter));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void hh(int i) {
        if (this.btP != null) {
            if (i == 1) {
                this.bGZ.setVisibility(8);
                this.bHN.setData(this.btP);
                this.bGY.showForumNameView(false);
                return;
            }
            this.bGZ.setData(this.btP);
            this.bHN.setVisibility(8);
            this.bGY.showForumNameView(true);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.bGM = str;
    }

    public int gp(int i) {
        return com.baidu.tieba.a.d.QB().L(this.bGM, i);
    }
}
