package com.baidu.tieba.im.chat;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.im.chat.officialBar.MultiContentView;
import com.baidu.tieba.im.message.chat.ChatMessage;
import java.util.List;
/* loaded from: classes.dex */
public class MsgMultiImageTextView extends cc {
    private MultiContentView aOW;

    public MsgMultiImageTextView(Context context) {
        super(context, com.baidu.tieba.w.msg_multi_pictext_view);
        init();
    }

    private void init() {
        this.auh = (TextView) findViewById(com.baidu.tieba.v.tex_msgitem_time);
        this.aOW = (MultiContentView) findViewById(com.baidu.tieba.v.msg_content);
    }

    public void a(ChatMessage chatMessage, View view) {
        if (chatMessage != null) {
            h(chatMessage);
            List<com.baidu.tieba.im.chat.officialBar.p> ak = com.baidu.tieba.im.chat.officialBar.o.ak(chatMessage.getContent(), chatMessage.getUserInfo().getUserId());
            this.aOW.setPosition(this.Uy);
            this.aOW.setOnItemViewLongClickListener(this.aOL);
            this.aOW.setNeedNightMode(false);
            this.aOW.setType(1);
            this.aOW.a(ak, view);
        }
    }
}
