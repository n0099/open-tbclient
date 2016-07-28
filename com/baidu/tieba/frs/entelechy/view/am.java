package com.baidu.tieba.frs.entelechy.view;

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
import com.baidu.tbadk.core.data.be;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.UserIconLayout;
import com.baidu.tbadk.data.UserTbVipInfoData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.at;
import com.baidu.tieba.u;
import com.baidu.tieba.view.GuessYourLikeHeaderView;
import java.util.ArrayList;
/* loaded from: classes.dex */
public abstract class am extends com.baidu.tieba.card.a<be> implements aw {
    protected TbPageContext<?> EA;
    protected TextView SW;
    public ViewStub aSW;
    public TbImageView aSX;
    public ThreadCommentAndPraiseInfoLayout aTh;
    public UserIconLayout aUI;
    private CustomMessageListener aUs;
    protected View aVa;
    protected be abb;
    private final View.OnClickListener aeW;
    private final View.OnClickListener aez;
    public TbImageView bHg;
    private GuessYourLikeHeaderView bLR;
    private View bLS;
    public RelativeLayout bLY;
    public ClickableHeaderImageView bMq;
    protected TextView bMr;
    protected TextView bMs;
    private String mForumName;
    protected boolean mIsFromCDN;
    protected View mRootView;
    private int mSkinType;

    protected abstract void hD(int i);

    protected abstract void l(be beVar);

    /* JADX INFO: Access modifiers changed from: protected */
    public int getSkinType() {
        return this.mSkinType;
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    public am(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.mIsFromCDN = true;
        this.aUs = new an(this, CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR);
        this.aeW = new ao(this);
        this.aez = new ap(this);
        this.EA = tbPageContext;
        initView();
    }

    public void initView() {
        this.mRootView = getView();
        this.aVa = this.mRootView.findViewById(u.g.card_vote_top_line);
        this.bMq = (ClickableHeaderImageView) this.mRootView.findViewById(u.g.card_vote_header_image);
        this.aSW = (ViewStub) this.mRootView.findViewById(u.g.viewstub_headimage_mask);
        this.bMq.setDefaultResource(17170445);
        this.bMq.setDefaultErrorResource(u.f.icon_default_avatar100);
        this.bMq.setDefaultBgResource(u.d.cp_bg_line_e);
        this.bMq.setRadius(com.baidu.adp.lib.util.k.c(this.EA.getPageActivity(), u.e.ds70));
        this.aUI = (UserIconLayout) this.mRootView.findViewById(u.g.user_icon);
        this.aUI.aeV = true;
        this.aUI.setEntelechyEnabled(true);
        this.aUI.setPageName(1);
        this.bHg = (TbImageView) this.mRootView.findViewById(u.g.theme_card_view);
        this.SW = (TextView) this.mRootView.findViewById(u.g.vote_thread_title);
        this.bMr = (TextView) this.mRootView.findViewById(u.g.vote_total_option_num);
        this.bMs = (TextView) this.mRootView.findViewById(u.g.vote_now_state);
        this.aTh = (ThreadCommentAndPraiseInfoLayout) this.mRootView.findViewById(u.g.thread_more_info);
        this.bLY = (RelativeLayout) this.mRootView.findViewById(u.g.card_home_page_normal_thread_root_content);
        this.bLR = (GuessYourLikeHeaderView) this.mRootView.findViewById(u.g.guess_your_like_header);
        this.bLS = this.mRootView.findViewById(u.g.guess_your_like_bottom_line);
    }

    public final void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            av.k(getView(), u.f.addresslist_item_bg);
            av.l(this.aVa, u.d.cp_bg_line_b);
            this.aUI.sd();
            this.aTh.sd();
            av.c(this.bMr, u.d.cp_cont_c, 1);
            av.c(this.bMs, u.d.cp_cont_d, 1);
            hD(i);
            if (this.bLR != null) {
                this.bLR.sd();
            }
            av.l(this.bLS, u.d.cp_bg_line_c);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return u.h.card_vote_item;
    }

