package com.baidu.tieba.enterForum.multiConcern;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.util.n;
import java.util.List;
import tbclient.MultiConcern.DataReq;
import tbclient.MultiConcern.MultiConcernReqIdl;
/* loaded from: classes.dex */
public class MultiConcernRequestMessage extends NetMessage {
    private List<Long> idList;

    public MultiConcernRequestMessage() {
        super(CmdConfigHttp.CMD_FORUM_MULTI_CONCERN, 309470);
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    protected Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.arr_forum_id = this.idList;
        if (z) {
            n.bindCommonParamsToProtobufData(builder, true);
        }
        MultiConcernReqIdl.Builder builder2 = new MultiConcernReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }

    public void setIdList(List<Long> list) {
        this.idList = list;
    }
}
