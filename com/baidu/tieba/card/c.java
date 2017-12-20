package com.baidu.tieba.card;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.ah;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tbadk.core.view.ThreadUserInfoLayout;
import com.baidu.tieba.NEGFeedBack.c;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public abstract class c extends a<com.baidu.tieba.card.data.l> {
    private final View.OnClickListener aod;
    private HeadPendantClickableView bZe;
    private ThreadGodReplyLayout bZf;
    private com.baidu.tieba.NEGFeedBack.c bZg;
    private View bZh;
    protected com.baidu.tieba.card.data.l bZi;
    private View.OnClickListener bZj;
    public ThreadUserInfoLayout bvE;
    public ThreadCommentAndPraiseInfoLayout bvI;
    private TbPageContext<?> mPageContext;
    private int mSkinType;

    protected abstract void af(View view);

    protected abstract void b(com.baidu.tieba.card.data.l lVar);

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bZg = null;
        this.mSkinType = 3;
        this.bZj = new View.OnClickListener() { // from class: com.baidu.tieba.card.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.abt() != null) {
                    c.this.abt().a(view, c.this.bZi);
                }
                c.this.dO(view == c.this.bZf);
            }
        };
        this.aod = new View.OnClickListener() { // from class: com.baidu.tieba.card.c.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.abt() != null) {
                    c.this.abt().a(view, c.this.bZi);
                }
            }
        };
        View view = getView();
        this.mPageContext = tbPageContext;
        this.bZe = (HeadPendantClickableView) view.findViewById(d.g.card_home_page_normal_thread_user_pendant_header);
        if (this.bZe.getHeadView() != null) {
            this.bZe.getHeadView().setIsRound(true);
            this.bZe.getHeadView().setDrawBorder(false);
            this.bZe.getHeadView().setDefaultResource(17170445);
            this.bZe.getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
            this.bZe.getHeadView().setDefaultBgResource(d.C0096d.cp_bg_line_e);
            this.bZe.getHeadView().setRadius(com.baidu.adp.lib.util.l.f(this.mPageContext.getPageActivity(), d.e.ds70));
        }
        this.bZe.wi();
        if (this.bZe.getPendantView() != null) {
            this.bZe.getPendantView().setIsRound(true);
            this.bZe.getPendantView().setDrawBorder(false);
        }
        this.bvI = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.card_home_page_normal_thread_info_layout);
        this.bvE = (ThreadUserInfoLayout) view.findViewById(d.g.card_home_page_normal_thread_user_info_layout);
        this.bZg = new com.baidu.tieba.NEGFeedBack.c(this.mPageContext);
        this.bZg.a((ViewGroup) this.bZe.getParent(), com.baidu.adp.lib.util.l.f(this.mContext, d.e.tbds120), 0);
        if (this.bvI.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bvI.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.bvI.setLayoutParams(layoutParams);
        }
        this.bZh = view.findViewById(d.g.divider_line);
        this.bvI.setOnClickListener(this.bZj);
        this.bvI.setReplyTimeVisible(false);
        this.bvI.setShowPraiseNum(true);
        this.bvI.setNeedAddPraiseIcon(true);
        this.bvI.setNeedAddReplyIcon(true);
        this.bvI.setShareVisible(true);
        this.bvI.setShareReportFrom(3);
        this.bvI.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (c.this.abt() != null) {
                    c.this.abt().a(view2, c.this.bZi);
                }
            }
        });
        this.bZf = (ThreadGodReplyLayout) view.findViewById(d.g.card_home_page_god_reply_layout);
        this.bZf.setOnClickListener(this.bZj);
        af(view);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.j(getView(), d.f.addresslist_item_bg);
            this.bvI.onChangeSkinType();
            this.bZf.onChangeSkinType();
            this.bvE.onChangeSkinType();
            if (this.bZg != null) {
                this.bZg.onChangeSkinType();
            }
            aj.k(this.bZh, d.C0096d.cp_bg_line_c);
        }
        this.mSkinType = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.card.data.l lVar) {
        if (lVar == null || lVar.threadData == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        this.bZi = lVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.bZj);
        }
        if (this.bZg != null && this.bZi.Ox() != null && lVar.threadData.rv() != null && !StringUtils.isNull(lVar.threadData.rv().getUserId())) {
            if (lVar.threadData.rv().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                this.bZg.setVisibility(8);
            } else {
                this.bZg.setVisibility(0);
                ah ahVar = new ah();
                ahVar.cD(this.bZi.Ox().getTid());
                ahVar.setFid(this.bZi.Ox().getFid());
                ahVar.a(this.bZi.Xy);
                this.bZg.setData(ahVar);
                this.bZg.setFirstRowSingleColumn(true);
            }
        }
        this.bvE.setData(lVar.threadData);
        this.bZf.setData(lVar.threadData.sM());
        if (!abx() && k.jP(this.bZi.threadData.getId())) {
            aby();
        }
        this.bvE.setUserAfterClickListener(this.aod);
        this.bvI.setData(lVar.threadData);
        bd Ox = lVar.Ox();
        if (this.bvE.getHeaderImg() != null) {
            if (this.bvE.getIsSimpleThread()) {
                this.bvE.getHeaderImg().setVisibility(8);
                this.bZe.setVisibility(8);
            } else if (Ox.rv() == null || Ox.rv().getPendantData() == null || StringUtils.isNull(Ox.rv().getPendantData().pR())) {
                this.bZe.setVisibility(8);
                this.bvE.getHeaderImg().setVisibility(0);
                this.bvE.getHeaderImg().setData(Ox);
            } else {
                this.bvE.getHeaderImg().setVisibility(4);
                this.bZe.setVisibility(0);
                this.bZe.setData(Ox);
            }
        }
        b(lVar);
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    public void k(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.bZg != null) {
            this.bZg.setUniqueId(bdUniqueId);
        }
        if (this.bvE != null) {
            this.bvE.setPageUniqueId(bdUniqueId);
        }
    }

    public View abv() {
        return this.bZf;
    }

    public void a(c.a aVar) {
        if (this.bZg != null) {
            this.bZg.setEventCallback(aVar);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.bvE != null) {
            return this.bvE.anY;
        }
        return null;
    }

    public View abw() {
        if (this.bvE != null) {
            return this.bvE.anZ;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dO(boolean z) {
        if (this.bZi != null && this.bZi.threadData != null) {
            if (!abx()) {
                k.jO(this.bZi.threadData.getId());
                aby();
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(this.bZi.threadData, null, k.rl(), 18003, true, false, false).addLocateParam(this.bZi.acf());
            addLocateParam.setForumId(String.valueOf(this.bZi.threadData.getFid()));
            addLocateParam.setStartFrom(this.currentPageType);
            if (z) {
                addLocateParam.setJumpGodReply(true);
            }
            this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
        }
    }

    private boolean abx() {
        return this.bZi.cdT && !this.bZi.aDm;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aby() {
        k.a(this.bZf.getGodReplyContent(), this.bZi.threadData.getId(), d.C0096d.cp_cont_f, d.C0096d.cp_cont_d);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
