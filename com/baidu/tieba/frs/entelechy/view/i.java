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
    protected bd aYc;
    private final View.OnClickListener bbZ;
    public ViewStub bcj;
    public TbImageView bck;
    private final View.OnClickListener bcm;
    public View cTI;
    private CustomMessageListener cTK;
    private CardGroupDividerView cTs;
    public TbImageView cWl;
    private com.baidu.tieba.frs.f.g dII;
    public ThreadCommentAndPraiseInfoLayout dIS;
    public UserIconLayout dIT;
    public RelativeLayout dIU;
    public HeadPendantClickableView dJr;
    public ClickableHeaderImageView dJs;
    protected TextView dJt;
    protected TextView dJu;
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
        this.cTK = new CustomMessageListener(CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR) { // from class: com.baidu.tieba.frs.entelechy.view.i.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && i.this.aYc != null && i.this.aYc.getTid() != null && i.this.mTitleView != null && ((String) customResponsedMessage.getData()).equals(i.this.aYc.getTid())) {
                    com.baidu.tieba.card.k.a(i.this.mTitleView, i.this.aYc.getId(), d.C0108d.cp_cont_b, d.C0108d.cp_cont_d);
                }
            }
        };
        this.bcm = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.i.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (i.this.akg() != null) {
                    i.this.akg().a(view, i.this.aYc);
                }
            }
        };
        this.bbZ = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.i.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (i.this.akg() != null) {
                    i.this.akg().a(view, i.this.aYc);
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
        this.dJs = (ClickableHeaderImageView) this.mRootView.findViewById(d.g.card_vote_header_image);
        this.dJr = (HeadPendantClickableView) this.mRootView.findViewById(d.g.card_vote_pendant_header_image);
        this.bcj = (ViewStub) this.mRootView.findViewById(d.g.viewstub_headimage_mask);
        this.dJs.setDefaultResource(17170445);
        this.dJs.setDefaultErrorResource(d.f.icon_default_avatar100);
        this.dJs.setDefaultBgResource(d.C0108d.cp_bg_line_e);
        this.dJs.setRadius(com.baidu.adp.lib.util.l.s(this.mPageContext.getPageActivity(), d.e.ds70));
        if (this.dJr.getHeadView() != null) {
            this.dJr.getHeadView().setDefaultResource(17170445);
            this.dJr.getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
            this.dJr.getHeadView().setDefaultBgResource(d.C0108d.cp_bg_line_e);
            this.dJr.getHeadView().setRadius(com.baidu.adp.lib.util.l.s(this.mPageContext.getPageActivity(), d.e.ds70));
            this.dJr.getHeadView().setIsRound(true);
            this.dJr.getHeadView().setDrawBorder(false);
        }
        this.dJr.Dz();
        if (this.dJr.getPendantView() != null) {
            this.dJr.getPendantView().setIsRound(true);
            this.dJr.getPendantView().setDrawBorder(false);
        }
        this.dIT = (UserIconLayout) this.mRootView.findViewById(d.g.user_icon);
        this.dIT.bdq = true;
        this.dIT.setEntelechyEnabled(true);
        this.dIT.setPageName(1);
        this.cWl = (TbImageView) this.mRootView.findViewById(d.g.theme_card_view);
        this.cWl.setPageId(getTag());
        this.mTitleView = (TextView) this.mRootView.findViewById(d.g.vote_thread_title);
        this.dJt = (TextView) this.mRootView.findViewById(d.g.vote_total_option_num);
        this.dJu = (TextView) this.mRootView.findViewById(d.g.vote_now_state);
        this.dIS = (ThreadCommentAndPraiseInfoLayout) this.mRootView.findViewById(d.g.thread_more_info);
        this.cTI = this.mRootView.findViewById(d.g.divider_below_reply_number_layout);
        this.dIU = (RelativeLayout) this.mRootView.findViewById(d.g.card_home_page_normal_thread_root_content);
        this.cTs = (CardGroupDividerView) this.mRootView.findViewById(d.g.header_divider);
        this.cTs.setTitleClickListener(this);
        this.dIS.setFrom(2);
        this.dIS.bbX = 3;
        this.dII = new com.baidu.tieba.frs.f.g(this.mPageContext, this.dIU);
        this.dII.setUniqueId(getTag());
    }

    @Override // com.baidu.tieba.card.a
    public final void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.s(getView(), d.f.addresslist_item_bg);
            this.dIT.onChangeSkinType();
            this.dIS.onChangeSkinType();
            aj.e(this.dJt, d.C0108d.cp_cont_c, 1);
            aj.e(this.dJu, d.C0108d.cp_cont_d, 1);
            no(i);
            if (this.cTs != null) {
                this.cTs.onChangeSkinType();
            }
            this.dII.onChangeSkinType();
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
        this.aYc = bdVar;
        if (getView() != null) {
            getView().setVisibility(0);
        }
        if (this.aYc.yT() == null || this.aYc.yT().getPendantData() == null || StringUtils.isNull(this.aYc.yT().getPendantData().xu())) {
            UserTbVipInfoData yU = this.aYc.yU();
            if (yU != null && yU.getvipV_url() != null) {
                if (this.bcj != null) {
                    if (this.bck == null) {
                        this.bcj.inflate();
                        this.bck = (TbImageView) getView().findViewById(d.g.user_head_mask);
                    }
                    this.bck.setPageId(getTag());
                    this.bck.setVisibility(0);
                    this.bck.startLoad(yU.getvipV_url(), 10, false);
                    this.dJs.setIsBigV(true);
                }
            } else {
                this.dJs.setIsBigV(false);
                if (this.bck != null) {
                    this.bck.setVisibility(8);
                }
            }
            this.dJr.setVisibility(8);
            this.dJs.setVisibility(0);
            this.dJs.setData(bdVar);
        } else {
            this.dJs.setIsBigV(false);
            if (this.bck != null) {
                this.bck.setVisibility(8);
            }
            this.dJr.setVisibility(0);
            this.dJs.setVisibility(4);
            this.dJr.setData(bdVar);
        }
        this.dJs.setAfterClickListener(this.bcm);
        this.dIT.setVisibility(0);
        if (bdVar.yT() != null && !StringUtils.isNull(bdVar.yT().getSealPrefix())) {
            this.dIT.bt(true);
        }
        this.dIT.setData(bdVar);
        this.dIT.setUserAfterClickListener(this.bcm);
        ArrayList arrayList = new ArrayList();
        if (bdVar.yP() == 1) {
            arrayList.add(new k.a(d.j.good));
        }
        SpannableStringBuilder a = com.baidu.tieba.card.k.a((Context) TbadkCoreApplication.getInst(), bdVar.getTitle(), (ArrayList<k.a>) arrayList, false);
        a.append((CharSequence) bdVar.a(new SpannableString(bdVar.g(bdVar.getTitle(), false) + " ")));
        this.mTitleView.setLinkTextColor(getContext().getResources().getColor(d.C0108d.cp_link_tip_c));
        this.mTitleView.setOnTouchListener(new m(a));
        this.mTitleView.setText(a);
        com.baidu.tieba.card.k.a(this.mTitleView, bdVar.getId(), d.C0108d.cp_cont_b, d.C0108d.cp_cont_d);
        if (bdVar.yF() == null || bdVar.yF().options_count.intValue() == 0) {
            this.dJt.setVisibility(8);
            this.dJu.setVisibility(8);
        } else {
            String string = this.mPageContext.getResources().getString(d.j.total_x_vote_option);
            this.dJt.setVisibility(0);
            this.dJt.setText(String.format(string, String.valueOf(bdVar.yF().options_count)));
            if (StringUtils.isNull(bdVar.yF().tips, true)) {
                this.dJu.setVisibility(8);
            } else {
                this.dJu.setVisibility(0);
                this.dJu.setText("(" + bdVar.yF().tips + ")");
            }
        }
        if (this.dIS.setData(bdVar)) {
            this.cTI.setVisibility(8);
        } else {
            this.cTI.setVisibility(0);
        }
        this.dIS.setForumAfterClickListener(this.bbZ);
        this.dIS.setStType("frs_page");
        P(bdVar);
        this.dII.T(this.aYc);
        b.a(this.aYc, this.cTs);
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((view == this.mRootView || view == this.dIS.getCommentNumView() || view == this.cTs) && this.aYc != null) {
            if (this.aYc.zq() > 0 && com.baidu.tieba.tbadkCore.util.f.bwK()) {
                PbActivityConfig createHistoryCfg = new PbActivityConfig(this.mPageContext.getPageActivity()).createHistoryCfg(this.aYc.getTid(), String.valueOf(this.aYc.zq()), false, true, "frs_page");
                createHistoryCfg.setFromSmartFrs(this.aYc.zU());
                createHistoryCfg.setSmartFrsPosition(this.aYc.Ab());
                createHistoryCfg.setForumId(String.valueOf(this.aYc.getFid()));
                createHistoryCfg.setStartFrom(this.currentPageType);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createHistoryCfg));
                return;
            }
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(this.aYc, this.mForumName, "frs_page", 18003, true, false, false);
            createFromThreadCfg.setFromSmartFrs(this.aYc.zU());
            createFromThreadCfg.setForumId(String.valueOf(this.aYc.getFid()));
            createFromThreadCfg.setStartFrom(this.currentPageType);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.dIS != null && this.cTK != null) {
            this.cTK.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.cTK);
        }
    }

    @Override // com.baidu.tieba.card.u
    public void setForumName(String str) {
        this.mForumName = str;
    }
}
