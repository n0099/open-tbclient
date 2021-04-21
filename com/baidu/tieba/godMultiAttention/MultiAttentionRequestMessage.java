package com.baidu.tieba.godMultiAttention;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ListUtils;
import d.b.i0.z0.w;
import java.util.ArrayList;
import java.util.List;
import tbclient.MFollow.DataReq;
import tbclient.MFollow.MFollowReqIdl;
/* loaded from: classes4.dex */
public class MultiAttentionRequestMessage extends NetMessage {
    public boolean isAttentionAll;
    public List<String> portraitList;

    public MultiAttentionRequestMessage() {
        super(CmdConfigHttp.MULTI_ATTENTION_HTTP_CMD, 309388);
        this.portraitList = new ArrayList();
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    public Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.portrait = this.portraitList;
        if (z) {
            w.b(builder, true, true);
        }
        MFollowReqIdl.Builder builder2 = new MFollowReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }

    public boolean isAttentionAll() {
        return this.isAttentionAll;
    }

    public void setAttentionAll(boolean z) {
        this.isAttentionAll = z;
    }

    public void setPortraitList(List<String> list) {
        if (ListUtils.isEmpty(list)) {
            return;
        }
        this.portraitList.clear();
        this.portraitList.addAll(list);
    }
}
