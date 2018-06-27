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
import com.baidu.tbadk.core.util.bb;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.messageCenter.NewsRemindMessage;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class d {
    private ImageView bFR;
    private ImageView bNv;
    private com.baidu.tieba.c.b dlg;
    private SpecialFrsWebFragment dzj;
    private ImageView dzk;
    private ImageView dzl;
    private NavigationBar mNavigationBar;
    private com.baidu.adp.base.e mPageContext;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.gametabs.d.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == d.this.bNv) {
                if (d.this.ayq()) {
                    d.this.finishActivity();
                } else {
                    d.this.ayr();
                }
            } else if (view != d.this.dzk) {
                if (d.this.dlg == null || view != d.this.dlg.getView()) {
                    if (view != d.this.bFR) {
                        if (view == d.this.dzl) {
                            d.this.a(d.this.dzj.m(null, null, null, null));
                        }
                    } else if (!StringUtils.isNull(d.this.getForumId())) {
                        d.this.mPageContext.sendMessage(new CustomMessage(2002001, new ForumDetailActivityConfig(d.this.mPageContext.getPageActivity(), d.this.getForumId(), ForumDetailActivityConfig.FromType.FRS_GAME_LIVE)));
                    }
                } else if (bb.aU(d.this.mPageContext.getPageActivity())) {
                    TiebaStatic.log(new an("c12924").r("obj_locate", 2));
                    d.this.mPageContext.sendMessage(new CustomMessage(2002001, new MessageCenterActivityConfig(d.this.mPageContext.getPageActivity())));
                }
            } else {
                TiebaStatic.log(new an("c12402").ah(ImageViewerConfig.FORUM_ID, d.this.getForumId()).ah("uid", TbadkCoreApplication.getCurrentAccount()).ah(ImageViewerConfig.FORUM_NAME, d.this.getForumName()));
                if (!StringUtils.isNull(d.this.getForumName())) {
                    d.this.mPageContext.sendMessage(new CustomMessage(2002001, new PostSearchActivityConfig(d.this.mPageContext.getPageActivity(), d.this.getForumName(), d.this.getForumId())));
                }
            }
        }
    };
    private CustomMessageListener dkG = new CustomMessageListener(2001626) { // from class: com.baidu.tieba.frs.gametabs.d.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            NewsRemindMessage newsRemindMessage;
            if (customResponsedMessage != null && (customResponsedMessage instanceof NewsRemindMessage) && customResponsedMessage.getCmd() == 2001626 && (newsRemindMessage = (NewsRemindMessage) customResponsedMessage) != null) {
                int notificationCount = newsRemindMessage.getNotificationCount() + newsRemindMessage.getMsgCount() + newsRemindMessage.getChatCount();
                boolean z = newsRemindMessage.hasMsgRemind() || newsRemindMessage.hasChatRemind() || newsRemindMessage.hasNotificationRemind();
                if (d.this.dlg != null) {
                    d.this.dlg.f(z, notificationCount);
                }
            }
        }
    };

    public d(com.baidu.adp.base.e eVar) {
        this.mPageContext = eVar;
        this.dlg = new com.baidu.tieba.c.b(this.mPageContext.getPageActivity());
        this.dlg.getView().setOnClickListener(this.mOnClickListener);
        this.mPageContext.registerListener(this.dkG);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ayq() {
        if (this.dzj != null) {
            return this.dzj.ayq();
        }
        return false;
    }

    public String getForumId() {
        return this.dzj != null ? this.dzj.getForumId() : "";
    }

    public String getForumName() {
        return this.dzj != null ? this.dzj.getForumName() : "";
    }

    public NavigationBar UW() {
        return this.mNavigationBar;
    }

    public void onChangeSkinType(int i) {
        if (this.dzj != null && this.mNavigationBar != null) {
            Pair<Integer, Integer> ayp = this.dzj.ayp();
            if (ayp != null) {
                this.mNavigationBar.onChangeSkinType(this.mPageContext, i);
                am.c(this.mNavigationBar.mTextTitle, d.C0142d.cp_cont_i, 1);
                am.c(this.mNavigationBar.mCenterText, d.C0142d.cp_cont_i, 1);
                am.j(this.mNavigationBar.getBottomLine(), d.C0142d.cp_bg_line_b);
                com.baidu.tieba.frs.worldcup.b.a(this.mNavigationBar, ayp);
                int i2 = d.C0142d.select_topbar_icon_white_color_tint;
                aq.zE().c(this.bNv, d.f.icon_topbar_return_n_svg, i2);
                aq.zE().c(this.dzk, d.f.icon_topbar_search_n_svg, i2);
                if (this.dlg != null) {
                    this.dlg.ja(i2);
                    this.dlg.onChangeSkinType(i);
                }
            } else {
                this.mNavigationBar.onChangeSkinType(this.mPageContext, i);
                am.c(this.mNavigationBar.mTextTitle, d.C0142d.cp_cont_b, 1);
                am.c(this.mNavigationBar.mCenterText, d.C0142d.cp_cont_b, 1);
                am.j(this.mNavigationBar.getBottomLine(), d.C0142d.cp_bg_line_b);
                int i3 = d.C0142d.select_topbar_icon_color_tint;
                aq.zE().c(this.bNv, d.f.icon_topbar_return_n_svg, i3);
                aq.zE().c(this.dzk, d.f.icon_topbar_search_n_svg, i3);
                if (this.dlg != null) {
                    this.dlg.ja(i3);
                    this.dlg.onChangeSkinType(i);
                }
            }
            am.a(this.bFR, d.f.btn_more_selector_s, d.f.btn_more_selector);
            am.a(this.dzl, d.f.icon_nav_share_selector, d.f.icon_nav_share_selector);
        }
    }

    public void a(NavigationBar navigationBar, SpecialFrsWebFragment specialFrsWebFragment) {
        this.mNavigationBar = navigationBar;
        this.dzj = specialFrsWebFragment;
        this.mNavigationBar.showBottomLine();
        this.mNavigationBar.getBarBgView().setAlpha(1.0f);
        this.mNavigationBar.setCenterTextTitle(getForumName());
        this.bNv = (ImageView) this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON).findViewById(d.g.widget_navi_back_button);
        this.bNv.setOnClickListener(this.mOnClickListener);
        if (ayq()) {
            this.dzk = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.i.widget_nb_item_search, (View.OnClickListener) null);
            this.dzk.setOnClickListener(this.mOnClickListener);
            if (this.dlg != null && this.dlg.getView() != null) {
                this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.dlg.getView(), (View.OnClickListener) null);
            }
        } else {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(0, 0, l.e(this.mPageContext.getPageActivity(), d.e.ds24), 0);
            this.dzl = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.i.special_frs_web_navigation_share, (View.OnClickListener) null);
            this.dzl.setLayoutParams(layoutParams);
            this.dzl.setOnClickListener(this.mOnClickListener);
            this.bFR = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.i.widget_frs_forum_info_item, (View.OnClickListener) null);
            this.bFR.setLayoutParams(layoutParams);
            this.bFR.setOnClickListener(this.mOnClickListener);
        }
        setNavBarVisibility(specialFrsWebFragment.isNeedShowNavigationBar());
        aj(specialFrsWebFragment.isNeedShowShareItem());
        gg(specialFrsWebFragment.isNeedShowMenuItem());
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finishActivity() {
        if (this.mPageContext != null) {
            this.mPageContext.getPageActivity().finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ayr() {
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921342);
        customResponsedMessage.setmOrginalMessage(new CustomMessage(2001627, this.mPageContext.getUniqueId()));
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
    }

    public void a(com.baidu.tbadk.coreExtra.c.d dVar) {
        if (this.dzj != null) {
            this.dzj.a(dVar);
        }
    }

    public void setNavBarVisibility(boolean z) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.setVisibility(z ? 0 : 8);
        }
    }

    public void aj(boolean z) {
        if (this.dzl != null) {
            this.dzl.setVisibility(z ? 0 : 8);
        }
    }

    public void gg(boolean z) {
        if (this.bFR != null) {
            this.bFR.setVisibility(z ? 0 : 8);
        }
    }

    public void onDestroy() {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.release();
        }
        MessageManager.getInstance().unRegisterListener(this.dkG);
    }
}
