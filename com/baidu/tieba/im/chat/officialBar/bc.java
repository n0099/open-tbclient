package com.baidu.tieba.im.chat.officialBar;

import com.baidu.tbadk.core.util.LocalViewSize;
import com.google.protobuf.MessageLite;
import protobuf.QueryHistoryMsg.QueryHistoryMsgReq;
/* loaded from: classes.dex */
public final class bc extends com.baidu.tbadk.message.websockt.d {
    private int a;
    private int b;
    private int c;
    private int d;
    private int e;
    private int f;
    private int g;

    public bc(int i, int i2, int i3) {
        super(208002);
        this.a = 0;
        this.b = 0;
        this.c = 0;
        this.d = 0;
        this.e = 0;
        this.f = 0;
        this.g = 0;
        this.a = i;
        this.b = i2;
        this.c = i3;
        LocalViewSize.ImageSize d = LocalViewSize.a().d();
        this.d = d.width;
        this.e = d.height;
        LocalViewSize.ImageSize c = LocalViewSize.a().c();
        this.f = c.width;
        this.g = c.height;
    }

    @Override // com.baidu.tbadk.message.websockt.d
    protected final MessageLite h() {
        QueryHistoryMsgReq.DataReq build = QueryHistoryMsgReq.DataReq.newBuilder().a(this.a).b(this.b).c(this.c).d(this.d).e(this.e).f(this.f).g(this.g).build();
        com.baidu.adp.lib.util.f.e("history:fid" + this.a + " id:" + this.c);
        return QueryHistoryMsgReq.QueryHistoryMsgReqIdl.newBuilder().a(build).build();
    }

    public final int i() {
        return this.a;
    }

    public final int j() {
        return this.c;
    }
}
