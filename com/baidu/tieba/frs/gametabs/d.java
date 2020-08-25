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
/* loaded from: classes16.dex */
public class d {
    private com.baidu.adp.base.e efK;
    private ImageView fYP;
    private ImageView gsv;
    private com.baidu.tieba.c.d hVp;
    private SpecialFrsWebFragment imI;
    private ImageView imJ;
    private NavigationBar mNavigationBar;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.gametabs.d.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == d.this.gsv) {
                d.this.crg();
            } else if (d.this.hVp == null || view != d.this.hVp.getView()) {
                if (view != d.this.fYP) {
                    if (view == d.this.imJ) {
                        d.this.a(d.this.imI.z(null, null, null, null));
                    }
                } else if (!StringUtils.isNull(d.this.getForumId())) {
                    d.this.efK.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumDetailActivityConfig(d.this.efK.getPageActivity(), d.this.getForumId(), ForumDetailActivityConfig.FromType.FRS_GAME_LIVE)));
                }
            } else if (bg.checkUpIsLogin(d.this.efK.getPageActivity())) {
                TiebaStatic.log(new aq(CommonStatisticKey.MESSAGE_ENTER_ICON_CLICK).ai("obj_locate", 2));
                d.this.efK.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MessageCenterActivityConfig(d.this.efK.getPageActivity())));
            }
        }
    };
    private CustomMessageListener hUo = new CustomMessageListener(CmdConfigCustom.CMD_MESSAGE_REMIND) { // from class: com.baidu.tieba.frs.gametabs.d.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            NewsRemindMessage newsRemindMessage;
            if (customResponsedMessage != null && (customResponsedMessage instanceof NewsRemindMessage) && customResponsedMessage.getCmd() == 2001626 && (newsRemindMessage = (NewsRemindMessage) customResponsedMessage) != null) {
                int notificationCount = newsRemindMessage.getNotificationCount() + newsRemindMessage.getMsgCount() + newsRemindMessage.getChatCount();
                boolean z = newsRemindMessage.hasMsgRemind() || newsRemindMessage.hasChatRemind() || newsRemindMessage.hasNotificationRemind();
                if (d.this.hVp != null) {
                    d.this.hVp.x(z, notificationCount);
                }
            }
        }
    };

    public d(com.baidu.adp.base.e eVar) {
        this.efK = eVar;
        this.hVp = new com.baidu.tieba.c.d(this.efK.getPageActivity());
        this.hVp.getView().setOnClickListener(this.mOnClickListener);
        this.efK.registerListener(this.hUo);
    }

    public String getForumId() {
        return this.imI != null ? this.imI.getForumId() : "";
    }

    public String getForumName() {
        return this.imI != null ? this.imI.getForumName() : "";
    }

    public NavigationBar bJH() {
        return this.mNavigationBar;
    }

    public void onChangeSkinType(int i) {
        if (this.imI != null && this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.efK, i);
            ap.setViewTextColor(this.mNavigationBar.mTextTitle, R.color.cp_cont_b, 1);
            ap.setViewTextColor(this.mNavigationBar.mCenterText, R.color.cp_cont_b, 1);
            ap.setBackgroundColor(this.mNavigationBar.getBottomLine(), R.color.cp_bg_line_c);
            SvgManager.bjq().a(this.gsv, R.drawable.icon_pure_topbar_return44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            if (this.hVp != null) {
                this.hVp.onChangeSkinType(i);
            }
            ap.setNavbarIconSrc(this.fYP, R.drawable.selector_web_topbar_other_black, R.drawable.selector_web_topbar_other_white);
            SvgManager.bjq().a(this.imJ, R.drawable.icon_pure_topbar_share44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    public void a(NavigationBar navigationBar, SpecialFrsWebFragment specialFrsWebFragment) {
        this.mNavigationBar = navigationBar;
        this.imI = specialFrsWebFragment;
        this.mNavigationBar.showBottomLine();
        this.mNavigationBar.getBarBgView().setAlpha(1.0f);
        this.mNavigationBar.setCenterTextTitle(getForumName());
        this.gsv = (ImageView) this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON).findViewById(R.id.widget_navi_back_button);
        this.gsv.setOnClickListener(this.mOnClickListener);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, l.getDimens(this.efK.getPageActivity(), R.dimen.ds24), 0);
        this.imJ = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.special_frs_web_navigation_share, (View.OnClickListener) null);
        this.imJ.setLayoutParams(layoutParams);
        this.imJ.setOnClickListener(this.mOnClickListener);
        this.fYP = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.widget_frs_forum_info_item, (View.OnClickListener) null);
        this.fYP.setLayoutParams(layoutParams);
        this.fYP.setOnClickListener(this.mOnClickListener);
        setNavBarVisibility(specialFrsWebFragment.isNeedShowNavigationBar());
        hD(specialFrsWebFragment.isNeedShowShareItem());
        oT(specialFrsWebFragment.isNeedShowMenuItem());
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void crg() {
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_CLICK_CLOSE_GAME_FRS_CONFIRM);
        customResponsedMessage.setmOrginalMessage(new CustomMessage((int) CmdConfigCustom.CMD_GAME_FRS_TAB_CHANGE, this.efK.getUniqueId()));
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
    }

    public void a(ShareItem shareItem) {
        if (this.imI != null) {
            this.imI.a(shareItem);
        }
    }

    public void setNavBarVisibility(boolean z) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.setVisibility(z ? 0 : 8);
        }
    }

    public void hD(boolean z) {
        if (this.imJ != null) {
            this.imJ.setVisibility(z ? 0 : 8);
        }
    }

    public void oT(boolean z) {
        if (this.fYP != null) {
            this.fYP.setVisibility(z ? 0 : 8);
        }
    }

    public void onDestroy() {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.release();
        }
        MessageManager.getInstance().unRegisterListener(this.hUo);
    }
}
