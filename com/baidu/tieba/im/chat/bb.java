package com.baidu.tieba.im.chat;

import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.im.message.TopicSystemGroupChatMessage;
import com.baidu.tieba.im.message.chat.ChatMessage;
/* loaded from: classes.dex */
public class bb extends com.baidu.adp.base.e<MsglistActivity<?>> {
    private TextView aRW;
    private TbPageContext<MsglistActivity<?>> mContext;
    private LinearLayout mLayout;
    private TextView mTextTitle;

    public bb(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, com.baidu.tieba.x.msg_msgtopic_view);
        this.mTextTitle = null;
        this.aRW = null;
        this.mLayout = null;
        this.mContext = null;
        this.mContext = tbPageContext;
        initView();
    }

    private void initView() {
        this.aRW = (TextView) findViewById(com.baidu.tieba.w.tex_content);
        this.mTextTitle = (TextView) findViewById(com.baidu.tieba.w.tex_title);
        this.aRW.setMovementMethod(LinkMovementMethod.getInstance());
        this.mTextTitle.setMovementMethod(LinkMovementMethod.getInstance());
        this.mLayout = (LinearLayout) findViewById(com.baidu.tieba.w.topic_title_layout);
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
                this.aRW.setVisibility(0);
                this.aRW.setText(topicSystemGroupChatMessage.mSystemContent);
                layoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.u.ds24);
                this.mLayout.setLayoutParams(layoutParams);
                return;
            }
            this.aRW.setText("");
            this.aRW.setVisibility(8);
            layoutParams.topMargin = 0;
            this.mLayout.setLayoutParams(layoutParams);
        }
    }
}
