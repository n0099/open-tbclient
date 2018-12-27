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
    private final View.OnClickListener aKC;
    private View bGu;
    protected bb bNy;
    private com.baidu.tbadk.core.view.userLike.c cXd;
    public ThreadUserInfoLayout caL;
    public ThreadCommentAndPraiseInfoLayout caM;
    private String caz;
    protected LinearLayout cbK;
    public ThreadSourceShareAndPraiseLayout cbz;
    private TextView eul;
    public ConcernUserLikeButton eum;
    private View eun;
    public LinearLayout euo;
    protected com.baidu.tieba.homepage.concern.b.b eup;
    protected boolean euq;
    private View.OnClickListener eur;
    protected View.OnClickListener eus;
    private final View.OnClickListener eut;
    protected TbPageContext<?> mPageContext;
    private int mSkinType;
    protected TextView mTitle;

    protected abstract void aA(View view);

    protected abstract void ag(bb bbVar);

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.euq = true;
        this.eur = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.apS() != null) {
                    d.this.apS().a(view, d.this.eup);
                }
                if (d.this.eup != null && !StringUtils.isNull(d.this.eup.etW.getName()) && !StringUtils.isNull(d.this.eup.etW.getUserId())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(d.this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.g.b.d(d.this.eup.etW.getUserId(), 0L), false, d.this.eup.etW.isGod())));
                }
            }
        };
        this.eus = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.d.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.apS() != null) {
                    d.this.apS().a(view, d.this.eup);
                }
                d.this.aqm();
            }
        };
        this.aKC = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.d.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.apS() != null) {
                    d.this.apS().a(view, d.this.eup);
                }
            }
        };
        this.eut = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.d.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == e.g.thread_info_commont_container && d.this.bNy != null) {
                    o.mG(d.this.bNy.getId());
                    d.this.apX();
                }
            }
        };
        View view = getView();
        this.currentPageType = 1;
        this.mPageContext = tbPageContext;
        this.eul = (TextView) view.findViewById(e.g.card_recommend_god_reason);
        this.eum = (ConcernUserLikeButton) view.findViewById(e.g.card_recommend_god_user_like_btn);
        this.caL = (ThreadUserInfoLayout) view.findViewById(e.g.card_rec_god_user_info);
        this.cXd = new com.baidu.tbadk.core.view.userLike.c(tbPageContext, this.eum);
        this.caL.setTShowVisible(false);
        this.caL.getHeaderImg().setAfterClickListener(this.aKC);
        this.eum.setAfterOnClickListener(this.aKC);
        this.bGu = view.findViewById(e.g.card_recommend_god_divide_line);
        this.eun = view.findViewById(e.g.divider_line);
        this.euo = (LinearLayout) view.findViewById(e.g.card_recommend_god_content);
        this.euo.setOnClickListener(this.eur);
        this.mTitle = (TextView) view.findViewById(e.g.card_recommend_god_therad_title);
        this.caM = (ThreadCommentAndPraiseInfoLayout) view.findViewById(e.g.card_recommend_god_therad_info_layout);
        this.caM.setOnClickListener(this.eus);
        this.caM.setReplyTimeVisible(false);
        this.caM.setIsBarViewVisible(false);
        this.caM.setShowPraiseNum(true);
        this.caM.setNeedAddPraiseIcon(true);
        this.caM.setNeedAddReplyIcon(true);
        this.caM.setShareVisible(true);
        this.caM.avM = this.currentPageType;
        this.caM.setForumAfterClickListener(this.eut);
        this.caM.setShareReportFrom(4);
        this.caM.setFrom(9);
        this.caM.setDisPraiseFrom(4);
        this.cbz = (ThreadSourceShareAndPraiseLayout) view.findViewById(e.g.card_concern_god_source_read_share_layout);
        this.cbz.aKk.setOnClickListener(this.eus);
        this.cbz.aKk.avM = this.currentPageType;
        this.cbz.aKk.setForumAfterClickListener(this.eut);
        this.cbz.setShareReportFrom(4);
        this.cbz.setFrom(9);
        this.cbK = (LinearLayout) view.findViewById(e.g.card_recommend_god_therad_content_layout);
        aA(view);
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
            this.cXd.h(bdUniqueId);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.i(getView(), e.f.addresslist_item_bg);
            al.h(this.eul, e.d.cp_cont_d);
            al.j(this.bGu, e.d.cp_bg_line_e);
            al.j(this.eun, e.d.cp_bg_line_e);
            this.eum.onChangeSkinType(i);
            this.caM.onChangeSkinType();
            this.cbz.onChangeSkinType();
        }
        this.mSkinType = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.homepage.concern.b.b bVar) {
        if (bVar != null && bVar.etW != null && !StringUtils.isNull(bVar.etW.getName()) && !StringUtils.isNull(bVar.etW.getUserId()) && !StringUtils.isNull(bVar.dzM.getTid())) {
            this.eup = bVar;
            if (this.caL != null) {
                this.caL.setData(bVar.dzM);
                if (this.caL.getHeaderImg() != null) {
                    this.caL.getHeaderImg().setData(bVar.metaData);
                }
                this.caL.onChangeSkinType();
            }
            this.cXd.a(this.eup.metaData);
            String aKZ = this.eup.etW.aKZ();
            if (StringUtils.isNull(aKZ)) {
                this.eul.setVisibility(8);
            } else {
                this.eul.setVisibility(0);
                this.eul.setText(aKZ);
            }
            this.bNy = bVar.dzM;
            if (o.mH(this.bNy.getId())) {
                apX();
            }
            this.caM.setData(this.bNy);
            o.b(this.bNy, this.mTitle);
            this.euq = true;
            if ((StringUtils.isNull(this.bNy.getTitle()) && (this.bNy.zE() == null || this.bNy.zE().size() == 0)) || this.bNy.zW() == 1) {
                this.bNy.g(false, true);
                if (this.bNy.Ag() == null || StringUtils.isNull(this.bNy.Ag().toString())) {
                    this.euq = false;
                }
            }
            ag(this.bNy);
            iM(hD(1));
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.eum != null) {
            this.eum.setTag(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void apX() {
        o.a(this.mTitle, this.bNy.getId(), e.d.cp_cont_b, e.d.cp_cont_d);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aqm() {
        if (this.eup != null && this.bNy != null) {
            o.mG(this.bNy.getId());
            apX();
            PbActivityConfig createCfgForPersonCenter = new PbActivityConfig(this.mPageContext.getPageActivity()).createCfgForPersonCenter(this.bNy.getId(), this.bNy.zX(), o.zu(), 18005);
            createCfgForPersonCenter.setStartFrom(this.currentPageType);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createCfgForPersonCenter));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void iM(int i) {
        if (this.bNy != null) {
            if (i == 1) {
                this.caM.setVisibility(8);
                this.cbz.setData(this.bNy);
                this.caL.showForumNameView(false);
                return;
            }
            this.caM.setData(this.bNy);
            this.cbz.setVisibility(8);
            this.caL.showForumNameView(true);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.caz = str;
    }

    public int hD(int i) {
        return com.baidu.tieba.a.d.VO().N(this.caz, i);
    }
}
