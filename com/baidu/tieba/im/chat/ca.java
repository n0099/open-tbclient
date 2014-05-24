package com.baidu.tieba.im.chat;

import android.content.Context;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;
import com.baidu.tieba.im.message.chat.ChatMessage;
/* loaded from: classes.dex */
public class ca extends com.baidu.adp.base.a<ChatMessage> {
    private TextView b;

    public ca(Context context) {
        super(context, com.baidu.tieba.w.msg_msgmid_view);
        this.b = null;
        b();
    }

    private void b() {
        this.b = (TextView) a(com.baidu.tieba.v.tex_msgcontent);
        this.b.setMovementMethod(LinkMovementMethod.getInstance());
    }

    public void a(ChatMessage chatMessage) {
        if (chatMessage == null) {
            this.b.setText("");
            return;
        }
        String h = com.baidu.tieba.im.f.r.h(chatMessage);
        if (!TextUtils.isEmpty(h)) {
            this.b.setText(h);
        } else {
            this.b.setText("");
        }
    }
}
