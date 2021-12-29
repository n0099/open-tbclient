package com.baidu.tieba.im.recommend.detail;

import c.a.d.f.d.l;
import c.a.s0.s.r.a;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import tbclient.Bigvip.BigvipResIdl;
import tbclient.Bigvip.UserInfoBigVip;
/* loaded from: classes12.dex */
public class RecommendDetailHttpResponseMessage extends HttpResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public UserInfoBigVip mDetailInfo;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RecommendDetailHttpResponseMessage(int i2) {
        super(i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public UserInfoBigVip getDetailInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mDetailInfo : (UserInfoBigVip) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.ResponsedMessage
    public void afterDispatchInBackGround(int i2, byte[] bArr) {
        UserInfoBigVip userInfoBigVip;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, bArr) == null) {
            a.f();
            l<byte[]> d2 = a.d("tb.im_recommend_detail");
            if (d2 == null || bArr == null || (userInfoBigVip = this.mDetailInfo) == null || userInfoBigVip.user_id == null) {
                return;
            }
            d2.g(this.mDetailInfo.user_id + "", bArr);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.HttpResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i2, byte[] bArr) throws Exception {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048579, this, i2, bArr) == null) {
            BigvipResIdl bigvipResIdl = (BigvipResIdl) new Wire(new Class[0]).parseFrom(bArr, BigvipResIdl.class);
            setError(bigvipResIdl.error.errorno.intValue());
            setErrorString(bigvipResIdl.error.usermsg);
            if (getError() != 0) {
                return;
            }
            this.mDetailInfo = bigvipResIdl.data.user_info;
        }
    }
}
