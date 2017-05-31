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
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.UserIconLayout;
import com.baidu.tbadk.data.UserTbVipInfoData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.at;
import com.baidu.tieba.card.cg;
import com.baidu.tieba.card.divider.CardGroupDividerView;
import com.baidu.tieba.w;
import java.util.ArrayList;
/* loaded from: classes.dex */
public abstract class ao extends com.baidu.tieba.card.a<bl> implements cg {
    protected TextView aaa;
    protected bl ahM;
    protected TbPageContext<?> ajh;
    private final View.OnClickListener alO;
    public ViewStub alX;
    public TbImageView alY;
    private final View.OnClickListener ama;
    private CustomMessageListener bAA;
    private CardGroupDividerView bAn;
    public UserIconLayout bBA;
    public ThreadCommentAndPraiseInfoLayout bBx;
    public TbImageView bVW;
    public HeadPendantClickableView bZR;
    public ClickableHeaderImageView bZS;
    protected TextView bZT;
    protected TextView bZU;
    private com.baidu.tieba.frs.f.ae bZq;
    public RelativeLayout bZv;
    public View bzE;
    private String mForumName;
    protected boolean mIsFromCDN;
    protected View mRootView;
    private int mSkinType;

    protected abstract void C(bl blVar);

    protected abstract void iA(int i);

