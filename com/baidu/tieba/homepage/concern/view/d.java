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
    private final View.OnClickListener aob;
    private com.baidu.tbadk.core.view.userLike.c bZG;
    protected bd bkp;
    public ThreadUserInfoLayout bvD;
    public ThreadCommentAndPraiseInfoLayout bvH;
    protected LinearLayout bvK;
    private TextView dnN;
    public ConcernUserLikeButton dnO;
    private View dnP;
    private View dnQ;
    public LinearLayout dnR;
    protected com.baidu.tieba.homepage.concern.b.b dnS;
    protected boolean dnT;
    private View.OnClickListener dnU;
    protected View.OnClickListener dnV;
    protected TbPageContext<?> mPageContext;
    private int mSkinType;
    protected TextView mTitle;

    protected abstract void U(bd bdVar);

    protected abstract void ae(View view);

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.dnT = true;
        this.dnU = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.abs() != null) {
                    d.this.abs().a(view, d.this.dnS);
                }
                if (d.this.dnS != null && !StringUtils.isNull(d.this.dnS.dnA.getName()) && !StringUtils.isNull(d.this.dnS.dnA.getUserId())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(d.this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.g.b.c(d.this.dnS.dnA.getUserId(), 0L), false, d.this.dnS.dnA.isGod())));
                }
            }
        };
        this.dnV = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.d.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.abs() != null) {
                    d.this.abs().a(view, d.this.dnS);
                }
                d.this.abK();
            }
        };
        this.aob = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.d.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.abs() != null) {
                    d.this.abs().a(view, d.this.dnS);
                }
            }
        };
        View view = getView();
        this.currentPageType = 1;
        this.mPageContext = tbPageContext;
        this.dnN = (TextView) view.findViewById(d.g.card_recommend_god_reason);
        this.dnO = (ConcernUserLikeButton) view.findViewById(d.g.card_recommend_god_user_like_btn);
        this.bvD = (ThreadUserInfoLayout) view.findViewById(d.g.card_rec_god_user_info);
        this.bZG = new com.baidu.tbadk.core.view.userLike.c(tbPageContext, this.dnO);
        this.bvD.setTShowVisible(false);
        this.bvD.getHeaderImg().setAfterClickListener(this.aob);
        this.dnO.setAfterOnClickListener(this.aob);
        this.dnP = view.findViewById(d.g.card_recommend_god_divide_line);
        this.dnQ = view.findViewById(d.g.divider_line);
        this.dnR = (LinearLayout) view.findViewById(d.g.card_recommend_god_content);
        this.dnR.setOnClickListener(this.dnU);
        this.mTitle = (TextView) view.findViewById(d.g.card_recommend_god_therad_title);
        this.bvH = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.card_recommend_god_therad_info_layout);
        this.bvH.setOnClickListener(this.dnV);
        this.bvH.setReplyTimeVisible(false);
        this.bvH.setIsBarViewVisible(false);
        this.bvH.setShowPraiseNum(true);
        this.bvH.setNeedAddPraiseIcon(true);
        this.bvH.setNeedAddReplyIcon(true);
        this.bvH.setShareVisible(true);
        this.bvH.anM = this.currentPageType;
        this.bvK = (LinearLayout) view.findViewById(d.g.card_recommend_god_therad_content_layout);
        ae(view);
    }

    public void k(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
            this.bZG.h(bdUniqueId);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.j(getView(), d.f.addresslist_item_bg);
            aj.i(this.dnN, d.C0082d.cp_cont_d);
            aj.k(this.dnP, d.C0082d.cp_bg_line_e);
            aj.k(this.dnQ, d.C0082d.cp_bg_line_e);
            this.dnO.onChangeSkinType(i);
            this.bvH.onChangeSkinType();
        }
        this.mSkinType = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.homepage.concern.b.b bVar) {
        if (bVar != null && bVar.dnA != null && !StringUtils.isNull(bVar.dnA.getName()) && !StringUtils.isNull(bVar.dnA.getUserId()) && !StringUtils.isNull(bVar.cBr.getTid())) {
            this.dnS = bVar;
            if (this.bvD != null) {
                this.bvD.setData(bVar.cBr);
                if (this.bvD.getHeaderImg() != null) {
                    this.bvD.getHeaderImg().setData(bVar.metaData);
                }
                this.bvD.onChangeSkinType();
            }
            this.bZG.a(this.dnS.metaData);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dnR.getLayoutParams();
            String atF = this.dnS.dnA.atF();
            if (StringUtils.isNull(atF)) {
                this.dnN.setVisibility(8);
            } else {
                this.dnN.setVisibility(0);
                this.dnN.setText(atF);
            }
            this.bkp = bVar.cBr;
            if (k.jR(this.bkp.getId())) {
                abx();
            }
            this.bvH.setData(this.bkp);
            k.b(this.bkp, this.mTitle);
            this.dnT = true;
            if ((StringUtils.isNull(this.bkp.getTitle()) && (this.bkp.rv() == null || this.bkp.rv().size() == 0)) || this.bkp.rN() == 1) {
                this.bkp.e(false, true);
                if (this.bkp.rX() == null || StringUtils.isNull(this.bkp.rX().toString())) {
                    this.dnT = false;
                }
            }
            U(this.bkp);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.dnO != null) {
            this.dnO.setTag(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void abx() {
        k.a(this.mTitle, this.bkp.getId(), d.C0082d.cp_cont_b, d.C0082d.cp_cont_d);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void abK() {
        if (this.dnS != null && this.bkp != null) {
            k.jQ(this.bkp.getId());
            abx();
            PbActivityConfig createCfgForPersonCenter = new PbActivityConfig(this.mPageContext.getPageActivity()).createCfgForPersonCenter(this.bkp.getId(), this.bkp.rO(), k.rn(), 18005);
            createCfgForPersonCenter.setStartFrom(this.currentPageType);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createCfgForPersonCenter));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
