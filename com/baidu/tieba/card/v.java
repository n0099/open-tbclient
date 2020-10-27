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
    private boolean eRV;
    private String ezR;
    private NEGFeedBackView gMD;
    public ThreadUserInfoLayout gMr;
    public ThreadCommentAndPraiseInfoLayout gMs;
    public ThreadSourceShareAndPraiseLayout gNe;
    private HeadPendantClickableView hRK;
    private View hSh;
    private boolean hSl;
    private View hTR;
    private TbImageView hTS;
    private bx hTT;
    private TbImageView hTU;
    private ViewGroup hTV;
    public OriginalThreadCardView hTy;
    private View mMaskView;
    private TbPageContext<?> mPageContext;
    private TextView mTitle;
    private String mUrl;

    public v(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.gMD = null;
        this.akk = true;
        this.hSl = true;
        this.ajG = new View.OnClickListener() { // from class: com.baidu.tieba.card.v.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (v.this.cls() != null) {
                    v.this.cls().a(view, v.this.hTT);
                }
            }
        };
        this.ail = new OriginalThreadCardView.a() { // from class: com.baidu.tieba.card.v.8
            @Override // com.baidu.tieba.card.OriginalThreadCardView.a
            public void a(OriginalThreadInfo originalThreadInfo) {
                if (v.this.hTT != null && v.this.hTT.erH != null) {
                    if (v.this.cls() != null) {
                        v.this.cls().a(v.this.hTy, v.this.hTT);
                    }
                    String id = v.this.hTT.erH.getId();
                    n.II(id);
                    v.this.dk(id);
                }
            }
        };
        this.mPageContext = tbPageContext;
        View view = getView();
        this.hTV = (ViewGroup) view.findViewById(R.id.thread_content_layout_outter);
        this.hTV.setOnClickListener(this);
        this.hRK = (HeadPendantClickableView) view.findViewById(R.id.thread_user_pendant_header);
        if (this.hRK.getHeadView() != null) {
            this.hRK.getHeadView().setIsRound(true);
            this.hRK.getHeadView().setDrawBorder(false);
            this.hRK.getHeadView().setDefaultResource(17170445);
            this.hRK.getHeadView().setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.hRK.getHeadView().setRadius(com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds70));
            this.hRK.getHeadView().setPlaceHolder(1);
        }
        this.hRK.setHasPendantStyle();
        if (this.hRK.getPendantView() != null) {
            this.hRK.getPendantView().setIsRound(true);
            this.hRK.getPendantView().setDrawBorder(false);
        }
        this.gMr = (ThreadUserInfoLayout) view.findViewById(R.id.thread_user_info_layout);
        this.gMD = new NEGFeedBackView(this.mPageContext);
        this.gMD.a((ViewGroup) getView(), com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds92), com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds16));
        this.mTitle = (TextView) view.findViewById(R.id.thread_title);
        this.agm = (TextView) view.findViewById(R.id.thread_abstract);
        this.hTy = (OriginalThreadCardView) view.findViewById(R.id.original_thread_view);
        this.hTy.setSubClickListener(this.ail);
        this.gMs = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.thread_comment_layout);
        if (this.gMs.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gMs.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.gMs.setLayoutParams(layoutParams);
        }
        view.setOnClickListener(this);
        this.gMs.setOnClickListener(this);
        this.gMs.setReplyTimeVisible(false);
        this.gMs.setShowPraiseNum(true);
        this.gMs.setNeedAddPraiseIcon(true);
        this.gMs.setNeedAddReplyIcon(true);
        this.gMs.setShareVisible(true);
        this.gMs.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.v.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (v.this.cls() != null) {
                    v.this.cls().a(view2, v.this.hTT);
                }
                if (v.this.hTT != null && v.this.hTT.erH != null) {
                    n.II(v.this.hTT.erH.getId());
                    v.this.dk(v.this.hTT.erH.getId());
                }
            }
        });
        this.gNe = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.card_transmit_source_read_share_layout);
        this.gNe.eRI.setOnClickListener(this);
        this.gNe.eRI.setNeedAddReplyIcon(true);
        this.gNe.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.v.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (v.this.cls() != null) {
                    v.this.cls().a(view2, v.this.hTT);
                }
                if (view2 != v.this.gNe.eQX && v.this.hTT != null && v.this.hTT.erH != null) {
                    n.II(v.this.hTT.erH.getId());
                    v.this.dk(v.this.hTT.erH.getId());
                }
            }
        });
        this.hSh = view.findViewById(R.id.divider_line_above_praise);
        this.hTR = view.findViewById(R.id.card_divider_line);
        this.hTS = (TbImageView) view.findViewById(R.id.thread_theme_card);
        this.hTU = (TbImageView) view.findViewById(R.id.frs_normal_item_star_view);
        this.mMaskView = view.findViewById(R.id.thread_multi_del_mask_view);
        this.mMaskView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.v.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                v.this.gMs.changeSelectStatus();
            }
        });
        this.gMs.setOnSelectStatusChangeListener(new ThreadCommentAndPraiseInfoLayout.b() { // from class: com.baidu.tieba.card.v.4
            @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.b
            public void jj(boolean z) {
                ap.setBackgroundColor(v.this.mMaskView, z ? R.color.cp_bg_line_d : R.color.transparent);
            }
        });
    }

    private void Y(final bw bwVar) {
        if (this.hTU != null) {
            if (this.hTS == null || bwVar == null) {
                this.hTU.setVisibility(8);
            } else if (!StringUtils.isNull(bwVar.eAz) && this.hTS.getVisibility() != 0) {
                if (this.gMD != null && this.gMD.getVisibility() == 0 && (this.hTU.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hTU.getLayoutParams();
                    layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds106);
                    this.hTU.setLayoutParams(layoutParams);
                }
                this.hTU.setVisibility(0);
                this.hTU.setImageDrawable(null);
                this.hTU.startLoad(bwVar.eAz, 10, false);
                this.hTU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.v.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (v.this.mPageContext != null) {
                            v.this.mTbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ShareWebActivityConfig(v.this.mTbPageContext.getContext(), "", bwVar.eAA, true)));
                        }
                        TiebaStatic.log(new aq(CommonStatisticKey.KEY_FRS_STAR_PIC_CLICK));
                    }
                });
            } else {
                this.hTU.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(getView(), R.drawable.addresslist_item_bg);
            ap.setBackgroundColor(this.hSh, R.color.cp_bg_line_c);
            this.gMs.onChangeSkinType();
            this.gMr.onChangeSkinType();
            if (this.gMD != null) {
                this.gMD.onChangeSkinType();
            }
            this.hTy.onChangeSkinType();
            ap.setBackgroundColor(this.hTR, R.color.cp_bg_line_e);
            this.gNe.onChangeSkinType();
        }
        if (this.hTT != null && this.hTT.erH != null) {
            ap.setBackgroundColor(this.mMaskView, (this.hTT.erH.blL() || this.hTT.erH.blM()) ? R.color.cp_bg_line_d : R.color.transparent);
        }
        if (this.hRK != null && this.hRK.getHeadView() != null && (this.hRK.getHeadView() instanceof TbImageView)) {
            this.hRK.getHeadView().setPlaceHolder(1);
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
        if (bxVar == null || bxVar.erH == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        if (getView() != null) {
            getView().setVisibility(0);
        }
        this.hTT = bxVar;
        bw bwVar = bxVar.erH;
        if (this.gMD != null) {
            SparseArray<String> feedBackReasonMap = bwVar.getFeedBackReasonMap();
            if (feedBackReasonMap != null && feedBackReasonMap.size() > 0 && this.hSl) {
                ar arVar = new ar();
                arVar.setTid(bwVar.getTid());
                arVar.setFid(bwVar.getFid());
                arVar.setNid(bwVar.getNid());
                arVar.setFeedBackReasonMap(feedBackReasonMap);
                arVar.evN = bwVar.evN;
                this.gMD.setData(arVar);
                this.gMD.setFirstRowSingleColumn(true);
                this.gMD.setVisibility(aa(bwVar) ? 8 : 0);
            } else {
                this.gMD.setVisibility(8);
            }
        }
        if (this.hTT.eBz == 1) {
            this.gMr.setFrom(3);
            b(bwVar);
            Y(bwVar);
        }
        this.gMr.setIsFromConcern(this.eRV);
        this.gMr.setData(bwVar);
        this.gMr.setUserAfterClickListener(this.ajG);
        if (this.gMr.getHeaderImg() != null) {
            if (this.gMr.getIsSimpleThread()) {
                this.gMr.getHeaderImg().setVisibility(8);
                this.hRK.setVisibility(8);
            } else if (bwVar.bka() == null || bwVar.bka().getPendantData() == null || StringUtils.isNull(bwVar.bka().getPendantData().bhW())) {
                this.hRK.setVisibility(8);
                this.gMr.getHeaderImg().setVisibility(0);
                this.gMr.getHeaderImg().setData(bwVar);
            } else {
                this.gMr.getHeaderImg().setVisibility(4);
                this.hRK.setVisibility(0);
                this.hRK.setData(bwVar);
            }
        }
        Z(bwVar);
        this.hTy.b(bwVar.eAy);
        uS(sZ(1));
        setPageUniqueId(getTag());
        onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        dk(bwVar.getId());
        if (this.gMs.isInFrsAllThread() && (com.baidu.tieba.frs.b.cuL().cuF() || com.baidu.tieba.frs.a.cuE().cuF())) {
            this.mMaskView.setVisibility(0);
            if (bwVar.blL() || bwVar.blM() || bwVar.blN()) {
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
            if (!StringUtils.isNull(this.mUrl) && !StringUtils.isNull(this.ezR)) {
                bwVar.dG(this.mUrl, this.ezR);
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
        if (bwVar == null || bwVar.bka() == null || StringUtils.isNull(bwVar.bka().getUserId())) {
            return false;
        }
        return bwVar.bka().getUserId().equals(TbadkCoreApplication.getCurrentAccount());
    }

    public void o(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.gMD != null) {
            this.gMD.setUniqueId(bdUniqueId);
        }
        if (this.gMr != null) {
            this.gMr.setPageUniqueId(bdUniqueId);
        }
    }

    public void oq(boolean z) {
        if (this.hTR != null) {
            this.hTR.setVisibility(z ? 0 : 8);
        }
    }

    public void ol(boolean z) {
        this.hSl = z;
    }

    private void bvc() {
        if (this.hTT != null && this.hTT.erH != null) {
            bw bwVar = this.hTT.erH;
            n.II(bwVar.getId());
            dk(bwVar.getId());
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(bwVar, null, this.hTT.stType, RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false);
            createFromThreadCfg.setStartFrom(this.currentPageType);
            createFromThreadCfg.setIsShareThread(true);
            n.II(bwVar.getTid());
            this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dk(String str) {
        n.a(this.mTitle, str, R.color.cp_cont_b, R.color.cp_cont_d);
        n.a(this.agm, str, R.color.cp_cont_b, R.color.cp_cont_d);
        this.hTy.setReadState(n.IJ(str));
    }

    public void b(bw bwVar) {
        MetaData bka;
        if (bwVar != null && this.hTS != null && (bka = bwVar.bka()) != null) {
            final ThemeCardInUserData themeCard = bka.getThemeCard();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                this.hTS.setVisibility(8);
                return;
            }
            this.hTS.setVisibility(0);
            this.hTS.setImageBitmap(null);
            this.hTS.startLoad(themeCard.getCardImageUrlAndroid(), 10, false);
            this.hTS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.v.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonalCardDetailActivityConfig(v.this.mPageContext.getPageActivity(), themeCard.getCardId())));
                }
            });
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (cls() != null) {
            cls().a(view, this.hTT);
        }
        if (view == getView() || view.getId() == R.id.thread_content_layout_outter) {
            bvc();
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.gMr != null) {
            return this.gMr.eRr;
        }
        return null;
    }

    public View clw() {
        if (this.gMr != null) {
            return this.gMr.aju;
        }
        return null;
    }

    public void uS(int i) {
        if (this.hTT != null && this.hTT.erH != null) {
            if (i == 1) {
                this.gMs.setVisibility(8);
                this.gNe.setFrom(this.hTT.eBy);
                this.gNe.setShareReportFrom(this.hTT.eBz);
                this.gNe.setStType(this.hTT.stType);
                this.gNe.setData(this.hTT.erH);
                this.gMr.jk(false);
                return;
            }
            this.gMs.setFrom(this.hTT.eBy);
            this.gMs.setShareReportFrom(this.hTT.eBz);
            this.gMs.setStType(this.hTT.stType);
            this.gMs.setData(this.hTT.erH);
            this.gMs.setDisPraiseFrom(this.hTT.eBA);
            this.gNe.setVisibility(8);
            this.gMr.jk(true);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.ahu = str;
    }

    public int sZ(int i) {
        return com.baidu.tieba.a.d.bGs().av(this.ahu, i);
    }
}
