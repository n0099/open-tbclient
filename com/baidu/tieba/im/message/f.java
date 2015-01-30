package com.baidu.tieba.im.message;

import com.baidu.tieba.im.message.chat.ChatMessage;
/* loaded from: classes.dex */
public class f {
    public ChatMessage bjk;
    public int customGroupType;
    public String id;
    public int type;

    public f() {
    }

    public f(String str, int i, ChatMessage chatMessage, int i2) {
        this.id = str;
        this.customGroupType = i;
        this.bjk = chatMessage;
        this.type = i2;
    }
}
