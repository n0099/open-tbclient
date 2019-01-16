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
    private MultiContentView eMY;

    public MsgMultiImageTextView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, e.h.msg_multi_pictext_view);
        init();
    }

    private void init() {
        this.dxJ = (TextView) findViewById(e.g.tex_msgitem_time);
        this.eMY = (MultiContentView) findViewById(e.g.msg_content);
    }

    public void a(TbPageContext<?> tbPageContext, ChatMessage chatMessage, View view) {
        if (chatMessage != null) {
            g(chatMessage);
            List<c.a> a = c.a(chatMessage.getContent(), chatMessage.getUserInfo().getUserId(), chatMessage.getUserInfo(), chatMessage.getMsgId(), chatMessage.getStatTaskId());
            this.eMY.setPosition(this.mPosition);
            this.eMY.setOnItemViewLongClickListener(this.eLt);
            this.eMY.setNeedNightMode(false);
            this.eMY.setType(1);
            this.eMY.setData(tbPageContext, a, view);
        }
    }
}
