package com.baidu.tieba.im.chat;

import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
import com.baidu.tbadk.core.view.NavigationBar;
/* loaded from: classes.dex */
public class GroupChatView extends CommonGroupMsglistView {
    protected TextView aOt;
    protected ImageView aOu;

    public GroupChatView(MsglistActivity msglistActivity, boolean z) {
        super(msglistActivity, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void initHeader(TalkableActivity talkableActivity, boolean z) {
        super.initHeader(talkableActivity, z);
        String string = talkableActivity.getString(com.baidu.tieba.y.msglist_groupinfo);
        if (string != null) {
            String stringExtra = talkableActivity.getIntent().getStringExtra(GroupChatActivityConfig.GROUP_AUTHOR_ID);
            this.mBtnGroupInfo = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.w.group_info_btn, talkableActivity);
            this.aOt = (TextView) this.mBtnGroupInfo.findViewById(com.baidu.tieba.v.group_info_btn_txt);
            this.aOt.setText(string);
            this.aOu = (ImageView) this.mBtnGroupInfo.findViewById(com.baidu.tieba.v.red_dot);
            this.aOu.setVisibility(8);
            if (TbadkApplication.getCurrentAccount().equals(stringExtra)) {
                JB();
            }
        }
    }

    public void JB() {
        if (!com.baidu.tbadk.core.sharedPref.b.lk().getBoolean("has_shown_group_btn_dot", false)) {
            this.aOu.setVisibility(0);
        }
    }

    public void JC() {
        this.aOu.setVisibility(8);
        com.baidu.tbadk.core.sharedPref.b.lk().putBoolean("has_shown_group_btn_dot", true);
    }
}
