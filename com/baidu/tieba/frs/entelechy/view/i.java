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
    protected TextView aaS;
    protected bh aiU;
    private final View.OnClickListener anf;
    public ViewStub anu;
    public TbImageView anv;
    private final View.OnClickListener anx;
    private CardGroupDividerView bJS;
    public View bKk;
    private CustomMessageListener bKm;
    public ThreadCommentAndPraiseInfoLayout bLn;
    public UserIconLayout bLq;
    public TbImageView csi;
    public HeadPendantClickableView cxS;
    public ClickableHeaderImageView cxT;
    protected TextView cxU;
    protected TextView cxV;
    private com.baidu.tieba.frs.h.g cxr;
    public RelativeLayout cxw;
    private String mForumName;
    protected TbPageContext<?> mH;
    protected boolean mIsFromCDN;
    protected View mRootView;
    private int mSkinType;

    protected abstract void G(bh bhVar);

    protected abstract void jw(int i);

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
        this.bKm = new CustomMessageListener(CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR) { // from class: com.baidu.tieba.frs.entelechy.view.i.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && i.this.aiU != null && i.this.aiU.getTid() != null && i.this.aaS != null && ((String) customResponsedMessage.getData()).equals(i.this.aiU.getTid())) {
                    m.a(i.this.aaS, i.this.aiU.getId(), d.e.cp_cont_b, d.e.cp_cont_d);
                }
            }
        };
        this.anx = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.i.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (i.this.Xn() != null) {
                    i.this.Xn().a(view, i.this.aiU);
                }
            }
        };
        this.anf = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.i.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (i.this.Xn() != null) {
                    i.this.Xn().a(view, i.this.aiU);
                }
            }
        };
        setTag(bdUniqueId);
        this.mH = tbPageContext;
        initView();
    }

    public void initView() {
        this.mRootView = getView();
        this.cxT = (ClickableHeaderImageView) this.mRootView.findViewById(d.h.card_vote_header_image);
        this.cxS = (HeadPendantClickableView) this.mRootView.findViewById(d.h.card_vote_pendant_header_image);
        this.anu = (ViewStub) this.mRootView.findViewById(d.h.viewstub_headimage_mask);
        this.cxT.setDefaultResource(17170445);
        this.cxT.setDefaultErrorResource(d.g.icon_default_avatar100);
        this.cxT.setDefaultBgResource(d.e.cp_bg_line_e);
        this.cxT.setRadius(com.baidu.adp.lib.util.l.f(this.mH.getPageActivity(), d.f.ds70));
        if (this.cxS.getHeadView() != null) {
            this.cxS.getHeadView().setDefaultResource(17170445);
            this.cxS.getHeadView().setDefaultErrorResource(d.g.icon_default_avatar100);
            this.cxS.getHeadView().setDefaultBgResource(d.e.cp_bg_line_e);
            this.cxS.getHeadView().setRadius(com.baidu.adp.lib.util.l.f(this.mH.getPageActivity(), d.f.ds70));
            this.cxS.getHeadView().setIsRound(true);
            this.cxS.getHeadView().setDrawBorder(false);
        }
        this.cxS.vZ();
        if (this.cxS.getPendantView() != null) {
            this.cxS.getPendantView().setIsRound(true);
            this.cxS.getPendantView().setDrawBorder(false);
        }
        this.bLq = (UserIconLayout) this.mRootView.findViewById(d.h.user_icon);
        this.bLq.aok = true;
        this.bLq.setEntelechyEnabled(true);
        this.bLq.setPageName(1);
        this.csi = (TbImageView) this.mRootView.findViewById(d.h.theme_card_view);
        this.csi.setPageId(getTag());
        this.aaS = (TextView) this.mRootView.findViewById(d.h.vote_thread_title);
        this.cxU = (TextView) this.mRootView.findViewById(d.h.vote_total_option_num);
        this.cxV = (TextView) this.mRootView.findViewById(d.h.vote_now_state);
        this.bLn = (ThreadCommentAndPraiseInfoLayout) this.mRootView.findViewById(d.h.thread_more_info);
        this.bKk = this.mRootView.findViewById(d.h.divider_below_reply_number_layout);
        this.cxw = (RelativeLayout) this.mRootView.findViewById(d.h.card_home_page_normal_thread_root_content);
        this.bJS = (CardGroupDividerView) this.mRootView.findViewById(d.h.header_divider);
        this.bJS.setTitleClickListener(this);
        this.bLn.setViewNumEnabled(true);
        this.bLn.setFrom(2);
        this.cxr = new com.baidu.tieba.frs.h.g(this.mH, this.bLn);
        this.cxr.setUniqueId(getTag());
    }

    @Override // com.baidu.tieba.card.a
    public final void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.j(getView(), d.g.addresslist_item_bg);
            this.bLq.onChangeSkinType();
            this.bLn.onChangeSkinType();
            aj.c(this.cxU, d.e.cp_cont_c, 1);
            aj.c(this.cxV, d.e.cp_cont_d, 1);
            jw(i);
            if (this.bJS != null) {
                this.bJS.onChangeSkinType();
            }
            this.cxr.onChangeSkinType();
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.j.card_vote_item;
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
        this.aiU = bhVar;
        if (getView() != null) {
            getView().setVisibility(0);
        }
        if (this.aiU.getAuthor() == null || this.aiU.getAuthor().getPendantData() == null || StringUtils.isNull(this.aiU.getAuthor().getPendantData().pL())) {
            UserTbVipInfoData ro = this.aiU.ro();
            if (ro != null && ro.getvipV_url() != null) {
                if (this.anu != null) {
                    if (this.anv == null) {
                        this.anu.inflate();
                        this.anv = (TbImageView) getView().findViewById(d.h.user_head_mask);
                    }
                    this.anv.setPageId(getTag());
                    this.anv.setVisibility(0);
                    this.anv.c(ro.getvipV_url(), 10, false);
                    this.cxT.setIsBigV(true);
                }
            } else {
                this.cxT.setIsBigV(false);
                if (this.anv != null) {
                    this.anv.setVisibility(8);
                }
            }
            this.cxS.setVisibility(8);
            this.cxT.setVisibility(0);
            this.cxT.setData(bhVar);
        } else {
            this.cxT.setIsBigV(false);
            if (this.anv != null) {
                this.anv.setVisibility(8);
            }
            this.cxS.setVisibility(0);
            this.cxT.setVisibility(4);
            this.cxS.setData(bhVar);
        }
        this.cxT.setAfterClickListener(this.anx);
        this.bLq.setVisibility(0);
        if (bhVar.getAuthor() != null && !StringUtils.isNull(bhVar.getAuthor().getSealPrefix())) {
            this.bLq.aN(true);
        }
        this.bLq.setData(bhVar);
        this.bLq.setUserAfterClickListener(this.anx);
        ArrayList arrayList = new ArrayList();
        if (bhVar.rk() == 1) {
            arrayList.add(new m.a(d.l.good));
        }
        SpannableStringBuilder a = m.a((Context) TbadkCoreApplication.getInst(), bhVar.getTitle(), (ArrayList<m.a>) arrayList, false);
        a.append((CharSequence) bhVar.a(new SpannableString(bhVar.g(bhVar.getTitle(), false) + " ")));
        this.aaS.setLinkTextColor(getContext().getResources().getColor(d.e.cp_link_tip_c));
        this.aaS.setOnTouchListener(new com.baidu.tieba.view.k(a));
        this.aaS.setText(a);
        m.a(this.aaS, bhVar.getId(), d.e.cp_cont_b, d.e.cp_cont_d);
        if (bhVar.rc() == null || bhVar.rc().options_count.intValue() == 0) {
            this.cxU.setVisibility(8);
            this.cxV.setVisibility(8);
        } else {
            String string = this.mH.getResources().getString(d.l.total_x_vote_option);
            this.cxU.setVisibility(0);
            this.cxU.setText(String.format(string, String.valueOf(bhVar.rc().options_count)));
            if (StringUtils.isNull(bhVar.rc().tips, true)) {
                this.cxV.setVisibility(8);
            } else {
                this.cxV.setVisibility(0);
                this.cxV.setText("(" + bhVar.rc().tips + ")");
            }
        }
        if (this.bLn.setData(bhVar)) {
            this.bKk.setVisibility(8);
        } else {
            this.bKk.setVisibility(0);
        }
        this.bLn.setForumAfterClickListener(this.anf);
        this.bLn.setStType(m.rf());
        G(bhVar);
        this.cxr.O(this.aiU);
        b.a(this.aiU, this.bJS);
        d(this.mH, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((view == this.mRootView || view == this.bLn.getCommentNumView() || view == this.bJS) && this.aiU != null) {
            if (this.aiU.rK() > 0 && com.baidu.tieba.tbadkCore.util.f.bso()) {
                PbActivityConfig createHistoryCfg = new PbActivityConfig(this.mH.getPageActivity()).createHistoryCfg(this.aiU.getTid(), String.valueOf(this.aiU.rK()), false, true, null);
                createHistoryCfg.setFromSmartFrs(this.aiU.sr());
                createHistoryCfg.setSmartFrsPosition(this.aiU.sy());
                createHistoryCfg.setForumId(String.valueOf(this.aiU.getFid()));
                createHistoryCfg.setStartFrom(1);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createHistoryCfg));
                return;
            }
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mH.getPageActivity()).createFromThreadCfg(this.aiU, this.mForumName, null, 18003, true, false, false);
            createFromThreadCfg.setFromSmartFrs(this.aiU.sr());
            createFromThreadCfg.setForumId(String.valueOf(this.aiU.getFid()));
            createFromThreadCfg.setStartFrom(1);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
        }
    }

    public void k(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.bLn != null && this.bKm != null) {
            this.bKm.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.bKm);
        }
    }

    @Override // com.baidu.tieba.card.v
    public void setForumName(String str) {
        this.mForumName = str;
    }
}
