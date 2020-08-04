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
    private MultiContentView iSi;

    public MsgMultiImageTextView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, R.layout.msg_multi_pictext_view);
        init();
    }

    private void init() {
        this.fvC = (TextView) findViewById(R.id.tex_msgitem_time);
        this.iSi = (MultiContentView) findViewById(R.id.msg_content);
    }

    public void a(TbPageContext<?> tbPageContext, ChatMessage chatMessage, View view) {
        if (chatMessage != null) {
            b(chatMessage);
            List<a.C0667a> a = com.baidu.tieba.im.message.chat.a.a(chatMessage.getContent(), chatMessage.getUserInfo().getUserId(), chatMessage.getUserInfo(), chatMessage.getMsgId(), chatMessage.getStatTaskId());
            this.iSi.setPosition(this.mPosition);
            this.iSi.setOnItemViewLongClickListener(this.iQE);
            this.iSi.setNeedNightMode(true);
            this.iSi.setType(1);
            this.iSi.setData(tbPageContext, a, view);
        }
    }
}
