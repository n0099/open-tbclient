package com.baidu.tieba.frs.entelechy.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BookCoverActivityConfig;
import com.baidu.tbadk.core.atomData.MangaBrowserActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalCardDetailActivityConfig;
import com.baidu.tbadk.core.atomData.ShareWebActivityConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.ThemeCardInUserData;
import com.baidu.tbadk.core.data.ak;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.data.m;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tbadk.core.view.ThreadSourceShareAndPraiseLayout;
import com.baidu.tbadk.core.view.ThreadUserInfoLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.card.o;
import com.baidu.tieba.e;
/* loaded from: classes6.dex */
public abstract class c extends com.baidu.tieba.card.a<bb> implements com.baidu.tieba.a.e, ab {
    protected bb aAQ;
    private final View.OnClickListener aGk;
    public View bHt;
    private String bVS;
    private HeadPendantClickableView bWP;
    protected ThreadSourceShareAndPraiseLayout bWS;
    public ThreadUserInfoLayout bWe;
    public ThreadCommentAndPraiseInfoLayout bWf;
    public LinearLayout bXd;
    public View buH;
    private ThreadGodReplyLayout cKD;
    private View.OnClickListener cKG;
    public TbImageView cOT;
    private TbImageView cOV;
    private com.baidu.tieba.frs.vc.g dJC;
    private String mForumName;
    private TbPageContext<?> mPageContext;
    private int mSkinType;

