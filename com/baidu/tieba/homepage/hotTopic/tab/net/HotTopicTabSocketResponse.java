package com.baidu.tieba.homepage.hotTopic.tab.net;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.squareup.wire.Wire;
import d.b.b.j.e.n;
import d.b.i0.z0.e.a.c;
import d.b.i0.z0.e.a.f.a;
import java.util.List;
import tbclient.HotThreadList.HotThreadListResIdl;
/* loaded from: classes3.dex */
public class HotTopicTabSocketResponse extends SocketResponsedMessage implements a {
    public HotThreadListResIdl mData;
    public List<n> mHotTopicDataList;

    public HotTopicTabSocketResponse() {
        super(309661);
    }

    @Override // d.b.i0.z0.e.a.f.a
    public List<n> getDataList() {
        return this.mHotTopicDataList;
    }

    @Override // d.b.i0.z0.e.a.f.a
    public HotThreadListResIdl getResData() {
        return this.mData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
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
