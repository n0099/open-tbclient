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
/* loaded from: classes2.dex */
public abstract class d extends com.baidu.tieba.card.a<com.baidu.tieba.homepage.concern.b.b> {
    protected bd bXU;
    private final View.OnClickListener bcm;
    private com.baidu.tbadk.core.view.userLike.c cTp;
    public ThreadUserInfoLayout ciS;
    public ThreadCommentAndPraiseInfoLayout ciT;
    protected LinearLayout cjQ;
    private TextView ecK;
    public ConcernUserLikeButton ecL;
    private View ecM;
    private View ecN;
    public LinearLayout ecO;
    protected com.baidu.tieba.homepage.concern.b.b ecP;
    protected boolean ecQ;
    private View.OnClickListener ecR;
    protected View.OnClickListener ecS;
    private final View.OnClickListener ecT;
    protected TbPageContext<?> mPageContext;
    private int mSkinType;
    protected TextView mTitle;

    protected abstract void U(bd bdVar);

    protected abstract void bz(View view);

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.ecQ = true;
        this.ecR = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.akg() != null) {
                    d.this.akg().a(view, d.this.ecP);
                }
                if (d.this.ecP != null && !StringUtils.isNull(d.this.ecP.ecx.getName()) && !StringUtils.isNull(d.this.ecP.ecx.getUserId())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(d.this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.g.b.c(d.this.ecP.ecx.getUserId(), 0L), false, d.this.ecP.ecx.isGod())));
                }
            }
        };
        this.ecS = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.d.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.akg() != null) {
                    d.this.akg().a(view, d.this.ecP);
                }
                d.this.akA();
            }
        };
        this.bcm = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.d.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.akg() != null) {
                    d.this.akg().a(view, d.this.ecP);
                }
            }
        };
        this.ecT = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.d.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == d.g.thread_info_commont_container && d.this.bXU != null) {
                    k.kk(d.this.bXU.getId());
                    d.this.akl();
                }
            }
        };
        View view = getView();
        this.currentPageType = 1;
        this.mPageContext = tbPageContext;
        this.ecK = (TextView) view.findViewById(d.g.card_recommend_god_reason);
        this.ecL = (ConcernUserLikeButton) view.findViewById(d.g.card_recommend_god_user_like_btn);
        this.ciS = (ThreadUserInfoLayout) view.findViewById(d.g.card_rec_god_user_info);
        this.cTp = new com.baidu.tbadk.core.view.userLike.c(tbPageContext, this.ecL);
        this.ciS.setTShowVisible(false);
        this.ciS.getHeaderImg().setAfterClickListener(this.bcm);
        this.ecL.setAfterOnClickListener(this.bcm);
        this.ecM = view.findViewById(d.g.card_recommend_god_divide_line);
        this.ecN = view.findViewById(d.g.divider_line);
        this.ecO = (LinearLayout) view.findViewById(d.g.card_recommend_god_content);
        this.ecO.setOnClickListener(this.ecR);
        this.mTitle = (TextView) view.findViewById(d.g.card_recommend_god_therad_title);
        this.ciT = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.card_recommend_god_therad_info_layout);
        this.ciT.setOnClickListener(this.ecS);
        this.ciT.setReplyTimeVisible(false);
        this.ciT.setIsBarViewVisible(false);
        this.ciT.setShowPraiseNum(true);
        this.ciT.setNeedAddPraiseIcon(true);
        this.ciT.setNeedAddReplyIcon(true);
        this.ciT.setShareVisible(true);
        this.ciT.bbX = this.currentPageType;
        this.ciT.setForumAfterClickListener(this.ecT);
        this.cjQ = (LinearLayout) view.findViewById(d.g.card_recommend_god_therad_content_layout);
        bz(view);
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
            this.cTp.h(bdUniqueId);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.s(getView(), d.f.addresslist_item_bg);
            aj.r(this.ecK, d.C0108d.cp_cont_d);
            aj.t(this.ecM, d.C0108d.cp_bg_line_e);
            aj.t(this.ecN, d.C0108d.cp_bg_line_e);
            this.ecL.onChangeSkinType(i);
            this.ciT.onChangeSkinType();
        }
        this.mSkinType = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.homepage.concern.b.b bVar) {
        if (bVar != null && bVar.ecx != null && !StringUtils.isNull(bVar.ecx.getName()) && !StringUtils.isNull(bVar.ecx.getUserId()) && !StringUtils.isNull(bVar.dvb.getTid())) {
            this.ecP = bVar;
            if (this.ciS != null) {
                this.ciS.setData(bVar.dvb);
                if (this.ciS.getHeaderImg() != null) {
                    this.ciS.getHeaderImg().setData(bVar.metaData);
                }
                this.ciS.onChangeSkinType();
            }
            this.cTp.a(this.ecP.metaData);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ecO.getLayoutParams();
            String aAY = this.ecP.ecx.aAY();
            if (StringUtils.isNull(aAY)) {
                this.ecK.setVisibility(8);
            } else {
                this.ecK.setVisibility(0);
                this.ecK.setText(aAY);
            }
            this.bXU = bVar.dvb;
            if (k.kl(this.bXU.getId())) {
                akl();
            }
            this.ciT.setData(this.bXU);
            k.b(this.bXU, this.mTitle);
            this.ecQ = true;
            if ((StringUtils.isNull(this.bXU.getTitle()) && (this.bXU.yR() == null || this.bXU.yR().size() == 0)) || this.bXU.zj() == 1) {
                this.bXU.h(false, true);
                if (this.bXU.zt() == null || StringUtils.isNull(this.bXU.zt().toString())) {
                    this.ecQ = false;
                }
            }
            U(this.bXU);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.ecL != null) {
            this.ecL.setTag(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void akl() {
        k.a(this.mTitle, this.bXU.getId(), d.C0108d.cp_cont_b, d.C0108d.cp_cont_d);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void akA() {
        if (this.ecP != null && this.bXU != null) {
            k.kk(this.bXU.getId());
            akl();
            PbActivityConfig createCfgForPersonCenter = new PbActivityConfig(this.mPageContext.getPageActivity()).createCfgForPersonCenter(this.bXU.getId(), this.bXU.zk(), k.yJ(), 18005);
            createCfgForPersonCenter.setStartFrom(this.currentPageType);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createCfgForPersonCenter));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
