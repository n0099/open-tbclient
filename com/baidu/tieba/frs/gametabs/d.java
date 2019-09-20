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
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.messageCenter.NewsRemindMessage;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class d {
    private ImageView dBY;
    private ImageView dFm;
    private SpecialFrsWebFragment fNa;
    private ImageView fNb;
    private com.baidu.tieba.c.b fxY;
    private NavigationBar mNavigationBar;
    private com.baidu.adp.base.e mPageContext;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.gametabs.d.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == d.this.dBY) {
                d.this.brx();
            } else if (d.this.fxY == null || view != d.this.fxY.getView()) {
                if (view != d.this.dFm) {
                    if (view == d.this.fNb) {
                        d.this.a(d.this.fNa.r(null, null, null, null));
                    }
                } else if (!StringUtils.isNull(d.this.getForumId())) {
                    d.this.mPageContext.sendMessage(new CustomMessage(2002001, new ForumDetailActivityConfig(d.this.mPageContext.getPageActivity(), d.this.getForumId(), ForumDetailActivityConfig.FromType.FRS_GAME_LIVE)));
                }
            } else if (bc.cF(d.this.mPageContext.getPageActivity())) {
                TiebaStatic.log(new an("c12924").P("obj_locate", 2));
                d.this.mPageContext.sendMessage(new CustomMessage(2002001, new MessageCenterActivityConfig(d.this.mPageContext.getPageActivity())));
            }
        }
    };
    private CustomMessageListener fxr = new CustomMessageListener(2001626) { // from class: com.baidu.tieba.frs.gametabs.d.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            NewsRemindMessage newsRemindMessage;
            if (customResponsedMessage != null && (customResponsedMessage instanceof NewsRemindMessage) && customResponsedMessage.getCmd() == 2001626 && (newsRemindMessage = (NewsRemindMessage) customResponsedMessage) != null) {
                int notificationCount = newsRemindMessage.getNotificationCount() + newsRemindMessage.getMsgCount() + newsRemindMessage.getChatCount();
                boolean z = newsRemindMessage.hasMsgRemind() || newsRemindMessage.hasChatRemind() || newsRemindMessage.hasNotificationRemind();
                if (d.this.fxY != null) {
                    d.this.fxY.l(z, notificationCount);
                }
            }
        }
    };

    public d(com.baidu.adp.base.e eVar) {
        this.mPageContext = eVar;
        this.fxY = new com.baidu.tieba.c.b(this.mPageContext.getPageActivity());
        this.fxY.getView().setOnClickListener(this.mOnClickListener);
        this.mPageContext.registerListener(this.fxr);
    }

    public String getForumId() {
        return this.fNa != null ? this.fNa.getForumId() : "";
    }

    public String getForumName() {
        return this.fNa != null ? this.fNa.getForumName() : "";
    }

    public NavigationBar aLN() {
        return this.mNavigationBar;
    }

    public void onChangeSkinType(int i) {
        if (this.fNa != null && this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.mPageContext, i);
            am.f(this.mNavigationBar.mTextTitle, R.color.cp_cont_b, 1);
            am.f(this.mNavigationBar.mCenterText, R.color.cp_cont_b, 1);
            am.l(this.mNavigationBar.getBottomLine(), R.color.cp_bg_line_c);
            SvgManager.ajv().a(this.dBY, R.drawable.icon_pure_topbar_return_n_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            if (this.fxY != null) {
                this.fxY.onChangeSkinType(i);
            }
            am.a(this.dFm, (int) R.drawable.selector_web_topbar_other_black, (int) R.drawable.selector_web_topbar_other_white);
            SvgManager.ajv().a(this.fNb, R.drawable.icon_pure_topbar_share_n_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    public void a(NavigationBar navigationBar, SpecialFrsWebFragment specialFrsWebFragment) {
        this.mNavigationBar = navigationBar;
        this.fNa = specialFrsWebFragment;
        this.mNavigationBar.showBottomLine();
        this.mNavigationBar.getBarBgView().setAlpha(1.0f);
        this.mNavigationBar.setCenterTextTitle(getForumName());
        this.dBY = (ImageView) this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON).findViewById(R.id.widget_navi_back_button);
        this.dBY.setOnClickListener(this.mOnClickListener);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, l.g(this.mPageContext.getPageActivity(), R.dimen.ds24), 0);
        this.fNb = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.special_frs_web_navigation_share, (View.OnClickListener) null);
        this.fNb.setLayoutParams(layoutParams);
        this.fNb.setOnClickListener(this.mOnClickListener);
        this.dFm = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.widget_frs_forum_info_item, (View.OnClickListener) null);
        this.dFm.setLayoutParams(layoutParams);
        this.dFm.setOnClickListener(this.mOnClickListener);
        setNavBarVisibility(specialFrsWebFragment.isNeedShowNavigationBar());
        dA(specialFrsWebFragment.isNeedShowShareItem());
        kH(specialFrsWebFragment.isNeedShowMenuItem());
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void brx() {
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921342);
        customResponsedMessage.setmOrginalMessage(new CustomMessage(2001627, this.mPageContext.getUniqueId()));
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
    }

    public void a(com.baidu.tbadk.coreExtra.c.e eVar) {
        if (this.fNa != null) {
            this.fNa.a(eVar);
        }
    }

    public void setNavBarVisibility(boolean z) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.setVisibility(z ? 0 : 8);
        }
    }

    public void dA(boolean z) {
        if (this.fNb != null) {
            this.fNb.setVisibility(z ? 0 : 8);
        }
    }

    public void kH(boolean z) {
        if (this.dFm != null) {
            this.dFm.setVisibility(z ? 0 : 8);
        }
    }

    public void onDestroy() {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.release();
        }
        MessageManager.getInstance().unRegisterListener(this.fxr);
    }
}
