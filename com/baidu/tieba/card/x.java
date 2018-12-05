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
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.data.bc;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadSourceShareAndPraiseLayout;
import com.baidu.tbadk.core.view.ThreadUserInfoLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.card.OriginalThreadCardView;
import com.baidu.tieba.e;
/* loaded from: classes6.dex */
public class x extends a<bc> implements com.baidu.tieba.a.e {
    private boolean aEq;
    private final View.OnClickListener aKA;
    private boolean aKC;
    private String auJ;
    private View cUY;
    private TextView cUZ;
    private boolean cVb;
    private View cWF;
    private TbImageView cWG;
    private bc cWH;
    private TbImageView cWI;
    private OriginalThreadCardView.a cWJ;
    public OriginalThreadCardView cWl;
    public ThreadUserInfoLayout caI;
    public ThreadCommentAndPraiseInfoLayout caJ;
    private NEGFeedBackView caU;
    private String caw;
    private HeadPendantClickableView cbt;
    public ThreadSourceShareAndPraiseLayout cbw;
    private View mMaskView;
    private TbPageContext<?> mPageContext;
    private TextView mTitle;
    private String mUrl;

    public x(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.caU = null;
        this.aEq = true;
        this.cVb = true;
        this.aKA = new View.OnClickListener() { // from class: com.baidu.tieba.card.x.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (x.this.apc() != null) {
                    x.this.apc().a(view, x.this.cWH);
                }
            }
        };
        this.cWJ = new OriginalThreadCardView.a() { // from class: com.baidu.tieba.card.x.8
            @Override // com.baidu.tieba.card.OriginalThreadCardView.a
            public void a(OriginalThreadInfo originalThreadInfo) {
                if (x.this.cWH != null && x.this.cWH.threadData != null) {
                    if (x.this.apc() != null) {
                        x.this.apc().a(x.this.cWl, x.this.cWH);
                    }
                    String id = x.this.cWH.threadData.getId();
                    o.mD(id);
                    x.this.mF(id);
                }
            }
        };
        this.mPageContext = tbPageContext;
        View view = getView();
        this.cbt = (HeadPendantClickableView) view.findViewById(e.g.thread_user_pendant_header);
        if (this.cbt.getHeadView() != null) {
            this.cbt.getHeadView().setIsRound(true);
            this.cbt.getHeadView().setDrawBorder(false);
            this.cbt.getHeadView().setDefaultResource(17170445);
            this.cbt.getHeadView().setDefaultErrorResource(e.f.icon_default_avatar100);
            this.cbt.getHeadView().setDefaultBgResource(e.d.cp_bg_line_e);
            this.cbt.getHeadView().setRadius(com.baidu.adp.lib.util.l.h(this.mPageContext.getPageActivity(), e.C0210e.ds70));
        }
        this.cbt.setHasPendantStyle();
        if (this.cbt.getPendantView() != null) {
            this.cbt.getPendantView().setIsRound(true);
            this.cbt.getPendantView().setDrawBorder(false);
        }
        this.caI = (ThreadUserInfoLayout) view.findViewById(e.g.thread_user_info_layout);
        this.caU = new NEGFeedBackView(this.mPageContext);
        this.caU.a((ViewGroup) getView(), com.baidu.adp.lib.util.l.h(this.mContext, e.C0210e.tbds92), com.baidu.adp.lib.util.l.h(getContext(), e.C0210e.tbds16));
        this.mTitle = (TextView) view.findViewById(e.g.thread_title);
        this.cUZ = (TextView) view.findViewById(e.g.thread_abstract);
        this.cWl = (OriginalThreadCardView) view.findViewById(e.g.original_thread_view);
        this.cWl.setSubClickListener(this.cWJ);
        this.caJ = (ThreadCommentAndPraiseInfoLayout) view.findViewById(e.g.thread_comment_layout);
        if (this.caJ.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.caJ.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.caJ.setLayoutParams(layoutParams);
        }
        view.setOnClickListener(this);
        this.caJ.setOnClickListener(this);
        this.caJ.setReplyTimeVisible(false);
        this.caJ.setShowPraiseNum(true);
        this.caJ.setNeedAddPraiseIcon(true);
        this.caJ.setNeedAddReplyIcon(true);
        this.caJ.setShareVisible(true);
        this.caJ.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.x.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (x.this.apc() != null) {
                    x.this.apc().a(view2, x.this.cWH);
                }
                if (x.this.cWH != null && x.this.cWH.threadData != null) {
                    o.mD(x.this.cWH.threadData.getId());
                    x.this.mF(x.this.cWH.threadData.getId());
                }
            }
        });
        this.cbw = (ThreadSourceShareAndPraiseLayout) view.findViewById(e.g.card_transmit_source_read_share_layout);
        this.cbw.aKi.setOnClickListener(this);
        this.cbw.aKi.setNeedAddReplyIcon(true);
        this.cbw.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.x.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (x.this.apc() != null) {
                    x.this.apc().a(view2, x.this.cWH);
                }
                if (view2 != x.this.cbw.aKh && x.this.cWH != null && x.this.cWH.threadData != null) {
                    o.mD(x.this.cWH.threadData.getId());
                    x.this.mF(x.this.cWH.threadData.getId());
                }
            }
        });
        this.cUY = view.findViewById(e.g.divider_line_above_praise);
        this.cWF = view.findViewById(e.g.card_divider_line);
        this.cWG = (TbImageView) view.findViewById(e.g.thread_theme_card);
        this.cWI = (TbImageView) view.findViewById(e.g.frs_normal_item_star_view);
        this.mMaskView = view.findViewById(e.g.thread_multi_del_mask_view);
        this.mMaskView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.x.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                x.this.caJ.changeSelectStatus();
            }
        });
        this.caJ.setOnSelectStatusChangeListener(new ThreadCommentAndPraiseInfoLayout.a() { // from class: com.baidu.tieba.card.x.4
            @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.a
            public void bJ(boolean z) {
                al.j(x.this.mMaskView, z ? e.d.cp_bg_line_d : e.d.transparent);
            }
        });
    }

    private void N(final bb bbVar) {
        if (this.cWI != null) {
            if (this.cWG == null || bbVar == null) {
                this.cWI.setVisibility(8);
            } else if (!StringUtils.isNull(bbVar.avu) && this.cWG.getVisibility() != 0) {
                if (this.caU != null && this.caU.getVisibility() == 0 && (this.cWI.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.cWI.getLayoutParams();
                    layoutParams.rightMargin = com.baidu.adp.lib.util.l.h(this.mPageContext.getPageActivity(), e.C0210e.tbds106);
                    this.cWI.setLayoutParams(layoutParams);
                }
                this.cWI.setVisibility(0);
                this.cWI.setImageDrawable(null);
                this.cWI.startLoad(bbVar.avu, 10, false);
                this.cWI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.x.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (x.this.mPageContext != null) {
                            x.this.mTbPageContext.sendMessage(new CustomMessage(2002001, new ShareWebActivityConfig(x.this.mTbPageContext.getContext(), "", bbVar.avv, true)));
                        }
                        TiebaStatic.log(new am("c12883"));
                    }
                });
            } else {
                this.cWI.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.i(getView(), e.f.addresslist_item_bg);
            al.j(this.cUY, e.d.cp_bg_line_e);
            this.caJ.onChangeSkinType();
            this.caI.onChangeSkinType();
            if (this.caU != null) {
                this.caU.onChangeSkinType();
            }
            this.cWl.onChangeSkinType();
            al.j(this.cWF, e.d.cp_bg_line_e);
            this.cbw.onChangeSkinType();
        }
        if (this.cWH != null && this.cWH.threadData != null) {
            al.j(this.mMaskView, this.cWH.threadData.Bh() ? e.d.cp_bg_line_d : e.d.transparent);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return e.h.card_transmit_thread_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(bc bcVar) {
        if (bcVar == null || bcVar.threadData == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        if (getView() != null) {
            getView().setVisibility(0);
        }
        this.cWH = bcVar;
        bb bbVar = bcVar.threadData;
        if (this.caU != null) {
            SparseArray<String> yF = bbVar.yF();
            if (yF != null && yF.size() > 0 && this.cVb) {
                ah ahVar = new ah();
                ahVar.setTid(bbVar.getTid());
                ahVar.setFid(bbVar.getFid());
                ahVar.a(yF);
                this.caU.setData(ahVar);
                this.caU.setFirstRowSingleColumn(true);
                this.caU.setVisibility(P(bbVar) ? 8 : 0);
            } else {
                this.caU.setVisibility(8);
            }
        }
        if (this.cWH.avK == 1) {
            this.caI.setFrom(3);
            Q(bbVar);
            N(bbVar);
        }
        if (this.currentPageType == 15) {
            this.caI.setFrom(5);
        }
        this.caI.setIsFromConcern(this.aKC);
        this.caI.setData(bbVar);
        this.caI.setUserAfterClickListener(this.aKA);
        if (this.caI.getHeaderImg() != null) {
            if (this.caI.getIsSimpleThread()) {
                this.caI.getHeaderImg().setVisibility(8);
                this.cbt.setVisibility(8);
            } else if (bbVar.zG() == null || bbVar.zG().getPendantData() == null || StringUtils.isNull(bbVar.zG().getPendantData().ys())) {
                this.cbt.setVisibility(8);
                this.caI.getHeaderImg().setVisibility(0);
                this.caI.getHeaderImg().setData(bbVar);
            } else {
                this.caI.getHeaderImg().setVisibility(4);
                this.cbt.setVisibility(0);
                this.cbt.setData(bbVar);
            }
        }
        O(bbVar);
        this.cWl.b(bbVar.avt);
        iL(hC(1));
        setPageUniqueId(getTag());
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        mF(bbVar.getId());
        if (this.caJ.isInFrsAllThread() && com.baidu.tieba.frs.a.azU().azV()) {
            this.mMaskView.setVisibility(0);
            if (bbVar.Bh() || bbVar.Bi()) {
                al.j(this.mMaskView, e.d.cp_bg_line_d);
                return;
            } else {
                this.mMaskView.setBackgroundResource(e.d.transparent);
                return;
            }
        }
        this.mMaskView.setVisibility(8);
    }

    private void O(bb bbVar) {
        if (bbVar != null) {
            if (!StringUtils.isNull(this.mUrl) && !StringUtils.isNull(this.auJ)) {
                bbVar.al(this.mUrl, this.auJ);
            }
            SpannableStringBuilder i = bbVar.i(false, true);
            if (i == null || StringUtils.isNull(i.toString())) {
                this.mTitle.setVisibility(8);
                return;
            }
            this.mTitle.setVisibility(0);
            this.mTitle.setOnTouchListener(new com.baidu.tieba.view.k(i));
            this.mTitle.setText(i);
            o.a(this.mTitle, bbVar.getId(), e.d.cp_cont_b, e.d.cp_cont_d);
        }
    }

    private boolean P(bb bbVar) {
        if (bbVar == null || bbVar.zG() == null || StringUtils.isNull(bbVar.zG().getUserId())) {
            return false;
        }
        return bbVar.zG().getUserId().equals(TbadkCoreApplication.getCurrentAccount());
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.caU != null) {
            this.caU.setUniqueId(bdUniqueId);
        }
        if (this.caI != null) {
            this.caI.setPageUniqueId(bdUniqueId);
        }
    }

    public void a(NEGFeedBackView.a aVar) {
        if (this.caU != null) {
            this.caU.setEventCallback(aVar);
        }
    }

    public ThreadCommentAndPraiseInfoLayout aco() {
        return this.caJ;
    }

    public ThreadCommentAndPraiseInfoLayout acp() {
        return this.cbw.aKi;
    }

    public void fu(boolean z) {
        if (this.cWF != null) {
            this.cWF.setVisibility(z ? 0 : 8);
        }
    }

    public void fq(boolean z) {
        this.cVb = z;
    }

    public void setIsFromConcern(boolean z) {
        this.aKC = z;
    }

    private void apx() {
        if (this.cWH != null && this.cWH.threadData != null) {
            bb bbVar = this.cWH.threadData;
            o.mD(bbVar.getId());
            mF(bbVar.getId());
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(bbVar, null, this.cWH.stType, 18003, true, false, false);
            createFromThreadCfg.setStartFrom(this.currentPageType);
            createFromThreadCfg.setIsShareThread(true);
            o.mD(bbVar.getTid());
            this.mPageContext.sendMessage(new CustomMessage(2004001, createFromThreadCfg));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mF(String str) {
        o.a(this.mTitle, str, e.d.cp_cont_b, e.d.cp_cont_d);
        o.a(this.cUZ, str, e.d.cp_cont_b, e.d.cp_cont_d);
        this.cWl.setReadState(o.mE(str));
    }

    public void Q(bb bbVar) {
        MetaData zG;
        if (bbVar != null && this.cWG != null && (zG = bbVar.zG()) != null) {
            final ThemeCardInUserData themeCard = zG.getThemeCard();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                this.cWG.setVisibility(8);
                return;
            }
            this.cWG.setVisibility(0);
            this.cWG.setImageBitmap(null);
            this.cWG.startLoad(themeCard.getCardImageUrlAndroid(), 10, false);
            this.cWG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.x.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonalCardDetailActivityConfig(x.this.mPageContext.getPageActivity(), themeCard.getCardId())));
                }
            });
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (apc() != null) {
            apc().a(view, this.cWH);
        }
        if (view == getView()) {
            apx();
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.caI != null) {
            return this.caI.aKn;
        }
        return null;
    }

    public View apf() {
        if (this.caI != null) {
            return this.caI.aKp;
        }
        return null;
    }

    public void iL(int i) {
        if (this.cWH != null && this.cWH.threadData != null) {
            if (i == 1) {
                this.caJ.setVisibility(8);
                this.cbw.setFrom(this.cWH.avJ);
                this.cbw.setShareReportFrom(this.cWH.avK);
                this.cbw.setStType(this.cWH.stType);
                this.cbw.setData(this.cWH.threadData);
                this.caI.showForumNameView(false);
                return;
            }
            this.caJ.setFrom(this.cWH.avJ);
            this.caJ.setShareReportFrom(this.cWH.avK);
            this.caJ.setStType(this.cWH.stType);
            this.caJ.setData(this.cWH.threadData);
            this.caJ.setDisPraiseFrom(this.cWH.avM);
            this.cbw.setVisibility(8);
            this.caI.showForumNameView(true);
        }
    }

    public void al(String str, String str2) {
        this.mUrl = str;
        this.auJ = str2;
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.caw = str;
    }

    public int hC(int i) {
        return com.baidu.tieba.a.d.VM().M(this.caw, i);
    }
}
