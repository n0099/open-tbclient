package com.baidu.tieba.frs.entelechy.view;

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
import com.baidu.tbadk.core.data.az;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.UserIconLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.at;
import com.baidu.tieba.u;
import java.util.ArrayList;
/* loaded from: classes.dex */
public abstract class ak extends com.baidu.tieba.card.a<az> implements au {
    protected TbPageContext<?> Ea;
    protected TextView So;
    public ThreadCommentAndPraiseInfoLayout aSl;
    public UserIconLayout aTM;
    private CustomMessageListener aTw;
    protected View aUe;
    protected az aas;
    private final View.OnClickListener adL;
    private final View.OnClickListener aei;
    public TbImageView bFR;
    public ClickableHeaderImageView bKG;
    protected TextView bKH;
    protected TextView bKI;
    public RelativeLayout bKq;
    private String mForumName;
    protected boolean mIsFromCDN;
    protected View mRootView;
    private int mSkinType;

    protected abstract void hD(int i);

    protected abstract void j(az azVar);

    /* JADX INFO: Access modifiers changed from: protected */
    public int getSkinType() {
        return this.mSkinType;
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    public ak(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.mIsFromCDN = true;
        this.aTw = new al(this, CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR);
        this.aei = new am(this);
        this.adL = new an(this);
        this.Ea = tbPageContext;
        initView();
    }

    public void initView() {
        this.mRootView = getView();
        this.aUe = this.mRootView.findViewById(u.g.card_vote_top_line);
        this.bKG = (ClickableHeaderImageView) this.mRootView.findViewById(u.g.card_vote_header_image);
        this.bKG.setDefaultResource(17170445);
        this.bKG.setDefaultErrorResource(u.f.icon_default_avatar100);
        this.bKG.setDefaultBgResource(u.d.cp_bg_line_e);
        this.bKG.setRadius(com.baidu.adp.lib.util.k.c(this.Ea.getPageActivity(), u.e.ds70));
        this.aTM = (UserIconLayout) this.mRootView.findViewById(u.g.user_icon);
        this.aTM.aeh = true;
        this.aTM.setEntelechyEnabled(true);
        this.aTM.setPageName(1);
        this.bFR = (TbImageView) this.mRootView.findViewById(u.g.theme_card_view);
        this.So = (TextView) this.mRootView.findViewById(u.g.vote_thread_title);
        this.bKH = (TextView) this.mRootView.findViewById(u.g.vote_total_option_num);
        this.bKI = (TextView) this.mRootView.findViewById(u.g.vote_now_state);
        this.aSl = (ThreadCommentAndPraiseInfoLayout) this.mRootView.findViewById(u.g.thread_more_info);
        this.bKq = (RelativeLayout) this.mRootView.findViewById(u.g.card_home_page_normal_thread_root_content);
    }

    public final void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            av.k(getView(), u.f.addresslist_item_bg);
            av.l(this.aUe, u.d.cp_bg_line_b);
            this.aTM.se();
            this.aSl.se();
            av.c(this.bKH, u.d.cp_cont_c, 1);
            av.c(this.bKI, u.d.cp_cont_d, 1);
            hD(i);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return u.h.card_vote_item;
    }

    public final void h(az azVar) {
        if (azVar == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        this.aas = azVar;
        if (getView() != null) {
            getView().setVisibility(0);
        }
        this.bKG.setVisibility(0);
        this.bKG.setData(azVar);
        this.bKG.setAfterClickListener(this.aei);
        this.aTM.setVisibility(0);
        this.aTM.setData(azVar);
        this.aTM.setUserAfterClickListener(this.aei);
        this.aSl.setData(azVar);
        ArrayList arrayList = new ArrayList();
        if (azVar.getIs_good() == 1) {
            arrayList.add(Integer.valueOf(u.j.good));
        }
        arrayList.add(Integer.valueOf(u.j.vote));
        this.So.setText(at.a(getContext(), String.valueOf(azVar.getTitle()) + " ", arrayList, -2));
        at.a(this.So, azVar.getId(), u.d.cp_cont_b, u.d.cp_cont_d);
        if (azVar.qF() == null || azVar.qF().options_count.intValue() == 0) {
            this.bKH.setVisibility(8);
            this.bKI.setVisibility(8);
        } else {
            String string = this.Ea.getResources().getString(u.j.total_x_vote_option);
            this.bKH.setVisibility(0);
            this.bKH.setText(String.format(string, azVar.qF().options_count));
            if (StringUtils.isNull(azVar.qF().tips, true)) {
                this.bKI.setVisibility(8);
            } else {
                this.bKI.setVisibility(0);
                this.bKI.setText("(" + azVar.qF().tips + ")");
            }
        }
        this.aSl.setData(this.aas);
        this.aSl.setForumAfterClickListener(this.adL);
        this.aSl.setStType(at.Lb());
        j(azVar);
        d(this.Ea, TbadkCoreApplication.m9getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((view == this.mRootView || view == this.aSl.getCommentNumView()) && this.aas != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.Ea.getPageActivity()).createFromThreadCfg(this.aas, this.mForumName, null, 18003, true, false, false)));
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.aSl != null && this.aTw != null) {
            this.aTw.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.aTw);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.view.au
    public void setForumName(String str) {
        this.mForumName = str;
    }
}
