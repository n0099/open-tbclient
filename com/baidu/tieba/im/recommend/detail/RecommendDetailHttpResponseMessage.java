package com.baidu.tieba.im.recommend.detail;

import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.cache.l;
import com.squareup.wire.Wire;
import tbclient.Bigvip.BigvipResIdl;
import tbclient.Bigvip.UserInfoBigVip;
/* loaded from: classes3.dex */
public class RecommendDetailHttpResponseMessage extends HttpResponsedMessage {
    private UserInfoBigVip mDetailInfo;

    public RecommendDetailHttpResponseMessage(int i) {
        super(i);
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
        l<byte[]> nk = com.baidu.tbadk.core.d.a.akL().nk("tb.im_recommend_detail");
        if (nk != null && bArr != null && this.mDetailInfo != null && this.mDetailInfo.user_id != null) {
            nk.setForever(this.mDetailInfo.user_id + "", bArr);
        }
    }
}
