package com.baidu.tieba.homepage.daily.message;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.squareup.wire.Wire;
import tbclient.DailyPage.DailyPageResIdl;
import tbclient.DailyPage.DataRes;
/* loaded from: classes6.dex */
public class DailyPageSocketResMessage extends SocketResponsedMessage {
    private DataRes mData;

    public DailyPageSocketResMessage() {
        super(309617);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        DailyPageResIdl dailyPageResIdl = (DailyPageResIdl) new Wire(new Class[0]).parseFrom(bArr, DailyPageResIdl.class);
        if (dailyPageResIdl != null) {
            if (dailyPageResIdl.error != null) {
                setError(dailyPageResIdl.error.errorno.intValue());
                setErrorString(dailyPageResIdl.error.errmsg);
            }
            this.mData = dailyPageResIdl.data;
        }
    }

    public DataRes getData() {
        return this.mData;
    }
}
