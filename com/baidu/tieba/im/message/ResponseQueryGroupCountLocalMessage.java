package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import protobuf.QueryGroupCount.QueryGroupCountRes;
/* loaded from: classes.dex */
public class ResponseQueryGroupCountLocalMessage extends CustomResponsedMessage<Object> {
    private int a;
    private int b;
    private String c;
    private String d;

    public ResponseQueryGroupCountLocalMessage() {
        super(2001114);
    }

    public ResponseQueryGroupCountLocalMessage(int i) {
        super(i);
    }

    public final String b() {
        return this.c;
    }

    public final String c() {
        return this.d;
    }

    public final int d() {
        return this.a;
    }

    public final int i() {
        return this.b;
    }

    public final void a(byte[] bArr) {
        QueryGroupCountRes.QueryGroupCountResIdl parseFrom = QueryGroupCountRes.QueryGroupCountResIdl.parseFrom(bArr);
        a(parseFrom.getError().getErrorno());
        d(parseFrom.getError().getUsermsg());
        if (e() == 0) {
            this.b = parseFrom.getData().getLocalGroupCount();
            this.a = parseFrom.getData().getUserGroupCount();
            this.d = parseFrom.getData().getBanner().getPicUrl();
            this.c = parseFrom.getData().getBanner().getLink();
        }
    }
}
