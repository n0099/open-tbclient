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
    protected TextView eHf;
    protected ImageView eHg;
    private GroupChatActivity eHh;

    public GroupChatView(MsglistActivity msglistActivity, boolean z) {
        super(msglistActivity, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void initHeader(TalkableActivity talkableActivity, boolean z) {
        super.initHeader(talkableActivity, z);
        this.eHh = (GroupChatActivity) talkableActivity;
        String string = talkableActivity.getPageContext().getString(e.j.msglist_groupinfo);
        if (string != null) {
            String stringExtra = talkableActivity.getIntent().getStringExtra(GroupChatActivityConfig.GROUP_AUTHOR_ID);
            this.mBtnGroupInfo = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, e.h.group_info_btn, talkableActivity);
            this.eHf = (TextView) this.mBtnGroupInfo.findViewById(e.g.group_info_btn_txt);
            this.eHf.setText(string);
            this.eHg = (ImageView) this.mBtnGroupInfo.findViewById(e.g.red_dot);
            this.eHg.setVisibility(8);
            if (!StringUtils.isNull(stringExtra) && stringExtra.equals(TbadkApplication.getCurrentAccount())) {
                aNP();
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
        if (this.eHf != null) {
            al.c(this.eHf, e.d.cp_cont_b, 1);
        }
    }

    public void aNP() {
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("has_shown_group_btn_dot", false)) {
            this.eHg.setVisibility(0);
        }
    }

    public void aNQ() {
        this.eHg.setVisibility(8);
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("has_shown_group_btn_dot", true);
    }
}
