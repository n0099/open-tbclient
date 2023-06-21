package com.baidu.tieba.homepage.hotTopic.tab.net;

import androidx.annotation.Nullable;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.cy7;
import com.baidu.tieba.ty7;
import com.baidu.tieba.wn;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import java.util.List;
import tbclient.HotThreadList.HotThreadListResIdl;
/* loaded from: classes6.dex */
public class HotTopicTabSocketResponse extends SocketResponsedMessage implements ty7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public HotThreadListResIdl mData;
    public List<wn> mHotTopicDataList;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HotTopicTabSocketResponse() {
        super(309661);
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

    @Override // com.baidu.tieba.ty7
    public List<wn> getDataList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mHotTopicDataList;
        }
        return (List) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ty7
    public HotThreadListResIdl getResData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.mData;
        }
        return (HotThreadListResIdl) invokeV.objValue;
    }

    @Override // com.baidu.adp.framework.message.SocketResponsedMessage
    @Nullable
    public Object decodeInBackGroundNeedResult(int i, byte[] bArr) throws Exception {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048576, this, i, bArr)) == null) {
            HotThreadListResIdl hotThreadListResIdl = (HotThreadListResIdl) new Wire(new Class[0]).parseFrom(bArr, HotThreadListResIdl.class);
            this.mData = hotThreadListResIdl;
            if (hotThreadListResIdl == null) {
                return null;
            }
            setError(hotThreadListResIdl.error.errorno.intValue());
            setErrorString(hotThreadListResIdl.error.usermsg);
            if (getError() != 0) {
                return hotThreadListResIdl;
            }
            if (hotThreadListResIdl.data == null) {
                return hotThreadListResIdl;
            }
            this.mHotTopicDataList = cy7.c(hotThreadListResIdl);
            return hotThreadListResIdl;
        }
        return invokeIL.objValue;
    }
}
