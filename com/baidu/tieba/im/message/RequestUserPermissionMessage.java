package com.baidu.tieba.im.message;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.frameworkData.MessageTypes;
import com.baidu.tbadk.message.websockt.TbSocketMessage;
import protobuf.QueryUserPermission.DataReq;
import protobuf.QueryUserPermission.QueryUserPermissionReqIdl;
/* loaded from: classes.dex */
public class RequestUserPermissionMessage extends TbSocketMessage {
    private long forumId;

    public RequestUserPermissionMessage() {
        super(MessageTypes.CMD_GET_USER_PERMISSION);
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
            builder.forumId = Integer.valueOf(com.baidu.adp.lib.f.b.a(String.valueOf(getForumId()), 0));
            QueryUserPermissionReqIdl.Builder builder2 = new QueryUserPermissionReqIdl.Builder();
            builder2.data = builder.build(false);
            return builder2.build(false);
        } catch (Exception e) {
            BdLog.d("data convert error");
            return null;
        }
    }
}
