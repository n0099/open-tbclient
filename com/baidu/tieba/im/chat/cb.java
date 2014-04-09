package com.baidu.tieba.im.chat;

import android.content.Context;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;
/* loaded from: classes.dex */
public final class cb extends com.baidu.adp.a.d<com.baidu.tieba.im.message.a.a> {
    private TextView c;

    public cb(Context context) {
        super(context, com.baidu.tieba.im.i.msg_msgmid_view);
        this.c = null;
        this.c = (TextView) a(com.baidu.tieba.im.h.tex_msgcontent);
        this.c.setMovementMethod(LinkMovementMethod.getInstance());
    }

    public final void a(com.baidu.tieba.im.message.a.a aVar) {
        if (aVar != null) {
            String g = com.baidu.tieba.im.f.q.g(aVar);
            if (!TextUtils.isEmpty(g)) {
                this.c.setText(g);
                return;
            }
        }
        this.c.setText("");
    }
}
