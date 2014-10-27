package com.baidu.tieba.im.chat;

import android.content.Context;
import android.widget.TextView;
import com.baidu.tieba.im.message.FakeSystemGroupChatMessage;
import com.baidu.tieba.im.message.chat.ChatMessage;
/* loaded from: classes.dex */
public class by extends com.baidu.adp.base.d<ChatMessage> {
    private TextView mTextView;

    public by(Context context) {
        super(context, com.baidu.tieba.w.msg_msg_chat_rule_view);
        this.mTextView = (TextView) findViewById(com.baidu.tieba.v.tex_msgcontent);
    }

    public void setData(ChatMessage chatMessage) {
        String str;
        if (chatMessage == null) {
            this.mTextView = null;
        } else if ((chatMessage instanceof FakeSystemGroupChatMessage) && (str = ((FakeSystemGroupChatMessage) chatMessage).mSystemMsg) != null) {
            this.mTextView.setText(str);
        }
    }
}
