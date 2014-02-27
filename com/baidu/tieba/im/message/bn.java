package com.baidu.tieba.im.message;

import java.util.LinkedList;
import java.util.List;
import protobuf.Im;
import protobuf.QueryChatroomInfo.QueryChatroomInfoRes;
/* loaded from: classes.dex */
public class bn extends da implements com.baidu.tieba.im.coder.f {
    private int a;
    private int b;
    private List<Im.UserInfo> c;
    private int d;
    private int e;
    private String f;
    private String g;

    public bn() {
        e(106001);
    }

    public String toString() {
        return "ResponseChatRoomInfoMessage{userNum=" + this.a + ", maxUserNum=" + this.b + ", userList=" + this.c + ", status=" + this.d + ", leftTime=" + this.e + ", title='" + this.f + "', content='" + this.g + "'}";
    }

    @Override // com.baidu.tieba.im.coder.f
    public final void a(LinkedList<s> linkedList, byte[] bArr, int i) {
        QueryChatroomInfoRes.QueryChatroomInfoResIdl parseFrom = QueryChatroomInfoRes.QueryChatroomInfoResIdl.parseFrom(bArr);
        g(parseFrom.getError().getErrorno());
        c(parseFrom.getError().getUsermsg());
        linkedList.add(this);
        if (!l()) {
            QueryChatroomInfoRes.DataRes data = parseFrom.getData();
            this.a = data.getUserNum();
            this.b = data.getMaxUserNum();
            this.c = data.getUserListList();
            this.d = data.getStatus();
            this.e = data.getLeftTime();
            this.f = data.getTitle();
            this.g = data.getContent();
            com.baidu.adp.lib.util.e.e(toString());
        }
    }

    public final List<Im.UserInfo> a() {
        return this.c;
    }
}
