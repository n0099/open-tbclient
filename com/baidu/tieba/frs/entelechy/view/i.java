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
    protected bd aZM;
    private final View.OnClickListener bdQ;
    public ViewStub bdZ;
    public TbImageView bea;
    private final View.OnClickListener bec;
    public View cWr;
    private CustomMessageListener cWt;
    private CardGroupDividerView cXw;
    public TbImageView cYW;
    private com.baidu.tieba.frs.g.g dLJ;
    public ThreadCommentAndPraiseInfoLayout dLT;
    public UserIconLayout dLU;
    public RelativeLayout dLV;
    public HeadPendantClickableView dMs;
    public ClickableHeaderImageView dMt;
    protected TextView dMu;
    protected TextView dMv;
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
        this.cWt = new CustomMessageListener(2001390) { // from class: com.baidu.tieba.frs.entelechy.view.i.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && i.this.aZM != null && i.this.aZM.getTid() != null && i.this.mTitleView != null && ((String) customResponsedMessage.getData()).equals(i.this.aZM.getTid())) {
                    com.baidu.tieba.card.j.a(i.this.mTitleView, i.this.aZM.getId(), d.C0140d.cp_cont_b, d.C0140d.cp_cont_d);
                }
            }
        };
        this.bec = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.i.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (i.this.akP() != null) {
                    i.this.akP().a(view, i.this.aZM);
                }
            }
        };
        this.bdQ = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.i.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (i.this.akP() != null) {
                    i.this.akP().a(view, i.this.aZM);
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
        this.dMt = (ClickableHeaderImageView) this.mRootView.findViewById(d.g.card_vote_header_image);
        this.dMs = (HeadPendantClickableView) this.mRootView.findViewById(d.g.card_vote_pendant_header_image);
        this.bdZ = (ViewStub) this.mRootView.findViewById(d.g.viewstub_headimage_mask);
        this.dMt.setDefaultResource(17170445);
        this.dMt.setDefaultErrorResource(d.f.icon_default_avatar100);
        this.dMt.setDefaultBgResource(d.C0140d.cp_bg_line_e);
        this.dMt.setRadius(com.baidu.adp.lib.util.l.t(this.mPageContext.getPageActivity(), d.e.ds70));
        if (this.dMs.getHeadView() != null) {
            this.dMs.getHeadView().setDefaultResource(17170445);
            this.dMs.getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
            this.dMs.getHeadView().setDefaultBgResource(d.C0140d.cp_bg_line_e);
            this.dMs.getHeadView().setRadius(com.baidu.adp.lib.util.l.t(this.mPageContext.getPageActivity(), d.e.ds70));
            this.dMs.getHeadView().setIsRound(true);
            this.dMs.getHeadView().setDrawBorder(false);
        }
        this.dMs.DT();
        if (this.dMs.getPendantView() != null) {
            this.dMs.getPendantView().setIsRound(true);
            this.dMs.getPendantView().setDrawBorder(false);
        }
        this.dLU = (UserIconLayout) this.mRootView.findViewById(d.g.user_icon);
        this.dLU.bfj = true;
        this.dLU.setEntelechyEnabled(true);
        this.dLU.setPageName(1);
        this.cYW = (TbImageView) this.mRootView.findViewById(d.g.theme_card_view);
        this.cYW.setPageId(getTag());
        this.mTitleView = (TextView) this.mRootView.findViewById(d.g.vote_thread_title);
        this.dMu = (TextView) this.mRootView.findViewById(d.g.vote_total_option_num);
        this.dMv = (TextView) this.mRootView.findViewById(d.g.vote_now_state);
        this.dLT = (ThreadCommentAndPraiseInfoLayout) this.mRootView.findViewById(d.g.thread_more_info);
        this.cWr = this.mRootView.findViewById(d.g.divider_below_reply_number_layout);
        this.dLV = (RelativeLayout) this.mRootView.findViewById(d.g.card_home_page_normal_thread_root_content);
        this.cXw = (CardGroupDividerView) this.mRootView.findViewById(d.g.header_divider);
        this.cXw.setTitleClickListener(this);
        this.dLT.setFrom(2);
        this.dLT.aQE = 3;
        this.dLJ = new com.baidu.tieba.frs.g.g(this.mPageContext, this.dLV);
        this.dLJ.setUniqueId(getTag());
    }

    @Override // com.baidu.tieba.card.a
    public final void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.s(getView(), d.f.addresslist_item_bg);
            this.dLU.onChangeSkinType();
            this.dLT.onChangeSkinType();
            aj.e(this.dMu, d.C0140d.cp_cont_c, 1);
            aj.e(this.dMv, d.C0140d.cp_cont_d, 1);
            nm(i);
            if (this.cXw != null) {
                this.cXw.onChangeSkinType();
            }
            this.dLJ.onChangeSkinType();
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
        this.aZM = bdVar;
        if (getView() != null) {
            getView().setVisibility(0);
        }
        if (this.aZM.zn() == null || this.aZM.zn().getPendantData() == null || StringUtils.isNull(this.aZM.zn().getPendantData().ya())) {
            UserTbVipInfoData zo = this.aZM.zo();
            if (zo != null && zo.getvipV_url() != null) {
                if (this.bdZ != null) {
                    if (this.bea == null) {
                        this.bdZ.inflate();
                        this.bea = (TbImageView) getView().findViewById(d.g.user_head_mask);
                    }
                    this.bea.setPageId(getTag());
                    this.bea.setVisibility(0);
                    this.bea.startLoad(zo.getvipV_url(), 10, false);
                    this.dMt.setIsBigV(true);
                }
            } else {
                this.dMt.setIsBigV(false);
                if (this.bea != null) {
                    this.bea.setVisibility(8);
                }
            }
            this.dMs.setVisibility(8);
            this.dMt.setVisibility(0);
            this.dMt.setData(bdVar);
        } else {
            this.dMt.setIsBigV(false);
            if (this.bea != null) {
                this.bea.setVisibility(8);
            }
            this.dMs.setVisibility(0);
            this.dMt.setVisibility(4);
            this.dMs.setData(bdVar);
        }
        this.dMt.setAfterClickListener(this.bec);
        this.dLU.setVisibility(0);
        if (bdVar.zn() != null && !StringUtils.isNull(bdVar.zn().getSealPrefix())) {
            this.dLU.by(true);
        }
        this.dLU.setData(bdVar);
        this.dLU.setUserAfterClickListener(this.bec);
        ArrayList arrayList = new ArrayList();
        if (bdVar.zj() == 1) {
            arrayList.add(new j.a(d.j.good));
        }
        SpannableStringBuilder a = com.baidu.tieba.card.j.a((Context) TbadkCoreApplication.getInst(), bdVar.getTitle(), (ArrayList<j.a>) arrayList, false);
        a.append((CharSequence) bdVar.a(new SpannableString(bdVar.g(bdVar.getTitle(), false) + " ")));
        this.mTitleView.setLinkTextColor(getContext().getResources().getColor(d.C0140d.cp_link_tip_c));
        this.mTitleView.setOnTouchListener(new com.baidu.tieba.view.m(a));
        this.mTitleView.setText(a);
        com.baidu.tieba.card.j.a(this.mTitleView, bdVar.getId(), d.C0140d.cp_cont_b, d.C0140d.cp_cont_d);
        if (bdVar.yZ() == null || bdVar.yZ().options_count.intValue() == 0) {
            this.dMu.setVisibility(8);
            this.dMv.setVisibility(8);
        } else {
            String string = this.mPageContext.getResources().getString(d.j.total_x_vote_option);
            this.dMu.setVisibility(0);
            this.dMu.setText(String.format(string, String.valueOf(bdVar.yZ().options_count)));
            if (StringUtils.isNull(bdVar.yZ().tips, true)) {
                this.dMv.setVisibility(8);
            } else {
                this.dMv.setVisibility(0);
                this.dMv.setText("(" + bdVar.yZ().tips + ")");
            }
        }
        if (this.dLT.setData(bdVar)) {
            this.cWr.setVisibility(8);
        } else {
            this.cWr.setVisibility(0);
        }
        this.dLT.setForumAfterClickListener(this.bdQ);
        this.dLT.setStType("frs_page");
        S(bdVar);
        this.dLJ.W(this.aZM);
        b.a(this.aZM, this.cXw);
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((view == this.mRootView || view == this.dLT.getCommentNumView() || view == this.cXw) && this.aZM != null) {
            if (this.aZM.zK() > 0 && com.baidu.tieba.tbadkCore.util.f.bxT()) {
                PbActivityConfig createHistoryCfg = new PbActivityConfig(this.mPageContext.getPageActivity()).createHistoryCfg(this.aZM.getTid(), String.valueOf(this.aZM.zK()), false, true, "frs_page");
                createHistoryCfg.setFromSmartFrs(this.aZM.An());
                createHistoryCfg.setSmartFrsPosition(this.aZM.Au());
                createHistoryCfg.setForumId(String.valueOf(this.aZM.getFid()));
                createHistoryCfg.setStartFrom(this.currentPageType);
                MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createHistoryCfg));
                return;
            }
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(this.aZM, this.mForumName, "frs_page", 18003, true, false, false);
            createFromThreadCfg.setFromSmartFrs(this.aZM.An());
            createFromThreadCfg.setForumId(String.valueOf(this.aZM.getFid()));
            createFromThreadCfg.setStartFrom(this.currentPageType);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createFromThreadCfg));
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.dLT != null && this.cWt != null) {
            this.cWt.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.cWt);
        }
    }

    @Override // com.baidu.tieba.card.t
    public void setForumName(String str) {
        this.mForumName = str;
    }
}
