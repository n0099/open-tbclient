package com.baidu.tieba.godMultiAttention;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.util.p;
import java.util.ArrayList;
import java.util.List;
import tbclient.MFollow.DataReq;
import tbclient.MFollow.MFollowReqIdl;
/* loaded from: classes3.dex */
public class MultiAttentionRequestMessage extends NetMessage {
    private boolean isAttentionAll;
    private List<String> portraitList;

    public MultiAttentionRequestMessage() {
        super(CmdConfigHttp.MULTI_ATTENTION_HTTP_CMD, 309388);
        this.portraitList = new ArrayList();
    }

    public void setPortraitList(List<String> list) {
        if (!v.I(list)) {
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
            p.bindCommonParamsToProtobufData(builder, true, true);
        }
        MFollowReqIdl.Builder builder2 = new MFollowReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }
}
