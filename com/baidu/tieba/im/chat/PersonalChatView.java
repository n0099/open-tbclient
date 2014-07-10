package com.baidu.tieba.im.chat;

import android.widget.TextView;
import com.baidu.tbadk.core.view.NavigationBar;
/* loaded from: classes.dex */
public class PersonalChatView extends CommonPersonalMsglistView {
    private TextView l;

    public PersonalChatView(MsglistActivity msglistActivity, boolean z) {
        super(msglistActivity, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.g
    public void a(TalkableActivity talkableActivity, boolean z) {
        super.a(talkableActivity, z);
        String string = talkableActivity.getString(com.baidu.tieba.y.msglist_personInfo);
        if (string != null) {
            this.b = this.a.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.w.group_info_btn, talkableActivity);
            this.l = (TextView) this.b.findViewById(com.baidu.tieba.v.group_info_btn_txt);
            this.l.setText(string);
        }
    }
}
