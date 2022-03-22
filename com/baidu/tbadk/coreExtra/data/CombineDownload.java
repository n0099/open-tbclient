package com.baidu.tbadk.coreExtra.data;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class CombineDownload implements Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int SHOW_COMBINE_DOWNLOAD = 1;
    public static final long serialVersionUID = -8311384562580282599L;
    public transient /* synthetic */ FieldHolder $fh;
    public String apkMD5RSA;
    public String appProc;
    public String appUrl;
    public String appdesc;
    public int isShow;

    public CombineDownload() {
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

    public String getApkMD5RSA() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.apkMD5RSA : (String) invokeV.objValue;
    }

    public String getAppName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.appdesc : (String) invokeV.objValue;
    }

    public String getAppProc() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.appProc : (String) invokeV.objValue;
    }

    public String getAppUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.appUrl : (String) invokeV.objValue;
    }

    public void parserJson(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        this.appdesc = jSONObject.optString("app_name");
        this.appUrl = jSONObject.optString("app_url");
        this.appProc = jSONObject.optString("app_proc");
        this.isShow = jSONObject.optInt("is_show");
        this.apkMD5RSA = jSONObject.optString("apk_MD5_RSA");
    }

    public boolean showCombineDownload() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.isShow == 1 : invokeV.booleanValue;
    }
}
