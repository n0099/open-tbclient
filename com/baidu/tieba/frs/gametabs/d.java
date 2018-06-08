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
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class d {
    private ImageView bDU;
    private ImageView bLm;
    private com.baidu.tieba.c.b djf;
    private SpecialFrsWebFragment dvZ;
    private ImageView dwa;
    private ImageView dwb;
    private NavigationBar mNavigationBar;
    private com.baidu.adp.base.e mPageContext;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.gametabs.d.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == d.this.bLm) {
                if (d.this.axL()) {
                    d.this.finishActivity();
                } else {
                    d.this.axM();
                }
            } else if (view != d.this.dwa) {
                if (d.this.djf == null || view != d.this.djf.getView()) {
                    if (view != d.this.bDU) {
                        if (view == d.this.dwb) {
                            d.this.a(d.this.dvZ.m(null, null, null, null));
                        }
                    } else if (!StringUtils.isNull(d.this.getForumId())) {
                        d.this.mPageContext.sendMessage(new CustomMessage(2002001, new ForumDetailActivityConfig(d.this.mPageContext.getPageActivity(), d.this.getForumId(), ForumDetailActivityConfig.FromType.FRS_GAME_LIVE)));
                    }
                } else if (ba.aU(d.this.mPageContext.getPageActivity())) {
                    TiebaStatic.log(new am("c12924").r("obj_locate", 2));
                    d.this.mPageContext.sendMessage(new CustomMessage(2002001, new MessageCenterActivityConfig(d.this.mPageContext.getPageActivity())));
                }
            } else {
                TiebaStatic.log(new am("c12402").ah(ImageViewerConfig.FORUM_ID, d.this.getForumId()).ah("uid", TbadkCoreApplication.getCurrentAccount()).ah(ImageViewerConfig.FORUM_NAME, d.this.getForumName()));
                if (!StringUtils.isNull(d.this.getForumName())) {
                    d.this.mPageContext.sendMessage(new CustomMessage(2002001, new PostSearchActivityConfig(d.this.mPageContext.getPageActivity(), d.this.getForumName(), d.this.getForumId())));
                }
            }
        }
    };
    private CustomMessageListener diF = new CustomMessageListener(2001626) { // from class: com.baidu.tieba.frs.gametabs.d.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            NewsRemindMessage newsRemindMessage;
            if (customResponsedMessage != null && (customResponsedMessage instanceof NewsRemindMessage) && customResponsedMessage.getCmd() == 2001626 && (newsRemindMessage = (NewsRemindMessage) customResponsedMessage) != null) {
                int notificationCount = newsRemindMessage.getNotificationCount() + newsRemindMessage.getMsgCount() + newsRemindMessage.getChatCount();
                boolean z = newsRemindMessage.hasMsgRemind() || newsRemindMessage.hasChatRemind() || newsRemindMessage.hasNotificationRemind();
                if (d.this.djf != null) {
                    d.this.djf.f(z, notificationCount);
                }
            }
        }
    };

    public d(com.baidu.adp.base.e eVar) {
        this.mPageContext = eVar;
        this.djf = new com.baidu.tieba.c.b(this.mPageContext.getPageActivity());
        this.djf.getView().setOnClickListener(this.mOnClickListener);
        this.mPageContext.registerListener(this.diF);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean axL() {
        if (this.dvZ != null) {
            return this.dvZ.axL();
        }
        return false;
    }

    public String getForumId() {
        return this.dvZ != null ? this.dvZ.getForumId() : "";
    }

    public String getForumName() {
        return this.dvZ != null ? this.dvZ.getForumName() : "";
    }

    public NavigationBar UB() {
        return this.mNavigationBar;
    }

    public void onChangeSkinType(int i) {
        if (this.dvZ != null && this.mNavigationBar != null) {
            Pair<Integer, Integer> axK = this.dvZ.axK();
            if (axK != null) {
                this.mNavigationBar.onChangeSkinType(this.mPageContext, i);
                al.c(this.mNavigationBar.mTextTitle, d.C0141d.cp_cont_i, 1);
                al.c(this.mNavigationBar.mCenterText, d.C0141d.cp_cont_i, 1);
                al.j(this.mNavigationBar.getBottomLine(), d.C0141d.cp_bg_line_b);
                com.baidu.tieba.frs.worldcup.b.a(this.mNavigationBar, axK);
                int i2 = d.C0141d.select_topbar_icon_white_color_tint;
                ap.zp().c(this.bLm, d.f.icon_topbar_return_n_svg, i2);
                ap.zp().c(this.dwa, d.f.icon_topbar_search_n_svg, i2);
                if (this.djf != null) {
                    this.djf.jc(i2);
                    this.djf.onChangeSkinType(i);
                }
            } else {
                this.mNavigationBar.onChangeSkinType(this.mPageContext, i);
                al.c(this.mNavigationBar.mTextTitle, d.C0141d.cp_cont_b, 1);
                al.c(this.mNavigationBar.mCenterText, d.C0141d.cp_cont_b, 1);
                al.j(this.mNavigationBar.getBottomLine(), d.C0141d.cp_bg_line_b);
                int i3 = d.C0141d.select_topbar_icon_color_tint;
                ap.zp().c(this.bLm, d.f.icon_topbar_return_n_svg, i3);
                ap.zp().c(this.dwa, d.f.icon_topbar_search_n_svg, i3);
                if (this.djf != null) {
                    this.djf.jc(i3);
                    this.djf.onChangeSkinType(i);
                }
            }
            al.a(this.bDU, d.f.btn_more_selector_s, d.f.btn_more_selector);
            al.a(this.dwb, d.f.icon_nav_share_selector, d.f.icon_nav_share_selector);
        }
    }

    public void a(NavigationBar navigationBar, SpecialFrsWebFragment specialFrsWebFragment) {
        this.mNavigationBar = navigationBar;
        this.dvZ = specialFrsWebFragment;
        this.mNavigationBar.showBottomLine();
        this.mNavigationBar.getBarBgView().setAlpha(1.0f);
        this.mNavigationBar.setCenterTextTitle(getForumName());
        this.bLm = (ImageView) this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON).findViewById(d.g.widget_navi_back_button);
        this.bLm.setOnClickListener(this.mOnClickListener);
        if (axL()) {
            this.dwa = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.i.widget_nb_item_search, (View.OnClickListener) null);
            this.dwa.setOnClickListener(this.mOnClickListener);
            if (this.djf != null && this.djf.getView() != null) {
                this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.djf.getView(), (View.OnClickListener) null);
            }
        } else {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(0, 0, l.e(this.mPageContext.getPageActivity(), d.e.ds24), 0);
            this.dwb = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.i.special_frs_web_navigation_share, (View.OnClickListener) null);
            this.dwb.setLayoutParams(layoutParams);
            this.dwb.setOnClickListener(this.mOnClickListener);
            this.bDU = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.i.widget_frs_forum_info_item, (View.OnClickListener) null);
            this.bDU.setLayoutParams(layoutParams);
            this.bDU.setOnClickListener(this.mOnClickListener);
        }
        setNavBarVisibility(specialFrsWebFragment.isNeedShowNavigationBar());
        aj(specialFrsWebFragment.isNeedShowShareItem());
        fX(specialFrsWebFragment.isNeedShowMenuItem());
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finishActivity() {
        if (this.mPageContext != null) {
            this.mPageContext.getPageActivity().finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void axM() {
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921342);
        customResponsedMessage.setmOrginalMessage(new CustomMessage(2001627, this.mPageContext.getUniqueId()));
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
    }

    public void a(com.baidu.tbadk.coreExtra.c.d dVar) {
        if (this.dvZ != null) {
            this.dvZ.a(dVar);
        }
    }

    public void setNavBarVisibility(boolean z) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.setVisibility(z ? 0 : 8);
        }
    }

    public void aj(boolean z) {
        if (this.dwb != null) {
            this.dwb.setVisibility(z ? 0 : 8);
        }
    }

    public void fX(boolean z) {
        if (this.bDU != null) {
            this.bDU.setVisibility(z ? 0 : 8);
        }
    }

    public void onDestroy() {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.release();
        }
        MessageManager.getInstance().unRegisterListener(this.diF);
    }
}
