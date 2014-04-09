package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import protobuf.QueryUserInfos.QueryUserInfosRes;
/* loaded from: classes.dex */
public class ResponseQueryUserInfoMessage extends SocketResponsedMessage {
    private QueryUserInfosRes.DataRes a;

    @Override // com.baidu.adp.framework.message.c
    public final /* synthetic */ void a(int i, Object obj) {
        QueryUserInfosRes.QueryUserInfosResIdl parseFrom = QueryUserInfosRes.QueryUserInfosResIdl.parseFrom((byte[]) obj);
        a(parseFrom.getError().getErrorno());
        d(parseFrom.getError().getUsermsg());
        if (e() == 0) {
            this.a = parseFrom.getData();
        }
    }

    public ResponseQueryUserInfoMessage() {
        super(205003);
        this.a = null;
    }

    public final QueryUserInfosRes.DataRes d() {
        return this.a;
    }
}
