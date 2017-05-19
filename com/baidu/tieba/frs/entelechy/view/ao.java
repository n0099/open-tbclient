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
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.UserIconLayout;
import com.baidu.tbadk.data.UserTbVipInfoData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.ap;
import com.baidu.tieba.card.cb;
import com.baidu.tieba.card.divider.CardGroupDividerView;
import com.baidu.tieba.w;
import java.util.ArrayList;
/* loaded from: classes.dex */
public abstract class ao extends com.baidu.tieba.card.a<bk> implements cb {
    public ClickableHeaderImageView aSp;
    protected TextView aab;
    protected bk ahV;
    protected TbPageContext<?> ajr;
    private final View.OnClickListener alY;
    public ViewStub amh;
    public TbImageView ami;
    private final View.OnClickListener amk;
    public TbImageView bQf;
    public RelativeLayout bTD;
    public HeadPendantClickableView bTZ;
    private com.baidu.tieba.frs.e.ae bTy;
    protected TextView bUa;
    protected TextView bUb;
    private CardGroupDividerView buA;
    public View buR;
    private CustomMessageListener buT;
    public ThreadCommentAndPraiseInfoLayout bvN;
    public UserIconLayout bvQ;
    private String mForumName;
    protected boolean mIsFromCDN;
    protected View mRootView;
    private int mSkinType;

    protected abstract void ic(int i);

