package com.baidu.tieba.hottopic.message;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tieba.hottopic.data.a;
import com.squareup.wire.Wire;
import java.util.List;
import tbclient.GetTopicRelateThread.GetTopicRelateThreadResIdl;
import tbclient.Page;
import tbclient.ThreadInfo;
/* loaded from: classes.dex */
public class ResponseSocketGetTopicRelateThreadMessage extends SocketResponsedMessage {
    private a hotThreadItemListData;
    private Page page;
    private List<ThreadInfo> thread_list;

    public ResponseSocketGetTopicRelateThreadMessage() {
        super(309005);
    }

    public List<ThreadInfo> getThreadList() {
        return this.thread_list;
    }

    public Page getPage() {
        return this.page;
    }

    public a getHotThreadItemListData() {
        return this.hotThreadItemListData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) {
        GetTopicRelateThreadResIdl getTopicRelateThreadResIdl = (GetTopicRelateThreadResIdl) new Wire(new Class[0]).parseFrom(bArr, GetTopicRelateThreadResIdl.class);
        if (getTopicRelateThreadResIdl != null) {
            setError(getTopicRelateThreadResIdl.error.errorno.intValue());
            setErrorString(getTopicRelateThreadResIdl.error.usermsg);
            if (getError() == 0) {
                this.thread_list = getTopicRelateThreadResIdl.data.thread_list;
                this.page = getTopicRelateThreadResIdl.data.page;
                this.hotThreadItemListData = new a();
                this.hotThreadItemListData.a(getTopicRelateThreadResIdl.data);
            }
        }
    }
}
