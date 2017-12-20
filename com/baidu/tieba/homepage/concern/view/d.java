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
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadUserInfoLayout;
import com.baidu.tieba.card.k;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public abstract class d extends com.baidu.tieba.card.a<com.baidu.tieba.homepage.concern.b.b> {
    private final View.OnClickListener aod;
    private com.baidu.tbadk.core.view.userLike.c bZK;
    protected bd bkq;
    public ThreadUserInfoLayout bvE;
    public ThreadCommentAndPraiseInfoLayout bvI;
    protected LinearLayout bvL;
    private TextView doT;
    public ConcernUserLikeButton doU;
    private View doV;
    private View doW;
    public LinearLayout doX;
    protected com.baidu.tieba.homepage.concern.b.b doY;
    protected boolean doZ;
    private View.OnClickListener dpa;
    protected View.OnClickListener dpb;
    protected TbPageContext<?> mPageContext;
    private int mSkinType;
    protected TextView mTitle;

    protected abstract void W(bd bdVar);

    protected abstract void af(View view);

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.doZ = true;
        this.dpa = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.abt() != null) {
                    d.this.abt().a(view, d.this.doY);
                }
                if (d.this.doY != null && !StringUtils.isNull(d.this.doY.doG.getName()) && !StringUtils.isNull(d.this.doY.doG.getUserId())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(d.this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.g.b.c(d.this.doY.doG.getUserId(), 0L), false, d.this.doY.doG.isGod())));
                }
            }
        };
        this.dpb = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.d.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.abt() != null) {
                    d.this.abt().a(view, d.this.doY);
                }
                d.this.abM();
            }
        };
        this.aod = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.d.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.abt() != null) {
                    d.this.abt().a(view, d.this.doY);
                }
            }
        };
        View view = getView();
        this.currentPageType = 1;
        this.mPageContext = tbPageContext;
        this.doT = (TextView) view.findViewById(d.g.card_recommend_god_reason);
        this.doU = (ConcernUserLikeButton) view.findViewById(d.g.card_recommend_god_user_like_btn);
        this.bvE = (ThreadUserInfoLayout) view.findViewById(d.g.card_rec_god_user_info);
        this.bZK = new com.baidu.tbadk.core.view.userLike.c(tbPageContext, this.doU);
        this.bvE.setTShowVisible(false);
        this.bvE.getHeaderImg().setAfterClickListener(this.aod);
        this.doU.setAfterOnClickListener(this.aod);
        this.doV = view.findViewById(d.g.card_recommend_god_divide_line);
        this.doW = view.findViewById(d.g.divider_line);
        this.doX = (LinearLayout) view.findViewById(d.g.card_recommend_god_content);
        this.doX.setOnClickListener(this.dpa);
        this.mTitle = (TextView) view.findViewById(d.g.card_recommend_god_therad_title);
        this.bvI = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.card_recommend_god_therad_info_layout);
        this.bvI.setOnClickListener(this.dpb);
        this.bvI.setReplyTimeVisible(false);
        this.bvI.setIsBarViewVisible(false);
        this.bvI.setShowPraiseNum(true);
        this.bvI.setNeedAddPraiseIcon(true);
        this.bvI.setNeedAddReplyIcon(true);
        this.bvI.setShareVisible(true);
        this.bvI.anO = this.currentPageType;
        this.bvL = (LinearLayout) view.findViewById(d.g.card_recommend_god_therad_content_layout);
        af(view);
    }

    public void k(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
            this.bZK.h(bdUniqueId);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.j(getView(), d.f.addresslist_item_bg);
            aj.i(this.doT, d.C0096d.cp_cont_d);
            aj.k(this.doV, d.C0096d.cp_bg_line_e);
            aj.k(this.doW, d.C0096d.cp_bg_line_e);
            this.doU.onChangeSkinType(i);
            this.bvI.onChangeSkinType();
        }
        this.mSkinType = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.homepage.concern.b.b bVar) {
        if (bVar != null && bVar.doG != null && !StringUtils.isNull(bVar.doG.getName()) && !StringUtils.isNull(bVar.doG.getUserId()) && !StringUtils.isNull(bVar.cBz.getTid())) {
            this.doY = bVar;
            if (this.bvE != null) {
                this.bvE.setData(bVar.cBz);
                if (this.bvE.getHeaderImg() != null) {
                    this.bvE.getHeaderImg().setData(bVar.metaData);
                }
                this.bvE.onChangeSkinType();
            }
            this.bZK.a(this.doY.metaData);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.doX.getLayoutParams();
            String atN = this.doY.doG.atN();
            if (StringUtils.isNull(atN)) {
                this.doT.setVisibility(8);
            } else {
                this.doT.setVisibility(0);
                this.doT.setText(atN);
            }
            this.bkq = bVar.cBz;
            if (k.jP(this.bkq.getId())) {
                aby();
            }
            this.bvI.setData(this.bkq);
            k.b(this.bkq, this.mTitle);
            this.doZ = true;
            if ((StringUtils.isNull(this.bkq.getTitle()) && (this.bkq.rt() == null || this.bkq.rt().size() == 0)) || this.bkq.rL() == 1) {
                this.bkq.e(false, true);
                if (this.bkq.rV() == null || StringUtils.isNull(this.bkq.rV().toString())) {
                    this.doZ = false;
                }
            }
            W(this.bkq);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.doU != null) {
            this.doU.setTag(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aby() {
        k.a(this.mTitle, this.bkq.getId(), d.C0096d.cp_cont_b, d.C0096d.cp_cont_d);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void abM() {
        if (this.doY != null && this.bkq != null) {
            k.jO(this.bkq.getId());
            aby();
            PbActivityConfig createCfgForPersonCenter = new PbActivityConfig(this.mPageContext.getPageActivity()).createCfgForPersonCenter(this.bkq.getId(), this.bkq.rM(), k.rl(), 18005);
            createCfgForPersonCenter.setStartFrom(this.currentPageType);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createCfgForPersonCenter));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