    public final void i(be beVar) {
        if (beVar == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        this.abb = beVar;
        if (getView() != null) {
            getView().setVisibility(0);
        }
        UserTbVipInfoData qx = this.abb.qx();
        if (qx != null && qx.getvipV_url() != null) {
            if (this.aSW != null) {
                if (this.aSX == null) {
                    this.aSW.inflate();
                    this.aSX = (TbImageView) getView().findViewById(u.g.user_head_mask);
                }
                this.aSX.setVisibility(0);
                this.aSX.c(qx.getvipV_url(), 10, false);
                this.bMq.setIsBigV(true);
            }
        } else {
            this.bMq.setIsBigV(false);
            if (this.aSX != null) {
                this.aSX.setVisibility(8);
            }
        }
        this.bMq.setVisibility(0);
        this.bMq.setData(beVar);
        this.bMq.setAfterClickListener(this.aeW);
        this.aUI.setVisibility(0);
        this.aUI.setData(beVar);
        this.aUI.setUserAfterClickListener(this.aeW);
        this.aTh.setData(beVar);
        ArrayList arrayList = new ArrayList();
        if (beVar.qu() == 1) {
            arrayList.add(Integer.valueOf(u.j.good));
        }
        arrayList.add(Integer.valueOf(u.j.vote));
        this.SW.setText(at.a(getContext(), String.valueOf(beVar.getTitle()) + " ", arrayList, -2));
        at.a(this.SW, beVar.getId(), u.d.cp_cont_b, u.d.cp_cont_d);
        if (beVar.qo() == null || beVar.qo().options_count.intValue() == 0) {
            this.bMr.setVisibility(8);
            this.bMs.setVisibility(8);
        } else {
            String string = this.EA.getResources().getString(u.j.total_x_vote_option);
            this.bMr.setVisibility(0);
            this.bMr.setText(String.format(string, beVar.qo().options_count));
            if (StringUtils.isNull(beVar.qo().tips, true)) {
                this.bMs.setVisibility(8);
            } else {
                this.bMs.setVisibility(0);
                this.bMs.setText("(" + beVar.qo().tips + ")");
            }
        }
        this.aTh.setData(this.abb);
        this.aTh.setForumAfterClickListener(this.aez);
        this.aTh.setStType(at.La());
        l(beVar);
        if (this.bLR != null) {
            if ((this.abb.qT() || this.abb.qU()) && com.baidu.tieba.tbadkCore.util.t.bgD()) {
                this.bLR.setTitleText(StringUtils.isNull(this.abb.qS()) ? getContext().getResources().getString(u.j.group_fourm_recommend_title) : this.abb.qS());
                this.bLR.show();
                this.aVa.setVisibility(8);
                if (this.bLS != null) {
                    this.bLS.setVisibility(0);
                }
                if (this.abb.aVQ) {
                    this.bLR.bmD();
                } else {
                    this.bLR.bmC();
                    if (this.abb.aVR) {
                        this.aVa.setVisibility(0);
                    }
                }
            } else {
                this.bLR.hide();
                this.aVa.setVisibility(0);
                if (this.bLS != null) {
                    this.bLS.setVisibility(8);
                }
            }
        }
        d(this.EA, TbadkCoreApplication.m10getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((view == this.mRootView || view == this.aTh.getCommentNumView()) && this.abb != null) {
            if (this.abb.qQ() > 0 && com.baidu.tieba.tbadkCore.util.t.bgD()) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.EA.getPageActivity()).createHistoryCfg(this.abb.getTid(), String.valueOf(this.abb.qQ()), false, true, null)));
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.EA.getPageActivity()).createFromThreadCfg(this.abb, this.mForumName, null, 18003, true, false, false)));
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.aTh != null && this.aUs != null) {
            this.aUs.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.aUs);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.view.aw
    public void setForumName(String str) {
        this.mForumName = str;
    }
}
