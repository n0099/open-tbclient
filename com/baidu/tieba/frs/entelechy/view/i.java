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
import com.baidu.tieba.view.m;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public abstract class i extends com.baidu.tieba.card.a<bd> implements u {
    protected bd aXU;
    private final View.OnClickListener bbR;
    public ViewStub bcb;
    public TbImageView bcc;
    private final View.OnClickListener bce;
    private CardGroupDividerView cSX;
    public View cTn;
    private CustomMessageListener cTp;
    public TbImageView cVQ;
    public HeadPendantClickableView dIW;
    public ClickableHeaderImageView dIX;
    protected TextView dIY;
    protected TextView dIZ;
    private com.baidu.tieba.frs.f.g dIn;
    public ThreadCommentAndPraiseInfoLayout dIx;
    public UserIconLayout dIy;
    public RelativeLayout dIz;
    private String mForumName;
    protected boolean mIsFromCDN;
    protected TbPageContext<?> mPageContext;
    protected View mRootView;
    private int mSkinType;
    protected TextView mTitleView;

    protected abstract void P(bd bdVar);

    protected abstract void no(int i);

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
        this.cTp = new CustomMessageListener(CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR) { // from class: com.baidu.tieba.frs.entelechy.view.i.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && i.this.aXU != null && i.this.aXU.getTid() != null && i.this.mTitleView != null && ((String) customResponsedMessage.getData()).equals(i.this.aXU.getTid())) {
                    com.baidu.tieba.card.k.a(i.this.mTitleView, i.this.aXU.getId(), d.C0107d.cp_cont_b, d.C0107d.cp_cont_d);
                }
            }
        };
        this.bce = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.i.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (i.this.akb() != null) {
                    i.this.akb().a(view, i.this.aXU);
                }
            }
        };
        this.bbR = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.i.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (i.this.akb() != null) {
                    i.this.akb().a(view, i.this.aXU);
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
        this.dIX = (ClickableHeaderImageView) this.mRootView.findViewById(d.g.card_vote_header_image);
        this.dIW = (HeadPendantClickableView) this.mRootView.findViewById(d.g.card_vote_pendant_header_image);
        this.bcb = (ViewStub) this.mRootView.findViewById(d.g.viewstub_headimage_mask);
        this.dIX.setDefaultResource(17170445);
        this.dIX.setDefaultErrorResource(d.f.icon_default_avatar100);
        this.dIX.setDefaultBgResource(d.C0107d.cp_bg_line_e);
        this.dIX.setRadius(com.baidu.adp.lib.util.l.s(this.mPageContext.getPageActivity(), d.e.ds70));
        if (this.dIW.getHeadView() != null) {
            this.dIW.getHeadView().setDefaultResource(17170445);
            this.dIW.getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
            this.dIW.getHeadView().setDefaultBgResource(d.C0107d.cp_bg_line_e);
            this.dIW.getHeadView().setRadius(com.baidu.adp.lib.util.l.s(this.mPageContext.getPageActivity(), d.e.ds70));
            this.dIW.getHeadView().setIsRound(true);
            this.dIW.getHeadView().setDrawBorder(false);
        }
        this.dIW.Dx();
        if (this.dIW.getPendantView() != null) {
            this.dIW.getPendantView().setIsRound(true);
            this.dIW.getPendantView().setDrawBorder(false);
        }
        this.dIy = (UserIconLayout) this.mRootView.findViewById(d.g.user_icon);
        this.dIy.bdi = true;
        this.dIy.setEntelechyEnabled(true);
        this.dIy.setPageName(1);
        this.cVQ = (TbImageView) this.mRootView.findViewById(d.g.theme_card_view);
        this.cVQ.setPageId(getTag());
        this.mTitleView = (TextView) this.mRootView.findViewById(d.g.vote_thread_title);
        this.dIY = (TextView) this.mRootView.findViewById(d.g.vote_total_option_num);
        this.dIZ = (TextView) this.mRootView.findViewById(d.g.vote_now_state);
        this.dIx = (ThreadCommentAndPraiseInfoLayout) this.mRootView.findViewById(d.g.thread_more_info);
        this.cTn = this.mRootView.findViewById(d.g.divider_below_reply_number_layout);
        this.dIz = (RelativeLayout) this.mRootView.findViewById(d.g.card_home_page_normal_thread_root_content);
        this.cSX = (CardGroupDividerView) this.mRootView.findViewById(d.g.header_divider);
        this.cSX.setTitleClickListener(this);
        this.dIx.setFrom(2);
        this.dIx.bbP = 3;
        this.dIn = new com.baidu.tieba.frs.f.g(this.mPageContext, this.dIz);
        this.dIn.setUniqueId(getTag());
    }

    @Override // com.baidu.tieba.card.a
    public final void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.s(getView(), d.f.addresslist_item_bg);
            this.dIy.onChangeSkinType();
            this.dIx.onChangeSkinType();
            aj.e(this.dIY, d.C0107d.cp_cont_c, 1);
            aj.e(this.dIZ, d.C0107d.cp_cont_d, 1);
            no(i);
            if (this.cSX != null) {
                this.cSX.onChangeSkinType();
            }
            this.dIn.onChangeSkinType();
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
    public final void a(bd bdVar) {
        if (bdVar == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        this.aXU = bdVar;
        if (getView() != null) {
            getView().setVisibility(0);
        }
        if (this.aXU.yS() == null || this.aXU.yS().getPendantData() == null || StringUtils.isNull(this.aXU.yS().getPendantData().xt())) {
            UserTbVipInfoData yT = this.aXU.yT();
            if (yT != null && yT.getvipV_url() != null) {
                if (this.bcb != null) {
                    if (this.bcc == null) {
                        this.bcb.inflate();
                        this.bcc = (TbImageView) getView().findViewById(d.g.user_head_mask);
                    }
                    this.bcc.setPageId(getTag());
                    this.bcc.setVisibility(0);
                    this.bcc.startLoad(yT.getvipV_url(), 10, false);
                    this.dIX.setIsBigV(true);
                }
            } else {
                this.dIX.setIsBigV(false);
                if (this.bcc != null) {
                    this.bcc.setVisibility(8);
                }
            }
            this.dIW.setVisibility(8);
            this.dIX.setVisibility(0);
            this.dIX.setData(bdVar);
        } else {
            this.dIX.setIsBigV(false);
            if (this.bcc != null) {
                this.bcc.setVisibility(8);
            }
            this.dIW.setVisibility(0);
            this.dIX.setVisibility(4);
            this.dIW.setData(bdVar);
        }
        this.dIX.setAfterClickListener(this.bce);
        this.dIy.setVisibility(0);
        if (bdVar.yS() != null && !StringUtils.isNull(bdVar.yS().getSealPrefix())) {
            this.dIy.bs(true);
        }
        this.dIy.setData(bdVar);
        this.dIy.setUserAfterClickListener(this.bce);
        ArrayList arrayList = new ArrayList();
        if (bdVar.yO() == 1) {
            arrayList.add(new k.a(d.j.good));
        }
        SpannableStringBuilder a = com.baidu.tieba.card.k.a((Context) TbadkCoreApplication.getInst(), bdVar.getTitle(), (ArrayList<k.a>) arrayList, false);
        a.append((CharSequence) bdVar.a(new SpannableString(bdVar.g(bdVar.getTitle(), false) + " ")));
        this.mTitleView.setLinkTextColor(getContext().getResources().getColor(d.C0107d.cp_link_tip_c));
        this.mTitleView.setOnTouchListener(new m(a));
        this.mTitleView.setText(a);
        com.baidu.tieba.card.k.a(this.mTitleView, bdVar.getId(), d.C0107d.cp_cont_b, d.C0107d.cp_cont_d);
        if (bdVar.yE() == null || bdVar.yE().options_count.intValue() == 0) {
            this.dIY.setVisibility(8);
            this.dIZ.setVisibility(8);
        } else {
            String string = this.mPageContext.getResources().getString(d.j.total_x_vote_option);
            this.dIY.setVisibility(0);
            this.dIY.setText(String.format(string, String.valueOf(bdVar.yE().options_count)));
            if (StringUtils.isNull(bdVar.yE().tips, true)) {
                this.dIZ.setVisibility(8);
            } else {
                this.dIZ.setVisibility(0);
                this.dIZ.setText("(" + bdVar.yE().tips + ")");
            }
        }
        if (this.dIx.setData(bdVar)) {
            this.cTn.setVisibility(8);
        } else {
            this.cTn.setVisibility(0);
        }
        this.dIx.setForumAfterClickListener(this.bbR);
        this.dIx.setStType("frs_page");
        P(bdVar);
        this.dIn.T(this.aXU);
        b.a(this.aXU, this.cSX);
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((view == this.mRootView || view == this.dIx.getCommentNumView() || view == this.cSX) && this.aXU != null) {
            if (this.aXU.zp() > 0 && com.baidu.tieba.tbadkCore.util.f.bwI()) {
                PbActivityConfig createHistoryCfg = new PbActivityConfig(this.mPageContext.getPageActivity()).createHistoryCfg(this.aXU.getTid(), String.valueOf(this.aXU.zp()), false, true, "frs_page");
                createHistoryCfg.setFromSmartFrs(this.aXU.zT());
                createHistoryCfg.setSmartFrsPosition(this.aXU.Aa());
                createHistoryCfg.setForumId(String.valueOf(this.aXU.getFid()));
                createHistoryCfg.setStartFrom(this.currentPageType);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createHistoryCfg));
                return;
            }
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(this.aXU, this.mForumName, "frs_page", 18003, true, false, false);
            createFromThreadCfg.setFromSmartFrs(this.aXU.zT());
            createFromThreadCfg.setForumId(String.valueOf(this.aXU.getFid()));
            createFromThreadCfg.setStartFrom(this.currentPageType);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.dIx != null && this.cTp != null) {
            this.cTp.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.cTp);
        }
    }

    @Override // com.baidu.tieba.card.u
    public void setForumName(String str) {
        this.mForumName = str;
    }
}
