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
    private boolean aYZ;
    private final View.OnClickListener bdT;
    private boolean beG;
    private View cWU;
    private TextView cWV;
    private boolean cWX;
    private View cYM;
    private TbImageView cYN;
    private be cYO;
    private TbImageView cYP;
    private OriginalThreadCardView.a cYQ;
    public OriginalThreadCardView cYt;
    public ThreadUserInfoLayout clZ;
    private HeadPendantClickableView cmL;
    public ThreadSourceShareAndPraiseLayout cmO;
    public ThreadCommentAndPraiseInfoLayout cma;
    private com.baidu.tieba.NEGFeedBack.c cmm;
    private TbPageContext<?> mPageContext;
    private TextView mTitle;

    public s(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.cmm = null;
        this.aYZ = true;
        this.cWX = true;
        this.bdT = new View.OnClickListener() { // from class: com.baidu.tieba.card.s.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (s.this.akP() != null) {
                    s.this.akP().a(view, s.this.cYO);
                }
            }
        };
        this.cYQ = new OriginalThreadCardView.a() { // from class: com.baidu.tieba.card.s.6
            @Override // com.baidu.tieba.card.OriginalThreadCardView.a
            public void a(OriginalThreadInfo originalThreadInfo) {
                if (s.this.cYO != null && s.this.cYO.threadData != null) {
                    if (s.this.akP() != null) {
                        s.this.akP().a(s.this.cYt, s.this.cYO);
                    }
                    String id = s.this.cYO.threadData.getId();
                    j.kr(id);
                    s.this.ku(id);
                }
            }
        };
        this.mPageContext = tbPageContext;
        View view = getView();
        this.cmL = (HeadPendantClickableView) view.findViewById(d.g.thread_user_pendant_header);
        if (this.cmL.getHeadView() != null) {
            this.cmL.getHeadView().setIsRound(true);
            this.cmL.getHeadView().setDrawBorder(false);
            this.cmL.getHeadView().setDefaultResource(17170445);
            this.cmL.getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
            this.cmL.getHeadView().setDefaultBgResource(d.C0141d.cp_bg_line_e);
            this.cmL.getHeadView().setRadius(com.baidu.adp.lib.util.l.t(this.mPageContext.getPageActivity(), d.e.ds70));
        }
        this.cmL.DT();
        if (this.cmL.getPendantView() != null) {
            this.cmL.getPendantView().setIsRound(true);
            this.cmL.getPendantView().setDrawBorder(false);
        }
        this.clZ = (ThreadUserInfoLayout) view.findViewById(d.g.thread_user_info_layout);
        this.cmm = new com.baidu.tieba.NEGFeedBack.c(this.mPageContext);
        this.cmm.a((ViewGroup) getView(), com.baidu.adp.lib.util.l.t(this.mContext, d.e.tbds92), com.baidu.adp.lib.util.l.t(getContext(), d.e.tbds16));
        this.mTitle = (TextView) view.findViewById(d.g.thread_title);
        this.cWV = (TextView) view.findViewById(d.g.thread_abstract);
        this.cYt = (OriginalThreadCardView) view.findViewById(d.g.original_thread_view);
        this.cYt.setSubClickListener(this.cYQ);
        this.cma = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.thread_comment_layout);
        if (this.cma.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cma.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.cma.setLayoutParams(layoutParams);
        }
        view.setOnClickListener(this);
        this.cma.setOnClickListener(this);
        this.cma.setReplyTimeVisible(false);
        this.cma.setShowPraiseNum(true);
        this.cma.setNeedAddPraiseIcon(true);
        this.cma.setNeedAddReplyIcon(true);
        this.cma.setShareVisible(true);
        this.cma.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.s.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (s.this.akP() != null) {
                    s.this.akP().a(view2, s.this.cYO);
                }
                if (s.this.cYO != null && s.this.cYO.threadData != null) {
                    j.kr(s.this.cYO.threadData.getId());
                    s.this.ku(s.this.cYO.threadData.getId());
                }
            }
        });
        this.cmO = (ThreadSourceShareAndPraiseLayout) view.findViewById(d.g.card_transmit_source_read_share_layout);
        this.cmO.bep.setOnClickListener(this);
        this.cmO.bep.setNeedAddReplyIcon(true);
        this.cmO.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.s.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (s.this.akP() != null) {
                    s.this.akP().a(view2, s.this.cYO);
                }
                if (view2 != s.this.cmO.beo && s.this.cYO != null && s.this.cYO.threadData != null) {
                    j.kr(s.this.cYO.threadData.getId());
                    s.this.ku(s.this.cYO.threadData.getId());
                }
            }
        });
        this.cWU = view.findViewById(d.g.divider_line_above_praise);
        this.cYM = view.findViewById(d.g.card_divider_line);
        this.cYN = (TbImageView) view.findViewById(d.g.thread_theme_card);
        this.cYP = (TbImageView) view.findViewById(d.g.frs_normal_item_star_view);
    }

    private void H(final bd bdVar) {
        if (this.cYP != null) {
            if (this.cYN == null || bdVar == null) {
                this.cYP.setVisibility(8);
            } else if (!StringUtils.isNull(bdVar.aQn) && this.cYN.getVisibility() != 0) {
                if (this.cmm != null && this.cmm.getVisibility() == 0 && (this.cYP.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.cYP.getLayoutParams();
                    layoutParams.rightMargin = com.baidu.adp.lib.util.l.t(this.mPageContext.getPageActivity(), d.e.tbds106);
                    this.cYP.setLayoutParams(layoutParams);
                }
                this.cYP.setVisibility(0);
                this.cYP.changeGrayScaleMode(bdVar.AC());
                this.cYP.setImageDrawable(null);
                this.cYP.startLoad(bdVar.aQn, 10, false);
                this.cYP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.s.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (s.this.mPageContext != null && !StringUtils.isNull(bdVar.aQo)) {
                            s.this.mTbPageContext.sendMessage(new CustomMessage(2002001, new ShareWebActivityConfig(s.this.mTbPageContext.getContext(), "", bdVar.aQo, true)));
                        }
                        TiebaStatic.log(new ak("c12883"));
                    }
                });
            } else {
                this.cYP.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.s(getView(), d.f.addresslist_item_bg);
            aj.t(this.cWU, d.C0141d.cp_bg_line_e);
            this.cma.onChangeSkinType();
            this.clZ.onChangeSkinType();
            if (this.cmm != null) {
                this.cmm.onChangeSkinType();
            }
            this.cYt.onChangeSkinType();
            aj.t(this.cYM, d.C0141d.cp_bg_line_e);
            this.cmO.onChangeSkinType();
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
        this.cYO = beVar;
        bd bdVar = beVar.threadData;
        if (this.cmm != null) {
            SparseArray<String> yo = bdVar.yo();
            if (yo != null && yo.size() > 0 && this.cWX) {
                ah ahVar = new ah();
                ahVar.cV(bdVar.getTid());
                ahVar.setFid(bdVar.getFid());
                ahVar.a(yo);
                this.cmm.setData(ahVar);
                this.cmm.setFirstRowSingleColumn(true);
                this.cmm.setVisibility(J(bdVar) ? 8 : 0);
            } else {
                this.cmm.setVisibility(8);
            }
        }
        if (this.cYO.aQu == 1) {
            this.clZ.setFrom(3);
            K(bdVar);
            H(bdVar);
        }
        this.clZ.setIsFromConcern(this.beG);
        this.clZ.setData(bdVar);
        this.clZ.setUserAfterClickListener(this.bdT);
        if (this.clZ.getHeaderImg() != null) {
            if (this.clZ.getIsSimpleThread()) {
                this.clZ.getHeaderImg().setVisibility(8);
                this.cmL.setVisibility(8);
            } else if (bdVar.zn() == null || bdVar.zn().getPendantData() == null || StringUtils.isNull(bdVar.zn().getPendantData().ya())) {
                this.cmL.setVisibility(8);
                this.clZ.getHeaderImg().setVisibility(0);
                this.clZ.getHeaderImg().setData(bdVar);
            } else {
                this.clZ.getHeaderImg().setVisibility(4);
                this.cmL.setVisibility(0);
                this.cmL.setData(bdVar);
            }
        }
        I(bdVar);
        this.cYt.getThreadImage().changeGrayScaleMode(bdVar.AC());
        this.cYt.b(bdVar.aQm);
        jX(bdVar.aQp);
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
        if (this.cmm != null) {
            this.cmm.setUniqueId(bdUniqueId);
        }
        if (this.clZ != null) {
            this.clZ.setPageUniqueId(bdUniqueId);
        }
    }

    public void a(c.a aVar) {
        if (this.cmm != null) {
            this.cmm.setEventCallback(aVar);
        }
    }

    public ThreadCommentAndPraiseInfoLayout alu() {
        return this.cma;
    }

    public ThreadCommentAndPraiseInfoLayout alv() {
        return this.cmO.bep;
    }

    public void eP(boolean z) {
        if (this.cYM != null) {
            this.cYM.setVisibility(z ? 0 : 8);
        }
    }

    public void eL(boolean z) {
        this.cWX = z;
    }

    public void setIsFromConcern(boolean z) {
        this.beG = z;
    }

    private void alj() {
        if (this.cYO != null && this.cYO.threadData != null) {
            bd bdVar = this.cYO.threadData;
            j.kr(bdVar.getId());
            ku(bdVar.getId());
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(bdVar, null, this.cYO.stType, 18003, true, false, false);
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
        j.a(this.cWV, str, d.C0141d.cp_cont_b, d.C0141d.cp_cont_d);
        this.cYt.setReadState(j.ks(str));
    }

    public void K(bd bdVar) {
        MetaData zn;
        if (bdVar != null && this.cYN != null && (zn = bdVar.zn()) != null) {
            final ThemeCardInUserData themeCard = zn.getThemeCard();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                this.cYN.setVisibility(8);
                return;
            }
            this.cYN.setVisibility(0);
            this.cYN.setImageBitmap(null);
            this.cYN.changeGrayScaleMode(bdVar.AC());
            this.cYN.startLoad(themeCard.getCardImageUrlAndroid(), 10, false);
            this.cYN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.s.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonalCardDetailActivityConfig(s.this.mPageContext.getPageActivity(), themeCard.getCardId())));
                }
            });
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (akP() != null) {
            akP().a(view, this.cYO);
        }
        if (view == getView()) {
            alj();
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.clZ != null) {
            return this.clZ.bdO;
        }
        return null;
    }

    public View akS() {
        if (this.clZ != null) {
            return this.clZ.bdP;
        }
        return null;
    }

    public void jX(int i) {
        if (this.cYO != null && this.cYO.threadData != null) {
            if (i == 1) {
                this.cma.setVisibility(8);
                this.cmO.setFrom(this.cYO.aQt);
                this.cmO.setShareReportFrom(this.cYO.aQu);
                this.cmO.setStType(this.cYO.stType);
                this.cmO.setData(this.cYO.threadData);
                this.clZ.showForumNameView(false);
                return;
            }
            this.cma.setFrom(this.cYO.aQt);
            this.cma.setShareReportFrom(this.cYO.aQu);
            this.cma.setStType(this.cYO.stType);
            this.cma.setData(this.cYO.threadData);
            this.cmO.setVisibility(8);
            this.clZ.showForumNameView(true);
        }
    }
}
