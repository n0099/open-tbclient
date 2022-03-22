package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.im.data.BlackListItemData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import java.util.ArrayList;
import java.util.List;
import protobuf.GetMaskInfo.DataRes;
import protobuf.GetMaskInfo.GetMaskInfoResIdl;
import protobuf.GetMaskInfo.UserInfo;
/* loaded from: classes5.dex */
public class ResponseGetMaskInfoMessage extends SocketResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public static final int FALSE = 0;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<BlackListItemData> blackList;
    public int isMask;
    public String list;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ResponseGetMaskInfoMessage() {
        super(104103);
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

    public ArrayList<BlackListItemData> getBlackList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.blackList : (ArrayList) invokeV.objValue;
    }

    public int getIsMask() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.isMask : invokeV.intValue;
    }

    public String getList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.list : (String) invokeV.objValue;
    }

    public boolean isMask() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.isMask != 0 : invokeV.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, bArr) == null) {
            GetMaskInfoResIdl getMaskInfoResIdl = (GetMaskInfoResIdl) new Wire(new Class[0]).parseFrom(bArr, GetMaskInfoResIdl.class);
            setError(getMaskInfoResIdl.error.errorno.intValue());
            setErrorString(getMaskInfoResIdl.error.usermsg);
            if (getError() != 0) {
                return;
            }
            this.blackList = new ArrayList<>();
            DataRes dataRes = getMaskInfoResIdl.data;
            if (dataRes != null) {
                this.isMask = dataRes.isMask.intValue();
                DataRes dataRes2 = getMaskInfoResIdl.data;
                this.list = dataRes2.list;
                List<UserInfo> list = dataRes2.users;
                int size = list != null ? list.size() : 0;
                for (int i2 = 0; i2 < size; i2++) {
                    BlackListItemData blackListItemData = new BlackListItemData();
                    blackListItemData.A(list.get(i2).portrait);
                    blackListItemData.setUserId(list.get(i2).uid.longValue());
                    blackListItemData.setUserName(list.get(i2).name);
                    blackListItemData.B(list.get(i2).nameShow);
                    this.blackList.add(blackListItemData);
                }
            }
        }
    }
}
