package com.baidu.tieba.im.chat;

import android.content.Context;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;
import com.baidu.tieba.im.message.ChatMessage;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class am extends com.baidu.adp.a.c<ChatMessage> {
    private TextView c;

    public am(Context context) {
        super(context, R.layout.msg_msgmid_view);
        this.c = null;
        e();
    }

    private void e() {
        this.c = (TextView) a(R.id.tex_msgcontent);
        this.c.setMovementMethod(LinkMovementMethod.getInstance());
    }

    public void a(ChatMessage chatMessage) {
        if (chatMessage == null) {
            this.c.setText((CharSequence) null);
            return;
        }
        String f = com.baidu.tieba.im.e.d.f(chatMessage);
        if (!TextUtils.isEmpty(f)) {
            this.c.setText(f);
        } else {
            this.c.setText((CharSequence) null);
        }
    }
}
