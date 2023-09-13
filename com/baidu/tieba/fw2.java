package com.baidu.tieba;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import com.baidu.swan.apps.SwanAppLauncherActivity;
import com.baidu.swan.apps.favordata.SwanFavorItemData;
import com.baidu.tieba.fw2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public abstract class fw2<SelfT extends fw2<SelfT>> extends hw2<SelfT> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static final class a extends fw2<a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a i1() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this : (a) invokeV.objValue;
        }

        public a() {
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

        @Override // com.baidu.tieba.dq3
        public /* bridge */ /* synthetic */ dq3 i() {
            i1();
            return this;
        }

        @Override // com.baidu.tieba.fw2, com.baidu.tieba.kw2
        public /* bridge */ /* synthetic */ kw2 update(Bundle bundle) {
            return super.update(bundle);
        }
    }

    public fw2() {
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

    public static String d1(String str, int i, JSONObject jSONObject) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65537, null, str, i, jSONObject)) == null) {
            return e1(str, null, i, jSONObject);
        }
        return (String) invokeLIL.objValue;
    }

    public static String e1(String str, String str2, int i, JSONObject jSONObject) {
        InterceptResult invokeLLIL;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLIL = interceptable.invokeLLIL(65538, null, str, str2, i, jSONObject)) == null) {
            if (i == 1) {
                str3 = SwanFavorItemData.SCHEME_AUTHORITY_SWAN_GAME;
            } else {
                str3 = "swan";
            }
            Uri.Builder builder = new Uri.Builder();
            builder.scheme(UnitedSchemeConstants.UNITED_SCHEME).authority(str3).appendPath(str);
            if (!TextUtils.isEmpty(str2)) {
                builder.appendEncodedPath(str2);
            } else if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            if (jSONObject != null) {
                builder.appendQueryParameter("_baiduboxapp", jSONObject.toString());
            }
            builder.build();
            return builder.toString();
        }
        return (String) invokeLLIL.objValue;
    }

    public static fw2 f1(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, bundle)) == null) {
            a aVar = new a();
            aVar.update(bundle);
            return aVar;
        }
        return (fw2) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.kw2
    public SelfT update(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle)) == null) {
            k82.h(bundle);
            return (SelfT) super.update(bundle);
        }
        return (SelfT) invokeL.objValue;
    }

    public static Intent g1(Context context, fw2 fw2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, fw2Var)) == null) {
            if (context != null && fw2Var != null) {
                Intent intent = new Intent();
                intent.setAction("com.baidu.searchbox.action.aiapps.LAUNCH");
                intent.setComponent(new ComponentName(context, SwanAppLauncherActivity.class));
                if (context instanceof Application) {
                    intent.setFlags(LaunchTaskConstants.OTHER_PROCESS);
                }
                intent.putExtras(fw2Var.D());
                return intent;
            }
            return null;
        }
        return (Intent) invokeLL.objValue;
    }

    public static String h1(String str, String str2, int i) {
        InterceptResult invokeLLI;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65541, null, str, str2, i)) == null) {
            if (i == 1) {
                str3 = SwanFavorItemData.SCHEME_AUTHORITY_SWAN_GAME;
            } else {
                str3 = "swan";
            }
            Uri.Builder builder = new Uri.Builder();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("from", str2);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            builder.scheme(UnitedSchemeConstants.UNITED_SCHEME).authority(str3).appendPath(str).appendQueryParameter("_baiduboxapp", jSONObject.toString()).build();
            return builder.toString();
        }
        return (String) invokeLLI.objValue;
    }

    @Override // com.baidu.tieba.kw2
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return "SwanAppLaunchParams{appId='" + H() + "', from='" + T() + "', page='" + e0() + "', isDebug=" + n0() + ", extraData=" + P() + ", clickId='" + L() + "', launchScheme='" + W() + "', notInHistory='" + c0() + "'}";
        }
        return (String) invokeV.objValue;
    }
}
