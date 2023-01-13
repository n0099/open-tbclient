package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.chatmessage.messages.NetDiskFileMsg;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.model.AdBaseModel;
import com.baidu.nadcore.model.AdOperator;
import com.baidu.swan.game.guide.GameGuideConfigInfo;
import com.baidu.tbadk.core.atomData.RecommendDetailActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class gq0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public String c;
    public String d;
    public final String e;
    public final int f;
    public String g;
    public String h;
    public final String i;
    public String j;
    public String k;
    public String l;
    public pp0 m;
    public String n;
    public boolean o;
    public boolean p;
    public boolean q;
    public String r;
    public String s;
    public String t;

    public gq0(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jSONObject};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.o = true;
        this.q = false;
        jSONObject.optString("style");
        this.a = jSONObject.optString("user_name");
        this.b = jSONObject.optString(RecommendDetailActivityConfig.USER_PORTRAIT);
        this.c = jSONObject.optString("scheme");
        this.d = jSONObject.optString("button_scheme");
        this.e = jSONObject.optString(GameGuideConfigInfo.KEY_BUTTON_TEXT);
        this.f = jSONObject.optInt("duration") * 1000;
        this.g = jSONObject.optString("trade");
        jSONObject.optString("score");
        this.h = jSONObject.optString("title");
        jSONObject.optString("sub_title");
        this.i = jSONObject.optString("popularity_text");
        this.j = jSONObject.optString(NetDiskFileMsg.NetDiskFile.JSON_KEY_COVER_URL);
        this.s = jSONObject.optString("bottom_button_text");
        this.r = jSONObject.optString("bottom_button_icon");
        this.t = jSONObject.optString("bottom_button_scheme");
    }

    @Nullable
    public static gq0 a(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            return new gq0(jSONObject);
        }
        return (gq0) invokeL.objValue;
    }

    public gq0 b(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            this.d = k31.a(this.d, str, "__BTN_SCHEME__");
            return this;
        }
        return (gq0) invokeL.objValue;
    }

    public gq0 c(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            this.j = str;
            return this;
        }
        return (gq0) invokeL.objValue;
    }

    public gq0 e(@NonNull pp0 pp0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, pp0Var)) == null) {
            this.m = pp0Var;
            return this;
        }
        return (gq0) invokeL.objValue;
    }

    public gq0 f(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            this.l = str;
            return this;
        }
        return (gq0) invokeL.objValue;
    }

    public gq0 g(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            this.c = k31.a(this.c, str, "__SCHEME__");
            return this;
        }
        return (gq0) invokeL.objValue;
    }

    public void d(@NonNull AdBaseModel adBaseModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, adBaseModel) == null) {
            eq0 eq0Var = adBaseModel.j;
            if (eq0Var != null && !TextUtils.isEmpty(eq0Var.c)) {
                c(adBaseModel.j.c);
            }
            if (!TextUtils.isEmpty(adBaseModel.f.d)) {
                f(adBaseModel.f.d);
            }
            pp0 pp0Var = adBaseModel.l;
            if (pp0Var != null) {
                e(pp0Var);
            }
            if (!TextUtils.isEmpty(adBaseModel.f.c)) {
                g(adBaseModel.f.c);
            }
            AdOperator adOperator = adBaseModel.h;
            if (adOperator != null && !TextUtils.isEmpty(adOperator.d)) {
                b(adBaseModel.h.d);
            }
            if (adBaseModel.f != null) {
                if (TextUtils.isEmpty(this.h)) {
                    this.h = adBaseModel.f.g;
                }
                if (TextUtils.isEmpty(this.g)) {
                    this.g = adBaseModel.f.h;
                }
            }
        }
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            pp0 pp0Var = this.m;
            if (pp0Var != null && pp0Var.e) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (!h() && TextUtils.isEmpty(this.c)) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }
}
