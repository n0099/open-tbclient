package com.baidu.tieba.godMultiAttention;

import com.baidu.adp.framework.message.Message;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.squareup.wire.Wire;
import java.util.List;
import tbclient.MFollow.MFollowResIdl;
import tbclient.MFollow.MFollowResult;
/* loaded from: classes3.dex */
public class MultiAttentionHttpResponseMessage extends TbHttpResponsedMessage {
    private List<MFollowResult> followResults;
    private boolean isAttentionAll;

    public MultiAttentionHttpResponseMessage() {
        super(CmdConfigHttp.MULTI_ATTENTION_HTTP_CMD);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage, com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        MFollowResIdl mFollowResIdl = (MFollowResIdl) new Wire(new Class[0]).parseFrom(bArr, MFollowResIdl.class);
        if (mFollowResIdl.error != null) {
            setError(mFollowResIdl.error.errorno.intValue());
            setErrorString(mFollowResIdl.error.errmsg);
        }
        if (mFollowResIdl.data != null) {
            this.followResults = mFollowResIdl.data.follow_results;
        }
        Message<?> orginalMessage = getOrginalMessage();
        if (orginalMessage != null && (orginalMessage.getExtra() instanceof MultiAttentionRequestMessage)) {
            this.isAttentionAll = ((MultiAttentionRequestMessage) orginalMessage.getExtra()).isAttentionAll();
        }
    }

    public List<MFollowResult> getFollowResults() {
        return this.followResults;
    }

    public boolean isAttentionAll() {
        return this.isAttentionAll;
    }
}
