package com.baidu.tieba.im.chat;

import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class GroupChatView extends CommonGroupMsglistView {
    protected TextView eJW;
    protected ImageView eJX;
    private GroupChatActivity eJY;

    public GroupChatView(MsglistActivity msglistActivity, boolean z) {
        super(msglistActivity, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void initHeader(TalkableActivity talkableActivity, boolean z) {
        super.initHeader(talkableActivity, z);
        this.eJY = (GroupChatActivity) talkableActivity;
        String string = talkableActivity.getPageContext().getString(e.j.msglist_groupinfo);
        if (string != null) {
            String stringExtra = talkableActivity.getIntent().getStringExtra(GroupChatActivityConfig.GROUP_AUTHOR_ID);
            this.mBtnGroupInfo = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, e.h.group_info_btn, talkableActivity);
            this.eJW = (TextView) this.mBtnGroupInfo.findViewById(e.g.group_info_btn_txt);
            this.eJW.setText(string);
            this.eJX = (ImageView) this.mBtnGroupInfo.findViewById(e.g.red_dot);
            this.eJX.setVisibility(8);
            if (!StringUtils.isNull(stringExtra) && stringExtra.equals(TbadkApplication.getCurrentAccount())) {
                aOC();
            }
            if (MessageManager.getInstance().findTask(2008011) == null) {
                this.mBtnGroupInfo.setVisibility(4);
            } else {
                this.mBtnGroupInfo.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.eJW != null) {
            al.c(this.eJW, e.d.cp_cont_b, 1);
        }
    }

    public void aOC() {
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("has_shown_group_btn_dot", false)) {
            this.eJX.setVisibility(0);
        }
    }

    public void aOD() {
        this.eJX.setVisibility(8);
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("has_shown_group_btn_dot", true);
    }
}
