package com.baidu.tieba.frs.gametabs;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.adp.base.f;
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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.messageCenter.NewsRemindMessage;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class d {
    private f eXW;
    private ImageView gYH;
    private ImageView hxw;
    private SpecialFrsWebFragment jCf;
    private ImageView jCg;
    private com.baidu.tieba.c.d jhJ;
    private NavigationBar mNavigationBar;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.gametabs.d.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == d.this.hxw) {
                d.this.cLu();
            } else if (d.this.jhJ == null || view != d.this.jhJ.getView()) {
                if (view != d.this.gYH) {
                    if (view == d.this.jCg) {
                        d.this.showShareDialog(d.this.jCf.D(null, null, null, null));
                    }
                } else if (!StringUtils.isNull(d.this.getForumId())) {
                    d.this.eXW.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumDetailActivityConfig(d.this.eXW.getPageActivity(), d.this.getForumId(), ForumDetailActivityConfig.FromType.FRS_GAME_LIVE)));
                }
            } else if (bg.checkUpIsLogin(d.this.eXW.getPageActivity())) {
                TiebaStatic.log(new aq(CommonStatisticKey.MESSAGE_ENTER_ICON_CLICK).an("obj_locate", 2));
                d.this.eXW.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MessageCenterActivityConfig(d.this.eXW.getPageActivity())));
            }
        }
    };
    private CustomMessageListener jgI = new CustomMessageListener(CmdConfigCustom.CMD_MESSAGE_REMIND) { // from class: com.baidu.tieba.frs.gametabs.d.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            NewsRemindMessage newsRemindMessage;
            if (customResponsedMessage != null && (customResponsedMessage instanceof NewsRemindMessage) && customResponsedMessage.getCmd() == 2001626 && (newsRemindMessage = (NewsRemindMessage) customResponsedMessage) != null) {
                int notificationCount = newsRemindMessage.getNotificationCount() + newsRemindMessage.getMsgCount() + newsRemindMessage.getChatCount();
                boolean z = newsRemindMessage.hasMsgRemind() || newsRemindMessage.hasChatRemind() || newsRemindMessage.hasNotificationRemind();
                if (d.this.jhJ != null) {
                    d.this.jhJ.z(z, notificationCount);
                }
            }
        }
    };

    public d(f fVar) {
        this.eXW = fVar;
        this.jhJ = new com.baidu.tieba.c.d(this.eXW.getPageActivity());
        this.jhJ.getView().setOnClickListener(this.mOnClickListener);
        this.eXW.registerListener(this.jgI);
    }

    public String getForumId() {
        return this.jCf != null ? this.jCf.getForumId() : "";
    }

    public String getForumName() {
        return this.jCf != null ? this.jCf.getForumName() : "";
    }

    public NavigationBar bYr() {
        return this.mNavigationBar;
    }

    public void onChangeSkinType(int i) {
        if (this.jCf != null && this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.eXW, i);
            ao.setViewTextColor(this.mNavigationBar.mTextTitle, R.color.CAM_X0105, 1);
            ao.setViewTextColor(this.mNavigationBar.mCenterText, R.color.CAM_X0105, 1);
            ao.setBackgroundColor(this.mNavigationBar.getBottomLine(), R.color.CAM_X0204);
            SvgManager.bwr().a(this.hxw, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            if (this.jhJ != null) {
                this.jhJ.onChangeSkinType(i);
            }
            ao.setNavbarIconSrc(this.gYH, R.drawable.selector_web_topbar_other_black, R.drawable.selector_web_topbar_other_white);
            SvgManager.bwr().a(this.jCg, R.drawable.icon_pure_topbar_share44_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    public void a(NavigationBar navigationBar, SpecialFrsWebFragment specialFrsWebFragment) {
        this.mNavigationBar = navigationBar;
        this.jCf = specialFrsWebFragment;
        this.mNavigationBar.showBottomLine();
        this.mNavigationBar.getBarBgView().setAlpha(1.0f);
        this.mNavigationBar.setCenterTextTitle(getForumName());
        this.hxw = (ImageView) this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON).findViewById(R.id.widget_navi_back_button);
        this.hxw.setOnClickListener(this.mOnClickListener);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, l.getDimens(this.eXW.getPageActivity(), R.dimen.ds24), 0);
        this.jCg = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.special_frs_web_navigation_share, (View.OnClickListener) null);
        this.jCg.setLayoutParams(layoutParams);
        this.jCg.setOnClickListener(this.mOnClickListener);
        this.gYH = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.widget_frs_forum_info_item, (View.OnClickListener) null);
        this.gYH.setLayoutParams(layoutParams);
        this.gYH.setOnClickListener(this.mOnClickListener);
        setNavBarVisibility(specialFrsWebFragment.isNeedShowNavigationBar());
        je(specialFrsWebFragment.isNeedShowShareItem());
        rj(specialFrsWebFragment.isNeedShowMenuItem());
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cLu() {
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_CLICK_CLOSE_GAME_FRS_CONFIRM);
        customResponsedMessage.setmOrginalMessage(new CustomMessage((int) CmdConfigCustom.CMD_GAME_FRS_TAB_CHANGE, this.eXW.getUniqueId()));
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
    }

    public void showShareDialog(ShareItem shareItem) {
        if (this.jCf != null) {
            this.jCf.showShareDialog(shareItem);
        }
    }

    public void setNavBarVisibility(boolean z) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.setVisibility(z ? 0 : 8);
        }
    }

    public void je(boolean z) {
        if (this.jCg != null) {
            this.jCg.setVisibility(z ? 0 : 8);
        }
    }

    public void rj(boolean z) {
        if (this.gYH != null) {
            this.gYH.setVisibility(z ? 0 : 8);
        }
    }

    public void onDestroy() {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.release();
        }
        MessageManager.getInstance().unRegisterListener(this.jgI);
    }
}
