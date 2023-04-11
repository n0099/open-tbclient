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
public class fx3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static class a extends ResponseCallback<mv3> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ iw3 a;

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, exc) == null) {
            }
        }

        public a(iw3 iw3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iw3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = iw3Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(mv3 mv3Var, int i) {
            iw3 iw3Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(1048576, this, mv3Var, i) == null) && mv3Var != null && (iw3Var = this.a) != null) {
                iw3Var.d(mv3Var.a, mv3Var.b);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: b */
        public mv3 parseResponse(Response response, int i) {
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
                            mv3 mv3Var = new mv3();
                            mv3Var.a = optJSONObject.optString("clickid");
                            mv3Var.b = optJSONObject.optString("dstlink");
                            return mv3Var;
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                } catch (Exception | OutOfMemoryError unused) {
                }
                return null;
            }
            return (mv3) invokeLI.objValue;
        }
    }

    public static void a(cx3 cx3Var, AdElementInfo adElementInfo, lw3 lw3Var, iw3 iw3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(65536, null, cx3Var, adElementInfo, lw3Var, iw3Var) == null) && adElementInfo != null && !TextUtils.isEmpty(adElementInfo.getClickUrl())) {
            String c = c(adElementInfo.getClickUrl(), cx3Var);
            a aVar = new a(iw3Var);
            if (NetworkUtils.f(AppRuntime.getAppContext()) && lw3Var != null) {
                lw3Var.c(c, aVar);
            }
        }
    }

    public static void b(String str, lw3 lw3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, str, lw3Var) == null) {
            lw3Var.e(str);
        }
    }

    public static void d(AdElementInfo adElementInfo, lw3 lw3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65539, null, adElementInfo, lw3Var) != null) || adElementInfo == null) {
            return;
        }
        for (String str : adElementInfo.getThirdClickTrackingUrls()) {
            b(c(str, null), lw3Var);
        }
    }

    public static void f(AdElementInfo adElementInfo, lw3 lw3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65541, null, adElementInfo, lw3Var) != null) || adElementInfo == null) {
            return;
        }
        for (String str : adElementInfo.getImpressionUrls()) {
            b(c(str, null), lw3Var);
        }
    }

    public static String c(String str, cx3 cx3Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, cx3Var)) == null) {
            if (cx3Var == null) {
                return str;
            }
            return str.replaceAll("\\{REQ_WIDTH\\}", cx3Var.a).replaceAll("\\{REQ_HEIGHT\\}", cx3Var.b).replaceAll("\\{WIDTH\\}", cx3Var.c).replaceAll("\\{HEIGHT\\}", cx3Var.d).replaceAll("\\{DOWN_X\\}", cx3Var.e).replaceAll("\\{DOWN_Y\\}", cx3Var.f).replaceAll("\\{UP_X\\}", cx3Var.g).replaceAll("\\{UP_Y\\}", cx3Var.h).replaceAll("\\{VIDEO_TIME\\}", cx3Var.i).replaceAll("\\{BEGIN_TIME\\}", cx3Var.j).replaceAll("\\{END_TIME\\}", cx3Var.k).replaceAll("\\{PLAY_FIRST_FRAME\\}", cx3Var.l).replaceAll("\\{PLAY_LAST_FRAME\\}", cx3Var.m).replaceAll("\\{SCENE\\}", cx3Var.n).replaceAll("\\{TYPE\\}", cx3Var.o).replaceAll("\\{BEHAVIOR\\}", cx3Var.p).replaceAll("\\{STATUS\\}", cx3Var.q).replaceAll("\\{CONVERSION_ACTION\\}", cx3Var.r).replaceAll("\\{CLICK_ID\\}", cx3Var.s);
        }
        return (String) invokeLL.objValue;
    }

    public static void e(cx3 cx3Var, AdElementInfo adElementInfo, lw3 lw3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, cx3Var, adElementInfo, lw3Var) != null) || adElementInfo == null) {
            return;
        }
        for (String str : adElementInfo.getConversionUrls()) {
            b(c(str, cx3Var), lw3Var);
        }
    }

    public static void g(cx3 cx3Var, AdElementInfo adElementInfo, lw3 lw3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(65542, null, cx3Var, adElementInfo, lw3Var) != null) || adElementInfo == null) {
            return;
        }
        for (String str : adElementInfo.getCloseTrackers()) {
            b(c(str, cx3Var), lw3Var);
        }
    }
}
