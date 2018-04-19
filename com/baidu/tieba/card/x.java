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
    private String abb;
    private boolean akC;
    private boolean apW;
    private final View.OnClickListener apj;
    private String bvX;
    private HeadPendantClickableView bwV;
    public ThreadSourceShareAndPraiseLayout bwZ;
    public ThreadUserInfoLayout bwj;
    public ThreadCommentAndPraiseInfoLayout bwk;
    private NEGFeedBackView bww;
    private View coV;
    private TextView coW;
    private boolean coY;
    private View cqD;
    private TbImageView cqE;
    private be cqF;
    private TbImageView cqG;
    private OriginalThreadCardView.a cqH;
    public OriginalThreadCardView cqk;
    private TbPageContext<?> mPageContext;
    private TextView mTitle;
    private String mUrl;

    public x(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bww = null;
        this.akC = true;
        this.coY = true;
        this.apj = new View.OnClickListener() { // from class: com.baidu.tieba.card.x.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (x.this.aeZ() != null) {
                    x.this.aeZ().a(view2, x.this.cqF);
                }
            }
        };
        this.cqH = new OriginalThreadCardView.a() { // from class: com.baidu.tieba.card.x.6
            @Override // com.baidu.tieba.card.OriginalThreadCardView.a
            public void a(OriginalThreadInfo originalThreadInfo) {
                if (x.this.cqF != null && x.this.cqF.threadData != null) {
                    if (x.this.aeZ() != null) {
                        x.this.aeZ().a(x.this.cqk, x.this.cqF);
                    }
                    String id = x.this.cqF.threadData.getId();
                    o.kv(id);
                    x.this.kx(id);
                }
            }
        };
        this.mPageContext = tbPageContext;
        View view2 = getView();
        this.bwV = (HeadPendantClickableView) view2.findViewById(d.g.thread_user_pendant_header);
        if (this.bwV.getHeadView() != null) {
            this.bwV.getHeadView().setIsRound(true);
            this.bwV.getHeadView().setDrawBorder(false);
            this.bwV.getHeadView().setDefaultResource(17170445);
            this.bwV.getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
            this.bwV.getHeadView().setDefaultBgResource(d.C0126d.cp_bg_line_e);
            this.bwV.getHeadView().setRadius(com.baidu.adp.lib.util.l.e(this.mPageContext.getPageActivity(), d.e.ds70));
        }
        this.bwV.setHasPendantStyle();
        if (this.bwV.getPendantView() != null) {
            this.bwV.getPendantView().setIsRound(true);
            this.bwV.getPendantView().setDrawBorder(false);
        }
        this.bwj = (ThreadUserInfoLayout) view2.findViewById(d.g.thread_user_info_layout);
        this.bww = new NEGFeedBackView(this.mPageContext);
        this.bww.a((ViewGroup) getView(), com.baidu.adp.lib.util.l.e(this.mContext, d.e.tbds92), com.baidu.adp.lib.util.l.e(getContext(), d.e.tbds16));
        this.mTitle = (TextView) view2.findViewById(d.g.thread_title);
        this.coW = (TextView) view2.findViewById(d.g.thread_abstract);
        this.cqk = (OriginalThreadCardView) view2.findViewById(d.g.original_thread_view);
        this.cqk.setSubClickListener(this.cqH);
        this.bwk = (ThreadCommentAndPraiseInfoLayout) view2.findViewById(d.g.thread_comment_layout);
        if (this.bwk.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bwk.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.bwk.setLayoutParams(layoutParams);
        }
        view2.setOnClickListener(this);
        this.bwk.setOnClickListener(this);
        this.bwk.setReplyTimeVisible(false);
        this.bwk.setShowPraiseNum(true);
        this.bwk.setNeedAddPraiseIcon(true);
        this.bwk.setNeedAddReplyIcon(true);
        this.bwk.setShareVisible(true);
        this.bwk.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.x.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view3) {
                if (x.this.aeZ() != null) {
                    x.this.aeZ().a(view3, x.this.cqF);
                }
                if (x.this.cqF != null && x.this.cqF.threadData != null) {
                    o.kv(x.this.cqF.threadData.getId());
                    x.this.kx(x.this.cqF.threadData.getId());
                }
            }
        });
        this.bwZ = (ThreadSourceShareAndPraiseLayout) view2.findViewById(d.g.card_transmit_source_read_share_layout);
        this.bwZ.apG.setOnClickListener(this);
        this.bwZ.apG.setNeedAddReplyIcon(true);
        this.bwZ.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.x.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view3) {
                if (x.this.aeZ() != null) {
                    x.this.aeZ().a(view3, x.this.cqF);
                }
                if (view3 != x.this.bwZ.apF && x.this.cqF != null && x.this.cqF.threadData != null) {
                    o.kv(x.this.cqF.threadData.getId());
                    x.this.kx(x.this.cqF.threadData.getId());
                }
            }
        });
        this.coV = view2.findViewById(d.g.divider_line_above_praise);
        this.cqD = view2.findViewById(d.g.card_divider_line);
        this.cqE = (TbImageView) view2.findViewById(d.g.thread_theme_card);
        this.cqG = (TbImageView) view2.findViewById(d.g.frs_normal_item_star_view);
    }

    private void I(final bd bdVar) {
        if (this.cqG != null) {
            if (this.cqE == null || bdVar == null) {
                this.cqG.setVisibility(8);
            } else if (!StringUtils.isNull(bdVar.abM) && this.cqE.getVisibility() != 0) {
                if (this.bww != null && this.bww.getVisibility() == 0 && (this.cqG.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.cqG.getLayoutParams();
                    layoutParams.rightMargin = com.baidu.adp.lib.util.l.e(this.mPageContext.getPageActivity(), d.e.tbds106);
                    this.cqG.setLayoutParams(layoutParams);
                }
                this.cqG.setVisibility(0);
                this.cqG.setImageDrawable(null);
                this.cqG.startLoad(bdVar.abM, 10, false);
                this.cqG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.x.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (x.this.mPageContext != null) {
                            x.this.mTbPageContext.sendMessage(new CustomMessage(2002001, new ShareWebActivityConfig(x.this.mTbPageContext.getContext(), "", bdVar.abN, true)));
                        }
                        TiebaStatic.log(new al("c12883"));
                    }
                });
            } else {
                this.cqG.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ak.i(getView(), d.f.addresslist_item_bg);
            ak.j(this.coV, d.C0126d.cp_bg_line_e);
            this.bwk.onChangeSkinType();
            this.bwj.onChangeSkinType();
            if (this.bww != null) {
                this.bww.onChangeSkinType();
            }
            this.cqk.onChangeSkinType();
            ak.j(this.cqD, d.C0126d.cp_bg_line_e);
            this.bwZ.onChangeSkinType();
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
        this.cqF = beVar;
        bd bdVar = beVar.threadData;
        if (this.bww != null) {
            SparseArray<String> qU = bdVar.qU();
            if (qU != null && qU.size() > 0 && this.coY) {
                ai aiVar = new ai();
                aiVar.cJ(bdVar.getTid());
                aiVar.setFid(bdVar.getFid());
                aiVar.a(qU);
                this.bww.setData(aiVar);
                this.bww.setFirstRowSingleColumn(true);
                this.bww.setVisibility(K(bdVar) ? 8 : 0);
            } else {
                this.bww.setVisibility(8);
            }
        }
        if (this.cqF.abU == 1) {
            this.bwj.setFrom(3);
            L(bdVar);
            I(bdVar);
        }
        this.bwj.setIsFromConcern(this.apW);
        this.bwj.setData(bdVar);
        this.bwj.setUserAfterClickListener(this.apj);
        if (this.bwj.getHeaderImg() != null) {
            if (this.bwj.getIsSimpleThread()) {
                this.bwj.getHeaderImg().setVisibility(8);
                this.bwV.setVisibility(8);
            } else if (bdVar.rQ() == null || bdVar.rQ().getPendantData() == null || StringUtils.isNull(bdVar.rQ().getPendantData().qG())) {
                this.bwV.setVisibility(8);
                this.bwj.getHeaderImg().setVisibility(0);
                this.bwj.getHeaderImg().setData(bdVar);
            } else {
                this.bwj.getHeaderImg().setVisibility(4);
                this.bwV.setVisibility(0);
                this.bwV.setData(bdVar);
            }
        }
        J(bdVar);
        this.cqk.b(bdVar.abL);
        hb(gm(1));
        setPageUniqueId(getTag());
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        kx(bdVar.getId());
    }

    private void J(bd bdVar) {
        if (bdVar != null) {
            if (!StringUtils.isNull(this.mUrl) && !StringUtils.isNull(this.abb)) {
                bdVar.M(this.mUrl, this.abb);
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
        if (bdVar == null || bdVar.rQ() == null || StringUtils.isNull(bdVar.rQ().getUserId())) {
            return false;
        }
        return bdVar.rQ().getUserId().equals(TbadkCoreApplication.getCurrentAccount());
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.bww != null) {
            this.bww.setUniqueId(bdUniqueId);
        }
        if (this.bwj != null) {
            this.bwj.setPageUniqueId(bdUniqueId);
        }
    }

    public void a(NEGFeedBackView.a aVar) {
        if (this.bww != null) {
            this.bww.setEventCallback(aVar);
        }
    }

    public ThreadCommentAndPraiseInfoLayout afz() {
        return this.bwk;
    }

    public ThreadCommentAndPraiseInfoLayout afA() {
        return this.bwZ.apG;
    }

    public void eu(boolean z) {
        if (this.cqD != null) {
            this.cqD.setVisibility(z ? 0 : 8);
        }
    }

    public void eq(boolean z) {
        this.coY = z;
    }

    public void setIsFromConcern(boolean z) {
        this.apW = z;
    }

    private void afs() {
        if (this.cqF != null && this.cqF.threadData != null) {
            bd bdVar = this.cqF.threadData;
            o.kv(bdVar.getId());
            kx(bdVar.getId());
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(bdVar, null, this.cqF.stType, 18003, true, false, false);
            createFromThreadCfg.setForumId(String.valueOf(bdVar.getFid()));
            createFromThreadCfg.setForumName(bdVar.rV());
            createFromThreadCfg.setStartFrom(this.currentPageType);
            createFromThreadCfg.setIsShareThread(true);
            o.kv(bdVar.getTid());
            this.mPageContext.sendMessage(new CustomMessage(2004001, createFromThreadCfg));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kx(String str) {
        o.a(this.mTitle, str, d.C0126d.cp_cont_b, d.C0126d.cp_cont_d);
        o.a(this.coW, str, d.C0126d.cp_cont_b, d.C0126d.cp_cont_d);
        this.cqk.setReadState(o.kw(str));
    }

    public void L(bd bdVar) {
        MetaData rQ;
        if (bdVar != null && this.cqE != null && (rQ = bdVar.rQ()) != null) {
            final ThemeCardInUserData themeCard = rQ.getThemeCard();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                this.cqE.setVisibility(8);
                return;
            }
            this.cqE.setVisibility(0);
            this.cqE.setImageBitmap(null);
            this.cqE.startLoad(themeCard.getCardImageUrlAndroid(), 10, false);
            this.cqE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.x.4
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
            aeZ().a(view2, this.cqF);
        }
        if (view2 == getView()) {
            afs();
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.bwj != null) {
            return this.bwj.apf;
        }
        return null;
    }

    public View afc() {
        if (this.bwj != null) {
            return this.bwj.apg;
        }
        return null;
    }

    public void hb(int i) {
        if (this.cqF != null && this.cqF.threadData != null) {
            if (i == 1) {
                this.bwk.setVisibility(8);
                this.bwZ.setFrom(this.cqF.abT);
                this.bwZ.setShareReportFrom(this.cqF.abU);
                this.bwZ.setStType(this.cqF.stType);
                this.bwZ.setData(this.cqF.threadData);
                this.bwj.showForumNameView(false);
                return;
            }
            this.bwk.setFrom(this.cqF.abT);
            this.bwk.setShareReportFrom(this.cqF.abU);
            this.bwk.setStType(this.cqF.stType);
            this.bwk.setData(this.cqF.threadData);
            this.bwZ.setVisibility(8);
            this.bwj.showForumNameView(true);
        }
    }

    public void M(String str, String str2) {
        this.mUrl = str;
        this.abb = str2;
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.bvX = str;
    }

    public int gm(int i) {
        return com.baidu.tieba.a.d.MH().L(this.bvX, i);
    }
}
