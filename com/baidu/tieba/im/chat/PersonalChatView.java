package com.baidu.tieba.im.chat;

import android.widget.TextView;
import com.baidu.tbadk.core.view.NavigationBar;
/* loaded from: classes.dex */
public class PersonalChatView extends CommonPersonalMsglistView {
    private TextView k;

    public PersonalChatView(MsglistActivity msglistActivity, boolean z) {
        super(msglistActivity, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.h
    public void a(dd ddVar, boolean z) {
        super.a(ddVar, z);
        String string = ddVar.getString(com.baidu.tieba.u.msglist_personInfo);
        if (string != null) {
            this.b = this.a.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.s.group_info_btn, ddVar);
            this.k = (TextView) this.b.findViewById(com.baidu.tieba.r.group_info_btn_txt);
            this.k.setText(string);
        }
    }
}
