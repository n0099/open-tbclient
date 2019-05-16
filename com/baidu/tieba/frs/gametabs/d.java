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
    private ImageView dHh;
    private ImageView dzZ;
    private SpecialFrsWebFragment fFy;
    private ImageView fFz;
    private com.baidu.tieba.c.b fqN;
    private NavigationBar mNavigationBar;
    private com.baidu.adp.base.e mPageContext;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.gametabs.d.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == d.this.dHh) {
                d.this.bov();
            } else if (d.this.fqN == null || view != d.this.fqN.getView()) {
                if (view != d.this.dzZ) {
                    if (view == d.this.fFz) {
                        d.this.a(d.this.fFy.q(null, null, null, null));
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
    private CustomMessageListener fqg = new CustomMessageListener(2001626) { // from class: com.baidu.tieba.frs.gametabs.d.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            NewsRemindMessage newsRemindMessage;
            if (customResponsedMessage != null && (customResponsedMessage instanceof NewsRemindMessage) && customResponsedMessage.getCmd() == 2001626 && (newsRemindMessage = (NewsRemindMessage) customResponsedMessage) != null) {
                int notificationCount = newsRemindMessage.getNotificationCount() + newsRemindMessage.getMsgCount() + newsRemindMessage.getChatCount();
                boolean z = newsRemindMessage.hasMsgRemind() || newsRemindMessage.hasChatRemind() || newsRemindMessage.hasNotificationRemind();
                if (d.this.fqN != null) {
                    d.this.fqN.l(z, notificationCount);
                }
            }
        }
    };

    public d(com.baidu.adp.base.e eVar) {
        this.mPageContext = eVar;
        this.fqN = new com.baidu.tieba.c.b(this.mPageContext.getPageActivity());
        this.fqN.getView().setOnClickListener(this.mOnClickListener);
        this.mPageContext.registerListener(this.fqg);
    }

    public String getForumId() {
        return this.fFy != null ? this.fFy.getForumId() : "";
    }

    public String getForumName() {
        return this.fFy != null ? this.fFy.getForumName() : "";
    }

    public NavigationBar aJz() {
        return this.mNavigationBar;
    }

    public void onChangeSkinType(int i) {
        if (this.fFy != null && this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.mPageContext, i);
            al.f(this.mNavigationBar.mTextTitle, R.color.cp_cont_b, 1);
            al.f(this.mNavigationBar.mCenterText, R.color.cp_cont_b, 1);
            al.l(this.mNavigationBar.getBottomLine(), R.color.cp_bg_line_b);
            aq.aik().d(this.dHh, R.drawable.icon_topbar_return_n_svg, R.color.select_topbar_icon_color_tint);
            if (this.fqN != null) {
                this.fqN.pH(R.color.select_topbar_icon_color_tint);
                this.fqN.onChangeSkinType(i);
            }
            al.a(this.dzZ, (int) R.drawable.btn_more_selector_s, (int) R.drawable.btn_more_selector);
            al.a(this.fFz, (int) R.drawable.icon_nav_share_selector, (int) R.drawable.icon_nav_share_selector);
        }
    }

    public void a(NavigationBar navigationBar, SpecialFrsWebFragment specialFrsWebFragment) {
        this.mNavigationBar = navigationBar;
        this.fFy = specialFrsWebFragment;
        this.mNavigationBar.showBottomLine();
        this.mNavigationBar.getBarBgView().setAlpha(1.0f);
        this.mNavigationBar.setCenterTextTitle(getForumName());
        this.dHh = (ImageView) this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON).findViewById(R.id.widget_navi_back_button);
        this.dHh.setOnClickListener(this.mOnClickListener);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, l.g(this.mPageContext.getPageActivity(), R.dimen.ds24), 0);
        this.fFz = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.special_frs_web_navigation_share, (View.OnClickListener) null);
        this.fFz.setLayoutParams(layoutParams);
        this.fFz.setOnClickListener(this.mOnClickListener);
        this.dzZ = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.widget_frs_forum_info_item, (View.OnClickListener) null);
        this.dzZ.setLayoutParams(layoutParams);
        this.dzZ.setOnClickListener(this.mOnClickListener);
        setNavBarVisibility(specialFrsWebFragment.isNeedShowNavigationBar());
        dw(specialFrsWebFragment.isNeedShowShareItem());
        ku(specialFrsWebFragment.isNeedShowMenuItem());
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bov() {
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921342);
        customResponsedMessage.setmOrginalMessage(new CustomMessage(2001627, this.mPageContext.getUniqueId()));
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
    }

    public void a(com.baidu.tbadk.coreExtra.c.e eVar) {
        if (this.fFy != null) {
            this.fFy.a(eVar);
        }
    }

    public void setNavBarVisibility(boolean z) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.setVisibility(z ? 0 : 8);
        }
    }

    public void dw(boolean z) {
        if (this.fFz != null) {
            this.fFz.setVisibility(z ? 0 : 8);
        }
    }

    public void ku(boolean z) {
        if (this.dzZ != null) {
            this.dzZ.setVisibility(z ? 0 : 8);
        }
    }

    public void onDestroy() {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.release();
        }
        MessageManager.getInstance().unRegisterListener(this.fqg);
    }
}
