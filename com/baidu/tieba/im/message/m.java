package com.baidu.tieba.im.message;

import com.baidu.sapi2.shell.SapiErrorCode;
/* loaded from: classes.dex */
public class m extends q {
    private int a = 0;
    private String b;

    public m() {
        e(SapiErrorCode.INVALID_ARG);
    }

    public String a() {
        return this.b;
    }

    public void a(String str) {
        this.b = str;
    }

    public int b() {
        return this.a;
    }

    public void a(int i) {
        this.a = i;
    }
}
