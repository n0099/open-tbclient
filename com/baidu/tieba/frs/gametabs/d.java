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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.bh;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.messageCenter.NewsRemindMessage;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tieba.R;
/* loaded from: classes22.dex */
public class d {
    private com.baidu.adp.base.e eNZ;
    private ImageView gMX;
    private ImageView hlB;
    private com.baidu.tieba.d.d iVx;
    private SpecialFrsWebFragment jpI;
    private ImageView jpJ;
    private NavigationBar mNavigationBar;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.gametabs.d.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == d.this.hlB) {
                d.this.cIt();
            } else if (d.this.iVx == null || view != d.this.iVx.getView()) {
                if (view != d.this.gMX) {
                    if (view == d.this.jpJ) {
                        d.this.showShareDialog(d.this.jpI.E(null, null, null, null));
                    }
                } else if (!StringUtils.isNull(d.this.getForumId())) {
                    d.this.eNZ.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumDetailActivityConfig(d.this.eNZ.getPageActivity(), d.this.getForumId(), ForumDetailActivityConfig.FromType.FRS_GAME_LIVE)));
                }
            } else if (bh.checkUpIsLogin(d.this.eNZ.getPageActivity())) {
                TiebaStatic.log(new ar(CommonStatisticKey.MESSAGE_ENTER_ICON_CLICK).al("obj_locate", 2));
                d.this.eNZ.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MessageCenterActivityConfig(d.this.eNZ.getPageActivity())));
            }
        }
    };
    private CustomMessageListener iUw = new CustomMessageListener(CmdConfigCustom.CMD_MESSAGE_REMIND) { // from class: com.baidu.tieba.frs.gametabs.d.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            NewsRemindMessage newsRemindMessage;
            if (customResponsedMessage != null && (customResponsedMessage instanceof NewsRemindMessage) && customResponsedMessage.getCmd() == 2001626 && (newsRemindMessage = (NewsRemindMessage) customResponsedMessage) != null) {
                int notificationCount = newsRemindMessage.getNotificationCount() + newsRemindMessage.getMsgCount() + newsRemindMessage.getChatCount();
                boolean z = newsRemindMessage.hasMsgRemind() || newsRemindMessage.hasChatRemind() || newsRemindMessage.hasNotificationRemind();
                if (d.this.iVx != null) {
                    d.this.iVx.A(z, notificationCount);
                }
            }
        }
    };

    public d(com.baidu.adp.base.e eVar) {
        this.eNZ = eVar;
        this.iVx = new com.baidu.tieba.d.d(this.eNZ.getPageActivity());
        this.iVx.getView().setOnClickListener(this.mOnClickListener);
        this.eNZ.registerListener(this.iUw);
    }

    public String getForumId() {
        return this.jpI != null ? this.jpI.getForumId() : "";
    }

    public String getForumName() {
        return this.jpI != null ? this.jpI.getForumName() : "";
    }

    public NavigationBar bVL() {
        return this.mNavigationBar;
    }

    public void onChangeSkinType(int i) {
        if (this.jpI != null && this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.eNZ, i);
            ap.setViewTextColor(this.mNavigationBar.mTextTitle, R.color.CAM_X0105, 1);
            ap.setViewTextColor(this.mNavigationBar.mCenterText, R.color.CAM_X0105, 1);
            ap.setBackgroundColor(this.mNavigationBar.getBottomLine(), R.color.CAM_X0204);
            SvgManager.btW().a(this.hlB, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            if (this.iVx != null) {
                this.iVx.onChangeSkinType(i);
            }
            ap.setNavbarIconSrc(this.gMX, R.drawable.selector_web_topbar_other_black, R.drawable.selector_web_topbar_other_white);
            SvgManager.btW().a(this.jpJ, R.drawable.icon_pure_topbar_share44_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    public void a(NavigationBar navigationBar, SpecialFrsWebFragment specialFrsWebFragment) {
        this.mNavigationBar = navigationBar;
        this.jpI = specialFrsWebFragment;
        this.mNavigationBar.showBottomLine();
        this.mNavigationBar.getBarBgView().setAlpha(1.0f);
        this.mNavigationBar.setCenterTextTitle(getForumName());
        this.hlB = (ImageView) this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON).findViewById(R.id.widget_navi_back_button);
        this.hlB.setOnClickListener(this.mOnClickListener);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, l.getDimens(this.eNZ.getPageActivity(), R.dimen.ds24), 0);
        this.jpJ = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.special_frs_web_navigation_share, (View.OnClickListener) null);
        this.jpJ.setLayoutParams(layoutParams);
        this.jpJ.setOnClickListener(this.mOnClickListener);
        this.gMX = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.widget_frs_forum_info_item, (View.OnClickListener) null);
        this.gMX.setLayoutParams(layoutParams);
        this.gMX.setOnClickListener(this.mOnClickListener);
        setNavBarVisibility(specialFrsWebFragment.isNeedShowNavigationBar());
        iJ(specialFrsWebFragment.isNeedShowShareItem());
        qL(specialFrsWebFragment.isNeedShowMenuItem());
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cIt() {
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_CLICK_CLOSE_GAME_FRS_CONFIRM);
        customResponsedMessage.setmOrginalMessage(new CustomMessage((int) CmdConfigCustom.CMD_GAME_FRS_TAB_CHANGE, this.eNZ.getUniqueId()));
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
    }

    public void showShareDialog(ShareItem shareItem) {
        if (this.jpI != null) {
            this.jpI.showShareDialog(shareItem);
        }
    }

    public void setNavBarVisibility(boolean z) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.setVisibility(z ? 0 : 8);
        }
    }

    public void iJ(boolean z) {
        if (this.jpJ != null) {
            this.jpJ.setVisibility(z ? 0 : 8);
        }
    }

    public void qL(boolean z) {
        if (this.gMX != null) {
            this.gMX.setVisibility(z ? 0 : 8);
        }
    }

    public void onDestroy() {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.release();
        }
        MessageManager.getInstance().unRegisterListener(this.iUw);
    }
}
