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
    private MultiContentView gda;

    public MsgMultiImageTextView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, d.h.msg_multi_pictext_view);
        init();
    }

    private void init() {
        this.eLa = (TextView) findViewById(d.g.tex_msgitem_time);
        this.gda = (MultiContentView) findViewById(d.g.msg_content);
    }

    public void a(TbPageContext<?> tbPageContext, ChatMessage chatMessage, View view) {
        if (chatMessage != null) {
            g(chatMessage);
            List<c.a> a = c.a(chatMessage.getContent(), chatMessage.getUserInfo().getUserId(), chatMessage.getUserInfo(), chatMessage.getMsgId(), chatMessage.getStatTaskId());
            this.gda.setPosition(this.mPosition);
            this.gda.setOnItemViewLongClickListener(this.gbv);
            this.gda.setNeedNightMode(false);
            this.gda.setType(1);
            this.gda.setData(tbPageContext, a, view);
        }
    }
}
