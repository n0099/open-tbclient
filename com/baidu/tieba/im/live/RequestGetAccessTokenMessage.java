package com.baidu.tieba.im.live;

import com.baidu.tbadk.core.frameworkData.MessageTypes;
import com.baidu.tbadk.message.websockt.TbSocketMessage;
import protobuf.GetAccessToken.DataReq;
import protobuf.GetAccessToken.GetAccessTokenReqIdl;
/* loaded from: classes.dex */
public class RequestGetAccessTokenMessage extends TbSocketMessage {
    private String bduss;

    public RequestGetAccessTokenMessage() {
        super(MessageTypes.CMD_GET_ACCESS_TOKEN);
    }

    public String getBduss() {
        return this.bduss;
    }

    public void setBduss(String str) {
        this.bduss = str;
    }

    @Override // com.baidu.tbadk.message.websockt.TbSocketMessage
    public Object encode() {
        DataReq.Builder builder = new DataReq.Builder();
        builder.bduss = getBduss();
        GetAccessTokenReqIdl.Builder builder2 = new GetAccessTokenReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }
}
