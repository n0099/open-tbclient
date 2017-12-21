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
    private final View.OnClickListener anT;
    public ViewStub aod;
    public TbImageView aoe;
    private final View.OnClickListener aog;
    private CardGroupDividerView bZR;
    private com.baidu.tieba.frs.g.g cOW;
    public HeadPendantClickableView cPE;
    public ClickableHeaderImageView cPF;
    protected TextView cPG;
    protected TextView cPH;
    public ThreadCommentAndPraiseInfoLayout cPg;
    public UserIconLayout cPh;
    public RelativeLayout cPi;
    public View cah;
    private CustomMessageListener caj;
    public TbImageView ccL;
    private String mForumName;
    protected boolean mIsFromCDN;
    protected TbPageContext<?> mPageContext;
    protected View mRootView;
    private int mSkinType;
    protected TextView mTitleView;

    protected abstract void L(bd bdVar);

    protected abstract void kn(int i);

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
        this.caj = new CustomMessageListener(CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR) { // from class: com.baidu.tieba.frs.entelechy.view.i.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && i.this.ajM != null && i.this.ajM.getTid() != null && i.this.mTitleView != null && ((String) customResponsedMessage.getData()).equals(i.this.ajM.getTid())) {
                    com.baidu.tieba.card.k.a(i.this.mTitleView, i.this.ajM.getId(), d.C0095d.cp_cont_b, d.C0095d.cp_cont_d);
                }
            }
        };
        this.aog = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.i.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (i.this.abt() != null) {
                    i.this.abt().a(view, i.this.ajM);
                }
            }
        };
        this.anT = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.i.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (i.this.abt() != null) {
                    i.this.abt().a(view, i.this.ajM);
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
        this.cPF = (ClickableHeaderImageView) this.mRootView.findViewById(d.g.card_vote_header_image);
        this.cPE = (HeadPendantClickableView) this.mRootView.findViewById(d.g.card_vote_pendant_header_image);
        this.aod = (ViewStub) this.mRootView.findViewById(d.g.viewstub_headimage_mask);
        this.cPF.setDefaultResource(17170445);
        this.cPF.setDefaultErrorResource(d.f.icon_default_avatar100);
        this.cPF.setDefaultBgResource(d.C0095d.cp_bg_line_e);
        this.cPF.setRadius(com.baidu.adp.lib.util.l.f(this.mPageContext.getPageActivity(), d.e.ds70));
        if (this.cPE.getHeadView() != null) {
            this.cPE.getHeadView().setDefaultResource(17170445);
            this.cPE.getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
            this.cPE.getHeadView().setDefaultBgResource(d.C0095d.cp_bg_line_e);
            this.cPE.getHeadView().setRadius(com.baidu.adp.lib.util.l.f(this.mPageContext.getPageActivity(), d.e.ds70));
            this.cPE.getHeadView().setIsRound(true);
            this.cPE.getHeadView().setDrawBorder(false);
        }
        this.cPE.wi();
        if (this.cPE.getPendantView() != null) {
            this.cPE.getPendantView().setIsRound(true);
            this.cPE.getPendantView().setDrawBorder(false);
        }
        this.cPh = (UserIconLayout) this.mRootView.findViewById(d.g.user_icon);
        this.cPh.apd = true;
        this.cPh.setEntelechyEnabled(true);
        this.cPh.setPageName(1);
        this.ccL = (TbImageView) this.mRootView.findViewById(d.g.theme_card_view);
        this.ccL.setPageId(getTag());
        this.mTitleView = (TextView) this.mRootView.findViewById(d.g.vote_thread_title);
        this.cPG = (TextView) this.mRootView.findViewById(d.g.vote_total_option_num);
        this.cPH = (TextView) this.mRootView.findViewById(d.g.vote_now_state);
        this.cPg = (ThreadCommentAndPraiseInfoLayout) this.mRootView.findViewById(d.g.thread_more_info);
        this.cah = this.mRootView.findViewById(d.g.divider_below_reply_number_layout);
        this.cPi = (RelativeLayout) this.mRootView.findViewById(d.g.card_home_page_normal_thread_root_content);
        this.bZR = (CardGroupDividerView) this.mRootView.findViewById(d.g.header_divider);
        this.bZR.setTitleClickListener(this);
        this.cPg.setFrom(2);
        this.cPg.anR = 3;
        this.cOW = new com.baidu.tieba.frs.g.g(this.mPageContext, this.cPi);
        this.cOW.setUniqueId(getTag());
    }

    @Override // com.baidu.tieba.card.a
    public final void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.j(getView(), d.f.addresslist_item_bg);
            this.cPh.onChangeSkinType();
            this.cPg.onChangeSkinType();
            aj.c(this.cPG, d.C0095d.cp_cont_c, 1);
            aj.c(this.cPH, d.C0095d.cp_cont_d, 1);
            kn(i);
            if (this.bZR != null) {
                this.bZR.onChangeSkinType();
            }
            this.cOW.onChangeSkinType();
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.card_vote_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: A */
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
        if (this.ajM.rv() == null || this.ajM.rv().getPendantData() == null || StringUtils.isNull(this.ajM.rv().getPendantData().pR())) {
            UserTbVipInfoData rw = this.ajM.rw();
            if (rw != null && rw.getvipV_url() != null) {
                if (this.aod != null) {
                    if (this.aoe == null) {
                        this.aod.inflate();
                        this.aoe = (TbImageView) getView().findViewById(d.g.user_head_mask);
                    }
                    this.aoe.setPageId(getTag());
                    this.aoe.setVisibility(0);
                    this.aoe.startLoad(rw.getvipV_url(), 10, false);
                    this.cPF.setIsBigV(true);
                }
            } else {
                this.cPF.setIsBigV(false);
                if (this.aoe != null) {
                    this.aoe.setVisibility(8);
                }
            }
            this.cPE.setVisibility(8);
            this.cPF.setVisibility(0);
            this.cPF.setData(bdVar);
        } else {
            this.cPF.setIsBigV(false);
            if (this.aoe != null) {
                this.aoe.setVisibility(8);
            }
            this.cPE.setVisibility(0);
            this.cPF.setVisibility(4);
            this.cPE.setData(bdVar);
        }
        this.cPF.setAfterClickListener(this.aog);
        this.cPh.setVisibility(0);
        if (bdVar.rv() != null && !StringUtils.isNull(bdVar.rv().getSealPrefix())) {
            this.cPh.aM(true);
        }
        this.cPh.setData(bdVar);
        this.cPh.setUserAfterClickListener(this.aog);
        ArrayList arrayList = new ArrayList();
        if (bdVar.rr() == 1) {
            arrayList.add(new k.a(d.j.good));
        }
        SpannableStringBuilder a = com.baidu.tieba.card.k.a((Context) TbadkCoreApplication.getInst(), bdVar.getTitle(), (ArrayList<k.a>) arrayList, false);
        a.append((CharSequence) bdVar.a(new SpannableString(bdVar.g(bdVar.getTitle(), false) + " ")));
        this.mTitleView.setLinkTextColor(getContext().getResources().getColor(d.C0095d.cp_link_tip_c));
        this.mTitleView.setOnTouchListener(new com.baidu.tieba.view.l(a));
        this.mTitleView.setText(a);
        com.baidu.tieba.card.k.a(this.mTitleView, bdVar.getId(), d.C0095d.cp_cont_b, d.C0095d.cp_cont_d);
        if (bdVar.rh() == null || bdVar.rh().options_count.intValue() == 0) {
            this.cPG.setVisibility(8);
            this.cPH.setVisibility(8);
        } else {
            String string = this.mPageContext.getResources().getString(d.j.total_x_vote_option);
            this.cPG.setVisibility(0);
            this.cPG.setText(String.format(string, String.valueOf(bdVar.rh().options_count)));
            if (StringUtils.isNull(bdVar.rh().tips, true)) {
                this.cPH.setVisibility(8);
            } else {
                this.cPH.setVisibility(0);
                this.cPH.setText("(" + bdVar.rh().tips + ")");
            }
        }
        if (this.cPg.setData(bdVar)) {
            this.cah.setVisibility(8);
        } else {
            this.cah.setVisibility(0);
        }
        this.cPg.setForumAfterClickListener(this.anT);
        this.cPg.setStType("frs_page");
        L(bdVar);
        this.cOW.U(this.ajM);
        b.a(this.ajM, this.bZR);
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((view == this.mRootView || view == this.cPg.getCommentNumView() || view == this.bZR) && this.ajM != null) {
            if (this.ajM.rS() > 0 && com.baidu.tieba.tbadkCore.util.f.bxV()) {
                PbActivityConfig createHistoryCfg = new PbActivityConfig(this.mPageContext.getPageActivity()).createHistoryCfg(this.ajM.getTid(), String.valueOf(this.ajM.rS()), false, true, "frs_page");
                createHistoryCfg.setFromSmartFrs(this.ajM.sz());
                createHistoryCfg.setSmartFrsPosition(this.ajM.sG());
                createHistoryCfg.setForumId(String.valueOf(this.ajM.getFid()));
                createHistoryCfg.setStartFrom(this.currentPageType);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createHistoryCfg));
                return;
            }
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(this.ajM, this.mForumName, "frs_page", 18003, true, false, false);
            createFromThreadCfg.setFromSmartFrs(this.ajM.sz());
            createFromThreadCfg.setForumId(String.valueOf(this.ajM.getFid()));
            createFromThreadCfg.setStartFrom(this.currentPageType);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
        }
    }

    public void k(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.cPg != null && this.caj != null) {
            this.caj.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.caj);
        }
    }

    @Override // com.baidu.tieba.card.u
    public void setForumName(String str) {
        this.mForumName = str;
    }
}
