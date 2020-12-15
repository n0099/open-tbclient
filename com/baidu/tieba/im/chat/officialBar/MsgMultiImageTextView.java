package com.baidu.tieba.im.chat.officialBar;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
import com.baidu.tieba.im.chat.MsglistActivity;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.message.chat.a;
import java.util.List;
/* loaded from: classes26.dex */
public class MsgMultiImageTextView extends com.baidu.tieba.im.chat.g {
    private MultiContentView klB;

    public MsgMultiImageTextView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, R.layout.msg_multi_pictext_view);
        init();
    }

    private void init() {
        this.gul = (TextView) findViewById(R.id.tex_msgitem_time);
        this.klB = (MultiContentView) findViewById(R.id.msg_content);
    }

    public void a(TbPageContext<?> tbPageContext, ChatMessage chatMessage, View view) {
        if (chatMessage != null) {
            b(chatMessage);
            List<a.C0782a> a2 = com.baidu.tieba.im.message.chat.a.a(chatMessage.getContent(), chatMessage.getUserInfo().getUserId(), chatMessage.getUserInfo(), chatMessage.getMsgId(), chatMessage.getStatTaskId(), chatMessage.getStatisticsServiceId());
            this.klB.setPosition(this.mPosition);
            this.klB.setOnItemViewLongClickListener(this.kjY);
            this.klB.setNeedNightMode(true);
            this.klB.setType(1);
            this.klB.setData(tbPageContext, a2, view);
        }
    }
}
