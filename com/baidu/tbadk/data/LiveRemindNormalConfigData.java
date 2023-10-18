package com.baidu.tbadk.data;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import tbclient.Loop.NormalConfig;
/* loaded from: classes5.dex */
public class LiveRemindNormalConfigData implements Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = -2274700879523295481L;
    public transient /* synthetic */ FieldHolder $fh;
    public String normalIconScheme;
    public String normalIconUrl;

    public LiveRemindNormalConfigData() {
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

    public String getNormalIconScheme() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.normalIconScheme;
        }
        return (String) invokeV.objValue;
    }

    public String getNormalIconUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.normalIconUrl;
        }
        return (String) invokeV.objValue;
    }

    public void parserProtobuf(NormalConfig normalConfig) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, normalConfig) != null) || normalConfig == null) {
            return;
        }
        this.normalIconUrl = normalConfig.icon_url;
        this.normalIconScheme = normalConfig.icon_scheme;
    }

    public void setNormalIconScheme(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.normalIconScheme = str;
        }
    }

    public void setNormalIconUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.normalIconUrl = str;
        }
    }
}
