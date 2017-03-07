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
import com.baidu.tbadk.core.data.bj;
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
import com.baidu.tieba.w;
import java.util.ArrayList;
/* loaded from: classes.dex */
public abstract class as extends com.baidu.tieba.card.a<bj> implements cd {
    public ClickableHeaderImageView aRC;
    protected TextView aap;
    protected bj ain;
    protected TbPageContext<?> ajF;
    private final View.OnClickListener alM;
    private final View.OnClickListener amj;
    public TbImageView bPi;
    public RelativeLayout bTH;
    public HeadPendantClickableView bTX;
    protected TextView bTY;
    protected TextView bTZ;
    private com.baidu.tieba.frs.f.af bTz;
    public ViewStub bbh;
    public TbImageView bbi;
    public ThreadCommentAndPraiseInfoLayout brM;
    private CustomMessageListener bsL;
    private CardGroupDividerView bss;
    public View btv;
    public UserIconLayout btw;
    private String mForumName;
    protected boolean mIsFromCDN;
    protected View mRootView;
    private int mSkinType;

    protected abstract void id(int i);

    protected abstract void t(bj bjVar);

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
        this.bsL = new at(this, CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR);
        this.amj = new au(this);
        this.alM = new av(this);
        this.ajF = tbPageContext;
        initView();
    }

    public void initView() {
        this.mRootView = getView();
        this.aRC = (ClickableHeaderImageView) this.mRootView.findViewById(w.h.card_vote_header_image);
        this.bTX = (HeadPendantClickableView) this.mRootView.findViewById(w.h.card_vote_pendant_header_image);
        this.bbh = (ViewStub) this.mRootView.findViewById(w.h.viewstub_headimage_mask);
        this.aRC.setDefaultResource(17170445);
        this.aRC.setDefaultErrorResource(w.g.icon_default_avatar100);
        this.aRC.setDefaultBgResource(w.e.cp_bg_line_e);
        this.aRC.setRadius(com.baidu.adp.lib.util.k.g(this.ajF.getPageActivity(), w.f.ds70));
        if (this.bTX.getHeadView() != null) {
            this.bTX.getHeadView().setDefaultResource(17170445);
            this.bTX.getHeadView().setDefaultErrorResource(w.g.icon_default_avatar100);
            this.bTX.getHeadView().setDefaultBgResource(w.e.cp_bg_line_e);
            this.bTX.getHeadView().setRadius(com.baidu.adp.lib.util.k.g(this.ajF.getPageActivity(), w.f.ds70));
            this.bTX.getHeadView().setIsRound(true);
            this.bTX.getHeadView().setDrawBorder(false);
        }
        this.bTX.wp();
        if (this.bTX.getPendantView() != null) {
            this.bTX.getPendantView().setIsRound(true);
            this.bTX.getPendantView().setDrawBorder(false);
        }
        this.btw = (UserIconLayout) this.mRootView.findViewById(w.h.user_icon);
        this.btw.amh = true;
        this.btw.setEntelechyEnabled(true);
        this.btw.setPageName(1);
        this.bPi = (TbImageView) this.mRootView.findViewById(w.h.theme_card_view);
        this.aap = (TextView) this.mRootView.findViewById(w.h.vote_thread_title);
        this.bTY = (TextView) this.mRootView.findViewById(w.h.vote_total_option_num);
        this.bTZ = (TextView) this.mRootView.findViewById(w.h.vote_now_state);
        this.brM = (ThreadCommentAndPraiseInfoLayout) this.mRootView.findViewById(w.h.thread_more_info);
        this.btv = this.mRootView.findViewById(w.h.divider_below_reply_number_layout);
        this.bTH = (RelativeLayout) this.mRootView.findViewById(w.h.card_home_page_normal_thread_root_content);
        this.bss = (CardGroupDividerView) this.mRootView.findViewById(w.h.header_divider);
        this.bss.setTitleClickListener(this);
        this.brM.setViewNumEnabled(true);
        this.bTz = new com.baidu.tieba.frs.f.af(this.ajF, this.brM);
    }

    @Override // com.baidu.tieba.card.a
    public final void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.aq.j(getView(), w.g.addresslist_item_bg);
            this.btw.tD();
            this.brM.tD();
            com.baidu.tbadk.core.util.aq.c(this.bTY, w.e.cp_cont_c, 1);
            com.baidu.tbadk.core.util.aq.c(this.bTZ, w.e.cp_cont_d, 1);
            id(i);
            if (this.bss != null) {
                this.bss.tD();
            }
            this.bTz.tD();
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return w.j.card_vote_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: k */
    public final void onBindDataToView(bj bjVar) {
        if (bjVar == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        this.ain = bjVar;
        if (getView() != null) {
            getView().setVisibility(0);
        }
        if (this.ain.getAuthor() == null || this.ain.getAuthor().getPendantData() == null || StringUtils.isNull(this.ain.getAuthor().getPendantData().qd())) {
            UserTbVipInfoData rR = this.ain.rR();
            if (rR != null && rR.getvipV_url() != null) {
                if (this.bbh != null) {
                    if (this.bbi == null) {
                        this.bbh.inflate();
                        this.bbi = (TbImageView) getView().findViewById(w.h.user_head_mask);
                    }
                    this.bbi.setVisibility(0);
                    this.bbi.c(rR.getvipV_url(), 10, false);
                    this.aRC.setIsBigV(true);
                }
            } else {
                this.aRC.setIsBigV(false);
                if (this.bbi != null) {
                    this.bbi.setVisibility(8);
                }
            }
            this.bTX.setVisibility(8);
            this.aRC.setVisibility(0);
            this.aRC.setData(bjVar);
        } else {
            this.aRC.setIsBigV(false);
            if (this.bbi != null) {
                this.bbi.setVisibility(8);
            }
            this.bTX.setVisibility(0);
            this.aRC.setVisibility(4);
            this.bTX.setData(bjVar);
        }
        this.aRC.setAfterClickListener(this.amj);
        this.btw.setVisibility(0);
        if (bjVar.getAuthor() != null && !StringUtils.isNull(bjVar.getAuthor().getSealPrefix())) {
            this.btw.aN(true);
        }
        this.btw.setData(bjVar);
        this.btw.setUserAfterClickListener(this.amj);
        ArrayList arrayList = new ArrayList();
        if (bjVar.rN() == 1) {
            arrayList.add(new at.a(w.l.good));
        }
        SpannableStringBuilder a = com.baidu.tieba.card.at.a((Context) TbadkCoreApplication.m9getInst(), bjVar.getTitle(), (ArrayList<at.a>) arrayList, false);
        a.append((CharSequence) bjVar.a(new SpannableString(String.valueOf(bjVar.g(bjVar.getTitle(), false)) + " "), false));
        this.aap.setLinkTextColor(getContext().getResources().getColor(w.e.cp_link_tip_c));
        this.aap.setOnTouchListener(new com.baidu.tieba.view.x(a));
        this.aap.setText(a);
        com.baidu.tieba.card.at.a(this.aap, bjVar.getId(), w.e.cp_cont_b, w.e.cp_cont_d);
        if (bjVar.rF() == null || bjVar.rF().options_count.intValue() == 0) {
            this.bTY.setVisibility(8);
            this.bTZ.setVisibility(8);
        } else {
            String string = this.ajF.getResources().getString(w.l.total_x_vote_option);
            this.bTY.setVisibility(0);
            this.bTY.setText(String.format(string, String.valueOf(bjVar.rF().options_count)));
            if (StringUtils.isNull(bjVar.rF().tips, true)) {
                this.bTZ.setVisibility(8);
            } else {
                this.bTZ.setVisibility(0);
                this.bTZ.setText("(" + bjVar.rF().tips + ")");
            }
        }
        if (this.brM.a(bjVar)) {
            this.btv.setVisibility(8);
        } else {
            this.btv.setVisibility(0);
        }
        this.brM.setForumAfterClickListener(this.alM);
        this.brM.setStType(com.baidu.tieba.card.at.rH());
        t(bjVar);
        this.bTz.D(this.ain);
        p.a(this.ain, this.bss);
        onChangeSkinType(this.ajF, TbadkCoreApplication.m9getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((view == this.mRootView || view == this.brM.getCommentNumView() || view == this.bss) && this.ain != null) {
            if (this.ain.sm() > 0 && com.baidu.tieba.tbadkCore.util.s.biB()) {
                PbActivityConfig createHistoryCfg = new PbActivityConfig(this.ajF.getPageActivity()).createHistoryCfg(this.ain.getTid(), String.valueOf(this.ain.sm()), false, true, null);
                createHistoryCfg.setFromSmartFrs(this.ain.sT());
                createHistoryCfg.setSmartFrsPosition(this.ain.sW());
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createHistoryCfg));
                return;
            }
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.ajF.getPageActivity()).createFromThreadCfg(this.ain, this.mForumName, null, 18003, true, false, false);
            createFromThreadCfg.setFromSmartFrs(this.ain.sT());
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.brM != null && this.bsL != null) {
            this.bsL.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.bsL);
        }
    }

    @Override // com.baidu.tieba.card.cd
    public void setForumName(String str) {
        this.mForumName = str;
    }
}
