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
    protected TextView aaA;
    protected bl aiQ;
    protected TbPageContext<?> ako;
    public ViewStub anA;
    public TbImageView anB;
    private final View.OnClickListener anD;
    private final View.OnClickListener ann;
    public View bEE;
    private CustomMessageListener bFA;
    private CardGroupDividerView bFn;
    public UserIconLayout bGA;
    public ThreadCommentAndPraiseInfoLayout bGx;
    public TbImageView cjQ;
    public RelativeLayout cnB;
    public HeadPendantClickableView cnX;
    public ClickableHeaderImageView cnY;
    protected TextView cnZ;
    private com.baidu.tieba.frs.h.g cnw;
    protected TextView coa;
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
        this.bFA = new CustomMessageListener(CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR) { // from class: com.baidu.tieba.frs.entelechy.view.i.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && i.this.aiQ != null && i.this.aiQ.getTid() != null && i.this.aaA != null && ((String) customResponsedMessage.getData()).equals(i.this.aiQ.getTid())) {
                    m.a(i.this.aaA, i.this.aiQ.getId(), d.e.cp_cont_b, d.e.cp_cont_d);
                }
            }
        };
        this.anD = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.i.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (i.this.VZ() != null) {
                    i.this.VZ().a(view, i.this.aiQ);
                }
            }
        };
        this.ann = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.i.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (i.this.VZ() != null) {
                    i.this.VZ().a(view, i.this.aiQ);
                }
            }
        };
        setTag(bdUniqueId);
        this.ako = tbPageContext;
        initView();
    }

    public void initView() {
        this.mRootView = getView();
        this.cnY = (ClickableHeaderImageView) this.mRootView.findViewById(d.h.card_vote_header_image);
        this.cnX = (HeadPendantClickableView) this.mRootView.findViewById(d.h.card_vote_pendant_header_image);
        this.anA = (ViewStub) this.mRootView.findViewById(d.h.viewstub_headimage_mask);
        this.cnY.setDefaultResource(17170445);
        this.cnY.setDefaultErrorResource(d.g.icon_default_avatar100);
        this.cnY.setDefaultBgResource(d.e.cp_bg_line_e);
        this.cnY.setRadius(com.baidu.adp.lib.util.k.g(this.ako.getPageActivity(), d.f.ds70));
        if (this.cnX.getHeadView() != null) {
            this.cnX.getHeadView().setDefaultResource(17170445);
            this.cnX.getHeadView().setDefaultErrorResource(d.g.icon_default_avatar100);
            this.cnX.getHeadView().setDefaultBgResource(d.e.cp_bg_line_e);
            this.cnX.getHeadView().setRadius(com.baidu.adp.lib.util.k.g(this.ako.getPageActivity(), d.f.ds70));
            this.cnX.getHeadView().setIsRound(true);
            this.cnX.getHeadView().setDrawBorder(false);
        }
        this.cnX.wt();
        if (this.cnX.getPendantView() != null) {
            this.cnX.getPendantView().setIsRound(true);
            this.cnX.getPendantView().setDrawBorder(false);
        }
        this.bGA = (UserIconLayout) this.mRootView.findViewById(d.h.user_icon);
        this.bGA.aoo = true;
        this.bGA.setEntelechyEnabled(true);
        this.bGA.setPageName(1);
        this.cjQ = (TbImageView) this.mRootView.findViewById(d.h.theme_card_view);
        this.cjQ.setPageId(getTag());
        this.aaA = (TextView) this.mRootView.findViewById(d.h.vote_thread_title);
        this.cnZ = (TextView) this.mRootView.findViewById(d.h.vote_total_option_num);
        this.coa = (TextView) this.mRootView.findViewById(d.h.vote_now_state);
        this.bGx = (ThreadCommentAndPraiseInfoLayout) this.mRootView.findViewById(d.h.thread_more_info);
        this.bEE = this.mRootView.findViewById(d.h.divider_below_reply_number_layout);
        this.cnB = (RelativeLayout) this.mRootView.findViewById(d.h.card_home_page_normal_thread_root_content);
        this.bFn = (CardGroupDividerView) this.mRootView.findViewById(d.h.header_divider);
        this.bFn.setTitleClickListener(this);
        this.bGx.setViewNumEnabled(true);
        this.cnw = new com.baidu.tieba.frs.h.g(this.ako, this.bGx);
        this.cnw.setUniqueId(getTag());
    }

    @Override // com.baidu.tieba.card.a
    public final void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ai.j(getView(), d.g.addresslist_item_bg);
            this.bGA.onChangeSkinType();
            this.bGx.onChangeSkinType();
            ai.c(this.cnZ, d.e.cp_cont_c, 1);
            ai.c(this.coa, d.e.cp_cont_d, 1);
            iW(i);
            if (this.bFn != null) {
                this.bFn.onChangeSkinType();
            }
            this.cnw.onChangeSkinType();
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
        this.aiQ = blVar;
        if (getView() != null) {
            getView().setVisibility(0);
        }
        if (this.aiQ.getAuthor() == null || this.aiQ.getAuthor().getPendantData() == null || StringUtils.isNull(this.aiQ.getAuthor().getPendantData().pL())) {
            UserTbVipInfoData rv = this.aiQ.rv();
            if (rv != null && rv.getvipV_url() != null) {
                if (this.anA != null) {
                    if (this.anB == null) {
                        this.anA.inflate();
                        this.anB = (TbImageView) getView().findViewById(d.h.user_head_mask);
                    }
                    this.anB.setPageId(getTag());
                    this.anB.setVisibility(0);
                    this.anB.c(rv.getvipV_url(), 10, false);
                    this.cnY.setIsBigV(true);
                }
            } else {
                this.cnY.setIsBigV(false);
                if (this.anB != null) {
                    this.anB.setVisibility(8);
                }
            }
            this.cnX.setVisibility(8);
            this.cnY.setVisibility(0);
            this.cnY.setData(blVar);
        } else {
            this.cnY.setIsBigV(false);
            if (this.anB != null) {
                this.anB.setVisibility(8);
            }
            this.cnX.setVisibility(0);
            this.cnY.setVisibility(4);
            this.cnX.setData(blVar);
        }
        this.cnY.setAfterClickListener(this.anD);
        this.bGA.setVisibility(0);
        if (blVar.getAuthor() != null && !StringUtils.isNull(blVar.getAuthor().getSealPrefix())) {
            this.bGA.aP(true);
        }
        this.bGA.setData(blVar);
        this.bGA.setUserAfterClickListener(this.anD);
        ArrayList arrayList = new ArrayList();
        if (blVar.rr() == 1) {
            arrayList.add(new m.a(d.l.good));
        }
        SpannableStringBuilder a = m.a((Context) TbadkCoreApplication.getInst(), blVar.getTitle(), (ArrayList<m.a>) arrayList, false);
        a.append((CharSequence) blVar.a(new SpannableString(blVar.g(blVar.getTitle(), false) + " ")));
        this.aaA.setLinkTextColor(getContext().getResources().getColor(d.e.cp_link_tip_c));
        this.aaA.setOnTouchListener(new com.baidu.tieba.view.l(a));
        this.aaA.setText(a);
        m.a(this.aaA, blVar.getId(), d.e.cp_cont_b, d.e.cp_cont_d);
        if (blVar.rj() == null || blVar.rj().options_count.intValue() == 0) {
            this.cnZ.setVisibility(8);
            this.coa.setVisibility(8);
        } else {
            String string = this.ako.getResources().getString(d.l.total_x_vote_option);
            this.cnZ.setVisibility(0);
            this.cnZ.setText(String.format(string, String.valueOf(blVar.rj().options_count)));
            if (StringUtils.isNull(blVar.rj().tips, true)) {
                this.coa.setVisibility(8);
            } else {
                this.coa.setVisibility(0);
                this.coa.setText("(" + blVar.rj().tips + ")");
            }
        }
        if (this.bGx.a(blVar)) {
            this.bEE.setVisibility(8);
        } else {
            this.bEE.setVisibility(0);
        }
        this.bGx.setForumAfterClickListener(this.ann);
        this.bGx.setStType(m.rm());
        H(blVar);
        this.cnw.P(this.aiQ);
        b.a(this.aiQ, this.bFn);
        d(this.ako, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((view == this.mRootView || view == this.bGx.getCommentNumView() || view == this.bFn) && this.aiQ != null) {
            if (this.aiQ.rR() > 0 && com.baidu.tieba.tbadkCore.util.g.btp()) {
                PbActivityConfig createHistoryCfg = new PbActivityConfig(this.ako.getPageActivity()).createHistoryCfg(this.aiQ.getTid(), String.valueOf(this.aiQ.rR()), false, true, null);
                createHistoryCfg.setFromSmartFrs(this.aiQ.sy());
                createHistoryCfg.setSmartFrsPosition(this.aiQ.sF());
                createHistoryCfg.setForumId(String.valueOf(this.aiQ.getFid()));
                createHistoryCfg.setStartFrom(1);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createHistoryCfg));
                return;
            }
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.ako.getPageActivity()).createFromThreadCfg(this.aiQ, this.mForumName, null, 18003, true, false, false);
            createFromThreadCfg.setFromSmartFrs(this.aiQ.sy());
            createFromThreadCfg.setForumId(String.valueOf(this.aiQ.getFid()));
            createFromThreadCfg.setStartFrom(1);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.bGx != null && this.bFA != null) {
            this.bFA.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.bFA);
        }
    }

    @Override // com.baidu.tieba.card.v
    public void setForumName(String str) {
        this.mForumName = str;
    }
}
