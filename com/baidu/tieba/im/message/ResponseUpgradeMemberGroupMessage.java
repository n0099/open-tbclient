package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import protobuf.UpgradeMemberGroup.UpgradeMemberGroupRes;
/* loaded from: classes.dex */
public class ResponseUpgradeMemberGroupMessage extends SocketResponsedMessage {
    @Override // com.baidu.adp.framework.message.c
    public final /* synthetic */ void a(int i, Object obj) {
        UpgradeMemberGroupRes.UpgradeMemberGroupResIdl parseFrom = UpgradeMemberGroupRes.UpgradeMemberGroupResIdl.parseFrom((byte[]) obj);
        a(parseFrom.getError().getErrorno());
        e(parseFrom.getError().getUsermsg());
    }

    public ResponseUpgradeMemberGroupMessage() {
        super(103105);
    }
}
