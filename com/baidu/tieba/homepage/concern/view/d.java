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
    protected bd bXM;
    private final View.OnClickListener bce;
    private com.baidu.tbadk.core.view.userLike.c cSU;
    public ThreadUserInfoLayout ciK;
    public ThreadCommentAndPraiseInfoLayout ciL;
    protected LinearLayout cjI;
    private TextView ecp;
    public ConcernUserLikeButton ecq;
    private View ecr;
    private View ecs;
    public LinearLayout ect;
    protected com.baidu.tieba.homepage.concern.b.b ecu;
    protected boolean ecv;
    private View.OnClickListener ecw;
    protected View.OnClickListener ecx;
    private final View.OnClickListener ecy;
    protected TbPageContext<?> mPageContext;
    private int mSkinType;
    protected TextView mTitle;

    protected abstract void U(bd bdVar);

    protected abstract void bz(View view);

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.ecv = true;
        this.ecw = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.akb() != null) {
                    d.this.akb().a(view, d.this.ecu);
                }
                if (d.this.ecu != null && !StringUtils.isNull(d.this.ecu.ecc.getName()) && !StringUtils.isNull(d.this.ecu.ecc.getUserId())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(d.this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.g.b.c(d.this.ecu.ecc.getUserId(), 0L), false, d.this.ecu.ecc.isGod())));
                }
            }
        };
        this.ecx = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.d.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.akb() != null) {
                    d.this.akb().a(view, d.this.ecu);
                }
                d.this.akv();
            }
        };
        this.bce = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.d.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.akb() != null) {
                    d.this.akb().a(view, d.this.ecu);
                }
            }
        };
        this.ecy = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.d.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == d.g.thread_info_commont_container && d.this.bXM != null) {
                    k.kc(d.this.bXM.getId());
                    d.this.akg();
                }
            }
        };
        View view = getView();
        this.currentPageType = 1;
        this.mPageContext = tbPageContext;
        this.ecp = (TextView) view.findViewById(d.g.card_recommend_god_reason);
        this.ecq = (ConcernUserLikeButton) view.findViewById(d.g.card_recommend_god_user_like_btn);
        this.ciK = (ThreadUserInfoLayout) view.findViewById(d.g.card_rec_god_user_info);
        this.cSU = new com.baidu.tbadk.core.view.userLike.c(tbPageContext, this.ecq);
        this.ciK.setTShowVisible(false);
        this.ciK.getHeaderImg().setAfterClickListener(this.bce);
        this.ecq.setAfterOnClickListener(this.bce);
        this.ecr = view.findViewById(d.g.card_recommend_god_divide_line);
        this.ecs = view.findViewById(d.g.divider_line);
        this.ect = (LinearLayout) view.findViewById(d.g.card_recommend_god_content);
        this.ect.setOnClickListener(this.ecw);
        this.mTitle = (TextView) view.findViewById(d.g.card_recommend_god_therad_title);
        this.ciL = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.card_recommend_god_therad_info_layout);
        this.ciL.setOnClickListener(this.ecx);
        this.ciL.setReplyTimeVisible(false);
        this.ciL.setIsBarViewVisible(false);
        this.ciL.setShowPraiseNum(true);
        this.ciL.setNeedAddPraiseIcon(true);
        this.ciL.setNeedAddReplyIcon(true);
        this.ciL.setShareVisible(true);
        this.ciL.bbP = this.currentPageType;
        this.ciL.setForumAfterClickListener(this.ecy);
        this.cjI = (LinearLayout) view.findViewById(d.g.card_recommend_god_therad_content_layout);
        bz(view);
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
            this.cSU.h(bdUniqueId);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.s(getView(), d.f.addresslist_item_bg);
            aj.r(this.ecp, d.C0107d.cp_cont_d);
            aj.t(this.ecr, d.C0107d.cp_bg_line_e);
            aj.t(this.ecs, d.C0107d.cp_bg_line_e);
            this.ecq.onChangeSkinType(i);
            this.ciL.onChangeSkinType();
        }
        this.mSkinType = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.homepage.concern.b.b bVar) {
        if (bVar != null && bVar.ecc != null && !StringUtils.isNull(bVar.ecc.getName()) && !StringUtils.isNull(bVar.ecc.getUserId()) && !StringUtils.isNull(bVar.duG.getTid())) {
            this.ecu = bVar;
            if (this.ciK != null) {
                this.ciK.setData(bVar.duG);
                if (this.ciK.getHeaderImg() != null) {
                    this.ciK.getHeaderImg().setData(bVar.metaData);
                }
                this.ciK.onChangeSkinType();
            }
            this.cSU.a(this.ecu.metaData);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ect.getLayoutParams();
            String aAT = this.ecu.ecc.aAT();
            if (StringUtils.isNull(aAT)) {
                this.ecp.setVisibility(8);
            } else {
                this.ecp.setVisibility(0);
                this.ecp.setText(aAT);
            }
            this.bXM = bVar.duG;
            if (k.kd(this.bXM.getId())) {
                akg();
            }
            this.ciL.setData(this.bXM);
            k.b(this.bXM, this.mTitle);
            this.ecv = true;
            if ((StringUtils.isNull(this.bXM.getTitle()) && (this.bXM.yQ() == null || this.bXM.yQ().size() == 0)) || this.bXM.zi() == 1) {
                this.bXM.h(false, true);
                if (this.bXM.zs() == null || StringUtils.isNull(this.bXM.zs().toString())) {
                    this.ecv = false;
                }
            }
            U(this.bXM);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.ecq != null) {
            this.ecq.setTag(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void akg() {
        k.a(this.mTitle, this.bXM.getId(), d.C0107d.cp_cont_b, d.C0107d.cp_cont_d);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void akv() {
        if (this.ecu != null && this.bXM != null) {
            k.kc(this.bXM.getId());
            akg();
            PbActivityConfig createCfgForPersonCenter = new PbActivityConfig(this.mPageContext.getPageActivity()).createCfgForPersonCenter(this.bXM.getId(), this.bXM.zj(), k.yI(), 18005);
            createCfgForPersonCenter.setStartFrom(this.currentPageType);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createCfgForPersonCenter));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
