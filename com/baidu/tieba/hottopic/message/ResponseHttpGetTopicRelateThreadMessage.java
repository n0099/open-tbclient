package com.baidu.tieba.hottopic.message;

import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.squareup.wire.Wire;
import d.a.j0.c1.c.d;
import java.util.List;
import tbclient.GetTopicRelateThread.DataRes;
import tbclient.GetTopicRelateThread.GetTopicRelateThreadResIdl;
import tbclient.Page;
import tbclient.ThreadInfo;
/* loaded from: classes4.dex */
public class ResponseHttpGetTopicRelateThreadMessage extends TbHttpResponsedMessage {
    public d hotThreadItemListData;
    public Page page;
    public List<ThreadInfo> thread_list;

    public ResponseHttpGetTopicRelateThreadMessage(int i2) {
        super(CmdConfigHttp.CMD_TOPIC_RELATE_THREAD);
    }

    public d getHotThreadItemListData() {
        return this.hotThreadItemListData;
    }

    public Page getPage() {
        return this.page;
    }

    public List<ThreadInfo> getThreadList() {
        return this.thread_list;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage, com.baidu.adp.framework.message.HttpResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i2, byte[] bArr) throws Exception {
        GetTopicRelateThreadResIdl getTopicRelateThreadResIdl = (GetTopicRelateThreadResIdl) new Wire(new Class[0]).parseFrom(bArr, GetTopicRelateThreadResIdl.class);
        if (getTopicRelateThreadResIdl != null) {
            setError(getTopicRelateThreadResIdl.error.errorno.intValue());
            setErrorString(getTopicRelateThreadResIdl.error.usermsg);
            if (getError() != 0) {
                return;
            }
            DataRes dataRes = getTopicRelateThreadResIdl.data;
            this.thread_list = dataRes.thread_list;
            this.page = dataRes.page;
            d dVar = new d();
            this.hotThreadItemListData = dVar;
            dVar.D4(getTopicRelateThreadResIdl.data);
        }
    }
}
