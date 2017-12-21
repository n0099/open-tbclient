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
    private final View.OnClickListener aog;
    private HeadPendantClickableView bZi;
    private ThreadGodReplyLayout bZj;
    private com.baidu.tieba.NEGFeedBack.c bZk;
    private View bZl;
    protected com.baidu.tieba.card.data.l bZm;
    private View.OnClickListener bZn;
    public ThreadUserInfoLayout bvI;
    public ThreadCommentAndPraiseInfoLayout bvM;
    private TbPageContext<?> mPageContext;
    private int mSkinType;

    protected abstract void af(View view);

    protected abstract void b(com.baidu.tieba.card.data.l lVar);

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bZk = null;
        this.mSkinType = 3;
        this.bZn = new View.OnClickListener() { // from class: com.baidu.tieba.card.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.abt() != null) {
                    c.this.abt().a(view, c.this.bZm);
                }
                c.this.dO(view == c.this.bZj);
            }
        };
        this.aog = new View.OnClickListener() { // from class: com.baidu.tieba.card.c.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.abt() != null) {
                    c.this.abt().a(view, c.this.bZm);
                }
            }
        };
        View view = getView();
        this.mPageContext = tbPageContext;
        this.bZi = (HeadPendantClickableView) view.findViewById(d.g.card_home_page_normal_thread_user_pendant_header);
        if (this.bZi.getHeadView() != null) {
            this.bZi.getHeadView().setIsRound(true);
            this.bZi.getHeadView().setDrawBorder(false);
            this.bZi.getHeadView().setDefaultResource(17170445);
            this.bZi.getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
            this.bZi.getHeadView().setDefaultBgResource(d.C0095d.cp_bg_line_e);
            this.bZi.getHeadView().setRadius(com.baidu.adp.lib.util.l.f(this.mPageContext.getPageActivity(), d.e.ds70));
        }
        this.bZi.wi();
        if (this.bZi.getPendantView() != null) {
            this.bZi.getPendantView().setIsRound(true);
            this.bZi.getPendantView().setDrawBorder(false);
        }
        this.bvM = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.card_home_page_normal_thread_info_layout);
        this.bvI = (ThreadUserInfoLayout) view.findViewById(d.g.card_home_page_normal_thread_user_info_layout);
        this.bZk = new com.baidu.tieba.NEGFeedBack.c(this.mPageContext);
        this.bZk.a((ViewGroup) this.bZi.getParent(), com.baidu.adp.lib.util.l.f(this.mContext, d.e.tbds120), 0);
        if (this.bvM.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bvM.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.bvM.setLayoutParams(layoutParams);
        }
        this.bZl = view.findViewById(d.g.divider_line);
        this.bvM.setOnClickListener(this.bZn);
        this.bvM.setReplyTimeVisible(false);
        this.bvM.setShowPraiseNum(true);
        this.bvM.setNeedAddPraiseIcon(true);
        this.bvM.setNeedAddReplyIcon(true);
        this.bvM.setShareVisible(true);
        this.bvM.setShareReportFrom(3);
        this.bvM.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (c.this.abt() != null) {
                    c.this.abt().a(view2, c.this.bZm);
                }
            }
        });
        this.bZj = (ThreadGodReplyLayout) view.findViewById(d.g.card_home_page_god_reply_layout);
        this.bZj.setOnClickListener(this.bZn);
        af(view);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.j(getView(), d.f.addresslist_item_bg);
            this.bvM.onChangeSkinType();
            this.bZj.onChangeSkinType();
            this.bvI.onChangeSkinType();
            if (this.bZk != null) {
                this.bZk.onChangeSkinType();
            }
            aj.k(this.bZl, d.C0095d.cp_bg_line_c);
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
        this.bZm = lVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.bZn);
        }
        if (this.bZk != null && this.bZm.Ox() != null && lVar.threadData.rv() != null && !StringUtils.isNull(lVar.threadData.rv().getUserId())) {
            if (lVar.threadData.rv().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                this.bZk.setVisibility(8);
            } else {
                this.bZk.setVisibility(0);
                ah ahVar = new ah();
                ahVar.cD(this.bZm.Ox().getTid());
                ahVar.setFid(this.bZm.Ox().getFid());
                ahVar.a(this.bZm.XB);
                this.bZk.setData(ahVar);
                this.bZk.setFirstRowSingleColumn(true);
            }
        }
        this.bvI.setData(lVar.threadData);
        this.bZj.setData(lVar.threadData.sM());
        if (!abx() && k.jP(this.bZm.threadData.getId())) {
            aby();
        }
        this.bvI.setUserAfterClickListener(this.aog);
        this.bvM.setData(lVar.threadData);
        bd Ox = lVar.Ox();
        if (this.bvI.getHeaderImg() != null) {
            if (this.bvI.getIsSimpleThread()) {
                this.bvI.getHeaderImg().setVisibility(8);
                this.bZi.setVisibility(8);
            } else if (Ox.rv() == null || Ox.rv().getPendantData() == null || StringUtils.isNull(Ox.rv().getPendantData().pR())) {
                this.bZi.setVisibility(8);
                this.bvI.getHeaderImg().setVisibility(0);
                this.bvI.getHeaderImg().setData(Ox);
            } else {
                this.bvI.getHeaderImg().setVisibility(4);
                this.bZi.setVisibility(0);
                this.bZi.setData(Ox);
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
        if (this.bZk != null) {
            this.bZk.setUniqueId(bdUniqueId);
        }
        if (this.bvI != null) {
            this.bvI.setPageUniqueId(bdUniqueId);
        }
    }

    public View abv() {
        return this.bZj;
    }

    public void a(c.a aVar) {
        if (this.bZk != null) {
            this.bZk.setEventCallback(aVar);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.bvI != null) {
            return this.bvI.aob;
        }
        return null;
    }

    public View abw() {
        if (this.bvI != null) {
            return this.bvI.aoc;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dO(boolean z) {
        if (this.bZm != null && this.bZm.threadData != null) {
            if (!abx()) {
                k.jO(this.bZm.threadData.getId());
                aby();
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(this.bZm.threadData, null, k.rl(), 18003, true, false, false).addLocateParam(this.bZm.acf());
            addLocateParam.setForumId(String.valueOf(this.bZm.threadData.getFid()));
            addLocateParam.setStartFrom(this.currentPageType);
            if (z) {
                addLocateParam.setJumpGodReply(true);
            }
            this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
        }
    }

    private boolean abx() {
        return this.bZm.cdX && !this.bZm.aDp;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aby() {
        k.a(this.bZj.getGodReplyContent(), this.bZm.threadData.getId(), d.C0095d.cp_cont_f, d.C0095d.cp_cont_d);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
