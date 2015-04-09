package com.baidu.tieba.im.chat.officialBar;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.im.chat.MsglistActivity;
import com.baidu.tieba.im.chat.bk;
import com.baidu.tieba.im.message.chat.ChatMessage;
import java.util.List;
/* loaded from: classes.dex */
public class MsgMultiImageTextView extends bk {
    private MultiContentView aYF;

    public MsgMultiImageTextView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, com.baidu.tieba.w.msg_multi_pictext_view);
        init();
    }

    private void init() {
        this.aGS = (TextView) findViewById(com.baidu.tieba.v.tex_msgitem_time);
        this.aYF = (MultiContentView) findViewById(com.baidu.tieba.v.msg_content);
    }

    public void a(TbPageContext<?> tbPageContext, ChatMessage chatMessage, View view) {
        if (chatMessage != null) {
            b(chatMessage);
            List<q> ax = p.ax(chatMessage.getContent(), chatMessage.getUserInfo().getUserId());
            this.aYF.setPosition(this.mPosition);
            this.aYF.setOnItemViewLongClickListener(this.aXt);
            this.aYF.setNeedNightMode(false);
            this.aYF.setType(1);
            this.aYF.a(tbPageContext, ax, view);
        }
    }
}
