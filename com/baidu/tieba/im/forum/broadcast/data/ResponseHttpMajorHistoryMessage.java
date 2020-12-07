package com.baidu.tieba.im.forum.broadcast.data;

import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.squareup.wire.Wire;
import tbclient.GetForumBroadcastList.GetForumBroadcastListResIdl;
/* loaded from: classes26.dex */
public class ResponseHttpMajorHistoryMessage extends TbHttpResponsedMessage {
    a majorHistoryData;

    public ResponseHttpMajorHistoryMessage() {
        super(CmdConfigHttp.CMD_FORUM_BROADCAST_MAJOR_HISTORY);
        this.majorHistoryData = new a();
    }

    public a getData() {
        return this.majorHistoryData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage, com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        super.decodeInBackGround(i, bArr);
        if (bArr != null) {
            GetForumBroadcastListResIdl getForumBroadcastListResIdl = (GetForumBroadcastListResIdl) new Wire(new Class[0]).parseFrom(bArr, GetForumBroadcastListResIdl.class);
            if (getForumBroadcastListResIdl.error != null) {
                setError(getForumBroadcastListResIdl.error.errorno.intValue());
                setErrorString(getForumBroadcastListResIdl.error.usermsg);
                if (getError() == 0) {
                    this.majorHistoryData.a(getForumBroadcastListResIdl.data);
                    this.majorHistoryData.cWq();
                }
            }
        }
    }
}
