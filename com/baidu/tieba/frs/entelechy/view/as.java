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
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.UserIconLayout;
import com.baidu.tbadk.data.UserTbVipInfoData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.at;
import com.baidu.tieba.card.cd;
import com.baidu.tieba.card.divider.CardGroupDividerView;
import com.baidu.tieba.r;
import java.util.ArrayList;
/* loaded from: classes.dex */
public abstract class as extends com.baidu.tieba.card.a<bh> implements cd {
    protected TbPageContext<?> FY;
    protected TextView Ve;
    public ClickableHeaderImageView aLP;
    public ViewStub aUU;
    public TbImageView aUV;
    protected bh acX;
    private final View.OnClickListener agO;
    private final View.OnClickListener agt;
    public TbImageView bHZ;
    public HeadPendantClickableView bMP;
    protected TextView bMQ;
    protected TextView bMR;
    public RelativeLayout bMz;
    public ThreadCommentAndPraiseInfoLayout bkU;
    private CustomMessageListener blR;
    private CardGroupDividerView blz;
    public View bmA;
    public UserIconLayout bmB;
    private String mForumName;
    protected boolean mIsFromCDN;
    protected View mRootView;
    private int mSkinType;

    protected abstract void ih(int i);

    protected abstract void t(bh bhVar);

