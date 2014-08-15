package com.baidu.tieba.im.chat;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.im.chat.officialBar.MultiContentView;
import com.baidu.tieba.im.message.chat.ChatMessage;
import java.util.List;
/* loaded from: classes.dex */
public class MsgMultiImageTextView extends cb {
    private MultiContentView p;

    public MsgMultiImageTextView(Context context) {
        super(context, com.baidu.tieba.v.msg_multi_pictext_view);
        c();
    }

    private void c() {
        this.g = (TextView) a(com.baidu.tieba.u.tex_msgitem_time);
        this.p = (MultiContentView) a(com.baidu.tieba.u.msg_content);
    }

    public void a(ChatMessage chatMessage, View view) {
        if (chatMessage != null) {
            b(chatMessage);
            List<com.baidu.tieba.im.chat.officialBar.p> a = com.baidu.tieba.im.chat.officialBar.o.a(chatMessage.getContent(), chatMessage.getUserInfo().getUserId());
            this.p.setPosition(this.d);
            this.p.setOnItemViewLongClickListener(this.c);
            this.p.setNeedNightMode(false);
            this.p.setType(1);
            this.p.a(a, view);
        }
    }
}
