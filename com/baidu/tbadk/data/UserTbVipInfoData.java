package com.baidu.tbadk.data;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import org.json.JSONObject;
import tbclient.TbVipInfo;
/* loaded from: classes4.dex */
public class UserTbVipInfoData implements Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = 1112312312312L;
    public transient /* synthetic */ FieldHolder $fh;
    public String vipIntro;
    public String vipV_detail;
    public String vipV_url;

    public UserTbVipInfoData() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public String getvipIntro() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.vipIntro : (String) invokeV.objValue;
    }

    public String getvipV_detail() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.vipV_detail : (String) invokeV.objValue;
    }

    public String getvipV_url() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.vipV_url : (String) invokeV.objValue;
    }

    public void parseJson(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        this.vipIntro = jSONObject.optString("intro", "");
        this.vipV_url = jSONObject.optString("v_url", "");
        this.vipV_detail = jSONObject.optString("v_detail", "");
    }

    public void parserProtobuf(TbVipInfo tbVipInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, tbVipInfo) == null) || tbVipInfo == null) {
            return;
        }
        this.vipIntro = tbVipInfo.intro;
        this.vipV_url = tbVipInfo.v_url;
        this.vipV_detail = tbVipInfo.v_detail;
    }

    public void setVipIntro(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.vipIntro = str;
        }
    }

    public void setVipV_detail(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.vipV_detail = str;
        }
    }

    public void setVipV_url(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.vipV_url = str;
        }
    }
}
