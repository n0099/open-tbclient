package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.im.data.GroupActivityData;
/* loaded from: classes.dex */
public class ResponseGetGroupActivityLocalMessage extends CustomResponsedMessage<byte[]> {
    private GroupActivityData a;

    public ResponseGetGroupActivityLocalMessage() {
        super(2001127);
    }

    public final GroupActivityData b() {
        return this.a;
    }
}
