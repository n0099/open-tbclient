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
import com.baidu.tbadk.core.data.bm;
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
public abstract class ao extends com.baidu.tieba.card.a<bm> implements cg {
    protected TextView aab;
    protected bm aiu;
    protected TbPageContext<?> ajP;
    private final View.OnClickListener amF;
    public ViewStub amP;
    public TbImageView amQ;
    private final View.OnClickListener amS;
    public View bAx;
    private CardGroupDividerView bBg;
    private CustomMessageListener bBt;
    public ThreadCommentAndPraiseInfoLayout bCq;
    public UserIconLayout bCt;
    public TbImageView cee;
    public RelativeLayout chE;
    private com.baidu.tieba.frs.f.v chz;
    public HeadPendantClickableView cia;
    public ClickableHeaderImageView cib;
    protected TextView cic;
    protected TextView cie;
    private String mForumName;
    protected boolean mIsFromCDN;
    protected View mRootView;
    private int mSkinType;

    protected abstract void D(bm bmVar);

    protected abstract void iM(int i);

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
        this.bBt = new ap(this, CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR);
        this.amS = new aq(this);
        this.amF = new ar(this);
        setTag(bdUniqueId);
        this.ajP = tbPageContext;
        initView();
    }

    public void initView() {
        this.mRootView = getView();
        this.cib = (ClickableHeaderImageView) this.mRootView.findViewById(w.h.card_vote_header_image);
        this.cia = (HeadPendantClickableView) this.mRootView.findViewById(w.h.card_vote_pendant_header_image);
        this.amP = (ViewStub) this.mRootView.findViewById(w.h.viewstub_headimage_mask);
        this.cib.setDefaultResource(17170445);
        this.cib.setDefaultErrorResource(w.g.icon_default_avatar100);
        this.cib.setDefaultBgResource(w.e.cp_bg_line_e);
        this.cib.setRadius(com.baidu.adp.lib.util.k.g(this.ajP.getPageActivity(), w.f.ds70));
        if (this.cia.getHeadView() != null) {
            this.cia.getHeadView().setDefaultResource(17170445);
            this.cia.getHeadView().setDefaultErrorResource(w.g.icon_default_avatar100);
            this.cia.getHeadView().setDefaultBgResource(w.e.cp_bg_line_e);
            this.cia.getHeadView().setRadius(com.baidu.adp.lib.util.k.g(this.ajP.getPageActivity(), w.f.ds70));
            this.cia.getHeadView().setIsRound(true);
            this.cia.getHeadView().setDrawBorder(false);
        }
        this.cia.wm();
        if (this.cia.getPendantView() != null) {
            this.cia.getPendantView().setIsRound(true);
            this.cia.getPendantView().setDrawBorder(false);
        }
        this.bCt = (UserIconLayout) this.mRootView.findViewById(w.h.user_icon);
        this.bCt.any = true;
        this.bCt.setEntelechyEnabled(true);
        this.bCt.setPageName(1);
        this.cee = (TbImageView) this.mRootView.findViewById(w.h.theme_card_view);
        this.cee.setPageId(getTag());
        this.aab = (TextView) this.mRootView.findViewById(w.h.vote_thread_title);
        this.cic = (TextView) this.mRootView.findViewById(w.h.vote_total_option_num);
        this.cie = (TextView) this.mRootView.findViewById(w.h.vote_now_state);
        this.bCq = (ThreadCommentAndPraiseInfoLayout) this.mRootView.findViewById(w.h.thread_more_info);
        this.bAx = this.mRootView.findViewById(w.h.divider_below_reply_number_layout);
        this.chE = (RelativeLayout) this.mRootView.findViewById(w.h.card_home_page_normal_thread_root_content);
        this.bBg = (CardGroupDividerView) this.mRootView.findViewById(w.h.header_divider);
        this.bBg.setTitleClickListener(this);
        this.bCq.setViewNumEnabled(true);
        this.chz = new com.baidu.tieba.frs.f.v(this.ajP, this.bCq);
        this.chz.setUniqueId(getTag());
    }

    @Override // com.baidu.tieba.card.a
    public final void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.as.j(getView(), w.g.addresslist_item_bg);
            this.bCt.onChangeSkinType();
            this.bCq.onChangeSkinType();
            com.baidu.tbadk.core.util.as.c(this.cic, w.e.cp_cont_c, 1);
            com.baidu.tbadk.core.util.as.c(this.cie, w.e.cp_cont_d, 1);
            iM(i);
            if (this.bBg != null) {
                this.bBg.onChangeSkinType();
            }
            this.chz.onChangeSkinType();
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return w.j.card_vote_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: t */
    public final void a(bm bmVar) {
        if (bmVar == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        this.aiu = bmVar;
        if (getView() != null) {
            getView().setVisibility(0);
        }
        if (this.aiu.getAuthor() == null || this.aiu.getAuthor().getPendantData() == null || StringUtils.isNull(this.aiu.getAuthor().getPendantData().pI())) {
            UserTbVipInfoData rr = this.aiu.rr();
            if (rr != null && rr.getvipV_url() != null) {
                if (this.amP != null) {
                    if (this.amQ == null) {
                        this.amP.inflate();
                        this.amQ = (TbImageView) getView().findViewById(w.h.user_head_mask);
                    }
                    this.amQ.setPageId(getTag());
                    this.amQ.setVisibility(0);
                    this.amQ.c(rr.getvipV_url(), 10, false);
                    this.cib.setIsBigV(true);
                }
            } else {
                this.cib.setIsBigV(false);
                if (this.amQ != null) {
                    this.amQ.setVisibility(8);
                }
            }
            this.cia.setVisibility(8);
            this.cib.setVisibility(0);
            this.cib.setData(bmVar);
        } else {
            this.cib.setIsBigV(false);
            if (this.amQ != null) {
                this.amQ.setVisibility(8);
            }
            this.cia.setVisibility(0);
            this.cib.setVisibility(4);
            this.cia.setData(bmVar);
        }
        this.cib.setAfterClickListener(this.amS);
        this.bCt.setVisibility(0);
        if (bmVar.getAuthor() != null && !StringUtils.isNull(bmVar.getAuthor().getSealPrefix())) {
            this.bCt.aO(true);
        }
        this.bCt.setData(bmVar);
        this.bCt.setUserAfterClickListener(this.amS);
        ArrayList arrayList = new ArrayList();
        if (bmVar.rn() == 1) {
            arrayList.add(new at.a(w.l.good));
        }
        SpannableStringBuilder a = com.baidu.tieba.card.at.a((Context) TbadkCoreApplication.m9getInst(), bmVar.getTitle(), (ArrayList<at.a>) arrayList, false);
        a.append((CharSequence) bmVar.a(new SpannableString(String.valueOf(bmVar.g(bmVar.getTitle(), false)) + " ")));
        this.aab.setLinkTextColor(getContext().getResources().getColor(w.e.cp_link_tip_c));
        this.aab.setOnTouchListener(new com.baidu.tieba.view.aa(a));
        this.aab.setText(a);
        com.baidu.tieba.card.at.a(this.aab, bmVar.getId(), w.e.cp_cont_b, w.e.cp_cont_d);
        if (bmVar.rg() == null || bmVar.rg().options_count.intValue() == 0) {
            this.cic.setVisibility(8);
            this.cie.setVisibility(8);
        } else {
            String string = this.ajP.getResources().getString(w.l.total_x_vote_option);
            this.cic.setVisibility(0);
            this.cic.setText(String.format(string, String.valueOf(bmVar.rg().options_count)));
            if (StringUtils.isNull(bmVar.rg().tips, true)) {
                this.cie.setVisibility(8);
            } else {
                this.cie.setVisibility(0);
                this.cie.setText("(" + bmVar.rg().tips + ")");
            }
        }
        if (this.bCq.a(bmVar)) {
            this.bAx.setVisibility(8);
        } else {
            this.bAx.setVisibility(0);
        }
        this.bCq.setForumAfterClickListener(this.amF);
        this.bCq.setStType(com.baidu.tieba.card.at.ri());
        D(bmVar);
        this.chz.L(this.aiu);
        p.a(this.aiu, this.bBg);
        d(this.ajP, TbadkCoreApplication.m9getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((view == this.mRootView || view == this.bCq.getCommentNumView() || view == this.bBg) && this.aiu != null) {
            if (this.aiu.rN() > 0 && com.baidu.tieba.tbadkCore.util.s.bns()) {
                PbActivityConfig createHistoryCfg = new PbActivityConfig(this.ajP.getPageActivity()).createHistoryCfg(this.aiu.getTid(), String.valueOf(this.aiu.rN()), false, true, null);
                createHistoryCfg.setFromSmartFrs(this.aiu.su());
                createHistoryCfg.setSmartFrsPosition(this.aiu.sA());
                createHistoryCfg.setForumId(String.valueOf(this.aiu.getFid()));
                createHistoryCfg.setStartFrom(1);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createHistoryCfg));
                return;
            }
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.ajP.getPageActivity()).createFromThreadCfg(this.aiu, this.mForumName, null, 18003, true, false, false);
            createFromThreadCfg.setFromSmartFrs(this.aiu.su());
            createFromThreadCfg.setForumId(String.valueOf(this.aiu.getFid()));
            createFromThreadCfg.setStartFrom(1);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.bCq != null && this.bBt != null) {
            this.bBt.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.bBt);
        }
    }

    @Override // com.baidu.tieba.card.cg
    public void setForumName(String str) {
        this.mForumName = str;
    }
}
