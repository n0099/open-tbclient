package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import protobuf.GetPeerInfo.GetPeerInfoRes;
/* loaded from: classes.dex */
public class ResponsePeerInfo extends SocketResponsedMessage {
    private int a;

    @Override // com.baidu.adp.framework.message.c
    public final /* synthetic */ void a(int i, Object obj) {
        GetPeerInfoRes.GetPeerInfoResIdl parseFrom = GetPeerInfoRes.GetPeerInfoResIdl.parseFrom((byte[]) obj);
        a(parseFrom.getError().getErrorno());
        e(parseFrom.getError().getUsermsg());
        if (e() == 0) {
            this.a = parseFrom.getData().getIsAllowed();
        }
    }

    public final boolean d() {
        return this.a != 0;
    }

    public ResponsePeerInfo() {
        super(205004);
        this.a = 1;
    }
}
