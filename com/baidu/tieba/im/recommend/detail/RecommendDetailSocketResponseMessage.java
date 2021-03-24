package com.baidu.tieba.im.recommend.detail;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.squareup.wire.Wire;
import d.b.b.e.d.l;
import d.b.h0.r.r.a;
import tbclient.Bigvip.BigvipResIdl;
import tbclient.Bigvip.UserInfoBigVip;
/* loaded from: classes4.dex */
public class RecommendDetailSocketResponseMessage extends SocketResponsedMessage {
    public UserInfoBigVip mDetailInfo;

    public RecommendDetailSocketResponseMessage() {
        super(303025);
    }

    public UserInfoBigVip getDetailInfo() {
        return this.mDetailInfo;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.ResponsedMessage
    public void afterDispatchInBackGround(int i, byte[] bArr) {
        UserInfoBigVip userInfoBigVip;
        l<byte[]> d2 = a.f().d("tb.im_recommend_detail");
        if (d2 == null || bArr == null || (userInfoBigVip = this.mDetailInfo) == null || userInfoBigVip.user_id == null) {
            return;
        }
        d2.g(this.mDetailInfo.user_id + "", bArr);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        BigvipResIdl bigvipResIdl = (BigvipResIdl) new Wire(new Class[0]).parseFrom(bArr, BigvipResIdl.class);
        setError(bigvipResIdl.error.errorno.intValue());
        setErrorString(bigvipResIdl.error.usermsg);
        if (getError() != 0) {
            return;
        }
        this.mDetailInfo = bigvipResIdl.data.user_info;
    }
}
