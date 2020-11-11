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
/* loaded from: classes21.dex */
public class v extends b<bx> implements com.baidu.tieba.a.e {
    private TextView agm;
    private String ahu;
    private OriginalThreadCardView.a ail;
    private final View.OnClickListener ajG;
    private boolean akk;
    private String eFG;
    private boolean eXK;
    public ThreadUserInfoLayout gSQ;
    public ThreadCommentAndPraiseInfoLayout gSR;
    public ThreadSourceShareAndPraiseLayout gTD;
    private NEGFeedBackView gTc;
    private HeadPendantClickableView hXH;
    private View hYe;
    private boolean hYi;
    private View hZO;
    private TbImageView hZP;
    private bx hZQ;
    private TbImageView hZR;
    private ViewGroup hZS;
    public OriginalThreadCardView hZv;
    private View mMaskView;
    private TbPageContext<?> mPageContext;
    private TextView mTitle;
    private String mUrl;

    public v(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.gTc = null;
        this.akk = true;
        this.hYi = true;
        this.ajG = new View.OnClickListener() { // from class: com.baidu.tieba.card.v.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (v.this.cnT() != null) {
                    v.this.cnT().a(view, v.this.hZQ);
                }
            }
        };
        this.ail = new OriginalThreadCardView.a() { // from class: com.baidu.tieba.card.v.8
            @Override // com.baidu.tieba.card.OriginalThreadCardView.a
            public void a(OriginalThreadInfo originalThreadInfo) {
                if (v.this.hZQ != null && v.this.hZQ.exA != null) {
                    if (v.this.cnT() != null) {
                        v.this.cnT().a(v.this.hZv, v.this.hZQ);
                    }
                    String id = v.this.hZQ.exA.getId();
                    n.IZ(id);
                    v.this.dk(id);
                }
            }
        };
        this.mPageContext = tbPageContext;
        View view = getView();
        this.hZS = (ViewGroup) view.findViewById(R.id.thread_content_layout_outter);
        this.hZS.setOnClickListener(this);
        this.hXH = (HeadPendantClickableView) view.findViewById(R.id.thread_user_pendant_header);
        if (this.hXH.getHeadView() != null) {
            this.hXH.getHeadView().setIsRound(true);
            this.hXH.getHeadView().setDrawBorder(false);
            this.hXH.getHeadView().setDefaultResource(17170445);
            this.hXH.getHeadView().setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.hXH.getHeadView().setRadius(com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds70));
            this.hXH.getHeadView().setPlaceHolder(1);
        }
        this.hXH.setHasPendantStyle();
        if (this.hXH.getPendantView() != null) {
            this.hXH.getPendantView().setIsRound(true);
            this.hXH.getPendantView().setDrawBorder(false);
        }
        this.gSQ = (ThreadUserInfoLayout) view.findViewById(R.id.thread_user_info_layout);
        this.gTc = new NEGFeedBackView(this.mPageContext);
        this.gTc.a((ViewGroup) getView(), com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds92), com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds16));
        this.mTitle = (TextView) view.findViewById(R.id.thread_title);
        this.agm = (TextView) view.findViewById(R.id.thread_abstract);
        this.hZv = (OriginalThreadCardView) view.findViewById(R.id.original_thread_view);
        this.hZv.setSubClickListener(this.ail);
        this.gSR = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.thread_comment_layout);
        if (this.gSR.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gSR.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.gSR.setLayoutParams(layoutParams);
        }
        view.setOnClickListener(this);
        this.gSR.setOnClickListener(this);
        this.gSR.setReplyTimeVisible(false);
        this.gSR.setShowPraiseNum(true);
        this.gSR.setNeedAddPraiseIcon(true);
        this.gSR.setNeedAddReplyIcon(true);
        this.gSR.setShareVisible(true);
        this.gSR.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.v.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (v.this.cnT() != null) {
                    v.this.cnT().a(view2, v.this.hZQ);
                }
                if (v.this.hZQ != null && v.this.hZQ.exA != null) {
                    n.IZ(v.this.hZQ.exA.getId());
                    v.this.dk(v.this.hZQ.exA.getId());
                }
            }
        });
        this.gTD = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.card_transmit_source_read_share_layout);
        this.gTD.eXx.setOnClickListener(this);
        this.gTD.eXx.setNeedAddReplyIcon(true);
        this.gTD.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.v.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (v.this.cnT() != null) {
                    v.this.cnT().a(view2, v.this.hZQ);
                }
                if (view2 != v.this.gTD.eWM && v.this.hZQ != null && v.this.hZQ.exA != null) {
                    n.IZ(v.this.hZQ.exA.getId());
                    v.this.dk(v.this.hZQ.exA.getId());
                }
            }
        });
        this.hYe = view.findViewById(R.id.divider_line_above_praise);
        this.hZO = view.findViewById(R.id.card_divider_line);
        this.hZP = (TbImageView) view.findViewById(R.id.thread_theme_card);
        this.hZR = (TbImageView) view.findViewById(R.id.frs_normal_item_star_view);
        this.mMaskView = view.findViewById(R.id.thread_multi_del_mask_view);
        this.mMaskView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.v.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                v.this.gSR.changeSelectStatus();
            }
        });
        this.gSR.setOnSelectStatusChangeListener(new ThreadCommentAndPraiseInfoLayout.b() { // from class: com.baidu.tieba.card.v.4
            @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.b
            public void js(boolean z) {
                ap.setBackgroundColor(v.this.mMaskView, z ? R.color.cp_bg_line_d : R.color.transparent);
            }
        });
    }

    private void Y(final bw bwVar) {
        if (this.hZR != null) {
            if (this.hZP == null || bwVar == null) {
                this.hZR.setVisibility(8);
            } else if (!StringUtils.isNull(bwVar.eGo) && this.hZP.getVisibility() != 0) {
                if (this.gTc != null && this.gTc.getVisibility() == 0 && (this.hZR.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hZR.getLayoutParams();
                    layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds106);
                    this.hZR.setLayoutParams(layoutParams);
                }
                this.hZR.setVisibility(0);
                this.hZR.setImageDrawable(null);
                this.hZR.startLoad(bwVar.eGo, 10, false);
                this.hZR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.v.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (v.this.mPageContext != null) {
                            v.this.mTbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ShareWebActivityConfig(v.this.mTbPageContext.getContext(), "", bwVar.eGp, true)));
                        }
                        TiebaStatic.log(new aq(CommonStatisticKey.KEY_FRS_STAR_PIC_CLICK));
                    }
                });
            } else {
                this.hZR.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(getView(), R.drawable.addresslist_item_bg);
            ap.setBackgroundColor(this.hYe, R.color.cp_bg_line_c);
            this.gSR.onChangeSkinType();
            this.gSQ.onChangeSkinType();
            if (this.gTc != null) {
                this.gTc.onChangeSkinType();
            }
            this.hZv.onChangeSkinType();
            ap.setBackgroundColor(this.hZO, R.color.cp_bg_line_e);
            this.gTD.onChangeSkinType();
        }
        if (this.hZQ != null && this.hZQ.exA != null) {
            ap.setBackgroundColor(this.mMaskView, (this.hZQ.exA.bol() || this.hZQ.exA.bom()) ? R.color.cp_bg_line_d : R.color.transparent);
        }
        if (this.hXH != null && this.hXH.getHeadView() != null && (this.hXH.getHeadView() instanceof TbImageView)) {
            this.hXH.getHeadView().setPlaceHolder(1);
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
        if (bxVar == null || bxVar.exA == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        if (getView() != null) {
            getView().setVisibility(0);
        }
        this.hZQ = bxVar;
        bw bwVar = bxVar.exA;
        if (this.gTc != null) {
            SparseArray<String> feedBackReasonMap = bwVar.getFeedBackReasonMap();
            if (feedBackReasonMap != null && feedBackReasonMap.size() > 0 && this.hYi) {
                ar arVar = new ar();
                arVar.setTid(bwVar.getTid());
                arVar.setFid(bwVar.getFid());
                arVar.setNid(bwVar.getNid());
                arVar.setFeedBackReasonMap(feedBackReasonMap);
                arVar.eBG = bwVar.eBG;
                this.gTc.setData(arVar);
                this.gTc.setFirstRowSingleColumn(true);
                this.gTc.setVisibility(aa(bwVar) ? 8 : 0);
            } else {
                this.gTc.setVisibility(8);
            }
        }
        if (this.hZQ.eHo == 1) {
            this.gSQ.setFrom(3);
            b(bwVar);
            Y(bwVar);
        }
        this.gSQ.setIsFromConcern(this.eXK);
        this.gSQ.setData(bwVar);
        this.gSQ.setUserAfterClickListener(this.ajG);
        if (this.gSQ.getHeaderImg() != null) {
            if (this.gSQ.getIsSimpleThread()) {
                this.gSQ.getHeaderImg().setVisibility(8);
                this.hXH.setVisibility(8);
            } else if (bwVar.bmA() == null || bwVar.bmA().getPendantData() == null || StringUtils.isNull(bwVar.bmA().getPendantData().bkw())) {
                this.hXH.setVisibility(8);
                this.gSQ.getHeaderImg().setVisibility(0);
                this.gSQ.getHeaderImg().setData(bwVar);
            } else {
                this.gSQ.getHeaderImg().setVisibility(4);
                this.hXH.setVisibility(0);
                this.hXH.setData(bwVar);
            }
        }
        Z(bwVar);
        this.hZv.b(bwVar.eGn);
        vf(tj(1));
        setPageUniqueId(getTag());
        onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        dk(bwVar.getId());
        if (this.gSR.isInFrsAllThread() && (com.baidu.tieba.frs.b.cxm().cxg() || com.baidu.tieba.frs.a.cxf().cxg())) {
            this.mMaskView.setVisibility(0);
            if (bwVar.bol() || bwVar.bom() || bwVar.bon()) {
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
            if (!StringUtils.isNull(this.mUrl) && !StringUtils.isNull(this.eFG)) {
                bwVar.dG(this.mUrl, this.eFG);
            }
            SpannableStringBuilder B = bwVar.B(false, true);
            if (B == null || StringUtils.isNull(B.toString())) {
                this.mTitle.setVisibility(8);
                return;
            }
            this.mTitle.setVisibility(0);
            this.mTitle.setOnTouchListener(new com.baidu.tieba.view.i(B));
            this.mTitle.setText(B);
            n.a(this.mTitle, bwVar.getId(), R.color.cp_cont_b, R.color.cp_cont_d);
        }
    }

    private boolean aa(bw bwVar) {
        if (bwVar == null || bwVar.bmA() == null || StringUtils.isNull(bwVar.bmA().getUserId())) {
            return false;
        }
        return bwVar.bmA().getUserId().equals(TbadkCoreApplication.getCurrentAccount());
    }

    public void o(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.gTc != null) {
            this.gTc.setUniqueId(bdUniqueId);
        }
        if (this.gSQ != null) {
            this.gSQ.setPageUniqueId(bdUniqueId);
        }
    }

    public void oz(boolean z) {
        if (this.hZO != null) {
            this.hZO.setVisibility(z ? 0 : 8);
        }
    }

    public void ou(boolean z) {
        this.hYi = z;
    }

    private void bxB() {
        if (this.hZQ != null && this.hZQ.exA != null) {
            bw bwVar = this.hZQ.exA;
            n.IZ(bwVar.getId());
            dk(bwVar.getId());
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(bwVar, null, this.hZQ.stType, RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false);
            createFromThreadCfg.setStartFrom(this.currentPageType);
            createFromThreadCfg.setIsShareThread(true);
            n.IZ(bwVar.getTid());
            this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dk(String str) {
        n.a(this.mTitle, str, R.color.cp_cont_b, R.color.cp_cont_d);
        n.a(this.agm, str, R.color.cp_cont_b, R.color.cp_cont_d);
        this.hZv.setReadState(n.Ja(str));
    }

    public void b(bw bwVar) {
        MetaData bmA;
        if (bwVar != null && this.hZP != null && (bmA = bwVar.bmA()) != null) {
            final ThemeCardInUserData themeCard = bmA.getThemeCard();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                this.hZP.setVisibility(8);
                return;
            }
            this.hZP.setVisibility(0);
            this.hZP.setImageBitmap(null);
            this.hZP.startLoad(themeCard.getCardImageUrlAndroid(), 10, false);
            this.hZP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.v.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonalCardDetailActivityConfig(v.this.mPageContext.getPageActivity(), themeCard.getCardId())));
                }
            });
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (cnT() != null) {
            cnT().a(view, this.hZQ);
        }
        if (view == getView() || view.getId() == R.id.thread_content_layout_outter) {
            bxB();
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.gSQ != null) {
            return this.gSQ.eXg;
        }
        return null;
    }

    public View cnX() {
        if (this.gSQ != null) {
            return this.gSQ.aju;
        }
        return null;
    }

    public void vf(int i) {
        if (this.hZQ != null && this.hZQ.exA != null) {
            if (i == 1) {
                this.gSR.setVisibility(8);
                this.gTD.setFrom(this.hZQ.eHn);
                this.gTD.setShareReportFrom(this.hZQ.eHo);
                this.gTD.setStType(this.hZQ.stType);
                this.gTD.setData(this.hZQ.exA);
                this.gSQ.jt(false);
                return;
            }
            this.gSR.setFrom(this.hZQ.eHn);
            this.gSR.setShareReportFrom(this.hZQ.eHo);
            this.gSR.setStType(this.hZQ.stType);
            this.gSR.setData(this.hZQ.exA);
            this.gSR.setDisPraiseFrom(this.hZQ.eHp);
            this.gTD.setVisibility(8);
            this.gSQ.jt(true);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.ahu = str;
    }

    public int tj(int i) {
        return com.baidu.tieba.a.d.bIR().ax(this.ahu, i);
    }
}
