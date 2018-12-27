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
    private ImageView bZG;
    private ImageView cgR;
    private com.baidu.tieba.c.b dMy;
    private SpecialFrsWebFragment ebc;
    private ImageView ebd;
    private ImageView ebe;
    private NavigationBar mNavigationBar;
    private com.baidu.adp.base.e mPageContext;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.gametabs.d.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == d.this.cgR) {
                if (d.this.aGq()) {
                    d.this.finishActivity();
                } else {
                    d.this.aGr();
                }
            } else if (view != d.this.ebd) {
                if (d.this.dMy == null || view != d.this.dMy.getView()) {
                    if (view != d.this.bZG) {
                        if (view == d.this.ebe) {
                            d.this.a(d.this.ebc.m(null, null, null, null));
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
    private CustomMessageListener dLX = new CustomMessageListener(2001626) { // from class: com.baidu.tieba.frs.gametabs.d.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            NewsRemindMessage newsRemindMessage;
            if (customResponsedMessage != null && (customResponsedMessage instanceof NewsRemindMessage) && customResponsedMessage.getCmd() == 2001626 && (newsRemindMessage = (NewsRemindMessage) customResponsedMessage) != null) {
                int notificationCount = newsRemindMessage.getNotificationCount() + newsRemindMessage.getMsgCount() + newsRemindMessage.getChatCount();
                boolean z = newsRemindMessage.hasMsgRemind() || newsRemindMessage.hasChatRemind() || newsRemindMessage.hasNotificationRemind();
                if (d.this.dMy != null) {
                    d.this.dMy.h(z, notificationCount);
                }
            }
        }
    };

    public d(com.baidu.adp.base.e eVar) {
        this.mPageContext = eVar;
        this.dMy = new com.baidu.tieba.c.b(this.mPageContext.getPageActivity());
        this.dMy.getView().setOnClickListener(this.mOnClickListener);
        this.mPageContext.registerListener(this.dLX);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aGq() {
        if (this.ebc != null) {
            return this.ebc.aGq();
        }
        return false;
    }

    public String getForumId() {
        return this.ebc != null ? this.ebc.getForumId() : "";
    }

    public String getForumName() {
        return this.ebc != null ? this.ebc.getForumName() : "";
    }

    public NavigationBar abW() {
        return this.mNavigationBar;
    }

    public void onChangeSkinType(int i) {
        if (this.ebc != null && this.mNavigationBar != null) {
            Pair<Integer, Integer> aGp = this.ebc.aGp();
            if (aGp != null) {
                this.mNavigationBar.onChangeSkinType(this.mPageContext, i);
                al.c(this.mNavigationBar.mTextTitle, e.d.cp_cont_i, 1);
                al.c(this.mNavigationBar.mCenterText, e.d.cp_cont_i, 1);
                al.j(this.mNavigationBar.getBottomLine(), e.d.cp_bg_line_b);
                com.baidu.tieba.frs.worldcup.b.a(this.mNavigationBar, aGp);
                int i2 = e.d.select_topbar_icon_white_color_tint;
                ap.DQ().c(this.cgR, e.f.icon_topbar_return_n_svg, i2);
                ap.DQ().c(this.ebd, e.f.icon_topbar_search_n_svg, i2);
                if (this.dMy != null) {
                    this.dMy.le(i2);
                    this.dMy.onChangeSkinType(i);
                }
            } else {
                this.mNavigationBar.onChangeSkinType(this.mPageContext, i);
                al.c(this.mNavigationBar.mTextTitle, e.d.cp_cont_b, 1);
                al.c(this.mNavigationBar.mCenterText, e.d.cp_cont_b, 1);
                al.j(this.mNavigationBar.getBottomLine(), e.d.cp_bg_line_b);
                int i3 = e.d.select_topbar_icon_color_tint;
                ap.DQ().c(this.cgR, e.f.icon_topbar_return_n_svg, i3);
                ap.DQ().c(this.ebd, e.f.icon_topbar_search_n_svg, i3);
                if (this.dMy != null) {
                    this.dMy.le(i3);
                    this.dMy.onChangeSkinType(i);
                }
            }
            al.a(this.bZG, e.f.btn_more_selector_s, e.f.btn_more_selector);
            al.a(this.ebe, e.f.icon_nav_share_selector, e.f.icon_nav_share_selector);
        }
    }

    public void a(NavigationBar navigationBar, SpecialFrsWebFragment specialFrsWebFragment) {
        this.mNavigationBar = navigationBar;
        this.ebc = specialFrsWebFragment;
        this.mNavigationBar.showBottomLine();
        this.mNavigationBar.getBarBgView().setAlpha(1.0f);
        this.mNavigationBar.setCenterTextTitle(getForumName());
        this.cgR = (ImageView) this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON).findViewById(e.g.widget_navi_back_button);
        this.cgR.setOnClickListener(this.mOnClickListener);
        if (aGq()) {
            this.ebd = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, e.h.widget_nb_item_search, (View.OnClickListener) null);
            this.ebd.setOnClickListener(this.mOnClickListener);
            if (this.dMy != null && this.dMy.getView() != null) {
                this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.dMy.getView(), (View.OnClickListener) null);
            }
        } else {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(0, 0, l.h(this.mPageContext.getPageActivity(), e.C0210e.ds24), 0);
            this.ebe = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, e.h.special_frs_web_navigation_share, (View.OnClickListener) null);
            this.ebe.setLayoutParams(layoutParams);
            this.ebe.setOnClickListener(this.mOnClickListener);
            this.bZG = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, e.h.widget_frs_forum_info_item, (View.OnClickListener) null);
            this.bZG.setLayoutParams(layoutParams);
            this.bZG.setOnClickListener(this.mOnClickListener);
        }
        setNavBarVisibility(specialFrsWebFragment.isNeedShowNavigationBar());
        aR(specialFrsWebFragment.isNeedShowShareItem());
        hk(specialFrsWebFragment.isNeedShowMenuItem());
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finishActivity() {
        if (this.mPageContext != null) {
            this.mPageContext.getPageActivity().finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aGr() {
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921342);
        customResponsedMessage.setmOrginalMessage(new CustomMessage(2001627, this.mPageContext.getUniqueId()));
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
    }

    public void a(com.baidu.tbadk.coreExtra.c.d dVar) {
        if (this.ebc != null) {
            this.ebc.a(dVar);
        }
    }

    public void setNavBarVisibility(boolean z) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.setVisibility(z ? 0 : 8);
        }
    }

    public void aR(boolean z) {
        if (this.ebe != null) {
            this.ebe.setVisibility(z ? 0 : 8);
        }
    }

    public void hk(boolean z) {
        if (this.bZG != null) {
            this.bZG.setVisibility(z ? 0 : 8);
        }
    }

    public void onDestroy() {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.release();
        }
        MessageManager.getInstance().unRegisterListener(this.dLX);
    }
}
