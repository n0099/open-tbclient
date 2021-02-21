package com.baidu.tieba.im.chat.officialBar;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
import com.baidu.tieba.im.chat.MsglistActivity;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.message.chat.a;
import java.util.List;
/* loaded from: classes8.dex */
public class MsgMultiImageTextView extends com.baidu.tieba.im.chat.e {
    private MultiContentView kBX;

    public MsgMultiImageTextView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, R.layout.msg_multi_pictext_view);
        init();
    }

    private void init() {
        this.gDC = (TextView) findViewById(R.id.tex_msgitem_time);
        this.kBX = (MultiContentView) findViewById(R.id.msg_content);
    }

    public void a(TbPageContext<?> tbPageContext, ChatMessage chatMessage, View view) {
        if (chatMessage != null) {
            b(chatMessage);
            List<a.C0761a> a2 = com.baidu.tieba.im.message.chat.a.a(chatMessage.getContent(), chatMessage.getUserInfo().getUserId(), chatMessage.getUserInfo(), chatMessage.getMsgId(), chatMessage.getStatTaskId(), chatMessage.getStatisticsServiceId());
            this.kBX.setPosition(this.mPosition);
            this.kBX.setOnItemViewLongClickListener(this.kAu);
            this.kBX.setNeedNightMode(true);
            this.kBX.setType(1);
            this.kBX.setData(tbPageContext, a2, view);
        }
    }
}
