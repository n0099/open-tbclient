package com.baidu.tieba.im.chat;

import android.content.Context;
import android.widget.TextView;
import com.baidu.tieba.im.message.FakeSystemGroupChatMessage;
import com.baidu.tieba.im.message.chat.ChatMessage;
/* loaded from: classes.dex */
public class by extends com.baidu.adp.base.d<ChatMessage> {
    private TextView b;

    public by(Context context) {
        super(context, com.baidu.tieba.v.msg_msg_chat_rule_view);
        this.b = (TextView) a(com.baidu.tieba.u.tex_msgcontent);
    }

    public void a(ChatMessage chatMessage) {
        String str;
        if (chatMessage == null) {
            this.b = null;
        } else if ((chatMessage instanceof FakeSystemGroupChatMessage) && (str = ((FakeSystemGroupChatMessage) chatMessage).mSystemMsg) != null) {
            this.b.setText(str);
        }
    }
}
