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
import com.baidu.tbadk.core.atomData.MessageCenterActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.messageCenter.NewsRemindMessage;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class d {
    private ImageView dAa;
    private ImageView dHi;
    private ImageView fFA;
    private SpecialFrsWebFragment fFz;
    private com.baidu.tieba.c.b fqO;
    private NavigationBar mNavigationBar;
    private com.baidu.adp.base.e mPageContext;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.gametabs.d.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == d.this.dHi) {
                d.this.boy();
            } else if (d.this.fqO == null || view != d.this.fqO.getView()) {
                if (view != d.this.dAa) {
                    if (view == d.this.fFA) {
                        d.this.a(d.this.fFz.q(null, null, null, null));
                    }
                } else if (!StringUtils.isNull(d.this.getForumId())) {
                    d.this.mPageContext.sendMessage(new CustomMessage(2002001, new ForumDetailActivityConfig(d.this.mPageContext.getPageActivity(), d.this.getForumId(), ForumDetailActivityConfig.FromType.FRS_GAME_LIVE)));
                }
            } else if (bc.cE(d.this.mPageContext.getPageActivity())) {
                TiebaStatic.log(new am("c12924").P("obj_locate", 2));
                d.this.mPageContext.sendMessage(new CustomMessage(2002001, new MessageCenterActivityConfig(d.this.mPageContext.getPageActivity())));
            }
        }
    };
    private CustomMessageListener fqh = new CustomMessageListener(2001626) { // from class: com.baidu.tieba.frs.gametabs.d.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            NewsRemindMessage newsRemindMessage;
            if (customResponsedMessage != null && (customResponsedMessage instanceof NewsRemindMessage) && customResponsedMessage.getCmd() == 2001626 && (newsRemindMessage = (NewsRemindMessage) customResponsedMessage) != null) {
                int notificationCount = newsRemindMessage.getNotificationCount() + newsRemindMessage.getMsgCount() + newsRemindMessage.getChatCount();
                boolean z = newsRemindMessage.hasMsgRemind() || newsRemindMessage.hasChatRemind() || newsRemindMessage.hasNotificationRemind();
                if (d.this.fqO != null) {
                    d.this.fqO.l(z, notificationCount);
                }
            }
        }
    };

    public d(com.baidu.adp.base.e eVar) {
        this.mPageContext = eVar;
        this.fqO = new com.baidu.tieba.c.b(this.mPageContext.getPageActivity());
        this.fqO.getView().setOnClickListener(this.mOnClickListener);
        this.mPageContext.registerListener(this.fqh);
    }

    public String getForumId() {
        return this.fFz != null ? this.fFz.getForumId() : "";
    }

    public String getForumName() {
        return this.fFz != null ? this.fFz.getForumName() : "";
    }

    public NavigationBar aJC() {
        return this.mNavigationBar;
    }

    public void onChangeSkinType(int i) {
        if (this.fFz != null && this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.mPageContext, i);
            al.f(this.mNavigationBar.mTextTitle, R.color.cp_cont_b, 1);
            al.f(this.mNavigationBar.mCenterText, R.color.cp_cont_b, 1);
            al.l(this.mNavigationBar.getBottomLine(), R.color.cp_bg_line_b);
            aq.aik().d(this.dHi, R.drawable.icon_topbar_return_n_svg, R.color.select_topbar_icon_color_tint);
            if (this.fqO != null) {
                this.fqO.pH(R.color.select_topbar_icon_color_tint);
                this.fqO.onChangeSkinType(i);
            }
            al.a(this.dAa, (int) R.drawable.selector_web_topbar_other_black, (int) R.drawable.selector_web_topbar_other_white);
            al.a(this.fFA, (int) R.drawable.icon_nav_share_selector, (int) R.drawable.icon_nav_share_selector);
        }
    }

    public void a(NavigationBar navigationBar, SpecialFrsWebFragment specialFrsWebFragment) {
        this.mNavigationBar = navigationBar;
        this.fFz = specialFrsWebFragment;
        this.mNavigationBar.showBottomLine();
        this.mNavigationBar.getBarBgView().setAlpha(1.0f);
        this.mNavigationBar.setCenterTextTitle(getForumName());
        this.dHi = (ImageView) this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON).findViewById(R.id.widget_navi_back_button);
        this.dHi.setOnClickListener(this.mOnClickListener);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, l.g(this.mPageContext.getPageActivity(), R.dimen.ds24), 0);
        this.fFA = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.special_frs_web_navigation_share, (View.OnClickListener) null);
        this.fFA.setLayoutParams(layoutParams);
        this.fFA.setOnClickListener(this.mOnClickListener);
        this.dAa = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.widget_frs_forum_info_item, (View.OnClickListener) null);
        this.dAa.setLayoutParams(layoutParams);
        this.dAa.setOnClickListener(this.mOnClickListener);
        setNavBarVisibility(specialFrsWebFragment.isNeedShowNavigationBar());
        dw(specialFrsWebFragment.isNeedShowShareItem());
        ku(specialFrsWebFragment.isNeedShowMenuItem());
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void boy() {
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921342);
        customResponsedMessage.setmOrginalMessage(new CustomMessage(2001627, this.mPageContext.getUniqueId()));
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
    }

    public void a(com.baidu.tbadk.coreExtra.c.e eVar) {
        if (this.fFz != null) {
            this.fFz.a(eVar);
        }
    }

    public void setNavBarVisibility(boolean z) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.setVisibility(z ? 0 : 8);
        }
    }

    public void dw(boolean z) {
        if (this.fFA != null) {
            this.fFA.setVisibility(z ? 0 : 8);
        }
    }

    public void ku(boolean z) {
        if (this.dAa != null) {
            this.dAa.setVisibility(z ? 0 : 8);
        }
    }

    public void onDestroy() {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.release();
        }
        MessageManager.getInstance().unRegisterListener(this.fqh);
    }
}
