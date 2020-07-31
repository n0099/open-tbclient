package com.baidu.tieba.im.message;

import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.message.websockt.TbSocketMessage;
import protobuf.SendMenuMsg.DataReq;
import protobuf.SendMenuMsg.SendMenuMsgReqIdl;
/* loaded from: classes20.dex */
public class RequestSendOfficialBarMenuMessage extends TbSocketMessage {
    private String forum_id;
    private String rid;
    private String user_id;

    public RequestSendOfficialBarMenuMessage() {
        super(CmdConfigSocket.CMD_SEND_OFFICIAL_BAR_MENU);
    }

    public String getRid() {
        return this.rid;
    }

    public void setRid(String str) {
        this.rid = str;
    }

    public String getUser_id() {
        return this.user_id;
    }

    public void setUser_id(String str) {
        this.user_id = str;
    }

    public String getForum_id() {
        return this.forum_id;
    }

    public void setForum_id(String str) {
        this.forum_id = str;
    }

    @Override // com.baidu.tbadk.message.websockt.TbSocketMessage
    public Object encode() {
        DataReq.Builder builder = new DataReq.Builder();
        builder.rid = Integer.valueOf(com.baidu.adp.lib.f.b.toInt(this.rid, 0));
        builder.forum_id = getForum_id();
        builder.user_id = Long.valueOf(com.baidu.adp.lib.f.b.toLong(this.user_id, 0L));
        SendMenuMsgReqIdl.Builder builder2 = new SendMenuMsgReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }
}
