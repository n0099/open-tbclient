package com.baidu.tieba.im.chat;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.im.chat.officialBar.MultiContentView;
import com.baidu.tieba.im.message.chat.ChatMessage;
import java.util.List;
/* loaded from: classes.dex */
public class MsgMultiImageTextView extends az {
    private MultiContentView aQV;

    public MsgMultiImageTextView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, com.baidu.tieba.x.msg_multi_pictext_view);
        init();
    }

    private void init() {
        this.axA = (TextView) findViewById(com.baidu.tieba.w.tex_msgitem_time);
        this.aQV = (MultiContentView) findViewById(com.baidu.tieba.w.msg_content);
    }

    public void a(TbPageContext<?> tbPageContext, ChatMessage chatMessage, View view) {
        if (chatMessage != null) {
            b(chatMessage);
            List<com.baidu.tieba.im.chat.officialBar.p> au = com.baidu.tieba.im.chat.officialBar.o.au(chatMessage.getContent(), chatMessage.getUserInfo().getUserId());
            this.aQV.setPosition(this.mPosition);
            this.aQV.setOnItemViewLongClickListener(this.mItemViewLongClickListener);
            this.aQV.setNeedNightMode(false);
            this.aQV.setType(1);
            this.aQV.a(tbPageContext, au, view);
        }
    }
}
