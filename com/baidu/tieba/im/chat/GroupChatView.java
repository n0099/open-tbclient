package com.baidu.tieba.im.chat;

import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.view.NavigationBar;
/* loaded from: classes.dex */
public class GroupChatView extends CommonGroupMsglistView {
    protected TextView k;
    protected ImageView l;

    public GroupChatView(MsglistActivity msglistActivity, boolean z) {
        super(msglistActivity, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.h
    public void a(dd ddVar, boolean z) {
        super.a(ddVar, z);
        String string = ddVar.getString(com.baidu.tieba.u.msglist_groupinfo);
        if (string != null) {
            String stringExtra = ddVar.getIntent().getStringExtra("group_author_id");
            this.b = this.a.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.s.group_info_btn, ddVar);
            this.k = (TextView) this.b.findViewById(com.baidu.tieba.r.group_info_btn_txt);
            this.k.setText(string);
            this.l = (ImageView) this.b.findViewById(com.baidu.tieba.r.red_dot);
            this.l.setVisibility(8);
            if (TbadkApplication.getCurrentAccount().equals(stringExtra)) {
                Q();
            }
        }
    }

    public void Q() {
        if (!com.baidu.tbadk.core.sharedPref.b.a().a("has_shown_group_btn_dot", false)) {
            this.l.setVisibility(0);
        }
    }

    public void R() {
        this.l.setVisibility(8);
        com.baidu.tbadk.core.sharedPref.b.a().b("has_shown_group_btn_dot", true);
    }
}
