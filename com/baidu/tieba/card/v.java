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
    private TextView FK;
    private String GC;
    private final View.OnClickListener HO;
    private boolean HY;
    private OriginalThreadCardView.a Ho;
    private String cdn;
    private boolean crZ;
    private NEGFeedBackView dTD;
    public ThreadUserInfoLayout dTq;
    public ThreadCommentAndPraiseInfoLayout dTr;
    public ThreadSourceShareAndPraiseLayout dUf;
    private HeadPendantClickableView eMH;
    private View eNg;
    private boolean eNk;
    private View eOP;
    private TbImageView eOQ;
    private bi eOR;
    private TbImageView eOS;
    private ViewGroup eOT;
    public OriginalThreadCardView eOw;
    private View mMaskView;
    private TbPageContext<?> mPageContext;
    private TextView mTitle;
    private String mUrl;

    public v(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.dTD = null;
        this.HY = true;
        this.eNk = true;
        this.HO = new View.OnClickListener() { // from class: com.baidu.tieba.card.v.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (v.this.aZX() != null) {
                    v.this.aZX().a(view, v.this.eOR);
                }
            }
        };
        this.Ho = new OriginalThreadCardView.a() { // from class: com.baidu.tieba.card.v.8
            @Override // com.baidu.tieba.card.OriginalThreadCardView.a
            public void a(OriginalThreadInfo originalThreadInfo) {
                if (v.this.eOR != null && v.this.eOR.cbq != null) {
                    if (v.this.aZX() != null) {
                        v.this.aZX().a(v.this.eOw, v.this.eOR);
                    }
                    String id = v.this.eOR.cbq.getId();
                    n.uz(id);
                    v.this.bt(id);
                }
            }
        };
        this.mPageContext = tbPageContext;
        View view = getView();
        this.eOT = (ViewGroup) view.findViewById(R.id.thread_content_layout_outter);
        this.eOT.setOnClickListener(this);
        this.eMH = (HeadPendantClickableView) view.findViewById(R.id.thread_user_pendant_header);
        if (this.eMH.getHeadView() != null) {
            this.eMH.getHeadView().setIsRound(true);
            this.eMH.getHeadView().setDrawBorder(false);
            this.eMH.getHeadView().setDefaultResource(17170445);
            this.eMH.getHeadView().setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.eMH.getHeadView().setRadius(com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds70));
        }
        this.eMH.setHasPendantStyle();
        if (this.eMH.getPendantView() != null) {
            this.eMH.getPendantView().setIsRound(true);
            this.eMH.getPendantView().setDrawBorder(false);
        }
        this.dTq = (ThreadUserInfoLayout) view.findViewById(R.id.thread_user_info_layout);
        this.dTD = new NEGFeedBackView(this.mPageContext);
        this.dTD.a((ViewGroup) getView(), com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds92), com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds16));
        this.mTitle = (TextView) view.findViewById(R.id.thread_title);
        this.FK = (TextView) view.findViewById(R.id.thread_abstract);
        this.eOw = (OriginalThreadCardView) view.findViewById(R.id.original_thread_view);
        this.eOw.setSubClickListener(this.Ho);
        this.dTr = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.thread_comment_layout);
        if (this.dTr.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dTr.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.dTr.setLayoutParams(layoutParams);
        }
        view.setOnClickListener(this);
        this.dTr.setOnClickListener(this);
        this.dTr.setReplyTimeVisible(false);
        this.dTr.setShowPraiseNum(true);
        this.dTr.setNeedAddPraiseIcon(true);
        this.dTr.setNeedAddReplyIcon(true);
        this.dTr.setShareVisible(true);
        this.dTr.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.v.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (v.this.aZX() != null) {
                    v.this.aZX().a(view2, v.this.eOR);
                }
                if (v.this.eOR != null && v.this.eOR.cbq != null) {
                    n.uz(v.this.eOR.cbq.getId());
                    v.this.bt(v.this.eOR.cbq.getId());
                }
            }
        });
        this.dUf = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.card_transmit_source_read_share_layout);
        this.dUf.crO.setOnClickListener(this);
        this.dUf.crO.setNeedAddReplyIcon(true);
        this.dUf.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.v.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (v.this.aZX() != null) {
                    v.this.aZX().a(view2, v.this.eOR);
                }
                if (view2 != v.this.dUf.crd && v.this.eOR != null && v.this.eOR.cbq != null) {
                    n.uz(v.this.eOR.cbq.getId());
                    v.this.bt(v.this.eOR.cbq.getId());
                }
            }
        });
        this.eNg = view.findViewById(R.id.divider_line_above_praise);
        this.eOP = view.findViewById(R.id.card_divider_line);
        this.eOQ = (TbImageView) view.findViewById(R.id.thread_theme_card);
        this.eOS = (TbImageView) view.findViewById(R.id.frs_normal_item_star_view);
        this.mMaskView = view.findViewById(R.id.thread_multi_del_mask_view);
        this.mMaskView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.v.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                v.this.dTr.changeSelectStatus();
            }
        });
        this.dTr.setOnSelectStatusChangeListener(new ThreadCommentAndPraiseInfoLayout.a() { // from class: com.baidu.tieba.card.v.4
            @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.a
            public void ev(boolean z) {
                am.setBackgroundColor(v.this.mMaskView, z ? R.color.cp_bg_line_d : R.color.transparent);
            }
        });
    }

    private void R(final bh bhVar) {
        if (this.eOS != null) {
            if (this.eOQ == null || bhVar == null) {
                this.eOS.setVisibility(8);
            } else if (!StringUtils.isNull(bhVar.ced) && this.eOQ.getVisibility() != 0) {
                if (this.dTD != null && this.dTD.getVisibility() == 0 && (this.eOS.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eOS.getLayoutParams();
                    layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds106);
                    this.eOS.setLayoutParams(layoutParams);
                }
                this.eOS.setVisibility(0);
                this.eOS.setImageDrawable(null);
                this.eOS.startLoad(bhVar.ced, 10, false);
                this.eOS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.v.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (v.this.mPageContext != null) {
                            v.this.mTbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ShareWebActivityConfig(v.this.mTbPageContext.getContext(), "", bhVar.cee, true)));
                        }
                        TiebaStatic.log(new an(CommonStatisticKey.KEY_FRS_STAR_PIC_CLICK));
                    }
                });
            } else {
                this.eOS.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(getView(), R.drawable.addresslist_item_bg);
            am.setBackgroundColor(this.eNg, R.color.cp_bg_line_c);
            this.dTr.onChangeSkinType();
            this.dTq.onChangeSkinType();
            if (this.dTD != null) {
                this.dTD.onChangeSkinType();
            }
            this.eOw.onChangeSkinType();
            am.setBackgroundColor(this.eOP, R.color.cp_bg_line_e);
            this.dUf.onChangeSkinType();
        }
        if (this.eOR != null && this.eOR.cbq != null) {
            am.setBackgroundColor(this.mMaskView, this.eOR.cbq.ako() ? R.color.cp_bg_line_d : R.color.transparent);
        }
        if (this.eMH != null && this.eMH.getHeadView() != null && (this.eMH.getHeadView() instanceof TbImageView)) {
            this.eMH.getHeadView().setDefaultBgResource(com.baidu.tbadk.util.e.Vl());
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
        if (biVar == null || biVar.cbq == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        if (getView() != null) {
            getView().setVisibility(0);
        }
        this.eOR = biVar;
        bh bhVar = biVar.cbq;
        if (this.dTD != null) {
            SparseArray<String> feedBackReasonMap = bhVar.getFeedBackReasonMap();
            if (feedBackReasonMap != null && feedBackReasonMap.size() > 0 && this.eNk) {
                aj ajVar = new aj();
                ajVar.setTid(bhVar.getTid());
                ajVar.setFid(bhVar.getFid());
                ajVar.setFeedBackReasonMap(feedBackReasonMap);
                this.dTD.setData(ajVar);
                this.dTD.setFirstRowSingleColumn(true);
                this.dTD.setVisibility(T(bhVar) ? 8 : 0);
            } else {
                this.dTD.setVisibility(8);
            }
        }
        if (this.eOR.ceG == 1) {
            this.dTq.setFrom(3);
            b(bhVar);
            R(bhVar);
        }
        if (this.currentPageType == 15) {
            this.dTq.setFrom(5);
        }
        this.dTq.setIsFromConcern(this.crZ);
        this.dTq.setData(bhVar);
        this.dTq.setUserAfterClickListener(this.HO);
        if (this.dTq.getHeaderImg() != null) {
            if (this.dTq.getIsSimpleThread()) {
                this.dTq.getHeaderImg().setVisibility(8);
                this.eMH.setVisibility(8);
            } else if (bhVar.aiG() == null || bhVar.aiG().getPendantData() == null || StringUtils.isNull(bhVar.aiG().getPendantData().ahf())) {
                this.eMH.setVisibility(8);
                this.dTq.getHeaderImg().setVisibility(0);
                this.dTq.getHeaderImg().setData(bhVar);
            } else {
                this.dTq.getHeaderImg().setVisibility(4);
                this.eMH.setVisibility(0);
                this.eMH.setData(bhVar);
            }
        }
        S(bhVar);
        this.eOw.b(bhVar.cec);
        mZ(ly(1));
        setPageUniqueId(getTag());
        onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        bt(bhVar.getId());
        if (this.dTr.isInFrsAllThread() && com.baidu.tieba.frs.a.biW().biX()) {
            this.mMaskView.setVisibility(0);
            if (bhVar.ako() || bhVar.akp()) {
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
            if (!StringUtils.isNull(this.mUrl) && !StringUtils.isNull(this.cdn)) {
                bhVar.bI(this.mUrl, this.cdn);
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
        if (bhVar == null || bhVar.aiG() == null || StringUtils.isNull(bhVar.aiG().getUserId())) {
            return false;
        }
        return bhVar.aiG().getUserId().equals(TbadkCoreApplication.getCurrentAccount());
    }

    public void l(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.dTD != null) {
            this.dTD.setUniqueId(bdUniqueId);
        }
        if (this.dTq != null) {
            this.dTq.setPageUniqueId(bdUniqueId);
        }
    }

    public void iL(boolean z) {
        if (this.eOP != null) {
            this.eOP.setVisibility(z ? 0 : 8);
        }
    }

    public void iH(boolean z) {
        this.eNk = z;
    }

    private void asj() {
        if (this.eOR != null && this.eOR.cbq != null) {
            bh bhVar = this.eOR.cbq;
            n.uz(bhVar.getId());
            bt(bhVar.getId());
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(bhVar, null, this.eOR.stType, RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false);
            createFromThreadCfg.setStartFrom(this.currentPageType);
            createFromThreadCfg.setIsShareThread(true);
            n.uz(bhVar.getTid());
            this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bt(String str) {
        n.a(this.mTitle, str, (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
        n.a(this.FK, str, (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
        this.eOw.setReadState(n.uA(str));
    }

    public void b(bh bhVar) {
        MetaData aiG;
        if (bhVar != null && this.eOQ != null && (aiG = bhVar.aiG()) != null) {
            final ThemeCardInUserData themeCard = aiG.getThemeCard();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                this.eOQ.setVisibility(8);
                return;
            }
            this.eOQ.setVisibility(0);
            this.eOQ.setImageBitmap(null);
            this.eOQ.startLoad(themeCard.getCardImageUrlAndroid(), 10, false);
            this.eOQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.v.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonalCardDetailActivityConfig(v.this.mPageContext.getPageActivity(), themeCard.getCardId())));
                }
            });
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (aZX() != null) {
            aZX().a(view, this.eOR);
        }
        if (view == getView() || view.getId() == R.id.thread_content_layout_outter) {
            asj();
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.dTq != null) {
            return this.dTq.crw;
        }
        return null;
    }

    public View bac() {
        if (this.dTq != null) {
            return this.dTq.HE;
        }
        return null;
    }

    public void mZ(int i) {
        if (this.eOR != null && this.eOR.cbq != null) {
            if (i == 1) {
                this.dTr.setVisibility(8);
                this.dUf.setFrom(this.eOR.ceF);
                this.dUf.setShareReportFrom(this.eOR.ceG);
                this.dUf.setStType(this.eOR.stType);
                this.dUf.setData(this.eOR.cbq);
                this.dTq.et(false);
                return;
            }
            this.dTr.setFrom(this.eOR.ceF);
            this.dTr.setShareReportFrom(this.eOR.ceG);
            this.dTr.setStType(this.eOR.stType);
            this.dTr.setData(this.eOR.cbq);
            this.dTr.setDisPraiseFrom(this.eOR.ceH);
            this.dUf.setVisibility(8);
            this.dTq.et(true);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.GC = str;
    }

    public int ly(int i) {
        return com.baidu.tieba.a.d.aDe().X(this.GC, i);
    }
}
