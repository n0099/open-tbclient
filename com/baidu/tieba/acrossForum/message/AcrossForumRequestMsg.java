package com.baidu.tieba.acrossForum.message;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.util.n;
import tbclient.Acrossforum.AcrossforumReqIdl;
import tbclient.Acrossforum.DataReq;
/* loaded from: classes.dex */
public class AcrossForumRequestMsg extends NetMessage {
    public String callFrom;
    public String forumName;
    public int needNum;

    public AcrossForumRequestMsg() {
        super(CmdConfigHttp.CMD_ACROSS_FORUM, 309424);
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    protected Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.call_from = this.callFrom;
        builder.forum_name = this.forumName;
        builder.need_num = Integer.valueOf(this.needNum);
        if (z) {
            n.a(builder, true);
        }
        AcrossforumReqIdl.Builder builder2 = new AcrossforumReqIdl.Builder();
        builder2.data = builder.build(true);
        return builder2.build(true);
    }
}
