package com.baidu.tieba.im.chat;

import android.content.Context;
import android.widget.TextView;
import com.baidu.tieba.im.message.FakeSystemGroupChatMessage;
import com.baidu.tieba.im.message.chat.ChatMessage;
/* loaded from: classes.dex */
public class ca extends com.baidu.adp.base.d<ChatMessage> {
    private TextView b;

    public ca(Context context) {
        super(context, com.baidu.tieba.w.msg_msg_chat_rule_view);
        this.b = (TextView) a(com.baidu.tieba.v.tex_msgcontent);
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
