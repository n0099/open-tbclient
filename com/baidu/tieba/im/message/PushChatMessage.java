package com.baidu.tieba.im.message;

import com.baidu.tieba.data.UserData;
/* loaded from: classes.dex */
public class PushChatMessage extends Message {
    private UserData userData;

    public PushChatMessage() {
        setCmd(-101);
    }
}
