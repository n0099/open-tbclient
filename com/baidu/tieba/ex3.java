package com.baidu.tieba;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.annotation.Singleton;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.searchbox.unitedscheme.SchemeConfig;
import com.baidu.searchbox.unitedscheme.SchemeRouter;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import com.baidu.searchbox.util.BaiduIdentityManager;
import com.baidu.searchbox.yy.gameassist.GameAssistConstKt;
import com.baidu.swan.apps.alliance.login.SwanAppAllianceLoginHelper;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.swan.game.guide.GameGuideConfigInfo;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.tieba.xh4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidubce.AbstractBceClient;
import java.util.List;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONObject;
@Singleton
@Service
/* loaded from: classes5.dex */
public class ex3 extends nu1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.xh4
    public void i(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject) == null) {
        }
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
        }
    }

    /* loaded from: classes5.dex */
    public class a extends ResponseCallback<Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ di4 a;
        public final /* synthetic */ ex3 b;

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onSuccess(Object obj, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj, i) == null) {
            }
        }

        public a(ex3 ex3Var, di4 di4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ex3Var, di4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ex3Var;
            this.a = di4Var;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, exc) != null) {
                return;
            }
            this.b.v();
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public Object parseResponse(Response response, int i) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, response, i)) == null) {
                this.b.x(response, this.a);
                return response;
            }
            return invokeLI.objValue;
        }
    }

    public ex3() {
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

    @Override // com.baidu.tieba.xh4
    public void f(int i, List<di4> list, xh4.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, list, aVar) == null) {
            aVar.a(40);
        }
    }

    @Override // com.baidu.tieba.nu1, com.baidu.tieba.xh4
    public boolean j(di4 di4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, di4Var)) == null) {
            int c = di4Var.c();
            if (c != 40) {
                if (c == 45) {
                    t(di4Var);
                }
            } else {
                u(di4Var);
            }
            return super.j(di4Var);
        }
        return invokeL.booleanValue;
    }

    public void o(List<di4> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048581, this, list) != null) || list == null) {
            return;
        }
        list.add(new di4(40, R.string.obfuscated_res_0x7f0f0121, R.drawable.obfuscated_res_0x7f08010c, true));
    }

    public final void t(di4 di4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048586, this, di4Var) != null) || vb3.b0() == null) {
            return;
        }
        q(di4Var);
    }

    @Override // com.baidu.tieba.nu1, com.baidu.tieba.xh4
    public void d(int i, List<di4> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i, list) == null) {
            super.d(i, list);
            if (i == 12 || i == 15 || i == 17 || i == 18) {
                r(list);
                if (!"wYub6F7RD2tEngaTnOQPBEbYXx5s4Y3y".equals(ub3.K().getAppId()) && !"sc9Tq1iKawTnj5GhG6i77vzeIt4Crt5u".equals(ub3.K().getAppId()) && cv2.L().a()) {
                    o(list);
                }
            }
        }
    }

    @Override // com.baidu.tieba.xh4
    public boolean k(boolean z, int i) {
        InterceptResult invokeCommon;
        vb3 b0;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)})) == null) {
            if (!pp3.Q()) {
                return false;
            }
            Context appContext = AppRuntime.getAppContext();
            if (!b02.y(appContext) || (b0 = vb3.b0()) == null || !b0.N().e(appContext)) {
                return false;
            }
            PMSAppInfo f0 = b0.W().f0();
            if (b0.w0() || f0 == null || TextUtils.isEmpty(f0.paNumber)) {
                return false;
            }
            return true;
        }
        return invokeCommon.booleanValue;
    }

    public final void x(Response response, di4 di4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048590, this, response, di4Var) == null) {
            try {
                if (!response.isSuccessful()) {
                    v();
                    return;
                }
                JSONObject jSONObject = new JSONObject(response.body().string());
                if (!TextUtils.equals(jSONObject.optString("errno"), "0")) {
                    v();
                    return;
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("data");
                if (optJSONObject == null) {
                    v();
                    return;
                }
                Uri p = p(optJSONObject.optString("scheme"));
                if (p == null) {
                    v();
                } else if (SchemeRouter.invokeScheme(AppRuntime.getAppContext(), p, UnitedSchemeConstants.SCHEME_INVOKE_TYPE_INSIDE)) {
                    w(di4Var);
                }
            } catch (Exception unused) {
                v();
            }
        }
    }

    public final Uri p(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            Uri.Builder buildUpon = Uri.parse(str).buildUpon();
            String schemeHead = SchemeConfig.getSchemeHead();
            if (TextUtils.isEmpty(schemeHead)) {
                schemeHead = BaiduIdentityManager.VALUE_OSNAME;
            }
            buildUpon.scheme(schemeHead);
            return buildUpon.build();
        }
        return (Uri) invokeL.objValue;
    }

    public final void r(List<di4> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, list) == null) && list != null && pp3.Q() && b02.y(AppRuntime.getAppContext())) {
            list.add(new di4(45, R.string.obfuscated_res_0x7f0f14ac, R.drawable.obfuscated_res_0x7f0800f9, true));
        }
    }

    public final void u(di4 di4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, di4Var) == null) {
            l13.o("appletCenter");
            yx3.a(SchemeConfig.getSchemeHead() + "://swan/wYub6F7RD2tEngaTnOQPBEbYXx5s4Y3y?_baiduboxapp={\"from\":\"1271009000000000\",\"ext\":{}}&callback=_bdbox_js_275&upgrade=0");
        }
    }

    public final void w(di4 di4Var) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, di4Var) == null) {
            cv2.i().d();
            t13.j(di4Var);
            if (di4Var.e() > 0) {
                i = 1;
            } else {
                i = 0;
            }
            l13.q("customerService", String.valueOf(i), "click");
            t13.i();
        }
    }

    public final void q(di4 di4Var) {
        vb3 b0;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048583, this, di4Var) != null) || (b0 = vb3.b0()) == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        vo3.f(jSONObject, GameGuideConfigInfo.KEY_APP_KEY, b0.getAppId());
        vo3.f(jSONObject, "srcAppPage", v13.b(pp3.n()));
        JSONObject jSONObject2 = new JSONObject();
        vo3.f(jSONObject2, "appKey", "pjwYb22xF6hUcKpZKsiqvnhUhsoUvLfT");
        vo3.f(jSONObject2, "path", "pages/conversation/index");
        vo3.f(jSONObject2, PrefetchEvent.EVENT_DATA_EXTRA_DATA, s(b0));
        vo3.f(jSONObject, "params", jSONObject2);
        String I = cv2.o().I();
        yi4 yi4Var = new yi4(I, new Request.Builder().url(I).post(RequestBody.create(MediaType.parse(AbstractBceClient.DEFAULT_CONTENT_TYPE), jSONObject.toString())).build().body(), new a(this, di4Var));
        yi4Var.f = true;
        yi4Var.g = false;
        yi4Var.h = true;
        zi4.g().e(yi4Var);
    }

    public final JSONObject s(vb3 vb3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, vb3Var)) == null) {
            JSONObject jSONObject = new JSONObject();
            PMSAppInfo f0 = vb3Var.W().f0();
            vo3.f(jSONObject, "appname", f0.appName);
            vo3.f(jSONObject, GameAssistConstKt.KEY_ICONURL, f0.iconUrl);
            vo3.f(jSONObject, BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, f0.appKey);
            vo3.f(jSONObject, "pa", f0.paNumber);
            vo3.f(jSONObject, "isBaiduSeries", Boolean.valueOf(SwanAppAllianceLoginHelper.d.h()));
            vo3.f(jSONObject, "isOpenCustomerService", Boolean.valueOf(pp3.Q()));
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
