package com.baidu.tieba.im.chat.officialBar;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
import com.baidu.tieba.im.chat.MsglistActivity;
import com.baidu.tieba.im.message.chat.ChatMessage;
import d.b.i0.d1.f.e;
import d.b.i0.d1.l.c.a;
import java.util.List;
/* loaded from: classes3.dex */
public class MsgMultiImageTextView extends e {
    public MultiContentView t;

    public MsgMultiImageTextView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, R.layout.msg_multi_pictext_view);
        G();
    }

    public final void G() {
        this.f53655h = (TextView) d(R.id.tex_msgitem_time);
        this.t = (MultiContentView) d(R.id.msg_content);
    }

    public void I(TbPageContext<?> tbPageContext, ChatMessage chatMessage, View view) {
        if (chatMessage == null) {
            return;
        }
        z(chatMessage);
        List<a.C1203a> b2 = a.b(chatMessage.getContent(), chatMessage.getUserInfo().getUserId(), chatMessage.getUserInfo(), chatMessage.getMsgId(), chatMessage.getStatTaskId(), chatMessage.getStatisticsServiceId());
        this.t.setPosition(this.f53653f);
        this.t.setOnItemViewLongClickListener(this.f53650c);
        this.t.setNeedNightMode(true);
        this.t.setType(1);
        this.t.setData(tbPageContext, b2, view);
    }
}
