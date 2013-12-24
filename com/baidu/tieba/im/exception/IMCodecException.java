package com.baidu.tieba.im.exception;

import com.baidu.tieba.im.message.n;
/* loaded from: classes.dex */
public class IMCodecException extends IMException {
    private static final long serialVersionUID = 4336990170393344032L;
    private n data;

    public IMCodecException(int i, n nVar) {
        super(i);
        this.data = nVar;
    }

    public IMCodecException(int i, String str, n nVar) {
        super(i, str);
        this.data = nVar;
    }

    public IMCodecException(int i, n nVar, Throwable th) {
        super(i, th);
        this.data = nVar;
    }

    public IMCodecException(int i, String str, n nVar, Throwable th) {
        super(i, str, th);
        this.data = nVar;
    }

    public n getData() {
        return this.data;
    }

    public void setData(n nVar) {
        this.data = nVar;
    }
}
