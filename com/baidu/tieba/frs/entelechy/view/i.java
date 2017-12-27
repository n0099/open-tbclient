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
import com.baidu.tbadk.core.data.be;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.UserIconLayout;
import com.baidu.tbadk.data.UserTbVipInfoData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.divider.CardGroupDividerView;
import com.baidu.tieba.card.k;
import com.baidu.tieba.card.u;
import com.baidu.tieba.d;
import com.baidu.tieba.view.m;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public abstract class i extends com.baidu.tieba.card.a<be> implements u {
    protected be aXV;
    private final View.OnClickListener bbR;
    public ViewStub bcb;
    public TbImageView bcc;
    private final View.OnClickListener bce;
    public View cOM;
    private CustomMessageListener cOO;
    private CardGroupDividerView cOw;
    public TbImageView cRo;
    private com.baidu.tieba.frs.f.g dDM;
    public ThreadCommentAndPraiseInfoLayout dDW;
    public UserIconLayout dDX;
    public RelativeLayout dDY;
    public HeadPendantClickableView dEv;
    public ClickableHeaderImageView dEw;
    protected TextView dEx;
    protected TextView dEy;
    private String mForumName;
    protected boolean mIsFromCDN;
    protected TbPageContext<?> mPageContext;
    protected View mRootView;
    private int mSkinType;
    protected TextView mTitleView;

    protected abstract void P(be beVar);

    protected abstract void nl(int i);

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
        this.cOO = new CustomMessageListener(CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR) { // from class: com.baidu.tieba.frs.entelechy.view.i.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && i.this.aXV != null && i.this.aXV.getTid() != null && i.this.mTitleView != null && ((String) customResponsedMessage.getData()).equals(i.this.aXV.getTid())) {
                    com.baidu.tieba.card.k.a(i.this.mTitleView, i.this.aXV.getId(), d.C0108d.cp_cont_b, d.C0108d.cp_cont_d);
                }
            }
        };
        this.bce = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.i.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (i.this.aiY() != null) {
                    i.this.aiY().a(view, i.this.aXV);
                }
            }
        };
        this.bbR = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.i.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (i.this.aiY() != null) {
                    i.this.aiY().a(view, i.this.aXV);
                }
            }
        };
        setTag(bdUniqueId);
        this.mPageContext = tbPageContext;
        this.currentPageType = 3;
        initView();
    }

    public void initView() {
        this.mRootView = getView();
        this.dEw = (ClickableHeaderImageView) this.mRootView.findViewById(d.g.card_vote_header_image);
        this.dEv = (HeadPendantClickableView) this.mRootView.findViewById(d.g.card_vote_pendant_header_image);
        this.bcb = (ViewStub) this.mRootView.findViewById(d.g.viewstub_headimage_mask);
        this.dEw.setDefaultResource(17170445);
        this.dEw.setDefaultErrorResource(d.f.icon_default_avatar100);
        this.dEw.setDefaultBgResource(d.C0108d.cp_bg_line_e);
        this.dEw.setRadius(com.baidu.adp.lib.util.l.s(this.mPageContext.getPageActivity(), d.e.ds70));
        if (this.dEv.getHeadView() != null) {
            this.dEv.getHeadView().setDefaultResource(17170445);
            this.dEv.getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
            this.dEv.getHeadView().setDefaultBgResource(d.C0108d.cp_bg_line_e);
            this.dEv.getHeadView().setRadius(com.baidu.adp.lib.util.l.s(this.mPageContext.getPageActivity(), d.e.ds70));
            this.dEv.getHeadView().setIsRound(true);
            this.dEv.getHeadView().setDrawBorder(false);
        }
        this.dEv.DG();
        if (this.dEv.getPendantView() != null) {
            this.dEv.getPendantView().setIsRound(true);
            this.dEv.getPendantView().setDrawBorder(false);
        }
        this.dDX = (UserIconLayout) this.mRootView.findViewById(d.g.user_icon);
        this.dDX.bdc = true;
        this.dDX.setEntelechyEnabled(true);
        this.dDX.setPageName(1);
        this.cRo = (TbImageView) this.mRootView.findViewById(d.g.theme_card_view);
        this.cRo.setPageId(getTag());
        this.mTitleView = (TextView) this.mRootView.findViewById(d.g.vote_thread_title);
        this.dEx = (TextView) this.mRootView.findViewById(d.g.vote_total_option_num);
        this.dEy = (TextView) this.mRootView.findViewById(d.g.vote_now_state);
        this.dDW = (ThreadCommentAndPraiseInfoLayout) this.mRootView.findViewById(d.g.thread_more_info);
        this.cOM = this.mRootView.findViewById(d.g.divider_below_reply_number_layout);
        this.dDY = (RelativeLayout) this.mRootView.findViewById(d.g.card_home_page_normal_thread_root_content);
        this.cOw = (CardGroupDividerView) this.mRootView.findViewById(d.g.header_divider);
        this.cOw.setTitleClickListener(this);
        this.dDW.setFrom(2);
        this.dDW.bbP = 3;
        this.dDM = new com.baidu.tieba.frs.f.g(this.mPageContext, this.dDY);
        this.dDM.setUniqueId(getTag());
    }

    @Override // com.baidu.tieba.card.a
    public final void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.s(getView(), d.f.addresslist_item_bg);
            this.dDX.onChangeSkinType();
            this.dDW.onChangeSkinType();
            aj.e(this.dEx, d.C0108d.cp_cont_c, 1);
            aj.e(this.dEy, d.C0108d.cp_cont_d, 1);
            nl(i);
            if (this.cOw != null) {
                this.cOw.onChangeSkinType();
            }
            this.dDM.onChangeSkinType();
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.card_vote_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: B */
    public final void a(be beVar) {
        if (beVar == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        this.aXV = beVar;
        if (getView() != null) {
            getView().setVisibility(0);
        }
        if (this.aXV.yX() == null || this.aXV.yX().getPendantData() == null || StringUtils.isNull(this.aXV.yX().getPendantData().xu())) {
            UserTbVipInfoData yY = this.aXV.yY();
            if (yY != null && yY.getvipV_url() != null) {
                if (this.bcb != null) {
                    if (this.bcc == null) {
                        this.bcb.inflate();
                        this.bcc = (TbImageView) getView().findViewById(d.g.user_head_mask);
                    }
                    this.bcc.setPageId(getTag());
                    this.bcc.setVisibility(0);
                    this.bcc.startLoad(yY.getvipV_url(), 10, false);
                    this.dEw.setIsBigV(true);
                }
            } else {
                this.dEw.setIsBigV(false);
                if (this.bcc != null) {
                    this.bcc.setVisibility(8);
                }
            }
            this.dEv.setVisibility(8);
            this.dEw.setVisibility(0);
            this.dEw.setData(beVar);
        } else {
            this.dEw.setIsBigV(false);
            if (this.bcc != null) {
                this.bcc.setVisibility(8);
            }
            this.dEv.setVisibility(0);
            this.dEw.setVisibility(4);
            this.dEv.setData(beVar);
        }
        this.dEw.setAfterClickListener(this.bce);
        this.dDX.setVisibility(0);
        if (beVar.yX() != null && !StringUtils.isNull(beVar.yX().getSealPrefix())) {
            this.dDX.bs(true);
        }
        this.dDX.setData(beVar);
        this.dDX.setUserAfterClickListener(this.bce);
        ArrayList arrayList = new ArrayList();
        if (beVar.yT() == 1) {
            arrayList.add(new k.a(d.j.good));
        }
        SpannableStringBuilder a = com.baidu.tieba.card.k.a((Context) TbadkCoreApplication.getInst(), beVar.getTitle(), (ArrayList<k.a>) arrayList, false);
        a.append((CharSequence) beVar.a(new SpannableString(beVar.g(beVar.getTitle(), false) + " ")));
        this.mTitleView.setLinkTextColor(getContext().getResources().getColor(d.C0108d.cp_link_tip_c));
        this.mTitleView.setOnTouchListener(new m(a));
        this.mTitleView.setText(a);
        com.baidu.tieba.card.k.a(this.mTitleView, beVar.getId(), d.C0108d.cp_cont_b, d.C0108d.cp_cont_d);
        if (beVar.yJ() == null || beVar.yJ().options_count.intValue() == 0) {
            this.dEx.setVisibility(8);
            this.dEy.setVisibility(8);
        } else {
            String string = this.mPageContext.getResources().getString(d.j.total_x_vote_option);
            this.dEx.setVisibility(0);
            this.dEx.setText(String.format(string, String.valueOf(beVar.yJ().options_count)));
            if (StringUtils.isNull(beVar.yJ().tips, true)) {
                this.dEy.setVisibility(8);
            } else {
                this.dEy.setVisibility(0);
                this.dEy.setText("(" + beVar.yJ().tips + ")");
            }
        }
        if (this.dDW.setData(beVar)) {
            this.cOM.setVisibility(8);
        } else {
            this.cOM.setVisibility(0);
        }
        this.dDW.setForumAfterClickListener(this.bbR);
        this.dDW.setStType("frs_page");
        P(beVar);
        this.dDM.T(this.aXV);
        b.a(this.aXV, this.cOw);
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((view == this.mRootView || view == this.dDW.getCommentNumView() || view == this.cOw) && this.aXV != null) {
            if (this.aXV.zu() > 0 && com.baidu.tieba.tbadkCore.util.f.bDl()) {
                PbActivityConfig createHistoryCfg = new PbActivityConfig(this.mPageContext.getPageActivity()).createHistoryCfg(this.aXV.getTid(), String.valueOf(this.aXV.zu()), false, true, "frs_page");
                createHistoryCfg.setFromSmartFrs(this.aXV.Ab());
                createHistoryCfg.setSmartFrsPosition(this.aXV.Ai());
                createHistoryCfg.setForumId(String.valueOf(this.aXV.getFid()));
                createHistoryCfg.setStartFrom(this.currentPageType);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createHistoryCfg));
                return;
            }
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(this.aXV, this.mForumName, "frs_page", 18003, true, false, false);
            createFromThreadCfg.setFromSmartFrs(this.aXV.Ab());
            createFromThreadCfg.setForumId(String.valueOf(this.aXV.getFid()));
            createFromThreadCfg.setStartFrom(this.currentPageType);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.dDW != null && this.cOO != null) {
            this.cOO.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.cOO);
        }
    }

    @Override // com.baidu.tieba.card.u
    public void setForumName(String str) {
        this.mForumName = str;
    }
}
