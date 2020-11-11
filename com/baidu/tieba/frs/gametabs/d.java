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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.messageCenter.NewsRemindMessage;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tieba.R;
/* loaded from: classes22.dex */
public class d {
    private com.baidu.adp.base.e eIz;
    private ImageView gEr;
    private ImageView hcj;
    private com.baidu.tieba.c.d iJP;
    private SpecialFrsWebFragment jbr;
    private ImageView jbs;
    private NavigationBar mNavigationBar;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.gametabs.d.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == d.this.hcj) {
                d.this.cDB();
            } else if (d.this.iJP == null || view != d.this.iJP.getView()) {
                if (view != d.this.gEr) {
                    if (view == d.this.jbs) {
                        d.this.a(d.this.jbr.E(null, null, null, null));
                    }
                } else if (!StringUtils.isNull(d.this.getForumId())) {
                    d.this.eIz.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumDetailActivityConfig(d.this.eIz.getPageActivity(), d.this.getForumId(), ForumDetailActivityConfig.FromType.FRS_GAME_LIVE)));
                }
            } else if (bg.checkUpIsLogin(d.this.eIz.getPageActivity())) {
                TiebaStatic.log(new aq(CommonStatisticKey.MESSAGE_ENTER_ICON_CLICK).al("obj_locate", 2));
                d.this.eIz.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MessageCenterActivityConfig(d.this.eIz.getPageActivity())));
            }
        }
    };
    private CustomMessageListener iIO = new CustomMessageListener(CmdConfigCustom.CMD_MESSAGE_REMIND) { // from class: com.baidu.tieba.frs.gametabs.d.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            NewsRemindMessage newsRemindMessage;
            if (customResponsedMessage != null && (customResponsedMessage instanceof NewsRemindMessage) && customResponsedMessage.getCmd() == 2001626 && (newsRemindMessage = (NewsRemindMessage) customResponsedMessage) != null) {
                int notificationCount = newsRemindMessage.getNotificationCount() + newsRemindMessage.getMsgCount() + newsRemindMessage.getChatCount();
                boolean z = newsRemindMessage.hasMsgRemind() || newsRemindMessage.hasChatRemind() || newsRemindMessage.hasNotificationRemind();
                if (d.this.iJP != null) {
                    d.this.iJP.A(z, notificationCount);
                }
            }
        }
    };

    public d(com.baidu.adp.base.e eVar) {
        this.eIz = eVar;
        this.iJP = new com.baidu.tieba.c.d(this.eIz.getPageActivity());
        this.iJP.getView().setOnClickListener(this.mOnClickListener);
        this.eIz.registerListener(this.iIO);
    }

    public String getForumId() {
        return this.jbr != null ? this.jbr.getForumId() : "";
    }

    public String getForumName() {
        return this.jbr != null ? this.jbr.getForumName() : "";
    }

    public NavigationBar bSH() {
        return this.mNavigationBar;
    }

    public void onChangeSkinType(int i) {
        if (this.jbr != null && this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.eIz, i);
            ap.setViewTextColor(this.mNavigationBar.mTextTitle, R.color.cp_cont_b, 1);
            ap.setViewTextColor(this.mNavigationBar.mCenterText, R.color.cp_cont_b, 1);
            ap.setBackgroundColor(this.mNavigationBar.getBottomLine(), R.color.cp_bg_line_c);
            SvgManager.brn().a(this.hcj, R.drawable.icon_pure_topbar_return44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            if (this.iJP != null) {
                this.iJP.onChangeSkinType(i);
            }
            ap.setNavbarIconSrc(this.gEr, R.drawable.selector_web_topbar_other_black, R.drawable.selector_web_topbar_other_white);
            SvgManager.brn().a(this.jbs, R.drawable.icon_pure_topbar_share44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    public void a(NavigationBar navigationBar, SpecialFrsWebFragment specialFrsWebFragment) {
        this.mNavigationBar = navigationBar;
        this.jbr = specialFrsWebFragment;
        this.mNavigationBar.showBottomLine();
        this.mNavigationBar.getBarBgView().setAlpha(1.0f);
        this.mNavigationBar.setCenterTextTitle(getForumName());
        this.hcj = (ImageView) this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON).findViewById(R.id.widget_navi_back_button);
        this.hcj.setOnClickListener(this.mOnClickListener);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, l.getDimens(this.eIz.getPageActivity(), R.dimen.ds24), 0);
        this.jbs = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.special_frs_web_navigation_share, (View.OnClickListener) null);
        this.jbs.setLayoutParams(layoutParams);
        this.jbs.setOnClickListener(this.mOnClickListener);
        this.gEr = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.widget_frs_forum_info_item, (View.OnClickListener) null);
        this.gEr.setLayoutParams(layoutParams);
        this.gEr.setOnClickListener(this.mOnClickListener);
        setNavBarVisibility(specialFrsWebFragment.isNeedShowNavigationBar());
        it(specialFrsWebFragment.isNeedShowShareItem());
        qh(specialFrsWebFragment.isNeedShowMenuItem());
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cDB() {
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_CLICK_CLOSE_GAME_FRS_CONFIRM);
        customResponsedMessage.setmOrginalMessage(new CustomMessage((int) CmdConfigCustom.CMD_GAME_FRS_TAB_CHANGE, this.eIz.getUniqueId()));
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
    }

    public void a(ShareItem shareItem) {
        if (this.jbr != null) {
            this.jbr.a(shareItem);
        }
    }

    public void setNavBarVisibility(boolean z) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.setVisibility(z ? 0 : 8);
        }
    }

    public void it(boolean z) {
        if (this.jbs != null) {
            this.jbs.setVisibility(z ? 0 : 8);
        }
    }

    public void qh(boolean z) {
        if (this.gEr != null) {
            this.gEr.setVisibility(z ? 0 : 8);
        }
    }

    public void onDestroy() {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.release();
        }
        MessageManager.getInstance().unRegisterListener(this.iIO);
    }
}
