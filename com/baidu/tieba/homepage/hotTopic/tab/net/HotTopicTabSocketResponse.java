package com.baidu.tieba.homepage.hotTopic.tab.net;

import c.a.e.l.e.n;
import c.a.r0.h1.f.a.c;
import c.a.r0.h1.f.a.f.a;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import java.util.List;
import tbclient.HotThreadList.HotThreadListResIdl;
/* loaded from: classes7.dex */
public class HotTopicTabSocketResponse extends SocketResponsedMessage implements a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public HotThreadListResIdl mData;
    public List<n> mHotTopicDataList;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HotTopicTabSocketResponse() {
        super(309661);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // c.a.r0.h1.f.a.f.a
    public List<n> getDataList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mHotTopicDataList : (List) invokeV.objValue;
    }

    @Override // c.a.r0.h1.f.a.f.a
    public HotThreadListResIdl getResData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mData : (HotThreadListResIdl) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i2, byte[] bArr) throws Exception {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, bArr) == null) {
            HotThreadListResIdl hotThreadListResIdl = (HotThreadListResIdl) new Wire(new Class[0]).parseFrom(bArr, HotThreadListResIdl.class);
            this.mData = hotThreadListResIdl;
            if (hotThreadListResIdl == null) {
                return;
            }
            setError(hotThreadListResIdl.error.errorno.intValue());
            setErrorString(hotThreadListResIdl.error.usermsg);
            if (getError() == 0 && hotThreadListResIdl.data != null) {
                this.mHotTopicDataList = c.c(hotThreadListResIdl);
            }
        }
    }
}
