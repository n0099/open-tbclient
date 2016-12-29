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
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.UserIconLayout;
import com.baidu.tbadk.data.UserTbVipInfoData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.ap;
import com.baidu.tieba.card.divider.CardGroupDividerView;
import com.baidu.tieba.r;
import java.util.ArrayList;
/* loaded from: classes.dex */
public abstract class as extends com.baidu.tieba.card.a<bg> implements bb {
    protected TbPageContext<?> GO;
    protected TextView VO;
    public ClickableHeaderImageView aMO;
    protected bg adN;
    private final View.OnClickListener ahA;
    private final View.OnClickListener ahg;
    public TbImageView bAE;
    public HeadPendantClickableView bGA;
    protected TextView bGB;
    protected TextView bGC;
    public RelativeLayout bGk;
    public ViewStub baW;
    public TbImageView baX;
    private CardGroupDividerView bbM;
    public ThreadCommentAndPraiseInfoLayout bbg;
    public View bcL;
    public UserIconLayout bcM;
    private CustomMessageListener bct;
    private String mForumName;
    protected boolean mIsFromCDN;
    protected View mRootView;
    private int mSkinType;

    protected abstract void hu(int i);

    protected abstract void q(bg bgVar);

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
        this.bct = new at(this, CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR);
        this.ahA = new au(this);
        this.ahg = new av(this);
        this.GO = tbPageContext;
        initView();
    }

    public void initView() {
        this.mRootView = getView();
        this.aMO = (ClickableHeaderImageView) this.mRootView.findViewById(r.g.card_vote_header_image);
        this.bGA = (HeadPendantClickableView) this.mRootView.findViewById(r.g.card_vote_pendant_header_image);
        this.baW = (ViewStub) this.mRootView.findViewById(r.g.viewstub_headimage_mask);
        this.aMO.setDefaultResource(17170445);
        this.aMO.setDefaultErrorResource(r.f.icon_default_avatar100);
        this.aMO.setDefaultBgResource(r.d.cp_bg_line_e);
        this.aMO.setRadius(com.baidu.adp.lib.util.k.e(this.GO.getPageActivity(), r.e.ds70));
        if (this.bGA.getHeadView() != null) {
            this.bGA.getHeadView().setDefaultResource(17170445);
            this.bGA.getHeadView().setDefaultErrorResource(r.f.icon_default_avatar100);
            this.bGA.getHeadView().setDefaultBgResource(r.d.cp_bg_line_e);
            this.bGA.getHeadView().setRadius(com.baidu.adp.lib.util.k.e(this.GO.getPageActivity(), r.e.ds70));
            this.bGA.getHeadView().setIsRound(true);
            this.bGA.getHeadView().setDrawBorder(false);
        }
        this.bGA.vY();
        if (this.bGA.getPendantView() != null) {
            this.bGA.getPendantView().setIsRound(true);
            this.bGA.getPendantView().setDrawBorder(false);
        }
        this.bcM = (UserIconLayout) this.mRootView.findViewById(r.g.user_icon);
        this.bcM.ahz = true;
        this.bcM.setEntelechyEnabled(true);
        this.bcM.setPageName(1);
        this.bAE = (TbImageView) this.mRootView.findViewById(r.g.theme_card_view);
        this.VO = (TextView) this.mRootView.findViewById(r.g.vote_thread_title);
        this.bGB = (TextView) this.mRootView.findViewById(r.g.vote_total_option_num);
        this.bGC = (TextView) this.mRootView.findViewById(r.g.vote_now_state);
        this.bbg = (ThreadCommentAndPraiseInfoLayout) this.mRootView.findViewById(r.g.thread_more_info);
        this.bcL = this.mRootView.findViewById(r.g.divider_below_reply_number_layout);
        this.bGk = (RelativeLayout) this.mRootView.findViewById(r.g.card_home_page_normal_thread_root_content);
        this.bbM = (CardGroupDividerView) this.mRootView.findViewById(r.g.header_divider);
        this.bbM.setTitleClickListener(this);
        this.bbg.setViewNumEnabled(true);
    }

    @Override // com.baidu.tieba.card.a
    public final void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.ar.k(getView(), r.f.addresslist_item_bg);
            this.bcM.tm();
            this.bbg.tm();
            com.baidu.tbadk.core.util.ar.c(this.bGB, r.d.cp_cont_c, 1);
            com.baidu.tbadk.core.util.ar.c(this.bGC, r.d.cp_cont_d, 1);
            hu(i);
            if (this.bbM != null) {
                this.bbM.tm();
            }
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return r.h.card_vote_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: o */
    public final void onBindDataToView(bg bgVar) {
        if (bgVar == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        this.adN = bgVar;
        if (getView() != null) {
            getView().setVisibility(0);
        }
        if (this.adN.getAuthor() == null || this.adN.getAuthor().getPendantData() == null || StringUtils.isNull(this.adN.getAuthor().getPendantData().pS())) {
            UserTbVipInfoData rF = this.adN.rF();
            if (rF != null && rF.getvipV_url() != null) {
                if (this.baW != null) {
                    if (this.baX == null) {
                        this.baW.inflate();
                        this.baX = (TbImageView) getView().findViewById(r.g.user_head_mask);
                    }
                    this.baX.setVisibility(0);
                    this.baX.c(rF.getvipV_url(), 10, false);
                    this.aMO.setIsBigV(true);
                }
            } else {
                this.aMO.setIsBigV(false);
                if (this.baX != null) {
                    this.baX.setVisibility(8);
                }
            }
            this.bGA.setVisibility(8);
            this.aMO.setVisibility(0);
            this.aMO.setData(bgVar);
        } else {
            this.aMO.setIsBigV(false);
            if (this.baX != null) {
                this.baX.setVisibility(8);
            }
            this.bGA.setVisibility(0);
            this.aMO.setVisibility(4);
            this.bGA.setData(bgVar);
        }
        this.aMO.setAfterClickListener(this.ahA);
        this.bcM.setVisibility(0);
        if (bgVar.getAuthor() != null && !StringUtils.isNull(bgVar.getAuthor().getSealPrefix())) {
            this.bcM.aO(true);
        }
        this.bcM.setData(bgVar);
        this.bcM.setUserAfterClickListener(this.ahA);
        ArrayList arrayList = new ArrayList();
        if (bgVar.rB() == 1) {
            arrayList.add(new ap.a(r.j.good));
        }
        SpannableStringBuilder a = com.baidu.tieba.card.ap.a((Context) TbadkCoreApplication.m9getInst(), bgVar.getTitle(), (ArrayList<ap.a>) arrayList, false);
        a.append((CharSequence) bgVar.a(new SpannableString(String.valueOf(bgVar.g(bgVar.getTitle(), false)) + " "), false));
        this.VO.setLinkTextColor(getContext().getResources().getColor(r.d.cp_link_tip_c));
        this.VO.setOnTouchListener(new com.baidu.tieba.view.x(a));
        this.VO.setText(a);
        com.baidu.tieba.card.ap.a(this.VO, bgVar.getId(), r.d.cp_cont_b, r.d.cp_cont_d);
        if (bgVar.ru() == null || bgVar.ru().options_count.intValue() == 0) {
            this.bGB.setVisibility(8);
            this.bGC.setVisibility(8);
        } else {
            String string = this.GO.getResources().getString(r.j.total_x_vote_option);
            this.bGB.setVisibility(0);
            this.bGB.setText(String.format(string, String.valueOf(bgVar.ru().options_count)));
            if (StringUtils.isNull(bgVar.ru().tips, true)) {
                this.bGC.setVisibility(8);
            } else {
                this.bGC.setVisibility(0);
                this.bGC.setText("(" + bgVar.ru().tips + ")");
            }
        }
        if (this.bbg.a(bgVar)) {
            this.bcL.setVisibility(8);
        } else {
            this.bcL.setVisibility(0);
        }
        this.bbg.setForumAfterClickListener(this.ahg);
        this.bbg.setStType(com.baidu.tieba.card.ap.OB());
        q(bgVar);
        p.a(this.adN, this.bbM);
        onChangeSkinType(this.GO, TbadkCoreApplication.m9getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((view == this.mRootView || view == this.bbg.getCommentNumView() || view == this.bbM) && this.adN != null) {
            if (this.adN.sa() > 0 && com.baidu.tieba.tbadkCore.util.s.bha()) {
                PbActivityConfig createHistoryCfg = new PbActivityConfig(this.GO.getPageActivity()).createHistoryCfg(this.adN.getTid(), String.valueOf(this.adN.sa()), false, true, null);
                createHistoryCfg.setFromSmartFrs(this.adN.sG());
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createHistoryCfg));
                return;
            }
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.GO.getPageActivity()).createFromThreadCfg(this.adN, this.mForumName, null, 18003, true, false, false);
            createFromThreadCfg.setFromSmartFrs(this.adN.sG());
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.bbg != null && this.bct != null) {
            this.bct.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.bct);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.view.bb
    public void setForumName(String str) {
        this.mForumName = str;
    }
}
