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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.bh;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.messageCenter.NewsRemindMessage;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class d {
    private f eVB;
    private ImageView gWZ;
    private ImageView hxo;
    private SpecialFrsWebFragment jDt;
    private ImageView jDu;
    private com.baidu.tieba.c.d jiX;
    private NavigationBar mNavigationBar;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.gametabs.d.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == d.this.hxo) {
                d.this.cIW();
            } else if (d.this.jiX == null || view != d.this.jiX.getView()) {
                if (view != d.this.gWZ) {
                    if (view == d.this.jDu) {
                        d.this.showShareDialog(d.this.jDt.D(null, null, null, null));
                    }
                } else if (!StringUtils.isNull(d.this.getForumId())) {
                    d.this.eVB.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumDetailActivityConfig(d.this.eVB.getPageActivity(), d.this.getForumId(), ForumDetailActivityConfig.FromType.FRS_GAME_LIVE)));
                }
            } else if (bh.checkUpIsLogin(d.this.eVB.getPageActivity())) {
                TiebaStatic.log(new ar(CommonStatisticKey.MESSAGE_ENTER_ICON_CLICK).ap("obj_locate", 2));
                d.this.eVB.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MessageCenterActivityConfig(d.this.eVB.getPageActivity())));
            }
        }
    };
    private CustomMessageListener jhV = new CustomMessageListener(CmdConfigCustom.CMD_MESSAGE_REMIND) { // from class: com.baidu.tieba.frs.gametabs.d.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            NewsRemindMessage newsRemindMessage;
            if (customResponsedMessage != null && (customResponsedMessage instanceof NewsRemindMessage) && customResponsedMessage.getCmd() == 2001626 && (newsRemindMessage = (NewsRemindMessage) customResponsedMessage) != null) {
                int notificationCount = newsRemindMessage.getNotificationCount() + newsRemindMessage.getMsgCount() + newsRemindMessage.getChatCount();
                boolean z = newsRemindMessage.hasMsgRemind() || newsRemindMessage.hasChatRemind() || newsRemindMessage.hasNotificationRemind();
                if (d.this.jiX != null) {
                    d.this.jiX.z(z, notificationCount);
                }
            }
        }
    };

    public d(f fVar) {
        this.eVB = fVar;
        this.jiX = new com.baidu.tieba.c.d(this.eVB.getPageActivity());
        this.jiX.getView().setOnClickListener(this.mOnClickListener);
        this.eVB.registerListener(this.jhV);
    }

    public String getForumId() {
        return this.jDt != null ? this.jDt.getForumId() : "";
    }

    public String getForumName() {
        return this.jDt != null ? this.jDt.getForumName() : "";
    }

    public NavigationBar bVk() {
        return this.mNavigationBar;
    }

    public void onChangeSkinType(int i) {
        if (this.jDt != null && this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.eVB, i);
            ap.setViewTextColor(this.mNavigationBar.mTextTitle, R.color.CAM_X0105, 1);
            ap.setViewTextColor(this.mNavigationBar.mCenterText, R.color.CAM_X0105, 1);
            ap.setBackgroundColor(this.mNavigationBar.getBottomLine(), R.color.CAM_X0204);
            SvgManager.bsR().a(this.hxo, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            if (this.jiX != null) {
                this.jiX.onChangeSkinType(i);
            }
            ap.setNavbarIconSrc(this.gWZ, R.drawable.selector_web_topbar_other_black, R.drawable.selector_web_topbar_other_white);
            SvgManager.bsR().a(this.jDu, R.drawable.icon_pure_topbar_share44_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    public void a(NavigationBar navigationBar, SpecialFrsWebFragment specialFrsWebFragment) {
        this.mNavigationBar = navigationBar;
        this.jDt = specialFrsWebFragment;
        this.mNavigationBar.showBottomLine();
        this.mNavigationBar.getBarBgView().setAlpha(1.0f);
        this.mNavigationBar.setCenterTextTitle(getForumName());
        this.hxo = (ImageView) this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON).findViewById(R.id.widget_navi_back_button);
        this.hxo.setOnClickListener(this.mOnClickListener);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, l.getDimens(this.eVB.getPageActivity(), R.dimen.ds24), 0);
        this.jDu = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.special_frs_web_navigation_share, (View.OnClickListener) null);
        this.jDu.setLayoutParams(layoutParams);
        this.jDu.setOnClickListener(this.mOnClickListener);
        this.gWZ = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.widget_frs_forum_info_item, (View.OnClickListener) null);
        this.gWZ.setLayoutParams(layoutParams);
        this.gWZ.setOnClickListener(this.mOnClickListener);
        setNavBarVisibility(specialFrsWebFragment.isNeedShowNavigationBar());
        jc(specialFrsWebFragment.isNeedShowShareItem());
        rp(specialFrsWebFragment.isNeedShowMenuItem());
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cIW() {
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_CLICK_CLOSE_GAME_FRS_CONFIRM);
        customResponsedMessage.setmOrginalMessage(new CustomMessage((int) CmdConfigCustom.CMD_GAME_FRS_TAB_CHANGE, this.eVB.getUniqueId()));
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
    }

    public void showShareDialog(ShareItem shareItem) {
        if (this.jDt != null) {
            this.jDt.showShareDialog(shareItem);
        }
    }

    public void setNavBarVisibility(boolean z) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.setVisibility(z ? 0 : 8);
        }
    }

    public void jc(boolean z) {
        if (this.jDu != null) {
            this.jDu.setVisibility(z ? 0 : 8);
        }
    }

    public void rp(boolean z) {
        if (this.gWZ != null) {
            this.gWZ.setVisibility(z ? 0 : 8);
        }
    }

    public void onDestroy() {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.release();
        }
        MessageManager.getInstance().unRegisterListener(this.jhV);
    }
}
