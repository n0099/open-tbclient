package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.annotation.Singleton;
import com.baidu.searchbox.pms.IPmsContext;
import com.baidu.searchbox.pms.init.RequestParams;
import com.baidu.searchbox.pms.statistic.StatisticCallback;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Collections;
import java.util.List;
@Singleton
@Service
/* loaded from: classes5.dex */
public class dm implements IPmsContext {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.searchbox.pms.IPmsContext
    public boolean checkChannelAllow(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, str2)) == null) {
            return true;
        }
        return invokeLL.booleanValue;
    }

    @Override // com.baidu.searchbox.pms.IPmsContext
    public List<String> getAutoClearChannelIdList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return null;
        }
        return (List) invokeV.objValue;
    }

    public dm() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.baidu.searchbox.pms.IPmsContext
    public List<RequestParams.Channel> getLongConnectParams() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return Collections.emptyList();
        }
        return (List) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.pms.IPmsContext
    public StatisticCallback getStatisticCallback() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return new fm();
        }
        return (StatisticCallback) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.pms.IPmsContext
    public RequestParams getRegisterParams(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            return getRegisterParams(str, "aps");
        }
        return (RequestParams) invokeL.objValue;
    }

    @Override // com.baidu.searchbox.pms.IPmsContext
    public RequestParams getRegisterParams(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, str2)) == null) {
            RequestParams requestParams = new RequestParams();
            requestParams.setRunType(str);
            if (TextUtils.isEmpty(str2)) {
                str2 = "aps";
            }
            requestParams.setRunNode(str2);
            if ("0".equals(str)) {
                requestParams.addChannel(ol.f().d());
                requestParams.addChannel(new an());
                requestParams.addChannel(new lm());
            }
            return requestParams;
        }
        return (RequestParams) invokeLL.objValue;
    }
}
