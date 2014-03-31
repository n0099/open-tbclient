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
    public final void a(dn dnVar, boolean z) {
        super.a(dnVar, z);
        String string = dnVar.getString(com.baidu.tieba.im.j.msglist_personInfo);
        if (string != null) {
            this.c = this.a.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.im.i.group_info_btn, dnVar);
            this.k = (TextView) this.c.findViewById(com.baidu.tieba.im.h.group_info_btn_txt);
            this.k.setText(string);
        }
    }
}
