package com.baidu.tieba.im.chat.officialBar;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
import com.baidu.tieba.im.chat.MsglistActivity;
import com.baidu.tieba.im.message.chat.ChatMessage;
import d.a.n0.f1.f.e;
import d.a.n0.f1.l.c.a;
import java.util.List;
/* loaded from: classes4.dex */
public class MsgMultiImageTextView extends e {
    public MultiContentView t;

    public MsgMultiImageTextView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, R.layout.msg_multi_pictext_view);
        F();
    }

    public final void F() {
        this.f58033h = (TextView) d(R.id.tex_msgitem_time);
        this.t = (MultiContentView) d(R.id.msg_content);
    }

    public void G(TbPageContext<?> tbPageContext, ChatMessage chatMessage, View view) {
        if (chatMessage == null) {
            return;
        }
        x(chatMessage);
        List<a.C1374a> b2 = a.b(chatMessage.getContent(), chatMessage.getUserInfo().getUserId(), chatMessage.getUserInfo(), chatMessage.getMsgId(), chatMessage.getStatTaskId(), chatMessage.getStatisticsServiceId());
        this.t.setPosition(this.f58031f);
        this.t.setOnItemViewLongClickListener(this.f58028c);
        this.t.setNeedNightMode(true);
        this.t.setType(1);
        this.t.setData(tbPageContext, b2, view);
    }
}
