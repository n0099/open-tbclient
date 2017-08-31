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
    protected bj ajF;
    private final View.OnClickListener aoe;
    public ViewStub aot;
    public TbImageView aou;
    private final View.OnClickListener aow;
    public View bJs;
    private CardGroupDividerView bKa;
    private CustomMessageListener bKn;
    public ThreadCommentAndPraiseInfoLayout bLl;
    public UserIconLayout bLo;
    public TbImageView crf;
    private com.baidu.tieba.frs.h.g cvV;
    public RelativeLayout cwa;
    public HeadPendantClickableView cww;
    public ClickableHeaderImageView cwx;
    protected TextView cwy;
    protected TextView cwz;
    protected TbPageContext<?> mF;
    private String mForumName;
    protected boolean mIsFromCDN;
    protected View mRootView;
    private int mSkinType;

    protected abstract void L(bj bjVar);

    protected abstract void jm(int i);

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
        this.bKn = new CustomMessageListener(CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR) { // from class: com.baidu.tieba.frs.entelechy.view.i.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && i.this.ajF != null && i.this.ajF.getTid() != null && i.this.abe != null && ((String) customResponsedMessage.getData()).equals(i.this.ajF.getTid())) {
                    m.a(i.this.abe, i.this.ajF.getId(), d.e.cp_cont_b, d.e.cp_cont_d);
                }
            }
        };
        this.aow = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.i.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (i.this.XA() != null) {
                    i.this.XA().a(view, i.this.ajF);
                }
            }
        };
        this.aoe = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.i.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (i.this.XA() != null) {
                    i.this.XA().a(view, i.this.ajF);
                }
            }
        };
        setTag(bdUniqueId);
        this.mF = tbPageContext;
        initView();
    }

    public void initView() {
        this.mRootView = getView();
        this.cwx = (ClickableHeaderImageView) this.mRootView.findViewById(d.h.card_vote_header_image);
        this.cww = (HeadPendantClickableView) this.mRootView.findViewById(d.h.card_vote_pendant_header_image);
        this.aot = (ViewStub) this.mRootView.findViewById(d.h.viewstub_headimage_mask);
        this.cwx.setDefaultResource(17170445);
        this.cwx.setDefaultErrorResource(d.g.icon_default_avatar100);
        this.cwx.setDefaultBgResource(d.e.cp_bg_line_e);
        this.cwx.setRadius(com.baidu.adp.lib.util.k.g(this.mF.getPageActivity(), d.f.ds70));
        if (this.cww.getHeadView() != null) {
            this.cww.getHeadView().setDefaultResource(17170445);
            this.cww.getHeadView().setDefaultErrorResource(d.g.icon_default_avatar100);
            this.cww.getHeadView().setDefaultBgResource(d.e.cp_bg_line_e);
            this.cww.getHeadView().setRadius(com.baidu.adp.lib.util.k.g(this.mF.getPageActivity(), d.f.ds70));
            this.cww.getHeadView().setIsRound(true);
            this.cww.getHeadView().setDrawBorder(false);
        }
        this.cww.wB();
        if (this.cww.getPendantView() != null) {
            this.cww.getPendantView().setIsRound(true);
            this.cww.getPendantView().setDrawBorder(false);
        }
        this.bLo = (UserIconLayout) this.mRootView.findViewById(d.h.user_icon);
        this.bLo.apn = true;
        this.bLo.setEntelechyEnabled(true);
        this.bLo.setPageName(1);
        this.crf = (TbImageView) this.mRootView.findViewById(d.h.theme_card_view);
        this.crf.setPageId(getTag());
        this.abe = (TextView) this.mRootView.findViewById(d.h.vote_thread_title);
        this.cwy = (TextView) this.mRootView.findViewById(d.h.vote_total_option_num);
        this.cwz = (TextView) this.mRootView.findViewById(d.h.vote_now_state);
        this.bLl = (ThreadCommentAndPraiseInfoLayout) this.mRootView.findViewById(d.h.thread_more_info);
        this.bJs = this.mRootView.findViewById(d.h.divider_below_reply_number_layout);
        this.cwa = (RelativeLayout) this.mRootView.findViewById(d.h.card_home_page_normal_thread_root_content);
        this.bKa = (CardGroupDividerView) this.mRootView.findViewById(d.h.header_divider);
        this.bKa.setTitleClickListener(this);
        this.bLl.setViewNumEnabled(true);
        this.bLl.setFrom(2);
        this.cvV = new com.baidu.tieba.frs.h.g(this.mF, this.bLl);
        this.cvV.setUniqueId(getTag());
    }

    @Override // com.baidu.tieba.card.a
    public final void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.j(getView(), d.g.addresslist_item_bg);
            this.bLo.onChangeSkinType();
            this.bLl.onChangeSkinType();
            aj.c(this.cwy, d.e.cp_cont_c, 1);
            aj.c(this.cwz, d.e.cp_cont_d, 1);
            jm(i);
            if (this.bKa != null) {
                this.bKa.onChangeSkinType();
            }
            this.cvV.onChangeSkinType();
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
        this.ajF = bjVar;
        if (getView() != null) {
            getView().setVisibility(0);
        }
        if (this.ajF.getAuthor() == null || this.ajF.getAuthor().getPendantData() == null || StringUtils.isNull(this.ajF.getAuthor().getPendantData().pR())) {
            UserTbVipInfoData rB = this.ajF.rB();
            if (rB != null && rB.getvipV_url() != null) {
                if (this.aot != null) {
                    if (this.aou == null) {
                        this.aot.inflate();
                        this.aou = (TbImageView) getView().findViewById(d.h.user_head_mask);
                    }
                    this.aou.setPageId(getTag());
                    this.aou.setVisibility(0);
                    this.aou.c(rB.getvipV_url(), 10, false);
                    this.cwx.setIsBigV(true);
                }
            } else {
                this.cwx.setIsBigV(false);
                if (this.aou != null) {
                    this.aou.setVisibility(8);
                }
            }
            this.cww.setVisibility(8);
            this.cwx.setVisibility(0);
            this.cwx.setData(bjVar);
        } else {
            this.cwx.setIsBigV(false);
            if (this.aou != null) {
                this.aou.setVisibility(8);
            }
            this.cww.setVisibility(0);
            this.cwx.setVisibility(4);
            this.cww.setData(bjVar);
        }
        this.cwx.setAfterClickListener(this.aow);
        this.bLo.setVisibility(0);
        if (bjVar.getAuthor() != null && !StringUtils.isNull(bjVar.getAuthor().getSealPrefix())) {
            this.bLo.aP(true);
        }
        this.bLo.setData(bjVar);
        this.bLo.setUserAfterClickListener(this.aow);
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
            this.cwy.setVisibility(8);
            this.cwz.setVisibility(8);
        } else {
            String string = this.mF.getResources().getString(d.l.total_x_vote_option);
            this.cwy.setVisibility(0);
            this.cwy.setText(String.format(string, String.valueOf(bjVar.rp().options_count)));
            if (StringUtils.isNull(bjVar.rp().tips, true)) {
                this.cwz.setVisibility(8);
            } else {
                this.cwz.setVisibility(0);
                this.cwz.setText("(" + bjVar.rp().tips + ")");
            }
        }
        if (this.bLl.c(bjVar)) {
            this.bJs.setVisibility(8);
        } else {
            this.bJs.setVisibility(0);
        }
        this.bLl.setForumAfterClickListener(this.aoe);
        this.bLl.setStType(m.rs());
        L(bjVar);
        this.cvV.T(this.ajF);
        b.a(this.ajF, this.bKa);
        d(this.mF, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((view == this.mRootView || view == this.bLl.getCommentNumView() || view == this.bKa) && this.ajF != null) {
            if (this.ajF.rX() > 0 && com.baidu.tieba.tbadkCore.util.g.btm()) {
                PbActivityConfig createHistoryCfg = new PbActivityConfig(this.mF.getPageActivity()).createHistoryCfg(this.ajF.getTid(), String.valueOf(this.ajF.rX()), false, true, null);
                createHistoryCfg.setFromSmartFrs(this.ajF.sE());
                createHistoryCfg.setSmartFrsPosition(this.ajF.sL());
                createHistoryCfg.setForumId(String.valueOf(this.ajF.getFid()));
                createHistoryCfg.setStartFrom(1);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createHistoryCfg));
                return;
            }
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mF.getPageActivity()).createFromThreadCfg(this.ajF, this.mForumName, null, 18003, true, false, false);
            createFromThreadCfg.setFromSmartFrs(this.ajF.sE());
            createFromThreadCfg.setForumId(String.valueOf(this.ajF.getFid()));
            createFromThreadCfg.setStartFrom(1);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
        }
    }

    public void l(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.bLl != null && this.bKn != null) {
            this.bKn.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.bKn);
        }
    }

    @Override // com.baidu.tieba.card.v
    public void setForumName(String str) {
        this.mForumName = str;
    }
}
