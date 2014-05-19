package com.baidu.tieba.im.message;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.frameworkData.MessageTypes;
import com.baidu.tbadk.message.websockt.TbSocketMessage;
import protobuf.QueryUserInfos.DataReq;
import protobuf.QueryUserInfos.QueryUserInfosReqIdl;
/* loaded from: classes.dex */
public class RequestQueryUserInfoMessage extends TbSocketMessage {
    DataReq.Builder dataBuilder;

    public RequestQueryUserInfoMessage() {
        super(MessageTypes.CMD_QUERY_USER_INFO);
        this.dataBuilder = new DataReq.Builder();
    }

    public void setReqUserId(long j) {
        this.dataBuilder.reqUserId = Long.valueOf(j);
    }

    @Override // com.baidu.tbadk.message.websockt.TbSocketMessage
    public Object encode() {
        try {
            QueryUserInfosReqIdl.Builder builder = new QueryUserInfosReqIdl.Builder();
            builder.data = this.dataBuilder.build(false);
            return builder.build(false);
        } catch (Exception e) {
            BdLog.d("data convert error");
            return null;
        }
    }
}
