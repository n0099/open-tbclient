package com.baidu.tieba.im.chat.officialBar;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
import com.baidu.tieba.im.chat.MsglistActivity;
import com.baidu.tieba.im.chat.g;
import com.baidu.tieba.im.chat.officialBar.c;
import com.baidu.tieba.im.message.chat.ChatMessage;
import java.util.List;
/* loaded from: classes3.dex */
public class MsgMultiImageTextView extends g {
    private MultiContentView gAZ;

    public MsgMultiImageTextView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, R.layout.msg_multi_pictext_view);
        init();
    }

    private void init() {
        this.dyX = (TextView) findViewById(R.id.tex_msgitem_time);
        this.gAZ = (MultiContentView) findViewById(R.id.msg_content);
    }

    public void a(TbPageContext<?> tbPageContext, ChatMessage chatMessage, View view) {
        if (chatMessage != null) {
            b(chatMessage);
            List<c.a> a = c.a(chatMessage.getContent(), chatMessage.getUserInfo().getUserId(), chatMessage.getUserInfo(), chatMessage.getMsgId(), chatMessage.getStatTaskId());
            this.gAZ.setPosition(this.mPosition);
            this.gAZ.setOnItemViewLongClickListener(this.gzv);
            this.gAZ.setNeedNightMode(false);
            this.gAZ.setType(1);
            this.gAZ.setData(tbPageContext, a, view);
        }
    }
}