    protected abstract void av(View view);

    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.cKG = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.anO() != null) {
                    c.this.anO().a(view, c.this.aAQ);
                }
                c.this.fb(view == c.this.cKD);
            }
        };
        this.aGk = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.anO() != null) {
                    c.this.anO().a(view, c.this.aAQ);
                }
            }
        };
        View view = getView();
        setTag(bdUniqueId);
        this.mPageContext = tbPageContext;
        this.currentPageType = 3;
        this.bWP = (HeadPendantClickableView) view.findViewById(e.g.card_home_page_normal_thread_user_pendant_header);
        if (this.bWP.getHeadView() != null) {
            this.bWP.getHeadView().setIsRound(true);
            this.bWP.getHeadView().setDrawBorder(false);
            this.bWP.getHeadView().setDefaultResource(17170445);
            this.bWP.getHeadView().setDefaultErrorResource(e.f.icon_default_avatar100);
            this.bWP.getHeadView().setDefaultBgResource(e.d.cp_bg_line_e);
            this.bWP.getHeadView().setRadius(l.h(this.mPageContext.getPageActivity(), e.C0175e.ds70));
            this.bWP.setAfterClickListener(this.aGk);
        }
        this.bWP.setHasPendantStyle();
        if (this.bWP.getPendantView() != null) {
            this.bWP.getPendantView().setIsRound(true);
            this.bWP.getPendantView().setDrawBorder(false);
        }
        this.cOV = (TbImageView) view.findViewById(e.g.frs_normal_item_star_view);
        this.buH = view.findViewById(e.g.divider_line);
        this.bHt = view.findViewById(e.g.top_divider_line);
        this.bWf = (ThreadCommentAndPraiseInfoLayout) view.findViewById(e.g.card_home_page_normal_thread_info_layout);
        this.bWe = (ThreadUserInfoLayout) view.findViewById(e.g.card_home_page_normal_thread_user_info_layout);
        this.bWe.setUserAfterClickListener(this.aGk);
        this.bWe.setFrom(3);
        if (this.bWf.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bWf.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.bWf.setLayoutParams(layoutParams);
        }
        this.bWf.setOnClickListener(this.cKG);
        this.bWf.setReplyTimeVisible(false);
        this.bWf.setShowPraiseNum(true);
        this.bWf.setNeedAddPraiseIcon(true);
        this.bWf.setNeedAddReplyIcon(true);
        this.bWf.setIsBarViewVisible(false);
        this.bWf.setShareVisible(true);
        this.bWf.setShareReportFrom(1);
        this.bWf.setFrom(2);
        this.bWf.setDisPraiseFrom(2);
        this.bWf.setStType("frs_page");
        this.bWf.ary = 3;
        if (view instanceof ViewGroup) {
            this.dJC = new com.baidu.tieba.frs.vc.g(this.mPageContext, (ViewGroup) view);
        } else {
            this.dJC = new com.baidu.tieba.frs.vc.g(this.mPageContext, this.bWe);
        }
        this.bWS = (ThreadSourceShareAndPraiseLayout) view.findViewById(e.g.card_link_thread_source_read_share_layout);
        this.bWS.aFS.setOnClickListener(this.cKG);
        this.bWS.setFrom(2);
        this.bWS.setShareReportFrom(1);
        this.bWS.setSourceFromForPb(3);
        this.bWS.setStType("frs_page");
        this.bWS.setHideBarName(true);
        this.bWS.aFS.setNeedAddReplyIcon(true);
        this.dJC.setUniqueId(getTag());
        this.cKD = (ThreadGodReplyLayout) view.findViewById(e.g.card_home_page_god_reply_layout);
        this.cKD.setOnClickListener(this.cKG);
        this.cOT = (TbImageView) view.findViewById(e.g.frs_normal_item_theme_card);
        this.cOT.setPageId(getTag());
        this.bXd = (LinearLayout) view.findViewById(e.g.card_home_page_normal_thread_content_layout);
        av(view);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.i(getView(), e.f.addresslist_item_bg);
            al.j(this.buH, e.d.cp_bg_line_e);
            al.j(this.bHt, e.d.cp_bg_line_e);
            this.bWf.onChangeSkinType();
            this.bWe.onChangeSkinType();
            this.cKD.onChangeSkinType();
            this.dJC.onChangeSkinType();
            if (this.bWS != null && this.bWS.getVisibility() == 0) {
                this.bWS.onChangeSkinType();
            }
        }
        this.mSkinType = i;
    }

    private void N(final bb bbVar) {
        if (this.cOV != null) {
            if (this.cOT == null || bbVar == null) {
                this.cOV.setVisibility(8);
            } else if (!StringUtils.isNull(bbVar.arh) && this.cOT.getVisibility() != 0) {
                if (this.dJC != null && this.dJC.aGk() && (this.cOV.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.cOV.getLayoutParams();
                    layoutParams.rightMargin = l.h(this.mPageContext.getPageActivity(), e.C0175e.tbds106);
                    this.cOV.setLayoutParams(layoutParams);
                }
                this.cOV.setVisibility(0);
                this.cOV.setImageDrawable(null);
                this.cOV.startLoad(bbVar.arh, 10, false);
                this.cOV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (c.this.mPageContext != null) {
                            c.this.mPageContext.sendMessage(new CustomMessage(2002001, new ShareWebActivityConfig(c.this.mPageContext.getPageActivity(), "", bbVar.ari, true)));
                        }
                        TiebaStatic.log(new am("c12883"));
                    }
                });
            } else {
                this.cOV.setVisibility(8);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: F */
    public void a(bb bbVar) {
        if (bbVar == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        this.aAQ = bbVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.cKG);
        }
        if (!anS() && o.me(this.aAQ.getId())) {
            anT();
        }
        Q(bbVar);
        this.dJC.af(this.aAQ);
        N(bbVar);
        this.bWe.setData(this.aAQ);
        this.cKD.setData(this.aAQ.zM());
        this.bWe.setUserAfterClickListener(this.aGk);
        if (this.bWe.getHeaderImg() != null) {
            if (this.bWe.getIsSimpleThread()) {
                this.bWe.getHeaderImg().setVisibility(8);
                this.bWP.setVisibility(8);
            } else if (bbVar.yv() == null || bbVar.yv().getPendantData() == null || StringUtils.isNull(bbVar.yv().getPendantData().xf())) {
                this.bWP.setVisibility(8);
                this.bWe.getHeaderImg().setVisibility(0);
                this.bWe.getHeaderImg().setData(bbVar);
            } else {
                this.bWe.getHeaderImg().setVisibility(4);
                this.bWP.setVisibility(0);
                this.bWP.setData(bbVar);
            }
        }
        ik(hb(1));
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    public void Q(bb bbVar) {
        MetaData yv;
        if (bbVar != null && this.cOT != null && (yv = bbVar.yv()) != null) {
            final ThemeCardInUserData themeCard = yv.getThemeCard();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                this.cOT.setVisibility(8);
                return;
            }
            this.cOT.setVisibility(0);
            this.cOT.setImageBitmap(null);
            this.cOT.startLoad(themeCard.getCardImageUrlAndroid(), 10, false);
            this.cOT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonalCardDetailActivityConfig(c.this.mPageContext.getPageActivity(), themeCard.getCardId())));
                }
            });
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.bWf != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.bWe != null) {
            this.bWe.setPageUniqueId(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fb(boolean z) {
        if (this.aAQ != null) {
            o.md(this.aAQ.getId());
            anT();
            m zq = this.aAQ.zq();
            if (zq != null) {
                if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                    ba.bH(this.mContext);
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(this.mPageContext.getPageActivity(), zq.getCartoonId(), zq.getChapterId(), 2)));
                return;
            }
            com.baidu.tbadk.core.data.j jVar = this.aAQ.aqC;
            if (this.aAQ.aqB == 1 && jVar != null && TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                String str = jVar.ama;
                long j = jVar.amb;
                ak akVar = new ak();
                akVar.pageContext = this.mPageContext;
                akVar.amo = str;
                akVar.chapterId = (int) j;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001417, akVar));
                return;
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(this.aAQ, null, "frs_page", 18003, true, false, false).addLocateParam("");
            addLocateParam.setStartFrom(this.currentPageType);
            if (z) {
                addLocateParam.setJumpGodReply(true);
            }
            this.mPageContext.sendMessage(new CustomMessage(2004001, addLocateParam));
        }
    }

    private boolean anS() {
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // com.baidu.tieba.card.ab
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.ab
    public void ii(int i) {
        this.currentPageType = i;
        if (this.bWf != null) {
            this.bWf.ary = i;
            if (i == 15) {
                this.bWf.setFrom(10);
                return;
            }
            this.bWf.setFrom(2);
            this.bWf.setDisPraiseFrom(2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void anT() {
        o.a(this.cKD.getGodReplyContent(), this.aAQ.getId(), e.d.cp_cont_f, e.d.cp_cont_d);
    }

    public ThreadCommentAndPraiseInfoLayout aaX() {
        return this.bWf;
    }

    public ThreadCommentAndPraiseInfoLayout aaY() {
        return this.bWS.aFS;
    }

    public void ik(int i) {
        if (this.aAQ != null) {
            if (i == 1) {
                this.bWf.setVisibility(8);
                this.bWS.setData(this.aAQ);
                return;
            }
            this.bWf.setData(this.aAQ);
            this.bWS.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.bVS = str;
    }

    public int hb(int i) {
        return com.baidu.tieba.a.d.Ux().M(this.bVS, i);
    }
}
