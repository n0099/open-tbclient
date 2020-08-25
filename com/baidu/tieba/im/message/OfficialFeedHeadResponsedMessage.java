package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.im.message.chat.ChatMessage;
import java.util.List;
/* loaded from: classes2.dex */
public class OfficialFeedHeadResponsedMessage extends CustomResponsedMessage<a> {

    /* loaded from: classes2.dex */
    public static class a {
        public List<ChatMessage> jwb;
        public List<com.baidu.tieba.im.db.pojo.a> msgList;
    }

    public OfficialFeedHeadResponsedMessage(int i) {
        super(i);
    }
}