    /* JADX INFO: Access modifiers changed from: protected */
    public int getSkinType() {
        return this.mSkinType;
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    public ao(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.mIsFromCDN = true;
        this.bAA = new ap(this, CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR);
        this.ama = new aq(this);
        this.alO = new ar(this);
        setTag(bdUniqueId);
        this.ajh = tbPageContext;
        initView();
    }

    public void initView() {
        this.mRootView = getView();
        this.bZS = (ClickableHeaderImageView) this.mRootView.findViewById(w.h.card_vote_header_image);
        this.bZR = (HeadPendantClickableView) this.mRootView.findViewById(w.h.card_vote_pendant_header_image);
        this.alX = (ViewStub) this.mRootView.findViewById(w.h.viewstub_headimage_mask);
        this.bZS.setDefaultResource(17170445);
        this.bZS.setDefaultErrorResource(w.g.icon_default_avatar100);
        this.bZS.setDefaultBgResource(w.e.cp_bg_line_e);
        this.bZS.setRadius(com.baidu.adp.lib.util.k.g(this.ajh.getPageActivity(), w.f.ds70));
        if (this.bZR.getHeadView() != null) {
            this.bZR.getHeadView().setDefaultResource(17170445);
            this.bZR.getHeadView().setDefaultErrorResource(w.g.icon_default_avatar100);
            this.bZR.getHeadView().setDefaultBgResource(w.e.cp_bg_line_e);
            this.bZR.getHeadView().setRadius(com.baidu.adp.lib.util.k.g(this.ajh.getPageActivity(), w.f.ds70));
            this.bZR.getHeadView().setIsRound(true);
            this.bZR.getHeadView().setDrawBorder(false);
        }
        this.bZR.vV();
        if (this.bZR.getPendantView() != null) {
            this.bZR.getPendantView().setIsRound(true);
            this.bZR.getPendantView().setDrawBorder(false);
        }
        this.bBA = (UserIconLayout) this.mRootView.findViewById(w.h.user_icon);
        this.bBA.amA = true;
        this.bBA.setEntelechyEnabled(true);
        this.bBA.setPageName(1);
        this.bVW = (TbImageView) this.mRootView.findViewById(w.h.theme_card_view);
        this.bVW.setPageId(getTag());
        this.aaa = (TextView) this.mRootView.findViewById(w.h.vote_thread_title);
        this.bZT = (TextView) this.mRootView.findViewById(w.h.vote_total_option_num);
        this.bZU = (TextView) this.mRootView.findViewById(w.h.vote_now_state);
        this.bBx = (ThreadCommentAndPraiseInfoLayout) this.mRootView.findViewById(w.h.thread_more_info);
        this.bzE = this.mRootView.findViewById(w.h.divider_below_reply_number_layout);
        this.bZv = (RelativeLayout) this.mRootView.findViewById(w.h.card_home_page_normal_thread_root_content);
        this.bAn = (CardGroupDividerView) this.mRootView.findViewById(w.h.header_divider);
        this.bAn.setTitleClickListener(this);
        this.bBx.setViewNumEnabled(true);
        this.bZq = new com.baidu.tieba.frs.f.ae(this.ajh, this.bBx);
        this.bZq.setUniqueId(getTag());
    }

    @Override // com.baidu.tieba.card.a
    public final void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.aq.j(getView(), w.g.addresslist_item_bg);
            this.bBA.onChangeSkinType();
            this.bBx.onChangeSkinType();
            com.baidu.tbadk.core.util.aq.c(this.bZT, w.e.cp_cont_c, 1);
            com.baidu.tbadk.core.util.aq.c(this.bZU, w.e.cp_cont_d, 1);
            iA(i);
            if (this.bAn != null) {
                this.bAn.onChangeSkinType();
            }
            this.bZq.onChangeSkinType();
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return w.j.card_vote_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: r */
    public final void a(bl blVar) {
        if (blVar == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        this.ahM = blVar;
        if (getView() != null) {
            getView().setVisibility(0);
        }
        if (this.ahM.getAuthor() == null || this.ahM.getAuthor().getPendantData() == null || StringUtils.isNull(this.ahM.getAuthor().getPendantData().pL())) {
            UserTbVipInfoData rv = this.ahM.rv();
            if (rv != null && rv.getvipV_url() != null) {
                if (this.alX != null) {
                    if (this.alY == null) {
                        this.alX.inflate();
                        this.alY = (TbImageView) getView().findViewById(w.h.user_head_mask);
                    }
                    this.alY.setPageId(getTag());
                    this.alY.setVisibility(0);
                    this.alY.c(rv.getvipV_url(), 10, false);
                    this.bZS.setIsBigV(true);
                }
            } else {
                this.bZS.setIsBigV(false);
                if (this.alY != null) {
                    this.alY.setVisibility(8);
                }
            }
            this.bZR.setVisibility(8);
            this.bZS.setVisibility(0);
            this.bZS.setData(blVar);
        } else {
            this.bZS.setIsBigV(false);
            if (this.alY != null) {
                this.alY.setVisibility(8);
            }
            this.bZR.setVisibility(0);
            this.bZS.setVisibility(4);
            this.bZR.setData(blVar);
        }
        this.bZS.setAfterClickListener(this.ama);
        this.bBA.setVisibility(0);
        if (blVar.getAuthor() != null && !StringUtils.isNull(blVar.getAuthor().getSealPrefix())) {
            this.bBA.aN(true);
        }
        this.bBA.setData(blVar);
        this.bBA.setUserAfterClickListener(this.ama);
        ArrayList arrayList = new ArrayList();
        if (blVar.rr() == 1) {
            arrayList.add(new at.a(w.l.good));
        }
        SpannableStringBuilder a = com.baidu.tieba.card.at.a((Context) TbadkCoreApplication.m9getInst(), blVar.getTitle(), (ArrayList<at.a>) arrayList, false);
        a.append((CharSequence) blVar.a(new SpannableString(String.valueOf(blVar.g(blVar.getTitle(), false)) + " "), false));
        this.aaa.setLinkTextColor(getContext().getResources().getColor(w.e.cp_link_tip_c));
        this.aaa.setOnTouchListener(new com.baidu.tieba.view.aa(a));
        this.aaa.setText(a);
        com.baidu.tieba.card.at.a(this.aaa, blVar.getId(), w.e.cp_cont_b, w.e.cp_cont_d);
        if (blVar.rj() == null || blVar.rj().options_count.intValue() == 0) {
            this.bZT.setVisibility(8);
            this.bZU.setVisibility(8);
        } else {
            String string = this.ajh.getResources().getString(w.l.total_x_vote_option);
            this.bZT.setVisibility(0);
            this.bZT.setText(String.format(string, String.valueOf(blVar.rj().options_count)));
            if (StringUtils.isNull(blVar.rj().tips, true)) {
                this.bZU.setVisibility(8);
            } else {
                this.bZU.setVisibility(0);
                this.bZU.setText("(" + blVar.rj().tips + ")");
            }
        }
        if (this.bBx.a(blVar)) {
            this.bzE.setVisibility(8);
        } else {
            this.bzE.setVisibility(0);
        }
        this.bBx.setForumAfterClickListener(this.alO);
        this.bBx.setStType(com.baidu.tieba.card.at.rl());
        C(blVar);
        this.bZq.K(this.ahM);
        p.a(this.ahM, this.bAn);
        d(this.ajh, TbadkCoreApplication.m9getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((view == this.mRootView || view == this.bBx.getCommentNumView() || view == this.bAn) && this.ahM != null) {
            if (this.ahM.rQ() > 0 && com.baidu.tieba.tbadkCore.util.s.bje()) {
                PbActivityConfig createHistoryCfg = new PbActivityConfig(this.ajh.getPageActivity()).createHistoryCfg(this.ahM.getTid(), String.valueOf(this.ahM.rQ()), false, true, null);
                createHistoryCfg.setFromSmartFrs(this.ahM.sw());
                createHistoryCfg.setSmartFrsPosition(this.ahM.sC());
                createHistoryCfg.setForumId(String.valueOf(this.ahM.getFid()));
                createHistoryCfg.setStartFrom(1);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createHistoryCfg));
                return;
            }
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.ajh.getPageActivity()).createFromThreadCfg(this.ahM, this.mForumName, null, 18003, true, false, false);
            createFromThreadCfg.setFromSmartFrs(this.ahM.sw());
            createFromThreadCfg.setForumId(String.valueOf(this.ahM.getFid()));
            createFromThreadCfg.setStartFrom(1);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.bBx != null && this.bAA != null) {
            this.bAA.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.bAA);
        }
    }

    @Override // com.baidu.tieba.card.cg
    public void setForumName(String str) {
        this.mForumName = str;
    }
}
