package com.baidu.tieba.im.chat;

import android.content.Context;
import android.widget.TextView;
/* loaded from: classes.dex */
public final class ce extends com.baidu.adp.a.d<com.baidu.tieba.im.message.a.a> {
    private TextView c;

    public ce(Context context) {
        super(context, com.baidu.tieba.im.i.msg_msg_chat_rule_view);
        this.c = (TextView) a(com.baidu.tieba.im.h.tex_msgcontent);
    }

    public final void a(com.baidu.tieba.im.message.a.a aVar) {
        String str;
        if (aVar == null) {
            this.c = null;
        } else if ((aVar instanceof com.baidu.tieba.im.message.b) && (str = ((com.baidu.tieba.im.message.b) aVar).a) != null) {
            this.c.setText(str);
        }
    }
}
