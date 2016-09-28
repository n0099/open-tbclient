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
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.UserIconLayout;
import com.baidu.tbadk.data.UserTbVipInfoData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.an;
import com.baidu.tieba.r;
import com.baidu.tieba.view.GuessYourLikeHeaderView;
import java.util.ArrayList;
/* loaded from: classes.dex */
public abstract class ap extends com.baidu.tieba.card.a<bi> implements az {
    protected TbPageContext<?> GM;
    protected TextView VW;
    public ViewStub aYH;
    public TbImageView aYI;
    public ThreadCommentAndPraiseInfoLayout aYR;
    private CustomMessageListener aZT;
    protected bi adW;
    private final View.OnClickListener ahd;
    private final View.OnClickListener ahz;
    public TbImageView bSf;
    public HeadPendantClickableView bXD;
    public ClickableHeaderImageView bXE;
    protected TextView bXF;
    protected TextView bXG;
    private GuessYourLikeHeaderView bXc;
    private View bXd;
    public RelativeLayout bXl;
    protected View baE;
    public UserIconLayout bak;
    private String mForumName;
    protected boolean mIsFromCDN;
    protected View mRootView;
    private int mSkinType;

    protected abstract void ik(int i);

    protected abstract void m(bi biVar);

    /* JADX INFO: Access modifiers changed from: protected */
    public int getSkinType() {
        return this.mSkinType;
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    public ap(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.mIsFromCDN = true;
        this.aZT = new aq(this, CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR);
        this.ahz = new ar(this);
        this.ahd = new as(this);
        this.GM = tbPageContext;
        initView();
    }

    public void initView() {
        this.mRootView = getView();
        this.baE = this.mRootView.findViewById(r.g.card_vote_top_line);
        this.bXE = (ClickableHeaderImageView) this.mRootView.findViewById(r.g.card_vote_header_image);
        this.bXD = (HeadPendantClickableView) this.mRootView.findViewById(r.g.card_vote_pendant_header_image);
        this.aYH = (ViewStub) this.mRootView.findViewById(r.g.viewstub_headimage_mask);
        this.bXE.setDefaultResource(17170445);
        this.bXE.setDefaultErrorResource(r.f.icon_default_avatar100);
        this.bXE.setDefaultBgResource(r.d.cp_bg_line_e);
        this.bXE.setRadius(com.baidu.adp.lib.util.k.e(this.GM.getPageActivity(), r.e.ds70));
        if (this.bXD.getHeadView() != null) {
            this.bXD.getHeadView().setDefaultResource(17170445);
            this.bXD.getHeadView().setDefaultErrorResource(r.f.icon_default_avatar100);
            this.bXD.getHeadView().setDefaultBgResource(r.d.cp_bg_line_e);
            this.bXD.getHeadView().setRadius(com.baidu.adp.lib.util.k.e(this.GM.getPageActivity(), r.e.ds70));
            this.bXD.getHeadView().setIsRound(true);
            this.bXD.getHeadView().setDrawBorder(false);
        }
        this.bXD.wk();
        if (this.bXD.getPendantView() != null) {
            this.bXD.getPendantView().setIsRound(true);
            this.bXD.getPendantView().setDrawBorder(false);
        }
        this.bak = (UserIconLayout) this.mRootView.findViewById(r.g.user_icon);
        this.bak.ahy = true;
        this.bak.setEntelechyEnabled(true);
        this.bak.setPageName(1);
        this.bSf = (TbImageView) this.mRootView.findViewById(r.g.theme_card_view);
        this.VW = (TextView) this.mRootView.findViewById(r.g.vote_thread_title);
        this.bXF = (TextView) this.mRootView.findViewById(r.g.vote_total_option_num);
        this.bXG = (TextView) this.mRootView.findViewById(r.g.vote_now_state);
        this.aYR = (ThreadCommentAndPraiseInfoLayout) this.mRootView.findViewById(r.g.thread_more_info);
        this.bXl = (RelativeLayout) this.mRootView.findViewById(r.g.card_home_page_normal_thread_root_content);
        this.bXc = (GuessYourLikeHeaderView) this.mRootView.findViewById(r.g.guess_your_like_header);
        this.bXd = this.mRootView.findViewById(r.g.guess_your_like_bottom_line);
    }

    @Override // com.baidu.tieba.card.a
    public final void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            av.k(getView(), r.f.addresslist_item_bg);
            av.l(this.baE, r.d.cp_bg_line_b);
            this.bak.tx();
            this.aYR.tx();
            av.c(this.bXF, r.d.cp_cont_c, 1);
            av.c(this.bXG, r.d.cp_cont_d, 1);
            ik(i);
            if (this.bXc != null) {
                this.bXc.tx();
            }
            av.l(this.bXd, r.d.cp_bg_line_c);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return r.h.card_vote_item;
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
        this.adW = biVar;
        if (getView() != null) {
            getView().setVisibility(0);
        }
        if (this.adW.getAuthor() == null || this.adW.getAuthor().getPendantData() == null || StringUtils.isNull(this.adW.getAuthor().getPendantData().pO())) {
            UserTbVipInfoData rO = this.adW.rO();
            if (rO != null && rO.getvipV_url() != null) {
                if (this.aYH != null) {
                    if (this.aYI == null) {
                        this.aYH.inflate();
                        this.aYI = (TbImageView) getView().findViewById(r.g.user_head_mask);
                    }
                    this.aYI.setVisibility(0);
                    this.aYI.c(rO.getvipV_url(), 10, false);
                    this.bXE.setIsBigV(true);
                }
            } else {
                this.bXE.setIsBigV(false);
                if (this.aYI != null) {
                    this.aYI.setVisibility(8);
                }
            }
            this.bXD.setVisibility(8);
            this.bXE.setVisibility(0);
            this.bXE.setData(biVar);
        } else {
            this.bXE.setIsBigV(false);
            if (this.aYI != null) {
                this.aYI.setVisibility(8);
            }
            this.bXD.setVisibility(0);
            this.bXE.setVisibility(4);
            this.bXD.setData(biVar);
        }
        this.bXE.setAfterClickListener(this.ahz);
        this.bak.setVisibility(0);
        this.bak.setData(biVar);
        this.bak.setUserAfterClickListener(this.ahz);
        this.aYR.setData(biVar);
        ArrayList arrayList = new ArrayList();
        if (biVar.rK() == 1) {
            arrayList.add(new an.a(r.j.good));
        }
        arrayList.add(new an.a(r.j.vote));
        SpannableStringBuilder a = com.baidu.tieba.card.an.a((Context) TbadkCoreApplication.m9getInst(), biVar.getTitle(), (ArrayList<an.a>) arrayList, false);
        a.append((CharSequence) biVar.a(new SpannableString(String.valueOf(biVar.g(biVar.getTitle(), false)) + " "), false));
        this.VW.setLinkTextColor(getContext().getResources().getColor(r.d.cp_link_tip_c));
        this.VW.setOnTouchListener(new com.baidu.tieba.view.y(a));
        this.VW.setText(a);
        com.baidu.tieba.card.an.a(this.VW, biVar.getId(), r.d.cp_cont_b, r.d.cp_cont_d);
        if (biVar.rE() == null || biVar.rE().options_count.intValue() == 0) {
            this.bXF.setVisibility(8);
            this.bXG.setVisibility(8);
        } else {
            String string = this.GM.getResources().getString(r.j.total_x_vote_option);
            this.bXF.setVisibility(0);
            this.bXF.setText(String.format(string, biVar.rE().options_count));
            if (StringUtils.isNull(biVar.rE().tips, true)) {
                this.bXG.setVisibility(8);
            } else {
                this.bXG.setVisibility(0);
                this.bXG.setText("(" + biVar.rE().tips + ")");
            }
        }
        this.aYR.setData(this.adW);
        this.aYR.setForumAfterClickListener(this.ahd);
        this.aYR.setStType(com.baidu.tieba.card.an.Od());
        m(biVar);
        if (this.bXc != null) {
            if ((this.adW.sk() || this.adW.sl()) && com.baidu.tieba.tbadkCore.util.t.bkQ()) {
                this.bXc.setTitleText(StringUtils.isNull(this.adW.sj()) ? getContext().getResources().getString(r.j.group_fourm_recommend_title) : this.adW.sj());
                this.bXc.show();
                this.baE.setVisibility(8);
                if (this.bXd != null) {
                    this.bXd.setVisibility(0);
                }
                if (this.adW.bbL) {
                    this.bXc.bqS();
                } else {
                    this.bXc.bqR();
                    if (this.adW.bbM) {
                        this.baE.setVisibility(0);
                    }
                }
            } else {
                this.bXc.hide();
                this.baE.setVisibility(0);
                if (this.bXd != null) {
                    this.bXd.setVisibility(8);
                }
            }
        }
        onChangeSkinType(this.GM, TbadkCoreApplication.m9getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((view == this.mRootView || view == this.aYR.getCommentNumView()) && this.adW != null) {
            if (this.adW.sh() > 0 && com.baidu.tieba.tbadkCore.util.t.bkQ()) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.GM.getPageActivity()).createHistoryCfg(this.adW.getTid(), String.valueOf(this.adW.sh()), false, true, null)));
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.GM.getPageActivity()).createFromThreadCfg(this.adW, this.mForumName, null, 18003, true, false, false)));
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.aYR != null && this.aZT != null) {
            this.aZT.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.aZT);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.view.az
    public void setForumName(String str) {
        this.mForumName = str;
    }
}
