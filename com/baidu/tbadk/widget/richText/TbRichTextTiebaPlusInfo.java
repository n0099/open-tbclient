package com.baidu.tbadk.widget.richText;

import androidx.core.view.InputDeviceCompat;
import c.a.q0.s.q.d2;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
import tbclient.TiebaPlusInfo;
/* loaded from: classes6.dex */
public class TbRichTextTiebaPlusInfo extends OrmObject {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final TiebaPlusInfo f48988e;

    /* renamed from: f  reason: collision with root package name */
    public final int f48989f;

    /* renamed from: g  reason: collision with root package name */
    public String f48990g;

    /* renamed from: h  reason: collision with root package name */
    public String f48991h;

    /* renamed from: i  reason: collision with root package name */
    public d2 f48992i;

    public TbRichTextTiebaPlusInfo(int i2, TiebaPlusInfo tiebaPlusInfo) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), tiebaPlusInfo};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f48988e = tiebaPlusInfo;
        this.f48989f = i2;
    }

    public void A(d2 d2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, d2Var) == null) {
            this.f48992i = d2Var;
        }
    }

    public String getForumId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f48991h : (String) invokeV.objValue;
    }

    public int getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f48989f : invokeV.intValue;
    }

    public void setForumId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.f48991h = str;
        }
    }

    public void setTid(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.f48990g = str;
        }
    }

    public String w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            d2 d2Var = this.f48992i;
            return d2Var == null ? "0" : String.valueOf(d2Var.R());
        }
        return (String) invokeV.objValue;
    }

    public d2 x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f48992i : (d2) invokeV.objValue;
    }

    public String y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f48990g : (String) invokeV.objValue;
    }

    public TiebaPlusInfo z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f48988e : (TiebaPlusInfo) invokeV.objValue;
    }

    public TbRichTextTiebaPlusInfo(int i2, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), jSONObject};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f48989f = i2;
        TiebaPlusInfo.Builder builder = new TiebaPlusInfo.Builder();
        builder.app_company = jSONObject.optString("app_company");
        builder.title = jSONObject.optString("title");
        builder.desc = jSONObject.optString("desc");
        builder.jump_url = jSONObject.optString("jump_url");
        builder.download_url = jSONObject.optString("download_url");
        builder.app_id = jSONObject.optString("app_id");
        builder.app_icon = jSONObject.optString("app_icon");
        builder.app_package = jSONObject.optString("app_package");
        builder.app_version = jSONObject.optString("app_version");
        builder.app_privacy = jSONObject.optString("app_privacy");
        builder.app_power = jSONObject.optString("app_power");
        builder.h5_jump_type = Integer.valueOf(jSONObject.optInt("h5_jump_type"));
        this.f48988e = builder.build(true);
    }
}
