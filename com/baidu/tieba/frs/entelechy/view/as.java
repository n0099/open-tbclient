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
import com.baidu.tbadk.core.data.bi;
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
public abstract class as extends com.baidu.tieba.card.a<bi> implements cd {
    public ClickableHeaderImageView aRS;
    protected TextView aaF;
    protected bi aiB;
    protected TbPageContext<?> ajT;
    private final View.OnClickListener ama;
    private final View.OnClickListener amx;
    public TbImageView bOX;
    public HeadPendantClickableView bTL;
    protected TextView bTM;
    protected TextView bTN;
    private com.baidu.tieba.frs.g.af bTn;
    public RelativeLayout bTv;
    public ViewStub bba;
    public TbImageView bbb;
    public ThreadCommentAndPraiseInfoLayout brE;
    private CustomMessageListener bsD;
    private CardGroupDividerView bsk;
    public View btm;
    public UserIconLayout bto;
    private String mForumName;
    protected boolean mIsFromCDN;
    protected View mRootView;
    private int mSkinType;

    protected abstract void ig(int i);

    protected abstract void t(bi biVar);

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
        this.bsD = new at(this, CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR);
        this.amx = new au(this);
        this.ama = new av(this);
        this.ajT = tbPageContext;
        initView();
    }

    public void initView() {
        this.mRootView = getView();
        this.aRS = (ClickableHeaderImageView) this.mRootView.findViewById(w.h.card_vote_header_image);
        this.bTL = (HeadPendantClickableView) this.mRootView.findViewById(w.h.card_vote_pendant_header_image);
        this.bba = (ViewStub) this.mRootView.findViewById(w.h.viewstub_headimage_mask);
        this.aRS.setDefaultResource(17170445);
        this.aRS.setDefaultErrorResource(w.g.icon_default_avatar100);
        this.aRS.setDefaultBgResource(w.e.cp_bg_line_e);
        this.aRS.setRadius(com.baidu.adp.lib.util.k.g(this.ajT.getPageActivity(), w.f.ds70));
        if (this.bTL.getHeadView() != null) {
            this.bTL.getHeadView().setDefaultResource(17170445);
            this.bTL.getHeadView().setDefaultErrorResource(w.g.icon_default_avatar100);
            this.bTL.getHeadView().setDefaultBgResource(w.e.cp_bg_line_e);
            this.bTL.getHeadView().setRadius(com.baidu.adp.lib.util.k.g(this.ajT.getPageActivity(), w.f.ds70));
            this.bTL.getHeadView().setIsRound(true);
            this.bTL.getHeadView().setDrawBorder(false);
        }
        this.bTL.wL();
        if (this.bTL.getPendantView() != null) {
            this.bTL.getPendantView().setIsRound(true);
            this.bTL.getPendantView().setDrawBorder(false);
        }
        this.bto = (UserIconLayout) this.mRootView.findViewById(w.h.user_icon);
        this.bto.amv = true;
        this.bto.setEntelechyEnabled(true);
        this.bto.setPageName(1);
        this.bOX = (TbImageView) this.mRootView.findViewById(w.h.theme_card_view);
        this.aaF = (TextView) this.mRootView.findViewById(w.h.vote_thread_title);
        this.bTM = (TextView) this.mRootView.findViewById(w.h.vote_total_option_num);
        this.bTN = (TextView) this.mRootView.findViewById(w.h.vote_now_state);
        this.brE = (ThreadCommentAndPraiseInfoLayout) this.mRootView.findViewById(w.h.thread_more_info);
        this.btm = this.mRootView.findViewById(w.h.divider_below_reply_number_layout);
        this.bTv = (RelativeLayout) this.mRootView.findViewById(w.h.card_home_page_normal_thread_root_content);
        this.bsk = (CardGroupDividerView) this.mRootView.findViewById(w.h.header_divider);
        this.bsk.setTitleClickListener(this);
        this.brE.setViewNumEnabled(true);
        this.bTn = new com.baidu.tieba.frs.g.af(this.ajT, this.brE);
    }

    @Override // com.baidu.tieba.card.a
    public final void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.aq.j(getView(), w.g.addresslist_item_bg);
            this.bto.onChangeSkinType();
            this.brE.onChangeSkinType();
            com.baidu.tbadk.core.util.aq.c(this.bTM, w.e.cp_cont_c, 1);
            com.baidu.tbadk.core.util.aq.c(this.bTN, w.e.cp_cont_d, 1);
            ig(i);
            if (this.bsk != null) {
                this.bsk.onChangeSkinType();
            }
            this.bTn.onChangeSkinType();
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
    public final void onBindDataToView(bi biVar) {
        if (biVar == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        this.aiB = biVar;
        if (getView() != null) {
            getView().setVisibility(0);
        }
        if (this.aiB.getAuthor() == null || this.aiB.getAuthor().getPendantData() == null || StringUtils.isNull(this.aiB.getAuthor().getPendantData().qB())) {
            UserTbVipInfoData sp = this.aiB.sp();
            if (sp != null && sp.getvipV_url() != null) {
                if (this.bba != null) {
                    if (this.bbb == null) {
                        this.bba.inflate();
                        this.bbb = (TbImageView) getView().findViewById(w.h.user_head_mask);
                    }
                    this.bbb.setVisibility(0);
                    this.bbb.c(sp.getvipV_url(), 10, false);
                    this.aRS.setIsBigV(true);
                }
            } else {
                this.aRS.setIsBigV(false);
                if (this.bbb != null) {
                    this.bbb.setVisibility(8);
                }
            }
            this.bTL.setVisibility(8);
            this.aRS.setVisibility(0);
            this.aRS.setData(biVar);
        } else {
            this.aRS.setIsBigV(false);
            if (this.bbb != null) {
                this.bbb.setVisibility(8);
            }
            this.bTL.setVisibility(0);
            this.aRS.setVisibility(4);
            this.bTL.setData(biVar);
        }
        this.aRS.setAfterClickListener(this.amx);
        this.bto.setVisibility(0);
        if (biVar.getAuthor() != null && !StringUtils.isNull(biVar.getAuthor().getSealPrefix())) {
            this.bto.aP(true);
        }
        this.bto.setData(biVar);
        this.bto.setUserAfterClickListener(this.amx);
        ArrayList arrayList = new ArrayList();
        if (biVar.sl() == 1) {
            arrayList.add(new at.a(w.l.good));
        }
        SpannableStringBuilder a = com.baidu.tieba.card.at.a((Context) TbadkCoreApplication.m9getInst(), biVar.getTitle(), (ArrayList<at.a>) arrayList, false);
        a.append((CharSequence) biVar.a(new SpannableString(String.valueOf(biVar.g(biVar.getTitle(), false)) + " "), false));
        this.aaF.setLinkTextColor(getContext().getResources().getColor(w.e.cp_link_tip_c));
        this.aaF.setOnTouchListener(new com.baidu.tieba.view.x(a));
        this.aaF.setText(a);
        com.baidu.tieba.card.at.a(this.aaF, biVar.getId(), w.e.cp_cont_b, w.e.cp_cont_d);
        if (biVar.sd() == null || biVar.sd().options_count.intValue() == 0) {
            this.bTM.setVisibility(8);
            this.bTN.setVisibility(8);
        } else {
            String string = this.ajT.getResources().getString(w.l.total_x_vote_option);
            this.bTM.setVisibility(0);
            this.bTM.setText(String.format(string, String.valueOf(biVar.sd().options_count)));
            if (StringUtils.isNull(biVar.sd().tips, true)) {
                this.bTN.setVisibility(8);
            } else {
                this.bTN.setVisibility(0);
                this.bTN.setText("(" + biVar.sd().tips + ")");
            }
        }
        if (this.brE.a(biVar)) {
            this.btm.setVisibility(8);
        } else {
            this.btm.setVisibility(0);
        }
        this.brE.setForumAfterClickListener(this.ama);
        this.brE.setStType(com.baidu.tieba.card.at.sf());
        t(biVar);
        this.bTn.A(this.aiB);
        p.a(this.aiB, this.bsk);
        onChangeSkinType(this.ajT, TbadkCoreApplication.m9getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((view == this.mRootView || view == this.brE.getCommentNumView() || view == this.bsk) && this.aiB != null) {
            if (this.aiB.sK() > 0 && com.baidu.tieba.tbadkCore.util.s.bjm()) {
                PbActivityConfig createHistoryCfg = new PbActivityConfig(this.ajT.getPageActivity()).createHistoryCfg(this.aiB.getTid(), String.valueOf(this.aiB.sK()), false, true, null);
                createHistoryCfg.setFromSmartFrs(this.aiB.tr());
                createHistoryCfg.setSmartFrsPosition(this.aiB.tu());
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createHistoryCfg));
                return;
            }
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.ajT.getPageActivity()).createFromThreadCfg(this.aiB, this.mForumName, null, 18003, true, false, false);
            createFromThreadCfg.setFromSmartFrs(this.aiB.tr());
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.brE != null && this.bsD != null) {
            this.bsD.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.bsD);
        }
    }

    @Override // com.baidu.tieba.card.cd
    public void setForumName(String str) {
        this.mForumName = str;
    }
}
