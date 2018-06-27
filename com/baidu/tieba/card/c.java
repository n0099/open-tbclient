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
import com.baidu.tbadk.core.data.ai;
import com.baidu.tbadk.core.data.bc;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tbadk.core.view.ThreadSourceShareAndPraiseLayout;
import com.baidu.tbadk.core.view.ThreadUserInfoLayout;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public abstract class c extends a<com.baidu.tieba.card.data.k> implements com.baidu.tieba.a.e {
    private final View.OnClickListener ayi;
    private String bGM;
    public ThreadUserInfoLayout bGY;
    public ThreadCommentAndPraiseInfoLayout bGZ;
    private HeadPendantClickableView bHK;
    public ThreadSourceShareAndPraiseLayout bHN;
    private NEGFeedBackView bHl;
    private ThreadGodReplyLayout ctS;
    private View ctT;
    protected com.baidu.tieba.card.data.k ctU;
    private View.OnClickListener ctV;
    private TbPageContext<?> mPageContext;
    private int mSkinType;

    protected abstract void ae(View view);

    protected abstract void b(com.baidu.tieba.card.data.k kVar);

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bHl = null;
        this.mSkinType = 3;
        this.ctV = new View.OnClickListener() { // from class: com.baidu.tieba.card.c.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.aia() != null) {
                    c.this.aia().a(view, c.this.ctU);
                }
                c.this.er(view == c.this.ctS);
            }
        };
        this.ayi = new View.OnClickListener() { // from class: com.baidu.tieba.card.c.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.aia() != null) {
                    c.this.aia().a(view, c.this.ctU);
                }
            }
        };
        View view = getView();
        this.mPageContext = tbPageContext;
        this.bHK = (HeadPendantClickableView) view.findViewById(d.g.card_home_page_normal_thread_user_pendant_header);
        if (this.bHK.getHeadView() != null) {
            this.bHK.getHeadView().setIsRound(true);
            this.bHK.getHeadView().setDrawBorder(false);
            this.bHK.getHeadView().setDefaultResource(17170445);
            this.bHK.getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
            this.bHK.getHeadView().setDefaultBgResource(d.C0142d.cp_bg_line_e);
            this.bHK.getHeadView().setRadius(com.baidu.adp.lib.util.l.e(this.mPageContext.getPageActivity(), d.e.ds70));
        }
        this.bHK.setHasPendantStyle();
        if (this.bHK.getPendantView() != null) {
            this.bHK.getPendantView().setIsRound(true);
            this.bHK.getPendantView().setDrawBorder(false);
        }
        this.bGZ = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.card_home_page_normal_thread_info_layout);
        this.bGY = (ThreadUserInfoLayout) view.findViewById(d.g.card_home_page_normal_thread_user_info_layout);
        this.bHl = new NEGFeedBackView(this.mPageContext);
        this.bHl.a((ViewGroup) this.bHK.getParent(), com.baidu.adp.lib.util.l.e(this.mContext, d.e.tbds120), 0);
        if (this.bGZ.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bGZ.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.bGZ.setLayoutParams(layoutParams);
        }
        this.ctT = view.findViewById(d.g.divider_line);
        this.bGZ.setOnClickListener(this.ctV);
        this.bGZ.setReplyTimeVisible(false);
        this.bGZ.setShowPraiseNum(true);
        this.bGZ.setNeedAddPraiseIcon(true);
        this.bGZ.setNeedAddReplyIcon(true);
        this.bGZ.setShareVisible(true);
        this.bGZ.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (c.this.aia() != null) {
                    c.this.aia().a(view2, c.this.ctU);
                }
                if (c.this.ctU != null && c.this.ctU.threadData != null) {
                    o.kY(c.this.ctU.threadData.getId());
                    if (!c.this.aie()) {
                        c.this.aif();
                    }
                }
            }
        });
        this.bHN = (ThreadSourceShareAndPraiseLayout) view.findViewById(d.g.card_link_thread_source_read_share_layout);
        this.bHN.ayE.setOnClickListener(this.ctV);
        this.bHN.setShareReportFrom(3);
        this.bHN.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (c.this.aia() != null) {
                    c.this.aia().a(view2, c.this.ctU);
                }
                if (c.this.ctU != null && c.this.ctU.threadData != null && view2 != c.this.bHN.ayD) {
                    o.kY(c.this.ctU.threadData.getId());
                    if (!c.this.aie()) {
                        c.this.aif();
                    }
                }
            }
        });
        this.ctS = (ThreadGodReplyLayout) view.findViewById(d.g.card_home_page_god_reply_layout);
        this.ctS.setOnClickListener(this.ctV);
        ae(view);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.i(getView(), d.f.addresslist_item_bg);
            this.bGZ.onChangeSkinType();
            this.ctS.onChangeSkinType();
            this.bGY.onChangeSkinType();
            if (this.bHl != null) {
                this.bHl.onChangeSkinType();
            }
            am.j(this.ctT, d.C0142d.cp_bg_line_c);
            this.bHN.onChangeSkinType();
        }
        this.mSkinType = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.card.data.k kVar) {
        if (kVar == null || kVar.threadData == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        this.ctU = kVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.ctV);
        }
        if (this.bHl != null && this.ctU.SV() != null && kVar.threadData.vw() != null && !StringUtils.isNull(kVar.threadData.vw().getUserId())) {
            if (kVar.threadData.vw().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                this.bHl.setVisibility(8);
            } else {
                this.bHl.setVisibility(0);
                ai aiVar = new ai();
                aiVar.dk(this.ctU.SV().getTid());
                aiVar.setFid(this.ctU.SV().getFid());
                aiVar.a(this.ctU.agZ);
                this.bHl.setData(aiVar);
                this.bHl.setFirstRowSingleColumn(true);
            }
        }
        this.bGY.setData(kVar.threadData);
        this.ctS.setData(kVar.threadData.wI());
        if (!aie() && o.kZ(this.ctU.threadData.getId())) {
            aif();
        }
        this.bGY.setUserAfterClickListener(this.ayi);
        bc SV = kVar.SV();
        if (this.bGY.getHeaderImg() != null) {
            if (this.bGY.getIsSimpleThread()) {
                this.bGY.getHeaderImg().setVisibility(8);
                this.bHK.setVisibility(8);
            } else if (SV.vw() == null || SV.vw().getPendantData() == null || StringUtils.isNull(SV.vw().getPendantData().uh())) {
                this.bHK.setVisibility(8);
                this.bGY.getHeaderImg().setVisibility(0);
                this.bGY.getHeaderImg().setData(SV);
            } else {
                this.bGY.getHeaderImg().setVisibility(4);
                this.bHK.setVisibility(0);
                this.bHK.setData(SV);
            }
        }
        b(kVar);
        hh(gp(1));
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.bHl != null) {
            this.bHl.setUniqueId(bdUniqueId);
        }
        if (this.bGY != null) {
            this.bGY.setPageUniqueId(bdUniqueId);
        }
    }

    public View aic() {
        return this.ctS;
    }

    public void a(NEGFeedBackView.a aVar) {
        if (this.bHl != null) {
            this.bHl.setEventCallback(aVar);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.bGY != null) {
            return this.bGY.aye;
        }
        return null;
    }

    public View aid() {
        if (this.bGY != null) {
            return this.bGY.ayf;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void er(boolean z) {
        if (this.ctU != null && this.ctU.threadData != null) {
            if (!aie()) {
                o.kY(this.ctU.threadData.getId());
                aif();
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(this.ctU.threadData, null, o.vk(), 18003, true, false, false).addLocateParam(this.ctU.aiK());
            addLocateParam.setForumId(String.valueOf(this.ctU.threadData.getFid()));
            addLocateParam.setStartFrom(this.currentPageType);
            if (z) {
                addLocateParam.setJumpGodReply(true);
            }
            this.mPageContext.sendMessage(new CustomMessage(2004001, addLocateParam));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aie() {
        return this.ctU.czG && !this.ctU.aNy;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aif() {
        o.a(this.ctS.getGodReplyContent(), this.ctU.threadData.getId(), d.C0142d.cp_cont_f, d.C0142d.cp_cont_d);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void hh(int i) {
        if (this.ctU != null && this.ctU.threadData != null) {
            if (i == 1) {
                this.bGZ.setVisibility(8);
                this.bHN.setData(this.ctU.threadData);
                this.bGY.showForumNameView(false);
                return;
            }
            this.bGZ.setData(this.ctU.threadData);
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
