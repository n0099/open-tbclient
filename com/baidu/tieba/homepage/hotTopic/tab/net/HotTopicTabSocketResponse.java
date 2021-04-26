package com.baidu.tieba.homepage.hotTopic.tab.net;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.squareup.wire.Wire;
import d.a.c.j.e.n;
import d.a.j0.a1.e.a.c;
import d.a.j0.a1.e.a.f.a;
import java.util.List;
import tbclient.HotThreadList.HotThreadListResIdl;
/* loaded from: classes4.dex */
public class HotTopicTabSocketResponse extends SocketResponsedMessage implements a {
    public HotThreadListResIdl mData;
    public List<n> mHotTopicDataList;

    public HotTopicTabSocketResponse() {
        super(309661);
    }

    @Override // d.a.j0.a1.e.a.f.a
    public List<n> getDataList() {
        return this.mHotTopicDataList;
    }

    @Override // d.a.j0.a1.e.a.f.a
    public HotThreadListResIdl getResData() {
        return this.mData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i2, byte[] bArr) throws Exception {
        HotThreadListResIdl hotThreadListResIdl = (HotThreadListResIdl) new Wire(new Class[0]).parseFrom(bArr, HotThreadListResIdl.class);
        this.mData = hotThreadListResIdl;
        if (hotThreadListResIdl == null) {
            return;
        }
        setError(hotThreadListResIdl.error.errorno.intValue());
        setErrorString(hotThreadListResIdl.error.usermsg);
        if (getError() == 0 && hotThreadListResIdl.data != null) {
            this.mHotTopicDataList = c.d(hotThreadListResIdl);
        }
    }
}
