package com.baidu.tieba.frs;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import tbclient.SetCommonForumState.DataReq;
import tbclient.SetCommonForumState.SetCommonForumStateReqIdl;
/* loaded from: classes4.dex */
public class RequestSetCommForumStateNetMessage extends NetMessage {
    private long mForumId;
    private int operation;

    public void setForumId(long j) {
        this.mForumId = j;
    }

    public void setOperation(int i) {
        this.operation = i;
    }

    public RequestSetCommForumStateNetMessage() {
        super(CmdConfigHttp.CMD_SET_COMMON_FORUM_STATE, 309365);
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    protected Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.forum_id = Long.valueOf(this.mForumId);
        builder.operation = Integer.valueOf(this.operation);
        if (z) {
            com.baidu.tbadk.util.r.bindCommonParamsToProtobufData(builder, true);
        }
        SetCommonForumStateReqIdl.Builder builder2 = new SetCommonForumStateReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }
}
