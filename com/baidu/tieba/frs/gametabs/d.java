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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.messageCenter.NewsRemindMessage;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class d {
    private ImageView bZD;
    private ImageView cgK;
    private com.baidu.tieba.c.b dJK;
    private SpecialFrsWebFragment dYl;
    private ImageView dYm;
    private ImageView dYn;
    private NavigationBar mNavigationBar;
    private com.baidu.adp.base.e mPageContext;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.gametabs.d.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == d.this.cgK) {
                if (d.this.aFB()) {
                    d.this.finishActivity();
                } else {
                    d.this.aFC();
                }
            } else if (view != d.this.dYm) {
                if (d.this.dJK == null || view != d.this.dJK.getView()) {
                    if (view != d.this.bZD) {
                        if (view == d.this.dYn) {
                            d.this.a(d.this.dYl.m(null, null, null, null));
                        }
                    } else if (!StringUtils.isNull(d.this.getForumId())) {
                        d.this.mPageContext.sendMessage(new CustomMessage(2002001, new ForumDetailActivityConfig(d.this.mPageContext.getPageActivity(), d.this.getForumId(), ForumDetailActivityConfig.FromType.FRS_GAME_LIVE)));
                    }
                } else if (ba.bJ(d.this.mPageContext.getPageActivity())) {
                    TiebaStatic.log(new am("c12924").x("obj_locate", 2));
                    d.this.mPageContext.sendMessage(new CustomMessage(2002001, new MessageCenterActivityConfig(d.this.mPageContext.getPageActivity())));
                }
            } else {
                TiebaStatic.log(new am("c12402").aA(ImageViewerConfig.FORUM_ID, d.this.getForumId()).aA("uid", TbadkCoreApplication.getCurrentAccount()).aA(ImageViewerConfig.FORUM_NAME, d.this.getForumName()));
                if (!StringUtils.isNull(d.this.getForumName())) {
                    d.this.mPageContext.sendMessage(new CustomMessage(2002001, new PostSearchActivityConfig(d.this.mPageContext.getPageActivity(), d.this.getForumName(), d.this.getForumId())));
                }
            }
        }
    };
    private CustomMessageListener dJj = new CustomMessageListener(2001626) { // from class: com.baidu.tieba.frs.gametabs.d.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            NewsRemindMessage newsRemindMessage;
            if (customResponsedMessage != null && (customResponsedMessage instanceof NewsRemindMessage) && customResponsedMessage.getCmd() == 2001626 && (newsRemindMessage = (NewsRemindMessage) customResponsedMessage) != null) {
                int notificationCount = newsRemindMessage.getNotificationCount() + newsRemindMessage.getMsgCount() + newsRemindMessage.getChatCount();
                boolean z = newsRemindMessage.hasMsgRemind() || newsRemindMessage.hasChatRemind() || newsRemindMessage.hasNotificationRemind();
                if (d.this.dJK != null) {
                    d.this.dJK.h(z, notificationCount);
                }
            }
        }
    };

    public d(com.baidu.adp.base.e eVar) {
        this.mPageContext = eVar;
        this.dJK = new com.baidu.tieba.c.b(this.mPageContext.getPageActivity());
        this.dJK.getView().setOnClickListener(this.mOnClickListener);
        this.mPageContext.registerListener(this.dJj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aFB() {
        if (this.dYl != null) {
            return this.dYl.aFB();
        }
        return false;
    }

    public String getForumId() {
        return this.dYl != null ? this.dYl.getForumId() : "";
    }

    public String getForumName() {
        return this.dYl != null ? this.dYl.getForumName() : "";
    }

    public NavigationBar abU() {
        return this.mNavigationBar;
    }

    public void onChangeSkinType(int i) {
        if (this.dYl != null && this.mNavigationBar != null) {
            Pair<Integer, Integer> aFA = this.dYl.aFA();
            if (aFA != null) {
                this.mNavigationBar.onChangeSkinType(this.mPageContext, i);
                al.c(this.mNavigationBar.mTextTitle, e.d.cp_cont_i, 1);
                al.c(this.mNavigationBar.mCenterText, e.d.cp_cont_i, 1);
                al.j(this.mNavigationBar.getBottomLine(), e.d.cp_bg_line_b);
                com.baidu.tieba.frs.worldcup.b.a(this.mNavigationBar, aFA);
                int i2 = e.d.select_topbar_icon_white_color_tint;
                ap.DQ().c(this.cgK, e.f.icon_topbar_return_n_svg, i2);
                ap.DQ().c(this.dYm, e.f.icon_topbar_search_n_svg, i2);
                if (this.dJK != null) {
                    this.dJK.kR(i2);
                    this.dJK.onChangeSkinType(i);
                }
            } else {
                this.mNavigationBar.onChangeSkinType(this.mPageContext, i);
                al.c(this.mNavigationBar.mTextTitle, e.d.cp_cont_b, 1);
                al.c(this.mNavigationBar.mCenterText, e.d.cp_cont_b, 1);
                al.j(this.mNavigationBar.getBottomLine(), e.d.cp_bg_line_b);
                int i3 = e.d.select_topbar_icon_color_tint;
                ap.DQ().c(this.cgK, e.f.icon_topbar_return_n_svg, i3);
                ap.DQ().c(this.dYm, e.f.icon_topbar_search_n_svg, i3);
                if (this.dJK != null) {
                    this.dJK.kR(i3);
                    this.dJK.onChangeSkinType(i);
                }
            }
            al.a(this.bZD, e.f.btn_more_selector_s, e.f.btn_more_selector);
            al.a(this.dYn, e.f.icon_nav_share_selector, e.f.icon_nav_share_selector);
        }
    }

    public void a(NavigationBar navigationBar, SpecialFrsWebFragment specialFrsWebFragment) {
        this.mNavigationBar = navigationBar;
        this.dYl = specialFrsWebFragment;
        this.mNavigationBar.showBottomLine();
        this.mNavigationBar.getBarBgView().setAlpha(1.0f);
        this.mNavigationBar.setCenterTextTitle(getForumName());
        this.cgK = (ImageView) this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON).findViewById(e.g.widget_navi_back_button);
        this.cgK.setOnClickListener(this.mOnClickListener);
        if (aFB()) {
            this.dYm = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, e.h.widget_nb_item_search, (View.OnClickListener) null);
            this.dYm.setOnClickListener(this.mOnClickListener);
            if (this.dJK != null && this.dJK.getView() != null) {
                this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.dJK.getView(), (View.OnClickListener) null);
            }
        } else {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(0, 0, l.h(this.mPageContext.getPageActivity(), e.C0210e.ds24), 0);
            this.dYn = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, e.h.special_frs_web_navigation_share, (View.OnClickListener) null);
            this.dYn.setLayoutParams(layoutParams);
            this.dYn.setOnClickListener(this.mOnClickListener);
            this.bZD = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, e.h.widget_frs_forum_info_item, (View.OnClickListener) null);
            this.bZD.setLayoutParams(layoutParams);
            this.bZD.setOnClickListener(this.mOnClickListener);
        }
        setNavBarVisibility(specialFrsWebFragment.isNeedShowNavigationBar());
        aR(specialFrsWebFragment.isNeedShowShareItem());
        hh(specialFrsWebFragment.isNeedShowMenuItem());
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finishActivity() {
        if (this.mPageContext != null) {
            this.mPageContext.getPageActivity().finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aFC() {
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921342);
        customResponsedMessage.setmOrginalMessage(new CustomMessage(2001627, this.mPageContext.getUniqueId()));
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
    }

    public void a(com.baidu.tbadk.coreExtra.c.d dVar) {
        if (this.dYl != null) {
            this.dYl.a(dVar);
        }
    }

    public void setNavBarVisibility(boolean z) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.setVisibility(z ? 0 : 8);
        }
    }

    public void aR(boolean z) {
        if (this.dYn != null) {
            this.dYn.setVisibility(z ? 0 : 8);
        }
    }

    public void hh(boolean z) {
        if (this.bZD != null) {
            this.bZD.setVisibility(z ? 0 : 8);
        }
    }

    public void onDestroy() {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.release();
        }
        MessageManager.getInstance().unRegisterListener(this.dJj);
    }
}
