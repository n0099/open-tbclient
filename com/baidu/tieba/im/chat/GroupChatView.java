package com.baidu.tieba.im.chat;

import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
import com.baidu.tbadk.core.view.NavigationBar;
/* loaded from: classes.dex */
public class GroupChatView extends CommonGroupMsglistView {
    protected TextView mGroupInfoBtnTxt;
    protected ImageView mGroupInfoDot;

    public GroupChatView(MsglistActivity msglistActivity, boolean z) {
        super(msglistActivity, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void initHeader(TalkableActivity talkableActivity, boolean z) {
        super.initHeader(talkableActivity, z);
        String string = talkableActivity.getPageContext().getString(com.baidu.tieba.z.msglist_groupinfo);
        if (string != null) {
            String stringExtra = talkableActivity.getIntent().getStringExtra(GroupChatActivityConfig.GROUP_AUTHOR_ID);
            this.mBtnGroupInfo = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.x.group_info_btn, talkableActivity);
            this.mGroupInfoBtnTxt = (TextView) this.mBtnGroupInfo.findViewById(com.baidu.tieba.w.group_info_btn_txt);
            this.mGroupInfoBtnTxt.setText(string);
            this.mGroupInfoDot = (ImageView) this.mBtnGroupInfo.findViewById(com.baidu.tieba.w.red_dot);
            this.mGroupInfoDot.setVisibility(8);
            if (!StringUtils.isNull(stringExtra) && stringExtra.equals(TbadkApplication.getCurrentAccount())) {
                showInfoDot();
            }
            if (MessageManager.getInstance().findTask(2008011) == null) {
                this.mBtnGroupInfo.setVisibility(4);
            } else {
                this.mBtnGroupInfo.setVisibility(0);
            }
        }
    }

    public void showInfoDot() {
        if (!com.baidu.tbadk.core.sharedPref.b.og().getBoolean("has_shown_group_btn_dot", false)) {
            this.mGroupInfoDot.setVisibility(0);
        }
    }

    public void hideInfoDot() {
        this.mGroupInfoDot.setVisibility(8);
        com.baidu.tbadk.core.sharedPref.b.og().putBoolean("has_shown_group_btn_dot", true);
    }
}
