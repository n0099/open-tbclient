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
    public final void a(dn dnVar, boolean z) {
        super.a(dnVar, z);
        String string = dnVar.getString(com.baidu.tieba.im.j.msglist_groupinfo);
        if (string != null) {
            String stringExtra = dnVar.getIntent().getStringExtra("group_author_id");
            this.c = this.a.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.im.i.group_info_btn, dnVar);
            this.k = (TextView) this.c.findViewById(com.baidu.tieba.im.h.group_info_btn_txt);
            this.k.setText(string);
            this.l = (ImageView) this.c.findViewById(com.baidu.tieba.im.h.red_dot);
            this.l.setVisibility(8);
            if (!TbadkApplication.E().equals(stringExtra) || com.baidu.tbadk.core.sharedPref.b.a().a("has_shown_group_btn_dot", false)) {
                return;
            }
            this.l.setVisibility(0);
        }
    }

    public final void R() {
        this.l.setVisibility(8);
        com.baidu.tbadk.core.sharedPref.b.a().b("has_shown_group_btn_dot", true);
    }
}
