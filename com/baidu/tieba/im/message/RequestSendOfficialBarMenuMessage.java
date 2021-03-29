package com.baidu.tieba.im.message;

import com.baidu.tbadk.message.websockt.TbSocketMessage;
import d.b.b.e.m.b;
import protobuf.SendMenuMsg.DataReq;
import protobuf.SendMenuMsg.SendMenuMsgReqIdl;
/* loaded from: classes3.dex */
public class RequestSendOfficialBarMenuMessage extends TbSocketMessage {
    public String forum_id;
    public String rid;
    public String user_id;

    public RequestSendOfficialBarMenuMessage() {
        super(208003);
    }

    @Override // com.baidu.tbadk.message.websockt.TbSocketMessage
    public Object encode() {
        DataReq.Builder builder = new DataReq.Builder();
        builder.rid = Integer.valueOf(b.d(this.rid, 0));
        builder.forum_id = getForum_id();
        builder.user_id = Long.valueOf(b.f(this.user_id, 0L));
        SendMenuMsgReqIdl.Builder builder2 = new SendMenuMsgReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }

    public String getForum_id() {
        return this.forum_id;
    }

    public String getRid() {
        return this.rid;
    }

    public String getUser_id() {
        return this.user_id;
    }

    public void setForum_id(String str) {
        this.forum_id = str;
    }

    public void setRid(String str) {
        this.rid = str;
    }

    public void setUser_id(String str) {
        this.user_id = str;
    }
}
