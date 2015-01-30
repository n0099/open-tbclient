package com.baidu.tieba.im.chat;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.im.chat.officialBar.MultiContentView;
import com.baidu.tieba.im.message.chat.ChatMessage;
import java.util.List;
/* loaded from: classes.dex */
public class MsgMultiImageTextView extends bc {
    private MultiContentView aSe;

    public MsgMultiImageTextView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, com.baidu.tieba.x.msg_multi_pictext_view);
        init();
    }

    private void init() {
        this.ayA = (TextView) findViewById(com.baidu.tieba.w.tex_msgitem_time);
        this.aSe = (MultiContentView) findViewById(com.baidu.tieba.w.msg_content);
    }

    public void a(TbPageContext<?> tbPageContext, ChatMessage chatMessage, View view) {
        if (chatMessage != null) {
            b(chatMessage);
            List<com.baidu.tieba.im.chat.officialBar.p> ax = com.baidu.tieba.im.chat.officialBar.o.ax(chatMessage.getContent(), chatMessage.getUserInfo().getUserId());
            this.aSe.setPosition(this.mPosition);
            this.aSe.setOnItemViewLongClickListener(this.mItemViewLongClickListener);
            this.aSe.setNeedNightMode(false);
            this.aSe.setType(1);
            this.aSe.a(tbPageContext, ax, view);
        }
    }
}
