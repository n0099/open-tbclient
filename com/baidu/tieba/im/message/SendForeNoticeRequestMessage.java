package com.baidu.tieba.im.message;

import com.baidu.tbadk.core.frameworkData.MessageTypes;
import com.baidu.tbadk.message.websockt.TbSocketMessage;
import protobuf.SendForenoticeMsg.DataReq;
import protobuf.SendForenoticeMsg.SendForenoticeMsgReqIdl;
/* loaded from: classes.dex */
public class SendForeNoticeRequestMessage extends TbSocketMessage {
    private String content;
    private int gid;

    public SendForeNoticeRequestMessage(int i, String str) {
        super(MessageTypes.CMD_SEND_FORE_NOTICE);
        setGid(i);
        setContent(str);
    }

    public int getGid() {
        return this.gid;
    }

    public void setGid(int i) {
        this.gid = i;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String str) {
        this.content = str;
    }

    @Override // com.baidu.tbadk.message.websockt.TbSocketMessage
    protected Object encode() {
        DataReq.Builder builder = new DataReq.Builder();
        builder.groupId = Integer.valueOf(getGid());
        builder.content = getContent();
        SendForenoticeMsgReqIdl.Builder builder2 = new SendForenoticeMsgReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }
}
