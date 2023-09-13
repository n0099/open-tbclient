package com.baidu.tieba.hottopic.message;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.switchs.SocketAddCommonParamSwitch;
import com.baidu.tbadk.util.NetMessageHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.CommonReq;
import tbclient.TopicList.DataReq;
import tbclient.TopicList.TopicListReqIdl;
/* loaded from: classes6.dex */
public class RequestHotRanklistMessage extends NetMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String call_from;

    /* renamed from: common  reason: collision with root package name */
    public CommonReq f1111common;
    public long fid;
    public String list_type;
    public String need_tab_list;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RequestHotRanklistMessage() {
        super(CmdConfigHttp.CMD_HOT_TOPIC_RANKLIST, 309289);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr = newInitContext.callArgs;
                super(((Integer) objArr[0]).intValue(), ((Integer) objArr[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    public Object encode(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048576, this, z)) == null) {
            try {
                DataReq.Builder builder = new DataReq.Builder();
                builder.f1510common = getCommon();
                builder.call_from = getCallFrom();
                builder.list_type = getListType();
                builder.need_tab_list = getNeedTabList();
                builder.fid = Long.valueOf(this.fid);
                if (z || SocketAddCommonParamSwitch.getIsOn()) {
                    NetMessageHelper.bindCommonParamsToProtobufData(builder, true);
                }
                TopicListReqIdl.Builder builder2 = new TopicListReqIdl.Builder();
                builder2.data = builder.build(false);
                return builder2.build(false);
            } catch (Exception unused) {
                return null;
            }
        }
        return invokeZ.objValue;
    }

    public String getCallFrom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.call_from;
        }
        return (String) invokeV.objValue;
    }

    public CommonReq getCommon() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.f1111common;
        }
        return (CommonReq) invokeV.objValue;
    }

    public String getListType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.list_type;
        }
        return (String) invokeV.objValue;
    }

    public String getNeedTabList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.need_tab_list;
        }
        return (String) invokeV.objValue;
    }

    public void setCallFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.call_from = str;
        }
    }

    public void setCommon(CommonReq commonReq) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, commonReq) == null) {
            this.f1111common = commonReq;
        }
    }

    public void setFid(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048583, this, j) == null) {
            this.fid = j;
        }
    }

    public void setListType(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            this.list_type = str;
        }
    }

    public void setNeedTabList(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            this.need_tab_list = str;
        }
    }
}
