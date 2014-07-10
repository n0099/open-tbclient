package com.baidu.tieba.im.chat;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.im.chat.officialBar.MultiContentView;
import com.baidu.tieba.im.message.chat.ChatMessage;
import java.util.List;
/* loaded from: classes.dex */
public class MsgMultiImageTextView extends cd {
    private MultiContentView p;

    public MsgMultiImageTextView(Context context) {
        super(context, com.baidu.tieba.w.msg_multi_pictext_view);
        c();
    }

    private void c() {
        this.h = (TextView) a(com.baidu.tieba.v.tex_msgitem_time);
        this.p = (MultiContentView) a(com.baidu.tieba.v.msg_content);
    }

    public void a(ChatMessage chatMessage, View view) {
        if (chatMessage != null) {
            b(chatMessage);
            List<com.baidu.tieba.im.chat.officialBar.t> a = com.baidu.tieba.im.chat.officialBar.s.a(chatMessage.getContent(), chatMessage.getUserInfo().getUserId());
            this.p.setPosition(this.e);
            this.p.setOnItemViewLongClickListener(this.c);
            this.p.setNeedNightMode(false);
            this.p.setType(1);
            this.p.a(a, view);
        }
    }
}
