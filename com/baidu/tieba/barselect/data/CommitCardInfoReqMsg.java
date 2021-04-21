package com.baidu.tieba.barselect.data;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import d.b.i0.z0.w;
import tbclient.CommitCardInfo.CommitCardInfoReqIdl;
import tbclient.CommitCardInfo.DataReq;
/* loaded from: classes4.dex */
public class CommitCardInfoReqMsg extends NetMessage {
    public int card_type;
    public String image_info;
    public String resource_id;

    public CommitCardInfoReqMsg() {
        super(CmdConfigHttp.CMD_COMMIT_CARD_INFO, 309643);
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    public Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.resource_id = this.resource_id;
        builder.card_type = Integer.valueOf(this.card_type);
        builder.image_info = this.image_info;
        if (z) {
            w.a(builder, true);
        }
        CommitCardInfoReqIdl.Builder builder2 = new CommitCardInfoReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }
}
