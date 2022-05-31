package com.baidu.tieba.im.recommend.detail;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.cq4;
import com.repackage.qe;
import com.squareup.wire.Wire;
import tbclient.Bigvip.BigvipResIdl;
import tbclient.Bigvip.UserInfoBigVip;
/* loaded from: classes3.dex */
public class RecommendDetailSocketResponseMessage extends SocketResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public UserInfoBigVip mDetailInfo;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RecommendDetailSocketResponseMessage() {
        super(303025);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
    public void afterDispatchInBackGround(int i, byte[] bArr) {
        UserInfoBigVip userInfoBigVip;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, bArr) == null) {
            cq4.f();
            qe<byte[]> d = cq4.d("tb.im_recommend_detail");
            if (d == null || bArr == null || (userInfoBigVip = this.mDetailInfo) == null || userInfoBigVip.user_id == null) {
                return;
            }
            d.g(this.mDetailInfo.user_id + "", bArr);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048579, this, i, bArr) == null) {
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
