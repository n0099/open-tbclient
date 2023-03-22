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
public class ex3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static class a extends ResponseCallback<lv3> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hw3 a;

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, exc) == null) {
            }
        }

        public a(hw3 hw3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hw3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hw3Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(lv3 lv3Var, int i) {
            hw3 hw3Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(1048576, this, lv3Var, i) == null) && lv3Var != null && (hw3Var = this.a) != null) {
                hw3Var.d(lv3Var.a, lv3Var.b);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: b */
        public lv3 parseResponse(Response response, int i) {
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
                            lv3 lv3Var = new lv3();
                            lv3Var.a = optJSONObject.optString("clickid");
                            lv3Var.b = optJSONObject.optString("dstlink");
                            return lv3Var;
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                } catch (Exception | OutOfMemoryError unused) {
                }
                return null;
            }
            return (lv3) invokeLI.objValue;
        }
    }

    public static void a(bx3 bx3Var, AdElementInfo adElementInfo, kw3 kw3Var, hw3 hw3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(65536, null, bx3Var, adElementInfo, kw3Var, hw3Var) == null) && adElementInfo != null && !TextUtils.isEmpty(adElementInfo.getClickUrl())) {
            String c = c(adElementInfo.getClickUrl(), bx3Var);
            a aVar = new a(hw3Var);
            if (NetworkUtils.f(AppRuntime.getAppContext()) && kw3Var != null) {
                kw3Var.c(c, aVar);
            }
        }
    }

    public static void b(String str, kw3 kw3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, str, kw3Var) == null) {
            kw3Var.e(str);
        }
    }

    public static void d(AdElementInfo adElementInfo, kw3 kw3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65539, null, adElementInfo, kw3Var) != null) || adElementInfo == null) {
            return;
        }
        for (String str : adElementInfo.getThirdClickTrackingUrls()) {
            b(c(str, null), kw3Var);
        }
    }

    public static void f(AdElementInfo adElementInfo, kw3 kw3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65541, null, adElementInfo, kw3Var) != null) || adElementInfo == null) {
            return;
        }
        for (String str : adElementInfo.getImpressionUrls()) {
            b(c(str, null), kw3Var);
        }
    }

    public static String c(String str, bx3 bx3Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, bx3Var)) == null) {
            if (bx3Var == null) {
                return str;
            }
            return str.replaceAll("\\{REQ_WIDTH\\}", bx3Var.a).replaceAll("\\{REQ_HEIGHT\\}", bx3Var.b).replaceAll("\\{WIDTH\\}", bx3Var.c).replaceAll("\\{HEIGHT\\}", bx3Var.d).replaceAll("\\{DOWN_X\\}", bx3Var.e).replaceAll("\\{DOWN_Y\\}", bx3Var.f).replaceAll("\\{UP_X\\}", bx3Var.g).replaceAll("\\{UP_Y\\}", bx3Var.h).replaceAll("\\{VIDEO_TIME\\}", bx3Var.i).replaceAll("\\{BEGIN_TIME\\}", bx3Var.j).replaceAll("\\{END_TIME\\}", bx3Var.k).replaceAll("\\{PLAY_FIRST_FRAME\\}", bx3Var.l).replaceAll("\\{PLAY_LAST_FRAME\\}", bx3Var.m).replaceAll("\\{SCENE\\}", bx3Var.n).replaceAll("\\{TYPE\\}", bx3Var.o).replaceAll("\\{BEHAVIOR\\}", bx3Var.p).replaceAll("\\{STATUS\\}", bx3Var.q).replaceAll("\\{CONVERSION_ACTION\\}", bx3Var.r).replaceAll("\\{CLICK_ID\\}", bx3Var.s);
        }
        return (String) invokeLL.objValue;
    }

    public static void e(bx3 bx3Var, AdElementInfo adElementInfo, kw3 kw3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, bx3Var, adElementInfo, kw3Var) != null) || adElementInfo == null) {
            return;
        }
        for (String str : adElementInfo.getConversionUrls()) {
            b(c(str, bx3Var), kw3Var);
        }
    }

    public static void g(bx3 bx3Var, AdElementInfo adElementInfo, kw3 kw3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(65542, null, bx3Var, adElementInfo, kw3Var) != null) || adElementInfo == null) {
            return;
        }
        for (String str : adElementInfo.getCloseTrackers()) {
            b(c(str, bx3Var), kw3Var);
        }
    }
}
