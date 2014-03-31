package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import java.util.List;
import protobuf.Im;
import protobuf.QueryChatroomInfo.QueryChatroomInfoRes;
/* loaded from: classes.dex */
public class ResponseChatRoomInfoMessage extends SocketResponsedMessage {
    private int a;
    private int b;
    private List<Im.UserInfo> c;
    private int d;
    private int e;
    private String f;
    private String g;

    @Override // com.baidu.adp.framework.message.c
    public final /* synthetic */ void a(int i, Object obj) {
        QueryChatroomInfoRes.QueryChatroomInfoResIdl parseFrom = QueryChatroomInfoRes.QueryChatroomInfoResIdl.parseFrom((byte[]) obj);
        a(parseFrom.getError().getErrorno());
        e(parseFrom.getError().getUsermsg());
        if (e() == 0) {
            QueryChatroomInfoRes.DataRes data = parseFrom.getData();
            this.a = data.getUserNum();
            this.b = data.getMaxUserNum();
            this.c = data.getUserListList();
            this.d = data.getStatus();
            this.e = data.getLeftTime();
            this.f = data.getTitle();
            this.g = data.getContent();
            com.baidu.adp.lib.util.f.e(toString());
        }
    }

    public ResponseChatRoomInfoMessage() {
        super(106001);
    }

    public String toString() {
        return "ResponseChatRoomInfoMessage{userNum=" + this.a + ", maxUserNum=" + this.b + ", userList=" + this.c + ", status=" + this.d + ", leftTime=" + this.e + ", title='" + this.f + "', content='" + this.g + "'}";
    }

    public final List<Im.UserInfo> d() {
        return this.c;
    }
}
