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
    private boolean aZj;
    private boolean beP;
    private final View.OnClickListener bec;
    private View cXd;
    private TextView cXe;
    private boolean cXg;
    public OriginalThreadCardView cYC;
    private View cYV;
    private TbImageView cYW;
    private be cYX;
    private TbImageView cYY;
    private OriginalThreadCardView.a cYZ;
    private HeadPendantClickableView cmU;
    public ThreadSourceShareAndPraiseLayout cmX;
    public ThreadUserInfoLayout cmj;
    public ThreadCommentAndPraiseInfoLayout cmk;
    private com.baidu.tieba.NEGFeedBack.c cmv;
    private TbPageContext<?> mPageContext;
    private TextView mTitle;

    public s(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.cmv = null;
        this.aZj = true;
        this.cXg = true;
        this.bec = new View.OnClickListener() { // from class: com.baidu.tieba.card.s.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (s.this.akP() != null) {
                    s.this.akP().a(view, s.this.cYX);
                }
            }
        };
        this.cYZ = new OriginalThreadCardView.a() { // from class: com.baidu.tieba.card.s.6
            @Override // com.baidu.tieba.card.OriginalThreadCardView.a
            public void a(OriginalThreadInfo originalThreadInfo) {
                if (s.this.cYX != null && s.this.cYX.threadData != null) {
                    if (s.this.akP() != null) {
                        s.this.akP().a(s.this.cYC, s.this.cYX);
                    }
                    String id = s.this.cYX.threadData.getId();
                    j.kr(id);
                    s.this.ku(id);
                }
            }
        };
        this.mPageContext = tbPageContext;
        View view = getView();
        this.cmU = (HeadPendantClickableView) view.findViewById(d.g.thread_user_pendant_header);
        if (this.cmU.getHeadView() != null) {
            this.cmU.getHeadView().setIsRound(true);
            this.cmU.getHeadView().setDrawBorder(false);
            this.cmU.getHeadView().setDefaultResource(17170445);
            this.cmU.getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
            this.cmU.getHeadView().setDefaultBgResource(d.C0140d.cp_bg_line_e);
            this.cmU.getHeadView().setRadius(com.baidu.adp.lib.util.l.t(this.mPageContext.getPageActivity(), d.e.ds70));
        }
        this.cmU.DT();
        if (this.cmU.getPendantView() != null) {
            this.cmU.getPendantView().setIsRound(true);
            this.cmU.getPendantView().setDrawBorder(false);
        }
        this.cmj = (ThreadUserInfoLayout) view.findViewById(d.g.thread_user_info_layout);
        this.cmv = new com.baidu.tieba.NEGFeedBack.c(this.mPageContext);
        this.cmv.a((ViewGroup) getView(), com.baidu.adp.lib.util.l.t(this.mContext, d.e.tbds92), com.baidu.adp.lib.util.l.t(getContext(), d.e.tbds16));
        this.mTitle = (TextView) view.findViewById(d.g.thread_title);
        this.cXe = (TextView) view.findViewById(d.g.thread_abstract);
        this.cYC = (OriginalThreadCardView) view.findViewById(d.g.original_thread_view);
        this.cYC.setSubClickListener(this.cYZ);
        this.cmk = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.thread_comment_layout);
        if (this.cmk.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cmk.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.cmk.setLayoutParams(layoutParams);
        }
        view.setOnClickListener(this);
        this.cmk.setOnClickListener(this);
        this.cmk.setReplyTimeVisible(false);
        this.cmk.setShowPraiseNum(true);
        this.cmk.setNeedAddPraiseIcon(true);
        this.cmk.setNeedAddReplyIcon(true);
        this.cmk.setShareVisible(true);
        this.cmk.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.s.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (s.this.akP() != null) {
                    s.this.akP().a(view2, s.this.cYX);
                }
                if (s.this.cYX != null && s.this.cYX.threadData != null) {
                    j.kr(s.this.cYX.threadData.getId());
                    s.this.ku(s.this.cYX.threadData.getId());
                }
            }
        });
        this.cmX = (ThreadSourceShareAndPraiseLayout) view.findViewById(d.g.card_transmit_source_read_share_layout);
        this.cmX.bez.setOnClickListener(this);
        this.cmX.bez.setNeedAddReplyIcon(true);
        this.cmX.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.s.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (s.this.akP() != null) {
                    s.this.akP().a(view2, s.this.cYX);
                }
                if (view2 != s.this.cmX.bey && s.this.cYX != null && s.this.cYX.threadData != null) {
                    j.kr(s.this.cYX.threadData.getId());
                    s.this.ku(s.this.cYX.threadData.getId());
                }
            }
        });
        this.cXd = view.findViewById(d.g.divider_line_above_praise);
        this.cYV = view.findViewById(d.g.card_divider_line);
        this.cYW = (TbImageView) view.findViewById(d.g.thread_theme_card);
        this.cYY = (TbImageView) view.findViewById(d.g.frs_normal_item_star_view);
    }

    private void H(final bd bdVar) {
        if (this.cYY != null) {
            if (this.cYW == null || bdVar == null) {
                this.cYY.setVisibility(8);
            } else if (!StringUtils.isNull(bdVar.aQx) && this.cYW.getVisibility() != 0) {
                if (this.cmv != null && this.cmv.getVisibility() == 0 && (this.cYY.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.cYY.getLayoutParams();
                    layoutParams.rightMargin = com.baidu.adp.lib.util.l.t(this.mPageContext.getPageActivity(), d.e.tbds106);
                    this.cYY.setLayoutParams(layoutParams);
                }
                this.cYY.setVisibility(0);
                this.cYY.setImageDrawable(null);
                this.cYY.startLoad(bdVar.aQx, 10, false);
                this.cYY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.s.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (s.this.mPageContext != null) {
                            s.this.mTbPageContext.sendMessage(new CustomMessage(2002001, new ShareWebActivityConfig(s.this.mTbPageContext.getContext(), "", bdVar.aQy, true)));
                        }
                        TiebaStatic.log(new ak("c12883"));
                    }
                });
            } else {
                this.cYY.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.s(getView(), d.f.addresslist_item_bg);
            aj.t(this.cXd, d.C0140d.cp_bg_line_e);
            this.cmk.onChangeSkinType();
            this.cmj.onChangeSkinType();
            if (this.cmv != null) {
                this.cmv.onChangeSkinType();
            }
            this.cYC.onChangeSkinType();
            aj.t(this.cYV, d.C0140d.cp_bg_line_e);
            this.cmX.onChangeSkinType();
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
        this.cYX = beVar;
        bd bdVar = beVar.threadData;
        if (this.cmv != null) {
            SparseArray<String> yo = bdVar.yo();
            if (yo != null && yo.size() > 0 && this.cXg) {
                ah ahVar = new ah();
                ahVar.cV(bdVar.getTid());
                ahVar.setFid(bdVar.getFid());
                ahVar.a(yo);
                this.cmv.setData(ahVar);
                this.cmv.setFirstRowSingleColumn(true);
                this.cmv.setVisibility(J(bdVar) ? 8 : 0);
            } else {
                this.cmv.setVisibility(8);
            }
        }
        if (this.cYX.aQD == 1) {
            this.cmj.setFrom(3);
            K(bdVar);
            H(bdVar);
        }
        this.cmj.setIsFromConcern(this.beP);
        this.cmj.setData(bdVar);
        this.cmj.setUserAfterClickListener(this.bec);
        if (this.cmj.getHeaderImg() != null) {
            if (this.cmj.getIsSimpleThread()) {
                this.cmj.getHeaderImg().setVisibility(8);
                this.cmU.setVisibility(8);
            } else if (bdVar.zn() == null || bdVar.zn().getPendantData() == null || StringUtils.isNull(bdVar.zn().getPendantData().ya())) {
                this.cmU.setVisibility(8);
                this.cmj.getHeaderImg().setVisibility(0);
                this.cmj.getHeaderImg().setData(bdVar);
            } else {
                this.cmj.getHeaderImg().setVisibility(4);
                this.cmU.setVisibility(0);
                this.cmU.setData(bdVar);
            }
        }
        I(bdVar);
        this.cYC.b(bdVar.aQw);
        jX(bdVar.aQz);
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
            j.a(this.mTitle, bdVar.getId(), d.C0140d.cp_cont_b, d.C0140d.cp_cont_d);
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
        if (this.cmv != null) {
            this.cmv.setUniqueId(bdUniqueId);
        }
        if (this.cmj != null) {
            this.cmj.setPageUniqueId(bdUniqueId);
        }
    }

    public void a(c.a aVar) {
        if (this.cmv != null) {
            this.cmv.setEventCallback(aVar);
        }
    }

    public ThreadCommentAndPraiseInfoLayout alu() {
        return this.cmk;
    }

    public ThreadCommentAndPraiseInfoLayout alv() {
        return this.cmX.bez;
    }

    public void eP(boolean z) {
        if (this.cYV != null) {
            this.cYV.setVisibility(z ? 0 : 8);
        }
    }

    public void eL(boolean z) {
        this.cXg = z;
    }

    public void setIsFromConcern(boolean z) {
        this.beP = z;
    }

    private void alj() {
        if (this.cYX != null && this.cYX.threadData != null) {
            bd bdVar = this.cYX.threadData;
            j.kr(bdVar.getId());
            ku(bdVar.getId());
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(bdVar, null, this.cYX.stType, 18003, true, false, false);
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
        j.a(this.mTitle, str, d.C0140d.cp_cont_b, d.C0140d.cp_cont_d);
        j.a(this.cXe, str, d.C0140d.cp_cont_b, d.C0140d.cp_cont_d);
        this.cYC.setReadState(j.ks(str));
    }

    public void K(bd bdVar) {
        MetaData zn;
        if (bdVar != null && this.cYW != null && (zn = bdVar.zn()) != null) {
            final ThemeCardInUserData themeCard = zn.getThemeCard();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                this.cYW.setVisibility(8);
                return;
            }
            this.cYW.setVisibility(0);
            this.cYW.setImageBitmap(null);
            this.cYW.startLoad(themeCard.getCardImageUrlAndroid(), 10, false);
            this.cYW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.s.4
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
            akP().a(view, this.cYX);
        }
        if (view == getView()) {
            alj();
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.cmj != null) {
            return this.cmj.bdX;
        }
        return null;
    }

    public View akS() {
        if (this.cmj != null) {
            return this.cmj.bdY;
        }
        return null;
    }

    public void jX(int i) {
        if (this.cYX != null && this.cYX.threadData != null) {
            if (i == 1) {
                this.cmk.setVisibility(8);
                this.cmX.setFrom(this.cYX.aQC);
                this.cmX.setShareReportFrom(this.cYX.aQD);
                this.cmX.setStType(this.cYX.stType);
                this.cmX.setData(this.cYX.threadData);
                this.cmj.showForumNameView(false);
                return;
            }
            this.cmk.setFrom(this.cYX.aQC);
            this.cmk.setShareReportFrom(this.cYX.aQD);
            this.cmk.setStType(this.cYX.stType);
            this.cmk.setData(this.cYX.threadData);
            this.cmX.setVisibility(8);
            this.cmj.showForumNameView(true);
        }
    }
}
