package com.baidu.tieba.im.chat;

import android.content.Context;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;
import com.baidu.tieba.im.message.chat.ChatMessage;
/* loaded from: classes.dex */
public class bz extends com.baidu.adp.base.d<ChatMessage> {
    private TextView b;

    public bz(Context context) {
        super(context, com.baidu.tieba.v.msg_msgmid_view);
        this.b = null;
        b();
    }

    private void b() {
        this.b = (TextView) a(com.baidu.tieba.u.tex_msgcontent);
        this.b.setMovementMethod(LinkMovementMethod.getInstance());
    }

    public void a(ChatMessage chatMessage) {
        if (chatMessage == null) {
            this.b.setText("");
            return;
        }
        String i = com.baidu.tieba.im.d.j.i(chatMessage);
        if (!TextUtils.isEmpty(i)) {
            this.b.setText(i);
        } else {
            this.b.setText("");
        }
    }
}
