package com.baidu.tieba.frs.gametabs;

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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.messageCenter.NewsRemindMessage;
import com.baidu.tieba.d;
/* loaded from: classes4.dex */
public class d {
    private ImageView dpq;
    private ImageView dwB;
    private com.baidu.tieba.c.b faM;
    private SpecialFrsWebFragment fpo;
    private ImageView fpp;
    private ImageView fpq;
    private NavigationBar mNavigationBar;
    private com.baidu.adp.base.e mPageContext;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.gametabs.d.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == d.this.dwB) {
                d.this.bhe();
            } else if (view != d.this.fpp) {
                if (d.this.faM == null || view != d.this.faM.getView()) {
                    if (view != d.this.dpq) {
                        if (view == d.this.fpq) {
                            d.this.a(d.this.fpo.q(null, null, null, null));
                        }
                    } else if (!StringUtils.isNull(d.this.getForumId())) {
                        d.this.mPageContext.sendMessage(new CustomMessage(2002001, new ForumDetailActivityConfig(d.this.mPageContext.getPageActivity(), d.this.getForumId(), ForumDetailActivityConfig.FromType.FRS_GAME_LIVE)));
                    }
                } else if (bc.cZ(d.this.mPageContext.getPageActivity())) {
                    TiebaStatic.log(new am("c12924").T("obj_locate", 2));
                    d.this.mPageContext.sendMessage(new CustomMessage(2002001, new MessageCenterActivityConfig(d.this.mPageContext.getPageActivity())));
                }
            } else {
                TiebaStatic.log(new am("c12402").bJ(ImageViewerConfig.FORUM_ID, d.this.getForumId()).bJ("uid", TbadkCoreApplication.getCurrentAccount()).bJ(ImageViewerConfig.FORUM_NAME, d.this.getForumName()));
                if (!StringUtils.isNull(d.this.getForumName())) {
                    d.this.mPageContext.sendMessage(new CustomMessage(2002001, new PostSearchActivityConfig(d.this.mPageContext.getPageActivity(), d.this.getForumName(), d.this.getForumId())));
                }
            }
        }
    };
    private CustomMessageListener fag = new CustomMessageListener(2001626) { // from class: com.baidu.tieba.frs.gametabs.d.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            NewsRemindMessage newsRemindMessage;
            if (customResponsedMessage != null && (customResponsedMessage instanceof NewsRemindMessage) && customResponsedMessage.getCmd() == 2001626 && (newsRemindMessage = (NewsRemindMessage) customResponsedMessage) != null) {
                int notificationCount = newsRemindMessage.getNotificationCount() + newsRemindMessage.getMsgCount() + newsRemindMessage.getChatCount();
                boolean z = newsRemindMessage.hasMsgRemind() || newsRemindMessage.hasChatRemind() || newsRemindMessage.hasNotificationRemind();
                if (d.this.faM != null) {
                    d.this.faM.l(z, notificationCount);
                }
            }
        }
    };

    public d(com.baidu.adp.base.e eVar) {
        this.mPageContext = eVar;
        this.faM = new com.baidu.tieba.c.b(this.mPageContext.getPageActivity());
        this.faM.getView().setOnClickListener(this.mOnClickListener);
        this.mPageContext.registerListener(this.fag);
    }

    public String getForumId() {
        return this.fpo != null ? this.fpo.getForumId() : "";
    }

    public String getForumName() {
        return this.fpo != null ? this.fpo.getForumName() : "";
    }

    public NavigationBar aDp() {
        return this.mNavigationBar;
    }

    public void onChangeSkinType(int i) {
        if (this.fpo != null && this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.mPageContext, i);
            al.d(this.mNavigationBar.mTextTitle, d.C0277d.cp_cont_b, 1);
            al.d(this.mNavigationBar.mCenterText, d.C0277d.cp_cont_b, 1);
            al.l(this.mNavigationBar.getBottomLine(), d.C0277d.cp_bg_line_b);
            int i2 = d.C0277d.select_topbar_icon_color_tint;
            aq.ado().d(this.dwB, d.f.icon_topbar_return_n_svg, i2);
            aq.ado().d(this.fpp, d.f.icon_topbar_search_n_svg, i2);
            if (this.faM != null) {
                this.faM.oH(i2);
                this.faM.onChangeSkinType(i);
            }
            al.a(this.dpq, d.f.btn_more_selector_s, d.f.btn_more_selector);
            al.a(this.fpq, d.f.icon_nav_share_selector, d.f.icon_nav_share_selector);
        }
    }

    public void a(NavigationBar navigationBar, SpecialFrsWebFragment specialFrsWebFragment) {
        this.mNavigationBar = navigationBar;
        this.fpo = specialFrsWebFragment;
        this.mNavigationBar.showBottomLine();
        this.mNavigationBar.getBarBgView().setAlpha(1.0f);
        this.mNavigationBar.setCenterTextTitle(getForumName());
        this.dwB = (ImageView) this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON).findViewById(d.g.widget_navi_back_button);
        this.dwB.setOnClickListener(this.mOnClickListener);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, l.h(this.mPageContext.getPageActivity(), d.e.ds24), 0);
        this.fpq = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.special_frs_web_navigation_share, (View.OnClickListener) null);
        this.fpq.setLayoutParams(layoutParams);
        this.fpq.setOnClickListener(this.mOnClickListener);
        this.dpq = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.widget_frs_forum_info_item, (View.OnClickListener) null);
        this.dpq.setLayoutParams(layoutParams);
        this.dpq.setOnClickListener(this.mOnClickListener);
        setNavBarVisibility(specialFrsWebFragment.isNeedShowNavigationBar());
        db(specialFrsWebFragment.isNeedShowShareItem());
        jI(specialFrsWebFragment.isNeedShowMenuItem());
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bhe() {
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921342);
        customResponsedMessage.setmOrginalMessage(new CustomMessage(2001627, this.mPageContext.getUniqueId()));
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
    }

    public void a(com.baidu.tbadk.coreExtra.c.d dVar) {
        if (this.fpo != null) {
            this.fpo.a(dVar);
        }
    }

    public void setNavBarVisibility(boolean z) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.setVisibility(z ? 0 : 8);
        }
    }

    public void db(boolean z) {
        if (this.fpq != null) {
            this.fpq.setVisibility(z ? 0 : 8);
        }
    }

    public void jI(boolean z) {
        if (this.dpq != null) {
            this.dpq.setVisibility(z ? 0 : 8);
        }
    }

    public void onDestroy() {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.release();
        }
        MessageManager.getInstance().unRegisterListener(this.fag);
    }
}
