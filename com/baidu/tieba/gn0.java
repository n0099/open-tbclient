package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.ao0;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public final class gn0 extends kn0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final JSONObject A;
    public final JSONObject B;
    public final on0 C;
    public final xn0 D;
    public final co0 E;
    public final fn0 F;
    public final JSONObject G;
    public final en0 H;
    public final ao0 r;
    public final rn0 s;
    public final pn0 t;
    public final boolean u;
    public final boolean v;
    public final boolean w;
    public final String x;
    public final String y;
    public final yn0 z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public gn0(an0 common2, JSONObject root) {
        super(common2, root, true);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {common2, root};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((an0) objArr2[0], (JSONObject) objArr2[1], ((Boolean) objArr2[2]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(common2, "common");
        Intrinsics.checkNotNullParameter(root, "root");
        boolean z = true;
        ao0.a aVar = ao0.A;
        JSONObject optJSONObject = root.optJSONObject("reward");
        this.r = aVar.a(optJSONObject == null ? new JSONObject() : optJSONObject);
        this.s = rn0.g.a(root.optJSONObject("image_info"));
        this.t = pn0.v.a(root.optJSONObject("cmd_policy"));
        this.u = Intrinsics.areEqual(root.optString("type"), "detail");
        this.v = Intrinsics.areEqual(root.optString("type"), "download");
        rn0 rn0Var = this.s;
        this.w = (rn0Var == null || !rn0Var.d()) ? false : false;
        String optString = root.optString("panel_cmd");
        Intrinsics.checkNotNullExpressionValue(optString, "root.optString(\"panel_cmd\")");
        this.x = optString;
        String optString2 = root.optString("webpanel_cmd");
        Intrinsics.checkNotNullExpressionValue(optString2, "root.optString(\"webpanel_cmd\")");
        this.y = optString2;
        Intrinsics.checkNotNullExpressionValue(root.optString("lp_real_url"), "root.optString(\"lp_real_url\")");
        this.z = yn0.i.a(root.optJSONObject("sliding_tag"));
        this.A = root.optJSONObject("sv_title");
        this.B = root.optJSONObject("sv_button");
        this.C = on0.i.a(root.optJSONObject("big_card"));
        this.D = xn0.w.a(root.optJSONObject("rotation_component"));
        this.E = new co0(false, false, 0, false, false, false, 63, null);
        this.F = fn0.d.a(root.optJSONObject("ad_tag"));
        JSONObject optJSONObject2 = root.optJSONObject("popover");
        this.G = optJSONObject2;
        this.H = en0.b.a(optJSONObject2);
        root.optJSONObject("convert");
    }

    public final on0 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.C;
        }
        return (on0) invokeV.objValue;
    }

    public final pn0 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.t;
        }
        return (pn0) invokeV.objValue;
    }

    public final xn0 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.D;
        }
        return (xn0) invokeV.objValue;
    }

    public final rn0 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.s;
        }
        return (rn0) invokeV.objValue;
    }

    public final String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.x;
        }
        return (String) invokeV.objValue;
    }

    public final ao0 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.r;
        }
        return (ao0) invokeV.objValue;
    }

    public final en0 h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.H;
        }
        return (en0) invokeV.objValue;
    }

    public final co0 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.E;
        }
        return (co0) invokeV.objValue;
    }

    public final yn0 j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.z;
        }
        return (yn0) invokeV.objValue;
    }

    public final JSONObject k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.B;
        }
        return (JSONObject) invokeV.objValue;
    }

    public final JSONObject l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.A;
        }
        return (JSONObject) invokeV.objValue;
    }

    public final fn0 m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.F;
        }
        return (fn0) invokeV.objValue;
    }

    public final String n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.y;
        }
        return (String) invokeV.objValue;
    }

    public final boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.u;
        }
        return invokeV.booleanValue;
    }

    public final boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.v;
        }
        return invokeV.booleanValue;
    }

    public final boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.w;
        }
        return invokeV.booleanValue;
    }
}
