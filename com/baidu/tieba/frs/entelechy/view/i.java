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
import com.baidu.tbadk.core.data.bj;
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
public abstract class i extends com.baidu.tieba.card.a<bj> implements v {
    protected TextView abe;
    protected bj ajE;
    private final View.OnClickListener aoc;
    public ViewStub aor;
    public TbImageView aos;
    private final View.OnClickListener aou;
    private CardGroupDividerView bKR;
    public View bKj;
    private CustomMessageListener bLe;
    public ThreadCommentAndPraiseInfoLayout bMc;
    public UserIconLayout bMf;
    public TbImageView crX;
    private com.baidu.tieba.frs.h.g cwN;
    public RelativeLayout cwS;
    public HeadPendantClickableView cxo;
    public ClickableHeaderImageView cxp;
    protected TextView cxq;
    protected TextView cxr;
    protected TbPageContext<?> mF;
    private String mForumName;
    protected boolean mIsFromCDN;
    protected View mRootView;
    private int mSkinType;

    protected abstract void L(bj bjVar);

    protected abstract void jo(int i);

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
        this.bLe = new CustomMessageListener(CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR) { // from class: com.baidu.tieba.frs.entelechy.view.i.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && i.this.ajE != null && i.this.ajE.getTid() != null && i.this.abe != null && ((String) customResponsedMessage.getData()).equals(i.this.ajE.getTid())) {
                    m.a(i.this.abe, i.this.ajE.getId(), d.e.cp_cont_b, d.e.cp_cont_d);
                }
            }
        };
        this.aou = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.i.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (i.this.XL() != null) {
                    i.this.XL().a(view, i.this.ajE);
                }
            }
        };
        this.aoc = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.i.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (i.this.XL() != null) {
                    i.this.XL().a(view, i.this.ajE);
                }
            }
        };
        setTag(bdUniqueId);
        this.mF = tbPageContext;
        initView();
    }

    public void initView() {
        this.mRootView = getView();
        this.cxp = (ClickableHeaderImageView) this.mRootView.findViewById(d.h.card_vote_header_image);
        this.cxo = (HeadPendantClickableView) this.mRootView.findViewById(d.h.card_vote_pendant_header_image);
        this.aor = (ViewStub) this.mRootView.findViewById(d.h.viewstub_headimage_mask);
        this.cxp.setDefaultResource(17170445);
        this.cxp.setDefaultErrorResource(d.g.icon_default_avatar100);
        this.cxp.setDefaultBgResource(d.e.cp_bg_line_e);
        this.cxp.setRadius(com.baidu.adp.lib.util.k.f(this.mF.getPageActivity(), d.f.ds70));
        if (this.cxo.getHeadView() != null) {
            this.cxo.getHeadView().setDefaultResource(17170445);
            this.cxo.getHeadView().setDefaultErrorResource(d.g.icon_default_avatar100);
            this.cxo.getHeadView().setDefaultBgResource(d.e.cp_bg_line_e);
            this.cxo.getHeadView().setRadius(com.baidu.adp.lib.util.k.f(this.mF.getPageActivity(), d.f.ds70));
            this.cxo.getHeadView().setIsRound(true);
            this.cxo.getHeadView().setDrawBorder(false);
        }
        this.cxo.wB();
        if (this.cxo.getPendantView() != null) {
            this.cxo.getPendantView().setIsRound(true);
            this.cxo.getPendantView().setDrawBorder(false);
        }
        this.bMf = (UserIconLayout) this.mRootView.findViewById(d.h.user_icon);
        this.bMf.apl = true;
        this.bMf.setEntelechyEnabled(true);
        this.bMf.setPageName(1);
        this.crX = (TbImageView) this.mRootView.findViewById(d.h.theme_card_view);
        this.crX.setPageId(getTag());
        this.abe = (TextView) this.mRootView.findViewById(d.h.vote_thread_title);
        this.cxq = (TextView) this.mRootView.findViewById(d.h.vote_total_option_num);
        this.cxr = (TextView) this.mRootView.findViewById(d.h.vote_now_state);
        this.bMc = (ThreadCommentAndPraiseInfoLayout) this.mRootView.findViewById(d.h.thread_more_info);
        this.bKj = this.mRootView.findViewById(d.h.divider_below_reply_number_layout);
        this.cwS = (RelativeLayout) this.mRootView.findViewById(d.h.card_home_page_normal_thread_root_content);
        this.bKR = (CardGroupDividerView) this.mRootView.findViewById(d.h.header_divider);
        this.bKR.setTitleClickListener(this);
        this.bMc.setViewNumEnabled(true);
        this.bMc.setFrom(2);
        this.cwN = new com.baidu.tieba.frs.h.g(this.mF, this.bMc);
        this.cwN.setUniqueId(getTag());
    }

    @Override // com.baidu.tieba.card.a
    public final void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.j(getView(), d.g.addresslist_item_bg);
            this.bMf.onChangeSkinType();
            this.bMc.onChangeSkinType();
            aj.c(this.cxq, d.e.cp_cont_c, 1);
            aj.c(this.cxr, d.e.cp_cont_d, 1);
            jo(i);
            if (this.bKR != null) {
                this.bKR.onChangeSkinType();
            }
            this.cwN.onChangeSkinType();
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.j.card_vote_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: A */
    public final void a(bj bjVar) {
        if (bjVar == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        this.ajE = bjVar;
        if (getView() != null) {
            getView().setVisibility(0);
        }
        if (this.ajE.getAuthor() == null || this.ajE.getAuthor().getPendantData() == null || StringUtils.isNull(this.ajE.getAuthor().getPendantData().pR())) {
            UserTbVipInfoData rB = this.ajE.rB();
            if (rB != null && rB.getvipV_url() != null) {
                if (this.aor != null) {
                    if (this.aos == null) {
                        this.aor.inflate();
                        this.aos = (TbImageView) getView().findViewById(d.h.user_head_mask);
                    }
                    this.aos.setPageId(getTag());
                    this.aos.setVisibility(0);
                    this.aos.c(rB.getvipV_url(), 10, false);
                    this.cxp.setIsBigV(true);
                }
            } else {
                this.cxp.setIsBigV(false);
                if (this.aos != null) {
                    this.aos.setVisibility(8);
                }
            }
            this.cxo.setVisibility(8);
            this.cxp.setVisibility(0);
            this.cxp.setData(bjVar);
        } else {
            this.cxp.setIsBigV(false);
            if (this.aos != null) {
                this.aos.setVisibility(8);
            }
            this.cxo.setVisibility(0);
            this.cxp.setVisibility(4);
            this.cxo.setData(bjVar);
        }
        this.cxp.setAfterClickListener(this.aou);
        this.bMf.setVisibility(0);
        if (bjVar.getAuthor() != null && !StringUtils.isNull(bjVar.getAuthor().getSealPrefix())) {
            this.bMf.aP(true);
        }
        this.bMf.setData(bjVar);
        this.bMf.setUserAfterClickListener(this.aou);
        ArrayList arrayList = new ArrayList();
        if (bjVar.rx() == 1) {
            arrayList.add(new m.a(d.l.good));
        }
        SpannableStringBuilder a = m.a((Context) TbadkCoreApplication.getInst(), bjVar.getTitle(), (ArrayList<m.a>) arrayList, false);
        a.append((CharSequence) bjVar.a(new SpannableString(bjVar.g(bjVar.getTitle(), false) + " ")));
        this.abe.setLinkTextColor(getContext().getResources().getColor(d.e.cp_link_tip_c));
        this.abe.setOnTouchListener(new com.baidu.tieba.view.m(a));
        this.abe.setText(a);
        m.a(this.abe, bjVar.getId(), d.e.cp_cont_b, d.e.cp_cont_d);
        if (bjVar.rp() == null || bjVar.rp().options_count.intValue() == 0) {
            this.cxq.setVisibility(8);
            this.cxr.setVisibility(8);
        } else {
            String string = this.mF.getResources().getString(d.l.total_x_vote_option);
            this.cxq.setVisibility(0);
            this.cxq.setText(String.format(string, String.valueOf(bjVar.rp().options_count)));
            if (StringUtils.isNull(bjVar.rp().tips, true)) {
                this.cxr.setVisibility(8);
            } else {
                this.cxr.setVisibility(0);
                this.cxr.setText("(" + bjVar.rp().tips + ")");
            }
        }
        if (this.bMc.c(bjVar)) {
            this.bKj.setVisibility(8);
        } else {
            this.bKj.setVisibility(0);
        }
        this.bMc.setForumAfterClickListener(this.aoc);
        this.bMc.setStType(m.rs());
        L(bjVar);
        this.cwN.T(this.ajE);
        b.a(this.ajE, this.bKR);
        d(this.mF, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((view == this.mRootView || view == this.bMc.getCommentNumView() || view == this.bKR) && this.ajE != null) {
            if (this.ajE.rX() > 0 && com.baidu.tieba.tbadkCore.util.g.btx()) {
                PbActivityConfig createHistoryCfg = new PbActivityConfig(this.mF.getPageActivity()).createHistoryCfg(this.ajE.getTid(), String.valueOf(this.ajE.rX()), false, true, null);
                createHistoryCfg.setFromSmartFrs(this.ajE.sE());
                createHistoryCfg.setSmartFrsPosition(this.ajE.sL());
                createHistoryCfg.setForumId(String.valueOf(this.ajE.getFid()));
                createHistoryCfg.setStartFrom(1);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createHistoryCfg));
                return;
            }
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mF.getPageActivity()).createFromThreadCfg(this.ajE, this.mForumName, null, 18003, true, false, false);
            createFromThreadCfg.setFromSmartFrs(this.ajE.sE());
            createFromThreadCfg.setForumId(String.valueOf(this.ajE.getFid()));
            createFromThreadCfg.setStartFrom(1);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
        }
    }

    public void l(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.bMc != null && this.bLe != null) {
            this.bLe.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.bLe);
        }
    }

    @Override // com.baidu.tieba.card.v
    public void setForumName(String str) {
        this.mForumName = str;
    }
}
