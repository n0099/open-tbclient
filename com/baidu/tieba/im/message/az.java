package com.baidu.tieba.im.message;

import com.google.protobuf.MessageLite;
import protobuf.SearchGroup.SearchGroupReq;
/* loaded from: classes.dex */
public final class az extends com.baidu.tbadk.message.websockt.d {
    private int a;

    public az() {
        super(103007);
    }

    public final void d(int i) {
        this.a = i;
    }

    @Override // com.baidu.tbadk.message.websockt.d
    public final MessageLite h() {
        return SearchGroupReq.SearchGroupReqIdl.newBuilder().a(SearchGroupReq.DataReq.newBuilder().a(this.a).build()).build();
    }
}
