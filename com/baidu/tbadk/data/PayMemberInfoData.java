package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.gslbsdk.db.ResultTB;
import org.json.JSONObject;
import tbclient.PayMemberInfo;
/* loaded from: classes3.dex */
public class PayMemberInfoData extends OrmObject {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f13012e;

    /* renamed from: f  reason: collision with root package name */
    public int f13013f;

    /* renamed from: g  reason: collision with root package name */
    public String f13014g;

    /* renamed from: h  reason: collision with root package name */
    public String f13015h;

    public PayMemberInfoData() {
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

    public void A(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            this.f13015h = str;
        }
    }

    public String getUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f13014g : (String) invokeV.objValue;
    }

    public void parseJson(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        this.f13012e = jSONObject.optInt("props_id");
        this.f13013f = jSONObject.optInt(ResultTB.ENDTIME, 0);
        this.f13014g = jSONObject.optString(this.f13014g, "");
        this.f13015h = jSONObject.optString("expire_remind");
    }

    public int w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f13013f : invokeV.intValue;
    }

    public String x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f13015h : (String) invokeV.objValue;
    }

    public int y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f13012e : invokeV.intValue;
    }

    public void z(PayMemberInfo payMemberInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, payMemberInfo) == null) || payMemberInfo == null) {
            return;
        }
        Integer num = payMemberInfo.props_id;
        if (num != null) {
            this.f13012e = num.intValue();
        }
        Integer num2 = payMemberInfo.end_time;
        if (num2 != null) {
            this.f13013f = num2.intValue();
        }
        this.f13014g = payMemberInfo.url;
        this.f13015h = payMemberInfo.expire_remind;
    }
}
