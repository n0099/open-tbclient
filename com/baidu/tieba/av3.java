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
import okhttp3.Response;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class av3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class a extends ResponseCallback<ht3> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ du3 a;

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, exc) == null) {
            }
        }

        public a(du3 du3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {du3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = du3Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(ht3 ht3Var, int i) {
            du3 du3Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(1048576, this, ht3Var, i) == null) && ht3Var != null && (du3Var = this.a) != null) {
                du3Var.d(ht3Var.a, ht3Var.b);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: b */
        public ht3 parseResponse(Response response, int i) {
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
                            if (!TextUtils.equals(jSONObject.optString("ret", ""), "0") || (optJSONObject = jSONObject.optJSONObject("data")) == null) {
                                return null;
                            }
                            ht3 ht3Var = new ht3();
                            ht3Var.a = optJSONObject.optString("clickid");
                            ht3Var.b = optJSONObject.optString("dstlink");
                            return ht3Var;
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                } catch (Exception | OutOfMemoryError unused) {
                }
                return null;
            }
            return (ht3) invokeLI.objValue;
        }
    }

    public static void a(xu3 xu3Var, AdElementInfo adElementInfo, gu3 gu3Var, du3 du3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(65536, null, xu3Var, adElementInfo, gu3Var, du3Var) == null) && adElementInfo != null && !TextUtils.isEmpty(adElementInfo.getClickUrl())) {
            String c = c(adElementInfo.getClickUrl(), xu3Var);
            a aVar = new a(du3Var);
            if (NetworkUtils.f(AppRuntime.getAppContext()) && gu3Var != null) {
                gu3Var.c(c, aVar);
            }
        }
    }

    public static void b(String str, gu3 gu3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, str, gu3Var) == null) {
            gu3Var.e(str);
        }
    }

    public static void d(AdElementInfo adElementInfo, gu3 gu3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65539, null, adElementInfo, gu3Var) != null) || adElementInfo == null) {
            return;
        }
        for (String str : adElementInfo.getThirdClickTrackingUrls()) {
            b(c(str, null), gu3Var);
        }
    }

    public static void f(AdElementInfo adElementInfo, gu3 gu3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65541, null, adElementInfo, gu3Var) != null) || adElementInfo == null) {
            return;
        }
        for (String str : adElementInfo.getImpressionUrls()) {
            b(c(str, null), gu3Var);
        }
    }

    public static String c(String str, xu3 xu3Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, xu3Var)) == null) {
            if (xu3Var == null) {
                return str;
            }
            return str.replaceAll("\\{REQ_WIDTH\\}", xu3Var.a).replaceAll("\\{REQ_HEIGHT\\}", xu3Var.b).replaceAll("\\{WIDTH\\}", xu3Var.c).replaceAll("\\{HEIGHT\\}", xu3Var.d).replaceAll("\\{DOWN_X\\}", xu3Var.e).replaceAll("\\{DOWN_Y\\}", xu3Var.f).replaceAll("\\{UP_X\\}", xu3Var.g).replaceAll("\\{UP_Y\\}", xu3Var.h).replaceAll("\\{VIDEO_TIME\\}", xu3Var.i).replaceAll("\\{BEGIN_TIME\\}", xu3Var.j).replaceAll("\\{END_TIME\\}", xu3Var.k).replaceAll("\\{PLAY_FIRST_FRAME\\}", xu3Var.l).replaceAll("\\{PLAY_LAST_FRAME\\}", xu3Var.m).replaceAll("\\{SCENE\\}", xu3Var.n).replaceAll("\\{TYPE\\}", xu3Var.o).replaceAll("\\{BEHAVIOR\\}", xu3Var.p).replaceAll("\\{STATUS\\}", xu3Var.q).replaceAll("\\{CONVERSION_ACTION\\}", xu3Var.r).replaceAll("\\{CLICK_ID\\}", xu3Var.s);
        }
        return (String) invokeLL.objValue;
    }

    public static void e(xu3 xu3Var, AdElementInfo adElementInfo, gu3 gu3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, xu3Var, adElementInfo, gu3Var) != null) || adElementInfo == null) {
            return;
        }
        for (String str : adElementInfo.getConversionUrls()) {
            b(c(str, xu3Var), gu3Var);
        }
    }

    public static void g(xu3 xu3Var, AdElementInfo adElementInfo, gu3 gu3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(65542, null, xu3Var, adElementInfo, gu3Var) != null) || adElementInfo == null) {
            return;
        }
        for (String str : adElementInfo.getCloseTrackers()) {
            b(c(str, xu3Var), gu3Var);
        }
    }
}
