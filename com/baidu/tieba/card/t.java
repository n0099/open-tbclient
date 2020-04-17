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
import com.baidu.tbadk.core.data.al;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.data.bk;
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
public class t extends a<bk> implements com.baidu.tieba.a.e {
    private TextView ady;
    private String aey;
    private OriginalThreadCardView.a afm;
    private final View.OnClickListener agi;
    private boolean agt;
    private boolean dJn;
    private String dsH;
    private NEGFeedBackView fsC;
    public ThreadUserInfoLayout fsq;
    public ThreadCommentAndPraiseInfoLayout fsr;
    public ThreadSourceShareAndPraiseLayout ftd;
    private HeadPendantClickableView goQ;
    private View gpp;
    private boolean gpt;
    public OriginalThreadCardView gqD;
    private View gqW;
    private TbImageView gqX;
    private bk gqY;
    private TbImageView gqZ;
    private ViewGroup gra;
    private View mMaskView;
    private TbPageContext<?> mPageContext;
    private TextView mTitle;
    private String mUrl;

    public t(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.fsC = null;
        this.agt = true;
        this.gpt = true;
        this.agi = new View.OnClickListener() { // from class: com.baidu.tieba.card.t.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (t.this.bEy() != null) {
                    t.this.bEy().a(view, t.this.gqY);
                }
            }
        };
        this.afm = new OriginalThreadCardView.a() { // from class: com.baidu.tieba.card.t.8
            @Override // com.baidu.tieba.card.OriginalThreadCardView.a
            public void a(OriginalThreadInfo originalThreadInfo) {
                if (t.this.gqY != null && t.this.gqY.dqA != null) {
                    if (t.this.bEy() != null) {
                        t.this.bEy().a(t.this.gqD, t.this.gqY);
                    }
                    String id = t.this.gqY.dqA.getId();
                    l.BB(id);
                    t.this.cW(id);
                }
            }
        };
        this.mPageContext = tbPageContext;
        View view = getView();
        this.gra = (ViewGroup) view.findViewById(R.id.thread_content_layout_outter);
        this.gra.setOnClickListener(this);
        this.goQ = (HeadPendantClickableView) view.findViewById(R.id.thread_user_pendant_header);
        if (this.goQ.getHeadView() != null) {
            this.goQ.getHeadView().setIsRound(true);
            this.goQ.getHeadView().setDrawBorder(false);
            this.goQ.getHeadView().setDefaultResource(17170445);
            this.goQ.getHeadView().setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.goQ.getHeadView().setRadius(com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds70));
            this.goQ.getHeadView().setPlaceHolder(1);
        }
        this.goQ.setHasPendantStyle();
        if (this.goQ.getPendantView() != null) {
            this.goQ.getPendantView().setIsRound(true);
            this.goQ.getPendantView().setDrawBorder(false);
        }
        this.fsq = (ThreadUserInfoLayout) view.findViewById(R.id.thread_user_info_layout);
        this.fsC = new NEGFeedBackView(this.mPageContext);
        this.fsC.a((ViewGroup) getView(), com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds92), com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds16));
        this.mTitle = (TextView) view.findViewById(R.id.thread_title);
        this.ady = (TextView) view.findViewById(R.id.thread_abstract);
        this.gqD = (OriginalThreadCardView) view.findViewById(R.id.original_thread_view);
        this.gqD.setSubClickListener(this.afm);
        this.fsr = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.thread_comment_layout);
        if (this.fsr.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fsr.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.fsr.setLayoutParams(layoutParams);
        }
        view.setOnClickListener(this);
        this.fsr.setOnClickListener(this);
        this.fsr.setReplyTimeVisible(false);
        this.fsr.setShowPraiseNum(true);
        this.fsr.setNeedAddPraiseIcon(true);
        this.fsr.setNeedAddReplyIcon(true);
        this.fsr.setShareVisible(true);
        this.fsr.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.t.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (t.this.bEy() != null) {
                    t.this.bEy().a(view2, t.this.gqY);
                }
                if (t.this.gqY != null && t.this.gqY.dqA != null) {
                    l.BB(t.this.gqY.dqA.getId());
                    t.this.cW(t.this.gqY.dqA.getId());
                }
            }
        });
        this.ftd = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.card_transmit_source_read_share_layout);
        this.ftd.dJa.setOnClickListener(this);
        this.ftd.dJa.setNeedAddReplyIcon(true);
        this.ftd.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.t.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (t.this.bEy() != null) {
                    t.this.bEy().a(view2, t.this.gqY);
                }
                if (view2 != t.this.ftd.dIp && t.this.gqY != null && t.this.gqY.dqA != null) {
                    l.BB(t.this.gqY.dqA.getId());
                    t.this.cW(t.this.gqY.dqA.getId());
                }
            }
        });
        this.gpp = view.findViewById(R.id.divider_line_above_praise);
        this.gqW = view.findViewById(R.id.card_divider_line);
        this.gqX = (TbImageView) view.findViewById(R.id.thread_theme_card);
        this.gqZ = (TbImageView) view.findViewById(R.id.frs_normal_item_star_view);
        this.mMaskView = view.findViewById(R.id.thread_multi_del_mask_view);
        this.mMaskView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.t.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                t.this.fsr.changeSelectStatus();
            }
        });
        this.fsr.setOnSelectStatusChangeListener(new ThreadCommentAndPraiseInfoLayout.b() { // from class: com.baidu.tieba.card.t.4
            @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.b
            public void gS(boolean z) {
                am.setBackgroundColor(t.this.mMaskView, z ? R.color.cp_bg_line_d : R.color.transparent);
            }
        });
    }

    private void Y(final bj bjVar) {
        if (this.gqZ != null) {
            if (this.gqX == null || bjVar == null) {
                this.gqZ.setVisibility(8);
            } else if (!StringUtils.isNull(bjVar.dtp) && this.gqX.getVisibility() != 0) {
                if (this.fsC != null && this.fsC.getVisibility() == 0 && (this.gqZ.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gqZ.getLayoutParams();
                    layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds106);
                    this.gqZ.setLayoutParams(layoutParams);
                }
                this.gqZ.setVisibility(0);
                this.gqZ.setImageDrawable(null);
                this.gqZ.startLoad(bjVar.dtp, 10, false);
                this.gqZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.t.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (t.this.mPageContext != null) {
                            t.this.mTbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ShareWebActivityConfig(t.this.mTbPageContext.getContext(), "", bjVar.dtq, true)));
                        }
                        TiebaStatic.log(new an(CommonStatisticKey.KEY_FRS_STAR_PIC_CLICK));
                    }
                });
            } else {
                this.gqZ.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(getView(), R.drawable.addresslist_item_bg);
            am.setBackgroundColor(this.gpp, R.color.cp_bg_line_c);
            this.fsr.onChangeSkinType();
            this.fsq.onChangeSkinType();
            if (this.fsC != null) {
                this.fsC.onChangeSkinType();
            }
            this.gqD.onChangeSkinType();
            am.setBackgroundColor(this.gqW, R.color.cp_bg_line_e);
            this.ftd.onChangeSkinType();
        }
        if (this.gqY != null && this.gqY.dqA != null) {
            am.setBackgroundColor(this.mMaskView, this.gqY.dqA.aMn() ? R.color.cp_bg_line_d : R.color.transparent);
        }
        if (this.goQ != null && this.goQ.getHeadView() != null && (this.goQ.getHeadView() instanceof TbImageView)) {
            this.goQ.getHeadView().setPlaceHolder(1);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.card_transmit_thread_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(bk bkVar) {
        if (bkVar == null || bkVar.dqA == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        if (getView() != null) {
            getView().setVisibility(0);
        }
        this.gqY = bkVar;
        bj bjVar = bkVar.dqA;
        if (this.fsC != null) {
            SparseArray<String> feedBackReasonMap = bjVar.getFeedBackReasonMap();
            if (feedBackReasonMap != null && feedBackReasonMap.size() > 0 && this.gpt) {
                al alVar = new al();
                alVar.setTid(bjVar.getTid());
                alVar.setFid(bjVar.getFid());
                alVar.setFeedBackReasonMap(feedBackReasonMap);
                this.fsC.setData(alVar);
                this.fsC.setFirstRowSingleColumn(true);
                this.fsC.setVisibility(aa(bjVar) ? 8 : 0);
            } else {
                this.fsC.setVisibility(8);
            }
        }
        if (this.gqY.dua == 1) {
            this.fsq.setFrom(3);
            b(bjVar);
            Y(bjVar);
        }
        this.fsq.setIsFromConcern(this.dJn);
        this.fsq.setData(bjVar);
        this.fsq.setUserAfterClickListener(this.agi);
        if (this.fsq.getHeaderImg() != null) {
            if (this.fsq.getIsSimpleThread()) {
                this.fsq.getHeaderImg().setVisibility(8);
                this.goQ.setVisibility(8);
            } else if (bjVar.aKE() == null || bjVar.aKE().getPendantData() == null || StringUtils.isNull(bjVar.aKE().getPendantData().aIW())) {
                this.goQ.setVisibility(8);
                this.fsq.getHeaderImg().setVisibility(0);
                this.fsq.getHeaderImg().setData(bjVar);
            } else {
                this.fsq.getHeaderImg().setVisibility(4);
                this.goQ.setVisibility(0);
                this.goQ.setData(bjVar);
            }
        }
        Z(bjVar);
        this.gqD.b(bjVar.dto);
        pX(or(1));
        setPageUniqueId(getTag());
        onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        cW(bjVar.getId());
        if (this.fsr.isInFrsAllThread() && com.baidu.tieba.frs.a.bND().bNE()) {
            this.mMaskView.setVisibility(0);
            if (bjVar.aMn() || bjVar.aMo()) {
                am.setBackgroundColor(this.mMaskView, R.color.cp_bg_line_d);
                return;
            } else {
                this.mMaskView.setBackgroundResource(R.color.transparent);
                return;
            }
        }
        this.mMaskView.setVisibility(8);
    }

    private void Z(bj bjVar) {
        if (bjVar != null) {
            if (!StringUtils.isNull(this.mUrl) && !StringUtils.isNull(this.dsH)) {
                bjVar.cz(this.mUrl, this.dsH);
            }
            SpannableStringBuilder u = bjVar.u(false, true);
            if (u == null || StringUtils.isNull(u.toString())) {
                this.mTitle.setVisibility(8);
                return;
            }
            this.mTitle.setVisibility(0);
            this.mTitle.setOnTouchListener(new com.baidu.tieba.view.i(u));
            this.mTitle.setText(u);
            l.a(this.mTitle, bjVar.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
        }
    }

    private boolean aa(bj bjVar) {
        if (bjVar == null || bjVar.aKE() == null || StringUtils.isNull(bjVar.aKE().getUserId())) {
            return false;
        }
        return bjVar.aKE().getUserId().equals(TbadkCoreApplication.getCurrentAccount());
    }

    public void m(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.fsC != null) {
            this.fsC.setUniqueId(bdUniqueId);
        }
        if (this.fsq != null) {
            this.fsq.setPageUniqueId(bdUniqueId);
        }
    }

    public void ly(boolean z) {
        if (this.gqW != null) {
            this.gqW.setVisibility(z ? 0 : 8);
        }
    }

    public void lt(boolean z) {
        this.gpt = z;
    }

    private void aVa() {
        if (this.gqY != null && this.gqY.dqA != null) {
            bj bjVar = this.gqY.dqA;
            l.BB(bjVar.getId());
            cW(bjVar.getId());
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(bjVar, null, this.gqY.stType, RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false);
            createFromThreadCfg.setStartFrom(this.currentPageType);
            createFromThreadCfg.setIsShareThread(true);
            l.BB(bjVar.getTid());
            this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cW(String str) {
        l.a(this.mTitle, str, (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
        l.a(this.ady, str, (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
        this.gqD.setReadState(l.BC(str));
    }

    public void b(bj bjVar) {
        MetaData aKE;
        if (bjVar != null && this.gqX != null && (aKE = bjVar.aKE()) != null) {
            final ThemeCardInUserData themeCard = aKE.getThemeCard();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                this.gqX.setVisibility(8);
                return;
            }
            this.gqX.setVisibility(0);
            this.gqX.setImageBitmap(null);
            this.gqX.startLoad(themeCard.getCardImageUrlAndroid(), 10, false);
            this.gqX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.t.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonalCardDetailActivityConfig(t.this.mPageContext.getPageActivity(), themeCard.getCardId())));
                }
            });
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (bEy() != null) {
            bEy().a(view, this.gqY);
        }
        if (view == getView() || view.getId() == R.id.thread_content_layout_outter) {
            aVa();
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.fsq != null) {
            return this.fsq.dIJ;
        }
        return null;
    }

    public View bED() {
        if (this.fsq != null) {
            return this.fsq.afW;
        }
        return null;
    }

    public void pX(int i) {
        if (this.gqY != null && this.gqY.dqA != null) {
            if (i == 1) {
                this.fsr.setVisibility(8);
                this.ftd.setFrom(this.gqY.dtZ);
                this.ftd.setShareReportFrom(this.gqY.dua);
                this.ftd.setStType(this.gqY.stType);
                this.ftd.setData(this.gqY.dqA);
                this.fsq.gQ(false);
                return;
            }
            this.fsr.setFrom(this.gqY.dtZ);
            this.fsr.setShareReportFrom(this.gqY.dua);
            this.fsr.setStType(this.gqY.stType);
            this.fsr.setData(this.gqY.dqA);
            this.fsr.setDisPraiseFrom(this.gqY.dub);
            this.ftd.setVisibility(8);
            this.fsq.gQ(true);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.aey = str;
    }

    public int or(int i) {
        return com.baidu.tieba.a.d.bfP().ar(this.aey, i);
    }
}
