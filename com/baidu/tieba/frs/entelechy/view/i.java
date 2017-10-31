package com.baidu.tieba.frs.entelechy.view;

import android.content.Context;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.view.ViewStub;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.UserIconLayout;
import com.baidu.tbadk.data.UserTbVipInfoData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.divider.CardGroupDividerView;
import com.baidu.tieba.card.m;
import com.baidu.tieba.card.v;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes.dex */
public abstract class i extends com.baidu.tieba.card.a<bh> implements v {
    protected bh ajq;
    private final View.OnClickListener anA;
    public ViewStub anP;
    public TbImageView anQ;
    private final View.OnClickListener anS;
    public View bRQ;
    private CustomMessageListener bRS;
    private CardGroupDividerView bRy;
    public ThreadCommentAndPraiseInfoLayout bSR;
    public UserIconLayout bSU;
    public HeadPendantClickableView cFL;
    public ClickableHeaderImageView cFM;
    protected TextView cFN;
    protected TextView cFO;
    private com.baidu.tieba.frs.g.g cFi;
    public RelativeLayout cFp;
    public TbImageView czF;
    private String mForumName;
    protected boolean mIsFromCDN;
    protected TbPageContext<?> mPageContext;
    protected View mRootView;
    private int mSkinType;
    protected TextView mTitleView;

    protected abstract void H(bh bhVar);

    protected abstract void jO(int i);

