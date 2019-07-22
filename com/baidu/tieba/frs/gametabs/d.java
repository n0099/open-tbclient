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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.bd;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.messageCenter.NewsRemindMessage;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class d {
    private ImageView dAg;
    private ImageView dDu;
    private SpecialFrsWebFragment fKx;
    private ImageView fKy;
    private com.baidu.tieba.c.b fvM;
    private NavigationBar mNavigationBar;
    private com.baidu.adp.base.e mPageContext;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.gametabs.d.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == d.this.dAg) {
                d.this.bqz();
            } else if (d.this.fvM == null || view != d.this.fvM.getView()) {
                if (view != d.this.dDu) {
                    if (view == d.this.fKy) {
                        d.this.a(d.this.fKx.q(null, null, null, null));
                    }
                } else if (!StringUtils.isNull(d.this.getForumId())) {
                    d.this.mPageContext.sendMessage(new CustomMessage(2002001, new ForumDetailActivityConfig(d.this.mPageContext.getPageActivity(), d.this.getForumId(), ForumDetailActivityConfig.FromType.FRS_GAME_LIVE)));
                }
            } else if (bd.cF(d.this.mPageContext.getPageActivity())) {
                TiebaStatic.log(new an("c12924").P("obj_locate", 2));
                d.this.mPageContext.sendMessage(new CustomMessage(2002001, new MessageCenterActivityConfig(d.this.mPageContext.getPageActivity())));
            }
        }
    };
    private CustomMessageListener fvf = new CustomMessageListener(2001626) { // from class: com.baidu.tieba.frs.gametabs.d.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            NewsRemindMessage newsRemindMessage;
            if (customResponsedMessage != null && (customResponsedMessage instanceof NewsRemindMessage) && customResponsedMessage.getCmd() == 2001626 && (newsRemindMessage = (NewsRemindMessage) customResponsedMessage) != null) {
                int notificationCount = newsRemindMessage.getNotificationCount() + newsRemindMessage.getMsgCount() + newsRemindMessage.getChatCount();
                boolean z = newsRemindMessage.hasMsgRemind() || newsRemindMessage.hasChatRemind() || newsRemindMessage.hasNotificationRemind();
                if (d.this.fvM != null) {
                    d.this.fvM.l(z, notificationCount);
                }
            }
        }
    };

    public d(com.baidu.adp.base.e eVar) {
        this.mPageContext = eVar;
        this.fvM = new com.baidu.tieba.c.b(this.mPageContext.getPageActivity());
        this.fvM.getView().setOnClickListener(this.mOnClickListener);
        this.mPageContext.registerListener(this.fvf);
    }

    public String getForumId() {
        return this.fKx != null ? this.fKx.getForumId() : "";
    }

    public String getForumName() {
        return this.fKx != null ? this.fKx.getForumName() : "";
    }

    public NavigationBar aLh() {
        return this.mNavigationBar;
    }

    public void onChangeSkinType(int i) {
        if (this.fKx != null && this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.mPageContext, i);
            am.f(this.mNavigationBar.mTextTitle, R.color.cp_cont_b, 1);
            am.f(this.mNavigationBar.mCenterText, R.color.cp_cont_b, 1);
            am.l(this.mNavigationBar.getBottomLine(), R.color.cp_bg_line_b);
            ar.ajn().d(this.dAg, R.drawable.icon_topbar_return_n_svg, R.color.select_topbar_icon_color_tint);
            if (this.fvM != null) {
                this.fvM.pY(R.color.select_topbar_icon_color_tint);
                this.fvM.onChangeSkinType(i);
            }
            am.a(this.dDu, (int) R.drawable.selector_web_topbar_other_black, (int) R.drawable.selector_web_topbar_other_white);
            am.a(this.fKy, (int) R.drawable.icon_nav_share_selector, (int) R.drawable.icon_nav_share_selector);
        }
    }

    public void a(NavigationBar navigationBar, SpecialFrsWebFragment specialFrsWebFragment) {
        this.mNavigationBar = navigationBar;
        this.fKx = specialFrsWebFragment;
        this.mNavigationBar.showBottomLine();
        this.mNavigationBar.getBarBgView().setAlpha(1.0f);
        this.mNavigationBar.setCenterTextTitle(getForumName());
        this.dAg = (ImageView) this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON).findViewById(R.id.widget_navi_back_button);
        this.dAg.setOnClickListener(this.mOnClickListener);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, l.g(this.mPageContext.getPageActivity(), R.dimen.ds24), 0);
        this.fKy = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.special_frs_web_navigation_share, (View.OnClickListener) null);
        this.fKy.setLayoutParams(layoutParams);
        this.fKy.setOnClickListener(this.mOnClickListener);
        this.dDu = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.widget_frs_forum_info_item, (View.OnClickListener) null);
        this.dDu.setLayoutParams(layoutParams);
        this.dDu.setOnClickListener(this.mOnClickListener);
        setNavBarVisibility(specialFrsWebFragment.isNeedShowNavigationBar());
        dA(specialFrsWebFragment.isNeedShowShareItem());
        kE(specialFrsWebFragment.isNeedShowMenuItem());
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqz() {
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921342);
        customResponsedMessage.setmOrginalMessage(new CustomMessage(2001627, this.mPageContext.getUniqueId()));
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
    }

    public void a(com.baidu.tbadk.coreExtra.c.e eVar) {
        if (this.fKx != null) {
            this.fKx.a(eVar);
        }
    }

    public void setNavBarVisibility(boolean z) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.setVisibility(z ? 0 : 8);
        }
    }

    public void dA(boolean z) {
        if (this.fKy != null) {
            this.fKy.setVisibility(z ? 0 : 8);
        }
    }

    public void kE(boolean z) {
        if (this.dDu != null) {
            this.dDu.setVisibility(z ? 0 : 8);
        }
    }

    public void onDestroy() {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.release();
        }
        MessageManager.getInstance().unRegisterListener(this.fvf);
    }
}
