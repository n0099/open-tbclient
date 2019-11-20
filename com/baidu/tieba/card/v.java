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
import com.baidu.tbadk.core.data.aj;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.data.bi;
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
/* loaded from: classes3.dex */
public class v extends a<bi> implements com.baidu.tieba.a.e {
    private TextView Fk;
    private OriginalThreadCardView.a GM;
    private String Gc;
    private final View.OnClickListener Ho;
    private boolean Hx;
    private String ccw;
    private boolean cri;
    public ThreadCommentAndPraiseInfoLayout dSA;
    private NEGFeedBackView dSM;
    public ThreadUserInfoLayout dSz;
    public ThreadSourceShareAndPraiseLayout dTo;
    private HeadPendantClickableView eLQ;
    private View eMp;
    private boolean eMt;
    public OriginalThreadCardView eNF;
    private View eNY;
    private TbImageView eNZ;
    private bi eOa;
    private TbImageView eOb;
    private ViewGroup eOc;
    private View mMaskView;
    private TbPageContext<?> mPageContext;
    private TextView mTitle;
    private String mUrl;

    public v(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.dSM = null;
        this.Hx = true;
        this.eMt = true;
        this.Ho = new View.OnClickListener() { // from class: com.baidu.tieba.card.v.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (v.this.aZV() != null) {
                    v.this.aZV().a(view, v.this.eOa);
                }
            }
        };
        this.GM = new OriginalThreadCardView.a() { // from class: com.baidu.tieba.card.v.8
            @Override // com.baidu.tieba.card.OriginalThreadCardView.a
            public void a(OriginalThreadInfo originalThreadInfo) {
                if (v.this.eOa != null && v.this.eOa.caz != null) {
                    if (v.this.aZV() != null) {
                        v.this.aZV().a(v.this.eNF, v.this.eOa);
                    }
                    String id = v.this.eOa.caz.getId();
                    n.uz(id);
                    v.this.bt(id);
                }
            }
        };
        this.mPageContext = tbPageContext;
        View view = getView();
        this.eOc = (ViewGroup) view.findViewById(R.id.thread_content_layout_outter);
        this.eOc.setOnClickListener(this);
        this.eLQ = (HeadPendantClickableView) view.findViewById(R.id.thread_user_pendant_header);
        if (this.eLQ.getHeadView() != null) {
            this.eLQ.getHeadView().setIsRound(true);
            this.eLQ.getHeadView().setDrawBorder(false);
            this.eLQ.getHeadView().setDefaultResource(17170445);
            this.eLQ.getHeadView().setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.eLQ.getHeadView().setRadius(com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds70));
        }
        this.eLQ.setHasPendantStyle();
        if (this.eLQ.getPendantView() != null) {
            this.eLQ.getPendantView().setIsRound(true);
            this.eLQ.getPendantView().setDrawBorder(false);
        }
        this.dSz = (ThreadUserInfoLayout) view.findViewById(R.id.thread_user_info_layout);
        this.dSM = new NEGFeedBackView(this.mPageContext);
        this.dSM.a((ViewGroup) getView(), com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds92), com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds16));
        this.mTitle = (TextView) view.findViewById(R.id.thread_title);
        this.Fk = (TextView) view.findViewById(R.id.thread_abstract);
        this.eNF = (OriginalThreadCardView) view.findViewById(R.id.original_thread_view);
        this.eNF.setSubClickListener(this.GM);
        this.dSA = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.thread_comment_layout);
        if (this.dSA.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dSA.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.dSA.setLayoutParams(layoutParams);
        }
        view.setOnClickListener(this);
        this.dSA.setOnClickListener(this);
        this.dSA.setReplyTimeVisible(false);
        this.dSA.setShowPraiseNum(true);
        this.dSA.setNeedAddPraiseIcon(true);
        this.dSA.setNeedAddReplyIcon(true);
        this.dSA.setShareVisible(true);
        this.dSA.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.v.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (v.this.aZV() != null) {
                    v.this.aZV().a(view2, v.this.eOa);
                }
                if (v.this.eOa != null && v.this.eOa.caz != null) {
                    n.uz(v.this.eOa.caz.getId());
                    v.this.bt(v.this.eOa.caz.getId());
                }
            }
        });
        this.dTo = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.card_transmit_source_read_share_layout);
        this.dTo.cqW.setOnClickListener(this);
        this.dTo.cqW.setNeedAddReplyIcon(true);
        this.dTo.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.v.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (v.this.aZV() != null) {
                    v.this.aZV().a(view2, v.this.eOa);
                }
                if (view2 != v.this.dTo.cql && v.this.eOa != null && v.this.eOa.caz != null) {
                    n.uz(v.this.eOa.caz.getId());
                    v.this.bt(v.this.eOa.caz.getId());
                }
            }
        });
        this.eMp = view.findViewById(R.id.divider_line_above_praise);
        this.eNY = view.findViewById(R.id.card_divider_line);
        this.eNZ = (TbImageView) view.findViewById(R.id.thread_theme_card);
        this.eOb = (TbImageView) view.findViewById(R.id.frs_normal_item_star_view);
        this.mMaskView = view.findViewById(R.id.thread_multi_del_mask_view);
        this.mMaskView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.v.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                v.this.dSA.changeSelectStatus();
            }
        });
        this.dSA.setOnSelectStatusChangeListener(new ThreadCommentAndPraiseInfoLayout.a() { // from class: com.baidu.tieba.card.v.4
            @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.a
            public void ev(boolean z) {
                am.setBackgroundColor(v.this.mMaskView, z ? R.color.cp_bg_line_d : R.color.transparent);
            }
        });
    }

    private void R(final bh bhVar) {
        if (this.eOb != null) {
            if (this.eNZ == null || bhVar == null) {
                this.eOb.setVisibility(8);
            } else if (!StringUtils.isNull(bhVar.cdm) && this.eNZ.getVisibility() != 0) {
                if (this.dSM != null && this.dSM.getVisibility() == 0 && (this.eOb.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eOb.getLayoutParams();
                    layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds106);
                    this.eOb.setLayoutParams(layoutParams);
                }
                this.eOb.setVisibility(0);
                this.eOb.setImageDrawable(null);
                this.eOb.startLoad(bhVar.cdm, 10, false);
                this.eOb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.v.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (v.this.mPageContext != null) {
                            v.this.mTbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ShareWebActivityConfig(v.this.mTbPageContext.getContext(), "", bhVar.cdn, true)));
                        }
                        TiebaStatic.log(new an(CommonStatisticKey.KEY_FRS_STAR_PIC_CLICK));
                    }
                });
            } else {
                this.eOb.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(getView(), R.drawable.addresslist_item_bg);
            am.setBackgroundColor(this.eMp, R.color.cp_bg_line_c);
            this.dSA.onChangeSkinType();
            this.dSz.onChangeSkinType();
            if (this.dSM != null) {
                this.dSM.onChangeSkinType();
            }
            this.eNF.onChangeSkinType();
            am.setBackgroundColor(this.eNY, R.color.cp_bg_line_e);
            this.dTo.onChangeSkinType();
        }
        if (this.eOa != null && this.eOa.caz != null) {
            am.setBackgroundColor(this.mMaskView, this.eOa.caz.akm() ? R.color.cp_bg_line_d : R.color.transparent);
        }
        if (this.eLQ != null && this.eLQ.getHeadView() != null && (this.eLQ.getHeadView() instanceof TbImageView)) {
            this.eLQ.getHeadView().setDefaultBgResource(com.baidu.tbadk.util.e.Vj());
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.card_transmit_thread_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(bi biVar) {
        if (biVar == null || biVar.caz == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        if (getView() != null) {
            getView().setVisibility(0);
        }
        this.eOa = biVar;
        bh bhVar = biVar.caz;
        if (this.dSM != null) {
            SparseArray<String> feedBackReasonMap = bhVar.getFeedBackReasonMap();
            if (feedBackReasonMap != null && feedBackReasonMap.size() > 0 && this.eMt) {
                aj ajVar = new aj();
                ajVar.setTid(bhVar.getTid());
                ajVar.setFid(bhVar.getFid());
                ajVar.setFeedBackReasonMap(feedBackReasonMap);
                this.dSM.setData(ajVar);
                this.dSM.setFirstRowSingleColumn(true);
                this.dSM.setVisibility(T(bhVar) ? 8 : 0);
            } else {
                this.dSM.setVisibility(8);
            }
        }
        if (this.eOa.cdP == 1) {
            this.dSz.setFrom(3);
            b(bhVar);
            R(bhVar);
        }
        if (this.currentPageType == 15) {
            this.dSz.setFrom(5);
        }
        this.dSz.setIsFromConcern(this.cri);
        this.dSz.setData(bhVar);
        this.dSz.setUserAfterClickListener(this.Ho);
        if (this.dSz.getHeaderImg() != null) {
            if (this.dSz.getIsSimpleThread()) {
                this.dSz.getHeaderImg().setVisibility(8);
                this.eLQ.setVisibility(8);
            } else if (bhVar.aiE() == null || bhVar.aiE().getPendantData() == null || StringUtils.isNull(bhVar.aiE().getPendantData().ahd())) {
                this.eLQ.setVisibility(8);
                this.dSz.getHeaderImg().setVisibility(0);
                this.dSz.getHeaderImg().setData(bhVar);
            } else {
                this.dSz.getHeaderImg().setVisibility(4);
                this.eLQ.setVisibility(0);
                this.eLQ.setData(bhVar);
            }
        }
        S(bhVar);
        this.eNF.b(bhVar.cdl);
        mY(lx(1));
        setPageUniqueId(getTag());
        onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        bt(bhVar.getId());
        if (this.dSA.isInFrsAllThread() && com.baidu.tieba.frs.a.biU().biV()) {
            this.mMaskView.setVisibility(0);
            if (bhVar.akm() || bhVar.akn()) {
                am.setBackgroundColor(this.mMaskView, R.color.cp_bg_line_d);
                return;
            } else {
                this.mMaskView.setBackgroundResource(R.color.transparent);
                return;
            }
        }
        this.mMaskView.setVisibility(8);
    }

    private void S(bh bhVar) {
        if (bhVar != null) {
            if (!StringUtils.isNull(this.mUrl) && !StringUtils.isNull(this.ccw)) {
                bhVar.bI(this.mUrl, this.ccw);
            }
            SpannableStringBuilder s = bhVar.s(false, true);
            if (s == null || StringUtils.isNull(s.toString())) {
                this.mTitle.setVisibility(8);
                return;
            }
            this.mTitle.setVisibility(0);
            this.mTitle.setOnTouchListener(new com.baidu.tieba.view.k(s));
            this.mTitle.setText(s);
            n.a(this.mTitle, bhVar.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
        }
    }

    private boolean T(bh bhVar) {
        if (bhVar == null || bhVar.aiE() == null || StringUtils.isNull(bhVar.aiE().getUserId())) {
            return false;
        }
        return bhVar.aiE().getUserId().equals(TbadkCoreApplication.getCurrentAccount());
    }

    public void l(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.dSM != null) {
            this.dSM.setUniqueId(bdUniqueId);
        }
        if (this.dSz != null) {
            this.dSz.setPageUniqueId(bdUniqueId);
        }
    }

    public void iL(boolean z) {
        if (this.eNY != null) {
            this.eNY.setVisibility(z ? 0 : 8);
        }
    }

    public void iH(boolean z) {
        this.eMt = z;
    }

    private void ash() {
        if (this.eOa != null && this.eOa.caz != null) {
            bh bhVar = this.eOa.caz;
            n.uz(bhVar.getId());
            bt(bhVar.getId());
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(bhVar, null, this.eOa.stType, RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false);
            createFromThreadCfg.setStartFrom(this.currentPageType);
            createFromThreadCfg.setIsShareThread(true);
            n.uz(bhVar.getTid());
            this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bt(String str) {
        n.a(this.mTitle, str, (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
        n.a(this.Fk, str, (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
        this.eNF.setReadState(n.uA(str));
    }

    public void b(bh bhVar) {
        MetaData aiE;
        if (bhVar != null && this.eNZ != null && (aiE = bhVar.aiE()) != null) {
            final ThemeCardInUserData themeCard = aiE.getThemeCard();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                this.eNZ.setVisibility(8);
                return;
            }
            this.eNZ.setVisibility(0);
            this.eNZ.setImageBitmap(null);
            this.eNZ.startLoad(themeCard.getCardImageUrlAndroid(), 10, false);
            this.eNZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.v.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonalCardDetailActivityConfig(v.this.mPageContext.getPageActivity(), themeCard.getCardId())));
                }
            });
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (aZV() != null) {
            aZV().a(view, this.eOa);
        }
        if (view == getView() || view.getId() == R.id.thread_content_layout_outter) {
            ash();
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.dSz != null) {
            return this.dSz.cqE;
        }
        return null;
    }

    public View baa() {
        if (this.dSz != null) {
            return this.dSz.He;
        }
        return null;
    }

    public void mY(int i) {
        if (this.eOa != null && this.eOa.caz != null) {
            if (i == 1) {
                this.dSA.setVisibility(8);
                this.dTo.setFrom(this.eOa.cdO);
                this.dTo.setShareReportFrom(this.eOa.cdP);
                this.dTo.setStType(this.eOa.stType);
                this.dTo.setData(this.eOa.caz);
                this.dSz.et(false);
                return;
            }
            this.dSA.setFrom(this.eOa.cdO);
            this.dSA.setShareReportFrom(this.eOa.cdP);
            this.dSA.setStType(this.eOa.stType);
            this.dSA.setData(this.eOa.caz);
            this.dSA.setDisPraiseFrom(this.eOa.cdQ);
            this.dTo.setVisibility(8);
            this.dSz.et(true);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.Gc = str;
    }

    public int lx(int i) {
        return com.baidu.tieba.a.d.aDc().X(this.Gc, i);
    }
}
