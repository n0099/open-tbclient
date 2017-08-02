package com.baidu.tieba.card;

import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.an;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tbadk.core.view.ThreadUserInfoLayout;
import com.baidu.tbadk.core.view.h;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public abstract class c extends a<com.baidu.tieba.card.data.l> {
    private TbPageContext<?> ako;
    private final View.OnClickListener anD;
    private HeadPendantClickableView bEC;
    private ThreadGodReplyLayout bED;
    private View bEE;
    private com.baidu.tbadk.core.view.h bEF;
    private View bEG;
    protected com.baidu.tieba.card.data.l bEH;
    private View.OnClickListener bEI;
    public ThreadUserInfoLayout bjL;
    public ThreadCommentAndPraiseInfoLayout bjP;
    private int mSkinType;

    protected abstract void U(View view);

    protected abstract void b(com.baidu.tieba.card.data.l lVar);

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bEF = null;
        this.mSkinType = 3;
        this.bEI = new View.OnClickListener() { // from class: com.baidu.tieba.card.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.VZ() != null) {
                    c.this.VZ().a(view, c.this.bEH);
                }
                c.this.dD(view == c.this.bED);
            }
        };
        this.anD = new View.OnClickListener() { // from class: com.baidu.tieba.card.c.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.VZ() != null) {
                    c.this.VZ().a(view, c.this.bEH);
                }
            }
        };
        View view = getView();
        this.ako = tbPageContext;
        this.bEC = (HeadPendantClickableView) view.findViewById(d.h.card_home_page_normal_thread_user_pendant_header);
        if (this.bEC.getHeadView() != null) {
            this.bEC.getHeadView().setIsRound(true);
            this.bEC.getHeadView().setDrawBorder(false);
            this.bEC.getHeadView().setDefaultResource(17170445);
            this.bEC.getHeadView().setDefaultErrorResource(d.g.icon_default_avatar100);
            this.bEC.getHeadView().setDefaultBgResource(d.e.cp_bg_line_e);
            this.bEC.getHeadView().setRadius(com.baidu.adp.lib.util.k.g(this.ako.getPageActivity(), d.f.ds70));
        }
        this.bEC.wt();
        if (this.bEC.getPendantView() != null) {
            this.bEC.getPendantView().setIsRound(true);
            this.bEC.getPendantView().setDrawBorder(false);
        }
        this.bjP = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.h.card_home_page_normal_thread_info_layout);
        this.bjL = (ThreadUserInfoLayout) view.findViewById(d.h.card_home_page_normal_thread_user_info_layout);
        this.bEE = view.findViewById(d.h.divider_below_reply_number_layout);
        this.bEF = new com.baidu.tbadk.core.view.h(this.ako);
        this.bEF.wA();
        this.bEF.setLeftPadding((int) getContext().getResources().getDimension(d.f.ds60));
        this.bjL.addView(this.bEF);
        if (this.bjP.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bjP.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.bjP.setLayoutParams(layoutParams);
        }
        this.bEG = view.findViewById(d.h.divider_line);
        this.bjP.setOnClickListener(this.bEI);
        this.bjP.setReplyTimeVisible(false);
        this.bjP.setShowPraiseNum(true);
        this.bjP.setNeedAddPraiseIcon(true);
        this.bjP.setNeedAddReplyIcon(true);
        this.bjP.setReplyIcon(d.g.icon_home_card_comment_n);
        this.bjP.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (c.this.VZ() != null) {
                    c.this.VZ().a(view2, c.this.bEH);
                }
            }
        });
        this.bED = (ThreadGodReplyLayout) view.findViewById(d.h.card_home_page_god_reply_layout);
        this.bED.setOnClickListener(this.bEI);
        U(view);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ai.j(getView(), d.g.addresslist_item_bg);
            this.bjP.onChangeSkinType();
            this.bED.onChangeSkinType();
            this.bjL.onChangeSkinType();
            if (this.bEF != null) {
                this.bEF.onChangeSkinType();
            }
            ai.k(this.bEG, d.e.cp_bg_line_c);
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
        this.bEH = lVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.bEI);
        }
        if (this.bEF != null && this.bEH.MA() != null && lVar.threadData.getAuthor() != null && !StringUtils.isNull(lVar.threadData.getAuthor().getUserId())) {
            if (lVar.threadData.getAuthor().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                this.bEF.setVisibility(8);
            } else {
                this.bEF.setVisibility(0);
                an anVar = new an();
                anVar.cz(this.bEH.MA().getTid());
                anVar.setFid(this.bEH.MA().getFid());
                anVar.a(this.bEH.Wx);
                this.bEF.setData(anVar);
                this.bEF.setFirstRowSingleColumn(true);
            }
        }
        this.bjL.a(lVar.threadData);
        this.bED.setData(lVar.threadData.sK());
        if (!Wd() && m.iZ(this.bEH.threadData.getId())) {
            We();
        }
        this.bjL.setUserAfterClickListener(this.anD);
        this.bjP.a(lVar.threadData);
        this.bEE.setVisibility(0);
        bl MA = lVar.MA();
        if (this.bjL.getHeaderImg() != null) {
            if (this.bjL.getIsSimpleThread()) {
                this.bjL.getHeaderImg().setVisibility(8);
                this.bEC.setVisibility(8);
            } else if (MA.getAuthor() == null || MA.getAuthor().getPendantData() == null || StringUtils.isNull(MA.getAuthor().getPendantData().pL())) {
                this.bEC.setVisibility(8);
                this.bjL.getHeaderImg().setVisibility(0);
                this.bjL.getHeaderImg().setData(MA);
            } else {
                this.bjL.getHeaderImg().setVisibility(4);
                this.bEC.setVisibility(0);
                this.bEC.setData(MA);
            }
        }
        b(lVar);
        d(this.ako, TbadkCoreApplication.getInst().getSkinType());
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.bEF != null) {
            this.bEF.setUniqueId(bdUniqueId);
        }
        if (this.bjL != null) {
            this.bjL.setPageUniqueId(bdUniqueId);
        }
    }

    public View Wb() {
        return this.bED;
    }

    public void a(h.a aVar) {
        if (this.bEF != null) {
            this.bEF.setEventCallback(aVar);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.bjL != null) {
            return this.bjL.any;
        }
        return null;
    }

    public View Wc() {
        if (this.bjL != null) {
            return this.bjL.anz;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dD(boolean z) {
        if (this.bEH != null && this.bEH.threadData != null) {
            if (!Wd()) {
                m.iY(this.bEH.threadData.getId());
                We();
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.ako.getPageActivity()).createFromThreadCfg(this.bEH.threadData, null, m.rm(), 18003, true, false, false).addLocateParam(this.bEH.WB());
            addLocateParam.setForumId(String.valueOf(this.bEH.threadData.getFid()));
            if (this.bEH.bIg == 0) {
                addLocateParam.setStartFrom(2);
            } else {
                addLocateParam.setStartFrom(this.bEH.bIg);
            }
            if (z) {
                addLocateParam.setJumpGodReply(true);
            }
            this.ako.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
        }
    }

    private boolean Wd() {
        return this.bEH.bIy && !this.bEH.aCd;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void We() {
        m.a(this.bED.getGodReplyContent(), this.bEH.threadData.getId(), d.e.cp_cont_f, d.e.cp_cont_d);
        m.a(this.bED.getPraiseNum(), this.bEH.threadData.getId(), d.e.cp_cont_f, d.e.cp_cont_d);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