    /* JADX INFO: Access modifiers changed from: protected */
    public int getSkinType() {
        return this.mSkinType;
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    public as(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.mIsFromCDN = true;
        this.blR = new at(this, CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR);
        this.agO = new au(this);
        this.agt = new av(this);
        this.FY = tbPageContext;
        initView();
    }

    public void initView() {
        this.mRootView = getView();
        this.aLP = (ClickableHeaderImageView) this.mRootView.findViewById(r.h.card_vote_header_image);
        this.bMP = (HeadPendantClickableView) this.mRootView.findViewById(r.h.card_vote_pendant_header_image);
        this.aUU = (ViewStub) this.mRootView.findViewById(r.h.viewstub_headimage_mask);
        this.aLP.setDefaultResource(17170445);
        this.aLP.setDefaultErrorResource(r.g.icon_default_avatar100);
        this.aLP.setDefaultBgResource(r.e.cp_bg_line_e);
        this.aLP.setRadius(com.baidu.adp.lib.util.k.e(this.FY.getPageActivity(), r.f.ds70));
        if (this.bMP.getHeadView() != null) {
            this.bMP.getHeadView().setDefaultResource(17170445);
            this.bMP.getHeadView().setDefaultErrorResource(r.g.icon_default_avatar100);
            this.bMP.getHeadView().setDefaultBgResource(r.e.cp_bg_line_e);
            this.bMP.getHeadView().setRadius(com.baidu.adp.lib.util.k.e(this.FY.getPageActivity(), r.f.ds70));
            this.bMP.getHeadView().setIsRound(true);
            this.bMP.getHeadView().setDrawBorder(false);
        }
        this.bMP.vS();
        if (this.bMP.getPendantView() != null) {
            this.bMP.getPendantView().setIsRound(true);
            this.bMP.getPendantView().setDrawBorder(false);
        }
        this.bmB = (UserIconLayout) this.mRootView.findViewById(r.h.user_icon);
        this.bmB.agN = true;
        this.bmB.setEntelechyEnabled(true);
        this.bmB.setPageName(1);
        this.bHZ = (TbImageView) this.mRootView.findViewById(r.h.theme_card_view);
        this.Ve = (TextView) this.mRootView.findViewById(r.h.vote_thread_title);
        this.bMQ = (TextView) this.mRootView.findViewById(r.h.vote_total_option_num);
        this.bMR = (TextView) this.mRootView.findViewById(r.h.vote_now_state);
        this.bkU = (ThreadCommentAndPraiseInfoLayout) this.mRootView.findViewById(r.h.thread_more_info);
        this.bmA = this.mRootView.findViewById(r.h.divider_below_reply_number_layout);
        this.bMz = (RelativeLayout) this.mRootView.findViewById(r.h.card_home_page_normal_thread_root_content);
        this.blz = (CardGroupDividerView) this.mRootView.findViewById(r.h.header_divider);
        this.blz.setTitleClickListener(this);
        this.bkU.setViewNumEnabled(true);
    }

    @Override // com.baidu.tieba.card.a
    public final void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.ap.j(getView(), r.g.addresslist_item_bg);
            this.bmB.tg();
            this.bkU.tg();
            com.baidu.tbadk.core.util.ap.c(this.bMQ, r.e.cp_cont_c, 1);
            com.baidu.tbadk.core.util.ap.c(this.bMR, r.e.cp_cont_d, 1);
            ih(i);
            if (this.blz != null) {
                this.blz.tg();
            }
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return r.j.card_vote_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: k */
    public final void onBindDataToView(bh bhVar) {
        if (bhVar == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        this.acX = bhVar;
        if (getView() != null) {
            getView().setVisibility(0);
        }
        if (this.acX.getAuthor() == null || this.acX.getAuthor().getPendantData() == null || StringUtils.isNull(this.acX.getAuthor().getPendantData().pL())) {
            UserTbVipInfoData rx = this.acX.rx();
            if (rx != null && rx.getvipV_url() != null) {
                if (this.aUU != null) {
                    if (this.aUV == null) {
                        this.aUU.inflate();
                        this.aUV = (TbImageView) getView().findViewById(r.h.user_head_mask);
                    }
                    this.aUV.setVisibility(0);
                    this.aUV.c(rx.getvipV_url(), 10, false);
                    this.aLP.setIsBigV(true);
                }
            } else {
                this.aLP.setIsBigV(false);
                if (this.aUV != null) {
                    this.aUV.setVisibility(8);
                }
            }
            this.bMP.setVisibility(8);
            this.aLP.setVisibility(0);
            this.aLP.setData(bhVar);
        } else {
            this.aLP.setIsBigV(false);
            if (this.aUV != null) {
                this.aUV.setVisibility(8);
            }
            this.bMP.setVisibility(0);
            this.aLP.setVisibility(4);
            this.bMP.setData(bhVar);
        }
        this.aLP.setAfterClickListener(this.agO);
        this.bmB.setVisibility(0);
        if (bhVar.getAuthor() != null && !StringUtils.isNull(bhVar.getAuthor().getSealPrefix())) {
            this.bmB.aO(true);
        }
        this.bmB.setData(bhVar);
        this.bmB.setUserAfterClickListener(this.agO);
        ArrayList arrayList = new ArrayList();
        if (bhVar.rt() == 1) {
            arrayList.add(new at.a(r.l.good));
        }
        SpannableStringBuilder a = com.baidu.tieba.card.at.a((Context) TbadkCoreApplication.m9getInst(), bhVar.getTitle(), (ArrayList<at.a>) arrayList, false);
        a.append((CharSequence) bhVar.a(new SpannableString(String.valueOf(bhVar.g(bhVar.getTitle(), false)) + " "), false));
        this.Ve.setLinkTextColor(getContext().getResources().getColor(r.e.cp_link_tip_c));
        this.Ve.setOnTouchListener(new com.baidu.tieba.view.x(a));
        this.Ve.setText(a);
        com.baidu.tieba.card.at.a(this.Ve, bhVar.getId(), r.e.cp_cont_b, r.e.cp_cont_d);
        if (bhVar.rm() == null || bhVar.rm().options_count.intValue() == 0) {
            this.bMQ.setVisibility(8);
            this.bMR.setVisibility(8);
        } else {
            String string = this.FY.getResources().getString(r.l.total_x_vote_option);
            this.bMQ.setVisibility(0);
            this.bMQ.setText(String.format(string, String.valueOf(bhVar.rm().options_count)));
            if (StringUtils.isNull(bhVar.rm().tips, true)) {
                this.bMR.setVisibility(8);
            } else {
                this.bMR.setVisibility(0);
                this.bMR.setText("(" + bhVar.rm().tips + ")");
            }
        }
        if (this.bkU.a(bhVar)) {
            this.bmA.setVisibility(8);
        } else {
            this.bmA.setVisibility(0);
        }
        this.bkU.setForumAfterClickListener(this.agt);
        this.bkU.setStType(com.baidu.tieba.card.at.Mt());
        t(bhVar);
        p.a(this.acX, this.blz);
        onChangeSkinType(this.FY, TbadkCoreApplication.m9getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((view == this.mRootView || view == this.bkU.getCommentNumView() || view == this.blz) && this.acX != null) {
            if (this.acX.rS() > 0 && com.baidu.tieba.tbadkCore.util.s.biL()) {
                PbActivityConfig createHistoryCfg = new PbActivityConfig(this.FY.getPageActivity()).createHistoryCfg(this.acX.getTid(), String.valueOf(this.acX.rS()), false, true, null);
                createHistoryCfg.setFromSmartFrs(this.acX.sy());
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createHistoryCfg));
                return;
            }
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.FY.getPageActivity()).createFromThreadCfg(this.acX, this.mForumName, null, 18003, true, false, false);
            createFromThreadCfg.setFromSmartFrs(this.acX.sy());
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.bkU != null && this.blR != null) {
            this.blR.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.blR);
        }
    }

    @Override // com.baidu.tieba.card.cd
    public void setForumName(String str) {
        this.mForumName = str;
    }
}
