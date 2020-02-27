package com.baidu.tieba.homepage;

import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.squareup.wire.Wire;
import tbclient.UserPk.UserPkResIdl;
/* loaded from: classes8.dex */
public class BlessHttpResponseMessage extends HttpResponsedMessage {
    public long pkID;
    public long userPkId;

    public BlessHttpResponseMessage(int i) {
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
