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
import com.baidu.tbadk.core.data.ai;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.data.be;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadSourceShareAndPraiseLayout;
import com.baidu.tbadk.core.view.ThreadUserInfoLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.card.OriginalThreadCardView;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class x extends a<be> implements com.baidu.tieba.a.e {
    private String abd;
    private boolean akC;
    private boolean apW;
    private final View.OnClickListener apj;
    private String bwO;
    private HeadPendantClickableView bxM;
    public ThreadSourceShareAndPraiseLayout bxQ;
    public ThreadUserInfoLayout bxa;
    public ThreadCommentAndPraiseInfoLayout bxb;
    private NEGFeedBackView bxn;
    private View cqc;
    private TextView cqd;
    private boolean cqf;
    private View crK;
    private TbImageView crL;
    private be crM;
    private TbImageView crN;
    private OriginalThreadCardView.a crO;
    public OriginalThreadCardView crr;
    private TbPageContext<?> mPageContext;
    private TextView mTitle;
    private String mUrl;

    public x(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bxn = null;
        this.akC = true;
        this.cqf = true;
        this.apj = new View.OnClickListener() { // from class: com.baidu.tieba.card.x.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (x.this.aeZ() != null) {
                    x.this.aeZ().a(view2, x.this.crM);
                }
            }
        };
        this.crO = new OriginalThreadCardView.a() { // from class: com.baidu.tieba.card.x.6
            @Override // com.baidu.tieba.card.OriginalThreadCardView.a
            public void a(OriginalThreadInfo originalThreadInfo) {
                if (x.this.crM != null && x.this.crM.threadData != null) {
                    if (x.this.aeZ() != null) {
                        x.this.aeZ().a(x.this.crr, x.this.crM);
                    }
                    String id = x.this.crM.threadData.getId();
                    o.ky(id);
                    x.this.kA(id);
                }
            }
        };
        this.mPageContext = tbPageContext;
        View view2 = getView();
        this.bxM = (HeadPendantClickableView) view2.findViewById(d.g.thread_user_pendant_header);
        if (this.bxM.getHeadView() != null) {
            this.bxM.getHeadView().setIsRound(true);
            this.bxM.getHeadView().setDrawBorder(false);
            this.bxM.getHeadView().setDefaultResource(17170445);
            this.bxM.getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
            this.bxM.getHeadView().setDefaultBgResource(d.C0126d.cp_bg_line_e);
            this.bxM.getHeadView().setRadius(com.baidu.adp.lib.util.l.e(this.mPageContext.getPageActivity(), d.e.ds70));
        }
        this.bxM.setHasPendantStyle();
        if (this.bxM.getPendantView() != null) {
            this.bxM.getPendantView().setIsRound(true);
            this.bxM.getPendantView().setDrawBorder(false);
        }
        this.bxa = (ThreadUserInfoLayout) view2.findViewById(d.g.thread_user_info_layout);
        this.bxn = new NEGFeedBackView(this.mPageContext);
        this.bxn.a((ViewGroup) getView(), com.baidu.adp.lib.util.l.e(this.mContext, d.e.tbds92), com.baidu.adp.lib.util.l.e(getContext(), d.e.tbds16));
        this.mTitle = (TextView) view2.findViewById(d.g.thread_title);
        this.cqd = (TextView) view2.findViewById(d.g.thread_abstract);
        this.crr = (OriginalThreadCardView) view2.findViewById(d.g.original_thread_view);
        this.crr.setSubClickListener(this.crO);
        this.bxb = (ThreadCommentAndPraiseInfoLayout) view2.findViewById(d.g.thread_comment_layout);
        if (this.bxb.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bxb.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.bxb.setLayoutParams(layoutParams);
        }
        view2.setOnClickListener(this);
        this.bxb.setOnClickListener(this);
        this.bxb.setReplyTimeVisible(false);
        this.bxb.setShowPraiseNum(true);
        this.bxb.setNeedAddPraiseIcon(true);
        this.bxb.setNeedAddReplyIcon(true);
        this.bxb.setShareVisible(true);
        this.bxb.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.x.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view3) {
                if (x.this.aeZ() != null) {
                    x.this.aeZ().a(view3, x.this.crM);
                }
                if (x.this.crM != null && x.this.crM.threadData != null) {
                    o.ky(x.this.crM.threadData.getId());
                    x.this.kA(x.this.crM.threadData.getId());
                }
            }
        });
        this.bxQ = (ThreadSourceShareAndPraiseLayout) view2.findViewById(d.g.card_transmit_source_read_share_layout);
        this.bxQ.apG.setOnClickListener(this);
        this.bxQ.apG.setNeedAddReplyIcon(true);
        this.bxQ.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.x.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view3) {
                if (x.this.aeZ() != null) {
                    x.this.aeZ().a(view3, x.this.crM);
                }
                if (view3 != x.this.bxQ.apF && x.this.crM != null && x.this.crM.threadData != null) {
                    o.ky(x.this.crM.threadData.getId());
                    x.this.kA(x.this.crM.threadData.getId());
                }
            }
        });
        this.cqc = view2.findViewById(d.g.divider_line_above_praise);
        this.crK = view2.findViewById(d.g.card_divider_line);
        this.crL = (TbImageView) view2.findViewById(d.g.thread_theme_card);
        this.crN = (TbImageView) view2.findViewById(d.g.frs_normal_item_star_view);
    }

    private void I(final bd bdVar) {
        if (this.crN != null) {
            if (this.crL == null || bdVar == null) {
                this.crN.setVisibility(8);
            } else if (!StringUtils.isNull(bdVar.abN) && this.crL.getVisibility() != 0) {
                if (this.bxn != null && this.bxn.getVisibility() == 0 && (this.crN.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.crN.getLayoutParams();
                    layoutParams.rightMargin = com.baidu.adp.lib.util.l.e(this.mPageContext.getPageActivity(), d.e.tbds106);
                    this.crN.setLayoutParams(layoutParams);
                }
                this.crN.setVisibility(0);
                this.crN.setImageDrawable(null);
                this.crN.startLoad(bdVar.abN, 10, false);
                this.crN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.x.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (x.this.mPageContext != null) {
                            x.this.mTbPageContext.sendMessage(new CustomMessage(2002001, new ShareWebActivityConfig(x.this.mTbPageContext.getContext(), "", bdVar.abO, true)));
                        }
                        TiebaStatic.log(new al("c12883"));
                    }
                });
            } else {
                this.crN.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ak.i(getView(), d.f.addresslist_item_bg);
            ak.j(this.cqc, d.C0126d.cp_bg_line_e);
            this.bxb.onChangeSkinType();
            this.bxa.onChangeSkinType();
            if (this.bxn != null) {
                this.bxn.onChangeSkinType();
            }
            this.crr.onChangeSkinType();
            ak.j(this.crK, d.C0126d.cp_bg_line_e);
            this.bxQ.onChangeSkinType();
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.i.card_transmit_thread_view;
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
        this.crM = beVar;
        bd bdVar = beVar.threadData;
        if (this.bxn != null) {
            SparseArray<String> qT = bdVar.qT();
            if (qT != null && qT.size() > 0 && this.cqf) {
                ai aiVar = new ai();
                aiVar.cJ(bdVar.getTid());
                aiVar.setFid(bdVar.getFid());
                aiVar.a(qT);
                this.bxn.setData(aiVar);
                this.bxn.setFirstRowSingleColumn(true);
                this.bxn.setVisibility(K(bdVar) ? 8 : 0);
            } else {
                this.bxn.setVisibility(8);
            }
        }
        if (this.crM.abV == 1) {
            this.bxa.setFrom(3);
            L(bdVar);
            I(bdVar);
        }
        this.bxa.setIsFromConcern(this.apW);
        this.bxa.setData(bdVar);
        this.bxa.setUserAfterClickListener(this.apj);
        if (this.bxa.getHeaderImg() != null) {
            if (this.bxa.getIsSimpleThread()) {
                this.bxa.getHeaderImg().setVisibility(8);
                this.bxM.setVisibility(8);
            } else if (bdVar.rP() == null || bdVar.rP().getPendantData() == null || StringUtils.isNull(bdVar.rP().getPendantData().qF())) {
                this.bxM.setVisibility(8);
                this.bxa.getHeaderImg().setVisibility(0);
                this.bxa.getHeaderImg().setData(bdVar);
            } else {
                this.bxa.getHeaderImg().setVisibility(4);
                this.bxM.setVisibility(0);
                this.bxM.setData(bdVar);
            }
        }
        J(bdVar);
        this.crr.b(bdVar.abM);
        hc(gn(1));
        setPageUniqueId(getTag());
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        kA(bdVar.getId());
    }

    private void J(bd bdVar) {
        if (bdVar != null) {
            if (!StringUtils.isNull(this.mUrl) && !StringUtils.isNull(this.abd)) {
                bdVar.M(this.mUrl, this.abd);
            }
            SpannableStringBuilder g = bdVar.g(false, true);
            if (g == null || StringUtils.isNull(g.toString())) {
                this.mTitle.setVisibility(8);
                return;
            }
            this.mTitle.setVisibility(0);
            this.mTitle.setOnTouchListener(new com.baidu.tieba.view.j(g));
            this.mTitle.setText(g);
            o.a(this.mTitle, bdVar.getId(), d.C0126d.cp_cont_b, d.C0126d.cp_cont_d);
        }
    }

    private boolean K(bd bdVar) {
        if (bdVar == null || bdVar.rP() == null || StringUtils.isNull(bdVar.rP().getUserId())) {
            return false;
        }
        return bdVar.rP().getUserId().equals(TbadkCoreApplication.getCurrentAccount());
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.bxn != null) {
            this.bxn.setUniqueId(bdUniqueId);
        }
        if (this.bxa != null) {
            this.bxa.setPageUniqueId(bdUniqueId);
        }
    }

    public void a(NEGFeedBackView.a aVar) {
        if (this.bxn != null) {
            this.bxn.setEventCallback(aVar);
        }
    }

    public ThreadCommentAndPraiseInfoLayout afz() {
        return this.bxb;
    }

    public ThreadCommentAndPraiseInfoLayout afA() {
        return this.bxQ.apG;
    }

    public void ev(boolean z) {
        if (this.crK != null) {
            this.crK.setVisibility(z ? 0 : 8);
        }
    }

    public void er(boolean z) {
        this.cqf = z;
    }

    public void setIsFromConcern(boolean z) {
        this.apW = z;
    }

    private void afs() {
        if (this.crM != null && this.crM.threadData != null) {
            bd bdVar = this.crM.threadData;
            o.ky(bdVar.getId());
            kA(bdVar.getId());
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(bdVar, null, this.crM.stType, 18003, true, false, false);
            createFromThreadCfg.setForumId(String.valueOf(bdVar.getFid()));
            createFromThreadCfg.setForumName(bdVar.rU());
            createFromThreadCfg.setStartFrom(this.currentPageType);
            createFromThreadCfg.setIsShareThread(true);
            o.ky(bdVar.getTid());
            this.mPageContext.sendMessage(new CustomMessage(2004001, createFromThreadCfg));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kA(String str) {
        o.a(this.mTitle, str, d.C0126d.cp_cont_b, d.C0126d.cp_cont_d);
        o.a(this.cqd, str, d.C0126d.cp_cont_b, d.C0126d.cp_cont_d);
        this.crr.setReadState(o.kz(str));
    }

    public void L(bd bdVar) {
        MetaData rP;
        if (bdVar != null && this.crL != null && (rP = bdVar.rP()) != null) {
            final ThemeCardInUserData themeCard = rP.getThemeCard();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                this.crL.setVisibility(8);
                return;
            }
            this.crL.setVisibility(0);
            this.crL.setImageBitmap(null);
            this.crL.startLoad(themeCard.getCardImageUrlAndroid(), 10, false);
            this.crL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.x.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonalCardDetailActivityConfig(x.this.mPageContext.getPageActivity(), themeCard.getCardId())));
                }
            });
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        if (aeZ() != null) {
            aeZ().a(view2, this.crM);
        }
        if (view2 == getView()) {
            afs();
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.bxa != null) {
            return this.bxa.apf;
        }
        return null;
    }

    public View afc() {
        if (this.bxa != null) {
            return this.bxa.apg;
        }
        return null;
    }

    public void hc(int i) {
        if (this.crM != null && this.crM.threadData != null) {
            if (i == 1) {
                this.bxb.setVisibility(8);
                this.bxQ.setFrom(this.crM.abU);
                this.bxQ.setShareReportFrom(this.crM.abV);
                this.bxQ.setStType(this.crM.stType);
                this.bxQ.setData(this.crM.threadData);
                this.bxa.showForumNameView(false);
                return;
            }
            this.bxb.setFrom(this.crM.abU);
            this.bxb.setShareReportFrom(this.crM.abV);
            this.bxb.setStType(this.crM.stType);
            this.bxb.setData(this.crM.threadData);
            this.bxQ.setVisibility(8);
            this.bxa.showForumNameView(true);
        }
    }

    public void M(String str, String str2) {
        this.mUrl = str;
        this.abd = str2;
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.bwO = str;
    }

    public int gn(int i) {
        return com.baidu.tieba.a.d.MF().L(this.bwO, i);
    }
}
