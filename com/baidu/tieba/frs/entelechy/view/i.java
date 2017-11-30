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
import com.baidu.tbadk.core.data.bd;
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
import java.util.ArrayList;
/* loaded from: classes.dex */
public abstract class i extends com.baidu.tieba.card.a<bd> implements u {
    protected bd ajM;
    private final View.OnClickListener anO;
    public ViewStub anY;
    public TbImageView anZ;
    private final View.OnClickListener aob;
    private CardGroupDividerView bZJ;
    public View bZZ;
    private com.baidu.tieba.frs.g.g cOH;
    public ThreadCommentAndPraiseInfoLayout cOR;
    public UserIconLayout cOS;
    public RelativeLayout cOT;
    public HeadPendantClickableView cPp;
    public ClickableHeaderImageView cPq;
    protected TextView cPr;
    protected TextView cPs;
    private CustomMessageListener cab;
    public TbImageView ccC;
    private String mForumName;
    protected boolean mIsFromCDN;
    protected TbPageContext<?> mPageContext;
    protected View mRootView;
    private int mSkinType;
    protected TextView mTitleView;

    protected abstract void J(bd bdVar);

    protected abstract void kl(int i);

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
        this.cab = new CustomMessageListener(CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR) { // from class: com.baidu.tieba.frs.entelechy.view.i.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && i.this.ajM != null && i.this.ajM.getTid() != null && i.this.mTitleView != null && ((String) customResponsedMessage.getData()).equals(i.this.ajM.getTid())) {
                    com.baidu.tieba.card.k.a(i.this.mTitleView, i.this.ajM.getId(), d.C0082d.cp_cont_b, d.C0082d.cp_cont_d);
                }
            }
        };
        this.aob = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.i.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (i.this.abs() != null) {
                    i.this.abs().a(view, i.this.ajM);
                }
            }
        };
        this.anO = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.i.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (i.this.abs() != null) {
                    i.this.abs().a(view, i.this.ajM);
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
        this.cPq = (ClickableHeaderImageView) this.mRootView.findViewById(d.g.card_vote_header_image);
        this.cPp = (HeadPendantClickableView) this.mRootView.findViewById(d.g.card_vote_pendant_header_image);
        this.anY = (ViewStub) this.mRootView.findViewById(d.g.viewstub_headimage_mask);
        this.cPq.setDefaultResource(17170445);
        this.cPq.setDefaultErrorResource(d.f.icon_default_avatar100);
        this.cPq.setDefaultBgResource(d.C0082d.cp_bg_line_e);
        this.cPq.setRadius(com.baidu.adp.lib.util.l.f(this.mPageContext.getPageActivity(), d.e.ds70));
        if (this.cPp.getHeadView() != null) {
            this.cPp.getHeadView().setDefaultResource(17170445);
            this.cPp.getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
            this.cPp.getHeadView().setDefaultBgResource(d.C0082d.cp_bg_line_e);
            this.cPp.getHeadView().setRadius(com.baidu.adp.lib.util.l.f(this.mPageContext.getPageActivity(), d.e.ds70));
            this.cPp.getHeadView().setIsRound(true);
            this.cPp.getHeadView().setDrawBorder(false);
        }
        this.cPp.wk();
        if (this.cPp.getPendantView() != null) {
            this.cPp.getPendantView().setIsRound(true);
            this.cPp.getPendantView().setDrawBorder(false);
        }
        this.cOS = (UserIconLayout) this.mRootView.findViewById(d.g.user_icon);
        this.cOS.aoX = true;
        this.cOS.setEntelechyEnabled(true);
        this.cOS.setPageName(1);
        this.ccC = (TbImageView) this.mRootView.findViewById(d.g.theme_card_view);
        this.ccC.setPageId(getTag());
        this.mTitleView = (TextView) this.mRootView.findViewById(d.g.vote_thread_title);
        this.cPr = (TextView) this.mRootView.findViewById(d.g.vote_total_option_num);
        this.cPs = (TextView) this.mRootView.findViewById(d.g.vote_now_state);
        this.cOR = (ThreadCommentAndPraiseInfoLayout) this.mRootView.findViewById(d.g.thread_more_info);
        this.bZZ = this.mRootView.findViewById(d.g.divider_below_reply_number_layout);
        this.cOT = (RelativeLayout) this.mRootView.findViewById(d.g.card_home_page_normal_thread_root_content);
        this.bZJ = (CardGroupDividerView) this.mRootView.findViewById(d.g.header_divider);
        this.bZJ.setTitleClickListener(this);
        this.cOR.setFrom(2);
        this.cOR.anM = 3;
        this.cOH = new com.baidu.tieba.frs.g.g(this.mPageContext, this.cOT);
        this.cOH.setUniqueId(getTag());
    }

    @Override // com.baidu.tieba.card.a
    public final void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.j(getView(), d.f.addresslist_item_bg);
            this.cOS.onChangeSkinType();
            this.cOR.onChangeSkinType();
            aj.c(this.cPr, d.C0082d.cp_cont_c, 1);
            aj.c(this.cPs, d.C0082d.cp_cont_d, 1);
            kl(i);
            if (this.bZJ != null) {
                this.bZJ.onChangeSkinType();
            }
            this.cOH.onChangeSkinType();
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.card_vote_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: y */
    public final void a(bd bdVar) {
        if (bdVar == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        this.ajM = bdVar;
        if (getView() != null) {
            getView().setVisibility(0);
        }
        if (this.ajM.rx() == null || this.ajM.rx().getPendantData() == null || StringUtils.isNull(this.ajM.rx().getPendantData().pT())) {
            UserTbVipInfoData ry = this.ajM.ry();
            if (ry != null && ry.getvipV_url() != null) {
                if (this.anY != null) {
                    if (this.anZ == null) {
                        this.anY.inflate();
                        this.anZ = (TbImageView) getView().findViewById(d.g.user_head_mask);
                    }
                    this.anZ.setPageId(getTag());
                    this.anZ.setVisibility(0);
                    this.anZ.startLoad(ry.getvipV_url(), 10, false);
                    this.cPq.setIsBigV(true);
                }
            } else {
                this.cPq.setIsBigV(false);
                if (this.anZ != null) {
                    this.anZ.setVisibility(8);
                }
            }
            this.cPp.setVisibility(8);
            this.cPq.setVisibility(0);
            this.cPq.setData(bdVar);
        } else {
            this.cPq.setIsBigV(false);
            if (this.anZ != null) {
                this.anZ.setVisibility(8);
            }
            this.cPp.setVisibility(0);
            this.cPq.setVisibility(4);
            this.cPp.setData(bdVar);
        }
        this.cPq.setAfterClickListener(this.aob);
        this.cOS.setVisibility(0);
        if (bdVar.rx() != null && !StringUtils.isNull(bdVar.rx().getSealPrefix())) {
            this.cOS.aL(true);
        }
        this.cOS.setData(bdVar);
        this.cOS.setUserAfterClickListener(this.aob);
        ArrayList arrayList = new ArrayList();
        if (bdVar.rt() == 1) {
            arrayList.add(new k.a(d.j.good));
        }
        SpannableStringBuilder a = com.baidu.tieba.card.k.a((Context) TbadkCoreApplication.getInst(), bdVar.getTitle(), (ArrayList<k.a>) arrayList, false);
        a.append((CharSequence) bdVar.a(new SpannableString(bdVar.g(bdVar.getTitle(), false) + " ")));
        this.mTitleView.setLinkTextColor(getContext().getResources().getColor(d.C0082d.cp_link_tip_c));
        this.mTitleView.setOnTouchListener(new com.baidu.tieba.view.l(a));
        this.mTitleView.setText(a);
        com.baidu.tieba.card.k.a(this.mTitleView, bdVar.getId(), d.C0082d.cp_cont_b, d.C0082d.cp_cont_d);
        if (bdVar.rj() == null || bdVar.rj().options_count.intValue() == 0) {
            this.cPr.setVisibility(8);
            this.cPs.setVisibility(8);
        } else {
            String string = this.mPageContext.getResources().getString(d.j.total_x_vote_option);
            this.cPr.setVisibility(0);
            this.cPr.setText(String.format(string, String.valueOf(bdVar.rj().options_count)));
            if (StringUtils.isNull(bdVar.rj().tips, true)) {
                this.cPs.setVisibility(8);
            } else {
                this.cPs.setVisibility(0);
                this.cPs.setText("(" + bdVar.rj().tips + ")");
            }
        }
        if (this.cOR.setData(bdVar)) {
            this.bZZ.setVisibility(8);
        } else {
            this.bZZ.setVisibility(0);
        }
        this.cOR.setForumAfterClickListener(this.anO);
        this.cOR.setStType("frs_page");
        J(bdVar);
        this.cOH.S(this.ajM);
        b.a(this.ajM, this.bZJ);
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((view == this.mRootView || view == this.cOR.getCommentNumView() || view == this.bZJ) && this.ajM != null) {
            if (this.ajM.rU() > 0 && com.baidu.tieba.tbadkCore.util.f.bxo()) {
                PbActivityConfig createHistoryCfg = new PbActivityConfig(this.mPageContext.getPageActivity()).createHistoryCfg(this.ajM.getTid(), String.valueOf(this.ajM.rU()), false, true, "frs_page");
                createHistoryCfg.setFromSmartFrs(this.ajM.sB());
                createHistoryCfg.setSmartFrsPosition(this.ajM.sI());
                createHistoryCfg.setForumId(String.valueOf(this.ajM.getFid()));
                createHistoryCfg.setStartFrom(this.currentPageType);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createHistoryCfg));
                return;
            }
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(this.ajM, this.mForumName, "frs_page", 18003, true, false, false);
            createFromThreadCfg.setFromSmartFrs(this.ajM.sB());
            createFromThreadCfg.setForumId(String.valueOf(this.ajM.getFid()));
            createFromThreadCfg.setStartFrom(this.currentPageType);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
        }
    }

    public void k(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.cOR != null && this.cab != null) {
            this.cab.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.cab);
        }
    }

    @Override // com.baidu.tieba.card.u
    public void setForumName(String str) {
        this.mForumName = str;
    }
}
