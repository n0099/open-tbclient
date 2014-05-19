package com.baidu.tieba.im.chat;

import android.content.Context;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tieba.im.message.TopicSystemGroupChatMessage;
import com.baidu.tieba.im.message.chat.ChatMessage;
/* loaded from: classes.dex */
public class cc extends com.baidu.adp.base.c<ChatMessage> {
    private TextView b;
    private TextView c;
    private LinearLayout d;
    private Context e;

    public cc(Context context) {
        super(context, com.baidu.tieba.s.msg_msgtopic_view);
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.e = context;
        b();
    }

    private void b() {
        this.c = (TextView) a(com.baidu.tieba.r.tex_content);
        this.b = (TextView) a(com.baidu.tieba.r.tex_title);
        this.c.setMovementMethod(LinkMovementMethod.getInstance());
        this.b.setMovementMethod(LinkMovementMethod.getInstance());
        this.d = (LinearLayout) a(com.baidu.tieba.r.topic_title_layout);
    }

    public void a(ChatMessage chatMessage) {
        if (chatMessage != null && (chatMessage instanceof TopicSystemGroupChatMessage)) {
            TopicSystemGroupChatMessage topicSystemGroupChatMessage = (TopicSystemGroupChatMessage) chatMessage;
            if (!TextUtils.isEmpty(topicSystemGroupChatMessage.mSystemMsg)) {
                this.b.setText(topicSystemGroupChatMessage.mSystemMsg);
            } else {
                this.b.setText("");
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.d.getLayoutParams();
            if (!TextUtils.isEmpty(topicSystemGroupChatMessage.mSystemContent)) {
                this.c.setVisibility(0);
                this.c.setText(topicSystemGroupChatMessage.mSystemContent);
                layoutParams.topMargin = this.e.getResources().getDimensionPixelSize(com.baidu.tieba.p.ds24);
                this.d.setLayoutParams(layoutParams);
                return;
            }
            this.c.setText("");
            this.c.setVisibility(8);
            layoutParams.topMargin = 0;
            this.d.setLayoutParams(layoutParams);
        }
    }
}
