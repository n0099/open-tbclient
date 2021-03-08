package com.baidu.tieba.barselect.data;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.util.v;
import tbclient.CommitCardInfo.CommitCardInfoReqIdl;
import tbclient.CommitCardInfo.DataReq;
/* loaded from: classes7.dex */
public class CommitCardInfoReqMsg extends NetMessage {
    public int card_type;
    public String image_info;
    public String resource_id;

    public CommitCardInfoReqMsg() {
        super(CmdConfigHttp.CMD_COMMIT_CARD_INFO, 309643);
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    protected Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.resource_id = this.resource_id;
        builder.card_type = Integer.valueOf(this.card_type);
        builder.image_info = this.image_info;
        if (z) {
            v.b(builder, true);
        }
        CommitCardInfoReqIdl.Builder builder2 = new CommitCardInfoReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }
}
