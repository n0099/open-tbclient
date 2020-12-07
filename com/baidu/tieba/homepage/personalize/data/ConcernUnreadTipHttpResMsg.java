package com.baidu.tieba.homepage.personalize.data;

import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.squareup.wire.Wire;
import tbclient.UnreadTip.UnreadTipResIdl;
/* loaded from: classes22.dex */
public class ConcernUnreadTipHttpResMsg extends HttpResponsedMessage {
    public e mData;

    public ConcernUnreadTipHttpResMsg() {
        super(1003387);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        UnreadTipResIdl unreadTipResIdl = (UnreadTipResIdl) new Wire(new Class[0]).parseFrom(bArr, UnreadTipResIdl.class);
        if (unreadTipResIdl != null) {
            if (unreadTipResIdl.error != null) {
                setError(unreadTipResIdl.error.errorno.intValue());
                setErrorString(unreadTipResIdl.error.errmsg);
            }
            if (unreadTipResIdl.data != null) {
                this.mData = new e();
                this.mData.a(unreadTipResIdl.data);
            }
        }
    }
}
