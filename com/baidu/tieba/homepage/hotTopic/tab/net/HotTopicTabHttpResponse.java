package com.baidu.tieba.homepage.hotTopic.tab.net;

import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.squareup.wire.Wire;
import d.a.c.k.e.n;
import d.a.n0.b1.f.a.c;
import d.a.n0.b1.f.a.f.a;
import java.util.List;
import tbclient.HotThreadList.HotThreadListResIdl;
/* loaded from: classes4.dex */
public class HotTopicTabHttpResponse extends TbHttpResponsedMessage implements a {
    public HotThreadListResIdl mData;
    public List<n> mHotTopicDataList;

    public HotTopicTabHttpResponse() {
        super(CmdConfigHttp.CMD_HOT_TOPIC_TAB);
    }

    @Override // d.a.n0.b1.f.a.f.a
    public List<n> getDataList() {
        return this.mHotTopicDataList;
    }

    @Override // d.a.n0.b1.f.a.f.a
    public HotThreadListResIdl getResData() {
        return this.mData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage, com.baidu.adp.framework.message.HttpResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
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
