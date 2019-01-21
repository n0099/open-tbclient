package com.baidu.tieba.im.chat.officialBar;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.e;
import com.baidu.tieba.im.chat.MsglistActivity;
import com.baidu.tieba.im.chat.g;
import com.baidu.tieba.im.chat.officialBar.c;
import com.baidu.tieba.im.message.chat.ChatMessage;
import java.util.List;
/* loaded from: classes3.dex */
public class MsgMultiImageTextView extends g {
    private MultiContentView eMZ;

    public MsgMultiImageTextView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, e.h.msg_multi_pictext_view);
        init();
    }

    private void init() {
        this.dxK = (TextView) findViewById(e.g.tex_msgitem_time);
        this.eMZ = (MultiContentView) findViewById(e.g.msg_content);
    }

    public void a(TbPageContext<?> tbPageContext, ChatMessage chatMessage, View view) {
        if (chatMessage != null) {
            g(chatMessage);
            List<c.a> a = c.a(chatMessage.getContent(), chatMessage.getUserInfo().getUserId(), chatMessage.getUserInfo(), chatMessage.getMsgId(), chatMessage.getStatTaskId());
            this.eMZ.setPosition(this.mPosition);
            this.eMZ.setOnItemViewLongClickListener(this.eLu);
            this.eMZ.setNeedNightMode(false);
            this.eMZ.setType(1);
            this.eMZ.setData(tbPageContext, a, view);
        }
    }
}
