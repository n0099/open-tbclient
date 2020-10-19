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
public class u extends b<bx> implements com.baidu.tieba.a.e {
    private TextView agl;
    private String aht;
    private OriginalThreadCardView.a aik;
    private final View.OnClickListener ajF;
    private boolean akj;
    private boolean eJz;
    private String erq;
    public ThreadUserInfoLayout gAD;
    public ThreadCommentAndPraiseInfoLayout gAE;
    private NEGFeedBackView gAP;
    public ThreadSourceShareAndPraiseLayout gBq;
    private View hFK;
    private boolean hFO;
    private HeadPendantClickableView hFn;
    public OriginalThreadCardView hHb;
    private View hHu;
    private TbImageView hHv;
    private bx hHw;
    private TbImageView hHx;
    private ViewGroup hHy;
    private View mMaskView;
    private TbPageContext<?> mPageContext;
    private TextView mTitle;
    private String mUrl;

    public u(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.gAP = null;
        this.akj = true;
        this.hFO = true;
        this.ajF = new View.OnClickListener() { // from class: com.baidu.tieba.card.u.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (u.this.cil() != null) {
                    u.this.cil().a(view, u.this.hHw);
                }
            }
        };
        this.aik = new OriginalThreadCardView.a() { // from class: com.baidu.tieba.card.u.8
            @Override // com.baidu.tieba.card.OriginalThreadCardView.a
            public void a(OriginalThreadInfo originalThreadInfo) {
                if (u.this.hHw != null && u.this.hHw.eji != null) {
                    if (u.this.cil() != null) {
                        u.this.cil().a(u.this.hHb, u.this.hHw);
                    }
                    String id = u.this.hHw.eji.getId();
                    m.Ij(id);
                    u.this.dk(id);
                }
            }
        };
        this.mPageContext = tbPageContext;
        View view = getView();
        this.hHy = (ViewGroup) view.findViewById(R.id.thread_content_layout_outter);
        this.hHy.setOnClickListener(this);
        this.hFn = (HeadPendantClickableView) view.findViewById(R.id.thread_user_pendant_header);
        if (this.hFn.getHeadView() != null) {
            this.hFn.getHeadView().setIsRound(true);
            this.hFn.getHeadView().setDrawBorder(false);
            this.hFn.getHeadView().setDefaultResource(17170445);
            this.hFn.getHeadView().setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.hFn.getHeadView().setRadius(com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds70));
            this.hFn.getHeadView().setPlaceHolder(1);
        }
        this.hFn.setHasPendantStyle();
        if (this.hFn.getPendantView() != null) {
            this.hFn.getPendantView().setIsRound(true);
            this.hFn.getPendantView().setDrawBorder(false);
        }
        this.gAD = (ThreadUserInfoLayout) view.findViewById(R.id.thread_user_info_layout);
        this.gAP = new NEGFeedBackView(this.mPageContext);
        this.gAP.a((ViewGroup) getView(), com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds92), com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds16));
        this.mTitle = (TextView) view.findViewById(R.id.thread_title);
        this.agl = (TextView) view.findViewById(R.id.thread_abstract);
        this.hHb = (OriginalThreadCardView) view.findViewById(R.id.original_thread_view);
        this.hHb.setSubClickListener(this.aik);
        this.gAE = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.thread_comment_layout);
        if (this.gAE.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gAE.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.gAE.setLayoutParams(layoutParams);
        }
        view.setOnClickListener(this);
        this.gAE.setOnClickListener(this);
        this.gAE.setReplyTimeVisible(false);
        this.gAE.setShowPraiseNum(true);
        this.gAE.setNeedAddPraiseIcon(true);
        this.gAE.setNeedAddReplyIcon(true);
        this.gAE.setShareVisible(true);
        this.gAE.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.u.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (u.this.cil() != null) {
                    u.this.cil().a(view2, u.this.hHw);
                }
                if (u.this.hHw != null && u.this.hHw.eji != null) {
                    m.Ij(u.this.hHw.eji.getId());
                    u.this.dk(u.this.hHw.eji.getId());
                }
            }
        });
        this.gBq = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.card_transmit_source_read_share_layout);
        this.gBq.eJm.setOnClickListener(this);
        this.gBq.eJm.setNeedAddReplyIcon(true);
        this.gBq.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.u.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (u.this.cil() != null) {
                    u.this.cil().a(view2, u.this.hHw);
                }
                if (view2 != u.this.gBq.eIB && u.this.hHw != null && u.this.hHw.eji != null) {
                    m.Ij(u.this.hHw.eji.getId());
                    u.this.dk(u.this.hHw.eji.getId());
                }
            }
        });
        this.hFK = view.findViewById(R.id.divider_line_above_praise);
        this.hHu = view.findViewById(R.id.card_divider_line);
        this.hHv = (TbImageView) view.findViewById(R.id.thread_theme_card);
        this.hHx = (TbImageView) view.findViewById(R.id.frs_normal_item_star_view);
        this.mMaskView = view.findViewById(R.id.thread_multi_del_mask_view);
        this.mMaskView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.u.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                u.this.gAE.changeSelectStatus();
            }
        });
        this.gAE.setOnSelectStatusChangeListener(new ThreadCommentAndPraiseInfoLayout.b() { // from class: com.baidu.tieba.card.u.4
            @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.b
            public void iW(boolean z) {
                ap.setBackgroundColor(u.this.mMaskView, z ? R.color.cp_bg_line_d : R.color.transparent);
            }
        });
    }

    private void Y(final bw bwVar) {
        if (this.hHx != null) {
            if (this.hHv == null || bwVar == null) {
                this.hHx.setVisibility(8);
            } else if (!StringUtils.isNull(bwVar.erZ) && this.hHv.getVisibility() != 0) {
                if (this.gAP != null && this.gAP.getVisibility() == 0 && (this.hHx.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hHx.getLayoutParams();
                    layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds106);
                    this.hHx.setLayoutParams(layoutParams);
                }
                this.hHx.setVisibility(0);
                this.hHx.setImageDrawable(null);
                this.hHx.startLoad(bwVar.erZ, 10, false);
                this.hHx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.u.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (u.this.mPageContext != null) {
                            u.this.mTbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ShareWebActivityConfig(u.this.mTbPageContext.getContext(), "", bwVar.esa, true)));
                        }
                        TiebaStatic.log(new aq(CommonStatisticKey.KEY_FRS_STAR_PIC_CLICK));
                    }
                });
            } else {
                this.hHx.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(getView(), R.drawable.addresslist_item_bg);
            ap.setBackgroundColor(this.hFK, R.color.cp_bg_line_c);
            this.gAE.onChangeSkinType();
            this.gAD.onChangeSkinType();
            if (this.gAP != null) {
                this.gAP.onChangeSkinType();
            }
            this.hHb.onChangeSkinType();
            ap.setBackgroundColor(this.hHu, R.color.cp_bg_line_e);
            this.gBq.onChangeSkinType();
        }
        if (this.hHw != null && this.hHw.eji != null) {
            ap.setBackgroundColor(this.mMaskView, (this.hHw.eji.bjS() || this.hHw.eji.bjT()) ? R.color.cp_bg_line_d : R.color.transparent);
        }
        if (this.hFn != null && this.hFn.getHeadView() != null && (this.hFn.getHeadView() instanceof TbImageView)) {
            this.hFn.getHeadView().setPlaceHolder(1);
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
        if (bxVar == null || bxVar.eji == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        if (getView() != null) {
            getView().setVisibility(0);
        }
        this.hHw = bxVar;
        bw bwVar = bxVar.eji;
        if (this.gAP != null) {
            SparseArray<String> feedBackReasonMap = bwVar.getFeedBackReasonMap();
            if (feedBackReasonMap != null && feedBackReasonMap.size() > 0 && this.hFO) {
                ar arVar = new ar();
                arVar.setTid(bwVar.getTid());
                arVar.setFid(bwVar.getFid());
                arVar.setNid(bwVar.getNid());
                arVar.setFeedBackReasonMap(feedBackReasonMap);
                arVar.eno = bwVar.eno;
                this.gAP.setData(arVar);
                this.gAP.setFirstRowSingleColumn(true);
                this.gAP.setVisibility(aa(bwVar) ? 8 : 0);
            } else {
                this.gAP.setVisibility(8);
            }
        }
        if (this.hHw.esZ == 1) {
            this.gAD.setFrom(3);
            b(bwVar);
            Y(bwVar);
        }
        this.gAD.setIsFromConcern(this.eJz);
        this.gAD.setData(bwVar);
        this.gAD.setUserAfterClickListener(this.ajF);
        if (this.gAD.getHeaderImg() != null) {
            if (this.gAD.getIsSimpleThread()) {
                this.gAD.getHeaderImg().setVisibility(8);
                this.hFn.setVisibility(8);
            } else if (bwVar.bih() == null || bwVar.bih().getPendantData() == null || StringUtils.isNull(bwVar.bih().getPendantData().bgd())) {
                this.hFn.setVisibility(8);
                this.gAD.getHeaderImg().setVisibility(0);
                this.gAD.getHeaderImg().setData(bwVar);
            } else {
                this.gAD.getHeaderImg().setVisibility(4);
                this.hFn.setVisibility(0);
                this.hFn.setData(bwVar);
            }
        }
        Z(bwVar);
        this.hHb.b(bwVar.erY);
        uz(sO(1));
        setPageUniqueId(getTag());
        onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        dk(bwVar.getId());
        if (this.gAE.isInFrsAllThread() && (com.baidu.tieba.frs.b.crE().cry() || com.baidu.tieba.frs.a.crx().cry())) {
            this.mMaskView.setVisibility(0);
            if (bwVar.bjS() || bwVar.bjT() || bwVar.bjU()) {
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
            if (!StringUtils.isNull(this.mUrl) && !StringUtils.isNull(this.erq)) {
                bwVar.dz(this.mUrl, this.erq);
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
        if (bwVar == null || bwVar.bih() == null || StringUtils.isNull(bwVar.bih().getUserId())) {
            return false;
        }
        return bwVar.bih().getUserId().equals(TbadkCoreApplication.getCurrentAccount());
    }

    public void o(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.gAP != null) {
            this.gAP.setUniqueId(bdUniqueId);
        }
        if (this.gAD != null) {
            this.gAD.setPageUniqueId(bdUniqueId);
        }
    }

    public void nY(boolean z) {
        if (this.hHu != null) {
            this.hHu.setVisibility(z ? 0 : 8);
        }
    }

    public void nT(boolean z) {
        this.hFO = z;
    }

    private void btj() {
        if (this.hHw != null && this.hHw.eji != null) {
            bw bwVar = this.hHw.eji;
            m.Ij(bwVar.getId());
            dk(bwVar.getId());
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(bwVar, null, this.hHw.stType, RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false);
            createFromThreadCfg.setStartFrom(this.currentPageType);
            createFromThreadCfg.setIsShareThread(true);
            m.Ij(bwVar.getTid());
            this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dk(String str) {
        m.a(this.mTitle, str, R.color.cp_cont_b, R.color.cp_cont_d);
        m.a(this.agl, str, R.color.cp_cont_b, R.color.cp_cont_d);
        this.hHb.setReadState(m.Ik(str));
    }

    public void b(bw bwVar) {
        MetaData bih;
        if (bwVar != null && this.hHv != null && (bih = bwVar.bih()) != null) {
            final ThemeCardInUserData themeCard = bih.getThemeCard();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                this.hHv.setVisibility(8);
                return;
            }
            this.hHv.setVisibility(0);
            this.hHv.setImageBitmap(null);
            this.hHv.startLoad(themeCard.getCardImageUrlAndroid(), 10, false);
            this.hHv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.u.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonalCardDetailActivityConfig(u.this.mPageContext.getPageActivity(), themeCard.getCardId())));
                }
            });
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (cil() != null) {
            cil().a(view, this.hHw);
        }
        if (view == getView() || view.getId() == R.id.thread_content_layout_outter) {
            btj();
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.gAD != null) {
            return this.gAD.eIV;
        }
        return null;
    }

    public View cip() {
        if (this.gAD != null) {
            return this.gAD.ajt;
        }
        return null;
    }

    public void uz(int i) {
        if (this.hHw != null && this.hHw.eji != null) {
            if (i == 1) {
                this.gAE.setVisibility(8);
                this.gBq.setFrom(this.hHw.esY);
                this.gBq.setShareReportFrom(this.hHw.esZ);
                this.gBq.setStType(this.hHw.stType);
                this.gBq.setData(this.hHw.eji);
                this.gAD.iX(false);
                return;
            }
            this.gAE.setFrom(this.hHw.esY);
            this.gAE.setShareReportFrom(this.hHw.esZ);
            this.gAE.setStType(this.hHw.stType);
            this.gAE.setData(this.hHw.eji);
            this.gAE.setDisPraiseFrom(this.hHw.eta);
            this.gBq.setVisibility(8);
            this.gAD.iX(true);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.aht = str;
    }

    public int sO(int i) {
        return com.baidu.tieba.a.d.bEz().av(this.aht, i);
    }
}
