package com.baidu.tieba.im.chat.officialBar;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.d;
import com.baidu.tieba.im.chat.MsglistActivity;
import com.baidu.tieba.im.chat.officialBar.g;
import com.baidu.tieba.im.message.chat.ChatMessage;
import java.util.List;
/* loaded from: classes3.dex */
public class MsgMultiImageTextView extends com.baidu.tieba.im.chat.g {
    private MultiContentView exA;

    public MsgMultiImageTextView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, d.h.msg_multi_pictext_view);
        init();
    }

    private void init() {
        this.duU = (TextView) findViewById(d.g.tex_msgitem_time);
        this.exA = (MultiContentView) findViewById(d.g.msg_content);
    }

    public void a(TbPageContext<?> tbPageContext, ChatMessage chatMessage, View view) {
        if (chatMessage != null) {
            g(chatMessage);
            List<g.a> a = g.a(chatMessage.getContent(), chatMessage.getUserInfo().getUserId(), chatMessage.getUserInfo(), chatMessage.getMsgId(), chatMessage.getStatTaskId());
            this.exA.setPosition(this.mPosition);
            this.exA.setOnItemViewLongClickListener(this.evU);
            this.exA.setNeedNightMode(false);
            this.exA.setType(1);
            this.exA.a(tbPageContext, a, view);
        }
    }
}
