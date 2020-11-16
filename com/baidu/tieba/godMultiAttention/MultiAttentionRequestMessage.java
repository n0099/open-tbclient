package com.baidu.tieba.godMultiAttention;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.util.u;
import java.util.ArrayList;
import java.util.List;
import tbclient.MFollow.DataReq;
import tbclient.MFollow.MFollowReqIdl;
/* loaded from: classes23.dex */
public class MultiAttentionRequestMessage extends NetMessage {
    private boolean isAttentionAll;
    private List<String> portraitList;

    public MultiAttentionRequestMessage() {
        super(1003105, CmdConfigSocket.MULTI_ATTENTION_SOCKET_CMD);
        this.portraitList = new ArrayList();
    }

    public void setPortraitList(List<String> list) {
        if (!y.isEmpty(list)) {
            this.portraitList.clear();
            this.portraitList.addAll(list);
        }
    }

    public boolean isAttentionAll() {
        return this.isAttentionAll;
    }

    public void setAttentionAll(boolean z) {
        this.isAttentionAll = z;
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    protected Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.portrait = this.portraitList;
        if (z) {
            u.a(builder, true, true);
        }
        MFollowReqIdl.Builder builder2 = new MFollowReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }
}
