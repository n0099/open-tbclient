package com.baidu.tieba.frs.entelechy.c;

import android.view.View;
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
import com.baidu.tbadk.core.data.ax;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.UserIconLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.t;
import java.util.ArrayList;
/* loaded from: classes.dex */
public abstract class am extends com.baidu.tieba.card.a<ax> {
    protected TbPageContext<?> DV;
    protected TextView RX;
    public ThreadCommentAndPraiseInfoLayout aOO;
    protected View aQI;
    private CustomMessageListener aQc;
    public UserIconLayout aQp;
    protected ax aab;
    private final View.OnClickListener adK;
    private final View.OnClickListener adn;
    public TbImageView bkR;
    public RelativeLayout bpJ;
    public ClickableHeaderImageView bpV;
    protected TextView bpW;
    protected TextView bpX;
    protected boolean mIsFromCDN;
    protected View mRootView;
    private int mSkinType;

    protected abstract void gA(int i);

    protected abstract void k(ax axVar);

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
        this.aQc = new an(this, CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR);
        this.adK = new ao(this);
        this.adn = new ap(this);
        this.DV = tbPageContext;
        initView();
    }

    public void initView() {
        this.mRootView = getView();
        this.aQI = this.mRootView.findViewById(t.g.card_vote_top_line);
        this.bpV = (ClickableHeaderImageView) this.mRootView.findViewById(t.g.card_vote_header_image);
        this.bpV.setDefaultResource(17170445);
        this.bpV.setDefaultErrorResource(t.f.icon_default_avatar100);
        this.bpV.setDefaultBgResource(t.d.cp_bg_line_e);
        this.bpV.setRadius(com.baidu.adp.lib.util.k.c(this.DV.getPageActivity(), t.e.ds70));
        this.aQp = (UserIconLayout) this.mRootView.findViewById(t.g.user_icon);
        this.aQp.adJ = true;
        this.aQp.setEntelechyEnabled(true);
        this.aQp.setPageName(1);
        this.bkR = (TbImageView) this.mRootView.findViewById(t.g.theme_card_view);
        this.RX = (TextView) this.mRootView.findViewById(t.g.vote_thread_title);
        this.bpW = (TextView) this.mRootView.findViewById(t.g.vote_total_option_num);
        this.bpX = (TextView) this.mRootView.findViewById(t.g.vote_now_state);
        this.aOO = (ThreadCommentAndPraiseInfoLayout) this.mRootView.findViewById(t.g.thread_more_info);
        this.bpJ = (RelativeLayout) this.mRootView.findViewById(t.g.card_home_page_normal_thread_root_content);
    }

    public final void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.at.k(getView(), t.f.addresslist_item_bg);
            com.baidu.tbadk.core.util.at.l(this.aQI, t.d.cp_bg_line_b);
            this.aQp.sg();
            this.aOO.sg();
            com.baidu.tbadk.core.util.at.c(this.bpW, t.d.cp_cont_c, 1);
            com.baidu.tbadk.core.util.at.c(this.bpX, t.d.cp_cont_d, 1);
            gA(i);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int JP() {
        return t.h.card_vote_item;
    }

    public final void h(ax axVar) {
        if (axVar == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        this.aab = axVar;
        if (getView() != null) {
            getView().setVisibility(0);
        }
        this.bpV.setVisibility(0);
        this.bpV.setData(axVar);
        this.bpV.setAfterClickListener(this.adK);
        this.aQp.setVisibility(0);
        this.aQp.setData(axVar);
        this.aQp.setUserAfterClickListener(this.adK);
        this.aOO.setData(axVar);
        ArrayList arrayList = new ArrayList();
        if (axVar.getIs_good() == 1) {
            arrayList.add(Integer.valueOf(t.j.good));
        }
        arrayList.add(Integer.valueOf(t.j.vote));
        this.RX.setText(com.baidu.tieba.card.au.a(getContext(), String.valueOf(axVar.getTitle()) + " ", arrayList, -2));
        com.baidu.tieba.card.au.a(this.RX, axVar.getId(), t.d.cp_cont_b, t.d.cp_cont_d);
        if (axVar.qM() == null || axVar.qM().options_count.intValue() == 0) {
            this.bpW.setVisibility(8);
            this.bpX.setVisibility(8);
        } else {
            String string = this.DV.getResources().getString(t.j.total_x_vote_option);
            this.bpW.setVisibility(0);
            this.bpW.setText(String.format(string, axVar.qM().options_count));
            if (StringUtils.isNull(axVar.qM().tips, true)) {
                this.bpX.setVisibility(8);
            } else {
                this.bpX.setVisibility(0);
                this.bpX.setText("(" + axVar.qM().tips + ")");
            }
        }
        this.aOO.setData(this.aab);
        this.aOO.setForumAfterClickListener(this.adn);
        this.aOO.setStType(com.baidu.tieba.card.au.Kd());
        k(axVar);
        d(this.DV, TbadkCoreApplication.m11getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((view == this.mRootView || view == this.aOO.getCommentNumView()) && this.aab != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.DV.getPageActivity()).createFromThreadCfg(this.aab, this.aab.qQ(), null, 18003, true, false, false)));
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.aOO != null && this.aQc != null) {
            this.aQc.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.aQc);
        }
    }
}
