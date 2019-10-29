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
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.CommonStatisticKey;
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
    private com.baidu.adp.base.e cfJ;
    private ImageView dKt;
    private ImageView ebv;
    private SpecialFrsWebFragment fMt;
    private ImageView fMu;
    private com.baidu.tieba.c.b fxm;
    private NavigationBar mNavigationBar;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.gametabs.d.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == d.this.ebv) {
                d.this.boB();
            } else if (d.this.fxm == null || view != d.this.fxm.getView()) {
                if (view != d.this.dKt) {
                    if (view == d.this.fMu) {
                        d.this.a(d.this.fMt.t(null, null, null, null));
                    }
                } else if (!StringUtils.isNull(d.this.getForumId())) {
                    d.this.cfJ.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumDetailActivityConfig(d.this.cfJ.getPageActivity(), d.this.getForumId(), ForumDetailActivityConfig.FromType.FRS_GAME_LIVE)));
                }
            } else if (bc.checkUpIsLogin(d.this.cfJ.getPageActivity())) {
                TiebaStatic.log(new an(CommonStatisticKey.MESSAGE_ENTER_ICON_CLICK).O("obj_locate", 2));
                d.this.cfJ.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MessageCenterActivityConfig(d.this.cfJ.getPageActivity())));
            }
        }
    };
    private CustomMessageListener fwF = new CustomMessageListener(CmdConfigCustom.CMD_MESSAGE_REMIND) { // from class: com.baidu.tieba.frs.gametabs.d.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            NewsRemindMessage newsRemindMessage;
            if (customResponsedMessage != null && (customResponsedMessage instanceof NewsRemindMessage) && customResponsedMessage.getCmd() == 2001626 && (newsRemindMessage = (NewsRemindMessage) customResponsedMessage) != null) {
                int notificationCount = newsRemindMessage.getNotificationCount() + newsRemindMessage.getMsgCount() + newsRemindMessage.getChatCount();
                boolean z = newsRemindMessage.hasMsgRemind() || newsRemindMessage.hasChatRemind() || newsRemindMessage.hasNotificationRemind();
                if (d.this.fxm != null) {
                    d.this.fxm.m(z, notificationCount);
                }
            }
        }
    };

    public d(com.baidu.adp.base.e eVar) {
        this.cfJ = eVar;
        this.fxm = new com.baidu.tieba.c.b(this.cfJ.getPageActivity());
        this.fxm.getView().setOnClickListener(this.mOnClickListener);
        this.cfJ.registerListener(this.fwF);
    }

    public String getForumId() {
        return this.fMt != null ? this.fMt.getForumId() : "";
    }

    public String getForumName() {
        return this.fMt != null ? this.fMt.getForumName() : "";
    }

    public NavigationBar aKR() {
        return this.mNavigationBar;
    }

    public void onChangeSkinType(int i) {
        if (this.fMt != null && this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.cfJ, i);
            am.setViewTextColor(this.mNavigationBar.mTextTitle, R.color.cp_cont_b, 1);
            am.setViewTextColor(this.mNavigationBar.mCenterText, R.color.cp_cont_b, 1);
            am.setBackgroundColor(this.mNavigationBar.getBottomLine(), R.color.cp_bg_line_c);
            SvgManager.amN().a(this.ebv, R.drawable.icon_pure_topbar_return_n_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            if (this.fxm != null) {
                this.fxm.onChangeSkinType(i);
            }
            am.setNavbarIconSrc(this.dKt, R.drawable.selector_web_topbar_other_black, R.drawable.selector_web_topbar_other_white);
            SvgManager.amN().a(this.fMu, R.drawable.icon_pure_topbar_share_n_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    public void a(NavigationBar navigationBar, SpecialFrsWebFragment specialFrsWebFragment) {
        this.mNavigationBar = navigationBar;
        this.fMt = specialFrsWebFragment;
        this.mNavigationBar.showBottomLine();
        this.mNavigationBar.getBarBgView().setAlpha(1.0f);
        this.mNavigationBar.setCenterTextTitle(getForumName());
        this.ebv = (ImageView) this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON).findViewById(R.id.widget_navi_back_button);
        this.ebv.setOnClickListener(this.mOnClickListener);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, l.getDimens(this.cfJ.getPageActivity(), R.dimen.ds24), 0);
        this.fMu = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.special_frs_web_navigation_share, (View.OnClickListener) null);
        this.fMu.setLayoutParams(layoutParams);
        this.fMu.setOnClickListener(this.mOnClickListener);
        this.dKt = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.widget_frs_forum_info_item, (View.OnClickListener) null);
        this.dKt.setLayoutParams(layoutParams);
        this.dKt.setOnClickListener(this.mOnClickListener);
        setNavBarVisibility(specialFrsWebFragment.isNeedShowNavigationBar());
        dR(specialFrsWebFragment.isNeedShowShareItem());
        ku(specialFrsWebFragment.isNeedShowMenuItem());
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void boB() {
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_CLICK_CLOSE_GAME_FRS_CONFIRM);
        customResponsedMessage.setmOrginalMessage(new CustomMessage((int) CmdConfigCustom.CMD_GAME_FRS_TAB_CHANGE, this.cfJ.getUniqueId()));
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
    }

    public void a(com.baidu.tbadk.coreExtra.c.e eVar) {
        if (this.fMt != null) {
            this.fMt.a(eVar);
        }
    }

    public void setNavBarVisibility(boolean z) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.setVisibility(z ? 0 : 8);
        }
    }

    public void dR(boolean z) {
        if (this.fMu != null) {
            this.fMu.setVisibility(z ? 0 : 8);
        }
    }

    public void ku(boolean z) {
        if (this.dKt != null) {
            this.dKt.setVisibility(z ? 0 : 8);
        }
    }

    public void onDestroy() {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.release();
        }
        MessageManager.getInstance().unRegisterListener(this.fwF);
    }
}
