package com.baidu.tieba.enterForum.multiConcern;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.util.t;
import java.util.List;
import tbclient.MultiConcern.DataReq;
import tbclient.MultiConcern.MultiConcernReqIdl;
/* loaded from: classes7.dex */
public class MultiConcernRequestMessage extends NetMessage {
    private List<Long> idList;

    public MultiConcernRequestMessage() {
        super(1003337, CmdConfigSocket.CMD_FORUM_MULTI_CONCERN);
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    protected Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.arr_forum_id = this.idList;
        if (z) {
            t.a(builder, true);
        }
        MultiConcernReqIdl.Builder builder2 = new MultiConcernReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }

    public void setIdList(List<Long> list) {
        this.idList = list;
    }
}
