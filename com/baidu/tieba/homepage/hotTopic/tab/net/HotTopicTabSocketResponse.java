package com.baidu.tieba.homepage.hotTopic.tab.net;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tieba.homepage.hotTopic.tab.c;
import com.squareup.wire.Wire;
import java.util.List;
import tbclient.HotThreadList.HotThreadListResIdl;
/* loaded from: classes21.dex */
public class HotTopicTabSocketResponse extends SocketResponsedMessage implements a {
    private HotThreadListResIdl mData;
    private List<q> mHotTopicDataList;

    public HotTopicTabSocketResponse() {
        super(309661);
    }

    @Override // com.baidu.tieba.homepage.hotTopic.tab.net.a
    public List<q> getDataList() {
        return this.mHotTopicDataList;
    }

    @Override // com.baidu.tieba.homepage.hotTopic.tab.net.a
    public HotThreadListResIdl getResData() {
        return this.mData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        HotThreadListResIdl hotThreadListResIdl = (HotThreadListResIdl) new Wire(new Class[0]).parseFrom(bArr, HotThreadListResIdl.class);
        this.mData = hotThreadListResIdl;
        if (hotThreadListResIdl != null) {
            setError(hotThreadListResIdl.error.errorno.intValue());
            setErrorString(hotThreadListResIdl.error.usermsg);
            if (getError() == 0 && hotThreadListResIdl.data != null) {
                this.mHotTopicDataList = c.a(hotThreadListResIdl);
            }
        }
    }
}
