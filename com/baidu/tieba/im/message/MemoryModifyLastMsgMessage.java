package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tieba.im.message.chat.ChatMessage;
/* loaded from: classes.dex */
public class MemoryModifyLastMsgMessage extends CustomResponsedMessage<a> {
    public static final int TYPE_CLEAR_ALL = 1;
    public static final int TYPE_DELETE = 2;
    public static final int TYPE_SEND_MSG = 3;

    public MemoryModifyLastMsgMessage(a aVar) {
        super(CmdConfigCustom.MEMORY_MODIFY_LAST_MESSAGE, aVar);
    }

    /* loaded from: classes.dex */
    public static class a {
        public int customGroupType;
        public String id;
        public ChatMessage kJu;
        public int type;

        public a() {
        }

        public a(String str, int i, ChatMessage chatMessage, int i2) {
            this.id = str;
            this.customGroupType = i;
            this.kJu = chatMessage;
            this.type = i2;
        }
    }
}
