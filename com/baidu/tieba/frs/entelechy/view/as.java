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
    public ClickableHeaderImageView aRU;
    protected TextView aaG;
    protected bi aiC;
    protected TbPageContext<?> ajU;
    private final View.OnClickListener ama;
    private final View.OnClickListener amx;
    public TbImageView bRo;
    private com.baidu.tieba.frs.g.af bVE;
    public RelativeLayout bVM;
    public HeadPendantClickableView bWc;
    protected TextView bWd;
    protected TextView bWe;
    public ViewStub bbW;
    public TbImageView bbX;
    public ThreadCommentAndPraiseInfoLayout btW;
    private CardGroupDividerView buD;
    private CustomMessageListener buW;
    public View bvF;
    public UserIconLayout bvG;
    private String mForumName;
    protected boolean mIsFromCDN;
    protected View mRootView;
    private int mSkinType;

    protected abstract void im(int i);

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
        this.buW = new at(this, CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR);
        this.amx = new au(this);
        this.ama = new av(this);
        this.ajU = tbPageContext;
        initView();
    }

    public void initView() {
        this.mRootView = getView();
        this.aRU = (ClickableHeaderImageView) this.mRootView.findViewById(w.h.card_vote_header_image);
        this.bWc = (HeadPendantClickableView) this.mRootView.findViewById(w.h.card_vote_pendant_header_image);
        this.bbW = (ViewStub) this.mRootView.findViewById(w.h.viewstub_headimage_mask);
        this.aRU.setDefaultResource(17170445);
        this.aRU.setDefaultErrorResource(w.g.icon_default_avatar100);
        this.aRU.setDefaultBgResource(w.e.cp_bg_line_e);
        this.aRU.setRadius(com.baidu.adp.lib.util.k.g(this.ajU.getPageActivity(), w.f.ds70));
        if (this.bWc.getHeadView() != null) {
            this.bWc.getHeadView().setDefaultResource(17170445);
            this.bWc.getHeadView().setDefaultErrorResource(w.g.icon_default_avatar100);
            this.bWc.getHeadView().setDefaultBgResource(w.e.cp_bg_line_e);
            this.bWc.getHeadView().setRadius(com.baidu.adp.lib.util.k.g(this.ajU.getPageActivity(), w.f.ds70));
            this.bWc.getHeadView().setIsRound(true);
            this.bWc.getHeadView().setDrawBorder(false);
        }
        this.bWc.wL();
        if (this.bWc.getPendantView() != null) {
            this.bWc.getPendantView().setIsRound(true);
            this.bWc.getPendantView().setDrawBorder(false);
        }
        this.bvG = (UserIconLayout) this.mRootView.findViewById(w.h.user_icon);
        this.bvG.amv = true;
        this.bvG.setEntelechyEnabled(true);
        this.bvG.setPageName(1);
        this.bRo = (TbImageView) this.mRootView.findViewById(w.h.theme_card_view);
        this.aaG = (TextView) this.mRootView.findViewById(w.h.vote_thread_title);
        this.bWd = (TextView) this.mRootView.findViewById(w.h.vote_total_option_num);
        this.bWe = (TextView) this.mRootView.findViewById(w.h.vote_now_state);
        this.btW = (ThreadCommentAndPraiseInfoLayout) this.mRootView.findViewById(w.h.thread_more_info);
        this.bvF = this.mRootView.findViewById(w.h.divider_below_reply_number_layout);
        this.bVM = (RelativeLayout) this.mRootView.findViewById(w.h.card_home_page_normal_thread_root_content);
        this.buD = (CardGroupDividerView) this.mRootView.findViewById(w.h.header_divider);
        this.buD.setTitleClickListener(this);
        this.btW.setViewNumEnabled(true);
        this.bVE = new com.baidu.tieba.frs.g.af(this.ajU, this.btW);
    }

    @Override // com.baidu.tieba.card.a
    public final void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.aq.j(getView(), w.g.addresslist_item_bg);
            this.bvG.onChangeSkinType();
            this.btW.onChangeSkinType();
            com.baidu.tbadk.core.util.aq.c(this.bWd, w.e.cp_cont_c, 1);
            com.baidu.tbadk.core.util.aq.c(this.bWe, w.e.cp_cont_d, 1);
            im(i);
            if (this.buD != null) {
                this.buD.onChangeSkinType();
            }
            this.bVE.onChangeSkinType();
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
        this.aiC = biVar;
        if (getView() != null) {
            getView().setVisibility(0);
        }
        if (this.aiC.getAuthor() == null || this.aiC.getAuthor().getPendantData() == null || StringUtils.isNull(this.aiC.getAuthor().getPendantData().qB())) {
            UserTbVipInfoData sp = this.aiC.sp();
            if (sp != null && sp.getvipV_url() != null) {
                if (this.bbW != null) {
                    if (this.bbX == null) {
                        this.bbW.inflate();
                        this.bbX = (TbImageView) getView().findViewById(w.h.user_head_mask);
                    }
                    this.bbX.setVisibility(0);
                    this.bbX.c(sp.getvipV_url(), 10, false);
                    this.aRU.setIsBigV(true);
                }
            } else {
                this.aRU.setIsBigV(false);
                if (this.bbX != null) {
                    this.bbX.setVisibility(8);
                }
            }
            this.bWc.setVisibility(8);
            this.aRU.setVisibility(0);
            this.aRU.setData(biVar);
        } else {
            this.aRU.setIsBigV(false);
            if (this.bbX != null) {
                this.bbX.setVisibility(8);
            }
            this.bWc.setVisibility(0);
            this.aRU.setVisibility(4);
            this.bWc.setData(biVar);
        }
        this.aRU.setAfterClickListener(this.amx);
        this.bvG.setVisibility(0);
        if (biVar.getAuthor() != null && !StringUtils.isNull(biVar.getAuthor().getSealPrefix())) {
            this.bvG.aP(true);
        }
        this.bvG.setData(biVar);
        this.bvG.setUserAfterClickListener(this.amx);
        ArrayList arrayList = new ArrayList();
        if (biVar.sl() == 1) {
            arrayList.add(new at.a(w.l.good));
        }
        SpannableStringBuilder a = com.baidu.tieba.card.at.a((Context) TbadkCoreApplication.m9getInst(), biVar.getTitle(), (ArrayList<at.a>) arrayList, false);
        a.append((CharSequence) biVar.a(new SpannableString(String.valueOf(biVar.g(biVar.getTitle(), false)) + " "), false));
        this.aaG.setLinkTextColor(getContext().getResources().getColor(w.e.cp_link_tip_c));
        this.aaG.setOnTouchListener(new com.baidu.tieba.view.x(a));
        this.aaG.setText(a);
        com.baidu.tieba.card.at.a(this.aaG, biVar.getId(), w.e.cp_cont_b, w.e.cp_cont_d);
        if (biVar.sd() == null || biVar.sd().options_count.intValue() == 0) {
            this.bWd.setVisibility(8);
            this.bWe.setVisibility(8);
        } else {
            String string = this.ajU.getResources().getString(w.l.total_x_vote_option);
            this.bWd.setVisibility(0);
            this.bWd.setText(String.format(string, String.valueOf(biVar.sd().options_count)));
            if (StringUtils.isNull(biVar.sd().tips, true)) {
                this.bWe.setVisibility(8);
            } else {
                this.bWe.setVisibility(0);
                this.bWe.setText("(" + biVar.sd().tips + ")");
            }
        }
        if (this.btW.a(biVar)) {
            this.bvF.setVisibility(8);
        } else {
            this.bvF.setVisibility(0);
        }
        this.btW.setForumAfterClickListener(this.ama);
        this.btW.setStType(com.baidu.tieba.card.at.sf());
        t(biVar);
        this.bVE.A(this.aiC);
        p.a(this.aiC, this.buD);
        onChangeSkinType(this.ajU, TbadkCoreApplication.m9getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((view == this.mRootView || view == this.btW.getCommentNumView() || view == this.buD) && this.aiC != null) {
            if (this.aiC.sK() > 0 && com.baidu.tieba.tbadkCore.util.s.bkn()) {
                PbActivityConfig createHistoryCfg = new PbActivityConfig(this.ajU.getPageActivity()).createHistoryCfg(this.aiC.getTid(), String.valueOf(this.aiC.sK()), false, true, null);
                createHistoryCfg.setFromSmartFrs(this.aiC.tr());
                createHistoryCfg.setSmartFrsPosition(this.aiC.tu());
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createHistoryCfg));
                return;
            }
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.ajU.getPageActivity()).createFromThreadCfg(this.aiC, this.mForumName, null, 18003, true, false, false);
            createFromThreadCfg.setFromSmartFrs(this.aiC.tr());
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.btW != null && this.buW != null) {
            this.buW.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.buW);
        }
    }

    @Override // com.baidu.tieba.card.cd
    public void setForumName(String str) {
        this.mForumName = str;
    }
}
