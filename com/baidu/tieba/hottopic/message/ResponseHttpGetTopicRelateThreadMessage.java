package com.baidu.tieba.hottopic.message;

import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.baidu.tieba.hottopic.data.d;
import com.squareup.wire.Wire;
import java.util.List;
import tbclient.GetTopicRelateThread.GetTopicRelateThreadResIdl;
import tbclient.Page;
import tbclient.ThreadInfo;
/* loaded from: classes21.dex */
public class ResponseHttpGetTopicRelateThreadMessage extends TbHttpResponsedMessage {
    private d hotThreadItemListData;
    private Page page;
    private List<ThreadInfo> thread_list;

    public ResponseHttpGetTopicRelateThreadMessage(int i) {
        super(1003042);
    }

    public List<ThreadInfo> getThreadList() {
        return this.thread_list;
    }

    public Page getPage() {
        return this.page;
    }

    public d getHotThreadItemListData() {
        return this.hotThreadItemListData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage, com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        GetTopicRelateThreadResIdl getTopicRelateThreadResIdl = (GetTopicRelateThreadResIdl) new Wire(new Class[0]).parseFrom(bArr, GetTopicRelateThreadResIdl.class);
        if (getTopicRelateThreadResIdl != null) {
            setError(getTopicRelateThreadResIdl.error.errorno.intValue());
            setErrorString(getTopicRelateThreadResIdl.error.usermsg);
            if (getError() == 0) {
                this.thread_list = getTopicRelateThreadResIdl.data.thread_list;
                this.page = getTopicRelateThreadResIdl.data.page;
                this.hotThreadItemListData = new d();
                this.hotThreadItemListData.a(getTopicRelateThreadResIdl.data);
            }
        }
    }
}
