package com.baidu.tieba.im.message;

import com.baidu.tbadk.message.websockt.TbSocketMessage;
import protobuf.QueryUserPermission.DataReq;
import protobuf.QueryUserPermission.QueryUserPermissionReqIdl;
/* loaded from: classes3.dex */
public class RequestUserPermissionMessage extends TbSocketMessage {
    private long forumId;

    public RequestUserPermissionMessage() {
        super(103008);
    }

    public long getForumId() {
        return this.forumId;
    }

    public void setForumId(long j) {
        this.forumId = j;
    }

    @Override // com.baidu.tbadk.message.websockt.TbSocketMessage
    public Object encode() {
        try {
            DataReq.Builder builder = new DataReq.Builder();
            builder.forumId = Integer.valueOf(com.baidu.adp.lib.g.b.l(String.valueOf(getForumId()), 0));
            QueryUserPermissionReqIdl.Builder builder2 = new QueryUserPermissionReqIdl.Builder();
            builder2.data = builder.build(false);
            return builder2.build(false);
        } catch (Exception e) {
            return null;
        }
    }
}
