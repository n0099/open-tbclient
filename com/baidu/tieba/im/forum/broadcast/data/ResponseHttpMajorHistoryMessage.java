package com.baidu.tieba.im.forum.broadcast.data;

import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.squareup.wire.Wire;
import d.a.j0.e1.i.a.b.a;
import tbclient.Error;
import tbclient.GetForumBroadcastList.GetForumBroadcastListResIdl;
/* loaded from: classes4.dex */
public class ResponseHttpMajorHistoryMessage extends TbHttpResponsedMessage {
    public a majorHistoryData;

    public ResponseHttpMajorHistoryMessage() {
        super(CmdConfigHttp.CMD_FORUM_BROADCAST_MAJOR_HISTORY);
        this.majorHistoryData = new a();
    }

    public a getData() {
        return this.majorHistoryData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage, com.baidu.adp.framework.message.HttpResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i2, byte[] bArr) throws Exception {
        GetForumBroadcastListResIdl getForumBroadcastListResIdl;
        Error error;
        super.decodeInBackGround(i2, bArr);
        if (bArr == null || (error = (getForumBroadcastListResIdl = (GetForumBroadcastListResIdl) new Wire(new Class[0]).parseFrom(bArr, GetForumBroadcastListResIdl.class)).error) == null) {
            return;
        }
        setError(error.errorno.intValue());
        setErrorString(getForumBroadcastListResIdl.error.usermsg);
        if (getError() != 0) {
            return;
        }
        this.majorHistoryData.d(getForumBroadcastListResIdl.data);
        this.majorHistoryData.f();
    }
}
