package com.baidu.tieba.homepage;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.squareup.wire.Wire;
import tbclient.UserPk.UserPkResIdl;
/* loaded from: classes3.dex */
public class BlessSocketResponseMessage extends SocketResponsedMessage {
    public long pkID;
    public long userPkId;

    public BlessSocketResponseMessage(int i) {
        super(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        UserPkResIdl userPkResIdl = (UserPkResIdl) new Wire(new Class[0]).parseFrom(bArr, UserPkResIdl.class);
        if (userPkResIdl != null && userPkResIdl.data != null) {
            this.userPkId = userPkResIdl.data.user_pk_id.longValue();
            this.pkID = userPkResIdl.data.pk_id.longValue();
        }
    }
}
