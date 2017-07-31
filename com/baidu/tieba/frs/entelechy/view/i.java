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
    protected TextView abX;
    protected bl akj;
    protected TbPageContext<?> alI;
    private final View.OnClickListener aoG;
    public ViewStub aoT;
    public TbImageView aoU;
    private final View.OnClickListener aoW;
    public View bFO;
    private CustomMessageListener bGK;
    private CardGroupDividerView bGx;
    public ThreadCommentAndPraiseInfoLayout bHH;
    public UserIconLayout bHK;
    public TbImageView ckY;
    private com.baidu.tieba.frs.g.g coH;
    public RelativeLayout coM;
    public HeadPendantClickableView cpi;
    public ClickableHeaderImageView cpj;
    protected TextView cpk;
    protected TextView cpl;
    private String mForumName;
    protected boolean mIsFromCDN;
    protected View mRootView;
    private int mSkinType;

    protected abstract void H(bl blVar);

    protected abstract void iW(int i);

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
        this.bGK = new CustomMessageListener(CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR) { // from class: com.baidu.tieba.frs.entelechy.view.i.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && i.this.akj != null && i.this.akj.getTid() != null && i.this.abX != null && ((String) customResponsedMessage.getData()).equals(i.this.akj.getTid())) {
                    m.a(i.this.abX, i.this.akj.getId(), d.e.cp_cont_b, d.e.cp_cont_d);
                }
            }
        };
        this.aoW = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.i.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (i.this.We() != null) {
                    i.this.We().a(view, i.this.akj);
                }
            }
        };
        this.aoG = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.i.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (i.this.We() != null) {
                    i.this.We().a(view, i.this.akj);
                }
            }
        };
        setTag(bdUniqueId);
        this.alI = tbPageContext;
        initView();
    }

    public void initView() {
        this.mRootView = getView();
        this.cpj = (ClickableHeaderImageView) this.mRootView.findViewById(d.h.card_vote_header_image);
        this.cpi = (HeadPendantClickableView) this.mRootView.findViewById(d.h.card_vote_pendant_header_image);
        this.aoT = (ViewStub) this.mRootView.findViewById(d.h.viewstub_headimage_mask);
        this.cpj.setDefaultResource(17170445);
        this.cpj.setDefaultErrorResource(d.g.icon_default_avatar100);
        this.cpj.setDefaultBgResource(d.e.cp_bg_line_e);
        this.cpj.setRadius(com.baidu.adp.lib.util.k.g(this.alI.getPageActivity(), d.f.ds70));
        if (this.cpi.getHeadView() != null) {
            this.cpi.getHeadView().setDefaultResource(17170445);
            this.cpi.getHeadView().setDefaultErrorResource(d.g.icon_default_avatar100);
            this.cpi.getHeadView().setDefaultBgResource(d.e.cp_bg_line_e);
            this.cpi.getHeadView().setRadius(com.baidu.adp.lib.util.k.g(this.alI.getPageActivity(), d.f.ds70));
            this.cpi.getHeadView().setIsRound(true);
            this.cpi.getHeadView().setDrawBorder(false);
        }
        this.cpi.wD();
        if (this.cpi.getPendantView() != null) {
            this.cpi.getPendantView().setIsRound(true);
            this.cpi.getPendantView().setDrawBorder(false);
        }
        this.bHK = (UserIconLayout) this.mRootView.findViewById(d.h.user_icon);
        this.bHK.apI = true;
        this.bHK.setEntelechyEnabled(true);
        this.bHK.setPageName(1);
        this.ckY = (TbImageView) this.mRootView.findViewById(d.h.theme_card_view);
        this.ckY.setPageId(getTag());
        this.abX = (TextView) this.mRootView.findViewById(d.h.vote_thread_title);
        this.cpk = (TextView) this.mRootView.findViewById(d.h.vote_total_option_num);
        this.cpl = (TextView) this.mRootView.findViewById(d.h.vote_now_state);
        this.bHH = (ThreadCommentAndPraiseInfoLayout) this.mRootView.findViewById(d.h.thread_more_info);
        this.bFO = this.mRootView.findViewById(d.h.divider_below_reply_number_layout);
        this.coM = (RelativeLayout) this.mRootView.findViewById(d.h.card_home_page_normal_thread_root_content);
        this.bGx = (CardGroupDividerView) this.mRootView.findViewById(d.h.header_divider);
        this.bGx.setTitleClickListener(this);
        this.bHH.setViewNumEnabled(true);
        this.coH = new com.baidu.tieba.frs.g.g(this.alI, this.bHH);
        this.coH.setUniqueId(getTag());
    }

    @Override // com.baidu.tieba.card.a
    public final void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ai.j(getView(), d.g.addresslist_item_bg);
            this.bHK.onChangeSkinType();
            this.bHH.onChangeSkinType();
            ai.c(this.cpk, d.e.cp_cont_c, 1);
            ai.c(this.cpl, d.e.cp_cont_d, 1);
            iW(i);
            if (this.bGx != null) {
                this.bGx.onChangeSkinType();
            }
            this.coH.onChangeSkinType();
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
        this.akj = blVar;
        if (getView() != null) {
            getView().setVisibility(0);
        }
        if (this.akj.getAuthor() == null || this.akj.getAuthor().getPendantData() == null || StringUtils.isNull(this.akj.getAuthor().getPendantData().pV())) {
            UserTbVipInfoData rF = this.akj.rF();
            if (rF != null && rF.getvipV_url() != null) {
                if (this.aoT != null) {
                    if (this.aoU == null) {
                        this.aoT.inflate();
                        this.aoU = (TbImageView) getView().findViewById(d.h.user_head_mask);
                    }
                    this.aoU.setPageId(getTag());
                    this.aoU.setVisibility(0);
                    this.aoU.c(rF.getvipV_url(), 10, false);
                    this.cpj.setIsBigV(true);
                }
            } else {
                this.cpj.setIsBigV(false);
                if (this.aoU != null) {
                    this.aoU.setVisibility(8);
                }
            }
            this.cpi.setVisibility(8);
            this.cpj.setVisibility(0);
            this.cpj.setData(blVar);
        } else {
            this.cpj.setIsBigV(false);
            if (this.aoU != null) {
                this.aoU.setVisibility(8);
            }
            this.cpi.setVisibility(0);
            this.cpj.setVisibility(4);
            this.cpi.setData(blVar);
        }
        this.cpj.setAfterClickListener(this.aoW);
        this.bHK.setVisibility(0);
        if (blVar.getAuthor() != null && !StringUtils.isNull(blVar.getAuthor().getSealPrefix())) {
            this.bHK.aP(true);
        }
        this.bHK.setData(blVar);
        this.bHK.setUserAfterClickListener(this.aoW);
        ArrayList arrayList = new ArrayList();
        if (blVar.rB() == 1) {
            arrayList.add(new m.a(d.l.good));
        }
        SpannableStringBuilder a = m.a((Context) TbadkCoreApplication.getInst(), blVar.getTitle(), (ArrayList<m.a>) arrayList, false);
        a.append((CharSequence) blVar.a(new SpannableString(blVar.g(blVar.getTitle(), false) + " ")));
        this.abX.setLinkTextColor(getContext().getResources().getColor(d.e.cp_link_tip_c));
        this.abX.setOnTouchListener(new com.baidu.tieba.view.l(a));
        this.abX.setText(a);
        m.a(this.abX, blVar.getId(), d.e.cp_cont_b, d.e.cp_cont_d);
        if (blVar.rt() == null || blVar.rt().options_count.intValue() == 0) {
            this.cpk.setVisibility(8);
            this.cpl.setVisibility(8);
        } else {
            String string = this.alI.getResources().getString(d.l.total_x_vote_option);
            this.cpk.setVisibility(0);
            this.cpk.setText(String.format(string, String.valueOf(blVar.rt().options_count)));
            if (StringUtils.isNull(blVar.rt().tips, true)) {
                this.cpl.setVisibility(8);
            } else {
                this.cpl.setVisibility(0);
                this.cpl.setText("(" + blVar.rt().tips + ")");
            }
        }
        if (this.bHH.a(blVar)) {
            this.bFO.setVisibility(8);
        } else {
            this.bFO.setVisibility(0);
        }
        this.bHH.setForumAfterClickListener(this.aoG);
        this.bHH.setStType(m.rw());
        H(blVar);
        this.coH.P(this.akj);
        b.a(this.akj, this.bGx);
        d(this.alI, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((view == this.mRootView || view == this.bHH.getCommentNumView() || view == this.bGx) && this.akj != null) {
            if (this.akj.sb() > 0 && com.baidu.tieba.tbadkCore.util.g.btw()) {
                PbActivityConfig createHistoryCfg = new PbActivityConfig(this.alI.getPageActivity()).createHistoryCfg(this.akj.getTid(), String.valueOf(this.akj.sb()), false, true, null);
                createHistoryCfg.setFromSmartFrs(this.akj.sI());
                createHistoryCfg.setSmartFrsPosition(this.akj.sP());
                createHistoryCfg.setForumId(String.valueOf(this.akj.getFid()));
                createHistoryCfg.setStartFrom(1);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createHistoryCfg));
                return;
            }
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.alI.getPageActivity()).createFromThreadCfg(this.akj, this.mForumName, null, 18003, true, false, false);
            createFromThreadCfg.setFromSmartFrs(this.akj.sI());
            createFromThreadCfg.setForumId(String.valueOf(this.akj.getFid()));
            createFromThreadCfg.setStartFrom(1);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.bHH != null && this.bGK != null) {
            this.bGK.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.bGK);
        }
    }

    @Override // com.baidu.tieba.card.v
    public void setForumName(String str) {
        this.mForumName = str;
    }
}
