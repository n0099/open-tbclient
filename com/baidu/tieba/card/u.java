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
/* loaded from: classes15.dex */
public class u extends b<bx> implements com.baidu.tieba.a.e {
    private TextView afB;
    private String agJ;
    private OriginalThreadCardView.a ahy;
    private final View.OnClickListener aiT;
    private boolean ajt;
    private String edb;
    private boolean evl;
    public ThreadSourceShareAndPraiseLayout gjQ;
    public ThreadUserInfoLayout gjd;
    public ThreadCommentAndPraiseInfoLayout gje;
    private NEGFeedBackView gjp;
    private View hjN;
    private boolean hjR;
    private HeadPendantClickableView hjq;
    private TbImageView hlA;
    private ViewGroup hlB;
    public OriginalThreadCardView hle;
    private View hlx;
    private TbImageView hly;
    private bx hlz;
    private View mMaskView;
    private TbPageContext<?> mPageContext;
    private TextView mTitle;
    private String mUrl;

    public u(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.gjp = null;
        this.ajt = true;
        this.hjR = true;
        this.aiT = new View.OnClickListener() { // from class: com.baidu.tieba.card.u.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (u.this.cbA() != null) {
                    u.this.cbA().a(view, u.this.hlz);
                }
            }
        };
        this.ahy = new OriginalThreadCardView.a() { // from class: com.baidu.tieba.card.u.8
            @Override // com.baidu.tieba.card.OriginalThreadCardView.a
            public void a(OriginalThreadInfo originalThreadInfo) {
                if (u.this.hlz != null && u.this.hlz.dUW != null) {
                    if (u.this.cbA() != null) {
                        u.this.cbA().a(u.this.hle, u.this.hlz);
                    }
                    String id = u.this.hlz.dUW.getId();
                    m.GZ(id);
                    u.this.di(id);
                }
            }
        };
        this.mPageContext = tbPageContext;
        View view = getView();
        this.hlB = (ViewGroup) view.findViewById(R.id.thread_content_layout_outter);
        this.hlB.setOnClickListener(this);
        this.hjq = (HeadPendantClickableView) view.findViewById(R.id.thread_user_pendant_header);
        if (this.hjq.getHeadView() != null) {
            this.hjq.getHeadView().setIsRound(true);
            this.hjq.getHeadView().setDrawBorder(false);
            this.hjq.getHeadView().setDefaultResource(17170445);
            this.hjq.getHeadView().setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.hjq.getHeadView().setRadius(com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds70));
            this.hjq.getHeadView().setPlaceHolder(1);
        }
        this.hjq.setHasPendantStyle();
        if (this.hjq.getPendantView() != null) {
            this.hjq.getPendantView().setIsRound(true);
            this.hjq.getPendantView().setDrawBorder(false);
        }
        this.gjd = (ThreadUserInfoLayout) view.findViewById(R.id.thread_user_info_layout);
        this.gjp = new NEGFeedBackView(this.mPageContext);
        this.gjp.a((ViewGroup) getView(), com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds92), com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds16));
        this.mTitle = (TextView) view.findViewById(R.id.thread_title);
        this.afB = (TextView) view.findViewById(R.id.thread_abstract);
        this.hle = (OriginalThreadCardView) view.findViewById(R.id.original_thread_view);
        this.hle.setSubClickListener(this.ahy);
        this.gje = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.thread_comment_layout);
        if (this.gje.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gje.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.gje.setLayoutParams(layoutParams);
        }
        view.setOnClickListener(this);
        this.gje.setOnClickListener(this);
        this.gje.setReplyTimeVisible(false);
        this.gje.setShowPraiseNum(true);
        this.gje.setNeedAddPraiseIcon(true);
        this.gje.setNeedAddReplyIcon(true);
        this.gje.setShareVisible(true);
        this.gje.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.u.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (u.this.cbA() != null) {
                    u.this.cbA().a(view2, u.this.hlz);
                }
                if (u.this.hlz != null && u.this.hlz.dUW != null) {
                    m.GZ(u.this.hlz.dUW.getId());
                    u.this.di(u.this.hlz.dUW.getId());
                }
            }
        });
        this.gjQ = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.card_transmit_source_read_share_layout);
        this.gjQ.euY.setOnClickListener(this);
        this.gjQ.euY.setNeedAddReplyIcon(true);
        this.gjQ.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.u.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (u.this.cbA() != null) {
                    u.this.cbA().a(view2, u.this.hlz);
                }
                if (view2 != u.this.gjQ.eun && u.this.hlz != null && u.this.hlz.dUW != null) {
                    m.GZ(u.this.hlz.dUW.getId());
                    u.this.di(u.this.hlz.dUW.getId());
                }
            }
        });
        this.hjN = view.findViewById(R.id.divider_line_above_praise);
        this.hlx = view.findViewById(R.id.card_divider_line);
        this.hly = (TbImageView) view.findViewById(R.id.thread_theme_card);
        this.hlA = (TbImageView) view.findViewById(R.id.frs_normal_item_star_view);
        this.mMaskView = view.findViewById(R.id.thread_multi_del_mask_view);
        this.mMaskView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.u.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                u.this.gje.changeSelectStatus();
            }
        });
        this.gje.setOnSelectStatusChangeListener(new ThreadCommentAndPraiseInfoLayout.b() { // from class: com.baidu.tieba.card.u.4
            @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.b
            public void iB(boolean z) {
                ap.setBackgroundColor(u.this.mMaskView, z ? R.color.cp_bg_line_d : R.color.transparent);
            }
        });
    }

    private void X(final bw bwVar) {
        if (this.hlA != null) {
            if (this.hly == null || bwVar == null) {
                this.hlA.setVisibility(8);
            } else if (!StringUtils.isNull(bwVar.edJ) && this.hly.getVisibility() != 0) {
                if (this.gjp != null && this.gjp.getVisibility() == 0 && (this.hlA.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hlA.getLayoutParams();
                    layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds106);
                    this.hlA.setLayoutParams(layoutParams);
                }
                this.hlA.setVisibility(0);
                this.hlA.setImageDrawable(null);
                this.hlA.startLoad(bwVar.edJ, 10, false);
                this.hlA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.u.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (u.this.mPageContext != null) {
                            u.this.mTbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ShareWebActivityConfig(u.this.mTbPageContext.getContext(), "", bwVar.edK, true)));
                        }
                        TiebaStatic.log(new aq(CommonStatisticKey.KEY_FRS_STAR_PIC_CLICK));
                    }
                });
            } else {
                this.hlA.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(getView(), R.drawable.addresslist_item_bg);
            ap.setBackgroundColor(this.hjN, R.color.cp_bg_line_c);
            this.gje.onChangeSkinType();
            this.gjd.onChangeSkinType();
            if (this.gjp != null) {
                this.gjp.onChangeSkinType();
            }
            this.hle.onChangeSkinType();
            ap.setBackgroundColor(this.hlx, R.color.cp_bg_line_e);
            this.gjQ.onChangeSkinType();
        }
        if (this.hlz != null && this.hlz.dUW != null) {
            ap.setBackgroundColor(this.mMaskView, (this.hlz.dUW.bgp() || this.hlz.dUW.bgq()) ? R.color.cp_bg_line_d : R.color.transparent);
        }
        if (this.hjq != null && this.hjq.getHeadView() != null && (this.hjq.getHeadView() instanceof TbImageView)) {
            this.hjq.getHeadView().setPlaceHolder(1);
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
        if (bxVar == null || bxVar.dUW == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        if (getView() != null) {
            getView().setVisibility(0);
        }
        this.hlz = bxVar;
        bw bwVar = bxVar.dUW;
        if (this.gjp != null) {
            SparseArray<String> feedBackReasonMap = bwVar.getFeedBackReasonMap();
            if (feedBackReasonMap != null && feedBackReasonMap.size() > 0 && this.hjR) {
                ar arVar = new ar();
                arVar.setTid(bwVar.getTid());
                arVar.setFid(bwVar.getFid());
                arVar.setNid(bwVar.getNid());
                arVar.setFeedBackReasonMap(feedBackReasonMap);
                arVar.dZb = bwVar.dZb;
                this.gjp.setData(arVar);
                this.gjp.setFirstRowSingleColumn(true);
                this.gjp.setVisibility(Z(bwVar) ? 8 : 0);
            } else {
                this.gjp.setVisibility(8);
            }
        }
        if (this.hlz.eeF == 1) {
            this.gjd.setFrom(3);
            b(bwVar);
            X(bwVar);
        }
        this.gjd.setIsFromConcern(this.evl);
        this.gjd.setData(bwVar);
        this.gjd.setUserAfterClickListener(this.aiT);
        if (this.gjd.getHeaderImg() != null) {
            if (this.gjd.getIsSimpleThread()) {
                this.gjd.getHeaderImg().setVisibility(8);
                this.hjq.setVisibility(8);
            } else if (bwVar.beE() == null || bwVar.beE().getPendantData() == null || StringUtils.isNull(bwVar.beE().getPendantData().bcA())) {
                this.hjq.setVisibility(8);
                this.gjd.getHeaderImg().setVisibility(0);
                this.gjd.getHeaderImg().setData(bwVar);
            } else {
                this.gjd.getHeaderImg().setVisibility(4);
                this.hjq.setVisibility(0);
                this.hjq.setData(bwVar);
            }
        }
        Y(bwVar);
        this.hle.b(bwVar.edI);
        tB(rY(1));
        setPageUniqueId(getTag());
        onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        di(bwVar.getId());
        if (this.gje.isInFrsAllThread() && (com.baidu.tieba.frs.b.ckT().ckN() || com.baidu.tieba.frs.a.ckM().ckN())) {
            this.mMaskView.setVisibility(0);
            if (bwVar.bgp() || bwVar.bgq() || bwVar.bgr()) {
                ap.setBackgroundColor(this.mMaskView, R.color.cp_bg_line_d);
                return;
            } else {
                this.mMaskView.setBackgroundResource(R.color.transparent);
                return;
            }
        }
        this.mMaskView.setVisibility(8);
    }

    private void Y(bw bwVar) {
        if (bwVar != null) {
            if (!StringUtils.isNull(this.mUrl) && !StringUtils.isNull(this.edb)) {
                bwVar.du(this.mUrl, this.edb);
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

    private boolean Z(bw bwVar) {
        if (bwVar == null || bwVar.beE() == null || StringUtils.isNull(bwVar.beE().getUserId())) {
            return false;
        }
        return bwVar.beE().getUserId().equals(TbadkCoreApplication.getCurrentAccount());
    }

    public void p(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.gjp != null) {
            this.gjp.setUniqueId(bdUniqueId);
        }
        if (this.gjd != null) {
            this.gjd.setPageUniqueId(bdUniqueId);
        }
    }

    public void nn(boolean z) {
        if (this.hlx != null) {
            this.hlx.setVisibility(z ? 0 : 8);
        }
    }

    public void ni(boolean z) {
        this.hjR = z;
    }

    private void bpF() {
        if (this.hlz != null && this.hlz.dUW != null) {
            bw bwVar = this.hlz.dUW;
            m.GZ(bwVar.getId());
            di(bwVar.getId());
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(bwVar, null, this.hlz.stType, RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false);
            createFromThreadCfg.setStartFrom(this.currentPageType);
            createFromThreadCfg.setIsShareThread(true);
            m.GZ(bwVar.getTid());
            this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void di(String str) {
        m.a(this.mTitle, str, R.color.cp_cont_b, R.color.cp_cont_d);
        m.a(this.afB, str, R.color.cp_cont_b, R.color.cp_cont_d);
        this.hle.setReadState(m.Ha(str));
    }

    public void b(bw bwVar) {
        MetaData beE;
        if (bwVar != null && this.hly != null && (beE = bwVar.beE()) != null) {
            final ThemeCardInUserData themeCard = beE.getThemeCard();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                this.hly.setVisibility(8);
                return;
            }
            this.hly.setVisibility(0);
            this.hly.setImageBitmap(null);
            this.hly.startLoad(themeCard.getCardImageUrlAndroid(), 10, false);
            this.hly.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.u.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonalCardDetailActivityConfig(u.this.mPageContext.getPageActivity(), themeCard.getCardId())));
                }
            });
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (cbA() != null) {
            cbA().a(view, this.hlz);
        }
        if (view == getView() || view.getId() == R.id.thread_content_layout_outter) {
            bpF();
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.gjd != null) {
            return this.gjd.euH;
        }
        return null;
    }

    public View cbE() {
        if (this.gjd != null) {
            return this.gjd.aiH;
        }
        return null;
    }

    public void tB(int i) {
        if (this.hlz != null && this.hlz.dUW != null) {
            if (i == 1) {
                this.gje.setVisibility(8);
                this.gjQ.setFrom(this.hlz.eeE);
                this.gjQ.setShareReportFrom(this.hlz.eeF);
                this.gjQ.setStType(this.hlz.stType);
                this.gjQ.setData(this.hlz.dUW);
                this.gjd.iC(false);
                return;
            }
            this.gje.setFrom(this.hlz.eeE);
            this.gje.setShareReportFrom(this.hlz.eeF);
            this.gje.setStType(this.hlz.stType);
            this.gje.setData(this.hlz.dUW);
            this.gje.setDisPraiseFrom(this.hlz.eeG);
            this.gjQ.setVisibility(8);
            this.gjd.iC(true);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.agJ = str;
    }

    public int rY(int i) {
        return com.baidu.tieba.a.d.bAB().au(this.agJ, i);
    }
}
