package com.baidu.tieba.im.message;

import com.baidu.tieba.im.message.chat.ChatMessage;
/* loaded from: classes.dex */
public class g {
    public ChatMessage bku;
    public int customGroupType;
    public String id;
    public int type;

    public g() {
    }

    public g(String str, int i, ChatMessage chatMessage, int i2) {
        this.id = str;
        this.customGroupType = i;
        this.bku = chatMessage;
        this.type = i2;
    }
}
