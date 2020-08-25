package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.im.message.chat.ChatMessage;
import java.util.List;
/* loaded from: classes2.dex */
public class LoadHistoryResponsedMessage extends CustomResponsedMessage<a> {

    /* loaded from: classes2.dex */
    public static class a {
        public String id;
        public boolean isFirst;
        public List<ChatMessage> msgList;
    }

    public LoadHistoryResponsedMessage(int i) {
        super(i);
    }
}
