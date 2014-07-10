package com.baidu.tieba.im.chat;

import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.view.NavigationBar;
/* loaded from: classes.dex */
public class GroupChatView extends CommonGroupMsglistView {
    protected TextView l;
    protected ImageView m;

    public GroupChatView(MsglistActivity msglistActivity, boolean z) {
        super(msglistActivity, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.g
    public void a(TalkableActivity talkableActivity, boolean z) {
        super.a(talkableActivity, z);
        String string = talkableActivity.getString(com.baidu.tieba.y.msglist_groupinfo);
        if (string != null) {
            String stringExtra = talkableActivity.getIntent().getStringExtra("group_author_id");
            this.b = this.a.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.w.group_info_btn, talkableActivity);
            this.l = (TextView) this.b.findViewById(com.baidu.tieba.v.group_info_btn_txt);
            this.l.setText(string);
            this.m = (ImageView) this.b.findViewById(com.baidu.tieba.v.red_dot);
            this.m.setVisibility(8);
            if (TbadkApplication.getCurrentAccount().equals(stringExtra)) {
                S();
            }
        }
    }

    public void S() {
        if (!com.baidu.tbadk.core.sharedPref.b.a().a("has_shown_group_btn_dot", false)) {
            this.m.setVisibility(0);
        }
    }

    public void T() {
        this.m.setVisibility(8);
        com.baidu.tbadk.core.sharedPref.b.a().c("has_shown_group_btn_dot", true);
    }
}
