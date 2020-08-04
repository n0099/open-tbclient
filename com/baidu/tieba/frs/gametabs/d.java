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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.messageCenter.NewsRemindMessage;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tieba.R;
/* loaded from: classes16.dex */
public class d {
    private com.baidu.adp.base.e dWk;
    private ImageView fMR;
    private ImageView ggn;
    private com.baidu.tieba.c.d hHZ;
    private SpecialFrsWebFragment hYA;
    private ImageView hYB;
    private NavigationBar mNavigationBar;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.gametabs.d.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == d.this.ggn) {
                d.this.cgB();
            } else if (d.this.hHZ == null || view != d.this.hHZ.getView()) {
                if (view != d.this.fMR) {
                    if (view == d.this.hYB) {
                        d.this.a(d.this.hYA.z(null, null, null, null));
                    }
                } else if (!StringUtils.isNull(d.this.getForumId())) {
                    d.this.dWk.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumDetailActivityConfig(d.this.dWk.getPageActivity(), d.this.getForumId(), ForumDetailActivityConfig.FromType.FRS_GAME_LIVE)));
                }
            } else if (bf.checkUpIsLogin(d.this.dWk.getPageActivity())) {
                TiebaStatic.log(new ap(CommonStatisticKey.MESSAGE_ENTER_ICON_CLICK).ah("obj_locate", 2));
                d.this.dWk.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MessageCenterActivityConfig(d.this.dWk.getPageActivity())));
            }
        }
    };
    private CustomMessageListener hGY = new CustomMessageListener(CmdConfigCustom.CMD_MESSAGE_REMIND) { // from class: com.baidu.tieba.frs.gametabs.d.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            NewsRemindMessage newsRemindMessage;
            if (customResponsedMessage != null && (customResponsedMessage instanceof NewsRemindMessage) && customResponsedMessage.getCmd() == 2001626 && (newsRemindMessage = (NewsRemindMessage) customResponsedMessage) != null) {
                int notificationCount = newsRemindMessage.getNotificationCount() + newsRemindMessage.getMsgCount() + newsRemindMessage.getChatCount();
                boolean z = newsRemindMessage.hasMsgRemind() || newsRemindMessage.hasChatRemind() || newsRemindMessage.hasNotificationRemind();
                if (d.this.hHZ != null) {
                    d.this.hHZ.x(z, notificationCount);
                }
            }
        }
    };

    public d(com.baidu.adp.base.e eVar) {
        this.dWk = eVar;
        this.hHZ = new com.baidu.tieba.c.d(this.dWk.getPageActivity());
        this.hHZ.getView().setOnClickListener(this.mOnClickListener);
        this.dWk.registerListener(this.hGY);
    }

    public String getForumId() {
        return this.hYA != null ? this.hYA.getForumId() : "";
    }

    public String getForumName() {
        return this.hYA != null ? this.hYA.getForumName() : "";
    }

    public NavigationBar bAm() {
        return this.mNavigationBar;
    }

    public void onChangeSkinType(int i) {
        if (this.hYA != null && this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.dWk, i);
            ao.setViewTextColor(this.mNavigationBar.mTextTitle, R.color.cp_cont_b, 1);
            ao.setViewTextColor(this.mNavigationBar.mCenterText, R.color.cp_cont_b, 1);
            ao.setBackgroundColor(this.mNavigationBar.getBottomLine(), R.color.cp_bg_line_c);
            SvgManager.baR().a(this.ggn, R.drawable.icon_pure_topbar_return44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            if (this.hHZ != null) {
                this.hHZ.onChangeSkinType(i);
            }
            ao.setNavbarIconSrc(this.fMR, R.drawable.selector_web_topbar_other_black, R.drawable.selector_web_topbar_other_white);
            SvgManager.baR().a(this.hYB, R.drawable.icon_pure_topbar_share44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    public void a(NavigationBar navigationBar, SpecialFrsWebFragment specialFrsWebFragment) {
        this.mNavigationBar = navigationBar;
        this.hYA = specialFrsWebFragment;
        this.mNavigationBar.showBottomLine();
        this.mNavigationBar.getBarBgView().setAlpha(1.0f);
        this.mNavigationBar.setCenterTextTitle(getForumName());
        this.ggn = (ImageView) this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON).findViewById(R.id.widget_navi_back_button);
        this.ggn.setOnClickListener(this.mOnClickListener);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, l.getDimens(this.dWk.getPageActivity(), R.dimen.ds24), 0);
        this.hYB = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.special_frs_web_navigation_share, (View.OnClickListener) null);
        this.hYB.setLayoutParams(layoutParams);
        this.hYB.setOnClickListener(this.mOnClickListener);
        this.fMR = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.widget_frs_forum_info_item, (View.OnClickListener) null);
        this.fMR.setLayoutParams(layoutParams);
        this.fMR.setOnClickListener(this.mOnClickListener);
        setNavBarVisibility(specialFrsWebFragment.isNeedShowNavigationBar());
        hh(specialFrsWebFragment.isNeedShowShareItem());
        op(specialFrsWebFragment.isNeedShowMenuItem());
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cgB() {
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_CLICK_CLOSE_GAME_FRS_CONFIRM);
        customResponsedMessage.setmOrginalMessage(new CustomMessage((int) CmdConfigCustom.CMD_GAME_FRS_TAB_CHANGE, this.dWk.getUniqueId()));
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
    }

    public void a(ShareItem shareItem) {
        if (this.hYA != null) {
            this.hYA.a(shareItem);
        }
    }

    public void setNavBarVisibility(boolean z) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.setVisibility(z ? 0 : 8);
        }
    }

    public void hh(boolean z) {
        if (this.hYB != null) {
            this.hYB.setVisibility(z ? 0 : 8);
        }
    }

    public void op(boolean z) {
        if (this.fMR != null) {
            this.fMR.setVisibility(z ? 0 : 8);
        }
    }

    public void onDestroy() {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.release();
        }
        MessageManager.getInstance().unRegisterListener(this.hGY);
    }
}
