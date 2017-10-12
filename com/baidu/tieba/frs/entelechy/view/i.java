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
    protected TextView abf;
    protected bh ajg;
    public ViewStub anG;
    public TbImageView anH;
    private final View.OnClickListener anJ;
    private final View.OnClickListener anr;
    private CardGroupDividerView bKe;
    public View bKw;
    private CustomMessageListener bKy;
    public UserIconLayout bLC;
    public ThreadCommentAndPraiseInfoLayout bLz;
    public TbImageView csu;
    private com.baidu.tieba.frs.h.g cxD;
    public RelativeLayout cxI;
    public HeadPendantClickableView cye;
    public ClickableHeaderImageView cyf;
    protected TextView cyg;
    protected TextView cyh;
    private String mForumName;
    protected TbPageContext<?> mG;
    protected boolean mIsFromCDN;
    protected View mRootView;
    private int mSkinType;

    protected abstract void G(bh bhVar);

    protected abstract void jx(int i);

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
        this.bKy = new CustomMessageListener(CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR) { // from class: com.baidu.tieba.frs.entelechy.view.i.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && i.this.ajg != null && i.this.ajg.getTid() != null && i.this.abf != null && ((String) customResponsedMessage.getData()).equals(i.this.ajg.getTid())) {
                    m.a(i.this.abf, i.this.ajg.getId(), d.e.cp_cont_b, d.e.cp_cont_d);
                }
            }
        };
        this.anJ = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.i.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (i.this.Xr() != null) {
                    i.this.Xr().a(view, i.this.ajg);
                }
            }
        };
        this.anr = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.i.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (i.this.Xr() != null) {
                    i.this.Xr().a(view, i.this.ajg);
                }
            }
        };
        setTag(bdUniqueId);
        this.mG = tbPageContext;
        initView();
    }

    public void initView() {
        this.mRootView = getView();
        this.cyf = (ClickableHeaderImageView) this.mRootView.findViewById(d.h.card_vote_header_image);
        this.cye = (HeadPendantClickableView) this.mRootView.findViewById(d.h.card_vote_pendant_header_image);
        this.anG = (ViewStub) this.mRootView.findViewById(d.h.viewstub_headimage_mask);
        this.cyf.setDefaultResource(17170445);
        this.cyf.setDefaultErrorResource(d.g.icon_default_avatar100);
        this.cyf.setDefaultBgResource(d.e.cp_bg_line_e);
        this.cyf.setRadius(com.baidu.adp.lib.util.l.f(this.mG.getPageActivity(), d.f.ds70));
        if (this.cye.getHeadView() != null) {
            this.cye.getHeadView().setDefaultResource(17170445);
            this.cye.getHeadView().setDefaultErrorResource(d.g.icon_default_avatar100);
            this.cye.getHeadView().setDefaultBgResource(d.e.cp_bg_line_e);
            this.cye.getHeadView().setRadius(com.baidu.adp.lib.util.l.f(this.mG.getPageActivity(), d.f.ds70));
            this.cye.getHeadView().setIsRound(true);
            this.cye.getHeadView().setDrawBorder(false);
        }
        this.cye.wg();
        if (this.cye.getPendantView() != null) {
            this.cye.getPendantView().setIsRound(true);
            this.cye.getPendantView().setDrawBorder(false);
        }
        this.bLC = (UserIconLayout) this.mRootView.findViewById(d.h.user_icon);
        this.bLC.aow = true;
        this.bLC.setEntelechyEnabled(true);
        this.bLC.setPageName(1);
        this.csu = (TbImageView) this.mRootView.findViewById(d.h.theme_card_view);
        this.csu.setPageId(getTag());
        this.abf = (TextView) this.mRootView.findViewById(d.h.vote_thread_title);
        this.cyg = (TextView) this.mRootView.findViewById(d.h.vote_total_option_num);
        this.cyh = (TextView) this.mRootView.findViewById(d.h.vote_now_state);
        this.bLz = (ThreadCommentAndPraiseInfoLayout) this.mRootView.findViewById(d.h.thread_more_info);
        this.bKw = this.mRootView.findViewById(d.h.divider_below_reply_number_layout);
        this.cxI = (RelativeLayout) this.mRootView.findViewById(d.h.card_home_page_normal_thread_root_content);
        this.bKe = (CardGroupDividerView) this.mRootView.findViewById(d.h.header_divider);
        this.bKe.setTitleClickListener(this);
        this.bLz.setViewNumEnabled(true);
        this.bLz.setFrom(2);
        this.cxD = new com.baidu.tieba.frs.h.g(this.mG, this.bLz);
        this.cxD.setUniqueId(getTag());
    }

    @Override // com.baidu.tieba.card.a
    public final void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.j(getView(), d.g.addresslist_item_bg);
            this.bLC.onChangeSkinType();
            this.bLz.onChangeSkinType();
            aj.c(this.cyg, d.e.cp_cont_c, 1);
            aj.c(this.cyh, d.e.cp_cont_d, 1);
            jx(i);
            if (this.bKe != null) {
                this.bKe.onChangeSkinType();
            }
            this.cxD.onChangeSkinType();
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
        this.ajg = bhVar;
        if (getView() != null) {
            getView().setVisibility(0);
        }
        if (this.ajg.getAuthor() == null || this.ajg.getAuthor().getPendantData() == null || StringUtils.isNull(this.ajg.getAuthor().getPendantData().pS())) {
            UserTbVipInfoData rv = this.ajg.rv();
            if (rv != null && rv.getvipV_url() != null) {
                if (this.anG != null) {
                    if (this.anH == null) {
                        this.anG.inflate();
                        this.anH = (TbImageView) getView().findViewById(d.h.user_head_mask);
                    }
                    this.anH.setPageId(getTag());
                    this.anH.setVisibility(0);
                    this.anH.c(rv.getvipV_url(), 10, false);
                    this.cyf.setIsBigV(true);
                }
            } else {
                this.cyf.setIsBigV(false);
                if (this.anH != null) {
                    this.anH.setVisibility(8);
                }
            }
            this.cye.setVisibility(8);
            this.cyf.setVisibility(0);
            this.cyf.setData(bhVar);
        } else {
            this.cyf.setIsBigV(false);
            if (this.anH != null) {
                this.anH.setVisibility(8);
            }
            this.cye.setVisibility(0);
            this.cyf.setVisibility(4);
            this.cye.setData(bhVar);
        }
        this.cyf.setAfterClickListener(this.anJ);
        this.bLC.setVisibility(0);
        if (bhVar.getAuthor() != null && !StringUtils.isNull(bhVar.getAuthor().getSealPrefix())) {
            this.bLC.aO(true);
        }
        this.bLC.setData(bhVar);
        this.bLC.setUserAfterClickListener(this.anJ);
        ArrayList arrayList = new ArrayList();
        if (bhVar.rr() == 1) {
            arrayList.add(new m.a(d.l.good));
        }
        SpannableStringBuilder a = m.a((Context) TbadkCoreApplication.getInst(), bhVar.getTitle(), (ArrayList<m.a>) arrayList, false);
        a.append((CharSequence) bhVar.a(new SpannableString(bhVar.g(bhVar.getTitle(), false) + " ")));
        this.abf.setLinkTextColor(getContext().getResources().getColor(d.e.cp_link_tip_c));
        this.abf.setOnTouchListener(new com.baidu.tieba.view.k(a));
        this.abf.setText(a);
        m.a(this.abf, bhVar.getId(), d.e.cp_cont_b, d.e.cp_cont_d);
        if (bhVar.rj() == null || bhVar.rj().options_count.intValue() == 0) {
            this.cyg.setVisibility(8);
            this.cyh.setVisibility(8);
        } else {
            String string = this.mG.getResources().getString(d.l.total_x_vote_option);
            this.cyg.setVisibility(0);
            this.cyg.setText(String.format(string, String.valueOf(bhVar.rj().options_count)));
            if (StringUtils.isNull(bhVar.rj().tips, true)) {
                this.cyh.setVisibility(8);
            } else {
                this.cyh.setVisibility(0);
                this.cyh.setText("(" + bhVar.rj().tips + ")");
            }
        }
        if (this.bLz.setData(bhVar)) {
            this.bKw.setVisibility(8);
        } else {
            this.bKw.setVisibility(0);
        }
        this.bLz.setForumAfterClickListener(this.anr);
        this.bLz.setStType(m.rm());
        G(bhVar);
        this.cxD.O(this.ajg);
        b.a(this.ajg, this.bKe);
        d(this.mG, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((view == this.mRootView || view == this.bLz.getCommentNumView() || view == this.bKe) && this.ajg != null) {
            if (this.ajg.rR() > 0 && com.baidu.tieba.tbadkCore.util.f.bsv()) {
                PbActivityConfig createHistoryCfg = new PbActivityConfig(this.mG.getPageActivity()).createHistoryCfg(this.ajg.getTid(), String.valueOf(this.ajg.rR()), false, true, null);
                createHistoryCfg.setFromSmartFrs(this.ajg.sy());
                createHistoryCfg.setSmartFrsPosition(this.ajg.sF());
                createHistoryCfg.setForumId(String.valueOf(this.ajg.getFid()));
                createHistoryCfg.setStartFrom(1);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createHistoryCfg));
                return;
            }
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mG.getPageActivity()).createFromThreadCfg(this.ajg, this.mForumName, null, 18003, true, false, false);
            createFromThreadCfg.setFromSmartFrs(this.ajg.sy());
            createFromThreadCfg.setForumId(String.valueOf(this.ajg.getFid()));
            createFromThreadCfg.setStartFrom(1);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
        }
    }

    public void k(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.bLz != null && this.bKy != null) {
            this.bKy.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.bKy);
        }
    }

    @Override // com.baidu.tieba.card.v
    public void setForumName(String str) {
        this.mForumName = str;
    }
}
