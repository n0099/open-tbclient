package com.baidu.tieba.im.chat;

import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.im.message.FakeSystemGroupChatMessage;
import com.baidu.tieba.im.message.chat.ChatMessage;
/* loaded from: classes.dex */
public class av extends com.baidu.adp.base.e<MsglistActivity<?>> {
    private TextView mTextView;

    public av(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, com.baidu.tieba.x.msg_msg_chat_rule_view);
        this.mTextView = (TextView) findViewById(com.baidu.tieba.w.tex_msgcontent);
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