    protected abstract void x(bk bkVar);

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
        this.buT = new ap(this, CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR);
        this.amk = new aq(this);
        this.alY = new ar(this);
        setTag(bdUniqueId);
        this.ajr = tbPageContext;
        initView();
    }

    public void initView() {
        this.mRootView = getView();
        this.aSp = (ClickableHeaderImageView) this.mRootView.findViewById(w.h.card_vote_header_image);
        this.bTZ = (HeadPendantClickableView) this.mRootView.findViewById(w.h.card_vote_pendant_header_image);
        this.amh = (ViewStub) this.mRootView.findViewById(w.h.viewstub_headimage_mask);
        this.aSp.setDefaultResource(17170445);
        this.aSp.setDefaultErrorResource(w.g.icon_default_avatar100);
        this.aSp.setDefaultBgResource(w.e.cp_bg_line_e);
        this.aSp.setRadius(com.baidu.adp.lib.util.k.g(this.ajr.getPageActivity(), w.f.ds70));
        if (this.bTZ.getHeadView() != null) {
            this.bTZ.getHeadView().setDefaultResource(17170445);
            this.bTZ.getHeadView().setDefaultErrorResource(w.g.icon_default_avatar100);
            this.bTZ.getHeadView().setDefaultBgResource(w.e.cp_bg_line_e);
            this.bTZ.getHeadView().setRadius(com.baidu.adp.lib.util.k.g(this.ajr.getPageActivity(), w.f.ds70));
            this.bTZ.getHeadView().setIsRound(true);
            this.bTZ.getHeadView().setDrawBorder(false);
        }
        this.bTZ.vY();
        if (this.bTZ.getPendantView() != null) {
            this.bTZ.getPendantView().setIsRound(true);
            this.bTZ.getPendantView().setDrawBorder(false);
        }
        this.bvQ = (UserIconLayout) this.mRootView.findViewById(w.h.user_icon);
        this.bvQ.amE = true;
        this.bvQ.setEntelechyEnabled(true);
        this.bvQ.setPageName(1);
        this.bQf = (TbImageView) this.mRootView.findViewById(w.h.theme_card_view);
        this.bQf.setPageId(getTag());
        this.aab = (TextView) this.mRootView.findViewById(w.h.vote_thread_title);
        this.bUa = (TextView) this.mRootView.findViewById(w.h.vote_total_option_num);
        this.bUb = (TextView) this.mRootView.findViewById(w.h.vote_now_state);
        this.bvN = (ThreadCommentAndPraiseInfoLayout) this.mRootView.findViewById(w.h.thread_more_info);
        this.buR = this.mRootView.findViewById(w.h.divider_below_reply_number_layout);
        this.bTD = (RelativeLayout) this.mRootView.findViewById(w.h.card_home_page_normal_thread_root_content);
        this.buA = (CardGroupDividerView) this.mRootView.findViewById(w.h.header_divider);
        this.buA.setTitleClickListener(this);
        this.bvN.setViewNumEnabled(true);
        this.bTy = new com.baidu.tieba.frs.e.ae(this.ajr, this.bvN);
        this.bTy.setUniqueId(getTag());
    }

    @Override // com.baidu.tieba.card.a
    public final void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.aq.j(getView(), w.g.addresslist_item_bg);
            this.bvQ.onChangeSkinType();
            this.bvN.onChangeSkinType();
            com.baidu.tbadk.core.util.aq.c(this.bUa, w.e.cp_cont_c, 1);
            com.baidu.tbadk.core.util.aq.c(this.bUb, w.e.cp_cont_d, 1);
            ic(i);
            if (this.buA != null) {
                this.buA.onChangeSkinType();
            }
            this.bTy.onChangeSkinType();
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return w.j.card_vote_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: p */
    public final void onBindDataToView(bk bkVar) {
        if (bkVar == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        this.ahV = bkVar;
        if (getView() != null) {
            getView().setVisibility(0);
        }
        if (this.ahV.getAuthor() == null || this.ahV.getAuthor().getPendantData() == null || StringUtils.isNull(this.ahV.getAuthor().getPendantData().pT())) {
            UserTbVipInfoData rz = this.ahV.rz();
            if (rz != null && rz.getvipV_url() != null) {
                if (this.amh != null) {
                    if (this.ami == null) {
                        this.amh.inflate();
                        this.ami = (TbImageView) getView().findViewById(w.h.user_head_mask);
                    }
                    this.ami.setPageId(getTag());
                    this.ami.setVisibility(0);
                    this.ami.c(rz.getvipV_url(), 10, false);
                    this.aSp.setIsBigV(true);
                }
            } else {
                this.aSp.setIsBigV(false);
                if (this.ami != null) {
                    this.ami.setVisibility(8);
                }
            }
            this.bTZ.setVisibility(8);
            this.aSp.setVisibility(0);
            this.aSp.setData(bkVar);
        } else {
            this.aSp.setIsBigV(false);
            if (this.ami != null) {
                this.ami.setVisibility(8);
            }
            this.bTZ.setVisibility(0);
            this.aSp.setVisibility(4);
            this.bTZ.setData(bkVar);
        }
        this.aSp.setAfterClickListener(this.amk);
        this.bvQ.setVisibility(0);
        if (bkVar.getAuthor() != null && !StringUtils.isNull(bkVar.getAuthor().getSealPrefix())) {
            this.bvQ.aP(true);
        }
        this.bvQ.setData(bkVar);
        this.bvQ.setUserAfterClickListener(this.amk);
        ArrayList arrayList = new ArrayList();
        if (bkVar.rv() == 1) {
            arrayList.add(new ap.a(w.l.good));
        }
        SpannableStringBuilder a = com.baidu.tieba.card.ap.a((Context) TbadkCoreApplication.m9getInst(), bkVar.getTitle(), (ArrayList<ap.a>) arrayList, false);
        a.append((CharSequence) bkVar.a(new SpannableString(String.valueOf(bkVar.g(bkVar.getTitle(), false)) + " "), false));
        this.aab.setLinkTextColor(getContext().getResources().getColor(w.e.cp_link_tip_c));
        this.aab.setOnTouchListener(new com.baidu.tieba.view.aa(a));
        this.aab.setText(a);
        com.baidu.tieba.card.ap.a(this.aab, bkVar.getId(), w.e.cp_cont_b, w.e.cp_cont_d);
        if (bkVar.rn() == null || bkVar.rn().options_count.intValue() == 0) {
            this.bUa.setVisibility(8);
            this.bUb.setVisibility(8);
        } else {
            String string = this.ajr.getResources().getString(w.l.total_x_vote_option);
            this.bUa.setVisibility(0);
            this.bUa.setText(String.format(string, String.valueOf(bkVar.rn().options_count)));
            if (StringUtils.isNull(bkVar.rn().tips, true)) {
                this.bUb.setVisibility(8);
            } else {
                this.bUb.setVisibility(0);
                this.bUb.setText("(" + bkVar.rn().tips + ")");
            }
        }
        if (this.bvN.a(bkVar)) {
            this.buR.setVisibility(8);
        } else {
            this.buR.setVisibility(0);
        }
        this.bvN.setForumAfterClickListener(this.alY);
        this.bvN.setStType(com.baidu.tieba.card.ap.rp());
        x(bkVar);
        this.bTy.F(this.ahV);
        p.a(this.ahV, this.buA);
        onChangeSkinType(this.ajr, TbadkCoreApplication.m9getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((view == this.mRootView || view == this.bvN.getCommentNumView() || view == this.buA) && this.ahV != null) {
            if (this.ahV.rU() > 0 && com.baidu.tieba.tbadkCore.util.s.bhK()) {
                PbActivityConfig createHistoryCfg = new PbActivityConfig(this.ajr.getPageActivity()).createHistoryCfg(this.ahV.getTid(), String.valueOf(this.ahV.rU()), false, true, null);
                createHistoryCfg.setFromSmartFrs(this.ahV.sB());
                createHistoryCfg.setSmartFrsPosition(this.ahV.sE());
                createHistoryCfg.setForumId(String.valueOf(this.ahV.getFid()));
                createHistoryCfg.setStartFrom(1);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createHistoryCfg));
                return;
            }
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.ajr.getPageActivity()).createFromThreadCfg(this.ahV, this.mForumName, null, 18003, true, false, false);
            createFromThreadCfg.setFromSmartFrs(this.ahV.sB());
            createFromThreadCfg.setForumId(String.valueOf(this.ahV.getFid()));
            createFromThreadCfg.setStartFrom(1);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.bvN != null && this.buT != null) {
            this.buT.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.buT);
        }
    }

    @Override // com.baidu.tieba.card.cb
    public void setForumName(String str) {
        this.mForumName = str;
    }
}
