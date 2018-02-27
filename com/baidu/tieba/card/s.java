package com.baidu.tieba.card;

import android.text.SpannableStringBuilder;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalCardDetailActivityConfig;
import com.baidu.tbadk.core.atomData.ShareWebActivityConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.ThemeCardInUserData;
import com.baidu.tbadk.core.data.ah;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.data.be;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadSourceShareAndPraiseLayout;
import com.baidu.tbadk.core.view.ThreadUserInfoLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.NEGFeedBack.c;
import com.baidu.tieba.card.OriginalThreadCardView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class s extends a<be> {
    private boolean aYX;
    private final View.OnClickListener bdQ;
    private boolean beD;
    private View cWR;
    private TextView cWS;
    private boolean cWU;
    private View cYJ;
    private TbImageView cYK;
    private be cYL;
    private TbImageView cYM;
    private OriginalThreadCardView.a cYN;
    public OriginalThreadCardView cYq;
    public ThreadUserInfoLayout clW;
    public ThreadCommentAndPraiseInfoLayout clX;
    private HeadPendantClickableView cmI;
    public ThreadSourceShareAndPraiseLayout cmL;
    private com.baidu.tieba.NEGFeedBack.c cmj;
    private TbPageContext<?> mPageContext;
    private TextView mTitle;

    public s(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.cmj = null;
        this.aYX = true;
        this.cWU = true;
        this.bdQ = new View.OnClickListener() { // from class: com.baidu.tieba.card.s.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (s.this.akO() != null) {
                    s.this.akO().a(view, s.this.cYL);
                }
            }
        };
        this.cYN = new OriginalThreadCardView.a() { // from class: com.baidu.tieba.card.s.6
            @Override // com.baidu.tieba.card.OriginalThreadCardView.a
            public void a(OriginalThreadInfo originalThreadInfo) {
                if (s.this.cYL != null && s.this.cYL.threadData != null) {
                    if (s.this.akO() != null) {
                        s.this.akO().a(s.this.cYq, s.this.cYL);
                    }
                    String id = s.this.cYL.threadData.getId();
                    j.kr(id);
                    s.this.ku(id);
                }
            }
        };
        this.mPageContext = tbPageContext;
        View view = getView();
        this.cmI = (HeadPendantClickableView) view.findViewById(d.g.thread_user_pendant_header);
        if (this.cmI.getHeadView() != null) {
            this.cmI.getHeadView().setIsRound(true);
            this.cmI.getHeadView().setDrawBorder(false);
            this.cmI.getHeadView().setDefaultResource(17170445);
            this.cmI.getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
            this.cmI.getHeadView().setDefaultBgResource(d.C0141d.cp_bg_line_e);
            this.cmI.getHeadView().setRadius(com.baidu.adp.lib.util.l.t(this.mPageContext.getPageActivity(), d.e.ds70));
        }
        this.cmI.DS();
        if (this.cmI.getPendantView() != null) {
            this.cmI.getPendantView().setIsRound(true);
            this.cmI.getPendantView().setDrawBorder(false);
        }
        this.clW = (ThreadUserInfoLayout) view.findViewById(d.g.thread_user_info_layout);
        this.cmj = new com.baidu.tieba.NEGFeedBack.c(this.mPageContext);
        this.cmj.a((ViewGroup) getView(), com.baidu.adp.lib.util.l.t(this.mContext, d.e.tbds92), com.baidu.adp.lib.util.l.t(getContext(), d.e.tbds16));
        this.mTitle = (TextView) view.findViewById(d.g.thread_title);
        this.cWS = (TextView) view.findViewById(d.g.thread_abstract);
        this.cYq = (OriginalThreadCardView) view.findViewById(d.g.original_thread_view);
        this.cYq.setSubClickListener(this.cYN);
        this.clX = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.thread_comment_layout);
        if (this.clX.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.clX.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.clX.setLayoutParams(layoutParams);
        }
        view.setOnClickListener(this);
        this.clX.setOnClickListener(this);
        this.clX.setReplyTimeVisible(false);
        this.clX.setShowPraiseNum(true);
        this.clX.setNeedAddPraiseIcon(true);
        this.clX.setNeedAddReplyIcon(true);
        this.clX.setShareVisible(true);
        this.clX.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.s.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (s.this.akO() != null) {
                    s.this.akO().a(view2, s.this.cYL);
                }
                if (s.this.cYL != null && s.this.cYL.threadData != null) {
                    j.kr(s.this.cYL.threadData.getId());
                    s.this.ku(s.this.cYL.threadData.getId());
                }
            }
        });
        this.cmL = (ThreadSourceShareAndPraiseLayout) view.findViewById(d.g.card_transmit_source_read_share_layout);
        this.cmL.bem.setOnClickListener(this);
        this.cmL.bem.setNeedAddReplyIcon(true);
        this.cmL.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.s.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (s.this.akO() != null) {
                    s.this.akO().a(view2, s.this.cYL);
                }
                if (view2 != s.this.cmL.bel && s.this.cYL != null && s.this.cYL.threadData != null) {
                    j.kr(s.this.cYL.threadData.getId());
                    s.this.ku(s.this.cYL.threadData.getId());
                }
            }
        });
        this.cWR = view.findViewById(d.g.divider_line_above_praise);
        this.cYJ = view.findViewById(d.g.card_divider_line);
        this.cYK = (TbImageView) view.findViewById(d.g.thread_theme_card);
        this.cYM = (TbImageView) view.findViewById(d.g.frs_normal_item_star_view);
    }

    private void H(final bd bdVar) {
        if (this.cYM != null) {
            if (this.cYK == null || bdVar == null) {
                this.cYM.setVisibility(8);
            } else if (!StringUtils.isNull(bdVar.aQm) && this.cYK.getVisibility() != 0) {
                if (this.cmj != null && this.cmj.getVisibility() == 0 && (this.cYM.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.cYM.getLayoutParams();
                    layoutParams.rightMargin = com.baidu.adp.lib.util.l.t(this.mPageContext.getPageActivity(), d.e.tbds106);
                    this.cYM.setLayoutParams(layoutParams);
                }
                this.cYM.setVisibility(0);
                this.cYM.setImageDrawable(null);
                this.cYM.startLoad(bdVar.aQm, 10, false);
                this.cYM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.s.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (s.this.mPageContext != null) {
                            s.this.mTbPageContext.sendMessage(new CustomMessage(2002001, new ShareWebActivityConfig(s.this.mTbPageContext.getContext(), "", bdVar.aQn, true)));
                        }
                        TiebaStatic.log(new ak("c12883"));
                    }
                });
            } else {
                this.cYM.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.s(getView(), d.f.addresslist_item_bg);
            aj.t(this.cWR, d.C0141d.cp_bg_line_e);
            this.clX.onChangeSkinType();
            this.clW.onChangeSkinType();
            if (this.cmj != null) {
                this.cmj.onChangeSkinType();
            }
            this.cYq.onChangeSkinType();
            aj.t(this.cYJ, d.C0141d.cp_bg_line_e);
            this.cmL.onChangeSkinType();
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.card_transmit_thread_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(be beVar) {
        if (beVar == null || beVar.threadData == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        if (getView() != null) {
            getView().setVisibility(0);
        }
        this.cYL = beVar;
        bd bdVar = beVar.threadData;
        if (this.cmj != null) {
            SparseArray<String> yo = bdVar.yo();
            if (yo != null && yo.size() > 0 && this.cWU) {
                ah ahVar = new ah();
                ahVar.cV(bdVar.getTid());
                ahVar.setFid(bdVar.getFid());
                ahVar.a(yo);
                this.cmj.setData(ahVar);
                this.cmj.setFirstRowSingleColumn(true);
                this.cmj.setVisibility(J(bdVar) ? 8 : 0);
            } else {
                this.cmj.setVisibility(8);
            }
        }
        if (this.cYL.aQs == 1) {
            this.clW.setFrom(3);
            K(bdVar);
            H(bdVar);
        }
        this.clW.setIsFromConcern(this.beD);
        this.clW.setData(bdVar);
        this.clW.setUserAfterClickListener(this.bdQ);
        if (this.clW.getHeaderImg() != null) {
            if (this.clW.getIsSimpleThread()) {
                this.clW.getHeaderImg().setVisibility(8);
                this.cmI.setVisibility(8);
            } else if (bdVar.zn() == null || bdVar.zn().getPendantData() == null || StringUtils.isNull(bdVar.zn().getPendantData().ya())) {
                this.cmI.setVisibility(8);
                this.clW.getHeaderImg().setVisibility(0);
                this.clW.getHeaderImg().setData(bdVar);
            } else {
                this.clW.getHeaderImg().setVisibility(4);
                this.cmI.setVisibility(0);
                this.cmI.setData(bdVar);
            }
        }
        I(bdVar);
        this.cYq.b(bdVar.aQl);
        jX(bdVar.aQo);
        setPageUniqueId(getTag());
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        ku(bdVar.getId());
    }

    private void I(bd bdVar) {
        if (bdVar != null) {
            SpannableStringBuilder j = bdVar.j(false, true);
            if (j == null || StringUtils.isNull(j.toString())) {
                this.mTitle.setVisibility(8);
                return;
            }
            this.mTitle.setVisibility(0);
            this.mTitle.setOnTouchListener(new com.baidu.tieba.view.m(j));
            this.mTitle.setText(j);
            j.a(this.mTitle, bdVar.getId(), d.C0141d.cp_cont_b, d.C0141d.cp_cont_d);
        }
    }

    private boolean J(bd bdVar) {
        if (bdVar == null || bdVar.zn() == null || StringUtils.isNull(bdVar.zn().getUserId())) {
            return false;
        }
        return bdVar.zn().getUserId().equals(TbadkCoreApplication.getCurrentAccount());
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.cmj != null) {
            this.cmj.setUniqueId(bdUniqueId);
        }
        if (this.clW != null) {
            this.clW.setPageUniqueId(bdUniqueId);
        }
    }

    public void a(c.a aVar) {
        if (this.cmj != null) {
            this.cmj.setEventCallback(aVar);
        }
    }

    public ThreadCommentAndPraiseInfoLayout alt() {
        return this.clX;
    }

    public ThreadCommentAndPraiseInfoLayout alu() {
        return this.cmL.bem;
    }

    public void eP(boolean z) {
        if (this.cYJ != null) {
            this.cYJ.setVisibility(z ? 0 : 8);
        }
    }

    public void eL(boolean z) {
        this.cWU = z;
    }

    public void setIsFromConcern(boolean z) {
        this.beD = z;
    }

    private void ali() {
        if (this.cYL != null && this.cYL.threadData != null) {
            bd bdVar = this.cYL.threadData;
            j.kr(bdVar.getId());
            ku(bdVar.getId());
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(bdVar, null, this.cYL.stType, 18003, true, false, false);
            createFromThreadCfg.setForumId(String.valueOf(bdVar.getFid()));
            createFromThreadCfg.setForumName(bdVar.zt());
            createFromThreadCfg.setStartFrom(this.currentPageType);
            createFromThreadCfg.setIsShareThread(true);
            j.kr(bdVar.getTid());
            this.mPageContext.sendMessage(new CustomMessage(2004001, createFromThreadCfg));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ku(String str) {
        j.a(this.mTitle, str, d.C0141d.cp_cont_b, d.C0141d.cp_cont_d);
        j.a(this.cWS, str, d.C0141d.cp_cont_b, d.C0141d.cp_cont_d);
        this.cYq.setReadState(j.ks(str));
    }

    public void K(bd bdVar) {
        MetaData zn;
        if (bdVar != null && this.cYK != null && (zn = bdVar.zn()) != null) {
            final ThemeCardInUserData themeCard = zn.getThemeCard();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                this.cYK.setVisibility(8);
                return;
            }
            this.cYK.setVisibility(0);
            this.cYK.setImageBitmap(null);
            this.cYK.startLoad(themeCard.getCardImageUrlAndroid(), 10, false);
            this.cYK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.s.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonalCardDetailActivityConfig(s.this.mPageContext.getPageActivity(), themeCard.getCardId())));
                }
            });
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (akO() != null) {
            akO().a(view, this.cYL);
        }
        if (view == getView()) {
            ali();
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.clW != null) {
            return this.clW.bdL;
        }
        return null;
    }

    public View akR() {
        if (this.clW != null) {
            return this.clW.bdM;
        }
        return null;
    }

    public void jX(int i) {
        if (this.cYL != null && this.cYL.threadData != null) {
            if (i == 1) {
                this.clX.setVisibility(8);
                this.cmL.setFrom(this.cYL.aQr);
                this.cmL.setShareReportFrom(this.cYL.aQs);
                this.cmL.setStType(this.cYL.stType);
                this.cmL.setData(this.cYL.threadData);
                this.clW.showForumNameView(false);
                return;
            }
            this.clX.setFrom(this.cYL.aQr);
            this.clX.setShareReportFrom(this.cYL.aQs);
            this.clX.setStType(this.cYL.stType);
            this.clX.setData(this.cYL.threadData);
            this.cmL.setVisibility(8);
            this.clW.showForumNameView(true);
        }
    }
}
