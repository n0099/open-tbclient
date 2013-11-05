package com.baidu.tieba.im.exception;

import com.baidu.tieba.im.k;
/* loaded from: classes.dex */
public class IMException extends Exception {
    private static final long serialVersionUID = -5107682798616053903L;
    private int errorCode;

    public IMException(int i) {
        this(i, k.a(i));
    }

    public IMException(int i, String str) {
        super(str);
        this.errorCode = i;
    }

    public IMException(int i, Throwable th) {
        this(i, k.a(i), th);
    }

    public IMException(int i, String str, Throwable th) {
        super(str, th);
        this.errorCode = i;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public void setErrorCode(int i) {
        this.errorCode = i;
    }
}
