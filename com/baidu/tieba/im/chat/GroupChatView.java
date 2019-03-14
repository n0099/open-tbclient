package com.baidu.tieba.im.chat;

import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class GroupChatView extends CommonGroupMsglistView {
    protected TextView gaK;
    protected ImageView gaL;
    private GroupChatActivity gaM;

    public GroupChatView(MsglistActivity msglistActivity, boolean z) {
        super(msglistActivity, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void initHeader(TalkableActivity talkableActivity, boolean z) {
        super.initHeader(talkableActivity, z);
        this.gaM = (GroupChatActivity) talkableActivity;
        String string = talkableActivity.getPageContext().getString(d.j.msglist_groupinfo);
        if (string != null) {
            String stringExtra = talkableActivity.getIntent().getStringExtra(GroupChatActivityConfig.GROUP_AUTHOR_ID);
            this.mBtnGroupInfo = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.group_info_btn, talkableActivity);
            this.gaK = (TextView) this.mBtnGroupInfo.findViewById(d.g.group_info_btn_txt);
            this.gaK.setText(string);
            this.gaL = (ImageView) this.mBtnGroupInfo.findViewById(d.g.red_dot);
            this.gaL.setVisibility(8);
            if (!StringUtils.isNull(stringExtra) && stringExtra.equals(TbadkApplication.getCurrentAccount())) {
                bpH();
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
        if (this.gaK != null) {
            al.d(this.gaK, d.C0277d.cp_cont_b, 1);
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        }
    }

    public void bpH() {
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("has_shown_group_btn_dot", false)) {
            this.gaL.setVisibility(0);
        }
    }

    public void bpI() {
        this.gaL.setVisibility(8);
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("has_shown_group_btn_dot", true);
    }
}
