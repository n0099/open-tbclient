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
/* loaded from: classes6.dex */
public class g14 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a extends ResponseCallback<nz3> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j04 a;

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, exc) == null) {
            }
        }

        public a(j04 j04Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j04Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = j04Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(nz3 nz3Var, int i) {
            j04 j04Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(1048576, this, nz3Var, i) == null) && nz3Var != null && (j04Var = this.a) != null) {
                j04Var.d(nz3Var.a, nz3Var.b);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: b */
        public nz3 parseResponse(Response response, int i) {
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
                            nz3 nz3Var = new nz3();
                            nz3Var.a = optJSONObject.optString("clickid");
                            nz3Var.b = optJSONObject.optString("dstlink");
                            return nz3Var;
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                } catch (Exception | OutOfMemoryError unused) {
                }
                return null;
            }
            return (nz3) invokeLI.objValue;
        }
    }

    public static void a(d14 d14Var, AdElementInfo adElementInfo, m04 m04Var, j04 j04Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(65536, null, d14Var, adElementInfo, m04Var, j04Var) == null) && adElementInfo != null && !TextUtils.isEmpty(adElementInfo.getClickUrl())) {
            String c = c(adElementInfo.getClickUrl(), d14Var);
            a aVar = new a(j04Var);
            if (NetworkUtils.f(AppRuntime.getAppContext()) && m04Var != null) {
                m04Var.c(c, aVar);
            }
        }
    }

    public static void b(String str, m04 m04Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, str, m04Var) == null) {
            m04Var.e(str);
        }
    }

    public static void d(AdElementInfo adElementInfo, m04 m04Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65539, null, adElementInfo, m04Var) != null) || adElementInfo == null) {
            return;
        }
        for (String str : adElementInfo.getThirdClickTrackingUrls()) {
            b(c(str, null), m04Var);
        }
    }

    public static void f(AdElementInfo adElementInfo, m04 m04Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65541, null, adElementInfo, m04Var) != null) || adElementInfo == null) {
            return;
        }
        for (String str : adElementInfo.getImpressionUrls()) {
            b(c(str, null), m04Var);
        }
    }

    public static String c(String str, d14 d14Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, d14Var)) == null) {
            if (d14Var == null) {
                return str;
            }
            return str.replaceAll("\\{REQ_WIDTH\\}", d14Var.a).replaceAll("\\{REQ_HEIGHT\\}", d14Var.b).replaceAll("\\{WIDTH\\}", d14Var.c).replaceAll("\\{HEIGHT\\}", d14Var.d).replaceAll("\\{DOWN_X\\}", d14Var.e).replaceAll("\\{DOWN_Y\\}", d14Var.f).replaceAll("\\{UP_X\\}", d14Var.g).replaceAll("\\{UP_Y\\}", d14Var.h).replaceAll("\\{VIDEO_TIME\\}", d14Var.i).replaceAll("\\{BEGIN_TIME\\}", d14Var.j).replaceAll("\\{END_TIME\\}", d14Var.k).replaceAll("\\{PLAY_FIRST_FRAME\\}", d14Var.l).replaceAll("\\{PLAY_LAST_FRAME\\}", d14Var.m).replaceAll("\\{SCENE\\}", d14Var.n).replaceAll("\\{TYPE\\}", d14Var.o).replaceAll("\\{BEHAVIOR\\}", d14Var.p).replaceAll("\\{STATUS\\}", d14Var.q).replaceAll("\\{CONVERSION_ACTION\\}", d14Var.r).replaceAll("\\{CLICK_ID\\}", d14Var.s);
        }
        return (String) invokeLL.objValue;
    }

    public static void e(d14 d14Var, AdElementInfo adElementInfo, m04 m04Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, d14Var, adElementInfo, m04Var) != null) || adElementInfo == null) {
            return;
        }
        for (String str : adElementInfo.getConversionUrls()) {
            b(c(str, d14Var), m04Var);
        }
    }

    public static void g(d14 d14Var, AdElementInfo adElementInfo, m04 m04Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(65542, null, d14Var, adElementInfo, m04Var) != null) || adElementInfo == null) {
            return;
        }
        for (String str : adElementInfo.getCloseTrackers()) {
            b(c(str, d14Var), m04Var);
        }
    }
}
