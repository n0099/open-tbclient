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
    public View bGx;
    private CardGroupDividerView bHg;
    private CustomMessageListener bHt;
    public ThreadCommentAndPraiseInfoLayout bIq;
    public UserIconLayout bIt;
    public TbImageView clJ;
    public HeadPendantClickableView cpQ;
    public ClickableHeaderImageView cpR;
    protected TextView cpS;
    protected TextView cpT;
    private com.baidu.tieba.frs.g.g cpp;
    public RelativeLayout cpu;
    private String mForumName;
    protected boolean mIsFromCDN;
    protected View mRootView;
    private int mSkinType;
    protected TbPageContext<?> oV;

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
        this.bHt = new CustomMessageListener(CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR) { // from class: com.baidu.tieba.frs.entelechy.view.i.1
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
                if (i.this.WA() != null) {
                    i.this.WA().a(view, i.this.akl);
                }
            }
        };
        this.aoH = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.i.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (i.this.WA() != null) {
                    i.this.WA().a(view, i.this.akl);
                }
            }
        };
        setTag(bdUniqueId);
        this.oV = tbPageContext;
        initView();
    }

    public void initView() {
        this.mRootView = getView();
        this.cpR = (ClickableHeaderImageView) this.mRootView.findViewById(d.h.card_vote_header_image);
        this.cpQ = (HeadPendantClickableView) this.mRootView.findViewById(d.h.card_vote_pendant_header_image);
        this.aoU = (ViewStub) this.mRootView.findViewById(d.h.viewstub_headimage_mask);
        this.cpR.setDefaultResource(17170445);
        this.cpR.setDefaultErrorResource(d.g.icon_default_avatar100);
        this.cpR.setDefaultBgResource(d.e.cp_bg_line_e);
        this.cpR.setRadius(com.baidu.adp.lib.util.k.g(this.oV.getPageActivity(), d.f.ds70));
        if (this.cpQ.getHeadView() != null) {
            this.cpQ.getHeadView().setDefaultResource(17170445);
            this.cpQ.getHeadView().setDefaultErrorResource(d.g.icon_default_avatar100);
            this.cpQ.getHeadView().setDefaultBgResource(d.e.cp_bg_line_e);
            this.cpQ.getHeadView().setRadius(com.baidu.adp.lib.util.k.g(this.oV.getPageActivity(), d.f.ds70));
            this.cpQ.getHeadView().setIsRound(true);
            this.cpQ.getHeadView().setDrawBorder(false);
        }
        this.cpQ.wD();
        if (this.cpQ.getPendantView() != null) {
            this.cpQ.getPendantView().setIsRound(true);
            this.cpQ.getPendantView().setDrawBorder(false);
        }
        this.bIt = (UserIconLayout) this.mRootView.findViewById(d.h.user_icon);
        this.bIt.apJ = true;
        this.bIt.setEntelechyEnabled(true);
        this.bIt.setPageName(1);
        this.clJ = (TbImageView) this.mRootView.findViewById(d.h.theme_card_view);
        this.clJ.setPageId(getTag());
        this.abZ = (TextView) this.mRootView.findViewById(d.h.vote_thread_title);
        this.cpS = (TextView) this.mRootView.findViewById(d.h.vote_total_option_num);
        this.cpT = (TextView) this.mRootView.findViewById(d.h.vote_now_state);
        this.bIq = (ThreadCommentAndPraiseInfoLayout) this.mRootView.findViewById(d.h.thread_more_info);
        this.bGx = this.mRootView.findViewById(d.h.divider_below_reply_number_layout);
        this.cpu = (RelativeLayout) this.mRootView.findViewById(d.h.card_home_page_normal_thread_root_content);
        this.bHg = (CardGroupDividerView) this.mRootView.findViewById(d.h.header_divider);
        this.bHg.setTitleClickListener(this);
        this.bIq.setViewNumEnabled(true);
        this.cpp = new com.baidu.tieba.frs.g.g(this.oV, this.bIq);
        this.cpp.setUniqueId(getTag());
    }

    @Override // com.baidu.tieba.card.a
    public final void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ai.j(getView(), d.g.addresslist_item_bg);
            this.bIt.onChangeSkinType();
            this.bIq.onChangeSkinType();
            ai.c(this.cpS, d.e.cp_cont_c, 1);
            ai.c(this.cpT, d.e.cp_cont_d, 1);
            iY(i);
            if (this.bHg != null) {
                this.bHg.onChangeSkinType();
            }
            this.cpp.onChangeSkinType();
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
        if (this.akl.getAuthor() == null || this.akl.getAuthor().getPendantData() == null || StringUtils.isNull(this.akl.getAuthor().getPendantData().pV())) {
            UserTbVipInfoData rF = this.akl.rF();
            if (rF != null && rF.getvipV_url() != null) {
                if (this.aoU != null) {
                    if (this.aoV == null) {
                        this.aoU.inflate();
                        this.aoV = (TbImageView) getView().findViewById(d.h.user_head_mask);
                    }
                    this.aoV.setPageId(getTag());
                    this.aoV.setVisibility(0);
                    this.aoV.c(rF.getvipV_url(), 10, false);
                    this.cpR.setIsBigV(true);
                }
            } else {
                this.cpR.setIsBigV(false);
                if (this.aoV != null) {
                    this.aoV.setVisibility(8);
                }
            }
            this.cpQ.setVisibility(8);
            this.cpR.setVisibility(0);
            this.cpR.setData(blVar);
        } else {
            this.cpR.setIsBigV(false);
            if (this.aoV != null) {
                this.aoV.setVisibility(8);
            }
            this.cpQ.setVisibility(0);
            this.cpR.setVisibility(4);
            this.cpQ.setData(blVar);
        }
        this.cpR.setAfterClickListener(this.aoX);
        this.bIt.setVisibility(0);
        if (blVar.getAuthor() != null && !StringUtils.isNull(blVar.getAuthor().getSealPrefix())) {
            this.bIt.aP(true);
        }
        this.bIt.setData(blVar);
        this.bIt.setUserAfterClickListener(this.aoX);
        ArrayList arrayList = new ArrayList();
        if (blVar.rB() == 1) {
            arrayList.add(new m.a(d.l.good));
        }
        SpannableStringBuilder a = m.a((Context) TbadkCoreApplication.getInst(), blVar.getTitle(), (ArrayList<m.a>) arrayList, false);
        a.append((CharSequence) blVar.a(new SpannableString(blVar.g(blVar.getTitle(), false) + " ")));
        this.abZ.setLinkTextColor(getContext().getResources().getColor(d.e.cp_link_tip_c));
        this.abZ.setOnTouchListener(new com.baidu.tieba.view.l(a));
        this.abZ.setText(a);
        m.a(this.abZ, blVar.getId(), d.e.cp_cont_b, d.e.cp_cont_d);
        if (blVar.rt() == null || blVar.rt().options_count.intValue() == 0) {
            this.cpS.setVisibility(8);
            this.cpT.setVisibility(8);
        } else {
            String string = this.oV.getResources().getString(d.l.total_x_vote_option);
            this.cpS.setVisibility(0);
            this.cpS.setText(String.format(string, String.valueOf(blVar.rt().options_count)));
            if (StringUtils.isNull(blVar.rt().tips, true)) {
                this.cpT.setVisibility(8);
            } else {
                this.cpT.setVisibility(0);
                this.cpT.setText("(" + blVar.rt().tips + ")");
            }
        }
        if (this.bIq.a(blVar)) {
            this.bGx.setVisibility(8);
        } else {
            this.bGx.setVisibility(0);
        }
        this.bIq.setForumAfterClickListener(this.aoH);
        this.bIq.setStType(m.rw());
        H(blVar);
        this.cpp.P(this.akl);
        b.a(this.akl, this.bHg);
        d(this.oV, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((view == this.mRootView || view == this.bIq.getCommentNumView() || view == this.bHg) && this.akl != null) {
            if (this.akl.sb() > 0 && com.baidu.tieba.tbadkCore.util.g.bue()) {
                PbActivityConfig createHistoryCfg = new PbActivityConfig(this.oV.getPageActivity()).createHistoryCfg(this.akl.getTid(), String.valueOf(this.akl.sb()), false, true, null);
                createHistoryCfg.setFromSmartFrs(this.akl.sI());
                createHistoryCfg.setSmartFrsPosition(this.akl.sP());
                createHistoryCfg.setForumId(String.valueOf(this.akl.getFid()));
                createHistoryCfg.setStartFrom(1);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createHistoryCfg));
                return;
            }
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.oV.getPageActivity()).createFromThreadCfg(this.akl, this.mForumName, null, 18003, true, false, false);
            createFromThreadCfg.setFromSmartFrs(this.akl.sI());
            createFromThreadCfg.setForumId(String.valueOf(this.akl.getFid()));
            createFromThreadCfg.setStartFrom(1);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.bIq != null && this.bHt != null) {
            this.bHt.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.bHt);
        }
    }

    @Override // com.baidu.tieba.card.v
    public void setForumName(String str) {
        this.mForumName = str;
    }
}
