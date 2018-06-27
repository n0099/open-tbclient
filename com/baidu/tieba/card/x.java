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
import com.baidu.tbadk.core.data.bc;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
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
public class x extends a<bd> implements com.baidu.tieba.a.e {
    private String ajC;
    private boolean atn;
    private View axY;
    private boolean ayW;
    private final View.OnClickListener ayi;
    private String bGM;
    public ThreadUserInfoLayout bGY;
    public ThreadCommentAndPraiseInfoLayout bGZ;
    private HeadPendantClickableView bHK;
    public ThreadSourceShareAndPraiseLayout bHN;
    private NEGFeedBackView bHl;
    private TextView cwA;
    private boolean cwC;
    private View cwz;
    public OriginalThreadCardView cxM;
    private View cyg;
    private TbImageView cyh;
    private bd cyi;
    private TbImageView cyj;
    private OriginalThreadCardView.a cyk;
    private TbPageContext<?> mPageContext;
    private TextView mTitle;
    private String mUrl;

    public x(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bHl = null;
        this.atn = true;
        this.cwC = true;
        this.ayi = new View.OnClickListener() { // from class: com.baidu.tieba.card.x.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (x.this.aia() != null) {
                    x.this.aia().a(view, x.this.cyi);
                }
            }
        };
        this.cyk = new OriginalThreadCardView.a() { // from class: com.baidu.tieba.card.x.8
            @Override // com.baidu.tieba.card.OriginalThreadCardView.a
            public void a(OriginalThreadInfo originalThreadInfo) {
                if (x.this.cyi != null && x.this.cyi.threadData != null) {
                    if (x.this.aia() != null) {
                        x.this.aia().a(x.this.cxM, x.this.cyi);
                    }
                    String id = x.this.cyi.threadData.getId();
                    o.kY(id);
                    x.this.la(id);
                }
            }
        };
        this.mPageContext = tbPageContext;
        View view = getView();
        this.bHK = (HeadPendantClickableView) view.findViewById(d.g.thread_user_pendant_header);
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
        this.bGY = (ThreadUserInfoLayout) view.findViewById(d.g.thread_user_info_layout);
        this.bHl = new NEGFeedBackView(this.mPageContext);
        this.bHl.a((ViewGroup) getView(), com.baidu.adp.lib.util.l.e(this.mContext, d.e.tbds92), com.baidu.adp.lib.util.l.e(getContext(), d.e.tbds16));
        this.mTitle = (TextView) view.findViewById(d.g.thread_title);
        this.cwA = (TextView) view.findViewById(d.g.thread_abstract);
        this.cxM = (OriginalThreadCardView) view.findViewById(d.g.original_thread_view);
        this.cxM.setSubClickListener(this.cyk);
        this.bGZ = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.thread_comment_layout);
        if (this.bGZ.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bGZ.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.bGZ.setLayoutParams(layoutParams);
        }
        view.setOnClickListener(this);
        this.bGZ.setOnClickListener(this);
        this.bGZ.setReplyTimeVisible(false);
        this.bGZ.setShowPraiseNum(true);
        this.bGZ.setNeedAddPraiseIcon(true);
        this.bGZ.setNeedAddReplyIcon(true);
        this.bGZ.setShareVisible(true);
        this.bGZ.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.x.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (x.this.aia() != null) {
                    x.this.aia().a(view2, x.this.cyi);
                }
                if (x.this.cyi != null && x.this.cyi.threadData != null) {
                    o.kY(x.this.cyi.threadData.getId());
                    x.this.la(x.this.cyi.threadData.getId());
                }
            }
        });
        this.bHN = (ThreadSourceShareAndPraiseLayout) view.findViewById(d.g.card_transmit_source_read_share_layout);
        this.bHN.ayE.setOnClickListener(this);
        this.bHN.ayE.setNeedAddReplyIcon(true);
        this.bHN.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.x.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (x.this.aia() != null) {
                    x.this.aia().a(view2, x.this.cyi);
                }
                if (view2 != x.this.bHN.ayD && x.this.cyi != null && x.this.cyi.threadData != null) {
                    o.kY(x.this.cyi.threadData.getId());
                    x.this.la(x.this.cyi.threadData.getId());
                }
            }
        });
        this.cwz = view.findViewById(d.g.divider_line_above_praise);
        this.cyg = view.findViewById(d.g.card_divider_line);
        this.cyh = (TbImageView) view.findViewById(d.g.thread_theme_card);
        this.cyj = (TbImageView) view.findViewById(d.g.frs_normal_item_star_view);
        this.axY = view.findViewById(d.g.thread_multi_del_mask_view);
        this.axY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.x.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                x.this.bGZ.changeSelectStatus();
            }
        });
        this.bGZ.setOnSelectStatusChangeListener(new ThreadCommentAndPraiseInfoLayout.a() { // from class: com.baidu.tieba.card.x.4
            @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.a
            public void aW(boolean z) {
                am.j(x.this.axY, z ? d.C0142d.cp_bg_line_d : d.C0142d.transparent);
            }
        });
    }

    private void K(final bc bcVar) {
        if (this.cyj != null) {
            if (this.cyh == null || bcVar == null) {
                this.cyj.setVisibility(8);
            } else if (!StringUtils.isNull(bcVar.akl) && this.cyh.getVisibility() != 0) {
                if (this.bHl != null && this.bHl.getVisibility() == 0 && (this.cyj.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.cyj.getLayoutParams();
                    layoutParams.rightMargin = com.baidu.adp.lib.util.l.e(this.mPageContext.getPageActivity(), d.e.tbds106);
                    this.cyj.setLayoutParams(layoutParams);
                }
                this.cyj.setVisibility(0);
                this.cyj.setImageDrawable(null);
                this.cyj.startLoad(bcVar.akl, 10, false);
                this.cyj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.x.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (x.this.mPageContext != null) {
                            x.this.mTbPageContext.sendMessage(new CustomMessage(2002001, new ShareWebActivityConfig(x.this.mTbPageContext.getContext(), "", bcVar.akm, true)));
                        }
                        TiebaStatic.log(new an("c12883"));
                    }
                });
            } else {
                this.cyj.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.i(getView(), d.f.addresslist_item_bg);
            am.j(this.cwz, d.C0142d.cp_bg_line_e);
            this.bGZ.onChangeSkinType();
            this.bGY.onChangeSkinType();
            if (this.bHl != null) {
                this.bHl.onChangeSkinType();
            }
            this.cxM.onChangeSkinType();
            am.j(this.cyg, d.C0142d.cp_bg_line_e);
            this.bHN.onChangeSkinType();
        }
        if (this.cyi != null && this.cyi.threadData != null) {
            am.j(this.axY, this.cyi.threadData.wS() ? d.C0142d.cp_bg_line_d : d.C0142d.transparent);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.i.card_transmit_thread_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(bd bdVar) {
        if (bdVar == null || bdVar.threadData == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        if (getView() != null) {
            getView().setVisibility(0);
        }
        this.cyi = bdVar;
        bc bcVar = bdVar.threadData;
        if (this.bHl != null) {
            SparseArray<String> uv = bcVar.uv();
            if (uv != null && uv.size() > 0 && this.cwC) {
                ai aiVar = new ai();
                aiVar.dk(bcVar.getTid());
                aiVar.setFid(bcVar.getFid());
                aiVar.a(uv);
                this.bHl.setData(aiVar);
                this.bHl.setFirstRowSingleColumn(true);
                this.bHl.setVisibility(M(bcVar) ? 8 : 0);
            } else {
                this.bHl.setVisibility(8);
            }
        }
        if (this.cyi.aky == 1) {
            this.bGY.setFrom(3);
            N(bcVar);
            K(bcVar);
        }
        if (this.currentPageType == 15) {
            this.bGY.setFrom(5);
        }
        this.bGY.setIsFromConcern(this.ayW);
        this.bGY.setData(bcVar);
        this.bGY.setUserAfterClickListener(this.ayi);
        if (this.bGY.getHeaderImg() != null) {
            if (this.bGY.getIsSimpleThread()) {
                this.bGY.getHeaderImg().setVisibility(8);
                this.bHK.setVisibility(8);
            } else if (bcVar.vw() == null || bcVar.vw().getPendantData() == null || StringUtils.isNull(bcVar.vw().getPendantData().uh())) {
                this.bHK.setVisibility(8);
                this.bGY.getHeaderImg().setVisibility(0);
                this.bGY.getHeaderImg().setData(bcVar);
            } else {
                this.bGY.getHeaderImg().setVisibility(4);
                this.bHK.setVisibility(0);
                this.bHK.setData(bcVar);
            }
        }
        L(bcVar);
        this.cxM.b(bcVar.akk);
        hh(gp(1));
        setPageUniqueId(getTag());
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        la(bcVar.getId());
        if (this.bGZ.isInFrsAllThread() && com.baidu.tieba.frs.a.asZ().ata()) {
            this.axY.setVisibility(0);
            if (bcVar.wS() || bcVar.wT()) {
                am.j(this.axY, d.C0142d.cp_bg_line_d);
                return;
            } else {
                this.axY.setBackgroundResource(d.C0142d.transparent);
                return;
            }
        }
        this.axY.setVisibility(8);
    }

    private void L(bc bcVar) {
        if (bcVar != null) {
            if (!StringUtils.isNull(this.mUrl) && !StringUtils.isNull(this.ajC)) {
                bcVar.P(this.mUrl, this.ajC);
            }
            SpannableStringBuilder g = bcVar.g(false, true);
            if (g == null || StringUtils.isNull(g.toString())) {
                this.mTitle.setVisibility(8);
                return;
            }
            this.mTitle.setVisibility(0);
            this.mTitle.setOnTouchListener(new com.baidu.tieba.view.k(g));
            this.mTitle.setText(g);
            o.a(this.mTitle, bcVar.getId(), d.C0142d.cp_cont_b, d.C0142d.cp_cont_d);
        }
    }

    private boolean M(bc bcVar) {
        if (bcVar == null || bcVar.vw() == null || StringUtils.isNull(bcVar.vw().getUserId())) {
            return false;
        }
        return bcVar.vw().getUserId().equals(TbadkCoreApplication.getCurrentAccount());
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

    public void a(NEGFeedBackView.a aVar) {
        if (this.bHl != null) {
            this.bHl.setEventCallback(aVar);
        }
    }

    public ThreadCommentAndPraiseInfoLayout Vr() {
        return this.bGZ;
    }

    public ThreadCommentAndPraiseInfoLayout Vs() {
        return this.bHN.ayE;
    }

    public void ey(boolean z) {
        if (this.cyg != null) {
            this.cyg.setVisibility(z ? 0 : 8);
        }
    }

    public void eu(boolean z) {
        this.cwC = z;
    }

    public void setIsFromConcern(boolean z) {
        this.ayW = z;
    }

    private void ait() {
        if (this.cyi != null && this.cyi.threadData != null) {
            bc bcVar = this.cyi.threadData;
            o.kY(bcVar.getId());
            la(bcVar.getId());
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(bcVar, null, this.cyi.stType, 18003, true, false, false);
            createFromThreadCfg.setStartFrom(this.currentPageType);
            createFromThreadCfg.setIsShareThread(true);
            o.kY(bcVar.getTid());
            this.mPageContext.sendMessage(new CustomMessage(2004001, createFromThreadCfg));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void la(String str) {
        o.a(this.mTitle, str, d.C0142d.cp_cont_b, d.C0142d.cp_cont_d);
        o.a(this.cwA, str, d.C0142d.cp_cont_b, d.C0142d.cp_cont_d);
        this.cxM.setReadState(o.kZ(str));
    }

    public void N(bc bcVar) {
        MetaData vw;
        if (bcVar != null && this.cyh != null && (vw = bcVar.vw()) != null) {
            final ThemeCardInUserData themeCard = vw.getThemeCard();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                this.cyh.setVisibility(8);
                return;
            }
            this.cyh.setVisibility(0);
            this.cyh.setImageBitmap(null);
            this.cyh.startLoad(themeCard.getCardImageUrlAndroid(), 10, false);
            this.cyh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.x.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonalCardDetailActivityConfig(x.this.mPageContext.getPageActivity(), themeCard.getCardId())));
                }
            });
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (aia() != null) {
            aia().a(view, this.cyi);
        }
        if (view == getView()) {
            ait();
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

    public void hh(int i) {
        if (this.cyi != null && this.cyi.threadData != null) {
            if (i == 1) {
                this.bGZ.setVisibility(8);
                this.bHN.setFrom(this.cyi.akx);
                this.bHN.setShareReportFrom(this.cyi.aky);
                this.bHN.setStType(this.cyi.stType);
                this.bHN.setData(this.cyi.threadData);
                this.bGY.showForumNameView(false);
                return;
            }
            this.bGZ.setFrom(this.cyi.akx);
            this.bGZ.setShareReportFrom(this.cyi.aky);
            this.bGZ.setStType(this.cyi.stType);
            this.bGZ.setData(this.cyi.threadData);
            this.bHN.setVisibility(8);
            this.bGY.showForumNameView(true);
        }
    }

    public void P(String str, String str2) {
        this.mUrl = str;
        this.ajC = str2;
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.bGM = str;
    }

    public int gp(int i) {
        return com.baidu.tieba.a.d.QB().L(this.bGM, i);
    }
}
