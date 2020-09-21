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
import com.baidu.tbadk.core.data.ar;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadSourceShareAndPraiseLayout;
import com.baidu.tbadk.core.view.ThreadUserInfoLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.OriginalThreadCardView;
/* loaded from: classes20.dex */
public class u extends b<bx> implements com.baidu.tieba.a.e {
    private TextView afT;
    private OriginalThreadCardView.a ahS;
    private String ahc;
    private boolean ajR;
    private final View.OnClickListener ajn;
    private String efl;
    private boolean exp;
    public ThreadSourceShareAndPraiseLayout gmX;
    public ThreadUserInfoLayout gmk;
    public ThreadCommentAndPraiseInfoLayout gml;
    private NEGFeedBackView gmw;
    private View hqQ;
    private boolean hqU;
    private HeadPendantClickableView hqt;
    private View hsA;
    private TbImageView hsB;
    private bx hsC;
    private TbImageView hsD;
    private ViewGroup hsE;
    public OriginalThreadCardView hsh;
    private View mMaskView;
    private TbPageContext<?> mPageContext;
    private TextView mTitle;
    private String mUrl;

    public u(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.gmw = null;
        this.ajR = true;
        this.hqU = true;
        this.ajn = new View.OnClickListener() { // from class: com.baidu.tieba.card.u.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (u.this.ceP() != null) {
                    u.this.ceP().a(view, u.this.hsC);
                }
            }
        };
        this.ahS = new OriginalThreadCardView.a() { // from class: com.baidu.tieba.card.u.8
            @Override // com.baidu.tieba.card.OriginalThreadCardView.a
            public void a(OriginalThreadInfo originalThreadInfo) {
                if (u.this.hsC != null && u.this.hsC.dXg != null) {
                    if (u.this.ceP() != null) {
                        u.this.ceP().a(u.this.hsh, u.this.hsC);
                    }
                    String id = u.this.hsC.dXg.getId();
                    m.Hw(id);
                    u.this.dk(id);
                }
            }
        };
        this.mPageContext = tbPageContext;
        View view = getView();
        this.hsE = (ViewGroup) view.findViewById(R.id.thread_content_layout_outter);
        this.hsE.setOnClickListener(this);
        this.hqt = (HeadPendantClickableView) view.findViewById(R.id.thread_user_pendant_header);
        if (this.hqt.getHeadView() != null) {
            this.hqt.getHeadView().setIsRound(true);
            this.hqt.getHeadView().setDrawBorder(false);
            this.hqt.getHeadView().setDefaultResource(17170445);
            this.hqt.getHeadView().setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.hqt.getHeadView().setRadius(com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds70));
            this.hqt.getHeadView().setPlaceHolder(1);
        }
        this.hqt.setHasPendantStyle();
        if (this.hqt.getPendantView() != null) {
            this.hqt.getPendantView().setIsRound(true);
            this.hqt.getPendantView().setDrawBorder(false);
        }
        this.gmk = (ThreadUserInfoLayout) view.findViewById(R.id.thread_user_info_layout);
        this.gmw = new NEGFeedBackView(this.mPageContext);
        this.gmw.a((ViewGroup) getView(), com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds92), com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds16));
        this.mTitle = (TextView) view.findViewById(R.id.thread_title);
        this.afT = (TextView) view.findViewById(R.id.thread_abstract);
        this.hsh = (OriginalThreadCardView) view.findViewById(R.id.original_thread_view);
        this.hsh.setSubClickListener(this.ahS);
        this.gml = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.thread_comment_layout);
        if (this.gml.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gml.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.gml.setLayoutParams(layoutParams);
        }
        view.setOnClickListener(this);
        this.gml.setOnClickListener(this);
        this.gml.setReplyTimeVisible(false);
        this.gml.setShowPraiseNum(true);
        this.gml.setNeedAddPraiseIcon(true);
        this.gml.setNeedAddReplyIcon(true);
        this.gml.setShareVisible(true);
        this.gml.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.u.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (u.this.ceP() != null) {
                    u.this.ceP().a(view2, u.this.hsC);
                }
                if (u.this.hsC != null && u.this.hsC.dXg != null) {
                    m.Hw(u.this.hsC.dXg.getId());
                    u.this.dk(u.this.hsC.dXg.getId());
                }
            }
        });
        this.gmX = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.card_transmit_source_read_share_layout);
        this.gmX.exc.setOnClickListener(this);
        this.gmX.exc.setNeedAddReplyIcon(true);
        this.gmX.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.u.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (u.this.ceP() != null) {
                    u.this.ceP().a(view2, u.this.hsC);
                }
                if (view2 != u.this.gmX.ewr && u.this.hsC != null && u.this.hsC.dXg != null) {
                    m.Hw(u.this.hsC.dXg.getId());
                    u.this.dk(u.this.hsC.dXg.getId());
                }
            }
        });
        this.hqQ = view.findViewById(R.id.divider_line_above_praise);
        this.hsA = view.findViewById(R.id.card_divider_line);
        this.hsB = (TbImageView) view.findViewById(R.id.thread_theme_card);
        this.hsD = (TbImageView) view.findViewById(R.id.frs_normal_item_star_view);
        this.mMaskView = view.findViewById(R.id.thread_multi_del_mask_view);
        this.mMaskView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.u.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                u.this.gml.changeSelectStatus();
            }
        });
        this.gml.setOnSelectStatusChangeListener(new ThreadCommentAndPraiseInfoLayout.b() { // from class: com.baidu.tieba.card.u.4
            @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.b
            public void iy(boolean z) {
                ap.setBackgroundColor(u.this.mMaskView, z ? R.color.cp_bg_line_d : R.color.transparent);
            }
        });
    }

    private void Y(final bw bwVar) {
        if (this.hsD != null) {
            if (this.hsB == null || bwVar == null) {
                this.hsD.setVisibility(8);
            } else if (!StringUtils.isNull(bwVar.efT) && this.hsB.getVisibility() != 0) {
                if (this.gmw != null && this.gmw.getVisibility() == 0 && (this.hsD.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hsD.getLayoutParams();
                    layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds106);
                    this.hsD.setLayoutParams(layoutParams);
                }
                this.hsD.setVisibility(0);
                this.hsD.setImageDrawable(null);
                this.hsD.startLoad(bwVar.efT, 10, false);
                this.hsD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.u.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (u.this.mPageContext != null) {
                            u.this.mTbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ShareWebActivityConfig(u.this.mTbPageContext.getContext(), "", bwVar.efU, true)));
                        }
                        TiebaStatic.log(new aq(CommonStatisticKey.KEY_FRS_STAR_PIC_CLICK));
                    }
                });
            } else {
                this.hsD.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(getView(), R.drawable.addresslist_item_bg);
            ap.setBackgroundColor(this.hqQ, R.color.cp_bg_line_c);
            this.gml.onChangeSkinType();
            this.gmk.onChangeSkinType();
            if (this.gmw != null) {
                this.gmw.onChangeSkinType();
            }
            this.hsh.onChangeSkinType();
            ap.setBackgroundColor(this.hsA, R.color.cp_bg_line_e);
            this.gmX.onChangeSkinType();
        }
        if (this.hsC != null && this.hsC.dXg != null) {
            ap.setBackgroundColor(this.mMaskView, (this.hsC.dXg.bhj() || this.hsC.dXg.bhk()) ? R.color.cp_bg_line_d : R.color.transparent);
        }
        if (this.hqt != null && this.hqt.getHeadView() != null && (this.hqt.getHeadView() instanceof TbImageView)) {
            this.hqt.getHeadView().setPlaceHolder(1);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.card_transmit_thread_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(bx bxVar) {
        if (bxVar == null || bxVar.dXg == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        if (getView() != null) {
            getView().setVisibility(0);
        }
        this.hsC = bxVar;
        bw bwVar = bxVar.dXg;
        if (this.gmw != null) {
            SparseArray<String> feedBackReasonMap = bwVar.getFeedBackReasonMap();
            if (feedBackReasonMap != null && feedBackReasonMap.size() > 0 && this.hqU) {
                ar arVar = new ar();
                arVar.setTid(bwVar.getTid());
                arVar.setFid(bwVar.getFid());
                arVar.setNid(bwVar.getNid());
                arVar.setFeedBackReasonMap(feedBackReasonMap);
                arVar.ebl = bwVar.ebl;
                this.gmw.setData(arVar);
                this.gmw.setFirstRowSingleColumn(true);
                this.gmw.setVisibility(aa(bwVar) ? 8 : 0);
            } else {
                this.gmw.setVisibility(8);
            }
        }
        if (this.hsC.egT == 1) {
            this.gmk.setFrom(3);
            b(bwVar);
            Y(bwVar);
        }
        this.gmk.setIsFromConcern(this.exp);
        this.gmk.setData(bwVar);
        this.gmk.setUserAfterClickListener(this.ajn);
        if (this.gmk.getHeaderImg() != null) {
            if (this.gmk.getIsSimpleThread()) {
                this.gmk.getHeaderImg().setVisibility(8);
                this.hqt.setVisibility(8);
            } else if (bwVar.bfy() == null || bwVar.bfy().getPendantData() == null || StringUtils.isNull(bwVar.bfy().getPendantData().bdu())) {
                this.hqt.setVisibility(8);
                this.gmk.getHeaderImg().setVisibility(0);
                this.gmk.getHeaderImg().setData(bwVar);
            } else {
                this.gmk.getHeaderImg().setVisibility(4);
                this.hqt.setVisibility(0);
                this.hqt.setData(bwVar);
            }
        }
        Z(bwVar);
        this.hsh.b(bwVar.efS);
        tU(sq(1));
        setPageUniqueId(getTag());
        onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        dk(bwVar.getId());
        if (this.gml.isInFrsAllThread() && (com.baidu.tieba.frs.b.cog().coa() || com.baidu.tieba.frs.a.cnZ().coa())) {
            this.mMaskView.setVisibility(0);
            if (bwVar.bhj() || bwVar.bhk() || bwVar.bhl()) {
                ap.setBackgroundColor(this.mMaskView, R.color.cp_bg_line_d);
                return;
            } else {
                this.mMaskView.setBackgroundResource(R.color.transparent);
                return;
            }
        }
        this.mMaskView.setVisibility(8);
    }

    private void Z(bw bwVar) {
        if (bwVar != null) {
            if (!StringUtils.isNull(this.mUrl) && !StringUtils.isNull(this.efl)) {
                bwVar.du(this.mUrl, this.efl);
            }
            SpannableStringBuilder B = bwVar.B(false, true);
            if (B == null || StringUtils.isNull(B.toString())) {
                this.mTitle.setVisibility(8);
                return;
            }
            this.mTitle.setVisibility(0);
            this.mTitle.setOnTouchListener(new com.baidu.tieba.view.i(B));
            this.mTitle.setText(B);
            m.a(this.mTitle, bwVar.getId(), R.color.cp_cont_b, R.color.cp_cont_d);
        }
    }

    private boolean aa(bw bwVar) {
        if (bwVar == null || bwVar.bfy() == null || StringUtils.isNull(bwVar.bfy().getUserId())) {
            return false;
        }
        return bwVar.bfy().getUserId().equals(TbadkCoreApplication.getCurrentAccount());
    }

    public void o(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.gmw != null) {
            this.gmw.setUniqueId(bdUniqueId);
        }
        if (this.gmk != null) {
            this.gmk.setPageUniqueId(bdUniqueId);
        }
    }

    public void nt(boolean z) {
        if (this.hsA != null) {
            this.hsA.setVisibility(z ? 0 : 8);
        }
    }

    public void no(boolean z) {
        this.hqU = z;
    }

    private void bqz() {
        if (this.hsC != null && this.hsC.dXg != null) {
            bw bwVar = this.hsC.dXg;
            m.Hw(bwVar.getId());
            dk(bwVar.getId());
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(bwVar, null, this.hsC.stType, RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false);
            createFromThreadCfg.setStartFrom(this.currentPageType);
            createFromThreadCfg.setIsShareThread(true);
            m.Hw(bwVar.getTid());
            this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dk(String str) {
        m.a(this.mTitle, str, R.color.cp_cont_b, R.color.cp_cont_d);
        m.a(this.afT, str, R.color.cp_cont_b, R.color.cp_cont_d);
        this.hsh.setReadState(m.Hx(str));
    }

    public void b(bw bwVar) {
        MetaData bfy;
        if (bwVar != null && this.hsB != null && (bfy = bwVar.bfy()) != null) {
            final ThemeCardInUserData themeCard = bfy.getThemeCard();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                this.hsB.setVisibility(8);
                return;
            }
            this.hsB.setVisibility(0);
            this.hsB.setImageBitmap(null);
            this.hsB.startLoad(themeCard.getCardImageUrlAndroid(), 10, false);
            this.hsB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.u.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonalCardDetailActivityConfig(u.this.mPageContext.getPageActivity(), themeCard.getCardId())));
                }
            });
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (ceP() != null) {
            ceP().a(view, this.hsC);
        }
        if (view == getView() || view.getId() == R.id.thread_content_layout_outter) {
            bqz();
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.gmk != null) {
            return this.gmk.ewL;
        }
        return null;
    }

    public View ceT() {
        if (this.gmk != null) {
            return this.gmk.ajb;
        }
        return null;
    }

    public void tU(int i) {
        if (this.hsC != null && this.hsC.dXg != null) {
            if (i == 1) {
                this.gml.setVisibility(8);
                this.gmX.setFrom(this.hsC.egS);
                this.gmX.setShareReportFrom(this.hsC.egT);
                this.gmX.setStType(this.hsC.stType);
                this.gmX.setData(this.hsC.dXg);
                this.gmk.iz(false);
                return;
            }
            this.gml.setFrom(this.hsC.egS);
            this.gml.setShareReportFrom(this.hsC.egT);
            this.gml.setStType(this.hsC.stType);
            this.gml.setData(this.hsC.dXg);
            this.gml.setDisPraiseFrom(this.hsC.egU);
            this.gmX.setVisibility(8);
            this.gmk.iz(true);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.ahc = str;
    }

    public int sq(int i) {
        return com.baidu.tieba.a.d.bBN().au(this.ahc, i);
    }
}
