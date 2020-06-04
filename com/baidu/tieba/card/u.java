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
import com.baidu.tbadk.core.data.ak;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.data.bl;
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
public class u extends b<bl> implements com.baidu.tieba.a.e {
    private TextView adV;
    private String aeX;
    private OriginalThreadCardView.a afM;
    private final View.OnClickListener agI;
    private boolean aha;
    private String dGF;
    private boolean dXG;
    private NEGFeedBackView fGK;
    public ThreadUserInfoLayout fGy;
    public ThreadCommentAndPraiseInfoLayout fGz;
    public ThreadSourceShareAndPraiseLayout fHl;
    private HeadPendantClickableView gDX;
    private View gEv;
    private boolean gEz;
    public OriginalThreadCardView gFJ;
    private View gGc;
    private TbImageView gGd;
    private bl gGe;
    private TbImageView gGf;
    private ViewGroup gGg;
    private View mMaskView;
    private TbPageContext<?> mPageContext;
    private TextView mTitle;
    private String mUrl;

    public u(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.fGK = null;
        this.aha = true;
        this.gEz = true;
        this.agI = new View.OnClickListener() { // from class: com.baidu.tieba.card.u.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (u.this.bKU() != null) {
                    u.this.bKU().a(view, u.this.gGe);
                }
            }
        };
        this.afM = new OriginalThreadCardView.a() { // from class: com.baidu.tieba.card.u.8
            @Override // com.baidu.tieba.card.OriginalThreadCardView.a
            public void a(OriginalThreadInfo originalThreadInfo) {
                if (u.this.gGe != null && u.this.gGe.dEA != null) {
                    if (u.this.bKU() != null) {
                        u.this.bKU().a(u.this.gFJ, u.this.gGe);
                    }
                    String id = u.this.gGe.dEA.getId();
                    m.Dn(id);
                    u.this.cX(id);
                }
            }
        };
        this.mPageContext = tbPageContext;
        View view = getView();
        this.gGg = (ViewGroup) view.findViewById(R.id.thread_content_layout_outter);
        this.gGg.setOnClickListener(this);
        this.gDX = (HeadPendantClickableView) view.findViewById(R.id.thread_user_pendant_header);
        if (this.gDX.getHeadView() != null) {
            this.gDX.getHeadView().setIsRound(true);
            this.gDX.getHeadView().setDrawBorder(false);
            this.gDX.getHeadView().setDefaultResource(17170445);
            this.gDX.getHeadView().setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.gDX.getHeadView().setRadius(com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds70));
            this.gDX.getHeadView().setPlaceHolder(1);
        }
        this.gDX.setHasPendantStyle();
        if (this.gDX.getPendantView() != null) {
            this.gDX.getPendantView().setIsRound(true);
            this.gDX.getPendantView().setDrawBorder(false);
        }
        this.fGy = (ThreadUserInfoLayout) view.findViewById(R.id.thread_user_info_layout);
        this.fGK = new NEGFeedBackView(this.mPageContext);
        this.fGK.a((ViewGroup) getView(), com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds92), com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds16));
        this.mTitle = (TextView) view.findViewById(R.id.thread_title);
        this.adV = (TextView) view.findViewById(R.id.thread_abstract);
        this.gFJ = (OriginalThreadCardView) view.findViewById(R.id.original_thread_view);
        this.gFJ.setSubClickListener(this.afM);
        this.fGz = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.thread_comment_layout);
        if (this.fGz.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fGz.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.fGz.setLayoutParams(layoutParams);
        }
        view.setOnClickListener(this);
        this.fGz.setOnClickListener(this);
        this.fGz.setReplyTimeVisible(false);
        this.fGz.setShowPraiseNum(true);
        this.fGz.setNeedAddPraiseIcon(true);
        this.fGz.setNeedAddReplyIcon(true);
        this.fGz.setShareVisible(true);
        this.fGz.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.u.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (u.this.bKU() != null) {
                    u.this.bKU().a(view2, u.this.gGe);
                }
                if (u.this.gGe != null && u.this.gGe.dEA != null) {
                    m.Dn(u.this.gGe.dEA.getId());
                    u.this.cX(u.this.gGe.dEA.getId());
                }
            }
        });
        this.fHl = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.card_transmit_source_read_share_layout);
        this.fHl.dXt.setOnClickListener(this);
        this.fHl.dXt.setNeedAddReplyIcon(true);
        this.fHl.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.u.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (u.this.bKU() != null) {
                    u.this.bKU().a(view2, u.this.gGe);
                }
                if (view2 != u.this.fHl.dWI && u.this.gGe != null && u.this.gGe.dEA != null) {
                    m.Dn(u.this.gGe.dEA.getId());
                    u.this.cX(u.this.gGe.dEA.getId());
                }
            }
        });
        this.gEv = view.findViewById(R.id.divider_line_above_praise);
        this.gGc = view.findViewById(R.id.card_divider_line);
        this.gGd = (TbImageView) view.findViewById(R.id.thread_theme_card);
        this.gGf = (TbImageView) view.findViewById(R.id.frs_normal_item_star_view);
        this.mMaskView = view.findViewById(R.id.thread_multi_del_mask_view);
        this.mMaskView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.u.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                u.this.fGz.changeSelectStatus();
            }
        });
        this.fGz.setOnSelectStatusChangeListener(new ThreadCommentAndPraiseInfoLayout.b() { // from class: com.baidu.tieba.card.u.4
            @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.b
            public void hp(boolean z) {
                am.setBackgroundColor(u.this.mMaskView, z ? R.color.cp_bg_line_d : R.color.transparent);
            }
        });
    }

    private void Z(final bk bkVar) {
        if (this.gGf != null) {
            if (this.gGd == null || bkVar == null) {
                this.gGf.setVisibility(8);
            } else if (!StringUtils.isNull(bkVar.dHn) && this.gGd.getVisibility() != 0) {
                if (this.fGK != null && this.fGK.getVisibility() == 0 && (this.gGf.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gGf.getLayoutParams();
                    layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds106);
                    this.gGf.setLayoutParams(layoutParams);
                }
                this.gGf.setVisibility(0);
                this.gGf.setImageDrawable(null);
                this.gGf.startLoad(bkVar.dHn, 10, false);
                this.gGf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.u.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (u.this.mPageContext != null) {
                            u.this.mTbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ShareWebActivityConfig(u.this.mTbPageContext.getContext(), "", bkVar.dHo, true)));
                        }
                        TiebaStatic.log(new an(CommonStatisticKey.KEY_FRS_STAR_PIC_CLICK));
                    }
                });
            } else {
                this.gGf.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(getView(), R.drawable.addresslist_item_bg);
            am.setBackgroundColor(this.gEv, R.color.cp_bg_line_c);
            this.fGz.onChangeSkinType();
            this.fGy.onChangeSkinType();
            if (this.fGK != null) {
                this.fGK.onChangeSkinType();
            }
            this.gFJ.onChangeSkinType();
            am.setBackgroundColor(this.gGc, R.color.cp_bg_line_e);
            this.fHl.onChangeSkinType();
        }
        if (this.gGe != null && this.gGe.dEA != null) {
            am.setBackgroundColor(this.mMaskView, this.gGe.dEA.aSk() ? R.color.cp_bg_line_d : R.color.transparent);
        }
        if (this.gDX != null && this.gDX.getHeadView() != null && (this.gDX.getHeadView() instanceof TbImageView)) {
            this.gDX.getHeadView().setPlaceHolder(1);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.card_transmit_thread_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(bl blVar) {
        if (blVar == null || blVar.dEA == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        if (getView() != null) {
            getView().setVisibility(0);
        }
        this.gGe = blVar;
        bk bkVar = blVar.dEA;
        if (this.fGK != null) {
            SparseArray<String> feedBackReasonMap = bkVar.getFeedBackReasonMap();
            if (feedBackReasonMap != null && feedBackReasonMap.size() > 0 && this.gEz) {
                ak akVar = new ak();
                akVar.setTid(bkVar.getTid());
                akVar.setFid(bkVar.getFid());
                akVar.setNid(bkVar.getNid());
                akVar.setFeedBackReasonMap(feedBackReasonMap);
                this.fGK.setData(akVar);
                this.fGK.setFirstRowSingleColumn(true);
                this.fGK.setVisibility(ab(bkVar) ? 8 : 0);
            } else {
                this.fGK.setVisibility(8);
            }
        }
        if (this.gGe.dHZ == 1) {
            this.fGy.setFrom(3);
            b(bkVar);
            Z(bkVar);
        }
        this.fGy.setIsFromConcern(this.dXG);
        this.fGy.setData(bkVar);
        this.fGy.setUserAfterClickListener(this.agI);
        if (this.fGy.getHeaderImg() != null) {
            if (this.fGy.getIsSimpleThread()) {
                this.fGy.getHeaderImg().setVisibility(8);
                this.gDX.setVisibility(8);
            } else if (bkVar.aQx() == null || bkVar.aQx().getPendantData() == null || StringUtils.isNull(bkVar.aQx().getPendantData().aOP())) {
                this.gDX.setVisibility(8);
                this.fGy.getHeaderImg().setVisibility(0);
                this.fGy.getHeaderImg().setData(bkVar);
            } else {
                this.fGy.getHeaderImg().setVisibility(4);
                this.gDX.setVisibility(0);
                this.gDX.setData(bkVar);
            }
        }
        aa(bkVar);
        this.gFJ.b(bkVar.dHm);
        qA(pa(1));
        setPageUniqueId(getTag());
        onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        cX(bkVar.getId());
        if (this.fGz.isInFrsAllThread() && com.baidu.tieba.frs.a.bTZ().bUa()) {
            this.mMaskView.setVisibility(0);
            if (bkVar.aSk() || bkVar.aSl()) {
                am.setBackgroundColor(this.mMaskView, R.color.cp_bg_line_d);
                return;
            } else {
                this.mMaskView.setBackgroundResource(R.color.transparent);
                return;
            }
        }
        this.mMaskView.setVisibility(8);
    }

    private void aa(bk bkVar) {
        if (bkVar != null) {
            if (!StringUtils.isNull(this.mUrl) && !StringUtils.isNull(this.dGF)) {
                bkVar.cY(this.mUrl, this.dGF);
            }
            SpannableStringBuilder x = bkVar.x(false, true);
            if (x == null || StringUtils.isNull(x.toString())) {
                this.mTitle.setVisibility(8);
                return;
            }
            this.mTitle.setVisibility(0);
            this.mTitle.setOnTouchListener(new com.baidu.tieba.view.i(x));
            this.mTitle.setText(x);
            m.a(this.mTitle, bkVar.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
        }
    }

    private boolean ab(bk bkVar) {
        if (bkVar == null || bkVar.aQx() == null || StringUtils.isNull(bkVar.aQx().getUserId())) {
            return false;
        }
        return bkVar.aQx().getUserId().equals(TbadkCoreApplication.getCurrentAccount());
    }

    public void o(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.fGK != null) {
            this.fGK.setUniqueId(bdUniqueId);
        }
        if (this.fGy != null) {
            this.fGy.setPageUniqueId(bdUniqueId);
        }
    }

    public void lU(boolean z) {
        if (this.gGc != null) {
            this.gGc.setVisibility(z ? 0 : 8);
        }
    }

    public void lP(boolean z) {
        this.gEz = z;
    }

    private void bbj() {
        if (this.gGe != null && this.gGe.dEA != null) {
            bk bkVar = this.gGe.dEA;
            m.Dn(bkVar.getId());
            cX(bkVar.getId());
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(bkVar, null, this.gGe.stType, RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false);
            createFromThreadCfg.setStartFrom(this.currentPageType);
            createFromThreadCfg.setIsShareThread(true);
            m.Dn(bkVar.getTid());
            this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cX(String str) {
        m.a(this.mTitle, str, (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
        m.a(this.adV, str, (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
        this.gFJ.setReadState(m.Do(str));
    }

    public void b(bk bkVar) {
        MetaData aQx;
        if (bkVar != null && this.gGd != null && (aQx = bkVar.aQx()) != null) {
            final ThemeCardInUserData themeCard = aQx.getThemeCard();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                this.gGd.setVisibility(8);
                return;
            }
            this.gGd.setVisibility(0);
            this.gGd.setImageBitmap(null);
            this.gGd.startLoad(themeCard.getCardImageUrlAndroid(), 10, false);
            this.gGd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.u.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonalCardDetailActivityConfig(u.this.mPageContext.getPageActivity(), themeCard.getCardId())));
                }
            });
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (bKU() != null) {
            bKU().a(view, this.gGe);
        }
        if (view == getView() || view.getId() == R.id.thread_content_layout_outter) {
            bbj();
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.fGy != null) {
            return this.fGy.dXc;
        }
        return null;
    }

    public View bKY() {
        if (this.fGy != null) {
            return this.fGy.agw;
        }
        return null;
    }

    public void qA(int i) {
        if (this.gGe != null && this.gGe.dEA != null) {
            if (i == 1) {
                this.fGz.setVisibility(8);
                this.fHl.setFrom(this.gGe.dHY);
                this.fHl.setShareReportFrom(this.gGe.dHZ);
                this.fHl.setStType(this.gGe.stType);
                this.fHl.setData(this.gGe.dEA);
                this.fGy.hq(false);
                return;
            }
            this.fGz.setFrom(this.gGe.dHY);
            this.fGz.setShareReportFrom(this.gGe.dHZ);
            this.fGz.setStType(this.gGe.stType);
            this.fGz.setData(this.gGe.dEA);
            this.fGz.setDisPraiseFrom(this.gGe.dIa);
            this.fHl.setVisibility(8);
            this.fGy.hq(true);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.aeX = str;
    }

    public int pa(int i) {
        return com.baidu.tieba.a.d.bmb().as(this.aeX, i);
    }
}
