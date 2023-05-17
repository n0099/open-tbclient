package com.baidu.tieba.im.message;

import androidx.annotation.Nullable;
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
/* loaded from: classes6.dex */
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
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.blackList;
        }
        return (ArrayList) invokeV.objValue;
    }

    public int getIsMask() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.isMask;
        }
        return invokeV.intValue;
    }

    public String getList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.list;
        }
        return (String) invokeV.objValue;
    }

    public boolean isMask() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.isMask != 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.adp.framework.message.SocketResponsedMessage
    @Nullable
    public Object decodeInBackGroundNeedResult(int i, byte[] bArr) throws Exception {
        InterceptResult invokeIL;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048576, this, i, bArr)) == null) {
            GetMaskInfoResIdl getMaskInfoResIdl = (GetMaskInfoResIdl) new Wire(new Class[0]).parseFrom(bArr, GetMaskInfoResIdl.class);
            setError(getMaskInfoResIdl.error.errorno.intValue());
            setErrorString(getMaskInfoResIdl.error.usermsg);
            if (getError() != 0) {
                return getMaskInfoResIdl;
            }
            this.blackList = new ArrayList<>();
            DataRes dataRes = getMaskInfoResIdl.data;
            if (dataRes != null) {
                this.isMask = dataRes.isMask.intValue();
                DataRes dataRes2 = getMaskInfoResIdl.data;
                this.list = dataRes2.list;
                List<UserInfo> list = dataRes2.users;
                if (list != null) {
                    i2 = list.size();
                } else {
                    i2 = 0;
                }
                for (int i3 = 0; i3 < i2; i3++) {
                    BlackListItemData blackListItemData = new BlackListItemData();
                    blackListItemData.U(list.get(i3).portrait);
                    blackListItemData.setUserId(list.get(i3).uid.longValue());
                    blackListItemData.setUserName(list.get(i3).name);
                    blackListItemData.V(list.get(i3).nameShow);
                    this.blackList.add(blackListItemData);
                }
            }
            return getMaskInfoResIdl;
        }
        return invokeIL.objValue;
    }
}
