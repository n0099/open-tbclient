package com.baidu.tieba.im.recommend.detail;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.cache.l;
import com.squareup.wire.Wire;
import tbclient.Bigvip.BigvipResIdl;
import tbclient.Bigvip.UserInfoBigVip;
/* loaded from: classes3.dex */
public class RecommendDetailSocketResponseMessage extends SocketResponsedMessage {
    private UserInfoBigVip mDetailInfo;

    public RecommendDetailSocketResponseMessage() {
        super(303025);
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
        l<byte[]> cY = com.baidu.tbadk.core.c.a.ty().cY("tb.im_recommend_detail");
        if (cY != null && bArr != null && this.mDetailInfo != null && this.mDetailInfo.user_id != null) {
            cY.e(this.mDetailInfo.user_id + "", bArr);
        }
    }
}
