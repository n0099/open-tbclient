package com.baidu.tieba.im.chat.officialBar;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.d;
import com.baidu.tieba.im.chat.MsglistActivity;
import com.baidu.tieba.im.chat.g;
import com.baidu.tieba.im.chat.officialBar.c;
import com.baidu.tieba.im.message.chat.ChatMessage;
import java.util.List;
/* loaded from: classes3.dex */
public class MsgMultiImageTextView extends g {
    private MultiContentView eew;

    public MsgMultiImageTextView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, d.i.msg_multi_pictext_view);
        init();
    }

    private void init() {
        this.cXR = (TextView) findViewById(d.g.tex_msgitem_time);
        this.eew = (MultiContentView) findViewById(d.g.msg_content);
    }

    public void a(TbPageContext<?> tbPageContext, ChatMessage chatMessage, View view) {
        if (chatMessage != null) {
            g(chatMessage);
            List<c.a> a = c.a(chatMessage.getContent(), chatMessage.getUserInfo().getUserId(), chatMessage.getUserInfo(), chatMessage.getMsgId(), chatMessage.getStatTaskId());
            this.eew.setPosition(this.mPosition);
            this.eew.setOnItemViewLongClickListener(this.ecR);
            this.eew.setNeedNightMode(false);
            this.eew.setType(1);
            this.eew.setData(tbPageContext, a, view);
        }
    }
}
