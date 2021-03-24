package com.baidu.tieba.godMultiAttention;

import com.baidu.adp.framework.message.Message;
import com.baidu.tbadk.message.websockt.TbSocketReponsedMessage;
import com.squareup.wire.Wire;
import java.util.List;
import tbclient.Error;
import tbclient.MFollow.DataRes;
import tbclient.MFollow.MFollowResIdl;
import tbclient.MFollow.MFollowResult;
/* loaded from: classes4.dex */
public class MultiAttentionSocketResponseMessage extends TbSocketReponsedMessage {
    public List<MFollowResult> followResults;
    public boolean isAttentionAll;

    public MultiAttentionSocketResponseMessage() {
        super(309388);
    }

    public List<MFollowResult> getFollowResults() {
        return this.followResults;
    }

    public boolean isAttentionAll() {
        return this.isAttentionAll;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.message.websockt.TbSocketReponsedMessage, com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
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
