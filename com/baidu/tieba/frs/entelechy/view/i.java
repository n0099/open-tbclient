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
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.ai;
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
public abstract class i extends com.baidu.tieba.card.a<bl> implements v {
    protected TextView abZ;
    protected bl akl;
    private final View.OnClickListener aoH;
    public ViewStub aoU;
    public TbImageView aoV;
    private final View.OnClickListener aoX;
    public View bGy;
    private CardGroupDividerView bHh;
    private CustomMessageListener bHu;
    public ThreadCommentAndPraiseInfoLayout bIr;
    public UserIconLayout bIu;
    public TbImageView clK;
    public HeadPendantClickableView cpR;
    public ClickableHeaderImageView cpS;
    protected TextView cpT;
    protected TextView cpU;
    private com.baidu.tieba.frs.g.g cpq;
    public RelativeLayout cpv;
    private String mForumName;
    protected boolean mIsFromCDN;
    protected View mRootView;
    private int mSkinType;
    protected TbPageContext<?> oW;

    protected abstract void H(bl blVar);

    protected abstract void iY(int i);

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
        this.bHu = new CustomMessageListener(CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR) { // from class: com.baidu.tieba.frs.entelechy.view.i.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && i.this.akl != null && i.this.akl.getTid() != null && i.this.abZ != null && ((String) customResponsedMessage.getData()).equals(i.this.akl.getTid())) {
                    m.a(i.this.abZ, i.this.akl.getId(), d.e.cp_cont_b, d.e.cp_cont_d);
                }
            }
        };
        this.aoX = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.i.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (i.this.Wx() != null) {
                    i.this.Wx().a(view, i.this.akl);
                }
            }
        };
        this.aoH = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.i.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (i.this.Wx() != null) {
                    i.this.Wx().a(view, i.this.akl);
                }
            }
        };
        setTag(bdUniqueId);
        this.oW = tbPageContext;
        initView();
    }

    public void initView() {
        this.mRootView = getView();
        this.cpS = (ClickableHeaderImageView) this.mRootView.findViewById(d.h.card_vote_header_image);
        this.cpR = (HeadPendantClickableView) this.mRootView.findViewById(d.h.card_vote_pendant_header_image);
        this.aoU = (ViewStub) this.mRootView.findViewById(d.h.viewstub_headimage_mask);
        this.cpS.setDefaultResource(17170445);
        this.cpS.setDefaultErrorResource(d.g.icon_default_avatar100);
        this.cpS.setDefaultBgResource(d.e.cp_bg_line_e);
        this.cpS.setRadius(com.baidu.adp.lib.util.k.g(this.oW.getPageActivity(), d.f.ds70));
        if (this.cpR.getHeadView() != null) {
            this.cpR.getHeadView().setDefaultResource(17170445);
            this.cpR.getHeadView().setDefaultErrorResource(d.g.icon_default_avatar100);
            this.cpR.getHeadView().setDefaultBgResource(d.e.cp_bg_line_e);
            this.cpR.getHeadView().setRadius(com.baidu.adp.lib.util.k.g(this.oW.getPageActivity(), d.f.ds70));
            this.cpR.getHeadView().setIsRound(true);
            this.cpR.getHeadView().setDrawBorder(false);
        }
        this.cpR.wE();
        if (this.cpR.getPendantView() != null) {
            this.cpR.getPendantView().setIsRound(true);
            this.cpR.getPendantView().setDrawBorder(false);
        }
        this.bIu = (UserIconLayout) this.mRootView.findViewById(d.h.user_icon);
        this.bIu.apJ = true;
        this.bIu.setEntelechyEnabled(true);
        this.bIu.setPageName(1);
        this.clK = (TbImageView) this.mRootView.findViewById(d.h.theme_card_view);
        this.clK.setPageId(getTag());
        this.abZ = (TextView) this.mRootView.findViewById(d.h.vote_thread_title);
        this.cpT = (TextView) this.mRootView.findViewById(d.h.vote_total_option_num);
        this.cpU = (TextView) this.mRootView.findViewById(d.h.vote_now_state);
        this.bIr = (ThreadCommentAndPraiseInfoLayout) this.mRootView.findViewById(d.h.thread_more_info);
        this.bGy = this.mRootView.findViewById(d.h.divider_below_reply_number_layout);
        this.cpv = (RelativeLayout) this.mRootView.findViewById(d.h.card_home_page_normal_thread_root_content);
        this.bHh = (CardGroupDividerView) this.mRootView.findViewById(d.h.header_divider);
        this.bHh.setTitleClickListener(this);
        this.bIr.setViewNumEnabled(true);
        this.cpq = new com.baidu.tieba.frs.g.g(this.oW, this.bIr);
        this.cpq.setUniqueId(getTag());
    }

    @Override // com.baidu.tieba.card.a
    public final void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ai.j(getView(), d.g.addresslist_item_bg);
            this.bIu.onChangeSkinType();
            this.bIr.onChangeSkinType();
            ai.c(this.cpT, d.e.cp_cont_c, 1);
            ai.c(this.cpU, d.e.cp_cont_d, 1);
            iY(i);
            if (this.bHh != null) {
                this.bHh.onChangeSkinType();
            }
            this.cpq.onChangeSkinType();
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.j.card_vote_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: x */
    public final void a(bl blVar) {
        if (blVar == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        this.akl = blVar;
        if (getView() != null) {
            getView().setVisibility(0);
        }
        if (this.akl.getAuthor() == null || this.akl.getAuthor().getPendantData() == null || StringUtils.isNull(this.akl.getAuthor().getPendantData().pW())) {
            UserTbVipInfoData rG = this.akl.rG();
            if (rG != null && rG.getvipV_url() != null) {
                if (this.aoU != null) {
                    if (this.aoV == null) {
                        this.aoU.inflate();
                        this.aoV = (TbImageView) getView().findViewById(d.h.user_head_mask);
                    }
                    this.aoV.setPageId(getTag());
                    this.aoV.setVisibility(0);
                    this.aoV.c(rG.getvipV_url(), 10, false);
                    this.cpS.setIsBigV(true);
                }
            } else {
                this.cpS.setIsBigV(false);
                if (this.aoV != null) {
                    this.aoV.setVisibility(8);
                }
            }
            this.cpR.setVisibility(8);
            this.cpS.setVisibility(0);
            this.cpS.setData(blVar);
        } else {
            this.cpS.setIsBigV(false);
            if (this.aoV != null) {
                this.aoV.setVisibility(8);
            }
            this.cpR.setVisibility(0);
            this.cpS.setVisibility(4);
            this.cpR.setData(blVar);
        }
        this.cpS.setAfterClickListener(this.aoX);
        this.bIu.setVisibility(0);
        if (blVar.getAuthor() != null && !StringUtils.isNull(blVar.getAuthor().getSealPrefix())) {
            this.bIu.aP(true);
        }
        this.bIu.setData(blVar);
        this.bIu.setUserAfterClickListener(this.aoX);
        ArrayList arrayList = new ArrayList();
        if (blVar.rC() == 1) {
            arrayList.add(new m.a(d.l.good));
        }
        SpannableStringBuilder a = m.a((Context) TbadkCoreApplication.getInst(), blVar.getTitle(), (ArrayList<m.a>) arrayList, false);
        a.append((CharSequence) blVar.a(new SpannableString(blVar.g(blVar.getTitle(), false) + " ")));
        this.abZ.setLinkTextColor(getContext().getResources().getColor(d.e.cp_link_tip_c));
        this.abZ.setOnTouchListener(new com.baidu.tieba.view.l(a));
        this.abZ.setText(a);
        m.a(this.abZ, blVar.getId(), d.e.cp_cont_b, d.e.cp_cont_d);
        if (blVar.ru() == null || blVar.ru().options_count.intValue() == 0) {
            this.cpT.setVisibility(8);
            this.cpU.setVisibility(8);
        } else {
            String string = this.oW.getResources().getString(d.l.total_x_vote_option);
            this.cpT.setVisibility(0);
            this.cpT.setText(String.format(string, String.valueOf(blVar.ru().options_count)));
            if (StringUtils.isNull(blVar.ru().tips, true)) {
                this.cpU.setVisibility(8);
            } else {
                this.cpU.setVisibility(0);
                this.cpU.setText("(" + blVar.ru().tips + ")");
            }
        }
        if (this.bIr.a(blVar)) {
            this.bGy.setVisibility(8);
        } else {
            this.bGy.setVisibility(0);
        }
        this.bIr.setForumAfterClickListener(this.aoH);
        this.bIr.setStType(m.rx());
        H(blVar);
        this.cpq.P(this.akl);
        b.a(this.akl, this.bHh);
        d(this.oW, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((view == this.mRootView || view == this.bIr.getCommentNumView() || view == this.bHh) && this.akl != null) {
            if (this.akl.sc() > 0 && com.baidu.tieba.tbadkCore.util.g.btX()) {
                PbActivityConfig createHistoryCfg = new PbActivityConfig(this.oW.getPageActivity()).createHistoryCfg(this.akl.getTid(), String.valueOf(this.akl.sc()), false, true, null);
                createHistoryCfg.setFromSmartFrs(this.akl.sJ());
                createHistoryCfg.setSmartFrsPosition(this.akl.sQ());
                createHistoryCfg.setForumId(String.valueOf(this.akl.getFid()));
                createHistoryCfg.setStartFrom(1);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createHistoryCfg));
                return;
            }
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.oW.getPageActivity()).createFromThreadCfg(this.akl, this.mForumName, null, 18003, true, false, false);
            createFromThreadCfg.setFromSmartFrs(this.akl.sJ());
            createFromThreadCfg.setForumId(String.valueOf(this.akl.getFid()));
            createFromThreadCfg.setStartFrom(1);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.bIr != null && this.bHu != null) {
            this.bHu.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.bHu);
        }
    }

    @Override // com.baidu.tieba.card.v
    public void setForumName(String str) {
        this.mForumName = str;
    }
}
