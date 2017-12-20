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
    protected bd ajJ;
    private final View.OnClickListener anQ;
    public ViewStub aoa;
    public TbImageView aob;
    private final View.OnClickListener aod;
    private CardGroupDividerView bZN;
    private com.baidu.tieba.frs.g.g cOS;
    public HeadPendantClickableView cPA;
    public ClickableHeaderImageView cPB;
    protected TextView cPC;
    protected TextView cPD;
    public ThreadCommentAndPraiseInfoLayout cPc;
    public UserIconLayout cPd;
    public RelativeLayout cPe;
    public View cad;
    private CustomMessageListener caf;
    public TbImageView ccH;
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
        this.caf = new CustomMessageListener(CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR) { // from class: com.baidu.tieba.frs.entelechy.view.i.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && i.this.ajJ != null && i.this.ajJ.getTid() != null && i.this.mTitleView != null && ((String) customResponsedMessage.getData()).equals(i.this.ajJ.getTid())) {
                    com.baidu.tieba.card.k.a(i.this.mTitleView, i.this.ajJ.getId(), d.C0096d.cp_cont_b, d.C0096d.cp_cont_d);
                }
            }
        };
        this.aod = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.i.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (i.this.abt() != null) {
                    i.this.abt().a(view, i.this.ajJ);
                }
            }
        };
        this.anQ = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.i.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (i.this.abt() != null) {
                    i.this.abt().a(view, i.this.ajJ);
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
        this.cPB = (ClickableHeaderImageView) this.mRootView.findViewById(d.g.card_vote_header_image);
        this.cPA = (HeadPendantClickableView) this.mRootView.findViewById(d.g.card_vote_pendant_header_image);
        this.aoa = (ViewStub) this.mRootView.findViewById(d.g.viewstub_headimage_mask);
        this.cPB.setDefaultResource(17170445);
        this.cPB.setDefaultErrorResource(d.f.icon_default_avatar100);
        this.cPB.setDefaultBgResource(d.C0096d.cp_bg_line_e);
        this.cPB.setRadius(com.baidu.adp.lib.util.l.f(this.mPageContext.getPageActivity(), d.e.ds70));
        if (this.cPA.getHeadView() != null) {
            this.cPA.getHeadView().setDefaultResource(17170445);
            this.cPA.getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
            this.cPA.getHeadView().setDefaultBgResource(d.C0096d.cp_bg_line_e);
            this.cPA.getHeadView().setRadius(com.baidu.adp.lib.util.l.f(this.mPageContext.getPageActivity(), d.e.ds70));
            this.cPA.getHeadView().setIsRound(true);
            this.cPA.getHeadView().setDrawBorder(false);
        }
        this.cPA.wi();
        if (this.cPA.getPendantView() != null) {
            this.cPA.getPendantView().setIsRound(true);
            this.cPA.getPendantView().setDrawBorder(false);
        }
        this.cPd = (UserIconLayout) this.mRootView.findViewById(d.g.user_icon);
        this.cPd.apa = true;
        this.cPd.setEntelechyEnabled(true);
        this.cPd.setPageName(1);
        this.ccH = (TbImageView) this.mRootView.findViewById(d.g.theme_card_view);
        this.ccH.setPageId(getTag());
        this.mTitleView = (TextView) this.mRootView.findViewById(d.g.vote_thread_title);
        this.cPC = (TextView) this.mRootView.findViewById(d.g.vote_total_option_num);
        this.cPD = (TextView) this.mRootView.findViewById(d.g.vote_now_state);
        this.cPc = (ThreadCommentAndPraiseInfoLayout) this.mRootView.findViewById(d.g.thread_more_info);
        this.cad = this.mRootView.findViewById(d.g.divider_below_reply_number_layout);
        this.cPe = (RelativeLayout) this.mRootView.findViewById(d.g.card_home_page_normal_thread_root_content);
        this.bZN = (CardGroupDividerView) this.mRootView.findViewById(d.g.header_divider);
        this.bZN.setTitleClickListener(this);
        this.cPc.setFrom(2);
        this.cPc.anO = 3;
        this.cOS = new com.baidu.tieba.frs.g.g(this.mPageContext, this.cPe);
        this.cOS.setUniqueId(getTag());
    }

    @Override // com.baidu.tieba.card.a
    public final void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.j(getView(), d.f.addresslist_item_bg);
            this.cPd.onChangeSkinType();
            this.cPc.onChangeSkinType();
            aj.c(this.cPC, d.C0096d.cp_cont_c, 1);
            aj.c(this.cPD, d.C0096d.cp_cont_d, 1);
            kn(i);
            if (this.bZN != null) {
                this.bZN.onChangeSkinType();
            }
            this.cOS.onChangeSkinType();
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
        this.ajJ = bdVar;
        if (getView() != null) {
            getView().setVisibility(0);
        }
        if (this.ajJ.rv() == null || this.ajJ.rv().getPendantData() == null || StringUtils.isNull(this.ajJ.rv().getPendantData().pR())) {
            UserTbVipInfoData rw = this.ajJ.rw();
            if (rw != null && rw.getvipV_url() != null) {
                if (this.aoa != null) {
                    if (this.aob == null) {
                        this.aoa.inflate();
                        this.aob = (TbImageView) getView().findViewById(d.g.user_head_mask);
                    }
                    this.aob.setPageId(getTag());
                    this.aob.setVisibility(0);
                    this.aob.startLoad(rw.getvipV_url(), 10, false);
                    this.cPB.setIsBigV(true);
                }
            } else {
                this.cPB.setIsBigV(false);
                if (this.aob != null) {
                    this.aob.setVisibility(8);
                }
            }
            this.cPA.setVisibility(8);
            this.cPB.setVisibility(0);
            this.cPB.setData(bdVar);
        } else {
            this.cPB.setIsBigV(false);
            if (this.aob != null) {
                this.aob.setVisibility(8);
            }
            this.cPA.setVisibility(0);
            this.cPB.setVisibility(4);
            this.cPA.setData(bdVar);
        }
        this.cPB.setAfterClickListener(this.aod);
        this.cPd.setVisibility(0);
        if (bdVar.rv() != null && !StringUtils.isNull(bdVar.rv().getSealPrefix())) {
            this.cPd.aM(true);
        }
        this.cPd.setData(bdVar);
        this.cPd.setUserAfterClickListener(this.aod);
        ArrayList arrayList = new ArrayList();
        if (bdVar.rr() == 1) {
            arrayList.add(new k.a(d.j.good));
        }
        SpannableStringBuilder a = com.baidu.tieba.card.k.a((Context) TbadkCoreApplication.getInst(), bdVar.getTitle(), (ArrayList<k.a>) arrayList, false);
        a.append((CharSequence) bdVar.a(new SpannableString(bdVar.g(bdVar.getTitle(), false) + " ")));
        this.mTitleView.setLinkTextColor(getContext().getResources().getColor(d.C0096d.cp_link_tip_c));
        this.mTitleView.setOnTouchListener(new com.baidu.tieba.view.l(a));
        this.mTitleView.setText(a);
        com.baidu.tieba.card.k.a(this.mTitleView, bdVar.getId(), d.C0096d.cp_cont_b, d.C0096d.cp_cont_d);
        if (bdVar.rh() == null || bdVar.rh().options_count.intValue() == 0) {
            this.cPC.setVisibility(8);
            this.cPD.setVisibility(8);
        } else {
            String string = this.mPageContext.getResources().getString(d.j.total_x_vote_option);
            this.cPC.setVisibility(0);
            this.cPC.setText(String.format(string, String.valueOf(bdVar.rh().options_count)));
            if (StringUtils.isNull(bdVar.rh().tips, true)) {
                this.cPD.setVisibility(8);
            } else {
                this.cPD.setVisibility(0);
                this.cPD.setText("(" + bdVar.rh().tips + ")");
            }
        }
        if (this.cPc.setData(bdVar)) {
            this.cad.setVisibility(8);
        } else {
            this.cad.setVisibility(0);
        }
        this.cPc.setForumAfterClickListener(this.anQ);
        this.cPc.setStType("frs_page");
        L(bdVar);
        this.cOS.U(this.ajJ);
        b.a(this.ajJ, this.bZN);
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((view == this.mRootView || view == this.cPc.getCommentNumView() || view == this.bZN) && this.ajJ != null) {
            if (this.ajJ.rS() > 0 && com.baidu.tieba.tbadkCore.util.f.bxU()) {
                PbActivityConfig createHistoryCfg = new PbActivityConfig(this.mPageContext.getPageActivity()).createHistoryCfg(this.ajJ.getTid(), String.valueOf(this.ajJ.rS()), false, true, "frs_page");
                createHistoryCfg.setFromSmartFrs(this.ajJ.sz());
                createHistoryCfg.setSmartFrsPosition(this.ajJ.sG());
                createHistoryCfg.setForumId(String.valueOf(this.ajJ.getFid()));
                createHistoryCfg.setStartFrom(this.currentPageType);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createHistoryCfg));
                return;
            }
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(this.ajJ, this.mForumName, "frs_page", 18003, true, false, false);
            createFromThreadCfg.setFromSmartFrs(this.ajJ.sz());
            createFromThreadCfg.setForumId(String.valueOf(this.ajJ.getFid()));
            createFromThreadCfg.setStartFrom(this.currentPageType);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
        }
    }

    public void k(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.cPc != null && this.caf != null) {
            this.caf.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.caf);
        }
    }

    @Override // com.baidu.tieba.card.u
    public void setForumName(String str) {
        this.mForumName = str;
    }
}
