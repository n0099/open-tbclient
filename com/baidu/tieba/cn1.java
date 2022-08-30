package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.bddownload.core.breakpoint.sqlite.BreakpointSQLiteKey;
import com.baidu.spswitch.emotion.resource.EmotionResourceInfo;
import com.baidu.tbadk.core.util.httpNet.HttpRequest;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public final class cn1 extends dm2<cn1> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public interface a {
        public static final String a = dm2.r("SwanApkFetcher.Params", "title");
        public static final String b = dm2.r("SwanApkFetcher.Params", EmotionResourceInfo.JSON_KEY_PKG_NAME);
        public static final String c = dm2.r("SwanApkFetcher.Params", "description");
        public static final String d = dm2.r("SwanApkFetcher.Params", "should_auto_install");
        public static final String e = dm2.r("SwanApkFetcher.Params", "current_swan_app");
        public static final String f = dm2.r("SwanApkFetcher.Params", "content_disposition");
        public static final String g = dm2.r("SwanApkFetcher.Params", "mime_type");
        public static final String h = dm2.r("SwanApkFetcher.Params", HttpRequest.USER_AGENT);
        public static final String i = dm2.r("SwanApkFetcher.Params", BreakpointSQLiteKey.CONTENT_LENGTH);
        public static final String j = dm2.r("SwanApkFetcher.Params", "ext_info");
    }

    public cn1() {
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

    public cn1 E(Boolean bool) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bool)) == null) ? t(a.d, bool.booleanValue()) : (cn1) invokeL.objValue;
    }

    public cn1 F(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) ? z(a.f, str) : (cn1) invokeL.objValue;
    }

    public cn1 G(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) ? z(a.i, str) : (cn1) invokeL.objValue;
    }

    public cn1 H(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) ? z(a.e, str) : (cn1) invokeL.objValue;
    }

    public cn1 I(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) ? z(a.c, str) : (cn1) invokeL.objValue;
    }

    public cn1 J(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) ? z(a.j, str) : (cn1) invokeL.objValue;
    }

    public cn1 K(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) ? z(a.g, str) : (cn1) invokeL.objValue;
    }

    public cn1 L(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) ? z(a.b, str) : (cn1) invokeL.objValue;
    }

    public cn1 M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this : (cn1) invokeV.objValue;
    }

    public cn1 N(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) ? z(a.a, str) : (cn1) invokeL.objValue;
    }

    public cn1 O(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) ? z(a.h, str) : (cn1) invokeL.objValue;
    }

    @Override // com.baidu.tieba.wf3
    public /* bridge */ /* synthetic */ wf3 a() {
        M();
        return this;
    }
}
