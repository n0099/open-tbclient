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
import com.baidu.tbadk.core.data.at;
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
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
public class v extends b<bz> implements com.baidu.tieba.a.e {
    private TextView ahp;
    private String aiw;
    private OriginalThreadCardView.a ajn;
    private final View.OnClickListener akI;
    private boolean alo;
    private String eLa;
    private boolean feo;
    public ThreadUserInfoLayout hbK;
    public ThreadCommentAndPraiseInfoLayout hbL;
    private NEGFeedBackView hbW;
    public ThreadSourceShareAndPraiseLayout hcx;
    private View ijB;
    private boolean ijF;
    private HeadPendantClickableView ije;
    public OriginalThreadCardView ikR;
    private View ill;
    private TbImageView ilm;
    private bz iln;
    private TbImageView ilo;
    private ViewGroup ilp;
    private View mMaskView;
    private TbPageContext<?> mPageContext;
    private TextView mTitle;
    private String mUrl;

    public v(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.hbW = null;
        this.alo = true;
        this.ijF = true;
        this.akI = new View.OnClickListener() { // from class: com.baidu.tieba.card.v.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (v.this.crI() != null) {
                    v.this.crI().a(view, v.this.iln);
                }
            }
        };
        this.ajn = new OriginalThreadCardView.a() { // from class: com.baidu.tieba.card.v.8
            @Override // com.baidu.tieba.card.OriginalThreadCardView.a
            public void a(OriginalThreadInfo originalThreadInfo) {
                if (v.this.iln != null && v.this.iln.eCR != null) {
                    if (v.this.crI() != null) {
                        v.this.crI().a(v.this.ikR, v.this.iln);
                    }
                    String id = v.this.iln.eCR.getId();
                    n.Jq(id);
                    v.this.dp(id);
                }
            }
        };
        this.mPageContext = tbPageContext;
        View view = getView();
        this.ilp = (ViewGroup) view.findViewById(R.id.thread_content_layout_outter);
        this.ilp.setOnClickListener(this);
        this.ije = (HeadPendantClickableView) view.findViewById(R.id.thread_user_pendant_header);
        if (this.ije.getHeadView() != null) {
            this.ije.getHeadView().setIsRound(true);
            this.ije.getHeadView().setDrawBorder(false);
            this.ije.getHeadView().setDefaultResource(17170445);
            this.ije.getHeadView().setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.ije.getHeadView().setRadius(com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds70));
            this.ije.getHeadView().setPlaceHolder(1);
        }
        this.ije.setHasPendantStyle();
        if (this.ije.getPendantView() != null) {
            this.ije.getPendantView().setIsRound(true);
            this.ije.getPendantView().setDrawBorder(false);
        }
        this.hbK = (ThreadUserInfoLayout) view.findViewById(R.id.thread_user_info_layout);
        this.hbW = new NEGFeedBackView(this.mPageContext);
        this.hbW.a((ViewGroup) getView(), com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds92), com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds16));
        this.mTitle = (TextView) view.findViewById(R.id.thread_title);
        this.ahp = (TextView) view.findViewById(R.id.thread_abstract);
        this.ikR = (OriginalThreadCardView) view.findViewById(R.id.original_thread_view);
        this.ikR.setSubClickListener(this.ajn);
        this.hbL = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.thread_comment_layout);
        if (this.hbL.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hbL.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.hbL.setLayoutParams(layoutParams);
        }
        view.setOnClickListener(this);
        this.hbL.setOnClickListener(this);
        this.hbL.setReplyTimeVisible(false);
        this.hbL.setShowPraiseNum(true);
        this.hbL.setNeedAddPraiseIcon(true);
        this.hbL.setNeedAddReplyIcon(true);
        this.hbL.setShareVisible(true);
        this.hbL.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.v.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (v.this.crI() != null) {
                    v.this.crI().a(view2, v.this.iln);
                }
                if (v.this.iln != null && v.this.iln.eCR != null) {
                    n.Jq(v.this.iln.eCR.getId());
                    v.this.dp(v.this.iln.eCR.getId());
                }
            }
        });
        this.hcx = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.card_transmit_source_read_share_layout);
        this.hcx.feb.setOnClickListener(this);
        this.hcx.feb.setNeedAddReplyIcon(true);
        this.hcx.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.v.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (v.this.crI() != null) {
                    v.this.crI().a(view2, v.this.iln);
                }
                if (view2 != v.this.hcx.fdq && v.this.iln != null && v.this.iln.eCR != null) {
                    n.Jq(v.this.iln.eCR.getId());
                    v.this.dp(v.this.iln.eCR.getId());
                }
            }
        });
        this.ijB = view.findViewById(R.id.divider_line_above_praise);
        this.ill = view.findViewById(R.id.card_divider_line);
        this.ilm = (TbImageView) view.findViewById(R.id.thread_theme_card);
        this.ilo = (TbImageView) view.findViewById(R.id.frs_normal_item_star_view);
        this.mMaskView = view.findViewById(R.id.thread_multi_del_mask_view);
        this.mMaskView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.v.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                v.this.hbL.changeSelectStatus();
            }
        });
        this.hbL.setOnSelectStatusChangeListener(new ThreadCommentAndPraiseInfoLayout.b() { // from class: com.baidu.tieba.card.v.4
            @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.b
            public void jJ(boolean z) {
                ap.setBackgroundColor(v.this.mMaskView, z ? R.color.CAM_X0201 : R.color.transparent);
            }
        });
    }

    private void aa(final by byVar) {
        if (this.ilo != null) {
            if (this.ilm == null || byVar == null) {
                this.ilo.setVisibility(8);
            } else if (!StringUtils.isNull(byVar.eLI) && this.ilm.getVisibility() != 0) {
                if (this.hbW != null && this.hbW.getVisibility() == 0 && (this.ilo.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.ilo.getLayoutParams();
                    layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds106);
                    this.ilo.setLayoutParams(layoutParams);
                }
                this.ilo.setVisibility(0);
                this.ilo.setImageDrawable(null);
                this.ilo.startLoad(byVar.eLI, 10, false);
                this.ilo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.v.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (v.this.mPageContext != null) {
                            v.this.mTbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ShareWebActivityConfig(v.this.mTbPageContext.getContext(), "", byVar.eLJ, true)));
                        }
                        TiebaStatic.log(new ar(CommonStatisticKey.KEY_FRS_STAR_PIC_CLICK));
                    }
                });
            } else {
                this.ilo.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(getView(), R.drawable.addresslist_item_bg);
            ap.setBackgroundColor(this.ijB, R.color.CAM_X0204);
            this.hbL.onChangeSkinType();
            this.hbK.onChangeSkinType();
            if (this.hbW != null) {
                this.hbW.onChangeSkinType();
            }
            this.ikR.onChangeSkinType();
            ap.setBackgroundColor(this.ill, R.color.CAM_X0205);
            this.hcx.onChangeSkinType();
        }
        if (this.iln != null && this.iln.eCR != null) {
            ap.setBackgroundColor(this.mMaskView, (this.iln.eCR.bqC() || this.iln.eCR.bqD()) ? R.color.CAM_X0201 : R.color.transparent);
        }
        if (this.ije != null && this.ije.getHeadView() != null && (this.ije.getHeadView() instanceof TbImageView)) {
            this.ije.getHeadView().setPlaceHolder(1);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.card_transmit_thread_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(bz bzVar) {
        if (bzVar == null || bzVar.eCR == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        if (getView() != null) {
            getView().setVisibility(0);
        }
        this.iln = bzVar;
        by byVar = bzVar.eCR;
        if (this.hbW != null) {
            SparseArray<String> feedBackReasonMap = byVar.getFeedBackReasonMap();
            if (feedBackReasonMap != null && feedBackReasonMap.size() > 0 && this.ijF) {
                at atVar = new at();
                atVar.setTid(byVar.getTid());
                atVar.setFid(byVar.getFid());
                atVar.setNid(byVar.getNid());
                atVar.setFeedBackReasonMap(feedBackReasonMap);
                atVar.eGW = byVar.eGW;
                this.hbW.setData(atVar);
                this.hbW.setFirstRowSingleColumn(true);
                this.hbW.setVisibility(ac(byVar) ? 8 : 0);
            } else {
                this.hbW.setVisibility(8);
            }
        }
        if (this.iln.eMJ == 1) {
            this.hbK.setFrom(3);
            b(byVar);
            aa(byVar);
        }
        this.hbK.setIsFromConcern(this.feo);
        this.hbK.setData(byVar);
        this.hbK.setUserAfterClickListener(this.akI);
        if (this.hbK.getHeaderImg() != null) {
            if (this.hbK.getIsSimpleThread()) {
                this.hbK.getHeaderImg().setVisibility(8);
                this.ije.setVisibility(8);
            } else if (byVar.boP() == null || byVar.boP().getPendantData() == null || StringUtils.isNull(byVar.boP().getPendantData().bmL())) {
                this.ije.setVisibility(8);
                this.hbK.getHeaderImg().setVisibility(0);
                this.hbK.getHeaderImg().setData(byVar);
            } else {
                this.hbK.getHeaderImg().setVisibility(4);
                this.ije.setVisibility(0);
                this.ije.setData(byVar);
            }
        }
        ab(byVar);
        this.ikR.b(byVar.eLH);
        wk(ul(1));
        setPageUniqueId(getTag());
        onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        dp(byVar.getId());
        if (this.hbL.isInFrsAllThread() && (com.baidu.tieba.frs.b.cBd().cAX() || com.baidu.tieba.frs.a.cAW().cAX())) {
            this.mMaskView.setVisibility(0);
            if (byVar.bqC() || byVar.bqD() || byVar.bqE()) {
                ap.setBackgroundColor(this.mMaskView, R.color.CAM_X0201);
                return;
            } else {
                this.mMaskView.setBackgroundResource(R.color.transparent);
                return;
            }
        }
        this.mMaskView.setVisibility(8);
    }

    private void ab(by byVar) {
        if (byVar != null) {
            if (!StringUtils.isNull(this.mUrl) && !StringUtils.isNull(this.eLa)) {
                byVar.dL(this.mUrl, this.eLa);
            }
            SpannableStringBuilder B = byVar.B(false, true);
            if (B == null || StringUtils.isNull(B.toString())) {
                this.mTitle.setVisibility(8);
                return;
            }
            this.mTitle.setVisibility(0);
            this.mTitle.setOnTouchListener(new com.baidu.tieba.view.i(B));
            this.mTitle.setText(B);
            n.a(this.mTitle, byVar.getId(), R.color.CAM_X0105, R.color.CAM_X0109);
        }
    }

    private boolean ac(by byVar) {
        if (byVar == null || byVar.boP() == null || StringUtils.isNull(byVar.boP().getUserId())) {
            return false;
        }
        return byVar.boP().getUserId().equals(TbadkCoreApplication.getCurrentAccount());
    }

    public void o(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.hbW != null) {
            this.hbW.setUniqueId(bdUniqueId);
        }
        if (this.hbK != null) {
            this.hbK.setPageUniqueId(bdUniqueId);
        }
    }

    public void oY(boolean z) {
        if (this.ill != null) {
            this.ill.setVisibility(z ? 0 : 8);
        }
    }

    public void oT(boolean z) {
        this.ijF = z;
    }

    private void bAr() {
        if (this.iln != null && this.iln.eCR != null) {
            by byVar = this.iln.eCR;
            n.Jq(byVar.getId());
            dp(byVar.getId());
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(byVar, null, this.iln.stType, RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false);
            createFromThreadCfg.setStartFrom(this.currentPageType);
            createFromThreadCfg.setIsShareThread(true);
            n.Jq(byVar.getTid());
            this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dp(String str) {
        n.a(this.mTitle, str, R.color.CAM_X0105, R.color.CAM_X0109);
        n.a(this.ahp, str, R.color.CAM_X0105, R.color.CAM_X0109);
        this.ikR.setReadState(n.Jr(str));
    }

    public void b(by byVar) {
        MetaData boP;
        if (byVar != null && this.ilm != null && (boP = byVar.boP()) != null) {
            final ThemeCardInUserData themeCard = boP.getThemeCard();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                this.ilm.setVisibility(8);
                return;
            }
            this.ilm.setVisibility(0);
            this.ilm.setImageBitmap(null);
            this.ilm.startLoad(themeCard.getCardImageUrlAndroid(), 10, false);
            this.ilm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.v.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonalCardDetailActivityConfig(v.this.mPageContext.getPageActivity(), themeCard.getCardId())));
                }
            });
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (crI() != null) {
            crI().a(view, this.iln);
        }
        if (view == getView() || view.getId() == R.id.thread_content_layout_outter) {
            bAr();
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.hbK != null) {
            return this.hbK.fdK;
        }
        return null;
    }

    public View crM() {
        if (this.hbK != null) {
            return this.hbK.aky;
        }
        return null;
    }

    public void wk(int i) {
        if (this.iln != null && this.iln.eCR != null) {
            if (i == 1) {
                this.hbL.setVisibility(8);
                this.hcx.setFrom(this.iln.eMI);
                this.hcx.setShareReportFrom(this.iln.eMJ);
                this.hcx.setStType(this.iln.stType);
                this.hcx.setData(this.iln.eCR);
                this.hbK.jK(false);
                return;
            }
            this.hbL.setFrom(this.iln.eMI);
            this.hbL.setShareReportFrom(this.iln.eMJ);
            this.hbL.setStType(this.iln.stType);
            this.hbL.setData(this.iln.eCR);
            this.hbL.setDisPraiseFrom(this.iln.eMK);
            this.hcx.setVisibility(8);
            this.hbK.jK(true);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.aiw = str;
    }

    public int ul(int i) {
        return com.baidu.tieba.a.d.bLT().ax(this.aiw, i);
    }
}
