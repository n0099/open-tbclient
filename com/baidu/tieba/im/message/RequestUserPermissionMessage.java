package com.baidu.tieba.im.message;

import com.baidu.tbadk.message.websockt.TbSocketMessage;
import d.b.b.e.m.b;
import protobuf.QueryUserPermission.DataReq;
import protobuf.QueryUserPermission.QueryUserPermissionReqIdl;
/* loaded from: classes3.dex */
public class RequestUserPermissionMessage extends TbSocketMessage {
    public long forumId;

    public RequestUserPermissionMessage() {
        super(103008);
    }

    @Override // com.baidu.tbadk.message.websockt.TbSocketMessage
    public Object encode() {
        try {
            DataReq.Builder builder = new DataReq.Builder();
            builder.forumId = Integer.valueOf(b.d(String.valueOf(getForumId()), 0));
            QueryUserPermissionReqIdl.Builder builder2 = new QueryUserPermissionReqIdl.Builder();
            builder2.data = builder.build(false);
            return builder2.build(false);
        } catch (Exception unused) {
            return null;
        }
    }

    public long getForumId() {
        return this.forumId;
    }

    public void setForumId(long j) {
        this.forumId = j;
    }
}
