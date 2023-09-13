package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.mvc.data.INetRequestData;
import com.baidu.tbadk.util.NetMessageHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import tbclient.ItemManage.DataReq;
import tbclient.ItemManage.ItemManageReqIdl;
/* loaded from: classes5.dex */
public class az6 implements INetRequestData {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public final int b;

    @Override // com.baidu.tbadk.mvc.data.IHttpParamRequestData
    public HashMap<String, String> getHttpHeader() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return null;
        }
        return (HashMap) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.mvc.data.IHttpParamRequestData
    public HashMap<String, Object> makeHttpParam() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return null;
        }
        return (HashMap) invokeV.objValue;
    }

    public az6(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = i;
        this.b = i2;
    }

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.a;
        }
        return invokeV.intValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.a = 1;
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.a++;
        }
    }

    @Override // com.baidu.tbadk.mvc.data.ISocketProtobufRequestData
    public Object encodeSocketRequestData(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048579, this, z)) == null) {
            DataReq.Builder builder = new DataReq.Builder();
            builder.pn = Integer.valueOf(this.a);
            builder.rn = 15;
            builder.tab_id = Integer.valueOf(this.b);
            ItemManageReqIdl.Builder builder2 = new ItemManageReqIdl.Builder();
            DataReq build = builder.build(false);
            builder2.data = build;
            NetMessageHelper.bindCommonParamsToProtobufData(build, false);
            return builder2.build(false);
        }
        return invokeZ.objValue;
    }
}
