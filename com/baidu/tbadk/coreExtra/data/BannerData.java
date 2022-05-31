package com.baidu.tbadk.coreExtra.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.en4;
import java.io.Serializable;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class BannerData extends en4 implements Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = -7774063518930689243L;
    public transient /* synthetic */ FieldHolder $fh;
    public int mOpen;
    public String mResultUrl;
    public String mUrl;

    public BannerData() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mOpen = 0;
        this.mUrl = null;
        this.mResultUrl = null;
    }

    public int getOpen() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mOpen : invokeV.intValue;
    }

    public String getResultUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mResultUrl : (String) invokeV.objValue;
    }

    public String getUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mUrl : (String) invokeV.objValue;
    }

    @Override // com.repackage.en4
    public void parserJson(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        try {
            this.mOpen = jSONObject.optInt("open", 0);
            this.mUrl = jSONObject.optString("message_url", null);
            this.mResultUrl = jSONObject.optString("dest_url", null);
        } catch (Exception e) {
            BdLog.detailException(e);
        }
    }
}
