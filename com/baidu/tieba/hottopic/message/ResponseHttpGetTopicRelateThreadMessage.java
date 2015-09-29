package com.baidu.tieba.hottopic.message;

import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.baidu.tieba.hottopic.data.a;
import com.squareup.wire.Wire;
import java.util.List;
import tbclient.GetTopicRelateThread.GetTopicRelateThreadResIdl;
import tbclient.Page;
import tbclient.ThreadInfo;
/* loaded from: classes.dex */
public class ResponseHttpGetTopicRelateThreadMessage extends TbHttpResponsedMessage {
    private a hotThreadItemListData;
    private Page page;
    private List<ThreadInfo> thread_list;

    public ResponseHttpGetTopicRelateThreadMessage(int i) {
        super(CmdConfigHttp.CMD_TOPIC_RELATE_THREAD);
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

    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage
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
