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
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalCardDetailActivityConfig;
import com.baidu.tbadk.core.atomData.ShareWebActivityConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.ThemeCardInUserData;
import com.baidu.tbadk.core.data.al;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.data.bk;
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
import com.baidu.tieba.R;
import com.baidu.tieba.card.OriginalThreadCardView;
/* loaded from: classes8.dex */
public class t extends a<bk> implements com.baidu.tieba.a.e {
    private TextView adB;
    private String aeB;
    private OriginalThreadCardView.a afp;
    private final View.OnClickListener agl;
    private boolean agw;
    private boolean dJr;
    private String dsL;
    private NEGFeedBackView fsH;
    public ThreadUserInfoLayout fsv;
    public ThreadCommentAndPraiseInfoLayout fsw;
    public ThreadSourceShareAndPraiseLayout fti;
    private HeadPendantClickableView goW;
    private View gpv;
    private boolean gpz;
    public OriginalThreadCardView gqJ;
    private View grc;
    private TbImageView grd;
    private bk gre;
    private TbImageView grf;
    private ViewGroup grg;
    private View mMaskView;
    private TbPageContext<?> mPageContext;
    private TextView mTitle;
    private String mUrl;

    public t(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.fsH = null;
        this.agw = true;
        this.gpz = true;
        this.agl = new View.OnClickListener() { // from class: com.baidu.tieba.card.t.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (t.this.bEw() != null) {
                    t.this.bEw().a(view, t.this.gre);
                }
            }
        };
        this.afp = new OriginalThreadCardView.a() { // from class: com.baidu.tieba.card.t.8
            @Override // com.baidu.tieba.card.OriginalThreadCardView.a
            public void a(OriginalThreadInfo originalThreadInfo) {
                if (t.this.gre != null && t.this.gre.dqE != null) {
                    if (t.this.bEw() != null) {
                        t.this.bEw().a(t.this.gqJ, t.this.gre);
                    }
                    String id = t.this.gre.dqE.getId();
                    l.BE(id);
                    t.this.cW(id);
                }
            }
        };
        this.mPageContext = tbPageContext;
        View view = getView();
        this.grg = (ViewGroup) view.findViewById(R.id.thread_content_layout_outter);
        this.grg.setOnClickListener(this);
        this.goW = (HeadPendantClickableView) view.findViewById(R.id.thread_user_pendant_header);
        if (this.goW.getHeadView() != null) {
            this.goW.getHeadView().setIsRound(true);
            this.goW.getHeadView().setDrawBorder(false);
            this.goW.getHeadView().setDefaultResource(17170445);
            this.goW.getHeadView().setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.goW.getHeadView().setRadius(com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds70));
            this.goW.getHeadView().setPlaceHolder(1);
        }
        this.goW.setHasPendantStyle();
        if (this.goW.getPendantView() != null) {
            this.goW.getPendantView().setIsRound(true);
            this.goW.getPendantView().setDrawBorder(false);
        }
        this.fsv = (ThreadUserInfoLayout) view.findViewById(R.id.thread_user_info_layout);
        this.fsH = new NEGFeedBackView(this.mPageContext);
        this.fsH.a((ViewGroup) getView(), com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds92), com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds16));
        this.mTitle = (TextView) view.findViewById(R.id.thread_title);
        this.adB = (TextView) view.findViewById(R.id.thread_abstract);
        this.gqJ = (OriginalThreadCardView) view.findViewById(R.id.original_thread_view);
        this.gqJ.setSubClickListener(this.afp);
        this.fsw = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.thread_comment_layout);
        if (this.fsw.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fsw.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.fsw.setLayoutParams(layoutParams);
        }
        view.setOnClickListener(this);
        this.fsw.setOnClickListener(this);
        this.fsw.setReplyTimeVisible(false);
        this.fsw.setShowPraiseNum(true);
        this.fsw.setNeedAddPraiseIcon(true);
        this.fsw.setNeedAddReplyIcon(true);
        this.fsw.setShareVisible(true);
        this.fsw.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.t.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (t.this.bEw() != null) {
                    t.this.bEw().a(view2, t.this.gre);
                }
                if (t.this.gre != null && t.this.gre.dqE != null) {
                    l.BE(t.this.gre.dqE.getId());
                    t.this.cW(t.this.gre.dqE.getId());
                }
            }
        });
        this.fti = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.card_transmit_source_read_share_layout);
        this.fti.dJe.setOnClickListener(this);
        this.fti.dJe.setNeedAddReplyIcon(true);
        this.fti.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.t.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (t.this.bEw() != null) {
                    t.this.bEw().a(view2, t.this.gre);
                }
                if (view2 != t.this.fti.dIt && t.this.gre != null && t.this.gre.dqE != null) {
                    l.BE(t.this.gre.dqE.getId());
                    t.this.cW(t.this.gre.dqE.getId());
                }
            }
        });
        this.gpv = view.findViewById(R.id.divider_line_above_praise);
        this.grc = view.findViewById(R.id.card_divider_line);
        this.grd = (TbImageView) view.findViewById(R.id.thread_theme_card);
        this.grf = (TbImageView) view.findViewById(R.id.frs_normal_item_star_view);
        this.mMaskView = view.findViewById(R.id.thread_multi_del_mask_view);
        this.mMaskView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.t.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                t.this.fsw.changeSelectStatus();
            }
        });
        this.fsw.setOnSelectStatusChangeListener(new ThreadCommentAndPraiseInfoLayout.b() { // from class: com.baidu.tieba.card.t.4
            @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.b
            public void gS(boolean z) {
                am.setBackgroundColor(t.this.mMaskView, z ? R.color.cp_bg_line_d : R.color.transparent);
            }
        });
    }

    private void Y(final bj bjVar) {
        if (this.grf != null) {
            if (this.grd == null || bjVar == null) {
                this.grf.setVisibility(8);
            } else if (!StringUtils.isNull(bjVar.dtu) && this.grd.getVisibility() != 0) {
                if (this.fsH != null && this.fsH.getVisibility() == 0 && (this.grf.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.grf.getLayoutParams();
                    layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds106);
                    this.grf.setLayoutParams(layoutParams);
                }
                this.grf.setVisibility(0);
                this.grf.setImageDrawable(null);
                this.grf.startLoad(bjVar.dtu, 10, false);
                this.grf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.t.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (t.this.mPageContext != null) {
                            t.this.mTbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ShareWebActivityConfig(t.this.mTbPageContext.getContext(), "", bjVar.dtv, true)));
                        }
                        TiebaStatic.log(new an(CommonStatisticKey.KEY_FRS_STAR_PIC_CLICK));
                    }
                });
            } else {
                this.grf.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(getView(), R.drawable.addresslist_item_bg);
            am.setBackgroundColor(this.gpv, R.color.cp_bg_line_c);
            this.fsw.onChangeSkinType();
            this.fsv.onChangeSkinType();
            if (this.fsH != null) {
                this.fsH.onChangeSkinType();
            }
            this.gqJ.onChangeSkinType();
            am.setBackgroundColor(this.grc, R.color.cp_bg_line_e);
            this.fti.onChangeSkinType();
        }
        if (this.gre != null && this.gre.dqE != null) {
            am.setBackgroundColor(this.mMaskView, this.gre.dqE.aMl() ? R.color.cp_bg_line_d : R.color.transparent);
        }
        if (this.goW != null && this.goW.getHeadView() != null && (this.goW.getHeadView() instanceof TbImageView)) {
            this.goW.getHeadView().setPlaceHolder(1);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.card_transmit_thread_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(bk bkVar) {
        if (bkVar == null || bkVar.dqE == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        if (getView() != null) {
            getView().setVisibility(0);
        }
        this.gre = bkVar;
        bj bjVar = bkVar.dqE;
        if (this.fsH != null) {
            SparseArray<String> feedBackReasonMap = bjVar.getFeedBackReasonMap();
            if (feedBackReasonMap != null && feedBackReasonMap.size() > 0 && this.gpz) {
                al alVar = new al();
                alVar.setTid(bjVar.getTid());
                alVar.setFid(bjVar.getFid());
                alVar.setFeedBackReasonMap(feedBackReasonMap);
                this.fsH.setData(alVar);
                this.fsH.setFirstRowSingleColumn(true);
                this.fsH.setVisibility(aa(bjVar) ? 8 : 0);
            } else {
                this.fsH.setVisibility(8);
            }
        }
        if (this.gre.due == 1) {
            this.fsv.setFrom(3);
            b(bjVar);
            Y(bjVar);
        }
        this.fsv.setIsFromConcern(this.dJr);
        this.fsv.setData(bjVar);
        this.fsv.setUserAfterClickListener(this.agl);
        if (this.fsv.getHeaderImg() != null) {
            if (this.fsv.getIsSimpleThread()) {
                this.fsv.getHeaderImg().setVisibility(8);
                this.goW.setVisibility(8);
            } else if (bjVar.aKC() == null || bjVar.aKC().getPendantData() == null || StringUtils.isNull(bjVar.aKC().getPendantData().aIU())) {
                this.goW.setVisibility(8);
                this.fsv.getHeaderImg().setVisibility(0);
                this.fsv.getHeaderImg().setData(bjVar);
            } else {
                this.fsv.getHeaderImg().setVisibility(4);
                this.goW.setVisibility(0);
                this.goW.setData(bjVar);
            }
        }
        Z(bjVar);
        this.gqJ.b(bjVar.dtt);
        pX(or(1));
        setPageUniqueId(getTag());
        onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        cW(bjVar.getId());
        if (this.fsw.isInFrsAllThread() && com.baidu.tieba.frs.a.bNB().bNC()) {
            this.mMaskView.setVisibility(0);
            if (bjVar.aMl() || bjVar.aMm()) {
                am.setBackgroundColor(this.mMaskView, R.color.cp_bg_line_d);
                return;
            } else {
                this.mMaskView.setBackgroundResource(R.color.transparent);
                return;
            }
        }
        this.mMaskView.setVisibility(8);
    }

    private void Z(bj bjVar) {
        if (bjVar != null) {
            if (!StringUtils.isNull(this.mUrl) && !StringUtils.isNull(this.dsL)) {
                bjVar.cz(this.mUrl, this.dsL);
            }
            SpannableStringBuilder u = bjVar.u(false, true);
            if (u == null || StringUtils.isNull(u.toString())) {
                this.mTitle.setVisibility(8);
                return;
            }
            this.mTitle.setVisibility(0);
            this.mTitle.setOnTouchListener(new com.baidu.tieba.view.i(u));
            this.mTitle.setText(u);
            l.a(this.mTitle, bjVar.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
        }
    }

    private boolean aa(bj bjVar) {
        if (bjVar == null || bjVar.aKC() == null || StringUtils.isNull(bjVar.aKC().getUserId())) {
            return false;
        }
        return bjVar.aKC().getUserId().equals(TbadkCoreApplication.getCurrentAccount());
    }

    public void m(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.fsH != null) {
            this.fsH.setUniqueId(bdUniqueId);
        }
        if (this.fsv != null) {
            this.fsv.setPageUniqueId(bdUniqueId);
        }
    }

    public void ly(boolean z) {
        if (this.grc != null) {
            this.grc.setVisibility(z ? 0 : 8);
        }
    }

    public void lt(boolean z) {
        this.gpz = z;
    }

    private void aUY() {
        if (this.gre != null && this.gre.dqE != null) {
            bj bjVar = this.gre.dqE;
            l.BE(bjVar.getId());
            cW(bjVar.getId());
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(bjVar, null, this.gre.stType, RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false);
            createFromThreadCfg.setStartFrom(this.currentPageType);
            createFromThreadCfg.setIsShareThread(true);
            l.BE(bjVar.getTid());
            this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cW(String str) {
        l.a(this.mTitle, str, (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
        l.a(this.adB, str, (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
        this.gqJ.setReadState(l.BF(str));
    }

    public void b(bj bjVar) {
        MetaData aKC;
        if (bjVar != null && this.grd != null && (aKC = bjVar.aKC()) != null) {
            final ThemeCardInUserData themeCard = aKC.getThemeCard();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                this.grd.setVisibility(8);
                return;
            }
            this.grd.setVisibility(0);
            this.grd.setImageBitmap(null);
            this.grd.startLoad(themeCard.getCardImageUrlAndroid(), 10, false);
            this.grd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.t.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonalCardDetailActivityConfig(t.this.mPageContext.getPageActivity(), themeCard.getCardId())));
                }
            });
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (bEw() != null) {
            bEw().a(view, this.gre);
        }
        if (view == getView() || view.getId() == R.id.thread_content_layout_outter) {
            aUY();
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.fsv != null) {
            return this.fsv.dIN;
        }
        return null;
    }

    public View bEB() {
        if (this.fsv != null) {
            return this.fsv.afZ;
        }
        return null;
    }

    public void pX(int i) {
        if (this.gre != null && this.gre.dqE != null) {
            if (i == 1) {
                this.fsw.setVisibility(8);
                this.fti.setFrom(this.gre.dud);
                this.fti.setShareReportFrom(this.gre.due);
                this.fti.setStType(this.gre.stType);
                this.fti.setData(this.gre.dqE);
                this.fsv.gQ(false);
                return;
            }
            this.fsw.setFrom(this.gre.dud);
            this.fsw.setShareReportFrom(this.gre.due);
            this.fsw.setStType(this.gre.stType);
            this.fsw.setData(this.gre.dqE);
            this.fsw.setDisPraiseFrom(this.gre.duf);
            this.fti.setVisibility(8);
            this.fsv.gQ(true);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.aeB = str;
    }

    public int or(int i) {
        return com.baidu.tieba.a.d.bfN().ar(this.aeB, i);
    }
}
