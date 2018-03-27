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
    protected bd aZC;
    private final View.OnClickListener bdG;
    public ViewStub bdQ;
    public TbImageView bdR;
    private final View.OnClickListener bdT;
    public View cWi;
    private CustomMessageListener cWk;
    private CardGroupDividerView cXn;
    public TbImageView cYN;
    private com.baidu.tieba.frs.g.g dLC;
    public ThreadCommentAndPraiseInfoLayout dLM;
    public UserIconLayout dLN;
    public RelativeLayout dLO;
    public HeadPendantClickableView dMl;
    public ClickableHeaderImageView dMm;
    protected TextView dMn;
    protected TextView dMo;
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
        this.cWk = new CustomMessageListener(2001390) { // from class: com.baidu.tieba.frs.entelechy.view.i.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && i.this.aZC != null && i.this.aZC.getTid() != null && i.this.mTitleView != null && ((String) customResponsedMessage.getData()).equals(i.this.aZC.getTid())) {
                    com.baidu.tieba.card.j.a(i.this.mTitleView, i.this.aZC.getId(), d.C0141d.cp_cont_b, d.C0141d.cp_cont_d);
                }
            }
        };
        this.bdT = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.i.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (i.this.akP() != null) {
                    i.this.akP().a(view, i.this.aZC);
                }
            }
        };
        this.bdG = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.i.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (i.this.akP() != null) {
                    i.this.akP().a(view, i.this.aZC);
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
        this.dMm = (ClickableHeaderImageView) this.mRootView.findViewById(d.g.card_vote_header_image);
        this.dMl = (HeadPendantClickableView) this.mRootView.findViewById(d.g.card_vote_pendant_header_image);
        this.bdQ = (ViewStub) this.mRootView.findViewById(d.g.viewstub_headimage_mask);
        this.dMm.setDefaultResource(17170445);
        this.dMm.setDefaultErrorResource(d.f.icon_default_avatar100);
        this.dMm.setDefaultBgResource(d.C0141d.cp_bg_line_e);
        this.dMm.setRadius(com.baidu.adp.lib.util.l.t(this.mPageContext.getPageActivity(), d.e.ds70));
        if (this.dMl.getHeadView() != null) {
            this.dMl.getHeadView().setDefaultResource(17170445);
            this.dMl.getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
            this.dMl.getHeadView().setDefaultBgResource(d.C0141d.cp_bg_line_e);
            this.dMl.getHeadView().setRadius(com.baidu.adp.lib.util.l.t(this.mPageContext.getPageActivity(), d.e.ds70));
            this.dMl.getHeadView().setIsRound(true);
            this.dMl.getHeadView().setDrawBorder(false);
        }
        this.dMl.DT();
        if (this.dMl.getPendantView() != null) {
            this.dMl.getPendantView().setIsRound(true);
            this.dMl.getPendantView().setDrawBorder(false);
        }
        this.dLN = (UserIconLayout) this.mRootView.findViewById(d.g.user_icon);
        this.dLN.beZ = true;
        this.dLN.setEntelechyEnabled(true);
        this.dLN.setPageName(1);
        this.cYN = (TbImageView) this.mRootView.findViewById(d.g.theme_card_view);
        this.cYN.setPageId(getTag());
        this.mTitleView = (TextView) this.mRootView.findViewById(d.g.vote_thread_title);
        this.dMn = (TextView) this.mRootView.findViewById(d.g.vote_total_option_num);
        this.dMo = (TextView) this.mRootView.findViewById(d.g.vote_now_state);
        this.dLM = (ThreadCommentAndPraiseInfoLayout) this.mRootView.findViewById(d.g.thread_more_info);
        this.cWi = this.mRootView.findViewById(d.g.divider_below_reply_number_layout);
        this.dLO = (RelativeLayout) this.mRootView.findViewById(d.g.card_home_page_normal_thread_root_content);
        this.cXn = (CardGroupDividerView) this.mRootView.findViewById(d.g.header_divider);
        this.cXn.setTitleClickListener(this);
        this.dLM.setFrom(2);
        this.dLM.aQv = 3;
        this.dLC = new com.baidu.tieba.frs.g.g(this.mPageContext, this.dLO);
        this.dLC.setUniqueId(getTag());
    }

    @Override // com.baidu.tieba.card.a
    public final void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.s(getView(), d.f.addresslist_item_bg);
            this.dLN.onChangeSkinType();
            this.dLM.onChangeSkinType();
            aj.e(this.dMn, d.C0141d.cp_cont_c, 1);
            aj.e(this.dMo, d.C0141d.cp_cont_d, 1);
            nm(i);
            if (this.cXn != null) {
                this.cXn.onChangeSkinType();
            }
            this.dLC.onChangeSkinType();
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
        this.aZC = bdVar;
        if (getView() != null) {
            getView().setVisibility(0);
        }
        if (this.aZC.zn() == null || this.aZC.zn().getPendantData() == null || StringUtils.isNull(this.aZC.zn().getPendantData().ya())) {
            UserTbVipInfoData zo = this.aZC.zo();
            if (zo != null && zo.getvipV_url() != null) {
                if (this.bdQ != null) {
                    if (this.bdR == null) {
                        this.bdQ.inflate();
                        this.bdR = (TbImageView) getView().findViewById(d.g.user_head_mask);
                    }
                    this.bdR.setPageId(getTag());
                    this.bdR.setVisibility(0);
                    this.bdR.startLoad(zo.getvipV_url(), 10, false);
                    this.dMm.setIsBigV(true);
                }
            } else {
                this.dMm.setIsBigV(false);
                if (this.bdR != null) {
                    this.bdR.setVisibility(8);
                }
            }
            this.dMl.setVisibility(8);
            this.dMm.setVisibility(0);
            this.dMm.setData(bdVar);
        } else {
            this.dMm.setIsBigV(false);
            if (this.bdR != null) {
                this.bdR.setVisibility(8);
            }
            this.dMl.setVisibility(0);
            this.dMm.setVisibility(4);
            this.dMl.setData(bdVar);
        }
        this.dMm.setAfterClickListener(this.bdT);
        this.dLN.setVisibility(0);
        if (bdVar.zn() != null && !StringUtils.isNull(bdVar.zn().getSealPrefix())) {
            this.dLN.by(true);
        }
        this.dLN.setData(bdVar);
        this.dLN.setUserAfterClickListener(this.bdT);
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
            this.dMn.setVisibility(8);
            this.dMo.setVisibility(8);
        } else {
            String string = this.mPageContext.getResources().getString(d.j.total_x_vote_option);
            this.dMn.setVisibility(0);
            this.dMn.setText(String.format(string, String.valueOf(bdVar.yZ().options_count)));
            if (StringUtils.isNull(bdVar.yZ().tips, true)) {
                this.dMo.setVisibility(8);
            } else {
                this.dMo.setVisibility(0);
                this.dMo.setText("(" + bdVar.yZ().tips + ")");
            }
        }
        if (this.dLM.setData(bdVar)) {
            this.cWi.setVisibility(8);
        } else {
            this.cWi.setVisibility(0);
        }
        this.dLM.setForumAfterClickListener(this.bdG);
        this.dLM.setStType("frs_page");
        S(bdVar);
        this.dLC.W(this.aZC);
        b.a(this.aZC, this.cXn);
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((view == this.mRootView || view == this.dLM.getCommentNumView() || view == this.cXn) && this.aZC != null) {
            if (this.aZC.zK() > 0 && com.baidu.tieba.tbadkCore.util.f.bxX()) {
                PbActivityConfig createHistoryCfg = new PbActivityConfig(this.mPageContext.getPageActivity()).createHistoryCfg(this.aZC.getTid(), String.valueOf(this.aZC.zK()), false, true, "frs_page");
                createHistoryCfg.setFromSmartFrs(this.aZC.An());
                createHistoryCfg.setSmartFrsPosition(this.aZC.Au());
                createHistoryCfg.setForumId(String.valueOf(this.aZC.getFid()));
                createHistoryCfg.setStartFrom(this.currentPageType);
                MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createHistoryCfg));
                return;
            }
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(this.aZC, this.mForumName, "frs_page", 18003, true, false, false);
            createFromThreadCfg.setFromSmartFrs(this.aZC.An());
            createFromThreadCfg.setForumId(String.valueOf(this.aZC.getFid()));
            createFromThreadCfg.setStartFrom(this.currentPageType);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createFromThreadCfg));
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.dLM != null && this.cWk != null) {
            this.cWk.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.cWk);
        }
    }

    @Override // com.baidu.tieba.card.t
    public void setForumName(String str) {
        this.mForumName = str;
    }
}
