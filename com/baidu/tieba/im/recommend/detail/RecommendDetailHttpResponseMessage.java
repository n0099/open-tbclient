package com.baidu.tieba.im.recommend.detail;

import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.cache.t;
import com.squareup.wire.Wire;
import tbclient.Bigvip.BigvipResIdl;
import tbclient.Bigvip.UserInfoBigVip;
/* loaded from: classes.dex */
public class RecommendDetailHttpResponseMessage extends HttpResponsedMessage {
    private UserInfoBigVip mDetailInfo;

    public RecommendDetailHttpResponseMessage(int i) {
        super(i);
    }

    public UserInfoBigVip getDetailInfo() {
        return this.mDetailInfo;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.b
    public void decodeInBackGround(int i, byte[] bArr) {
        BigvipResIdl bigvipResIdl = (BigvipResIdl) new Wire(new Class[0]).parseFrom(bArr, BigvipResIdl.class);
        setError(bigvipResIdl.error.errorno.intValue());
        setErrorString(bigvipResIdl.error.usermsg);
        if (getError() == 0) {
            this.mDetailInfo = bigvipResIdl.data.user_info;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: java.lang.Integer : 0x001f: IGET  (r2v1 java.lang.Integer A[REMOVE]) = 
      (wrap: tbclient.Bigvip.UserInfoBigVip : 0x001d: IGET  (r2v0 tbclient.Bigvip.UserInfoBigVip A[REMOVE]) = (r3v0 'this' com.baidu.tieba.im.recommend.detail.RecommendDetailHttpResponseMessage A[IMMUTABLE_TYPE, THIS]) com.baidu.tieba.im.recommend.detail.RecommendDetailHttpResponseMessage.mDetailInfo tbclient.Bigvip.UserInfoBigVip)
     tbclient.Bigvip.UserInfoBigVip.user_id java.lang.Integer)] */
    @Override // com.baidu.adp.framework.message.ResponsedMessage
    public void afterDispatchInBackGround(int i, byte[] bArr) {
        t<byte[]> bW = com.baidu.tbadk.core.b.a.rc().bW("tb.im_recommend_detail");
        if (bW != null && bArr != null && this.mDetailInfo != null && this.mDetailInfo.user_id != null) {
            bW.f(new StringBuilder().append(this.mDetailInfo.user_id).toString(), bArr);
        }
    }
}
