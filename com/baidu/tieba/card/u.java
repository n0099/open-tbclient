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
    private TextView afz;
    private String agH;
    private OriginalThreadCardView.a ahw;
    private final View.OnClickListener aiR;
    private boolean ajr;
    private String ecX;
    private boolean evh;
    public ThreadUserInfoLayout giZ;
    public ThreadSourceShareAndPraiseLayout gjM;
    public ThreadCommentAndPraiseInfoLayout gja;
    private NEGFeedBackView gjl;
    private View hjJ;
    private boolean hjN;
    private HeadPendantClickableView hjm;
    public OriginalThreadCardView hla;
    private View hlt;
    private TbImageView hlu;
    private bx hlv;
    private TbImageView hlw;
    private ViewGroup hlx;
    private View mMaskView;
    private TbPageContext<?> mPageContext;
    private TextView mTitle;
    private String mUrl;

    public u(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.gjl = null;
        this.ajr = true;
        this.hjN = true;
        this.aiR = new View.OnClickListener() { // from class: com.baidu.tieba.card.u.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (u.this.cbz() != null) {
                    u.this.cbz().a(view, u.this.hlv);
                }
            }
        };
        this.ahw = new OriginalThreadCardView.a() { // from class: com.baidu.tieba.card.u.8
            @Override // com.baidu.tieba.card.OriginalThreadCardView.a
            public void a(OriginalThreadInfo originalThreadInfo) {
                if (u.this.hlv != null && u.this.hlv.dUS != null) {
                    if (u.this.cbz() != null) {
                        u.this.cbz().a(u.this.hla, u.this.hlv);
                    }
                    String id = u.this.hlv.dUS.getId();
                    m.GY(id);
                    u.this.dh(id);
                }
            }
        };
        this.mPageContext = tbPageContext;
        View view = getView();
        this.hlx = (ViewGroup) view.findViewById(R.id.thread_content_layout_outter);
        this.hlx.setOnClickListener(this);
        this.hjm = (HeadPendantClickableView) view.findViewById(R.id.thread_user_pendant_header);
        if (this.hjm.getHeadView() != null) {
            this.hjm.getHeadView().setIsRound(true);
            this.hjm.getHeadView().setDrawBorder(false);
            this.hjm.getHeadView().setDefaultResource(17170445);
            this.hjm.getHeadView().setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.hjm.getHeadView().setRadius(com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds70));
            this.hjm.getHeadView().setPlaceHolder(1);
        }
        this.hjm.setHasPendantStyle();
        if (this.hjm.getPendantView() != null) {
            this.hjm.getPendantView().setIsRound(true);
            this.hjm.getPendantView().setDrawBorder(false);
        }
        this.giZ = (ThreadUserInfoLayout) view.findViewById(R.id.thread_user_info_layout);
        this.gjl = new NEGFeedBackView(this.mPageContext);
        this.gjl.a((ViewGroup) getView(), com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds92), com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds16));
        this.mTitle = (TextView) view.findViewById(R.id.thread_title);
        this.afz = (TextView) view.findViewById(R.id.thread_abstract);
        this.hla = (OriginalThreadCardView) view.findViewById(R.id.original_thread_view);
        this.hla.setSubClickListener(this.ahw);
        this.gja = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.thread_comment_layout);
        if (this.gja.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gja.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.gja.setLayoutParams(layoutParams);
        }
        view.setOnClickListener(this);
        this.gja.setOnClickListener(this);
        this.gja.setReplyTimeVisible(false);
        this.gja.setShowPraiseNum(true);
        this.gja.setNeedAddPraiseIcon(true);
        this.gja.setNeedAddReplyIcon(true);
        this.gja.setShareVisible(true);
        this.gja.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.u.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (u.this.cbz() != null) {
                    u.this.cbz().a(view2, u.this.hlv);
                }
                if (u.this.hlv != null && u.this.hlv.dUS != null) {
                    m.GY(u.this.hlv.dUS.getId());
                    u.this.dh(u.this.hlv.dUS.getId());
                }
            }
        });
        this.gjM = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.card_transmit_source_read_share_layout);
        this.gjM.euU.setOnClickListener(this);
        this.gjM.euU.setNeedAddReplyIcon(true);
        this.gjM.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.u.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (u.this.cbz() != null) {
                    u.this.cbz().a(view2, u.this.hlv);
                }
                if (view2 != u.this.gjM.euj && u.this.hlv != null && u.this.hlv.dUS != null) {
                    m.GY(u.this.hlv.dUS.getId());
                    u.this.dh(u.this.hlv.dUS.getId());
                }
            }
        });
        this.hjJ = view.findViewById(R.id.divider_line_above_praise);
        this.hlt = view.findViewById(R.id.card_divider_line);
        this.hlu = (TbImageView) view.findViewById(R.id.thread_theme_card);
        this.hlw = (TbImageView) view.findViewById(R.id.frs_normal_item_star_view);
        this.mMaskView = view.findViewById(R.id.thread_multi_del_mask_view);
        this.mMaskView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.u.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                u.this.gja.changeSelectStatus();
            }
        });
        this.gja.setOnSelectStatusChangeListener(new ThreadCommentAndPraiseInfoLayout.b() { // from class: com.baidu.tieba.card.u.4
            @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.b
            public void iA(boolean z) {
                ap.setBackgroundColor(u.this.mMaskView, z ? R.color.cp_bg_line_d : R.color.transparent);
            }
        });
    }

    private void X(final bw bwVar) {
        if (this.hlw != null) {
            if (this.hlu == null || bwVar == null) {
                this.hlw.setVisibility(8);
            } else if (!StringUtils.isNull(bwVar.edF) && this.hlu.getVisibility() != 0) {
                if (this.gjl != null && this.gjl.getVisibility() == 0 && (this.hlw.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hlw.getLayoutParams();
                    layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds106);
                    this.hlw.setLayoutParams(layoutParams);
                }
                this.hlw.setVisibility(0);
                this.hlw.setImageDrawable(null);
                this.hlw.startLoad(bwVar.edF, 10, false);
                this.hlw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.u.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (u.this.mPageContext != null) {
                            u.this.mTbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ShareWebActivityConfig(u.this.mTbPageContext.getContext(), "", bwVar.edG, true)));
                        }
                        TiebaStatic.log(new aq(CommonStatisticKey.KEY_FRS_STAR_PIC_CLICK));
                    }
                });
            } else {
                this.hlw.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(getView(), R.drawable.addresslist_item_bg);
            ap.setBackgroundColor(this.hjJ, R.color.cp_bg_line_c);
            this.gja.onChangeSkinType();
            this.giZ.onChangeSkinType();
            if (this.gjl != null) {
                this.gjl.onChangeSkinType();
            }
            this.hla.onChangeSkinType();
            ap.setBackgroundColor(this.hlt, R.color.cp_bg_line_e);
            this.gjM.onChangeSkinType();
        }
        if (this.hlv != null && this.hlv.dUS != null) {
            ap.setBackgroundColor(this.mMaskView, (this.hlv.dUS.bgp() || this.hlv.dUS.bgq()) ? R.color.cp_bg_line_d : R.color.transparent);
        }
        if (this.hjm != null && this.hjm.getHeadView() != null && (this.hjm.getHeadView() instanceof TbImageView)) {
            this.hjm.getHeadView().setPlaceHolder(1);
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
        if (bxVar == null || bxVar.dUS == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        if (getView() != null) {
            getView().setVisibility(0);
        }
        this.hlv = bxVar;
        bw bwVar = bxVar.dUS;
        if (this.gjl != null) {
            SparseArray<String> feedBackReasonMap = bwVar.getFeedBackReasonMap();
            if (feedBackReasonMap != null && feedBackReasonMap.size() > 0 && this.hjN) {
                ar arVar = new ar();
                arVar.setTid(bwVar.getTid());
                arVar.setFid(bwVar.getFid());
                arVar.setNid(bwVar.getNid());
                arVar.setFeedBackReasonMap(feedBackReasonMap);
                arVar.dYX = bwVar.dYX;
                this.gjl.setData(arVar);
                this.gjl.setFirstRowSingleColumn(true);
                this.gjl.setVisibility(Z(bwVar) ? 8 : 0);
            } else {
                this.gjl.setVisibility(8);
            }
        }
        if (this.hlv.eeB == 1) {
            this.giZ.setFrom(3);
            b(bwVar);
            X(bwVar);
        }
        this.giZ.setIsFromConcern(this.evh);
        this.giZ.setData(bwVar);
        this.giZ.setUserAfterClickListener(this.aiR);
        if (this.giZ.getHeaderImg() != null) {
            if (this.giZ.getIsSimpleThread()) {
                this.giZ.getHeaderImg().setVisibility(8);
                this.hjm.setVisibility(8);
            } else if (bwVar.beE() == null || bwVar.beE().getPendantData() == null || StringUtils.isNull(bwVar.beE().getPendantData().bcA())) {
                this.hjm.setVisibility(8);
                this.giZ.getHeaderImg().setVisibility(0);
                this.giZ.getHeaderImg().setData(bwVar);
            } else {
                this.giZ.getHeaderImg().setVisibility(4);
                this.hjm.setVisibility(0);
                this.hjm.setData(bwVar);
            }
        }
        Y(bwVar);
        this.hla.b(bwVar.edE);
        tB(rY(1));
        setPageUniqueId(getTag());
        onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        dh(bwVar.getId());
        if (this.gja.isInFrsAllThread() && (com.baidu.tieba.frs.b.ckS().ckM() || com.baidu.tieba.frs.a.ckL().ckM())) {
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
            if (!StringUtils.isNull(this.mUrl) && !StringUtils.isNull(this.ecX)) {
                bwVar.du(this.mUrl, this.ecX);
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
        if (this.gjl != null) {
            this.gjl.setUniqueId(bdUniqueId);
        }
        if (this.giZ != null) {
            this.giZ.setPageUniqueId(bdUniqueId);
        }
    }

    public void nl(boolean z) {
        if (this.hlt != null) {
            this.hlt.setVisibility(z ? 0 : 8);
        }
    }

    public void ng(boolean z) {
        this.hjN = z;
    }

    private void bpE() {
        if (this.hlv != null && this.hlv.dUS != null) {
            bw bwVar = this.hlv.dUS;
            m.GY(bwVar.getId());
            dh(bwVar.getId());
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(bwVar, null, this.hlv.stType, RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false);
            createFromThreadCfg.setStartFrom(this.currentPageType);
            createFromThreadCfg.setIsShareThread(true);
            m.GY(bwVar.getTid());
            this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dh(String str) {
        m.a(this.mTitle, str, R.color.cp_cont_b, R.color.cp_cont_d);
        m.a(this.afz, str, R.color.cp_cont_b, R.color.cp_cont_d);
        this.hla.setReadState(m.GZ(str));
    }

    public void b(bw bwVar) {
        MetaData beE;
        if (bwVar != null && this.hlu != null && (beE = bwVar.beE()) != null) {
            final ThemeCardInUserData themeCard = beE.getThemeCard();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                this.hlu.setVisibility(8);
                return;
            }
            this.hlu.setVisibility(0);
            this.hlu.setImageBitmap(null);
            this.hlu.startLoad(themeCard.getCardImageUrlAndroid(), 10, false);
            this.hlu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.u.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonalCardDetailActivityConfig(u.this.mPageContext.getPageActivity(), themeCard.getCardId())));
                }
            });
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (cbz() != null) {
            cbz().a(view, this.hlv);
        }
        if (view == getView() || view.getId() == R.id.thread_content_layout_outter) {
            bpE();
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.giZ != null) {
            return this.giZ.euD;
        }
        return null;
    }

    public View cbD() {
        if (this.giZ != null) {
            return this.giZ.aiF;
        }
        return null;
    }

    public void tB(int i) {
        if (this.hlv != null && this.hlv.dUS != null) {
            if (i == 1) {
                this.gja.setVisibility(8);
                this.gjM.setFrom(this.hlv.eeA);
                this.gjM.setShareReportFrom(this.hlv.eeB);
                this.gjM.setStType(this.hlv.stType);
                this.gjM.setData(this.hlv.dUS);
                this.giZ.iB(false);
                return;
            }
            this.gja.setFrom(this.hlv.eeA);
            this.gja.setShareReportFrom(this.hlv.eeB);
            this.gja.setStType(this.hlv.stType);
            this.gja.setData(this.hlv.dUS);
            this.gja.setDisPraiseFrom(this.hlv.eeC);
            this.gjM.setVisibility(8);
            this.giZ.iB(true);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.agH = str;
    }

    public int rY(int i) {
        return com.baidu.tieba.a.d.bAA().au(this.agH, i);
    }
}
