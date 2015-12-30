package com.baidu.tieba.frs.collect;

import com.baidu.adp.framework.message.Message;
import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.squareup.wire.Wire;
import java.util.List;
import tbclient.GetUserForumStore.GetUserForumStoreResIdl;
import tbclient.ThreadInfo;
/* loaded from: classes.dex */
public class GetUserForumStoreHttpResponseMessage extends TbHttpResponsedMessage {
    private boolean hasMore;
    private com.baidu.tieba.tbadkCore.n responseData;
    private int type;

    public GetUserForumStoreHttpResponseMessage(int i) {
        super(i);
        this.type = -1;
    }

    public com.baidu.tieba.tbadkCore.n getResponseData() {
        return this.responseData;
    }

    public boolean isHasMore() {
        return this.hasMore;
    }

    public int getType() {
        return this.type;
    }

    @Override // com.baidu.adp.framework.message.ResponsedMessage
    public void setOrginalMessage(Message<?> message) {
        super.setOrginalMessage(message);
        if (message.getExtra() instanceof GetUserForumStoreRequestMessage) {
            this.type = ((GetUserForumStoreRequestMessage) message.getExtra()).getType();
        }
    }

    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) {
        this.responseData = new com.baidu.tieba.tbadkCore.n();
        GetUserForumStoreResIdl getUserForumStoreResIdl = (GetUserForumStoreResIdl) new Wire(new Class[0]).parseFrom(bArr, GetUserForumStoreResIdl.class);
        if (getUserForumStoreResIdl.error != null) {
            setError(getUserForumStoreResIdl.error.errorno.intValue());
            setErrorString(getUserForumStoreResIdl.error.usermsg);
        }
        if (getUserForumStoreResIdl.data != null) {
            List<ThreadInfo> list = getUserForumStoreResIdl.data.store_thread;
            this.hasMore = getUserForumStoreResIdl.data.has_more.intValue() == 1;
            this.responseData.bL(list);
        }
    }
}
