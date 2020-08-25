package com.baidu.tieba.im.chat.officialBar;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
import com.baidu.tieba.im.chat.MsglistActivity;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.message.chat.a;
import java.util.List;
/* loaded from: classes20.dex */
public class MsgMultiImageTextView extends com.baidu.tieba.im.chat.g {
    private MultiContentView jhf;

    public MsgMultiImageTextView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, R.layout.msg_multi_pictext_view);
        init();
    }

    private void init() {
        this.fGU = (TextView) findViewById(R.id.tex_msgitem_time);
        this.jhf = (MultiContentView) findViewById(R.id.msg_content);
    }

    public void a(TbPageContext<?> tbPageContext, ChatMessage chatMessage, View view) {
        if (chatMessage != null) {
            b(chatMessage);
            List<a.C0719a> a = com.baidu.tieba.im.message.chat.a.a(chatMessage.getContent(), chatMessage.getUserInfo().getUserId(), chatMessage.getUserInfo(), chatMessage.getMsgId(), chatMessage.getStatTaskId());
            this.jhf.setPosition(this.mPosition);
            this.jhf.setOnItemViewLongClickListener(this.jfB);
            this.jhf.setNeedNightMode(true);
            this.jhf.setType(1);
            this.jhf.setData(tbPageContext, a, view);
        }
    }
}