    /* JADX INFO: Access modifiers changed from: protected */
    public int getSkinType() {
        return this.mSkinType;
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    public i(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.mIsFromCDN = true;
        this.bRS = new CustomMessageListener(CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR) { // from class: com.baidu.tieba.frs.entelechy.view.i.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && i.this.ajq != null && i.this.ajq.getTid() != null && i.this.mTitleView != null && ((String) customResponsedMessage.getData()).equals(i.this.ajq.getTid())) {
                    m.a(i.this.mTitleView, i.this.ajq.getId(), d.C0080d.cp_cont_b, d.C0080d.cp_cont_d);
                }
            }
        };
        this.anS = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.i.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (i.this.Zx() != null) {
                    i.this.Zx().a(view, i.this.ajq);
                }
            }
        };
        this.anA = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.i.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (i.this.Zx() != null) {
                    i.this.Zx().a(view, i.this.ajq);
                }
            }
        };
        setTag(bdUniqueId);
        this.mPageContext = tbPageContext;
        initView();
    }

    public void initView() {
        this.mRootView = getView();
        this.cFM = (ClickableHeaderImageView) this.mRootView.findViewById(d.g.card_vote_header_image);
        this.cFL = (HeadPendantClickableView) this.mRootView.findViewById(d.g.card_vote_pendant_header_image);
        this.anP = (ViewStub) this.mRootView.findViewById(d.g.viewstub_headimage_mask);
        this.cFM.setDefaultResource(17170445);
        this.cFM.setDefaultErrorResource(d.f.icon_default_avatar100);
        this.cFM.setDefaultBgResource(d.C0080d.cp_bg_line_e);
        this.cFM.setRadius(com.baidu.adp.lib.util.l.f(this.mPageContext.getPageActivity(), d.e.ds70));
        if (this.cFL.getHeadView() != null) {
            this.cFL.getHeadView().setDefaultResource(17170445);
            this.cFL.getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
            this.cFL.getHeadView().setDefaultBgResource(d.C0080d.cp_bg_line_e);
            this.cFL.getHeadView().setRadius(com.baidu.adp.lib.util.l.f(this.mPageContext.getPageActivity(), d.e.ds70));
            this.cFL.getHeadView().setIsRound(true);
            this.cFL.getHeadView().setDrawBorder(false);
        }
        this.cFL.wg();
        if (this.cFL.getPendantView() != null) {
            this.cFL.getPendantView().setIsRound(true);
            this.cFL.getPendantView().setDrawBorder(false);
        }
        this.bSU = (UserIconLayout) this.mRootView.findViewById(d.g.user_icon);
        this.bSU.aoG = true;
        this.bSU.setEntelechyEnabled(true);
        this.bSU.setPageName(1);
        this.czF = (TbImageView) this.mRootView.findViewById(d.g.theme_card_view);
        this.czF.setPageId(getTag());
        this.mTitleView = (TextView) this.mRootView.findViewById(d.g.vote_thread_title);
        this.cFN = (TextView) this.mRootView.findViewById(d.g.vote_total_option_num);
        this.cFO = (TextView) this.mRootView.findViewById(d.g.vote_now_state);
        this.bSR = (ThreadCommentAndPraiseInfoLayout) this.mRootView.findViewById(d.g.thread_more_info);
        this.bRQ = this.mRootView.findViewById(d.g.divider_below_reply_number_layout);
        this.cFp = (RelativeLayout) this.mRootView.findViewById(d.g.card_home_page_normal_thread_root_content);
        this.bRy = (CardGroupDividerView) this.mRootView.findViewById(d.g.header_divider);
        this.bRy.setTitleClickListener(this);
        this.bSR.setViewNumEnabled(true);
        this.bSR.setFrom(2);
        this.cFi = new com.baidu.tieba.frs.g.g(this.mPageContext, this.bSR);
        this.cFi.setUniqueId(getTag());
    }

    @Override // com.baidu.tieba.card.a
    public final void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.j(getView(), d.f.addresslist_item_bg);
            this.bSU.onChangeSkinType();
            this.bSR.onChangeSkinType();
            aj.c(this.cFN, d.C0080d.cp_cont_c, 1);
            aj.c(this.cFO, d.C0080d.cp_cont_d, 1);
            jO(i);
            if (this.bRy != null) {
                this.bRy.onChangeSkinType();
            }
            this.cFi.onChangeSkinType();
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.card_vote_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: w */
    public final void a(bh bhVar) {
        if (bhVar == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        this.ajq = bhVar;
        if (getView() != null) {
            getView().setVisibility(0);
        }
        if (this.ajq.rt() == null || this.ajq.rt().getPendantData() == null || StringUtils.isNull(this.ajq.rt().getPendantData().pQ())) {
            UserTbVipInfoData ru = this.ajq.ru();
            if (ru != null && ru.getvipV_url() != null) {
                if (this.anP != null) {
                    if (this.anQ == null) {
                        this.anP.inflate();
                        this.anQ = (TbImageView) getView().findViewById(d.g.user_head_mask);
                    }
                    this.anQ.setPageId(getTag());
                    this.anQ.setVisibility(0);
                    this.anQ.startLoad(ru.getvipV_url(), 10, false);
                    this.cFM.setIsBigV(true);
                }
            } else {
                this.cFM.setIsBigV(false);
                if (this.anQ != null) {
                    this.anQ.setVisibility(8);
                }
            }
            this.cFL.setVisibility(8);
            this.cFM.setVisibility(0);
            this.cFM.setData(bhVar);
        } else {
            this.cFM.setIsBigV(false);
            if (this.anQ != null) {
                this.anQ.setVisibility(8);
            }
            this.cFL.setVisibility(0);
            this.cFM.setVisibility(4);
            this.cFL.setData(bhVar);
        }
        this.cFM.setAfterClickListener(this.anS);
        this.bSU.setVisibility(0);
        if (bhVar.rt() != null && !StringUtils.isNull(bhVar.rt().getSealPrefix())) {
            this.bSU.aL(true);
        }
        this.bSU.setData(bhVar);
        this.bSU.setUserAfterClickListener(this.anS);
        ArrayList arrayList = new ArrayList();
        if (bhVar.rp() == 1) {
            arrayList.add(new m.a(d.j.good));
        }
        SpannableStringBuilder a = m.a((Context) TbadkCoreApplication.getInst(), bhVar.getTitle(), (ArrayList<m.a>) arrayList, false);
        a.append((CharSequence) bhVar.a(new SpannableString(bhVar.g(bhVar.getTitle(), false) + " ")));
        this.mTitleView.setLinkTextColor(getContext().getResources().getColor(d.C0080d.cp_link_tip_c));
        this.mTitleView.setOnTouchListener(new com.baidu.tieba.view.l(a));
        this.mTitleView.setText(a);
        m.a(this.mTitleView, bhVar.getId(), d.C0080d.cp_cont_b, d.C0080d.cp_cont_d);
        if (bhVar.rf() == null || bhVar.rf().options_count.intValue() == 0) {
            this.cFN.setVisibility(8);
            this.cFO.setVisibility(8);
        } else {
            String string = this.mPageContext.getResources().getString(d.j.total_x_vote_option);
            this.cFN.setVisibility(0);
            this.cFN.setText(String.format(string, String.valueOf(bhVar.rf().options_count)));
            if (StringUtils.isNull(bhVar.rf().tips, true)) {
                this.cFO.setVisibility(8);
            } else {
                this.cFO.setVisibility(0);
                this.cFO.setText("(" + bhVar.rf().tips + ")");
            }
        }
        if (this.bSR.setData(bhVar)) {
            this.bRQ.setVisibility(8);
        } else {
            this.bRQ.setVisibility(0);
        }
        this.bSR.setForumAfterClickListener(this.anA);
        this.bSR.setStType("frs_page");
        H(bhVar);
        this.cFi.Q(this.ajq);
        b.a(this.ajq, this.bRy);
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((view == this.mRootView || view == this.bSR.getCommentNumView() || view == this.bRy) && this.ajq != null) {
            if (this.ajq.rQ() > 0 && com.baidu.tieba.tbadkCore.util.f.bvs()) {
                PbActivityConfig createHistoryCfg = new PbActivityConfig(this.mPageContext.getPageActivity()).createHistoryCfg(this.ajq.getTid(), String.valueOf(this.ajq.rQ()), false, true, "frs_page");
                createHistoryCfg.setFromSmartFrs(this.ajq.sy());
                createHistoryCfg.setSmartFrsPosition(this.ajq.sF());
                createHistoryCfg.setForumId(String.valueOf(this.ajq.getFid()));
                createHistoryCfg.setStartFrom(1);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createHistoryCfg));
                return;
            }
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(this.ajq, this.mForumName, "frs_page", 18003, true, false, false);
            createFromThreadCfg.setFromSmartFrs(this.ajq.sy());
            createFromThreadCfg.setForumId(String.valueOf(this.ajq.getFid()));
            createFromThreadCfg.setStartFrom(1);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
        }
    }

    public void k(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.bSR != null && this.bRS != null) {
            this.bRS.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.bRS);
        }
    }

    @Override // com.baidu.tieba.card.v
    public void setForumName(String str) {
        this.mForumName = str;
    }
}
