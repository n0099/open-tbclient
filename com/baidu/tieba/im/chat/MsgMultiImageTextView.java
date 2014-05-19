package com.baidu.tieba.im.chat;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.im.chat.officialBar.MultiContentView;
import com.baidu.tieba.im.message.chat.ChatMessage;
import java.util.List;
/* loaded from: classes.dex */
public class MsgMultiImageTextView extends cd {
    private MultiContentView o;

    public MsgMultiImageTextView(Context context) {
        super(context, com.baidu.tieba.s.msg_multi_pictext_view);
        c();
    }

    private void c() {
        this.h = (TextView) a(com.baidu.tieba.r.tex_msgitem_time);
        this.o = (MultiContentView) a(com.baidu.tieba.r.msg_content);
    }

    public void a(ChatMessage chatMessage, View view) {
        if (chatMessage != null) {
            b(chatMessage);
            List<com.baidu.tieba.im.chat.officialBar.t> a = com.baidu.tieba.im.chat.officialBar.s.a(chatMessage.getContent());
            this.o.setPosition(this.e);
            this.o.setOnItemViewLongClickListener(this.c);
            this.o.setNeedNightMode(false);
            this.o.setType(1);
            this.o.a(a, view);
        }
    }
}
