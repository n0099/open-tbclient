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
public class hy3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static class a extends ResponseCallback<ow3> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kx3 a;

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, exc) == null) {
            }
        }

        public a(kx3 kx3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kx3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kx3Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(ow3 ow3Var, int i) {
            kx3 kx3Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(1048576, this, ow3Var, i) == null) && ow3Var != null && (kx3Var = this.a) != null) {
                kx3Var.d(ow3Var.a, ow3Var.b);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: b */
        public ow3 parseResponse(Response response, int i) {
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
                            ow3 ow3Var = new ow3();
                            ow3Var.a = optJSONObject.optString("clickid");
                            ow3Var.b = optJSONObject.optString("dstlink");
                            return ow3Var;
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                } catch (Exception | OutOfMemoryError unused) {
                }
                return null;
            }
            return (ow3) invokeLI.objValue;
        }
    }

    public static void a(ey3 ey3Var, AdElementInfo adElementInfo, nx3 nx3Var, kx3 kx3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(65536, null, ey3Var, adElementInfo, nx3Var, kx3Var) == null) && adElementInfo != null && !TextUtils.isEmpty(adElementInfo.getClickUrl())) {
            String c = c(adElementInfo.getClickUrl(), ey3Var);
            a aVar = new a(kx3Var);
            if (NetworkUtils.f(AppRuntime.getAppContext()) && nx3Var != null) {
                nx3Var.c(c, aVar);
            }
        }
    }

    public static void b(String str, nx3 nx3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, str, nx3Var) == null) {
            nx3Var.e(str);
        }
    }

    public static void d(AdElementInfo adElementInfo, nx3 nx3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65539, null, adElementInfo, nx3Var) != null) || adElementInfo == null) {
            return;
        }
        for (String str : adElementInfo.getThirdClickTrackingUrls()) {
            b(c(str, null), nx3Var);
        }
    }

    public static void f(AdElementInfo adElementInfo, nx3 nx3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65541, null, adElementInfo, nx3Var) != null) || adElementInfo == null) {
            return;
        }
        for (String str : adElementInfo.getImpressionUrls()) {
            b(c(str, null), nx3Var);
        }
    }

    public static String c(String str, ey3 ey3Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, ey3Var)) == null) {
            if (ey3Var == null) {
                return str;
            }
            return str.replaceAll("\\{REQ_WIDTH\\}", ey3Var.a).replaceAll("\\{REQ_HEIGHT\\}", ey3Var.b).replaceAll("\\{WIDTH\\}", ey3Var.c).replaceAll("\\{HEIGHT\\}", ey3Var.d).replaceAll("\\{DOWN_X\\}", ey3Var.e).replaceAll("\\{DOWN_Y\\}", ey3Var.f).replaceAll("\\{UP_X\\}", ey3Var.g).replaceAll("\\{UP_Y\\}", ey3Var.h).replaceAll("\\{VIDEO_TIME\\}", ey3Var.i).replaceAll("\\{BEGIN_TIME\\}", ey3Var.j).replaceAll("\\{END_TIME\\}", ey3Var.k).replaceAll("\\{PLAY_FIRST_FRAME\\}", ey3Var.l).replaceAll("\\{PLAY_LAST_FRAME\\}", ey3Var.m).replaceAll("\\{SCENE\\}", ey3Var.n).replaceAll("\\{TYPE\\}", ey3Var.o).replaceAll("\\{BEHAVIOR\\}", ey3Var.p).replaceAll("\\{STATUS\\}", ey3Var.q).replaceAll("\\{CONVERSION_ACTION\\}", ey3Var.r).replaceAll("\\{CLICK_ID\\}", ey3Var.s);
        }
        return (String) invokeLL.objValue;
    }

    public static void e(ey3 ey3Var, AdElementInfo adElementInfo, nx3 nx3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, ey3Var, adElementInfo, nx3Var) != null) || adElementInfo == null) {
            return;
        }
        for (String str : adElementInfo.getConversionUrls()) {
            b(c(str, ey3Var), nx3Var);
        }
    }

    public static void g(ey3 ey3Var, AdElementInfo adElementInfo, nx3 nx3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(65542, null, ey3Var, adElementInfo, nx3Var) != null) || adElementInfo == null) {
            return;
        }
        for (String str : adElementInfo.getCloseTrackers()) {
            b(c(str, ey3Var), nx3Var);
        }
    }
}
