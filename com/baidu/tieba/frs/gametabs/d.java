package com.baidu.tieba.frs.gametabs;

import android.util.Pair;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForumDetailActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.MessageCenterActivityConfig;
import com.baidu.tbadk.core.atomData.PostSearchActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.messageCenter.NewsRemindMessage;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class d {
    private ImageView bGG;
    private ImageView bOq;
    private SpecialFrsWebFragment dBV;
    private ImageView dBW;
    private ImageView dBX;
    private com.baidu.tieba.c.b dnX;
    private NavigationBar mNavigationBar;
    private com.baidu.adp.base.e mPageContext;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.gametabs.d.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == d.this.bOq) {
                if (d.this.ayV()) {
                    d.this.finishActivity();
                } else {
                    d.this.ayW();
                }
            } else if (view != d.this.dBW) {
                if (d.this.dnX == null || view != d.this.dnX.getView()) {
                    if (view != d.this.bGG) {
                        if (view == d.this.dBX) {
                            d.this.a(d.this.dBV.m(null, null, null, null));
                        }
                    } else if (!StringUtils.isNull(d.this.getForumId())) {
                        d.this.mPageContext.sendMessage(new CustomMessage(2002001, new ForumDetailActivityConfig(d.this.mPageContext.getPageActivity(), d.this.getForumId(), ForumDetailActivityConfig.FromType.FRS_GAME_LIVE)));
                    }
                } else if (ba.aV(d.this.mPageContext.getPageActivity())) {
                    TiebaStatic.log(new an("c12924").r("obj_locate", 2));
                    d.this.mPageContext.sendMessage(new CustomMessage(2002001, new MessageCenterActivityConfig(d.this.mPageContext.getPageActivity())));
                }
            } else {
                TiebaStatic.log(new an("c12402").af(ImageViewerConfig.FORUM_ID, d.this.getForumId()).af("uid", TbadkCoreApplication.getCurrentAccount()).af(ImageViewerConfig.FORUM_NAME, d.this.getForumName()));
                if (!StringUtils.isNull(d.this.getForumName())) {
                    d.this.mPageContext.sendMessage(new CustomMessage(2002001, new PostSearchActivityConfig(d.this.mPageContext.getPageActivity(), d.this.getForumName(), d.this.getForumId())));
                }
            }
        }
    };
    private CustomMessageListener dnw = new CustomMessageListener(2001626) { // from class: com.baidu.tieba.frs.gametabs.d.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            NewsRemindMessage newsRemindMessage;
            if (customResponsedMessage != null && (customResponsedMessage instanceof NewsRemindMessage) && customResponsedMessage.getCmd() == 2001626 && (newsRemindMessage = (NewsRemindMessage) customResponsedMessage) != null) {
                int notificationCount = newsRemindMessage.getNotificationCount() + newsRemindMessage.getMsgCount() + newsRemindMessage.getChatCount();
                boolean z = newsRemindMessage.hasMsgRemind() || newsRemindMessage.hasChatRemind() || newsRemindMessage.hasNotificationRemind();
                if (d.this.dnX != null) {
                    d.this.dnX.f(z, notificationCount);
                }
            }
        }
    };

    public d(com.baidu.adp.base.e eVar) {
        this.mPageContext = eVar;
        this.dnX = new com.baidu.tieba.c.b(this.mPageContext.getPageActivity());
        this.dnX.getView().setOnClickListener(this.mOnClickListener);
        this.mPageContext.registerListener(this.dnw);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ayV() {
        if (this.dBV != null) {
            return this.dBV.ayV();
        }
        return false;
    }

    public String getForumId() {
        return this.dBV != null ? this.dBV.getForumId() : "";
    }

    public String getForumName() {
        return this.dBV != null ? this.dBV.getForumName() : "";
    }

    public NavigationBar Vf() {
        return this.mNavigationBar;
    }

    public void onChangeSkinType(int i) {
        if (this.dBV != null && this.mNavigationBar != null) {
            Pair<Integer, Integer> ayU = this.dBV.ayU();
            if (ayU != null) {
                this.mNavigationBar.onChangeSkinType(this.mPageContext, i);
                am.c(this.mNavigationBar.mTextTitle, d.C0140d.cp_cont_i, 1);
                am.c(this.mNavigationBar.mCenterText, d.C0140d.cp_cont_i, 1);
                am.j(this.mNavigationBar.getBottomLine(), d.C0140d.cp_bg_line_b);
                com.baidu.tieba.frs.worldcup.b.a(this.mNavigationBar, ayU);
                int i2 = d.C0140d.select_topbar_icon_white_color_tint;
                aq.zv().c(this.bOq, d.f.icon_topbar_return_n_svg, i2);
                aq.zv().c(this.dBW, d.f.icon_topbar_search_n_svg, i2);
                if (this.dnX != null) {
                    this.dnX.jm(i2);
                    this.dnX.onChangeSkinType(i);
                }
            } else {
                this.mNavigationBar.onChangeSkinType(this.mPageContext, i);
                am.c(this.mNavigationBar.mTextTitle, d.C0140d.cp_cont_b, 1);
                am.c(this.mNavigationBar.mCenterText, d.C0140d.cp_cont_b, 1);
                am.j(this.mNavigationBar.getBottomLine(), d.C0140d.cp_bg_line_b);
                int i3 = d.C0140d.select_topbar_icon_color_tint;
                aq.zv().c(this.bOq, d.f.icon_topbar_return_n_svg, i3);
                aq.zv().c(this.dBW, d.f.icon_topbar_search_n_svg, i3);
                if (this.dnX != null) {
                    this.dnX.jm(i3);
                    this.dnX.onChangeSkinType(i);
                }
            }
            am.a(this.bGG, d.f.btn_more_selector_s, d.f.btn_more_selector);
            am.a(this.dBX, d.f.icon_nav_share_selector, d.f.icon_nav_share_selector);
        }
    }

    public void a(NavigationBar navigationBar, SpecialFrsWebFragment specialFrsWebFragment) {
        this.mNavigationBar = navigationBar;
        this.dBV = specialFrsWebFragment;
        this.mNavigationBar.showBottomLine();
        this.mNavigationBar.getBarBgView().setAlpha(1.0f);
        this.mNavigationBar.setCenterTextTitle(getForumName());
        this.bOq = (ImageView) this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON).findViewById(d.g.widget_navi_back_button);
        this.bOq.setOnClickListener(this.mOnClickListener);
        if (ayV()) {
            this.dBW = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.widget_nb_item_search, (View.OnClickListener) null);
            this.dBW.setOnClickListener(this.mOnClickListener);
            if (this.dnX != null && this.dnX.getView() != null) {
                this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.dnX.getView(), (View.OnClickListener) null);
            }
        } else {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(0, 0, l.f(this.mPageContext.getPageActivity(), d.e.ds24), 0);
            this.dBX = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.special_frs_web_navigation_share, (View.OnClickListener) null);
            this.dBX.setLayoutParams(layoutParams);
            this.dBX.setOnClickListener(this.mOnClickListener);
            this.bGG = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.widget_frs_forum_info_item, (View.OnClickListener) null);
            this.bGG.setLayoutParams(layoutParams);
            this.bGG.setOnClickListener(this.mOnClickListener);
        }
        setNavBarVisibility(specialFrsWebFragment.isNeedShowNavigationBar());
        af(specialFrsWebFragment.isNeedShowShareItem());
        gi(specialFrsWebFragment.isNeedShowMenuItem());
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finishActivity() {
        if (this.mPageContext != null) {
            this.mPageContext.getPageActivity().finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ayW() {
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921342);
        customResponsedMessage.setmOrginalMessage(new CustomMessage(2001627, this.mPageContext.getUniqueId()));
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
    }

    public void a(com.baidu.tbadk.coreExtra.c.d dVar) {
        if (this.dBV != null) {
            this.dBV.a(dVar);
        }
    }

    public void setNavBarVisibility(boolean z) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.setVisibility(z ? 0 : 8);
        }
    }

    public void af(boolean z) {
        if (this.dBX != null) {
            this.dBX.setVisibility(z ? 0 : 8);
        }
    }

    public void gi(boolean z) {
        if (this.bGG != null) {
            this.bGG.setVisibility(z ? 0 : 8);
        }
    }

    public void onDestroy() {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.release();
        }
        MessageManager.getInstance().unRegisterListener(this.dnw);
    }
}
