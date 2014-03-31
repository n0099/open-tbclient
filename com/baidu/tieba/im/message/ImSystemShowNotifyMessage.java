package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class ImSystemShowNotifyMessage extends CustomResponsedMessage<String> {
    private String a;

    public ImSystemShowNotifyMessage(String str) {
        super(2001128);
        this.a = str;
    }

    public final String b() {
        return this.a;
    }
}
