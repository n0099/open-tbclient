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
public class cb extends com.baidu.adp.base.d<ChatMessage> {
    private TextView aOP;
    private Context mContext;
    private LinearLayout mLayout;
    private TextView mTextTitle;

    public cb(Context context) {
        super(context, com.baidu.tieba.w.msg_msgtopic_view);
        this.mTextTitle = null;
        this.aOP = null;
        this.mLayout = null;
        this.mContext = null;
        this.mContext = context;
        nu();
    }

    private void nu() {
        this.aOP = (TextView) findViewById(com.baidu.tieba.v.tex_content);
        this.mTextTitle = (TextView) findViewById(com.baidu.tieba.v.tex_title);
        this.aOP.setMovementMethod(LinkMovementMethod.getInstance());
        this.mTextTitle.setMovementMethod(LinkMovementMethod.getInstance());
        this.mLayout = (LinearLayout) findViewById(com.baidu.tieba.v.topic_title_layout);
    }

    public void setData(ChatMessage chatMessage) {
        if (chatMessage != null && (chatMessage instanceof TopicSystemGroupChatMessage)) {
            TopicSystemGroupChatMessage topicSystemGroupChatMessage = (TopicSystemGroupChatMessage) chatMessage;
            if (!TextUtils.isEmpty(topicSystemGroupChatMessage.mSystemMsg)) {
                this.mTextTitle.setText(topicSystemGroupChatMessage.mSystemMsg);
            } else {
                this.mTextTitle.setText("");
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mLayout.getLayoutParams();
            if (!TextUtils.isEmpty(topicSystemGroupChatMessage.mSystemContent)) {
                this.aOP.setVisibility(0);
                this.aOP.setText(topicSystemGroupChatMessage.mSystemContent);
                layoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.t.ds24);
                this.mLayout.setLayoutParams(layoutParams);
                return;
            }
            this.aOP.setText("");
            this.aOP.setVisibility(8);
            layoutParams.topMargin = 0;
            this.mLayout.setLayoutParams(layoutParams);
        }
    }
}
