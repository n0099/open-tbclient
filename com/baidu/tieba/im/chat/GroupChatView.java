package com.baidu.tieba.im.chat;

import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.f;
/* loaded from: classes3.dex */
public class GroupChatView extends CommonGroupMsglistView {
    protected TextView ejM;
    protected ImageView ejN;
    private GroupChatActivity ejO;

    public GroupChatView(MsglistActivity msglistActivity, boolean z) {
        super(msglistActivity, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void initHeader(TalkableActivity talkableActivity, boolean z) {
        super.initHeader(talkableActivity, z);
        this.ejO = (GroupChatActivity) talkableActivity;
        String string = talkableActivity.getPageContext().getString(f.j.msglist_groupinfo);
        if (string != null) {
            String stringExtra = talkableActivity.getIntent().getStringExtra(GroupChatActivityConfig.GROUP_AUTHOR_ID);
            this.mBtnGroupInfo = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, f.h.group_info_btn, talkableActivity);
            this.ejM = (TextView) this.mBtnGroupInfo.findViewById(f.g.group_info_btn_txt);
            this.ejM.setText(string);
            this.ejN = (ImageView) this.mBtnGroupInfo.findViewById(f.g.red_dot);
            this.ejN.setVisibility(8);
            if (!StringUtils.isNull(stringExtra) && stringExtra.equals(TbadkApplication.getCurrentAccount())) {
                aGT();
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
        if (this.ejM != null) {
            am.c(this.ejM, f.d.cp_cont_b, 1);
        }
    }

    public void aGT() {
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("has_shown_group_btn_dot", false)) {
            this.ejN.setVisibility(0);
        }
    }

    public void aGU() {
        this.ejN.setVisibility(8);
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("has_shown_group_btn_dot", true);
    }
}
