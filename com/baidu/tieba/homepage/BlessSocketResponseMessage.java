package com.baidu.tieba.homepage;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.squareup.wire.Wire;
import tbclient.UserPk.DataRes;
import tbclient.UserPk.UserPkResIdl;
/* loaded from: classes3.dex */
public class BlessSocketResponseMessage extends SocketResponsedMessage {
    public long pkID;
    public long userPkId;

    public BlessSocketResponseMessage(int i) {
        super(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        DataRes dataRes;
        UserPkResIdl userPkResIdl = (UserPkResIdl) new Wire(new Class[0]).parseFrom(bArr, UserPkResIdl.class);
        if (userPkResIdl == null || (dataRes = userPkResIdl.data) == null) {
            return;
        }
        this.userPkId = dataRes.user_pk_id.longValue();
        this.pkID = userPkResIdl.data.pk_id.longValue();
    }
}
