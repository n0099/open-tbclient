package com.baidu.tieba;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.swan.game.ad.entity.AdElementInfo;
import com.baidu.swan.game.ad.utils.NetworkUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.qq.e.comm.constants.Constants;
import okhttp3.Response;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class gx3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static class a extends ResponseCallback<nv3> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jw3 a;

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, exc) == null) {
            }
        }

        public a(jw3 jw3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jw3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jw3Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(nv3 nv3Var, int i) {
            jw3 jw3Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(1048576, this, nv3Var, i) == null) && nv3Var != null && (jw3Var = this.a) != null) {
                jw3Var.d(nv3Var.a, nv3Var.b);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: b */
        public nv3 parseResponse(Response response, int i) {
            InterceptResult invokeLI;
            JSONObject optJSONObject;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, response, i)) == null) {
                if (response == null || response.body() == null || !response.isSuccessful()) {
                    return null;
                }
                try {
                    String string = response.body().string();
                    if (!TextUtils.isEmpty(string)) {
                        try {
                            JSONObject jSONObject = new JSONObject(string);
                            if (!TextUtils.equals(jSONObject.optString(Constants.KEYS.RET, ""), "0") || (optJSONObject = jSONObject.optJSONObject("data")) == null) {
                                return null;
                            }
                            nv3 nv3Var = new nv3();
                            nv3Var.a = optJSONObject.optString("clickid");
                            nv3Var.b = optJSONObject.optString("dstlink");
                            return nv3Var;
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                } catch (Exception | OutOfMemoryError unused) {
                }
                return null;
            }
            return (nv3) invokeLI.objValue;
        }
    }

    public static void a(dx3 dx3Var, AdElementInfo adElementInfo, mw3 mw3Var, jw3 jw3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(65536, null, dx3Var, adElementInfo, mw3Var, jw3Var) == null) && adElementInfo != null && !TextUtils.isEmpty(adElementInfo.getClickUrl())) {
            String c = c(adElementInfo.getClickUrl(), dx3Var);
            a aVar = new a(jw3Var);
            if (NetworkUtils.f(AppRuntime.getAppContext()) && mw3Var != null) {
                mw3Var.c(c, aVar);
            }
        }
    }

    public static void b(String str, mw3 mw3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, str, mw3Var) == null) {
            mw3Var.e(str);
        }
    }

    public static void d(AdElementInfo adElementInfo, mw3 mw3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65539, null, adElementInfo, mw3Var) != null) || adElementInfo == null) {
            return;
        }
        for (String str : adElementInfo.getThirdClickTrackingUrls()) {
            b(c(str, null), mw3Var);
        }
    }

    public static void f(AdElementInfo adElementInfo, mw3 mw3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65541, null, adElementInfo, mw3Var) != null) || adElementInfo == null) {
            return;
        }
        for (String str : adElementInfo.getImpressionUrls()) {
            b(c(str, null), mw3Var);
        }
    }

    public static String c(String str, dx3 dx3Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, dx3Var)) == null) {
            if (dx3Var == null) {
                return str;
            }
            return str.replaceAll("\\{REQ_WIDTH\\}", dx3Var.a).replaceAll("\\{REQ_HEIGHT\\}", dx3Var.b).replaceAll("\\{WIDTH\\}", dx3Var.c).replaceAll("\\{HEIGHT\\}", dx3Var.d).replaceAll("\\{DOWN_X\\}", dx3Var.e).replaceAll("\\{DOWN_Y\\}", dx3Var.f).replaceAll("\\{UP_X\\}", dx3Var.g).replaceAll("\\{UP_Y\\}", dx3Var.h).replaceAll("\\{VIDEO_TIME\\}", dx3Var.i).replaceAll("\\{BEGIN_TIME\\}", dx3Var.j).replaceAll("\\{END_TIME\\}", dx3Var.k).replaceAll("\\{PLAY_FIRST_FRAME\\}", dx3Var.l).replaceAll("\\{PLAY_LAST_FRAME\\}", dx3Var.m).replaceAll("\\{SCENE\\}", dx3Var.n).replaceAll("\\{TYPE\\}", dx3Var.o).replaceAll("\\{BEHAVIOR\\}", dx3Var.p).replaceAll("\\{STATUS\\}", dx3Var.q).replaceAll("\\{CONVERSION_ACTION\\}", dx3Var.r).replaceAll("\\{CLICK_ID\\}", dx3Var.s);
        }
        return (String) invokeLL.objValue;
    }

    public static void e(dx3 dx3Var, AdElementInfo adElementInfo, mw3 mw3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, dx3Var, adElementInfo, mw3Var) != null) || adElementInfo == null) {
            return;
        }
        for (String str : adElementInfo.getConversionUrls()) {
            b(c(str, dx3Var), mw3Var);
        }
    }

    public static void g(dx3 dx3Var, AdElementInfo adElementInfo, mw3 mw3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(65542, null, dx3Var, adElementInfo, mw3Var) != null) || adElementInfo == null) {
            return;
        }
        for (String str : adElementInfo.getCloseTrackers()) {
            b(c(str, dx3Var), mw3Var);
        }
    }
}
