package com.baidu.tieba.im.chat.officialBar;

import com.google.protobuf.MessageLite;
import protobuf.QueryForumDetail.QueryForumDetailReq;
/* loaded from: classes.dex */
public final class be extends com.baidu.tbadk.message.websockt.d {
    private int a;
    private String b;

    public be(int i, String str) {
        super(208001);
        this.a = 0;
        this.b = null;
        this.a = i;
        this.b = str;
    }

    @Override // com.baidu.tbadk.message.websockt.d
    protected final MessageLite h() {
        return QueryForumDetailReq.QueryForumDetailReqIdl.newBuilder().a(QueryForumDetailReq.DataReq.newBuilder().a(this.a).a(this.b).build()).build();
    }
}
