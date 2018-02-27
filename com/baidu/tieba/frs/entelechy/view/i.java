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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.UserIconLayout;
import com.baidu.tbadk.data.UserTbVipInfoData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.divider.CardGroupDividerView;
import com.baidu.tieba.card.j;
import com.baidu.tieba.card.t;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public abstract class i extends com.baidu.tieba.card.a<bd> implements t {
    protected bd aZA;
    private final View.OnClickListener bdE;
    public ViewStub bdN;
    public TbImageView bdO;
    private final View.OnClickListener bdQ;
    public View cWf;
    private CustomMessageListener cWh;
    private CardGroupDividerView cXk;
    public TbImageView cYK;
    public ThreadCommentAndPraiseInfoLayout dLH;
    public UserIconLayout dLI;
    public RelativeLayout dLJ;
    private com.baidu.tieba.frs.g.g dLx;
    public HeadPendantClickableView dMg;
    public ClickableHeaderImageView dMh;
    protected TextView dMi;
    protected TextView dMj;
    private String mForumName;
    protected boolean mIsFromCDN;
    protected TbPageContext<?> mPageContext;
    protected View mRootView;
    private int mSkinType;
    protected TextView mTitleView;

    protected abstract void S(bd bdVar);

    protected abstract void nm(int i);

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
        this.cWh = new CustomMessageListener(2001390) { // from class: com.baidu.tieba.frs.entelechy.view.i.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && i.this.aZA != null && i.this.aZA.getTid() != null && i.this.mTitleView != null && ((String) customResponsedMessage.getData()).equals(i.this.aZA.getTid())) {
                    com.baidu.tieba.card.j.a(i.this.mTitleView, i.this.aZA.getId(), d.C0141d.cp_cont_b, d.C0141d.cp_cont_d);
                }
            }
        };
        this.bdQ = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.i.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (i.this.akO() != null) {
                    i.this.akO().a(view, i.this.aZA);
                }
            }
        };
        this.bdE = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.i.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (i.this.akO() != null) {
                    i.this.akO().a(view, i.this.aZA);
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
        this.dMh = (ClickableHeaderImageView) this.mRootView.findViewById(d.g.card_vote_header_image);
        this.dMg = (HeadPendantClickableView) this.mRootView.findViewById(d.g.card_vote_pendant_header_image);
        this.bdN = (ViewStub) this.mRootView.findViewById(d.g.viewstub_headimage_mask);
        this.dMh.setDefaultResource(17170445);
        this.dMh.setDefaultErrorResource(d.f.icon_default_avatar100);
        this.dMh.setDefaultBgResource(d.C0141d.cp_bg_line_e);
        this.dMh.setRadius(com.baidu.adp.lib.util.l.t(this.mPageContext.getPageActivity(), d.e.ds70));
        if (this.dMg.getHeadView() != null) {
            this.dMg.getHeadView().setDefaultResource(17170445);
            this.dMg.getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
            this.dMg.getHeadView().setDefaultBgResource(d.C0141d.cp_bg_line_e);
            this.dMg.getHeadView().setRadius(com.baidu.adp.lib.util.l.t(this.mPageContext.getPageActivity(), d.e.ds70));
            this.dMg.getHeadView().setIsRound(true);
            this.dMg.getHeadView().setDrawBorder(false);
        }
        this.dMg.DS();
        if (this.dMg.getPendantView() != null) {
            this.dMg.getPendantView().setIsRound(true);
            this.dMg.getPendantView().setDrawBorder(false);
        }
        this.dLI = (UserIconLayout) this.mRootView.findViewById(d.g.user_icon);
        this.dLI.beW = true;
        this.dLI.setEntelechyEnabled(true);
        this.dLI.setPageName(1);
        this.cYK = (TbImageView) this.mRootView.findViewById(d.g.theme_card_view);
        this.cYK.setPageId(getTag());
        this.mTitleView = (TextView) this.mRootView.findViewById(d.g.vote_thread_title);
        this.dMi = (TextView) this.mRootView.findViewById(d.g.vote_total_option_num);
        this.dMj = (TextView) this.mRootView.findViewById(d.g.vote_now_state);
        this.dLH = (ThreadCommentAndPraiseInfoLayout) this.mRootView.findViewById(d.g.thread_more_info);
        this.cWf = this.mRootView.findViewById(d.g.divider_below_reply_number_layout);
        this.dLJ = (RelativeLayout) this.mRootView.findViewById(d.g.card_home_page_normal_thread_root_content);
        this.cXk = (CardGroupDividerView) this.mRootView.findViewById(d.g.header_divider);
        this.cXk.setTitleClickListener(this);
        this.dLH.setFrom(2);
        this.dLH.aQt = 3;
        this.dLx = new com.baidu.tieba.frs.g.g(this.mPageContext, this.dLJ);
        this.dLx.setUniqueId(getTag());
    }

    @Override // com.baidu.tieba.card.a
    public final void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.s(getView(), d.f.addresslist_item_bg);
            this.dLI.onChangeSkinType();
            this.dLH.onChangeSkinType();
            aj.e(this.dMi, d.C0141d.cp_cont_c, 1);
            aj.e(this.dMj, d.C0141d.cp_cont_d, 1);
            nm(i);
            if (this.cXk != null) {
                this.cXk.onChangeSkinType();
            }
            this.dLx.onChangeSkinType();
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
        this.aZA = bdVar;
        if (getView() != null) {
            getView().setVisibility(0);
        }
        if (this.aZA.zn() == null || this.aZA.zn().getPendantData() == null || StringUtils.isNull(this.aZA.zn().getPendantData().ya())) {
            UserTbVipInfoData zo = this.aZA.zo();
            if (zo != null && zo.getvipV_url() != null) {
                if (this.bdN != null) {
                    if (this.bdO == null) {
                        this.bdN.inflate();
                        this.bdO = (TbImageView) getView().findViewById(d.g.user_head_mask);
                    }
                    this.bdO.setPageId(getTag());
                    this.bdO.setVisibility(0);
                    this.bdO.startLoad(zo.getvipV_url(), 10, false);
                    this.dMh.setIsBigV(true);
                }
            } else {
                this.dMh.setIsBigV(false);
                if (this.bdO != null) {
                    this.bdO.setVisibility(8);
                }
            }
            this.dMg.setVisibility(8);
            this.dMh.setVisibility(0);
            this.dMh.setData(bdVar);
        } else {
            this.dMh.setIsBigV(false);
            if (this.bdO != null) {
                this.bdO.setVisibility(8);
            }
            this.dMg.setVisibility(0);
            this.dMh.setVisibility(4);
            this.dMg.setData(bdVar);
        }
        this.dMh.setAfterClickListener(this.bdQ);
        this.dLI.setVisibility(0);
        if (bdVar.zn() != null && !StringUtils.isNull(bdVar.zn().getSealPrefix())) {
            this.dLI.by(true);
        }
        this.dLI.setData(bdVar);
        this.dLI.setUserAfterClickListener(this.bdQ);
        ArrayList arrayList = new ArrayList();
        if (bdVar.zj() == 1) {
            arrayList.add(new j.a(d.j.good));
        }
        SpannableStringBuilder a = com.baidu.tieba.card.j.a((Context) TbadkCoreApplication.getInst(), bdVar.getTitle(), (ArrayList<j.a>) arrayList, false);
        a.append((CharSequence) bdVar.a(new SpannableString(bdVar.f(bdVar.getTitle(), false) + " ")));
        this.mTitleView.setLinkTextColor(getContext().getResources().getColor(d.C0141d.cp_link_tip_c));
        this.mTitleView.setOnTouchListener(new com.baidu.tieba.view.m(a));
        this.mTitleView.setText(a);
        com.baidu.tieba.card.j.a(this.mTitleView, bdVar.getId(), d.C0141d.cp_cont_b, d.C0141d.cp_cont_d);
        if (bdVar.yZ() == null || bdVar.yZ().options_count.intValue() == 0) {
            this.dMi.setVisibility(8);
            this.dMj.setVisibility(8);
        } else {
            String string = this.mPageContext.getResources().getString(d.j.total_x_vote_option);
            this.dMi.setVisibility(0);
            this.dMi.setText(String.format(string, String.valueOf(bdVar.yZ().options_count)));
            if (StringUtils.isNull(bdVar.yZ().tips, true)) {
                this.dMj.setVisibility(8);
            } else {
                this.dMj.setVisibility(0);
                this.dMj.setText("(" + bdVar.yZ().tips + ")");
            }
        }
        if (this.dLH.setData(bdVar)) {
            this.cWf.setVisibility(8);
        } else {
            this.cWf.setVisibility(0);
        }
        this.dLH.setForumAfterClickListener(this.bdE);
        this.dLH.setStType("frs_page");
        S(bdVar);
        this.dLx.W(this.aZA);
        b.a(this.aZA, this.cXk);
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((view == this.mRootView || view == this.dLH.getCommentNumView() || view == this.cXk) && this.aZA != null) {
            if (this.aZA.zK() > 0 && com.baidu.tieba.tbadkCore.util.f.bxS()) {
                PbActivityConfig createHistoryCfg = new PbActivityConfig(this.mPageContext.getPageActivity()).createHistoryCfg(this.aZA.getTid(), String.valueOf(this.aZA.zK()), false, true, "frs_page");
                createHistoryCfg.setFromSmartFrs(this.aZA.An());
                createHistoryCfg.setSmartFrsPosition(this.aZA.Au());
                createHistoryCfg.setForumId(String.valueOf(this.aZA.getFid()));
                createHistoryCfg.setStartFrom(this.currentPageType);
                MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createHistoryCfg));
                return;
            }
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(this.aZA, this.mForumName, "frs_page", 18003, true, false, false);
            createFromThreadCfg.setFromSmartFrs(this.aZA.An());
            createFromThreadCfg.setForumId(String.valueOf(this.aZA.getFid()));
            createFromThreadCfg.setStartFrom(this.currentPageType);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createFromThreadCfg));
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.dLH != null && this.cWh != null) {
            this.cWh.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.cWh);
        }
    }

    @Override // com.baidu.tieba.card.t
    public void setForumName(String str) {
        this.mForumName = str;
    }
}
