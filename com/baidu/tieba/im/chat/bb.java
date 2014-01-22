package com.baidu.tieba.im.chat;

import android.content.Context;
import android.widget.TextView;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class bb extends com.baidu.adp.a.c<com.baidu.tieba.im.message.b> {
    private TextView c;

    public bb(Context context) {
        super(context, R.layout.msg_msg_chat_rule_view);
        this.c = (TextView) a(R.id.tex_msgcontent);
    }

    public void a(com.baidu.tieba.im.message.b bVar) {
        String str;
        if (bVar == null) {
            this.c = null;
        } else if ((bVar instanceof com.baidu.tieba.im.message.f) && (str = ((com.baidu.tieba.im.message.f) bVar).b) != null) {
            this.c.setText(str);
        }
    }
}
