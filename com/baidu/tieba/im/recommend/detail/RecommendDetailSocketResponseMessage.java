package com.baidu.tieba.im.recommend.detail;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.cache.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.squareup.wire.Wire;
import tbclient.Bigvip.BigvipResIdl;
import tbclient.Bigvip.UserInfoBigVip;
/* loaded from: classes26.dex */
public class RecommendDetailSocketResponseMessage extends SocketResponsedMessage {
    private UserInfoBigVip mDetailInfo;

    public RecommendDetailSocketResponseMessage() {
        super(CmdConfigSocket.CMD_GET_RECOMMEND_DETAIL);
    }

    public UserInfoBigVip getDetailInfo() {
        return this.mDetailInfo;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        BigvipResIdl bigvipResIdl = (BigvipResIdl) new Wire(new Class[0]).parseFrom(bArr, BigvipResIdl.class);
        setError(bigvipResIdl.error.errorno.intValue());
        setErrorString(bigvipResIdl.error.usermsg);
        if (getError() == 0) {
            this.mDetailInfo = bigvipResIdl.data.user_info;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.ResponsedMessage
    public void afterDispatchInBackGround(int i, byte[] bArr) {
        l<byte[]> AX = com.baidu.tbadk.core.c.a.bmx().AX("tb.im_recommend_detail");
        if (AX != null && bArr != null && this.mDetailInfo != null && this.mDetailInfo.user_id != null) {
            AX.setForever(this.mDetailInfo.user_id + "", bArr);
        }
    }
}
