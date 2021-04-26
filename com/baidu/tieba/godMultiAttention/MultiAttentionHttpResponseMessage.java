package com.baidu.tieba.godMultiAttention;

import com.baidu.adp.framework.message.Message;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.squareup.wire.Wire;
import java.util.List;
import tbclient.Error;
import tbclient.MFollow.DataRes;
import tbclient.MFollow.MFollowResIdl;
import tbclient.MFollow.MFollowResult;
/* loaded from: classes4.dex */
public class MultiAttentionHttpResponseMessage extends TbHttpResponsedMessage {
    public List<MFollowResult> followResults;
    public boolean isAttentionAll;

    public MultiAttentionHttpResponseMessage() {
        super(CmdConfigHttp.MULTI_ATTENTION_HTTP_CMD);
    }

    public List<MFollowResult> getFollowResults() {
        return this.followResults;
    }

    public boolean isAttentionAll() {
        return this.isAttentionAll;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage, com.baidu.adp.framework.message.HttpResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i2, byte[] bArr) throws Exception {
        MFollowResIdl mFollowResIdl = (MFollowResIdl) new Wire(new Class[0]).parseFrom(bArr, MFollowResIdl.class);
        Error error = mFollowResIdl.error;
        if (error != null) {
            setError(error.errorno.intValue());
            setErrorString(mFollowResIdl.error.errmsg);
        }
        DataRes dataRes = mFollowResIdl.data;
        if (dataRes != null) {
            this.followResults = dataRes.follow_results;
        }
        Message<?> orginalMessage = getOrginalMessage();
        if (orginalMessage == null || !(orginalMessage.getExtra() instanceof MultiAttentionRequestMessage)) {
            return;
        }
        this.isAttentionAll = ((MultiAttentionRequestMessage) orginalMessage.getExtra()).isAttentionAll();
    }
}
