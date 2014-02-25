package com.baidu.tieba.im.coder;

import com.baidu.tieba.im.h;
/* loaded from: classes.dex */
public class CoderException extends Exception {
    private static final long serialVersionUID = -4477017113691535623L;
    private int mErrorCode;

    public CoderException(int i) {
        super(h.a(i));
        this.mErrorCode = i;
    }

    public int getErrorCode() {
        return this.mErrorCode;
    }
}
