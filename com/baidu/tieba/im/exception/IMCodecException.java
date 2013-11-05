package com.baidu.tieba.im.exception;

import com.baidu.tieba.im.message.Message;
/* loaded from: classes.dex */
public class IMCodecException extends IMException {
    private static final long serialVersionUID = 4336990170393344032L;
    private Message data;

    public IMCodecException(int i, Message message) {
        super(i);
        this.data = message;
    }

    public IMCodecException(int i, String str, Message message) {
        super(i, str);
        this.data = message;
    }

    public IMCodecException(int i, Message message, Throwable th) {
        super(i, th);
        this.data = message;
    }

    public IMCodecException(int i, String str, Message message, Throwable th) {
        super(i, str, th);
        this.data = message;
    }

    public Message getData() {
        return this.data;
    }

    public void setData(Message message) {
        this.data = message;
    }
}
