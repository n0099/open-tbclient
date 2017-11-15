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
    protected bh ajq;
    public ViewStub anO;
    public TbImageView anP;
    private final View.OnClickListener anR;
    private final View.OnClickListener anz;
    private CardGroupDividerView bRL;
    public View bSd;
    private CustomMessageListener bSf;
    public ThreadCommentAndPraiseInfoLayout bTe;
    public UserIconLayout bTh;
    private com.baidu.tieba.frs.g.g cFB;
    public RelativeLayout cFI;
    public HeadPendantClickableView cGe;
    public ClickableHeaderImageView cGf;
    protected TextView cGg;
    protected TextView cGh;
    public TbImageView czY;
    private String mForumName;
    protected boolean mIsFromCDN;
    protected TbPageContext<?> mPageContext;
    protected View mRootView;
    private int mSkinType;
    protected TextView mTitleView;

    protected abstract void H(bh bhVar);

    protected abstract void jN(int i);

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
        this.bSf = new CustomMessageListener(CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR) { // from class: com.baidu.tieba.frs.entelechy.view.i.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && i.this.ajq != null && i.this.ajq.getTid() != null && i.this.mTitleView != null && ((String) customResponsedMessage.getData()).equals(i.this.ajq.getTid())) {
                    m.a(i.this.mTitleView, i.this.ajq.getId(), d.C0080d.cp_cont_b, d.C0080d.cp_cont_d);
                }
            }
        };
        this.anR = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.i.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (i.this.ZJ() != null) {
                    i.this.ZJ().a(view, i.this.ajq);
                }
            }
        };
        this.anz = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.i.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (i.this.ZJ() != null) {
                    i.this.ZJ().a(view, i.this.ajq);
                }
            }
        };
        setTag(bdUniqueId);
        this.mPageContext = tbPageContext;
        initView();
    }

    public void initView() {
        this.mRootView = getView();
        this.cGf = (ClickableHeaderImageView) this.mRootView.findViewById(d.g.card_vote_header_image);
        this.cGe = (HeadPendantClickableView) this.mRootView.findViewById(d.g.card_vote_pendant_header_image);
        this.anO = (ViewStub) this.mRootView.findViewById(d.g.viewstub_headimage_mask);
        this.cGf.setDefaultResource(17170445);
        this.cGf.setDefaultErrorResource(d.f.icon_default_avatar100);
        this.cGf.setDefaultBgResource(d.C0080d.cp_bg_line_e);
        this.cGf.setRadius(com.baidu.adp.lib.util.l.f(this.mPageContext.getPageActivity(), d.e.ds70));
        if (this.cGe.getHeadView() != null) {
            this.cGe.getHeadView().setDefaultResource(17170445);
            this.cGe.getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
            this.cGe.getHeadView().setDefaultBgResource(d.C0080d.cp_bg_line_e);
            this.cGe.getHeadView().setRadius(com.baidu.adp.lib.util.l.f(this.mPageContext.getPageActivity(), d.e.ds70));
            this.cGe.getHeadView().setIsRound(true);
            this.cGe.getHeadView().setDrawBorder(false);
        }
        this.cGe.wg();
        if (this.cGe.getPendantView() != null) {
            this.cGe.getPendantView().setIsRound(true);
            this.cGe.getPendantView().setDrawBorder(false);
        }
        this.bTh = (UserIconLayout) this.mRootView.findViewById(d.g.user_icon);
        this.bTh.aoF = true;
        this.bTh.setEntelechyEnabled(true);
        this.bTh.setPageName(1);
        this.czY = (TbImageView) this.mRootView.findViewById(d.g.theme_card_view);
        this.czY.setPageId(getTag());
        this.mTitleView = (TextView) this.mRootView.findViewById(d.g.vote_thread_title);
        this.cGg = (TextView) this.mRootView.findViewById(d.g.vote_total_option_num);
        this.cGh = (TextView) this.mRootView.findViewById(d.g.vote_now_state);
        this.bTe = (ThreadCommentAndPraiseInfoLayout) this.mRootView.findViewById(d.g.thread_more_info);
        this.bSd = this.mRootView.findViewById(d.g.divider_below_reply_number_layout);
        this.cFI = (RelativeLayout) this.mRootView.findViewById(d.g.card_home_page_normal_thread_root_content);
        this.bRL = (CardGroupDividerView) this.mRootView.findViewById(d.g.header_divider);
        this.bRL.setTitleClickListener(this);
        this.bTe.setViewNumEnabled(true);
        this.bTe.setFrom(2);
        this.cFB = new com.baidu.tieba.frs.g.g(this.mPageContext, this.bTe);
        this.cFB.setUniqueId(getTag());
    }

    @Override // com.baidu.tieba.card.a
    public final void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.j(getView(), d.f.addresslist_item_bg);
            this.bTh.onChangeSkinType();
            this.bTe.onChangeSkinType();
            aj.c(this.cGg, d.C0080d.cp_cont_c, 1);
            aj.c(this.cGh, d.C0080d.cp_cont_d, 1);
            jN(i);
            if (this.bRL != null) {
                this.bRL.onChangeSkinType();
            }
            this.cFB.onChangeSkinType();
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.card_vote_item;
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
        this.ajq = bhVar;
        if (getView() != null) {
            getView().setVisibility(0);
        }
        if (this.ajq.rt() == null || this.ajq.rt().getPendantData() == null || StringUtils.isNull(this.ajq.rt().getPendantData().pQ())) {
            UserTbVipInfoData ru = this.ajq.ru();
            if (ru != null && ru.getvipV_url() != null) {
                if (this.anO != null) {
                    if (this.anP == null) {
                        this.anO.inflate();
                        this.anP = (TbImageView) getView().findViewById(d.g.user_head_mask);
                    }
                    this.anP.setPageId(getTag());
                    this.anP.setVisibility(0);
                    this.anP.startLoad(ru.getvipV_url(), 10, false);
                    this.cGf.setIsBigV(true);
                }
            } else {
                this.cGf.setIsBigV(false);
                if (this.anP != null) {
                    this.anP.setVisibility(8);
                }
            }
            this.cGe.setVisibility(8);
            this.cGf.setVisibility(0);
            this.cGf.setData(bhVar);
        } else {
            this.cGf.setIsBigV(false);
            if (this.anP != null) {
                this.anP.setVisibility(8);
            }
            this.cGe.setVisibility(0);
            this.cGf.setVisibility(4);
            this.cGe.setData(bhVar);
        }
        this.cGf.setAfterClickListener(this.anR);
        this.bTh.setVisibility(0);
        if (bhVar.rt() != null && !StringUtils.isNull(bhVar.rt().getSealPrefix())) {
            this.bTh.aL(true);
        }
        this.bTh.setData(bhVar);
        this.bTh.setUserAfterClickListener(this.anR);
        ArrayList arrayList = new ArrayList();
        if (bhVar.rp() == 1) {
            arrayList.add(new m.a(d.j.good));
        }
        SpannableStringBuilder a = m.a((Context) TbadkCoreApplication.getInst(), bhVar.getTitle(), (ArrayList<m.a>) arrayList, false);
        a.append((CharSequence) bhVar.a(new SpannableString(bhVar.g(bhVar.getTitle(), false) + " ")));
        this.mTitleView.setLinkTextColor(getContext().getResources().getColor(d.C0080d.cp_link_tip_c));
        this.mTitleView.setOnTouchListener(new com.baidu.tieba.view.l(a));
        this.mTitleView.setText(a);
        m.a(this.mTitleView, bhVar.getId(), d.C0080d.cp_cont_b, d.C0080d.cp_cont_d);
        if (bhVar.rf() == null || bhVar.rf().options_count.intValue() == 0) {
            this.cGg.setVisibility(8);
            this.cGh.setVisibility(8);
        } else {
            String string = this.mPageContext.getResources().getString(d.j.total_x_vote_option);
            this.cGg.setVisibility(0);
            this.cGg.setText(String.format(string, String.valueOf(bhVar.rf().options_count)));
            if (StringUtils.isNull(bhVar.rf().tips, true)) {
                this.cGh.setVisibility(8);
            } else {
                this.cGh.setVisibility(0);
                this.cGh.setText("(" + bhVar.rf().tips + ")");
            }
        }
        if (this.bTe.setData(bhVar)) {
            this.bSd.setVisibility(8);
        } else {
            this.bSd.setVisibility(0);
        }
        this.bTe.setForumAfterClickListener(this.anz);
        this.bTe.setStType("frs_page");
        H(bhVar);
        this.cFB.Q(this.ajq);
        b.a(this.ajq, this.bRL);
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((view == this.mRootView || view == this.bTe.getCommentNumView() || view == this.bRL) && this.ajq != null) {
            if (this.ajq.rQ() > 0 && com.baidu.tieba.tbadkCore.util.f.bvE()) {
                PbActivityConfig createHistoryCfg = new PbActivityConfig(this.mPageContext.getPageActivity()).createHistoryCfg(this.ajq.getTid(), String.valueOf(this.ajq.rQ()), false, true, "frs_page");
                createHistoryCfg.setFromSmartFrs(this.ajq.sy());
                createHistoryCfg.setSmartFrsPosition(this.ajq.sF());
                createHistoryCfg.setForumId(String.valueOf(this.ajq.getFid()));
                createHistoryCfg.setStartFrom(1);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createHistoryCfg));
                return;
            }
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(this.ajq, this.mForumName, "frs_page", 18003, true, false, false);
            createFromThreadCfg.setFromSmartFrs(this.ajq.sy());
            createFromThreadCfg.setForumId(String.valueOf(this.ajq.getFid()));
            createFromThreadCfg.setStartFrom(1);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
        }
    }

    public void k(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.bTe != null && this.bSf != null) {
            this.bSf.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.bSf);
        }
    }

    @Override // com.baidu.tieba.card.v
    public void setForumName(String str) {
        this.mForumName = str;
    }
}
