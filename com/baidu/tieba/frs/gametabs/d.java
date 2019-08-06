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
    private ImageView dAn;
    private ImageView dDB;
    private SpecialFrsWebFragment fLl;
    private ImageView fLm;
    private com.baidu.tieba.c.b fwl;
    private NavigationBar mNavigationBar;
    private com.baidu.adp.base.e mPageContext;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.gametabs.d.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == d.this.dAn) {
                d.this.bqM();
            } else if (d.this.fwl == null || view != d.this.fwl.getView()) {
                if (view != d.this.dDB) {
                    if (view == d.this.fLm) {
                        d.this.a(d.this.fLl.q(null, null, null, null));
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
    private CustomMessageListener fvE = new CustomMessageListener(2001626) { // from class: com.baidu.tieba.frs.gametabs.d.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            NewsRemindMessage newsRemindMessage;
            if (customResponsedMessage != null && (customResponsedMessage instanceof NewsRemindMessage) && customResponsedMessage.getCmd() == 2001626 && (newsRemindMessage = (NewsRemindMessage) customResponsedMessage) != null) {
                int notificationCount = newsRemindMessage.getNotificationCount() + newsRemindMessage.getMsgCount() + newsRemindMessage.getChatCount();
                boolean z = newsRemindMessage.hasMsgRemind() || newsRemindMessage.hasChatRemind() || newsRemindMessage.hasNotificationRemind();
                if (d.this.fwl != null) {
                    d.this.fwl.l(z, notificationCount);
                }
            }
        }
    };

    public d(com.baidu.adp.base.e eVar) {
        this.mPageContext = eVar;
        this.fwl = new com.baidu.tieba.c.b(this.mPageContext.getPageActivity());
        this.fwl.getView().setOnClickListener(this.mOnClickListener);
        this.mPageContext.registerListener(this.fvE);
    }

    public String getForumId() {
        return this.fLl != null ? this.fLl.getForumId() : "";
    }

    public String getForumName() {
        return this.fLl != null ? this.fLl.getForumName() : "";
    }

    public NavigationBar aLj() {
        return this.mNavigationBar;
    }

    public void onChangeSkinType(int i) {
        if (this.fLl != null && this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.mPageContext, i);
            am.f(this.mNavigationBar.mTextTitle, R.color.cp_cont_b, 1);
            am.f(this.mNavigationBar.mCenterText, R.color.cp_cont_b, 1);
            am.l(this.mNavigationBar.getBottomLine(), R.color.cp_bg_line_b);
            ar.ajp().d(this.dAn, R.drawable.icon_topbar_return_n_svg, R.color.select_topbar_icon_color_tint);
            if (this.fwl != null) {
                this.fwl.pZ(R.color.select_topbar_icon_color_tint);
                this.fwl.onChangeSkinType(i);
            }
            am.a(this.dDB, (int) R.drawable.selector_web_topbar_other_black, (int) R.drawable.selector_web_topbar_other_white);
            am.a(this.fLm, (int) R.drawable.icon_nav_share_selector, (int) R.drawable.icon_nav_share_selector);
        }
    }

    public void a(NavigationBar navigationBar, SpecialFrsWebFragment specialFrsWebFragment) {
        this.mNavigationBar = navigationBar;
        this.fLl = specialFrsWebFragment;
        this.mNavigationBar.showBottomLine();
        this.mNavigationBar.getBarBgView().setAlpha(1.0f);
        this.mNavigationBar.setCenterTextTitle(getForumName());
        this.dAn = (ImageView) this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON).findViewById(R.id.widget_navi_back_button);
        this.dAn.setOnClickListener(this.mOnClickListener);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, l.g(this.mPageContext.getPageActivity(), R.dimen.ds24), 0);
        this.fLm = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.special_frs_web_navigation_share, (View.OnClickListener) null);
        this.fLm.setLayoutParams(layoutParams);
        this.fLm.setOnClickListener(this.mOnClickListener);
        this.dDB = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.widget_frs_forum_info_item, (View.OnClickListener) null);
        this.dDB.setLayoutParams(layoutParams);
        this.dDB.setOnClickListener(this.mOnClickListener);
        setNavBarVisibility(specialFrsWebFragment.isNeedShowNavigationBar());
        dA(specialFrsWebFragment.isNeedShowShareItem());
        kE(specialFrsWebFragment.isNeedShowMenuItem());
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqM() {
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921342);
        customResponsedMessage.setmOrginalMessage(new CustomMessage(2001627, this.mPageContext.getUniqueId()));
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
    }

    public void a(com.baidu.tbadk.coreExtra.c.e eVar) {
        if (this.fLl != null) {
            this.fLl.a(eVar);
        }
    }

    public void setNavBarVisibility(boolean z) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.setVisibility(z ? 0 : 8);
        }
    }

    public void dA(boolean z) {
        if (this.fLm != null) {
            this.fLm.setVisibility(z ? 0 : 8);
        }
    }

    public void kE(boolean z) {
        if (this.dDB != null) {
            this.dDB.setVisibility(z ? 0 : 8);
        }
    }

    public void onDestroy() {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.release();
        }
        MessageManager.getInstance().unRegisterListener(this.fvE);
    }
}
